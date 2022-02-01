package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;

public class WSFetchLocalDataModule
  implements IFetchDataModule
{
  private String a()
  {
    WeishiManager localWeishiManager = WeishiUtils.a();
    String str = "";
    if (localWeishiManager != null) {
      str = localWeishiManager.c();
    }
    return str;
  }
  
  private void b(IVerticalRspListener paramIVerticalRspListener)
  {
    WSLog.a("WSFetchLocalDataModule", "fetchVerticalListDataFromLocal");
    WeiShiCacheManager.a().d(new WSFetchLocalDataModule.1(this, paramIVerticalRspListener));
  }
  
  public void a(IVerticalRspListener paramIVerticalRspListener)
  {
    b(paramIVerticalRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchLocalDataModule
 * JD-Core Version:    0.7.0.1
 */