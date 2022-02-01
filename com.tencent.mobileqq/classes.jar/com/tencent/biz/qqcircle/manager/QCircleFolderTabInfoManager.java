package com.tencent.biz.qqcircle.manager;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.QCircleCollection;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeInfoManger;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudRead.StGetBusiInfoReq;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StRewardData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QCircleFolderTabInfoManager
{
  private static volatile QCircleFolderTabInfoManager d;
  private final ConcurrentHashMap<String, List<QQCircleFeedBase.StTabInfo>> a = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap();
  private final int c = QCircleConfigHelper.a(6);
  
  public QCircleFolderTabInfoManager()
  {
    c();
    d();
  }
  
  private int a(QQCircleFeedBase.StBusiInfoData paramStBusiInfoData, List<QQCircleFeedBase.StTabInfo> paramList)
  {
    int i = this.c;
    if (!paramStBusiInfoData.defaultTabIndex.has())
    {
      QLog.d("QCircleFolderTabInfoManager", 1, "parseJumpTabType defaultTabIndex not set,use default");
      return i;
    }
    try
    {
      int j = ((QQCircleFeedBase.StTabInfo)paramList.get(paramStBusiInfoData.defaultTabIndex.get())).tabType.get();
      return j;
    }
    catch (Exception paramStBusiInfoData)
    {
      paramStBusiInfoData.printStackTrace();
      QLog.d("QCircleFolderTabInfoManager", 1, new Object[] { "parseJumpTabType parse exception:", paramStBusiInfoData.toString() });
    }
    return i;
  }
  
  public static QCircleFolderTabInfoManager a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new QCircleFolderTabInfoManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  private List<QQCircleFeedBase.StTabInfo> a(@NonNull String[] paramArrayOfString)
  {
    Object localObject = new ArrayList();
    try
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a((List)localObject, Integer.parseInt(paramArrayOfString[i]));
        i += 1;
      }
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label41:
      break label41;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wrapTabByOrders failed,typeOrders:");
    ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfString));
    QLog.d("QCircleFolderTabInfoManager", 1, ((StringBuilder)localObject).toString());
    paramArrayOfString = new ArrayList();
    c(paramArrayOfString);
    a(paramArrayOfString);
    b(paramArrayOfString);
    return paramArrayOfString;
  }
  
  private void a(QCircleGetTabListRequest paramQCircleGetTabListRequest)
  {
    VSNetworkHelper.getInstance().sendRequest(paramQCircleGetTabListRequest, new QCircleFolderTabInfoManager.2(this));
  }
  
  private void a(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt == null) {
      return;
    }
    List localList = paramStCommonExt.mapBytesInfo.get();
    Object localObject = QCircleReportHelper.getInstance().getInviteId();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = ((String)localObject).getBytes();
    if (localObject != null)
    {
      FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
      localBytesEntry.key.set("circle_invite");
      localBytesEntry.value.set(ByteStringMicro.copyFrom((byte[])localObject));
      localList.add(localBytesEntry);
    }
    paramStCommonExt.mapBytesInfo.set(localList);
  }
  
  private void a(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      int i = ((Integer)this.b.get(paramString)).intValue();
      QCirclePluginGlobalInfo.a(i);
      QLog.d("QCircleFolderTabInfoManager", 1, new Object[] { "setJumpTabType:", Integer.valueOf(i) });
    }
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    QQCircleFeedBase.StTabInfo localStTabInfo = new QQCircleFeedBase.StTabInfo();
    localStTabInfo.tabType.set(1);
    localStTabInfo.tabName.set(HardCodeUtil.a(2131895724));
    paramList.add(localStTabInfo);
  }
  
  private void a(@NonNull List<QQCircleFeedBase.StTabInfo> paramList, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 6) {
          return;
        }
        b(paramList);
        return;
      }
      c(paramList);
      return;
    }
    a(paramList);
  }
  
  private void a(QQCircleFeedBase.StBusiInfoData paramStBusiInfoData)
  {
    if (paramStBusiInfoData != null)
    {
      if (!paramStBusiInfoData.tabInfos.has()) {
        return;
      }
      b(paramStBusiInfoData);
      List localList = paramStBusiInfoData.tabInfos.get();
      int i = a(paramStBusiInfoData, localList);
      RFThreadManager.getUIHandler().post(new QCircleFolderTabInfoManager.3(this, i, localList));
    }
  }
  
  public static void b()
  {
    QLog.d("QCircleFolderTabInfoManager", 1, "releaseInstance");
    if (d != null) {
      try
      {
        if (d != null) {
          d = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void b(QCircleGetTabListRequest paramQCircleGetTabListRequest)
  {
    if (paramQCircleGetTabListRequest != null)
    {
      if (paramQCircleGetTabListRequest.mReq == null) {
        return;
      }
      FeedCloudCommon.StCommonExt localStCommonExt = (FeedCloudCommon.StCommonExt)paramQCircleGetTabListRequest.mReq.extInfo.get();
      a(localStCommonExt);
      b(localStCommonExt);
      paramQCircleGetTabListRequest.mReq.extInfo.set(localStCommonExt);
    }
  }
  
  private void b(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt == null) {
      return;
    }
    List localList = paramStCommonExt.mapInfo.get();
    localList.add(QCircleReportFirstLogin.getFirstLoginEntry());
    paramStCommonExt.mapInfo.set(localList);
  }
  
  private void b(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    QQCircleFeedBase.StTabInfo localStTabInfo = new QQCircleFeedBase.StTabInfo();
    localStTabInfo.tabType.set(6);
    localStTabInfo.tabName.set(HardCodeUtil.a(2131895726));
    paramList.add(localStTabInfo);
  }
  
  private void b(QQCircleFeedBase.StBusiInfoData paramStBusiInfoData)
  {
    List localList = paramStBusiInfoData.allPolyInfo.get();
    if (localList != null)
    {
      QCirclePolyLikeInfoManger.a().a(localList);
      QCirclePolyLikeInfoManger.a().a((float)paramStBusiInfoData.rewardData.myMoney.get());
    }
  }
  
  private boolean b(String paramString)
  {
    if (this.a.containsKey(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTabInfo in ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" level");
      QLog.d("QCircleFolderTabInfoManager", 1, localStringBuilder.toString());
      a(paramString);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    Object localObject = QCirclePluginConfig.M();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDefaultTabInfo error,defaultTabTapeOrder:");
      localStringBuilder.append((String)localObject);
      QLog.d("QCircleFolderTabInfoManager", 1, localStringBuilder.toString());
      return;
    }
    localObject = a(((String)localObject).split(","));
    this.a.put("default", localObject);
    this.b.put("default", Integer.valueOf(this.c));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDefaultTabInfo done,size:");
    localStringBuilder.append(((List)localObject).size());
    localStringBuilder.append(",jumpTabType:");
    localStringBuilder.append(this.c);
    QLog.d("QCircleFolderTabInfoManager", 1, localStringBuilder.toString());
  }
  
  private void c(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (QCircleConfigHelper.aD())
    {
      QQCircleFeedBase.StTabInfo localStTabInfo = new QQCircleFeedBase.StTabInfo();
      localStTabInfo.tabType.set(4);
      localStTabInfo.tabName.set(HardCodeUtil.a(2131895725));
      paramList.add(localStTabInfo);
    }
  }
  
  private void d()
  {
    QQCircleFeedBase.StBusiInfoData localStBusiInfoData = QCirclePluginConfig.a().t();
    if ((localStBusiInfoData != null) && (!localStBusiInfoData.tabInfos.isEmpty()))
    {
      b(localStBusiInfoData);
      this.a.put("cache", localStBusiInfoData.tabInfos.get());
      int i = a(localStBusiInfoData, localStBusiInfoData.tabInfos.get());
      this.b.put("cache", Integer.valueOf(i));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initCacheTabInfo done,size:");
      localStringBuilder.append(localStBusiInfoData.tabInfos.size());
      localStringBuilder.append(",jumpTabType:");
      localStringBuilder.append(i);
      QLog.d("QCircleFolderTabInfoManager", 1, localStringBuilder.toString());
      return;
    }
    QLog.e("QCircleFolderTabInfoManager", 1, "initCacheTabInfo error,no cache tabInfo data");
  }
  
  private void e()
  {
    QCircleCollection.a("qcircle_preload");
    QLog.i("QCircleFolderTabInfoManager", 1, "fetchNewDataFromPreload");
    PreLoader.addListener("2002", new QCircleFolderTabInfoManager.1(this));
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2, QCircleFolderBean paramQCircleFolderBean)
  {
    boolean bool = PreLoader.exists("2002");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchNewData from Preload:");
    localStringBuilder.append(bool);
    QLog.d("QCircleFolderTabInfoManager", 1, localStringBuilder.toString());
    if (bool)
    {
      e();
      return;
    }
    b(paramStGPSV2, paramQCircleFolderBean);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    QCircleCollection.a("handleTabListResponse");
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetBusiInfoRsp != null))
    {
      paramString = new QQCircleFeedBase.StBusiInfoData();
      paramStGetBusiInfoRsp = paramStGetBusiInfoRsp.busiRspData.get().toByteArray();
      try
      {
        paramString.mergeFrom(paramStGetBusiInfoRsp);
        QCirclePluginConfig.a().a(paramStGetBusiInfoRsp);
        a(paramString);
        QCirclePeriodCollect.record("get_tab_net_rsp");
        QCircleCollection.a("handleTabListResponse", "");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        QLog.d("QCircleFolderTabInfoManager", 1, new Object[] { "handleTabListResponse parse setBusiInfoData exception:", paramString.toString() });
        return;
      }
    }
    QLog.d("QCircleFolderTabInfoManager", 1, new Object[] { "handleTabListRsp isSuc:", Boolean.valueOf(paramBoolean), ",retCode:", Long.valueOf(paramLong), ",errMsg:", paramString });
  }
  
  public void b(FeedCloudMeta.StGPSV2 paramStGPSV2, QCircleFolderBean paramQCircleFolderBean)
  {
    QCircleCollection.a("QCircleTabViewModel");
    paramStGPSV2 = new QCircleGetTabListRequest(paramStGPSV2, paramQCircleFolderBean);
    paramStGPSV2.setRetryCount(2);
    b(paramStGPSV2);
    paramQCircleFolderBean = new StringBuilder();
    paramQCircleFolderBean.append("requestTabData(),CmdName:");
    paramQCircleFolderBean.append(paramStGPSV2.getCmdName());
    paramQCircleFolderBean.append(" | TraceId:");
    paramQCircleFolderBean.append(paramStGPSV2.getTraceId());
    paramQCircleFolderBean.append(" | SeqId:");
    paramQCircleFolderBean.append(paramStGPSV2.getCurrentSeq());
    QLog.d("QCircleFolderTabInfoManager", 1, paramQCircleFolderBean.toString());
    a(paramStGPSV2);
  }
  
  public List<QQCircleFeedBase.StTabInfo> c(FeedCloudMeta.StGPSV2 paramStGPSV2, QCircleFolderBean paramQCircleFolderBean)
  {
    a(paramStGPSV2, paramQCircleFolderBean);
    if (b("new")) {
      return (List)this.a.get("new");
    }
    if (b("cache")) {
      return (List)this.a.get("cache");
    }
    QLog.d("QCircleFolderTabInfoManager", 1, "getTabInfo in default level");
    a("default");
    return (List)this.a.get("default");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager
 * JD-Core Version:    0.7.0.1
 */