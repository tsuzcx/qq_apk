package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

class PublicAccountDetailActivityImpl$19
  implements Runnable
{
  PublicAccountDetailActivityImpl$19(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.getFaceBitmap(115, this.this$0.uin, (byte)1, true, 0);
    if (localObject != null)
    {
      localObject = this.this$0.getGaussianBlurPic((Bitmap)localObject);
      if (localObject != null) {
        PublicAccountDetailActivityImpl.access$1201(this.this$0, new PublicAccountDetailActivityImpl.19.1(this, (Drawable)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.19
 * JD-Core Version:    0.7.0.1
 */