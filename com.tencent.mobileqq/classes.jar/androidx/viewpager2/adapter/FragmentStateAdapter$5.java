package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class FragmentStateAdapter$5
  implements LifecycleEventObserver
{
  FragmentStateAdapter$5(FragmentStateAdapter paramFragmentStateAdapter, Handler paramHandler, Runnable paramRunnable) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (paramEvent == Lifecycle.Event.ON_DESTROY)
    {
      this.val$handler.removeCallbacks(this.val$runnable);
      paramLifecycleOwner.getLifecycle().removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.5
 * JD-Core Version:    0.7.0.1
 */