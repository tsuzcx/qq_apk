import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class apxm
  implements DialogInterface.OnClickListener
{
  apxm(apxi paramapxi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.a.c();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxm
 * JD-Core Version:    0.7.0.1
 */