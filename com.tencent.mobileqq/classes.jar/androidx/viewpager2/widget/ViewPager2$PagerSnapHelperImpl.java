package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class ViewPager2$PagerSnapHelperImpl
  extends PagerSnapHelper
{
  ViewPager2$PagerSnapHelperImpl(ViewPager2 paramViewPager2) {}
  
  @Nullable
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (this.this$0.isFakeDragging()) {
      return null;
    }
    return super.findSnapView(paramLayoutManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.PagerSnapHelperImpl
 * JD-Core Version:    0.7.0.1
 */