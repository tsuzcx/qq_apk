package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stGetTabsRsp;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

class WSHomeFragmentPresenter$6
  implements IWeishiServiceListener
{
  WSHomeFragmentPresenter$6(WSHomeFragmentPresenter paramWSHomeFragmentPresenter, long paramLong, stGetTabsRsp paramstGetTabsRsp) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.a;
    if ((paramWeishiTask.b()) && ((paramWeishiTask.m instanceof stGetTabsRsp)))
    {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, "feeds", true);
      paramWeishiTask = (stGetTabsRsp)paramWeishiTask.m;
      WeiShiCacheManager.a().a(paramWeishiTask);
      WSHomeFragmentPresenter.b(this.c, paramWeishiTask);
      if (this.c.getView() != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTabsInfo size: ");
        localStringBuilder.append(paramWeishiTask.Tabs.size());
        WSLog.a("WSHomeFragmentPresenter", localStringBuilder.toString());
        ((IWSHomeView)this.c.getView()).a(paramWeishiTask);
      }
      return;
    }
    WSHomeFragmentPresenter.b(this.c, this.b);
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.g, paramWeishiTask.d, paramWeishiTask.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.6
 * JD-Core Version:    0.7.0.1
 */