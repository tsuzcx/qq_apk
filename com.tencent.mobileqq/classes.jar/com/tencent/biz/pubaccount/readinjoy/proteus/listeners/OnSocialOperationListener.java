package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OnSocialOperationListener
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  OnSocialOperationListener(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo != null)
    {
      ReportInfo localReportInfo = new ReportInfo();
      Object localObject = paramArticleInfo.mSocialFeedInfo;
      ReportInfo.FeedsReportData localFeedsReportData = new ReportInfo.FeedsReportData();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
      localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
      localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
      localReportInfo.mServerContext = paramArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mOperation = paramInt;
      if (localObject != null)
      {
        localFeedsReportData.jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
          localFeedsReportData.jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        }
        localFeedsReportData.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        localFeedsReportData.jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject).d;
        paramArticleInfo = ((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaUtilList;
        if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
        {
          localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramArticleInfo = paramArticleInfo.iterator();
          while (paramArticleInfo.hasNext())
          {
            localObject = (SocializeFeedsInfo.FeedsInfoUser)paramArticleInfo.next();
            if (localObject != null) {
              localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((SocializeFeedsInfo.FeedsInfoUser)localObject).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mFeedsReportData = localFeedsReportData;
      paramArticleInfo = new ArrayList();
      paramArticleInfo.add(localReportInfo);
      ReadInJoyLogicEngine.a().a(paramArticleInfo);
    }
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    a(paramArticleInfo);
    a(paramArticleInfo, a());
  }
  
  protected abstract int a();
  
  protected abstract void a(ArticleInfo paramArticleInfo);
  
  public final void a(ViewBase paramViewBase)
  {
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    b(paramViewBase);
    c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
  
  protected abstract void b(ViewBase paramViewBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialOperationListener
 * JD-Core Version:    0.7.0.1
 */