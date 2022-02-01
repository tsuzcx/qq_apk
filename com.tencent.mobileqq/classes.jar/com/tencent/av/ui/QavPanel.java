package com.tencent.av.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavEffectUIABTestUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.effect.menuview.QavEffectMenuView;
import com.tencent.av.ui.viewcontroller.OperationBtnItem;
import com.tencent.av.ui.viewcontroller.OperationMenuViewFactory;
import com.tencent.av.ui.viewcontroller.QavOperationMenuViewController;
import com.tencent.av.ui.virtual.QavVirtualMenuView;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DrawableTools;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.QavMicroPhoneAnimatorHolder;
import com.tencent.av.utils.QavMuteButtonForeGroundDrawable;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class QavPanel
  extends RelativeLayout
{
  public static int ai = 2131446793;
  View A = null;
  View B = null;
  ImageButton C = null;
  ImageButton D = null;
  ImageButton E = null;
  FrameLayout F = null;
  Button G = null;
  TextView H = null;
  TextView I = null;
  Button J = null;
  ClipDrawable K = null;
  Button L = null;
  RelativeLayout M = null;
  RelativeLayout N = null;
  Button O = null;
  Button P = null;
  View.OnTouchListener Q = null;
  View.OnClickListener R = null;
  QavPanel.ScreenBroadcastReceiver S = null;
  boolean T = false;
  VideoAppInterface U;
  NormalMenuView[] V = new NormalMenuView[6];
  int W = -1;
  QavOperationMenuViewController Z = null;
  final String a;
  private QavPanel.CustomHandler aA = new QavPanel.CustomHandler(this, Looper.getMainLooper());
  private QavPanel.onReciveQavPanelStatusChangeListener aB;
  public final int aa = 256;
  public final int ab = 257;
  public final int ac = 258;
  public final int ad = 259;
  public final int ae = 260;
  public final int af = 261;
  Drawable ag = null;
  Drawable ah = null;
  private int aj = 0;
  private ValueAnimator ak;
  private volatile boolean al = false;
  private boolean am = false;
  private boolean an = false;
  private Drawable ao;
  private QavMuteButtonForeGroundDrawable ap;
  private LayerDrawable aq;
  private View ar;
  private ImageView as;
  private ImageView at;
  private TextView au;
  private QavMicroPhoneAnimatorHolder av;
  private ValueAnimator aw;
  private int ax = 0;
  private boolean ay = false;
  private int az = 1;
  int b = 0;
  View c = null;
  View d = null;
  boolean e = false;
  QavPanelSoundWaveView f = null;
  Button g = null;
  Button h = null;
  Button i = null;
  Button j = null;
  Button k = null;
  ImageView l = null;
  ImageView m = null;
  ShimmerTextView n = null;
  ImageView o = null;
  View p = null;
  public QavPanelSlideTouchListener q = null;
  ImageButton r = null;
  Button s = null;
  Button t = null;
  Button u = null;
  Button v = null;
  RedTouch w = null;
  View x = null;
  View y = null;
  View z = null;
  
  public QavPanel(Context paramContext)
  {
    super(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("QavPanel_");
    paramContext.append(AudioHelper.c());
    this.a = paramContext.toString();
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new StringBuilder();
    paramContext.append("QavPanel_");
    paramContext.append(AudioHelper.c());
    this.a = paramContext.toString();
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new StringBuilder();
    paramContext.append("QavPanel_");
    paramContext.append(AudioHelper.c());
    this.a = paramContext.toString();
    a();
  }
  
  private void A()
  {
    if (!j())
    {
      QLog.d(this.a, 1, "tryPerformLongClick cannot switch muteStatus");
      return;
    }
    if (!this.aB.a())
    {
      QLog.d(this.a, 1, "tryPerformLongClick cannot checkBlockMuteStatus");
      return;
    }
    if (getCurrentSpeakerMode() == 1)
    {
      SessionInfo localSessionInfo = this.U.b().k();
      if (E())
      {
        localSessionInfo.a("tryPerformLongClick", false);
        localSessionInfo.c("tryPerformLongClick", 3);
        a("tryPerformLongClick", 1, 3, true);
      }
      else
      {
        this.U.b().a("tryPerformLongClick", this.aB.d(), true, true, 3);
        a("tryPerformLongClick", 1, 3, false);
        this.aB.a(true, true);
      }
      ReportController.b(null, "dc00898", "", "", "0X800ADE2", "0X800ADE2", localSessionInfo.g, 0, "", "", "", "");
      this.aA.sendEmptyMessageDelayed(261, 4000L);
    }
  }
  
  @TargetApi(11)
  private void B()
  {
    Object localObject = this.J;
    if ((localObject != null) && ((localObject == null) || (((Button)localObject).isShown())))
    {
      if (this.U == null) {
        return;
      }
      if (getCurrentSpeakerMode() != 1) {
        return;
      }
      if (E())
      {
        localObject = this.U.b().k();
        ((SessionInfo)localObject).a("tryPlayBtnMuteAnimation", true);
        ((SessionInfo)localObject).c("tryPlayBtnMuteAnimation", 2);
        a("tryPlayBtnMuteAnimation start", 1, 2, false);
      }
      else
      {
        this.U.b().c("tryPlayBtnMuteAnimation onAnimationEnd", 2);
        a("tryPlayBtnMuteAnimation", 1, 2, false);
        this.aB.a(false, false);
      }
      this.aB.c();
      if (this.aw == null)
      {
        this.aw = ValueAnimator.ofInt(new int[] { 0, 3000 });
        this.aw.setDuration(3000L);
        this.aw.addListener(new QavPanel.5(this));
        this.aw.addUpdateListener(new QavPanel.6(this, new int[] { 250, 2750, 3000 }));
      }
      if (this.aw.isRunning()) {
        this.aw.cancel();
      }
      this.aw.start();
      this.ay = true;
    }
  }
  
  private void C()
  {
    ValueAnimator localValueAnimator = this.aw;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.aw.cancel();
    }
  }
  
  private AlphaAnimation D()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(400L);
    return localAlphaAnimation;
  }
  
  private boolean E()
  {
    int i1 = this.b;
    return (i1 == 2131625779) || (i1 == 2131625780);
  }
  
  private boolean F()
  {
    QavPanel.onReciveQavPanelStatusChangeListener localonReciveQavPanelStatusChangeListener = this.aB;
    return (localonReciveQavPanelStatusChangeListener != null) && (localonReciveQavPanelStatusChangeListener.b());
  }
  
  private void a(View paramView, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    localMarginLayoutParams.leftMargin = paramInt;
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  static void a(ImageButton paramImageButton, int paramInt)
  {
    if (paramImageButton == null) {
      return;
    }
    paramImageButton.setImageDrawable(DrawableTools.b(paramImageButton.getResources(), paramInt));
    paramImageButton.setAdjustViewBounds(true);
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = this.c.findViewById(2131441027);
    this.s = ((Button)this.c.findViewById(2131441017));
    this.t = ((Button)this.c.findViewById(2131441018));
    this.M = ((RelativeLayout)this.c.findViewById(2131441000));
    this.N = ((RelativeLayout)this.c.findViewById(2131441003));
    this.O = ((Button)this.c.findViewById(2131441008));
    Drawable localDrawable;
    if (this.O != null)
    {
      localDrawable = getResources().getDrawable(2130843007);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.O.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    this.P = ((Button)this.c.findViewById(2131441022));
    if (this.P != null)
    {
      localDrawable = getResources().getDrawable(2130843029);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.P.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    r();
    this.F = ((FrameLayout)this.c.findViewById(2131441026));
    this.G = ((Button)this.c.findViewById(2131441025));
    this.J = ((Button)this.c.findViewById(2131441023));
    this.L = ((Button)this.c.findViewById(2131441014));
    if (paramBoolean2) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    a(paramBoolean1, paramInt, false);
  }
  
  static void b(ImageButton paramImageButton, int paramInt)
  {
    if (paramImageButton == null) {
      return;
    }
    Drawable localDrawable = paramImageButton.getResources().getDrawable(paramInt);
    localDrawable.clearColorFilter();
    paramImageButton.setImageDrawable(localDrawable);
    paramImageButton.setAdjustViewBounds(true);
    setBtnTouchEffect(paramImageButton);
  }
  
  private void d(boolean paramBoolean, int paramInt)
  {
    this.s = ((Button)this.c.findViewById(2131441017));
    this.d = this.c.findViewById(2131441027);
    r();
    this.J = ((Button)this.c.findViewById(2131441023));
    q();
    this.L = ((Button)this.c.findViewById(2131441014));
    if (paramInt == 2131625786)
    {
      paramInt = UITools.a(getContext()) / 4;
      int i1 = (paramInt - AIOUtils.b(64.0F, getResources())) / 2;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ar.getLayoutParams();
      localLayoutParams.leftMargin = (paramInt + i1);
      this.ar.setLayoutParams(localLayoutParams);
      this.au.setVisibility(8);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    this.s = ((Button)this.c.findViewById(2131441017));
    this.d = this.c.findViewById(2131441027);
    r();
    this.J = ((Button)this.c.findViewById(2131441023));
    q();
    this.L = ((Button)this.c.findViewById(2131441014));
  }
  
  private NormalMenuView getCurrentMenu()
  {
    int i1 = this.W;
    if (i1 != -1) {
      return this.V[i1];
    }
    return null;
  }
  
  private void l(int paramInt)
  {
    this.d = this.c.findViewById(2131441027);
    this.g = ((Button)this.c.findViewById(2131428972));
    this.x = ((ViewGroup)getParent()).findViewById(2131441020);
    s();
    t();
    this.i = ((Button)this.c.findViewById(2131441182));
    this.f.setVisibility(0);
  }
  
  private void m(int paramInt)
  {
    this.d = this.c.findViewById(2131441027);
    this.m = ((ImageView)this.c.findViewById(2131441180));
    this.n = ((ShimmerTextView)this.c.findViewById(2131441181));
    this.o = ((ImageView)this.c.findViewById(2131441030));
    this.p = this.c.findViewById(2131441178);
    s();
    t();
    b();
    c();
  }
  
  private void n(int paramInt)
  {
    this.g = ((Button)this.c.findViewById(2131428972));
    this.m = ((ImageView)this.c.findViewById(2131441180));
    this.n = ((ShimmerTextView)this.c.findViewById(2131441181));
    this.o = ((ImageView)this.c.findViewById(2131441030));
    this.p = this.c.findViewById(2131441178);
    b();
    this.j = ((Button)this.c.findViewById(2131441183));
    c();
  }
  
  private void o(int paramInt)
  {
    r(paramInt);
    setBtnTopDrawable(this.L, 2130843045);
  }
  
  private boolean p(int paramInt)
  {
    return (paramInt == 2131441020) || (paramInt == 2131441304) || (paramInt == 2131441310) || (paramInt == 2131441302) || (paramInt == 2131441300);
  }
  
  private void q()
  {
    View localView = this.c;
    this.ar = localView.findViewById(2131441116);
    this.as = ((ImageView)localView.findViewById(2131441329));
    this.at = ((ImageView)localView.findViewById(2131441115));
    this.au = ((TextView)localView.findViewById(2131441117));
    this.av = new QavMicroPhoneAnimatorHolder((Activity)localView.getContext());
    this.as.setImageDrawable(this.av.a());
    this.ar.setVisibility(8);
  }
  
  private void q(int paramInt)
  {
    b((ImageButton)this.x, 2130842996);
    b((ImageButton)this.y, 2130842998);
    b(this.C, 2130843016);
    b(this.D, 2130843198);
    b(this.E, 2130843059);
    ImageButton localImageButton = this.E;
    if (localImageButton != null) {
      localImageButton.setTag(CameraUtils.b);
    }
  }
  
  private void r()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    this.x = localViewGroup.findViewById(2131441020);
    if ((this.x == null) && (AudioHelper.a())) {
      throw new IllegalArgumentException("没找到VIEW_ENUM.HIDE");
    }
    this.y = localViewGroup.findViewById(2131441304);
    this.z = localViewGroup.findViewById(2131441301);
    this.B = localViewGroup.findViewById(2131441306);
    this.A = localViewGroup.findViewById(2131441308);
    this.C = ((ImageButton)localViewGroup.findViewById(2131441310));
    this.D = ((ImageButton)localViewGroup.findViewById(2131441302));
    this.E = ((ImageButton)localViewGroup.findViewById(2131441300));
  }
  
  private void r(int paramInt)
  {
    if (this.J == null) {
      return;
    }
    boolean bool;
    if ((paramInt != 2131625785) && (paramInt != 2131625786)) {
      bool = false;
    } else {
      bool = true;
    }
    if (!QAVConfigUtils.d()) {
      bool = false;
    }
    this.am = bool;
    if (!this.am)
    {
      this.K = ((ClipDrawable)this.J.getResources().getDrawable(2130843036));
      setBtnTopDrawableWithForeGround(this.J, 2130843035, this.K);
      this.J.setOnTouchListener(new QavPanel.2(this));
      return;
    }
    z();
  }
  
  private void s()
  {
    this.h = ((Button)this.c.findViewById(2131428983));
    if (this.h != null) {
      AudioHelper.a(getResources(), this.h, 2130842948, 2131166706, 2131166706);
    }
  }
  
  private static boolean s(int paramInt)
  {
    return (paramInt == 2130843035) || (paramInt == 2130843045) || (paramInt == 2130843046);
  }
  
  public static void setBtnTopDrawable(View paramView, int paramInt)
  {
    if ((paramView instanceof Button))
    {
      setBtnTopDrawable((Button)paramView, paramInt);
      return;
    }
    if ((paramView instanceof ImageButton)) {
      a((ImageButton)paramView, paramInt);
    }
  }
  
  public static void setBtnTopDrawable(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    Drawable localDrawable;
    if (s(paramInt)) {
      localDrawable = DrawableTools.a(paramTextView.getResources(), paramInt, false);
    } else {
      localDrawable = DrawableTools.a(paramTextView.getResources(), paramInt);
    }
    paramTextView.setCompoundDrawables(null, localDrawable, null, null);
  }
  
  public static void setBtnTopDrawableWithForeGround(TextView paramTextView, int paramInt, Drawable paramDrawable)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setCompoundDrawables(null, DrawableTools.a(paramTextView.getResources(), paramInt, paramDrawable, false), null, null);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public static void setBtnTouchEffect(View paramView)
  {
    paramView.setOnTouchListener(new QavPanel.7(paramView));
  }
  
  public static void setTopLayerImageBtnEnable(ImageButton paramImageButton, boolean paramBoolean)
  {
    if (paramImageButton != null)
    {
      if ((paramImageButton != null) && (paramImageButton.getDrawable() == null)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTopLayerImageBtnEnable, id");
        localStringBuilder.append(LayoutDef.a(paramImageButton.getId()));
        localStringBuilder.append(", enable[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.d("VideoControlUI", 2, localStringBuilder.toString());
      }
      paramImageButton = paramImageButton.getDrawable();
      if (paramBoolean)
      {
        paramImageButton.clearColorFilter();
        return;
      }
      paramImageButton.setColorFilter(Color.parseColor("#4dffffff"), PorterDuff.Mode.MULTIPLY);
    }
  }
  
  private void t()
  {
    this.k = ((Button)this.c.findViewById(2131428982));
    if (this.k != null) {
      AudioHelper.a(getResources(), this.k, 2130842981, 2131166706, 2131166706);
    }
  }
  
  private void u()
  {
    if ((getContext() instanceof BaseActivity))
    {
      BaseActivity localBaseActivity = (BaseActivity)getContext();
      if ((localBaseActivity.getAppRuntime() instanceof VideoAppInterface)) {
        this.U = ((VideoAppInterface)localBaseActivity.getAppRuntime());
      }
    }
  }
  
  private boolean v()
  {
    VideoAppInterface localVideoAppInterface = this.U;
    if (localVideoAppInterface != null) {
      return localVideoAppInterface.p();
    }
    return false;
  }
  
  private void w()
  {
    this.s = ((Button)this.c.findViewById(2131441017));
    this.d = this.c.findViewById(2131441027);
    r();
    this.J = ((Button)this.c.findViewById(2131441023));
    this.L = ((Button)this.c.findViewById(2131441014));
    a(false);
  }
  
  private void x()
  {
    this.f = new QavPanelSoundWaveView(getContext());
    this.f.a(true);
    this.f.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131298595));
    this.f.setLayoutParams(localLayoutParams);
  }
  
  private void y()
  {
    Object localObject = getResources().getDisplayMetrics();
    int i2 = getResources().getDimensionPixelSize(2131298595);
    int i3 = getResources().getDimensionPixelSize(2131298592);
    int i1 = this.b;
    if ((i1 != 2131625779) && (i1 != 2131625780)) {
      i1 = 0;
    } else {
      i1 = ((DisplayMetrics)localObject).widthPixels * 880 / 750;
    }
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustPanel, heightPixels[");
      localStringBuilder.append(((DisplayMetrics)localObject).heightPixels);
      localStringBuilder.append("], widthPixels[");
      localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
      localStringBuilder.append("], waveHeight[");
      localStringBuilder.append(i2);
      localStringBuilder.append("], shadowHeight[");
      localStringBuilder.append(i3);
      localStringBuilder.append("], videoHeight[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], mPanelType[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    localObject = this.f;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((QavPanelSoundWaveView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = i2;
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    i1 = this.b;
    if ((i1 == 2131625780) || (i1 == 2131625786))
    {
      i1 = Math.max(0, (UITools.a(getContext()) - AIOUtils.b(64.0F, getResources()) * 4) / 5);
      a(findViewById(2131432387), i1);
      a(this.J, i1);
      a(this.L, i1);
      a(this.s, i1);
    }
  }
  
  private void z()
  {
    this.ao = TintStateDrawable.a(getResources(), 2130842986, 2131166772);
    this.ao.setBounds(0, 0, AIOUtils.b(64.0F, getResources()), AIOUtils.b(64.0F, getResources()));
    this.ap = new QavMuteButtonForeGroundDrawable(AIOUtils.b(64.0F, getResources()), AIOUtils.b(64.0F, getResources()));
    this.ap.a(0, BitmapFactory.decodeResource(getResources(), 2130843037));
    this.ap.a(0, BitmapFactory.decodeResource(getResources(), 2130843038));
    this.ap.a(1, BitmapFactory.decodeResource(getResources(), 2130843039));
    this.ap.a(2, BitmapFactory.decodeResource(getResources(), 2130843039));
    this.ap.a(2, BitmapFactory.decodeResource(getResources(), 2130843041));
    this.ap.a(3, BitmapFactory.decodeResource(getResources(), 2130843042));
    this.ap.a(0);
    this.aq = new LayerDrawable(new Drawable[] { this.ao, this.ap });
    this.aq.setLayerInset(0, 0, 0, 0, 0);
    this.aq.setLayerInset(1, 0, 0, 0, 0);
    this.aq.setBounds(0, 0, this.ap.getIntrinsicWidth(), this.ap.getIntrinsicHeight());
    this.J.setCompoundDrawables(null, this.aq, null, null);
    this.J.setOnTouchListener(new QavPanel.3(this));
  }
  
  public View a(OperationBtnItem paramOperationBtnItem)
  {
    NormalMenuView localNormalMenuView = this.V[1];
    if (localNormalMenuView == null) {
      return null;
    }
    if (!localNormalMenuView.e) {
      return null;
    }
    if (!(localNormalMenuView.c instanceof QavOperationMenuView)) {
      return null;
    }
    return ((QavOperationMenuView)localNormalMenuView.c).a(paramOperationBtnItem);
  }
  
  NormalMenuView a(int paramInt, NormalMenuView.ViewEvent paramViewEvent)
  {
    Object localObject2 = getContext();
    QavOperationMenuViewController localQavOperationMenuViewController = this.Z;
    Object localObject1 = null;
    if (localQavOperationMenuViewController != null)
    {
      if (!(localObject2 instanceof AVActivity)) {
        return null;
      }
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5) {
                localObject1 = new QavEffectMenuView((Context)localObject2);
              }
            }
            else {
              localObject1 = new QavVirtualMenuView((Context)localObject2);
            }
          }
          else {
            localObject1 = new QavBeautyMenuPanel((Context)localObject2);
          }
        }
        else {
          localObject1 = new EffectSettingUi((Context)localObject2);
        }
      }
      else {
        localObject1 = new QavOperationMenuView((Context)localObject2);
      }
      ((QavMenuBaseView)localObject1).setVisibility(8);
      ((QavMenuBaseView)localObject1).setGravity(80);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout)findViewById(2131440999)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((QavMenuBaseView)localObject1).a(this);
      ((QavMenuBaseView)localObject1).b();
      return new NormalMenuView((RelativeLayout)localObject1, paramInt, paramViewEvent);
    }
    return null;
  }
  
  void a() {}
  
  public void a(int paramInt)
  {
    a(paramInt, false, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e) {
      return;
    }
    u();
    int i1 = getResources().getDimensionPixelSize(2131298622);
    this.b = paramInt;
    x();
    b(this.b);
    paramInt = this.b;
    switch (paramInt)
    {
    case 2131625784: 
    default: 
      break;
    case 2131625788: 
      n(i1);
      break;
    case 2131625787: 
      f(paramBoolean2);
      break;
    case 2131625785: 
    case 2131625786: 
      d(paramBoolean2, paramInt);
      break;
    case 2131625783: 
      w();
      break;
    case 2131625782: 
      l(i1);
      break;
    case 2131625781: 
      m(i1);
      break;
    case 2131625779: 
    case 2131625780: 
      b(i1, paramBoolean1, paramBoolean2);
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      addView((View)localObject);
      a(-1020L, 0, false);
    }
    p();
    localObject = (RelativeLayout)findViewById(2131450041);
    if (localObject != null)
    {
      ((RelativeLayout)localObject).addView(this.f);
      ((RelativeLayout)localObject).bringChildToFront(this.f);
    }
    y();
    this.S = new QavPanel.ScreenBroadcastReceiver(this);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    getContext().registerReceiver(this.S, (IntentFilter)localObject);
    this.e = true;
    setBtnOnTouchListener(this.Q);
    g();
    o(this.b);
    q(this.b);
    d(paramBoolean1);
    if (paramBoolean2) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    h(paramInt);
    if (AudioHelper.a(0) == 1)
    {
      localObject = this.L;
      if (localObject != null) {
        ((Button)localObject).setBackgroundColor(Color.argb(255, 68, 128, 2));
      }
      setBackgroundColor(-545259606);
      localObject = this.y;
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(2145129532);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.S != null)
    {
      getContext().unregisterReceiver(this.S);
      this.S = null;
    }
    int i1 = 0;
    this.aj = 0;
    Object localObject = this.ak;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.ak = null;
    }
    this.R = null;
    for (;;)
    {
      localObject = this.V;
      if (i1 >= localObject.length) {
        break;
      }
      if ((localObject[i1] != null) && ((localObject[i1].c instanceof QavMenuBaseView))) {
        ((QavMenuBaseView)this.V[i1].c).b(paramLong);
      }
      this.V[i1] = null;
      i1 += 1;
    }
    localObject = this.f;
    if (localObject != null) {
      ((QavPanelSoundWaveView)localObject).c();
    }
    C();
    if (this.U != null) {
      this.U = null;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    int i1;
    if (QavEffectUIABTestUtils.b(this.U.getCurrentAccountUin())) {
      i1 = 5;
    } else {
      i1 = 2;
    }
    j(i1);
    QavEffectBaseMenuView localQavEffectBaseMenuView = (QavEffectBaseMenuView)k(i1);
    if (localQavEffectBaseMenuView == null) {
      return;
    }
    if (!localQavEffectBaseMenuView.a(paramLong, paramInt)) {
      return;
    }
    a(paramLong, i1, true);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (!(getContext() instanceof AVActivity)) {
      return;
    }
    NormalMenuView localNormalMenuView = getCurrentMenu();
    if (localNormalMenuView != null)
    {
      if (localNormalMenuView.d == paramInt)
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showMenu direct, menuType[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], needAnimation[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        localNormalMenuView.a(paramLong, paramBoolean, 3);
        this.U.a(new Object[] { Integer.valueOf(123), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      }
      j(paramInt);
    }
    else
    {
      j(paramInt);
    }
    if (this.V[paramInt] == null) {
      return;
    }
    int i2;
    if (localNormalMenuView == null) {
      i2 = -1;
    } else {
      i2 = localNormalMenuView.a();
    }
    int i1 = 4;
    if (i2 == 0) {
      i1 = 3;
    }
    boolean bool1;
    int i3;
    label304:
    for (;;)
    {
      bool1 = false;
      i3 = -1;
      break label307;
      if (i2 == 1) {
        if ((paramInt != 2) && (paramInt != 3) && (paramInt != 5)) {
          if (paramInt != 0) {
            break label304;
          }
        }
      }
      while (paramInt == 1)
      {
        i1 = 3;
        do
        {
          bool1 = true;
          i3 = 2;
          break label307;
          if (i2 == -1) {
            break;
          }
          if ((i2 != 2) && (i2 != 3) && (i2 != 5)) {
            break label304;
          }
        } while (paramInt == 0);
      }
    }
    label307:
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showMenu, MenuType[");
    localStringBuilder.append(i2);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], isVisible[");
    if (getVisibility() == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    localStringBuilder.append(bool2);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    this.W = paramInt;
    if ((i2 != this.W) && (i2 == 0))
    {
      a("showMenu", 0);
      this.aA.removeMessages(257);
    }
    boolean bool2 = false;
    localObject = new QavPanel.8(this, paramInt, paramLong, paramBoolean, i1);
    if (getVisibility() != 0) {
      bool1 = bool2;
    }
    if (localNormalMenuView != null) {
      localNormalMenuView.a(paramLong, bool1, i3, new QavPanel.9(this, (Runnable)localObject));
    }
    if ((localNormalMenuView == null) || (!bool1)) {
      ((Runnable)localObject).run();
    }
  }
  
  public void a(Animation.AnimationListener paramAnimationListener)
  {
    int i1;
    if (this.t != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((this.N != null) && (this.M != null))
    {
      AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation1.setFillEnabled(true);
      localAlphaAnimation1.setFillAfter(true);
      localAlphaAnimation1.setDuration(400L);
      AlphaAnimation localAlphaAnimation2 = D();
      localAlphaAnimation2.setAnimationListener(paramAnimationListener);
      this.M.startAnimation(localAlphaAnimation1);
      this.N.startAnimation(localAlphaAnimation2);
      if (i1 != 0)
      {
        paramAnimationListener = D();
        this.t.startAnimation(paramAnimationListener);
        this.t.setVisibility(0);
      }
    }
  }
  
  public void a(QavPanel.onReciveQavPanelStatusChangeListener paramonReciveQavPanelStatusChangeListener)
  {
    this.aB = paramonReciveQavPanelStatusChangeListener;
  }
  
  public void a(QQFrameByFrameAnimation paramQQFrameByFrameAnimation)
  {
    Object localObject = this.s;
    if (localObject != null)
    {
      paramQQFrameByFrameAnimation.a((View)localObject);
      paramQQFrameByFrameAnimation.b();
      return;
    }
    localObject = this.r;
    if (localObject != null)
    {
      paramQQFrameByFrameAnimation.a((View)localObject);
      paramQQFrameByFrameAnimation.b();
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pressSpeaking showPressSpeakingGuider, from[1], text[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mVoiceGuiderRootContent[");
    localStringBuilder.append(this.ar);
    localStringBuilder.append("]");
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    localObject = this.ar;
    if (localObject != null)
    {
      this.az = 1;
      ((View)localObject).setVisibility(0);
      this.at.getBackground().setAlpha(255);
      this.at.setVisibility(0);
      this.au.setText(paramString);
      this.au.setVisibility(0);
      this.as.setVisibility(8);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pressSpeaking hidePressSpreakingGuiderOrTips, from[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], tipsType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    if ((this.ar != null) && ((this.az == paramInt) || (paramInt == 0))) {
      this.ar.setVisibility(8);
    }
  }
  
  @TargetApi(11)
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doSpeakerStatusChange from:=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(";lastStatus:=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(";nextStatus:=");
    localStringBuilder.append(paramInt2);
    paramString = localStringBuilder.toString();
    boolean bool2 = true;
    QLog.d(str, 1, paramString);
    if (paramInt2 != paramInt1)
    {
      if (!this.am) {
        return;
      }
      boolean bool1;
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2) {
            if (paramInt2 == 3) {}
          }
          for (;;)
          {
            bool1 = false;
            break;
            this.ap.setAlpha(127);
            this.ap.a(3);
            h();
            this.ax += 1;
            bool1 = bool2;
            break;
            this.ap.a(2);
          }
        }
        if (paramInt1 == 0) {
          QLog.d(this.a, 1, "test has call keep speaking status");
        }
        do
        {
          bool1 = true;
          break label210;
          if (paramInt1 == 2)
          {
            C();
            break;
          }
        } while (paramInt1 == 3);
        bool1 = false;
        label210:
        a("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
        this.ap.setAlpha(255);
        this.ap.a(1);
        a(2131441023, getResources().getString(2131889940));
        if ((!this.ay) && (F()))
        {
          this.aA.removeMessages(257);
          this.aA.sendEmptyMessageDelayed(257, 5300L);
        }
        if (!UITools.a(false))
        {
          this.aA.removeMessages(258);
          this.aA.sendEmptyMessageDelayed(258, 300L);
        }
      }
      else
      {
        if (paramInt1 == 2) {
          C();
        }
        a("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
        this.ap.setAlpha(255);
        this.ap.a(0);
        bool1 = bool2;
        if (!UITools.a(true))
        {
          this.aA.removeMessages(259);
          this.aA.sendEmptyMessageAtTime(259, 300L);
          bool1 = bool2;
        }
      }
      if ((this.aB != null) && (this.U != null) && (paramBoolean) && (E())) {
        this.aB.a(this.U.b().k().E, bool1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resizeLayout4DoubleVideoMeeting mEffectiveType:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 2, localStringBuilder.toString());
    d(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resizeLayout4Multi mEffectiveType:");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
    if (paramInt == 2) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    d(paramBoolean);
    h(paramInt);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoSession :");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", localHasVideo:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isVipFunCall:");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    d(paramBoolean1);
    h(paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.al = false;
      this.aj = 0;
      Object localObject = this.ak;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).cancel();
        this.ak = null;
      }
      localObject = this.K;
      if (localObject != null) {
        ((ClipDrawable)localObject).setLevel(0);
      }
      if (this.am)
      {
        this.av.a(0);
        this.ap.b(0);
      }
    }
    else
    {
      this.al = true;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewBackground, id");
      localStringBuilder.append(LayoutDef.a(paramInt1));
      localStringBuilder.append(", selected[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = e(paramInt1);
    if (localObject != null)
    {
      ((View)localObject).setBackgroundResource(paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setViewMargin, id");
      ((StringBuilder)localObject2).append(LayoutDef.a(paramInt1));
      ((StringBuilder)localObject2).append(", direction[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], margin[");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt3 < 0) {
      return false;
    }
    Object localObject1 = e(paramInt1);
    if (localObject1 == null) {
      return false;
    }
    try
    {
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 == null) {
        return false;
      }
      if (paramInt2 == 1) {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = paramInt3;
      } else if (paramInt2 == 2) {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = paramInt3;
      } else if (paramInt2 == 4) {
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramInt3;
      } else if (paramInt2 == 3) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = paramInt3;
      }
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewAccText, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      localStringBuilder.append(", text[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = e(paramInt);
    if (localObject != null)
    {
      UITools.a((View)localObject, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewAccText, id");
      localStringBuilder.append(LayoutDef.a(paramInt1));
      localStringBuilder.append(", text[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], audioType[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = e(paramInt1);
    if (localObject != null)
    {
      UITools.a((View)localObject, paramString, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewSelected, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      localStringBuilder.append(", selected[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = e(paramInt);
    if (localObject != null)
    {
      ((View)localObject).setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(QavPanel.SlideAcceptListener paramSlideAcceptListener)
  {
    QavPanelSlideTouchListener localQavPanelSlideTouchListener = this.q;
    if (localQavPanelSlideTouchListener == null) {
      return false;
    }
    localQavPanelSlideTouchListener.a(paramSlideAcceptListener);
    return true;
  }
  
  public boolean a(TraeHelper paramTraeHelper)
  {
    if (paramTraeHelper != null)
    {
      Button localButton = this.L;
      if (localButton != null)
      {
        paramTraeHelper.b(localButton);
        return true;
      }
    }
    return false;
  }
  
  View b(int paramInt)
  {
    this.c = LayoutInflater.from(getContext()).inflate(paramInt, this, false);
    return this.c;
  }
  
  void b()
  {
    this.i = ((Button)this.c.findViewById(2131441182));
    if (this.i != null) {
      AudioHelper.a(getResources(), this.i, 2130843176, 2131166706, 2131166706);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.U == null) {
      return;
    }
    boolean bool;
    if ((!E()) && (this.U.b().D() != 1) && (this.U.b().D() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshButtonStatus, from[1], mute[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], canRefresh[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    if ((this.am) && (bool)) {
      if (paramBoolean)
      {
        this.ap.setAlpha(255);
        this.ap.a(1);
        a(2131441023, getResources().getString(2131889940));
        if ((!this.ay) && (F()))
        {
          this.aA.removeMessages(257);
          this.aA.sendEmptyMessageDelayed(257, 5300L);
        }
        if (!UITools.a(false))
        {
          this.aA.removeMessages(258);
          this.aA.sendEmptyMessageDelayed(258, 300L);
        }
      }
      else
      {
        this.ap.setAlpha(255);
        this.ap.a(0);
        this.aA.removeMessages(257);
        if (!UITools.a(true))
        {
          this.aA.removeMessages(259);
          this.aA.sendEmptyMessageDelayed(259, 300L);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resizeLayout4Group mEffectiveType:");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
    if (paramInt == 2) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    d(paramBoolean);
    h(paramInt);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return b(paramInt1, paramInt2, -1);
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setViewRule, id");
      ((StringBuilder)localObject2).append(LayoutDef.a(paramInt1));
      ((StringBuilder)localObject2).append(", verb[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], anchor[");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool = false;
    Object localObject1 = e(paramInt1);
    if (localObject1 != null) {}
    try
    {
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(paramInt2, paramInt3);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      bool = true;
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewClickable, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = e(paramInt);
    if (localObject != null)
    {
      ((View)localObject).setClickable(paramBoolean);
      return true;
    }
    return false;
  }
  
  public OperationBtnItem c(int paramInt)
  {
    QavOperationMenuViewController localQavOperationMenuViewController = this.Z;
    if (localQavOperationMenuViewController == null) {
      return null;
    }
    return localQavOperationMenuViewController.b(paramInt);
  }
  
  void c()
  {
    this.l = ((ImageView)this.c.findViewById(2131441179));
    this.q = new QavPanelSlideTouchListener(getContext(), this.l, this.m, this.n, this.o);
    if (v())
    {
      this.l.setContentDescription(getResources().getString(2131917825));
      this.l.setFocusable(true);
      this.l.setClickable(true);
      this.l.setOnClickListener(new QavPanel.1(this));
      return;
    }
    this.l.setOnTouchListener(this.q);
  }
  
  public void c(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEffectBtn, effectType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], mEffectDrawable[");
      boolean bool;
      if (this.ag != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], ignoreSetSelected[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Button localButton = this.v;
    if (localButton != null)
    {
      if (this.u == null) {
        return;
      }
      if (paramBoolean)
      {
        localButton.setVisibility(0);
        this.u.setVisibility(8);
        return;
      }
      localButton.setVisibility(8);
      this.u.setVisibility(0);
    }
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.F;
    if ((localObject != null) && (paramBoolean))
    {
      ((FrameLayout)localObject).setVisibility(0);
      localObject = this.G;
      if (localObject != null)
      {
        ((Button)localObject).setClickable(false);
        this.G.setEnabled(false);
      }
    }
  }
  
  public void d()
  {
    QavPanelSoundWaveView localQavPanelSoundWaveView = this.f;
    if (localQavPanelSoundWaveView != null)
    {
      if (!localQavPanelSoundWaveView.isShown()) {
        return;
      }
      this.f.f();
      this.T = true;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.Z == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SetBeautyViewVisibility, visibility:");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.Z;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((QavOperationMenuViewController)localObject).a(bool);
  }
  
  void d(boolean paramBoolean)
  {
    c(paramBoolean);
    NormalMenuView localNormalMenuView = this.V[0];
    if (paramBoolean)
    {
      QavPanelSoundWaveView localQavPanelSoundWaveView = this.f;
      if (localQavPanelSoundWaveView != null) {
        localQavPanelSoundWaveView.setVisibility(8);
      }
      if ((localNormalMenuView != null) && (localNormalMenuView.d() != null)) {
        localNormalMenuView.d().setBackgroundResource(2130842942);
      }
    }
    else if ((localNormalMenuView != null) && (localNormalMenuView.d() != null))
    {
      localNormalMenuView.d().setBackgroundColor(0);
    }
    e(paramBoolean);
  }
  
  public View e(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131906696));
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]，Name[");
      ((StringBuilder)localObject).append(LayoutDef.a(paramInt));
      ((StringBuilder)localObject).append("]，Name[");
      ((StringBuilder)localObject).append(AudioHelper.a(this, paramInt));
      localObject = ((StringBuilder)localObject).toString();
      QLog.d(this.a, 1, (String)localObject);
      if (!AudioHelper.a()) {
        return null;
      }
      break;
    case 2131449444: 
      return this.I;
    case 2131441323: 
      return this.v;
    case 2131441310: 
      return this.C;
    case 2131441308: 
      return this.A;
    case 2131441306: 
      return this.B;
    case 2131441304: 
      return this.y;
    case 2131441302: 
      return this.D;
    case 2131441301: 
      return this.z;
    case 2131441300: 
      return this.E;
    case 2131441183: 
      return this.j;
    case 2131441182: 
      return this.i;
    case 2131441179: 
      return this.l;
    case 2131441178: 
      return this.p;
    case 2131441026: 
      return this.F;
    case 2131441025: 
      return this.G;
    case 2131441023: 
      return this.J;
    case 2131441022: 
      return this.P;
    case 2131441020: 
      return this.x;
    case 2131441018: 
      return this.t;
    case 2131441017: 
      return this.s;
    case 2131441016: 
      return this.r;
    case 2131441014: 
      return this.L;
    case 2131441008: 
      return this.O;
    case 2131440994: 
      return this.u;
    case 2131428983: 
      return this.h;
    case 2131428982: 
      return this.k;
    case 2131428972: 
      return this.g;
    case 2131428836: 
      return this.H;
    }
    throw new IllegalArgumentException((String)localObject);
  }
  
  public void e()
  {
    QavPanelSoundWaveView localQavPanelSoundWaveView = this.f;
    if (localQavPanelSoundWaveView != null)
    {
      if (!localQavPanelSoundWaveView.isShown()) {
        return;
      }
      this.f.g();
      this.T = false;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    View localView = this.d;
    if (localView == null) {
      return;
    }
    if (paramBoolean) {
      localView.setVisibility(0);
    } else {
      localView.setVisibility(8);
    }
    if (AudioHelper.a(0) == 1) {
      this.d.setBackgroundColor(-536894208);
    }
  }
  
  public void f()
  {
    NormalMenuView localNormalMenuView = this.V[1];
    if (localNormalMenuView == null) {
      return;
    }
    if (!localNormalMenuView.e) {
      return;
    }
    if (!(localNormalMenuView.c instanceof QavOperationMenuView)) {
      return;
    }
    ((QavOperationMenuView)localNormalMenuView.c).b();
  }
  
  public boolean f(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkView, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return e(paramInt) == null;
  }
  
  public int g(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewClickable, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = e(paramInt);
    if (localObject != null) {
      return ((View)localObject).getVisibility();
    }
    return -1;
  }
  
  void g()
  {
    Object localObject = (ViewGroup)getParent();
    this.H = ((TextView)((ViewGroup)localObject).findViewById(2131428836));
    this.I = ((TextView)((ViewGroup)localObject).findViewById(2131449444));
    TextView localTextView = this.H;
    if ((localTextView != null) && (this.I != null))
    {
      localTextView.setTextColor(getResources().getColor(2131166796));
      this.I.setTextColor(getResources().getColor(2131166796));
    }
    this.v = ((Button)((ViewGroup)localObject).findViewById(2131441323));
    this.u = ((Button)((ViewGroup)localObject).findViewById(2131440994));
    localObject = this.v;
    if ((localObject != null) && (this.u != null))
    {
      setBtnTopDrawable((TextView)localObject, 2130843315);
      setBtnTopDrawable(this.u, 2130843326);
    }
    k();
  }
  
  public int getCurrentMenuType()
  {
    return this.W;
  }
  
  public int getCurrentSpeakerMode()
  {
    SessionInfo localSessionInfo = this.U.b().k();
    int i1 = this.b;
    if ((i1 != 2131625779) && (i1 != 2131625780)) {
      return this.U.b().D();
    }
    return localSessionInfo.D;
  }
  
  public ArrayList<OperationBtnItem> getMenuItems()
  {
    QavOperationMenuViewController localQavOperationMenuViewController = this.Z;
    if (localQavOperationMenuViewController == null) {
      return new ArrayList();
    }
    return localQavOperationMenuViewController.a();
  }
  
  public QavPanelSoundWaveView getWave()
  {
    return this.f;
  }
  
  public void h()
  {
    if ((this.ar != null) && (F()))
    {
      this.az = 2;
      this.ar.setVisibility(0);
      this.at.getBackground().setAlpha(127);
      this.at.setVisibility(0);
      this.as.getBackground().setAlpha(127);
      this.as.setVisibility(0);
      this.au.setVisibility(8);
    }
  }
  
  public void h(int paramInt)
  {
    c(paramInt, false);
  }
  
  public boolean i()
  {
    return this.am;
  }
  
  public boolean i(int paramInt)
  {
    return paramInt == this.W;
  }
  
  public boolean isPressed()
  {
    if (!super.isPressed())
    {
      Object localObject = this.y;
      if ((localObject == null) || (!((View)localObject).isPressed()))
      {
        localObject = this.J;
        if ((localObject == null) || (!((Button)localObject).isPressed()))
        {
          localObject = this.L;
          if ((localObject == null) || (!((Button)localObject).isPressed())) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  void j(int paramInt)
  {
    if (this.V[paramInt] != null) {
      return;
    }
    NormalMenuView localNormalMenuView = null;
    if (paramInt == 1) {
      localNormalMenuView = o();
    } else if (paramInt == 0) {
      localNormalMenuView = n();
    } else if (paramInt == 2) {
      localNormalMenuView = a(2, new DefaultViewEvent(null));
    } else if (paramInt == 3) {
      localNormalMenuView = a(3, new DefaultViewEvent("0X800A567"));
    } else if (paramInt == 4) {
      localNormalMenuView = a(4, new DefaultViewEvent(null));
    } else if (paramInt == 5) {
      localNormalMenuView = a(5, new DefaultViewEvent(null));
    }
    this.V[paramInt] = localNormalMenuView;
  }
  
  public boolean j()
  {
    Object localObject = this.U;
    boolean bool3 = false;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    if (E())
    {
      localObject = this.U.b().k();
      bool1 = bool2;
      if (this.am)
      {
        bool1 = bool2;
        if (((SessionInfo)localObject).D != 3)
        {
          bool1 = bool2;
          if (!this.an) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    boolean bool1 = bool3;
    if (this.am)
    {
      bool1 = bool3;
      if (this.U.b().D() != 3)
      {
        bool1 = bool3;
        if (!this.an) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public <T extends RelativeLayout> T k(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 99) {
      i1 = this.W;
    }
    NormalMenuView[] arrayOfNormalMenuView = this.V;
    if (arrayOfNormalMenuView[i1] != null) {
      return arrayOfNormalMenuView[i1].d();
    }
    return null;
  }
  
  public void k()
  {
    this.w = AVRedTouchUtil.a(this.U, this.v, 11);
    if (this.w != null)
    {
      int i1 = (int)UITools.b(getContext(), this.v.getPaddingRight());
      int i2 = (int)UITools.b(getContext(), this.v.getPaddingTop());
      this.w.a(0, i1, i2, 0).a();
    }
  }
  
  public void l()
  {
    RedTouch localRedTouch = this.w;
    if (localRedTouch != null) {
      AVRedTouchUtil.a(this.U, localRedTouch, 11);
    }
  }
  
  public void m()
  {
    RelativeLayout localRelativeLayout = this.N;
    if ((localRelativeLayout != null) && (this.M != null))
    {
      localRelativeLayout.setVisibility(0);
      this.N.clearAnimation();
      this.M.clearAnimation();
      this.M.setVisibility(4);
    }
  }
  
  NormalMenuView n()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.c.findViewById(2131441002);
    if (localRelativeLayout != null)
    {
      if (AudioHelper.a(0) == 1) {
        localRelativeLayout.setBackgroundColor(2142236398);
      }
      return new NormalMenuView(localRelativeLayout, 0, null);
    }
    return null;
  }
  
  NormalMenuView o()
  {
    NormalMenuView localNormalMenuView = a(1, new DefaultViewEvent(null));
    if ((localNormalMenuView != null) && ((localNormalMenuView.c instanceof QavOperationMenuView)))
    {
      QavOperationMenuView localQavOperationMenuView = (QavOperationMenuView)localNormalMenuView.c;
      localQavOperationMenuView.setViewController(this.Z);
      localQavOperationMenuView.setQavMenuActionListener(new QavPanel.10(this));
    }
    return localNormalMenuView;
  }
  
  void p()
  {
    if (this.Z != null) {
      return;
    }
    this.Z = OperationMenuViewFactory.a(getResources(), this.b);
  }
  
  public void setAcceptDrawableTop(Drawable paramDrawable)
  {
    Button localButton = this.g;
    if (localButton == null) {
      return;
    }
    localButton.setBackgroundDrawable(paramDrawable);
  }
  
  public void setAudioVolumeValue(int paramInt)
  {
    Object localObject = this.J;
    if (localObject != null)
    {
      if ((localObject != null) && (!((Button)localObject).isShown())) {
        return;
      }
      int i2 = this.aj;
      this.aj = paramInt;
      if (this.aj != i2)
      {
        localObject = this.ak;
        int i1;
        if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
        {
          paramInt = ((Integer)this.ak.getAnimatedValue()).intValue();
          this.ak.cancel();
          i1 = paramInt;
        }
        else
        {
          i1 = -1;
          paramInt = i2;
        }
        if (this.ak == null)
        {
          this.ak = new ValueAnimator();
          this.ak.addUpdateListener(new QavPanel.4(this));
        }
        if (this.aj > paramInt) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        localObject = this.ak;
        long l1;
        if (i2 != 0) {
          l1 = 100L;
        } else {
          l1 = 200L;
        }
        ((ValueAnimator)localObject).setDuration(l1);
        localObject = this.ak;
        i2 = i1;
        if (i1 == -1) {
          i2 = paramInt;
        }
        ((ValueAnimator)localObject).setIntValues(new int[] { i2, this.aj });
        this.ak.start();
        return;
      }
      localObject = this.K;
      if (localObject != null) {
        ((ClipDrawable)localObject).setLevel(paramInt);
      }
    }
  }
  
  public void setBtnOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.Q = paramOnTouchListener;
    Button localButton = this.J;
    if (localButton != null) {
      localButton.setOnTouchListener(paramOnTouchListener);
    }
    localButton = this.L;
    if (localButton != null) {
      localButton.setOnTouchListener(paramOnTouchListener);
    }
  }
  
  public void setEffectOperateDrawable(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "setEffectOperateDrawable");
    }
    this.ah = paramDrawable;
  }
  
  public void setImgBtnDrawable(int paramInt1, int paramInt2)
  {
    View localView = e(paramInt1);
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setImgBtnDrawable, id");
      localStringBuilder.append(LayoutDef.a(paramInt1));
      localStringBuilder.append("], view[");
      boolean bool;
      if (localView != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], resid[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((localView != null) && ((localView instanceof ImageButton))) {
      ((ImageButton)localView).setImageDrawable(this.U.getApplicationContext().getResources().getDrawable(paramInt2));
    }
  }
  
  public void setNoVideoAndShareBtnMode()
  {
    QavOperationMenuViewController localQavOperationMenuViewController = this.Z;
    if (localQavOperationMenuViewController != null)
    {
      localQavOperationMenuViewController.a(2131893073);
      this.Z.a(2131893078);
      this.Z.a(2131893080);
    }
  }
  
  void setOperationMenuViewOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.R = paramOnClickListener;
  }
  
  public void setViewEnable(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewEnable, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      localStringBuilder.append(", enable[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = e(paramInt);
    boolean bool = p(paramInt);
    if (localObject != null) {
      ((View)localObject).setEnabled(paramBoolean);
    }
    if ((localObject != null) && (bool)) {
      setTopLayerImageBtnEnable((ImageButton)localObject, paramBoolean);
    }
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    View localView = e(paramInt1);
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewVisibility, id");
      localStringBuilder.append(LayoutDef.a(paramInt1));
      localStringBuilder.append("], view[");
      boolean bool;
      if (localView != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], visibility[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (localView != null) {
      localView.setVisibility(paramInt2);
    }
  }
  
  public void setWaveVisibility(int paramInt)
  {
    if (this.f == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("timWaveView setWaveVisibility visibility:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.f.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel
 * JD-Core Version:    0.7.0.1
 */