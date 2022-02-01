package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;

public class WSFetchPreloadDataModule
  implements IFetchDataModule
{
  private void b(IVerticalRspListener paramIVerticalRspListener)
  {
    WeiShiCacheManager.a().b(new WSFetchPreloadDataModule.1(this, paramIVerticalRspListener));
  }
  
  public void a(IVerticalRspListener paramIVerticalRspListener)
  {
    b(paramIVerticalRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchPreloadDataModule
 * JD-Core Version:    0.7.0.1
 */