package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.aelight.camera.videoplay.IHWVideoPlay;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
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
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
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
    int i = paramView.getId();
    if (i != 2131364037) {
      if (i != 2131364052)
      {
        if (i != 2131365132) {
          break label50;
        }
      }
      else
      {
        setResult(-1);
        finish();
        break label50;
      }
    }
    finish();
    overridePendingTransition(2130772011, 2130772015);
    label50:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.i = true;
    this.j = false;
    super.onCreate(paramBundle);
    setContentView(2131562473);
    try
    {
      if (VideoEnvironment.loadAVCodecSo() == 0) {
        break label54;
      }
      QLog.e("PreviewVideoActivity", 4, "load so failed");
      finish();
    }
    catch (Exception paramBundle)
    {
      label42:
      label54:
      Object localObject1;
      Object localObject2;
      int i;
      FrameLayout.LayoutParams localLayoutParams;
      break label42;
    }
    QLog.e("PreviewVideoActivity", 4, "load so failed");
    finish();
    GloableValue.a();
    if (getIntent() == null)
    {
      Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131708406), 1).show();
      finish();
      return;
    }
    if (getIntent().getBooleanExtra("from_qzone_camera", false))
    {
      localObject1 = getIntent().getStringExtra("video_path");
      localObject2 = getIntent().getStringExtra("audio_path");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131708405), 1).show();
        QLog.e("PreviewVideoActivity", 4, "videoPath is null");
        finish();
        return;
      }
      paramBundle = new EncodeVideoUtil.VideoInfo();
      paramBundle.jdField_a_of_type_JavaLangString = ((String)localObject1);
      paramBundle.b = ((String)localObject2);
      findViewById(2131376669).setVisibility(0);
      findViewById(2131364037).setOnClickListener(this);
      findViewById(2131364052).setOnClickListener(this);
    }
    else
    {
      i = getIntent().getIntExtra("video_type", -1);
      if ((i != 0) && (i != 1))
      {
        Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131708404), 1).show();
        paramBundle = new StringBuilder();
        paramBundle.append("init error, mVideoType=");
        paramBundle.append(i);
        QLog.e("PreviewVideoActivity", 4, paramBundle.toString());
        finish();
        return;
      }
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("video_source_path");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131708407), 1).show();
        paramBundle = new StringBuilder();
        paramBundle.append("init error, mSourcePath=");
        paramBundle.append(this.jdField_a_of_type_JavaLangString);
        QLog.e("PreviewVideoActivity", 4, paramBundle.toString());
        finish();
        return;
      }
      findViewById(2131378460).setVisibility(0);
      findViewById(2131365132).setOnClickListener(this);
      paramBundle = EncodeVideoUtil.a(this.jdField_a_of_type_JavaLangString);
    }
    localObject1 = (FrameLayout)findViewById(2131380856);
    localObject2 = getResources().getDisplayMetrics();
    localLayoutParams = new FrameLayout.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels, 17);
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView = ((IHWVideoPlay)QRoute.api(IHWVideoPlay.class)).getHWVideoPlayView(this);
      ((IHWVideoPlay)QRoute.api(IHWVideoPlay.class)).setFilePath(this.jdField_a_of_type_AndroidOpenglGLSurfaceView, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.b);
      ((FrameLayout)localObject1).addView(this.jdField_a_of_type_AndroidOpenglGLSurfaceView, localLayoutParams);
      ((IHWVideoPlay)QRoute.api(IHWVideoPlay.class)).startPlay(this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
      ((IHWVideoPlay)QRoute.api(IHWVideoPlay.class)).setRepeat(this.jdField_a_of_type_AndroidOpenglGLSurfaceView, true);
      return;
    }
    this.jdField_a_of_type_Int = getIntent().getBundleExtra("encode_video_params").getInt("sv_total_frame_count");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = new ImageViewVideoPlayer(getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.updateUISize(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels, false, ScreenUtil.dip2px(5.0F));
    ((FrameLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewVideoActivity", 2, "onDestroy");
    }
    super.onDestroy();
    ImageViewVideoPlayer localImageViewVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
    if (localImageViewVideoPlayer != null)
    {
      localImageViewVideoPlayer.stopPlayer();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
    }
    GloableValue.b();
    if (this.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)
    {
      ((IHWVideoPlay)QRoute.api(IHWVideoPlay.class)).stopPlay(this.jdField_a_of_type_AndroidOpenglGLSurfaceView);
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView = null;
    }
  }
  
  public void onDrawLastFrameEnd() {}
  
  protected void onPause()
  {
    super.onPause();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
    if (localObject != null) {
      ((ImageViewVideoPlayer)localObject).stopPlayer();
    }
    localObject = this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
    if (localObject != null) {
      ((GLSurfaceView)localObject).onPause();
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
  
  protected void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.initPlayer(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
    }
    GLSurfaceView localGLSurfaceView = this.jdField_a_of_type_AndroidOpenglGLSurfaceView;
    if (localGLSurfaceView != null) {
      localGLSurfaceView.onResume();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    ImageViewVideoPlayer localImageViewVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
    if (localImageViewVideoPlayer != null) {
      localImageViewVideoPlayer.stopPlayer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity
 * JD-Core Version:    0.7.0.1
 */