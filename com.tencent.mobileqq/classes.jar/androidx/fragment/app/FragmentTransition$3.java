package androidx.fragment.app;

import androidx.core.os.CancellationSignal;

final class FragmentTransition$3
  implements Runnable
{
  FragmentTransition$3(FragmentTransition.Callback paramCallback, Fragment paramFragment, CancellationSignal paramCancellationSignal) {}
  
  public void run()
  {
    this.val$callback.onComplete(this.val$outFragment, this.val$signal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransition.3
 * JD-Core Version:    0.7.0.1
 */