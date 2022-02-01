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
  public ArrayList<StoryVideoUploadManager.ShareGroupFakeItem> a;
  public final boolean a;
  public StoryVideoItem b;
  public boolean b;
  public boolean c = false;
  
  public StoryVideoUploadManager$StoryVideoPublishStatusEvent(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 940006) || (paramInt == 940007) || (paramInt == 940017) || (paramInt == 940018) || (paramInt == 941001) || (paramInt == 941002) || (paramInt == StoryUploadProcessor.makeStoryErrorCoder(940017)) || (paramInt == StoryUploadProcessor.makeStoryErrorCoder(9042)) || (paramInt == StoryUploadProcessor.makeStoryErrorCoder(9070)) || (paramInt == StoryUploadProcessor.makeStoryErrorCoder(9071)) || (paramInt / 100 == StoryUploadProcessor.makeStoryErrorCoder(999000) / 100) || ((paramInt >= 5100) && (paramInt <= 5108));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 941001) || (paramInt == 941002);
  }
  
  public boolean a()
  {
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (localStoryVideoItem == null) {
      return false;
    }
    return localStoryVideoItem.isTroopLocalVideoOnly();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryVideoPublishStatusEvent{mFakeStoryVideoItem=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    localStringBuilder.append(", mSucStoryVideoItem=");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    localStringBuilder.append(", mCommentLikeFeedItem=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem);
    localStringBuilder.append(", mShareGroupFakeItems=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent
 * JD-Core Version:    0.7.0.1
 */