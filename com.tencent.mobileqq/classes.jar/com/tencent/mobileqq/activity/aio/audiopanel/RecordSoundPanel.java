package com.tencent.mobileqq.activity.aio.audiopanel;

import aexp;
import aeyj;
import agti;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awxo;
import azqs;
import bavt;
import bdmd;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nrt;

public class RecordSoundPanel
  extends RelativeLayout
  implements aexp, View.OnClickListener, bdmd
{
  protected double a;
  public Handler a;
  protected View a;
  protected ViewGroup a;
  protected ImageView a;
  protected PopupWindow a;
  protected TextView a;
  protected awxo a;
  public BaseChatPie a;
  protected AudioPanel a;
  protected VolumeChangeView a;
  protected QQAppInterface a;
  protected String a;
  protected boolean a;
  protected ViewGroup b;
  protected TextView b;
  protected VolumeChangeView b;
  protected boolean b;
  protected ViewGroup c;
  protected ViewGroup d;
  protected ViewGroup e;
  protected ViewGroup f;
  
  public RecordSoundPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new aeyj(this, Looper.getMainLooper());
  }
  
  public RecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new aeyj(this, Looper.getMainLooper());
  }
  
  public int a()
  {
    this.jdField_a_of_type_Double = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.3(this));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
    bavt.b(2);
    return 350;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484D", "0X800484D", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.f = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.c = paramViewGroup4;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372240));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131713675));
    this.d = ((ViewGroup)findViewById(2131376995));
    this.e = ((ViewGroup)findViewById(2131368226));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368228));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368229));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166894));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166894));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375527));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375520));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramBaseChatPie.a().getResources();
    setClickable(true);
    this.jdField_a_of_type_Awxo = new awxo();
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166894));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166894));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.init() is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.2(this, paramString));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, false, paramRecorderParam);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (this.jdField_a_of_type_Double < 500.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.8(this, paramString, paramRecorderParam));
    }
    int i;
    do
    {
      return;
      bavt.a(2, (int)this.jdField_a_of_type_Double);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i);
      }
      if (i == 2)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.9(this, paramString, paramRecorderParam));
        return;
      }
    } while (i != 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, 3, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.10(this, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString1, false, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.7(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, (int)paramDouble, paramRecorderParam);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    if (this.jdField_a_of_type_Awxo.a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.5(this, paramInt2, paramDouble));
    }
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844372);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131713677));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
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
          return;
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
          QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          continue;
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
          localAlphaAnimation.setDuration(0L);
          localAlphaAnimation.setInterpolator(new LinearInterpolator());
          localException.startAnimation(localAlphaAnimation);
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "level = " + paramInt);
    }
    paramInt = this.jdField_a_of_type_Awxo.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.6(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.4(this));
  }
  
  public void d()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(2);
    }
  }
  
  public void e()
  {
    b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.k(1);
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    aepi.n = true;
    if (i == 2131375520)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
      }
      if (!bool) {
        break label101;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m())
      {
        setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(2);
      }
    }
    return;
    label101:
    bavt.a = SystemClock.uptimeMillis();
    i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (!QQRecorder.d()) {
      QQToast.a(BaseApplication.getContext(), 2131719552, 0).b(i);
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agti)) {
        break;
      }
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005854", "0X8005854", 0, 0, "", "", Double.toString(this.jdField_a_of_type_Double), "", false);
      return;
      if (!QQRecorder.a(paramView.c))
      {
        QQToast.a(BaseApplication.getContext(), 2131693703, 0).b(i);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        QQToast.a(BaseApplication.getContext(), 2131695682, 0).a();
      }
      else if (AudioHelper.b(1))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b(5);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844373);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131713676));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this, this.jdField_b_of_type_Boolean, paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.k(2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
        paramView = new Rect();
        getWindowVisibleDisplayFrame(paramView);
        Rect localRect = new Rect();
        this.jdField_b_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
        localRect = new Rect();
        this.c.getGlobalVisibleRect(localRect);
        int j = localRect.bottom;
        if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
        {
          i = j;
          if (Build.MODEL.startsWith("ivvi"))
          {
            i = j;
            if (Build.VERSION.SDK_INT != 22) {}
          }
        }
        else
        {
          i = j - paramView.top;
        }
        if (localRect.top <= getResources().getDisplayMetrics().heightPixels) {
          this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView.width(), i, this, 0, 0, 0);
        }
        this.jdField_a_of_type_AndroidViewView = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_b_of_type_AndroidViewViewGroup, this.c);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */