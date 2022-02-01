package com.tencent.biz.pubaccount.util;

import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotImageUtil;
import com.tencent.util.WeakReferenceHandler;

class ReadInJoyShareHelper$3
  implements Runnable
{
  public void run()
  {
    String str = ScreenShotImageUtil.a(this.a, "ShotCache_");
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = str;
    ReadInJoyShareHelper.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.3
 * JD-Core Version:    0.7.0.1
 */