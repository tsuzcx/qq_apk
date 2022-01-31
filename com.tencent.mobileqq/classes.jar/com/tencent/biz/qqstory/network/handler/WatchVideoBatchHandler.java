package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager.InnerVideoItem;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.WatchVideoBatchRequest;
import com.tencent.biz.qqstory.network.response.WatchVideoBatchResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WatchVideoBatchHandler
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static int a = 20;
  private long c;
  
  public WatchVideoBatchRequest a(int paramInt, ArrayList paramArrayList)
  {
    if (paramArrayList.size() > a) {
      SLog.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    WatchVideoBatchRequest localWatchVideoBatchRequest = new WatchVideoBatchRequest();
    localWatchVideoBatchRequest.c = paramInt;
    localWatchVideoBatchRequest.a = paramArrayList;
    CmdTaskManger.a().a(localWatchVideoBatchRequest, this);
    this.c = System.currentTimeMillis();
    return localWatchVideoBatchRequest;
  }
  
  public void a(@NonNull WatchVideoBatchRequest paramWatchVideoBatchRequest, @Nullable WatchVideoBatchResponse paramWatchVideoBatchResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    ReportWatchVideoManager localReportWatchVideoManager = (ReportWatchVideoManager)SuperManager.a(13);
    if ((paramWatchVideoBatchResponse == null) || (paramErrorMessage.isFail()))
    {
      SLog.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramWatchVideoBatchResponse = paramWatchVideoBatchRequest.a.iterator();
    }
    while (paramWatchVideoBatchResponse.hasNext())
    {
      localReportWatchVideoManager.a((ReportWatchVideoManager.InnerVideoItem)paramWatchVideoBatchResponse.next(), false);
      continue;
      localReportWatchVideoManager.a(paramWatchVideoBatchResponse.a);
      SLog.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramWatchVideoBatchResponse.a.size()), Integer.valueOf(paramWatchVideoBatchRequest.a.size()) });
      paramErrorMessage = paramWatchVideoBatchRequest.a.iterator();
      while (paramErrorMessage.hasNext())
      {
        ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = (ReportWatchVideoManager.InnerVideoItem)paramErrorMessage.next();
        if (!paramWatchVideoBatchResponse.a.contains(localInnerVideoItem)) {
          localReportWatchVideoManager.a(localInnerVideoItem, false);
        }
      }
      if (paramWatchVideoBatchRequest.a.size() > paramWatchVideoBatchResponse.a.size()) {
        StoryReportor.b("home_page", "batch_watch_video", 0, paramWatchVideoBatchRequest.a.size() - paramWatchVideoBatchResponse.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.c), StoryReportor.a(BaseApplication.getContext()) });
      }
    }
    localReportWatchVideoManager.a(paramWatchVideoBatchRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.WatchVideoBatchHandler
 * JD-Core Version:    0.7.0.1
 */