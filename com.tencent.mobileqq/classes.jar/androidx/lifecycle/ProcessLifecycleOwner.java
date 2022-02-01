package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

public class ProcessLifecycleOwner
  implements LifecycleOwner
{
  @VisibleForTesting
  static final long TIMEOUT_MS = 700L;
  private static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();
  private Runnable mDelayedPauseRunnable = new ProcessLifecycleOwner.1(this);
  private Handler mHandler;
  ReportFragment.ActivityInitializationListener mInitializationListener = new ProcessLifecycleOwner.2(this);
  private boolean mPauseSent = true;
  private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
  private int mResumedCounter = 0;
  private int mStartedCounter = 0;
  private boolean mStopSent = true;
  
  @NonNull
  public static LifecycleOwner get()
  {
    return sInstance;
  }
  
  static void init(Context paramContext)
  {
    sInstance.attach(paramContext);
  }
  
  void activityPaused()
  {
    this.mResumedCounter -= 1;
    if (this.mResumedCounter == 0) {
      this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700L);
    }
  }
  
  void activityResumed()
  {
    this.mResumedCounter += 1;
    if (this.mResumedCounter == 1)
    {
      if (this.mPauseSent)
      {
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mPauseSent = false;
      }
    }
    else {
      return;
    }
    this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
  }
  
  void activityStarted()
  {
    this.mStartedCounter += 1;
    if ((this.mStartedCounter == 1) && (this.mStopSent))
    {
      this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.mStopSent = false;
    }
  }
  
  void activityStopped()
  {
    this.mStartedCounter -= 1;
    dispatchStopIfNeeded();
  }
  
  void attach(Context paramContext)
  {
    this.mHandler = new Handler();
    this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new ProcessLifecycleOwner.3(this));
  }
  
  void dispatchPauseIfNeeded()
  {
    if (this.mResumedCounter == 0)
    {
      this.mPauseSent = true;
      this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }
  }
  
  void dispatchStopIfNeeded()
  {
    if ((this.mStartedCounter == 0) && (this.mPauseSent))
    {
      this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.mStopSent = true;
    }
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.mRegistry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ProcessLifecycleOwner
 * JD-Core Version:    0.7.0.1
 */