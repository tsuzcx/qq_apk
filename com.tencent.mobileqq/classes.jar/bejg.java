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

public class bejg
{
  private static volatile bejg jdField_a_of_type_Bejg;
  public static final String a;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final String b = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/mini/";
  public static final String c = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/mini_tissue/";
  
  static
  {
    jdField_a_of_type_JavaLangString = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/minigame/";
  }
  
  public static bejg a()
  {
    if (jdField_a_of_type_Bejg == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bejg == null) {
        jdField_a_of_type_Bejg = new bejg();
      }
      return jdField_a_of_type_Bejg;
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
      return b(paramMiniAppBaseInfo, paramBoolean) + bfgt.c(paramMiniAppBaseInfo.appId) + "_" + paramMiniAppBaseInfo.version;
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
  
  public void a(Context paramContext, boolean paramBoolean, MiniAppBaseInfo paramMiniAppBaseInfo, bejj parambejj)
  {
    if (paramBoolean) {}
    do
    {
      try
      {
        paramContext = a(paramMiniAppBaseInfo, paramBoolean) + "_maintmp";
        if (new File(paramContext).exists())
        {
          localObject = bekp.a(paramContext, null, paramMiniAppBaseInfo);
          if (localObject != null)
          {
            betc.b("ApkgManager", "apkg has download in main process. folder:" + paramContext);
            beys.d(paramMiniAppBaseInfo.appId, true);
            if (parambejj != null) {
              parambejj.a((bekp)localObject, 0, "加载成功");
            }
          }
          return;
        }
      }
      catch (Throwable paramContext)
      {
        betc.d("ApkgManager", "", paramContext);
      }
      paramContext = a(paramMiniAppBaseInfo, paramBoolean);
      if (!new File(paramContext).exists()) {
        break;
      }
      betc.d("ApkgManager", "startLoadApkg");
      paramContext = bekp.a(paramContext, null, paramMiniAppBaseInfo);
      betc.d("ApkgManager", "endLoadApkg");
      if (paramContext == null) {
        break;
      }
      beys.d(paramMiniAppBaseInfo.appId, true);
    } while (parambejj == null);
    parambejj.a(paramContext, 0, "");
    return;
    beys.d(paramMiniAppBaseInfo.appId, false);
    paramContext = new DownloaderProxyDefault();
    Object localObject = b(paramMiniAppBaseInfo);
    paramContext.download(paramMiniAppBaseInfo.downloadUrl, null, (String)localObject, 20, new bejh(this, parambejj, paramMiniAppBaseInfo, paramBoolean));
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString, bejj parambejj)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramString))) {
      if (parambejj != null) {
        parambejj.a(null, -1, "参数错误");
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
        if (parambejj == null) {
          break;
        }
        parambejj.a(null, -1, "下载链接错误");
        return;
        str2 = paramMiniAppInfo.apkgInfo.c(paramString);
        str1 = a(paramMiniAppInfo, str2);
      }
      if (("/__APP__/".equals(paramString)) || (!new File(str3, str2).exists())) {
        break;
      }
    } while (parambejj == null);
    parambejj.a((bekp)paramMiniAppInfo.apkgInfo, 0, null);
    return;
    new DownloaderProxyDefault().download(str1, null, b(paramMiniAppInfo, str2), 20, new beji(this, paramMiniAppInfo, str2, parambejj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejg
 * JD-Core Version:    0.7.0.1
 */