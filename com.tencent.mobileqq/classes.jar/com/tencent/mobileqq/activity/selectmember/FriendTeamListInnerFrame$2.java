package com.tencent.mobileqq.activity.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.RelationFriendsTroopViewHelper;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendTeamListInnerFrame$2
  implements View.OnClickListener
{
  FriendTeamListInnerFrame$2(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    SelectMemberBuddyListAdapter.SelectBuddyChildTag localSelectBuddyChildTag = (SelectMemberBuddyListAdapter.SelectBuddyChildTag)paramView.getTag();
    Object localObject;
    boolean bool;
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject != null))
    {
      localObject = "";
      if (!(localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label263;
      }
      localObject = ((Friends)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localSelectBuddyChildTag.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label339;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        if (localSelectBuddyChildTag.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopRelationFriendsTroopViewHelper.b();
        }
        localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label362;
          }
          paramView.setContentDescription(localSelectBuddyChildTag.d.getText().toString() + HardCodeUtil.a(2131704971));
        }
      }
    }
    for (;;)
    {
      this.a.f();
      if (AppSetting.d) {
        paramView.postDelayed(new FriendTeamListInnerFrame.2.1(this, paramView), 2000L);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label263:
        if ((localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
        {
          localObject = ((PhoneContact)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject).name;
          break;
        }
        if (!(localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
          break;
        }
        localObject = (RelationTroopEntity)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject;
        this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f(((RelationTroopEntity)localObject).troopInfo.troopuin);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopRelationFriendsTroopViewHelper.d();
      }
      label339:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localSelectBuddyChildTag.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1");
      break label108;
      label362:
      paramView.setContentDescription(localSelectBuddyChildTag.d.getText().toString() + HardCodeUtil.a(2131704970));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame.2
 * JD-Core Version:    0.7.0.1
 */