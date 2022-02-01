package com.tencent.mobileqq.ar.arengine;

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
  private static boolean jdField_e_of_type_Boolean = false;
  private static boolean jdField_f_of_type_Boolean = false;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  PointF jdField_a_of_type_AndroidGraphicsPointF;
  private AVGestureWrapper jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper = null;
  private ARLocalGestureCircleRecog.ARLocalGestureCircleRecogCallback jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ARLocalGestureCircleRecogCallback = null;
  private ARLocalGestureCircleRecog.ProcessWorker jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker = null;
  private ARLocalGestureCircleRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult = new ARLocalGestureCircleRecogResult();
  private Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  PointF[] jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
  private int jdField_b_of_type_Int = 480;
  private long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 640;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private long jdField_e_of_type_Long = 0L;
  private long jdField_f_of_type_Long = 0L;
  
  ARLocalGestureCircleRecog()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ar_cloud_img/");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(-1.0F, -1.0F);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[100];
  }
  
  public static PointF a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PointF paramPointF)
  {
    float f1 = paramInt3;
    return new PointF(f1 - paramPointF.y / paramInt2 * f1, paramPointF.x / paramInt1 * paramInt4);
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool1 = GestureRecognitionUtils.a();
      boolean bool2 = SdkContext.getInstance().getResources().getGestureResource().isGestureEnable();
      if ((bool1) && (bool2))
      {
        String str = SdkContext.getInstance().getResources().getGestureResource().getSoPathDir();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("libAVGesture4Android");
        ((StringBuilder)localObject2).append(".so");
        str = ((StringBuilder)localObject2).toString();
        if (!new File(str).exists())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("load gesture so failed. so not exist. soFilename = ");
          ((StringBuilder)localObject2).append(str);
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, ((StringBuilder)localObject2).toString());
          return false;
        }
        localObject2 = PortalUtils.a(str);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("load gesture so... md5FromCalc = ");
        localStringBuilder2.append((String)localObject2);
        QLog.i("AREngine_ARLocalGestureCircleRecog", 2, localStringBuilder2.toString());
        try
        {
          System.load(str);
          jdField_e_of_type_Boolean = true;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("load gesture so ok. soFilename = ");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(", SDKVersion = ");
          ((StringBuilder)localObject2).append(AVGestureWrapper.getVersionInfo());
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, ((StringBuilder)localObject2).toString());
        }
        catch (Throwable localThrowable)
        {
          jdField_e_of_type_Boolean = false;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("load gesture so failed. err = ");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, ((StringBuilder)localObject2).toString());
        }
        bool1 = jdField_e_of_type_Boolean;
        return bool1;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("load gesture so failed. isGestureResourceReady = ");
      localStringBuilder1.append(bool1);
      localStringBuilder1.append(", isGestureEnable = ");
      localStringBuilder1.append(bool2);
      QLog.i("AREngine_ARLocalGestureCircleRecog", 2, localStringBuilder1.toString());
      return false;
    }
    finally {}
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 69	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic 133	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   15: invokevirtual 137	com/tencent/sveffects/SdkContext:getResources	()Lcom/tencent/mobileqq/shortvideo/resource/Resources;
    //   18: invokeinterface 143 1 0
    //   23: invokeinterface 215 1 0
    //   28: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: getstatic 89	java/io/File:separator	Ljava/lang/String;
    //   36: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_2
    //   45: new 78	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 161	java/io/File:exists	()Z
    //   58: ifne +39 -> 97
    //   61: new 69	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   68: astore_2
    //   69: aload_2
    //   70: ldc 217
    //   72: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: aload_1
    //   78: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 165
    //   84: iconst_2
    //   85: aload_2
    //   86: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: ldc 2
    //   94: monitorexit
    //   95: iconst_0
    //   96: ireturn
    //   97: new 69	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: ldc 222
    //   108: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_3
    //   113: aload_1
    //   114: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 165
    //   120: iconst_2
    //   121: aload_3
    //   122: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_2
    //   129: aload_2
    //   130: aload_2
    //   131: invokestatic 226	com/tencent/av/avgesture/AVGestureWrapper:setFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   134: pop
    //   135: aload_2
    //   136: invokestatic 230	com/tencent/av/avgesture/AVGestureWrapper:setGlobalConfigFile	(Ljava/lang/String;)Z
    //   139: pop
    //   140: new 232	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$1
    //   143: dup
    //   144: invokespecial 233	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$1:<init>	()V
    //   147: invokestatic 237	com/tencent/av/avgesture/AVGestureWrapper:setAVGestureReport	(Lcom/tencent/av/avgesture/AVGestureWrapper$AVUploadReport;)V
    //   150: iconst_0
    //   151: invokestatic 241	com/tencent/av/avgesture/AVGestureWrapper:setShouldUpload	(Z)V
    //   154: iconst_1
    //   155: putstatic 243	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   158: ldc 165
    //   160: iconst_2
    //   161: ldc 245
    //   163: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: goto +88 -> 254
    //   169: astore_1
    //   170: goto +93 -> 263
    //   173: astore_1
    //   174: iconst_0
    //   175: putstatic 243	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   178: new 69	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   185: astore_2
    //   186: aload_2
    //   187: ldc 247
    //   189: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: aload_1
    //   195: invokevirtual 248	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: ldc 165
    //   204: iconst_2
    //   205: aload_2
    //   206: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: goto +42 -> 254
    //   215: astore_1
    //   216: iconst_0
    //   217: putstatic 243	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   220: new 69	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   227: astore_2
    //   228: aload_2
    //   229: ldc 250
    //   231: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: aload_1
    //   237: invokevirtual 251	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   240: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 165
    //   246: iconst_2
    //   247: aload_2
    //   248: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 171	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: getstatic 243	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:jdField_f_of_type_Boolean	Z
    //   257: istore_0
    //   258: ldc 2
    //   260: monitorexit
    //   261: iload_0
    //   262: ireturn
    //   263: ldc 2
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   257	5	0	bool	boolean
    //   10	104	1	localObject1	Object
    //   169	1	1	localObject2	Object
    //   173	22	1	localException	java.lang.Exception
    //   215	52	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   44	204	2	localObject3	Object
    //   104	18	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	92	169	finally
    //   97	166	169	finally
    //   174	212	169	finally
    //   216	254	169	finally
    //   254	258	169	finally
    //   3	92	173	java/lang/Exception
    //   97	166	173	java/lang/Exception
    //   3	92	215	java/lang/UnsatisfiedLinkError
    //   97	166	215	java/lang/UnsatisfiedLinkError
  }
  
  private void f()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "delete backup file.");
    File[] arrayOfFile = new File(this.jdField_a_of_type_JavaLangString).listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        File localFile = arrayOfFile[i];
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  float a(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 != null) && (paramPointF2 != null))
    {
      float f1 = Math.abs(paramPointF1.x - paramPointF2.x);
      float f2 = Math.abs(paramPointF1.y - paramPointF2.y);
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return 0.0F;
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
  
  int a(PointF[] paramArrayOfPointF, int paramInt1, int[] paramArrayOfInt, int paramInt2, ARLocalGestureCircleRecogResult.ARCircle paramARCircle)
  {
    int i;
    if (!paramARCircle.jdField_a_of_type_Boolean) {
      i = -1;
    } else {
      i = 1;
    }
    float f2 = i * 360.0F / paramInt2;
    double d1 = f2 / 180.0F;
    Double.isNaN(d1);
    float f3 = (float)(d1 * 3.141592653589793D);
    d1 = 180.0F * f3;
    Double.isNaN(d1);
    Math.abs(d1 / 3.141592653589793D);
    int k = 0;
    if (i == -1) {
      i = 0;
    } else {
      i = 360;
    }
    PointF localPointF1 = new PointF(paramARCircle.b - paramARCircle.jdField_a_of_type_Float, paramARCircle.c);
    new PointF(paramARCircle.b, paramARCircle.c);
    float f1 = i;
    int j = paramInt1;
    paramInt1 = k;
    while (paramInt1 < paramInt2)
    {
      PointF localPointF2;
      if (paramInt1 == 0)
      {
        localPointF2 = new PointF(localPointF1.x - paramARCircle.b, localPointF1.y - paramARCircle.c);
      }
      else
      {
        k = j - 1;
        localPointF2 = new PointF(paramArrayOfPointF[k].x - paramARCircle.b, paramArrayOfPointF[k].y - paramARCircle.c);
      }
      PointF localPointF3 = new PointF(0.0F, 0.0F);
      d1 = f3;
      double d2 = Math.cos(d1);
      double d3 = localPointF2.x;
      Double.isNaN(d3);
      double d4 = Math.sin(d1);
      double d5 = localPointF2.y;
      Double.isNaN(d5);
      localPointF3.x = ((float)(d2 * d3 - d4 * d5) + paramARCircle.b);
      d2 = Math.sin(d1);
      d3 = localPointF2.x;
      Double.isNaN(d3);
      d1 = Math.cos(d1);
      d4 = localPointF2.y;
      Double.isNaN(d4);
      localPointF3.y = ((float)(d2 * d3 + d1 * d4) + paramARCircle.c);
      paramArrayOfPointF[j] = localPointF3;
      k = (int)(Math.random() * 210.0D + 30.0D);
      paramArrayOfInt[j] = (((int)f1 - k + 360) % 360);
      j += 1;
      paramInt1 += 1;
      f1 -= f2;
    }
    paramArrayOfPointF = new StringBuilder();
    paramArrayOfPointF.append("genCirclePoints4. pointCnt = ");
    paramArrayOfPointF.append(j);
    paramArrayOfPointF.append(", newCnt = ");
    paramArrayOfPointF.append(paramInt1);
    paramArrayOfPointF.append(", radianInc = ");
    paramArrayOfPointF.append(f3);
    paramArrayOfPointF.append(", startDegree = ");
    paramArrayOfPointF.append(i);
    paramArrayOfPointF.append(", startP.x = ");
    paramArrayOfPointF.append(localPointF1.x);
    paramArrayOfPointF.append(", startP.y = ");
    paramArrayOfPointF.append(localPointF1.y);
    paramArrayOfPointF.append(", circle.x = ");
    paramArrayOfPointF.append(paramARCircle.b);
    paramArrayOfPointF.append(", circle.y = ");
    paramArrayOfPointF.append(paramARCircle.c);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfPointF.toString());
    return j;
  }
  
  ARLocalGestureCircleRecogResult.ARCircle a(PointF[] paramArrayOfPointF, int paramInt)
  {
    if (paramInt < 3) {
      return null;
    }
    paramInt -= 1;
    return a(paramArrayOfPointF, paramInt, paramArrayOfPointF[paramInt]);
  }
  
  ARLocalGestureCircleRecogResult.ARCircle a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF)
  {
    int j = paramInt + 1;
    if (j < 3) {
      return null;
    }
    ARLocalGestureCircleRecogResult.ARCircle localARCircle = new ARLocalGestureCircleRecogResult.ARCircle();
    double d8 = 0.0D;
    double d1 = d8;
    double d2 = d1;
    double d3 = d2;
    double d4 = d3;
    double d5 = d4;
    double d6 = d5;
    double d7 = d6;
    double d9 = d7;
    int i = 0;
    while (i < paramInt)
    {
      d12 = paramArrayOfPointF[i].x;
      d10 = paramArrayOfPointF[i].y;
      Double.isNaN(d12);
      Double.isNaN(d12);
      d11 = d12 * d12;
      Double.isNaN(d10);
      Double.isNaN(d10);
      d13 = d10 * d10;
      Double.isNaN(d12);
      d9 += d12;
      Double.isNaN(d10);
      d8 += d10;
      d1 += d11;
      d2 += d13;
      Double.isNaN(d12);
      d3 += d11 * d12;
      Double.isNaN(d10);
      d4 += d13 * d10;
      Double.isNaN(d12);
      Double.isNaN(d10);
      d5 += d12 * d10;
      Double.isNaN(d12);
      d6 += d12 * d13;
      Double.isNaN(d10);
      d7 += d11 * d10;
      i += 1;
    }
    double d15 = paramPointF.x;
    double d11 = paramPointF.y;
    Double.isNaN(d15);
    Double.isNaN(d15);
    double d12 = d15 * d15;
    Double.isNaN(d11);
    Double.isNaN(d11);
    double d13 = d11 * d11;
    Double.isNaN(d15);
    d9 += d15;
    Double.isNaN(d11);
    d8 += d11;
    d1 += d12;
    double d10 = d2 + d13;
    Double.isNaN(d15);
    Double.isNaN(d11);
    Double.isNaN(d15);
    Double.isNaN(d11);
    Double.isNaN(d15);
    Double.isNaN(d11);
    d2 = j;
    Double.isNaN(d2);
    double d14 = d2 * d1 - d9 * d9;
    Double.isNaN(d2);
    d5 = (d5 + d15 * d11) * d2 - d9 * d8;
    Double.isNaN(d2);
    Double.isNaN(d2);
    double d16 = d1 + d10;
    d3 = (d3 + d12 * d15) * d2 + (d6 + d15 * d13) * d2 - d16 * d9;
    Double.isNaN(d2);
    d6 = d2 * d10 - d8 * d8;
    Double.isNaN(d2);
    Double.isNaN(d2);
    d7 = (d7 + d12 * d11) * d2 + (d4 + d13 * d11) * d2 - d16 * d8;
    d11 = d6 * d14;
    d12 = d5 * d5;
    d4 = (d7 * d5 - d3 * d6) / (d11 - d12);
    d3 = (d7 * d14 - d3 * d5) / (d12 - d11);
    d1 = -(d9 * d4 + d8 * d3 + d1 + d10);
    Double.isNaN(d2);
    d1 /= d2;
    localARCircle.b = ((float)d4 / -2.0F);
    localARCircle.c = ((float)d3 / -2.0F);
    localARCircle.jdField_a_of_type_Float = ((float)Math.sqrt(d4 * d4 + d3 * d3 - d1 * 4.0D) / 2.0F);
    int k = 0;
    int m = 0;
    for (i = 0;; i = j)
    {
      j = paramInt - 1;
      if (k >= j + 1) {
        break;
      }
      PointF localPointF1 = new PointF(localARCircle.b, localARCircle.c);
      PointF localPointF2 = new PointF(localARCircle.b + localARCircle.jdField_a_of_type_Float, localARCircle.c);
      float f2 = a(localPointF1, localPointF2, paramArrayOfPointF[k]);
      float f1;
      if (k != j) {
        f1 = a(localPointF1, localPointF2, paramArrayOfPointF[(k + 1)]);
      } else {
        f1 = a(localPointF1, localPointF2, paramPointF);
      }
      int n;
      if ((270.0F <= f2) && (f2 <= 360.0F) && (0.0F <= f1))
      {
        n = m;
        j = i;
        if (f1 <= 90.0F) {}
      }
      else if ((270.0F <= f1) && (f1 <= 360.0F) && (0.0F <= f2) && (f2 <= 90.0F))
      {
        n = m;
        j = i;
      }
      else
      {
        j = i;
        if (f1 > f2) {
          j = i + 1;
        }
        n = m + 1;
      }
      k += 1;
      m = n;
    }
    boolean bool;
    if ((m > 0) && (i <= m / 2.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    localARCircle.jdField_a_of_type_Boolean = bool;
    paramArrayOfPointF = new StringBuilder();
    paramArrayOfPointF.append("fitCircle. centerX = ");
    paramArrayOfPointF.append(localARCircle.b);
    paramArrayOfPointF.append(", centerY = ");
    paramArrayOfPointF.append(localARCircle.c);
    paramArrayOfPointF.append(", r = ");
    paramArrayOfPointF.append(localARCircle.jdField_a_of_type_Float);
    paramArrayOfPointF.append(", isClockwise = ");
    paramArrayOfPointF.append(localARCircle.jdField_a_of_type_Boolean);
    paramArrayOfPointF.append(", clockWiseCnt = ");
    paramArrayOfPointF.append(i);
    paramArrayOfPointF.append(", usedPointCnt = ");
    paramArrayOfPointF.append(m);
    paramArrayOfPointF.append(", pointCnt = ");
    paramArrayOfPointF.append(paramInt);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfPointF.toString());
    return localARCircle;
  }
  
  ARLocalGestureCircleRecogResult.ARGestureResult a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    ARLocalGestureCircleRecogResult.ARGestureResult localARGestureResult = new ARLocalGestureCircleRecogResult.ARGestureResult(1);
    PointF[] arrayOfPointF = new PointF[1];
    arrayOfPointF[0] = new PointF(-1.0F, -1.0F);
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper == null) {
          break label473;
        }
        boolean bool = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.doCalc(paramArrayOfByte, paramInt1, paramInt2, 2, 270, paramBoolean);
        localARGestureResult.jdField_a_of_type_Boolean = bool;
        localARGestureResult.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.getGestureType();
        arrayOfPointF[0] = this.jdField_a_of_type_ComTencentAvAvgestureAVGestureWrapper.getKeyPointByName("finger");
        if ((!bool) || (arrayOfPointF[0].x <= 0.0F) || (arrayOfPointF[0].y <= 0.0F)) {
          break label467;
        }
        if (paramBoolean)
        {
          if (localARGestureResult.jdField_a_of_type_JavaLangString.equalsIgnoreCase("finger1")) {
            break label461;
          }
          break label456;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("detectGesture. doCalc. isSuccess = ");
          paramArrayOfByte.append(paramBoolean);
          paramArrayOfByte.append(", res = ");
          paramArrayOfByte.append(bool);
          paramArrayOfByte.append(", type = ");
          paramArrayOfByte.append(localARGestureResult.jdField_a_of_type_JavaLangString);
          paramArrayOfByte.append(", x = ");
          paramArrayOfByte.append(arrayOfPointF[0].x);
          paramArrayOfByte.append(", y = ");
          paramArrayOfByte.append(arrayOfPointF[0].y);
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfByte.toString());
          if (paramBoolean)
          {
            paramArrayOfByte = localARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
            paramInt1 = localARGestureResult.jdField_b_of_type_Int;
            localARGestureResult.jdField_b_of_type_Int = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = new PointF(arrayOfPointF[0].x, arrayOfPointF[0].y);
            localARGestureResult.d = 0;
            localARGestureResult.jdField_a_of_type_Int = 0;
          }
          else
          {
            localARGestureResult.jdField_a_of_type_JavaLangString = "";
            paramArrayOfByte = localARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
            paramInt1 = localARGestureResult.jdField_b_of_type_Int;
            localARGestureResult.jdField_b_of_type_Int = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = new PointF(-1.0F, -1.0F);
            localARGestureResult.d = -1;
            localARGestureResult.jdField_a_of_type_Int = -1;
          }
          localARGestureResult.jdField_c_of_type_Int = ((int)(System.currentTimeMillis() - l));
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("detectGesture. gestureResult = ");
          paramArrayOfByte.append(localARGestureResult);
          paramArrayOfByte.append(", TotalTime = ");
          paramArrayOfByte.append(localARGestureResult.jdField_c_of_type_Int);
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfByte.toString());
          return localARGestureResult;
        }
      }
      label456:
      if (!paramBoolean)
      {
        label461:
        paramBoolean = true;
      }
      else
      {
        label467:
        paramBoolean = false;
        continue;
        label473:
        paramBoolean = false;
      }
    }
  }
  
  ARLocalGestureCircleRecogResult a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.d = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int < 999))
    {
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
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Boolean)) {
        bool = false;
      } else {
        bool = true;
      }
      Object localObject1 = a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, bool);
      paramInt1 = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Boolean = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_Boolean;
      float f1;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int == 0)
      {
        if (((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Int = 0;
          if (this.jdField_a_of_type_AndroidGraphicsPointF.x < 0.0F)
          {
            this.jdField_a_of_type_AndroidGraphicsPointF.x = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x;
            this.jdField_a_of_type_AndroidGraphicsPointF.y = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y;
            f1 = -1.0F;
          }
          else
          {
            f1 = a(this.jdField_a_of_type_AndroidGraphicsPointF, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
            this.jdField_a_of_type_AndroidGraphicsPointF.x = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x;
            this.jdField_a_of_type_AndroidGraphicsPointF.y = localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h < 4)
          {
            if (f1 > 30)
            {
              paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
              paramArrayOfByte.h += 1;
            }
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("detectImg. startDrawDetect. return. , px = ");
            paramArrayOfByte.append(localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x);
            paramArrayOfByte.append(", py = ");
            paramArrayOfByte.append(localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y);
            paramArrayOfByte.append(", d1 = ");
            paramArrayOfByte.append(f1);
            paramArrayOfByte.append(", d2 = ");
            paramArrayOfByte.append(-1.0F);
            paramArrayOfByte.append(", gesturePointCnt = ");
            paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h);
            paramArrayOfByte.append(", stillPointCnt = ");
            paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i);
            paramArrayOfByte.append(", goodPointCnt = ");
            paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j);
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfByte.toString());
            return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i < 4) {
            if ((f1 >= 0.0F) && (f1 < 30))
            {
              paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
              paramArrayOfByte.i += 1;
              if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i >= 4) {
                this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j = 0;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i = 0;
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j < 6)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j != 0)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j < 1) || (f1 <= 30)) {
                break label805;
              }
              float f4 = a(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j - 1)], localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0]);
              f3 = f1;
              f2 = f4;
              if (f4 <= 120) {
                break label960;
              }
              f2 = f4;
            }
            else
            {
              f2 = -1.0F;
            }
            paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
            paramArrayOfByte.j += 1;
            this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j - 1)] = new PointF(localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x, localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y);
            f3 = f1;
            break label960;
          }
        }
        else
        {
          label805:
          this.jdField_a_of_type_Int += 1;
          paramInt1 = this.jdField_a_of_type_Int;
          if (paramInt1 > 13)
          {
            this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h = 0;
            this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i = 0;
            this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j = 0;
          }
          else if (paramInt1 > 5)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h < 4) {
              this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h = 0;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i < 4) {
              this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i = 0;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j < 4) {
              this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j = 0;
            }
          }
          f1 = -1.0F;
        }
        float f2 = -1.0F;
        float f3 = f1;
        label960:
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h >= 4) && (((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i >= 4) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j >= 4)) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j >= 6)))
        {
          paramArrayOfByte = a(this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j);
          if (paramArrayOfByte != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Boolean = paramArrayOfByte.jdField_a_of_type_Boolean;
            a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_b_of_type_ArrayOfAndroidGraphicsPointF, 0, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.e, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle);
          }
          else
          {
            return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
          }
        }
        else
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("detectImg. startDrawDetect. return. , px = ");
          paramArrayOfByte.append(localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].x);
          paramArrayOfByte.append(", py = ");
          paramArrayOfByte.append(localObject1.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[0].y);
          paramArrayOfByte.append(", d1 = ");
          paramArrayOfByte.append(f3);
          paramArrayOfByte.append(", d2 = ");
          paramArrayOfByte.append(f2);
          paramArrayOfByte.append(", gesturePointCnt = ");
          paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.h);
          paramArrayOfByte.append(", stillPointCnt = ");
          paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.i);
          paramArrayOfByte.append(", goodPointCnt = ");
          paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j);
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfByte.toString());
          return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
        }
      }
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
      long l1;
      long l2;
      if ((paramArrayOfByte.x > 0.0F) && (paramArrayOfByte.y > 0.0F))
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.d = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).d;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Int = 0;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult;
        paramInt1 = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject2).jdField_b_of_type_Int;
        ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject2).jdField_b_of_type_Int = (paramInt1 + 1);
        localObject1[paramInt1] = paramArrayOfByte;
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int == 0)
        {
          if ((150.0F < paramArrayOfByte.x) && (paramArrayOfByte.x < this.jdField_b_of_type_Int - 150) && (50.0F < paramArrayOfByte.y) && (paramArrayOfByte.y < this.jdField_c_of_type_Int - 50))
          {
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
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Gesture failed. firstPoint. x = ");
            ((StringBuilder)localObject1).append(paramArrayOfByte.x);
            ((StringBuilder)localObject1).append(", y = ");
            ((StringBuilder)localObject1).append(paramArrayOfByte.y);
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          bool = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int, paramArrayOfByte, 20.0F);
          if (!bool)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int >= 2) {
              f1 = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int - 2)], this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_b_of_type_Int - 1)]);
            } else {
              f1 = a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - 1)], paramArrayOfByte);
            }
            if (f1 > 50.0F)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult;
              ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject1).j += 1;
              if (this.jdField_e_of_type_Long == 0L) {
                this.jdField_e_of_type_Long = System.currentTimeMillis();
              } else {
                this.jdField_f_of_type_Long = System.currentTimeMillis();
              }
              l1 = this.jdField_e_of_type_Long;
              if (l1 != 0L)
              {
                l2 = this.jdField_f_of_type_Long;
                if (l2 != 0L)
                {
                  paramInt1 = (int)(l2 - l1);
                  break label1990;
                }
              }
            }
            paramInt1 = 0;
            label1990:
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Gesture dist. dist = ");
            ((StringBuilder)localObject1).append(f1);
            ((StringBuilder)localObject1).append(", goodPointCnt = ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.j);
            ((StringBuilder)localObject1).append(", timeLen = ");
            ((StringBuilder)localObject1).append(paramInt1);
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, ((StringBuilder)localObject1).toString());
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
          }
          else
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("Gesture failed. isRepeat = ");
            paramArrayOfByte.append(bool);
            paramArrayOfByte.append(", isException = ");
            paramArrayOfByte.append(false);
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfByte.toString());
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_a_of_type_Int = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int > 0)
        {
          if (this.jdField_a_of_type_Long == 0L) {
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          } else {
            this.jdField_b_of_type_Long = System.currentTimeMillis();
          }
          l1 = this.jdField_a_of_type_Long;
          if (l1 != 0L)
          {
            l2 = this.jdField_b_of_type_Long;
            if (l2 != 0L)
            {
              paramInt1 = (int)(l2 - l1);
              break label2316;
            }
          }
          paramInt1 = 0;
          label2316:
          if (paramInt1 > 2000)
          {
            double d1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.g;
            double d2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.e;
            Double.isNaN(d2);
            if (d1 >= d2 * 0.8D) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            if (paramInt1 != 0) {
              this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = 0;
            } else {
              this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = -1;
            }
            this.jdField_a_of_type_Long = 0L;
            this.jdField_b_of_type_Long = 0L;
            return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.g >= this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.e - 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int = 0;
      }
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
    }
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. mRecogResult.circleResult.pointCnt >= ARLocalGestureCircleRecogResult.MAX_POINT_CNT - 1.");
    return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause. mIsPause = ");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, localStringBuilder.toString());
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.d == 1) {
        return;
      }
      ARLocalGestureCircleRecog.ProcessWorker localProcessWorker = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker;
      if (localProcessWorker != null) {
        localProcessWorker.a(paramLong, paramArrayOfByte);
      }
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecog. onPreviewFrame");
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, ARLocalGestureCircleRecog.ARLocalGestureCircleRecogCallback paramARLocalGestureCircleRecogCallback)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("init. imgW = ");
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append(", imgH = ");
    ((StringBuilder)???).append(paramInt2);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, ((StringBuilder)???).toString());
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
  
  boolean a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF, float paramFloat)
  {
    if ((paramArrayOfPointF != null) && (paramInt != 0))
    {
      if (paramPointF == null) {
        return false;
      }
      int i = 0;
      while (i < paramInt)
      {
        if (a(paramArrayOfPointF[i], paramPointF) < paramFloat) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume. mIsPause = ");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, localStringBuilder.toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker;
    if (localObject != null)
    {
      ((ARLocalGestureCircleRecog.ProcessWorker)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog$ProcessWorker = null;
    }
    this.jdField_b_of_type_Boolean = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop end. mIsStarted = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, ((StringBuilder)localObject).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start end. mIsStarted = ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, localStringBuilder.toString());
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append("uninit end. mIsInited = ");
      ((StringBuilder)???).append(this.jdField_a_of_type_Boolean);
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, ((StringBuilder)???).toString());
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
    int i = this.jdField_c_of_type_Int;
    localARCircle.jdField_a_of_type_Float = (i / 4.0F * 1.05F);
    localARCircle.b = (this.jdField_b_of_type_Int / 2 - 100);
    localARCircle.c = (i / 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog
 * JD-Core Version:    0.7.0.1
 */