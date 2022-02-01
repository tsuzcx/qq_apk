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
  float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  AVActivity.AnimationTrigger jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
  EffectFilterTextPager.FilterTextAdapter jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter;
  float b = 0.0F;
  
  public EffectFilterTextPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter = new EffectFilterTextPager.FilterTextAdapter(paramContext);
    setAdapter(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter);
    this.jdField_a_of_type_AndroidOsHandler = new EffectFilterTextPager.MyHandler(this);
    setOnTouchListener(this);
    this.jdField_a_of_type_Int = -1;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    AVLog.printColorLog("EffectFilterTextPager", "showPromotionText ");
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).setVisibility(0);
      i += 1;
    }
  }
  
  void a(int paramInt)
  {
    AVLog.printColorLog("EffectFilterTextPager", "dispearPromotionText view:");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramInt);
  }
  
  public void a(List<FilterItem> paramList)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramList);
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramBoolean);
    int j = getChildCount();
    float f1;
    if (paramBoolean) {
      f1 = 0.6F;
    } else {
      f1 = 1.0F;
    }
    if (paramBoolean) {
      i = 2131297764;
    } else {
      i = 2131297763;
    }
    float f2 = getContext().getResources().getDimension(i);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("changeLayout: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(f1);
    AVLog.printColorLog("EffectFilterTextPager", ((StringBuilder)localObject).toString());
    int i = 0;
    while (i < j)
    {
      localObject = (ImageView)((ViewGroup)getChildAt(i)).findViewById(2131373385);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, (int)f2, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      ((ImageView)localObject).setScaleX(f1);
      ((ImageView)localObject).setScaleY(f1);
      i += 1;
    }
  }
  
  void b()
  {
    View localView = a();
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
    paramView = Boolean.valueOf(VideoController.a().a().w);
    Object localObject;
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.b = 0.0F;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[childLock] touch onDown: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
        ((StringBuilder)localObject).append(" x ");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(" ==========");
        QLog.e("EffectFilterTextPager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger != null) {
        if (VideoController.a().a().w) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.a();
        } else {
          this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.a(this.jdField_a_of_type_Float, this.b);
        }
      }
      if (!paramView.booleanValue()) {
        a();
      }
      localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        EditText localEditText = (EditText)((Activity)localObject).findViewById(2131368877);
        if (localEditText != null)
        {
          localEditText.clearFocus();
          ((InputMethodManager)((Activity)localObject).getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
        }
      }
    }
    if ((!VideoController.a().a().w) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.b) > 70.0F)))))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger);
      localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger;
      if ((localObject != null) && (((AVActivity.AnimationTrigger)localObject).a())) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.c();
      }
      if (QLog.isColorLevel()) {
        QLog.e("EffectFilterTextPager", 2, "[childLock] touch end ==========");
      }
    }
    if (paramView.booleanValue())
    {
      if ((paramMotionEvent.getAction() == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 200L))
      {
        paramView = this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger;
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
    this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = paramAnimationTrigger;
  }
  
  public void setApp(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void setCurrentFilter(FilterItem paramFilterItem)
  {
    int i = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramFilterItem);
    this.jdField_a_of_type_Int = i;
    setCurrentItem(i + 1, false);
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
      int i;
      if (VideoController.a().a().am) {
        i = 4000;
      } else {
        i = 1300;
      }
      a(i);
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      View localView = a();
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