import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bkpq
  implements DialogInterface.OnClickListener
{
  bkpq(bkpo parambkpo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bkpk)this.a.a).f(true);
    bkpo.a(this.a).setSelected(true);
    ((bkpk)this.a.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpq
 * JD-Core Version:    0.7.0.1
 */