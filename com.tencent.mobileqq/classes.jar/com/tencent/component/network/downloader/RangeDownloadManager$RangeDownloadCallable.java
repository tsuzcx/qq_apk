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
    long l3 = System.currentTimeMillis();
    RangeDownloadReport localRangeDownloadReport = new RangeDownloadReport();
    Response localResponse = this.okHttpClient.newCall(this.request).execute();
    long l4 = System.currentTimeMillis();
    long l2 = l4 - l3;
    localRangeDownloadReport.setTimeCostHeader(l2);
    if ((localResponse != null) && (localResponse.isSuccessful()) && (localResponse.body() != null))
    {
      localObject = localResponse.header("content-length");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.contentLength = Long.parseLong((String)localObject);
      }
      InputStream localInputStream = localResponse.body().byteStream();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.savePath, "rw");
      localObject = new byte[8192];
      long l1 = 0L;
      int i = 0;
      int j = 0;
      for (;;)
      {
        int k = localInputStream.read((byte[])localObject, i, 8192 - i);
        if (k == -1) {
          break;
        }
        i += k;
        if ((i >= 8192) || (i + l1 >= this.contentLength))
        {
          localRandomAccessFile.seek(this.startPos + l1);
          localRandomAccessFile.write((byte[])localObject, 0, i);
          l1 += i;
          j += 1;
          if (this.progressHandler != null)
          {
            Message localMessage = Message.obtain();
            localMessage.obj = Integer.valueOf(i);
            this.progressHandler.sendMessage(localMessage);
          }
          i = 0;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("range task id:");
      ((StringBuilder)localObject).append(this.index);
      ((StringBuilder)localObject).append(", round:");
      ((StringBuilder)localObject).append(j);
      QDLog.d("downloader_RANGE", ((StringBuilder)localObject).toString());
      localInputStream.close();
      localRandomAccessFile.close();
      long l5 = System.currentTimeMillis();
      l4 = l5 - l4;
      l3 = l5 - l3;
      localRangeDownloadReport.setTimeCostData(l4);
      localRangeDownloadReport.setTimeCost(l3);
      localRangeDownloadReport.setRangeId(this.index);
      localRangeDownloadReport.setContentLength(l1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("range task id:");
      ((StringBuilder)localObject).append(this.index);
      ((StringBuilder)localObject).append(" header costTime:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", data costtime:");
      ((StringBuilder)localObject).append(l4);
      ((StringBuilder)localObject).append(", totalCostTime:");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(", byte count:");
      ((StringBuilder)localObject).append(l1);
      QDLog.e("downloader_RANGE", ((StringBuilder)localObject).toString());
      return new RangeDownloadManager.RangeDownloadResult(this.index, localResponse, l1, localRangeDownloadReport);
    }
    Object localObject = null;
    if (localResponse != null) {
      localObject = localResponse.message();
    }
    localObject = new Exception((String)localObject);
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager.RangeDownloadCallable
 * JD-Core Version:    0.7.0.1
 */