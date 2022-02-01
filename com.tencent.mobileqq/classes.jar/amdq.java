import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.mobileqq.activity.selectmember.FriendTabView.3.1;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amdq
  implements View.OnClickListener
{
  public amdq(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    amfg localamfg = (amfg)paramView.getTag();
    String str;
    boolean bool;
    if ((localamfg != null) && (localamfg.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localamfg.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localamfg.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label243;
      }
      str = ((Friends)localamfg.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localamfg.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localamfg.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label269;
        }
        bool = this.a.a.a(localamfg.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localamfg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localamfg.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label294;
          }
          paramView.setContentDescription(localamfg.d.getText().toString() + anzj.a(2131703840));
        }
      }
    }
    for (;;)
    {
      this.a.c();
      if (AppSetting.c) {
        paramView.postDelayed(new FriendTabView.3.1(this, paramView), 2000L);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label243:
      if (!(localamfg.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localamfg.jdField_a_of_type_JavaLangObject).name;
      break;
      label269:
      bool = this.a.a.a(localamfg.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label294:
      paramView.setContentDescription(localamfg.d.getText().toString() + anzj.a(2131703841));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdq
 * JD-Core Version:    0.7.0.1
 */