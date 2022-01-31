package com.tencent.mobileqq.activity.contact.addcontact;

import allj;
import aloz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$9
  implements Runnable
{
  AddContactsView$9(AddContactsView paramAddContactsView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_Allj.d();
    if (i != 0) {
      this.a.append(allj.jdField_a_of_type_ArrayOfJavaLangString[i]).append("、");
    }
    Object localObject = this.this$0.jdField_a_of_type_Allj.a();
    localObject = this.this$0.jdField_a_of_type_Allj.a(localObject[0], localObject[1]);
    if (!allj.b[0].equals(localObject)) {
      this.a.append((String)localObject).append("、");
    }
    i = this.this$0.jdField_a_of_type_Allj.b();
    if ((i != 0) && (i != allj.d.length - 1)) {
      this.a.append(allj.e[i]).append("、");
    }
    if (this.this$0.c) {
      if ((this.this$0.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.this$0.d)) {
        if ("-1".equals(this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0]))
        {
          localObject = ((aloz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
          localObject = this.this$0.jdField_a_of_type_Allj.b(this.this$0.jdField_a_of_type_ArrayOfJavaLangString);
          this.this$0.jdField_a_of_type_Allj.b(this.this$0.jdField_a_of_type_ArrayOfJavaLangString);
          this.this$0.jdField_a_of_type_Allj.a(0, (String)localObject);
          if (!"0".equals(this.this$0.jdField_a_of_type_ArrayOfJavaLangString[0])) {
            this.a.append(this.this$0.jdField_a_of_type_Allj.b((String)localObject)).append("、");
          }
          localObject = this.this$0.jdField_a_of_type_Allj.a(1);
          if (!((String)localObject).startsWith("不限")) {
            this.a.append(this.this$0.jdField_a_of_type_Allj.b((String)localObject)).append("、");
          }
          i = this.this$0.jdField_a_of_type_Allj.c();
          if (i != 0) {
            this.a.append(allj.c[i]).append("、");
          }
          this.this$0.jdField_a_of_type_Allj.b();
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new AddContactsView.9.1(this));
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
      String str = this.this$0.jdField_a_of_type_Allj.a(0);
      if (!str.startsWith("不限")) {
        this.a.append(this.this$0.jdField_a_of_type_Allj.b(str)).append("、");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.9
 * JD-Core Version:    0.7.0.1
 */