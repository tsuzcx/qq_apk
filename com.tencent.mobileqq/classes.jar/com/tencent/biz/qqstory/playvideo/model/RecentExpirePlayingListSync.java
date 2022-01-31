package com.tencent.biz.qqstory.playvideo.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.List;

public class RecentExpirePlayingListSync
  extends BasePagePlayingListSync
{
  protected String c;
  
  protected int a()
  {
    return 27;
  }
  
  protected void c()
  {
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    localPlayerVideoListEvent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_b_of_type_JavaLangString = this.c;
    localPlayerVideoListEvent.jdField_a_of_type_Boolean = true;
    localPlayerVideoListEvent.jdField_b_of_type_Boolean = true;
    StoryItem localStoryItem = ((StoryManager)SuperManager.a(5)).a(this.c, 2);
    StoryVideoItem localStoryVideoItem = new StoryVideoItem();
    if (localStoryItem != null)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
        localStoryVideoItem.mOwnerUid = this.c;
      }
      localStoryVideoItem.mVideoThumbnailUrl = localStoryItem.getCoverUrl();
      localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.add(localStoryVideoItem);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(localStoryVideoItem);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.RecentExpirePlayingListSync
 * JD-Core Version:    0.7.0.1
 */