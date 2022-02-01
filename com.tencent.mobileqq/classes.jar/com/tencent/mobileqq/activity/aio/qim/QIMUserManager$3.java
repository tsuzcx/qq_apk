package com.tencent.mobileqq.activity.aio.qim;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import mqq.os.MqqHandler;

final class QIMUserManager$3
  implements Runnable
{
  public void run()
  {
    try
    {
      Drawable localDrawable1 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850250);
      Drawable localDrawable2 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850251);
      Drawable localDrawable3 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850300);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      Drawable localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850396);
      localStateListDrawable.addState(new int[] { -16842910 }, localDrawable4);
      localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850399);
      localStateListDrawable.addState(new int[] { 16842910 }, localDrawable4);
      localDrawable4 = SkinEngine.getInstances().getDefaultThemeDrawable(2130850400);
      localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable4);
      ThreadManager.getUIHandler().post(new QIMUserManager.3.1(this, localDrawable1, localDrawable2, localDrawable3, localStateListDrawable));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QIMUserManager", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.3
 * JD-Core Version:    0.7.0.1
 */