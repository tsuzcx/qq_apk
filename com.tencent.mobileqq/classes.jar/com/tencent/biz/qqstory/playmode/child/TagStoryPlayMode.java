package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class TagStoryPlayMode
  extends NewFriendsPlayMode
{
  protected HashSet a;
  protected ArrayList e;
  
  public TagStoryPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 104;
    }
    return this.f;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    VideoListFeedItem localVideoListFeedItem2 = null;
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler != null)
    {
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a > 0) {
        i = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler.a + paramInt - 1;
      }
    }
    VideoListFeedItem localVideoListFeedItem1 = localVideoListFeedItem2;
    if (this.e != null)
    {
      localVideoListFeedItem1 = localVideoListFeedItem2;
      if (!this.e.isEmpty())
      {
        if (i < this.e.size()) {
          break label75;
        }
        localVideoListFeedItem1 = localVideoListFeedItem2;
      }
    }
    label75:
    String str;
    do
    {
      do
      {
        do
        {
          return localVideoListFeedItem1;
          str = (String)this.e.get(i);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          localVideoListFeedItem1 = localVideoListFeedItem2;
        } while (!QLog.isColorLevel());
        QLog.e("TagStoryPlayMode", 2, "getVideoListFeedItem: feedid == null");
        return null;
        localVideoListFeedItem2 = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(str);
        if ((!this.jdField_a_of_type_JavaUtilHashSet.contains(str)) && (!TextUtils.isEmpty(str)))
        {
          GetFeedFeatureHandler.a(Collections.singletonList(str));
          this.jdField_a_of_type_JavaUtilHashSet.add(str);
          return localVideoListFeedItem2;
        }
        localVideoListFeedItem1 = localVideoListFeedItem2;
      } while (localVideoListFeedItem2 != null);
      localVideoListFeedItem1 = localVideoListFeedItem2;
    } while (!QLog.isColorLevel());
    QLog.w("TagStoryPlayMode", 2, "queryFeedItem and requestFeemItem is null, " + str);
    return localVideoListFeedItem2;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.e = paramBundle.getStringArrayList("extra_feedid_list");
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramVideoViewHolder, paramStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.TagStoryPlayMode
 * JD-Core Version:    0.7.0.1
 */