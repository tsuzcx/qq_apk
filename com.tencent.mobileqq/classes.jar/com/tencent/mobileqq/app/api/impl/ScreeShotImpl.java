package com.tencent.mobileqq.app.api.impl;

import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.api.IScreenShot;

public class ScreeShotImpl
  implements IScreenShot
{
  private ScreenShot a;
  
  public ScreeShotImpl(Context paramContext, Window paramWindow)
  {
    this.a = new ScreenShot(paramContext, paramWindow);
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public boolean b()
  {
    return this.a.a();
  }
  
  public boolean c()
  {
    return this.a.c();
  }
  
  public boolean d()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.api.impl.ScreeShotImpl
 * JD-Core Version:    0.7.0.1
 */