package com.tencent.biz.pubaccount.readinjoy.view.widget;

import actn;
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
import rtn;
import rto;
import rtp;
import rtq;
import vpp;

public class ReadInJoyScrollViewSwitcher
  extends ViewSwitcher
{
  private int jdField_a_of_type_Int = 400;
  private ArrayList<rtq> jdField_a_of_type_JavaUtilArrayList;
  private rto jdField_a_of_type_Rto;
  public rtp a;
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
  
  private void a(rtq paramrtq, View paramView, int paramInt)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131377030);
    localTextView.setText(paramrtq.jdField_a_of_type_JavaLangString);
    paramView = (CornerImageView)paramView.findViewById(2131367679);
    paramView.setRadius(actn.a(2.0F, getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (TextUtils.isEmpty(paramrtq.b)) {
      if (paramrtq.jdField_a_of_type_Int > 0)
      {
        paramView.setImageDrawable(getResources().getDrawable(paramrtq.jdField_a_of_type_Int));
        localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localLayoutParams.rightMargin = actn.a(32.0F, getResources());
        localTextView.setLayoutParams(localLayoutParams);
        paramView.setVisibility(0);
      }
    }
    for (;;)
    {
      localTextView.setOnClickListener(new rtn(this, paramrtq));
      return;
      paramView.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      paramView.rightMargin = actn.a(5.0F, getResources());
      localTextView.setLayoutParams(paramView);
      continue;
      a(paramrtq.b, paramView);
      localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      localLayoutParams.rightMargin = actn.a(32.0F, getResources());
      localTextView.setLayoutParams(localLayoutParams);
      paramView.setVisibility(0);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Rto = new rto(this);
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
      a((rtq)this.jdField_a_of_type_JavaUtilArrayList.get(this.b), getNextView(), this.b);
      showNext();
      return;
    }
  }
  
  protected void a(String paramString, URLImageView paramURLImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vpp.b(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vpp.b(getContext(), 24.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = vpp.b(getContext(), 2.0F);
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
    this.jdField_a_of_type_Rto.removeMessages(0);
    this.jdField_a_of_type_Rto.sendEmptyMessageDelayed(0, this.c);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Rto.removeCallbacksAndMessages(null);
  }
  
  public void setOnClickListener(rtp paramrtp)
  {
    this.jdField_a_of_type_Rtp = paramrtp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher
 * JD-Core Version:    0.7.0.1
 */