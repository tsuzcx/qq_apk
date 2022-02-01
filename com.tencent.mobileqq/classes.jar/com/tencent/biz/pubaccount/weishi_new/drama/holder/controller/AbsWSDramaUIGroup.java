package com.tencent.biz.pubaccount.weishi_new.drama.holder.controller;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;

public abstract class AbsWSDramaUIGroup
  extends AbsWsUIGroup<WSDramaItemData>
{
  protected stDrama g;
  protected stDramaFeed h;
  protected stSimpleMetaFeed i;
  
  public AbsWSDramaUIGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  private stDrama l()
  {
    WSDramaItemData localWSDramaItemData = (WSDramaItemData)c();
    if (localWSDramaItemData != null) {
      return localWSDramaItemData.f();
    }
    return null;
  }
  
  private stDramaFeed m()
  {
    WSDramaItemData localWSDramaItemData = (WSDramaItemData)c();
    if (localWSDramaItemData != null) {
      return localWSDramaItemData.g();
    }
    return null;
  }
  
  private stSimpleMetaFeed n()
  {
    stDramaFeed localstDramaFeed = m();
    if (localstDramaFeed != null) {
      return localstDramaFeed.feed;
    }
    return null;
  }
  
  protected void a()
  {
    this.g = l();
    this.h = m();
    this.i = n();
  }
  
  public abstract void d(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.AbsWSDramaUIGroup
 * JD-Core Version:    0.7.0.1
 */