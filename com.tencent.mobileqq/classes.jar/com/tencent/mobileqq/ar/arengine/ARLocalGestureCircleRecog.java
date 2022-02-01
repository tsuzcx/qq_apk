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
  private static boolean w = false;
  private static boolean x = false;
  String a;
  int b;
  PointF c;
  PointF[] d;
  private ARLocalGestureCircleRecog.ProcessWorker e = null;
  private Object f = new Object();
  private Object g = new Object();
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private int l = 480;
  private int m = 640;
  private long n = 0L;
  private long o = 0L;
  private long p = 0L;
  private long q = 0L;
  private long r = 0L;
  private long s = 0L;
  private AVGestureWrapper t = null;
  private ARLocalGestureCircleRecogResult u = new ARLocalGestureCircleRecogResult();
  private ARLocalGestureCircleRecog.ARLocalGestureCircleRecogCallback v = null;
  
  ARLocalGestureCircleRecog()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ar_cloud_img/");
    this.a = localStringBuilder.toString();
    this.b = 0;
    this.c = new PointF(-1.0F, -1.0F);
    this.d = new PointF[100];
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
          w = true;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("load gesture so ok. soFilename = ");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(", SDKVersion = ");
          ((StringBuilder)localObject2).append(AVGestureWrapper.getVersionInfo());
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, ((StringBuilder)localObject2).toString());
        }
        catch (Throwable localThrowable)
        {
          w = false;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("load gesture so failed. err = ");
          ((StringBuilder)localObject2).append(localThrowable.getMessage());
          QLog.i("AREngine_ARLocalGestureCircleRecog", 2, ((StringBuilder)localObject2).toString());
        }
        bool1 = w;
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
    //   3: new 87	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic 147	com/tencent/sveffects/SdkContext:getInstance	()Lcom/tencent/sveffects/SdkContext;
    //   15: invokevirtual 151	com/tencent/sveffects/SdkContext:getResources	()Lcom/tencent/mobileqq/shortvideo/resource/Resources;
    //   18: invokeinterface 157 1 0
    //   23: invokeinterface 227 1 0
    //   28: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: getstatic 107	java/io/File:separator	Ljava/lang/String;
    //   36: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_2
    //   45: new 96	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 175	java/io/File:exists	()Z
    //   58: ifne +39 -> 97
    //   61: new 87	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   68: astore_2
    //   69: aload_2
    //   70: ldc 229
    //   72: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: aload_1
    //   78: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc 179
    //   84: iconst_2
    //   85: aload_2
    //   86: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: ldc 2
    //   94: monitorexit
    //   95: iconst_0
    //   96: ireturn
    //   97: new 87	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   104: astore_3
    //   105: aload_3
    //   106: ldc 234
    //   108: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_3
    //   113: aload_1
    //   114: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 179
    //   120: iconst_2
    //   121: aload_3
    //   122: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_2
    //   129: aload_2
    //   130: aload_2
    //   131: invokestatic 238	com/tencent/av/avgesture/AVGestureWrapper:setFilePath	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   134: pop
    //   135: aload_2
    //   136: invokestatic 242	com/tencent/av/avgesture/AVGestureWrapper:setGlobalConfigFile	(Ljava/lang/String;)Z
    //   139: pop
    //   140: new 244	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$1
    //   143: dup
    //   144: invokespecial 245	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog$1:<init>	()V
    //   147: invokestatic 249	com/tencent/av/avgesture/AVGestureWrapper:setAVGestureReport	(Lcom/tencent/av/avgesture/AVGestureWrapper$AVUploadReport;)V
    //   150: iconst_0
    //   151: invokestatic 253	com/tencent/av/avgesture/AVGestureWrapper:setShouldUpload	(Z)V
    //   154: iconst_1
    //   155: putstatic 255	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:x	Z
    //   158: ldc 179
    //   160: iconst_2
    //   161: ldc_w 257
    //   164: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: goto +90 -> 257
    //   170: astore_1
    //   171: goto +95 -> 266
    //   174: astore_1
    //   175: iconst_0
    //   176: putstatic 255	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:x	Z
    //   179: new 87	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   186: astore_2
    //   187: aload_2
    //   188: ldc_w 259
    //   191: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: aload_1
    //   197: invokevirtual 260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: ldc 179
    //   206: iconst_2
    //   207: aload_2
    //   208: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: goto +43 -> 257
    //   217: astore_1
    //   218: iconst_0
    //   219: putstatic 255	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:x	Z
    //   222: new 87	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   229: astore_2
    //   230: aload_2
    //   231: ldc_w 262
    //   234: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_2
    //   239: aload_1
    //   240: invokevirtual 263	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 179
    //   249: iconst_2
    //   250: aload_2
    //   251: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: getstatic 255	com/tencent/mobileqq/ar/arengine/ARLocalGestureCircleRecog:x	Z
    //   260: istore_0
    //   261: ldc 2
    //   263: monitorexit
    //   264: iload_0
    //   265: ireturn
    //   266: ldc 2
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   260	5	0	bool	boolean
    //   10	104	1	localObject1	Object
    //   170	1	1	localObject2	Object
    //   174	23	1	localException	java.lang.Exception
    //   217	53	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   44	207	2	localObject3	Object
    //   104	18	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	92	170	finally
    //   97	167	170	finally
    //   175	214	170	finally
    //   218	257	170	finally
    //   257	261	170	finally
    //   3	92	174	java/lang/Exception
    //   97	167	174	java/lang/Exception
    //   3	92	217	java/lang/UnsatisfiedLinkError
    //   97	167	217	java/lang/UnsatisfiedLinkError
  }
  
  private void j()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "delete backup file.");
    File[] arrayOfFile = new File(this.a).listFiles();
    if (arrayOfFile != null)
    {
      int i1 = 0;
      while (i1 < arrayOfFile.length)
      {
        File localFile = arrayOfFile[i1];
        if (localFile.exists()) {
          localFile.delete();
        }
        i1 += 1;
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
    int i1;
    if (!paramARCircle.d) {
      i1 = -1;
    } else {
      i1 = 1;
    }
    float f2 = i1 * 360.0F / paramInt2;
    double d1 = f2 / 180.0F;
    Double.isNaN(d1);
    float f3 = (float)(d1 * 3.141592653589793D);
    d1 = 180.0F * f3;
    Double.isNaN(d1);
    Math.abs(d1 / 3.141592653589793D);
    int i3 = 0;
    if (i1 == -1) {
      i1 = 0;
    } else {
      i1 = 360;
    }
    PointF localPointF1 = new PointF(paramARCircle.b - paramARCircle.a, paramARCircle.c);
    new PointF(paramARCircle.b, paramARCircle.c);
    float f1 = i1;
    int i2 = paramInt1;
    paramInt1 = i3;
    while (paramInt1 < paramInt2)
    {
      PointF localPointF2;
      if (paramInt1 == 0)
      {
        localPointF2 = new PointF(localPointF1.x - paramARCircle.b, localPointF1.y - paramARCircle.c);
      }
      else
      {
        i3 = i2 - 1;
        localPointF2 = new PointF(paramArrayOfPointF[i3].x - paramARCircle.b, paramArrayOfPointF[i3].y - paramARCircle.c);
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
      paramArrayOfPointF[i2] = localPointF3;
      i3 = (int)(Math.random() * 210.0D + 30.0D);
      paramArrayOfInt[i2] = (((int)f1 - i3 + 360) % 360);
      i2 += 1;
      paramInt1 += 1;
      f1 -= f2;
    }
    paramArrayOfPointF = new StringBuilder();
    paramArrayOfPointF.append("genCirclePoints4. pointCnt = ");
    paramArrayOfPointF.append(i2);
    paramArrayOfPointF.append(", newCnt = ");
    paramArrayOfPointF.append(paramInt1);
    paramArrayOfPointF.append(", radianInc = ");
    paramArrayOfPointF.append(f3);
    paramArrayOfPointF.append(", startDegree = ");
    paramArrayOfPointF.append(i1);
    paramArrayOfPointF.append(", startP.x = ");
    paramArrayOfPointF.append(localPointF1.x);
    paramArrayOfPointF.append(", startP.y = ");
    paramArrayOfPointF.append(localPointF1.y);
    paramArrayOfPointF.append(", circle.x = ");
    paramArrayOfPointF.append(paramARCircle.b);
    paramArrayOfPointF.append(", circle.y = ");
    paramArrayOfPointF.append(paramARCircle.c);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfPointF.toString());
    return i2;
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
    int i2 = paramInt + 1;
    if (i2 < 3) {
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
    int i1 = 0;
    while (i1 < paramInt)
    {
      d12 = paramArrayOfPointF[i1].x;
      d10 = paramArrayOfPointF[i1].y;
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
      i1 += 1;
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
    d2 = i2;
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
    localARCircle.a = ((float)Math.sqrt(d4 * d4 + d3 * d3 - d1 * 4.0D) / 2.0F);
    int i3 = 0;
    int i4 = 0;
    for (i1 = 0;; i1 = i2)
    {
      i2 = paramInt - 1;
      if (i3 >= i2 + 1) {
        break;
      }
      PointF localPointF1 = new PointF(localARCircle.b, localARCircle.c);
      PointF localPointF2 = new PointF(localARCircle.b + localARCircle.a, localARCircle.c);
      float f2 = a(localPointF1, localPointF2, paramArrayOfPointF[i3]);
      float f1;
      if (i3 != i2) {
        f1 = a(localPointF1, localPointF2, paramArrayOfPointF[(i3 + 1)]);
      } else {
        f1 = a(localPointF1, localPointF2, paramPointF);
      }
      int i5;
      if ((270.0F <= f2) && (f2 <= 360.0F) && (0.0F <= f1))
      {
        i5 = i4;
        i2 = i1;
        if (f1 <= 90.0F) {}
      }
      else if ((270.0F <= f1) && (f1 <= 360.0F) && (0.0F <= f2) && (f2 <= 90.0F))
      {
        i5 = i4;
        i2 = i1;
      }
      else
      {
        i2 = i1;
        if (f1 > f2) {
          i2 = i1 + 1;
        }
        i5 = i4 + 1;
      }
      i3 += 1;
      i4 = i5;
    }
    boolean bool;
    if ((i4 > 0) && (i1 <= i4 / 2.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    localARCircle.d = bool;
    paramArrayOfPointF = new StringBuilder();
    paramArrayOfPointF.append("fitCircle. centerX = ");
    paramArrayOfPointF.append(localARCircle.b);
    paramArrayOfPointF.append(", centerY = ");
    paramArrayOfPointF.append(localARCircle.c);
    paramArrayOfPointF.append(", r = ");
    paramArrayOfPointF.append(localARCircle.a);
    paramArrayOfPointF.append(", isClockwise = ");
    paramArrayOfPointF.append(localARCircle.d);
    paramArrayOfPointF.append(", clockWiseCnt = ");
    paramArrayOfPointF.append(i1);
    paramArrayOfPointF.append(", usedPointCnt = ");
    paramArrayOfPointF.append(i4);
    paramArrayOfPointF.append(", pointCnt = ");
    paramArrayOfPointF.append(paramInt);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfPointF.toString());
    return localARCircle;
  }
  
  ARLocalGestureCircleRecogResult.ARGestureResult a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    ARLocalGestureCircleRecogResult.ARGestureResult localARGestureResult = new ARLocalGestureCircleRecogResult.ARGestureResult(1);
    PointF[] arrayOfPointF = new PointF[1];
    arrayOfPointF[0] = new PointF(-1.0F, -1.0F);
    for (;;)
    {
      synchronized (this.g)
      {
        if (this.t == null) {
          break label473;
        }
        boolean bool = this.t.doCalc(paramArrayOfByte, paramInt1, paramInt2, 2, 270, paramBoolean);
        localARGestureResult.a = bool;
        localARGestureResult.c = this.t.getGestureType();
        arrayOfPointF[0] = this.t.getKeyPointByName("finger");
        if ((!bool) || (arrayOfPointF[0].x <= 0.0F) || (arrayOfPointF[0].y <= 0.0F)) {
          break label467;
        }
        if (paramBoolean)
        {
          if (localARGestureResult.c.equalsIgnoreCase("finger1")) {
            break label461;
          }
          break label456;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("detectGesture. doCalc. isSuccess = ");
          paramArrayOfByte.append(paramBoolean);
          paramArrayOfByte.append(", res = ");
          paramArrayOfByte.append(bool);
          paramArrayOfByte.append(", type = ");
          paramArrayOfByte.append(localARGestureResult.c);
          paramArrayOfByte.append(", x = ");
          paramArrayOfByte.append(arrayOfPointF[0].x);
          paramArrayOfByte.append(", y = ");
          paramArrayOfByte.append(arrayOfPointF[0].y);
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfByte.toString());
          if (paramBoolean)
          {
            paramArrayOfByte = localARGestureResult.d;
            paramInt1 = localARGestureResult.e;
            localARGestureResult.e = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = new PointF(arrayOfPointF[0].x, arrayOfPointF[0].y);
            localARGestureResult.g = 0;
            localARGestureResult.b = 0;
          }
          else
          {
            localARGestureResult.c = "";
            paramArrayOfByte = localARGestureResult.d;
            paramInt1 = localARGestureResult.e;
            localARGestureResult.e = (paramInt1 + 1);
            paramArrayOfByte[paramInt1] = new PointF(-1.0F, -1.0F);
            localARGestureResult.g = -1;
            localARGestureResult.b = -1;
          }
          localARGestureResult.f = ((int)(System.currentTimeMillis() - l1));
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("detectGesture. gestureResult = ");
          paramArrayOfByte.append(localARGestureResult);
          paramArrayOfByte.append(", TotalTime = ");
          paramArrayOfByte.append(localARGestureResult.f);
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
    this.u.c.b = this.u.c.a;
    this.u.c.f = this.u.c.e;
    if ((this.i) && (this.u.c.e < 999))
    {
      if (this.u.b.e >= 999)
      {
        this.u.b.e = 0;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. reset gesture result point cnt.");
      }
      if (this.u.c.a == 0)
      {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. state == ARCircleResult.CIRCLE_STATE_SUCCESS.");
        return this.u;
      }
      boolean bool;
      if ((this.u.c.e != 0) && (this.u.b.a)) {
        bool = false;
      } else {
        bool = true;
      }
      Object localObject1 = a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, bool);
      paramInt1 = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).b;
      this.u.b.a = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).a;
      float f1;
      if (this.u.c.e == 0)
      {
        if (((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).b == 0)
        {
          this.b = 0;
          if (this.c.x < 0.0F)
          {
            this.c.x = localObject1.d[0].x;
            this.c.y = localObject1.d[0].y;
            f1 = -1.0F;
          }
          else
          {
            f1 = a(this.c, localObject1.d[0]);
            this.c.x = localObject1.d[0].x;
            this.c.y = localObject1.d[0].y;
          }
          if (this.u.c.l < 4)
          {
            if (f1 > 30)
            {
              paramArrayOfByte = this.u.c;
              paramArrayOfByte.l += 1;
            }
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("detectImg. startDrawDetect. return. , px = ");
            paramArrayOfByte.append(localObject1.d[0].x);
            paramArrayOfByte.append(", py = ");
            paramArrayOfByte.append(localObject1.d[0].y);
            paramArrayOfByte.append(", d1 = ");
            paramArrayOfByte.append(f1);
            paramArrayOfByte.append(", d2 = ");
            paramArrayOfByte.append(-1.0F);
            paramArrayOfByte.append(", gesturePointCnt = ");
            paramArrayOfByte.append(this.u.c.l);
            paramArrayOfByte.append(", stillPointCnt = ");
            paramArrayOfByte.append(this.u.c.m);
            paramArrayOfByte.append(", goodPointCnt = ");
            paramArrayOfByte.append(this.u.c.n);
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfByte.toString());
            return this.u;
          }
          if (this.u.c.m < 4) {
            if ((f1 >= 0.0F) && (f1 < 30))
            {
              paramArrayOfByte = this.u.c;
              paramArrayOfByte.m += 1;
              if (this.u.c.m >= 4) {
                this.u.c.n = 0;
              }
            }
            else
            {
              this.u.c.m = 0;
            }
          }
          if (this.u.c.n < 6)
          {
            if (this.u.c.n != 0)
            {
              if ((this.u.c.n < 1) || (f1 <= 30)) {
                break label805;
              }
              float f4 = a(this.d[(this.u.c.n - 1)], localObject1.d[0]);
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
            paramArrayOfByte = this.u.c;
            paramArrayOfByte.n += 1;
            this.d[(this.u.c.n - 1)] = new PointF(localObject1.d[0].x, localObject1.d[0].y);
            f3 = f1;
            break label960;
          }
        }
        else
        {
          label805:
          this.b += 1;
          paramInt1 = this.b;
          if (paramInt1 > 13)
          {
            this.u.c.l = 0;
            this.u.c.m = 0;
            this.u.c.n = 0;
          }
          else if (paramInt1 > 5)
          {
            if (this.u.c.l < 4) {
              this.u.c.l = 0;
            }
            if (this.u.c.m < 4) {
              this.u.c.m = 0;
            }
            if (this.u.c.n < 4) {
              this.u.c.n = 0;
            }
          }
          f1 = -1.0F;
        }
        float f2 = -1.0F;
        float f3 = f1;
        label960:
        if ((this.u.c.l >= 4) && (((this.u.c.m >= 4) && (this.u.c.n >= 4)) || (this.u.c.n >= 6)))
        {
          paramArrayOfByte = a(this.d, this.u.c.n);
          if (paramArrayOfByte != null)
          {
            this.u.c.c.d = paramArrayOfByte.d;
            a(this.u.c.g, 0, this.u.c.h, this.u.c.i, this.u.c.c);
          }
          else
          {
            return this.u;
          }
        }
        else
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("detectImg. startDrawDetect. return. , px = ");
          paramArrayOfByte.append(localObject1.d[0].x);
          paramArrayOfByte.append(", py = ");
          paramArrayOfByte.append(localObject1.d[0].y);
          paramArrayOfByte.append(", d1 = ");
          paramArrayOfByte.append(f3);
          paramArrayOfByte.append(", d2 = ");
          paramArrayOfByte.append(f2);
          paramArrayOfByte.append(", gesturePointCnt = ");
          paramArrayOfByte.append(this.u.c.l);
          paramArrayOfByte.append(", stillPointCnt = ");
          paramArrayOfByte.append(this.u.c.m);
          paramArrayOfByte.append(", goodPointCnt = ");
          paramArrayOfByte.append(this.u.c.n);
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, paramArrayOfByte.toString());
          return this.u;
        }
      }
      if ((this.u.c.e == 0) && (localObject1.d[(localObject1.e - 1)].x > 0.0F) && (localObject1.d[(localObject1.e - 1)].y > 0.0F) && (!((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).c.equalsIgnoreCase("finger1")))
      {
        ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).c = "";
        localObject1.d[(localObject1.e - 1)].x = -1.0F;
        localObject1.d[(localObject1.e - 1)].y = -1.0F;
        ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).g = -1;
        ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).b = -1;
      }
      this.u.b.f = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).f;
      this.u.b.c = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).c;
      paramArrayOfByte = localObject1.d[(localObject1.e - 1)];
      long l1;
      long l2;
      if ((paramArrayOfByte.x > 0.0F) && (paramArrayOfByte.y > 0.0F))
      {
        this.u.b.g = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject1).g;
        this.u.b.b = 0;
        localObject1 = this.u.b.d;
        Object localObject2 = this.u.b;
        paramInt1 = ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject2).e;
        ((ARLocalGestureCircleRecogResult.ARGestureResult)localObject2).e = (paramInt1 + 1);
        localObject1[paramInt1] = paramArrayOfByte;
        if (this.u.c.e == 0)
        {
          if ((150.0F < paramArrayOfByte.x) && (paramArrayOfByte.x < this.l - 150) && (50.0F < paramArrayOfByte.y) && (paramArrayOfByte.y < this.m - 50))
          {
            localObject1 = this.u.c.d;
            localObject2 = this.u.c;
            paramInt1 = ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject2).e;
            ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject2).e = (paramInt1 + 1);
            localObject1[paramInt1] = new PointF(paramArrayOfByte.x, paramArrayOfByte.y);
            this.u.c.a = 1;
            this.u.c.n = 0;
            this.n = 0L;
            this.o = 0L;
            this.r = System.currentTimeMillis();
            this.s = 0L;
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
          bool = a(this.u.c.d, this.u.c.e, paramArrayOfByte, 20.0F);
          if (!bool)
          {
            if (this.u.b.e >= 2) {
              f1 = a(this.u.b.d[(this.u.b.e - 2)], this.u.b.d[(this.u.b.e - 1)]);
            } else {
              f1 = a(this.u.c.d[(this.u.c.e - 1)], paramArrayOfByte);
            }
            if (f1 > 50.0F)
            {
              localObject1 = this.u.c;
              ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject1).n += 1;
              if (this.r == 0L) {
                this.r = System.currentTimeMillis();
              } else {
                this.s = System.currentTimeMillis();
              }
              l1 = this.r;
              if (l1 != 0L)
              {
                l2 = this.s;
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
            ((StringBuilder)localObject1).append(this.u.c.n);
            ((StringBuilder)localObject1).append(", timeLen = ");
            ((StringBuilder)localObject1).append(paramInt1);
            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, ((StringBuilder)localObject1).toString());
            if ((this.u.c.n >= 1) && (paramInt1 > 30))
            {
              localObject1 = this.u.c.d;
              localObject2 = this.u.c;
              paramInt1 = ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject2).e;
              ((ARLocalGestureCircleRecogResult.ARCircleResult)localObject2).e = (paramInt1 + 1);
              localObject1[paramInt1] = new PointF(paramArrayOfByte.x, paramArrayOfByte.y);
              this.u.c.n = 0;
              this.r = System.currentTimeMillis();
              this.s = 0L;
            }
            this.n = 0L;
            this.o = 0L;
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
        this.u.b.b = -1;
        if (this.u.c.e > 0)
        {
          if (this.n == 0L) {
            this.n = System.currentTimeMillis();
          } else {
            this.o = System.currentTimeMillis();
          }
          l1 = this.n;
          if (l1 != 0L)
          {
            l2 = this.o;
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
            double d1 = this.u.c.k;
            double d2 = this.u.c.i;
            Double.isNaN(d2);
            if (d1 >= d2 * 0.8D) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            if (paramInt1 != 0) {
              this.u.c.a = 0;
            } else {
              this.u.c.a = -1;
            }
            this.n = 0L;
            this.o = 0L;
            return this.u;
          }
        }
      }
      if (this.u.c.k >= this.u.c.i - 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        this.u.c.a = 0;
      }
      return this.u;
    }
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. mRecogResult.circleResult.pointCnt >= ARLocalGestureCircleRecogResult.MAX_POINT_CNT - 1.");
    return this.u;
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (this.i))
    {
      if (this.k) {
        return;
      }
      if (this.u.b.g == 1) {
        return;
      }
      ARLocalGestureCircleRecog.ProcessWorker localProcessWorker = this.e;
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
    if (this.h) {
      return true;
    }
    this.h = false;
    this.i = false;
    this.j = false;
    synchronized (this.g)
    {
      SvEffectSdkInitor.a();
      if ((a()) && (b()) && (this.t == null)) {
        this.t = new AVGestureWrapper();
      }
      this.l = paramInt1;
      this.m = paramInt2;
      this.v = paramARLocalGestureCircleRecogCallback;
      i();
      this.h = true;
      return this.h;
    }
  }
  
  boolean a(PointF[] paramArrayOfPointF, int paramInt, PointF paramPointF, float paramFloat)
  {
    if ((paramArrayOfPointF != null) && (paramInt != 0))
    {
      if (paramPointF == null) {
        return false;
      }
      int i1 = 0;
      while (i1 < paramInt)
      {
        if (a(paramArrayOfPointF[i1], paramPointF) < paramFloat) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public boolean c()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "start start.");
    if (this.i) {
      return true;
    }
    if (this.e == null) {
      this.e = new ARLocalGestureCircleRecog.ProcessWorker(this);
    }
    i();
    j();
    this.i = true;
    this.k = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start end. mIsStarted = ");
    localStringBuilder.append(this.i);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, localStringBuilder.toString());
    return true;
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause. mIsPause = ");
    localStringBuilder.append(this.k);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, localStringBuilder.toString());
    if (this.k) {
      return;
    }
    this.k = true;
  }
  
  public boolean e()
  {
    return this.k;
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume. mIsPause = ");
    localStringBuilder.append(this.k);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, localStringBuilder.toString());
    if (!this.k) {
      return;
    }
    this.k = false;
  }
  
  public void g()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "stop start.");
    if (!this.i) {
      return;
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      ((ARLocalGestureCircleRecog.ProcessWorker)localObject).a();
      this.e = null;
    }
    this.i = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop end. mIsStarted = ");
    ((StringBuilder)localObject).append(this.i);
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, ((StringBuilder)localObject).toString());
  }
  
  public void h()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "uninit start.");
    if (!this.h) {
      return;
    }
    this.v = null;
    synchronized (this.g)
    {
      if (this.t != null)
      {
        this.t.destroyRecognizor();
        this.t = null;
      }
      this.h = false;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("uninit end. mIsInited = ");
      ((StringBuilder)???).append(this.h);
      QLog.i("AREngine_ARLocalGestureCircleRecog", 1, ((StringBuilder)???).toString());
      return;
    }
  }
  
  public void i()
  {
    this.u.a();
    ARLocalGestureCircleRecogResult.ARCircle localARCircle = new ARLocalGestureCircleRecogResult.ARCircle();
    int i1 = this.m;
    localARCircle.a = (i1 / 4.0F * 1.05F);
    localARCircle.b = (this.l / 2 - 100);
    localARCircle.c = (i1 / 2);
    localARCircle.d = true;
    this.u.c.c = localARCircle;
    a(this.u.c.g, 0, this.u.c.h, this.u.c.i, this.u.c.c);
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
    this.q = 0L;
    this.r = 0L;
    this.s = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog
 * JD-Core Version:    0.7.0.1
 */