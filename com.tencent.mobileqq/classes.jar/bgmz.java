import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bgmz
  implements DialogInterface.OnDismissListener
{
  bgmz(bgmt parambgmt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    bgmt.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgmz
 * JD-Core Version:    0.7.0.1
 */