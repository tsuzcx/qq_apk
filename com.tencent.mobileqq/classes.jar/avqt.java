import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class avqt
  implements DialogInterface.OnClickListener
{
  avqt(avqr paramavqr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    avqr.a(this.a, null);
    avqr.b(this.a, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqt
 * JD-Core Version:    0.7.0.1
 */