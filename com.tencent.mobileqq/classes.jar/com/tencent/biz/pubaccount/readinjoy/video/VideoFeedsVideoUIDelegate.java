package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VideoFeedsVideoUIDelegate
  implements SeekBar.OnSeekBarChangeListener, IVideoUIDelegate
{
  private long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsVideoUIDelegate.CallBack jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate$CallBack = null;
  BaseVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  
  public VideoFeedsVideoUIDelegate(BaseVideoItemHolder paramBaseVideoItemHolder, VideoFeedsPlayManager paramVideoFeedsPlayManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder = paramBaseVideoItemHolder;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.a.setOnSeekBarChangeListener(this);
    this.b = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new VideoFeedsVideoUIDelegate.1(this, Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView == null) {
      return;
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView, paramInt1, paramInt2);
  }
  
  public static void a(TextView paramTextView, VideoInfo paramVideoInfo, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    VideoFeedsHelper.a(paramTextView, paramVideoPlayerWrapper, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.d, paramVideoInfo.jdField_a_of_type_Int, null);
  }
  
  private boolean a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (!NetworkUtil.b(BaseApplicationImpl.getContext())) {}
    while ((paramVideoPlayParam == null) || (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!this.jdField_a_of_type_Boolean) || (this.g)) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    ShortVideoItemHolder localShortVideoItemHolder = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder instanceof ShortVideoItemHolder)) {
      localShortVideoItemHolder = (ShortVideoItemHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder;
    }
    if ((localShortVideoItemHolder != null) && (localShortVideoItemHolder.c != null) && ((localShortVideoItemHolder.c.getDrawable() instanceof ReadInJoyLottieDrawable))) {
      ((ReadInJoyLottieDrawable)localShortVideoItemHolder.c.getDrawable()).playAnimation();
    }
  }
  
  private void b(int paramInt)
  {
    a(paramInt, 500);
  }
  
  private void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsVideoUIDelegate", 2, "innerChangePlayButton() what = " + paramInt);
    }
    this.c = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.setVisibility(0);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.getContext(), 2130843457));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.clearAnimation();
      paramString = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramString.setDuration(500L);
      paramString.setRepeatCount(-1);
      paramString.setRepeatMode(1);
      paramString.setStartTime(-1L);
      paramString.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.startAnimation(paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.clearAnimation();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.getContext(), 2130843459));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.clearAnimation();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.getContext(), 2130843459));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.clearAnimation();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.getContext(), 2130843459));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.clearAnimation();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.getContext(), 2130843458));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.clearAnimation();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.setBackgroundDrawable(VideoFeedsResourceLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.getContext(), 2130843458));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.r.getVisibility() != 0) || (!NetworkUtil.b(BaseApplicationImpl.getContext())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.g.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.r.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.t.setVisibility(8);
  }
  
  private void j(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (a(paramVideoPlayParam)) {
      a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    a(4);
    if (paramVideoPlayParam.jdField_a_of_type_AndroidViewView != null) {
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    int i = 100;
    int j;
    if (this.e)
    {
      long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
      j = (int)((float)l1 * 100.0F / (float)l2 + 0.5D);
      if (j + 1 < 100) {
        break label75;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.a.setProgress(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.b.setProgress(i);
      return;
      label75:
      i = j + 1;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c = false;
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.7(this, paramInt, paramString));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    String str;
    if (this.b) {
      str = HardCodeUtil.a(2131716073);
    }
    for (;;)
    {
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.s;
      paramVideoInfo.setText(str);
      VideoFeedsHelper.a(paramVideoInfo, 0);
      this.g = true;
      this.jdField_a_of_type_AndroidOsHandler.postAtTime(new VideoFeedsVideoUIDelegate.8(this, paramVideoInfo), Integer.valueOf(0), SystemClock.uptimeMillis() + 1000L);
      return;
      str = HardCodeUtil.a(2131715969) + VideoFeedsHelper.b(paramVideoInfo.b);
      if (paramVideoInfo.b <= 0L) {
        str = HardCodeUtil.a(2131716076);
      }
    }
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(0);
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = HardCodeUtil.a(2131716044);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.2(this, str, paramVideoPlayParam));
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt <= 300) {
        break label113;
      }
      paramInt -= 300;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidViewView.setVisibility(0);
      paramVideoPlayParam = new AlphaAnimation(0.0F, 1.0F);
      paramVideoPlayParam.setDuration(300L);
      paramVideoPlayParam.setStartOffset(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidViewView.setAnimation(paramVideoPlayParam);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new VideoFeedsVideoUIDelegate.5(this));
      paramVideoPlayParam.setAnimationListener(new VideoFeedsVideoUIDelegate.6(this, localAlphaAnimation));
      paramVideoPlayParam.start();
      return;
      label113:
      paramInt = 0;
    }
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, long paramLong1, long paramLong2)
  {
    int i = 100;
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.q != null))
    {
      if (paramLong2 != 0L) {
        break label112;
      }
      if (this.e)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.a.setProgress(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.b.setProgress(0);
      }
    }
    label112:
    while (paramLong1 == 0L)
    {
      if (paramLong2 > 0L) {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.q, paramLong2);
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.p, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      if (this.e)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.a.setProgress(i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.b.setProgress(i);
      }
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView, paramLong1);
      break;
      i = j + 1;
    }
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-1);
    if ((!this.f) && (!paramVideoPlayParam.c)) {
      a(0, 0);
    }
    this.f = false;
    if (paramBoolean)
    {
      a(1);
      return;
    }
    this.c = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-1, 1200L);
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.f = true;
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.3(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsVideoUIDelegate.4(this));
  }
  
  public void a(VideoFeedsVideoUIDelegate.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate$CallBack = paramCallBack;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j(paramVideoPlayParam);
      a(8, 0);
      return;
    }
    a(paramVideoPlayParam, false);
  }
  
  public void c(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    j(paramVideoPlayParam);
  }
  
  public void d(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(0);
  }
  
  public void e(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    b(8);
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void f(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.f = false;
  }
  
  public void g(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(1);
  }
  
  public void h(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e()))
    {
      a(0);
      return;
    }
    if ((paramVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.d.getVisibility() == 0))
    {
      a(3);
      return;
    }
    a(4);
  }
  
  public void i(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(0, 0);
    a(0);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    long l;
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    } while (l <= 0L);
    double d1 = paramInt / 100.0D;
    paramInt = (int)(l * d1);
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView, paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = false;
    int i = paramSeekBar.getProgress();
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    if (l > 0L)
    {
      i = (int)(i / 100.0D * l);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(i);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate$CallBack != null) && (paramSeekBar == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsBaseVideoItemHolder.a)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsVideoUIDelegate$CallBack.i();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsVideoUIDelegate
 * JD-Core Version:    0.7.0.1
 */