package com.tencent.mobileqq.activity.aio.tim;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.theme.SkinEngine;
import mqq.os.MqqHandler;

public final class TIMUserManager$3
  implements Runnable
{
  public void run()
  {
    Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849207);
    Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849208);
    Drawable localDrawable3 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849257);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849353);
    localStateListDrawable.addState(new int[] { -16842910 }, localDrawable4);
    localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849356);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable4);
    localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849357);
    localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable4);
    ThreadManager.getUIHandler().post(new TIMUserManager.3.1(this, localDrawable1, localDrawable2, localDrawable3, localStateListDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.3
 * JD-Core Version:    0.7.0.1
 */