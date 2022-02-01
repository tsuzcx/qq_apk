package com.tencent.biz.qqcircle.viewmodels;

import android.os.Bundle;
import com.tencent.QCircleCollection;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StBatchGetFeedDetailRsp;
import java.util.Collection;
import java.util.List;

class QCircleSealRankFeedViewModel$1
  implements Runnable
{
  QCircleSealRankFeedViewModel$1(QCircleSealRankFeedViewModel paramQCircleSealRankFeedViewModel, Bundle paramBundle, String paramString, Object paramObject) {}
  
  public void run()
  {
    boolean bool1 = this.a.getBoolean("extra_key_is_load_more");
    boolean bool2 = VSNetworkHelper.isProtocolCache(this.b);
    this.a.getInt("extra_key_tab_type");
    int i = this.a.getInt("extra_key_pull_scene_type");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestFeedsData");
    ((StringBuilder)localObject).append(i);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCache ");
    localStringBuilder.append(bool2);
    QCircleCollection.a((String)localObject, localStringBuilder.toString());
    if (this.this$0.a(bool2)) {
      return;
    }
    this.this$0.b(bool1);
    localObject = ((FeedCloudRead.StBatchGetFeedDetailRsp)this.c).feeds.get();
    this.this$0.j.addAll((Collection)localObject);
    if (this.this$0.j.size() > 0)
    {
      localObject = this.this$0;
      localObject = QCircleTransFormHelper.a(((QCircleSealRankFeedViewModel)localObject).a(bool2, ((QCircleSealRankFeedViewModel)localObject).j));
      QCircleFeedDataCenter.a().a((List)localObject, true);
      this.this$0.a(UIStateData.a(bool2).a(bool1, localObject).c(this.this$0.h));
      this.this$0.a((List)localObject, bool1);
      this.this$0.f = ((FeedBlockData)((List)localObject).get(((List)localObject).size() - 1)).b().id.get();
      localObject = this.this$0.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mFeedAttachInfo:");
      localStringBuilder.append(this.this$0.e());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    this.this$0.a(UIStateData.a().b(bool1).c(this.this$0.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleSealRankFeedViewModel.1
 * JD-Core Version:    0.7.0.1
 */