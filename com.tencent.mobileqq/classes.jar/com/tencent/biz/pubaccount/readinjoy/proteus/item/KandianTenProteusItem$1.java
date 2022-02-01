package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

class KandianTenProteusItem$1
  implements ViewBase.OnClickListener
{
  KandianTenProteusItem$1(KandianTenProteusItem paramKandianTenProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    for (;;)
    {
      try
      {
        ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
        ProteusSupportUtil.a(localArticleInfo, localArticleInfo.mProteusTemplateBean, paramViewBase);
        RIJDtReportHelper.a.a(localArticleInfo);
        int j = 0;
        if (PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.reading"))
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() == 2)
          {
            paramViewBase = KandianTenProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemKandianTenProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().weishiUGInfo.msg_url_jump_info.bytes_jump_schema);
            i = j;
            if (!TextUtils.isEmpty(paramViewBase))
            {
              KandianTenProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemKandianTenProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
              break label323;
            }
          }
          if (i == 0)
          {
            paramViewBase = new JSONObject(localArticleInfo.proteusItemsData).getString("kandian_jump_url");
            if (!TextUtils.isEmpty(paramViewBase)) {
              SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
            }
          }
          KandianUGStatisticUtils.a(KandianTenProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemKandianTenProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().weishiUGInfo.bytes_report_base_url) + KandianTenProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemKandianTenProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().weishiUGInfo.bytes_click_report_tail));
        }
        else
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().weishiUGInfo.msg_url_jump_info.uint32_jump_type.get() != 1) {
            continue;
          }
          paramViewBase = KandianTenProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemKandianTenProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().weishiUGInfo.msg_url_jump_info.bytes_jump_url);
          i = j;
          if (TextUtils.isEmpty(paramViewBase)) {
            continue;
          }
          SearchUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
        }
      }
      catch (Exception paramViewBase)
      {
        return;
      }
      label323:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.KandianTenProteusItem.1
 * JD-Core Version:    0.7.0.1
 */