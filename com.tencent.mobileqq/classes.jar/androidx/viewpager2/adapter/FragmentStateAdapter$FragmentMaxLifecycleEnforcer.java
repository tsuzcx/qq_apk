package androidx.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

class FragmentStateAdapter$FragmentMaxLifecycleEnforcer
{
  private RecyclerView.AdapterDataObserver mDataObserver;
  private LifecycleEventObserver mLifecycleObserver;
  private ViewPager2.OnPageChangeCallback mPageChangeCallback;
  private long mPrimaryItemId = -1L;
  private ViewPager2 mViewPager;
  
  FragmentStateAdapter$FragmentMaxLifecycleEnforcer(FragmentStateAdapter paramFragmentStateAdapter) {}
  
  @NonNull
  private ViewPager2 inferViewPager(@NonNull RecyclerView paramRecyclerView)
  {
    paramRecyclerView = paramRecyclerView.getParent();
    if ((paramRecyclerView instanceof ViewPager2)) {
      return (ViewPager2)paramRecyclerView;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected ViewPager2 instance. Got: ");
    localStringBuilder.append(paramRecyclerView);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  void register(@NonNull RecyclerView paramRecyclerView)
  {
    this.mViewPager = inferViewPager(paramRecyclerView);
    this.mPageChangeCallback = new FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1(this);
    this.mViewPager.registerOnPageChangeCallback(this.mPageChangeCallback);
    this.mDataObserver = new FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2(this);
    this.this$0.registerAdapterDataObserver(this.mDataObserver);
    this.mLifecycleObserver = new FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3(this);
    this.this$0.mLifecycle.addObserver(this.mLifecycleObserver);
  }
  
  void unregister(@NonNull RecyclerView paramRecyclerView)
  {
    inferViewPager(paramRecyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
    this.this$0.unregisterAdapterDataObserver(this.mDataObserver);
    this.this$0.mLifecycle.removeObserver(this.mLifecycleObserver);
    this.mViewPager = null;
  }
  
  void updateFragmentMaxLifecycle(boolean paramBoolean)
  {
    if (this.this$0.shouldDelayFragmentTransactions()) {
      return;
    }
    if (this.mViewPager.getScrollState() != 0) {
      return;
    }
    if (!this.this$0.mFragments.isEmpty())
    {
      if (this.this$0.getItemCount() == 0) {
        return;
      }
      int i = this.mViewPager.getCurrentItem();
      if (i >= this.this$0.getItemCount()) {
        return;
      }
      long l = this.this$0.getItemId(i);
      if ((l == this.mPrimaryItemId) && (!paramBoolean)) {
        return;
      }
      Object localObject = (Fragment)this.this$0.mFragments.get(l);
      if (localObject != null)
      {
        if (!((Fragment)localObject).isAdded()) {
          return;
        }
        this.mPrimaryItemId = l;
        FragmentTransaction localFragmentTransaction = this.this$0.mFragmentManager.beginTransaction();
        localObject = null;
        i = 0;
        while (i < this.this$0.mFragments.size())
        {
          l = this.this$0.mFragments.keyAt(i);
          Fragment localFragment = (Fragment)this.this$0.mFragments.valueAt(i);
          if (localFragment.isAdded())
          {
            if (l != this.mPrimaryItemId) {
              localFragmentTransaction.setMaxLifecycle(localFragment, Lifecycle.State.STARTED);
            } else {
              localObject = localFragment;
            }
            if (l == this.mPrimaryItemId) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            localFragment.setMenuVisibility(paramBoolean);
          }
          i += 1;
        }
        if (localObject != null) {
          localFragmentTransaction.setMaxLifecycle((Fragment)localObject, Lifecycle.State.RESUMED);
        }
        if (!localFragmentTransaction.isEmpty()) {
          localFragmentTransaction.commitNow();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer
 * JD-Core Version:    0.7.0.1
 */