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

public class bbng
  implements View.OnClickListener
{
  bbng(bbne parambbne) {}
  
  public void onClick(View paramView)
  {
    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
    bbnm localbbnm = (bbnm)paramView.getTag();
    String str;
    boolean bool;
    if ((localbbnm != null) && (localbbnm.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localbbnm.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localbbnm.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label256;
      }
      str = ((Friends)localbbnm.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localbbnm.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localbbnm.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label320;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localbbnm.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + bool);
        }
        if (localbbnm.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Bboi.b();
        }
        localbbnm.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localbbnm.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label343;
          }
          paramView.setContentDescription(localbbnm.d.getText().toString() + alud.a(2131702892));
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
      if ((localbbnm.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        str = ((PhoneContact)localbbnm.jdField_a_of_type_JavaLangObject).name;
        break;
      }
      if (!(localbbnm.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
        break;
      }
      paramView = (RelationTroopEntity)localbbnm.jdField_a_of_type_JavaLangObject;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(paramView.troopInfo.troopuin);
      return;
      label320:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localbbnm.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label343:
      paramView.setContentDescription(localbbnm.d.getText().toString() + alud.a(2131702891));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbng
 * JD-Core Version:    0.7.0.1
 */