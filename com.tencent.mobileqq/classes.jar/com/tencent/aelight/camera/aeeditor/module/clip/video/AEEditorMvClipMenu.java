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
import com.tencent.qcircle.tavcut.timeline.TimelineView;
import com.tencent.qcircle.tavcut.timeline.TimelineView.SpeedChangeCallback;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavkit.composition.TAVSource;

public class AEEditorMvClipMenu
  extends FrameLayout
{
  TAVSource a;
  private RelativeLayout b;
  private ImageView c;
  private TextView d;
  private TimelineView e;
  private IPlayer.PlayerStatus f;
  private IPlayer.PlayerStatus g;
  private float h = 1.0F;
  private AEEditorMvClipMenu.MvClipMenuListener i;
  private FrameLayout j = null;
  private CMTimeRange k;
  private boolean l = false;
  private boolean m = false;
  private CMTimeRange n;
  
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
    AEEditorMvClipMenu.MvClipMenuListener localMvClipMenuListener = this.i;
    if (localMvClipMenuListener != null) {
      localMvClipMenuListener.a(paramCMTime);
    }
  }
  
  private void a(CMTimeRange paramCMTimeRange)
  {
    AEEditorMvClipMenu.MvClipMenuListener localMvClipMenuListener = this.i;
    if (localMvClipMenuListener != null) {
      localMvClipMenuListener.a(paramCMTimeRange);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AEEditorMvClipMenu.MvClipMenuListener localMvClipMenuListener = this.i;
    if (localMvClipMenuListener != null) {
      localMvClipMenuListener.a(paramBoolean);
    }
  }
  
  private void b()
  {
    this.m = AEThemeUtil.b();
    inflate(getContext(), 2064056466, this);
    this.b = ((RelativeLayout)findViewById(2063990862));
    this.c = ((ImageView)findViewById(2063991212));
    this.d = ((TextView)findViewById(2063991566));
    this.j = ((FrameLayout)findViewById(2063991279));
    this.e = new TimelineView(getContext(), null, 2063925492, 2063925394, 2063925394, 2063925442, 2063925443, 2063925444, 2063925445);
    this.e.setSliderFrameColor(Color.parseColor("#3B80FF"));
    this.e.setIndicatorRes(2063925542);
    this.e.setDurationBgRes(2063925484);
    this.e.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.j.addView(this.e);
    c();
    d();
    e();
  }
  
  private void c() {}
  
  private void d()
  {
    this.e.setSliderChangeListener(new AEEditorMvClipMenu.1(this));
  }
  
  private void e()
  {
    this.b.setOnClickListener(new AEEditorMvClipMenu.2(this));
  }
  
  private void setIsInSlidering(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setMvClipMenuListener(AEEditorMvClipMenu.MvClipMenuListener paramMvClipMenuListener)
  {
    this.i = paramMvClipMenuListener;
  }
  
  public void setPlayPosition(CMTime paramCMTime)
  {
    TimelineView localTimelineView = this.e;
    if (localTimelineView != null) {
      localTimelineView.setPlayPosition(((float)(paramCMTime.getTimeUs() / 1000L) * 1.0F));
    }
  }
  
  public void setPlayStatus(IPlayer.PlayerStatus paramPlayerStatus)
  {
    this.f = paramPlayerStatus;
  }
  
  public void setSpeedEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setOnClickListener(new AEEditorMvClipMenu.4(this));
      this.d.setTextColor(getResources().getColor(2131165564));
      this.c.setImageResource(2063925434);
      return;
    }
    this.b.setOnClickListener(new AEEditorMvClipMenu.5(this));
    this.d.setTextColor(getResources().getColor(2131167032));
    this.c.setImageResource(2063925435);
  }
  
  public void setTAVSource(TAVSource paramTAVSource)
  {
    this.a = paramTAVSource;
  }
  
  public void setTime(CMTimeRange paramCMTimeRange)
  {
    this.n = paramCMTimeRange;
    this.k = paramCMTimeRange;
    paramCMTimeRange = new StringBuilder();
    paramCMTimeRange.append("setTime: newTimeRange ");
    paramCMTimeRange.append(this.k);
    Log.e("MvClipMenu", paramCMTimeRange.toString());
  }
  
  public void setTimeLineViewSpeed(float paramFloat, TimelineView.SpeedChangeCallback paramSpeedChangeCallback)
  {
    TimelineView localTimelineView = this.e;
    if (localTimelineView != null) {
      localTimelineView.updateSpeed(paramFloat, new AEEditorMvClipMenu.3(this, paramSpeedChangeCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.video.AEEditorMvClipMenu
 * JD-Core Version:    0.7.0.1
 */