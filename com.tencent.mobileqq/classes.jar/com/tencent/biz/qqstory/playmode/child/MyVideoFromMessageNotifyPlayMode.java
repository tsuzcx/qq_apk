package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import nok;

public class MyVideoFromMessageNotifyPlayMode
  extends NewFriendsPlayMode
{
  public MyVideoFromMessageNotifyPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    b(1);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
  }
  
  public int a()
  {
    if (this.f != 0) {
      return this.f;
    }
    return 29;
  }
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    if (localObject != null)
    {
      paramBundle = new ArrayList();
      StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        StoryVideoItem localStoryVideoItem = localStoryManager.a((String)((Iterator)localObject).next());
        if (localStoryVideoItem != null)
        {
          if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
            localStoryVideoItem.mOwnerUid = this.b;
          }
          paramBundle.add(localStoryVideoItem);
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(paramBundle);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() > 0))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(1);
      }
      this.jdField_a_of_type_Boolean = true;
      if (!TextUtils.isEmpty(this.g)) {
        GetFeedFeatureHandler.a(Collections.singletonList(this.g));
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nok(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MyVideoFromMessageNotifyPlayMode
 * JD-Core Version:    0.7.0.1
 */