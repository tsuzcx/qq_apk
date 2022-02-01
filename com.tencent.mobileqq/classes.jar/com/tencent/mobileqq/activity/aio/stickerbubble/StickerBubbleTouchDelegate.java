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
  private static boolean b = false;
  private static boolean c = false;
  protected boolean a;
  private final StickerBubbleSendCallback d;
  private final GestureDetector e;
  private final View f;
  private final Handler g;
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private int l;
  private int m = -1;
  private float n;
  private float o;
  private long p;
  private float q;
  private float r;
  private boolean s;
  private String t = "chat_item_for_sticker40";
  private boolean u = true;
  
  public StickerBubbleTouchDelegate(StickerBubbleSendCallback paramStickerBubbleSendCallback, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramStickerBubbleSendCallback;
    this.f = paramView;
    this.s = paramBoolean1;
    this.a = paramBoolean2;
    this.e = new GestureDetector(paramView.getContext(), this);
    this.g = new Handler(Looper.getMainLooper(), this);
    if (QLog.isColorLevel())
    {
      paramStickerBubbleSendCallback = new StringBuilder();
      paramStickerBubbleSendCallback.append("mIsSupportFeedBack = ");
      paramStickerBubbleSendCallback.append(this.s);
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
    this.m = -1;
    this.d.a(paramInt, this.l);
    this.g.sendEmptyMessageDelayed(2, 3000L);
    this.k = true;
    b = false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    boolean bool1 = false;
    boolean bool2 = false;
    if ((i1 == 1) || (paramMotionEvent.getAction() == 3))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleActionUp: ");
        localStringBuilder.append(paramMotionEvent);
        QLog.d("StickerBubbleGesture", 2, localStringBuilder.toString());
      }
      i1 = this.m;
      bool1 = bool2;
      if (i1 > -1)
      {
        a(i1);
        bool1 = true;
      }
      this.d.e();
    }
    return bool1;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) && (this.m > -1) && (this.d.c(paramMotionEvent.getX(), paramMotionEvent.getY())))
    {
      a(this.m);
      return true;
    }
    return false;
  }
  
  private void d()
  {
    if (this.k)
    {
      this.d.d();
      this.k = false;
      this.j = false;
    }
  }
  
  private void e()
  {
    int[] arrayOfInt = new int[2];
    this.f.getLocationInWindow(arrayOfInt);
    this.h = arrayOfInt[0];
    this.i = arrayOfInt[1];
  }
  
  public void a()
  {
    c = true;
    this.g.removeCallbacksAndMessages(null);
    this.k = true;
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
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
      if (this.a)
      {
        this.q = paramMotionEvent.getX();
        this.r = paramMotionEvent.getY();
      }
      bool2 = bool1;
      if (this.u) {
        bool2 = this.e.onTouchEvent(paramMotionEvent);
      }
    }
    return bool2;
  }
  
  public void b()
  {
    c = false;
    this.g.removeCallbacksAndMessages(null);
    Message localMessage = this.g.obtainMessage(1, Integer.valueOf(this.m));
    this.g.sendMessage(localMessage);
  }
  
  public void c()
  {
    int i1 = this.m;
    if (i1 > -1) {
      a(i1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return true;
      }
      d();
      return true;
    }
    if (this.m == ((Integer)paramMessage.obj).intValue())
    {
      if (c) {
        return true;
      }
      this.l += 1;
      if (this.l >= this.d.getMaxSendCount())
      {
        a(this.m);
        return true;
      }
      if (this.a)
      {
        float f1 = this.q;
        if (f1 != 0.0F)
        {
          f1 += this.h;
          float f2 = this.r + this.i;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("touchX = ");
          localStringBuilder.append(f1);
          localStringBuilder.append("  touchY = ");
          localStringBuilder.append(f2);
          QLog.d("StickerBubbleGesture", 2, localStringBuilder.toString());
          this.d.a(f1, f2, this.m, this.l);
          break label221;
        }
      }
      this.d.a(this.n, this.o, this.m, this.l);
      label221:
      if (this.s) {
        ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.t, 2);
      }
      d();
      if ((this.l > 2) && (!this.j))
      {
        this.d.c();
        this.j = true;
      }
      paramMessage = this.g.obtainMessage(1, paramMessage.obj);
      this.g.sendMessageDelayed(paramMessage, 80L);
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
    this.d.b(paramMotionEvent.getX(), paramMotionEvent.getY());
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
    int i1 = this.d.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (i1 >= 0)
    {
      if (b) {
        return;
      }
      int i2 = this.m;
      if (i2 > -1) {
        a(i2);
      }
      this.m = i1;
      e();
      this.n = (paramMotionEvent.getX() + this.h);
      this.o = (paramMotionEvent.getY() + this.i);
      this.d.a(this.n, this.o, i1, 1);
      if (this.s)
      {
        ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.t, 2);
      }
      else if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("onShowPress isTouchEffectSupport = ");
        paramMotionEvent.append(this.s);
        QLog.d("StickerBubbleGesture", 2, paramMotionEvent.toString());
      }
      this.l = 1;
      this.g.removeMessages(1);
      b = true;
      paramMotionEvent = this.g.obtainMessage(1, Integer.valueOf(i1));
      this.g.sendMessageDelayed(paramMotionEvent, 80L);
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    long l1 = SystemClock.uptimeMillis();
    if (l1 - this.p > 300L)
    {
      int i1 = this.d.a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSingleTapUp: ");
        localStringBuilder.append(paramMotionEvent);
        localStringBuilder.append(" on idx: ");
        localStringBuilder.append(i1);
        QLog.d("StickerBubbleGesture", 2, localStringBuilder.toString());
      }
      if (i1 > -1)
      {
        e();
        this.d.a(paramMotionEvent.getX() + this.h, paramMotionEvent.getY() + this.i, i1, 1);
        if (this.s)
        {
          ((IHapticManagerApi)QRoute.api(IHapticManagerApi.class)).playEffect(this.t, 2);
        }
        else if (QLog.isColorLevel())
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("onSingleTapUp isTouchEffectSupport = ");
          paramMotionEvent.append(this.s);
          QLog.d("StickerBubbleGesture", 2, paramMotionEvent.toString());
        }
        this.d.a(i1, 1);
      }
      this.p = l1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate
 * JD-Core Version:    0.7.0.1
 */