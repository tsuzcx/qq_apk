package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.ClickStatus;
import lwf;

public class ReadInJoyLikeButton
  extends ButtonBase
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ReadInJoyLikeButton(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramVafContext.a());
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramVafContext.a());
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramVafContext.a());
    paramVafContext = new LinearLayout.LayoutParams(-2, -2);
    paramVafContext.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramVafContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramVafContext);
    h();
  }
  
  private void d(String paramString)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramString));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 1.8F, 0.85F, 1.0F }).setDuration(600L), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 1.8F, 0.85F, 1.0F }).setDuration(600L) });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new lwf(null));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.o, this.q, this.p, this.r);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.C);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(this.A, 0, 0, 0);
    d(this.e);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.e))
    {
      this.e = paramString;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setSelected(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected boolean a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    boolean bool2 = super.a(paramInt);
    if (!g()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(bool1);
      return bool2;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
  }
  
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    localObject = DrawableUtil.a(DrawableUtil.a((Context)localObject, a(0).b, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), DrawableUtil.a((Context)localObject, a(1).b, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), DrawableUtil.a((Context)localObject, a(4).b, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable((Drawable)localObject);
  }
  
  protected void c() {}
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    localObject = DrawableUtil.a(DrawableUtil.a((Context)localObject, a(0).a, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), DrawableUtil.a((Context)localObject, a(1).a, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), DrawableUtil.a((Context)localObject, a(4).a, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  protected void e()
  {
    ColorStateList localColorStateList = ColorUtil.a(a(0).d, a(1).d, a(4).d);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
  }
  
  public void f()
  {
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLikeButton
 * JD-Core Version:    0.7.0.1
 */