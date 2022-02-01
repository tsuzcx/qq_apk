package com.tencent.common.wormhole.controllers;

import android.content.Context;
import android.view.View;
import com.tencent.common.wormhole.views.HippyWormholeContainer;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="WormholeContainer")
public class HippyWormholeContainerController
  extends HippyViewController<HippyWormholeContainer>
{
  protected View createViewImpl(Context paramContext)
  {
    return new HippyWormholeContainer(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    return new HippyWormholeContainer(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.controllers.HippyWormholeContainerController
 * JD-Core Version:    0.7.0.1
 */