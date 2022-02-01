package androidx.recyclerview.widget;

import java.util.List;
import java.util.concurrent.Executor;

class AsyncListDiffer$1
  implements Runnable
{
  AsyncListDiffer$1(AsyncListDiffer paramAsyncListDiffer, List paramList1, List paramList2, int paramInt, Runnable paramRunnable) {}
  
  public void run()
  {
    DiffUtil.DiffResult localDiffResult = DiffUtil.calculateDiff(new AsyncListDiffer.1.1(this));
    this.this$0.mMainThreadExecutor.execute(new AsyncListDiffer.1.2(this, localDiffResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListDiffer.1
 * JD-Core Version:    0.7.0.1
 */