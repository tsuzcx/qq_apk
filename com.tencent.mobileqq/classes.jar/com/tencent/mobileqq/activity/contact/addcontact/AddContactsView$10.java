package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$10
  implements Runnable
{
  AddContactsView$10(AddContactsView paramAddContactsView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "fillSearchConditions | sexIndex = " + i);
    }
    if ((i != 0) && (i < ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      this.a.append(ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString[i]).append("、");
    }
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(localObject[0], localObject[1]);
    if (!ConditionSearchManager.b[0].equals(localObject)) {
      this.a.append((String)localObject).append("、");
    }
    i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if ((i != 0) && (i != ConditionSearchManager.d.length - 1)) {
      this.a.append(ConditionSearchManager.e[i]).append("、");
    }
    if (this.this$0.c) {
      if ((this.this$0.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.this$0.d)) {
        if ("-1".equals(this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0]))
        {
          localObject = ((FriendsManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (localObject == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        this.this$0.jdField_a_of_type_ArrayOfJavaLangString = ((Card)localObject).strLocationCodes.split("-");
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "card.strLocationCodes = " + ((Card)localObject).strLocationCodes);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.this$0.jdField_a_of_type_ArrayOfJavaLangString[3] = "0";
          localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.this$0.jdField_a_of_type_ArrayOfJavaLangString);
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.this$0.jdField_a_of_type_ArrayOfJavaLangString);
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, (String)localObject);
          if (!"0".equals(this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0])) {
            this.a.append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String)localObject)).append("、");
          }
          localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
          if (!((String)localObject).startsWith("不限")) {
            this.a.append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String)localObject)).append("、");
          }
          i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
          if (i != 0) {
            this.a.append(ConditionSearchManager.c[i]).append("、");
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new AddContactsView.10.1(this));
          return;
          localException1 = localException1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AddContactsView", 2, "spliteLocationString | exception: ", localException1);
          continue;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AddContactsView", 2, "parseLocationDesc", localException2);
          continue;
        }
      }
      String str = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
      if (!str.startsWith("不限")) {
        this.a.append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(str)).append("、");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.10
 * JD-Core Version:    0.7.0.1
 */