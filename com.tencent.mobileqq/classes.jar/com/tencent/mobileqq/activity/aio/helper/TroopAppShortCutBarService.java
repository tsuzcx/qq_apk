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
  
  public int a()
  {
    return 2;
  }
  
  public View a()
  {
    return this.a.a();
  }
  
  public ViewGroup.LayoutParams a()
  {
    return this.a.a();
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
  
  public boolean a()
  {
    return this.a.c();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
  
  public int b()
  {
    return ViewUtils.a(39.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAppShortCutBarService
 * JD-Core Version:    0.7.0.1
 */