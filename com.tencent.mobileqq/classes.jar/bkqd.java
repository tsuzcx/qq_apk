import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bkqd
  implements DialogInterface.OnClickListener
{
  bkqd(bkpy parambkpy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bkpy.a(this.a).q = true;
    bkpy.b(this.a).setSelected(true);
    bkpy.a(this.a).d(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqd
 * JD-Core Version:    0.7.0.1
 */