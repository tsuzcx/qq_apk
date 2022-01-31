package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.List;

public class GetUserGroupUnionIDHandler$GetUserGroupUnionIDEvent
  extends BaseEvent
{
  public List a;
  
  public GetUserGroupUnionIDHandler$GetUserGroupUnionIDEvent(ErrorMessage paramErrorMessage)
  {
    this.a = paramErrorMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent
 * JD-Core Version:    0.7.0.1
 */