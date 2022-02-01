package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;

class NotificationActivity$22
  implements DialogInterface.OnClickListener
{
  NotificationActivity$22(NotificationActivity paramNotificationActivity, String paramString1, int paramInt, String paramString2) {}
  
  /* Error */
  public void onClick(android.content.DialogInterface paramDialogInterface, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +144 -> 151
    //   10: aload_0
    //   11: getfield 15	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   14: invokevirtual 41	com/tencent/mobileqq/activity/NotificationActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   17: invokevirtual 47	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   20: astore_1
    //   21: new 49	android/content/Intent
    //   24: dup
    //   25: invokespecial 50	android/content/Intent:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 52
    //   32: aload_1
    //   33: invokevirtual 56	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   36: pop
    //   37: aload_0
    //   38: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: astore 4
    //   43: aload 4
    //   45: ldc 58
    //   47: invokevirtual 64	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   50: iconst_m1
    //   51: if_icmpne +44 -> 95
    //   54: new 66	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   61: astore 5
    //   63: aload 5
    //   65: aload 4
    //   67: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: ldc 73
    //   75: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: aload_1
    //   82: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 5
    //   88: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore_1
    //   92: goto +41 -> 133
    //   95: new 66	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   102: astore 5
    //   104: aload 5
    //   106: aload 4
    //   108: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 5
    //   114: ldc 78
    //   116: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: aload_1
    //   123: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 5
    //   129: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_1
    //   133: aload_3
    //   134: ldc 80
    //   136: aload_1
    //   137: invokevirtual 56	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   140: pop
    //   141: aload_0
    //   142: getfield 15	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   145: aload_3
    //   146: ldc 82
    //   148: invokestatic 87	com/tencent/mobileqq/app/utils/RouteUtils:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V
    //   151: new 89	com/tencent/ims/AlertReport$ButtonAction
    //   154: dup
    //   155: invokespecial 90	com/tencent/ims/AlertReport$ButtonAction:<init>	()V
    //   158: astore_1
    //   159: aload_1
    //   160: getfield 94	com/tencent/ims/AlertReport$ButtonAction:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   163: iconst_1
    //   164: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   167: aload_1
    //   168: getfield 103	com/tencent/ims/AlertReport$ButtonAction:uint32_button_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: aload_0
    //   172: getfield 19	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_Int	I
    //   175: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   178: aload_1
    //   179: getfield 107	com/tencent/ims/AlertReport$ButtonAction:str_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   182: invokestatic 111	com/tencent/qqprotect/common/BaseQPMiscUtils:a	()Ljava/lang/String;
    //   185: invokevirtual 116	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   188: aload_1
    //   189: getfield 119	com/tencent/ims/AlertReport$ButtonAction:uint32_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   192: invokestatic 124	com/tencent/common/config/AppSetting:a	()I
    //   195: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   198: aload_0
    //   199: getfield 15	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   202: invokevirtual 41	com/tencent/mobileqq/activity/NotificationActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   205: aload_1
    //   206: invokevirtual 128	com/tencent/ims/AlertReport$ButtonAction:toByteArray	()[B
    //   209: ldc 130
    //   211: invokestatic 135	com/tencent/biz/ProtoUtils:a	(Lmqq/app/AppRuntime;[BLjava/lang/String;)V
    //   214: aconst_null
    //   215: ldc 137
    //   217: ldc 139
    //   219: ldc 141
    //   221: ldc 143
    //   223: ldc 143
    //   225: aload_0
    //   226: getfield 19	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_Int	I
    //   229: iconst_0
    //   230: aload_0
    //   231: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	Ljava/lang/String;
    //   234: ldc 141
    //   236: ldc 141
    //   238: ldc 141
    //   240: invokestatic 148	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto +116 -> 359
    //   246: astore_1
    //   247: goto +108 -> 355
    //   250: astore_1
    //   251: goto +116 -> 367
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   259: new 89	com/tencent/ims/AlertReport$ButtonAction
    //   262: dup
    //   263: invokespecial 90	com/tencent/ims/AlertReport$ButtonAction:<init>	()V
    //   266: astore_1
    //   267: aload_1
    //   268: getfield 94	com/tencent/ims/AlertReport$ButtonAction:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   271: iconst_1
    //   272: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   275: aload_1
    //   276: getfield 103	com/tencent/ims/AlertReport$ButtonAction:uint32_button_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   279: aload_0
    //   280: getfield 19	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_Int	I
    //   283: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   286: aload_1
    //   287: getfield 107	com/tencent/ims/AlertReport$ButtonAction:str_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   290: invokestatic 111	com/tencent/qqprotect/common/BaseQPMiscUtils:a	()Ljava/lang/String;
    //   293: invokevirtual 116	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   296: aload_1
    //   297: getfield 119	com/tencent/ims/AlertReport$ButtonAction:uint32_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   300: invokestatic 124	com/tencent/common/config/AppSetting:a	()I
    //   303: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   306: aload_0
    //   307: getfield 15	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   310: invokevirtual 41	com/tencent/mobileqq/activity/NotificationActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   313: aload_1
    //   314: invokevirtual 128	com/tencent/ims/AlertReport$ButtonAction:toByteArray	()[B
    //   317: ldc 130
    //   319: invokestatic 135	com/tencent/biz/ProtoUtils:a	(Lmqq/app/AppRuntime;[BLjava/lang/String;)V
    //   322: aconst_null
    //   323: ldc 137
    //   325: ldc 139
    //   327: ldc 141
    //   329: ldc 143
    //   331: ldc 143
    //   333: aload_0
    //   334: getfield 19	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_Int	I
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	Ljava/lang/String;
    //   342: ldc 141
    //   344: ldc 141
    //   346: ldc 141
    //   348: invokestatic 148	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto +8 -> 359
    //   354: astore_1
    //   355: aload_1
    //   356: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   359: aload_0
    //   360: getfield 15	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   363: invokevirtual 154	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   366: return
    //   367: new 89	com/tencent/ims/AlertReport$ButtonAction
    //   370: dup
    //   371: invokespecial 90	com/tencent/ims/AlertReport$ButtonAction:<init>	()V
    //   374: astore_3
    //   375: aload_3
    //   376: getfield 94	com/tencent/ims/AlertReport$ButtonAction:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   379: iconst_1
    //   380: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   383: aload_3
    //   384: getfield 103	com/tencent/ims/AlertReport$ButtonAction:uint32_button_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   387: aload_0
    //   388: getfield 19	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_Int	I
    //   391: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   394: aload_3
    //   395: getfield 107	com/tencent/ims/AlertReport$ButtonAction:str_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   398: invokestatic 111	com/tencent/qqprotect/common/BaseQPMiscUtils:a	()Ljava/lang/String;
    //   401: invokevirtual 116	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   404: aload_3
    //   405: getfield 119	com/tencent/ims/AlertReport$ButtonAction:uint32_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   408: invokestatic 124	com/tencent/common/config/AppSetting:a	()I
    //   411: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   414: aload_0
    //   415: getfield 15	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   418: invokevirtual 41	com/tencent/mobileqq/activity/NotificationActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   421: aload_3
    //   422: invokevirtual 128	com/tencent/ims/AlertReport$ButtonAction:toByteArray	()[B
    //   425: ldc 130
    //   427: invokestatic 135	com/tencent/biz/ProtoUtils:a	(Lmqq/app/AppRuntime;[BLjava/lang/String;)V
    //   430: aconst_null
    //   431: ldc 137
    //   433: ldc 139
    //   435: ldc 141
    //   437: ldc 143
    //   439: ldc 143
    //   441: aload_0
    //   442: getfield 19	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_Int	I
    //   445: iconst_0
    //   446: aload_0
    //   447: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	Ljava/lang/String;
    //   450: ldc 141
    //   452: ldc 141
    //   454: ldc 141
    //   456: invokestatic 148	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   459: goto +8 -> 467
    //   462: astore_3
    //   463: aload_3
    //   464: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   467: aload_0
    //   468: getfield 15	com/tencent/mobileqq/activity/NotificationActivity$22:jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   471: invokevirtual 154	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   474: aload_1
    //   475: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	22
    //   0	476	1	paramDialogInterface	android.content.DialogInterface
    //   0	476	2	paramInt	int
    //   28	394	3	localObject	Object
    //   462	2	3	localException	java.lang.Exception
    //   41	66	4	str	String
    //   61	67	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   151	243	246	java/lang/Exception
    //   0	92	250	finally
    //   95	133	250	finally
    //   133	151	250	finally
    //   255	259	250	finally
    //   0	92	254	java/lang/Exception
    //   95	133	254	java/lang/Exception
    //   133	151	254	java/lang/Exception
    //   259	351	354	java/lang/Exception
    //   367	459	462	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.22
 * JD-Core Version:    0.7.0.1
 */