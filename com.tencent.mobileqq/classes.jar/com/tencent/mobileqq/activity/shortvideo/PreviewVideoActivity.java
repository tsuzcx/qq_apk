package com.tencent.mobileqq.activity.shortvideo;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import anvx;
import bczp;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PreviewVideoActivity
  extends PeakActivity
  implements View.OnClickListener, ImageViewVideoPlayer.IMPlayerEndListener
{
  private int jdField_a_of_type_Int;
  private HWVideoPlayView jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  private String jdField_a_of_type_JavaLangString;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      overridePendingTransition(2130771997, 2130772001);
      continue;
      setResult(-1);
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    setContentView(2131562518);
    try
    {
      if (VideoEnvironment.loadAVCodecSo("AVCodec", getApplicationContext()) != 0)
      {
        QLog.e("PreviewVideoActivity", 4, "load so failed");
        finish();
      }
      bczp.a();
      if (getIntent() == null)
      {
        Toast.makeText(getApplicationContext(), anvx.a(2131707873), 1).show();
        finish();
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("PreviewVideoActivity", 4, "load so failed");
        finish();
      }
      Object localObject1;
      Object localObject2;
      if (getIntent().getBooleanExtra("from_qzone_camera", false))
      {
        localObject1 = getIntent().getStringExtra("video_path");
        localObject2 = getIntent().getStringExtra("audio_path");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          Toast.makeText(getApplicationContext(), anvx.a(2131707872), 1).show();
          QLog.e("PreviewVideoActivity", 4, "videoPath is null");
          finish();
          return;
        }
        paramBundle = new EncodeVideoUtil.VideoInfo();
        paramBundle.videoPath = ((String)localObject1);
        paramBundle.audioPath = ((String)localObject2);
        findViewById(2131376805).setVisibility(0);
        findViewById(2131364017).setOnClickListener(this);
        findViewById(2131364031).setOnClickListener(this);
      }
      FrameLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        localObject1 = (FrameLayout)findViewById(2131381157);
        localObject2 = getResources().getDisplayMetrics();
        localLayoutParams = new FrameLayout.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels, 17);
        if (paramBundle == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView = new HWVideoPlayView(this);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.setFilePath(paramBundle.videoPath, paramBundle.audioPath);
        ((FrameLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.setRepeat(true);
        return;
        int i = getIntent().getIntExtra("video_type", -1);
        if ((i != 0) && (i != 1))
        {
          Toast.makeText(getApplicationContext(), anvx.a(2131707871), 1).show();
          QLog.e("PreviewVideoActivity", 4, "init error, mVideoType=" + i);
          finish();
          return;
        }
        this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("video_source_path");
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          Toast.makeText(getApplicationContext(), anvx.a(2131707874), 1).show();
          QLog.e("PreviewVideoActivity", 4, "init error, mSourcePath=" + this.jdField_a_of_type_JavaLangString);
          finish();
          return;
        }
        findViewById(2131378658).setVisibility(0);
        findViewById(2131365119).setOnClickListener(this);
        paramBundle = EncodeVideoUtil.getVideoInfoByPath(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = getIntent().getBundleExtra("encode_video_params").getInt("sv_total_frame_count");
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = new ImageViewVideoPlayer(getApplicationContext());
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.updateUISize(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels, false, ScreenUtil.dip2px(5.0F));
      ((FrameLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewVideoActivity", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
    }
    bczp.b();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.f();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView = null;
    }
  }
  
  public void onDrawLastFrameEnd() {}
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.onPause();
    }
  }
  
  public void onPlayerEnd()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.initPlayer(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
    }
  }
  
  public void onPlayerRecyle() {}
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.initPlayer(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.onResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity
 * JD-Core Version:    0.7.0.1
 */