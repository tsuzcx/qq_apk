package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler.RequestSearchWordCallback;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.HashMap;
import mqq.os.MqqHandler;
import pb.unite.search.RequestSearchWord.Rcmd;

class RIJListViewGroupHandlerClick$2
  implements UniteSearchHandler.RequestSearchWordCallback
{
  RIJListViewGroupHandlerClick$2(RIJListViewGroupHandlerClick paramRIJListViewGroupHandlerClick, HashMap paramHashMap, ArticleInfo paramArticleInfo, int paramInt1, RIJListViewGroupHandlerClick.Builder paramBuilder, int paramInt2) {}
  
  public void a(PBRepeatMessageField<RequestSearchWord.Rcmd> paramPBRepeatMessageField, PBStringField paramPBStringField)
  {
    if ((paramPBRepeatMessageField == null) || (paramPBRepeatMessageField.size() <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRefreshTime)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRefreshTime, Integer.valueOf(this.jdField_a_of_type_Int + 1));
    }
    for (;;)
    {
      SharedPreUtils.a("search_word_prefix_show_times", SharedPreUtils.b("search_word_prefix_show_times") + 1L);
      ThreadManager.getUIHandler().post(new RIJListViewGroupHandlerClick.2.1(this, paramPBRepeatMessageField, paramPBStringField));
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRefreshTime, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick.2
 * JD-Core Version:    0.7.0.1
 */