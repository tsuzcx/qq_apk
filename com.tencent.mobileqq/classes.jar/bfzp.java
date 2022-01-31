import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qidian.controller.QidianHandler.1;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qidian.proto.mobileqq_qidian.CRMMsgHead;
import com.tencent.qidian.proto.mobileqq_qidian.CheckMpqqRefuseFlagReq;
import com.tencent.qidian.proto.mobileqq_qidian.CheckMpqqRefuseFlagRsp;
import com.tencent.qidian.proto.mobileqq_qidian.ClickEManReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.ClickEManRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.ClickReplyCmdActionReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.ClickReplyCmdActionRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.CloseSessionReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.CloseSessionRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.CorpReportInfo;
import com.tencent.qidian.proto.mobileqq_qidian.ExtReportInfo;
import com.tencent.qidian.proto.mobileqq_qidian.GetCorpUinDetailInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetCustomerTransferInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetCustomerTransferInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetNavigationMenuConfigReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetNavigationMenuConfigRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetQiDianGroupInfoReq;
import com.tencent.qidian.proto.mobileqq_qidian.GetQiDianGroupInfoRsp;
import com.tencent.qidian.proto.mobileqq_qidian.GetUserDetailInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.NotRecvQdGroupMsgReq;
import com.tencent.qidian.proto.mobileqq_qidian.NotRecvQdGroupMsgRsp;
import com.tencent.qidian.proto.mobileqq_qidian.QidianWpaAddFriendReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.QidianWpaAddFriendRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.ReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.ReqCorpUinWpaReq;
import com.tencent.qidian.proto.mobileqq_qidian.ReqCorpUinWpaRsp;
import com.tencent.qidian.proto.mobileqq_qidian.RetInfo;
import com.tencent.qidian.proto.mobileqq_qidian.RspBody;
import com.tencent.qidian.proto.mobileqq_qidian.VerifyWpaUinAndKeyReq;
import com.tencent.qidian.proto.mobileqq_qidian.VerifyWpaUinAndKeyRsp;
import com.tencent.qidian.proto.mobileqq_qidian.WpaAssignKfextReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.WpaAssignKfextRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.WpaSigtToSigMsgReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.WpaSigtToSigMsgRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x7e7.Oidb_0x7e7.ReqBody;
import tencent.im.oidb.cmd0x7e7.Oidb_0x7e7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92.MsgBody.S2CPushEmanMsgToC;
import tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CUserGetCouponForCEventPush;

