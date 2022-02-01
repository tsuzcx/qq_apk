import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awxk
  implements CompoundButton.OnCheckedChangeListener
{
  awxk(awxj paramawxj, NotifyPushSettingActivity paramNotifyPushSettingActivity, FormSwitchItem paramFormSwitchItem1, FormSwitchItem paramFormSwitchItem2) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "NEW_MSG_NOTIFICATION_KEY::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!this.jdField_a_of_type_Awxj.c())
    {
      this.jdField_a_of_type_Awxj.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        bool = true;
      }
      localFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_Awxj.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    FormSwitchItem localFormSwitchItem = this.b;
    if (paramBoolean)
    {
      i = 0;
      label129:
      localFormSwitchItem.setVisibility(i);
      if (anui.a(this.jdField_a_of_type_Awxj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h()) {
        this.b.setVisibility(8);
      }
      SettingCloneUtil.writeValue(this.jdField_a_of_type_Awxj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_Awxj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, "new_msg_notification_key", paramBoolean);
      if (!paramBoolean) {
        break label227;
      }
    }
    label227:
    for (int i = j;; i = 2)
    {
      bdla.b(null, "dc00898", "", "", "0X800A511", "0X800A511", i, 0, "", "", "", "");
      break;
      i = 8;
      break label129;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxk
 * JD-Core Version:    0.7.0.1
 */