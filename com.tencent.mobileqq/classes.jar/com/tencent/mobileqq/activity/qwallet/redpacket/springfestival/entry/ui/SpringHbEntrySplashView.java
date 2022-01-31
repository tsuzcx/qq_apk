package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import actj;
import alww;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.qphone.base.util.QLog;

public class SpringHbEntrySplashView
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  public alww a;
  private Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public EntryBgView a;
  private StrokeTextView jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new SpringHbEntrySplashView.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  public View b;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public SpringHbEntrySplashView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SpringHbEntrySplashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SpringHbEntrySplashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      LayoutInflater.from(paramContext).inflate(2131561659, this, true);
      setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      e();
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_FuDaiEntrySplashView", paramContext);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.c != paramBoolean)
      {
        this.c = paramBoolean;
        if (paramBoolean)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_displayTip", localThrowable);
    }
  }
  
  private void e()
  {
    try
    {
      int i = getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiEntryBgView = ((EntryBgView)findViewById(2131366850));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131373019);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131375056));
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131373018));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131375060);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#f7e5c3"));
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#b1162e"));
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(actj.a(1.5F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 16.0F);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
      float f1 = getResources().getDimension(2131297002);
      float f2 = getResources().getDimension(2131297001);
      float f3 = getResources().getDimension(2131297000);
      int j = actj.a(50.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setMaxWidth(i - (int)(f1 * 2.0F + f2 + f3 + j));
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131366849);
      this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131296996);
      this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131296997);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiEntryBgView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772248);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_initViews", localThrowable);
    }
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.startNow();
      if (QLog.isColorLevel())
      {
        QLog.d("springHb_SpringHbEntrySplashView", 2, "startTipAnimation");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_startTipAnimation", localThrowable);
    }
  }
  
  private void g()
  {
    try
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
      if (QLog.isColorLevel())
      {
        QLog.d("springHb_SpringHbEntrySplashView", 2, "stopTipAnimation");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_stopTipAnimation", localThrowable);
    }
  }
  
  private void h()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848527);
      if ((this.jdField_a_of_type_Alww != null) && (!this.jdField_a_of_type_Alww.c))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848526);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_initResutImg", localThrowable);
    }
  }
  
  @TargetApi(11)
  public void a()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
      this.jdField_b_of_type_AndroidViewView.setAlpha(1.0F);
      if ((this.c) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      g();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_resetDragWordingOffset", localThrowable);
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringHbEntrySplashView", 2, "showPullMsgResult, isPulling=" + this.jdField_a_of_type_Boolean + ",resultType=" + paramInt);
      }
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(getResources().getString(2131719805));
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      h();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_Alww != null) {
        this.jdField_a_of_type_Alww.a(0, 300L);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_showPullMsgResult", localThrowable);
    }
  }
  
  public void a(alww paramalww)
  {
    this.jdField_a_of_type_Alww = paramalww;
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringHbEntrySplashView", 2, "showPullMsgProcess, isPulling=" + this.jdField_a_of_type_Boolean);
      }
      removeCallbacks(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(getResources().getString(2131719801));
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      setVisibility(0);
      bringToFront();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_showPullMsgProcess", localThrowable);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbEntrySplashView", 2, "reset, isPulling=" + this.jdField_a_of_type_Boolean);
    }
    try
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if (this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText("");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_reset", localThrowable);
    }
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringHbEntrySplashView", 2, "onBeforeSpringBack, ispulling=" + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (this.jdField_a_of_type_Boolean)
      {
        h();
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_onBeforeSpringBack", localThrowable);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  protected void onDetachedFromWindow()
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbEntrySplashView", 2, "fes_onDetachedFromWindow");
    }
    super.onDetachedFromWindow();
    g();
  }
  
  public void setContent(View paramView, Bitmap paramBitmap, String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiEntryBgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiEntryBgView.setTargetView(paramView, paramBitmap);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
      }
      invalidate();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_setContent", paramView);
    }
  }
  
  @TargetApi(11)
  public void setDragWordingOffset(float paramFloat)
  {
    float f2;
    for (float f1 = 0.0F;; f1 = f2) {
      try
      {
        if (paramFloat <= this.jdField_b_of_type_Int)
        {
          f();
          return;
        }
        f2 = 1.0F - paramFloat / this.jdField_a_of_type_Int;
        if (f2 < 0.0F)
        {
          if (this.c)
          {
            if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
              this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            }
            this.jdField_b_of_type_AndroidViewView.setTranslationY(paramFloat - this.jdField_b_of_type_Int);
            this.jdField_b_of_type_AndroidViewView.setAlpha(f1);
          }
          g();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_setDragWordingOffset", localThrowable);
        return;
      }
    }
  }
  
  public void setTipMarginTop(int paramInt)
  {
    try
    {
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.topMargin = paramInt;
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbEntrySplashView", 1, "FDS_setTipMarginTop", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntrySplashView
 * JD-Core Version:    0.7.0.1
 */