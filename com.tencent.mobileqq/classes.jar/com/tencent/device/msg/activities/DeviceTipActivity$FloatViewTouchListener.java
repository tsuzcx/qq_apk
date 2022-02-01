package com.tencent.device.msg.activities;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.av.widget.shimmer.ShimmerTextView;

class DeviceTipActivity$FloatViewTouchListener
  implements View.OnTouchListener
{
  DeviceTipActivity$FloatViewTouchListener(DeviceTipActivity paramDeviceTipActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        i = (int)paramMotionEvent.getRawX() - this.a.j;
        if (i > 2)
        {
          this.a.i.setVisibility(4);
          this.a.f.setVisibility(4);
        }
        paramView = this.a.l;
        paramView.left += i;
        paramView = this.a.l;
        paramView.right += i;
        if (this.a.l.right >= this.a.q)
        {
          this.a.l.right = this.a.q;
          this.a.l.left = (this.a.l.right - this.a.e.getWidth());
        }
        if (this.a.l.left <= this.a.r)
        {
          this.a.l.left = this.a.r;
          this.a.l.right = (this.a.l.left + this.a.e.getWidth());
        }
        this.a.e.layout(this.a.l.left, this.a.m.top, this.a.l.right, this.a.m.bottom);
        this.a.o.layout(this.a.l.left - this.a.r, this.a.n.top, this.a.n.right, this.a.n.bottom);
        this.a.j = ((int)paramMotionEvent.getRawX());
        return true;
      }
      if (this.a.l.right == this.a.q)
      {
        this.a.b();
        return true;
      }
      if (this.a.l.right < this.a.q)
      {
        this.a.e.layout(this.a.m.left, this.a.m.top, this.a.m.right, this.a.m.bottom);
        this.a.o.layout(this.a.n.left, this.a.n.top, this.a.n.right, this.a.n.bottom);
        this.a.i.setVisibility(0);
        this.a.f.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.a.j = ((int)paramMotionEvent.getRawX());
      DeviceTipActivity.c(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceTipActivity.FloatViewTouchListener
 * JD-Core Version:    0.7.0.1
 */