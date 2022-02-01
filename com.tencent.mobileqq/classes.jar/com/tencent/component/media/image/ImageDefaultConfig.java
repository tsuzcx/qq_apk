package com.tencent.component.media.image;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class ImageDefaultConfig
{
  public static final int[][] BYTE_ARRAY;
  public static final int[][] BYTE_ARRAY_LOCAL;
  static final int[] PIC_WEIGHT;
  private static final String TAG = "ImageDefaultConfig";
  static int[] bmpCount4Picture = { 40, 2 };
  static int[] bmpCount4Qzone;
  static int[] bmpSize4Picture = { 30000, 30000 };
  static int[] bmpSize4Qzone;
  private static String sProcessName;
  private static int screenHeight = -1;
  private static int screenWidth;
  private static boolean smallScreem;
  
  static
  {
    int[] arrayOfInt = { 6, 200000 };
    BYTE_ARRAY = new int[][] { { 6, 25000 }, arrayOfInt };
    BYTE_ARRAY_LOCAL = new int[][] { { 6, 25000 }, { 6, 200000 }, { 6, 1000000 }, { 8, 6000000 } };
    screenWidth = -1;
    smallScreem = false;
    bmpCount4Qzone = new int[] { 2, 1, 1 };
    PIC_WEIGHT = new int[] { 1, 2, 2 };
    bmpSize4Qzone = new int[] { 1000, 16000, 32000 };
  }
  
  public static PoolParams.BucketParams getArtBitmapBucketParams(Context paramContext, int paramInt)
  {
    int i = getScreenWidth(paramContext);
    getScreenHeight(paramContext);
    if (isQzone(paramContext)) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return new PoolParams.BucketParams(1, 1);
      return new PoolParams.BucketParams(bmpSize4Qzone[0], bmpCount4Qzone[0]);
      return new PoolParams.BucketParams(bmpSize4Qzone[1], bmpCount4Qzone[1]);
      return new PoolParams.BucketParams(bmpSize4Qzone[2], bmpCount4Qzone[2]);
      if (isPicture(paramContext)) {
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          return new PoolParams.BucketParams(bmpSize4Picture[0], bmpCount4Picture[0]);
        case 1: 
          return new PoolParams.BucketParams(bmpSize4Picture[1], bmpCount4Picture[1]);
        }
      } else {
        switch (paramInt)
        {
        }
      }
    }
    return new PoolParams.BucketParams(16000, 1);
    int j = i * i * 4 / 9;
    i = 1048576 / j;
    paramInt = i;
    if (i < 3) {
      paramInt = i + 1;
    }
    return new PoolParams.BucketParams(j + 1000, paramInt);
  }
  
  public static int getArtBitmapPoolSize(Context paramContext)
  {
    if (isPicture(paramContext)) {}
    while (!isQzone(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  /* Error */
  private static String getProcessName(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 80	com/tencent/component/media/image/ImageDefaultConfig:sProcessName	Ljava/lang/String;
    //   6: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +73 -> 82
    //   12: invokestatic 92	android/os/Process:myPid	()I
    //   15: istore_1
    //   16: aload_0
    //   17: ldc 94
    //   19: invokevirtual 100	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 102	android/app/ActivityManager
    //   25: invokevirtual 106	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnonnull +11 -> 41
    //   33: ldc 108
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: aload_0
    //   42: invokeinterface 114 1 0
    //   47: astore_0
    //   48: aload_0
    //   49: invokeinterface 120 1 0
    //   54: ifeq +28 -> 82
    //   57: aload_0
    //   58: invokeinterface 124 1 0
    //   63: checkcast 126	android/app/ActivityManager$RunningAppProcessInfo
    //   66: astore_2
    //   67: aload_2
    //   68: getfield 129	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   71: iload_1
    //   72: if_icmpne -24 -> 48
    //   75: aload_2
    //   76: getfield 132	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   79: putstatic 80	com/tencent/component/media/image/ImageDefaultConfig:sProcessName	Ljava/lang/String;
    //   82: getstatic 80	com/tencent/component/media/image/ImageDefaultConfig:sProcessName	Ljava/lang/String;
    //   85: astore_0
    //   86: goto -50 -> 36
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    //   15	58	1	i	int
    //   66	10	2	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    // Exception table:
    //   from	to	target	type
    //   3	29	89	finally
    //   41	48	89	finally
    //   48	82	89	finally
    //   82	86	89	finally
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    int i;
    if (screenHeight <= 0)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      i = paramContext.widthPixels;
      int j = paramContext.heightPixels;
      if (i > j) {
        break label39;
      }
      i = j;
    }
    label39:
    for (;;)
    {
      screenHeight = i;
      return screenHeight;
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    int i;
    int j;
    if (screenWidth <= 0)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      i = paramContext.widthPixels;
      j = paramContext.heightPixels;
      if (i > j) {
        break label37;
      }
    }
    for (;;)
    {
      screenWidth = i;
      return screenWidth;
      label37:
      i = j;
    }
  }
  
  public static void initBmpCount4Picture(Context paramContext, int paramInt)
  {
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader----maxBitMapPool---" + paramInt });
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader--before--counts:---" + bmpCount4Picture[0] });
    int i = getScreenWidth(paramContext);
    int j = getScreenHeight(paramContext);
    bmpSize4Picture[1] = ((int)(j * i * 4 * 0.6D));
    bmpSize4Picture[0] = (i * i / 36 * 4);
    i = paramInt - (bmpSize4Picture[0] * bmpCount4Picture[0] + bmpSize4Picture[1] * bmpCount4Picture[1]);
    while (i < 0)
    {
      bmpSize4Picture[1] = ((int)(bmpSize4Picture[1] * 0.8F));
      bmpCount4Picture[0] = ((int)(bmpCount4Picture[0] * 0.8F));
      i = paramInt - (bmpSize4Picture[0] * bmpCount4Picture[0] + bmpSize4Picture[1] * bmpCount4Picture[1]);
      ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader---reduce bmp size(" + 0.8F + "),new size:" + bmpSize4Picture[0] });
    }
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader---size:" + bmpSize4Picture[0] });
    while (i > bmpSize4Picture[0])
    {
      paramContext = bmpCount4Picture;
      paramContext[0] += 1;
      i -= bmpSize4Picture[0];
    }
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader--after--counts:-bmpCount4Picture[0]--" + bmpCount4Picture[0] + "-bmpCount4Picture[1]" + bmpCount4Picture[1] + ",bmpSize4Picture[1] == " + bmpSize4Picture[1] });
  }
  
  public static void initBmpCount4Qzone(Context paramContext, int paramInt)
  {
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader----maxBitMapPool---" + paramInt });
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader--before--counts:---" + bmpCount4Qzone[0] + "," + bmpCount4Qzone[1] + "," + bmpCount4Qzone[2] });
    int i = getScreenWidth(paramContext);
    getScreenHeight(paramContext);
    bmpSize4Qzone[0] = ((int)(i * i * 4 * 0.09876543F) + 1000);
    bmpSize4Qzone[1] = ((int)(i * i * 4 * 0.1975309F) + 1000);
    bmpSize4Qzone[2] = ((int)(i * i * 4 * 0.3125F) + 1000);
    i = paramInt - (bmpSize4Qzone[0] * bmpCount4Qzone[0] + bmpSize4Qzone[1] * bmpCount4Qzone[1] + bmpSize4Qzone[2] * bmpCount4Qzone[2]);
    while (i < 0)
    {
      bmpSize4Qzone[0] = ((int)(bmpSize4Qzone[0] * 0.8F));
      bmpSize4Qzone[1] = ((int)(bmpSize4Qzone[1] * 0.8F));
      bmpSize4Qzone[2] = ((int)(bmpSize4Qzone[2] * 0.8F));
      i = paramInt - (bmpSize4Qzone[0] * bmpCount4Qzone[0] + bmpSize4Qzone[1] * bmpCount4Qzone[1] + bmpSize4Qzone[2] * bmpCount4Qzone[2]);
      ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader---reduce bmp size(" + 0.8F + "),new size:" + bmpSize4Qzone[0] + "," + bmpSize4Qzone[1] + "," + bmpSize4Qzone[2] });
    }
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader---size:" + bmpSize4Qzone[0] + ",size1:" + bmpSize4Qzone[1] + ",size2:" + bmpSize4Qzone[2] });
    paramInt = i;
    int j;
    if (paramInt > bmpSize4Qzone[0])
    {
      i = 1;
      j = 0;
      while (j < PIC_WEIGHT[2])
      {
        k = paramInt;
        if (paramInt > bmpSize4Qzone[2])
        {
          paramContext = bmpCount4Qzone;
          paramContext[2] += 1;
          k = paramInt - bmpSize4Qzone[2];
          i = 0;
        }
        j += 1;
        paramInt = k;
      }
      j = 0;
      while (j < PIC_WEIGHT[1])
      {
        k = paramInt;
        if (paramInt > bmpSize4Qzone[1])
        {
          paramContext = bmpCount4Qzone;
          paramContext[1] += 1;
          k = paramInt - bmpSize4Qzone[1];
          i = 0;
        }
        j += 1;
        paramInt = k;
      }
      int k = 0;
      j = i;
      i = k;
      label572:
      if (i < PIC_WEIGHT[0])
      {
        if ((bmpSize4Qzone[0] >= 6) || (paramInt <= bmpSize4Qzone[0])) {
          break label704;
        }
        paramContext = bmpCount4Qzone;
        paramContext[0] += 1;
        k = bmpSize4Qzone[0];
        j = 0;
        paramInt -= k;
      }
    }
    label704:
    for (;;)
    {
      i += 1;
      break label572;
      if (j == 0) {
        break;
      }
      ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader--after--counts:---" + bmpCount4Qzone[0] + "," + bmpCount4Qzone[1] + "," + bmpCount4Qzone[2] });
      return;
    }
  }
  
  public static boolean isMobileQQ(Context paramContext)
  {
    paramContext = getProcessName(paramContext);
    if (TextUtils.isEmpty(paramContext)) {}
    while (!"com.tencent.mobileqq".equals(paramContext)) {
      return false;
    }
    return true;
  }
  
  public static boolean isPicture(Context paramContext)
  {
    paramContext = getProcessName(paramContext);
    return (!TextUtils.isEmpty(paramContext)) && (("com.tencent.mobileqq:picture".equals(paramContext)) || ("com.tencent.mobileqq/cooperation.qzone.QzonePicturePluginProxyActivity".equals(paramContext)));
  }
  
  public static boolean isQzone(Context paramContext)
  {
    boolean bool = true;
    paramContext = getProcessName(paramContext);
    if (TextUtils.isEmpty(paramContext)) {}
    do
    {
      return false;
      if ("com.tencent.mobileqq:qzone".equals(paramContext)) {
        return true;
      }
      paramContext = paramContext.split("/");
    } while ((paramContext.length < 2) || (!"com.tencent.mobileqq".equals(paramContext[0])) || (TextUtils.isEmpty(paramContext[1])));
    paramContext = paramContext[1].toLowerCase().split("\\.");
    if ((paramContext.length > 0) && (paramContext[(paramContext.length - 1)].startsWith("qzone")) && (paramContext[(paramContext.length - 1)].endsWith("proxyactivity"))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageDefaultConfig
 * JD-Core Version:    0.7.0.1
 */