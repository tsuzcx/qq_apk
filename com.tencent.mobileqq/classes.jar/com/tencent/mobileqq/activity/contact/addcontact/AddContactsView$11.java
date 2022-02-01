package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$11
  extends LBSObserver
{
  AddContactsView$11(AddContactsView paramAddContactsView) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ArrayOfJavaLangString = paramLBSInfo.a();
    }
    if ((this.a.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.a.jdField_a_of_type_ArrayOfJavaLangString.length != 4)) {
      this.a.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
    }
    if (this.a.c) {
      this.a.f();
    }
    if (!"-1".equals(this.a.jdField_a_of_type_ArrayOfJavaLangString[0]))
    {
      this.a.jdField_a_of_type_ArrayOfJavaLangString[3] = "0";
      this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.a.jdField_a_of_type_ArrayOfJavaLangString);
    }
    if (QLog.isColorLevel())
    {
      paramLBSInfo = new StringBuilder();
      paramLBSInfo.append("onGetUserLocation|isSuccess : ");
      paramLBSInfo.append(paramBoolean);
      paramLBSInfo.append(", autoReqLocation : ");
      paramLBSInfo.append(this.a.c);
      paramLBSInfo.append(", locationCodes[0] : ");
      paramLBSInfo.append(this.a.jdField_a_of_type_ArrayOfJavaLangString[0]);
      QLog.d("AddContactsView", 2, paramLBSInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.11
 * JD-Core Version:    0.7.0.1
 */