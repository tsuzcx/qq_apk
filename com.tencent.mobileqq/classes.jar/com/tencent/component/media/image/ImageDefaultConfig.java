package com.tencent.component.media.image;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import java.util.Iterator;
import java.util.List;

public class ImageDefaultConfig
{
  public static final int[][] BYTE_ARRAY = { { 6, 25000 }, { 6, 200000 } };
  public static final int[][] BYTE_ARRAY_LOCAL = { { 6, 25000 }, { 6, 200000 }, { 6, 1000000 }, { 8, 6000000 } };
  static final int[] PIC_WEIGHT;
  private static final String TAG = "ImageDefaultConfig";
  static int[] bmpCount4Picture = { 40, 2 };
  static int[] bmpCount4Qzone;
  static int[] bmpSize4Picture = { 30000, 30000 };
  static int[] bmpSize4Qzone;
  private static String sProcessName;
  private static int screenHeight = -1;
  private static int screenWidth = -1;
  private static boolean smallScreem = false;
  
  static
  {
    bmpCount4Qzone = new int[] { 2, 1, 1 };
    PIC_WEIGHT = new int[] { 1, 2, 2 };
    bmpSize4Qzone = new int[] { 1000, 16000, 32000 };
  }
  
  public static PoolParams.BucketParams getArtBitmapBucketParams(Context paramContext, int paramInt)
  {
    int i = getScreenWidth(paramContext);
    getScreenHeight(paramContext);
    if (isQzone(paramContext))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            return new PoolParams.BucketParams(bmpSize4Qzone[2], bmpCount4Qzone[2]);
          }
        }
        else {
          return new PoolParams.BucketParams(bmpSize4Qzone[1], bmpCount4Qzone[1]);
        }
      }
      else {
        return new PoolParams.BucketParams(bmpSize4Qzone[0], bmpCount4Qzone[0]);
      }
    }
    else if (isPicture(paramContext))
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          return new PoolParams.BucketParams(bmpSize4Picture[1], bmpCount4Picture[1]);
        }
      }
      else {
        return new PoolParams.BucketParams(bmpSize4Picture[0], bmpCount4Picture[0]);
      }
    }
    else
    {
      if (paramInt == 0) {
        break label201;
      }
      if (paramInt == 1) {
        break label162;
      }
    }
    return new PoolParams.BucketParams(1, 1);
    label162:
    int j = i * i * 4 / 9;
    i = 1048576 / j;
    paramInt = i;
    if (i < 3) {
      paramInt = i + 1;
    }
    return new PoolParams.BucketParams(j + 1000, paramInt);
    label201:
    return new PoolParams.BucketParams(16000, 1);
  }
  
  public static int getArtBitmapPoolSize(Context paramContext)
  {
    boolean bool = isPicture(paramContext);
    int i = 2;
    if (bool) {
      return 2;
    }
    if (isQzone(paramContext)) {
      i = 3;
    }
    return i;
  }
  
  private static String getProcessName(Context paramContext)
  {
    try
    {
      if (TextUtils.isEmpty(sProcessName))
      {
        int i = Process.myPid();
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext == null) {
          return "unknown";
        }
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == i) {
            sProcessName = localRunningAppProcessInfo.processName;
          }
        }
      }
      paramContext = sProcessName;
      return paramContext;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if (screenHeight <= 0)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      int i = paramContext.widthPixels;
      int j = paramContext.heightPixels;
      if (i <= j) {
        i = j;
      }
      screenHeight = i;
    }
    return screenHeight;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (screenWidth <= 0)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      int j = paramContext.widthPixels;
      int k = paramContext.heightPixels;
      int i = k;
      if (j <= k) {
        i = j;
      }
      screenWidth = i;
    }
    return screenWidth;
  }
  
  public static void initBmpCount4Picture(Context paramContext, int paramInt)
  {
    Object localObject = ImageManagerEnv.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("---------ImageLoader----maxBitMapPool---");
    localStringBuilder.append(paramInt);
    ((ILog)localObject).d("ImageDefaultConfig", new Object[] { localStringBuilder.toString() });
    localObject = ImageManagerEnv.getLogger();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("---------ImageLoader--before--counts:---");
    localStringBuilder.append(bmpCount4Picture[0]);
    ((ILog)localObject).d("ImageDefaultConfig", new Object[] { localStringBuilder.toString() });
    int i = getScreenWidth(paramContext);
    int j = getScreenHeight(paramContext);
    paramContext = bmpSize4Picture;
    double d = j * i * 4;
    Double.isNaN(d);
    paramContext[1] = ((int)(d * 0.6D));
    paramContext[0] = (i * i / 36 * 4);
    i = paramContext[0];
    localObject = bmpCount4Picture;
    i = paramInt - (i * localObject[0] + paramContext[1] * localObject[1]);
    while (i < 0)
    {
      paramContext = bmpSize4Picture;
      paramContext[1] = ((int)(paramContext[1] * 0.8F));
      localObject = bmpCount4Picture;
      localObject[0] = ((int)(localObject[0] * 0.8F));
      i = paramInt - (paramContext[0] * localObject[0] + paramContext[1] * localObject[1]);
      paramContext = ImageManagerEnv.getLogger();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("---------ImageLoader---reduce bmp size(");
      ((StringBuilder)localObject).append(0.8F);
      ((StringBuilder)localObject).append("),new size:");
      ((StringBuilder)localObject).append(bmpSize4Picture[0]);
      paramContext.d("ImageDefaultConfig", new Object[] { ((StringBuilder)localObject).toString() });
    }
    paramContext = ImageManagerEnv.getLogger();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---------ImageLoader---size:");
    ((StringBuilder)localObject).append(bmpSize4Picture[0]);
    paramContext.d("ImageDefaultConfig", new Object[] { ((StringBuilder)localObject).toString() });
    for (;;)
    {
      paramContext = bmpSize4Picture;
      if (i <= paramContext[0]) {
        break;
      }
      localObject = bmpCount4Picture;
      localObject[0] += 1;
      i -= paramContext[0];
    }
    paramContext = ImageManagerEnv.getLogger();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---------ImageLoader--after--counts:-bmpCount4Picture[0]--");
    ((StringBuilder)localObject).append(bmpCount4Picture[0]);
    ((StringBuilder)localObject).append("-bmpCount4Picture[1]");
    ((StringBuilder)localObject).append(bmpCount4Picture[1]);
    ((StringBuilder)localObject).append(",bmpSize4Picture[1] == ");
    ((StringBuilder)localObject).append(bmpSize4Picture[1]);
    paramContext.d("ImageDefaultConfig", new Object[] { ((StringBuilder)localObject).toString() });
  }
  
  public static void initBmpCount4Qzone(Context paramContext, int paramInt)
  {
    Object localObject = ImageManagerEnv.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("---------ImageLoader----maxBitMapPool---");
    localStringBuilder.append(paramInt);
    ((ILog)localObject).d("ImageDefaultConfig", new Object[] { localStringBuilder.toString() });
    localObject = ImageManagerEnv.getLogger();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("---------ImageLoader--before--counts:---");
    localStringBuilder.append(bmpCount4Qzone[0]);
    localStringBuilder.append(",");
    localStringBuilder.append(bmpCount4Qzone[1]);
    localStringBuilder.append(",");
    localStringBuilder.append(bmpCount4Qzone[2]);
    ((ILog)localObject).d("ImageDefaultConfig", new Object[] { localStringBuilder.toString() });
    int i = getScreenWidth(paramContext);
    getScreenHeight(paramContext);
    paramContext = bmpSize4Qzone;
    float f = i * i * 4;
    paramContext[0] = ((int)(0.09876543F * f) + 1000);
    paramContext[1] = ((int)(0.1975309F * f) + 1000);
    paramContext[2] = ((int)(f * 0.3125F) + 1000);
    i = paramContext[0];
    localObject = bmpCount4Qzone;
    i = paramInt - (i * localObject[0] + paramContext[1] * localObject[1] + paramContext[2] * localObject[2]);
    while (i < 0)
    {
      paramContext = bmpSize4Qzone;
      paramContext[0] = ((int)(paramContext[0] * 0.8F));
      paramContext[1] = ((int)(paramContext[1] * 0.8F));
      paramContext[2] = ((int)(paramContext[2] * 0.8F));
      i = paramContext[0];
      localObject = bmpCount4Qzone;
      i = paramInt - (i * localObject[0] + paramContext[1] * localObject[1] + paramContext[2] * localObject[2]);
      paramContext = ImageManagerEnv.getLogger();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("---------ImageLoader---reduce bmp size(");
      ((StringBuilder)localObject).append(0.8F);
      ((StringBuilder)localObject).append("),new size:");
      ((StringBuilder)localObject).append(bmpSize4Qzone[0]);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(bmpSize4Qzone[1]);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(bmpSize4Qzone[2]);
      paramContext.d("ImageDefaultConfig", new Object[] { ((StringBuilder)localObject).toString() });
    }
    paramContext = ImageManagerEnv.getLogger();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---------ImageLoader---size:");
    ((StringBuilder)localObject).append(bmpSize4Qzone[0]);
    ((StringBuilder)localObject).append(",size1:");
    ((StringBuilder)localObject).append(bmpSize4Qzone[1]);
    ((StringBuilder)localObject).append(",size2:");
    ((StringBuilder)localObject).append(bmpSize4Qzone[2]);
    paramContext.d("ImageDefaultConfig", new Object[] { ((StringBuilder)localObject).toString() });
    while (i > bmpSize4Qzone[0])
    {
      int j = 0;
      paramInt = 1;
      while (j < PIC_WEIGHT[2])
      {
        paramContext = bmpSize4Qzone;
        k = i;
        if (i > paramContext[2])
        {
          localObject = bmpCount4Qzone;
          localObject[2] += 1;
          k = i - paramContext[2];
          paramInt = 0;
        }
        j += 1;
        i = k;
      }
      j = 0;
      while (j < PIC_WEIGHT[1])
      {
        paramContext = bmpSize4Qzone;
        k = i;
        if (i > paramContext[1])
        {
          localObject = bmpCount4Qzone;
          localObject[1] += 1;
          k = i - paramContext[1];
          paramInt = 0;
        }
        j += 1;
        i = k;
      }
      j = 0;
      int k = paramInt;
      while (j < PIC_WEIGHT[0])
      {
        paramContext = bmpSize4Qzone;
        int m = k;
        paramInt = i;
        if (paramContext[0] < 6)
        {
          m = k;
          paramInt = i;
          if (i > paramContext[0])
          {
            localObject = bmpCount4Qzone;
            localObject[0] += 1;
            paramInt = i - paramContext[0];
            m = 0;
          }
        }
        j += 1;
        k = m;
        i = paramInt;
      }
      if (k != 0) {
        break;
      }
    }
    paramContext = ImageManagerEnv.getLogger();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---------ImageLoader--after--counts:---");
    ((StringBuilder)localObject).append(bmpCount4Qzone[0]);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(bmpCount4Qzone[1]);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(bmpCount4Qzone[2]);
    paramContext.d("ImageDefaultConfig", new Object[] { ((StringBuilder)localObject).toString() });
  }
  
  public static boolean isMobileQQ(Context paramContext)
  {
    paramContext = getProcessName(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return false;
    }
    return "com.tencent.mobileqq".equals(paramContext);
  }
  
  public static boolean isPicture(Context paramContext)
  {
    paramContext = getProcessName(paramContext);
    return (!TextUtils.isEmpty(paramContext)) && (("com.tencent.mobileqq:picture".equals(paramContext)) || ("com.tencent.mobileqq/cooperation.qzone.QzonePicturePluginProxyActivity".equals(paramContext)));
  }
  
  public static boolean isQzone(Context paramContext)
  {
    paramContext = getProcessName(paramContext);
    boolean bool1 = TextUtils.isEmpty(paramContext);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ("com.tencent.mobileqq:qzone".equals(paramContext)) {
      return true;
    }
    paramContext = paramContext.split("/");
    if (paramContext.length < 2) {
      return false;
    }
    bool1 = bool2;
    if ("com.tencent.mobileqq".equals(paramContext[0]))
    {
      if (TextUtils.isEmpty(paramContext[1])) {
        return false;
      }
      paramContext = paramContext[1].toLowerCase().split("\\.");
      bool1 = bool2;
      if (paramContext.length > 0)
      {
        bool1 = bool2;
        if (paramContext[(paramContext.length - 1)].startsWith("qzone"))
        {
          bool1 = bool2;
          if (paramContext[(paramContext.length - 1)].endsWith("proxyactivity")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ImageDefaultConfig
 * JD-Core Version:    0.7.0.1
 */