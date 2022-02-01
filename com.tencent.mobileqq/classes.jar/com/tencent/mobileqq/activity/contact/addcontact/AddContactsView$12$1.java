package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormMutiWithAvatarItem;
import java.util.ArrayList;

class AddContactsView$12$1
  implements Runnable
{
  AddContactsView$12$1(AddContactsView.12 param12, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$12.this$0) == null) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {}
    FormMutiWithAvatarItem localFormMutiWithAvatarItem;
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$12.this$0.h instanceof FormMutiWithAvatarItem));
      localFormMutiWithAvatarItem = (FormMutiWithAvatarItem)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$12.this$0.h;
      if (!localFormMutiWithAvatarItem.a()) {
        localFormMutiWithAvatarItem.setOverloading();
      }
      if (this.jdField_a_of_type_Int != 0) {
        localFormMutiWithAvatarItem.setPeopleText(this.jdField_a_of_type_Int + HardCodeUtil.a(2131699906));
      }
    } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
    String[] arrayOfString = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      arrayOfString[i] = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
    localFormMutiWithAvatarItem.setOverimgLayout(24, 24, arrayOfString, AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$12.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.12.1
 * JD-Core Version:    0.7.0.1
 */