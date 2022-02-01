package com.tencent.biz.qqcircle.viewmodels;

import android.text.TextUtils;
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
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.Collection;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QCirclePersonalDetailPushViewModel
  extends QCircleBaseViewModel
  implements IDataDisplaySurface<FeedBlockData>
{
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a = new MutableLiveData();
  private String b = null;
  private String c = null;
  private String d;
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestPushFeedsData uin : ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("QCirclePersonalDetailViewModel", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean1) {
      localObject = this.b;
    } else {
      localObject = null;
    }
    paramString = new QCircleGetFeedListRequest(paramString, (String)localObject, this.c);
    paramString.setEnableCache(paramBoolean2);
    paramString.mRequest.extInfo.setHasFlag(true);
    paramString.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
    e();
    VSNetworkHelper.getInstance().sendRequest(paramString, new QCirclePersonalDetailPushViewModel.1(this, paramBoolean1));
  }
  
  private void e()
  {
    if (this.a.getValue() != null)
    {
      ((UIStateData)this.a.getValue()).d();
      return;
    }
    this.a.setValue(UIStateData.b());
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a(Object... paramVarArgs)
  {
    return this.a;
  }
  
  public String a()
  {
    return "QCirclePersonalDetailViewModel";
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.d, false, paramBoolean);
  }
  
  public void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handlePushFeedsResponse isSuccess:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" retCode:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("errMsg:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("QCirclePersonalDetailViewModel", 1, ((StringBuilder)localObject).toString());
    boolean bool2 = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean1) && (paramLong == 0L) && (paramStGetFeedListRsp != null))
    {
      localObject = QCircleTransFormHelper.a(paramStGetFeedListRsp.vecFeed.get());
      boolean bool1 = false;
      paramBoolean1 = false;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if ((paramBoolean2) && (((UIStateData)this.a.getValue()).e() != null)) {
          ((List)localObject).addAll(0, (Collection)((UIStateData)this.a.getValue()).e());
        }
        paramString = this.a;
        localObject = UIStateData.a(bool2).a(paramBoolean2, localObject);
        if (paramStGetFeedListRsp.isFinish.get() > 0) {
          paramBoolean1 = true;
        }
        paramString.setValue(((UIStateData)localObject).c(paramBoolean1));
      }
      else
      {
        paramString = this.a;
        localObject = UIStateData.a().b(paramBoolean2);
        paramBoolean1 = bool1;
        if (paramStGetFeedListRsp.isFinish.get() > 0) {
          paramBoolean1 = true;
        }
        paramString.setValue(((UIStateData)localObject).c(paramBoolean1));
      }
      this.b = paramStGetFeedListRsp.feedAttchInfo.get();
      if (paramStGetFeedListRsp.busiRspData.has())
      {
        paramString = new QQCircleFeedBase.StFeedListBusiRspData();
        try
        {
          paramString.mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException paramStGetFeedListRsp)
        {
          paramStGetFeedListRsp.printStackTrace();
        }
        if (paramString.refreshAttachInfo.has()) {
          this.c = paramString.refreshAttachInfo.get();
        }
      }
      return;
    }
    this.a.setValue(UIStateData.a(paramString).a(paramLong).b(paramBoolean2));
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> b()
  {
    return this.a;
  }
  
  public void b(Object... paramVarArgs)
  {
    d();
  }
  
  public int c()
  {
    return 9;
  }
  
  public void d()
  {
    a(this.d, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailPushViewModel
 * JD-Core Version:    0.7.0.1
 */