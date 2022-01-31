import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bbmq
  implements DialogInterface.OnDismissListener
{
  bbmq(bbml parambbml) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmq
 * JD-Core Version:    0.7.0.1
 */