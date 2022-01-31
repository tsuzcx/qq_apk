import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.2.1;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;

public class ayjw
  implements View.OnClickListener
{
  ayjw(ayju paramayju) {}
  
  public void onClick(View paramView)
  {
    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
    aykc localaykc = (aykc)paramView.getTag();
    String str;
    boolean bool;
    if ((localaykc != null) && (localaykc.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localaykc.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localaykc.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label256;
      }
      str = ((Friends)localaykc.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localaykc.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localaykc.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label320;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localaykc.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + bool);
        }
        if (localaykc.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Ayky.b();
        }
        localaykc.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localaykc.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label343;
          }
          paramView.setContentDescription(localaykc.d.getText().toString() + ajjy.a(2131636713));
        }
      }
    }
    for (;;)
    {
      this.a.a();
      if (AppSetting.c) {
        paramView.postDelayed(new ContactListAdapter.2.1(this, paramView), 2000L);
      }
      return;
      label256:
      if ((localaykc.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        str = ((PhoneContact)localaykc.jdField_a_of_type_JavaLangObject).name;
        break;
      }
      if (!(localaykc.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
        break;
      }
      paramView = (RelationTroopEntity)localaykc.jdField_a_of_type_JavaLangObject;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(paramView.troopInfo.troopuin);
      return;
      label320:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localaykc.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label343:
      paramView.setContentDescription(localaykc.d.getText().toString() + ajjy.a(2131636712));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayjw
 * JD-Core Version:    0.7.0.1
 */