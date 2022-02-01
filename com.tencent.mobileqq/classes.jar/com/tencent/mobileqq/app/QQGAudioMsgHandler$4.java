package com.tencent.mobileqq.app;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.utils.GVideoGrayConfig.GVideoGrayConfigListener;
import com.tencent.av.utils.GVideoGrayConfig.Record;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.groupvideo.GroupVideoWrapper;

class QQGAudioMsgHandler$4
  implements GVideoGrayConfig.GVideoGrayConfigListener
{
  QQGAudioMsgHandler$4(QQGAudioMsgHandler paramQQGAudioMsgHandler, long paramLong1, int paramInt, long paramLong2) {}
  
  public void a(int paramInt1, GVideoGrayConfig.Record paramRecord, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (this.d.b != null)
      {
        this.d.b.a(3, this.a, this.b, 0, 0, 20, 1);
        this.d.b.b(this.a, true);
        this.d.b.a(21, 1, Long.valueOf(this.a).longValue(), 0L);
      }
      VideoMsgTools.a(this.d.a, 1, 13, false, Long.toString(this.a), Long.toString(this.c), false, null, false, this.b, new Object[0]);
      if (this.b == 2)
      {
        new GroupVideoWrapper(this.d.a).a(new QQGAudioMsgHandler.4.1(this));
        return;
      }
      new QavWrapper(BaseApplication.getContext()).a(new QQGAudioMsgHandler.4.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.4
 * JD-Core Version:    0.7.0.1
 */