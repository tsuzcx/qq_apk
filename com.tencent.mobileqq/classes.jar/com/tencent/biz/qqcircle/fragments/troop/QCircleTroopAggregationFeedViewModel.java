package com.tencent.biz.qqcircle.fragments.troop;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.helpers.QCircleVideoPreloadHelper;
import com.tencent.biz.qqcircle.requests.QCircleGetGroupFeedListRequest;
import com.tencent.biz.qqcircle.viewmodels.QCircleBaseViewModel;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListReq;

public class QCircleTroopAggregationFeedViewModel
  extends QCircleBaseViewModel
  implements IQCircleReportSessionOperation
{
  private QCircleVideoPreloadHelper a = new QCircleVideoPreloadHelper(this.D);
  private final MutableLiveData<ResponseBean> b = new MutableLiveData();
  
  public String a()
  {
    return "QCircleTroopAggregationFeedViewModel";
  }
  
  public void a(String paramString, LoadInfo paramLoadInfo)
  {
    boolean bool = paramLoadInfo.e();
    paramString = new QCircleGetGroupFeedListRequest(Long.parseLong(paramString), paramLoadInfo.f());
    paramString.mRequest.extInfo.set(getSession(bool ^ true));
    paramString.setEnableCache(paramLoadInfo.c());
    paramString.mRequest.extInfo.setHasFlag(true);
    paramString.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
    a(paramString, new QCircleTroopAggregationFeedViewModel.1(this, paramString, bool, paramLoadInfo));
  }
  
  public MutableLiveData<ResponseBean> b()
  {
    return this.b;
  }
  
  public FeedCloudCommon.StCommonExt getSession(boolean paramBoolean)
  {
    if (this.k != null) {
      return this.k.getSessionCommonExt(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  protected void onCleared()
  {
    super.onCleared();
    QCircleVideoPreloadHelper localQCircleVideoPreloadHelper = this.a;
    if (localQCircleVideoPreloadHelper != null)
    {
      localQCircleVideoPreloadHelper.a();
      this.a.b();
    }
  }
  
  public void updateSession(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.k != null) {
      this.k.updateSubSession(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.troop.QCircleTroopAggregationFeedViewModel
 * JD-Core Version:    0.7.0.1
 */