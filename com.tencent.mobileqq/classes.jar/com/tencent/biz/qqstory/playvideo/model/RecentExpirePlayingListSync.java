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
  protected String j;
  
  protected void a()
  {
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    localPlayerVideoListEvent.a = this.h;
    localPlayerVideoListEvent.b = this.j;
    localPlayerVideoListEvent.i = true;
    localPlayerVideoListEvent.j = true;
    StoryItem localStoryItem = ((StoryManager)SuperManager.a(5)).a(this.j, 2);
    StoryVideoItem localStoryVideoItem = new StoryVideoItem();
    if (localStoryItem != null)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
        localStoryVideoItem.mOwnerUid = this.j;
      }
      localStoryVideoItem.mVideoThumbnailUrl = localStoryItem.getCoverUrl();
      localPlayerVideoListEvent.e.add(localStoryVideoItem);
      this.b.clear();
      this.b.add(localStoryVideoItem);
    }
    this.d = true;
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.RecentExpirePlayingListSync
 * JD-Core Version:    0.7.0.1
 */