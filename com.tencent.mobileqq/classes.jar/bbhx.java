import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bbhx
  implements View.OnClickListener
{
  bbhx(bbhs parambbhs, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbhs, 0);
      this.jdField_a_of_type_Bbhs.a();
    }
    try
    {
      if (this.jdField_a_of_type_Bbhs.isShowing()) {
        this.jdField_a_of_type_Bbhs.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhx
 * JD-Core Version:    0.7.0.1
 */