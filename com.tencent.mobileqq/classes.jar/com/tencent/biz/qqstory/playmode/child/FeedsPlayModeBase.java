package com.tencent.biz.qqstory.playmode.child;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.comment.FeedLikeDataProvider;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.PlayPanelController;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.MyVideoVisibilityDialog;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import nnt;
import nnu;
import nnv;
import nnw;
import nnx;
import nny;
import nnz;

public abstract class FeedsPlayModeBase
  extends VideoPlayModeBase
{
  protected final LikeManager a;
  protected FeedsPlayModeBase.FeedInfoUpdateReceiver a;
  protected FeedsPlayModeBase.GetFeedFeatureReceiver a;
  protected FeedsPlayModeBase.StoryVideoDeleteReceiver a;
  private MyVideoVisibilityDialog a;
  protected final FeedManager a;
  public final FeedVideoManager a;
  public ActionSheet a;
  public boolean e;
  protected boolean f;
  public String g;
  public int l;
  
  public FeedsPlayModeBase(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    super(paramInt, paramStoryVideoPlayer, paramVideoPlayerPagerAdapter, paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$StoryVideoDeleteReceiver = new FeedsPlayModeBase.StoryVideoDeleteReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$GetFeedFeatureReceiver = new FeedsPlayModeBase.GetFeedFeatureReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$FeedInfoUpdateReceiver = new FeedsPlayModeBase.FeedInfoUpdateReceiver(this);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$StoryVideoDeleteReceiver);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$GetFeedFeatureReceiver);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase$FeedInfoUpdateReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager = ((FeedVideoManager)SuperManager.a(12));
    this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager = ((LikeManager)SuperManager.a(15));
    this.l = paramBundle.getInt("extra_page_source", 0);
    this.g = paramBundle.getString("extra_feedid");
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    PlayPanelController.d(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
    PlayPanelController.a(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
    PlayPanelController.b(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
    PlayPanelController.c(paramLayoutInflater, paramVideoPlayerPagerAdapter, paramVideoViewHolder);
  }
  
  public void a(View paramView)
  {
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.b);
    if (localVideoViewHolder == null) {}
    StoryVideoItem localStoryVideoItem;
    String str;
    QQUserUIItem localQQUserUIItem;
    int j;
    label95:
    boolean bool;
    label259:
    label298:
    label329:
    label343:
    label352:
    label358:
    do
    {
      return;
      localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(localVideoViewHolder.jdField_c_of_type_Int);
      str = localStoryVideoItem.mVid;
      localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(localStoryVideoItem.mOwnerUid);
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
      {
        i = 1;
        if (localStoryVideoItem.mStoryType != 2) {
          break label329;
        }
        j = 1;
        bool = PlayModeUtils.a(localStoryVideoItem);
        localObject = a(this.b);
      }
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131364603: 
      case 2131372132: 
        if (localObject == null)
        {
          paramView = this.g;
          if (TextUtils.isEmpty(paramView)) {
            break label358;
          }
          StoryDetailActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, paramView, PlayModeUtils.a(a()), false, str, a());
          if (localQQUserUIItem != null) {
            break label343;
          }
          i = 4;
          if (!bool) {
            break label352;
          }
        }
        for (paramView = "2";; paramView = "1")
        {
          StoryReportor.a("play_video", "clk_list", i, 0, new String[] { paramView });
          return;
          i = 0;
          break;
          j = 0;
          break label95;
          paramView = ((VideoListFeedItem)localObject).feedId;
          break label259;
          i = StoryReportor.a(localQQUserUIItem);
          break label298;
        }
        if (localObject != null) {}
        for (paramView = "feed exist";; paramView = "feed empty")
        {
          SLog.d("FeedsPlayModeBase", "Feed id null!Open detail error ,%s", new Object[] { paramView });
          return;
        }
      }
    } while (localObject == null);
    if (((VideoListFeedItem)localObject).mDenyComment == 1)
    {
      QQToast.a(PlayModeUtils.a(), 1, "该用户已关闭评论", 0).a();
      j = StoryReportor.a(localQQUserUIItem);
      if (i == 0) {
        break label511;
      }
    }
    label511:
    for (paramView = "2";; paramView = "1")
    {
      StoryReportor.a("play_video", "clk_reply", j, 1, new String[] { "1", paramView, String.valueOf(localStoryVideoItem.mOwnerUid), localStoryVideoItem.mVid });
      return;
      StoryQQTextCacher.a().a = "3";
      StoryDetailActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, ((VideoListFeedItem)localObject).feedId, PlayModeUtils.a(a()), true, str, a());
      break;
    }
    b(localStoryVideoItem);
    return;
    if (localObject != null)
    {
      paramView = new LikeEntry();
      paramView.likeTime = System.currentTimeMillis();
      paramView.uin = QQStoryContext.a().a();
      paramView.unionId = QQStoryContext.a().b();
      paramView.feedId = ((VideoListFeedItem)localObject).feedId;
      label614:
      label621:
      int k;
      if (((VideoListFeedItem)localObject).mHadLike == 1)
      {
        j = 1;
        if (j == 0) {
          break label761;
        }
        ((VideoListFeedItem)localObject).mHadLike = 0;
        ((VideoListFeedItem)localObject).mLikeCount -= 1;
        this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager.b(paramView);
        if (j != 0) {
          break label790;
        }
        bool = true;
        int m = ((VideoListFeedItem)localObject).getCommentLikeType();
        if (a() != 106) {
          break label796;
        }
        k = 106;
        label641:
        FeedLikeDataProvider.a((CommentLikeFeedItem)localObject, bool, m, k);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a((FeedItem)localObject);
        paramView = new FeedInfoChangeEvent(1, ((VideoListFeedItem)localObject).feedId, 3, (CommentLikeFeedItem)localObject);
        Dispatchers.get().dispatch(paramView);
        if (j == 0) {
          break label802;
        }
        paramView = "unlike";
        label696:
        j = StoryReportor.a((FeedItem)localObject);
        k = a();
        if (i == 0) {
          break label809;
        }
      }
      label790:
      label796:
      label802:
      label809:
      for (localObject = "2";; localObject = "1")
      {
        StoryReportor.a("play_video", paramView, j, k, new String[] { localObject, "1", String.valueOf(localStoryVideoItem.mOwnerUid), str });
        return;
        j = 0;
        break;
        label761:
        ((VideoListFeedItem)localObject).mHadLike = 1;
        ((VideoListFeedItem)localObject).mLikeCount += 1;
        this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager.a(paramView);
        break label614;
        bool = false;
        break label621;
        k = 0;
        break label641;
        paramView = "like";
        break label696;
      }
    }
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, localVideoViewHolder, null, localStoryVideoItem, true);
    return;
    if (j == 0)
    {
      if (i != 0)
      {
        i = 1;
        if (!bool) {
          break label1074;
        }
        paramView = "2";
        label851:
        StoryReportor.a("play_video", "clk_more_play", i, 0, new String[] { paramView, String.valueOf(StoryReportor.a(localQQUserUIItem)) });
      }
    }
    else
    {
      i = a();
      if (localObject == null) {
        break label1080;
      }
    }
    label1074:
    label1080:
    for (paramView = ((VideoListFeedItem)localObject).feedId;; paramView = "")
    {
      StoryReportor.a("story_grp", "video_more", i, 0, new String[] { "", "", "", paramView });
      paramView = new Boolean[1];
      paramView[0] = Boolean.valueOf(false);
      c(1);
      localObject = new nnw(this, paramView);
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.d(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a);
      a(this.jdField_a_of_type_ComTencentWidgetActionSheet, localStoryVideoItem);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433029);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener((DialogInterface.OnDismissListener)localObject);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new nnx(this, paramView, localStoryVideoItem));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnCancelListener(new nny(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      i = 2;
      break;
      paramView = "1";
      break label851;
    }
    Object localObject = WeShiGuideDialog.a(paramView.getContext(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    if (localObject != null)
    {
      c(1);
      ((Dialog)localObject).setOnDismissListener(new nnz(this));
    }
    if (WeishiGuideUtils.a(paramView.getContext())) {}
    for (int i = 2;; i = 1)
    {
      StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { "4", localStoryVideoItem.mOwnerUid, "weishi", localStoryVideoItem.mVid });
      return;
    }
  }
  
  public void a(PollWidgetUtils.IPollWidget paramIPollWidget, PollWidgetUtils.WidgetElement paramWidgetElement)
  {
    super.a(paramIPollWidget, paramWidgetElement);
  }
  
  protected abstract void a(ActionSheet paramActionSheet, StoryVideoItem paramStoryVideoItem);
  
  void a(String paramString, int paramInt, VideoSpreadGroupList paramVideoSpreadGroupList)
  {
    if (this.b >= this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()) {
      return;
    }
    u();
    c(1);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibilityDialog = new MyVideoVisibilityDialog(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, paramString, paramInt, paramVideoSpreadGroupList, false);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibilityDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibilityDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibilityDialog.setOnDismissListener(new nnt(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibilityDialog.show();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(paramString1);
    if (i < 0) {
      return;
    }
    if (i == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = true;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.post(new nnu(this, bool));
      return;
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      g();
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.j(this.b);
      u();
      return true;
    }
    return false;
  }
  
  public abstract boolean a(View paramView, String paramString, StoryVideoItem paramStoryVideoItem);
  
  public void b(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent) {}
  
  protected void b(StoryVideoItem paramStoryVideoItem)
  {
    if (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FeedsPlayModeBase", 2, "storyVideoItem ownerUid is null.");
      }
      return;
    }
    StoryApi.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, 9, paramStoryVideoItem.mOwnerUid);
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isVip))
    {
      StoryReportor.a("play_video", "clk_head", 0, 0, new String[] { "3", "2", "", paramStoryVideoItem.mVid });
      return;
    }
    StoryReportor.a("play_video", "clk_head", 0, 0, new String[] { "2", "2", "", paramStoryVideoItem.mVid });
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public boolean b(int paramInt)
  {
    VideoListFeedItem localVideoListFeedItem = a(paramInt);
    return (localVideoListFeedItem != null) && (!TextUtils.isEmpty(localVideoListFeedItem.feedId));
  }
  
  public void c()
  {
    u();
    super.c();
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void j()
  {
    if ((this.b < 0) || (this.b >= this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())) {
      if (QLog.isColorLevel()) {
        QLog.e("FeedsPlayModeBase", 2, "double tap, mCurrentIndex >= mAdapter.mStoryVideoItemList.size(), mCurrentIndex :" + this.b + ", mAdapter.mStoryVideoItemList.size():" + this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    do
    {
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
      do
      {
        StoryVideoItem localStoryVideoItem;
        do
        {
          do
          {
            return;
            if (b(this.b)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("FeedsPlayModeBase", 2, "double tap, but current item not support interaction");
          return;
          localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.b);
          localVideoViewHolder = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder;
        } while ((localVideoViewHolder == null) || (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) || (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() == 0) || (localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0));
        try
        {
          localObject = (AnimationDrawable)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.getResources().getDrawable(2130843898);
          if (localObject != null)
          {
            localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
            localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            ((AnimationDrawable)localObject).start();
            i = 0;
            int j = 0;
            while (i < ((AnimationDrawable)localObject).getNumberOfFrames())
            {
              j += ((AnimationDrawable)localObject).getDuration(i);
              i += 1;
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new nnv(this, (AnimationDrawable)localObject, localVideoViewHolder), j);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            Object localObject;
            SLog.d("FeedsPlayModeBase", "oom ,zan animation error!");
            continue;
            int i = 0;
            continue;
            i = 2;
            continue;
            String str = String.valueOf(StoryReportor.a(localOutOfMemoryError));
          }
        }
        localObject = ((UserManager)SuperManager.a(2)).b(localStoryVideoItem.mOwnerUid);
        if ((localObject == null) || (!((QQUserUIItem)localObject).isVip)) {
          break;
        }
        i = 1;
        if (i == 0) {
          break label407;
        }
        i = 1;
        if (localObject != null) {
          break label412;
        }
        localObject = "4";
        StoryReportor.a("play_video", "dbl_like", i, 0, new String[] { "", localObject, "", localStoryVideoItem.mVid });
        localObject = a(this.b);
      } while ((localObject == null) || (((VideoListFeedItem)localObject).mHadLike == 1));
      localObject = (View)localVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131368335);
    } while (localObject == null);
    a((View)localObject);
  }
  
  protected void u()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void v()
  {
    int j = 8;
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.b);
    Object localObject;
    StoryVideoItem localStoryVideoItem;
    if ((localVideoViewHolder != null) && (this.b >= 0) && (this.b < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localObject = a(this.b);
      if (localObject != null)
      {
        localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.b);
        PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, localVideoViewHolder, (VideoListFeedItem)localObject, localStoryVideoItem);
        localObject = localVideoViewHolder.b;
        if (!PlayModeUtils.a(this.l)) {
          break label407;
        }
        i = 0;
        ((LinearLayout)localObject).setVisibility(i);
        localVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.b - 1);
    if ((localVideoViewHolder != null) && (this.b - 1 >= 0) && (this.b - 1 < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localObject = a(this.b - 1);
      if (localObject != null)
      {
        localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.b - 1);
        PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, localVideoViewHolder, (VideoListFeedItem)localObject, localStoryVideoItem);
        localObject = localVideoViewHolder.b;
        if (!PlayModeUtils.a(this.l)) {
          break label413;
        }
      }
    }
    label407:
    label413:
    for (int i = 0;; i = 8)
    {
      ((LinearLayout)localObject).setVisibility(i);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.b + 1);
      if ((localVideoViewHolder != null) && (this.b + 1 >= 0) && (this.b + 1 < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localObject = a(this.b + 1);
        if (localObject != null)
        {
          localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.b + 1);
          PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a, localVideoViewHolder, (VideoListFeedItem)localObject, localStoryVideoItem);
          localObject = localVideoViewHolder.b;
          i = j;
          if (PlayModeUtils.a(this.l)) {
            i = 0;
          }
          ((LinearLayout)localObject).setVisibility(i);
          localVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
      return;
      i = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase
 * JD-Core Version:    0.7.0.1
 */