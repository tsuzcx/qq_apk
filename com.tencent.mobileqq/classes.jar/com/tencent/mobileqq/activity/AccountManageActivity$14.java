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

class AccountManageActivity$14
  implements Runnable
{
  AccountManageActivity$14(AccountManageActivity paramAccountManageActivity, QQAppInterface paramQQAppInterface, String paramString1, SimpleAccount paramSimpleAccount, String paramString2, TextView paramTextView, ImageView paramImageView) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.a == this.this$0.app)
        {
          if (this.a == null) {
            return;
          }
          Bitmap localBitmap = this.a.getFaceBitmap(this.b, (byte)3, false);
          SubAccountInfo localSubAccountInfo = null;
          if (localBitmap == null)
          {
            if ((AccountManageActivity.f(this.this$0).containsKey(this.b)) && (AccountManageActivity.f(this.this$0).get(this.b) != null))
            {
              localBitmap = (Bitmap)AccountManageActivity.f(this.this$0).get(this.b);
              FaceDrawable.getUserFaceDrawable(this.a, this.b, (byte)3);
              break label412;
            }
            localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.a, this.b, (byte)3);
          }
          else
          {
            AccountManageActivity.f(this.this$0).put(this.b, localBitmap);
            break label412;
          }
          String str = ContactUtils.f(this.a, this.b);
          Object localObject = (ISubAccountService)this.a.getRuntimeService(ISubAccountService.class, "");
          if (localObject != null) {
            localSubAccountInfo = ((ISubAccountService)localObject).getSubAccountInfo(this.b);
          }
          if (!this.c.isLogined())
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
            if (!localSubAccountInfo.subuin.equalsIgnoreCase(this.b)) {
              break label417;
            }
          }
          if (!TextUtils.isEmpty(str))
          {
            localObject = str;
            if (!str.equals(this.b)) {
              break label417;
            }
          }
          localObject = ContactUtils.c(this.a, this.b);
          break label417;
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (this.d.equals(localObject)) || (((String)localObject).equals(this.b))) {
            break label420;
          }
          bool = true;
          if ((localFaceDrawable instanceof FaceDrawable)) {
            ((FaceDrawable)localFaceDrawable).setSupportMaskView(false);
          }
          if (QLog.isColorLevel()) {
            QLog.i("AccountManageActivity", 2, String.format("updateAccountListView %b [uin,nick]=[%s,%s]", new Object[] { Boolean.valueOf(bool), StringUtil.getSimpleUinForPrint(this.b), localObject }));
          }
          this.this$0.runOnUiThread(new AccountManageActivity.14.1(this, bool, (String)localObject, localBitmap, localFaceDrawable));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.14
 * JD-Core Version:    0.7.0.1
 */