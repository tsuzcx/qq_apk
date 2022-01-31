import android.widget.Toast;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;

class aohc
  implements Runnable
{
  aohc(aohb paramaohb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMFileEventNotify", 2, "RMFileEventNotify[runOnUIThread][stopWatching-delete-quit]");
    }
    Toast.makeText(VideoEnvironment.a(), "视频缓存被恶意篡改了", 1).show();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a("RMFileEventNotify");
    if (localRMVideoStateMgr.a != null) {
      localRMVideoStateMgr.a.A();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aohc
 * JD-Core Version:    0.7.0.1
 */