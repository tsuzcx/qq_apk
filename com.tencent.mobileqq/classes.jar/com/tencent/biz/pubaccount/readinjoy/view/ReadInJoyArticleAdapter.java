package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.presenter.IReadInJoyPresenter;
import com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.ReadInJoyAccountActiveTips;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyArticleAdapter
  extends ReadInJoyBaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private ReadInJoyAccountActiveTips jdField_a_of_type_ComTencentWidgetReadInJoyAccountActiveTips;
  
  public ReadInJoyArticleAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  public int a(int paramInt)
  {
    return a((ArticleInfo)this.b.get(paramInt), this.d);
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
  
  public FaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentWidgetReadInJoyAccountActiveTips != null) {
      this.jdField_a_of_type_ComTencentWidgetReadInJoyAccountActiveTips = null;
    }
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList paramArrayList)
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
          paramArrayList = (KandianMergeManager)paramBaseArticleInfo.getManager(161);
          if (this.b.size() <= 0) {
            break;
          }
        } while (this.c != 0);
        paramArrayList = (BaseArticleInfo)this.b.get(0);
      } while (paramArrayList == null);
      localObject = PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList);
      PublicAccountUtil.a(paramBaseArticleInfo, PublicAccountUtil.a(paramArrayList), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
      return;
      ReadInJoyLogicEngine.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    PublicAccountUtil.a(paramBaseArticleInfo, paramBaseArticleInfo.getApp().getResources().getString(2131428458), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Object localObject = ReadInJoyUtils.a();
    ArticleInfo localArticleInfo = (ArticleInfo)paramArrayList1.get(0);
    if (localArticleInfo != null) {
      ReadInJoyLogicEngine.a().a(Long.valueOf((String)localObject).longValue(), localArticleInfo.makeDislikeParam(paramArrayList2));
    }
    paramArrayList2 = paramArrayList2.iterator();
    while (paramArrayList2.hasNext())
    {
      localObject = (DislikeInfo)paramArrayList2.next();
      if (((DislikeInfo)localObject).jdField_a_of_type_Int == 5) {
        a(((DislikeInfo)localObject).b);
      }
    }
    int i = 0;
    if (i < paramArrayList1.size())
    {
      paramArrayList2 = (ArticleInfo)paramArrayList1.get(i);
      if (paramArrayList2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayList2.mRecommendSeq;
        if (ReadinjoyFixPosArticleManager.a(l)) {
          ReadinjoyFixPosArticleManager.a().a(this.c, l);
        } else {
          ReadInJoyLogicEngine.a().a(this.c, paramArrayList2);
        }
      }
    }
    if (paramInt == 0)
    {
      paramArrayList1 = (QQAppInterface)ReadInJoyUtils.a();
      paramArrayList2 = (KandianMergeManager)paramArrayList1.getManager(161);
      if (this.b.size() <= 0) {
        break label249;
      }
      if (this.c == 0)
      {
        paramArrayList2 = (BaseArticleInfo)this.b.get(0);
        if (paramArrayList2 != null)
        {
          localObject = PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList2);
          PublicAccountUtil.a(paramArrayList1, PublicAccountUtil.a(paramArrayList2), String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, true);
        }
      }
    }
    label249:
    do
    {
      return;
      ReadInJoyLogicEngine.a().a(this.c, 20, 9223372036854775807L, true);
    } while (this.c != 0);
    PublicAccountUtil.a(paramArrayList1, paramArrayList1.getApp().getResources().getString(2131428458), String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if ((paramBaseArticleInfo == null) || (paramVideoPlayParam == null)) {
      return;
    }
    super.b(paramVideoPlayParam, paramBaseArticleInfo);
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
    ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
    super.a(paramVideoPlayParam, paramBaseArticleInfo, paramBoolean);
  }
  
  public boolean a()
  {
    return ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount();
    int i = 0;
    for (;;)
    {
      ReadInJoyView localReadInJoyView;
      IReadInJoyPresenter localIReadInJoyPresenter;
      if (i < j)
      {
        Object localObject = (IReadInJoyModel)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i).getTag(2131362079);
        localReadInJoyView = (ReadInJoyView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i).getTag(2131362078);
        localIReadInJoyPresenter = (IReadInJoyPresenter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i).getTag(2131362077);
        if (localObject == null) {
          break label219;
        }
        if (this.jdField_a_of_type_ComTencentWidgetReadInJoyAccountActiveTips == null) {
          this.jdField_a_of_type_ComTencentWidgetReadInJoyAccountActiveTips = new ReadInJoyAccountActiveTips(this.jdField_a_of_type_AndroidAppActivity);
        }
        if (!CellFactory.a(((IReadInJoyModel)localObject).a())) {
          break label146;
        }
        localObject = (FeedItemCell)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i).getTag();
        if (localObject != null)
        {
          localObject = ((FeedItemCell)localObject).b();
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentWidgetReadInJoyAccountActiveTips.a((View)localObject);
          }
        }
      }
      label146:
      do
      {
        do
        {
          return;
        } while ((localReadInJoyView == null) || (localIReadInJoyPresenter == null));
        if ((localReadInJoyView.d == null) && (localReadInJoyView.e.isShown())) {
          this.jdField_a_of_type_ComTencentWidgetReadInJoyAccountActiveTips.a(localReadInJoyView.e);
        }
      } while ((localReadInJoyView.d == null) || (!localReadInJoyView.d.isShown()));
      this.jdField_a_of_type_ComTencentWidgetReadInJoyAccountActiveTips.a(localReadInJoyView.d);
      return;
      label219:
      i += 1;
    }
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(Long.valueOf(paramLong));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
    {
      paramInt2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount();
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          Object localObject = (IReadInJoyModel)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131362079);
          ReadInJoyView localReadInJoyView = (ReadInJoyView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131362078);
          IReadInJoyPresenter localIReadInJoyPresenter = (IReadInJoyPresenter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1).getTag(2131362077);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter
 * JD-Core Version:    0.7.0.1
 */