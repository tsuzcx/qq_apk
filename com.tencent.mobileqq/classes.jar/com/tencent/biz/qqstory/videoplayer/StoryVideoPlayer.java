package com.tencent.biz.qqstory.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase.TopViewHolder;
import com.tencent.biz.qqstory.playmode.VideoPlayModeFactory;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DebugInfo;
import com.tencent.biz.qqstory.playvideo.CustomViewPager;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BetterGestureDetector;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import ons;
import ont;
import onu;
import onv;
import onw;
import onx;
import onz;

public class StoryVideoPlayer
  extends RelativeLayout
  implements View.OnClickListener, IEventReceiver
{
  public int a;
  public Activity a;
  public ImageView a;
  public VideoPlayModeBase a;
  public CustomViewPager a;
  public ProgressControler a;
  public QQStoryVideoPlayerErrorView a;
  public StoryVideoPlayer.GestureListener a;
  public StoryVideoPlayer.OnCloseListener a;
  public VideoPlayerPagerAdapter a;
  public SplitedProgressBar a;
  public QQStoryLoadingView a;
  public boolean a;
  public int b;
  public boolean b;
  public boolean c;
  
  public StoryVideoPlayer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StoryVideoPlayer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    a(paramContext);
  }
  
  private void b(Bundle paramBundle)
  {
    PlayModeUtils.a(System.identityHashCode(this.jdField_a_of_type_AndroidAppActivity)).c = SystemClock.uptimeMillis();
    SLog.d("Q.qqstory.player.StoryVideoPlayer", "[3/8] trulyStart %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    VideoPlayModeBase.TopViewHolder localTopViewHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase$TopViewHolder;
    localTopViewHolder.a = ((LinearLayout)findViewById(2131371979));
    localTopViewHolder.b = ((LinearLayout)findViewById(2131371980));
    localTopViewHolder.c = ((LinearLayout)findViewById(2131371981));
    localTopViewHolder.d = ((LinearLayout)findViewById(2131371982));
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase);
    setGestureListener(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.b();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$OnCloseListener != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$OnCloseListener.a(paramInt);
      e();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130970846, this, true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager = ((CustomViewPager)localView.findViewById(2131370498));
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)localView.findViewById(2131364788));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)super.findViewById(2131362985));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnClickListener(new ons(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)super.findViewById(2131368932));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370490));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler = new ProgressControler(this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter = new VideoPlayerPagerAdapter(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setPageMargin(10);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setGestureListener(new onz(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.a.a(50);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setClickable(true);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setOnTouchListener(new ont(this));
    new Handler(Looper.getMainLooper()).postDelayed(new onu(this), 300L);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase = VideoPlayModeFactory.a(paramBundle.getInt("EXTRA_VIDEO_MODE"), this, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter, paramBundle);
    PlayModeUtils.a(System.identityHashCode(this.jdField_a_of_type_AndroidAppActivity)).b = SystemClock.uptimeMillis();
    String str1 = paramBundle.getString("EXTRA_USER_UNION_ID", "");
    boolean bool;
    if (!TextUtils.isEmpty(str1))
    {
      bool = true;
      this.b = bool;
      SLog.d("Q.qqstory.player.StoryVideoPlayer", "start, mIsFetchingUserInfo=%s, mVideoPlayMode.mStoryType=%d, playMode=%s", new Object[] { Boolean.valueOf(this.b), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.e), this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.getClass().getSimpleName() });
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.e == -1) || (this.b)) {
        break label149;
      }
      ThreadManager.getUIHandler().post(new onv(this, paramBundle));
    }
    label149:
    do
    {
      return;
      bool = false;
      break;
      if ((!this.c) && (!this.b))
      {
        ThreadManager.getUIHandler().post(new onw(this, paramBundle));
        return;
      }
    } while (!this.b);
    String str2 = paramBundle.getString("EXTRA_USER_UIN");
    PlayModeUtils.a(str1, str2, new onx(this, str1, str2, paramBundle), false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.c();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.e();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.d();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.c();
    }
  }
  
  public void d()
  {
    a(1);
  }
  
  public void e()
  {
    String str = "0";
    int i;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0))
    {
      SLog.c("Q.qqstory.player.StoryVideoPlayer", "yarkeyReportViewVideo, onClose report the state = 1");
      i = 200;
      str = String.valueOf(SystemClock.uptimeMillis() - PlayModeUtils.a(System.identityHashCode(this.jdField_a_of_type_AndroidAppActivity)).a);
    }
    for (;;)
    {
      if (i != 0) {
        StoryReportor.b("play_video", "play_result", this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(), i, new String[] { str, "0", StoryReportor.a(VideoPlayModeBase.a()), "" });
      }
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() == 0))
      {
        SLog.c("Q.qqstory.player.StoryVideoPlayer", "yarkeyReportViewVideo, onClose report the state = 2");
        str = "1";
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.g(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.g();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$OnCloseListener != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$OnCloseListener.a(1);
        e();
      }
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase == null) || (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener == null));
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.f(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.getCurrentItem())
    {
      if (bool) {
        QLog.d("wyx", 2, new Object[] { "StoryVideoPlayer-setCurrentItem when index not change. index=", Integer.valueOf(paramInt) });
      }
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (((localVideoViewHolder == null) || (!localVideoViewHolder.a.a())) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        if (bool) {
          QLog.d("wyx", 2, new Object[] { "StoryVideoPlayer-setCurrentItem-onPageSelected when index not change. index=", Integer.valueOf(paramInt) });
        }
        ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).mIsPlaying = 0;
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.onPageSelected(paramInt);
      }
      return;
    }
    if (bool) {
      QLog.d("wyx", 2, new Object[] { "StoryVideoPlayer-setCurrentItem when index change. index=", Integer.valueOf(paramInt) });
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setCurrentItem(paramInt, paramBoolean);
  }
  
  public void setGestureListener(StoryVideoPlayer.GestureListener paramGestureListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$GestureListener = paramGestureListener;
  }
  
  public void setOnCloseListener(StoryVideoPlayer.OnCloseListener paramOnCloseListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer$OnCloseListener = paramOnCloseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer
 * JD-Core Version:    0.7.0.1
 */