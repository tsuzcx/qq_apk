package androidx.recyclerview.widget;

class FastScroller$2
  extends RecyclerView.OnScrollListener
{
  FastScroller$2(FastScroller paramFastScroller) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.this$0.updateScrollPosition(paramRecyclerView.computeHorizontalScrollOffset(), paramRecyclerView.computeVerticalScrollOffset());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.FastScroller.2
 * JD-Core Version:    0.7.0.1
 */