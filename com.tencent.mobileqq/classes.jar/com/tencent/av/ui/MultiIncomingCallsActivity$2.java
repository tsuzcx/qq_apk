package com.tencent.av.ui;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import lqk;
import mqq.os.MqqHandler;

class MultiIncomingCallsActivity$2
  implements Runnable
{
  MultiIncomingCallsActivity$2(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void run()
  {
    if (MultiIncomingCallsActivity.a(this.this$0) == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.b, 2, "mTaskCheckRunnable before" + MultiIncomingCallsActivity.a(this.this$0) + ";currentMemberSize=" + MultiIncomingCallsActivity.a(this.this$0).size());
      }
      if (MultiIncomingCallsActivity.a(this.this$0))
      {
        long l = AudioHelper.a() / 1000L;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = MultiIncomingCallsActivity.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          lqk locallqk = (lqk)localIterator.next();
          if (locallqk.b + 60L > l) {
            localArrayList.add(locallqk);
          } else if (QLog.isColorLevel()) {
            QLog.d(this.this$0.b, 2, "mTaskCheckRunnable " + locallqk.b + ";otherTimestamp=" + l);
          }
        }
        MultiIncomingCallsActivity.a(this.this$0, localArrayList);
      }
      MultiIncomingCallsActivity.a(this.this$0).postDelayed(MultiIncomingCallsActivity.a(this.this$0), 10000L);
    } while (!QLog.isColorLevel());
    QLog.d(this.this$0.b, 2, "mTaskCheckRunnable after" + MultiIncomingCallsActivity.a(this.this$0) + ";currentMemberSize=" + MultiIncomingCallsActivity.a(this.this$0).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.2
 * JD-Core Version:    0.7.0.1
 */