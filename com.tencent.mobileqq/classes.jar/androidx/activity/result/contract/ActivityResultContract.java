package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class ActivityResultContract<I, O>
{
  @NonNull
  public abstract Intent createIntent(@NonNull Context paramContext, @SuppressLint({"UnknownNullness"}) I paramI);
  
  @Nullable
  public ActivityResultContract.SynchronousResult<O> getSynchronousResult(@NonNull Context paramContext, @SuppressLint({"UnknownNullness"}) I paramI)
  {
    return null;
  }
  
  @SuppressLint({"UnknownNullness"})
  public abstract O parseResult(int paramInt, @Nullable Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContract
 * JD-Core Version:    0.7.0.1
 */