package com.tencent.biz.qqstory.playmode.child;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import nht;
import nhu;
import nhv;

public class CommentPlayMode
  extends NewFriendsPlayMode
{
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  nhv jdField_a_of_type_Nhv = new nhv(this);
  private boolean g;
  protected int j;
  
  public CommentPlayMode(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    b(1);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((UserManager)SuperManager.a(2)).b(this.b);
    a(this.jdField_a_of_type_Nhv);
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      this.j = paramBundle.getInt("extra_identify", 1);
    }
  }
  
  private void a(QQUserUIItem paramQQUserUIItem)
  {
    if (String.valueOf(this.b).equals(paramQQUserUIItem.getUnionId())) {
      d();
    }
  }
  
  public int a()
  {
    return 7;
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public VideoListFeedItem a(int paramInt)
  {
    if ((this.j == 1) || (this.jdField_g_of_type_Boolean)) {
      return (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_g_of_type_JavaLangString);
    }
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    if (localObject != null)
    {
      paramBundle = new ArrayList();
      StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        StoryVideoItem localStoryVideoItem = localStoryManager.a((String)localIterator.next());
        if (localStoryVideoItem != null)
        {
          if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
            localStoryVideoItem.mOwnerUid = this.b;
          }
          paramBundle.add(localStoryVideoItem);
        }
      }
      GetVidPollInfoHandler.a((List)localObject);
      localObject = null;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(paramBundle);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nht(this));
      paramBundle = (Bundle)localObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a != null)
      {
        paramBundle = (Bundle)localObject;
        if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() > 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a);
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(1);
          paramBundle = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(0);
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_Boolean = true;
      if (((this.jdField_a_of_type_Int == 16) || (this.jdField_a_of_type_Int == 5)) && (paramBundle != null)) {
        if (paramBundle.mInteractStatus != 1) {
          break label374;
        }
      }
    }
    label374:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      if (((this.j == 1) || (this.jdField_g_of_type_Boolean)) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))) {
        GetFeedFeatureHandler.a(Collections.singletonList(this.jdField_g_of_type_JavaLangString));
      }
      localObject = (UserManager)SuperManager.a(2);
      paramBundle = QQStoryContext.a().b();
      localObject = ((UserManager)localObject).b(paramBundle);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b(1, this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid);
        if (localObject == null)
        {
          localObject = new QQUserUIItem.UserID("", paramBundle);
          new GetUserInfoHandler().a(1, (QQUserUIItem.UserID)localObject, paramBundle);
        }
      }
      return;
    }
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramVideoViewHolder, paramStoryVideoItem, null);
    boolean bool;
    label78:
    int i;
    if (paramStoryVideoItem.isPollVideo())
    {
      PlayModePollViewUtils.a(this, paramVideoViewHolder, paramStoryVideoItem);
      if ((this.jdField_a_of_type_Int == 16) || (this.jdField_a_of_type_Int == 5))
      {
        if (paramStoryVideoItem.mInteractStatus != 1) {
          break label201;
        }
        bool = true;
        this.jdField_g_of_type_Boolean = bool;
      }
      if ((this.j != 1) && (!this.jdField_g_of_type_Boolean)) {
        break label234;
      }
      if (!b(paramVideoViewHolder.jdField_c_of_type_Int)) {
        break label213;
      }
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, paramVideoViewHolder, a(paramVideoViewHolder.jdField_c_of_type_Int), paramStoryVideoItem);
      LinearLayout localLinearLayout = paramVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout;
      if (!PlayModeUtils.a(this.k)) {
        break label207;
      }
      i = 0;
      label148:
      localLinearLayout.setVisibility(i);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label162:
      if (this.j != 1) {
        break label255;
      }
      paramVideoViewHolder.d.setVisibility(0);
    }
    for (;;)
    {
      b(paramVideoViewHolder, paramStoryVideoItem);
      return;
      if (!paramStoryVideoItem.isInteractVideo()) {
        break;
      }
      PlayModeInteractViewUtils.a(this, paramVideoViewHolder, paramStoryVideoItem);
      break;
      label201:
      bool = false;
      break label78;
      label207:
      i = 8;
      break label148;
      label213:
      paramVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label162;
      label234:
      paramVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label162;
      label255:
      paramVideoViewHolder.d.setVisibility(8);
    }
  }
  
  protected void a(ActionSheet paramActionSheet, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool = PlayModeUtils.a(paramStoryVideoItem);
    paramActionSheet.b(2131434719);
    if (!bool) {
      paramActionSheet.b(2131435099);
    }
  }
  
  public void b(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if ((!paramPlayerVideoListEvent.jdField_a_of_type_Boolean) && (paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setTipsText(StoryApi.a(2131432080));
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.NewFriendsPlayMode", 2, "奇怪的事情发生了,不应该进到这里, mVideoMode:" + this.jdField_a_of_type_Int + ",uin:" + this.b);
      }
    }
    do
    {
      return;
      if ((paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList != null) && (paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_Boolean = paramPlayerVideoListEvent.b;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.clear();
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.addAll(paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(paramPlayerVideoListEvent.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidOsHandler.post(new nhu(this));
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      if ((this.jdField_a_of_type_Int == 15) || (this.jdField_a_of_type_Int == 33)) {
        this.jdField_g_of_type_Boolean = paramPlayerVideoListEvent.c;
      }
    } while (((this.j != 1) && (!this.jdField_g_of_type_Boolean)) || (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)));
    GetFeedFeatureHandler.a(Collections.singletonList(this.jdField_g_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.CommentPlayMode
 * JD-Core Version:    0.7.0.1
 */