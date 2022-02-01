package com.tencent.component.network.downloader;

import com.tencent.component.network.module.base.QDLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

final class PreConnectManager$1
  implements Callback
{
  PreConnectManager$1(String paramString, long paramLong) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QDLog.e("downloader", "pre-connect onFailure: " + this.val$url);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    long l = System.currentTimeMillis();
    QDLog.i("downloader", "pre-connect onResponse [timecost: " + (l - this.val$begin) + "] [url: " + this.val$url + "] [code: " + paramResponse.code() + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.PreConnectManager.1
 * JD-Core Version:    0.7.0.1
 */