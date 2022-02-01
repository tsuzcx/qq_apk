package com.tencent.common.wormhole.controllers;

import android.content.Context;
import android.view.View;
import com.tencent.common.wormhole.WormholeManager;
import com.tencent.common.wormhole.node.TKDWormholeNode;
import com.tencent.common.wormhole.views.HippyWormholeView;
import com.tencent.common.wormhole.views.TKDWormholeView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

@HippyController(name="TKDWormhole")
public class TKDWormholeController
  extends HippyViewController<TKDWormholeView>
{
  protected StyleNode createNode(boolean paramBoolean, int paramInt)
  {
    return new TKDWormholeNode(paramBoolean, WormholeManager.a().b(), paramInt);
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new TKDWormholeView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    paramContext = new TKDWormholeView(paramContext);
    String str = WormholeManager.a().b(paramHippyMap);
    int i = WormholeManager.a().a(paramHippyMap);
    paramContext.setWormholeId(str);
    paramContext.setRootId(i);
    WormholeManager.a().a(paramContext, str);
    return paramContext;
  }
  
  public void dispatchFunction(TKDWormholeView paramTKDWormholeView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramTKDWormholeView, paramString, paramHippyArray);
    int i;
    if ((paramString.hashCode() == 1284238917) && (paramString.equals("sendEventToWormholeView"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0) {
      return;
    }
    if ((paramTKDWormholeView != null) && (paramTKDWormholeView.getChildCount() > 0))
    {
      paramTKDWormholeView = paramTKDWormholeView.getChildAt(0);
      if ((paramTKDWormholeView != null) && ((paramTKDWormholeView instanceof HippyWormholeView))) {
        new HippyViewEvent("onCustomEvent").send(paramTKDWormholeView, paramHippyArray);
      }
    }
  }
  
  public void onViewDestroy(TKDWormholeView paramTKDWormholeView)
  {
    WormholeManager.a().b(paramTKDWormholeView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.controllers.TKDWormholeController
 * JD-Core Version:    0.7.0.1
 */