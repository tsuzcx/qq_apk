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
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
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
import tencent.im.oidb.cmd0x614.Oidb_0x614.DeviceManageHead;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReNameDeviceNameReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614.ReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614.RspBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8.ReqBody;
import tencent.im.oidb.cmd0xebd.oidb_0xebd.RspBody;
import tencent.im.oidb.cmd0xec0.oidb_0xec0.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.AccountExceptionAlertBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6.MsgBody;

public class SecSvcHandler
  extends BusinessHandler
{
  private int jdField_a_of_type_Int = 1;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  SecSvcHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
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
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +737 -> 738
    //   4: aload_2
    //   5: invokevirtual 134	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifeq +730 -> 738
    //   11: new 136	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   14: dup
    //   15: invokespecial 139	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 143	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   24: invokevirtual 147	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: pop
    //   28: aload_3
    //   29: getfield 153	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   32: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   35: ifne +703 -> 738
    //   38: aload_3
    //   39: getfield 213	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   42: invokevirtual 216	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   45: ifeq +693 -> 738
    //   48: new 218	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody
    //   51: dup
    //   52: invokespecial 219	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:<init>	()V
    //   55: astore_1
    //   56: aload_1
    //   57: aload_3
    //   58: getfield 213	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   61: invokevirtual 222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   64: invokevirtual 227	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   67: invokevirtual 228	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   70: pop
    //   71: aload_1
    //   72: getfield 231	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:uint32_check_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   75: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   78: istore 4
    //   80: iload 4
    //   82: ifle +656 -> 738
    //   85: iconst_4
    //   86: istore 5
    //   88: iload 4
    //   90: iconst_4
    //   91: if_icmpeq +9 -> 100
    //   94: iconst_1
    //   95: istore 8
    //   97: goto +6 -> 103
    //   100: iconst_0
    //   101: istore 8
    //   103: new 149	android/os/Bundle
    //   106: dup
    //   107: invokespecial 150	android/os/Bundle:<init>	()V
    //   110: astore_2
    //   111: aload_2
    //   112: ldc 233
    //   114: iload 4
    //   116: invokevirtual 159	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   119: iload 4
    //   121: iconst_3
    //   122: if_icmpne +630 -> 752
    //   125: iconst_1
    //   126: istore 4
    //   128: goto +3 -> 131
    //   131: aload_2
    //   132: ldc 235
    //   134: iload 4
    //   136: invokevirtual 159	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   139: aload_1
    //   140: getfield 238	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:str_mibao_change_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   143: invokevirtual 51	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   146: ifeq +16 -> 162
    //   149: aload_2
    //   150: ldc 240
    //   152: aload_1
    //   153: getfield 238	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:str_mibao_change_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   156: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   159: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_1
    //   163: getfield 243	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:str_mibao_set_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: invokevirtual 51	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   169: ifeq +16 -> 185
    //   172: aload_2
    //   173: ldc 245
    //   175: aload_1
    //   176: getfield 243	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:str_mibao_set_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   179: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   182: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload_1
    //   186: getfield 248	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:str_mibao_verify_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   189: invokevirtual 51	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   192: ifeq +16 -> 208
    //   195: aload_2
    //   196: ldc 250
    //   198: aload_1
    //   199: getfield 248	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:str_mibao_verify_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   202: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   205: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_1
    //   209: getfield 254	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:rpt_phone_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   212: invokevirtual 257	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   215: ifeq +571 -> 786
    //   218: aload_1
    //   219: getfield 254	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:rpt_phone_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   222: invokevirtual 260	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   225: astore_3
    //   226: aload_3
    //   227: invokeinterface 265 1 0
    //   232: anewarray 149	android/os/Bundle
    //   235: astore 10
    //   237: iconst_0
    //   238: istore 4
    //   240: iload 4
    //   242: aload_3
    //   243: invokeinterface 265 1 0
    //   248: if_icmpge +359 -> 607
    //   251: aload_3
    //   252: iload 4
    //   254: invokeinterface 268 2 0
    //   259: checkcast 270	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo
    //   262: astore 11
    //   264: aload 11
    //   266: ifnonnull +6 -> 272
    //   269: goto +508 -> 777
    //   272: new 149	android/os/Bundle
    //   275: dup
    //   276: invokespecial 150	android/os/Bundle:<init>	()V
    //   279: astore 12
    //   281: aload 11
    //   283: getfield 273	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:uint32_phone_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   286: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   289: ifeq +469 -> 758
    //   292: aload 11
    //   294: getfield 273	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:uint32_phone_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   297: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   300: istore 7
    //   302: aload 12
    //   304: ldc_w 275
    //   307: iload 7
    //   309: invokevirtual 159	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   312: iload 7
    //   314: istore 6
    //   316: iload 7
    //   318: iload 5
    //   320: if_icmpne +47 -> 367
    //   323: aload_2
    //   324: ldc_w 277
    //   327: iconst_0
    //   328: invokevirtual 281	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   331: aload_2
    //   332: ldc_w 283
    //   335: aload 11
    //   337: getfield 286	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:str_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   340: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   343: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: aload_2
    //   347: ldc_w 288
    //   350: aload_1
    //   351: getfield 291	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$RspBody:str_verify_premibao_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   354: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   357: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: iload 7
    //   362: istore 6
    //   364: goto +3 -> 367
    //   367: aload 11
    //   369: getfield 294	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:str_country_code	Lcom/tencent/mobileqq/pb/PBStringField;
    //   372: invokevirtual 51	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   375: ifeq +40 -> 415
    //   378: aload 12
    //   380: ldc_w 296
    //   383: aload 11
    //   385: getfield 294	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:str_country_code	Lcom/tencent/mobileqq/pb/PBStringField;
    //   388: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   391: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: iload 6
    //   396: iconst_1
    //   397: if_icmpne +18 -> 415
    //   400: aload_2
    //   401: ldc_w 296
    //   404: aload 11
    //   406: getfield 294	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:str_country_code	Lcom/tencent/mobileqq/pb/PBStringField;
    //   409: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   412: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: aload 11
    //   417: getfield 286	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:str_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   420: invokevirtual 51	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   423: ifeq +40 -> 463
    //   426: aload 12
    //   428: ldc_w 298
    //   431: aload 11
    //   433: getfield 286	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:str_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   436: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   439: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: iload 6
    //   444: iconst_1
    //   445: if_icmpne +18 -> 463
    //   448: aload_2
    //   449: ldc_w 298
    //   452: aload 11
    //   454: getfield 286	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:str_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   457: invokevirtual 55	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   460: invokevirtual 168	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: aload 11
    //   465: getfield 301	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:uint32_phone_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   468: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   471: ifeq +296 -> 767
    //   474: aload 11
    //   476: getfield 301	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:uint32_phone_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   479: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   482: istore 5
    //   484: aload 12
    //   486: ldc_w 303
    //   489: iload 5
    //   491: invokevirtual 159	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   494: iload 6
    //   496: iconst_1
    //   497: if_icmpne +12 -> 509
    //   500: aload_2
    //   501: ldc_w 303
    //   504: iload 5
    //   506: invokevirtual 159	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   509: iload 5
    //   511: iconst_4
    //   512: if_icmpne +252 -> 764
    //   515: new 170	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   522: astore 13
    //   524: aload 13
    //   526: ldc_w 305
    //   529: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 13
    //   535: iload 6
    //   537: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 13
    //   543: ldc_w 310
    //   546: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 13
    //   552: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: astore 13
    //   557: ldc 27
    //   559: iconst_1
    //   560: aload 13
    //   562: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: iconst_0
    //   566: istore 8
    //   568: goto +3 -> 571
    //   571: iconst_4
    //   572: istore 5
    //   574: aload 11
    //   576: getfield 316	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:bytes_vas_phone	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   579: invokevirtual 216	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   582: ifeq +188 -> 770
    //   585: aload 12
    //   587: ldc_w 318
    //   590: aload 11
    //   592: getfield 316	tencent/im/oidb/cmd0xeb8/oidb_0xeb8$PhoneInfo:bytes_vas_phone	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   595: invokevirtual 222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   598: invokevirtual 227	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   601: invokevirtual 322	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   604: goto +166 -> 770
    //   607: aload_2
    //   608: ldc_w 324
    //   611: aload 10
    //   613: invokevirtual 328	android/os/Bundle:putParcelableArray	(Ljava/lang/String;[Landroid/os/Parcelable;)V
    //   616: aload_0
    //   617: getfield 16	com/tencent/mobileqq/app/SecSvcHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   620: getstatic 333	com/tencent/mobileqq/app/QQManagerFactory:PHONE_UNITY_MANAGER	I
    //   623: invokevirtual 337	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   626: checkcast 339	com/tencent/mobileqq/activity/contact/phonecontact/PhoneUnityManager
    //   629: aload_2
    //   630: invokevirtual 342	com/tencent/mobileqq/activity/contact/phonecontact/PhoneUnityManager:a	(Landroid/os/Bundle;)V
    //   633: goto +3 -> 636
    //   636: iconst_1
    //   637: istore 9
    //   639: aload_2
    //   640: ldc_w 344
    //   643: iload 8
    //   645: invokevirtual 281	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   648: aload_2
    //   649: astore_3
    //   650: goto +93 -> 743
    //   653: iconst_1
    //   654: istore 8
    //   656: astore_1
    //   657: goto +25 -> 682
    //   660: astore_1
    //   661: iconst_1
    //   662: istore 8
    //   664: goto +18 -> 682
    //   667: astore_1
    //   668: iconst_1
    //   669: istore 8
    //   671: aconst_null
    //   672: astore_2
    //   673: goto +9 -> 682
    //   676: astore_1
    //   677: aconst_null
    //   678: astore_2
    //   679: iconst_0
    //   680: istore 8
    //   682: iload 8
    //   684: istore 9
    //   686: aload_2
    //   687: astore_3
    //   688: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   691: ifeq +52 -> 743
    //   694: new 170	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   701: astore_3
    //   702: aload_3
    //   703: ldc_w 346
    //   706: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload_3
    //   711: aload_1
    //   712: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   715: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: ldc 27
    //   721: iconst_2
    //   722: aload_3
    //   723: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 33	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: iload 8
    //   731: istore 9
    //   733: aload_2
    //   734: astore_3
    //   735: goto +8 -> 743
    //   738: aconst_null
    //   739: astore_3
    //   740: iconst_0
    //   741: istore 9
    //   743: aload_0
    //   744: iconst_5
    //   745: iload 9
    //   747: aload_3
    //   748: invokevirtual 187	com/tencent/mobileqq/app/SecSvcHandler:notifyUI	(IZLjava/lang/Object;)V
    //   751: return
    //   752: iconst_0
    //   753: istore 4
    //   755: goto -624 -> 131
    //   758: iconst_m1
    //   759: istore 6
    //   761: goto -394 -> 367
    //   764: goto -193 -> 571
    //   767: goto -196 -> 571
    //   770: aload 10
    //   772: iload 4
    //   774: aload 12
    //   776: aastore
    //   777: iload 4
    //   779: iconst_1
    //   780: iadd
    //   781: istore 4
    //   783: goto -543 -> 240
    //   786: goto -150 -> 636
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	789	0	this	SecSvcHandler
    //   0	789	1	paramToServiceMsg	ToServiceMsg
    //   0	789	2	paramFromServiceMsg	FromServiceMsg
    //   0	789	3	paramObject	Object
    //   78	704	4	i	int
    //   86	487	5	j	int
    //   314	446	6	k	int
    //   300	61	7	m	int
    //   95	635	8	bool1	boolean
    //   637	109	9	bool2	boolean
    //   235	536	10	arrayOfBundle	Bundle[]
    //   262	329	11	localPhoneInfo	tencent.im.oidb.cmd0xeb8.oidb_0xeb8.PhoneInfo
    //   279	496	12	localBundle	Bundle
    //   522	39	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   557	565	653	java/lang/Exception
    //   574	604	653	java/lang/Exception
    //   607	633	653	java/lang/Exception
    //   639	648	653	java/lang/Exception
    //   111	119	660	java/lang/Exception
    //   131	162	660	java/lang/Exception
    //   162	185	660	java/lang/Exception
    //   185	208	660	java/lang/Exception
    //   208	237	660	java/lang/Exception
    //   240	264	660	java/lang/Exception
    //   272	312	660	java/lang/Exception
    //   323	360	660	java/lang/Exception
    //   367	394	660	java/lang/Exception
    //   400	415	660	java/lang/Exception
    //   415	442	660	java/lang/Exception
    //   448	463	660	java/lang/Exception
    //   463	494	660	java/lang/Exception
    //   500	509	660	java/lang/Exception
    //   515	557	660	java/lang/Exception
    //   103	111	667	java/lang/Exception
    //   4	80	676	java/lang/Exception
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
        ((QPUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQPROTECT_UPDATE_MANAGER)).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
    localReqBody.uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localReqBody.uint32_cmd.set(1);
    Object localObject = localReqBody.uint32_seq;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
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
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc.0xeb8");
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
            ((QPUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQPROTECT_UPDATE_MANAGER)).b(i);
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
    localReqBody.u64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localReqBody.u32_appid.set(AppSetting.a());
    localReqBody.u32_proto_version.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.u32_seq;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
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
    localReqBody.uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localReqBody.uint32_cmd.set(2);
    Object localObject = localReqBody.uint32_seq;
    int j = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (j + 1);
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
    ((ByteBuffer)localObject).putInt((int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
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
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc.0xa13");
    ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    device_lock_query_status.ReqBody localReqBody = new device_lock_query_status.ReqBody();
    Object localObject = localReqBody.u32_seq;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    ((PBUInt32Field)localObject).set(i);
    localReqBody.u32_sys_type.set(1);
    localReqBody.u32_app_id.set(AppSetting.a());
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
    ((ByteBuffer)localObject).putInt((int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    ((ByteBuffer)localObject).put((byte)paramArrayOfByte.length);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
    paramArrayOfByte.uint32_command.set(1197);
    paramArrayOfByte.uint32_service_type.set(11);
    paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x4ad");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcHandler
 * JD-Core Version:    0.7.0.1
 */