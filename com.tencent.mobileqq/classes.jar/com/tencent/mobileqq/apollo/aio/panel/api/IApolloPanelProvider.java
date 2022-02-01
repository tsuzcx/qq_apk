package com.tencent.mobileqq.apollo.aio.panel.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mtt.hippy.HippyAPIProvider;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IApolloPanelProvider
  extends QRouteApi
{
  public abstract HippyAPIProvider createHippyProvider();
  
  public abstract void init(Object paramObject);
  
  public abstract boolean isCMModule(String paramString);
  
  public abstract void onMoveToState(int paramInt);
  
  public abstract void showApolloStatusPanel(int paramInt);
  
  public abstract boolean showQuickApolloSendPanel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.api.IApolloPanelProvider
 * JD-Core Version:    0.7.0.1
 */