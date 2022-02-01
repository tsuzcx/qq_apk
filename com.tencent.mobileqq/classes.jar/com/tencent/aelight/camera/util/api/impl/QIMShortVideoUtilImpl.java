package com.tencent.aelight.camera.util.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.aebase.QIMShortVideoUtils;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;

public class QIMShortVideoUtilImpl
  implements IQIMShortVideoUtil
{
  public boolean isPeakAlive(Context paramContext)
  {
    return QIMShortVideoUtils.a(paramContext);
  }
  
  public void preLoadPeakProcess(Context paramContext)
  {
    QIMShortVideoUtils.a(paramContext);
  }
  
  public void preLoadPeakProcess(Context paramContext, Runnable paramRunnable, String paramString)
  {
    QIMShortVideoUtils.a(paramContext, paramRunnable, paramString);
  }
  
  public void preLoadPeakProcess(Context paramContext, String paramString)
  {
    QIMShortVideoUtils.a(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.impl.QIMShortVideoUtilImpl
 * JD-Core Version:    0.7.0.1
 */