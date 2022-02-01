package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class h
{
  public static long a = 0L;
  private static boolean b = true;
  private static String c = "";
  private static int d = 0;
  private static long e = 0L;
  private static boolean f = false;
  private static a<b> g = new a(new h.1());
  private static final Object h = new Object();
  private static boolean i = false;
  private static int[] j = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  
  public static int a(int paramInt)
  {
    int k = 0;
    for (;;)
    {
      int[] arrayOfInt = j;
      if ((k >= arrayOfInt.length) || (arrayOfInt[k] == paramInt)) {
        break;
      }
      k += 1;
    }
    paramInt = k;
    if (k >= j.length) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  @TargetApi(16)
  public static MediaFormat a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = a(paramInt1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.put(0, (byte)(paramInt3 << 3 | k >> 1));
    localByteBuffer.put(1, (byte)((k & 0x1) << 7 | paramInt2 << 3));
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
    localMediaFormat.setInteger("channel-count", paramInt2);
    localMediaFormat.setInteger("sample-rate", paramInt1);
    localMediaFormat.setByteBuffer("csd-0", localByteBuffer);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  public static MediaFormat a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    paramInt1 = 0;
    int i3 = 0;
    paramInt2 = 0;
    int k = 0;
    int i4;
    for (int i2 = 0;; i2 = i4)
    {
      int i1 = paramInt1 + 3;
      if (i1 >= paramArrayOfByte.length) {
        break;
      }
      if ((paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 0) && (paramArrayOfByte[(paramInt1 + 2)] == 1)) {
        n = 3;
      } else {
        n = 0;
      }
      int m = n;
      if (paramArrayOfByte[paramInt1] == 0)
      {
        m = n;
        if (paramArrayOfByte[(paramInt1 + 1)] == 0)
        {
          m = n;
          if (paramArrayOfByte[(paramInt1 + 2)] == 0)
          {
            m = n;
            if (paramArrayOfByte[i1] == 1) {
              m = 4;
            }
          }
        }
      }
      i1 = paramInt1;
      int n = i3;
      int i6 = paramInt2;
      int i5 = k;
      i4 = i2;
      if (m > 0) {
        if (i3 == 0)
        {
          i1 = paramInt1 + m;
          n = m;
          i6 = paramInt2;
          i5 = k;
          i4 = i2;
        }
        else
        {
          i1 = paramArrayOfByte[i3] & 0x1F;
          if (i1 == 7)
          {
            a("csd-0", localMediaFormat, paramArrayOfByte, i3, paramInt1);
            n = 1;
          }
          else
          {
            n = paramInt2;
            if (i1 == 8)
            {
              a("csd-1", localMediaFormat, paramArrayOfByte, i3, paramInt1);
              k = 1;
              n = paramInt2;
            }
          }
          paramInt2 = paramInt1 + m;
          if ((n != 0) && (k != 0)) {
            return localMediaFormat;
          }
          i1 = paramInt2;
          i4 = paramInt1;
          i5 = k;
          i6 = n;
          n = paramInt2;
        }
      }
      paramInt1 = i1 + 1;
      i3 = n;
      paramInt2 = i6;
      k = i5;
    }
    paramInt1 = paramArrayOfByte[i3] & 0x1F;
    if ((paramInt2 != 0) && (paramInt1 == 8))
    {
      a("csd-1", localMediaFormat, paramArrayOfByte, i3, i2);
      return localMediaFormat;
    }
    if ((k != 0) && (paramInt1 == 7))
    {
      a("csd-0", localMediaFormat, paramArrayOfByte, i3, i2);
      return localMediaFormat;
    }
    return null;
  }
  
  public static com.tencent.liteav.basic.opengl.a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = paramInt1 * paramInt4;
    int m = paramInt2 * paramInt3;
    if (k >= m)
    {
      paramInt3 = m / paramInt4;
      paramInt4 = paramInt2;
    }
    else
    {
      paramInt4 = k / paramInt3;
      paramInt3 = paramInt1;
    }
    k = 0;
    if (paramInt1 > paramInt3) {
      paramInt1 = paramInt1 - paramInt3 >> 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 > paramInt4) {
      k = paramInt2 - paramInt4 >> 1;
    }
    return new com.tencent.liteav.basic.opengl.a(paramInt1, k, paramInt3, paramInt4);
  }
  
  private static void a(String paramString, MediaFormat paramMediaFormat, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2);
    localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
    localByteBuffer.position(0);
    paramMediaFormat.setByteBuffer(paramString, localByteBuffer);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference, int paramInt, Bundle paramBundle)
  {
    if (paramWeakReference == null) {
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.c.b)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference, int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    a(paramWeakReference, paramInt, localBundle);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference, String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramWeakReference == null) {
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.c.b)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      paramBundle.putString("EVT_USERID", paramString);
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", paramString1);
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    localBundle.putLong("EVT_BLOCK_DURATION", paramLong);
    if (paramString2 != null) {
      localBundle.putCharSequence("EVT_MSG", paramString2);
    }
    a(paramWeakReference, paramInt, localBundle);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      List localList = ((ActivityManager)localObject).getRunningTasks(1);
      if (localList == null)
      {
        TXCLog.e("TXCSystemUtil", "running task is null, ams is abnormal!!!");
        return false;
      }
      localObject = (ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0);
      if ((localObject != null) && (((ActivityManager.RunningTaskInfo)localObject).topActivity != null)) {
        return ((ActivityManager.RunningTaskInfo)localObject).topActivity.getPackageName().equals(paramContext.getPackageName()) ^ true;
      }
      TXCLog.e("TXCSystemUtil", "failed to get RunningTaskInfo");
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("load library ");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(" from system path ");
      Log.w("Native-LiteAV", localStringBuilder1.toString());
      System.loadLibrary(paramString);
      return true;
    }
    catch (Exception localException) {}catch (Error localError)
    {
      break label95;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("load library : ");
    localStringBuilder2.append(localError.toString());
    Log.w("Native-LiteAV", localStringBuilder2.toString());
    return b(c, paramString);
    label95:
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("load library : ");
    localStringBuilder2.append(localError.toString());
    Log.w("Native-LiteAV", localStringBuilder2.toString());
    return b(c, paramString);
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +235 -> 236
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore_3
    //   15: aconst_null
    //   16: astore 5
    //   18: new 279	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 281	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 285	java/io/File:exists	()Z
    //   29: ifne +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: new 287	android/media/MediaMetadataRetriever
    //   37: dup
    //   38: invokespecial 288	android/media/MediaMetadataRetriever:<init>	()V
    //   41: astore_2
    //   42: aload 6
    //   44: astore_3
    //   45: aload_2
    //   46: astore 4
    //   48: aload_2
    //   49: aload_0
    //   50: invokevirtual 291	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   53: aload 6
    //   55: astore_3
    //   56: aload_2
    //   57: astore 4
    //   59: aload_2
    //   60: invokevirtual 295	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   63: astore 7
    //   65: aload 6
    //   67: astore_3
    //   68: aload_2
    //   69: astore 4
    //   71: new 279	java/io/File
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 281	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore_0
    //   80: aload 6
    //   82: astore_3
    //   83: aload_2
    //   84: astore 4
    //   86: aload_0
    //   87: invokevirtual 285	java/io/File:exists	()Z
    //   90: ifeq +14 -> 104
    //   93: aload 6
    //   95: astore_3
    //   96: aload_2
    //   97: astore 4
    //   99: aload_0
    //   100: invokevirtual 298	java/io/File:delete	()Z
    //   103: pop
    //   104: aload 6
    //   106: astore_3
    //   107: aload_2
    //   108: astore 4
    //   110: new 300	java/io/FileOutputStream
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 303	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   118: astore_0
    //   119: aload 7
    //   121: getstatic 309	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   124: bipush 100
    //   126: aload_0
    //   127: invokevirtual 315	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   130: pop
    //   131: aload_0
    //   132: invokevirtual 318	java/io/FileOutputStream:flush	()V
    //   135: aload_0
    //   136: invokevirtual 321	java/io/FileOutputStream:close	()V
    //   139: aload_2
    //   140: invokevirtual 324	android/media/MediaMetadataRetriever:release	()V
    //   143: iconst_1
    //   144: ireturn
    //   145: astore_1
    //   146: aload_0
    //   147: astore_3
    //   148: aload_1
    //   149: astore_0
    //   150: goto +65 -> 215
    //   153: astore_1
    //   154: goto +22 -> 176
    //   157: astore_1
    //   158: aload 5
    //   160: astore_0
    //   161: goto +15 -> 176
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_2
    //   167: goto +48 -> 215
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_2
    //   173: aload 5
    //   175: astore_0
    //   176: aload_0
    //   177: astore_3
    //   178: aload_2
    //   179: astore 4
    //   181: ldc 203
    //   183: ldc_w 326
    //   186: aload_1
    //   187: invokestatic 329	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: aload_0
    //   191: ifnull +10 -> 201
    //   194: aload_0
    //   195: invokevirtual 321	java/io/FileOutputStream:close	()V
    //   198: goto +3 -> 201
    //   201: aload_2
    //   202: ifnull +7 -> 209
    //   205: aload_2
    //   206: invokevirtual 324	android/media/MediaMetadataRetriever:release	()V
    //   209: iconst_0
    //   210: ireturn
    //   211: astore_0
    //   212: aload 4
    //   214: astore_2
    //   215: aload_3
    //   216: ifnull +10 -> 226
    //   219: aload_3
    //   220: invokevirtual 321	java/io/FileOutputStream:close	()V
    //   223: goto +3 -> 226
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 324	android/media/MediaMetadataRetriever:release	()V
    //   234: aload_0
    //   235: athrow
    //   236: iconst_0
    //   237: ireturn
    //   238: astore_0
    //   239: goto -100 -> 139
    //   242: astore_0
    //   243: goto -42 -> 201
    //   246: astore_1
    //   247: goto -21 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramString1	String
    //   0	250	1	paramString2	String
    //   41	190	2	localObject1	Object
    //   14	206	3	localObject2	Object
    //   46	167	4	localObject3	Object
    //   16	158	5	localObject4	Object
    //   11	94	6	localObject5	Object
    //   63	57	7	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   119	135	145	finally
    //   119	135	153	java/lang/Exception
    //   48	53	157	java/lang/Exception
    //   59	65	157	java/lang/Exception
    //   71	80	157	java/lang/Exception
    //   86	93	157	java/lang/Exception
    //   99	104	157	java/lang/Exception
    //   110	119	157	java/lang/Exception
    //   18	32	164	finally
    //   34	42	164	finally
    //   18	32	170	java/lang/Exception
    //   34	42	170	java/lang/Exception
    //   48	53	211	finally
    //   59	65	211	finally
    //   71	80	211	finally
    //   86	93	211	finally
    //   99	104	211	finally
    //   110	119	211	finally
    //   181	190	211	finally
    //   135	139	238	java/io/IOException
    //   194	198	242	java/io/IOException
    //   219	223	246	java/io/IOException
  }
  
  public static int[] a()
  {
    if (b)
    {
      b = false;
      ((b)g.a()).a();
      return new int[] { 0, 0 };
    }
    return ((b)g.a()).a();
  }
  
  public static int b()
  {
    if ((!f) && ((e == 0L) || (TXCTimeUtil.getTimeTick() - e >= 15000L)))
    {
      f = true;
      try
      {
        AsyncTask.execute(new h.2());
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAppMemory error : ");
        localStringBuilder.append(localThrowable);
        TXCLog.e("TXCSystemUtil", localStringBuilder.toString());
      }
      return d;
    }
    return d;
  }
  
  public static String b(Context paramContext)
  {
    return TXCDRApi.getSimulateIDFA(paramContext);
  }
  
  public static void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLibraryPath ");
    localStringBuilder.append(paramString);
    Log.w("Native-LiteAV", localStringBuilder.toString());
    c = paramString;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load library ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" from path ");
        localStringBuilder.append(paramString1);
        Log.w("Native-LiteAV", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("/lib");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(".so");
        System.load(localStringBuilder.toString());
        return true;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("load library : ");
      paramString2.append(paramString1.toString());
      Log.w("Native-LiteAV", paramString2.toString());
      return false;
    }
    catch (Error paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("load library : ");
      paramString2.append(paramString1.toString());
      Log.w("Native-LiteAV", paramString2.toString());
    }
    return false;
  }
  
  public static String c()
  {
    return Build.MODEL;
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label22:
      break label22;
    }
    return "";
  }
  
  public static String d()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      System.currentTimeMillis();
      if (paramContext != null)
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.isAvailable();
          return bool;
        }
      }
    }
    catch (Exception paramContext)
    {
      label33:
      break label33;
    }
    return false;
  }
  
  public static int e(Context paramContext)
  {
    int k = 0;
    if (paramContext == null) {
      return 0;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    paramContext = null;
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      paramContext = (Context)localObject;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCSystemUtil", "getNetworkType: error occurred.", localException);
    }
    if (paramContext == null) {
      return 0;
    }
    if (!paramContext.isConnected()) {
      return 0;
    }
    if (paramContext.getType() == 9) {
      return 5;
    }
    if (paramContext.getType() == 1) {
      return 1;
    }
    if (paramContext.getType() == 0)
    {
      k = 2;
      try
      {
        int m = localTelephonyManager.getNetworkType();
        switch (m)
        {
        case 13: 
        default: 
          return 2;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          return 3;
        }
        return 4;
      }
      catch (Exception paramContext)
      {
        TXCLog.e("TXCSystemUtil", "getNetworkType: error occurred.", paramContext);
      }
    }
    return k;
  }
  
  public static String e()
  {
    return UUID.randomUUID().toString();
  }
  
  public static String f(Context paramContext)
  {
    return TXCDRApi.getDevUUID(paramContext, TXCDRApi.getSimulateIDFA(paramContext));
  }
  
  public static boolean f()
  {
    synchronized (h)
    {
      if (!i)
      {
        bool = a("txffmpeg");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load library txffmpeg ");
        localStringBuilder.append(bool);
        Log.w("Native-LiteAV", localStringBuilder.toString());
        bool = a("traeimp-rtmp");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load library traeimp-rtmp ");
        localStringBuilder.append(bool);
        Log.w("Native-LiteAV", localStringBuilder.toString());
        i = a("liteavsdk");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load library liteavsdk ");
        localStringBuilder.append(i);
        Log.w("Native-LiteAV", localStringBuilder.toString());
      }
      boolean bool = i;
      return bool;
    }
  }
  
  public static int g(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      int k = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
      return k;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String g()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.h
 * JD-Core Version:    0.7.0.1
 */