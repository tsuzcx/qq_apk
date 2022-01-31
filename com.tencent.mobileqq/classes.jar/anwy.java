import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import mqq.app.MobileQQ;

public class anwy
  implements RadioGroup.OnCheckedChangeListener
{
  public anwy(FMActivity paramFMActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = 1;
    if (this.a.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.a.g();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null)
    {
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    }
    if ((paramInt == 2131309128) && (this.a.jdField_b_of_type_AndroidWidgetRadioButton.isChecked()))
    {
      this.a.a().f();
      FMActivity.d(this.a);
      this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
      this.a.c.setSelected(false);
      this.a.jdField_d_of_type_AndroidWidgetRadioButton.setSelected(false);
      this.a.i(false);
      paramInt = 0;
    }
    for (;;)
    {
      paramRadioGroup = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      paramRadioGroup.putInt("last_select_tab_type", paramInt);
      paramRadioGroup.commit();
      return;
      if ((paramInt == 2131303846) && (this.a.jdField_a_of_type_AndroidWidgetRadioButton.isChecked()))
      {
        this.a.a().e();
        FMActivity.e(this.a);
        if ((this.a.h == 0) && (this.a.jdField_d_of_type_Boolean)) {
          this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.c.setSelected(false);
        this.a.jdField_d_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.i(false);
        paramInt = i;
      }
      else if ((paramInt == 2131298748) && (this.a.c.isChecked()))
      {
        this.a.a().d();
        FMActivity.a(this.a, 2);
        this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.jdField_d_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.i(false);
        paramInt = 2;
      }
      else if ((paramInt == 2131313587) && (this.a.jdField_d_of_type_AndroidWidgetRadioButton.isChecked()))
      {
        FMActivity.f(this.a);
        this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.c.setSelected(false);
        this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.i(true);
        paramInt = 9;
      }
      else
      {
        paramInt = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwy
 * JD-Core Version:    0.7.0.1
 */