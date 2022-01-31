import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class ayfn
  implements View.OnClickListener
{
  ayfn(ayfm paramayfm, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Ayfm, 1);
    }
    try
    {
      if (this.jdField_a_of_type_Ayfm.isShowing()) {
        this.jdField_a_of_type_Ayfm.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfn
 * JD-Core Version:    0.7.0.1
 */