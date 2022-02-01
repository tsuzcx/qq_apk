package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopHandler$Oidb0xb36
{
  public static String a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = "OidbSvc.0xb36_1";
  }
  
  /* Error */
  public static void a(TroopHandler paramTroopHandler, ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 28	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc 30
    //   6: invokevirtual 36	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +28 -> 41
    //   16: ldc 44
    //   18: iconst_2
    //   19: new 46	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   26: ldc 49
    //   28: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_2
    //   42: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   45: ifne +49 -> 94
    //   48: ldc 44
    //   50: iconst_1
    //   51: iconst_3
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: ldc 68
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_2
    //   63: invokevirtual 71	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_2
    //   70: invokevirtual 72	com/tencent/qphone/base/remote/FromServiceMsg:toString	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   77: aload_0
    //   78: getstatic 81	com/tencent/mobileqq/service/troop/TroopNotificationConstants:jdField_a_of_type_Int	I
    //   81: iconst_0
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: invokevirtual 87	com/tencent/mobileqq/app/TroopHandler:notifyUI	(IZLjava/lang/Object;)V
    //   93: return
    //   94: new 89	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: dup
    //   98: invokespecial 90	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   101: astore_2
    //   102: aload_2
    //   103: aload_3
    //   104: checkcast 92	[B
    //   107: checkcast 92	[B
    //   110: invokevirtual 96	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: checkcast 89	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   116: astore_2
    //   117: new 98	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody
    //   120: dup
    //   121: invokespecial 99	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody:<init>	()V
    //   124: astore_3
    //   125: aload_3
    //   126: aload_2
    //   127: getfield 103	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   130: invokevirtual 109	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   133: invokevirtual 115	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   136: invokevirtual 116	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   139: pop
    //   140: aload_0
    //   141: invokestatic 119	com/tencent/mobileqq/app/TroopHandler:a	(Lcom/tencent/mobileqq/app/TroopHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   144: getstatic 124	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   147: invokevirtual 130	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   150: checkcast 132	com/tencent/mobileqq/app/TroopManager
    //   153: aload_3
    //   154: invokevirtual 135	com/tencent/mobileqq/app/TroopManager:a	(Ltencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody;)V
    //   157: aload_0
    //   158: getstatic 81	com/tencent/mobileqq/service/troop/TroopNotificationConstants:jdField_a_of_type_Int	I
    //   161: iconst_1
    //   162: iconst_1
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_1
    //   169: aastore
    //   170: invokevirtual 87	com/tencent/mobileqq/app/TroopHandler:notifyUI	(IZLjava/lang/Object;)V
    //   173: return
    //   174: astore_2
    //   175: ldc 44
    //   177: iconst_1
    //   178: ldc 137
    //   180: aload_2
    //   181: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: aload_0
    //   185: getstatic 81	com/tencent/mobileqq/service/troop/TroopNotificationConstants:jdField_a_of_type_Int	I
    //   188: iconst_0
    //   189: iconst_1
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_1
    //   196: aastore
    //   197: invokevirtual 87	com/tencent/mobileqq/app/TroopHandler:notifyUI	(IZLjava/lang/Object;)V
    //   200: return
    //   201: astore_2
    //   202: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq -48 -> 157
    //   208: ldc 44
    //   210: iconst_2
    //   211: ldc 142
    //   213: aload_2
    //   214: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: goto -60 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramTroopHandler	TroopHandler
    //   0	220	1	paramToServiceMsg	ToServiceMsg
    //   0	220	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	220	3	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   102	117	174	java/lang/Exception
    //   125	157	201	java/lang/Exception
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
      localObject = paramTroopHandler.createToServiceMsg(jdField_a_of_type_JavaLangString);
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      paramTroopHandler.sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException paramTroopHandler)
    {
      QLog.e(".troop.survey", 1, "send_oidb_0xb36 error! ", paramTroopHandler);
    }
  }
  
  /* Error */
  public static boolean a(TroopHandler paramTroopHandler, com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo paramTroopUnreadMsgInfo, tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 220	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   4: ldc2_w 221
    //   7: lcmp
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +70 -> 86
    //   19: ldc 44
    //   21: iconst_2
    //   22: bipush 8
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: ldc 224
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_1
    //   35: getfield 225	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: ldc 227
    //   43: aastore
    //   44: dup
    //   45: iconst_3
    //   46: aload_1
    //   47: getfield 230	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   50: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc 238
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: aload_1
    //   62: getfield 239	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   65: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: dup
    //   70: bipush 6
    //   72: ldc 241
    //   74: aastore
    //   75: dup
    //   76: bipush 7
    //   78: iload_3
    //   79: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   86: aload_2
    //   87: ifnull +118 -> 205
    //   90: aload_2
    //   91: getfield 249	tencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum:msg_app_tip_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$AppTipNotify;
    //   94: invokevirtual 254	tencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$AppTipNotify:has	()Z
    //   97: ifeq +108 -> 205
    //   100: aload_2
    //   101: getfield 249	tencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum:msg_app_tip_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$AppTipNotify;
    //   104: getfield 257	tencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$AppTipNotify:bytes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   107: invokevirtual 109	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   110: invokevirtual 260	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   113: astore_2
    //   114: aload_2
    //   115: invokestatic 266	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +87 -> 205
    //   121: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +35 -> 159
    //   127: ldc 44
    //   129: iconst_2
    //   130: iconst_4
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: ldc 224
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload_1
    //   142: getfield 225	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: ldc_w 268
    //   151: aastore
    //   152: dup
    //   153: iconst_3
    //   154: aload_2
    //   155: aastore
    //   156: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   159: new 270	org/json/JSONObject
    //   162: dup
    //   163: aload_2
    //   164: invokespecial 273	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   167: astore 4
    //   169: ldc_w 275
    //   172: ldc_w 277
    //   175: aload 4
    //   177: invokevirtual 278	org/json/JSONObject:toString	()Ljava/lang/String;
    //   180: ldc_w 280
    //   183: invokestatic 285	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   186: pop
    //   187: ldc_w 287
    //   190: ldc_w 277
    //   193: aload 4
    //   195: invokevirtual 278	org/json/JSONObject:toString	()Ljava/lang/String;
    //   198: ldc_w 280
    //   201: invokestatic 285	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   204: pop
    //   205: iload_3
    //   206: iconst_2
    //   207: if_icmpeq +10 -> 217
    //   210: aload_1
    //   211: getfield 230	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   214: ifeq +82 -> 296
    //   217: aload_0
    //   218: aload_1
    //   219: getfield 225	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: aload_1
    //   223: getfield 230	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   226: invokestatic 289	com/tencent/mobileqq/app/TroopHandler$Oidb0xb36:a	(Lcom/tencent/mobileqq/app/TroopHandler;Ljava/lang/String;I)V
    //   229: iconst_1
    //   230: ireturn
    //   231: astore 5
    //   233: ldc 44
    //   235: iconst_2
    //   236: ldc_w 291
    //   239: aload 5
    //   241: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: goto -57 -> 187
    //   247: astore 4
    //   249: ldc 44
    //   251: iconst_2
    //   252: new 46	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 293
    //   262: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_2
    //   266: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: aload 4
    //   274: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: goto -72 -> 205
    //   280: astore 4
    //   282: ldc 44
    //   284: iconst_2
    //   285: ldc_w 291
    //   288: aload 4
    //   290: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -88 -> 205
    //   296: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq -70 -> 229
    //   302: ldc 44
    //   304: iconst_2
    //   305: bipush 8
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: ldc 224
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: aload_1
    //   318: getfield 225	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: aastore
    //   322: dup
    //   323: iconst_2
    //   324: ldc 227
    //   326: aastore
    //   327: dup
    //   328: iconst_3
    //   329: aload_1
    //   330: getfield 230	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:b	I
    //   333: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: aastore
    //   337: dup
    //   338: iconst_4
    //   339: ldc 238
    //   341: aastore
    //   342: dup
    //   343: iconst_5
    //   344: aload_1
    //   345: getfield 239	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   348: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: aastore
    //   352: dup
    //   353: bipush 6
    //   355: ldc_w 295
    //   358: aastore
    //   359: dup
    //   360: bipush 7
    //   362: iload_3
    //   363: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: aastore
    //   367: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   370: goto -141 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	paramTroopHandler	TroopHandler
    //   0	373	1	paramTroopUnreadMsgInfo	com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo
    //   0	373	2	paramSubCmd0x1UpdateAppUnreadNum	tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum
    //   0	373	3	paramInt	int
    //   167	27	4	localJSONObject	org.json.JSONObject
    //   247	26	4	localJSONException	org.json.JSONException
    //   280	9	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   231	9	5	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   169	187	231	java/lang/UnsatisfiedLinkError
    //   121	159	247	org/json/JSONException
    //   159	169	247	org/json/JSONException
    //   169	187	247	org/json/JSONException
    //   187	205	247	org/json/JSONException
    //   233	244	247	org/json/JSONException
    //   282	293	247	org/json/JSONException
    //   187	205	280	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.Oidb0xb36
 * JD-Core Version:    0.7.0.1
 */