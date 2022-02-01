package com.tencent.mobileqq.activity.aio.rebuild;

import ahia;
import android.os.Message;
import awcm;
import java.util.List;
import mqq.os.MqqHandler;

public class MultiForwardChatPie$2
  implements Runnable
{
  public MultiForwardChatPie$2(ahia paramahia) {}
  
  public void run()
  {
    List localList = awcm.a().a(this.this$0.app, this.this$0.jdField_a_of_type_Long);
    Message localMessage = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    localMessage.obj = localList;
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.2
 * JD-Core Version:    0.7.0.1
 */