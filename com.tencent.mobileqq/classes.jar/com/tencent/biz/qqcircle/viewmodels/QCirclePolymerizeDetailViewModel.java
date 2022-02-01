package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QCirclePolymerizeDetailViewModel
  extends QCircleBaseViewModel
  implements IDataDisplaySurface<FeedBlockData>, IQCircleReportSessionOperation
{
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a = new MutableLiveData();
  public MutableLiveData<UIStateData<QQCircleFeedBase.StFeedListBusiRspData>> b = new MutableLiveData();
  private List<FeedBlockData> c;
  private String d = null;
  private String e = null;
  private QCirclePolymerizeDetailBean f;
  
  private QCirclePolymerizeDetailViewModel.FeedBlockSource a(boolean paramBoolean, List<FeedCloudMeta.StFeed> paramList)
  {
    paramList = QCircleTransFormHelper.a(paramList);
    if (!paramBoolean)
    {
      this.c = new ArrayList(paramList);
      return new QCirclePolymerizeDetailViewModel.FeedBlockSource(0, this.c);
    }
    if ((UIStateData)this.a.getValue() == null)
    {
      this.c = new ArrayList(paramList);
      return new QCirclePolymerizeDetailViewModel.FeedBlockSource(0, this.c);
    }
    List localList = this.c;
    if (localList == null)
    {
      this.c = new ArrayList(paramList);
      return new QCirclePolymerizeDetailViewModel.FeedBlockSource(0, this.c);
    }
    int i = localList.size();
    this.c.addAll(paramList);
    return new QCirclePolymerizeDetailViewModel.FeedBlockSource(i, this.c);
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a(Object... paramVarArgs)
  {
    return this.a;
  }
  
  public String a()
  {
    return "QCirclePolymerizeDetailViewModel";
  }
  
  public void a(QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQCirclePolymerizeDetailBean, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramQCirclePolymerizeDetailBean == null)
    {
      QLog.e("QCirclePolymerizeDetailViewModel", 1, "initBean == null");
      return;
    }
    this.f = paramQCirclePolymerizeDetailBean;
    if (paramBoolean1) {
      localObject = this.d;
    } else {
      localObject = null;
    }
    Object localObject = new QCircleGetFeedListRequest(paramQCirclePolymerizeDetailBean, (String)localObject, this.e, paramBoolean3);
    ((QCircleGetFeedListRequest)localObject).mRequest.extInfo.set(getSession(paramBoolean1 ^ true));
    ((QCircleGetFeedListRequest)localObject).setEnableCache(paramBoolean2);
    this.a.setValue(UIStateData.b());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestAttachInfo : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("  , isLoadMore : ");
    localStringBuilder.append(paramBoolean1);
    QLog.d("QCirclePolymerizeDetailViewModel", 1, localStringBuilder.toString());
    a((BaseRequest)localObject, new QCirclePolymerizeDetailViewModel.1(this, paramBoolean1, paramQCirclePolymerizeDetailBean));
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2, QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean1) && (paramLong == 0L) && (paramStGetFeedListRsp != null))
    {
      if (paramStGetFeedListRsp.extInfo.has()) {
        updateSession((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      this.d = paramStGetFeedListRsp.feedAttchInfo.get();
      Object localObject2 = paramStGetFeedListRsp.vecFeed.get();
      Object localObject1 = a(paramBoolean2, (List)localObject2);
      if (((List)localObject2).size() > 0)
      {
        localObject2 = this.a;
        localObject1 = UIStateData.a(bool).a(paramBoolean2, ((QCirclePolymerizeDetailViewModel.FeedBlockSource)localObject1).b()).a(((QCirclePolymerizeDetailViewModel.FeedBlockSource)localObject1).a());
        if (paramStGetFeedListRsp.isFinish.get() > 0) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        ((MutableLiveData)localObject2).setValue(((UIStateData)localObject1).c(paramBoolean1));
      }
      else
      {
        localObject1 = this.a;
        localObject2 = UIStateData.a().a(paramLong).b(paramBoolean2);
        if (paramStGetFeedListRsp.isFinish.get() > 0) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        ((MutableLiveData)localObject1).setValue(((UIStateData)localObject2).c(paramBoolean1));
      }
      localObject1 = new QQCircleFeedBase.StFeedListBusiRspData();
      if (paramStGetFeedListRsp.busiRspData.has())
      {
        try
        {
          ((QQCircleFeedBase.StFeedListBusiRspData)localObject1).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject1).has()) {
          this.b.setValue(UIStateData.a(bool).a(false, localObject1));
        } else {
          this.b.setValue(UIStateData.a());
        }
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject1).refreshAttachInfo.has()) {
          this.e = ((QQCircleFeedBase.StFeedListBusiRspData)localObject1).refreshAttachInfo.get();
        }
      }
      if (!VSNetworkHelper.isProtocolCache(paramString))
      {
        QCirclePluginGlobalInfo.b(paramStGetFeedListRsp.isFirstLogin.get());
        if ((paramQCirclePolymerizeDetailBean != null) && (paramQCirclePolymerizeDetailBean.isNeedShowGoHomeButton())) {
          QCircleDTLoginReporter.daTongLoginReportMiddlePage(paramQCirclePolymerizeDetailBean.getSchemeAttrs(), QCirclePluginGlobalInfo.k());
        }
      }
      paramString = new StringBuilder();
      paramString.append("responseAttachInfo:");
      paramString.append(this.d);
      paramString.append("  ， isFinish: ");
      paramString.append(paramStGetFeedListRsp.isFinish.get());
      QLog.d("QCirclePolymerizeDetailViewModel", 1, paramString.toString());
      return;
    }
    this.a.setValue(UIStateData.a(paramString).a(paramLong).b(paramBoolean2));
  }
  
  public void b(Object... paramVarArgs)
  {
    if ((a(new Object[0]).getValue() != null) && (((UIStateData)a(new Object[0]).getValue()).c() != 1))
    {
      ((UIStateData)a(new Object[0]).getValue()).c(1);
      a(this.f, true, false);
    }
  }
  
  public int c()
  {
    QCirclePolymerizeDetailBean localQCirclePolymerizeDetailBean = this.f;
    if (localQCirclePolymerizeDetailBean == null) {
      return 0;
    }
    return localQCirclePolymerizeDetailBean.getPolymerizationType();
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
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizeDetailViewModel
 * JD-Core Version:    0.7.0.1
 */