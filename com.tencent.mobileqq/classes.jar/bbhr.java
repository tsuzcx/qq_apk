import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

class bbhr
  implements View.OnClickListener
{
  bbhr(bbhp parambbhp, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bbhp.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbhp, 0);
      if (this.jdField_a_of_type_Bbhp.c)
      {
        if (!this.jdField_a_of_type_Bbhp.jdField_a_of_type_Boolean) {
          break label93;
        }
        this.jdField_a_of_type_Bbhp.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_Bbhp.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbhp.c = false;
      label93:
      try
      {
        if (this.jdField_a_of_type_Bbhp.isShowing()) {
          this.jdField_a_of_type_Bbhp.dismiss();
        }
        return;
      }
      catch (Exception paramView) {}
      this.jdField_a_of_type_Bbhp.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_Bbhp.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhr
 * JD-Core Version:    0.7.0.1
 */