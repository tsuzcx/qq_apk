package com.tencent.mobileqq.ar.ARRenderModel;

import aafp;
import aafr;
import aafs;
import aaft;
import aafu;
import aafv;
import aafw;
import aafz;
import aagd;
import aage;
import aagf;
import aagh;
import aagj;
import aagk;
import aagl;
import aagm;
import aagn;
import aago;
import aagp;
import aagq;
import aagr;
import aags;
import aagt;
import aagu;
import aagv;
import aagw;
import aagx;
import aagy;
import aagz;
import aaha;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARNativeBridge.ARWorldCupCallback;
import com.tencent.mobileqq.ar.ARRecord.worldcup.ARWorldCupStateListener;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.arcard.ARcardSound;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;
import com.tencent.mobileqq.armap.sensor.rotation.Vector3;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager.RenderProxy;
import com.tencent.mobileqq.worldcup.ARWorldCupGameTouchView;
import com.tencent.mobileqq.worldcup.ARWorldCupGameUtil;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper.OnPlayMediaStatusListener;
import com.tencent.mobileqq.worldcup.ARWorldCupVideoInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARWorldCupGlobalSceneRenderable
  implements Handler.Callback, View.OnTouchListener, ARNativeBridge.ARWorldCupCallback, ARBaseRender, ARWorldCupGameLogicManager.RenderProxy, ARWorldCupMediaPlayerWrapper.OnPlayMediaStatusListener
{
  public volatile int a;
  volatile long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  volatile PointF jdField_a_of_type_AndroidGraphicsPointF = null;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private ARWorldCupStateListener jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupARWorldCupStateListener;
  private ARRenderMangerInnerCallback jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback;
  private ARWorldCupResourceInfo jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo;
  private ARcardSound jdField_a_of_type_ComTencentMobileqqArcardARcardSound;
  private ARSensorManager jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager;
  private SimpleSensorChangeListener jdField_a_of_type_ComTencentMobileqqArmapSensorSimpleSensorChangeListener = new aafp(this);
  private ARWorldCupGameTouchView jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView;
  private ARWorldCupMediaPlayerWrapper jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper = new ARWorldCupMediaPlayerWrapper(this, 1);
  public MqqWeakReferenceHandler a;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new aagh(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public volatile boolean a;
  volatile double[] jdField_a_of_type_ArrayOfDouble = null;
  public volatile int b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  volatile int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  public volatile int d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private volatile boolean e;
  private int f;
  private volatile int g;
  private volatile int h;
  private int i;
  private int j;
  private volatile int k;
  
  public ARWorldCupGlobalSceneRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, ARWorldCupResourceInfo paramARWorldCupResourceInfo)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback = paramARRenderMangerInnerCallback;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo = paramARWorldCupResourceInfo;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a();
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = ((ARNativeBridge)paramARRenderMangerInnerCallback.a(0));
    boolean bool = SensorTrackManager.a();
    paramARRenderMangerInnerCallback = this.jdField_a_of_type_AndroidContentContext;
    if (bool) {}
    for (int m = 5;; m = 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorARSensorManager = new ARSensorManager(paramARRenderMangerInnerCallback, m);
      this.g = 1;
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
      return;
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARWorldCupGlobalSceneRenderable", 2, String.format("setNativeState mCurrentState=%s state=%s", new Object[] { Integer.valueOf(this.g), Integer.valueOf(paramInt) }));
    }
    this.g = paramInt;
    switch (this.g)
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
        this.f = this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.getIndentification();
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeCreateEngineBusiness(this.f, "test.scene", this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getAssets(), this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.a(), this.i, this.j, 88);
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.native_setARWorldCupCallBack(this);
        a(3);
        return;
        this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeResume(this.f);
        a(5);
        this.h = 0;
        return;
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(new aafu(this));
      } while (!QLog.isColorLevel());
      QLog.d("ARWorldCupGlobalSceneRenderable", 2, "enter STATE_ENGINE_DRAW status");
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativePause(this.f);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeDestroyCertainEngine(this.f);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.setupActionCallback(null);
    this.f = 0;
    this.g = 1;
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "tryPlayGameVideoAndSwitchStatus  " + paramInt + "|" + paramString);
    if (new File(paramString).exists())
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper.a(paramString, 123456L, paramBoolean);
    }
  }
  
  private void a(long paramLong)
  {
    if (paramLong < 0L) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = ARWorldCupGameLogicManager.a().a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.a() + "/res/worldcup/");
      } while (localObject == null);
      localObject = ((ARWorldCupVideoInfo)localObject).a(paramLong);
    } while (localObject == null);
    b(new aagq(this, (Vector3)localObject));
  }
  
  private void a(PointF paramPointF, int paramInt)
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, String.format("tryPlayFootballGame width=%d", new Object[] { Integer.valueOf(paramInt) }));
    if ((this.jdField_b_of_type_Int != 8) || (this.jdField_d_of_type_Int != -1)) {}
    label40:
    int m;
    int n;
    float f1;
    float f2;
    float f3;
    do
    {
      do
      {
        break label40;
        do
        {
          return;
        } while ((this.jdField_a_of_type_AndroidGraphicsPointF == null) || (paramPointF == null) || (paramInt <= 0));
        m = paramInt / 3;
        n = paramInt / 4;
        f1 = paramPointF.x - this.jdField_a_of_type_AndroidGraphicsPointF.x;
        f2 = paramPointF.y - this.jdField_a_of_type_AndroidGraphicsPointF.y;
      } while (Math.sqrt(Math.pow(f1, 2.0D) + Math.pow(f2, 2.0D)) <= m);
      f3 = paramPointF.x;
    } while ((f3 < 0.0F) || (f3 > paramInt) || (f2 > 0.0F));
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper.c();
    if (f()) {
      if (f1 < n * -1) {
        m = 1;
      }
    }
    for (;;)
    {
      QLog.d("ARWorldCupGlobalSceneRenderable", 2, String.format("tryPlayFootballGame pX=%f  width=%d", new Object[] { Float.valueOf(f3), Integer.valueOf(paramInt) }));
      if (m <= -1) {
        break;
      }
      this.jdField_d_of_type_Int = m;
      return;
      if (f1 > n)
      {
        m = 2;
      }
      else
      {
        m = 0;
        continue;
        m = 0;
      }
    }
  }
  
  private void a(float[] arg1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      while (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        paramArrayOfFloat3 = (Runnable)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (paramArrayOfFloat3 != null)
        {
          long l1 = System.currentTimeMillis();
          paramArrayOfFloat3.run();
          long l2 = System.currentTimeMillis();
          if (l2 - l1 >= 200L) {
            QLog.d("ARWorldCupGlobalSceneRenderable", 1, "event queue cost too long: " + (l2 - l1));
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.nativeOnDrawFrame(this.f, paramArrayOfFloat2, paramArrayOfFloat4);
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_e_of_type_Boolean)
    {
      int m = this.k + 1;
      this.k = m;
      if (m >= 1)
      {
        ThreadManager.getSubThreadHandler().post(new aaft(this));
        this.jdField_e_of_type_Boolean = false;
      }
    }
  }
  
  private void b(long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    b(new aagr(this, paramLong));
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
  
  private boolean e()
  {
    return false;
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return false;
    }
    try
    {
      boolean bool = WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(3);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupGlobalSceneRenderable", 2, "checkGameExtendResourceReady has exception.", localException);
    }
    return false;
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = null;
    if (this.jdField_d_of_type_Int > -1)
    {
      ThreadManager.getUIHandler().post(new aage(this));
      a(9);
    }
  }
  
  private void l()
  {
    ThreadManager.getFileThreadHandler().post(new aagf(this));
  }
  
  private void m()
  {
    int m = 2;
    d();
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "playGameChoiceVideo." + this.jdField_b_of_type_Int + "|" + this.jdField_d_of_type_Int);
    if (this.jdField_b_of_type_Int != 9) {
      return;
    }
    int n = this.jdField_d_of_type_Int;
    Object localObject;
    switch (n)
    {
    default: 
      m = 0;
      localObject = null;
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = -1;
      if (localObject == null) {
        break;
      }
      o();
      ThreadManager.getUIHandler().post(new aagj(this));
      ReportController.b(null, "dc00898", "", "", "0X8009316", "0X8009316", m, 0, Integer.toString(m), "", "", "");
      a(10, (String)localObject, false);
      localObject = ARWorldCupGameLogicManager.a().a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.a() + "/res/worldcup/");
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_ArrayOfDouble = ((ARWorldCupVideoInfo)localObject).a(n);
      if (this.jdField_a_of_type_ArrayOfDouble == null) {
        break;
      }
      this.jdField_c_of_type_Int = -1;
      n();
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.a() + "/res/worldcup/ball01_batch.mp4";
      m = 1;
      continue;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.b() + "/res/worldcup/ball02_batch.mp4";
      continue;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.b() + "/res/worldcup/ball03_batch.mp4";
      m = 3;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null)
    {
      this.jdField_c_of_type_Boolean = false;
      if (!this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1105)) {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1105, 100L);
      }
    }
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "startMediaTimeListener ");
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1105);
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfDouble = null;
    this.jdField_c_of_type_Int = -1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_b_of_type_Int == paramInt) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARWorldCupGlobalSceneRenderable", 2, "switchGameStatus status " + paramInt);
    }
    b(new aafv(this, paramInt));
    return 0;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "init test start +" + this);
    this.jdField_a_of_type_Long = Thread.currentThread().getId();
    ARWorldCupGameLogicManager.a().a(this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "onMediaPlayerStatusChange mCurrentPrePareChangeStatus " + this.jdField_a_of_type_Int + "|" + paramInt1 + "|" + this.jdField_b_of_type_Int);
    b(new aafw(this, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(AppInterface paramAppInterface, ScanTorchActivity paramScanTorchActivity)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_b_of_type_JavaLangString = paramScanTorchActivity.e();
    this.jdField_a_of_type_JavaLangString = paramScanTorchActivity.getCurrentAccountUin();
    this.jdField_d_of_type_JavaLangString = paramScanTorchActivity.f();
    this.jdField_c_of_type_JavaLangString = paramScanTorchActivity.g();
  }
  
  public void a(ARWorldCupStateListener paramARWorldCupStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupARWorldCupStateListener = paramARWorldCupStateListener;
  }
  
  public void a(ARRenerArumentManager.DrawFrameParements paramDrawFrameParements)
  {
    a((float[])paramDrawFrameParements.a("TARGET_SIZE"), (float[])paramDrawFrameParements.a("POSE"), (float[])paramDrawFrameParements.a("CAMERA_MATRIX"), (float[])paramDrawFrameParements.a("CAMERA_POSITION"));
  }
  
  public void a(ARWorldCupGameTouchView paramARWorldCupGameTouchView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView = paramARWorldCupGameTouchView;
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.setOnTouchListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.setGameMainResourcePath(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.a());
        this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.setGameExtendResourcePath(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.b());
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(paramRunnable);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupARWorldCupStateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupARWorldCupStateListener.a(1, null);
    }
    b(new aagk(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    b(new aagl(this, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3));
  }
  
  public boolean a()
  {
    return (this.g == 6) && (this.f != 0);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!e()) {
      return false;
    }
    int n = paramMotionEvent.getPointerCount();
    int[] arrayOfInt = new int[n];
    float[] arrayOfFloat1 = new float[n];
    float[] arrayOfFloat2 = new float[n];
    int m = 0;
    while (m < n)
    {
      arrayOfInt[m] = paramMotionEvent.getPointerId(m);
      arrayOfFloat1[m] = paramMotionEvent.getX(m);
      arrayOfFloat2[m] = paramMotionEvent.getY(m);
      m += 1;
    }
    long l = System.currentTimeMillis();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 4: 
    default: 
      return false;
    case 0: 
      b(new aagy(this, paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0], l));
      return false;
    case 5: 
      m = paramMotionEvent.getAction() >> 8;
      b(new aagx(this, paramMotionEvent.getPointerId(m), paramMotionEvent.getX(m), paramMotionEvent.getY(m), l));
      return false;
    case 2: 
      b(new aagz(this, arrayOfInt, arrayOfFloat1, arrayOfFloat2, l));
      return false;
    case 6: 
      m = paramMotionEvent.getAction() >> 8;
      b(new aaha(this, paramMotionEvent.getPointerId(m), paramMotionEvent.getX(m), paramMotionEvent.getY(m), l));
      return false;
    case 1: 
      b(new aafr(this, paramMotionEvent.getPointerId(0), arrayOfFloat1[0], arrayOfFloat2[0], l));
      return false;
    }
    b(new aafs(this, arrayOfInt, arrayOfFloat1, arrayOfFloat2, l));
    return false;
  }
  
  public void a_(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupResourceInfo.a() + "/res/worldcup/";
  }
  
  public void b()
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "start from this cluase second");
    if (1 == this.g) {
      a(2);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    if (this.g != 6) {
      return 0;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    if (this.g == 5)
    {
      int m = this.h + 1;
      this.h = m;
      if (m >= 2) {
        a(6);
      }
    }
  }
  
  public boolean c()
  {
    return (this.g == 6) && (this.f != 0);
  }
  
  public void d()
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, String.format("onDestroy mCurrentState=%s mCallDestroyFromPause=%s", new Object[] { Integer.valueOf(this.g), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    ThreadManager.getSubThreadHandler().post(new aagv(this));
    aagw localaagw = new aagw(this);
    if (this.jdField_a_of_type_Long == Thread.currentThread().getId())
    {
      localaagw.run();
      QLog.e("ARWorldCupGlobalSceneRenderable", 1, "onDestroy in GLThread.");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderMangerInnerCallback.a(localaagw);
    }
    QLog.e("ARWorldCupGlobalSceneRenderable", 1, "onDestroy not in GLThread.");
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void e()
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "startCameraAniamtion ");
    b(new aagd(this));
  }
  
  public void f()
  {
    b(new aagm(this));
  }
  
  public void g()
  {
    b(new aagn(this));
  }
  
  public void h()
  {
    o();
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupARWorldCupStateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupARWorldCupStateListener.a(15, null);
    }
    if (ARWorldCupGameLogicManager.a().a != null) {
      ARWorldCupGameLogicManager.a().a.a(15);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    long l;
    if ((this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper.a()))
    {
      if (this.jdField_b_of_type_Int != 4) {
        break label156;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper.a();
      b(l);
      if (!this.jdField_a_of_type_Boolean)
      {
        if (l > 4700L)
        {
          a(l);
          if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupARWorldCupStateListener != null) && (!this.jdField_c_of_type_Boolean))
          {
            this.jdField_c_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupARWorldCupStateListener.a(102, null);
            QLog.i("ARWorldCupGlobalSceneRenderable", 1, "onStateChanged GAME_NOTIFY_LOOP_END.");
          }
        }
        ThreadManager.getUIHandler().post(new aags(this, l));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1105, 100L);
      return false;
      label156:
      if (this.jdField_b_of_type_Int == 10)
      {
        if (this.jdField_a_of_type_ArrayOfDouble != null)
        {
          int m = 0;
          label174:
          if (m < this.jdField_a_of_type_ArrayOfDouble.length) {
            if (m >= this.jdField_c_of_type_Int) {
              break label198;
            }
          }
          label198:
          while (Math.abs(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper.a() - (this.jdField_a_of_type_ArrayOfDouble[m] * 1000.0D)) >= 100L)
          {
            m += 1;
            break label174;
            break;
          }
          this.jdField_c_of_type_Int = m;
          ARWorldCupGameUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        }
      }
      else if (this.jdField_b_of_type_Int == 6)
      {
        l = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper.a();
        ThreadManager.getUIHandler().post(new aagt(this, l));
      }
      else if (this.jdField_b_of_type_Int == 8)
      {
        QLog.i("ARWorldCupGlobalSceneRenderable", 1, "OnVideoPlayTick VIDEO_360_PLAY_MSG. mGameChoice=" + this.jdField_d_of_type_Int);
        if (this.jdField_d_of_type_Int == -1)
        {
          l = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper.a();
          ThreadManager.getUIHandler().post(new aagu(this, l));
        }
      }
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Boolean = false;
    b(new aago(this));
  }
  
  public void j()
  {
    b(new aagp(this));
  }
  
  public void nativeCallBack(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "nativeCallBack  " + paramInt1 + "|" + paramInt2);
    b(new aafz(this, paramInt1));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, String.format("onTouch mNativeGameStatus=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    if ((this.jdField_b_of_type_Int != 8) || (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView == null)) {
      return false;
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameTouchView.getWidth();
    paramView = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_AndroidGraphicsPointF = paramView;
      return false;
    case 2: 
      a(paramView, m);
      return false;
    }
    a(paramView, m);
    k();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable
 * JD-Core Version:    0.7.0.1
 */