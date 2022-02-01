package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ReportFragment
  extends com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment
{
  private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
  private ReportFragment.ActivityInitializationListener mProcessListener;
  
  static void dispatch(@NonNull Activity paramActivity, @NonNull Lifecycle.Event paramEvent)
  {
    if ((paramActivity instanceof LifecycleRegistryOwner))
    {
      ((LifecycleRegistryOwner)paramActivity).getLifecycle().handleLifecycleEvent(paramEvent);
      return;
    }
    if ((paramActivity instanceof LifecycleOwner))
    {
      paramActivity = ((LifecycleOwner)paramActivity).getLifecycle();
      if ((paramActivity instanceof LifecycleRegistry)) {
        ((LifecycleRegistry)paramActivity).handleLifecycleEvent(paramEvent);
      }
    }
  }
  
  private void dispatch(@NonNull Lifecycle.Event paramEvent)
  {
    if (Build.VERSION.SDK_INT < 29) {
      dispatch(getActivity(), paramEvent);
    }
  }
  
  private void dispatchCreate(ReportFragment.ActivityInitializationListener paramActivityInitializationListener)
  {
    if (paramActivityInitializationListener != null) {
      paramActivityInitializationListener.onCreate();
    }
  }
  
  private void dispatchResume(ReportFragment.ActivityInitializationListener paramActivityInitializationListener)
  {
    if (paramActivityInitializationListener != null) {
      paramActivityInitializationListener.onResume();
    }
  }
  
  private void dispatchStart(ReportFragment.ActivityInitializationListener paramActivityInitializationListener)
  {
    if (paramActivityInitializationListener != null) {
      paramActivityInitializationListener.onStart();
    }
  }
  
  static ReportFragment get(Activity paramActivity)
  {
    return (ReportFragment)paramActivity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  public static void injectIfNeededIn(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      ReportFragment.LifecycleCallbacks.registerIn(paramActivity);
    }
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    dispatchCreate(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    dispatch(Lifecycle.Event.ON_DESTROY);
    this.mProcessListener = null;
  }
  
  public void onPause()
  {
    super.onPause();
    dispatch(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    dispatchResume(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    dispatchStart(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    dispatch(Lifecycle.Event.ON_STOP);
  }
  
  void setProcessListener(ReportFragment.ActivityInitializationListener paramActivityInitializationListener)
  {
    this.mProcessListener = paramActivityInitializationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ReportFragment
 * JD-Core Version:    0.7.0.1
 */