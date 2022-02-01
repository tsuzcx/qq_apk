package com.tencent.biz.qqcircle.immersive.aggregation;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.aggregation.request.QFSGetFeedListMusicRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.viewmodels.QCircleBaseViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StFeedMusic;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StMusicPageData;

public class QFSMusicAggregationViewModel
  extends QCircleBaseViewModel
  implements IDataDisplaySurface<FeedBlockData>, Call.OnRspCallBack<QCircleBaseRequest>, IQCircleReportSessionOperation
{
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a = new MutableLiveData();
  private MutableLiveData<UIStateData<List<FeedBlockData>>> b = new MutableLiveData();
  private MutableLiveData<UIStateData<QQCircleFeedBase.StFeedListBusiRspData>> c = new MutableLiveData();
  private List<FeedCloudMeta.StFeed> d = new ArrayList();
  private String e = null;
  private String f = null;
  private QFSMusicAggregationInitBean g;
  
  private void a(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean)
  {
    if (paramStGetFeedListRsp != null)
    {
      if (!paramStGetFeedListRsp.busiRspData.has()) {
        return;
      }
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      try
      {
        localStFeedListBusiRspData.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        paramStGetFeedListRsp.printStackTrace();
      }
      if (localStFeedListBusiRspData.has()) {
        this.c.setValue(UIStateData.a(paramBoolean).a(false, localStFeedListBusiRspData));
      } else {
        this.c.setValue(UIStateData.a());
      }
      if (localStFeedListBusiRspData.refreshAttachInfo.has()) {
        this.f = localStFeedListBusiRspData.refreshAttachInfo.get();
      }
    }
  }
  
  private void a(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    this.c.setValue(UIStateData.a(true).a(false, paramStFeedListBusiRspData));
  }
  
  private void a(boolean paramBoolean1, List<FeedCloudMeta.StFeed> paramList, boolean paramBoolean2, boolean paramBoolean3)
  {
    List localList = this.d;
    if (localList == null) {
      return;
    }
    if (!paramBoolean1) {
      localList.clear();
    }
    this.d.addAll(paramList);
    this.a.setValue(UIStateData.a(paramBoolean2).a(paramBoolean1, QCircleTransFormHelper.a(this.d)).c(paramBoolean3));
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a(Object... paramVarArgs)
  {
    return this.a;
  }
  
  public String a()
  {
    return "QFSMusicAggregationViewModel";
  }
  
  public void a(QFSMusicAggregationInitBean paramQFSMusicAggregationInitBean)
  {
    this.g = paramQFSMusicAggregationInitBean;
    if (this.g != null)
    {
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      localStFeedListBusiRspData.musicPageData.setHasFlag(true);
      localStFeedListBusiRspData.musicPageData.music.set(paramQFSMusicAggregationInitBean.getFeedMusic());
      a(localStFeedListBusiRspData);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setValue(UIStateData.b());
    QFSGetFeedListMusicRequest localQFSGetFeedListMusicRequest = new QFSGetFeedListMusicRequest(this.g, null, this.f);
    localQFSGetFeedListMusicRequest.setEnableCache(paramBoolean);
    QCircleRequestSender.a().b().a("2013").b(false).a(localQFSGetFeedListMusicRequest).a(this).a();
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, Bundle paramBundle)
  {
    if (!(paramObject instanceof FeedCloudRead.StGetFeedListRsp))
    {
      QLog.e("QFSMusicAggregationViewModel", 1, "rspObj != StGetFeedListRsp");
      return;
    }
    paramQCircleBaseRequest = (FeedCloudRead.StGetFeedListRsp)paramObject;
    boolean bool3 = VSNetworkHelper.isProtocolCache(paramString);
    boolean bool4 = paramBundle.getBoolean("qfs_extra_data_key_is_load_more");
    paramObject = new StringBuilder();
    paramObject.append("requestMusicAggregationData onReceive: dispatch Success:");
    paramObject.append(paramBoolean);
    paramObject.append(" | retCode:");
    paramObject.append(paramLong);
    paramObject.append(" | retMessage:");
    paramObject.append(paramString);
    paramObject.append(" | isLoadMore:");
    paramObject.append(bool4);
    paramObject.append(" | isCache:");
    paramObject.append(bool3);
    QLog.d("QFSMusicAggregationViewModel", 1, paramObject.toString());
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramQCircleBaseRequest.extInfo.has()) {
        updateSession((FeedCloudCommon.StCommonExt)paramQCircleBaseRequest.extInfo.get());
      }
      this.e = paramQCircleBaseRequest.feedAttchInfo.get();
      paramString = paramQCircleBaseRequest.vecFeed.get();
      int i = paramString.size();
      boolean bool2 = false;
      boolean bool1 = false;
      if (i > 0)
      {
        paramObject = this.b;
        paramBundle = UIStateData.a(bool3).a(bool4, QCircleTransFormHelper.a(paramString));
        if (paramQCircleBaseRequest.isFinish.get() > 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramObject.setValue(paramBundle.c(paramBoolean));
        paramBoolean = bool1;
        if (paramQCircleBaseRequest.isFinish.get() > 0) {
          paramBoolean = true;
        }
        a(bool4, paramString, bool3, paramBoolean);
      }
      else
      {
        paramString = this.b;
        paramObject = UIStateData.a().a(paramLong).b(bool4);
        if (paramQCircleBaseRequest.isFinish.get() > 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramString.setValue(paramObject.c(paramBoolean));
        paramString = this.a;
        paramObject = UIStateData.a().a(paramLong).b(bool4);
        paramBoolean = bool2;
        if (paramQCircleBaseRequest.isFinish.get() > 0) {
          paramBoolean = true;
        }
        paramString.setValue(paramObject.c(paramBoolean));
      }
      a(paramQCircleBaseRequest, bool3);
      paramString = new StringBuilder();
      paramString.append("responseAttachInfo:");
      paramString.append(this.e);
      paramString.append("  ， isFinish: ");
      paramString.append(paramQCircleBaseRequest.isFinish.get());
      QLog.d("QFSMusicAggregationViewModel", 1, paramString.toString());
      return;
    }
    this.b.setValue(UIStateData.a(paramString).a(paramLong).b(bool4));
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> b()
  {
    return this.b;
  }
  
  public void b(Object... paramVarArgs)
  {
    e();
  }
  
  public int c()
  {
    return 0;
  }
  
  public MutableLiveData<UIStateData<QQCircleFeedBase.StFeedListBusiRspData>> d()
  {
    return this.c;
  }
  
  public void e()
  {
    QFSGetFeedListMusicRequest localQFSGetFeedListMusicRequest = new QFSGetFeedListMusicRequest(this.g, this.e, this.f);
    QCircleRequestSender.a().b().b(false).c(true).a(localQFSGetFeedListMusicRequest).a(this).a();
  }
  
  public String f()
  {
    return String.valueOf(hashCode());
  }
  
  public FeedCloudCommon.StCommonExt getSession(boolean paramBoolean)
  {
    if (this.k != null) {
      return this.k.getSessionCommonExt(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public void updateSession(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.k != null) {
      this.k.updateSubSession(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationViewModel
 * JD-Core Version:    0.7.0.1
 */