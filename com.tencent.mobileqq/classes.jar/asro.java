import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class asro
  implements DialogInterface.OnClickListener
{
  asro(asrm paramasrm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    asrm.a(this.a, null);
    asrm.b(this.a, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asro
 * JD-Core Version:    0.7.0.1
 */