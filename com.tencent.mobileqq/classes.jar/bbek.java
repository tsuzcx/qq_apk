import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;

class bbek
  implements DialogInterface.OnDismissListener
{
  bbek(bbeg parambbeg) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a instanceof LoginActivity)) {
      ((LoginActivity)this.a.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbek
 * JD-Core Version:    0.7.0.1
 */