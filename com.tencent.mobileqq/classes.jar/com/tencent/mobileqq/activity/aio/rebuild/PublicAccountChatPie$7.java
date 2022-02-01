package com.tencent.mobileqq.activity.aio.rebuild;

import ainh;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import java.util.List;

public class PublicAccountChatPie$7
  implements Runnable
{
  public PublicAccountChatPie$7(ainh paramainh) {}
  
  public void run()
  {
    int j = ainh.a(this.this$0);
    int i = j;
    if (j > 2) {
      i = 2;
    }
    List localList = this.this$0.a.a().a("2747277822", 1008, i);
    ((VasExtensionHandler)this.this$0.a.a(71)).a(2, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.7
 * JD-Core Version:    0.7.0.1
 */