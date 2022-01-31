import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class bkqi
  implements DialogInterface.OnClickListener
{
  bkqi(bkqf parambkqf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((bkqb)this.a.a).f(false);
    bkqf.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqi
 * JD-Core Version:    0.7.0.1
 */