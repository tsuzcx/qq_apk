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
import android.view.animation.Animation;
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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.XPanelContainer;

public class PressToSpeakPanel
  extends RelativeLayout
  implements View.OnTouchListener, AudioPanelCallback, IQQRecorder.OnQQRecorderListener
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
  private IPttAudioDataManager jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager;
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
    double d1 = paramInt;
    Double.isNaN(d1);
    if (Math.abs(d1 - paramDouble1) < paramDouble2 * 1.3D) {
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
    TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(2131560928, null);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      localTextView.setTextColor(Color.parseColor("#FF737373"));
    }
    if ((VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isVip()) && (d()))
    {
      Object localObject1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560929, null);
      if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip())
      {
        localObject2 = a(new SpannableString(getContext().getString(2131699377, new Object[] { "5分钟" })), "5分钟");
        ((TextView)((LinearLayout)localObject1).findViewById(2131373195)).setText((CharSequence)localObject2);
        ((ImageView)((LinearLayout)localObject1).findViewById(2131373194)).setImageResource(2130843446);
      }
      else
      {
        localObject2 = a(new SpannableString(getContext().getString(2131699576, new Object[] { "3分钟" })), "3分钟");
        ((TextView)((LinearLayout)localObject1).findViewById(2131373195)).setText((CharSequence)localObject2);
        ((ImageView)((LinearLayout)localObject1).findViewById(2131373194)).setImageResource(2130844067);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView((View)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView(localTextView);
      UiThreadUtil.a(new PressToSpeakPanel.2(this), 2000L);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pref_ppt_hint");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit().putLong("key_last_show_vip_tips", System.currentTimeMillis()).apply();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str = HttpUtil.getNetWorkTypeByStr();
      if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isSVip()) {
        localObject1 = "svip";
      } else {
        localObject1 = "vip";
      }
      VasWebviewUtil.a((String)localObject2, "PanelPrivilegeView", "TailView", "0", 1, 0, 0, str, "", (String)localObject1);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView(localTextView);
    }
    AccessibilityUtil.a(localTextView, false);
  }
  
  private void i()
  {
    this.jdField_g_of_type_Int = (ScreenUtil.getRealWidth(getContext()) / 2);
    double d2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth();
    Object localObject = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen((int[])localObject);
    Double.isNaN(d2);
    double d1 = d2 / 2.0D;
    double d3 = localObject[0];
    Double.isNaN(d3);
    this.jdField_a_of_type_Double = (d3 + d1);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      Double.isNaN(d2);
      d1 = d2 * 0.8D;
    }
    this.jdField_b_of_type_Double = d1;
    d2 = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth();
    localObject = new int[2];
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen((int[])localObject);
    Double.isNaN(d2);
    d1 = d2 / 2.0D;
    d3 = localObject[0];
    Double.isNaN(d3);
    this.jdField_c_of_type_Double = (d3 + d1);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      Double.isNaN(d2);
      d1 = d2 * 0.8D;
    }
    this.jdField_d_of_type_Double = d1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initGetLeveParam centerListerIvX=:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Double);
      ((StringBuilder)localObject).append(",centerDelIvX=:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Double);
      ((StringBuilder)localObject).append(" RListerIv=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Double);
      ((StringBuilder)localObject).append(" RDelIvX=");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Double);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
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
    if (XPanelContainer.jdField_a_of_type_Int != (int)(getContext().getResources().getDisplayMetrics().density * 196.0F))
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
    paramInt = this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager.a(paramInt);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView = ((PttTipSwitchView)findViewById(2131373192));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377835));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368764));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368766));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368767));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377746));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373028));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131366268));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createThemeViewPresenter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setType(1);
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setImageResource(2130844761);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(HardCodeUtil.a(2131708400));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setImageResource(2130844753);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(HardCodeUtil.a(2131708398));
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131377745));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createThemeViewPresenter(this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setType(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(HardCodeUtil.a(2131708397));
    this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368763));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    paramBaseChatPie = paramBaseChatPie.a().getResources();
    if (paramViewGroup2.getVisibility() == 4) {
      setPadding(getPaddingLeft(), getPaddingTop() + AIOUtils.b(12.5F, paramBaseChatPie), getPaddingRight(), getPaddingBottom());
    }
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131167047));
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqPttIPttAudioDataManager = ((IPttUtils)QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
    if (this.jdField_a_of_type_Int == -1)
    {
      paramViewGroup1 = new Rect();
      getWindowVisibleDisplayFrame(paramViewGroup1);
      int j = paramViewGroup1.right / 2;
      int k = AIOUtils.b(75.0F, paramBaseChatPie);
      this.jdField_a_of_type_Int = (j - k);
      if (QLog.isColorLevel())
      {
        paramBaseChatPie = new StringBuilder();
        paramBaseChatPie.append("rect is:");
        paramBaseChatPie.append(paramViewGroup1);
        paramBaseChatPie.append("entirePanelWidth is:");
        paramBaseChatPie.append(j);
        paramBaseChatPie.append(",listenRight is:");
        paramBaseChatPie.append(k);
        paramBaseChatPie.append(",mBasicDistance is:");
        paramBaseChatPie.append(this.jdField_a_of_type_Int);
        QLog.d("AIOAudioPanel", 2, paramBaseChatPie.toString());
      }
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      paramBaseChatPie = paramQQAppInterface.getApp();
      paramViewGroup1 = new StringBuilder();
      paramViewGroup1.append("pref_ppt_hint");
      paramViewGroup1.append(paramQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramBaseChatPie.getSharedPreferences(paramViewGroup1.toString(), 0);
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_ppt_hint", 3);
      this.jdField_c_of_type_Boolean = false;
      setFocusable(false);
      ViewCompat.setImportantForAccessibility(this, 2);
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView, 2);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131689928));
      ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetImageView, new PressToSpeakPanel.1(this));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().isFinishing()) {
      return;
    }
    this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(8);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView;
    int j = 0;
    ((PttTipSwitchView)localObject1).setVisibility(0);
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    if (!((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
    if ((paramBoolean) || (!b()) || (((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b() != 2))
    {
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
              QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      }
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 != null)
      {
        if (((View)localObject2).getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView = null;
      }
    }
    Object localObject2 = (PanelIconLinearLayout)this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject2 != null)
    {
      ((PanelIconLinearLayout)localObject2).setAllAlpha(1.0F);
      ((PanelIconLinearLayout)localObject2).setAllEnable(true);
    }
    int k = this.jdField_c_of_type_AndroidViewViewGroup.getChildCount();
    while (j < k)
    {
      localObject2 = this.jdField_c_of_type_AndroidViewViewGroup.getChildAt(j);
      if (((View)localObject2).getVisibility() != 8)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        ((View)localObject2).startAnimation(localAlphaAnimation);
      }
      j += 1;
    }
  }
  
  public boolean a()
  {
    boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onBackEvent() is called,isRecording is:");
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
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    paramMotionEvent.getRawY();
    int i2 = (int)paramMotionEvent.getRawX();
    int k = 0;
    int j;
    if ((i1 == 0) || (i1 == 2))
    {
      this.jdField_b_of_type_Int = 3;
      int m;
      int n;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        m = a(i2, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
        if (m > 80)
        {
          this.jdField_b_of_type_Int = 1;
          if (this.jdField_f_of_type_Boolean)
          {
            this.jdField_f_of_type_Boolean = false;
            k();
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
          if ((m < 42) && (!this.jdField_f_of_type_Boolean)) {
            this.jdField_f_of_type_Boolean = true;
          }
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
        n = this.h;
        j = m;
        if (m > n) {
          j = n;
        }
        paramMotionEvent.setLevel(j);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        m = a(i2, false, this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView, this.jdField_c_of_type_Double, this.jdField_d_of_type_Double);
        if (m > 80)
        {
          this.jdField_b_of_type_Int = 2;
          if (this.jdField_g_of_type_Boolean)
          {
            this.jdField_g_of_type_Boolean = false;
            k();
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
          if ((m < 42) && (!this.jdField_g_of_type_Boolean)) {
            this.jdField_g_of_type_Boolean = true;
          }
        }
        paramMotionEvent = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
        n = this.h;
        j = m;
        if (m > n) {
          j = n;
        }
        paramMotionEvent.setLevel(j);
      }
    }
    if (i1 == 0) {
      return true;
    }
    if (i1 == 2) {
      return true;
    }
    if ((i1 == 1) || (i1 == 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
      j = this.jdField_b_of_type_Int;
      if (j == 1)
      {
        j = 2;
      }
      else if (j == 2)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A1D5", "0X800A1D5", 1, 0, "", "", "", "");
        if (AppSetting.jdField_d_of_type_Boolean) {
          AccessibilityUtils.a(this.jdField_g_of_type_AndroidViewViewGroup, getContext().getString(2131691107));
        }
        j = 1;
      }
      else
      {
        j = k;
      }
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(j);
    }
    return true;
  }
  
  public void b()
  {
    boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).f(2);
    }
  }
  
  public boolean b()
  {
    RecordParams.RecorderParam localRecorderParam = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    return (((PttWithTextSwitchBean)QConfigManager.a().a(488)).a()) && (localRecorderParam.jdField_c_of_type_Int == 1) && (!((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    boolean bool = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().isFinishing()))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c() != 36)) {
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
    if ((AppSetting.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_ppt_hint", this.jdField_c_of_type_Int).commit();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.prepareRecord() is called,time is:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" PressToSpeakPanel.startRecord() is called, time is ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
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
    Object localObject = new AnimationSet(true);
    ((AnimationSet)localObject).setDuration(150L);
    ((AnimationSet)localObject).setInterpolator(new LinearInterpolator());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.86F, 1.0F, 0.86F, 1.0F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    ((AnimationSet)localObject).addAnimation(localScaleAnimation);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    ((AnimationSet)localObject).setAnimationListener(new PressToSpeakPanel.3(this));
    this.jdField_f_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
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
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
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
    return ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitFailed() is called");
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, true, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.6(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 13, 0, "", "", "", "8.7.0");
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, true, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.8(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 14, 0, "", "", "", "8.7.0");
    paramString = (InputStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(16);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PressToSpeakPanel.onRecorderEnd() is called,path is:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (InputStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(16);
    if (localObject != null) {
      ((InputStatusHelper)localObject).c();
    }
    if (this.jdField_e_of_type_Double < 500.0D)
    {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.10(this, paramString, paramRecorderParam));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 11, 0, String.valueOf((int)this.jdField_e_of_type_Double), "", "", "8.7.0");
      return;
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(1, (int)this.jdField_e_of_type_Double);
    int j = ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("time is:");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Double);
      ((StringBuilder)localObject).append(",fateOfRecorder is:");
      ((StringBuilder)localObject).append(j);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
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
    if (j == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A1D4", "0X800A1D4", 1, 0, "", "", "", "");
      this.jdField_d_of_type_Int += 1;
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, 1, (int)paramDouble, paramRecorderParam, 0, true, 0);
      this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.13(this, paramString));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof PublicAccountChatPie)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005853", "0X8005853", 0, 0, "", "", Double.toString(this.jdField_e_of_type_Double), "", false);
      }
    }
    else
    {
      ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).c(paramString, 1, paramRecorderParam);
      this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.14(this, paramString));
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onRecorderError() is called,path is:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",errorCode is:");
      localStringBuilder.append(paramString2);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString1, false, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.9(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 12, 0, "", "", "", "8.7.0");
    paramString1 = (InputStatusHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(16);
    if (paramString1 != null) {
      paramString1.c();
    }
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onRecorderNotReady() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onRecorderPrepare() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.4(this));
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, true, paramRecorderParam);
    paramString = paramRecorderParam.a;
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b(paramString, (int)paramDouble, paramRecorderParam);
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
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).g(paramInt);
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484C", "0X800484C", 0, 0, "", "", "", "");
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onTouch() is called,action is:");
      localStringBuilder.append(j);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.d();
    int k = paramView.getId();
    boolean bool = false;
    if (k == 2131373028)
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
      else if (j == 2)
      {
        if ((this.jdField_b_of_type_Boolean) && (((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b())) {
          a(paramMotionEvent);
        }
      }
      else if ((j == 3) || (j == 1))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(false);
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          if (((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).b()) {
            a(paramMotionEvent);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
      }
      bool = true;
    }
    return bool;
  }
  
  public void setUseOnce(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel
 * JD-Core Version:    0.7.0.1
 */