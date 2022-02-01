import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
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
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcMsg;
import com.tencent.trpcprotocol.gamecenter.trpcproxy.TrpcProxy.TrpcOptions;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class blef
{
  private static volatile blef jdField_a_of_type_Blef;
  public static String a;
  static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private CopyOnWriteArrayList<WeakReference<blee>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlTrpcUtil";
  }
  
  public static blef a()
  {
    if (jdField_a_of_type_Blef == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Blef == null) {
        jdField_a_of_type_Blef = new blef();
      }
      return jdField_a_of_type_Blef;
    }
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
      blee localblee = (blee)((WeakReference)localObject).get();
      if (localblee != null)
      {
        localObject = localblee.a();
        if ((localObject == null) || (((HashSet)localObject).contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listener=" + localblee);
          }
          localblee.a(paramIntent, paramString, paramLong, paramTrpcInovkeRsp);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
      }
    }
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
          break label423;
        }
        localObject1 = Integer.valueOf(paramArrayOfByte.size());
        QLog.d(str, 2, localObject1);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() != localObject2.length)) {
          break label430;
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
          break label436;
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
      label423:
      localObject1 = "is null";
      continue;
      label430:
      int i = 0;
      continue;
      label436:
      int k = -1;
    }
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.8.4810");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(paramTrpcListReq.toByteArray()));
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), blea.class);
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
    paramString1.uid.set(String.valueOf(blec.a()));
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
    paramString3 = new TrpcProxy.TrpcMsg();
    paramString3.clientRPCName.set("/v1/2");
    paramString4 = new TrpcProxy.TrpcOptions();
    paramString4.nameSpace.set("Production");
    paramString4.currentSerializationType.set(4);
    paramString4.serializationType.set(0);
    paramString4.requestType.set(1);
    paramString2 = new TrpcProxy.TrpcInovkeReq();
    paramString2.msg.set(paramString3);
    paramString2.data.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
    paramString2.options.set(paramString4);
    paramString1 = new TrpcProxy.TrpcListReq();
    paramString1.list.add(paramString2);
    a(paramString1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blef
 * JD-Core Version:    0.7.0.1
 */