package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

class AsyncListDiffer$MainThreadExecutor
  implements Executor
{
  final Handler mHandler = new Handler(Looper.getMainLooper());
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListDiffer.MainThreadExecutor
 * JD-Core Version:    0.7.0.1
 */