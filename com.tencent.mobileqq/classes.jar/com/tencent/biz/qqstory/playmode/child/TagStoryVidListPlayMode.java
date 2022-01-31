package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.jsp.QQStoryApiPlugin;
import com.tencent.qphone.base.util.QLog;
import nln;

public class TagStoryVidListPlayMode
  extends TagStoryPlayMode
{
  public TagStoryVidListPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 105;
    }
    return this.f;
  }
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public void a(Bundle paramBundle)
  {
    this.e = paramBundle.getStringArrayList("extra_feedid_list");
    this.d = paramBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    if (this.d != null)
    {
      localBatchGetVideoInfo = new BatchGetVideoInfo(this.d);
      localBatchGetVideoInfo.a(new nln(this, localBatchGetVideoInfo, paramBundle));
      localBatchGetVideoInfo.b();
    }
    while (!QLog.isColorLevel())
    {
      BatchGetVideoInfo localBatchGetVideoInfo;
      return;
    }
    QLog.e("TagStoryVidListPlayMode", 2, "TagStoryVidListPlayMode - initialize, vidList is Empty.");
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    super.a(paramString1, paramString2, paramString3);
    QQStoryApiPlugin.a(paramString1);
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.TagStoryVidListPlayMode
 * JD-Core Version:    0.7.0.1
 */