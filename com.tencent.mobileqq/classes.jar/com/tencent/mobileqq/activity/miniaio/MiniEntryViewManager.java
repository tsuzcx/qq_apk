package com.tencent.mobileqq.activity.miniaio;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MiniEntryViewManager
  extends D8SafeAnimatorListener
  implements ValueAnimator.AnimatorUpdateListener, View.OnTouchListener, IMiniMsgUnreadCallback
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private final GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private MiniMsgConfigData jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgConfigData;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public MiniEntryViewManager(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.d = paramInt1;
    this.e = paramInt2;
    this.m = paramInt3;
    this.n = paramInt4;
    this.k = paramInt5;
    this.l = paramInt6;
    this.c = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
    paramActivity = BaseApplicationImpl.getApplication().getBaseContext();
    paramInt1 = paramActivity.getResources().getDisplayMetrics().widthPixels;
    paramInt3 = paramActivity.getResources().getDisplayMetrics().heightPixels;
    paramInt4 = paramActivity.getResources().getDimensionPixelSize(2131297351);
    int i1 = paramActivity.getResources().getDimensionPixelSize(2131297352);
    int i3 = paramActivity.getResources().getDimensionPixelSize(2131297350);
    int i2 = ViewUtils.b(56.0F);
    this.f = paramInt1;
    this.i = paramInt4;
    this.j = (paramInt3 - i3);
    i3 = this.c;
    int i4 = ViewUtils.a(7.0F);
    int i5 = this.i;
    if (paramInt5 != -1)
    {
      this.jdField_a_of_type_Int = paramInt5;
      this.jdField_b_of_type_Int = paramInt6;
    }
    else if (paramInt2 != 0)
    {
      this.jdField_a_of_type_Int = (paramInt1 - paramInt4 * 4);
      this.jdField_b_of_type_Int = (i3 + i4);
    }
    else
    {
      this.jdField_a_of_type_Int = (paramInt1 - i2 - i5);
      this.jdField_b_of_type_Int = (paramInt3 - i1);
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramActivity, new MiniEntryViewManager.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgConfigData = MiniMsgConfigProcessor.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgConfigData == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgConfigData = new MiniMsgConfigData();
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("configData : ");
      paramActivity.append(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgConfigData.toString());
      com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, paramActivity.toString());
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int i2 = this.c;
    int i1 = paramInt2;
    if (paramInt2 < i2) {
      i1 = i2;
    }
    paramInt2 = this.j;
    i2 = i1;
    if (i1 > paramInt2) {
      i2 = paramInt2;
    }
    i1 = this.i;
    paramInt2 = paramInt1;
    if (paramInt1 < i1) {
      paramInt2 = i1;
    }
    i1 = this.jdField_a_of_type_Int;
    paramInt1 = paramInt2;
    if (paramInt2 > i1) {
      paramInt1 = i1;
    }
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    localLayoutParams.y = i2;
    localLayoutParams.x = paramInt1;
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(paramView, localLayoutParams);
  }
  
  public int[] a()
  {
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    if (localLayoutParams == null) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    if (localLayoutParams != null)
    {
      arrayOfInt[0] = localLayoutParams.x;
      arrayOfInt[1] = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y;
    }
    return arrayOfInt;
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void hide()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void hideUnread()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371244).setVisibility(8);
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i1 = this.jdField_a_of_type_Int;
    if (this.g < this.f / 2) {
      i1 = this.i;
    }
    int i2 = this.g;
    i1 = i2 + (int)((i1 - i2) * f1);
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("onAnimationUpdate .curPx = ");
    paramValueAnimator.append(i1);
    paramValueAnimator.append(" ,mTouchUpX = ");
    paramValueAnimator.append(this.g);
    com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, paramValueAnimator.toString());
    i2 = this.h;
    a(this.jdField_a_of_type_AndroidViewView, i1, i2);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    int i1 = 0;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return false;
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.e != 0) {
      return bool;
    }
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 != 3) {
            break label185;
          }
        }
        else
        {
          a(paramView, (int)(f1 - this.jdField_a_of_type_Float), (int)(f2 - this.jdField_b_of_type_Float));
          break label185;
        }
      }
      a(paramView, (int)(f1 - this.jdField_a_of_type_Float), (int)(f2 - this.jdField_b_of_type_Float));
      this.g = ((int)(f1 - this.jdField_a_of_type_Float));
      this.h = ((int)(f2 - this.jdField_b_of_type_Float));
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_Float = 0.0F;
      i1 = 1;
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
    }
    label185:
    if ((!bool) && (i1 != 0)) {
      a();
    }
    return true;
  }
  
  public boolean show(int paramInt)
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.hasWindowFocus()) {
      return false;
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    Object localObject1;
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("styleType = ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(",filterType = ");
      ((StringBuilder)localObject1).append(this.d);
      com.tencent.qphone.base.util.QLog.d("mini_msg_FloatViewManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(localActivity.getApplicationContext(), 2131559396, null);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
      Object localObject3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371242);
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371243);
      Object localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371244);
      localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
      if (this.e != 0)
      {
        i1 = ViewUtils.b(38.0F);
        i2 = ViewUtils.b(32.0F);
        ((RelativeLayout.LayoutParams)localObject3).width = i1;
        ((RelativeLayout.LayoutParams)localObject3).height = i2;
        i1 = ViewUtils.b(24.0F);
        localLayoutParams.width = i1;
        localLayoutParams.height = i1;
        localLayoutParams.leftMargin = ViewUtils.b(4.0F);
        ((ImageView)localObject1).setPadding(0, 0, 0, 0);
        ((ImageView)localObject1).setBackgroundDrawable(null);
        i1 = this.m;
        if (i1 == 1)
        {
          ((ImageView)localObject1).setImageResource(2130841087);
        }
        else
        {
          if (i1 == 2)
          {
            i1 = this.n;
            if (i1 != 0)
            {
              ((ImageView)localObject1).setImageResource(i1);
              break label317;
            }
          }
          ((ImageView)localObject1).setImageResource(2130841089);
        }
      }
      label317:
      if (AppSetting.d) {
        AccessibilityUtil.b(this.jdField_a_of_type_AndroidViewView, false);
      }
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localActivity.getApplicationContext().getSystemService("window"));
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("is activity window focused ");
        ((StringBuilder)localObject1).append(localActivity.hasWindowFocus());
        com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, ((StringBuilder)localObject1).toString());
      }
      int i1 = localActivity.getResources().getDisplayMetrics().heightPixels;
      if ((this.k != -1) && (this.e != 0) && (this.l == -1) && (ScreenUtil.isNavigationBarExist(localActivity))) {
        this.jdField_b_of_type_Int = (i1 - localActivity.getResources().getDimensionPixelSize(2131297352) - ScreenUtil.getNavigationBarHeight(localActivity));
      }
      i1 = this.jdField_a_of_type_Int;
      int i2 = this.jdField_b_of_type_Int;
      localObject1 = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
      ((WindowManager.LayoutParams)localObject1).type = 1002;
      ((WindowManager.LayoutParams)localObject1).format = 1;
      ((WindowManager.LayoutParams)localObject1).flags = 40;
      ((WindowManager.LayoutParams)localObject1).gravity = 51;
      ((WindowManager.LayoutParams)localObject1).x = i1;
      ((WindowManager.LayoutParams)localObject1).y = i2;
      ((WindowManager.LayoutParams)localObject1).width = -2;
      ((WindowManager.LayoutParams)localObject1).height = -2;
      ((WindowManager.LayoutParams)localObject1).token = localActivity.getWindow().getDecorView().getWindowToken();
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgConfigData.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    updateUnreadCount(paramInt, false);
    return this.jdField_a_of_type_Boolean;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgConfigData.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371244);
      String str = String.valueOf(paramInt);
      if (paramInt > 99) {
        str = "99+";
      }
      localTextView.setText(str);
      if ((!paramBoolean) && (paramInt > 0)) {
        localTextView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniEntryViewManager
 * JD-Core Version:    0.7.0.1
 */