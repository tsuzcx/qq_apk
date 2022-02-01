package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertUtil;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.presenter.IReadInJoyPresenter;
import com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyArticleAdapter
  extends ReadInJoyBaseAdapter
  implements DecodeTaskCompletionListener
{
  private IFaceDecoder a;
  
  public ReadInJoyArticleAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, IFaceDecoder paramIFaceDecoder, SparseArray<BaseHandler> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public int a(int paramInt)
  {
    return RIJItemViewType.a((ArticleInfo)b(paramInt), this.d);
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public BaseArticleInfo a(int paramInt)
  {
    return ReadInJoyLogicEngine.a().a(Integer.valueOf(this.c));
  }
  
  public BaseArticleInfo a(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(this.c, paramLong);
  }
  
  public IFaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  }
  
  public void a()
  {
    super.a();
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = Math.min(a().size(), 200);
    int i = 0;
    if (i < j)
    {
      BaseArticleInfo localBaseArticleInfo = b(i);
      MultiVideoColumnInfo localMultiVideoColumnInfo;
      if ((localBaseArticleInfo.mResolvedFeedType == 142) && (localBaseArticleInfo.multiVideoColumnInfo != null) && (localBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_Int == paramInt1))
      {
        localMultiVideoColumnInfo = localBaseArticleInfo.multiVideoColumnInfo;
        if (paramInt2 != 1) {
          break label125;
        }
      }
      label125:
      for (boolean bool = true;; bool = false)
      {
        localMultiVideoColumnInfo.jdField_a_of_type_Boolean = bool;
        localBaseArticleInfo.multiVideoColumnInfo.d = paramInt3;
        if ((localBaseArticleInfo instanceof ArticleInfo)) {
          ReadInJoyLogicEngine.a().b((ArticleInfo)localBaseArticleInfo);
        }
        i += 1;
        break;
      }
    }
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList)
  {
    Object localObject = (ArticleInfo)paramBaseArticleInfo;
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (ReadinjoyFixPosArticleManager.a(paramBaseArticleInfo.mRecommendSeq))
            {
              ReadinjoyFixPosArticleManager.a().a(this.c, paramBaseArticleInfo.mRecommendSeq);
              return;
            }
            paramBaseArticleInfo = ReadInJoyUtils.a();
            Iterator localIterator = paramArrayList.iterator();
            while (localIterator.hasNext())
            {
              DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
              if (localDislikeInfo.jdField_a_of_type_Int == 5) {
                a(localDislikeInfo.b);
              }
            }
            ReadInJoyLogicEngine.a().a(Long.valueOf(paramBaseArticleInfo).longValue(), ((ArticleInfo)localObject).makeDislikeParam(paramArrayList));
            ReadInJoyLogicEngine.a().a(this.c, (BaseArticleInfo)localObject);
          } while (paramInt != 0);
          paramBaseArticleInfo = (QQAppInterface)ReadInJoyUtils.a();
          paramArrayList = (KandianMergeManager)paramBaseArticleInfo.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
          if (a().size() <= 0) {
            break;
          }
        } while (this.c != 0);
        localObject = b(0);
      } while (localObject == null);
      paramArrayList = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBriefPrefix(RIJQQAppInterfaceUtil.b(), (BaseArticleInfo)localObject);
      localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBriefSuffix((BaseArticleInfo)localObject);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramBaseArticleInfo, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime()), paramArrayList, true);
      return;
      ReadInJoyLogicEngine.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    paramArrayList = paramBaseArticleInfo.getApp().getResources().getString(2131695233);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramBaseArticleInfo, paramArrayList, String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = ReadInJoyUtils.a();
    ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList.get(0);
    if (localArticleInfo != null) {
      ReadInJoyLogicEngine.a().a(Long.valueOf((String)localObject).longValue(), localArticleInfo.makeDislikeParam(paramArrayList1));
    }
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localObject = (DislikeInfo)paramArrayList1.next();
      if (((DislikeInfo)localObject).jdField_a_of_type_Int == 5) {
        a(((DislikeInfo)localObject).b);
      }
    }
    int i = 0;
    if (i < paramArrayList.size())
    {
      paramArrayList1 = (ArticleInfo)paramArrayList.get(i);
      if (paramArrayList1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayList1.mRecommendSeq;
        if (ReadinjoyFixPosArticleManager.a(l)) {
          ReadinjoyFixPosArticleManager.a().a(this.c, l);
        } else {
          ReadInJoyLogicEngine.a().a(this.c, paramArrayList1);
        }
      }
    }
    if (paramInt == 0)
    {
      paramArrayList = (QQAppInterface)ReadInJoyUtils.a();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (a().size() <= 0) {
        break label276;
      }
      if (this.c == 0)
      {
        localObject = b(0);
        if (localObject != null)
        {
          paramArrayList1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBriefPrefix(RIJQQAppInterfaceUtil.b(), (BaseArticleInfo)localObject);
          localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createStructingMsgBriefSuffix((BaseArticleInfo)localObject);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramArrayList, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime()), paramArrayList1, true);
        }
      }
    }
    label276:
    do
    {
      return;
      ReadInJoyLogicEngine.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    paramArrayList1 = paramArrayList.getApp().getResources().getString(2131695233);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramArrayList, paramArrayList1, String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseArticleInfo == null) || (paramVideoPlayParam == null)) {
      return;
    }
    if (paramBoolean2) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a(paramVideoPlayParam, paramBaseArticleInfo);
    }
    if (this.c != 40677)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = this.c;
      localReportInfo.mAlgorithmId = ((int)paramBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 1;
      localReportInfo.mServerContext = paramBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mInnerId = paramBaseArticleInfo.innerUniqueID;
      localReportInfo.videoReportInfo = paramBaseArticleInfo.videoReportInfo;
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localReportInfo.mColumnID = paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        ReportInfo.FeedsReportData localFeedsReportData = new ReportInfo.FeedsReportData();
        localFeedsReportData.jdField_a_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
          localFeedsReportData.jdField_b_of_type_Long = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        }
        localFeedsReportData.jdField_a_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localFeedsReportData.jdField_b_of_type_Int = paramBaseArticleInfo.mSocialFeedInfo.d;
        Object localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
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
      }
      localArrayList.add(localReportInfo);
      ReadInJoyLogicEngine.a().a(localArrayList);
    }
    ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
    RIJFeedsInsertUtil.a.b(this.c, paramBaseArticleInfo);
    super.a(paramVideoPlayParam, paramBaseArticleInfo, paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return RIJAppSetting.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new PublicAccountUnfollowTask((QQAppInterface)ReadInJoyUtils.a(), paramString, this.jdField_a_of_type_AndroidAppActivity).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(Long.valueOf(paramLong));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount();
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          Object localObject = (IReadInJoyModel)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381651);
          ReadInJoyView localReadInJoyView = (ReadInJoyView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381656);
          IReadInJoyPresenter localIReadInJoyPresenter = (IReadInJoyPresenter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131381653);
          if ((localObject != null) && (localReadInJoyView != null) && (localIReadInJoyPresenter != null)) {
            localIReadInJoyPresenter.a(localReadInJoyView, (IReadInJoyModel)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
          }
          if ((localObject != null) && (CellFactory.a(((IReadInJoyModel)localObject).a())))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            if (localObject != null)
            {
              localObject = (FeedItemCell)((View)localObject).getTag();
              if (localObject == null) {}
            }
          }
          try
          {
            ((FeedItemCell)localObject).a(Long.valueOf(paramString).longValue(), paramBitmap);
            paramInt1 += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter
 * JD-Core Version:    0.7.0.1
 */