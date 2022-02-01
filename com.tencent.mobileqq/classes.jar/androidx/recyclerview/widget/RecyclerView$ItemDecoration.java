package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;

public abstract class RecyclerView$ItemDecoration
{
  @Deprecated
  public void getItemOffsets(@NonNull Rect paramRect, int paramInt, @NonNull RecyclerView paramRecyclerView)
  {
    paramRect.set(0, 0, 0, 0);
  }
  
  public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    getItemOffsets(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition(), paramRecyclerView);
  }
  
  @Deprecated
  public void onDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView) {}
  
  public void onDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    onDraw(paramCanvas, paramRecyclerView);
  }
  
  @Deprecated
  public void onDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView) {}
  
  public void onDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    onDrawOver(paramCanvas, paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.ItemDecoration
 * JD-Core Version:    0.7.0.1
 */