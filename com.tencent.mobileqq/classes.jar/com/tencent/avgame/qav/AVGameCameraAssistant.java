package com.tencent.avgame.qav;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import bkgm;
import com.tencent.av.camera.CameraUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import lbh;
import ljb;
import ljd;
import lox;
import mqq.util.WeakReference;
import mrd;
import mws;
import mwu;
import ndt;
import ndz;
import nea;
import neb;

public class AVGameCameraAssistant
  extends lbh
  implements Handler.Callback, ljb
{
  private long jdField_a_of_type_Long;
  private final bkgm jdField_a_of_type_Bkgm;
  private final CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  private AVGameCameraAssistant.ClearCacheTask jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask;
  private final ConcurrentLinkedQueue<nea> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private ljd jdField_a_of_type_Ljd = new ndz(this);
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private mws jdField_a_of_type_Mws;
  private final ndt jdField_a_of_type_Ndt;
  private neb jdField_a_of_type_Neb;
  private int b;
  
  public AVGameCameraAssistant(ndt paramndt, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVGameAppInterface);
    this.jdField_a_of_type_Ndt = paramndt;
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this);
    this.jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Ljd);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "clearEffectCtrl, exit[" + paramBoolean + "]");
    }
    if (this.jdField_a_of_type_Neb != null)
    {
      this.jdField_a_of_type_Neb.a();
      this.jdField_a_of_type_Neb.a(paramBoolean);
      this.jdField_a_of_type_Neb = null;
    }
    a(null);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Mws != null)
    {
      mwu.a().b(this.jdField_a_of_type_Mws);
      this.jdField_a_of_type_Mws = null;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Neb == null) {}
    try
    {
      if (this.jdField_a_of_type_Neb == null)
      {
        neb localneb = new neb();
        localneb.c();
        this.jdField_a_of_type_Neb = localneb;
        a(this.jdField_a_of_type_Neb);
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
    AVGameSession localAVGameSession = this.jdField_a_of_type_Ndt.a();
    if (localAVGameSession != null)
    {
      int i = localAVGameSession.jdField_a_of_type_Int;
      if (paramBoolean1)
      {
        localAVGameSession.a(3);
        localAVGameSession.jdField_a_of_type_Int = 4;
        localAVGameSession.a(1, false);
      }
      while (localAVGameSession.d != 2) {
        return i;
      }
      ndt.b().f();
      return i;
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkgm.post(new AVGameCameraAssistant.2(this));
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bkgm.post(new AVGameCameraAssistant.1(this, paramLong));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Ndt.a();
    if (localObject != null)
    {
      ((AVGameSession)localObject).a(0);
      ((AVGameSession)localObject).a(1, true);
    }
    localObject = this.jdField_a_of_type_Mrd;
    this.jdField_a_of_type_Mrd = null;
    if (localObject != null) {
      ((mrd)localObject).d();
    }
    this.jdField_a_of_type_Bkgm.removeMessages(1);
    a(false);
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask == null)
    {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask = new AVGameCameraAssistant.ClearCacheTask();
      ThreadManager.excute(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask, 16, null, false);
    }
  }
  
  public void a(AVGameSession paramAVGameSession)
  {
    if (paramAVGameSession == null) {
      return;
    }
    paramAVGameSession.a(2);
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "openCamera, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l);
  }
  
  public void a(String paramString)
  {
    if (!lox.b()) {}
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
        if (this.jdField_a_of_type_Neb == null) {
          f();
        }
      } while ((this.jdField_a_of_type_Neb != null) && (this.jdField_a_of_type_Neb.f()));
      l1 = SystemClock.elapsedRealtime();
      l2 = Math.abs(l1 - this.jdField_a_of_type_Long);
    } while (l2 < 2000L);
    this.jdField_a_of_type_Long = l1;
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "startCheckEffect, from[" + paramString + "], interval[" + l2 + "]");
    }
    ThreadManager.excute(new AVGameCameraAssistant.3(this), 16, null, true);
  }
  
  public void a(nea paramnea)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "addCameraListener, cameraListener[" + paramnea + "]");
    }
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramnea)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramnea);
      }
      return;
    }
    catch (Throwable paramnea)
    {
      QLog.i("AVGameCameraAssistant", 2, "addCameraListener", paramnea);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Ljd);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    e();
    a(true);
  }
  
  public void b(AVGameSession paramAVGameSession)
  {
    if (paramAVGameSession == null) {
      return;
    }
    paramAVGameSession.a(5);
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "openCamera, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l, true);
  }
  
  public void b(nea paramnea)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "removeCameraListener, cameraListener[" + paramnea + "]");
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramnea);
      return;
    }
    catch (Throwable paramnea)
    {
      QLog.i("AVGameCameraAssistant", 2, "removeCameraListener", paramnea);
    }
  }
  
  public void c() {}
  
  public void d()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant
 * JD-Core Version:    0.7.0.1
 */