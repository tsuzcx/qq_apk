package com.tencent.mobileqq.ark;

import aayp;
import aayq;
import aayr;
import aays;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ArkAiBubbleView
  implements Animation.AnimationListener
{
  public View a;
  public ImageView a;
  protected TextView a;
  public ArkAiInfo a;
  public ArkAiScrollBar a;
  private ArkAppCenter.OnGetAppIcon jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$OnGetAppIcon = new aayp(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new aayq(this);
  public List a;
  public boolean a;
  private Runnable b;
  public boolean b;
  public boolean c;
  
  public ArkAiBubbleView(ArkRecommendController paramArkRecommendController, LinearLayout paramLinearLayout)
  {
    this.jdField_b_of_type_JavaLangRunnable = new aayr(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramArkRecommendController.a().a).inflate(2130968710, paramLinearLayout, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363339));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363340));
    this.jdField_a_of_type_AndroidViewView.setTag(this);
  }
  
  public static ArkAiBubbleView a(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof ArkAiBubbleView)) {
      return (ArkAiBubbleView)paramView;
    }
    return null;
  }
  
  private void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aays(this, paramOnClickListener));
  }
  
  public ArkAiInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130838205));
      ArkAppCenter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.d);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(LinearLayout paramLinearLayout, ArkAiScrollBar paramArkAiScrollBar, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar = paramArkAiScrollBar;
    this.jdField_b_of_type_Boolean = false;
    Object localObject = FaceDrawable.a((AppInterface)BaseApplicationImpl.sApplication.getRuntime(), AppConstants.av, (byte)3);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetImageView.getResources();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(200.0F, (Resources)localObject));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((Resources)localObject).getString(2131438855));
    a(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    if (paramArkAiScrollBar.b()) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ark.ai", 2, String.format("ArkRecommendLogic.addToParent: %h", new Object[] { this }));
      }
      return;
      paramLinearLayout = new TranslateAnimation(2, 1.0F, 0, 0.0F, 0, 0.0F, 0, 0.0F);
      paramLinearLayout.setDuration(500L);
      paramLinearLayout.setAnimationListener(this);
      paramArkAiScrollBar = new AlphaAnimation(0.0F, 1.0F);
      paramArkAiScrollBar.setDuration(500L);
      paramArkAiScrollBar.setAnimationListener(this);
      paramOnClickListener = new AnimationSet(true);
      paramOnClickListener.addAnimation(paramLinearLayout);
      paramOnClickListener.addAnimation(paramArkAiScrollBar);
      this.jdField_a_of_type_AndroidViewView.startAnimation(paramOnClickListener);
    }
  }
  
  public void a(LinearLayout paramLinearLayout, ArkAiScrollBar paramArkAiScrollBar, List paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar = paramArkAiScrollBar;
    this.jdField_b_of_type_Boolean = false;
    a(paramList);
    if ((paramList != null) && (paramList.size() > 0)) {
      a((ArkAiInfo)paramList.get(paramList.size() - 1));
    }
    a(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    if (paramArkAiScrollBar.b()) {
      this.jdField_a_of_type_AndroidViewView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ark.ai", 2, String.format("ArkRecommendLogic.addToParent: %h", new Object[] { this }));
      }
      return;
      paramLinearLayout = new TranslateAnimation(2, 1.0F, 0, 0.0F, 0, 0.0F, 0, 0.0F);
      paramLinearLayout.setDuration(500L);
      paramLinearLayout.setAnimationListener(this);
      paramArkAiScrollBar = new AlphaAnimation(0.0F, 1.0F);
      paramArkAiScrollBar.setDuration(500L);
      paramArkAiScrollBar.setAnimationListener(this);
      paramList = new AnimationSet(true);
      paramList.addAnimation(paramLinearLayout);
      paramList.addAnimation(paramArkAiScrollBar);
      this.jdField_a_of_type_AndroidViewView.startAnimation(paramList);
    }
  }
  
  public void a(ArkAiInfo paramArkAiInfo)
  {
    Resources localResources = this.jdField_a_of_type_AndroidWidgetImageView.getResources();
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo != null)
    {
      if ((!paramArkAiInfo.d.equals(this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.d)) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localResources.getDrawable(2130838205));
        ArkAppCenter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.d);
        this.jdField_a_of_type_Boolean = false;
      }
      if (!this.jdField_a_of_type_Boolean) {
        ArkAppCenter.a(paramArkAiInfo.d, this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$OnGetAppIcon);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo = paramArkAiInfo;
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(100.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo.g);
      return;
      ArkAppCenter.a(paramArkAiInfo.d, this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter$OnGetAppIcon);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar = null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ark.ai", 2, String.format("ArkRecommendLogic.disappear: %s", new Object[] { this }));
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewView.post(this.jdField_b_of_type_JavaLangRunnable);
    ArkAppCenter.b("ArkBubbleState", String.format("disappear is success", new Object[0]));
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      c();
      return;
    }
    paramAnimation = this.jdField_a_of_type_AndroidViewView;
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (this.c) {}
    for (long l = 20000L;; l = 10000L)
    {
      paramAnimation.postDelayed(localRunnable, l);
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiBubbleView
 * JD-Core Version:    0.7.0.1
 */