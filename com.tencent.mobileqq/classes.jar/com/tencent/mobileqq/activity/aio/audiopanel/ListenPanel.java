package com.tencent.mobileqq.activity.aio.audiopanel;

import agej;
import agnw;
import agnx;
import agob;
import agoc;
import agoj;
import ainh;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import balt;
import bamg;
import bdll;
import bhud;
import bhue;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ocd;

public class ListenPanel
  extends RelativeLayout
  implements agnw, agob, Handler.Callback, View.OnClickListener, bamg, bhue
{
  public static int a;
  public static int b;
  private double jdField_a_of_type_Double;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private balt jdField_a_of_type_Balt;
  private bhud jdField_a_of_type_Bhud;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeChangeView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ListenPanel.2(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeChangeView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private QQRecorder.RecorderParam jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d;
  private int e = jdField_a_of_type_Int;
  
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
  
  private boolean a(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat - paramInt) < 1.0E-007D;
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setPlayImageState:" + paramBoolean);
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (XPanelContainer.jdField_a_of_type_Int != (int)(196.0F * getContext().getResources().getDisplayMetrics().density))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setBackgroundResource(2130849794);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130844776));
      }
      for (;;)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.height = agej.a(75.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130844778));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setBackgroundResource(2130849795);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130844777));
    }
    for (;;)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.height = agej.a(64.0F, getContext().getResources());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(getContext().getResources().getDrawable(2130844779));
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    agnx localagnx = agnx.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (localagnx.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable))) {
      localagnx.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = localagnx.a(getContext(), this.jdField_c_of_type_Int);
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
    agnx.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView, true);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel. stopAudioPlayer " + this.jdField_a_of_type_JavaLangString);
    }
    b(203);
    if (this.jdField_a_of_type_Bhud != null)
    {
      this.jdField_a_of_type_Bhud.e();
      this.jdField_a_of_type_Bhud = null;
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Balt.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131690959));
    a(false);
    a();
  }
  
  public void a(Animator paramAnimator, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel onAnimationEnd  type=" + paramInt);
    }
    if (agoc.b(paramInt)) {}
    while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.d = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377878));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)findViewById(2131370058));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370057));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370059));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370060));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368629));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368630));
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Balt = new balt();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166981));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166981));
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setRingColor(getResources().getColor(2131166978));
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.init() is called");
    }
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel onDrawableLoaded mCurAnimType:" + this.jdField_c_of_type_Int + ",type= " + paramInt + " drawable=" + paramLottieDrawable);
    }
    if (agoc.b(paramInt)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_Int != paramInt);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = paramLottieDrawable;
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (this.jdField_a_of_type_Balt.a()))
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
    if (this.e == jdField_b_of_type_Int)
    {
      i = 3;
      ((BaseChatPie)localObject).b(str, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      if (this.d != 1) {
        break label127;
      }
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131372945);
      ((PressToSpeakPanel)localObject).d();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    label127:
    while (this.d != 2)
    {
      return false;
      i = 2;
      break;
    }
    setVisibility(8);
    localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131376384);
    ((RecordSoundPanel)localObject).d();
    ((RecordSoundPanel)localObject).setVisibility(0);
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Bhud != null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131690959));
    }
  }
  
  public void b(int paramInt)
  {
    paramInt = agoc.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel startPlayAnimByType:,type= " + paramInt + " isEnabled()" + isEnabled() + " getVisibility=" + getVisibility());
    }
    if (!agnx.a().a()) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fileNotExsit");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() != 2) || (getVisibility() != 0) || (!isEnabled())) {
      return;
    }
    agnx.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.f();
    c(paramInt);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (this.e == jdField_b_of_type_Int)
    {
      i = 3;
      ((BaseChatPie)localObject).b(str, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      if (this.d != 1) {
        break label126;
      }
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131372945);
      ((PressToSpeakPanel)localObject).d();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    label126:
    while (this.d != 2)
    {
      return;
      i = 2;
      break;
    }
    setVisibility(8);
    localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131376384);
    ((RecordSoundPanel)localObject).d();
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
    if (i == 2131370058)
    {
      if (AppSetting.c) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(2131230745);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = new StringBuilder();
        if (this.e != jdField_b_of_type_Int) {
          break label287;
        }
        i = 1;
        bdll.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, i + "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.e);
        }
      }
      if (this.jdField_a_of_type_Bhud == null)
      {
        this.jdField_a_of_type_Bhud = new bhud(this.jdField_a_of_type_JavaLangString, new Handler(), this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_c_of_type_Int);
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bhud.a())) {
          this.jdField_a_of_type_Bhud.a(this);
        }
        this.jdField_a_of_type_Bhud.a(getContext());
        this.jdField_a_of_type_Bhud.b();
        this.jdField_a_of_type_Bhud.a(this);
        this.jdField_a_of_type_Bhud.b();
        b(false);
        b(202);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131690960));
        a(true);
      }
    }
    label287:
    label383:
    int j;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      break;
      b(true);
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131690959));
      a(false);
      continue;
      if (i == 2131370057)
      {
        a();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
        localObject2 = this.jdField_a_of_type_JavaLangString;
        if (this.e == jdField_b_of_type_Int)
        {
          i = 3;
          ((BaseChatPie)localObject1).b((String)localObject2, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
          if (this.d != 1) {
            break label460;
          }
          setVisibility(8);
          localObject1 = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131372945);
          ((PressToSpeakPanel)localObject1).d();
          ((PressToSpeakPanel)localObject1).setVisibility(0);
        }
        for (;;)
        {
          a(false);
          break;
          i = 2;
          break label383;
          label460:
          if (this.d == 2)
          {
            setVisibility(8);
            localObject1 = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131376384);
            ((RecordSoundPanel)localObject1).d();
            ((RecordSoundPanel)localObject1).setVisibility(0);
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record _cancel", 0, 0, "", "", "", "");
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ainh)) {
              ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005856", "0X8005856", 0, 0, "", "", "", "", false);
            }
          }
        }
      }
      if (i == 2131370060)
      {
        a();
        j = (int)this.jdField_a_of_type_Double;
        if (this.d == 2)
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Record_attribute", 0, 0, String.valueOf(j), "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ainh)) {
            ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005855", "0X8005855", 0, 0, "", "", "", "", false);
          }
        }
        if (this.jdField_a_of_type_Double >= 1000.0D) {
          break label737;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131697822), 0).a();
      }
    }
    label737:
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    if (this.e == jdField_a_of_type_Int) {}
    for (i = 2;; i = 3)
    {
      ((BaseChatPie)localObject1).a((String)localObject2, i, j, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, true, 0);
      if (!bool) {
        break label836;
      }
      localObject1 = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131372945);
      ((PressToSpeakPanel)localObject1).h();
      ((PressToSpeakPanel)localObject1).d();
      break;
    }
    label836:
    if (this.d == 1)
    {
      setVisibility(8);
      localObject1 = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131372945);
      ((PressToSpeakPanel)localObject1).d();
      ((PressToSpeakPanel)localObject1).setVisibility(0);
    }
    for (;;)
    {
      a(false);
      break;
      if (this.d == 2)
      {
        setVisibility(8);
        localObject1 = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131376384);
        ((RecordSoundPanel)localObject1).d();
        ((RecordSoundPanel)localObject1).setVisibility(0);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setAnimFlag(true);
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131690959));
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetTextView, new agoj(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + getContext().getString(2131690962));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_c_of_type_AndroidWidgetTextView.getText() + getContext().getString(2131690962));
      QQAppInterface.f(getContext().getString(2131690957));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + paramString + ",recordTime is:" + paramDouble);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel
 * JD-Core Version:    0.7.0.1
 */