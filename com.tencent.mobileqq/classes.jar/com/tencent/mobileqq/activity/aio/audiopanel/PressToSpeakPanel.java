package com.tencent.mobileqq.activity.aio.audiopanel;

import actj;
import adbf;
import adbp;
import adbq;
import adbr;
import aert;
import ajya;
import ampl;
import amug;
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
import android.widget.TextView;
import ardt;
import avbs;
import axlk;
import axqy;
import aytn;
import baww;
import bbiy;
import bfny;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import naj;
import nol;

public class PressToSpeakPanel
  extends RelativeLayout
  implements adbf, View.OnTouchListener, bbiy
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
  private avbs jdField_a_of_type_Avbs;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private MoveDistIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private PttTipSwitchView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView;
  private VolumeChangeView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private int jdField_b_of_type_Int = 0;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private MoveDistIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private VolumeChangeView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private boolean jdField_d_of_type_Boolean;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private boolean jdField_e_of_type_Boolean = true;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private boolean jdField_f_of_type_Boolean = true;
  private ViewGroup jdField_g_of_type_AndroidViewViewGroup;
  private boolean jdField_g_of_type_Boolean = true;
  
  public PressToSpeakPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PressToSpeakPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private double a(int paramInt1, int paramInt2, View paramView)
  {
    if (paramView.getVisibility() != 0) {
      return -1.0D;
    }
    paramInt2 = axlk.e(getContext()) / 2;
    double d1 = paramView.getWidth();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    d1 /= 2.0D;
    double d2 = arrayOfInt[0];
    return Math.abs(paramInt1 - (d1 + d2));
  }
  
  private boolean d()
  {
    return false;
  }
  
  private void i()
  {
    TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(2131560616, null);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      localTextView.setTextColor(Color.parseColor("#FF737373"));
    }
    Object localObject1;
    Object localObject2;
    if ((VipUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (d()))
    {
      localObject1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560617, null);
      if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject2 = a(new SpannableString(getContext().getString(2131699551, new Object[] { "5分钟" })), "5分钟");
        ((TextView)((LinearLayout)localObject1).findViewById(2131372073)).setText((CharSequence)localObject2);
        ((ImageView)((LinearLayout)localObject1).findViewById(2131372072)).setImageResource(2130842701);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView((View)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView(localTextView);
        bfny.a(new PressToSpeakPanel.2(this), 2000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("pref_ppt_hint" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("key_last_show_vip_tips", System.currentTimeMillis()).apply();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        String str = naj.a();
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
      baww.a(localTextView, false);
      return;
      localObject2 = a(new SpannableString(getContext().getString(2131699624, new Object[] { "3分钟" })), "3分钟");
      ((TextView)((LinearLayout)localObject1).findViewById(2131372073)).setText((CharSequence)localObject2);
      ((ImageView)((LinearLayout)localObject1).findViewById(2131372072)).setImageResource(2130843315);
      break;
      label349:
      localObject1 = "vip";
      break label255;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.addView(localTextView);
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
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.5(this));
    aytn.b(1);
    this.jdField_a_of_type_Double = 0.0D;
    ardt localardt = (ardt)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(16);
    if (localardt != null) {
      localardt.a();
    }
    return 250;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e();
  }
  
  public SpannableString a(SpannableString paramSpannableString, String paramString)
  {
    int i = paramSpannableString.toString().indexOf(paramString);
    if (i < 0) {
      return paramSpannableString;
    }
    paramSpannableString.setSpan(new ForegroundColorSpan(-1145334), i, paramString.length() + i, 33);
    return paramSpannableString;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitSuccess() is called");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(paramInt);
    if (paramInt == 1) {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484C", "0X800484C", 0, 0, "", "", "", "");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_g_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    paramAudioPanel.setSpeakPanel(this);
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup4;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView = ((PttTipSwitchView)findViewById(2131372070));
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376441));
    this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368077));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368079));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView = ((VolumeChangeView)findViewById(2131368080));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376358));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371903));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131365705));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setType(1);
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setImageResource(2130843959);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(ajya.a(2131708416));
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131376357));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setType(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(ajya.a(2131708413));
      this.jdField_f_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368076));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      paramBaseChatPie = paramBaseChatPie.a().getResources();
      if (paramViewGroup2.getVisibility() == 4) {
        setPadding(getPaddingLeft(), getPaddingTop() + actj.a(12.5F, paramBaseChatPie), getPaddingRight(), getPaddingBottom());
      }
      if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4A4A4A"));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166845));
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setColor(getResources().getColor(2131166845));
      }
      i();
      this.jdField_a_of_type_Avbs = new avbs();
      if (this.jdField_a_of_type_Int == -1)
      {
        paramViewGroup1 = new Rect();
        getWindowVisibleDisplayFrame(paramViewGroup1);
        int i = paramViewGroup1.right / 2;
        int j = actj.a(75.0F, paramBaseChatPie);
        this.jdField_a_of_type_Int = (i - j);
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "rect is:" + paramViewGroup1 + "entirePanelWidth is:" + i + ",listenRight is:" + j + ",mBasicDistance is:" + this.jdField_a_of_type_Int);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131689985));
        ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetImageView, new adbp(this));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setImageResource(2130843951);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setContentDescription(ajya.a(2131708414));
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderPrepare() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.4(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, paramRecorderParam);
    if (paramRecorderParam.a == null) {}
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    ardt localardt = (ardt)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(16);
    if (localardt != null) {
      localardt.c();
    }
    if (this.jdField_a_of_type_Double < 500.0D)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.10(this, paramString, paramRecorderParam));
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 11, 0, String.valueOf((int)this.jdField_a_of_type_Double), "", "", "8.3.0");
    }
    do
    {
      return;
      aytn.a(1, (int)this.jdField_a_of_type_Double);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "time is:" + this.jdField_a_of_type_Double + ",fateOfRecorder is:" + i);
      }
      if (i == 2)
      {
        if (b())
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.11(this, paramString, paramRecorderParam, paramDouble));
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.12(this, paramString, paramRecorderParam));
        return;
      }
      if (i != 0) {
        break;
      }
      this.jdField_d_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, 1, (int)paramDouble, paramRecorderParam, 0, true, 0);
      this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.13(this, paramString));
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aert));
    nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005853", "0X8005853", 0, 0, "", "", Double.toString(this.jdField_a_of_type_Double), "", false);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramString, 1, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.14(this, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderError() is called,path is:" + paramString1 + ",errorCode is:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString1, false, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.9(this));
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 12, 0, "", "", "", "8.3.0");
    paramString1 = (ardt)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(16);
    if (paramString1 != null) {
      paramString1.c();
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, (int)paramDouble, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.7(this, paramInt2, paramDouble));
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    int m = (int)paramMotionEvent.getRawY();
    int n = (int)paramMotionEvent.getRawX();
    double d1;
    int j;
    if ((k == 0) || (k == 2))
    {
      this.jdField_b_of_type_Int = 3;
      double d2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth();
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break label478;
        }
        d1 = i * 0.5D;
        d2 = a(n, m, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView);
        if (QLog.isDevelopLevel()) {
          QLog.d("MoveDistIndicateView", 4, "distToListenView=" + d2 + " r=" + d1 + " BasicDistance is:" + this.jdField_a_of_type_Int);
        }
        if ((d2 >= 0.0D) && (d2 <= this.jdField_a_of_type_Int + d1))
        {
          if (d2 <= d1) {
            this.jdField_b_of_type_Int = 1;
          }
          i = (int)(100.0D - (d2 - d1) / this.jdField_a_of_type_Int * 100.0D);
          if (this.jdField_b_of_type_Int != 1) {
            break label489;
          }
          j = 100;
          i = j;
          if (this.jdField_f_of_type_Boolean)
          {
            this.jdField_f_of_type_Boolean = false;
            k();
            i = j;
          }
          label229:
          j = i;
          if (i < 42)
          {
            if (!this.jdField_f_of_type_Boolean) {
              this.jdField_f_of_type_Boolean = true;
            }
            j = 42;
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
          i = j;
          if (j > 100) {
            i = 100;
          }
          paramMotionEvent.setLevel(i);
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        i = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth();
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break label524;
        }
        d1 = i * 1.2D;
        label315:
        d2 = a(n, m, this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView);
        if ((d2 >= 0.0D) && (d2 <= this.jdField_a_of_type_Int + d1))
        {
          if (d2 <= d1) {
            this.jdField_b_of_type_Int = 2;
          }
          i = (int)(100.0D - (d2 - d1) / this.jdField_a_of_type_Int * 100.0D);
          if (this.jdField_b_of_type_Int != 2) {
            break label535;
          }
          j = 100;
          i = j;
          if (this.jdField_g_of_type_Boolean)
          {
            this.jdField_g_of_type_Boolean = false;
            k();
            i = j;
          }
          label418:
          j = i;
          if (i < 42)
          {
            if (!this.jdField_g_of_type_Boolean) {
              this.jdField_g_of_type_Boolean = true;
            }
            j = 42;
          }
          paramMotionEvent = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
          i = j;
          if (j > 100) {
            i = 100;
          }
          paramMotionEvent.setLevel(i);
        }
      }
    }
    if (k == 0) {}
    label478:
    label489:
    while ((k == 2) || ((k != 1) && (k != 3)))
    {
      return true;
      d1 = i / 2.0D;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setSelected(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setPressed(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      break label229;
      d1 = i / 2.0D;
      break label315;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(0);
      break label418;
    }
    label524:
    label535:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    int i = 0;
    if (this.jdField_b_of_type_Int == 1) {
      i = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(i);
      break;
      if (this.jdField_b_of_type_Int == 2)
      {
        j = 1;
        i = j;
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          baww.a(this.jdField_g_of_type_AndroidViewViewGroup, getContext().getString(2131691097));
          i = j;
        }
      }
      else if (this.jdField_b_of_type_Int == 3)
      {
        i = 0;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) {}
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
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.K) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
      if (((b()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d() == 2)) || ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))) {}
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
        int j = this.jdField_c_of_type_AndroidViewViewGroup.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject = this.jdField_c_of_type_AndroidViewViewGroup.getChildAt(i);
          if (((View)localObject).getVisibility() != 8) {
            break label297;
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
            label297:
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
            localAlphaAnimation.setDuration(0L);
            localAlphaAnimation.setInterpolator(new LinearInterpolator());
            localException.startAnimation(localAlphaAnimation);
          }
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "level = " + paramInt);
    }
    paramInt = this.jdField_a_of_type_Avbs.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.a(paramInt);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.8(this));
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 14, 0, "", "", "", "8.3.0");
    paramString = (ardt)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(16);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  public boolean b()
  {
    QQRecorder.RecorderParam localRecorderParam = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    return (((amug)ampl.a().a(488)).a()) && (localRecorderParam.jdField_c_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.K);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
    }
    actj.n = true;
    this.jdField_f_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPttTipSwitchView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeChangeView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, true, true, paramRecorderParam);
    this.jdField_a_of_type_AndroidOsHandler.post(new PressToSpeakPanel.6(this));
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A17", "0X8005A17", 13, 0, "", "", "", "8.3.0");
  }
  
  public void d()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(2);
    }
  }
  
  public void e()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f() != 36)) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.k(1);
    }
    if ((AppSetting.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_ppt_hint", this.jdField_c_of_type_Int).commit();
    }
  }
  
  public void f()
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
    localAnimationSet.setAnimationListener(new adbr(this));
    this.jdField_f_of_type_AndroidViewViewGroup.startAnimation(localAnimationSet);
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
    localAnimationSet.setAnimationListener(new adbq(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onTouch() is called,action is:" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.d();
    if (paramView.getId() == 2131371903)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(true);
        j();
        if (this.jdField_e_of_type_Boolean)
        {
          k();
          this.jdField_e_of_type_Boolean = false;
        }
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
            if (i != 2) {
              break;
            }
          } while ((!this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n()));
          a(paramMotionEvent);
          return true;
        } while ((i != 3) && (i != 1));
        this.jdField_a_of_type_AndroidWidgetImageView.setPressed(false);
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_Boolean = false;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel
 * JD-Core Version:    0.7.0.1
 */