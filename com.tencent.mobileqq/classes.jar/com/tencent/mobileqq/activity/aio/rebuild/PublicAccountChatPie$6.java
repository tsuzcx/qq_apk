package com.tencent.mobileqq.activity.aio.rebuild;

import agot;
import bdpx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class PublicAccountChatPie$6
  implements Runnable
{
  public PublicAccountChatPie$6(agot paramagot) {}
  
  public void run()
  {
    int j = agot.a(this.this$0);
    int i = j;
    if (j > 2) {
      i = 2;
    }
    List localList = this.this$0.a.a().a("2747277822", 1008, i);
    ((bdpx)this.this$0.a.a(71)).a(2, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.6
 * JD-Core Version:    0.7.0.1
 */