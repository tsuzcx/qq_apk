import android.animation.AnimatorSet;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class bczn
  implements DialogInterface.OnDismissListener
{
  bczn(AnimatorSet paramAnimatorSet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.isRunning()) {
      this.a.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczn
 * JD-Core Version:    0.7.0.1
 */