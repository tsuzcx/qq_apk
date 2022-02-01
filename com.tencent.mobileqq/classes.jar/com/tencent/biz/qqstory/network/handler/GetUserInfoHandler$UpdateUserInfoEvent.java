package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

public class GetUserInfoHandler$UpdateUserInfoEvent
  extends BaseEvent
{
  public QQUserUIItem a;
  public List<QQUserUIItem> b;
  public String c;
  public String d;
  
  public String toString()
  {
    if (this.a == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("UpdateUserInfoEvent ");
      localStringBuilder.append(super.toString());
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdateUserInfoEvent ");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent
 * JD-Core Version:    0.7.0.1
 */