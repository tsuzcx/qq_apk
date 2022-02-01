package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse.UserVidList;

public class TroopUidToVidListHandler$GetTroopVidListEvent
  extends BaseEvent
{
  public int a;
  public String b;
  public GetGroupVidListResponse.UserVidList c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetTroopVidListEvent{pullType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler.GetTroopVidListEvent
 * JD-Core Version:    0.7.0.1
 */