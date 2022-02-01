package com.tencent.mobileqq.activity.messagesearch;

import android.os.Bundle;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;

class BaseMessageResultAdapter$1
  implements Runnable
{
  BaseMessageResultAdapter$1(BaseMessageResultAdapter paramBaseMessageResultAdapter, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      ??? = BaseMessageResultAdapter.d();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadMessageResult, run(), keyword = ");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(", loadType = ");
      ((StringBuilder)localObject2).append(this.b);
      QLog.i((String)???, 2, ((StringBuilder)localObject2).toString());
    }
    ??? = null;
    int i = this.b;
    boolean bool1 = true;
    if (i == 1)
    {
      ??? = this.this$0.h.getMessageFacade().a(this.a, this.this$0.g.b, this.this$0.g.a, this.this$0.g.e);
      HistoryChatMsgSearchKeyUtil.a(this.this$0.h.getCurrentAccountUin(), this.a);
    }
    else if (i == 2)
    {
      ??? = this.this$0.k;
    }
    Object localObject2 = new ArrayList();
    Object localObject4 = this.this$0.b((ChatHistorySearchData)???, (ArrayList)localObject2);
    Object localObject5;
    if (QLog.isColorLevel())
    {
      ??? = BaseMessageResultAdapter.d();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("loadMessageResult, get: messageItems[] = ");
      ((StringBuilder)localObject5).append(localObject2);
      QLog.i((String)???, 2, ((StringBuilder)localObject5).toString());
    }
    for (;;)
    {
      synchronized (this.this$0.l)
      {
        if (this.this$0.i.equals(this.a))
        {
          i = this.b;
          boolean bool2 = false;
          if (i == 1)
          {
            localObject5 = this.this$0;
            bool1 = bool2;
            if (((ArrayList)localObject2).size() < 20) {
              bool1 = true;
            }
            ((BaseMessageResultAdapter)localObject5).j = bool1;
            this.this$0.k = ((ChatHistorySearchData)localObject4);
            localObject2 = this.this$0.f.obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 1;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.c);
            ((Bundle)localObject4).putString("searchKeyword", this.a);
            ((Message)localObject2).setData((Bundle)localObject4);
            ((Message)localObject2).sendToTarget();
          }
          else if (this.b == 2)
          {
            localObject5 = this.this$0;
            if (((ArrayList)localObject2).size() >= 20) {
              break label495;
            }
            ((BaseMessageResultAdapter)localObject5).j = bool1;
            this.this$0.k = ((ChatHistorySearchData)localObject4);
            localObject2 = this.this$0.f.obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 2;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.c);
            ((Bundle)localObject4).putString("searchKeyword", this.a);
            ((Message)localObject2).setData((Bundle)localObject4);
            ((Message)localObject2).sendToTarget();
          }
        }
        return;
      }
      label495:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */