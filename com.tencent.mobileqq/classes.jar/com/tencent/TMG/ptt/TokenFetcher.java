package com.tencent.TMG.ptt;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenFetcher
{
  static final String CMD_DOWNLOAD_TOKEN = "get_voice_download_token";
  static final String CMD_UPLOAD_TOKEN = "get_voice_upload_url";
  static final String CMD_VOICE2TEXT_TOKEN = "convert_voice_to_text";
  static final String PARAMS = "sdkappid=%s&accounttype=%s&accesstoken=%s&apn=1&identifier=%s&appidat3rd=%s&contenttype=json";
  public static final String TAG = "TokenFetcher";
  static final String URL_HOST = "https://yun.tim.qq.com/v4/group_open_http_svc/";
  private static TokenFetcher s_instance = null;
  private AppInfo mAppInfo = null;
  private HttpRequestListener mDownloadTokenListener = new HttpRequestListener()
  {
    public void onCompleted(int paramAnonymousInt, String paramAnonymousString, Object paramAnonymousObject)
    {
      if (!(paramAnonymousObject instanceof TokenFetcher.GetDownloadTokenListener)) {
        return;
      }
      TokenFetcher.GetDownloadTokenListener localGetDownloadTokenListener = (TokenFetcher.GetDownloadTokenListener)paramAnonymousObject;
      paramAnonymousObject = "";
      if ((paramAnonymousInt != 0) || (TextUtils.isEmpty(paramAnonymousString)))
      {
        Log.e("TokenFetcher", String.format("mDownloadTokenListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
        paramAnonymousInt = 12293;
        paramAnonymousString = null;
        if (paramAnonymousString != null) {
          break label254;
        }
      }
      label254:
      String str1;
      for (Object localObject = "";; str1 = paramAnonymousString.token)
      {
        for (;;)
        {
          Log.d("TokenFetcher", String.format("mDownloadTokenListener|errCode=%d, errInfo=%s, token=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject, localObject }));
          localGetDownloadTokenListener.onCompleted(paramAnonymousInt, paramAnonymousObject, paramAnonymousString);
          return;
          try
          {
            localObject = new JSONObject(paramAnonymousString);
            paramAnonymousInt = ((JSONObject)localObject).getInt("ErrorCode");
            if (paramAnonymousInt != 0)
            {
              paramAnonymousObject = ((JSONObject)localObject).getString("ErrorInfo");
              Log.e("TokenFetcher", String.format("mDownloadTokenListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject }));
              if (paramAnonymousInt == 70001) {
                break label263;
              }
              if (paramAnonymousInt != 70347) {
                break label272;
              }
              break label263;
            }
            String str2 = ((JSONObject)localObject).getString("download_token");
            localObject = new TokenFetcher.DownloadInfo(((JSONObject)localObject).getString("voice_url"), str2);
            paramAnonymousString = (String)localObject;
          }
          catch (JSONException localJSONException)
          {
            paramAnonymousInt = 12295;
            paramAnonymousObject = "decode resp json fail.";
            Log.e("TokenFetcher", "mDownloadTokenListener|decode resp json fail. resp=" + paramAnonymousString);
            localJSONException.printStackTrace();
            paramAnonymousString = null;
          }
        }
        break;
      }
      label263:
      label272:
      for (paramAnonymousInt = 12296;; paramAnonymousInt = 12290)
      {
        paramAnonymousString = null;
        break;
      }
    }
  };
  private HttpRequestListener mUploadTokenListener = new HttpRequestListener()
  {
    public void onCompleted(int paramAnonymousInt, String paramAnonymousString, Object paramAnonymousObject)
    {
      if (!(paramAnonymousObject instanceof TokenFetcher.GetUploadTokenListener)) {
        return;
      }
      TokenFetcher.GetUploadTokenListener localGetUploadTokenListener = (TokenFetcher.GetUploadTokenListener)paramAnonymousObject;
      paramAnonymousObject = "";
      Object localObject;
      if ((paramAnonymousInt != 0) || (TextUtils.isEmpty(paramAnonymousString)))
      {
        Log.e("TokenFetcher", String.format("mUploadTokenListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
        paramAnonymousInt = 8196;
        paramAnonymousString = null;
        if (paramAnonymousString != null) {
          break label267;
        }
        localObject = "";
        label64:
        if (paramAnonymousString != null) {
          break label276;
        }
      }
      label267:
      label276:
      for (String str2 = "";; str2 = paramAnonymousString.upload_url)
      {
        for (;;)
        {
          Log.d("TokenFetcher", String.format("mUploadTokenListener|errCode=%d, errInfo=%s, token=%s, url=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject, localObject, str2 }));
          localGetUploadTokenListener.onCompleted(paramAnonymousInt, paramAnonymousObject, paramAnonymousString);
          return;
          try
          {
            localObject = new JSONObject(paramAnonymousString);
            paramAnonymousInt = ((JSONObject)localObject).getInt("ErrorCode");
            if (paramAnonymousInt != 0)
            {
              paramAnonymousObject = ((JSONObject)localObject).getString("ErrorInfo");
              Log.e("TokenFetcher", String.format("mUploadTokenListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject }));
              if (paramAnonymousInt == 70001) {
                break label285;
              }
              if (paramAnonymousInt != 70347) {
                break label294;
              }
              break label285;
            }
            str2 = ((JSONObject)localObject).getString("upload_token");
            localObject = new TokenFetcher.UploadInfo(((JSONObject)localObject).getString("upload_url"), str2);
            paramAnonymousString = (String)localObject;
          }
          catch (JSONException localJSONException)
          {
            paramAnonymousInt = 8198;
            paramAnonymousObject = "decode resp json fail.";
            Log.e("TokenFetcher", "mUploadTokenListener|decode resp json fail. resp=" + paramAnonymousString);
            localJSONException.printStackTrace();
            paramAnonymousString = null;
          }
        }
        break;
        String str1 = paramAnonymousString.token;
        break label64;
      }
      label285:
      label294:
      for (paramAnonymousInt = 8199;; paramAnonymousInt = 8194)
      {
        paramAnonymousString = null;
        break;
      }
    }
  };
  private HttpRequestListener mVoiceToTextListener = new HttpRequestListener()
  {
    public void onCompleted(int paramAnonymousInt, String paramAnonymousString, Object paramAnonymousObject)
    {
      if (!(paramAnonymousObject instanceof TokenFetcher.Voice2TextListener)) {
        return;
      }
      TokenFetcher.Voice2TextListener localVoice2TextListener = (TokenFetcher.Voice2TextListener)paramAnonymousObject;
      paramAnonymousObject = "";
      if ((paramAnonymousInt != 0) || (TextUtils.isEmpty(paramAnonymousString)))
      {
        Log.e("TokenFetcher", String.format("mVoiceToTextListener|http error code=%d", new Object[] { Integer.valueOf(0) }));
        paramAnonymousInt = 32770;
        paramAnonymousString = null;
        if (paramAnonymousString != null) {
          break label248;
        }
      }
      label248:
      String str;
      for (Object localObject = "";; str = paramAnonymousString.text)
      {
        for (;;)
        {
          Log.d("TokenFetcher", String.format("mVoiceToTextListener|errCode=%d, errInfo=%s, text=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject, localObject }));
          localVoice2TextListener.onCompleted(paramAnonymousInt, paramAnonymousObject, paramAnonymousString);
          return;
          try
          {
            localObject = new JSONObject(paramAnonymousString);
            paramAnonymousInt = ((JSONObject)localObject).getInt("ErrorCode");
            if (paramAnonymousInt != 0)
            {
              paramAnonymousObject = ((JSONObject)localObject).getString("ErrorInfo");
              Log.e("TokenFetcher", String.format("mVoiceToTextListener|errCode=%d, errInfo=%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject }));
              if (paramAnonymousInt == 70001) {
                break label257;
              }
              if (paramAnonymousInt != 70347) {
                break label265;
              }
              break label257;
            }
            localObject = new TokenFetcher.Voice2TextInfo(((JSONObject)localObject).getString("voice_url"), ((JSONObject)localObject).getString("text"));
            paramAnonymousString = (String)localObject;
          }
          catch (JSONException localJSONException)
          {
            paramAnonymousInt = 32772;
            paramAnonymousObject = "decode resp json fail.";
            Log.e("TokenFetcher", "mVoiceToTextListener|decode resp json fail. resp=" + paramAnonymousString);
            localJSONException.printStackTrace();
            paramAnonymousString = null;
          }
        }
        break;
      }
      label257:
      label265:
      for (paramAnonymousInt = 32773;; paramAnonymousInt = 32769)
      {
        paramAnonymousString = null;
        break;
      }
    }
  };
  
  private TokenFetcher()
  {
    this.mAppInfo.sdk_appid = "1400029763";
    this.mAppInfo.appidat3rd = "1400029763";
    this.mAppInfo.accounttype = "12346";
    this.mAppInfo.accesstoken = "eJx10EFPgzAcBfA7n6LhOqN-KK1g4sFMjXMjMtnmbgRogboBHXRjzvjdt*ESe-Fd3y95yfs2EELmbBJex2labysVqS-JTXSHTMvGDjWv-oCUgkWxinDDfoEDALZ3S7Gm*F6KhkdxpnjTK5eemSYE45USmbj0mDjE9TxwNdKyVdTP-b-Tirwv-af5cDR99Luks4L5O*X7RN7gtyALV7Gv4HVd1JvPF7b2k4J4dEOSfJQPgcnBtm2DWVmMu4AtF*HDgbkDIOl0WVF3whal9fwxPuzye21SifLyDAHAlGDP0dodb1pRVz2wwSKn**Ac0-gxjgLrX78_";
    this.mAppInfo.identifier = "354589908";
  }
  
  public static TokenFetcher getInstance()
  {
    if (s_instance == null) {}
    try
    {
      if (s_instance == null) {
        s_instance = new TokenFetcher();
      }
      return s_instance;
    }
    finally {}
  }
  
  private String getUrl(String paramString)
  {
    if (this.mAppInfo == null) {
      return null;
    }
    String str = String.format("sdkappid=%s&accounttype=%s&accesstoken=%s&apn=1&identifier=%s&appidat3rd=%s&contenttype=json", new Object[] { this.mAppInfo.sdk_appid, this.mAppInfo.accounttype, this.mAppInfo.accesstoken, this.mAppInfo.identifier, this.mAppInfo.appidat3rd });
    return "https://yun.tim.qq.com/v4/group_open_http_svc/" + paramString + "?" + str;
  }
  
  public AppInfo getAppInfo()
  {
    return this.mAppInfo;
  }
  
  public void getDownloadToken(String paramString, GetDownloadTokenListener paramGetDownloadTokenListener)
  {
    if ((this.mAppInfo == null) || (TextUtils.isEmpty(this.mAppInfo.accesstoken)))
    {
      if (paramGetDownloadTokenListener != null) {
        paramGetDownloadTokenListener.onCompleted(12297, "getDownloadToken|appinfo is invalid.", null);
      }
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("voice_url", paramString);
      httpRequest(getUrl("get_voice_download_token"), localJSONObject.toString(), this.mDownloadTokenListener, paramGetDownloadTokenListener);
      return;
    }
    catch (JSONException paramString)
    {
      if (paramGetDownloadTokenListener != null) {
        paramGetDownloadTokenListener.onCompleted(1, "params is invalid.", null);
      }
      paramString.printStackTrace();
    }
  }
  
  public void getUploadToken(String paramString, GetUploadTokenListener paramGetUploadTokenListener)
  {
    if ((this.mAppInfo == null) || (TextUtils.isEmpty(this.mAppInfo.accesstoken)))
    {
      if (paramGetUploadTokenListener != null) {
        paramGetUploadTokenListener.onCompleted(8200, "getUploadToken|appinfo is invalid.", null);
      }
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("voice_filename", paramString);
      httpRequest(getUrl("get_voice_upload_url"), localJSONObject.toString(), this.mUploadTokenListener, paramGetUploadTokenListener);
      return;
    }
    catch (JSONException paramString)
    {
      if (paramGetUploadTokenListener != null) {
        paramGetUploadTokenListener.onCompleted(1, "params is invalid.", null);
      }
      paramString.printStackTrace();
    }
  }
  
  public void httpRequest(final String paramString1, final String paramString2, final HttpRequestListener paramHttpRequestListener, final Object paramObject)
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore 8
        //   6: aconst_null
        //   7: astore 7
        //   9: iconst_0
        //   10: istore_2
        //   11: ldc 43
        //   13: astore 6
        //   15: new 45	java/net/URL
        //   18: dup
        //   19: aload_0
        //   20: getfield 26	com/tencent/TMG/ptt/TokenFetcher$4:val$strUrl	Ljava/lang/String;
        //   23: invokespecial 48	java/net/URL:<init>	(Ljava/lang/String;)V
        //   26: invokevirtual 52	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   29: checkcast 54	java/net/HttpURLConnection
        //   32: astore_3
        //   33: aload_3
        //   34: sipush 5000
        //   37: invokevirtual 58	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   40: aload_3
        //   41: sipush 30000
        //   44: invokevirtual 61	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   47: aload_3
        //   48: iconst_1
        //   49: invokevirtual 65	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   52: aload_3
        //   53: iconst_1
        //   54: invokevirtual 68	java/net/HttpURLConnection:setDoInput	(Z)V
        //   57: aload_3
        //   58: iconst_0
        //   59: invokevirtual 71	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   62: aload_3
        //   63: ldc 73
        //   65: invokevirtual 76	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   68: aload_3
        //   69: ldc 78
        //   71: ldc 80
        //   73: invokevirtual 84	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   76: new 86	java/io/DataOutputStream
        //   79: dup
        //   80: aload_3
        //   81: invokevirtual 90	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   84: invokespecial 93	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   87: astore 4
        //   89: aload 4
        //   91: aload_0
        //   92: getfield 28	com/tencent/TMG/ptt/TokenFetcher$4:val$reqJson	Ljava/lang/String;
        //   95: invokevirtual 99	java/lang/String:getBytes	()[B
        //   98: invokevirtual 105	java/io/OutputStream:write	([B)V
        //   101: aload 4
        //   103: invokevirtual 108	java/io/OutputStream:flush	()V
        //   106: aload_3
        //   107: invokevirtual 112	java/net/HttpURLConnection:getResponseCode	()I
        //   110: istore_1
        //   111: ldc 114
        //   113: new 116	java/lang/StringBuilder
        //   116: dup
        //   117: invokespecial 117	java/lang/StringBuilder:<init>	()V
        //   120: ldc 119
        //   122: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   125: iload_1
        //   126: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   129: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   132: invokestatic 136	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
        //   135: pop
        //   136: iload_1
        //   137: sipush 200
        //   140: if_icmpne +78 -> 218
        //   143: new 138	java/io/BufferedReader
        //   146: dup
        //   147: new 140	java/io/InputStreamReader
        //   150: dup
        //   151: aload_3
        //   152: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   155: invokespecial 147	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   158: invokespecial 150	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   161: astore 5
        //   163: ldc 43
        //   165: astore 4
        //   167: aload 5
        //   169: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   172: astore 8
        //   174: aload 4
        //   176: astore 6
        //   178: aload 5
        //   180: astore 7
        //   182: iload_2
        //   183: istore_1
        //   184: aload 8
        //   186: ifnull +64 -> 250
        //   189: new 116	java/lang/StringBuilder
        //   192: dup
        //   193: invokespecial 117	java/lang/StringBuilder:<init>	()V
        //   196: aload 4
        //   198: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   201: aload 8
        //   203: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   206: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   209: astore 6
        //   211: aload 6
        //   213: astore 4
        //   215: goto -48 -> 167
        //   218: ldc 114
        //   220: new 116	java/lang/StringBuilder
        //   223: dup
        //   224: invokespecial 117	java/lang/StringBuilder:<init>	()V
        //   227: ldc 155
        //   229: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   232: iload_1
        //   233: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   236: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   239: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   242: pop
        //   243: aconst_null
        //   244: astore 7
        //   246: ldc 43
        //   248: astore 6
        //   250: aload_3
        //   251: ifnull +7 -> 258
        //   254: aload_3
        //   255: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
        //   258: aload 7
        //   260: ifnull +8 -> 268
        //   263: aload 7
        //   265: invokevirtual 164	java/io/BufferedReader:close	()V
        //   268: aload_0
        //   269: getfield 30	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
        //   272: ifnull +19 -> 291
        //   275: aload_0
        //   276: getfield 30	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
        //   279: iload_1
        //   280: aload 6
        //   282: aload_0
        //   283: getfield 32	com/tencent/TMG/ptt/TokenFetcher$4:val$param	Ljava/lang/Object;
        //   286: invokeinterface 170 4 0
        //   291: return
        //   292: astore 5
        //   294: aconst_null
        //   295: astore_3
        //   296: ldc 43
        //   298: astore 4
        //   300: aload 7
        //   302: astore 6
        //   304: ldc 114
        //   306: ldc 172
        //   308: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   311: pop
        //   312: aload 5
        //   314: invokevirtual 175	java/io/IOException:printStackTrace	()V
        //   317: aload_3
        //   318: ifnull +7 -> 325
        //   321: aload_3
        //   322: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
        //   325: aload 6
        //   327: ifnull +8 -> 335
        //   330: aload 6
        //   332: invokevirtual 164	java/io/BufferedReader:close	()V
        //   335: aload_0
        //   336: getfield 30	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
        //   339: ifnull -48 -> 291
        //   342: aload_0
        //   343: getfield 30	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
        //   346: iconst_1
        //   347: aload 4
        //   349: aload_0
        //   350: getfield 32	com/tencent/TMG/ptt/TokenFetcher$4:val$param	Ljava/lang/Object;
        //   353: invokeinterface 170 4 0
        //   358: return
        //   359: astore_3
        //   360: aconst_null
        //   361: astore 5
        //   363: ldc 114
        //   365: ldc 177
        //   367: invokestatic 158	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   370: pop
        //   371: aload_3
        //   372: invokevirtual 178	java/lang/Exception:printStackTrace	()V
        //   375: aload 4
        //   377: ifnull +8 -> 385
        //   380: aload 4
        //   382: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
        //   385: aload 5
        //   387: ifnull +8 -> 395
        //   390: aload 5
        //   392: invokevirtual 164	java/io/BufferedReader:close	()V
        //   395: aload_0
        //   396: getfield 30	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
        //   399: ifnull -108 -> 291
        //   402: aload_0
        //   403: getfield 30	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
        //   406: iconst_1
        //   407: aload 6
        //   409: aload_0
        //   410: getfield 32	com/tencent/TMG/ptt/TokenFetcher$4:val$param	Ljava/lang/Object;
        //   413: invokeinterface 170 4 0
        //   418: return
        //   419: astore_3
        //   420: aconst_null
        //   421: astore 5
        //   423: iconst_0
        //   424: istore_1
        //   425: aload 8
        //   427: astore 4
        //   429: aload 4
        //   431: ifnull +8 -> 439
        //   434: aload 4
        //   436: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
        //   439: aload 5
        //   441: ifnull +8 -> 449
        //   444: aload 5
        //   446: invokevirtual 164	java/io/BufferedReader:close	()V
        //   449: aload_0
        //   450: getfield 30	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
        //   453: ifnull +19 -> 472
        //   456: aload_0
        //   457: getfield 30	com/tencent/TMG/ptt/TokenFetcher$4:val$listener	Lcom/tencent/TMG/ptt/TokenFetcher$HttpRequestListener;
        //   460: iload_1
        //   461: aload 6
        //   463: aload_0
        //   464: getfield 32	com/tencent/TMG/ptt/TokenFetcher$4:val$param	Ljava/lang/Object;
        //   467: invokeinterface 170 4 0
        //   472: aload_3
        //   473: athrow
        //   474: astore_3
        //   475: goto -207 -> 268
        //   478: astore_3
        //   479: goto -144 -> 335
        //   482: astore_3
        //   483: goto -88 -> 395
        //   486: astore 4
        //   488: goto -39 -> 449
        //   491: astore 7
        //   493: aconst_null
        //   494: astore 5
        //   496: aload_3
        //   497: astore 4
        //   499: aload 7
        //   501: astore_3
        //   502: iconst_0
        //   503: istore_1
        //   504: goto -75 -> 429
        //   507: astore 7
        //   509: aload 4
        //   511: astore 6
        //   513: aload_3
        //   514: astore 4
        //   516: aload 7
        //   518: astore_3
        //   519: iconst_0
        //   520: istore_1
        //   521: goto -92 -> 429
        //   524: astore 8
        //   526: aload 4
        //   528: astore 7
        //   530: aload 6
        //   532: astore 5
        //   534: aload_3
        //   535: astore 4
        //   537: iconst_1
        //   538: istore_1
        //   539: aload 8
        //   541: astore_3
        //   542: aload 7
        //   544: astore 6
        //   546: goto -117 -> 429
        //   549: astore_3
        //   550: iconst_1
        //   551: istore_1
        //   552: goto -123 -> 429
        //   555: astore 7
        //   557: aconst_null
        //   558: astore 5
        //   560: aload_3
        //   561: astore 4
        //   563: aload 7
        //   565: astore_3
        //   566: goto -203 -> 363
        //   569: astore 7
        //   571: aload 4
        //   573: astore 6
        //   575: aload_3
        //   576: astore 4
        //   578: aload 7
        //   580: astore_3
        //   581: goto -218 -> 363
        //   584: astore 5
        //   586: ldc 43
        //   588: astore 4
        //   590: aload 7
        //   592: astore 6
        //   594: goto -290 -> 304
        //   597: astore 6
        //   599: aload 5
        //   601: astore 7
        //   603: aload 6
        //   605: astore 5
        //   607: aload 7
        //   609: astore 6
        //   611: goto -307 -> 304
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	614	0	this	4
        //   110	442	1	i	int
        //   10	173	2	j	int
        //   32	290	3	localHttpURLConnection	java.net.HttpURLConnection
        //   359	13	3	localException1	java.lang.Exception
        //   419	54	3	localObject1	Object
        //   474	1	3	localIOException1	java.io.IOException
        //   478	1	3	localIOException2	java.io.IOException
        //   482	15	3	localIOException3	java.io.IOException
        //   501	41	3	localObject2	Object
        //   549	12	3	localObject3	Object
        //   565	16	3	localException2	java.lang.Exception
        //   1	434	4	localObject4	Object
        //   486	1	4	localIOException4	java.io.IOException
        //   497	92	4	localObject5	Object
        //   161	18	5	localBufferedReader	java.io.BufferedReader
        //   292	21	5	localIOException5	java.io.IOException
        //   361	198	5	localObject6	Object
        //   584	16	5	localIOException6	java.io.IOException
        //   605	1	5	localIOException7	java.io.IOException
        //   13	580	6	localObject7	Object
        //   597	7	6	localIOException8	java.io.IOException
        //   609	1	6	localObject8	Object
        //   7	294	7	localObject9	Object
        //   491	9	7	localObject10	Object
        //   507	10	7	localObject11	Object
        //   528	15	7	localObject12	Object
        //   555	9	7	localException3	java.lang.Exception
        //   569	22	7	localException4	java.lang.Exception
        //   601	7	7	localObject13	Object
        //   4	422	8	str	String
        //   524	16	8	localObject14	Object
        // Exception table:
        //   from	to	target	type
        //   15	33	292	java/io/IOException
        //   15	33	359	java/lang/Exception
        //   15	33	419	finally
        //   263	268	474	java/io/IOException
        //   330	335	478	java/io/IOException
        //   390	395	482	java/io/IOException
        //   444	449	486	java/io/IOException
        //   33	136	491	finally
        //   143	163	491	finally
        //   218	243	491	finally
        //   167	174	507	finally
        //   189	211	507	finally
        //   304	317	524	finally
        //   363	375	549	finally
        //   33	136	555	java/lang/Exception
        //   143	163	555	java/lang/Exception
        //   218	243	555	java/lang/Exception
        //   167	174	569	java/lang/Exception
        //   189	211	569	java/lang/Exception
        //   33	136	584	java/io/IOException
        //   143	163	584	java/io/IOException
        //   218	243	584	java/io/IOException
        //   167	174	597	java/io/IOException
        //   189	211	597	java/io/IOException
      }
    }).start();
  }
  
  public void setAppInfo(AppInfo paramAppInfo)
  {
    this.mAppInfo = paramAppInfo;
  }
  
  public void voice2Text(String paramString, Voice2TextListener paramVoice2TextListener)
  {
    if ((this.mAppInfo == null) || (TextUtils.isEmpty(this.mAppInfo.accesstoken)))
    {
      if (paramVoice2TextListener != null) {
        paramVoice2TextListener.onCompleted(32774, "voice2Text|appinfo is invalid.", null);
      }
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("voice_url", paramString);
      localJSONObject.put("samples_per_sec", 16000);
      localJSONObject.put("compress_type", "silk");
      localJSONObject.put("file_type", "raw");
      httpRequest(getUrl("convert_voice_to_text"), localJSONObject.toString(), this.mVoiceToTextListener, paramVoice2TextListener);
      return;
    }
    catch (JSONException paramString)
    {
      if (paramVoice2TextListener != null) {
        paramVoice2TextListener.onCompleted(32769, "params is invalid.", null);
      }
      paramString.printStackTrace();
    }
  }
  
  public static class AppInfo
  {
    public String accesstoken;
    public String accounttype;
    public String appidat3rd;
    public String identifier;
    public String sdk_appid;
  }
  
  public static class DownloadInfo
  {
    public String file_url;
    public String token;
    
    public DownloadInfo(String paramString1, String paramString2)
    {
      this.file_url = paramString1;
      this.token = paramString2;
    }
  }
  
  public static abstract interface GetDownloadTokenListener
  {
    public abstract void onCompleted(int paramInt, String paramString, TokenFetcher.DownloadInfo paramDownloadInfo);
  }
  
  public static abstract interface GetUploadTokenListener
  {
    public abstract void onCompleted(int paramInt, String paramString, TokenFetcher.UploadInfo paramUploadInfo);
  }
  
  public static abstract interface HttpRequestListener
  {
    public abstract void onCompleted(int paramInt, String paramString, Object paramObject);
  }
  
  public static class UploadInfo
  {
    public String token;
    public String upload_url;
    
    public UploadInfo(String paramString1, String paramString2)
    {
      this.upload_url = paramString1;
      this.token = paramString2;
    }
  }
  
  public static class Voice2TextInfo
  {
    public String file_url;
    public String text;
    
    public Voice2TextInfo(String paramString1, String paramString2)
    {
      this.file_url = paramString1;
      this.text = paramString2;
    }
  }
  
  public static abstract interface Voice2TextListener
  {
    public abstract void onCompleted(int paramInt, String paramString, TokenFetcher.Voice2TextInfo paramVoice2TextInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.ptt.TokenFetcher
 * JD-Core Version:    0.7.0.1
 */