import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LoginActivity;

class bhel
  implements DialogInterface.OnDismissListener
{
  bhel(bheh parambheh) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a instanceof LoginActivity)) {
      ((LoginActivity)this.a.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhel
 * JD-Core Version:    0.7.0.1
 */