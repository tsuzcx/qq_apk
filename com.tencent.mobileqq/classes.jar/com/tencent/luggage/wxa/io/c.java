package com.tencent.luggage.wxa.io;

import android.os.Handler;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class c
  extends TimerTask
{
  private float a;
  private final float b;
  private final WheelView c;
  
  public c(WheelView paramWheelView, float paramFloat)
  {
    this.c = paramWheelView;
    this.b = paramFloat;
    this.a = 2.147484E+009F;
  }
  
  public final void run()
  {
    float f2;
    if (this.a == 2.147484E+009F)
    {
      f2 = Math.abs(this.b);
      f1 = 2000.0F;
      if (f2 > 2000.0F)
      {
        if (this.b <= 0.0F) {
          f1 = -2000.0F;
        }
        this.a = f1;
      }
      else
      {
        this.a = this.b;
      }
    }
    if ((Math.abs(this.a) >= 0.0F) && (Math.abs(this.a) <= 20.0F))
    {
      this.c.a();
      this.c.getHandler().sendEmptyMessage(2000);
      return;
    }
    int i = (int)(this.a / 100.0F);
    WheelView localWheelView = this.c;
    float f1 = localWheelView.getTotalScrollY();
    float f5 = i;
    localWheelView.setTotalScrollY(f1 - f5);
    if (!this.c.d())
    {
      f1 = this.c.getItemHeight();
      float f3 = -this.c.getInitPosition() * f1;
      float f4 = (this.c.getItemsCount() - 1 - this.c.getInitPosition()) * f1;
      double d1 = this.c.getTotalScrollY();
      double d2 = f1;
      Double.isNaN(d2);
      d2 *= 0.25D;
      Double.isNaN(d1);
      if (d1 - d2 < f3)
      {
        f1 = this.c.getTotalScrollY() + f5;
        f2 = f4;
      }
      else
      {
        d1 = this.c.getTotalScrollY();
        Double.isNaN(d1);
        f1 = f3;
        f2 = f4;
        if (d1 + d2 > f4)
        {
          f2 = this.c.getTotalScrollY() + f5;
          f1 = f3;
        }
      }
      if (this.c.getTotalScrollY() <= f1)
      {
        this.a = 40.0F;
        this.c.setTotalScrollY((int)f1);
      }
      else if (this.c.getTotalScrollY() >= f2)
      {
        this.c.setTotalScrollY((int)f2);
        this.a = -40.0F;
      }
    }
    f1 = this.a;
    if (f1 < 0.0F) {
      this.a = (f1 + 20.0F);
    } else {
      this.a = (f1 - 20.0F);
    }
    this.c.getHandler().sendEmptyMessage(1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.io.c
 * JD-Core Version:    0.7.0.1
 */