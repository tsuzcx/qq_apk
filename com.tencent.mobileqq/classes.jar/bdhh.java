import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdhh
  implements View.OnClickListener
{
  bdhh(bdhc parambdhc, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdhc, 0);
      this.jdField_a_of_type_Bdhc.a();
    }
    try
    {
      if (this.jdField_a_of_type_Bdhc.isShowing()) {
        this.jdField_a_of_type_Bdhc.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhh
 * JD-Core Version:    0.7.0.1
 */