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
  protected stDrama a;
  protected stDramaFeed a;
  protected stSimpleMetaFeed a;
  
  public AbsWSDramaUIGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  private stDrama a()
  {
    WSDramaItemData localWSDramaItemData = (WSDramaItemData)a();
    if (localWSDramaItemData != null) {
      return localWSDramaItemData.a();
    }
    return null;
  }
  
  private stDramaFeed a()
  {
    WSDramaItemData localWSDramaItemData = (WSDramaItemData)a();
    if (localWSDramaItemData != null) {
      return localWSDramaItemData.a();
    }
    return null;
  }
  
  private stSimpleMetaFeed a()
  {
    stDramaFeed localstDramaFeed = a();
    if (localstDramaFeed != null) {
      return localstDramaFeed.feed;
    }
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_UserGrowthStDrama = a();
    this.jdField_a_of_type_UserGrowthStDramaFeed = a();
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = a();
  }
  
  public abstract void c(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.AbsWSDramaUIGroup
 * JD-Core Version:    0.7.0.1
 */