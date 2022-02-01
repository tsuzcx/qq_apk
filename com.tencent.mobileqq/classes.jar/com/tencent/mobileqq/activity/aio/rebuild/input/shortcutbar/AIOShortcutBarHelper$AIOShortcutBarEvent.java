package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import android.os.Bundle;

public class AIOShortcutBarHelper$AIOShortcutBarEvent
{
  public int a;
  private Bundle b;
  
  public AIOShortcutBarHelper$AIOShortcutBarEvent() {}
  
  public AIOShortcutBarHelper$AIOShortcutBarEvent(int paramInt)
  {
    this.a = paramInt;
  }
  
  public AIOShortcutBarHelper$AIOShortcutBarEvent(int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramBundle;
  }
  
  public Bundle a()
  {
    if (this.b == null) {
      this.b = new Bundle();
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent
 * JD-Core Version:    0.7.0.1
 */