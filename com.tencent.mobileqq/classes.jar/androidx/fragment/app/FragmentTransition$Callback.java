package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;

abstract interface FragmentTransition$Callback
{
  public abstract void onComplete(@NonNull Fragment paramFragment, @NonNull CancellationSignal paramCancellationSignal);
  
  public abstract void onStart(@NonNull Fragment paramFragment, @NonNull CancellationSignal paramCancellationSignal);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransition.Callback
 * JD-Core Version:    0.7.0.1
 */