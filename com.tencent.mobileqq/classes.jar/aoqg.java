import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class aoqg
  implements Runnable
{
  public aoqg(RMVideoRecordState paramRMVideoRecordState, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a != null) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.unlockFrameSync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoqg
 * JD-Core Version:    0.7.0.1
 */