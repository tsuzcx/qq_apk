package com.tencent.biz.richframework.network.request;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictReq;
import NS_QQ_STORY_CLIENT.CLIENT.StGetWatermarkDictRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBStringField;

public class GetWatermarkDictRequest
  extends VSBaseRequest
{
  public static final String TAG = "Q.qqstory:GetWatermarkDictRequest";
  public final CLIENT.StGetWatermarkDictReq req = new CLIENT.StGetWatermarkDictReq();
  
  public GetWatermarkDictRequest(COMM.StCommonExt paramStCommonExt, double paramDouble1, double paramDouble2, String paramString)
  {
    this.req.extInfo.set(paramStCommonExt);
    this.req.fLat.set(paramDouble1);
    this.req.fLon.set(paramDouble2);
    this.req.clientIP.set(paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CLIENT.StGetWatermarkDictRsp localStGetWatermarkDictRsp = new CLIENT.StGetWatermarkDictRsp();
    try
    {
      localStGetWatermarkDictRsp.mergeFrom(paramArrayOfByte);
      return localStGetWatermarkDictRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetWatermarkDictRsp;
  }
  
  public String getCmdName()
  {
    return "LightAppSvc.qq_story_client.GetWatermarkDict";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.GetWatermarkDictRequest
 * JD-Core Version:    0.7.0.1
 */