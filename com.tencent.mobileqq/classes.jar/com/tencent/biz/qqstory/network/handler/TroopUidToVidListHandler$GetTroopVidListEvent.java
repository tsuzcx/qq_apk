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
    return "GetTroopVidListEvent{pullType=" + this.jdField_a_of_type_Int + ", uin=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler.GetTroopVidListEvent
 * JD-Core Version:    0.7.0.1
 */