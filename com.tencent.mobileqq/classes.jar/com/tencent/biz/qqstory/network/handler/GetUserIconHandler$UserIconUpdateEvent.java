package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import java.util.HashMap;

public class GetUserIconHandler$UserIconUpdateEvent
  extends BaseEvent
{
  public HashMap<String, String[]> a;
  
  public String toString()
  {
    return "InteractionInfoChangeEvent{iconMap=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler.UserIconUpdateEvent
 * JD-Core Version:    0.7.0.1
 */