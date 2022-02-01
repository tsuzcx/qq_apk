package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener;

class ViewPager2$4
  implements RecyclerView.OnChildAttachStateChangeListener
{
  ViewPager2$4(ViewPager2 paramViewPager2) {}
  
  public void onChildViewAttachedToWindow(@NonNull View paramView)
  {
    paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if ((paramView.width == -1) && (paramView.height == -1)) {
      return;
    }
    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
  }
  
  public void onChildViewDetachedFromWindow(@NonNull View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.4
 * JD-Core Version:    0.7.0.1
 */