package com.tencent.mobileqq.app;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.GVideoGrayConfig.GVideoGrayConfigListener;
import com.tencent.av.utils.GVideoGrayConfig.Record;

class QQGAudioMsgHandler$1
  implements GVideoGrayConfig.GVideoGrayConfigListener
{
  QQGAudioMsgHandler$1(QQGAudioMsgHandler paramQQGAudioMsgHandler, long paramLong, int paramInt) {}
  
  public void a(int paramInt1, GVideoGrayConfig.Record paramRecord, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.c.b.a(10, 1, this.a, null, this.b);
      this.c.b.a(7, this.a, 2, 0, 0, 21, this.b);
      this.c.b.a(21, 1, this.a, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.1
 * JD-Core Version:    0.7.0.1
 */