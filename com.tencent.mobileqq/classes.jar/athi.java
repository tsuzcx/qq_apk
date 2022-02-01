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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class athi
  implements RadioGroup.OnCheckedChangeListener
{
  public athi(FMActivity paramFMActivity) {}
  
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
    if ((paramInt == 2131376261) && (this.a.jdField_b_of_type_AndroidWidgetRadioButton.isChecked()))
    {
      this.a.a().f();
      FMActivity.b(this.a);
      this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
      this.a.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(false);
      if (FMActivity.a(this.a)) {
        this.a.d.setSelected(false);
      }
      this.a.i(false);
      FMActivity.a(this.a, 1);
      i = 0;
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_type", i);
      localEditor.commit();
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      if ((paramInt == 2131370339) && (this.a.jdField_a_of_type_AndroidWidgetRadioButton.isChecked()))
      {
        this.a.a().e();
        FMActivity.c(this.a);
        if ((this.a.i == 0) && (this.a.f)) {
          this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(false);
        if (FMActivity.a(this.a)) {
          this.a.d.setSelected(false);
        }
        this.a.i(false);
        FMActivity.a(this.a, 2);
      }
      else if ((paramInt == 2131364630) && (this.a.jdField_c_of_type_AndroidWidgetRadioButton.isChecked()))
      {
        this.a.a().d();
        FMActivity.b(this.a, 2);
        this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
        if (FMActivity.a(this.a)) {
          this.a.d.setSelected(false);
        }
        this.a.i(false);
        FMActivity.a(this.a, 0);
        i = 2;
      }
      else if ((paramInt == 2131366311) && (this.a.d.isChecked()))
      {
        this.a.a().g();
        FMActivity.d(this.a);
        this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.jdField_b_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.jdField_c_of_type_AndroidWidgetRadioButton.setSelected(false);
        this.a.i(false);
        FMActivity.a(this.a, 5);
        bdll.b(this.a.app, "dc00898", "", "", "0X800AFA6", "0X800AFA6", 0, 0, "", "", "", "");
        i = 1408041718;
      }
      else
      {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athi
 * JD-Core Version:    0.7.0.1
 */