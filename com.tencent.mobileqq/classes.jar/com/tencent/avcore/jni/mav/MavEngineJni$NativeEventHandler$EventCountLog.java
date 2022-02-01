package com.tencent.avcore.jni.mav;

import com.tencent.avcore.util.AVCoreLog;

class MavEngineJni$NativeEventHandler$EventCountLog
{
  int eventCount = 0;
  long intervalMS;
  long logTime = 0L;
  String tag;
  
  MavEngineJni$NativeEventHandler$EventCountLog(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventCountLog_");
    localStringBuilder.append(paramString);
    this.tag = localStringBuilder.toString();
    this.intervalMS = paramLong;
  }
  
  void log()
  {
    if (!AVCoreLog.isColorLevel()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    this.eventCount += 1;
    long l2 = this.logTime;
    if (l2 < l1)
    {
      long l3 = this.intervalMS;
      this.logTime = (l1 + l3);
      String str = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EventCountLog, eventCount[");
      localStringBuilder.append(this.eventCount);
      localStringBuilder.append("], intervalMS[");
      localStringBuilder.append(l1 + l3 - l2);
      localStringBuilder.append("]");
      AVCoreLog.i(str, localStringBuilder.toString());
      this.eventCount = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.mav.MavEngineJni.NativeEventHandler.EventCountLog
 * JD-Core Version:    0.7.0.1
 */