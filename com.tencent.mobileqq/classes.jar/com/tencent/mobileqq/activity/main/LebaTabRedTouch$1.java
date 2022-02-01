package com.tencent.mobileqq.activity.main;

class LebaTabRedTouch$1
  implements Runnable
{
  LebaTabRedTouch$1(LebaTabRedTouch paramLebaTabRedTouch, LebaTabRedTouch.RefreshCallback paramRefreshCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:this$0	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch;
    //   4: getfield 28	com/tencent/mobileqq/activity/main/LebaTabRedTouch:a	Lcom/tencent/mobileqq/activity/SplashActivity;
    //   7: ifnull +192 -> 199
    //   10: aload_0
    //   11: getfield 14	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:this$0	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch;
    //   14: getfield 28	com/tencent/mobileqq/activity/main/LebaTabRedTouch:a	Lcom/tencent/mobileqq/activity/SplashActivity;
    //   17: getfield 34	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: ifnonnull +6 -> 26
    //   23: goto +176 -> 199
    //   26: aload_0
    //   27: getfield 14	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:this$0	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch;
    //   30: getfield 28	com/tencent/mobileqq/activity/main/LebaTabRedTouch:a	Lcom/tencent/mobileqq/activity/SplashActivity;
    //   33: getfield 34	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: getstatic 40	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH_EX	I
    //   39: invokevirtual 46	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   42: checkcast 48	com/tencent/biz/TroopRedpoint/TroopRedTouchManager
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 52	com/tencent/biz/TroopRedpoint/TroopRedTouchManager:q	()Ltencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo;
    //   50: astore_3
    //   51: iconst_m1
    //   52: istore_1
    //   53: aload_3
    //   54: ifnull +11 -> 65
    //   57: aload_3
    //   58: getfield 58	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   61: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   64: istore_1
    //   65: aload_0
    //   66: getfield 14	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:this$0	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch;
    //   69: getfield 28	com/tencent/mobileqq/activity/main/LebaTabRedTouch:a	Lcom/tencent/mobileqq/activity/SplashActivity;
    //   72: getfield 34	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   75: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getNowLiveManager	()Lcom/tencent/biz/now/NowLiveManager;
    //   78: getfield 74	com/tencent/biz/now/NowLiveManager:d	Z
    //   81: ifne +85 -> 166
    //   84: iload_1
    //   85: bipush 11
    //   87: if_icmpne +79 -> 166
    //   90: new 76	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo
    //   93: dup
    //   94: invokespecial 77	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: getfield 80	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   102: iconst_4
    //   103: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   106: aload_2
    //   107: getfield 88	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   110: aload_3
    //   111: getfield 92	tencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo:str_custom_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   114: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   117: invokevirtual 103	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   120: invokevirtual 108	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   123: aload_2
    //   124: getfield 111	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   127: ldc 113
    //   129: invokevirtual 108	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   132: new 115	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   139: astore_3
    //   140: aload_3
    //   141: ldc 118
    //   143: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_3
    //   148: iload_1
    //   149: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 127
    //   155: iconst_1
    //   156: aload_3
    //   157: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto +14 -> 177
    //   166: aload_0
    //   167: getfield 14	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:this$0	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch;
    //   170: aload_2
    //   171: aconst_null
    //   172: aload_3
    //   173: invokestatic 139	com/tencent/mobileqq/activity/main/LebaTabRedTouch:a	(Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch;Lcom/tencent/biz/TroopRedpoint/TroopRedTouchManager;Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;Ltencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo;)Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;
    //   176: astore_2
    //   177: aload_0
    //   178: getfield 16	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:a	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch$RefreshCallback;
    //   181: aload_2
    //   182: invokeinterface 144 2 0
    //   187: aload_0
    //   188: getfield 16	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:a	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch$RefreshCallback;
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +51 -> 244
    //   196: goto +42 -> 238
    //   199: aload_0
    //   200: getfield 16	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:a	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch$RefreshCallback;
    //   203: astore_2
    //   204: aload_2
    //   205: ifnull +9 -> 214
    //   208: aload_2
    //   209: invokeinterface 146 1 0
    //   214: return
    //   215: astore_2
    //   216: goto +29 -> 245
    //   219: astore_2
    //   220: ldc 148
    //   222: iconst_1
    //   223: ldc 150
    //   225: aload_2
    //   226: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   229: aload_0
    //   230: getfield 16	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:a	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch$RefreshCallback;
    //   233: astore_2
    //   234: aload_2
    //   235: ifnull +9 -> 244
    //   238: aload_2
    //   239: invokeinterface 146 1 0
    //   244: return
    //   245: aload_0
    //   246: getfield 16	com/tencent/mobileqq/activity/main/LebaTabRedTouch$1:a	Lcom/tencent/mobileqq/activity/main/LebaTabRedTouch$RefreshCallback;
    //   249: astore_3
    //   250: aload_3
    //   251: ifnull +9 -> 260
    //   254: aload_3
    //   255: invokeinterface 146 1 0
    //   260: aload_2
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	1
    //   52	97	1	i	int
    //   45	164	2	localObject1	Object
    //   215	1	2	localObject2	Object
    //   219	7	2	localException	java.lang.Exception
    //   233	28	2	localRefreshCallback	LebaTabRedTouch.RefreshCallback
    //   50	205	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	215	finally
    //   26	51	215	finally
    //   57	65	215	finally
    //   65	84	215	finally
    //   90	163	215	finally
    //   166	177	215	finally
    //   177	187	215	finally
    //   220	229	215	finally
    //   0	23	219	java/lang/Exception
    //   26	51	219	java/lang/Exception
    //   57	65	219	java/lang/Exception
    //   65	84	219	java/lang/Exception
    //   90	163	219	java/lang/Exception
    //   166	177	219	java/lang/Exception
    //   177	187	219	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.LebaTabRedTouch.1
 * JD-Core Version:    0.7.0.1
 */