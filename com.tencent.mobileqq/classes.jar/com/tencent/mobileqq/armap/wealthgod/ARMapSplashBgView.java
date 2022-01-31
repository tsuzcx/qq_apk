package com.tencent.mobileqq.armap.wealthgod;

import abpn;
import abpo;
import abpp;
import abpq;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ARMapSplashBgView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 0;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ARMapFlakeView a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private ImageView f;
  private ImageView g;
  
  public ARMapSplashBgView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ARMapSplashBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ARMapSplashBgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130970249, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  private void c()
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369770));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369772));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369773));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369775));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369776));
    this.f = ((ImageView)findViewById(2131369774));
    this.g = ((ImageView)findViewById(2131369777));
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView = ((ARMapFlakeView)findViewById(2131369771));
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView.setDataType(100);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView.setVisibility(8);
    this.jdField_b_of_type_Int = localResources.getDimensionPixelSize(2131560255);
    this.jdField_c_of_type_Int = localResources.getInteger(2131689486);
    this.jdField_d_of_type_Int = localResources.getDimensionPixelSize(2131560259);
    this.jdField_e_of_type_Int = localResources.getInteger(2131689487);
  }
  
  private void d()
  {
    e();
    f();
  }
  
  @TargetApi(11)
  private void e()
  {
    long l2 = 2000L;
    ValueAnimator localValueAnimator1;
    ValueAnimator localValueAnimator2;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null)
    {
      localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F });
      if (this.jdField_a_of_type_Int != 1) {
        break label179;
      }
      l1 = 1000L;
      localValueAnimator1.setDuration(l1);
      localValueAnimator1.setRepeatMode(1);
      localValueAnimator1.setRepeatCount(-1);
      localValueAnimator1.addUpdateListener(new abpn(this));
      localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, -1.0F, 0.0F, 1.0F, 0.0F });
      if (this.jdField_a_of_type_Int != 1) {
        break label186;
      }
    }
    label179:
    label186:
    for (long l1 = l2;; l1 = 4000L)
    {
      localValueAnimator2.setDuration(l1);
      localValueAnimator2.setRepeatMode(1);
      localValueAnimator2.setRepeatCount(-1);
      localValueAnimator2.addUpdateListener(new abpo(this));
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      return;
      l1 = 2000L;
      break;
    }
  }
  
  @TargetApi(11)
  private void f()
  {
    long l2 = 2000L;
    ValueAnimator localValueAnimator1;
    ValueAnimator localValueAnimator2;
    if (this.jdField_b_of_type_AndroidAnimationAnimatorSet == null)
    {
      localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F });
      if (this.jdField_a_of_type_Int != 1) {
        break label179;
      }
      l1 = 1000L;
      localValueAnimator1.setDuration(l1);
      localValueAnimator1.setRepeatMode(1);
      localValueAnimator1.setRepeatCount(-1);
      localValueAnimator1.addUpdateListener(new abpp(this));
      localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F, -1.0F, 0.0F });
      if (this.jdField_a_of_type_Int != 1) {
        break label186;
      }
    }
    label179:
    label186:
    for (long l1 = l2;; l1 = 4000L)
    {
      localValueAnimator2.setDuration(l1);
      localValueAnimator2.setRepeatMode(1);
      localValueAnimator2.setRepeatCount(-1);
      localValueAnimator2.addUpdateListener(new abpq(this));
      this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      return;
      l1 = 2000L;
      break;
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.start();
    }
  }
  
  @TargetApi(11)
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = this.jdField_a_of_type_AndroidWidgetImageView.getLeft();
    paramInt3 = this.jdField_a_of_type_AndroidWidgetImageView.getRight();
    int i = (int)(paramInt1 * 0.6F);
    this.jdField_a_of_type_AndroidWidgetImageView.layout(paramInt2, 0, paramInt3, i + 0);
    paramInt2 = this.jdField_d_of_type_AndroidWidgetImageView.getLeft();
    paramInt3 = this.jdField_d_of_type_AndroidWidgetImageView.getRight();
    i = (int)(paramInt1 * 0.38F);
    int j = this.jdField_d_of_type_AndroidWidgetImageView.getHeight();
    this.jdField_d_of_type_AndroidWidgetImageView.layout(paramInt2, i, paramInt3, j + i);
    paramInt2 = this.jdField_e_of_type_AndroidWidgetImageView.getLeft();
    paramInt3 = this.jdField_e_of_type_AndroidWidgetImageView.getRight();
    i = (int)(paramInt1 * 0.4F);
    j = this.jdField_e_of_type_AndroidWidgetImageView.getHeight();
    this.jdField_e_of_type_AndroidWidgetImageView.layout(paramInt2, i, paramInt3, j + i);
    paramInt2 = this.f.getLeft();
    paramInt3 = this.f.getRight();
    i = (int)(paramInt1 * 0.3F);
    j = (int)(paramInt1 * 0.55F);
    this.f.layout(paramInt2, i, paramInt3, j);
    paramInt2 = this.g.getLeft();
    paramInt3 = this.g.getRight();
    paramInt1 = (int)(paramInt1 * 0.4F);
    this.g.layout(paramInt2, paramInt1, paramInt3, paramInt4);
  }
  
  public void setLoadDrawableAsync(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setWealthGodType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    String str3;
    String str2;
    String str1;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 2))
    {
      str3 = "KEY_SPLASH_BG_TOY_LEFT_SLEEP";
      str2 = "KEY_SPLASH_BG_TOY_RIGHT_SLEEP";
      str1 = "KEY_SPLASH_BG_CLOUD_FG_2_SLEEP";
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView.setVisibility(8);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str3))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        label55:
        if (!TextUtils.isEmpty(str2)) {
          break label207;
        }
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        label70:
        if (!TextUtils.isEmpty(str1)) {
          break label226;
        }
        this.g.setBackgroundDrawable(null);
      }
      for (;;)
      {
        SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, "KEY_SPLASH_BG_BG", this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Boolean);
        SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, "KEY_SPLASH_BG_CLOUD_FG_1", this.f, this.jdField_a_of_type_Boolean);
        SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, "KEY_SPLASH_BG_CLOUD_LEFT_TOP", this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Boolean);
        SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, "KEY_SPLASH_BG_CLOUD_RIGHT_TOP", this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Boolean);
        d();
        return;
        if (this.jdField_a_of_type_Int != 1) {
          break label245;
        }
        str3 = "KEY_SPLASH_BG_TOY_LEFT_WORK";
        str2 = "KEY_SPLASH_BG_TOY_RIGHT_WORK";
        str1 = "KEY_SPLASH_BG_CLOUD_FG_2_WORK";
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapFlakeView.setVisibility(0);
        break;
        SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, str3, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Boolean);
        break label55;
        label207:
        SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, str2, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Boolean);
        break label70;
        label226:
        SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, str1, this.g, this.jdField_a_of_type_Boolean);
      }
      label245:
      str1 = null;
      str2 = null;
      str3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapSplashBgView
 * JD-Core Version:    0.7.0.1
 */