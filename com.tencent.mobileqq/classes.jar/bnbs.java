import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bnbs
  implements DialogInterface.OnClickListener
{
  bnbs(bnbp parambnbp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bnbl)this.a.a).f(false);
    bnbp.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbs
 * JD-Core Version:    0.7.0.1
 */