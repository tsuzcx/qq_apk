package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.support.v4.view.ViewCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttWithTextSwitchBean;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.ptt.PttAudioDataManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.XPanelContainer;

public class PressToSpeakPanel
  extends RelativeLayout
  implements View.OnTouchListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener
{
  private static boolean jdField_a_of_type_Boolean;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private MoveDistIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private PttTipSwitchView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView;
  private VolumeChangeView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PttAudioDataManager jdField_a_of_type_ComTencentMobileqqPttPttAudioDataManager;
  private double jdField_b_of_type_Double;
  private int jdField_b_of_type_Int = 0;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private MoveDistIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private VolumeChangeView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private boolean jdField_b_of_type_Boolean = false;
  private double jdField_c_of_type_Double;
  private int jdField_c_of_type_Int = 0;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = false;
  private double jdField_d_of_type_Double;
  private int jdField_d_of_type_Int = 0;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private boolean jdField_d_of_type_Boolean = false;
  private double jdField_e_of_type_Double;
  private final int jdField_e_of_type_Int = 80;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private boolean jdField_e_of_type_Boolean = true;
  private final int jdField_f_of_type_Int = 42;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private ViewGroup jdField_g_of_type_AndroidViewViewGroup;
  private boolean jdField_g_of_type_Boolean = true;
  private int h = 100;
  private int i = 0;
  
  public PressToSpeakPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PressToSpeakPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private int a(int paramInt, boolean paramBoolean, View paramView, double paramDouble1, double paramDouble2)
  {
    int j = this.i;
    if (paramView.getVisibility() != 0) {
      return j;
    }
    if ((paramDouble1 == 0.0D) || (paramDouble2 == 0.0D)) {
      i();
    }
    if (paramBoolean)
    {
      if ((paramInt <= paramDouble1) && (paramDouble1 > 0.0D)) {
        return this.h;
      }
      if (paramInt > this.jdField_g_of_type_Int) {
        return this.i;
      }
    }
    else
    {
      if ((paramInt >= paramDouble1) && (paramDouble1 > 0.0D)) {
        return this.h;
      }
      if (paramInt < this.jdField_g_of_type_Int) {
        return this.i;
      }
    }
    if (Math.abs(paramInt - paramDouble1) < 1.3D * paramDouble2) {
      return this.h;
    }
    return this.i;
  }
  
  private boolean d()
  {
    return false;
  }
  
  private void h()
  {
    TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(2131561064, null);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      localTextView.setTextColor(Color.parseColor("#FF737373"));
    }
    Object localObject1;
    Object localObject2;
    if ((VipUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (d()))
    {
      localObject1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131561065, null);
      if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject2 = a(new SpannableString(getContext().getString(2131699272, new Object[] { "5分钟" })), "5分钟");
        ((TextView)((LinearLayout)localObject1).findViewById(2131373620)).setText((CharSequence)localObject2);
        ((ImageView)((LinearLayout)localObject1).findViewById(2131373619)).setImageResource(2130843532);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView((View)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView(localTextView);
        UiThreadUtil.a(new PressToSpeakPanel.2(this), 2000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("pref_ppt_hint" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("key_last_show_vip_tips", System.currentTimeMillis()).apply();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        String str = HttpUtil.getNetWorkTypeByStr();
        if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label349;
        }
        localObject1 = "svip";
        label255:
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "PanelPrivilegeView", "TailView", "0", 1, 0, 0, str, "", (String)localObject1);
      }
    }
    for (;;)
    {
      AccessibilityUtil.a(localTextView, false);
      return;
      localObject2 = a(new SpannableString(getContext().getString(2131699471, new Object[] { "3分钟" })), "3分钟");
      ((TextView)((LinearLayout)localObject1).findViewById(2131373620)).setText((CharSequence)localObject2);
      ((ImageView)((LinearLayout)localObject1).findViewById(2131373619)).setImageResource(2130844164);
      break;
      label349:
      localObject1 = "vip";
      break label255;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView(localTextView);
    }
  }
  
  private void i()
  {
    this.jdField_g_of_type_Int = (ScreenUtil.getRealWidth(getContext()) / 2);
    double d1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth();
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen(arrayOfInt);
    double d2 = d1 / 2.0D;
    this.jdField_a_of_type_Double = (arrayOfInt[0] + d2);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      d1 *= 0.8D;
      this.jdField_b_of_type_Double = d1;
      d1 = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth();
      arrayOfInt = new int[2];
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen(arrayOfInt);
      d2 = d1 / 2.0D;
      this.jdField_c_of_type_Double = (arrayOfInt[0] + d2);
      if (!AppSetting.jdField_d_of_type_Boolean) {
        break label212;
      }
    }
    label212:
    for (d1 *= 0.8D;; d1 /= 2.0D)
    {
      this.jdField_d_of_type_Double = d1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "initGetLeveParam centerListerIvX=:" + this.jdField_a_of_type_Double + ",centerDelIvX=:" + this.jdField_c_of_type_Double + " RListerIv=" + this.jdField_b_of_type_Double + " RDelIvX=" + this.jdField_d_of_type_Double);
      }
      return;
      d1 /= 2.0D;
      break;
    }
  }
  
  private void j()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
  }
  
  private void k()
  {
    ((Vibrator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("vibrator")).vibrate(50L);
  }
  
  private void l()
  {
    if (XPanelContainer.jdField_a_of_type_Int != (int)(196.0F * getContext().getResources().getDisplayMetrics().density))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.topMargin = ScreenUtil.dip2px(30.0F);
      this.jdField_f_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.topMargin = ScreenUtil.dip2px(42.0F);
    this.jdField_f_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public SpannableString a(SpannableString paramSpannableString, String paramString)
  {
    int j = paramSpannableString.toString().indexOf(paramString);
    if (j < 0) {
      return paramSpannableString;
    }
    paramSpannableString.setSpan(new ForegroundColorSpan(-1145334), j, paramString.length() + j, 33);
    return paramSpannableString;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqPttPttAudioDataManager.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_g_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    paramAudioPanel.setSpeakPanel(this);
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup4;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView = ((PttTipSwitchView)findViewById(2131373617));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378421));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369042));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369044));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131369045));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378337));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373450));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131366385));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setType(1);
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setImageResource(2130844885);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(HardCodeUtil.a(2131708391));
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131378336));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setType(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(HardCodeUtil.a(2131708388));
      this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369041));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      paramBaseChatPie = paramBaseChatPie.a().getResources();
      if (paramViewGroup2.getVisibility() == 4) {
        setPadding(getPaddingLeft(), getPaddingTop() + AIOUtils.a(12.5F, paramBaseChatPie), getPaddingRight(), getPaddingBottom());
      }
      if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167024));
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167024));
      }
      h();
      this.jdField_a_of_type_ComTencentMobileqqPttPttAudioDataManager = new PttAudioDataManager();
      if (this.jdField_a_of_type_Int == -1)
      {
        paramViewGroup1 = new Rect();
        getWindowVisibleDisplayFrame(paramViewGroup1);
        int j = paramViewGroup1.right / 2;
        int k = AIOUtils.a(75.0F, paramBaseChatPie);
        this.jdField_a_of_type_Int = (j - k);
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "rect is:" + paramViewGroup1 + "entirePanelWidth is:" + j + ",listenRight is:" + k + ",mBasicDistance is:" + this.jdField_a_of_type_Int);
        }
      }
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("pref_ppt_hint" + paramQQAppInterface.getCurrentAccountUin(), 0);
        this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_ppt_hint", 3);
        this.jdField_c_of_type_Boolean = false;
        setFocusable(false);
        ViewCompat.setImportantForAccessibility(this, 2);
        ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView, 2);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131690013));
        ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetImageView, new PressToSpeakPanel.1(this));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setImageResource(2130844877);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(HardCodeUtil.a(2131708389));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().isFinishing()) {}
    for (;;)
    {
      return;
      this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.F) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
      if (((!paramBoolean) && (b()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d() == 2)) || ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))) {}
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
        Object localObject = (PanelIconLinearLayout)this.jdField_a_of_type_AndroidViewViewGroup;
        if (localObject != null)
        {
          ((PanelIconLinearLayout)localObject).setAllAlpha(1.0F);
          ((PanelIconLinearLayout)localObject).setAllEnable(true);
        }
        int k = this.jdField_c_of_type_AndroidViewViewGroup.getChildCount();
        int j = 0;
        while (j < k)
        {
          localObject = this.jdField_c_of_type_AndroidViewViewGroup.getChildAt(j);
          if (((View)localObject).getVisibility() != 8) {
            break label309;
          }
          j += 1;
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
            label309:
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
            localAlphaAnimation.setDuration(0L);
            localAlphaAnimation.setInterpolator(new LinearInterpolator());
            localException.startAnimation(localAlphaAnimation);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    int n = (int)paramMotionEvent.getRawX();
    int k;
    if ((m == 0) || (m == 2))
    {
      this.jdField_b_of_type_Int = 3;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        k = a(n, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
        if (k <= 80) {
          break label206;
        }
        this.jdField_b_of_type_Int = 1;
        if (this.jdField_f_of_type_Boolean)
        {
          this.jdField_f_of_type_Boolean = false;
          k();
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
        j = k;
        if (k > this.h) {
          j = this.h;
        }
        paramMotionEvent.setLevel(j);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        k = a(n, false, this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView, this.jdField_c_of_type_Double, this.jdField_d_of_type_Double);
        if (k <= 80) {
          break label243;
        }
        this.jdField_b_of_type_Int = 2;
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_g_of_type_Boolean = false;
          k();
        }
        label174:
        paramMotionEvent = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
        j = k;
        if (k > this.h) {
          j = this.h;
        }
        paramMotionEvent.setLevel(j);
      }
    }
    if (m == 0) {}
    label206:
    label243:
    while ((m == 2) || ((m != 1) && (m != 3)))
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      if ((k >= 42) || (this.jdField_f_of_type_Boolean)) {
        break;
      }
      this.jdField_f_of_type_Boolean = true;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      if ((k >= 42) || (this.jdField_g_of_type_Boolean)) {
        break label174;
      }
      this.jdField_g_of_type_Boolean = true;
      break label174;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    j = 0;
    if (this.jdField_b_of_type_Int == 1) {
      j = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i(j);
      break;
      if (this.jdField_b_of_type_Int == 2)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A1D5", "0X800A1D5", 1, 0, "", "", "", "");
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          AccessibilityUtils.a(this.jdField_g_of_type_AndroidViewViewGroup, getContext().getString(2131691186));
          j = 1;
        }
      }
      else
      {
        if (this.jdField_b_of_type_Int != 3) {
          continue;
        }
        j = 0;
        continue;
      }
      j = 1;
    }
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i(2);
    }
  }
  
  public boolean b()
  {
    RecordParams.RecorderParam localRecorderParam = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    return (((PttWithTextSwitchBean)QConfigManager.a().a(488)).a()) && (localRecorderParam.jdField_c_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.F);
  }
  
  public void c()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().isFinishing()) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g() != 36)) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.i(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.j(1);
    }
    if ((AppSetting.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_ppt_hint", this.jdField_c_of_type_Int).commit();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
    }
    AIOUtils.o = true;
    this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, " PressToSpeakPanel.startRecord() is called, time is " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a();
    this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(150L);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.86F, 1.0F, 0.86F, 1.0F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setAnimationListener(new PressToSpeakPanel.3(this));
    this.jdField_f_of_type_AndroidViewViewGroup.startAnimation(localAnimationSet);
  }
  
  void f()
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
    localAnimationSet.setAnimationListener(new PressToSpeakPanel.16(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, true, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.6(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 13, 0, "", "", "", "8.5.5");
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, true, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.8(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 14, 0, "", "", "", "8.5.5");
    paramString = (InputStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(16);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.c();
    }
    if (this.jdField_e_of_type_Double < 500.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.10(this, paramString, paramRecorderParam));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 11, 0, String.valueOf((int)this.jdField_e_of_type_Double), "", "", "8.5.5");
    }
    do
    {
      return;
      PttInfoCollector.reportGcAndMemoryUse(1, (int)this.jdField_e_of_type_Double);
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "time is:" + this.jdField_e_of_type_Double + ",fateOfRecorder is:" + j);
      }
      if (j == 2)
      {
        if (b())
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.11(this, paramString, paramRecorderParam, paramDouble));
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800A1D6", "0X800A1D6", 1, 0, "", "", "", "");
        this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.12(this, paramString, paramRecorderParam));
        return;
      }
      if (j != 0) {
        break;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A1D4", "0X800A1D4", 1, 0, "", "", "", "");
      this.jdField_d_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, 1, (int)paramDouble, paramRecorderParam, 0, true, 0);
      this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.13(this, paramString));
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005853", "0X8005853", 0, 0, "", "", Double.toString(this.jdField_e_of_type_Double), "", false);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(paramString, 1, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.14(this, paramString));
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderError() is called,path is:" + paramString1 + ",errorCode is:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString1, false, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.9(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 12, 0, "", "", "", "8.5.5");
    paramString1 = (InputStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(16);
    if (paramString1 != null) {
      paramString1.c();
    }
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderPrepare() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.4(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, true, paramRecorderParam);
    if (paramRecorderParam.a == null) {}
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramString, (int)paramDouble, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.7(this, paramInt2, paramDouble));
    this.jdField_e_of_type_Double = paramDouble;
  }
  
  public int onRecorderStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    if (this.jdField_e_of_type_Boolean)
    {
      k();
      this.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.5(this));
    PttInfoCollector.reportCostUntilPrepare(1);
    this.jdField_e_of_type_Double = 0.0D;
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.a();
    }
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l(paramInt);
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484C", "0X800484C", 0, 0, "", "", "", "");
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onTouch() is called,action is:" + j);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.d();
    if (paramView.getId() == 2131373450)
    {
      if (j == 0)
      {
        l();
        ReportController.b(null, "dc00898", "", "", "0X800A1D3", "0X800A1D3", 1, 0, "", "", "", "");
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(true);
        j();
        i();
        paramView = new PressToSpeakPanel.15(this, paramMotionEvent);
        paramView = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramView);
        paramView.what = 1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 150L);
      }
      do
      {
        do
        {
          do
          {
            return true;
            if (j != 2) {
              break;
            }
          } while ((!this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l()));
          a(paramMotionEvent);
          return true;
        } while ((j != 3) && (j != 1));
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(false);
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_Boolean = false;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l());
      a(paramMotionEvent);
      return true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      return true;
    }
    return false;
  }
  
  public void setUseOnce(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel
 * JD-Core Version:    0.7.0.1
 */