package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;

class AccountManageActivity$37
  implements DecodeTaskCompletionListener
{
  AccountManageActivity$37(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.a.app;
      paramBitmap = QQAppInterface.getRoundFaceBitmap(paramBitmap);
      localObject = (String)AccountManageActivity.j(this.a).getTag();
      String str = (String)AccountManageActivity.k(this.a).getTag();
      if (paramString.equals(localObject))
      {
        AccountManageActivity.j(this.a).setImageBitmap(paramBitmap);
        return;
      }
      if (paramString.equals(str)) {
        AccountManageActivity.k(this.a).setImageBitmap(paramBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.37
 * JD-Core Version:    0.7.0.1
 */