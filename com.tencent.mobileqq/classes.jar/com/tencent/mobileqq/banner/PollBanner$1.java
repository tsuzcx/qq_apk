package com.tencent.mobileqq.banner;

import android.os.Handler.Callback;
import android.os.Message;

class PollBanner$1
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what) {
      this.a.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.PollBanner.1
 * JD-Core Version:    0.7.0.1
 */