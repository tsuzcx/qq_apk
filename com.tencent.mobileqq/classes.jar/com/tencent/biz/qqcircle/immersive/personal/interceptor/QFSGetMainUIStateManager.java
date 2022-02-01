package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;

public class QFSGetMainUIStateManager
  extends QFSUIStateBaseManager<FeedBlockData, QFSGetMainPageRequest, FeedCloudRead.StGetMainPageRsp>
{
  private String a;
  
  public List<FeedBlockData> a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, boolean paramBoolean)
  {
    this.a = paramStGetMainPageRsp.feedAttchInfo.get();
    paramStGetMainPageRsp = QCircleTransFormHelper.a(paramStGetMainPageRsp.vecFeed.get());
    if (!paramBoolean) {
      QCircleFeedDataCenter.a().a(paramStGetMainPageRsp, true);
    }
    return paramStGetMainPageRsp;
  }
  
  protected void a(QFSGetMainPageRequest paramQFSGetMainPageRequest)
  {
    if ((paramQFSGetMainPageRequest != null) && (!TextUtils.isEmpty(this.a))) {
      paramQFSGetMainPageRequest.setAttachInfo(this.a);
    }
  }
  
  public boolean a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    return paramStGetMainPageRsp.isFinish.get() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSGetMainUIStateManager
 * JD-Core Version:    0.7.0.1
 */