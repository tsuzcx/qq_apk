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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfnb
  implements View.OnClickListener
{
  bfnb(bfmz parambfmz) {}
  
  public void onClick(View paramView)
  {
    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
    bfnh localbfnh = (bfnh)paramView.getTag();
    Object localObject;
    boolean bool;
    if ((localbfnh != null) && (localbfnh.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localbfnh.jdField_a_of_type_JavaLangObject != null))
    {
      localObject = "";
      if (!(localbfnh.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label263;
      }
      localObject = ((Friends)localbfnh.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localbfnh.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localbfnh.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label329;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localbfnh.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + bool);
        }
        if (localbfnh.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Bfod.b();
        }
        localbfnh.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localbfnh.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label352;
          }
          paramView.setContentDescription(localbfnh.d.getText().toString() + anzj.a(2131701406));
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
        if ((localbfnh.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
        {
          localObject = ((PhoneContact)localbfnh.jdField_a_of_type_JavaLangObject).name;
          break;
        }
        if (!(localbfnh.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
          break;
        }
        localObject = (RelationTroopEntity)localbfnh.jdField_a_of_type_JavaLangObject;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(((RelationTroopEntity)localObject).troopInfo.troopuin);
      }
      label329:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(localbfnh.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1");
      break label108;
      label352:
      paramView.setContentDescription(localbfnh.d.getText().toString() + anzj.a(2131701405));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnb
 * JD-Core Version:    0.7.0.1
 */