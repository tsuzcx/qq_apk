import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhqu
  implements View.OnClickListener
{
  bhqu(bhqp parambhqp, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bhqp, 0);
      this.jdField_a_of_type_Bhqp.a();
    }
    try
    {
      if (this.jdField_a_of_type_Bhqp.isShowing()) {
        this.jdField_a_of_type_Bhqp.dismiss();
      }
      label45:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhqu
 * JD-Core Version:    0.7.0.1
 */