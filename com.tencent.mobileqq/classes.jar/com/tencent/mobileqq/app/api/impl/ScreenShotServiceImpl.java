package com.tencent.mobileqq.app.api.impl;

import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.api.IScreenShot;
import com.tencent.mobileqq.app.api.IScreenShotService;

public class ScreenShotServiceImpl
  implements IScreenShotService
{
  public void logForDev(String paramString)
  {
    ScreenShot.a(paramString);
  }
  
  public IScreenShot newInstance(Context paramContext, Window paramWindow)
  {
    return new ScreeShotImpl(paramContext, paramWindow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.api.impl.ScreenShotServiceImpl
 * JD-Core Version:    0.7.0.1
 */