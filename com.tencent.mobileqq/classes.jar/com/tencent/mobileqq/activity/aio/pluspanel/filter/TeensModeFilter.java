package com.tencent.mobileqq.activity.aio.pluspanel.filter;

import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeManager;
import java.util.Iterator;
import java.util.List;

public abstract class TeensModeFilter
  implements AppInfoFilter
{
  private boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void a(PlusPanelAppLoader paramPlusPanelAppLoader, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (StudyModeManager.a())
    {
      paramPlusPanelAppLoader = paramPlusPanelAppLoader.a().iterator();
      while (paramPlusPanelAppLoader.hasNext()) {
        if (!a(((PlusPanelAppInfo)paramPlusPanelAppLoader.next()).getAppID(), a())) {
          paramPlusPanelAppLoader.remove();
        }
      }
    }
  }
  
  protected abstract int[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.filter.TeensModeFilter
 * JD-Core Version:    0.7.0.1
 */