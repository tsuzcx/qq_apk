package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qphone.base.util.QLog;

public class QCircleDoubleClickLayout
  extends FrameLayout
{
  private static final int a = QCircleConstants.c;
  private boolean b = true;
  private int c;
  private int d;
  private int e;
  private QCircleDoubleClickLayout.OnTapClickListener f;
  private QCircleDoubleClickLayout.OnDoubleClickListener g;
  private QCircleDoubleClickLayout.OnLongClickListener h;
  private final Handler i = new Handler(Looper.getMainLooper());
  private int j;
  private boolean k = false;
  private boolean l = false;
  private MotionEvent m;
  private MotionEvent n;
  private MotionEvent o;
  private MotionEvent p;
  private MotionEvent q;
  private Runnable r = new QCircleDoubleClickLayout.1(this);
  private Runnable s = new QCircleDoubleClickLayout.2(this);
  
  public QCircleDoubleClickLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QCircleDoubleClickLayout(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public QCircleDoubleClickLayout(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, paramMotionEvent.getX(), paramMotionEvent.getY(), 0));
    }
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMotionEvent == null) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = SystemClock.uptimeMillis();
    float f1;
    if (paramBoolean1) {
      f1 = paramMotionEvent.getX() - this.e;
    } else {
      f1 = paramMotionEvent.getX() + this.e;
    }
    float f2;
    if (paramBoolean2) {
      f2 = paramMotionEvent.getY() - this.e;
    } else {
      f2 = paramMotionEvent.getY() + this.e;
    }
    super.dispatchTouchEvent(MotionEvent.obtain(l1, l2, 2, f1, f2, 0));
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      int i1 = (int)paramMotionEvent2.getX() - (int)paramMotionEvent1.getX();
      int i2 = (int)paramMotionEvent2.getY() - (int)paramMotionEvent1.getY();
      bool1 = bool2;
      if (i1 * i1 + i2 * i2 > this.e) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > a) {
        return false;
      }
      if (a(paramMotionEvent1, paramMotionEvent2)) {
        return false;
      }
      int i1 = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      int i2 = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
      bool1 = bool2;
      if (i1 * i1 + i2 * i2 < this.d) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b()
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.c = localViewConfiguration.getScaledDoubleTapSlop();
    int i1 = this.c;
    this.d = (i1 * i1);
    this.e = (localViewConfiguration.getScaledTouchSlop() * localViewConfiguration.getScaledTouchSlop());
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, paramMotionEvent.getX(), paramMotionEvent.getY(), 0));
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null)) {
      return a(paramMotionEvent1, paramMotionEvent2) ^ true;
    }
    return false;
  }
  
  private void c()
  {
    if (b(this.m, this.n))
    {
      a(this.m);
      b(this.n);
      QCircleDoubleClickLayout.OnTapClickListener localOnTapClickListener = this.f;
      if (localOnTapClickListener != null) {
        localOnTapClickListener.a(this.m);
      }
      QLog.d("QCircleDoubleClickLayout", 1, "singleTap success");
      return;
    }
    QLog.d("QCircleDoubleClickLayout", 1, "singleTap error");
  }
  
  private void d()
  {
    if (this.q != null)
    {
      MotionEvent localMotionEvent = this.o;
      if (localMotionEvent != null)
      {
        a(localMotionEvent);
        localMotionEvent = this.q;
        float f1 = this.o.getX();
        float f2 = this.q.getX();
        boolean bool2 = true;
        boolean bool1;
        if (f1 > f2) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (this.o.getY() <= this.q.getY()) {
          bool2 = false;
        }
        a(localMotionEvent, bool1, bool2);
        QLog.d("QCircleDoubleClickLayout", 4, "move success");
        return;
      }
    }
    QLog.d("QCircleDoubleClickLayout", 4, "move error");
  }
  
  public void a()
  {
    this.b = true;
    this.j = 0;
    this.k = false;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.i.removeCallbacks(this.r);
    this.i.removeCallbacks(this.s);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.b)
    {
      QLog.d("QCircleDoubleClickLayout", 4, "not intercept");
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("event:");
    ((StringBuilder)localObject).append(paramMotionEvent.getAction());
    ((StringBuilder)localObject).append(" mIsRunnablePosting:");
    ((StringBuilder)localObject).append(this.k);
    QLog.d("QCircleDoubleClickLayout", 4, ((StringBuilder)localObject).toString());
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.m == null)
      {
        this.m = MotionEvent.obtain(paramMotionEvent);
        this.j = 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("firstdown clickcount:");
        ((StringBuilder)localObject).append(this.j);
        QLog.d("QCircleDoubleClickLayout", 4, ((StringBuilder)localObject).toString());
      }
      if ((this.j >= 1) && (a(this.o, this.p, paramMotionEvent)))
      {
        this.j += 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("considerdown clickcount:");
        ((StringBuilder)localObject).append(this.j);
        QLog.d("QCircleDoubleClickLayout", 4, ((StringBuilder)localObject).toString());
      }
      if (!this.k)
      {
        this.i.postDelayed(this.r, QCircleConstants.c);
        this.i.removeCallbacks(this.s);
        this.i.postDelayed(this.s, QCircleConstants.d);
        this.k = true;
      }
      localObject = this.o;
      if (localObject != null) {
        ((MotionEvent)localObject).recycle();
      }
      this.o = MotionEvent.obtain(paramMotionEvent);
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      this.i.removeCallbacks(this.s);
      if (this.l)
      {
        this.l = false;
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      if (this.n == null) {
        this.n = MotionEvent.obtain(paramMotionEvent);
      }
      localObject = this.p;
      if (localObject != null) {
        ((MotionEvent)localObject).recycle();
      }
      this.p = MotionEvent.obtain(paramMotionEvent);
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      localObject = this.q;
      if (localObject != null) {
        ((MotionEvent)localObject).recycle();
      }
      this.q = MotionEvent.obtain(paramMotionEvent);
      if (a(this.o, this.q))
      {
        this.i.removeCallbacks(this.s);
        d();
        a();
        this.l = true;
      }
    }
    else if (paramMotionEvent.getAction() == 3)
    {
      a();
    }
    if (this.k) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setEnableDoubleClick(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setOnDoubleClickListener(QCircleDoubleClickLayout.OnDoubleClickListener paramOnDoubleClickListener)
  {
    this.g = paramOnDoubleClickListener;
  }
  
  public void setOnLongClickListener(QCircleDoubleClickLayout.OnLongClickListener paramOnLongClickListener)
  {
    this.h = paramOnLongClickListener;
  }
  
  public void setOnTapClickListener(QCircleDoubleClickLayout.OnTapClickListener paramOnTapClickListener)
  {
    this.f = paramOnTapClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout
 * JD-Core Version:    0.7.0.1
 */