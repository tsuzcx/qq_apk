package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class BottomDialog
  extends Dialog
{
  private Context a;
  private View b;
  private View c;
  private View d;
  private boolean e = false;
  private Handler f = new Handler(Looper.getMainLooper());
  
  public BottomDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131951927);
    this.a = paramContext;
  }
  
  private void a()
  {
    if (this.b == null) {
      return;
    }
    Object localObject = new TranslateAnimation(0.0F, 0.0F, this.c.getHeight(), 0.0F);
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setInterpolator(new DecelerateInterpolator());
    this.c.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.d.startAnimation((Animation)localObject);
  }
  
  private void a(View paramView)
  {
    this.c = paramView.findViewById(2131431280);
    this.d = paramView.findViewById(2131429234);
    this.d.setBackgroundColor(this.a.getResources().getColor(2131165566));
    this.d.setOnClickListener(new BottomDialog.1(this));
    paramView.findViewById(2131430806).setOnClickListener(new BottomDialog.2(this));
  }
  
  private void b()
  {
    if (this.b == null) {
      return;
    }
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.c.getHeight());
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setInterpolator(new DecelerateInterpolator());
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setAnimationListener(new BottomDialog.3(this));
    this.c.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.d.startAnimation((Animation)localObject);
  }
  
  public void dismiss()
  {
    if (this.e) {
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setCanceledOnTouchOutside(true);
  }
  
  public void setContentView(int paramInt)
  {
    this.b = LayoutInflater.from(getContext()).inflate(paramInt, null);
    a(this.b);
    super.setContentView(this.b);
  }
  
  public void setContentView(@NonNull View paramView)
  {
    this.b = paramView;
    a(this.b);
    super.setContentView(paramView);
  }
  
  public void setContentView(@NonNull View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.b = paramView;
    a(this.b);
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    this.c.setVisibility(4);
    this.d.setVisibility(4);
    this.f.post(new BottomDialog.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.BottomDialog
 * JD-Core Version:    0.7.0.1
 */