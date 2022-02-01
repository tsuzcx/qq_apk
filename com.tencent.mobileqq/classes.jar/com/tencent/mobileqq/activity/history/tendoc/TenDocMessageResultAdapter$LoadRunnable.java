package com.tencent.mobileqq.activity.history.tendoc;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;

class TenDocMessageResultAdapter$LoadRunnable
  implements Runnable
{
  private int a;
  private String b;
  private long c;
  private final Object d = new Object();
  
  TenDocMessageResultAdapter$LoadRunnable(TenDocMessageResultAdapter paramTenDocMessageResultAdapter, int paramInt, String paramString, long paramLong)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramLong;
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("loadMessageResult, run(), keyword = ");
      ((StringBuilder)???).append(this.b);
      ((StringBuilder)???).append(", loadType = ");
      ((StringBuilder)???).append(this.a);
      QLog.i("TenDocMessageResultAdapter", 2, ((StringBuilder)???).toString());
    }
    Object localObject2 = new ArrayList();
    ??? = this.this$0;
    Object localObject4 = TenDocMessageResultAdapter.a((TenDocMessageResultAdapter)???, TenDocMessageResultAdapter.a((TenDocMessageResultAdapter)???), (ArrayList)localObject2);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("loadMessageResult, get: messageItems[] = ");
      ((StringBuilder)???).append(localObject2);
      QLog.i("TenDocMessageResultAdapter", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.d)
    {
      if (TenDocMessageResultAdapter.b(this.this$0).equals(this.b))
      {
        TenDocMessageResultAdapter.a(this.this$0, true);
        TenDocMessageResultAdapter.a(this.this$0, (ChatHistorySearchData)localObject4);
        localObject2 = TenDocMessageResultAdapter.c(this.this$0).obtainMessage(2, localObject2);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putLong("searchSequence", this.c);
        ((Bundle)localObject4).putString("searchKeyword", this.b);
        ((Message)localObject2).setData((Bundle)localObject4);
        ((Message)localObject2).sendToTarget();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter.LoadRunnable
 * JD-Core Version:    0.7.0.1
 */