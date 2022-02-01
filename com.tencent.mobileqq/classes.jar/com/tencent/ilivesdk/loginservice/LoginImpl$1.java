package com.tencent.ilivesdk.loginservice;

import com.tencent.falco.base.libapi.login.LoginCallback;

class LoginImpl$1
  implements Runnable
{
  LoginImpl$1(LoginImpl paramLoginImpl, LoginCallback paramLoginCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   4: getfield 31	com/tencent/ilivesdk/loginservice/LoginImpl:isTestEnv	Z
    //   7: ifeq +503 -> 510
    //   10: ldc 33
    //   12: astore_2
    //   13: new 35	java/net/URL
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 38	java/net/URL:<init>	(Ljava/lang/String;)V
    //   21: astore_2
    //   22: new 40	org/json/JSONObject
    //   25: dup
    //   26: new 42	java/lang/String
    //   29: dup
    //   30: aload_0
    //   31: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   34: aload_2
    //   35: aconst_null
    //   36: invokevirtual 46	com/tencent/ilivesdk/loginservice/LoginImpl:request	(Ljava/net/URL;[B)[B
    //   39: invokespecial 49	java/lang/String:<init>	([B)V
    //   42: invokespecial 50	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: ldc 52
    //   49: invokevirtual 56	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   52: istore_1
    //   53: aload_0
    //   54: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   57: getfield 60	com/tencent/ilivesdk/loginservice/LoginImpl:loginServiceAdapter	Lcom/tencent/falco/base/libapi/login/LoginServiceAdapter;
    //   60: invokeinterface 66 1 0
    //   65: ldc 68
    //   67: new 70	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   74: ldc 73
    //   76: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload_1
    //   80: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokeinterface 90 4 0
    //   95: iload_1
    //   96: ifeq +32 -> 128
    //   99: aload_0
    //   100: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   103: aconst_null
    //   104: putfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   107: aload_0
    //   108: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   111: aload_0
    //   112: getfield 16	com/tencent/ilivesdk/loginservice/LoginImpl$1:val$loginCallback	Lcom/tencent/falco/base/libapi/login/LoginCallback;
    //   115: aload_2
    //   116: ldc 52
    //   118: invokevirtual 56	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   121: ldc 96
    //   123: aconst_null
    //   124: invokevirtual 100	com/tencent/ilivesdk/loginservice/LoginImpl:handleCallback	(Lcom/tencent/falco/base/libapi/login/LoginCallback;ILjava/lang/String;Lcom/tencent/falco/base/libapi/login/LoginInfo;)V
    //   127: return
    //   128: aload_2
    //   129: ldc 102
    //   131: invokevirtual 106	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   134: astore_2
    //   135: aload_0
    //   136: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   139: new 108	com/tencent/falco/base/libapi/login/LoginInfo
    //   142: dup
    //   143: invokespecial 109	com/tencent/falco/base/libapi/login/LoginInfo:<init>	()V
    //   146: putfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   149: aload_0
    //   150: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   153: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   156: aload_0
    //   157: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   160: getfield 113	com/tencent/ilivesdk/loginservice/LoginImpl:accountId	Ljava/lang/String;
    //   163: putfield 116	com/tencent/falco/base/libapi/login/LoginInfo:openId	Ljava/lang/String;
    //   166: aload_0
    //   167: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   170: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   173: aload_0
    //   174: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   177: getfield 119	com/tencent/ilivesdk/loginservice/LoginImpl:authKey	Ljava/lang/String;
    //   180: putfield 122	com/tencent/falco/base/libapi/login/LoginInfo:access_token	Ljava/lang/String;
    //   183: aload_0
    //   184: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   187: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   190: aload_0
    //   191: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   194: getfield 113	com/tencent/ilivesdk/loginservice/LoginImpl:accountId	Ljava/lang/String;
    //   197: putfield 125	com/tencent/falco/base/libapi/login/LoginInfo:businessUid	Ljava/lang/String;
    //   200: aload_2
    //   201: ldc 127
    //   203: invokevirtual 131	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore_3
    //   207: aload_3
    //   208: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifne +14 -> 225
    //   214: aload_0
    //   215: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   218: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   221: aload_3
    //   222: putfield 116	com/tencent/falco/base/libapi/login/LoginInfo:openId	Ljava/lang/String;
    //   225: aload_0
    //   226: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   229: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   232: aload_2
    //   233: ldc 139
    //   235: lconst_0
    //   236: invokevirtual 143	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   239: putfield 146	com/tencent/falco/base/libapi/login/LoginInfo:uid	J
    //   242: aload_0
    //   243: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   246: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   249: aload_2
    //   250: ldc 148
    //   252: invokevirtual 151	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 157	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   258: invokevirtual 161	java/lang/Long:longValue	()J
    //   261: putfield 164	com/tencent/falco/base/libapi/login/LoginInfo:tinyid	J
    //   264: aload_0
    //   265: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   268: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   271: aload_2
    //   272: ldc 166
    //   274: ldc 168
    //   276: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   279: invokestatic 177	com/tencent/falco/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   282: putfield 180	com/tencent/falco/base/libapi/login/LoginInfo:a2	[B
    //   285: aload_0
    //   286: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   289: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   292: aload_0
    //   293: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   296: getfield 184	com/tencent/ilivesdk/loginservice/LoginImpl:mLoginType	Lcom/tencent/falco/base/libapi/login/LoginType;
    //   299: putfield 187	com/tencent/falco/base/libapi/login/LoginInfo:loginType	Lcom/tencent/falco/base/libapi/login/LoginType;
    //   302: aload_0
    //   303: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   306: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   309: aload_2
    //   310: ldc 189
    //   312: invokevirtual 151	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   315: putfield 192	com/tencent/falco/base/libapi/login/LoginInfo:configData	Ljava/lang/String;
    //   318: aload_0
    //   319: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   322: invokestatic 197	com/tencent/falco/utils/TimeUtil:getCurrentMillis	()J
    //   325: ldc2_w 198
    //   328: ldiv
    //   329: putfield 202	com/tencent/ilivesdk/loginservice/LoginImpl:lastLoginTime	J
    //   332: aload_2
    //   333: ldc 204
    //   335: invokevirtual 207	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   338: invokestatic 211	com/tencent/falco/utils/TimeUtil:setServerUTCTime	(J)V
    //   341: aload_0
    //   342: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   345: aload_2
    //   346: ldc 213
    //   348: invokevirtual 216	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   351: i2l
    //   352: putfield 219	com/tencent/ilivesdk/loginservice/LoginImpl:a2ExpireTime	J
    //   355: aload_0
    //   356: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   359: getfield 60	com/tencent/ilivesdk/loginservice/LoginImpl:loginServiceAdapter	Lcom/tencent/falco/base/libapi/login/LoginServiceAdapter;
    //   362: invokeinterface 66 1 0
    //   367: ldc 68
    //   369: new 70	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   376: ldc 221
    //   378: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   385: getfield 202	com/tencent/ilivesdk/loginservice/LoginImpl:lastLoginTime	J
    //   388: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   391: ldc 226
    //   393: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   400: getfield 219	com/tencent/ilivesdk/loginservice/LoginImpl:a2ExpireTime	J
    //   403: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: ldc 228
    //   408: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_0
    //   412: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   415: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   418: invokevirtual 229	com/tencent/falco/base/libapi/login/LoginInfo:toString	()Ljava/lang/String;
    //   421: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: iconst_0
    //   428: anewarray 4	java/lang/Object
    //   431: invokeinterface 90 4 0
    //   436: aload_0
    //   437: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   440: aload_0
    //   441: getfield 16	com/tencent/ilivesdk/loginservice/LoginImpl$1:val$loginCallback	Lcom/tencent/falco/base/libapi/login/LoginCallback;
    //   444: iconst_0
    //   445: aconst_null
    //   446: aload_0
    //   447: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   450: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   453: invokevirtual 233	com/tencent/falco/base/libapi/login/LoginInfo:clone	()Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   456: invokevirtual 100	com/tencent/ilivesdk/loginservice/LoginImpl:handleCallback	(Lcom/tencent/falco/base/libapi/login/LoginCallback;ILjava/lang/String;Lcom/tencent/falco/base/libapi/login/LoginInfo;)V
    //   459: return
    //   460: astore_2
    //   461: aload_0
    //   462: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   465: aload_0
    //   466: getfield 16	com/tencent/ilivesdk/loginservice/LoginImpl$1:val$loginCallback	Lcom/tencent/falco/base/libapi/login/LoginCallback;
    //   469: bipush 254
    //   471: aload_2
    //   472: ldc 235
    //   474: invokevirtual 239	com/tencent/ilivesdk/loginservice/LoginImpl:handleLoginError	(Lcom/tencent/falco/base/libapi/login/LoginCallback;ILjava/lang/Exception;Ljava/lang/String;)V
    //   477: return
    //   478: astore_3
    //   479: aload_0
    //   480: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   483: getfield 94	com/tencent/ilivesdk/loginservice/LoginImpl:loginInfo	Lcom/tencent/falco/base/libapi/login/LoginInfo;
    //   486: lconst_0
    //   487: putfield 164	com/tencent/falco/base/libapi/login/LoginInfo:tinyid	J
    //   490: goto -226 -> 264
    //   493: astore_2
    //   494: aload_0
    //   495: getfield 14	com/tencent/ilivesdk/loginservice/LoginImpl$1:this$0	Lcom/tencent/ilivesdk/loginservice/LoginImpl;
    //   498: aload_0
    //   499: getfield 16	com/tencent/ilivesdk/loginservice/LoginImpl$1:val$loginCallback	Lcom/tencent/falco/base/libapi/login/LoginCallback;
    //   502: iconst_m1
    //   503: aload_2
    //   504: ldc 241
    //   506: invokevirtual 239	com/tencent/ilivesdk/loginservice/LoginImpl:handleLoginError	(Lcom/tencent/falco/base/libapi/login/LoginCallback;ILjava/lang/Exception;Ljava/lang/String;)V
    //   509: return
    //   510: ldc 243
    //   512: astore_2
    //   513: goto -500 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	1
    //   52	44	1	i	int
    //   12	334	2	localObject	Object
    //   460	12	2	localSocketTimeoutException	java.net.SocketTimeoutException
    //   493	11	2	localException1	java.lang.Exception
    //   512	1	2	str1	java.lang.String
    //   206	16	3	str2	java.lang.String
    //   478	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	10	460	java/net/SocketTimeoutException
    //   13	95	460	java/net/SocketTimeoutException
    //   99	127	460	java/net/SocketTimeoutException
    //   128	225	460	java/net/SocketTimeoutException
    //   225	242	460	java/net/SocketTimeoutException
    //   242	264	460	java/net/SocketTimeoutException
    //   264	459	460	java/net/SocketTimeoutException
    //   479	490	460	java/net/SocketTimeoutException
    //   242	264	478	java/lang/Exception
    //   0	10	493	java/lang/Exception
    //   13	95	493	java/lang/Exception
    //   99	127	493	java/lang/Exception
    //   128	225	493	java/lang/Exception
    //   225	242	493	java/lang/Exception
    //   264	459	493	java/lang/Exception
    //   479	490	493	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpl.1
 * JD-Core Version:    0.7.0.1
 */