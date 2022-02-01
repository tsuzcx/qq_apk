package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;

public class DeleteStoryVideoHandler$StateVideoCollectionItem
{
  public VideoCollectionItem a;
  public int b;
  
  public DeleteStoryVideoHandler$StateVideoCollectionItem(int paramInt, VideoCollectionItem paramVideoCollectionItem)
  {
    this.b = paramInt;
    this.a = paramVideoCollectionItem;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateVideoCollectionItem{itemKey=");
    localStringBuilder.append(this.a.key);
    localStringBuilder.append(", operation=");
    String str;
    if (this.b == 1) {
      str = "delete";
    } else {
      str = "update";
    }
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler.StateVideoCollectionItem
 * JD-Core Version:    0.7.0.1
 */