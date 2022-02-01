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
    this.tag = ("EventCountLog_" + paramString);
    this.intervalMS = paramLong;
  }
  
  void log()
  {
    if (!AVCoreLog.isColorLevel()) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      this.eventCount += 1;
    } while (this.logTime >= l1);
    long l2 = this.intervalMS;
    long l3 = this.logTime;
    this.logTime = (l1 + this.intervalMS);
    AVCoreLog.i(this.tag, "EventCountLog, eventCount[" + this.eventCount + "], intervalMS[" + (l2 + l1 - l3) + "]");
    this.eventCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.mav.MavEngineJni.NativeEventHandler.EventCountLog
 * JD-Core Version:    0.7.0.1
 */