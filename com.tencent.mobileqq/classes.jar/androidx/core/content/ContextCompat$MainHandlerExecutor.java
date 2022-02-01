package androidx.core.content;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

class ContextCompat$MainHandlerExecutor
  implements Executor
{
  private final Handler mHandler;
  
  ContextCompat$MainHandlerExecutor(@NonNull Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (this.mHandler.post(paramRunnable)) {
      return;
    }
    paramRunnable = new StringBuilder();
    paramRunnable.append(this.mHandler);
    paramRunnable.append(" is shutting down");
    throw new RejectedExecutionException(paramRunnable.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.ContextCompat.MainHandlerExecutor
 * JD-Core Version:    0.7.0.1
 */