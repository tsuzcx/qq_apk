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
    //   1: getfield 19	com/tencent/mobileqq/activity/NotificationActivity$22:a	Ljava/lang/String;
    //   4: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +144 -> 151
    //   10: aload_0
    //   11: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:d	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   14: invokevirtual 43	com/tencent/mobileqq/activity/NotificationActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   17: invokevirtual 49	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   20: astore_1
    //   21: new 51	android/content/Intent
    //   24: dup
    //   25: invokespecial 52	android/content/Intent:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 54
    //   32: aload_1
    //   33: invokevirtual 58	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   36: pop
    //   37: aload_0
    //   38: getfield 19	com/tencent/mobileqq/activity/NotificationActivity$22:a	Ljava/lang/String;
    //   41: astore 4
    //   43: aload 4
    //   45: ldc 60
    //   47: invokevirtual 66	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   50: iconst_m1
    //   51: if_icmpne +44 -> 95
    //   54: new 68	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   61: astore 5
    //   63: aload 5
    //   65: aload 4
    //   67: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: ldc 75
    //   75: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: aload_1
    //   82: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 5
    //   88: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore_1
    //   92: goto +41 -> 133
    //   95: new 68	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   102: astore 5
    //   104: aload 5
    //   106: aload 4
    //   108: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 5
    //   114: ldc 80
    //   116: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: aload_1
    //   123: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 5
    //   129: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_1
    //   133: aload_3
    //   134: ldc 82
    //   136: aload_1
    //   137: invokevirtual 58	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   140: pop
    //   141: aload_0
    //   142: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:d	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   145: aload_3
    //   146: ldc 84
    //   148: invokestatic 89	com/tencent/mobileqq/app/utils/RouteUtils:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V
    //   151: new 91	com/tencent/ims/AlertReport$ButtonAction
    //   154: dup
    //   155: invokespecial 92	com/tencent/ims/AlertReport$ButtonAction:<init>	()V
    //   158: astore_1
    //   159: aload_1
    //   160: getfield 96	com/tencent/ims/AlertReport$ButtonAction:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   163: iconst_1
    //   164: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   167: aload_1
    //   168: getfield 105	com/tencent/ims/AlertReport$ButtonAction:uint32_button_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: aload_0
    //   172: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	I
    //   175: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   178: aload_1
    //   179: getfield 109	com/tencent/ims/AlertReport$ButtonAction:str_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   182: invokestatic 113	com/tencent/qqprotect/common/BaseQPMiscUtils:a	()Ljava/lang/String;
    //   185: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   188: aload_1
    //   189: getfield 121	com/tencent/ims/AlertReport$ButtonAction:uint32_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   192: invokestatic 126	com/tencent/common/config/AppSetting:d	()I
    //   195: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   198: aload_0
    //   199: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:d	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   202: invokevirtual 43	com/tencent/mobileqq/activity/NotificationActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   205: aload_1
    //   206: invokevirtual 130	com/tencent/ims/AlertReport$ButtonAction:toByteArray	()[B
    //   209: ldc 132
    //   211: invokestatic 137	com/tencent/biz/ProtoUtils:a	(Lmqq/app/AppRuntime;[BLjava/lang/String;)V
    //   214: aconst_null
    //   215: ldc 139
    //   217: ldc 141
    //   219: ldc 143
    //   221: ldc 145
    //   223: ldc 145
    //   225: aload_0
    //   226: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	I
    //   229: iconst_0
    //   230: aload_0
    //   231: getfield 23	com/tencent/mobileqq/activity/NotificationActivity$22:c	Ljava/lang/String;
    //   234: ldc 143
    //   236: ldc 143
    //   238: ldc 143
    //   240: invokestatic 150	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto +116 -> 359
    //   246: astore_1
    //   247: goto +108 -> 355
    //   250: astore_1
    //   251: goto +116 -> 367
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   259: new 91	com/tencent/ims/AlertReport$ButtonAction
    //   262: dup
    //   263: invokespecial 92	com/tencent/ims/AlertReport$ButtonAction:<init>	()V
    //   266: astore_1
    //   267: aload_1
    //   268: getfield 96	com/tencent/ims/AlertReport$ButtonAction:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   271: iconst_1
    //   272: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   275: aload_1
    //   276: getfield 105	com/tencent/ims/AlertReport$ButtonAction:uint32_button_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   279: aload_0
    //   280: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	I
    //   283: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   286: aload_1
    //   287: getfield 109	com/tencent/ims/AlertReport$ButtonAction:str_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   290: invokestatic 113	com/tencent/qqprotect/common/BaseQPMiscUtils:a	()Ljava/lang/String;
    //   293: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   296: aload_1
    //   297: getfield 121	com/tencent/ims/AlertReport$ButtonAction:uint32_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   300: invokestatic 126	com/tencent/common/config/AppSetting:d	()I
    //   303: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   306: aload_0
    //   307: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:d	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   310: invokevirtual 43	com/tencent/mobileqq/activity/NotificationActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   313: aload_1
    //   314: invokevirtual 130	com/tencent/ims/AlertReport$ButtonAction:toByteArray	()[B
    //   317: ldc 132
    //   319: invokestatic 137	com/tencent/biz/ProtoUtils:a	(Lmqq/app/AppRuntime;[BLjava/lang/String;)V
    //   322: aconst_null
    //   323: ldc 139
    //   325: ldc 141
    //   327: ldc 143
    //   329: ldc 145
    //   331: ldc 145
    //   333: aload_0
    //   334: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	I
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 23	com/tencent/mobileqq/activity/NotificationActivity$22:c	Ljava/lang/String;
    //   342: ldc 143
    //   344: ldc 143
    //   346: ldc 143
    //   348: invokestatic 150	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto +8 -> 359
    //   354: astore_1
    //   355: aload_1
    //   356: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   359: aload_0
    //   360: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:d	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   363: invokevirtual 156	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
    //   366: return
    //   367: new 91	com/tencent/ims/AlertReport$ButtonAction
    //   370: dup
    //   371: invokespecial 92	com/tencent/ims/AlertReport$ButtonAction:<init>	()V
    //   374: astore_3
    //   375: aload_3
    //   376: getfield 96	com/tencent/ims/AlertReport$ButtonAction:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   379: iconst_1
    //   380: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   383: aload_3
    //   384: getfield 105	com/tencent/ims/AlertReport$ButtonAction:uint32_button_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   387: aload_0
    //   388: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	I
    //   391: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   394: aload_3
    //   395: getfield 109	com/tencent/ims/AlertReport$ButtonAction:str_package_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   398: invokestatic 113	com/tencent/qqprotect/common/BaseQPMiscUtils:a	()Ljava/lang/String;
    //   401: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   404: aload_3
    //   405: getfield 121	com/tencent/ims/AlertReport$ButtonAction:uint32_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   408: invokestatic 126	com/tencent/common/config/AppSetting:d	()I
    //   411: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   414: aload_0
    //   415: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:d	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   418: invokevirtual 43	com/tencent/mobileqq/activity/NotificationActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   421: aload_3
    //   422: invokevirtual 130	com/tencent/ims/AlertReport$ButtonAction:toByteArray	()[B
    //   425: ldc 132
    //   427: invokestatic 137	com/tencent/biz/ProtoUtils:a	(Lmqq/app/AppRuntime;[BLjava/lang/String;)V
    //   430: aconst_null
    //   431: ldc 139
    //   433: ldc 141
    //   435: ldc 143
    //   437: ldc 145
    //   439: ldc 145
    //   441: aload_0
    //   442: getfield 21	com/tencent/mobileqq/activity/NotificationActivity$22:b	I
    //   445: iconst_0
    //   446: aload_0
    //   447: getfield 23	com/tencent/mobileqq/activity/NotificationActivity$22:c	Ljava/lang/String;
    //   450: ldc 143
    //   452: ldc 143
    //   454: ldc 143
    //   456: invokestatic 150	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   459: goto +8 -> 467
    //   462: astore_3
    //   463: aload_3
    //   464: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   467: aload_0
    //   468: getfield 17	com/tencent/mobileqq/activity/NotificationActivity$22:d	Lcom/tencent/mobileqq/activity/NotificationActivity;
    //   471: invokevirtual 156	com/tencent/mobileqq/activity/NotificationActivity:finish	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.22
 * JD-Core Version:    0.7.0.1
 */