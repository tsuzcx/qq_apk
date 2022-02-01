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
  private long jdField_a_of_type_Long = 0L;
  private CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new AVGameCameraAssistant.4(this);
  private final ICameraManagerApi jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi;
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
    this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi = CameraUtils.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.setCameraListener(this);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.addObserver(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
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
    Object localObject = this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl;
    if (localObject != null)
    {
      ((AVGameEffectCtrl)localObject).a();
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
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl == null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl == null)
        {
          AVGameEffectCtrl localAVGameEffectCtrl = new AVGameEffectCtrl(this);
          localAVGameEffectCtrl.b();
          this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl = localAVGameEffectCtrl;
          a(this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl);
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
    AVGameSession localAVGameSession = this.jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl.a();
    int i = 0;
    if (localAVGameSession != null)
    {
      i = localAVGameSession.jdField_a_of_type_Int;
      if (paramBoolean1)
      {
        localAVGameSession.b(3);
        localAVGameSession.jdField_a_of_type_Int = 4;
        localAVGameSession.a(1, false);
      }
      else if (localAVGameSession.d == 2)
      {
        AVGameBusinessCtrl.b().c();
      }
    }
    return i;
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
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramCameraEventListener))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramCameraEventListener);
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
    long l = QQAudioHelper.b();
    if (QLog.isColorLevel())
    {
      paramAVGameSession = new StringBuilder();
      paramAVGameSession.append("openCamera, seq[");
      paramAVGameSession.append(l);
      paramAVGameSession.append("]");
      QLog.i("AVGameCameraAssistant", 2, paramAVGameSession.toString());
    }
    this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(l);
  }
  
  public void a(String paramString)
  {
    if (!EffectCtrlBase.b()) {
      return;
    }
    if ((AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl == null) {
      g();
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl;
    if ((localObject != null) && (((AVGameEffectCtrl)localObject).f())) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = Math.abs(l1 - this.jdField_a_of_type_Long);
    if (l2 < 2000L) {
      return;
    }
    this.jdField_a_of_type_Long = l1;
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
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameEffectCtrl == null) {
      g();
    }
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
    long l = QQAudioHelper.b();
    if (QLog.isColorLevel())
    {
      paramAVGameSession = new StringBuilder();
      paramAVGameSession.append("openCamera, seq[");
      paramAVGameSession.append(l);
      paramAVGameSession.append("]");
      QLog.i("AVGameCameraAssistant", 2, paramAVGameSession.toString());
    }
    this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.closeCamera(l, true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.deleteObserver(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    f();
    a(true);
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    AVGameCameraAssistant.ClearCacheTask localClearCacheTask = this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask;
    if (localClearCacheTask != null)
    {
      localClearCacheTask.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask = null;
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