import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.gpkg.GpkgManager.3;
import com.tencent.qqmini.sdk.minigame.utils.TTHandleThread;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bgud
{
  public static volatile long a;
  
  private static SubPkgInfo a(MiniAppInfo paramMiniAppInfo, bgun parambgun, String paramString)
  {
    paramMiniAppInfo = paramMiniAppInfo.subpkgs;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        parambgun = (SubPkgInfo)paramMiniAppInfo.next();
        if (paramString.equals(parambgun.subPkgName)) {
          return parambgun;
        }
      }
    }
    return null;
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo)
  {
    TTHandleThread.a().a(new GpkgManager.3(paramMiniAppInfo));
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, bgum parambgum)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (parambgum != null) {
        parambgum.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null");
      }
      return;
    }
    parambgum = new bgue(paramMiniAppInfo, parambgum);
    bgtx.a(paramMiniAppInfo);
    c(paramMiniAppInfo, parambgum);
  }
  
  private static void a(MiniAppInfo paramMiniAppInfo, bgum parambgum, String paramString)
  {
    if (new File(paramString).exists())
    {
      if (b(paramString))
      {
        QMLog.i("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent success");
        paramString = bgun.a(paramString, null, paramMiniAppInfo);
        if (parambgum != null) {
          parambgum.onInitGpkgInfo(0, paramString, "gpkg exist, no need download");
        }
        if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
          bgxn.c(paramMiniAppInfo.appId, true);
        }
        return;
      }
      QMLog.i("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent failed, delete folder:" + paramString);
      bgkv.a(paramString, false);
      QMLog.i("[minigame] GpkgManager", "[Gpkg] download gpkg by url1:" + paramMiniAppInfo.downloadUrl);
      b(paramMiniAppInfo, parambgum, paramString);
      return;
    }
    QMLog.i("[minigame] GpkgManager", "[Gpkg] download gpkg by url2:" + paramMiniAppInfo.downloadUrl);
    b(paramMiniAppInfo, parambgum, paramString);
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, bgun parambgun, String paramString, bgum parambgum)
  {
    String str2 = parambgun.getRootPath(paramString);
    SubPkgInfo localSubPkgInfo = a(paramMiniAppInfo, parambgun, paramString);
    String str1;
    String str3;
    int i;
    if (localSubPkgInfo != null)
    {
      str1 = localSubPkgInfo.downloadUrl;
      str3 = bgrb.a(paramMiniAppInfo);
      if (localSubPkgInfo == null) {
        break label130;
      }
      i = localSubPkgInfo.fileSize;
      label45:
      QMLog.i("[minigame] GpkgManager subpackage", "[Gpkg] downloadSubPack | downPage(subName)=" + paramString + "; subPackDownloadUrl=" + str1 + "; folder:" + str3 + "; fileSize:" + i);
      if (!TextUtils.isEmpty(str3)) {
        break label136;
      }
      if (parambgum != null) {
        parambgum.onInitGpkgInfo(2007, null, "downloadSubPack but pkg folder not exist");
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
    } while (parambgum == null);
    parambgum.onInitGpkgInfo(0, parambgun, "downloadSubPack succeed, sub pkg already exist");
    return;
    label168:
    if (!TextUtils.isEmpty(str1))
    {
      paramString = bgrb.b(paramMiniAppInfo) + File.separator + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + "_" + System.nanoTime() + ".wxapkg";
      bgyd.a(paramMiniAppInfo, 613, "1");
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(str1, null, paramString, 60, new bguj(paramMiniAppInfo, parambgum, paramString, str2, parambgun, i));
      return;
    }
    parambgum.onInitGpkgInfo(2008, null, "sub pkg download url empty");
  }
  
  public static void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return;
      paramMiniAppInfo = bgrb.a(paramMiniAppInfo);
    } while (!new File(paramMiniAppInfo).exists());
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("offlineResourceReady", paramBoolean);
      localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
      bgkv.c(new File(paramMiniAppInfo, "offlineconfig.json").getAbsolutePath(), (String)localObject);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      paramMiniAppInfo.printStackTrace();
    }
  }
  
  private static void a(MiniGamePluginInfo paramMiniGamePluginInfo, bguk parambguk)
  {
    File localFile1 = new File(bgrb.a(paramMiniGamePluginInfo));
    if (localFile1.exists())
    {
      if (new File(localFile1, "plugin.js").exists())
      {
        QMLog.i("[minigame] GpkgManager", "[Gpkg] plugin existed:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
        parambguk.a(true, null);
        return;
      }
      QMLog.e("[minigame] GpkgManager", "[Gpkg] plugin corrupted:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
    }
    File localFile2;
    try
    {
      localFile2 = File.createTempFile("gpkg_plugin_" + paramMiniGamePluginInfo.id, ".wxapkg");
      if (TextUtils.isEmpty(paramMiniGamePluginInfo.url))
      {
        if (parambguk != null) {
          parambguk.a(false, null);
        }
        QMLog.e("[minigame] GpkgManager", "[Gpkg] download plugin failed pluginInfo.url null");
        return;
      }
    }
    catch (IOException paramMiniGamePluginInfo)
    {
      parambguk.a(false, paramMiniGamePluginInfo);
      return;
    }
    QMLog.i("[minigame] GpkgManager", "[Gpkg] start download plugin to:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramMiniGamePluginInfo.url, null, localFile2.getAbsolutePath(), 60, new bgug(paramMiniGamePluginInfo, parambguk, localFile2, localFile1));
  }
  
  public static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {}
    do
    {
      return false;
      paramMiniAppInfo = bgrb.a(paramMiniAppInfo);
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
        paramString = bgkv.b(paramString);
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString)) {
          bool1 = new JSONObject(paramString).optBoolean("offlineResourceReady", false);
        }
      }
      return bool1;
    }
    catch (Throwable paramString)
    {
      QMLog.i("[minigame] GpkgManager", "[Gpkg] checkOfflineResourceContent error:" + DebugUtil.getPrintableStackTrace(paramString));
    }
    return false;
  }
  
  /* Error */
  private static String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 25	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: ldc_w 349
    //   14: aload_0
    //   15: invokestatic 351	bgkv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokevirtual 51	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifeq +189 -> 210
    //   24: aload_0
    //   25: ldc_w 349
    //   28: ldc_w 353
    //   31: invokevirtual 357	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   34: astore 6
    //   36: aload_0
    //   37: ldc_w 349
    //   40: ldc_w 359
    //   43: invokevirtual 357	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   46: astore 5
    //   48: iconst_0
    //   49: istore_1
    //   50: aconst_null
    //   51: astore_3
    //   52: aload_0
    //   53: aload 6
    //   55: invokestatic 364	bglr:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: ifne +217 -> 275
    //   61: aload 6
    //   63: invokestatic 365	bgkv:b	(Ljava/lang/String;)Z
    //   66: ifeq +209 -> 275
    //   69: aload 6
    //   71: iconst_0
    //   72: iconst_0
    //   73: invokestatic 368	bgkv:a	(Ljava/lang/String;ZI)Ljava/util/ArrayList;
    //   76: astore 4
    //   78: aload 4
    //   80: ifnull +304 -> 384
    //   83: aload 4
    //   85: invokevirtual 371	java/util/ArrayList:size	()I
    //   88: ifle +296 -> 384
    //   91: aload 4
    //   93: invokevirtual 372	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   96: astore 4
    //   98: aload 4
    //   100: invokeinterface 35 1 0
    //   105: ifeq +279 -> 384
    //   108: aload 4
    //   110: invokeinterface 39 1 0
    //   115: checkcast 374	com/tencent/qqmini/sdk/core/utils/FileInfo
    //   118: astore 7
    //   120: ldc_w 359
    //   123: aload 7
    //   125: invokevirtual 376	com/tencent/qqmini/sdk/core/utils/FileInfo:a	()Ljava/lang/String;
    //   128: invokestatic 351	bgkv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokevirtual 51	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifne +19 -> 153
    //   137: ldc 219
    //   139: aload 7
    //   141: invokevirtual 376	com/tencent/qqmini/sdk/core/utils/FileInfo:a	()Ljava/lang/String;
    //   144: invokestatic 351	bgkv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 51	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifeq -52 -> 98
    //   153: aload 7
    //   155: invokevirtual 376	com/tencent/qqmini/sdk/core/utils/FileInfo:a	()Ljava/lang/String;
    //   158: astore 4
    //   160: aload 4
    //   162: astore_3
    //   163: aload_3
    //   164: astore 4
    //   166: aload_3
    //   167: invokestatic 365	bgkv:b	(Ljava/lang/String;)Z
    //   170: ifeq +108 -> 278
    //   173: new 103	java/io/File
    //   176: dup
    //   177: aload_3
    //   178: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   181: new 103	java/io/File
    //   184: dup
    //   185: aload 5
    //   187: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: invokestatic 379	bgkv:a	(Ljava/io/File;Ljava/io/File;)Z
    //   193: istore_2
    //   194: aload_3
    //   195: astore 4
    //   197: iload_2
    //   198: ifeq +80 -> 278
    //   201: aload 6
    //   203: iconst_0
    //   204: invokestatic 151	bgkv:a	(Ljava/lang/String;Z)V
    //   207: aload 5
    //   209: astore_3
    //   210: aload_3
    //   211: invokestatic 365	bgkv:b	(Ljava/lang/String;)Z
    //   214: ifeq +151 -> 365
    //   217: aload_3
    //   218: astore 4
    //   220: aload_3
    //   221: aload_0
    //   222: invokevirtual 51	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifne +11 -> 236
    //   228: aload_0
    //   229: iconst_0
    //   230: invokestatic 151	bgkv:a	(Ljava/lang/String;Z)V
    //   233: aload_3
    //   234: astore 4
    //   236: ldc 73
    //   238: new 134	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 381
    //   248: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 4
    //   253: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 383
    //   259: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_0
    //   263: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 117	com/tencent/qqmini/sdk/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 4
    //   274: areturn
    //   275: aload_3
    //   276: astore 4
    //   278: iload_1
    //   279: iconst_1
    //   280: iadd
    //   281: istore_1
    //   282: aload 4
    //   284: astore_3
    //   285: iload_1
    //   286: iconst_3
    //   287: if_icmpge -77 -> 210
    //   290: aload 4
    //   292: astore_3
    //   293: goto -241 -> 52
    //   296: astore 4
    //   298: ldc 73
    //   300: new 134	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 385
    //   310: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_0
    //   314: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 387
    //   320: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload 6
    //   325: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc_w 389
    //   331: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: iload_1
    //   335: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: aload 4
    //   343: invokestatic 392	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   346: aload 6
    //   348: iconst_0
    //   349: invokestatic 151	bgkv:a	(Ljava/lang/String;Z)V
    //   352: iload_1
    //   353: iconst_1
    //   354: iadd
    //   355: istore_1
    //   356: aload_3
    //   357: astore 4
    //   359: goto -77 -> 282
    //   362: astore_0
    //   363: aload_0
    //   364: athrow
    //   365: aload_0
    //   366: astore 4
    //   368: goto -132 -> 236
    //   371: astore 4
    //   373: aload 5
    //   375: astore_3
    //   376: goto -78 -> 298
    //   379: astore 4
    //   381: goto -83 -> 298
    //   384: goto -221 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramString	String
    //   49	307	1	i	int
    //   193	5	2	bool	boolean
    //   1	375	3	localObject1	Object
    //   76	215	4	localObject2	Object
    //   296	46	4	localThrowable1	Throwable
    //   357	10	4	localObject3	Object
    //   371	1	4	localThrowable2	Throwable
    //   379	1	4	localThrowable3	Throwable
    //   46	328	5	str1	String
    //   34	313	6	str2	String
    //   118	36	7	localFileInfo	com.tencent.qqmini.sdk.core.utils.FileInfo
    // Exception table:
    //   from	to	target	type
    //   166	194	296	java/lang/Throwable
    //   52	78	362	finally
    //   83	98	362	finally
    //   98	153	362	finally
    //   153	160	362	finally
    //   166	194	362	finally
    //   201	207	362	finally
    //   298	352	362	finally
    //   201	207	371	java/lang/Throwable
    //   52	78	379	java/lang/Throwable
    //   83	98	379	java/lang/Throwable
    //   98	153	379	java/lang/Throwable
    //   153	160	379	java/lang/Throwable
  }
  
  public static void b(MiniAppInfo paramMiniAppInfo, bgum parambgum)
  {
    bgyd.b(paramMiniAppInfo, 2, "0");
    if (paramMiniAppInfo == null)
    {
      QMLog.e("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (parambgum != null) {
        parambgum.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null");
      }
      return;
    }
    QMLog.i("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig version:" + paramMiniAppInfo.version + ", appid=" + paramMiniAppInfo.appId + ",size=" + paramMiniAppInfo.fileSize);
    String str = bgrb.a(paramMiniAppInfo);
    QMLog.i("[minigame] GpkgManager", "[Gpkg] getGpkgInfoByConfig folderPath:" + str);
    if ((paramMiniAppInfo.verType != 3) && ((!paramMiniAppInfo.isSupportOffline) || (paramMiniAppInfo.launchParam.scene == 1011)))
    {
      QMLog.i("[minigame] GpkgManager", "[Gpkg]verType is not online " + paramMiniAppInfo.verType + ", delete path " + str);
      if (new File(str).exists()) {
        bgkv.a(str, false);
      }
    }
    parambgum = new bgul(parambgum);
    a(paramMiniAppInfo, parambgum, str);
    if (paramMiniAppInfo.miniGamePluginInfo != null)
    {
      a(paramMiniAppInfo.miniGamePluginInfo, parambgum);
      return;
    }
    QMLog.i("[minigame] GpkgManager", "[Gpkg] game don't have plugin " + paramMiniAppInfo.name + " " + paramMiniAppInfo.appId);
    parambgum.a(true, null);
  }
  
  private static void b(MiniAppInfo paramMiniAppInfo, bgum parambgum, String paramString)
  {
    if (paramMiniAppInfo == null)
    {
      if (parambgum != null) {
        parambgum.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, game config null");
      }
      QMLog.e("[minigame] GpkgManager", "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, game config null");
      return;
    }
    if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
      bgxn.c(paramMiniAppInfo.appId, false);
    }
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    int i = -1;
    String str1;
    Object localObject2;
    SubPkgInfo localSubPkgInfo;
    String str2;
    if (paramMiniAppInfo.firstPage != null)
    {
      str1 = paramMiniAppInfo.firstPage.subPkgName;
      if (paramMiniAppInfo.subpkgs != null)
      {
        localObject2 = paramMiniAppInfo.subpkgs.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localSubPkgInfo = (SubPkgInfo)((Iterator)localObject2).next();
          if ((localSubPkgInfo != null) && (str1 != null) && (str1.equals(localSubPkgInfo.subPkgName))) {
            if (localSubPkgInfo.independent == 1)
            {
              str2 = localSubPkgInfo.downloadUrl;
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
        label183:
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (parambgum != null) {
            parambgum.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, downloadUrl null");
          }
          QMLog.e("[minigame] GpkgManager", "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, downloadUrl null");
          return;
          localObject1 = localSubPkgInfo.downloadUrl;
          i = localSubPkgInfo.fileSize;
        }
      }
      for (;;)
      {
        break;
        if (((String)localObject1).toLowerCase().endsWith(".zip")) {}
        for (str2 = ".zip";; str2 = ".tqapkg")
        {
          str2 = bgrb.b(paramMiniAppInfo) + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + str2;
          QMLog.i("[minigame] GpkgManager", "[Gpkg]download gpkgUrl=" + (String)localObject1 + " ,subApkUrl=" + (String)localObject2 + " ,independentPath=" + str1 + " ,savePath=" + str2 + " ,fileSize=" + i);
          bgyd.a(paramMiniAppInfo, 619, "1");
          ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download((String)localObject1, null, str2, 60, new bguh(paramMiniAppInfo, parambgum, l, str2, paramString, (String)localObject2, str1, i));
          return;
        }
        break label183;
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
  
  private static void b(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, bgum parambgum, String paramString3, String paramString4)
  {
    File localFile = new File(paramString1);
    bgyd.a(paramMiniAppInfo, 621, "1");
    boolean bool = bgjt.a(localFile.getAbsolutePath(), paramString2);
    int i;
    if (bool)
    {
      i = 0;
      bgyd.a(paramMiniAppInfo, 622, null, null, null, i, "1", 0L, null);
      QMLog.i("[minigame] GpkgManager", "[Gpkg] handleGpkgDownloadSuccess path:" + paramString1 + ",unpack:" + paramString2 + ",hasUnpack:" + bool);
      if (!bool) {
        break label182;
      }
      paramString1 = bgun.a(paramString2, paramString4, paramMiniAppInfo);
      if (paramString3 == null) {
        break label166;
      }
      QMLog.i("[minigame] GpkgManager", "[Gpkg] downloadSubPack after gpk succeed, subApkUrl=" + paramString3);
      a(paramMiniAppInfo, paramString1, paramString3, new bgui(parambgum));
    }
    label166:
    label182:
    do
    {
      do
      {
        return;
        i = 1;
        break;
      } while (parambgum == null);
      parambgum.onInitGpkgInfo(0, paramString1, "download pkg and unpack succeed");
      return;
      bgyg.a(paramMiniAppInfo, "1", null, "page_view", "load_fail", "unpkg_fail", "");
      bgxl.a("2launch_fail", "unpkg_fail", null, paramMiniAppInfo);
      QMLog.e("[minigame] GpkgManager", "[Gpkg] handleGpkgDownloadSuccess hasUnpack=" + bool);
    } while (parambgum == null);
    parambgum.onInitGpkgInfo(2005, null, "download pkg succeed but unpack fail");
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
        QMLog.i("[minigame] GpkgManager", "[Gpkg] checkPkgFolderContent error:" + DebugUtil.getPrintableStackTrace(paramString));
      }
    }
    return false;
  }
  
  private static void c(MiniAppInfo paramMiniAppInfo, bgum parambgum)
  {
    b(paramMiniAppInfo, new bguf(parambgum));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgud
 * JD-Core Version:    0.7.0.1
 */