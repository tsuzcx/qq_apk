package com.tencent.mobileqq.apollo.process.sso;

import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoReq;
import com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoRsp;
import com.tencent.pb.apollo.GetTinyID.STUserAccInfo;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.ReqBody;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.RspBody;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamReq;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamRsp;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoReq;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoRsp;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.SdkData;
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class CmGameSSoHandler
  extends BusinessHandler
{
  public CmGameSSoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleGameOnlineCountRsp]");
    }
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleGameOnlineCountRsp] data null or rsp failed");
      a(1, false, null);
      return;
    }
    try
    {
      paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSSoHandler", 2, new Object[] { "[handleGameOnlineCountRsp] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
      }
      if (paramFromServiceMsg.ret.get() == 0L)
      {
        paramFromServiceMsg = paramFromServiceMsg.rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSSoHandler", 2, new Object[] { "[handleGameOnlineCountRsp] respData=", paramFromServiceMsg });
        }
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg).optJSONObject("data");
        if (paramIntent != null) {
          paramFromServiceMsg.put("tipsBarAnimation", paramIntent.getBooleanExtra("tipsBarAnimation", false));
        }
        a(1, true, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleGameOnlineCountRsp] exception=", paramIntent);
      return;
    }
    a(1, false, null);
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleWebSSO]");
    }
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "");
      localJSONObject.put("data", new JSONObject());
      localJSONObject.put("errCode", -1);
      if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()) || (paramIntent == null))
      {
        QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleWebSSO] data null or rsp failed");
        a(3, false, localJSONObject);
        return;
      }
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
        a(3, true, localJSONObject);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleWebSSO] exception=", paramIntent);
      return;
    }
    a(3, false, localJSONObject);
  }
  
  protected Class a()
  {
    return CmGameObserver.class;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, new Object[] { "[getGameOnlineUserCount] gameId=", Integer.valueOf(paramInt), ", from=", paramString });
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.3");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.get_playing_usernum");
      ((JSONObject)localObject).put("from", paramString);
      ((JSONObject)localObject).put("gameId", paramInt);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(this.a.getApp(), CmGameServlet.class);
      paramString.putExtra("cmd", "apollo_aio_game.get_playing_usernum");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      this.a.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[getGameOnlineUserCount] exception=", paramString);
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    if ("apollo_game_av.join_av_room".equals(str))
    {
      a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
      if (!paramIntent.getBooleanExtra("isCMShowJSRequest", false)) {
        break label111;
      }
      b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    label111:
    while (!paramIntent.getBooleanExtra("cs.ssoMessage.local", false))
    {
      return;
      if ("apollo_game_av.get_av_ctrl_param".equals(str))
      {
        a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
        break;
      }
      if ("apollo_game_av.get_usraccinfo".equals(str))
      {
        a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
        break;
      }
      if (!"apollo_aio_game.get_playing_usernum".equals(str)) {
        break;
      }
      c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      break;
    }
    d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, String paramString2, byte[] paramArrayOfByte, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[doCMGameReq]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.3.3560");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new qqavopensdkSsoTunnel.STAudioVideoReq();
      ((qqavopensdkSsoTunnel.STAudioVideoReq)localObject).gameId.set(paramInt2);
      ((qqavopensdkSsoTunnel.STAudioVideoReq)localObject).roomId.set(paramLong1);
      qqavopensdkSsoTunnel.ReqBody localReqBody = new qqavopensdkSsoTunnel.ReqBody();
      qqavopensdkSsoTunnel.SdkData localSdkData = new qqavopensdkSsoTunnel.SdkData();
      localSdkData.uint32_sdk_app_id.set(paramInt1);
      localSdkData.cmlb_test.set(false);
      localSdkData.tinyid.set(paramString2);
      localReqBody.msg_sdk_data.set(localSdkData);
      localReqBody.bytes_reqbody.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      ((qqavopensdkSsoTunnel.STAudioVideoReq)localObject).reqBody.set(localReqBody);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((qqavopensdkSsoTunnel.STAudioVideoReq)localObject).toByteArray()));
      paramString2 = new NewIntent(this.a.getApp(), CmGameServlet.class);
      paramString2.putExtra("usrdata", paramLong2);
      paramString2.putExtra("cmd", paramString1);
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      this.a.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "doCMGameReq failed ", paramString1);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[doTMGameReqCmdCtrl]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.3.3560");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new qqavopensdkSsoTunnel.STAVCtrlParamReq();
      ((qqavopensdkSsoTunnel.STAVCtrlParamReq)localObject).sdkAppId.set(paramInt);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((qqavopensdkSsoTunnel.STAVCtrlParamReq)localObject).toByteArray()));
      localObject = new NewIntent(this.a.getApp(), CmGameServlet.class);
      ((NewIntent)localObject).putExtra("usrdata", paramLong);
      ((NewIntent)localObject).putExtra("cmd", paramString);
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.a.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "doCMGameReq failed ", paramString);
    }
  }
  
  void a(String paramString, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int i = 0;
    long l;
    if ("apollo_game_av.join_av_room".equals(paramString))
    {
      l = paramIntent.getLongExtra("usrdata", 0L);
      if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {
        SSOTunnelEvent.a().a(l, false, null);
      }
    }
    for (;;)
    {
      return;
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
      if ("apollo_game_av.get_av_ctrl_param".equals(paramString))
      {
        l = paramIntent.getLongExtra("usrdata", 0L);
        if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
        {
          SSOTunnelEvent.a().a(l, false, null);
          return;
        }
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
      if (("apollo_game_av.get_usraccinfo".equals(paramString)) && (paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
      {
        paramString = new GetTinyID.STTinyID2UserAccInfoRsp();
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        try
        {
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          paramString.mergeFrom(paramFromServiceMsg.pbRsqData.get().toByteArray());
          paramArrayOfByte = ((GetTinyID.STTinyID2UserAccInfoRsp)paramString.get()).user_acc_info.get();
          if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
          {
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
            if (paramIntent != null)
            {
              paramIntent.a(paramString, paramFromServiceMsg, i, l);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "handleRoomSSOInfoCallback error:", paramString);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[doCmGameRequest], cmd:" + paramString1 + ",reqData:" + paramString2 + ", app: " + this.a);
    }
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("7.6.3.3560");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      localUniSsoServerReq.reqdata.set(paramString2);
      paramString2 = new NewIntent(this.a.getApp(), CmGameServlet.class);
      paramString2.putExtra("cmd", paramString1);
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
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
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[doCmGameRequest], cmd:" + paramString1 + ",reqData:" + paramString2 + ",luaR:" + paramLong + ", app: " + this.a);
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.3.3560");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localUniSsoServerReq.reqdata.set(paramString2);
      localObject = new NewIntent(this.a.getApp(), CmGameServlet.class);
      ((NewIntent)localObject).putExtra("usrdata", paramLong);
      ((NewIntent)localObject).putExtra("cmd", paramString1);
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("callFrom", paramInt);
      ((NewIntent)localObject).putExtra("isCMShowJSRequest", true);
      if ("apollo_aio_game.get_user_uin_or_openid".equals(paramString1)) {
        ((NewIntent)localObject).putExtra("reqData", paramString2);
      }
      this.a.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "doCMGameReq failed ", paramString1);
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[doCMGameReq]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.3.3560");
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
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleCMGameResp],data:" + paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null))
    {
      JSONObject localJSONObject;
      int i;
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label319;
        }
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
        localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
        localJSONObject = new JSONObject(localUniSsoServerRsp.rspdata.get());
        paramArrayOfByte = localJSONObject.toString();
        paramFromServiceMsg = paramArrayOfByte;
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          paramFromServiceMsg = "{}";
        }
        long l = paramIntent.getLongExtra("usrdata", 0L);
        paramArrayOfByte = paramIntent.getStringExtra("cmd");
        i = paramIntent.getIntExtra("callFrom", 0);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSSoHandler", 2, "ret:" + localUniSsoServerRsp.ret.get() + ",data:" + paramFromServiceMsg + ",cmd:" + paramArrayOfByte);
        }
        CmGameManager localCmGameManager = CmGameUtil.a();
        if (localCmGameManager == null)
        {
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "gameMgr is null.");
          return;
        }
        if (i != 4) {
          break label270;
        }
        localCmGameManager.a().callbackFromRequest(l, (int)localUniSsoServerRsp.ret.get(), paramArrayOfByte, paramFromServiceMsg);
        return;
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "errInfo->" + paramIntent.getMessage());
      return;
      label270:
      if ("apollo_aio_game.get_user_uin_or_openid".equals(paramArrayOfByte))
      {
        paramIntent = paramIntent.getStringExtra("reqData");
        paramFromServiceMsg = CmGameUtil.a(new JSONObject(paramIntent).optInt("gameId"));
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.a(localJSONObject, i, paramIntent);
        }
      }
    }
    else
    {
      label319:
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSSoHandler", 2, "resp data is err.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler
 * JD-Core Version:    0.7.0.1
 */