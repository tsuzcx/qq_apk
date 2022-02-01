import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardTextOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auuz
  implements View.OnClickListener
{
  public auuz(ForwardTextOption paramForwardTextOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hideSoftInputFromWindow();
      auso localauso = new auso(this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      localauso.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692554), this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.addPreviewView(localauso.b());
      this.a.F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuz
 * JD-Core Version:    0.7.0.1
 */