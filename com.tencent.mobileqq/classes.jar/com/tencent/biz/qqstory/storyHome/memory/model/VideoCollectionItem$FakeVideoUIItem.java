package com.tencent.biz.qqstory.storyHome.memory.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class VideoCollectionItem$FakeVideoUIItem
{
  public String a;
  public StoryVideoItem b;
  public boolean c = false;
  public boolean d = true;
  
  public VideoCollectionItem$FakeVideoUIItem(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.a = paramString;
    this.b = paramStoryVideoItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof FakeVideoUIItem)) {
      return TextUtils.equals(this.a, ((FakeVideoUIItem)paramObject).a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem
 * JD-Core Version:    0.7.0.1
 */