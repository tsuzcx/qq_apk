import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class beip
{
  private static volatile beip jdField_a_of_type_Beip;
  public static final String a;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final String b = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/mini/";
  public static final String c = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/mini_tissue/";
  
  static
  {
    jdField_a_of_type_JavaLangString = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/minigame/";
  }
  
  public static beip a()
  {
    if (jdField_a_of_type_Beip == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Beip == null) {
        jdField_a_of_type_Beip = new beip();
      }
      return jdField_a_of_type_Beip;
    }
  }
  
  public static String a(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    return b(paramMiniAppBaseInfo, false);
  }
  
  private String a(MiniAppBaseInfo paramMiniAppBaseInfo, String paramString)
  {
    paramMiniAppBaseInfo = paramMiniAppBaseInfo.subpkgs;
    if ((paramMiniAppBaseInfo != null) && (paramMiniAppBaseInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppBaseInfo = paramMiniAppBaseInfo.iterator();
      while (paramMiniAppBaseInfo.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramMiniAppBaseInfo.next();
        if (paramString.equals(localSubPkgInfo.subPkgName)) {
          return localSubPkgInfo.downloadUrl;
        }
      }
    }
    return null;
  }
  
  public static String a(MiniAppBaseInfo paramMiniAppBaseInfo, boolean paramBoolean)
  {
    if ((paramMiniAppBaseInfo == null) || (TextUtils.isEmpty(paramMiniAppBaseInfo.appId))) {
      return "";
    }
    if (paramMiniAppBaseInfo.verType == 3) {
      return b(paramMiniAppBaseInfo, paramBoolean) + bfgc.c(paramMiniAppBaseInfo.appId) + "_" + paramMiniAppBaseInfo.version;
    }
    return b(paramMiniAppBaseInfo, paramBoolean) + paramMiniAppBaseInfo.appId + "_debug";
  }
  
  private String b(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    return a(paramMiniAppBaseInfo) + "apkg/" + paramMiniAppBaseInfo.appId + "_" + paramMiniAppBaseInfo.version + ".qapkg";
  }
  
  private String b(MiniAppBaseInfo paramMiniAppBaseInfo, String paramString)
  {
    return a(paramMiniAppBaseInfo) + "apkg/" + paramString + "_" + paramMiniAppBaseInfo.appId + "_" + paramMiniAppBaseInfo.version + ".qapkg";
  }
  
  public static String b(MiniAppBaseInfo paramMiniAppBaseInfo, boolean paramBoolean)
  {
    if (paramMiniAppBaseInfo.isEngineTypeMiniGame()) {
      return jdField_a_of_type_JavaLangString;
    }
    if ((paramBoolean) && (paramMiniAppBaseInfo.supportNativeRenderMode())) {
      return c;
    }
    return b;
  }
  
  public void a(Context paramContext, boolean paramBoolean, MiniAppBaseInfo paramMiniAppBaseInfo, beis parambeis)
  {
    if (paramBoolean) {}
    do
    {
      try
      {
        paramContext = a(paramMiniAppBaseInfo, paramBoolean) + "_maintmp";
        if (new File(paramContext).exists())
        {
          localObject = bejy.a(paramContext, null, paramMiniAppBaseInfo);
          if (localObject != null)
          {
            besl.b("ApkgManager", "apkg has download in main process. folder:" + paramContext);
            if (parambeis != null) {
              parambeis.a((bejy)localObject, 0, "加载成功");
            }
          }
          return;
        }
      }
      catch (Throwable paramContext)
      {
        besl.d("ApkgManager", "", paramContext);
      }
      paramContext = a(paramMiniAppBaseInfo, paramBoolean);
      if (!new File(paramContext).exists()) {
        break;
      }
      besl.d("ApkgManager", "startLoadApkg");
      paramContext = bejy.a(paramContext, null, paramMiniAppBaseInfo);
      besl.d("ApkgManager", "endLoadApkg");
      if (paramContext == null) {
        break;
      }
    } while (parambeis == null);
    parambeis.a(paramContext, 0, "");
    return;
    paramContext = new DownloaderProxyDefault();
    Object localObject = b(paramMiniAppBaseInfo);
    paramContext.download(paramMiniAppBaseInfo.downloadUrl, null, (String)localObject, 20, new beiq(this, parambeis, paramMiniAppBaseInfo, paramBoolean));
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString, beis parambeis)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramString))) {
      if (parambeis != null) {
        parambeis.a(null, -1, "参数错误");
      }
    }
    String str1;
    String str2;
    label97:
    do
    {
      return;
      String str3 = a(paramMiniAppInfo, false);
      if ("/__APP__/".equals(paramString))
      {
        str1 = paramMiniAppInfo.downloadUrl;
        str2 = "";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str1)) {
          break label97;
        }
        if (parambeis == null) {
          break;
        }
        parambeis.a(null, -1, "下载链接错误");
        return;
        str2 = paramMiniAppInfo.apkgInfo.c(paramString);
        str1 = a(paramMiniAppInfo, str2);
      }
      if (("/__APP__/".equals(paramString)) || (!new File(str3, str2).exists())) {
        break;
      }
    } while (parambeis == null);
    parambeis.a((bejy)paramMiniAppInfo.apkgInfo, 0, null);
    return;
    new DownloaderProxyDefault().download(str1, null, b(paramMiniAppInfo, str2), 20, new beir(this, paramMiniAppInfo, str2, parambeis));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beip
 * JD-Core Version:    0.7.0.1
 */