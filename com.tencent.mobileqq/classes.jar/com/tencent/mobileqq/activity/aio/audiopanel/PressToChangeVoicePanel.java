package com.tencent.mobileqq.activity.aio.audiopanel;

import afya;
import afyo;
import afyq;
import ahzx;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bahh;
import baif;
import bdla;
import bhgu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import muy;

public class PressToChangeVoicePanel
  extends RelativeLayout
  implements afya, View.OnTouchListener, bhgu
{
  public static String a;
  public double a;
  private Handler jdField_a_of_type_AndroidOsHandler = new afyo(this, Looper.getMainLooper());
  protected View a;
  public ViewGroup a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected PopupWindow a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bahh a;
  public AudioPanel a;
  public AudioPanelAdapter a;
  protected VolumeChangeView a;
  public BaseChatPie a;
  public QQAppInterface a;
  public boolean a;
  protected ViewGroup b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected VolumeChangeView b;
  private boolean jdField_b_of_type_Boolean;
  protected ViewGroup c;
  protected ViewGroup d;
  protected ViewGroup e;
  public ViewGroup f;
  
  public PressToChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (jdField_a_of_type_JavaLangString == null) {
        jdField_a_of_type_JavaLangString = muy.a(BaseApplicationImpl.sApplication);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "checkVcSo sync:" + jdField_a_of_type_JavaLangString);
      }
    }
    if (jdField_a_of_type_JavaLangString == null) {
      ThreadManager.post(new PressToChangeVoicePanel.2(paramBoolean, paramQQAppInterface, paramString), 5, null, false);
    }
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    int k = (int)paramMotionEvent.getRawX();
    if (i == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isRecorderRecording()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.stopAudioRecord(2);
      }
    }
    for (;;)
    {
      return true;
      if (i == 2)
      {
        paramMotionEvent = new int[2];
        paramView.getLocationOnScreen(paramMotionEvent);
        double d1 = paramView.getWidth();
        double d2 = paramView.getHeight();
        double d3 = paramMotionEvent[0];
        double d4 = paramMotionEvent[1];
        if ((Math.abs(k - (d3 + d1)) > d1) || (Math.abs(j - (d4 + d2)) > d2)) {
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = false;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isRecorderRecording())
            {
              setClickable(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.stopAudioRecord(2);
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
        }
      }
      else if ((i == 1) || (i == 3))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(false);
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isRecorderRecording())
          {
            setClickable(false);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.stopAudioRecord(2);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
    }
  }
  
  public int a()
  {
    this.jdField_a_of_type_Double = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
    PttInfoCollector.reportCostUntilPrepare(0);
    return 350;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    baif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString, paramRecorderParam, jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.recorderSetTimeout();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "level = " + paramInt);
    }
    paramInt = this.jdField_a_of_type_Bahh.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4, AudioPanelAdapter paramAudioPanelAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.f = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.c = paramViewGroup4;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter = paramAudioPanelAdapter;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373126));
    this.d = ((ViewGroup)findViewById(2131378002));
    this.e = ((ViewGroup)findViewById(2131368810));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368812));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368813));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167017));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167017));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377922));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373120));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_a_of_type_Bahh = new bahh();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.init() is called");
    }
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167017));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167017));
    }
    if (AppSetting.c)
    {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidWidgetTextView, 2);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131691080));
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChanegVoicePanel.onRecorderPrepare() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.recorderPrepared(paramString, false, paramRecorderParam);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString + ", type: " + paramRecorderParam.c + ", time:" + this.jdField_a_of_type_Double);
    }
    HashMap localHashMap;
    if (this.jdField_a_of_type_Double < 800.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.recorderTimeTooShort(paramString);
      localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(0), paramString);
      localHashMap.put(Integer.valueOf(1), paramRecorderParam);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1003, localHashMap));
      baif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 1, 0, String.valueOf((int)this.jdField_a_of_type_Double), "", "", "8.4.10");
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "1", "", "", "");
    }
    int i;
    do
    {
      return;
      PttInfoCollector.reportGcAndMemoryUse(3, (int)this.jdField_a_of_type_Double);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "0", "", "", "");
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getFateOfRecorder();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i);
      }
      if (i == 2)
      {
        localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(0), paramString);
        localHashMap.put(Integer.valueOf(1), paramRecorderParam);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1005, localHashMap));
        return;
      }
    } while (i != 1);
    baif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.cancelSendPtt(paramString, 4, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onRecorderError() is called,path is:" + paramString1 + ",errorCode is:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.recorderError(paramString1, false, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 2, 0, "", "", "", "8.4.10");
    baif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.recorderSilceEnd(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sendSliceDataIfNeeded(paramString, (int)paramDouble, paramRecorderParam);
    baif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_Bahh.a()) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1007, paramInt2, 0, Double.valueOf(paramDouble)));
    }
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.stopAudioRecord(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.stopAudioRecord(2);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.recorderVolumeChange(paramInt);
    if (paramInt == 1) {}
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.recorderError(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 3, 0, "", "", "", "8.4.10");
  }
  
  public void c()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isRecording();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().isFinishing()) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.stopAudioRecord(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setFateOfRecorder(1);
    }
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.recorderError(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 4, 0, "", "", "", "8.4.10");
    baif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, " PressToSpeakPanel.startRecord() is called, time is " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public void e()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup != null) {
        break label106;
      }
      localObject = (ListenChangeVoicePanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131560973, null);
      ((ListenChangeVoicePanel)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.f);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    }
    for (;;)
    {
      localObject = (ListenChangeVoicePanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup;
      ((ListenChangeVoicePanel)localObject).a();
      this.f.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((ListenChangeVoicePanel)localObject).setVisibility(8);
      this.jdField_a_of_type_Boolean = true;
      return;
      label106:
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup);
      }
      ((ListenChangeVoicePanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.f);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitSuccess() is called");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().isFinishing()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView = null;
      }
      Object localObject = (PanelIconLinearLayout)this.c;
      if (localObject != null)
      {
        ((PanelIconLinearLayout)localObject).setAllAlpha(1.0F);
        ((PanelIconLinearLayout)localObject).setAllEnable(true);
      }
      int j = this.jdField_b_of_type_AndroidViewViewGroup.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label301;
        }
        localObject = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(i);
        if (((View)localObject).getVisibility() != 8) {
          break;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          continue;
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
          localAlphaAnimation.setDuration(0L);
          localAlphaAnimation.setInterpolator(new LinearInterpolator());
          localException.startAnimation(localAlphaAnimation);
        }
      }
      label301:
      i();
    }
  }
  
  void h()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(0L);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localScaleAnimation = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(200L);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new afyq(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  @TargetApi(14)
  public void i()
  {
    if (AppSetting.c) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new PressToChangeVoicePanel.5(this), 500L);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahzx)))
    {
      QQToast.a(BaseApplication.getContext(), 2131691533, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getTitleBarHeight());
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.onTouch() is called,action is:" + i);
    }
    boolean bool1;
    if (paramView.getId() == 2131373120) {
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(true);
        paramView = new PressToChangeVoicePanel.3(this);
        paramView = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramView);
        paramView.what = 1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 150L);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        a(paramView, paramMotionEvent);
        bool1 = bool2;
        continue;
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */