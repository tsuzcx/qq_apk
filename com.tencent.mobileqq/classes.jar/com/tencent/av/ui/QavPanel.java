package com.tencent.av.ui;

import alpo;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mgu;
import mkm;
import mkn;
import mko;
import mkp;
import mkq;
import mkr;
import mks;
import mkt;
import mku;
import mkz;
import mla;
import mlb;
import mqq.app.BaseActivity;
import mtb;
import mtc;
import mtd;
import mtv;
import mvp;
import mwk;
import mww;

public class QavPanel
  extends RelativeLayout
{
  public static int d;
  int jdField_a_of_type_Int = 0;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public ClipDrawable a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public View.OnClickListener a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public VideoAppInterface a;
  public QavPanelSoundWaveView a;
  ShimmerTextView jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
  final String jdField_a_of_type_JavaLangString = "QavPanel_" + AudioHelper.b();
  mkz jdField_a_of_type_Mkz = null;
  public mlb a;
  mtd jdField_a_of_type_Mtd = null;
  boolean jdField_a_of_type_Boolean = false;
  mku[] jdField_a_of_type_ArrayOfMku = new mku[4];
  int jdField_b_of_type_Int = 1;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  View jdField_b_of_type_AndroidViewView = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public boolean b;
  int jdField_c_of_type_Int = -1;
  View jdField_c_of_type_AndroidViewView = null;
  Button jdField_c_of_type_AndroidWidgetButton = null;
  ImageButton jdField_c_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  private volatile boolean jdField_c_of_type_Boolean;
  View jdField_d_of_type_AndroidViewView = null;
  Button jdField_d_of_type_AndroidWidgetButton = null;
  private int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView = null;
  Button jdField_e_of_type_AndroidWidgetButton = null;
  Button f = null;
  Button g = null;
  Button h = null;
  Button i = null;
  Button j = null;
  Button k = null;
  
  static
  {
    jdField_d_of_type_Int = 2131377359;
  }
  
  public QavPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  static void a(ImageButton paramImageButton, int paramInt)
  {
    if (paramImageButton == null) {
      return;
    }
    paramImageButton.setImageDrawable(mtv.b(paramImageButton.getResources(), paramInt));
    paramImageButton.setAdjustViewBounds(true);
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      bool = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f();
    }
    return bool;
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372575);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131372565));
    this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372566));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372549));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372551));
    this.j = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372557));
    Drawable localDrawable;
    if (this.j != null)
    {
      localDrawable = getResources().getDrawable(2130841659);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.j.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    this.k = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372570));
    if (this.k != null)
    {
      localDrawable = getResources().getDrawable(2130841678);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.k.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    l();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372574));
    this.g = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372573));
    this.h = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372571));
    this.i = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372563));
    if (paramBoolean2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      a(paramBoolean1, paramInt, false);
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      }
      return;
    }
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt == 2130841684) || (paramInt == 2130841692) || (paramInt == 2130841693);
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131372565));
    this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372566));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372575);
    l();
    this.h = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372571));
    this.i = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372563));
  }
  
  private mku e()
  {
    if (this.jdField_c_of_type_Int != -1) {
      return this.jdField_a_of_type_ArrayOfMku[this.jdField_c_of_type_Int];
    }
    return null;
  }
  
  private void e(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372575);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362956));
    this.jdField_d_of_type_AndroidViewView = ((ViewGroup)getParent()).findViewById(2131372568);
    m();
    n();
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372730));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131372565));
    this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372566));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372575);
    l();
    this.h = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372571));
    this.i = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372563));
  }
  
  private void f(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372575);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372728));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372729));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372578));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372726);
    m();
    n();
    b();
    c();
  }
  
  private void g(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362956));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372728));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372729));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372578));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372726);
    b();
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372731));
    c();
  }
  
  private void l()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    this.jdField_d_of_type_AndroidViewView = localViewGroup.findViewById(2131372568);
    if ((this.jdField_d_of_type_AndroidViewView == null) && (AudioHelper.d())) {
      throw new IllegalArgumentException("没找到VIEW_ENUM.HIDE");
    }
    this.jdField_e_of_type_AndroidViewView = localViewGroup.findViewById(2131372873);
    this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)localViewGroup.findViewById(2131372871));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)localViewGroup.findViewById(2131372877));
    getRootView();
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362968));
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_b_of_type_AndroidWidgetButton, 2130841607, 2131165887, 2131165887);
    }
  }
  
  private void n()
  {
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131362967));
    if (this.jdField_e_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_e_of_type_AndroidWidgetButton, 2130841633, 2131165887, 2131165887);
    }
  }
  
  private void o()
  {
    if ((getContext() instanceof BaseActivity))
    {
      BaseActivity localBaseActivity = (BaseActivity)getContext();
      if ((localBaseActivity.getAppRuntime() instanceof VideoAppInterface)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)localBaseActivity.getAppRuntime());
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131372565));
    this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372566));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372575);
    l();
    this.h = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372571));
    this.i = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372563));
    a(false);
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = new QavPanelSoundWaveView(getContext());
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(true);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297717));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams(localLayoutParams);
  }
  
  private void r()
  {
    if (this.h == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = ((ClipDrawable)this.h.getResources().getDrawable(2130841685));
    setBtnTopDrawableWithForeGround(this.h, 2130841684, this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable);
    this.h.setOnTouchListener(new mkn(this));
  }
  
  public static void setBtnTopDrawable(View paramView, int paramInt)
  {
    if ((paramView instanceof Button)) {
      setBtnTopDrawable((Button)paramView, paramInt);
    }
    while (!(paramView instanceof ImageButton)) {
      return;
    }
    a((ImageButton)paramView, paramInt);
  }
  
  public static void setBtnTopDrawable(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    if (c(paramInt)) {}
    for (Drawable localDrawable = mtv.a(paramTextView.getResources(), paramInt, false);; localDrawable = mtv.a(paramTextView.getResources(), paramInt))
    {
      paramTextView.setCompoundDrawables(null, localDrawable, null, null);
      return;
    }
  }
  
  public static void setBtnTopDrawableWithForeGround(TextView paramTextView, int paramInt, Drawable paramDrawable)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setCompoundDrawables(null, mtv.a(paramTextView.getResources(), paramInt, paramDrawable, false), null, null);
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewClickable, id" + mgu.a(paramInt));
    }
    View localView = b(paramInt);
    if (localView != null) {
      return localView.getVisibility();
    }
    return -1;
  }
  
  View a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(paramInt, this, false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public <T extends RelativeLayout> T a(int paramInt)
  {
    int m = paramInt;
    if (paramInt == 99) {
      m = this.jdField_c_of_type_Int;
    }
    if (this.jdField_a_of_type_ArrayOfMku[m] != null) {
      return this.jdField_a_of_type_ArrayOfMku[m].a();
    }
    return null;
  }
  
  public QavPanelSoundWaveView a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
  }
  
  mku a()
  {
    Object localObject = (AVActivity)getContext();
    localObject = new EffectSettingUi(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)localObject);
    ((EffectSettingUi)localObject).setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, (int)0.0F, 0, 0);
    ((EffectSettingUi)localObject).setGravity(80);
    ((RelativeLayout)findViewById(2131372548)).addView((View)localObject, localLayoutParams);
    ((EffectSettingUi)localObject).a(-1013L);
    return new mku((RelativeLayout)localObject, 2, new mkq(this));
  }
  
  public mtb a(int paramInt)
  {
    if (this.jdField_a_of_type_Mtd == null) {
      return null;
    }
    return this.jdField_a_of_type_Mtd.a(paramInt);
  }
  
  void a() {}
  
  public void a(int paramInt)
  {
    a(paramInt, false, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("updateEffectBtn, effectType[").append(paramInt).append("], mEffectDrawable[");
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + "], ignoreSetSelected[" + paramBoolean + "]");
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    o();
    int m = getResources().getDimensionPixelSize(2131297744);
    this.jdField_a_of_type_Int = paramInt;
    q();
    a(this.jdField_a_of_type_Int);
    switch (this.jdField_a_of_type_Int)
    {
    case 2131559610: 
    default: 
      label92:
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        addView(this.jdField_a_of_type_AndroidViewView);
        a(-1020L, 0, false);
      }
      k();
      Object localObject = (RelativeLayout)findViewById(2131380080);
      if (localObject != null)
      {
        ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
        ((RelativeLayout)localObject).bringChildToFront(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
      }
      d();
      this.jdField_a_of_type_Mkz = new mkz(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      getContext().registerReceiver(this.jdField_a_of_type_Mkz, (IntentFilter)localObject);
      this.jdField_a_of_type_Boolean = true;
      setBtnOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      h();
      i();
      b(paramBoolean1);
      if (!paramBoolean2) {
        break;
      }
    }
    for (paramInt = 2;; paramInt = 1)
    {
      c(paramInt);
      setBackgroundColor(33554431);
      if (AudioHelper.a(0) != 1) {
        break;
      }
      if (this.i != null) {
        this.i.setBackgroundColor(Color.argb(255, 68, 128, 2));
      }
      setBackgroundColor(-545259606);
      if (this.jdField_e_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_e_of_type_AndroidViewView.setBackgroundColor(2145129532);
      return;
      e(m);
      break label92;
      f(m);
      break label92;
      g(m);
      break label92;
      b(m, paramBoolean1, paramBoolean2);
      break label92;
      d(paramBoolean2);
      break label92;
      e(paramBoolean2);
      break label92;
      p();
      break label92;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Mkz != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_Mkz);
      this.jdField_a_of_type_Mkz = null;
    }
    this.jdField_e_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    EffectSettingUi localEffectSettingUi = (EffectSettingUi)a(2);
    if (localEffectSettingUi != null)
    {
      localEffectSettingUi.c(paramLong);
      this.jdField_a_of_type_ArrayOfMku[2] = null;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.c();
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    d(2);
    EffectSettingUi localEffectSettingUi = (EffectSettingUi)a(2);
    if (localEffectSettingUi == null) {}
    while (!localEffectSettingUi.a(paramLong, paramInt)) {
      return;
    }
    a(paramLong, 2, true);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int n = 3;
    if (!(getContext() instanceof AVActivity)) {
      return;
    }
    mku localmku = e();
    label137:
    int i1;
    label154:
    int m;
    boolean bool;
    if (localmku != null)
    {
      if (localmku.jdField_a_of_type_Int == paramInt)
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showMenu direct, menuType[" + paramInt + "], needAnimation[" + paramBoolean + "], seq[" + paramLong + "]");
        localmku.a(paramLong, paramBoolean, 3);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      }
      d(paramInt);
      if (this.jdField_a_of_type_ArrayOfMku[paramInt] == null) {
        break label290;
      }
      if (localmku != null) {
        break label292;
      }
      i1 = -1;
      if (i1 != 0) {
        break label302;
      }
      m = -1;
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showMenu, MenuType[" + i1 + "->" + paramInt + "], seq[" + paramLong + "]");
      this.jdField_c_of_type_Int = paramInt;
      QavPanel.4 local4 = new QavPanel.4(this, paramInt, paramLong, paramBoolean, n);
      if (localmku != null) {
        localmku.a(paramLong, bool, m, new mkp(this, local4));
      }
      if ((localmku != null) && (bool)) {
        break;
      }
      local4.run();
      return;
      d(paramInt);
      break label137;
      label290:
      break;
      label292:
      i1 = localmku.a();
      break label154;
      label302:
      if (i1 == 1)
      {
        if ((paramInt == 2) || (paramInt == 3))
        {
          m = 2;
          bool = true;
          continue;
        }
        if (paramInt == 0)
        {
          n = 4;
          m = 2;
          bool = true;
        }
      }
      else
      {
        if (i1 == -1)
        {
          m = -1;
          bool = false;
          continue;
        }
        if ((i1 == 2) || (i1 == 3))
        {
          if (paramInt == 0)
          {
            n = 4;
            m = 2;
            bool = true;
            continue;
          }
          if (paramInt == 1)
          {
            m = 2;
            bool = true;
            continue;
          }
        }
      }
      n = 4;
      bool = false;
      m = -1;
    }
  }
  
  void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(Animation.AnimationListener paramAnimationListener)
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation1.setFillEnabled(true);
      localAlphaAnimation1.setFillAfter(true);
      localAlphaAnimation1.setDuration(400L);
      AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation2.setFillEnabled(true);
      localAlphaAnimation2.setFillAfter(true);
      localAlphaAnimation2.setDuration(400L);
      localAlphaAnimation2.setAnimationListener(paramAnimationListener);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAlphaAnimation1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(localAlphaAnimation2);
    }
  }
  
  public void a(mvp parammvp)
  {
    if (this.f != null)
    {
      parammvp.a(this.f);
      parammvp.b();
    }
    while (this.jdField_a_of_type_AndroidWidgetImageButton == null) {
      return;
    }
    parammvp.a(this.jdField_a_of_type_AndroidWidgetImageButton);
    parammvp.b();
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(paramBoolean);
      c(paramInt);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "videoSession :" + paramBoolean1 + ", localHasVideo:" + paramInt + ", isVipFunCall:" + paramBoolean2);
    }
    b(paramBoolean1);
    c(paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable == null) {
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_e_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel(0);
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkView, id" + mgu.a(paramInt));
    }
    return b(paramInt) == null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewBackground, id" + mgu.a(paramInt1) + ", selected[" + paramInt2 + "]");
    }
    View localView = b(paramInt1);
    if (localView != null)
    {
      localView.setBackgroundResource(paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewMargin, id" + mgu.a(paramInt1) + ", direction[" + paramInt2 + "], margin[" + paramInt3 + "]");
    }
    if (paramInt3 < 0) {
      return false;
    }
    View localView = b(paramInt1);
    if (localView == null) {
      return false;
    }
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams == null) {
        return false;
      }
      if (paramInt2 == 1) {
        localLayoutParams.leftMargin = paramInt3;
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        return true;
        if (paramInt2 == 2) {
          localLayoutParams.rightMargin = paramInt3;
        } else if (paramInt2 == 4) {
          localLayoutParams.bottomMargin = paramInt3;
        } else if (paramInt2 == 3) {
          localLayoutParams.topMargin = paramInt3;
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewAccText, id" + mgu.a(paramInt) + ", text[" + paramString + "]");
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      mww.a(localView, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewAccText, id" + mgu.a(paramInt1) + ", text[" + paramString + "], audioType[" + paramInt2 + "]");
    }
    View localView = b(paramInt1);
    if (localView != null)
    {
      mww.a(localView, paramString, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewSelected, id" + mgu.a(paramInt) + ", selected[" + paramBoolean + "]");
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      localView.setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(mla parammla)
  {
    if (this.jdField_a_of_type_Mlb == null) {
      return false;
    }
    this.jdField_a_of_type_Mlb.a(parammla);
    return true;
  }
  
  public boolean a(mwk parammwk)
  {
    if ((parammwk != null) && (this.i != null))
    {
      parammwk.b(this.i);
      return true;
    }
    return false;
  }
  
  public View b(int paramInt)
  {
    Button localButton = null;
    switch (paramInt)
    {
    default: 
      String str = alpo.a(2131709319) + paramInt + "]，Name[" + mgu.a(paramInt) + "]，Name[" + AudioHelper.a(this, paramInt);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, str);
      if (AudioHelper.d()) {
        throw new IllegalArgumentException(str);
      }
    case 2131372571: 
      localButton = this.h;
      return localButton;
    case 2131364128: 
      return this.jdField_a_of_type_AndroidWidgetTextView;
    case 2131362956: 
      return this.jdField_a_of_type_AndroidWidgetButton;
    case 2131372730: 
      return this.jdField_c_of_type_AndroidWidgetButton;
    case 2131372731: 
      return this.jdField_d_of_type_AndroidWidgetButton;
    case 2131362968: 
      return this.jdField_b_of_type_AndroidWidgetButton;
    case 2131372557: 
      return this.j;
    case 2131372563: 
      return this.i;
    case 2131372565: 
      return this.jdField_a_of_type_AndroidWidgetImageButton;
    case 2131372566: 
      return this.f;
    case 2131372568: 
      return this.jdField_d_of_type_AndroidViewView;
    case 2131372726: 
      return this.jdField_c_of_type_AndroidViewView;
    case 2131362967: 
      return this.jdField_e_of_type_AndroidWidgetButton;
    case 2131372570: 
      return this.k;
    case 2131372727: 
      return this.jdField_a_of_type_AndroidWidgetImageView;
    case 2131372574: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    case 2131372573: 
      return this.g;
    case 2131372873: 
      return this.jdField_e_of_type_AndroidViewView;
    case 2131372877: 
      return this.jdField_b_of_type_AndroidWidgetImageButton;
    }
    return this.jdField_c_of_type_AndroidWidgetImageButton;
  }
  
  mku b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372550);
    if (localRelativeLayout != null)
    {
      if (AudioHelper.a(0) == 1) {
        localRelativeLayout.setBackgroundColor(2142236398);
      }
      return new mku(localRelativeLayout, 0, null);
    }
    return null;
  }
  
  void b()
  {
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372730));
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_c_of_type_AndroidWidgetButton, 2130841812, 2131165887, 2131165887);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Mtd == null) {
      return;
    }
    mtd localmtd = this.jdField_a_of_type_Mtd;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localmtd.a(bool);
      return;
    }
  }
  
  void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    }
    c(paramBoolean);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(paramBoolean);
      c(paramInt);
      return;
    }
  }
  
  public boolean b(int paramInt)
  {
    return paramInt == this.jdField_c_of_type_Int;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return b(paramInt1, paramInt2, -1);
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewRule, id" + mgu.a(paramInt1) + ", verb[" + paramInt2 + "], anchor[" + paramInt3 + "]");
    }
    View localView = b(paramInt1);
    if (localView != null) {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.addRule(paramInt2, paramInt3);
        localView.setLayoutParams(localLayoutParams);
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return false;
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewClickable, id" + mgu.a(paramInt));
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      localView.setClickable(paramBoolean);
      return true;
    }
    return false;
  }
  
  mku c()
  {
    Object localObject = getContext();
    if ((this.jdField_a_of_type_Mtd == null) || (localObject == null) || (!(localObject instanceof AVActivity))) {
      return null;
    }
    localObject = new QavOperationMenuView((Context)localObject);
    ((QavOperationMenuView)localObject).setGravity(80);
    ((QavOperationMenuView)localObject).setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout)findViewById(2131372548)).addView((View)localObject, localLayoutParams);
    ((QavOperationMenuView)localObject).setAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    ((QavOperationMenuView)localObject).setViewController(this.jdField_a_of_type_Mtd);
    ((QavOperationMenuView)localObject).setQavMenuActionListener(new mkr(this));
    ((QavOperationMenuView)localObject).a();
    return new mku((RelativeLayout)localObject, 1, new mks(this));
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372727));
    this.jdField_a_of_type_Mlb = new mlb(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131721272));
      this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new mkm(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_Mlb);
  }
  
  public void c(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      while (AudioHelper.a(0) == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-536894208);
        return;
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if (this.g != null)
      {
        this.g.setClickable(false);
        this.g.setEnabled(false);
      }
    }
  }
  
  mku d()
  {
    Object localObject = getContext();
    if ((this.jdField_a_of_type_Mtd == null) || (!(localObject instanceof AVActivity))) {
      return null;
    }
    localObject = new QavBeautyMenuPanel((Context)localObject);
    ((QavBeautyMenuPanel)localObject).setGravity(80);
    ((QavBeautyMenuPanel)localObject).setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout)findViewById(2131372548)).addView((View)localObject, localLayoutParams);
    ((QavBeautyMenuPanel)localObject).setAppInterface(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    ((QavBeautyMenuPanel)localObject).a();
    return new mku((RelativeLayout)localObject, 3, new mkt(this));
  }
  
  void d()
  {
    Object localObject = getResources().getDisplayMetrics();
    int n = getResources().getDimensionPixelSize(2131297717);
    int i1 = getResources().getDimensionPixelSize(2131297714);
    int m = 0;
    if (this.jdField_a_of_type_Int == 2131559606) {
      m = ((DisplayMetrics)localObject).widthPixels * 880 / 750;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "adjustPanel, heightPixels[" + ((DisplayMetrics)localObject).heightPixels + "], widthPixels[" + ((DisplayMetrics)localObject).widthPixels + "], waveHeight[" + n + "], shadowHeight[" + i1 + "], videoHeight[" + m + "], mPanelType[" + this.jdField_a_of_type_Int + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = n;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  void d(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfMku[paramInt] != null) {
      return;
    }
    mku localmku = null;
    if (paramInt == 1) {
      localmku = c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfMku[paramInt] = localmku;
      return;
      if (paramInt == 0) {
        localmku = b();
      } else if (paramInt == 2) {
        localmku = a();
      } else if (paramInt == 3) {
        localmku = d();
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.f();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.g();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void g()
  {
    mku localmku = this.jdField_a_of_type_ArrayOfMku[1];
    if (localmku == null) {}
    while ((!localmku.jdField_a_of_type_Boolean) || (!(localmku.jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavOperationMenuView))) {
      return;
    }
    ((QavOperationMenuView)localmku.jdField_a_of_type_AndroidWidgetRelativeLayout).a();
    ((QavOperationMenuView)localmku.jdField_a_of_type_AndroidWidgetRelativeLayout).a();
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364128));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165971));
    }
  }
  
  void i()
  {
    r();
    setBtnTopDrawable(this.i, 2130841692);
    setBtnTopDrawable(this.jdField_d_of_type_AndroidViewView, 2130841648);
    setBtnTopDrawable(this.jdField_e_of_type_AndroidViewView, 2130841650);
    setBtnTopDrawable(this.jdField_b_of_type_AndroidWidgetImageButton, 2130841668);
    setBtnTopDrawable(this.jdField_c_of_type_AndroidWidgetImageButton, 2130841934);
  }
  
  public boolean isPressed()
  {
    return (super.isPressed()) || ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.isPressed())) || ((this.h != null) && (this.h.isPressed())) || ((this.i != null) && (this.i.isPressed()));
  }
  
  public void j()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_Mtd != null) {
      return;
    }
    this.jdField_a_of_type_Mtd = mtc.a(getResources(), this.jdField_a_of_type_Int);
  }
  
  public void setAcceptDrawableTop(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(null, paramDrawable, null, null);
  }
  
  public void setAudioVolumeValue(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable == null) || (this.h == null) || ((this.h != null) && (!this.h.isShown()))) {
      return;
    }
    int m = this.jdField_e_of_type_Int;
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int != m)
    {
      if ((this.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break label222;
      }
      paramInt = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      m = paramInt;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new mko(this));
      }
      int n;
      ValueAnimator localValueAnimator;
      long l;
      if (this.jdField_e_of_type_Int > m)
      {
        n = 1;
        localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (n == 0) {
          break label199;
        }
        l = 100L;
        label148:
        localValueAnimator.setDuration(l);
        localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (paramInt != -1) {
          break label207;
        }
      }
      for (;;)
      {
        localValueAnimator.setIntValues(new int[] { m, this.jdField_e_of_type_Int });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        return;
        n = 0;
        break;
        label199:
        l = 200L;
        break label148;
        label207:
        m = paramInt;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel(paramInt);
      return;
      label222:
      paramInt = -1;
    }
  }
  
  public void setBtnOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
    if (this.h != null) {
      this.h.setOnTouchListener(paramOnTouchListener);
    }
    if (this.i != null) {
      this.i.setOnTouchListener(paramOnTouchListener);
    }
  }
  
  public void setEffectOperateDrawable(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setEffectOperateDrawable");
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setNoVideoAndShareBtnMode()
  {
    if (this.jdField_a_of_type_Mtd != null)
    {
      this.jdField_a_of_type_Mtd.a(2131695807);
      this.jdField_a_of_type_Mtd.a(2131695811);
      this.jdField_a_of_type_Mtd.a(2131695813);
    }
  }
  
  public void setViewEnable(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewEnable, id" + mgu.a(paramInt) + ", enable[" + paramBoolean + "]");
    }
    View localView = b(paramInt);
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    View localView = b(paramInt1);
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("setViewVisibility, id").append(mgu.a(paramInt1)).append("], view[");
      if (localView == null) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + "], visibility[" + paramInt2 + "]");
      if (localView != null) {
        localView.setVisibility(paramInt2);
      }
      return;
    }
  }
  
  public void setWaveVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "timWaveView setWaveVisibility visibility:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel
 * JD-Core Version:    0.7.0.1
 */