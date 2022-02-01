package androidx.viewpager2.widget;

class ViewPager2$2
  extends ViewPager2.OnPageChangeCallback
{
  ViewPager2$2(ViewPager2 paramViewPager2) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      this.this$0.updateCurrentItem();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.this$0.mCurrentItem != paramInt)
    {
      ViewPager2 localViewPager2 = this.this$0;
      localViewPager2.mCurrentItem = paramInt;
      localViewPager2.mAccessibilityProvider.onSetNewCurrentItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.2
 * JD-Core Version:    0.7.0.1
 */