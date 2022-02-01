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
import asbg;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
import wad;
import wek;
import wjp;
import wjs;
import wkk;
import wsg;
import ydz;
import yer;
import yeu;
import yew;
import yhj;
import ykq;
import ykv;
import zei;

public class QQStoryAutoPlayView
  extends FrameLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  private VideoListFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
  private AutoPlayImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView;
  private InteractContainerLayout jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout;
  private PollContainerLayout jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout;
  private wsg jdField_a_of_type_Wsg;
  private yer jdField_a_of_type_Yer;
  private yeu jdField_a_of_type_Yeu;
  private yhj jdField_a_of_type_Yhj;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  private long c = -1L;
  private long d;
  
  public QQStoryAutoPlayView(Context paramContext)
  {
    super(paramContext);
    j();
  }
  
  public QQStoryAutoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    j();
  }
  
  public QQStoryAutoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    j();
  }
  
  private void j()
  {
    super.setOnClickListener(this);
    super.setOnLongClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout = new PollContainerLayout(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout = new InteractContainerLayout(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView = new AutoPlayImageView(getContext());
    MessageProgressView localMessageProgressView = new MessageProgressView(getContext());
    this.jdField_a_of_type_Yhj = new yhj(localMessageProgressView);
    this.jdField_a_of_type_Yhj.a();
    this.jdField_a_of_type_Wsg = new wsg();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    super.addView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    super.addView(localMessageProgressView, new FrameLayout.LayoutParams(-1, -1));
    super.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_Yhj.a(4);
  }
  
  private void k()
  {
    if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid)) {}
    StoryVideoItem localStoryVideoItem;
    do
    {
      return;
      ykq.b("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView---- reportWatchVideo ------coverUrl=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl());
      localStoryVideoItem = this.jdField_a_of_type_Yer.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    } while (localStoryVideoItem == null);
    Object localObject;
    if (!TextUtils.isEmpty(localStoryVideoItem.shareGroupId))
    {
      localObject = localStoryVideoItem.shareGroupId;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new wkk((String)localObject, localStoryVideoItem);
        wad.a().dispatch((Dispatcher.Dispatchable)localObject);
      }
      localObject = "";
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
        break label150;
      }
      localObject = localStoryVideoItem.mOwnerUid;
    }
    for (;;)
    {
      this.jdField_a_of_type_Wsg.a(localStoryVideoItem.mVid, (String)localObject, 79, false, localStoryVideoItem.mCreateTime);
      return;
      localObject = localStoryVideoItem.mOwnerUid;
      break;
      label150:
      ykq.e("Q.qqstory.home.QQStoryAutoPlayView", "this story item info incomplete .vid=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_Yer == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isFakeFeedItem())) {
      return;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Yer.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    if (localStoryVideoItem == null)
    {
      ykq.e("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView reportAutoPlayStory but getVideo is null, vid=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      return;
    }
    int i;
    int j;
    long l1;
    long l2;
    if (localStoryVideoItem.mIsPicture == 1)
    {
      i = 1;
      j = ykv.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      l1 = localStoryVideoItem.mVideoDuration;
      l2 = this.b;
      str3 = "";
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("vid", localStoryVideoItem.mVid);
        localJSONObject.put("feedid", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId);
        localJSONObject.put("author_id", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.ownerId);
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isReportedAutoPlay) {
          continue;
        }
        str1 = "2";
        localJSONObject.put("type", str1);
        str1 = localJSONObject.toString();
      }
      catch (Exception localException)
      {
        String str1;
        String str2 = str3;
        continue;
      }
      ykv.b("auto_play", "auto_play_720", this.jdField_a_of_type_Yer.a(), i, new String[] { String.valueOf(j), String.valueOf(l1), String.valueOf(l2), str1 });
      yew.c("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory dev url= ", localStoryVideoItem.getThumbUrl() });
      return;
      i = 0;
      break;
      str1 = "1";
    }
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_Yer == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isFakeFeedItem())) {
      return;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Yer.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    if (localStoryVideoItem == null)
    {
      ykq.e("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView reportAutoPlayStory but getVideo is null, vid=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      return;
    }
    if ((TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) || (localStoryVideoItem.mVideoDuration < 0L) || (localStoryVideoItem.mSourceType == -1)) {
      localStoryVideoItem = ((wjp)wjs.a(5)).c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    }
    String str3;
    for (;;)
    {
      if (localStoryVideoItem == null)
      {
        ykq.e("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView reportAutoPlayStory but queryVideoFromDb is null, vid=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
        return;
      }
      int i;
      String str4;
      String str5;
      String str6;
      if (localStoryVideoItem.mIsPicture == 1)
      {
        i = 1;
        str4 = String.valueOf(ykv.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
        str5 = String.valueOf(localStoryVideoItem.mVideoDuration);
        str6 = String.valueOf(this.b);
        str3 = "";
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("vid", localStoryVideoItem.mVid);
          localJSONObject.put("feedid", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId);
          localJSONObject.put("author_id", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid);
          if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isReportedAutoPlay) {
            continue;
          }
          str1 = "2";
          localJSONObject.put("type", str1);
          localJSONObject.put("info_error", localStoryVideoItem.mErrorCode);
          localJSONObject.put("video_origin", localStoryVideoItem.mSourceType);
          localJSONObject.put("mobile_type", Build.MODEL);
          localJSONObject.put("wifi_ssid", zei.b(getContext()));
          localJSONObject.put("wifi_mac", zei.a(getContext()));
          str1 = localJSONObject.toString();
        }
        catch (Exception localException)
        {
          String str1;
          String str2 = str3;
          continue;
        }
        ykv.a("play_video", "auto_play", this.jdField_a_of_type_Yer.a(), i, new String[] { str4, str5, str6, str1 });
        ykv.b("auto_play", "auto_play_720", this.jdField_a_of_type_Yer.a(), i, new String[] { str4, str5, str6, str1 });
        ykv.b("auto_play", "auto_play_scenes", this.jdField_a_of_type_Yer.a(), this.jdField_a_of_type_Yer.b(), new String[] { String.valueOf(this.b), localStoryVideoItem.mVid });
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isReportedAutoPlay = true;
        yew.c("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory ", Integer.valueOf(this.jdField_a_of_type_Yer.b()), ",url= ", localStoryVideoItem.getThumbUrl() });
        yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory:", Integer.valueOf(this.jdField_a_of_type_Yer.a()), "|", Integer.valueOf(i), "|", str4, "|", str5, "|", str6, "|", str1 });
        return;
        i = 0;
        break;
        str1 = "1";
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public StoryVideoItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  }
  
  public AutoPlayImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView;
  }
  
  public QQStoryAutoPlayView a(yer paramyer)
  {
    this.jdField_a_of_type_Yer = paramyer;
    return this;
  }
  
  public yhj a()
  {
    return this.jdField_a_of_type_Yhj;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.c();
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--", Integer.valueOf(hashCode()), "-- release completed:", Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.jdField_a_of_type_Boolean), "---", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a()), "---coverUrl=", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl() });
    g();
  }
  
  public void a(File paramFile1, File paramFile2)
  {
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view-", Integer.valueOf(hashCode()), "- startPlay ---", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a()), "---coverUrl=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl() });
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.c()) {
      k();
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a())) {}
    StoryVideoItem localStoryVideoItem;
    for (String str = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl();; str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a())
    {
      localStoryVideoItem = this.jdField_a_of_type_Yer.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      if (localStoryVideoItem != null) {
        break;
      }
      ykq.e("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView startPlay but getVideo is null, vid=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      return;
    }
    ykq.a("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView startPlay w= %s ,h= %s , coverUrl=%s", Integer.valueOf(localStoryVideoItem.mVideoWidth), Integer.valueOf(localStoryVideoItem.mVideoHeight), str);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a(str, localStoryVideoItem.mVideoWidth, localStoryVideoItem.mVideoHeight, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.uniqueKey(), paramFile1.getAbsolutePath());
    if ((paramFile2 != null) && (paramFile2.exists())) {}
    try
    {
      paramFile1 = URLDrawable.URLDrawableOptions.obtain();
      paramFile1.mUseAutoScaleParams = false;
      paramFile1.mLoadingDrawable = new asbg(0, localStoryVideoItem.mVideoWidth, localStoryVideoItem.mVideoHeight);
      paramFile1.mMemoryCacheKeySuffix = "qqstory_mask";
      paramFile1.mRequestHeight = getHeight();
      paramFile1.mRequestWidth = (localStoryVideoItem.mVideoWidth * getHeight() / localStoryVideoItem.mVideoHeight);
      paramFile1 = URLDrawable.getDrawable(paramFile2, paramFile1);
      if ((paramFile1.getStatus() == 2) || (paramFile1.getStatus() == 3))
      {
        yew.c("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "drawable restartDownload" });
        paramFile1.restartDownload();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramFile1);
    }
    catch (Exception paramFile1)
    {
      for (;;)
      {
        ykq.e("Q.qqstory.home.QQStoryAutoPlayView", "get maskFile error:" + paramFile1);
      }
    }
    d();
  }
  
  public void a(List<ydz> paramList)
  {
    if (this.jdField_a_of_type_Yer != null)
    {
      ykq.b("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView requestPlay");
      this.jdField_a_of_type_Yer.a(this, paramList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a();
  }
  
  public void b()
  {
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view=", Integer.valueOf(super.hashCode()), "-- pausePlay ---" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a() + "---coverUrl=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl() });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a();
    e();
  }
  
  public void c()
  {
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view=", Integer.valueOf(super.hashCode()), "-- resumePlay ---" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a() + "---coverUrl=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl() });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.b();
    f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.b = 0L;
    this.c = this.jdField_a_of_type_Long;
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordStartTime---view=", Integer.valueOf(super.hashCode()), "--mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.b = (System.currentTimeMillis() - this.jdField_a_of_type_Long + this.b);
    }
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordPauseTime--view=", Integer.valueOf(super.hashCode()), "---mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordResumeTime--view=", Integer.valueOf(super.hashCode()), "---mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
  }
  
  public void g()
  {
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordReleaseTime---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
    if ((this.jdField_a_of_type_Long == -1L) && (this.b > 0L)) {
      m();
    }
    this.b = 0L;
  }
  
  public void h()
  {
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayWhenPageSwitch---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
    if (this.b > 0L)
    {
      m();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.c();
    }
    this.jdField_a_of_type_Long = -1L;
    this.b = 0L;
    this.d = 0L;
    this.c = -1L;
  }
  
  public void i()
  {
    yew.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordReleaseTimeForDev---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime_dev=", Long.valueOf(this.c), ",mHaveBeenPlayedTime_dev=", Long.valueOf(this.d) });
    if ((this.jdField_a_of_type_Long == -1L) && (this.b > 0L))
    {
      this.d = 0L;
      this.c = -1L;
    }
    for (;;)
    {
      if (this.c > 0L) {
        this.d = (System.currentTimeMillis() - this.jdField_a_of_type_Long + this.b);
      }
      return;
      if (this.d > 0L)
      {
        l();
        this.d = 0L;
        this.c = -1L;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    String str;
    if (this.jdField_a_of_type_Yeu != null)
    {
      str = paramView.getContext().getClass().getSimpleName();
      if (!StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid)) {
        break label96;
      }
      ykq.a("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has video info of fake vid = %s, current activity = %s", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, str);
      ykv.b("play_video", "home_video_info_state", 0, 1, new String[] { str });
    }
    for (;;)
    {
      this.jdField_a_of_type_Yeu.a(this, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label96:
      StoryVideoItem localStoryVideoItem = ((wjp)wjs.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())))
      {
        ykq.a("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has video info of vid = %s, current activity = %s", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, str);
        ykv.b("play_video", "home_video_info_state", 0, 2, new String[] { str });
      }
      else
      {
        ykq.d("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has *no* video info of vid = %s, current activity = %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, str });
        ykv.b("play_video", "home_video_info_state", 0, 3, new String[] { str });
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Yeu != null) {
      this.jdField_a_of_type_Yeu.b(this, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_Int);
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    wek.a(this, paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCoverUrl(String paramString, int paramInt1, int paramInt2)
  {
    ykq.b("Q.qqstory.home.QQStoryAutoPlayView", "setCoverUrl:" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setCoverUrl(paramString, paramInt1, paramInt2);
  }
  
  public void setImageDrawable(Drawable paramDrawable, String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.b()))
    {
      ykq.d("Q.qqstory.home.QQStoryAutoPlayView", "setImageDrawable but data have no change. so ignore this called.");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setCoverDrawable(paramDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    if ("QQStory_feed_min".equals(paramString)) {
      i();
    }
    g();
  }
  
  public void setItemData(VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    String str;
    if (paramStoryVideoItem == null)
    {
      str = "";
      ykq.a("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView setItemData mPosition=%s url=%s", Integer.valueOf(paramInt), str);
      if ((paramStoryVideoItem != null) && (paramStoryVideoItem.equals(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem))) {
        break label87;
      }
    }
    label87:
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (paramStoryVideoItem != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.a(paramStoryVideoItem);
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout.a(paramStoryVideoItem);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = paramVideoListFeedItem;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
      this.jdField_a_of_type_Int = paramInt;
      return;
      str = paramStoryVideoItem.getThumbUrl();
      break;
    }
  }
  
  public void setStoryCoverClickListener(yeu paramyeu)
  {
    this.jdField_a_of_type_Yeu = paramyeu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView
 * JD-Core Version:    0.7.0.1
 */