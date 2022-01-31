import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;

public final class bjag
  implements DialogInterface.OnDismissListener
{
  public bjag(FragmentActivity paramFragmentActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjag
 * JD-Core Version:    0.7.0.1
 */