package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public final class PlayModeUtils$DownloadStatusChangeEvent
  extends BaseEvent
{
  public int a;
  public StoryVideoItem a;
  public String a;
  public String b;
  
  public PlayModeUtils$DownloadStatusChangeEvent(String paramString, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DownloadStatusChangeEvent
 * JD-Core Version:    0.7.0.1
 */