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
  private static final String jdField_a_of_type_JavaLangString = StoryApi.a("StoryLrSvc.msglist_head_node");
  private List<Long> jdField_a_of_type_JavaUtilList;
  private String b;
  private int c;
  
  public int a()
  {
    return this.c;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
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
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgListHeadNode localReqMsgListHeadNode = new qqstory_service.ReqMsgListHeadNode();
    PBBytesField localPBBytesField = localReqMsgListHeadNode.current_seq;
    String str = this.b;
    if (str == null) {
      str = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    localReqMsgListHeadNode.uin_list.set(this.jdField_a_of_type_JavaUtilList);
    localReqMsgListHeadNode.source.set(this.c);
    localReqMsgListHeadNode.setHasFlag(true);
    return localReqMsgListHeadNode.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RecentTabHaloRequest{");
    localStringBuilder.append("mCurrentSeq='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUins=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", mWhen=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.RecentTabHaloRequest
 * JD-Core Version:    0.7.0.1
 */