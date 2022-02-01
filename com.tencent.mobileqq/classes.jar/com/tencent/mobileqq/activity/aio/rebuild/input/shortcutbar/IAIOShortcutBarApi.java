package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract interface IAIOShortcutBarApi
{
  public abstract View a();
  
  public abstract void a(int paramInt, Bundle paramBundle);
  
  public abstract void a(IAIOShortcutBarLogic paramIAIOShortcutBarLogic);
  
  public abstract boolean a(MotionEvent paramMotionEvent);
  
  public abstract ViewGroup.LayoutParams b();
  
  public abstract int c();
  
  public abstract int d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarApi
 * JD-Core Version:    0.7.0.1
 */