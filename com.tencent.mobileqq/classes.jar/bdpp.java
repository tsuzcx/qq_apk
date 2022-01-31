import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bdpp
{
  public static volatile long a;
  
  public static String a(MiniGameInfo paramMiniGameInfo)
  {
    if ((paramMiniGameInfo == null) || (TextUtils.isEmpty(paramMiniGameInfo.gameId))) {
      return "";
    }
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = paramMiniGameInfo.gameId;
    localMiniAppInfo.version = paramMiniGameInfo.version;
    localMiniAppInfo.verType = paramMiniGameInfo.verType;
    localMiniAppInfo.setEngineType(1);
    return bdnx.a(localMiniAppInfo);
  }
  
  private static String a(MiniAppInfo paramMiniAppInfo, bdpy parambdpy, String paramString)
  {
    paramMiniAppInfo = paramMiniAppInfo.subpkgs;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        parambdpy = (SubPkgInfo)paramMiniAppInfo.next();
        if (paramString.equals(parambdpy.subPkgName)) {
          return parambdpy.downloadUrl;
        }
      }
    }
    return null;
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, bdpx parambdpx)
  {
    if (paramMiniAppInfo == null)
    {
      bdnw.d("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (parambdpx != null) {
        parambdpx.a(2002, null, "getGpkgInfoByConfig invalid request, game config null");
      }
      return;
    }
    c(paramMiniAppInfo, parambdpx);
  }
  
  private static void a(MiniAppInfo paramMiniAppInfo, bdpx parambdpx, String paramString)
  {
    if (new File(paramString).exists())
    {
      if (a(paramString))
      {
        bdnw.b("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent success");
        paramMiniAppInfo = bdpy.a(paramString, null, paramMiniAppInfo);
        if (parambdpx != null) {
          parambdpx.a(0, paramMiniAppInfo, "gpkg exist, no need download");
        }
        return;
      }
      bdnw.b("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent failed, delete folder:" + paramString);
      bdgo.a(paramString, false);
      bdnw.b("[minigame] GpkgManager", "[Gpkg] download gpkg by url1:" + paramMiniAppInfo.downloadUrl);
      b(paramMiniAppInfo, parambdpx, paramString);
      return;
    }
    bdnw.b("[minigame] GpkgManager", "[Gpkg] download gpkg by url2:" + paramMiniAppInfo.downloadUrl);
    b(paramMiniAppInfo, parambdpx, paramString);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, bdpy parambdpy, String paramString, bdpx parambdpx)
  {
    String str1 = parambdpy.c(paramString);
    String str2 = a(paramMiniAppInfo, parambdpy, paramString);
    String str3 = bdnx.a(paramMiniAppInfo);
    bdnw.b("[minigame] GpkgManager subpackage", "[Gpkg] downloadSubPack | downPage(subName)=" + paramString + "; subPackDownloadUrl=" + str2 + "; folder:" + str3);
    if (TextUtils.isEmpty(str3)) {
      if (parambdpx != null) {
        parambdpx.a(2007, null, "downloadSubPack but pkg folder not exist");
      }
    }
    do
    {
      return;
      if (!new File(str3, str1).exists()) {
        break;
      }
    } while (parambdpx == null);
    parambdpx.a(0, parambdpy, "downloadSubPack succeed, sub pkg already exist");
    return;
    if (!TextUtils.isEmpty(str2))
    {
      paramString = bdnx.b(paramMiniAppInfo) + File.separator + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".wxapkg";
      bdsu.a(paramMiniAppInfo, 613, "1");
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str2, null, paramString, 60, new bdpu(paramMiniAppInfo, parambdpx, paramString, str1, parambdpy));
      return;
    }
    parambdpx.a(2008, null, "sub pkg download url empty");
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    paramMiniAppInfo = a(new MiniGameInfo(paramMiniAppInfo.appId, paramMiniAppInfo.version, paramMiniAppInfo.verType));
    if (new File(paramMiniAppInfo).exists()) {}
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("offlineResourceReady", paramBoolean);
      localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
      bdgo.c(new File(paramMiniAppInfo, "offlineconfig.json").getAbsolutePath(), (String)localObject);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      paramMiniAppInfo.printStackTrace();
    }
  }
  
  private static void a(MiniGamePluginInfo paramMiniGamePluginInfo, bdpv parambdpv)
  {
    File localFile1 = new File(bdnx.a(paramMiniGamePluginInfo));
    if (localFile1.exists())
    {
      if (new File(localFile1, "plugin.js").exists())
      {
        bdnw.b("[minigame] GpkgManager", "[Gpkg] plugin existed:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
        parambdpv.a(true, null);
        return;
      }
      bdnw.d("[minigame] GpkgManager", "[Gpkg] plugin corrupted:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
    }
    try
    {
      File localFile2 = File.createTempFile("gpkg_plugin_" + paramMiniGamePluginInfo.b, ".wxapkg");
      bdnw.b("[minigame] GpkgManager", "[Gpkg] start download plugin to:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramMiniGamePluginInfo.d, null, localFile2.getAbsolutePath(), 60, new bdpr(paramMiniGamePluginInfo, parambdpv, localFile2, localFile1));
      return;
    }
    catch (IOException paramMiniGamePluginInfo)
    {
      parambdpv.a(false, paramMiniGamePluginInfo);
    }
  }
  
  private static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString + File.separator + "game.js";
      try
      {
        boolean bool = new File(paramString).exists();
        if (bool) {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        bdnw.b("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent error:" + bdyl.a(paramString));
      }
    }
    return false;
  }
  
  public static void b(MiniAppInfo paramMiniAppInfo, bdpx parambdpx)
  {
    bdsu.b(paramMiniAppInfo, 2, "0");
    if (paramMiniAppInfo == null)
    {
      bdnw.d("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (parambdpx != null) {
        parambdpx.a(2002, null, "getGpkgInfoByConfig invalid request, game config null");
      }
      return;
    }
    bdnw.b("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig version:" + paramMiniAppInfo.version + ", appid=" + paramMiniAppInfo.appId + ",size=" + paramMiniAppInfo.fileSize);
    String str = a(new MiniGameInfo(paramMiniAppInfo.appId, paramMiniAppInfo.version, paramMiniAppInfo.verType));
    bdnw.b("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig folderPath:" + str);
    if ((paramMiniAppInfo.verType != 3) && ((!paramMiniAppInfo.isSupportOffline) || (paramMiniAppInfo.launchParam.a == 1011)))
    {
      bdnw.b("[minigame] GpkgManager", "[Gpkg]verType is not online " + paramMiniAppInfo.verType + ", delete path " + str);
      if (new File(str).exists()) {
        bdgo.a(str, false);
      }
    }
    parambdpx = new bdpw(parambdpx);
    a(paramMiniAppInfo, parambdpx, str);
    if (paramMiniAppInfo.miniGamePluginInfo != null)
    {
      a(paramMiniAppInfo.miniGamePluginInfo, parambdpx);
      return;
    }
    bdnw.b("[minigame] GpkgManager", "[Gpkg] game don't have plugin " + paramMiniAppInfo.name + " " + paramMiniAppInfo.appId);
    parambdpx.a(true, null);
  }
  
  private static void b(MiniAppInfo paramMiniAppInfo, bdpx parambdpx, String paramString)
  {
    if (paramMiniAppInfo == null)
    {
      if (parambdpx != null) {
        parambdpx.a(2002, null, "downloadGpkgByResumableDownloader fail invalid params, game config null");
      }
      bdnw.d("[minigame] GpkgManager", "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, game config null");
      return;
    }
    String str2 = bdnx.b(paramMiniAppInfo) + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".wxapkg";
    long l = System.currentTimeMillis();
    String str1;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramMiniAppInfo.firstPage != null)
    {
      str1 = paramMiniAppInfo.firstPage.b;
      if (paramMiniAppInfo.subpkgs != null)
      {
        localObject2 = paramMiniAppInfo.subpkgs.iterator();
        localObject1 = null;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubPkgInfo)((Iterator)localObject2).next();
          if ((localObject3 != null) && (str1 != null) && (str1.equals(((SubPkgInfo)localObject3).subPkgName))) {
            if (((SubPkgInfo)localObject3).independent == 1)
            {
              localObject3 = ((SubPkgInfo)localObject3).downloadUrl;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = paramMiniAppInfo.downloadUrl;
        label194:
        bdnw.b("[minigame] GpkgManager", "[Gpkg]download gpkgUrl=" + (String)localObject1 + " ,subApkUrl=" + (String)localObject2 + " ,independentPath=" + str1 + " ,savePath=" + str2);
        bdsu.a(paramMiniAppInfo, 619, "1");
        ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download((String)localObject1, null, str2, 60, new bdps(paramMiniAppInfo, parambdpx, l, str2, paramString, (String)localObject2, str1));
        return;
        localObject1 = ((SubPkgInfo)localObject3).downloadUrl;
      }
      for (;;)
      {
        break;
        break label194;
      }
      str1 = null;
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      str1 = null;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  private static void b(MiniAppInfo paramMiniAppInfo1, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo2, bdpx parambdpx, String paramString3, String paramString4)
  {
    File localFile = new File(paramString1);
    bdsu.a(paramMiniAppInfo2, 621, "1");
    boolean bool = bdfi.a(localFile.getAbsolutePath(), paramString2);
    int i;
    if (bool)
    {
      i = 0;
      bdsu.a(paramMiniAppInfo2, 622, null, null, null, i, "1", 0L, null);
      bdnw.b("[minigame] GpkgManager", "[Gpkg] handleGpkgDownloadSuccess path:" + paramString1 + ",unpack:" + paramString2 + ",hasUnpack:" + bool);
      if (!bool) {
        break label185;
      }
      paramString1 = bdpy.a(paramString2, paramString4, paramMiniAppInfo2);
      if (paramString3 == null) {
        break label167;
      }
      bdnw.b("[minigame] GpkgManager", "[Gpkg] downloadSubPack after gpk succeed, subApkUrl=" + paramString3);
      a(paramMiniAppInfo1, paramString1, paramString3, new bdpt(parambdpx));
    }
    label167:
    label185:
    do
    {
      do
      {
        return;
        i = 1;
        break;
      } while (parambdpx == null);
      parambdpx.a(0, paramString1, "download pkg and unpack succeed");
      return;
      bdsx.a(paramMiniAppInfo2, "1", null, "page_view", "load_fail", "unpkg_fail", "");
      bdsc.a("2launch_fail", "unpkg_fail", null, paramMiniAppInfo2);
      bdnw.d("[minigame] GpkgManager", "[Gpkg] handleGpkgDownloadSuccess hasUnpack=" + bool);
    } while (parambdpx == null);
    parambdpx.a(2005, null, "download pkg succeed but unpack fail");
  }
  
  private static void c(MiniAppInfo paramMiniAppInfo, bdpx parambdpx)
  {
    b(paramMiniAppInfo, new bdpq(parambdpx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpp
 * JD-Core Version:    0.7.0.1
 */