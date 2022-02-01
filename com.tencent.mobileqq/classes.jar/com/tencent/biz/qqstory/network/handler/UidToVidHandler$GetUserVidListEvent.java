package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.network.response.GetVidListResponse.UserVidList;
import java.util.ArrayList;
import java.util.List;

public class UidToVidHandler$GetUserVidListEvent
  extends BaseEvent
{
  public int a;
  public List<String> b = new ArrayList();
  public List<GetVidListResponse.UserVidList> c = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetUserVidListEvent{pullType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mUserVidList=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.UidToVidHandler.GetUserVidListEvent
 * JD-Core Version:    0.7.0.1
 */