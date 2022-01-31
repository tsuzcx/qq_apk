package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import azyu;
import bcxb;
import bdbt;
import bdje;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AccountManageActivity$14
  implements Runnable
{
  AccountManageActivity$14(AccountManageActivity paramAccountManageActivity, QQAppInterface paramQQAppInterface, String paramString1, SimpleAccount paramSimpleAccount, String paramString2, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != this.this$0.app) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_JavaLangString, (byte)3, false);
        if (localBitmap != null) {
          break label372;
        }
        if ((!AccountManageActivity.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString)) || (AccountManageActivity.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) == null))
        {
          bcxb localbcxb = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
          String str2 = bdbt.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          localObject2 = (azyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
          if (localObject2 == null) {
            break label398;
          }
          localObject2 = ((azyu)localObject2).a(this.jdField_a_of_type_JavaLangString);
          String str1;
          if (!this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.isLogined())
          {
            str1 = str2;
            if (localObject2 != null)
            {
              str1 = str2;
              if (((SubAccountInfo)localObject2).subuin != null)
              {
                str1 = str2;
                if (!((SubAccountInfo)localObject2).subuin.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {}
              }
            }
          }
          else if (!TextUtils.isEmpty(str2))
          {
            str1 = str2;
            if (!str2.equals(this.jdField_a_of_type_JavaLangString)) {}
          }
          else
          {
            str1 = bdbt.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          }
          if ((TextUtils.isEmpty(str1)) || (this.b.equals(str1)) || (str1.equals(this.jdField_a_of_type_JavaLangString))) {
            break label393;
          }
          if ((localbcxb instanceof bcxb)) {
            ((bcxb)localbcxb).a(false);
          }
          if (QLog.isColorLevel()) {
            QLog.i("AccountManageActivity", 2, String.format("updateAccountListView %b [uin,nick]=[%s,%s]", new Object[] { Boolean.valueOf(bool), bdje.e(this.jdField_a_of_type_JavaLangString), str1 }));
          }
          this.this$0.runOnUiThread(new AccountManageActivity.14.1(this, bool, str1, localBitmap, localbcxb));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Bitmap localBitmap = (Bitmap)AccountManageActivity.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
      Object localObject1 = null;
      continue;
      label372:
      AccountManageActivity.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, localBitmap);
      localObject1 = null;
      continue;
      label393:
      bool = false;
      continue;
      label398:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.14
 * JD-Core Version:    0.7.0.1
 */