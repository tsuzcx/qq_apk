package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.ClickStatus;

public class ReadInJoyLikeButton
  extends ButtonBase
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private AnimatorSet b = new AnimatorSet();
  
  public ReadInJoyLikeButton(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.0F }).setDuration(200L), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.0F }).setDuration(200L) });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ReadInJoyLikeButton.1(this));
    this.b.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 0.0F, 1.1F, 1.0F }).setDuration(200L), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 0.0F, 1.1F, 1.0F }).setDuration(200L) });
    this.b.addListener(new ReadInJoyLikeButton.2(this));
  }
  
  private void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramVafContext.getContext());
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramVafContext.getContext());
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramVafContext.getContext());
    paramVafContext = new LinearLayout.LayoutParams(-2, -2);
    paramVafContext.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramVafContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramVafContext);
    a();
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  private void b()
  {
    c();
    super.onClick();
    if (!isSelected()) {}
    for (boolean bool = true;; bool = false)
    {
      super.setSelected(bool);
      this.jdField_a_of_type_AndroidWidgetTextView.setSelected(bool);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(isSelected());
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public boolean onClick()
  {
    RIJUserLevelModule.a().a(getNativeView().getContext(), 3, new ReadInJoyLikeButton.3(this));
    return false;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.mTextSize);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(this.mCompoundDrawablePadding, 0, 0, 0);
    a(this.mText);
  }
  
  public void refresh()
  {
    super.refresh();
  }
  
  public void setBackgroundColorForStates() {}
  
  public void setBackgroundForStates()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void setCompoundDrawableForStates()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setSelected(paramBoolean);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mText))
    {
      this.mText = paramCharSequence;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
  }
  
  public void setTextColorForStates()
  {
    ColorStateList localColorStateList = ColorUtil.getColorStateList(getStatus(0).textColor, getStatus(1).textColor, getStatus(4).textColor);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLikeButton
 * JD-Core Version:    0.7.0.1
 */