import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bnce
  implements DialogInterface.OnClickListener
{
  bnce(bnbz parambnbz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bnbz.a(this.a).q = true;
    bnbz.b(this.a).setSelected(true);
    bnbz.a(this.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnce
 * JD-Core Version:    0.7.0.1
 */