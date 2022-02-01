package com.tencent.aelight.camera.ae;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public abstract interface IQIMCameraLifeCallback
{
  public abstract void I();
  
  public abstract void J();
  
  public abstract void K();
  
  public abstract View a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean);
  
  public abstract boolean a(MotionEvent paramMotionEvent, boolean paramBoolean);
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract boolean i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.IQIMCameraLifeCallback
 * JD-Core Version:    0.7.0.1
 */