package com.tencent.biz.lebasearch;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.lebasearch.widget.LebaSearchBounceScrollView;

class LebaSearchPluginManagerActivity$3$1
  extends Handler
{
  LebaSearchPluginManagerActivity$3$1(LebaSearchPluginManagerActivity.3 param3) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.a == this.a.c.r.getScrollY())
    {
      if ((this.a.a > 0) && (!this.a.c.r.a()))
      {
        int i = this.a.a;
        double d1 = this.a.c.f;
        double d2 = LebaSearchPluginManagerActivity.b;
        Double.isNaN(d1);
        double d3 = this.a.a;
        Double.isNaN(d3);
        i = (int)(d1 * (1.0D - d2) + d3);
        d1 = this.a.a;
        d2 = this.a.c.o.getHeight() + this.a.c.g * 56.0F;
        d3 = this.a.c.f;
        double d4 = LebaSearchPluginManagerActivity.b;
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d1);
        int j = (int)(d1 - (d2 - d3 * (1.0D - d4)));
        if ((i > this.a.c.o.getHeight() + this.a.c.g * 56.0F) || (i > this.a.c.o.getHeight())) {
          this.a.c.r.scrollBy(0, -j);
        }
      }
    }
    else
    {
      paramMessage = this.a;
      paramMessage.a = paramMessage.c.r.getScrollY();
      this.a.b.sendMessageDelayed(this.a.b.obtainMessage(), 5L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity.3.1
 * JD-Core Version:    0.7.0.1
 */