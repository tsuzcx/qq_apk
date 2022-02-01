package com.tencent.ark;

import android.text.TextUtils;
import java.util.HashMap;

class ArkPerfMonitor
{
  private static final ArkPerfMonitor _instance = new ArkPerfMonitor();
  private final HashMap<ArkPerfMonitor.PerfRecordKey, ArkPerfMonitor.PerfRecord> _records = new HashMap();
  
  public static ArkPerfMonitor getInstance()
  {
    return _instance;
  }
  
  public void addRecord(String paramString1, String paramString2, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (paramLong < 30L) {
        return;
      }
      synchronized (this._records)
      {
        ArkPerfMonitor.PerfRecord localPerfRecord2 = (ArkPerfMonitor.PerfRecord)this._records.get(new ArkPerfMonitor.PerfRecordKey(paramString1, paramString2));
        ArkPerfMonitor.PerfRecord localPerfRecord1 = localPerfRecord2;
        if (localPerfRecord2 == null)
        {
          localPerfRecord1 = new ArkPerfMonitor.PerfRecord(null);
          this._records.put(new ArkPerfMonitor.PerfRecordKey(paramString1, paramString2), localPerfRecord1);
        }
        double d1 = localPerfRecord1.totalTime;
        double d2 = paramLong;
        Double.isNaN(d2);
        localPerfRecord1.totalTime = (d1 + d2);
        localPerfRecord1.count += 1;
        return;
      }
    }
  }
  
  public void doReport(String paramString1, String paramString2, ArkPerfMonitor.IReport paramIReport)
  {
    synchronized (this._records)
    {
      ArkPerfMonitor.PerfRecord localPerfRecord = (ArkPerfMonitor.PerfRecord)this._records.get(new ArkPerfMonitor.PerfRecordKey(paramString1, paramString2));
      int i = 0;
      if (localPerfRecord != null)
      {
        double d1 = localPerfRecord.totalTime;
        i = localPerfRecord.count;
        double d2 = i;
        Double.isNaN(d2);
        i = (int)(d1 / d2);
        localPerfRecord.count = 0;
        localPerfRecord.totalTime = 0.0D;
      }
      if ((i != 0) && (paramIReport != null)) {
        paramIReport.report(paramString1, paramString2, i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkPerfMonitor
 * JD-Core Version:    0.7.0.1
 */