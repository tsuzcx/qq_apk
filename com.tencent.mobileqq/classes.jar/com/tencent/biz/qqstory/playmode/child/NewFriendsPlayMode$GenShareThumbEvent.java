package com.tencent.biz.qqstory.playmode.child;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class NewFriendsPlayMode$GenShareThumbEvent
  extends BaseEvent
{
  public StoryVideoItem a;
  public String a;
  
  public NewFriendsPlayMode$GenShareThumbEvent(ErrorMessage paramErrorMessage)
  {
    this.a = paramErrorMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode.GenShareThumbEvent
 * JD-Core Version:    0.7.0.1
 */