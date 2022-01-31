package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.PlayPanelController;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase.TopViewHolder;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import nlc;

public class SelectVideosPlayMode
  extends NewFriendsPlayMode
{
  protected TextView a;
  protected List a;
  protected ConcurrentHashMap a;
  protected boolean g;
  protected int j;
  
  public SelectVideosPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    b(1);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
  }
  
  public int a()
  {
    if (this.f == 0) {
      return 86;
    }
    return this.f;
  }
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    boolean bool = false;
    this.jdField_a_of_type_JavaUtilList = paramBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    Object localObject = paramBundle.getStringArrayList("extra_select_vid_list");
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (localObject != null)
      {
        this.j = ((ArrayList)localObject).size();
        int i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ArrayList)localObject).get(i), Boolean.valueOf(true));
          i += 1;
        }
      }
      localObject = new BatchGetVideoInfo(this.jdField_a_of_type_JavaUtilList);
      ((BatchGetVideoInfo)localObject).a(new nlc(this, (BatchGetVideoInfo)localObject, paramBundle));
      ((BatchGetVideoInfo)localObject).b();
      if (this.j <= 0) {
        break label206;
      }
    }
    label206:
    for (paramBundle = "完成(" + this.j + ")";; paramBundle = "完成")
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.j > 0) {
        bool = true;
      }
      ((TextView)localObject).setEnabled(bool);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("SelectVideosPlayMode", 2, "SelectVideosPlayMode - initialize, vidList is Empty.");
      QQToast.a(a(), "SelectVideosPlayMode - initialize, vidList is Empty.", 0).a();
      break;
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater)
  {
    PlayPanelController.b(paramLayoutInflater, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$TopViewHolder);
    PlayPanelController.a(paramLayoutInflater, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$TopViewHolder);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$TopViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372126));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("完成(" + this.j + ")");
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.d = true;
  }
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    PlayPanelController.f(paramLayoutInflater, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, paramVideoViewHolder);
  }
  
  public void a(View paramView)
  {
    boolean bool2 = false;
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.b);
    if (localVideoViewHolder == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(localVideoViewHolder.c);
      switch (paramView.getId())
      {
      default: 
        super.a(paramView);
        return;
      }
    } while (this.j == 0);
    this.g = true;
    g();
    return;
    g();
    return;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((StoryVideoItem)localObject).mVid)) {}
    for (boolean bool1 = ((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((StoryVideoItem)localObject).mVid)).booleanValue();; bool1 = false)
    {
      paramView = (ImageView)localVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372127);
      if (bool1) {
        break label288;
      }
      if (this.j != 20) {
        break;
      }
      QQToast.a(a(), "最多只能选择20个小视频", 0).a();
      return;
    }
    this.j += 1;
    paramView.setImageResource(2130842154);
    if (this.j == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      label215:
      paramView = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      localObject = ((StoryVideoItem)localObject).mVid;
      if (!bool1) {
        bool2 = true;
      }
      paramView.put(localObject, Boolean.valueOf(bool2));
      if (this.j <= 0) {
        break label318;
      }
    }
    label288:
    label318:
    for (paramView = "完成(" + this.j + ")";; paramView = "完成")
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      return;
      this.j -= 1;
      paramView.setImageResource(2130842983);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      break label215;
    }
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramStoryVideoItem.mVid)) {}
    for (boolean bool = ((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramStoryVideoItem.mVid)).booleanValue();; bool = false)
    {
      paramStoryVideoItem.mIsPlaying = 0;
      paramVideoViewHolder = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372127);
      if (!bool) {
        break;
      }
      paramVideoViewHolder.setImageResource(2130842154);
      return;
    }
    paramVideoViewHolder.setImageResource(2130842983);
  }
  
  public void b(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent) {}
  
  public void g()
  {
    SelectVideosPlayMode.SelectedVideosEvent localSelectedVideosEvent = new SelectVideosPlayMode.SelectedVideosEvent();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(str);
      }
    }
    localSelectedVideosEvent.jdField_a_of_type_Boolean = this.g;
    localSelectedVideosEvent.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if (QLog.isColorLevel()) {
      QLog.d("SelectVideosPlayMode", 2, "onPagerItemClick onClick complete: " + localSelectedVideosEvent.jdField_a_of_type_JavaUtilArrayList.toString());
    }
    Dispatchers.get().dispatch(localSelectedVideosEvent);
    if (this.g)
    {
      super.h();
      return;
    }
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.SelectVideosPlayMode
 * JD-Core Version:    0.7.0.1
 */