package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import org.json.JSONException;
import org.json.JSONObject;

class WebFastTitleViewCreator$TitleViewHolder$1
  implements UserOperationModule.Ox978RespCallBack
{
  WebFastTitleViewCreator$TitleViewHolder$1(WebFastTitleViewCreator.TitleViewHolder paramTitleViewHolder) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    WebFastTitleViewCreator.TitleViewHolder.a(this.a, true);
    Context localContext = this.a.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c()) {
      paramString = "2";
    }
    for (;;)
    {
      paramString = RIJTransMergeKanDianReport.a(localContext, localArticleInfo, 0, paramString);
      if (paramBoolean) {
        paramInt = 1;
      }
      try
      {
        for (;;)
        {
          paramString.put("is_done", paramInt);
          ReportUtil.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X800898B", paramString.toString());
          return;
          paramString = "1";
          break;
          paramInt = 2;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastTitleViewCreator.TitleViewHolder.1
 * JD-Core Version:    0.7.0.1
 */