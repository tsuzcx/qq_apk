package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

class BatchGetVideoInfo$1
  implements BatchGetVideoInfo.VideoLocalCacheFilter
{
  BatchGetVideoInfo$1(BatchGetVideoInfo paramBatchGetVideoInfo) {}
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true)) || (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) || (paramStoryVideoItem.mVideoIndex == 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.1
 * JD-Core Version:    0.7.0.1
 */