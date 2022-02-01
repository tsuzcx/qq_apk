package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.device_lock_query_status.ReqBody;
import com.tencent.ims.device_lock_query_status.RspBody;
import com.tencent.ims.get_config.ReqBody;
import com.tencent.ims.get_config.RspBody;
import com.tencent.ims.wx_msg_opt.ReqBody;
import com.tencent.ims.wx_msg_opt.RspBody;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mqp.app.sec.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.SecSvcHandlerHelper;
import com.tencent.qqprotect.singleupdate.QPUpdateManager;
import java.nio.ByteBuffer;
import java.util.List;
import tencent.im.oidb.cmd0x614.Oidb_0x614.DeviceManageHead;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReNameDeviceNameReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614.RspBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.PhoneInfo;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.ReqBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.RspBody;
import tencent.im.oidb.cmd0xebd.oidb_0xebd.RspBody;
import tencent.im.oidb.cmd0xec0.oidb_0xec0.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.AccountExceptionAlertBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.MsgBody;

public class SecSvcHandler
  extends BusinessHandler
{
  private int a = 1;
  private QQAppInterface b;
  
  SecSvcHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  private void a(int paramInt, SubMsgType0xc6.AccountExceptionAlertBody paramAccountExceptionAlertBody)
  {
    if (paramAccountExceptionAlertBody == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcHandler", 2, "account exception alert, null body");
      }
      return;
    }
    if (!this.b.isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcHandler", 2, "user not logined, no alert");
      }
      return;
    }
    String str1;
    if (paramAccountExceptionAlertBody.str_title.has()) {
      str1 = paramAccountExceptionAlertBody.str_title.get();
    } else {
      str1 = "";
    }
    String str2;
    if (paramAccountExceptionAlertBody.str_content.has()) {
      str2 = paramAccountExceptionAlertBody.str_content.get();
    } else {
      str2 = "";
    }
    String str3;
    if (paramAccountExceptionAlertBody.str_left_button_text.has()) {
      str3 = paramAccountExceptionAlertBody.str_left_button_text.get();
    } else {
      str3 = "";
    }
    String str4;
    if (paramAccountExceptionAlertBody.str_right_button_text.has()) {
      str4 = paramAccountExceptionAlertBody.str_right_button_text.get();
    } else {
      str4 = "";
    }
    String str5;
    if (paramAccountExceptionAlertBody.str_right_button_link.has()) {
      str5 = paramAccountExceptionAlertBody.str_right_button_link.get();
    } else {
      str5 = "";
    }
    int i;
    if (paramAccountExceptionAlertBody.uint32_left_button_id.has()) {
      i = paramAccountExceptionAlertBody.uint32_left_button_id.get();
    } else {
      i = 0;
    }
    int j;
    if (paramAccountExceptionAlertBody.uint32_right_button_id.has()) {
      j = paramAccountExceptionAlertBody.uint32_right_button_id.get();
    } else {
      j = 0;
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcHandler", 2, String.format("cmd=%d, args: title=%s, msg=%s, lbtn=%s, rbtn=%s, url=%s,lbip=%d, rbid=%d", new Object[] { Integer.valueOf(paramInt), str1, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(j) }));
      }
      new Handler(Looper.getMainLooper()).post(new SecSvcHandler.1(this, str1, str2, str3, str4, str5, i, j, paramInt));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "empty title or content, or no buttons, so no alert");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool4 = false;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramToServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = new Bundle();
        bool1 = bool3;
        try
        {
          if (localOIDBSSOPkg.uint32_result.has())
          {
            bool2 = bool4;
            bool1 = bool3;
            if (localOIDBSSOPkg.uint32_result.get() == 0) {
              bool2 = true;
            }
            bool1 = bool2;
            paramToServiceMsg.putInt("ret_code", localOIDBSSOPkg.uint32_result.get());
          }
          bool1 = bool2;
          bool3 = bool2;
          paramObject = paramToServiceMsg;
          if (!localOIDBSSOPkg.str_error_msg.has()) {
            break label223;
          }
          bool1 = bool2;
          paramToServiceMsg.putString("err_msg", localOIDBSSOPkg.str_error_msg.get());
          bool3 = bool2;
          paramObject = paramToServiceMsg;
        }
        catch (Exception paramFromServiceMsg) {}
        bool3 = bool1;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg = null;
      }
      paramObject = paramToServiceMsg;
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onUnbindPhoneNumLogin error:");
        paramObject.append(paramFromServiceMsg.getMessage());
        QLog.d("SecSvcHandler", 2, paramObject.toString());
        paramObject = paramToServiceMsg;
        bool3 = bool1;
      }
      label223:
      notifyUI(8, bool3, paramObject);
      return;
    }
    notifyUI(8, false, Integer.valueOf(-1));
  }
  
  private void a(oidb_0xeb8.RspBody paramRspBody, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramRspBody.str_mibao_change_url.has()) {
      paramBundle.putString("mibao_change_url", paramRspBody.str_mibao_change_url.get());
    }
    if (paramRspBody.str_mibao_set_url.has()) {
      paramBundle.putString("mibao_set_url", paramRspBody.str_mibao_set_url.get());
    }
    if (paramRspBody.str_mibao_verify_url.has()) {
      paramBundle.putString("mibao_verify_url", paramRspBody.str_mibao_verify_url.get());
    }
    if (paramRspBody.str_hori_bar_tips.has()) {
      paramBundle.putString("str_hori_bar_tips", paramRspBody.str_hori_bar_tips.get());
    }
    if (paramRspBody.str_red_dot_tips.has()) {
      paramBundle.putString("str_red_dot_tips", paramRspBody.str_red_dot_tips.get());
    }
    if (paramRspBody.bool_is_IOT.get())
    {
      paramBundle.putBoolean("bool_is_IOT", true);
      paramBundle.putString("verify_phone_url", paramRspBody.str_verify_premibao_url.get());
    }
    if (paramRspBody.rpt_phone_info.has())
    {
      List localList = paramRspBody.rpt_phone_info.get();
      Bundle[] arrayOfBundle = new Bundle[localList.size()];
      int i = 0;
      while (i < localList.size())
      {
        oidb_0xeb8.PhoneInfo localPhoneInfo = (oidb_0xeb8.PhoneInfo)localList.get(i);
        if (localPhoneInfo != null)
        {
          Bundle localBundle = new Bundle();
          int j = -1;
          int k;
          if (localPhoneInfo.uint32_phone_type.has())
          {
            k = localPhoneInfo.uint32_phone_type.get();
            localBundle.putInt("phone_type", k);
            j = k;
            if (k == 4)
            {
              paramBundle.putBoolean("phone_verified", false);
              paramBundle.putString("phone_unverified_number", localPhoneInfo.str_phone.get());
              paramBundle.putString("verify_phone_url", paramRspBody.str_verify_premibao_url.get());
              j = k;
            }
          }
          if (localPhoneInfo.str_country_code.has())
          {
            localBundle.putString("country_code", localPhoneInfo.str_country_code.get());
            if (j == 1) {
              paramBundle.putString("country_code", localPhoneInfo.str_country_code.get());
            }
          }
          if (localPhoneInfo.str_phone.has())
          {
            localBundle.putString("phone", localPhoneInfo.str_phone.get());
            paramBundle.putString("phone", localPhoneInfo.str_phone.get());
            if (j == 1) {
              paramBundle.putString("phone", localPhoneInfo.str_phone.get());
            }
          }
          boolean bool = paramBoolean;
          if (localPhoneInfo.uint32_phone_status.has())
          {
            k = localPhoneInfo.uint32_phone_status.get();
            localBundle.putInt("status", k);
            if (j == 1) {
              paramBundle.putInt("status", k);
            }
            bool = paramBoolean;
            if (k == 4)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onGetNewPhoneUnityInfo: get phone type: ");
              localStringBuilder.append(j);
              localStringBuilder.append(" fail.");
              QLog.e("SecSvcHandler", 1, localStringBuilder.toString());
              bool = false;
            }
          }
          if (localPhoneInfo.bytes_vas_phone.has()) {
            localBundle.putByteArray("vaskey", localPhoneInfo.bytes_vas_phone.get().toByteArray());
          }
          arrayOfBundle[i] = localBundle;
          paramBoolean = bool;
        }
        i += 1;
      }
      paramBundle.putParcelableArray("phone_info", arrayOfBundle);
      ((PhoneUnityManager)this.b.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).a(paramBundle);
      paramBundle.putBoolean("is_all_phone_get", paramBoolean);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramToServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xebd.RspBody()) == 0)
      {
        notifyUI(10, true, paramToServiceMsg.getAttribute("open_close_contacts", localBoolean));
        return;
      }
      notifyUI(10, false, paramToServiceMsg.getAttribute("open_close_contacts", localBoolean));
      return;
    }
    if (paramToServiceMsg == null) {
      paramToServiceMsg = localBoolean;
    } else {
      paramToServiceMsg = paramToServiceMsg.getAttribute("open_close_contacts", localBoolean);
    }
    notifyUI(10, false, paramToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool1 = bool3;
    paramToServiceMsg = localObject3;
    if (paramObject != null)
    {
      bool1 = bool3;
      paramToServiceMsg = localObject3;
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label279;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        bool1 = bool3;
        paramToServiceMsg = localObject3;
        if (paramObject.uint32_result.get() != 0) {
          break label279;
        }
        bool1 = bool3;
        paramToServiceMsg = localObject3;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label279;
        }
        paramFromServiceMsg = new oidb_0xeb8.RspBody();
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        int j = paramFromServiceMsg.uint32_check_result.get();
        bool1 = bool3;
        paramToServiceMsg = localObject3;
        if (j <= 0) {
          break label279;
        }
        if (j != 4) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        try
        {
          paramToServiceMsg = new Bundle();
          try
          {
            paramToServiceMsg.putInt("check_result", j);
            if (j == 3) {
              i = 1;
            }
            paramToServiceMsg.putInt("need_unify", i);
            a(paramFromServiceMsg, paramToServiceMsg, bool1);
            bool1 = true;
          }
          catch (Exception paramObject)
          {
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramObject;
          }
          bool2 = true;
        }
        catch (Exception paramToServiceMsg)
        {
          paramFromServiceMsg = localObject1;
        }
        paramObject = paramToServiceMsg;
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = localObject2;
      }
      bool1 = bool2;
      paramToServiceMsg = paramFromServiceMsg;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("onGetPhoneBindInfo error:");
        paramToServiceMsg.append(paramObject.getMessage());
        QLog.d("SecSvcHandler", 2, paramToServiceMsg.toString());
        paramToServiceMsg = paramFromServiceMsg;
        bool1 = bool2;
      }
    }
    label279:
    notifyUI(5, bool1, paramToServiceMsg);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        get_config.RspBody localRspBody = new get_config.RspBody();
        localRspBody.mergeFrom((byte[])paramObject);
        paramObject = new Bundle();
        if (!localRspBody.u32_proto_version.has()) {
          break label305;
        }
        i = localRspBody.u32_proto_version.get();
        paramObject.putInt("proto_version", i);
        boolean bool = localRspBody.str_config_name.has();
        paramFromServiceMsg = "";
        if (!bool) {
          break label311;
        }
        paramToServiceMsg = localRspBody.str_config_name.get();
        paramObject.putString("config_name", paramToServiceMsg);
        if (!localRspBody.u32_config_version.has()) {
          break label317;
        }
        i = localRspBody.u32_config_version.get();
        paramObject.putInt("config_version", i);
        i = j;
        if (localRspBody.u32_effect_time.has()) {
          i = localRspBody.u32_effect_time.get();
        }
        paramObject.putInt("effect_time", i);
        if (!localRspBody.str_md5.has()) {
          break label323;
        }
        paramToServiceMsg = localRspBody.str_md5.get();
        paramObject.putString("md5", paramToServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
        if (localRspBody.str_download_link.has()) {
          paramToServiceMsg = localRspBody.str_download_link.get();
        }
        paramObject.putString("download_url", paramToServiceMsg);
        notifyUI(1, true, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onGetAntiFraudConfig error:");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("SecSvcHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      notifyUI(1, false, null);
      return;
      label305:
      int i = 1;
      continue;
      label311:
      paramToServiceMsg = "";
      continue;
      label317:
      i = 0;
      continue;
      label323:
      paramToServiceMsg = "";
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      paramObject = new wx_msg_opt.RspBody();
    }
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (!paramObject.uint32_cmd.has()) {
          break label220;
        }
        i = paramObject.uint32_cmd.get();
        paramFromServiceMsg.putInt("cmd", i);
        i = -1;
        if (paramObject.uint32_ret.has()) {
          i = paramObject.uint32_ret.get();
        }
        paramFromServiceMsg.putInt("ret", i);
        if (!paramObject.uint32_opt.has()) {
          break label226;
        }
        i = paramObject.uint32_opt.get();
        paramFromServiceMsg.putInt("opt", i);
        paramToServiceMsg = "";
        if (paramObject.str_wording.has()) {
          paramToServiceMsg = paramObject.str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        notifyUI(2, true, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onWXSyncQQMsgOption error:");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("SecSvcHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      notifyUI(2, false, null);
      return;
      label220:
      int i = 1;
      continue;
      label226:
      i = 2;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      paramObject = new device_lock_query_status.RspBody();
    }
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (!paramObject.u32_status.has()) {
          break label193;
        }
        i = paramObject.u32_status.get();
        paramFromServiceMsg.putInt("status", i);
        paramToServiceMsg = "";
        if (paramObject.str_wording.has()) {
          paramToServiceMsg = paramObject.str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        boolean bool1 = bool2;
        if (paramObject.u32_ret.has())
        {
          bool1 = bool2;
          if (paramObject.u32_ret.get() == 0) {
            bool1 = true;
          }
        }
        notifyUI(3, bool1, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onQueryDevLockStatus error:");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("SecSvcHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      notifyUI(3, false, null);
      return;
      label193:
      int i = 0;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool2 = bool4;
    Object localObject1 = localObject3;
    if (paramObject != null)
    {
      boolean bool1 = bool3;
      bool2 = bool4;
      localObject1 = localObject3;
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label345;
        }
        bool1 = bool3;
        paramObject = new oidb_sso.OIDBSSOPkg();
        bool1 = bool3;
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        bool1 = bool3;
        bool2 = bool4;
        localObject1 = localObject3;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label345;
        }
        bool1 = bool3;
        paramFromServiceMsg = new Oidb_0x614.RspBody();
        bool1 = bool3;
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        bool1 = bool3;
        bool2 = bool4;
        localObject1 = localObject3;
        if (!paramFromServiceMsg.msg_dm_head.has()) {
          break label345;
        }
        bool1 = bool3;
        paramFromServiceMsg = paramFromServiceMsg.msg_dm_head;
        bool1 = bool3;
        bool2 = bool4;
        localObject1 = localObject3;
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label345;
        }
        bool1 = bool3;
        bool2 = bool4;
        localObject1 = localObject3;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label345;
        }
        bool2 = true;
        bool3 = true;
        bool1 = true;
        paramFromServiceMsg = new Bundle();
        try
        {
          paramFromServiceMsg.putInt("index", paramToServiceMsg.extraData.getInt("index"));
          paramFromServiceMsg.putString("target_name", paramToServiceMsg.extraData.getString("target_name"));
          paramFromServiceMsg.putByteArray("target_desc", paramToServiceMsg.extraData.getByteArray("target_desc"));
          bool2 = bool3;
          localObject1 = paramFromServiceMsg;
        }
        catch (Exception paramObject)
        {
          paramToServiceMsg = paramFromServiceMsg;
          bool1 = bool2;
          paramFromServiceMsg = paramObject;
        }
        bool2 = bool1;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg = localObject2;
      }
      localObject1 = paramToServiceMsg;
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onRenameAuthDev error:");
        paramObject.append(paramFromServiceMsg.getMessage());
        QLog.d("SecSvcHandler", 2, paramObject.toString());
        localObject1 = paramToServiceMsg;
        bool2 = bool1;
      }
    }
    label345:
    notifyUI(4, bool2, localObject1);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    if (paramObject != null)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label212;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = new Bundle();
        bool1 = bool3;
        try
        {
          if (paramObject.uint32_result.has())
          {
            bool2 = bool4;
            bool1 = bool3;
            if (paramObject.uint32_result.get() == 0) {
              bool2 = true;
            }
            bool1 = bool2;
            paramToServiceMsg.putInt("ret_code", paramObject.uint32_result.get());
          }
          bool1 = bool2;
          bool3 = bool2;
          paramFromServiceMsg = paramToServiceMsg;
          if (!paramObject.str_error_msg.has()) {
            break label218;
          }
          bool1 = bool2;
          paramToServiceMsg.putString("err_msg", paramObject.str_error_msg.get());
          bool3 = bool2;
          paramFromServiceMsg = paramToServiceMsg;
        }
        catch (Exception paramObject) {}
        bool3 = bool1;
      }
      catch (Exception paramObject)
      {
        paramToServiceMsg = null;
      }
      paramFromServiceMsg = paramToServiceMsg;
      if (!QLog.isColorLevel()) {
        break label218;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onBindPhoneNumLogin error:");
      paramFromServiceMsg.append(paramObject.getMessage());
      QLog.d("SecSvcHandler", 2, paramFromServiceMsg.toString());
      bool3 = bool1;
      paramFromServiceMsg = paramToServiceMsg;
      break label218;
    }
    label212:
    paramFromServiceMsg = null;
    bool3 = bool5;
    label218:
    notifyUI(7, bool3, paramFromServiceMsg);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    if (paramObject != null)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label211;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = new Bundle();
        bool1 = bool3;
        try
        {
          if (paramObject.uint32_result.has())
          {
            bool2 = bool4;
            bool1 = bool3;
            if (paramObject.uint32_result.get() == 0) {
              bool2 = true;
            }
            bool1 = bool2;
            paramToServiceMsg.putInt("ret_code", paramObject.uint32_result.get());
          }
          bool1 = bool2;
          bool3 = bool2;
          paramFromServiceMsg = paramToServiceMsg;
          if (!paramObject.str_error_msg.has()) {
            break label217;
          }
          bool1 = bool2;
          paramToServiceMsg.putString("err_msg", paramObject.str_error_msg.get());
          bool3 = bool2;
          paramFromServiceMsg = paramToServiceMsg;
        }
        catch (Exception paramObject) {}
        bool3 = bool1;
      }
      catch (Exception paramObject)
      {
        paramToServiceMsg = null;
      }
      paramFromServiceMsg = paramToServiceMsg;
      if (!QLog.isColorLevel()) {
        break label217;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onUnbindPhoneNumLogin error:");
      paramFromServiceMsg.append(paramObject.getMessage());
      QLog.d("SecSvcHandler", 2, paramFromServiceMsg.toString());
      bool3 = bool1;
      paramFromServiceMsg = paramToServiceMsg;
      break label217;
    }
    label211:
    paramFromServiceMsg = null;
    bool3 = bool5;
    label217:
    notifyUI(8, bool3, paramFromServiceMsg);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        d.e(3, d.x(), paramFromServiceMsg.getWupBuffer());
        return;
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SecSvcHandler", 2, "[SFU] Received reply from server.");
        }
        ((QPUpdateManager)this.b.getManager(QQManagerFactory.QQPROTECT_UPDATE_MANAGER)).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("[SFU] onQQProtectUpdate error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("SecSvcHandler", 2, paramFromServiceMsg.toString());
        return;
      }
    }
    QLog.e("SecSvcHandler", 1, String.format("[SFU] onQQProtectUpdate failed, FromServiceMsg: %s", new Object[] { paramFromServiceMsg.getStringForLog() }));
  }
  
  public void a()
  {
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.b.getLongAccountUin());
    localReqBody.uint32_cmd.set(1);
    Object localObject = localReqBody.uint32_seq;
    int i = this.a;
    this.a = (i + 1);
    ((PBUInt32Field)localObject).set(i);
    localReqBody.uint32_opt.set(1);
    localObject = createToServiceMsg("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new oidb_0xeb8.ReqBody();
    ((oidb_0xeb8.ReqBody)localObject).uint32_src.set(paramInt);
    ((oidb_0xeb8.ReqBody)localObject).uint32_proto_ver.set(2);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3768);
    localOIDBSSOPkg.uint32_service_type.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xeb8.ReqBody)localObject).toByteArray()));
    localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "OidbSvc.0xeb8");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SecSvcHandler onReceivePushMessage subMsgTye = ");
      localStringBuilder.append(Integer.toHexString((int)paramLong));
      QLog.d("SecSvcHandler", 2, localStringBuilder.toString());
    }
    if ((int)paramLong != 198) {
      return;
    }
    try
    {
      paramArrayOfByte = (SubMsgType0xc6.MsgBody)new SubMsgType0xc6.MsgBody().mergeFrom(paramArrayOfByte);
      int i = paramArrayOfByte.uint32_sec_cmd.get();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SecSvcHandler onReceivePushMessage SecCmd = ");
        localStringBuilder.append(i);
        QLog.d("SecSvcHandler", 2, localStringBuilder.toString());
      }
      if (i != 1) {
        if (i != 2)
        {
          if (i == 3) {}
        }
        else
        {
          try
          {
            ((QPUpdateManager)this.b.getManager(QQManagerFactory.QQPROTECT_UPDATE_MANAGER)).b(i);
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            if (!QLog.isColorLevel()) {
              break label233;
            }
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onQQProtectUpdate error:");
          localStringBuilder.append(paramArrayOfByte.getMessage());
          QLog.d("SecSvcHandler", 2, localStringBuilder.toString());
          return;
        }
      }
      if (paramArrayOfByte.msg_s2c_account_exception_notify.has()) {
        a(i, (SubMsgType0xc6.AccountExceptionAlertBody)paramArrayOfByte.msg_s2c_account_exception_notify.get());
      }
      label233:
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    Object localObject1 = paramBundle.getString("uin");
    Object localObject2 = paramBundle.getString("appname");
    long l3 = paramBundle.getLong("appid");
    long l4 = paramBundle.getLong("sub_appid");
    byte[] arrayOfByte2 = paramBundle.getByteArray("device_guid");
    String str = paramBundle.getString("target_name");
    byte[] arrayOfByte1 = paramBundle.getByteArray("target_desc");
    int i = paramBundle.getInt("index");
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject1);
      l1 = l2;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    paramBundle = new Oidb_0x614.DeviceManageHead();
    paramBundle.uint32_cmd.set(0);
    paramBundle.uint32_result.set(0);
    paramBundle.uint64_uin.set(l1);
    paramBundle.bytes_guid.set(ByteStringMicro.copyFrom(arrayOfByte2));
    Object localObject3 = paramBundle.uint32_appid;
    int j = (int)l3;
    ((PBUInt32Field)localObject3).set(j);
    localObject3 = paramBundle.uint32_subappid;
    int k = (int)l4;
    ((PBUInt32Field)localObject3).set(k);
    paramBundle.bytes_appname.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject3 = new Oidb_0x614.ReNameDeviceNameReqBody();
    ((Oidb_0x614.ReNameDeviceNameReqBody)localObject3).bytes_guid.set(ByteStringMicro.copyFrom(arrayOfByte2));
    ((Oidb_0x614.ReNameDeviceNameReqBody)localObject3).uint32_appid.set(j);
    ((Oidb_0x614.ReNameDeviceNameReqBody)localObject3).uint32_subappid.set(k);
    ((Oidb_0x614.ReNameDeviceNameReqBody)localObject3).bytes_appname.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    ((Oidb_0x614.ReNameDeviceNameReqBody)localObject3).bytes_device_des.set(ByteStringMicro.copyFrom(arrayOfByte1));
    ((Oidb_0x614.ReNameDeviceNameReqBody)localObject3).bytes_rename_device_name.set(ByteStringMicro.copyFromUtf8(str));
    localObject2 = new Oidb_0x614.ReqBody();
    ((Oidb_0x614.ReqBody)localObject2).msg_dm_head.set(paramBundle);
    ((Oidb_0x614.ReqBody)localObject2).msg_mdn_req_body.set((MessageMicro)localObject3);
    paramBundle = new oidb_sso.OIDBSSOPkg();
    paramBundle.uint32_command.set(1556);
    paramBundle.uint32_service_type.set(1);
    paramBundle.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x614.ReqBody)localObject2).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "OidbSvc.0x614_1");
    ((ToServiceMsg)localObject1).putWupBuffer(paramBundle.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("uin", l1);
    ((ToServiceMsg)localObject1).extraData.putString("target_name", str);
    ((ToServiceMsg)localObject1).extraData.putByteArray("target_desc", arrayOfByte1);
    ((ToServiceMsg)localObject1).extraData.putInt("index", i);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "getAntiFraudConfig");
    }
    get_config.ReqBody localReqBody = new get_config.ReqBody();
    localReqBody.u64_uin.set(this.b.getLongAccountUin());
    localReqBody.u32_appid.set(AppSetting.d());
    localReqBody.u32_proto_version.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.u32_seq;
    int i = this.a;
    this.a = (i + 1);
    localPBUInt32Field.set(i);
    localReqBody.str_config_name.set(paramString);
    paramString = AntiFraudConfigFileUtil.a().a(paramString, "Version");
    int j = 0;
    i = j;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        i = Integer.parseInt(paramString);
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        i = j;
      }
    }
    localReqBody.u32_config_version.set(i);
    paramString = createToServiceMsg("SecuritySvc.GetConfig");
    paramString.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.d("SecSvcHandler", 2, "setWXSyncQQMsgOption");
    }
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.b.getLongAccountUin());
    localReqBody.uint32_cmd.set(2);
    Object localObject = localReqBody.uint32_seq;
    int j = this.a;
    this.a = (j + 1);
    ((PBUInt32Field)localObject).set(j);
    localObject = localReqBody.uint32_opt;
    if (paramBoolean) {
      i = 1;
    }
    ((PBUInt32Field)localObject).set(i);
    localObject = createToServiceMsg("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      notifyUI(7, false, null);
      return;
    }
    Object localObject = ByteBuffer.allocate(paramArrayOfByte.length + 19);
    ((ByteBuffer)localObject).putShort((short)3);
    ((ByteBuffer)localObject).putInt((int)this.b.getLongAccountUin());
    ((ByteBuffer)localObject).put((byte)paramArrayOfByte.length);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    ((ByteBuffer)localObject).putShort((short)2);
    ((ByteBuffer)localObject).putShort((short)1);
    ((ByteBuffer)localObject).putShort((short)1);
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)2);
    ((ByteBuffer)localObject).putShort((short)1);
    ((ByteBuffer)localObject).put((byte)1);
    paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
    paramArrayOfByte.uint32_command.set(2579);
    paramArrayOfByte.uint32_service_type.set(16);
    paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "OidbSvc.0xa13");
    ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    device_lock_query_status.ReqBody localReqBody = new device_lock_query_status.ReqBody();
    Object localObject = localReqBody.u32_seq;
    int i = this.a;
    this.a = (i + 1);
    ((PBUInt32Field)localObject).set(i);
    localReqBody.u32_sys_type.set(1);
    localReqBody.u32_app_id.set(AppSetting.d());
    localObject = createToServiceMsg("DevLockSecSvc.DevLockQuery");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      notifyUI(8, false, Integer.valueOf(-1));
      return;
    }
    Object localObject = ByteBuffer.allocate(paramArrayOfByte.length + 7);
    ((ByteBuffer)localObject).putShort((short)3);
    ((ByteBuffer)localObject).putInt((int)this.b.getLongAccountUin());
    ((ByteBuffer)localObject).put((byte)paramArrayOfByte.length);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
    paramArrayOfByte.uint32_command.set(1197);
    paramArrayOfByte.uint32_service_type.set(11);
    paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "OidbSvc.0x4ad");
    ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void c()
  {
    sendPbReq(makeOIDBPkg("OidbSvc.0xec0", 3776, 0, new oidb_0xec0.ReqBody().toByteArray()));
  }
  
  public void d()
  {
    b(true);
  }
  
  public void e()
  {
    b(false);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SecSvcObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equalsIgnoreCase("SecuritySvc.GetConfig"))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("DevLockAuthSvc.WxMsgOpt"))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("DevLockSecSvc.DevLockQuery"))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0x614_1"))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0xa13"))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0x4ad"))
    {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("MamonoSvc.Pa"))
    {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("MobileQQprotect.QPUpdate"))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0xeb8"))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0xebd"))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0xec0"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    SecSvcHandlerHelper.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcHandler
 * JD-Core Version:    0.7.0.1
 */