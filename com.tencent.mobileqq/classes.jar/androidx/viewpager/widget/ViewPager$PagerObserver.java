package androidx.viewpager.widget;

import android.database.DataSetObserver;

class ViewPager$PagerObserver
  extends DataSetObserver
{
  ViewPager$PagerObserver(ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    this.this$0.dataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.this$0.dataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.viewpager.widget.ViewPager.PagerObserver
 * JD-Core Version:    0.7.0.1
 */