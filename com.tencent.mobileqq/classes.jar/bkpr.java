import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bkpr
  implements DialogInterface.OnClickListener
{
  bkpr(bkpo parambkpo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bkpk)this.a.a).f(false);
    bkpo.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpr
 * JD-Core Version:    0.7.0.1
 */