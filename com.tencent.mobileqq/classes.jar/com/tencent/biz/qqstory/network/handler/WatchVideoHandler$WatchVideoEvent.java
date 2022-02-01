package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;

public class WatchVideoHandler$WatchVideoEvent
  extends BaseEvent
{
  public String a;
  public String b;
  public boolean c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchVideoEvent{vid='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isLiveVideo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", unReadCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.WatchVideoHandler.WatchVideoEvent
 * JD-Core Version:    0.7.0.1
 */