package com.tencent.mobileqq.app;

import java.util.Comparator;

class QQGAudioMsgHandler$SortByTime
  implements Comparator<QQGAudioMsgHandler.DoubleMeetingMsgWapper>
{
  public int a(QQGAudioMsgHandler.DoubleMeetingMsgWapper paramDoubleMeetingMsgWapper1, QQGAudioMsgHandler.DoubleMeetingMsgWapper paramDoubleMeetingMsgWapper2)
  {
    if (paramDoubleMeetingMsgWapper1.b < paramDoubleMeetingMsgWapper2.b) {
      return -1;
    }
    if (paramDoubleMeetingMsgWapper1.b > paramDoubleMeetingMsgWapper2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.SortByTime
 * JD-Core Version:    0.7.0.1
 */