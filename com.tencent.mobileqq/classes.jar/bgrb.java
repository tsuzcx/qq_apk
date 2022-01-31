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

public class bgrb
{
  public static volatile long a;
  private static volatile bgrb a;
  public static final String a;
  public static final String b = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/mini/";
  private String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/minigame/";
  }
  
  public static bgrb a()
  {
    if (jdField_a_of_type_Bgrb == null) {}
    try
    {
      if (jdField_a_of_type_Bgrb == null) {
        jdField_a_of_type_Bgrb = new bgrb();
      }
      return jdField_a_of_type_Bgrb;
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
  
  private void a(bgrh parambgrh, int paramInt, bgjw parambgjw, String paramString)
  {
    QMLog.d("ApkgManager", "onInitApkgInfo :" + paramInt + "|" + paramString);
    if (parambgrh != null) {
      parambgrh.onInitApkgInfo(paramInt, parambgjw, paramString);
    }
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    ThreadManager.b().post(new ApkgManager.4(this, paramMiniAppInfo, paramString));
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgrg parambgrg)
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
        bgkv.a((String)localObject, false);
      }
    }
    if (new File((String)localObject).exists())
    {
      localObject = bgjw.a((String)localObject, null, paramMiniAppInfo);
      if (parambgrg != null) {
        parambgrg.a((bgjw)localObject, 0, "");
      }
      if (paramMiniAppInfo.launchParam != null) {}
      for (parambgrg = paramMiniAppInfo.launchParam.entryPath;; parambgrg = "")
      {
        bgxl.a("cache_apkg_hit", "hit", parambgrg, paramMiniAppInfo);
        return;
      }
    }
    a(paramMiniAppInfo, paramBoolean, parambgrg, (String)localObject);
    if (paramMiniAppInfo.launchParam != null) {}
    for (parambgrg = paramMiniAppInfo.launchParam.entryPath;; parambgrg = "")
    {
      bgxl.a("cache_apkg_hit", "unhit", parambgrg, paramMiniAppInfo);
      return;
    }
  }
  
  private void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgrg parambgrg, String paramString)
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
      a(paramMiniAppInfo, paramBoolean, parambgrg, paramString, (String)localObject3, (String)localObject2, str);
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
  
  private void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgrg parambgrg, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = b + File.separator + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".qapkg";
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString2)) {
      if (parambgrg != null)
      {
        parambgrg.a(null, 1, "apkUrl is Null!");
        QMLog.e("ApkgManager", "downloadApkgByResumableDownloader apkUrl is null!");
      }
    }
    do
    {
      return;
      bgyd.a(paramMiniAppInfo, 619, "0");
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString2, null, str, 60, new bgrd(this, parambgrg, str, paramString1, paramMiniAppInfo, paramString3, paramString4, l));
    } while (!paramBoolean);
    a(paramMiniAppInfo, paramString1);
  }
  
  private void a(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, String paramString4, bgrg parambgrg)
  {
    bgyd.a(paramMiniAppInfo, 621, "0");
    boolean bool = bgjt.a(new File(paramString1).getAbsolutePath(), paramString2);
    int i;
    if (bool)
    {
      i = 0;
      bgyd.a(paramMiniAppInfo, 622, null, null, null, i);
      if (!bool) {
        break label111;
      }
      paramString1 = bgjw.a(paramString2, paramString4, paramMiniAppInfo);
      if ((paramString3 == null) || (paramString1 == null)) {
        break label94;
      }
      a(paramString1, paramMiniAppInfo, paramString3, new bgre(this, parambgrg));
    }
    label94:
    label111:
    while (parambgrg == null)
    {
      do
      {
        return;
        i = 1;
        break;
      } while (parambgrg == null);
      parambgrg.a(paramString1, 0, "");
      return;
    }
    parambgrg.a(null, 3, "解包失败");
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
  
  public void a(bgjw parambgjw, MiniAppInfo paramMiniAppInfo, String paramString, bgrh parambgrh)
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
      if (parambgrh != null) {
        parambgrh.onInitApkgInfo(1, parambgjw, null);
      }
    }
    label119:
    do
    {
      return;
      this.c = parambgjw.getRootPath(paramString);
      str1 = a(paramMiniAppInfo, this.c);
      break;
      if (("/__APP__/".equals(paramString)) || (!new File(str2, this.c).exists())) {
        break label164;
      }
    } while (parambgrh == null);
    parambgrh.onInitApkgInfo(0, parambgjw, null);
    return;
    label164:
    if (!TextUtils.isEmpty(str1))
    {
      str2 = b + File.separator + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".qapkg";
      bgyd.a(paramMiniAppInfo, 613, paramString, null, null, 0, "0", 0L, null);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str1, null, str2, 60, new bgrf(this, parambgrh, parambgjw, paramMiniAppInfo, paramString, str2));
      return;
    }
    parambgrh.onInitApkgInfo(1, parambgjw, null);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, bgrh parambgrh)
  {
    a(paramMiniAppInfo, true, parambgrh);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, bgrh parambgrh)
  {
    long l = System.currentTimeMillis();
    bgyd.a(paramMiniAppInfo, 12, null, null, null, 0);
    a(paramMiniAppInfo, paramBoolean, new bgrc(this, parambgrh, l, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrb
 * JD-Core Version:    0.7.0.1
 */