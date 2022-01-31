package com.tencent.mobileqq.activity.aio.qim;

import aekr;
import aeks;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class QIMUserManager$5
  implements Runnable
{
  public QIMUserManager$5(aekr paramaekr, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        aeks localaeks = (aeks)localIterator.next();
        if ((this.b == null) || (this.b.size() <= localaeks.jdField_a_of_type_Int)) {
          continue;
        }
        if (((int[])this.b.get(localaeks.jdField_a_of_type_Int)).length >= 7)
        {
          i = 5;
          if (((int[])this.b.get(localaeks.jdField_a_of_type_Int)).length < 7) {
            break label264;
          }
          j = 6;
          StateListDrawable localStateListDrawable = new StateListDrawable();
          Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localaeks.jdField_a_of_type_Int))[j]);
          localStateListDrawable.addState(new int[] { 16842913, 16842910 }, localDrawable);
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localaeks.jdField_a_of_type_Int))[j]);
          localStateListDrawable.addState(new int[] { 16842919, 16842910 }, localDrawable);
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(((int[])this.b.get(localaeks.jdField_a_of_type_Int))[i]);
          localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
          localaeks.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localStateListDrawable;
          continue;
        }
        int i = 4;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QIMUserManager", 1, localThrowable, new Object[0]);
        return;
      }
      continue;
      label264:
      int j = 5;
    }
    if (this.b != null) {
      this.b.clear();
    }
    ThreadManager.getUIHandler().post(new QIMUserManager.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5
 * JD-Core Version:    0.7.0.1
 */