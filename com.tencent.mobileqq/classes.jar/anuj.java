import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anuj
  implements CompoundButton.OnCheckedChangeListener
{
  anuj(anui paramanui, BaseActivity paramBaseActivity, FormSwitchItem paramFormSwitchItem) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    Object localObject = awxj.a(anui.a(this.jdField_a_of_type_Anui));
    if ((!bool) && (localObject != null))
    {
      ((awxj)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        bool = true;
        ((FormSwitchItem)localObject).setChecked(bool);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(anui.a(this.jdField_a_of_type_Anui));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      SettingCloneUtil.writeValue(anui.a(this.jdField_a_of_type_Anui).getApp(), anui.a(this.jdField_a_of_type_Anui).getCurrentUin(), null, "top_msg_notification_key", paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anuj
 * JD-Core Version:    0.7.0.1
 */