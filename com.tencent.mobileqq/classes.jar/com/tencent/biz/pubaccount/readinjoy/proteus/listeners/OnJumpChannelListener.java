package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class OnJumpChannelListener
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public OnJumpChannelListener(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80097D7", "0X80097D7", 0, 0, "", "", "", "", false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    String str = "";
    paramViewBase = str;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      paramViewBase = str;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        paramViewBase = str;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
        {
          paramViewBase = str;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.f != null)
          {
            paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.f;
            RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
          }
        }
      }
    }
    QLog.d("OnFriendsBiuClickListener", 1, "jump channel,  context:" + this.jdField_a_of_type_AndroidContentContext + "  url:" + paramViewBase);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnJumpChannelListener
 * JD-Core Version:    0.7.0.1
 */