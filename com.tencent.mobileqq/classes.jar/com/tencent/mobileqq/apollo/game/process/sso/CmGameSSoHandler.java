package com.tencent.mobileqq.apollo.game.process.sso;

import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.game.process.data.CmGameOpenIdFinder;
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
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoReq;
import com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoRsp;
import com.tencent.pb.apollo.GetTinyID.STUserAccInfo;
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
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.RspBody;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamRsp;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoRsp;
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent;
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
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0.5295");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          CmGameResUpdateInfo localCmGameResUpdateInfo = (CmGameResUpdateInfo)paramArrayList.next();
          STCommon.STLocalCVerInfo localSTLocalCVerInfo = new STCommon.STLocalCVerInfo();
          localSTLocalCVerInfo.busId.set(localCmGameResUpdateInfo.jdField_a_of_type_Int);
          localSTLocalCVerInfo.itemId.set(localCmGameResUpdateInfo.jdField_a_of_type_JavaLangString);
          localSTLocalCVerInfo.localVer.set(localCmGameResUpdateInfo.jdField_b_of_type_Int);
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
    String str = paramIntent.getStringExtra("cmd");
    if ("apollo_game_av.join_av_room".equals(str)) {
      a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
    } else if ("apollo_game_av.get_av_ctrl_param".equals(str)) {
      a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
    } else if ("apollo_game_av.get_usraccinfo".equals(str)) {
      a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
    } else if ("apollo_res_update.get_patch_update_info".equals(str)) {
      b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    } else if ("ltgame_native_api.batch_get_user_info".equals(str)) {
      c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    } else if (("QQVacCommSvc.report_channel".equals(str)) && (QLog.isColorLevel())) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "game channel report");
    }
    if (paramIntent.getBooleanExtra("isCMShowJSRequest", false))
    {
      d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    if (paramIntent.getBooleanExtra("cs.ssoMessage.local", false)) {
      e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
  }
  
  void a(String paramString, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool = "apollo_game_av.join_av_room".equals(paramString);
    int i = 0;
    long l;
    if (bool)
    {
      l = paramIntent.getLongExtra("usrdata", 0L);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
      {
        paramString = new WebSSOAgent.UniSsoServerRsp();
        paramIntent = new qqavopensdkSsoTunnel.STAudioVideoRsp();
        try
        {
          paramString.mergeFrom(paramArrayOfByte);
          paramIntent.mergeFrom(paramString.pbRsqData.get().toByteArray());
          paramString = ((qqavopensdkSsoTunnel.RspBody)((qqavopensdkSsoTunnel.STAudioVideoRsp)paramIntent.get()).rspbody.get()).bytes_rspbody.get().toByteArray();
          SSOTunnelEvent.a().a(l, true, paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "handleRoomSSOInfoCallback error:", paramString);
          return;
        }
      }
      SSOTunnelEvent.a().a(l, false, null);
      return;
    }
    if ("apollo_game_av.get_av_ctrl_param".equals(paramString))
    {
      l = paramIntent.getLongExtra("usrdata", 0L);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
      {
        paramString = new WebSSOAgent.UniSsoServerRsp();
        paramIntent = new qqavopensdkSsoTunnel.STAVCtrlParamRsp();
        try
        {
          paramString.mergeFrom(paramArrayOfByte);
          paramIntent.mergeFrom(paramString.pbRsqData.get().toByteArray());
          paramString = ((qqavopensdkSsoTunnel.STAVCtrlParamRsp)paramIntent.get()).ctrlParam.get().toByteArray();
          SSOTunnelEvent.a().a(l, true, paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "handleRoomSSOInfoCallback error:", paramString);
          return;
        }
      }
      SSOTunnelEvent.a().a(l, false, null);
      return;
    }
    if (("apollo_game_av.get_usraccinfo".equals(paramString)) && (paramArrayOfByte != null))
    {
      if (!paramFromServiceMsg.isSuccess()) {
        return;
      }
      paramString = new GetTinyID.STTinyID2UserAccInfoRsp();
      paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
      try
      {
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        paramString.mergeFrom(paramFromServiceMsg.pbRsqData.get().toByteArray());
        paramArrayOfByte = ((GetTinyID.STTinyID2UserAccInfoRsp)paramString.get()).user_acc_info.get();
        if (paramArrayOfByte != null)
        {
          if (paramArrayOfByte.size() <= 0) {
            return;
          }
          paramString = new ArrayList(paramArrayOfByte.size());
          paramFromServiceMsg = new ArrayList(paramArrayOfByte.size());
          while (i < paramArrayOfByte.size())
          {
            paramString.add(Long.valueOf(((GetTinyID.STUserAccInfo)paramArrayOfByte.get(i)).tinyid.get()));
            paramFromServiceMsg.add(((GetTinyID.STUserAccInfo)paramArrayOfByte.get(i)).identifier.get());
            i += 1;
          }
          i = paramIntent.getIntExtra("eventId", -1);
          l = paramIntent.getLongExtra("lState", -1L);
          paramIntent = CmGameUtil.a(paramIntent.getIntExtra("gameId", -1));
          if (paramIntent != null) {
            paramIntent.a(paramString, paramFromServiceMsg, i, l);
          }
        }
        else {}
      }
      catch (Exception paramString)
      {
        QLog.e("cmgame_process.CmGameSSoHandler", 1, "handleRoomSSOInfoCallback error:", paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[doCmGameRequest], cmd:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",reqData:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", app: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("cmgame_process.CmGameSSoHandler", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("8.7.0.5295");
      localObject = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject).comm.set(localUniSsoServerReqComm);
      ((WebSSOAgent.UniSsoServerReq)localObject).reqdata.set(paramString2);
      paramString2 = new NewIntent(this.a.getApp(), CmGameServlet.class);
      paramString2.putExtra("cmd", paramString1);
      paramString2.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject).toByteArray());
      paramString2.putExtra("callFrom", "web");
      paramString2.putExtra("cs.ssoMessage.local", true);
      this.a.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "doCMGameReq failed ", paramString1);
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
      localUniSsoServerReqComm.mqqver.set("8.7.0.5295");
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
  
  public void a(ArrayList<Long> paramArrayList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[doCMGameReq]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0.5295");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new GetTinyID.STTinyID2UserAccInfoReq();
      ((GetTinyID.STTinyID2UserAccInfoReq)localObject).tinyids.set(paramArrayList);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((GetTinyID.STTinyID2UserAccInfoReq)localObject).toByteArray()));
      paramArrayList = new NewIntent(this.a.getApp(), CmGameServlet.class);
      paramArrayList.putExtra("usrdata", -1);
      paramArrayList.putExtra("cmd", "apollo_game_av.get_usraccinfo");
      paramArrayList.putExtra("data", localUniSsoServerReq.toByteArray());
      paramArrayList.putExtra("eventId", paramInt1);
      paramArrayList.putExtra("lState", paramLong);
      paramArrayList.putExtra("gameId", paramInt2);
      this.a.startServlet(paramArrayList);
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "doCMGameReq failed ", paramArrayList);
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
          ((CmGameSubRscHandler)localObject1).c(paramFromServiceMsg.getResultCode(), paramIntent);
          return;
        }
        paramArrayOfByte = new STGameResUpdate.STCPatchUpdateInfoRsp();
        paramArrayOfByte.mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject2).pbRsqData.get().toByteArray());
        paramArrayOfByte = (STGameResUpdate.STSvrCVerInfo)paramArrayOfByte.list.get(0);
        if ((paramArrayOfByte.subCode.has()) && (paramArrayOfByte.subCode.get() != 0))
        {
          ((CmGameSubRscHandler)localObject1).c(paramArrayOfByte.subCode.get(), paramIntent);
          return;
        }
        localObject2 = new CmGameRscSvrInfo();
        if (paramArrayOfByte.updateFlag.get() == 1)
        {
          bool = true;
          ((CmGameRscSvrInfo)localObject2).jdField_a_of_type_Boolean = bool;
          if (paramArrayOfByte.isPatch.get() != 1) {
            break label375;
          }
          bool = true;
          ((CmGameRscSvrInfo)localObject2).jdField_b_of_type_Boolean = bool;
          ((CmGameRscSvrInfo)localObject2).jdField_a_of_type_Int = paramArrayOfByte.svrVer.get();
          ((CmGameRscSvrInfo)localObject2).jdField_b_of_type_Int = i;
          ((CmGameRscSvrInfo)localObject2).jdField_d_of_type_JavaLangString = paramArrayOfByte.url.get();
          ((CmGameRscSvrInfo)localObject2).c = paramArrayOfByte.md5.get();
          ((CmGameRscSvrInfo)localObject2).jdField_a_of_type_ArrayOfByte = paramArrayOfByte.patchContent.get().toByteArray();
          ((CmGameRscSvrInfo)localObject2).e = paramArrayOfByte.patchUrl.get();
          ((CmGameRscSvrInfo)localObject2).jdField_b_of_type_Long = paramArrayOfByte.packageSize.get();
          ((CmGameRscSvrInfo)localObject2).jdField_a_of_type_Long = paramArrayOfByte.tipsSize.get();
          ((CmGameRscSvrInfo)localObject2).jdField_a_of_type_JavaLangString = paramArrayOfByte.itemId.get();
          ((CmGameRscSvrInfo)localObject2).jdField_b_of_type_JavaLangString = paramIntent;
          ((CmGameRscSvrInfo)localObject2).jdField_d_of_type_Int = 1;
          ((CmGameSubRscHandler)localObject1).a((CmGameRscSvrInfo)localObject2);
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        QLog.e("cmgame_process.CmGameSSoHandler", 1, paramArrayOfByte, new Object[0]);
        ((CmGameSubRscHandler)localObject1).c(paramFromServiceMsg.getResultCode(), paramIntent);
        return;
      }
      boolean bool = false;
      continue;
      label375:
      bool = false;
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 25
    //   8: iconst_2
    //   9: ldc_w 602
    //   12: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: invokestatic 608	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getInstance	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel;
    //   18: astore 12
    //   20: aload_1
    //   21: ldc_w 464
    //   24: iconst_0
    //   25: invokevirtual 423	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   28: istore 4
    //   30: aload_1
    //   31: ldc_w 340
    //   34: lconst_0
    //   35: invokevirtual 344	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   38: lstore 6
    //   40: aload_1
    //   41: ldc_w 610
    //   44: invokevirtual 92	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 10
    //   49: aload_1
    //   50: ldc 38
    //   52: invokevirtual 92	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore 11
    //   57: aload_2
    //   58: invokevirtual 56	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   61: ifeq +307 -> 368
    //   64: new 58	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   67: dup
    //   68: invokespecial 59	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   71: astore 13
    //   73: aload 13
    //   75: aload_3
    //   76: invokevirtual 63	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   79: pop
    //   80: new 33	org/json/JSONObject
    //   83: dup
    //   84: aload 13
    //   86: getfield 99	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:rspdata	Lcom/tencent/mobileqq/pb/PBStringField;
    //   89: invokevirtual 104	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   92: invokespecial 113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   95: invokevirtual 611	org/json/JSONObject:toString	()Ljava/lang/String;
    //   98: astore_2
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifeq +7 -> 112
    //   108: ldc_w 613
    //   111: astore_1
    //   112: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +837 -> 952
    //   118: new 442	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   125: astore_2
    //   126: aload_2
    //   127: ldc_w 615
    //   130: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 13
    //   136: getfield 71	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   139: astore_3
    //   140: aload_2
    //   141: aload_3
    //   142: invokevirtual 77	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   145: invokevirtual 477	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: ldc_w 617
    //   153: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_2
    //   158: aload 11
    //   160: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 25
    //   166: iconst_2
    //   167: aload_2
    //   168: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: goto +3 -> 177
    //   177: new 33	org/json/JSONObject
    //   180: dup
    //   181: aload_1
    //   182: invokespecial 113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   185: ldc_w 619
    //   188: invokevirtual 623	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   191: astore_2
    //   192: new 625	org/json/JSONArray
    //   195: dup
    //   196: invokespecial 626	org/json/JSONArray:<init>	()V
    //   199: astore_1
    //   200: aload_2
    //   201: ifnull +750 -> 951
    //   204: iconst_0
    //   205: istore 5
    //   207: iload 5
    //   209: aload_2
    //   210: invokevirtual 629	org/json/JSONArray:length	()I
    //   213: if_icmpge +113 -> 326
    //   216: aload_2
    //   217: iload 5
    //   219: invokevirtual 633	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   222: astore_3
    //   223: aload_3
    //   224: ifnull +731 -> 955
    //   227: aload_3
    //   228: ldc_w 635
    //   231: invokevirtual 638	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore 11
    //   236: aload_3
    //   237: ldc_w 640
    //   240: invokevirtual 638	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   243: astore 13
    //   245: aload 12
    //   247: new 642	com/tencent/mobileqq/apollo/game/ranklist/CmGameUserInfo
    //   250: dup
    //   251: aload_3
    //   252: ldc_w 644
    //   255: invokevirtual 638	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   258: aload 13
    //   260: aload 11
    //   262: invokespecial 647	com/tencent/mobileqq/apollo/game/ranklist/CmGameUserInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   265: invokevirtual 651	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:updateUserInfo	(Lcom/tencent/mobileqq/apollo/game/ranklist/CmGameUserInfo;)V
    //   268: iload 4
    //   270: getstatic 654	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:jdField_a_of_type_Int	I
    //   273: if_icmpne +15 -> 288
    //   276: aload 12
    //   278: lload 6
    //   280: aload 11
    //   282: invokevirtual 658	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getOpenApiHead	(JLjava/lang/String;)V
    //   285: goto +670 -> 955
    //   288: iload 4
    //   290: getstatic 659	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:jdField_b_of_type_Int	I
    //   293: if_icmpne +15 -> 308
    //   296: aload 12
    //   298: lload 6
    //   300: aload 11
    //   302: invokevirtual 662	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getOpenApiNick	(JLjava/lang/String;)V
    //   305: goto +650 -> 955
    //   308: iload 4
    //   310: getstatic 664	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:c	I
    //   313: if_icmpne +642 -> 955
    //   316: aload_1
    //   317: aload 11
    //   319: invokevirtual 667	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   322: pop
    //   323: goto +632 -> 955
    //   326: iload 4
    //   328: getstatic 664	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:c	I
    //   331: if_icmpne +620 -> 951
    //   334: new 33	org/json/JSONObject
    //   337: dup
    //   338: invokespecial 36	org/json/JSONObject:<init>	()V
    //   341: astore_2
    //   342: aload_2
    //   343: ldc_w 610
    //   346: aload_1
    //   347: invokevirtual 44	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   350: pop
    //   351: invokestatic 608	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getInstance	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel;
    //   354: lload 6
    //   356: iconst_0
    //   357: ldc_w 669
    //   360: aload_2
    //   361: invokevirtual 611	org/json/JSONObject:toString	()Ljava/lang/String;
    //   364: invokevirtual 673	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:callbackFromRequest	(JILjava/lang/String;Ljava/lang/String;)V
    //   367: return
    //   368: ldc_w 675
    //   371: astore_3
    //   372: ldc_w 677
    //   375: astore 11
    //   377: getstatic 654	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:jdField_a_of_type_Int	I
    //   380: istore 5
    //   382: iload 4
    //   384: iload 5
    //   386: if_icmpne +82 -> 468
    //   389: new 33	org/json/JSONObject
    //   392: dup
    //   393: aload 10
    //   395: invokespecial 113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   398: ldc_w 679
    //   401: invokevirtual 623	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   404: astore_1
    //   405: aload_1
    //   406: iconst_0
    //   407: invokevirtual 683	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   410: astore 13
    //   412: aload_2
    //   413: invokevirtual 510	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   416: istore 5
    //   418: aload 12
    //   420: lload 6
    //   422: aload 13
    //   424: iload 5
    //   426: iconst_0
    //   427: iconst_0
    //   428: aconst_null
    //   429: invokevirtual 687	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:nativeOpenApiGetHeadCallBack	(JLjava/lang/String;III[B)V
    //   432: new 442	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   439: astore_2
    //   440: aload_2
    //   441: aload 11
    //   443: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload_2
    //   448: aload_1
    //   449: iconst_0
    //   450: invokevirtual 683	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   453: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: ldc 25
    //   459: iconst_1
    //   460: aload_2
    //   461: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: return
    //   468: aload 10
    //   470: astore_1
    //   471: lload 6
    //   473: lstore 8
    //   475: iload 4
    //   477: istore 5
    //   479: iload 5
    //   481: getstatic 659	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:jdField_b_of_type_Int	I
    //   484: if_icmpne +70 -> 554
    //   487: new 33	org/json/JSONObject
    //   490: dup
    //   491: aload_1
    //   492: invokespecial 113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   495: ldc_w 679
    //   498: invokevirtual 623	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   501: astore_1
    //   502: aload 12
    //   504: lload 8
    //   506: aload_1
    //   507: iconst_0
    //   508: invokevirtual 683	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   511: aload_2
    //   512: invokevirtual 510	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   515: aconst_null
    //   516: invokevirtual 691	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:nativeOpenApiGetNickCallBack	(JLjava/lang/String;ILjava/lang/String;)V
    //   519: new 442	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   526: astore_2
    //   527: aload_2
    //   528: aload_3
    //   529: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload_2
    //   534: aload_1
    //   535: iconst_0
    //   536: invokevirtual 683	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   539: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: ldc 25
    //   545: iconst_1
    //   546: aload_2
    //   547: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: return
    //   554: iload 5
    //   556: getstatic 664	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:c	I
    //   559: if_icmpne +392 -> 951
    //   562: new 33	org/json/JSONObject
    //   565: dup
    //   566: invokespecial 36	org/json/JSONObject:<init>	()V
    //   569: astore_1
    //   570: aload_1
    //   571: ldc_w 693
    //   574: ldc_w 695
    //   577: invokevirtual 44	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   580: pop
    //   581: aload_1
    //   582: ldc_w 697
    //   585: aload_2
    //   586: invokevirtual 510	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   589: invokevirtual 51	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   592: pop
    //   593: invokestatic 608	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getInstance	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel;
    //   596: lload 8
    //   598: aload_2
    //   599: invokevirtual 510	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   602: ldc_w 669
    //   605: aload_1
    //   606: invokevirtual 611	org/json/JSONObject:toString	()Ljava/lang/String;
    //   609: invokevirtual 673	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:callbackFromRequest	(JILjava/lang/String;Ljava/lang/String;)V
    //   612: ldc 25
    //   614: iconst_1
    //   615: ldc_w 699
    //   618: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   621: return
    //   622: aload 10
    //   624: astore_3
    //   625: ldc_w 675
    //   628: astore_2
    //   629: astore_1
    //   630: aload 11
    //   632: astore 10
    //   634: goto +58 -> 692
    //   637: astore_1
    //   638: ldc_w 677
    //   641: astore 11
    //   643: aload_3
    //   644: astore_2
    //   645: aload 10
    //   647: astore_3
    //   648: aload 11
    //   650: astore 10
    //   652: goto +40 -> 692
    //   655: astore_1
    //   656: ldc_w 675
    //   659: astore_2
    //   660: ldc_w 677
    //   663: astore 11
    //   665: aload 10
    //   667: astore_3
    //   668: aload 11
    //   670: astore 10
    //   672: goto +20 -> 692
    //   675: astore_1
    //   676: ldc_w 677
    //   679: astore 11
    //   681: ldc_w 675
    //   684: astore_2
    //   685: aload 10
    //   687: astore_3
    //   688: aload 11
    //   690: astore 10
    //   692: iload 4
    //   694: getstatic 654	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:jdField_a_of_type_Int	I
    //   697: if_icmpne +72 -> 769
    //   700: new 33	org/json/JSONObject
    //   703: dup
    //   704: aload_3
    //   705: invokespecial 113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   708: ldc_w 679
    //   711: invokevirtual 623	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   714: astore_2
    //   715: aload 12
    //   717: lload 6
    //   719: aload_2
    //   720: iconst_0
    //   721: invokevirtual 683	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   724: iconst_m1
    //   725: iconst_0
    //   726: iconst_0
    //   727: aconst_null
    //   728: invokevirtual 687	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:nativeOpenApiGetHeadCallBack	(JLjava/lang/String;III[B)V
    //   731: new 442	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   738: astore_3
    //   739: aload_3
    //   740: aload 10
    //   742: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload_3
    //   747: aload_2
    //   748: iconst_0
    //   749: invokevirtual 683	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   752: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: ldc 25
    //   758: iconst_1
    //   759: aload_3
    //   760: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   763: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   766: goto +113 -> 879
    //   769: iload 4
    //   771: getstatic 659	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:jdField_b_of_type_Int	I
    //   774: if_icmpne +73 -> 847
    //   777: new 33	org/json/JSONObject
    //   780: dup
    //   781: aload_3
    //   782: invokespecial 113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   785: ldc_w 679
    //   788: invokevirtual 623	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   791: astore_3
    //   792: aload 12
    //   794: lload 6
    //   796: aload_3
    //   797: iconst_0
    //   798: invokevirtual 683	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   801: iconst_m1
    //   802: aconst_null
    //   803: invokevirtual 691	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:nativeOpenApiGetNickCallBack	(JLjava/lang/String;ILjava/lang/String;)V
    //   806: new 442	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   813: astore 10
    //   815: aload 10
    //   817: aload_2
    //   818: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: aload 10
    //   824: aload_3
    //   825: iconst_0
    //   826: invokevirtual 683	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   829: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: ldc 25
    //   835: iconst_1
    //   836: aload 10
    //   838: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   844: goto +35 -> 879
    //   847: iload 4
    //   849: getstatic 664	com/tencent/mobileqq/apollo/game/process/chanel/CmGameSubProcessHandler:c	I
    //   852: if_icmpne +27 -> 879
    //   855: invokestatic 608	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getInstance	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel;
    //   858: lload 6
    //   860: iconst_m1
    //   861: ldc_w 669
    //   864: ldc_w 613
    //   867: invokevirtual 673	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:callbackFromRequest	(JILjava/lang/String;Ljava/lang/String;)V
    //   870: ldc 25
    //   872: iconst_1
    //   873: ldc_w 699
    //   876: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   879: new 442	java/lang/StringBuilder
    //   882: dup
    //   883: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   886: astore_2
    //   887: aload_2
    //   888: ldc_w 701
    //   891: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload_2
    //   896: aload_1
    //   897: invokevirtual 702	java/lang/Exception:toString	()Ljava/lang/String;
    //   900: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: ldc 25
    //   906: iconst_1
    //   907: aload_2
    //   908: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: return
    //   915: astore_1
    //   916: new 442	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   923: astore_2
    //   924: aload_2
    //   925: ldc_w 704
    //   928: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload_2
    //   933: aload_1
    //   934: invokevirtual 705	org/json/JSONException:toString	()Ljava/lang/String;
    //   937: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: ldc 25
    //   943: iconst_1
    //   944: aload_2
    //   945: invokevirtual 459	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   951: return
    //   952: goto -775 -> 177
    //   955: iload 5
    //   957: iconst_1
    //   958: iadd
    //   959: istore 5
    //   961: goto -754 -> 207
    //   964: astore_1
    //   965: goto -327 -> 638
    //   968: astore_1
    //   969: ldc_w 677
    //   972: astore 11
    //   974: aload_3
    //   975: astore_2
    //   976: aload 10
    //   978: astore_3
    //   979: aload 11
    //   981: astore 10
    //   983: goto -291 -> 692
    //   986: astore_1
    //   987: goto -18 -> 969
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	990	0	this	CmGameSSoHandler
    //   0	990	1	paramIntent	Intent
    //   0	990	2	paramFromServiceMsg	FromServiceMsg
    //   0	990	3	paramArrayOfByte	byte[]
    //   28	825	4	i	int
    //   205	755	5	j	int
    //   38	821	6	l1	long
    //   473	124	8	l2	long
    //   47	935	10	localObject1	Object
    //   55	925	11	str	String
    //   18	775	12	localApolloCmdChannel	ApolloCmdChannel
    //   71	352	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   527	553	622	java/lang/Exception
    //   554	621	622	java/lang/Exception
    //   440	467	637	java/lang/Exception
    //   479	487	637	java/lang/Exception
    //   140	174	655	java/lang/Exception
    //   177	200	655	java/lang/Exception
    //   207	223	655	java/lang/Exception
    //   227	285	655	java/lang/Exception
    //   288	305	655	java/lang/Exception
    //   308	323	655	java/lang/Exception
    //   326	367	655	java/lang/Exception
    //   377	382	655	java/lang/Exception
    //   49	99	675	java/lang/Exception
    //   101	108	675	java/lang/Exception
    //   112	140	675	java/lang/Exception
    //   692	766	915	org/json/JSONException
    //   769	844	915	org/json/JSONException
    //   847	879	915	org/json/JSONException
    //   879	914	915	org/json/JSONException
    //   418	440	964	java/lang/Exception
    //   389	418	968	java/lang/Exception
    //   487	527	986	java/lang/Exception
  }
  
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleCMGameResp]");
    }
    ApolloCmdChannel.getInstance();
    int i;
    long l;
    try
    {
      i = paramIntent.getIntExtra("callFrom", 0);
      l = paramIntent.getLongExtra("usrdata", 0L);
      String str1 = paramIntent.getStringExtra("cmd");
      if (paramFromServiceMsg.isSuccess())
      {
        String str2 = paramIntent.getStringExtra("reqData");
        JSONObject localJSONObject1 = new JSONObject(str2);
        int j = localJSONObject1.optInt("seqId");
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
        localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
        JSONObject localJSONObject2 = new JSONObject(localUniSsoServerRsp.rspdata.get());
        localJSONObject2.put("seqId", j);
        localObject = localJSONObject2.toString();
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
          ((StringBuilder)localObject).append(str1);
          QLog.d("cmgame_process.CmGameSSoHandler", 2, ((StringBuilder)localObject).toString());
        }
        if (i == 4)
        {
          ApolloCmdChannel.getInstance().callbackFromRequest(l, (int)localUniSsoServerRsp.ret.get(), str1, paramArrayOfByte);
          return;
        }
        if ("apollo_aio_game.get_user_uin_or_openid".equals(str1))
        {
          paramArrayOfByte = CmGameUtil.a(localJSONObject1.optInt("gameId"));
          if (paramArrayOfByte != null) {
            paramArrayOfByte.a(localJSONObject2, i, str2);
          }
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
          ApolloCmdChannel.getInstance().callbackFromRequest(l, paramFromServiceMsg.getResultCode(), str1, "{}");
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
    try
    {
      i = paramIntent.getIntExtra("callFrom", 0);
      l = paramIntent.getLongExtra("usrdata", 0L);
      paramIntent = paramIntent.getStringExtra("cmd");
      if (i != 4) {
        break label459;
      }
      ApolloCmdChannel.getInstance().callbackFromRequest(l, paramFromServiceMsg.getResultCode(), paramIntent, "{}");
      return;
    }
    catch (Throwable paramIntent)
    {
      label427:
      label459:
      break label427;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("th2:");
    paramIntent.append(paramArrayOfByte);
    QLog.e("cmgame_process.CmGameSSoHandler", 1, paramIntent.toString());
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return CmGameObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.sso.CmGameSSoHandler
 * JD-Core Version:    0.7.0.1
 */