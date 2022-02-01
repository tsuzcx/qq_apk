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
  
  protected boolean l()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    return (localWSVerticalItemData != null) && (localWSVerticalItemData.g() != null) && (localWSVerticalItemData.g().d() != null) && (!TextUtils.isEmpty(localWSVerticalItemData.g().d().barText));
  }
  
  protected String m()
  {
    return ((WSVerticalItemData)c()).g().d().barText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomDramaCollectionController
 * JD-Core Version:    0.7.0.1
 */