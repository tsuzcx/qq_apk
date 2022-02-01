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
import com.tencent.mobileqq.qqcommon.api.IHapticManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class StickerBubbleTouchDelegate
  implements Handler.Callback, GestureDetector.OnGestureListener
{
  private static boolean jdField_b_of_type_Boolean = false;
  private static boolean jdField_c_of_type_Boolean = false;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private final View jdField_a_of_type_AndroidViewView;
  private final StickerBubbleSendCallback jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_sticker40";
  protected boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g = true;
  
  public StickerBubbleTouchDelegate(StickerBubbleSendCallback paramStickerBubbleSendCallback, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback = paramStickerBubbleSendCallback;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.f = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramView.getContext(), this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (QLog.isColorLevel())
    {
      paramStickerBubbleSendCallback = new StringBuilder();
      paramStickerBubbleSendCallback.append("mIsSupportFeedBack = ");
      paramStickerBubbleSendCallback.append(this.f);
      QLog.d("StickerBubbleGesture", 2, paramStickerBubbleSendCallback.toString());
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finishSendingAction: ");
      localStringBuilder.append(paramInt);
      QLog.d("StickerBubbleGesture", 2, localStringBuilder.toString());
    }
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(paramInt, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
    this.e = true;
    jdField_b_of_type_Boolean = false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool1 = false;
    boolean bool2 = false;
    if ((i == 1) || (paramMotionEvent.getAction() == 3))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleActionUp: ");
        localStringBuilder.append(paramMotionEvent);
        QLog.d("StickerBubbleGesture", 2, localStringBuilder.toString());
      }
      i = this.jdField_d_of_type_Int;
      bool1 = bool2;
      if (i > -1)
      {
        a(i);
        bool1 = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.e();
    }
    return bool1;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) && (this.jdField_d_of_type_Int > -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(paramMotionEvent.getX(), paramMotionEvent.getY())))
    {
      a(this.jdField_d_of_type_Int);
      return true;
    }
    return false;
  }
  
  private void d()
  {
    if (this.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.d();
      this.e = false;
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  private void e()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow(arrayOfInt);
    this.jdField_a_of_type_Int = arrayOfInt[0];
    this.jdField_b_of_type_Int = arrayOfInt[1];
  }
  
  public void a()
  {
    jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.e = true;
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = b(paramMotionEvent);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = c(paramMotionEvent);
    }
    bool2 = bool1;
    if (!bool1)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_Float = paramMotionEvent.getX();
        this.jdField_d_of_type_Float = paramMotionEvent.getY();
      }
      bool2 = bool1;
      if (this.g) {
        bool2 = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
    return bool2;
  }
  
  public void b()
  {
    jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, Integer.valueOf(this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void c()
  {
    int i = this.jdField_d_of_type_Int;
    if (i > -1) {
      a(i);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      d();
      return true;
    }
    if (this.jdField_d_of_type_Int == ((Integer)paramMessage.obj).intValue())
    {
      if (jdField_c_of_type_Boolean) {
        return true;
      }
      this.jdField_c_of_type_Int += 1;
      if (this.jdField_c_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a())
      {
        a(this.jdField_d_of_type_Int);
        return true;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        float f1 = this.jdField_c_of_type_Float;
        if (f1 != 0.0F)
        {
          f1 += this.jdField_a_of_type_Int;
          float f2 = this.jdField_d_of_type_Float + this.jdField_b_of_type_Int;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("touchX = ");
          localStringBuilder.append(f1);
          localStringBuilder.append("  touchY = ");
          localStringBuilder.append(f2);
          QLog.d("StickerBubbleGesture", 2, localStringBuilder.toString());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(f1, f2, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
          break label221;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
      label221:
      if (this.f) {
        ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.jdField_a_of_type_JavaLangString, 2);
      }
      d();
      if ((this.jdField_c_of_type_Int > 2) && (!this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.c();
        this.jdField_d_of_type_Boolean = true;
      }
      paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramMessage.obj);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 80L);
    }
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDown: ");
      localStringBuilder.append(paramMotionEvent);
      QLog.d("StickerBubbleGesture", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (i >= 0)
    {
      if (jdField_b_of_type_Boolean) {
        return;
      }
      int j = this.jdField_d_of_type_Int;
      if (j > -1) {
        a(j);
      }
      this.jdField_d_of_type_Int = i;
      e();
      this.jdField_a_of_type_Float = (paramMotionEvent.getX() + this.jdField_a_of_type_Int);
      this.jdField_b_of_type_Float = (paramMotionEvent.getY() + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, i, 1);
      if (this.f)
      {
        ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.jdField_a_of_type_JavaLangString, 2);
      }
      else if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("onShowPress isTouchEffectSupport = ");
        paramMotionEvent.append(this.f);
        QLog.d("StickerBubbleGesture", 2, paramMotionEvent.toString());
      }
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      jdField_b_of_type_Boolean = true;
      paramMotionEvent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, Integer.valueOf(i));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMotionEvent, 80L);
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 300L)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSingleTapUp: ");
        localStringBuilder.append(paramMotionEvent);
        localStringBuilder.append(" on idx: ");
        localStringBuilder.append(i);
        QLog.d("StickerBubbleGesture", 2, localStringBuilder.toString());
      }
      if (i > -1)
      {
        e();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(paramMotionEvent.getX() + this.jdField_a_of_type_Int, paramMotionEvent.getY() + this.jdField_b_of_type_Int, i, 1);
        if (this.f)
        {
          ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.jdField_a_of_type_JavaLangString, 2);
        }
        else if (QLog.isColorLevel())
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("onSingleTapUp isTouchEffectSupport = ");
          paramMotionEvent.append(this.f);
          QLog.d("StickerBubbleGesture", 2, paramMotionEvent.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleSendCallback.a(i, 1);
      }
      this.jdField_a_of_type_Long = l;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate
 * JD-Core Version:    0.7.0.1
 */