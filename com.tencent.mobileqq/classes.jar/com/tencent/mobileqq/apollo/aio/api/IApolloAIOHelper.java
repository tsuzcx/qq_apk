package com.tencent.mobileqq.apollo.aio.api;

import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.apollo.aio.ui.IChatPieApolloViewController;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IApolloAIOHelper
  extends ILifeCycleHelper, QRouteApi
{
  public abstract void doOnPanelChanged(int paramInt1, int paramInt2);
  
  public abstract <T extends IChatPieApolloViewController> T getChatPieApolloViewController();
  
  public abstract void init(Object paramObject);
  
  public abstract boolean isApolloForward();
  
  public abstract void showApolloView(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper
 * JD-Core Version:    0.7.0.1
 */