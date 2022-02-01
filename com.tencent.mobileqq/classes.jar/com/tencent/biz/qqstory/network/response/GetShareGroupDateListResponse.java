package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGroupDateVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupNodeInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupDateListResponse
  extends BaseResponse
{
  public long a;
  public String a;
  public ArrayList<VideoCollectionItem> a;
  public boolean a;
  
  public GetShareGroupDateListResponse(String paramString, qqstory_service.RspGroupDateVideoList paramRspGroupDateVideoList)
  {
    super(paramRspGroupDateVideoList.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = paramRspGroupDateVideoList.is_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_JavaLangString = paramRspGroupDateVideoList.next_cookie.get().toStringUtf8();
    this.jdField_a_of_type_Long = paramRspGroupDateVideoList.seqno.get();
    paramRspGroupDateVideoList = paramRspGroupDateVideoList.group_node_info.get().iterator();
    while (paramRspGroupDateVideoList.hasNext())
    {
      qqstory_struct.GroupNodeInfo localGroupNodeInfo = (qqstory_struct.GroupNodeInfo)paramRspGroupDateVideoList.next();
      VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
      localVideoCollectionItem.convertFrom("Q.qqstory.shareGroup:GetDateCollectionListResponse", paramString, localGroupNodeInfo);
      this.jdField_a_of_type_JavaUtilArrayList.add(localVideoCollectionItem);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareGroupDateListResponse{errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", nextCookie='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mCollectionItemList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetShareGroupDateListResponse
 * JD-Core Version:    0.7.0.1
 */