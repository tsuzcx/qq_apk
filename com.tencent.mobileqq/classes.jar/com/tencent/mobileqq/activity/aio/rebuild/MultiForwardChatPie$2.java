package com.tencent.mobileqq.activity.aio.rebuild;

import agso;
import android.os.Message;
import aupg;
import java.util.List;
import mqq.os.MqqHandler;

public class MultiForwardChatPie$2
  implements Runnable
{
  public MultiForwardChatPie$2(agso paramagso) {}
  
  public void run()
  {
    List localList = aupg.a().a(this.this$0.a, this.this$0.g);
    Message localMessage = this.this$0.b.obtainMessage(0);
    localMessage.obj = localList;
    this.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.2
 * JD-Core Version:    0.7.0.1
 */