package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class SendVideoToFriendHelper$GenShareThumbEvent
  extends BaseEvent
{
  public StoryVideoItem a;
  public String b;
  public String c;
  
  public SendVideoToFriendHelper$GenShareThumbEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    this.g = paramErrorMessage;
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.GenShareThumbEvent
 * JD-Core Version:    0.7.0.1
 */