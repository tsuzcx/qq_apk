package com.tencent.biz.pubaccount.weishi_new.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

@SuppressLint({"ClickableViewAccessibility"})
public class WSMarqueeDirector
  extends WSViewDirector
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private static int jdField_a_of_type_Int = ScreenUtil.dip2px(60.0F);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private final HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final WSMarqueeDirector.MarqueeAnimAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector$MarqueeAnimAdapter = new WSMarqueeDirector.MarqueeAnimAdapter(this, null);
  private WSMarqueeDirector.OnTextContentListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector$OnTextContentListener;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private final TextView c;
  private final TextView d;
  
  public WSMarqueeDirector(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131368322));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131370275));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131370693));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131370694));
    this.c = ((TextView)a(2131370695));
    this.d = ((TextView)a(2131370696));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT > 15) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.c.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.c.setVisibility(8);
    Drawable localDrawable = a().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(WeishiUIUtil.c);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(paramObject);
    this.c.setCompoundDrawables(localDrawable, null, null, null);
    this.c.setCompoundDrawablePadding(WeishiUIUtil.c);
    this.c.setText(paramString);
    this.c.setTag(paramObject);
  }
  
  public void a(WSMarqueeDirector.OnTextContentListener paramOnTextContentListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector$OnTextContentListener = paramOnTextContentListener;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.d.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public void b(int paramInt, String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.d.setVisibility(8);
    Drawable localDrawable = a().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(WeishiUIUtil.c);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramObject);
    this.d.setCompoundDrawables(localDrawable, null, null, null);
    this.d.setCompoundDrawablePadding(WeishiUIUtil.c);
    this.d.setText(paramString);
    this.d.setTag(paramObject);
  }
  
  public void c()
  {
    f();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    int i = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getWidth();
    this.jdField_b_of_type_Int = 0;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_b_of_type_Int += this.jdField_a_of_type_AndroidWidgetTextView.getWidth();
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_b_of_type_Int += this.jdField_b_of_type_AndroidWidgetTextView.getWidth();
    }
    if (this.jdField_b_of_type_Int - i < 1)
    {
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startAnim:  A text:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    localStringBuilder.append(",B text:");
    localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    localStringBuilder.append(" , A width:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetTextView.getWidth());
    localStringBuilder.append(" , B width:");
    localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetTextView.getWidth());
    localStringBuilder.append(" , ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    WSLog.a("WSMarqueeDirector", localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView.isShown()) {
        this.c.setVisibility(0);
      } else {
        this.c.setVisibility(8);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView.isShown()) {
        this.d.setVisibility(0);
      } else {
        this.d.setVisibility(8);
      }
      i = this.jdField_b_of_type_Int * 2;
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(i * 1000 / jdField_a_of_type_Int + 1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector$MarqueeAnimAdapter);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector$MarqueeAnimAdapter);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 19)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.pause();
      return;
    }
    f();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
      return;
    }
    if (Build.VERSION.SDK_INT > 19)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.resume();
      return;
    }
    c();
  }
  
  public void f()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator == null) {
      return;
    }
    localValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370694: 
    case 2131370696: 
      localOnTextContentListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector$OnTextContentListener;
      if (localOnTextContentListener == null) {
        return;
      }
      localOnTextContentListener.b(paramView.getTag());
      return;
    }
    WSMarqueeDirector.OnTextContentListener localOnTextContentListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSMarqueeDirector$OnTextContentListener;
    if (localOnTextContentListener == null) {
      return;
    }
    localOnTextContentListener.a(paramView.getTag());
  }
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT > 15) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    WSLog.a("WSMarqueeDirector", "onGlobalLayout: ");
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSMarqueeDirector
 * JD-Core Version:    0.7.0.1
 */