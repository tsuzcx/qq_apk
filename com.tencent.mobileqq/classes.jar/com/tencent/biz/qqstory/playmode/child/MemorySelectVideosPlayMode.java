package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.PlayPanelController;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase.TopViewHolder;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
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

public class MemorySelectVideosPlayMode
  extends MyMemoryPlayMode
{
  protected TextView a;
  protected List a;
  protected ConcurrentHashMap a;
  protected boolean g;
  protected int j;
  
  public MemorySelectVideosPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    b(1);
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
  
  public void a(Bundle paramBundle)
  {
    boolean bool = false;
    super.a(paramBundle);
    this.jdField_a_of_type_JavaUtilList = paramBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaUtilList.get(i), Boolean.valueOf(true));
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.i("MemorySelectVideosPlayMode", 2, "initialize, vidList is Empty.");
      QQToast.a(a(), "MemorySelectVideosPlayMode SelectVideosPlayMode - initialize, vidList is Empty.", 0).a();
    }
    if (this.j > 0) {}
    for (paramBundle = "完成(" + this.j + ")";; paramBundle = "完成")
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.j > 0) {
        bool = true;
      }
      localTextView.setEnabled(bool);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      return;
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater)
  {
    PlayPanelController.b(paramLayoutInflater, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$TopViewHolder);
    PlayPanelController.a(paramLayoutInflater, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$TopViewHolder);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$TopViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372134));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("完成(" + this.j + ")");
    }
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
      localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(localVideoViewHolder.jdField_c_of_type_Int);
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
      paramView = (ImageView)localVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372135);
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
    paramView.setImageResource(2130842186);
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
      paramView.setImageResource(2130843015);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      break label215;
    }
  }
  
  public void a(PollWidgetUtils.IPollWidget paramIPollWidget, PollWidgetUtils.WidgetElement paramWidgetElement) {}
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (!PlayModeUtils.b(paramStoryVideoItem))
    {
      paramVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      boolean bool;
      ImageView localImageView;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramStoryVideoItem.mVid))
      {
        bool = ((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramStoryVideoItem.mVid)).booleanValue();
        localImageView = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372135);
        paramStoryVideoItem.mIsPlaying = 0;
        if (!bool) {
          break label128;
        }
        localImageView.setImageResource(2130842186);
        label109:
        if (!paramStoryVideoItem.isPollVideo()) {
          break label138;
        }
        PlayModePollViewUtils.a(this, paramVideoViewHolder, paramStoryVideoItem);
      }
      label128:
      label138:
      while (!paramStoryVideoItem.isInteractVideo())
      {
        return;
        bool = false;
        break;
        localImageView.setImageResource(2130843015);
        break label109;
      }
      PlayModeInteractViewUtils.a(this, paramVideoViewHolder, paramStoryVideoItem);
      return;
    }
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramVideoViewHolder, paramStoryVideoItem);
  }
  
  protected int b(int paramInt)
  {
    return 1;
  }
  
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
      QLog.d("MemorySelectVideosPlayMode", 2, "onPagerItemClick onClick complete: " + localSelectedVideosEvent.jdField_a_of_type_JavaUtilArrayList.toString());
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
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MemorySelectVideosPlayMode
 * JD-Core Version:    0.7.0.1
 */