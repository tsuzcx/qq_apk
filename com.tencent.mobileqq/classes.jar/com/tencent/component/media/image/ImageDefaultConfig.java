package com.tencent.component.media.image;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class ImageDefaultConfig
{
  public static final int[][] BYTE_ARRAY = { { 6, 25000 }, { 6, 200000 } };
  public static final int[][] BYTE_ARRAY_LOCAL;
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  static int[] jdField_a_of_type_ArrayOfInt;
  private static int jdField_b_of_type_Int = -1;
  static final int[] jdField_b_of_type_ArrayOfInt;
  static int[] c;
  static int[] d;
  static int[] e;
  
  static
  {
    int[] arrayOfInt1 = { 6, 200000 };
    int[] arrayOfInt2 = { 6, 1000000 };
    int[] arrayOfInt3 = { 8, 6000000 };
    BYTE_ARRAY_LOCAL = new int[][] { { 6, 25000 }, arrayOfInt1, arrayOfInt2, arrayOfInt3 };
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 1, 1 };
    jdField_b_of_type_ArrayOfInt = new int[] { 1, 2, 2 };
    c = new int[] { 1000, 16000, 32000 };
    d = new int[] { 40, 2 };
    e = new int[] { 30000, 30000 };
  }
  
  /* Error */
  private static String a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 49	com/tencent/component/media/image/ImageDefaultConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +73 -> 82
    //   12: invokestatic 61	android/os/Process:myPid	()I
    //   15: istore_1
    //   16: aload_0
    //   17: ldc 63
    //   19: invokevirtual 69	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 71	android/app/ActivityManager
    //   25: invokevirtual 75	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnonnull +11 -> 41
    //   33: ldc 77
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: aload_0
    //   42: invokeinterface 83 1 0
    //   47: astore_0
    //   48: aload_0
    //   49: invokeinterface 89 1 0
    //   54: ifeq +28 -> 82
    //   57: aload_0
    //   58: invokeinterface 93 1 0
    //   63: checkcast 95	android/app/ActivityManager$RunningAppProcessInfo
    //   66: astore_2
    //   67: aload_2
    //   68: getfield 98	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   71: iload_1
    //   72: if_icmpne -24 -> 48
    //   75: aload_2
    //   76: getfield 101	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   79: putstatic 49	com/tencent/component/media/image/ImageDefaultConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   82: getstatic 49	com/tencent/component/media/image/ImageDefaultConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
      return new PoolParams.BucketParams(c[0], jdField_a_of_type_ArrayOfInt[0]);
      return new PoolParams.BucketParams(c[1], jdField_a_of_type_ArrayOfInt[1]);
      return new PoolParams.BucketParams(c[2], jdField_a_of_type_ArrayOfInt[2]);
      if (isPicture(paramContext)) {
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          return new PoolParams.BucketParams(e[0], d[0]);
        case 1: 
          return new PoolParams.BucketParams(e[1], d[1]);
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
  
  public static int getScreenHeight(Context paramContext)
  {
    int i;
    if (jdField_b_of_type_Int <= 0)
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
      jdField_b_of_type_Int = i;
      return jdField_b_of_type_Int;
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    int i;
    int j;
    if (jdField_a_of_type_Int <= 0)
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
      jdField_a_of_type_Int = i;
      return jdField_a_of_type_Int;
      label37:
      i = j;
    }
  }
  
  public static void initBmpCount4Picture(Context paramContext, int paramInt)
  {
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader----maxBitMapPool---" + paramInt });
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader--before--counts:---" + d[0] });
    int i = getScreenWidth(paramContext);
    int j = getScreenHeight(paramContext);
    e[1] = ((int)(j * i * 4 * 0.6D));
    e[0] = (i * i / 36 * 4);
    i = paramInt - (e[0] * d[0] + e[1] * d[1]);
    while (i < 0)
    {
      e[1] = ((int)(e[1] * 0.8F));
      d[0] = ((int)(d[0] * 0.8F));
      i = paramInt - (e[0] * d[0] + e[1] * d[1]);
      ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader---reduce bmp size(" + 0.8F + "),new size:" + e[0] });
    }
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader---size:" + e[0] });
    while (i > e[0])
    {
      paramContext = d;
      paramContext[0] += 1;
      i -= e[0];
    }
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader--after--counts:-bmpCount4Picture[0]--" + d[0] + "-bmpCount4Picture[1]" + d[1] + ",bmpSize4Picture[1] == " + e[1] });
  }
  
  public static void initBmpCount4Qzone(Context paramContext, int paramInt)
  {
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader----maxBitMapPool---" + paramInt });
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader--before--counts:---" + jdField_a_of_type_ArrayOfInt[0] + "," + jdField_a_of_type_ArrayOfInt[1] + "," + jdField_a_of_type_ArrayOfInt[2] });
    int i = getScreenWidth(paramContext);
    getScreenHeight(paramContext);
    c[0] = ((int)(i * i * 4 * 0.09876543F) + 1000);
    c[1] = ((int)(i * i * 4 * 0.1975309F) + 1000);
    c[2] = ((int)(i * i * 4 * 0.3125F) + 1000);
    i = paramInt - (c[0] * jdField_a_of_type_ArrayOfInt[0] + c[1] * jdField_a_of_type_ArrayOfInt[1] + c[2] * jdField_a_of_type_ArrayOfInt[2]);
    while (i < 0)
    {
      c[0] = ((int)(c[0] * 0.8F));
      c[1] = ((int)(c[1] * 0.8F));
      c[2] = ((int)(c[2] * 0.8F));
      i = paramInt - (c[0] * jdField_a_of_type_ArrayOfInt[0] + c[1] * jdField_a_of_type_ArrayOfInt[1] + c[2] * jdField_a_of_type_ArrayOfInt[2]);
      ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader---reduce bmp size(" + 0.8F + "),new size:" + c[0] + "," + c[1] + "," + c[2] });
    }
    ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader---size:" + c[0] + ",size1:" + c[1] + ",size2:" + c[2] });
    paramInt = i;
    int j;
    if (paramInt > c[0])
    {
      i = 1;
      j = 0;
      while (j < jdField_b_of_type_ArrayOfInt[2])
      {
        k = paramInt;
        if (paramInt > c[2])
        {
          paramContext = jdField_a_of_type_ArrayOfInt;
          paramContext[2] += 1;
          k = paramInt - c[2];
          i = 0;
        }
        j += 1;
        paramInt = k;
      }
      j = 0;
      while (j < jdField_b_of_type_ArrayOfInt[1])
      {
        k = paramInt;
        if (paramInt > c[1])
        {
          paramContext = jdField_a_of_type_ArrayOfInt;
          paramContext[1] += 1;
          k = paramInt - c[1];
          i = 0;
        }
        j += 1;
        paramInt = k;
      }
      int k = 0;
      j = i;
      i = k;
      label572:
      if (i < jdField_b_of_type_ArrayOfInt[0])
      {
        if ((c[0] >= 6) || (paramInt <= c[0])) {
          break label704;
        }
        paramContext = jdField_a_of_type_ArrayOfInt;
        paramContext[0] += 1;
        k = c[0];
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
      ImageManagerEnv.getLogger().d("ImageDefaultConfig", new Object[] { "---------ImageLoader--after--counts:---" + jdField_a_of_type_ArrayOfInt[0] + "," + jdField_a_of_type_ArrayOfInt[1] + "," + jdField_a_of_type_ArrayOfInt[2] });
      return;
    }
  }
  
  public static boolean isPicture(Context paramContext)
  {
    paramContext = a(paramContext);
    return (!TextUtils.isEmpty(paramContext)) && (("com.tencent.mobileqq:picture".equals(paramContext)) || ("com.tencent.mobileqq/cooperation.qzone.QzonePicturePluginProxyActivity".equals(paramContext)));
  }
  
  public static boolean isQzone(Context paramContext)
  {
    boolean bool = true;
    paramContext = a(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageDefaultConfig
 * JD-Core Version:    0.7.0.1
 */