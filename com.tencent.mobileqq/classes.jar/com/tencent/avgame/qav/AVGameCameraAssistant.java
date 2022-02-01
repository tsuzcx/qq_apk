package com.tencent.avgame.qav;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import blhq;
import com.tencent.av.camera.CameraUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import lbo;
import ljj;
import ljl;
import lpk;
import mqq.util.WeakReference;
import msb;
import mxr;
import mxt;
import nfm;
import nfs;
import nft;
import nfu;

public class AVGameCameraAssistant
  extends lbo
  implements Handler.Callback, ljj
{
  private long jdField_a_of_type_Long;
  private final blhq jdField_a_of_type_Blhq;
  private final CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  private AVGameCameraAssistant.ClearCacheTask jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$ClearCacheTask;
  private final ConcurrentLinkedQueue<nft> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private ljl jdField_a_of_type_Ljl = new nfs(this);
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private mxr jdField_a_of_type_Mxr;
  private final nfm jdField_a_of_type_Nfm;
  private nfu jdField_a_of_type_Nfu;
  private int b;
  
  public AVGameCameraAssistant(nfm paramnfm, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVGameAppInterface);
    this.jdField_a_of_type_Nfm = paramnfm;
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this);
    this.jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Ljl);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "clearEffectCtrl, exit[" + paramBoolean + "]");
    }
    if (this.jdField_a_of_type_Nfu != null)
    {
      this.jdField_a_of_type_Nfu.a();
      this.jdField_a_of_type_Nfu.a(paramBoolean);
      this.jdField_a_of_type_Nfu = null;
    }
    a(null);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Mxr != null)
    {
      mxt.a().b(this.jdField_a_of_type_Mxr);
      this.jdField_a_of_type_Mxr = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Nfu == null) {}
    try
    {
      if (this.jdField_a_of_type_Nfu == null)
      {
        nfu localnfu = new nfu(this);
        localnfu.c();
        this.jdField_a_of_type_Nfu = localnfu;
        a(this.jdField_a_of_type_Nfu);
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
    AVGameSession localAVGameSession = this.jdField_a_of_type_Nfm.a();
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
      nfm.b().f();
      return i;
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blhq.post(new AVGameCameraAssistant.2(this));
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Blhq.post(new AVGameCameraAssistant.1(this, paramLong));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Nfm.a();
    if (localObject != null)
    {
      ((AVGameSession)localObject).a(0);
      ((AVGameSession)localObject).a(1, true);
    }
    localObject = this.jdField_a_of_type_Msb;
    this.jdField_a_of_type_Msb = null;
    if (localObject != null) {
      ((msb)localObject).d();
    }
    this.jdField_a_of_type_Blhq.removeMessages(1);
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
    if (!lpk.b()) {}
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
        if (this.jdField_a_of_type_Nfu == null) {
          g();
        }
      } while ((this.jdField_a_of_type_Nfu != null) && (this.jdField_a_of_type_Nfu.f()));
      l1 = SystemClock.elapsedRealtime();
      l2 = Math.abs(l1 - this.jdField_a_of_type_Long);
    } while (l2 < 2000L);
    this.jdField_a_of_type_Long = l1;
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "startCheckEffect, from[" + paramString + "], interval[" + l2 + "]");
    }
    ThreadManager.excute(new AVGameCameraAssistant.3(this), 16, null, true);
  }
  
  public void a(nft paramnft)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "addCameraListener, cameraListener[" + paramnft + "]");
    }
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramnft)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramnft);
      }
      return;
    }
    catch (Throwable paramnft)
    {
      QLog.i("AVGameCameraAssistant", 2, "addCameraListener", paramnft);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Nfu == null) {
      g();
    }
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
  
  public void b(nft paramnft)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("AVGameCameraAssistant", 4, "removeCameraListener, cameraListener[" + paramnft + "]");
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramnft);
      return;
    }
    catch (Throwable paramnft)
    {
      QLog.i("AVGameCameraAssistant", 2, "removeCameraListener", paramnft);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Ljl);
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