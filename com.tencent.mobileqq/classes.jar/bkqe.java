import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class bkqe
  implements DialogInterface.OnClickListener
{
  bkqe(bkpy parambkpy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bkpy.a(this.a).q = false;
    bkpy.b(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqe
 * JD-Core Version:    0.7.0.1
 */