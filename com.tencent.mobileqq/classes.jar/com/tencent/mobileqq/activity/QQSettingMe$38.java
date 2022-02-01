package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;
import java.util.HashSet;

class QQSettingMe$38
  extends FriendListObserver
{
  QQSettingMe$38(QQSettingMe paramQQSettingMe) {}
  
  public void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramHashSet.contains(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.38.1(this));
    }
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1) && (this.a.c)) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.38.2(this));
    }
  }
  
  public void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int k = 0;
    String str;
    int i;
    if ((paramBoolean) && (this.a.c) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (str != null)
      {
        j = k;
        if (i < paramArrayOfString.length)
        {
          if (!str.equals(paramArrayOfString[i])) {
            break label97;
          }
          j = 1;
        }
      }
      if (j != 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.38.3(this));
      }
      return;
      label97:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.38
 * JD-Core Version:    0.7.0.1
 */