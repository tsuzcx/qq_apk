package com.tencent.biz.richframework.download;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

class RFWDownloader$4
  implements Callback
{
  RFWDownloader$4(RFWDownloader paramRFWDownloader, String paramString1, RFWCheckResourceListener paramRFWCheckResourceListener, boolean paramBoolean, String paramString2) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("checkResource:");
    paramCall.append(this.val$url);
    paramCall.append(" onFailure");
    QLog.d("RFWDownloader", 1, paramCall.toString());
    this.val$checkResultListener.onCheckResult(false, this.val$isFileDownloaded, false, this.val$preMd5);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = paramResponse.headers().get("X-COS-META-MD5");
      paramResponse.body().contentLength();
      boolean bool = TextUtils.isEmpty(paramCall);
      if ((!bool) && (!this.val$preMd5.equals(paramCall)))
      {
        paramResponse = new StringBuilder();
        paramResponse.append("checkResource:");
        paramResponse.append(this.val$url);
        paramResponse.append(" need update");
        QLog.d("RFWDownloader", 1, paramResponse.toString());
        this.val$checkResultListener.onCheckResult(true, this.val$isFileDownloaded, true, paramCall);
        return;
      }
      paramResponse = new StringBuilder();
      paramResponse.append("checkResource:");
      paramResponse.append(this.val$url);
      paramResponse.append(" is up to date");
      QLog.d("RFWDownloader", 1, paramResponse.toString());
      this.val$checkResultListener.onCheckResult(true, this.val$isFileDownloaded, false, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.4
 * JD-Core Version:    0.7.0.1
 */