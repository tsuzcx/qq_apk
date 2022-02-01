package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.List;

public class DefaultPlayerVideoListSynchronizer$PlayerVideoListEvent
  extends BaseEvent
{
  public String a;
  public String b;
  public String c;
  public long d;
  public List<StoryVideoItem> e = new ArrayList();
  public long f;
  public int h;
  public boolean i;
  public boolean j;
  public boolean k;
  public LiveVideoEntry l;
  public List<String> m;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayerVideoListEvent{context='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", label='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mStoryVideoItems=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", totalTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", isFromCache=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", interactStatus=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", liveVideoInfo=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent
 * JD-Core Version:    0.7.0.1
 */