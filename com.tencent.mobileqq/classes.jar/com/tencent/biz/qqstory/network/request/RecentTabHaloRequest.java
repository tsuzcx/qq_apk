package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgListHeadNode;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgListHeadNode;
import com.tencent.biz.qqstory.network.response.RecentTabHaloResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class RecentTabHaloRequest
  extends NetworkRequest<RecentTabHaloResponse>
{
  private static final String e = StoryApi.a("StoryLrSvc.msglist_head_node");
  private String f;
  private List<Long> g;
  private int h;
  
  public String a()
  {
    return e;
  }
  
  public int b()
  {
    return this.h;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgListHeadNode localRspMsgListHeadNode = new qqstory_service.RspMsgListHeadNode();
    try
    {
      localRspMsgListHeadNode.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeResponse: failed. Message: exception: ");
        localStringBuilder.append(paramArrayOfByte);
        QLog.e("RecentTabHaloRequest", 2, localStringBuilder.toString());
      }
    }
    return new RecentTabHaloResponse(localRspMsgListHeadNode);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqMsgListHeadNode localReqMsgListHeadNode = new qqstory_service.ReqMsgListHeadNode();
    PBBytesField localPBBytesField = localReqMsgListHeadNode.current_seq;
    String str = this.f;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    localReqMsgListHeadNode.uin_list.set(this.g);
    localReqMsgListHeadNode.source.set(this.h);
    localReqMsgListHeadNode.setHasFlag(true);
    return localReqMsgListHeadNode.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RecentTabHaloRequest{");
    localStringBuilder.append("mCurrentSeq='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUins=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mWhen=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.RecentTabHaloRequest
 * JD-Core Version:    0.7.0.1
 */