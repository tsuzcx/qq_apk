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

public class azko
  implements View.OnClickListener
{
  azko(azkm paramazkm) {}
  
  public void onClick(View paramView)
  {
    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
    azku localazku = (azku)paramView.getTag();
    String str;
    boolean bool;
    if ((localazku != null) && (localazku.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localazku.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localazku.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label256;
      }
      str = ((Friends)localazku.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localazku.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localazku.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label320;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localazku.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + bool);
        }
        if (localazku.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Azlq.b();
        }
        localazku.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localazku.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label343;
          }
          paramView.setContentDescription(localazku.d.getText().toString() + ajya.a(2131702508));
        }
      }
    }
    for (;;)
    {
      this.a.a();
      if (AppSetting.d) {
        paramView.postDelayed(new ContactListAdapter.2.1(this, paramView), 2000L);
      }
      return;
      label256:
      if ((localazku.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        str = ((PhoneContact)localazku.jdField_a_of_type_JavaLangObject).name;
        break;
      }
      if (!(localazku.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
        break;
      }
      paramView = (RelationTroopEntity)localazku.jdField_a_of_type_JavaLangObject;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(paramView.troopInfo.troopuin);
      return;
      label320:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localazku.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label343:
      paramView.setContentDescription(localazku.d.getText().toString() + ajya.a(2131702507));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azko
 * JD-Core Version:    0.7.0.1
 */