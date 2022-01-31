package com.tencent.mobileqq.activity.aio.audiopanel;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
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
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import upz;
import uqb;
import uqc;
import uqd;
import uqe;

public class PressToChangeVoicePanel
  extends RelativeLayout
  implements View.OnTouchListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener
{
  public static String a;
  public double a;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new upz(this, Looper.getMainLooper());
  public View a;
  protected ViewGroup a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public PopupWindow a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseChatPie a;
  public AudioPanel a;
  public AudioPanelAdapter a;
  protected VolumeIndicateSquareView a;
  public QQAppInterface a;
  public boolean a;
  public ViewGroup b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected VolumeIndicateSquareView b;
  private boolean jdField_b_of_type_Boolean;
  public ViewGroup c;
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
        jdField_a_of_type_JavaLangString = TraeHelper.a(BaseApplicationImpl.sApplication);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "checkVcSo sync:" + jdField_a_of_type_JavaLangString);
      }
    }
    if (jdField_a_of_type_JavaLangString == null) {
      ThreadManager.post(new uqb(paramBoolean, paramQQAppInterface, paramString), 5, null, false);
    }
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    int k = (int)paramMotionEvent.getRawX();
    if (i == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
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
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i())
            {
              setClickable(false);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
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
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i())
          {
            setClickable(false);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
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
    PttInfoCollector.b(0);
    return 350;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramString, paramRecorderParam, jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitSuccess() is called");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i(paramInt);
    if (paramInt == 1) {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4, AudioPanelAdapter paramAudioPanelAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.f = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.c = paramViewGroup4;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter = paramAudioPanelAdapter;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369458));
    this.d = ((ViewGroup)findViewById(2131366445));
    this.e = ((ViewGroup)findViewById(2131363125));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131366436));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131366438));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366437));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369459));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.init() is called");
    }
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidWidgetTextView, 2);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131427476));
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChanegVoicePanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChanegVoicePanel.onRecorderPrepare() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, false, paramRecorderParam);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString + ", type: " + paramRecorderParam.c + ", time:" + this.jdField_a_of_type_Double);
    }
    HashMap localHashMap;
    if (this.jdField_a_of_type_Double < 800.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString);
      localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(0), paramString);
      localHashMap.put(Integer.valueOf(1), paramRecorderParam);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1003, localHashMap));
      PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 1, 0, String.valueOf((int)this.jdField_a_of_type_Double), "", "", "7.6.3");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "1", "", "", "");
    }
    int i;
    do
    {
      return;
      PttInfoCollector.a(3, (int)this.jdField_a_of_type_Double);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "0", "", "", "");
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d();
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
    PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, 4, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onRecorderError() is called,path is:" + paramString1 + ",errorCode is:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString1, false, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 2, 0, "", "", "", "7.6.3");
    PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, (int)paramDouble, paramRecorderParam);
    PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramArrayOfByte, paramInt1);
    if (b()) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1007, paramInt2, 0, Double.valueOf(paramDouble)));
    }
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void b(int paramInt)
  {
    paramInt /= 1250;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 4, 0, "", "", "", "7.6.3");
    PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 75L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, " PressToSpeakPanel.startRecord() is called, time is " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 3, 0, "", "", "", "7.6.3");
  }
  
  public void d()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(2);
    }
  }
  
  public void e()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g(1);
    }
  }
  
  public void f()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup != null) {
        break label106;
      }
      localObject = (ListenChangeVoicePanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2130970182, null);
      ((ListenChangeVoicePanel)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.f);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    }
    for (;;)
    {
      localObject = (ListenChangeVoicePanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup;
      ((ListenChangeVoicePanel)localObject).f();
      this.f.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((ListenChangeVoicePanel)localObject).setVisibility(8);
      this.jdField_a_of_type_Boolean = true;
      return;
      label106:
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup);
      }
      ((ListenChangeVoicePanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.f);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
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
  
  public void h()
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
    localAnimationSet.setAnimationListener(new uqd(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  @TargetApi(14)
  public void i()
  {
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new uqe(this), 500L);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DeviceMsgChatPie)))
    {
      QQToast.a(BaseApplication.getContext(), 2131437825, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight());
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.onTouch() is called,action is:" + i);
    }
    boolean bool1;
    if (paramView.getId() == 2131369459) {
      if (i == 0)
      {
        paramView = new uqc(this);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        a(paramView, paramMotionEvent);
        bool1 = bool2;
        continue;
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */