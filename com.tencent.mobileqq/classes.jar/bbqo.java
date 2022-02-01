import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.widget.immersive.ImmersiveUtils;

class bbqo
  implements DialogInterface.OnDismissListener
{
  bbqo(bbqn parambbqn) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.a.a.updateSystemUIVisablity();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqo
 * JD-Core Version:    0.7.0.1
 */