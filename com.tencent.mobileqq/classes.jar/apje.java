import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARCamera.1;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class apje
  implements Camera.AutoFocusCallback
{
  private static final int jdField_a_of_type_Int = ScreenUtil.SCREEN_WIDTH * 3 / 4;
  private static long jdField_a_of_type_Long = -1L;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final int jdField_b_of_type_Int = ScreenUtil.SCREEN_WIDTH * 3 / 4;
  private static int jdField_c_of_type_Int;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener = new apjf(this);
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
  private Handler jdField_a_of_type_AndroidOsHandler = new apjg(this, Looper.getMainLooper());
  private apjh jdField_a_of_type_Apjh;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_c_of_type_Int = -3;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    paramInt5 = (int)(paramInt5 * paramFloat);
    paramInt1 = a(paramInt1 - paramInt5 / 2, 0, paramInt3 - paramInt5);
    paramInt2 = a(paramInt2 - paramInt5 / 2, 0, paramInt4 - paramInt5);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + paramInt5, paramInt5 + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!b()) || (this.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      return;
      try
      {
        Camera.Parameters localParameters1 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters1.getSupportedFocusModes().contains("auto"))
        {
          Object localObject = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1.0F);
          Rect localRect = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1.0F);
          QLog.d("AREngine_ARCamera", 1, String.format("focusOnArea focusRect=%s meteringRect=%s", new Object[] { localObject, localRect }));
          localParameters1.setFocusMode("auto");
          if (localParameters1.getMaxNumFocusAreas() > 0)
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(new Camera.Area((Rect)localObject, 1000));
            localParameters1.setFocusAreas(localArrayList);
          }
          if (localParameters1.getMaxNumMeteringAreas() > 0)
          {
            localObject = new ArrayList();
            ((List)localObject).add(new Camera.Area(localRect, 1000));
            localParameters1.setMeteringAreas((List)localObject);
          }
          this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters1);
          this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this);
          this.jdField_a_of_type_Boolean = true;
          return;
        }
      }
      catch (Exception localException1)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", localException1);
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
          Camera.Parameters localParameters2 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
          hg.a(localParameters2);
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters2);
          return;
        }
        catch (Exception localException2)
        {
          QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", localException2);
        }
      }
    }
  }
  
  public static int b(int paramInt)
  {
    int i2 = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2) {
        try
        {
          Camera.getCameraInfo(i1, localCameraInfo);
          int i3 = localCameraInfo.facing;
          if (paramInt == i3) {
            return i1;
          }
          i1 += 1;
        }
        catch (Throwable localThrowable)
        {
          QLog.i("AREngine_ARCamera", 1, "checkCameraFacing error:" + localThrowable.getMessage());
        }
      }
    }
    return 0;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_b_of_type_Boolean = true;
        if (paramInt2 <= paramInt1) {
          break label39;
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = bool;
        this.k = paramInt1;
        this.l = paramInt2;
        g();
        return;
        label39:
        bool = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean b()
  {
    return !bdaw.d(bdaw.a);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("revertZoom mZooming=%s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        }
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters.isZoomSupported())
        {
          int i1 = localParameters.getZoom();
          if (i1 != this.i)
          {
            b(i1, this.i);
            bdla.b(null, "dc00898", "", "", "0X80085B0", "0X80085B0", 0, 0, "", "", "", "");
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        int i1 = this.k;
        int i2 = this.l;
        if (i1 != i2) {
          try
          {
            if (this.jdField_c_of_type_Boolean) {
              this.k += 5;
            }
            for (this.k = Math.min(this.k, this.l);; this.k = Math.max(this.k, this.l))
            {
              this.k = Math.min(this.k, this.j);
              this.k = Math.max(this.k, this.i);
              Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
              localParameters.setZoom(this.k);
              this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
              if (this.jdField_a_of_type_AndroidOsHandler == null) {
                break;
              }
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(102, 20L);
              return;
              this.k -= 5;
            }
            QLog.d("AREngine_ARCamera", 2, "updateZoom fail!", localException1);
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              break label189;
            }
          }
        } else {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      label189:
      return;
    }
    catch (Exception localException2) {}
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int i2 = 0;
    Object localObject1 = jdField_a_of_type_JavaLangObject;
    int i1 = i2;
    try
    {
      if (jdField_a_of_type_Long != -1L)
      {
        if (Thread.currentThread().getId() != jdField_a_of_type_Long) {
          break label53;
        }
        i1 = i2;
      }
      for (;;)
      {
        if (i1 == 0) {
          break;
        }
        return a(paramInt, 150L);
        label53:
        i1 = i2;
        if (jdField_c_of_type_Int == 0) {
          i1 = 1;
        }
      }
      return a(paramInt, 0L);
    }
    finally {}
  }
  
  /* Error */
  public int a(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 173
    //   2: iconst_1
    //   3: new 261	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 377
    //   13: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   20: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_0
    //   30: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   33: ifnull +37 -> 70
    //   36: getstatic 46	apje:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   39: astore 6
    //   41: aload 6
    //   43: monitorenter
    //   44: iconst_0
    //   45: putstatic 48	apje:jdField_c_of_type_Int	I
    //   48: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   51: invokevirtual 370	java/lang/Thread:getId	()J
    //   54: putstatic 52	apje:jdField_a_of_type_Long	J
    //   57: aload 6
    //   59: monitorexit
    //   60: iconst_0
    //   61: ireturn
    //   62: astore 7
    //   64: aload 6
    //   66: monitorexit
    //   67: aload 7
    //   69: athrow
    //   70: getstatic 385	android/os/Build:MODEL	Ljava/lang/String;
    //   73: ldc_w 387
    //   76: invokevirtual 390	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   79: ifne +21 -> 100
    //   82: getstatic 385	android/os/Build:MODEL	Ljava/lang/String;
    //   85: ldc_w 392
    //   88: invokevirtual 390	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   91: ifne +9 -> 100
    //   94: lload_2
    //   95: lconst_0
    //   96: lcmp
    //   97: ifeq +17 -> 114
    //   100: lload_2
    //   101: lconst_0
    //   102: lcmp
    //   103: ifeq +142 -> 245
    //   106: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   109: pop
    //   110: lload_2
    //   111: invokestatic 396	java/lang/Thread:sleep	(J)V
    //   114: getstatic 401	android/os/Build$VERSION:SDK_INT	I
    //   117: bipush 9
    //   119: if_icmplt +220 -> 339
    //   122: invokestatic 249	android/hardware/Camera:getNumberOfCameras	()I
    //   125: ifle +76 -> 201
    //   128: iload_1
    //   129: invokestatic 403	apje:b	(I)I
    //   132: istore 4
    //   134: aload_0
    //   135: iload 4
    //   137: iconst_1
    //   138: invokestatic 408	bkxv:a	(II)Landroid/hardware/Camera;
    //   141: putfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   144: aload_0
    //   145: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   148: ifnonnull +525 -> 673
    //   151: iload 4
    //   153: iconst_1
    //   154: if_icmpeq +519 -> 673
    //   157: aload_0
    //   158: iconst_1
    //   159: iconst_1
    //   160: invokestatic 408	bkxv:a	(II)Landroid/hardware/Camera;
    //   163: putfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   166: iconst_1
    //   167: istore 4
    //   169: aload_0
    //   170: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   173: ifnull +28 -> 201
    //   176: new 251	android/hardware/Camera$CameraInfo
    //   179: dup
    //   180: invokespecial 252	android/hardware/Camera$CameraInfo:<init>	()V
    //   183: astore 6
    //   185: iload 4
    //   187: aload 6
    //   189: invokestatic 256	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   192: aload_0
    //   193: aload 6
    //   195: getfield 411	android/hardware/Camera$CameraInfo:orientation	I
    //   198: putfield 413	apje:m	I
    //   201: aload_0
    //   202: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   205: ifnonnull +154 -> 359
    //   208: ldc 173
    //   210: iconst_1
    //   211: ldc_w 415
    //   214: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: getstatic 46	apje:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   220: astore 6
    //   222: aload 6
    //   224: monitorenter
    //   225: bipush 253
    //   227: putstatic 48	apje:jdField_c_of_type_Int	I
    //   230: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   233: invokevirtual 370	java/lang/Thread:getId	()J
    //   236: putstatic 52	apje:jdField_a_of_type_Long	J
    //   239: aload 6
    //   241: monitorexit
    //   242: bipush 253
    //   244: ireturn
    //   245: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   248: pop
    //   249: ldc2_w 416
    //   252: invokestatic 396	java/lang/Thread:sleep	(J)V
    //   255: goto -141 -> 114
    //   258: astore 6
    //   260: ldc 173
    //   262: iconst_1
    //   263: ldc_w 419
    //   266: aload 6
    //   268: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: getstatic 46	apje:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   274: astore 6
    //   276: aload 6
    //   278: monitorenter
    //   279: bipush 253
    //   281: putstatic 48	apje:jdField_c_of_type_Int	I
    //   284: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   287: invokevirtual 370	java/lang/Thread:getId	()J
    //   290: putstatic 52	apje:jdField_a_of_type_Long	J
    //   293: aload 6
    //   295: monitorexit
    //   296: bipush 253
    //   298: ireturn
    //   299: astore 6
    //   301: ldc 173
    //   303: iconst_1
    //   304: new 261	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 421
    //   314: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload 4
    //   319: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc_w 426
    //   325: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: aload 6
    //   333: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   336: goto -192 -> 144
    //   339: aload_0
    //   340: iconst_m1
    //   341: iconst_1
    //   342: invokestatic 408	bkxv:a	(II)Landroid/hardware/Camera;
    //   345: putfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   348: goto -147 -> 201
    //   351: astore 7
    //   353: aload 6
    //   355: monitorexit
    //   356: aload 7
    //   358: athrow
    //   359: aload_0
    //   360: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   363: sipush 1280
    //   366: sipush 720
    //   369: invokestatic 431	aphn:a	()Laphn;
    //   372: getfield 432	aphn:jdField_a_of_type_Int	I
    //   375: invokestatic 435	hg:a	(Landroid/hardware/Camera;III)V
    //   378: bipush 90
    //   380: istore 5
    //   382: iload 5
    //   384: istore 4
    //   386: getstatic 437	bdaw:g	Ljava/lang/String;
    //   389: invokestatic 298	bdaw:d	(Ljava/lang/String;)Z
    //   392: ifeq +16 -> 408
    //   395: iload 5
    //   397: istore 4
    //   399: iload_1
    //   400: ifne +8 -> 408
    //   403: sipush 270
    //   406: istore 4
    //   408: iload 4
    //   410: istore 5
    //   412: iload_1
    //   413: iconst_1
    //   414: if_icmpne +28 -> 442
    //   417: getstatic 439	bdaw:e	Ljava/lang/String;
    //   420: invokestatic 298	bdaw:d	(Ljava/lang/String;)Z
    //   423: ifne +253 -> 676
    //   426: iload 4
    //   428: istore 5
    //   430: getstatic 441	bdaw:f	Ljava/lang/String;
    //   433: invokestatic 443	bdaw:b	(Ljava/lang/String;)Z
    //   436: ifeq +6 -> 442
    //   439: goto +237 -> 676
    //   442: aload_0
    //   443: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   446: iload 5
    //   448: invokevirtual 446	android/hardware/Camera:setDisplayOrientation	(I)V
    //   451: aload_0
    //   452: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   455: invokevirtual 155	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   458: astore 6
    //   460: aload_0
    //   461: aload 6
    //   463: invokevirtual 449	android/hardware/Camera$Parameters:getPreviewFormat	()I
    //   466: putfield 451	apje:f	I
    //   469: new 453	android/graphics/PixelFormat
    //   472: dup
    //   473: invokespecial 454	android/graphics/PixelFormat:<init>	()V
    //   476: astore 7
    //   478: aload_0
    //   479: getfield 451	apje:f	I
    //   482: aload 7
    //   484: invokestatic 458	android/graphics/PixelFormat:getPixelFormatInfo	(ILandroid/graphics/PixelFormat;)V
    //   487: aload 6
    //   489: invokevirtual 462	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   492: astore 8
    //   494: aload_0
    //   495: aload 8
    //   497: getfield 467	android/hardware/Camera$Size:width	I
    //   500: putfield 360	apje:jdField_d_of_type_Int	I
    //   503: aload_0
    //   504: aload 8
    //   506: getfield 470	android/hardware/Camera$Size:height	I
    //   509: putfield 472	apje:e	I
    //   512: aload_0
    //   513: iconst_0
    //   514: putfield 149	apje:jdField_a_of_type_Boolean	Z
    //   517: aload_0
    //   518: aload 6
    //   520: invokevirtual 321	android/hardware/Camera$Parameters:getZoom	()I
    //   523: putfield 323	apje:i	I
    //   526: aload_0
    //   527: aload 6
    //   529: invokevirtual 475	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   532: iconst_3
    //   533: idiv
    //   534: iconst_2
    //   535: imul
    //   536: putfield 342	apje:j	I
    //   539: ldc 173
    //   541: iconst_1
    //   542: ldc_w 477
    //   545: iconst_3
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_0
    //   552: getfield 323	apje:i	I
    //   555: invokestatic 482	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   558: aastore
    //   559: dup
    //   560: iconst_1
    //   561: aload_0
    //   562: getfield 342	apje:j	I
    //   565: invokestatic 482	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   568: aastore
    //   569: dup
    //   570: iconst_2
    //   571: aload 6
    //   573: invokevirtual 475	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   576: invokestatic 482	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   579: aastore
    //   580: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   583: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: aload_0
    //   587: getfield 360	apje:jdField_d_of_type_Int	I
    //   590: aload_0
    //   591: getfield 472	apje:e	I
    //   594: imul
    //   595: aload 7
    //   597: getfield 485	android/graphics/PixelFormat:bitsPerPixel	I
    //   600: imul
    //   601: bipush 8
    //   603: idiv
    //   604: istore 4
    //   606: iconst_0
    //   607: istore_1
    //   608: iload_1
    //   609: iconst_3
    //   610: if_icmpge +29 -> 639
    //   613: aload_0
    //   614: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   617: iload 4
    //   619: newarray byte
    //   621: invokevirtual 489	android/hardware/Camera:addCallbackBuffer	([B)V
    //   624: iload_1
    //   625: iconst_1
    //   626: iadd
    //   627: istore_1
    //   628: goto -20 -> 608
    //   631: astore 7
    //   633: aload 6
    //   635: monitorexit
    //   636: aload 7
    //   638: athrow
    //   639: getstatic 46	apje:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   642: astore 6
    //   644: aload 6
    //   646: monitorenter
    //   647: iconst_0
    //   648: putstatic 48	apje:jdField_c_of_type_Int	I
    //   651: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   654: invokevirtual 370	java/lang/Thread:getId	()J
    //   657: putstatic 52	apje:jdField_a_of_type_Long	J
    //   660: aload 6
    //   662: monitorexit
    //   663: iconst_0
    //   664: ireturn
    //   665: astore 7
    //   667: aload 6
    //   669: monitorexit
    //   670: aload 7
    //   672: athrow
    //   673: goto -504 -> 169
    //   676: sipush 270
    //   679: istore 5
    //   681: goto -239 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	apje
    //   0	684	1	paramInt	int
    //   0	684	2	paramLong	long
    //   132	486	4	i1	int
    //   380	300	5	i2	int
    //   258	9	6	localException1	Exception
    //   299	55	6	localException2	Exception
    //   62	6	7	localObject4	Object
    //   351	6	7	localObject5	Object
    //   476	120	7	localPixelFormat	android.graphics.PixelFormat
    //   631	6	7	localObject6	Object
    //   665	6	7	localObject7	Object
    //   492	13	8	localSize	android.hardware.Camera.Size
    // Exception table:
    //   from	to	target	type
    //   44	60	62	finally
    //   64	67	62	finally
    //   70	94	258	java/lang/Exception
    //   106	114	258	java/lang/Exception
    //   114	134	258	java/lang/Exception
    //   144	151	258	java/lang/Exception
    //   157	166	258	java/lang/Exception
    //   169	201	258	java/lang/Exception
    //   201	225	258	java/lang/Exception
    //   245	255	258	java/lang/Exception
    //   301	336	258	java/lang/Exception
    //   339	348	258	java/lang/Exception
    //   356	359	258	java/lang/Exception
    //   359	378	258	java/lang/Exception
    //   386	395	258	java/lang/Exception
    //   417	426	258	java/lang/Exception
    //   430	439	258	java/lang/Exception
    //   442	606	258	java/lang/Exception
    //   613	624	258	java/lang/Exception
    //   134	144	299	java/lang/Exception
    //   225	242	351	finally
    //   353	356	351	finally
    //   279	296	631	finally
    //   633	636	631	finally
    //   647	663	665	finally
    //   667	670	665	finally
  }
  
  public void a()
  {
    QLog.i("AREngine_ARCamera", 1, String.format("stopPreview mCamera=%s", new Object[] { this.jdField_a_of_type_AndroidHardwareCamera }));
    c();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {}
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(null);
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.jdField_a_of_type_Apjh = null;
      if (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
        this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("AREngine_ARCamera", 1, "stopCamera fail.", localException);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("autoFocus surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      if ((this.g != paramInt1) || (this.h != paramInt2))
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(1.0F, 1.0F);
        localMatrix.postRotate(90.0F);
        localMatrix.postScale(paramInt1 / 2000.0F, paramInt2 / 2000.0F);
        localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
        localMatrix.invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.g = paramInt1;
        this.h = paramInt2;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 500L);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i("AREngine_ARCamera", 1, String.format("manualFocus touchX=%s touchY=%s surfaceWidth=%s surfaceHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      apoo.a().a(new ARCamera.1(this, paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: ldc 173
    //   2: iconst_1
    //   3: ldc_w 554
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   16: aastore
    //   17: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   27: ifnull +124 -> 151
    //   30: aload_0
    //   31: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   34: invokevirtual 557	android/hardware/Camera:release	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   42: getstatic 46	apje:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore_1
    //   46: aload_1
    //   47: monitorenter
    //   48: bipush 253
    //   50: putstatic 48	apje:jdField_c_of_type_Int	I
    //   53: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   56: invokevirtual 370	java/lang/Thread:getId	()J
    //   59: putstatic 52	apje:jdField_a_of_type_Long	J
    //   62: aload_1
    //   63: monitorexit
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_2
    //   67: aload_1
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: astore_1
    //   72: ldc 173
    //   74: iconst_1
    //   75: ldc_w 559
    //   78: aload_1
    //   79: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   87: getstatic 46	apje:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   90: astore_1
    //   91: aload_1
    //   92: monitorenter
    //   93: bipush 253
    //   95: putstatic 48	apje:jdField_c_of_type_Int	I
    //   98: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   101: invokevirtual 370	java/lang/Thread:getId	()J
    //   104: putstatic 52	apje:jdField_a_of_type_Long	J
    //   107: aload_1
    //   108: monitorexit
    //   109: iconst_1
    //   110: ireturn
    //   111: astore_2
    //   112: aload_1
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    //   116: astore_2
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   122: getstatic 46	apje:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   125: astore_1
    //   126: aload_1
    //   127: monitorenter
    //   128: bipush 253
    //   130: putstatic 48	apje:jdField_c_of_type_Int	I
    //   133: invokestatic 366	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   136: invokevirtual 370	java/lang/Thread:getId	()J
    //   139: putstatic 52	apje:jdField_a_of_type_Long	J
    //   142: aload_1
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: astore_2
    //   147: aload_1
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    //   151: iconst_1
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	apje
    //   45	23	1	localObject1	Object
    //   71	8	1	localException	Exception
    //   90	58	1	localObject2	Object
    //   66	4	2	localObject3	Object
    //   111	4	2	localObject4	Object
    //   116	29	2	localObject5	Object
    //   146	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   48	64	66	finally
    //   67	69	66	finally
    //   30	37	71	java/lang/Exception
    //   93	109	111	finally
    //   112	114	111	finally
    //   30	37	116	finally
    //   72	82	116	finally
    //   128	144	146	finally
    //   147	149	146	finally
  }
  
  public boolean a(float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("directZoom scale=%.2f autoRevert=%s mZooming=%s", new Object[] { Float.valueOf(paramFloat), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
    }
    if ((this.jdField_a_of_type_AndroidHardwareCamera != null) && (!this.jdField_b_of_type_Boolean)) {}
    try
    {
      localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      localList = localParameters.getZoomRatios();
      if ((localList == null) || (localList.size() == 0)) {
        break label487;
      }
      i7 = localParameters.getZoom();
      if (i7 < 0) {
        return false;
      }
      if (localList.size() <= i7) {
        break label506;
      }
      i6 = ((Integer)localList.get(i7)).intValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Camera.Parameters localParameters;
        List localList;
        int i7;
        int i6;
        int i8;
        continue;
        int i4 = i1;
        break label532;
        break label532;
        return false;
        for (;;)
        {
          i8 = (int)(i6 * paramFloat);
          if (i8 > i6) {
            break;
          }
          return false;
          i6 = -1;
        }
        int i5 = 2147483647;
        i4 = -1;
        int i3 = -1;
        int i2 = 0;
        int i1 = i7;
        continue;
        i1 += 1;
      }
    }
    if (i1 < localList.size())
    {
      if ((Math.abs(((Integer)localList.get(i1)).intValue() - i8) >= i5) || (((Integer)localList.get(i1)).intValue() >= i8)) {
        break label484;
      }
      i5 = Math.abs(((Integer)localList.get(i1)).intValue() - i8);
      i3 = ((Integer)localList.get(i1)).intValue();
      if (i1 + 1 < localList.size())
      {
        i2 = ((Integer)localList.get(i1 + 1)).intValue();
        i4 = i1;
        break label532;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("AREngine_ARCamera", 2, String.format("directZoom [curZoomRatio,dstZoomRatio,index,cur,finalRatio,nextRatio]=[%d,%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(i6), Integer.valueOf(i8), Integer.valueOf(i4), Integer.valueOf(i7), Integer.valueOf(i3), Integer.valueOf(i2) }));
      }
      if ((localParameters.isZoomSupported()) && (i4 >= 0) && (i4 != i7))
      {
        i1 = Math.max(Math.min(i4, this.j), this.i);
        if (i1 != i7)
        {
          localParameters.setZoom(i1);
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
          return true;
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
          if (paramBoolean) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 5000L);
          }
        }
      }
      return false;
    }
  }
  
  /* Error */
  public boolean a(android.hardware.Camera.PreviewCallback paramPreviewCallback, android.graphics.SurfaceTexture paramSurfaceTexture, apjh paramapjh)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 173
    //   8: iconst_1
    //   9: ldc_w 591
    //   12: iconst_3
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_2
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: aload_0
    //   27: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   30: aastore
    //   31: invokestatic 181	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   41: ifnull +76 -> 117
    //   44: aload_0
    //   45: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   48: aload_1
    //   49: invokevirtual 501	android/hardware/Camera:setPreviewCallbackWithBuffer	(Landroid/hardware/Camera$PreviewCallback;)V
    //   52: aload_0
    //   53: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   56: aload_2
    //   57: invokevirtual 595	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   60: aload_0
    //   61: getfield 144	apje:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   64: invokevirtual 598	android/hardware/Camera:startPreview	()V
    //   67: aload_0
    //   68: aload_3
    //   69: putfield 506	apje:jdField_a_of_type_Apjh	Lapjh;
    //   72: aload_0
    //   73: getfield 96	apje:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   76: ifnull +24 -> 100
    //   79: aload_0
    //   80: getfield 96	apje:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   83: aload_0
    //   84: getfield 65	apje:jdField_a_of_type_AndroidHardwareSensorEventListener	Landroid/hardware/SensorEventListener;
    //   87: aload_0
    //   88: getfield 96	apje:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   91: iconst_1
    //   92: invokevirtual 602	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   95: iconst_3
    //   96: invokevirtual 606	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   99: pop
    //   100: iconst_1
    //   101: ireturn
    //   102: astore_1
    //   103: iload 5
    //   105: istore 4
    //   107: ldc 173
    //   109: iconst_1
    //   110: ldc_w 608
    //   113: aload_1
    //   114: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   117: iload 4
    //   119: ireturn
    //   120: astore_1
    //   121: iconst_1
    //   122: istore 4
    //   124: goto -17 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	apje
    //   0	127	1	paramPreviewCallback	android.hardware.Camera.PreviewCallback
    //   0	127	2	paramSurfaceTexture	android.graphics.SurfaceTexture
    //   0	127	3	paramapjh	apjh
    //   1	122	4	bool1	boolean
    //   4	100	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   44	72	102	java/lang/Exception
    //   72	100	120	java/lang/Exception
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      try
      {
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCamera", 2, String.format("switchFlashLight on=%s current=%s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getFlashMode() }));
        }
        if (paramBoolean) {
          localParameters.setFlashMode("torch");
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
          return true;
          localParameters.setFlashMode("off");
        }
        return false;
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "switchFlashLight fail.", localException);
      }
    }
  }
  
  public int b()
  {
    return this.e;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 100L);
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    }
  }
  
  public int d()
  {
    return (this.m - this.n + 360) % 360;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCamera", 2, String.format("autoZoom mZooming=%s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      try
      {
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        }
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        if (localParameters.isZoomSupported())
        {
          int i1 = localParameters.getZoom();
          if (i1 == this.i) {
            b(i1, this.j);
          }
          for (;;)
          {
            apho.a().b();
            return;
            b(i1, this.i);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AREngine_ARCamera", 1, "autoZoom fail!", localException);
      }
    }
  }
  
  public int e()
  {
    return a(0, 0L);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 20L);
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    QLog.d("AREngine_ARCamera", 1, String.format("onAutoFocus success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      paramCamera = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      hg.a(paramCamera);
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramCamera);
      if (this.jdField_a_of_type_Apjh != null) {
        this.jdField_a_of_type_Apjh.a(paramBoolean);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception paramCamera)
    {
      for (;;)
      {
        QLog.i("AREngine_ARCamera", 1, "focusOnArea fail.", paramCamera);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apje
 * JD-Core Version:    0.7.0.1
 */