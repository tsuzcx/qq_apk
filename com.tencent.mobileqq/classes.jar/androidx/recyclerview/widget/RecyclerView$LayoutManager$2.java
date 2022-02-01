package androidx.recyclerview.widget;

import android.view.View;

class RecyclerView$LayoutManager$2
  implements ViewBoundsCheck.Callback
{
  RecyclerView$LayoutManager$2(RecyclerView.LayoutManager paramLayoutManager) {}
  
  public View getChildAt(int paramInt)
  {
    return this.this$0.getChildAt(paramInt);
  }
  
  public int getChildEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.this$0.getDecoratedBottom(paramView);
    return localLayoutParams.bottomMargin + i;
  }
  
  public int getChildStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.this$0.getDecoratedTop(paramView) - localLayoutParams.topMargin;
  }
  
  public int getParentEnd()
  {
    return this.this$0.getHeight() - this.this$0.getPaddingBottom();
  }
  
  public int getParentStart()
  {
    return this.this$0.getPaddingTop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.LayoutManager.2
 * JD-Core Version:    0.7.0.1
 */