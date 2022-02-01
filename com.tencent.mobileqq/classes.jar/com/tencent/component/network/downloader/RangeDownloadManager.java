package com.tencent.component.network.downloader;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;

public class RangeDownloadManager
{
  private static final int DEFAULT_RANGE_NUMBER = 4;
  private static final int MAX_THREAD_NUM_LIMIT = 4;
  private List<RangeDownloadManager.RangeDownloadCallable> allRangeRequests = new ArrayList();
  private long contentLength;
  private long durationMillisForHeadPhase;
  private long durationMillisForRangeReceivePhase;
  private final int numberOfRangeTasks;
  private final OkHttpClient okHttpClient;
  private RangeDownloadManager.ProgressHandler progressHandler;
  private List<RangeDownloadReport> rangeDownloadReports = new ArrayList();
  private long totalFileSize = 0L;
  
  public RangeDownloadManager(OkHttpClient paramOkHttpClient, int paramInt)
  {
    this.okHttpClient = paramOkHttpClient;
    if (paramInt > 0) {}
    for (;;)
    {
      this.numberOfRangeTasks = paramInt;
      return;
      paramInt = 4;
    }
  }
  
  private Response buildResponse(List<RangeDownloadManager.RangeDownloadResult> paramList)
  {
    Object localObject3 = null;
    if (paramList == null) {
      return null;
    }
    this.totalFileSize = 0L;
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Object localObject1 = null;
    Object localObject2 = null;
    while (localIterator.hasNext())
    {
      RangeDownloadManager.RangeDownloadResult localRangeDownloadResult = (RangeDownloadManager.RangeDownloadResult)localIterator.next();
      Object localObject6 = localObject3;
      List<RangeDownloadManager.RangeDownloadResult> localList = paramList;
      Object localObject4 = localObject1;
      Object localObject5 = localObject2;
      if (localRangeDownloadResult != null)
      {
        this.rangeDownloadReports.add(localRangeDownloadResult.getRangeDownloadReport());
        localObject6 = localObject3;
        localList = paramList;
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult) != null)
        {
          if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).request() != null) {
            localObject2 = RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).request();
          }
          if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).protocol() != null) {
            localObject1 = RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).protocol();
          }
          if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).message() != null) {
            paramList = RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).message();
          }
          if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).priorResponse() != null) {
            localObject3 = RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).priorResponse();
          }
          localObject6 = localObject3;
          localList = paramList;
          localObject4 = localObject1;
          localObject5 = localObject2;
          if (RangeDownloadManager.RangeDownloadResult.access$100(localRangeDownloadResult) > 0L)
          {
            this.totalFileSize += RangeDownloadManager.RangeDownloadResult.access$100(localRangeDownloadResult);
            localObject5 = localObject2;
            localObject4 = localObject1;
            localList = paramList;
            localObject6 = localObject3;
          }
        }
      }
      localObject2 = localObject5;
      localObject1 = localObject4;
      paramList = localList;
      localObject3 = localObject6;
    }
    return new Response.Builder().request((Request)localObject2).protocol((Protocol)localObject1).message(paramList).priorResponse((Response)localObject3).code(200).build();
  }
  
  private List<RangeDownloadManager.RangeDownloadResult> executeAsync()
  {
    int i = 4;
    ArrayList localArrayList = new ArrayList();
    if (this.numberOfRangeTasks > 4) {}
    ExecutorService localExecutorService;
    for (;;)
    {
      localExecutorService = Executors.newFixedThreadPool(i);
      Iterator localIterator = localExecutorService.invokeAll(this.allRangeRequests).iterator();
      while (localIterator.hasNext())
      {
        Future localFuture = (Future)localIterator.next();
        if (localFuture != null) {
          localArrayList.add((RangeDownloadManager.RangeDownloadResult)localFuture.get());
        }
      }
      i = this.numberOfRangeTasks;
    }
    localExecutorService.shutdown();
    localExecutorService.awaitTermination(1L, TimeUnit.SECONDS);
    return localArrayList;
  }
  
  private List<RangeDownloadManager.RangeDownloadResult> executeSingle()
  {
    if (this.allRangeRequests.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(((RangeDownloadManager.RangeDownloadCallable)this.allRangeRequests.get(0)).call());
      return localArrayList;
    }
    return null;
  }
  
  private long getContentLength(Request.Builder paramBuilder, String paramString)
  {
    long l2 = getContentLength();
    long l1 = l2;
    if (l2 <= 0L)
    {
      long l3 = System.currentTimeMillis();
      paramBuilder = requestHeader(paramBuilder, paramString);
      l1 = l2;
      if (paramBuilder != null)
      {
        l1 = l2;
        if (paramBuilder.isSuccessful())
        {
          paramString = paramBuilder.header("Accept-Ranges", null);
          l1 = l2;
          if (!TextUtils.isEmpty(paramString))
          {
            l1 = l2;
            if (!paramString.equalsIgnoreCase("none"))
            {
              l1 = Long.parseLong(paramBuilder.header("Content-Length", "0"));
              setContentLength(l1);
            }
          }
        }
      }
      QDLog.i("downloader_RANGE", "getContentLength header costTime:" + (System.currentTimeMillis() - l3) + ", contentLength:" + l1 + ", rangeTaskNum:" + this.numberOfRangeTasks);
    }
    return l1;
  }
  
  private RangeDownloadManager.ProgressHandler getProgressHandler(RangeDownloadManager.ProgressListener paramProgressListener, long paramLong)
  {
    if (this.progressHandler == null) {
      this.progressHandler = new RangeDownloadManager.ProgressHandler(GlobalHandlerThread.getInstance(null).getLooper(), paramProgressListener, paramLong);
    }
    return this.progressHandler;
  }
  
  private Request getRequest(Request.Builder paramBuilder, String paramString, long paramLong1, long paramLong2)
  {
    paramString = paramBuilder.get().url(paramString);
    StringBuilder localStringBuilder = new StringBuilder().append("bytes=").append(paramLong1).append('-');
    if (paramLong2 == -1L) {}
    for (paramBuilder = "";; paramBuilder = Long.valueOf(paramLong2))
    {
      paramString.header("Range", paramBuilder);
      paramString.header("Connection", "keep-alive");
      return paramString.build();
    }
  }
  
  private Response requestHeader(Request.Builder paramBuilder, String paramString)
  {
    paramBuilder = paramBuilder.url(paramString).header("Connection", "keep-alive").head().build();
    try
    {
      paramBuilder = this.okHttpClient.newCall(paramBuilder).execute();
      return paramBuilder;
    }
    catch (IOException paramBuilder)
    {
      QDLog.e("downloader_RANGE", "requestHeader exception", paramBuilder);
    }
    return null;
  }
  
  public void cancel() {}
  
  public boolean createEmptyFile(String paramString)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = getContentLength();
    if (l2 <= 0L) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramString, "rw");
      localRandomAccessFile.setLength(l2);
      localRandomAccessFile.close();
      QDLog.e("downloader_RANGE", "createFileWithSize fileSize: " + paramString.length() + ", cost time: " + (SystemClock.uptimeMillis() - l1));
      return true;
    }
    catch (Exception paramString)
    {
      QDLog.e("downloader_RANGE", "createFileWithSize exception", paramString);
    }
    return false;
  }
  
  public Response execute()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = null;
    if (this.numberOfRangeTasks == 1) {
      localObject = executeSingle();
    }
    for (;;)
    {
      localObject = buildResponse((List)localObject);
      this.durationMillisForRangeReceivePhase = (SystemClock.uptimeMillis() - l);
      return localObject;
      if (this.numberOfRangeTasks > 1) {
        localObject = executeAsync();
      }
    }
  }
  
  public long getContentLength()
  {
    return this.contentLength;
  }
  
  public long getDurationMillisForHeadPhase()
  {
    return this.durationMillisForHeadPhase;
  }
  
  public long getDurationMillisForRangeReceivePhase()
  {
    return this.durationMillisForRangeReceivePhase;
  }
  
  public int getNumberOfRangeTasks()
  {
    return this.numberOfRangeTasks;
  }
  
  public List<RangeDownloadReport> getRangeDownloadReports()
  {
    return this.rangeDownloadReports;
  }
  
  public long getTotalFileSize()
  {
    return this.totalFileSize;
  }
  
  public void setContentLength(long paramLong)
  {
    this.contentLength = paramLong;
  }
  
  public boolean tryBuildAllRangeRequests(String paramString1, String paramString2, Request.Builder paramBuilder, String paramString3, RangeDownloadManager.ProgressListener paramProgressListener)
  {
    if (paramBuilder == null) {
      paramBuilder = new Request.Builder();
    }
    for (;;)
    {
      long l3 = System.currentTimeMillis();
      long l4 = getContentLength(paramBuilder, paramString2);
      if (l4 > 0L)
      {
        long l5 = l4 / this.numberOfRangeTasks + 1L;
        int i = 0;
        if (i < this.numberOfRangeTasks)
        {
          long l6 = i * l5;
          long l2 = l6 + (l5 - 1L);
          long l1 = l2;
          if (l2 >= l4) {
            l1 = -1L;
          }
          paramString2 = this.allRangeRequests;
          OkHttpClient localOkHttpClient = this.okHttpClient;
          Request localRequest = getRequest(paramBuilder, paramString1, l6, l1);
          if (l1 == -1L) {}
          for (l1 = l4 - l6;; l1 = l1 - l6 + 1L)
          {
            paramString2.add(new RangeDownloadManager.RangeDownloadCallable(localOkHttpClient, localRequest, paramString3, l6, l1, i, getProgressHandler(paramProgressListener, l4)));
            i += 1;
            break;
          }
        }
        this.durationMillisForHeadPhase = (System.currentTimeMillis() - l3);
        return true;
      }
      QDLog.e("downloader_RANGE", "tryBuildAllRangeRequests fail, url:" + paramString1 + ", requestUrl:" + paramString2);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager
 * JD-Core Version:    0.7.0.1
 */