import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bocr
  implements DialogInterface.OnDismissListener
{
  bocr(bocp parambocp) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (bocp.a(this.a) != null) {
      bocp.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocr
 * JD-Core Version:    0.7.0.1
 */