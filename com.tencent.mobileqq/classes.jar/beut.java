import android.text.TextUtils;
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

public class beut
{
  public static volatile long a;
  
  private static SubPkgInfo a(MiniAppInfo paramMiniAppInfo, bevc parambevc, String paramString)
  {
    paramMiniAppInfo = paramMiniAppInfo.subpkgs;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        parambevc = (SubPkgInfo)paramMiniAppInfo.next();
        if (paramString.equals(parambevc.subPkgName)) {
          return parambevc;
        }
      }
    }
    return null;
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, bevb parambevb)
  {
    if (paramMiniAppInfo == null)
    {
      besl.d("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (parambevb != null) {
        parambevb.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null");
      }
      return;
    }
    c(paramMiniAppInfo, parambevb);
  }
  
  private static void a(MiniAppInfo paramMiniAppInfo, bevb parambevb, String paramString)
  {
    if (new File(paramString).exists())
    {
      if (b(paramString))
      {
        besl.b("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent success");
        paramMiniAppInfo = bevc.a(paramString, null, paramMiniAppInfo);
        if (parambevb != null) {
          parambevb.onInitGpkgInfo(0, paramMiniAppInfo, "gpkg exist, no need download");
        }
        return;
      }
      besl.b("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent failed, delete folder:" + paramString);
      bekq.a(paramString, false);
      besl.b("[minigame] GpkgManager", "[Gpkg] download gpkg by url1:" + paramMiniAppInfo.downloadUrl);
      b(paramMiniAppInfo, parambevb, paramString);
      return;
    }
    besl.b("[minigame] GpkgManager", "[Gpkg] download gpkg by url2:" + paramMiniAppInfo.downloadUrl);
    b(paramMiniAppInfo, parambevb, paramString);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, bevc parambevc, String paramString, bevb parambevb)
  {
    String str2 = parambevc.c(paramString);
    SubPkgInfo localSubPkgInfo = a(paramMiniAppInfo, parambevc, paramString);
    String str1;
    String str3;
    int i;
    if (localSubPkgInfo != null)
    {
      str1 = localSubPkgInfo.downloadUrl;
      str3 = besm.a(paramMiniAppInfo);
      if (localSubPkgInfo == null) {
        break label130;
      }
      i = localSubPkgInfo.fileSize;
      label45:
      besl.b("[minigame] GpkgManager subpackage", "[Gpkg] downloadSubPack | downPage(subName)=" + paramString + "; subPackDownloadUrl=" + str1 + "; folder:" + str3 + "; fileSize:" + i);
      if (!TextUtils.isEmpty(str3)) {
        break label136;
      }
      if (parambevb != null) {
        parambevb.onInitGpkgInfo(2007, null, "downloadSubPack but pkg folder not exist");
      }
    }
    label130:
    label136:
    do
    {
      return;
      str1 = null;
      break;
      i = -1;
      break label45;
      if (!new File(str3, str2).exists()) {
        break label168;
      }
    } while (parambevb == null);
    parambevb.onInitGpkgInfo(0, parambevc, "downloadSubPack succeed, sub pkg already exist");
    return;
    label168:
    if (!TextUtils.isEmpty(str1))
    {
      paramString = besm.b(paramMiniAppInfo) + File.separator + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + "_" + System.nanoTime() + ".wxapkg";
      beyr.a(paramMiniAppInfo, 613, "1");
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str1, null, paramString, 60, new beuy(paramMiniAppInfo, parambevb, paramString, str2, parambevc, i));
      return;
    }
    parambevb.onInitGpkgInfo(2008, null, "sub pkg download url empty");
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return;
      paramMiniAppInfo = besm.a(paramMiniAppInfo);
    } while (!new File(paramMiniAppInfo).exists());
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("offlineResourceReady", paramBoolean);
      localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
      bekq.c(new File(paramMiniAppInfo, "offlineconfig.json").getAbsolutePath(), (String)localObject);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      paramMiniAppInfo.printStackTrace();
    }
  }
  
  private static void a(MiniGamePluginInfo paramMiniGamePluginInfo, beuz parambeuz)
  {
    File localFile1 = new File(besm.a(paramMiniGamePluginInfo));
    if (localFile1.exists())
    {
      if (new File(localFile1, "plugin.js").exists())
      {
        besl.b("[minigame] GpkgManager", "[Gpkg] plugin existed:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
        parambeuz.a(true, null);
        return;
      }
      besl.d("[minigame] GpkgManager", "[Gpkg] plugin corrupted:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
    }
    try
    {
      File localFile2 = File.createTempFile("gpkg_plugin_" + paramMiniGamePluginInfo.b, ".wxapkg");
      besl.b("[minigame] GpkgManager", "[Gpkg] start download plugin to:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramMiniGamePluginInfo.d, null, localFile2.getAbsolutePath(), 60, new beuv(paramMiniGamePluginInfo, parambeuz, localFile2, localFile1));
      return;
    }
    catch (IOException paramMiniGamePluginInfo)
    {
      parambeuz.a(false, paramMiniGamePluginInfo);
    }
  }
  
  public static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return false;
      paramMiniAppInfo = besm.a(paramMiniAppInfo);
    } while ((!new File(paramMiniAppInfo).exists()) || (!b(paramMiniAppInfo)));
    return a(paramMiniAppInfo);
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString + File.separator + "offlineconfig.json";
    }
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists())
      {
        paramString = bekq.b(paramString);
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString)) {
          bool1 = new JSONObject(paramString).optBoolean("offlineResourceReady", false);
        }
      }
      return bool1;
    }
    catch (Throwable paramString)
    {
      besl.b("[minigame] GpkgManager", "[Gpkg] checkOfflineResourceContent error:" + bffr.a(paramString));
    }
    return false;
  }
  
  public static void b(MiniAppInfo paramMiniAppInfo, bevb parambevb)
  {
    beyr.b(paramMiniAppInfo, 2, "0");
    if (paramMiniAppInfo == null)
    {
      besl.d("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (parambevb != null) {
        parambevb.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null");
      }
      return;
    }
    besl.b("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig version:" + paramMiniAppInfo.version + ", appid=" + paramMiniAppInfo.appId + ",size=" + paramMiniAppInfo.fileSize);
    String str = besm.a(paramMiniAppInfo);
    besl.b("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig folderPath:" + str);
    if ((paramMiniAppInfo.verType != 3) && ((!paramMiniAppInfo.isSupportOffline) || (paramMiniAppInfo.launchParam.a == 1011)))
    {
      besl.b("[minigame] GpkgManager", "[Gpkg]verType is not online " + paramMiniAppInfo.verType + ", delete path " + str);
      if (new File(str).exists()) {
        bekq.a(str, false);
      }
    }
    parambevb = new beva(parambevb);
    a(paramMiniAppInfo, parambevb, str);
    if (paramMiniAppInfo.miniGamePluginInfo != null)
    {
      a(paramMiniAppInfo.miniGamePluginInfo, parambevb);
      return;
    }
    besl.b("[minigame] GpkgManager", "[Gpkg] game don't have plugin " + paramMiniAppInfo.name + " " + paramMiniAppInfo.appId);
    parambevb.a(true, null);
  }
  
  private static void b(MiniAppInfo paramMiniAppInfo, bevb parambevb, String paramString)
  {
    if (paramMiniAppInfo == null)
    {
      if (parambevb != null) {
        parambevb.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, game config null");
      }
      besl.d("[minigame] GpkgManager", "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, game config null");
      return;
    }
    String str3 = besm.b(paramMiniAppInfo) + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".wxapkg";
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    int i = -1;
    String str1;
    Object localObject2;
    SubPkgInfo localSubPkgInfo;
    if (paramMiniAppInfo.firstPage != null)
    {
      str1 = paramMiniAppInfo.firstPage.b;
      if (paramMiniAppInfo.subpkgs != null)
      {
        localObject2 = paramMiniAppInfo.subpkgs.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localSubPkgInfo = (SubPkgInfo)((Iterator)localObject2).next();
          if ((localSubPkgInfo != null) && (str1 != null) && (str1.equals(localSubPkgInfo.subPkgName))) {
            if (localSubPkgInfo.independent == 1)
            {
              String str2 = localSubPkgInfo.downloadUrl;
              i = localSubPkgInfo.fileSize;
              localObject2 = localObject1;
              localObject1 = str2;
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
        i = paramMiniAppInfo.fileSize;
        label208:
        besl.b("[minigame] GpkgManager", "[Gpkg]download gpkgUrl=" + (String)localObject1 + " ,subApkUrl=" + (String)localObject2 + " ,independentPath=" + str1 + " ,savePath=" + str3 + " ,fileSize=" + i);
        beyr.a(paramMiniAppInfo, 619, "1");
        ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download((String)localObject1, null, str3, 60, new beuw(paramMiniAppInfo, parambevb, l, str3, paramString, (String)localObject2, str1, i));
        return;
        localObject1 = localSubPkgInfo.downloadUrl;
        i = localSubPkgInfo.fileSize;
      }
      for (;;)
      {
        break;
        break label208;
      }
      str1 = null;
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      i = -1;
      str1 = null;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  private static void b(MiniAppInfo paramMiniAppInfo1, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo2, bevb parambevb, String paramString3, String paramString4)
  {
    File localFile = new File(paramString1);
    beyr.a(paramMiniAppInfo2, 621, "1");
    boolean bool = beji.a(localFile.getAbsolutePath(), paramString2);
    int i;
    if (bool)
    {
      i = 0;
      beyr.a(paramMiniAppInfo2, 622, null, null, null, i, "1", 0L, null);
      besl.b("[minigame] GpkgManager", "[Gpkg] handleGpkgDownloadSuccess path:" + paramString1 + ",unpack:" + paramString2 + ",hasUnpack:" + bool);
      if (!bool) {
        break label185;
      }
      paramString1 = bevc.a(paramString2, paramString4, paramMiniAppInfo2);
      if (paramString3 == null) {
        break label167;
      }
      besl.b("[minigame] GpkgManager", "[Gpkg] downloadSubPack after gpk succeed, subApkUrl=" + paramString3);
      a(paramMiniAppInfo1, paramString1, paramString3, new beux(parambevb));
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
      } while (parambevb == null);
      parambevb.onInitGpkgInfo(0, paramString1, "download pkg and unpack succeed");
      return;
      beyu.a(paramMiniAppInfo2, "1", null, "page_view", "load_fail", "unpkg_fail", "");
      bexz.a("2launch_fail", "unpkg_fail", null, paramMiniAppInfo2);
      besl.d("[minigame] GpkgManager", "[Gpkg] handleGpkgDownloadSuccess hasUnpack=" + bool);
    } while (parambevb == null);
    parambevb.onInitGpkgInfo(2005, null, "download pkg succeed but unpack fail");
  }
  
  private static boolean b(String paramString)
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
        besl.b("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent error:" + bffr.a(paramString));
      }
    }
    return false;
  }
  
  private static void c(MiniAppInfo paramMiniAppInfo, bevb parambevb)
  {
    b(paramMiniAppInfo, new beuu(parambevb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beut
 * JD-Core Version:    0.7.0.1
 */