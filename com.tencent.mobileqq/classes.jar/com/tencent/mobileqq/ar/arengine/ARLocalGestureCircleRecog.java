package com.tencent.mobileqq.ar.arengine;

import aaob;
import android.graphics.PointF;
import android.os.Environment;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.sveffects.SvEffectSdkInitor;
import java.io.File;

public class ARLocalGestureCircleRecog
{
  private static boolean jdField_e_of_type_Boolean;
  private static boolean jdField_f_of_type_Boolean;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private aaob jdField_a_of_type_Aaob;
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(-1.0F, -1.0F);
  private AVGestureWrapper jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper;
  private ARLocalGestureCircleRecog.ARLocalGestureCircleRecogCallback jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ARLocalGestureCircleRecogCallback;
  private ARLocalGestureCircleRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult = new ARLocalGestureCircleRecogResult();
  private Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + File.separator + "ar_cloud_img/";
  private boolean jdField_a_of_type_Boolean;
  PointF[] jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[100];
  private int jdField_b_of_type_Int = 480;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 640;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private long jdField_f_of_type_Long;
  
  public static PointF a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PointF paramPointF)
  {
    return new PointF(paramInt3 - paramPointF.y / paramInt2 * paramInt3, paramPointF.x / paramInt1 * paramInt4);
  }
  
  public static boolean a()
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        boolean bool2 = GestureRecognitionUtils.b();
        boolean bool3 = SdkContext.a().a().a().b();
        if ((!bool2) || (!bool3))
        {
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. isGestureResourceReady = " + bool2 + ", isGestureEnable = " + bool3);
          return bool1;
        }
        String str1 = SdkContext.a().a().a().c();
        str1 = str1 + "libAVGesture4Android" + ".so";
        if (!new File(str1).exists())
        {
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. so not exist. soFilename = " + str1);
          continue;
        }
        str3 = PortalUtils.a(str2);
      }
      finally {}
      String str3;
      QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so... md5FromCalc = " + str3);
      try
      {
        System.load(str2);
        jdField_e_of_type_Boolean = true;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so ok. soFilename = " + str2 + ", SDKVersion = " + AVGestureWrapper.getVersionInfo());
        bool1 = jdField_e_of_type_Boolean;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          jdField_e_of_type_Boolean = false;
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. err = " + localThrowable.getMessage());
        }
      }
    }
  }
  
  public static PointF b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PointF paramPointF)
  {
    return new PointF(paramPointF.y / paramInt4 * paramInt1, (paramInt3 - paramPointF.x) / paramInt3 * paramInt2);
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 40	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   12: invokestatic 106	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   15: invokevirtual 109	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/mobileqq/shortvideo/resource/Resources;
    //   18: invokeinterface 114 1 0
    //   23: invokeinterface 186 1 0
    //   28: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 60	java/io/File:separator	Ljava/lang/String;
    //   34: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 49	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 144	java/io/File:exists	()Z
    //   54: ifne +33 -> 87
    //   57: ldc 119
    //   59: iconst_2
    //   60: new 40	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   67: ldc 188
    //   69: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: ldc 2
    //   84: monitorexit
    //   85: iload_0
    //   86: ireturn
    //   87: ldc 119
    //   89: iconst_2
    //   90: new 40	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   97: ldc 193
    //   99: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_1
    //   113: aload_1
    //   114: aload_1
    //   115: invokestatic 197	com/tencent/av/avgesture/AVGestureWrapper:setFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   118: pop
    //   119: aload_1
    //   120: invokestatic 201	com/tencent/av/avgesture/AVGestureWrapper:setGlobalConfigFile	(Ljava/lang/String;)Z
    //   123: pop
    //   124: new 203	aaoa
    //   127: dup
    //   128: invokespecial 204	aaoa:<init>	()V
    //   131: invokestatic 208	com/tencent/av/avgesture/AVGestureWrapper:setAVGestureReport	(Lcom/tencent/av/avgesture/AVGestureWrapper$AVUploadReport;)V
    //   134: iconst_0
    //   135: invokestatic 212	com/tencent/av/avgesture/AVGestureWrapper:setShouldUpload	(Z)V
    //   138: iconst_1
    //   139: putstatic 214	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   142: ldc 119
    //   144: iconst_2
    //   145: ldc 216
    //   147: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: getstatic 214	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   153: istore_0
    //   154: goto -72 -> 82
    //   157: astore_1
    //   158: iconst_0
    //   159: putstatic 214	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   162: ldc 119
    //   164: iconst_2
    //   165: new 40	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   172: ldc 218
    //   174: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 219	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: goto -40 -> 150
    //   193: astore_1
    //   194: ldc 2
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: iconst_0
    //   201: putstatic 214	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   204: ldc 119
    //   206: iconst_2
    //   207: new 40	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   214: ldc 221
    //   216: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_1
    //   220: invokevirtual 222	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   223: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: goto -82 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	153	0	bool	boolean
    //   40	80	1	str	String
    //   157	21	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   193	5	1	localObject	Object
    //   199	21	1	localException	java.lang.Exception
    //   49	54	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	82	157	java/lang/UnsatisfiedLinkError
    //   87	150	157	java/lang/UnsatisfiedLinkError
    //   5	82	193	finally
    //   87	150	193	finally
    //   150	154	193	finally
    //   158	190	193	finally
    //   200	232	193	finally
    //   5	82	199	java/lang/Exception
    //   87	150	199	java/lang/Exception
  }
  
  private void f()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "delete backup file.");
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int i = 0;
        while (i < localObject1.length)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.exists()) {
            localObject2.delete();
          }
          i += 1;
        }
      }
    }
  }
  
  float a(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return 0.0F;
    }
    float f1 = Math.abs(paramPointF1.x - paramPointF2.x);
    float f2 = Math.abs(paramPointF1.y - paramPointF2.y);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  float a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    double d1 = Math.sqrt((paramPointF2.x - paramPointF3.x) * (paramPointF2.x - paramPointF3.x) + (paramPointF2.y - paramPointF3.y) * (paramPointF2.y - paramPointF3.y));
    double d2 = Math.sqrt((paramPointF1.x - paramPointF3.x) * (paramPointF1.x - paramPointF3.x) + (paramPointF1.y - paramPointF3.y) * (paramPointF1.y - paramPointF3.y));
    double d3 = Math.sqrt((paramPointF2.x - paramPointF1.x) * (paramPointF2.x - paramPointF1.x) + (paramPointF2.y - paramPointF1.y) * (paramPointF2.y - paramPointF1.y));
    return (float)(Math.acos((d2 * d2 + d3 * d3 - d1 * d1) / (d2 * 2.0D * d3)) * 180.0D / 3.141592653589793D);
  }
  
  int a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF)
  {
    float f2 = -1.0F;
    if (paramInt < 1) {
      return paramInt;
    }
    PointF localPointF;
    if (paramInt == 1)
    {
      f1 = paramPointF.x - paramArrayOfPointF[0].x;
      float f4 = paramPointF.y - paramArrayOfPointF[0].y;
      float f5 = a(paramPointF, paramArrayOfPointF[0]);
      float f3 = Math.abs(f4) / f5;
      f5 = Math.abs(f1) / f5;
      if (f1 > 0.0F) {}
      for (f1 = 1.0F;; f1 = -1.0F)
      {
        i = paramInt;
        if (f4 > 0.0F)
        {
          f2 = 1.0F;
          i = paramInt;
        }
        for (;;)
        {
          paramInt = i;
          if (a(paramArrayOfPointF[(i - 1)], paramPointF) <= 20.0F) {
            break;
          }
          localPointF = new PointF(0.0F, 0.0F);
          localPointF.x = (paramArrayOfPointF[(i - 1)].x + 20.0F * f5 * f1);
          localPointF.y = (paramArrayOfPointF[(i - 1)].y + 20.0F * f3 * f2);
          paramArrayOfPointF[i] = localPointF;
          i += 1;
        }
      }
    }
    int i = paramInt;
    float f1 = a(paramArrayOfPointF[(i - 1)], paramPointF);
    int j;
    if (f1 > 20.0F)
    {
      localPointF = new PointF(0.0F, 0.0F);
      localPointF.x = (paramArrayOfPointF[(i - 1)].x + (paramPointF.x - paramArrayOfPointF[(i - 2)].x) * 0.2F);
      localPointF.y = (paramArrayOfPointF[(i - 1)].y + (paramPointF.y - paramArrayOfPointF[(i - 2)].y) * 0.2F);
      j = i + 1;
      paramArrayOfPointF[i] = localPointF;
      if (j - paramInt <= 3) {}
    }
    for (;;)
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "genCirclePoints2. pointCnt = " + j + ", newCnt = " + (j - paramInt) + ", d = " + f1);
      return j;
      i = j;
      break;
      j = i;
    }
  }
  
  int a(PointF[] paramArrayOfPointF, int paramInt1, int[] paramArrayOfInt, int paramInt2, ARLocalGestureCircleRecogResult.ARCircle paramARCircle)
  {
    int i = 1;
    if (!paramARCircle.jdField_a_of_type_Boolean) {
      i = -1;
    }
    float f2 = i * 360.0F / paramInt2;
    float f3 = (float)(f2 / 180.0F * 3.141592653589793D);
    float f1 = (float)Math.abs(180.0F * f3 / 3.141592653589793D);
    if (i == -1) {}
    for (i = 0;; i = 360)
    {
      PointF localPointF2 = new PointF(paramARCircle.b - paramARCircle.jdField_a_of_type_Float, paramARCircle.c);
      new PointF(paramARCircle.b, paramARCircle.c);
      f1 = i;
      int k = 0;
      int j = paramInt1;
      paramInt1 = k;
      if (paramInt1 < paramInt2)
      {
        if (paramInt1 == 0) {}
        for (PointF localPointF1 = new PointF(localPointF2.x - paramARCircle.b, localPointF2.y - paramARCircle.c);; localPointF1 = new PointF(paramArrayOfPointF[(j - 1)].x - paramARCircle.b, paramArrayOfPointF[(j - 1)].y - paramARCircle.c))
        {
          PointF localPointF3 = new PointF(0.0F, 0.0F);
          localPointF3.x = ((float)(Math.cos(f3) * localPointF1.x - Math.sin(f3) * localPointF1.y) + paramARCircle.b);
          localPointF3.y = ((float)(Math.sin(f3) * localPointF1.x + Math.cos(f3) * localPointF1.y) + paramARCircle.c);
          paramArrayOfPointF[j] = localPointF3;
          k = (int)(Math.random() * 210.0D + 30.0D);
          paramArrayOfInt[j] = (((int)f1 - k + 360) % 360);
          j += 1;
          paramInt1 += 1;
          f1 -= f2;
          break;
        }
      }
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "genCirclePoints4. pointCnt = " + j + ", newCnt = " + paramInt1 + ", radianInc = " + f3 + ", startDegree = " + i + ", startP.x = " + localPointF2.x + ", startP.y = " + localPointF2.y + ", circle.x = " + paramARCircle.b + ", circle.y = " + paramARCircle.c);
      return j;
    }
  }
  
  ARLocalGestureCircleRecogResult.ARCircle a(PointF[] paramArrayOfPointF, int paramInt)
  {
    if (paramInt < 3) {
      return null;
    }
    return a(paramArrayOfPointF, paramInt - 1, paramArrayOfPointF[(paramInt - 1)]);
  }
  
  ARLocalGestureCircleRecogResult.ARCircle a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF)
  {
    int j = paramInt + 1;
    if (j < 3) {
      return null;
    }
    ARLocalGestureCircleRecogResult.ARCircle localARCircle = new ARLocalGestureCircleRecogResult.ARCircle();
    double d9 = 0.0D;
    double d8 = 0.0D;
    double d7 = 0.0D;
    double d6 = 0.0D;
    double d4 = 0.0D;
    double d2 = 0.0D;
    double d5 = 0.0D;
    double d3 = 0.0D;
    double d1 = 0.0D;
    int i = 0;
    while (i < paramInt)
    {
      d12 = paramArrayOfPointF[i].x;
      d10 = paramArrayOfPointF[i].y;
      d11 = d12 * d12;
      d13 = d10 * d10;
      d9 += d12;
      d8 += d10;
      d7 += d11;
      d6 += d13;
      d4 += d11 * d12;
      d2 += d13 * d10;
      d5 += d12 * d10;
      d3 += d12 * d13;
      d1 += d11 * d10;
      i += 1;
    }
    double d13 = paramPointF.x;
    double d10 = paramPointF.y;
    double d11 = d13 * d13;
    double d12 = d10 * d10;
    d9 += d13;
    d8 += d10;
    d7 += d11;
    d6 += d12;
    double d14 = j * d7 - d9 * d9;
    d5 = (d5 + d13 * d10) * j - d9 * d8;
    double d15 = j;
    d3 = (d3 + d13 * d12) * j + (d4 + d11 * d13) * d15 - (d7 + d6) * d9;
    d4 = j * d6 - d8 * d8;
    d2 = (d1 + d11 * d10) * j + (d2 + d12 * d10) * j - (d7 + d6) * d8;
    d1 = (d2 * d5 - d3 * d4) / (d14 * d4 - d5 * d5);
    d2 = (d2 * d14 - d3 * d5) / (d5 * d5 - d4 * d14);
    d3 = -(d1 * d9 + d2 * d8 + d7 + d6) / j;
    localARCircle.b = ((float)d1 / -2.0F);
    localARCircle.c = ((float)d2 / -2.0F);
    localARCircle.jdField_a_of_type_Float = ((float)Math.sqrt(d2 * d2 + d1 * d1 - d3 * 4.0D) / 2.0F);
    j = 0;
    int m = 0;
    i = 0;
    PointF localPointF1;
    PointF localPointF2;
    float f2;
    float f1;
    label587:
    int k;
    if (m < paramInt - 1 + 1)
    {
      localPointF1 = new PointF(localARCircle.b, localARCircle.c);
      localPointF2 = new PointF(localARCircle.b + localARCircle.jdField_a_of_type_Float, localARCircle.c);
      f2 = b(localPointF1, localPointF2, paramArrayOfPointF[m]);
      if (m != paramInt - 1)
      {
        f1 = b(localPointF1, localPointF2, paramArrayOfPointF[(m + 1)]);
        if ((270.0F <= f2) && (f2 <= 360.0F) && (0.0F <= f1) && (f1 <= 90.0F)) {
          break label879;
        }
        if ((270.0F > f1) || (f1 > 360.0F) || (0.0F > f2) || (f2 > 90.0F)) {
          break label702;
        }
        k = j;
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      m += 1;
      k = i;
      i = j;
      j = k;
      break;
      f1 = b(localPointF1, localPointF2, paramPointF);
      break label587;
      label702:
      k = i;
      if (f1 > f2) {
        k = i + 1;
      }
      i = j + 1;
      j = k;
      continue;
      boolean bool;
      if (j > 0) {
        if (i > j / 2.0F) {
          bool = true;
        }
      }
      for (;;)
      {
        localARCircle.jdField_a_of_type_Boolean = bool;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "fitCircle. centerX = " + localARCircle.b + ", centerY = " + localARCircle.c + ", r = " + localARCircle.jdField_a_of_type_Float + ", isClockwise = " + localARCircle.jdField_a_of_type_Boolean + ", clockWiseCnt = " + i + ", usedPointCnt = " + j + ", pointCnt = " + paramInt);
        return localARCircle;
        bool = false;
        continue;
        bool = true;
      }
      label879:
      k = i;
      i = j;
      j = k;
    }
  }
  
  ARLocalGestureCircleRecogResult.ARGestureResult a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    ARLocalGestureCircleRecogResult.ARGestureResult localARGestureResult = new ARLocalGestureCircleRecogResult.ARGestureResult(1);
    boolean bool = false;
    PointF[] arrayOfPointF = new PointF[1];
    arrayOfPointF[0] = new PointF(-1.0F, -1.0F);
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper != null)
        {
          bool = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.doCalc(paramArrayOfByte, paramInt1, paramInt2, 2, 270, paramBoolean);
          localARGestureResult.jdField_a_of_type_Boolean = bool;
          localARGestureResult.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.getGestureType();
          arrayOfPointF[0] = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.getKeyPointByName("finger");
          if ((bool) && (arrayOfPointF[0].x > 0.0F) && (arrayOfPointF[0].y > 0.0F))
          {
            if (!paramBoolean) {
              break label434;
            }
            if (localARGestureResult.jdField_a_of_type_JavaLangString.equalsIgnoreCase("finger1")) {
              break label439;
            }
            break label434;
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectGesture. doCalc. isSuccess = " + paramBoolean + ", res = " + bool + ", type = " + localARGestureResult.jdField_a_of_type_JavaLangString + ", x = " + arrayOfPointF[0].x + ", y = " + arrayOfPointF[0].y);
            bool = paramBoolean;
          }
        }
        else
        {
          if (!bool) {
            break label377;
          }
          paramArrayOfByte = localARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
          paramInt1 = localARGestureResult.jdField_b_of_type_Int;
          localARGestureResult.jdField_b_of_type_Int = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = new PointF(arrayOfPointF[0].x, arrayOfPointF[0].y);
          localARGestureResult.d = 0;
          localARGestureResult.jdField_a_of_type_Int = 0;
          localARGestureResult.jdField_c_of_type_Int = ((int)(System.currentTimeMillis() - l));
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectGesture. gestureResult = " + localARGestureResult + ", TotalTime = " + localARGestureResult.jdField_c_of_type_Int);
          return localARGestureResult;
        }
        paramBoolean = false;
      }
      label377:
      localARGestureResult.jdField_a_of_type_JavaLangString = "";
      paramArrayOfByte = localARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
      paramInt1 = localARGestureResult.jdField_b_of_type_Int;
      localARGestureResult.jdField_b_of_type_Int = (paramInt1 + 1);
      paramArrayOfByte[paramInt1] = new PointF(-1.0F, -1.0F);
      localARGestureResult.d = -1;
      localARGestureResult.jdField_a_of_type_Int = -1;
      continue;
      label434:
      if (!paramBoolean) {
        label439:
        paramBoolean = true;
      }
    }
  }
  
  ARLocalGestureCircleRecogResult a(PointF paramPointF, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.d = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int;
    if (!this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int >= 999)
    {
      if (paramInt == 1)
      {
        bool = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int);
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectTouch. isCircleForTouch = " + bool);
        if (!bool) {
          break label147;
        }
      }
      label147:
      for (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = -1) {
        return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int >= 999)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int = 0;
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectTouch. reset gesture result point cnt.");
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_JavaLangString = "TouchScreen";
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.d = 1;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Int = 0;
    PointF[] arrayOfPointF = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult;
    int i = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject).jdField_b_of_type_Int;
    ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject).jdField_b_of_type_Int = (i + 1);
    arrayOfPointF[i] = paramPointF;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int == 0)
    {
      if ((150.0F < paramPointF.x) && (paramPointF.x < this.jdField_b_of_type_Int - 150) && (50.0F < paramPointF.y) && (paramPointF.y < this.jdField_c_of_type_Int - 50))
      {
        arrayOfPointF = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
        paramInt = ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).jdField_c_of_type_Int;
        ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).jdField_c_of_type_Int = (paramInt + 1);
        arrayOfPointF[paramInt] = new PointF(paramPointF.x, paramPointF.y);
        paramInt = (int)(Math.random() * 360.0D);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - 1)] = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = 1;
      }
      for (;;)
      {
        return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectTouch. Gesture failed. firstPoint. x = " + paramPointF.x + ", y = " + paramPointF.y);
      }
    }
    if (paramInt != 1) {}
    for (boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int, paramPointF, 10.0F);; bool = false)
    {
      if ((paramInt != 1) && (bool))
      {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectTouch. Gesture failed. isRepeat = " + bool);
        break;
      }
      arrayOfPointF = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
      i = ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).jdField_c_of_type_Int;
      ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).jdField_c_of_type_Int = (i + 1);
      arrayOfPointF[i] = new PointF(paramPointF.x, paramPointF.y);
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int < 3)
      {
        i = (int)(Math.random() * 360.0D);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - 1)] = i;
      }
      for (;;)
      {
        if (paramInt != 1) {
          break label955;
        }
        bool = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int);
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectTouch. isCircleForTouch = " + bool);
        if (!bool) {
          break label957;
        }
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = 0;
        break;
        i = (int)(Math.random() * 360.0D);
        i = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - 1;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - 1, paramPointF);
        while (i < this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int)
        {
          int j = (int)(Math.random() * 360.0D);
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfInt[i] = j;
          i += 1;
        }
        arrayOfPointF = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
        i = ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).jdField_c_of_type_Int;
        ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject).jdField_c_of_type_Int = (i + 1);
        arrayOfPointF[i] = new PointF(paramPointF.x, paramPointF.y);
        i = (int)(Math.random() * 360.0D);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - 1)] = i;
      }
      label955:
      break;
      label957:
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = -1;
      break;
    }
  }
  
  public ARLocalGestureCircleRecogResult a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.d = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int;
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int >= 999))
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. mRecogResult.circleResult.pointCnt >= ARLocalGestureCircleRecogResult.MAX_POINT_CNT - 1.");
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int >= 999)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int = 0;
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. reset gesture result point cnt.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int == 0)
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. state == ARCircleResult.CIRCLE_STATE_SUCCESS.");
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
    }
    boolean bool;
    Object localObject1;
    float f1;
    float f3;
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int == 0) || (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Boolean))
    {
      bool = true;
      localObject1 = a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, bool);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Boolean = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int != 0) {
        break label928;
      }
      f1 = -1.0F;
      f3 = -1.0F;
      if (((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_Int != 0) {
        break label1410;
      }
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidGraphicsPointF.x >= 0.0F) {
        break label462;
      }
      this.jdField_a_of_type_AndroidGraphicsPointF.x = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x;
    }
    for (this.jdField_a_of_type_AndroidGraphicsPointF.y = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y;; this.jdField_a_of_type_AndroidGraphicsPointF.y = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h >= 4) {
        break label516;
      }
      if (f1 > 30)
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
        paramArrayOfByte.h += 1;
      }
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. startDrawDetect. return. , px = " + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x + ", py = " + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y + ", d1 = " + f1 + ", d2 = " + -1.0F + ", gesturePointCnt = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h + ", stillPointCnt = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i + ", goodPointCnt = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j);
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
      bool = false;
      break;
      label462:
      f1 = a(this.jdField_a_of_type_AndroidGraphicsPointF, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
      this.jdField_a_of_type_AndroidGraphicsPointF.x = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x;
    }
    label516:
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i < 4)
    {
      if ((f1 < 0.0F) || (f1 >= 30)) {
        break label1396;
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
      paramArrayOfByte.i += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i >= 4) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j = 0;
      }
    }
    float f4 = f1;
    float f2 = f3;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j < 6)
    {
      f2 = f3;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j != 0)
      {
        f4 = f1;
        f2 = f3;
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j >= 1)
        {
          f4 = f1;
          f2 = f3;
          if (f1 > 30)
          {
            f3 = a(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j - 1)], localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
            f4 = f1;
            f2 = f3;
            if (f3 > 120) {
              f2 = f3;
            }
          }
        }
      }
      else
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
        paramArrayOfByte.j += 1;
        this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j - 1)] = new PointF(localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y);
        f4 = f1;
      }
    }
    label785:
    label928:
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h >= 4) && (((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i >= 4) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j >= 4)) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j >= 6)))
    {
      paramArrayOfByte = a(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j);
      if (paramArrayOfByte != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Boolean = paramArrayOfByte.jdField_a_of_type_Boolean;
        a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_b_of_type_ArrayOfAndroidGraphicsPointF, 0, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.e, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle);
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int == 0) && (localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)].x > 0.0F) && (localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)].y > 0.0F) && (!((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_JavaLangString.equalsIgnoreCase("finger1")))
        {
          ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_JavaLangString = "";
          localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)].x = -1.0F;
          localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)].y = -1.0F;
          ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).d = -1;
          ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_Int = -1;
        }
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_c_of_type_Int = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_c_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_JavaLangString = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_JavaLangString;
        paramArrayOfByte = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)];
        if ((paramArrayOfByte.x <= 0.0F) || (paramArrayOfByte.y <= 0.0F)) {
          break label2212;
        }
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.d = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).d;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Int = 0;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult;
        paramInt1 = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject2).jdField_b_of_type_Int;
        ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject2).jdField_b_of_type_Int = (paramInt1 + 1);
        localObject1[paramInt1] = paramArrayOfByte;
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int != 0) {
          break label1771;
        }
        if ((150.0F >= paramArrayOfByte.x) || (paramArrayOfByte.x >= this.jdField_b_of_type_Int - 150) || (50.0F >= paramArrayOfByte.y) || (paramArrayOfByte.y >= this.jdField_c_of_type_Int - 50)) {
          break label1726;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
        paramInt1 = ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject2).jdField_c_of_type_Int;
        ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject2).jdField_c_of_type_Int = (paramInt1 + 1);
        localObject1[paramInt1] = new PointF(paramArrayOfByte.x, paramArrayOfByte.y);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j = 0;
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        this.jdField_e_of_type_Long = System.currentTimeMillis();
        this.jdField_f_of_type_Long = 0L;
      }
    }
    label1396:
    do
    {
      for (;;)
      {
        paramInt1 = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.g >= this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.e - 1) {
          paramInt1 = 1;
        }
        if (paramInt1 != 0) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = 0;
        }
        return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i = 0;
        break;
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int > 13)
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h = 0;
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i = 0;
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j = 0;
          f4 = f1;
          f2 = f3;
          break label785;
        }
        f4 = f1;
        f2 = f3;
        if (this.jdField_a_of_type_Int <= 5) {
          break label785;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h < 4) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h = 0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i < 4) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i = 0;
        }
        f4 = f1;
        f2 = f3;
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j >= 4) {
          break label785;
        }
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j = 0;
        f4 = f1;
        f2 = f3;
        break label785;
        return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. startDrawDetect. return. , px = " + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x + ", py = " + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y + ", d1 = " + f4 + ", d2 = " + f2 + ", gesturePointCnt = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h + ", stillPointCnt = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i + ", goodPointCnt = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j);
        return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture failed. firstPoint. x = " + paramArrayOfByte.x + ", y = " + paramArrayOfByte.y);
        continue;
        bool = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int, paramArrayOfByte, 20.0F);
        if ((!bool) && ((!bool) && (0 == 0))) {
          break label1855;
        }
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture failed. isRepeat = " + bool + ", isException = " + false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int >= 2)
      {
        f1 = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int - 2)], this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int - 1)]);
        paramInt1 = 0;
        if (f1 > 50.0F)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
          ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject1).j += 1;
          if (this.jdField_e_of_type_Long != 0L) {
            break label2197;
          }
          this.jdField_e_of_type_Long = System.currentTimeMillis();
          if ((this.jdField_e_of_type_Long == 0L) || (this.jdField_f_of_type_Long == 0L)) {
            break label2207;
          }
        }
      }
      for (paramInt1 = (int)(this.jdField_f_of_type_Long - this.jdField_e_of_type_Long);; paramInt1 = 0)
      {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture dist. dist = " + f1 + ", goodPointCnt = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j + ", timeLen = " + paramInt1);
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j >= 1) && (paramInt1 > 30))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
          paramInt1 = ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject2).jdField_c_of_type_Int;
          ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject2).jdField_c_of_type_Int = (paramInt1 + 1);
          localObject1[paramInt1] = new PointF(paramArrayOfByte.x, paramArrayOfByte.y);
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j = 0;
          this.jdField_e_of_type_Long = System.currentTimeMillis();
          this.jdField_f_of_type_Long = 0L;
        }
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        break;
        f1 = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - 1)], paramArrayOfByte);
        break label1921;
        this.jdField_f_of_type_Long = System.currentTimeMillis();
        break label1969;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Int = -1;
    } while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int <= 0);
    label1410:
    label1726:
    label1771:
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long == 0L)) {
        break label2362;
      }
      paramInt1 = (int)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
      if (paramInt1 <= 2000) {
        break label2365;
      }
      paramInt1 = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.g >= this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.e * 0.8D) {
        paramInt1 = 1;
      }
      if (paramInt1 == 0) {
        break label2367;
      }
    }
    label1855:
    label2252:
    label2281:
    for (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = -1)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      break label2252;
      paramInt1 = 0;
      break label2281;
      break;
    }
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "pause. mIsPause = " + this.jdField_d_of_type_Boolean);
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.d == 1) || (this.jdField_a_of_type_Aaob == null)) {
      return;
    }
    this.jdField_a_of_type_Aaob.a(paramLong, paramArrayOfByte);
  }
  
  public void a(PointF paramPointF, int paramInt)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.d == 0);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.d = 1;
      paramPointF = a(paramPointF, paramInt);
    } while ((!this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ARLocalGestureCircleRecogCallback == null));
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ARLocalGestureCircleRecogCallback.a(paramPointF);
  }
  
  public boolean a(int paramInt1, int paramInt2, ARLocalGestureCircleRecog.ARLocalGestureCircleRecogCallback paramARLocalGestureCircleRecogCallback)
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "init. imgW = " + paramInt1 + ", imgH = " + paramInt2);
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      SvEffectSdkInitor.a();
      if ((a()) && (b()) && (this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper == null)) {
        this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper = new AVGestureWrapper();
      }
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ARLocalGestureCircleRecogCallback = paramARLocalGestureCircleRecogCallback;
      e();
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
    }
  }
  
  boolean a(PointF[] paramArrayOfPointF, int paramInt)
  {
    if ((paramArrayOfPointF == null) || (paramInt < 15))
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "isCircleForTouch. false. pointCnt = " + paramInt);
      return false;
    }
    ARLocalGestureCircleRecogResult.ARCircle localARCircle = a(paramArrayOfPointF, paramInt);
    if (localARCircle == null) {
      return false;
    }
    if (localARCircle.jdField_a_of_type_Float < 60.0F)
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "isCircleForTouch. false. r = " + localARCircle.jdField_a_of_type_Float);
      return false;
    }
    float f7 = paramArrayOfPointF[0].x;
    float f4 = paramArrayOfPointF[0].x;
    float f2 = paramArrayOfPointF[0].y;
    float f1 = paramArrayOfPointF[0].y;
    int i = 1;
    while (i < paramInt)
    {
      f3 = f7;
      if (paramArrayOfPointF[i].x < f7) {
        f3 = paramArrayOfPointF[i].x;
      }
      float f5 = f4;
      if (paramArrayOfPointF[i].x > f4) {
        f5 = paramArrayOfPointF[i].x;
      }
      float f6 = f2;
      if (paramArrayOfPointF[i].y < f2) {
        f6 = paramArrayOfPointF[i].y;
      }
      float f8 = f1;
      if (paramArrayOfPointF[i].y > f1) {
        f8 = paramArrayOfPointF[i].y;
      }
      i += 1;
      f7 = f3;
      f4 = f5;
      f2 = f6;
      f1 = f8;
    }
    float f3 = f4 - f7;
    f1 -= f2;
    if ((f3 < 60.0F) || (f1 < 60.0F))
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "isCircleForTouch. false. w = " + f3 + ", h = " + f1);
      return false;
    }
    PointF localPointF = new PointF(localARCircle.b, localARCircle.c);
    f1 = a(paramArrayOfPointF[(paramInt - 1)], paramArrayOfPointF[0]);
    int j;
    label388:
    int m;
    if (f1 < 80.0F)
    {
      i = 1;
      k = i;
      if (i == 0)
      {
        j = paramInt - 2;
        k = i;
        if (j >= 14) {
          m = 0;
        }
      }
    }
    else
    {
      for (;;)
      {
        k = i;
        f2 = f1;
        if (m < 5)
        {
          f3 = a(paramArrayOfPointF[j], paramArrayOfPointF[m]);
          f2 = f1;
          if (f3 < f1) {
            f2 = f3;
          }
          if (f3 < 80.0F) {
            k = 1;
          }
        }
        else
        {
          j -= 1;
          f1 = f2;
          i = k;
          break label388;
          i = 0;
          break;
        }
        m += 1;
        f1 = f2;
      }
    }
    boolean bool8;
    boolean bool7;
    boolean bool5;
    boolean bool3;
    if (k == 0)
    {
      i = 0;
      bool8 = false;
      bool7 = false;
      bool5 = false;
      bool3 = false;
    }
    for (;;)
    {
      if (i < paramInt)
      {
        boolean bool1 = false;
        boolean bool2 = false;
        boolean bool4 = false;
        boolean bool6 = false;
        j = 0;
        bool8 = bool1;
        bool7 = bool2;
        bool5 = bool4;
        bool3 = bool6;
        if (j < paramInt)
        {
          if ((j - 5 < i) && (i < j + 5))
          {
            bool7 = bool4;
            bool8 = bool2;
          }
          do
          {
            do
            {
              do
              {
                do
                {
                  j += 1;
                  bool2 = bool8;
                  bool4 = bool7;
                  break;
                  bool3 = bool6;
                  if (!bool6)
                  {
                    bool3 = bool6;
                    if (paramArrayOfPointF[j].x < paramArrayOfPointF[i].x)
                    {
                      bool3 = bool6;
                      if (Math.abs(paramArrayOfPointF[j].y - paramArrayOfPointF[i].y) < 20.0F) {
                        bool3 = true;
                      }
                    }
                  }
                  bool5 = bool4;
                  if (!bool4)
                  {
                    bool5 = bool4;
                    if (paramArrayOfPointF[j].x > paramArrayOfPointF[i].x)
                    {
                      bool5 = bool4;
                      if (Math.abs(paramArrayOfPointF[j].y - paramArrayOfPointF[i].y) < 20.0F) {
                        bool5 = true;
                      }
                    }
                  }
                  bool4 = bool2;
                  if (!bool2)
                  {
                    bool4 = bool2;
                    if (paramArrayOfPointF[j].y < paramArrayOfPointF[i].y)
                    {
                      bool4 = bool2;
                      if (Math.abs(paramArrayOfPointF[j].x - paramArrayOfPointF[i].x) < 20.0F) {
                        bool4 = true;
                      }
                    }
                  }
                  bool2 = bool1;
                  if (!bool1)
                  {
                    bool2 = bool1;
                    if (paramArrayOfPointF[j].y > paramArrayOfPointF[i].y)
                    {
                      bool2 = bool1;
                      if (Math.abs(paramArrayOfPointF[j].x - paramArrayOfPointF[i].x) < 20.0F) {
                        bool2 = true;
                      }
                    }
                  }
                  bool1 = bool2;
                  bool8 = bool4;
                  bool7 = bool5;
                  bool6 = bool3;
                } while (!bool3);
                bool1 = bool2;
                bool8 = bool4;
                bool7 = bool5;
                bool6 = bool3;
              } while (!bool5);
              bool1 = bool2;
              bool8 = bool4;
              bool7 = bool5;
              bool6 = bool3;
            } while (!bool4);
            bool1 = bool2;
            bool8 = bool4;
            bool7 = bool5;
            bool6 = bool3;
          } while (!bool2);
          bool7 = bool4;
          bool8 = bool2;
        }
        if ((!bool3) || (!bool5) || (!bool7) || (!bool8)) {}
      }
      else
      {
        if ((!bool3) || (!bool5) || (!bool7) || (!bool8)) {
          break;
        }
        f2 = localARCircle.jdField_a_of_type_Float;
        f1 = 0.0F;
        j = 0;
        i = 0;
        while (i < paramInt)
        {
          f3 = a(localPointF, paramArrayOfPointF[i]);
          f1 += (f3 - f2) * (f3 - f2);
          k = j;
          if (Math.abs(f3 - f2) > 0.2F * f2) {
            k = j + 1;
          }
          i += 1;
          j = k;
        }
      }
      i += 1;
    }
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "isCircleForTouch. hasLeft = " + bool3 + ", hasRight = " + bool5 + ", hasTop = " + bool7 + ", hasBottom = " + bool8);
    f1 = a(localPointF, paramArrayOfPointF[(paramInt - 1)], paramArrayOfPointF[0]);
    if ((f1 > 90.0F) && (f1 < 270.0F))
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "isCircleForTouch. false. degree = " + f1);
      return false;
    }
    int k = 0;
    i = 1;
    for (;;)
    {
      j = k;
      if (i < paramInt - 1)
      {
        f1 = a(localPointF, paramArrayOfPointF[i], paramArrayOfPointF[0]);
        if (f1 > 90.0F) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "isCircleForTouch. false. degree = " + (360.0F - f1));
        return false;
      }
      i += 1;
    }
    f1 = (float)Math.sqrt(f1 / paramInt);
    if ((f1 > 40.0F) && (j > 20))
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "isCircleForTouch. false. sd = " + f1 + ", cx = " + localPointF.x + ", cy = " + localPointF.y + ", r = " + localARCircle.jdField_a_of_type_Float + ", average = " + f2 + ", expPointCnt = " + j);
      return false;
    }
    return true;
  }
  
  boolean a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF, float paramFloat)
  {
    if ((paramArrayOfPointF == null) || (paramInt == 0) || (paramPointF == null)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramInt)
      {
        if (a(paramArrayOfPointF[i], paramPointF) < paramFloat) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  float b(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    double d1 = Math.sqrt((paramPointF2.x - paramPointF3.x) * (paramPointF2.x - paramPointF3.x) + (paramPointF2.y - paramPointF3.y) * (paramPointF2.y - paramPointF3.y));
    double d2 = Math.sqrt((paramPointF1.x - paramPointF3.x) * (paramPointF1.x - paramPointF3.x) + (paramPointF1.y - paramPointF3.y) * (paramPointF1.y - paramPointF3.y));
    double d3 = Math.sqrt((paramPointF2.x - paramPointF1.x) * (paramPointF2.x - paramPointF1.x) + (paramPointF2.y - paramPointF1.y) * (paramPointF2.y - paramPointF1.y));
    d1 = Math.acos((d2 * d2 + d3 * d3 - d1 * d1) / (d2 * 2.0D * d3)) * 180.0D / 3.141592653589793D;
    if (paramPointF3.y > paramPointF1.y) {
      return (float)d1;
    }
    return (float)(360.0D - d1);
  }
  
  public void b()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "resume. mIsPause = " + this.jdField_d_of_type_Boolean);
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void c()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "stop start.");
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Aaob != null)
    {
      this.jdField_a_of_type_Aaob.a();
      this.jdField_a_of_type_Aaob = null;
    }
    this.jdField_b_of_type_Boolean = false;
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "stop end. mIsStarted = " + this.jdField_b_of_type_Boolean);
  }
  
  public boolean c()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "start start.");
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if (this.jdField_a_of_type_Aaob == null) {
      this.jdField_a_of_type_Aaob = new aaob(this);
    }
    e();
    f();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "start end. mIsStarted = " + this.jdField_b_of_type_Boolean);
    return true;
  }
  
  public void d()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "uninit start.");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ARLocalGestureCircleRecogCallback = null;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper != null)
      {
        this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.destroyRecognizor();
        this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper = null;
      }
      this.jdField_a_of_type_Boolean = false;
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "uninit end. mIsInited = " + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.a();
    ARLocalGestureCircleRecogResult.ARCircle localARCircle = new ARLocalGestureCircleRecogResult.ARCircle();
    localARCircle.jdField_a_of_type_Float = (this.jdField_c_of_type_Int / 4.0F * 1.05F);
    localARCircle.b = (this.jdField_b_of_type_Int / 2 - 100);
    localARCircle.c = (this.jdField_c_of_type_Int / 2);
    localARCircle.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle = localARCircle;
    a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_b_of_type_ArrayOfAndroidGraphicsPointF, 0, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.e, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog
 * JD-Core Version:    0.7.0.1
 */