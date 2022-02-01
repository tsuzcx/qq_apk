package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.InteraActionReportUtils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OnSocialHeaderFollowClickListener
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public OnSocialHeaderFollowClickListener(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static long a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramArticleInfo.mSubscribeID);
      return l;
    }
    catch (NumberFormatException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
      return 0L;
    }
    catch (Exception paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return 0L;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.needShowFollwedButton = true;
    }
    String str = String.valueOf(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    ReadInJoyUserInfoModule.a(Long.valueOf(str).longValue(), new OnSocialHeaderFollowClickListener.1(this, localQQAppInterface, str));
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      return;
    }
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    boolean bool;
    OnSocialHeaderFollowClickListener.2 local2;
    if (!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      bool = true;
      local2 = new OnSocialHeaderFollowClickListener.2(this, paramBoolean);
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 2)
    {
      localUserOperationModule.a(paramQQAppInterface, paramString1, bool, paramString2, local2, i);
      d();
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArticleInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mSocialFeedInfo.h == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b()
  {
    String str2 = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID, RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, 0, 0, NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext), a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) + "", null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)) {}
    for (String str1 = "0X800941D";; str1 = "0X80080EC")
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) + "", str1, str1, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), Integer.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), str2, false);
      return;
    }
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ArticleInfo localArticleInfo;
    if (localQQAppInterface != null)
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (localArticleInfo != null)
      {
        localArticleInfo.needShowFollwedButton = true;
        if (!ReadinjoyReportUtils.a(localArticleInfo.mChannelID)) {
          break label103;
        }
      }
    }
    label103:
    for (String str = "0X800941D";; str = "0X80080EC")
    {
      RIJFrameworkReportManager.a(localArticleInfo, str, str, (int)localArticleInfo.mChannelID);
      ReadInJoyLogicEngine.d(localArticleInfo);
      if (localArticleInfo.mSocialFeedInfo != null)
      {
        str = String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
        ReadInJoyUserInfoModule.a(Long.valueOf(str).longValue(), new OnSocialHeaderFollowClickListener.3(this, localQQAppInterface, str));
      }
      d();
      return;
    }
  }
  
  private void d()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new ReportInfo.FeedsReportData();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
          ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        }
        ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).d;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((SocializeFeedsInfo.FeedsInfoUser)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 14;
      localReportInfo.mFeedsReportData = ((ReportInfo.FeedsReportData)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ReadInJoyLogicEngine.a().a((List)localObject1);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      QLog.d("OnSocialHeaderFollowClickListener", 2, "OnSocialHeaderFollowClickListener: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle);
      ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, ReadinjoyReportUtils.e, "");
      if ((this.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_Int != 83) && (this.jdField_a_of_type_Int != 84) && (this.jdField_a_of_type_Int != 85) && (this.jdField_a_of_type_Int != 86) && (this.jdField_a_of_type_Int != 77) && (this.jdField_a_of_type_Int != 78) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isPGCShortContent()) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isAccountShown)) {
        break label181;
      }
      a();
    }
    for (;;)
    {
      InteraActionReportUtils.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
      RIJFeedsDynamicInsertController.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_FOLLOW, 0, 0, 0));
      return;
      label181:
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener
 * JD-Core Version:    0.7.0.1
 */