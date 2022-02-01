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
import java.util.List<Lcom.tencent.component.network.downloader.RangeDownloadManager.RangeDownloadResult;>;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
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
    if (paramInt <= 0) {
      paramInt = 4;
    }
    this.numberOfRangeTasks = paramInt;
  }
  
  private Response buildResponse(List<RangeDownloadManager.RangeDownloadResult> paramList)
  {
    Object localObject6 = null;
    if (paramList == null) {
      return null;
    }
    this.totalFileSize = 0L;
    Iterator localIterator = paramList.iterator();
    Object localObject3 = null;
    paramList = localObject3;
    Object localObject1 = paramList;
    while (localIterator.hasNext())
    {
      RangeDownloadManager.RangeDownloadResult localRangeDownloadResult = (RangeDownloadManager.RangeDownloadResult)localIterator.next();
      if (localRangeDownloadResult != null)
      {
        this.rangeDownloadReports.add(localRangeDownloadResult.getRangeDownloadReport());
        if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult) != null)
        {
          Object localObject2 = localObject6;
          if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).request() != null) {
            localObject2 = RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).request();
          }
          Object localObject4 = localObject3;
          if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).protocol() != null) {
            localObject4 = RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).protocol();
          }
          Object localObject5 = paramList;
          if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).message() != null) {
            localObject5 = RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).message();
          }
          Object localObject7 = localObject1;
          if (RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).priorResponse() != null) {
            localObject7 = RangeDownloadManager.RangeDownloadResult.access$000(localRangeDownloadResult).priorResponse();
          }
          localObject6 = localObject2;
          localObject3 = localObject4;
          paramList = (List<RangeDownloadManager.RangeDownloadResult>)localObject5;
          localObject1 = localObject7;
          if (RangeDownloadManager.RangeDownloadResult.access$100(localRangeDownloadResult) > 0L)
          {
            this.totalFileSize += RangeDownloadManager.RangeDownloadResult.access$100(localRangeDownloadResult);
            localObject6 = localObject2;
            localObject3 = localObject4;
            paramList = (List<RangeDownloadManager.RangeDownloadResult>)localObject5;
            localObject1 = localObject7;
          }
        }
      }
    }
    return new Response.Builder().request(localObject6).protocol(localObject3).message(paramList).priorResponse((Response)localObject1).code(200).build();
  }
  
  private List<RangeDownloadManager.RangeDownloadResult> executeAsync()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.numberOfRangeTasks;
    int i = j;
    if (j > 4) {
      i = 4;
    }
    ExecutorService localExecutorService = Executors.newFixedThreadPool(i);
    Iterator localIterator = localExecutorService.invokeAll(this.allRangeRequests).iterator();
    while (localIterator.hasNext())
    {
      Future localFuture = (Future)localIterator.next();
      if (localFuture != null) {
        localArrayList.add((RangeDownloadManager.RangeDownloadResult)localFuture.get());
      }
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
      paramBuilder = new StringBuilder();
      paramBuilder.append("getContentLength header costTime:");
      paramBuilder.append(System.currentTimeMillis() - l3);
      paramBuilder.append(", contentLength:");
      paramBuilder.append(l1);
      paramBuilder.append(", rangeTaskNum:");
      paramBuilder.append(this.numberOfRangeTasks);
      QDLog.i("downloader_RANGE", paramBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bytes=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append('-');
    if (paramLong2 == -1L) {
      paramBuilder = "";
    } else {
      paramBuilder = Long.valueOf(paramLong2);
    }
    localStringBuilder.append(paramBuilder);
    paramString.header("Range", localStringBuilder.toString());
    paramString.header("Connection", "keep-alive");
    return paramString.build();
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
      Object localObject = new RandomAccessFile(paramString, "rw");
      ((RandomAccessFile)localObject).setLength(l2);
      ((RandomAccessFile)localObject).close();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createFileWithSize fileSize: ");
      ((StringBuilder)localObject).append(paramString.length());
      ((StringBuilder)localObject).append(", cost time: ");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l1);
      QDLog.e("downloader_RANGE", ((StringBuilder)localObject).toString());
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
    int i = this.numberOfRangeTasks;
    if (i == 1) {
      localObject = executeSingle();
    } else if (i > 1) {
      localObject = executeAsync();
    } else {
      localObject = null;
    }
    Object localObject = buildResponse((List)localObject);
    this.durationMillisForRangeReceivePhase = (SystemClock.uptimeMillis() - l);
    return localObject;
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
    long l2 = System.currentTimeMillis();
    long l3 = getContentLength(paramBuilder, paramString2);
    if (l3 > 0L)
    {
      long l4 = l3 / this.numberOfRangeTasks + 1L;
      int i = 0;
      while (i < this.numberOfRangeTasks)
      {
        long l5 = i * l4;
        long l1 = l5 + (l4 - 1L);
        if (l1 >= l3) {
          l1 = -1L;
        }
        paramString2 = this.allRangeRequests;
        OkHttpClient localOkHttpClient = this.okHttpClient;
        Request localRequest = getRequest(paramBuilder, paramString1, l5, l1);
        if (l1 == -1L) {
          l1 = l3 - l5;
        } else {
          l1 = l1 - l5 + 1L;
        }
        paramString2.add(new RangeDownloadManager.RangeDownloadCallable(localOkHttpClient, localRequest, paramString3, l5, l1, i, getProgressHandler(paramProgressListener, l3)));
        i += 1;
      }
      this.durationMillisForHeadPhase = (System.currentTimeMillis() - l2);
      return true;
    }
    paramBuilder = new StringBuilder();
    paramBuilder.append("tryBuildAllRangeRequests fail, url:");
    paramBuilder.append(paramString1);
    paramBuilder.append(", requestUrl:");
    paramBuilder.append(paramString2);
    QDLog.e("downloader_RANGE", paramBuilder.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager
 * JD-Core Version:    0.7.0.1
 */