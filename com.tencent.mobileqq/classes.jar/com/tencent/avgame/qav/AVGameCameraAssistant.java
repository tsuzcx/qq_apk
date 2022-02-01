package com.tencent.avgame.qav;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import bjng;
import com.tencent.av.camera.CameraUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import lbg;
import ljd;
import ljf;
import los;
import mqq.util.WeakReference;
import mrk;
import myc;
import mye;
import ngu;
import nha;
import nhb;
import nhc;
import nhn;

public class AVGameCameraAssistant
  extends lbg
  implements Handler.Callback, ljd
{
  private long jdField_a_of_type_Long;
  private final bjng jdField_a_of_type_Bjng;
  private final CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  private AVGameCameraAssistant.ClearCacheTask jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask;
  private final ConcurrentLinkedQueue<nhb> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private ljf jdField_a_of_type_Ljf = new nha(this);
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private myc jdField_a_of_type_Myc;
  private final ngu jdField_a_of_type_Ngu;
  private nhc jdField_a_of_type_Nhc;
  private int b;
  
  public AVGameCameraAssistant(ngu paramngu, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVGameAppInterface);
    this.jdField_a_of_type_Ngu = paramngu;
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this);
    this.jdField_a_of_type_Bjng = new bjng(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Ljf);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "clearEffectCtrl, exit[" + paramBoolean + "]");
    }
    if (this.jdField_a_of_type_Nhc != null)
    {
      this.jdField_a_of_type_Nhc.a();
      this.jdField_a_of_type_Nhc.a(paramBoolean);
      this.jdField_a_of_type_Nhc = null;
    }
    a(null);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Myc != null)
    {
      mye.a().b(this.jdField_a_of_type_Myc);
      this.jdField_a_of_type_Myc = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Nhc == null) {}
    try
    {
      if (this.jdField_a_of_type_Nhc == null)
      {
        nhc localnhc = new nhc(this);
        localnhc.c();
        this.jdField_a_of_type_Nhc = localnhc;
        a(this.jdField_a_of_type_Nhc);
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
    nhn localnhn = this.jdField_a_of_type_Ngu.a();
    if (localnhn != null)
    {
      int i = localnhn.jdField_a_of_type_Int;
      if (paramBoolean1)
      {
        localnhn.b(3);
        localnhn.jdField_a_of_type_Int = 4;
        localnhn.a(1, false);
      }
      while (localnhn.d != 2) {
        return i;
      }
      ngu.b().f();
      return i;
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bjng.post(new AVGameCameraAssistant.2(this));
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bjng.post(new AVGameCameraAssistant.1(this, paramLong));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Ngu.a();
    if (localObject != null)
    {
      ((nhn)localObject).b(0);
      ((nhn)localObject).a(1, true);
    }
    localObject = this.jdField_a_of_type_Mrk;
    this.jdField_a_of_type_Mrk = null;
    if (localObject != null) {
      ((mrk)localObject).d();
    }
    this.jdField_a_of_type_Bjng.removeMessages(1);
    a(false);
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask == null)
    {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask = new AVGameCameraAssistant.ClearCacheTask();
      ThreadManager.excute(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask, 16, null, false);
    }
  }
  
  public void a(String paramString)
  {
    if (!los.b()) {}
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
        if (this.jdField_a_of_type_Nhc == null) {
          g();
        }
      } while ((this.jdField_a_of_type_Nhc != null) && (this.jdField_a_of_type_Nhc.f()));
      l1 = SystemClock.elapsedRealtime();
      l2 = Math.abs(l1 - this.jdField_a_of_type_Long);
    } while (l2 < 2000L);
    this.jdField_a_of_type_Long = l1;
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "startCheckEffect, from[" + paramString + "], interval[" + l2 + "]");
    }
    ThreadManager.excute(new AVGameCameraAssistant.3(this), 16, null, true);
  }
  
  public void a(nhb paramnhb)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "addCameraListener, cameraListener[" + paramnhb + "]");
    }
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramnhb)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramnhb);
      }
      return;
    }
    catch (Throwable paramnhb)
    {
      QLog.i("AVGameCameraAssistant", 2, "addCameraListener", paramnhb);
    }
  }
  
  public void a(nhn paramnhn)
  {
    if (paramnhn == null) {
      return;
    }
    paramnhn.b(2);
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "openCamera, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Nhc == null) {
      g();
    }
  }
  
  public void b(nhb paramnhb)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "removeCameraListener, cameraListener[" + paramnhb + "]");
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramnhb);
      return;
    }
    catch (Throwable paramnhb)
    {
      QLog.i("AVGameCameraAssistant", 2, "removeCameraListener", paramnhb);
    }
  }
  
  public void b(nhn paramnhn)
  {
    if (paramnhn == null) {
      return;
    }
    paramnhn.b(5);
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "openCamera, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l, true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Ljf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant
 * JD-Core Version:    0.7.0.1
 */