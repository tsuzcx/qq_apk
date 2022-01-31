package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import ayav;
import baxt;
import bbcl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.HashMap;

class AccountManageActivity$13
  implements Runnable
{
  AccountManageActivity$13(AccountManageActivity paramAccountManageActivity, QQAppInterface paramQQAppInterface, String paramString1, SimpleAccount paramSimpleAccount, String paramString2, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    boolean bool2 = false;
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
          break label327;
        }
        if ((!AccountManageActivity.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString)) || (AccountManageActivity.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) == null))
        {
          baxt localbaxt = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
          String str2 = bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          localObject2 = (ayav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
          if (localObject2 == null) {
            break label349;
          }
          localObject2 = ((ayav)localObject2).a(this.jdField_a_of_type_JavaLangString);
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
            str1 = bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          }
          boolean bool1 = bool2;
          if (!TextUtils.isEmpty(str1))
          {
            bool1 = bool2;
            if (!this.b.equals(str1)) {
              bool1 = true;
            }
          }
          if ((localbaxt instanceof baxt)) {
            ((baxt)localbaxt).a(false);
          }
          this.this$0.runOnUiThread(new AccountManageActivity.13.1(this, bool1, str1, localBitmap, localbaxt));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Bitmap localBitmap = (Bitmap)AccountManageActivity.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
      Object localObject1 = null;
      continue;
      label327:
      AccountManageActivity.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, localBitmap);
      localObject1 = null;
      continue;
      label349:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.13
 * JD-Core Version:    0.7.0.1
 */