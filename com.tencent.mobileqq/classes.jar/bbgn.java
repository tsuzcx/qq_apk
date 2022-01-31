import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bbgn
  implements View.OnClickListener
{
  bbgn(bbgg parambbgg, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbgg, 1);
    }
    try
    {
      if (this.jdField_a_of_type_Bbgg.isShowing()) {
        this.jdField_a_of_type_Bbgg.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbgn
 * JD-Core Version:    0.7.0.1
 */