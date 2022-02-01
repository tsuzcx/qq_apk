package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StBusiInfoReqData;

public class QCircleGetTabListRequest
  extends QCircleBaseRequest
{
  public final FeedCloudRead.StGetBusiInfoReq mReq = new FeedCloudRead.StGetBusiInfoReq();
  
  public QCircleGetTabListRequest(FeedCloudMeta.StGPSV2 paramStGPSV2, QCircleFolderBean paramQCircleFolderBean)
  {
    QQCircleFeedBase.StBusiInfoReqData localStBusiInfoReqData = new QQCircleFeedBase.StBusiInfoReqData();
    if (QCirclePluginConfig.a().t() != null) {
      localStBusiInfoReqData.busiMap.set(QCirclePluginConfig.a().t().busiMap.get());
    }
    if (paramStGPSV2 != null) {
      localStBusiInfoReqData.gpsInfo.set(paramStGPSV2);
    }
    if ((paramQCircleFolderBean != null) && (paramQCircleFolderBean.getLastPageScheme() != null)) {
      localStBusiInfoReqData.entrySchema.set(paramQCircleFolderBean.getLastPageScheme());
    }
    this.mReq.busiReqData.set(ByteStringMicro.copyFrom(localStBusiInfoReqData.toByteArray()));
    a();
  }
  
  private void a()
  {
    boolean bool = QCircleConfigHelper.aD();
    Object localObject = new FeedCloudCommon.StCommonExt();
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    localEntry.key.set("needCityTab");
    PBStringField localPBStringField = localEntry.value;
    String str2 = "1";
    String str1;
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localPBStringField.set(str1);
    ((FeedCloudCommon.StCommonExt)localObject).mapInfo.set(Arrays.asList(new FeedCloudCommon.Entry[] { localEntry }));
    this.mReq.extInfo.set((MessageMicro)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wrapNearbyTabOpenConfig open bit is:");
    if (bool) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    ((StringBuilder)localObject).append(str1);
    QLog.d("QCircleGetTabListRequest", 1, ((StringBuilder)localObject).toString());
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetBusiInfoRsp localStGetBusiInfoRsp = new FeedCloudRead.StGetBusiInfoRsp();
    try
    {
      localStGetBusiInfoRsp.mergeFrom(paramArrayOfByte);
      return localStGetBusiInfoRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetBusiInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetBusiInfo";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public byte[] getRequestByteKey()
  {
    return new FeedCloudRead.StGetBusiInfoReq().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest
 * JD-Core Version:    0.7.0.1
 */