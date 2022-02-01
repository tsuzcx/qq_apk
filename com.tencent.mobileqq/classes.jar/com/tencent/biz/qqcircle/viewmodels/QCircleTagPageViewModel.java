package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class QCircleTagPageViewModel
  extends QCircleBaseViewModel
  implements IQCircleReportSessionOperation
{
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a = new MutableLiveData();
  public MutableLiveData<UIStateData<FeedCloudMeta.StTagInfo>> b = new MutableLiveData();
  private String c = null;
  private String d = null;
  
  public QCircleTagPageViewModel()
  {
    this.k = QCircleReporterAgent.obtain(31);
  }
  
  public String a()
  {
    return "QCircleTagPageViewModel";
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1) {
      str = this.c;
    } else {
      str = null;
    }
    paramString1 = new QCircleGetFeedListRequest(paramString1, paramString2, str, this.d);
    paramString1.mRequest.extInfo.set(getSession(paramBoolean1 ^ true));
    paramString1.setEnableCache(paramBoolean2);
    this.a.setValue(UIStateData.b());
    a(paramString1, new QCircleTagPageViewModel.1(this, paramBoolean1));
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    boolean bool2 = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean1) && (paramLong == 0L) && (paramStGetFeedListRsp != null))
    {
      paramString = paramStGetFeedListRsp.vecFeed.get();
      int i = paramString.size();
      boolean bool1 = false;
      UIStateData localUIStateData;
      if (i > 0)
      {
        localObject = this.a;
        localUIStateData = UIStateData.a(bool2).a(paramBoolean2, QCircleTransFormHelper.a(paramString));
        if (paramStGetFeedListRsp.isFinish.get() > 0) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        ((MutableLiveData)localObject).setValue(localUIStateData.c(paramBoolean1));
      }
      else
      {
        localObject = this.a;
        localUIStateData = UIStateData.a().b(paramBoolean2);
        if (paramStGetFeedListRsp.isFinish.get() > 0) {
          paramBoolean1 = true;
        } else {
          paramBoolean1 = false;
        }
        ((MutableLiveData)localObject).setValue(localUIStateData.c(paramBoolean1));
      }
      Object localObject = new QQCircleFeedBase.StFeedListBusiRspData();
      if (paramStGetFeedListRsp.busiRspData.has())
      {
        try
        {
          ((QQCircleFeedBase.StFeedListBusiRspData)localObject).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.has())
        {
          FeedCloudMeta.StTagInfo localStTagInfo = (FeedCloudMeta.StTagInfo)((QQCircleFeedBase.StFeedListBusiRspData)localObject).tagPageData.tagInfo.get();
          if (localStTagInfo != null) {
            this.b.setValue(UIStateData.a(bool2).a(false, localStTagInfo));
          } else {
            this.b.setValue(UIStateData.a());
          }
        }
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.has()) {
          this.d = ((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.get();
        }
      }
      if (paramStGetFeedListRsp.extInfo.has()) {
        updateSession((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      this.c = paramStGetFeedListRsp.feedAttchInfo.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("feed size:");
      ((StringBuilder)localObject).append(paramString.size());
      ((StringBuilder)localObject).append(" | isFinish:");
      paramBoolean1 = bool1;
      if (paramStGetFeedListRsp.isFinish.get() > 0) {
        paramBoolean1 = true;
      }
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" | feedAttachInfo:");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("QCircleTagPageViewModel", 1, ((StringBuilder)localObject).toString());
      return;
    }
    this.a.setValue(UIStateData.a(paramString).a(paramLong).b(paramBoolean2));
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
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleTagPageViewModel
 * JD-Core Version:    0.7.0.1
 */