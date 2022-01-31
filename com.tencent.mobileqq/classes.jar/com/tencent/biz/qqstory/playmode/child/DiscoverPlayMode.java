package com.tencent.biz.qqstory.playmode.child;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.util.DiscoverVideoDataProvider;
import com.tencent.biz.qqstory.playmode.util.MultiGroupVideoDataProvider;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import nji;

public class DiscoverPlayMode
  extends MyMemoryPlayMode
{
  protected IPlayVideoStatusChangeListener b;
  private final String h;
  
  public DiscoverPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener = new nji(this);
    b(3);
    a(this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener);
    if (a() == 63) {}
    for (paramStoryVideoPlayer = "1";; paramStoryVideoPlayer = "2")
    {
      this.h = paramStoryVideoPlayer;
      return;
    }
  }
  
  public int a()
  {
    if (this.f != 0) {
      return this.f;
    }
    return 63;
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider = new DiscoverVideoDataProvider(paramBundle.getParcelableArrayList("extra_discover_card_list"), this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider.a();
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    super.a(paramVideoViewHolder, paramStoryVideoItem);
    paramStoryVideoItem = (ImageView)paramVideoViewHolder.a.get(2131372140);
    paramVideoViewHolder = (TextView)paramVideoViewHolder.a.get(2131372139);
    paramStoryVideoItem.setVisibility(8);
    paramVideoViewHolder.setVisibility(8);
  }
  
  @TargetApi(14)
  public boolean a(int paramInt)
  {
    boolean bool = super.a(paramInt);
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt);
    if (bool)
    {
      DiscoverPlayMode.PlayVideoEvent localPlayVideoEvent = new DiscoverPlayMode.PlayVideoEvent();
      localPlayVideoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryVideoItem;
      localPlayVideoEvent.jdField_a_of_type_JavaLangString = a(paramInt);
      localPlayVideoEvent.jdField_b_of_type_Int = ((DiscoverVideoDataProvider)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMultiGroupVideoDataProvider).a(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("DiscoverPlayMode", 2, "startPlayVideo: startIndex " + localPlayVideoEvent.jdField_b_of_type_Int + " CurrentIndex " + this.jdField_b_of_type_Int + " arg.index " + paramInt);
      }
      Dispatchers.get().dispatch(localPlayVideoEvent);
    }
    return bool;
  }
  
  public void c()
  {
    b(this.jdField_b_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener);
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.DiscoverPlayMode
 * JD-Core Version:    0.7.0.1
 */