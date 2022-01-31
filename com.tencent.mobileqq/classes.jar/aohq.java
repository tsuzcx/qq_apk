import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import java.util.concurrent.atomic.AtomicReference;

public class aohq
  implements Runnable
{
  public aohq(RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    synchronized (RMVideoStateMgr.a(this.a))
    {
      AudioCapture localAudioCapture = this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture;
      if ((localAudioCapture != null) && (localAudioCapture.b != null) && (this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAudioDataCache != null) && (localAudioCapture.c()) && (localAudioCapture != null))
      {
        localAudioCapture.c();
        localAudioCapture.b.getAndSet(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAudioDataCache);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aohq
 * JD-Core Version:    0.7.0.1
 */