package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ArticleBasicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LongContentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PgcShortContentProteusItem$5
  implements View.OnClickListener
{
  PgcShortContentProteusItem$5(PgcShortContentProteusItem paramPgcShortContentProteusItem, IReadInJoyModel paramIReadInJoyModel, PgcSmallView paramPgcSmallView, Container paramContainer) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    localArticleInfo.clickArea = 11;
    QLog.d("PgcShortContentProteusItem", 1, "click short content small image");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_Int == 3)
    {
      localArticleInfo.clickJumpTarget = PGCShortContentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.h, "-1");
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCVideoInfo.h, null);
    }
    for (;;)
    {
      RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localArticleInfo.clickJumpTarget = PGCShortContentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ArticleBasicInfo.c, "-1");
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ArticleBasicInfo.c, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.PgcShortContentProteusItem.5
 * JD-Core Version:    0.7.0.1
 */