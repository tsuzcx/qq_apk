import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

class bdkw
  implements View.OnClickListener
{
  bdkw(bdku parambdku, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bdku.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdku, 0);
      if (this.jdField_a_of_type_Bdku.c)
      {
        if (!this.jdField_a_of_type_Bdku.jdField_a_of_type_Boolean) {
          break label93;
        }
        this.jdField_a_of_type_Bdku.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_Bdku.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdku.c = false;
      label93:
      try
      {
        if (this.jdField_a_of_type_Bdku.isShowing()) {
          this.jdField_a_of_type_Bdku.dismiss();
        }
        return;
      }
      catch (Exception paramView) {}
      this.jdField_a_of_type_Bdku.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_Bdku.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdkw
 * JD-Core Version:    0.7.0.1
 */