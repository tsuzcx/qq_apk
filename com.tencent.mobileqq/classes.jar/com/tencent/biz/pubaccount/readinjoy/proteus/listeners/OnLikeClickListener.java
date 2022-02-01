package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLikeButton;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OnLikeClickListener
  extends OnSocialOperationListener
{
  public OnLikeClickListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  private void a(ButtonBase paramButtonBase)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramButtonBase != null) && (!paramButtonBase.isSelected())) {
      RIJFeedsDynamicInsertController.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_LOVE, 0, 0, 0));
    }
  }
  
  private void b(ViewBase paramViewBase)
  {
    if ((paramViewBase instanceof ButtonBase))
    {
      paramViewBase = (ButtonBase)paramViewBase;
      b(paramViewBase);
      a(paramViewBase);
    }
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_like_button");
    } while (!(paramViewBase instanceof ReadInJoyLikeButton));
    paramViewBase = (ReadInJoyLikeButton)paramViewBase;
    paramViewBase.onClick();
    a(paramViewBase);
  }
  
  private void b(ButtonBase paramButtonBase)
  {
    boolean bool = true;
    int i;
    if (paramButtonBase.isSelected())
    {
      i = -1;
      paramButtonBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo;
      paramButtonBase.b += i;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b < 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b = 0;
      }
      paramButtonBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo;
      if (i <= 0) {
        break label136;
      }
    }
    label136:
    for (int j = 1;; j = 0)
    {
      paramButtonBase.c = j;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
      com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if ((!RIJPreParseData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID))) {
        break label141;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ATLAS", 2, "atlas native has undercarriage");
      }
      ReadInJoyLogicEngineEventDispatcher.a().c();
      return;
      i = 1;
      break;
    }
    label141:
    paramButtonBase = ReadInJoyLogicEngine.a();
    long l1 = ReadInJoyUtils.a();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId;
    if (i > 0) {}
    for (;;)
    {
      paramButtonBase.a(l1, l2, bool, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.clone());
      break;
      bool = false;
    }
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.c == 1) {
      return 2;
    }
    return 13;
  }
  
  protected void a(ArticleInfo paramArticleInfo)
  {
    String str2 = RIJTransMergeKanDianReport.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    boolean bool = ReadinjoyReportUtils.a(paramArticleInfo.mChannelID);
    Object localObject;
    String str1;
    if (bool)
    {
      localObject = "0X800935E";
      if (!bool) {
        break label173;
      }
      str1 = "0X800935F";
      label35:
      if (localSocializeFeedsInfo.c != 1) {
        break label288;
      }
      if ((!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        break label180;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), (String)localObject, (String)localObject, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!RIJFeedsType.l(paramArticleInfo)) && (!RIJFeedsType.m(paramArticleInfo))) {
        RIJFrameworkReportManager.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
    }
    label173:
    label180:
    do
    {
      return;
      localObject = "0X8007B65";
      break;
      str1 = "0X8007B66";
      break label35;
      if (RIJPreParseData.a(paramArticleInfo))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("like", 0);
          GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, "0X8009A74", (JSONObject)localObject);
          return;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, (String)localObject, (String)localObject, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
      return;
      if ((!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.g(paramArticleInfo)) && (!RIJItemViewType.j(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) {
        break label413;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), localJSONException1, localJSONException1, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
    } while ((RIJFeedsType.l(paramArticleInfo)) || (RIJFeedsType.m(paramArticleInfo)));
    label288:
    RIJFrameworkReportManager.b(paramArticleInfo, (int)paramArticleInfo.mChannelID);
    return;
    label413:
    if (RIJPreParseData.a(paramArticleInfo))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("like", 1);
        GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, paramArticleInfo, "0X8009A74", (JSONObject)localObject);
        return;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, localJSONException2, localJSONException2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnLikeClickListener", 1, "cick like");
    b(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnLikeClickListener
 * JD-Core Version:    0.7.0.1
 */