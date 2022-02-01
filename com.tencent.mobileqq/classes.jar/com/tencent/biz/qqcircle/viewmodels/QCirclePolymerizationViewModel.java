package com.tencent.biz.qqcircle.viewmodels;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
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
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StTagOperateInfo;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class QCirclePolymerizationViewModel
  extends QCircleBaseViewModel
  implements IDataDisplaySurface<FeedBlockData>, IQCircleReportSessionOperation
{
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a = new MutableLiveData();
  public MutableLiveData<UIStateData<List<FeedBlockData>>> b = new MutableLiveData();
  public MutableLiveData<UIStateData<QQCircleFeedBase.StFeedListBusiRspData>> c = new MutableLiveData();
  public MutableLiveData<String> d = new MutableLiveData();
  private List<FeedCloudMeta.StFeed> e = new ArrayList();
  private String f = null;
  private String g = null;
  private QCirclePolymerizationBean h;
  private Context i;
  
  private void a(boolean paramBoolean1, List<FeedCloudMeta.StFeed> paramList, boolean paramBoolean2, boolean paramBoolean3)
  {
    List localList = this.e;
    if (localList != null)
    {
      if (!paramBoolean1) {
        localList.clear();
      }
      this.e.addAll(paramList);
      this.b.setValue(UIStateData.a(paramBoolean2).a(paramBoolean1, QCircleTransFormHelper.a(this.e)).c(paramBoolean3));
    }
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a(Object... paramVarArgs)
  {
    return this.b;
  }
  
  public String a()
  {
    return "QCirclePolymerizationVi";
  }
  
  public void a(Context paramContext, QCirclePolymerizationBean paramQCirclePolymerizationBean, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQCirclePolymerizationBean == null)
    {
      QLog.e("QCirclePolymerizationVi", 1, "initBean == null");
      return;
    }
    if (paramBoolean1) {
      localObject = this.f;
    } else {
      localObject = null;
    }
    Object localObject = new QCircleGetFeedListRequest(paramQCirclePolymerizationBean, (String)localObject, this.g);
    ((QCircleGetFeedListRequest)localObject).mRequest.extInfo.set(getSession(paramBoolean1 ^ true));
    ((QCircleGetFeedListRequest)localObject).setEnableCache(paramBoolean2);
    this.a.setValue(UIStateData.b());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestAttachInfo : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("  , isLoadMore : ");
    localStringBuilder.append(paramBoolean1);
    QLog.d("QCirclePolymerizationVi", 1, localStringBuilder.toString());
    if (!paramBoolean1) {
      VSNetworkHelper.getInstance().cancelRequest(paramContext);
    }
    a(paramContext, (BaseRequest)localObject, new QCirclePolymerizationViewModel.1(this, paramBoolean1, paramQCirclePolymerizationBean));
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2, QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean1) && (paramLong == 0L) && (paramStGetFeedListRsp != null))
    {
      if (paramStGetFeedListRsp.extInfo.has()) {
        updateSession((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      this.f = paramStGetFeedListRsp.feedAttchInfo.get();
      Object localObject1 = paramStGetFeedListRsp.vecFeed.get();
      Object localObject2;
      if (((List)localObject1).size() > 0)
      {
        localObject2 = this.a;
        UIStateData localUIStateData = UIStateData.a(bool).a(paramBoolean2, QCircleTransFormHelper.a((List)localObject1));
        if (paramStGetFeedListRsp.isFinish.get() > 0) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        ((MutableLiveData)localObject2).setValue(localUIStateData.c(paramBoolean1));
        if (paramStGetFeedListRsp.isFinish.get() > 0) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        a(paramBoolean2, (List)localObject1, bool, paramBoolean1);
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
        localObject1 = this.b;
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
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject1).has())
        {
          this.c.setValue(UIStateData.a(bool).a(false, localObject1));
          if (((QQCircleFeedBase.StFeedListBusiRspData)localObject1).tagPageData.tagInfo.optInfo.has()) {
            this.d.setValue(((QQCircleFeedBase.StFeedListBusiRspData)localObject1).tagPageData.tagInfo.optInfo.publishSchema.get());
          }
        }
        else
        {
          this.c.setValue(UIStateData.a());
        }
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject1).refreshAttachInfo.has()) {
          this.g = ((QQCircleFeedBase.StFeedListBusiRspData)localObject1).refreshAttachInfo.get();
        }
      }
      if (!VSNetworkHelper.isProtocolCache(paramString))
      {
        QCirclePluginGlobalInfo.b(paramStGetFeedListRsp.isFirstLogin.get());
        if ((paramQCirclePolymerizationBean != null) && (paramQCirclePolymerizationBean.isNeedShowGoHomeButton())) {
          QCircleDTLoginReporter.daTongLoginReportMiddlePage(paramQCirclePolymerizationBean.getSchemeAttrs(), QCirclePluginGlobalInfo.k());
        }
      }
      paramString = new StringBuilder();
      paramString.append("responseAttachInfo:");
      paramString.append(this.f);
      paramString.append("  ， isFinish: ");
      paramString.append(paramStGetFeedListRsp.isFinish.get());
      QLog.d("QCirclePolymerizationVi", 1, paramString.toString());
      return;
    }
    this.a.setValue(UIStateData.a(paramString).a(paramLong).b(paramBoolean2));
  }
  
  public void b(Object... paramVarArgs)
  {
    if ((a(new Object[0]).getValue() != null) && (((UIStateData)a(new Object[0]).getValue()).c() != 1))
    {
      if ((paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof QCirclePolymerizationBean))) {
        this.h = ((QCirclePolymerizationBean)paramVarArgs[0]);
      }
      if ((paramVarArgs.length > 1) && ((paramVarArgs[1] instanceof Context))) {
        this.i = ((Context)paramVarArgs[1]);
      }
      ((UIStateData)a(new Object[0]).getValue()).c(1);
      a(this.i, this.h, true, false);
    }
  }
  
  public int c()
  {
    return this.h.getPolymerizationType();
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
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel
 * JD-Core Version:    0.7.0.1
 */