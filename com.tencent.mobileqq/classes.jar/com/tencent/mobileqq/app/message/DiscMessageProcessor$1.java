package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import android.util.Pair;
import java.util.ArrayList;

class DiscMessageProcessor$1
  implements Runnable
{
  DiscMessageProcessor$1(DiscMessageProcessor paramDiscMessageProcessor, long paramLong1, long paramLong2, Pair paramPair1, MsgInfo paramMsgInfo, long paramLong3, long paramLong4, byte paramByte, long paramLong5, Pair paramPair2, ArrayList paramArrayList) {}
  
  public void run()
  {
    long l1 = this.a;
    long l2 = this.b;
    if (l1 != l2)
    {
      DiscMessageProcessor.a(this.this$0, this.c, this.d, l2, this.e, this.f, this.g, this.h, this.i);
      return;
    }
    DiscMessageProcessor.a(this.this$0, this.c, this.d, this.j, l2, String.valueOf(this.e), this.g, this.h, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */