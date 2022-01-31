import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class aoql
  implements Runnable
{
  public aoql(RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    synchronized (RMVideoStateMgr.a(this.a))
    {
      if (this.a.f())
      {
        this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.b(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture$OnAudioRecordListener);
        this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.f();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]");
        }
      }
      this.a.d = false;
      this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
      this.a.e = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoql
 * JD-Core Version:    0.7.0.1
 */