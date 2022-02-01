package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.ui.AVActivity.AnimationTrigger;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EffectFilterTextPager
  extends EffectCycleViewPager
  implements View.OnTouchListener
{
  Handler c;
  EffectFilterTextPager.FilterTextAdapter d;
  float e = 0.0F;
  float f = 0.0F;
  long g = 0L;
  VideoAppInterface h = null;
  AVActivity.AnimationTrigger i = null;
  private int j;
  
  public EffectFilterTextPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = new EffectFilterTextPager.FilterTextAdapter(paramContext);
    setAdapter(this.d);
    this.c = new EffectFilterTextPager.MyHandler(this);
    setOnTouchListener(this);
    this.j = -1;
  }
  
  void a()
  {
    this.c.removeMessages(1);
    AVLog.printColorLog("EffectFilterTextPager", "showPromotionText ");
    int m = getChildCount();
    int k = 0;
    while (k < m)
    {
      getChildAt(k).setVisibility(0);
      k += 1;
    }
  }
  
  void a(int paramInt)
  {
    AVLog.printColorLog("EffectFilterTextPager", "dispearPromotionText view:");
    this.c.removeMessages(1);
    Message localMessage = this.c.obtainMessage(1);
    this.c.sendMessageDelayed(localMessage, paramInt);
  }
  
  public void a(List<FilterItem> paramList)
  {
    this.d.a(paramList);
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
    int m = getChildCount();
    float f1;
    if (paramBoolean) {
      f1 = 0.6F;
    } else {
      f1 = 1.0F;
    }
    if (paramBoolean) {
      k = 2131298433;
    } else {
      k = 2131298432;
    }
    float f2 = getContext().getResources().getDimension(k);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("changeLayout: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(f1);
    AVLog.printColorLog("EffectFilterTextPager", ((StringBuilder)localObject).toString());
    int k = 0;
    while (k < m)
    {
      localObject = (ImageView)((ViewGroup)getChildAt(k)).findViewById(2131441058);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, (int)f2, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      ((ImageView)localObject).setScaleX(f1);
      ((ImageView)localObject).setScaleY(f1);
      k += 1;
    }
  }
  
  void b()
  {
    View localView = getCurrentView();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dispearPromotionText_internal view:");
    ((StringBuilder)localObject).append(getCurrentItem());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(localView);
    AVLog.printColorLog("EffectFilterTextPager", ((StringBuilder)localObject).toString());
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(450L);
      ((AlphaAnimation)localObject).setAnimationListener(new EffectFilterTextPager.MyTextAlphaAnimationListener(this, localView));
      localView.startAnimation((Animation)localObject);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = Boolean.valueOf(VideoController.f().k().af);
    Object localObject;
    if (paramMotionEvent.getAction() == 0)
    {
      this.e = 0.0F;
      this.f = 0.0F;
      this.g = System.currentTimeMillis();
      this.e = paramMotionEvent.getX();
      this.f = paramMotionEvent.getY();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[childLock] touch onDown: ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" x ");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(" ==========");
        QLog.e("EffectFilterTextPager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.i != null) {
        if (VideoController.f().k().af) {
          this.i.a();
        } else {
          this.i.a(this.e, this.f);
        }
      }
      if (!paramView.booleanValue()) {
        a();
      }
      localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        EditText localEditText = (EditText)((Activity)localObject).findViewById(2131435813);
        if (localEditText != null)
        {
          localEditText.clearFocus();
          ((InputMethodManager)((Activity)localObject).getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
        }
      }
    }
    if ((!VideoController.f().k().af) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.e) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.f) > 70.0F)))))
    {
      this.h.a().removeCallbacks(this.i);
      localObject = this.i;
      if ((localObject != null) && (((AVActivity.AnimationTrigger)localObject).d())) {
        this.i.c();
      }
      if (QLog.isColorLevel()) {
        QLog.e("EffectFilterTextPager", 2, "[childLock] touch end ==========");
      }
    }
    if (paramView.booleanValue())
    {
      if ((paramMotionEvent.getAction() == 1) && (System.currentTimeMillis() - this.g < 200L))
      {
        paramView = this.i;
        if (paramView != null) {
          paramView.b();
        }
      }
      b();
      return true;
    }
    return false;
  }
  
  public void setAnimationTrigger(AVActivity.AnimationTrigger paramAnimationTrigger)
  {
    this.i = paramAnimationTrigger;
  }
  
  public void setApp(VideoAppInterface paramVideoAppInterface)
  {
    this.h = paramVideoAppInterface;
  }
  
  public void setCurrentFilter(FilterItem paramFilterItem)
  {
    int k = this.d.a(paramFilterItem);
    this.j = k;
    setCurrentItem(k + 1, false);
  }
  
  public void setOnFilterListenner(EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    setOnPageChangeListener(new EffectFilterTextPager.MyOnPageChangeListener(this, paramOnEffectFilterChangeListener));
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0)
    {
      a();
      int k;
      if (VideoController.f().k().bK) {
        k = 4000;
      } else {
        k = 1300;
      }
      a(k);
    }
    else
    {
      this.c.removeMessages(1);
      View localView = getCurrentView();
      if (localView != null) {
        localView.clearAnimation();
      }
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager
 * JD-Core Version:    0.7.0.1
 */