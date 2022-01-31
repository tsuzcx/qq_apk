package com.tencent.mobileqq.apollo.store.openbox;

import aldt;
import aldu;
import aler;
import ales;
import alet;
import aleu;
import alev;
import alew;
import alex;
import aley;
import alez;
import alfb;
import alfc;
import aliu;
import alsf;
import alud;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bdgk;
import bdhj;
import bdin;
import bead;
import beae;
import beag;
import beaj;
import bflr;
import bhtd;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(11)
public class ApolloCardWindow
  extends RelativeLayout
  implements aley, alez, alfb, Handler.Callback, View.OnClickListener
{
  static float jdField_a_of_type_Float;
  private static final String jdField_a_of_type_JavaLangString = alud.a(2131700698);
  public static Map<String, Drawable> a;
  private static boolean jdField_a_of_type_Boolean;
  static float jdField_b_of_type_Float;
  private static final String jdField_b_of_type_JavaLangString = alud.a(2131700687);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aler jdField_a_of_type_Aler;
  private alew jdField_a_of_type_Alew;
  private alex jdField_a_of_type_Alex;
  private Context jdField_a_of_type_AndroidContentContext;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bead jdField_a_of_type_Bead = new alev(this);
  beaj jdField_a_of_type_Beaj;
  private bhtd jdField_a_of_type_Bhtd;
  private ApolloOpenBoxView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView;
  private OpeningCardGroup jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup;
  private RoundRectLinearLayout jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  Runnable jdField_a_of_type_JavaLangRunnable = new ApolloCardWindow.3(this);
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloCardLayout> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  ScaleAnimation jdField_b_of_type_AndroidViewAnimationScaleAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundRectLinearLayout jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private int jdField_h_of_type_Int;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private int jdField_i_of_type_Int;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public ApolloCardWindow(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
    this.jdField_a_of_type_Beaj = new beag(BaseApplicationImpl.getApplication().getRuntime()).a(3);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 10, null, true);
  }
  
  public static void a()
  {
    jdField_a_of_type_Float = alsf.a() / 16.0F;
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = 1.0F;
    }
    jdField_b_of_type_Float = bdgk.a() / jdField_a_of_type_Float;
    if (jdField_b_of_type_Float == 0.0F) {
      jdField_b_of_type_Float = bdgk.a();
    }
  }
  
  public static void b()
  {
    int n = 0;
    if (jdField_a_of_type_Boolean) {}
    do
    {
      return;
      jdField_a_of_type_Boolean = true;
      int m = 0;
      String str;
      while (m <= 9)
      {
        str = "apollo_card_gold_" + m + ".png";
        if (!new File(aliu.k + "boxcard/" + str).exists()) {
          aldt.a(str, null, aldt.a(str)).startDownload();
        }
        m += 1;
      }
      if (!new File(aliu.k + "boxcard/" + "apollo_card_gold_add.png").exists()) {
        aldt.a("apollo_card_gold_add.png", null, aldt.a("apollo_card_gold_add.png")).startDownload();
      }
      m = n;
      if (!new File(aliu.k + "boxcard/" + "apollo_card_gold_icon.png").exists())
      {
        aldt.a("apollo_card_gold_icon.png", null, aldt.a("apollo_card_gold_icon.png")).startDownload();
        m = n;
      }
      while (m <= 9)
      {
        str = "apollo_card_crystal_" + m + ".png";
        if (!new File(aliu.k + "boxcard/" + str).exists()) {
          aldt.a(str, null, aldt.a(str)).startDownload();
        }
        m += 1;
      }
      if (!new File(aliu.k + "boxcard/" + "apollo_card_crystal_add.png").exists()) {
        aldt.a("apollo_card_crystal_add.png", null, aldt.a("apollo_card_crystal_add.png")).startDownload();
      }
    } while (new File(aliu.k + "boxcard/" + "apollo_card_crystal_image.png").exists());
    aldt.a("apollo_card_crystal_image.png", null, aldt.a("apollo_card_crystal_image.png")).startDownload();
  }
  
  private void d()
  {
    setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()), 0, 0);
    this.jdField_i_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Alex = new alex(this);
    this.jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
    a();
    int n = (int)bdgk.i();
    int m = (int)bdgk.j() - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
    super.setBackgroundColor(-671088640);
    this.jdField_c_of_type_Int = ((int)(n * 0.706F));
    this.jdField_d_of_type_Int = ((int)(n * 0.04F));
    this.jdField_e_of_type_Int = ((n - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int * 2) / 2);
    this.jdField_f_of_type_Int = (this.jdField_c_of_type_Int * 760 / 530);
    this.jdField_h_of_type_Int = ((int)(m * 0.23F));
    this.j = (n >> 1);
    this.k = ((int)(m * 0.461F));
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = new RelativeLayout(getContext());
    super.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup = new OpeningCardGroup(this.jdField_a_of_type_AndroidContentContext, this);
    localObject3 = new RelativeLayout.LayoutParams(-1, this.jdField_f_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setFrameWidth(this.jdField_c_of_type_Int, this.jdField_f_of_type_Int, 0, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setClickLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850069);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(n * 0.032D));
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(m * 0.017D));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(17.0F / jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690885);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    super.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = new RoundRectLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setOrientation(0);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setGravity(17);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect(ApolloUtil.a(15.0F, jdField_b_of_type_Float), -1, true);
    localObject3 = new RelativeLayout.LayoutParams(-2, ApolloUtil.a(30.0F, jdField_b_of_type_Float));
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(m * 0.018F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(10);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setPadding(0, 0, ApolloUtil.a(12.0F, jdField_b_of_type_Float), 0);
    super.addView(this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout, (ViewGroup.LayoutParams)localObject3);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject3 = new LinearLayout.LayoutParams(ApolloUtil.a(15.0F, jdField_b_of_type_Float), ApolloUtil.a(17.0F, jdField_b_of_type_Float));
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.a(12.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F / jdField_a_of_type_Float);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.a(3.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_f_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject3 = new LinearLayout.LayoutParams(ApolloUtil.a(15.0F, jdField_b_of_type_Float), ApolloUtil.a(17.0F, jdField_b_of_type_Float));
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.a(15.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_h_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(12.0F / jdField_a_of_type_Float);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.a(3.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_h_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject3 = new LinearLayout.LayoutParams(ApolloUtil.a(15.0F, jdField_b_of_type_Float), ApolloUtil.a(17.0F, jdField_b_of_type_Float));
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.a(15.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_h_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_i_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(12.0F / jdField_a_of_type_Float);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.a(3.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_i_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(14.0F / jdField_a_of_type_Float);
    this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-34816);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(alud.a(2131700697));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = ((int)(n * 0.029F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(14);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(m * 0.17F));
    super.addView(this.jdField_g_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(17.0F / jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_e_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
    ((LinearLayout.LayoutParams)localObject3).bottomMargin = ApolloUtil.a(25.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new LinearLayout.LayoutParams(-1, ApolloUtil.a(250.0F, jdField_b_of_type_Float) * 3 / 4);
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    URLDrawable localURLDrawable = aldt.a("apollo_error.png", null, aldt.a("apollo_error.png"));
    localURLDrawable.setTargetDensity(((Resources)localObject2).getDisplayMetrics().densityDpi / 2);
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER);
    localURLImageView.setImageDrawable(localURLDrawable);
    localURLImageView.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localURLImageView, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ApolloUtil.a(66.0F, jdField_b_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ApolloUtil.a(129.0F, jdField_b_of_type_Float);
    super.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839227);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_g_of_type_Int = ((int)(m * 0.061F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(17);
    localObject2 = new RelativeLayout.LayoutParams((int)(n * 0.936F), this.jdField_g_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(n * 0.027F));
    super.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = new RoundRectLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect((int)(n * 0.008F), -7707920, false);
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838351);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(18.0F / jdField_a_of_type_Float);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("送花给TA");
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtil.a(8.0F, jdField_b_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_d_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setOnClickListener(this);
    localObject2 = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout, (ViewGroup.LayoutParams)localObject2);
    this.jdField_e_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(18.0F);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(m * 0.2F));
    super.addView(this.jdField_e_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView = new ApolloOpenBoxView(this.jdField_a_of_type_AndroidContentContext, this);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_f_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ApolloUtil.a(217.0F, jdField_b_of_type_Float);
    this.jdField_f_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(30.0F / jdField_a_of_type_Float);
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-1);
    ((RelativeLayout)localObject1).addView(this.jdField_f_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    m = 0;
    while (m < 4)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ApolloCardLayout(this.jdField_a_of_type_AndroidContentContext));
      m += 1;
    }
    this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130838350);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = (n / 4);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)(n * 0.04F));
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
    super.addView(this.jdField_e_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    super.setOnClickListener(this);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Aler == null) || (this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    Object localObject1;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aler.jdField_c_of_type_JavaLangString))
    {
      localObject1 = "";
      label50:
      if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (!this.jdField_d_of_type_JavaLangString.equals(this.jdField_a_of_type_Aler.jdField_b_of_type_JavaLangString))) {
        break label1753;
      }
      localObject1 = alud.a(2131700694);
    }
    label300:
    label455:
    label587:
    label600:
    label1753:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      label224:
      label376:
      int m;
      if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() == 3)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject2 = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(2);
        if (localObject2 != null)
        {
          if (!TextUtils.isEmpty(((alet)localObject2).jdField_a_of_type_JavaLangString))
          {
            localObject3 = aldt.a(Utils.Crc64String(((alet)localObject2).jdField_a_of_type_JavaLangString), null, ((alet)localObject2).jdField_a_of_type_JavaLangString);
            this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          }
          if (((alet)localObject2).jdField_a_of_type_Int == 7) {
            this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-31676);
          }
        }
        else
        {
          localObject2 = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1);
          if (localObject2 != null)
          {
            if (!TextUtils.isEmpty(((alet)localObject2).jdField_a_of_type_JavaLangString))
            {
              localObject3 = aldt.a(Utils.Crc64String(((alet)localObject2).jdField_a_of_type_JavaLangString), null, ((alet)localObject2).jdField_a_of_type_JavaLangString);
              this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            }
            if (((alet)localObject2).jdField_a_of_type_Int != 7) {
              break label587;
            }
            this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-31676);
          }
          localObject2 = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0);
          if (localObject2 != null)
          {
            if (!TextUtils.isEmpty(((alet)localObject2).jdField_a_of_type_JavaLangString))
            {
              localObject3 = aldt.a(Utils.Crc64String(((alet)localObject2).jdField_a_of_type_JavaLangString), null, ((alet)localObject2).jdField_a_of_type_JavaLangString);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            }
            if (((alet)localObject2).jdField_a_of_type_Int != 7) {
              break label600;
            }
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-31676);
          }
          if (this.jdField_a_of_type_Aler.jdField_a_of_type_Int != -1) {
            super.setBackgroundColor(this.jdField_a_of_type_Aler.jdField_a_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.removeAllViews();
          if ((this.jdField_a_of_type_Aler.jdField_b_of_type_Long == 0L) && (this.jdField_a_of_type_Aler.jdField_a_of_type_Long != -501031L) && (this.jdField_a_of_type_Aler.jdField_a_of_type_Long != -501027L)) {
            break label1243;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
          m = 0;
          if (m >= this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList.size()) {
            break label1020;
          }
          if (this.jdField_a_of_type_JavaUtilList.size() <= m) {
            break label1748;
          }
          localObject1 = (ApolloCardLayout)this.jdField_a_of_type_JavaUtilList.get(m);
          ((ApolloCardLayout)localObject1).clearAnimation();
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new ApolloCardLayout(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        localObject1 = new FrameLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        m += 1;
        break label455;
        localObject1 = this.jdField_a_of_type_Aler.jdField_c_of_type_JavaLangString;
        break label50;
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        break label224;
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        break label300;
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        break label376;
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() == 2)
        {
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          localObject2 = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1);
          if (localObject2 != null)
          {
            if (!TextUtils.isEmpty(((alet)localObject2).jdField_a_of_type_JavaLangString))
            {
              localObject3 = aldt.a(Utils.Crc64String(((alet)localObject2).jdField_a_of_type_JavaLangString), null, ((alet)localObject2).jdField_a_of_type_JavaLangString);
              this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            }
            if (((alet)localObject2).jdField_a_of_type_Int != 7) {
              break label834;
            }
            this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-31676);
          }
          for (;;)
          {
            localObject2 = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0);
            if (localObject2 == null) {
              break;
            }
            if (!TextUtils.isEmpty(((alet)localObject2).jdField_a_of_type_JavaLangString))
            {
              localObject3 = aldt.a(Utils.Crc64String(((alet)localObject2).jdField_a_of_type_JavaLangString), null, ((alet)localObject2).jdField_a_of_type_JavaLangString);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            }
            if (((alet)localObject2).jdField_a_of_type_Int != 7) {
              break label847;
            }
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-31676);
            break;
            this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          break label376;
        }
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() != 1) {
          break label376;
        }
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject2 = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0);
        if (localObject2 == null) {
          break label376;
        }
        if (!TextUtils.isEmpty(((alet)localObject2).jdField_a_of_type_JavaLangString))
        {
          localObject3 = aldt.a(Utils.Crc64String(((alet)localObject2).jdField_a_of_type_JavaLangString), null, ((alet)localObject2).jdField_a_of_type_JavaLangString);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
        }
        if (((alet)localObject2).jdField_a_of_type_Int == 7)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-31676);
          break label376;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        break label376;
        label1020:
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.jdField_c_of_type_Int, this.jdField_f_of_type_Int, this.jdField_a_of_type_Aler);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setCurrentFrame(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.requestLayout();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(aler.c(((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_Int));
        }
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 1) {
          this.jdField_h_of_type_AndroidWidgetTextView.setText(aler.b(((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1)).jdField_b_of_type_Int));
        }
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 2) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(aler.a(((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(2)).jdField_b_of_type_Int));
        }
        if ((this.jdField_a_of_type_Aler.jdField_b_of_type_Long != -501027L) && (this.jdField_a_of_type_Long != -501027L)) {
          break;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        label1243:
        AbstractGifImage.pauseAll();
        this.jdField_e_of_type_AndroidWidgetTextView.setText(alud.a(2131700691) + (String)localObject1 + alud.a(2131700692));
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(0);
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(aler.c(((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_Int - ((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0)).jdField_c_of_type_Int));
        }
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 1) {
          this.jdField_h_of_type_AndroidWidgetTextView.setText(aler.b(((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1)).jdField_b_of_type_Int - ((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1)).jdField_c_of_type_Int));
        }
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 2) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(aler.a(((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(2)).jdField_b_of_type_Int - ((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(2)).jdField_c_of_type_Int));
        }
        if ((this.jdField_a_of_type_Aler.jdField_b_of_type_Long == -501027L) || (this.jdField_a_of_type_Long == -501027L)) {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        localObject3 = new ArrayList();
        m = 0;
        if (m < this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList.size())
        {
          if (this.jdField_a_of_type_JavaUtilList.size() <= m) {
            break label1743;
          }
          localObject1 = (ApolloCardLayout)this.jdField_a_of_type_JavaUtilList.get(m);
          ((ApolloCardLayout)localObject1).clearAnimation();
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new ApolloCardLayout(this.jdField_a_of_type_AndroidContentContext);
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
          ((List)localObject3).add(localObject2);
          localObject1 = (ales)this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList.get(m);
          if ((localObject1 != null) && (((ales)localObject1).jdField_a_of_type_Short == 15)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C002", this.jdField_a_of_type_Int, 0, new String[0]);
          }
          m += 1;
          break;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList, (List)localObject3, this.j, this.k - this.jdField_h_of_type_Int, super.getWidth(), super.getHeight());
          this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(256, 600);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.a();
          return;
          localObject1 = null;
        }
        localObject1 = null;
      }
    }
  }
  
  private void f()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localScaleAnimation1.setDuration(100L);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.0F, 0.6666667F, 1.0F, 0.6666667F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation2.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setStartOffset(100L);
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  public Drawable a(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    paramString.setDensity(getContext().getResources().getDisplayMetrics().densityDpi);
    return new BitmapDrawable(getContext().getResources(), paramString);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(false);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(false);
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(150L);
    }
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    alfc localalfc = new alfc(0, 0, 0, -ApolloUtil.a(144.0F, jdField_b_of_type_Float), -(ApolloUtil.a(195.0F, jdField_b_of_type_Float) - paramInt), -ApolloUtil.a(164.0F, jdField_b_of_type_Float));
    localalfc.setDuration(500L);
    localalfc.setStartOffset(250L);
    localalfc.setInterpolator(new AccelerateDecelerateInterpolator());
    if (this.jdField_b_of_type_AndroidViewAnimationScaleAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F);
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setStartOffset(250L);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localalfc);
    if (this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setStartOffset(250L);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_f_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloCardWindow", 2, "onOpenStep drawStep:" + paramInt1);
    }
    if (super.getVisibility() != 0) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Aler == null);
        if (4 != paramInt1) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.b();
      } while ((this.jdField_a_of_type_Aler.jdField_b_of_type_Long != -501027L) && (this.jdField_a_of_type_Long != -501027L));
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    } while (10 != paramInt1);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.getVisibility() != 0)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
      if ((this.jdField_a_of_type_Aler.jdField_b_of_type_Long == -501027L) || (this.jdField_a_of_type_Long == -501027L)) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.jdField_c_of_type_Int, this.jdField_f_of_type_Int, this.jdField_a_of_type_Aler);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setCurrentFrame(0);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(4);
    this.jdField_c_of_type_Boolean = true;
    AbstractGifImage.resumeAll();
  }
  
  public void a(View paramView, String paramString1, String paramString2, AppInterface paramAppInterface, alew paramalew)
  {
    if ((paramView == null) || (paramAppInterface == null) || (paramString1 == null)) {
      return;
    }
    this.jdField_a_of_type_Alew = paramalew;
    super.setVisibility(4);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_f_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(4);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(4);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_Bhtd.sendEmptyMessage(258);
      this.jdField_a_of_type_Bhtd.removeMessages(264);
      this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(264, 1000L);
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Bhtd.removeMessages(264);
      this.jdField_a_of_type_Bhtd.sendEmptyMessage(264);
      this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(258, 500L);
    }
  }
  
  void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Object localObject = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    ((ScaleAnimation)localObject).setStartOffset(paramInt);
    if (paramImageView1 != null) {
      paramImageView1.startAnimation((Animation)localObject);
    }
    paramImageView1 = new AnimationSet(false);
    localObject = new ScaleAnimation(1.0F, 4.0F, 1.0F, 4.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    paramImageView1.addAnimation((Animation)localObject);
    new AlphaAnimation(0.0F, 1.0F).setDuration(75L);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(150L);
    paramImageView1.addAnimation((Animation)localObject);
    paramImageView1.setStartOffset(paramInt);
    paramImageView1.setFillAfter(true);
    if (paramImageView2 != null) {
      paramImageView2.startAnimation(paramImageView1);
    }
  }
  
  void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 <= paramInt1) {
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setObjectValues(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.addUpdateListener(new aleu(this, paramTextView));
    localValueAnimator.setStartDelay(paramInt4);
    localValueAnimator.start();
  }
  
  void a(File paramFile, String paramString)
  {
    if (this.jdField_a_of_type_Beaj == null) {
      return;
    }
    beae localbeae = new beae(paramString, paramFile);
    localbeae.p = true;
    localbeae.j = false;
    localbeae.n = true;
    localbeae.s = false;
    localbeae.q = true;
    localbeae.r = true;
    localbeae.jdField_b_of_type_Boolean = true;
    localbeae.jdField_f_of_type_JavaLangString = "apollo_res";
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramFile.getPath());
    localBundle.putString("url", paramString);
    this.jdField_a_of_type_Beaj.a(localbeae, this.jdField_a_of_type_Bead, null);
  }
  
  public void a(String paramString1, boolean paramBoolean, long paramLong, Object paramObject, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloCardWindow", 2, "cmd:" + paramString1 + " isSuccess:" + paramBoolean + " uin:" + paramString2 + " retCode:" + paramLong + " data:" + paramObject);
    }
    if (super.getVisibility() == 8) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloCardWindow", 2, "onResult + super.getVisibility() not VISIBLE");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (this.jdField_c_of_type_JavaLangString.equals(paramString2))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ApolloCardWindow", 2, "mBoxUin:" + this.jdField_c_of_type_JavaLangString + "notEqual uin:" + paramString2 + " return!");
        return;
        if (!"apollo_core.get_user_info".equals(paramString1)) {
          break;
        }
      } while ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!this.jdField_c_of_type_JavaLangString.equals(paramString2)));
      paramString1 = this.jdField_a_of_type_Bhtd.obtainMessage(257);
      paramString1.obj = paramObject;
      paramString1.sendToTarget();
      return;
      if ("apollo_interact.thank_zan".equals(paramString1))
      {
        if ((paramLong != 0L) || (!paramBoolean))
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Bhtd.obtainMessage(261).sendToTarget();
          return;
        }
        this.jdField_a_of_type_Bhtd.obtainMessage(262).sendToTarget();
        return;
      }
    } while (!"apollo_interact.take_chips".equals(paramString1));
    this.jdField_a_of_type_Bhtd.removeMessages(258);
    if ((paramObject instanceof aler)) {
      this.jdField_a_of_type_Aler = ((aler)paramObject);
    }
    this.jdField_a_of_type_Long = paramLong;
    if ((this.jdField_a_of_type_Aler != null) && ((this.jdField_a_of_type_Long == -501030L) || (this.jdField_a_of_type_Aler.jdField_b_of_type_Long == -501030L)))
    {
      if (this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      paramString1 = new ales();
      paramString1.jdField_g_of_type_Int = 1;
      this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList.add(0, paramString1);
    }
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long == -501030L) || (this.jdField_a_of_type_Long == -501027L) || (this.jdField_a_of_type_Long == -501040L) || (this.jdField_a_of_type_Long == -501031L))
      {
        this.jdField_a_of_type_Bhtd.obtainMessage(260).sendToTarget();
        return;
      }
      if (this.jdField_a_of_type_Long == -501028L)
      {
        this.jdField_e_of_type_JavaLangString = jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_Bhtd.obtainMessage(259).sendToTarget();
        return;
      }
      this.jdField_e_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bhtd.obtainMessage(259).sendToTarget();
      return;
    }
    this.jdField_e_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Bhtd.obtainMessage(259).sendToTarget();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_Alew != null)) {
      this.jdField_a_of_type_Alew.a(this.jdField_c_of_type_JavaLangString);
    }
    super.setVisibility(8);
    this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(paramBoolean);
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.clearAnimation();
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    }
    if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
      this.jdField_h_of_type_AndroidWidgetTextView.clearAnimation();
    }
    if (this.jdField_f_of_type_AndroidWidgetImageView != null) {
      this.jdField_f_of_type_AndroidWidgetImageView.clearAnimation();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.b();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Alex.a();
    }
  }
  
  void c()
  {
    Object localObject1;
    Object localObject3;
    File localFile1;
    File localFile2;
    if ((this.jdField_a_of_type_Aler != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aler.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aler.jdField_d_of_type_JavaLangString)))
    {
      localObject1 = bflr.d(this.jdField_a_of_type_Aler.jdField_d_of_type_JavaLangString);
      localObject3 = bflr.d(this.jdField_a_of_type_Aler.jdField_e_of_type_JavaLangString);
      localFile1 = new File(aliu.k + (String)localObject1 + ".cache");
      localFile2 = new File(aliu.k + (String)localObject3 + ".cache");
      if ((!localFile1.exists()) || (!localFile2.exists())) {}
    }
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      if (jdField_a_of_type_JavaUtilMap.containsKey(localObject1)) {}
      for (localObject1 = (Drawable)jdField_a_of_type_JavaUtilMap.get(localObject1); jdField_a_of_type_JavaUtilMap.containsKey(localObject3); localObject1 = null)
      {
        localObject3 = (Drawable)jdField_a_of_type_JavaUtilMap.get(localObject3);
        if ((localObject1 != null) && (localObject3 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setDrawables((Drawable)localObject1, (Drawable)localObject3, null);
        }
        if (!localFile1.exists()) {
          a(localFile1, this.jdField_a_of_type_Aler.jdField_d_of_type_JavaLangString);
        }
        if (!localFile2.exists()) {
          a(localFile2, this.jdField_a_of_type_Aler.jdField_e_of_type_JavaLangString);
        }
        return;
      }
      localObject3 = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Object localObject;
    float f1;
    label629:
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            switch (paramMessage.what)
            {
            default: 
              return false;
            }
          } while (this.jdField_a_of_type_Aler == null);
          if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0);
            if ((paramMessage != null) && (paramMessage.jdField_c_of_type_Int > 0))
            {
              this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_f_of_type_AndroidWidgetTextView.setText("+" + paramMessage.jdField_c_of_type_Int);
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130838346);
              localObject = aldt.a("apollo_card_first_image.png", (URLDrawable.URLDrawableOptions)localObject, paramMessage.jdField_a_of_type_JavaLangString);
              m = ApolloUtil.a(25.0F / jdField_a_of_type_Float, jdField_b_of_type_Float);
              ((URLDrawable)localObject).setBounds(0, 0, (int)(m * 0.8F), m);
              this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
              a(0);
              this.jdField_c_of_type_AndroidWidgetTextView.setText(aler.c(paramMessage.jdField_b_of_type_Int - paramMessage.jdField_c_of_type_Int));
              a(this.jdField_c_of_type_AndroidWidgetTextView, paramMessage.jdField_b_of_type_Int - paramMessage.jdField_c_of_type_Int, paramMessage.jdField_b_of_type_Int, 200, 650);
              if (this.jdField_c_of_type_AndroidWidgetImageView == null)
              {
                this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                this.jdField_c_of_type_AndroidWidgetImageView.setId(2131365532);
                this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                paramMessage = new RelativeLayout.LayoutParams(ApolloUtil.a(15.0F, jdField_b_of_type_Float), ApolloUtil.a(15.0F, jdField_b_of_type_Float));
                paramMessage.leftMargin = ApolloUtil.a(12.0F, jdField_b_of_type_Float);
                paramMessage.topMargin = (((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.getLayoutParams()).topMargin + ApolloUtil.a(7.5F, jdField_b_of_type_Float));
                super.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramMessage);
              }
              this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
              a(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, 650);
              this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(266, 650L);
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("ApolloCardWindow", 2, "MSG_CODE_ADD_CARD:");
        return false;
        this.jdField_a_of_type_Alex.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        return false;
      } while (this.jdField_a_of_type_Aler == null);
      return false;
      super.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return false;
      super.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return false;
      if (this.jdField_a_of_type_Aler != null)
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramMessage = this.jdField_d_of_type_AndroidWidgetImageView;
          if (!this.jdField_a_of_type_Aler.jdField_a_of_type_Boolean) {
            break label686;
          }
          f1 = 1.0F;
          paramMessage.setAlpha(f1);
        }
        paramMessage = this.jdField_d_of_type_AndroidWidgetTextView;
        if (!this.jdField_a_of_type_Aler.jdField_a_of_type_Boolean) {
          break label693;
        }
      }
      for (m = -1;; m = -2130706433)
      {
        paramMessage.setTextColor(m);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131700693), 0).a();
        return false;
        f1 = 0.5F;
        break label629;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.5F);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-2130706433);
    } while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0);
    label686:
    label693:
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131700688), 0).a();
    return false;
    super.setVisibility(0);
    c();
    if (this.jdField_a_of_type_Aler == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(4);
      return false;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!"drawer".equals(this.jdField_f_of_type_JavaLangString)) {
        break label1101;
      }
      this.jdField_a_of_type_Int = 0;
      label890:
      if ((this.jdField_a_of_type_Aler.jdField_b_of_type_Long == 0L) && (this.jdField_a_of_type_Aler.jdField_a_of_type_Long != -501031L)) {
        break label1168;
      }
      if (this.jdField_a_of_type_Aler.jdField_b_of_type_Int <= 0) {
        break label1138;
      }
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Aler.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_Aler.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Aler.jdField_b_of_type_JavaLangString))) {
        break label1130;
      }
      this.jdField_b_of_type_Int = 1;
    }
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "openfloatagain", this.jdField_a_of_type_Int, 0, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
      label996:
      e();
      return false;
      if (this.jdField_a_of_type_Aler.jdField_b_of_type_Int > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramMessage = this.jdField_d_of_type_AndroidWidgetImageView;
          if (this.jdField_a_of_type_Aler.jdField_a_of_type_Boolean)
          {
            f1 = 1.0F;
            label1045:
            paramMessage.setAlpha(f1);
          }
        }
        else
        {
          paramMessage = this.jdField_d_of_type_AndroidWidgetTextView;
          if (!this.jdField_a_of_type_Aler.jdField_a_of_type_Boolean) {
            break label1082;
          }
        }
        label1082:
        for (m = -1;; m = -2130706433)
        {
          paramMessage.setTextColor(m);
          break;
          f1 = 0.5F;
          break label1045;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
      break;
      label1101:
      if ("friendcard".equals(this.jdField_f_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Int = 1;
        break label890;
      }
      this.jdField_a_of_type_Int = 2;
      break label890;
      label1130:
      this.jdField_b_of_type_Int = 2;
      continue;
      label1138:
      if (this.jdField_a_of_type_Aler.jdField_b_of_type_Long == -501030L) {
        this.jdField_b_of_type_Int = 3;
      } else {
        this.jdField_b_of_type_Int = 4;
      }
    }
    label1168:
    if (this.jdField_a_of_type_Aler.jdField_b_of_type_Int > 0) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aler.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Aler.jdField_b_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_Int = 1;
        paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
        if ((paramMessage != null) && (paramMessage.jdField_c_of_type_Int > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C2", this.jdField_a_of_type_Int, 0, new String[] { "", String.valueOf(paramMessage.jdField_c_of_type_Int), "" });
        }
        paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(7));
        if ((paramMessage != null) && (paramMessage.jdField_c_of_type_Int > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C04", this.jdField_a_of_type_Int, 0, new String[] { "", String.valueOf(paramMessage.jdField_c_of_type_Int), "" });
        }
        paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(15));
        if ((paramMessage != null) && (paramMessage.jdField_c_of_type_Int > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C06", this.jdField_a_of_type_Int, 0, new String[] { "", String.valueOf(paramMessage.jdField_c_of_type_Int), "" });
        }
      }
    }
    for (int m = 0;; m = 1)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C1", this.jdField_a_of_type_Int, 0, new String[] { String.valueOf(m), String.valueOf(this.jdField_a_of_type_Aler.jdField_b_of_type_Int) });
      break label996;
      this.jdField_b_of_type_Int = 2;
      if ((this.jdField_a_of_type_Aler.jdField_c_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_Aler.jdField_c_of_type_JavaUtilList.isEmpty()))
      {
        paramMessage = this.jdField_a_of_type_Aler.jdField_c_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (paramMessage.hasNext())
          {
            localObject = (ales)paramMessage.next();
            alet localalet = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
            if ((localalet != null) && (localalet.jdField_c_of_type_Int > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.jdField_a_of_type_Int, 0, new String[] { String.valueOf(((ales)localObject).jdField_a_of_type_Int), String.valueOf(0), String.valueOf(((ales)localObject).jdField_a_of_type_Short) });
            }
            localObject = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(7));
            if ((localObject != null) && (((alet)localObject).jdField_c_of_type_Int > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.jdField_a_of_type_Int, 0, new String[] { "0", String.valueOf(0), "4" });
            }
            localObject = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(15));
            if ((localObject != null) && (((alet)localObject).jdField_c_of_type_Int > 0))
            {
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.jdField_a_of_type_Int, 0, new String[] { "0", String.valueOf(0), "5" });
              continue;
              if (this.jdField_a_of_type_Aler.jdField_a_of_type_Long == -501030L)
              {
                this.jdField_b_of_type_Int = 3;
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C4", this.jdField_a_of_type_Int, 0, new String[] { "0", "0", "1" });
                break label996;
              }
              this.jdField_b_of_type_Int = 4;
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C5", this.jdField_a_of_type_Int, 0, new String[0]);
              break label996;
              if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String)) || (TextUtils.isEmpty((String)paramMessage.obj))) {
                break;
              }
              paramMessage = URLDrawable.URLDrawableOptions.obtain();
              paramMessage.mLoadingDrawable = bdhj.b();
              paramMessage.mFailedDrawable = paramMessage.mLoadingDrawable;
              localObject = new aldu();
              ((aldu)localObject).jdField_a_of_type_Int = aldt.jdField_a_of_type_Int;
              paramMessage.mExtraInfo = localObject;
              return false;
              if ((this.jdField_a_of_type_Aler == null) || (this.jdField_a_of_type_Aler.jdField_b_of_type_JavaUtilList == null)) {
                break;
              }
              m = this.jdField_c_of_type_Int / 2;
              int n = this.jdField_d_of_type_Int;
              int i1 = this.jdField_e_of_type_Int;
              int i2 = this.jdField_f_of_type_Int / 2;
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(m + n + i1, this.jdField_c_of_type_Int + this.jdField_d_of_type_Int, i2);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloCardWindow", 2, "MSG_CODE_CARD_TO_NORMAL");
              }
              if (this.jdField_a_of_type_Aler == null) {
                break;
              }
              if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 0)
              {
                paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0);
                if ((paramMessage != null) && (paramMessage.jdField_a_of_type_Boolean) && (paramMessage.jdField_c_of_type_Int > 0))
                {
                  this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(255, 500L);
                  n = 650;
                  m = 650;
                }
              }
              for (;;)
              {
                i1 = m;
                if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 1)
                {
                  paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1);
                  i1 = m;
                  if (paramMessage != null)
                  {
                    i1 = m;
                    if (paramMessage.jdField_a_of_type_Boolean)
                    {
                      i1 = m;
                      if (paramMessage.jdField_c_of_type_Int > 0)
                      {
                        this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(265, n + 500);
                        i1 = m + 150 + 500;
                      }
                    }
                  }
                }
                if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() <= 2) {
                  break;
                }
                paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(2);
                if ((paramMessage == null) || (!paramMessage.jdField_a_of_type_Boolean) || (paramMessage.jdField_c_of_type_Int <= 0)) {
                  break;
                }
                this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(268, i1 + 500);
                return false;
                if (this.jdField_a_of_type_Aler == null) {
                  break;
                }
                if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 1)
                {
                  paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1);
                  if ((paramMessage != null) && (paramMessage.jdField_c_of_type_Int > 0))
                  {
                    this.jdField_f_of_type_AndroidWidgetTextView.setText("+" + paramMessage.jdField_c_of_type_Int);
                    localObject = URLDrawable.URLDrawableOptions.obtain();
                    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130838347);
                    localObject = aldt.a("apollo_card_first_image.png", (URLDrawable.URLDrawableOptions)localObject, paramMessage.jdField_a_of_type_JavaLangString);
                    m = ApolloUtil.a(25.0F / jdField_a_of_type_Float, jdField_b_of_type_Float);
                    ((URLDrawable)localObject).setBounds(0, 0, m, m);
                    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
                    a(this.jdField_c_of_type_AndroidWidgetTextView.getWidth() + this.jdField_f_of_type_AndroidWidgetImageView.getWidth() + ApolloUtil.a(28.0F, jdField_b_of_type_Float));
                    this.jdField_h_of_type_AndroidWidgetTextView.setText(aler.b(paramMessage.jdField_b_of_type_Int - paramMessage.jdField_c_of_type_Int));
                    a(this.jdField_h_of_type_AndroidWidgetTextView, paramMessage.jdField_b_of_type_Int - paramMessage.jdField_c_of_type_Int, paramMessage.jdField_b_of_type_Int, 200, 650);
                    if (this.jdField_g_of_type_AndroidWidgetImageView == null)
                    {
                      this.jdField_g_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                      this.jdField_g_of_type_AndroidWidgetImageView.setId(2131374006);
                      this.jdField_g_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                      paramMessage = new RelativeLayout.LayoutParams(ApolloUtil.a(15.0F, jdField_b_of_type_Float), ApolloUtil.a(15.0F, jdField_b_of_type_Float));
                      paramMessage.leftMargin = (ApolloUtil.a(47.0F, jdField_b_of_type_Float) + this.jdField_c_of_type_AndroidWidgetTextView.getWidth());
                      paramMessage.topMargin = (((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.getLayoutParams()).topMargin + ApolloUtil.a(7.5F, jdField_b_of_type_Float));
                      super.addView(this.jdField_g_of_type_AndroidWidgetImageView, paramMessage);
                    }
                    this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable(null);
                    a(this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_g_of_type_AndroidWidgetImageView, 650);
                    this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(267, 650L);
                  }
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloCardWindow", 2, "MSG_CODE_ADD_GOLD:");
                return false;
                if (this.jdField_a_of_type_Aler == null) {
                  break;
                }
                if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 2)
                {
                  paramMessage = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(2);
                  if ((paramMessage != null) && (paramMessage.jdField_c_of_type_Int > 0))
                  {
                    this.jdField_f_of_type_AndroidWidgetTextView.setText("+" + paramMessage.jdField_c_of_type_Int);
                    localObject = aldt.a("apollo_card_props_image.png", null, paramMessage.jdField_a_of_type_JavaLangString);
                    m = ApolloUtil.a(25.0F / jdField_a_of_type_Float, jdField_b_of_type_Float);
                    ((URLDrawable)localObject).setBounds(0, 0, m, m);
                    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
                    a(ApolloUtil.a(125.0F, jdField_b_of_type_Float) + this.jdField_c_of_type_AndroidWidgetTextView.getWidth() + this.jdField_h_of_type_AndroidWidgetTextView.getWidth());
                    this.jdField_i_of_type_AndroidWidgetTextView.setText(aler.a(paramMessage.jdField_b_of_type_Int - paramMessage.jdField_c_of_type_Int));
                    a(this.jdField_i_of_type_AndroidWidgetTextView, paramMessage.jdField_b_of_type_Int - paramMessage.jdField_c_of_type_Int, paramMessage.jdField_b_of_type_Int, 200, 650);
                    if (this.jdField_i_of_type_AndroidWidgetImageView == null)
                    {
                      this.jdField_i_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                      this.jdField_i_of_type_AndroidWidgetImageView.setId(2131374006);
                      this.jdField_i_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                      paramMessage = new RelativeLayout.LayoutParams(ApolloUtil.a(15.0F, jdField_b_of_type_Float), ApolloUtil.a(15.0F, jdField_b_of_type_Float));
                      paramMessage.leftMargin = (ApolloUtil.a(82.0F, jdField_b_of_type_Float) + this.jdField_c_of_type_AndroidWidgetTextView.getWidth() + this.jdField_h_of_type_AndroidWidgetTextView.getWidth());
                      paramMessage.topMargin = (((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.getLayoutParams()).topMargin + ApolloUtil.a(7.5F, jdField_b_of_type_Float));
                      super.addView(this.jdField_i_of_type_AndroidWidgetImageView, paramMessage);
                    }
                    a(this.jdField_h_of_type_AndroidWidgetImageView, this.jdField_i_of_type_AndroidWidgetImageView, 650);
                    this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(269, 650L);
                  }
                }
                this.jdField_i_of_type_AndroidWidgetImageView.setImageDrawable(null);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloCardWindow", 2, "MSG_CODE_ADD_GOLD:");
                return false;
                if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
                  break;
                }
                this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838349);
                return false;
                if (this.jdField_g_of_type_AndroidWidgetImageView == null) {
                  break;
                }
                this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130838349);
                return false;
                if (this.jdField_i_of_type_AndroidWidgetImageView == null) {
                  break;
                }
                this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130838349);
                return false;
                m = 0;
                n = 0;
              }
            }
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C8", this.jdField_a_of_type_Int, 0, new String[0]);
      a(false);
    }
    label642:
    do
    {
      do
      {
        Object localObject1;
        do
        {
          Object localObject2;
          do
          {
            do
            {
              return;
              if ((paramView != this.jdField_c_of_type_AndroidWidgetTextView) && (paramView != this.jdField_b_of_type_AndroidWidgetImageView)) {
                break;
              }
            } while ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Aler == null));
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            localObject1 = aliu.aa + "&adtag=floatlayer";
            paramView = (View)localObject1;
            if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              alet localalet = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0);
              paramView = (View)localObject1;
              if (!TextUtils.isEmpty(localalet.jdField_b_of_type_JavaLangString)) {
                paramView = localalet.jdField_b_of_type_JavaLangString;
              }
            }
            ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_zf_lmx");
            VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_AndroidContentContext, paramView, -1L, (Intent)localObject2, false, -1);
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C01", this.jdField_a_of_type_Int, 0, new String[0]);
            a(false);
            return;
            if ((paramView != this.jdField_f_of_type_AndroidWidgetImageView) && (paramView != this.jdField_h_of_type_AndroidWidgetTextView)) {
              break;
            }
          } while (this.jdField_a_of_type_Aler == null);
          localObject1 = aliu.Z + "&adtag=floatlayer";
          paramView = (View)localObject1;
          if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 1)
          {
            localObject2 = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1);
            paramView = (View)localObject1;
            if (!TextUtils.isEmpty(((alet)localObject2).jdField_b_of_type_JavaLangString)) {
              paramView = ((alet)localObject2).jdField_b_of_type_JavaLangString;
            }
          }
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_AndroidContentContext, paramView, -1L, (Intent)localObject1, false, -1);
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C03", this.jdField_a_of_type_Int, 0, new String[0]);
          a(false);
          return;
          if ((paramView != this.jdField_h_of_type_AndroidWidgetImageView) && (paramView != this.jdField_i_of_type_AndroidWidgetTextView)) {
            break;
          }
        } while (this.jdField_a_of_type_Aler == null);
        if (this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 2)
        {
          paramView = (alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(2);
          if (!TextUtils.isEmpty(paramView.jdField_b_of_type_JavaLangString))
          {
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
            VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_AndroidContentContext, paramView.jdField_b_of_type_JavaLangString, -1L, (Intent)localObject1, false, -1);
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C001", this.jdField_a_of_type_Int, 0, new String[0]);
          }
        }
        a(false);
        return;
        if (paramView != this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout) {
          break;
        }
      } while ((this.jdField_a_of_type_Aler == null) || (!this.jdField_c_of_type_Boolean));
      if ((this.jdField_a_of_type_Aler.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        if (bdin.g(this.jdField_a_of_type_AndroidContentContext))
        {
          if (Build.VERSION.SDK_INT >= 11) {
            this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.5F);
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-2130706433);
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_Alex.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aler.jdField_c_of_type_Long, (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_f_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
          f();
        }
      }
      for (int m = 1;; m = 2)
      {
        if ((this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 2) && (((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(2)).jdField_c_of_type_Int > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "sendflower", m, 0, new String[] { "3" });
        }
        if ((this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() > 1) && (((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(1)).jdField_c_of_type_Int > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "sendflower", m, 0, new String[] { "2" });
        }
        if ((this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.size() <= 0) || (((alet)this.jdField_a_of_type_Aler.jdField_a_of_type_JavaUtilList.get(0)).jdField_c_of_type_Int <= 0)) {
          break;
        }
        VipUtils.a(null, "cmshow", "Apollo", "sendflower", m, 0, new String[] { "1" });
        return;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131700696), 0).a();
        break label642;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131700686), 0).a();
      }
    } while ((this != paramView) || (!this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean));
    VipUtils.a(null, "cmshow", "Apollo", "clickblackfloat", this.jdField_a_of_type_Int, 0, new String[0]);
    a(false);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (m)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_c_of_type_Float = f1;
      this.jdField_d_of_type_Float = f2;
      this.jdField_e_of_type_Boolean = false;
      continue;
      if (Math.hypot(Math.abs(this.jdField_c_of_type_Float - f1), Math.abs(this.jdField_d_of_type_Float - f2)) > this.jdField_i_of_type_Int)
      {
        this.jdField_e_of_type_Boolean = true;
        continue;
        if (Math.hypot(Math.abs(this.jdField_c_of_type_Float - f1), Math.abs(this.jdField_d_of_type_Float - f2)) > this.jdField_i_of_type_Int) {
          this.jdField_e_of_type_Boolean = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow
 * JD-Core Version:    0.7.0.1
 */