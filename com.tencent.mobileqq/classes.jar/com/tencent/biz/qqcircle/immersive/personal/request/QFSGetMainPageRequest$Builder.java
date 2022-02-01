package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest.Builder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import java.util.Locale;
import qqcircle.QQCircleFeedBase.StMainPageBusiReqData;

public class QFSGetMainPageRequest$Builder
  extends QCircleBaseRequest.Builder<QFSGetMainPageRequest>
{
  private final FeedCloudRead.StGetMainPageReq b = new FeedCloudRead.StGetMainPageReq();
  private final QQCircleFeedBase.StMainPageBusiReqData c = new QQCircleFeedBase.StMainPageBusiReqData();
  
  public QFSGetMainPageRequest$Builder(String paramString)
  {
    this.b.userId.set(paramString);
  }
  
  public Builder a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    paramString1 = String.format(Locale.getDefault(), "uin=%s&feedid=%s&createtime=%d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    this.c.reqType.set(paramInt);
    this.c.entrySchema.set(paramString1);
    return this;
  }
  
  public QFSGetMainPageRequest a()
  {
    this.b.busiReqData.set(ByteStringMicro.copyFrom(this.c.toByteArray()));
    this.a = new QFSGetMainPageRequest(this.b, null);
    ((QFSGetMainPageRequest)this.a).setUin(this.b.userId.get());
    return (QFSGetMainPageRequest)this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageRequest.Builder
 * JD-Core Version:    0.7.0.1
 */