package com.tencent.biz.pubaccount.util.monitor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class FPSSuspendedBall
  extends TextView
{
  private WindowManager.LayoutParams a;
  private WindowManager b;
  private boolean c;
  
  public FPSSuspendedBall(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FPSSuspendedBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FPSSuspendedBall(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setId(2131438809);
    setBackgroundColor(paramContext.getResources().getColor(2131165580));
    setText("60.00");
    setTextColor(-16711936);
    setGravity(17);
    setOnTouchListener(new FPSSuspendedBall.SuspendedBallTouchListener(this, null));
    this.a = new WindowManager.LayoutParams(-2, -2, 1000, 8, -3);
    paramContext = this.a;
    paramContext.gravity = 53;
    paramContext.y = 250;
    float f = getTextSize();
    paramContext = this.a;
    paramContext.width = ((int)(5.0F * f));
    double d = f;
    Double.isNaN(d);
    paramContext.height = ((int)(d * 1.5D));
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong1, long paramLong2)
  {
    float f = getTextSize();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFloat1);
    int i;
    double d1;
    if ((paramFloat2 > 0.0F) && (paramFloat3 > 0.0F))
    {
      localStringBuilder.append("\n");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("%");
      localStringBuilder.append("\n");
      localStringBuilder.append(paramFloat3);
      localStringBuilder.append("%");
      i = (int)(4.0F * f) + 0;
    }
    else
    {
      d1 = f;
      Double.isNaN(d1);
      i = (int)(d1 * 1.5D) + 0;
    }
    int j = i;
    if (this.c)
    {
      localStringBuilder.append("\n");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("kb/s");
      localStringBuilder.append("\n");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("kb/s");
      d1 = i;
      double d2 = f;
      Double.isNaN(d2);
      Double.isNaN(d1);
      j = (int)(d1 + d2 * 2.5D);
    }
    if (this.a.height != j)
    {
      this.a.height = j;
      if (getParent() != null) {
        this.b.updateViewLayout(this, this.a);
      }
    }
    setText(localStringBuilder.toString());
  }
  
  public void a(Activity paramActivity, WindowManager paramWindowManager)
  {
    this.b = paramWindowManager;
    paramActivity.getWindow().getDecorView().post(new FPSSuspendedBall.1(this, paramWindowManager));
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSSuspendedBall
 * JD-Core Version:    0.7.0.1
 */