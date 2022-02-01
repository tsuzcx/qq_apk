package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.av.widget.api.IChildLockCircleApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ChildLockCircle
  extends View
  implements Handler.Callback, Animation.AnimationListener
{
  public Handler a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private Bitmap g;
  private Bitmap h;
  private Bitmap i;
  private boolean j = true;
  private final RectF k = new RectF();
  private final RectF l = new RectF();
  private final Paint m = new Paint();
  private final int n = 100;
  private int o = 0;
  private ChildLockCircle.AnimatedThread p = null;
  private int q = 0;
  private Animation r = null;
  private Animation s = null;
  private int t;
  private int u;
  private CountDownTimer v = null;
  
  public ChildLockCircle(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
  }
  
  public ChildLockCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public ChildLockCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private Bitmap a(Resources paramResources, int paramInt)
  {
    int i2 = 2130843069;
    int i1 = i2;
    switch (paramInt)
    {
    default: 
      i1 = i2;
      break;
    case 14: 
      i1 = 2130843068;
      break;
    case 13: 
      i1 = 2130843067;
      break;
    case 12: 
      i1 = 2130843066;
      break;
    case 11: 
      i1 = 2130843065;
      break;
    case 10: 
      i1 = 2130843064;
      break;
    case 9: 
      i1 = 2130843077;
      break;
    case 8: 
      i1 = 2130843076;
      break;
    case 7: 
      i1 = 2130843075;
      break;
    case 6: 
      i1 = 2130843074;
      break;
    case 5: 
      i1 = 2130843073;
      break;
    case 4: 
      i1 = 2130843072;
      break;
    case 3: 
      i1 = 2130843071;
      break;
    case 2: 
      i1 = 2130843070;
      break;
    case 1: 
      i1 = 2130843063;
    }
    return BitmapFactory.decodeResource(paramResources, i1);
  }
  
  private void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    this.a.sendMessage(localMessage);
  }
  
  private void a(Context paramContext)
  {
    if (!((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).onLockSuccess(getContext())) {
      return;
    }
    if (this.v == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer start");
      }
      this.v = new ChildLockCircle.1(this, 750L, 50L, paramContext);
      this.v.start();
    }
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    setId(2131441036);
    setBackgroundResource(2130843078);
    paramAttributeSet = getResources();
    this.b = paramAttributeSet.getString(2131893172);
    this.c = paramAttributeSet.getString(2131893173);
    this.d = paramAttributeSet.getString(2131893170);
    this.e = paramAttributeSet.getString(2131893171);
    try
    {
      this.g = BitmapFactory.decodeResource(paramAttributeSet, 2130843069);
      this.h = BitmapFactory.decodeResource(paramAttributeSet, 2130843063);
    }
    catch (OutOfMemoryError paramAttributeSet)
    {
      paramAttributeSet.printStackTrace();
    }
    paramAttributeSet = this.k;
    paramAttributeSet.left = 12.0F;
    paramAttributeSet.top = 12.0F;
    this.m.setFlags(1);
    this.m.setColor(-1);
    this.a = new Handler(Looper.getMainLooper(), this);
  }
  
  private void c()
  {
    d();
    this.p = new ChildLockCircle.AnimatedThread(this);
    ChildLockCircle.AnimatedThread localAnimatedThread = this.p;
    localAnimatedThread.a = true;
    localAnimatedThread.start();
  }
  
  private void d()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      ((ChildLockCircle.AnimatedThread)localObject).a = false;
      this.p = null;
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      this.v = null;
    }
  }
  
  private void e()
  {
    a(1);
  }
  
  private void f()
  {
    a(2);
  }
  
  private void g()
  {
    ((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).onAnimationFailed(getContext());
  }
  
  private boolean getIsLock()
  {
    return this.j;
  }
  
  private void setIsLock(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (this.j)
    {
      this.o = 0;
      this.f = this.b;
      this.i = this.h;
      return;
    }
    this.o = 100;
    this.f = this.d;
    this.i = this.g;
  }
  
  public void a()
  {
    if (((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).updateText(getContext()))
    {
      setIsLock(true);
      return;
    }
    setIsLock(false);
  }
  
  public void a(boolean paramBoolean)
  {
    ((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).startChildLockAnimation();
    a();
    if (this.r == null) {
      this.r = AnimationUtils.loadAnimation(getContext(), 2130772268);
    }
    if (paramBoolean)
    {
      this.q = 1;
      this.r.setAnimationListener(this);
      startAnimation(this.r);
      return;
    }
    setVisibility(0);
    this.q = 2;
    c();
  }
  
  public void b()
  {
    if (this.q == 1) {
      this.q = -1;
    }
    d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage, msg.what=");
      localStringBuilder.append(paramMessage.what);
      QLog.d("ChildLockCircle", 2, localStringBuilder.toString());
    }
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if ((i1 == 3) && (getIsLock())) {
            a(getContext());
          }
        }
        else {
          ((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).handleAnimSuccessMsg(getContext());
        }
      }
      else
      {
        if (this.s == null) {
          this.s = AnimationUtils.loadAnimation(getContext(), 2130772269);
        }
        paramMessage = this.s;
        if (paramMessage != null)
        {
          this.q = 3;
          paramMessage.setAnimationListener(this);
          startAnimation(this.s);
        }
        else
        {
          onAnimationEnd(paramMessage);
        }
      }
    }
    else {
      postInvalidate();
    }
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.s))
    {
      setVisibility(8);
      if (QLog.isDevelopLevel()) {
        QLog.w("ChildLockCircle", 1, "timtest onAnimationEnd animation.equals(fadeoutAnimation)");
      }
      ((IChildLockCircleApi)QRoute.api(IChildLockCircleApi.class)).onAnimationEnd();
      this.q = 0;
      new Handler().post(new ChildLockCircle.2(this));
      try
      {
        if ((this.g != null) && (!this.g.isRecycled())) {
          this.g.isRecycled();
        }
        if ((this.h != null) && (!this.h.isRecycled())) {
          this.h.isRecycled();
        }
        this.g = null;
        this.h = null;
        this.i = null;
        return;
      }
      catch (OutOfMemoryError paramAnimation)
      {
        paramAnimation.printStackTrace();
        return;
      }
    }
    if (paramAnimation.equals(this.r))
    {
      setVisibility(0);
      if (this.q == 1)
      {
        this.q = 2;
        c();
        return;
      }
      g();
      e();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.m.setStrokeWidth(8.0F);
    this.m.setStyle(Paint.Style.STROKE);
    this.m.setAlpha(255);
    paramCanvas.drawArc(this.k, -90.0F, this.o / 100.0F * 360.0F, false, this.m);
    Object localObject = this.i;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      paramCanvas.drawBitmap(this.i, null, this.l, this.m);
    }
    this.m.setStyle(Paint.Style.FILL);
    localObject = this.f;
    paramCanvas.drawText((String)localObject, (this.t - this.m.measureText((String)localObject, 0, ((String)localObject).length())) / 2.0F, this.u * 6 / 7, this.m);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.t = paramInt1;
    this.u = paramInt2;
    Object localObject = this.k;
    ((RectF)localObject).left = (paramInt1 * 18 / 65);
    ((RectF)localObject).top = (paramInt2 * 19 / 120);
    ((RectF)localObject).right = (paramInt1 * 47 / 65);
    ((RectF)localObject).bottom = (paramInt2 * 77 / 120);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[childLock] action : w = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("  h = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" width = ");
      ((StringBuilder)localObject).append(this.t);
      QLog.d("ChildLockCircle", 1, ((StringBuilder)localObject).toString());
    }
    this.l.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.m.setTextSize(paramInt1 / 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle
 * JD-Core Version:    0.7.0.1
 */