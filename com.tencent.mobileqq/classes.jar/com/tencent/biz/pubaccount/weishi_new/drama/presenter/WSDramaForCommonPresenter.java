package com.tencent.biz.pubaccount.weishi_new.drama.presenter;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaOperationRecordManager;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSDramaForCommonPresenter
  extends AbsWSDramaPagePresenter
{
  private void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportDramaWatchRecord() scene = ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.a("WSDramaForCommonPresenterLog", ((StringBuilder)localObject).toString());
    localObject = d();
    if (localObject != null)
    {
      localObject = ((AbsWSDramaVideoHolder)localObject).c;
      if (localObject != null) {
        WSDramaOperationRecordManager.a(((WSDramaItemData)localObject).b(), ((WSDramaItemData)localObject).d(), ((WSDramaItemData)localObject).c(), (int)(e().a().a() / 1000L));
      }
    }
  }
  
  private void a(WSDramaItemData paramWSDramaItemData)
  {
    WSDramaVideoPlayEvent localWSDramaVideoPlayEvent = new WSDramaVideoPlayEvent();
    localWSDramaVideoPlayEvent.setDramaId(paramWSDramaItemData.b());
    localWSDramaVideoPlayEvent.setEpisodeNum(paramWSDramaItemData.c());
    localWSDramaVideoPlayEvent.setEpisodeId(paramWSDramaItemData.d());
    localWSDramaVideoPlayEvent.setDramaInfo(paramWSDramaItemData.f());
    localWSDramaVideoPlayEvent.setDramaPreviewPage(true);
    WSSimpleEventBus.a().a(localWSDramaVideoPlayEvent);
    paramWSDramaItemData = new StringBuilder();
    paramWSDramaItemData.append("[WSDramaForCommonPresenter.java][dispatchEventForDramaVideoPlay] event:");
    paramWSDramaItemData.append(localWSDramaVideoPlayEvent);
    WSLog.e("WSDramaForCommonPresenterLog", paramWSDramaItemData.toString());
  }
  
  private void a(WSDramaVideoExposureEvent paramWSDramaVideoExposureEvent)
  {
    Object localObject = paramWSDramaVideoExposureEvent.getFeedInfo();
    AbsWSDramaVideoHolder localAbsWSDramaVideoHolder = d();
    if ((localAbsWSDramaVideoHolder != null) && (localAbsWSDramaVideoHolder.c != null)) {
      localAbsWSDramaVideoHolder.c.a((stSimpleMetaFeed)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSDramaForCommonPresenter.java][handleEventForDramaVideoExposure] event:");
    ((StringBuilder)localObject).append(paramWSDramaVideoExposureEvent);
    WSLog.e("WSDramaForCommonPresenterLog", ((StringBuilder)localObject).toString());
  }
  
  private void f()
  {
    Object localObject = d();
    if (localObject != null)
    {
      localObject = ((AbsWSDramaVideoHolder)localObject).c;
      if (localObject != null) {
        a((WSDramaItemData)localObject);
      }
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    super.a(paramWSSimpleBaseEvent);
    if ((paramWSSimpleBaseEvent instanceof WSDramaVideoExposureEvent)) {
      a((WSDramaVideoExposureEvent)paramWSSimpleBaseEvent);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    super.a(paramWSPlayerParam);
    f();
    a(1);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    a(2);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    WSDramaPageContract.View localView = (WSDramaPageContract.View)getView();
    if (localView == null) {
      return false;
    }
    WSDramaDataManager.a().a(localView.c(), paramBoolean1, paramBoolean2, paramString, this);
    return true;
  }
  
  public void c()
  {
    super.c();
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.presenter.WSDramaForCommonPresenter
 * JD-Core Version:    0.7.0.1
 */