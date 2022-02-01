package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryDepends.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.events.ReadStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

public class QQStoryAutoPlayView
  extends FrameLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int a = 0;
  private boolean b = false;
  private StoryUploadProgressView c;
  private ImageView d;
  private PollContainerLayout e;
  private AutoPlayImageView f;
  private StoryVideoItem g;
  private AutoPlayManager h;
  private WatchVideoHandler i;
  private VideoListFeedItem j;
  private QQStoryAutoPlayView.StoryCoverClickListener k;
  private long l = -1L;
  private long m = 0L;
  private long n = -1L;
  private long o = 0L;
  
  public QQStoryAutoPlayView(Context paramContext)
  {
    super(paramContext);
    k();
  }
  
  public QQStoryAutoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    k();
  }
  
  public QQStoryAutoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k();
  }
  
  private void k()
  {
    super.setOnClickListener(this);
    super.setOnLongClickListener(this);
    this.d = new ImageView(getContext());
    this.e = new PollContainerLayout(getContext());
    this.e.a(true);
    this.f = new AutoPlayImageView(getContext());
    MessageProgressView localMessageProgressView = new MessageProgressView(getContext());
    this.c = new StoryUploadProgressView(localMessageProgressView);
    this.c.a();
    this.i = new WatchVideoHandler();
    this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
    super.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    super.addView(localMessageProgressView, new FrameLayout.LayoutParams(-1, -1));
    super.setOnClickListener(this);
    this.d.setVisibility(8);
    this.c.a(4);
  }
  
  private void l()
  {
    if (StoryVideoItem.isFakeVid(this.g.mVid)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQStoryAutoPlayView---- reportWatchVideo ------coverUrl=");
    ((StringBuilder)localObject).append(this.g.getThumbUrl());
    SLog.b("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject).toString());
    StoryVideoItem localStoryVideoItem = this.h.a(this.g.mVid);
    if (localStoryVideoItem == null) {
      return;
    }
    if (!TextUtils.isEmpty(localStoryVideoItem.shareGroupId)) {
      localObject = localStoryVideoItem.shareGroupId;
    } else {
      localObject = localStoryVideoItem.mOwnerUid;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new ReadStoryVideoEvent((String)localObject, localStoryVideoItem);
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
    }
    if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
    {
      localObject = localStoryVideoItem.mOwnerUid;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("this story item info incomplete .vid=");
      ((StringBuilder)localObject).append(this.g.mVid);
      SLog.e("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject).toString());
      localObject = "";
    }
    this.i.a(localStoryVideoItem.mVid, (String)localObject, 79, false, localStoryVideoItem.mCreateTime);
  }
  
  private void m()
  {
    StoryVideoItem localStoryVideoItem;
    int i1;
    int i2;
    long l1;
    long l2;
    if (this.h != null)
    {
      if (this.j.isFakeFeedItem()) {
        return;
      }
      localStoryVideoItem = this.h.a(this.g.mVid);
      if (localStoryVideoItem == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QQStoryAutoPlayView reportAutoPlayStory but getVideo is null, vid=");
        ((StringBuilder)localObject).append(this.g.mVid);
        SLog.e("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject).toString());
        return;
      }
      if (localStoryVideoItem.mIsPicture == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      i2 = StoryReportor.a(this.j);
      l1 = localStoryVideoItem.mVideoDuration;
      l2 = this.m;
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("vid", localStoryVideoItem.mVid);
      localJSONObject.put("feedid", this.j.feedId);
      localJSONObject.put("author_id", this.j.ownerId);
      if (!this.j.isReportedAutoPlay) {
        break label289;
      }
      localObject = "2";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        label212:
        continue;
        String str = "1";
      }
    }
    localJSONObject.put("type", localObject);
    Object localObject = localJSONObject.toString();
    break label212;
    localObject = "";
    StoryReportor.b("auto_play", "auto_play_720", this.h.a(), i1, new String[] { String.valueOf(i2), String.valueOf(l1), String.valueOf(l2), localObject });
    InfoPrinter.c("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory dev url= ", localStoryVideoItem.getThumbUrl() });
  }
  
  private void n()
  {
    Object localObject1;
    int i1;
    String str2;
    String str3;
    String str4;
    if (this.h != null)
    {
      if (this.j.isFakeFeedItem()) {
        return;
      }
      localObject2 = this.h.a(this.g.mVid);
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QQStoryAutoPlayView reportAutoPlayStory but getVideo is null, vid=");
        ((StringBuilder)localObject1).append(this.g.mVid);
        SLog.e("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject1).toString());
        return;
      }
      if ((!TextUtils.isEmpty(((StoryVideoItem)localObject2).mVideoUrl)) && (((StoryVideoItem)localObject2).mVideoDuration >= 0L))
      {
        localObject1 = localObject2;
        if (((StoryVideoItem)localObject2).mSourceType != -1) {}
      }
      else
      {
        localObject1 = ((StoryManager)SuperManager.a(5)).c(this.g.mVid);
      }
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QQStoryAutoPlayView reportAutoPlayStory but queryVideoFromDb is null, vid=");
        ((StringBuilder)localObject1).append(this.g.mVid);
        SLog.e("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject1).toString());
        return;
      }
      if (((StoryVideoItem)localObject1).mIsPicture == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      str2 = String.valueOf(StoryReportor.a(this.j));
      str3 = String.valueOf(((StoryVideoItem)localObject1).mVideoDuration);
      str4 = String.valueOf(this.m);
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("vid", ((StoryVideoItem)localObject1).mVid);
      localJSONObject.put("feedid", this.j.feedId);
      localJSONObject.put("author_id", this.g.mOwnerUid);
      if (!this.j.isReportedAutoPlay) {
        break label638;
      }
      localObject2 = "2";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        continue;
        String str1 = "1";
      }
    }
    localJSONObject.put("type", localObject2);
    localJSONObject.put("info_error", ((StoryVideoItem)localObject1).mErrorCode);
    localJSONObject.put("video_origin", ((StoryVideoItem)localObject1).mSourceType);
    localJSONObject.put("mobile_type", Build.MODEL);
    localJSONObject.put("wifi_ssid", NetworkUtils.d(getContext()));
    localJSONObject.put("wifi_mac", NetworkUtils.c(getContext()));
    Object localObject2 = localJSONObject.toString();
    break label369;
    localObject2 = "";
    label369:
    StoryReportor.a("play_video", "auto_play", this.h.a(), i1, new String[] { str2, str3, str4, localObject2 });
    StoryReportor.b("auto_play", "auto_play_720", this.h.a(), i1, new String[] { str2, str3, str4, localObject2 });
    StoryReportor.b("auto_play", "auto_play_scenes", this.h.a(), this.h.c(), new String[] { String.valueOf(this.m), ((StoryVideoItem)localObject1).mVid });
    this.j.isReportedAutoPlay = true;
    InfoPrinter.c("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory ", Integer.valueOf(this.h.c()), ",url= ", ((StoryVideoItem)localObject1).getThumbUrl() });
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory:", Integer.valueOf(this.h.a()), "|", Integer.valueOf(i1), "|", str2, "|", str3, "|", str4, "|", localObject2 });
  }
  
  public QQStoryAutoPlayView a(AutoPlayManager paramAutoPlayManager)
  {
    this.h = paramAutoPlayManager;
    return this;
  }
  
  public void a()
  {
    this.f.e();
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--", Integer.valueOf(hashCode()), "-- release completed:", Boolean.valueOf(this.f.a), "---", Integer.valueOf(this.f.getAutoPlayState()), "---coverUrl=", this.g.getThumbUrl() });
    h();
  }
  
  public void a(File paramFile1, File paramFile2)
  {
    int i1 = hashCode();
    int i2 = this.f.getAutoPlayState();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---coverUrl=");
    ((StringBuilder)localObject).append(this.g.getThumbUrl());
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view-", Integer.valueOf(i1), "- startPlay ---", Integer.valueOf(i2), ((StringBuilder)localObject).toString() });
    if (this.f.f()) {
      l();
    }
    if (TextUtils.isEmpty(this.f.getCoverUrl())) {
      localObject = this.g.getThumbUrl();
    } else {
      localObject = this.f.getCoverUrl();
    }
    StoryVideoItem localStoryVideoItem = this.h.a(this.g.mVid);
    if (localStoryVideoItem == null)
    {
      paramFile1 = new StringBuilder();
      paramFile1.append("QQStoryAutoPlayView startPlay but getVideo is null, vid=");
      paramFile1.append(this.g.mVid);
      SLog.e("Q.qqstory.home.QQStoryAutoPlayView", paramFile1.toString());
      return;
    }
    SLog.a("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView startPlay w= %s ,h= %s , coverUrl=%s", Integer.valueOf(localStoryVideoItem.mVideoWidth), Integer.valueOf(localStoryVideoItem.mVideoHeight), localObject);
    this.f.a((String)localObject, localStoryVideoItem.mVideoWidth, localStoryVideoItem.mVideoHeight, this.g.uniqueKey(), paramFile1.getAbsolutePath());
    if ((paramFile2 != null) && (paramFile2.exists())) {
      try
      {
        paramFile1 = URLDrawable.URLDrawableOptions.obtain();
        paramFile1.mUseAutoScaleParams = false;
        paramFile1.mLoadingDrawable = new EmptyDrawable(0, localStoryVideoItem.mVideoWidth, localStoryVideoItem.mVideoHeight);
        paramFile1.mMemoryCacheKeySuffix = "qqstory_mask";
        paramFile1.mRequestHeight = getHeight();
        paramFile1.mRequestWidth = (localStoryVideoItem.mVideoWidth * getHeight() / localStoryVideoItem.mVideoHeight);
        paramFile1 = URLDrawable.getDrawable(paramFile2, paramFile1);
        if ((paramFile1.getStatus() == 2) || (paramFile1.getStatus() == 3))
        {
          InfoPrinter.c("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "drawable restartDownload" });
          paramFile1.restartDownload();
        }
        this.d.setVisibility(0);
        this.d.setImageDrawable(paramFile1);
      }
      catch (Exception paramFile1)
      {
        paramFile2 = new StringBuilder();
        paramFile2.append("get maskFile error:");
        paramFile2.append(paramFile1);
        SLog.e("Q.qqstory.home.QQStoryAutoPlayView", paramFile2.toString());
      }
    }
    e();
  }
  
  public void a(List<StoryHomeFeed> paramList)
  {
    if (this.h != null)
    {
      SLog.b("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView requestPlay");
      this.h.a(this, paramList);
    }
  }
  
  public void b()
  {
    int i1 = super.hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-- pausePlay ---");
    localStringBuilder.append(this.f.getAutoPlayState());
    localStringBuilder.append("---coverUrl=");
    localStringBuilder.append(this.g.getThumbUrl());
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view=", Integer.valueOf(i1), localStringBuilder.toString() });
    this.f.c();
    f();
  }
  
  public void c()
  {
    int i1 = super.hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-- resumePlay ---");
    localStringBuilder.append(this.f.getAutoPlayState());
    localStringBuilder.append("---coverUrl=");
    localStringBuilder.append(this.g.getThumbUrl());
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view=", Integer.valueOf(i1), localStringBuilder.toString() });
    this.f.d();
    g();
  }
  
  public boolean d()
  {
    return this.f.a();
  }
  
  public void e()
  {
    this.l = System.currentTimeMillis();
    this.m = 0L;
    this.n = this.l;
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordStartTime---view=", Integer.valueOf(super.hashCode()), "--mStartPlayTime=", Long.valueOf(this.l), ",mHaveBeenPlayedTime=", Long.valueOf(this.m) });
  }
  
  public void f()
  {
    if (this.l > 0L) {
      this.m = (System.currentTimeMillis() - this.l + this.m);
    }
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordPauseTime--view=", Integer.valueOf(super.hashCode()), "---mStartPlayTime=", Long.valueOf(this.l), ",mHaveBeenPlayedTime=", Long.valueOf(this.m) });
    this.l = -1L;
  }
  
  public void g()
  {
    if (this.l == -1L) {
      this.l = System.currentTimeMillis();
    }
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordResumeTime--view=", Integer.valueOf(super.hashCode()), "---mStartPlayTime=", Long.valueOf(this.l), ",mHaveBeenPlayedTime=", Long.valueOf(this.m) });
  }
  
  public int getAutoPlayState()
  {
    return this.f.getAutoPlayState();
  }
  
  public VideoListFeedItem getFeedItem()
  {
    return this.j;
  }
  
  public int getIndexAtVideoList()
  {
    return this.a;
  }
  
  public StoryUploadProgressView getProgressView()
  {
    return this.c;
  }
  
  public AutoPlayImageView getSrcImageView()
  {
    return this.f;
  }
  
  public StoryVideoItem getStoryVideoItem()
  {
    return this.g;
  }
  
  public void h()
  {
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordReleaseTime---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime=", Long.valueOf(this.l), ",mHaveBeenPlayedTime=", Long.valueOf(this.m) });
    if ((this.l == -1L) && (this.m > 0L)) {
      n();
    }
    this.m = 0L;
  }
  
  public void i()
  {
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayWhenPageSwitch---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime=", Long.valueOf(this.l), ",mHaveBeenPlayedTime=", Long.valueOf(this.m) });
    if (this.m > 0L)
    {
      n();
      this.f.e();
    }
    this.l = -1L;
    this.m = 0L;
    this.o = 0L;
    this.n = -1L;
  }
  
  public void j()
  {
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordReleaseTimeForDev---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime_dev=", Long.valueOf(this.n), ",mHaveBeenPlayedTime_dev=", Long.valueOf(this.o) });
    if ((this.l == -1L) && (this.m > 0L))
    {
      this.o = 0L;
      this.n = -1L;
    }
    else if (this.o > 0L)
    {
      m();
      this.o = 0L;
      this.n = -1L;
    }
    if (this.n > 0L) {
      this.o = (System.currentTimeMillis() - this.l + this.m);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.k != null)
    {
      String str = paramView.getContext().getClass().getSimpleName();
      if (StoryVideoItem.isFakeVid(this.g.mVid))
      {
        SLog.a("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has video info of fake vid = %s, current activity = %s", this.g.mVid, str);
        StoryReportor.b("play_video", "home_video_info_state", 0, 1, new String[] { str });
      }
      else
      {
        StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.g.mVid);
        if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())))
        {
          SLog.a("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has video info of vid = %s, current activity = %s", this.g.mVid, str);
          StoryReportor.b("play_video", "home_video_info_state", 0, 2, new String[] { str });
        }
        else
        {
          SLog.d("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has *no* video info of vid = %s, current activity = %s", new Object[] { this.g.mVid, str });
          StoryReportor.b("play_video", "home_video_info_state", 0, 3, new String[] { str });
        }
      }
      this.k.a(this, this.j, this.g, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.k;
    if (paramView != null) {
      paramView.b(this, this.j, this.g, this.a);
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    StoryDepends.QQStoryAutoPlayView.a(this, paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCoverUrl(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCoverUrl:");
    localStringBuilder.append(this.g.getThumbUrl());
    SLog.b("Q.qqstory.home.QQStoryAutoPlayView", localStringBuilder.toString());
    this.f.setCoverUrl(paramString, paramInt1, paramInt2);
  }
  
  public void setImageDrawable(Drawable paramDrawable, String paramString)
  {
    if ((!this.b) && (this.f.b()))
    {
      SLog.d("Q.qqstory.home.QQStoryAutoPlayView", "setImageDrawable but data have no change. so ignore this called.");
      return;
    }
    this.f.e();
    this.f.setImageDrawable(paramDrawable);
    this.f.setCoverDrawable(paramDrawable);
    this.d.setVisibility(8);
    this.d.setImageDrawable(null);
    if ("QQStory_feed_min".equals(paramString)) {
      j();
    }
    h();
  }
  
  public void setItemData(VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    String str;
    if (paramStoryVideoItem == null) {
      str = "";
    } else {
      str = paramStoryVideoItem.getThumbUrl();
    }
    SLog.a("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView setItemData mPosition=%s url=%s", Integer.valueOf(paramInt), str);
    if ((paramStoryVideoItem != null) && (paramStoryVideoItem.equals(this.g))) {
      this.b = false;
    } else {
      this.b = true;
    }
    if (paramStoryVideoItem != null) {
      this.e.a(paramStoryVideoItem);
    }
    this.j = paramVideoListFeedItem;
    this.g = paramStoryVideoItem;
    this.a = paramInt;
  }
  
  public void setStoryCoverClickListener(QQStoryAutoPlayView.StoryCoverClickListener paramStoryCoverClickListener)
  {
    this.k = paramStoryCoverClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView
 * JD-Core Version:    0.7.0.1
 */