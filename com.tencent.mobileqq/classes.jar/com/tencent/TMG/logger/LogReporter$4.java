package com.tencent.TMG.logger;

import android.util.Log;
import com.tencent.TMG.utils.HttpHelper.HttpRequestListener;

class LogReporter$4
  implements HttpHelper.HttpRequestListener
{
  LogReporter$4(LogReporter paramLogReporter) {}
  
  public void onCompleted(String paramString, int paramInt, byte[] paramArrayOfByte, Object paramObject)
  {
    if ((paramInt != 200) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("LogReporter", String.format("mReportLogFinishedListener|http request error code=%d", new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
    Log.i("LogReporter", String.format("mReportLogFinishedListener|upload log finish.req=%s, resp=%s", new Object[] { paramObject, new String(paramArrayOfByte) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.logger.LogReporter.4
 * JD-Core Version:    0.7.0.1
 */