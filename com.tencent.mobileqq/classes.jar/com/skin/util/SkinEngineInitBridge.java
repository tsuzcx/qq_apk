package com.skin.util;

import android.content.Context;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.theme.SkinEngine;

public class SkinEngineInitBridge
{
  public static void init(Context paramContext)
  {
    SkinEngine.init(paramContext, 8191, 2130837504, 1264, 2131492864, null);
  }
  
  public static void initSkin(Context paramContext)
  {
    InitSkin.initSkin(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.skin.util.SkinEngineInitBridge
 * JD-Core Version:    0.7.0.1
 */