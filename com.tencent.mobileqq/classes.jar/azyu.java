import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.mobileqq.resourcesgrab.ResourceGrabFragment;
import com.tencent.mobileqq.resourcesgrab.ResourceGrabView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class azyu
  implements Application.ActivityLifecycleCallbacks
{
  public azyu(ResourceGrabView paramResourceGrabView) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabView", 2, "onActivityCreated activity: " + paramActivity);
    }
    ResourceGrabView.a(this.a, new WeakReference(paramActivity));
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabView", 2, "onActivityDestroyed activity: " + paramActivity);
    }
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
      if ((paramActivity instanceof ResourceGrabFragment)) {
        ((ResourceGrabFragment)paramActivity).d();
      }
    }
    ResourceGrabView.a(this.a, null);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabView", 2, "onActivityResumed activity: " + paramActivity);
    }
    ResourceGrabView.a(this.a, new WeakReference(paramActivity));
    this.a.a(ResourceGrabView.a(this.a));
    ResourceGrabView.a(this.a);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyu
 * JD-Core Version:    0.7.0.1
 */