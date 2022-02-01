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
  private int jdField_a_of_type_Int;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public WSFeedsPreloadStrategy(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private long a()
  {
    return WSExpPreloadABTestManager.a().a() * 1000L;
  }
  
  private ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    return localArrayList;
  }
  
  private void a(WeishiTask paramWeishiTask)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramWeishiTask == null)
    {
      WSLog.d("WSFeedsPreloadStrategy", "WSRedDot preloadTask is null.");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onTaskResponse-resultCode:");
    ((StringBuilder)localObject1).append(paramWeishiTask.b);
    ((StringBuilder)localObject1).append(" | resultBean:");
    ((StringBuilder)localObject1).append(paramWeishiTask.jdField_a_of_type_JavaLangObject);
    ((StringBuilder)localObject1).append(" | thread:");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    WSLog.b("WSFeedsPreloadStrategy", ((StringBuilder)localObject1).toString());
    if (!paramWeishiTask.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WSRedDot preload request error. resultCode=");
      ((StringBuilder)localObject1).append(paramWeishiTask.b);
      WSLog.d("WSFeedsPreloadStrategy", ((StringBuilder)localObject1).toString());
      return;
    }
    if (!(paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest instanceof RecommendRequest)) {
      return;
    }
    localObject1 = (RecommendRequest)paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("WSRedDot recommendRequest.mRequestId=");
    ((StringBuilder)localObject2).append(((RecommendRequest)localObject1).b);
    ((StringBuilder)localObject2).append(", mCurrentUniSeq=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    WSLog.b("WSFeedsPreloadStrategy", ((StringBuilder)localObject2).toString());
    if ((TextUtils.equals(((RecommendRequest)localObject1).b, this.jdField_a_of_type_JavaLangString)) && ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      localObject2 = (stSimpleGetFeedListRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      localObject1 = ((stSimpleGetFeedListRsp)localObject2).feeds;
      if (paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean != null) {
        WSRecommendReportManager.a().a(((stSimpleGetFeedListRsp)localObject2).trace_id, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean.a);
      }
      long l = a();
      WeiShiCacheManager.a().a((List)localObject1, l, this.jdField_a_of_type_Int);
      paramWeishiTask = new StringBuilder();
      paramWeishiTask.append("WSRedDot preloadList.size:");
      paramWeishiTask.append(((ArrayList)localObject1).size());
      WSLog.a("WSFeedsPreloadStrategy", paramWeishiTask.toString());
      this.b = false;
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("WSRedDot preloadList is empty. task.mResultBean=");
    ((StringBuilder)localObject1).append(paramWeishiTask.jdField_a_of_type_JavaLangObject);
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
    boolean bool = WeishiUtils.b();
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
    this.jdField_a_of_type_JavaLangRunnable = new WSFeedsPreloadStrategy.1(this, paramString, paramInt);
    WeishiBusinessLooper.a().a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    WSLog.b("WSFeedsPreloadStrategy", "[checkSendRequest] postDelayed start!");
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
    WSSharePreferencesUtil.a("key_red_dot_msg_uin", this.jdField_a_of_type_JavaLangString);
  }
  
  private void c(String paramString)
  {
    Object localObject = WeishiUtils.a();
    if (localObject != null) {
      localObject = ((WSRedDotPushMsg)localObject).mMsgData;
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[realPreloadRedData] scene:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", feedId=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", wsPushMsgData.mMsgData=");
    localStringBuilder.append((String)localObject);
    WSLog.d("WSFeedsPreloadStrategy", localStringBuilder.toString());
    localObject = new RecommendRequest(null, (byte)0, (byte)1, a(), this.jdField_a_of_type_Int, null, null, null, (String)localObject);
    ((RecommendRequest)localObject).b = paramString;
    paramString = new WeishiTask((WeishiRequest)localObject, null, new WSFeedsPreloadStrategy.2(this), 1001);
    this.jdField_a_of_type_Boolean = true;
    WeishiBusinessLooper.a().a(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      WeishiBusinessLooper.a().b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
      WSLog.b("WSFeedsPreloadStrategy", "[cancelPostDelayRunnable]");
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (!WSExpPreloadABTestManager.a().c())
      {
        paramString = new StringBuilder();
        paramString.append("[preloadRedDotData] mHadCleanPreCache:");
        paramString.append(this.b);
        WSLog.d("WSFeedsPreloadStrategy", paramString.toString());
        if (!this.b) {
          WeiShiCacheManager.a().a(this.jdField_a_of_type_Int);
        }
        this.b = true;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preloadRedDotData] mCurrentUniSeq=structMsg.uniSeq: ");
      localStringBuilder.append(paramString);
      WSLog.b("WSFeedsPreloadStrategy", localStringBuilder.toString());
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        if (WeiShiCacheManager.a().a(this.jdField_a_of_type_Int))
        {
          WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] isRedCacheInValidDuration: true");
          return;
        }
        paramString = new StringBuilder();
        paramString.append("[preloadRedDotData] mIsPreloadOutValidDuration: ");
        paramString.append(WSExpPreloadABTestManager.a().d());
        WSLog.d("WSFeedsPreloadStrategy", paramString.toString());
        if (!WSExpPreloadABTestManager.a().d()) {
          WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] mIsPreloadOutValidDuration: false");
        }
      }
      else
      {
        b(paramString);
      }
      paramString = new StringBuilder();
      paramString.append("[preloadRedDotData] mCurrentUniSeq: ");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      paramString.append(", mIsSendingRequest: ");
      paramString.append(this.jdField_a_of_type_Boolean);
      WSLog.d("WSFeedsPreloadStrategy", paramString.toString());
      a();
      a(this.jdField_a_of_type_JavaLangString, 3);
      return;
    }
    finally {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    WeiShiCacheManager.a().a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSFeedsPreloadStrategy
 * JD-Core Version:    0.7.0.1
 */