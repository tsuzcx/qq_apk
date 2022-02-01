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
    paramCall = new StringBuilder();
    paramCall.append("pre-connect onFailure: ");
    paramCall.append(this.val$url);
    QDLog.e("downloader", paramCall.toString());
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    long l = System.currentTimeMillis();
    paramCall = new StringBuilder();
    paramCall.append("pre-connect onResponse [timecost: ");
    paramCall.append(l - this.val$begin);
    paramCall.append("] [url: ");
    paramCall.append(this.val$url);
    paramCall.append("] [code: ");
    paramCall.append(paramResponse.code());
    paramCall.append("]");
    QDLog.i("downloader", paramCall.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.PreConnectManager.1
 * JD-Core Version:    0.7.0.1
 */