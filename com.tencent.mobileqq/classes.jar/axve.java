import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.widget.immersive.ImmersiveUtils;

class axve
  implements DialogInterface.OnDismissListener
{
  axve(axvd paramaxvd) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.a.a.updateSystemUIVisablity();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axve
 * JD-Core Version:    0.7.0.1
 */