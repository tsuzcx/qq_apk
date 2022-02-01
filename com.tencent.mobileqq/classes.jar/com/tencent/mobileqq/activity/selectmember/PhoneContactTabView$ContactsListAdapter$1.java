package com.tencent.mobileqq.activity.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhoneContactTabView$ContactsListAdapter$1
  implements View.OnClickListener
{
  PhoneContactTabView$ContactsListAdapter$1(PhoneContactTabView.ContactsListAdapter paramContactsListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365875) {}
    SelectActivityViewHolder localSelectActivityViewHolder;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localSelectActivityViewHolder = (SelectActivityViewHolder)paramView.getTag();
      if ((localSelectActivityViewHolder != null) && (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        PhoneContact localPhoneContact = localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
        {
          if (localSelectActivityViewHolder.jdField_a_of_type_JavaLangString.startsWith("+")) {}
          for (boolean bool = this.a.a.a.a(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.a(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
          {
            localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
            if (!AppSetting.d) {
              break;
            }
            if (!localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label266;
            }
            if (!localSelectActivityViewHolder.jdField_a_of_type_Boolean) {
              break label225;
            }
            paramView.setContentDescription(localSelectActivityViewHolder.b.getText() + this.a.a.a.getString(2131719003));
            break;
          }
          label225:
          paramView.setContentDescription(localSelectActivityViewHolder.b.getText().toString() + HardCodeUtil.a(2131707982));
        }
      }
    }
    label266:
    if (localSelectActivityViewHolder.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.a(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localSelectActivityViewHolder.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localSelectActivityViewHolder.b.getText() + this.a.a.a.getString(i));
        break;
      }
      paramView.setContentDescription(localSelectActivityViewHolder.b.getText().toString() + HardCodeUtil.a(2131707979));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.PhoneContactTabView.ContactsListAdapter.1
 * JD-Core Version:    0.7.0.1
 */