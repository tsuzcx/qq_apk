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
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean = false;
  private View b;
  private View c;
  
  public BottomDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755240);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject = new TranslateAnimation(0.0F, 0.0F, this.b.getHeight(), 0.0F);
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setInterpolator(new DecelerateInterpolator());
    this.b.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.c.startAnimation((Animation)localObject);
  }
  
  private void a(View paramView)
  {
    this.b = paramView.findViewById(2131365132);
    this.c = paramView.findViewById(2131363349);
    this.c.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165329));
    this.c.setOnClickListener(new BottomDialog.1(this));
    paramView.findViewById(2131364703).setOnClickListener(new BottomDialog.2(this));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.b.getHeight());
    ((Animation)localObject).setFillAfter(true);
    ((Animation)localObject).setInterpolator(new DecelerateInterpolator());
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setAnimationListener(new BottomDialog.3(this));
    this.b.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    this.c.startAnimation((Animation)localObject);
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Boolean) {
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(paramInt, null);
    a(this.jdField_a_of_type_AndroidViewView);
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void setContentView(@NonNull View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(this.jdField_a_of_type_AndroidViewView);
    super.setContentView(paramView);
  }
  
  public void setContentView(@NonNull View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(this.jdField_a_of_type_AndroidViewView);
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    this.b.setVisibility(4);
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.post(new BottomDialog.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.BottomDialog
 * JD-Core Version:    0.7.0.1
 */