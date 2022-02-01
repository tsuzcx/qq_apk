package com.tencent.aelight.camera.ae.play;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aelight.camera.aeeditor.util.TimeUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qzone.util.QZLog;

public class AEVideoPreviewFragment
  extends AbsAEPublishVideoProcessFragment
  implements View.OnClickListener
{
  private static final String TAG = "AEVideoPreviewFragment";
  private ImageView ivClose;
  private ImageView ivDelete;
  private ImageView ivPlayOrPause;
  boolean needPlayWhenResume = false;
  private RelativeLayout rlVideoController;
  private SeekBar seekBarVideoProgress;
  TextView tvCurrentDuration;
  TextView tvTotalDuration;
  
  private void pause()
  {
    this.ivPlayOrPause.setVisibility(0);
    this.mMoviePlayer.pause();
  }
  
  private void play()
  {
    this.ivPlayOrPause.setVisibility(8);
    this.mMoviePlayer.play();
  }
  
  private void registerDaTongReport(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "pg_xsj_publish_page_preview_videos");
    VideoReport.setPageParams(paramView, new QCircleDTParamBuilder().buildPageParams("AEVideoPreviewFragment"));
    QLog.i("AEVideoPreviewFragment", 1, "reportDaTongRegister  subPage: AEVideoPreviewFragment");
  }
  
  private void showCustomAlertDialog()
  {
    String str = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "UploadGiveUpVideo", "放弃上传这个视频吗？");
    try
    {
      DialogUtil.a(getBaseActivity(), 230, str, null, getResources().getString(2131690728), getResources().getString(2131691064), new AEVideoPreviewFragment.3(this), new AEVideoPreviewFragment.4(this)).show();
      return;
    }
    catch (Exception localException)
    {
      QZLog.w(localException);
    }
  }
  
  void bindViews(View paramView)
  {
    this.tavCutVideoView = ((TAVCutVideoView)paramView.findViewById(2064122671));
    this.rlVideoController = ((RelativeLayout)paramView.findViewById(2064122577));
    this.ivClose = ((ImageView)paramView.findViewById(2064122298));
    this.ivDelete = ((ImageView)paramView.findViewById(2064122304));
    this.ivPlayOrPause = ((ImageView)paramView.findViewById(2064122323));
    this.seekBarVideoProgress = ((SeekBar)paramView.findViewById(2064122605));
    this.tvTotalDuration = ((TextView)paramView.findViewById(2064122798));
    this.tvCurrentDuration = ((TextView)paramView.findViewById(2064122755));
    this.rlVideoController.setOnClickListener(this);
    this.ivClose.setOnClickListener(this);
    this.ivDelete.setOnClickListener(this);
    this.ivPlayOrPause.setOnClickListener(this);
    this.seekBarVideoProgress.setOnSeekBarChangeListener(new AEVideoPreviewFragment.2(this));
    registerDaTongReport(paramView);
  }
  
  void customizeBindingData(VideoResourceModel paramVideoResourceModel)
  {
    play();
    if ((this.tavCutVideoSession != null) && (this.tavCutVideoSession.getDuration() != null))
    {
      this.seekBarVideoProgress.setMax((int)this.tavCutVideoSession.getDuration().getTimeUs());
      this.tvTotalDuration.setText(TimeUtils.a((this.tavCutVideoSession.getDuration().getTimeSeconds() * 1000.0F)));
    }
    this.mMoviePlayer.setVideoProgressListener(new AEVideoPreviewFragment.1(this));
  }
  
  protected int getLayoutId()
  {
    return 2064318591;
  }
  
  protected int getPlayerBackColor()
  {
    return getResources().getColor(2131165327);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2064122577: 
      if ((this.mMoviePlayer != null) && (this.mMoviePlayer.isPlaying()))
      {
        pause();
        return;
      }
      if (this.mMoviePlayer != null)
      {
        play();
        return;
      }
      break;
    case 2064122323: 
      if (this.mMoviePlayer != null)
      {
        play();
        return;
      }
      break;
    case 2064122304: 
      showCustomAlertDialog();
      return;
    case 2064122298: 
      getBaseActivity().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.needPlayWhenResume = this.mMoviePlayer.isPlaying();
    if (this.mMoviePlayer.isPlaying()) {
      pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.needPlayWhenResume) {
      play();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */