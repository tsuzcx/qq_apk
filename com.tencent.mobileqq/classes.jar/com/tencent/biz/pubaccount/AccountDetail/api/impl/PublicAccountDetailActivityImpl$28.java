package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$28
  implements Runnable
{
  PublicAccountDetailActivityImpl$28(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, String paramString) {}
  
  public void run()
  {
    try
    {
      int i = DisplayUtil.a(this.this$0, 110.0F);
      Bitmap localBitmap = ImageUtil.a(this.a, i, i);
      this.this$0.bigFace = new BitmapDrawable(ImageUtil.c(localBitmap, i, i));
      this.this$0.mHandler.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, localException.toString());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.28
 * JD-Core Version:    0.7.0.1
 */