package com.tencent.mobileqq.activity.aio.pluspanel.filter;

import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeManager;
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
    if (StudyModeManager.h())
    {
      paramQQAppInterface = paramPlusPanelAppLoader.a();
      paramInt = 0;
      int i = paramQQAppInterface.size();
      while (paramInt < i)
      {
        paramString = (PlusPanelAppInfo)paramQQAppInterface.get(paramInt);
        if (!a(paramString.getAppID(), a())) {
          paramPlusPanelAppLoader.c(paramString.getAppID());
        }
        paramInt += 1;
      }
    }
  }
  
  protected abstract int[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.filter.TeensModeFilter
 * JD-Core Version:    0.7.0.1
 */