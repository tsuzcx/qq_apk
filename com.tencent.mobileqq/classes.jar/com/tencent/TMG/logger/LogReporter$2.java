package com.tencent.TMG.logger;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.TMG.utils.HttpHelper.HttpRequestListener;
import org.json.JSONException;
import org.json.JSONObject;

class LogReporter$2
  implements HttpHelper.HttpRequestListener
{
  LogReporter$2(LogReporter paramLogReporter) {}
  
  public void onCompleted(String paramString, int paramInt, byte[] paramArrayOfByte, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof LogReporter.LogReprotInfo))) {}
    do
    {
      return;
      paramString = (LogReporter.LogReprotInfo)paramObject;
    } while (TextUtils.isEmpty(paramString.logPath));
    if ((paramInt != 200) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("LogReporter", String.format("mReportLogInfoListener|http request error code=%d", new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      int i = new JSONObject(paramArrayOfByte).getInt("errorCode");
      if ((i == 0) || (i == 1))
      {
        LogReporter.access$100(this.this$0, paramString);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      Log.e("LogReporter", String.format("mReportLogInfoListener|json=%s", new Object[] { paramArrayOfByte }));
      return;
    }
    Log.e("LogReporter", String.format("mReportLogInfoListener|errorcode=%d", new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.logger.LogReporter.2
 * JD-Core Version:    0.7.0.1
 */