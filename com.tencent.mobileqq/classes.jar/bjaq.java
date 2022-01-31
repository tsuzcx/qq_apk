import android.os.Handler;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.1;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.2;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class bjaq
  extends bjar
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  
  private void d()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + bjki.jdField_a_of_type_Boolean);
    }
    if (!bjki.jdField_a_of_type_Boolean) {}
    synchronized (bjki.jdField_a_of_type_JavaLangObject)
    {
      bjki.jdField_a_of_type_Boolean = true;
      bjki.jdField_a_of_type_JavaLangObject.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + bjki.jdField_a_of_type_Boolean);
      }
      AVCodec.get().startCapture();
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.startCapture();
      if (localRMVideoStateMgr.a(2)) {
        localRMVideoStateMgr.a();
      }
      if ((localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (localRMVideoStateMgr.e())) {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.g();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  public void a()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.jdField_a_of_type_Bjax.b();
    localRMVideoStateMgr.e();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]stopWatching");
    }
    this.jdField_a_of_type_Boolean = false;
    d();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] initState end");
    }
  }
  
  public void a(bjjn parambjjn, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    parambjjn = RMVideoStateMgr.a();
    if (parambjjn.jdField_a_of_type_Boolean) {}
    for (parambjjn.jdField_a_of_type_Double = (System.currentTimeMillis() - parambjjn.jdField_a_of_type_Long);; parambjjn.jdField_a_of_type_Double = paramInt1)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        if ((parambjjn.d()) && (!parambjjn.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.e) && (!parambjjn.f)) {
          parambjjn.jdField_a_of_type_AndroidOsHandler.post(new RMVideoRecordState.2(this));
        }
        if (QLog.isColorLevel()) {
          QLog.d("RMRecordState", 2, "[@] timeExpire: mIsRecordOver=" + this.jdField_a_of_type_Boolean + " mStateMgr.mTotalTime=" + parambjjn.jdField_a_of_type_Double);
        }
        parambjjn.jdField_a_of_type_Bjax.a((int)(parambjjn.jdField_a_of_type_Double + bjkk.a().a().a()), this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean) {
          parambjjn.jdField_a_of_type_AndroidOsHandler.post(new RMVideoRecordState.3(this));
        }
      }
      return;
    }
  }
  
  public void b()
  {
    c();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a(2);
    localRMVideoStateMgr.d();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]startWatching");
    }
  }
  
  public void c()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [stopRecordVideo]Lock.CAPTURE_LOCK = " + bjki.jdField_a_of_type_Boolean);
    }
    if (bjki.jdField_a_of_type_Boolean)
    {
      bjki.jdField_a_of_type_Boolean = false;
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Long = (l1 - this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] current=" + l1 + " timestamp=" + this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Boolean) {
        localRMVideoStateMgr.jdField_a_of_type_Double = awje.c;
      }
      localRMVideoStateMgr.jdField_a_of_type_Bjax.f();
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.stopCapture();
      if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.h();
      }
      if (localRMVideoStateMgr.a(3))
      {
        if (localRMVideoStateMgr.jdField_a_of_type_Bjla != null) {
          localRMVideoStateMgr.b = localRMVideoStateMgr.jdField_a_of_type_Bjla.a(localRMVideoStateMgr);
        }
        localRMVideoStateMgr.b();
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new RMVideoRecordState.1(this, localRMVideoStateMgr));
      AVCodec.get().stopCapture();
      long l2 = localRMVideoStateMgr.jdField_a_of_type_Bjax.a();
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] timeLimit=" + l2 + " timestamp=" + this.jdField_a_of_type_Long);
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = this.jdField_a_of_type_Long;
      }
      if ((l1 < 500L) && (!this.jdField_a_of_type_Boolean))
      {
        localRMVideoStateMgr.jdField_a_of_type_Bjax.a(true);
        localRMVideoStateMgr.a(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] stopRecordVideo end Lock.CAPTURE_LOCK = " + bjki.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void e()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjaq
 * JD-Core Version:    0.7.0.1
 */