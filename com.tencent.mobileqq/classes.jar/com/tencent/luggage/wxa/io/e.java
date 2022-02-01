package com.tencent.luggage.wxa.io;

import android.os.Handler;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class e
  extends TimerTask
{
  private int a;
  private int b;
  private int c;
  private final WheelView d;
  
  public e(WheelView paramWheelView, int paramInt)
  {
    this.d = paramWheelView;
    this.c = paramInt;
    this.a = 2147483647;
    this.b = 0;
  }
  
  public final void run()
  {
    if (this.a == 2147483647) {
      this.a = this.c;
    }
    int i = this.a;
    this.b = ((int)(i * 0.1F));
    if (this.b == 0) {
      if (i < 0) {
        this.b = -1;
      } else {
        this.b = 1;
      }
    }
    if (Math.abs(this.a) <= 1)
    {
      this.d.a();
      this.d.getHandler().sendEmptyMessage(3000);
      return;
    }
    WheelView localWheelView = this.d;
    localWheelView.setTotalScrollY(localWheelView.getTotalScrollY() + this.b);
    if (!this.d.d())
    {
      float f1 = this.d.getItemHeight();
      float f2 = -this.d.getInitPosition();
      float f3 = this.d.getItemsCount() - 1 - this.d.getInitPosition();
      if ((this.d.getTotalScrollY() <= f2 * f1) || (this.d.getTotalScrollY() >= f3 * f1))
      {
        localWheelView = this.d;
        localWheelView.setTotalScrollY(localWheelView.getTotalScrollY() - this.b);
        this.d.a();
        this.d.getHandler().sendEmptyMessage(3000);
        return;
      }
    }
    this.d.getHandler().sendEmptyMessage(1000);
    this.a -= this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.io.e
 * JD-Core Version:    0.7.0.1
 */