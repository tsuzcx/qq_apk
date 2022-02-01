package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;

public class DeleteStoryVideoHandler$StateVideoCollectionItem
{
  public int a;
  public VideoCollectionItem a;
  
  public DeleteStoryVideoHandler$StateVideoCollectionItem(int paramInt, VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem = paramVideoCollectionItem;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateVideoCollectionItem{itemKey=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.key);
    localStringBuilder.append(", operation=");
    String str;
    if (this.jdField_a_of_type_Int == 1) {
      str = "delete";
    } else {
      str = "update";
    }
    localStringBuilder.append(str);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler.StateVideoCollectionItem
 * JD-Core Version:    0.7.0.1
 */