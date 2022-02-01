package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.GroupID;
import java.util.List;

public class GetUserGroupUnionIDHandler$GetUserGroupUnionIDEvent
  extends BaseEvent
{
  public List<GroupID> a;
  
  public GetUserGroupUnionIDHandler$GetUserGroupUnionIDEvent(ErrorMessage paramErrorMessage)
  {
    this.g = paramErrorMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent
 * JD-Core Version:    0.7.0.1
 */