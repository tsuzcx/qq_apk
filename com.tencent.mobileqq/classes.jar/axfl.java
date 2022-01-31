import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class axfl
  implements View.OnClickListener
{
  axfl(axfj paramaxfj, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Axfj, 0);
    }
    try
    {
      if (this.jdField_a_of_type_Axfj.isShowing()) {
        this.jdField_a_of_type_Axfj.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axfl
 * JD-Core Version:    0.7.0.1
 */