package com.tencent.mobileqq.activity.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendTabView$3
  implements View.OnClickListener
{
  FriendTabView$3(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    SelectMemberBuddyListAdapter.SelectBuddyChildTag localSelectBuddyChildTag = (SelectMemberBuddyListAdapter.SelectBuddyChildTag)paramView.getTag();
    String str;
    boolean bool;
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label243;
      }
      str = ((Friends)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localSelectBuddyChildTag.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label269;
        }
        bool = this.a.a.a(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label294;
          }
          paramView.setContentDescription(localSelectBuddyChildTag.d.getText().toString() + HardCodeUtil.a(2131704968));
        }
      }
    }
    for (;;)
    {
      this.a.c();
      if (AppSetting.d) {
        paramView.postDelayed(new FriendTabView.3.1(this, paramView), 2000L);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label243:
      if (!(localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).name;
      break;
      label269:
      bool = this.a.a.a(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label294:
      paramView.setContentDescription(localSelectBuddyChildTag.d.getText().toString() + HardCodeUtil.a(2131704969));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTabView.3
 * JD-Core Version:    0.7.0.1
 */