package com.tencent.mobileqq.activity.aio.audiopanel;

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
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.PttAudioDataManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener
{
  protected double a;
  public Handler a;
  protected View a;
  protected ViewGroup a;
  protected ImageView a;
  protected PopupWindow a;
  protected TextView a;
  protected AudioPanel a;
  protected VolumeChangeView a;
  protected BaseChatPie a;
  protected QQAppInterface a;
  protected PttAudioDataManager a;
  protected String a;
  protected boolean a;
  protected ViewGroup b;
  protected TextView b;
  protected VolumeChangeView b;
  protected boolean b;
  protected ViewGroup c;
  private boolean c;
  protected ViewGroup d;
  protected ViewGroup e;
  protected ViewGroup f;
  
  public RecordSoundPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new RecordSoundPanel.1(this, Looper.getMainLooper());
  }
  
  public RecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new RecordSoundPanel.1(this, Looper.getMainLooper());
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844883);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713240));
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
      Object localObject = (PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup;
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
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "level = " + paramInt);
    }
    paramInt = this.jdField_a_of_type_ComTencentMobileqqPttPttAudioDataManager.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.f = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup4;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373448));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131713238));
    this.d = ((ViewGroup)findViewById(2131378421));
    this.e = ((ViewGroup)findViewById(2131369042));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369044));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369045));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167024));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167024));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376798));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376791));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramBaseChatPie.a().getResources();
    setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqPttPttAudioDataManager = new PttAudioDataManager();
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167024));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167024));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.init() is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i(2);
    }
  }
  
  public void c()
  {
    a();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.j(1);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public void e()
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
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    if (i == 2131376791)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
      }
      if (!bool) {
        break label109;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.k())
      {
        setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i(2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
    return;
    label109:
    PttInfoCollector.sCostUntilPrepare = SystemClock.uptimeMillis();
    i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getTitleBarHeight();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    if (!QQRecorder.d()) {
      QQToast.a(BaseApplication.getContext(), 2131718862, 0).b(i);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie)) {
        break;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005854", "0X8005854", 0, 0, "", "", Double.toString(this.jdField_a_of_type_Double), "", false);
      break;
      if (!QQRecorder.a(((RecordParams.RecorderParam)localObject).c))
      {
        QQToast.a(BaseApplication.getContext(), 2131693443, 0).b(i);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        QQToast.a(BaseApplication.getContext(), 2131695173, 0).a();
      }
      else
      {
        if (!AudioHelper.b(1)) {
          break label333;
        }
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      }
    }
    label333:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b(5);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844884);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713239));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(this, this.jdField_b_of_type_Boolean, (RecordParams.RecorderParam)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.j(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
    localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    Rect localRect = new Rect();
    this.jdField_b_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
    localRect = new Rect();
    if (ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_b_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
    }
    for (;;)
    {
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
        i = j - ((Rect)localObject).top;
      }
      if (localRect.top <= getResources().getDisplayMetrics().heightPixels) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), ((Rect)localObject).width(), i, this, 0, 0, 0);
      }
      this.jdField_a_of_type_AndroidViewView = AudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_c_of_type_AndroidViewViewGroup);
      break;
      this.jdField_c_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
    }
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.4(this));
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.6(this));
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (this.jdField_a_of_type_Double < 500.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.8(this, paramString, paramRecorderParam));
    }
    int i;
    do
    {
      return;
      PttInfoCollector.reportGcAndMemoryUse(2, (int)this.jdField_a_of_type_Double);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i);
      }
      if (i == 2)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.9(this, paramString, paramRecorderParam));
        return;
      }
    } while (i != 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(paramString, 3, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.10(this, paramString));
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString1, false, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.7(this));
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.2(this, paramString));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, false, paramRecorderParam);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, (int)paramDouble, paramRecorderParam);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttPttAudioDataManager.a()) {
      this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.5(this, paramInt2, paramDouble));
    }
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public int onRecorderStart()
  {
    this.jdField_a_of_type_Double = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.3(this));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
    PttInfoCollector.reportCostUntilPrepare(2);
    return 350;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484D", "0X800484D", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */