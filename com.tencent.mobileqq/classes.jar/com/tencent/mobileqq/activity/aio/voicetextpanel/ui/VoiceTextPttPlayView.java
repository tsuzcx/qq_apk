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
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PttAudioWaveView jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  
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
  
  private int a(int paramInt)
  {
    paramInt /= 1000;
    if (paramInt <= 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("1\"");
      return paramInt;
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\"");
    localTextView.setText(localStringBuilder.toString());
    return paramInt;
  }
  
  private int a(int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam)
  {
    int i = ViewUtils.c((int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()));
    paramInt2 = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getWaveViewLen(getContext(), paramInt2, 0.0F, i, 5, false, false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDuration  length=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" duration=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("  param.waveSampleLen");
      localStringBuilder.append(paramRecorderParam.f);
      QLog.d("VoiceTextPttPlayView", 2, localStringBuilder.toString());
    }
    paramInt1 = paramInt2;
    if (paramInt2 > ViewUtils.b(120.0F)) {
      paramInt1 = ViewUtils.b(120.0F);
    }
    return paramInt1;
  }
  
  private void a(int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, VoiceTextPanel paramVoiceTextPanel)
  {
    paramRecorderParam = PttAudioWaveView.a(paramRecorderParam.a, paramRecorderParam.f);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramRecorderParam, paramInt2, paramInt1 / 1000);
    paramRecorderParam = new RelativeLayout.LayoutParams(-2, -1);
    paramRecorderParam.width = paramInt2;
    paramRecorderParam.addRule(15, -1);
    paramRecorderParam.leftMargin = ViewUtils.b(5.0F);
    paramRecorderParam.rightMargin = ViewUtils.b(5.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setLayoutParams(paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
    paramRecorderParam = (LinearLayout.LayoutParams)getLayoutParams();
    paramRecorderParam.width = (ViewUtils.b(13.0F) + paramInt2 + (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()));
    setLayoutParams(paramRecorderParam);
    if (paramVoiceTextPanel != null) {
      paramVoiceTextPanel.c();
    }
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = new PttAudioWaveView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.width = ViewUtils.b(120.0F);
    localLayoutParams.addRule(15, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.rightMargin = ViewUtils.b(5.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_Boolean = false;
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
  }
  
  private void g()
  {
    VoicePlayer localVoicePlayer = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
    if (localVoicePlayer != null)
    {
      localVoicePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) && (!this.jdField_a_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_Float - 0.0F) < 1.0E-008D)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
    }
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(this.jdField_a_of_type_JavaLangString, new Handler(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
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
    this.jdField_a_of_type_Boolean = true;
    g();
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    int i = (int)(paramFloat * this.b);
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
    this.jdField_a_of_type_Float = (paramInt2 / paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(this.jdField_a_of_type_Float);
  }
  
  public void b()
  {
    f();
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    a((int)(this.jdField_a_of_type_Float * this.b));
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setDuration(int paramInt, String paramString, RecordParams.RecorderParam paramRecorderParam, VoiceTextPanel paramVoiceTextPanel)
  {
    this.b = paramInt;
    a(paramInt, a(paramInt, a(paramInt), paramRecorderParam), paramRecorderParam, paramVoiceTextPanel);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramRecorderParam.c;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(getContext().getResources().getColorStateList(2131167047).getDefaultColor());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColorStateList(2131167047).getDefaultColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPttPlayView
 * JD-Core Version:    0.7.0.1
 */