import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.2.1;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdwl
  implements View.OnClickListener
{
  bdwl(bdwj parambdwj) {}
  
  public void onClick(View paramView)
  {
    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
    bdwr localbdwr = (bdwr)paramView.getTag();
    Object localObject;
    boolean bool;
    if ((localbdwr != null) && (localbdwr.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localbdwr.jdField_a_of_type_JavaLangObject != null))
    {
      localObject = "";
      if (!(localbdwr.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label263;
      }
      localObject = ((Friends)localbdwr.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localbdwr.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localbdwr.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label329;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localbdwr.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + bool);
        }
        if (localbdwr.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Bdxn.b();
        }
        localbdwr.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localbdwr.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label352;
          }
          paramView.setContentDescription(localbdwr.d.getText().toString() + amtj.a(2131701641));
        }
      }
    }
    for (;;)
    {
      this.a.a();
      if (AppSetting.c) {
        paramView.postDelayed(new ContactListAdapter.2.1(this, paramView), 2000L);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label263:
        if ((localbdwr.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
        {
          localObject = ((PhoneContact)localbdwr.jdField_a_of_type_JavaLangObject).name;
          break;
        }
        if (!(localbdwr.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
          break;
        }
        localObject = (RelationTroopEntity)localbdwr.jdField_a_of_type_JavaLangObject;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(((RelationTroopEntity)localObject).troopInfo.troopuin);
      }
      label329:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localbdwr.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1");
      break label108;
      label352:
      paramView.setContentDescription(localbdwr.d.getText().toString() + amtj.a(2131701640));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwl
 * JD-Core Version:    0.7.0.1
 */