package com.tencent.avgame.qav;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.av.CameraDataProcess;
import com.tencent.av.camera.CameraListener;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.effects.EffectCtrlBase;
import com.tencent.av.utils.FramePerfData;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.observer.IPCEventObserver;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.util.WeakReference;

public class AVGameCameraAssistant
  extends CameraDataProcess
  implements Handler.Callback, CameraListener
{
  private final AVGameBusinessCtrl d;
  private final ICameraManagerApi e;
  private final WeakReference<AVGameAppInterface> f;
  private AVGameEffectCtrl g = null;
  private final WeakReferenceHandler h;
  private int i = 0;
  private long j = 0L;
  private IPCEventObserver k = null;
  private AVGameCameraAssistant.ClearCacheTask l = null;
  private final ConcurrentLinkedQueue<AVGameCameraAssistant.CameraEventListener> m = new ConcurrentLinkedQueue();
  private CameraObserver n = new AVGameCameraAssistant.4(this);
  
  public AVGameCameraAssistant(AVGameBusinessCtrl paramAVGameBusinessCtrl, AVGameAppInterface paramAVGameAppInterface)
  {
    this.f = new WeakReference(paramAVGameAppInterface);
    this.d = paramAVGameBusinessCtrl;
    this.e = CameraUtils.a(BaseApplicationImpl.getContext());
    this.e.setCameraListener(this);
    this.h = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.e.addObserver(this.n);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearEffectCtrl, exit[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameCameraAssistant", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g;
    if (localObject != null)
    {
      ((AVGameEffectCtrl)localObject).a();
      this.g.a(paramBoolean);
      this.g = null;
    }
    a(null);
  }
  
  private void g()
  {
    if (this.k != null)
    {
      ObserverCenter.a().b(this.k);
      this.k = null;
    }
  }
  
  private void h()
  {
    if (this.g == null) {
      try
      {
        if (this.g == null)
        {
          AVGameEffectCtrl localAVGameEffectCtrl = new AVGameEffectCtrl(this);
          localAVGameEffectCtrl.g();
          this.g = localAVGameEffectCtrl;
          a(this.g);
        }
        if (QLog.isDevelopLevel())
        {
          QLog.i("AVGameCameraAssistant", 2, "initEffectCtrl");
          return;
        }
      }
      finally {}
    }
  }
  
  public int a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AVGameSession localAVGameSession = this.d.j();
    int i1 = 0;
    if (localAVGameSession != null)
    {
      i1 = localAVGameSession.a;
      if (paramBoolean1)
      {
        localAVGameSession.b(3);
        localAVGameSession.a = 4;
        localAVGameSession.a(1, false);
      }
      else if (localAVGameSession.m == 2)
      {
        AVGameBusinessCtrl.b().l();
      }
    }
    return i1;
  }
  
  public void a(long paramLong)
  {
    this.h.post(new AVGameCameraAssistant.1(this, paramLong));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.d.j();
    if (localObject != null)
    {
      ((AVGameSession)localObject).b(0);
      ((AVGameSession)localObject).a(1, true);
    }
    localObject = this.a;
    this.a = null;
    if (localObject != null) {
      ((FramePerfData)localObject).i();
    }
    this.h.removeMessages(1);
    a(false);
    if (this.l == null)
    {
      this.l = new AVGameCameraAssistant.ClearCacheTask();
      ThreadManager.excute(this.l, 16, null, false);
    }
  }
  
  public void a(AVGameCameraAssistant.CameraEventListener paramCameraEventListener)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addCameraListener, cameraListener[");
      localStringBuilder.append(paramCameraEventListener);
      localStringBuilder.append("]");
      QLog.i("AVGameCameraAssistant", 4, localStringBuilder.toString());
    }
    try
    {
      if (!this.m.contains(paramCameraEventListener))
      {
        this.m.add(paramCameraEventListener);
        return;
      }
    }
    catch (Throwable paramCameraEventListener)
    {
      QLog.i("AVGameCameraAssistant", 2, "addCameraListener", paramCameraEventListener);
    }
  }
  
  public void a(AVGameSession paramAVGameSession)
  {
    if (paramAVGameSession == null) {
      return;
    }
    paramAVGameSession.b(2);
    long l1 = QQAudioHelper.d();
    if (QLog.isColorLevel())
    {
      paramAVGameSession = new StringBuilder();
      paramAVGameSession.append("openCamera, seq[");
      paramAVGameSession.append(l1);
      paramAVGameSession.append("]");
      QLog.i("AVGameCameraAssistant", 2, paramAVGameSession.toString());
    }
    this.e.openCamera(l1);
  }
  
  public void a(String paramString)
  {
    if (!EffectCtrlBase.c()) {
      return;
    }
    if ((AVGameAppInterface)this.f.get() == null) {
      return;
    }
    if (this.g == null) {
      h();
    }
    Object localObject = this.g;
    if ((localObject != null) && (((AVGameEffectCtrl)localObject).m())) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = Math.abs(l1 - this.j);
    if (l2 < 2000L) {
      return;
    }
    this.j = l1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startCheckEffect, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], interval[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameCameraAssistant", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new AVGameCameraAssistant.3(this), 16, null, true);
  }
  
  public void b()
  {
    this.h.post(new AVGameCameraAssistant.2(this));
  }
  
  public void b(AVGameCameraAssistant.CameraEventListener paramCameraEventListener)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeCameraListener, cameraListener[");
      localStringBuilder.append(paramCameraEventListener);
      localStringBuilder.append("]");
      QLog.i("AVGameCameraAssistant", 4, localStringBuilder.toString());
    }
    try
    {
      this.m.remove(paramCameraEventListener);
      return;
    }
    catch (Throwable paramCameraEventListener)
    {
      QLog.i("AVGameCameraAssistant", 2, "removeCameraListener", paramCameraEventListener);
    }
  }
  
  public void b(AVGameSession paramAVGameSession)
  {
    if (paramAVGameSession == null) {
      return;
    }
    paramAVGameSession.b(5);
    long l1 = QQAudioHelper.d();
    if (QLog.isColorLevel())
    {
      paramAVGameSession = new StringBuilder();
      paramAVGameSession.append("openCamera, seq[");
      paramAVGameSession.append(l1);
      paramAVGameSession.append("]");
      QLog.i("AVGameCameraAssistant", 2, paramAVGameSession.toString());
    }
    this.e.closeCamera(l1, true);
  }
  
  public void c()
  {
    if (this.g == null) {
      h();
    }
  }
  
  public void d()
  {
    this.e.deleteObserver(this.n);
    this.m.clear();
    g();
    a(true);
  }
  
  public void e() {}
  
  public void f()
  {
    this.b = 0;
    this.c = false;
    AVGameCameraAssistant.ClearCacheTask localClearCacheTask = this.l;
    if (localClearCacheTask != null)
    {
      localClearCacheTask.a = true;
      this.l = null;
    }
    a("beforeOpenCamera");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a("MSG_CHECK_PTV_SO");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant
 * JD-Core Version:    0.7.0.1
 */