package com.tencent.biz.pubaccount.weishi_new.presenter;

import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerStatusListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSFollowPlayerStatusListenerImpl
  implements WSPlayerStatusListener
{
  private WSFollowAdapter a;
  
  public WSFollowPlayerStatusListenerImpl(WSFollowAdapter paramWSFollowAdapter)
  {
    this.a = paramWSFollowAdapter;
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    paramString = new StringBuilder().append("[onVideoError] video: ");
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null)) {}
    for (paramWSPlayerParam = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;; paramWSPlayerParam = "")
    {
      WSLog.b("WSFollowPlayerStatusListenerImpl", paramWSPlayerParam);
      return;
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoStop] video: ");
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null)) {}
    for (String str = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;; str = "")
    {
      WSLog.b("WSFollowPlayerStatusListenerImpl", str);
      new WSFollowPlayerStatusListenerImpl.1(this, paramWSPlayerParam, paramBoolean).run();
      return;
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoStart] video: ");
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null)) {}
    for (String str = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;; str = "")
    {
      WSLog.b("WSFollowPlayerStatusListenerImpl", str);
      WSFollowBeaconReport.a(paramWSPlayerParam);
      if (this.a != null) {
        this.a.a();
      }
      return;
    }
  }
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if ((paramWSPlayerParam == null) || (this.a == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[onCompletion] videoTitle: ");
    if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null) {}
    for (Object localObject = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;; localObject = "videoInfo is null!")
    {
      WSLog.e("WSFollowPlayerStatusListenerImpl", (String)localObject);
      localObject = this.a.a();
      if ((localObject == null) || (!((WSPlayerManager)localObject).j())) {
        break;
      }
      WSLog.e("WSFollowPlayerStatusListenerImpl", "[onCompletion] loopPlayMode: true");
      ((WSPlayerManager)localObject).b(paramWSPlayerParam, false);
      return;
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoPause] video: ");
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null)) {}
    for (paramWSPlayerParam = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;; paramWSPlayerParam = "")
    {
      WSLog.b("WSFollowPlayerStatusListenerImpl", paramWSPlayerParam);
      return;
    }
  }
  
  public void e(WSPlayerParam paramWSPlayerParam)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoRestart] video: ");
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null)) {}
    for (paramWSPlayerParam = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;; paramWSPlayerParam = "")
    {
      WSLog.b("WSFollowPlayerStatusListenerImpl", paramWSPlayerParam);
      return;
    }
  }
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowPlayerStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */