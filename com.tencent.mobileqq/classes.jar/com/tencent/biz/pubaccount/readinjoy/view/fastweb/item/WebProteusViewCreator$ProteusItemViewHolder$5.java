package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class WebProteusViewCreator$ProteusItemViewHolder$5
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$5(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      paramViewBase = (AuthorData)paramProteusItemData;
      if (!TextUtils.isEmpty(paramViewBase.jdField_a_of_type_JavaLangString)) {
        break label23;
      }
    }
    label23:
    while (paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    paramContext = paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramContext;
    paramProteusItemData = ((AuthorData)paramProteusItemData).c;
    FastWebPTSUtils.a(this.a.a.getContext(), paramContext, paramProteusItemData, paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.5
 * JD-Core Version:    0.7.0.1
 */