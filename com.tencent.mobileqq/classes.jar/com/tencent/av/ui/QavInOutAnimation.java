package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.UITools;
import java.lang.ref.SoftReference;

public class QavInOutAnimation
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  QavInOutAnimation.QavInAnimationListener jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavInAnimationListener = null;
  QavInOutAnimation.QavOutAnimationListener jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener = null;
  QavPanel jdField_a_of_type_ComTencentAvUiQavPanel = null;
  SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference = null;
  View jdField_b_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  View jdField_c_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_c_of_type_AndroidViewAnimationAnimation = null;
  View jdField_d_of_type_AndroidViewView = null;
  Animation jdField_d_of_type_AndroidViewAnimationAnimation = null;
  View jdField_e_of_type_AndroidViewView = null;
  Animation jdField_e_of_type_AndroidViewAnimationAnimation = null;
  View jdField_f_of_type_AndroidViewView = null;
  Animation jdField_f_of_type_AndroidViewAnimationAnimation = null;
  View jdField_g_of_type_AndroidViewView = null;
  Animation jdField_g_of_type_AndroidViewAnimationAnimation = null;
  Animation h = null;
  Animation i = null;
  Animation j = null;
  Animation k = null;
  Animation l = null;
  Animation m = null;
  
  public QavInOutAnimation(Context paramContext, VideoController paramVideoController, int paramInt, QavPanel paramQavPanel, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = paramQavPanel;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_c_of_type_AndroidViewView = paramView3;
    this.jdField_d_of_type_AndroidViewView = paramView4;
    this.jdField_e_of_type_AndroidViewView = paramView5;
    this.jdField_g_of_type_AndroidViewView = paramView6;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    paramVideoController = new DecelerateInterpolator();
    paramQavPanel = new AccelerateInterpolator();
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    paramView1 = this.jdField_c_of_type_AndroidViewAnimationAnimation;
    long l1 = 620;
    paramView1.setDuration(l1);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setInterpolator(paramVideoController);
    this.h = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    this.h.setDuration(l1);
    this.h.setInterpolator(paramQavPanel);
    paramInt = UITools.a(paramContext);
    int n;
    if (paramInt <= 320)
    {
      n = paramContext.getResources().getDimensionPixelSize(2131297794);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131297790);
    }
    for (;;)
    {
      break;
      if (paramInt <= 480)
      {
        n = paramContext.getResources().getDimensionPixelSize(2131297795);
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297791);
      }
      else
      {
        n = paramContext.getResources().getDimensionPixelSize(2131297797);
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297793);
      }
    }
    float f1 = -(n + paramInt);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, f1, 1, 0.0F);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(l1);
    this.jdField_d_of_type_AndroidViewAnimationAnimation.setInterpolator(paramVideoController);
    this.i = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 0, f1);
    this.i.setDuration(l1);
    this.i.setInterpolator(paramQavPanel);
    this.jdField_e_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_e_of_type_AndroidViewAnimationAnimation.setDuration(l1);
    this.j = new AlphaAnimation(1.0F, 0.0F);
    this.j.setDuration(l1);
    this.jdField_f_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.jdField_f_of_type_AndroidViewAnimationAnimation.setDuration(l1);
    this.jdField_f_of_type_AndroidViewAnimationAnimation.setInterpolator(paramVideoController);
    this.k = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.k.setDuration(l1);
    this.k.setInterpolator(paramQavPanel);
    this.l = new AlphaAnimation(0.0F, 0.0F);
    this.l.setDuration(l1);
    this.jdField_g_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 0.0F);
    this.jdField_g_of_type_AndroidViewAnimationAnimation.setDuration(l1);
    this.m = new AlphaAnimation(0.0F, 0.0F);
    this.m.setDuration(l1);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new QavInOutAnimation.InAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new QavInOutAnimation.InDelayAnimationListener(this);
    this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new QavInOutAnimation.OutAnimationListener(this);
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(QavInOutAnimation.QavInAnimationListener paramQavInAnimationListener)
  {
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavInAnimationListener = paramQavInAnimationListener;
    paramQavInAnimationListener = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((paramQavInAnimationListener != null) && (paramQavInAnimationListener.a() != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ai) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      paramQavInAnimationListener = this.jdField_f_of_type_AndroidViewAnimationAnimation;
      if ((paramQavInAnimationListener != null) && (this.jdField_a_of_type_AndroidViewAnimationAnimation != null))
      {
        paramQavInAnimationListener.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        paramQavInAnimationListener = this.jdField_a_of_type_AndroidViewView;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
        paramQavInAnimationListener = this.jdField_b_of_type_AndroidViewView;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
        paramQavInAnimationListener = this.jdField_c_of_type_AndroidViewView;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
        paramQavInAnimationListener = this.jdField_d_of_type_AndroidViewView;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
        paramQavInAnimationListener = this.jdField_e_of_type_AndroidViewView;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
        paramQavInAnimationListener = this.jdField_g_of_type_AndroidViewView;
        if (paramQavInAnimationListener != null) {
          paramQavInAnimationListener.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        }
        return;
      }
    }
    paramQavInAnimationListener = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavInAnimationListener;
    if (paramQavInAnimationListener != null)
    {
      paramQavInAnimationListener.a();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavInAnimationListener.b();
    }
  }
  
  public void a(QavInOutAnimation.QavOutAnimationListener paramQavOutAnimationListener)
  {
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener = paramQavOutAnimationListener;
    paramQavOutAnimationListener = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.a() != null) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().aj))
    {
      QavPanel localQavPanel = this.jdField_a_of_type_ComTencentAvUiQavPanel;
      if (localQavPanel != null)
      {
        paramQavOutAnimationListener = this.k;
        if (paramQavOutAnimationListener != null)
        {
          if (localQavPanel.getVisibility() != 0) {
            paramQavOutAnimationListener = this.l;
          }
          paramQavOutAnimationListener.setAnimationListener(this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.startAnimation(paramQavOutAnimationListener);
          if (this.jdField_a_of_type_ComTencentAvUiQavPanel.a() != null) {
            this.jdField_a_of_type_ComTencentAvUiQavPanel.a().startAnimation(this.m);
          }
          paramQavOutAnimationListener = this.jdField_a_of_type_AndroidViewView;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.jdField_a_of_type_AndroidViewView.startAnimation(this.h);
          }
          paramQavOutAnimationListener = this.jdField_b_of_type_AndroidViewView;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.jdField_b_of_type_AndroidViewView.startAnimation(this.i);
          }
          paramQavOutAnimationListener = this.jdField_c_of_type_AndroidViewView;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.jdField_c_of_type_AndroidViewView.startAnimation(this.i);
          }
          paramQavOutAnimationListener = this.jdField_d_of_type_AndroidViewView;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.jdField_d_of_type_AndroidViewView.startAnimation(this.j);
          }
          paramQavOutAnimationListener = this.jdField_e_of_type_AndroidViewView;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.jdField_e_of_type_AndroidViewView.startAnimation(this.j);
          }
          paramQavOutAnimationListener = this.jdField_g_of_type_AndroidViewView;
          if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.getVisibility() == 0)) {
            this.jdField_g_of_type_AndroidViewView.startAnimation(this.j);
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a().aj = true;
          return;
        }
      }
    }
    paramQavOutAnimationListener = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((paramQavOutAnimationListener != null) && (paramQavOutAnimationListener.a() != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ai = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().aj = false;
    }
    paramQavOutAnimationListener = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener;
    if (paramQavOutAnimationListener != null)
    {
      paramQavOutAnimationListener.a();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener.b();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    Animation localAnimation = this.jdField_c_of_type_AndroidViewAnimationAnimation;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.jdField_d_of_type_AndroidViewAnimationAnimation;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.jdField_e_of_type_AndroidViewAnimationAnimation;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.jdField_f_of_type_AndroidViewAnimationAnimation;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.jdField_g_of_type_AndroidViewAnimationAnimation;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.h;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.i;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.j;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.k;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.l;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = this.m;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_d_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_e_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_f_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_g_of_type_AndroidViewAnimationAnimation = null;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavInAnimationListener = null;
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation$QavOutAnimationListener = null;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_g_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavInOutAnimation
 * JD-Core Version:    0.7.0.1
 */