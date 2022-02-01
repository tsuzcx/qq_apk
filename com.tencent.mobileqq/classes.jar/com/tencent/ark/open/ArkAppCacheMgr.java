package com.tencent.ark.open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArkAppCacheMgr
{
  private static final String TAG = "ArkApp.ArkAppCacheMgr";
  private static final Map<String, ArkAppCacheMgr.ArkDescIconInfo> sAppDescIconCache = Collections.synchronizedMap(new HashMap());
  private static final Map<String, ArkAppCacheMgr.ApplicationIconHolder> sAppIconCache = Collections.synchronizedMap(new HashMap());
  protected static Map<String, ArkAppCacheMgr.ArkAppManifestInfo> sAppManifestInfoCache = Collections.synchronizedMap(new HashMap());
  
  public static ArkAppCacheMgr.ArkAppManifestInfo cacheManifestInfo(String paramString1, String paramString2)
  {
    ArkDelegateManager.setupArkEnvironment(true);
    if (!ArkEnvironmentManager.getInstance().isLibraryLoad()) {
      return null;
    }
    if (sAppManifestInfoCache.containsKey(paramString1)) {
      return (ArkAppCacheMgr.ArkAppManifestInfo)sAppManifestInfoCache.get(paramString1);
    }
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
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
    if (paramString != null)
    {
      if (paramOnGetAppIcon == null) {
        return;
      }
      synchronized (sAppIconCache)
      {
        ArkAppCacheMgr.ApplicationIconHolder localApplicationIconHolder = (ArkAppCacheMgr.ApplicationIconHolder)sAppIconCache.get(paramString);
        if (localApplicationIconHolder != null) {
          localApplicationIconHolder.refCount += 1;
        }
        if (localApplicationIconHolder != null)
        {
          paramOnGetAppIcon.callback(paramString, localApplicationIconHolder.bmp);
          return;
        }
        ArkDispatchTask.getInstance().post(paramString, new ArkAppCacheMgr.2(paramString, paramOnGetAppIcon));
        return;
      }
    }
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
    if (ArkAppMgr.getInstance().getAppPathFromLocal(paramString1, paramString2) != null)
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
  
  public static ArkAppCacheMgr.ArkDescIconInfo getDescIconInfo(String paramString)
  {
    synchronized (sAppDescIconCache)
    {
      Object localObject2 = (ArkAppCacheMgr.ArkDescIconInfo)sAppDescIconCache.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Object localObject3 = ArkEnvironmentManager.getInstance().getAppConfigCacheSharedPreferences();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((SharedPreferences)localObject3).getString(paramString, "");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = ArkAppCacheMgr.ArkDescIconInfo.fromJson((String)localObject3);
            sAppDescIconCache.put(paramString, localObject1);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("ArkTemp.getAppIcon get ArkAppConfigInfo app:");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(",ArkAppConfigInfo:");
            ((StringBuilder)localObject2).append((String)localObject3);
            Logger.logI("ArkApp.ArkAppCacheMgr", ((StringBuilder)localObject2).toString());
          }
        }
      }
      return localObject1;
    }
  }
  
  /* Error */
  private static android.graphics.Bitmap getIconFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 10
    //   17: aconst_null
    //   18: astore 7
    //   20: iload_3
    //   21: ifeq +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 212	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   34: astore 5
    //   36: aload 7
    //   38: astore 4
    //   40: aload 8
    //   42: astore 6
    //   44: new 217	android/graphics/BitmapFactory$Options
    //   47: dup
    //   48: invokespecial 218	android/graphics/BitmapFactory$Options:<init>	()V
    //   51: astore 9
    //   53: aload 7
    //   55: astore 4
    //   57: aload 8
    //   59: astore 6
    //   61: aload 9
    //   63: iconst_1
    //   64: putfield 222	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   67: aload 7
    //   69: astore 4
    //   71: aload 8
    //   73: astore 6
    //   75: aload 5
    //   77: aconst_null
    //   78: aload 9
    //   80: invokestatic 228	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   83: pop
    //   84: aload 7
    //   86: astore 4
    //   88: aload 8
    //   90: astore 6
    //   92: aload 9
    //   94: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   97: istore_1
    //   98: aload 7
    //   100: astore 4
    //   102: aload 8
    //   104: astore 6
    //   106: aload 9
    //   108: getfield 234	android/graphics/BitmapFactory$Options:outWidth	I
    //   111: istore_2
    //   112: aload 7
    //   114: astore 4
    //   116: aload 8
    //   118: astore 6
    //   120: new 217	android/graphics/BitmapFactory$Options
    //   123: dup
    //   124: invokespecial 218	android/graphics/BitmapFactory$Options:<init>	()V
    //   127: astore 9
    //   129: aload 7
    //   131: astore 4
    //   133: aload 8
    //   135: astore 6
    //   137: aload 9
    //   139: iload_1
    //   140: iload_2
    //   141: invokestatic 240	java/lang/Math:max	(II)I
    //   144: sipush 128
    //   147: idiv
    //   148: putfield 243	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   151: aload 7
    //   153: astore 4
    //   155: aload 8
    //   157: astore 6
    //   159: aload_0
    //   160: aload 9
    //   162: invokestatic 247	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   165: astore 7
    //   167: aload 7
    //   169: astore 4
    //   171: aload 7
    //   173: astore 6
    //   175: new 184	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   182: astore 8
    //   184: aload 7
    //   186: astore 4
    //   188: aload 7
    //   190: astore 6
    //   192: aload 8
    //   194: ldc 249
    //   196: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 7
    //   202: astore 4
    //   204: aload 7
    //   206: astore 6
    //   208: aload 8
    //   210: aload_0
    //   211: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 7
    //   217: astore 4
    //   219: aload 7
    //   221: astore 6
    //   223: ldc 8
    //   225: aload 8
    //   227: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 202	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload 5
    //   235: invokevirtual 252	java/io/FileInputStream:close	()V
    //   238: goto +41 -> 279
    //   241: astore_0
    //   242: new 184	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   249: astore 4
    //   251: aload 4
    //   253: ldc 254
    //   255: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 4
    //   261: aload_0
    //   262: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   265: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: ldc 8
    //   271: aload 4
    //   273: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 202	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload 7
    //   281: areturn
    //   282: astore_0
    //   283: goto +246 -> 529
    //   286: astore 6
    //   288: aload 4
    //   290: astore_0
    //   291: goto +31 -> 322
    //   294: astore 4
    //   296: aload 6
    //   298: astore_0
    //   299: aload 4
    //   301: astore 6
    //   303: goto +139 -> 442
    //   306: astore_0
    //   307: aload 4
    //   309: astore 5
    //   311: goto +218 -> 529
    //   314: astore 6
    //   316: aconst_null
    //   317: astore_0
    //   318: aload 9
    //   320: astore 5
    //   322: aload 5
    //   324: astore 4
    //   326: new 184	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   333: astore 7
    //   335: aload 5
    //   337: astore 4
    //   339: aload 7
    //   341: ldc_w 259
    //   344: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 5
    //   350: astore 4
    //   352: aload 7
    //   354: aload 6
    //   356: invokevirtual 260	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 5
    //   365: astore 4
    //   367: ldc 8
    //   369: aload 7
    //   371: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 202	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_0
    //   378: astore 4
    //   380: aload 5
    //   382: ifnull +144 -> 526
    //   385: aload 5
    //   387: invokevirtual 252	java/io/FileInputStream:close	()V
    //   390: aload_0
    //   391: areturn
    //   392: astore 5
    //   394: new 184	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   401: astore 4
    //   403: aload 4
    //   405: ldc 254
    //   407: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 4
    //   413: aload 5
    //   415: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   418: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: ldc 8
    //   424: aload 4
    //   426: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 202	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: aload_0
    //   433: areturn
    //   434: astore 6
    //   436: aconst_null
    //   437: astore_0
    //   438: aload 10
    //   440: astore 5
    //   442: aload 5
    //   444: astore 4
    //   446: new 184	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   453: astore 7
    //   455: aload 5
    //   457: astore 4
    //   459: aload 7
    //   461: ldc_w 262
    //   464: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 5
    //   470: astore 4
    //   472: aload 7
    //   474: aload 6
    //   476: invokevirtual 263	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   479: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 5
    //   485: astore 4
    //   487: ldc 8
    //   489: aload 7
    //   491: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 202	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload_0
    //   498: astore 4
    //   500: aload 5
    //   502: ifnull +24 -> 526
    //   505: aload 5
    //   507: invokevirtual 252	java/io/FileInputStream:close	()V
    //   510: aload_0
    //   511: areturn
    //   512: astore 5
    //   514: new 184	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   521: astore 4
    //   523: goto -120 -> 403
    //   526: aload 4
    //   528: areturn
    //   529: aload 5
    //   531: ifnull +51 -> 582
    //   534: aload 5
    //   536: invokevirtual 252	java/io/FileInputStream:close	()V
    //   539: goto +43 -> 582
    //   542: astore 4
    //   544: new 184	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   551: astore 5
    //   553: aload 5
    //   555: ldc 254
    //   557: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 5
    //   563: aload 4
    //   565: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   568: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: ldc 8
    //   574: aload 5
    //   576: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 202	com/tencent/ark/Logger:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: goto +5 -> 587
    //   585: aload_0
    //   586: athrow
    //   587: goto -2 -> 585
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	paramString	String
    //   97	43	1	i	int
    //   111	30	2	j	int
    //   4	17	3	bool	boolean
    //   9	280	4	localObject1	Object
    //   294	14	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   324	203	4	localObject2	Object
    //   542	22	4	localIOException1	java.io.IOException
    //   34	352	5	localObject3	Object
    //   392	22	5	localIOException2	java.io.IOException
    //   440	66	5	localObject4	Object
    //   512	23	5	localIOException3	java.io.IOException
    //   551	24	5	localStringBuilder1	StringBuilder
    //   42	180	6	localObject5	Object
    //   286	11	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   301	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   314	41	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   434	41	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   18	472	7	localObject6	Object
    //   6	220	8	localStringBuilder2	StringBuilder
    //   12	307	9	localOptions	android.graphics.BitmapFactory.Options
    //   15	424	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   233	238	241	java/io/IOException
    //   44	53	282	finally
    //   61	67	282	finally
    //   75	84	282	finally
    //   92	98	282	finally
    //   106	112	282	finally
    //   120	129	282	finally
    //   137	151	282	finally
    //   159	167	282	finally
    //   175	184	282	finally
    //   192	200	282	finally
    //   208	215	282	finally
    //   223	233	282	finally
    //   44	53	286	java/lang/OutOfMemoryError
    //   61	67	286	java/lang/OutOfMemoryError
    //   75	84	286	java/lang/OutOfMemoryError
    //   92	98	286	java/lang/OutOfMemoryError
    //   106	112	286	java/lang/OutOfMemoryError
    //   120	129	286	java/lang/OutOfMemoryError
    //   137	151	286	java/lang/OutOfMemoryError
    //   159	167	286	java/lang/OutOfMemoryError
    //   175	184	286	java/lang/OutOfMemoryError
    //   192	200	286	java/lang/OutOfMemoryError
    //   208	215	286	java/lang/OutOfMemoryError
    //   223	233	286	java/lang/OutOfMemoryError
    //   44	53	294	java/io/FileNotFoundException
    //   61	67	294	java/io/FileNotFoundException
    //   75	84	294	java/io/FileNotFoundException
    //   92	98	294	java/io/FileNotFoundException
    //   106	112	294	java/io/FileNotFoundException
    //   120	129	294	java/io/FileNotFoundException
    //   137	151	294	java/io/FileNotFoundException
    //   159	167	294	java/io/FileNotFoundException
    //   175	184	294	java/io/FileNotFoundException
    //   192	200	294	java/io/FileNotFoundException
    //   208	215	294	java/io/FileNotFoundException
    //   223	233	294	java/io/FileNotFoundException
    //   26	36	306	finally
    //   326	335	306	finally
    //   339	348	306	finally
    //   352	363	306	finally
    //   367	377	306	finally
    //   446	455	306	finally
    //   459	468	306	finally
    //   472	483	306	finally
    //   487	497	306	finally
    //   26	36	314	java/lang/OutOfMemoryError
    //   385	390	392	java/io/IOException
    //   26	36	434	java/io/FileNotFoundException
    //   505	510	512	java/io/IOException
    //   534	539	542	java/io/IOException
  }
  
  public static void releaseAppIcon(String paramString)
  {
    if (paramString == null)
    {
      Logger.logI("ArkApp.ArkAppCacheMgr", "releaseAppIcon call getAppName, return");
      return;
    }
    synchronized (sAppIconCache)
    {
      ArkAppCacheMgr.ApplicationIconHolder localApplicationIconHolder = (ArkAppCacheMgr.ApplicationIconHolder)sAppIconCache.get(paramString);
      if (localApplicationIconHolder == null)
      {
        Logger.logI("ArkApp.ArkAppCacheMgr", String.format("releaseAppIcon.notfound!! appName: %s", new Object[] { paramString }));
        return;
      }
      int i = localApplicationIconHolder.refCount - 1;
      localApplicationIconHolder.refCount = i;
      if (i != 0) {
        return;
      }
      Logger.logI("ArkApp.ArkAppCacheMgr", String.format("releaseAppIcon.release!! appName: %s", new Object[] { paramString }));
      sAppIconCache.remove(paramString);
      ArkDispatchTask.getInstance().postToArkThread(new ArkAppCacheMgr.3(localApplicationIconHolder));
      return;
    }
  }
  
  public static void saveDescIconInfo(String paramString, ArkAppCacheMgr.ArkDescIconInfo paramArkDescIconInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramArkDescIconInfo == null) {
        return;
      }
      synchronized (sAppDescIconCache)
      {
        sAppDescIconCache.put(paramString, paramArkDescIconInfo);
        Object localObject = ArkEnvironmentManager.getInstance().getAppConfigCacheSharedPreferences();
        if (localObject != null)
        {
          paramArkDescIconInfo = paramArkDescIconInfo.toString();
          ((SharedPreferences)localObject).edit().putString(paramString, paramArkDescIconInfo);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ArkTemp.getAppIcon save ArkAppConfigInfo app:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",ArkAppConfigInfo:");
          ((StringBuilder)localObject).append(paramArkDescIconInfo);
          Logger.logI("ArkApp.ArkAppCacheMgr", ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr
 * JD-Core Version:    0.7.0.1
 */