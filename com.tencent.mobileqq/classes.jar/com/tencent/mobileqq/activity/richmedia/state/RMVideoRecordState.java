package com.tencent.mobileqq.activity.richmedia.state;

import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.common.TCTimer;
import com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import com.tencent.mobileqq.shortvideo.util.AudioDataCache;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

public class RMVideoRecordState
  extends RMVideoState
{
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void d()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[@] [startRecordVideo]Lock.CAPTURE_LOCK=");
      ((StringBuilder)???).append(Lock.jdField_a_of_type_Boolean);
      QLog.d("RMRecordState", 2, ((StringBuilder)???).toString());
    }
    if (!Lock.jdField_a_of_type_Boolean) {
      synchronized (Lock.jdField_a_of_type_JavaLangObject)
      {
        Lock.jdField_a_of_type_Boolean = true;
        Lock.jdField_a_of_type_JavaLangObject.notifyAll();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[@] [startRecordVideo]Lock.CAPTURE_LOCK=");
          ((StringBuilder)???).append(Lock.jdField_a_of_type_Boolean);
          QLog.d("RMRecordState", 2, ((StringBuilder)???).toString());
        }
        AVCodec.get().startCapture();
        localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.startCapture();
        if (localRMVideoStateMgr.h()) {
          localRMVideoStateMgr.f();
        }
        if ((localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (localRMVideoStateMgr.g())) {
          localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.h();
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
    }
  }
  
  public void a()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.ag_();
    localRMVideoStateMgr.k();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]stopWatching");
    }
    this.jdField_a_of_type_Boolean = false;
    d();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] initState end");
    }
  }
  
  public void a(TCTimer.TCTimerCallback paramTCTimerCallback, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramTCTimerCallback = RMVideoStateMgr.a();
    if (paramTCTimerCallback.jdField_b_of_type_Boolean) {
      paramTCTimerCallback.jdField_a_of_type_Double = (System.currentTimeMillis() - paramTCTimerCallback.jdField_a_of_type_Long);
    } else {
      paramTCTimerCallback.jdField_a_of_type_Double = paramInt1;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((paramTCTimerCallback.f()) && (!paramTCTimerCallback.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.e) && (!paramTCTimerCallback.h)) {
        paramTCTimerCallback.jdField_a_of_type_AndroidOsHandler.post(new RMVideoRecordState.2(this));
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[@] timeExpire: mIsRecordOver=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject).append(" mStateMgr.mTotalTime=");
        ((StringBuilder)localObject).append(paramTCTimerCallback.jdField_a_of_type_Double);
        QLog.d("RMRecordState", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramTCTimerCallback.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface;
      double d1 = paramTCTimerCallback.jdField_a_of_type_Double;
      double d2 = RecordManager.a().a().a();
      Double.isNaN(d2);
      ((RMViewSTInterface)localObject).a((int)(d1 + d2), this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Boolean) {
        paramTCTimerCallback.jdField_a_of_type_AndroidOsHandler.post(new RMVideoRecordState.3(this));
      }
    }
  }
  
  public void b()
  {
    c();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a(2);
    localRMVideoStateMgr.j();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]startWatching");
    }
  }
  
  public void c()
  {
    Object localObject = RMVideoStateMgr.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] [stopRecordVideo]Lock.CAPTURE_LOCK = ");
      localStringBuilder.append(Lock.jdField_a_of_type_Boolean);
      QLog.d("RMRecordState", 2, localStringBuilder.toString());
    }
    if (Lock.jdField_a_of_type_Boolean)
    {
      Lock.jdField_a_of_type_Boolean = false;
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Long = (l1 - this.jdField_a_of_type_Long);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] [stopRecordVideo] current=");
        localStringBuilder.append(l1);
        localStringBuilder.append(" timestamp=");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        QLog.d("RMRecordState", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_Boolean) {
        ((RMVideoStateMgr)localObject).jdField_a_of_type_Double = CodecParam.RECORD_MAX_TIME;
      }
      ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.f();
      ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.stopCapture();
      if (((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
        ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.i();
      }
      if (((RMVideoStateMgr)localObject).h())
      {
        if (((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioDataCache != null) {
          ((RMVideoStateMgr)localObject).jdField_b_of_type_JavaLangString = ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioDataCache.a((RMVideoStateMgr)localObject);
        }
        ((RMVideoStateMgr)localObject).g();
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new RMVideoRecordState.1(this, (RMVideoStateMgr)localObject));
      AVCodec.get().stopCapture();
      long l2 = ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.a();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] [stopRecordVideo] timeLimit=");
        localStringBuilder.append(l2);
        localStringBuilder.append(" timestamp=");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        QLog.d("RMRecordState", 2, localStringBuilder.toString());
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = this.jdField_a_of_type_Long;
      }
      if ((l1 < 500L) && (!this.jdField_a_of_type_Boolean))
      {
        ((RMVideoStateMgr)localObject).jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.a(true);
        ((RMVideoStateMgr)localObject).a(true);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[@] stopRecordVideo end Lock.CAPTURE_LOCK = ");
        ((StringBuilder)localObject).append(Lock.jdField_a_of_type_Boolean);
        QLog.d("RMRecordState", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void f()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState
 * JD-Core Version:    0.7.0.1
 */