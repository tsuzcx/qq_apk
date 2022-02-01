package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QFSGetFeedListUIStateManager
  extends QFSUIStateBaseManager<FeedBlockData, QFSGetFeedListRequest, FeedCloudRead.StGetFeedListRsp>
{
  private String a;
  private String b;
  
  public List<FeedBlockData> a(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean)
  {
    this.a = paramStGetFeedListRsp.feedAttchInfo.get();
    List localList = paramStGetFeedListRsp.vecFeed.get();
    if (paramStGetFeedListRsp.busiRspData.has())
    {
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      try
      {
        localStFeedListBusiRspData.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        paramStGetFeedListRsp.printStackTrace();
      }
      if (localStFeedListBusiRspData.refreshAttachInfo.has()) {
        this.b = localStFeedListBusiRspData.refreshAttachInfo.get();
      }
    }
    paramStGetFeedListRsp = QCircleTransFormHelper.a(localList);
    if (!paramBoolean) {
      QCircleFeedDataCenter.a().a(paramStGetFeedListRsp, true);
    }
    return paramStGetFeedListRsp;
  }
  
  protected void a(QFSGetFeedListRequest paramQFSGetFeedListRequest)
  {
    if (paramQFSGetFeedListRequest != null)
    {
      if (TextUtils.isEmpty(this.a)) {
        return;
      }
      paramQFSGetFeedListRequest.setAttachInfo(this.a);
    }
  }
  
  public boolean a(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    return paramStGetFeedListRsp.isFinish.get() > 0;
  }
  
  protected void b(QFSGetFeedListRequest paramQFSGetFeedListRequest)
  {
    if (paramQFSGetFeedListRequest != null)
    {
      if (TextUtils.isEmpty(this.b)) {
        return;
      }
      paramQFSGetFeedListRequest.setRefreshAttachInfo(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSGetFeedListUIStateManager
 * JD-Core Version:    0.7.0.1
 */