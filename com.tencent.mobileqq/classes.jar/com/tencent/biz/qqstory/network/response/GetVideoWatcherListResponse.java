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
  public long a = 0L;
  public long b = 0L;
  public List<qqstory_struct.UserSimpleInfo> e;
  
  public GetVideoWatcherListResponse(String paramString, qqstory_service.RspGetFeedVisitor paramRspGetFeedVisitor)
  {
    super(paramRspGetFeedVisitor.result);
    this.b = paramRspGetFeedVisitor.view_total_num.get();
    this.e = paramRspGetFeedVisitor.user_list.get();
    this.a = this.e.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetVideoWatcherListResponse{totalReadTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("totalWatcherCount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", userList=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetVideoWatcherListResponse
 * JD-Core Version:    0.7.0.1
 */