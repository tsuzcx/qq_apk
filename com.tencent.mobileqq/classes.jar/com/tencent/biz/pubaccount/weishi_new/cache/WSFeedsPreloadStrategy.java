package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPreloadABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.request.RecommendRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;

public class WSFeedsPreloadStrategy
{
  private String a = "";
  private boolean b;
  private Runnable c;
  private boolean d;
  private int e;
  
  public WSFeedsPreloadStrategy(int paramInt)
  {
    this.e = paramInt;
  }
  
  private void a(WeishiTask paramWeishiTask)
  {
    this.b = false;
    if (paramWeishiTask == null)
    {
      WSLog.d("WSFeedsPreloadStrategy", "WSRedDot preloadTask is null.");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onTaskResponse-resultCode:");
    ((StringBuilder)localObject1).append(paramWeishiTask.e);
    ((StringBuilder)localObject1).append(" | resultBean:");
    ((StringBuilder)localObject1).append(paramWeishiTask.m);
    ((StringBuilder)localObject1).append(" | thread:");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    WSLog.b("WSFeedsPreloadStrategy", ((StringBuilder)localObject1).toString());
    if (!paramWeishiTask.b())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WSRedDot preload request error. resultCode=");
      ((StringBuilder)localObject1).append(paramWeishiTask.e);
      WSLog.d("WSFeedsPreloadStrategy", ((StringBuilder)localObject1).toString());
      return;
    }
    if (!(paramWeishiTask.g instanceof RecommendRequest)) {
      return;
    }
    localObject1 = (RecommendRequest)paramWeishiTask.g;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("WSRedDot recommendRequest.mRequestId=");
    ((StringBuilder)localObject2).append(((RecommendRequest)localObject1).d);
    ((StringBuilder)localObject2).append(", mCurrentUniSeq=");
    ((StringBuilder)localObject2).append(this.a);
    WSLog.b("WSFeedsPreloadStrategy", ((StringBuilder)localObject2).toString());
    if ((TextUtils.equals(((RecommendRequest)localObject1).d, this.a)) && ((paramWeishiTask.m instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramWeishiTask.m).feeds != null) && (((stSimpleGetFeedListRsp)paramWeishiTask.m).feeds.size() > 0))
    {
      localObject2 = (stSimpleGetFeedListRsp)paramWeishiTask.m;
      localObject1 = ((stSimpleGetFeedListRsp)localObject2).feeds;
      if (paramWeishiTask.n != null) {
        WSRecommendReportManager.a().a(((stSimpleGetFeedListRsp)localObject2).trace_id, paramWeishiTask.n.a);
      }
      long l = d();
      WeiShiCacheManager.a().a((List)localObject1, l, this.e);
      paramWeishiTask = new StringBuilder();
      paramWeishiTask.append("WSRedDot preloadList.size:");
      paramWeishiTask.append(((ArrayList)localObject1).size());
      WSLog.a("WSFeedsPreloadStrategy", paramWeishiTask.toString());
      this.d = false;
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("WSRedDot preloadList is empty. task.mResultBean=");
    ((StringBuilder)localObject1).append(paramWeishiTask.m);
    WSLog.d("WSFeedsPreloadStrategy", ((StringBuilder)localObject1).toString());
  }
  
  private void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[checkSendRequest] checkCount: ");
    localStringBuilder.append(paramInt);
    WSLog.b("WSFeedsPreloadStrategy", localStringBuilder.toString());
    if (paramInt == 0) {
      return;
    }
    boolean bool = WeishiUtils.i();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[checkSendRequest] inRealActionLoginB: ");
    localStringBuilder.append(bool);
    WSLog.b("WSFeedsPreloadStrategy", localStringBuilder.toString());
    if (!bool)
    {
      c(paramString);
      WSLog.b("WSFeedsPreloadStrategy", "[checkSendRequest] sendRequest!");
      return;
    }
    this.c = new WSFeedsPreloadStrategy.1(this, paramString, paramInt);
    WeishiBusinessLooper.a().a(this.c, 30000L);
    WSLog.b("WSFeedsPreloadStrategy", "[checkSendRequest] postDelayed start!");
  }
  
  private void b(String paramString)
  {
    this.a = paramString;
    this.b = false;
    WSSharePreferencesUtil.a("key_red_dot_msg_uin", this.a);
  }
  
  private ArrayList<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.a);
    return localArrayList;
  }
  
  private void c(String paramString)
  {
    Object localObject = WeishiUtils.g();
    if (localObject != null) {
      localObject = ((WSRedDotPushMsg)localObject).mMsgData;
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[realPreloadRedData] scene:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", feedId=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", wsPushMsgData.mMsgData=");
    localStringBuilder.append((String)localObject);
    WSLog.d("WSFeedsPreloadStrategy", localStringBuilder.toString());
    localObject = new RecommendRequest(null, (byte)0, (byte)1, c(), this.e, null, null, null, (String)localObject);
    ((RecommendRequest)localObject).d = paramString;
    paramString = new WeishiTask((WeishiRequest)localObject, null, new WSFeedsPreloadStrategy.2(this), 1001);
    this.b = true;
    WeishiBusinessLooper.a().a(paramString);
  }
  
  private long d()
  {
    return WSExpPreloadABTestManager.a().f() * 1000L;
  }
  
  public void a()
  {
    if (this.c != null)
    {
      WeishiBusinessLooper.a().b(this.c);
      this.c = null;
      WSLog.b("WSFeedsPreloadStrategy", "[cancelPostDelayRunnable]");
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (!WSExpPreloadABTestManager.a().e())
      {
        paramString = new StringBuilder();
        paramString.append("[preloadRedDotData] mHadCleanPreCache:");
        paramString.append(this.d);
        WSLog.d("WSFeedsPreloadStrategy", paramString.toString());
        if (!this.d) {
          WeiShiCacheManager.a().c(this.e);
        }
        this.d = true;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preloadRedDotData] mCurrentUniSeq=structMsg.uniSeq: ");
      localStringBuilder.append(paramString);
      WSLog.b("WSFeedsPreloadStrategy", localStringBuilder.toString());
      if (TextUtils.equals(this.a, paramString))
      {
        boolean bool = this.b;
        if (bool) {
          return;
        }
        if (WeiShiCacheManager.a().a(this.e))
        {
          WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] isRedCacheInValidDuration: true");
          return;
        }
        paramString = new StringBuilder();
        paramString.append("[preloadRedDotData] mIsPreloadOutValidDuration: ");
        paramString.append(WSExpPreloadABTestManager.a().g());
        WSLog.d("WSFeedsPreloadStrategy", paramString.toString());
        if (!WSExpPreloadABTestManager.a().g()) {
          WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] mIsPreloadOutValidDuration: false");
        }
      }
      else
      {
        b(paramString);
      }
      paramString = new StringBuilder();
      paramString.append("[preloadRedDotData] mCurrentUniSeq: ");
      paramString.append(this.a);
      paramString.append(", mIsSendingRequest: ");
      paramString.append(this.b);
      WSLog.d("WSFeedsPreloadStrategy", paramString.toString());
      a();
      a(this.a, 3);
      return;
    }
    finally {}
  }
  
  public void b()
  {
    this.b = false;
    WeiShiCacheManager.a().c(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSFeedsPreloadStrategy
 * JD-Core Version:    0.7.0.1
 */