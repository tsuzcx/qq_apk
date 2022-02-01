package androidx.recyclerview.widget;

class RecyclerView$1
  implements Runnable
{
  RecyclerView$1(RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    if (this.this$0.mFirstLayoutComplete)
    {
      if (this.this$0.isLayoutRequested()) {
        return;
      }
      if (!this.this$0.mIsAttached)
      {
        this.this$0.requestLayout();
        return;
      }
      if (this.this$0.mLayoutSuppressed)
      {
        this.this$0.mLayoutWasDefered = true;
        return;
      }
      this.this$0.consumePendingUpdateOperations();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.1
 * JD-Core Version:    0.7.0.1
 */