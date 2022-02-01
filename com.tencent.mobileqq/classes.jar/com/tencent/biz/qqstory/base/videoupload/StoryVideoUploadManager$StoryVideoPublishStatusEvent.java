package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.ArrayList;

public final class StoryVideoUploadManager$StoryVideoPublishStatusEvent
  extends BaseEvent
{
  public final boolean a;
  public boolean b = true;
  public StoryVideoItem c;
  public StoryVideoItem d;
  public GeneralFeedItem e;
  public ArrayList<StoryVideoUploadManager.ShareGroupFakeItem> f;
  public boolean h = false;
  
  public StoryVideoUploadManager$StoryVideoPublishStatusEvent(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 940006) || (paramInt == 940007) || (paramInt == 940017) || (paramInt == 940018) || (paramInt == 941001) || (paramInt == 941002) || (paramInt == StoryUploadProcessor.makeStoryErrorCoder(940017)) || (paramInt == StoryUploadProcessor.makeStoryErrorCoder(9042)) || (paramInt == StoryUploadProcessor.makeStoryErrorCoder(9070)) || (paramInt == StoryUploadProcessor.makeStoryErrorCoder(9071)) || (paramInt / 100 == StoryUploadProcessor.makeStoryErrorCoder(999000) / 100) || ((paramInt >= 5100) && (paramInt <= 5108));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 941001) || (paramInt == 941002);
  }
  
  public boolean b()
  {
    StoryVideoItem localStoryVideoItem = this.c;
    if (localStoryVideoItem == null) {
      return false;
    }
    return localStoryVideoItem.isTroopLocalVideoOnly();
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    ArrayList localArrayList = this.f;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryVideoPublishStatusEvent{mFakeStoryVideoItem=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mSucStoryVideoItem=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mCommentLikeFeedItem=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mShareGroupFakeItems=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent
 * JD-Core Version:    0.7.0.1
 */