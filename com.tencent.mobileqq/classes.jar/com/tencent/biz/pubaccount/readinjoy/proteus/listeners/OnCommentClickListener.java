package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class OnCommentClickListener
  extends OnSocialOperationListener
{
  public OnCommentClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  protected int a()
  {
    return 3;
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    String str = ReadInJoyUtils.a(paramArticleInfo);
    if ((ReadInJoyBaseAdapter.g(paramArticleInfo)) || (ReadInJoyBaseAdapter.f(paramArticleInfo)) || (ReadInJoyBaseAdapter.h(paramArticleInfo)) || (ReadInJoyBaseAdapter.i(paramArticleInfo)))
    {
      if (!ReadInJoyBaseAdapter.m(paramArticleInfo)) {
        PublicAccountReportUtils.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007B67", "0X8007B67", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "", str, false);
      }
      ReadInJoyBaseAdapter.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      return;
    }
    PublicAccountReportUtils.a(null, paramArticleInfo.mSubscribeID, "0X8007B67", "0X8007B67", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "", str, false);
  }
  
  protected void b(ViewBase paramViewBase)
  {
    if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, true, 0, true);
      return;
    }
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnCommentClickListener
 * JD-Core Version:    0.7.0.1
 */