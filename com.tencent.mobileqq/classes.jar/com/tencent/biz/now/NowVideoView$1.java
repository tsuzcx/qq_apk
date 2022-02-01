package com.tencent.biz.now;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.MessageRecord;

class NowVideoView$1
  extends Handler
{
  NowVideoView$1(NowVideoView paramNowVideoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1003: 
      if ((this.a.f != null) && (this.a.k != null) && (!this.a.l) && (this.a.p == 2))
      {
        this.a.f.a(this.a.k.frienduin, this.a.c, this.a.d, this.a.k.msgseq, false);
        return;
      }
      break;
    case 1002: 
      if ((this.a.f != null) && (this.a.k != null)) {
        this.a.f.a(this.a.k.frienduin, this.a.c, this.a.d, this.a.k.msgseq, true);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView.1
 * JD-Core Version:    0.7.0.1
 */