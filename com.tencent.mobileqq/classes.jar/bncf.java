import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bncf
  implements DialogInterface.OnClickListener
{
  bncf(bnbz parambnbz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bnbz.a(this.a).q = false;
    bnbz.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncf
 * JD-Core Version:    0.7.0.1
 */