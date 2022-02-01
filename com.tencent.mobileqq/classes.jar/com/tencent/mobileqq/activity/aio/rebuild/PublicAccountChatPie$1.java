package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.os.Message;

class PublicAccountChatPie$1
  extends Handler
{
  PublicAccountChatPie$1(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 6)
            {
              if (i != 9)
              {
                if (i != 10) {
                  return;
                }
                PublicAccountChatPie.e(this.a);
                return;
              }
              PublicAccountChatPie.b(this.a, paramMessage);
              return;
            }
            PublicAccountChatPie.a(this.a, paramMessage);
            return;
          }
          PublicAccountChatPie.d(this.a);
          return;
        }
        PublicAccountChatPie.c(this.a);
        return;
      }
      PublicAccountChatPie.b(this.a);
      return;
    }
    PublicAccountChatPie.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.1
 * JD-Core Version:    0.7.0.1
 */