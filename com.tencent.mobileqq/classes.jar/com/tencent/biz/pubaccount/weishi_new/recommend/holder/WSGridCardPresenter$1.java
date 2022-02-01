package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.OnDownloadOpenWeishiGoH5Listener;

class WSGridCardPresenter$1
  implements WeishiUtils.OnDownloadOpenWeishiGoH5Listener
{
  WSGridCardPresenter$1(WSGridCardPresenter paramWSGridCardPresenter, Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void a(String paramString, int paramInt)
  {
    WSGridCardPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, 501);
    WSReportDc00898.a(114, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.type, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.id);
    WSGridBeaconReport.a("gzh_click", 1000003, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, WSGridCardPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter).a);
  }
  
  public void b(String paramString, int paramInt)
  {
    WSGridCardPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSGridCardPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    WSReportDc00898.a(115, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.type, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.id);
    WSGridBeaconReport.a("gzh_click", 1000002, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, WSGridCardPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendHolderWSGridCardPresenter).a);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCardPresenter.1
 * JD-Core Version:    0.7.0.1
 */