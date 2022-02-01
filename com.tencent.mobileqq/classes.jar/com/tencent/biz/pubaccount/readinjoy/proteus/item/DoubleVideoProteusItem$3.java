package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class DoubleVideoProteusItem$3
  implements ViewBase.OnClickListener
{
  DoubleVideoProteusItem$3(DoubleVideoProteusItem paramDoubleVideoProteusItem, BaseArticleInfo paramBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances.isEmpty())) {
      return;
    }
    VideoColumnInfo localVideoColumnInfo = (VideoColumnInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances.get(0);
    if ((localVideoColumnInfo.a != null) && (localVideoColumnInfo.a.a != 3)) {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().getContext(), localVideoColumnInfo.a);
    }
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean, paramViewBase);
    RIJDtReportHelper.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.DoubleVideoProteusItem.3
 * JD-Core Version:    0.7.0.1
 */