package androidx.viewpager2.adapter;

class FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2
  extends FragmentStateAdapter.DataSetChangeObserver
{
  FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2(FragmentStateAdapter.FragmentMaxLifecycleEnforcer paramFragmentMaxLifecycleEnforcer)
  {
    super(null);
  }
  
  public void onChanged()
  {
    this.this$1.updateFragmentMaxLifecycle(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
 * JD-Core Version:    0.7.0.1
 */