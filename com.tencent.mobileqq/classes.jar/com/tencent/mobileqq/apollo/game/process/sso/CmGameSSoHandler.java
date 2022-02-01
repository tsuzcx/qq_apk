package com.tencent.mobileqq.apollo.game.process.sso;

import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameResUpdateInfo;
import com.tencent.mobileqq.apollo.game.process.download.CmGameRscSvrInfo;
import com.tencent.mobileqq.apollo.game.process.download.CmGameSubRscHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.apollo.STCommon.STCPatchUpdateInfoReq;
import com.tencent.pb.apollo.STCommon.STLocalCVerInfo;
import com.tencent.pb.apollo.STGameResUpdate.STCPatchUpdateInfoRsp;
import com.tencent.pb.apollo.STGameResUpdate.STSvrCVerInfo;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class CmGameSSoHandler
  extends BusinessHandler
{
  private AppInterface a;
  
  public CmGameSSoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleWebSSO]");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "");
      localJSONObject.put("data", new JSONObject());
      localJSONObject.put("errCode", -1);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()) && (paramIntent != null))
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSSoHandler", 2, new Object[] { "[handleWebSSO] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
        }
        localJSONObject.put("cmd", paramIntent.getStringExtra("cmd"));
        localJSONObject.put("errCode", paramFromServiceMsg.ret.get());
        paramIntent = paramFromServiceMsg.rspdata.get();
        if (!TextUtils.isEmpty(paramIntent)) {
          localJSONObject.put("data", new JSONObject(paramIntent));
        }
        if (paramFromServiceMsg.ret.get() == 0L)
        {
          notifyUI(3, true, localJSONObject);
          return;
        }
        notifyUI(3, false, localJSONObject);
        return;
      }
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleWebSSO] data null or rsp failed");
      notifyUI(3, false, localJSONObject);
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleWebSSO] exception=", paramIntent);
    }
  }
  
  public void a(int paramInt, String paramString, ArrayList<CmGameResUpdateInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, new Object[] { "[checkGameResUpdate], gameId:", Integer.valueOf(paramInt) });
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17.5770");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          CmGameResUpdateInfo localCmGameResUpdateInfo = (CmGameResUpdateInfo)paramArrayList.next();
          STCommon.STLocalCVerInfo localSTLocalCVerInfo = new STCommon.STLocalCVerInfo();
          localSTLocalCVerInfo.busId.set(localCmGameResUpdateInfo.a);
          localSTLocalCVerInfo.itemId.set(localCmGameResUpdateInfo.b);
          localSTLocalCVerInfo.localVer.set(localCmGameResUpdateInfo.c);
          ((ArrayList)localObject).add(localSTLocalCVerInfo);
        }
        paramArrayList = new STCommon.STCPatchUpdateInfoReq();
        paramArrayList.from.set("android");
        paramArrayList.list.set((List)localObject);
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(paramArrayList.toByteArray()));
        paramArrayList = new NewIntent(this.a.getApp(), CmGameServlet.class);
        paramArrayList.putExtra("gameid", paramInt);
        paramArrayList.putExtra("packname", paramString);
        paramArrayList.putExtra("cmd", "apollo_res_update.get_patch_update_info");
        paramArrayList.putExtra("data", localUniSsoServerReq.toByteArray());
        this.a.startServlet(paramArrayList);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameSSoHandler", 1, paramString, new Object[0]);
      }
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ("apollo_res_update.get_patch_update_info".equals(paramIntent.getStringExtra("cmd"))) {
      b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    if (paramIntent.getBooleanExtra("isCMShowJSRequest", false))
    {
      c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    if (paramIntent.getBooleanExtra("cs.ssoMessage.local", false)) {
      d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[doCmGameRequest], cmd:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",luaR:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", app: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("cmgame_process.CmGameSSoHandler", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("8.8.17.5770");
      localObject = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject).comm.set(localUniSsoServerReqComm);
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        ((WebSSOAgent.UniSsoServerReq)localObject).pbReqData.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      } else {
        ((WebSSOAgent.UniSsoServerReq)localObject).reqdata.set(paramString2);
      }
      paramArrayOfByte = new NewIntent(this.a.getApp(), CmGameServlet.class);
      paramArrayOfByte.putExtra("usrdata", paramLong);
      paramArrayOfByte.putExtra("cmd", paramString1);
      paramArrayOfByte.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject).toByteArray());
      paramArrayOfByte.putExtra("callFrom", paramInt);
      paramArrayOfByte.putExtra("isCMShowJSRequest", true);
      paramArrayOfByte.putExtra("reqData", paramString2);
      this.a.startServlet(paramArrayOfByte);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "doCMGameReq failed ", paramString1);
    }
  }
  
  public void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleGameReqUpdate]");
    }
    int i = paramIntent.getIntExtra("gameid", -1);
    paramIntent = paramIntent.getStringExtra("packname");
    Object localObject1 = CmGameUtil.a(i);
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((CmGameLauncher)localObject1).a();
    if (localObject1 == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom(paramArrayOfByte);
        if (!paramFromServiceMsg.isSuccess())
        {
          ((CmGameSubRscHandler)localObject1).d(paramFromServiceMsg.getResultCode(), paramIntent);
          return;
        }
        paramArrayOfByte = new STGameResUpdate.STCPatchUpdateInfoRsp();
        paramArrayOfByte.mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject2).pbRsqData.get().toByteArray());
        paramArrayOfByte = (STGameResUpdate.STSvrCVerInfo)paramArrayOfByte.list.get(0);
        if ((paramArrayOfByte.subCode.has()) && (paramArrayOfByte.subCode.get() != 0))
        {
          ((CmGameSubRscHandler)localObject1).d(paramArrayOfByte.subCode.get(), paramIntent);
          return;
        }
        localObject2 = new CmGameRscSvrInfo();
        if (paramArrayOfByte.updateFlag.get() == 1)
        {
          bool = true;
          ((CmGameRscSvrInfo)localObject2).a = bool;
          if (paramArrayOfByte.isPatch.get() != 1) {
            break label375;
          }
          bool = true;
          ((CmGameRscSvrInfo)localObject2).b = bool;
          ((CmGameRscSvrInfo)localObject2).c = paramArrayOfByte.svrVer.get();
          ((CmGameRscSvrInfo)localObject2).g = i;
          ((CmGameRscSvrInfo)localObject2).k = paramArrayOfByte.url.get();
          ((CmGameRscSvrInfo)localObject2).j = paramArrayOfByte.md5.get();
          ((CmGameRscSvrInfo)localObject2).f = paramArrayOfByte.patchContent.get().toByteArray();
          ((CmGameRscSvrInfo)localObject2).l = paramArrayOfByte.patchUrl.get();
          ((CmGameRscSvrInfo)localObject2).e = paramArrayOfByte.packageSize.get();
          ((CmGameRscSvrInfo)localObject2).d = paramArrayOfByte.tipsSize.get();
          ((CmGameRscSvrInfo)localObject2).h = paramArrayOfByte.itemId.get();
          ((CmGameRscSvrInfo)localObject2).i = paramIntent;
          ((CmGameRscSvrInfo)localObject2).o = 1;
          ((CmGameSubRscHandler)localObject1).a((CmGameRscSvrInfo)localObject2);
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        QLog.e("cmgame_process.CmGameSSoHandler", 1, paramArrayOfByte, new Object[0]);
        ((CmGameSubRscHandler)localObject1).d(paramFromServiceMsg.getResultCode(), paramIntent);
        return;
      }
      boolean bool = false;
      continue;
      label375:
      bool = false;
    }
  }
  
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleCMGameResp]");
    }
    int i;
    long l;
    try
    {
      i = paramIntent.getIntExtra("callFrom", 0);
      l = paramIntent.getLongExtra("usrdata", 0L);
      String str = paramIntent.getStringExtra("cmd");
      if (paramFromServiceMsg.isSuccess())
      {
        int j = new JSONObject(paramIntent.getStringExtra("reqData")).optInt("seqId");
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
        localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new JSONObject(localUniSsoServerRsp.rspdata.get());
        paramArrayOfByte.put("seqId", j);
        localObject = paramArrayOfByte.toString();
        paramArrayOfByte = (byte[])localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramArrayOfByte = "{}";
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ret:");
          ((StringBuilder)localObject).append(localUniSsoServerRsp.ret.get());
          ((StringBuilder)localObject).append(",cmd:");
          ((StringBuilder)localObject).append(str);
          QLog.d("cmgame_process.CmGameSSoHandler", 2, ((StringBuilder)localObject).toString());
        }
        if (i == 4) {
          ApolloCmdChannel.getInstance().callbackFromRequest(l, (int)localUniSsoServerRsp.ret.get(), str, paramArrayOfByte);
        }
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("resp data is err, errorCode:");
        paramArrayOfByte.append(paramFromServiceMsg.getResultCode());
        QLog.w("cmgame_process.CmGameSSoHandler", 1, paramArrayOfByte.toString());
        if (i == 4)
        {
          ApolloCmdChannel.getInstance().callbackFromRequest(l, paramFromServiceMsg.getResultCode(), str, "{}");
          return;
        }
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("th:");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.e("cmgame_process.CmGameSSoHandler", 1, ((StringBuilder)localObject).toString());
    }
    label406:
    try
    {
      i = paramIntent.getIntExtra("callFrom", 0);
      l = paramIntent.getLongExtra("usrdata", 0L);
      paramIntent = paramIntent.getStringExtra("cmd");
      if (i != 4) {
        break label406;
      }
      ApolloCmdChannel.getInstance().callbackFromRequest(l, paramFromServiceMsg.getResultCode(), paramIntent, "{}");
      return;
    }
    catch (Throwable paramIntent)
    {
      label374:
      break label374;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("th2:");
    paramIntent.append(paramArrayOfByte);
    QLog.e("cmgame_process.CmGameSSoHandler", 1, paramIntent.toString());
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler
 * JD-Core Version:    0.7.0.1
 */