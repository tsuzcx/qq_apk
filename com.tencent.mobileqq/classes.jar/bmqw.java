import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.trpcAttaProxy.TrpcAttaProxy.AttaItem;
import com.tencent.trpcprotocol.gamecenter.trpcAttaProxy.TrpcAttaProxy.AttaValue;
import com.tencent.trpcprotocol.gamecenter.trpcAttaProxy.TrpcAttaProxy.ReportAttaListReq;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.ExpeDataAcc.AccountInfo;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.ExpeDataAcc.AppInfo;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.ExpeDataAcc.EventInfo;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.ExpeDataAcc.ExpeEventReportReq;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.ExpeDataAcc.ExpeInfo;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.ExpeDataAcc.UserActionInfo;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcInovkeReq;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcInovkeRsp;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcListReq;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcListRsp;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcMetaData;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcMsg;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcOptions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class bmqw
{
  private static volatile bmqw jdField_a_of_type_Bmqw;
  public static String a;
  static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static String b;
  private CopyOnWriteArrayList<WeakReference<bmqv>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlTrpcUtil";
  }
  
  public static bmqw a()
  {
    if (jdField_a_of_type_Bmqw == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bmqw == null) {
        jdField_a_of_type_Bmqw = new bmqw();
      }
      return jdField_a_of_type_Bmqw;
    }
  }
  
  private TrpcAttaProxy.AttaValue a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "createAttaValue key=" + paramString1 + ",value is null");
      }
      str = "";
    }
    paramString2 = new TrpcAttaProxy.AttaValue();
    paramString2.key.set(paramString1);
    paramString2.value.set(str);
    return paramString2;
  }
  
  private void a(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listeners size=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      bmqv localbmqv = (bmqv)((WeakReference)localObject).get();
      if (localbmqv != null)
      {
        localObject = localbmqv.a();
        if ((localObject == null) || (((HashSet)localObject).contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listener=" + localbmqv);
          }
          localbmqv.a(paramIntent, paramString, paramLong, paramTrpcInovkeRsp);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
      }
    }
  }
  
  public TrpcProxy.TrpcInovkeReq a(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "createTrpcInvokeReq cmdId=" + paramString + ",sendOnly=" + paramBoolean + ",data=" + paramArrayOfByte);
    }
    TrpcProxy.TrpcMsg localTrpcMsg = new TrpcProxy.TrpcMsg();
    localTrpcMsg.clientRPCName.set(paramString);
    paramString = new TrpcProxy.TrpcOptions();
    paramString.nameSpace.set("Production");
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
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destroy trpcListeners=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte)
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
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("onRespTrpcSso cmdArray=").append(localObject2).append("sSucc=").append(paramBoolean).append(",ret=").append(l1).append(",rspList size=");
        if (paramArrayOfByte == null) {
          break label432;
        }
        localObject1 = Integer.valueOf(paramArrayOfByte.size());
        QLog.d(str, 2, localObject1);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() != localObject2.length)) {
          break label440;
        }
        i = 1;
        int j = 0;
        if (j >= localObject2.length) {
          break;
        }
        str = localObject2[j];
        localObject1 = null;
        if (i != 0)
        {
          localObject1 = (TrpcProxy.TrpcInovkeRsp)paramArrayOfByte.get(j);
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onRespTrpcSso on TRPC, cmd=" + str + ",rsp=[ret=" + ((TrpcProxy.TrpcInovkeRsp)localObject1).ret.get() + ",msg=" + ((TrpcProxy.TrpcInovkeRsp)localObject1).msg.get() + "]");
        }
        if (localObject1 == null) {
          break label446;
        }
        k = ((TrpcProxy.TrpcInovkeRsp)localObject1).ret.get();
        a(paramIntent, str, k, (TrpcProxy.TrpcInovkeRsp)localObject1);
        j += 1;
        continue;
        paramArrayOfByte = null;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "onRespTrpcSso err:" + paramArrayOfByte.getMessage());
      }
      continue;
      label432:
      localObject1 = "is null";
      continue;
      label440:
      int i = 0;
      continue;
      label446:
      int k = -1;
    }
  }
  
  public void a(bmqv parambmqv)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "addListener listener=" + parambmqv);
    }
    if (parambmqv == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      bmqv localbmqv = (bmqv)((WeakReference)localIterator.next()).get();
      if ((localbmqv != null) && (localbmqv == parambmqv)) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "addListener listener=" + parambmqv + " succ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(parambmqv));
  }
  
  public void a(TrpcProxy.TrpcListReq paramTrpcListReq, Bundle paramBundle)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "requestTrpc trpcListReq=" + paramTrpcListReq + ",extra=" + paramBundle + ",appRuntime=" + localAppRuntime);
    }
    if ((localAppRuntime == null) || (paramTrpcListReq == null)) {
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(paramTrpcListReq.toByteArray()));
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), bmqr.class);
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
      QLog.e(jdField_a_of_type_JavaLangString, 1, "requestTrpc exception=", paramTrpcListReq);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "reportTianJi appId=" + paramString1 + ",eventId=" + paramString3 + ",eventType=" + paramString4 + ",eventType2=" + paramString5 + ",eventType3=" + paramString6 + ",eventResult=" + paramString7 + ",eventErrCode=" + paramString8 + ",expeSysTransfer=" + paramString2);
    }
    ExpeDataAcc.AppInfo localAppInfo = new ExpeDataAcc.AppInfo();
    localAppInfo.appid.set(paramString1);
    paramString1 = new ExpeDataAcc.AccountInfo();
    paramString1.account_type.set(1L);
    paramString1.uid.set(String.valueOf(bmqt.a()));
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
    paramString1 = a("/v1/2", true, paramString1.toByteArray());
    paramString2 = new TrpcProxy.TrpcListReq();
    paramString2.list.add(paramString1);
    a(paramString2, null);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "reportAtta reportData=" + paramJSONObject);
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("report_list"))) {
      return;
    }
    if (TextUtils.isEmpty(b)) {
      b = String.valueOf(DeviceInfoUtil.getCarrier());
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
          break label147;
        }
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "reportAtta data is null");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label147:
        TrpcAttaProxy.AttaItem localAttaItem = new TrpcAttaProxy.AttaItem();
        localAttaItem.attaId.set(((JSONObject)localObject2).optString("dc_id"));
        localAttaItem.valueList.add(a("uin", String.valueOf(bmqt.a())));
        long l = NetConnInfoCenter.getServerTime();
        localAttaItem.valueList.add(a("itimestamp", String.valueOf(l)));
        localAttaItem.valueList.add(a("domain", "1"));
        localAttaItem.valueList.add(a("sq_ver", "8.4.10"));
        localAttaItem.valueList.add(a("gamecenter_ver", ""));
        localAttaItem.valueList.add(a("gamecenter_ver_type", "2"));
        localAttaItem.valueList.add(a("device_type", Build.BRAND));
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
        localAttaItem.valueList.add(a("net_type", AppConstants.NET_TYPE_NAME[j]));
        localAttaItem.valueList.add(a("resolution", bmqt.a(null)));
        localAttaItem.valueList.add(a("is_red_point", "0"));
        localAttaItem.valueList.add(a("is_new_status", "0"));
        localAttaItem.valueList.add(a("gamecenter_src", "1"));
        localAttaItem.valueList.add(a("ret_id", String.valueOf(localJSONObject.optInt("ret_id", 0))));
        localObject2 = localJSONObject.optString("oper_moudle");
        String str1 = localJSONObject.optString("oper_id");
        String str2 = localJSONObject.optString("gameappid");
        String str3 = localJSONObject.optString("tianji_report_str");
        String str4 = localJSONObject.optString("apk_volume");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localAttaItem.valueList.add(a("oper_moudle", (String)localObject2));
        }
        if (!TextUtils.isEmpty(str1)) {
          localAttaItem.valueList.add(a("oper_id", str1));
        }
        if (!TextUtils.isEmpty(str2)) {
          localAttaItem.valueList.add(a("gameappid", str2));
        }
        if (!TextUtils.isEmpty(str3)) {
          localAttaItem.valueList.add(a("tianji_report_str", str3));
        }
        if (!TextUtils.isEmpty(str4)) {
          localAttaItem.valueList.add(a("apk_volume", str4));
        }
        int j = 1;
        while (j <= bmqu.a)
        {
          localObject2 = "ext" + j;
          if (localJSONObject.has((String)localObject2)) {
            localAttaItem.valueList.add(a((String)localObject2, localJSONObject.optString((String)localObject2)));
          }
          j += 1;
        }
        ((TrpcAttaProxy.ReportAttaListReq)localObject1).attaList.add(localAttaItem);
      }
    }
    paramJSONObject = a("/v1/11", true, ((TrpcAttaProxy.ReportAttaListReq)localObject1).toByteArray());
    localObject1 = new TrpcProxy.TrpcListReq();
    ((TrpcProxy.TrpcListReq)localObject1).list.add(paramJSONObject);
    a((TrpcProxy.TrpcListReq)localObject1, null);
  }
  
  public void b(bmqv parambmqv)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "removeListener listener=" + parambmqv);
    }
    if (parambmqv == null) {
      return;
    }
    boolean bool;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      } while (!localIterator.hasNext());
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      bmqv localbmqv = (bmqv)localWeakReference.get();
      if ((localbmqv == null) || (localbmqv != parambmqv)) {
        break;
      }
      bool = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 1, "removeListener listener=" + parambmqv + " " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqw
 * JD-Core Version:    0.7.0.1
 */