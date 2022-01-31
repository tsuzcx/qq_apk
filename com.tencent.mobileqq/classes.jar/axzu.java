import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class axzu
  implements DialogInterface.OnClickListener
{
  axzu(axzt paramaxzt, Context paramContext, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axzs.a(this.jdField_a_of_type_Axzt.a, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      axqy.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzu
 * JD-Core Version:    0.7.0.1
 */