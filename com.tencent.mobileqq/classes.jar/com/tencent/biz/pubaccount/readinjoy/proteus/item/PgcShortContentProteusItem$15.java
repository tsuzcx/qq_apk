package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class PgcShortContentProteusItem$15
  implements ViewBase.OnClickListener
{
  PgcShortContentProteusItem$15(PgcShortContentProteusItem paramPgcShortContentProteusItem, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo != null))
      {
        String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$LongContentInfo.a.h;
        paramViewBase = paramViewBase.getNativeView();
        PgcShortContentProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemPgcShortContentProteusItem, paramViewBase, str);
        paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
        if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
        {
          paramViewBase.clickArea = 11;
          paramViewBase.clickJumpTarget = PGCShortContentUtils.a(str, "-1");
          RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
        }
      }
      return;
    }
    catch (NullPointerException paramViewBase)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramViewBase.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem.15
 * JD-Core Version:    0.7.0.1
 */