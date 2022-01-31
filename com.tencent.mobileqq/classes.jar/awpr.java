import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class awpr
  implements DialogInterface.OnClickListener
{
  awpr(awpn paramawpn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    awpn.a(this.a, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpr
 * JD-Core Version:    0.7.0.1
 */