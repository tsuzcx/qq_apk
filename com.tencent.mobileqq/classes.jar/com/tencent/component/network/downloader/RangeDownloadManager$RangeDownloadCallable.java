package com.tencent.component.network.downloader;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;
import java.util.concurrent.Callable;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

class RangeDownloadManager$RangeDownloadCallable
  implements Callable<RangeDownloadManager.RangeDownloadResult>
{
  private final int index;
  private final OkHttpClient okHttpClient;
  private final Request request;
  private final HttpUtil.RequestOptions requestOptions;
  
  RangeDownloadManager$RangeDownloadCallable(OkHttpClient paramOkHttpClient, Request paramRequest, HttpUtil.RequestOptions paramRequestOptions, int paramInt)
  {
    this.okHttpClient = paramOkHttpClient;
    this.request = paramRequest;
    this.requestOptions = paramRequestOptions;
    this.index = paramInt;
  }
  
  public RangeDownloadManager.RangeDownloadResult call()
  {
    long l = System.currentTimeMillis();
    Object localObject = new RangeDownloadReport();
    Response localResponse = this.okHttpClient.newCall(this.request).execute();
    ((RangeDownloadReport)localObject).setTimeCostHeader(System.currentTimeMillis() - l);
    if ((localResponse != null) && (localResponse.isSuccessful()) && (localResponse.body() != null))
    {
      byte[] arrayOfByte = localResponse.body().bytes();
      localResponse.body().close();
      ((RangeDownloadReport)localObject).setTimeCostData(System.currentTimeMillis() - l - ((RangeDownloadReport)localObject).getTimeCostHeader());
      ((RangeDownloadReport)localObject).setTimeCost(System.currentTimeMillis() - l);
      ((RangeDownloadReport)localObject).setRangeId(this.index);
      if (arrayOfByte != null)
      {
        ((RangeDownloadReport)localObject).setContentLength(arrayOfByte.length);
        QDLog.i("downloader_RANGE", "range task id:" + this.index + " costTime:" + (System.currentTimeMillis() - l) + ", byte count:" + arrayOfByte.length);
      }
      return new RangeDownloadManager.RangeDownloadResult(this.index, localResponse, arrayOfByte, (RangeDownloadReport)localObject);
    }
    localObject = null;
    if (localResponse != null) {
      localObject = localResponse.message();
    }
    throw new Exception((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager.RangeDownloadCallable
 * JD-Core Version:    0.7.0.1
 */