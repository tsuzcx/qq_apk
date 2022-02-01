package com.tencent.luggage.wxa.f;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

class s
  extends o
{
  final SurfaceView a;
  
  s(Context paramContext, ViewGroup paramViewGroup)
  {
    this.a = ((SurfaceView)View.inflate(paramContext, 2131629354, paramViewGroup).findViewById(2131446642));
    paramContext = this.a.getHolder();
    paramContext.setType(3);
    paramContext.addCallback(new s.1(this));
  }
  
  void a(int paramInt) {}
  
  Surface e()
  {
    return f().getSurface();
  }
  
  SurfaceHolder f()
  {
    return this.a.getHolder();
  }
  
  View g()
  {
    return this.a;
  }
  
  Class h()
  {
    return SurfaceHolder.class;
  }
  
  boolean i()
  {
    return (l() != 0) && (m() != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.s
 * JD-Core Version:    0.7.0.1
 */