package androidx.arch.core.executor;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DefaultTaskExecutor
  extends TaskExecutor
{
  private final ExecutorService mDiskIO = Executors.newFixedThreadPool(4, new DefaultTaskExecutor.1(this));
  private final Object mLock = new Object();
  @Nullable
  private volatile Handler mMainHandler;
  
  private static Handler createAsync(@NonNull Looper paramLooper)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Handler.createAsync(paramLooper);
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, null, Boolean.valueOf(true) });
      return localHandler;
    }
    catch (IllegalAccessException|InstantiationException|NoSuchMethodException localIllegalAccessException)
    {
      break label83;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label74:
      label83:
      break label74;
    }
    return new Handler(paramLooper);
    return new Handler(paramLooper);
  }
  
  public void executeOnDiskIO(Runnable paramRunnable)
  {
    this.mDiskIO.execute(paramRunnable);
  }
  
  public boolean isMainThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public void postToMainThread(Runnable paramRunnable)
  {
    if (this.mMainHandler == null) {
      synchronized (this.mLock)
      {
        if (this.mMainHandler == null) {
          this.mMainHandler = createAsync(Looper.getMainLooper());
        }
      }
    }
    this.mMainHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.arch.core.executor.DefaultTaskExecutor
 * JD-Core Version:    0.7.0.1
 */