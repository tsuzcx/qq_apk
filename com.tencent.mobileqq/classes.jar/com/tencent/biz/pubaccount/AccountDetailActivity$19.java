package com.tencent.biz.pubaccount;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

class AccountDetailActivity$19
  implements Runnable
{
  AccountDetailActivity$19(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.a(115, this.this$0.e, (byte)1, true, 0);
    if (localObject != null)
    {
      localObject = this.this$0.a((Bitmap)localObject);
      if (localObject != null) {
        AccountDetailActivity.c(this.this$0, new AccountDetailActivity.19.1(this, (Drawable)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.19
 * JD-Core Version:    0.7.0.1
 */