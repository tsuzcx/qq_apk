package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;

public abstract interface ActivityResultCaller
{
  @NonNull
  public abstract <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> paramActivityResultContract, @NonNull ActivityResultCallback<O> paramActivityResultCallback);
  
  @NonNull
  public abstract <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> paramActivityResultContract, @NonNull ActivityResultRegistry paramActivityResultRegistry, @NonNull ActivityResultCallback<O> paramActivityResultCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResultCaller
 * JD-Core Version:    0.7.0.1
 */