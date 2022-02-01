import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bjfl
  implements DialogInterface.OnClickListener
{
  bjfl(bjfh parambjfh, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (bjfh.a(this.jdField_a_of_type_Bjfh).isShowing()) {
      bjfh.a(this.jdField_a_of_type_Bjfh).dismiss();
    }
    apoh.a(this.jdField_a_of_type_AndroidAppActivity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfl
 * JD-Core Version:    0.7.0.1
 */