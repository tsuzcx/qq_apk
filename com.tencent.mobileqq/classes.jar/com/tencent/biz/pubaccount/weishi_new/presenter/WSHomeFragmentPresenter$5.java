package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stGetAIOFeedDetailRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSHomeFragmentPresenter$5
  implements IWeishiServiceListener
{
  WSHomeFragmentPresenter$5(WSHomeFragmentPresenter paramWSHomeFragmentPresenter, long paramLong) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if ((!paramWeishiTask.a()) || (!(paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stGetAIOFeedDetailRsp))) {
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
    }
    stSimpleMetaFeed localstSimpleMetaFeed;
    do
    {
      return;
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "feeds", true);
      paramWeishiTask = (stGetAIOFeedDetailRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      localstSimpleMetaFeed = paramWeishiTask.feed;
      WSLog.e("WSHomeFragmentPresenter", "[getAIOFeedDetail] onTaskResponse");
    } while ((!paramWeishiTask.enable) || (localstSimpleMetaFeed == null));
    WSHomeFragmentPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPresenterWSHomeFragmentPresenter, localstSimpleMetaFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.5
 * JD-Core Version:    0.7.0.1
 */