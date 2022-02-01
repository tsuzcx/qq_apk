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
import com.tencent.mobileqq.utils.QQTheme;
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
  private static boolean v;
  private boolean A = false;
  private boolean B = false;
  private int C = 0;
  private IPttAudioDataManager D;
  private boolean E = true;
  private boolean F = true;
  private boolean G = true;
  private final int H = 80;
  private final int I = 42;
  private int J;
  private double K;
  private double L;
  private double M;
  private double N;
  private int O = 100;
  private int P = 0;
  private double Q;
  protected ViewGroup a;
  private QQAppInterface b;
  private BaseChatPie c;
  private ViewGroup d;
  private AudioPanel e;
  private ViewGroup f;
  private PttTipSwitchView g;
  private ViewGroup h;
  private ViewGroup i;
  private VolumeChangeView j;
  private VolumeChangeView k;
  private TextView l;
  private ImageView m;
  private MoveDistIndicateView n;
  private MoveDistIndicateView o;
  private ViewGroup p;
  private PopupWindow q;
  private View r;
  private int s = -1;
  private Handler t;
  private ViewGroup u;
  private boolean w = false;
  private int x = 0;
  private SharedPreferences y;
  private int z = 0;
  
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
    int i1 = this.P;
    if (paramView.getVisibility() != 0) {
      return i1;
    }
    if ((paramDouble1 == 0.0D) || (paramDouble2 == 0.0D)) {
      m();
    }
    if (paramBoolean)
    {
      if ((paramInt <= paramDouble1) && (paramDouble1 > 0.0D)) {
        return this.O;
      }
      if (paramInt > this.J) {
        return this.P;
      }
    }
    else
    {
      if ((paramInt >= paramDouble1) && (paramDouble1 > 0.0D)) {
        return this.O;
      }
      if (paramInt < this.J) {
        return this.P;
      }
    }
    double d1 = paramInt;
    Double.isNaN(d1);
    if (Math.abs(d1 - paramDouble1) < paramDouble2 * 1.3D) {
      return this.O;
    }
    return this.P;
  }
  
  private void k()
  {
    TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(2131627269, null);
    if (ThemeUtil.isNowThemeIsNight(this.b, false, null)) {
      localTextView.setTextColor(Color.parseColor("#FF737373"));
    }
    if ((VasUtil.b(this.b).getVipStatus().isVip()) && (l()))
    {
      Object localObject1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131627270, null);
      if (VasUtil.b(this.b).getVipStatus().isSVip())
      {
        localObject2 = a(new SpannableString(getContext().getString(2131897408, new Object[] { "5分钟" })), "5分钟");
        ((TextView)((LinearLayout)localObject1).findViewById(2131440804)).setText((CharSequence)localObject2);
        ((ImageView)((LinearLayout)localObject1).findViewById(2131440803)).setImageResource(2130844400);
      }
      else
      {
        localObject2 = a(new SpannableString(getContext().getString(2131897607, new Object[] { "3分钟" })), "3分钟");
        ((TextView)((LinearLayout)localObject1).findViewById(2131440804)).setText((CharSequence)localObject2);
        ((ImageView)((LinearLayout)localObject1).findViewById(2131440803)).setImageResource(2130845022);
      }
      this.g.addView((View)localObject1);
      this.g.addView(localTextView);
      UiThreadUtil.a(new PressToSpeakPanel.2(this), 2000L);
      localObject1 = this.b.getApp();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pref_ppt_hint");
      ((StringBuilder)localObject2).append(this.b.getCurrentAccountUin());
      ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit().putLong("key_last_show_vip_tips", System.currentTimeMillis()).apply();
      localObject2 = this.b.getCurrentAccountUin();
      String str = HttpUtil.getNetWorkTypeByStr();
      if (VasUtil.b(this.b).getVipStatus().isSVip()) {
        localObject1 = "svip";
      } else {
        localObject1 = "vip";
      }
      VasWebviewUtil.a((String)localObject2, "PanelPrivilegeView", "TailView", "0", 1, 0, 0, str, "", (String)localObject1);
    }
    else
    {
      this.g.addView(localTextView);
    }
    AccessibilityUtil.a(localTextView, false);
  }
  
  private boolean l()
  {
    return false;
  }
  
  private void m()
  {
    this.J = (ScreenUtil.getRealWidth(getContext()) / 2);
    double d2 = this.n.getWidth();
    Object localObject = new int[2];
    this.n.getLocationOnScreen((int[])localObject);
    Double.isNaN(d2);
    double d1 = d2 / 2.0D;
    double d3 = localObject[0];
    Double.isNaN(d3);
    this.K = (d3 + d1);
    if (AppSetting.e)
    {
      Double.isNaN(d2);
      d1 = d2 * 0.8D;
    }
    this.L = d1;
    d2 = this.o.getWidth();
    localObject = new int[2];
    this.o.getLocationOnScreen((int[])localObject);
    Double.isNaN(d2);
    d1 = d2 / 2.0D;
    d3 = localObject[0];
    Double.isNaN(d3);
    this.M = (d3 + d1);
    if (AppSetting.e)
    {
      Double.isNaN(d2);
      d1 = d2 * 0.8D;
    }
    this.N = d1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initGetLeveParam centerListerIvX=:");
      ((StringBuilder)localObject).append(this.K);
      ((StringBuilder)localObject).append(",centerDelIvX=:");
      ((StringBuilder)localObject).append(this.M);
      ((StringBuilder)localObject).append(" RListerIv=");
      ((StringBuilder)localObject).append(this.L);
      ((StringBuilder)localObject).append(" RDelIvX=");
      ((StringBuilder)localObject).append(this.N);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void n()
  {
    this.E = true;
    this.F = true;
    this.G = true;
  }
  
  private void o()
  {
    ((Vibrator)this.b.getApp().getSystemService("vibrator")).vibrate(50L);
  }
  
  private void p()
  {
    if (XPanelContainer.a != (int)(getContext().getResources().getDisplayMetrics().density * 196.0F))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
      localLayoutParams.topMargin = ScreenUtil.dip2px(30.0F);
      this.p.setLayoutParams(localLayoutParams);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    localLayoutParams.topMargin = ScreenUtil.dip2px(42.0F);
    this.p.setLayoutParams(localLayoutParams);
  }
  
  public SpannableString a(SpannableString paramSpannableString, String paramString)
  {
    int i1 = paramSpannableString.toString().indexOf(paramString);
    if (i1 < 0) {
      return paramSpannableString;
    }
    paramSpannableString.setSpan(new ForegroundColorSpan(-1145334), i1, paramString.length() + i1, 33);
    return paramSpannableString;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt)
  {
    paramInt = this.D.a(paramInt);
    this.j.a(paramInt);
    this.k.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4)
  {
    this.b = paramQQAppInterface;
    this.c = paramBaseChatPie;
    this.u = paramViewGroup1;
    this.e = paramAudioPanel;
    paramAudioPanel.setSpeakPanel(this);
    this.d = paramViewGroup2;
    this.f = paramViewGroup3;
    this.a = paramViewGroup4;
    this.t = new Handler(Looper.getMainLooper());
    this.g = ((PttTipSwitchView)findViewById(2131440801));
    this.h = ((ViewGroup)findViewById(2131446307));
    this.i = ((ViewGroup)findViewById(2131435682));
    this.j = ((VolumeChangeView)findViewById(2131435684));
    this.k = ((VolumeChangeView)findViewById(2131435685));
    this.l = ((TextView)findViewById(2131446204));
    this.m = ((ImageView)findViewById(2131440607));
    this.n = ((MoveDistIndicateView)findViewById(2131432568));
    this.n.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createThemeViewPresenter(this.n));
    this.n.setType(1);
    if (i())
    {
      this.n.setImageResource(2130846195);
      this.n.setContentDescription(HardCodeUtil.a(2131906188));
    }
    else
    {
      this.n.setImageResource(2130846186);
      this.n.setContentDescription(HardCodeUtil.a(2131906186));
    }
    this.o = ((MoveDistIndicateView)findViewById(2131446203));
    this.o.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createThemeViewPresenter(this.o));
    this.o.setType(0);
    this.o.setContentDescription(HardCodeUtil.a(2131906185));
    this.p = ((ViewGroup)findViewById(2131435681));
    this.m.setOnTouchListener(this);
    paramBaseChatPie = paramBaseChatPie.aX().getResources();
    if (paramViewGroup2.getVisibility() == 4) {
      setPadding(getPaddingLeft(), getPaddingTop() + AIOUtils.b(12.5F, paramBaseChatPie), getPaddingRight(), getPaddingBottom());
    }
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.l.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.j.setColor(getResources().getColor(2131167984));
      this.k.setColor(getResources().getColor(2131167984));
    }
    if (QQTheme.isNowThemeSimpleNight()) {
      this.m.setImageResource(2130851925);
    } else {
      this.m.setImageResource(2130851924);
    }
    k();
    this.D = ((IPttUtils)QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
    if (this.s == -1)
    {
      paramViewGroup1 = new Rect();
      getWindowVisibleDisplayFrame(paramViewGroup1);
      int i1 = paramViewGroup1.right / 2;
      int i2 = AIOUtils.b(75.0F, paramBaseChatPie);
      this.s = (i1 - i2);
      if (QLog.isColorLevel())
      {
        paramBaseChatPie = new StringBuilder();
        paramBaseChatPie.append("rect is:");
        paramBaseChatPie.append(paramViewGroup1);
        paramBaseChatPie.append("entirePanelWidth is:");
        paramBaseChatPie.append(i1);
        paramBaseChatPie.append(",listenRight is:");
        paramBaseChatPie.append(i2);
        paramBaseChatPie.append(",mBasicDistance is:");
        paramBaseChatPie.append(this.s);
        QLog.d("AIOAudioPanel", 2, paramBaseChatPie.toString());
      }
    }
    if (AppSetting.e)
    {
      paramBaseChatPie = paramQQAppInterface.getApp();
      paramViewGroup1 = new StringBuilder();
      paramViewGroup1.append("pref_ppt_hint");
      paramViewGroup1.append(paramQQAppInterface.getCurrentAccountUin());
      this.y = paramBaseChatPie.getSharedPreferences(paramViewGroup1.toString(), 0);
      this.z = this.y.getInt("key_ppt_hint", 3);
      this.A = false;
      setFocusable(false);
      ViewCompat.setImportantForAccessibility(this, 2);
      ViewCompat.setImportantForAccessibility(this.g, 2);
      this.m.setContentDescription(getContext().getString(2131886569));
      ViewCompat.setAccessibilityDelegate(this.m, new PressToSpeakPanel.1(this));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    if (this.c.aX().isFinishing()) {
      return;
    }
    this.p.setVisibility(8);
    Object localObject1 = this.g;
    int i1 = 0;
    ((PttTipSwitchView)localObject1).setVisibility(0);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.m.setVisibility(0);
    this.l.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0D));
    this.j.setVisibility(8);
    this.k.setVisibility(8);
    if (!((ReceiptHelper)this.c.q(118)).a) {
      this.d.setVisibility(0);
    }
    this.e.setStatus(1);
    if ((paramBoolean) || (!i()) || (((AudioPanelAioHelper)this.c.q(128)).h() != 2))
    {
      localObject1 = this.q;
      if (localObject1 != null)
      {
        if (((PopupWindow)localObject1).isShowing()) {
          try
          {
            this.q.dismiss();
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
            }
          }
        }
        this.q = null;
      }
      localObject2 = this.r;
      if (localObject2 != null)
      {
        if (((View)localObject2).getParent() != null) {
          ((ViewGroup)this.r.getParent()).removeView(this.r);
        }
        this.r = null;
      }
    }
    Object localObject2 = (PanelIconLinearLayout)this.a;
    if (localObject2 != null)
    {
      ((PanelIconLinearLayout)localObject2).setAllAlpha(1.0F);
      ((PanelIconLinearLayout)localObject2).setAllEnable(true);
    }
    int i2 = this.f.getChildCount();
    while (i1 < i2)
    {
      localObject2 = this.f.getChildAt(i1);
      if (((View)localObject2).getVisibility() != 8)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        ((View)localObject2).startAnimation(localAlphaAnimation);
      }
      i1 += 1;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i5 = paramMotionEvent.getAction();
    paramMotionEvent.getRawY();
    int i6 = (int)paramMotionEvent.getRawX();
    int i2 = 0;
    int i1;
    if ((i5 == 0) || (i5 == 2))
    {
      this.x = 3;
      int i3;
      int i4;
      if (this.n.getVisibility() == 0)
      {
        i3 = a(i6, true, this.n, this.K, this.L);
        if (i3 > 80)
        {
          this.x = 1;
          if (this.F)
          {
            this.F = false;
            o();
          }
        }
        else
        {
          this.j.setVisibility(0);
          this.k.setVisibility(0);
          if ((i3 < 42) && (!this.F)) {
            this.F = true;
          }
        }
        paramMotionEvent = this.n;
        i4 = this.O;
        i1 = i3;
        if (i3 > i4) {
          i1 = i4;
        }
        paramMotionEvent.setLevel(i1);
      }
      if (this.o.getVisibility() == 0)
      {
        i3 = a(i6, false, this.o, this.M, this.N);
        if (i3 > 80)
        {
          this.x = 2;
          if (this.G)
          {
            this.G = false;
            o();
          }
        }
        else
        {
          this.j.setVisibility(0);
          this.k.setVisibility(0);
          if ((i3 < 42) && (!this.G)) {
            this.G = true;
          }
        }
        paramMotionEvent = this.o;
        i4 = this.O;
        i1 = i3;
        if (i3 > i4) {
          i1 = i4;
        }
        paramMotionEvent.setLevel(i1);
      }
    }
    if (i5 == 0) {
      return true;
    }
    if (i5 == 2) {
      return true;
    }
    if ((i5 == 1) || (i5 == 3))
    {
      this.n.setLevel(0);
      this.o.setLevel(0);
      this.j.setVisibility(8);
      this.k.setVisibility(8);
      i1 = this.x;
      if (i1 == 1)
      {
        i1 = 2;
      }
      else if (i1 == 2)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A1D5", "0X800A1D5", 1, 0, "", "", "", "");
        if (AppSetting.e) {
          AccessibilityUtils.a(this.u, getContext().getString(2131888053));
        }
        i1 = 1;
      }
      else
      {
        i1 = i2;
      }
      ((AudioPanelAioHelper)this.c.q(128)).g(i1);
    }
    return true;
  }
  
  public boolean b()
  {
    boolean bool = ((AudioPanelAioHelper)this.c.q(128)).g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onBackEvent() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ((AudioPanelAioHelper)this.c.q(128)).g(2);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    boolean bool = ((AudioPanelAioHelper)this.c.q(128)).g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      ((AudioPanelAioHelper)this.c.q(128)).g(2);
    }
  }
  
  public void d()
  {
    boolean bool = ((AudioPanelAioHelper)this.c.q(128)).g();
    Object localObject;
    if ((this.c.aX() != null) && (!this.c.aX().isFinishing()))
    {
      localObject = this.q;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing()) && (this.c.aR() != 36)) {
        this.q.dismiss();
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
      ((AudioPanelAioHelper)this.c.q(128)).g(1);
      ((AudioPanelAioHelper)this.c.q(128)).f(1);
    }
    if ((AppSetting.e) && (this.A)) {
      this.y.edit().putInt("key_ppt_hint", this.z).commit();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.prepareRecord() is called,time is:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    AIOUtils.q = true;
    this.p.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(0);
    this.i.setVisibility(8);
    this.m.setVisibility(0);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
    this.d.setVisibility(4);
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" PressToSpeakPanel.startRecord() is called, time is ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    this.j.a();
    this.k.a();
    this.p.setVisibility(0);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    this.m.setVisibility(0);
    this.j.setVisibility(0);
    this.k.setVisibility(0);
    this.d.setVisibility(4);
    this.n.setLevel(0);
    this.o.setLevel(0);
    Object localObject = new AnimationSet(true);
    ((AnimationSet)localObject).setDuration(150L);
    ((AnimationSet)localObject).setInterpolator(new LinearInterpolator());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.86F, 1.0F, 0.86F, 1.0F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    ((AnimationSet)localObject).addAnimation(localScaleAnimation);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    ((AnimationSet)localObject).setAnimationListener(new PressToSpeakPanel.3(this));
    this.p.startAnimation((Animation)localObject);
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
    localAnimationSet.setAnimationListener(new PressToSpeakPanel.16(this));
    this.m.startAnimation(localAnimationSet);
  }
  
  public ImageView getPressToSpeakView()
  {
    return this.m;
  }
  
  public void h()
  {
    PopupWindow localPopupWindow = this.q;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      this.q.dismiss();
      this.q = null;
    }
  }
  
  public boolean i()
  {
    RecordParams.RecorderParam localRecorderParam = this.c.aU();
    return (((PttWithTextSwitchBean)QConfigManager.b().b(488)).a()) && (localRecorderParam.c == 1) && (!((ReceiptHelper)this.c.q(118)).a);
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    return ((AudioPanelAioHelper)this.c.q(128)).l();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitFailed() is called");
    }
    ((AudioPanelAioHelper)this.c.q(128)).a(paramString, true, true, paramRecorderParam);
    this.t.post(new PressToSpeakPanel.6(this));
    ReportController.b(this.b, "CliOper", "", "", "0X8005A17", "0X8005A17", 13, 0, "", "", "", "8.8.17");
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.c.q(128)).a(paramString, true, true, paramRecorderParam);
    this.t.post(new PressToSpeakPanel.8(this));
    ReportController.b(this.b, "CliOper", "", "", "0X8005A17", "0X8005A17", 14, 0, "", "", "", "8.8.17");
    paramString = (InputStatusHelper)this.c.q(16);
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
    Object localObject = (InputStatusHelper)this.c.q(16);
    if (localObject != null) {
      ((InputStatusHelper)localObject).c();
    }
    if (this.Q < 500.0D)
    {
      ((AudioPanelAioHelper)this.c.q(128)).a(paramString);
      this.t.post(new PressToSpeakPanel.10(this, paramString, paramRecorderParam));
      ReportController.b(this.b, "CliOper", "", "", "0X8005A17", "0X8005A17", 11, 0, String.valueOf((int)this.Q), "", "", "8.8.17");
      return;
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(1, (int)this.Q);
    int i1 = ((AudioPanelAioHelper)this.c.q(128)).h();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("time is:");
      ((StringBuilder)localObject).append(this.Q);
      ((StringBuilder)localObject).append(",fateOfRecorder is:");
      ((StringBuilder)localObject).append(i1);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (i1 == 2)
    {
      if (i())
      {
        this.t.post(new PressToSpeakPanel.11(this, paramString, paramRecorderParam, paramDouble));
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A1D6", "0X800A1D6", 1, 0, "", "", "", "");
      this.t.post(new PressToSpeakPanel.12(this, paramString, paramRecorderParam));
      return;
    }
    if (i1 == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A1D4", "0X800A1D4", 1, 0, "", "", "", "");
      this.C += 1;
      ((AudioPanelAioHelper)this.c.q(128)).a(paramString, 1, (int)paramDouble, paramRecorderParam, 0, true, 0);
      this.t.post(new PressToSpeakPanel.13(this, paramString));
      if ((this.c instanceof PublicAccountChatPie)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.b, "P_CliOper", "Pb_account_lifeservice", "", "0X8005853", "0X8005853", 0, 0, "", "", Double.toString(this.Q), "", false);
      }
    }
    else
    {
      ((AudioPanelAioHelper)this.c.q(128)).c(paramString, 1, paramRecorderParam);
      this.t.post(new PressToSpeakPanel.14(this, paramString));
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
    ((AudioPanelAioHelper)this.c.q(128)).a(paramString1, false, true, paramRecorderParam);
    this.t.post(new PressToSpeakPanel.9(this));
    ReportController.b(this.b, "CliOper", "", "", "0X8005A17", "0X8005A17", 12, 0, "", "", "", "8.8.17");
    paramString1 = (InputStatusHelper)this.c.q(16);
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
    this.t.post(new PressToSpeakPanel.4(this));
    ((AudioPanelAioHelper)this.c.q(128)).a(paramString, true, paramRecorderParam);
    paramString = paramRecorderParam.f;
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.c.q(128)).a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    ((AudioPanelAioHelper)this.c.q(128)).b(paramString, (int)paramDouble, paramRecorderParam);
    this.t.post(new PressToSpeakPanel.7(this, paramInt2, paramDouble));
    this.Q = paramDouble;
  }
  
  public int onRecorderStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    if (this.E)
    {
      o();
      this.E = false;
    }
    this.t.post(new PressToSpeakPanel.5(this));
    PttInfoCollector.reportCostUntilPrepare(1);
    this.Q = 0.0D;
    InputStatusHelper localInputStatusHelper = (InputStatusHelper)this.c.q(16);
    if (localInputStatusHelper != null) {
      localInputStatusHelper.a();
    }
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    ((AudioPanelAioHelper)this.c.q(128)).h(paramInt);
    if (paramInt == 1) {
      ReportController.b(this.b, "CliOper", "", "", "0X800484C", "0X800484C", 0, 0, "", "", "", "");
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.onTouch() is called,action is:");
      localStringBuilder.append(i1);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.e.e();
    int i2 = paramView.getId();
    boolean bool = false;
    if (i2 == 2131440607)
    {
      if (i1 == 0)
      {
        p();
        ReportController.b(null, "dc00898", "", "", "0X800A1D3", "0X800A1D3", 1, 0, "", "", "", "");
        this.m.setPressed(true);
        n();
        m();
        paramView = new PressToSpeakPanel.15(this, paramMotionEvent);
        paramView = Message.obtain(this.t, paramView);
        paramView.what = 1;
        this.t.sendMessageDelayed(paramView, 150L);
      }
      else if (i1 == 2)
      {
        if ((this.w) && (((AudioPanelAioHelper)this.c.q(128)).g())) {
          a(paramMotionEvent);
        }
      }
      else if ((i1 == 3) || (i1 == 1))
      {
        this.m.setPressed(false);
        if (this.w)
        {
          this.w = false;
          if (((AudioPanelAioHelper)this.c.q(128)).g()) {
            a(paramMotionEvent);
          }
        }
        else
        {
          this.t.removeMessages(1);
        }
      }
      bool = true;
    }
    return bool;
  }
  
  public void setUseOnce(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel
 * JD-Core Version:    0.7.0.1
 */