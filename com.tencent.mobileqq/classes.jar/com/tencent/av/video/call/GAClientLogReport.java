package com.tencent.av.video.call;

import com.tencent.avcore.jni.log.GAClientLogReportJni;
import com.tencent.avcore.jni.log.IClientLogReport;

public class GAClientLogReport
  implements IClientLogReport
{
  private static GAClientLogReport instance;
  private final GAClientLogReportJni mJni = new GAClientLogReportJni(this);
  
  public static GAClientLogReport instance()
  {
    if (instance == null) {
      instance = new GAClientLogReport();
    }
    return instance;
  }
  
  public int sendLog(long paramLong, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return ClientLogReport.instance().sendLog(paramLong, paramInt, paramArrayOfByte, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.call.GAClientLogReport
 * JD-Core Version:    0.7.0.1
 */