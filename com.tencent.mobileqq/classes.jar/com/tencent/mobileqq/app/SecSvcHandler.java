package com.tencent.mobileqq.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.device_lock_query_status.ReqBody;
import com.tencent.ims.device_lock_query_status.RspBody;
import com.tencent.ims.get_config.ReqBody;
import com.tencent.ims.get_config.RspBody;
import com.tencent.ims.wx_msg_opt.ReqBody;
import com.tencent.ims.wx_msg_opt.RspBody;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mqp.app.sec.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.SecSvcHandlerHelper;
import com.tencent.qqprotect.singleupdate.QPUpdateManager;
import com.tencent.smtt.utils.Apn;
import java.nio.ByteBuffer;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x614.Oidb_0x614.DeviceManageHead;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReNameDeviceNameReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReqBody;
import tencent.im.oidb.cmd0x6de.Oidb_0x6de.DevInfo;
import tencent.im.oidb.cmd0x6de.Oidb_0x6de.PhoneInfo;
import tencent.im.oidb.cmd0x6de.Oidb_0x6de.ReqBody;
import tencent.im.oidb.cmd0x6de.Oidb_0x6de.RspBody;
import tencent.im.oidb.cmd0x6df.Oidb_0x6df.DevInfo;
import tencent.im.oidb.cmd0x6df.Oidb_0x6df.PhoneInfo;
import tencent.im.oidb.cmd0x6df.Oidb_0x6df.ReqBody;
import tencent.im.oidb.cmd0x6df.Oidb_0x6df.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.AccountExceptionAlertBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.MsgBody;
import zts;

