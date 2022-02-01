package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleProfile.SetProfileReq;
import qqcircle.QQCircleProfile.SetProfileRsp;

public class QCircleSetProfileRequest
  extends QCircleBaseRequest
{
  private QQCircleProfile.SetProfileReq mReq = new QQCircleProfile.SetProfileReq();
  
  public QCircleSetProfileRequest() {}
  
  public QCircleSetProfileRequest(String paramString, List<FeedCloudMeta.StTagInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(10008));
    localArrayList.add(Integer.valueOf(10011));
    this.mReq.infoTypes.set(localArrayList);
    this.mReq.sign.set(paramString);
    if (paramList != null) {
      this.mReq.showTagList.set(paramList);
    }
  }
  
  public QCircleSetProfileRequest(String paramString, List<FeedCloudMeta.StTagInfo> paramList, List<Long> paramList1)
  {
    this(paramString, paramList);
    this.mReq.infoTypes.get().add(Integer.valueOf(10015));
    if (paramList1 != null) {
      this.mReq.groupIDList.set(paramList1);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleProfile.SetProfileRsp localSetProfileRsp = new QQCircleProfile.SetProfileRsp();
    try
    {
      localSetProfileRsp.mergeFrom(paramArrayOfByte);
      return localSetProfileRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localSetProfileRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.SetProfile";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  public void setPattonType(int paramInt)
  {
    List localList = this.mReq.infoTypes.get();
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(Integer.valueOf(10012));
    this.mReq.pattonType.set(paramInt);
    this.mReq.infoTypes.set((List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleSetProfileRequest
 * JD-Core Version:    0.7.0.1
 */