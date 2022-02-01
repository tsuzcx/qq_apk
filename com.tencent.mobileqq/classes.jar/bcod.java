import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.RelatedFileInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class bcod
{
  private static Map<String, SharedPreferences> a = new HashMap();
  
  public static long a()
  {
    return a("dynamic_so_load").getLong("key_last_rsp_time", 0L);
  }
  
  private static SharedPreferences a(String paramString)
  {
    SharedPreferences localSharedPreferences2 = (SharedPreferences)a.get(paramString);
    SharedPreferences localSharedPreferences1 = localSharedPreferences2;
    if (localSharedPreferences2 == null)
    {
      localSharedPreferences1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 4);
      a.put(paramString, localSharedPreferences1);
    }
    return localSharedPreferences1;
  }
  
  static bcoc a(String paramString)
  {
    return bcoc.a(a("so_crash").getString(b(paramString), ""));
  }
  
  static bcoc a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if ((paramString1 != null) && (paramString1.jdField_a_of_type_JavaLangString.equals(paramString2))) {
      return paramString1;
    }
    return null;
  }
  
  static bcoq a(LoadParam.LoadItem paramLoadItem, @NonNull SoConfig.SoDetailInfo paramSoDetailInfo)
  {
    try
    {
      paramLoadItem = bcoq.a(a("dynamic_so_load").getString(a(paramLoadItem.name), ""));
      boolean bool = a(paramLoadItem, paramSoDetailInfo);
      if (bool) {
        return paramLoadItem;
      }
    }
    catch (Throwable paramLoadItem)
    {
      QLog.e("SoLoadWidget.SoDataUtil", 1, paramLoadItem, new Object[0]);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalInfoFromCache] no cache, use default!");
      }
    }
    return new bcoq();
  }
  
  private static String a()
  {
    if (bcoe.a()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
  
  static String a(LoadParam.LoadItem paramLoadItem)
  {
    try
    {
      paramLoadItem = a("dynamic_so_load").getString("key_last_succ_" + paramLoadItem.name + a(), "");
      return paramLoadItem;
    }
    catch (Throwable paramLoadItem)
    {
      paramLoadItem.printStackTrace();
    }
    return "";
  }
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("key_local_info_").append(paramString);
    if (!bcoe.a()) {}
    for (paramString = "_32";; paramString = "_64") {
      return paramString;
    }
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = a("dynamic_so_load");
    long l = NetConnInfoCenter.getServerTimeMillis();
    localSharedPreferences.edit().putLong("key_last_rsp_time", l).apply();
  }
  
  static void a(bcoc parambcoc, String paramString)
  {
    SharedPreferences localSharedPreferences = a("so_crash");
    paramString = b(paramString);
    localSharedPreferences.edit().putString(paramString, parambcoc.a()).commit();
  }
  
  static void a(LoadParam.LoadItem paramLoadItem, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = a("dynamic_so_load");
        String str1 = a(paramLoadItem.name);
        bcoq localbcoq = a(paramLoadItem, paramSoLoadInfo.soDetailInfo);
        localObject = paramSoLoadInfo.soDetailInfo.relatedFileInfo;
        boolean bool1 = a(localbcoq, paramSoLoadInfo);
        boolean bool2 = a(localbcoq, paramSoLoadInfo, (SoConfig.RelatedFileInfo)localObject);
        if ((bool1) && (bool2)) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.SoDataUtil", 2, "[saveLocalInfo] need cal crc or save!");
        }
        String str2 = paramSoLoadInfo.soDetailInfo.url;
        if (localObject != null)
        {
          localObject = ((SoConfig.RelatedFileInfo)localObject).url;
          if (!bool1) {
            break label173;
          }
          l = localbcoq.jdField_a_of_type_Long;
          paramLoadItem = new bcoq(paramSoLoadInfo.getVer(), paramLoadItem.name, paramSoLoadInfo.soPathToLoad, l, str2, (String)localObject, paramSoLoadInfo.rFileFolder);
          localSharedPreferences.edit().putString(str1, paramLoadItem.a()).commit();
          return;
        }
      }
      catch (Throwable paramLoadItem)
      {
        paramLoadItem.printStackTrace();
        return;
      }
      Object localObject = null;
      continue;
      label173:
      long l = IOUtil.getCRC32Value(new File(paramSoLoadInfo.soPathToLoad));
    }
  }
  
  static void a(LoadParam.LoadItem paramLoadItem, String paramString)
  {
    try
    {
      a("dynamic_so_load").edit().putString("key_last_succ_" + paramLoadItem.name + a(), paramString).apply();
      return;
    }
    catch (Throwable paramLoadItem)
    {
      paramLoadItem.printStackTrace();
    }
  }
  
  static void a(String paramString)
  {
    bcoc localbcoc = a(paramString);
    if (localbcoc != null)
    {
      localbcoc.jdField_a_of_type_Int = 0;
      localbcoc.jdField_a_of_type_Long = 0L;
      a(localbcoc, paramString);
    }
  }
  
  private static boolean a(@NonNull bcoq parambcoq, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    return (TextUtils.equals(parambcoq.c, paramSoLoadInfo.soPathToLoad)) && (parambcoq.jdField_a_of_type_Long != -1L);
  }
  
  private static boolean a(@NonNull bcoq parambcoq, @NonNull SoLoadInfo paramSoLoadInfo, SoConfig.RelatedFileInfo paramRelatedFileInfo)
  {
    return (paramRelatedFileInfo == null) || (TextUtils.equals(parambcoq.f, paramSoLoadInfo.rFileFolder));
  }
  
  private static boolean a(@NonNull bcoq parambcoq, @NonNull SoConfig.SoDetailInfo paramSoDetailInfo)
  {
    if (!TextUtils.equals(paramSoDetailInfo.url, parambcoq.d)) {}
    while ((paramSoDetailInfo.relatedFileInfo != null) && (!TextUtils.equals(paramSoDetailInfo.relatedFileInfo.url, parambcoq.e))) {
      return false;
    }
    return true;
  }
  
  static bcoq b(LoadParam.LoadItem paramLoadItem, @NonNull SoConfig.SoDetailInfo paramSoDetailInfo)
  {
    Object localObject1 = null;
    bcoq localbcoq = a(paramLoadItem, paramSoDetailInfo);
    Object localObject2 = localbcoq.c;
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
    {
      localObject2 = new DownloadParam();
      ((DownloadParam)localObject2).filePos = 1;
      ((DownloadParam)localObject2).url = paramSoDetailInfo.url;
      ((DownloadParam)localObject2).md5ForChecked = paramSoDetailInfo.md5;
      localObject2 = PreloadManager.a((DownloadParam)localObject2);
      if ((localObject2 == null) || (((PreloadManager.PathResult)localObject2).folderPath == null)) {
        break label270;
      }
    }
    label270:
    for (paramLoadItem = new File(((PreloadManager.PathResult)localObject2).folderPath, paramLoadItem.soFileName).getAbsolutePath();; paramLoadItem = null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalxxConfig] try get so from sync method");
      }
      localbcoq.c = paramLoadItem;
      localbcoq.jdField_a_of_type_Long = -1L;
      if (paramSoDetailInfo.relatedFileInfo != null)
      {
        paramLoadItem = localbcoq.f;
        if ((TextUtils.isEmpty(paramLoadItem)) || (!new File(paramLoadItem).exists()))
        {
          paramLoadItem = new DownloadParam();
          paramLoadItem.filePos = 1;
          paramLoadItem.url = paramSoDetailInfo.relatedFileInfo.url;
          paramLoadItem.md5ForChecked = paramSoDetailInfo.relatedFileInfo.md5;
          paramSoDetailInfo = PreloadManager.a(paramLoadItem);
          paramLoadItem = localObject1;
          if (paramSoDetailInfo != null)
          {
            paramLoadItem = localObject1;
            if (!TextUtils.isEmpty(paramSoDetailInfo.folderPath)) {
              paramLoadItem = paramSoDetailInfo.folderPath;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalxxConfig] try get rPath from sync method");
          }
          localbcoq.f = paramLoadItem;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoDataUtil", 2, "[getLocalInfoFromCacheOrConfig] return info from cache");
      }
      return localbcoq;
    }
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("key_crash_info_").append(paramString);
    if (!bcoe.a()) {}
    for (paramString = "_32";; paramString = "_64") {
      return paramString;
    }
  }
  
  public static void b(String paramString)
  {
    bcoc localbcoc = a(paramString);
    if ((localbcoc != null) && (!localbcoc.b()))
    {
      localbcoc.b = 0L;
      a(localbcoc, paramString);
    }
  }
  
  static void c(String paramString)
  {
    SharedPreferences localSharedPreferences = a("dynamic_so_load");
    paramString = a(paramString);
    localSharedPreferences.edit().remove(paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcod
 * JD-Core Version:    0.7.0.1
 */