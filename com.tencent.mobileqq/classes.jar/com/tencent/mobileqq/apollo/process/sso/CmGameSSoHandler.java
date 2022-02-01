package com.tencent.mobileqq.apollo.process.sso;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.common.util.ReportInfoManager.ReportChannlInfo;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.game.rankList.CmGameUserInfo;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.process.data.CmGameResUpdateInfo;
import com.tencent.mobileqq.apollo.process.download.CmGameRscSvrInfo;
import com.tencent.mobileqq.apollo.process.download.CmGameSubRscHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.gamecenter.data.GameNoticeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
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
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.ReqBody;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.RspBody;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamReq;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamRsp;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoReq;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoRsp;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.SdkData;
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
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
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleGameOnlineCountRsp]");
    }
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleGameOnlineCountRsp] data null or rsp failed");
      notifyUI(1, false, null);
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
        notifyUI(1, true, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleGameOnlineCountRsp] exception=", paramIntent);
      return;
    }
    notifyUI(1, false, null);
  }
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
        notifyUI(3, false, localJSONObject);
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
        notifyUI(3, true, localJSONObject);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleWebSSO] exception=", paramIntent);
      return;
    }
    notifyUI(3, false, localJSONObject);
  }
  
  public void a(int paramInt, String paramString, ArrayList<CmGameResUpdateInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, new Object[] { "[checkGameResUpdate], gameId:", Integer.valueOf(paramInt) });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Object localObject;
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
    try
    {
      localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
      localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
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
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, paramString, new Object[0]);
      return;
    }
    paramArrayList.from.set("android");
    paramArrayList.list.set((List)localObject);
    localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(paramArrayList.toByteArray()));
    paramArrayList = new NewIntent(this.a.getApp(), CmGameServlet.class);
    paramArrayList.putExtra("gameid", paramInt);
    paramArrayList.putExtra("packname", paramString);
    paramArrayList.putExtra("cmd", "apollo_res_update.get_patch_update_info");
    paramArrayList.putExtra("data", localUniSsoServerReq.toByteArray());
    this.a.startServlet(paramArrayList);
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    if ("apollo_game_av.join_av_room".equals(str))
    {
      a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
      if (!paramIntent.getBooleanExtra("isCMShowJSRequest", false)) {
        break label206;
      }
      d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
    label206:
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
      if ("apollo_aio_game.get_playing_usernum".equals(str))
      {
        f(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        break;
      }
      if ("apollo_res_update.get_patch_update_info".equals(str))
      {
        b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        break;
      }
      if ("ltgame_native_api.batch_get_user_info".equals(str))
      {
        c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        break;
      }
      if ("QQVacCommSvc.check_download".equals(str))
      {
        e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        break;
      }
      if ((!"QQVacCommSvc.report_channel".equals(str)) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "game channel report");
      break;
    }
    g(paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
  
  public void a(ReportInfoManager.ReportChannlInfo paramReportChannlInfo)
  {
    QLog.d("cmgame_process.CmGameSSoHandler", 1, "reportGameCenterChannel");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("qq_version", "8.5.5.5105");
      Field[] arrayOfField = paramReportChannlInfo.getClass().getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        localJSONObject2.put(localField.getName(), localField.get(paramReportChannlInfo));
        i += 1;
      }
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12886", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramReportChannlInfo = new NewIntent(this.a.getApp(), CmGameServlet.class);
      paramReportChannlInfo.putExtra("cmd", "QQVacCommSvc.report_channel");
      paramReportChannlInfo.putExtra("data", localUniSsoServerReq.toByteArray());
      this.a.startServlet(paramReportChannlInfo);
      return;
    }
    catch (Exception paramReportChannlInfo)
    {
      paramReportChannlInfo.printStackTrace();
    }
  }
  
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
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
      localUniSsoServerReqComm.mqqver.set("8.5.5.5105");
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
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[doCmGameRequest], cmd:" + paramString1 + ",luaR:" + paramLong + ", app: " + this.a);
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localUniSsoServerReq.reqdata.set(paramString2);
      localObject = new NewIntent(this.a.getApp(), CmGameServlet.class);
      ((NewIntent)localObject).putExtra("usrdata", paramLong);
      ((NewIntent)localObject).putExtra("cmd", paramString1);
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("callFrom", paramInt);
      ((NewIntent)localObject).putExtra("openIdList", paramString2);
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
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[doCmGameRequest], cmd:" + paramString1 + ",luaR:" + paramLong + ", app: " + this.a);
    }
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("8.5.5.5105");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      for (;;)
      {
        paramArrayOfByte = new NewIntent(this.a.getApp(), CmGameServlet.class);
        paramArrayOfByte.putExtra("usrdata", paramLong);
        paramArrayOfByte.putExtra("cmd", paramString1);
        paramArrayOfByte.putExtra("data", localUniSsoServerReq.toByteArray());
        paramArrayOfByte.putExtra("callFrom", paramInt);
        paramArrayOfByte.putExtra("isCMShowJSRequest", true);
        paramArrayOfByte.putExtra("reqData", paramString2);
        this.a.startServlet(paramArrayOfByte);
        return;
        localUniSsoServerReq.reqdata.set(paramString2);
      }
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
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
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((CmGameLauncher)localObject1).a();
    } while (localObject1 == null);
    try
    {
      localObject2 = new WebSSOAgent.UniSsoServerRsp();
      ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom(paramArrayOfByte);
      if (!paramFromServiceMsg.isSuccess())
      {
        ((CmGameSubRscHandler)localObject1).c(paramFromServiceMsg.getResultCode(), paramIntent);
        return;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("cmgame_process.CmGameSSoHandler", 1, paramArrayOfByte, new Object[0]);
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
    Object localObject2 = new CmGameRscSvrInfo();
    if (paramArrayOfByte.updateFlag.get() == 1)
    {
      bool = true;
      ((CmGameRscSvrInfo)localObject2).jdField_a_of_type_Boolean = bool;
      if (paramArrayOfByte.isPatch.get() != 1) {
        break label368;
      }
    }
    label368:
    for (boolean bool = true;; bool = false)
    {
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
      bool = false;
      break;
    }
  }
  
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleCMGameResp]");
    }
    CmGameManager localCmGameManager = CmGameUtil.a();
    if ((localCmGameManager == null) || (localCmGameManager.a() == null))
    {
      QLog.w("cmgame_process.CmGameSSoHandler", 1, "gameMgr is null.");
      return;
    }
    int j = paramIntent.getIntExtra("callFrom", 0);
    long l = paramIntent.getLongExtra("usrdata", 0L);
    String str = paramIntent.getStringExtra("openIdList");
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = paramIntent.getStringExtra("cmd");
        if (paramFromServiceMsg.isSuccess())
        {
          Object localObject2 = new WebSSOAgent.UniSsoServerRsp();
          ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom(paramArrayOfByte);
          paramFromServiceMsg = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).toString();
          paramIntent = paramFromServiceMsg;
          if (TextUtils.isEmpty(paramFromServiceMsg)) {
            paramIntent = "{}";
          }
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameSSoHandler", 2, "ret:" + ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get() + ",cmd:" + (String)localObject1);
          }
          paramFromServiceMsg = new JSONObject(paramIntent).optJSONArray("infoList");
          paramIntent = new JSONArray();
          if (paramFromServiceMsg == null) {
            break;
          }
          i = 0;
          if (i < paramFromServiceMsg.length())
          {
            localObject1 = paramFromServiceMsg.getJSONObject(i);
            if (localObject1 == null) {
              break label879;
            }
            paramArrayOfByte = ((JSONObject)localObject1).optString("uid");
            localObject2 = ((JSONObject)localObject1).optString("nick");
            localObject1 = new CmGameUserInfo(((JSONObject)localObject1).optString("icon"), (String)localObject2, paramArrayOfByte);
            localCmGameManager.a().updateUserInfo((CmGameUserInfo)localObject1);
            if (j == CmGameSubProcessHandler.jdField_a_of_type_Int) {
              localCmGameManager.a().getOpenApiHead(l, paramArrayOfByte);
            } else if (j == CmGameSubProcessHandler.jdField_b_of_type_Int) {
              localCmGameManager.a().getOpenApiNick(l, paramArrayOfByte);
            }
          }
        }
      }
      catch (Exception paramIntent) {}
      for (;;)
      {
        try
        {
          if (j != CmGameSubProcessHandler.jdField_a_of_type_Int) {
            break label764;
          }
          paramFromServiceMsg = new JSONObject(str).optJSONArray("uidList");
          localCmGameManager.a().nativeOpenApiGetHeadCallBack(l, paramFromServiceMsg.getString(0), -1, 0, 0, null);
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "GET_OPENID_INFO_FROM_HEAD error openid=" + paramFromServiceMsg.getString(0));
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "handleOpenIdInfo e:" + paramIntent.toString());
          return;
        }
        catch (JSONException paramIntent)
        {
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "handleOpenIdInfo catch json e:" + paramIntent.toString());
          return;
        }
        if (j != CmGameSubProcessHandler.c) {
          break label879;
        }
        paramIntent.put(paramArrayOfByte);
        break label879;
        if (j != CmGameSubProcessHandler.c) {
          break;
        }
        paramFromServiceMsg = new JSONObject();
        paramFromServiceMsg.put("openIdList", paramIntent);
        localCmGameManager.a().callbackFromRequest(l, 0, "cs.preload_userInfoList.local", paramFromServiceMsg.toString());
        return;
        if (j == CmGameSubProcessHandler.jdField_a_of_type_Int)
        {
          paramIntent = new JSONObject(str).optJSONArray("uidList");
          localCmGameManager.a().nativeOpenApiGetHeadCallBack(l, paramIntent.getString(0), paramFromServiceMsg.getResultCode(), 0, 0, null);
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "GET_OPENID_INFO_FROM_HEAD error openid=" + paramIntent.getString(0));
          return;
        }
        if (j == CmGameSubProcessHandler.jdField_b_of_type_Int)
        {
          paramIntent = new JSONObject(str).optJSONArray("uidList");
          localCmGameManager.a().nativeOpenApiGetNickCallBack(l, paramIntent.getString(0), paramFromServiceMsg.getResultCode(), null);
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "GET_OPENID_INFO_FROM_NICK error openid=" + paramIntent.getString(0));
          return;
        }
        if (j != CmGameSubProcessHandler.c) {
          break;
        }
        paramIntent = new JSONObject();
        paramIntent.put("res", "error");
        paramIntent.put("code", paramFromServiceMsg.getResultCode());
        localCmGameManager.a().callbackFromRequest(l, paramFromServiceMsg.getResultCode(), "cs.preload_userInfoList.local", paramIntent.toString());
        QLog.e("cmgame_process.CmGameSSoHandler", 1, "GET_OPENID_INFO_FROM_PRELOAD error ");
        return;
        label764:
        if (j == CmGameSubProcessHandler.jdField_b_of_type_Int)
        {
          paramFromServiceMsg = new JSONObject(str).optJSONArray("uidList");
          localCmGameManager.a().nativeOpenApiGetNickCallBack(l, paramFromServiceMsg.getString(0), -1, null);
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "GET_OPENID_INFO_FROM_NICK error openid=" + paramFromServiceMsg.getString(0));
        }
        else if (j == CmGameSubProcessHandler.c)
        {
          localCmGameManager.a().callbackFromRequest(l, -1, "cs.preload_userInfoList.local", "{}");
          QLog.e("cmgame_process.CmGameSSoHandler", 1, "GET_OPENID_INFO_FROM_PRELOAD error ");
        }
      }
      label879:
      i += 1;
    }
  }
  
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSSoHandler", 2, "[handleCMGameResp]");
    }
    CmGameManager localCmGameManager = CmGameUtil.a();
    if ((localCmGameManager == null) || (localCmGameManager.a() == null)) {
      QLog.w("cmgame_process.CmGameSSoHandler", 1, "gameMgr is null.");
    }
    int i;
    long l;
    String str3;
    label402:
    do
    {
      String str2;
      JSONObject localJSONObject2;
      do
      {
        JSONObject localJSONObject1;
        do
        {
          for (;;)
          {
            return;
            try
            {
              i = paramIntent.getIntExtra("callFrom", 0);
              l = paramIntent.getLongExtra("usrdata", 0L);
              str3 = paramIntent.getStringExtra("cmd");
              if (!paramFromServiceMsg.isSuccess()) {
                break label402;
              }
              str2 = paramIntent.getStringExtra("reqData");
              localJSONObject1 = new JSONObject(str2);
              int j = localJSONObject1.optInt("seqId");
              WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
              localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
              localJSONObject2 = new JSONObject(localUniSsoServerRsp.rspdata.get());
              localJSONObject2.put("seqId", j);
              String str1 = localJSONObject2.toString();
              paramArrayOfByte = str1;
              if (TextUtils.isEmpty(str1)) {
                paramArrayOfByte = "{}";
              }
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.CmGameSSoHandler", 2, "ret:" + localUniSsoServerRsp.ret.get() + ",cmd:" + str3);
              }
              if (i == 4)
              {
                localCmGameManager.a().callbackFromRequest(l, (int)localUniSsoServerRsp.ret.get(), str3, paramArrayOfByte);
                return;
              }
            }
            catch (Throwable paramArrayOfByte)
            {
              QLog.e("cmgame_process.CmGameSSoHandler", 1, "th:" + paramArrayOfByte);
              try
              {
                i = paramIntent.getIntExtra("callFrom", 0);
                l = paramIntent.getLongExtra("usrdata", 0L);
                paramIntent = paramIntent.getStringExtra("cmd");
                if (i == 4)
                {
                  localCmGameManager.a().callbackFromRequest(l, paramFromServiceMsg.getResultCode(), paramIntent, "{}");
                  return;
                }
              }
              catch (Throwable paramIntent)
              {
                QLog.e("cmgame_process.CmGameSSoHandler", 1, "th2:" + paramArrayOfByte);
                return;
              }
            }
          }
        } while (!"apollo_aio_game.get_user_uin_or_openid".equals(str3));
        paramArrayOfByte = CmGameUtil.a(localJSONObject1.optInt("gameId"));
      } while (paramArrayOfByte == null);
      paramArrayOfByte.a(localJSONObject2, i, str2);
      return;
      QLog.w("cmgame_process.CmGameSSoHandler", 1, "resp data is err, errorCode:" + paramFromServiceMsg.getResultCode());
    } while (i != 4);
    localCmGameManager.a().callbackFromRequest(l, paramFromServiceMsg.getResultCode(), str3, "{}");
  }
  
  public void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameSSoHandler", 2, new Object[] { "[handleCheckDownload] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
        }
        if (paramFromServiceMsg.ret.get() == 0L)
        {
          paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
          if (paramFromServiceMsg == null) {
            break label297;
          }
          paramArrayOfByte = paramFromServiceMsg.optJSONObject("12829");
          paramFromServiceMsg.optInt("ecode");
          if (paramArrayOfByte == null) {
            break label297;
          }
          paramFromServiceMsg = paramArrayOfByte.optJSONObject("data");
          if (paramFromServiceMsg == null) {
            break label297;
          }
          paramFromServiceMsg = paramFromServiceMsg.optJSONObject("rsp");
          if (paramFromServiceMsg == null) {
            break label297;
          }
          i = paramFromServiceMsg.optInt("legal");
          paramArrayOfByte = paramFromServiceMsg.optString("legal_url");
          Bundle localBundle = paramIntent.getExtras().getBundle("downloadBundle");
          localBundle.putInt("legal", i);
          localBundle.putString("legal_url", paramArrayOfByte);
          GameNoticeInfo.saveTipInfo(paramIntent.getExtras().getString("appid"), paramFromServiceMsg);
          notifyUI(4, true, localBundle);
          i = 1;
          if (i == 0) {
            notifyUI(4, false, paramIntent.getExtras().getBundle("downloadBundle"));
          }
        }
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        notifyUI(4, false, paramIntent.getExtras().getBundle("downloadBundle"));
        QLog.e("cmgame_process.CmGameSSoHandler", 1, "[handleCheckDownload] err:" + paramFromServiceMsg.getMessage());
        return;
      }
      notifyUI(4, false, paramIntent.getExtras().getBundle("downloadBundle"));
      return;
      label297:
      int i = 0;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return CmGameObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler
 * JD-Core Version:    0.7.0.1
 */