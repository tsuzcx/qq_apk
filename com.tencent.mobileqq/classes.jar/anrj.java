import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;

public class anrj
  implements Runnable
{
  public anrj(RMVideoRecordState paramRMVideoRecordState) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.a())
    {
      SLog.c("RMRecordState", "run record finish, but state is not right");
      return;
    }
    this.a.b();
    localRMVideoStateMgr.a.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrj
 * JD-Core Version:    0.7.0.1
 */