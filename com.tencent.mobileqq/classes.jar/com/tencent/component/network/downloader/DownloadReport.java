package com.tencent.component.network.downloader;

import java.util.List;
import okhttp3.Response;
import org.apache.http.HttpResponse;

public final class DownloadReport
{
  public String clientip;
  public int concurrent;
  public String content_type;
  public int currAttempCount;
  public String dns;
  public String domain;
  public int downloadMode;
  public long downloadTime;
  public long endTime;
  public Throwable exception;
  public long fileSize;
  public int httpStatus;
  public int id;
  public boolean isFromQzoneAlbum;
  public boolean isHttp2;
  public boolean isHttps;
  public boolean isSucceed = false;
  public String localAddress;
  public String logInfo;
  public Response okResponse;
  public String protocol;
  public List<RangeDownloadReport> rangeDownloadReports;
  public int rangeNumber;
  public String refer;
  public String remoteAddress;
  public HttpResponse response;
  public long startTime;
  public int strategyId;
  public String strategyInfo;
  public long t_conn;
  public long t_prepare;
  public long t_process;
  public long t_recvdata;
  public long t_recvrsp;
  public long t_wait;
  public long timeCostForRangeMergePhase;
  public long timeCostForRangeReceivePhase;
  public long totaltime;
  public String url;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadReport
 * JD-Core Version:    0.7.0.1
 */