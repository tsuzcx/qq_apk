package androidx.viewpager2.adapter;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

class FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1
  extends ViewPager2.OnPageChangeCallback
{
  FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1(FragmentStateAdapter.FragmentMaxLifecycleEnforcer paramFragmentMaxLifecycleEnforcer) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.this$1.updateFragmentMaxLifecycle(false);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.this$1.updateFragmentMaxLifecycle(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
 * JD-Core Version:    0.7.0.1
 */