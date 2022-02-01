package com.tencent.biz.qqstory.msgTabNode.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.VideoLocalCacheFilter;

class MsgTabNodePullVideoBasicInfoSegment$1
  implements BatchGetVideoInfo.VideoLocalCacheFilter
{
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    String str = paramStoryVideoItem.mVid;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (StoryVideoItem.isPlayable(str, true))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid))
      {
        if (paramStoryVideoItem.mVideoIndex <= 0L) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment.1
 * JD-Core Version:    0.7.0.1
 */