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

public class aonx
  implements RadioGroup.OnCheckedChangeListener
{
  public aonx(FMActivity paramFMActivity) {}
  
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
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
      this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    }
    if ((paramInt == 2131374874) && (this.a.jdField_b_of_type_AndroidWidgetRadioButton.isChecked()))
    {
      this.a.a().f();
      FMActivity.d(this.a);
      this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
      this.a.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(false);
      this.a.i(false);
      FMActivity.a(this.a, 1);
      paramInt = 0;
    }
    for (;;)
    {
      paramRadioGroup = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      paramRadioGroup.putInt("last_select_tab_type", paramInt);
      paramRadioGroup.commit();
      return;
      if ((paramInt == 2131369520) && (this.a.jdField_a_of_type_AndroidWidgetRadioButton.isChecked()))
      {
        this.a.a().e();
        FMActivity.e(this.a);
        if ((this.a.h == 0) && (this.a.d)) {
          this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.i(false);
        FMActivity.a(this.a, 2);
        paramInt = i;
      }
      else if ((paramInt == 2131364304) && (this.a.jdField_c_of_type_AndroidWidgetRadioButton.isChecked()))
      {
        this.a.a().d();
        FMActivity.b(this.a, 2);
        this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.i(false);
        FMActivity.a(this.a, 0);
        paramInt = 2;
      }
      else
      {
        paramInt = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aonx
 * JD-Core Version:    0.7.0.1
 */