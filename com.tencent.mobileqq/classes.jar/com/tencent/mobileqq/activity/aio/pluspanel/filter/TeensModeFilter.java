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
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.filter.TeensModeFilter
 * JD-Core Version:    0.7.0.1
 */