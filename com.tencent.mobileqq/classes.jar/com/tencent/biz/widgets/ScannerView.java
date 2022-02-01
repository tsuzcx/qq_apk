package com.tencent.biz.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
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
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
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
  private float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  protected long a;
  Rect jdField_a_of_type_AndroidGraphicsRect = null;
  Camera jdField_a_of_type_AndroidHardwareCamera;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private ScannerView.AutoFocusThread jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread;
  ScannerView.DecodeThread jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread;
  private ScannerView.FileDecodeListener jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener;
  private ScannerView.FlashLightListener jdField_a_of_type_ComTencentBizWidgetsScannerView$FlashLightListener;
  private ScannerView.ScannerListener jdField_a_of_type_ComTencentBizWidgetsScannerView$ScannerListener;
  private ScannerView.WeakSensorEventListener jdField_a_of_type_ComTencentBizWidgetsScannerView$WeakSensorEventListener;
  private ViewFinderView jdField_a_of_type_ComTencentBizWidgetsViewFinderView;
  String jdField_a_of_type_JavaLangString;
  public StringBuilder a;
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  public boolean a;
  private float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int;
  protected long b;
  Rect jdField_b_of_type_AndroidGraphicsRect = null;
  Handler jdField_b_of_type_AndroidOsHandler = new ScannerView.1(this);
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  int jdField_c_of_type_Int;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = -1;
  private int n = -1;
  private int o = 17;
  
  public ScannerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext, null);
  }
  
  public ScannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext, paramAttributeSet);
  }
  
  private Point a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    paramCamera = paramCamera.getParameters();
    Camera.Size localSize1 = paramCamera.getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL))) {
      return new Point(localSize1.width, localSize1.height);
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
      paramCamera = new StringBuilder("manufacturer:");
      paramCamera.append(Build.MANUFACTURER);
      paramCamera.append(" model:");
      paramCamera.append(Build.MODEL);
      paramCamera.append("\ndefault size:");
      paramCamera.append(localSize1.width);
      paramCamera.append(" x ");
      paramCamera.append(localSize1.height);
      paramCamera.append("\nsizes:");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)((Iterator)localObject2).next();
        paramCamera.append(localSize2.width);
        paramCamera.append(" x ");
        paramCamera.append(localSize2.height);
        paramCamera.append(" | ");
      }
      QLog.d("ScannerView", 4, paramCamera.toString());
    }
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      int i1 = ((Camera.Size)localObject2).width;
      int i2 = ((Camera.Size)localObject2).height;
      int i3 = i1 * i2;
      if ((i3 >= 76800) && (i3 <= 921600) && ((i1 != 980) || (i2 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i1 == 1184) && (i2 == 666)) || ((i1 != 704) || (i2 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        int i4 = 0;
        if (paramInt1 > paramInt2) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        if (i1 < i2) {
          i4 = 1;
        }
        int i5;
        if (i3 == i4)
        {
          i4 = i2;
          i3 = i1;
          i5 = i3;
        }
        else
        {
          i5 = i2;
          i3 = i1;
          i4 = i3;
        }
        if ((i4 == paramInt1) && (i5 == paramInt2)) {
          return new Point(i1, i2);
        }
        if ((i4 >= paramInt1 >> 1) && (i4 >> 1 <= paramInt1) && (i5 >= paramInt2 >> 1) && (i5 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i4 / i5 - f3);
          if (f2 < f1)
          {
            paramCamera = new Point(i1, i2);
            f1 = f2;
          }
        }
      }
    }
    if (paramCamera != null) {
      return paramCamera;
    }
    return new Point(localSize1.width, localSize1.height);
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
      while (i1 < i2)
      {
        int i3 = ((TypedArray)localObject).getIndex(i1);
        switch (i3)
        {
        default: 
          break;
        case 8: 
          this.m = ((TypedArray)localObject).getLayoutDimension(i3, this.m);
          break;
        case 7: 
          this.jdField_i_of_type_Int = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.jdField_i_of_type_Int);
          break;
        case 6: 
          this.k = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.k);
          break;
        case 5: 
          this.j = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.j);
          break;
        case 4: 
          this.n = ((TypedArray)localObject).getLayoutDimension(i3, this.n);
          break;
        case 3: 
          this.o = ((TypedArray)localObject).getInt(i3, this.o);
          break;
        case 2: 
          this.l = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.l);
        }
        i1 += 1;
      }
      ((TypedArray)localObject).recycle();
      this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView = new ViewFinderView(paramContext);
      addView(this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView);
    }
    if (paramAttributeSet != null) {
      this.jdField_b_of_type_Boolean = paramAttributeSet.getAttributeBooleanValue(0, true);
    }
  }
  
  private void a(Camera paramCamera, boolean paramBoolean)
  {
    try
    {
      localParameters = paramCamera.getParameters();
      localObject = "torch";
      if (MobileIssueSettings.j) {
        break label141;
      }
      localObject = KapalaiAdapterUtil.a().a(localParameters);
    }
    catch (RuntimeException paramCamera)
    {
      for (;;)
      {
        Camera.Parameters localParameters;
        Object localObject;
        label45:
        continue;
        label141:
        if (!paramBoolean) {
          localObject = "off";
        }
      }
    }
    localParameters.setFlashMode((String)localObject);
    paramCamera.setParameters(localParameters);
    break label45;
    paramBoolean = false;
    if ((this.jdField_d_of_type_Boolean) && (("auto".equals(this.jdField_a_of_type_JavaLangString)) || ("macro".equals(this.jdField_a_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread = new ScannerView.AutoFocusThread(this, this.jdField_a_of_type_AndroidHardwareCamera);
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread.start();
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    localObject = this.jdField_b_of_type_AndroidOsHandler;
    if (paramBoolean) {
      paramCamera = Boolean.TRUE;
    } else {
      paramCamera = Boolean.FALSE;
    }
    ((Handler)localObject).obtainMessage(10, paramCamera).sendToTarget();
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  private boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 414	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: iconst_0
    //   8: istore 5
    //   10: aload_0
    //   11: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   14: ifnull +27 -> 41
    //   17: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +12 -> 32
    //   23: ldc 224
    //   25: iconst_2
    //   26: ldc_w 419
    //   29: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   36: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   39: iconst_1
    //   40: ireturn
    //   41: bipush 90
    //   43: istore_1
    //   44: getstatic 288	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 9
    //   49: if_icmplt +79 -> 128
    //   52: invokestatic 425	android/hardware/Camera:getNumberOfCameras	()I
    //   55: istore_2
    //   56: iload_2
    //   57: ifle +312 -> 369
    //   60: new 427	android/hardware/Camera$CameraInfo
    //   63: dup
    //   64: invokespecial 428	android/hardware/Camera$CameraInfo:<init>	()V
    //   67: astore 6
    //   69: iconst_0
    //   70: istore_1
    //   71: iload_1
    //   72: iload_2
    //   73: if_icmpge +20 -> 93
    //   76: iload_1
    //   77: aload 6
    //   79: invokestatic 432	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   82: aload 6
    //   84: getfield 435	android/hardware/Camera$CameraInfo:facing	I
    //   87: ifne +270 -> 357
    //   90: goto +3 -> 93
    //   93: iload_1
    //   94: iload_2
    //   95: if_icmplt +269 -> 364
    //   98: iconst_0
    //   99: aload 6
    //   101: invokestatic 432	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   104: iconst_1
    //   105: istore_2
    //   106: iconst_0
    //   107: istore_1
    //   108: goto +3 -> 111
    //   111: aload_0
    //   112: iload_1
    //   113: invokestatic 440	com/tencent/util/CameraUtil:a	(I)Landroid/hardware/Camera;
    //   116: putfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   119: aload 6
    //   121: getfield 443	android/hardware/Camera$CameraInfo:orientation	I
    //   124: istore_1
    //   125: goto +13 -> 138
    //   128: aload_0
    //   129: invokestatic 446	com/tencent/util/CameraUtil:a	()Landroid/hardware/Camera;
    //   132: putfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   135: goto +234 -> 369
    //   138: getstatic 448	com/tencent/mobileqq/utils/kapalaiadapter/MobileIssueSettings:jdField_a_of_type_Int	I
    //   141: ifle +233 -> 374
    //   144: getstatic 448	com/tencent/mobileqq/utils/kapalaiadapter/MobileIssueSettings:jdField_a_of_type_Int	I
    //   147: istore_3
    //   148: goto +3 -> 151
    //   151: aload_0
    //   152: iload_3
    //   153: putfield 450	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Int	I
    //   156: aload_0
    //   157: iload_2
    //   158: putfield 452	com/tencent/biz/widgets/ScannerView:jdField_d_of_type_Int	I
    //   161: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +85 -> 249
    //   167: new 185	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   174: astore 6
    //   176: aload 6
    //   178: ldc_w 455
    //   181: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_0
    //   186: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   189: ifnull +190 -> 379
    //   192: iconst_1
    //   193: istore 4
    //   195: goto +3 -> 198
    //   198: aload 6
    //   200: iload 4
    //   202: invokevirtual 458	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 6
    //   208: ldc_w 460
    //   211: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 6
    //   217: iload_1
    //   218: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 6
    //   224: ldc_w 462
    //   227: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 6
    //   233: iload_2
    //   234: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: ldc 224
    //   240: iconst_2
    //   241: aload 6
    //   243: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   253: astore 6
    //   255: iload 5
    //   257: istore 4
    //   259: aload 6
    //   261: ifnull +6 -> 267
    //   264: iconst_1
    //   265: istore 4
    //   267: aload_0
    //   268: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   271: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   274: iload 4
    //   276: ireturn
    //   277: astore 6
    //   279: goto +62 -> 341
    //   282: astore 6
    //   284: iload 5
    //   286: istore 4
    //   288: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq -24 -> 267
    //   294: new 185	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   301: astore 7
    //   303: aload 7
    //   305: ldc_w 464
    //   308: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 7
    //   314: aload 6
    //   316: invokevirtual 467	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   319: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: ldc 224
    //   325: iconst_2
    //   326: aload 7
    //   328: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: iload 5
    //   336: istore 4
    //   338: goto -71 -> 267
    //   341: aload_0
    //   342: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   345: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   348: goto +6 -> 354
    //   351: aload 6
    //   353: athrow
    //   354: goto -3 -> 351
    //   357: iload_1
    //   358: iconst_1
    //   359: iadd
    //   360: istore_1
    //   361: goto -290 -> 71
    //   364: iconst_0
    //   365: istore_2
    //   366: goto -255 -> 111
    //   369: iconst_0
    //   370: istore_2
    //   371: goto -233 -> 138
    //   374: iload_1
    //   375: istore_3
    //   376: goto -225 -> 151
    //   379: iconst_0
    //   380: istore 4
    //   382: goto -184 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	ScannerView
    //   43	332	1	i1	int
    //   55	316	2	i2	int
    //   147	229	3	i3	int
    //   193	188	4	bool1	boolean
    //   8	327	5	bool2	boolean
    //   67	193	6	localObject1	Object
    //   277	1	6	localObject2	Object
    //   282	70	6	localRuntimeException	RuntimeException
    //   301	26	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	32	277	finally
    //   44	56	277	finally
    //   60	69	277	finally
    //   76	90	277	finally
    //   98	104	277	finally
    //   111	125	277	finally
    //   128	135	277	finally
    //   138	148	277	finally
    //   151	192	277	finally
    //   198	249	277	finally
    //   249	255	277	finally
    //   288	334	277	finally
    //   10	32	282	java/lang/RuntimeException
    //   44	56	282	java/lang/RuntimeException
    //   60	69	282	java/lang/RuntimeException
    //   76	90	282	java/lang/RuntimeException
    //   98	104	282	java/lang/RuntimeException
    //   111	125	282	java/lang/RuntimeException
    //   128	135	282	java/lang/RuntimeException
    //   138	148	282	java/lang/RuntimeException
    //   151	192	282	java/lang/RuntimeException
    //   198	249	282	java/lang/RuntimeException
    //   249	255	282	java/lang/RuntimeException
  }
  
  /* Error */
  @android.annotation.TargetApi(8)
  private boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 414	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_d_of_type_Boolean	Z
    //   29: ifeq +34 -> 63
    //   32: aload_0
    //   33: getfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: getfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   43: invokevirtual 478	com/tencent/biz/widgets/ScannerView$AutoFocusThread:isAlive	()Z
    //   46: ifeq +10 -> 56
    //   49: aload_0
    //   50: getfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   53: invokevirtual 481	com/tencent/biz/widgets/ScannerView$AutoFocusThread:interrupt	()V
    //   56: aload_0
    //   57: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   60: invokevirtual 484	android/hardware/Camera:stopPreview	()V
    //   63: aload_0
    //   64: invokevirtual 488	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   67: ldc_w 490
    //   70: invokevirtual 494	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   73: checkcast 496	android/view/WindowManager
    //   76: invokeinterface 500 1 0
    //   81: invokevirtual 505	android/view/Display:getOrientation	()I
    //   84: bipush 90
    //   86: imul
    //   87: istore_2
    //   88: aload_0
    //   89: getfield 452	com/tencent/biz/widgets/ScannerView:jdField_d_of_type_Int	I
    //   92: ifne +21 -> 113
    //   95: aload_0
    //   96: getfield 450	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Int	I
    //   99: iload_2
    //   100: isub
    //   101: sipush 360
    //   104: iadd
    //   105: sipush 360
    //   108: irem
    //   109: istore_1
    //   110: goto +14 -> 124
    //   113: aload_0
    //   114: getfield 450	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Int	I
    //   117: iload_2
    //   118: iadd
    //   119: sipush 360
    //   122: irem
    //   123: istore_1
    //   124: aload_0
    //   125: iload_1
    //   126: putfield 507	com/tencent/biz/widgets/ScannerView:jdField_g_of_type_Int	I
    //   129: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +49 -> 181
    //   135: new 185	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   142: astore_3
    //   143: aload_3
    //   144: ldc_w 509
    //   147: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_3
    //   152: iload_2
    //   153: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: ldc_w 511
    //   161: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_3
    //   166: iload_1
    //   167: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc 224
    //   173: iconst_2
    //   174: aload_3
    //   175: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_0
    //   182: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   185: invokevirtual 125	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   188: astore_3
    //   189: getstatic 288	android/os/Build$VERSION:SDK_INT	I
    //   192: bipush 8
    //   194: if_icmplt +33 -> 227
    //   197: aload_0
    //   198: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   201: iload_1
    //   202: invokevirtual 514	android/hardware/Camera:setDisplayOrientation	(I)V
    //   205: aload_3
    //   206: invokevirtual 517	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   209: ifeq +41 -> 250
    //   212: aload_3
    //   213: iconst_2
    //   214: aload_3
    //   215: invokevirtual 520	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   218: invokestatic 523	java/lang/Math:min	(II)I
    //   221: invokevirtual 526	android/hardware/Camera$Parameters:setZoom	(I)V
    //   224: goto +26 -> 250
    //   227: iload_2
    //   228: sipush 180
    //   231: irem
    //   232: ifne +13 -> 245
    //   235: aload_3
    //   236: ldc_w 527
    //   239: ldc_w 529
    //   242: invokevirtual 533	android/hardware/Camera$Parameters:set	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_3
    //   246: iload_1
    //   247: invokevirtual 536	android/hardware/Camera$Parameters:setRotation	(I)V
    //   250: aload_0
    //   251: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   254: aload_3
    //   255: invokevirtual 359	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   258: aload_0
    //   259: aload_0
    //   260: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   263: aload_0
    //   264: getfield 538	com/tencent/biz/widgets/ScannerView:jdField_e_of_type_Int	I
    //   267: aload_0
    //   268: getfield 540	com/tencent/biz/widgets/ScannerView:jdField_f_of_type_Int	I
    //   271: invokespecial 542	com/tencent/biz/widgets/ScannerView:a	(Landroid/hardware/Camera;II)Landroid/graphics/Point;
    //   274: astore_3
    //   275: aload_0
    //   276: aload_3
    //   277: getfield 545	android/graphics/Point:x	I
    //   280: putfield 546	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   283: aload_0
    //   284: aload_3
    //   285: getfield 549	android/graphics/Point:y	I
    //   288: putfield 551	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   291: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +60 -> 354
    //   297: new 185	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   304: astore 4
    //   306: aload 4
    //   308: ldc_w 553
    //   311: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 4
    //   317: aload_3
    //   318: getfield 545	android/graphics/Point:x	I
    //   321: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 4
    //   327: ldc 203
    //   329: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 4
    //   335: aload_3
    //   336: getfield 549	android/graphics/Point:y	I
    //   339: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: ldc 224
    //   345: iconst_2
    //   346: aload 4
    //   348: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload_0
    //   355: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   358: invokevirtual 125	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   361: astore 4
    //   363: aload 4
    //   365: aload_3
    //   366: getfield 545	android/graphics/Point:x	I
    //   369: aload_3
    //   370: getfield 549	android/graphics/Point:y	I
    //   373: invokevirtual 556	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   376: aload_0
    //   377: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   380: aload 4
    //   382: invokevirtual 359	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   385: goto +18 -> 403
    //   388: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +12 -> 403
    //   394: ldc 224
    //   396: iconst_2
    //   397: ldc_w 558
    //   400: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: aload_0
    //   404: getfield 363	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   407: astore 5
    //   409: aload 5
    //   411: astore_3
    //   412: aload 5
    //   414: ifnonnull +171 -> 585
    //   417: aload_0
    //   418: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   421: invokevirtual 125	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   424: astore 6
    //   426: aload 6
    //   428: invokevirtual 561	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   431: astore 7
    //   433: aload 7
    //   435: ifnonnull +9 -> 444
    //   438: aload 5
    //   440: astore_3
    //   441: goto +51 -> 492
    //   444: aload 5
    //   446: astore 4
    //   448: aload 7
    //   450: ldc_w 361
    //   453: invokeinterface 564 2 0
    //   458: ifeq +10 -> 468
    //   461: ldc_w 361
    //   464: astore_3
    //   465: goto +27 -> 492
    //   468: aload 5
    //   470: astore_3
    //   471: aload 5
    //   473: astore 4
    //   475: aload 7
    //   477: ldc_w 566
    //   480: invokeinterface 564 2 0
    //   485: ifeq +7 -> 492
    //   488: ldc_w 566
    //   491: astore_3
    //   492: aload_3
    //   493: ifnull +26 -> 519
    //   496: aload_3
    //   497: astore 4
    //   499: aload_0
    //   500: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   503: aload 6
    //   505: invokevirtual 359	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   508: aload_3
    //   509: astore 4
    //   511: aload_0
    //   512: aload_3
    //   513: putfield 363	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   516: goto +69 -> 585
    //   519: aload_3
    //   520: astore 4
    //   522: aload_0
    //   523: ldc_w 568
    //   526: putfield 363	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   529: goto +56 -> 585
    //   532: aload 4
    //   534: astore_3
    //   535: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +47 -> 585
    //   541: new 185	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   548: astore_3
    //   549: aload_3
    //   550: ldc_w 570
    //   553: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload_3
    //   558: aload 4
    //   560: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload_3
    //   565: ldc_w 572
    //   568: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: ldc 224
    //   574: iconst_2
    //   575: aload_3
    //   576: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload 4
    //   584: astore_3
    //   585: aload_0
    //   586: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   589: aload_0
    //   590: getfield 269	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidViewSurfaceView	Landroid/view/SurfaceView;
    //   593: invokevirtual 277	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   596: invokevirtual 576	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   599: aload_0
    //   600: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   603: invokevirtual 579	android/hardware/Camera:startPreview	()V
    //   606: aload_0
    //   607: iconst_1
    //   608: putfield 87	com/tencent/biz/widgets/ScannerView:jdField_d_of_type_Boolean	Z
    //   611: ldc_w 361
    //   614: aload_3
    //   615: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   618: ifne +13 -> 631
    //   621: ldc_w 369
    //   624: aload_3
    //   625: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   628: ifeq +26 -> 654
    //   631: aload_0
    //   632: new 371	com/tencent/biz/widgets/ScannerView$AutoFocusThread
    //   635: dup
    //   636: aload_0
    //   637: aload_0
    //   638: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   641: invokespecial 376	com/tencent/biz/widgets/ScannerView$AutoFocusThread:<init>	(Lcom/tencent/biz/widgets/ScannerView;Landroid/hardware/Camera;)V
    //   644: putfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   647: aload_0
    //   648: getfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   651: invokevirtual 381	com/tencent/biz/widgets/ScannerView$AutoFocusThread:start	()V
    //   654: aload_0
    //   655: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   658: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   661: iconst_1
    //   662: ireturn
    //   663: astore_3
    //   664: goto +45 -> 709
    //   667: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq +30 -> 700
    //   673: ldc 224
    //   675: iconst_2
    //   676: ldc_w 581
    //   679: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: goto +18 -> 700
    //   685: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +12 -> 700
    //   691: ldc 224
    //   693: iconst_2
    //   694: ldc_w 581
    //   697: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: aload_0
    //   701: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   704: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   707: iconst_0
    //   708: ireturn
    //   709: aload_0
    //   710: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   713: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   716: aload_3
    //   717: athrow
    //   718: astore_3
    //   719: goto -34 -> 685
    //   722: astore_3
    //   723: goto -56 -> 667
    //   726: astore_3
    //   727: goto -469 -> 258
    //   730: astore_3
    //   731: goto -343 -> 388
    //   734: astore_3
    //   735: goto -203 -> 532
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	738	0	this	ScannerView
    //   109	138	1	i1	int
    //   87	145	2	i2	int
    //   11	614	3	localObject1	Object
    //   663	54	3	localObject2	Object
    //   718	1	3	localIOException	java.io.IOException
    //   722	1	3	localRuntimeException1	RuntimeException
    //   726	1	3	localRuntimeException2	RuntimeException
    //   730	1	3	localRuntimeException3	RuntimeException
    //   734	1	3	localRuntimeException4	RuntimeException
    //   304	279	4	localObject3	Object
    //   407	65	5	str	String
    //   424	80	6	localParameters	Camera.Parameters
    //   431	45	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   7	12	663	finally
    //   25	56	663	finally
    //   56	63	663	finally
    //   63	110	663	finally
    //   113	124	663	finally
    //   124	181	663	finally
    //   181	224	663	finally
    //   235	245	663	finally
    //   245	250	663	finally
    //   250	258	663	finally
    //   258	354	663	finally
    //   354	385	663	finally
    //   388	403	663	finally
    //   403	409	663	finally
    //   417	433	663	finally
    //   448	461	663	finally
    //   475	488	663	finally
    //   499	508	663	finally
    //   511	516	663	finally
    //   522	529	663	finally
    //   535	582	663	finally
    //   585	631	663	finally
    //   631	654	663	finally
    //   667	682	663	finally
    //   685	700	663	finally
    //   7	12	718	java/io/IOException
    //   25	56	718	java/io/IOException
    //   56	63	718	java/io/IOException
    //   63	110	718	java/io/IOException
    //   113	124	718	java/io/IOException
    //   124	181	718	java/io/IOException
    //   181	224	718	java/io/IOException
    //   235	245	718	java/io/IOException
    //   245	250	718	java/io/IOException
    //   250	258	718	java/io/IOException
    //   258	354	718	java/io/IOException
    //   354	385	718	java/io/IOException
    //   388	403	718	java/io/IOException
    //   403	409	718	java/io/IOException
    //   417	433	718	java/io/IOException
    //   448	461	718	java/io/IOException
    //   475	488	718	java/io/IOException
    //   499	508	718	java/io/IOException
    //   511	516	718	java/io/IOException
    //   522	529	718	java/io/IOException
    //   535	582	718	java/io/IOException
    //   585	631	718	java/io/IOException
    //   631	654	718	java/io/IOException
    //   7	12	722	java/lang/RuntimeException
    //   25	56	722	java/lang/RuntimeException
    //   56	63	722	java/lang/RuntimeException
    //   63	110	722	java/lang/RuntimeException
    //   113	124	722	java/lang/RuntimeException
    //   124	181	722	java/lang/RuntimeException
    //   181	224	722	java/lang/RuntimeException
    //   235	245	722	java/lang/RuntimeException
    //   245	250	722	java/lang/RuntimeException
    //   258	354	722	java/lang/RuntimeException
    //   388	403	722	java/lang/RuntimeException
    //   403	409	722	java/lang/RuntimeException
    //   417	433	722	java/lang/RuntimeException
    //   535	582	722	java/lang/RuntimeException
    //   585	631	722	java/lang/RuntimeException
    //   631	654	722	java/lang/RuntimeException
    //   250	258	726	java/lang/RuntimeException
    //   354	385	730	java/lang/RuntimeException
    //   448	461	734	java/lang/RuntimeException
    //   475	488	734	java/lang/RuntimeException
    //   499	508	734	java/lang/RuntimeException
    //   511	516	734	java/lang/RuntimeException
    //   522	529	734	java/lang/RuntimeException
  }
  
  private static boolean c()
  {
    if (("Lenovo K50-t5".equalsIgnoreCase(Build.MODEL)) && ("LENOVO".equalsIgnoreCase(Build.MANUFACTURER))) {
      return true;
    }
    return ("Redmi Note 3".equalsIgnoreCase(Build.MODEL)) && ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER));
  }
  
  private void e()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new RuntimeException("This method must be called on UI thread");
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 414	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: return
    //   24: aload_0
    //   25: getfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   28: ifnull +25 -> 53
    //   31: aload_0
    //   32: getfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   35: invokevirtual 478	com/tencent/biz/widgets/ScannerView$AutoFocusThread:isAlive	()Z
    //   38: ifeq +15 -> 53
    //   41: aload_0
    //   42: getfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   45: invokevirtual 481	com/tencent/biz/widgets/ScannerView$AutoFocusThread:interrupt	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 378	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread	Lcom/tencent/biz/widgets/ScannerView$AutoFocusThread;
    //   53: aload_0
    //   54: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   57: invokevirtual 125	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   60: astore_1
    //   61: aload_1
    //   62: ldc_w 403
    //   65: invokevirtual 355	android/hardware/Camera$Parameters:setFlashMode	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   72: aload_1
    //   73: invokevirtual 359	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 89	com/tencent/biz/widgets/ScannerView:jdField_e_of_type_Boolean	Z
    //   81: aload_0
    //   82: getfield 87	com/tencent/biz/widgets/ScannerView:jdField_d_of_type_Boolean	Z
    //   85: ifeq +15 -> 100
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 87	com/tencent/biz/widgets/ScannerView:jdField_d_of_type_Boolean	Z
    //   93: aload_0
    //   94: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   97: invokevirtual 484	android/hardware/Camera:stopPreview	()V
    //   100: aload_0
    //   101: getfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   104: invokevirtual 606	android/hardware/Camera:release	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 373	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   112: aload_0
    //   113: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   116: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   119: return
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 56	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:unlock	()V
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
    SensorManager localSensorManager = this.jdField_a_of_type_AndroidHardwareSensorManager;
    if (localSensorManager != null)
    {
      localSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentBizWidgetsScannerView$WeakSensorEventListener);
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
      this.jdField_a_of_type_ComTencentBizWidgetsScannerView$WeakSensorEventListener = null;
    }
  }
  
  public void a(Context paramContext)
  {
    if (c()) {
      return;
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$WeakSensorEventListener == null) {
        this.jdField_a_of_type_ComTencentBizWidgetsScannerView$WeakSensorEventListener = new ScannerView.WeakSensorEventListener(this);
      }
      paramContext = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_ComTencentBizWidgetsScannerView$WeakSensorEventListener, paramContext, 2);
    }
  }
  
  public void a(SensorEvent paramSensorEvent)
  {
    float f1;
    float f2;
    float f3;
    if ((this.jdField_a_of_type_AndroidHardwareCamera != null) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$AutoFocusThread != null))
    {
      if (this.jdField_f_of_type_Boolean) {
        return;
      }
      f1 = paramSensorEvent.values[0];
      f2 = paramSensorEvent.values[1];
      f3 = paramSensorEvent.values[2];
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        this.jdField_c_of_type_Float = f3;
        this.jdField_g_of_type_Boolean = true;
      }
      float f4 = Math.abs(this.jdField_a_of_type_Float - f1);
      float f5 = Math.abs(this.jdField_b_of_type_Float - f2);
      float f6 = Math.abs(this.jdField_c_of_type_Float - f3);
      if (((f4 <= 0.5D) && (f5 <= 0.5D) && (f6 <= 0.5D)) || (!this.jdField_h_of_type_Boolean)) {}
    }
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
    if ((this.jdField_i_of_type_Boolean) && (b()))
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
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_c_of_type_Boolean) {
      ThreadManager.post(new ScannerView.5(this), 8, null, true);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    ViewFinderView localViewFinderView = this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView;
    if (localViewFinderView != null) {
      localViewFinderView.b();
    }
    ThreadManager.post(new ScannerView.7(this), 8, null, false);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread == null)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread = new ScannerView.DecodeThread(this, "ScannerDecodeThread");
          this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.start();
          this.jdField_a_of_type_AndroidOsHandler = new ScannerView.DecodeHandler(this, this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.getLooper());
        }
      }
      finally {}
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsScannerView$DecodeThread.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock()) {
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
    Object localObject = this.jdField_a_of_type_AndroidViewSurfaceView;
    int i1 = paramInt3 - paramInt1;
    paramInt4 -= paramInt2;
    ((SurfaceView)localObject).layout(0, 0, i1, paramInt4);
    localObject = this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView;
    if (localObject != null)
    {
      ((ViewFinderView)localObject).layout(0, 0, i1, paramInt4);
      paramInt3 = this.m;
      if (paramInt3 == -1)
      {
        paramInt1 = this.j;
        paramInt2 = i1 - this.k;
      }
      else
      {
        paramInt1 = this.o;
        if ((paramInt1 & 0x3) == 3) {}
        for (paramInt1 = this.j;; paramInt1 = i1 - paramInt3 >> 1)
        {
          paramInt2 = paramInt1 + paramInt3;
          break;
          if ((paramInt1 & 0x5) == 5)
          {
            paramInt2 = i1 - this.k;
            paramInt1 = paramInt2 - paramInt3;
            break;
          }
        }
      }
      i1 = this.n;
      if (i1 == -1)
      {
        paramInt3 = this.jdField_i_of_type_Int;
        paramInt4 -= this.l;
      }
      else
      {
        paramInt3 = this.o;
        if ((paramInt3 & 0x30) == 48) {}
        for (paramInt3 = this.jdField_i_of_type_Int;; paramInt3 = paramInt4 - i1 >> 1)
        {
          paramInt4 = paramInt3 + i1;
          break;
          if ((paramInt3 & 0x50) == 80)
          {
            paramInt4 -= this.l;
            paramInt3 = paramInt4 - i1;
            break;
          }
        }
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.jdField_c_of_type_AndroidGraphicsRect == null) {
        this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
      }
      this.jdField_c_of_type_AndroidGraphicsRect.set(paramInt1, paramInt3, paramInt2, paramInt4);
      this.jdField_a_of_type_AndroidGraphicsRect = this.jdField_c_of_type_AndroidGraphicsRect;
      this.jdField_c_of_type_AndroidGraphicsRect = ((Rect)localObject);
      this.jdField_b_of_type_AndroidGraphicsRect = null;
      this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView.a(paramInt1, paramInt3, paramInt2, paramInt4);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    paramCamera = this.jdField_a_of_type_AndroidOsHandler;
    if (paramCamera != null) {
      paramCamera.obtainMessage(5, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramArrayOfByte).sendToTarget();
    }
  }
  
  public void setFileDecodeListener(ScannerView.FileDecodeListener paramFileDecodeListener)
  {
    e();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener = paramFileDecodeListener;
  }
  
  public void setFlashLightListener(ScannerView.FlashLightListener paramFlashLightListener)
  {
    e();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FlashLightListener = paramFlashLightListener;
  }
  
  public void setScanListener(ScannerView.ScannerListener paramScannerListener)
  {
    e();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$ScannerListener = paramScannerListener;
  }
  
  public void setViewFinder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e();
    this.o = 51;
    this.j = paramInt1;
    this.jdField_i_of_type_Int = paramInt2;
    this.m = (paramInt3 - paramInt1);
    this.n = (paramInt4 - paramInt2);
    this.k = 0;
    this.l = 0;
    if (this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView == null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView = new ViewFinderView(getContext());
      addView(this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_ComTencentBizWidgetsViewFinderView.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_f_of_type_Int = paramInt3;
    if (this.jdField_b_of_type_Boolean)
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        ThreadManager.post(new ScannerView.2(this), 8, null, true);
        return;
      }
      ThreadManager.post(new ScannerView.3(this), 8, null, true);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_c_of_type_Boolean = false;
    ThreadManager.post(new ScannerView.4(this), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView
 * JD-Core Version:    0.7.0.1
 */