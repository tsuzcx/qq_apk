package com.tencent.biz.qqstory.playmode;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.ViewPagerScroller;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.OnPollDetailClickListener;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.OnWidgetElementClickListener;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer.GestureListener;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qqstory.view.widget.RateWidget;
import com.tencent.biz.qqstory.view.widget.RateWidget.AttendViewClickListener;
import com.tencent.biz.qqstory.view.widget.RateWidget.WidgetRatingChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import nmq;
import nms;
import nmv;
import nmw;
import nmx;
import nna;
import nnb;
import nne;
import nnf;
import nng;
import nnh;
import nni;
import nnj;
import nnk;
import nnl;
import nno;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class VideoPlayModeBase
  implements ViewPager.OnPageChangeListener, PollWidgetUtils.OnPollDetailClickListener, PollWidgetUtils.OnWidgetElementClickListener, StoryVideoPlayer.GestureListener, RateWidget.AttendViewClickListener, RateWidget.WidgetRatingChangedListener, IEventReceiver
{
  public static final Boolean a;
  public int a;
  public long a;
  public Dialog a;
  public Handler a;
  protected QQStoryManager a;
  public PlayingListPreloader.OnVideoDownloadListener a;
  public PlayingListPreloader a;
  protected LiveVideoEntry a;
  public DefaultPlayerVideoListSynchronizer a;
  private WatchVideoHandler a;
  public IPlayVideoStatusChangeListener a;
  protected VideoPlayModeBase.GetPollInfoReceiver a;
  protected VideoPlayModeBase.GetStoryListReceiver a;
  public VideoPlayModeBase.HideProgressBarRunnable a;
  public VideoPlayModeBase.ProgressView a;
  protected VideoPlayModeBase.SendVidPollDataResultReceiver a;
  protected VideoPlayModeBase.SendVidRateDataResultReceiver a;
  public VideoPlayModeBase.TopViewHolder a;
  public ViewPagerScroller a;
  protected IVideoView a;
  public StoryVideoPlayer a;
  public VideoPlayerPagerAdapter.VideoViewHolder a;
  public VideoPlayerPagerAdapter a;
  public StoryNewGuideDialog a;
  protected FriendListObserver a;
  public QQAppInterface a;
  protected Runnable a;
  public final String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public ArrayList b;
  public boolean b;
  protected int c;
  public long c;
  public String c;
  protected ArrayList c;
  protected boolean c;
  public int d;
  public long d;
  public String d;
  protected boolean d;
  public int e;
  public long e;
  protected String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g;
  public int h;
  public long h;
  protected int i;
  private long i;
  private int j;
  
  static
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  }
  
  public VideoPlayModeBase(int paramInt, StoryVideoPlayer paramStoryVideoPlayer, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = (System.currentTimeMillis() + "");
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$TopViewHolder = new VideoPlayModeBase.TopViewHolder(this, this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader = new PlayingListPreloader();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler = new WatchVideoHandler();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$GetStoryListReceiver = new VideoPlayModeBase.GetStoryListReceiver(this, this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$GetPollInfoReceiver = new VideoPlayModeBase.GetPollInfoReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$SendVidPollDataResultReceiver = new VideoPlayModeBase.SendVidPollDataResultReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$SendVidRateDataResultReceiver = new VideoPlayModeBase.SendVidRateDataResultReceiver(this);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_Int = 0;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener = new nnk(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$HideProgressBarRunnable = new VideoPlayModeBase.HideProgressBarRunnable(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener = new nms(this);
    this.jdField_a_of_type_JavaLangRunnable = new nmv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new nna(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = PlayModeUtils.a();
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer = paramStoryVideoPlayer;
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter = paramVideoPlayerPagerAdapter;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramBundle.getInt("EXTRA_CURRENT_INDEX");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("EXTRA_USER_UNION_ID");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("EXTRA_USER_UIN");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("extra_partner_api");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("extra_ugc_steaming_enabled", false);
    this.jdField_f_of_type_Int = paramBundle.getInt("extra_share_from_type");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("EXTRA_SHARE_GROUP_UNION_ID");
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$GetStoryListReceiver);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$GetPollInfoReceiver);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$SendVidPollDataResultReceiver);
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$SendVidRateDataResultReceiver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener);
    paramStoryVideoPlayer = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramStoryVideoPlayer.a())
    {
      paramStoryVideoPlayer.c();
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180));
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilViewPagerScroller = new ViewPagerScroller(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilViewPagerScroller.a(1000);
    SLog.a("VideoPlayModeBase", "VideoPlayModeBase() ctor, class name: %s", getClass().getSimpleName());
  }
  
  public static Context a()
  {
    return BaseApplicationImpl.getApplication().getApplicationContext();
  }
  
  @TargetApi(14)
  private void a(int paramInt, boolean paramBoolean)
  {
    long l = SystemClock.uptimeMillis();
    SLog.b("VideoPlayModeBase", "_onPageSelected() index:%d, isScrolled:%s", Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
    if (!this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("VideoPlayModeBase", 2, "_onPageSelected() i: " + paramInt + ", i >= mStoryVideoItems.size(=" + this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() + ")");
    return;
    Object localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 1);
    if (localObject != null)
    {
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.k(paramInt - 1);
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).a();
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(8);
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((paramInt - 1 >= 0) && (paramInt - 1 < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())) {
        ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1)).mIsPlaying = 0;
      }
    }
    localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt + 1);
    if (localObject != null)
    {
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.k(paramInt + 1);
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).a();
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(8);
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((paramInt + 1 >= 0) && (paramInt + 1 < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())) {
        ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt + 1)).mIsPlaying = 0;
      }
    }
    ThreadManager.post(new nnh(this), 8, null, true);
    this.jdField_b_of_type_Int = paramInt;
    localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    this.jdField_f_of_type_JavaLangString = ((StoryVideoItem)localObject).mVid;
    this.jdField_h_of_type_Long = SystemClock.uptimeMillis();
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localVideoViewHolder != null)
    {
      localVideoViewHolder.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if (paramBoolean) {
        ((StoryVideoItem)localObject).mIsPlaying = 0;
      }
      if (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null)
      {
        a(paramInt);
        QLog.i("VideoPlayModeBase", 2, "_onPageSelected() start play");
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a(paramInt);
    }
    SLog.b("VideoPlayModeBase", "_onPageSelected() index:%d, costTime:%d", Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis() - l));
  }
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public DefaultPlayerVideoListSynchronizer a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer;
  }
  
  public StoryVideoItem a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt)
    {
      SLog.c("VideoPlayModeBase", "getVideoItem", new IndexOutOfBoundsException(String.format(Locale.getDefault(), "index %d out of bounds of size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()) })));
      return null;
    }
    return (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public VideoPlayModeBase.VideoOnCompletionListener a(int paramInt)
  {
    return new VideoPlayModeBase.VideoOnCompletionListener(this, paramInt);
  }
  
  public abstract VideoListFeedItem a(int paramInt);
  
  public VideoPlayerPagerAdapter.VideoViewHolder a(int paramInt)
  {
    return (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a()
  {
    if (((this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.isShowing())) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(this.jdField_e_of_type_Long);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.b();
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.l(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView = null;
    }
  }
  
  public void a(int paramInt)
  {
    e();
    g();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    if (a() > 1000)
    {
      b(paramInt1, paramInt2);
      return;
    }
    c(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramInt != this.jdField_b_of_type_Int) {}
    StoryConfigManager localStoryConfigManager;
    do
    {
      do
      {
        do
        {
          return;
          paramStoryVideoItem = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        } while (paramStoryVideoItem == null);
        localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      } while ((this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.getCount() <= 1) || (localStoryConfigManager.a()));
      if ((paramStoryVideoItem != null) && (paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null))
      {
        paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.k(paramInt);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b();
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog != null);
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog = new StoryNewGuideDialog(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.a("左右滑动可切换小视频");
    c(1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.setOnDismissListener(new nnl(this, paramStoryVideoItem));
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.show();
    localStoryConfigManager.a(true);
  }
  
  public void a(int paramInt, StoryVideoItem paramStoryVideoItem, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    if (paramStoryVideoItem.isPollVideo()) {
      PlayModePollViewUtils.b(this, paramVideoViewHolder, paramStoryVideoItem);
    }
    while (!paramStoryVideoItem.isInteractVideo()) {
      return;
    }
    PlayModeInteractViewUtils.b(this, paramVideoViewHolder, paramStoryVideoItem);
  }
  
  public abstract void a(Bundle paramBundle);
  
  public void a(LayoutInflater paramLayoutInflater) {}
  
  public abstract void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder);
  
  public void a(View paramView) {}
  
  public final void a(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramPlayerVideoListEvent.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      if (paramPlayerVideoListEvent.errorInfo.isFail())
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayModeBase", 2, "event.errorInfo.isFail()");
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        if (paramPlayerVideoListEvent.errorInfo.errorCode == 880001)
        {
          if (QLog.isColorLevel()) {
            QLog.i("VideoPlayModeBase", 2, "event.errorInfo.isFail(): ERROR_NO_NETWORK");
          }
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
          StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(111) });
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_b_of_type_Int = 880001;
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new nng(this));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayModeBase", 2, "event.errorInfo.isFail(): errorCode:" + paramPlayerVideoListEvent.errorInfo.errorCode);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(0);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_b_of_type_Int = paramPlayerVideoListEvent.errorInfo.errorCode;
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry = paramPlayerVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry;
      if ((paramPlayerVideoListEvent.jdField_b_of_type_Boolean == true) && (paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry != null))
      {
        e();
        g();
        return;
      }
      b(paramPlayerVideoListEvent);
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (String str = this.jdField_c_of_type_JavaLangString;; str = paramStoryVideoItem.mOwnerUid)
    {
      if (!TextUtils.isEmpty(str))
      {
        paramStoryVideoItem = new ReadStoryVideoEvent(str, paramStoryVideoItem);
        Dispatchers.get().dispatch(paramStoryVideoItem);
      }
      return;
    }
  }
  
  public void a(IPlayVideoStatusChangeListener paramIPlayVideoStatusChangeListener)
  {
    int k = 0;
    while (k < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (((IPlayVideoStatusChangeListener)this.jdField_b_of_type_JavaUtilArrayList.get(k)).equals(paramIPlayVideoStatusChangeListener)) {
        return;
      }
      k += 1;
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(paramIPlayVideoStatusChangeListener);
  }
  
  public void a(PollWidgetUtils.IPollWidget paramIPollWidget)
  {
    Context localContext = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getContext();
    Object localObject = a(((Integer)paramIPollWidget.a().getTag(2131362463)).intValue());
    if (localObject != null)
    {
      StoryReportor.a("play_video", "vote_detail", 1, 0, new String[0]);
      paramIPollWidget = new Intent(localContext, QQBrowserActivity.class);
      localObject = String.format(Locale.getDefault(), "http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0&vid=%s", new Object[] { ((StoryVideoItem)localObject).mVid });
      paramIPollWidget.putExtra("url", (String)localObject);
      paramIPollWidget.putExtra("startOpenPageTime", System.currentTimeMillis());
      SLog.b("VideoPlayModeBaseVASH_DEBUG", "go to url %s", localObject);
      localContext.startActivity(paramIPollWidget);
    }
  }
  
  public void a(PollWidgetUtils.IPollWidget paramIPollWidget, PollWidgetUtils.WidgetElement paramWidgetElement)
  {
    PlayModePollViewUtils.a(this, paramIPollWidget, paramWidgetElement);
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder) {}
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    b(paramVideoViewHolder, paramStoryVideoItem);
  }
  
  public void a(RateWidget paramRateWidget)
  {
    Context localContext = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getContext();
    Object localObject = a(((Integer)paramRateWidget.a().getTag(2131362463)).intValue());
    if (localObject != null)
    {
      StoryReportor.a("play_video", "vote_detail", 2, 0, new String[0]);
      paramRateWidget = new Intent(localContext, QQBrowserActivity.class);
      localObject = String.format(Locale.getDefault(), "http://story.now.qq.com/m/score/index.html?vid=%s&_wv=3&_nav_alpha=0", new Object[] { ((StoryVideoItem)localObject).mVid });
      paramRateWidget.putExtra("url", (String)localObject);
      paramRateWidget.putExtra("startOpenPageTime", System.currentTimeMillis());
      SLog.b("VideoPlayModeBase", "go to url %s", localObject);
      localContext.startActivity(paramRateWidget);
    }
  }
  
  public void a(RateWidget paramRateWidget, float paramFloat)
  {
    PlayModeInteractViewUtils.a(this, paramRateWidget, paramFloat);
  }
  
  public void a(QQUIEventReceiver paramQQUIEventReceiver)
  {
    a("", paramQQUIEventReceiver);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, true, 0L);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    Context localContext = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getContext();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new nnj(this, localContext, paramBoolean, paramCharSequence), paramLong);
  }
  
  public void a(String paramString, int paramInt)
  {
    SLog.d("VideoPlayModeBase", "get video info error , vid = %s", new Object[] { paramString });
    int k = 0;
    for (;;)
    {
      StoryVideoItem localStoryVideoItem;
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
      if (k < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (!paramString.equals(localStoryVideoItem.mVid)) {
          break label415;
        }
        localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(k);
        if (localVideoViewHolder != null)
        {
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
          SLog.b("Q.qqstory.player.YPlayModeUtils", "onGetVideoInfoError set progress bar GONE");
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
          if (localStoryVideoItem.mErrorCode == 0) {
            break label274;
          }
          localVideoViewHolder.jdField_a_of_type_Int = 4;
          localVideoViewHolder.jdField_b_of_type_Int = localStoryVideoItem.mErrorCode;
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(0);
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setTipsText(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getResources().getString(2131432108));
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
          StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(110), "", localStoryVideoItem.mVid });
        }
        paramInt = 101;
        if (!TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())) {
          break label398;
        }
        paramInt = 102;
      }
      for (;;)
      {
        StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(paramInt), "", localStoryVideoItem.mVid });
        return;
        label274:
        if ((localStoryVideoItem.isUploading()) || (StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)))
        {
          localVideoViewHolder.jdField_a_of_type_Int = 5;
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(2);
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(null);
          StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "1", String.valueOf(105), "", "" });
          break;
        }
        localVideoViewHolder.jdField_a_of_type_Int = 6;
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new nmx(this, localVideoViewHolder, paramInt, paramString));
        break;
        label398:
        if (TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
          paramInt = 103;
        }
      }
      label415:
      k += 1;
    }
  }
  
  public void a(String paramString, QQUIEventReceiver paramQQUIEventReceiver)
  {
    this.jdField_c_of_type_JavaUtilArrayList.add(paramQQUIEventReceiver);
    Dispatchers.get().registerSubscriber(paramString, paramQQUIEventReceiver);
  }
  
  public void a(String paramString1, String paramString2)
  {
    int k = 0;
    for (;;)
    {
      if (k < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (!paramString1.equals(((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(k)).mVid)) {
          break label148;
        }
        paramString2 = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(k);
        if (paramString2 != null)
        {
          paramString2.jdField_a_of_type_Int = 3;
          paramString2.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
          paramString2.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
          SLog.b("Q.qqstory.player.YPlayModeUtils", "onDownloadError set progress bar GONE");
          paramString2.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
          paramString2.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnTipsClickListener(new nmw(this, paramString2, paramString1));
          if ((this.jdField_b_of_type_Int == k) && (!NetworkUtil.a(a()))) {
            QQToast.a(a(), 1, 2131433227, 0).a();
          }
        }
      }
      return;
      label148:
      k += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @TargetApi(14)
  public boolean a(int paramInt)
  {
    SLog.d("Q.qqstory.player.YPlayModeUtils", "[6] startPlayVideo, index = %d", new Object[] { Integer.valueOf(paramInt) });
    boolean bool = QLog.isColorLevel();
    if (bool) {
      QLog.d("wyx", 2, new Object[] { "startPlayVideo. storyVideoItemIndex=", Integer.valueOf(paramInt), ", mCurrentIndex=", Integer.valueOf(this.jdField_b_of_type_Int) });
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localVideoViewHolder == null)
    {
      if (bool) {
        QLog.d("wyx", 2, new Object[] { "startPlayVideo. not found viewHolder. storyVideoItemIndex=", Integer.valueOf(paramInt), ", mCurrentIndex=", Integer.valueOf(this.jdField_b_of_type_Int) });
      }
      return false;
    }
    IVideoView localIVideoView = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView;
    Object localObject1 = localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView;
    Object localObject3 = localVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView;
    QQStoryLoadingView localQQStoryLoadingView = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
    QQStoryVideoPlayerErrorView localQQStoryVideoPlayerErrorView = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView;
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    PlayModeUtils.a((ImageView)localObject1, localStoryVideoItem.mLocalMaskPath, localStoryVideoItem.getDownloadMaskUrl(), localVideoViewHolder.jdField_b_of_type_Boolean);
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoPlayModeBase", 2, "azrael: setStoryPlayMask: localPath = " + localStoryVideoItem.mLocalMaskPath + ", url = " + localStoryVideoItem.getDownloadMaskUrl());
    }
    localQQStoryVideoPlayerErrorView.setVisibility(8);
    DownloadUrlManager localDownloadUrlManager = (DownloadUrlManager)SuperManager.a(28);
    if (paramInt == this.jdField_b_of_type_Int)
    {
      if (bool) {
        QLog.d("wyx", 2, new Object[] { "startPlayVideo index match. index=", Integer.valueOf(paramInt) });
      }
      a(this.jdField_b_of_type_Int, localStoryVideoItem, localVideoViewHolder);
      if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Boolean = false;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView instanceof VideoViewTextureImpl)) {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(null);
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder != null) && (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a()))
      {
        if (bool) {
          QLog.d("wyx", 2, new Object[] { "startPlayVideo video is already playing. index=", Integer.valueOf(paramInt) });
        }
        return true;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder = localVideoViewHolder;
      if (bool) {
        QLog.d("wyx", 2, new Object[] { "startPlayVideo index match and isPlaying=", Integer.valueOf(localStoryVideoItem.mIsPlaying), ". index=", Integer.valueOf(paramInt), ", vid=", localStoryVideoItem.mVid });
      }
      if (localStoryVideoItem.mIsPlaying == 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.d();
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b(a(paramInt), 0L);
        if (PlayModeUtils.b(localStoryVideoItem))
        {
          localVideoViewHolder.jdField_a_of_type_Int = 200;
          localQQStoryLoadingView.setVisibility(0);
          localQQStoryVideoPlayerErrorView.setVisibility(8);
          return false;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Boolean = true;
        StoryReportor.b("play_video", "play_process", 0, 0, new String[] { localStoryVideoItem.mVid, localStoryVideoItem.getVideoUrl(), String.valueOf(StoryReportor.a(BaseApplication.getContext())) });
        Object localObject2 = a(paramInt);
        if (localObject2 != null)
        {
          if (((DefaultPlayerVideoListSynchronizer)localObject2).a(localStoryVideoItem))
          {
            a(localStoryVideoItem.mVid, paramInt);
            return false;
          }
        }
        else if ((TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())) && (TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)))
        {
          a(localStoryVideoItem.mVid, paramInt);
          return true;
        }
        localIVideoView.a(0);
        ((ImageView)localObject1).setVisibility(0);
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.b(localStoryVideoItem.mVid);
        if ((localObject2 != null) && (FileCacheUtils.a(new File((String)localObject2))))
        {
          localObject1 = new String[2];
          int m = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size();
          int k = 0;
          while (k < 2)
          {
            if (paramInt + k + 1 < m) {
              localObject1[k] = ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt + k + 1)).mVid;
            }
            k += 1;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(localStoryVideoItem.mVid, (String[])localObject1);
        }
        for (;;)
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((String)localObject2).startsWith("file://")) {
              localObject1 = ((String)localObject2).substring(7);
            }
          }
          localIVideoView.a(new nno(this, paramInt, localIVideoView, (ImageView)localObject3, localQQStoryLoadingView));
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("VideoPlayModeBase", 2, "只有网络url, 等待下载， vid:" + localStoryVideoItem.mVid + ",videoUrl:" + localStoryVideoItem.getVideoUrl());
          }
          this.jdField_i_of_type_Long = System.currentTimeMillis();
          localQQStoryLoadingView.setVisibility(0);
          localQQStoryVideoPlayerErrorView.setVisibility(8);
          localIVideoView.a(null);
          localIVideoView.a(null);
          localIVideoView.a(localStoryVideoItem.mVid, null, null, System.identityHashCode(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity));
          return false;
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(localStoryVideoItem.mVid, new String[0]);
        }
        PlayModeUtils.a(System.identityHashCode(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity)).jdField_e_of_type_Long = SystemClock.uptimeMillis();
        if (VideoViewFactory.a(BaseApplicationImpl.getContext()).a()) {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (FileCacheUtils.a(new File((String)localObject1))) {
              localQQStoryLoadingView.setVisibility(4);
            }
          }
          else
          {
            localIVideoView.a(new nnb(this, (String)localObject1, localStoryVideoItem, localDownloadUrlManager, paramInt));
            localIVideoView.a(new nne(this, localStoryVideoItem, localQQStoryLoadingView));
            this.jdField_e_of_type_Long = 0L;
            localStoryVideoItem.mIsPlaying = 1;
            if (bool) {
              QLog.d("wyx", 2, new Object[] { "startPlayVideo setIsPlaying=1. index=", Integer.valueOf(paramInt), ", vid=", localStoryVideoItem.mVid, ", storyVideoItem hashcode=", Integer.valueOf(localStoryVideoItem.hashCode()) });
            }
            localObject2 = localDownloadUrlManager.a(localStoryVideoItem.mVid, 0);
            if (((DownloadUrlManager.DownloadUrlQueryResult)localObject2).jdField_a_of_type_Boolean)
            {
              localObject3 = new File((String)localObject1);
              if ((((File)localObject3).exists()) && (!FileCacheUtils.a((File)localObject3)))
              {
                ((File)localObject3).delete();
                SLog.d("VideoPlayModeBase", "%s - %d found orphan tmp , delete it", new Object[] { ((DownloadUrlManager.DownloadUrlQueryResult)localObject2).jdField_a_of_type_JavaLangString, Integer.valueOf(((DownloadUrlManager.DownloadUrlQueryResult)localObject2).jdField_a_of_type_Int) });
              }
            }
            localIVideoView.a(localStoryVideoItem.mVid, (String)localObject1, ((DownloadUrlManager.DownloadUrlQueryResult)localObject2).jdField_b_of_type_JavaLangString, System.identityHashCode(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity));
            if (QLog.isColorLevel())
            {
              QLog.i("VideoPlayModeBase", 2, "prepared video. vid = " + localStoryVideoItem.mVid + " localPath = " + localStoryVideoItem.mLocalVideoPath);
              QLog.i("VideoPlayModeBase", 2, "storyVideoItemIndex = " + paramInt + ", mCurrentIndex = " + this.jdField_b_of_type_Int);
              QLog.i("VideoPlayModeBase", 2, "storyVideoItem.mIsPlaying = " + localStoryVideoItem.mIsPlaying + ", mIsVideoListEnd = " + this.jdField_a_of_type_Boolean);
              QLog.i("VideoPlayModeBase", 2, "before start time:" + System.currentTimeMillis());
            }
            if (this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.e())
            {
              localObject2 = a(paramInt);
              localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(PlayModeUtils.a(localStoryVideoItem, (String)localObject1, (VideoListFeedItem)localObject2));
            }
          }
        }
      }
      for (;;)
      {
        if (!((StoryConfigManager)SuperManager.a(10)).a()) {
          this.jdField_a_of_type_AndroidOsHandler.post(new nnf(this, localQQStoryLoadingView, localQQStoryVideoPlayerErrorView, paramInt, localStoryVideoItem));
        }
        return true;
        localQQStoryLoadingView.setVisibility(0);
        break;
        localQQStoryLoadingView.setVisibility(4);
        break;
        if (localStoryVideoItem.mIsPlaying == 2)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Boolean = true;
          localIVideoView.a(4);
          ((ImageView)localObject1).setVisibility(4);
          localIVideoView.b();
          this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.a(this.jdField_b_of_type_Int);
          this.jdField_e_of_type_Long = 0L;
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(a(this.jdField_b_of_type_Int), 0L, localIVideoView.b(), localIVideoView);
          localStoryVideoItem.mIsPlaying = 1;
        }
        else if (localStoryVideoItem.mIsPlaying == 1)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.a(this.jdField_b_of_type_Int);
          if (!localIVideoView.a())
          {
            localIVideoView.b();
            this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a(a(this.jdField_b_of_type_Int), 0L, localIVideoView.b(), localIVideoView);
            if (QLog.isColorLevel()) {
              QLog.i("VideoPlayModeBase", 2, "Do play video. not playing, start, videoIndex:" + paramInt);
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      g();
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.j(this.jdField_b_of_type_Int);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
    if (localVideoViewHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null)
      {
        this.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.k(this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    Object localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (localObject == null) {}
    StoryVideoItem localStoryVideoItem;
    String str;
    long l;
    do
    {
      return;
      localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      str = StoryReportor.a(a());
      l = ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
      if (paramInt2 == 1) {
        l = this.jdField_c_of_type_Long;
      }
      if (QLog.isColorLevel()) {
        QLog.i("reportTroopVideo", 2, this.jdField_a_of_type_Int + "," + l + "," + localStoryVideoItem.mOwnerUid + "," + localStoryVideoItem.mVid);
      }
    } while (l <= 0L);
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("author_id", localStoryVideoItem.mOwnerUid + "");
        ((JSONObject)localObject).put("author_type", "1");
        ((JSONObject)localObject).put("video_type", "1");
        ((JSONObject)localObject).put("video_time", this.jdField_c_of_type_Long + "");
        ((JSONObject)localObject).put("play_time", l + "");
        ((JSONObject)localObject).put("video_restrict", localStoryVideoItem.mBanType + "");
        if (localStoryVideoItem.mIsPicture != 1) {
          break label487;
        }
        paramInt1 = 1;
        ((JSONObject)localObject).put("content_type", paramInt1);
        if (localStoryVideoItem.mLocalCreateTime > 0L) {
          break label492;
        }
        paramInt1 = 1;
        ((JSONObject)localObject).put("content_origin", paramInt1);
        if ((this.jdField_i_of_type_Long <= this.jdField_a_of_type_Long) || (this.jdField_b_of_type_Long <= this.jdField_i_of_type_Long)) {
          break label497;
        }
        l = this.jdField_b_of_type_Long - this.jdField_i_of_type_Long;
        ((JSONObject)localObject).put("load_time", l + "");
        StoryReportor.a("story_grp", "play_video_js", a(), paramInt2, new String[] { ((JSONObject)localObject).toString(), "", str, localStoryVideoItem.mVid });
        return;
      }
      catch (JSONException localJSONException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("VideoPlayModeBase", 2, "reportTroopVideo exception:" + QLog.getStackTraceString(localJSONException));
      return;
      label487:
      paramInt1 = 2;
      continue;
      label492:
      paramInt1 = 2;
      continue;
      label497:
      l = 0L;
    }
  }
  
  public abstract void b(DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent);
  
  public void b(IPlayVideoStatusChangeListener paramIPlayVideoStatusChangeListener)
  {
    int k = 0;
    for (;;)
    {
      if (k < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        if (((IPlayVideoStatusChangeListener)this.jdField_b_of_type_JavaUtilArrayList.get(k)).equals(paramIPlayVideoStatusChangeListener)) {
          this.jdField_b_of_type_JavaUtilArrayList.remove(k);
        }
      }
      else {
        return;
      }
      k += 1;
    }
  }
  
  public void b(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isPollVideo())
    {
      PlayModePollViewUtils.a(this, paramVideoViewHolder, paramStoryVideoItem);
      return;
    }
    if (paramStoryVideoItem.isInteractVideo())
    {
      PlayModeInteractViewUtils.a(this, paramVideoViewHolder, paramStoryVideoItem);
      return;
    }
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_c_of_type_Boolean) {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(15000L);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.b();
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.dismiss();
    }
    int k = 0;
    while (k < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      Dispatchers.get().unRegisterSubscriber((Subscriber)this.jdField_c_of_type_JavaUtilArrayList.get(k));
      k += 1;
    }
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a();
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.j += 1;
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (localVideoViewHolder == null) {}
    StoryVideoItem localStoryVideoItem;
    String str2;
    long l1;
    label65:
    label75:
    do
    {
      return;
      localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      str2 = StoryReportor.a(a());
      if (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView == null) {
        break;
      }
      l1 = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
      if (paramInt2 != 1) {
        break label1612;
      }
      l1 = this.jdField_c_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.i("reportviewvideo", 2, this.jdField_a_of_type_Int + "," + l1 + "," + localStoryVideoItem.mOwnerUid + "," + localStoryVideoItem.mVid);
      }
    } while (l1 <= 0L);
    Object localObject2 = "1";
    Object localObject1 = localObject2;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject1 = localObject2;
    case 3: 
    case 4: 
      label204:
      StoryReportor.a("play_video", "exp", 0, 0, new String[] { localObject1, l1 + "", localStoryVideoItem.mOwnerUid + "", "" });
      localObject1 = ((UserManager)SuperManager.a(2)).b(localStoryVideoItem.mOwnerUid);
    }
    for (;;)
    {
      VideoListFeedItem localVideoListFeedItem;
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("author_id", localStoryVideoItem.mOwnerUid + "");
        if (localStoryVideoItem.mStoryType != 2) {
          break label1574;
        }
        localObject1 = "6";
        ((JSONObject)localObject2).put("author_type", localObject1);
        ((JSONObject)localObject2).put("video_type", "1");
        ((JSONObject)localObject2).put("video_time", this.jdField_c_of_type_Long + "");
        ((JSONObject)localObject2).put("play_time", l1 + "");
        ((JSONObject)localObject2).put("video_restrict", localStoryVideoItem.mBanType + "");
        if (localStoryVideoItem.mIsPicture != 1) {
          break label1631;
        }
        paramInt1 = 1;
        ((JSONObject)localObject2).put("content_type", paramInt1);
        if (localStoryVideoItem.mLocalCreateTime > 0L) {
          break label1636;
        }
        paramInt1 = 1;
        ((JSONObject)localObject2).put("content_origin", paramInt1);
        ((JSONObject)localObject2).put("vote_id", StoryReportor.a(localStoryVideoItem));
        if ((this.jdField_i_of_type_Long <= this.jdField_a_of_type_Long) || (this.jdField_b_of_type_Long <= this.jdField_i_of_type_Long)) {
          break label1641;
        }
        l2 = this.jdField_b_of_type_Long - this.jdField_i_of_type_Long;
        localVideoListFeedItem = a(this.jdField_b_of_type_Int);
        ((JSONObject)localObject2).put("load_time", l2 + "");
        ((JSONObject)localObject2).put("viewer_id", StoryReportor.a(localVideoListFeedItem));
        ((JSONObject)localObject2).put("sharefromapp", Integer.toString(StoryApi.a(2131689488)));
        if (localStoryVideoItem.mTagInfoBase != null) {
          ((JSONObject)localObject2).put("tag_id", localStoryVideoItem.mTagInfoBase.jdField_a_of_type_Long);
        }
        if (localStoryVideoItem.mSourceType == -1) {
          break label1647;
        }
        bool = true;
        AssertUtils.a(bool, "storyVideoItem.mSourceType is illegal");
        ((JSONObject)localObject2).put("video_origin", localStoryVideoItem.mSourceType);
        paramInt1 = a();
        String str3 = ((JSONObject)localObject2).toString();
        if (localVideoListFeedItem != null) {
          break label1595;
        }
        localObject2 = "";
        StoryReportor.a("play_video", "video_all_js", paramInt1, paramInt2, new String[] { str3, localObject2, str2, localStoryVideoItem.mVid });
        StoryReportor.a("play_video", "video_property", paramInt1, paramInt2, new String[] { localStoryVideoItem.mOwnerUid + "", localObject1, "1", localStoryVideoItem.mVid });
        StoryReportor.a("play_video", "video_time", paramInt1, paramInt2, new String[] { this.jdField_c_of_type_Long + "", l1 + "", l2 + "", localStoryVideoItem.mVid });
        StoryReportor.b("play_video", "play_done", 0, 0, new String[] { "0", "", "", localStoryVideoItem.mVid });
        if (this.jdField_g_of_type_Int > 0)
        {
          StoryReportor.b("play_video", "buffering_count", this.jdField_g_of_type_Int, a(), new String[] { "", str2, "", localStoryVideoItem.mVid });
          this.jdField_g_of_type_Int = 0;
        }
        if (this.jdField_f_of_type_Long > 0L)
        {
          StoryReportor.b("play_video", "buffering_total_time", (int)this.jdField_f_of_type_Long, a(), new String[] { "", str2, "", localStoryVideoItem.mVid });
          this.jdField_f_of_type_Long = 0L;
        }
        if ((localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null) && (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a() == 1)) {
          StoryReportor.b("story_steaming", "story_steaming_result", 0, 0, new String[] { localStoryVideoItem.mVideoBytes + "", "", str2, localStoryVideoItem.mVid });
        }
        if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath))
        {
          localObject1 = new File(localStoryVideoItem.mLocalVideoPath);
          if (((File)localObject1).exists()) {
            StoryReportor.b("play_video", "play_bytes", 0, 0, new String[] { String.valueOf(((File)localObject1).length()), "0", localStoryVideoItem.mDownloadNetType, localStoryVideoItem.mVid });
          }
        }
        if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath))
        {
          localObject1 = new File(localStoryVideoItem.mLocalMaskPath);
          if (((File)localObject1).exists()) {
            StoryReportor.b("play_video", "play_bytes", 0, 0, new String[] { String.valueOf(((File)localObject1).length()), "1", localStoryVideoItem.mDownloadNetType, localStoryVideoItem.mVid });
          }
        }
        if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath))
        {
          localObject1 = new File(localStoryVideoItem.mVideoLocalThumbnailPath);
          if (((File)localObject1).exists()) {
            StoryReportor.b("play_video", "play_bytes", 0, 0, new String[] { String.valueOf(((File)localObject1).length()), "2", localStoryVideoItem.mDownloadNetType, localStoryVideoItem.mVid });
          }
        }
        l1 = 0L;
        if (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) {
          l1 = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
        }
        localObject2 = l1 + "";
        if (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView == null) {
          break label1605;
        }
        localObject1 = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a() + "";
        StoryReportor.b("play_video", "local_load_time", 0, 0, new String[] { localObject2, "", localObject1, localStoryVideoItem.mVid });
        return;
      }
      catch (JSONException localJSONException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("VideoPlayModeBase", 2, "reportViewVideo exception:" + QLog.getStackTraceString(localJSONException));
      return;
      l1 = 0L;
      break label65;
      String str1 = "2";
      break label204;
      str1 = "5";
      break label204;
      str1 = "7";
      break label204;
      str1 = "8";
      break label204;
      label1574:
      if (str1 != null)
      {
        if (str1.isVip)
        {
          str1 = "3";
          continue;
          label1595:
          localObject2 = localVideoListFeedItem.feedId;
          continue;
          label1605:
          str1 = "";
          continue;
          label1612:
          break label75;
        }
        str1 = "1";
        continue;
      }
      str1 = "1";
      continue;
      label1631:
      paramInt1 = 2;
      continue;
      label1636:
      paramInt1 = 2;
      continue;
      label1641:
      long l2 = 0L;
      continue;
      label1647:
      boolean bool = false;
    }
  }
  
  public final void c(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    SLog.d("Q.qqstory.player.YPlayModeUtils", "onBaseFillData, position = %d", new Object[] { Integer.valueOf(paramVideoViewHolder.jdField_c_of_type_Int) });
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(a(paramVideoViewHolder.jdField_c_of_type_Int));
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(new VideoPlayModeBase.VideoOnErrorListener(this, paramVideoViewHolder, paramStoryVideoItem));
    PlayModeUtils.a((WindowManager)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.getContext().getSystemService("window"), paramVideoViewHolder, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramStoryVideoItem.playerScaleType);
    PlayModeUtils.a(paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView, paramStoryVideoItem.mVideoLocalThumbnailPath, paramStoryVideoItem.getThumbUrl(), paramVideoViewHolder.jdField_b_of_type_Boolean, null);
    if (QLog.isDevelopLevel())
    {
      QLog.i("VideoPlayModeBase", 2, "azrael: setCover: localPath = " + paramStoryVideoItem.mVideoLocalThumbnailPath + ", url=" + paramStoryVideoItem.getThumbUrl());
      QLog.i("VideoPlayModeBase", 2, "azrael: setMask: localPath = " + paramStoryVideoItem.mLocalMaskPath + ", url=" + paramStoryVideoItem.getDownloadMaskUrl());
    }
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.e())
    {
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      a(paramVideoViewHolder, paramStoryVideoItem);
      if (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) {
        break label314;
      }
    }
    label314:
    for (String str1 = paramStoryVideoItem.mOwnerUid;; str1 = this.jdField_b_of_type_JavaLangString)
    {
      String str2 = this.jdField_d_of_type_JavaLangString;
      int k = paramVideoViewHolder.jdField_c_of_type_Int;
      if (!PlayModeUtils.b(paramStoryVideoItem)) {
        PlayModeUtils.a(str1, str2, new nmq(this, k, str1, str2, paramStoryVideoItem), false);
      }
      return;
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    String str = null;
    Object localObject3 = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
    Object localObject4;
    Object localObject2;
    VideoListFeedItem localVideoListFeedItem;
    if ((localObject3 != null) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localObject4 = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
      if (this.jdField_e_of_type_Int != 2) {
        break label496;
      }
      localObject2 = ((StoryVideoItem)localObject4).mGroupId;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localVideoListFeedItem = a(((VideoPlayerPagerAdapter.VideoViewHolder)localObject3).jdField_c_of_type_Int);
        localObject1 = localObject2;
        if (localVideoListFeedItem != null)
        {
          localObject1 = localObject2;
          if (localVideoListFeedItem.getOwner() != null)
          {
            localObject1 = localObject2;
            if (!(localVideoListFeedItem.getOwner() instanceof QQUserUIItem)) {}
          }
        }
      }
    }
    label491:
    label496:
    for (Object localObject1 = ((QQUserUIItem)localVideoListFeedItem.getOwner()).qq;; localObject1 = null)
    {
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, (VideoPlayerPagerAdapter.VideoViewHolder)localObject3, (StoryVideoItem)localObject4, (String)localObject1);
      localObject3 = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int - 1);
      if ((localObject3 != null) && (this.jdField_b_of_type_Int - 1 > 0) && (this.jdField_b_of_type_Int - 1 < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localObject4 = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int - 1);
        if (this.jdField_e_of_type_Int != 2) {
          break label491;
        }
        localObject2 = ((StoryVideoItem)localObject4).mGroupId;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localVideoListFeedItem = a(((VideoPlayerPagerAdapter.VideoViewHolder)localObject3).jdField_c_of_type_Int);
          localObject1 = localObject2;
          if (localVideoListFeedItem != null)
          {
            localObject1 = localObject2;
            if (localVideoListFeedItem.getOwner() != null)
            {
              localObject1 = localObject2;
              if (!(localVideoListFeedItem.getOwner() instanceof QQUserUIItem)) {}
            }
          }
        }
      }
      for (localObject1 = ((QQUserUIItem)localVideoListFeedItem.getOwner()).qq;; localObject1 = null)
      {
        PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, (VideoPlayerPagerAdapter.VideoViewHolder)localObject3, (StoryVideoItem)localObject4, (String)localObject1);
        localObject2 = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int + 1);
        if ((localObject2 != null) && (this.jdField_b_of_type_Int + 1 > 0) && (this.jdField_b_of_type_Int + 1 < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject3 = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int + 1);
          localObject1 = str;
          if (this.jdField_e_of_type_Int == 2)
          {
            str = ((StoryVideoItem)localObject3).mGroupId;
            localObject1 = str;
            if (TextUtils.isEmpty(str))
            {
              localObject4 = a(((VideoPlayerPagerAdapter.VideoViewHolder)localObject2).jdField_c_of_type_Int);
              localObject1 = str;
              if (localObject4 != null)
              {
                localObject1 = str;
                if (((VideoListFeedItem)localObject4).getOwner() != null)
                {
                  localObject1 = str;
                  if ((((VideoListFeedItem)localObject4).getOwner() instanceof QQUserUIItem)) {
                    localObject1 = ((QQUserUIItem)((VideoListFeedItem)localObject4).getOwner()).qq;
                  }
                }
              }
            }
          }
          PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity, (VideoPlayerPagerAdapter.VideoViewHolder)localObject2, (StoryVideoItem)localObject3, (String)localObject1);
        }
        return;
      }
    }
  }
  
  public void d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      SLog.d("VideoPlayModeBase", "yarkeyReportViewVideo illegal index %d, list size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()) });
      return;
    }
    Object localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null)
    {
      SLog.d("VideoPlayModeBase", "yarkeyReportViewVideo can not find holder");
      return;
    }
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    SLog.b("VideoPlayModeBase", "yarkeyReportViewVideo, report the state = %d, errorCode = %d, subErrorCode = %d", Integer.valueOf(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).a()), Integer.valueOf(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_Int), Integer.valueOf(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_b_of_type_Int));
    String str;
    if ((((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null) && ((((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_Int == 0) || (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_Int == 7))) {
      if (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a() == 1)
      {
        str = "1";
        switch (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).a())
        {
        default: 
          localObject = "0";
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      StoryReportor.b("play_video", "play_result", a(), paramInt, new String[] { localObject, str, StoryReportor.a(a()), localStoryVideoItem.mVid });
      return;
      str = "2";
      break;
      str = "0";
      break;
      paramInt = ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_Int;
      localObject = String.valueOf(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_b_of_type_Int);
      continue;
      paramInt = 201;
      localObject = String.valueOf(SystemClock.uptimeMillis() - ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_Long);
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry != null)
    {
      NowProxy localNowProxy = (NowProxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
      NowFromData localNowFromData = new NowFromData();
      localNowFromData.jdField_b_of_type_JavaLangString = "story";
      localNowFromData.jdField_a_of_type_JavaLangString = "story";
      localNowProxy.a(null, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry.roomId, localNowFromData, 2, null);
      StoryListUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry.unionId);
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.d();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.c(this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() - 1)
    {
      if (a())
      {
        e();
        g();
        return;
      }
      this.jdField_b_of_type_Int += 1;
      return;
    }
    StoryReportor.a("play_video", "clk_next", 0, 0, new String[] { "1", "", "", "" });
    this.jdField_i_of_type_Int = -1;
    int k = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int += 1;
    boolean bool = a(k, this.jdField_b_of_type_Int);
    if (bool) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilViewPagerScroller.a(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.jdField_b_of_type_Int, bool);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Boolean;
  }
  
  public void j() {}
  
  public void k()
  {
    if (!jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return;
    }
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
    if (localVideoViewHolder != null)
    {
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.k(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b();
    }
    this.jdField_i_of_type_Int = this.jdField_b_of_type_Int;
  }
  
  public void l()
  {
    if (!jdField_a_of_type_JavaLangBoolean.booleanValue()) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
      } while (localObject == null);
      localObject = ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView;
    } while (((IVideoView)localObject).a());
    ((IVideoView)localObject).b();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.l(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.c();
  }
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size() == 1) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_Boolean)
      {
        this.jdField_i_of_type_Int = -1;
        return;
      }
    } while (paramInt == this.jdField_h_of_type_Int);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_h_of_type_Int = paramInt;
      return;
      if (this.jdField_i_of_type_Int != -1)
      {
        if (this.jdField_i_of_type_Int == this.jdField_b_of_type_Int) {
          break label110;
        }
        a(this.jdField_i_of_type_Int, true);
      }
      for (;;)
      {
        this.jdField_i_of_type_Int = -1;
        q();
        break;
        label110:
        localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
        if (localObject != null)
        {
          localObject = ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView;
          if (!((IVideoView)localObject).a())
          {
            ((IVideoView)localObject).b();
            this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.l(this.jdField_b_of_type_Int);
            this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.c();
          }
        }
      }
      Object localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
      if (localObject != null)
      {
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.k(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b();
      }
      this.jdField_i_of_type_Int = this.jdField_b_of_type_Int;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    String str;
    long l;
    if (this.jdField_d_of_type_Boolean)
    {
      str = "1";
      StoryReportor.b("play_video", "want_play_video", 0, 0, new String[] { str });
      this.jdField_d_of_type_Boolean = false;
      SLog.a("VideoPlayModeBase", "[6] onPageSelected : %d", Integer.valueOf(paramInt));
      PlayModeUtils.a(System.identityHashCode(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_AndroidAppActivity)).d = SystemClock.uptimeMillis();
      l = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$HideProgressBarRunnable.jdField_a_of_type_Int != paramInt) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$HideProgressBarRunnable);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
      if (this.jdField_i_of_type_Int == -1) {
        break label264;
      }
      if (this.jdField_i_of_type_Int >= paramInt) {
        break label234;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.d(this.jdField_i_of_type_Int);
      label159:
      if (this.jdField_i_of_type_Int != paramInt) {
        break label256;
      }
      a(paramInt, true);
      this.jdField_i_of_type_Int = -1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayModeBase", 2, "onPageSelected() costTime: " + (System.currentTimeMillis() - l) + ", index: " + paramInt);
      }
      return;
      str = "2";
      break;
      label234:
      if (this.jdField_i_of_type_Int <= paramInt) {
        break label159;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.e(this.jdField_i_of_type_Int);
      break label159;
      label256:
      this.jdField_i_of_type_Int = paramInt;
      continue;
      label264:
      a(paramInt, false);
      this.jdField_i_of_type_Int = -1;
    }
  }
  
  public void p()
  {
    e();
    g();
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.g(this.jdField_b_of_type_Int);
  }
  
  public void q() {}
  
  public void r()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new nni(this));
  }
  
  public void s()
  {
    int k = this.j - 1;
    this.j = k;
    if (k <= 0)
    {
      this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      this.j = 0;
    }
  }
  
  public void t() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.VideoPlayModeBase
 * JD-Core Version:    0.7.0.1
 */