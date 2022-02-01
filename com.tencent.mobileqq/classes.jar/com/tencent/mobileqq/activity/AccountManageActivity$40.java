package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;

class AccountManageActivity$40
  implements DecodeTaskCompletionListener
{
  AccountManageActivity$40(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    String str;
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.a.app;
      paramBitmap = QQAppInterface.getRoundFaceBitmap(paramBitmap);
      localObject = (String)AccountManageActivity.b(this.a).getTag();
      str = (String)AccountManageActivity.c(this.a).getTag();
      if (!paramString.equals(localObject)) {
        break label80;
      }
      AccountManageActivity.b(this.a).setImageBitmap(paramBitmap);
    }
    label80:
    while (!paramString.equals(str)) {
      return;
    }
    AccountManageActivity.c(this.a).setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.40
 * JD-Core Version:    0.7.0.1
 */