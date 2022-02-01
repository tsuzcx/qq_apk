package androidx.recyclerview.widget;

import android.view.View;

class RecyclerView$LayoutManager$1
  implements ViewBoundsCheck.Callback
{
  RecyclerView$LayoutManager$1(RecyclerView.LayoutManager paramLayoutManager) {}
  
  public View getChildAt(int paramInt)
  {
    return this.this$0.getChildAt(paramInt);
  }
  
  public int getChildEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.this$0.getDecoratedRight(paramView);
    return localLayoutParams.rightMargin + i;
  }
  
  public int getChildStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedLeft(paramView) - localLayoutParams.leftMargin;
  }
  
  public int getParentEnd()
  {
    return this.this$0.getWidth() - this.this$0.getPaddingRight();
  }
  
  public int getParentStart()
  {
    return this.this$0.getPaddingLeft();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.LayoutManager.1
 * JD-Core Version:    0.7.0.1
 */