package com.tencent.biz.richframework.download;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
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
    RFLog.d("RFWDownloader", RFLog.USR, "checkResource:" + this.val$url + " onFailure");
    this.val$checkResultListener.onCheckResult(false, this.val$isFileDownloaded, false, this.val$preMd5);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = paramResponse.headers().get("X-COS-META-MD5");
      paramResponse.body().contentLength();
      if ((TextUtils.isEmpty(paramCall)) || (this.val$preMd5.equals(paramCall)))
      {
        RFLog.d("RFWDownloader", RFLog.USR, "checkResource:" + this.val$url + " is up to date");
        this.val$checkResultListener.onCheckResult(true, this.val$isFileDownloaded, false, paramCall);
        return;
      }
      RFLog.d("RFWDownloader", RFLog.USR, "checkResource:" + this.val$url + " need update");
      this.val$checkResultListener.onCheckResult(true, this.val$isFileDownloaded, true, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.4
 * JD-Core Version:    0.7.0.1
 */