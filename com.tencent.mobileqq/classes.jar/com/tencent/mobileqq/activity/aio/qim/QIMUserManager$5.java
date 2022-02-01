package com.tencent.mobileqq.activity.aio.qim;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class QIMUserManager$5
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.a.iterator();
        if (localIterator.hasNext())
        {
          QIMUserManager.QIMUserIcon localQIMUserIcon = (QIMUserManager.QIMUserIcon)localIterator.next();
          if ((this.b == null) || (this.b.size() <= localQIMUserIcon.b)) {
            continue;
          }
          i = ((int[])this.b.get(localQIMUserIcon.b)).length;
          int j = 5;
          if (i >= 7)
          {
            i = 5;
            if (((int[])this.b.get(localQIMUserIcon.b)).length >= 7) {
              j = 6;
            }
            StateListDrawable localStateListDrawable = new StateListDrawable();
            Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localQIMUserIcon.b))[j]);
            localStateListDrawable.addState(new int[] { 16842913, 16842910 }, localDrawable);
            localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localQIMUserIcon.b))[j]);
            localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable);
            localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localQIMUserIcon.b))[i]);
            localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
            localQIMUserIcon.c = localStateListDrawable;
          }
        }
        else
        {
          if (this.b != null) {
            this.b.clear();
          }
          ThreadManager.getUIHandler().post(new QIMUserManager.5.1(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QIMUserManager", 1, localThrowable, new Object[0]);
        return;
      }
      int i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5
 * JD-Core Version:    0.7.0.1
 */