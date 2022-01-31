package com.tencent.mobileqq.activity.shortvideo;

import ajyb;
import ajyc;
import alpo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import azbo;
import azgq;
import azhq;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.qphone.base.util.QLog;

public class PreviewVideoActivity
  extends PeakActivity
  implements View.OnClickListener, azhq
{
  private int jdField_a_of_type_Int;
  private HWVideoPlayView jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  private String jdField_a_of_type_JavaLangString;
  
  public void ae_()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363688: 
    case 2131364735: 
      finish();
      overridePendingTransition(2130771997, 2130772001);
      return;
    }
    setResult(-1);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    setContentView(2131562277);
    try
    {
      if (VideoEnvironment.a("AVCodec", getApplicationContext()) != 0)
      {
        QLog.e("PreviewVideoActivity", 4, "load so failed");
        finish();
      }
      azbo.a();
      if (getIntent() == null)
      {
        Toast.makeText(getApplicationContext(), alpo.a(2131708797), 1).show();
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
          Toast.makeText(getApplicationContext(), alpo.a(2131708796), 1).show();
          QLog.e("PreviewVideoActivity", 4, "videoPath is null");
          finish();
          return;
        }
        paramBundle = new ajyc();
        paramBundle.jdField_a_of_type_JavaLangString = ((String)localObject1);
        paramBundle.b = ((String)localObject2);
        findViewById(2131375851).setVisibility(0);
        findViewById(2131363688).setOnClickListener(this);
        findViewById(2131363702).setOnClickListener(this);
      }
      FrameLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        localObject1 = (FrameLayout)findViewById(2131379887);
        localObject2 = getResources().getDisplayMetrics();
        localLayoutParams = new FrameLayout.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels, 17);
        if (paramBundle == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView = new HWVideoPlayView(this);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.setFilePath(paramBundle.jdField_a_of_type_JavaLangString, paramBundle.b);
        ((FrameLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.setRepeat(true);
        return;
        int i = getIntent().getIntExtra("video_type", -1);
        if ((i != 0) && (i != 1))
        {
          Toast.makeText(getApplicationContext(), alpo.a(2131708795), 1).show();
          QLog.e("PreviewVideoActivity", 4, "init error, mVideoType=" + i);
          finish();
          return;
        }
        this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("video_source_path");
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          Toast.makeText(getApplicationContext(), alpo.a(2131708798), 1).show();
          QLog.e("PreviewVideoActivity", 4, "init error, mSourcePath=" + this.jdField_a_of_type_JavaLangString);
          finish();
          return;
        }
        findViewById(2131377552).setVisibility(0);
        findViewById(2131364735).setOnClickListener(this);
        paramBundle = ajyb.a(this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = getIntent().getBundleExtra("encode_video_params").getInt("sv_total_frame_count");
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = new ImageViewVideoPlayer(getApplicationContext());
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels, false, azgq.a(5.0F));
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
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    }
    azbo.b();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.h();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecWidgetHWVideoPlayView.onResume();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity
 * JD-Core Version:    0.7.0.1
 */