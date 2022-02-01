package com.tencent.biz.qqcircle.fragments.feeddetail;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.helpers.QCircleVideoPreloadHelper;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.viewmodels.QCircleBaseViewModel;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import java.util.ArrayList;
import java.util.List;

public class QCircleFeedDetailModel
  extends QCircleBaseViewModel
  implements IDataDisplaySurface<FeedBlockData>, IQCircleReportSessionOperation
{
  private QCircleVideoPreloadHelper a = new QCircleVideoPreloadHelper(this.D);
  private LoadInfo b;
  private QCircleInitBean c;
  private List<FeedCloudMeta.StFeed> d = new ArrayList();
  private final MutableLiveData<ResponseBean> e = new MutableLiveData();
  private final MutableLiveData<UIStateData<List<FeedBlockData>>> f = new MutableLiveData();
  
  private void a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramStFeed);
    a(false, localArrayList, paramBoolean, false);
  }
  
  private void a(boolean paramBoolean1, List<FeedCloudMeta.StFeed> paramList, boolean paramBoolean2, boolean paramBoolean3)
  {
    List localList = this.d;
    if (localList != null)
    {
      if (!paramBoolean1) {
        localList.clear();
      }
      this.d.addAll(paramList);
      this.f.postValue(UIStateData.a(paramBoolean2).a(paramBoolean1, QCircleTransFormHelper.a(this.d)).c(paramBoolean3));
    }
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a(Object... paramVarArgs)
  {
    return this.f;
  }
  
  public String a()
  {
    return "QCircleFeedDetailModel";
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, LoadInfo paramLoadInfo)
  {
    boolean bool = paramLoadInfo.e();
    paramQCircleInitBean = new QCircleGetFeedListRequest(paramQCircleInitBean, paramLoadInfo.f());
    paramQCircleInitBean.mRequest.extInfo.set(getSession(bool ^ true));
    a(paramQCircleInitBean, new QCircleFeedDetailModel.2(this, paramQCircleInitBean, bool, paramLoadInfo));
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, boolean paramBoolean, LoadInfo paramLoadInfo)
  {
    int i = QCircleGetFeedDetailRequest.FROM_NATIVE;
    if (paramQCircleInitBean.isSingleFeed()) {
      i = QCircleGetFeedDetailRequest.FROM_PUSH_DETAIL;
    }
    QCircleGetFeedDetailRequest localQCircleGetFeedDetailRequest = new QCircleGetFeedDetailRequest(paramQCircleInitBean.getFeed().id.get(), paramQCircleInitBean.getFeed().poster.id.get(), paramQCircleInitBean.getFeed().createTime.get(), false, i, paramQCircleInitBean.getFeed(), paramQCircleInitBean);
    localQCircleGetFeedDetailRequest.mRequest.extInfo.set(getSession(true));
    localQCircleGetFeedDetailRequest.mRequest.extInfo.setHasFlag(true);
    localQCircleGetFeedDetailRequest.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
    localQCircleGetFeedDetailRequest.setEnableCache(paramBoolean);
    this.c = paramQCircleInitBean;
    a(localQCircleGetFeedDetailRequest, new QCircleFeedDetailModel.1(this, localQCircleGetFeedDetailRequest, paramQCircleInitBean));
    if (!paramQCircleInitBean.isSingleFeed()) {
      a(paramQCircleInitBean, paramLoadInfo);
    }
  }
  
  public MutableLiveData<ResponseBean> b()
  {
    return this.e;
  }
  
  public void b(Object... paramVarArgs)
  {
    if ((paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof QCircleLayerBean))) {
      this.c = ((QCircleLayerBean)paramVarArgs[0]);
    }
    if (this.b == null) {
      this.b = new LoadInfo();
    }
    a(this.c, this.b);
  }
  
  public int c()
  {
    return 69;
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
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailModel
 * JD-Core Version:    0.7.0.1
 */