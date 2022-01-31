import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bbhb
  implements View.OnClickListener
{
  bbhb(bbgu parambbgu, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbgu, 1);
    }
    try
    {
      if (this.jdField_a_of_type_Bbgu.isShowing()) {
        this.jdField_a_of_type_Bbgu.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhb
 * JD-Core Version:    0.7.0.1
 */