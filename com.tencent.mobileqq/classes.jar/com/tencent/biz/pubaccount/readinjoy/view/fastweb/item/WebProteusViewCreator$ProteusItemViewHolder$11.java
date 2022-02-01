package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJMiniProgramUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.MiniAppData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebProteusReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class WebProteusViewCreator$ProteusItemViewHolder$11
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$11(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    ArticleInfo localArticleInfo = paramProteusItemData.b;
    FastWebArticleInfo localFastWebArticleInfo = paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
    String str = paramViewBase.getEventAttachedData();
    FastWebProteusReportUtils.b(localArticleInfo, localFastWebArticleInfo, paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    FastWebProteusReportUtils.a(localArticleInfo, localFastWebArticleInfo, paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if (!TextUtils.isEmpty(str))
    {
      if (((paramProteusItemData instanceof MiniAppData)) && (localArticleInfo != null))
      {
        localArticleInfo.miniProgramName = ((MiniAppData)paramProteusItemData).a;
        localArticleInfo.miniAppMovieName = ((MiniAppData)paramProteusItemData).b;
        localArticleInfo.miniRowKey = ((MiniAppData)paramProteusItemData).c;
        RIJMiniProgramUtils.a.a(localArticleInfo, 2, str);
      }
    }
    else {
      return;
    }
    RIJJumpUtils.a(paramContext, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.11
 * JD-Core Version:    0.7.0.1
 */