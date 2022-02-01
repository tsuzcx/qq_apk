package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class OnUserCommentClickListener
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  
  public OnUserCommentClickListener(ArticleInfo paramArticleInfo, Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (RIJItemViewType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, false, 0, 1);
    }
    for (;;)
    {
      GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
      OnSocialOperationListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009442", "0X8009445");
      return;
      if (RIJPreParseData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A77", null);
      }
      else
      {
        RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, false, 0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnUserCommentClickListener
 * JD-Core Version:    0.7.0.1
 */