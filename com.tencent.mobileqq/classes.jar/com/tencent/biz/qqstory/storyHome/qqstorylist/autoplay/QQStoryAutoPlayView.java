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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  private WatchVideoHandler jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler;
  private VideoListFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
  private AutoPlayImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView;
  private AutoPlayManager jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager;
  private QQStoryAutoPlayView.StoryCoverClickListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener;
  private StoryUploadProgressView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryUploadProgressView;
  private PollContainerLayout jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout;
  private boolean jdField_a_of_type_Boolean = false;
  private long b = 0L;
  private long c = -1L;
  private long d = 0L;
  
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
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView = new AutoPlayImageView(getContext());
    MessageProgressView localMessageProgressView = new MessageProgressView(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryUploadProgressView = new StoryUploadProgressView(localMessageProgressView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryUploadProgressView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler = new WatchVideoHandler();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    super.addView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    super.addView(localMessageProgressView, new FrameLayout.LayoutParams(-1, -1));
    super.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryUploadProgressView.a(4);
  }
  
  private void k()
  {
    if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQStoryAutoPlayView---- reportWatchVideo ------coverUrl=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl());
    SLog.b("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject).toString());
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      SLog.e("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject).toString());
      localObject = "";
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler.a(localStoryVideoItem.mVid, (String)localObject, 79, false, localStoryVideoItem.mCreateTime);
  }
  
  private void l()
  {
    StoryVideoItem localStoryVideoItem;
    int i;
    int j;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isFakeFeedItem()) {
        return;
      }
      localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      if (localStoryVideoItem == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QQStoryAutoPlayView reportAutoPlayStory but getVideo is null, vid=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
        SLog.e("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject).toString());
        return;
      }
      if (localStoryVideoItem.mIsPicture == 1) {
        i = 1;
      } else {
        i = 0;
      }
      j = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      l1 = localStoryVideoItem.mVideoDuration;
      l2 = this.b;
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("vid", localStoryVideoItem.mVid);
      localJSONObject.put("feedid", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId);
      localJSONObject.put("author_id", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.ownerId);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isReportedAutoPlay) {
        break label288;
      }
      localObject = "2";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        label211:
        continue;
        String str = "1";
      }
    }
    localJSONObject.put("type", localObject);
    Object localObject = localJSONObject.toString();
    break label211;
    localObject = "";
    StoryReportor.b("auto_play", "auto_play_720", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(), i, new String[] { String.valueOf(j), String.valueOf(l1), String.valueOf(l2), localObject });
    InfoPrinter.c("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory dev url= ", localStoryVideoItem.getThumbUrl() });
  }
  
  private void m()
  {
    Object localObject1;
    int i;
    String str2;
    String str3;
    String str4;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isFakeFeedItem()) {
        return;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QQStoryAutoPlayView reportAutoPlayStory but getVideo is null, vid=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
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
        localObject1 = ((StoryManager)SuperManager.a(5)).c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      }
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QQStoryAutoPlayView reportAutoPlayStory but queryVideoFromDb is null, vid=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
        SLog.e("Q.qqstory.home.QQStoryAutoPlayView", ((StringBuilder)localObject1).toString());
        return;
      }
      if (((StoryVideoItem)localObject1).mIsPicture == 1) {
        i = 1;
      } else {
        i = 0;
      }
      str2 = String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem));
      str3 = String.valueOf(((StoryVideoItem)localObject1).mVideoDuration);
      str4 = String.valueOf(this.b);
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("vid", ((StoryVideoItem)localObject1).mVid);
      localJSONObject.put("feedid", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId);
      localJSONObject.put("author_id", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isReportedAutoPlay) {
        break label637;
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
    localJSONObject.put("wifi_ssid", NetworkUtils.b(getContext()));
    localJSONObject.put("wifi_mac", NetworkUtils.a(getContext()));
    Object localObject2 = localJSONObject.toString();
    break label368;
    localObject2 = "";
    label368:
    StoryReportor.a("play_video", "auto_play", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(), i, new String[] { str2, str3, str4, localObject2 });
    StoryReportor.b("auto_play", "auto_play_720", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(), i, new String[] { str2, str3, str4, localObject2 });
    StoryReportor.b("auto_play", "auto_play_scenes", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.b(), new String[] { String.valueOf(this.b), ((StoryVideoItem)localObject1).mVid });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.isReportedAutoPlay = true;
    InfoPrinter.c("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory ", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.b()), ",url= ", ((StoryVideoItem)localObject1).getThumbUrl() });
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory:", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a()), "|", Integer.valueOf(i), "|", str2, "|", str3, "|", str4, "|", localObject2 });
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
  
  public QQStoryAutoPlayView a(AutoPlayManager paramAutoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager = paramAutoPlayManager;
    return this;
  }
  
  public StoryUploadProgressView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryUploadProgressView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.c();
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--", Integer.valueOf(hashCode()), "-- release completed:", Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.jdField_a_of_type_Boolean), "---", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a()), "---coverUrl=", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl() });
    g();
  }
  
  public void a(File paramFile1, File paramFile2)
  {
    int i = hashCode();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---coverUrl=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl());
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view-", Integer.valueOf(i), "- startPlay ---", Integer.valueOf(j), ((StringBuilder)localObject).toString() });
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.c()) {
      k();
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a())) {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl();
    } else {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a();
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    if (localStoryVideoItem == null)
    {
      paramFile1 = new StringBuilder();
      paramFile1.append("QQStoryAutoPlayView startPlay but getVideo is null, vid=");
      paramFile1.append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      SLog.e("Q.qqstory.home.QQStoryAutoPlayView", paramFile1.toString());
      return;
    }
    SLog.a("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView startPlay w= %s ,h= %s , coverUrl=%s", Integer.valueOf(localStoryVideoItem.mVideoWidth), Integer.valueOf(localStoryVideoItem.mVideoHeight), localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a((String)localObject, localStoryVideoItem.mVideoWidth, localStoryVideoItem.mVideoHeight, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.uniqueKey(), paramFile1.getAbsolutePath());
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
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramFile1);
      }
      catch (Exception paramFile1)
      {
        paramFile2 = new StringBuilder();
        paramFile2.append("get maskFile error:");
        paramFile2.append(paramFile1);
        SLog.e("Q.qqstory.home.QQStoryAutoPlayView", paramFile2.toString());
      }
    }
    d();
  }
  
  public void a(List<StoryHomeFeed> paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager != null)
    {
      SLog.b("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView requestPlay");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager.a(this, paramList);
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
    int i = super.hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-- pausePlay ---");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a());
    localStringBuilder.append("---coverUrl=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl());
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view=", Integer.valueOf(i), localStringBuilder.toString() });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a();
    e();
  }
  
  public void c()
  {
    int i = super.hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-- resumePlay ---");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a());
    localStringBuilder.append("---coverUrl=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl());
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view=", Integer.valueOf(i), localStringBuilder.toString() });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.b();
    f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.b = 0L;
    this.c = this.jdField_a_of_type_Long;
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordStartTime---view=", Integer.valueOf(super.hashCode()), "--mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.b = (System.currentTimeMillis() - this.jdField_a_of_type_Long + this.b);
    }
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordPauseTime--view=", Integer.valueOf(super.hashCode()), "---mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordResumeTime--view=", Integer.valueOf(super.hashCode()), "---mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
  }
  
  public void g()
  {
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordReleaseTime---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
    if ((this.jdField_a_of_type_Long == -1L) && (this.b > 0L)) {
      m();
    }
    this.b = 0L;
  }
  
  public void h()
  {
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayWhenPageSwitch---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime=", Long.valueOf(this.jdField_a_of_type_Long), ",mHaveBeenPlayedTime=", Long.valueOf(this.b) });
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
    InfoPrinter.b("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordReleaseTimeForDev---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime_dev=", Long.valueOf(this.c), ",mHaveBeenPlayedTime_dev=", Long.valueOf(this.d) });
    if ((this.jdField_a_of_type_Long == -1L) && (this.b > 0L))
    {
      this.d = 0L;
      this.c = -1L;
    }
    else if (this.d > 0L)
    {
      l();
      this.d = 0L;
      this.c = -1L;
    }
    if (this.c > 0L) {
      this.d = (System.currentTimeMillis() - this.jdField_a_of_type_Long + this.b);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener != null)
    {
      String str = paramView.getContext().getClass().getSimpleName();
      if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
      {
        SLog.a("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has video info of fake vid = %s, current activity = %s", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, str);
        StoryReportor.b("play_video", "home_video_info_state", 0, 1, new String[] { str });
      }
      else
      {
        StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
        if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())))
        {
          SLog.a("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has video info of vid = %s, current activity = %s", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, str);
          StoryReportor.b("play_video", "home_video_info_state", 0, 2, new String[] { str });
        }
        else
        {
          SLog.d("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has *no* video info of vid = %s, current activity = %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, str });
          StoryReportor.b("play_video", "home_video_info_state", 0, 3, new String[] { str });
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener.a(this, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener;
    if (paramView != null) {
      paramView.b(this, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_Int);
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
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getThumbUrl());
    SLog.b("Q.qqstory.home.QQStoryAutoPlayView", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setCoverUrl(paramString, paramInt1, paramInt2);
  }
  
  public void setImageDrawable(Drawable paramDrawable, String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.b()))
    {
      SLog.d("Q.qqstory.home.QQStoryAutoPlayView", "setImageDrawable but data have no change. so ignore this called.");
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
    if (paramStoryVideoItem == null) {
      str = "";
    } else {
      str = paramStoryVideoItem.getThumbUrl();
    }
    SLog.a("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView setItemData mPosition=%s url=%s", Integer.valueOf(paramInt), str);
    if ((paramStoryVideoItem != null) && (paramStoryVideoItem.equals(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem))) {
      this.jdField_a_of_type_Boolean = false;
    } else {
      this.jdField_a_of_type_Boolean = true;
    }
    if (paramStoryVideoItem != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.a(paramStoryVideoItem);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = paramVideoListFeedItem;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setStoryCoverClickListener(QQStoryAutoPlayView.StoryCoverClickListener paramStoryCoverClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener = paramStoryCoverClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView
 * JD-Core Version:    0.7.0.1
 */