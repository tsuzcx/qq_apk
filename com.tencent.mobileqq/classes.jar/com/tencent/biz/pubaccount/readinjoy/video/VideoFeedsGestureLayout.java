package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsGestureLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private VideoBrightnessController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController;
  private VideoFeedsGestureLayout.CustomClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$CustomClickListener;
  private VideoFeedsGestureLayout.IVideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$IVideoPlayManager;
  private VideoFeedsGestureUIManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  private int f = -1;
  private int g;
  private int h;
  
  public VideoFeedsGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(float paramFloat)
  {
    long l2;
    long l1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() != null))
    {
      l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().jdField_b_of_type_Int * 1000;
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Int == 0) && (l2 != 0L)) {
        this.jdField_a_of_type_Float = ((float)l1 / (float)l2);
      }
      float f2 = this.jdField_a_of_type_Float + paramFloat;
      float f1;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      for (;;)
      {
        this.h = ((int)(f1 * (float)l2));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager.a(3, paramFloat, this.h, l2);
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
        {
          l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
          l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$IVideoPlayManager == null) {
          break label183;
        }
        l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$IVideoPlayManager.a();
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$IVideoPlayManager.b();
        break;
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = 0.0F;
        }
      }
      label183:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    ViewGroup localViewGroup;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      i = 0;
      label31:
      if (i < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView == null) || (!(localView instanceof ViewGroup))) {
          break label103;
        }
        localViewGroup = (ViewGroup)localView;
      }
    }
    label103:
    for (;;)
    {
      if ((localViewGroup instanceof TopGestureLayout))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localViewGroup);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
        return;
      }
      i += 1;
      break label31;
    }
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_Int == 3)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) {
        break label60;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c(this.h);
      if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.h / 1000);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager.a(0, 0.0F, 0L, 0L);
      return;
      label60:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.h, true);
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$IVideoPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$IVideoPlayManager.a(this.h);
      }
    }
  }
  
  private void b(float paramFloat)
  {
    int i = 255;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController == null) {
      return;
    }
    if (this.jdField_c_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController.a()) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (this.f != -1) {
        break label154;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label140;
      }
      this.e = 127;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFeedsItemFrameLayout", 2, "mBeginBrightness = " + this.e);
      }
    }
    int j = (int)(255.0F * paramFloat) + this.e;
    if (j > 255) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController.a(i / 255.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager.a(2, i / 255.0F, 0L, 0L);
      this.f = i;
      return;
      label140:
      this.e = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController.a();
      break;
      label154:
      this.e = this.f;
      break;
      if (j < 0) {
        i = 0;
      } else {
        i = j;
      }
    }
  }
  
  private void c(float paramFloat)
  {
    int j = 2;
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    }
    int k = (int)(this.g * paramFloat) + this.jdField_d_of_type_Int;
    int i;
    if (k > this.g)
    {
      i = this.g;
      if (this.jdField_a_of_type_Int != 2) {
        break label114;
      }
      label58:
      if (i != 0) {
        break label119;
      }
      VideoVolumeControl.a().a(true, "user_gesture", j);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, i, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager.a(1, i / this.g, 0L, 0L);
      return;
      i = k;
      if (k >= 0) {
        break;
      }
      i = 0;
      break;
      label114:
      j = 1;
      break label58;
      label119:
      VideoVolumeControl.a().a(false, "user_gesture", j);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager.a();
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$CustomClickListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$CustomClickListener.a(this, 1);
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager == null)
      {
        this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
        this.g = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
      }
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
      if (this.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$CustomClickListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$CustomClickListener.a(this, 2);
      break;
      c(paramFloat);
      continue;
      b(paramFloat);
      continue;
      a(paramFloat);
      continue;
      b();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_AndroidViewGestureDetector == null) {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new VideoFeedsGestureLayout.MyGestureListener(this));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    JSONObject localJSONObject;
    if ((paramMotionEvent.getAction() == 1) && (this.jdField_b_of_type_Int != 0)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channel_id", this.jdField_a_of_type_Long);
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        this.jdField_b_of_type_Int = 0;
        a(0, 0.0F);
        this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
        if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Int != 1)) {
          bool = true;
        }
        return bool;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X8008A42", "0X8008A42", 0, 0, "", "", "", VideoReporter.a(localJSONObject), false);
        continue;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X8008A43", "0X8008A43", 0, 0, "", "", "", VideoReporter.a(localJSONObject), false);
        continue;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X8008A41", "0X8008A41", 0, 0, "", "", "", VideoReporter.a(localJSONObject), false);
      }
    }
  }
  
  public void setChannelID(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setContext(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void setIsInFullScreen(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager = new VideoFeedsGestureUIManager();
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureUIManager.a(this.jdField_a_of_type_AndroidAppActivity, this);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_c_of_type_Boolean)
      {
        a(false);
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsItemFrameLayout", 2, "wgs error =" + localException.getMessage());
          }
        }
        a(true);
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController.a();
      this.f = -1;
    }
  }
  
  @Deprecated
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomClickListener(VideoFeedsGestureLayout.CustomClickListener paramCustomClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$CustomClickListener = paramCustomClickListener;
  }
  
  public void setSeekBar(SeekBar paramSeekBar)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar = paramSeekBar;
  }
  
  public void setVideoBrightnessController(VideoBrightnessController paramVideoBrightnessController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoBrightnessController = paramVideoBrightnessController;
  }
  
  public void setVideoPlayManager(VideoFeedsGestureLayout.IVideoPlayManager paramIVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout$IVideoPlayManager = paramIVideoPlayManager;
  }
  
  public void setVideoPlayManager(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Int = 2;
  }
  
  public void setVideoPlayManager(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_Int = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout
 * JD-Core Version:    0.7.0.1
 */