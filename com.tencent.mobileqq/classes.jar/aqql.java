import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.zip.InflaterInputStream;

@TargetApi(9)
public class aqql
{
  public static boolean a;
  public static boolean b = true;
  
  public static int a(Context paramContext)
  {
    return a(paramContext).getInt("qcamera_conf_version", 0);
  }
  
  public static int a(aqpp paramaqpp, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = 0;
    }
    Camera.CameraInfo localCameraInfo = paramaqpp.a()[paramInt1];
    if (localCameraInfo.facing == 1) {
      return (paramaqpp.a().a(paramInt1, localCameraInfo.orientation) - i + 360) % 360;
    }
    return (paramaqpp.a().a(paramInt1, localCameraInfo.orientation) + i) % 360;
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qcamera_pref", 4);
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio bmpWidth=" + j + " bmpHeight=" + i + " screenWidth=" + bdep.a + " screenHeight=" + bdep.b);
    }
    if (i < j) {
      return paramBitmap;
    }
    double d = bdep.b * 1.0D / bdep.a;
    if (d > i * 1.0D / j)
    {
      k = (int)(i / d);
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio targetWidth=" + k + " bmpWidth=" + j);
      }
      return Bitmap.createBitmap(paramBitmap, 0, 0, k, i);
    }
    int k = (int)(d * j);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio targetHeight=" + k + " bmpHeight=" + i);
    }
    return Bitmap.createBitmap(paramBitmap, 0, 0, j, k);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if ((paramInt == 0) || (paramInt == 360)) {
        return paramBitmap;
      }
      Object localObject1 = new Matrix();
      ((Matrix)localObject1).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
        if ((paramBoolean) && (paramBitmap != localObject1)) {}
        localOutOfMemoryError1.printStackTrace();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          a(paramBitmap);
          return localObject1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            paramBitmap = localOutOfMemoryError1;
            Object localObject2 = localOutOfMemoryError2;
          }
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        paramBitmap = null;
      }
      QLog.w("Q.camera.CameraUtils", 2, "OutOfMemoryError. ", localOutOfMemoryError1);
      return paramBitmap;
    }
    return null;
  }
  
  @TargetApi(10)
  public static Bitmap a(byte[] paramArrayOfByte, Rect paramRect, boolean paramBoolean, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    double d4;
    double d5;
    double d1;
    double d2;
    double d3;
    if (j > i)
    {
      paramInt = 1;
      d4 = 1.0D * Math.max(i, j) / Math.min(i, j);
      d5 = 1.0D * paramRect.height() / paramRect.width();
      d1 = j;
      d2 = i;
      if (d4 <= d5) {
        break label337;
      }
      if (paramInt == 0) {
        break label319;
      }
      d3 = d5 * d2;
      d1 = d2;
      d2 = d3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "clipJpegToBitmap tw=" + d2 + " th=" + d1 + " bw=" + j + " bh=" + i + " br=" + d4 + " sr=" + d5);
      }
      localOptions.inJustDecodeBounds = false;
      d3 = (j - d2) / 2.0D;
      d4 = (j + d2) / 2.0D;
      d5 = (i - d1) / 2.0D;
      double d6 = (i + d1) / 2.0D;
      if (Build.VERSION.SDK_INT >= 10)
      {
        paramRect = new Rect((int)d3, (int)d5, (int)d4, (int)d6);
        paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
        paramRect = paramArrayOfByte.decodeRegion(paramRect, localOptions);
        paramArrayOfByte.recycle();
        return paramRect;
        paramInt = 0;
        break;
        label319:
        d3 = d5 * d1;
        d2 = d1;
        d1 = d3;
        continue;
        label337:
        if (d4 >= d5) {
          break label451;
        }
        if (paramInt != 0)
        {
          d3 = 1.0D / d5 * d1;
          d2 = d1;
          d1 = d3;
          continue;
        }
        d3 = 1.0D / d5 * d2;
        d1 = d2;
        d2 = d3;
        continue;
      }
      try
      {
        localOptions.inSampleSize = 2;
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        paramRect = Bitmap.createBitmap(paramArrayOfByte, (int)(d3 / 2.0D), (int)(d5 / 2.0D), (int)(d2 / 2.0D), (int)(d1 / 2.0D));
        paramArrayOfByte.recycle();
        return paramRect;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        throw paramArrayOfByte;
      }
      label451:
      d3 = d1;
      d1 = d2;
      d2 = d3;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext).edit().putInt("qcamera_conf_version", paramInt).commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean("disableCameraSDK", paramBoolean);
  }
  
  public static void a(Matrix paramMatrix, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramMatrix.reset();
    int i;
    int j;
    if (paramInt2 < paramInt3)
    {
      i = 1;
      j = paramInt2;
      if (i != 0)
      {
        j = paramInt2;
        if (paramInt4 != 0) {
          j = paramInt3 * paramInt5 / paramInt4;
        }
      }
      if (!paramBoolean) {
        break label103;
      }
    }
    label103:
    for (float f = -1.0F;; f = 1.0F)
    {
      paramMatrix.setScale(f, 1.0F);
      paramMatrix.postRotate(paramInt1);
      paramMatrix.postScale(j / 2000.0F, paramInt3 / 2000.0F);
      paramMatrix.postTranslate(j / 2.0F, paramInt3 / 2.0F);
      return;
      i = 0;
      break;
    }
  }
  
  public static boolean a()
  {
    int i = 2;
    Object localObject;
    boolean bool1;
    if (b)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] + ENTER");
      }
      localObject = aqqk.a().a();
      String str = aqqk.a().b();
      QLog.i("Q.camera.CameraUtils", 1, "My Phone: " + (String)localObject + ",  Model: " + str);
      bool1 = aqqj.a().c();
      boolean bool2 = b();
      if ((!bool1) && (bool2)) {
        break label277;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 0, qcameraDisabled=" + bool1 + " sysVerSupported=" + bool2);
      }
      if (bool1) {
        i = 1;
      }
      bool1 = false;
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      bdmc.a(BaseApplication.getContext()).a(null, "qcamera_choice_type", false, 0L, 0L, (HashMap)localObject, "");
      QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera: " + bool1 + " choiceResult: " + i);
      a = bool1;
      b = false;
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera final: " + a);
      }
      return a;
      label277:
      if (aqqj.a().a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 1");
        }
        bool1 = false;
        i = 3;
      }
      else if (c())
      {
        bool1 = true;
        i = 10;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 3");
        }
        bool1 = false;
        i = 4;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext).getBoolean("disableCameraSDK", true);
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    a(a(paramContext), paramString, paramInt);
    aqqj.a().a(true);
    b = true;
    return true;
  }
  
  /* Error */
  private static boolean a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 76
    //   2: iconst_4
    //   3: ldc_w 377
    //   6: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_1
    //   10: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +14 -> 27
    //   16: ldc 76
    //   18: iconst_4
    //   19: ldc_w 385
    //   22: invokestatic 388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: iconst_0
    //   26: ireturn
    //   27: iconst_0
    //   28: invokestatic 393	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: astore 6
    //   33: aload 6
    //   35: astore 5
    //   37: invokestatic 398	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   40: invokevirtual 402	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   43: astore 7
    //   45: aload 6
    //   47: astore 5
    //   49: aload 7
    //   51: new 404	java/io/StringReader
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 407	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   59: invokeinterface 413 2 0
    //   64: aload 6
    //   66: astore 5
    //   68: aload 7
    //   70: invokeinterface 416 1 0
    //   75: istore_3
    //   76: aload 6
    //   78: astore 5
    //   80: aload_0
    //   81: invokeinterface 238 1 0
    //   86: astore 8
    //   88: aload 6
    //   90: astore 5
    //   92: aload 8
    //   94: invokeinterface 419 1 0
    //   99: pop
    //   100: aload 6
    //   102: astore 5
    //   104: aload 8
    //   106: ldc 21
    //   108: iload_2
    //   109: invokeinterface 244 3 0
    //   114: pop
    //   115: aload 6
    //   117: astore 5
    //   119: invokestatic 282	aqqk:a	()Laqqk;
    //   122: invokevirtual 284	aqqk:a	()Ljava/lang/String;
    //   125: astore 9
    //   127: aload 6
    //   129: astore 5
    //   131: new 78	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   138: aload 9
    //   140: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 421
    //   146: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: getstatic 426	android/os/Build:DISPLAY	Ljava/lang/String;
    //   152: ldc_w 428
    //   155: ldc_w 421
    //   158: invokevirtual 432	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   161: invokevirtual 435	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   164: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 10
    //   172: aload 6
    //   174: astore 5
    //   176: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +733 -> 912
    //   182: aload 6
    //   184: astore 5
    //   186: ldc 76
    //   188: iconst_4
    //   189: new 78	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 437
    //   199: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 9
    //   204: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 439
    //   210: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 10
    //   215: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: goto +688 -> 912
    //   227: aload_0
    //   228: astore 5
    //   230: aload 7
    //   232: invokeinterface 442 1 0
    //   237: istore_2
    //   238: goto +682 -> 920
    //   241: goto -14 -> 227
    //   244: aload 7
    //   246: invokeinterface 445 1 0
    //   251: astore_1
    //   252: aload_1
    //   253: aload 9
    //   255: invokevirtual 449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   258: ifeq +341 -> 599
    //   261: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +51 -> 315
    //   267: ldc 76
    //   269: iconst_4
    //   270: new 78	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 451
    //   280: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_1
    //   284: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 453
    //   290: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload 9
    //   295: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc_w 439
    //   301: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 10
    //   306: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 7
    //   317: invokeinterface 459 1 0
    //   322: istore_3
    //   323: iconst_0
    //   324: istore_2
    //   325: iload_2
    //   326: iload_3
    //   327: if_icmpge +262 -> 589
    //   330: aload 7
    //   332: iload_2
    //   333: invokeinterface 462 2 0
    //   338: astore_1
    //   339: aload 7
    //   341: iload_2
    //   342: invokeinterface 465 2 0
    //   347: astore 5
    //   349: aload_1
    //   350: ldc 250
    //   352: invokevirtual 449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   355: ifeq +74 -> 429
    //   358: aload 5
    //   360: invokestatic 468	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   363: invokestatic 393	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   366: invokevirtual 471	java/lang/Boolean:booleanValue	()Z
    //   369: istore 4
    //   371: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +585 -> 959
    //   377: ldc 76
    //   379: iconst_4
    //   380: new 78	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 473
    //   390: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: iload_2
    //   394: iconst_1
    //   395: iadd
    //   396: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: ldc_w 475
    //   402: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_1
    //   406: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 477
    //   412: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload 5
    //   417: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: goto +533 -> 959
    //   429: aload_1
    //   430: ldc_w 479
    //   433: invokevirtual 482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   436: ifeq +40 -> 476
    //   439: aload 8
    //   441: aload_1
    //   442: aload 5
    //   444: invokestatic 488	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   447: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: invokevirtual 494	java/lang/Integer:intValue	()I
    //   453: invokeinterface 244 3 0
    //   458: pop
    //   459: goto -88 -> 371
    //   462: astore_0
    //   463: ldc 76
    //   465: iconst_1
    //   466: aload_0
    //   467: iconst_0
    //   468: anewarray 4	java/lang/Object
    //   471: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   474: aload_0
    //   475: athrow
    //   476: aload_1
    //   477: ldc_w 499
    //   480: invokevirtual 482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   483: ifeq +34 -> 517
    //   486: aload 8
    //   488: aload_1
    //   489: aload 5
    //   491: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   494: invokeinterface 506 3 0
    //   499: pop
    //   500: goto -129 -> 371
    //   503: astore_0
    //   504: ldc 76
    //   506: iconst_1
    //   507: aload_0
    //   508: iconst_0
    //   509: anewarray 4	java/lang/Object
    //   512: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   515: aload_0
    //   516: athrow
    //   517: aload 8
    //   519: aload_1
    //   520: aload 5
    //   522: invokestatic 468	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   525: invokestatic 393	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   528: invokevirtual 471	java/lang/Boolean:booleanValue	()Z
    //   531: invokeinterface 254 3 0
    //   536: pop
    //   537: goto -166 -> 371
    //   540: astore_1
    //   541: ldc 76
    //   543: iconst_1
    //   544: aload_1
    //   545: iconst_0
    //   546: anewarray 4	java/lang/Object
    //   549: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   552: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +29 -> 584
    //   558: ldc 76
    //   560: iconst_4
    //   561: new 78	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 508
    //   571: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_0
    //   575: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: aload_0
    //   585: invokevirtual 471	java/lang/Boolean:booleanValue	()Z
    //   588: ireturn
    //   589: iconst_1
    //   590: invokestatic 393	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   593: astore_1
    //   594: aload_1
    //   595: astore_0
    //   596: goto -369 -> 227
    //   599: ldc_w 513
    //   602: aload_1
    //   603: invokevirtual 449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   606: ifeq +350 -> 956
    //   609: aload 7
    //   611: invokeinterface 459 1 0
    //   616: istore_3
    //   617: iconst_0
    //   618: istore_2
    //   619: iload_2
    //   620: iload_3
    //   621: if_icmpge +352 -> 973
    //   624: aload 7
    //   626: iload_2
    //   627: invokeinterface 462 2 0
    //   632: astore_1
    //   633: aload 7
    //   635: iload_2
    //   636: invokeinterface 465 2 0
    //   641: astore 5
    //   643: aload_1
    //   644: ldc 250
    //   646: invokevirtual 449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   649: ifeq +74 -> 723
    //   652: aload 5
    //   654: invokestatic 468	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   657: invokestatic 393	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   660: invokevirtual 471	java/lang/Boolean:booleanValue	()Z
    //   663: istore 4
    //   665: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +298 -> 966
    //   671: ldc 76
    //   673: iconst_4
    //   674: new 78	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 515
    //   684: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: iload_2
    //   688: iconst_1
    //   689: iadd
    //   690: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: ldc_w 475
    //   696: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload_1
    //   700: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: ldc_w 477
    //   706: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload 5
    //   711: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   720: goto +246 -> 966
    //   723: aload_1
    //   724: ldc_w 479
    //   727: invokevirtual 482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   730: ifeq +26 -> 756
    //   733: aload 8
    //   735: aload_1
    //   736: aload 5
    //   738: invokestatic 488	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   741: invokestatic 491	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: invokevirtual 494	java/lang/Integer:intValue	()I
    //   747: invokeinterface 244 3 0
    //   752: pop
    //   753: goto -88 -> 665
    //   756: aload_1
    //   757: ldc_w 499
    //   760: invokevirtual 482	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   763: ifeq +20 -> 783
    //   766: aload 8
    //   768: aload_1
    //   769: aload 5
    //   771: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   774: invokeinterface 506 3 0
    //   779: pop
    //   780: goto -115 -> 665
    //   783: aload 8
    //   785: aload_1
    //   786: aload 5
    //   788: invokestatic 468	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   791: invokestatic 393	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   794: invokevirtual 471	java/lang/Boolean:booleanValue	()Z
    //   797: invokeinterface 254 3 0
    //   802: pop
    //   803: goto -138 -> 665
    //   806: aload_0
    //   807: invokevirtual 471	java/lang/Boolean:booleanValue	()Z
    //   810: ifeq +53 -> 863
    //   813: aload 8
    //   815: ldc 250
    //   817: iload 4
    //   819: invokeinterface 254 3 0
    //   824: pop
    //   825: ldc 76
    //   827: iconst_1
    //   828: new 78	java/lang/StringBuilder
    //   831: dup
    //   832: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   835: ldc_w 517
    //   838: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: iload 4
    //   843: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   846: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   852: aload 8
    //   854: invokeinterface 247 1 0
    //   859: pop
    //   860: goto -308 -> 552
    //   863: aload 8
    //   865: ldc 250
    //   867: iload 4
    //   869: invokeinterface 254 3 0
    //   874: pop
    //   875: ldc 76
    //   877: iconst_1
    //   878: new 78	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   885: ldc_w 519
    //   888: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: iload 4
    //   893: invokevirtual 301	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   896: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: goto -50 -> 852
    //   905: astore_1
    //   906: aload 5
    //   908: astore_0
    //   909: goto -368 -> 541
    //   912: aload 6
    //   914: astore_0
    //   915: iconst_0
    //   916: istore 4
    //   918: iload_3
    //   919: istore_2
    //   920: iload_2
    //   921: iconst_1
    //   922: if_icmpeq -116 -> 806
    //   925: iload_2
    //   926: tableswitch	default:+30 -> 956, 0:+-685->241, 1:+30->956, 2:+-682->244, 3:+50->976
    //   957: <illegal opcode>
    //   958: dload_1
    //   959: iload_2
    //   960: iconst_1
    //   961: iadd
    //   962: istore_2
    //   963: goto -638 -> 325
    //   966: iload_2
    //   967: iconst_1
    //   968: iadd
    //   969: istore_2
    //   970: goto -351 -> 619
    //   973: goto -746 -> 227
    //   976: goto -749 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	979	0	paramSharedPreferences	SharedPreferences
    //   0	979	1	paramString	String
    //   0	979	2	paramInt	int
    //   75	844	3	i	int
    //   369	548	4	bool	boolean
    //   35	872	5	localObject	Object
    //   31	882	6	localBoolean	java.lang.Boolean
    //   43	591	7	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   86	778	8	localEditor	SharedPreferences.Editor
    //   125	169	9	str1	String
    //   170	135	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   37	45	462	org/xmlpull/v1/XmlPullParserException
    //   49	64	462	org/xmlpull/v1/XmlPullParserException
    //   68	76	462	org/xmlpull/v1/XmlPullParserException
    //   80	88	462	org/xmlpull/v1/XmlPullParserException
    //   92	100	462	org/xmlpull/v1/XmlPullParserException
    //   104	115	462	org/xmlpull/v1/XmlPullParserException
    //   119	127	462	org/xmlpull/v1/XmlPullParserException
    //   131	172	462	org/xmlpull/v1/XmlPullParserException
    //   176	182	462	org/xmlpull/v1/XmlPullParserException
    //   186	224	462	org/xmlpull/v1/XmlPullParserException
    //   230	238	462	org/xmlpull/v1/XmlPullParserException
    //   244	315	462	org/xmlpull/v1/XmlPullParserException
    //   315	323	462	org/xmlpull/v1/XmlPullParserException
    //   330	371	462	org/xmlpull/v1/XmlPullParserException
    //   371	426	462	org/xmlpull/v1/XmlPullParserException
    //   429	459	462	org/xmlpull/v1/XmlPullParserException
    //   476	500	462	org/xmlpull/v1/XmlPullParserException
    //   517	537	462	org/xmlpull/v1/XmlPullParserException
    //   589	594	462	org/xmlpull/v1/XmlPullParserException
    //   599	617	462	org/xmlpull/v1/XmlPullParserException
    //   624	665	462	org/xmlpull/v1/XmlPullParserException
    //   665	720	462	org/xmlpull/v1/XmlPullParserException
    //   723	753	462	org/xmlpull/v1/XmlPullParserException
    //   756	780	462	org/xmlpull/v1/XmlPullParserException
    //   783	803	462	org/xmlpull/v1/XmlPullParserException
    //   806	852	462	org/xmlpull/v1/XmlPullParserException
    //   852	860	462	org/xmlpull/v1/XmlPullParserException
    //   863	902	462	org/xmlpull/v1/XmlPullParserException
    //   37	45	503	java/io/IOException
    //   49	64	503	java/io/IOException
    //   68	76	503	java/io/IOException
    //   80	88	503	java/io/IOException
    //   92	100	503	java/io/IOException
    //   104	115	503	java/io/IOException
    //   119	127	503	java/io/IOException
    //   131	172	503	java/io/IOException
    //   176	182	503	java/io/IOException
    //   186	224	503	java/io/IOException
    //   230	238	503	java/io/IOException
    //   244	315	503	java/io/IOException
    //   315	323	503	java/io/IOException
    //   330	371	503	java/io/IOException
    //   371	426	503	java/io/IOException
    //   429	459	503	java/io/IOException
    //   476	500	503	java/io/IOException
    //   517	537	503	java/io/IOException
    //   589	594	503	java/io/IOException
    //   599	617	503	java/io/IOException
    //   624	665	503	java/io/IOException
    //   665	720	503	java/io/IOException
    //   723	753	503	java/io/IOException
    //   756	780	503	java/io/IOException
    //   783	803	503	java/io/IOException
    //   806	852	503	java/io/IOException
    //   852	860	503	java/io/IOException
    //   863	902	503	java/io/IOException
    //   244	315	540	java/lang/Exception
    //   315	323	540	java/lang/Exception
    //   330	371	540	java/lang/Exception
    //   371	426	540	java/lang/Exception
    //   429	459	540	java/lang/Exception
    //   476	500	540	java/lang/Exception
    //   517	537	540	java/lang/Exception
    //   589	594	540	java/lang/Exception
    //   599	617	540	java/lang/Exception
    //   624	665	540	java/lang/Exception
    //   665	720	540	java/lang/Exception
    //   723	753	540	java/lang/Exception
    //   756	780	540	java/lang/Exception
    //   783	803	540	java/lang/Exception
    //   806	852	540	java/lang/Exception
    //   852	860	540	java/lang/Exception
    //   863	902	540	java/lang/Exception
    //   37	45	905	java/lang/Exception
    //   49	64	905	java/lang/Exception
    //   68	76	905	java/lang/Exception
    //   80	88	905	java/lang/Exception
    //   92	100	905	java/lang/Exception
    //   104	115	905	java/lang/Exception
    //   119	127	905	java/lang/Exception
    //   131	172	905	java/lang/Exception
    //   176	182	905	java/lang/Exception
    //   186	224	905	java/lang/Exception
    //   230	238	905	java/lang/Exception
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      return true;
    }
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "[decodeXML] + BEGIN");
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences("qcamera_local", 4);
  }
  
  @TargetApi(10)
  public static Bitmap b(byte[] paramArrayOfByte, Rect paramRect, boolean paramBoolean, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int j = localOptions.outHeight;
    int k = localOptions.outWidth;
    int i;
    double d4;
    double d5;
    double d1;
    double d2;
    if (k > j)
    {
      i = 1;
      d4 = 1.0D * Math.max(j, k) / Math.min(j, k);
      d5 = 1.0D * paramRect.height() / paramRect.width();
      d1 = k;
      d2 = j;
      if (d4 <= d5) {
        break label392;
      }
      if (i == 0) {
        break label374;
      }
      d1 = d2;
      d2 = d5 * d2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "clipJpegToBitmap tw=" + d2 + " th=" + d1 + " bw=" + k + " bh=" + j + " br=" + d4 + " sr=" + d5);
      }
      localOptions.inJustDecodeBounds = false;
      double d3 = (k - d2) / 2.0D;
      d4 = (k + d2) / 2.0D;
      d5 = (j - d1) / 2.0D;
      double d6 = (j + d1) / 2.0D;
      if (Build.VERSION.SDK_INT >= 10)
      {
        paramRect = new Rect((int)d3, (int)d5, (int)d4, (int)d6);
        paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
        paramRect = paramArrayOfByte.decodeRegion(paramRect, localOptions);
        paramArrayOfByte.recycle();
        paramArrayOfByte = new Matrix();
        paramArrayOfByte.setRotate(paramInt, paramRect.getWidth() / 2.0F, paramRect.getHeight() / 2.0F);
        if (paramBoolean) {
          paramArrayOfByte.postScale(-1.0F, 1.0F);
        }
        return Bitmap.createBitmap(paramRect, 0, 0, paramRect.getWidth(), paramRect.getHeight(), paramArrayOfByte, false);
        i = 0;
        break;
        label374:
        d3 = d5 * d1;
        d2 = d1;
        d1 = d3;
        continue;
        label392:
        if (d4 >= d5) {
          break label550;
        }
        if (i != 0)
        {
          d3 = 1.0D / d5 * d1;
          d2 = d1;
          d1 = d3;
          continue;
        }
        d3 = 1.0D / d5;
        d1 = d2;
        d2 = d3 * d2;
        continue;
      }
      try
      {
        localOptions.inSampleSize = 2;
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        paramRect = new Matrix();
        paramRect.setRotate(paramInt, paramArrayOfByte.getWidth() / 2.0F, paramArrayOfByte.getHeight() / 2.0F);
        if (paramBoolean) {
          paramRect.postScale(-1.0F, 1.0F);
        }
        paramRect = Bitmap.createBitmap(paramArrayOfByte, (int)(d3 / 2.0D), (int)(d5 / 2.0D), (int)(d2 / 2.0D), (int)(d1 / 2.0D), paramRect, false);
        paramArrayOfByte.recycle();
        return paramRect;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        throw paramArrayOfByte;
      }
      label550:
      d3 = d1;
      d1 = d2;
      d2 = d3;
    }
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= aqqj.a().a();
  }
  
  public static boolean c()
  {
    boolean bool3 = false;
    for (;;)
    {
      int i;
      try
      {
        int j = aqqj.a().b();
        if (j < 1) {
          return false;
        }
        SharedPreferences localSharedPreferences = b(BaseApplicationImpl.getContext());
        boolean bool2 = localSharedPreferences.getBoolean("localsp_camera_back_exist", false);
        bool1 = bool2;
        if (!bool2)
        {
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          i = 0;
          bool1 = bool2;
          if (i < j)
          {
            Camera.getCameraInfo(i, localCameraInfo);
            if (localCameraInfo.facing == 0) {
              bool1 = true;
            }
          }
          else
          {
            localSharedPreferences.edit().putBoolean("localsp_camera_back_exist", bool1).commit();
          }
        }
        else
        {
          if (bool1) {
            break;
          }
          bool1 = bool3;
          if (!QLog.isColorLevel()) {
            return bool1;
          }
          QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] check back camera exist: failed");
          return false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] check back camera exist: OK");
    }
    boolean bool1 = true;
    return bool1;
  }
  
  public static boolean d()
  {
    try
    {
      int j = aqqj.a().b();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(i, localCameraInfo);
          if (localCameraInfo != null)
          {
            int k = localCameraInfo.facing;
            if (1 == k) {
              return true;
            }
          }
          i += 1;
        }
      }
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.camera.CameraUtils", 1, "hasFrontCamera error, ", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqql
 * JD-Core Version:    0.7.0.1
 */