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
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
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
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public class QavPanel
  extends RelativeLayout
{
  public static int i = 2131378274;
  int jdField_a_of_type_Int = 0;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  ClipDrawable jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private QavPanel.CustomHandler jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler = new QavPanel.CustomHandler(this, Looper.getMainLooper());
  QavPanel.ScreenBroadcastReceiver jdField_a_of_type_ComTencentAvUiQavPanel$ScreenBroadcastReceiver = null;
  private QavPanel.onReciveQavPanelStatusChangeListener jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener;
  public QavPanelSlideTouchListener a;
  QavPanelSoundWaveView jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
  QavOperationMenuViewController jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController = null;
  private QavMicroPhoneAnimatorHolder jdField_a_of_type_ComTencentAvUtilsQavMicroPhoneAnimatorHolder;
  private QavMuteButtonForeGroundDrawable jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable;
  ShimmerTextView jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  NormalMenuView[] jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView = new NormalMenuView[5];
  int jdField_b_of_type_Int = -1;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  View jdField_b_of_type_AndroidViewView = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  public final int c;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_c_of_type_AndroidViewView = null;
  Button jdField_c_of_type_AndroidWidgetButton = null;
  ImageButton jdField_c_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  private volatile boolean jdField_c_of_type_Boolean = false;
  public final int d;
  View jdField_d_of_type_AndroidViewView = null;
  Button jdField_d_of_type_AndroidWidgetButton = null;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = false;
  public final int e;
  View jdField_e_of_type_AndroidViewView = null;
  Button jdField_e_of_type_AndroidWidgetButton = null;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean = false;
  public final int f;
  private View jdField_f_of_type_AndroidViewView;
  Button jdField_f_of_type_AndroidWidgetButton = null;
  private boolean jdField_f_of_type_Boolean = false;
  public final int g;
  Button g;
  public final int h;
  Button h;
  Button i = null;
  private int jdField_j_of_type_Int = 0;
  Button jdField_j_of_type_AndroidWidgetButton = null;
  private int jdField_k_of_type_Int = 0;
  Button jdField_k_of_type_AndroidWidgetButton = null;
  private int l = 1;
  
  public QavPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_g_of_type_AndroidWidgetButton = null;
    this.jdField_h_of_type_AndroidWidgetButton = null;
    this.jdField_c_of_type_Int = 256;
    this.jdField_d_of_type_Int = 257;
    this.jdField_e_of_type_Int = 258;
    this.jdField_f_of_type_Int = 259;
    this.jdField_g_of_type_Int = 260;
    this.jdField_h_of_type_Int = 261;
    paramContext = new StringBuilder();
    paramContext.append("QavPanel_");
    paramContext.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_g_of_type_AndroidWidgetButton = null;
    this.jdField_h_of_type_AndroidWidgetButton = null;
    this.jdField_c_of_type_Int = 256;
    this.jdField_d_of_type_Int = 257;
    this.jdField_e_of_type_Int = 258;
    this.jdField_f_of_type_Int = 259;
    this.jdField_g_of_type_Int = 260;
    this.jdField_h_of_type_Int = 261;
    paramContext = new StringBuilder();
    paramContext.append("QavPanel_");
    paramContext.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_g_of_type_AndroidWidgetButton = null;
    this.jdField_h_of_type_AndroidWidgetButton = null;
    this.jdField_c_of_type_Int = 256;
    this.jdField_d_of_type_Int = 257;
    this.jdField_e_of_type_Int = 258;
    this.jdField_f_of_type_Int = 259;
    this.jdField_g_of_type_Int = 260;
    this.jdField_h_of_type_Int = 261;
    paramContext = new StringBuilder();
    paramContext.append("QavPanel_");
    paramContext.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
    a();
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
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373355);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373345));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373346));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373329));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373331));
    this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373337));
    Drawable localDrawable;
    if (this.jdField_j_of_type_AndroidWidgetButton != null)
    {
      localDrawable = getResources().getDrawable(2130842083);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.jdField_j_of_type_AndroidWidgetButton.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373350));
    if (this.jdField_k_of_type_AndroidWidgetButton != null)
    {
      localDrawable = getResources().getDrawable(2130842103);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
        this.jdField_k_of_type_AndroidWidgetButton.setCompoundDrawables(null, localDrawable, null, null);
      }
    }
    m();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373354));
    this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373353));
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373351));
    this.i = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373343));
    if (paramBoolean2) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    a(paramBoolean1, paramInt, false);
  }
  
  private NormalMenuView c()
  {
    int m = this.jdField_b_of_type_Int;
    if (m != -1) {
      return this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView[m];
    }
    return null;
  }
  
  private boolean c()
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface != null) {
      return localVideoAppInterface.e();
    }
    return false;
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt == 2130842109) || (paramInt == 2130842119) || (paramInt == 2130842120);
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Int == 2131559739;
  }
  
  private void e(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373355);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363119));
    this.jdField_d_of_type_AndroidViewView = ((ViewGroup)getParent()).findViewById(2131373348);
    n();
    o();
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373510));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373345));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373346));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373355);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373351));
    l();
    this.i = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373343));
  }
  
  private boolean e()
  {
    QavPanel.onReciveQavPanelStatusChangeListener localonReciveQavPanelStatusChangeListener = this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener;
    return (localonReciveQavPanelStatusChangeListener != null) && (localonReciveQavPanelStatusChangeListener.b());
  }
  
  private void f(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373355);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373508));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373509));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373358));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373506);
    n();
    o();
    b();
    c();
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373345));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373346));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373355);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373351));
    l();
    this.i = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373343));
  }
  
  private void g(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363119));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373508));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373509));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373358));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373506);
    b();
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373511));
    c();
  }
  
  private void h(int paramInt)
  {
    i(paramInt);
    setBtnTopDrawable(this.i, 2130842119);
    setBtnTopDrawable(this.jdField_d_of_type_AndroidViewView, 2130842072);
    setBtnTopDrawable(this.jdField_e_of_type_AndroidViewView, 2130842074);
    setBtnTopDrawable(this.jdField_b_of_type_AndroidWidgetImageButton, 2130842092);
    setBtnTopDrawable(this.jdField_c_of_type_AndroidWidgetImageButton, 2130842365);
  }
  
  private void i(int paramInt)
  {
    if (this.jdField_h_of_type_AndroidWidgetButton == null) {
      return;
    }
    boolean bool;
    if ((paramInt != 2131559745) && (paramInt != 2131559744)) {
      bool = false;
    } else {
      bool = true;
    }
    if (!QAVConfigUtils.c()) {
      bool = false;
    }
    this.jdField_d_of_type_Boolean = bool;
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = ((ClipDrawable)this.jdField_h_of_type_AndroidWidgetButton.getResources().getDrawable(2130842110));
      setBtnTopDrawableWithForeGround(this.jdField_h_of_type_AndroidWidgetButton, 2130842109, this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable);
      this.jdField_h_of_type_AndroidWidgetButton.setOnTouchListener(new QavPanel.2(this));
      return;
    }
    s();
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    this.jdField_f_of_type_AndroidViewView = ((View)localObject).findViewById(2131373442);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373655));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373441));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131373443));
    this.jdField_a_of_type_ComTencentAvUtilsQavMicroPhoneAnimatorHolder = new QavMicroPhoneAnimatorHolder((Activity)((View)localObject).getContext());
    localObject = this.jdField_d_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentAvUtilsQavMicroPhoneAnimatorHolder.a());
    }
    localObject = this.jdField_f_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void m()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    this.jdField_d_of_type_AndroidViewView = localViewGroup.findViewById(2131373348);
    if ((this.jdField_d_of_type_AndroidViewView == null) && (AudioHelper.a())) {
      throw new IllegalArgumentException("没找到VIEW_ENUM.HIDE");
    }
    this.jdField_e_of_type_AndroidViewView = localViewGroup.findViewById(2131373636);
    this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)localViewGroup.findViewById(2131373634));
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)localViewGroup.findViewById(2131373640));
    getRootView();
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363130));
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_b_of_type_AndroidWidgetButton, 2130842031, 2131165985, 2131165985);
    }
  }
  
  private void o()
  {
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363129));
    if (this.jdField_e_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_e_of_type_AndroidWidgetButton, 2130842057, 2131165985, 2131165985);
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
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373345));
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373346));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373355);
    m();
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373351));
    this.i = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373343));
    a(false);
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = new QavPanelSoundWaveView(getContext());
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(true);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297925));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams(localLayoutParams);
  }
  
  private void s()
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(getResources(), 2130842062, 2131166045);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, AIOUtils.b(64.0F, getResources()), AIOUtils.b(64.0F, getResources()));
    this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable = new QavMuteButtonForeGroundDrawable(AIOUtils.b(64.0F, getResources()), AIOUtils.b(64.0F, getResources()));
    this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(0, BitmapFactory.decodeResource(getResources(), 2130842111));
    this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(0, BitmapFactory.decodeResource(getResources(), 2130842112));
    this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(1, BitmapFactory.decodeResource(getResources(), 2130842113));
    this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(2, BitmapFactory.decodeResource(getResources(), 2130842113));
    this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(2, BitmapFactory.decodeResource(getResources(), 2130842115));
    this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(3, BitmapFactory.decodeResource(getResources(), 2130842116));
    this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable });
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(0, 0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(1, 0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setBounds(0, 0, this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.getIntrinsicWidth(), this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.getIntrinsicHeight());
    this.jdField_h_of_type_AndroidWidgetButton.setCompoundDrawables(null, this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable, null, null);
    this.jdField_h_of_type_AndroidWidgetButton.setOnTouchListener(new QavPanel.3(this));
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
    if (c(paramInt)) {
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
  
  private void t()
  {
    if (!b())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "tryPerformLongClick cannot switch muteStatus");
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener.a())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "tryPerformLongClick cannot checkBlockMuteStatus");
      return;
    }
    if (a() == 1)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      if (d())
      {
        localSessionInfo.a("tryPerformLongClick", false);
        localSessionInfo.c("tryPerformLongClick", 3);
        a("tryPerformLongClick", 1, 3, true);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a("tryPerformLongClick", this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener.a(), true, true, 3);
        a("tryPerformLongClick", 1, 3, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener.a(true, true);
      }
      ReportController.b(null, "dc00898", "", "", "0X800ADE2", "0X800ADE2", localSessionInfo.jdField_d_of_type_Int, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.sendEmptyMessageDelayed(261, 4000L);
    }
  }
  
  @TargetApi(11)
  private void u()
  {
    Object localObject = this.jdField_h_of_type_AndroidWidgetButton;
    if ((localObject != null) && ((localObject == null) || (((Button)localObject).isShown())))
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        return;
      }
      if (a() != 1) {
        return;
      }
      if (d())
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
        ((SessionInfo)localObject).a("tryPlayBtnMuteAnimation", true);
        ((SessionInfo)localObject).c("tryPlayBtnMuteAnimation", 2);
        a("tryPlayBtnMuteAnimation start", 1, 2, false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().c("tryPlayBtnMuteAnimation onAnimationEnd", 2);
        a("tryPlayBtnMuteAnimation", 1, 2, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener.a(false, false);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener.a();
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 3000 });
        this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(3000L);
        this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new QavPanel.5(this));
        this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new QavPanel.6(this, new int[] { 250, 2750, 3000 }));
      }
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()) {
        this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  private void v()
  {
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public int a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (this.jdField_a_of_type_Int == 2131559739) {
      return localSessionInfo.m;
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().e();
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewClickable, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = b(paramInt);
    if (localObject != null) {
      return ((View)localObject).getVisibility();
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
    NormalMenuView[] arrayOfNormalMenuView = this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView;
    if (arrayOfNormalMenuView[m] != null) {
      return arrayOfNormalMenuView[m].a();
    }
    return null;
  }
  
  NormalMenuView a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373330);
    if (localRelativeLayout != null)
    {
      if (AudioHelper.a(0) == 1) {
        localRelativeLayout.setBackgroundColor(2142236398);
      }
      return new NormalMenuView(localRelativeLayout, 0, null);
    }
    return null;
  }
  
  NormalMenuView a(int paramInt, NormalMenuView.ViewEvent paramViewEvent)
  {
    Object localObject2 = getContext();
    QavOperationMenuViewController localQavOperationMenuViewController = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController;
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
            if (paramInt == 4) {
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
      ((RelativeLayout)findViewById(2131373328)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ((QavMenuBaseView)localObject1).a(this);
      ((QavMenuBaseView)localObject1).d();
      return new NormalMenuView((RelativeLayout)localObject1, paramInt, paramViewEvent);
    }
    return null;
  }
  
  public QavPanelSoundWaveView a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
  }
  
  public OperationBtnItem a(int paramInt)
  {
    QavOperationMenuViewController localQavOperationMenuViewController = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController;
    if (localQavOperationMenuViewController == null) {
      return null;
    }
    return localQavOperationMenuViewController.a(paramInt);
  }
  
  void a() {}
  
  public void a(int paramInt)
  {
    a(paramInt, false, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEffectBtn, effectType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], mEffectDrawable[");
      boolean bool;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
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
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    p();
    int m = getResources().getDimensionPixelSize(2131297952);
    this.jdField_a_of_type_Int = paramInt;
    r();
    a(this.jdField_a_of_type_Int);
    switch (this.jdField_a_of_type_Int)
    {
    case 2131559743: 
    default: 
      break;
    case 2131559746: 
      g(m);
      break;
    case 2131559745: 
      e(paramBoolean2);
      break;
    case 2131559744: 
      f(paramBoolean2);
      break;
    case 2131559742: 
      q();
      break;
    case 2131559741: 
      e(m);
      break;
    case 2131559740: 
      f(m);
      break;
    case 2131559739: 
      b(m, paramBoolean1, paramBoolean2);
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      addView((View)localObject);
      a(-1020L, 0, false);
    }
    k();
    localObject = (RelativeLayout)findViewById(2131381030);
    if (localObject != null)
    {
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
      ((RelativeLayout)localObject).bringChildToFront(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
    }
    d();
    this.jdField_a_of_type_ComTencentAvUiQavPanel$ScreenBroadcastReceiver = new QavPanel.ScreenBroadcastReceiver(this);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    getContext().registerReceiver(this.jdField_a_of_type_ComTencentAvUiQavPanel$ScreenBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_Boolean = true;
    setBtnOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    h();
    h(this.jdField_a_of_type_Int);
    c(paramBoolean1);
    if (paramBoolean2) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    c(paramInt);
    if (AudioHelper.a(0) == 1)
    {
      localObject = this.i;
      if (localObject != null) {
        ((Button)localObject).setBackgroundColor(Color.argb(255, 68, 128, 2));
      }
      setBackgroundColor(-545259606);
      localObject = this.jdField_e_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(2145129532);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel$ScreenBroadcastReceiver != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentAvUiQavPanel$ScreenBroadcastReceiver);
      this.jdField_a_of_type_ComTencentAvUiQavPanel$ScreenBroadcastReceiver = null;
    }
    int m = 0;
    this.jdField_j_of_type_Int = 0;
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView;
      if (m >= localObject.length) {
        break;
      }
      if ((localObject[m] != null) && ((localObject[m].jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavMenuBaseView))) {
        ((QavMenuBaseView)this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView[m].jdField_a_of_type_AndroidWidgetRelativeLayout).b(paramLong);
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView[m] = null;
      m += 1;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
    if (localObject != null) {
      ((QavPanelSoundWaveView)localObject).c();
    }
    v();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    d(2);
    EffectSettingUi localEffectSettingUi = (EffectSettingUi)a(2);
    if (localEffectSettingUi == null) {
      return;
    }
    if (!localEffectSettingUi.a(paramLong, paramInt)) {
      return;
    }
    a(paramLong, 2, true);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (!(getContext() instanceof AVActivity)) {
      return;
    }
    NormalMenuView localNormalMenuView = c();
    if (localNormalMenuView != null)
    {
      if (localNormalMenuView.jdField_a_of_type_Int == paramInt)
      {
        localObject = this.jdField_a_of_type_JavaLangString;
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
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      }
      d(paramInt);
    }
    else
    {
      d(paramInt);
    }
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView[paramInt] == null) {
      return;
    }
    int n;
    if (localNormalMenuView == null) {
      n = -1;
    } else {
      n = localNormalMenuView.a();
    }
    int m = 4;
    if (n == 0) {
      m = 3;
    }
    boolean bool1;
    int i1;
    label293:
    for (;;)
    {
      bool1 = false;
      i1 = -1;
      break label296;
      if (n == 1) {
        if ((paramInt != 2) && (paramInt != 3)) {
          if (paramInt != 0) {
            break label293;
          }
        }
      }
      while (paramInt == 1)
      {
        m = 3;
        do
        {
          bool1 = true;
          i1 = 2;
          break label296;
          if (n == -1) {
            break;
          }
          if ((n != 2) && (n != 3)) {
            break label293;
          }
        } while (paramInt == 0);
      }
    }
    label296:
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showMenu, MenuType[");
    localStringBuilder.append(n);
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
    this.jdField_b_of_type_Int = paramInt;
    if ((n != this.jdField_b_of_type_Int) && (n == 0))
    {
      a("showMenu", 0);
      this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.removeMessages(257);
    }
    boolean bool2 = false;
    localObject = new QavPanel.7(this, paramInt, paramLong, paramBoolean, m);
    if (getVisibility() != 0) {
      bool1 = bool2;
    }
    if (localNormalMenuView != null) {
      localNormalMenuView.a(paramLong, bool1, i1, new QavPanel.8(this, (Runnable)localObject));
    }
    if ((localNormalMenuView == null) || (!bool1)) {
      ((Runnable)localObject).run();
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
  
  public void a(QavPanel.onReciveQavPanelStatusChangeListener paramonReciveQavPanelStatusChangeListener)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener = paramonReciveQavPanelStatusChangeListener;
  }
  
  public void a(QQFrameByFrameAnimation paramQQFrameByFrameAnimation)
  {
    Object localObject = this.jdField_f_of_type_AndroidWidgetButton;
    if (localObject != null)
    {
      paramQQFrameByFrameAnimation.a((View)localObject);
      paramQQFrameByFrameAnimation.b();
      return;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localObject != null)
    {
      paramQQFrameByFrameAnimation.a((View)localObject);
      paramQQFrameByFrameAnimation.b();
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pressSpeaking showPressSpeakingGuider, from[1], text[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], mVoiceGuiderRootContent[");
    localStringBuilder.append(this.jdField_f_of_type_AndroidViewView);
    localStringBuilder.append("]");
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_f_of_type_AndroidViewView;
    if (localObject != null)
    {
      this.l = 1;
      ((View)localObject).setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.getBackground().setAlpha(255);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pressSpeaking hidePressSpreakingGuiderOrTips, from[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], tipsType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    if ((this.jdField_f_of_type_AndroidViewView != null) && ((this.l == paramInt) || (paramInt == 0))) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  @TargetApi(11)
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_JavaLangString;
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
      if (!this.jdField_d_of_type_Boolean) {
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
            this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.setAlpha(127);
            this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(3);
            i();
            this.jdField_k_of_type_Int += 1;
            bool1 = bool2;
            break;
            this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(2);
          }
        }
        if (paramInt1 == 0) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 1, "test has call keep speaking status");
        }
        do
        {
          bool1 = true;
          break label210;
          if (paramInt1 == 2)
          {
            v();
            break;
          }
        } while (paramInt1 == 3);
        bool1 = false;
        label210:
        a("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.setAlpha(255);
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(1);
        a(2131373351, getResources().getString(2131692832));
        if ((!this.jdField_f_of_type_Boolean) && (e()))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.removeMessages(257);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.sendEmptyMessageDelayed(257, 5300L);
        }
        if (!UITools.a(false))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.removeMessages(258);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.sendEmptyMessageDelayed(258, 300L);
        }
      }
      else
      {
        if (paramInt1 == 2) {
          v();
        }
        a("doSpeakerStatusChange KEEP_SPEAKING_STATUS", 2);
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.setAlpha(255);
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(0);
        bool1 = bool2;
        if (!UITools.a(true))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.removeMessages(259);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.sendEmptyMessageAtTime(259, 300L);
          bool1 = bool2;
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramBoolean) && (d())) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel$onReciveQavPanelStatusChangeListener.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g, bool1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resizeLayout4DoubleVideoMeeting mEffectiveType:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 2, localStringBuilder.toString());
    c(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resizeLayout4Multi mEffectiveType:");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
    if (paramInt == 2) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    c(paramBoolean);
    c(paramInt);
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("videoSession :");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", localHasVideo:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isVipFunCall:");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
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
      Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).cancel();
        this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable;
      if (localObject != null) {
        ((ClipDrawable)localObject).setLevel(0);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvUtilsQavMicroPhoneAnimatorHolder.a(0);
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.b(0);
      }
    }
    else
    {
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkView, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return b(paramInt) == null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewBackground, id");
      localStringBuilder.append(LayoutDef.a(paramInt1));
      localStringBuilder.append(", selected[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = b(paramInt1);
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
      localObject1 = this.jdField_a_of_type_JavaLangString;
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
    Object localObject1 = b(paramInt1);
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
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewAccText, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      localStringBuilder.append(", text[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = b(paramInt);
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
      localObject = this.jdField_a_of_type_JavaLangString;
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
    Object localObject = b(paramInt1);
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
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewSelected, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      localStringBuilder.append(", selected[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = b(paramInt);
    if (localObject != null)
    {
      ((View)localObject).setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(QavPanel.SlideAcceptListener paramSlideAcceptListener)
  {
    QavPanelSlideTouchListener localQavPanelSlideTouchListener = this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener;
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
      Button localButton = this.i;
      if (localButton != null)
      {
        paramTraeHelper.b(localButton);
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public View b(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131708928));
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]，Name[");
      ((StringBuilder)localObject).append(LayoutDef.a(paramInt));
      ((StringBuilder)localObject).append("]，Name[");
      ((StringBuilder)localObject).append(AudioHelper.a(this, paramInt));
      localObject = ((StringBuilder)localObject).toString();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, (String)localObject);
      if (!AudioHelper.a()) {
        return null;
      }
      break;
    case 2131373640: 
      return this.jdField_b_of_type_AndroidWidgetImageButton;
    case 2131373636: 
      return this.jdField_e_of_type_AndroidViewView;
    case 2131373634: 
      return this.jdField_c_of_type_AndroidWidgetImageButton;
    case 2131373511: 
      return this.jdField_d_of_type_AndroidWidgetButton;
    case 2131373510: 
      return this.jdField_c_of_type_AndroidWidgetButton;
    case 2131373507: 
      return this.jdField_a_of_type_AndroidWidgetImageView;
    case 2131373506: 
      return this.jdField_c_of_type_AndroidViewView;
    case 2131373354: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    case 2131373353: 
      return this.jdField_g_of_type_AndroidWidgetButton;
    case 2131373351: 
      return this.jdField_h_of_type_AndroidWidgetButton;
    case 2131373350: 
      return this.jdField_k_of_type_AndroidWidgetButton;
    case 2131373348: 
      return this.jdField_d_of_type_AndroidViewView;
    case 2131373346: 
      return this.jdField_f_of_type_AndroidWidgetButton;
    case 2131373345: 
      return this.jdField_a_of_type_AndroidWidgetImageButton;
    case 2131373343: 
      return this.i;
    case 2131373337: 
      return this.jdField_j_of_type_AndroidWidgetButton;
    case 2131364477: 
      return this.jdField_a_of_type_AndroidWidgetTextView;
    case 2131363130: 
      return this.jdField_b_of_type_AndroidWidgetButton;
    case 2131363129: 
      return this.jdField_e_of_type_AndroidWidgetButton;
    case 2131363119: 
      return this.jdField_a_of_type_AndroidWidgetButton;
    }
    throw new IllegalArgumentException((String)localObject);
  }
  
  NormalMenuView b()
  {
    NormalMenuView localNormalMenuView = a(1, new DefaultViewEvent(null));
    if ((localNormalMenuView != null) && ((localNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavOperationMenuView)))
    {
      QavOperationMenuView localQavOperationMenuView = (QavOperationMenuView)localNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout;
      localQavOperationMenuView.setViewController(this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController);
      localQavOperationMenuView.setQavMenuActionListener(new QavPanel.9(this));
    }
    return localNormalMenuView;
  }
  
  void b()
  {
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373510));
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_c_of_type_AndroidWidgetButton, 2130842241, 2131165985, 2131165985);
    }
  }
  
  public void b(int paramInt)
  {
    QavOperationMenuViewController localQavOperationMenuViewController = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController;
    if (localQavOperationMenuViewController == null) {
      return;
    }
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localQavOperationMenuViewController.a(bool);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    boolean bool;
    if ((!d()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().e() != 1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().e() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshButtonStatus, from[1], mute[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], canRefresh[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    if ((this.jdField_d_of_type_Boolean) && (bool)) {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.setAlpha(255);
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(1);
        a(2131373351, getResources().getString(2131692832));
        if ((!this.jdField_f_of_type_Boolean) && (e()))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.removeMessages(257);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.sendEmptyMessageDelayed(257, 5300L);
        }
        if (!UITools.a(false))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.removeMessages(258);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.sendEmptyMessageDelayed(258, 300L);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.setAlpha(255);
        this.jdField_a_of_type_ComTencentAvUtilsQavMuteButtonForeGroundDrawable.a(0);
        this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.removeMessages(257);
        if (!UITools.a(true))
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.removeMessages(259);
          this.jdField_a_of_type_ComTencentAvUiQavPanel$CustomHandler.sendEmptyMessageDelayed(259, 300L);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resizeLayout4Group mEffectiveType:");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
    if (paramInt == 2) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    c(paramBoolean);
    c(paramInt);
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    boolean bool3 = false;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    if (d())
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      bool1 = bool2;
      if (this.jdField_d_of_type_Boolean)
      {
        bool1 = bool2;
        if (((SessionInfo)localObject).m != 3)
        {
          bool1 = bool2;
          if (!this.jdField_e_of_type_Boolean) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    boolean bool1 = bool3;
    if (this.jdField_d_of_type_Boolean)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().e() != 3)
      {
        bool1 = bool3;
        if (!this.jdField_e_of_type_Boolean) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
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
    Object localObject1 = b(paramInt1);
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
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewClickable, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = b(paramInt);
    if (localObject != null)
    {
      ((View)localObject).setClickable(paramBoolean);
      return true;
    }
    return false;
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373507));
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = new QavPanelSlideTouchListener(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131720195));
      this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new QavPanel.1(this));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener);
  }
  
  public void c(int paramInt)
  {
    a(paramInt, false);
  }
  
  void c(boolean paramBoolean)
  {
    NormalMenuView localNormalMenuView = this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView[0];
    if (paramBoolean)
    {
      QavPanelSoundWaveView localQavPanelSoundWaveView = this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
      if (localQavPanelSoundWaveView != null) {
        localQavPanelSoundWaveView.setVisibility(8);
      }
      if ((localNormalMenuView != null) && (localNormalMenuView.a() != null)) {
        localNormalMenuView.a().setBackgroundResource(2130842025);
      }
    }
    else if ((localNormalMenuView != null) && (localNormalMenuView.a() != null))
    {
      localNormalMenuView.a().setBackgroundColor(0);
    }
    d(paramBoolean);
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if ((localObject != null) && (paramBoolean))
    {
      ((FrameLayout)localObject).setVisibility(0);
      localObject = this.jdField_g_of_type_AndroidWidgetButton;
      if (localObject != null)
      {
        ((Button)localObject).setClickable(false);
        this.jdField_g_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
  }
  
  void d()
  {
    Object localObject = getResources().getDisplayMetrics();
    int n = getResources().getDimensionPixelSize(2131297925);
    int i1 = getResources().getDimensionPixelSize(2131297922);
    int m;
    if (this.jdField_a_of_type_Int == 2131559739) {
      m = ((DisplayMetrics)localObject).widthPixels * 880 / 750;
    } else {
      m = 0;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustPanel, heightPixels[");
      localStringBuilder.append(((DisplayMetrics)localObject).heightPixels);
      localStringBuilder.append("], widthPixels[");
      localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
      localStringBuilder.append("], waveHeight[");
      localStringBuilder.append(n);
      localStringBuilder.append("], shadowHeight[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], videoHeight[");
      localStringBuilder.append(m);
      localStringBuilder.append("], mPanelType[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((QavPanelSoundWaveView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = n;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  void d(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView[paramInt] != null) {
      return;
    }
    NormalMenuView localNormalMenuView = null;
    if (paramInt == 1) {
      localNormalMenuView = b();
    } else if (paramInt == 0) {
      localNormalMenuView = a();
    } else if (paramInt == 2) {
      localNormalMenuView = a(2, new DefaultViewEvent(null));
    } else if (paramInt == 3) {
      localNormalMenuView = a(3, new DefaultViewEvent("0X800A567"));
    } else if (paramInt == 4) {
      localNormalMenuView = a(4, new DefaultViewEvent(null));
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView[paramInt] = localNormalMenuView;
  }
  
  public void d(boolean paramBoolean)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView == null) {
      return;
    }
    if (paramBoolean) {
      localView.setVisibility(0);
    } else {
      localView.setVisibility(8);
    }
    if (AudioHelper.a(0) == 1) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-536894208);
    }
  }
  
  public void e()
  {
    QavPanelSoundWaveView localQavPanelSoundWaveView = this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
    if (localQavPanelSoundWaveView != null)
    {
      if (!localQavPanelSoundWaveView.isShown()) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.f();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void f()
  {
    QavPanelSoundWaveView localQavPanelSoundWaveView = this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
    if (localQavPanelSoundWaveView != null)
    {
      if (!localQavPanelSoundWaveView.isShown()) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.g();
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void g()
  {
    NormalMenuView localNormalMenuView = this.jdField_a_of_type_ArrayOfComTencentAvUiNormalMenuView[1];
    if (localNormalMenuView == null) {
      return;
    }
    if (!localNormalMenuView.jdField_a_of_type_Boolean) {
      return;
    }
    if (!(localNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout instanceof QavOperationMenuView)) {
      return;
    }
    ((QavOperationMenuView)localNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout).d();
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364477));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setTextColor(getResources().getColor(2131166069));
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
    if (!super.isPressed())
    {
      Object localObject = this.jdField_e_of_type_AndroidViewView;
      if ((localObject == null) || (!((View)localObject).isPressed()))
      {
        localObject = this.jdField_h_of_type_AndroidWidgetButton;
        if ((localObject == null) || (!((Button)localObject).isPressed()))
        {
          localObject = this.i;
          if ((localObject == null) || (!((Button)localObject).isPressed())) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public void j()
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if ((localRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      localRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController = OperationMenuViewFactory.a(getResources(), this.jdField_a_of_type_Int);
  }
  
  public void setAcceptDrawableTop(Drawable paramDrawable)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton == null) {
      return;
    }
    localButton.setBackgroundDrawable(paramDrawable);
  }
  
  public void setAudioVolumeValue(int paramInt)
  {
    Object localObject = this.jdField_h_of_type_AndroidWidgetButton;
    if (localObject != null)
    {
      if ((localObject != null) && (!((Button)localObject).isShown())) {
        return;
      }
      int n = this.jdField_j_of_type_Int;
      this.jdField_j_of_type_Int = paramInt;
      if (this.jdField_j_of_type_Int != n)
      {
        localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        int m;
        if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
        {
          paramInt = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
          this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
          m = paramInt;
        }
        else
        {
          m = -1;
          paramInt = n;
        }
        if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
        {
          this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new QavPanel.4(this));
        }
        if (this.jdField_j_of_type_Int > paramInt) {
          n = 1;
        } else {
          n = 0;
        }
        localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        long l1;
        if (n != 0) {
          l1 = 100L;
        } else {
          l1 = 200L;
        }
        ((ValueAnimator)localObject).setDuration(l1);
        localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        n = m;
        if (m == -1) {
          n = paramInt;
        }
        ((ValueAnimator)localObject).setIntValues(new int[] { n, this.jdField_j_of_type_Int });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        return;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable;
      if (localObject != null) {
        ((ClipDrawable)localObject).setLevel(paramInt);
      }
    }
  }
  
  public void setBtnOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
    Button localButton = this.jdField_h_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.setOnTouchListener(paramOnTouchListener);
    }
    localButton = this.i;
    if (localButton != null) {
      localButton.setOnTouchListener(paramOnTouchListener);
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
    QavOperationMenuViewController localQavOperationMenuViewController = this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController;
    if (localQavOperationMenuViewController != null)
    {
      localQavOperationMenuViewController.a(2131695333);
      this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController.a(2131695337);
      this.jdField_a_of_type_ComTencentAvUiViewcontrollerQavOperationMenuViewController.a(2131695339);
    }
  }
  
  public void setViewEnable(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewEnable, id");
      localStringBuilder.append(LayoutDef.a(paramInt));
      localStringBuilder.append(", enable[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = b(paramInt);
    if (localObject != null) {
      ((View)localObject).setEnabled(paramBoolean);
    }
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    View localView = b(paramInt1);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("timWaveView setWaveVisibility visibility:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel
 * JD-Core Version:    0.7.0.1
 */