package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory.ListenerAdapter;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieTask;
import com.tencent.qphone.base.util.QLog;

public class LoginAnimBtnView
  extends ImageView
{
  private LottieDrawable a;
  private boolean b = false;
  private Path c;
  private int d;
  private int e;
  private int f = -1446926;
  private int g = -16725252;
  private int h = 855638016;
  private Paint i;
  private boolean j = false;
  private volatile boolean k = false;
  private Object l = new Object();
  private LottieTask<LottieComposition> m;
  private LottieComposition.Factory.ListenerAdapter n;
  private Runnable o = new LoginAnimBtnView.1(this);
  
  public LoginAnimBtnView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoginAnimBtnView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LoginAnimBtnView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    LottieDrawable localLottieDrawable = this.a;
    if ((localLottieDrawable != null) && (!localLottieDrawable.isAnimating())) {
      this.a.playAnimation();
    }
  }
  
  private void h()
  {
    LottieDrawable localLottieDrawable = this.a;
    if ((localLottieDrawable != null) && (localLottieDrawable.isAnimating())) {
      this.a.pauseAnimation();
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadLottieAnimation mLottieDrawable:");
      localStringBuilder.append(this.a);
      QLog.i("LoginAnimBtnView", 2, localStringBuilder.toString());
    }
    if (this.a != null) {
      return;
    }
    ThreadManager.post(new LoginAnimBtnView.2(this), 5, null, true);
  }
  
  public void a()
  {
    this.i = new Paint();
    this.i.setColor(-1);
    this.i.setStyle(Paint.Style.FILL);
    this.i.setAntiAlias(true);
    setEnabled(false);
    this.k = false;
    i();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume ");
      localStringBuilder.append(this.a);
      QLog.i("LoginAnimBtnView", 2, localStringBuilder.toString());
    }
    if ((this.a != null) && (isEnabled())) {
      this.a.resumeAnimation();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause ");
      ((StringBuilder)localObject).append(this.a);
      QLog.i("LoginAnimBtnView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if ((localObject != null) && (((LottieDrawable)localObject).isAnimating())) {
      this.a.pauseAnimation();
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (isEnabled()) && (this.a.isAnimating()) && (this.j))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginAnimBtnView", 2, "pauseIfAnim");
      }
      this.a.pauseAnimation();
    }
  }
  
  public void e()
  {
    if ((this.a != null) && (isEnabled()) && (!this.a.isAnimating()) && (this.j))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginAnimBtnView", 2, "resumeIfAnim");
      }
      this.a.resumeAnimation();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onDestroy ");
      ((StringBuilder)???).append(this.a);
      QLog.i("LoginAnimBtnView", 2, ((StringBuilder)???).toString());
    }
    this.k = true;
    removeCallbacks(this.o);
    if (this.a != null)
    {
      setBackgroundDrawable(null);
      this.a.cancelAnimation();
      this.a.recycleBitmaps();
      this.a.clearComposition();
      this.a.setImageAssetDelegate(null);
      this.a = null;
      this.b = false;
    }
    synchronized (this.l)
    {
      if (this.m != null)
      {
        this.n.cancel();
        this.m.removeListener(this.n);
        this.m = null;
        this.n = null;
      }
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("onDraw error0:");
      localStringBuilder2.append(localOutOfMemoryError.getMessage());
      QLog.e("LoginAnimBtnView", 1, localStringBuilder2.toString());
      LottieDrawable localLottieDrawable = this.a;
      if (localLottieDrawable != null)
      {
        localLottieDrawable.cancelAnimation();
        this.a.recycleBitmaps();
        this.a.clearComposition();
        this.a.setImageAssetDelegate(null);
      }
      this.a = null;
      this.b = false;
      if (isEnabled()) {
        setBackgroundColor(this.g);
      } else {
        setBackgroundColor(this.f);
      }
      try
      {
        super.onDraw(paramCanvas);
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("onDraw error1:");
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.e("LoginAnimBtnView", 1, localStringBuilder2.toString());
      }
    }
    try
    {
      int i1 = getMeasuredWidth();
      int i2 = getMeasuredHeight();
      if ((this.c == null) || (i1 != this.d) || (i2 != this.e))
      {
        int i3 = Math.min(i1, i2) / 2;
        this.c = new Path();
        this.c.setFillType(Path.FillType.INVERSE_WINDING);
        this.c.addCircle(i1 / 2, i2 / 2, i3, Path.Direction.CW);
        this.d = i1;
        this.e = i2;
      }
      if ((isEnabled()) && (isPressed())) {
        paramCanvas.drawColor(this.h);
      }
      paramCanvas.drawPath(this.c, this.i);
      return;
    }
    catch (Throwable paramCanvas)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onDraw error2:");
      localStringBuilder1.append(paramCanvas.getMessage());
      QLog.e("LoginAnimBtnView", 1, localStringBuilder1.toString());
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    boolean bool = isEnabled();
    super.setEnabled(paramBoolean);
    if (bool == paramBoolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setEnabled isEnabled:");
      localStringBuilder.append(isEnabled());
      localStringBuilder.append("  mLottieDrawable:");
      localStringBuilder.append(this.a);
      QLog.i("LoginAnimBtnView", 2, localStringBuilder.toString());
    }
    removeCallbacks(this.o);
    post(this.o);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView
 * JD-Core Version:    0.7.0.1
 */