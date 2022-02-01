package com.tencent.gdtad.views.canvas.components.danmaku;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdUIUtils;

@SuppressLint({"AppCompatCustomView"})
class GdtDanmakuItemView
  extends TextView
{
  private ObjectAnimator a;
  
  public GdtDanmakuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GdtDanmakuItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public GdtDanmakuItemView a(ObjectAnimator paramObjectAnimator)
  {
    this.a = paramObjectAnimator;
    return this;
  }
  
  public boolean a()
  {
    ObjectAnimator localObjectAnimator = this.a;
    if (localObjectAnimator == null) {
      return false;
    }
    localObjectAnimator.start();
    return true;
  }
  
  public void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    setTextColor(Color.parseColor("#FFFFFFFF"));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AdUIUtils.dp2px(11.0F, getResources()));
    localGradientDrawable.setColor(Color.parseColor("#993C3C3C"));
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(localGradientDrawable);
    }
    setLayoutParams(localLayoutParams);
    setPadding(AdUIUtils.dp2px(10.0F, getResources()), AdUIUtils.dp2px(2.0F, getResources()), AdUIUtils.dp2px(10.0F, getResources()), AdUIUtils.dp2px(2.0F, getResources()));
    setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuItemView
 * JD-Core Version:    0.7.0.1
 */