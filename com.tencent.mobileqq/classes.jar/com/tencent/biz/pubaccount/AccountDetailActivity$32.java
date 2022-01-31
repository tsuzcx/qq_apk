package com.tencent.biz.pubaccount;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import bdaq;
import bdhj;
import com.tencent.qphone.base.util.QLog;

class AccountDetailActivity$32
  implements Runnable
{
  AccountDetailActivity$32(AccountDetailActivity paramAccountDetailActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      int i = bdaq.a(this.this$0, 110.0F);
      Bitmap localBitmap = bdhj.a(this.a, i, i);
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(bdhj.c(localBitmap, i, i));
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.toString());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity.32
 * JD-Core Version:    0.7.0.1
 */