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
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class BigImageVideoProteusItem$1
  implements ViewBase.OnClickListener
{
  BigImageVideoProteusItem$1(BigImageVideoProteusItem paramBigImageVideoProteusItem, BaseArticleInfo paramBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances.isEmpty())) {
      return;
    }
    QLog.i("BigImageVideoProteusItem", 1, "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances);
    paramViewBase = (VideoColumnInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.columnEntrances.get(0);
    QLog.i("BigImageVideoProteusItem", 1, "" + paramViewBase);
    if ((paramViewBase.a != null) && (paramViewBase.a.a != 3)) {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().getContext(), paramViewBase.a);
    }
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase);
    RIJDtReportHelper.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.BigImageVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */