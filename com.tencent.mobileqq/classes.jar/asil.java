import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class asil
  implements CompoundButton.OnCheckedChangeListener
{
  asil(asik paramasik, NotifyPushSettingActivity paramNotifyPushSettingActivity, FormSwitchItem paramFormSwitchItem) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "NEW_MSG_NOTIFICATION_KEY::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!this.jdField_a_of_type_Asik.b())
    {
      this.jdField_a_of_type_Asik.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      paramBoolean = bool;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        paramBoolean = true;
      }
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_Asik.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    }
    SettingCloneUtil.writeValue(this.jdField_a_of_type_Asik.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_Asik.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "new_msg_notification_key", paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      axqw.b(null, "dc00898", "", "", "0X800A511", "0X800A511", i, 0, "", "", "", "");
      return;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asil
 * JD-Core Version:    0.7.0.1
 */