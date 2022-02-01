package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig$Builder<T>
{
  private static Executor sDiffExecutor = null;
  private static final Object sExecutorLock = new Object();
  private Executor mBackgroundThreadExecutor;
  private final DiffUtil.ItemCallback<T> mDiffCallback;
  @Nullable
  private Executor mMainThreadExecutor;
  
  public AsyncDifferConfig$Builder(@NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    this.mDiffCallback = paramItemCallback;
  }
  
  @NonNull
  public AsyncDifferConfig<T> build()
  {
    if (this.mBackgroundThreadExecutor == null) {}
    synchronized (sExecutorLock)
    {
      if (sDiffExecutor == null) {
        sDiffExecutor = Executors.newFixedThreadPool(2);
      }
      this.mBackgroundThreadExecutor = sDiffExecutor;
      return new AsyncDifferConfig(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
    }
  }
  
  @NonNull
  public Builder<T> setBackgroundThreadExecutor(Executor paramExecutor)
  {
    this.mBackgroundThreadExecutor = paramExecutor;
    return this;
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public Builder<T> setMainThreadExecutor(Executor paramExecutor)
  {
    this.mMainThreadExecutor = paramExecutor;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncDifferConfig.Builder
 * JD-Core Version:    0.7.0.1
 */