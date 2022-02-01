package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.folder.QCirclePageLayoutTypeHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;

public class QCircleTabGetFeedListRequest$Builder
{
  private QCircleTabInfo a;
  private String b = "";
  private String c = "";
  private FeedCloudMeta.StGPSV2 d;
  private int e;
  private QQCircleFeedBase.StPageRedPointInfo f;
  private QCircleFolderBean g;
  
  private void a(QQCircleFeedBase.StFeedListBusiReqData paramStFeedListBusiReqData)
  {
    int i;
    try
    {
      i = Integer.parseInt(QCircleConfigHelper.bm());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNewLayerMode:");
    localStringBuilder.append(i);
    QLog.i("QCircleTabGetFeedListRequest", 1, localStringBuilder.toString());
    if (i > 0) {
      paramStFeedListBusiReqData.pageLayoutType.set(i);
    }
  }
  
  public Builder a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder a(QCircleFolderBean paramQCircleFolderBean)
  {
    this.g = paramQCircleFolderBean;
    return this;
  }
  
  public Builder a(QCircleTabInfo paramQCircleTabInfo)
  {
    this.a = paramQCircleTabInfo;
    return this;
  }
  
  public Builder a(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    this.d = paramStGPSV2;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Builder a(QQCircleFeedBase.StPageRedPointInfo paramStPageRedPointInfo)
  {
    this.f = paramStPageRedPointInfo;
    return this;
  }
  
  public FeedCloudRead.StGetFeedListReq a()
  {
    FeedCloudRead.StGetFeedListReq localStGetFeedListReq = new FeedCloudRead.StGetFeedListReq();
    localStGetFeedListReq.listNum.set(10);
    localStGetFeedListReq.from.set(0);
    localStGetFeedListReq.source.set(this.a.c());
    if (this.b != null) {
      localStGetFeedListReq.feedAttchInfo.set(this.b);
    }
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.tabAttachInfo.set(this.a.d());
    if (this.c != null)
    {
      localStFeedListBusiReqData.refreshAttachInfo.set(this.c);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QCircleGetFeedListRequest RefreshAttachInfo:");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("QCircleTabGetFeedListRequest", 2, ((StringBuilder)localObject).toString());
    }
    if (this.d != null) {
      localStFeedListBusiReqData.gpsInfo.set(this.d);
    }
    if (this.f != null) {
      localStFeedListBusiReqData.RedPointInfo.set(this.f);
    }
    localStFeedListBusiReqData.pullSceneType.set(this.e);
    Object localObject = this.g;
    if ((localObject != null) && (((QCircleFolderBean)localObject).getLastPageScheme() != null)) {
      localStFeedListBusiReqData.entrySchema.set(this.g.getLastPageScheme());
    }
    localObject = this.g;
    if ((localObject != null) && (((QCircleFolderBean)localObject).getFeed() != null))
    {
      localObject = QCirclePluginUtil.a(this.g.getFeed());
      if (localObject != null)
      {
        ((FeedCloudMeta.StFeed)localObject).busiTranparent.set(this.g.getFeed().busiTranparent.get());
        localStGetFeedListReq.feed.set((MessageMicro)localObject);
      }
    }
    localStFeedListBusiReqData.allPushPageLayoutType.set(QCirclePageLayoutTypeHelper.a().b());
    a(localStFeedListBusiReqData);
    localStGetFeedListReq.busiReqData.set(ByteStringMicro.copyFrom(localStFeedListBusiReqData.toByteArray()));
    return localStGetFeedListReq;
  }
  
  public Builder b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public FeedCloudRead.StGetFeedListReq b()
  {
    FeedCloudRead.StGetFeedListReq localStGetFeedListReq = new FeedCloudRead.StGetFeedListReq();
    localStGetFeedListReq.listNum.set(10);
    localStGetFeedListReq.from.set(0);
    localStGetFeedListReq.source.set(this.a.c());
    return localStGetFeedListReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest.Builder
 * JD-Core Version:    0.7.0.1
 */