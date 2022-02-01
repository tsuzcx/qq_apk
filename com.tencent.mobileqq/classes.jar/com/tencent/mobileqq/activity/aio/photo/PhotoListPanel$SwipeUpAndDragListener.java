package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class PhotoListPanel$SwipeUpAndDragListener
  implements View.OnTouchListener
{
  private static int jdField_e_of_type_Int = 60;
  private static int jdField_f_of_type_Int = 300;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  PhotoListPanel.SwipeUpAndDragCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack;
  PhotoListPanel.SwipeUpAndDragListener.GestureHandler jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler;
  PhotoListPanel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  PhotoListPanel.SwipeUpAndDragListener.GestureHandler jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler;
  AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  PhotoListPanel.SwipeUpAndDragListener.GestureHandler jdField_c_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  float jdField_e_of_type_Float;
  float jdField_f_of_type_Float = 0.7F;
  float g;
  
  public PhotoListPanel$SwipeUpAndDragListener(Context paramContext, ViewGroup paramViewGroup, int[] paramArrayOfInt, int paramInt, PhotoListPanel.SwipeUpAndDragCallBack paramSwipeUpAndDragCallBack, PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack = paramSwipeUpAndDragCallBack;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = paramPhotoListPanel;
    this.jdField_e_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    Logger.a("PhotoListPanel", "detectGesture", "SwipeUpAndDragListener.mTouchSlop = " + this.jdField_b_of_type_Int);
    jdField_e_of_type_Int = (int)(30.0F * this.jdField_e_of_type_Float);
    switch (PhotoListPanel.f())
    {
    }
    for (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler = new PhotoListPanel.SwipeUpAndDragListener.FlingHandler(this, paramContext, paramViewGroup);; this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler = new PhotoListPanel.SwipeUpAndDragListener.GestureHandler(this, paramContext, paramViewGroup))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler = new PhotoListPanel.SwipeUpAndDragListener.DragHandler(this, paramContext, paramViewGroup);
      return;
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Float = paramMotionEvent.getX();
    this.jdField_b_of_type_Float = paramMotionEvent.getY();
    Logger.a("PhotoListPanel", "onTouch", " ACTION_DOWN,x = " + this.jdField_a_of_type_Float + ",y = " + this.jdField_b_of_type_Float);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean) {
      a(paramMotionEvent);
    }
    return false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Logger.a("PhotoListPanel", "onTouch", " ACTION_MOVE,x = " + f1 + ",y = " + f2 + ",mGestureHandler = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler);
    if ((this.jdField_c_of_type_Float == f1) && (this.jdField_d_of_type_Float == f2)) {
      return false;
    }
    float f3 = this.jdField_a_of_type_Float;
    float f4 = this.jdField_b_of_type_Float;
    if (PhotoListPanel.f() == 1)
    {
      if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < jdField_f_of_type_Int) && ((Math.abs(this.jdField_c_of_type_Float - paramMotionEvent.getX()) > this.jdField_b_of_type_Int) || (Math.abs(this.jdField_d_of_type_Float - paramMotionEvent.getY()) > this.jdField_b_of_type_Int))) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        return false;
      }
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    PhotoListPanel.PhotoPanelAdapter.RecyclerHolder localRecyclerHolder = (PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(this.jdField_c_of_type_Int);
    if (localRecyclerHolder == null) {
      return false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (PhotoListPanel.f() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler = a(paramMotionEvent, f1 - f3, f2 - f4);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler != null) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.a(localRecyclerHolder, this.jdField_c_of_type_Int);
        }
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.a(paramMotionEvent);
    }
    return false;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Logger.a("PhotoListPanel", "onTouch", " ACTION_UP,x = " + f1 + ",y = " + f2);
    if (PhotoListPanel.f() == 1) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.b(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler = null;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      return bool;
    }
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 0)) && (Math.abs(f2 - this.jdField_b_of_type_Float) > Math.abs(f1 - this.jdField_a_of_type_Float)) && ((l > 200L) || (Math.abs(f2 - this.jdField_b_of_type_Float) > this.jdField_b_of_type_Int) || (Math.abs(f1 - this.jdField_a_of_type_Float) > this.jdField_b_of_type_Int)))
    {
      Logger.a("PhotoListPanel", "onTouch", " ACTION_UP,eat up event.dx = " + Math.abs(f1 - this.jdField_a_of_type_Float) + ",dy = " + Math.abs(f2 - this.jdField_b_of_type_Float) + ",duration = " + l);
      return true;
    }
    return false;
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Logger.a("PhotoListPanel", "onTouch", " ACTION_CANCEL,x = " + f1 + ",y = " + f2);
    if (PhotoListPanel.f() == 1) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    ThreadManagerV2.getUIHandlerV2().post(new PhotoListPanel.SwipeUpAndDragListener.1(this));
    return false;
  }
  
  float a(int paramInt1, int paramInt2)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(paramInt1);
    float f1;
    if (i == 1) {
      f1 = 1168.0F / (paramInt2 * this.jdField_e_of_type_Float);
    }
    for (;;)
    {
      Logger.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f1 + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.mediaWidth + ",info.mediaHeight = " + localLocalMediaInfo.mediaHeight + ",sideLength = " + paramInt2);
      return f1;
      f1 = localLocalMediaInfo.mediaHeight * 1.0F / localLocalMediaInfo.mediaWidth;
      if ((localLocalMediaInfo.mediaWidth > 100) || (localLocalMediaInfo.mediaHeight > 100))
      {
        if (localLocalMediaInfo.mediaHeight > localLocalMediaInfo.mediaWidth) {
          f1 = 1168.0F / (f1 * paramInt2 * this.jdField_e_of_type_Float);
        } else {
          f1 = f1 * 1168.0F / (paramInt2 * this.jdField_e_of_type_Float);
        }
      }
      else if (localLocalMediaInfo.mediaHeight > localLocalMediaInfo.mediaWidth) {
        f1 = paramInt2 * 2336.0F / (f1 * this.jdField_e_of_type_Float);
      } else {
        f1 = f1 * 2336.0F / (paramInt2 * this.jdField_e_of_type_Float);
      }
    }
  }
  
  float a(int paramInt1, int paramInt2, int paramInt3)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.getItemViewType(paramInt1);
    float f1;
    if (i == 1) {
      f1 = 160.0F * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
    }
    for (;;)
    {
      Logger.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f1 + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.mediaWidth + ",info.mediaHeight = " + localLocalMediaInfo.mediaHeight);
      return f1;
      if ((localLocalMediaInfo.mediaWidth > 100) || (localLocalMediaInfo.mediaHeight > 100)) {
        f1 = 135.0F * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
      } else {
        f1 = Math.max(localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight) * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
      }
    }
  }
  
  PhotoListPanel.SwipeUpAndDragListener.GestureHandler a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_Boolean = true;
      i = paramMotionEvent.findPointerIndex(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
      if (-f1 > 1500.0F)
      {
        bool1 = true;
        if (paramFloat2 >= 0.0F) {
          break label396;
        }
        bool2 = true;
        label82:
        if (Math.abs(paramFloat1 / paramFloat2) >= 1.0F) {
          break label402;
        }
      }
      label396:
      label402:
      for (bool3 = true;; bool3 = false)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 0)) {
          bool4 = true;
        }
        Logger.a("PhotoListPanel", "detectGesture", "Xvelocity=" + this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) + "Yvelocity=" + f1 + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4 + ",mGestureHandler = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler);
        Logger.a("PhotoListPanel", "detectGesture", "mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler != null) || (!bool2) || (!bool3) || (!bool4)) {
          break label797;
        }
        Logger.a("PhotoListPanel", "detectGesture", "return mDragHandler.");
        return this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler;
        bool1 = false;
        break;
        bool2 = false;
        break label82;
      }
    }
    int i = paramMotionEvent.findPointerIndex(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
    if (-f1 > 3000.0F)
    {
      bool1 = true;
      if (paramFloat2 >= 0.0F) {
        break label785;
      }
      bool2 = true;
      label469:
      if (Math.abs(paramFloat1 / paramFloat2) >= 1.0F) {
        break label791;
      }
    }
    label785:
    label791:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 1)
      {
        bool4 = bool5;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 0) {}
      }
      else
      {
        bool4 = true;
      }
      Logger.a("PhotoListPanel", "detectGesture", "2 Xvelocity=" + this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) + "Yvelocity=" + f1 + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4);
      Logger.a("PhotoListPanel", "detectGesture", "2 mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler != null) || (!bool2) || (!bool3) || (!bool4) || (!bool1)) {
        break label797;
      }
      this.jdField_a_of_type_Boolean = true;
      Logger.a("PhotoListPanel", "detectGesture", "return mFlingHandler.");
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler;
      bool1 = false;
      break;
      bool2 = false;
      break label469;
    }
    label797:
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler = null;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findChildViewUnder(f1, f2);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAdapterPosition(localView);
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_d_of_type_Int = paramMotionEvent.getPointerId(0);
      Logger.a("PhotoListPanel", "onTouch", " touchFirstActtion,mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      ThreadManager.getUIHandler().postDelayed(new PhotoListPanel.SwipeUpAndDragListener.2(this), 100L);
      if (PhotoListPanel.f() == 1)
      {
        ThreadManager.getUIHandler().postDelayed(new PhotoListPanel.SwipeUpAndDragListener.3(this), jdField_f_of_type_Int);
        paramMotionEvent = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 0) {
          break label218;
        }
      }
    }
    for (;;)
    {
      paramMotionEvent.set(bool);
      return;
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      break;
      label218:
      bool = false;
    }
  }
  
  void b()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler != null) && (this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.a())) {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.b();
    }
    while ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler == null) || (!this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.a())) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.b();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Logger.a("PhotoListPanel", "onTouch", "x = " + f1 + ",y = " + f2 + ",event = " + paramMotionEvent + ", mPanel.mDisableGuestrueSend = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean) {
      return true;
    }
    switch (i)
    {
    default: 
      return false;
    case 0: 
      return a(paramMotionEvent);
    case 2: 
      return b(paramMotionEvent);
    case 1: 
      return c(paramMotionEvent);
    }
    return d(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener
 * JD-Core Version:    0.7.0.1
 */