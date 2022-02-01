package com.tencent.mobileqq.activity.aio;

public class AIOConfigManager
{
  public static int a = 0;
  public static AIOConfigData a;
  public static boolean a = false;
  public static boolean b;
  
  /* Error */
  public static void a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 29
    //   11: iconst_2
    //   12: ldc 31
    //   14: invokestatic 35	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual 41	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   21: astore_2
    //   22: invokestatic 47	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   25: astore_0
    //   26: new 49	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_2
    //   36: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc 56
    //   43: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: ldc 58
    //   50: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_2
    //   59: iconst_0
    //   60: istore_1
    //   61: aload_0
    //   62: aload_2
    //   63: iconst_0
    //   64: invokevirtual 65	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   67: astore_0
    //   68: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +11 -> 82
    //   74: ldc 29
    //   76: iconst_2
    //   77: ldc 67
    //   79: invokestatic 35	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: ldc 69
    //   85: iconst_0
    //   86: invokeinterface 75 3 0
    //   91: iconst_1
    //   92: if_icmpne +5 -> 97
    //   95: iconst_1
    //   96: istore_1
    //   97: iload_1
    //   98: putstatic 77	com/tencent/mobileqq/activity/aio/AIOConfigManager:b	Z
    //   101: aload_0
    //   102: ldc 79
    //   104: bipush 10
    //   106: invokeinterface 75 3 0
    //   111: putstatic 81	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_Int	I
    //   114: aload_0
    //   115: ldc 83
    //   117: ldc 85
    //   119: invokeinterface 89 3 0
    //   124: astore_0
    //   125: aload_0
    //   126: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifne +15 -> 144
    //   132: aload_0
    //   133: ldc 97
    //   135: invokestatic 102	com/tencent/mobileqq/jsonconverter/JSONConverter:a	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   138: checkcast 97	com/tencent/mobileqq/activity/aio/AIOConfigData
    //   141: putstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   144: getstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   147: ifnull +35 -> 182
    //   150: getstatic 108	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   153: ldc 110
    //   155: iconst_4
    //   156: invokevirtual 65	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   159: invokeinterface 114 1 0
    //   164: ldc 116
    //   166: getstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   169: getfield 118	com/tencent/mobileqq/activity/aio/AIOConfigData:jdField_a_of_type_Boolean	Z
    //   172: invokeinterface 124 3 0
    //   177: invokeinterface 127 1 0
    //   182: getstatic 128	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_Boolean	Z
    //   185: ifeq +47 -> 232
    //   188: getstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   191: ifnonnull +13 -> 204
    //   194: new 97	com/tencent/mobileqq/activity/aio/AIOConfigData
    //   197: dup
    //   198: invokespecial 129	com/tencent/mobileqq/activity/aio/AIOConfigData:<init>	()V
    //   201: putstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   204: getstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   207: iconst_1
    //   208: putfield 130	com/tencent/mobileqq/activity/aio/AIOConfigData:jdField_a_of_type_Int	I
    //   211: getstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   214: iconst_1
    //   215: putfield 133	com/tencent/mobileqq/activity/aio/AIOConfigData:e	I
    //   218: getstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   221: iconst_1
    //   222: putfield 136	com/tencent/mobileqq/activity/aio/AIOConfigData:d	I
    //   225: getstatic 104	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_ComTencentMobileqqActivityAioAIOConfigData	Lcom/tencent/mobileqq/activity/aio/AIOConfigData;
    //   228: iconst_1
    //   229: putfield 139	com/tencent/mobileqq/activity/aio/AIOConfigData:f	I
    //   232: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +174 -> 409
    //   238: new 49	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   245: astore_2
    //   246: aload_2
    //   247: ldc 141
    //   249: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: new 49	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   260: astore_3
    //   261: aload_3
    //   262: ldc 143
    //   264: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_3
    //   269: getstatic 77	com/tencent/mobileqq/activity/aio/AIOConfigManager:b	Z
    //   272: invokevirtual 146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: aload_3
    //   278: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: new 49	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   292: astore_3
    //   293: aload_3
    //   294: ldc 148
    //   296: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_3
    //   301: getstatic 81	com/tencent/mobileqq/activity/aio/AIOConfigManager:jdField_a_of_type_Int	I
    //   304: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_2
    //   309: aload_3
    //   310: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: new 49	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   324: astore_3
    //   325: aload_3
    //   326: ldc 153
    //   328: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_3
    //   333: getstatic 155	com/tencent/common/app/BaseApplicationImpl:httpMonitorBan	Z
    //   336: invokevirtual 146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_2
    //   341: aload_3
    //   342: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: new 49	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   356: astore_3
    //   357: aload_3
    //   358: ldc 157
    //   360: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_3
    //   365: aload_0
    //   366: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_2
    //   371: aload_3
    //   372: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: ldc 29
    //   381: iconst_2
    //   382: aload_2
    //   383: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 35	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: goto +20 -> 409
    //   392: astore_0
    //   393: goto +20 -> 413
    //   396: astore_0
    //   397: aload_0
    //   398: invokevirtual 160	java/lang/Error:printStackTrace	()V
    //   401: goto +8 -> 409
    //   404: astore_0
    //   405: aload_0
    //   406: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   409: ldc 2
    //   411: monitorexit
    //   412: return
    //   413: ldc 2
    //   415: monitorexit
    //   416: aload_0
    //   417: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   60	38	1	bool	boolean
    //   21	362	2	localObject	Object
    //   33	339	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	17	392	finally
    //   17	59	392	finally
    //   61	82	392	finally
    //   82	95	392	finally
    //   97	144	392	finally
    //   144	182	392	finally
    //   182	204	392	finally
    //   204	232	392	finally
    //   232	389	392	finally
    //   397	401	392	finally
    //   405	409	392	finally
    //   3	17	396	java/lang/Error
    //   17	59	396	java/lang/Error
    //   61	82	396	java/lang/Error
    //   82	95	396	java/lang/Error
    //   97	144	396	java/lang/Error
    //   144	182	396	java/lang/Error
    //   182	204	396	java/lang/Error
    //   204	232	396	java/lang/Error
    //   232	389	396	java/lang/Error
    //   3	17	404	java/lang/Exception
    //   17	59	404	java/lang/Exception
    //   61	82	404	java/lang/Exception
    //   82	95	404	java/lang/Exception
    //   97	144	404	java/lang/Exception
    //   144	182	404	java/lang/Exception
    //   182	204	404	java/lang/Exception
    //   204	232	404	java/lang/Exception
    //   232	389	404	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOConfigManager
 * JD-Core Version:    0.7.0.1
 */