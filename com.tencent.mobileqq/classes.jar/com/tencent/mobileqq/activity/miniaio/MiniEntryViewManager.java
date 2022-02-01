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
  ValueAnimator a;
  private WindowManager.LayoutParams b;
  private WindowManager c;
  private Activity d;
  private View e;
  private final GestureDetector f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private boolean m;
  private float n;
  private float o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private View.OnClickListener v;
  private MiniMsgConfigData w;
  private int x;
  private int y;
  
  public MiniEntryViewManager(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View.OnClickListener paramOnClickListener)
  {
    this.d = paramActivity;
    this.j = paramInt1;
    this.k = paramInt2;
    this.x = paramInt3;
    this.y = paramInt4;
    this.t = paramInt5;
    this.u = paramInt6;
    this.i = ImmersiveUtils.getStatusBarHeight(this.d);
    paramActivity = BaseApplicationImpl.getApplication().getBaseContext();
    paramInt1 = paramActivity.getResources().getDisplayMetrics().widthPixels;
    paramInt3 = paramActivity.getResources().getDisplayMetrics().heightPixels;
    paramInt4 = paramActivity.getResources().getDimensionPixelSize(2131297818);
    int i1 = paramActivity.getResources().getDimensionPixelSize(2131297819);
    int i3 = paramActivity.getResources().getDimensionPixelSize(2131297817);
    int i2 = ViewUtils.dpToPx(56.0F);
    this.l = paramInt1;
    this.r = paramInt4;
    this.s = (paramInt3 - i3);
    i3 = this.i;
    int i4 = ViewUtils.dip2px(7.0F);
    int i5 = this.r;
    if (paramInt5 != -1)
    {
      this.g = paramInt5;
      this.h = paramInt6;
    }
    else if (paramInt2 != 0)
    {
      this.g = (paramInt1 - paramInt4 * 4);
      this.h = (i3 + i4);
    }
    else
    {
      this.g = (paramInt1 - i2 - i5);
      this.h = (paramInt3 - i1);
    }
    this.v = paramOnClickListener;
    this.f = new GestureDetector(paramActivity, new MiniEntryViewManager.1(this));
    this.w = MiniMsgConfigProcessor.a();
    if (this.w == null) {
      this.w = new MiniMsgConfigData();
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("configData : ");
      paramActivity.append(this.w.toString());
      com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, paramActivity.toString());
    }
  }
  
  private void b()
  {
    if (this.a == null)
    {
      this.a = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.a.setDuration(200L);
      this.a.addListener(this);
      this.a.addUpdateListener(this);
    }
    this.a.start();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (!this.m) {
      return;
    }
    int i2 = this.i;
    int i1 = paramInt2;
    if (paramInt2 < i2) {
      i1 = i2;
    }
    paramInt2 = this.s;
    i2 = i1;
    if (i1 > paramInt2) {
      i2 = paramInt2;
    }
    i1 = this.r;
    paramInt2 = paramInt1;
    if (paramInt1 < i1) {
      paramInt2 = i1;
    }
    i1 = this.g;
    paramInt1 = paramInt2;
    if (paramInt2 > i1) {
      paramInt1 = i1;
    }
    WindowManager.LayoutParams localLayoutParams = this.b;
    localLayoutParams.y = i2;
    localLayoutParams.x = paramInt1;
    this.c.updateViewLayout(paramView, localLayoutParams);
  }
  
  public int[] a()
  {
    WindowManager.LayoutParams localLayoutParams = this.b;
    if (localLayoutParams == null) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    if (localLayoutParams != null)
    {
      arrayOfInt[0] = localLayoutParams.x;
      arrayOfInt[1] = this.b.y;
    }
    return arrayOfInt;
  }
  
  public void destroy()
  {
    if (this.m)
    {
      this.c.removeViewImmediate(this.e);
      this.m = false;
    }
    this.d = null;
    this.e = null;
  }
  
  public void hide()
  {
    if (this.m) {
      this.e.setVisibility(8);
    }
  }
  
  public void hideUnread()
  {
    if (this.m) {
      this.e.findViewById(2131438588).setVisibility(8);
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
    int i1 = this.g;
    if (this.p < this.l / 2) {
      i1 = this.r;
    }
    int i2 = this.p;
    i1 = i2 + (int)((i1 - i2) * f1);
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("onAnimationUpdate .curPx = ");
    paramValueAnimator.append(i1);
    paramValueAnimator.append(" ,mTouchUpX = ");
    paramValueAnimator.append(this.p);
    com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, paramValueAnimator.toString());
    i2 = this.q;
    a(this.e, i1, i2);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ValueAnimator localValueAnimator = this.a;
    int i1 = 0;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return false;
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = this.f.onTouchEvent(paramMotionEvent);
    if (this.k != 0) {
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
          a(paramView, (int)(f1 - this.n), (int)(f2 - this.o));
          break label185;
        }
      }
      a(paramView, (int)(f1 - this.n), (int)(f2 - this.o));
      this.p = ((int)(f1 - this.n));
      this.q = ((int)(f2 - this.o));
      this.o = 0.0F;
      this.n = 0.0F;
      i1 = 1;
    }
    else
    {
      this.n = paramMotionEvent.getX();
      this.o = paramMotionEvent.getY();
    }
    label185:
    if ((!bool) && (i1 != 0)) {
      b();
    }
    return true;
  }
  
  public boolean show(int paramInt)
  {
    if (!this.d.hasWindowFocus()) {
      return false;
    }
    Activity localActivity = this.d;
    Object localObject1;
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("styleType = ");
      ((StringBuilder)localObject1).append(this.k);
      ((StringBuilder)localObject1).append(",filterType = ");
      ((StringBuilder)localObject1).append(this.j);
      com.tencent.qphone.base.util.QLog.d("mini_msg_FloatViewManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.e == null)
    {
      this.e = View.inflate(localActivity.getApplicationContext(), 2131625362, null);
      this.e.setOnTouchListener(this);
      Object localObject3 = (RelativeLayout)this.e.findViewById(2131438586);
      localObject1 = (ImageView)this.e.findViewById(2131438587);
      Object localObject2 = (TextView)this.e.findViewById(2131438588);
      localObject3 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
      if (this.k != 0)
      {
        i1 = ViewUtils.dpToPx(38.0F);
        i2 = ViewUtils.dpToPx(32.0F);
        ((RelativeLayout.LayoutParams)localObject3).width = i1;
        ((RelativeLayout.LayoutParams)localObject3).height = i2;
        i1 = ViewUtils.dpToPx(24.0F);
        localLayoutParams.width = i1;
        localLayoutParams.height = i1;
        localLayoutParams.leftMargin = ViewUtils.dpToPx(4.0F);
        ((ImageView)localObject1).setPadding(0, 0, 0, 0);
        ((ImageView)localObject1).setBackgroundDrawable(null);
        i1 = this.x;
        if (i1 == 1)
        {
          ((ImageView)localObject1).setImageResource(2130841878);
        }
        else
        {
          if (i1 == 2)
          {
            i1 = this.y;
            if (i1 != 0)
            {
              ((ImageView)localObject1).setImageResource(i1);
              break label317;
            }
          }
          ((ImageView)localObject1).setImageResource(2130841880);
        }
      }
      label317:
      if (AppSetting.e) {
        AccessibilityUtil.b(this.e, false);
      }
      this.c = ((WindowManager)localActivity.getApplicationContext().getSystemService("window"));
      this.b = new WindowManager.LayoutParams();
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("is activity window focused ");
        ((StringBuilder)localObject1).append(localActivity.hasWindowFocus());
        com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, ((StringBuilder)localObject1).toString());
      }
      int i1 = localActivity.getResources().getDisplayMetrics().heightPixels;
      if ((this.t != -1) && (this.k != 0) && (this.u == -1) && (ScreenUtil.isNavigationBarExist(localActivity))) {
        this.h = (i1 - localActivity.getResources().getDimensionPixelSize(2131297819) - ScreenUtil.getNavigationBarHeight(localActivity));
      }
      i1 = this.g;
      int i2 = this.h;
      localObject1 = this.b;
      ((WindowManager.LayoutParams)localObject1).type = 1002;
      ((WindowManager.LayoutParams)localObject1).format = 1;
      ((WindowManager.LayoutParams)localObject1).flags = 40;
      ((WindowManager.LayoutParams)localObject1).gravity = 51;
      ((WindowManager.LayoutParams)localObject1).x = i1;
      ((WindowManager.LayoutParams)localObject1).y = i2;
      ((WindowManager.LayoutParams)localObject1).width = -2;
      ((WindowManager.LayoutParams)localObject1).height = -2;
      ((WindowManager.LayoutParams)localObject1).token = localActivity.getWindow().getDecorView().getWindowToken();
      this.c.addView(this.e, this.b);
      this.m = true;
    }
    if (this.m) {
      this.e.setVisibility(0);
    }
    if (!this.w.a) {
      this.e.setVisibility(8);
    }
    updateUnreadCount(paramInt, false);
    return this.m;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    if (this.m)
    {
      if (this.w.a) {
        this.e.setVisibility(0);
      }
      TextView localTextView = (TextView)this.e.findViewById(2131438588);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniEntryViewManager
 * JD-Core Version:    0.7.0.1
 */