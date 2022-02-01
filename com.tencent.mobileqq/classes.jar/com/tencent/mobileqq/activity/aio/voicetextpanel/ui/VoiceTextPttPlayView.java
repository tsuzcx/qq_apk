package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.SeekProgressListener;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VoiceTextPttPlayView
  extends RelativeLayout
  implements View.OnClickListener, PttAudioWaveView.SeekProgressListener, VoicePlayer.VoicePlayerListener
{
  private TextView a;
  private PttAudioWaveView b;
  private VoicePlayer c;
  private String d;
  private int e;
  private int f;
  private float g = 0.0F;
  private boolean h = false;
  
  public VoiceTextPttPlayView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public VoiceTextPttPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public VoiceTextPttPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private int a(int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam)
  {
    int i = ViewUtils.pxToDp((int)this.a.getPaint().measureText(this.a.getText().toString()));
    paramInt2 = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getWaveViewLen(getContext(), paramInt2, 0.0F, i, 5, false, false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDuration  length=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" duration=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("  param.waveSampleLen");
      localStringBuilder.append(paramRecorderParam.g);
      QLog.d("VoiceTextPttPlayView", 2, localStringBuilder.toString());
    }
    paramInt1 = paramInt2;
    if (paramInt2 > ViewUtils.dpToPx(120.0F)) {
      paramInt1 = ViewUtils.dpToPx(120.0F);
    }
    return paramInt1;
  }
  
  private void a(int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, VoiceTextPanel paramVoiceTextPanel)
  {
    paramRecorderParam = PttAudioWaveView.a(paramRecorderParam.h, paramRecorderParam.g);
    this.b.setAudioData(paramRecorderParam, paramInt2, paramInt1 / 1000);
    paramRecorderParam = new RelativeLayout.LayoutParams(-2, -1);
    paramRecorderParam.width = paramInt2;
    paramRecorderParam.addRule(15, -1);
    paramRecorderParam.leftMargin = ViewUtils.dpToPx(5.0F);
    paramRecorderParam.rightMargin = ViewUtils.dpToPx(5.0F);
    this.b.setLayoutParams(paramRecorderParam);
    this.b.setVisibility(0);
    paramRecorderParam = (LinearLayout.LayoutParams)getLayoutParams();
    paramRecorderParam.width = (ViewUtils.dpToPx(13.0F) + paramInt2 + (int)this.a.getPaint().measureText(this.a.getText().toString()));
    setLayoutParams(paramRecorderParam);
    if (paramVoiceTextPanel != null) {
      paramVoiceTextPanel.c();
    }
  }
  
  private int b(int paramInt)
  {
    paramInt /= 1000;
    if (paramInt <= 0)
    {
      this.a.setText("1\"");
      return paramInt;
    }
    TextView localTextView = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\"");
    localTextView.setText(localStringBuilder.toString());
    return paramInt;
  }
  
  private void c()
  {
    d();
    e();
    setOnClickListener(this);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init width =");
      localStringBuilder.append(getMeasuredWidth());
      QLog.d("VoiceTextPttPlayView", 2, localStringBuilder.toString());
    }
  }
  
  private void d()
  {
    this.b = new PttAudioWaveView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.width = ViewUtils.dpToPx(120.0F);
    localLayoutParams.addRule(15, -1);
    this.b.setVisibility(8);
    this.b.setLayoutParams(localLayoutParams);
    addView(this.b);
    this.b.setOnClickListener(this);
    this.b.setSeekListener(this);
  }
  
  private void e()
  {
    this.a = new TextView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.rightMargin = ViewUtils.dpToPx(5.0F);
    this.a.setTextSize(2, 14.0F);
    this.a.setLayoutParams(localLayoutParams);
    this.a.setGravity(16);
    addView(this.a);
  }
  
  private void f()
  {
    this.g = 0.0F;
    this.b.setProgress(0.0F);
    this.h = false;
    g();
    this.b.setCanSupportSlide(false);
  }
  
  private void g()
  {
    VoicePlayer localVoicePlayer = this.c;
    if (localVoicePlayer != null)
    {
      localVoicePlayer.f();
      this.c = null;
    }
    if ((this.b != null) && (!this.h) && (Math.abs(this.g - 0.0F) < 1.0E-008D)) {
      this.b.setCanSupportSlide(false);
    }
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt)
  {
    if (this.c == null)
    {
      this.c = new VoicePlayer(this.d, new Handler(), this.e);
      this.c.a(getContext());
      this.c.h();
      this.c.a(this);
      this.c.a(paramInt);
      this.c.c();
      this.b.setCanSupportSlide(true);
      return;
    }
    g();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    f();
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    this.h = true;
    g();
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    int i = (int)(paramFloat * this.f);
    if (QLog.isColorLevel())
    {
      paramPttAudioWaveView = new StringBuilder();
      paramPttAudioWaveView.append("onSeekProgressUpdate, offset = ");
      paramPttAudioWaveView.append(i);
      QLog.d("VoiceTextPttPlayView", 2, paramPttAudioWaveView.toString());
    }
    a(i);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.g = (paramInt2 / paramInt1);
    this.b.setProgress(this.g);
  }
  
  public void b()
  {
    f();
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    a((int)(this.g * this.f));
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setDuration(int paramInt, String paramString, RecordParams.RecorderParam paramRecorderParam, VoiceTextPanel paramVoiceTextPanel)
  {
    this.f = paramInt;
    a(paramInt, a(paramInt, b(paramInt), paramRecorderParam), paramRecorderParam, paramVoiceTextPanel);
    this.d = paramString;
    this.e = paramRecorderParam.c;
    this.b.setProgressColor(getContext().getResources().getColorStateList(2131167984).getDefaultColor());
    this.a.setTextColor(getContext().getResources().getColorStateList(2131167984).getDefaultColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPttPlayView
 * JD-Core Version:    0.7.0.1
 */