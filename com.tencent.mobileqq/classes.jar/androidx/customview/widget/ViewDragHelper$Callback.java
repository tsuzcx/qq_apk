package androidx.customview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Px;

public abstract class ViewDragHelper$Callback
{
  public int clampViewPositionHorizontal(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int clampViewPositionVertical(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getOrderedChildIndex(int paramInt)
  {
    return paramInt;
  }
  
  public int getViewHorizontalDragRange(@NonNull View paramView)
  {
    return 0;
  }
  
  public int getViewVerticalDragRange(@NonNull View paramView)
  {
    return 0;
  }
  
  public void onEdgeDragStarted(int paramInt1, int paramInt2) {}
  
  public boolean onEdgeLock(int paramInt)
  {
    return false;
  }
  
  public void onEdgeTouched(int paramInt1, int paramInt2) {}
  
  public void onViewCaptured(@NonNull View paramView, int paramInt) {}
  
  public void onViewDragStateChanged(int paramInt) {}
  
  public void onViewPositionChanged(@NonNull View paramView, int paramInt1, int paramInt2, @Px int paramInt3, @Px int paramInt4) {}
  
  public void onViewReleased(@NonNull View paramView, float paramFloat1, float paramFloat2) {}
  
  public abstract boolean tryCaptureView(@NonNull View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.customview.widget.ViewDragHelper.Callback
 * JD-Core Version:    0.7.0.1
 */