package com.tencent.av.qavperf.manager;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.qavperf.report.QAVPReport;
import java.util.HashMap;
import java.util.List;

class QAVPFpsManager$1
  implements Runnable
{
  QAVPFpsManager$1(QAVPFpsManager paramQAVPFpsManager, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i2 = QAVPFpsManager.a(this.this$0).size();
    int n = QAVPFpsManager.b(this.this$0).size();
    int i1 = QAVPFpsManager.c(this.this$0).size();
    if ((i2 != 0) && (i1 != 0) && (n != 0))
    {
      int m = 0;
      int j = 0;
      int i = 0;
      while (j < i2)
      {
        i += ((Integer)QAVPFpsManager.a(this.this$0).get(j)).intValue();
        j += 1;
      }
      float f3 = 0.0F;
      j = 0;
      float f1 = 0.0F;
      int k;
      float f2;
      for (;;)
      {
        k = m;
        f2 = f3;
        if (j >= i1) {
          break;
        }
        f1 += ((Float)QAVPFpsManager.c(this.this$0).get(j)).floatValue();
        j += 1;
      }
      while (k < n)
      {
        f2 += ((Float)QAVPFpsManager.b(this.this$0).get(k)).floatValue();
        k += 1;
      }
      i /= i2;
      f2 /= n;
      f1 /= i1;
      HashMap localHashMap = new HashMap();
      localHashMap.put("fps_avg", String.valueOf(i));
      localHashMap.put("fps_ratio", String.valueOf(f1));
      localHashMap.put("fps_draw", String.valueOf(f2));
      localHashMap.put("fps_device", String.valueOf(QAVPFpsManager.d(this.this$0)));
      localHashMap.put("fps_warn_drop", String.valueOf(QAVPFpsManager.e(this.this$0)));
      QAVPReport.a(this.a, 17, 2, localHashMap);
      QAVPFpsManager.f(this.this$0);
      return;
    }
    QAVPReport.a(this.a, 17, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.manager.QAVPFpsManager.1
 * JD-Core Version:    0.7.0.1
 */