package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;

class FragmentManager$2
  implements FragmentTransition.Callback
{
  FragmentManager$2(FragmentManager paramFragmentManager) {}
  
  public void onComplete(@NonNull Fragment paramFragment, @NonNull CancellationSignal paramCancellationSignal)
  {
    if (!paramCancellationSignal.isCanceled()) {
      this.this$0.removeCancellationSignal(paramFragment, paramCancellationSignal);
    }
  }
  
  public void onStart(@NonNull Fragment paramFragment, @NonNull CancellationSignal paramCancellationSignal)
  {
    this.this$0.addCancellationSignal(paramFragment, paramCancellationSignal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager.2
 * JD-Core Version:    0.7.0.1
 */