package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.os.Message;

class PublicAccountChatPie$1
  extends Handler
{
  PublicAccountChatPie$1(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return;
    case 1: 
      PublicAccountChatPie.a(this.a);
      return;
    case 2: 
      PublicAccountChatPie.b(this.a);
      return;
    case 3: 
      PublicAccountChatPie.c(this.a);
      return;
    case 4: 
      PublicAccountChatPie.d(this.a);
      return;
    case 6: 
      PublicAccountChatPie.a(this.a, paramMessage);
      return;
    case 9: 
      PublicAccountChatPie.b(this.a, paramMessage);
      return;
    }
    PublicAccountChatPie.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.1
 * JD-Core Version:    0.7.0.1
 */