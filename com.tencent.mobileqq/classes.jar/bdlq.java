import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdlq
  implements View.OnClickListener
{
  bdlq(bdll parambdll, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdll, 0);
      this.jdField_a_of_type_Bdll.a();
    }
    try
    {
      if (this.jdField_a_of_type_Bdll.isShowing()) {
        this.jdField_a_of_type_Bdll.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlq
 * JD-Core Version:    0.7.0.1
 */