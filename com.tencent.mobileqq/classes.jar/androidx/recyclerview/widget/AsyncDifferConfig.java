package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

public final class AsyncDifferConfig<T>
{
  @NonNull
  private final Executor mBackgroundThreadExecutor;
  @NonNull
  private final DiffUtil.ItemCallback<T> mDiffCallback;
  @Nullable
  private final Executor mMainThreadExecutor;
  
  AsyncDifferConfig(@Nullable Executor paramExecutor1, @NonNull Executor paramExecutor2, @NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    this.mMainThreadExecutor = paramExecutor1;
    this.mBackgroundThreadExecutor = paramExecutor2;
    this.mDiffCallback = paramItemCallback;
  }
  
  @NonNull
  public Executor getBackgroundThreadExecutor()
  {
    return this.mBackgroundThreadExecutor;
  }
  
  @NonNull
  public DiffUtil.ItemCallback<T> getDiffCallback()
  {
    return this.mDiffCallback;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public Executor getMainThreadExecutor()
  {
    return this.mMainThreadExecutor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncDifferConfig
 * JD-Core Version:    0.7.0.1
 */