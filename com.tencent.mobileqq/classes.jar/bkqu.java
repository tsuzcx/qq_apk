import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bkqu
  implements DialogInterface.OnClickListener
{
  bkqu(bkqp parambkqp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bkqp.a(this.a).q = true;
    bkqp.b(this.a).setSelected(true);
    bkqp.a(this.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqu
 * JD-Core Version:    0.7.0.1
 */