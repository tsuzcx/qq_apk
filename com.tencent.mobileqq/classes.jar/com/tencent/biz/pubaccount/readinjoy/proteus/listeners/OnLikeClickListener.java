package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;

public class OnLikeClickListener
  extends OnSocialOperationListener
{
  public OnLikeClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  protected int a()
  {
    if (this.a.mSocialFeedInfo.c == 1) {
      return 2;
    }
    return 13;
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    String str = ReadInJoyUtils.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (localSocializeFeedsInfo.c == 1)
    {
      if ((ReadInJoyBaseAdapter.g(paramArticleInfo)) || (ReadInJoyBaseAdapter.f(paramArticleInfo)) || (ReadInJoyBaseAdapter.h(paramArticleInfo)) || (ReadInJoyBaseAdapter.i(paramArticleInfo)))
      {
        if (!ReadInJoyBaseAdapter.m(paramArticleInfo)) {
          PublicAccountReportUtils.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007B65", "0X8007B65", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "", str, false);
        }
        ReadInJoyBaseAdapter.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
        return;
      }
      PublicAccountReportUtils.a(null, paramArticleInfo.mSubscribeID, "0X8007B65", "0X8007B65", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "", str, false);
      return;
    }
    if ((ReadInJoyBaseAdapter.g(paramArticleInfo)) || (ReadInJoyBaseAdapter.f(paramArticleInfo)) || (ReadInJoyBaseAdapter.h(paramArticleInfo)) || (ReadInJoyBaseAdapter.i(paramArticleInfo)))
    {
      if (!ReadInJoyBaseAdapter.m(paramArticleInfo)) {
        PublicAccountReportUtils.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007B66", "0X8007B66", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "", str, false);
      }
      ReadInJoyBaseAdapter.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      return;
    }
    PublicAccountReportUtils.a(null, paramArticleInfo.mSubscribeID, "0X8007B66", "0X8007B66", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "", str, false);
  }
  
  protected void b(ViewBase paramViewBase)
  {
    boolean bool = true;
    int i;
    int j;
    label58:
    long l1;
    long l2;
    if ((paramViewBase instanceof ButtonBase))
    {
      if (!((ButtonBase)paramViewBase).g()) {
        break label142;
      }
      i = -1;
      SocializeFeedsInfo localSocializeFeedsInfo = this.a.mSocialFeedInfo;
      localSocializeFeedsInfo.b += i;
      localSocializeFeedsInfo = this.a.mSocialFeedInfo;
      if (i <= 0) {
        break label147;
      }
      j = 1;
      localSocializeFeedsInfo.c = j;
      j = this.a.mSocialFeedInfo.b;
      ((ButtonBase)paramViewBase).a(Util.a(j, "赞"));
      this.a.invalidateProteusTemplateBean();
      ReadInJoyUtils.a = this.a;
      paramViewBase = ReadInJoyLogicEngine.a();
      l1 = ReadInJoyUtils.a();
      l2 = this.a.mFeedId;
      if (i <= 0) {
        break label152;
      }
    }
    for (;;)
    {
      paramViewBase.a(l1, l2, bool, this.a.clone());
      return;
      label142:
      i = 1;
      break;
      label147:
      j = 0;
      break label58;
      label152:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnLikeClickListener
 * JD-Core Version:    0.7.0.1
 */