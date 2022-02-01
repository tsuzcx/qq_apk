package com.tencent.common.wormhole.controllers;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.wormhole.WormholeManager;
import com.tencent.common.wormhole.node.WormholeNode;
import com.tencent.common.wormhole.views.HippyWormholeView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="Wormhole")
public class HippyWormholeController
  extends HippyViewController<HippyWormholeView>
{
  protected StyleNode createNode(boolean paramBoolean)
  {
    return new WormholeNode(paramBoolean);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyWormholeView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new HippyWormholeView(paramContext);
    paramHippyMap = WormholeManager.a().b(paramHippyMap);
    if (!TextUtils.isEmpty(paramHippyMap)) {
      paramContext.setWormholeId(paramHippyMap);
    }
    WormholeManager.a().a(paramHippyMap, paramContext);
    return paramContext;
  }
  
  public void onBatchComplete(HippyWormholeView paramHippyWormholeView)
  {
    super.onBatchComplete(paramHippyWormholeView);
    if (paramHippyWormholeView != null) {
      WormholeManager.a().a(paramHippyWormholeView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.controllers.HippyWormholeController
 * JD-Core Version:    0.7.0.1
 */