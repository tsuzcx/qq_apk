import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DirectForwardActivity;

class aqfh
  implements DialogInterface.OnDismissListener
{
  aqfh(aqfd paramaqfd) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a instanceof DirectForwardActivity)) {
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfh
 * JD-Core Version:    0.7.0.1
 */