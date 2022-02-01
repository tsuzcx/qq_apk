package androidx.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class FragmentStateAdapter$2
  implements LifecycleEventObserver
{
  FragmentStateAdapter$2(FragmentStateAdapter paramFragmentStateAdapter, FragmentViewHolder paramFragmentViewHolder) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (this.this$0.shouldDelayFragmentTransactions()) {
      return;
    }
    paramLifecycleOwner.getLifecycle().removeObserver(this);
    if (ViewCompat.isAttachedToWindow(this.val$holder.getContainer())) {
      this.this$0.placeFragmentInViewHolder(this.val$holder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.2
 * JD-Core Version:    0.7.0.1
 */