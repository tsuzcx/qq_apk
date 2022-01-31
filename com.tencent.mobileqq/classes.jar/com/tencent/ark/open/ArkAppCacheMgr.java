package com.tencent.ark.open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateSetup;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArkAppCacheMgr
{
  private static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.ArkAppCacheMgr";
  private static Map<String, ArkAppCacheMgr.ArkDescIconInfo> sAppDescIconCache = Collections.synchronizedMap(new HashMap());
  private static Map<String, ArkAppCacheMgr.ApplicationIconHolder> sAppIconCache = Collections.synchronizedMap(new HashMap());
  protected static Map<String, ArkAppCacheMgr.ArkAppManifestInfo> sAppManifestInfoCache = Collections.synchronizedMap(new HashMap());
  
  protected static ArkAppCacheMgr.ArkAppManifestInfo cacheManifestInfo(String paramString1, String paramString2)
  {
    setupArkEnvironment(true);
    if (!ArkEnvironmentManager.getInstance().isLibraryLoad()) {}
    do
    {
      return null;
      if (sAppManifestInfoCache.containsKey(paramString1)) {
        return (ArkAppCacheMgr.ArkAppManifestInfo)sAppManifestInfoCache.get(paramString1);
      }
    } while (TextUtils.isEmpty(paramString2));
    ArkDispatchTask.getInstance().send(paramString2, new ArkAppCacheMgr.1(paramString2, paramString1));
    return (ArkAppCacheMgr.ArkAppManifestInfo)sAppManifestInfoCache.get(paramString2);
  }
  
  public static int checkAppVersion(String paramString)
  {
    paramString = (ArkAppCacheMgr.ArkAppManifestInfo)sAppManifestInfoCache.get(paramString);
    if (paramString != null) {
      return paramString.checkVersion;
    }
    if (paramString != null) {
      return paramString.checkVersion;
    }
    return 0;
  }
  
  public static String getAppActionSet(String paramString)
  {
    paramString = (ArkAppCacheMgr.ArkAppManifestInfo)sAppManifestInfoCache.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.actionSet))) {
      return paramString.actionSet;
    }
    if (paramString != null) {
      return paramString.actionSet;
    }
    return "";
  }
  
  public static void getAppIcon(String paramString, ArkAppCacheMgr.OnGetAppIcon paramOnGetAppIcon)
  {
    if ((paramString == null) || (paramOnGetAppIcon == null)) {
      return;
    }
    Object localObject2;
    synchronized (sAppIconCache)
    {
      localObject2 = (ArkAppCacheMgr.ApplicationIconHolder)sAppIconCache.get(paramString);
      if (localObject2 != null) {
        ((ArkAppCacheMgr.ApplicationIconHolder)localObject2).refCount += 1;
      }
      if (localObject2 != null)
      {
        paramOnGetAppIcon.callback(paramString, ((ArkAppCacheMgr.ApplicationIconHolder)localObject2).bmp);
        return;
      }
    }
    ArkAppInfo.AppConfig localAppConfig = ArkAppConfigMgr.getInstance().getAppConfig(paramString);
    if ((localAppConfig != null) && (ArkAppConfigMgr.isTemplateApp(localAppConfig)))
    {
      localObject2 = getDescIconInfo(paramString);
      if ((localObject2 != null) && (ArkUtil.fileExists(((ArkAppCacheMgr.ArkDescIconInfo)localObject2).iconPath)))
      {
        ArkDispatchTask.getInstance().postToArkThread(new ArkAppCacheMgr.2((ArkAppCacheMgr.ArkDescIconInfo)localObject2, paramString, paramOnGetAppIcon));
        return;
      }
      if (!TextUtils.isEmpty(localAppConfig.iconUrl))
      {
        ENV.logI("ArkApp.ArkAppCacheMgr", "ArkTemp.getAppIcon from config appName=" + paramString);
        ??? = localObject2;
        if (localObject2 == null)
        {
          ??? = new ArkAppCacheMgr.ArkDescIconInfo();
          ((ArkAppCacheMgr.ArkDescIconInfo)???).name = paramString;
        }
        ArkDispatchTask.getInstance().postToArkThread(new ArkAppCacheMgr.3(paramString, localAppConfig, (ArkAppCacheMgr.ArkDescIconInfo)???, paramOnGetAppIcon));
        return;
      }
      ENV.logI("ArkApp.ArkAppCacheMgr", "ArkTemp.getAppIcon from config, iconurl is null, appName =" + paramString);
      paramOnGetAppIcon.callback(paramString, null);
      return;
    }
    ArkDispatchTask.getInstance().post(paramString, new ArkAppCacheMgr.4(paramString, paramOnGetAppIcon));
  }
  
  public static String getApplicationDesc(String paramString)
  {
    paramString = getDescIconInfo(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.name))) {
      return paramString.name;
    }
    if (paramString != null) {
      return paramString.name;
    }
    return "";
  }
  
  public static Map<String, String> getApplicationFromManifest(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (ArkAppMgr.getInstance().getAppPathByNameFromLocal(paramString1, "", paramString2, false) != null)
    {
      localHashMap.put("desc", getApplicationDesc(paramString1));
      localHashMap.put("version", getApplicationVersion(paramString1));
      return localHashMap;
    }
    return null;
  }
  
  public static String getApplicationLauncher(String paramString)
  {
    paramString = (ArkAppCacheMgr.ArkAppManifestInfo)sAppManifestInfoCache.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.launcher))) {
      return paramString.launcher;
    }
    if (paramString != null) {
      return paramString.launcher;
    }
    return "";
  }
  
  public static String getApplicationVersion(String paramString)
  {
    paramString = (ArkAppCacheMgr.ArkAppManifestInfo)sAppManifestInfoCache.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.version))) {
      return paramString.version;
    }
    if (paramString != null) {
      return paramString.version;
    }
    return "0.0.0.1";
  }
  
  protected static ArkAppCacheMgr.ArkDescIconInfo getDescIconInfo(String paramString)
  {
    synchronized (sAppDescIconCache)
    {
      ArkAppCacheMgr.ArkDescIconInfo localArkDescIconInfo2 = (ArkAppCacheMgr.ArkDescIconInfo)sAppDescIconCache.get(paramString);
      ArkAppCacheMgr.ArkDescIconInfo localArkDescIconInfo1 = localArkDescIconInfo2;
      if (localArkDescIconInfo2 == null)
      {
        Object localObject = ArkEnvironmentManager.getInstance().getAppConfigCacheSharedPreferences();
        localArkDescIconInfo1 = localArkDescIconInfo2;
        if (localObject != null)
        {
          localObject = ((SharedPreferences)localObject).getString(paramString, "");
          localArkDescIconInfo1 = localArkDescIconInfo2;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localArkDescIconInfo1 = ArkAppCacheMgr.ArkDescIconInfo.fromJson((String)localObject);
            sAppDescIconCache.put(paramString, localArkDescIconInfo1);
            ENV.logI("ArkApp.ArkAppCacheMgr", "ArkTemp.getAppIcon get ArkAppConfigInfo app:" + paramString + ",ArkAppConfigInfo:" + (String)localObject);
          }
        }
      }
      return localArkDescIconInfo1;
    }
  }
  
  /* Error */
  private static android.graphics.Bitmap getIconFromFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +7 -> 25
    //   21: aload_3
    //   22: astore_0
    //   23: aload_0
    //   24: areturn
    //   25: new 263	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 266	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: astore_3
    //   38: aload 7
    //   40: astore 5
    //   42: aload 8
    //   44: astore 6
    //   46: new 268	android/graphics/BitmapFactory$Options
    //   49: dup
    //   50: invokespecial 269	android/graphics/BitmapFactory$Options:<init>	()V
    //   53: astore 9
    //   55: aload 4
    //   57: astore_3
    //   58: aload 7
    //   60: astore 5
    //   62: aload 8
    //   64: astore 6
    //   66: aload 9
    //   68: iconst_1
    //   69: putfield 273	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   72: aload 4
    //   74: astore_3
    //   75: aload 7
    //   77: astore 5
    //   79: aload 8
    //   81: astore 6
    //   83: aload 4
    //   85: aconst_null
    //   86: aload 9
    //   88: invokestatic 279	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   91: pop
    //   92: aload 4
    //   94: astore_3
    //   95: aload 7
    //   97: astore 5
    //   99: aload 8
    //   101: astore 6
    //   103: aload 9
    //   105: getfield 282	android/graphics/BitmapFactory$Options:outHeight	I
    //   108: istore_1
    //   109: aload 4
    //   111: astore_3
    //   112: aload 7
    //   114: astore 5
    //   116: aload 8
    //   118: astore 6
    //   120: aload 9
    //   122: getfield 285	android/graphics/BitmapFactory$Options:outWidth	I
    //   125: istore_2
    //   126: aload 4
    //   128: astore_3
    //   129: aload 7
    //   131: astore 5
    //   133: aload 8
    //   135: astore 6
    //   137: new 268	android/graphics/BitmapFactory$Options
    //   140: dup
    //   141: invokespecial 269	android/graphics/BitmapFactory$Options:<init>	()V
    //   144: astore 9
    //   146: aload 4
    //   148: astore_3
    //   149: aload 7
    //   151: astore 5
    //   153: aload 8
    //   155: astore 6
    //   157: aload 9
    //   159: iload_1
    //   160: iload_2
    //   161: invokestatic 291	java/lang/Math:max	(II)I
    //   164: sipush 128
    //   167: idiv
    //   168: putfield 294	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   171: aload 4
    //   173: astore_3
    //   174: aload 7
    //   176: astore 5
    //   178: aload 8
    //   180: astore 6
    //   182: aload_0
    //   183: aload 9
    //   185: invokestatic 298	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   188: astore 7
    //   190: aload 4
    //   192: astore_3
    //   193: aload 7
    //   195: astore 5
    //   197: aload 7
    //   199: astore 6
    //   201: getstatic 27	com/tencent/ark/open/ArkAppCacheMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   204: ldc 10
    //   206: new 170	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 300
    //   216: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokevirtual 184	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 7
    //   231: astore_0
    //   232: aload 4
    //   234: ifnull -211 -> 23
    //   237: aload 4
    //   239: invokevirtual 303	java/io/FileInputStream:close	()V
    //   242: aload 7
    //   244: areturn
    //   245: astore_0
    //   246: getstatic 27	com/tencent/ark/open/ArkAppCacheMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   249: ldc 10
    //   251: new 170	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 305
    //   261: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokevirtual 308	java/io/IOException:getMessage	()Ljava/lang/String;
    //   268: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokevirtual 184	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload 7
    //   279: areturn
    //   280: astore_0
    //   281: aconst_null
    //   282: astore 4
    //   284: aload 4
    //   286: astore_3
    //   287: getstatic 27	com/tencent/ark/open/ArkAppCacheMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   290: ldc 10
    //   292: new 170	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 310
    //   302: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_0
    //   306: invokevirtual 311	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   309: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokevirtual 184	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload 6
    //   320: astore_0
    //   321: aload 4
    //   323: ifnull -300 -> 23
    //   326: aload 4
    //   328: invokevirtual 303	java/io/FileInputStream:close	()V
    //   331: aload 6
    //   333: areturn
    //   334: astore_0
    //   335: getstatic 27	com/tencent/ark/open/ArkAppCacheMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   338: ldc 10
    //   340: new 170	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 305
    //   350: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: invokevirtual 308	java/io/IOException:getMessage	()Ljava/lang/String;
    //   357: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokevirtual 184	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload 6
    //   368: areturn
    //   369: astore_0
    //   370: aconst_null
    //   371: astore 4
    //   373: aload 4
    //   375: astore_3
    //   376: getstatic 27	com/tencent/ark/open/ArkAppCacheMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   379: ldc 10
    //   381: new 170	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 313
    //   391: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: invokevirtual 314	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   398: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokevirtual 184	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload 5
    //   409: astore_0
    //   410: aload 4
    //   412: ifnull -389 -> 23
    //   415: aload 4
    //   417: invokevirtual 303	java/io/FileInputStream:close	()V
    //   420: aload 5
    //   422: areturn
    //   423: astore_0
    //   424: getstatic 27	com/tencent/ark/open/ArkAppCacheMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   427: ldc 10
    //   429: new 170	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 305
    //   439: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_0
    //   443: invokevirtual 308	java/io/IOException:getMessage	()Ljava/lang/String;
    //   446: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokevirtual 184	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: aload 5
    //   457: areturn
    //   458: astore_0
    //   459: aconst_null
    //   460: astore_3
    //   461: aload_3
    //   462: ifnull +7 -> 469
    //   465: aload_3
    //   466: invokevirtual 303	java/io/FileInputStream:close	()V
    //   469: aload_0
    //   470: athrow
    //   471: astore_3
    //   472: getstatic 27	com/tencent/ark/open/ArkAppCacheMgr:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   475: ldc 10
    //   477: new 170	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 305
    //   487: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_3
    //   491: invokevirtual 308	java/io/IOException:getMessage	()Ljava/lang/String;
    //   494: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokevirtual 184	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: goto -34 -> 469
    //   506: astore_0
    //   507: goto -46 -> 461
    //   510: astore_0
    //   511: goto -138 -> 373
    //   514: astore_0
    //   515: goto -231 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	paramString	String
    //   108	52	1	i	int
    //   125	36	2	j	int
    //   13	453	3	localObject1	Object
    //   471	20	3	localIOException	java.io.IOException
    //   33	383	4	localFileInputStream	java.io.FileInputStream
    //   4	452	5	localObject2	Object
    //   1	366	6	localObject3	Object
    //   7	271	7	localBitmap	android.graphics.Bitmap
    //   10	169	8	localObject4	Object
    //   53	131	9	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   237	242	245	java/io/IOException
    //   25	35	280	java/io/FileNotFoundException
    //   326	331	334	java/io/IOException
    //   25	35	369	java/lang/OutOfMemoryError
    //   415	420	423	java/io/IOException
    //   25	35	458	finally
    //   465	469	471	java/io/IOException
    //   46	55	506	finally
    //   66	72	506	finally
    //   83	92	506	finally
    //   103	109	506	finally
    //   120	126	506	finally
    //   137	146	506	finally
    //   157	171	506	finally
    //   182	190	506	finally
    //   201	229	506	finally
    //   287	318	506	finally
    //   376	407	506	finally
    //   46	55	510	java/lang/OutOfMemoryError
    //   66	72	510	java/lang/OutOfMemoryError
    //   83	92	510	java/lang/OutOfMemoryError
    //   103	109	510	java/lang/OutOfMemoryError
    //   120	126	510	java/lang/OutOfMemoryError
    //   137	146	510	java/lang/OutOfMemoryError
    //   157	171	510	java/lang/OutOfMemoryError
    //   182	190	510	java/lang/OutOfMemoryError
    //   201	229	510	java/lang/OutOfMemoryError
    //   46	55	514	java/io/FileNotFoundException
    //   66	72	514	java/io/FileNotFoundException
    //   83	92	514	java/io/FileNotFoundException
    //   103	109	514	java/io/FileNotFoundException
    //   120	126	514	java/io/FileNotFoundException
    //   137	146	514	java/io/FileNotFoundException
    //   157	171	514	java/io/FileNotFoundException
    //   182	190	514	java/io/FileNotFoundException
    //   201	229	514	java/io/FileNotFoundException
  }
  
  public static void releaseAppIcon(String paramString)
  {
    if (paramString == null)
    {
      ENV.logI("ArkApp.ArkAppCacheMgr", String.format("releaseAppIcon call getAppName, return", new Object[0]));
      return;
    }
    ArkAppCacheMgr.ApplicationIconHolder localApplicationIconHolder;
    synchronized (sAppIconCache)
    {
      localApplicationIconHolder = (ArkAppCacheMgr.ApplicationIconHolder)sAppIconCache.get(paramString);
      if (localApplicationIconHolder == null)
      {
        ENV.logI("ArkApp.ArkAppCacheMgr", String.format("releaseAppIcon.notfound!! appName: %s", new Object[] { paramString }));
        return;
      }
    }
    int i = localApplicationIconHolder.refCount - 1;
    localApplicationIconHolder.refCount = i;
    if (i != 0) {
      return;
    }
    ENV.logI("ArkApp.ArkAppCacheMgr", String.format("releaseAppIcon.release!! appName: %s", new Object[] { paramString }));
    sAppIconCache.remove(paramString);
    ArkDispatchTask.getInstance().postToArkThread(new ArkAppCacheMgr.5(localApplicationIconHolder));
  }
  
  protected static void saveDescIconInfo(String paramString, ArkAppCacheMgr.ArkDescIconInfo paramArkDescIconInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArkDescIconInfo == null)) {
      return;
    }
    synchronized (sAppDescIconCache)
    {
      sAppDescIconCache.put(paramString, paramArkDescIconInfo);
      SharedPreferences localSharedPreferences = ArkEnvironmentManager.getInstance().getAppConfigCacheSharedPreferences();
      if (localSharedPreferences != null)
      {
        paramArkDescIconInfo = paramArkDescIconInfo.toString();
        localSharedPreferences.edit().putString(paramString, paramArkDescIconInfo);
        ENV.logI("ArkApp.ArkAppCacheMgr", "ArkTemp.getAppIcon save ArkAppConfigInfo app:" + paramString + ",ArkAppConfigInfo:" + paramArkDescIconInfo);
      }
      return;
    }
  }
  
  public static void setupArkEnvironment(boolean paramBoolean)
  {
    IArkDelegateSetup localIArkDelegateSetup = ArkDelegateManager.getInstance().getSetupDelegate();
    if (localIArkDelegateSetup != null) {
      localIArkDelegateSetup.setupArkEnvironment(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr
 * JD-Core Version:    0.7.0.1
 */