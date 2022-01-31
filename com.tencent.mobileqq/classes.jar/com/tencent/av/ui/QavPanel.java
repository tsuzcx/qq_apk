package com.tencent.av.ui;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import jzh;
import jzi;
import jzj;
import jzk;
import jzl;
import jzm;
import jzn;
import mqq.app.BaseActivity;

public class QavPanel
  extends RelativeLayout
{
  private static double jdField_a_of_type_Double = 0.11667D;
  private static double jdField_b_of_type_Double = 0.08333D;
  private static double jdField_c_of_type_Double = 0.157333D;
  private static double jdField_d_of_type_Double = 0.073333D;
  private static double jdField_e_of_type_Double = 0.14267D;
  public static int e;
  private static double jdField_f_of_type_Double = 0.17067D;
  private static double jdField_g_of_type_Double = 0.15067D;
  private static double jdField_h_of_type_Double = 0.16D;
  int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jzj(this);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnTouchListener a;
  View jdField_a_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  public FrameLayout a;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public VideoAppInterface a;
  public QavPanelSlideTouchListener a;
  public QavPanelSoundWaveView a;
  TipsManager jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
  ShimmerTextView jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
  public BubbleTextView a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  jzn jdField_a_of_type_Jzn = null;
  boolean jdField_a_of_type_Boolean = false;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = null;
  int jdField_b_of_type_Int = 0;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = new UITools.MyViewAlphaOnTouchListener();
  View jdField_b_of_type_AndroidViewView = null;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  public FrameLayout b;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  public boolean b;
  int jdField_c_of_type_Int = 1;
  View jdField_c_of_type_AndroidViewView = null;
  Animation jdField_c_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_c_of_type_AndroidWidgetButton = null;
  FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout = null;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  public boolean c;
  public int d;
  Animation jdField_d_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_d_of_type_AndroidWidgetButton = null;
  public FrameLayout d;
  public ImageView d;
  public boolean d;
  Animation jdField_e_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_e_of_type_AndroidWidgetButton = null;
  public FrameLayout e;
  public ImageView e;
  Animation jdField_f_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_f_of_type_AndroidWidgetButton = null;
  public FrameLayout f;
  Animation jdField_g_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_g_of_type_AndroidWidgetButton = null;
  public FrameLayout g;
  Animation jdField_h_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_h_of_type_AndroidWidgetButton = null;
  Animation jdField_i_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_i_of_type_AndroidWidgetButton = null;
  Animation jdField_j_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_j_of_type_AndroidWidgetButton = null;
  Animation jdField_k_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_k_of_type_AndroidWidgetButton = null;
  Animation jdField_l_of_type_AndroidViewAnimationAnimation = null;
  Button jdField_l_of_type_AndroidWidgetButton = null;
  public Button m = null;
  Button n = null;
  Button o = null;
  
  static
  {
    jdField_e_of_type_Int = 2131362541;
  }
  
  public QavPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_e_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_f_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_g_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
    this.jdField_e_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_e_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_f_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_g_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
    this.jdField_e_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  public QavPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_b_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_e_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_f_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_g_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
    this.jdField_e_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  private BubbleTextView a(String paramString, int paramInt1, int paramInt2)
  {
    BubbleTextView localBubbleTextView = null;
    Object localObject = localBubbleTextView;
    int i2;
    int i3;
    int i1;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject = localBubbleTextView;
      if (this.jdField_g_of_type_AndroidWidgetFrameLayout != null)
      {
        localBubbleTextView = new BubbleTextView(getContext());
        localBubbleTextView.setText(paramString);
        localBubbleTextView.setTextSize(13.0F);
        localBubbleTextView.setTextColor(paramInt1);
        localBubbleTextView.setContentDescription(paramString);
        localBubbleTextView.setBackgroundDrawable(null);
        localBubbleTextView.setIncludeFontPadding(false);
        localBubbleTextView.setGravity(3);
        localBubbleTextView.setMaxLines(2);
        localBubbleTextView.setSingleLine(false);
        localBubbleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (paramString.length() <= 13) {
          break label692;
        }
        i2 = paramString.length() / 13;
        i3 = paramString.length() % 13;
        if (i2 != 1) {
          break label620;
        }
        if (i3 >= 4) {
          break label550;
        }
        paramInt1 = paramString.length() - 4;
        localObject = paramString.substring(0, paramInt1) + "\n" + paramString.substring(paramInt1);
        localBubbleTextView.setText((CharSequence)localObject);
        i1 = i2;
        paramInt1 = i3;
      }
    }
    for (;;)
    {
      paramString = localBubbleTextView.getPaint();
      paramString.density = getResources().getDisplayMetrics().density;
      i3 = (int)Layout.getDesiredWidth((CharSequence)localObject, paramString);
      i2 = 5;
      if (paramString.density >= 2.0F) {
        i2 = 10;
      }
      i2 = (int)(i2 * paramString.density);
      localBubbleTextView.setMinimumWidth(i2 * 2 + i3);
      localBubbleTextView.setPadding(i2, i2, i2, i2);
      i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localBubbleTextView.measure(i2, i2);
      i2 = localBubbleTextView.getMeasuredWidth();
      i3 = (int)UITools.a(getContext(), 10.0F);
      int i4 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth() - (this.jdField_g_of_type_AndroidWidgetFrameLayout.getRight() + this.jdField_g_of_type_AndroidWidgetFrameLayout.getLeft()) / 2;
      localBubbleTextView.b = ((int)UITools.a(getContext(), 10.0F));
      localBubbleTextView.jdField_a_of_type_Boolean = false;
      localBubbleTextView.jdField_a_of_type_Int = paramInt2;
      localBubbleTextView.d = (i2 + i3 - i4 - localBubbleTextView.jdField_a_of_type_Float / 2.0F);
      localBubbleTextView.c = ((int)UITools.a(getContext(), 8.0F));
      if (QLog.isColorLevel()) {
        QLog.e("QavPanel", 2, "showBubbleAtEffect width: " + i2 + ", anchorOffset: " + i4 + ", lines: " + i1 + ", remainder: " + paramInt1 + ", text: " + (String)localObject);
      }
      localBubbleTextView.a();
      paramString = new RelativeLayout.LayoutParams(-2, -2);
      paramString.addRule(11, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getId());
      paramString.rightMargin = i3;
      paramString.addRule(2, this.jdField_g_of_type_AndroidWidgetFrameLayout.getId());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localBubbleTextView, paramString);
      localObject = localBubbleTextView;
      return localObject;
      label550:
      paramInt1 = i3;
      i1 = i2;
      localObject = paramString;
      if (i3 >= 4)
      {
        localObject = paramString.substring(0, 13) + "\n" + paramString.substring(13);
        localBubbleTextView.setText((CharSequence)localObject);
        paramInt1 = i3;
        i1 = i2;
        continue;
        label620:
        paramInt1 = i3;
        i1 = i2;
        localObject = paramString;
        if (i2 >= 2)
        {
          localObject = paramString.substring(0, 13) + "\n" + paramString.substring(13, 26);
          localBubbleTextView.setText((CharSequence)localObject);
          paramInt1 = i3;
          i1 = i2;
          continue;
          label692:
          i1 = 1;
          paramInt1 = 0;
          localObject = paramString;
        }
      }
    }
  }
  
  public static String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unKnown";
    }
    for (;;)
    {
      return "[" + paramInt + "][" + str + "]";
      str = "NONE";
      continue;
      str = "CAMERA";
      continue;
      str = "CAMERA_SHELL";
      continue;
      str = "ADD_MEMBER";
      continue;
      str = "ADD_MEMBER_SHELL";
      continue;
      str = "HAND_FREE";
      continue;
      str = "HAND_FREE_SHELL";
      continue;
      str = "MUTE";
      continue;
      str = "MUTE_SHELL";
      continue;
      str = "Effect";
      continue;
      str = "Effect_SHELL";
      continue;
      str = "HIDE";
      continue;
      str = "HIDE_SHELL";
      continue;
      str = "HANG_UP";
      continue;
      str = "CALL_PHONE";
      continue;
      str = "LEAVE_MSG";
      continue;
      str = "ACCEPT";
      continue;
      str = "ACCEPT_BY_AUDIO";
      continue;
      str = "REFUSE";
      continue;
      str = "MSG_REPLY_AUDIO";
      continue;
      str = "MSG_REPLY_VIDEO";
      continue;
      str = "MSG_REPLY_LOCKSCREEN";
      continue;
      str = "SLIDER_AREA";
      continue;
      str = "SLIDER_ACCEPT";
      continue;
      str = "OPEN_LOCK_SHELL";
      continue;
      str = "OPEN_LOCK";
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = a(paramInt1);
    if (localView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.width = paramInt2;
    localLayoutParams.leftMargin = paramInt3;
    localView.setLayoutParams(localLayoutParams);
  }
  
  static boolean a(String paramString, VideoAppInterface paramVideoAppInterface, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    boolean bool3 = false;
    int i3 = 1;
    boolean bool4 = true;
    boolean bool2 = bool3;
    int i2 = i3;
    boolean bool1 = paramBoolean;
    int i1 = paramInt;
    if (paramVideoAppInterface != null)
    {
      Object localObject = paramTextView.getTag(jdField_e_of_type_Int);
      if (localObject == null) {
        break label269;
      }
      if (!((Boolean)localObject).booleanValue()) {
        break label363;
      }
      localObject = new ControlUIObserver.CPreChangButtonStyleInfo(paramTextView, paramBoolean, paramInt);
      paramVideoAppInterface.a(new Object[] { Integer.valueOf(9004), localObject });
      if (!((ControlUIObserver.CPreChangButtonStyleInfo)localObject).jdField_b_of_type_Boolean) {
        break label357;
      }
      i1 = 0;
      if (!((ControlUIObserver.CPreChangButtonStyleInfo)localObject).a()) {
        break label351;
      }
      QLog.w("QavPanel", 1, "ChangButtonStyleWithNotify[" + paramString + "], mBlockName[" + ((ControlUIObserver.CPreChangButtonStyleInfo)localObject).jdField_a_of_type_JavaLangString + "], mBlock[" + ((ControlUIObserver.CPreChangButtonStyleInfo)localObject).jdField_b_of_type_Boolean + "], drawableResId[" + paramInt + "->" + ((ControlUIObserver.CPreChangButtonStyleInfo)localObject).jdField_a_of_type_Int + "], lightStyle[" + paramBoolean + "->" + ((ControlUIObserver.CPreChangButtonStyleInfo)localObject).jdField_a_of_type_Boolean + "]");
      bool1 = bool4;
      label221:
      paramInt = ((ControlUIObserver.CPreChangButtonStyleInfo)localObject).jdField_a_of_type_Int;
      paramBoolean = ((ControlUIObserver.CPreChangButtonStyleInfo)localObject).jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      bool2 = bool1;
      i2 = i1;
      i1 = paramInt;
      bool1 = paramBoolean;
      for (;;)
      {
        if (i2 != 0) {
          AudioHelper.a(paramTextView.getResources(), paramTextView, bool1, i1);
        }
        return bool2;
        label269:
        bool2 = bool3;
        i2 = i3;
        bool1 = paramBoolean;
        i1 = paramInt;
        if (AudioHelper.e())
        {
          QLog.w("QavPanel", 1, "ChangButtonStyleWithNotify[" + paramString + "], 无需回调, lightStyle[" + paramBoolean + "]");
          bool2 = bool3;
          i2 = i3;
          bool1 = paramBoolean;
          i1 = paramInt;
        }
      }
      label351:
      bool1 = false;
      break label221;
      label357:
      i1 = 1;
      break;
      label363:
      i1 = 1;
      bool1 = false;
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.m != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = new ImageView(getContext());
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setAlpha(0.0F);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setImageResource(2130840198);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = new ImageView(getContext());
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setAlpha(0.0F);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setImageResource(2130840198);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = new ImageView(getContext());
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setAlpha(0.0F);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setImageResource(2130840198);
      Object localObject1 = new int[2];
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationInWindow((int[])localObject1);
      Object localObject2 = new int[2];
      this.m.getLocationInWindow((int[])localObject2);
      int i1 = localObject2[0] - localObject1[0];
      int i2 = localObject2[1] - localObject1[1];
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds();
      int i3 = this.m.getWidth();
      this.m.getHeight();
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getId());
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getId());
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = (i1 + i3 - (int)UITools.a(getContext(), 3.0F));
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i2;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0], (ViewGroup.LayoutParams)localObject2);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)UITools.a(getContext(), 7.0F));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)UITools.a(getContext(), 7.0F));
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getId());
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getId());
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = (i3 + i1 - (int)UITools.a(getContext(), 5.0F));
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)UITools.a(getContext(), 15.0F) + i2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1], (ViewGroup.LayoutParams)localObject2);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)UITools.a(getContext(), 6.0F));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)UITools.a(getContext(), 6.0F));
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getId());
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getId());
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i1;
      ((RelativeLayout.LayoutParams)localObject2).topMargin = (i2 + ((Rect)localObject1).height() - (int)UITools.a(getContext(), 7.0F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2], (ViewGroup.LayoutParams)localObject2);
    }
  }
  
  private void j()
  {
    if ((this.m == null) || (this.jdField_g_of_type_AndroidWidgetFrameLayout == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("QavPanel", 2, "removeStar button is not init!");
      }
    }
    while (this.jdField_a_of_type_ArrayOfAndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0]);
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1]);
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2]);
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = null;
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = null;
  }
  
  public int a()
  {
    if (getResources().getDisplayMetrics().heightPixels <= 854) {
      return getResources().getDimensionPixelSize(2131560004);
    }
    return getResources().getDimensionPixelSize(2131560003);
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewClickable, id" + a(paramInt));
    }
    View localView = a(paramInt);
    if (localView != null) {
      return localView.getVisibility();
    }
    return -1;
  }
  
  public View a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.d("QavPanel", 1, "turnViewType2View, WRONG BTN TYPE --> " + paramInt);
      return null;
    case 2131365397: 
      return this.jdField_j_of_type_AndroidWidgetButton;
    case 2131365399: 
      return this.jdField_k_of_type_AndroidWidgetButton;
    case 2131365391: 
      return this.jdField_h_of_type_AndroidWidgetButton;
    case 2131365414: 
      return this.jdField_a_of_type_AndroidWidgetButton;
    case 2131364247: 
      return this.jdField_c_of_type_AndroidWidgetButton;
    case 2131365413: 
      return this.jdField_b_of_type_AndroidWidgetButton;
    case 2131365405: 
      return this.n;
    case 2131365403: 
      return this.m;
    case 2131365401: 
      return this.jdField_l_of_type_AndroidWidgetButton;
    case 2131365388: 
      return this.jdField_a_of_type_AndroidWidgetImageButton;
    case 2131365395: 
      return this.jdField_g_of_type_AndroidWidgetButton;
    case 2131365411: 
      return this.jdField_d_of_type_AndroidWidgetButton;
    case 2131364249: 
      return this.jdField_f_of_type_AndroidWidgetButton;
    case 2131364248: 
      return this.jdField_c_of_type_AndroidViewView;
    case 2131365409: 
      return this.jdField_e_of_type_AndroidWidgetButton;
    case 2131365398: 
      return this.jdField_e_of_type_AndroidWidgetFrameLayout;
    case 2131365390: 
      return this.jdField_b_of_type_AndroidWidgetFrameLayout;
    case 2131365406: 
      return this.o;
    case 2131365396: 
      return this.jdField_d_of_type_AndroidWidgetFrameLayout;
    case 2131365394: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    case 2131365400: 
      return this.jdField_f_of_type_AndroidWidgetFrameLayout;
    case 2131365402: 
      return this.jdField_g_of_type_AndroidWidgetFrameLayout;
    case 2131364252: 
      return this.jdField_a_of_type_AndroidWidgetImageView;
    case 2131365392: 
      return this.jdField_c_of_type_AndroidWidgetFrameLayout;
    }
    return this.jdField_i_of_type_AndroidWidgetButton;
  }
  
  public View a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    View localView = a(paramInt1);
    if (localView != null) {
      localView.setTag(paramInt2, Boolean.valueOf(paramBoolean));
    }
    return localView;
  }
  
  public QavPanelSoundWaveView a()
  {
    return this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    b(paramInt, paramBoolean, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    Object localObject;
    if (paramBoolean1)
    {
      paramInt = 0;
      this.jdField_b_of_type_Int = paramInt;
      d();
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView = new QavPanelSoundWaveView(getContext());
      localObject = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131560000));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelSize(2131560002);
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (!(getContext() instanceof BaseActivity)) {
        break label2209;
      }
      localObject = (BaseActivity)getContext();
      if (!(((BaseActivity)localObject).getAppRuntime() instanceof VideoAppInterface)) {
        break label2209;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)((BaseActivity)localObject).getAppRuntime());
    }
    label2209:
    for (boolean bool = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f();; bool = false)
    {
      switch (this.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewView != null) {
          addView(this.jdField_a_of_type_AndroidViewView);
        }
        addView(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
        bringChildToFront(this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView);
        c();
        this.jdField_a_of_type_Jzn = new jzn(this);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
        ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
        getContext().registerReceiver(this.jdField_a_of_type_Jzn, (IntentFilter)localObject);
        getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.redpoint.broadcast.push.av"));
        if (QLog.isColorLevel()) {
          QLog.d("QavPanel", 2, "[red dot]  register red dot receiver");
        }
        this.jdField_a_of_type_Boolean = true;
        if (AudioHelper.a(0) == 1)
        {
          if (this.jdField_f_of_type_AndroidWidgetFrameLayout != null) {
            this.jdField_f_of_type_AndroidWidgetFrameLayout.setBackgroundColor(Color.argb(255, 255, 255, 255));
          }
          if (this.jdField_l_of_type_AndroidWidgetButton != null) {
            this.jdField_l_of_type_AndroidWidgetButton.setBackgroundColor(Color.argb(255, 68, 128, 2));
          }
          if (this.jdField_g_of_type_AndroidWidgetFrameLayout != null) {
            this.jdField_g_of_type_AndroidWidgetFrameLayout.setBackgroundColor(Color.argb(100, 255, 255, 255));
          }
          if (this.m != null) {
            this.m.setBackgroundColor(Color.argb(255, 68, 128, 2));
          }
        }
        setBtnOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        return;
        paramInt = 1;
        break;
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969332, this, false);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365386);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365414));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365413));
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364247));
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365411));
        this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365409));
        this.jdField_d_of_type_AndroidWidgetButton.setOnTouchListener(this.jdField_b_of_type_AndroidViewView$OnTouchListener);
        b(false);
        continue;
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969331, this, false);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365386);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364252));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364254));
        this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364253));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364251));
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364248);
        this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364249));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365413));
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364247));
        this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = new QavPanelSlideTouchListener(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
        if (bool)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131428827));
          this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new jzh(this));
        }
        for (;;)
        {
          c(false);
          break;
          this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener);
        }
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969337, this, false);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364252));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364254));
        this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364253));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364251));
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364248);
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364247));
        this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener = new QavPanelSlideTouchListener(getContext(), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView, this.jdField_c_of_type_AndroidWidgetImageView);
        if (bool)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131428827));
          this.jdField_a_of_type_AndroidWidgetImageView.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new jzi(this));
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener);
          continue;
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969330, this, false);
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365386);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365388));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365389));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365404));
          this.n = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365405));
          this.o = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365406));
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365394));
          this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365395));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365390));
          this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365391));
          this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365392));
          this.jdField_i_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365393));
          this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365396));
          this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365397));
          this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365398));
          this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365399));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365400));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365401));
          this.jdField_g_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365402));
          this.m = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365403));
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getContext(), this.m).a(53).a();
          if (paramBoolean2) {}
          for (paramInt = 2;; paramInt = 1)
          {
            a(paramBoolean1, paramInt, false);
            break;
          }
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969336, this, false);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365388));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365386);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365394));
          this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365395));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365390));
          this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365391));
          this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365396));
          this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365397));
          this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365398));
          this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365399));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365400));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365401));
          this.jdField_g_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365402));
          this.m = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365403));
          if (paramBoolean2) {}
          for (paramInt = 2;; paramInt = 1)
          {
            a(false, paramInt);
            break;
          }
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969334, this, false);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365388));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365386);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365394));
          this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365395));
          this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365396));
          this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365397));
          this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365398));
          this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365399));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365400));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365401));
          this.jdField_g_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365402));
          this.m = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365403));
          if (paramBoolean2) {}
          for (paramInt = 2;; paramInt = 1)
          {
            b(false, paramInt);
            break;
          }
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969333, this, false);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131365388));
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365386);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365394));
          this.jdField_g_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365395));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365390));
          this.jdField_h_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365391));
          this.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365396));
          this.jdField_j_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365397));
          this.jdField_e_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365398));
          this.jdField_k_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365399));
          this.jdField_f_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365400));
          this.jdField_l_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365401));
          a(false);
        }
      }
    }
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
  
  public void a(QQFrameByFrameAnimation paramQQFrameByFrameAnimation)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      paramQQFrameByFrameAnimation.a(this.jdField_a_of_type_AndroidWidgetImageButton);
      paramQQFrameByFrameAnimation.b();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.w("QavPanel", 1, "showEffectOperateAnimation, tips[" + paramString + "]");
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true)))
    {
      if ((this.m != null) && (this.jdField_g_of_type_AndroidWidgetFrameLayout != null)) {
        break label82;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QavPanel", 2, "showEffectOperateAnimation button is not init!");
      }
    }
    return;
    label82:
    if (this.jdField_d_of_type_AndroidWidgetImageView == null) {
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(getContext());
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView == null) {
      this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(getContext());
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.m.getCompoundDrawables()[1];
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable().mutate();
    ((Drawable)localObject).setAlpha(255);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_e_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new jzl(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener((View.OnTouchListener)localObject);
    this.m.setOnTouchListener((View.OnTouchListener)localObject);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).addListener(new jzm(this, paramString, paramInt1, paramInt2));
    paramString = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds();
    paramInt1 = paramString.width() - (int)UITools.a(getContext(), 4.0F);
    paramInt2 = paramString.height() - (int)UITools.a(getContext(), 4.0F);
    if (QLog.isColorLevel()) {
      QLog.e("QavPanel", 2, "showEffectOperateAnimation width: " + paramInt1 + ", height: " + paramInt2);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(0);
    if (QLog.isDevelopLevel()) {
      QLog.w("QavPanel", 1, "setCompoundDrawables[showEffectOperateAnimation]");
    }
    this.m.setCompoundDrawables(null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null);
    paramString = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    paramString.gravity = 49;
    this.jdField_d_of_type_AndroidWidgetImageView.setPivotX(0.0F);
    this.jdField_d_of_type_AndroidWidgetImageView.setPivotY(paramInt1 / 2.0F);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setClickable(false);
    if (this.jdField_d_of_type_AndroidWidgetImageView.getParent() != null) {
      ((ViewGroup)this.jdField_d_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_d_of_type_AndroidWidgetImageView);
    }
    this.jdField_g_of_type_AndroidWidgetFrameLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView, paramString);
    paramString = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    paramString.gravity = 49;
    this.jdField_e_of_type_AndroidWidgetImageView.setPivotX(paramInt1);
    this.jdField_e_of_type_AndroidWidgetImageView.setPivotY(paramInt1 / 2.0F);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetImageView.setClickable(false);
    if (this.jdField_e_of_type_AndroidWidgetImageView.getParent() != null) {
      ((ViewGroup)this.jdField_e_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_e_of_type_AndroidWidgetImageView);
    }
    this.jdField_g_of_type_AndroidWidgetFrameLayout.addView(this.jdField_e_of_type_AndroidWidgetImageView, paramString);
    float f1 = UITools.a(getContext(), -6.0F);
    paramString = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, f1, 0.0F });
    paramString.setDuration(500L);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.8F });
    localObjectAnimator1.setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.8F });
    localObjectAnimator2.setDuration(500L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.8F });
    localObjectAnimator3.setDuration(500L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.8F, 0.0F });
    localObjectAnimator4.setDuration(270L);
    localObjectAnimator4.setStartDelay(500L);
    f1 = UITools.a(getContext(), 7.5F);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, f1, 0.0F });
    localObjectAnimator5.setDuration(500L);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidWidgetImageView, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator6.setDuration(400L);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidWidgetImageView, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator7.setDuration(400L);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator8.setDuration(500L);
    i();
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0], "alpha", new float[] { 0.0F, 1.0F, 0.0F });
    localObjectAnimator9.setDuration(600L);
    localObjectAnimator9.setStartDelay(900L);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1], "alpha", new float[] { 0.0F, 1.0F, 0.0F });
    localObjectAnimator10.setDuration(600L);
    localObjectAnimator10.setStartDelay(1500L);
    ObjectAnimator localObjectAnimator11 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2], "alpha", new float[] { 0.0F, 1.0F, 0.0F });
    localObjectAnimator11.setDuration(600L);
    localObjectAnimator11.setStartDelay(500L);
    ((AnimatorSet)localObject).play(paramString).with(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).with(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).with(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).with(localObjectAnimator11);
    ((AnimatorSet)localObject).start();
  }
  
  public void a(boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics;
    int i2;
    int i1;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localDisplayMetrics = getResources().getDisplayMetrics();
      i2 = (int)(localDisplayMetrics.widthPixels * jdField_g_of_type_Double);
      i1 = (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double);
      if (i1 <= a() * 2 / 5) {
        break label337;
      }
      i1 = a() * 2 / 5;
    }
    label337:
    for (;;)
    {
      int i3 = (int)(localDisplayMetrics.widthPixels * jdField_a_of_type_Double);
      a(2131365396, i2, i3);
      a(2131365390, i2 + 10, i3 - 5);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_c_of_type_Double);
      a(2131365398, i2, i3);
      a(2131365400, i2, i3);
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        i3 = (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        localLayoutParams.width = i1;
        localLayoutParams.height = i1;
        localLayoutParams.leftMargin = i3;
        this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
      }
      a(2131365394, i2, (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double) * 2 + (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double) - 5);
      AudioHelper.a(getResources(), this.jdField_j_of_type_AndroidWidgetButton, paramBoolean, 2130840140);
      AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, paramBoolean, 2130840136);
      AudioHelper.a(getResources(), this.jdField_k_of_type_AndroidWidgetButton, paramBoolean, 2130840131);
      AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, paramBoolean, 2130840134);
      AudioHelper.a(getResources(), this.jdField_h_of_type_AndroidWidgetButton, paramBoolean, 2130840125);
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int i1 = 0;
    label27:
    DisplayMetrics localDisplayMetrics;
    int i2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        break label376;
      }
      this.jdField_b_of_type_Int = i1;
      localDisplayMetrics = getResources().getDisplayMetrics();
      i2 = (int)(localDisplayMetrics.widthPixels * jdField_g_of_type_Double);
      i1 = (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double);
      if (i1 <= a() * 2 / 5) {
        break label381;
      }
      i1 = a() * 2 / 5;
    }
    label376:
    label381:
    for (;;)
    {
      int i3 = (int)(localDisplayMetrics.widthPixels * jdField_b_of_type_Double);
      a(2131365396, i2, i3);
      a(2131365390, i2 + 10, i3 - 5);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_d_of_type_Double);
      a(2131365398, i2, i3);
      a(2131365400, i2, i3);
      a(2131365402, i2 + 10, i3 - 5);
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        i3 = (int)(localDisplayMetrics.widthPixels * jdField_f_of_type_Double);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        localLayoutParams.width = i1;
        localLayoutParams.height = i1;
        localLayoutParams.leftMargin = i3;
        this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
      }
      a(2131365394, i2, (int)(localDisplayMetrics.widthPixels * jdField_f_of_type_Double) * 2 + (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double) - 5);
      AudioHelper.a(getResources(), this.jdField_j_of_type_AndroidWidgetButton, paramBoolean, 2130840140);
      AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, paramBoolean, 2130840136);
      AudioHelper.a(getResources(), this.jdField_k_of_type_AndroidWidgetButton, paramBoolean, 2130840131);
      AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, paramBoolean, 2130840134);
      AudioHelper.a(getResources(), this.jdField_h_of_type_AndroidWidgetButton, paramBoolean, 2130840125);
      a(paramInt, paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      i1 = 1;
      break label27;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "videoSession :" + paramBoolean1 + ", localHasVideo:" + paramInt + ", isVipFunCall:" + paramBoolean2);
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      paramBoolean2 = true;
      if (!paramBoolean1) {
        break label277;
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label87:
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(paramBoolean2);
      if (paramInt == 0) {
        break label297;
      }
      this.jdField_g_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      label107:
      if (this.jdField_a_of_type_Boolean) {
        break label309;
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
        this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(null);
      }
      label131:
      if (!paramBoolean2) {
        break label531;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = i1;
      AudioHelper.a(getResources(), this.jdField_j_of_type_AndroidWidgetButton, paramBoolean2, 2130840140);
      AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, paramBoolean2, 2130840136);
      AudioHelper.a(getResources(), this.jdField_k_of_type_AndroidWidgetButton, paramBoolean2, 2130840131);
      AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, paramBoolean2, 2130840134);
      a(paramInt, paramBoolean2);
      AudioHelper.a(getResources(), this.jdField_i_of_type_AndroidWidgetButton, paramBoolean2, 2130840143);
      a("BtnAddMember", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_h_of_type_AndroidWidgetButton, paramBoolean2, 2130840125);
      AudioHelper.a(getResources(), this.n, paramBoolean2, 2130840145);
      AudioHelper.a(getResources(), this.o, paramBoolean2, 2130840155);
      return;
      paramBoolean2 = false;
      break;
      label277:
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label87;
      label297:
      this.jdField_g_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      break label107;
      label309:
      if (paramInt != 0)
      {
        paramBoolean1 = true;
        label315:
        if (paramBoolean1 == this.jdField_b_of_type_Boolean) {
          break label455;
        }
        if (paramInt == 0) {
          break label457;
        }
      }
      label455:
      label457:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        this.jdField_b_of_type_Boolean = paramBoolean1;
        this.jdField_d_of_type_AndroidWidgetFrameLayout.clearAnimation();
        this.jdField_e_of_type_AndroidWidgetFrameLayout.clearAnimation();
        this.jdField_f_of_type_AndroidWidgetFrameLayout.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
        this.jdField_b_of_type_AndroidWidgetFrameLayout.clearAnimation();
        this.jdField_c_of_type_AndroidWidgetFrameLayout.clearAnimation();
        if (!this.jdField_b_of_type_Boolean) {
          break label462;
        }
        this.jdField_d_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_e_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
        this.jdField_f_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_e_of_type_AndroidViewAnimationAnimation);
        this.jdField_g_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_g_of_type_AndroidViewAnimationAnimation);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_i_of_type_AndroidViewAnimationAnimation);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_k_of_type_AndroidViewAnimationAnimation);
        break;
        paramBoolean1 = false;
        break label315;
        break;
      }
      label462:
      this.jdField_d_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.jdField_e_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
      this.jdField_f_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_f_of_type_AndroidViewAnimationAnimation);
      this.jdField_g_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_h_of_type_AndroidViewAnimationAnimation);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_j_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(this.jdField_l_of_type_AndroidViewAnimationAnimation);
      break label131;
      label531:
      i1 = 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "checkView, id" + a(paramInt));
    }
    return a(paramInt) == null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewBackground, id" + a(paramInt1) + ", selected[" + paramInt2 + "]");
    }
    View localView = a(paramInt1);
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
      QLog.d("QavPanel", 2, "setViewMargin, id" + a(paramInt1) + ", direction[" + paramInt2 + "], margin[" + paramInt3 + "]");
    }
    if (paramInt3 < 0) {
      return false;
    }
    View localView = a(paramInt1);
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
      QLog.d("QavPanel", 2, "setViewAccText, id" + a(paramInt) + ", text[" + paramString + "]");
    }
    View localView = a(paramInt);
    if (localView != null)
    {
      UITools.a(localView, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewAccText, id" + a(paramInt1) + ", text[" + paramString + "], audioType[" + paramInt2 + "]");
    }
    View localView = a(paramInt1);
    if (localView != null)
    {
      UITools.a(localView, paramString, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewSelected, id" + a(paramInt) + ", selected[" + paramBoolean + "]");
    }
    View localView = a(paramInt);
    if (localView != null)
    {
      localView.setSelected(paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(QavPanel.SlideAcceptListener paramSlideAcceptListener)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSlideTouchListener.a(paramSlideAcceptListener);
    return true;
  }
  
  public boolean a(TraeHelper paramTraeHelper)
  {
    if ((paramTraeHelper != null) && (this.jdField_l_of_type_AndroidWidgetButton != null))
    {
      paramTraeHelper.a(this.jdField_l_of_type_AndroidWidgetButton);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        paramTraeHelper.a(this.jdField_a_of_type_ComTencentAvUtilsTipsManager);
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "[red dot] updateRedDot 1");
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavPanel", 2, "[red dot] updateRedDot 2");
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(null);
      if (this.jdField_c_of_type_Int == 1) {
        localAppInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a("103416");
      }
      if (localAppInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
        if (QLog.isColorLevel()) {
          QLog.d("QavPanel", 2, "[red dot] Effect iNewFlag = " + localAppInfo.iNewFlag.get());
        }
      }
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateEffectBtn, mIsShowEffectOperateAnimation[").append(this.jdField_d_of_type_Boolean).append("], effectType[").append(paramInt).append("], highLight[").append(paramBoolean1).append("], mEffectDrawable[");
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        bool = true;
        QLog.d("QavPanel", 2, bool + "], ignoreSetSelected[" + paramBoolean2 + "]");
      }
    }
    else
    {
      if ((this.m != null) && (this.jdField_g_of_type_AndroidWidgetFrameLayout != null)) {
        break label118;
      }
    }
    label118:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.jdField_c_of_type_Int = paramInt;
        if (paramInt != 1) {
          break label208;
        }
        if ((a("BtnEffect", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.m, paramBoolean1, 2130840149)) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          this.m.setSelected(false);
          return;
        }
        if (QLog.isDevelopLevel()) {
          QLog.w("QavPanel", 1, "setCompoundDrawables[updateEffectBtn]");
        }
        this.m.setCompoundDrawables(null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null);
      } while (paramBoolean2);
      this.m.setSelected(true);
      return;
      if (paramInt != 2) {
        break label252;
      }
      if (!this.jdField_d_of_type_Boolean) {
        a("BtnEffect", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.m, paramBoolean1, 2130840132);
      }
    } while (paramBoolean2);
    label208:
    this.m.setSelected(false);
    return;
    label252:
    this.jdField_g_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131493511));
      }
      if (this.jdField_c_of_type_AndroidWidgetButton != null) {
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(getResources().getColor(2131493511));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(paramBoolean);
      }
      if (this.jdField_e_of_type_AndroidWidgetButton != null) {
        AudioHelper.a(getResources(), this.jdField_e_of_type_AndroidWidgetButton, paramBoolean, 2130840129);
      }
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        AudioHelper.a(getResources(), this.jdField_b_of_type_AndroidWidgetButton, paramBoolean, 2130840108);
      }
      return;
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_c_of_type_AndroidWidgetButton != null) {
        this.jdField_c_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#566B7D"));
      }
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    int i1 = 0;
    label27:
    DisplayMetrics localDisplayMetrics;
    int i2;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        break label345;
      }
      this.jdField_b_of_type_Int = i1;
      localDisplayMetrics = getResources().getDisplayMetrics();
      i2 = (int)(localDisplayMetrics.widthPixels * jdField_g_of_type_Double);
      i1 = (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double);
      if (i1 <= a() * 2 / 5) {
        break label350;
      }
      i1 = a() * 2 / 5;
    }
    label345:
    label350:
    for (;;)
    {
      int i3 = (int)(localDisplayMetrics.widthPixels * jdField_a_of_type_Double);
      a(2131365396, i2, i3);
      a(2131365402, i2 + 10, i3 - 5);
      i3 = (int)(localDisplayMetrics.widthPixels * jdField_c_of_type_Double);
      a(2131365398, i2, i3);
      a(2131365400, i2, i3);
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
      {
        i3 = (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        localLayoutParams.width = i1;
        localLayoutParams.height = i1;
        localLayoutParams.leftMargin = i3;
        this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(localLayoutParams);
      }
      a(2131365394, i2, (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double) * 2 + (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double) - 5);
      AudioHelper.a(getResources(), this.jdField_j_of_type_AndroidWidgetButton, paramBoolean, 2130840140);
      AudioHelper.a(getResources(), this.jdField_g_of_type_AndroidWidgetButton, paramBoolean, 2130840136);
      AudioHelper.a(getResources(), this.jdField_k_of_type_AndroidWidgetButton, paramBoolean, 2130840131);
      AudioHelper.a(getResources(), this.jdField_l_of_type_AndroidWidgetButton, paramBoolean, 2130840134);
      a(paramInt, paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break;
      i1 = 1;
      break label27;
    }
  }
  
  public boolean b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "isViewEnable, id" + a(paramInt));
    }
    View localView = a(paramInt);
    if (localView != null) {
      return localView.isEnabled();
    }
    return false;
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return b(paramInt1, paramInt2, -1);
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewRule, id" + a(paramInt1) + ", verb[" + paramInt2 + "], anchor[" + paramInt3 + "]");
    }
    View localView = a(paramInt1);
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
      QLog.d("QavPanel", 2, "setViewClickable, id" + a(paramInt));
    }
    View localView = a(paramInt);
    if (localView != null)
    {
      localView.setClickable(paramBoolean);
      return true;
    }
    return false;
  }
  
  void c()
  {
    Object localObject = getResources().getDisplayMetrics();
    int i1 = getResources().getDimensionPixelSize(2131559998);
    int i5 = getResources().getDimensionPixelSize(2131560000);
    int i4 = getResources().getDimensionPixelSize(2131560003);
    int i3 = getResources().getDimensionPixelSize(2131560005);
    int i2 = getResources().getDimensionPixelSize(2131560007);
    int i7 = 0;
    if (((DisplayMetrics)localObject).heightPixels <= 854)
    {
      i1 = getResources().getDimensionPixelSize(2131559999);
      i5 = getResources().getDimensionPixelSize(2131560001);
      i4 = getResources().getDimensionPixelSize(2131560004);
      i3 = getResources().getDimensionPixelSize(2131560006);
      i2 = getResources().getDimensionPixelSize(2131560008);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavPanel", 2, "adjustPanel, heightPixels[" + ((DisplayMetrics)localObject).heightPixels + "], panelHeight[" + i1 + "], waveHeight[" + i5 + "], shadowHeight[" + i4 + "], marginBottom[" + i3 + "], lockMarginBottom[" + i2 + "], mPanelType[" + this.jdField_a_of_type_Int + "], exteranlPanelMarginTop=[" + this.jdField_d_of_type_Int);
      }
      int i6;
      if (this.jdField_a_of_type_Int == 4)
      {
        i1 = ((DisplayMetrics)localObject).widthPixels * 880 / 750;
        i7 = this.jdField_d_of_type_Int;
        i6 = -1;
      }
      for (i1 = i1 - i5 + i7;; i1 = i7)
      {
        try
        {
          localObject = (RelativeLayout.LayoutParams)getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = i6;
          if ((this.jdField_a_of_type_Int == 4) && (i1 != 0)) {
            ((RelativeLayout.LayoutParams)localObject).topMargin = i1;
          }
          setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        catch (Exception localException)
        {
          label331:
          break label331;
        }
        if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = i5;
          this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = i4;
          this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        a(2131365396, 4, i3);
        a(2131365398, 4, i3);
        a(2131365400, 4, i3);
        a(2131365402, 4, i3);
        if (this.jdField_a_of_type_Int == 6) {
          a(2131365402, 4, getResources().getDimensionPixelSize(2131560005));
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
          {
            a(2131364247, 4, i2);
            a(2131364249, 4, i2);
            a(2131365413, 4, i2);
          }
          return;
          a(2131365402, 4, i3);
        }
        i6 = i1;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.a(paramBoolean);
    }
    if (this.jdField_f_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_f_of_type_AndroidWidgetButton, paramBoolean, 2130840129);
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_b_of_type_AndroidWidgetButton, paramBoolean, 2130840108);
    }
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      AudioHelper.a(getResources(), this.jdField_c_of_type_AndroidWidgetButton, paramBoolean, 2130840261);
    }
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((this.jdField_c_of_type_AndroidWidgetFrameLayout != null) && (paramBoolean))
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_i_of_type_AndroidWidgetButton.setEnabled(false);
      Resources localResources = getResources();
      Button localButton = this.jdField_i_of_type_AndroidWidgetButton;
      paramBoolean = bool;
      if (this.jdField_b_of_type_Int == 0) {
        paramBoolean = true;
      }
      AudioHelper.a(localResources, localButton, paramBoolean, paramInt);
    }
  }
  
  public void d()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double) + (float)(jdField_d_of_type_Double - jdField_c_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double) + (float)(jdField_c_of_type_Double - jdField_d_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_e_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double) + (float)(jdField_d_of_type_Double - jdField_c_of_type_Double) * 2.0F, 1, 0.0F, 1, 0.0F);
    this.jdField_e_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_e_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_f_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double) + (float)(jdField_c_of_type_Double - jdField_d_of_type_Double) * 2.0F, 1, 0.0F, 1, 0.0F);
    this.jdField_f_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_f_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_g_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double) + (float)(jdField_d_of_type_Double - jdField_c_of_type_Double) * 3.0F, 1, 0.0F, 1, 0.0F);
    this.jdField_g_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_g_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_h_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double) + (float)(jdField_c_of_type_Double - jdField_d_of_type_Double) * 3.0F, 1, 0.0F, 1, 0.0F);
    this.jdField_h_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_h_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_i_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_b_of_type_Double - jdField_a_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_i_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_i_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_j_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, (float)(jdField_a_of_type_Double - jdField_b_of_type_Double), 1, 0.0F, 1, 0.0F);
    this.jdField_j_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_j_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    int i1 = (int)(localDisplayMetrics.widthPixels * jdField_f_of_type_Double) * 2 + (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double);
    int i2 = (int)(localDisplayMetrics.widthPixels * jdField_e_of_type_Double);
    i2 = (int)(localDisplayMetrics.widthPixels * jdField_h_of_type_Double) + i2 * 2;
    if (localDisplayMetrics.widthPixels != 0) {}
    for (float f1 = (i1 - i2) / localDisplayMetrics.widthPixels + (float)(jdField_b_of_type_Double - jdField_a_of_type_Double);; f1 = 0.0F)
    {
      if (localDisplayMetrics.widthPixels != 0) {}
      for (float f2 = (i2 - i1) / localDisplayMetrics.widthPixels + (float)(jdField_a_of_type_Double - jdField_b_of_type_Double);; f2 = 0.0F)
      {
        this.jdField_k_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, f1, 1, 0.0F, 1, 0.0F);
        this.jdField_k_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
        this.jdField_k_of_type_AndroidViewAnimationAnimation.setDuration(150L);
        this.jdField_l_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 2, f2, 1, 0.0F, 1, 0.0F);
        this.jdField_l_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
        this.jdField_l_of_type_AndroidViewAnimationAnimation.setDuration(150L);
        this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new jzk(this);
        this.jdField_g_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_h_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        return;
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (EffectSettingUi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false))
    {
      if ((this.m != null) && (this.jdField_g_of_type_AndroidWidgetFrameLayout != null)) {
        break label42;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QavPanel", 2, "hideEffectOperate button is not init!");
      }
    }
    label42:
    EffectOperateManager localEffectOperateManager;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("QavPanel", 2, "hideEffectOperate");
      }
      SmallScreenUtils.a("hideEffectOperate");
      this.jdField_d_of_type_Boolean = false;
      b(this.jdField_c_of_type_Int, paramBoolean, true);
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_g_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_d_of_type_AndroidWidgetImageView);
        this.jdField_d_of_type_AndroidWidgetImageView = null;
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_g_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_e_of_type_AndroidWidgetImageView);
        this.jdField_e_of_type_AndroidWidgetImageView = null;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView);
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      this.m.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      localEffectOperateManager = (EffectOperateManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(8);
    } while (localEffectOperateManager == null);
    localEffectOperateManager.c(false);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.f();
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.g();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void g()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Jzn != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_Jzn);
      this.jdField_a_of_type_Jzn = null;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (QLog.isColorLevel()) {
        QLog.e("QavPanel", 2, "[red dot] unregister red dot receiver");
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.c();
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    }
  }
  
  public boolean isPressed()
  {
    return (super.isPressed()) || ((this.jdField_d_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_d_of_type_AndroidWidgetFrameLayout.isPressed())) || ((this.jdField_j_of_type_AndroidWidgetButton != null) && (this.jdField_j_of_type_AndroidWidgetButton.isPressed())) || ((this.jdField_e_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_e_of_type_AndroidWidgetFrameLayout.isPressed())) || ((this.jdField_k_of_type_AndroidWidgetButton != null) && (this.jdField_k_of_type_AndroidWidgetButton.isPressed())) || ((this.jdField_f_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_f_of_type_AndroidWidgetFrameLayout.isPressed())) || ((this.jdField_l_of_type_AndroidWidgetButton != null) && (this.jdField_l_of_type_AndroidWidgetButton.isPressed())) || ((this.jdField_g_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_g_of_type_AndroidWidgetFrameLayout.isPressed())) || ((this.m != null) && (this.m.isPressed()));
  }
  
  public void setAcceptDrawableTop(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(null, paramDrawable, null, null);
  }
  
  public void setAddtionalMartinTop(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    c();
  }
  
  public void setBtnOnClickListener(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setBtnOnClickListener --> BtnType = " + paramInt);
    }
    View localView = a(paramInt);
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setBtnOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
    if (this.jdField_d_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_d_of_type_AndroidWidgetFrameLayout.setOnTouchListener(paramOnTouchListener);
    }
    if (this.jdField_j_of_type_AndroidWidgetButton != null) {
      this.jdField_j_of_type_AndroidWidgetButton.setOnTouchListener(paramOnTouchListener);
    }
    if (this.jdField_e_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_e_of_type_AndroidWidgetFrameLayout.setOnTouchListener(paramOnTouchListener);
    }
    if (this.jdField_k_of_type_AndroidWidgetButton != null) {
      this.jdField_k_of_type_AndroidWidgetButton.setOnTouchListener(paramOnTouchListener);
    }
    if (this.jdField_f_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_f_of_type_AndroidWidgetFrameLayout.setOnTouchListener(paramOnTouchListener);
    }
    if (this.jdField_l_of_type_AndroidWidgetButton != null) {
      this.jdField_l_of_type_AndroidWidgetButton.setOnTouchListener(paramOnTouchListener);
    }
    if (this.jdField_g_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_g_of_type_AndroidWidgetFrameLayout.setOnTouchListener(paramOnTouchListener);
    }
    if (this.m != null) {
      this.m.setOnTouchListener(paramOnTouchListener);
    }
  }
  
  public void setEffectDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setEffectOperateDrawable(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setEffectOperateDrawable");
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setMultiPstnCallback(boolean paramBoolean)
  {
    Button localButton1 = (Button)findViewById(2131366159);
    Button localButton2 = (Button)findViewById(2131366160);
    Button localButton3 = (Button)findViewById(2131366161);
    if (localButton1 != null)
    {
      AudioHelper.a(getResources(), localButton1, false, 2130840140);
      localButton1.setEnabled(false);
      if (paramBoolean) {
        localButton1.setVisibility(0);
      }
    }
    else
    {
      if (localButton2 != null)
      {
        AudioHelper.a(getResources(), localButton2, false, 2130840131);
        localButton2.setEnabled(false);
        if (!paramBoolean) {
          break label169;
        }
        localButton2.setVisibility(0);
      }
      label94:
      if (localButton3 != null)
      {
        AudioHelper.a(getResources(), localButton3, false, 2130840134);
        localButton3.setEnabled(false);
        if (!paramBoolean) {
          break label178;
        }
        localButton3.setVisibility(0);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label188;
      }
      setViewVisibility(2131365397, 8);
      setViewVisibility(2131365399, 8);
      setViewVisibility(2131365401, 8);
      return;
      localButton1.setVisibility(8);
      break;
      label169:
      localButton2.setVisibility(8);
      break label94;
      label178:
      localButton3.setVisibility(8);
    }
    label188:
    setViewVisibility(2131365397, 0);
    setViewVisibility(2131365399, 0);
    setViewVisibility(2131365401, 0);
  }
  
  public void setTipsManager(TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = paramTipsManager;
  }
  
  public void setViewEnable(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewEnable, id" + a(paramInt) + ", enable[" + paramBoolean + "]");
    }
    View localView = a(paramInt);
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  public void setViewVisibility(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavPanel", 2, "setViewVisibility, id" + a(paramInt1) + ", visibility[" + paramInt2 + "]");
    }
    View localView = a(paramInt1);
    if (localView != null) {
      localView.setVisibility(paramInt2);
    }
  }
  
  public void setWaveVisibility(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanelSoundWaveView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel
 * JD-Core Version:    0.7.0.1
 */