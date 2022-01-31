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
  extends NetworkRequest
{
  private static final String jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.msglist_head_node");
  private List jdField_a_of_type_JavaUtilList;
  private String b;
  private int c;
  
  public RecentTabHaloRequest(String paramString, List paramList, int paramInt)
  {
    this.b = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.c = paramInt;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMsgListHeadNode localRspMsgListHeadNode = new qqstory_service.RspMsgListHeadNode();
    try
    {
      localRspMsgListHeadNode.mergeFrom(paramArrayOfByte);
      return new RecentTabHaloResponse(localRspMsgListHeadNode);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecentTabHaloRequest", 2, "decodeResponse: failed. Message: exception: " + paramArrayOfByte);
        }
      }
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqMsgListHeadNode localReqMsgListHeadNode = new qqstory_service.ReqMsgListHeadNode();
    PBBytesField localPBBytesField = localReqMsgListHeadNode.current_seq;
    if (this.b != null) {}
    for (String str = this.b;; str = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localReqMsgListHeadNode.uin_list.set(this.jdField_a_of_type_JavaUtilList);
      localReqMsgListHeadNode.source.set(this.c);
      localReqMsgListHeadNode.setHasFlag(true);
      return localReqMsgListHeadNode.toByteArray();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RecentTabHaloRequest{");
    localStringBuilder.append("mCurrentSeq='").append(this.b).append('\'');
    localStringBuilder.append(", mUins=").append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", mWhen=").append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.RecentTabHaloRequest
 * JD-Core Version:    0.7.0.1
 */