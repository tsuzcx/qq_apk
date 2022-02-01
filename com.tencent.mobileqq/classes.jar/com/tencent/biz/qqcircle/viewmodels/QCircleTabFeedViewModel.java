package com.tencent.biz.qqcircle.viewmodels;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper.QCircleFolderPageCache;
import com.tencent.biz.qqcircle.folder.QCirclePageLayoutTypeHelper;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest.Builder;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCircleColdBootReqInterceptor;
import com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCircleFollowTabRspInterceptor;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.base.UIStateData.ModifyListRecord;
import com.tencent.richframework.sender.call.BaseCall;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QCircleTabFeedViewModel
  extends QCircleAbsTabFeedViewModel
{
  private String l;
  
  private UIStateData.ModifyListRecord a(List<FeedBlockData> paramList1, List<FeedBlockData> paramList2)
  {
    if ((paramList1 != null) && (paramList2 != null)) {
      return UIStateData.ModifyListRecord.a(paramList1.size(), paramList2.size() - paramList1.size());
    }
    return UIStateData.ModifyListRecord.a();
  }
  
  private boolean a(boolean paramBoolean, int paramInt, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if ((paramBoolean) && (paramInt == 6) && (paramStGetFeedListRsp != null))
    {
      if (!paramStGetFeedListRsp.busiRspData.has()) {
        return false;
      }
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      try
      {
        localStFeedListBusiRspData.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        paramInt = QCirclePageLayoutTypeHelper.a().b();
        paramStGetFeedListRsp = new StringBuilder();
        paramStGetFeedListRsp.append("differentPageLayoutType  busiRspData.pageLayoutType = ");
        paramStGetFeedListRsp.append(localStFeedListBusiRspData.pageLayoutType.get());
        paramStGetFeedListRsp.append(" , currentPageType = ");
        paramStGetFeedListRsp.append(paramInt);
        QLog.i("QCircleTabFeedViewModel", 1, paramStGetFeedListRsp.toString());
        if (localStFeedListBusiRspData.pageLayoutType.get() != paramInt)
        {
          QLog.i("QCircleTabFeedViewModel", 1, "differentPageLayoutType  direct return");
          return true;
        }
        return false;
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        paramStGetFeedListRsp.printStackTrace();
      }
    }
    return false;
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      return;
    }
    String str;
    if (paramBoolean1) {
      str = "get_page_cache_rsp";
    } else {
      str = "get_page_net_rsp";
    }
    QCirclePeriodCollect.record(this.l, str);
    QCirclePeriodCollect.setState(this.l, str);
    QCirclePeriodCollect.flushPeriodReport(this.l, str);
  }
  
  public String a()
  {
    return "QCircleTabFeedViewModel";
  }
  
  public void a(QCircleTabInfo paramQCircleTabInfo)
  {
    super.a(paramQCircleTabInfo);
    if (paramQCircleTabInfo != null) {
      this.l = String.valueOf(paramQCircleTabInfo.c());
    }
  }
  
  public void a(@NonNull QCircleFolderCacheHelper.QCircleFolderPageCache paramQCircleFolderPageCache)
  {
    super.a(paramQCircleFolderPageCache);
    QCirclePeriodCollect.record(this.l, "request_page_by_cache");
    QCirclePeriodCollect.setIsPurelyMemCache(this.l);
  }
  
  void a(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if (paramStGetFeedListRsp == null) {
      return;
    }
    if (paramStGetFeedListRsp.extInfo.has())
    {
      this.i = ((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      updateSession(this.i);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("extra_key_is_load_more");
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (((paramObject1 instanceof QCircleTabGetFeedListRequest)) && ((paramObject2 instanceof FeedCloudRead.StGetFeedListRsp))) {
        b(true, paramLong, paramString, paramObject1, paramObject2, paramBundle);
      }
      return;
    }
    a(UIStateData.a(paramString).a(paramLong).b(bool));
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.j.size() > 0)
    {
      this.j = a(paramBoolean2, this.j);
      Object localObject = QCircleTransFormHelper.a(this.j);
      a((List)localObject, paramBoolean1);
      if (!paramBoolean2) {
        QCircleFeedDataCenter.a().a((List)localObject, true);
      }
      UIStateData localUIStateData = UIStateData.a(paramBoolean2).a(paramBoolean1, localObject);
      if (paramBoolean1) {
        localObject = a((List)((UIStateData)this.a.getValue()).e(), (List)localObject);
      } else {
        localObject = UIStateData.ModifyListRecord.a();
      }
      a(localUIStateData.a((UIStateData.ModifyListRecord)localObject).c(this.h));
      return;
    }
    a(UIStateData.a().b(paramBoolean1).c(this.h));
  }
  
  void b(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if (paramStGetFeedListRsp == null) {
      return;
    }
    this.f = paramStGetFeedListRsp.feedAttchInfo.get();
  }
  
  protected void b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt, QCircleFolderBean paramQCircleFolderBean)
  {
    QCirclePeriodCollect.record(this.l, "request_page_by_net");
    paramString2 = new QCircleTabGetFeedListRequest(new QCircleTabGetFeedListRequest.Builder().a(this.c).a(paramString1).b(paramString2).a(QCircleGpsHelper.a().e()).a(paramInt).a(this.d).a(paramQCircleFolderBean));
    paramString2.setRetryCount(1);
    paramString2.mRequest.extInfo.set(getSession(paramBoolean1 ^ true));
    paramString2.setEnableCache(paramBoolean2);
    paramString2.mRequest.extInfo.setHasFlag(true);
    paramString2.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
    paramQCircleFolderBean = QCircleRequestSender.a().b().b(false).a(a(paramInt, paramBoolean1));
    if (paramBoolean1) {
      paramString1 = null;
    } else {
      paramString1 = new QCircleColdBootReqInterceptor();
    }
    paramQCircleFolderBean.a(paramString1).a(new QCircleFollowTabRspInterceptor()).a(paramString2).a(this).a();
  }
  
  void b(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    RFThreadManager.getSerialThreadHandler().post(new QCircleTabFeedViewModel.1(this, paramObject1, paramObject2, paramBundle, paramString, paramBoolean, paramLong));
  }
  
  public boolean b(@NonNull QCircleFolderCacheHelper.QCircleFolderPageCache paramQCircleFolderPageCache)
  {
    boolean bool = super.b(paramQCircleFolderPageCache);
    if (bool)
    {
      QCirclePeriodCollect.record(this.l, "get_page_cache_rsp");
      QCirclePeriodCollect.setState(this.l, "get_page_cache_rsp");
      QCirclePeriodCollect.flushPeriodReport(this.l, "get_page_cache_rsp");
    }
    return bool;
  }
  
  void c(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if (paramStGetFeedListRsp == null) {
      return;
    }
    boolean bool;
    if (paramStGetFeedListRsp.isFinish.get() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
  }
  
  void d(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if (paramStGetFeedListRsp == null) {
      return;
    }
    if (paramStGetFeedListRsp.busiRspData.has())
    {
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      try
      {
        localStFeedListBusiRspData.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
      {
        paramStGetFeedListRsp.printStackTrace();
      }
      if (localStFeedListBusiRspData.refreshAttachInfo.has()) {
        this.e = localStFeedListBusiRspData.refreshAttachInfo.get();
      }
    }
  }
  
  void e(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if (paramStGetFeedListRsp == null) {
      return;
    }
    paramStGetFeedListRsp = paramStGetFeedListRsp.vecFeed.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("feed size:");
    localStringBuilder.append(paramStGetFeedListRsp.size());
    localStringBuilder.append(" | isFinish:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" | feedAttachInfo:");
    localStringBuilder.append(e());
    QLog.d("QCircleTabFeedViewModel", 1, localStringBuilder.toString());
    this.j.addAll(paramStGetFeedListRsp);
    QCirclePushInfoManager.a().a(paramStGetFeedListRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleTabFeedViewModel
 * JD-Core Version:    0.7.0.1
 */