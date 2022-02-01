package com.tencent.avcore.jni.log;

import com.tencent.avcore.util.AVCoreLog;

public class ClientLogReportJni
{
  private static final String TAG = "ClientLogReportJni";
  protected final IClientLogReport mImpl;
  public final boolean mNativeInit;
  
  public ClientLogReportJni(IClientLogReport paramIClientLogReport)
  {
    this.mImpl = paramIClientLogReport;
    try
    {
      cacheMethodIds();
    }
    catch (Throwable paramIClientLogReport)
    {
      for (;;)
      {
        try
        {
          init();
          this.mNativeInit = true;
          return;
        }
        catch (Throwable paramIClientLogReport)
        {
          AVCoreLog.e("ClientLogReportJni", "init fail.", paramIClientLogReport);
          return;
        }
        finally
        {
          this.mNativeInit = false;
        }
        paramIClientLogReport = paramIClientLogReport;
        AVCoreLog.e("ClientLogReportJni", "cacheMethodIds fail.", paramIClientLogReport);
      }
    }
  }
  
  private static native void cacheMethodIds();
  
  private int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    StringBuilder localStringBuilder;
    if (AVCoreLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("callbackSendLog, sendUin[").append(paramLong).append("], topicId[").append(paramInt).append("], log[");
      if (paramArrayOfByte != null) {
        break label96;
      }
    }
    label96:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayOfByte.length))
    {
      AVCoreLog.i("ClientLogReportJni", localObject + "]");
      if (this.mImpl != null) {
        i = this.mImpl.sendLog(paramLong, paramInt, paramArrayOfByte, false);
      }
      return i;
    }
  }
  
  private native void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.log.ClientLogReportJni
 * JD-Core Version:    0.7.0.1
 */