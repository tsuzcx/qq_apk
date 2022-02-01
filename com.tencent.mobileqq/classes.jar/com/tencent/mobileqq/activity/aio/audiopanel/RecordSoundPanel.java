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
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, IQQRecorder.OnQQRecorderListener
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
  protected IPttAudioDataManager a;
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
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    int i = 0;
    ((TextView)localObject1).setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844759);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713208));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    localObject1 = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localObject1 != null)
    {
      if (((PopupWindow)localObject1).isShowing()) {
        try
        {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidViewView;
    if (localObject2 != null)
    {
      if (((View)localObject2).getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = null;
    }
    localObject2 = (PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup;
    if (localObject2 != null)
    {
      ((PanelIconLinearLayout)localObject2).setAllAlpha(1.0F);
      ((PanelIconLinearLayout)localObject2).setAllEnable(true);
    }
    int j = this.jdField_b_of_type_AndroidViewViewGroup.getChildCount();
    while (i < j)
    {
      localObject2 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(i);
      if (((View)localObject2).getVisibility() != 8)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        ((View)localObject2).startAnimation(localAlphaAnimation);
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("level = ");
      localStringBuilder.append(paramInt);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    paramInt = this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager.a(paramInt);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373026));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131713206));
    this.d = ((ViewGroup)findViewById(2131377835));
    this.e = ((ViewGroup)findViewById(2131368764));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368766));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368767));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376292));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376286));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramBaseChatPie.a().getResources();
    setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager = ((IPttUtils)QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("RecordSoundPanel.init() is called,time is:");
      paramQQAppInterface.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, paramQQAppInterface.toString());
    }
  }
  
  public boolean a()
  {
    boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onBackEvent() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(2);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(2);
    }
  }
  
  public void c()
  {
    a();
    boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onDestroy() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(1);
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).e(1);
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
    VolumeChangeView localVolumeChangeView = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
    if ((localVolumeChangeView != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView != null))
    {
      localVolumeChangeView.a();
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
    return ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    if (i == 2131376286)
    {
      boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isRecording is:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        if (((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a())
        {
          setClickable(false);
          ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(2);
        }
      }
      else
      {
        ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).setsCostUntilPrepare(SystemClock.uptimeMillis());
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getTitleBarHeight();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
        if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkExternalStorageForRecord())
        {
          QQToast.a(BaseApplication.getContext(), 2131718577, 0).b(i);
        }
        else if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(((RecordParams.RecorderParam)localObject).c))
        {
          QQToast.a(BaseApplication.getContext(), 2131693398, 0).b(i);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
        {
          QQToast.a(BaseApplication.getContext(), 2131695163, 0).a();
        }
        else if (AudioUtil.a(1))
        {
          ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b(5);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844760);
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131713207));
          ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(this, this.jdField_b_of_type_Boolean, (RecordParams.RecorderParam)localObject);
          ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).e(2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
          localObject = new Rect();
          getWindowVisibleDisplayFrame((Rect)localObject);
          Rect localRect = new Rect();
          this.jdField_b_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
          localRect = new Rect();
          if (ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
            this.jdField_b_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
          } else {
            this.jdField_c_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect);
          }
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
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie)) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005854", "0X8005854", 0, 0, "", "", Double.toString(this.jdField_a_of_type_Double), "", false);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, true, false, paramRecorderParam);
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
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.6(this));
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onRecorderEnd() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (this.jdField_a_of_type_Double < 500.0D)
    {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.8(this, paramString, paramRecorderParam));
      return;
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(2, (int)this.jdField_a_of_type_Double);
    int i = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fateOfRecorder is:");
      localStringBuilder.append(i);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (i == 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.9(this, paramString, paramRecorderParam));
      return;
    }
    if (i == 1)
    {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c(paramString, 3, paramRecorderParam);
      this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.10(this, paramString));
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("RecordSoundPanel.onRecorderError() is called,path is:");
      paramString2.append(paramString1);
      QLog.d("AIOAudioPanel", 2, paramString2.toString());
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString1, false, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.7(this));
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onRecorderNotReady() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RecordSoundPanel.2(this, paramString));
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, false, paramRecorderParam);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b(paramString, (int)paramDouble, paramRecorderParam);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager.a()) {
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
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).g(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */