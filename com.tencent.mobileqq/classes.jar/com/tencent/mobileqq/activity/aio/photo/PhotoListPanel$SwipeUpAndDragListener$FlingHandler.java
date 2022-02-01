package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.Iterator;

class PhotoListPanel$SwipeUpAndDragListener$FlingHandler
  extends PhotoListPanel.SwipeUpAndDragListener.GestureHandler
{
  public PhotoListPanel$SwipeUpAndDragListener$FlingHandler(PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramSwipeUpAndDragListener, paramContext, paramViewGroup);
  }
  
  private boolean a(int paramInt)
  {
    Object localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getWidth() - (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() - (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F) * 2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = (this.jdField_c_of_type_ArrayOfInt[0] + (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F));
    this.jdField_a_of_type_AndroidViewViewGroup.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Int + (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView, (ViewGroup.LayoutParams)localObject1);
    float f1;
    int j;
    int i;
    int k;
    int m;
    float f2;
    switch (PhotoListPanel.f())
    {
    default: 
      f1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getWidth() - (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() - (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e));
      Logger.a("PhotoListPanel", "startFlingAnim", "f scale = " + f1);
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[0] - (int)(65.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getWidth() * f1 + 0.5F) - this.jdField_c_of_type_ArrayOfInt[0];
      paramInt = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[1];
      k = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getHeight();
      int n = (int)(13.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() * f1 + 0.5F);
      int i1 = this.jdField_c_of_type_ArrayOfInt[1];
      m = ((RelativeLayout.LayoutParams)localObject1).topMargin - (int)(30.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e);
      k = paramInt + i - k - n - i1 + m;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.c);
      f2 = ((LocalMediaInfo)localObject1).mediaHeight * 1.0F / ((LocalMediaInfo)localObject1).mediaWidth;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(this.jdField_b_of_type_Int) == 1)
      {
        paramInt = k - (int)(70.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F);
        i = j;
      }
      break;
    }
    for (;;)
    {
      localObject1 = new AnimationSet(false);
      Object localObject2 = new ScaleAnimation(1.0F, f1, 1.0F, f1);
      ((ScaleAnimation)localObject2).setStartOffset(200L);
      ((ScaleAnimation)localObject2).setDuration(300L);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
      localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -m);
      ((TranslateAnimation)localObject2).setStartOffset(0L);
      ((TranslateAnimation)localObject2).setDuration(200L);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
      localObject2 = new AnimationSet(false);
      ((AnimationSet)localObject2).setStartOffset(200L);
      ((AnimationSet)localObject2).setDuration(300L);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, i, 0.0F, 0.0F);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject2).setStartOffset(200L + 300L - 200L / 2L);
      ((AlphaAnimation)localObject2).setDuration(200L);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
      this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.startAnimation((Animation)localObject1);
      ((AnimationSet)localObject1).setAnimationListener(new PhotoListPanel.SwipeUpAndDragListener.FlingHandler.1(this));
      return true;
      f1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() - (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e));
      break;
      paramInt = k;
      i = j;
      if (PhotoListPanel.f() == 1) {
        if (((LocalMediaInfo)localObject1).mediaHeight > ((LocalMediaInfo)localObject1).mediaWidth)
        {
          paramInt = k - (int)((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() - (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e)) * 0.5F * (f2 - 1.0F) * f1);
          i = j;
        }
        else
        {
          i = j - (int)((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter$RecyclerHolder.itemView.getHeight() - (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e)) * 0.5F * (1.0F / f2 - 1.0F) * f1);
          paramInt = k;
        }
      }
    }
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    return true;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    Logger.a("PhotoListPanel", "handleUp", "handler = " + this);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = f2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Float;
    float f4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Float;
    int i = paramMotionEvent.getPointerId(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    float f5 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
    Logger.a("PhotoListPanel", "FlingHandler", "@@handleUp,x = " + f1 + ",y = " + f2 + ",delY = " + f3 + ",velocityY = " + f5 + ",SWIPE_THRESHOLD = " + PhotoListPanel.SwipeUpAndDragListener.b());
    if ((-f3 > PhotoListPanel.SwipeUpAndDragListener.b()) && (Math.abs(f5) > 100.0F) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Long < 500L) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 0)) && (Math.abs(f3) > Math.abs(f1 - f4)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a.size() == 0)
      {
        Logger.a("PhotoListPanel", "handleUp", "handler = " + this + "mInfos is null!!!!!! targetPosition=" + this.jdField_b_of_type_Int);
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
      if (!a(this.jdField_b_of_type_Int))
      {
        Logger.a("PhotoListPanel", "handleUp", "handler  animLayout already hasparent= ");
        return false;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(this.jdField_b_of_type_Int);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.jdField_b_of_type_Int).path);
      ReportController.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", this.jdField_b_of_type_Int + 1, 0, "1", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A914", "0X800A914", PhotoUtils.getTypeforReport2(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo), 0, "" + (this.jdField_b_of_type_Int + 1), "", "", "");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack != null)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(this.jdField_b_of_type_Int).path;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c == 2)
        {
          bool = true;
          paramMotionEvent.a((String)localObject, bool);
        }
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if (QFileAssistantUtils.a(paramMotionEvent.jdField_a_of_type_JavaLangString))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(str, paramMotionEvent.jdField_a_of_type_JavaLangString, paramMotionEvent.jdField_a_of_type_JavaLangString, paramMotionEvent.jdField_a_of_type_Int, true);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(this.jdField_b_of_type_Int, (ArrayList)localObject, false, true, "0X8005E0D", "1", i + "", false);
        }
      }
    }
    Logger.a("PhotoListPanel", "FlingHandler", "@handleUp,return false. velocityY = " + f5 + ",dely = " + (f2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Float));
    return (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Long >= 200L) || (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Float) >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Int) || (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Float) >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.FlingHandler
 * JD-Core Version:    0.7.0.1
 */