package com.tencent.mobileqq.activity.aio.rebuild;

import aimn;
import android.os.Message;
import axpf;
import java.util.List;
import mqq.os.MqqHandler;

public class MultiForwardChatPie$2
  implements Runnable
{
  public MultiForwardChatPie$2(aimn paramaimn) {}
  
  public void run()
  {
    List localList = axpf.a().a(this.this$0.a, this.this$0.e);
    Message localMessage = this.this$0.b.obtainMessage(0);
    localMessage.obj = localList;
    this.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.2
 * JD-Core Version:    0.7.0.1
 */