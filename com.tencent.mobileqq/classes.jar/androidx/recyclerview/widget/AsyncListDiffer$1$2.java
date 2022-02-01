package androidx.recyclerview.widget;

class AsyncListDiffer$1$2
  implements Runnable
{
  AsyncListDiffer$1$2(AsyncListDiffer.1 param1, DiffUtil.DiffResult paramDiffResult) {}
  
  public void run()
  {
    if (this.this$1.this$0.mMaxScheduledGeneration == this.this$1.val$runGeneration) {
      this.this$1.this$0.latchList(this.this$1.val$newList, this.val$result, this.this$1.val$commitCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListDiffer.1.2
 * JD-Core Version:    0.7.0.1
 */