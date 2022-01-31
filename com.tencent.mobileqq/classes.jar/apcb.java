import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.database.corrupt.DBFixManager;

class apcb
  implements DialogInterface.OnClickListener
{
  apcb(apbu paramapbu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    apbu.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcb
 * JD-Core Version:    0.7.0.1
 */