package androidx.recyclerview.widget;

class SnapHelper$1
  extends RecyclerView.OnScrollListener
{
  boolean mScrolled = false;
  
  SnapHelper$1(SnapHelper paramSnapHelper) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.mScrolled))
    {
      this.mScrolled = false;
      this.this$0.snapToTargetExistingView();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.mScrolled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.SnapHelper.1
 * JD-Core Version:    0.7.0.1
 */