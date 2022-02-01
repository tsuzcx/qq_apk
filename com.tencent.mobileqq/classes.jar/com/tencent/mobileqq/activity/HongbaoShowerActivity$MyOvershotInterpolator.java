package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.tencent.mobileqq.portal.SanHuaView;

public class HongbaoShowerActivity$MyOvershotInterpolator
  extends OvershootInterpolator
{
  private boolean b;
  
  public HongbaoShowerActivity$MyOvershotInterpolator(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public float getInterpolation(float paramFloat)
  {
    if ((!this.b) && (paramFloat > 0.7D))
    {
      this.b = true;
      this.a.b.setBackgroundColor(-16777216);
      this.a.b.startAnimation(this.a.c);
      HongbaoShowerActivity.d(this.a).a();
    }
    return (float)(1.0D - Math.pow(2.718281828459045D, -paramFloat * 5.0F) * Math.cos(paramFloat * 8.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity.MyOvershotInterpolator
 * JD-Core Version:    0.7.0.1
 */