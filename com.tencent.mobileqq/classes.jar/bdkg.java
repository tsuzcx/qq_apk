import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdkg
  implements View.OnClickListener
{
  bdkg(bdjz parambdjz, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdjz, 1);
    }
    try
    {
      if (this.jdField_a_of_type_Bdjz.isShowing()) {
        this.jdField_a_of_type_Bdjz.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdkg
 * JD-Core Version:    0.7.0.1
 */