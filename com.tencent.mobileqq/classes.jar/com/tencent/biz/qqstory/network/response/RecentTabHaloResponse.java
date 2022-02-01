package com.tencent.biz.qqstory.network.response;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgListHeadNode;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentTabHaloResponse
  extends BaseResponse
{
  private String jdField_a_of_type_JavaLangString;
  private List<MsgTabNodeInfo> jdField_a_of_type_JavaUtilList;
  
  public RecentTabHaloResponse(@NonNull qqstory_service.RspMsgListHeadNode paramRspMsgListHeadNode)
  {
    super(paramRspMsgListHeadNode.result);
    this.jdField_a_of_type_JavaLangString = paramRspMsgListHeadNode.list_seq.get().toStringUtf8();
    this.jdField_a_of_type_JavaUtilList = a(paramRspMsgListHeadNode.node_list.get());
  }
  
  private static List<MsgTabNodeInfo> a(List<qqstory_service.MsgTabNodeInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qqstory_service.MsgTabNodeInfo localMsgTabNodeInfo = (qqstory_service.MsgTabNodeInfo)paramList.next();
      MsgTabNodeInfo localMsgTabNodeInfo1 = new MsgTabNodeInfo();
      localMsgTabNodeInfo1.a(localMsgTabNodeInfo);
      localArrayList.add(localMsgTabNodeInfo1);
    }
    return localArrayList;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<MsgTabNodeInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecentTabHaloResponse{mSeq='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMsgTabNodeInfos=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.RecentTabHaloResponse
 * JD-Core Version:    0.7.0.1
 */