package com.tencent.imcore.message;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.ArrayList;
import java.util.List;

class C2CMessageManagerCallback$1
  implements Runnable
{
  C2CMessageManagerCallback$1(C2CMessageManagerCallback paramC2CMessageManagerCallback, C2CMessageManager paramC2CMessageManager, RefreshMessageContext paramRefreshMessageContext, int paramInt, String paramString, C2CMessageManager.C2CReplyContext paramC2CReplyContext, IMessageFacade paramIMessageFacade, Context paramContext) {}
  
  public void run()
  {
    this.a.b(this.b);
    Object localObject2 = this.a.a(this.c).g(this.d, this.c);
    Object localObject1;
    if (localObject2 != null)
    {
      long l = ((MessageRecord)((List)localObject2).get(0)).uniseq;
      localObject1 = new ArrayList();
      this.a.a(this.d, this.c, l, 200 - ((List)localObject2).size(), this.b, (ArrayList)localObject1);
      if (((ArrayList)localObject1).size() > 200 - ((List)localObject2).size()) {
        i = ((ArrayList)localObject1).size() - (200 - ((List)localObject2).size());
      } else {
        i = 0;
      }
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (ChatMessage)((ArrayList)localObject1).get(i);
        if ((!MsgProxyUtils.b((MessageRecord)localObject2)) && (((ChatMessage)localObject2).msgUid == this.e.c) && (((ChatMessage)localObject2).time == this.e.d))
        {
          i = 1;
          break label213;
        }
        i += 1;
      }
    }
    int i = 0;
    label213:
    if (i != 0)
    {
      do
      {
        do
        {
          localObject1 = this.b;
          ((RefreshMessageContext)localObject1).r = 15;
          ((RefreshMessageContext)localObject1).l = 0;
          localObject1 = this.a.a(this.d, this.c, 15, (RefreshMessageContext)localObject1, this.e);
        } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
        localObject1 = (ChatMessage)((List)localObject1).get(0);
      } while ((MsgProxyUtils.b((MessageRecord)localObject1)) || (((ChatMessage)localObject1).msgUid != this.e.c) || (((ChatMessage)localObject1).time != this.e.d));
      localObject1 = this.b;
      ((RefreshMessageContext)localObject1).i = true;
      this.f.setChangeAndNotify(localObject1);
    }
    else
    {
      this.f.getFacadeHandler().post(new C2CMessageManagerCallback.1.1(this));
    }
    this.f.getFacadeHandler().post(new C2CMessageManagerCallback.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManagerCallback.1
 * JD-Core Version:    0.7.0.1
 */