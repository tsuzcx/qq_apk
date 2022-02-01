package com.tencent.av.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.av.utils.SeqUtil;

class AVActivity$21
  extends Handler
{
  AVActivity$21(AVActivity paramAVActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 272)
    {
      super.handleMessage(paramMessage);
      return;
    }
    long l = SeqUtil.a(paramMessage.obj);
    this.a.a(l, "handleMessage", true);
    if (this.a.ad != null) {
      this.a.ad.E();
    }
    if (this.a.L != null) {
      this.a.L.o(this.a.ad.e);
    }
    this.a.h(-1031L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.21
 * JD-Core Version:    0.7.0.1
 */