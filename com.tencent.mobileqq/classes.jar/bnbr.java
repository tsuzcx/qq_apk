import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bnbr
  implements DialogInterface.OnClickListener
{
  bnbr(bnbp parambnbp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bnbl)this.a.a).f(true);
    bnbp.a(this.a).setSelected(true);
    ((bnbl)this.a.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbr
 * JD-Core Version:    0.7.0.1
 */