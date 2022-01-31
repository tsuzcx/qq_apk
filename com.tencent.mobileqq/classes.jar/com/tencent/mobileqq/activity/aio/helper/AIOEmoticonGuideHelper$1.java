package com.tencent.mobileqq.activity.aio.helper;

import afdc;
import android.os.Message;
import aoks;
import aoqv;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AIOEmoticonGuideHelper$1
  implements Runnable
{
  public AIOEmoticonGuideHelper$1(afdc paramafdc) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble start loadConObj.");
    }
    aoqv localaoqv = (aoqv)aoks.a().a(545);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = localaoqv;
    afdc.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */