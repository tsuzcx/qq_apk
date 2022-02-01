package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AccountManageActivity$17
  implements Runnable
{
  AccountManageActivity$17(AccountManageActivity paramAccountManageActivity, QQAppInterface paramQQAppInterface, String paramString1, SimpleAccount paramSimpleAccount, String paramString2, TextView paramTextView, ImageView paramImageView) {}
  
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
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(this.jdField_a_of_type_JavaLangString, (byte)3, false);
        if (localBitmap != null) {
          break label373;
        }
        if ((!AccountManageActivity.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString)) || (AccountManageActivity.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) == null))
        {
          FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
          String str2 = ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          localObject2 = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
          if (localObject2 == null) {
            break label399;
          }
          localObject2 = ((SubAccountManager)localObject2).a(this.jdField_a_of_type_JavaLangString);
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
            str1 = ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          }
          if ((TextUtils.isEmpty(str1)) || (this.b.equals(str1)) || (str1.equals(this.jdField_a_of_type_JavaLangString))) {
            break label394;
          }
          if ((localFaceDrawable instanceof FaceDrawable)) {
            ((FaceDrawable)localFaceDrawable).setSupportMaskView(false);
          }
          if (QLog.isColorLevel()) {
            QLog.i("AccountManageActivity", 2, String.format("updateAccountListView %b [uin,nick]=[%s,%s]", new Object[] { Boolean.valueOf(bool), StringUtil.e(this.jdField_a_of_type_JavaLangString), str1 }));
          }
          this.this$0.runOnUiThread(new AccountManageActivity.17.1(this, bool, str1, localBitmap, localFaceDrawable));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Bitmap localBitmap = (Bitmap)AccountManageActivity.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
      Object localObject1 = null;
      continue;
      label373:
      AccountManageActivity.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, localBitmap);
      localObject1 = null;
      continue;
      label394:
      bool = false;
      continue;
      label399:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.17
 * JD-Core Version:    0.7.0.1
 */