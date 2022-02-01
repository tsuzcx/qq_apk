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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fillSearchConditions | sexIndex = ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject1).toString());
    }
    if ((i != 0) && (i < ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString.length))
    {
      localObject1 = this.a;
      ((StringBuilder)localObject1).append(ConditionSearchManager.jdField_a_of_type_ArrayOfJavaLangString[i]);
      ((StringBuilder)localObject1).append("、");
    }
    Object localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(localObject1[0], localObject1[1]);
    StringBuilder localStringBuilder;
    if (!ConditionSearchManager.b[0].equals(localObject1))
    {
      localStringBuilder = this.a;
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("、");
    }
    i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if ((i != 0) && (i != ConditionSearchManager.d.length - 1))
    {
      localObject1 = this.a;
      ((StringBuilder)localObject1).append(ConditionSearchManager.e[i]);
      ((StringBuilder)localObject1).append("、");
    }
    if (this.this$0.c)
    {
      if ((this.this$0.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.this$0.d))
      {
        if ("-1".equals(this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0]))
        {
          localObject1 = ((FriendsManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (localObject1 != null) {
            try
            {
              this.this$0.jdField_a_of_type_ArrayOfJavaLangString = ((Card)localObject1).strLocationCodes.split("-");
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("card.strLocationCodes = ");
                localStringBuilder.append(((Card)localObject1).strLocationCodes);
                QLog.d("AddContactsView", 2, localStringBuilder.toString());
              }
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AddContactsView", 2, "spliteLocationString | exception: ", localException1);
              }
            }
          }
        }
        try
        {
          this.this$0.jdField_a_of_type_ArrayOfJavaLangString[3] = "0";
          String str = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.this$0.jdField_a_of_type_ArrayOfJavaLangString);
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.this$0.jdField_a_of_type_ArrayOfJavaLangString);
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, str);
          if ("0".equals(this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0])) {
            break label517;
          }
          localStringBuilder = this.a;
          localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(str));
          localStringBuilder.append("、");
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label517;
          }
        }
        QLog.d("AddContactsView", 2, "parseLocationDesc", localException2);
      }
    }
    else
    {
      localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
      if (!((String)localObject2).startsWith("不限"))
      {
        localStringBuilder = this.a;
        localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String)localObject2));
        localStringBuilder.append("、");
      }
    }
    label517:
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
    if (!((String)localObject2).startsWith("不限"))
    {
      localStringBuilder = this.a;
      localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String)localObject2));
      localStringBuilder.append("、");
    }
    i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
    if (i != 0)
    {
      localObject2 = this.a;
      ((StringBuilder)localObject2).append(ConditionSearchManager.c[i]);
      ((StringBuilder)localObject2).append("、");
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new AddContactsView.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.10
 * JD-Core Version:    0.7.0.1
 */