package com.tencent.aelight.camera.ae;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public abstract interface IQIMCameraLifeCallback
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean);
  
  public abstract boolean a(MotionEvent paramMotionEvent, boolean paramBoolean);
  
  public abstract void ai();
  
  public abstract void aj();
  
  public abstract boolean ak();
  
  public abstract void al();
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void e(boolean paramBoolean);
  
  public abstract View j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.IQIMCameraLifeCallback
 * JD-Core Version:    0.7.0.1
 */