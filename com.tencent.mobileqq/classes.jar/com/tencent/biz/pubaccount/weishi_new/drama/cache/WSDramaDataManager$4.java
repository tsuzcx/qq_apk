package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.List;

class WSDramaDataManager$4
  implements IFetchDataRspListener<stDramaFeed>
{
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    IFetchDataRspListener localIFetchDataRspListener = this.c;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(paramInt, paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(List<stDramaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    WSDramaDataManager.a(this.d).a(paramList, this.a.d());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSDramaDataManager.java][getEpisodeFeeds] isPreloadData:");
    ((StringBuilder)localObject).append(this.a.i());
    WSLog.a("WSDramaDataManager-nel-log", ((StringBuilder)localObject).toString());
    localObject = WSDramaDataManager.a(this.d).a(this.a.d()).f();
    paramList = this.b.a((stDrama)localObject, paramList);
    localObject = this.c;
    if (localObject != null) {
      ((IFetchDataRspListener)localObject).a(paramList, paramBoolean1, paramBoolean2, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager.4
 * JD-Core Version:    0.7.0.1
 */