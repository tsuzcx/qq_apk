import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowSendTask;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class anqc
  implements Runnable
{
  public anqc(FlowSendTask paramFlowSendTask) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.j, 2, "FlowSendTask(): isPTV:" + this.a.d + ", mVideoCacheDir:" + this.a.jdField_a_of_type_JavaLangString + ",is to call AVideoCodec.recordSubmit()");
      }
      RecordManager.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        this.a.k = -6;
        synchronized (this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a)
        {
          this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.set(true);
          this.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.notifyAll();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(this.a.j, 2, "FlowSendTask(): isPTV:" + this.a.d + ", mVideoCacheDir:" + this.a.jdField_a_of_type_JavaLangString + ", call AVideoCodec.recordSubmit() fail, error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqc
 * JD-Core Version:    0.7.0.1
 */