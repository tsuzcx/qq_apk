import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhqb
  implements View.OnClickListener
{
  bhqb(bhpy parambhpy, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bhpy.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bhpy, 1);
      if (this.jdField_a_of_type_Bhpy.c)
      {
        if (!this.jdField_a_of_type_Bhpy.jdField_a_of_type_Boolean) {
          break label100;
        }
        this.jdField_a_of_type_Bhpy.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_Bhpy.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.c = false;
      try
      {
        if (this.jdField_a_of_type_Bhpy.isShowing()) {
          this.jdField_a_of_type_Bhpy.dismiss();
        }
        label92:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label100:
        this.jdField_a_of_type_Bhpy.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_Bhpy.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
      }
      catch (Exception localException)
      {
        break label92;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhqb
 * JD-Core Version:    0.7.0.1
 */