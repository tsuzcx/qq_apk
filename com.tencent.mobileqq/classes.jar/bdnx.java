import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class bdnx
{
  private static volatile bdnx a;
  public static final String a;
  public static final String b = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/mini/";
  private String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/minigame/";
  }
  
  public static bdnx a()
  {
    if (jdField_a_of_type_Bdnx == null) {}
    try
    {
      if (jdField_a_of_type_Bdnx == null) {
        jdField_a_of_type_Bdnx = new bdnx();
      }
      return jdField_a_of_type_Bdnx;
    }
    finally {}
  }
  
  public static String a(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return "";
    }
    if (paramMiniAppInfo.verType == 3) {
      return b(paramMiniAppInfo) + bdyv.c(paramMiniAppInfo.appId) + "_" + paramMiniAppInfo.version;
    }
    return b(paramMiniAppInfo) + paramMiniAppInfo.appId + "_debug";
  }
  
  private String a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    paramMiniAppInfo = paramMiniAppInfo.subpkgs;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramMiniAppInfo.next();
        if (paramString.equals(localSubPkgInfo.subPkgName)) {
          return localSubPkgInfo.downloadUrl;
        }
      }
    }
    return null;
  }
  
  public static String a(MiniGamePluginInfo paramMiniGamePluginInfo)
  {
    return jdField_a_of_type_JavaLangString + bdyv.c(paramMiniGamePluginInfo.b) + "_plugin_" + paramMiniGamePluginInfo.c;
  }
  
  public static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    return new File(a(paramMiniAppInfo)).exists();
  }
  
  public static String b(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      return jdField_a_of_type_JavaLangString;
    }
    return b;
  }
  
  public void a(bdfx parambdfx, MiniAppInfo paramMiniAppInfo, String paramString, bdnz parambdnz)
  {
    String str2 = a(paramMiniAppInfo);
    String str1;
    if ("/__APP__/".equals(paramString))
    {
      this.c = "";
      str1 = paramMiniAppInfo.downloadUrl;
      bdnw.a("ApkgManager", "downloadSubPack | downPage=" + paramString + "; subPackDownloadUrl=" + str1);
      if (!TextUtils.isEmpty(str1)) {
        break label115;
      }
      bdnw.d("ApkgManager", "subPackDownloadUrl is null, return.");
      if (parambdnz != null) {
        parambdnz.onInitApkgInfo(1, parambdfx, null);
      }
    }
    label115:
    do
    {
      return;
      this.c = parambdfx.c(paramString);
      str1 = a(paramMiniAppInfo, this.c);
      break;
      if (("/__APP__/".equals(paramString)) || (!new File(str2, this.c).exists())) {
        break label159;
      }
    } while (parambdnz == null);
    parambdnz.onInitApkgInfo(0, parambdfx, null);
    return;
    label159:
    if (!TextUtils.isEmpty(str1))
    {
      str2 = b + File.separator + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".qapkg";
      bdsu.a(paramMiniAppInfo, 613, paramString, null, null, 0, "0", 0L, null);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str1, null, str2, 60, new bdny(this, parambdnz, parambdfx, paramMiniAppInfo, paramString, str2));
      return;
    }
    parambdnz.onInitApkgInfo(1, parambdfx, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdnx
 * JD-Core Version:    0.7.0.1
 */