package androidx.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3
  implements LifecycleEventObserver
{
  FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(FragmentStateAdapter.FragmentMaxLifecycleEnforcer paramFragmentMaxLifecycleEnforcer) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    this.this$1.updateFragmentMaxLifecycle(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
 * JD-Core Version:    0.7.0.1
 */