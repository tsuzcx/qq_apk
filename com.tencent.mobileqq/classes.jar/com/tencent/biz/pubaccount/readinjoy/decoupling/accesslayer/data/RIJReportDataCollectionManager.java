package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.pts.data.PTSLiteDataFactory;
import com.tencent.biz.pubaccount.readinjoy.pts.data.PTSLiteDataFactory.Companion;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.FeedExposureHelper.Range;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RIJReportDataCollectionManager
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, RIJDataManager paramRIJDataManager)
  {
    int i = 0;
    if (i < paramInt3)
    {
      int j = paramInt1 - paramInt2 + i;
      if ((j >= paramRIJDataManager.a().a().getCount()) || (j < 0)) {}
      for (;;)
      {
        i += 1;
        break;
        ArticleInfo localArticleInfo = (ArticleInfo)paramRIJDataManager.a().a().getItem(j);
        if (localArticleInfo != null) {
          a(localArticleInfo, new ReadInJoyModelImpl(paramRIJDataManager.a().a(), localArticleInfo, paramRIJDataManager.a().a().getItemViewType(j), paramRIJDataManager.a().b(), paramRIJDataManager.a().a(), j, paramRIJDataManager.a().d(), paramRIJDataManager.a().a().getCount(), null, paramRIJDataManager.a().a()), System.currentTimeMillis(), j, paramRIJDataManager);
        }
      }
    }
  }
  
  public static void a(View paramView, int paramInt, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (paramInt == 46) {}
    while ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementId(paramView, "card");
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().a(Integer.valueOf(paramRIJDataManager.a().b())).a("14");
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)))
    {
      paramRIJDataManager = paramBaseArticleInfo.innerUniqueID;
      localRIJDtParamBuilder = localRIJDtParamBuilder.e(paramRIJDataManager).b("list").c("click_contentid");
      if (paramBaseArticleInfo == null) {
        break label172;
      }
      paramRIJDataManager = paramBaseArticleInfo.dtReportBackendInfo;
      label107:
      paramRIJDataManager = localRIJDtParamBuilder.g(paramRIJDataManager);
      if (paramBaseArticleInfo == null) {
        break label178;
      }
      paramInt = paramBaseArticleInfo.dtReportContentType;
      label123:
      VideoReport.setElementParams(paramView, paramRIJDataManager.b(Integer.valueOf(paramInt)).a().a());
      if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))) {
        break label183;
      }
    }
    label172:
    label178:
    label183:
    for (paramBaseArticleInfo = paramBaseArticleInfo.innerUniqueID;; paramBaseArticleInfo = "null")
    {
      VideoReport.setElementReuseIdentifier(paramView, paramBaseArticleInfo);
      return;
      paramRIJDataManager = "null";
      break;
      paramRIJDataManager = "";
      break label107;
      paramInt = 5;
      break label123;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, long paramLong, int paramInt, RIJDataManager paramRIJDataManager)
  {
    if ((paramBaseArticleInfo == null) || (paramRIJDataManager.a().a() == null) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (paramRIJDataManager.a().a().b((ArticleInfo)paramBaseArticleInfo)) && (!PTSLiteItemViewBuilder.a(paramBaseArticleInfo)))) {
      break label47;
    }
    label47:
    while ((((paramBaseArticleInfo instanceof ArticleInfo)) && (PTSLiteItemViewBuilder.a((ArticleInfo)paramBaseArticleInfo))) || ((RIJFeedsType.j(paramBaseArticleInfo)) && (!RIJFeedsType.l(paramBaseArticleInfo)))) {
      return;
    }
    if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mFeedType != 121))
    {
      Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
      while (localIterator.hasNext()) {
        a((ArticleInfo)localIterator.next(), new ReadInJoyModelImpl(paramRIJDataManager.a().a(), (ArticleInfo)paramBaseArticleInfo, 46, paramRIJDataManager.a().b(), paramRIJDataManager.a().a(), paramInt, paramRIJDataManager.a().d(), paramRIJDataManager.a().a().getCount(), null, paramRIJDataManager.a().a()), paramLong, paramInt, paramRIJDataManager);
      }
    }
    PTSLiteDataFactory.a.a(paramBaseArticleInfo, paramLong, paramInt, paramRIJDataManager);
    int i;
    if ((RIJFeedsType.g(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)) {
      if (!paramRIJDataManager.a().a().containsKey(Long.valueOf(-paramBaseArticleInfo.mArticleID))) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        ThreadManager.post(new RIJReportDataCollectionManager.1(paramBaseArticleInfo, paramIReadInJoyModel, paramInt, paramRIJDataManager, paramLong, paramBaseArticleInfo), 5, null, true);
      }
      if (!RIJAladdinUtils.j()) {
        break;
      }
      ThreadManager.executeOnSubThread(new RIJReportDataCollectionManager.2(paramRIJDataManager, paramBaseArticleInfo));
      return;
      i = 0;
      continue;
      if (!paramRIJDataManager.a().a().containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(BaseReportData paramBaseReportData, int paramInt1, int paramInt2)
  {
    if (RIJFeedsType.j(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      paramBaseReportData.jdField_b_of_type_Boolean = true;
    }
    while (paramBaseReportData.jdField_b_of_type_Boolean) {
      return;
    }
    paramBaseReportData.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = paramInt1;
    localReportInfo.mSourceArticleId = paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue();
    if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {}
    ReportInfo.FeedsReportData localFeedsReportData;
    for (paramInt1 = (int)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID;; paramInt1 = 0)
    {
      localReportInfo.mChannelId = paramInt1;
      localReportInfo.mAlgorithmId = ((int)paramBaseReportData.jdField_a_of_type_Long);
      localReportInfo.mStrategyId = paramBaseReportData.jdField_b_of_type_Int;
      localReportInfo.mOperation = paramInt2;
      localReportInfo.mServerContext = paramBaseReportData.jdField_a_of_type_ArrayOfByte;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mInnerId = paramBaseReportData.jdField_e_of_type_JavaLangString;
      if ((paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
        localReportInfo.mColumnID = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if ((paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null) || (RIJFeedsType.l(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) {
        break label395;
      }
      localFeedsReportData = new ReportInfo.FeedsReportData();
      localFeedsReportData.jdField_a_of_type_Long = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        localFeedsReportData.jdField_b_of_type_Long = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      localFeedsReportData.jdField_a_of_type_Int = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localFeedsReportData.jdField_b_of_type_Int = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.d;
      Object localObject = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        break;
      }
      localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject).next();
        if (localFeedsInfoUser != null) {
          localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
        }
      }
    }
    localReportInfo.mFeedsReportData = localFeedsReportData;
    label395:
    localReportInfo.dynamicInsertReportData = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReportInfo$DynamicInsertReportData;
    if ((paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (DailyModeConfigHandler.c((int)paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID)))
    {
      localReportInfo.mSearchTagName = paramBaseReportData.f;
      KandianDailyReportUtils.a(localReportInfo);
      return;
    }
    localArrayList.add(localReportInfo);
    QLog.d("RIJReportDataManager", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public static void a(FeedExposureHelper.Range paramRange, int paramInt, RIJDataManager paramRIJDataManager)
  {
    new ArrayList();
    int i = paramRange.jdField_a_of_type_Int;
    while (i <= paramRange.jdField_b_of_type_Int)
    {
      int j = i - paramInt;
      if (j >= 0)
      {
        BaseArticleInfo localBaseArticleInfo = paramRIJDataManager.a(j);
        if (localBaseArticleInfo != null)
        {
          QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo + " proteusItemsData : " + localBaseArticleInfo.proteusItemsData);
          ReadinjoyReportUtils.a(localBaseArticleInfo, paramRange.jdField_a_of_type_Long);
        }
      }
      i += 1;
    }
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (paramBaseArticleInfo.mFeedType == 3)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = paramRIJDataManager.a().b();
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 7;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        localReportInfo.mInnerId = paramBaseArticleInfo.innerUniqueID;
      }
      localArrayList.add(localReportInfo);
      ReadInJoyLogicEngine.a().a(localArrayList);
    }
  }
  
  private static void b(BaseReportData paramBaseReportData)
  {
    a(paramBaseReportData, 0, 7);
  }
  
  private static void b(BaseReportData paramBaseReportData, RIJDataManager paramRIJDataManager)
  {
    if (DailyModeConfigHandler.c(paramRIJDataManager.a().b())) {}
    try
    {
      paramRIJDataManager.a().a().add(paramBaseReportData);
      return;
    }
    catch (Exception paramBaseReportData)
    {
      QLog.d("RIJReportDataManager", 2, "mDailyReportDatas error!  msg=" + paramBaseReportData);
    }
  }
  
  private static void b(BaseReportData paramBaseReportData, BaseArticleInfo paramBaseArticleInfo, int paramInt, IReadInJoyModel paramIReadInJoyModel)
  {
    if (((RIJItemViewType.g(paramBaseArticleInfo)) || (RIJItemViewType.i((ArticleInfo)paramBaseArticleInfo)) || (RIJItemViewType.j((ArticleInfo)paramBaseArticleInfo)) || (RIJItemViewType.k((ArticleInfo)paramBaseArticleInfo))) && (!RIJItemViewType.o((ArticleInfo)paramBaseArticleInfo)))
    {
      paramBaseReportData.jdField_d_of_type_JavaLangString = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
      paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.businessId);
      if (paramBaseReportData.jdField_e_of_type_Boolean)
      {
        if (!paramIReadInJoyModel.b()) {
          break label338;
        }
        paramInt = 2;
      }
    }
    for (;;)
    {
      paramBaseReportData.jdField_a_of_type_Int = paramInt;
      return;
      if ((RIJFeedsType.i(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6))
      {
        paramBaseReportData.jdField_d_of_type_JavaLangString = (paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long + "");
        paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
        break;
      }
      if (RIJFeedsType.l(paramBaseArticleInfo))
      {
        if (RIJFeedsType.j(paramBaseArticleInfo)) {
          if (paramBaseArticleInfo.mGroupSubArticleList.size() >= 1)
          {
            if (!TextUtils.isEmpty(((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid)) {
              paramBaseReportData.jdField_b_of_type_JavaLangString = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid;
            }
            paramBaseReportData.jdField_e_of_type_JavaLangString = ((BaseArticleInfo)paramBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        for (;;)
        {
          paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
          break;
          paramBaseReportData.k = paramInt;
          if (paramBaseArticleInfo.mPolymericInfo != null) {
            paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean = true;
          }
        }
      }
      if (RIJFeedsType.g(paramBaseArticleInfo))
      {
        paramBaseReportData.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
        paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
        break;
      }
      paramBaseReportData.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
      paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      break;
      label338:
      if (paramIReadInJoyModel.d()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  private static void b(BaseReportData paramBaseReportData, BaseArticleInfo paramBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if ((RIJFeedsType.g(paramBaseArticleInfo)) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
    {
      paramRIJDataManager.a().a().put(Long.valueOf(-paramBaseArticleInfo.mArticleID), paramBaseReportData);
      return;
    }
    paramRIJDataManager.a().a().put(Long.valueOf(paramBaseArticleInfo.mArticleID), paramBaseReportData);
  }
  
  private static void b(BaseReportData paramBaseReportData, BaseArticleInfo paramBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel)
  {
    boolean bool2 = false;
    if ((paramBaseArticleInfo.mGroupId != -1L) || (paramBaseArticleInfo.isSubscriptFeed())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBaseReportData.c = bool1;
      paramBaseReportData.jdField_d_of_type_Boolean = paramIReadInJoyModel.a();
      if (!paramIReadInJoyModel.b())
      {
        bool1 = bool2;
        if (!paramIReadInJoyModel.d()) {}
      }
      else
      {
        bool1 = true;
      }
      paramBaseReportData.jdField_e_of_type_Boolean = bool1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJReportDataCollectionManager
 * JD-Core Version:    0.7.0.1
 */