package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

class ViewPager2$RecyclerViewImpl
  extends RecyclerView
{
  ViewPager2$RecyclerViewImpl(ViewPager2 paramViewPager2, @NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  @RequiresApi(23)
  public CharSequence getAccessibilityClassName()
  {
    if (this.this$0.mAccessibilityProvider.handlesRvGetAccessibilityClassName()) {
      return this.this$0.mAccessibilityProvider.onRvGetAccessibilityClassName();
    }
    return super.getAccessibilityClassName();
  }
  
  public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setFromIndex(this.this$0.mCurrentItem);
    paramAccessibilityEvent.setToIndex(this.this$0.mCurrentItem);
    this.this$0.mAccessibilityProvider.onRvInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.this$0.isUserInputEnabled()) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.this$0.isUserInputEnabled()) && (super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.RecyclerViewImpl
 * JD-Core Version:    0.7.0.1
 */