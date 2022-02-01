package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emotionintegrate.EmotionKeywordLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CommonStickerRecView
  implements View.OnClickListener, IStickerView
{
  public int b;
  public int c;
  public int d;
  public URLImageView e;
  CommonStickerRecPresenter f;
  RelativeLayout g;
  TextView h;
  Animator i;
  ImageView j;
  Drawable k;
  EditText l;
  
  public CommonStickerRecView(IStickerPresenter paramIStickerPresenter, Activity paramActivity, BaseAIOContext paramBaseAIOContext, ViewGroup paramViewGroup, EditText paramEditText)
  {
    this.f = ((CommonStickerRecPresenter)paramIStickerPresenter);
    this.l = paramEditText;
    this.k = paramActivity.getResources().getDrawable(2130838305);
    float f1 = paramActivity.getResources().getDisplayMetrics().density;
    int m = (int)(64.0F * f1);
    this.b = m;
    this.c = m;
    this.d = ((int)(6.0F * f1));
    m = (int)(7.0F * f1);
    int n = (int)(9.0F * f1);
    int i1 = (int)(f1 * 8.0F);
    this.g = new EmotionKeywordLayout(paramActivity, paramBaseAIOContext, paramViewGroup);
    paramIStickerPresenter = new ViewGroup.LayoutParams(-2, -2);
    this.g.setLayoutParams(paramIStickerPresenter);
    this.g.setPadding(m, n, m, i1);
    this.e = new URLImageView(paramActivity);
    this.e.setScaleType(ImageView.ScaleType.FIT_XY);
    this.e.setId(2131435503);
    paramIStickerPresenter = new RelativeLayout.LayoutParams(this.c, this.b);
    paramIStickerPresenter.addRule(13, -1);
    this.g.addView(this.e, paramIStickerPresenter);
    this.h = new TextView(paramActivity);
    this.h.setBackgroundDrawable(paramActivity.getResources().getDrawable(2130837982));
    paramIStickerPresenter = new RelativeLayout.LayoutParams(-2, -2);
    paramIStickerPresenter.addRule(7, 2131435503);
    paramIStickerPresenter.addRule(8, 2131435503);
    this.h.setText(2131888851);
    this.h.setTextColor(paramActivity.getResources().getColor(2131168212));
    this.h.setTextSize(1, 12.0F);
    this.g.addView(this.h, paramIStickerPresenter);
    this.j = new ImageView(paramActivity);
    this.j.setImageDrawable(paramActivity.getResources().getDrawable(2130838299));
    paramIStickerPresenter = new RelativeLayout.LayoutParams(-2, -2);
    paramIStickerPresenter.addRule(7, 2131435503);
    paramIStickerPresenter.addRule(8, 2131435503);
    this.g.addView(this.j, paramIStickerPresenter);
    this.j.setVisibility(8);
    paramIStickerPresenter = ObjectAnimator.ofFloat(this.e, "alpha", new float[] { 0.0F, 1.0F });
    paramIStickerPresenter.setDuration(300L);
    this.i = paramIStickerPresenter;
  }
  
  public void a(boolean paramBoolean)
  {
    int m = this.f.g();
    this.e.getLayoutParams().width = m;
    Object localObject = this.e;
    int n = 0;
    ((URLImageView)localObject).setVisibility(0);
    if (paramBoolean)
    {
      this.g.setOnClickListener(this);
      this.i.start();
    }
    else
    {
      this.e.setImageDrawable(this.k);
    }
    localObject = this.h;
    if (this.f.h()) {
      m = 0;
    } else {
      m = 8;
    }
    ((TextView)localObject).setVisibility(m);
    localObject = this.j;
    if (this.f.i()) {
      m = n;
    } else {
      m = 8;
    }
    ((ImageView)localObject).setVisibility(m);
    this.e.setContentDescription(this.f.j());
  }
  
  public View c()
  {
    return this.g;
  }
  
  public IStickerPresenter d()
  {
    return this.f;
  }
  
  public Drawable e()
  {
    return this.k;
  }
  
  public void onClick(View paramView)
  {
    CommonStickerRecPresenter localCommonStickerRecPresenter;
    if (QLog.isColorLevel())
    {
      localCommonStickerRecPresenter = this.f;
      QLog.d("CommonStickerRec", 2, "onClick");
    }
    if (this.l == null)
    {
      if (QLog.isColorLevel())
      {
        localCommonStickerRecPresenter = this.f;
        QLog.e("CommonStickerRec", 2, "onClick input == null");
      }
    }
    else if (this.f.c())
    {
      this.l.getEditableText().clear();
      this.l.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecView
 * JD-Core Version:    0.7.0.1
 */