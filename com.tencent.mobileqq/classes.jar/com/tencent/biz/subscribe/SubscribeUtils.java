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
import com.tencent.mobileqq.theme.ThemeUtil;
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
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 < 0)) {
      return null;
    }
    for (;;)
    {
      int k;
      int i;
      try
      {
        localObject = new HashMap();
        ((Map)localObject).put(EncodeHintType.CHARACTER_SET, "UTF-8");
        ((Map)localObject).put(EncodeHintType.MARGIN, Integer.valueOf(2));
        ((Map)localObject).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        paramString = new QRCodeWriter().a(paramString, paramInt1, paramInt1, (Map)localObject);
        if (paramString == null) {
          break;
        }
        j = paramString.a();
        k = paramString.b();
        localObject = new int[j * k];
        paramInt1 = 0;
      }
      catch (OutOfMemoryError paramString)
      {
        Object localObject;
        int j;
        QLog.e("SubscribeUtils", 4, "oom when create qr bitmap", paramString);
        return null;
        paramInt1 += 1;
        break label195;
        paramString = Bitmap.createBitmap((int[])localObject, j, k, paramConfig);
        return paramString;
      }
      catch (WriterException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      if (i < j)
      {
        if (paramString.a(i, paramInt1)) {
          localObject[(paramInt1 * j + i)] = paramInt2;
        } else {
          localObject[(paramInt1 * j + i)] = paramInt3;
        }
      }
      else
      {
        label195:
        if (paramInt1 >= k) {
          continue;
        }
        i = 0;
        continue;
      }
      i += 1;
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
    if (paramLong == 0L) {}
    Time localTime;
    int i;
    for (Object localObject1 = new Date();; localObject1 = new Date(paramLong))
    {
      localObject2 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
      localObject1 = new Time();
      ((Time)localObject1).set(paramLong);
      paramLong = System.currentTimeMillis();
      localTime = new Time();
      localTime.set(paramLong);
      i = localTime.yearDay;
      if ((((Time)localObject1).year == localTime.year) && (localTime.yearDay >= ((Time)localObject1).yearDay)) {
        break;
      }
      return localObject2;
    }
    if (localTime.yearDay == ((Time)localObject1).yearDay)
    {
      localObject2 = new StringBuilder().append(((Time)localObject1).hour).append(":");
      if (((Time)localObject1).minute < 10) {}
      for (localObject1 = "0" + ((Time)localObject1).minute;; localObject1 = Integer.valueOf(((Time)localObject1).minute)) {
        return localObject1;
      }
    }
    if (((Time)localObject1).yearDay == i - 1) {
      return BaseApplicationImpl.getApplication().getString(2131720766);
    }
    return ((Time)localObject1).month + 1 + BaseApplicationImpl.getApplication().getString(2131694236) + ((Time)localObject1).monthDay + BaseApplicationImpl.getApplication().getString(2131691528);
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +128 -> 133
    //   8: new 207	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: sipush 1024
    //   15: invokespecial 210	java/io/ByteArrayOutputStream:<init>	(I)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getstatic 216	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   25: bipush 100
    //   27: aload_2
    //   28: invokevirtual 220	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: invokevirtual 221	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 227	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: aload_2
    //   46: ifnull +13 -> 59
    //   49: aload_2
    //   50: invokevirtual 230	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_2
    //   54: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_1
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: aload_0
    //   74: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   77: aload_3
    //   78: astore_1
    //   79: aload_2
    //   80: ifnull -21 -> 59
    //   83: aload_2
    //   84: invokevirtual 230	java/io/ByteArrayOutputStream:flush	()V
    //   87: aload_2
    //   88: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +11 -> 115
    //   107: aload_1
    //   108: invokevirtual 230	java/io/ByteArrayOutputStream:flush	()V
    //   111: aload_1
    //   112: invokevirtual 233	java/io/ByteArrayOutputStream:close	()V
    //   115: aload_0
    //   116: athrow
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_0
    //   126: goto -23 -> 103
    //   129: astore_0
    //   130: goto -59 -> 71
    //   133: aconst_null
    //   134: astore_2
    //   135: aload_1
    //   136: astore_0
    //   137: goto -94 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramBitmap	Bitmap
    //   3	57	1	localObject1	Object
    //   61	2	1	localIOException1	java.io.IOException
    //   72	40	1	localObject2	Object
    //   117	19	1	localIOException2	java.io.IOException
    //   18	117	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	77	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	61	java/io/IOException
    //   8	19	68	java/lang/Exception
    //   83	91	93	java/io/IOException
    //   8	19	100	finally
    //   107	115	117	java/io/IOException
    //   21	32	125	finally
    //   34	43	125	finally
    //   73	77	125	finally
    //   21	32	129	java/lang/Exception
    //   34	43	129	java/lang/Exception
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
      ThreadManagerV2.executeOnFileThread(new SubscribeUtils.1(paramString2, new File(paramFile.getPath() + ".zip"), paramString1));
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
    boolean bool = false;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      bool = ThemeUtil.isInNightMode((QQAppInterface)localAppRuntime);
    }
    if ((localAppRuntime instanceof ToolAppRuntime)) {
      bool = ThemeUtil.isInNightMode(localAppRuntime);
    }
    return bool;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  public static boolean a(long paramLong)
  {
    return a(paramLong, 1);
  }
  
  public static boolean a(long paramLong, int paramInt)
  {
    return (1 << paramInt & paramLong) > 0L;
  }
  
  public static boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return paramStFeed.poster.followState.get() == 1;
  }
  
  public static String b(long paramLong)
  {
    DecimalFormat localDecimalFormat;
    if (paramLong >= 10000L)
    {
      localDecimalFormat = new DecimalFormat(".#");
      return localDecimalFormat.format(paramLong / 10000.0D) + "w";
    }
    if (paramLong >= 1000L)
    {
      localDecimalFormat = new DecimalFormat(".#");
      return localDecimalFormat.format(paramLong / 1000.0D) + "k";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils
 * JD-Core Version:    0.7.0.1
 */