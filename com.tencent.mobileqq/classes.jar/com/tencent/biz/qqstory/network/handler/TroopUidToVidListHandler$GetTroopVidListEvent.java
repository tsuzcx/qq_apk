package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse.UserVidList;

public class TroopUidToVidListHandler$GetTroopVidListEvent
  extends BaseEvent
{
  public int a;
  public GetGroupVidListResponse.UserVidList a;
  public String a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetTroopVidListEvent{pullType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler.GetTroopVidListEvent
 * JD-Core Version:    0.7.0.1
 */