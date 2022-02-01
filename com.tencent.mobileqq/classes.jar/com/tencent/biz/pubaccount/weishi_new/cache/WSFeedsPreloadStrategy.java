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
    if (paramWeishiTask == null) {
      WSLog.d("WSFeedsPreloadStrategy", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      WSLog.b("WSFeedsPreloadStrategy", "onTaskResponse-resultCode:" + paramWeishiTask.b + " | resultBean:" + paramWeishiTask.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramWeishiTask.a())
      {
        WSLog.d("WSFeedsPreloadStrategy", "WSRedDot preload request error. resultCode=" + paramWeishiTask.b);
        return;
      }
    } while (!(paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest instanceof RecommendRequest));
    Object localObject = (RecommendRequest)paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest;
    WSLog.b("WSFeedsPreloadStrategy", "WSRedDot recommendRequest.mRequestId=" + ((RecommendRequest)localObject).b + ", mCurrentUniSeq=" + this.jdField_a_of_type_JavaLangString);
    if ((TextUtils.equals(((RecommendRequest)localObject).b, this.jdField_a_of_type_JavaLangString)) && ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      localObject = (stSimpleGetFeedListRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      ArrayList localArrayList = ((stSimpleGetFeedListRsp)localObject).feeds;
      if (paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean != null) {
        WSRecommendReportManager.a().a(((stSimpleGetFeedListRsp)localObject).trace_id, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean.a);
      }
      long l = a();
      WeiShiCacheManager.a().a(localArrayList, l, this.jdField_a_of_type_Int);
      WSLog.a("WSFeedsPreloadStrategy", "WSRedDot preloadList.size:" + localArrayList.size());
      this.b = false;
      return;
    }
    WSLog.d("WSFeedsPreloadStrategy", "WSRedDot preloadList is empty. task.mResultBean=" + paramWeishiTask.jdField_a_of_type_JavaLangObject);
  }
  
  private void a(String paramString, int paramInt)
  {
    WSLog.b("WSFeedsPreloadStrategy", "[checkSendRequest] checkCount: " + paramInt);
    if (paramInt == 0) {
      return;
    }
    boolean bool = WeishiUtils.b();
    WSLog.b("WSFeedsPreloadStrategy", "[checkSendRequest] inRealActionLoginB: " + bool);
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
    Object localObject = "";
    WSRedDotPushMsg localWSRedDotPushMsg = WeishiUtils.a();
    if (localWSRedDotPushMsg != null) {
      localObject = localWSRedDotPushMsg.mMsgData;
    }
    WSLog.d("WSFeedsPreloadStrategy", "[realPreloadRedData] scene:" + this.jdField_a_of_type_Int + ", feedId=" + paramString + ", wsPushMsgData.mMsgData=" + (String)localObject);
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
    for (;;)
    {
      try
      {
        if (!WSExpPreloadABTestManager.a().c())
        {
          WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] mHadCleanPreCache:" + this.b);
          if (!this.b) {
            WeiShiCacheManager.a().a(this.jdField_a_of_type_Int);
          }
          this.b = true;
          return;
        }
        WSLog.b("WSFeedsPreloadStrategy", "[preloadRedDotData] mCurrentUniSeq=structMsg.uniSeq: " + paramString);
        if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {
          break label184;
        }
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        if (WeiShiCacheManager.a().a(this.jdField_a_of_type_Int))
        {
          WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] isRedCacheInValidDuration: true");
          continue;
        }
        WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] mIsPreloadOutValidDuration: " + WSExpPreloadABTestManager.a().d());
      }
      finally {}
      if (!WSExpPreloadABTestManager.a().d())
      {
        WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] mIsPreloadOutValidDuration: false");
        continue;
        label184:
        b(paramString);
      }
      else
      {
        WSLog.d("WSFeedsPreloadStrategy", "[preloadRedDotData] mCurrentUniSeq: " + this.jdField_a_of_type_JavaLangString + ", mIsSendingRequest: " + this.jdField_a_of_type_Boolean);
        a();
        a(this.jdField_a_of_type_JavaLangString, 3);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    WeiShiCacheManager.a().a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSFeedsPreloadStrategy
 * JD-Core Version:    0.7.0.1
 */