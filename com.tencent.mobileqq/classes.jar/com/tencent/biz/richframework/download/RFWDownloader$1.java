package com.tencent.biz.richframework.download;

import android.os.SystemClock;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class RFWDownloader$1
  implements Callback
{
  RFWDownloader$1(RFWDownloader paramRFWDownloader, RFWDownloadInfo paramRFWDownloadInfo, long paramLong) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramIOException.printStackTrace();
    RFLog.e("RFWDownloader", RFLog.USR, new Object[] { paramIOException, paramIOException.getMessage() });
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    long l1 = SystemClock.uptimeMillis();
    RFWDownloader.access$000(this.this$0, this.val$downloadInfo, paramResponse);
    long l2 = SystemClock.uptimeMillis();
    RFLog.e("RFWDownloader", RFLog.USR, "download [timeCost=" + (SystemClock.uptimeMillis() - this.val$beginEnqueue) + "][receiveData=" + (l2 - l1) + "] [url=" + this.val$downloadInfo.getUrl() + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.1
 * JD-Core Version:    0.7.0.1
 */