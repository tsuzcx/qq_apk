import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class avqb
  implements DialogInterface.OnDismissListener
{
  avqb(avpx paramavpx) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a)
    {
      this.a.a = false;
      avpx.a(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqb
 * JD-Core Version:    0.7.0.1
 */