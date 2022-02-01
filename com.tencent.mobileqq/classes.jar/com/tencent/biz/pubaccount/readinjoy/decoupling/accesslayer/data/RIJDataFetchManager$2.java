package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRespData;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class RIJDataFetchManager$2
  implements RIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  RIJDataFetchManager$2(RIJDataFetchManager paramRIJDataFetchManager, ArticleInfo paramArticleInfo) {}
  
  public void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    if (paramRIJBiuAndCommentRespData.a() == 0)
    {
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, new CommentInfo(), false);
      QQToast.a(RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager).a(), 2, RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager).a().getString(2131718160), 0).a();
    }
    for (;;)
    {
      RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager);
      RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataFetchManager, null);
      return;
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712856), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.2
 * JD-Core Version:    0.7.0.1
 */