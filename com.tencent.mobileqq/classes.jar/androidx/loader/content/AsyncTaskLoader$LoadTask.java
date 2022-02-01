package androidx.loader.content;

import androidx.core.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader$LoadTask
  extends ModernAsyncTask<Void, Void, D>
  implements Runnable
{
  private final CountDownLatch mDone = new CountDownLatch(1);
  boolean waiting;
  
  AsyncTaskLoader$LoadTask(AsyncTaskLoader paramAsyncTaskLoader) {}
  
  protected D doInBackground(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.this$0.onLoadInBackground();
      return paramVarArgs;
    }
    catch (OperationCanceledException paramVarArgs)
    {
      if (!isCancelled()) {
        throw paramVarArgs;
      }
    }
    return null;
  }
  
  protected void onCancelled(D paramD)
  {
    try
    {
      this.this$0.dispatchOnCancelled(this, paramD);
      return;
    }
    finally
    {
      this.mDone.countDown();
    }
  }
  
  protected void onPostExecute(D paramD)
  {
    try
    {
      this.this$0.dispatchOnLoadComplete(this, paramD);
      return;
    }
    finally
    {
      this.mDone.countDown();
    }
  }
  
  public void run()
  {
    this.waiting = false;
    this.this$0.executePendingTask();
  }
  
  public void waitForLoader()
  {
    try
    {
      this.mDone.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.content.AsyncTaskLoader.LoadTask
 * JD-Core Version:    0.7.0.1
 */