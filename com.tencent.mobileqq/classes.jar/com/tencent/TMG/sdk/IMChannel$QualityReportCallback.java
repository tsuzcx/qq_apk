package com.tencent.TMG.sdk;

import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.TMG.utils.QLog;

public class IMChannel$QualityReportCallback
  implements AVAppChannel.CsCmdCallback
{
  private int mNativeCallback;
  
  public IMChannel$QualityReportCallback(IMChannel paramIMChannel, int paramInt)
  {
    this.mNativeCallback = paramInt;
  }
  
  public void onError(int paramInt, String paramString)
  {
    QLog.e(IMChannel.LOGTAG, 0, "QualityReport failed: " + paramInt + " info: " + paramString);
    IMChannel.QualityReportResult localQualityReportResult = new IMChannel.QualityReportResult(this.this$0);
    localQualityReportResult.result = paramInt;
    localQualityReportResult.errorInfo = paramString;
    this.this$0.nativeQualityReportCallback(this.mNativeCallback, localQualityReportResult);
    this.mNativeCallback = 0;
  }
  
  public void onSuccess(byte[] paramArrayOfByte)
  {
    QLog.d(IMChannel.LOGTAG, 0, "QualityReport succ");
    paramArrayOfByte = new IMChannel.QualityReportResult(this.this$0);
    paramArrayOfByte.result = 0;
    this.this$0.nativeQualityReportCallback(this.mNativeCallback, paramArrayOfByte);
    this.mNativeCallback = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.IMChannel.QualityReportCallback
 * JD-Core Version:    0.7.0.1
 */