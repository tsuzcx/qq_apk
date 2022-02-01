package com.tencent.aelight.camera.aioeditor.share.impl;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class AIOShareHelperImpl$5$1
  implements Runnable
{
  AIOShareHelperImpl$5$1(AIOShareHelperImpl.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.b.this$0.dismissLoading();
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str = this.b.a.b();
    Bitmap localBitmap = this.a;
    int i;
    if (this.b.c == 9) {
      i = 0;
    } else {
      i = 1;
    }
    localWXShareHelper.a(str, localBitmap, i, false, this.b.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.5.1
 * JD-Core Version:    0.7.0.1
 */