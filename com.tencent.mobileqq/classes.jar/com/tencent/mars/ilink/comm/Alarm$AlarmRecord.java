package com.tencent.mars.ilink.comm;

import android.app.PendingIntent;

class Alarm$AlarmRecord
  implements Comparable<AlarmRecord>
{
  final long id;
  PendingIntent pendingIntent;
  long waitTime;
  
  Alarm$AlarmRecord(long paramLong1, long paramLong2, PendingIntent paramPendingIntent)
  {
    this.id = paramLong1;
    this.waitTime = paramLong2;
    this.pendingIntent = paramPendingIntent;
  }
  
  public int compareTo(AlarmRecord paramAlarmRecord)
  {
    return (int)(this.id - paramAlarmRecord.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.Alarm.AlarmRecord
 * JD-Core Version:    0.7.0.1
 */