package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class StickerBubbleTouchDelegate
  implements Handler.Callback, GestureDetector.OnGestureListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private final View jdField_a_of_type_AndroidViewView;
  private final StickerBubbleTouchDelegate.StickerBubbleSendCallbackByGesture jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d = -1;
  
  public StickerBubbleTouchDelegate(StickerBubbleTouchDelegate.StickerBubbleSendCallbackByGesture paramStickerBubbleSendCallbackByGesture, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture = paramStickerBubbleSendCallbackByGesture;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramView.getContext(), this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "finishSendingAction: " + paramInt);
    }
    this.d = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(paramInt, this.c);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void b()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow(arrayOfInt);
    this.jdField_a_of_type_Int = arrayOfInt[0];
    this.jdField_b_of_type_Int = arrayOfInt[1];
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "handleActionUp: " + paramMotionEvent);
      }
      if (this.d <= -1) {
        break label80;
      }
      a(this.d);
    }
    label80:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.e();
      return bool1;
    }
  }
  
  public void a()
  {
    if (this.d > -1) {
      a(this.d);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = b(paramMotionEvent);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (this.d != ((Integer)paramMessage.obj).intValue());
      if (this.c >= this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a())
      {
        a(this.d);
        return true;
      }
      this.c += 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.d, this.c);
      if ((this.c > 2) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.c();
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_b_of_type_Boolean = false;
      }
      paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramMessage.obj);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 80L);
      return true;
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.d();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onDown: " + paramMotionEvent);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onFling: " + paramFloat1 + " / " + paramFloat2);
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onLongPress: " + paramMotionEvent + " on idx: " + i);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onScroll: " + paramFloat1 + " / " + paramFloat2);
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onShowPress: " + paramMotionEvent + " on idx: " + i);
    }
    if (i > -1)
    {
      if (this.d > -1) {
        a(this.d);
      }
      this.d = i;
      b();
      this.jdField_a_of_type_Float = (paramMotionEvent.getX() + this.jdField_a_of_type_Int);
      this.jdField_b_of_type_Float = (paramMotionEvent.getY() + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, i, 1);
      this.c = 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      paramMotionEvent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, Integer.valueOf(i));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMotionEvent, 80L);
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "onSingleTapUp: " + paramMotionEvent + " on idx: " + i);
      }
      if (i > -1)
      {
        b();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(paramMotionEvent.getX() + this.jdField_a_of_type_Int, paramMotionEvent.getY() + this.jdField_b_of_type_Int, i, 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate$StickerBubbleSendCallbackByGesture.a(i, 1);
      }
      this.jdField_a_of_type_Long = l;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate
 * JD-Core Version:    0.7.0.1
 */