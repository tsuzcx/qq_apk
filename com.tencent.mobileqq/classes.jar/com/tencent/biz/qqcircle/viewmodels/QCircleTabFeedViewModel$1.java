package com.tencent.biz.qqcircle.viewmodels;

import android.os.Bundle;
import com.tencent.QCircleCollection;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleTabFeedViewModel$1
  implements Runnable
{
  QCircleTabFeedViewModel$1(QCircleTabFeedViewModel paramQCircleTabFeedViewModel, Object paramObject1, Object paramObject2, Bundle paramBundle, String paramString, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    QCircleTabGetFeedListRequest localQCircleTabGetFeedListRequest = (QCircleTabGetFeedListRequest)this.a;
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = (FeedCloudRead.StGetFeedListRsp)this.b;
    boolean bool1 = this.c.getBoolean("extra_key_is_load_more");
    boolean bool2 = VSNetworkHelper.isProtocolCache(this.d);
    int i = this.c.getInt("extra_key_tab_type");
    int j = this.c.getInt("extra_key_pull_scene_type");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestFeedsData");
    ((StringBuilder)localObject).append(j);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCache ");
    localStringBuilder.append(bool2);
    QCircleCollection.a((String)localObject, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestFeedsData onReceive: dispatch Success:");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" | TraceId:");
    ((StringBuilder)localObject).append(localQCircleTabGetFeedListRequest.getTraceId());
    ((StringBuilder)localObject).append(" | SeqId:");
    ((StringBuilder)localObject).append(localQCircleTabGetFeedListRequest.getCurrentSeq());
    ((StringBuilder)localObject).append(" | retCode:");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(" | retMessage:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" | isLoadMore:");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" | isCache:");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(" | tabType:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" | pullSceneType:");
    ((StringBuilder)localObject).append(j);
    QLog.d("QCircleTabFeedViewModel", 1, ((StringBuilder)localObject).toString());
    if (this.this$0.a(bool2)) {
      return;
    }
    if (QCircleTabFeedViewModel.a(this.this$0, bool2, i, localStGetFeedListRsp)) {
      return;
    }
    this.this$0.b(bool1);
    this.this$0.a(localStGetFeedListRsp);
    this.this$0.b(localStGetFeedListRsp);
    this.this$0.c(localStGetFeedListRsp);
    this.this$0.d(localStGetFeedListRsp);
    this.this$0.e(localStGetFeedListRsp);
    this.this$0.a(bool1, bool2);
    QCircleTabFeedViewModel.a(this.this$0, bool2, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleTabFeedViewModel.1
 * JD-Core Version:    0.7.0.1
 */