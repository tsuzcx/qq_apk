package com.tencent.aelight.camera.aeeditor.module.clip.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.timeline.TimelineView;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import com.tencent.tavkit.composition.TAVSource;

public class AEEditorMvClipMenu
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEEditorMvClipMenu.MvClipMenuListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  private TimelineView jdField_a_of_type_ComTencentTavcutTimelineTimelineView;
  TAVSource jdField_a_of_type_ComTencentTavkitCompositionTAVSource;
  private boolean jdField_a_of_type_Boolean = false;
  private CMTimeRange jdField_b_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_b_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  private boolean jdField_b_of_type_Boolean = false;
  
  public AEEditorMvClipMenu(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AEEditorMvClipMenu(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AEEditorMvClipMenu(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    b();
  }
  
  private void a(CMTime paramCMTime)
  {
    AEEditorMvClipMenu.MvClipMenuListener localMvClipMenuListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener;
    if (localMvClipMenuListener != null) {
      localMvClipMenuListener.a(paramCMTime);
    }
  }
  
  private void a(CMTimeRange paramCMTimeRange)
  {
    AEEditorMvClipMenu.MvClipMenuListener localMvClipMenuListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener;
    if (localMvClipMenuListener != null) {
      localMvClipMenuListener.a(paramCMTimeRange);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AEEditorMvClipMenu.MvClipMenuListener localMvClipMenuListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener;
    if (localMvClipMenuListener != null) {
      localMvClipMenuListener.a(paramBoolean);
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_Boolean = AEThemeUtil.a();
    inflate(getContext(), 2064318594, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2064121928));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2064122330));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2064122791));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2064122450));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView = new TimelineView(getContext(), null, 2064056533, 2064056425, 2064056425, 2064056474, 2064056475, 2064056476, 2064056477);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderFrameColor(Color.parseColor("#3B80FF"));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setIndicatorRes(2064056583);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setDurationBgRes(2064056525);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView);
    c();
    d();
    e();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void c() {}
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderChangeListener(new AEEditorMvClipMenu.1(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMvClipMenu.2(this));
  }
  
  public void setMvClipMenuListener(AEEditorMvClipMenu.MvClipMenuListener paramMvClipMenuListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoAEEditorMvClipMenu$MvClipMenuListener = paramMvClipMenuListener;
  }
  
  public void setPlayPosition(CMTime paramCMTime)
  {
    TimelineView localTimelineView = this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView;
    if (localTimelineView != null) {
      localTimelineView.setPlayPosition(((float)(paramCMTime.getTimeUs() / 1000L) * 1.0F));
    }
  }
  
  public void setPlayStatus(IPlayer.PlayerStatus paramPlayerStatus)
  {
    this.jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerStatus = paramPlayerStatus;
  }
  
  public void setSpeedEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMvClipMenu.4(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165327));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056466);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMvClipMenu.5(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166295));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056467);
  }
  
  public void setTAVSource(TAVSource paramTAVSource)
  {
    this.jdField_a_of_type_ComTencentTavkitCompositionTAVSource = paramTAVSource;
  }
  
  public void setTime(CMTimeRange paramCMTimeRange)
  {
    this.jdField_b_of_type_ComTencentTavCoremediaCMTimeRange = paramCMTimeRange;
    this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = paramCMTimeRange;
    paramCMTimeRange = new StringBuilder();
    paramCMTimeRange.append("setTime: newTimeRange ");
    paramCMTimeRange.append(this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
    Log.e("MvClipMenu", paramCMTimeRange.toString());
  }
  
  public void setTimeLineViewSpeed(float paramFloat, TimelineView.SpeedChangeCallback paramSpeedChangeCallback)
  {
    TimelineView localTimelineView = this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView;
    if (localTimelineView != null) {
      localTimelineView.updateSpeed(paramFloat, new AEEditorMvClipMenu.3(this, paramSpeedChangeCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.video.AEEditorMvClipMenu
 * JD-Core Version:    0.7.0.1
 */