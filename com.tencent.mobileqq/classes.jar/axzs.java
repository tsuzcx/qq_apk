import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class axzs
  implements DialogInterface.OnClickListener
{
  axzs(axzr paramaxzr, Context paramContext, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axzq.a(this.jdField_a_of_type_Axzr.a, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      axqw.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzs
 * JD-Core Version:    0.7.0.1
 */