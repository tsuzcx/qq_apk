package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData.SearchWord;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class WebFastRelatedSearchCreator$RelatedSearchViewHolder$1
  implements View.OnClickListener
{
  WebFastRelatedSearchCreator$RelatedSearchViewHolder$1(WebFastRelatedSearchCreator.RelatedSearchViewHolder paramRelatedSearchViewHolder, int paramInt, RelatedSearchData.SearchWord paramSearchWord, BaseData paramBaseData) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    QLog.d("WebFastRelatedSearchCreator", 1, new Object[] { "click search word, position = ", Integer.valueOf(this.jdField_a_of_type_Int), ", word = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData$SearchWord.a, ", jumpUrl = ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData$SearchWord.b });
    for (;;)
    {
      try
      {
        localObject = new RIJTransMergeKanDianReport.ReportR5Builder().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.j).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData$SearchWord, this.jdField_a_of_type_Int).f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c);
        if (!RIJAladdinUtils.f()) {
          continue;
        }
        WebFastRelatedSearchCreator.a("0X800983F", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).p(i).g(((RelatedSearchData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData).a).a());
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        localJSONException.printStackTrace();
        continue;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData$SearchWord.b))
      {
        localObject = new Intent(WebFastRelatedSearchCreator.RelatedSearchViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastRelatedSearchCreator$RelatedSearchViewHolder), PublicAccountBrowserImpl.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData$SearchWord.b);
        WebFastRelatedSearchCreator.RelatedSearchViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastRelatedSearchCreator$RelatedSearchViewHolder).startActivity((Intent)localObject);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastRelatedSearchCreator.RelatedSearchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */