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
  private static final String TAG = "QQGameTrpcServiceImpl";
  static byte[] lock = new byte[0];
  private CopyOnWriteArrayList<WeakReference<WadlTrpcListener>> trpcListeners = new CopyOnWriteArrayList();
  
  private TrpcAttaProxy.AttaValue createAttaValue(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQGameTrpcServiceImpl", 1, "createAttaValue key=" + paramString1 + ",value is null");
      }
      str = "";
    }
    paramString2 = new TrpcAttaProxy.AttaValue();
    paramString2.key.set(paramString1);
    paramString2.value.set(str);
    return paramString2;
  }
  
  private void notifyListeners(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listeners size=" + this.trpcListeners.size());
    }
    Iterator localIterator = this.trpcListeners.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      WadlTrpcListener localWadlTrpcListener = (WadlTrpcListener)((WeakReference)localObject).get();
      if (localWadlTrpcListener != null)
      {
        localObject = localWadlTrpcListener.a();
        if ((localObject == null) || (((HashSet)localObject).contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQGameTrpcServiceImpl", 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listener=" + localWadlTrpcListener);
          }
          localWadlTrpcListener.a(paramIntent, paramString, paramLong, paramTrpcInovkeRsp);
        }
      }
      else
      {
        this.trpcListeners.remove(localObject);
      }
    }
  }
  
  public void addListener(WadlTrpcListener paramWadlTrpcListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 1, "addListener listener=" + paramWadlTrpcListener);
    }
    if (paramWadlTrpcListener == null) {
      return;
    }
    Iterator localIterator = this.trpcListeners.iterator();
    while (localIterator.hasNext())
    {
      WadlTrpcListener localWadlTrpcListener = (WadlTrpcListener)((WeakReference)localIterator.next()).get();
      if ((localWadlTrpcListener != null) && (localWadlTrpcListener == paramWadlTrpcListener)) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 1, "addListener listener=" + paramWadlTrpcListener + " succ");
    }
    this.trpcListeners.add(new WeakReference(paramWadlTrpcListener));
  }
  
  public TrpcProxy.TrpcInovkeReq createTrpcInvokeReq(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 1, "createTrpcInvokeReq cmdId=" + paramString + ",sendOnly=" + paramBoolean + ",data=" + paramArrayOfByte);
    }
    TrpcProxy.TrpcMsg localTrpcMsg = new TrpcProxy.TrpcMsg();
    localTrpcMsg.clientRPCName.set(paramString);
    paramString = new TrpcProxy.TrpcOptions();
    paramString.currentSerializationType.set(4);
    paramString.serializationType.set(0);
    if (paramBoolean) {
      paramString.requestType.set(1);
    }
    Object localObject = new ArrayList();
    TrpcProxy.TrpcMetaData localTrpcMetaData = new TrpcProxy.TrpcMetaData();
    localTrpcMetaData.key.set("platform");
    localTrpcMetaData.value.set(ByteStringMicro.copyFrom("Android".getBytes()));
    ((List)localObject).add(localTrpcMetaData);
    paramString.metaData2.set((List)localObject);
    localObject = new TrpcProxy.TrpcInovkeReq();
    ((TrpcProxy.TrpcInovkeReq)localObject).msg.set(localTrpcMsg);
    ((TrpcProxy.TrpcInovkeReq)localObject).data.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    ((TrpcProxy.TrpcInovkeReq)localObject).options.set(paramString);
    return localObject;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 2, "destroy trpcListeners=" + this.trpcListeners.size());
    }
    this.trpcListeners.clear();
  }
  
  public void onRespTrpcSso(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramIntent == null) {
      return;
    }
    long l2 = -1L;
    Object localObject1 = null;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramArrayOfByte != null) {
        l1 = l2;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new WebSSOAgent.UniSsoServerRsp();
        l1 = l2;
        ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom(paramArrayOfByte);
        l1 = l2;
        l2 = ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get();
        paramArrayOfByte = (byte[])localObject1;
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = l2;
          paramArrayOfByte = new TrpcProxy.TrpcListRsp();
          l1 = l2;
          paramArrayOfByte.mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject2).pbRsqData.get().toByteArray());
          l1 = l2;
          l2 = paramArrayOfByte.ret.get();
          l1 = l2;
          paramArrayOfByte = paramArrayOfByte.list.get();
          l1 = l2;
        }
        localObject2 = paramIntent.getStringArrayExtra("trpcssoCmdIds");
        StringBuilder localStringBuilder = new StringBuilder().append("onRespTrpcSso cmdArray=").append(localObject2).append("sSucc=").append(paramBoolean).append(",ret=").append(l1).append(",rspList size=");
        if (paramArrayOfByte == null) {
          break label425;
        }
        localObject1 = Integer.valueOf(paramArrayOfByte.size());
        QLog.d("QQGameTrpcServiceImpl", 2, localObject1);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() != localObject2.length)) {
          break label433;
        }
        i = 1;
        int j = 0;
        if (j >= localObject2.length) {
          break;
        }
        localStringBuilder = localObject2[j];
        localObject1 = null;
        if (i != 0)
        {
          localObject1 = (TrpcProxy.TrpcInovkeRsp)paramArrayOfByte.get(j);
          QLog.d("QQGameTrpcServiceImpl", 2, "onRespTrpcSso on TRPC, cmd=" + localStringBuilder + ",rsp=[ret=" + ((TrpcProxy.TrpcInovkeRsp)localObject1).ret.get() + ",msg=" + ((TrpcProxy.TrpcInovkeRsp)localObject1).msg.get() + "]");
        }
        if (localObject1 == null) {
          break label439;
        }
        k = ((TrpcProxy.TrpcInovkeRsp)localObject1).ret.get();
        notifyListeners(paramIntent, localStringBuilder, k, (TrpcProxy.TrpcInovkeRsp)localObject1);
        j += 1;
        continue;
        paramArrayOfByte = null;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("QQGameTrpcServiceImpl", 1, "onRespTrpcSso err:" + paramArrayOfByte.getMessage());
      }
      continue;
      label425:
      localObject1 = "is null";
      continue;
      label433:
      int i = 0;
      continue;
      label439:
      int k = -1;
    }
  }
  
  public void removeListener(WadlTrpcListener paramWadlTrpcListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 1, "removeListener listener=" + paramWadlTrpcListener);
    }
    if (paramWadlTrpcListener == null) {
      return;
    }
    boolean bool;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = this.trpcListeners.iterator();
      } while (!localIterator.hasNext());
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      WadlTrpcListener localWadlTrpcListener = (WadlTrpcListener)localWeakReference.get();
      if ((localWadlTrpcListener == null) || (localWadlTrpcListener != paramWadlTrpcListener)) {
        break;
      }
      bool = this.trpcListeners.remove(localWeakReference);
    } while (!QLog.isColorLevel());
    QLog.d("QQGameTrpcServiceImpl", 1, "removeListener listener=" + paramWadlTrpcListener + " " + bool);
  }
  
  public void reportAtta(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 1, "reportAtta reportData=" + paramJSONObject);
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("report_list"))) {
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("report_list");
    Object localObject1 = new TrpcAttaProxy.ReportAttaListReq();
    int m = paramJSONObject.length();
    int i = 0;
    if (i < m)
    {
      Object localObject2 = paramJSONObject.optJSONObject(i);
      JSONObject localJSONObject;
      if (localObject2 != null)
      {
        localJSONObject = ((JSONObject)localObject2).optJSONObject("data");
        if (localJSONObject != null) {
          break label127;
        }
        if (QLog.isColorLevel()) {
          QLog.w("QQGameTrpcServiceImpl", 1, "reportAtta data is null");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label127:
        TrpcAttaProxy.AttaItem localAttaItem = new TrpcAttaProxy.AttaItem();
        localAttaItem.attaId.set(((JSONObject)localObject2).optString("dc_id"));
        localAttaItem.valueList.add(createAttaValue("uin", GameCenterUtil.a()));
        long l = NetConnInfoCenter.getServerTime();
        localAttaItem.valueList.add(createAttaValue("itimestamp", String.valueOf(l)));
        localAttaItem.valueList.add(createAttaValue("domain", "1"));
        localAttaItem.valueList.add(createAttaValue("sq_ver", "8.5.5"));
        localAttaItem.valueList.add(createAttaValue("gamecenter_ver", ""));
        localAttaItem.valueList.add(createAttaValue("gamecenter_ver_type", "2"));
        localAttaItem.valueList.add(createAttaValue("device_type", Build.BRAND));
        int k = HttpUtil.getNetWorkType();
        if (k >= 0)
        {
          j = k;
          if (k < AppConstants.NET_TYPE_NAME.length) {}
        }
        else
        {
          j = 0;
        }
        localAttaItem.valueList.add(createAttaValue("net_type", AppConstants.NET_TYPE_NAME[j]));
        localAttaItem.valueList.add(createAttaValue("resolution", GameCenterUtil.c()));
        localAttaItem.valueList.add(createAttaValue("is_red_point", "0"));
        localAttaItem.valueList.add(createAttaValue("is_new_status", "0"));
        localAttaItem.valueList.add(createAttaValue("gamecenter_src", "1"));
        localAttaItem.valueList.add(createAttaValue("ret_id", String.valueOf(localJSONObject.optInt("ret_id", 0))));
        localObject2 = localJSONObject.optString("oper_moudle");
        String str1 = localJSONObject.optString("oper_id");
        String str2 = localJSONObject.optString("gameappid");
        String str3 = localJSONObject.optString("tianji_report_str");
        String str4 = localJSONObject.optString("apk_volume");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localAttaItem.valueList.add(createAttaValue("oper_moudle", (String)localObject2));
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
        int j = 1;
        while (j <= WadlReportBuilder.a)
        {
          localObject2 = "ext" + j;
          if (localJSONObject.has((String)localObject2)) {
            localAttaItem.valueList.add(createAttaValue((String)localObject2, localJSONObject.optString((String)localObject2)));
          }
          j += 1;
        }
        ((TrpcAttaProxy.ReportAttaListReq)localObject1).attaList.add(localAttaItem);
      }
    }
    paramJSONObject = createTrpcInvokeReq("/v1/11", true, ((TrpcAttaProxy.ReportAttaListReq)localObject1).toByteArray());
    localObject1 = new TrpcProxy.TrpcListReq();
    ((TrpcProxy.TrpcListReq)localObject1).list.add(paramJSONObject);
    requestTrpc((TrpcProxy.TrpcListReq)localObject1, null);
  }
  
  public void reportTianJi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 1, "reportTianJi appId=" + paramString1 + ",eventId=" + paramString3 + ",eventType=" + paramString4 + ",eventType2=" + paramString5 + ",eventType3=" + paramString6 + ",eventResult=" + paramString7 + ",eventErrCode=" + paramString8 + ",expeSysTransfer=" + paramString2);
    }
    ExpeDataAcc.AppInfo localAppInfo = new ExpeDataAcc.AppInfo();
    localAppInfo.appid.set(paramString1);
    paramString1 = new ExpeDataAcc.AccountInfo();
    paramString1.account_type.set(1L);
    paramString1.uid.set(GameCenterUtil.a());
    ExpeDataAcc.ExpeInfo localExpeInfo = new ExpeDataAcc.ExpeInfo();
    localExpeInfo.expe_sys_transfer.set(paramString2);
    paramString2 = new ExpeDataAcc.EventInfo();
    paramString2.event_id.set(paramString3);
    paramString2.event_type.set(paramString4);
    paramString2.event_type2.set(paramString5);
    paramString2.event_type3.set(paramString6);
    paramString2.event_err_code.set(paramString8);
    paramString2.event_result.set(paramString7);
    paramString3 = new ExpeDataAcc.UserActionInfo();
    paramString3.app_info.set(localAppInfo);
    paramString3.account_info.set(paramString1);
    paramString3.expe_info.set(localExpeInfo);
    paramString3.event_info.set(paramString2);
    paramString1 = new ExpeDataAcc.ExpeEventReportReq();
    paramString1.noNeedRsp.set(1);
    paramString1.action_infos.add(paramString3);
    paramString1 = createTrpcInvokeReq("/v1/2", true, paramString1.toByteArray());
    paramString2 = new TrpcProxy.TrpcListReq();
    paramString2.list.add(paramString1);
    requestTrpc(paramString2, null);
  }
  
  public void requestTrpc(TrpcProxy.TrpcListReq paramTrpcListReq, Bundle paramBundle)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (QLog.isColorLevel()) {
      QLog.d("QQGameTrpcServiceImpl", 1, "requestTrpc trpcListReq=" + paramTrpcListReq + ",extra=" + paramBundle + ",appRuntime=" + localAppRuntime);
    }
    if ((localAppRuntime == null) || (paramTrpcListReq == null)) {
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
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
      QLog.e("QQGameTrpcServiceImpl", 1, "requestTrpc exception=", paramTrpcListReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameTrpcServiceImpl
 * JD-Core Version:    0.7.0.1
 */