package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public class OnBiuClickListener
  extends OnSocialOperationListener
{
  public OnBiuClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  protected int a()
  {
    return 25;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    String str = ReadInJoyUtils.a(paramArticleInfo);
    if ((ReadInJoyBaseAdapter.g(paramArticleInfo)) || (ReadInJoyBaseAdapter.f(paramArticleInfo)) || (ReadInJoyBaseAdapter.h(paramArticleInfo)) || (ReadInJoyBaseAdapter.i(paramArticleInfo)))
    {
      if (!ReadInJoyBaseAdapter.m(paramArticleInfo)) {
        PublicAccountReportUtils.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007EE4", "0X8007EE4", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "", str, false);
      }
      ReadInJoyBaseAdapter.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      return;
    }
    PublicAccountReportUtils.a(null, paramArticleInfo.mSubscribeID, "0X8007EE4", "0X8007EE4", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "", str, false);
  }
  
  protected void b(ViewBase paramViewBase)
  {
    Intent localIntent;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramViewBase = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localIntent = new Intent(paramViewBase, ReadInJoyDeliverBiuActivity.class);
      localIntent.putExtra("arg_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      localIntent.putExtra("feedsType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID != 70L) {
        break label98;
      }
      localIntent.putExtra("biu_src", 9);
      localIntent.putExtra("arg_from_type", 14);
    }
    for (;;)
    {
      paramViewBase.startActivity(localIntent);
      paramViewBase.overridePendingTransition(0, 0);
      return;
      label98:
      localIntent.putExtra("biu_src", 1);
      localIntent.putExtra("arg_from_type", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnBiuClickListener
 * JD-Core Version:    0.7.0.1
 */