package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AssociatedAccountActivity$14
  extends SubAccountBindObserver
{
  AssociatedAccountActivity$14(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((paramSubAccountBackProtocData == null) || (!TextUtils.equals(paramSubAccountBackProtocData.b, this.a.app.getCurrentUin()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      paramSubAccountBackProtocData = paramSubAccountBackProtocData.c();
    } while ((paramSubAccountBackProtocData == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramSubAccountBackProtocData.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (paramSubAccountBackProtocData.size() != this.a.a.size()) {
        i = j;
      }
      while (i != 0)
      {
        AssociatedAccountActivity.b(this.a, false);
        return;
      }
      break;
    }
  }
  
  public void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramSubAccountBackProtocData == null) || (!TextUtils.equals(paramSubAccountBackProtocData.b, this.a.app.getCurrentUin()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
  
  public void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.jdField_a_of_type_Int + " errMsg=" + paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramSubAccountBackProtocData == null) || (!TextUtils.equals(paramSubAccountBackProtocData.b, this.a.app.getCurrentUin()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.14
 * JD-Core Version:    0.7.0.1
 */