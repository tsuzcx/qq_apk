package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.app.WeishiManager;

public class WSFetchLocalDataModule
  implements IFetchDataModule
{
  private String a()
  {
    WeishiManager localWeishiManager = WeishiUtils.a();
    if (localWeishiManager != null) {
      return localWeishiManager.c();
    }
    return "";
  }
  
  private void b(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    WSLog.a("WSFetchLocalDataModule", "fetchVerticalListDataFromLocal");
    WeiShiCacheManager.a().d(new WSFetchLocalDataModule.1(this, paramIFetchDataRspListener));
  }
  
  public void a(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    b(paramIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchLocalDataModule
 * JD-Core Version:    0.7.0.1
 */