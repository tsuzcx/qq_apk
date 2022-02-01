package com.tencent.biz.qrcode.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;

class QRDisplayActivity$6$1
  implements Runnable
{
  QRDisplayActivity$6$1(QRDisplayActivity.6 param6) {}
  
  public void run()
  {
    Object localObject;
    if (this.a.this$0.t == 1)
    {
      this.a.this$0.j = this.a.this$0.app.getFaceBitmap(this.a.this$0.n, false);
      QRDisplayActivity localQRDisplayActivity = this.a.this$0;
      if (this.a.this$0.j == null) {
        localObject = ImageUtil.b(true);
      } else {
        localObject = ImageUtil.a(this.a.this$0.j, 50, 50);
      }
      localQRDisplayActivity.j = ((Bitmap)localObject);
    }
    else if (this.a.this$0.t == 2)
    {
      this.a.this$0.j = this.a.this$0.app.getTroopFaceBitmap(this.a.this$0.n, (byte)3, false, false);
      if (this.a.this$0.j == null) {
        this.a.this$0.j = ImageUtil.g();
      }
      this.a.this$0.j = ImageUtil.a(this.a.this$0.j, 50, 50);
    }
    else
    {
      localObject = this.a.this$0.C.a(this.a.this$0.n, true);
      if ((localObject instanceof BitmapDrawable)) {
        this.a.this$0.j = ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if (this.a.this$0.j == null) {
      this.a.this$0.j = ImageUtil.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.6.1
 * JD-Core Version:    0.7.0.1
 */