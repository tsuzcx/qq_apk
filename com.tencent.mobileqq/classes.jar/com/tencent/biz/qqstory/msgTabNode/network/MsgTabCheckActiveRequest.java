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
  public static String a = StoryApi.a("StorySvc.check_activity");
  public String b;
  public final String c;
  
  public MsgTabCheckActiveRequest(String paramString)
  {
    this.c = paramString;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCheckActivity localRspCheckActivity = new qqstory_service.RspCheckActivity();
    try
    {
      localRspCheckActivity.mergeFrom(paramArrayOfByte);
      return new MsgTabCheckActiveRequest.MsgTabCheckActiveResponse(localRspCheckActivity);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return a;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqCheckActivity localReqCheckActivity = new qqstory_service.ReqCheckActivity();
    if (!TextUtils.isEmpty(this.c)) {
      localReqCheckActivity.adcode.set(Long.valueOf(this.c).longValue());
    }
    SLog.a("MsgTabCheckActiveRequest", "client version=%s", "8.5.5");
    localReqCheckActivity.version.set("8.5.5");
    return localReqCheckActivity.toByteArray();
  }
  
  public String toString()
  {
    return "MsgTabCheckActiveRequest{value='" + this.b + '\'' + ", adCode='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest
 * JD-Core Version:    0.7.0.1
 */