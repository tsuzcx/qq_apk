package com.tencent.mobileqq.ar.arengine;

import alhk;
import alhl;
import alhm;
import alhn;
import alho;
import android.graphics.PointF;
import android.os.Environment;
import aurl;
import axje;
import bflj;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class ARLocalGestureCircleRecog
{
  private static boolean jdField_e_of_type_Boolean;
  private static boolean jdField_f_of_type_Boolean;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private alhk jdField_a_of_type_Alhk;
  private alhl jdField_a_of_type_Alhl = new alhl();
  PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(-1.0F, -1.0F);
  private AVGestureWrapper jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper;
  private ARLocalGestureCircleRecog.ProcessWorker jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker;
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
        boolean bool2 = axje.b();
        boolean bool3 = SdkContext.getInstance().getResources().getGestureResource().isGestureEnable();
        if ((!bool2) || (!bool3))
        {
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. isGestureResourceReady = " + bool2 + ", isGestureEnable = " + bool3);
          return bool1;
        }
        String str1 = SdkContext.getInstance().getResources().getGestureResource().getSoPathDir();
        str1 = str1 + "libAVGesture4Android" + ".so";
        if (!new File(str1).exists())
        {
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. so not exist. soFilename = " + str1);
          continue;
        }
        str3 = aurl.a(str2);
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
    //   12: invokestatic 107	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   15: invokevirtual 111	com/tencent/sveffects/SdkContext:getResources	()Lcom/tencent/mobileqq/shortvideo/resource/Resources;
    //   18: invokeinterface 117 1 0
    //   23: invokeinterface 193 1 0
    //   28: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: getstatic 60	java/io/File:separator	Ljava/lang/String;
    //   34: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 49	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 150	java/io/File:exists	()Z
    //   54: ifne +33 -> 87
    //   57: ldc 124
    //   59: iconst_2
    //   60: new 40	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   67: ldc 195
    //   69: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: ldc 2
    //   84: monitorexit
    //   85: iload_0
    //   86: ireturn
    //   87: ldc 124
    //   89: iconst_2
    //   90: new 40	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   97: ldc 200
    //   99: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_1
    //   113: aload_1
    //   114: aload_1
    //   115: invokestatic 204	com/tencent/av/avgesture/AVGestureWrapper:setFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   118: pop
    //   119: aload_1
    //   120: invokestatic 208	com/tencent/av/avgesture/AVGestureWrapper:setGlobalConfigFile	(Ljava/lang/String;)Z
    //   123: pop
    //   124: new 210	alhj
    //   127: dup
    //   128: invokespecial 211	alhj:<init>	()V
    //   131: invokestatic 215	com/tencent/av/avgesture/AVGestureWrapper:setAVGestureReport	(Lcom/tencent/av/avgesture/AVGestureWrapper$AVUploadReport;)V
    //   134: iconst_0
    //   135: invokestatic 219	com/tencent/av/avgesture/AVGestureWrapper:setShouldUpload	(Z)V
    //   138: iconst_1
    //   139: putstatic 221	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   142: ldc 124
    //   144: iconst_2
    //   145: ldc 223
    //   147: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: getstatic 221	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   153: istore_0
    //   154: goto -72 -> 82
    //   157: astore_1
    //   158: iconst_0
    //   159: putstatic 221	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   162: ldc 124
    //   164: iconst_2
    //   165: new 40	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   172: ldc 225
    //   174: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 226	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: goto -40 -> 150
    //   193: astore_1
    //   194: ldc 2
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: iconst_0
    //   201: putstatic 221	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   204: ldc 124
    //   206: iconst_2
    //   207: new 40	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   214: ldc 228
    //   216: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_1
    //   220: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   223: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    d1 = Math.acos((d2 * d2 + d3 * d3 - d1 * d1) / (d2 * 2.0D * d3)) * 180.0D / 3.141592653589793D;
    if (paramPointF3.y > paramPointF1.y) {
      return (float)d1;
    }
    return (float)(360.0D - d1);
  }
  
  int a(PointF[] paramArrayOfPointF, int paramInt1, int[] paramArrayOfInt, int paramInt2, alhm paramalhm)
  {
    int i = 1;
    if (!paramalhm.jdField_a_of_type_Boolean) {
      i = -1;
    }
    float f2 = i * 360.0F / paramInt2;
    float f3 = (float)(f2 / 180.0F * 3.141592653589793D);
    float f1 = (float)Math.abs(180.0F * f3 / 3.141592653589793D);
    if (i == -1) {}
    for (i = 0;; i = 360)
    {
      PointF localPointF2 = new PointF(paramalhm.b - paramalhm.jdField_a_of_type_Float, paramalhm.c);
      new PointF(paramalhm.b, paramalhm.c);
      f1 = i;
      int k = 0;
      int j = paramInt1;
      paramInt1 = k;
      if (paramInt1 < paramInt2)
      {
        if (paramInt1 == 0) {}
        for (PointF localPointF1 = new PointF(localPointF2.x - paramalhm.b, localPointF2.y - paramalhm.c);; localPointF1 = new PointF(paramArrayOfPointF[(j - 1)].x - paramalhm.b, paramArrayOfPointF[(j - 1)].y - paramalhm.c))
        {
          PointF localPointF3 = new PointF(0.0F, 0.0F);
          localPointF3.x = ((float)(Math.cos(f3) * localPointF1.x - Math.sin(f3) * localPointF1.y) + paramalhm.b);
          localPointF3.y = ((float)(Math.sin(f3) * localPointF1.x + Math.cos(f3) * localPointF1.y) + paramalhm.c);
          paramArrayOfPointF[j] = localPointF3;
          k = (int)(Math.random() * 210.0D + 30.0D);
          paramArrayOfInt[j] = (((int)f1 - k + 360) % 360);
          j += 1;
          paramInt1 += 1;
          f1 -= f2;
          break;
        }
      }
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "genCirclePoints4. pointCnt = " + j + ", newCnt = " + paramInt1 + ", radianInc = " + f3 + ", startDegree = " + i + ", startP.x = " + localPointF2.x + ", startP.y = " + localPointF2.y + ", circle.x = " + paramalhm.b + ", circle.y = " + paramalhm.c);
      return j;
    }
  }
  
  alhl a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_b_of_type_Int = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Int;
    this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.d = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int;
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int >= 999))
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. mRecogResult.circleResult.pointCnt >= ARLocalGestureCircleRecogResult.MAX_POINT_CNT - 1.");
      return this.jdField_a_of_type_Alhl;
    }
    if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_b_of_type_Int >= 999)
    {
      this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_b_of_type_Int = 0;
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. reset gesture result point cnt.");
    }
    if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Int == 0)
    {
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. state == ARCircleResult.CIRCLE_STATE_SUCCESS.");
      return this.jdField_a_of_type_Alhl;
    }
    boolean bool;
    Object localObject1;
    float f1;
    float f3;
    if ((this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int == 0) || (!this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_a_of_type_Boolean))
    {
      bool = true;
      localObject1 = a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, bool);
      if (((alho)localObject1).jdField_a_of_type_Int == 0) {}
      this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_a_of_type_Boolean = ((alho)localObject1).jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int != 0) {
        break label936;
      }
      f1 = -1.0F;
      f3 = -1.0F;
      if (((alho)localObject1).jdField_a_of_type_Int != 0) {
        break label1418;
      }
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidGraphicsPointF.x >= 0.0F) {
        break label470;
      }
      this.jdField_a_of_type_AndroidGraphicsPointF.x = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x;
    }
    for (this.jdField_a_of_type_AndroidGraphicsPointF.y = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y;; this.jdField_a_of_type_AndroidGraphicsPointF.y = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y)
    {
      if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.h >= 4) {
        break label524;
      }
      if (f1 > 30)
      {
        paramArrayOfByte = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn;
        paramArrayOfByte.h += 1;
      }
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. startDrawDetect. return. , px = " + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x + ", py = " + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y + ", d1 = " + f1 + ", d2 = " + -1.0F + ", gesturePointCnt = " + this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.h + ", stillPointCnt = " + this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i + ", goodPointCnt = " + this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j);
      return this.jdField_a_of_type_Alhl;
      bool = false;
      break;
      label470:
      f1 = a(this.jdField_a_of_type_AndroidGraphicsPointF, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
      this.jdField_a_of_type_AndroidGraphicsPointF.x = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x;
    }
    label524:
    if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i < 4)
    {
      if ((f1 < 0.0F) || (f1 >= 30)) {
        break label1404;
      }
      paramArrayOfByte = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn;
      paramArrayOfByte.i += 1;
      if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i >= 4) {
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j = 0;
      }
    }
    float f4 = f1;
    float f2 = f3;
    if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j < 6)
    {
      f2 = f3;
      if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j != 0)
      {
        f4 = f1;
        f2 = f3;
        if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j >= 1)
        {
          f4 = f1;
          f2 = f3;
          if (f1 > 30)
          {
            f3 = a(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j - 1)], localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
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
        paramArrayOfByte = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn;
        paramArrayOfByte.j += 1;
        this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j - 1)] = new PointF(localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y);
        f4 = f1;
      }
    }
    label793:
    label936:
    Object localObject2;
    if ((this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.h >= 4) && (((this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i >= 4) && (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j >= 4)) || (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j >= 6)))
    {
      paramArrayOfByte = a(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j);
      if (paramArrayOfByte != null)
      {
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Alhm.jdField_a_of_type_Boolean = paramArrayOfByte.jdField_a_of_type_Boolean;
        a(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_b_of_type_ArrayOfAndroidGraphicsPointF, 0, this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.e, this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Alhm);
        if ((this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int == 0) && (localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)].x > 0.0F) && (localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)].y > 0.0F) && (!((alho)localObject1).jdField_a_of_type_JavaLangString.equalsIgnoreCase("finger1")))
        {
          ((alho)localObject1).jdField_a_of_type_JavaLangString = "";
          localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)].x = -1.0F;
          localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)].y = -1.0F;
          ((alho)localObject1).d = -1;
          ((alho)localObject1).jdField_a_of_type_Int = -1;
        }
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_c_of_type_Int = ((alho)localObject1).jdField_c_of_type_Int;
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_a_of_type_JavaLangString = ((alho)localObject1).jdField_a_of_type_JavaLangString;
        paramArrayOfByte = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(localObject1.jdField_b_of_type_Int - 1)];
        if ((paramArrayOfByte.x <= 0.0F) || (paramArrayOfByte.y <= 0.0F)) {
          break label2220;
        }
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.d = ((alho)localObject1).d;
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_a_of_type_Int = 0;
        localObject1 = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
        localObject2 = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho;
        paramInt1 = ((alho)localObject2).jdField_b_of_type_Int;
        ((alho)localObject2).jdField_b_of_type_Int = (paramInt1 + 1);
        localObject1[paramInt1] = paramArrayOfByte;
        if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int != 0) {
          break label1779;
        }
        if ((150.0F >= paramArrayOfByte.x) || (paramArrayOfByte.x >= this.jdField_b_of_type_Int - 150) || (50.0F >= paramArrayOfByte.y) || (paramArrayOfByte.y >= this.jdField_c_of_type_Int - 50)) {
          break label1734;
        }
        localObject1 = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
        localObject2 = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn;
        paramInt1 = ((alhn)localObject2).jdField_c_of_type_Int;
        ((alhn)localObject2).jdField_c_of_type_Int = (paramInt1 + 1);
        localObject1[paramInt1] = new PointF(paramArrayOfByte.x, paramArrayOfByte.y);
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j = 0;
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        this.jdField_e_of_type_Long = System.currentTimeMillis();
        this.jdField_f_of_type_Long = 0L;
      }
    }
    label1404:
    do
    {
      for (;;)
      {
        paramInt1 = 0;
        if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.g >= this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.e - 1) {
          paramInt1 = 1;
        }
        if (paramInt1 != 0) {
          this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Int = 0;
        }
        return this.jdField_a_of_type_Alhl;
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i = 0;
        break;
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int > 13)
        {
          this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.h = 0;
          this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i = 0;
          this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j = 0;
          f4 = f1;
          f2 = f3;
          break label793;
        }
        f4 = f1;
        f2 = f3;
        if (this.jdField_a_of_type_Int <= 5) {
          break label793;
        }
        if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.h < 4) {
          this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.h = 0;
        }
        if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i < 4) {
          this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i = 0;
        }
        f4 = f1;
        f2 = f3;
        if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j >= 4) {
          break label793;
        }
        this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j = 0;
        f4 = f1;
        f2 = f3;
        break label793;
        return this.jdField_a_of_type_Alhl;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. startDrawDetect. return. , px = " + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x + ", py = " + localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y + ", d1 = " + f4 + ", d2 = " + f2 + ", gesturePointCnt = " + this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.h + ", stillPointCnt = " + this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.i + ", goodPointCnt = " + this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j);
        return this.jdField_a_of_type_Alhl;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture failed. firstPoint. x = " + paramArrayOfByte.x + ", y = " + paramArrayOfByte.y);
        continue;
        bool = a(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int, paramArrayOfByte, 20.0F);
        if ((!bool) && ((!bool) && (0 == 0))) {
          break label1863;
        }
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture failed. isRepeat = " + bool + ", isException = " + false);
      }
      if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_b_of_type_Int >= 2)
      {
        f1 = a(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_b_of_type_Int - 2)], this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_b_of_type_Int - 1)]);
        paramInt1 = 0;
        if (f1 > 50.0F)
        {
          localObject1 = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn;
          ((alhn)localObject1).j += 1;
          if (this.jdField_e_of_type_Long != 0L) {
            break label2205;
          }
          this.jdField_e_of_type_Long = System.currentTimeMillis();
          if ((this.jdField_e_of_type_Long == 0L) || (this.jdField_f_of_type_Long == 0L)) {
            break label2215;
          }
        }
      }
      for (paramInt1 = (int)(this.jdField_f_of_type_Long - this.jdField_e_of_type_Long);; paramInt1 = 0)
      {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture dist. dist = " + f1 + ", goodPointCnt = " + this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j + ", timeLen = " + paramInt1);
        if ((this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j >= 1) && (paramInt1 > 30))
        {
          localObject1 = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
          localObject2 = this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn;
          paramInt1 = ((alhn)localObject2).jdField_c_of_type_Int;
          ((alhn)localObject2).jdField_c_of_type_Int = (paramInt1 + 1);
          localObject1[paramInt1] = new PointF(paramArrayOfByte.x, paramArrayOfByte.y);
          this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.j = 0;
          this.jdField_e_of_type_Long = System.currentTimeMillis();
          this.jdField_f_of_type_Long = 0L;
        }
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        break;
        f1 = a(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int - 1)], paramArrayOfByte);
        break label1929;
        this.jdField_f_of_type_Long = System.currentTimeMillis();
        break label1977;
      }
      this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.jdField_a_of_type_Int = -1;
    } while (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_c_of_type_Int <= 0);
    label1418:
    label1734:
    label1779:
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long == 0L)) {
        break label2370;
      }
      paramInt1 = (int)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
      if (paramInt1 <= 2000) {
        break label2373;
      }
      paramInt1 = 0;
      if (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.g >= this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.e * 0.8D) {
        paramInt1 = 1;
      }
      if (paramInt1 == 0) {
        break label2375;
      }
    }
    label1863:
    label2260:
    label2289:
    for (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Int = -1)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      return this.jdField_a_of_type_Alhl;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      break label2260;
      paramInt1 = 0;
      break label2289;
      break;
    }
  }
  
  alhm a(PointF[] paramArrayOfPointF, int paramInt)
  {
    if (paramInt < 3) {
      return null;
    }
    return a(paramArrayOfPointF, paramInt - 1, paramArrayOfPointF[(paramInt - 1)]);
  }
  
  alhm a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF)
  {
    int j = paramInt + 1;
    if (j < 3) {
      return null;
    }
    alhm localalhm = new alhm();
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
    localalhm.b = ((float)d1 / -2.0F);
    localalhm.c = ((float)d2 / -2.0F);
    localalhm.jdField_a_of_type_Float = ((float)Math.sqrt(d2 * d2 + d1 * d1 - d3 * 4.0D) / 2.0F);
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
      localPointF1 = new PointF(localalhm.b, localalhm.c);
      localPointF2 = new PointF(localalhm.b + localalhm.jdField_a_of_type_Float, localalhm.c);
      f2 = a(localPointF1, localPointF2, paramArrayOfPointF[m]);
      if (m != paramInt - 1)
      {
        f1 = a(localPointF1, localPointF2, paramArrayOfPointF[(m + 1)]);
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
      f1 = a(localPointF1, localPointF2, paramPointF);
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
        localalhm.jdField_a_of_type_Boolean = bool;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "fitCircle. centerX = " + localalhm.b + ", centerY = " + localalhm.c + ", r = " + localalhm.jdField_a_of_type_Float + ", isClockwise = " + localalhm.jdField_a_of_type_Boolean + ", clockWiseCnt = " + i + ", usedPointCnt = " + j + ", pointCnt = " + paramInt);
        return localalhm;
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
  
  alho a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    alho localalho = new alho(1);
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
          localalho.jdField_a_of_type_Boolean = bool;
          localalho.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.getGestureType();
          arrayOfPointF[0] = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.getKeyPointByName("finger");
          if ((bool) && (arrayOfPointF[0].x > 0.0F) && (arrayOfPointF[0].y > 0.0F))
          {
            if (!paramBoolean) {
              break label434;
            }
            if (localalho.jdField_a_of_type_JavaLangString.equalsIgnoreCase("finger1")) {
              break label439;
            }
            break label434;
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectGesture. doCalc. isSuccess = " + paramBoolean + ", res = " + bool + ", type = " + localalho.jdField_a_of_type_JavaLangString + ", x = " + arrayOfPointF[0].x + ", y = " + arrayOfPointF[0].y);
            bool = paramBoolean;
          }
        }
        else
        {
          if (!bool) {
            break label377;
          }
          paramArrayOfByte = localalho.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
          paramInt1 = localalho.jdField_b_of_type_Int;
          localalho.jdField_b_of_type_Int = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = new PointF(arrayOfPointF[0].x, arrayOfPointF[0].y);
          localalho.d = 0;
          localalho.jdField_a_of_type_Int = 0;
          localalho.jdField_c_of_type_Int = ((int)(System.currentTimeMillis() - l));
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectGesture. gestureResult = " + localalho + ", TotalTime = " + localalho.jdField_c_of_type_Int);
          return localalho;
        }
        paramBoolean = false;
      }
      label377:
      localalho.jdField_a_of_type_JavaLangString = "";
      paramArrayOfByte = localalho.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
      paramInt1 = localalho.jdField_b_of_type_Int;
      localalho.jdField_b_of_type_Int = (paramInt1 + 1);
      paramArrayOfByte[paramInt1] = new PointF(-1.0F, -1.0F);
      localalho.d = -1;
      localalho.jdField_a_of_type_Int = -1;
      continue;
      label434:
      if (!paramBoolean) {
        label439:
        paramBoolean = true;
      }
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
    while (this.jdField_a_of_type_Alhl.jdField_a_of_type_Alho.d == 1) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker.a(paramLong, paramArrayOfByte);
    }
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecog. onPreviewFrame");
  }
  
  public boolean a(int paramInt1, int paramInt2, alhk paramalhk)
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
      bflj.a();
      if ((a()) && (b()) && (this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper == null)) {
        this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper = new AVGestureWrapper();
      }
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
      this.jdField_a_of_type_Alhk = paramalhk;
      e();
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker.a();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker = null;
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
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker == null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker = new ARLocalGestureCircleRecog.ProcessWorker(this);
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
    this.jdField_a_of_type_Alhk = null;
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
    this.jdField_a_of_type_Alhl.a();
    alhm localalhm = new alhm();
    localalhm.jdField_a_of_type_Float = (this.jdField_c_of_type_Int / 4.0F * 1.05F);
    localalhm.b = (this.jdField_b_of_type_Int / 2 - 100);
    localalhm.c = (this.jdField_c_of_type_Int / 2);
    localalhm.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Alhm = localalhm;
    a(this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_b_of_type_ArrayOfAndroidGraphicsPointF, 0, this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.e, this.jdField_a_of_type_Alhl.jdField_a_of_type_Alhn.jdField_a_of_type_Alhm);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog
 * JD-Core Version:    0.7.0.1
 */