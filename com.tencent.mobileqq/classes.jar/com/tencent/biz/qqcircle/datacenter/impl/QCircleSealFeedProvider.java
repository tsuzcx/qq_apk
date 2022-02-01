package com.tencent.biz.qqcircle.datacenter.impl;

import android.os.Bundle;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.datacenter.request.QCircleRecommendListRequest;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.rank.QCircleRankEventCollector;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetCloudSealFeedRsp;
import java.util.List;
import java.util.Map;

public class QCircleSealFeedProvider
  extends QCircleNetListProvider<FeedBlockData>
{
  private byte[] a;
  private FeedCloudCommon.StCommonExt b = new FeedCloudCommon.StCommonExt();
  
  public QCircleSealFeedProvider() {}
  
  public QCircleSealFeedProvider(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if ((!paramBoolean) && (a() != null) && (a().b() != null) && (a().b().size() > 0)) {
      a().c();
    }
    this.a = paramArrayOfByte;
  }
  
  private FeedCloudCommon.StCommonExt b()
  {
    if (this.a == null) {
      return null;
    }
    try
    {
      FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
      localBytesEntry.key.set("allpush_reddot");
      localBytesEntry.value.set(ByteStringMicro.copyFrom(this.a));
      this.b.mapBytesInfo.clear();
      this.b.mapBytesInfo.add(localBytesEntry);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set common ext msg error = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QCircleSealFeedProvider", 1, localStringBuilder.toString());
    }
    return this.b;
  }
  
  public QCircleBaseRequest a(String paramString)
  {
    FeedCloudCommon.StCommonExt localStCommonExt = b();
    QCircleRankEventCollector.getInstance().setExtCommonInfo(localStCommonExt);
    return new QCircleRecommendListRequest(paramString, localStCommonExt);
  }
  
  protected IDataStore<FeedBlockData> a()
  {
    return (IDataStore)QCircleFeedDataCenter.a().e().get("QCircleSealRawDataStore");
  }
  
  void a(QCircleRequestCall paramQCircleRequestCall)
  {
    paramQCircleRequestCall.b(new QCircleSealFeedProvider.SealRspInterceptor(null));
  }
  
  public void a(LoadInfo paramLoadInfo, BaseSenderChain paramBaseSenderChain)
  {
    if ((paramBaseSenderChain != null) && (paramBaseSenderChain.b() != null) && (a() != null) && (a().b() != null) && (!paramBaseSenderChain.b().getBoolean("extra_key_is_load_more"))) {
      a().b().clear();
    }
    super.a(paramLoadInfo, paramBaseSenderChain);
  }
  
  public String getAttachInfoFromRsp(Object paramObject)
  {
    if ((paramObject instanceof FeedCloudRead.StGetCloudSealFeedRsp)) {
      return ((FeedCloudRead.StGetCloudSealFeedRsp)paramObject).attachInfo.get();
    }
    return null;
  }
  
  public boolean getIsFinishFromRsp(Object paramObject)
  {
    return false;
  }
  
  public List<FeedBlockData> getListDataFromRsp(Object paramObject)
  {
    if ((paramObject instanceof FeedCloudRead.StGetCloudSealFeedRsp)) {
      return QCircleTransFormHelper.a(((FeedCloudRead.StGetCloudSealFeedRsp)paramObject).sealFeeds.get());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.impl.QCircleSealFeedProvider
 * JD-Core Version:    0.7.0.1
 */