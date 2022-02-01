package com.tencent.biz.pubaccount.weishi_new.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class RoundImageView$1
  implements Runnable
{
  RoundImageView$1(RoundImageView paramRoundImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    Bitmap localBitmap = RoundImageView.a(this.this$0, this.a);
    if (localBitmap == null) {
      return;
    }
    if (RoundImageView.a(this.this$0) == null) {
      RoundImageView.a(this.this$0, new Handler(Looper.getMainLooper(), this.this$0));
    }
    Message localMessage = RoundImageView.a(this.this$0).obtainMessage();
    localMessage.what = 101;
    localMessage.obj = localBitmap;
    RoundImageView.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundImageView.1
 * JD-Core Version:    0.7.0.1
 */