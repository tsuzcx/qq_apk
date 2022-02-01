package androidx.viewpager2.adapter;

class FragmentStateAdapter$4
  implements Runnable
{
  FragmentStateAdapter$4(FragmentStateAdapter paramFragmentStateAdapter) {}
  
  public void run()
  {
    FragmentStateAdapter localFragmentStateAdapter = this.this$0;
    localFragmentStateAdapter.mIsInGracePeriod = false;
    localFragmentStateAdapter.gcFragments();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.4
 * JD-Core Version:    0.7.0.1
 */