package com.tencent.mobileqq.ar.model;

import android.content.Context;
import com.tencent.common.app.AppInterface;

public abstract class AbstractSession
  implements CameraProxy.OnCameraPreviewCallback
{
  protected int a = 0;
  protected int b = 0;
  protected int c = 0;
  protected int d = 0;
  protected Context e;
  protected AppInterface f;
  
  public void a(Context paramContext, AppInterface paramAppInterface)
  {
    this.e = paramContext;
    this.f = paramAppInterface;
  }
  
  public int j()
  {
    return 0;
  }
  
  public void k()
  {
    this.a = 2;
  }
  
  public int l()
  {
    return this.a;
  }
  
  public void m()
  {
    this.a = 3;
  }
  
  public void n() {}
  
  public void o()
  {
    this.a = 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.AbstractSession
 * JD-Core Version:    0.7.0.1
 */