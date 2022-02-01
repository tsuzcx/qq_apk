package com.tencent.biz.widgets;

import abdr;
import abds;
import abdt;
import abdu;
import abdv;
import abdw;
import abek;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup;
import bgvf;
import bgvi;
import bkfp;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class ScannerView
  extends ViewGroup
  implements Camera.PreviewCallback, SurfaceHolder.Callback, Comparator<Camera.Size>
{
  private float jdField_a_of_type_Float;
  public int a;
  public long a;
  private abdt jdField_a_of_type_Abdt;
  private abdu jdField_a_of_type_Abdu;
  private abdv jdField_a_of_type_Abdv;
  private abdw jdField_a_of_type_Abdw;
  private abek jdField_a_of_type_Abek;
  public Rect a;
  Camera jdField_a_of_type_AndroidHardwareCamera;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private ScannerView.AutoFocusThread jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread;
  ScannerView.DecodeThread jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread;
  String jdField_a_of_type_JavaLangString;
  public StringBuilder a;
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  public int b;
  public long b;
  public Rect b;
  public Handler b;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private boolean e;
  public int f;
  private boolean f;
  public int g;
  private boolean g;
  public int h;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m = -1;
  private int n = -1;
  private int o = 17;
  
  public ScannerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new abdr(this);
    a(paramContext, null);
  }
  
  public ScannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler = new abdr(this);
    a(paramContext, paramAttributeSet);
  }
  
  private Point a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    paramCamera = paramCamera.getParameters();
    Camera.Size localSize1 = paramCamera.getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
    {
      localObject1 = new Point(localSize1.width, localSize1.height);
      return localObject1;
    }
    paramCamera = paramCamera.getSupportedPreviewSizes();
    if (paramCamera == null) {
      return new Point(localSize1.width, localSize1.height);
    }
    Object localObject1 = new ArrayList(paramCamera);
    Collections.sort((List)localObject1, this);
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      paramCamera = new StringBuilder("manufacturer:").append(Build.MANUFACTURER).append(" model:").append(Build.MODEL).append("\ndefault size:").append(localSize1.width).append(" x ").append(localSize1.height).append("\nsizes:");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)((Iterator)localObject2).next();
        paramCamera.append(localSize2.width).append(" x ").append(localSize2.height).append(" | ");
      }
      QLog.d("ScannerView", 4, paramCamera.toString());
    }
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    localObject1 = ((List)localObject1).iterator();
    label256:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      int i1 = ((Camera.Size)localObject2).width;
      int i2 = ((Camera.Size)localObject2).height;
      int i3 = i1 * i2;
      if ((i3 >= 76800) && (i3 <= 921600) && ((i1 != 980) || (i2 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i1 == 1184) && (i2 == 666)) || ((i1 != 704) || (i2 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        if (paramInt1 > paramInt2)
        {
          i3 = 1;
          if (i1 >= i2) {
            break label479;
          }
          i4 = 1;
          label434:
          if (i3 != i4) {
            break label485;
          }
          i3 = i1;
        }
        for (int i4 = i2;; i4 = i1)
        {
          if ((i4 != paramInt1) || (i3 != paramInt2)) {
            break label496;
          }
          return new Point(i1, i2);
          i3 = 0;
          break;
          label479:
          i4 = 0;
          break label434;
          label485:
          i3 = i2;
        }
        label496:
        if ((i4 >= paramInt1 >> 1) && (i4 >> 1 <= paramInt1) && (i3 >= paramInt2 >> 1) && (i3 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i4 / i3 - f3);
          if (f2 >= f1) {
            break label595;
          }
          paramCamera = new Point(i1, i2);
          f1 = f2;
        }
      }
    }
    label595:
    for (;;)
    {
      break label256;
      localObject1 = paramCamera;
      if (paramCamera != null) {
        break;
      }
      return new Point(localSize1.width, localSize1.height);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setKeepScreenOn(true);
    a(paramContext);
    this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(paramContext, paramAttributeSet);
    addView(this.jdField_a_of_type_AndroidViewSurfaceView);
    Object localObject = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    ((SurfaceHolder)localObject).addCallback(this);
    if (Build.VERSION.SDK_INT < 11) {
      ((SurfaceHolder)localObject).setType(3);
    }
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeBooleanValue(1, true)))
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScannerView);
      int i2 = ((TypedArray)localObject).getIndexCount();
      int i1 = 0;
      if (i1 < i2)
      {
        int i3 = ((TypedArray)localObject).getIndex(i1);
        switch (i3)
        {
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.l = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.l);
          continue;
          this.j = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.j);
          continue;
          this.k = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.k);
          continue;
          this.i = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.i);
          continue;
          this.m = ((TypedArray)localObject).getLayoutDimension(i3, this.m);
          continue;
          this.n = ((TypedArray)localObject).getLayoutDimension(i3, this.n);
          continue;
          this.o = ((TypedArray)localObject).getInt(i3, this.o);
        }
      }
      ((TypedArray)localObject).recycle();
      this.jdField_a_of_type_Abek = new abek(paramContext);
      addView(this.jdField_a_of_type_Abek);
    }
    if (paramAttributeSet != null) {
      this.jdField_a_of_type_Boolean = paramAttributeSet.getAttributeBooleanValue(0, true);
    }
  }
  
  private void a(Camera paramCamera, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localParameters = paramCamera.getParameters();
        localObject = "torch";
        if (bgvi.j) {
          continue;
        }
        localObject = bgvf.a().a(localParameters);
      }
      catch (RuntimeException paramCamera)
      {
        Camera.Parameters localParameters;
        Object localObject;
        paramBoolean = false;
        continue;
        paramCamera = Boolean.FALSE;
        continue;
        if (!paramBoolean) {
          continue;
        }
        continue;
      }
      localParameters.setFlashMode((String)localObject);
      paramCamera.setParameters(localParameters);
      if ((this.jdField_c_of_type_Boolean) && (("auto".equals(this.jdField_a_of_type_JavaLangString)) || ("macro".equals(this.jdField_a_of_type_JavaLangString))))
      {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread = new ScannerView.AutoFocusThread(this, this.jdField_a_of_type_AndroidHardwareCamera);
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread.start();
      }
      this.jdField_d_of_type_Boolean = paramBoolean;
      localObject = this.jdField_b_of_type_AndroidOsHandler;
      if (!paramBoolean) {
        continue;
      }
      paramCamera = Boolean.TRUE;
      ((Handler)localObject).obtainMessage(10, paramCamera).sendToTarget();
      return;
      localObject = "off";
    }
  }
  
  @TargetApi(9)
  private boolean a()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    label330:
    label337:
    label342:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScannerView", 2, "camera already opened");
          }
          return true;
        }
        if (Build.VERSION.SDK_INT >= 9)
        {
          i2 = Camera.getNumberOfCameras();
          if (i2 <= 0) {
            break label337;
          }
          Object localObject1 = new Camera.CameraInfo();
          i1 = 0;
          if (i1 < i2)
          {
            Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject1);
            if (((Camera.CameraInfo)localObject1).facing != 0) {}
          }
          else
          {
            if (i1 < i2) {
              break label330;
            }
            Camera.getCameraInfo(0, (Camera.CameraInfo)localObject1);
            i2 = 0;
            i1 = 1;
            this.jdField_a_of_type_AndroidHardwareCamera = bkfp.a(i2);
            i3 = ((Camera.CameraInfo)localObject1).orientation;
            i2 = i1;
            i1 = i3;
            break label342;
            if (bgvi.jdField_a_of_type_Int <= 0) {
              continue;
            }
            i3 = bgvi.jdField_a_of_type_Int;
            this.jdField_c_of_type_Int = i3;
            this.jdField_d_of_type_Int = i2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("camera open:");
              if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
                continue;
              }
              bool1 = true;
              QLog.d("ScannerView", 2, bool1 + " orientation:" + i1 + " facing:" + i2);
            }
            localObject1 = this.jdField_a_of_type_AndroidHardwareCamera;
            bool1 = bool2;
            if (localObject1 != null) {
              bool1 = true;
            }
            return bool1;
          }
          i1 += 1;
          continue;
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera = bkfp.a();
          i2 = 0;
          i1 = 90;
          continue;
        }
        int i3 = i1;
        continue;
        boolean bool1 = false;
        continue;
        i2 = i1;
      }
      catch (RuntimeException localRuntimeException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScannerView", 2, "camera open failed:" + localRuntimeException.getMessage());
        }
        return false;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      int i1 = 0;
      continue;
      i1 = 90;
      int i2 = 0;
    }
  }
  
  /* Error */
  @TargetApi(8)
  private boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 400	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 408	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 343	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   29: ifeq +34 -> 63
    //   32: aload_0
    //   33: getfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: getfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   43: invokevirtual 466	com/tencent/biz/widgets/ScannerView$AutoFocusThread:isAlive	()Z
    //   46: ifeq +10 -> 56
    //   49: aload_0
    //   50: getfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   53: invokevirtual 469	com/tencent/biz/widgets/ScannerView$AutoFocusThread:interrupt	()V
    //   56: aload_0
    //   57: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   60: invokevirtual 472	android/hardware/Camera:stopPreview	()V
    //   63: aload_0
    //   64: invokevirtual 476	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   67: ldc_w 478
    //   70: invokevirtual 482	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   73: checkcast 484	android/view/WindowManager
    //   76: invokeinterface 488 1 0
    //   81: invokevirtual 493	android/view/Display:getOrientation	()I
    //   84: bipush 90
    //   86: imul
    //   87: istore_2
    //   88: aload_0
    //   89: getfield 435	com/tencent/biz/widgets/ScannerView:jdField_d_of_type_Int	I
    //   92: ifne +367 -> 459
    //   95: aload_0
    //   96: getfield 433	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Int	I
    //   99: iload_2
    //   100: isub
    //   101: sipush 360
    //   104: iadd
    //   105: sipush 360
    //   108: irem
    //   109: istore_1
    //   110: aload_0
    //   111: iload_1
    //   112: putfield 495	com/tencent/biz/widgets/ScannerView:jdField_g_of_type_Int	I
    //   115: invokestatic 403	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +39 -> 157
    //   121: ldc 208
    //   123: iconst_2
    //   124: new 169	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 436	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 497
    //   134: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload_2
    //   138: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: ldc_w 499
    //   144: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: iload_1
    //   148: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_0
    //   158: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   161: invokevirtual 109	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   164: astore_3
    //   165: getstatic 260	android/os/Build$VERSION:SDK_INT	I
    //   168: bipush 8
    //   170: if_icmplt +303 -> 473
    //   173: aload_0
    //   174: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   177: iload_1
    //   178: invokevirtual 502	android/hardware/Camera:setDisplayOrientation	(I)V
    //   181: aload_3
    //   182: invokevirtual 505	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   185: ifeq +15 -> 200
    //   188: aload_3
    //   189: iconst_2
    //   190: aload_3
    //   191: invokevirtual 508	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   194: invokestatic 511	java/lang/Math:min	(II)I
    //   197: invokevirtual 514	android/hardware/Camera$Parameters:setZoom	(I)V
    //   200: aload_0
    //   201: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   204: aload_3
    //   205: invokevirtual 341	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   213: aload_0
    //   214: getfield 516	com/tencent/biz/widgets/ScannerView:jdField_e_of_type_Int	I
    //   217: aload_0
    //   218: getfield 518	com/tencent/biz/widgets/ScannerView:jdField_f_of_type_Int	I
    //   221: invokespecial 520	com/tencent/biz/widgets/ScannerView:a	(Landroid/hardware/Camera;II)Landroid/graphics/Point;
    //   224: astore_3
    //   225: aload_0
    //   226: aload_3
    //   227: getfield 523	android/graphics/Point:x	I
    //   230: putfield 524	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   233: aload_0
    //   234: aload_3
    //   235: getfield 527	android/graphics/Point:y	I
    //   238: putfield 529	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   241: invokestatic 403	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +44 -> 288
    //   247: ldc 208
    //   249: iconst_2
    //   250: new 169	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 436	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 531
    //   260: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_3
    //   264: getfield 523	android/graphics/Point:x	I
    //   267: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: ldc 187
    //   272: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_3
    //   276: getfield 527	android/graphics/Point:y	I
    //   279: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_0
    //   289: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   292: invokevirtual 109	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   295: astore 4
    //   297: aload 4
    //   299: aload_3
    //   300: getfield 523	android/graphics/Point:x	I
    //   303: aload_3
    //   304: getfield 527	android/graphics/Point:y	I
    //   307: invokevirtual 534	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   310: aload_0
    //   311: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   314: aload 4
    //   316: invokevirtual 341	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   319: aload_0
    //   320: getfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   323: astore 5
    //   325: aload 5
    //   327: astore_3
    //   328: aload 5
    //   330: ifnonnull +51 -> 381
    //   333: aload_0
    //   334: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   337: invokevirtual 109	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   340: astore 6
    //   342: aload 6
    //   344: invokevirtual 537	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   347: astore 7
    //   349: aload 7
    //   351: ifnonnull +218 -> 569
    //   354: aload 5
    //   356: astore_3
    //   357: aload_3
    //   358: ifnull +262 -> 620
    //   361: aload_3
    //   362: astore 4
    //   364: aload_0
    //   365: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   368: aload 6
    //   370: invokevirtual 341	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   373: aload_3
    //   374: astore 4
    //   376: aload_0
    //   377: aload_3
    //   378: putfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   381: aload_0
    //   382: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   385: aload_0
    //   386: getfield 241	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidViewSurfaceView	Landroid/view/SurfaceView;
    //   389: invokevirtual 249	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   392: invokevirtual 541	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   395: aload_0
    //   396: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   399: invokevirtual 544	android/hardware/Camera:startPreview	()V
    //   402: aload_0
    //   403: iconst_1
    //   404: putfield 343	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   407: ldc_w 345
    //   410: aload_3
    //   411: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   414: ifne +13 -> 427
    //   417: ldc_w 353
    //   420: aload_3
    //   421: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   424: ifeq +26 -> 450
    //   427: aload_0
    //   428: new 355	com/tencent/biz/widgets/ScannerView$AutoFocusThread
    //   431: dup
    //   432: aload_0
    //   433: aload_0
    //   434: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   437: invokespecial 360	com/tencent/biz/widgets/ScannerView$AutoFocusThread:<init>	(Lcom/tencent/biz/widgets/ScannerView;Landroid/hardware/Camera;)V
    //   440: putfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   443: aload_0
    //   444: getfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   447: invokevirtual 365	com/tencent/biz/widgets/ScannerView$AutoFocusThread:start	()V
    //   450: aload_0
    //   451: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   454: invokevirtual 408	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   457: iconst_1
    //   458: ireturn
    //   459: aload_0
    //   460: getfield 433	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Int	I
    //   463: iload_2
    //   464: iadd
    //   465: sipush 360
    //   468: irem
    //   469: istore_1
    //   470: goto -360 -> 110
    //   473: iload_2
    //   474: sipush 180
    //   477: irem
    //   478: ifne +13 -> 491
    //   481: aload_3
    //   482: ldc_w 545
    //   485: ldc_w 547
    //   488: invokevirtual 551	android/hardware/Camera$Parameters:set	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: aload_3
    //   492: iload_1
    //   493: invokevirtual 554	android/hardware/Camera$Parameters:setRotation	(I)V
    //   496: goto -296 -> 200
    //   499: astore_3
    //   500: invokestatic 403	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +12 -> 515
    //   506: ldc 208
    //   508: iconst_2
    //   509: ldc_w 556
    //   512: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: aload_0
    //   516: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   519: invokevirtual 408	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   522: iconst_0
    //   523: ireturn
    //   524: astore_3
    //   525: invokestatic 403	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq -209 -> 319
    //   531: ldc 208
    //   533: iconst_2
    //   534: ldc_w 558
    //   537: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: goto -221 -> 319
    //   543: astore_3
    //   544: invokestatic 403	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +12 -> 559
    //   550: ldc 208
    //   552: iconst_2
    //   553: ldc_w 556
    //   556: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: aload_0
    //   560: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   563: invokevirtual 408	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   566: goto -44 -> 522
    //   569: aload 5
    //   571: astore 4
    //   573: aload 7
    //   575: ldc_w 345
    //   578: invokeinterface 561 2 0
    //   583: ifeq +10 -> 593
    //   586: ldc_w 345
    //   589: astore_3
    //   590: goto -233 -> 357
    //   593: aload 5
    //   595: astore_3
    //   596: aload 5
    //   598: astore 4
    //   600: aload 7
    //   602: ldc_w 563
    //   605: invokeinterface 561 2 0
    //   610: ifeq -253 -> 357
    //   613: ldc_w 563
    //   616: astore_3
    //   617: goto -260 -> 357
    //   620: aload_3
    //   621: astore 4
    //   623: aload_0
    //   624: ldc_w 565
    //   627: putfield 347	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   630: goto -249 -> 381
    //   633: astore_3
    //   634: aload 4
    //   636: astore_3
    //   637: invokestatic 403	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq -259 -> 381
    //   643: ldc 208
    //   645: iconst_2
    //   646: new 169	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 436	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 567
    //   656: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 4
    //   661: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 569
    //   667: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   676: aload 4
    //   678: astore_3
    //   679: goto -298 -> 381
    //   682: astore_3
    //   683: aload_0
    //   684: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   687: invokevirtual 408	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   690: aload_3
    //   691: athrow
    //   692: astore_3
    //   693: goto -485 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	this	ScannerView
    //   109	384	1	i1	int
    //   87	391	2	i2	int
    //   11	481	3	localObject1	Object
    //   499	1	3	localIOException	java.io.IOException
    //   524	1	3	localRuntimeException1	RuntimeException
    //   543	1	3	localRuntimeException2	RuntimeException
    //   589	32	3	localObject2	Object
    //   633	1	3	localRuntimeException3	RuntimeException
    //   636	43	3	localObject3	Object
    //   682	9	3	localObject4	Object
    //   692	1	3	localRuntimeException4	RuntimeException
    //   295	382	4	localObject5	Object
    //   323	274	5	str	String
    //   340	29	6	localParameters	Camera.Parameters
    //   347	254	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   7	12	499	java/io/IOException
    //   25	56	499	java/io/IOException
    //   56	63	499	java/io/IOException
    //   63	110	499	java/io/IOException
    //   110	157	499	java/io/IOException
    //   157	200	499	java/io/IOException
    //   200	208	499	java/io/IOException
    //   208	288	499	java/io/IOException
    //   288	319	499	java/io/IOException
    //   319	325	499	java/io/IOException
    //   333	349	499	java/io/IOException
    //   364	373	499	java/io/IOException
    //   376	381	499	java/io/IOException
    //   381	427	499	java/io/IOException
    //   427	450	499	java/io/IOException
    //   459	470	499	java/io/IOException
    //   481	491	499	java/io/IOException
    //   491	496	499	java/io/IOException
    //   525	540	499	java/io/IOException
    //   573	586	499	java/io/IOException
    //   600	613	499	java/io/IOException
    //   623	630	499	java/io/IOException
    //   637	676	499	java/io/IOException
    //   288	319	524	java/lang/RuntimeException
    //   7	12	543	java/lang/RuntimeException
    //   25	56	543	java/lang/RuntimeException
    //   56	63	543	java/lang/RuntimeException
    //   63	110	543	java/lang/RuntimeException
    //   110	157	543	java/lang/RuntimeException
    //   157	200	543	java/lang/RuntimeException
    //   208	288	543	java/lang/RuntimeException
    //   319	325	543	java/lang/RuntimeException
    //   333	349	543	java/lang/RuntimeException
    //   381	427	543	java/lang/RuntimeException
    //   427	450	543	java/lang/RuntimeException
    //   459	470	543	java/lang/RuntimeException
    //   481	491	543	java/lang/RuntimeException
    //   491	496	543	java/lang/RuntimeException
    //   525	540	543	java/lang/RuntimeException
    //   637	676	543	java/lang/RuntimeException
    //   364	373	633	java/lang/RuntimeException
    //   376	381	633	java/lang/RuntimeException
    //   573	586	633	java/lang/RuntimeException
    //   600	613	633	java/lang/RuntimeException
    //   623	630	633	java/lang/RuntimeException
    //   7	12	682	finally
    //   25	56	682	finally
    //   56	63	682	finally
    //   63	110	682	finally
    //   110	157	682	finally
    //   157	200	682	finally
    //   200	208	682	finally
    //   208	288	682	finally
    //   288	319	682	finally
    //   319	325	682	finally
    //   333	349	682	finally
    //   364	373	682	finally
    //   376	381	682	finally
    //   381	427	682	finally
    //   427	450	682	finally
    //   459	470	682	finally
    //   481	491	682	finally
    //   491	496	682	finally
    //   500	515	682	finally
    //   525	540	682	finally
    //   544	559	682	finally
    //   573	586	682	finally
    //   600	613	682	finally
    //   623	630	682	finally
    //   637	676	682	finally
    //   200	208	692	java/lang/RuntimeException
  }
  
  private static boolean c()
  {
    if (("Lenovo K50-t5".equalsIgnoreCase(Build.MODEL)) && ("LENOVO".equalsIgnoreCase(Build.MANUFACTURER))) {}
    while (("Redmi Note 3".equalsIgnoreCase(Build.MODEL)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER))) {
      return true;
    }
    return false;
  }
  
  private void e()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new RuntimeException("This method must be called on UI thread");
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 400	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 408	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: return
    //   24: aload_0
    //   25: getfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   28: ifnull +25 -> 53
    //   31: aload_0
    //   32: getfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   35: invokevirtual 466	com/tencent/biz/widgets/ScannerView$AutoFocusThread:isAlive	()Z
    //   38: ifeq +15 -> 53
    //   41: aload_0
    //   42: getfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   45: invokevirtual 469	com/tencent/biz/widgets/ScannerView$AutoFocusThread:interrupt	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 362	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   53: aload_0
    //   54: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   57: invokevirtual 109	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   60: astore_1
    //   61: aload_1
    //   62: ldc_w 386
    //   65: invokevirtual 337	android/hardware/Camera$Parameters:setFlashMode	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   72: aload_1
    //   73: invokevirtual 341	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 367	com/tencent/biz/widgets/ScannerView:jdField_d_of_type_Boolean	Z
    //   81: aload_0
    //   82: getfield 343	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   85: ifeq +15 -> 100
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 343	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   93: aload_0
    //   94: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   97: invokevirtual 472	android/hardware/Camera:stopPreview	()V
    //   100: aload_0
    //   101: getfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   104: invokevirtual 594	android/hardware/Camera:release	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 357	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   112: aload_0
    //   113: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   116: invokevirtual 408	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   119: return
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 408	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: goto -50 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ScannerView
    //   11	62	1	localObject1	Object
    //   120	9	1	localObject2	Object
    //   130	1	1	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   7	12	120	finally
    //   24	53	120	finally
    //   53	81	120	finally
    //   81	100	120	finally
    //   100	112	120	finally
    //   53	81	130	java/lang/RuntimeException
  }
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i1 = paramSize1.height * paramSize1.width;
    int i2 = paramSize2.height * paramSize2.width;
    if (i2 < i1) {
      return 1;
    }
    if (i2 > i1) {
      return -1;
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Abdw);
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
      this.jdField_a_of_type_Abdw = null;
    }
  }
  
  public void a(Context paramContext)
  {
    if (c()) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    } while (this.jdField_a_of_type_AndroidHardwareSensorManager == null);
    if (this.jdField_a_of_type_Abdw == null) {
      this.jdField_a_of_type_Abdw = new abdw(this);
    }
    paramContext = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Abdw, paramContext, 2);
  }
  
  public void a(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread == null) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if (!this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f3;
      this.jdField_f_of_type_Boolean = true;
    }
    float f4 = Math.abs(this.jdField_a_of_type_Float - f1);
    float f5 = Math.abs(this.jdField_b_of_type_Float - f2);
    float f6 = Math.abs(this.jdField_c_of_type_Float - f3);
    if (((f4 > 0.5D) || (f5 > 0.5D) || (f6 > 0.5D)) && (this.jdField_g_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread.a();
      label157:
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f3;
      return;
    }
    catch (RuntimeException paramSensorEvent)
    {
      break label157;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_h_of_type_Boolean) && (b()))
    {
      ThreadManager.getUIHandler().post(new ScannerView.6(this));
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Long = 0L;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(7);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean) {
      ThreadManager.post(new ScannerView.5(this), 8, null, true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Abek != null) {
      this.jdField_a_of_type_Abek.b();
    }
    ThreadManager.post(new ScannerView.7(this), 8, null, false);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread == null) {}
    do
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread == null)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread = new ScannerView.DecodeThread(this, "ScannerDecodeThread");
          this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.start();
          this.jdField_a_of_type_AndroidOsHandler = new abds(this, this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.getLooper());
        }
        if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.jdField_a_of_type_Boolean) {
          return;
        }
      }
      finally {}
    } while (!this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock());
    try
    {
      Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
      if (localCamera == null) {
        return;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setOneShotPreviewCallback(this);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
    try
    {
      if ((this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread != null) && (!this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.quit();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
    finally {}
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (this.jdField_a_of_type_Abek != null)
    {
      this.jdField_a_of_type_Abek.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      if (this.m != -1) {
        break label167;
      }
      int i1 = this.j;
      paramInt1 = paramInt3 - paramInt1 - this.k;
      paramInt3 = i1;
      if (this.n != -1) {
        break label249;
      }
      i1 = this.i;
      paramInt2 = paramInt4 - paramInt2 - this.l;
      paramInt4 = i1;
    }
    for (;;)
    {
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.jdField_c_of_type_AndroidGraphicsRect == null) {
        this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
      }
      this.jdField_c_of_type_AndroidGraphicsRect.set(paramInt3, paramInt4, paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidGraphicsRect = this.jdField_c_of_type_AndroidGraphicsRect;
      this.jdField_c_of_type_AndroidGraphicsRect = localRect;
      this.jdField_b_of_type_AndroidGraphicsRect = null;
      this.jdField_a_of_type_Abek.a(paramInt3, paramInt4, paramInt1, paramInt2);
      return;
      label167:
      if ((this.o & 0x3) == 3)
      {
        paramInt3 = this.j;
        paramInt1 = this.m + paramInt3;
        break;
      }
      if ((this.o & 0x5) == 5)
      {
        paramInt1 = paramInt3 - paramInt1 - this.k;
        paramInt3 = paramInt1 - this.m;
        break;
      }
      paramInt3 = paramInt3 - paramInt1 - this.m >> 1;
      paramInt1 = this.m + paramInt3;
      break;
      label249:
      if ((this.o & 0x30) == 48)
      {
        paramInt4 = this.i;
        paramInt2 = this.n + paramInt4;
      }
      else if ((this.o & 0x50) == 80)
      {
        paramInt2 = paramInt4 - paramInt2 - this.l;
        paramInt4 = paramInt2 - this.n;
      }
      else
      {
        paramInt4 = paramInt4 - paramInt2 - this.n >> 1;
        paramInt2 = this.n + paramInt4;
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramArrayOfByte).sendToTarget();
    }
  }
  
  public void setFileDecodeListener(abdt paramabdt)
  {
    e();
    this.jdField_a_of_type_Abdt = paramabdt;
  }
  
  public void setFlashLightListener(abdu paramabdu)
  {
    e();
    this.jdField_a_of_type_Abdu = paramabdu;
  }
  
  public void setScanListener(abdv paramabdv)
  {
    e();
    this.jdField_a_of_type_Abdv = paramabdv;
  }
  
  public void setViewFinder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e();
    this.o = 51;
    this.j = paramInt1;
    this.i = paramInt2;
    this.m = (paramInt3 - paramInt1);
    this.n = (paramInt4 - paramInt2);
    this.k = 0;
    this.l = 0;
    if (this.jdField_a_of_type_Abek == null)
    {
      this.jdField_a_of_type_Abek = new abek(getContext());
      addView(this.jdField_a_of_type_Abek);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_Abek.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_f_of_type_Int = paramInt3;
    if (this.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_c_of_type_Boolean) {
        ThreadManager.post(new ScannerView.2(this), 8, null, true);
      }
    }
    else {
      return;
    }
    ThreadManager.post(new ScannerView.3(this), 8, null, true);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = false;
    ThreadManager.post(new ScannerView.4(this), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView
 * JD-Core Version:    0.7.0.1
 */