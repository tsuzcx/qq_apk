import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bgmz
  implements View.OnClickListener
{
  bgmz(bgmu parambgmu, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bgmu, 1);
    }
    try
    {
      if (this.jdField_a_of_type_Bgmu.isShowing()) {
        this.jdField_a_of_type_Bgmu.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmz
 * JD-Core Version:    0.7.0.1
 */