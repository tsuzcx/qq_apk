package com.tencent.mobileqq.activity.aio.audiopanel;

import actj;
import adbf;
import adbl;
import aert;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import avbs;
import avcf;
import axqy;
import bbly;
import bblz;
import bcql;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.app.MobileQQ;
import nol;

public class ListenPanel
  extends RelativeLayout
  implements adbf, Handler.Callback, View.OnClickListener, avcf, bblz
{
  public static int a;
  public static int b;
  private double jdField_a_of_type_Double;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avbs jdField_a_of_type_Avbs;
  private bbly jdField_a_of_type_Bbly;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeChangeView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeChangeView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private QQRecorder.RecorderParam jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d = jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = jdField_a_of_type_Int + 1;
  }
  
  public ListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 8;
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_c_of_type_Int == 1) {
        break label45;
      }
      i = j;
    }
    label45:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(i);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (XPanelContainer.jdField_a_of_type_Int != (int)(196.0F * getContext().getResources().getDisplayMetrics().density))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setBackgroundResource(2130848728);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130843953));
      }
      for (;;)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.height = actj.a(75.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130843955));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setBackgroundResource(2130848729);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130843954));
    }
    for (;;)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.height = actj.a(64.0F, getContext().getResources());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130843956));
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Bbly != null)
    {
      this.jdField_a_of_type_Bbly.f();
      this.jdField_a_of_type_Bbly = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel level = " + paramInt);
    }
    paramInt = this.jdField_a_of_type_Avbs.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691102));
    a(false);
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376358));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)findViewById(2131369312));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369311));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369313));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369314));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368079));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368080));
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Avbs = new avbs();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166845));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166845));
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingColor(getResources().getColor(2131166842));
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.init() is called");
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(paramInt2));
      return;
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (this.jdField_a_of_type_Avbs.a()))
    {
      int i = (int)AudioHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramArrayOfByte, paramArrayOfByte.length, 1.0F);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, i, 0));
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (this.d == jdField_b_of_type_Int)
    {
      i = 3;
      ((BaseChatPie)localObject).b(str, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_c_of_type_Int != 1) {
        break label127;
      }
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131371904);
      ((PressToSpeakPanel)localObject).b();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    label127:
    while (this.jdField_c_of_type_Int != 2)
    {
      return false;
      i = 2;
      break;
    }
    setVisibility(8);
    localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131375000);
    ((RecordSoundPanel)localObject).b();
    ((RecordSoundPanel)localObject).setVisibility(0);
    return false;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Bbly != null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691102));
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (this.d == jdField_b_of_type_Int)
    {
      i = 3;
      ((BaseChatPie)localObject).b(str, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_c_of_type_Int != 1) {
        break label126;
      }
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131371904);
      ((PressToSpeakPanel)localObject).b();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    label126:
    while (this.jdField_c_of_type_Int != 2)
    {
      return;
      i = 2;
      break;
    }
    setVisibility(8);
    localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131375000);
    ((RecordSoundPanel)localObject).b();
    ((RecordSoundPanel)localObject).setVisibility(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    a(paramMessage.arg1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369312)
    {
      if (AppSetting.d) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l(2131230745);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject = new StringBuilder();
        if (this.d != jdField_b_of_type_Int) {
          break label270;
        }
        i = 1;
        axqy.b(paramView, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, i + "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.d);
        }
      }
      if (this.jdField_a_of_type_Bbly == null)
      {
        this.jdField_a_of_type_Bbly = new bbly(this.jdField_a_of_type_JavaLangString, new Handler(), this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_c_of_type_Int);
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bbly.a())) {
          this.jdField_a_of_type_Bbly.a(this);
        }
        this.jdField_a_of_type_Bbly.a(getContext());
        this.jdField_a_of_type_Bbly.b();
        this.jdField_a_of_type_Bbly.a(this);
        this.jdField_a_of_type_Bbly.c();
        b(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691103));
        a(true);
      }
    }
    label270:
    label432:
    do
    {
      return;
      i = 2;
      break;
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691102));
      a(false);
      return;
      if (i == 2131369311)
      {
        a();
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
        localObject = this.jdField_a_of_type_JavaLangString;
        if (this.d == jdField_b_of_type_Int)
        {
          i = 3;
          paramView.b((String)localObject, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
          if (this.jdField_c_of_type_Int != 1) {
            break label432;
          }
          setVisibility(8);
          paramView = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131371904);
          paramView.b();
          paramView.setVisibility(0);
        }
        for (;;)
        {
          a(false);
          return;
          i = 2;
          break;
          if (this.jdField_c_of_type_Int == 2)
          {
            setVisibility(8);
            paramView = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131375000);
            paramView.b();
            paramView.setVisibility(0);
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record _cancel", 0, 0, "", "", "", "");
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aert)) {
              nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005856", "0X8005856", 0, 0, "", "", "", "", false);
            }
          }
        }
      }
    } while (i != 2131369314);
    a();
    int j = (int)this.jdField_a_of_type_Double;
    if (this.jdField_c_of_type_Int == 2)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Record_attribute", 0, 0, String.valueOf(j), "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aert)) {
        nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005855", "0X8005855", 0, 0, "", "", "", "", false);
      }
    }
    if (this.jdField_a_of_type_Double < 1000.0D)
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131698559), 0).a();
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.K;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (this.d == jdField_a_of_type_Int) {}
    for (i = 2;; i = 3)
    {
      paramView.a((String)localObject, i, j, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, true, 0);
      if (!bool) {
        break;
      }
      paramView = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131371904);
      paramView.h();
      paramView.b();
      return;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      setVisibility(8);
      paramView = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131371904);
      paramView.b();
      paramView.setVisibility(0);
    }
    for (;;)
    {
      a(false);
      return;
      if (this.jdField_c_of_type_Int == 2)
      {
        setVisibility(8);
        paramView = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131375000);
        paramView.b();
        paramView.setVisibility(0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(paramDouble));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691102));
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetTextView, new adbl(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + getContext().getString(2131691105));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_c_of_type_AndroidWidgetTextView.getText() + getContext().getString(2131691105));
      QQAppInterface.f(getContext().getString(2131691100));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + paramString + ",recordTime is:" + paramDouble);
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setNeedAudioData(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel
 * JD-Core Version:    0.7.0.1
 */