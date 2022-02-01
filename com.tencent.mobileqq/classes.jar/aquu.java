import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aquu
  implements Application.ActivityLifecycleCallbacks
{
  public aquu(ColorNoteSmallScreenService paramColorNoteSmallScreenService) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "onActivityDestroyed: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "onActivityResumed: " + paramActivity.getClass().getName());
    }
    if (this.a.f)
    {
      this.a.f = false;
      this.a.d = true;
      this.a.a().removeCallbacks(this.a.b);
      this.a.a().postDelayed(this.a.b, 200L);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "onActivityStarted: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "onActivityStopped: " + paramActivity.getClass().getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquu
 * JD-Core Version:    0.7.0.1
 */