import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bgrd
  implements View.OnClickListener
{
  bgrd(bgrb parambgrb, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bgrb, 0);
    }
    try
    {
      if (this.jdField_a_of_type_Bgrb.isShowing()) {
        this.jdField_a_of_type_Bgrb.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgrd
 * JD-Core Version:    0.7.0.1
 */