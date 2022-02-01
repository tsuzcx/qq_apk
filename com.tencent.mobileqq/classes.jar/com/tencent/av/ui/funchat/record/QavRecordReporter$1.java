package com.tencent.av.ui.funchat.record;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

final class QavRecordReporter$1
  implements Runnable
{
  QavRecordReporter$1(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, long paramLong3, long paramLong4, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    Object localObject = String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(this.a / 1000.0F) });
    float f1 = this.b;
    long l = this.c;
    int k = (int)(f1 * 1.0F / (float)(l - this.d) * 1000.0F);
    int j = (int)(this.e * 1.0F / (float)(l - this.f) * 1000.0F);
    String str = String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)this.g / 1000.0F) });
    k = Math.max(0, k);
    j = Math.max(0, j);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cores", String.valueOf(this.h));
    localHashMap.put("frequency", localObject);
    localHashMap.put("videoFps", String.valueOf(k));
    localHashMap.put("mp4Fps", String.valueOf(j));
    localHashMap.put("strDuration", str);
    localHashMap.put("stopType", String.valueOf(this.i));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRecordEnd  params=");
      ((StringBuilder)localObject).append(localHashMap);
      QLog.i("QavRecordReporter", 2, ((StringBuilder)localObject).toString());
    }
    localObject = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
    boolean bool;
    if (this.i != 3) {
      bool = true;
    } else {
      bool = false;
    }
    ((StatisticCollector)localObject).collectPerformance("", "av_record_fps", bool, this.g, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordReporter.1
 * JD-Core Version:    0.7.0.1
 */