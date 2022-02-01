package com.tencent.av.qavperf.manager;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.qavperf.report.QAVPReport;
import java.util.HashMap;
import java.util.List;

class QAVPMemoryManager$1
  implements Runnable
{
  QAVPMemoryManager$1(QAVPMemoryManager paramQAVPMemoryManager, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i2 = QAVPMemoryManager.a(this.this$0).size();
    int i1 = QAVPMemoryManager.b(this.this$0).size();
    if ((i2 != 0) && (i1 != 0))
    {
      int n = 0;
      int m = 0;
      int k = 0;
      int i = 2147483647;
      int j = 0;
      while (m < i2)
      {
        int i3 = ((Integer)QAVPMemoryManager.a(this.this$0).get(m)).intValue();
        k = Math.max(k, i3);
        i = Math.min(i, i3);
        j += i3;
        m += 1;
      }
      float f = 0.0F;
      m = n;
      while (m < i1)
      {
        f += ((Float)QAVPMemoryManager.b(this.this$0).get(m)).floatValue();
        m += 1;
      }
      j /= i2;
      f /= i1;
      HashMap localHashMap = new HashMap();
      localHashMap.put("mem_max", String.valueOf(k));
      localHashMap.put("mem_min", String.valueOf(i));
      localHashMap.put("mem_avg", String.valueOf(j));
      localHashMap.put("mem_ratio", String.valueOf(f));
      localHashMap.put("mem_warn_top", String.valueOf(QAVPMemoryManager.c(this.this$0)));
      QAVPReport.a(this.a, 34, 2, localHashMap);
      QAVPMemoryManager.d(this.this$0);
      return;
    }
    QAVPReport.a(this.a, 34, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.manager.QAVPMemoryManager.1
 * JD-Core Version:    0.7.0.1
 */