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
  
  public int a()
  {
    return 1;
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
    this.a.a(paramInt, paramBundle);
  }
  
  public void a(IAIOShortcutBarLogic paramIAIOShortcutBarLogic)
  {
    this.a = new C2CAppShortcutBarHelper(paramIAIOShortcutBarLogic);
  }
  
  public boolean a()
  {
    return this.a.c();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int b()
  {
    return ViewUtils.a(39.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.C2CAppShortcutBarService
 * JD-Core Version:    0.7.0.1
 */