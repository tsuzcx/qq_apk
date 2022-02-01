package androidx.activity.result.contract;

import android.annotation.SuppressLint;

public final class ActivityResultContract$SynchronousResult<T>
{
  @SuppressLint({"UnknownNullness"})
  private final T mValue;
  
  public ActivityResultContract$SynchronousResult(@SuppressLint({"UnknownNullness"}) T paramT)
  {
    this.mValue = paramT;
  }
  
  @SuppressLint({"UnknownNullness"})
  public T getValue()
  {
    return this.mValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContract.SynchronousResult
 * JD-Core Version:    0.7.0.1
 */