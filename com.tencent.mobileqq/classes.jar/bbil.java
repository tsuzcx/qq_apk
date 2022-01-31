import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bbil
  implements View.OnClickListener
{
  bbil(bbig parambbig, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbig, 0);
      this.jdField_a_of_type_Bbig.a();
    }
    try
    {
      if (this.jdField_a_of_type_Bbig.isShowing()) {
        this.jdField_a_of_type_Bbig.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbil
 * JD-Core Version:    0.7.0.1
 */