package com.tencent.biz.qqstory.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;

public class TranslucentTitleBarHelper
{
  RelativeLayout a;
  ImmersiveTitleBar2 b;
  TextView c;
  TextView d;
  TextView e;
  ImageView f;
  int g = 0;
  float h = 1.0F;
  ColorStateList i;
  boolean j = false;
  
  public TranslucentTitleBarHelper(BaseActivity paramBaseActivity, int paramInt)
  {
    int k = ImmersiveUtils.isSupporImmersive();
    boolean bool = true;
    if (k != 1) {
      bool = false;
    }
    this.j = bool;
    if (this.j)
    {
      paramBaseActivity.mActNeedImmersive = false;
      paramBaseActivity.mNeedStatusTrans = false;
      paramBaseActivity.getWindow().addFlags(67108864);
    }
    this.g = DisplayUtil.a(paramBaseActivity, paramInt);
  }
  
  private void a(float paramFloat)
  {
    int k = (int)(255.0F * paramFloat);
    Object localObject = this.a.getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).setAlpha(k);
      this.a.invalidateDrawable((Drawable)localObject);
    }
    this.b.setAlpha(paramFloat);
    this.c.setAlpha(paramFloat);
    if (this.i == null) {
      this.i = this.d.getTextColors();
    }
    if (paramFloat > 0.5D)
    {
      this.f.setImageResource(2130841087);
      this.d.setBackgroundResource(2130853297);
      this.d.setTextColor(this.i);
      this.e.setTextColor(this.i);
      return;
    }
    this.f.setImageResource(2130841087);
    this.d.setBackgroundResource(2130853297);
    localObject = this.d;
    ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColorStateList(2131167990));
    localObject = this.e;
    ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColorStateList(2131167990));
  }
  
  public void a(View paramView)
  {
    this.a = ((RelativeLayout)paramView.findViewById(2131447534));
    this.c = ((TextView)paramView.findViewById(2131436227));
    this.d = ((TextView)paramView.findViewById(2131436180));
    this.e = ((TextView)paramView.findViewById(2131436211));
    this.f = ((ImageView)paramView.findViewById(2131436194));
    this.b = ((ImmersiveTitleBar2)paramView.findViewById(2131447582));
    if (this.j)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramInt1 = -paramAbsListView.getChildAt(0).getTop();
      if ((paramInt1 > this.g) && (!a()))
      {
        a(true, true);
        return;
      }
      if ((paramInt1 < this.g) && (a())) {
        a(false, true);
      }
    }
    else if ((paramInt1 > 0) && (!a()))
    {
      a(true, true);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f1;
    if (paramBoolean1) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    if (this.h == f1) {
      return;
    }
    if (paramBoolean2)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      localValueAnimator.setFloatValues(new float[] { this.h, f1 });
      localValueAnimator.addUpdateListener(new TranslucentTitleBarHelper.1(this));
      localValueAnimator.setDuration(500L);
      localValueAnimator.start();
    }
    else
    {
      a(f1);
    }
    this.h = f1;
  }
  
  public boolean a()
  {
    return this.h > 0.5D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper
 * JD-Core Version:    0.7.0.1
 */