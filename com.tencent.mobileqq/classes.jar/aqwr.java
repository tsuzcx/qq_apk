import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aqwr
  implements DialogInterface.OnClickListener
{
  aqwr(aqwp paramaqwp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aqwp.a(this.a, null);
    aqwp.b(this.a, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqwr
 * JD-Core Version:    0.7.0.1
 */