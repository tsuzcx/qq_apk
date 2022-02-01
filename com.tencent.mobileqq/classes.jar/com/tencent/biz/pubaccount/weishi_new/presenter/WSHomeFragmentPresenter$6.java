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
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if ((paramWeishiTask.a()) && ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stGetTabsRsp)))
    {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "feeds", true);
      paramWeishiTask = (stGetTabsRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      WeiShiCacheManager.a().a(paramWeishiTask);
      WSHomeFragmentPresenter.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSHomeFragmentPresenter, paramWeishiTask);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSHomeFragmentPresenter.a() != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTabsInfo size: ");
        localStringBuilder.append(paramWeishiTask.Tabs.size());
        WSLog.a("WSHomeFragmentPresenter", localStringBuilder.toString());
        ((IWSHomeView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSHomeFragmentPresenter.a()).a(paramWeishiTask);
      }
      return;
    }
    WSHomeFragmentPresenter.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSHomeFragmentPresenter, this.jdField_a_of_type_UserGrowthStGetTabsRsp);
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.6
 * JD-Core Version:    0.7.0.1
 */