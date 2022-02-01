package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.FeedExposureHelper;
import com.tencent.biz.pubaccount.util.FeedExposureHelper.Range;
import com.tencent.widget.ListView;

class RIJOnScrollListener$2
  extends FeedExposureHelper
{
  RIJOnScrollListener$2(RIJOnScrollListener paramRIJOnScrollListener, RIJDataManager paramRIJDataManager) {}
  
  public void a(FeedExposureHelper.Range paramRange)
  {
    if (paramRange != null) {
      RIJReportDataCollectionManager.a(paramRange, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a().getHeaderViewsCount(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener.2
 * JD-Core Version:    0.7.0.1
 */