package com.tencent.component.network.downloader;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.Callable;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

class RangeDownloadManager$RangeDownloadCallable
  implements Callable<RangeDownloadManager.RangeDownloadResult>
{
  private long contentLength;
  private final int index;
  private final OkHttpClient okHttpClient;
  private RangeDownloadManager.ProgressHandler progressHandler;
  private final Request request;
  private String savePath;
  private final long startPos;
  
  RangeDownloadManager$RangeDownloadCallable(OkHttpClient paramOkHttpClient, Request paramRequest, String paramString, long paramLong1, long paramLong2, int paramInt, RangeDownloadManager.ProgressHandler paramProgressHandler)
  {
    this.okHttpClient = paramOkHttpClient;
    this.request = paramRequest;
    this.savePath = paramString;
    this.index = paramInt;
    this.startPos = paramLong1;
    this.contentLength = paramLong2;
    this.progressHandler = paramProgressHandler;
  }
  
  public RangeDownloadManager.RangeDownloadResult call()
  {
    long l4 = System.currentTimeMillis();
    Object localObject1 = new RangeDownloadReport();
    Response localResponse = this.okHttpClient.newCall(this.request).execute();
    long l5 = System.currentTimeMillis();
    long l3 = l5 - l4;
    ((RangeDownloadReport)localObject1).setTimeCostHeader(l3);
    long l1 = 0L;
    if ((localResponse != null) && (localResponse.isSuccessful()) && (localResponse.body() != null))
    {
      Object localObject2 = localResponse.header("content-length");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.contentLength = Long.parseLong((String)localObject2);
      }
      localObject2 = localResponse.body().byteStream();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.savePath, "rw");
      byte[] arrayOfByte = new byte[8192];
      int j = 0;
      int i = 0;
      for (;;)
      {
        int k = ((InputStream)localObject2).read(arrayOfByte, i, 8192 - i);
        if (k == -1) {
          break;
        }
        int n = k + i;
        if ((n < 8192) && (n + l1 < this.contentLength))
        {
          i += k;
        }
        else
        {
          k = 0;
          localRandomAccessFile.seek(this.startPos + l1);
          localRandomAccessFile.write(arrayOfByte, 0, n);
          l2 = l1 + n;
          int m = j + 1;
          i = k;
          j = m;
          l1 = l2;
          if (this.progressHandler != null)
          {
            Message localMessage = Message.obtain();
            localMessage.obj = Integer.valueOf(n);
            this.progressHandler.sendMessage(localMessage);
            i = k;
            j = m;
            l1 = l2;
          }
        }
      }
      QDLog.d("downloader_RANGE", "range task id:" + this.index + ", round:" + j);
      ((InputStream)localObject2).close();
      localRandomAccessFile.close();
      long l2 = System.currentTimeMillis();
      l5 = l2 - l5;
      l2 -= l4;
      ((RangeDownloadReport)localObject1).setTimeCostData(l5);
      ((RangeDownloadReport)localObject1).setTimeCost(l2);
      ((RangeDownloadReport)localObject1).setRangeId(this.index);
      ((RangeDownloadReport)localObject1).setContentLength(l1);
      QDLog.e("downloader_RANGE", "range task id:" + this.index + " header costTime:" + l3 + ", data costtime:" + l5 + ", totalCostTime:" + l2 + ", byte count:" + l1);
      return new RangeDownloadManager.RangeDownloadResult(this.index, localResponse, l1, (RangeDownloadReport)localObject1);
    }
    localObject1 = null;
    if (localResponse != null) {
      localObject1 = localResponse.message();
    }
    throw new Exception((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager.RangeDownloadCallable
 * JD-Core Version:    0.7.0.1
 */