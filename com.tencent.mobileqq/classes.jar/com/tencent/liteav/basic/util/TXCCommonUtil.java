package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;
import java.security.MessageDigest;

public class TXCCommonUtil
{
  private static final String TAG = "TXCCommonUtil";
  private static String mAppID = "";
  private static String mStrAppVersion = "";
  private static String mUserId = "";
  public static String pituLicencePath = "YTFaceSDK.licence";
  private static Context sApplicationContext;
  
  static
  {
    h.f();
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static Context getAppContext()
  {
    return sApplicationContext;
  }
  
  public static String getAppFilePath()
  {
    Object localObject = sApplicationContext;
    if (localObject != null) {
      localObject = ((Context)localObject).getFilesDir().getAbsolutePath();
    } else {
      localObject = "/sdcard/liteav";
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  public static String getAppID()
  {
    return mAppID;
  }
  
  public static String getAppNameByStreamUrl(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      int i = paramString.indexOf("?");
      String str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      if (str != null)
      {
        if (str.length() == 0) {
          return null;
        }
        i = str.lastIndexOf("/");
        paramString = str;
        if (i != -1) {
          paramString = str.substring(0, i);
        }
        if (paramString != null)
        {
          if (paramString.length() == 0) {
            return null;
          }
          i = paramString.lastIndexOf("/");
          str = paramString;
          if (i != -1) {
            str = paramString.substring(i + 1);
          }
          if (str != null)
          {
            if (str.length() == 0) {
              return null;
            }
            return str;
          }
        }
      }
    }
    return null;
  }
  
  public static String getAppPackageName()
  {
    return h.c(sApplicationContext);
  }
  
  public static String getAppVersion()
  {
    return mStrAppVersion;
  }
  
  public static String getConfigCenterKey()
  {
    return nativeGetConfigCenterKey();
  }
  
  public static final String getDeviceInfo()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.BRAND);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(Build.MODEL);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      label53:
      break label53;
    }
    return "unknown_device";
  }
  
  public static String getFileExtension(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = paramString.lastIndexOf('.');
      if ((i > -1) && (i < paramString.length() - 1)) {
        return paramString.substring(i + 1);
      }
    }
    return null;
  }
  
  public static int getGateway()
  {
    Context localContext = sApplicationContext;
    if (localContext == null) {
      return 0;
    }
    try
    {
      int i = ((WifiManager)localContext.getSystemService("wifi")).getDhcpInfo().gateway;
      return i;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCommonUtil", "getGateway error ", localException);
    }
    return 0;
  }
  
  public static String getLogUploadPath()
  {
    Object localObject = sApplicationContext;
    if (localObject == null) {
      return "";
    }
    localObject = ((Context)localObject).getExternalFilesDir(null);
    if (localObject == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append("/log/liteav");
    return localStringBuilder.toString();
  }
  
  public static String getMD5(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuffer localStringBuffer = new StringBuffer("");
      int i = 0;
      while (i < localObject.length)
      {
        int k = localObject[i];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (j < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Integer.toHexString(j));
        i += 1;
      }
      localObject = localStringBuffer.toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static byte[] getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label18:
      break label18;
    }
    return null;
  }
  
  public static int getSDKID()
  {
    return nativeGetSDKID();
  }
  
  public static int[] getSDKVersion()
  {
    String[] arrayOfString = nativeGetSDKVersion().split("\\.");
    int[] arrayOfInt = new int[arrayOfString.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      try
      {
        arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        TXCLog.e("TXCCommonUtil", "parse version failed.", localNumberFormatException);
        arrayOfInt[i] = 0;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static String getSDKVersionStr()
  {
    return nativeGetSDKVersion();
  }
  
  public static String getStreamIDByStreamUrl(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      int i = paramString.indexOf("?");
      String str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      if (str != null)
      {
        if (str.length() == 0) {
          return null;
        }
        i = str.lastIndexOf("/");
        paramString = str;
        if (i != -1) {
          paramString = str.substring(i + 1);
        }
        if (paramString != null)
        {
          if (paramString.length() == 0) {
            return null;
          }
          i = paramString.indexOf(".");
          str = paramString;
          if (i != -1) {
            str = paramString.substring(0, i);
          }
          if (str != null)
          {
            if (str.length() == 0) {
              return null;
            }
            return str;
          }
        }
      }
    }
    return null;
  }
  
  public static String getUserId()
  {
    return mUserId;
  }
  
  public static String loadString(String paramString)
  {
    Context localContext = sApplicationContext;
    if (localContext == null) {
      return "";
    }
    try
    {
      paramString = localContext.getSharedPreferences("TXCCommonConfig", 0).getString(paramString, "");
      return paramString;
    }
    catch (Exception paramString)
    {
      TXCLog.e("TXCCommonUtil", "load string failed.", paramString);
    }
    return "";
  }
  
  public static long loadUInt64(String paramString)
  {
    Context localContext = sApplicationContext;
    if (localContext == null) {
      return 0L;
    }
    try
    {
      long l = localContext.getSharedPreferences("TXCCommonConfig", 0).getLong(paramString, 0L);
      return l;
    }
    catch (Exception paramString)
    {
      TXCLog.e("TXCCommonUtil", "load uint64 failed.", paramString);
    }
    return 0L;
  }
  
  private static native String nativeGetConfigCenterKey();
  
  private static native int nativeGetSDKID();
  
  private static native String nativeGetSDKVersion();
  
  public static void saveString(String paramString1, String paramString2)
  {
    Object localObject = sApplicationContext;
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("TXCCommonConfig", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramString1)
    {
      TXCLog.e("TXCCommonUtil", "save string failed", paramString1);
    }
  }
  
  public static void saveUInt64(String paramString, long paramLong)
  {
    Object localObject = sApplicationContext;
    if (localObject == null) {
      return;
    }
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("TXCCommonConfig", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramString)
    {
      TXCLog.e("TXCCommonUtil", "save uint64 failed.", paramString);
    }
  }
  
  public static void setAppContext(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    sApplicationContext = paramContext.getApplicationContext();
  }
  
  public static void setAppID(String paramString)
  {
    mAppID = paramString;
  }
  
  public static void setAppVersion(String paramString)
  {
    mStrAppVersion = paramString;
  }
  
  public static void setPituLicencePath(String paramString)
  {
    pituLicencePath = paramString;
  }
  
  public static void setUserId(String paramString)
  {
    mUserId = paramString;
  }
  
  public static void sleep(int paramInt)
  {
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  /* Error */
  public static void zip(java.util.ArrayList<String> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 49	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_1
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore_3
    //   17: new 310	java/util/zip/ZipOutputStream
    //   20: dup
    //   21: new 312	java/io/FileOutputStream
    //   24: dup
    //   25: aload 4
    //   27: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 318	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore 4
    //   35: aload 4
    //   37: ldc_w 320
    //   40: invokevirtual 323	java/util/zip/ZipOutputStream:setComment	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 329	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   47: astore 5
    //   49: aload_3
    //   50: astore_0
    //   51: aload 5
    //   53: invokeinterface 334 1 0
    //   58: ifeq +164 -> 222
    //   61: new 49	java/io/File
    //   64: dup
    //   65: aload 5
    //   67: invokeinterface 338 1 0
    //   72: checkcast 70	java/lang/String
    //   75: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 6
    //   80: aload 6
    //   82: invokevirtual 341	java/io/File:length	()J
    //   85: lconst_0
    //   86: lcmp
    //   87: ifeq +94 -> 181
    //   90: aload 6
    //   92: invokevirtual 341	java/io/File:length	()J
    //   95: ldc2_w 342
    //   98: lcmp
    //   99: ifle +6 -> 105
    //   102: goto +79 -> 181
    //   105: new 345	java/io/FileInputStream
    //   108: dup
    //   109: aload 6
    //   111: invokespecial 346	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore_3
    //   115: aload_3
    //   116: astore_1
    //   117: aload 4
    //   119: new 348	java/util/zip/ZipEntry
    //   122: dup
    //   123: aload 6
    //   125: invokevirtual 351	java/io/File:getName	()Ljava/lang/String;
    //   128: invokespecial 352	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   131: invokevirtual 356	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   134: aload_3
    //   135: astore_1
    //   136: sipush 8192
    //   139: newarray byte
    //   141: astore 6
    //   143: aload_3
    //   144: astore_1
    //   145: aload_3
    //   146: aload 6
    //   148: invokevirtual 362	java/io/InputStream:read	([B)I
    //   151: istore_2
    //   152: aload_3
    //   153: astore_0
    //   154: iload_2
    //   155: iconst_m1
    //   156: if_icmpeq +52 -> 208
    //   159: aload_3
    //   160: astore_1
    //   161: aload 4
    //   163: aload 6
    //   165: iconst_0
    //   166: iload_2
    //   167: invokevirtual 366	java/util/zip/ZipOutputStream:write	([BII)V
    //   170: goto -27 -> 143
    //   173: astore_1
    //   174: aload_3
    //   175: astore_0
    //   176: aload_1
    //   177: astore_3
    //   178: goto +19 -> 197
    //   181: aload_0
    //   182: invokevirtual 369	java/io/InputStream:close	()V
    //   185: goto -134 -> 51
    //   188: astore_3
    //   189: aload_0
    //   190: astore_1
    //   191: aload_3
    //   192: astore_0
    //   193: goto +23 -> 216
    //   196: astore_3
    //   197: aload_0
    //   198: astore_1
    //   199: ldc 8
    //   201: ldc_w 371
    //   204: aload_3
    //   205: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: aload_0
    //   209: invokevirtual 369	java/io/InputStream:close	()V
    //   212: goto -161 -> 51
    //   215: astore_0
    //   216: aload_1
    //   217: invokevirtual 369	java/io/InputStream:close	()V
    //   220: aload_0
    //   221: athrow
    //   222: aload 4
    //   224: invokevirtual 372	java/util/zip/ZipOutputStream:close	()V
    //   227: return
    //   228: astore_0
    //   229: goto +31 -> 260
    //   232: aload 4
    //   234: astore_0
    //   235: goto +10 -> 245
    //   238: astore_0
    //   239: aload_1
    //   240: astore 4
    //   242: goto +18 -> 260
    //   245: aload_0
    //   246: astore_1
    //   247: ldc 8
    //   249: ldc_w 374
    //   252: invokestatic 377	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_0
    //   256: invokevirtual 372	java/util/zip/ZipOutputStream:close	()V
    //   259: return
    //   260: aload 4
    //   262: invokevirtual 372	java/util/zip/ZipOutputStream:close	()V
    //   265: goto +5 -> 270
    //   268: aload_0
    //   269: athrow
    //   270: goto -2 -> 268
    //   273: astore_0
    //   274: aload 5
    //   276: astore_0
    //   277: goto -32 -> 245
    //   280: astore_0
    //   281: goto -49 -> 232
    //   284: astore_1
    //   285: goto -234 -> 51
    //   288: astore_1
    //   289: goto -77 -> 212
    //   292: astore_1
    //   293: goto -73 -> 220
    //   296: astore_0
    //   297: return
    //   298: astore_1
    //   299: goto -34 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramArrayList	java.util.ArrayList<String>
    //   0	302	1	paramString	String
    //   151	16	2	i	int
    //   16	162	3	localObject1	Object
    //   188	4	3	localObject2	Object
    //   196	9	3	localException	Exception
    //   8	253	4	localObject3	Object
    //   13	262	5	localIterator	java.util.Iterator
    //   78	86	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   117	134	173	java/lang/Exception
    //   136	143	173	java/lang/Exception
    //   145	152	173	java/lang/Exception
    //   161	170	173	java/lang/Exception
    //   80	102	188	finally
    //   105	115	188	finally
    //   80	102	196	java/lang/Exception
    //   105	115	196	java/lang/Exception
    //   117	134	215	finally
    //   136	143	215	finally
    //   145	152	215	finally
    //   161	170	215	finally
    //   199	208	215	finally
    //   35	49	228	finally
    //   51	80	228	finally
    //   181	185	228	finally
    //   208	212	228	finally
    //   216	220	228	finally
    //   220	222	228	finally
    //   17	35	238	finally
    //   247	255	238	finally
    //   17	35	273	java/io/FileNotFoundException
    //   35	49	280	java/io/FileNotFoundException
    //   51	80	280	java/io/FileNotFoundException
    //   181	185	280	java/io/FileNotFoundException
    //   208	212	280	java/io/FileNotFoundException
    //   216	220	280	java/io/FileNotFoundException
    //   220	222	280	java/io/FileNotFoundException
    //   181	185	284	java/lang/Exception
    //   208	212	288	java/lang/Exception
    //   216	220	292	java/lang/Exception
    //   222	227	296	java/lang/Exception
    //   255	259	296	java/lang/Exception
    //   260	265	298	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCCommonUtil
 * JD-Core Version:    0.7.0.1
 */