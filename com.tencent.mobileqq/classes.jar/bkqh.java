import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bkqh
  implements DialogInterface.OnClickListener
{
  bkqh(bkqf parambkqf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bkqb)this.a.a).f(true);
    bkqf.a(this.a).setSelected(true);
    ((bkqb)this.a.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqh
 * JD-Core Version:    0.7.0.1
 */