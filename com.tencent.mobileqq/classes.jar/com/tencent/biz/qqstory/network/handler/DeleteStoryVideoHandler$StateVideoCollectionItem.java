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
    StringBuilder localStringBuilder = new StringBuilder().append("StateVideoCollectionItem{itemKey=").append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem.key).append(", operation=");
    if (this.jdField_a_of_type_Int == 1) {}
    for (String str = "delete";; str = "update") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler.StateVideoCollectionItem
 * JD-Core Version:    0.7.0.1
 */