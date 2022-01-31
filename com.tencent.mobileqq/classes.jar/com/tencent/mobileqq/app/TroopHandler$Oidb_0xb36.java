package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import zuu;

public class TroopHandler$Oidb_0xb36
{
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OidbSvc.0xb36_1";
  }
  
  /* Error */
  public static void a(TroopHandler paramTroopHandler, ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 25	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc 27
    //   6: invokevirtual 33	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +28 -> 41
    //   16: ldc 41
    //   18: iconst_2
    //   19: new 43	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   26: ldc 46
    //   28: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_2
    //   42: invokevirtual 63	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   45: ifne +47 -> 92
    //   48: ldc 41
    //   50: iconst_1
    //   51: iconst_3
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: ldc 65
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_2
    //   63: invokevirtual 68	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_2
    //   70: invokevirtual 69	com/tencent/qphone/base/remote/FromServiceMsg:toString	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   77: aload_0
    //   78: iconst_1
    //   79: iconst_0
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: aastore
    //   88: invokevirtual 78	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   91: return
    //   92: new 80	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 81	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: astore_2
    //   100: aload_2
    //   101: aload_3
    //   102: checkcast 83	[B
    //   105: checkcast 83	[B
    //   108: invokevirtual 87	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 80	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_2
    //   115: new 89	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody
    //   118: dup
    //   119: invokespecial 90	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody:<init>	()V
    //   122: astore_3
    //   123: aload_3
    //   124: aload_2
    //   125: getfield 94	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   128: invokevirtual 100	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   131: invokevirtual 106	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   134: invokevirtual 107	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   137: pop
    //   138: aload_0
    //   139: getfield 111	com/tencent/mobileqq/app/TroopHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   142: bipush 51
    //   144: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   147: checkcast 119	com/tencent/mobileqq/app/TroopManager
    //   150: aload_3
    //   151: invokevirtual 122	com/tencent/mobileqq/app/TroopManager:a	(Ltencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody;)V
    //   154: aload_0
    //   155: iconst_1
    //   156: iconst_1
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_1
    //   164: aastore
    //   165: invokevirtual 78	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   168: return
    //   169: astore_2
    //   170: ldc 41
    //   172: iconst_1
    //   173: ldc 124
    //   175: aload_2
    //   176: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload_0
    //   180: iconst_1
    //   181: iconst_0
    //   182: iconst_1
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload_1
    //   189: aastore
    //   190: invokevirtual 78	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   193: return
    //   194: astore_2
    //   195: invokestatic 39	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq -44 -> 154
    //   201: ldc 41
    //   203: iconst_2
    //   204: ldc 129
    //   206: aload_2
    //   207: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: goto -56 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramTroopHandler	TroopHandler
    //   0	213	1	paramToServiceMsg	ToServiceMsg
    //   0	213	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	213	3	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   100	115	169	java/lang/Exception
    //   123	154	194	java/lang/Exception
  }
  
  public static void a(TroopHandler paramTroopHandler, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.survey", 2, "send_oidb_0xb36, troopUin = " + paramString);
    }
    Object localObject = new oidb_cmd0xb36.ReqBody();
    try
    {
      long l = Long.parseLong(paramString);
      ((oidb_cmd0xb36.ReqBody)localObject).group_id.set(l);
      ((oidb_cmd0xb36.ReqBody)localObject).red_point_num.set(paramInt);
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(2870);
      localOIDBSSOPkg.uint32_service_type.set(1);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xb36.ReqBody)localObject).toByteArray()));
      localObject = paramTroopHandler.a(jdField_a_of_type_JavaLangString);
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      paramTroopHandler.b((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException paramTroopHandler)
    {
      QLog.e(".troop.survey", 1, "send_oidb_0xb36 error! ", paramTroopHandler);
    }
  }
  
  public static boolean a(TroopHandler paramTroopHandler, TroopUnreadMsgInfo paramTroopUnreadMsgInfo, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, int paramInt)
  {
    if (paramTroopUnreadMsgInfo.jdField_a_of_type_Long != 1106717414L) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.survey", 2, new Object[] { "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, " newNum: ", Integer.valueOf(paramTroopUnreadMsgInfo.b), " unreadNumber: ", Integer.valueOf(paramTroopUnreadMsgInfo.jdField_a_of_type_Int), " from: ", Integer.valueOf(paramInt) });
    }
    if ((paramSubCmd0x1UpdateAppUnreadNum != null) && (paramSubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has()))
    {
      paramSubCmd0x1UpdateAppUnreadNum = paramSubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.bytes_text.get().toStringUtf8();
      if (TextUtils.isEmpty(paramSubCmd0x1UpdateAppUnreadNum)) {}
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, new Object[] { "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, " will notify ark com.tencent.groupDragon, data: ", paramSubCmd0x1UpdateAppUnreadNum });
      }
      JSONObject localJSONObject = new JSONObject(paramSubCmd0x1UpdateAppUnreadNum);
      ArkAppCenter.a().post(new zuu(localJSONObject));
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(".troop.survey", 2, "Error: json decode error, string is " + paramSubCmd0x1UpdateAppUnreadNum, localJSONException);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(".troop.survey", 2, new Object[] { "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, " newNum: ", Integer.valueOf(paramTroopUnreadMsgInfo.b), " unreadNumber: ", Integer.valueOf(paramTroopUnreadMsgInfo.jdField_a_of_type_Int), " no need to send_oidb_0xb36 , from is: ", Integer.valueOf(paramInt) });
        }
      }
    }
    if ((paramInt == 2) || (paramTroopUnreadMsgInfo.b != 0))
    {
      a(paramTroopHandler, paramTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, paramTroopUnreadMsgInfo.b);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.Oidb_0xb36
 * JD-Core Version:    0.7.0.1
 */