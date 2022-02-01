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
    int i = LoginImpl.3.$SwitchMap$com$tencent$falco$base$libapi$login$LoginType[this.mLoginType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return "";
        }
        return "sp_live_platform_guest";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("1:");
      localStringBuilder.append(this.appId);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0:");
    localStringBuilder.append(this.appId);
    return localStringBuilder.toString();
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
    LogInterface localLogInterface = this.loginServiceAdapter.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doLogin with Exception : ");
    localStringBuilder.append(paramString);
    localLogInterface.e("LoginImpl", localStringBuilder.toString(), new Object[0]);
    handleCallback(paramLoginCallback, paramInt, paramString, null);
    paramException.printStackTrace();
  }
  
  public void refreshLogin(LoginCallback paramLoginCallback)
  {
    if (this.lastLoginTime != 0L)
    {
      long l1 = this.a2ExpireTime;
      if (l1 != 0L)
      {
        if (l1 <= 7200L) {
          l1 = 7200L;
        }
        long l2 = TimeUtil.getCurrentMillis() / 1000L;
        long l3 = this.lastLoginTime;
        if ((l2 - l3 > 3600L) && (l1 - (l2 - l3) < 604800L))
        {
          localObject = this.loginServiceAdapter.getLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshLogin-> start refreshLogin, lastLoginTime=");
          localStringBuilder.append(this.lastLoginTime);
          localStringBuilder.append(", a2ExpireTime=");
          localStringBuilder.append(this.a2ExpireTime);
          localStringBuilder.append(", miniRefreshTime=");
          localStringBuilder.append(l1);
          ((LogInterface)localObject).i("LoginImpl", localStringBuilder.toString(), new Object[0]);
          doLogin(paramLoginCallback);
          return;
        }
        paramLoginCallback = this.loginServiceAdapter.getLog();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshLogin-> Don't need to refreshLogin, lastLoginTime=");
        ((StringBuilder)localObject).append(this.lastLoginTime);
        ((StringBuilder)localObject).append(", a2ExpireTime=");
        ((StringBuilder)localObject).append(this.a2ExpireTime);
        ((StringBuilder)localObject).append(", miniRefreshTime=");
        ((StringBuilder)localObject).append(l1);
        paramLoginCallback.i("LoginImpl", ((StringBuilder)localObject).toString(), new Object[0]);
        return;
      }
    }
    paramLoginCallback = this.loginServiceAdapter.getLog();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshLogin-> fail, lastLoginTime=");
    ((StringBuilder)localObject).append(this.lastLoginTime);
    ((StringBuilder)localObject).append(", a2ExpireTime=");
    ((StringBuilder)localObject).append(this.a2ExpireTime);
    paramLoginCallback.e("LoginImpl", ((StringBuilder)localObject).toString(), new Object[0]);
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
    //   9: ifeq +361 -> 370
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
    //   194: if_icmpne +69 -> 263
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
    //   228: if_icmpeq +12 -> 240
    //   231: aload 4
    //   233: iload_3
    //   234: invokevirtual 341	java/io/ByteArrayOutputStream:write	(I)V
    //   237: goto -16 -> 221
    //   240: aload 4
    //   242: invokevirtual 344	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   245: astore 5
    //   247: aload_2
    //   248: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   251: aload 4
    //   253: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   256: aload_1
    //   257: invokevirtual 349	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   260: aload 5
    //   262: areturn
    //   263: new 100	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   270: astore_2
    //   271: aload_2
    //   272: ldc_w 351
    //   275: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_2
    //   280: iload_3
    //   281: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: new 160	java/lang/Exception
    //   288: dup
    //   289: aload_2
    //   290: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 356	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   296: athrow
    //   297: astore_2
    //   298: goto +66 -> 364
    //   301: astore_2
    //   302: new 160	java/lang/Exception
    //   305: dup
    //   306: ldc_w 358
    //   309: aload_2
    //   310: invokespecial 361	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   313: athrow
    //   314: astore_2
    //   315: new 160	java/lang/Exception
    //   318: dup
    //   319: ldc_w 363
    //   322: aload_2
    //   323: invokespecial 361	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   326: athrow
    //   327: new 210	java/net/SocketTimeoutException
    //   330: dup
    //   331: ldc_w 365
    //   334: invokespecial 366	java/net/SocketTimeoutException:<init>	(Ljava/lang/String;)V
    //   337: athrow
    //   338: astore_2
    //   339: new 160	java/lang/Exception
    //   342: dup
    //   343: ldc_w 368
    //   346: aload_2
    //   347: invokespecial 361	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   350: athrow
    //   351: astore_2
    //   352: new 160	java/lang/Exception
    //   355: dup
    //   356: ldc_w 370
    //   359: aload_2
    //   360: invokespecial 361	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   363: athrow
    //   364: aload_1
    //   365: invokevirtual 349	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   368: aload_2
    //   369: athrow
    //   370: new 372	java/lang/IllegalStateException
    //   373: dup
    //   374: ldc_w 374
    //   377: invokespecial 375	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   380: athrow
    //   381: astore_1
    //   382: new 160	java/lang/Exception
    //   385: dup
    //   386: ldc_w 377
    //   389: aload_1
    //   390: invokespecial 361	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   393: astore_1
    //   394: goto +5 -> 399
    //   397: aload_1
    //   398: athrow
    //   399: goto -2 -> 397
    //   402: astore_2
    //   403: goto -76 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	LoginImpl
    //   0	406	1	paramURL	java.net.URL
    //   0	406	2	paramArrayOfByte	byte[]
    //   189	92	3	i	int
    //   151	101	4	localObject	Object
    //   245	16	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   175	190	297	finally
    //   197	221	297	finally
    //   221	226	297	finally
    //   231	237	297	finally
    //   240	256	297	finally
    //   263	297	297	finally
    //   302	314	297	finally
    //   315	327	297	finally
    //   327	338	297	finally
    //   339	351	297	finally
    //   352	364	297	finally
    //   175	190	301	org/json/JSONException
    //   197	221	301	org/json/JSONException
    //   221	226	301	org/json/JSONException
    //   231	237	301	org/json/JSONException
    //   240	256	301	org/json/JSONException
    //   263	297	301	org/json/JSONException
    //   175	190	314	java/io/IOException
    //   197	221	314	java/io/IOException
    //   221	226	314	java/io/IOException
    //   231	237	314	java/io/IOException
    //   240	256	314	java/io/IOException
    //   263	297	314	java/io/IOException
    //   175	190	338	java/security/KeyManagementException
    //   197	221	338	java/security/KeyManagementException
    //   221	226	338	java/security/KeyManagementException
    //   231	237	338	java/security/KeyManagementException
    //   240	256	338	java/security/KeyManagementException
    //   263	297	338	java/security/KeyManagementException
    //   175	190	351	java/security/NoSuchAlgorithmException
    //   197	221	351	java/security/NoSuchAlgorithmException
    //   221	226	351	java/security/NoSuchAlgorithmException
    //   231	237	351	java/security/NoSuchAlgorithmException
    //   240	256	351	java/security/NoSuchAlgorithmException
    //   263	297	351	java/security/NoSuchAlgorithmException
    //   0	5	381	java/io/IOException
    //   175	190	402	java/net/SocketTimeoutException
    //   197	221	402	java/net/SocketTimeoutException
    //   221	226	402	java/net/SocketTimeoutException
    //   231	237	402	java/net/SocketTimeoutException
    //   240	256	402	java/net/SocketTimeoutException
    //   263	297	402	java/net/SocketTimeoutException
  }
  
  public void setAuthTicket(String paramString1, String paramString2)
  {
    Object localObject = this.loginServiceAdapter.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAuthTicket-> accountId=");
    localStringBuilder.append(paramString1);
    ((LogInterface)localObject).i("LoginImpl", localStringBuilder.toString(), new Object[0]);
    if (!TextUtils.equals(this.accountId, paramString1))
    {
      localObject = this.loginServiceAdapter.getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAuthTicket-> Id has changed, oldId=");
      localStringBuilder.append(this.accountId);
      localStringBuilder.append(", newId=");
      localStringBuilder.append(paramString1);
      ((LogInterface)localObject).e("LoginImpl", localStringBuilder.toString(), new Object[0]);
    }
    this.accountId = paramString1;
    this.authKey = paramString2;
    localObject = this.loginInfo;
    if (localObject != null)
    {
      ((LoginInfo)localObject).openId = paramString1;
      ((LoginInfo)localObject).access_token = paramString2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpl
 * JD-Core Version:    0.7.0.1
 */