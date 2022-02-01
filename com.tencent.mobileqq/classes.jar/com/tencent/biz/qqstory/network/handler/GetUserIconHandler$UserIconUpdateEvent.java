package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import java.util.HashMap;

public class GetUserIconHandler$UserIconUpdateEvent
  extends BaseEvent
{
  public HashMap<String, String[]> a;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InteractionInfoChangeEvent{iconMap=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler.UserIconUpdateEvent
 * JD-Core Version:    0.7.0.1
 */