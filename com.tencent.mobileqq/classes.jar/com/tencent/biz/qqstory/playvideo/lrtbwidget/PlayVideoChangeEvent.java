package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;

public class PlayVideoChangeEvent
  extends BaseEvent
{
  public String a;
  public IDataProvider.GroupId b;
  public String c;
  
  public PlayVideoChangeEvent(@Nullable String paramString1, IDataProvider.GroupId paramGroupId, String paramString2)
  {
    this.a = paramString1;
    this.b = paramGroupId;
    this.c = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayVideoChangeEvent{openPlayerSessionId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", groupId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent
 * JD-Core Version:    0.7.0.1
 */