package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;

final class PlayModeUtils$3
  extends ArrayList
{
  PlayModeUtils$3(String paramString1, String paramString2, String paramString3, StoryVideoItem paramStoryVideoItem)
  {
    add(this.val$finalMaskPath);
    add(this.val$hflipPath);
    add(this.val$outputFilePath);
    add(Integer.valueOf(this.val$storyVideoItem.mVideoWidth));
    add(Integer.valueOf(this.val$storyVideoItem.mVideoHeight));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.3
 * JD-Core Version:    0.7.0.1
 */