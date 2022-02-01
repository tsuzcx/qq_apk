package com.tencent.mobileqq.activity.history.link.search;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;

class LinkMessageResultAdapter$1
  implements Runnable
{
  LinkMessageResultAdapter$1(LinkMessageResultAdapter paramLinkMessageResultAdapter, String paramString, int paramInt, long paramLong) {}
  
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
      ??? = this.this$0;
      ??? = ((LinkMessageResultAdapter)???).a(LinkMessageResultAdapter.a((LinkMessageResultAdapter)???), this.a);
      HistoryChatMsgSearchKeyUtil.a(LinkMessageResultAdapter.b(this.this$0).getCurrentAccountUin(), this.a);
    }
    else if (i == 2)
    {
      ??? = this.this$0;
      ??? = ((LinkMessageResultAdapter)???).a(LinkMessageResultAdapter.c((LinkMessageResultAdapter)???), "");
    }
    Object localObject2 = new ArrayList();
    Object localObject4 = LinkMessageResultAdapter.a(this.this$0, (ChatHistorySearchData)???, (ArrayList)localObject2);
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
        if (LinkMessageResultAdapter.d(this.this$0).equals(this.a))
        {
          i = this.b;
          boolean bool2 = false;
          LinkMessageResultAdapter localLinkMessageResultAdapter;
          if (i == 1)
          {
            localLinkMessageResultAdapter = this.this$0;
            bool1 = bool2;
            if (((ArrayList)localObject2).size() < 20) {
              bool1 = true;
            }
            LinkMessageResultAdapter.a(localLinkMessageResultAdapter, bool1);
            LinkMessageResultAdapter.a(this.this$0, (ChatHistorySearchData)localObject4);
            localObject2 = LinkMessageResultAdapter.e(this.this$0).obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 1;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.c);
            ((Bundle)localObject4).putString("searchKeyword", this.a);
            ((Message)localObject2).setData((Bundle)localObject4);
            ((Message)localObject2).sendToTarget();
          }
          else if (this.b == 2)
          {
            localLinkMessageResultAdapter = this.this$0;
            if (((ArrayList)localObject2).size() >= 20) {
              break label468;
            }
            LinkMessageResultAdapter.b(localLinkMessageResultAdapter, bool1);
            LinkMessageResultAdapter.b(this.this$0, (ChatHistorySearchData)localObject4);
            localObject2 = LinkMessageResultAdapter.f(this.this$0).obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 2;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.c);
            ((Bundle)localObject4).putString("searchKeyword", this.a);
            ((Message)localObject2).setData((Bundle)localObject4);
          }
        }
        return;
      }
      label468:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */