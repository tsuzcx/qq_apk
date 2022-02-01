import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bkqt
  implements DialogInterface.OnClickListener
{
  bkqt(bkqp parambkqp, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (bkqp.a(this.jdField_a_of_type_Bkqp).isShowing()) {
      bkqp.a(this.jdField_a_of_type_Bkqp).dismiss();
    }
    aqrl.a(this.jdField_a_of_type_AndroidAppActivity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqt
 * JD-Core Version:    0.7.0.1
 */