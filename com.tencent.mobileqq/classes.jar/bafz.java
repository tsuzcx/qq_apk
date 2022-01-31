import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

class bafz
  implements View.OnClickListener
{
  bafz(bafw parambafw, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bafw.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bafw, 1);
      if (this.jdField_a_of_type_Bafw.c)
      {
        if (!this.jdField_a_of_type_Bafw.jdField_a_of_type_Boolean) {
          break label93;
        }
        this.jdField_a_of_type_Bafw.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_Bafw.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bafw.c = false;
      label93:
      try
      {
        if (this.jdField_a_of_type_Bafw.isShowing()) {
          this.jdField_a_of_type_Bafw.dismiss();
        }
        return;
      }
      catch (Exception paramView) {}
      this.jdField_a_of_type_Bafw.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_Bafw.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bafz
 * JD-Core Version:    0.7.0.1
 */