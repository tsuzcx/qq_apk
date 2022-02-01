package androidx.viewpager2.widget;

class ViewPager2$1
  extends ViewPager2.DataSetChangeObserver
{
  ViewPager2$1(ViewPager2 paramViewPager2)
  {
    super(null);
  }
  
  public void onChanged()
  {
    ViewPager2 localViewPager2 = this.this$0;
    localViewPager2.mCurrentItemDirty = true;
    localViewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.1
 * JD-Core Version:    0.7.0.1
 */