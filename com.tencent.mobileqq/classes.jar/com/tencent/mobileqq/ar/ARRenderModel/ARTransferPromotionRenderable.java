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
  private int A = -1;
  private SimpleSensorChangeListener B = new ARTransferPromotionRenderable.2(this);
  private int C;
  private IARCoreBridge D = null;
  private TextView E;
  private volatile boolean F = false;
  private volatile int G = 0;
  private boolean H = false;
  private int I = 0;
  private boolean J = false;
  volatile int a = 0;
  volatile int b = 0;
  MqqWeakReferenceHandler c;
  volatile long d = -1L;
  private Context e;
  private ARRenderMangerInnerCallback f;
  private ARTransferResourceInfo g;
  private ARNativeBridge h;
  private int i;
  private boolean j = false;
  private ARSensorManager k;
  private volatile int l;
  private volatile int m;
  private int n;
  private int o;
  private boolean p;
  private boolean q = true;
  private volatile boolean r = false;
  private ARTransferDoorVideoInfo s;
  private ARTransferDoorConfigInfo.FragmentInfo t;
  private ARPromotionSoundPlayer u;
  private ARPromotionMediaPlayerWrapper v = new ARPromotionMediaPlayerWrapper(this, 1);
  private ArrayList<Runnable> w = new ArrayList();
  private final Runnable x = new ARTransferPromotionRenderable.1(this);
  private ARTransferDoorLogicManager y;
  private ISPlayerPreDownloader z;
  
  public ARTransferPromotionRenderable(ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, ARTransferResourceInfo paramARTransferResourceInfo)
  {
    this.f = paramARRenderMangerInnerCallback;
    this.g = paramARTransferResourceInfo;
    this.e = this.f.a();
    this.h = ((ARNativeBridge)paramARRenderMangerInnerCallback.a(0));
    this.y = ((ARTransferDoorLogicManager)paramARRenderMangerInnerCallback.a(8));
    boolean bool = SensorTrackManager.a();
    if (this.j)
    {
      paramARRenderMangerInnerCallback = this.e;
      int i1;
      if (bool) {
        i1 = 5;
      } else {
        i1 = 4;
      }
      this.k = new ARSensorManager(paramARRenderMangerInnerCallback, i1);
    }
    this.l = 1;
    this.c = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.q = SensorTrackManager.b;
    this.z = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 108);
    paramARRenderMangerInnerCallback = this.g.b();
    if (!TextUtils.isEmpty(paramARRenderMangerInnerCallback))
    {
      paramARRenderMangerInnerCallback = SuperPlayerFactory.createVideoInfoForUrl(paramARRenderMangerInnerCallback, 101, MD5Utils.toMD5(paramARRenderMangerInnerCallback));
      this.A = this.z.startPreDownload(paramARRenderMangerInnerCallback, 3000L, 1000L);
    }
    ThreadManager.post(new ARTransferPromotionRenderable.3(this), 8, null, true);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  private void a(int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tryPlayGameVideoAndSwitchStatus  ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    int i2 = 1;
    QLog.d("ARTransferPromotionRenderable", 1, (String)localObject);
    localObject = new File(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      i1 = i2;
      if (paramString.startsWith("http")) {
        break label111;
      }
      if (paramString.startsWith("https"))
      {
        i1 = i2;
        break label111;
      }
    }
    int i1 = 0;
    label111:
    if ((((File)localObject).exists()) || (i1 != 0))
    {
      this.a = paramInt1;
      this.v.a(paramString, 123456L, paramBoolean1, paramInt2, paramBoolean2);
    }
  }
  
  private void a(float[] arg1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5)
  {
    if ((this.q) && (this.r) && (paramArrayOfFloat5 != null) && (this.b < 6)) {
      if (this.D == null) {
        this.h.native_setARWorldCupQuaternion(paramArrayOfFloat5[0], paramArrayOfFloat5[1], paramArrayOfFloat5[2], paramArrayOfFloat5[3]);
      } else {
        a(paramArrayOfFloat5);
      }
    }
    synchronized (this.w)
    {
      while (!this.w.isEmpty())
      {
        paramArrayOfFloat3 = (Runnable)this.w.remove(0);
        if (paramArrayOfFloat3 != null)
        {
          long l1 = System.currentTimeMillis();
          paramArrayOfFloat3.run();
          l1 = System.currentTimeMillis() - l1;
          if (l1 >= 200L)
          {
            paramArrayOfFloat3 = new StringBuilder();
            paramArrayOfFloat3.append("event queue cost too long: ");
            paramArrayOfFloat3.append(l1);
            QLog.d("ARTransferPromotionRenderable", 1, paramArrayOfFloat3.toString());
          }
        }
      }
      this.h.nativeOnDrawFrame(this.i, paramArrayOfFloat2, paramArrayOfFloat4);
      this.r = true;
      if (this.F)
      {
        int i1 = this.G + 1;
        this.G = i1;
        if (i1 >= 1)
        {
          ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.9(this));
          this.y.b(true);
          ??? = this.y;
          ???.getClass();
          ???.c(6);
          ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.10(this));
          this.F = false;
        }
      }
      return;
    }
    for (;;)
    {
      throw paramArrayOfFloat2;
    }
  }
  
  private boolean a(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = this.D;
    if (paramArrayOfFloat == null) {
      return false;
    }
    if (!paramArrayOfFloat.b()) {
      return false;
    }
    if (this.f.d() == null) {
      return false;
    }
    paramArrayOfFloat = new float[4];
    float[] arrayOfFloat = new float[3];
    int i1 = this.f.d().i();
    FloatBuffer localFloatBuffer = this.D.a(i1, paramArrayOfFloat, arrayOfFloat);
    if ((i1 != -1) && (localFloatBuffer != null))
    {
      this.f.d().b(i1);
      this.f.d().a(localFloatBuffer, this.D.a());
      this.h.native_setARWorldCupQuaternion(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
      if ((this.b <= 5) && (this.b >= 3))
      {
        this.h.updateCameraTranslate(arrayOfFloat, paramArrayOfFloat);
        a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
      }
      return true;
    }
    a(-1.0F, -1.0F, -1.0F);
    return false;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState mCurrentState=%s state=%s", new Object[] { Integer.valueOf(this.l), Integer.valueOf(paramInt) }));
    }
    this.l = paramInt;
    switch (this.l)
    {
    default: 
    case 7: 
      this.h.nativeDestroyCertainEngine(this.i);
      this.h.setupActionCallback(null);
      this.i = 0;
      this.l = 1;
      return;
    case 6: 
      this.f.a(new ARTransferPromotionRenderable.11(this));
      if (QLog.isColorLevel())
      {
        QLog.d("ARTransferPromotionRenderable", 2, "enter STATE_ENGINE_DRAW status");
        return;
      }
      break;
    case 4: 
      this.h.nativePause(this.i);
      return;
    case 3: 
      this.h.nativeResume(this.i);
      b(5);
      this.m = 0;
      return;
    case 2: 
      ARGLSurfaceView.nativeSetLogLevel(QLog.getUIN_REPORTLOG_LEVEL());
      this.i = this.h.getIndentification();
      ARNativeBridge localARNativeBridge = this.h;
      long l1 = this.i;
      Context localContext = this.e;
      localARNativeBridge.nativeCreateEngineBusiness(l1, "test.scene", localContext, localContext.getAssets(), this.g.n, this.n, this.o, 88);
      this.h.native_setARWorldCupCallBack(this);
      this.h.setPreLoadTransferDoorFlags();
      if (this.D != null) {
        this.h.setARCoreSupport(1);
      } else {
        this.h.setARCoreSupport(0);
      }
      b(3);
    }
  }
  
  private void b(Runnable paramRunnable)
  {
    synchronized (this.w)
    {
      this.w.add(paramRunnable);
      return;
    }
  }
  
  private void s()
  {
    if (this.D != null)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "tryCreatARCore ");
      b(new ARTransferPromotionRenderable.15(this));
    }
  }
  
  private void t()
  {
    if (this.D != null)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "checkAndStartARCore ");
      CameraProxy.a().k();
      this.D.a(this.n, this.o);
      this.D.e();
    }
  }
  
  private int u()
  {
    ARNativeBridge localARNativeBridge = this.h;
    if (localARNativeBridge != null) {
      this.b = localARNativeBridge.native_getNativeGameStatus();
    }
    return this.b;
  }
  
  private void v()
  {
    MqqWeakReferenceHandler localMqqWeakReferenceHandler = this.c;
    if ((localMqqWeakReferenceHandler != null) && (!localMqqWeakReferenceHandler.hasMessages(1105))) {
      this.c.sendEmptyMessageDelayed(1105, 200L);
    }
    QLog.d("ARTransferPromotionRenderable", 2, "startMediaTimeListener ");
  }
  
  private void w()
  {
    MqqWeakReferenceHandler localMqqWeakReferenceHandler = this.c;
    if (localMqqWeakReferenceHandler != null)
    {
      localMqqWeakReferenceHandler.removeMessages(1105);
      this.y.a(false, "");
    }
    QLog.d("ARTransferPromotionRenderable", 2, "stopMediaTimeListener ");
  }
  
  public int a(int paramInt)
  {
    if (this.b == paramInt) {
      return 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchGameStatus status ");
      localStringBuilder.append(paramInt);
      QLog.d("ARTransferPromotionRenderable", 2, localStringBuilder.toString());
    }
    b(new ARTransferPromotionRenderable.13(this, paramInt));
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    if (this.D != null) {
      b(new ARTransferPromotionRenderable.8(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMediaPlayerStatusChange mCurrentPrePareChangeStatus ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|status");
    localStringBuilder.append(paramInt2);
    QLog.d("ARTransferPromotionRenderable", 1, localStringBuilder.toString());
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
    ARRenderMangerInnerCallback localARRenderMangerInnerCallback = this.f;
    if (localARRenderMangerInnerCallback != null) {
      localARRenderMangerInnerCallback.a(paramRunnable);
    }
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    b(new ARTransferPromotionRenderable.20(this, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3));
  }
  
  public boolean a()
  {
    return (this.l == 6) && (this.i != 0);
  }
  
  public boolean b()
  {
    return this.r;
  }
  
  public boolean c()
  {
    return this.g.i.booleanValue() ^ true;
  }
  
  public String d()
  {
    return this.g.a;
  }
  
  public String e()
  {
    return this.g.o;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTransferPromotionRenderable", 2, "directlyEnterTransferDoor");
    }
    this.y.h();
    this.y.a(false, "");
    ReportController.b(null, "CliOper", "", "", "0X80098C8", "0X80098C8", 0, 0, this.g.a, "0", "0", "");
    b(new ARTransferPromotionRenderable.12(this));
  }
  
  public int g()
  {
    if (this.l != 6) {
      return 0;
    }
    return this.b;
  }
  
  public void h()
  {
    b(new ARTransferPromotionRenderable.21(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1105) {
      return false;
    }
    paramMessage = this.v;
    if ((paramMessage != null) && (paramMessage.c()) && (this.s != null))
    {
      long l1 = this.v.e();
      paramMessage = this.s.a(l1);
      if (paramMessage == null) {
        this.y.a(false, "");
      } else {
        this.y.a(true, paramMessage.c);
      }
    }
    this.c.sendEmptyMessageDelayed(1105, 200L);
    return false;
  }
  
  public void i()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init test start +");
    ((StringBuilder)localObject).append(this);
    QLog.d("ARTransferPromotionRenderable", 2, ((StringBuilder)localObject).toString());
    this.d = Thread.currentThread().getId();
    this.y.a(this);
    if (!this.g.i.booleanValue()) {
      this.y.g();
    }
    localObject = this.k;
    if ((localObject != null) && (this.j)) {
      QLog.d("ARTransferPromotionRenderable", 2, String.format("setNativeState start sensor result=%s", new Object[] { Boolean.valueOf(((ARSensorManager)localObject).a(this.B)) }));
    }
  }
  
  public void j()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "start from this cluase second");
    if (1 == this.l) {
      b(2);
    }
  }
  
  public void k()
  {
    if (this.l == 5)
    {
      int i1 = this.m + 1;
      this.m = i1;
      if (i1 >= 2) {
        b(6);
      }
    }
  }
  
  public void l()
  {
    QLog.d("ARTransferPromotionRenderable", 2, String.format("onDestroy mCurrentState=%s mCallDestroyFromPause=%s", new Object[] { Integer.valueOf(this.l), Boolean.valueOf(this.p) }));
    Object localObject = this.c;
    if (localObject != null) {
      ((MqqWeakReferenceHandler)localObject).removeCallbacks(this.x);
    }
    ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.6(this));
    localObject = new ARTransferPromotionRenderable.7(this);
    if (this.d == Thread.currentThread().getId())
    {
      ((Runnable)localObject).run();
      QLog.e("ARTransferPromotionRenderable", 1, "onDestroy in GLThread.");
      return;
    }
    ARRenderMangerInnerCallback localARRenderMangerInnerCallback = this.f;
    if (localARRenderMangerInnerCallback != null) {
      localARRenderMangerInnerCallback.a((Runnable)localObject);
    }
    QLog.e("ARTransferPromotionRenderable", 1, "onDestroy not in GLThread.");
  }
  
  public int m()
  {
    return this.g.b;
  }
  
  public String n()
  {
    return this.g.a;
  }
  
  public void nativeCallBack(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nativeCallBack  ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    QLog.d("ARTransferPromotionRenderable", 1, localStringBuilder.toString());
    b(new ARTransferPromotionRenderable.16(this, paramInt1));
  }
  
  public boolean o()
  {
    return (this.l == 6) && (this.i != 0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.d("ARTransferPromotionRenderable", 2, String.format("onTouch mNativeGameStatus=%d", new Object[] { Integer.valueOf(this.b) }));
    paramView.getWidth();
    new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent.getAction() != 0) {
      return false;
    }
    if (this.b == 3)
    {
      r();
      paramView.setVisibility(8);
      QLog.d("ARTransferPromotionRenderable", 2, "start cameraAnimation here");
      return false;
    }
    if (this.b == 4)
    {
      if (this.J)
      {
        QLog.d("ARTransferPromotionRenderable", 2, "onTouch event not deal ready");
        return false;
      }
      this.J = true;
      paramMotionEvent = this.f;
      if ((paramMotionEvent != null) && (this.h != null)) {
        paramMotionEvent.a(new ARTransferPromotionRenderable.17(this, paramView));
      }
      QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER click operation");
      return false;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "onTouch doNothing");
    return false;
  }
  
  public boolean p()
  {
    return false;
  }
  
  public int q()
  {
    return this.g.d;
  }
  
  public void r()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "startCameraAniamtion ");
    b(new ARTransferPromotionRenderable.18(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable
 * JD-Core Version:    0.7.0.1
 */