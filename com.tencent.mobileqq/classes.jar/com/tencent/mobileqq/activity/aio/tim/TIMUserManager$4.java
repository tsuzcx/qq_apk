package com.tencent.mobileqq.activity.aio.tim;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.theme.SkinEngine;
import mqq.os.MqqHandler;

public final class TIMUserManager$4
  implements Runnable
{
  public void run()
  {
    Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849550);
    Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130849554);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable1);
    localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable2);
    ThreadManager.getUIHandler().post(new TIMUserManager.4.1(this, localStateListDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tim.TIMUserManager.4
 * JD-Core Version:    0.7.0.1
 */