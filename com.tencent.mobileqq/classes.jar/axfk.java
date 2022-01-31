import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class axfk
  implements View.OnClickListener
{
  axfk(axfj paramaxfj, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Axfj, 1);
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
 * Qualified Name:     axfk
 * JD-Core Version:    0.7.0.1
 */