package com.tencent.ilivesdk.loginservice;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceAdapter;
import com.tencent.falco.base.libapi.login.LoginType;
import com.tencent.falco.base.libapi.login.LogoutCallback;
import com.tencent.falco.utils.TimeUtil;

public class LoginImpl
{
  protected static final int MINI_A2_REFRESH_TIME = 7200;
  protected static final String TAG = "LoginImpl";
  protected final String URL_ONLINE = "https://ilive.qq.com/cgi-bin/core/platform_login/user_login";
  protected final String URL_TEST = "https://test.ilive.qq.com/cgi-bin/core/platform_login/user_login";
  protected long a2ExpireTime;
  protected String accountId;
  protected String appId;
  protected String authAppId;
  protected String authKey;
  protected String clientType;
  protected String customExtData;
  protected String deviceId;
  protected boolean isTestEnv;
  protected long lastLoginTime;
  protected LoginInfo loginInfo;
  protected LoginServiceAdapter loginServiceAdapter;
  protected LoginType mLoginType;
  protected String versionCode;
  
  public LoginImpl(LoginServiceAdapter paramLoginServiceAdapter)
  {
    this.loginServiceAdapter = paramLoginServiceAdapter;
  }
  
  public void doLogin(LoginCallback paramLoginCallback)
  {
    new Thread(new LoginImpl.1(this, paramLoginCallback)).start();
  }
  
  public void doLogout(LogoutCallback paramLogoutCallback)
  {
    paramLogoutCallback.onSucceed();
  }
  
  protected String getExtData()
  {
    if (!TextUtils.isEmpty(this.customExtData)) {
      return this.customExtData;
    }
    switch (LoginImpl.3.$SwitchMap$com$tencent$falco$base$libapi$login$LoginType[this.mLoginType.ordinal()])
    {
    default: 
      return "";
    case 1: 
      return "0:" + this.appId;
    case 2: 
      return "1:" + this.appId;
    }
    return "sp_live_platform_guest";
  }
  
  public LoginInfo getLoginInfo()
  {
    return this.loginInfo;
  }
  
  protected void handleCallback(LoginCallback paramLoginCallback, int paramInt, String paramString, LoginInfo paramLoginInfo)
  {
    new Handler(Looper.getMainLooper()).post(new LoginImpl.2(this, paramLoginInfo, paramLoginCallback, paramInt, paramString));
  }
  
  public void handleLoginError(LoginCallback paramLoginCallback, int paramInt, Exception paramException, String paramString)
  {
    this.loginServiceAdapter.getLog().e("LoginImpl", "doLogin with Exception : " + paramString, new Object[0]);
    handleCallback(paramLoginCallback, paramInt, paramString, null);
    paramException.printStackTrace();
  }
  
  public void refreshLogin(LoginCallback paramLoginCallback)
  {
    long l1 = 7200L;
    if ((this.lastLoginTime == 0L) || (this.a2ExpireTime == 0L))
    {
      this.loginServiceAdapter.getLog().e("LoginImpl", "refreshLogin-> fail, lastLoginTime=" + this.lastLoginTime + ", a2ExpireTime=" + this.a2ExpireTime, new Object[0]);
      return;
    }
    if (this.a2ExpireTime > 7200L) {
      l1 = this.a2ExpireTime;
    }
    long l2 = TimeUtil.getCurrentMillis() / 1000L;
    if ((l2 - this.lastLoginTime > 3600L) && (l1 - (l2 - this.lastLoginTime) < 604800L))
    {
      this.loginServiceAdapter.getLog().i("LoginImpl", "refreshLogin-> start refreshLogin, lastLoginTime=" + this.lastLoginTime + ", a2ExpireTime=" + this.a2ExpireTime + ", miniRefreshTime=" + l1, new Object[0]);
      doLogin(paramLoginCallback);
      return;
    }
    this.loginServiceAdapter.getLog().i("LoginImpl", "refreshLogin-> Don't need to refreshLogin, lastLoginTime=" + this.lastLoginTime + ", a2ExpireTime=" + this.a2ExpireTime + ", miniRefreshTime=" + l1, new Object[0]);
  }
  
