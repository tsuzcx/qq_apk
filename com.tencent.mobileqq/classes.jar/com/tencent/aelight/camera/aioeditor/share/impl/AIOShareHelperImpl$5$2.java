package com.tencent.aelight.camera.aioeditor.share.impl;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class AIOShareHelperImpl$5$2
  implements Runnable
{
  AIOShareHelperImpl$5$2(AIOShareHelperImpl.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.b.this$0.dismissLoading();
    WXShareHelper.a().a(this.b.a.b(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.5.2
 * JD-Core Version:    0.7.0.1
 */