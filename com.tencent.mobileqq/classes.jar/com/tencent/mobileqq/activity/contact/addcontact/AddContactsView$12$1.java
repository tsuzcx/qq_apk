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
    if ((AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$12.this$0) != null) && (this.jdField_a_of_type_Int != 0))
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).isEmpty()) {
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$12.this$0.h instanceof FormMutiWithAvatarItem))
        {
          localObject1 = (FormMutiWithAvatarItem)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$12.this$0.h;
          if (!((FormMutiWithAvatarItem)localObject1).a()) {
            ((FormMutiWithAvatarItem)localObject1).setOverloading();
          }
          if (this.jdField_a_of_type_Int != 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700047));
            ((FormMutiWithAvatarItem)localObject1).setPeopleText(((StringBuilder)localObject2).toString());
          }
          Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            localObject2 = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
            int i = 0;
            while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
            {
              localObject2[i] = ((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
              i += 1;
            }
            ((FormMutiWithAvatarItem)localObject1).setOverimgLayout(24, 24, (String[])localObject2, AddContactsView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView$12.this$0));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.12.1
 * JD-Core Version:    0.7.0.1
 */