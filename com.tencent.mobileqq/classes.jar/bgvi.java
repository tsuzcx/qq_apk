import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.ApkgManager.4;
import com.tencent.qqmini.sdk.utils.MD5Utils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class bgvi
{
  public static volatile long a;
  private static volatile bgvi a;
  public static final String a;
  public static final String b = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/mini/";
  private String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/minigame/";
  }
  
  public static bgvi a()
  {
    if (jdField_a_of_type_Bgvi == null) {}
    try
    {
      if (jdField_a_of_type_Bgvi == null) {
        jdField_a_of_type_Bgvi = new bgvi();
      }
      return jdField_a_of_type_Bgvi;
    }
    finally {}
  }
  
  public static String a(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return "";
    }
    if (paramMiniAppInfo.verType == 3) {
      return b(paramMiniAppInfo) + MD5Utils.toMD5(paramMiniAppInfo.appId) + "_" + paramMiniAppInfo.version;
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
    return jdField_a_of_type_JavaLangString + MD5Utils.toMD5(paramMiniGamePluginInfo.id) + "_plugin_" + paramMiniGamePluginInfo.version;
  }
  
  private void a(bgvo parambgvo, int paramInt, bgod parambgod, String paramString)
  {
    QMLog.d("ApkgManager", "onInitApkgInfo :" + paramInt + "|" + paramString);
    if (parambgvo != null) {
      parambgvo.onInitApkgInfo(paramInt, parambgod, paramString);
    }
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    ThreadManager.b().post(new ApkgManager.4(this, paramMiniAppInfo, paramString));
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgvn parambgvn)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    Object localObject = paramMiniAppInfo.version;
    QMLog.d("ApkgManager", "getApkgInfoByConfig version:" + (String)localObject);
    localObject = a(paramMiniAppInfo);
    if (paramMiniAppInfo.verType != 3)
    {
      QMLog.d("ApkgManager", "verType is not online, delete unPackFolderPath." + paramMiniAppInfo.verType);
      if (new File((String)localObject).exists()) {
        bgpc.a((String)localObject, false);
      }
    }
    if (new File((String)localObject).exists())
    {
      localObject = bgod.a((String)localObject, null, paramMiniAppInfo);
      if (parambgvn != null) {
        parambgvn.a((bgod)localObject, 0, "");
      }
      if (paramMiniAppInfo.launchParam != null) {}
      for (parambgvn = paramMiniAppInfo.launchParam.entryPath;; parambgvn = "")
      {
        bhbs.a("cache_apkg_hit", "hit", parambgvn, paramMiniAppInfo);
        return;
      }
    }
    a(paramMiniAppInfo, paramBoolean, parambgvn, (String)localObject);
    if (paramMiniAppInfo.launchParam != null) {}
    for (parambgvn = paramMiniAppInfo.launchParam.entryPath;; parambgvn = "")
    {
      bhbs.a("cache_apkg_hit", "unhit", parambgvn, paramMiniAppInfo);
      return;
    }
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgvn parambgvn, String paramString)
  {
    String str;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramMiniAppInfo.firstPage != null)
    {
      str = paramMiniAppInfo.firstPage.subPkgName;
      localObject2 = paramMiniAppInfo.subpkgs.iterator();
      localObject1 = null;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubPkgInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((SubPkgInfo)localObject3).subPkgName != null) && (str.equals(((SubPkgInfo)localObject3).subPkgName))) {
          if (((SubPkgInfo)localObject3).independent == 1)
          {
            localObject3 = ((SubPkgInfo)localObject3).downloadUrl;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = paramMiniAppInfo.downloadUrl;
      }
      a(paramMiniAppInfo, paramBoolean, parambgvn, paramString, (String)localObject3, (String)localObject2, str);
      return;
      localObject1 = paramMiniAppInfo.firstPage.pagePath;
      for (;;)
      {
        break;
      }
      str = null;
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      str = null;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgvn parambgvn, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = b + File.separator + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".qapkg";
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString2)) {
      if (parambgvn != null)
      {
        parambgvn.a(null, 1, "apkUrl is Null!");
        QMLog.e("ApkgManager", "downloadApkgByResumableDownloader apkUrl is null!");
      }
    }
    do
    {
      return;
      bhck.a(paramMiniAppInfo, 619, "0");
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString2, null, str, 60, new bgvk(this, parambgvn, str, paramString1, paramMiniAppInfo, paramString3, paramString4, l));
    } while (!paramBoolean);
    a(paramMiniAppInfo, paramString1);
  }
  
  private void a(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, String paramString4, bgvn parambgvn)
  {
    bhck.a(paramMiniAppInfo, 621, "0");
    boolean bool = bgoa.a(new File(paramString1).getAbsolutePath(), paramString2);
    int i;
    if (bool)
    {
      i = 0;
      bhck.a(paramMiniAppInfo, 622, null, null, null, i);
      if (!bool) {
        break label111;
      }
      paramString1 = bgod.a(paramString2, paramString4, paramMiniAppInfo);
      if ((paramString3 == null) || (paramString1 == null)) {
        break label94;
      }
      a(paramString1, paramMiniAppInfo, paramString3, new bgvl(this, parambgvn));
    }
    label94:
    label111:
    while (parambgvn == null)
    {
      do
      {
        return;
        i = 1;
        break;
      } while (parambgvn == null);
      parambgvn.a(paramString1, 0, "");
      return;
    }
    parambgvn.a(null, 3, "解包失败");
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
  
  public void a(bgod parambgod, MiniAppInfo paramMiniAppInfo, String paramString, bgvo parambgvo)
  {
    String str2 = a(paramMiniAppInfo);
    String str1;
    if ("/__APP__/".equals(paramString))
    {
      this.c = "";
      str1 = paramMiniAppInfo.downloadUrl;
      QMLog.d("ApkgManager", "downloadSubPack | downPage=" + paramString + "; subPackDownloadUrl=" + str1);
      if (!TextUtils.isEmpty(str1)) {
        break label119;
      }
      QMLog.e("ApkgManager", "subPackDownloadUrl is null, return.");
      if (parambgvo != null) {
        parambgvo.onInitApkgInfo(1, parambgod, null);
      }
    }
    label119:
    do
    {
      return;
      this.c = parambgod.getRootPath(paramString);
      str1 = a(paramMiniAppInfo, this.c);
      break;
      if (("/__APP__/".equals(paramString)) || (!new File(str2, this.c).exists())) {
        break label164;
      }
    } while (parambgvo == null);
    parambgvo.onInitApkgInfo(0, parambgod, null);
    return;
    label164:
    if (!TextUtils.isEmpty(str1))
    {
      str2 = b + File.separator + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".qapkg";
      bhck.a(paramMiniAppInfo, 613, paramString, null, null, 0, "0", 0L, null);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str1, null, str2, 60, new bgvm(this, parambgvo, parambgod, paramMiniAppInfo, paramString, str2));
      return;
    }
    parambgvo.onInitApkgInfo(1, parambgod, null);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, bgvo parambgvo)
  {
    a(paramMiniAppInfo, true, parambgvo);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgvo parambgvo)
  {
    long l = System.currentTimeMillis();
    bhck.a(paramMiniAppInfo, 12, null, null, null, 0);
    a(paramMiniAppInfo, paramBoolean, new bgvj(this, parambgvo, l, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvi
 * JD-Core Version:    0.7.0.1
 */