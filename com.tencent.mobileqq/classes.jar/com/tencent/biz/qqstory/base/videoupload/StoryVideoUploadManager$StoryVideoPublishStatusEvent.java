package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.ArrayList;

public final class StoryVideoUploadManager$StoryVideoPublishStatusEvent
  extends BaseEvent
{
  public StoryVideoItem a;
  public GeneralFeedItem a;
  public ArrayList a;
  public final boolean a;
  public StoryVideoItem b;
  public boolean b;
  public boolean c;
  
  public StoryVideoUploadManager$StoryVideoPublishStatusEvent(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 940006) || (paramInt == 940007) || (paramInt == 940017) || (paramInt == 940018) || (paramInt == 941001) || (paramInt == 941002) || (paramInt == StoryUploadProcessor.a(940017)) || (paramInt == StoryUploadProcessor.a(9042)) || (paramInt == StoryUploadProcessor.a(9070)) || (paramInt == StoryUploadProcessor.a(9071)) || (paramInt / 100 == StoryUploadProcessor.a(999000) / 100) || ((paramInt >= 5100) && (paramInt <= 5108));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 941001) || (paramInt == 941002);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isTroopLocalVideoOnly();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  public String toString()
  {
    return "StoryVideoPublishStatusEvent{mFakeStoryVideoItem=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem + ", mSucStoryVideoItem=" + this.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem + ", mCommentLikeFeedItem=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem + ", mShareGroupFakeItems=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent
 * JD-Core Version:    0.7.0.1
 */