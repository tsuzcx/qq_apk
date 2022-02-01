package com.tencent.TMG.logger;

import android.util.Log;
import com.tencent.TMG.utils.HttpHelper.HttpRequestListener;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class LogReporter$1
  implements HttpHelper.HttpRequestListener
{
  LogReporter$1(LogReporter paramLogReporter) {}
  
  public void onCompleted(String paramString, int paramInt, byte[] paramArrayOfByte, Object paramObject)
  {
    if ((paramInt != 200) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      Log.e("LogReporter", String.format("mLogPollerListener|http request error code=%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    for (;;)
    {
      return;
      paramString = new LogUploadMessage.Resp();
      try
      {
        paramString.mergeFrom(paramArrayOfByte);
        int i = paramString.num_log_uploads.get();
        paramInt = 0;
        while ((paramInt < i) && (paramInt < paramString.params.size()))
        {
          LogReporter.access$000(this.this$0, (LogUploadMessage.LogParam)paramString.params.get(paramInt));
          paramInt += 1;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.logger.LogReporter.1
 * JD-Core Version:    0.7.0.1
 */