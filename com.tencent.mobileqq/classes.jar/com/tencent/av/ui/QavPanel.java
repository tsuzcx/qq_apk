package com.tencent.av.ui;

import afur;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anni;
import bcst;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.av.ui.virtual.QavVirtualMenuView;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import ley;
import mce;
import mdy;
import mgi;
import mgl;
import mhq;
import mhr;
import mhs;
import mht;
import mhu;
import mhv;
import mhw;
import mhx;
import mhy;
import mia;
import mib;
import mic;
import mid;
import mqg;
import mqh;
import mqi;
import mqq.app.BaseActivity;
import mrb;
import msn;
import msv;
import msx;
import msy;
import mts;
import mue;

public class QavPanel
  extends RelativeLayout
{
  public static int i;
  int jdField_a_of_type_Int = 0;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public ClipDrawable a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
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
  private mhy jdField_a_of_type_Mhy = new mhy(this, Looper.getMainLooper());
  mia jdField_a_of_type_Mia = null;
  private mic jdField_a_of_type_Mic;
  public mid a;
  mqi jdField_a_of_type_Mqi = null;
  private msx jdField_a_of_type_Msx;
  private msy jdField_a_of_type_Msy;
  boolean jdField_a_of_type_Boolean = false;
  mgi[] jdField_a_of_type_ArrayOfMgi = new mgi[5];
  int jdField_b_of_type_Int = -1;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  View jdField_b_of_type_AndroidViewView = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public final int c;
  View jdField_c_of_type_AndroidViewView = null;
  Button jdField_c_of_type_AndroidWidgetButton = null;
  ImageButton jdField_c_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  private volatile boolean jdField_c_of_type_Boolean;
  public final int d;
  View jdField_d_of_type_AndroidViewView = null;
  Button jdField_d_of_type_AndroidWidgetButton = null;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  public final int e;
  View jdField_e_of_type_AndroidViewView = null;
  Button jdField_e_of_type_AndroidWidgetButton = null;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean;
  public final int f;
  private View jdField_f_of_type_AndroidViewView;
  Button jdField_f_of_type_AndroidWidgetButton = null;
  private boolean jdField_f_of_type_Boolean;
  public final int g;
  Button g;
  public final int h;
  public Button h;
  Button i;
  private int jdField_j_of_type_Int;
  Button jdField_j_of_type_AndroidWidgetButton = null;
  private int jdField_k_of_type_Int;
  Button jdField_k_of_type_AndroidWidgetButton = null;
  private int l = 1;
  
  static
  {
    jdField_i_of_type_Int = 2131378242;
  }
  
  public QavPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_g_of_type_AndroidWidgetButton = null;
    this.jdField_h_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    this.jdField_i_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 256;
    this.jdField_d_of_type_Int = 257;
    this.jdField_e_of_type_Int = 258;
    this.jdField_f_of_type_Int = 259;
    this.jdField_g_of_type_Int = 260;
    this.jdField_h_of_type_Int = 261;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_g_of_type_AndroidWidgetButton = null;
    this.jdField_h_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    this.jdField_i_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 256;
    this.jdField_d_of_type_Int = 257;
    this.jdField_e_of_type_Int = 258;
    this.jdField_f_of_type_Int = 259;
    this.jdField_g_of_type_Int = 260;
    this.jdField_h_of_type_Int = 261;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_g_of_type_AndroidWidgetButton = null;
    this.jdField_h_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
    this.jdField_i_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 256;
    this.jdField_d_of_type_Int = 257;
    this.jdField_e_of_type_Int = 258;
    this.jdField_f_of_type_Int = 259;
    this.jdField_g_of_type_Int = 260;
    this.jdField_h_of_type_Int = 261;
    a();
  }
  
  static void a(ImageButton paramImageButton, int paramInt)
  {
    if (paramImageButton == null) {
      return;
    }
    paramImageButton.setImageDrawable(mrb.b(paramImageButton.getResources(), paramInt));
    paramImageButton.setAdjustViewBounds(true);
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373211);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373201));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373202));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373185));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373187));
    this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373193));
    Drawable localDrawable;
    if (this.jdField_j_of_type_AndroidWidgetButton != null)
    {
      localDrawable = getResources().getDrawable(2130841975);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.jdField_j_of_type_AndroidWidgetButton.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373206));
    if (this.jdField_k_of_type_AndroidWidgetButton != null)
    {
      localDrawable = getResources().getDrawable(2130841994);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.jdField_k_of_type_AndroidWidgetButton.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    m();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373210));
    this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373209));
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373207));
    this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373199));
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
  
  private mgi c()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_a_of_type_ArrayOfMgi[this.jdField_b_of_type_Int];
    }
    return null;
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      bool = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f();
    }
    return bool;
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt == 2130842000) || (paramInt == 2130842010) || (paramInt == 2130842011);
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Int == 2131559742;
  }
  
  private void e(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373211);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363071));
    this.jdField_d_of_type_AndroidViewView = ((ViewGroup)getParent()).findViewById(2131373204);
    n();
    o();
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373371));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373201));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373202));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373211);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373207));
    l();
    this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373199));
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_Mic != null) && (this.jdField_a_of_type_Mic.b());
  }
  
  private void f(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373211);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373369));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373370));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373217));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373367);
    n();
    o();
    b();
    c();
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373201));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373202));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373211);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373207));
    l();
    this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373199));
  }
  
  private void g(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363071));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373369));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373370));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373217));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373367);
    b();
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373372));
    c();
  }
  
  private void h(int paramInt)
  {
    i(paramInt);
    setBtnTopDrawable(this.jdField_i_of_type_AndroidWidgetButton, 2130842010);
    setBtnTopDrawable(this.jdField_d_of_type_AndroidViewView, 2130841964);
    setBtnTopDrawable(this.jdField_e_of_type_AndroidViewView, 2130841966);
    setBtnTopDrawable(this.jdField_b_of_type_AndroidWidgetImageButton, 2130841984);
    setBtnTopDrawable(this.jdField_c_of_type_AndroidWidgetImageButton, 2130842255);
  }
  
  private void i(int paramInt)
  {
    boolean bool2 = false;
    if (this.jdField_h_of_type_AndroidWidgetButton == null) {
      return;
    }
    boolean bool1;
    if ((paramInt == 2131559748) || (paramInt == 2131559747))
    {
      bool1 = true;
      if (msn.d()) {
        break label106;
      }
      bool1 = bool2;
    }
    label106:
    for (;;)
    {
      this.jdField_d_of_type_Boolean = bool1;
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = ((ClipDrawable)this.jdField_h_of_type_AndroidWidgetButton.getResources().getDrawable(2130842001));
        setBtnTopDrawableWithForeGround(this.jdField_h_of_type_AndroidWidgetButton, 2130842000, this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable);
        this.jdField_h_of_type_AndroidWidgetButton.setOnTouchListener(new mhr(this));
        return;
        bool1 = false;
        break;
      }
      s();
      return;
    }
  }
  
  private void l()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    this.jdField_f_of_type_AndroidViewView = localView.findViewById(2131373304);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373533));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373303));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373305));
    this.jdField_a_of_type_Msx = new msx((Activity)localView.getContext());
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Msx.a());
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void m()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    this.jdField_d_of_type_AndroidViewView = localViewGroup.findViewById(2131373204);
    if ((this.jdField_d_of_type_AndroidViewView == null) && (AudioHelper.e())) {
      throw new IllegalArgumentException("没找到VIEW_ENUM.HIDE");
    }
    this.jdField_e_of_type_AndroidViewView = localViewGroup.findViewById(2131373514);
    this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)localViewGroup.findViewById(2131373512));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)localViewGroup.findViewById(2131373518));
    getRootView();
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363083));
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_b_of_type_AndroidWidgetButton, 2130841923, 2131165942, 2131165942);
    }
  }
  
  private void o()
  {
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363082));
    if (this.jdField_e_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_e_of_type_AndroidWidgetButton, 2130841949, 2131165942, 2131165942);
    }
  }
  
  private void p()
  {
    if ((getContext() instanceof BaseActivity))
    {
      BaseActivity localBaseActivity = (BaseActivity)getContext();
      if ((localBaseActivity.getAppRuntime() instanceof VideoAppInterface)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)localBaseActivity.getAppRuntime());
      }
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373201));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373202));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373211);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373207));
    this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373199));
    a(false);
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = new QavPanelSoundWaveView(getContext());
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(true);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297796));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams(localLayoutParams);
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(1);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setSize(afur.a(64.0F, getResources()), afur.a(64.0F, getResources()));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(1291845632);
    this.jdField_a_of_type_Msy = new msy(afur.a(64.0F, getResources()), afur.a(64.0F, getResources()));
    this.jdField_a_of_type_Msy.a(0, BitmapFactory.decodeResource(getResources(), 2130842002));
    this.jdField_a_of_type_Msy.a(0, BitmapFactory.decodeResource(getResources(), 2130842003));
    this.jdField_a_of_type_Msy.a(1, BitmapFactory.decodeResource(getResources(), 2130842004));
    this.jdField_a_of_type_Msy.a(2, BitmapFactory.decodeResource(getResources(), 2130842004));
    this.jdField_a_of_type_Msy.a(2, BitmapFactory.decodeResource(getResources(), 2130842006));
    this.jdField_a_of_type_Msy.a(3, BitmapFactory.decodeResource(getResources(), 2130842007));
    this.jdField_a_of_type_Msy.a(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable, this.jdField_a_of_type_Msy });
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(0, 0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(1, 0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setBounds(0, 0, this.jdField_a_of_type_Msy.getIntrinsicWidth(), this.jdField_a_of_type_Msy.getIntrinsicHeight());
    this.jdField_h_of_type_AndroidWidgetButton.setCompoundDrawables(null, this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable, null, null);
    this.jdField_h_of_type_AndroidWidgetButton.setOnTouchListener(new mhs(this));
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
    for (Drawable localDrawable = mrb.a(paramTextView.getResources(), paramInt, false);; localDrawable = mrb.a(paramTextView.getResources(), paramInt))
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
    paramTextView.setCompoundDrawables(null, mrb.a(paramTextView.getResources(), paramInt, paramDrawable, false), null, null);
  }
  
  private void t()
  {
    if (!b()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "tryPerformLongClick cannot switch muteStatus");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Mic.a())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "tryPerformLongClick cannot checkBlockMuteStatus");
        return;
      }
    } while (a() != 1);
    ley localley = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (d())
    {
      localley.a("tryPerformLongClick", false);
      localley.b("tryPerformLongClick", 3);
      a("tryPerformLongClick", 1, 3, true);
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800ADE2", "0X800ADE2", localley.jdField_d_of_type_Int, 0, "", "", "", "");
      this.jdField_a_of_type_Mhy.sendEmptyMessageDelayed(261, 4000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a("tryPerformLongClick", this.jdField_a_of_type_Mic.a(), true, true, 3);
      a("tryPerformLongClick", 1, 3, false);
      this.jdField_a_of_type_Mic.a(true, true);
    }
  }
  
  @TargetApi(11)
  private void u()
  {
    if ((this.jdField_h_of_type_AndroidWidgetButton == null) || ((this.jdField_h_of_type_AndroidWidgetButton != null) && (!this.jdField_h_of_type_AndroidWidgetButton.isShown())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    while (a() != 1) {
      return;
    }
    if (d())
    {
      ley localley = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      localley.a("tryPlayBtnMuteAnimation", true);
      localley.b("tryPlayBtnMuteAnimation", 2);
      a("tryPlayBtnMuteAnimation start", 1, 2, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mic.a();
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 3000 });
        this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(3000L);
        this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new mhu(this));
        this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new mhv(this, new int[] { 250, 2750, 3000 }));
      }
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()) {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      this.jdField_f_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().h("tryPlayBtnMuteAnimation onAnimationEnd", 2);
      a("tryPlayBtnMuteAnimation", 1, 2, false);
      this.jdField_a_of_type_Mic.a(false, false);
    }
  }
  
  private void v()
  {
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public int a()
  {
    ley localley = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (this.jdField_a_of_type_Int == 2131559742) {
      return localley.a();
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f();
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewClickable, id" + mdy.a(paramInt));
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
      m = this.jdField_b_of_type_Int;
    }
    if (this.jdField_a_of_type_ArrayOfMgi[m] != null) {
      return this.jdField_a_of_type_ArrayOfMgi[m].a();
    }
    return null;
  }
  
  public QavPanelSoundWaveView a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
  }
  
  mgi a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373186);
    if (localRelativeLayout != null)
    {
      if (AudioHelper.a(0) == 1) {
        localRelativeLayout.setBackgroundColor(2142236398);
      }
      return new mgi(localRelativeLayout, 0, null);
    }
    return null;
  }
  
  mgi a(int paramInt, mgl parammgl)
  {
    Object localObject = getContext();
    if ((this.jdField_a_of_type_Mqi == null) || (!(localObject instanceof AVActivity))) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      ((QavMenuBaseView)localObject).setVisibility(8);
      ((QavMenuBaseView)localObject).setGravity(80);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout)findViewById(2131373184)).addView((View)localObject, localLayoutParams);
      ((QavMenuBaseView)localObject).a(this);
      ((QavMenuBaseView)localObject).f();
      return new mgi((RelativeLayout)localObject, paramInt, parammgl);
      localObject = new QavVirtualMenuView((Context)localObject);
      continue;
      localObject = new QavBeautyMenuPanel((Context)localObject);
      continue;
      localObject = new EffectSettingUi((Context)localObject);
      continue;
      localObject = new QavOperationMenuView((Context)localObject);
    }
  }
  
  public mqg a(int paramInt)
  {
    if (this.jdField_a_of_type_Mqi == null) {
      return null;
    }
    return this.jdField_a_of_type_Mqi.a(paramInt);
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
    p();
    int m = getResources().getDimensionPixelSize(2131297823);
    this.jdField_a_of_type_Int = paramInt;
    r();
    a(this.jdField_a_of_type_Int);
    switch (this.jdField_a_of_type_Int)
    {
    case 2131559746: 
    default: 
      label92:
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        addView(this.jdField_a_of_type_AndroidViewView);
        a(-1020L, 0, false);
      }
      k();
      Object localObject = (RelativeLayout)findViewById(2131381103);
      if (localObject != null)
      {
        ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
        ((RelativeLayout)localObject).bringChildToFront(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
      }
      d();
      this.jdField_a_of_type_Mia = new mia(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      getContext().registerReceiver(this.jdField_a_of_type_Mia, (IntentFilter)localObject);
      this.jdField_a_of_type_Boolean = true;
      setBtnOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      h();
      h(this.jdField_a_of_type_Int);
      c(paramBoolean1);
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
      if (this.jdField_i_of_type_AndroidWidgetButton != null) {
        this.jdField_i_of_type_AndroidWidgetButton.setBackgroundColor(Color.argb(255, 68, 128, 2));
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
      e(paramBoolean2);
      break label92;
      f(paramBoolean2);
      break label92;
      q();
      break label92;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Mia != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_Mia);
      this.jdField_a_of_type_Mia = null;
    }
    this.jdField_j_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    int m = 0;
    while (m < this.jdField_a_of_type_ArrayOfMgi.length)
    {
      if ((this.jdField_a_of_type_ArrayOfMgi[m] != null) && ((this.jdField_a_of_type_ArrayOfMgi[m].jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavMenuBaseView))) {
        ((QavMenuBaseView)this.jdField_a_of_type_ArrayOfMgi[m].jdField_a_of_type_AndroidWidgetRelativeLayout).b(paramLong);
      }
      this.jdField_a_of_type_ArrayOfMgi[m] = null;
      m += 1;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.c();
    }
    v();
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
    mgi localmgi = c();
    label137:
    int i1;
    label154:
    int m;
    boolean bool1;
    if (localmgi != null)
    {
      if (localmgi.jdField_a_of_type_Int == paramInt)
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showMenu direct, menuType[" + paramInt + "], needAnimation[" + paramBoolean + "], seq[" + paramLong + "]");
        localmgi.a(paramLong, paramBoolean, 3);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      }
      d(paramInt);
      if (this.jdField_a_of_type_ArrayOfMgi[paramInt] == null) {
        break label361;
      }
      if (localmgi != null) {
        break label363;
      }
      i1 = -1;
      if (i1 != 0) {
        break label373;
      }
      m = -1;
      bool1 = false;
    }
    for (;;)
    {
      label165:
      Object localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("showMenu, MenuType[").append(i1).append("->").append(paramInt).append("], seq[").append(paramLong).append("], isVisible[");
      boolean bool2;
      if (getVisibility() == 0)
      {
        bool2 = true;
        label227:
        QLog.w((String)localObject, 1, bool2 + "]");
        this.jdField_b_of_type_Int = paramInt;
        if ((i1 != this.jdField_b_of_type_Int) && (i1 == 0))
        {
          a("showMenu", 0);
          this.jdField_a_of_type_Mhy.removeMessages(257);
        }
        localObject = new QavPanel.7(this, paramInt, paramLong, paramBoolean, n);
        if (getVisibility() == 0) {
          break label477;
        }
      }
      label477:
      for (paramBoolean = false;; paramBoolean = bool1)
      {
        if (localmgi != null) {
          localmgi.a(paramLong, paramBoolean, m, new mhw(this, (Runnable)localObject));
        }
        if ((localmgi != null) && (paramBoolean)) {
          break;
        }
        ((Runnable)localObject).run();
        return;
        d(paramInt);
        break label137;
        label361:
        break;
        label363:
        i1 = localmgi.a();
        break label154;
        label373:
        if (i1 == 1)
        {
          if ((paramInt == 2) || (paramInt == 3))
          {
            m = 2;
            bool1 = true;
            break label165;
          }
          if (paramInt != 0) {
            break label484;
          }
          n = 4;
          m = 2;
          bool1 = true;
          break label165;
        }
        if (i1 == -1)
        {
          m = -1;
          bool1 = false;
          break label165;
        }
        if ((i1 != 2) && (i1 != 3)) {
          break label484;
        }
        if (paramInt == 0)
        {
          n = 4;
          m = 2;
          bool1 = true;
          break label165;
        }
        if (paramInt != 1) {
          break label484;
        }
        m = 2;
        bool1 = true;
        break label165;
        bool2 = false;
        break label227;
      }
      label484:
      n = 4;
      bool1 = false;
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
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "pressSpeaking showPressSpeakingGuider, from[1], text[" + paramString + "], mVoiceGuiderRootContent[" + this.jdField_f_of_type_AndroidViewView + "]");
    if (this.jdField_f_of_type_AndroidViewView != null)
    {
      this.l = 1;
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.getBackground().setAlpha(255);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "pressSpeaking hidePressSpreakingGuiderOrTips, from[" + paramString + "], tipsType[" + paramInt + "]");
    if ((this.jdField_f_of_type_AndroidViewView != null) && ((this.l == paramInt) || (paramInt == 0))) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  @TargetApi(11)
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doSpeakerStatusChange from:=" + paramString + ";lastStatus:=" + paramInt1 + ";nextStatus:=" + paramInt2);
    if ((paramInt2 == paramInt1) || (!this.jdField_d_of_type_Boolean)) {
      return;
    }
    boolean bool1;
    switch (paramInt2)
    {
    default: 
      bool1 = false;
    case 0: 
      while ((this.jdField_a_of_type_Mic != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramBoolean) && (d()))
      {
        this.jdField_a_of_type_Mic.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g, bool1);
        return;
        if (paramInt1 == 2) {
          v();
        }
        a("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(1291845632);
        this.jdField_a_of_type_Msy.setAlpha(255);
        this.jdField_a_of_type_Msy.a(0);
        bool1 = bool2;
        if (!mue.a(true))
        {
          this.jdField_a_of_type_Mhy.removeMessages(259);
          this.jdField_a_of_type_Mhy.sendEmptyMessageAtTime(259, 300L);
          bool1 = bool2;
        }
      }
    case 1: 
      if (paramInt1 == 0)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "test has call keep speaking status");
        bool1 = true;
      }
      break;
    }
    for (;;)
    {
      a("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
      this.jdField_a_of_type_Msy.setAlpha(255);
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setAlpha(255);
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-1);
      this.jdField_a_of_type_Msy.a(1);
      a(2131373207, getResources().getString(2131692578));
      if ((!this.jdField_f_of_type_Boolean) && (e()))
      {
        this.jdField_a_of_type_Mhy.removeMessages(257);
        this.jdField_a_of_type_Mhy.sendEmptyMessageDelayed(257, 5300L);
      }
      if (!mue.a(false))
      {
        this.jdField_a_of_type_Mhy.removeMessages(258);
        this.jdField_a_of_type_Mhy.sendEmptyMessageDelayed(258, 300L);
        break;
        if (paramInt1 == 2)
        {
          v();
          bool1 = false;
          continue;
        }
        if (paramInt1 != 3) {
          break label505;
        }
        bool1 = true;
        continue;
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setAlpha(255);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-1);
        this.jdField_a_of_type_Msy.a(2);
        bool1 = false;
        break;
        this.jdField_a_of_type_Msy.setAlpha(127);
        this.jdField_a_of_type_Msy.a(3);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setAlpha(127);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-1);
        i();
        this.jdField_k_of_type_Int += 1;
        bool1 = bool2;
        break;
      }
      break;
      label505:
      bool1 = false;
    }
  }
  
  public void a(mic parammic)
  {
    this.jdField_a_of_type_Mic = parammic;
  }
  
  public void a(msv parammsv)
  {
    if (this.jdField_f_of_type_AndroidWidgetButton != null)
    {
      parammsv.a(this.jdField_f_of_type_AndroidWidgetButton);
      parammsv.b();
    }
    while (this.jdField_a_of_type_AndroidWidgetImageButton == null) {
      return;
    }
    parammsv.a(this.jdField_a_of_type_AndroidWidgetImageButton);
    parammsv.b();
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c(paramBoolean);
      c(paramInt);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "videoSession :" + paramBoolean1 + ", localHasVideo:" + paramInt + ", isVipFunCall:" + paramBoolean2);
    }
    c(paramBoolean1);
    c(paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_j_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel(0);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_Msx.a(0);
        this.jdField_a_of_type_Msy.b(0);
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkView, id" + mdy.a(paramInt));
    }
    return b(paramInt) == null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewBackground, id" + mdy.a(paramInt1) + ", selected[" + paramInt2 + "]");
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewMargin, id" + mdy.a(paramInt1) + ", direction[" + paramInt2 + "], margin[" + paramInt3 + "]");
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewAccText, id" + mdy.a(paramInt) + ", text[" + paramString + "]");
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      mue.a(localView, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewAccText, id" + mdy.a(paramInt1) + ", text[" + paramString + "], audioType[" + paramInt2 + "]");
    }
    View localView = b(paramInt1);
    if (localView != null)
    {
      mue.a(localView, paramString, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewSelected, id" + mdy.a(paramInt) + ", selected[" + paramBoolean + "]");
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      localView.setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(mib parammib)
  {
    if (this.jdField_a_of_type_Mid == null) {
      return false;
    }
    this.jdField_a_of_type_Mid.a(parammib);
    return true;
  }
  
  public boolean a(mts parammts)
  {
    if ((parammts != null) && (this.jdField_i_of_type_AndroidWidgetButton != null))
    {
      parammts.b(this.jdField_i_of_type_AndroidWidgetButton);
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
      String str = anni.a(2131707707) + paramInt + "]，Name[" + mdy.a(paramInt) + "]，Name[" + AudioHelper.a(this, paramInt);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, str);
      if (AudioHelper.e()) {
        throw new IllegalArgumentException(str);
      }
    case 2131373207: 
      localButton = this.jdField_h_of_type_AndroidWidgetButton;
      return localButton;
    case 2131364337: 
      return this.jdField_a_of_type_AndroidWidgetTextView;
    case 2131363071: 
      return this.jdField_a_of_type_AndroidWidgetButton;
    case 2131373371: 
      return this.jdField_c_of_type_AndroidWidgetButton;
    case 2131373372: 
      return this.jdField_d_of_type_AndroidWidgetButton;
    case 2131363083: 
      return this.jdField_b_of_type_AndroidWidgetButton;
    case 2131373193: 
      return this.jdField_j_of_type_AndroidWidgetButton;
    case 2131373199: 
      return this.jdField_i_of_type_AndroidWidgetButton;
    case 2131373201: 
      return this.jdField_a_of_type_AndroidWidgetImageButton;
    case 2131373202: 
      return this.jdField_f_of_type_AndroidWidgetButton;
    case 2131373204: 
      return this.jdField_d_of_type_AndroidViewView;
    case 2131373367: 
      return this.jdField_c_of_type_AndroidViewView;
    case 2131363082: 
      return this.jdField_e_of_type_AndroidWidgetButton;
    case 2131373206: 
      return this.jdField_k_of_type_AndroidWidgetButton;
    case 2131373368: 
      return this.jdField_a_of_type_AndroidWidgetImageView;
    case 2131373210: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    case 2131373209: 
      return this.jdField_g_of_type_AndroidWidgetButton;
    case 2131373514: 
      return this.jdField_e_of_type_AndroidViewView;
    case 2131373518: 
      return this.jdField_b_of_type_AndroidWidgetImageButton;
    }
    return this.jdField_c_of_type_AndroidWidgetImageButton;
  }
  
  mgi b()
  {
    mgi localmgi = a(1, new mce(null));
    if ((localmgi != null) && ((localmgi.jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavOperationMenuView)))
    {
      QavOperationMenuView localQavOperationMenuView = (QavOperationMenuView)localmgi.jdField_a_of_type_AndroidWidgetRelativeLayout;
      localQavOperationMenuView.setViewController(this.jdField_a_of_type_Mqi);
      localQavOperationMenuView.setQavMenuActionListener(new mhx(this));
    }
    return localmgi;
  }
  
  void b()
  {
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373371));
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_c_of_type_AndroidWidgetButton, 2130842132, 2131165942, 2131165942);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Mqi == null) {
      return;
    }
    mqi localmqi = this.jdField_a_of_type_Mqi;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localmqi.a(bool);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    label239:
    do
    {
      return;
      if ((d()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f() == 1) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "refreshButtonStatus, from[1], mute[" + paramBoolean + "], canRefresh[" + bool + "]");
        if ((!this.jdField_d_of_type_Boolean) || (!bool)) {
          break;
        }
        if (!paramBoolean) {
          break label239;
        }
        this.jdField_a_of_type_Msy.setAlpha(255);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setAlpha(255);
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-1);
        this.jdField_a_of_type_Msy.a(1);
        a(2131373207, getResources().getString(2131692578));
        if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Mhy != null) && (e()))
        {
          this.jdField_a_of_type_Mhy.removeMessages(257);
          this.jdField_a_of_type_Mhy.sendEmptyMessageDelayed(257, 5300L);
        }
        if (mue.a(false)) {
          break;
        }
        this.jdField_a_of_type_Mhy.removeMessages(258);
        this.jdField_a_of_type_Mhy.sendEmptyMessageDelayed(258, 300L);
        return;
      }
      this.jdField_a_of_type_Msy.setAlpha(255);
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setAlpha(255);
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(1291845632);
      this.jdField_a_of_type_Msy.a(0);
      if (this.jdField_a_of_type_Mhy != null) {
        this.jdField_a_of_type_Mhy.removeMessages(257);
      }
    } while (mue.a(true));
    this.jdField_a_of_type_Mhy.removeMessages(259);
    this.jdField_a_of_type_Mhy.sendEmptyMessageDelayed(259, 300L);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c(paramBoolean);
      c(paramInt);
      return;
    }
  }
  
  public boolean b()
  {
    if (d())
    {
      localley = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      if ((!this.jdField_d_of_type_Boolean) || (localley.a() == 3) || (this.jdField_e_of_type_Boolean)) {}
    }
    while ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f() != 3) && (!this.jdField_e_of_type_Boolean))
    {
      ley localley;
      return true;
      return false;
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    return paramInt == this.jdField_b_of_type_Int;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return b(paramInt1, paramInt2, -1);
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewRule, id" + mdy.a(paramInt1) + ", verb[" + paramInt2 + "], anchor[" + paramInt3 + "]");
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewClickable, id" + mdy.a(paramInt));
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      localView.setClickable(paramBoolean);
      return true;
    }
    return false;
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373368));
    this.jdField_a_of_type_Mid = new mid(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131719000));
      this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new mhq(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_Mid);
  }
  
  public void c(int paramInt)
  {
    a(paramInt, false);
  }
  
  void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    }
    d(paramBoolean);
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if (this.jdField_g_of_type_AndroidWidgetButton != null)
      {
        this.jdField_g_of_type_AndroidWidgetButton.setClickable(false);
        this.jdField_g_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
  }
  
  void d()
  {
    Object localObject = getResources().getDisplayMetrics();
    int n = getResources().getDimensionPixelSize(2131297796);
    int i1 = getResources().getDimensionPixelSize(2131297793);
    int m = 0;
    if (this.jdField_a_of_type_Int == 2131559742) {
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
    mgi localmgi = null;
    if (this.jdField_a_of_type_ArrayOfMgi[paramInt] != null) {
      return;
    }
    if (paramInt == 1) {
      localmgi = b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfMgi[paramInt] = localmgi;
      return;
      if (paramInt == 0) {
        localmgi = a();
      } else if (paramInt == 2) {
        localmgi = a(2, new mce(null));
      } else if (paramInt == 3) {
        localmgi = a(3, new mce("0X800A567"));
      } else if (paramInt == 4) {
        localmgi = a(4, new mce(null));
      }
    }
  }
  
  public void d(boolean paramBoolean)
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
    mgi localmgi = this.jdField_a_of_type_ArrayOfMgi[1];
    if (localmgi == null) {}
    while ((!localmgi.jdField_a_of_type_Boolean) || (!(localmgi.jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavOperationMenuView))) {
      return;
    }
    ((QavOperationMenuView)localmgi.jdField_a_of_type_AndroidWidgetRelativeLayout).f();
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364337));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166026));
    }
  }
  
  public void i()
  {
    if ((this.jdField_f_of_type_AndroidViewView != null) && (e()))
    {
      this.l = 2;
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.getBackground().setAlpha(127);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.getBackground().setAlpha(127);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean isPressed()
  {
    return (super.isPressed()) || ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.isPressed())) || ((this.jdField_h_of_type_AndroidWidgetButton != null) && (this.jdField_h_of_type_AndroidWidgetButton.isPressed())) || ((this.jdField_i_of_type_AndroidWidgetButton != null) && (this.jdField_i_of_type_AndroidWidgetButton.isPressed()));
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
    if (this.jdField_a_of_type_Mqi != null) {
      return;
    }
    this.jdField_a_of_type_Mqi = mqh.a(getResources(), this.jdField_a_of_type_Int);
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
    if ((this.jdField_h_of_type_AndroidWidgetButton == null) || ((this.jdField_h_of_type_AndroidWidgetButton != null) && (!this.jdField_h_of_type_AndroidWidgetButton.isShown()))) {
      return;
    }
    int m = this.jdField_j_of_type_Int;
    this.jdField_j_of_type_Int = paramInt;
    if (this.jdField_j_of_type_Int != m)
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
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new mht(this));
      }
      int n;
      ValueAnimator localValueAnimator;
      long l1;
      if (this.jdField_j_of_type_Int > m)
      {
        n = 1;
        localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (n == 0) {
          break label192;
        }
        l1 = 100L;
        label141:
        localValueAnimator.setDuration(l1);
        localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (paramInt != -1) {
          break label200;
        }
      }
      for (;;)
      {
        localValueAnimator.setIntValues(new int[] { m, this.jdField_j_of_type_Int });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        return;
        n = 0;
        break;
        label192:
        l1 = 200L;
        break label141;
        label200:
        m = paramInt;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable == null) {
        break;
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
    if (this.jdField_h_of_type_AndroidWidgetButton != null) {
      this.jdField_h_of_type_AndroidWidgetButton.setOnTouchListener(paramOnTouchListener);
    }
    if (this.jdField_i_of_type_AndroidWidgetButton != null) {
      this.jdField_i_of_type_AndroidWidgetButton.setOnTouchListener(paramOnTouchListener);
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
    if (this.jdField_a_of_type_Mqi != null)
    {
      this.jdField_a_of_type_Mqi.a(2131694686);
      this.jdField_a_of_type_Mqi.a(2131694690);
      this.jdField_a_of_type_Mqi.a(2131694692);
    }
  }
  
  public void setViewEnable(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewEnable, id" + mdy.a(paramInt) + ", enable[" + paramBoolean + "]");
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
      localStringBuilder = new StringBuilder().append("setViewVisibility, id").append(mdy.a(paramInt1)).append("], view[");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel
 * JD-Core Version:    0.7.0.1
 */