import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bkqv
  implements DialogInterface.OnClickListener
{
  bkqv(bkqp parambkqp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bkqp.a(this.a).q = false;
    bkqp.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqv
 * JD-Core Version:    0.7.0.1
 */