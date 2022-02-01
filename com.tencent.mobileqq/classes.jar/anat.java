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
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqp.app.sec.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import tencent.im.oidb.cmd0x614.Oidb_0x614.DeviceManageHead;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReNameDeviceNameReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReqBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.PhoneInfo;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.ReqBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.RspBody;
import tencent.im.oidb.cmd0xebd.oidb_0xebd.ReqBody;
import tencent.im.oidb.cmd0xebd.oidb_0xebd.RspBody;
import tencent.im.oidb.cmd0xec0.oidb_0xec0.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.AccountExceptionAlertBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.MsgBody;

public class anat
  extends BusinessHandler
{
  private int a = 1;
  
  anat(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt, SubMsgType0xc6.AccountExceptionAlertBody paramAccountExceptionAlertBody)
  {
    if (paramAccountExceptionAlertBody == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcHandler", 2, "account exception alert, null body");
      }
    }
    do
    {
      return;
      if (this.app.isLogin()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SecSvcHandler", 2, "user not logined, no alert");
    return;
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    if (paramAccountExceptionAlertBody.str_title.has()) {
      str1 = paramAccountExceptionAlertBody.str_title.get();
    }
    if (paramAccountExceptionAlertBody.str_content.has()) {
      str2 = paramAccountExceptionAlertBody.str_content.get();
    }
    if (paramAccountExceptionAlertBody.str_left_button_text.has()) {
      str3 = paramAccountExceptionAlertBody.str_left_button_text.get();
    }
    if (paramAccountExceptionAlertBody.str_right_button_text.has()) {
      str4 = paramAccountExceptionAlertBody.str_right_button_text.get();
    }
    if (paramAccountExceptionAlertBody.str_right_button_link.has()) {
      str5 = paramAccountExceptionAlertBody.str_right_button_link.get();
    }
    if (paramAccountExceptionAlertBody.uint32_left_button_id.has()) {}
    for (int i = paramAccountExceptionAlertBody.uint32_left_button_id.get();; i = 0)
    {
      if (paramAccountExceptionAlertBody.uint32_right_button_id.has()) {}
      for (int j = paramAccountExceptionAlertBody.uint32_right_button_id.get();; j = 0)
      {
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4))))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SecSvcHandler", 2, "empty title or content, or no buttons, so no alert");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SecSvcHandler", 2, String.format("cmd=%d, args: title=%s, msg=%s, lbtn=%s, rbtn=%s, url=%s,lbip=%d, rbid=%d", new Object[] { Integer.valueOf(paramInt), str1, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(j) }));
        }
        new Handler(Looper.getMainLooper()).post(new SecSvcHandler.1(this, str1, str2, str3, str4, str5, i, j, paramInt));
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    if ((paramObject == null) || (paramFromServiceMsg == null) || (paramToServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      notifyUI(8, false, Integer.valueOf(-1));
      return;
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = new Bundle();
        bool2 = bool3;
        paramObject = paramToServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        try
        {
          if (localOIDBSSOPkg.uint32_result.has())
          {
            bool1 = bool4;
            bool2 = bool3;
            if (localOIDBSSOPkg.uint32_result.get() == 0) {
              bool1 = true;
            }
            bool2 = bool1;
            paramToServiceMsg.putInt("ret_code", localOIDBSSOPkg.uint32_result.get());
          }
          paramObject = paramToServiceMsg;
          bool2 = bool1;
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            boolean bool2;
            bool1 = bool2;
          }
        }
        try
        {
          if (localOIDBSSOPkg.str_error_msg.has())
          {
            paramToServiceMsg.putString("err_msg", localOIDBSSOPkg.str_error_msg.get());
            bool2 = bool1;
            paramObject = paramToServiceMsg;
          }
          notifyUI(8, bool2, paramObject);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          break label175;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        paramToServiceMsg = null;
        bool1 = false;
      }
      label175:
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onUnbindPhoneNumLogin error:" + paramFromServiceMsg.getMessage());
        paramObject = paramToServiceMsg;
        bool2 = bool1;
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (paramFromServiceMsg == null) || (paramToServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (paramToServiceMsg == null) {}
      for (paramToServiceMsg = Boolean.valueOf(false);; paramToServiceMsg = paramToServiceMsg.getAttribute("open_close_contacts", Boolean.valueOf(false)))
      {
        notifyUI(10, false, paramToServiceMsg);
        return;
      }
    }
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xebd.RspBody()) == 0)
    {
      notifyUI(10, true, paramToServiceMsg.getAttribute("open_close_contacts", Boolean.valueOf(false)));
      return;
    }
    notifyUI(10, false, paramToServiceMsg.getAttribute("open_close_contacts", Boolean.valueOf(false)));
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = null;
    oidb_0xeb8.PhoneInfo localPhoneInfo = null;
    if (paramObject != null) {}
    for (;;)
    {
      boolean bool1;
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label599;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramObject.uint32_result.get() != 0) || (!paramObject.bytes_bodybuffer.has())) {
          break label599;
        }
        paramFromServiceMsg = new oidb_0xeb8.RspBody();
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        i = paramFromServiceMsg.uint32_check_result.get();
        if (i <= 0) {
          break label599;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = false;
        paramToServiceMsg = localPhoneInfo;
        continue;
      }
      try
      {
        paramToServiceMsg = new Bundle();
        try
        {
          paramToServiceMsg.putInt("check_result", i);
          if (i != 2) {
            break label616;
          }
          i = 0;
          paramToServiceMsg.putInt("need_unify", i);
          if (paramFromServiceMsg.str_mibao_change_url.has()) {
            paramToServiceMsg.putString("mibao_change_url", paramFromServiceMsg.str_mibao_change_url.get());
          }
          if (paramFromServiceMsg.str_mibao_set_url.has()) {
            paramToServiceMsg.putString("mibao_set_url", paramFromServiceMsg.str_mibao_set_url.get());
          }
          if (paramFromServiceMsg.str_mibao_verify_url.has()) {
            paramToServiceMsg.putString("mibao_verify_url", paramFromServiceMsg.str_mibao_verify_url.get());
          }
          if (!paramFromServiceMsg.rpt_phone_info.has()) {
            continue;
          }
          paramFromServiceMsg = paramFromServiceMsg.rpt_phone_info.get();
          paramObject = new Bundle[paramFromServiceMsg.size()];
          i = 0;
          if (i >= paramFromServiceMsg.size()) {
            continue;
          }
          localPhoneInfo = (oidb_0xeb8.PhoneInfo)paramFromServiceMsg.get(i);
          if (localPhoneInfo == null) {
            break label607;
          }
          Bundle localBundle = new Bundle();
          int j = -1;
          if (localPhoneInfo.uint32_phone_type.has())
          {
            localBundle.putInt("phone_type", localPhoneInfo.uint32_phone_type.get());
            j = localPhoneInfo.uint32_phone_type.get();
          }
          if (localPhoneInfo.str_country_code.has())
          {
            localBundle.putString("country_code", localPhoneInfo.str_country_code.get());
            if (j == 1) {
              paramToServiceMsg.putString("country_code", localPhoneInfo.str_country_code.get());
            }
          }
          if (localPhoneInfo.str_phone.has())
          {
            localBundle.putString("phone", localPhoneInfo.str_phone.get());
            if (j == 1) {
              paramToServiceMsg.putString("phone", localPhoneInfo.str_phone.get());
            }
          }
          if (localPhoneInfo.uint32_phone_status.has())
          {
            localBundle.putInt("status", localPhoneInfo.uint32_phone_status.get());
            if (j == 1) {
              paramToServiceMsg.putInt("status", localPhoneInfo.uint32_phone_status.get());
            }
          }
          if (localPhoneInfo.bytes_vas_phone.has()) {
            localBundle.putByteArray("vaskey", localPhoneInfo.bytes_vas_phone.get().toByteArray());
          }
          paramObject[i] = localBundle;
        }
        catch (Exception paramFromServiceMsg)
        {
          bool1 = true;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = true;
        paramToServiceMsg = localPhoneInfo;
        continue;
      }
      paramObject = paramToServiceMsg;
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onGetPhoneBindInfo error:" + paramFromServiceMsg.getMessage());
        bool2 = bool1;
        paramObject = paramToServiceMsg;
      }
      notifyUI(5, bool2, paramObject);
      return;
      paramToServiceMsg.putParcelableArray("phone_info", paramObject);
      ((aihp)this.app.getManager(102)).a(paramToServiceMsg);
      bool2 = true;
      paramObject = paramToServiceMsg;
      continue;
      label599:
      bool2 = false;
      paramObject = paramToServiceMsg;
      continue;
      label607:
      i += 1;
      continue;
      label616:
      int i = 1;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    int i = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      notifyUI(1, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new get_config.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = new Bundle();
        if (paramFromServiceMsg.u32_proto_version.has()) {
          i = paramFromServiceMsg.u32_proto_version.get();
        }
        paramObject.putInt("proto_version", i);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_config_name.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_config_name.get();
        }
        paramObject.putString("config_name", paramToServiceMsg);
        if (!paramFromServiceMsg.u32_config_version.has()) {
          break label273;
        }
        i = paramFromServiceMsg.u32_config_version.get();
        paramObject.putInt("config_version", i);
        i = j;
        if (paramFromServiceMsg.u32_effect_time.has()) {
          i = paramFromServiceMsg.u32_effect_time.get();
        }
        paramObject.putInt("effect_time", i);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_md5.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_md5.get();
        }
        paramObject.putString("md5", paramToServiceMsg);
        paramToServiceMsg = "";
        if (paramFromServiceMsg.str_download_link.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_download_link.get();
        }
        paramObject.putString("download_url", paramToServiceMsg);
        notifyUI(1, true, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onGetAntiFraudConfig error:" + paramToServiceMsg.getMessage());
      return;
      label273:
      i = 0;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      notifyUI(2, false, null);
      return;
    }
    paramObject = new wx_msg_opt.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (paramObject.uint32_cmd.has()) {
          i = paramObject.uint32_cmd.get();
        }
        paramFromServiceMsg.putInt("cmd", i);
        i = -1;
        if (paramObject.uint32_ret.has()) {
          i = paramObject.uint32_ret.get();
        }
        paramFromServiceMsg.putInt("ret", i);
        if (!paramObject.uint32_opt.has()) {
          break label208;
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
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onWXSyncQQMsgOption error:" + paramToServiceMsg.getMessage());
      return;
      label208:
      i = 2;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      notifyUI(3, false, null);
      return;
    }
    paramObject = new device_lock_query_status.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        if (!paramObject.u32_status.has()) {
          break label181;
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
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onQueryDevLockStatus error:" + paramToServiceMsg.getMessage());
      return;
      label181:
      int i = 0;
    }
  }
  
  /* Error */
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +252 -> 253
    //   4: aload_2
    //   5: invokevirtual 133	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifeq +245 -> 253
    //   11: new 139	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   14: dup
    //   15: invokespecial 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   24: invokevirtual 150	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: pop
    //   28: aload_3
    //   29: getfield 212	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   32: invokevirtual 215	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   35: ifeq +218 -> 253
    //   38: new 397	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody
    //   41: dup
    //   42: invokespecial 398	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_3
    //   48: getfield 212	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 221	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 226	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   57: invokevirtual 399	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_2
    //   62: getfield 403	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:msg_dm_head	Ltencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead;
    //   65: invokevirtual 406	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:has	()Z
    //   68: ifeq +185 -> 253
    //   71: aload_2
    //   72: getfield 403	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:msg_dm_head	Ltencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead;
    //   75: astore_2
    //   76: aload_2
    //   77: getfield 407	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   80: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   83: ifeq +170 -> 253
    //   86: aload_2
    //   87: getfield 407	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   90: invokevirtual 78	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   93: istore 4
    //   95: iload 4
    //   97: ifne +156 -> 253
    //   100: new 152	android/os/Bundle
    //   103: dup
    //   104: invokespecial 153	android/os/Bundle:<init>	()V
    //   107: astore_3
    //   108: aload_1
    //   109: getfield 411	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   112: getstatic 417	com/tencent/mobileqq/activity/AuthDevRenameActivity:i	Ljava/lang/String;
    //   115: invokevirtual 421	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   118: istore 4
    //   120: aload_3
    //   121: getstatic 417	com/tencent/mobileqq/activity/AuthDevRenameActivity:i	Ljava/lang/String;
    //   124: iload 4
    //   126: invokevirtual 162	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   129: aload_1
    //   130: getfield 411	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   133: getstatic 423	com/tencent/mobileqq/activity/AuthDevRenameActivity:f	Ljava/lang/String;
    //   136: invokevirtual 427	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_2
    //   140: aload_3
    //   141: getstatic 423	com/tencent/mobileqq/activity/AuthDevRenameActivity:f	Ljava/lang/String;
    //   144: aload_2
    //   145: invokevirtual 171	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_1
    //   149: getfield 411	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   152: getstatic 430	com/tencent/mobileqq/activity/AuthDevRenameActivity:h	Ljava/lang/String;
    //   155: invokevirtual 434	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   158: astore_1
    //   159: aload_3
    //   160: getstatic 430	com/tencent/mobileqq/activity/AuthDevRenameActivity:h	Ljava/lang/String;
    //   163: aload_1
    //   164: invokevirtual 298	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   167: iconst_1
    //   168: istore 6
    //   170: aload_0
    //   171: iconst_4
    //   172: iload 6
    //   174: aload_3
    //   175: invokevirtual 137	anat:notifyUI	(IZLjava/lang/Object;)V
    //   178: return
    //   179: astore_2
    //   180: iconst_0
    //   181: istore 5
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: astore_3
    //   187: iload 5
    //   189: istore 6
    //   191: invokestatic 20	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -24 -> 170
    //   197: ldc 22
    //   199: iconst_2
    //   200: new 173	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 436
    //   210: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 28	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_1
    //   227: astore_3
    //   228: iload 5
    //   230: istore 6
    //   232: goto -62 -> 170
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_1
    //   238: iconst_1
    //   239: istore 5
    //   241: goto -56 -> 185
    //   244: astore_2
    //   245: iconst_1
    //   246: istore 5
    //   248: aload_3
    //   249: astore_1
    //   250: goto -65 -> 185
    //   253: iconst_0
    //   254: istore 6
    //   256: aconst_null
    //   257: astore_3
    //   258: goto -88 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	anat
    //   0	261	1	paramToServiceMsg	ToServiceMsg
    //   0	261	2	paramFromServiceMsg	FromServiceMsg
    //   0	261	3	paramObject	Object
    //   93	32	4	i	int
    //   181	66	5	bool1	boolean
    //   168	87	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	95	179	java/lang/Exception
    //   100	108	235	java/lang/Exception
    //   108	167	244	java/lang/Exception
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label210;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        bool2 = bool3;
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramObject)
      {
        try
        {
          if (paramObject.uint32_result.has())
          {
            bool1 = bool4;
            bool2 = bool3;
            if (paramObject.uint32_result.get() == 0) {
              bool1 = true;
            }
            bool2 = bool1;
            paramFromServiceMsg.putInt("ret_code", paramObject.uint32_result.get());
          }
          paramToServiceMsg = paramFromServiceMsg;
          bool2 = bool1;
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            bool1 = bool2;
          }
        }
        try
        {
          if (paramObject.str_error_msg.has())
          {
            paramFromServiceMsg.putString("err_msg", paramObject.str_error_msg.get());
            bool2 = bool1;
            paramToServiceMsg = paramFromServiceMsg;
          }
          notifyUI(7, bool2, paramToServiceMsg);
          return;
        }
        catch (Exception paramObject)
        {
          break label148;
        }
        paramObject = paramObject;
        paramFromServiceMsg = null;
        bool1 = false;
      }
      label148:
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onBindPhoneNumLogin error:" + paramObject.getMessage());
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = bool1;
        continue;
        label210:
        paramToServiceMsg = null;
        bool2 = false;
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label209;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new Bundle();
        bool2 = bool3;
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramObject)
      {
        try
        {
          if (paramObject.uint32_result.has())
          {
            bool1 = bool4;
            bool2 = bool3;
            if (paramObject.uint32_result.get() == 0) {
              bool1 = true;
            }
            bool2 = bool1;
            paramFromServiceMsg.putInt("ret_code", paramObject.uint32_result.get());
          }
          paramToServiceMsg = paramFromServiceMsg;
          bool2 = bool1;
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            bool1 = bool2;
          }
        }
        try
        {
          if (paramObject.str_error_msg.has())
          {
            paramFromServiceMsg.putString("err_msg", paramObject.str_error_msg.get());
            bool2 = bool1;
            paramToServiceMsg = paramFromServiceMsg;
          }
          notifyUI(8, bool2, paramToServiceMsg);
          return;
        }
        catch (Exception paramObject)
        {
          break label148;
        }
        paramObject = paramObject;
        paramFromServiceMsg = null;
        bool1 = false;
      }
      label148:
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onUnbindPhoneNumLogin error:" + paramObject.getMessage());
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = bool1;
        continue;
        label209:
        paramToServiceMsg = null;
        bool2 = false;
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {}
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
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e("SecSvcHandler", 1, String.format("[SFU] onQQProtectUpdate failed, FromServiceMsg: %s", new Object[] { paramFromServiceMsg.getStringForLog() }));
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcHandler", 2, "[SFU] Received reply from server.");
      }
      ((bjki)this.app.getManager(194)).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("SecSvcHandler", 2, "[SFU] onQQProtectUpdate error:" + paramToServiceMsg.getMessage());
    }
  }
  
  public void a()
  {
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.app.getLongAccountUin());
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
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3768);
    localOIDBSSOPkg.uint32_service_type.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xeb8.ReqBody)localObject).toByteArray()));
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc.0xeb8");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "SecSvcHandler onReceivePushMessage subMsgTye = " + Integer.toHexString((int)paramLong));
    }
    switch ((int)paramLong)
    {
    }
    int i;
    do
    {
      do
      {
        return;
        try
        {
          paramArrayOfByte = (SubMsgType0xc6.MsgBody)new SubMsgType0xc6.MsgBody().mergeFrom(paramArrayOfByte);
          i = paramArrayOfByte.uint32_sec_cmd.get();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SecSvcHandler", 2, "SecSvcHandler onReceivePushMessage SecCmd = " + i);
        }
        catch (Exception paramArrayOfByte)
        {
          return;
        }
      } while (!paramArrayOfByte.msg_s2c_account_exception_notify.has());
      a(i, (SubMsgType0xc6.AccountExceptionAlertBody)paramArrayOfByte.msg_s2c_account_exception_notify.get());
      return;
      try
      {
        ((bjki)this.app.getManager(194)).b(i);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("SecSvcHandler", 2, "onQQProtectUpdate error:" + paramArrayOfByte.getMessage());
    return;
    switch (i)
    {
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    Object localObject1 = paramBundle.getString(AuthDevRenameActivity.a);
    Object localObject2 = paramBundle.getString(AuthDevRenameActivity.b);
    long l3 = paramBundle.getLong(AuthDevRenameActivity.c);
    long l4 = paramBundle.getLong(AuthDevRenameActivity.d);
    byte[] arrayOfByte2 = paramBundle.getByteArray(AuthDevRenameActivity.e);
    String str = paramBundle.getString(AuthDevRenameActivity.f);
    byte[] arrayOfByte1 = paramBundle.getByteArray(AuthDevRenameActivity.h);
    int i = paramBundle.getInt(AuthDevRenameActivity.i);
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
        Oidb_0x614.ReNameDeviceNameReqBody localReNameDeviceNameReqBody;
        paramBundle.printStackTrace();
      }
    }
    paramBundle = new Oidb_0x614.DeviceManageHead();
    paramBundle.uint32_cmd.set(0);
    paramBundle.uint32_result.set(0);
    paramBundle.uint64_uin.set(l1);
    paramBundle.bytes_guid.set(ByteStringMicro.copyFrom(arrayOfByte2));
    paramBundle.uint32_appid.set((int)l3);
    paramBundle.uint32_subappid.set((int)l4);
    paramBundle.bytes_appname.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localReNameDeviceNameReqBody = new Oidb_0x614.ReNameDeviceNameReqBody();
    localReNameDeviceNameReqBody.bytes_guid.set(ByteStringMicro.copyFrom(arrayOfByte2));
    localReNameDeviceNameReqBody.uint32_appid.set((int)l3);
    localReNameDeviceNameReqBody.uint32_subappid.set((int)l4);
    localReNameDeviceNameReqBody.bytes_appname.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localReNameDeviceNameReqBody.bytes_device_des.set(ByteStringMicro.copyFrom(arrayOfByte1));
    localReNameDeviceNameReqBody.bytes_rename_device_name.set(ByteStringMicro.copyFromUtf8(str));
    localObject2 = new Oidb_0x614.ReqBody();
    ((Oidb_0x614.ReqBody)localObject2).msg_dm_head.set(paramBundle);
    ((Oidb_0x614.ReqBody)localObject2).msg_mdn_req_body.set(localReNameDeviceNameReqBody);
    paramBundle = new oidb_sso.OIDBSSOPkg();
    paramBundle.uint32_command.set(1556);
    paramBundle.uint32_service_type.set(1);
    paramBundle.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x614.ReqBody)localObject2).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "OidbSvc.0x614_1");
    ((ToServiceMsg)localObject1).putWupBuffer(paramBundle.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong(AuthDevRenameActivity.a, l1);
    ((ToServiceMsg)localObject1).extraData.putString(AuthDevRenameActivity.f, str);
    ((ToServiceMsg)localObject1).extraData.putByteArray(AuthDevRenameActivity.h, arrayOfByte1);
    ((ToServiceMsg)localObject1).extraData.putInt(AuthDevRenameActivity.i, i);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "getAntiFraudConfig");
    }
    get_config.ReqBody localReqBody = new get_config.ReqBody();
    localReqBody.u64_uin.set(this.app.getLongAccountUin());
    localReqBody.u32_appid.set(AppSetting.a());
    localReqBody.u32_proto_version.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.u32_seq;
    int i = this.a;
    this.a = (i + 1);
    localPBUInt32Field.set(i);
    localReqBody.str_config_name.set(paramString);
    paramString = bftm.a().a(paramString, "Version");
    int j = 0;
    i = j;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Integer.parseInt(paramString);
      localReqBody.u32_config_version.set(i);
      paramString = createToServiceMsg("SecuritySvc.GetConfig");
      paramString.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "setWXSyncQQMsgOption");
    }
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.app.getLongAccountUin());
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
    ((ByteBuffer)localObject).putInt((int)this.app.getLongAccountUin());
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
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc.0xa13");
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
    localReqBody.u32_app_id.set(AppSetting.a());
    localObject = createToServiceMsg("DevLockSecSvc.DevLockQuery");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void b(boolean paramBoolean)
  {
    Object localObject = new oidb_0xebd.ReqBody();
    PBUInt32Field localPBUInt32Field = ((oidb_0xebd.ReqBody)localObject).uint32_set_is_searched_by_mobile;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localObject = makeOIDBPkg("OidbSvc.0xebd", 3773, 1, ((oidb_0xebd.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("open_close_contacts", Boolean.valueOf(paramBoolean));
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
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
    ((ByteBuffer)localObject).putInt((int)this.app.getLongAccountUin());
    ((ByteBuffer)localObject).put((byte)paramArrayOfByte.length);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
    paramArrayOfByte.uint32_command.set(1197);
    paramArrayOfByte.uint32_service_type.set(11);
    paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc.0x4ad");
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return anau.class;
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
    bjkb.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anat
 * JD-Core Version:    0.7.0.1
 */