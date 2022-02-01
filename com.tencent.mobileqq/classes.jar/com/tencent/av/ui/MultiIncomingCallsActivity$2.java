package com.tencent.av.ui;

import com.tencent.av.gaudio.Memberinfo;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class MultiIncomingCallsActivity$2
  implements Runnable
{
  MultiIncomingCallsActivity$2(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void run()
  {
    if (MultiIncomingCallsActivity.d(this.this$0) == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.this$0.l;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mTaskCheckRunnable before");
      ((StringBuilder)localObject2).append(MultiIncomingCallsActivity.e(this.this$0));
      ((StringBuilder)localObject2).append(";currentMemberSize=");
      ((StringBuilder)localObject2).append(MultiIncomingCallsActivity.b(this.this$0).size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (MultiIncomingCallsActivity.e(this.this$0))
    {
      long l = QQAudioHelper.c() / 1000L;
      localObject1 = new ArrayList();
      localObject2 = MultiIncomingCallsActivity.b(this.this$0).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Memberinfo localMemberinfo = (Memberinfo)((Iterator)localObject2).next();
        if (localMemberinfo.b + 60L > l)
        {
          ((ArrayList)localObject1).add(localMemberinfo);
        }
        else if (QLog.isColorLevel())
        {
          String str = this.this$0.l;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mTaskCheckRunnable ");
          localStringBuilder.append(localMemberinfo.b);
          localStringBuilder.append(";otherTimestamp=");
          localStringBuilder.append(l);
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      MultiIncomingCallsActivity.a(this.this$0, (ArrayList)localObject1);
    }
    MultiIncomingCallsActivity.d(this.this$0).postDelayed(MultiIncomingCallsActivity.f(this.this$0), 10000L);
    if (QLog.isColorLevel())
    {
      localObject1 = this.this$0.l;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mTaskCheckRunnable after");
      ((StringBuilder)localObject2).append(MultiIncomingCallsActivity.e(this.this$0));
      ((StringBuilder)localObject2).append(";currentMemberSize=");
      ((StringBuilder)localObject2).append(MultiIncomingCallsActivity.b(this.this$0).size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.2
 * JD-Core Version:    0.7.0.1
 */