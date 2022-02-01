import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class awhd
  implements Application.ActivityLifecycleCallbacks
{
  awhd(awgx paramawgx) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityDestroyed: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityResumed: " + paramActivity.getClass().getName());
    }
    if ((this.a.c) && (!this.a.b))
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getUIHandlerV2().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    while (!awgx.b(this.a)) {
      return;
    }
    awgx.a(this.a, false);
    this.a.jdField_a_of_type_Boolean = true;
    this.a.a(true);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityStarted: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityStopped: " + paramActivity.getClass().getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhd
 * JD-Core Version:    0.7.0.1
 */