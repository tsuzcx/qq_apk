import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anxn
  implements CompoundButton.OnCheckedChangeListener
{
  anxn(anxm paramanxm, BaseActivity paramBaseActivity, FormSwitchItem paramFormSwitchItem) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    Object localObject = axdx.a(anxm.a(this.jdField_a_of_type_Anxm));
    if ((!bool) && (localObject != null))
    {
      ((axdx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        bool = true;
        ((FormSwitchItem)localObject).setChecked(bool);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(anxm.a(this.jdField_a_of_type_Anxm));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      SettingCloneUtil.writeValue(anxm.a(this.jdField_a_of_type_Anxm).getApp(), anxm.a(this.jdField_a_of_type_Anxm).c(), null, "top_msg_notification_key", paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxn
 * JD-Core Version:    0.7.0.1
 */