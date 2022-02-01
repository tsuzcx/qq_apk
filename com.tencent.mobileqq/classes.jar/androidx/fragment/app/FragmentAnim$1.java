package androidx.fragment.app;

import android.view.View;
import androidx.core.os.CancellationSignal.OnCancelListener;

final class FragmentAnim$1
  implements CancellationSignal.OnCancelListener
{
  FragmentAnim$1(Fragment paramFragment) {}
  
  public void onCancel()
  {
    if (this.val$fragment.getAnimatingAway() != null)
    {
      View localView = this.val$fragment.getAnimatingAway();
      this.val$fragment.setAnimatingAway(null);
      localView.clearAnimation();
    }
    this.val$fragment.setAnimator(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentAnim.1
 * JD-Core Version:    0.7.0.1
 */