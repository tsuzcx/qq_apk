package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public final class PlayModeUtils$DownloadStatusChangeEvent
  extends BaseEvent
{
  public String a;
  public int b;
  public StoryVideoItem c;
  public String d;
  
  public PlayModeUtils$DownloadStatusChangeEvent(String paramString, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramStoryVideoItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DownloadStatusChangeEvent
 * JD-Core Version:    0.7.0.1
 */