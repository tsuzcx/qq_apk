package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

class ViewPager2$3
  extends ViewPager2.OnPageChangeCallback
{
  ViewPager2$3(ViewPager2 paramViewPager2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.this$0.clearFocus();
    if (this.this$0.hasFocus()) {
      this.this$0.mRecyclerView.requestFocus(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.3
 * JD-Core Version:    0.7.0.1
 */