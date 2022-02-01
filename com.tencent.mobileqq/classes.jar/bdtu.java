import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class bdtu
  implements DialogInterface.OnClickListener
{
  bdtu(bdtt parambdtt, Context paramContext, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdts.a(this.jdField_a_of_type_Bdtt.a, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      bdll.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtu
 * JD-Core Version:    0.7.0.1
 */