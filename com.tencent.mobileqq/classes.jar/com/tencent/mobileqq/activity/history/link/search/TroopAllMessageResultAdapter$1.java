package com.tencent.mobileqq.activity.history.link.search;

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

class TroopAllMessageResultAdapter$1
  implements Runnable
{
  TroopAllMessageResultAdapter$1(TroopAllMessageResultAdapter paramTroopAllMessageResultAdapter, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("loadMessageResult, run(), keyword = ");
      ((StringBuilder)???).append(this.a);
      ((StringBuilder)???).append(", loadType = ");
      ((StringBuilder)???).append(this.b);
      QLog.i("LinkMessageResultAdapter", 2, ((StringBuilder)???).toString());
    }
    ??? = null;
    int i = this.b;
    boolean bool1 = true;
    if (i == 1)
    {
      ??? = TroopAllMessageResultAdapter.d(this.this$0).getMessageFacade().a(this.a, TroopAllMessageResultAdapter.a(this.this$0).b, TroopAllMessageResultAdapter.b(this.this$0).a, TroopAllMessageResultAdapter.c(this.this$0).e);
      HistoryChatMsgSearchKeyUtil.a(TroopAllMessageResultAdapter.e(this.this$0).getCurrentAccountUin(), this.a);
    }
    else if (i == 2)
    {
      ??? = TroopAllMessageResultAdapter.i(this.this$0).getMessageFacade().a("", TroopAllMessageResultAdapter.f(this.this$0).b, TroopAllMessageResultAdapter.g(this.this$0).a, TroopAllMessageResultAdapter.h(this.this$0).e);
    }
    Object localObject2 = new ArrayList();
    Object localObject4 = TroopAllMessageResultAdapter.a(this.this$0, (ChatHistorySearchData)???, (ArrayList)localObject2);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("loadMessageResult, get: messageItems[] = ");
      ((StringBuilder)???).append(localObject2);
      QLog.i("LinkMessageResultAdapter", 2, ((StringBuilder)???).toString());
    }
    for (;;)
    {
      synchronized (this.this$0.a)
      {
        if (TroopAllMessageResultAdapter.j(this.this$0).equals(this.a))
        {
          i = this.b;
          boolean bool2 = false;
          TroopAllMessageResultAdapter localTroopAllMessageResultAdapter;
          if (i == 1)
          {
            localTroopAllMessageResultAdapter = this.this$0;
            bool1 = bool2;
            if (((ArrayList)localObject2).size() < 20) {
              bool1 = true;
            }
            TroopAllMessageResultAdapter.a(localTroopAllMessageResultAdapter, bool1);
            TroopAllMessageResultAdapter.a(this.this$0, (ChatHistorySearchData)localObject4);
            localObject2 = TroopAllMessageResultAdapter.k(this.this$0).obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 1;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.c);
            ((Bundle)localObject4).putString("searchKeyword", this.a);
            ((Message)localObject2).setData((Bundle)localObject4);
            ((Message)localObject2).sendToTarget();
          }
          else if (this.b == 2)
          {
            localTroopAllMessageResultAdapter = this.this$0;
            if (((ArrayList)localObject2).size() >= 20) {
              break label527;
            }
            TroopAllMessageResultAdapter.b(localTroopAllMessageResultAdapter, bool1);
            TroopAllMessageResultAdapter.b(this.this$0, (ChatHistorySearchData)localObject4);
            localObject2 = TroopAllMessageResultAdapter.l(this.this$0).obtainMessage(2, localObject2);
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
      label527:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */