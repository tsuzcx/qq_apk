import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager;

public class avpr
  implements Application.ActivityLifecycleCallbacks
{
  public avpr(RedTouchLifeTimeManager paramRedTouchLifeTimeManager) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity.getComponentName() != null)
    {
      RedTouchLifeTimeManager.a(this.a, paramActivity.getComponentName().getClassName());
      if ((!TextUtils.isEmpty(RedTouchLifeTimeManager.a(this.a))) && (RedTouchLifeTimeManager.a(this.a).equals(RedTouchLifeTimeManager.b(this.a)))) {
        RedTouchLifeTimeManager.a(this.a);
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avpr
 * JD-Core Version:    0.7.0.1
 */