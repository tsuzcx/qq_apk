package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ARWorldCupCallback;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.OnPlayMediaStatusListener;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo.FragmentInfo;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.RenderProxy;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorVideoInfo;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorVideoInfo.PlayGuideShowInfo;
import com.tencent.mobileqq.ar.arcore.IARCoreBridge;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable
  implements Handler.Callback, View.OnTouchListener, ARNativeBridge.ARWorldCupCallback, ARPromotionMediaPlayerWrapper.OnPlayMediaStatusListener, ARTransferDoorLogicManager.RenderProxy, ARBaseRender
{
  volatile int jdField_a_of_type_Int = 0;
  volatile long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private ARPromotionMediaPlayerWrapper jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper = new ARPromotionMediaPlayerWrapper(this, 1);
  private ARPromotionSoundPlayer jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionSoundPlayer;
  private ARTransferDoorConfigInfo.FragmentInfo jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo$FragmentInfo;
  private ARTransferDoorLogicManager jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
  private ARTransferDoorVideoInfo jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorVideoInfo;
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  private ARTransferResourceInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo;
  private IARCoreBridge jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge = null;
  private ARSensorManager jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager;
  private SimpleSensorChangeListener jdField_a_of_type_ComTencentMobileqqArmapSensorSimpleSensorChangeListener = new ARTransferPromotionRenderable.2(this);
  private ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ARTransferPromotionRenderable.1(this);
  private ArrayList<Runnable> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  volatile int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private volatile int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private volatile int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private int h = -1;
  private int i;
  private volatile int j = 0;
  private int k = 0;
  
  public ARTransferPromotionRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, ARTransferResourceInfo paramARTransferResourceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo = paramARTransferResourceInfo;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)paramARRenderMangerInnerCallback.a(0));
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager = ((ARTransferDoorLogicManager)paramARRenderMangerInnerCallback.a(8));
    boolean bool = SensorTrackManager.a();
    if (this.jdField_a_of_type_Boolean)
    {
      paramARRenderMangerInnerCallback = this.jdField_a_of_type_AndroidContentContext;
      if (!bool) {
        break label309;
      }
    }
    label309:
    for (int m = 5;; m = 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager = new ARSensorManager(paramARRenderMangerInnerCallback, m);
      this.jdField_d_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_c_of_type_Boolean = SensorTrackManager.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 108);
      paramARRenderMangerInnerCallback = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.a();
      if (!TextUtils.isEmpty(paramARRenderMangerInnerCallback))
      {
        paramARRenderMangerInnerCallback = SuperPlayerFactory.createVideoInfoForUrl(paramARRenderMangerInnerCallback, 101, MD5Utils.toMD5(paramARRenderMangerInnerCallback));
        this.h = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload(paramARRenderMangerInnerCallback, 3000L, 1000L);
      }
      ThreadManager.post(new ARTransferPromotionRenderable.3(this), 8, null, true);
      return;
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState mCurrentState=%s state=%s", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(paramInt) }));
    }
    this.jdField_d_of_type_Int = paramInt;
    switch (this.jdField_d_of_type_Int)
    {
    case 5: 
    default: 
    case 2: 
    case 3: 
    case 6: 
      do
      {
        return;
        ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngineBusiness(this.jdField_c_of_type_Int, "test.scene", this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getAssets(), this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.jdField_b_of_type_JavaLangString, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, 88);
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupCallBack(this);
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setPreLoadTransferDoorFlags();
        if (this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setARCoreSupport(1);
        }
        for (;;)
        {
          a(3);
          return;
          this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setARCoreSupport(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.jdField_c_of_type_Int);
        a(5);
        this.jdField_e_of_type_Int = 0;
        return;
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new ARTransferPromotionRenderable.11(this));
      } while (!QLog.isColorLevel());
      QLog.d("ARTransferPromotionRenderable", 2, "enter STATE_ENGINE_DRAW status");
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.jdField_c_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 1;
  }
  
  private void a(int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int n = 1;
    QLog.d("ARTransferPromotionRenderable", 1, "tryPlayGameVideoAndSwitchStatus  " + paramInt1 + "|" + paramString);
    File localFile = new File(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      m = n;
      if (!paramString.startsWith("http")) {
        if (!paramString.startsWith("https")) {
          break label119;
        }
      }
    }
    label119:
    for (int m = n;; m = 0)
    {
      if ((localFile.exists()) || (m != 0))
      {
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper.a(paramString, 123456L, paramBoolean1, paramInt2, paramBoolean2);
      }
      return;
    }
  }
  
  private void a(float[] arg1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (paramArrayOfFloat5 != null) && (this.jdField_b_of_type_Int < 6))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge != null) {
        break label157;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupQuaternion(paramArrayOfFloat5[0], paramArrayOfFloat5[1], paramArrayOfFloat5[2], paramArrayOfFloat5[3]);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break;
        }
        paramArrayOfFloat3 = (Runnable)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (paramArrayOfFloat3 == null) {
          continue;
        }
        long l1 = System.currentTimeMillis();
        paramArrayOfFloat3.run();
        long l2 = System.currentTimeMillis();
        if (l2 - l1 < 200L) {
          continue;
        }
        QLog.d("ARTransferPromotionRenderable", 1, "event queue cost too long: " + (l2 - l1));
      }
      label157:
      a(paramArrayOfFloat5);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.jdField_c_of_type_Int, paramArrayOfFloat2, paramArrayOfFloat4);
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_e_of_type_Boolean)
    {
      int m = this.j + 1;
      this.j = m;
      if (m >= 1)
      {
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.9(this));
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.b(true);
        ??? = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.getClass();
        ???.c(6);
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.10(this));
        this.jdField_e_of_type_Boolean = false;
      }
    }
  }
  
  private boolean a(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge == null) {}
    while ((!this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge.a()) || (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a() == null)) {
      return false;
    }
    paramArrayOfFloat = new float[4];
    float[] arrayOfFloat = new float[3];
    int m = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a();
    FloatBuffer localFloatBuffer = this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge.a(m, paramArrayOfFloat, arrayOfFloat);
    if ((m == -1) || (localFloatBuffer == null))
    {
      a(-1.0F, -1.0F, -1.0F);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(m);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a().a(localFloatBuffer, this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge.a());
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupQuaternion(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
    if ((this.jdField_b_of_type_Int <= 5) && (this.jdField_b_of_type_Int >= 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.updateCameraTranslate(arrayOfFloat, paramArrayOfFloat);
      a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
    }
    return true;
  }
  
  private void b(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
      return;
    }
  }
  
  private int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge != null) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_getNativeGameStatus();
    }
    return this.jdField_b_of_type_Int;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge != null)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "tryCreatARCore ");
      b(new ARTransferPromotionRenderable.15(this));
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge != null)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "checkAndStartARCore ");
      CameraProxy.a().e();
      this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge.a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge.c();
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) && (!this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1105))) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1105, 200L);
    }
    QLog.d("ARTransferPromotionRenderable", 2, "startMediaTimeListener ");
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1105);
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(false, "");
    }
    QLog.d("ARTransferPromotionRenderable", 2, "stopMediaTimeListener ");
  }
  
  public int a()
  {
    if (this.jdField_d_of_type_Int != 6) {
      return 0;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_b_of_type_Int == paramInt) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus status " + paramInt);
    }
    b(new ARTransferPromotionRenderable.13(this, paramInt));
    return 0;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, "directlyEnterTransferDoor");
    }
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.f();
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(false, "");
    ReportController.b(null, "CliOper", "", "", "0X80098C8", "0X80098C8", 0, 0, this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.jdField_a_of_type_JavaLangString, "0", "0", "");
    b(new ARTransferPromotionRenderable.12(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqArArcoreIARCoreBridge != null) {
      b(new ARTransferPromotionRenderable.8(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange mCurrentPrePareChangeStatus " + this.jdField_a_of_type_Int + "|" + paramInt1 + "|" + this.jdField_b_of_type_Int + "|status" + paramInt2);
    b(new ARTransferPromotionRenderable.14(this, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b(new ARTransferPromotionRenderable.19(this, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.setOnTouchListener(this);
      QLog.d("ARTransferPromotionRenderable", 2, "setContainer  success");
    }
  }
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"), paramDrawFrameParements.a);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(paramRunnable);
    }
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    b(new ARTransferPromotionRenderable.20(this, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3));
  }
  
  public boolean a()
  {
    return (this.jdField_d_of_type_Int == 6) && (this.jdField_c_of_type_Int != 0);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.c;
  }
  
  public void b()
  {
    b(new ARTransferPromotionRenderable.21(this));
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.jdField_b_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void c()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "init test start +" + this);
    this.jdField_a_of_type_Long = Thread.currentThread().getId();
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.e();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager != null) && (this.jdField_a_of_type_Boolean)) {
      QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState start sensor result=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager.a(this.jdField_a_of_type_ComTencentMobileqqArmapSensorSimpleSensorChangeListener)) }));
    }
  }
  
  public boolean c()
  {
    return !this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARTransferResourceInfo.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public void d()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "start from this cluase second");
    if (1 == this.jdField_d_of_type_Int) {
      a(2);
    }
  }
  
  public boolean d()
  {
    return (this.jdField_d_of_type_Int == 6) && (this.jdField_c_of_type_Int != 0);
  }
  
  public void e()
  {
    if (this.jdField_d_of_type_Int == 5)
    {
      int m = this.jdField_e_of_type_Int + 1;
      this.jdField_e_of_type_Int = m;
      if (m >= 2) {
        a(6);
      }
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    QLog.d("ARTransferPromotionRenderable", 2, String.format("onDestroy mCurrentState=%s mCallDestroyFromPause=%s", new Object[] { Integer.valueOf(this.jdField_d_of_type_Int), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.6(this));
    ARTransferPromotionRenderable.7 local7 = new ARTransferPromotionRenderable.7(this);
    if (this.jdField_a_of_type_Long == Thread.currentThread().getId())
    {
      local7.run();
      QLog.e("ARTransferPromotionRenderable", 1, "onDestroy in GLThread.");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(local7);
    }
    QLog.e("ARTransferPromotionRenderable", 1, "onDestroy not in GLThread.");
  }
  
  public void g()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "startCameraAniamtion ");
    b(new ARTransferPromotionRenderable.18(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper.a()) && (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorVideoInfo != null))
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPromotionMediaPlayerWrapper.a();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorVideoInfo.a(l);
      if (paramMessage != null) {
        break label98;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(false, "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1105, 200L);
      return false;
      label98:
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(true, paramMessage.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void nativeCallBack(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ARTransferPromotionRenderable", 1, "nativeCallBack  " + paramInt1 + "|" + paramInt2);
    b(new ARTransferPromotionRenderable.16(this, paramInt1));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.d("ARTransferPromotionRenderable", 2, String.format("onTouch mNativeGameStatus=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    paramView.getWidth();
    new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    case 2: 
    default: 
      return false;
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      g();
      paramView.setVisibility(8);
      QLog.d("ARTransferPromotionRenderable", 2, "start cameraAnimation here");
      return false;
    }
    if (this.jdField_b_of_type_Int == 4)
    {
      if (this.jdField_g_of_type_Boolean)
      {
        QLog.d("ARTransferPromotionRenderable", 2, "onTouch event not deal ready");
        return false;
      }
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) && (this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new ARTransferPromotionRenderable.17(this, paramView));
      }
      QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER click operation");
      return false;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "onTouch doNothing");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable
 * JD-Core Version:    0.7.0.1
 */