package com.tencent.ark;

import android.text.TextUtils;
import java.util.HashMap;

public class ArkPerfMonitor
{
  private static final ArkPerfMonitor _instance = new ArkPerfMonitor();
  private HashMap<ArkPerfMonitor.PerfRecordKey, ArkPerfMonitor.PerfRecord> _records = new HashMap();
  
  public static ArkPerfMonitor getInstance()
  {
    return _instance;
  }
  
  public void addRecord(String paramString1, String paramString2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (paramLong < 30L) {
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
      localPerfRecord1.totalTime += paramLong;
      localPerfRecord1.count += 1;
      return;
    }
  }
  
  public void doReport(String paramString1, String paramString2, ArkPerfMonitor.IReport paramIReport)
  {
    int i = 0;
    synchronized (this._records)
    {
      ArkPerfMonitor.PerfRecord localPerfRecord = (ArkPerfMonitor.PerfRecord)this._records.get(new ArkPerfMonitor.PerfRecordKey(paramString1, paramString2));
      if (localPerfRecord != null)
      {
        i = (int)(localPerfRecord.totalTime / localPerfRecord.count);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkPerfMonitor
 * JD-Core Version:    0.7.0.1
 */