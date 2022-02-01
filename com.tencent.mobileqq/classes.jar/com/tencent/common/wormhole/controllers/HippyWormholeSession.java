package com.tencent.common.wormhole.controllers;

import android.content.Context;
import android.view.View;
import com.tencent.common.wormhole.WormholeManager;
import com.tencent.common.wormhole.views.HippySessionView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="WormholeSession")
public class HippyWormholeSession
  extends HippyViewController<HippySessionView>
{
  protected View createViewImpl(Context paramContext)
  {
    return new HippySessionView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new HippySessionView(paramContext);
    WormholeManager.a().a(paramContext, paramHippyMap);
    return paramContext;
  }
  
  public void onViewDestroy(HippySessionView paramHippySessionView)
  {
    WormholeManager.a().a(paramHippySessionView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.controllers.HippyWormholeSession
 * JD-Core Version:    0.7.0.1
 */