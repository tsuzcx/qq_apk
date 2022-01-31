package com.tencent.biz.pubaccount.readinjoy.view.widget;

import aciy;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import rgx;
import rgy;
import rgz;
import rha;
import vct;

public class ReadInJoyScrollViewSwitcher
  extends ViewSwitcher
{
  private int jdField_a_of_type_Int = 400;
  private ArrayList<rha> jdField_a_of_type_JavaUtilArrayList;
  private rgy jdField_a_of_type_Rgy;
  public rgz a;
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
  
  private void a(rha paramrha, View paramView, int paramInt)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131311220);
    localTextView.setText(paramrha.jdField_a_of_type_JavaLangString);
    paramView = (CornerImageView)paramView.findViewById(2131302061);
    paramView.setRadius(aciy.a(2.0F, getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (TextUtils.isEmpty(paramrha.b)) {
      if (paramrha.jdField_a_of_type_Int > 0)
      {
        paramView.setImageDrawable(getResources().getDrawable(paramrha.jdField_a_of_type_Int));
        localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams.rightMargin = aciy.a(32.0F, getResources());
        localTextView.setLayoutParams(localLayoutParams);
        paramView.setVisibility(0);
      }
    }
    for (;;)
    {
      localTextView.setOnClickListener(new rgx(this, paramrha));
      return;
      paramView.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      paramView.rightMargin = aciy.a(5.0F, getResources());
      localTextView.setLayoutParams(paramView);
      continue;
      a(paramrha.b, paramView);
      localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams.rightMargin = aciy.a(32.0F, getResources());
      localTextView.setLayoutParams(localLayoutParams);
      paramView.setVisibility(0);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Rgy = new rgy(this);
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
      a((rha)this.jdField_a_of_type_JavaUtilArrayList.get(this.b), getNextView(), this.b);
      showNext();
      return;
    }
  }
  
  protected void a(String paramString, URLImageView paramURLImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vct.a(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vct.a(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = vct.a(getContext(), 2.0F);
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
    this.jdField_a_of_type_Rgy.removeMessages(0);
    this.jdField_a_of_type_Rgy.sendEmptyMessageDelayed(0, this.c);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Rgy.removeCallbacksAndMessages(null);
  }
  
  public void setOnClickListener(rgz paramrgz)
  {
    this.jdField_a_of_type_Rgz = paramrgz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher
 * JD-Core Version:    0.7.0.1
 */