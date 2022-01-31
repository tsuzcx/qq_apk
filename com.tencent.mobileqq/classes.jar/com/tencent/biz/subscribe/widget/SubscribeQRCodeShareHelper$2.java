package com.tencent.biz.subscribe.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import axli;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import wiw;
import wuu;

public class SubscribeQRCodeShareHelper$2
  implements Runnable
{
  public SubscribeQRCodeShareHelper$2(wuu paramwuu) {}
  
  public void run()
  {
    Bitmap localBitmap = wiw.a(wuu.b(this.this$0), axli.a(50.0F), -16777216, -1, Bitmap.Config.ARGB_8888);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code");
      return;
    }
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.2.1(this, localBitmap));
    QLog.d("SubscribeQRCodeShareHelper", 4, " create card code success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.2
 * JD-Core Version:    0.7.0.1
 */