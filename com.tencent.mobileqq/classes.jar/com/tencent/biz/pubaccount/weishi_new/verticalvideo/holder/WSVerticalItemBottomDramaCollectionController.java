package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stDrama;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeInfo;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemBottomDramaCollectionController
  extends AbsWSVerticalItemBottomSubCollectionController
{
  public WSVerticalItemBottomDramaCollectionController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  protected String a()
  {
    return ((WSVerticalItemData)a()).a().a().barText;
  }
  
  protected boolean a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    return (localWSVerticalItemData != null) && (localWSVerticalItemData.a() != null) && (localWSVerticalItemData.a().a() != null) && (!TextUtils.isEmpty(localWSVerticalItemData.a().a().barText));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomDramaCollectionController
 * JD-Core Version:    0.7.0.1
 */