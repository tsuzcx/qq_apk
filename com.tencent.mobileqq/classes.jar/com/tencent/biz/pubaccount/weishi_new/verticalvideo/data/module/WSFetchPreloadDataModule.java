package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSFetchPreloadDataModule
  implements IFetchDataModule
{
  private void b(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    WeiShiCacheManager.a().a(new WSFetchPreloadDataModule.1(this, paramIFetchDataRspListener));
  }
  
  public void a(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    b(paramIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchPreloadDataModule
 * JD-Core Version:    0.7.0.1
 */