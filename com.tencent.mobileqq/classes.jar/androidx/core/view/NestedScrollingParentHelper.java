package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class NestedScrollingParentHelper
{
  private int mNestedScrollAxesNonTouch;
  private int mNestedScrollAxesTouch;
  
  public NestedScrollingParentHelper(@NonNull ViewGroup paramViewGroup) {}
  
  public int getNestedScrollAxes()
  {
    return this.mNestedScrollAxesTouch | this.mNestedScrollAxesNonTouch;
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      this.mNestedScrollAxesNonTouch = paramInt1;
      return;
    }
    this.mNestedScrollAxesTouch = paramInt1;
  }
  
  public void onStopNestedScroll(@NonNull View paramView)
  {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(@NonNull View paramView, int paramInt)
  {
    if (paramInt == 1)
    {
      this.mNestedScrollAxesNonTouch = 0;
      return;
    }
    this.mNestedScrollAxesTouch = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.NestedScrollingParentHelper
 * JD-Core Version:    0.7.0.1
 */