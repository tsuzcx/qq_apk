package com.tencent.av.ui;

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
import anvx;
import bdla;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.av.ui.virtual.QavVirtualMenuView;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lfe;
import mde;
import mez;
import mhj;
import mhm;
import mir;
import mis;
import mit;
import miu;
import miv;
import miw;
import mix;
import miy;
import miz;
import mjb;
import mjc;
import mjd;
import mje;
import mqq.app.BaseActivity;
import mrj;
import mrk;
import mrl;
import msf;
import mtr;
import mtz;
import muc;
import mue;
import mux;
import muy;
import mvk;

public class QavPanel
  extends RelativeLayout
{
  public static int i;
  int jdField_a_of_type_Int = 0;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public ClipDrawable a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
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
  private miz jdField_a_of_type_Miz = new miz(this, Looper.getMainLooper());
  mjb jdField_a_of_type_Mjb = null;
  private mjd jdField_a_of_type_Mjd;
  public mje a;
  mrl jdField_a_of_type_Mrl = null;
  private muc jdField_a_of_type_Muc;
  private mue jdField_a_of_type_Mue;
  boolean jdField_a_of_type_Boolean = false;
  mhj[] jdField_a_of_type_ArrayOfMhj = new mhj[5];
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
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
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
    jdField_i_of_type_Int = 2131378454;
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
    paramImageButton.setImageDrawable(msf.b(paramImageButton.getResources(), paramInt));
    paramImageButton.setAdjustViewBounds(true);
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373469);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373459));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373460));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373443));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373445));
    this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373451));
    Drawable localDrawable;
    if (this.jdField_j_of_type_AndroidWidgetButton != null)
    {
      localDrawable = getResources().getDrawable(2130842042);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.jdField_j_of_type_AndroidWidgetButton.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373464));
    if (this.jdField_k_of_type_AndroidWidgetButton != null)
    {
      localDrawable = getResources().getDrawable(2130842062);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.jdField_k_of_type_AndroidWidgetButton.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    m();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373468));
    this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373467));
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373465));
    this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373457));
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
  
  private mhj c()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_a_of_type_ArrayOfMhj[this.jdField_b_of_type_Int];
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
    return (paramInt == 2130842068) || (paramInt == 2130842078) || (paramInt == 2130842079);
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Int == 2131559787;
  }
  
  private void e(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373469);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363128));
    this.jdField_d_of_type_AndroidViewView = ((ViewGroup)getParent()).findViewById(2131373462);
    n();
    o();
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373624));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373459));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373460));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373469);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373465));
    l();
    this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373457));
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_Mjd != null) && (this.jdField_a_of_type_Mjd.b());
  }
  
  private void f(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373469);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373622));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373623));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373472));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373620);
    n();
    o();
    b();
    c();
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373459));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373460));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373469);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373465));
    l();
    this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373457));
  }
  
  private void g(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363128));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373622));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373623));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373472));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373620);
    b();
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373625));
    c();
  }
  
  private void h(int paramInt)
  {
    i(paramInt);
    setBtnTopDrawable(this.jdField_i_of_type_AndroidWidgetButton, 2130842078);
    setBtnTopDrawable(this.jdField_d_of_type_AndroidViewView, 2130842031);
    setBtnTopDrawable(this.jdField_e_of_type_AndroidViewView, 2130842033);
    setBtnTopDrawable(this.jdField_b_of_type_AndroidWidgetImageButton, 2130842051);
    setBtnTopDrawable(this.jdField_c_of_type_AndroidWidgetImageButton, 2130842323);
  }
  
  private void i(int paramInt)
  {
    boolean bool2 = false;
    if (this.jdField_h_of_type_AndroidWidgetButton == null) {
      return;
    }
    boolean bool1;
    if ((paramInt == 2131559793) || (paramInt == 2131559792))
    {
      bool1 = true;
      if (mtr.d()) {
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
        this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = ((ClipDrawable)this.jdField_h_of_type_AndroidWidgetButton.getResources().getDrawable(2130842069));
        setBtnTopDrawableWithForeGround(this.jdField_h_of_type_AndroidWidgetButton, 2130842068, this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable);
        this.jdField_h_of_type_AndroidWidgetButton.setOnTouchListener(new mis(this));
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
    this.jdField_f_of_type_AndroidViewView = localView.findViewById(2131373556);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373786));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373555));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373557));
    this.jdField_a_of_type_Muc = new muc((Activity)localView.getContext());
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Muc.a());
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void m()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    this.jdField_d_of_type_AndroidViewView = localViewGroup.findViewById(2131373462);
    if ((this.jdField_d_of_type_AndroidViewView == null) && (AudioHelper.e())) {
      throw new IllegalArgumentException("没找到VIEW_ENUM.HIDE");
    }
    this.jdField_e_of_type_AndroidViewView = localViewGroup.findViewById(2131373767);
    this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)localViewGroup.findViewById(2131373765));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)localViewGroup.findViewById(2131373771));
    getRootView();
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363140));
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_b_of_type_AndroidWidgetButton, 2130841990, 2131165970, 2131165970);
    }
  }
  
  private void o()
  {
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363139));
    if (this.jdField_e_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_e_of_type_AndroidWidgetButton, 2130842016, 2131165970, 2131165970);
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
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373459));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373460));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373469);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373465));
    this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373457));
    a(false);
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = new QavPanelSoundWaveView(getContext());
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(true);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297864));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams(localLayoutParams);
  }
  
  private void s()
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = mux.a(getResources(), 2130842021, 2131166030);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, AIOUtils.dp2px(64.0F, getResources()), AIOUtils.dp2px(64.0F, getResources()));
    this.jdField_a_of_type_Mue = new mue(AIOUtils.dp2px(64.0F, getResources()), AIOUtils.dp2px(64.0F, getResources()));
    this.jdField_a_of_type_Mue.a(0, BitmapFactory.decodeResource(getResources(), 2130842070));
    this.jdField_a_of_type_Mue.a(0, BitmapFactory.decodeResource(getResources(), 2130842071));
    this.jdField_a_of_type_Mue.a(1, BitmapFactory.decodeResource(getResources(), 2130842072));
    this.jdField_a_of_type_Mue.a(2, BitmapFactory.decodeResource(getResources(), 2130842072));
    this.jdField_a_of_type_Mue.a(2, BitmapFactory.decodeResource(getResources(), 2130842074));
    this.jdField_a_of_type_Mue.a(3, BitmapFactory.decodeResource(getResources(), 2130842075));
    this.jdField_a_of_type_Mue.a(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Mue });
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(0, 0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(1, 0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setBounds(0, 0, this.jdField_a_of_type_Mue.getIntrinsicWidth(), this.jdField_a_of_type_Mue.getIntrinsicHeight());
    this.jdField_h_of_type_AndroidWidgetButton.setCompoundDrawables(null, this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable, null, null);
    this.jdField_h_of_type_AndroidWidgetButton.setOnTouchListener(new mit(this));
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
    for (Drawable localDrawable = msf.a(paramTextView.getResources(), paramInt, false);; localDrawable = msf.a(paramTextView.getResources(), paramInt))
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
    paramTextView.setCompoundDrawables(null, msf.a(paramTextView.getResources(), paramInt, paramDrawable, false), null, null);
  }
  
  private void t()
  {
    if (!b()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "tryPerformLongClick cannot switch muteStatus");
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Mjd.a())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "tryPerformLongClick cannot checkBlockMuteStatus");
        return;
      }
    } while (a() != 1);
    lfe locallfe = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (d())
    {
      locallfe.a("tryPerformLongClick", false);
      locallfe.b("tryPerformLongClick", 3);
      a("tryPerformLongClick", 1, 3, true);
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800ADE2", "0X800ADE2", locallfe.jdField_d_of_type_Int, 0, "", "", "", "");
      this.jdField_a_of_type_Miz.sendEmptyMessageDelayed(261, 4000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a("tryPerformLongClick", this.jdField_a_of_type_Mjd.a(), true, true, 3);
      a("tryPerformLongClick", 1, 3, false);
      this.jdField_a_of_type_Mjd.a(true, true);
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
      lfe locallfe = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      locallfe.a("tryPlayBtnMuteAnimation", true);
      locallfe.b("tryPlayBtnMuteAnimation", 2);
      a("tryPlayBtnMuteAnimation start", 1, 2, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mjd.a();
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 3000 });
        this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(3000L);
        this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new miv(this));
        this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new miw(this, new int[] { 250, 2750, 3000 }));
      }
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()) {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      this.jdField_f_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().g("tryPlayBtnMuteAnimation onAnimationEnd", 2);
      a("tryPlayBtnMuteAnimation", 1, 2, false);
      this.jdField_a_of_type_Mjd.a(false, false);
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
    lfe locallfe = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (this.jdField_a_of_type_Int == 2131559787) {
      return locallfe.a();
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f();
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewClickable, id" + mez.a(paramInt));
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
    if (this.jdField_a_of_type_ArrayOfMhj[m] != null) {
      return this.jdField_a_of_type_ArrayOfMhj[m].a();
    }
    return null;
  }
  
  public QavPanelSoundWaveView a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
  }
  
  mhj a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373444);
    if (localRelativeLayout != null)
    {
      if (AudioHelper.a(0) == 1) {
        localRelativeLayout.setBackgroundColor(2142236398);
      }
      return new mhj(localRelativeLayout, 0, null);
    }
    return null;
  }
  
  mhj a(int paramInt, mhm parammhm)
  {
    Object localObject = getContext();
    if ((this.jdField_a_of_type_Mrl == null) || (!(localObject instanceof AVActivity))) {
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
      ((RelativeLayout)findViewById(2131373442)).addView((View)localObject, localLayoutParams);
      ((QavMenuBaseView)localObject).a(this);
      ((QavMenuBaseView)localObject).g();
      return new mhj((RelativeLayout)localObject, paramInt, parammhm);
      localObject = new QavVirtualMenuView((Context)localObject);
      continue;
      localObject = new QavBeautyMenuPanel((Context)localObject);
      continue;
      localObject = new EffectSettingUi((Context)localObject);
      continue;
      localObject = new QavOperationMenuView((Context)localObject);
    }
  }
  
  public mrj a(int paramInt)
  {
    if (this.jdField_a_of_type_Mrl == null) {
      return null;
    }
    return this.jdField_a_of_type_Mrl.a(paramInt);
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
    int m = getResources().getDimensionPixelSize(2131297891);
    this.jdField_a_of_type_Int = paramInt;
    r();
    a(this.jdField_a_of_type_Int);
    switch (this.jdField_a_of_type_Int)
    {
    case 2131559791: 
    default: 
      label92:
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        addView(this.jdField_a_of_type_AndroidViewView);
        a(-1020L, 0, false);
      }
      k();
      Object localObject = (RelativeLayout)findViewById(2131381351);
      if (localObject != null)
      {
        ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
        ((RelativeLayout)localObject).bringChildToFront(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
      }
      d();
      this.jdField_a_of_type_Mjb = new mjb(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      getContext().registerReceiver(this.jdField_a_of_type_Mjb, (IntentFilter)localObject);
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
    if (this.jdField_a_of_type_Mjb != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_Mjb);
      this.jdField_a_of_type_Mjb = null;
    }
    this.jdField_j_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    int m = 0;
    while (m < this.jdField_a_of_type_ArrayOfMhj.length)
    {
      if ((this.jdField_a_of_type_ArrayOfMhj[m] != null) && ((this.jdField_a_of_type_ArrayOfMhj[m].jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavMenuBaseView))) {
        ((QavMenuBaseView)this.jdField_a_of_type_ArrayOfMhj[m].jdField_a_of_type_AndroidWidgetRelativeLayout).b(paramLong);
      }
      this.jdField_a_of_type_ArrayOfMhj[m] = null;
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
    mhj localmhj = c();
    label137:
    int i1;
    label154:
    int m;
    boolean bool1;
    if (localmhj != null)
    {
      if (localmhj.jdField_a_of_type_Int == paramInt)
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showMenu direct, menuType[" + paramInt + "], needAnimation[" + paramBoolean + "], seq[" + paramLong + "]");
        localmhj.a(paramLong, paramBoolean, 3);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      }
      d(paramInt);
      if (this.jdField_a_of_type_ArrayOfMhj[paramInt] == null) {
        break label361;
      }
      if (localmhj != null) {
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
          this.jdField_a_of_type_Miz.removeMessages(257);
        }
        localObject = new QavPanel.7(this, paramInt, paramLong, paramBoolean, n);
        if (getVisibility() == 0) {
          break label477;
        }
      }
      label477:
      for (paramBoolean = false;; paramBoolean = bool1)
      {
        if (localmhj != null) {
          localmhj.a(paramLong, paramBoolean, m, new mix(this, (Runnable)localObject));
        }
        if ((localmhj != null) && (paramBoolean)) {
          break;
        }
        ((Runnable)localObject).run();
        return;
        d(paramInt);
        break label137;
        label361:
        break;
        label363:
        i1 = localmhj.a();
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
      while ((this.jdField_a_of_type_Mjd != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramBoolean) && (d()))
      {
        this.jdField_a_of_type_Mjd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g, bool1);
        return;
        if (paramInt1 == 2) {
          v();
        }
        a("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
        this.jdField_a_of_type_Mue.setAlpha(255);
        this.jdField_a_of_type_Mue.a(0);
        bool1 = bool2;
        if (!mvk.a(true))
        {
          this.jdField_a_of_type_Miz.removeMessages(259);
          this.jdField_a_of_type_Miz.sendEmptyMessageAtTime(259, 300L);
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
      this.jdField_a_of_type_Mue.setAlpha(255);
      this.jdField_a_of_type_Mue.a(1);
      a(2131373465, getResources().getString(2131692734));
      if ((!this.jdField_f_of_type_Boolean) && (e()))
      {
        this.jdField_a_of_type_Miz.removeMessages(257);
        this.jdField_a_of_type_Miz.sendEmptyMessageDelayed(257, 5300L);
      }
      if (!mvk.a(false))
      {
        this.jdField_a_of_type_Miz.removeMessages(258);
        this.jdField_a_of_type_Miz.sendEmptyMessageDelayed(258, 300L);
        break;
        if (paramInt1 == 2)
        {
          v();
          bool1 = false;
          continue;
        }
        if (paramInt1 != 3) {
          break label442;
        }
        bool1 = true;
        continue;
        this.jdField_a_of_type_Mue.a(2);
        bool1 = false;
        break;
        this.jdField_a_of_type_Mue.setAlpha(127);
        this.jdField_a_of_type_Mue.a(3);
        i();
        this.jdField_k_of_type_Int += 1;
        bool1 = bool2;
        break;
      }
      break;
      label442:
      bool1 = false;
    }
  }
  
  public void a(mjd parammjd)
  {
    this.jdField_a_of_type_Mjd = parammjd;
  }
  
  public void a(mtz parammtz)
  {
    if (this.jdField_f_of_type_AndroidWidgetButton != null)
    {
      parammtz.a(this.jdField_f_of_type_AndroidWidgetButton);
      parammtz.b();
    }
    while (this.jdField_a_of_type_AndroidWidgetImageButton == null) {
      return;
    }
    parammtz.a(this.jdField_a_of_type_AndroidWidgetImageButton);
    parammtz.b();
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
        this.jdField_a_of_type_Muc.a(0);
        this.jdField_a_of_type_Mue.b(0);
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkView, id" + mez.a(paramInt));
    }
    return b(paramInt) == null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewBackground, id" + mez.a(paramInt1) + ", selected[" + paramInt2 + "]");
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewMargin, id" + mez.a(paramInt1) + ", direction[" + paramInt2 + "], margin[" + paramInt3 + "]");
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewAccText, id" + mez.a(paramInt) + ", text[" + paramString + "]");
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      mvk.a(localView, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewAccText, id" + mez.a(paramInt1) + ", text[" + paramString + "], audioType[" + paramInt2 + "]");
    }
    View localView = b(paramInt1);
    if (localView != null)
    {
      mvk.a(localView, paramString, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewSelected, id" + mez.a(paramInt) + ", selected[" + paramBoolean + "]");
    }
    View localView = b(paramInt);
    if (localView != null)
    {
      localView.setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(mjc parammjc)
  {
    if (this.jdField_a_of_type_Mje == null) {
      return false;
    }
    this.jdField_a_of_type_Mje.a(parammjc);
    return true;
  }
  
  public boolean a(muy parammuy)
  {
    if ((parammuy != null) && (this.jdField_i_of_type_AndroidWidgetButton != null))
    {
      parammuy.b(this.jdField_i_of_type_AndroidWidgetButton);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public View b(int paramInt)
  {
    Button localButton = null;
    switch (paramInt)
    {
    default: 
      String str = anvx.a(2131708395) + paramInt + "]，Name[" + mez.a(paramInt) + "]，Name[" + AudioHelper.a(this, paramInt);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, str);
      if (AudioHelper.e()) {
        throw new IllegalArgumentException(str);
      }
    case 2131373465: 
      localButton = this.jdField_h_of_type_AndroidWidgetButton;
      return localButton;
    case 2131364480: 
      return this.jdField_a_of_type_AndroidWidgetTextView;
    case 2131363128: 
      return this.jdField_a_of_type_AndroidWidgetButton;
    case 2131373624: 
      return this.jdField_c_of_type_AndroidWidgetButton;
    case 2131373625: 
      return this.jdField_d_of_type_AndroidWidgetButton;
    case 2131363140: 
      return this.jdField_b_of_type_AndroidWidgetButton;
    case 2131373451: 
      return this.jdField_j_of_type_AndroidWidgetButton;
    case 2131373457: 
      return this.jdField_i_of_type_AndroidWidgetButton;
    case 2131373459: 
      return this.jdField_a_of_type_AndroidWidgetImageButton;
    case 2131373460: 
      return this.jdField_f_of_type_AndroidWidgetButton;
    case 2131373462: 
      return this.jdField_d_of_type_AndroidViewView;
    case 2131373620: 
      return this.jdField_c_of_type_AndroidViewView;
    case 2131363139: 
      return this.jdField_e_of_type_AndroidWidgetButton;
    case 2131373464: 
      return this.jdField_k_of_type_AndroidWidgetButton;
    case 2131373621: 
      return this.jdField_a_of_type_AndroidWidgetImageView;
    case 2131373468: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    case 2131373467: 
      return this.jdField_g_of_type_AndroidWidgetButton;
    case 2131373767: 
      return this.jdField_e_of_type_AndroidViewView;
    case 2131373771: 
      return this.jdField_b_of_type_AndroidWidgetImageButton;
    }
    return this.jdField_c_of_type_AndroidWidgetImageButton;
  }
  
  mhj b()
  {
    mhj localmhj = a(1, new mde(null));
    if ((localmhj != null) && ((localmhj.jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavOperationMenuView)))
    {
      QavOperationMenuView localQavOperationMenuView = (QavOperationMenuView)localmhj.jdField_a_of_type_AndroidWidgetRelativeLayout;
      localQavOperationMenuView.setViewController(this.jdField_a_of_type_Mrl);
      localQavOperationMenuView.setQavMenuActionListener(new miy(this));
    }
    return localmhj;
  }
  
  void b()
  {
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373624));
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_c_of_type_AndroidWidgetButton, 2130842200, 2131165970, 2131165970);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Mrl == null) {
      return;
    }
    mrl localmrl = this.jdField_a_of_type_Mrl;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localmrl.a(bool);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    label214:
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
          break label214;
        }
        this.jdField_a_of_type_Mue.setAlpha(255);
        this.jdField_a_of_type_Mue.a(1);
        a(2131373465, getResources().getString(2131692734));
        if ((!this.jdField_f_of_type_Boolean) && (e()))
        {
          this.jdField_a_of_type_Miz.removeMessages(257);
          this.jdField_a_of_type_Miz.sendEmptyMessageDelayed(257, 5300L);
        }
        if (mvk.a(false)) {
          break;
        }
        this.jdField_a_of_type_Miz.removeMessages(258);
        this.jdField_a_of_type_Miz.sendEmptyMessageDelayed(258, 300L);
        return;
      }
      this.jdField_a_of_type_Mue.setAlpha(255);
      this.jdField_a_of_type_Mue.a(0);
      this.jdField_a_of_type_Miz.removeMessages(257);
    } while (mvk.a(true));
    this.jdField_a_of_type_Miz.removeMessages(259);
    this.jdField_a_of_type_Miz.sendEmptyMessageDelayed(259, 300L);
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
      locallfe = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      if ((!this.jdField_d_of_type_Boolean) || (locallfe.a() == 3) || (this.jdField_e_of_type_Boolean)) {}
    }
    while ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f() != 3) && (!this.jdField_e_of_type_Boolean))
    {
      lfe locallfe;
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewRule, id" + mez.a(paramInt1) + ", verb[" + paramInt2 + "], anchor[" + paramInt3 + "]");
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewClickable, id" + mez.a(paramInt));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373621));
    this.jdField_a_of_type_Mje = new mje(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131719907));
      this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new mir(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_Mje);
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
    int n = getResources().getDimensionPixelSize(2131297864);
    int i1 = getResources().getDimensionPixelSize(2131297861);
    int m = 0;
    if (this.jdField_a_of_type_Int == 2131559787) {
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
    mhj localmhj = null;
    if (this.jdField_a_of_type_ArrayOfMhj[paramInt] != null) {
      return;
    }
    if (paramInt == 1) {
      localmhj = b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfMhj[paramInt] = localmhj;
      return;
      if (paramInt == 0) {
        localmhj = a();
      } else if (paramInt == 2) {
        localmhj = a(2, new mde(null));
      } else if (paramInt == 3) {
        localmhj = a(3, new mde("0X800A567"));
      } else if (paramInt == 4) {
        localmhj = a(4, new mde(null));
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
    mhj localmhj = this.jdField_a_of_type_ArrayOfMhj[1];
    if (localmhj == null) {}
    while ((!localmhj.jdField_a_of_type_Boolean) || (!(localmhj.jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavOperationMenuView))) {
      return;
    }
    ((QavOperationMenuView)localmhj.jdField_a_of_type_AndroidWidgetRelativeLayout).g();
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364480));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166054));
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
    if (this.jdField_a_of_type_Mrl != null) {
      return;
    }
    this.jdField_a_of_type_Mrl = mrk.a(getResources(), this.jdField_a_of_type_Int);
  }
  
  public void setAcceptDrawableTop(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(paramDrawable);
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
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new miu(this));
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
    if (this.jdField_a_of_type_Mrl != null)
    {
      this.jdField_a_of_type_Mrl.a(2131695080);
      this.jdField_a_of_type_Mrl.a(2131695084);
      this.jdField_a_of_type_Mrl.a(2131695086);
    }
  }
  
  public void setViewEnable(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setViewEnable, id" + mez.a(paramInt) + ", enable[" + paramBoolean + "]");
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
      localStringBuilder = new StringBuilder().append("setViewVisibility, id").append(mez.a(paramInt1)).append("], view[");
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