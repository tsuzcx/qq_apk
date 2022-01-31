package com.tencent.mobileqq.activity.aio.helper;

import aeyn;
import android.os.Message;
import aogj;
import aomm;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AIOEmoticonGuideHelper$1
  implements Runnable
{
  public AIOEmoticonGuideHelper$1(aeyn paramaeyn) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble start loadConObj.");
    }
    aomm localaomm = (aomm)aogj.a().a(545);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = localaomm;
    aeyn.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */