package com.tencent.mobileqq.activity.aio.helper;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarApi;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarLogic;
import com.tencent.mobileqq.c2cshortcutbar.C2CAppShortcutBarHelper;
import com.tencent.mobileqq.utils.ViewUtils;

public class C2CAppShortcutBarService
  implements IAIOShortcutBarApi
{
  private C2CAppShortcutBarHelper a;
  
  public View a()
  {
    return this.a.b();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.a(paramInt, paramBundle);
  }
  
  public void a(IAIOShortcutBarLogic paramIAIOShortcutBarLogic)
  {
    this.a = new C2CAppShortcutBarHelper(paramIAIOShortcutBarLogic);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public ViewGroup.LayoutParams b()
  {
    return this.a.c();
  }
  
  public int c()
  {
    return 1;
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.C2CAppShortcutBarService
 * JD-Core Version:    0.7.0.1
 */