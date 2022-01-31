import android.animation.AnimatorSet;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class bbat
  implements DialogInterface.OnDismissListener
{
  bbat(AnimatorSet paramAnimatorSet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.isRunning()) {
      this.a.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbat
 * JD-Core Version:    0.7.0.1
 */