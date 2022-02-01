package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import tqt;
import tqu;
import tqv;
import tqw;

public class ReadInJoyScrollViewSwitcher
  extends ViewSwitcher
{
  private int jdField_a_of_type_Int = 400;
  private ArrayList<tqw> jdField_a_of_type_JavaUtilArrayList;
  private tqu jdField_a_of_type_Tqu;
  public tqv a;
  private int b;
  private int c;
  
  public ReadInJoyScrollViewSwitcher(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyScrollViewSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
    d();
  }
  
  private void a(tqw paramtqw, View paramView, int paramInt)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131378658);
    localTextView.setText(paramtqw.jdField_a_of_type_JavaLangString);
    paramView = (CornerImageView)paramView.findViewById(2131368381);
    paramView.setRadius(AIOUtils.dp2px(2.0F, getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (TextUtils.isEmpty(paramtqw.b)) {
      if (paramtqw.jdField_a_of_type_Int > 0)
      {
        paramView.setImageDrawable(getResources().getDrawable(paramtqw.jdField_a_of_type_Int));
        localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams.rightMargin = AIOUtils.dp2px(32.0F, getResources());
        localTextView.setLayoutParams(localLayoutParams);
        paramView.setVisibility(0);
      }
    }
    for (;;)
    {
      localTextView.setOnClickListener(new tqt(this, paramtqw));
      return;
      paramView.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      paramView.rightMargin = AIOUtils.dp2px(5.0F, getResources());
      localTextView.setLayoutParams(paramView);
      continue;
      a(paramtqw.b, paramView);
      localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams.rightMargin = AIOUtils.dp2px(32.0F, getResources());
      localTextView.setLayoutParams(localLayoutParams);
      paramView.setVisibility(0);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Tqu = new tqu(this);
    setAnimateFirstView(false);
  }
  
  private void d()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(this.jdField_a_of_type_Int);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    localTranslateAnimation.setFillAfter(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(this.jdField_a_of_type_Int);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    setInAnimation(localAnimationSet);
    localAnimationSet = new AnimationSet(true);
    localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    localTranslateAnimation.setDuration(this.jdField_a_of_type_Int);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    localTranslateAnimation.setFillAfter(false);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(this.jdField_a_of_type_Int);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    setOutAnimation(localAnimationSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 1) {
      return;
    }
    if (this.b == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {}
    for (int i = 0;; i = this.b + 1)
    {
      this.b = i;
      a((tqw)this.jdField_a_of_type_JavaUtilArrayList.get(this.b), getNextView(), this.b);
      showNext();
      return;
    }
  }
  
  protected void a(String paramString, URLImageView paramURLImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = DisplayUtil.dip2px(getContext(), 2.0F);
    try
    {
      localObject = URLDrawable.getDrawable(new URL("redtouchpicdownloadprotoc", null, paramString), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(paramString);
      paramURLImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyScrollViewSwitcher", 2, "parse img exception : e = " + paramString);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {
      return;
    }
    this.jdField_a_of_type_Tqu.removeMessages(0);
    this.jdField_a_of_type_Tqu.sendEmptyMessageDelayed(0, this.c);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Tqu.removeCallbacksAndMessages(null);
  }
  
  public void setOnClickListener(tqv paramtqv)
  {
    this.jdField_a_of_type_Tqv = paramtqv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher
 * JD-Core Version:    0.7.0.1
 */