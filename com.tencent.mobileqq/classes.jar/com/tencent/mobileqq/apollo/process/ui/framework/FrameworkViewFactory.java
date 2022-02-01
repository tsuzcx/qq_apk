package com.tencent.mobileqq.apollo.process.ui.framework;

import android.content.Context;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.mobileqq.apollo.game.OnGameMenuListener;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.util.WeakReferenceHandler;

public class FrameworkViewFactory
{
  public static FrameworkView a(Context paramContext, CmGameLauncher paramCmGameLauncher, WeakReferenceHandler paramWeakReferenceHandler, CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramContext = new CmGameGuideView(paramContext, paramStartCheckParam);
    }
    for (;;)
    {
      paramContext.a(paramCmGameLauncher, paramWeakReferenceHandler, null, paramStartCheckParam);
      return paramContext;
      paramContext = new CmGameGuideView(paramContext, paramStartCheckParam);
      continue;
      paramContext = new CmGameDebugView(paramContext, paramStartCheckParam);
    }
  }
  
  public static FrameworkView a(Context paramContext, CmGameLauncher paramCmGameLauncher, WeakReferenceHandler paramWeakReferenceHandler, OnGameMenuListener paramOnGameMenuListener, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    switch (paramStartCheckParam.src)
    {
    default: 
      if (paramStartCheckParam.mGameType == 5) {
        paramContext = new QzoneGameFloatView(paramContext, paramStartCheckParam);
      }
      break;
    }
    for (;;)
    {
      paramContext.a(paramCmGameLauncher, paramWeakReferenceHandler, paramOnGameMenuListener, paramStartCheckParam);
      return paramContext;
      paramContext = new QzoneGameFloatView(paramContext, paramStartCheckParam);
      continue;
      paramContext = new CmGameFloatView(paramContext, paramStartCheckParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.FrameworkViewFactory
 * JD-Core Version:    0.7.0.1
 */