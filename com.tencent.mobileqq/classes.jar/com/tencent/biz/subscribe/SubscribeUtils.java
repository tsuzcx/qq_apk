package com.tencent.biz.subscribe;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class SubscribeUtils
{
  public static CertifiedAccountMeta.StFeed a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
    if (paramStFeed == null) {
      return localStFeed;
    }
    try
    {
      localStFeed.mergeFrom(paramStFeed.toByteArray());
      return localStFeed;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    return localStFeed;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    Object localObject;
    int j;
    int k;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt1 < 0) {
        return null;
      }
      try
      {
        localObject = new HashMap();
        ((Map)localObject).put(EncodeHintType.CHARACTER_SET, "UTF-8");
        ((Map)localObject).put(EncodeHintType.MARGIN, Integer.valueOf(2));
        ((Map)localObject).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        paramString = new QRCodeWriter().a(paramString, paramInt1, paramInt1, (Map)localObject);
        if (paramString == null) {
          return null;
        }
        j = paramString.a();
        k = paramString.b();
        localObject = new int[j * k];
        paramInt1 = 0;
      }
      catch (WriterException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("SubscribeUtils", 4, "oom when create qr bitmap", paramString);
      }
      if (i >= j) {
        break label208;
      }
      if (!paramString.a(i, paramInt1)) {
        break label188;
      }
      localObject[(paramInt1 * j + i)] = paramInt2;
      break label199;
    }
    label188:
    label199:
    label208:
    label213:
    for (;;)
    {
      paramString = Bitmap.createBitmap((int[])localObject, j, k, paramConfig);
      return paramString;
      return null;
      for (;;)
      {
        if (paramInt1 >= k) {
          break label213;
        }
        i = 0;
        break;
        localObject[(paramInt1 * j + i)] = paramInt3;
        i += 1;
        break;
        paramInt1 += 1;
      }
    }
  }
  
  public static String a()
  {
    return SubscribeConstants.c("certified_account_download_pics");
  }
  
  public static String a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static String a(long paramLong)
  {
    Object localObject2 = new SimpleDateFormat("yyyy年MM月dd日");
    if (paramLong == 0L) {
      localObject1 = new Date();
    } else {
      localObject1 = new Date(paramLong);
    }
    localObject2 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    paramLong = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(paramLong);
    int i = localTime2.yearDay;
    Object localObject1 = localObject2;
    if (localTime1.year == localTime2.year)
    {
      if (localTime2.yearDay < localTime1.yearDay) {
        return localObject2;
      }
      if (localTime2.yearDay == localTime1.yearDay)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localTime1.hour);
        ((StringBuilder)localObject2).append(":");
        if (localTime1.minute < 10)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append(localTime1.minute);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = Integer.valueOf(localTime1.minute);
        }
        ((StringBuilder)localObject2).append(localObject1);
        return ((StringBuilder)localObject2).toString();
      }
      if (localTime1.yearDay == i - 1) {
        return BaseApplicationImpl.getApplication().getString(2131720491);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localTime1.month + 1);
      ((StringBuilder)localObject1).append(BaseApplicationImpl.getApplication().getString(2131694201));
      ((StringBuilder)localObject1).append(localTime1.monthDay);
      ((StringBuilder)localObject1).append(BaseApplicationImpl.getApplication().getString(2131691450));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull +107 -> 110
    //   6: new 207	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 210	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_0
    //   20: getstatic 216	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   23: bipush 100
    //   25: aload_2
    //   26: invokevirtual 220	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   29: pop
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: invokevirtual 221	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   36: iconst_2
    //   37: invokestatic 227	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   40: astore_0
    //   41: aload_2
    //   42: astore_1
    //   43: goto +69 -> 112
    //   46: astore_0
    //   47: goto +12 -> 59
    //   50: astore_0
    //   51: aconst_null
    //   52: astore_1
    //   53: goto +35 -> 88
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   65: aload_2
    //   66: ifnull +19 -> 85
    //   69: aload_2
    //   70: invokevirtual 231	java/io/ByteArrayOutputStream:flush	()V
    //   73: aload_2
    //   74: invokevirtual 234	java/io/ByteArrayOutputStream:close	()V
    //   77: goto +8 -> 85
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +19 -> 108
    //   92: aload_1
    //   93: invokevirtual 231	java/io/ByteArrayOutputStream:flush	()V
    //   96: aload_1
    //   97: invokevirtual 234	java/io/ByteArrayOutputStream:close	()V
    //   100: goto +8 -> 108
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   108: aload_0
    //   109: athrow
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_1
    //   113: ifnull +18 -> 131
    //   116: aload_1
    //   117: invokevirtual 231	java/io/ByteArrayOutputStream:flush	()V
    //   120: aload_1
    //   121: invokevirtual 234	java/io/ByteArrayOutputStream:close	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 235	java/io/IOException:printStackTrace	()V
    //   131: aload_0
    //   132: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramBitmap	Bitmap
    //   1	96	1	localObject	Object
    //   103	18	1	localIOException1	java.io.IOException
    //   126	2	1	localIOException2	java.io.IOException
    //   16	58	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   19	30	46	java/lang/Exception
    //   32	41	46	java/lang/Exception
    //   6	17	50	finally
    //   6	17	56	java/lang/Exception
    //   69	77	80	java/io/IOException
    //   19	30	87	finally
    //   32	41	87	finally
    //   61	65	87	finally
    //   92	100	103	java/io/IOException
    //   116	124	126	java/io/IOException
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    View localView = new View(paramActivity);
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  public static void a(File paramFile, String paramString)
  {
    a(paramFile, paramString, SubscribeConstants.a);
  }
  
  public static void a(File paramFile, String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getPath());
      localStringBuilder.append(".zip");
      ThreadManagerV2.executeOnFileThread(new SubscribeUtils.1(paramString2, new File(localStringBuilder.toString()), paramString1));
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").postDelayed(new SubscribeUtils.2(paramString), 0L);
  }
  
  public static boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool;
    if ((localAppRuntime instanceof QQAppInterface)) {
      bool = ThemeUtil.isInNightMode((QQAppInterface)localAppRuntime);
    } else {
      bool = false;
    }
    if ((localAppRuntime instanceof ToolAppRuntime)) {
      bool = ThemeUtil.isInNightMode(localAppRuntime);
    }
    return bool;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 2)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(long paramLong)
  {
    return a(paramLong, 1);
  }
  
  public static boolean a(long paramLong, int paramInt)
  {
    return (paramLong & 1 << paramInt) > 0L;
  }
  
  public static boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return paramStFeed.poster.followState.get() == 1;
  }
  
  public static String b(long paramLong)
  {
    DecimalFormat localDecimalFormat;
    StringBuilder localStringBuilder;
    double d;
    if (paramLong >= 10000L)
    {
      localDecimalFormat = new DecimalFormat(".#");
      localStringBuilder = new StringBuilder();
      d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(localDecimalFormat.format(d / 10000.0D));
      localStringBuilder.append("w");
      return localStringBuilder.toString();
    }
    if (paramLong >= 1000L)
    {
      localDecimalFormat = new DecimalFormat(".#");
      localStringBuilder = new StringBuilder();
      d = paramLong;
      Double.isNaN(d);
      localStringBuilder.append(localDecimalFormat.format(d / 1000.0D));
      localStringBuilder.append("k");
      return localStringBuilder.toString();
    }
    return String.valueOf(paramLong);
  }
  
  public static boolean b(long paramLong)
  {
    return a(paramLong, 4);
  }
  
  public static boolean c(long paramLong)
  {
    return (a(paramLong)) && (b(paramLong));
  }
  
  public static boolean d(long paramLong)
  {
    return a(paramLong, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils
 * JD-Core Version:    0.7.0.1
 */