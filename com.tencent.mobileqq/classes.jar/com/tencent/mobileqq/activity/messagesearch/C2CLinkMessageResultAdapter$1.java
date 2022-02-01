package com.tencent.mobileqq.activity.messagesearch;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;

class C2CLinkMessageResultAdapter$1
  implements Runnable
{
  C2CLinkMessageResultAdapter$1(C2CLinkMessageResultAdapter paramC2CLinkMessageResultAdapter, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("loadMessageResult, run(), keyword = ");
      ((StringBuilder)???).append(this.a);
      ((StringBuilder)???).append(", loadType = ");
      ((StringBuilder)???).append(this.b);
      QLog.i("C2CLinkMessageResultAdapter", 2, ((StringBuilder)???).toString());
    }
    ??? = null;
    int i = this.b;
    boolean bool1 = true;
    if (i == 1)
    {
      ??? = this.this$0;
      ??? = ((C2CLinkMessageResultAdapter)???).a(((C2CLinkMessageResultAdapter)???).g, this.a);
      HistoryChatMsgSearchKeyUtil.a(this.this$0.h.getCurrentAccountUin(), this.a);
    }
    else if (i == 2)
    {
      ??? = this.this$0;
      ??? = ((C2CLinkMessageResultAdapter)???).a(((C2CLinkMessageResultAdapter)???).g, "");
    }
    Object localObject2 = new ArrayList();
    Object localObject4 = this.this$0.b((ChatHistorySearchData)???, (ArrayList)localObject2);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("loadMessageResult, get: messageItems[] = ");
      ((StringBuilder)???).append(localObject2);
      QLog.i("C2CLinkMessageResultAdapter", 2, ((StringBuilder)???).toString());
    }
    for (;;)
    {
      synchronized (this.this$0.a)
      {
        if (this.this$0.i.equals(this.a))
        {
          i = this.b;
          boolean bool2 = false;
          C2CLinkMessageResultAdapter localC2CLinkMessageResultAdapter;
          if (i == 1)
          {
            localC2CLinkMessageResultAdapter = this.this$0;
            bool1 = bool2;
            if (((ArrayList)localObject2).size() < 20) {
              bool1 = true;
            }
            localC2CLinkMessageResultAdapter.j = bool1;
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
            localC2CLinkMessageResultAdapter = this.this$0;
            if (((ArrayList)localObject2).size() >= 20) {
              break label469;
            }
            localC2CLinkMessageResultAdapter.j = bool1;
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
      label469:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */