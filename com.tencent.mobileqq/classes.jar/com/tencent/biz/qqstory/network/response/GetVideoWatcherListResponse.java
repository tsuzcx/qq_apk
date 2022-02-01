package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFeedVisitor;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserSimpleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class GetVideoWatcherListResponse
  extends BaseResponse
{
  public long a;
  public List<qqstory_struct.UserSimpleInfo> a;
  public long b = 0L;
  
  public GetVideoWatcherListResponse(String paramString, qqstory_service.RspGetFeedVisitor paramRspGetFeedVisitor)
  {
    super(paramRspGetFeedVisitor.result);
    this.jdField_a_of_type_Long = 0L;
    this.b = paramRspGetFeedVisitor.view_total_num.get();
    this.jdField_a_of_type_JavaUtilList = paramRspGetFeedVisitor.user_list.get();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetVideoWatcherListResponse{totalReadTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("totalWatcherCount=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", userList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetVideoWatcherListResponse
 * JD-Core Version:    0.7.0.1
 */