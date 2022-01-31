package com.tencent.biz.subscribe.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import awmc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import vvz;
import wfw;

public class SubscribeQRCodeShareHelper$1
  implements Runnable
{
  public SubscribeQRCodeShareHelper$1(wfw paramwfw) {}
  
  public void run()
  {
    Bitmap localBitmap = vvz.a(wfw.a(this.this$0), awmc.a(63.0F), -16777216, -1, Bitmap.Config.ARGB_8888);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      QLog.d("SubscribeQRCodeShareHelper", 4, "failed to create card code");
      return;
    }
    ThreadManager.getUIHandler().post(new SubscribeQRCodeShareHelper.1.1(this, localBitmap));
    QLog.d("SubscribeQRCodeShareHelper", 4, " create card code success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1
 * JD-Core Version:    0.7.0.1
 */