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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kdo;
import kdp;
import kdq;
import kdr;

public class EffectFilterTextPager
  extends EffectCycleViewPager
  implements View.OnTouchListener
{
  public float a;
  final int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler;
  public VideoAppInterface a;
  private EffectFilterTools jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools;
  public EffectFilterTextPager.FilterTextAdapter a;
  Runnable jdField_a_of_type_JavaLangRunnable = new kdo(this);
  public boolean a;
  public float b;
  private int b;
  
  public EffectFilterTextPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter = new EffectFilterTextPager.FilterTextAdapter(paramContext);
    setAdapter(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter);
    this.jdField_a_of_type_AndroidOsHandler = new kdp(this);
    setOnTouchListener(this);
    this.jdField_b_of_type_Int = -1;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    AVLog.c("EffectFilterTextPager", "showPromotionText ");
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).setVisibility(0);
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    AVLog.c("EffectFilterTextPager", "dispearPromotionText view:");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramInt);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramList);
  }
  
  @TargetApi(11)
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramBoolean);
    int j = getChildCount();
    float f1;
    if (paramBoolean)
    {
      f1 = 0.6F;
      if (!paramBoolean) {
        break label172;
      }
    }
    label172:
    for (int i = 2131560052;; i = 2131560051)
    {
      float f2 = getContext().getResources().getDimension(i);
      AVLog.c("EffectFilterTextPager", "changeLayout: " + paramBoolean + "|" + j + "|" + f1);
      i = 0;
      while (i < j)
      {
        ImageView localImageView = (ImageView)((ViewGroup)getChildAt(i)).findViewById(2131366264);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
        localLayoutParams.setMargins(localLayoutParams.leftMargin, (int)f2, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
        localImageView.setScaleX(f1);
        localImageView.setScaleY(f1);
        i += 1;
      }
      f1 = 1.0F;
      break;
    }
  }
  
  public void b()
  {
    View localView = a();
    AVLog.c("EffectFilterTextPager", "dispearPromotionText_internal view:" + getCurrentItem() + "|" + localView);
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(450L);
      localAlphaAnimation.setAnimationListener(new kdr(this, localView));
      localView.startAnimation(localAlphaAnimation);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = Boolean.valueOf(VideoController.a().a().u);
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if (QLog.isColorLevel()) {
        QLog.e("EffectFilterTextPager", 2, "[childLock] touch onDown: " + this.jdField_a_of_type_Float + " x " + this.jdField_b_of_type_Float + " ==========");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      if (!paramView.booleanValue()) {
        a();
      }
      Object localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        EditText localEditText = (EditText)((Activity)localObject).findViewById(2131365920);
        if (localEditText != null)
        {
          localEditText.clearFocus();
          ((InputMethodManager)((Activity)localObject).getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
        }
      }
    }
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.jdField_b_of_type_Float) > 70.0F))))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(0) });
        if (QLog.isColorLevel()) {
          QLog.e("EffectFilterTextPager", 2, "[childLock] cancel animation");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("EffectFilterTextPager", 2, "[childLock] touch end ==========");
      }
    }
    if (paramView.booleanValue())
    {
      if ((paramMotionEvent.getAction() == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 200L)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(2) });
      }
      b();
      return true;
    }
    return false;
  }
  
  public void setApp(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools = ((EffectFilterTools)paramVideoAppInterface.a(1));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools);
  }
  
  public void setCurrentFilter(FilterItem paramFilterItem)
  {
    int i = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramFilterItem);
    this.jdField_b_of_type_Int = i;
    setCurrentItem(i + 1, false);
  }
  
  public void setOnFilterListenner(EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    setOnPageChangeListener(new kdq(this, paramOnEffectFilterChangeListener));
  }
  
  public void setVisibility(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      a();
      if (VideoController.a().a().ay)
      {
        i = 4000;
        a(i);
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      i = 1300;
      break;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      View localView = a();
      if (localView != null) {
        localView.clearAnimation();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager
 * JD-Core Version:    0.7.0.1
 */