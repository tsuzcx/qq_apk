package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.WadlBusinessServlet;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.AccountInfo;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.AppInfo;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.EventInfo;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.ExpeEventReportReq;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.ExpeInfo;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.UserActionInfo;
import com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy.AttaItem;
import com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy.AttaValue;
import com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy.ReportAttaListReq;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeReq;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListRsp;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcMetaData;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcMsg;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcOptions;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport.DcRecord;
import com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport.DcReportRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport.KV;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameTrpcServiceImpl
  implements IQQGameTrpcService
{
  private static final String TAG = "Wadl_QQGameTrpcServiceImpl";
  static byte[] lock = new byte[0];
  private CopyOnWriteArrayList<WeakReference<WadlTrpcListener>> trpcListeners = new CopyOnWriteArrayList();
  
  private TrpcAttaProxy.AttaValue createAttaValue(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("createAttaValue key=");
      paramString2.append(paramString1);
      paramString2.append(",value is null");
      QLog.w("Wadl_QQGameTrpcServiceImpl", 1, paramString2.toString());
      str = "";
    }
    paramString2 = new TrpcAttaProxy.AttaValue();
    paramString2.key.set(paramString1);
    paramString2.value.set(str);
    return paramString2;
  }
  
  private WadlTrpcReport.KV createDcRecord(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("createDcRecord key=");
      paramString2.append(paramString1);
      paramString2.append(",value is null");
      QLog.w("Wadl_QQGameTrpcServiceImpl", 1, paramString2.toString());
      str = "";
    }
    paramString2 = new WadlTrpcReport.KV();
    paramString2.key.set(paramString1);
    paramString2.value.set(str);
    return paramString2;
  }
  
  private WadlTrpcReport.DcReportRequest getDcReportReq(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("req").optJSONArray("report_list");
    WadlTrpcReport.DcReportRequest localDcReportRequest = new WadlTrpcReport.DcReportRequest();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.optJSONObject(i);
      if (localObject != null)
      {
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("data");
        if (localJSONObject == null)
        {
          QLog.w("Wadl_QQGameTrpcServiceImpl", 1, "requestTrpc data is null");
        }
        else
        {
          WadlTrpcReport.DcRecord localDcRecord = new WadlTrpcReport.DcRecord();
          localDcRecord.dcId.set(((JSONObject)localObject).optString("dc_id"));
          localObject = localJSONObject.keys();
          while (((Iterator)localObject).hasNext())
          {
            String str1 = (String)((Iterator)localObject).next();
            String str2 = localJSONObject.optString(str1);
            localDcRecord.data.add(createDcRecord(str1, str2));
          }
          localDcReportRequest.record.add(localDcRecord);
        }
      }
      i += 1;
    }
    return localDcReportRequest;
  }
  
  private void notifyListeners(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("notifyListeners cmd=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(",ret=");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append(",listeners size=");
    ((StringBuilder)localObject1).append(this.trpcListeners.size());
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.trpcListeners.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (WeakReference)((Iterator)localObject1).next();
      WadlTrpcListener localWadlTrpcListener = (WadlTrpcListener)((WeakReference)localObject2).get();
      if (localWadlTrpcListener != null)
      {
        localObject2 = localWadlTrpcListener.getFilterCmds();
        if ((localObject2 == null) || (((HashSet)localObject2).contains(paramString)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("notifyListeners cmd=");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(",ret=");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append(",listener=");
          ((StringBuilder)localObject2).append(localWadlTrpcListener);
          QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject2).toString());
          localWadlTrpcListener.onTrpcRsp(paramIntent, paramString, paramLong, paramTrpcInovkeRsp);
        }
      }
      else
      {
        this.trpcListeners.remove(localObject2);
      }
    }
  }
  
  public void addListener(WadlTrpcListener paramWadlTrpcListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addListener listener=");
    ((StringBuilder)localObject).append(paramWadlTrpcListener);
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (paramWadlTrpcListener == null) {
      return;
    }
    localObject = this.trpcListeners.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WadlTrpcListener localWadlTrpcListener = (WadlTrpcListener)((WeakReference)((Iterator)localObject).next()).get();
      if ((localWadlTrpcListener != null) && (localWadlTrpcListener == paramWadlTrpcListener)) {
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addListener listener=");
    ((StringBuilder)localObject).append(paramWadlTrpcListener);
    ((StringBuilder)localObject).append(" succ");
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject).toString());
    this.trpcListeners.add(new WeakReference(paramWadlTrpcListener));
  }
  
  public TrpcProxy.TrpcInovkeReq createTrpcInvokeReq(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("createTrpcInvokeReq cmdId=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(",sendOnly=");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(",data=");
    ((StringBuilder)localObject1).append(paramArrayOfByte);
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new TrpcProxy.TrpcMsg();
    ((TrpcProxy.TrpcMsg)localObject1).clientRPCName.set(paramString);
    paramString = new TrpcProxy.TrpcOptions();
    paramString.currentSerializationType.set(4);
    paramString.serializationType.set(0);
    if (paramBoolean) {
      paramString.requestType.set(1);
    }
    Object localObject2 = new ArrayList();
    TrpcProxy.TrpcMetaData localTrpcMetaData = new TrpcProxy.TrpcMetaData();
    localTrpcMetaData.key.set("platform");
    localTrpcMetaData.value.set(ByteStringMicro.copyFrom("Android".getBytes()));
    ((List)localObject2).add(localTrpcMetaData);
    paramString.metaData2.set((List)localObject2);
    localObject2 = new TrpcProxy.TrpcInovkeReq();
    ((TrpcProxy.TrpcInovkeReq)localObject2).msg.set((MessageMicro)localObject1);
    ((TrpcProxy.TrpcInovkeReq)localObject2).data.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    ((TrpcProxy.TrpcInovkeReq)localObject2).options.set(paramString);
    return localObject2;
  }
  
  public void destroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy trpcListeners=");
    localStringBuilder.append(this.trpcListeners.size());
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, localStringBuilder.toString());
    this.trpcListeners.clear();
  }
  
  public void onRespTrpcSso(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramIntent == null) {
      return;
    }
    long l2 = -1L;
    long l1 = l2;
    Object localObject1;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramArrayOfByte != null)
      {
        l1 = l2;
        try
        {
          localObject1 = new WebSSOAgent.UniSsoServerRsp();
          l1 = l2;
          ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramArrayOfByte);
          l1 = l2;
          l2 = ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get();
          l1 = l2;
          if (l2 == 0L)
          {
            l1 = l2;
            paramArrayOfByte = new TrpcProxy.TrpcListRsp();
            l1 = l2;
            paramArrayOfByte.mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject1).pbRsqData.get().toByteArray());
            l1 = l2;
            l2 = paramArrayOfByte.ret.get();
            l1 = l2;
            paramArrayOfByte = paramArrayOfByte.list.get();
            l1 = l2;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onRespTrpcSso err:");
          ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
          QLog.e("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject1).toString());
        }
      }
    }
    paramArrayOfByte = null;
    String[] arrayOfString = paramIntent.getStringArrayExtra("trpcssoCmdIds");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onRespTrpcSso cmdArray=");
    ((StringBuilder)localObject2).append(arrayOfString);
    ((StringBuilder)localObject2).append("sSucc=");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(",ret=");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append(",rspList size=");
    if (paramArrayOfByte != null) {
      localObject1 = Integer.valueOf(paramArrayOfByte.size());
    } else {
      localObject1 = "is null";
    }
    ((StringBuilder)localObject2).append(localObject1);
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject2).toString());
    int j = 0;
    int i;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() == arrayOfString.length)) {
      i = 1;
    } else {
      i = 0;
    }
    while (j < arrayOfString.length)
    {
      localObject2 = arrayOfString[j];
      if (i != 0)
      {
        localObject1 = (TrpcProxy.TrpcInovkeRsp)paramArrayOfByte.get(j);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRespTrpcSso on TRPC, cmd=");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(",rsp=[ret=");
        localStringBuilder.append(((TrpcProxy.TrpcInovkeRsp)localObject1).ret.get());
        localStringBuilder.append(",msg=");
        localStringBuilder.append(((TrpcProxy.TrpcInovkeRsp)localObject1).msg.get());
        localStringBuilder.append("]");
        QLog.d("Wadl_QQGameTrpcServiceImpl", 1, localStringBuilder.toString());
      }
      else
      {
        localObject1 = null;
      }
      int k;
      if (localObject1 != null) {
        k = ((TrpcProxy.TrpcInovkeRsp)localObject1).ret.get();
      } else {
        k = -1;
      }
      notifyListeners(paramIntent, (String)localObject2, k, (TrpcProxy.TrpcInovkeRsp)localObject1);
      j += 1;
    }
  }
  
  public void removeListener(WadlTrpcListener paramWadlTrpcListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("removeListener listener=");
    ((StringBuilder)localObject).append(paramWadlTrpcListener);
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (paramWadlTrpcListener == null) {
      return;
    }
    localObject = this.trpcListeners.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      WadlTrpcListener localWadlTrpcListener = (WadlTrpcListener)localWeakReference.get();
      if ((localWadlTrpcListener != null) && (localWadlTrpcListener == paramWadlTrpcListener))
      {
        boolean bool = this.trpcListeners.remove(localWeakReference);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeListener listener=");
        ((StringBuilder)localObject).append(paramWadlTrpcListener);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void reportAtta(JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reportAtta reportData=");
    ((StringBuilder)localObject1).append(paramJSONObject);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = "Wadl_QQGameTrpcServiceImpl";
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, (String)localObject2);
    if (paramJSONObject != null)
    {
      if (!paramJSONObject.has("report_list")) {
        return;
      }
      localObject2 = paramJSONObject.optJSONArray("report_list");
      TrpcAttaProxy.ReportAttaListReq localReportAttaListReq = new TrpcAttaProxy.ReportAttaListReq();
      int i = ((JSONArray)localObject2).length();
      int j = 0;
      paramJSONObject = (JSONObject)localObject1;
      localObject1 = localObject2;
      while (j < i)
      {
        Object localObject3 = ((JSONArray)localObject1).optJSONObject(j);
        if (localObject3 != null)
        {
          localObject2 = ((JSONObject)localObject3).optJSONObject("data");
          if (localObject2 == null)
          {
            QLog.w(paramJSONObject, 1, "reportAtta data is null");
          }
          else
          {
            TrpcAttaProxy.AttaItem localAttaItem = new TrpcAttaProxy.AttaItem();
            localAttaItem.attaId.set(((JSONObject)localObject3).optString("dc_id"));
            localAttaItem.valueList.add(createAttaValue("uin", GameCenterUtil.b()));
            long l = NetConnInfoCenter.getServerTime();
            localAttaItem.valueList.add(createAttaValue("itimestamp", String.valueOf(l)));
            localAttaItem.valueList.add(createAttaValue("domain", "1"));
            localAttaItem.valueList.add(createAttaValue("sq_ver", "8.8.17"));
            localAttaItem.valueList.add(createAttaValue("gamecenter_ver", ""));
            localAttaItem.valueList.add(createAttaValue("gamecenter_ver_type", "2"));
            localAttaItem.valueList.add(createAttaValue("device_type", Build.BRAND));
            int m = HttpUtil.getNetWorkType();
            if (m >= 0)
            {
              k = m;
              if (m < AppConstants.NET_TYPE_NAME.length) {}
            }
            else
            {
              k = 0;
            }
            localAttaItem.valueList.add(createAttaValue("net_type", AppConstants.NET_TYPE_NAME[k]));
            localAttaItem.valueList.add(createAttaValue("resolution", GameCenterUtil.d()));
            localAttaItem.valueList.add(createAttaValue("is_red_point", "0"));
            localAttaItem.valueList.add(createAttaValue("is_new_status", "0"));
            localAttaItem.valueList.add(createAttaValue("gamecenter_src", "1"));
            localAttaItem.valueList.add(createAttaValue("ret_id", String.valueOf(((JSONObject)localObject2).optInt("ret_id", 0))));
            localObject3 = ((JSONObject)localObject2).optString("oper_moudle");
            String str1 = ((JSONObject)localObject2).optString("oper_id");
            String str2 = ((JSONObject)localObject2).optString("gameappid");
            String str3 = ((JSONObject)localObject2).optString("tianji_report_str");
            String str4 = ((JSONObject)localObject2).optString("apk_volume");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localAttaItem.valueList.add(createAttaValue("oper_moudle", (String)localObject3));
            }
            if (!TextUtils.isEmpty(str1)) {
              localAttaItem.valueList.add(createAttaValue("oper_id", str1));
            }
            if (!TextUtils.isEmpty(str2)) {
              localAttaItem.valueList.add(createAttaValue("gameappid", str2));
            }
            if (!TextUtils.isEmpty(str3)) {
              localAttaItem.valueList.add(createAttaValue("tianji_report_str", str3));
            }
            if (!TextUtils.isEmpty(str4)) {
              localAttaItem.valueList.add(createAttaValue("apk_volume", str4));
            }
            int k = 1;
            while (k <= WadlReportBuilder.a)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("ext");
              ((StringBuilder)localObject3).append(k);
              localObject3 = ((StringBuilder)localObject3).toString();
              if (((JSONObject)localObject2).has((String)localObject3)) {
                localAttaItem.valueList.add(createAttaValue((String)localObject3, ((JSONObject)localObject2).optString((String)localObject3)));
              }
              k += 1;
            }
            localReportAttaListReq.attaList.add(localAttaItem);
          }
        }
        j += 1;
      }
      paramJSONObject = createTrpcInvokeReq("/v1/11", true, localReportAttaListReq.toByteArray());
      localObject1 = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject1).list.add(paramJSONObject);
      requestTrpc((TrpcProxy.TrpcListReq)localObject1, null);
    }
  }
  
  public void reportTianJi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportTianJi appId=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",eventId=");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(",eventType=");
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append(",eventType2=");
    ((StringBuilder)localObject).append(paramString5);
    ((StringBuilder)localObject).append(",eventType3=");
    ((StringBuilder)localObject).append(paramString6);
    ((StringBuilder)localObject).append(",eventResult=");
    ((StringBuilder)localObject).append(paramString7);
    ((StringBuilder)localObject).append(",eventErrCode=");
    ((StringBuilder)localObject).append(paramString8);
    ((StringBuilder)localObject).append(",expeSysTransfer=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject).toString());
    localObject = new ExpeDataAcc.AppInfo();
    ((ExpeDataAcc.AppInfo)localObject).appid.set(paramString1);
    paramString1 = new ExpeDataAcc.AccountInfo();
    paramString1.accountType.set(1L);
    paramString1.uid.set(GameCenterUtil.b());
    ExpeDataAcc.ExpeInfo localExpeInfo = new ExpeDataAcc.ExpeInfo();
    localExpeInfo.expeSysTransfer.set(paramString2);
    paramString2 = new ExpeDataAcc.EventInfo();
    paramString2.eventId.set(paramString3);
    paramString2.eventType.set(paramString4);
    paramString2.eventType2.set(paramString5);
    paramString2.eventType3.set(paramString6);
    paramString2.eventErrCode.set(paramString8);
    paramString2.eventResult.set(paramString7);
    paramString3 = new ExpeDataAcc.UserActionInfo();
    paramString3.appInfo.set((MessageMicro)localObject);
    paramString3.accountInfo.set(paramString1);
    paramString3.expeInfo.set(localExpeInfo);
    paramString3.eventInfo.set(paramString2);
    paramString1 = new ExpeDataAcc.ExpeEventReportReq();
    paramString1.noNeedRsp.set(1);
    paramString1.actionInfos.add(paramString3);
    paramString1 = createTrpcInvokeReq("/v1/2", true, paramString1.toByteArray());
    paramString2 = new TrpcProxy.TrpcListReq();
    paramString2.list.add(paramString1);
    requestTrpc(paramString2, null);
  }
  
  public void reportToDcByTrpc(JSONObject paramJSONObject)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportToDcByTrpc reportData= ");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(",appRuntime:");
    ((StringBuilder)localObject).append(localAppRuntime);
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (localAppRuntime == null) {
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.optJSONObject("req") != null))
    {
      if (paramJSONObject.optJSONObject("req").optJSONArray("report_list") == null) {
        return;
      }
      paramJSONObject = getDcReportReq(paramJSONObject);
      localObject = new NewIntent(MobileQQ.getContext(), WadlBusinessServlet.class);
      ((NewIntent)localObject).putExtra("extra_cmd", "trpc.down.report.Report.DcReport");
      ((NewIntent)localObject).putExtra("webssoReq", paramJSONObject.toByteArray());
      ((NewIntent)localObject).putExtra("wadl_sso_type", 2);
      localAppRuntime.startServlet((NewIntent)localObject);
    }
  }
  
  public void requestTrpc(TrpcProxy.TrpcListReq paramTrpcListReq, Bundle paramBundle)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestTrpc trpcListReq=");
    ((StringBuilder)localObject).append(paramTrpcListReq);
    ((StringBuilder)localObject).append(",extra=");
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append(",appRuntime=");
    ((StringBuilder)localObject).append(localAppRuntime);
    QLog.d("Wadl_QQGameTrpcServiceImpl", 1, ((StringBuilder)localObject).toString());
    if (localAppRuntime != null)
    {
      if (paramTrpcListReq == null) {
        return;
      }
      try
      {
        localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17.5770");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(paramTrpcListReq.toByteArray()));
        NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, WadlBusinessServlet.class);
        localObject = paramBundle;
        if (paramBundle == null) {
          localObject = new Bundle();
        }
        paramTrpcListReq = paramTrpcListReq.list.get();
        int j = paramTrpcListReq.size();
        paramBundle = new String[j];
        int i = 0;
        while (i < j)
        {
          paramBundle[i] = ((TrpcProxy.TrpcInovkeReq)paramTrpcListReq.get(i)).msg.clientRPCName.get();
          i += 1;
        }
        ((Bundle)localObject).putInt("wadl_sso_type", 1);
        ((Bundle)localObject).putStringArray("trpcssoCmdIds", paramBundle);
        ((Bundle)localObject).putByteArray("webssoReq", localUniSsoServerReq.toByteArray());
        localNewIntent.putExtras((Bundle)localObject);
        localAppRuntime.startServlet(localNewIntent);
        return;
      }
      catch (Exception paramTrpcListReq)
      {
        QLog.e("Wadl_QQGameTrpcServiceImpl", 1, "requestTrpc exception=", paramTrpcListReq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameTrpcServiceImpl
 * JD-Core Version:    0.7.0.1
 */