package com.tencent.mobileqq.activity.aio.item;

import actj;
import adwo;
import adwp;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bbly;
import bblz;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;

public class SmallPttPlayView
  extends RelativeLayout
  implements adwo, View.OnClickListener, bblz
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbly jdField_a_of_type_Bbly;
  PttAudioWaveView jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public SmallPttPlayView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public SmallPttPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public SmallPttPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = new PttAudioWaveView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.width = actj.a(120.0F, getContext().getResources());
    localLayoutParams.addRule(15, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setLayoutParams(localLayoutParams);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setSeekListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.rightMargin = actj.a(5.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
    setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("SmallPttPlayView", 2, "init width =" + getMeasuredWidth());
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_Boolean = false;
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbly == null)
    {
      this.jdField_a_of_type_Bbly = new bbly(this.jdField_a_of_type_JavaLangString, new Handler(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bbly.a(getContext());
      this.jdField_a_of_type_Bbly.b();
      this.jdField_a_of_type_Bbly.a(this);
      this.jdField_a_of_type_Bbly.b(paramInt);
      this.jdField_a_of_type_Bbly.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(true);
      return;
    }
    c();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    e();
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(PttAudioWaveView paramPttAudioWaveView, float paramFloat)
  {
    int i = (int)(this.b * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("SmallPttPlayView", 2, "onSeekProgressUpdate, offset = " + i);
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
    e();
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  void c()
  {
    if (this.jdField_a_of_type_Bbly != null)
    {
      this.jdField_a_of_type_Bbly.f();
      this.jdField_a_of_type_Bbly = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) && (!this.jdField_a_of_type_Boolean) && (Math.abs(this.jdField_a_of_type_Float - 0.0F) < 1.0E-008D)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
    }
  }
  
  public void onClick(View paramView)
  {
    a((int)(this.jdField_a_of_type_Float * this.b));
  }
  
  public void setDuration(int paramInt, String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.b = paramInt;
    int i = paramInt / 1000;
    if (i <= 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("1\"");
      int j = (int)actj.a((int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()), getContext().getResources());
      i = adwp.a(getContext(), i, 0.0F, j, 5, false, false);
      if (QLog.isColorLevel()) {
        QLog.d("SmallPttPlayView", 2, "setDuration  length=" + i + " duration=" + paramInt + "  param.waveSampleLen" + paramRecorderParam.f);
      }
      if (i <= actj.a(121.0F, getContext().getResources())) {
        break label449;
      }
      i = actj.a(121.0F, getContext().getResources());
    }
    label449:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(getContext().getResources().getColorStateList(2131166845).getDefaultColor());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColorStateList(2131166845).getDefaultColor());
      Object localObject = PttAudioWaveView.a(paramRecorderParam.a, paramRecorderParam.f);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData((int[])localObject, i, paramInt / 1000);
      localObject = new RelativeLayout.LayoutParams(-2, -1);
      ((RelativeLayout.LayoutParams)localObject).width = i;
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = actj.a(5.0F, getContext().getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = actj.a(5.0F, getContext().getResources());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = (i + actj.a(13.0F, getContext().getResources()) + (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()));
      setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((VoiceTextEditPanel)getParent().getParent().getParent().getParent().getParent()).l();
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Int = paramRecorderParam.c;
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "\"");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SmallPttPlayView
 * JD-Core Version:    0.7.0.1
 */