public class SecSvcHandler
  extends BusinessHandler
{
  private int a = 1;
  
  SecSvcHandler(QQAppInterface paramQQAppInterface)
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
      if (this.b.isLogin()) {
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
        new Handler(Looper.getMainLooper()).post(new zts(this, str1, str2, str3, str4, str5, i, j, paramInt));
        return;
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    int i = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(1, false, null);
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
          break label266;
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
        a(1, true, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onGetAntiFraudConfig error:" + paramToServiceMsg.getMessage());
      return;
      label266:
      i = 0;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(2, false, null);
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
          break label203;
        }
        i = paramObject.uint32_opt.get();
        paramFromServiceMsg.putInt("opt", i);
        paramToServiceMsg = "";
        if (paramObject.str_wording.has()) {
          paramToServiceMsg = paramObject.str_wording.get();
        }
        paramFromServiceMsg.putString("wording", paramToServiceMsg);
        a(2, true, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onWXSyncQQMsgOption error:" + paramToServiceMsg.getMessage());
      return;
      label203:
      i = 2;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
    {
      a(3, false, null);
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
          break label178;
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
        a(3, bool1, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SecSvcHandler", 2, "onQueryDevLockStatus error:" + paramToServiceMsg.getMessage());
      return;
      label178:
      int i = 0;
    }
  }
  
  /* Error */
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +252 -> 253
    //   4: aload_2
    //   5: invokevirtual 133	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifeq +245 -> 253
    //   11: new 252	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   14: dup
    //   15: invokespecial 253	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 211	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   24: invokevirtual 254	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: pop
    //   28: aload_3
    //   29: getfield 258	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   32: invokevirtual 261	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   35: ifeq +218 -> 253
    //   38: new 263	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody
    //   41: dup
    //   42: invokespecial 264	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:<init>	()V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_3
    //   48: getfield 258	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 267	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 272	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   57: invokevirtual 273	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_2
    //   62: getfield 277	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:msg_dm_head	Ltencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead;
    //   65: invokevirtual 280	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:has	()Z
    //   68: ifeq +185 -> 253
    //   71: aload_2
    //   72: getfield 277	tencent/im/oidb/cmd0x614/Oidb_0x614$RspBody:msg_dm_head	Ltencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead;
    //   75: astore_2
    //   76: aload_2
    //   77: getfield 283	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   80: invokevirtual 75	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   83: ifeq +170 -> 253
    //   86: aload_2
    //   87: getfield 283	tencent/im/oidb/cmd0x614/Oidb_0x614$DeviceManageHead:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   90: invokevirtual 78	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   93: istore 4
    //   95: iload 4
    //   97: ifne +156 -> 253
    //   100: new 149	android/os/Bundle
    //   103: dup
    //   104: invokespecial 150	android/os/Bundle:<init>	()V
    //   107: astore_3
    //   108: aload_1
    //   109: getfield 289	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   112: getstatic 295	com/tencent/mobileqq/activity/AuthDevRenameActivity:i	Ljava/lang/String;
    //   115: invokevirtual 299	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   118: istore 4
    //   120: aload_3
    //   121: getstatic 295	com/tencent/mobileqq/activity/AuthDevRenameActivity:i	Ljava/lang/String;
    //   124: iload 4
    //   126: invokevirtual 159	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   129: aload_1
    //   130: getfield 289	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   133: getstatic 302	com/tencent/mobileqq/activity/AuthDevRenameActivity:f	Ljava/lang/String;
    //   136: invokevirtual 306	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_2
    //   140: aload_3
    //   141: getstatic 302	com/tencent/mobileqq/activity/AuthDevRenameActivity:f	Ljava/lang/String;
    //   144: aload_2
    //   145: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_1
    //   149: getfield 289	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   152: getstatic 309	com/tencent/mobileqq/activity/AuthDevRenameActivity:h	Ljava/lang/String;
    //   155: invokevirtual 313	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   158: astore_1
    //   159: aload_3
    //   160: getstatic 309	com/tencent/mobileqq/activity/AuthDevRenameActivity:h	Ljava/lang/String;
    //   163: aload_1
    //   164: invokevirtual 317	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   167: iconst_1
    //   168: istore 6
    //   170: aload_0
    //   171: iconst_4
    //   172: iload 6
    //   174: aload_3
    //   175: invokevirtual 136	com/tencent/mobileqq/app/SecSvcHandler:a	(IZLjava/lang/Object;)V
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
    //   200: new 190	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 319
    //   210: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: invokevirtual 200	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   0	261	0	this	SecSvcHandler
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
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    paramToServiceMsg = null;
    Oidb_0x6de.PhoneInfo localPhoneInfo = null;
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label589;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (!paramObject.bytes_bodybuffer.has()) {
          break label589;
        }
        paramFromServiceMsg = new Oidb_0x6de.RspBody();
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label589;
        }
        int j = paramFromServiceMsg.uint32_result.get();
        if (j != 0) {
          break label606;
        }
        bool1 = true;
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
          if (paramFromServiceMsg.uint32_src.has()) {
            paramToServiceMsg.putInt("src", paramFromServiceMsg.uint32_src.get());
          }
          if (paramFromServiceMsg.str_country_code.has()) {
            paramToServiceMsg.putString("country_code", paramFromServiceMsg.str_country_code.get());
          }
          if (paramFromServiceMsg.str_binding_phone.has()) {
            paramToServiceMsg.putString("phone", paramFromServiceMsg.str_binding_phone.get());
          }
          if (paramFromServiceMsg.uint32_binding_time.has()) {
            paramToServiceMsg.putInt("binding_time", paramFromServiceMsg.uint32_binding_time.get());
          }
          if (paramFromServiceMsg.uint32_need_unify.has()) {
            paramToServiceMsg.putInt("need_unify", paramFromServiceMsg.uint32_need_unify.get());
          }
          if (paramFromServiceMsg.uint32_phone_type.has()) {
            paramToServiceMsg.putInt("phone_type", paramFromServiceMsg.uint32_phone_type.get());
          }
          if (!paramFromServiceMsg.phone_info.has()) {
            continue;
          }
          paramObject = new Bundle[paramFromServiceMsg.phone_info.size()];
          if (i >= paramFromServiceMsg.phone_info.size()) {
            continue;
          }
          localPhoneInfo = (Oidb_0x6de.PhoneInfo)paramFromServiceMsg.phone_info.get(i);
          if (localPhoneInfo == null) {
            break label597;
          }
          Bundle localBundle = new Bundle();
          if (localPhoneInfo.uint32_type.has()) {
            localBundle.putInt("phone_type", localPhoneInfo.uint32_type.get());
          }
          if (localPhoneInfo.str_country_code.has()) {
            localBundle.putString("country_code", localPhoneInfo.str_country_code.get());
          }
          if (localPhoneInfo.str_phone.has()) {
            localBundle.putString("phone", localPhoneInfo.str_phone.get());
          }
          if (localPhoneInfo.uint32_bu_status.has()) {
            localBundle.putInt("status", localPhoneInfo.uint32_bu_status.get());
          }
          paramObject[i] = localBundle;
        }
        catch (Exception paramFromServiceMsg) {}
      }
      catch (Exception paramFromServiceMsg)
      {
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
      a(5, bool2, paramObject);
      return;
      paramToServiceMsg.putParcelableArray("phone_info", paramObject);
      if (paramFromServiceMsg.bytes_skip_url.has()) {
        paramToServiceMsg.putString("skip_url", paramFromServiceMsg.bytes_skip_url.get().toStringUtf8());
      }
      if (paramFromServiceMsg.bytes_vas_result.has()) {
        paramToServiceMsg.putByteArray("vaskey", paramFromServiceMsg.bytes_vas_result.get().toByteArray());
      }
      ((PhoneUnityManager)this.b.getManager(101)).a(paramToServiceMsg);
      paramObject = paramToServiceMsg;
      bool2 = bool1;
      continue;
      label589:
      bool2 = false;
      paramObject = paramToServiceMsg;
      continue;
      label597:
      i += 1;
      continue;
      label606:
      boolean bool1 = false;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    paramToServiceMsg = null;
    Oidb_0x6df.PhoneInfo localPhoneInfo = null;
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          break label622;
        }
        paramObject = new oidb_sso.OIDBSSOPkg();
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if (!paramObject.uint32_result.has()) {
          break label639;
        }
        i = paramObject.uint32_result.get();
        if (!paramObject.bytes_bodybuffer.has()) {
          break label622;
        }
        paramFromServiceMsg = new Oidb_0x6df.RspBody();
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label622;
        }
        int k = paramFromServiceMsg.uint32_result.get();
        if (k != 0) {
          break label645;
        }
        bool1 = true;
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
          paramToServiceMsg.putInt("sso_result", i);
          if (paramFromServiceMsg.uint32_src.has()) {
            paramToServiceMsg.putInt("src", paramFromServiceMsg.uint32_src.get());
          }
          if (paramFromServiceMsg.str_country_code.has()) {
            paramToServiceMsg.putString("country_code", paramFromServiceMsg.str_country_code.get());
          }
          if (paramFromServiceMsg.str_binding_phone.has()) {
            paramToServiceMsg.putString("phone", paramFromServiceMsg.str_binding_phone.get());
          }
          if (paramFromServiceMsg.uint32_binding_time.has()) {
            paramToServiceMsg.putInt("binding_time", paramFromServiceMsg.uint32_binding_time.get());
          }
          if (paramFromServiceMsg.uint32_need_unify.has()) {
            paramToServiceMsg.putInt("need_unify", paramFromServiceMsg.uint32_need_unify.get());
          }
          if (paramFromServiceMsg.uint32_phone_type.has()) {
            paramToServiceMsg.putInt("phone_type", paramFromServiceMsg.uint32_phone_type.get());
          }
          if (!paramFromServiceMsg.phone_info.has()) {
            continue;
          }
          paramObject = new Bundle[paramFromServiceMsg.phone_info.size()];
          i = j;
          if (i >= paramFromServiceMsg.phone_info.size()) {
            continue;
          }
          localPhoneInfo = (Oidb_0x6df.PhoneInfo)paramFromServiceMsg.phone_info.get(i);
          if (localPhoneInfo == null) {
            break label630;
          }
          Bundle localBundle = new Bundle();
          if (localPhoneInfo.uint32_type.has()) {
            localBundle.putInt("phone_type", localPhoneInfo.uint32_type.get());
          }
          if (localPhoneInfo.str_country_code.has()) {
            localBundle.putString("country_code", localPhoneInfo.str_country_code.get());
          }
          if (localPhoneInfo.str_phone.has()) {
            localBundle.putString("phone", localPhoneInfo.str_phone.get());
          }
          if (localPhoneInfo.uint32_bu_status.has()) {
            localBundle.putInt("status", localPhoneInfo.uint32_bu_status.get());
          }
          paramObject[i] = localBundle;
        }
        catch (Exception paramFromServiceMsg) {}
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg = localPhoneInfo;
        continue;
      }
      paramObject = paramToServiceMsg;
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onSetPhoneBindInfo error:" + paramFromServiceMsg.getMessage());
        bool2 = bool1;
        paramObject = paramToServiceMsg;
      }
      a(6, bool2, paramObject);
      return;
      paramToServiceMsg.putParcelableArray("phone_info", paramObject);
      if (paramFromServiceMsg.bytes_skip_url.has()) {
        paramToServiceMsg.putString("skip_url", paramFromServiceMsg.bytes_skip_url.get().toStringUtf8());
      }
      if (paramFromServiceMsg.bytes_vas_result.has()) {
        paramToServiceMsg.putByteArray("vaskey", paramFromServiceMsg.bytes_vas_result.get().toByteArray());
      }
      ((PhoneUnityManager)this.b.getManager(101)).a(paramToServiceMsg);
      paramObject = paramToServiceMsg;
      bool2 = bool1;
      continue;
      label622:
      bool2 = false;
      paramObject = paramToServiceMsg;
      continue;
      label630:
      i += 1;
      continue;
      label639:
      int i = -1;
      continue;
      label645:
      boolean bool1 = false;
    }
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
          break label212;
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
          a(7, bool2, paramToServiceMsg);
          return;
        }
        catch (Exception paramObject)
        {
          break label150;
        }
        paramObject = paramObject;
        paramFromServiceMsg = null;
        bool1 = false;
      }
      label150:
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onBindPhoneNumLogin error:" + paramObject.getMessage());
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = bool1;
        continue;
        label212:
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
          break label212;
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
          a(8, bool2, paramToServiceMsg);
          return;
        }
        catch (Exception paramObject)
        {
          break label150;
        }
        paramObject = paramObject;
        paramFromServiceMsg = null;
        bool1 = false;
      }
      label150:
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("SecSvcHandler", 2, "onUnbindPhoneNumLogin error:" + paramObject.getMessage());
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = bool1;
        continue;
        label212:
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
      ((QPUpdateManager)this.b.getManager(193)).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("SecSvcHandler", 2, "[SFU] onQQProtectUpdate error:" + paramToServiceMsg.getMessage());
    }
  }
  
  protected Class a()
  {
    return SecSvcObserver.class;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        localObject1 = new Oidb_0x6de.DevInfo();
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Object localObject4;
        int i;
        label206:
        localObject1 = null;
      }
      for (;;)
      {
        try
        {
          localObject2 = this.b.getApplication().getApplicationContext();
          ((Oidb_0x6de.DevInfo)localObject1).uint32_appid.set(AppSetting.a);
          ((Oidb_0x6de.DevInfo)localObject1).bytes_imei.set(ByteStringMicro.copyFromUtf8(DeviceInfoUtil.a()));
          ((Oidb_0x6de.DevInfo)localObject1).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
          localObject4 = Settings.Secure.getString(((Context)localObject2).getContentResolver(), "android_id");
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            ((Oidb_0x6de.DevInfo)localObject1).bytes_androidid.set(ByteStringMicro.copyFromUtf8((String)localObject4));
          }
          localObject4 = ((Oidb_0x6de.DevInfo)localObject1).uint32_wifi;
          if (Apn.getApnType((Context)localObject2) == 3)
          {
            i = 1;
            ((PBUInt32Field)localObject4).set(i);
            localObject2 = localObject1;
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          continue;
        }
        try
        {
          localObject1 = new Oidb_0x6de.ReqBody();
        }
        catch (Exception paramString2)
        {
          paramString1 = null;
          paramString2.printStackTrace();
          break label206;
        }
      }
      try
      {
        ((Oidb_0x6de.ReqBody)localObject1).uint32_src.set(paramInt1);
        ((Oidb_0x6de.ReqBody)localObject1).uint32_phone_type.set(paramInt2);
        if (!TextUtils.isEmpty(paramString1)) {
          ((Oidb_0x6de.ReqBody)localObject1).str_country_code.set(paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          ((Oidb_0x6de.ReqBody)localObject1).str_phone.set(paramString2);
        }
        paramString1 = (String)localObject1;
        if (localObject2 != null)
        {
          ((Oidb_0x6de.ReqBody)localObject1).dev_info.set((MessageMicro)localObject2);
          paramString1 = (String)localObject1;
        }
        paramString2 = new oidb_sso.OIDBSSOPkg();
        paramString2.uint32_command.set(1758);
        paramString2.uint32_service_type.set(0);
        paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
        paramString1 = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "OidbSvc.0x6de");
        paramString1.putWupBuffer(paramString2.toByteArray());
        b(paramString1);
        return;
      }
      catch (Exception paramString2)
      {
        paramString1 = (String)localObject1;
        break;
      }
      i = 0;
      continue;
      localException1.printStackTrace();
      localObject3 = localObject1;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        localObject1 = new Oidb_0x6df.DevInfo();
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Object localObject4;
        int i;
        label195:
        localObject1 = null;
      }
      for (;;)
      {
        try
        {
          localObject2 = this.b.getApplication().getApplicationContext();
          ((Oidb_0x6df.DevInfo)localObject1).uint32_appid.set(AppSetting.a);
          ((Oidb_0x6df.DevInfo)localObject1).bytes_imei.set(ByteStringMicro.copyFromUtf8(DeviceInfoUtil.a()));
          ((Oidb_0x6df.DevInfo)localObject1).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
          localObject4 = Settings.Secure.getString(((Context)localObject2).getContentResolver(), "android_id");
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            ((Oidb_0x6df.DevInfo)localObject1).bytes_androidid.set(ByteStringMicro.copyFromUtf8((String)localObject4));
          }
          localObject4 = ((Oidb_0x6df.DevInfo)localObject1).uint32_wifi;
          if (Apn.getApnType((Context)localObject2) == 3)
          {
            i = 1;
            ((PBUInt32Field)localObject4).set(i);
            localObject2 = localObject1;
          }
        }
        catch (Exception localException2)
        {
          Object localObject3;
          continue;
        }
        try
        {
          localObject1 = new Oidb_0x6df.ReqBody();
        }
        catch (Exception paramString2)
        {
          paramString1 = null;
          paramString2.printStackTrace();
          break label195;
        }
      }
      try
      {
        ((Oidb_0x6df.ReqBody)localObject1).uint32_src.set(paramInt);
        if (!TextUtils.isEmpty(paramString1)) {
          ((Oidb_0x6df.ReqBody)localObject1).str_country_code.set(paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          ((Oidb_0x6df.ReqBody)localObject1).str_phone.set(paramString2);
        }
        paramString1 = (String)localObject1;
        if (localObject2 != null)
        {
          ((Oidb_0x6df.ReqBody)localObject1).dev_info.set((MessageMicro)localObject2);
          paramString1 = (String)localObject1;
        }
        paramString2 = new oidb_sso.OIDBSSOPkg();
        paramString2.uint32_command.set(1759);
        paramString2.uint32_service_type.set(0);
        paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
        paramString1 = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "OidbSvc.0x6df");
        paramString1.putWupBuffer(paramString2.toByteArray());
        b(paramString1);
        return;
      }
      catch (Exception paramString2)
      {
        paramString1 = (String)localObject1;
        break;
      }
      i = 0;
      continue;
      localException1.printStackTrace();
      localObject3 = localObject1;
    }
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
        ((QPUpdateManager)this.b.getManager(193)).b(i);
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
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equalsIgnoreCase("SecuritySvc.GetConfig"))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("DevLockAuthSvc.WxMsgOpt"))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("DevLockSecSvc.DevLockQuery"))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0x614_1"))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0x6de"))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str.equalsIgnoreCase("OidbSvc.0x6df"))
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
    SecSvcHandlerHelper.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecSvcHandler", 2, "getAntiFraudConfig");
    }
    get_config.ReqBody localReqBody = new get_config.ReqBody();
    localReqBody.u64_uin.set(this.b.getLongAccountUin());
    localReqBody.u32_appid.set(AppSetting.a);
    localReqBody.u32_proto_version.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.u32_seq;
    int i = this.a;
    this.a = (i + 1);
    localPBUInt32Field.set(i);
    localReqBody.str_config_name.set(paramString);
    paramString = AntiFraudConfigFileUtil.a().a(paramString, "Version");
    int j = 0;
    i = j;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Integer.parseInt(paramString);
      localReqBody.u32_config_version.set(i);
      paramString = a("SecuritySvc.GetConfig");
      paramString.putWupBuffer(localReqBody.toByteArray());
      b(paramString);
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
    localObject = a("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      a(7, false, null);
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
    b((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.b.getLongAccountUin());
    localReqBody.uint32_cmd.set(1);
    Object localObject = localReqBody.uint32_seq;
    int i = this.a;
    this.a = (i + 1);
    ((PBUInt32Field)localObject).set(i);
    localReqBody.uint32_opt.set(1);
    localObject = a("DevLockAuthSvc.WxMsgOpt");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      a(8, false, Integer.valueOf(-1));
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
    b((ToServiceMsg)localObject);
  }
  
  public void c()
  {
    device_lock_query_status.ReqBody localReqBody = new device_lock_query_status.ReqBody();
    Object localObject = localReqBody.u32_seq;
    int i = this.a;
    this.a = (i + 1);
    ((PBUInt32Field)localObject).set(i);
    localReqBody.u32_sys_type.set(1);
    localReqBody.u32_app_id.set(AppSetting.a);
    localObject = a("DevLockSecSvc.DevLockQuery");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcHandler
 * JD-Core Version:    0.7.0.1
 */