package com.tencent.biz.qqstory.storyHome.memory.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class VideoCollectionItem$FakeVideoUIItem
{
  public StoryVideoItem a;
  public String a;
  public boolean a;
  public boolean b = true;
  
  public VideoCollectionItem$FakeVideoUIItem(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof FakeVideoUIItem)) {
      return TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((FakeVideoUIItem)paramObject).jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem
 * JD-Core Version:    0.7.0.1
 */