package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFileDataListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ListenPanel
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, AudioPanelCallback, AudioTransitionAnimManager.TransitionAnimListener, IAudioFileDataListener, VoicePlayer.VoicePlayerListener
{
  public static int a = 1;
  public static int b;
  private double jdField_a_of_type_Double;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeChangeView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private IPttAudioDataManager jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager;
  private RecordParams.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ListenPanel.2(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeChangeView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private RecordParams.RecorderParam jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d;
  private int e = jdField_a_of_type_Int;
  
  static
  {
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
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_c_of_type_Int != 1) {
      i = 8;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(i);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(i);
  }
  
  private boolean a(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat - paramInt) < 1.0E-007D;
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel.setPlayImageState:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (XPanelContainer.jdField_a_of_type_Int != (int)(getContext().getResources().getDisplayMetrics().density * 196.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setBackgroundResource(2130850129);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130844755));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130844757));
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(75.0F, getContext().getResources());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setBackgroundResource(2130850130);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130844756));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130844758));
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(64.0F, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    AudioTransitionAnimManager localAudioTransitionAnimManager = AudioTransitionAnimManager.a();
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if ((localLottieDrawable != null) && (localAudioTransitionAnimManager.a(localLottieDrawable))) {
      localAudioTransitionAnimManager.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = localAudioTransitionAnimManager.a(getContext(), this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      d();
    }
  }
  
  private void d()
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.getDrawable() instanceof LottieDrawable)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.getDrawable();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getIntrinsicWidth() > 0) && (a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getScale(), 1))) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setScale(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.getWidth() / this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getIntrinsicWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.getHeight() / this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getIntrinsicHeight());
    }
    AudioTransitionAnimManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView, true);
  }
  
  void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel. stopAudioPlayer ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    b(203);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).e();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691112));
    a(false);
    a();
  }
  
  public void a(Animator paramAnimator, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("ListenPanel onAnimationEnd  type=");
      paramAnimator.append(paramInt);
      QLog.d("AIOAudioPanel", 2, paramAnimator.toString());
    }
    if (AudioTransitionAnimUtils.b(paramInt)) {
      return;
    }
    paramAnimator = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (paramAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(paramAnimator);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.d = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377746));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)findViewById(2131370159));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCircleProcessViewPresenter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370158));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370160));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370161));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368766));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368767));
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager = ((IPttUtils)QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
    this.jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingColor(getResources().getColor(2131167044));
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.init() is called");
    }
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel onDrawableLoaded mCurAnimType:");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append(",type= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" drawable=");
      localStringBuilder.append(paramLottieDrawable);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (AudioTransitionAnimUtils.b(paramInt)) {
      return;
    }
    if (this.jdField_c_of_type_Int == paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = paramLottieDrawable;
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
    else {
      paramInt1 = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramInt2));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager.a()))
    {
      int i = (int)AudioHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramArrayOfByte, paramArrayOfByte.length, 1.0F);
      paramArrayOfByte = this.jdField_a_of_type_AndroidOsHandler;
      paramArrayOfByte.sendMessage(paramArrayOfByte.obtainMessage(1, i, 0));
    }
  }
  
  public boolean a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel.onBackEvent() is called,audioPath is:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    a();
    if (this.e == jdField_b_of_type_Int) {
      i = 3;
    } else {
      i = 2;
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c(this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(this.jdField_a_of_type_JavaLangString, null);
    int i = this.d;
    if (i == 1)
    {
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373029);
      ((PressToSpeakPanel)localObject).a();
      ((PressToSpeakPanel)localObject).setVisibility(0);
      return false;
    }
    if (i == 2)
    {
      setVisibility(8);
      localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131376287);
      ((RecordSoundPanel)localObject).a();
      ((RecordSoundPanel)localObject).setVisibility(0);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.onPause() is called,audioPath is:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691112));
    }
  }
  
  public void b(int paramInt)
  {
    paramInt = AudioTransitionAnimUtils.a(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel startPlayAnimByType:,type= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isEnabled()");
      localStringBuilder.append(isEnabled());
      localStringBuilder.append(" getVisibility=");
      localStringBuilder.append(getVisibility());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (!AudioTransitionAnimManager.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fileNotExsit");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() == 2) && (getVisibility() == 0) && (isEnabled()))
    {
      AudioTransitionAnimManager.a().a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.f();
      c(paramInt);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel.onDestroy() is called,audioPath is:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    a();
    if (this.e == jdField_b_of_type_Int) {
      i = 3;
    } else {
      i = 2;
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c(this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(this.jdField_a_of_type_JavaLangString, null);
    int i = this.d;
    if (i == 1)
    {
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373029);
      ((PressToSpeakPanel)localObject).a();
      ((PressToSpeakPanel)localObject).setVisibility(0);
      return;
    }
    if (i == 2)
    {
      setVisibility(8);
      localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131376287);
      ((RecordSoundPanel)localObject).a();
      ((RecordSoundPanel)localObject).setVisibility(0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    a(paramMessage.arg1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    Object localObject;
    int i;
    if (j == 2131370159)
    {
      if (AppSetting.d) {
        AudioUtil.b(2131230749, false);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.e == jdField_b_of_type_Int) {
          i = 1;
        } else {
          i = 2;
        }
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, localStringBuilder.toString(), "", "", "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ListenPanel listened, jump source = ");
          ((StringBuilder)localObject).append(this.e);
          QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(this.jdField_a_of_type_JavaLangString, new Handler(), this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_c_of_type_Int);
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        b(false);
        b(202);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691113));
        a(true);
      }
      else
      {
        b(true);
        a();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.jdField_a_of_type_Double));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691112));
        a(false);
      }
    }
    else
    {
      i = 3;
      if (j == 2131370158)
      {
        a();
        if (this.e != jdField_b_of_type_Int) {
          i = 2;
        }
        ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c(this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
        ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(this.jdField_a_of_type_JavaLangString, null);
        i = this.d;
        if (i == 1)
        {
          setVisibility(8);
          localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373029);
          ((PressToSpeakPanel)localObject).a();
          ((PressToSpeakPanel)localObject).setVisibility(0);
        }
        else if (i == 2)
        {
          setVisibility(8);
          localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131376287);
          ((RecordSoundPanel)localObject).a();
          ((RecordSoundPanel)localObject).setVisibility(0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record _cancel", 0, 0, "", "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie)) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005856", "0X8005856", 0, 0, "", "", "", "", false);
          }
        }
        a(false);
      }
      else if (j == 2131370161)
      {
        a();
        j = (int)this.jdField_a_of_type_Double;
        if (this.d == 2)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Record_attribute", 0, 0, String.valueOf(j), "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie)) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005855", "0X8005855", 0, 0, "", "", "", "", false);
          }
        }
        if (this.jdField_a_of_type_Double < 1000.0D)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getString(2131698595), 0).a();
        }
        else
        {
          boolean bool = ((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).jdField_a_of_type_Boolean;
          ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(this.jdField_a_of_type_JavaLangString, null);
          if (this.e == jdField_a_of_type_Int) {
            i = 2;
          } else {
            i = 3;
          }
          ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(this.jdField_a_of_type_JavaLangString, i, j, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam, 0, true, 0);
          if (bool)
          {
            localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373029);
            ((PressToSpeakPanel)localObject).g();
            ((PressToSpeakPanel)localObject).a();
          }
          else
          {
            i = this.d;
            if (i == 1)
            {
              setVisibility(8);
              localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131373029);
              ((PressToSpeakPanel)localObject).a();
              ((PressToSpeakPanel)localObject).setVisibility(0);
            }
            else if (i == 2)
            {
              setVisibility(8);
              localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131376287);
              ((RecordSoundPanel)localObject).a();
              ((RecordSoundPanel)localObject).setVisibility(0);
            }
            a(false);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramDouble));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setAnimFlag(true);
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131691112));
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetTextView, new ListenPanel.1(this));
      paramRecorderParam = this.jdField_b_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      localStringBuilder.append(getContext().getString(2131691115));
      paramRecorderParam.setContentDescription(localStringBuilder.toString());
      paramRecorderParam = this.jdField_c_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_c_of_type_AndroidWidgetTextView.getText());
      localStringBuilder.append(getContext().getString(2131691115));
      paramRecorderParam.setContentDescription(localStringBuilder.toString());
      QQAppInterface.speak(getContext().getString(2131691110));
    }
    if (QLog.isColorLevel())
    {
      paramRecorderParam = new StringBuilder();
      paramRecorderParam.append("ListenPanel.setAudioPath() is called,path is:");
      paramRecorderParam.append(paramString);
      paramRecorderParam.append(",recordTime is:");
      paramRecorderParam.append(paramDouble);
      QLog.d("AIOAudioPanel", 2, paramRecorderParam.toString());
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setNeedAudioData(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel
 * JD-Core Version:    0.7.0.1
 */