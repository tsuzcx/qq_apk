package com.tencent.biz.qqstory.playvideo.preload;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.VideoLocalCacheFilter;

class PlayerDataPreLoader$2
  implements BatchGetVideoInfo.VideoLocalCacheFilter
{
  PlayerDataPreLoader$2(PlayerDataPreLoader paramPlayerDataPreLoader) {}
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!paramStoryVideoItem.isBasicInfoOK()) || (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) || (paramStoryVideoItem.mVideoIndex == 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.2
 * JD-Core Version:    0.7.0.1
 */