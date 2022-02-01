package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectMemberBuddyListAdapter$1
  implements View.OnClickListener
{
  SelectMemberBuddyListAdapter$1(SelectMemberBuddyListAdapter paramSelectMemberBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "----->onBuddyListClick");
    SelectMemberBuddyListAdapter.SelectBuddyChildTag localSelectBuddyChildTag = (SelectMemberBuddyListAdapter.SelectBuddyChildTag)paramView.getTag();
    boolean bool;
    Object localObject;
    if ((localSelectBuddyChildTag != null) && (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject != null))
    {
      if (!localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()) {
        break label291;
      }
      if (localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label230;
      }
      bool = true;
      localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if ((localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        localObject = (Friends)localSelectBuddyChildTag.jdField_a_of_type_JavaLangObject;
        localObject = ResultRecord.a(((Friends)localObject).uin, ((Friends)localObject).name, 1);
        if (!bool) {
          break label235;
        }
        this.a.a.add(localObject);
      }
      label116:
      if (AppSetting.d)
      {
        if (!localSelectBuddyChildTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label251;
        }
        paramView.setContentDescription(localSelectBuddyChildTag.d.getText().toString() + HardCodeUtil.a(2131713690));
      }
      label169:
      this.a.notifyDataSetChanged();
      if (AppSetting.d) {
        paramView.postDelayed(new SelectMemberBuddyListAdapter.1.1(this, paramView), 2000L);
      }
    }
    for (;;)
    {
      if (SelectMemberBuddyListAdapter.a(this.a) != null) {
        SelectMemberBuddyListAdapter.a(this.a).onClick(paramView);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label230:
      bool = false;
      break;
      label235:
      this.a.a.remove(localObject);
      break label116;
      label251:
      paramView.setContentDescription(localSelectBuddyChildTag.d.getText().toString() + HardCodeUtil.a(2131713700));
      break label169;
      label291:
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.SelectMemberBuddyListAdapter.1
 * JD-Core Version:    0.7.0.1
 */