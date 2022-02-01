import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class baks
  extends MqqHandler
{
  public baks(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
      QLog.d("IphoneTitleBarActivity", 2, "TEST more info message handler: " + paramMessage.what);
    }
    do
    {
      return;
    } while (!((String)paramMessage.obj).equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a));
    label86:
    FormSwitchItem localFormSwitchItem;
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      if (bool1 == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label154;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localFormSwitchItem = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (paramMessage.arg1 != 1) {
        break label156;
      }
    }
    label154:
    label156:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localFormSwitchItem.setChecked(bool1);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.a);
      return;
      bool1 = false;
      break label86;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baks
 * JD-Core Version:    0.7.0.1
 */