package com.tencent.biz.pubaccount.weishi_new.aiolist;

import UserGrowth.stGetAIOFeedDetailRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.GetAIOFeedDetailRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.app.WeishiManager;

public class WSAioListHelper
{
  private static stSimpleMetaFeed a;
  
  public static stSimpleMetaFeed a()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a;
    a = null;
    return localstSimpleMetaFeed;
  }
  
  public static void a()
  {
    GetAIOFeedDetailRequest localGetAIOFeedDetailRequest = new GetAIOFeedDetailRequest();
    WSNetService.a(localGetAIOFeedDetailRequest).a(new WSAioListHelper.1(localGetAIOFeedDetailRequest));
  }
  
  public static void a(@Nullable stSimpleMetaFeed paramstSimpleMetaFeed, @Nullable String paramString)
  {
    WeishiManager localWeishiManager = WeishiUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("writeBackToAioListAndCacheFeed() tag = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", weishiManager = ");
    localStringBuilder.append(localWeishiManager);
    localStringBuilder.append(", feed = ");
    localStringBuilder.append(paramstSimpleMetaFeed);
    WSLog.e("WSAioListHelper", localStringBuilder.toString());
    if ((localWeishiManager != null) && (paramstSimpleMetaFeed != null))
    {
      paramstSimpleMetaFeed.feed_desc = WeishiUtils.a(paramstSimpleMetaFeed.feed_desc);
      paramString = new StringBuilder();
      paramString.append("write back feed info and preload. feed_id = ");
      paramString.append(paramstSimpleMetaFeed.id);
      paramString.append(", desc = ");
      paramString.append(paramstSimpleMetaFeed.feed_desc);
      WSLog.e("WSAioListHelper", paramString.toString());
      localWeishiManager.a(paramstSimpleMetaFeed, "0");
      WSVideoPreloadManager.a(paramstSimpleMetaFeed, WSExpABTestManager.a().b());
      return;
    }
    WSLog.e("WSAioListHelper", "params is invalid.");
  }
  
  public static void b()
  {
    a = null;
  }
  
  private static void b(GetAIOFeedDetailRequest paramGetAIOFeedDetailRequest, stGetAIOFeedDetailRsp paramstGetAIOFeedDetailRsp)
  {
    if (paramstGetAIOFeedDetailRsp == null) {
      return;
    }
    WsBeaconReportPresenter.a().a(paramGetAIOFeedDetailRequest);
    WSLog.e("WSAioListHelper", "[onGetAioListOperationFeedSuccess] onTaskResponse");
    if (paramstGetAIOFeedDetailRsp.enable)
    {
      if (paramstGetAIOFeedDetailRsp.feed == null) {
        return;
      }
      WSLog.e("WSAioListHelper", "[onGetAioListOperationFeedSuccess] cacheAioListOperationFeed");
      a = paramstGetAIOFeedDetailRsp.feed;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper
 * JD-Core Version:    0.7.0.1
 */