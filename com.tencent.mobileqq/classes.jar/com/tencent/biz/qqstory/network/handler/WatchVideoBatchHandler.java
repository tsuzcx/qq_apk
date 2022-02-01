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
  implements CmdTaskManger.CommandCallback<WatchVideoBatchRequest, WatchVideoBatchResponse>
{
  public static int g = 20;
  private long h;
  
  public WatchVideoBatchRequest a(int paramInt, ArrayList<ReportWatchVideoManager.InnerVideoItem> paramArrayList)
  {
    if (paramArrayList.size() > g) {
      SLog.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    WatchVideoBatchRequest localWatchVideoBatchRequest = new WatchVideoBatchRequest();
    localWatchVideoBatchRequest.f = paramInt;
    localWatchVideoBatchRequest.g = paramArrayList;
    CmdTaskManger.a().a(localWatchVideoBatchRequest, this);
    this.h = System.currentTimeMillis();
    return localWatchVideoBatchRequest;
  }
  
  public void a(@NonNull WatchVideoBatchRequest paramWatchVideoBatchRequest, @Nullable WatchVideoBatchResponse paramWatchVideoBatchResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    ReportWatchVideoManager localReportWatchVideoManager = (ReportWatchVideoManager)SuperManager.a(13);
    if ((paramWatchVideoBatchResponse != null) && (!paramErrorMessage.isFail()))
    {
      localReportWatchVideoManager.a(paramWatchVideoBatchResponse.a);
      SLog.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. succList.size=%d. requestList.size=%d", new Object[] { Integer.valueOf(paramWatchVideoBatchResponse.a.size()), Integer.valueOf(paramWatchVideoBatchRequest.g.size()) });
      paramErrorMessage = paramWatchVideoBatchRequest.g.iterator();
      while (paramErrorMessage.hasNext())
      {
        ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = (ReportWatchVideoManager.InnerVideoItem)paramErrorMessage.next();
        if (!paramWatchVideoBatchResponse.a.contains(localInnerVideoItem)) {
          localReportWatchVideoManager.a(localInnerVideoItem, false);
        }
      }
      if (paramWatchVideoBatchRequest.g.size() > paramWatchVideoBatchResponse.a.size()) {
        StoryReportor.b("home_page", "batch_watch_video", 0, paramWatchVideoBatchRequest.g.size() - paramWatchVideoBatchResponse.a.size(), new String[] { "", String.valueOf(System.currentTimeMillis() - this.h), StoryReportor.a(BaseApplication.getContext()) });
      }
    }
    else
    {
      SLog.d("Q.qqstory:WatchVideoBatchHandler", "WatchVideoBatchHandler onCmdRespond. errorInfo=%s", new Object[] { paramErrorMessage.toString() });
      paramWatchVideoBatchResponse = paramWatchVideoBatchRequest.g.iterator();
      while (paramWatchVideoBatchResponse.hasNext()) {
        localReportWatchVideoManager.a((ReportWatchVideoManager.InnerVideoItem)paramWatchVideoBatchResponse.next(), false);
      }
    }
    localReportWatchVideoManager.a(paramWatchVideoBatchRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.WatchVideoBatchHandler
 * JD-Core Version:    0.7.0.1
 */