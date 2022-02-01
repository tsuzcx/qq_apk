package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DiscMessageProcessor$2
  implements Runnable
{
  DiscMessageProcessor$2(DiscMessageProcessor paramDiscMessageProcessor, ArrayList paramArrayList, long paramLong1, long paramLong2, String paramString, MsgInfo paramMsgInfo, long paramLong3) {}
  
  public void run()
  {
    if (this.a.contains(Long.valueOf(this.b)))
    {
      this.a.remove(Long.valueOf(this.b));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "陌生人uin包括自己,移出");
      }
    }
    if (this.a.size() != 0)
    {
      StringBuilder localStringBuilder1 = new StringBuilder(this.a.size() * 8);
      DiscMessageProcessor.a(this.this$0, localStringBuilder1, this.a, this.c);
      localStringBuilder1.append(this.d);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("show yinsi tips");
        localStringBuilder2.append(localStringBuilder1.toString());
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, localStringBuilder2.toString());
      }
      DiscMessageProcessor.a(this.this$0, this.e, this.b, this.c, this.f, localStringBuilder1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */