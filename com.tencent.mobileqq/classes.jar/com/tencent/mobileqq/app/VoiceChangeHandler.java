package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.voicechange.VoiceChangeObserver;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.voiceChange.VipVoiceChange.subCmd0x1ReqAuth;
import com.tencent.pb.voiceChange.VipVoiceChange.subCmd0x1RspAuth;
import com.tencent.pb.voiceChange.VipVoiceChange.voiceChangeReq;
import com.tencent.pb.voiceChange.VipVoiceChange.voiceChangeRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VoiceChangeHandler
  extends BusinessHandler
{
  WeakReference<ListenChangeVoicePanel> a;
  private QQAppInterface b;
  
  public VoiceChangeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public void a(int paramInt1, int paramInt2, ListenChangeVoicePanel paramListenChangeVoicePanel)
  {
    this.a = new WeakReference(paramListenChangeVoicePanel);
    paramListenChangeVoicePanel = super.createToServiceMsg("voiceChange.Auth");
    paramListenChangeVoicePanel.extraData.putInt("callId", paramInt2);
    Object localObject = new VipVoiceChange.voiceChangeReq();
    ((VipVoiceChange.voiceChangeReq)localObject).int32_platform.set(109);
    ((VipVoiceChange.voiceChangeReq)localObject).int32_sub_cmd.set(1);
    ((VipVoiceChange.voiceChangeReq)localObject).str_qq_version.set("8.8.17");
    VipVoiceChange.subCmd0x1ReqAuth localsubCmd0x1ReqAuth = new VipVoiceChange.subCmd0x1ReqAuth();
    localsubCmd0x1ReqAuth.int32_item_id.set(paramInt2);
    ((VipVoiceChange.voiceChangeReq)localObject).msg_subcmd0x1_req_auth.set(localsubCmd0x1ReqAuth);
    ((VipVoiceChange.voiceChangeReq)localObject).setHasFlag(true);
    paramListenChangeVoicePanel.putWupBuffer(((VipVoiceChange.voiceChangeReq)localObject).toByteArray());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendReqToSVR funcType=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", voiceID:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("VoiceChangeHandler", 2, ((StringBuilder)localObject).toString());
    }
    super.sendPbReq(paramListenChangeVoicePanel);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VoiceChangeObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"voiceChange.Auth".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("callId", paramToServiceMsg.extraData.getInt("callId"));
        boolean bool = paramFromServiceMsg.isSuccess();
        if ((bool) && (paramObject != null)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("onReceive~ isSuccess=false ,data=");
          paramToServiceMsg.append(PkgTools.toHexStr((byte[])paramObject));
          QLog.e("VoiceChangeHandler", 1, paramToServiceMsg.toString());
          ReportCenter.a().a("voiceChange.Auth", 100, paramFromServiceMsg.getBusinessFailCode(), this.appRuntime.getAccount(), 0, HardCodeUtil.a(2131913767), true);
          localBundle.putInt("result", -1);
          super.notifyUI(1, false, localBundle);
          return;
        }
        paramToServiceMsg = new VipVoiceChange.voiceChangeRsp();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        int i = paramToServiceMsg.int32_sub_cmd.get();
        paramToServiceMsg = (VipVoiceChange.subCmd0x1RspAuth)paramToServiceMsg.msg_subcmd0x1_rsp_auth.get();
        int j = paramToServiceMsg.int32_ret.get();
        paramFromServiceMsg = paramToServiceMsg.str_error_msg.get();
        paramObject = paramToServiceMsg.str_active_url.get();
        localBundle.putInt("result", j);
        bool = QLog.isColorLevel();
        if (bool)
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("VoiceChangeHandler onReceive~ ret=");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(",msg=");
          paramToServiceMsg.append(paramFromServiceMsg);
          paramToServiceMsg.append(", url=");
          paramToServiceMsg.append(paramObject);
          paramToServiceMsg.append(", funcType=");
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(", actStr=");
          paramToServiceMsg.append(null);
          QLog.d("VoiceChangeHandler", 2, paramToServiceMsg.toString());
        }
        localBundle.putString("message", paramFromServiceMsg);
        localBundle.putString("svr_url", paramObject);
        localBundle.putString("svr_actStr", null);
        if ((this.a == null) || (this.a.get() == null)) {
          break label527;
        }
        paramToServiceMsg = (ListenChangeVoicePanel)this.a.get();
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg.a(i, j, localBundle, false);
        }
        else
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("VoiceChangeHandler onReceive~ null == listenChangeVoicePanel ret=");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(",msg=");
          paramToServiceMsg.append(paramFromServiceMsg);
          paramToServiceMsg.append(", url=");
          paramToServiceMsg.append(paramObject);
          paramToServiceMsg.append(", funcType=");
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(", actStr=");
          paramToServiceMsg.append(null);
          QLog.e("VoiceChangeHandler", 1, paramToServiceMsg.toString());
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive prb.mergeFrom error: ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("VoiceChangeHandler", 1, paramFromServiceMsg.toString());
      }
      this.a = null;
      return;
      label527:
      paramToServiceMsg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VoiceChangeHandler
 * JD-Core Version:    0.7.0.1
 */