  /* Error */
  protected byte[] request(java.net.URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 218	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   4: astore_1
    //   5: aload_1
    //   6: instanceof 220
    //   9: ifeq +366 -> 375
    //   12: aload_1
    //   13: checkcast 220	javax/net/ssl/HttpsURLConnection
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 222
    //   20: invokevirtual 226	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: ldc 228
    //   26: ldc 230
    //   28: invokevirtual 234	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_1
    //   32: sipush 30000
    //   35: invokevirtual 238	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   38: aload_1
    //   39: sipush 30000
    //   42: invokevirtual 241	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   45: new 243	org/json/JSONObject
    //   48: dup
    //   49: invokespecial 244	org/json/JSONObject:<init>	()V
    //   52: astore_2
    //   53: aload_2
    //   54: ldc 246
    //   56: aload_0
    //   57: getfield 248	com/tencent/ilivesdk/loginservice/LoginImpl:accountId	Ljava/lang/String;
    //   60: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   63: pop
    //   64: aload_2
    //   65: ldc 254
    //   67: aload_0
    //   68: getfield 256	com/tencent/ilivesdk/loginservice/LoginImpl:clientType	Ljava/lang/String;
    //   71: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload_2
    //   76: ldc_w 258
    //   79: aload_0
    //   80: getfield 260	com/tencent/ilivesdk/loginservice/LoginImpl:deviceId	Ljava/lang/String;
    //   83: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload_2
    //   88: ldc_w 262
    //   91: aload_0
    //   92: getfield 264	com/tencent/ilivesdk/loginservice/LoginImpl:authAppId	Ljava/lang/String;
    //   95: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: aload_2
    //   100: ldc_w 266
    //   103: aload_0
    //   104: getfield 268	com/tencent/ilivesdk/loginservice/LoginImpl:authKey	Ljava/lang/String;
    //   107: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload_2
    //   112: ldc_w 270
    //   115: aload_0
    //   116: getfield 272	com/tencent/ilivesdk/loginservice/LoginImpl:versionCode	Ljava/lang/String;
    //   119: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload_2
    //   124: ldc_w 274
    //   127: aload_0
    //   128: invokevirtual 276	com/tencent/ilivesdk/loginservice/LoginImpl:getExtData	()Ljava/lang/String;
    //   131: invokevirtual 252	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   134: pop
    //   135: aload_1
    //   136: iconst_1
    //   137: invokevirtual 280	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   140: new 282	java/io/DataOutputStream
    //   143: dup
    //   144: aload_1
    //   145: invokevirtual 286	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   148: invokespecial 289	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   151: astore 4
    //   153: aload 4
    //   155: aload_2
    //   156: invokevirtual 290	org/json/JSONObject:toString	()Ljava/lang/String;
    //   159: invokevirtual 296	java/lang/String:getBytes	()[B
    //   162: invokevirtual 300	java/io/DataOutputStream:write	([B)V
    //   165: aload 4
    //   167: invokevirtual 303	java/io/DataOutputStream:flush	()V
    //   170: aload 4
    //   172: invokevirtual 306	java/io/DataOutputStream:close	()V
    //   175: aload_1
    //   176: invokestatic 312	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   179: invokevirtual 316	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   182: invokevirtual 320	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   185: aload_1
    //   186: invokevirtual 323	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   189: istore_3
    //   190: iload_3
    //   191: sipush 200
    //   194: if_icmpne +102 -> 296
    //   197: new 325	java/io/BufferedInputStream
    //   200: dup
    //   201: aload_1
    //   202: invokevirtual 329	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   205: invokespecial 332	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   208: astore_2
    //   209: new 334	java/io/ByteArrayOutputStream
    //   212: dup
    //   213: sipush 1024
    //   216: invokespecial 336	java/io/ByteArrayOutputStream:<init>	(I)V
    //   219: astore 4
    //   221: aload_2
    //   222: invokevirtual 339	java/io/BufferedInputStream:read	()I
    //   225: istore_3
    //   226: iload_3
    //   227: iconst_m1
    //   228: if_icmpeq +45 -> 273
    //   231: aload 4
    //   233: iload_3
    //   234: invokevirtual 341	java/io/ByteArrayOutputStream:write	(I)V
    //   237: goto -16 -> 221
    //   240: astore_2
    //   241: new 160	java/lang/Exception
    //   244: dup
    //   245: ldc_w 343
    //   248: aload_2
    //   249: invokespecial 346	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: athrow
    //   253: astore_2
    //   254: aload_1
    //   255: invokevirtual 349	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   258: aload_2
    //   259: athrow
    //   260: astore_1
    //   261: new 160	java/lang/Exception
    //   264: dup
    //   265: ldc_w 351
    //   268: aload_1
    //   269: invokespecial 346	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: athrow
    //   273: aload 4
    //   275: invokevirtual 354	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   278: astore 5
    //   280: aload_2
    //   281: invokevirtual 355	java/io/BufferedInputStream:close	()V
    //   284: aload 4
    //   286: invokevirtual 356	java/io/ByteArrayOutputStream:close	()V
    //   289: aload_1
    //   290: invokevirtual 349	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   293: aload 5
    //   295: areturn
    //   296: new 160	java/lang/Exception
    //   299: dup
    //   300: new 98	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 358
    //   310: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload_3
    //   314: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokespecial 363	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   323: athrow
    //   324: astore_2
    //   325: new 160	java/lang/Exception
    //   328: dup
    //   329: ldc_w 365
    //   332: aload_2
    //   333: invokespecial 346	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: athrow
    //   337: astore_2
    //   338: new 210	java/net/SocketTimeoutException
    //   341: dup
    //   342: ldc_w 367
    //   345: invokespecial 368	java/net/SocketTimeoutException:<init>	(Ljava/lang/String;)V
    //   348: athrow
    //   349: astore_2
    //   350: new 160	java/lang/Exception
    //   353: dup
    //   354: ldc_w 370
    //   357: aload_2
    //   358: invokespecial 346	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   361: athrow
    //   362: astore_2
    //   363: new 160	java/lang/Exception
    //   366: dup
    //   367: ldc_w 372
    //   370: aload_2
    //   371: invokespecial 346	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   374: athrow
    //   375: new 374	java/lang/IllegalStateException
    //   378: dup
    //   379: ldc_w 376
    //   382: invokespecial 377	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   385: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	LoginImpl
    //   0	386	1	paramURL	java.net.URL
    //   0	386	2	paramArrayOfByte	byte[]
    //   189	125	3	i	int
    //   151	134	4	localObject	Object
    //   278	16	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   175	190	240	java/security/NoSuchAlgorithmException
    //   197	221	240	java/security/NoSuchAlgorithmException
    //   221	226	240	java/security/NoSuchAlgorithmException
    //   231	237	240	java/security/NoSuchAlgorithmException
    //   273	289	240	java/security/NoSuchAlgorithmException
    //   296	324	240	java/security/NoSuchAlgorithmException
    //   175	190	253	finally
    //   197	221	253	finally
    //   221	226	253	finally
    //   231	237	253	finally
    //   241	253	253	finally
    //   273	289	253	finally
    //   296	324	253	finally
    //   325	337	253	finally
    //   338	349	253	finally
    //   350	362	253	finally
    //   363	375	253	finally
    //   0	5	260	java/io/IOException
    //   175	190	324	java/security/KeyManagementException
    //   197	221	324	java/security/KeyManagementException
    //   221	226	324	java/security/KeyManagementException
    //   231	237	324	java/security/KeyManagementException
    //   273	289	324	java/security/KeyManagementException
    //   296	324	324	java/security/KeyManagementException
    //   175	190	337	java/net/SocketTimeoutException
    //   197	221	337	java/net/SocketTimeoutException
    //   221	226	337	java/net/SocketTimeoutException
    //   231	237	337	java/net/SocketTimeoutException
    //   273	289	337	java/net/SocketTimeoutException
    //   296	324	337	java/net/SocketTimeoutException
    //   175	190	349	java/io/IOException
    //   197	221	349	java/io/IOException
    //   221	226	349	java/io/IOException
    //   231	237	349	java/io/IOException
    //   273	289	349	java/io/IOException
    //   296	324	349	java/io/IOException
    //   175	190	362	org/json/JSONException
    //   197	221	362	org/json/JSONException
    //   221	226	362	org/json/JSONException
    //   231	237	362	org/json/JSONException
    //   273	289	362	org/json/JSONException
    //   296	324	362	org/json/JSONException
  }
  
  public void setAuthTicket(String paramString1, String paramString2)
  {
    this.loginServiceAdapter.getLog().i("LoginImpl", "setAuthTicket-> accountId=" + paramString1, new Object[0]);
    if (!TextUtils.equals(this.accountId, paramString1)) {
      this.loginServiceAdapter.getLog().e("LoginImpl", "setAuthTicket-> Id has changed, oldId=" + this.accountId + ", newId=" + paramString1, new Object[0]);
    }
    this.accountId = paramString1;
    this.authKey = paramString2;
    if (this.loginInfo != null)
    {
      this.loginInfo.openId = paramString1;
      this.loginInfo.access_token = paramString2;
    }
  }
  
  public void setLoginReqInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LoginType paramLoginType, String paramString7, String paramString8)
  {
    this.accountId = paramString1;
    this.authKey = paramString2;
    this.authAppId = paramString3;
    this.clientType = paramString4;
    this.deviceId = paramString5;
    this.versionCode = paramString6;
    this.mLoginType = paramLoginType;
    this.customExtData = paramString7;
    this.appId = paramString8;
    this.isTestEnv = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpl
 * JD-Core Version:    0.7.0.1
 */