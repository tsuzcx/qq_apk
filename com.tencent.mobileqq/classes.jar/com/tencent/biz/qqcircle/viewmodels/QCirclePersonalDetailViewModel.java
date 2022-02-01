package com.tencent.biz.qqcircle.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.QCircleTransFormHelper;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qqcircle.report.QCircleReporterAgent;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageReq;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.Collection;
import java.util.List;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class QCirclePersonalDetailViewModel
  extends QCircleBaseViewModel
  implements IDataDisplaySurface<FeedBlockData>, IQCircleReportSessionOperation
{
  private MutableLiveData<UIStateData<FeedCloudRead.StGetMainPageRsp>> a = new MutableLiveData();
  private final MutableLiveData<UIStateData<List<FeedBlockData>>> b = new MutableLiveData();
  private MutableLiveData<FeedCloudMeta.StUser> c = new MutableLiveData();
  private MutableLiveData<QQCircleFeedBase.StMainPageBusiRspData> d = new MutableLiveData();
  private String e = null;
  private String f;
  private QCircleInitBean g;
  
  public QCirclePersonalDetailViewModel()
  {
    this.k = QCircleReporterAgent.obtain(32);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, QCircleInitBean paramQCircleInitBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestData uin : ");
    localStringBuilder.append(paramString1);
    QLog.d("QCirclePersonalDetailViewModel", 1, localStringBuilder.toString());
    paramString1 = new QCircleGetMainPageRequest(paramString1, paramString2, paramQCircleInitBean);
    paramString1.mRequest.extInfo.set(getSession(paramBoolean1 ^ true));
    paramString1.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
    paramString1.setEnableCache(paramBoolean2);
    paramString2 = this.b;
    if ((paramString2 != null) && (paramString2.getValue() != null)) {
      ((UIStateData)this.b.getValue()).d();
    }
    this.a.setValue(UIStateData.b());
    a(paramString1, new QCirclePersonalDetailViewModel.1(this, paramString1, paramBoolean1, paramQCircleInitBean));
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a(Object... paramVarArgs)
  {
    return this.b;
  }
  
  public String a()
  {
    return "QCirclePersonalDetailViewModel";
  }
  
  public void a(String paramString, QCircleInitBean paramQCircleInitBean)
  {
    this.f = paramString;
    this.g = paramQCircleInitBean;
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.f, null, false, paramBoolean, this.g);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp, Boolean paramBoolean1, QCircleInitBean paramQCircleInitBean)
  {
    boolean bool2 = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramLong == 10028L) && (this.c.getValue() != null)) {
      ((FeedCloudMeta.StUser)this.c.getValue()).blackState.set(1);
    }
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetMainPageRsp != null))
    {
      if ((paramStGetMainPageRsp.user != null) && (!TextUtils.isEmpty(paramStGetMainPageRsp.user.id.get())))
      {
        if (!bool2) {
          QCircleFollowManager.getInstance().setUinFollowed(paramStGetMainPageRsp.user.id.get(), paramStGetMainPageRsp.user.followState.get());
        }
        this.c.setValue(paramStGetMainPageRsp.user.get());
      }
      localObject1 = this.a;
      localObject2 = UIStateData.a(bool2).a(paramBoolean1.booleanValue(), paramStGetMainPageRsp);
      int i = paramStGetMainPageRsp.isFinish.get();
      bool1 = false;
      if (i > 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((MutableLiveData)localObject1).setValue(((UIStateData)localObject2).c(paramBoolean));
      localObject1 = QCircleTransFormHelper.a(paramStGetMainPageRsp.vecFeed.get());
      if (((List)localObject1).size() > 0)
      {
        if (!paramBoolean1.booleanValue())
        {
          paramBoolean1 = UIStateData.a(bool2).a(paramBoolean1.booleanValue(), localObject1);
        }
        else
        {
          if (((UIStateData)this.b.getValue()).e() != null) {
            ((List)((UIStateData)this.b.getValue()).e()).addAll((Collection)localObject1);
          } else {
            ((UIStateData)this.b.getValue()).a(paramBoolean1.booleanValue(), localObject1);
          }
          paramBoolean1 = UIStateData.a(bool2).a(paramBoolean1.booleanValue(), ((UIStateData)this.b.getValue()).e());
        }
      }
      else {
        paramBoolean1 = UIStateData.a().b(paramBoolean1.booleanValue());
      }
      if (paramStGetMainPageRsp.isFinish.get() > 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramBoolean1.c(paramBoolean);
      if (paramStGetMainPageRsp.busiRspData.get() != null)
      {
        localObject2 = new QQCircleFeedBase.StMainPageBusiRspData();
        paramBoolean1.a(paramStGetMainPageRsp.busiRspData.get().toByteArray());
      }
    }
    try
    {
      ((QQCircleFeedBase.StMainPageBusiRspData)localObject2).mergeFrom(paramStGetMainPageRsp.busiRspData.get().toByteArray());
      this.d.setValue(localObject2);
    }
    catch (Exception localException)
    {
      label442:
      break label442;
    }
    QLog.e("QCirclePersonalDetailViewModel", 1, "mergeFrom stMainPageBusiRspData error");
    this.b.setValue(paramBoolean1);
    if (paramStGetMainPageRsp.extInfo.has()) {
      updateSession((FeedCloudCommon.StCommonExt)paramStGetMainPageRsp.extInfo.get());
    }
    this.e = paramStGetMainPageRsp.feedAttchInfo.get();
    if (!VSNetworkHelper.isProtocolCache(paramString))
    {
      QCirclePluginGlobalInfo.b(paramStGetMainPageRsp.isFirstLogin.get());
      if ((paramQCircleInitBean != null) && (paramQCircleInitBean.isNeedShowGoHomeButton())) {
        QCircleDTLoginReporter.daTongLoginReportMiddlePage(paramQCircleInitBean.getSchemeAttrs(), QCirclePluginGlobalInfo.k());
      }
    }
    paramString = new StringBuilder();
    paramString.append("feed size:");
    paramString.append(((List)localObject1).size());
    paramString.append(" | isFinish:");
    paramBoolean = bool1;
    if (paramStGetMainPageRsp.isFinish.get() > 0) {
      paramBoolean = true;
    }
    paramString.append(paramBoolean);
    paramString.append(" | feedAttachInfo:");
    paramString.append(this.e);
    QLog.d("QCirclePersonalDetailViewModel", 1, paramString.toString());
    return;
    this.b.setValue(UIStateData.a(paramString).a(paramLong).b(paramBoolean1.booleanValue()));
    this.a.setValue(UIStateData.a(paramString).b(paramBoolean1.booleanValue()));
  }
  
  public MutableLiveData<UIStateData<FeedCloudRead.StGetMainPageRsp>> b()
  {
    return this.a;
  }
  
  public void b(Object... paramVarArgs)
  {
    if ((!((UIStateData)this.b.getValue()).h()) && (!((UIStateData)this.b.getValue()).l())) {
      f();
    }
  }
  
  public int c()
  {
    return 8;
  }
  
  protected void c(Object[] paramArrayOfObject)
  {
    QLog.d("QCirclePersonalDetailViewModel", 1, "onPreloadComplete");
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload requestData onReceive: dispatch Success:");
      localStringBuilder.append((Boolean)paramArrayOfObject[0]);
      localStringBuilder.append(" | retCode:");
      localStringBuilder.append((Long)paramArrayOfObject[1]);
      localStringBuilder.append(" | retMessage:");
      localStringBuilder.append((String)paramArrayOfObject[2]);
      QLog.d("QCirclePersonalDetailViewModel", 1, localStringBuilder.toString());
      a(((Boolean)paramArrayOfObject[0]).booleanValue(), ((Long)paramArrayOfObject[1]).longValue(), (String)paramArrayOfObject[2], (FeedCloudRead.StGetMainPageRsp)paramArrayOfObject[3], Boolean.valueOf(false), this.g);
    }
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> d()
  {
    return this.b;
  }
  
  public MutableLiveData<FeedCloudMeta.StUser> e()
  {
    return this.c;
  }
  
  public void f()
  {
    a(this.f, this.e, true, false, this.g);
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
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel
 * JD-Core Version:    0.7.0.1
 */