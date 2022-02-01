package com.tencent.biz.richframework.download;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
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
    QLog.e("RFWDownloader", 1, paramIOException, new Object[] { paramIOException.getMessage() });
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    long l1 = SystemClock.uptimeMillis();
    RFWDownloader.access$000(this.this$0, this.val$downloadInfo, paramResponse);
    long l2 = SystemClock.uptimeMillis();
    paramCall = new StringBuilder();
    paramCall.append("download [timeCost=");
    paramCall.append(SystemClock.uptimeMillis() - this.val$beginEnqueue);
    paramCall.append("][receiveData=");
    paramCall.append(l2 - l1);
    paramCall.append("] [url=");
    paramCall.append(this.val$downloadInfo.getUrl());
    paramCall.append("]");
    QLog.e("RFWDownloader", 1, paramCall.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader.1
 * JD-Core Version:    0.7.0.1
 */