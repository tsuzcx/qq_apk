package com.tencent.mobileqq.activity.aio.audiopanel;

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
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PressToChangeVoicePanel
  extends RelativeLayout
  implements View.OnTouchListener, AudioPanelCallback, IQQRecorder.OnQQRecorderListener
{
  public static String a;
  protected double a;
  private Handler jdField_a_of_type_AndroidOsHandler = new PressToChangeVoicePanel.1(this, Looper.getMainLooper());
  protected View a;
  protected ViewGroup a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected PopupWindow a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AudioPanel a;
  public AudioPanelAdapter a;
  protected VolumeChangeView a;
  protected BaseChatPie a;
  protected QQAppInterface a;
  protected IPttAudioDataManager a;
  public boolean a;
  protected ViewGroup b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected VolumeChangeView b;
  private boolean jdField_b_of_type_Boolean = false;
  protected ViewGroup c;
  protected ViewGroup d;
  protected ViewGroup e;
  protected ViewGroup f;
  
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkVcSo sync:");
        localStringBuilder.append(jdField_a_of_type_JavaLangString);
        QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
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
      if (((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a()) {
        ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(2);
      }
    }
    for (;;)
    {
      return true;
      if (i == 2)
      {
        paramMotionEvent = new int[2];
        paramView.getLocationOnScreen(paramMotionEvent);
        double d3 = paramView.getWidth();
        double d1 = paramView.getHeight();
        double d4 = paramMotionEvent[0];
        Double.isNaN(d4);
        Double.isNaN(d3);
        double d2 = paramMotionEvent[1];
        Double.isNaN(d2);
        Double.isNaN(d1);
        double d5 = k;
        Double.isNaN(d5);
        if (Math.abs(d5 - (d4 + d3)) <= d3)
        {
          d3 = j;
          Double.isNaN(d3);
          if (Math.abs(d3 - (d2 + d1)) <= d1) {}
        }
        else if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          if (((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a())
          {
            setClickable(false);
            ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(2);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          return true;
        }
      }
      else if ((i == 1) || (i == 3))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(false);
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_Boolean = false;
        if (((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a())
        {
          setClickable(false);
          ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(2);
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    return true;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.prepareRecord() is called,time is:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373030));
    this.d = ((ViewGroup)findViewById(2131377835));
    this.e = ((ViewGroup)findViewById(2131368764));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368766));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368767));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377746));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373024));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager = ((IPttUtils)QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.init() is called");
    }
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    }
    if (AppSetting.d)
    {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidWidgetTextView, 2);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131691108));
    }
  }
  
  public boolean a()
  {
    boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChangeVoicePanel.onBackEvent() is called,isRecording is:");
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
      localStringBuilder.append("PressToChangeVoicePanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(2);
    }
  }
  
  public void c()
  {
    boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().isFinishing()))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing())) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PressToSpeakPanel.onDestroy() is called,isRecording is:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(1);
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).e(1);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" PressToSpeakPanel.startRecord() is called, time is ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
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
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup == null)
      {
        localObject = (ListenChangeVoicePanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2131560923, null);
        ((ListenChangeVoicePanel)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.f);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
      }
      else
      {
        localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup);
        }
        ((ListenChangeVoicePanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.f);
      }
      Object localObject = (ListenChangeVoicePanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanelAdapter.jdField_b_of_type_AndroidViewViewGroup;
      ((ListenChangeVoicePanel)localObject).a();
      this.f.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((ListenChangeVoicePanel)localObject).setVisibility(8);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    int i = 0;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().isFinishing()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null)
    {
      if (localPopupWindow.isShowing()) {
        try
        {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      if (((View)localObject).getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = null;
    }
    localObject = (PanelIconLinearLayout)this.c;
    if (localObject != null)
    {
      ((PanelIconLinearLayout)localObject).setAllAlpha(1.0F);
      ((PanelIconLinearLayout)localObject).setAllEnable(true);
    }
    int j = this.jdField_b_of_type_AndroidViewViewGroup.getChildCount();
    while (i < j)
    {
      localObject = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(i);
      if (((View)localObject).getVisibility() != 8)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        ((View)localObject).startAnimation(localAlphaAnimation);
      }
      i += 1;
    }
    h();
  }
  
  void g()
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
    localAnimationSet.setAnimationListener(new PressToChangeVoicePanel.4(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  @TargetApi(14)
  public void h()
  {
    if (AppSetting.d) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new PressToChangeVoicePanel.5(this), 500L);
    }
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    ((IPttPreSendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPttPreSendService.class)).startPreSendIfNeed(paramString, paramRecorderParam, jdField_a_of_type_JavaLangString);
    return ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitFailed() is called");
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 3, 0, "", "", "", "8.7.0");
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, true, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 4, 0, "", "", "", "8.7.0");
    ((IPttPreSendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPttPreSendService.class)).cleanUp();
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RecordSoundPanel.onRecorderEnd() is called,path is:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type: ");
      ((StringBuilder)localObject).append(paramRecorderParam.c);
      ((StringBuilder)localObject).append(", time:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Double);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Double < 800.0D)
    {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString);
      localObject = new HashMap();
      ((HashMap)localObject).put(Integer.valueOf(0), paramString);
      ((HashMap)localObject).put(Integer.valueOf(1), paramRecorderParam);
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      paramString.sendMessage(paramString.obtainMessage(1003, localObject));
      ((IPttPreSendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPttPreSendService.class)).cleanUp();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 1, 0, String.valueOf((int)this.jdField_a_of_type_Double), "", "", "8.7.0");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "1", "", "", "");
      return;
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(3, (int)this.jdField_a_of_type_Double);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "0", "", "", "");
    int i = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fateOfRecorder is:");
      ((StringBuilder)localObject).append(i);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 2)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(Integer.valueOf(0), paramString);
      ((HashMap)localObject).put(Integer.valueOf(1), paramRecorderParam);
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      paramString.sendMessage(paramString.obtainMessage(1005, localObject));
      return;
    }
    if (i == 1)
    {
      ((IPttPreSendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPttPreSendService.class)).cleanUp();
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c(paramString, 4, paramRecorderParam);
      paramRecorderParam = this.jdField_a_of_type_AndroidOsHandler;
      paramRecorderParam.sendMessage(paramRecorderParam.obtainMessage(1004, paramString));
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChangeVoicePanel.onRecorderError() is called,path is:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",errorCode is:");
      localStringBuilder.append(paramString2);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString1, false, false, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1006);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 2, 0, "", "", "", "8.7.0");
    ((IPttPreSendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPttPreSendService.class)).cleanUp();
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChanegVoicePanel.onRecorderNotReady() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChanegVoicePanel.onRecorderPrepare() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, false, paramRecorderParam);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b(paramString, (int)paramDouble, paramRecorderParam);
    ((IPttPreSendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPttPreSendService.class)).handleSliceData(paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager.a())
    {
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      paramString.sendMessage(paramString.obtainMessage(1007, paramInt2, 0, Double.valueOf(paramDouble)));
    }
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public int onRecorderStart()
  {
    this.jdField_a_of_type_Double = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
    PttInfoCollector.reportCostUntilPrepare(0);
    return 350;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).g(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    boolean bool = false;
    if ((localObject != null) && ((localObject instanceof DeviceMsgChatPie)))
    {
      QQToast.a(BaseApplication.getContext(), 2131691568, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getTitleBarHeight());
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PressToChangeVoice.onTouch() is called,action is:");
      ((StringBuilder)localObject).append(i);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramView.getId() == 2131373024)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(true);
        paramView = new PressToChangeVoicePanel.3(this);
        paramView = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramView);
        paramView.what = 1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 150L);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        a(paramView, paramMotionEvent);
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */