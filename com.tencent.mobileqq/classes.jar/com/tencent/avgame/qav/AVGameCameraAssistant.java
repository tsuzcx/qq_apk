package com.tencent.avgame.qav;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import bkys;
import com.tencent.av.camera.CameraUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import lbj;
import ljp;
import ljr;
import lpf;
import mqq.util.WeakReference;
import msh;
import ndo;
import ndq;
import nnm;
import nns;
import nnt;
import nnu;
import nof;

public class AVGameCameraAssistant
  extends lbj
  implements Handler.Callback, ljp
{
  private long jdField_a_of_type_Long;
  private final bkys jdField_a_of_type_Bkys;
  private final CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  private AVGameCameraAssistant.ClearCacheTask jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask;
  private final ConcurrentLinkedQueue<nnt> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private ljr jdField_a_of_type_Ljr = new nns(this);
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private ndo jdField_a_of_type_Ndo;
  private final nnm jdField_a_of_type_Nnm;
  private nnu jdField_a_of_type_Nnu;
  private int b;
  
  public AVGameCameraAssistant(nnm paramnnm, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVGameAppInterface);
    this.jdField_a_of_type_Nnm = paramnnm;
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this);
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Ljr);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "clearEffectCtrl, exit[" + paramBoolean + "]");
    }
    if (this.jdField_a_of_type_Nnu != null)
    {
      this.jdField_a_of_type_Nnu.a();
      this.jdField_a_of_type_Nnu.a(paramBoolean);
      this.jdField_a_of_type_Nnu = null;
    }
    a(null);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Ndo != null)
    {
      ndq.a().b(this.jdField_a_of_type_Ndo);
      this.jdField_a_of_type_Ndo = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Nnu == null) {}
    try
    {
      if (this.jdField_a_of_type_Nnu == null)
      {
        nnu localnnu = new nnu(this);
        localnnu.c();
        this.jdField_a_of_type_Nnu = localnnu;
        a(this.jdField_a_of_type_Nnu);
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
    nof localnof = this.jdField_a_of_type_Nnm.a();
    if (localnof != null)
    {
      int i = localnof.jdField_a_of_type_Int;
      if (paramBoolean1)
      {
        localnof.b(3);
        localnof.jdField_a_of_type_Int = 4;
        localnof.a(1, false);
      }
      while (localnof.d != 2) {
        return i;
      }
      nnm.b().f();
      return i;
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkys.post(new AVGameCameraAssistant.2(this));
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bkys.post(new AVGameCameraAssistant.1(this, paramLong));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Nnm.a();
    if (localObject != null)
    {
      ((nof)localObject).b(0);
      ((nof)localObject).a(1, true);
    }
    localObject = this.jdField_a_of_type_Msh;
    this.jdField_a_of_type_Msh = null;
    if (localObject != null) {
      ((msh)localObject).d();
    }
    this.jdField_a_of_type_Bkys.removeMessages(1);
    a(false);
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask == null)
    {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask = new AVGameCameraAssistant.ClearCacheTask();
      ThreadManager.excute(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask, 16, null, false);
    }
  }
  
  public void a(String paramString)
  {
    if (!lpf.b()) {}
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
        if (this.jdField_a_of_type_Nnu == null) {
          g();
        }
      } while ((this.jdField_a_of_type_Nnu != null) && (this.jdField_a_of_type_Nnu.f()));
      l1 = SystemClock.elapsedRealtime();
      l2 = Math.abs(l1 - this.jdField_a_of_type_Long);
    } while (l2 < 2000L);
    this.jdField_a_of_type_Long = l1;
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "startCheckEffect, from[" + paramString + "], interval[" + l2 + "]");
    }
    ThreadManager.excute(new AVGameCameraAssistant.3(this), 16, null, true);
  }
  
  public void a(nnt paramnnt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "addCameraListener, cameraListener[" + paramnnt + "]");
    }
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramnnt)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramnnt);
      }
      return;
    }
    catch (Throwable paramnnt)
    {
      QLog.i("AVGameCameraAssistant", 2, "addCameraListener", paramnnt);
    }
  }
  
  public void a(nof paramnof)
  {
    if (paramnof == null) {
      return;
    }
    paramnof.b(2);
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "openCamera, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Nnu == null) {
      g();
    }
  }
  
  public void b(nnt paramnnt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "removeCameraListener, cameraListener[" + paramnnt + "]");
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramnnt);
      return;
    }
    catch (Throwable paramnnt)
    {
      QLog.i("AVGameCameraAssistant", 2, "removeCameraListener", paramnnt);
    }
  }
  
  public void b(nof paramnof)
  {
    if (paramnof == null) {
      return;
    }
    paramnof.b(5);
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "openCamera, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l, true);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Ljr);
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