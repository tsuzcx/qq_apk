import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OcrCamera.4;
import com.tencent.mobileqq.ocr.OcrCamera.5;
import com.tencent.mobileqq.ocr.OcrCamera.8;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aygn
  implements Handler.Callback
{
  public int a;
  private long jdField_a_of_type_Long;
  public RectF a;
  Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = new aygq(this);
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  aozk jdField_a_of_type_Aozk;
  aqan jdField_a_of_type_Aqan;
  public aygs a;
  bkgm jdField_a_of_type_Bkgm;
  public volatile boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  public int b;
  private long jdField_b_of_type_Long;
  public volatile boolean b;
  byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private volatile boolean e;
  int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = true;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public aygn(Context paramContext, aygs paramaygs, SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Aygs = paramaygs;
    this.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
    this.jdField_a_of_type_Bkgm = new bkgm(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Aqan = aqan.a();
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new aygo(this, paramContext);
    paramContext = ayhn.a();
    if (paramContext != null)
    {
      this.jdField_c_of_type_Int = paramContext.i;
      int m = paramContext.jdField_d_of_type_Int;
      this.jdField_d_of_type_Int = (paramContext.jdField_e_of_type_Int * m);
      if (this.jdField_d_of_type_Int >= 76800) {}
    }
    for (this.jdField_d_of_type_Int = 921600;; this.jdField_d_of_type_Int = 921600)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.camera", 2, "OcrCamera mFrameGap:" + this.jdField_c_of_type_Int + ",mMaxPreviewPixels:" + this.jdField_d_of_type_Int);
      }
      return;
      this.jdField_c_of_type_Int = 100;
    }
  }
  
  private int a()
  {
    int n = 0;
    for (;;)
    {
      try
      {
        if (ljj.b(BaseApplicationImpl.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "openCamera take up!");
          }
          m = -1001;
          return m;
        }
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera = bkfp.a();
          if (this.jdField_a_of_type_AndroidHardwareCamera == null)
          {
            if (!QLog.isColorLevel()) {
              break label610;
            }
            QLog.d("Q.ocr.camera", 2, "openCamera failed!");
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          continue;
        }
        this.jdField_a_of_type_Int = bcie.b();
      }
      finally {}
      hi.a(this.jdField_a_of_type_AndroidHardwareCamera, 0, 0);
      int m = 90;
      if (bcif.d(bcif.g)) {
        m = 270;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(m);
      Object localObject2 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      PixelFormat localPixelFormat = new PixelFormat();
      m = ((Camera.Parameters)localObject2).getPreviewFormat();
      PixelFormat.getPixelFormatInfo(m, localPixelFormat);
      Object localObject3 = a(this.jdField_a_of_type_AndroidHardwareCamera, bclx.jdField_a_of_type_Int, bclx.jdField_b_of_type_Int, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.camera", 2, "openCamera bestPreviewSize:" + ((Point)localObject3).x + "," + ((Point)localObject3).y);
      }
      try
      {
        ((Camera.Parameters)localObject2).setPreviewSize(((Point)localObject3).x, ((Point)localObject3).y);
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters((Camera.Parameters)localObject2);
        int i1 = this.jdField_e_of_type_Int;
        if (i1 != 1) {}
      }
      catch (Exception localException3)
      {
        try
        {
          Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
          localParameters.setPictureFormat(256);
          localParameters.setJpegQuality(100);
          Point localPoint = a(this.jdField_a_of_type_AndroidHardwareCamera, bclx.jdField_a_of_type_Int, bclx.jdField_b_of_type_Int, true);
          if ((localPoint.x >= ((Point)localObject3).x) && (localPoint.y >= ((Point)localObject3).y))
          {
            localParameters.setPictureSize(localPoint.x, localPoint.y);
            this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
            localObject3 = localParameters.getPictureSize();
            this.i = ((Camera.Size)localObject3).width;
            this.j = ((Camera.Size)localObject3).height;
            this.jdField_f_of_type_Boolean = true;
          }
          localObject2 = ((Camera.Parameters)localObject2).getPreviewSize();
          this.g = ((Camera.Size)localObject2).width;
          this.h = ((Camera.Size)localObject2).height;
          this.k = m;
          this.l = localPixelFormat.bitsPerPixel;
          if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.camera", 2, "openCamera picWidth:" + this.g + ",picHeight:" + this.h + ",picFormat:" + this.k + "  mTakePicWidth:" + this.i + "   mTakePicHeight:" + this.j);
          }
          if (!b())
          {
            m = -1003;
            continue;
            localException3 = localException3;
            localException3.printStackTrace();
            QLog.d("Q.ocr.camera", 1, "openInternal setCamera Params1 exp " + localException3.getMessage());
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            QLog.d("Q.ocr.camera", 1, "openInternal setCamera Params2 exp " + localException2.getMessage());
            this.jdField_f_of_type_Boolean = false;
          }
          this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
          m = n;
        }
      }
      continue;
      label610:
      m = -1002;
    }
  }
  
  private Point a(Camera paramCamera, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = paramCamera.getParameters();
    Camera.Size localSize1 = ((Camera.Parameters)localObject).getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
    {
      localObject = new Point(localSize1.width, localSize1.height);
      return localObject;
    }
    paramCamera = ((Camera.Parameters)localObject).getSupportedPreviewSizes();
    if (paramBoolean) {
      paramCamera = ((Camera.Parameters)localObject).getSupportedPictureSizes();
    }
    if (paramCamera == null) {
      return new Point(localSize1.width, localSize1.height);
    }
    localObject = new ArrayList(paramCamera);
    Collections.sort((List)localObject, new aygp(this));
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    int m = this.jdField_d_of_type_Int;
    if (paramBoolean) {
      m = 3686400;
    }
    for (;;)
    {
      localObject = ((List)localObject).iterator();
      label160:
      while (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)((Iterator)localObject).next();
        int n = localSize2.width;
        int i1 = localSize2.height;
        int i2 = n * i1;
        if ((i2 >= 76800) && (i2 <= m) && ((n != 980) || (i1 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((n == 1184) && (i1 == 666)) || ((n != 704) || (i1 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
        {
          if (paramInt1 > paramInt2)
          {
            i2 = 1;
            if (n >= i1) {
              break label388;
            }
            i3 = 1;
            label343:
            if (i2 != i3) {
              break label394;
            }
            i2 = n;
          }
          for (int i3 = i1;; i3 = n)
          {
            if ((i3 != paramInt1) || (i2 != paramInt2)) {
              break label405;
            }
            return new Point(n, i1);
            i2 = 0;
            break;
            i3 = 0;
            break label343;
            i2 = i1;
          }
          if ((i3 >= paramInt1 >> 1) && (i3 >> 1 <= paramInt1) && (i2 >= paramInt2 >> 1) && (i2 >> 1 <= paramInt2))
          {
            float f2 = Math.abs(i3 / i2 - f3);
            if (f2 > f1) {
              break label504;
            }
            paramCamera = new Point(n, i1);
            f1 = f2;
          }
        }
      }
      label388:
      label394:
      label405:
      label504:
      for (;;)
      {
        break label160;
        localObject = paramCamera;
        if (paramCamera != null) {
          break;
        }
        return new Point(localSize1.width, localSize1.height);
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          if (QLog.isDebugVersion()) {
            ThreadManager.getUIHandler().post(new OcrCamera.4(this));
          }
          bcst.b(null, "dc00898", "", "", "0X80082C1", "0X80082C1", 0, 0, "", "", "", "");
          this.jdField_b_of_type_Long = System.currentTimeMillis();
        }
        if (this.jdField_a_of_type_Aozk == null) {
          this.jdField_a_of_type_Aozk = new aozk(aozk.jdField_a_of_type_Int);
        }
        int m = this.jdField_f_of_type_Int;
        if (m < 5) {
          continue;
        }
      }
      finally
      {
        try
        {
          bool = this.jdField_a_of_type_Aozk.a(paramArrayOfByte, this.g, this.h);
        }
        catch (Throwable paramArrayOfByte)
        {
          long l1;
          boolean bool = false;
        }
        try
        {
          this.jdField_f_of_type_Int = 0;
          if (!bool) {
            continue;
          }
          l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
          QLog.d("Q.ocr.camera", 4, "select image isBest:" + bool + ",costTime:" + l1);
          bcst.b(null, "dc00898", "", "", "0X80082C3", "0X80082C3", 0, 0, "", "", "", "");
          bcst.b(null, "dc00898", "", "", "0X80082C5", "0X80082C5", 0, 0, String.valueOf(l1), "", "", "");
          ThreadManager.post(new OcrCamera.5(this, l1), 5, null, false);
          if (bgnt.d(BaseApplicationImpl.getContext())) {
            break label352;
          }
          QLog.d("Q.ocr.camera", 1, "selectImage best but error!");
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698136, 0).a();
        }
        catch (Throwable paramArrayOfByte)
        {
          break label310;
        }
        paramArrayOfByte = finally;
      }
      return;
      label310:
      this.jdField_f_of_type_Int += 1;
      QLog.d("Q.ocr.camera", 4, "selectImage error " + paramArrayOfByte.getMessage());
      continue;
      label352:
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      paramArrayOfByte = this.jdField_a_of_type_Aozk.a();
      if (paramArrayOfByte == null)
      {
        this.jdField_a_of_type_Boolean = true;
        QLog.d("Q.ocr.camera", 1, "postUploadTask imageData == null");
      }
      else
      {
        if (this.jdField_a_of_type_Aygs != null) {
          this.jdField_a_of_type_Aygs.a();
        }
        paramArrayOfByte = aygw.a(paramArrayOfByte, this.g, this.h, this.k, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Aygs != null) {
          this.jdField_a_of_type_Aygs.a(paramArrayOfByte);
        }
      }
    }
  }
  
  private boolean a(Camera paramCamera, int paramInt)
  {
    if ((paramCamera == null) || (paramInt <= 0))
    {
      QLog.d("Q.ocr.camera", 1, "addCallbackBuffer camera == null || bufSize <= 0");
      return false;
    }
    int m = 0;
    int n = 0;
    if (m < 5) {}
    for (;;)
    {
      try
      {
        paramCamera.addCallbackBuffer(new byte[paramInt]);
        n += 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("Q.ocr.camera", 1, "addCallbackBuffer failed. exp msg:" + localException.getMessage());
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (n <= 1) {
          break label148;
        }
      }
      m += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.camera", 2, "addCallbackBuffer count:" + n + ",bufSize:" + paramInt);
      }
      if (n <= 1) {
        break label180;
      }
      return true;
      label148:
      URLDrawable.clearMemoryCache();
      QLog.d("Q.ocr.camera", 1, "addCallbackBuffer failed. oom i:" + m);
    }
    label180:
    return false;
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 152	aygn:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   13: ifnull +191 -> 204
    //   16: aload_0
    //   17: getfield 57	aygn:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +180 -> 204
    //   27: aload_0
    //   28: getfield 53	aygn:jdField_a_of_type_AndroidHardwareCamera$PreviewCallback	Landroid/hardware/Camera$PreviewCallback;
    //   31: ifnull +52 -> 83
    //   34: aload_0
    //   35: getfield 255	aygn:g	I
    //   38: aload_0
    //   39: getfield 257	aygn:h	I
    //   42: imul
    //   43: aload_0
    //   44: getfield 264	aygn:l	I
    //   47: imul
    //   48: bipush 8
    //   50: idiv
    //   51: istore_1
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 152	aygn:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   57: iload_1
    //   58: invokespecial 503	aygn:a	(Landroid/hardware/Camera;I)Z
    //   61: istore 4
    //   63: iload 4
    //   65: ifne +7 -> 72
    //   68: aload_0
    //   69: monitorexit
    //   70: iload_3
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 152	aygn:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   76: aload_0
    //   77: getfield 53	aygn:jdField_a_of_type_AndroidHardwareCamera$PreviewCallback	Landroid/hardware/Camera$PreviewCallback;
    //   80: invokevirtual 507	android/hardware/Camera:setPreviewCallbackWithBuffer	(Landroid/hardware/Camera$PreviewCallback;)V
    //   83: aload_0
    //   84: getfield 152	aygn:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   87: aload_0
    //   88: getfield 57	aygn:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   91: invokevirtual 511	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   94: aload_0
    //   95: getfield 152	aygn:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   98: invokevirtual 514	android/hardware/Camera:startPreview	()V
    //   101: aload_0
    //   102: invokevirtual 516	aygn:f	()V
    //   105: iconst_1
    //   106: istore_2
    //   107: iload_2
    //   108: ifeq +8 -> 116
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 518	aygn:jdField_d_of_type_Boolean	Z
    //   116: iload_2
    //   117: istore_3
    //   118: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq -53 -> 68
    //   124: ldc 107
    //   126: iconst_2
    //   127: new 109	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 520
    //   137: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_2
    //   141: invokevirtual 419	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   144: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iload_2
    //   151: istore_3
    //   152: goto -84 -> 68
    //   155: astore 5
    //   157: aload_0
    //   158: monitorexit
    //   159: aload 5
    //   161: athrow
    //   162: astore 5
    //   164: iconst_0
    //   165: istore_2
    //   166: aload 5
    //   168: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   171: ldc 107
    //   173: iconst_1
    //   174: new 109	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 522
    //   184: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 281	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: goto -94 -> 107
    //   204: ldc 107
    //   206: iconst_1
    //   207: ldc_w 524
    //   210: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: iload 4
    //   215: istore_2
    //   216: goto -109 -> 107
    //   219: astore 5
    //   221: goto -55 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	aygn
    //   51	7	1	m	int
    //   1	215	2	bool1	boolean
    //   6	146	3	bool2	boolean
    //   3	211	4	bool3	boolean
    //   20	3	5	localSurfaceHolder	SurfaceHolder
    //   155	5	5	localObject	Object
    //   162	26	5	localException1	Exception
    //   219	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	22	155	finally
    //   27	63	155	finally
    //   72	83	155	finally
    //   83	101	155	finally
    //   101	105	155	finally
    //   111	116	155	finally
    //   118	150	155	finally
    //   166	201	155	finally
    //   204	213	155	finally
    //   27	63	162	java/lang/Exception
    //   72	83	162	java/lang/Exception
    //   83	101	162	java/lang/Exception
    //   101	105	219	java/lang/Exception
  }
  
  private boolean c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
        if (localCamera != null)
        {
          try
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(null);
            this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
            QLog.d("Q.ocr.camera", 1, "stopPreview failed. error msg: " + localException1.getMessage());
          }
          catch (Exception localException1)
          {
            try
            {
              this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
              g();
              if (bool1) {
                this.jdField_d_of_type_Boolean = true;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.camera", 2, "stopPreviewInternal isSuc:" + bool1);
              }
              return bool1;
            }
            catch (Exception localException2)
            {
              bool1 = bool2;
              continue;
            }
            localException1 = localException1;
            bool1 = false;
          }
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 152	aygn:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +59 -> 69
    //   13: aload_0
    //   14: getfield 152	aygn:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   17: invokevirtual 539	android/hardware/Camera:release	()V
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 541	aygn:jdField_b_of_type_ArrayOfByte	[B
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: astore_2
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 152	aygn:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 57	aygn:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   40: ldc 107
    //   42: iconst_1
    //   43: new 109	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 543
    //   53: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: invokevirtual 281	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   60: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iconst_0
    //   70: istore_1
    //   71: goto -51 -> 20
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	aygn
    //   1	70	1	bool	boolean
    //   8	2	2	localCamera	Camera
    //   29	28	2	localException	Exception
    //   74	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	29	java/lang/Exception
    //   4	9	74	finally
    //   13	20	74	finally
    //   20	25	74	finally
    //   30	69	74	finally
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      if (this.jdField_d_of_type_Boolean)
      {
        e();
        b();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Bkgm.removeMessages(0);
      Message localMessage = this.jdField_a_of_type_Bkgm.obtainMessage(0);
      this.jdField_a_of_type_Bkgm.sendMessage(localMessage);
    } while (!QLog.isColorLevel());
    QLog.d("Q.ocr.camera", 2, "open isStop:" + this.jdField_d_of_type_Boolean + ",isOpen:" + this.jdField_c_of_type_Boolean);
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_d_of_type_Int = 2073600;
      if (QLog.isColorLevel()) {
        QLog.i("Q.ocr.camera", 1, "setOcrMode device model: " + bgln.i());
      }
    }
  }
  
  public void a(RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
  }
  
  public boolean a()
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("takePicture, isOpen:").append(this.jdField_c_of_type_Boolean).append(",mNeedSelectImage:").append(this.jdField_a_of_type_Boolean).append(",isStop:").append(this.jdField_d_of_type_Boolean).append(",picData:");
      if (this.jdField_a_of_type_ArrayOfByte == null)
      {
        bool = true;
        QLog.d("Q.ocr.camera", 2, bool);
      }
    }
    else
    {
      if (bgnt.d(BaseApplicationImpl.getContext())) {
        break label122;
      }
      QLog.d("Q.ocr.camera", 1, "takePicture but net error!");
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698136, 0).a();
    }
    label122:
    while ((!this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || ((!this.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Int != 1)) || (this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_AndroidHardwareCamera == null))
    {
      return false;
      bool = false;
      break;
    }
    this.jdField_e_of_type_Boolean = true;
    if ((this.jdField_e_of_type_Int == 1) && (this.jdField_f_of_type_Boolean) && (this.i * this.j >= this.g * this.h)) {
      this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, null, new aygr(this));
    }
    for (;;)
    {
      return true;
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != this.jdField_a_of_type_ArrayOfByte.length)) {}
      try
      {
        this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_ArrayOfByte.length];
        if (this.jdField_b_of_type_ArrayOfByte != null)
        {
          System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
          localObject = this.jdField_b_of_type_ArrayOfByte;
          a((byte[])localObject, false);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("Q.ocr.camera", 1, new Object[] { "takePicture error: ", localThrowable.getMessage() });
          this.jdField_b_of_type_ArrayOfByte = null;
          continue;
          byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        }
      }
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (this.jdField_a_of_type_Bkgm == null) || (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      return false;
    }
    this.jdField_a_of_type_Bkgm.post(new OcrCamera.8(this, paramBoolean, paramArrayOfByte));
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bkgm.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_Bkgm.obtainMessage(1);
    this.jdField_a_of_type_Bkgm.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "startPreview");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bkgm.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_Bkgm.obtainMessage(2);
    this.jdField_a_of_type_Bkgm.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "stopPreview");
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bkgm.removeCallbacksAndMessages(null);
    Message localMessage = this.jdField_a_of_type_Bkgm.obtainMessage(3);
    this.jdField_a_of_type_Bkgm.sendMessage(localMessage);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.camera", 2, "close");
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return false;
              if (!this.jdField_c_of_type_Boolean) {
                try
                {
                  m = a();
                  if (m == 0) {
                    this.jdField_c_of_type_Boolean = true;
                  }
                  if (this.jdField_a_of_type_Aygs != null)
                  {
                    this.jdField_a_of_type_Aygs.a(m, this.g, this.h, this.k);
                    return false;
                  }
                }
                catch (Exception paramMessage)
                {
                  for (;;)
                  {
                    int m = -1004;
                    paramMessage.printStackTrace();
                  }
                }
              }
            }
            bool = b();
          } while (this.jdField_a_of_type_Aygs == null);
          this.jdField_a_of_type_Aygs.a(bool);
          return false;
          bool = c();
        } while (this.jdField_a_of_type_Aygs == null);
        this.jdField_a_of_type_Aygs.b(bool);
        return false;
      } while (!this.jdField_c_of_type_Boolean);
      bool = d();
      if (bool) {
        this.jdField_c_of_type_Boolean = false;
      }
    } while (this.jdField_a_of_type_Aygs == null);
    this.jdField_a_of_type_Aygs.c(bool);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygn
 * JD-Core Version:    0.7.0.1
 */