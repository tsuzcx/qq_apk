package com.tencent.biz.qqstory.msgTabNode.network;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckActivity;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class MsgTabCheckActiveRequest
  extends NetworkRequest
{
  public static String e = StoryApi.a("StorySvc.check_activity");
  public String f;
  public final String g;
  
  public MsgTabCheckActiveRequest(String paramString)
  {
    this.g = paramString;
  }
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCheckActivity localRspCheckActivity = new qqstory_service.RspCheckActivity();
    try
    {
      localRspCheckActivity.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new MsgTabCheckActiveRequest.MsgTabCheckActiveResponse(localRspCheckActivity);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqCheckActivity localReqCheckActivity = new qqstory_service.ReqCheckActivity();
    if (!TextUtils.isEmpty(this.g)) {
      localReqCheckActivity.adcode.set(Long.valueOf(this.g).longValue());
    }
    SLog.a("MsgTabCheckActiveRequest", "client version=%s", "8.8.17");
    localReqCheckActivity.version.set("8.8.17");
    return localReqCheckActivity.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabCheckActiveRequest{value='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", adCode='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest
 * JD-Core Version:    0.7.0.1
 */