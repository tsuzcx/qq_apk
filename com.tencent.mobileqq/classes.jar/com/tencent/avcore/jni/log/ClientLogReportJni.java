package com.tencent.avcore.jni.log;

import com.tencent.avcore.util.AVCoreLog;

public class ClientLogReportJni
{
  private static final String TAG = "ClientLogReportJni";
  protected final IClientLogReport mImpl;
  public final boolean mNativeInit;
  
  /* Error */
  public ClientLogReportJni(IClientLogReport paramIClientLogReport)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 19	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 21	com/tencent/avcore/jni/log/ClientLogReportJni:mImpl	Lcom/tencent/avcore/jni/log/IClientLogReport;
    //   9: invokestatic 24	com/tencent/avcore/jni/log/ClientLogReportJni:cacheMethodIds	()V
    //   12: goto +12 -> 24
    //   15: astore_1
    //   16: ldc 8
    //   18: ldc 26
    //   20: aload_1
    //   21: invokestatic 32	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   24: iconst_0
    //   25: istore_2
    //   26: aload_0
    //   27: invokespecial 35	com/tencent/avcore/jni/log/ClientLogReportJni:init	()V
    //   30: iconst_1
    //   31: istore_2
    //   32: aload_0
    //   33: iload_2
    //   34: putfield 37	com/tencent/avcore/jni/log/ClientLogReportJni:mNativeInit	Z
    //   37: return
    //   38: astore_1
    //   39: goto +15 -> 54
    //   42: astore_1
    //   43: ldc 8
    //   45: ldc 39
    //   47: aload_1
    //   48: invokestatic 32	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   51: goto -19 -> 32
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 37	com/tencent/avcore/jni/log/ClientLogReportJni:mNativeInit	Z
    //   59: goto +5 -> 64
    //   62: aload_1
    //   63: athrow
    //   64: goto -2 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ClientLogReportJni
    //   0	67	1	paramIClientLogReport	IClientLogReport
    //   25	9	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	12	15	java/lang/Throwable
    //   26	30	38	finally
    //   43	51	38	finally
    //   26	30	42	java/lang/Throwable
  }
  
  private static native void cacheMethodIds();
  
  private int callbackSendLog(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    if (AVCoreLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callbackSendLog, sendUin[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], topicId[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], log[");
      if (paramArrayOfByte == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramArrayOfByte.length);
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      AVCoreLog.i("ClientLogReportJni", localStringBuilder.toString());
    }
    int i = 0;
    Object localObject = this.mImpl;
    if (localObject != null) {
      i = ((IClientLogReport)localObject).sendLog(paramLong, paramString, paramArrayOfByte, false);
    }
    return i;
  }
  
  private native void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.log.ClientLogReportJni
 * JD-Core Version:    0.7.0.1
 */