public class bfzp
  extends alpd
{
  private static final String a = bfzp.class.getName();
  
  public bfzp(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private mobileqq_qidian.CRMMsgHead a(String paramString1, int paramInt, String paramString2)
  {
    mobileqq_qidian.CRMMsgHead localCRMMsgHead = new mobileqq_qidian.CRMMsgHead();
    localCRMMsgHead.uint32_crm_sub_cmd.set(paramInt);
    localCRMMsgHead.uint32_crm_sub_cmd.setHasFlag(true);
    long l;
    if (!TextUtils.isEmpty(paramString1))
    {
      l = Long.valueOf(paramString1).longValue();
      localCRMMsgHead.uint64_kf_uin.set(l);
      localCRMMsgHead.uint64_kf_uin.setHasFlag(true);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      l = Long.valueOf(paramString2).longValue();
      localCRMMsgHead.uint64_ext_uin.set(l);
      localCRMMsgHead.uint64_ext_uin.setHasFlag(true);
    }
    localCRMMsgHead.uint32_terminal_type.set(2);
    localCRMMsgHead.uint32_terminal_version.set(bgac.a("8.3.5"));
    return localCRMMsgHead;
  }
  
  private mobileqq_qidian.ReqBody a(String paramString1, int paramInt, String paramString2)
  {
    mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
    paramString1 = a(paramString1, paramInt, paramString2);
    localReqBody.msg_crm_common_head.set(paramString1);
    localReqBody.msg_crm_common_head.setHasFlag(true);
    localReqBody.uint32_sub_cmd.set(paramInt);
    localReqBody.uint32_sub_cmd.setHasFlag(true);
    return localReqBody;
  }
  
  private void a(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    ((bfyh)this.mApp.getManager(165)).a(paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo);
  }
  
  private void a(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    ((bfyh)this.mApp.getManager(165)).a(paramQidianExternalInfo, paramQidianProfileUiInfo);
  }
  
  private void a(mobileqq_qidian.ReqBody paramReqBody, String paramString, Map<String, String> paramMap)
  {
    ToServiceMsg localToServiceMsg = super.createToServiceMsg(paramString);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localToServiceMsg.extraData.putString(str, (String)paramMap.get(str));
      }
    }
    localToServiceMsg.putWupBuffer(paramReqBody.toByteArray());
    super.sendPbReq(localToServiceMsg);
    paramReqBody = alof.c[bdin.a(this.mApp.getApp().getBaseContext())];
    azqs.b(this.app, "P_CliOper", "Qidian", "", paramString, paramString, 0, 0, "", "", paramReqBody, "");
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    String str = alof.c[bdin.a(this.mApp.getApp().getBaseContext())];
    long l = paramToServiceMsg.extraData.getLong("startTime");
    l = System.currentTimeMillis() - l;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label167;
      }
      azqs.b(this.app, "P_CliOper", "Qidian", "", paramString + "_success", paramString + "_success", 0, 0, String.valueOf((int)l), "", str, "");
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleAssignExt success, delta is " + l);
      }
    }
    label167:
    do
    {
      return bool;
      bool = false;
      break;
      paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      azqs.b(this.app, "P_CliOper", "Qidian", "", paramString + "_fail", paramString + "_fail", 0, 0, String.valueOf((int)l), "", str, paramToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d(a, 2, "handleGetAccountType failed, fail message: " + paramToServiceMsg);
    return bool;
  }
  
  private void b(SubMsgType0x92.MsgBody paramMsgBody)
  {
    paramMsgBody = (SubMsgType0x92.MsgBody.S2CPushEmanMsgToC)paramMsgBody.msg_Push_Eman_Msg.get();
    if (paramMsgBody != null)
    {
      long l = paramMsgBody.uint64_uin.get();
      if (paramMsgBody.str_xml.has())
      {
        paramMsgBody = paramMsgBody.str_xml.get();
        ((bfyh)this.mApp.getManager(165)).a(this.app, l, paramMsgBody);
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 1;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("key_sigt", paramToServiceMsg.extraData.get("key_sigt"));
      paramFromServiceMsg.put("uin", paramToServiceMsg.extraData.get("uin"));
      paramFromServiceMsg.put("key_return_root", paramToServiceMsg.extraData.get("key_return_root"));
      if (i == 0) {}
    }
    for (;;)
    {
      try
      {
        mobileqq_qidian.RspBody localRspBody = new mobileqq_qidian.RspBody();
        localRspBody.mergeFrom((byte[])paramObject);
        if (localRspBody.msg_req_corpuin_wpa_rsp.has())
        {
          if (localRspBody.msg_req_corpuin_wpa_rsp.msg_ret.uint32_ret_code.get() != 0) {
            break label300;
          }
          i = j;
          if (i != 0)
          {
            i = localRspBody.msg_req_corpuin_wpa_rsp.uint32_aio_type.get();
            if (localRspBody.msg_req_corpuin_wpa_rsp.bytes_sigmsg.has())
            {
              paramToServiceMsg = paramToServiceMsg.extraData.get("uin");
              if (paramToServiceMsg != null) {
                this.app.a().c(String.valueOf(paramToServiceMsg), localRspBody.msg_req_corpuin_wpa_rsp.bytes_sigmsg.get().toByteArray());
              }
            }
            paramFromServiceMsg.put("key_aio_type", Integer.valueOf(i));
            notifyUI(1007, true, paramFromServiceMsg);
            return;
          }
          notifyUI(1007, false, paramFromServiceMsg);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleCorpUinWpaReport ", paramToServiceMsg);
        }
        notifyUI(1007, false, paramFromServiceMsg);
        return;
      }
      notifyUI(1007, false, paramFromServiceMsg);
      return;
      notifyUI(1007, false, paramFromServiceMsg);
      return;
      i = 0;
      break;
      label300:
      i = 0;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    int i = j;
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        i = j;
        if (paramObject != null) {
          i = 1;
        }
      }
      if (i != 0)
      {
        paramFromServiceMsg = new mobileqq_qidian.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.msg_not_recv_qd_group_msg_rsp.has())
        {
          paramFromServiceMsg = (mobileqq_qidian.NotRecvQdGroupMsgRsp)paramFromServiceMsg.msg_not_recv_qd_group_msg_rsp.get();
          i = paramFromServiceMsg.msg_ret.uint32_ret_code.get();
          paramFromServiceMsg = paramFromServiceMsg.msg_ret.str_error_msg.get();
          paramObject = new HashMap();
          paramObject.put("ret_code", Integer.valueOf(i));
          paramObject.put("ret_msg", paramFromServiceMsg);
          if (i == 0)
          {
            ThreadManager.executeOnSubThread(new QidianHandler.1(this, paramToServiceMsg, paramObject));
            return;
          }
          notifyUI(1005, false, paramObject);
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "handleBlockBulkMsg ", paramToServiceMsg);
      }
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 1;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {
        break label294;
      }
      try
      {
        paramFromServiceMsg = new mobileqq_qidian.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.has())
        {
          if (paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.int32_result.get() == 0)
          {
            i = j;
            label69:
            if (i == 0) {
              break label242;
            }
            paramObject = paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.bytes_sigmsg_ext.get().toByteArray();
            long l = paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.uint64_kfext_uin.get();
            paramFromServiceMsg = new HashMap();
            paramFromServiceMsg.put("uin", String.valueOf(l));
            paramFromServiceMsg.put("sigmsg", paramObject);
            paramToServiceMsg = paramToServiceMsg.extraData;
            if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
              break label232;
            }
            paramObject = paramToServiceMsg.keySet().iterator();
            while (paramObject.hasNext())
            {
              String str = (String)paramObject.next();
              paramFromServiceMsg.put(str, paramToServiceMsg.get(str));
            }
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleGetSigmsgBySigt ", paramToServiceMsg);
        }
        notifyUI(1010, false, null);
      }
    }
    label232:
    label242:
    do
    {
      i = 0;
      break;
      i = 0;
      break label69;
      notifyUI(1010, true, paramFromServiceMsg);
      return;
      notifyUI(1010, false, null);
    } while (!QLog.isColorLevel());
    QLog.d(a, 2, "handleGetSigmsgBySigt " + paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.str_err_msg.get());
    return;
    label294:
    notifyUI(1010, false, null);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        try
        {
          paramToServiceMsg = new mobileqq_qidian.RspBody();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (!paramToServiceMsg.msg_qidian_wpa_addfriend_rsp.has()) {
            break label180;
          }
          i = paramToServiceMsg.msg_close_session_rsp.msg_ret.uint32_ret_code.get();
          if (i == 0)
          {
            if (!QLog.isColorLevel()) {
              break label180;
            }
            QLog.d(a, 2, "handleGetWebImAddFriend errorCode = 0");
            return;
          }
          paramToServiceMsg = paramToServiceMsg.msg_close_session_rsp.msg_ret.str_error_msg.get();
          if (!QLog.isColorLevel()) {
            break label180;
          }
          QLog.d(a, 2, "handleGetWebImAddFriend errorCode: " + i + " , errorMsg: " + paramToServiceMsg);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            break label180;
          }
        }
        QLog.d(a, 2, "handleGetWebImAddFriend ", paramToServiceMsg);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(a, 2, "handleGetWebImAddFriend is Success = false");
      }
      label180:
      return;
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (paramObject != null)
      {
        try
        {
          paramFromServiceMsg = new mobileqq_qidian.RspBody();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (!paramFromServiceMsg.msg_get_qidian_group_info_rsp.has()) {
            return;
          }
          paramFromServiceMsg = (mobileqq_qidian.GetQiDianGroupInfoRsp)paramFromServiceMsg.msg_get_qidian_group_info_rsp.get();
          paramObject = (mobileqq_qidian.RetInfo)paramFromServiceMsg.msg_ret.get();
          if (paramObject.uint32_ret_code.get() == 0)
          {
            paramObject = new HashMap();
            paramFromServiceMsg = paramFromServiceMsg.bytes_wpalink.get().toStringUtf8();
            paramObject.put("uin", (String)paramToServiceMsg.extraData.get("uin"));
            paramObject.put("url", paramFromServiceMsg);
            notifyUI(1018, true, paramObject);
            return;
          }
          paramToServiceMsg = paramObject.str_error_msg.get();
          if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramToServiceMsg))) {
            QLog.d(a, 2, "handleQidianGroupInfo error is " + paramToServiceMsg);
          }
          notifyUI(1018, false, null);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "handleQidianGroupInfo throw exception is " + paramToServiceMsg.toString());
          }
          notifyUI(1018, false, null);
          return;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleQidianGroupInfo data is null");
        }
        notifyUI(1018, false, null);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleQidianGroupInfo res is fail");
      }
      notifyUI(1018, false, null);
    }
  }
  
  public void a(long paramLong)
  {
    new StringBuilder().append("QidianSsoProto.getUserDetailInfo").append(paramLong).toString();
    mobileqq_qidian.ReqBody localReqBody = a("", 4, String.valueOf(paramLong));
    localReqBody.msg_crm_common_head.uint32_ver_no.set(1);
    Object localObject = new mobileqq_qidian.GetUserDetailInfoReqBody();
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint32_req_type.set(2);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint32_mobile_client.set(1);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint64_uin.set(paramLong);
    localReqBody.msg_get_user_detail_info_req.set((MessageMicro)localObject);
    localReqBody.msg_get_user_detail_info_req.setHasFlag(true);
    localObject = new HashMap(1);
    ((Map)localObject).put("uin", String.valueOf(paramLong));
    ((Map)localObject).put("req_type", String.valueOf(2));
    a(localReqBody, "QidianSsoProto.getUserDetailInfo", (Map)localObject);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    mobileqq_qidian.ReqBody localReqBody = a("", 1005, String.valueOf(paramLong2));
    Object localObject = new mobileqq_qidian.GetCustomerTransferInfoReqBody();
    ((mobileqq_qidian.GetCustomerTransferInfoReqBody)localObject).uint64_qq_uin.set(paramLong1);
    ((mobileqq_qidian.GetCustomerTransferInfoReqBody)localObject).uint64_kfext_uin.set(paramLong2);
    ((mobileqq_qidian.GetCustomerTransferInfoReqBody)localObject).uint32_mobile_client.set(1);
    ((mobileqq_qidian.GetCustomerTransferInfoReqBody)localObject).uint32_ver_no.set(ndv.a("8.3.5"));
    localReqBody.msg_get_customer_transfer_info_req.set((MessageMicro)localObject);
    localReqBody.msg_get_customer_transfer_info_req.setHasFlag(true);
    localObject = new HashMap(1);
    ((Map)localObject).put("kfext", String.valueOf(paramLong2));
    a(localReqBody, "QidianSsoProto.getCustomerTransferInfo", (Map)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e(a, 2, "getNavigationConfig...version=" + paramInt1);
    }
    mobileqq_qidian.ReqBody localReqBody = a(String.valueOf(paramLong1), 1007, null);
    mobileqq_qidian.GetNavigationMenuConfigReqBody localGetNavigationMenuConfigReqBody = new mobileqq_qidian.GetNavigationMenuConfigReqBody();
    localGetNavigationMenuConfigReqBody.uint64_puin.set(paramLong1);
    localGetNavigationMenuConfigReqBody.uint64_uin.set(paramLong2);
    localGetNavigationMenuConfigReqBody.uint32_ver_no.set(paramInt1);
    localGetNavigationMenuConfigReqBody.uint32_unread_msg_count.set(paramInt2);
    PBUInt32Field localPBUInt32Field = localGetNavigationMenuConfigReqBody.uint32_is_click_graytip;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localPBUInt32Field.set(paramInt1);
      localGetNavigationMenuConfigReqBody.uint32_is_support_cc_nav.set(1);
      localReqBody.msg_get_navigation_menu_config_req_body.setHasFlag(true);
      localReqBody.msg_get_navigation_menu_config_req_body.set(localGetNavigationMenuConfigReqBody);
      a(localReqBody, "QidianSsoProto.getNavigationConfig", null);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ranKey", paramToServiceMsg.extraData.get("ranKey"));
    for (;;)
    {
      try
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject, "qidian_wpa_assign");
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          break label325;
        }
        i = 1;
        if (i == 0) {
          break label314;
        }
        paramFromServiceMsg = new mobileqq_qidian.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.msg_wpa_assign_kfext_rsp.has())
        {
          if (paramFromServiceMsg.msg_wpa_assign_kfext_rsp.int32_result.get() != 0) {
            break label331;
          }
          i = j;
          if (i != 0)
          {
            paramObject = String.valueOf(paramFromServiceMsg.msg_wpa_assign_kfext_rsp.uint64_ext_uin.get());
            String str = bdhe.a(paramFromServiceMsg.msg_wpa_assign_kfext_rsp.bytes_sigT_ext.get().toByteArray());
            i = paramFromServiceMsg.msg_wpa_assign_kfext_rsp.uint32_aio_type.get();
            if ((paramFromServiceMsg.msg_wpa_assign_kfext_rsp.bytes_sigmsg.has()) && (paramObject != null)) {
              this.app.a().c(paramObject, paramFromServiceMsg.msg_wpa_assign_kfext_rsp.bytes_sigmsg.get().toByteArray());
            }
            localHashMap.put("key_ext_uin", paramObject);
            localHashMap.put("key_sigt", str);
            localHashMap.put("key_aio_type", Integer.valueOf(i));
            localHashMap.put("key_return_root", paramToServiceMsg.extraData.get("key_return_root"));
            notifyUI(1004, true, localHashMap);
            return;
          }
          notifyUI(1004, false, localHashMap);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleAssignExt ", paramToServiceMsg);
        }
        notifyUI(1004, false, localHashMap);
        return;
      }
      notifyUI(1004, false, localHashMap);
      return;
      label314:
      notifyUI(1004, false, localHashMap);
      return;
      label325:
      int i = 0;
      continue;
      label331:
      i = 0;
    }
  }
  
  public void a(String paramString)
  {
    new Bundle().putString("k", paramString);
    StringBuilder localStringBuilder = new StringBuilder("http://qm.qq.com/cgi-bin/qm/qr");
    localStringBuilder.append("?");
    localStringBuilder.append("k=");
    localStringBuilder.append(paramString);
    short s = (short)localStringBuilder.toString().getBytes().length;
    paramString = new byte[s + 14];
    bdqa.a(paramString, 0, (short)2);
    bdqa.a(paramString, 2, (short)1);
    bdqa.a(paramString, 4, (short)4);
    bdqa.a(paramString, 6, 1);
    bdqa.a(paramString, 10, (short)5);
    bdqa.a(paramString, 12, s);
    bdqa.a(paramString, 14, localStringBuilder.toString().getBytes(), s);
    sendPbReq(makeOIDBPkg("OidbSvc.0x782", 1922, 0, paramString));
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "decodeQidianPrivateTroopUin");
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new Oidb_0x7e7.ReqBody();
    ((Oidb_0x7e7.ReqBody)localObject).cmd_id.set(paramInt1);
    ((Oidb_0x7e7.ReqBody)localObject).platform.set(2);
    ((Oidb_0x7e7.ReqBody)localObject).timestamp.set(System.currentTimeMillis() / 1000L);
    ((Oidb_0x7e7.ReqBody)localObject).env.set(paramInt2);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          continue;
        }
        paramString = new JSONObject();
        paramString.put("qq_uin", this.app.getCurrentAccountUin());
        ((Oidb_0x7e7.ReqBody)localObject).json_string.set(ByteStringMicro.copyFromUtf8(paramString.toString()));
        long l;
        if (paramString.has("kfuin"))
        {
          l = Long.valueOf(paramString.getString("kfuin")).longValue();
          ((Oidb_0x7e7.ReqBody)localObject).corp_uin.set(l);
        }
        if (paramString.has("kfext"))
        {
          l = Long.valueOf(paramString.getString("kfext")).longValue();
          ((Oidb_0x7e7.ReqBody)localObject).user_uin.set(l);
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(a, 2, "reportWPA json error  ", paramString);
        continue;
      }
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2023);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x7e7.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg("OidbSvc.0x7e7_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
      paramString = new JSONObject(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    Object localObject = this.app.a();
    byte[] arrayOfByte = ((ayzl)localObject).d(paramString);
    localObject = ((ayzl)localObject).e(paramString);
    int i;
    if ((arrayOfByte != null) && (localObject != null)) {
      i = 3;
    }
    for (;;)
    {
      int j = 0;
      if (((bfyh)this.app.getManager(165)).a(paramString)) {
        j = 4;
      }
      azqs.b(this.app, "dc00899", "Qidian", paramString, "0X8006DEC", "SigCheck", j, 2, "" + paramInt, "" + i, "" + paramLong, "" + bdin.a(this.app.getApp()));
      return;
      if (arrayOfByte != null) {
        i = 2;
      } else if (localObject != null) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean, double paramDouble1, double paramDouble2, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    mobileqq_qidian.ReqBody localReqBody = a(paramString2, 3, "");
    mobileqq_qidian.ClickReplyCmdActionReqBody localClickReplyCmdActionReqBody = new mobileqq_qidian.ClickReplyCmdActionReqBody();
    localClickReplyCmdActionReqBody.str_key.set(paramString1);
    localClickReplyCmdActionReqBody.uint32_type.set(paramInt1);
    if (paramBoolean)
    {
      localClickReplyCmdActionReqBody.bool_is_need_lbs.set(paramBoolean);
      localClickReplyCmdActionReqBody.double_latitude.set(paramDouble1);
      localClickReplyCmdActionReqBody.double_longitude.set(paramDouble2);
    }
    localClickReplyCmdActionReqBody.uint32_src_type.set(paramInt2);
    localClickReplyCmdActionReqBody.str_menu_title.set(paramString5);
    localClickReplyCmdActionReqBody.uint32_terminal_type.set(1001);
    localClickReplyCmdActionReqBody.uint32_pubno.set(AppSetting.a());
    localReqBody.msg_click_reply_cmd_action_req.set(localClickReplyCmdActionReqBody);
    localReqBody.msg_click_reply_cmd_action_req.setHasFlag(true);
    paramString1 = new HashMap(1);
    paramString1.put("master_uin", paramString2);
    a(localReqBody, "QidianSsoProto.clickReplyCmd", paramString1);
    if (paramInt1 == 1) {
      azqs.b(this.app, "dc00899", "Qidian", paramString4, "0X800849E", "ClickCard", paramInt2, 1, paramString3, "1", null, null);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = this.app.a();
    byte[] arrayOfByte = ((ayzl)localObject).d(paramString);
    localObject = ((ayzl)localObject).e(paramString);
    int i;
    if ((arrayOfByte != null) && (localObject != null))
    {
      i = 3;
      if (!((bfyh)this.app.getManager(165)).a(paramString)) {
        break label181;
      }
    }
    label181:
    for (int j = 4;; j = 0)
    {
      azqs.b(this.app, "dc00899", "Qidian", paramString, "0X8006DEC", "SigCheck", j, 1, "", "" + i, "" + paramLong, "" + bdin.a(this.app.getApp()));
      return;
      if (arrayOfByte != null)
      {
        i = 2;
        break;
      }
      if (localObject != null)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2, 1003, null);
    mobileqq_qidian.CheckMpqqRefuseFlagReq localCheckMpqqRefuseFlagReq = new mobileqq_qidian.CheckMpqqRefuseFlagReq();
    localCheckMpqqRefuseFlagReq.uint64_mpqq_uin.set(Long.parseLong(paramString1));
    localCheckMpqqRefuseFlagReq.uint64_qq_uin.set(this.app.getLongAccountUin());
    paramString2.msg_check_mpqq_refuse_flag_req.set(localCheckMpqqRefuseFlagReq);
    paramString2.msg_check_mpqq_refuse_flag_req.setHasFlag(true);
    a(paramString2, "QidianSsoProto.getShieldStatus", null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = a(paramString2, 1010, paramString3);
    mobileqq_qidian.ClickEManReqBody localClickEManReqBody = new mobileqq_qidian.ClickEManReqBody();
    localClickEManReqBody.str_key.set(paramString1);
    paramString3.msg_click_eman_req.set(localClickEManReqBody);
    paramString1 = new HashMap(1);
    paramString1.put("master_uin", paramString2);
    a(paramString3, "QidianSsoProto.emanClickReport", paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    try
    {
      Oidb_0x7e7.ReqBody localReqBody = new Oidb_0x7e7.ReqBody();
      localReqBody.cmd_id.set(paramInt1);
      localReqBody.platform.set(2);
      localReqBody.timestamp.set(System.currentTimeMillis() / 1000L);
      localReqBody.env.set(paramInt2);
      if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isDigitsOnly(paramString2))) {
        localReqBody.user_uin.set(Long.parseLong(paramString2));
      }
      if ((!TextUtils.isEmpty(paramString3)) && (TextUtils.isDigitsOnly(paramString3))) {
        localReqBody.corp_uin.set(Long.parseLong(paramString3));
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localReqBody.json_string.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2023);
      paramString1.uint32_service_type.set(0);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = createToServiceMsg("OidbSvc.0x7e7_0");
      paramString2.putWupBuffer(paramString1.toByteArray());
      sendPbReq(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(a, 2, "qidianUnifiedReport " + paramString1.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (!TextUtils.isDigitsOnly(paramString1)) || (!TextUtils.isDigitsOnly(paramString2)) || (!TextUtils.isDigitsOnly(paramString3))) {}
    do
    {
      return;
      try
      {
        mobileqq_qidian.ReqBody localReqBody = a(paramString2, 1004, paramString1);
        mobileqq_qidian.NotRecvQdGroupMsgReq localNotRecvQdGroupMsgReq = new mobileqq_qidian.NotRecvQdGroupMsgReq();
        localNotRecvQdGroupMsgReq.uint64_extuin.set(Long.parseLong(paramString1));
        localNotRecvQdGroupMsgReq.uint64_kfuin.set(Long.parseLong(paramString2));
        localNotRecvQdGroupMsgReq.uint64_taskid.set(Long.parseLong(paramString3));
        localReqBody.msg_not_recv_qd_group_msg_req.set(localNotRecvQdGroupMsgReq);
        localReqBody.msg_not_recv_qd_group_msg_req.setHasFlag(true);
        paramString2 = createToServiceMsg("QidianSsoProto.blockBulkMsg");
        paramString2.extraData.putLong("startTime", System.currentTimeMillis());
        paramString2.extraData.putString("extUin", paramString1);
        paramString2.extraData.putLong("uinseq", paramLong);
        paramString2.extraData.putInt("uinType", paramInt);
        paramString2.putWupBuffer(localReqBody.toByteArray());
        super.sendPbReq(paramString2);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.e(a, 2, "blockQdBulkMsg ", paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString2 = a(paramString2, 1002, null);
    mobileqq_qidian.VerifyWpaUinAndKeyReq localVerifyWpaUinAndKeyReq = new mobileqq_qidian.VerifyWpaUinAndKeyReq();
    localVerifyWpaUinAndKeyReq.str_key.set(paramString3);
    localVerifyWpaUinAndKeyReq.uint64_dst_uin.set(Long.parseLong(paramString1));
    if (paramString5 != null) {
      localVerifyWpaUinAndKeyReq.str_json_info.set(paramString5);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localVerifyWpaUinAndKeyReq.str_rkey.set(paramString4);
    }
    localVerifyWpaUinAndKeyReq.uint32_terminal_type.set(2);
    localVerifyWpaUinAndKeyReq.uint32_terminal_version.set(apao.a(this.app.getApp()));
    paramString2.msg_verify_wpa_uin_and_key_req.set(localVerifyWpaUinAndKeyReq);
    paramString2.msg_verify_wpa_uin_and_key_req.setHasFlag(true);
    a(paramString2, "QidianSsoProto.verifyWpaAndKey", null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {}
    try
    {
      mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
      paramString1 = a(paramString1, 1008, "");
      localReqBody.msg_crm_common_head.set(paramString1);
      localReqBody.uint32_sub_cmd.set(1008);
      paramString1 = new mobileqq_qidian.ReqCorpUinWpaReq();
      byte[] arrayOfByte = bdhe.a(paramString2);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        paramString1.bytes_sigt.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      paramString1.uint64_qquin.set(Long.parseLong(this.app.getCurrentAccountUin()));
      paramString1.uint64_touin.set(Long.parseLong(paramString3));
      paramString1.uint32_assign_type.set(Integer.parseInt(paramString4));
      paramString1.uint64_assign_id.set(Long.parseLong(paramString5));
      localReqBody.msg_req_corpuin_wpa_req.set(paramString1);
      paramString1 = new HashMap();
      paramString1.put("key_return_root", paramString6);
      paramString1.put("key_sigt", paramString2);
      paramString1.put("uin", paramString3);
      a(localReqBody, "QidianSsoProto.corpUinWpaReport", paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(a, 2, "corpUinWpaReport ", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
    paramString1 = a(paramString1, 1, "");
    localReqBody.msg_crm_common_head.set(paramString1);
    localReqBody.msg_crm_common_head.setHasFlag(true);
    paramString1 = new mobileqq_qidian.WpaAssignKfextReqBody();
    paramString1.uint32_wpa_type.set(Integer.valueOf(paramString2).intValue());
    paramString1.uint32_wpa_type.setHasFlag(true);
    paramString2 = bdhe.a(paramString3);
    paramString1.bytes_sigT_kf.set(ByteStringMicro.copyFrom(paramString2));
    paramString1.bytes_sigT_kf.setHasFlag(true);
    paramString1.uint64_assign_id.set(Long.valueOf(paramString4).longValue());
    paramString1.uint64_assign_id.setHasFlag(true);
    paramString1.uint64_customer_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    paramString1.uint64_customer_uin.setHasFlag(true);
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString1.str_rkey.set(paramString5);
      paramString1.str_rkey.setHasFlag(true);
    }
    localReqBody.msg_wpa_assign_kfext_req.set(paramString1);
    localReqBody.msg_wpa_assign_kfext_req.setHasFlag(true);
    paramString1 = super.createToServiceMsg("QidianSsoProto.WpaAssignKfext");
    paramString1.extraData.putLong("startTime", System.currentTimeMillis());
    paramString1.extraData.putString("key_return_root", paramString6);
    paramString1.extraData.putInt("ranKey", paramInt);
    paramString1.putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq(paramString1);
    paramString1 = alof.c[bdin.a(this.mApp.getApp().getBaseContext())];
    azqs.b(this.app, "P_CliOper", "Qidian", "", "qidian_wpa_assign", "qidian_wpa_assign", 0, 0, "", "", paramString1, "");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    paramString3 = a(String.valueOf(paramString3), 1012, paramString4);
    if (paramBoolean) {
      paramString3.msg_crm_common_head.uint64_kfaccount.set(Long.valueOf(paramString5).longValue());
    }
    paramString4 = new mobileqq_qidian.QidianWpaAddFriendReqBody();
    paramString4.str_visitID.set(paramString1);
    paramString4.uint64_customer_uin.set(Long.valueOf(paramString2).longValue());
    paramString3.msg_qidian_wpa_addfriend_req.set(paramString4);
    paramString3.msg_qidian_wpa_addfriend_req.setHasFlag(true);
    a(paramString3, "QidianSsoProto.webimAddFriend", null);
  }
  
  public void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
        Object localObject = a("", 2, paramString1);
        localReqBody.msg_crm_common_head.set((MessageMicro)localObject);
        localReqBody.uint32_sub_cmd.set(2);
        localObject = new mobileqq_qidian.WpaSigtToSigMsgReqBody();
        paramString2 = bdhe.a(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0)) {
          ((mobileqq_qidian.WpaSigtToSigMsgReqBody)localObject).bytes_sigT_ext.set(ByteStringMicro.copyFrom(paramString2));
        }
        ((mobileqq_qidian.WpaSigtToSigMsgReqBody)localObject).uint64_kfext_uin.set(Long.parseLong(paramString1));
        localReqBody.msg_wpa_sigt_to_sigmsg_req.set((MessageMicro)localObject);
        if (paramHashMap != null)
        {
          a(localReqBody, "QidianSsoProto.WpaGenSigMsg", paramHashMap);
          return;
        }
        a(localReqBody, "QidianSsoProto.WpaGenSigMsg", null);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "getSigmsgBySigt ", paramString1);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    mobileqq_qidian.ReqBody localReqBody = a(paramString1, 1011, paramString2);
    mobileqq_qidian.CloseSessionReqBody localCloseSessionReqBody = new mobileqq_qidian.CloseSessionReqBody();
    long l;
    if (paramBoolean)
    {
      paramString2 = new mobileqq_qidian.CorpReportInfo();
      if (!TextUtils.isEmpty(paramString1))
      {
        l = Long.valueOf(paramString1).longValue();
        paramString2.uint64_kfuin.set(l);
      }
      localCloseSessionReqBody.msg_corp_report_info.set(paramString2);
    }
    for (;;)
    {
      int i = (int)NetConnInfoCenter.getServerTime();
      localCloseSessionReqBody.uint32_close_session_time.set(i);
      paramString1 = this.app.getCurrentAccountUin();
      localCloseSessionReqBody.uint64_cqq_uin.set(Long.valueOf(paramString1).longValue());
      localReqBody.msg_close_session_req.set(localCloseSessionReqBody);
      a(localReqBody, "QidianSsoProto.closeAIOSessionReport", null);
      return;
      paramString1 = new mobileqq_qidian.ExtReportInfo();
      if (!TextUtils.isEmpty(paramString2))
      {
        l = Long.valueOf(paramString2).longValue();
        paramString1.uint64_ext_uin.set(l);
      }
      localCloseSessionReqBody.msg_ext_report_info.set(paramString1);
    }
  }
  
  public void a(SubMsgType0x92.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_sub_cmd.get();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleQidianSCPushMsg, subcmd =  " + i);
    }
    switch (i)
    {
    default: 
      return;
    }
    b(paramMsgBody);
  }
  
  public void a(Submsgtype0xe5.MsgBody paramMsgBody)
  {
    switch (paramMsgBody.uint32_sub_cmd.get())
    {
    default: 
      return;
    }
    long l = paramMsgBody.msg_s2c_user_get_coupon_for_c_event_push.uint64_kfext.get();
    paramMsgBody = paramMsgBody.msg_s2c_user_get_coupon_for_c_event_push.str_tips_content.get();
    amkl.a(this.app, String.valueOf(l), paramMsgBody, 0, false, false);
  }
  
  public void b(long paramLong)
  {
    new StringBuilder().append("QidianSsoProto.getUserDetailInfo").append(paramLong).toString();
    mobileqq_qidian.ReqBody localReqBody = a("", 4, String.valueOf(paramLong));
    Object localObject = new mobileqq_qidian.GetUserDetailInfoReqBody();
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint32_req_type.set(3);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint32_mobile_client.set(1);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject).uint64_uin.set(paramLong);
    localReqBody.msg_get_user_detail_info_req.set((MessageMicro)localObject);
    localReqBody.msg_get_user_detail_info_req.setHasFlag(true);
    localObject = new HashMap(1);
    ((Map)localObject).put("uin", String.valueOf(paramLong));
    ((Map)localObject).put("req_type", String.valueOf(3));
    a(localReqBody, "QidianSsoProto.getUserDetailInfo", (Map)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new mobileqq_qidian.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg.msg_close_session_rsp.has()) && (paramToServiceMsg.msg_close_session_rsp.msg_ret.has()))
      {
        int i = paramToServiceMsg.msg_close_session_rsp.msg_ret.uint32_ret_code.get();
        if (i == 0)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(a, 2, "handleCloseAIOSessionReport errorCode: " + i);
          return;
        }
        paramToServiceMsg = paramToServiceMsg.msg_close_session_rsp.msg_ret.str_error_msg.get();
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(a, 2, "handleCloseAIOSessionReport errorCode: " + i + " , errorMsg: " + paramToServiceMsg);
      }
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.d(a, 2, "handleCloseAIOSessionReport exception: " + paramToServiceMsg.getMessage());
        return;
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleCloseAIOSessionReport no response");
        }
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    mobileqq_qidian.ReqBody localReqBody = a("", 1018, paramString2);
    mobileqq_qidian.GetQiDianGroupInfoReq localGetQiDianGroupInfoReq = new mobileqq_qidian.GetQiDianGroupInfoReq();
    localGetQiDianGroupInfoReq.uint32_groupcode.set(Integer.valueOf(paramString1).intValue());
    localGetQiDianGroupInfoReq.uint64_groupowner.set(Long.valueOf(paramString2).longValue());
    localReqBody.msg_get_qidian_group_info_req.set(localGetQiDianGroupInfoReq);
    localReqBody.msg_get_qidian_group_info_req.setHasFlag(true);
    paramString2 = new HashMap();
    paramString2.put("uin", paramString1);
    a(localReqBody, "QidianSsoProto.getQidianGroupInfo", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getQidianGroupInfoReq");
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString4 = (TicketManager)this.app.getManager(2);
      if (paramString4 == null)
      {
        paramString4 = null;
        if ((paramString4 != null) && (paramString4.length() != 0)) {
          break label349;
        }
        new beuj(this.app.getApp()).a(2131693562, this.app.getApp().getResources().getDimensionPixelSize(2131298914), 0, 1);
        paramString4 = "";
      }
    }
    for (;;)
    {
      paramString5 = new aspy(paramString1, paramString1, paramString2 + paramString3, 0, -5020, 1245187, ayzl.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 1);
      localBundle.putString("key_action_DATA", paramString4);
      localBundle.putString("key_a_action_DATA", paramString4);
      int i = (paramString2 + paramString3).lastIndexOf(paramString3);
      if (i >= 0) {
        paramString5.a(i, paramString3.length() + i, localBundle);
      }
      paramString2 = new MessageForUniteGrayTip();
      paramString2.hasRead = 0;
      paramString2.initGrayTipMsg(this.app, paramString5);
      aspz.a(this.app, paramString2);
      paramString2 = this.app.getApplication().getBaseContext().getSharedPreferences(this.app.getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
      paramString2.putBoolean(this.app.getCurrentAccountUin() + "_" + paramString1, true);
      paramString2.commit();
      return;
      paramString4 = paramString4.getStweb(this.app.getCurrentAccountUin());
      break;
      label349:
      paramString4 = String.format(paramString5, new Object[] { this.app.getCurrentAccountUin(), paramString4 });
      continue;
      if (TextUtils.isEmpty(paramString4)) {
        paramString4 = "";
      }
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getQidianMasterDetailReq uin: " + paramLong);
    }
    mobileqq_qidian.ReqBody localReqBody = a(String.valueOf(paramLong), 1009, "");
    Object localObject = new mobileqq_qidian.GetCorpUinDetailInfoReqBody();
    ((mobileqq_qidian.GetCorpUinDetailInfoReqBody)localObject).uint64_uin.set(paramLong);
    ((mobileqq_qidian.GetCorpUinDetailInfoReqBody)localObject).uint32_req_type.set(0);
    localReqBody.msg_get_corpuin_detail_info_req_body.set((MessageMicro)localObject);
    localReqBody.msg_get_corpuin_detail_info_req_body.setHasFlag(true);
    localObject = new HashMap(1);
    ((Map)localObject).put("uin", String.valueOf(paramLong));
    ((Map)localObject).put("req_type", String.valueOf(0));
    a(localReqBody, "QidianSsoProto.fetchCorpDetailInfo", (Map)localObject);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.clickReplyCmd");
    if (bool)
    {
      paramFromServiceMsg = new mobileqq_qidian.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.msg_click_reply_cmd_action_rsp.has())
        {
          int i = paramFromServiceMsg.msg_click_reply_cmd_action_rsp.msg_ret.uint32_ret_code.get();
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "handleClickReplyCmd errorCode: " + i);
          }
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("result", Integer.valueOf(i));
          paramFromServiceMsg.put("master_uin", paramToServiceMsg.extraData.get("master_uin"));
          super.notifyUI(1008, bool, paramFromServiceMsg);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleClickReplyCmd no msg_click_reply_cmd_action_rsp");
        }
        super.notifyUI(1008, bool, null);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleClickReplyCmd exception: " + paramToServiceMsg.getMessage());
        }
        super.notifyUI(1008, bool, null);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleClickReplyCmd isSuccess: " + bool);
    }
    super.notifyUI(1008, bool, null);
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getQidianMasterSimpleInfo uin: " + paramLong);
    }
    mobileqq_qidian.ReqBody localReqBody = a(String.valueOf(paramLong), 1009, "");
    Object localObject = new mobileqq_qidian.GetCorpUinDetailInfoReqBody();
    ((mobileqq_qidian.GetCorpUinDetailInfoReqBody)localObject).uint64_uin.set(paramLong);
    ((mobileqq_qidian.GetCorpUinDetailInfoReqBody)localObject).uint32_req_type.set(2);
    localReqBody.msg_get_corpuin_detail_info_req_body.set((MessageMicro)localObject);
    localReqBody.msg_get_corpuin_detail_info_req_body.setHasFlag(true);
    localObject = new HashMap(1);
    ((Map)localObject).put("uin", String.valueOf(paramLong));
    ((Map)localObject).put("req_type", String.valueOf(2));
    a(localReqBody, "QidianSsoProto.fetchCorpDetailInfo", (Map)localObject);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new mobileqq_qidian.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg.msg_click_eman_rsp.has()) && (paramToServiceMsg.msg_click_eman_rsp.msg_ret.has()))
      {
        i = paramToServiceMsg.msg_click_eman_rsp.msg_ret.uint32_ret_code.get();
        if ((i == 0) && (paramToServiceMsg.msg_click_eman_rsp.str_msg.has()))
        {
          paramToServiceMsg = azvd.a(paramToServiceMsg.msg_click_eman_rsp.str_msg.get().getBytes(), 0);
          if ((paramToServiceMsg == null) || ((!(BaseActivity.sTopActivity instanceof SplashActivity)) && (!(BaseActivity.sTopActivity instanceof ChatActivity)))) {
            return;
          }
          paramFromServiceMsg = (FragmentActivity)BaseActivity.sTopActivity;
          if (paramFromServiceMsg.getChatFragment() == null) {
            return;
          }
          acjm.a(this.app, paramFromServiceMsg.getChatFragment().a.a, paramToServiceMsg);
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      int i;
      paramToServiceMsg.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.d(a, 2, "handleEmanClickReport exception: " + paramToServiceMsg.getMessage());
        return;
        paramToServiceMsg = paramToServiceMsg.msg_click_eman_rsp.msg_ret.str_error_msg.get();
        if (QLog.isColorLevel())
        {
          QLog.d(a, 2, "handleEmanClickReport errorCode: " + i + " , errorMsg: " + paramToServiceMsg);
          return;
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "handleEmanClickReport no response");
          }
        }
      }
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.verifyWpaAndKey");
    if (bool2) {
      paramToServiceMsg = new mobileqq_qidian.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_verify_wpa_uin_and_key_rsp.has())
        {
          paramToServiceMsg = (mobileqq_qidian.VerifyWpaUinAndKeyRsp)paramToServiceMsg.msg_verify_wpa_uin_and_key_rsp.get();
          if (paramToServiceMsg.int32_result.get() != 0) {
            break label303;
          }
          bool1 = true;
          if (bool1)
          {
            paramFromServiceMsg = new HashMap();
            paramObject = paramToServiceMsg.str_welcome_word.get();
            int i = paramToServiceMsg.uint32_is_valid.get();
            paramFromServiceMsg.put("welcome", paramObject);
            paramFromServiceMsg.put("result", Integer.valueOf(i));
            super.notifyUI(1002, bool2, paramFromServiceMsg);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "handleVerifyWpaAndKey uint32_ret_code: " + bool1);
          }
          super.notifyUI(1002, bool2, null);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleVerifyWpaAndKey exception: " + paramToServiceMsg.getMessage());
        }
        super.notifyUI(1002, bool2, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleVerifyWpaAndKey no msg_verify_wpa_uin_and_key_rsp");
      }
      super.notifyUI(1002, bool2, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleVerifyWpaAndKey isSuccess: " + bool2);
      }
      super.notifyUI(1002, bool2, null);
      return;
      label303:
      boolean bool1 = false;
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.getShieldStatus");
    if (bool2) {
      paramToServiceMsg = new mobileqq_qidian.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_check_mpqq_refuse_flag_rsp.has())
        {
          paramToServiceMsg = (mobileqq_qidian.CheckMpqqRefuseFlagRsp)paramToServiceMsg.msg_check_mpqq_refuse_flag_rsp.get();
          if (paramToServiceMsg.int32_result.get() != 0) {
            break label290;
          }
          bool1 = true;
          if (bool1)
          {
            paramFromServiceMsg = new HashMap();
            if (paramToServiceMsg.uint32_is_refuse.get() != 1) {
              break label296;
            }
            bool1 = true;
            paramFromServiceMsg.put("result", Boolean.valueOf(bool1));
            super.notifyUI(1003, true, paramFromServiceMsg);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "handleGetShieldStatus uint32_ret_code: " + bool1);
          }
          super.notifyUI(1003, bool2, null);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleGetShieldStatus exception: " + paramToServiceMsg.getMessage());
        }
        super.notifyUI(1003, bool2, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleGetShieldStatus no msg_verify_wpa_uin_and_key_rsp");
      }
      super.notifyUI(1003, bool2, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleGetShieldStatus isSuccess: " + bool2);
      }
      super.notifyUI(1003, bool2, null);
      return;
      label290:
      boolean bool1 = false;
      continue;
      label296:
      bool1 = false;
    }
  }
  
  /* Error */
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: ldc_w 520
    //   7: invokespecial 606	bfzp:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;Ljava/lang/String;)Z
    //   10: istore 6
    //   12: aload_1
    //   13: getfield 128	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 319
    //   19: invokevirtual 1365	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: iload 6
    //   25: ifeq +659 -> 684
    //   28: new 323	com/tencent/qidian/proto/mobileqq_qidian$RspBody
    //   31: dup
    //   32: invokespecial 324	com/tencent/qidian/proto/mobileqq_qidian$RspBody:<init>	()V
    //   35: astore 7
    //   37: aload 7
    //   39: aload_3
    //   40: checkcast 326	[B
    //   43: checkcast 326	[B
    //   46: invokevirtual 330	com/tencent/qidian/proto/mobileqq_qidian$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   49: pop
    //   50: new 307	java/util/HashMap
    //   53: dup
    //   54: invokespecial 308	java/util/HashMap:<init>	()V
    //   57: astore 10
    //   59: aload 7
    //   61: getfield 1369	com/tencent/qidian/proto/mobileqq_qidian$RspBody:msg_subcmd_get_user_detail_info_rsp_body	Lcom/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody;
    //   64: invokevirtual 1372	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:has	()Z
    //   67: ifeq +590 -> 657
    //   70: aload 7
    //   72: getfield 1369	com/tencent/qidian/proto/mobileqq_qidian$RspBody:msg_subcmd_get_user_detail_info_rsp_body	Lcom/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody;
    //   75: invokevirtual 1373	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: checkcast 1371	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody
    //   81: astore 11
    //   83: aload 11
    //   85: getfield 1374	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_ret	Lcom/tencent/qidian/proto/mobileqq_qidian$RetInfo;
    //   88: getfield 346	com/tencent/qidian/proto/mobileqq_qidian$RetInfo:uint32_ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   91: invokevirtual 349	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   94: ifne +655 -> 749
    //   97: iconst_1
    //   98: istore 5
    //   100: iload 5
    //   102: ifeq +510 -> 612
    //   105: aload_1
    //   106: getfield 128	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   109: ldc_w 545
    //   112: invokevirtual 1365	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_1
    //   116: aload_1
    //   117: invokestatic 944	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   120: istore 4
    //   122: aload 11
    //   124: getfield 1378	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_external_info	Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;
    //   127: invokevirtual 1381	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo:has	()Z
    //   130: ifeq +610 -> 740
    //   133: new 1383	com/tencent/qidian/data/QidianExternalInfo
    //   136: dup
    //   137: invokespecial 1384	com/tencent/qidian/data/QidianExternalInfo:<init>	()V
    //   140: astore_1
    //   141: aload_1
    //   142: aload 11
    //   144: getfield 1378	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_external_info	Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;
    //   147: invokevirtual 1385	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 1380	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo
    //   153: invokevirtual 1389	com/tencent/qidian/data/QidianExternalInfo:from	(Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;)V
    //   156: aload 10
    //   158: ldc_w 1391
    //   161: aload_1
    //   162: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: aload_1
    //   167: getfield 1393	com/tencent/qidian/data/QidianExternalInfo:uin	Ljava/lang/String;
    //   170: astore_2
    //   171: aload_2
    //   172: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +570 -> 745
    //   178: aload_0
    //   179: getfield 104	bfzp:mApp	Lcom/tencent/common/app/AppInterface;
    //   182: sipush 165
    //   185: invokevirtual 110	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   188: checkcast 112	bfyh
    //   191: new 1395	com/tencent/qidian/data/BmqqAccountType
    //   194: dup
    //   195: aload_2
    //   196: invokestatic 367	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: iconst_1
    //   200: invokespecial 1397	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   203: invokevirtual 1400	bfyh:a	(Lcom/tencent/qidian/data/BmqqAccountType;)V
    //   206: goto +539 -> 745
    //   209: aload 11
    //   211: getfield 1404	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_internal_info	Lcom/tencent/qidian/proto/mobileqq_qidian$InternalInfo;
    //   214: invokevirtual 1407	com/tencent/qidian/proto/mobileqq_qidian$InternalInfo:has	()Z
    //   217: ifeq +518 -> 735
    //   220: new 1409	com/tencent/qidian/data/QidianInternalInfo
    //   223: dup
    //   224: invokespecial 1410	com/tencent/qidian/data/QidianInternalInfo:<init>	()V
    //   227: astore_3
    //   228: aload_3
    //   229: aload 11
    //   231: getfield 1404	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_internal_info	Lcom/tencent/qidian/proto/mobileqq_qidian$InternalInfo;
    //   234: invokevirtual 1411	com/tencent/qidian/proto/mobileqq_qidian$InternalInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   237: checkcast 1406	com/tencent/qidian/proto/mobileqq_qidian$InternalInfo
    //   240: invokevirtual 1414	com/tencent/qidian/data/QidianInternalInfo:from	(Lcom/tencent/qidian/proto/mobileqq_qidian$InternalInfo;)V
    //   243: aload 10
    //   245: ldc_w 1416
    //   248: aload_3
    //   249: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: aload 11
    //   255: getfield 1420	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_corp_info	Lcom/tencent/qidian/proto/mobileqq_qidian$CorpInfo;
    //   258: invokevirtual 1423	com/tencent/qidian/proto/mobileqq_qidian$CorpInfo:has	()Z
    //   261: ifeq +468 -> 729
    //   264: new 1425	com/tencent/qidian/data/QidianCorpInfo
    //   267: dup
    //   268: invokespecial 1426	com/tencent/qidian/data/QidianCorpInfo:<init>	()V
    //   271: astore 7
    //   273: aload 7
    //   275: aload 11
    //   277: getfield 1420	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:msg_corp_info	Lcom/tencent/qidian/proto/mobileqq_qidian$CorpInfo;
    //   280: invokevirtual 1427	com/tencent/qidian/proto/mobileqq_qidian$CorpInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   283: checkcast 1422	com/tencent/qidian/proto/mobileqq_qidian$CorpInfo
    //   286: invokevirtual 1430	com/tencent/qidian/data/QidianCorpInfo:from	(Lcom/tencent/qidian/proto/mobileqq_qidian$CorpInfo;)V
    //   289: aload 10
    //   291: ldc_w 1432
    //   294: aload 7
    //   296: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   299: pop
    //   300: aconst_null
    //   301: astore 9
    //   303: aload 9
    //   305: astore 8
    //   307: aload_2
    //   308: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifne +46 -> 357
    //   314: aload 9
    //   316: astore 8
    //   318: aload 11
    //   320: getfield 1436	com/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody:rpt_msg_config_group_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   323: invokevirtual 1439	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   326: ifeq +31 -> 357
    //   329: new 1441	com/tencent/qidian/data/QidianProfileUiInfo
    //   332: dup
    //   333: invokespecial 1442	com/tencent/qidian/data/QidianProfileUiInfo:<init>	()V
    //   336: astore 8
    //   338: aload 8
    //   340: aload_2
    //   341: aload 11
    //   343: invokevirtual 1445	com/tencent/qidian/data/QidianProfileUiInfo:from	(Ljava/lang/String;Lcom/tencent/qidian/proto/mobileqq_qidian$GetUserDetailInfoRspBody;)V
    //   346: aload 10
    //   348: ldc_w 1447
    //   351: aload 8
    //   353: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   356: pop
    //   357: iload 4
    //   359: iconst_3
    //   360: if_icmpne +179 -> 539
    //   363: aload_0
    //   364: getfield 104	bfzp:mApp	Lcom/tencent/common/app/AppInterface;
    //   367: sipush 165
    //   370: invokevirtual 110	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   373: checkcast 112	bfyh
    //   376: astore 13
    //   378: aload 13
    //   380: aload_2
    //   381: invokevirtual 1450	bfyh:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianExternalInfo;
    //   384: astore 9
    //   386: aload 9
    //   388: ifnull +9 -> 397
    //   391: aload 9
    //   393: aload_1
    //   394: invokevirtual 1454	com/tencent/qidian/data/QidianExternalInfo:update	(Lcom/tencent/qidian/data/QidianExternalInfo;)V
    //   397: aload 13
    //   399: aload_2
    //   400: invokevirtual 1457	bfyh:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianInternalInfo;
    //   403: astore 11
    //   405: aload 11
    //   407: ifnull +9 -> 416
    //   410: aload 11
    //   412: aload_3
    //   413: invokevirtual 1460	com/tencent/qidian/data/QidianInternalInfo:update	(Lcom/tencent/qidian/data/QidianInternalInfo;)V
    //   416: aload 7
    //   418: aload_1
    //   419: getfield 1463	com/tencent/qidian/data/QidianExternalInfo:masterUin	Ljava/lang/String;
    //   422: putfield 1466	com/tencent/qidian/data/QidianCorpInfo:corpUin	Ljava/lang/String;
    //   425: aload 13
    //   427: aload 7
    //   429: getfield 1466	com/tencent/qidian/data/QidianCorpInfo:corpUin	Ljava/lang/String;
    //   432: invokevirtual 1469	bfyh:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianCorpInfo;
    //   435: astore 12
    //   437: aload 12
    //   439: ifnull +10 -> 449
    //   442: aload 12
    //   444: aload 7
    //   446: invokevirtual 1472	com/tencent/qidian/data/QidianCorpInfo:update	(Lcom/tencent/qidian/data/QidianCorpInfo;)V
    //   449: aload 13
    //   451: aload_2
    //   452: invokevirtual 1475	bfyh:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianProfileUiInfo;
    //   455: astore_2
    //   456: aload 9
    //   458: ifnull +290 -> 748
    //   461: aload 11
    //   463: ifnull +285 -> 748
    //   466: aload 12
    //   468: ifnull +280 -> 748
    //   471: aload_2
    //   472: ifnull +276 -> 748
    //   475: aload 10
    //   477: ldc_w 1391
    //   480: aload 9
    //   482: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload 10
    //   488: ldc_w 1416
    //   491: aload 11
    //   493: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   496: pop
    //   497: aload 10
    //   499: ldc_w 1432
    //   502: aload 12
    //   504: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: aload 10
    //   510: ldc_w 1447
    //   513: aload_2
    //   514: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   517: pop
    //   518: aload_0
    //   519: aload_1
    //   520: aload_3
    //   521: aload 7
    //   523: aload 8
    //   525: invokespecial 1476	bfzp:a	(Lcom/tencent/qidian/data/QidianExternalInfo;Lcom/tencent/qidian/data/QidianInternalInfo;Lcom/tencent/qidian/data/QidianCorpInfo;Lcom/tencent/qidian/data/QidianProfileUiInfo;)V
    //   528: aload_0
    //   529: sipush 1001
    //   532: iconst_1
    //   533: aload 10
    //   535: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   538: return
    //   539: aload_0
    //   540: aload_1
    //   541: aload_3
    //   542: aload 7
    //   544: aload 8
    //   546: invokespecial 1476	bfzp:a	(Lcom/tencent/qidian/data/QidianExternalInfo;Lcom/tencent/qidian/data/QidianInternalInfo;Lcom/tencent/qidian/data/QidianCorpInfo;Lcom/tencent/qidian/data/QidianProfileUiInfo;)V
    //   549: aload_0
    //   550: sipush 1001
    //   553: iconst_1
    //   554: aload 10
    //   556: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   559: return
    //   560: astore_1
    //   561: aload_1
    //   562: invokevirtual 1095	java/lang/Exception:printStackTrace	()V
    //   565: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +33 -> 601
    //   571: getstatic 16	bfzp:a	Ljava/lang/String;
    //   574: iconst_2
    //   575: new 236	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 1478
    //   585: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_1
    //   589: invokevirtual 863	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   592: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload_0
    //   602: sipush 1001
    //   605: iload 6
    //   607: aconst_null
    //   608: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   611: return
    //   612: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +31 -> 646
    //   618: getstatic 16	bfzp:a	Ljava/lang/String;
    //   621: iconst_2
    //   622: new 236	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   629: ldc_w 1480
    //   632: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload 5
    //   637: invokevirtual 1257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   640: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: aload_0
    //   647: sipush 1001
    //   650: iload 6
    //   652: aconst_null
    //   653: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   656: return
    //   657: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   660: ifeq +13 -> 673
    //   663: getstatic 16	bfzp:a	Ljava/lang/String;
    //   666: iconst_2
    //   667: ldc_w 1482
    //   670: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: aload_0
    //   674: sipush 1001
    //   677: iload 6
    //   679: aconst_null
    //   680: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   683: return
    //   684: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +31 -> 718
    //   690: getstatic 16	bfzp:a	Ljava/lang/String;
    //   693: iconst_2
    //   694: new 236	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 1484
    //   704: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: iload 6
    //   709: invokevirtual 1257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   712: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload_0
    //   719: sipush 1001
    //   722: iload 6
    //   724: aconst_null
    //   725: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   728: return
    //   729: aconst_null
    //   730: astore 7
    //   732: goto -432 -> 300
    //   735: aconst_null
    //   736: astore_3
    //   737: goto -484 -> 253
    //   740: aconst_null
    //   741: astore_1
    //   742: goto -533 -> 209
    //   745: goto -536 -> 209
    //   748: return
    //   749: iconst_0
    //   750: istore 5
    //   752: goto -652 -> 100
    //   755: astore_1
    //   756: iconst_2
    //   757: istore 4
    //   759: goto -637 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	bfzp
    //   0	762	1	paramToServiceMsg	ToServiceMsg
    //   0	762	2	paramFromServiceMsg	FromServiceMsg
    //   0	762	3	paramObject	Object
    //   120	638	4	i	int
    //   98	653	5	bool1	boolean
    //   10	713	6	bool2	boolean
    //   35	696	7	localObject1	Object
    //   305	240	8	localObject2	Object
    //   301	180	9	localQidianExternalInfo	QidianExternalInfo
    //   57	498	10	localHashMap	HashMap
    //   81	411	11	localObject3	Object
    //   435	68	12	localQidianCorpInfo	QidianCorpInfo
    //   376	74	13	localbfyh	bfyh
    // Exception table:
    //   from	to	target	type
    //   37	97	560	java/lang/Exception
    //   105	116	560	java/lang/Exception
    //   122	206	560	java/lang/Exception
    //   209	253	560	java/lang/Exception
    //   253	300	560	java/lang/Exception
    //   307	314	560	java/lang/Exception
    //   318	357	560	java/lang/Exception
    //   363	386	560	java/lang/Exception
    //   391	397	560	java/lang/Exception
    //   397	405	560	java/lang/Exception
    //   410	416	560	java/lang/Exception
    //   416	437	560	java/lang/Exception
    //   442	449	560	java/lang/Exception
    //   449	456	560	java/lang/Exception
    //   475	538	560	java/lang/Exception
    //   539	559	560	java/lang/Exception
    //   612	646	560	java/lang/Exception
    //   646	656	560	java/lang/Exception
    //   657	673	560	java/lang/Exception
    //   673	683	560	java/lang/Exception
    //   116	122	755	java/lang/Exception
  }
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
        {
          i = 1;
          if (i != 0)
          {
            paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            paramFromServiceMsg = new Oidb_0x7e7.RspBody();
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if (paramFromServiceMsg.ret_code.has()) {
              paramFromServiceMsg.ret_code.get();
            }
            if (paramFromServiceMsg.ret_msg.has()) {
              paramFromServiceMsg.ret_msg.get().toString();
            }
          }
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(a, 2, "handleReportWPA ", paramToServiceMsg);
      }
      i = 0;
    }
  }
  
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.getCustomerTransferInfo");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("kfext");
    if (bool) {
      paramFromServiceMsg = new mobileqq_qidian.RspBody();
    }
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg.msg_get_customer_transfer_info_rsp.has())
      {
        paramFromServiceMsg = (mobileqq_qidian.GetCustomerTransferInfoRspBody)paramFromServiceMsg.msg_get_customer_transfer_info_rsp.get();
        if (paramFromServiceMsg.msg_ret.uint32_ret_code.get() == 0) {
          b(paramToServiceMsg, paramFromServiceMsg.str_transfer_info.get(), paramFromServiceMsg.str_link_info.get(), paramFromServiceMsg.str_link_url.get(), paramFromServiceMsg.str_pt_url.get());
        }
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(a, 2, "handleGetCustomerTransferInfo ", paramToServiceMsg);
    }
  }
  
  public void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e(a, 2, "handleGetNavigationConfig");
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new mobileqq_qidian.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramToServiceMsg.msg_get_navigation_menu_config_rsp_body.has()) {
          break label208;
        }
        paramToServiceMsg = (mobileqq_qidian.GetNavigationMenuConfigRspBody)paramToServiceMsg.msg_get_navigation_menu_config_rsp_body.get();
        if (paramToServiceMsg.msg_ret.uint32_ret_code.get() == 0)
        {
          paramFromServiceMsg = new bfzq();
          paramFromServiceMsg.jdField_a_of_type_Int = paramToServiceMsg.int32_is_show.get();
          paramFromServiceMsg.jdField_b_of_type_Int = paramToServiceMsg.uint32_ver_no.get();
          paramFromServiceMsg.jdField_a_of_type_Long = paramToServiceMsg.uint64_puin.get();
          paramFromServiceMsg.jdField_b_of_type_Long = paramToServiceMsg.uint64_kf_uin.get();
          paramFromServiceMsg.c = paramToServiceMsg.uint32_is_show_graytip.get();
          notifyUI(1006, true, paramFromServiceMsg);
          return;
        }
        notifyUI(1006, false, null);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(a, 2, "handleGetNavigationConfig error return");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(1006, false, null);
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d(a, 2, "handleGetNavigationConfig ", paramToServiceMsg);
      return;
      label208:
      notifyUI(1006, false, null);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleGetNavigationConfig without body");
      }
    }
    else
    {
      notifyUI(1006, false, null);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleGetNavigationConfig-false");
      }
    }
  }
  
  /* Error */
  public void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: ldc_w 1235
    //   7: invokespecial 606	bfzp:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;Ljava/lang/String;)Z
    //   10: istore 5
    //   12: aload_1
    //   13: getfield 128	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 319
    //   19: invokevirtual 1365	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: iload 5
    //   25: ifeq +413 -> 438
    //   28: new 323	com/tencent/qidian/proto/mobileqq_qidian$RspBody
    //   31: dup
    //   32: invokespecial 324	com/tencent/qidian/proto/mobileqq_qidian$RspBody:<init>	()V
    //   35: astore 6
    //   37: aload 6
    //   39: aload_3
    //   40: checkcast 326	[B
    //   43: checkcast 326	[B
    //   46: invokevirtual 330	com/tencent/qidian/proto/mobileqq_qidian$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   49: pop
    //   50: new 307	java/util/HashMap
    //   53: dup
    //   54: invokespecial 308	java/util/HashMap:<init>	()V
    //   57: astore 7
    //   59: aload 6
    //   61: getfield 1571	com/tencent/qidian/proto/mobileqq_qidian$RspBody:msg_get_corpuin_detail_info_rsp_body	Lcom/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody;
    //   64: invokevirtual 1574	com/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody:has	()Z
    //   67: ifeq +361 -> 428
    //   70: aload 6
    //   72: getfield 1571	com/tencent/qidian/proto/mobileqq_qidian$RspBody:msg_get_corpuin_detail_info_rsp_body	Lcom/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody;
    //   75: invokevirtual 1575	com/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: checkcast 1573	com/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody
    //   81: astore 8
    //   83: aload 8
    //   85: getfield 1578	com/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody:int32_ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   88: invokevirtual 442	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   91: ifne +414 -> 505
    //   94: iconst_1
    //   95: istore 4
    //   97: iload 4
    //   99: ifeq +319 -> 418
    //   102: aload_1
    //   103: getfield 128	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   106: ldc_w 545
    //   109: invokevirtual 1365	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 944	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   117: istore 4
    //   119: aload 8
    //   121: getfield 1579	com/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody:msg_external_info	Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;
    //   124: invokevirtual 1381	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo:has	()Z
    //   127: ifeq +361 -> 488
    //   130: new 1383	com/tencent/qidian/data/QidianExternalInfo
    //   133: dup
    //   134: invokespecial 1384	com/tencent/qidian/data/QidianExternalInfo:<init>	()V
    //   137: astore_3
    //   138: aload 8
    //   140: getfield 1579	com/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody:msg_external_info	Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;
    //   143: invokevirtual 1385	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   146: checkcast 1380	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo
    //   149: astore 6
    //   151: aload_3
    //   152: aload 6
    //   154: invokevirtual 1389	com/tencent/qidian/data/QidianExternalInfo:from	(Lcom/tencent/qidian/proto/mobileqq_qidian$ExternalInfo;)V
    //   157: aload_0
    //   158: getfield 104	bfzp:mApp	Lcom/tencent/common/app/AppInterface;
    //   161: sipush 165
    //   164: invokevirtual 110	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   167: checkcast 112	bfyh
    //   170: astore 9
    //   172: aload 9
    //   174: aload_2
    //   175: invokevirtual 1450	bfyh:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianExternalInfo;
    //   178: astore_1
    //   179: aload_1
    //   180: ifnull +216 -> 396
    //   183: iload 4
    //   185: iconst_2
    //   186: if_icmpne +127 -> 313
    //   189: aload_1
    //   190: aload_3
    //   191: getfield 1582	com/tencent/qidian/data/QidianExternalInfo:isShowVideoCall	I
    //   194: putfield 1582	com/tencent/qidian/data/QidianExternalInfo:isShowVideoCall	I
    //   197: aload 7
    //   199: ldc_w 1391
    //   202: aload_1
    //   203: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: aload_3
    //   208: getfield 1393	com/tencent/qidian/data/QidianExternalInfo:uin	Ljava/lang/String;
    //   211: astore 6
    //   213: aload 6
    //   215: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifne +279 -> 497
    //   221: aload 9
    //   223: new 1395	com/tencent/qidian/data/BmqqAccountType
    //   226: dup
    //   227: aload 6
    //   229: invokestatic 367	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   232: bipush 6
    //   234: invokespecial 1397	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   237: invokevirtual 1400	bfyh:a	(Lcom/tencent/qidian/data/BmqqAccountType;)V
    //   240: goto +257 -> 497
    //   243: aload_3
    //   244: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne +236 -> 483
    //   250: aload 8
    //   252: getfield 1583	com/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody:rpt_msg_config_group_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   255: invokevirtual 1439	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   258: ifeq +225 -> 483
    //   261: new 1441	com/tencent/qidian/data/QidianProfileUiInfo
    //   264: dup
    //   265: invokespecial 1442	com/tencent/qidian/data/QidianProfileUiInfo:<init>	()V
    //   268: astore 6
    //   270: aload 6
    //   272: aload_3
    //   273: aload 8
    //   275: invokevirtual 1586	com/tencent/qidian/data/QidianProfileUiInfo:from	(Ljava/lang/String;Lcom/tencent/qidian/proto/mobileqq_qidian$GetCorpUinDetailInfoRspBody;)V
    //   278: aload 7
    //   280: ldc_w 1447
    //   283: aload 6
    //   285: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: pop
    //   289: aload 6
    //   291: astore_3
    //   292: aload_1
    //   293: ifnull +116 -> 409
    //   296: aload_0
    //   297: aload_1
    //   298: aload_3
    //   299: invokespecial 1587	bfzp:a	(Lcom/tencent/qidian/data/QidianExternalInfo;Lcom/tencent/qidian/data/QidianProfileUiInfo;)V
    //   302: aload_0
    //   303: sipush 1009
    //   306: iconst_1
    //   307: aload 7
    //   309: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   312: return
    //   313: iload 4
    //   315: ifne -118 -> 197
    //   318: aload 6
    //   320: getfield 1590	com/tencent/qidian/proto/mobileqq_qidian$ExternalInfo:uint32_videoshow	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   323: invokevirtual 1493	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   326: ifne +11 -> 337
    //   329: aload_3
    //   330: aload_1
    //   331: getfield 1582	com/tencent/qidian/data/QidianExternalInfo:isShowVideoCall	I
    //   334: putfield 1582	com/tencent/qidian/data/QidianExternalInfo:isShowVideoCall	I
    //   337: aload_1
    //   338: aload_3
    //   339: invokevirtual 1454	com/tencent/qidian/data/QidianExternalInfo:update	(Lcom/tencent/qidian/data/QidianExternalInfo;)V
    //   342: goto -145 -> 197
    //   345: astore_1
    //   346: aload_1
    //   347: invokevirtual 1095	java/lang/Exception:printStackTrace	()V
    //   350: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +33 -> 386
    //   356: getstatic 16	bfzp:a	Ljava/lang/String;
    //   359: iconst_2
    //   360: new 236	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 1592
    //   370: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_1
    //   374: invokevirtual 863	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   377: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload_0
    //   387: sipush 1009
    //   390: iconst_0
    //   391: aconst_null
    //   392: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   395: return
    //   396: aload 7
    //   398: ldc_w 1391
    //   401: aload_3
    //   402: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: goto -199 -> 207
    //   409: aload_0
    //   410: aload_2
    //   411: aload_3
    //   412: invokespecial 1587	bfzp:a	(Lcom/tencent/qidian/data/QidianExternalInfo;Lcom/tencent/qidian/data/QidianProfileUiInfo;)V
    //   415: goto -113 -> 302
    //   418: aload_0
    //   419: sipush 1009
    //   422: iconst_0
    //   423: aconst_null
    //   424: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   427: return
    //   428: aload_0
    //   429: sipush 1009
    //   432: iconst_0
    //   433: aconst_null
    //   434: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   437: return
    //   438: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq +31 -> 472
    //   444: getstatic 16	bfzp:a	Ljava/lang/String;
    //   447: iconst_2
    //   448: new 236	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 1594
    //   458: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: iload 5
    //   463: invokevirtual 1257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   466: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: aload_0
    //   473: sipush 1009
    //   476: iload 5
    //   478: aconst_null
    //   479: invokespecial 1248	alpd:notifyUI	(IZLjava/lang/Object;)V
    //   482: return
    //   483: aconst_null
    //   484: astore_3
    //   485: goto -193 -> 292
    //   488: aload_2
    //   489: astore_3
    //   490: aconst_null
    //   491: astore_2
    //   492: aconst_null
    //   493: astore_1
    //   494: goto -251 -> 243
    //   497: aload_3
    //   498: astore_2
    //   499: aload 6
    //   501: astore_3
    //   502: goto -259 -> 243
    //   505: iconst_0
    //   506: istore 4
    //   508: goto -411 -> 97
    //   511: astore_1
    //   512: iconst_0
    //   513: istore 4
    //   515: goto -396 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	this	bfzp
    //   0	518	1	paramToServiceMsg	ToServiceMsg
    //   0	518	2	paramFromServiceMsg	FromServiceMsg
    //   0	518	3	paramObject	Object
    //   95	419	4	i	int
    //   10	467	5	bool	boolean
    //   35	465	6	localObject	Object
    //   57	340	7	localHashMap	HashMap
    //   81	193	8	localGetCorpUinDetailInfoRspBody	com.tencent.qidian.proto.mobileqq_qidian.GetCorpUinDetailInfoRspBody
    //   170	52	9	localbfyh	bfyh
    // Exception table:
    //   from	to	target	type
    //   37	94	345	java/lang/Exception
    //   102	113	345	java/lang/Exception
    //   119	179	345	java/lang/Exception
    //   189	197	345	java/lang/Exception
    //   197	207	345	java/lang/Exception
    //   207	240	345	java/lang/Exception
    //   243	289	345	java/lang/Exception
    //   296	302	345	java/lang/Exception
    //   302	312	345	java/lang/Exception
    //   318	337	345	java/lang/Exception
    //   337	342	345	java/lang/Exception
    //   396	406	345	java/lang/Exception
    //   409	415	345	java/lang/Exception
    //   418	427	345	java/lang/Exception
    //   428	437	345	java/lang/Exception
    //   113	119	511	java/lang/Exception
  }
  
  public void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (paramObject != null)
      {
        try
        {
          paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.get() == 0))
          {
            if ((!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
              return;
            }
            paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
            int i = paramFromServiceMsg[0];
            if (i == 0)
            {
              bdqa.a(paramFromServiceMsg, 1);
              bdqa.a(paramFromServiceMsg, 3);
              i = bdqa.a(paramFromServiceMsg, 5);
              paramToServiceMsg = new byte[i];
              bdqa.b(paramFromServiceMsg, 7, paramToServiceMsg, i);
              paramToServiceMsg = bdqa.a(paramToServiceMsg, 0, i);
              i += 7;
              bdqa.a(paramFromServiceMsg, i);
              i += 2;
              int j = bdqa.a(paramFromServiceMsg, i);
              paramObject = new byte[j];
              bdqa.b(paramFromServiceMsg, i + 2, paramObject, j);
              paramFromServiceMsg = bdqa.a(paramObject, 0, j);
              paramObject = new HashMap();
              paramObject.put("plain_text", paramToServiceMsg);
              paramObject.put("cipher_text", paramFromServiceMsg);
              notifyUI(1019, true, paramObject);
              return;
            }
            QLog.d(a, 2, "handleQidianPrivateTroopUin result is " + i);
            notifyUI(1019, false, null);
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "handleQidianPrivateTroopUin throw exception is " + paramToServiceMsg.toString());
          }
          notifyUI(1019, false, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleQidianPrivateTroopUin pkg is null");
        }
        notifyUI(1019, false, null);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "handleQidianPrivateTroopUin data is null");
        }
        notifyUI(1019, false, null);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "handleQidianPrivateTroopUin res is fail");
      }
      notifyUI(1019, false, null);
    }
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return bfzo.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onReceive cmd: " + str);
    }
    if (str.equalsIgnoreCase("QidianSsoProto.WpaAssignKfext")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (str.equalsIgnoreCase("QidianSsoProto.clickReplyCmd"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.getUserDetailInfo"))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.verifyWpaAndKey"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.getShieldStatus"))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("OidbSvc.0x7e7_0"))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.blockBulkMsg"))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.getCustomerTransferInfo"))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.getNavigationConfig"))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.corpUinWpaReport"))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.emanClickReport"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equals("QidianSsoProto.fetchCorpDetailInfo"))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.closeAIOSessionReport"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.WpaGenSigMsg"))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.webimAddFriend"))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (str.equalsIgnoreCase("QidianSsoProto.getQidianGroupInfo"))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!str.equalsIgnoreCase("OidbSvc.0x782"));
    l(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfzp
 * JD-Core Version:    0.7.0.1
 */