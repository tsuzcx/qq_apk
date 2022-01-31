import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoHallowenUpload;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class anvp
  implements Runnable
{
  public anvp(EditWebVideoHallowenUpload paramEditWebVideoHallowenUpload, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditWebVideoActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + ",is to call AVideoCodec.recordSubmit()");
      }
      RecordManager.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        synchronized (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
        {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("EditWebVideoActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvp
 * JD-Core Version:    0.7.0.1
 */