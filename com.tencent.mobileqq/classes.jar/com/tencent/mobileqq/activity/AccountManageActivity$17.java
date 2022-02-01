package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
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
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == this.this$0.app)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            return;
          }
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(this.jdField_a_of_type_JavaLangString, (byte)3, false);
          SubAccountInfo localSubAccountInfo = null;
          if (localBitmap == null)
          {
            if ((AccountManageActivity.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString)) && (AccountManageActivity.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) != null))
            {
              localBitmap = (Bitmap)AccountManageActivity.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
              FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
              break label412;
            }
            localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, (byte)3);
          }
          else
          {
            AccountManageActivity.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, localBitmap);
            break label412;
          }
          String str = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          Object localObject = (ISubAccountService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISubAccountService.class, "");
          if (localObject != null) {
            localSubAccountInfo = ((ISubAccountService)localObject).getSubAccountInfo(this.jdField_a_of_type_JavaLangString);
          }
          if (!this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.isLogined())
          {
            localObject = str;
            if (localSubAccountInfo == null) {
              break label417;
            }
            localObject = str;
            if (localSubAccountInfo.subuin == null) {
              break label417;
            }
            localObject = str;
            if (!localSubAccountInfo.subuin.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
              break label417;
            }
          }
          if (!TextUtils.isEmpty(str))
          {
            localObject = str;
            if (!str.equals(this.jdField_a_of_type_JavaLangString)) {
              break label417;
            }
          }
          localObject = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          break label417;
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (this.b.equals(localObject)) || (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))) {
            break label420;
          }
          bool = true;
          if ((localFaceDrawable instanceof FaceDrawable)) {
            ((FaceDrawable)localFaceDrawable).setSupportMaskView(false);
          }
          if (QLog.isColorLevel()) {
            QLog.i("AccountManageActivity", 2, String.format("updateAccountListView %b [uin,nick]=[%s,%s]", new Object[] { Boolean.valueOf(bool), StringUtil.e(this.jdField_a_of_type_JavaLangString), localObject }));
          }
          this.this$0.runOnUiThread(new AccountManageActivity.17.1(this, bool, (String)localObject, localBitmap, localFaceDrawable));
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label412:
      FaceDrawable localFaceDrawable = null;
      continue;
      label417:
      continue;
      label420:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.17
 * JD-Core Version:    0.7.0.1
 */