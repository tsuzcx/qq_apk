package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HotRecommendPlayMode
  extends NewFriendsPlayMode
{
  protected HashSet a;
  
  public HotRecommendPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 74;
    }
    return this.f;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    String str = ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt)).mAttachedFeedId;
    Object localObject;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.NewFriendsPlayMode", 2, "getVideoListFeedItem: feedid == null");
      }
      localObject = null;
    }
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      do
      {
        return localObject;
        localVideoListFeedItem = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(str);
        if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(str)) && (!TextUtils.isEmpty(str)))
        {
          GetFeedFeatureHandler.a(Collections.singletonList(str));
          this.jdField_a_of_type_JavaUtilHashSet.add(str);
          return localVideoListFeedItem;
        }
        localObject = localVideoListFeedItem;
      } while (localVideoListFeedItem != null);
      localObject = localVideoListFeedItem;
    } while (!QLog.isColorLevel());
    QLog.w("Q.qqstory.player.NewFriendsPlayMode", 2, "queryFeedItem and requestFeemItem is null, " + str);
    return localVideoListFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.HotRecommendPlayMode
 * JD-Core Version:    0.7.0.1
 */