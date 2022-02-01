package androidx.recyclerview.widget;

class RecyclerView$2
  implements Runnable
{
  RecyclerView$2(RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    if (this.this$0.mItemAnimator != null) {
      this.this$0.mItemAnimator.runPendingAnimations();
    }
    this.this$0.mPostedAnimatorRunner = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.2
 * JD-Core Version:    0.7.0.1
 */