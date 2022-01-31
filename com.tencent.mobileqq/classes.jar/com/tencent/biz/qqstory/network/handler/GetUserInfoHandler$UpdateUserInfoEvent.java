package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class GetUserInfoHandler$UpdateUserInfoEvent
  extends BaseEvent
{
  public QQUserUIItem a;
  public String a;
  public List a;
  public String b;
  
  public String toString()
  {
    if (this.a == null) {
      return "UpdateUserInfoEvent " + super.toString();
    }
    return "UpdateUserInfoEvent " + this.a.toString() + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent
 * JD-Core Version:    0.7.0.1
 */