package com.tencent.biz.pubaccount.weishi_new.aiolist;

import UserGrowth.stGetAIOFeedDetailRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.GetAIOFeedDetailRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.WeishiManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WSAioListHelper
{
  private static stSimpleMetaFeed a;
  
  @NonNull
  private static List<Object> a(@Nullable WeakReference<SplashActivity> paramWeakReference)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramWeakReference != null)
    {
      paramWeakReference = (SplashActivity)paramWeakReference.get();
      if (paramWeakReference != null)
      {
        paramWeakReference = FrameHelperActivity.a(paramWeakReference);
        if (paramWeakReference == null)
        {
          WSLog.e("WSAioListHelper", "getConversationList() frameHelperActivity is null.");
          return localArrayList;
        }
        paramWeakReference = paramWeakReference.a(Conversation.class);
        if (!(paramWeakReference instanceof Conversation))
        {
          WSLog.e("WSAioListHelper", "getConversationList() frame is not Conversation.");
          return localArrayList;
        }
        paramWeakReference = ((Conversation)paramWeakReference).K();
        if (paramWeakReference == null)
        {
          WSLog.e("WSAioListHelper", "getConversationList() adapter is null.");
          return localArrayList;
        }
        paramWeakReference = paramWeakReference.j();
        if (paramWeakReference != null) {
          localArrayList.addAll(paramWeakReference);
        }
        paramWeakReference = new StringBuilder();
        paramWeakReference.append("getConversationList() dataList size = ");
        paramWeakReference.append(localArrayList.size());
        WSLog.e("WSAioListHelper", paramWeakReference.toString());
        return localArrayList;
      }
    }
    WSLog.e("WSAioListHelper", "getConversationList() splashActivity ref is null.");
    return localArrayList;
  }
  
  public static void a()
  {
    c();
    GetAIOFeedDetailRequest localGetAIOFeedDetailRequest = new GetAIOFeedDetailRequest();
    WSNetService.a(localGetAIOFeedDetailRequest).a(new WSAioListHelper.1(localGetAIOFeedDetailRequest));
  }
  
  public static void a(@Nullable stSimpleMetaFeed paramstSimpleMetaFeed, @Nullable String paramString)
  {
    WeishiManager localWeishiManager = WeishiUtils.d();
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
      if ((WSExpABTestManager.a().v()) && (WeishiUtils.r()))
      {
        int i = d();
        paramString = new StringBuilder();
        paramString.append("wsPublicAccountIndex = ");
        paramString.append(i);
        WSLog.e("WSAioListHelper", paramString.toString());
        if (i + 1 < WSExpABTestManager.a().u())
        {
          WSLog.e("WSAioListHelper", "wsPublicAccountIndex is no exceed threshold.");
          return;
        }
      }
      paramstSimpleMetaFeed.feed_desc = WeishiUtils.a(paramstSimpleMetaFeed.feed_desc);
      paramString = new StringBuilder();
      paramString.append("write back feed info and preload. feed_id = ");
      paramString.append(paramstSimpleMetaFeed.id);
      paramString.append(", desc = ");
      paramString.append(paramstSimpleMetaFeed.feed_desc);
      WSLog.e("WSAioListHelper", paramString.toString());
      localWeishiManager.a(paramstSimpleMetaFeed, "0");
      WSVideoPreloadManager.a(paramstSimpleMetaFeed, WSExpABTestManager.a().f());
      return;
    }
    WSLog.e("WSAioListHelper", "params is invalid.");
  }
  
  public static stSimpleMetaFeed b()
  {
    return a;
  }
  
  private static void b(GetAIOFeedDetailRequest paramGetAIOFeedDetailRequest, stGetAIOFeedDetailRsp paramstGetAIOFeedDetailRsp)
  {
    if (paramstGetAIOFeedDetailRsp == null) {
      return;
    }
    WSLog.e("WSAioListHelper", "[onGetAioListOperationFeedSuccess] onTaskResponse");
    if (paramstGetAIOFeedDetailRsp.enable)
    {
      if (paramstGetAIOFeedDetailRsp.feed == null) {
        return;
      }
      a = paramstGetAIOFeedDetailRsp.feed;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onGetAioListOperationFeedSuccess] cacheAioListOperationFeed feedId:");
      paramGetAIOFeedDetailRequest = a;
      paramstGetAIOFeedDetailRsp = "";
      if (paramGetAIOFeedDetailRequest != null) {
        paramGetAIOFeedDetailRequest = paramGetAIOFeedDetailRequest.id;
      } else {
        paramGetAIOFeedDetailRequest = "";
      }
      localStringBuilder.append(paramGetAIOFeedDetailRequest);
      localStringBuilder.append(", feedTitle:");
      stSimpleMetaFeed localstSimpleMetaFeed = a;
      paramGetAIOFeedDetailRequest = paramstGetAIOFeedDetailRsp;
      if (localstSimpleMetaFeed != null) {
        paramGetAIOFeedDetailRequest = localstSimpleMetaFeed.feed_desc;
      }
      localStringBuilder.append(paramGetAIOFeedDetailRequest);
      WSLog.d("WSAioListHelper", localStringBuilder.toString());
    }
  }
  
  public static void c()
  {
    a = null;
  }
  
  public static int d()
  {
    List localList = a(SplashActivity.sWeakInstance);
    if (localList.size() == 0) {
      return -1;
    }
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = localList.get(i);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        if (AppConstants.WEISHI_UIN.equals(((RecentBaseData)localObject).getRecentUserUin())) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper
 * JD-Core Version:    0.7.0.1
 */