package com.tencent.avgame.qav;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.av.CameraDataProcess;
import com.tencent.av.camera.CameraListener;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.effects.EffectCtrlBase;
import com.tencent.av.utils.FramePerfData;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.observer.IPCEventObserver;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.util.WeakReference;

public class AVGameCameraAssistant
  extends CameraDataProcess
  implements Handler.Callback, CameraListener
{
  private long jdField_a_of_type_Long = 0L;
  private CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new AVGameCameraAssistant.4(this);
  private final CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  private IPCEventObserver jdField_a_of_type_ComTencentAvgameBusinessObserverIPCEventObserver = null;
  private final AVGameBusinessCtrl jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl;
  private AVGameCameraAssistant.ClearCacheTask jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask = null;
  private AVGameEffectCtrl jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl = null;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private final ConcurrentLinkedQueue<AVGameCameraAssistant.CameraEventListener> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private int b = 0;
  
  public AVGameCameraAssistant(AVGameBusinessCtrl paramAVGameBusinessCtrl, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVGameAppInterface);
    this.jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl = paramAVGameBusinessCtrl;
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "clearEffectCtrl, exit[" + paramBoolean + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl != null)
    {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl.a();
      this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl.a(paramBoolean);
      this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl = null;
    }
    a(null);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentAvgameBusinessObserverIPCEventObserver != null)
    {
      ObserverCenter.a().b(this.jdField_a_of_type_ComTencentAvgameBusinessObserverIPCEventObserver);
      this.jdField_a_of_type_ComTencentAvgameBusinessObserverIPCEventObserver = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl == null)
      {
        AVGameEffectCtrl localAVGameEffectCtrl = new AVGameEffectCtrl(this);
        localAVGameEffectCtrl.b();
        this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl = localAVGameEffectCtrl;
        a(this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameCameraAssistant", 2, "initEffectCtrl");
      }
      return;
    }
    finally {}
  }
  
  public int a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl.a();
    if (localAVGameSession != null)
    {
      int i = localAVGameSession.jdField_a_of_type_Int;
      if (paramBoolean1)
      {
        localAVGameSession.b(3);
        localAVGameSession.jdField_a_of_type_Int = 4;
        localAVGameSession.a(1, false);
      }
      while (localAVGameSession.d != 2) {
        return i;
      }
      AVGameBusinessCtrl.b().c();
      return i;
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AVGameCameraAssistant.2(this));
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AVGameCameraAssistant.1(this, paramLong));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl.a();
    if (localObject != null)
    {
      ((AVGameSession)localObject).b(0);
      ((AVGameSession)localObject).a(1, true);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUtilsFramePerfData;
    this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = null;
    if (localObject != null) {
      ((FramePerfData)localObject).d();
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    a(false);
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask == null)
    {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask = new AVGameCameraAssistant.ClearCacheTask();
      ThreadManager.excute(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask, 16, null, false);
    }
  }
  
  public void a(AVGameCameraAssistant.CameraEventListener paramCameraEventListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "addCameraListener, cameraListener[" + paramCameraEventListener + "]");
    }
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramCameraEventListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramCameraEventListener);
      }
      return;
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
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "openCamera, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l);
  }
  
  public void a(String paramString)
  {
    if (!EffectCtrlBase.b()) {}
    long l1;
    long l2;
    do
    {
      do
      {
        do
        {
          return;
        } while ((AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get() == null);
        if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl == null) {
          g();
        }
      } while ((this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl != null) && (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl.f()));
      l1 = SystemClock.elapsedRealtime();
      l2 = Math.abs(l1 - this.jdField_a_of_type_Long);
    } while (l2 < 2000L);
    this.jdField_a_of_type_Long = l1;
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "startCheckEffect, from[" + paramString + "], interval[" + l2 + "]");
    }
    ThreadManager.excute(new AVGameCameraAssistant.3(this), 16, null, true);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl == null) {
      g();
    }
  }
  
  public void b(AVGameCameraAssistant.CameraEventListener paramCameraEventListener)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "removeCameraListener, cameraListener[" + paramCameraEventListener + "]");
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramCameraEventListener);
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
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "openCamera, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l, true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    f();
    a(true);
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask != null)
    {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask = null;
    }
    a("beforeOpenCamera");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a("MSG_CHECK_PTV_SO");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant
 * JD-Core Version:    0.7.0.1
 */