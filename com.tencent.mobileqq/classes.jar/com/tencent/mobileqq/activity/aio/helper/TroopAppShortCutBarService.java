package com.tencent.mobileqq.activity.aio.helper;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarApi;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarLogic;
import com.tencent.mobileqq.utils.ViewUtils;

public class TroopAppShortCutBarService
  implements IAIOShortcutBarApi
{
  private TroopAppShortcutBarHelper a;
  
  public View a()
  {
    return this.a.b();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    TroopAppShortcutBarHelper localTroopAppShortcutBarHelper = this.a;
    if (localTroopAppShortcutBarHelper != null) {
      localTroopAppShortcutBarHelper.a(paramInt, paramBundle);
    }
  }
  
  public void a(IAIOShortcutBarLogic paramIAIOShortcutBarLogic)
  {
    this.a = new TroopAppShortcutBarHelper(paramIAIOShortcutBarLogic);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
  
  public ViewGroup.LayoutParams b()
  {
    return this.a.c();
  }
  
  public int c()
  {
    return 2;
  }
  
  public int d()
  {
    return ViewUtils.dip2px(39.0F);
  }
  
  public boolean e()
  {
    return this.a.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAppShortCutBarService
 * JD-Core Version:    0.7.0.1
 */