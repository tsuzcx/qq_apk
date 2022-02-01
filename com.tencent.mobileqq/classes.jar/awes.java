import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.6;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awes
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new awev(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new awet(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new awew(this, Looper.getMainLooper());
  private awdx jdField_a_of_type_Awdx = new aweu(this);
  private awdz jdField_a_of_type_Awdz;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  private JsBridgeListener jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener;
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public awes()
  {
    this.mPluginNameSpace = "qqmusic";
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_Int <= 0) && (this.jdField_a_of_type_Awdz != null)) {}
    try
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Awdz.c();
      return this.jdField_a_of_type_Int;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return 103;
    case 0: 
      return 102;
    }
    return 101;
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private SongInfo a()
  {
    SongInfo localSongInfo2 = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null)
    {
      localSongInfo1 = localSongInfo2;
      if (this.jdField_a_of_type_Awdz == null) {}
    }
    try
    {
      localSongInfo1 = this.jdField_a_of_type_Awdz.a();
      return localSongInfo1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localSongInfo2;
  }
  
  private String a()
  {
    try
    {
      if (c()) {
        return awex.a();
      }
      String str = this.jdField_a_of_type_Awdz.a(3, "MusicGeneWebViewPlugin");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private HashMap<String, JSONObject> a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
        if (localJSONObject != null) {
          localHashMap.put(localJSONObject.getString("songId"), localJSONObject);
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  private JSONObject a(SongInfo paramSongInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramSongInfo != null)
    {
      localJSONObject.put("playUrl", paramSongInfo.b);
      localJSONObject.put("songPage", paramSongInfo.f);
      localJSONObject.put("songId", paramSongInfo.jdField_a_of_type_Long);
      localJSONObject.put("songName", paramSongInfo.c);
      localJSONObject.put("singerName", paramSongInfo.h);
      localJSONObject.put("albumName", paramSongInfo.g);
      localJSONObject.put("albumImg", paramSongInfo.e);
    }
    return localJSONObject;
  }
  
  private void a()
  {
    MusicGeneWebViewPlugin.6 local6 = new MusicGeneWebViewPlugin.6(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(local6, 1000L, 1000L);
  }
  
  private void a(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      paramBitmap = bfuc.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      localObject = "data:image\\/jpg;base64," + paramBitmap;
      paramBitmap = new JSONObject();
    }
    try
    {
      paramBitmap.put("code", "0");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("imgUrl", localObject);
      paramBitmap.put("data", localJSONObject);
      callJs(String.format("try{qqmusicBridge.appTrigger('%s',  %s);}catch(e){}", new Object[] { "DO_MACK_IMG_CALLBACK", paramBitmap }));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iload 6
    //   5: istore 5
    //   7: aload_0
    //   8: getfield 295	awes:jdField_b_of_type_Boolean	Z
    //   11: ifeq +286 -> 297
    //   14: aload_0
    //   15: invokespecial 296	awes:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   18: astore 7
    //   20: aload_0
    //   21: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   24: ifnull +456 -> 480
    //   27: aload_0
    //   28: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   31: invokeinterface 299 1 0
    //   36: istore_1
    //   37: aload_0
    //   38: invokespecial 301	awes:a	()I
    //   41: istore_3
    //   42: iload_1
    //   43: istore 4
    //   45: aload 7
    //   47: astore 9
    //   49: ldc_w 269
    //   52: astore 8
    //   54: aload_0
    //   55: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   58: ifnull +409 -> 467
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   66: invokeinterface 302 1 0
    //   71: invokespecial 304	awes:b	(I)I
    //   74: istore_1
    //   75: aload 8
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   83: invokeinterface 307 1 0
    //   88: astore 10
    //   90: aload 10
    //   92: ifnull +369 -> 461
    //   95: aload 8
    //   97: astore 7
    //   99: aload 10
    //   101: ldc_w 309
    //   104: invokevirtual 312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 8
    //   109: aload 8
    //   111: astore 7
    //   113: new 164	org/json/JSONObject
    //   116: dup
    //   117: aload 10
    //   119: ldc_w 273
    //   122: invokevirtual 312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokespecial 313	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   128: astore 10
    //   130: aload 10
    //   132: astore 7
    //   134: aload 7
    //   136: ifnonnull +322 -> 458
    //   139: new 164	org/json/JSONObject
    //   142: dup
    //   143: invokespecial 179	org/json/JSONObject:<init>	()V
    //   146: astore 7
    //   148: iload 6
    //   150: istore 5
    //   152: aload 9
    //   154: ifnull +143 -> 297
    //   157: aload_0
    //   158: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   161: ifnull +324 -> 485
    //   164: aload_0
    //   165: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   168: invokeinterface 307 1 0
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull +175 -> 352
    //   180: aload 10
    //   182: ldc_w 315
    //   185: iconst_0
    //   186: invokevirtual 319	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   189: istore_2
    //   190: aload_0
    //   191: aload 9
    //   193: invokespecial 321	awes:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   196: astore 9
    //   198: aload 9
    //   200: ifnull +167 -> 367
    //   203: aload 9
    //   205: invokevirtual 325	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   208: astore 10
    //   210: aload 10
    //   212: invokeinterface 330 1 0
    //   217: ifeq +150 -> 367
    //   220: aload 10
    //   222: invokeinterface 334 1 0
    //   227: checkcast 281	java/lang/String
    //   230: astore 11
    //   232: aload 7
    //   234: aload 11
    //   236: aload 9
    //   238: aload 11
    //   240: invokevirtual 337	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   243: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: goto -37 -> 210
    //   250: astore 8
    //   252: aload 8
    //   254: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   257: iload 6
    //   259: istore 5
    //   261: aload 7
    //   263: ifnull +34 -> 297
    //   266: aload_0
    //   267: ldc_w 339
    //   270: iconst_2
    //   271: anewarray 277	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: ldc_w 341
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: aload 7
    //   284: invokevirtual 342	org/json/JSONObject:toString	()Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 285	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   291: invokevirtual 288	awes:callJs	(Ljava/lang/String;)V
    //   294: iconst_1
    //   295: istore 5
    //   297: iload 5
    //   299: ireturn
    //   300: astore 8
    //   302: aconst_null
    //   303: astore 7
    //   305: iconst_0
    //   306: istore_1
    //   307: aload 8
    //   309: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   312: iconst_0
    //   313: istore_3
    //   314: aload 7
    //   316: astore 9
    //   318: iload_1
    //   319: istore 4
    //   321: goto -272 -> 49
    //   324: astore 8
    //   326: ldc_w 269
    //   329: astore 7
    //   331: iconst_0
    //   332: istore_1
    //   333: aload 8
    //   335: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   338: aconst_null
    //   339: astore 10
    //   341: aload 7
    //   343: astore 8
    //   345: aload 10
    //   347: astore 7
    //   349: goto -215 -> 134
    //   352: iconst_0
    //   353: istore_2
    //   354: goto -164 -> 190
    //   357: astore 10
    //   359: aload 10
    //   361: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   364: goto +121 -> 485
    //   367: aload 7
    //   369: ldc_w 344
    //   372: iload 4
    //   374: sipush 1000
    //   377: idiv
    //   378: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   381: pop
    //   382: aload 7
    //   384: ldc_w 349
    //   387: iload_3
    //   388: sipush 1000
    //   391: idiv
    //   392: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   395: pop
    //   396: aload 7
    //   398: ldc_w 351
    //   401: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   404: ifne +14 -> 418
    //   407: aload 7
    //   409: ldc_w 351
    //   412: aload 8
    //   414: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload 7
    //   420: ldc_w 357
    //   423: iload_1
    //   424: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   427: pop
    //   428: aload 7
    //   430: ldc_w 359
    //   433: iload_2
    //   434: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   437: pop
    //   438: goto -181 -> 257
    //   441: astore 8
    //   443: goto -110 -> 333
    //   446: astore 8
    //   448: iconst_0
    //   449: istore_1
    //   450: goto -143 -> 307
    //   453: astore 8
    //   455: goto -148 -> 307
    //   458: goto -310 -> 148
    //   461: aconst_null
    //   462: astore 7
    //   464: goto -330 -> 134
    //   467: iconst_0
    //   468: istore_1
    //   469: aconst_null
    //   470: astore 7
    //   472: ldc_w 269
    //   475: astore 8
    //   477: goto -343 -> 134
    //   480: iconst_0
    //   481: istore_1
    //   482: goto -445 -> 37
    //   485: iconst_0
    //   486: istore_2
    //   487: goto -297 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	awes
    //   36	446	1	i	int
    //   189	298	2	j	int
    //   41	351	3	k	int
    //   43	335	4	m	int
    //   5	293	5	bool1	boolean
    //   1	257	6	bool2	boolean
    //   18	453	7	localObject1	Object
    //   52	58	8	str1	String
    //   250	3	8	localException1	Exception
    //   300	8	8	localException2	Exception
    //   324	10	8	localException3	Exception
    //   343	70	8	localObject2	Object
    //   441	1	8	localException4	Exception
    //   446	1	8	localException5	Exception
    //   453	1	8	localException6	Exception
    //   475	1	8	str2	String
    //   47	270	9	localObject3	Object
    //   88	258	10	localObject4	Object
    //   357	3	10	localException7	Exception
    //   230	9	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   190	198	250	java/lang/Exception
    //   203	210	250	java/lang/Exception
    //   210	247	250	java/lang/Exception
    //   359	364	250	java/lang/Exception
    //   367	418	250	java/lang/Exception
    //   418	438	250	java/lang/Exception
    //   14	20	300	java/lang/Exception
    //   61	75	324	java/lang/Exception
    //   157	175	357	java/lang/Exception
    //   180	190	357	java/lang/Exception
    //   79	90	441	java/lang/Exception
    //   99	109	441	java/lang/Exception
    //   113	130	441	java/lang/Exception
    //   20	37	446	java/lang/Exception
    //   37	42	453	java/lang/Exception
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_Awdz;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (localObject == null) {}
    }
    try
    {
      i = ((awdz)localObject).e();
      int j = b(paramInt);
      localObject = new JSONObject();
      try
      {
        Bundle localBundle = this.jdField_a_of_type_Awdz.a();
        if (localBundle == null) {
          break label182;
        }
        paramInt = localBundle.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          paramInt = 0;
          continue;
          localRemoteException.put("code", "0");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      ((JSONObject)localObject).put("state", j);
      ((JSONObject)localObject).put("index", i);
      ((JSONObject)localObject).put("playType", paramInt);
      if (b())
      {
        ((JSONObject)localObject).put("code", "0");
        bool1 = bool2;
        if (localObject != null)
        {
          callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", new Object[] { "CALLPAGE_SONG_STATE_CHANGE", ((JSONObject)localObject).toString() }));
          bool1 = true;
        }
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
        int i = 0;
        continue;
        label182:
        paramInt = 0;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return bool1;
      }
      paramString = Uri.parse(paramString);
      String str = paramString.getScheme();
      if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str)))
      {
        paramString = paramString.getHost();
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString)) {
          return bool1;
        }
        if ((!paramString.contains("y.qq.com")) && (!paramString.contains("music.qq.com")) && (!paramString.contains("imgcache.gtimg.cn")) && (!paramString.contains("article.mp.qq.com")))
        {
          bool1 = bool2;
          if (!paramString.contains("post.mp.qq.com")) {
            return bool1;
          }
        }
      }
      else
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic urlString is not url!");
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic exception: " + paramString);
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  private SongInfo[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (!paramJSONObject.has("list")) {
      return null;
    }
    JSONArray localJSONArray = paramJSONObject.getJSONArray("list");
    SongInfo[] arrayOfSongInfo = new SongInfo[localJSONArray.length()];
    int i = 0;
    if (i < localJSONArray.length())
    {
      JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
      label80:
      SongInfo localSongInfo;
      String str;
      label108:
      long l;
      if (localJSONObject != null)
      {
        if (!localJSONObject.has("songId")) {
          break label321;
        }
        paramJSONObject = localJSONObject.getString("songId");
        localSongInfo = new SongInfo();
        if (!localJSONObject.has("songName")) {
          break label327;
        }
        str = localJSONObject.getString("songName");
        localSongInfo.c = str;
        if (!localJSONObject.has("playUrl")) {
          break label334;
        }
        str = localJSONObject.getString("playUrl");
        label134:
        localSongInfo.b = str;
        if (!localJSONObject.has("albumName")) {
          break label341;
        }
        str = localJSONObject.getString("albumName");
        label160:
        localSongInfo.d = str;
        if (!localJSONObject.has("albumImg")) {
          break label348;
        }
        str = localJSONObject.getString("albumImg");
        label186:
        localSongInfo.e = str;
        if (!localJSONObject.has("songPage")) {
          break label355;
        }
        str = localJSONObject.getString("songPage");
        label212:
        localSongInfo.f = str;
        if (!TextUtils.isEmpty(paramJSONObject)) {
          break label362;
        }
        l = 0L;
        label228:
        localSongInfo.jdField_a_of_type_Long = l;
        if (!localJSONObject.has("albumName")) {
          break label370;
        }
        paramJSONObject = localJSONObject.getString("albumName");
        label252:
        localSongInfo.g = paramJSONObject;
        if (!localJSONObject.has("singerName")) {
          break label376;
        }
        paramJSONObject = localJSONObject.getString("singerName");
        label276:
        localSongInfo.h = paramJSONObject;
        if (!localJSONObject.has("songmid")) {
          break label382;
        }
      }
      label321:
      label327:
      label334:
      label341:
      label348:
      label355:
      label362:
      label370:
      label376:
      label382:
      for (paramJSONObject = localJSONObject.getString("songmid");; paramJSONObject = "")
      {
        localSongInfo.jdField_a_of_type_JavaLangString = paramJSONObject;
        arrayOfSongInfo[i] = localSongInfo;
        i += 1;
        break;
        paramJSONObject = "";
        break label80;
        str = "";
        break label108;
        str = "";
        break label134;
        str = "";
        break label160;
        str = "";
        break label186;
        str = "";
        break label212;
        l = Long.parseLong(paramJSONObject);
        break label228;
        paramJSONObject = "";
        break label252;
        paramJSONObject = "";
        break label276;
      }
    }
    return arrayOfSongInfo;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 4;
    case 3: 
      return 2;
    }
    return -1001;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Awdz != null) {}
    try
    {
      String str1 = this.jdField_a_of_type_Awdz.a();
      String str2 = a();
      bool1 = bool2;
      if (!TextUtils.isEmpty(str1))
      {
        boolean bool3 = str1.equals(str2);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  private void c()
  {
    callJs(String.format("try{qqmusicBridge.appTrigger('%s');}catch(e){}", new Object[] { "CALLPAGE_SHARE" }));
  }
  
  private boolean c()
  {
    return (1 == this.c) || (2 == this.c);
  }
  
  private void d()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.a();
        if ((localActivity != null) && (this.jdField_a_of_type_Awdz == null))
        {
          localActivity.bindService(new Intent(localActivity, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
          QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService end!");
          return;
        }
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService activity is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService exception", localException);
      return;
    }
    QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService mRuntime is null!");
  }
  
  private void e()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.a();
        if (localActivity != null) {
          localActivity.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934594L) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      Intent localIntent = new Intent("BROAD_CAST_UPDATE_TITLE");
      localIntent.putExtra("BUNDLE_KEY_URL", paramString);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.music.data.permission");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  /* Error */
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: new 530	java/util/ArrayList
    //   3: dup
    //   4: aload 5
    //   6: invokestatic 536	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   9: invokespecial 539	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   12: astore 20
    //   14: ldc 59
    //   16: aload_3
    //   17: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +2959 -> 2979
    //   23: ldc_w 541
    //   26: aload 4
    //   28: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +2741 -> 2772
    //   34: aload 20
    //   36: iconst_0
    //   37: invokevirtual 542	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   40: checkcast 281	java/lang/String
    //   43: astore_2
    //   44: new 164	org/json/JSONObject
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 313	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: ldc_w 544
    //   57: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   60: ifeq +108 -> 168
    //   63: aload_2
    //   64: ldc_w 544
    //   67: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_3
    //   71: aload_2
    //   72: ldc_w 273
    //   75: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   78: ifeq +2974 -> 3052
    //   81: aload_2
    //   82: ldc_w 273
    //   85: invokevirtual 548	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +65 -> 155
    //   93: aload_2
    //   94: ldc_w 359
    //   97: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   100: ifeq +55 -> 155
    //   103: aload_0
    //   104: aload_2
    //   105: ldc_w 359
    //   108: invokevirtual 551	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   111: putfield 461	awes:c	I
    //   114: ldc_w 553
    //   117: aload_3
    //   118: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: istore 13
    //   123: iload 13
    //   125: ifeq +86 -> 211
    //   128: ldc 142
    //   130: iconst_1
    //   131: ldc_w 555
    //   134: invokestatic 421	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_0
    //   138: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   141: ifnonnull +29 -> 170
    //   144: aload_0
    //   145: aload_1
    //   146: putfield 131	awes:jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener	Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;
    //   149: aload_0
    //   150: invokespecial 557	awes:d	()V
    //   153: iconst_1
    //   154: ireturn
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 461	awes:c	I
    //   160: goto -46 -> 114
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   168: iconst_1
    //   169: ireturn
    //   170: new 164	org/json/JSONObject
    //   173: dup
    //   174: invokespecial 179	org/json/JSONObject:<init>	()V
    //   177: astore_2
    //   178: aload_2
    //   179: ldc_w 267
    //   182: ldc_w 269
    //   185: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: aload_1
    //   190: aload_2
    //   191: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   194: goto -41 -> 153
    //   197: astore_1
    //   198: ldc 142
    //   200: iconst_1
    //   201: ldc_w 564
    //   204: aload_1
    //   205: invokestatic 492	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: goto -55 -> 153
    //   211: aload_0
    //   212: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   215: astore 21
    //   217: aload 21
    //   219: ifnonnull +5 -> 224
    //   222: iconst_0
    //   223: ireturn
    //   224: ldc_w 566
    //   227: aload_3
    //   228: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +419 -> 650
    //   234: ldc_w 568
    //   237: astore_3
    //   238: aload_0
    //   239: aload_2
    //   240: invokespecial 570	awes:a	(Lorg/json/JSONObject;)[Lcom/tencent/mobileqq/music/SongInfo;
    //   243: astore 5
    //   245: aload 5
    //   247: ifnull +358 -> 605
    //   250: iconst_0
    //   251: istore 8
    //   253: ldc_w 269
    //   256: astore_3
    //   257: lconst_0
    //   258: lstore 14
    //   260: aconst_null
    //   261: astore 4
    //   263: aload_2
    //   264: ldc_w 366
    //   267: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   270: ifeq +12 -> 282
    //   273: aload_2
    //   274: ldc_w 366
    //   277: invokevirtual 551	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   280: istore 8
    //   282: aload_2
    //   283: ldc_w 351
    //   286: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   289: ifeq +11 -> 300
    //   292: aload_2
    //   293: ldc_w 351
    //   296: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: astore_3
    //   300: aload_2
    //   301: ldc_w 572
    //   304: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   307: ifeq +12 -> 319
    //   310: aload_2
    //   311: ldc_w 572
    //   314: invokevirtual 575	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   317: lstore 14
    //   319: aload_2
    //   320: ldc_w 577
    //   323: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   326: ifeq +11 -> 337
    //   329: aload_2
    //   330: ldc_w 577
    //   333: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   336: pop
    //   337: aload_2
    //   338: ldc_w 429
    //   341: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   344: ifeq +12 -> 356
    //   347: aload_2
    //   348: ldc_w 429
    //   351: invokevirtual 433	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   354: astore 4
    //   356: lload 14
    //   358: invokestatic 581	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   361: astore 22
    //   363: new 472	android/content/Intent
    //   366: dup
    //   367: aload_0
    //   368: getfield 506	awes:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   371: ldc_w 583
    //   374: invokespecial 477	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   377: astore 20
    //   379: ldc_w 585
    //   382: iconst_1
    //   383: anewarray 277	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 22
    //   390: aastore
    //   391: invokestatic 285	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   394: astore 23
    //   396: aload 20
    //   398: ldc_w 572
    //   401: aload 22
    //   403: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   406: pop
    //   407: aload 20
    //   409: ldc_w 587
    //   412: aload 23
    //   414: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   417: pop
    //   418: aload 20
    //   420: ldc_w 589
    //   423: iconst_1
    //   424: invokevirtual 592	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   427: pop
    //   428: aload_2
    //   429: ldc_w 594
    //   432: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   435: ifeq +31 -> 466
    //   438: aload_2
    //   439: ldc_w 594
    //   442: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: astore 22
    //   447: aload 22
    //   449: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   452: ifne +14 -> 466
    //   455: aload 20
    //   457: ldc_w 587
    //   460: aload 22
    //   462: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   465: pop
    //   466: new 311	android/os/Bundle
    //   469: dup
    //   470: invokespecial 595	android/os/Bundle:<init>	()V
    //   473: astore 22
    //   475: aload 22
    //   477: ldc_w 597
    //   480: lload 14
    //   482: invokevirtual 601	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   485: aload 22
    //   487: ldc_w 309
    //   490: aload_3
    //   491: invokevirtual 605	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload 22
    //   496: ldc_w 315
    //   499: aload_0
    //   500: getfield 461	awes:c	I
    //   503: invokevirtual 609	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   506: aload 4
    //   508: ifnull +16 -> 524
    //   511: aload 22
    //   513: ldc_w 611
    //   516: aload 4
    //   518: invokevirtual 612	org/json/JSONArray:toString	()Ljava/lang/String;
    //   521: invokevirtual 605	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: aload 22
    //   526: ldc_w 273
    //   529: aload_2
    //   530: invokevirtual 342	org/json/JSONObject:toString	()Ljava/lang/String;
    //   533: invokevirtual 605	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload 21
    //   538: aload 22
    //   540: invokeinterface 615 2 0
    //   545: aload 21
    //   547: aload_0
    //   548: getfield 39	awes:jdField_a_of_type_Awdx	Lawdx;
    //   551: invokeinterface 618 2 0
    //   556: aload 20
    //   558: ifnull +12 -> 570
    //   561: aload 21
    //   563: aload 20
    //   565: invokeinterface 621 2 0
    //   570: aload_0
    //   571: invokespecial 136	awes:c	()Z
    //   574: ifeq +56 -> 630
    //   577: aload 21
    //   579: bipush 102
    //   581: invokeinterface 624 2 0
    //   586: aload 21
    //   588: aload_0
    //   589: invokespecial 451	awes:a	()Ljava/lang/String;
    //   592: aload 5
    //   594: iload 8
    //   596: invokeinterface 627 4 0
    //   601: ldc_w 269
    //   604: astore_3
    //   605: new 164	org/json/JSONObject
    //   608: dup
    //   609: invokespecial 179	org/json/JSONObject:<init>	()V
    //   612: astore_2
    //   613: aload_2
    //   614: ldc_w 267
    //   617: aload_3
    //   618: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   621: pop
    //   622: aload_1
    //   623: aload_2
    //   624: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   627: goto -459 -> 168
    //   630: aload 21
    //   632: bipush 103
    //   634: invokeinterface 624 2 0
    //   639: goto -53 -> 586
    //   642: astore_2
    //   643: aload_2
    //   644: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   647: goto -46 -> 601
    //   650: ldc_w 629
    //   653: aload_3
    //   654: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   657: ifeq +48 -> 705
    //   660: aload_0
    //   661: aload 21
    //   663: invokeinterface 299 1 0
    //   668: putfield 631	awes:jdField_b_of_type_Int	I
    //   671: aload 21
    //   673: invokeinterface 633 1 0
    //   678: new 164	org/json/JSONObject
    //   681: dup
    //   682: invokespecial 179	org/json/JSONObject:<init>	()V
    //   685: astore_2
    //   686: aload_2
    //   687: ldc_w 267
    //   690: ldc_w 269
    //   693: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   696: pop
    //   697: aload_1
    //   698: aload_2
    //   699: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   702: goto -534 -> 168
    //   705: ldc_w 635
    //   708: aload_3
    //   709: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifeq +37 -> 749
    //   715: aload 21
    //   717: invokeinterface 637 1 0
    //   722: new 164	org/json/JSONObject
    //   725: dup
    //   726: invokespecial 179	org/json/JSONObject:<init>	()V
    //   729: astore_2
    //   730: aload_2
    //   731: ldc_w 267
    //   734: ldc_w 269
    //   737: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   740: pop
    //   741: aload_1
    //   742: aload_2
    //   743: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   746: goto -578 -> 168
    //   749: ldc_w 639
    //   752: aload_3
    //   753: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   756: ifeq +37 -> 793
    //   759: aload 21
    //   761: invokeinterface 640 1 0
    //   766: new 164	org/json/JSONObject
    //   769: dup
    //   770: invokespecial 179	org/json/JSONObject:<init>	()V
    //   773: astore_2
    //   774: aload_2
    //   775: ldc_w 267
    //   778: ldc_w 269
    //   781: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   784: pop
    //   785: aload_1
    //   786: aload_2
    //   787: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   790: goto -622 -> 168
    //   793: ldc_w 642
    //   796: aload_3
    //   797: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   800: ifeq +37 -> 837
    //   803: aload 21
    //   805: invokeinterface 643 1 0
    //   810: new 164	org/json/JSONObject
    //   813: dup
    //   814: invokespecial 179	org/json/JSONObject:<init>	()V
    //   817: astore_2
    //   818: aload_2
    //   819: ldc_w 267
    //   822: ldc_w 269
    //   825: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   828: pop
    //   829: aload_1
    //   830: aload_2
    //   831: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   834: goto -666 -> 168
    //   837: ldc_w 645
    //   840: aload_3
    //   841: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   844: ifeq +37 -> 881
    //   847: aload 21
    //   849: invokeinterface 647 1 0
    //   854: new 164	org/json/JSONObject
    //   857: dup
    //   858: invokespecial 179	org/json/JSONObject:<init>	()V
    //   861: astore_2
    //   862: aload_2
    //   863: ldc_w 267
    //   866: ldc_w 269
    //   869: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   872: pop
    //   873: aload_1
    //   874: aload_2
    //   875: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   878: goto -710 -> 168
    //   881: ldc_w 649
    //   884: aload_3
    //   885: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   888: istore 13
    //   890: iload 13
    //   892: ifeq +431 -> 1323
    //   895: aconst_null
    //   896: astore_2
    //   897: aload 21
    //   899: invokeinterface 307 1 0
    //   904: astore_3
    //   905: aload_3
    //   906: ifnull +2141 -> 3047
    //   909: aload_3
    //   910: astore_2
    //   911: aload_3
    //   912: ldc_w 273
    //   915: invokevirtual 652	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   918: ifeq +2129 -> 3047
    //   921: aload_3
    //   922: astore_2
    //   923: new 164	org/json/JSONObject
    //   926: dup
    //   927: aload_3
    //   928: ldc_w 273
    //   931: invokevirtual 312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   934: invokespecial 313	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   937: astore 4
    //   939: aload 4
    //   941: astore_2
    //   942: aload_3
    //   943: astore 4
    //   945: aload_2
    //   946: ifnonnull +2096 -> 3042
    //   949: new 164	org/json/JSONObject
    //   952: dup
    //   953: invokespecial 179	org/json/JSONObject:<init>	()V
    //   956: astore_3
    //   957: aload_0
    //   958: invokespecial 296	awes:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   961: astore 20
    //   963: aload 4
    //   965: ifnull +2092 -> 3057
    //   968: aload 4
    //   970: ldc_w 315
    //   973: iconst_0
    //   974: invokevirtual 319	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   977: istore 8
    //   979: aload 4
    //   981: ifnull +2082 -> 3063
    //   984: aload 4
    //   986: ldc_w 597
    //   989: invokevirtual 652	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   992: ifeq +2071 -> 3063
    //   995: aload 4
    //   997: ldc_w 597
    //   1000: invokevirtual 653	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1003: lstore 14
    //   1005: aload 20
    //   1007: ifnull +292 -> 1299
    //   1010: aconst_null
    //   1011: astore 5
    //   1013: aload 5
    //   1015: astore_2
    //   1016: aload 4
    //   1018: ifnull +51 -> 1069
    //   1021: aload 5
    //   1023: astore_2
    //   1024: aload 4
    //   1026: ldc_w 611
    //   1029: invokevirtual 652	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1032: ifeq +37 -> 1069
    //   1035: aload_0
    //   1036: new 155	org/json/JSONArray
    //   1039: dup
    //   1040: aload 4
    //   1042: ldc_w 611
    //   1045: invokevirtual 312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1048: invokespecial 654	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1051: invokespecial 656	awes:a	(Lorg/json/JSONArray;)Ljava/util/HashMap;
    //   1054: aload 20
    //   1056: getfield 196	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1059: invokestatic 581	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1062: invokevirtual 659	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1065: checkcast 164	org/json/JSONObject
    //   1068: astore_2
    //   1069: aload_2
    //   1070: ifnonnull +1969 -> 3039
    //   1073: aload_0
    //   1074: aload 20
    //   1076: invokespecial 321	awes:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   1079: astore_2
    //   1080: aload_2
    //   1081: ifnull +60 -> 1141
    //   1084: aload_2
    //   1085: invokevirtual 325	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1088: astore 4
    //   1090: aload 4
    //   1092: invokeinterface 330 1 0
    //   1097: ifeq +44 -> 1141
    //   1100: aload 4
    //   1102: invokeinterface 334 1 0
    //   1107: checkcast 281	java/lang/String
    //   1110: astore 5
    //   1112: aload_3
    //   1113: aload 5
    //   1115: aload_2
    //   1116: aload 5
    //   1118: invokevirtual 337	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1121: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1124: pop
    //   1125: goto -35 -> 1090
    //   1128: astore_3
    //   1129: aload_3
    //   1130: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   1133: aload_2
    //   1134: astore 4
    //   1136: aconst_null
    //   1137: astore_2
    //   1138: goto -193 -> 945
    //   1141: aload_0
    //   1142: invokespecial 301	awes:a	()I
    //   1145: i2l
    //   1146: lstore 18
    //   1148: aload 21
    //   1150: invokeinterface 302 1 0
    //   1155: istore 9
    //   1157: aload_0
    //   1158: iload 9
    //   1160: invokespecial 304	awes:b	(I)I
    //   1163: istore 10
    //   1165: iload 9
    //   1167: iconst_3
    //   1168: if_icmpne +104 -> 1272
    //   1171: aload_0
    //   1172: getfield 631	awes:jdField_b_of_type_Int	I
    //   1175: i2l
    //   1176: lstore 16
    //   1178: aload_0
    //   1179: invokespecial 368	awes:b	()Z
    //   1182: ifeq +103 -> 1285
    //   1185: aload_3
    //   1186: ldc_w 267
    //   1189: ldc_w 269
    //   1192: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1195: pop
    //   1196: aload_3
    //   1197: ldc_w 344
    //   1200: lload 16
    //   1202: ldc2_w 222
    //   1205: ldiv
    //   1206: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1209: pop
    //   1210: aload_3
    //   1211: ldc_w 349
    //   1214: lload 18
    //   1216: ldc2_w 222
    //   1219: ldiv
    //   1220: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1223: pop
    //   1224: aload_3
    //   1225: ldc_w 357
    //   1228: iload 10
    //   1230: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1233: pop
    //   1234: aload_3
    //   1235: ldc_w 359
    //   1238: iload 8
    //   1240: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1243: pop
    //   1244: aload_3
    //   1245: ldc_w 572
    //   1248: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1251: ifne +13 -> 1264
    //   1254: aload_3
    //   1255: ldc_w 572
    //   1258: lload 14
    //   1260: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1263: pop
    //   1264: aload_1
    //   1265: aload_3
    //   1266: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1269: goto -1101 -> 168
    //   1272: aload 21
    //   1274: invokeinterface 299 1 0
    //   1279: i2l
    //   1280: lstore 16
    //   1282: goto -104 -> 1178
    //   1285: aload_3
    //   1286: ldc_w 267
    //   1289: ldc_w 269
    //   1292: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1295: pop
    //   1296: goto -100 -> 1196
    //   1299: aload_3
    //   1300: ldc_w 267
    //   1303: ldc_w 568
    //   1306: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1309: pop
    //   1310: aload_3
    //   1311: ldc_w 359
    //   1314: iload 8
    //   1316: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1319: pop
    //   1320: goto -76 -> 1244
    //   1323: ldc_w 661
    //   1326: aload_3
    //   1327: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1330: istore 13
    //   1332: iload 13
    //   1334: ifeq +532 -> 1866
    //   1337: aconst_null
    //   1338: astore_2
    //   1339: aload 21
    //   1341: invokeinterface 307 1 0
    //   1346: astore_3
    //   1347: aload_3
    //   1348: ifnull +1686 -> 3034
    //   1351: aload_3
    //   1352: astore_2
    //   1353: aload_3
    //   1354: ldc_w 273
    //   1357: invokevirtual 652	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1360: ifeq +1674 -> 3034
    //   1363: aload_3
    //   1364: astore_2
    //   1365: new 164	org/json/JSONObject
    //   1368: dup
    //   1369: aload_3
    //   1370: ldc_w 273
    //   1373: invokevirtual 312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1376: invokespecial 313	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1379: astore 4
    //   1381: aload 4
    //   1383: astore_2
    //   1384: aload_3
    //   1385: astore 5
    //   1387: aload_2
    //   1388: ifnonnull +1640 -> 3028
    //   1391: new 164	org/json/JSONObject
    //   1394: dup
    //   1395: invokespecial 179	org/json/JSONObject:<init>	()V
    //   1398: astore 4
    //   1400: aload 5
    //   1402: ifnull +1680 -> 3082
    //   1405: aload 5
    //   1407: ldc_w 315
    //   1410: iconst_0
    //   1411: invokevirtual 319	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1414: istore 11
    //   1416: aload 5
    //   1418: ifnull +1670 -> 3088
    //   1421: aload 5
    //   1423: ldc_w 597
    //   1426: invokevirtual 652	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1429: ifeq +1659 -> 3088
    //   1432: aload 5
    //   1434: ldc_w 597
    //   1437: invokevirtual 653	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1440: lstore 14
    //   1442: aconst_null
    //   1443: astore 20
    //   1445: ldc_w 269
    //   1448: astore_3
    //   1449: aload 5
    //   1451: ifnull +1571 -> 3022
    //   1454: aload 5
    //   1456: ldc_w 309
    //   1459: invokevirtual 652	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1462: ifeq +1632 -> 3094
    //   1465: aload 5
    //   1467: ldc_w 309
    //   1470: invokevirtual 312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1473: astore_2
    //   1474: aload_2
    //   1475: astore_3
    //   1476: aload 5
    //   1478: ldc_w 611
    //   1481: invokevirtual 652	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1484: ifeq +1538 -> 3022
    //   1487: new 155	org/json/JSONArray
    //   1490: dup
    //   1491: aload 5
    //   1493: ldc_w 611
    //   1496: invokevirtual 312	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1499: invokespecial 654	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1502: astore 5
    //   1504: aload_2
    //   1505: astore_3
    //   1506: aload 5
    //   1508: astore_2
    //   1509: iconst_0
    //   1510: istore 12
    //   1512: iconst_0
    //   1513: istore 10
    //   1515: iconst_0
    //   1516: istore 8
    //   1518: iconst_0
    //   1519: istore 9
    //   1521: aload_2
    //   1522: ifnonnull +249 -> 1771
    //   1525: new 155	org/json/JSONArray
    //   1528: dup
    //   1529: invokespecial 662	org/json/JSONArray:<init>	()V
    //   1532: astore_2
    //   1533: aload 21
    //   1535: invokeinterface 665 1 0
    //   1540: astore 5
    //   1542: aload_0
    //   1543: invokespecial 296	awes:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1546: astore 20
    //   1548: iload 8
    //   1550: istore 10
    //   1552: aload 5
    //   1554: ifnull +1547 -> 3101
    //   1557: iconst_0
    //   1558: istore 8
    //   1560: iload 9
    //   1562: istore 10
    //   1564: iload 8
    //   1566: aload 5
    //   1568: arraylength
    //   1569: if_icmpge +1532 -> 3101
    //   1572: aload 5
    //   1574: iload 8
    //   1576: aaload
    //   1577: astore 22
    //   1579: iload 9
    //   1581: istore 10
    //   1583: aload 22
    //   1585: ifnull +1484 -> 3069
    //   1588: aload_2
    //   1589: iload 8
    //   1591: aload_0
    //   1592: aload 22
    //   1594: invokespecial 321	awes:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   1597: invokevirtual 668	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1600: pop
    //   1601: iload 9
    //   1603: istore 10
    //   1605: aload 20
    //   1607: ifnull +1462 -> 3069
    //   1610: iload 9
    //   1612: istore 10
    //   1614: aload 22
    //   1616: getfield 196	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1619: aload 20
    //   1621: getfield 196	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1624: lcmp
    //   1625: ifne +1444 -> 3069
    //   1628: iload 8
    //   1630: istore 10
    //   1632: goto +1437 -> 3069
    //   1635: astore_3
    //   1636: aload_3
    //   1637: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   1640: aload_2
    //   1641: astore 5
    //   1643: aconst_null
    //   1644: astore_2
    //   1645: goto -258 -> 1387
    //   1648: aload 4
    //   1650: ldc_w 366
    //   1653: iload 10
    //   1655: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1658: pop
    //   1659: aload 4
    //   1661: ldc_w 357
    //   1664: aload_0
    //   1665: aload 21
    //   1667: invokeinterface 302 1 0
    //   1672: invokespecial 304	awes:b	(I)I
    //   1675: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1678: pop
    //   1679: aload 4
    //   1681: ldc_w 351
    //   1684: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1687: ifne +13 -> 1700
    //   1690: aload 4
    //   1692: ldc_w 351
    //   1695: aload_3
    //   1696: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1699: pop
    //   1700: aload 4
    //   1702: ldc_w 429
    //   1705: aload_2
    //   1706: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1709: pop
    //   1710: aload_0
    //   1711: invokespecial 368	awes:b	()Z
    //   1714: ifeq +137 -> 1851
    //   1717: aload 4
    //   1719: ldc_w 267
    //   1722: ldc_w 269
    //   1725: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1728: pop
    //   1729: aload 4
    //   1731: ldc_w 572
    //   1734: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1737: ifne +14 -> 1751
    //   1740: aload 4
    //   1742: ldc_w 572
    //   1745: lload 14
    //   1747: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1750: pop
    //   1751: aload 4
    //   1753: ldc_w 359
    //   1756: iload 11
    //   1758: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1761: pop
    //   1762: aload_1
    //   1763: aload 4
    //   1765: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1768: goto -1600 -> 168
    //   1771: aload 21
    //   1773: invokeinterface 665 1 0
    //   1778: astore 5
    //   1780: aload_0
    //   1781: invokespecial 296	awes:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1784: astore 20
    //   1786: aload 5
    //   1788: ifnull +1231 -> 3019
    //   1791: iconst_0
    //   1792: istore 8
    //   1794: iload 12
    //   1796: istore 9
    //   1798: iload 9
    //   1800: istore 10
    //   1802: iload 8
    //   1804: aload 5
    //   1806: arraylength
    //   1807: if_icmpge +1212 -> 3019
    //   1810: aload 5
    //   1812: iload 8
    //   1814: aaload
    //   1815: astore 22
    //   1817: iload 9
    //   1819: istore 10
    //   1821: aload 22
    //   1823: ifnull +1281 -> 3104
    //   1826: iload 9
    //   1828: istore 10
    //   1830: aload 22
    //   1832: getfield 196	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1835: aload 20
    //   1837: getfield 196	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1840: lcmp
    //   1841: ifne +1263 -> 3104
    //   1844: iload 8
    //   1846: istore 10
    //   1848: goto +1256 -> 3104
    //   1851: aload 4
    //   1853: ldc_w 267
    //   1856: ldc_w 269
    //   1859: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1862: pop
    //   1863: goto -134 -> 1729
    //   1866: ldc_w 670
    //   1869: aload_3
    //   1870: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1873: ifeq +78 -> 1951
    //   1876: bipush 103
    //   1878: istore 9
    //   1880: iload 9
    //   1882: istore 8
    //   1884: aload_2
    //   1885: ifnull +26 -> 1911
    //   1888: iload 9
    //   1890: istore 8
    //   1892: aload_2
    //   1893: ldc_w 672
    //   1896: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1899: ifeq +12 -> 1911
    //   1902: aload_2
    //   1903: ldc_w 672
    //   1906: invokevirtual 551	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1909: istore 8
    //   1911: aload 21
    //   1913: aload_0
    //   1914: iload 8
    //   1916: invokespecial 674	awes:a	(I)I
    //   1919: invokeinterface 624 2 0
    //   1924: new 164	org/json/JSONObject
    //   1927: dup
    //   1928: invokespecial 179	org/json/JSONObject:<init>	()V
    //   1931: astore_2
    //   1932: aload_2
    //   1933: ldc_w 267
    //   1936: ldc_w 269
    //   1939: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1942: pop
    //   1943: aload_1
    //   1944: aload_2
    //   1945: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1948: goto -1780 -> 168
    //   1951: ldc_w 676
    //   1954: aload_3
    //   1955: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1958: ifeq +108 -> 2066
    //   1961: aload_2
    //   1962: ifnull +1051 -> 3013
    //   1965: aload_2
    //   1966: ldc_w 678
    //   1969: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1972: ifeq +1041 -> 3013
    //   1975: aload_2
    //   1976: ldc_w 678
    //   1979: invokevirtual 551	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1982: istore 8
    //   1984: new 164	org/json/JSONObject
    //   1987: dup
    //   1988: invokespecial 179	org/json/JSONObject:<init>	()V
    //   1991: astore_3
    //   1992: aload_0
    //   1993: getfield 506	awes:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1996: astore_2
    //   1997: aload_2
    //   1998: ifnull +1008 -> 3006
    //   2001: iload 8
    //   2003: iflt +1003 -> 3006
    //   2006: iload 8
    //   2008: bipush 100
    //   2010: if_icmpgt +996 -> 3006
    //   2013: aload_2
    //   2014: ldc_w 680
    //   2017: invokevirtual 683	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2020: checkcast 685	android/media/AudioManager
    //   2023: astore_2
    //   2024: aload_2
    //   2025: ifnull +981 -> 3006
    //   2028: aload_2
    //   2029: iconst_3
    //   2030: aload_2
    //   2031: iconst_3
    //   2032: invokevirtual 688	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   2035: iload 8
    //   2037: imul
    //   2038: bipush 100
    //   2040: idiv
    //   2041: iconst_4
    //   2042: invokevirtual 692	android/media/AudioManager:setStreamVolume	(III)V
    //   2045: ldc_w 269
    //   2048: astore_2
    //   2049: aload_3
    //   2050: ldc_w 267
    //   2053: aload_2
    //   2054: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2057: pop
    //   2058: aload_1
    //   2059: aload_3
    //   2060: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2063: goto -1895 -> 168
    //   2066: ldc_w 694
    //   2069: aload_3
    //   2070: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2073: ifeq +192 -> 2265
    //   2076: aload_2
    //   2077: ifnull +146 -> 2223
    //   2080: aload_2
    //   2081: ldc_w 271
    //   2084: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2087: ifeq +136 -> 2223
    //   2090: aload_2
    //   2091: ldc_w 271
    //   2094: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2097: astore_3
    //   2098: aload_2
    //   2099: ldc_w 696
    //   2102: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2105: ifeq +124 -> 2229
    //   2108: aload_2
    //   2109: ldc_w 696
    //   2112: invokevirtual 551	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2115: istore 8
    //   2117: aload_3
    //   2118: invokestatic 701	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   2121: astore_2
    //   2122: new 703	java/io/File
    //   2125: dup
    //   2126: new 703	java/io/File
    //   2129: dup
    //   2130: new 255	java/lang/StringBuilder
    //   2133: dup
    //   2134: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   2137: getstatic 708	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   2140: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: getstatic 711	java/io/File:separator	Ljava/lang/String;
    //   2146: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: ldc_w 713
    //   2152: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2155: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2158: invokespecial 714	java/io/File:<init>	(Ljava/lang/String;)V
    //   2161: aload_2
    //   2162: invokespecial 717	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   2165: astore_2
    //   2166: aload_2
    //   2167: ifnull +10 -> 2177
    //   2170: aload_2
    //   2171: invokevirtual 720	java/io/File:exists	()Z
    //   2174: ifne +61 -> 2235
    //   2177: new 722	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin$5
    //   2180: dup
    //   2181: aload_0
    //   2182: aload_3
    //   2183: iload 8
    //   2185: aload_2
    //   2186: invokespecial 725	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin$5:<init>	(Lawes;Ljava/lang/String;ILjava/io/File;)V
    //   2189: bipush 8
    //   2191: aconst_null
    //   2192: iconst_1
    //   2193: invokestatic 731	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2196: new 164	org/json/JSONObject
    //   2199: dup
    //   2200: invokespecial 179	org/json/JSONObject:<init>	()V
    //   2203: astore_2
    //   2204: aload_2
    //   2205: ldc_w 267
    //   2208: ldc_w 269
    //   2211: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2214: pop
    //   2215: aload_1
    //   2216: aload_2
    //   2217: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2220: goto -2052 -> 168
    //   2223: ldc 147
    //   2225: astore_3
    //   2226: goto -128 -> 2098
    //   2229: iconst_0
    //   2230: istore 8
    //   2232: goto -115 -> 2117
    //   2235: aload_0
    //   2236: aload_2
    //   2237: invokevirtual 734	java/io/File:getPath	()Ljava/lang/String;
    //   2240: invokestatic 737	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   2243: invokespecial 293	awes:a	(Landroid/graphics/Bitmap;)V
    //   2246: goto -50 -> 2196
    //   2249: astore_2
    //   2250: aload_2
    //   2251: invokevirtual 115	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2254: goto -58 -> 2196
    //   2257: astore_2
    //   2258: aload_2
    //   2259: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   2262: goto -66 -> 2196
    //   2265: ldc_w 739
    //   2268: aload_3
    //   2269: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2272: ifeq +106 -> 2378
    //   2275: aload_0
    //   2276: getfield 506	awes:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2279: astore_2
    //   2280: new 164	org/json/JSONObject
    //   2283: dup
    //   2284: invokespecial 179	org/json/JSONObject:<init>	()V
    //   2287: astore_3
    //   2288: aload_2
    //   2289: ifnull +710 -> 2999
    //   2292: aload_2
    //   2293: ldc_w 680
    //   2296: invokevirtual 683	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2299: checkcast 685	android/media/AudioManager
    //   2302: astore_2
    //   2303: aload_2
    //   2304: ifnull +695 -> 2999
    //   2307: aload_2
    //   2308: iconst_3
    //   2309: invokevirtual 688	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   2312: i2f
    //   2313: fstore 6
    //   2315: aload_2
    //   2316: iconst_3
    //   2317: invokevirtual 742	android/media/AudioManager:getStreamVolume	(I)I
    //   2320: i2f
    //   2321: fstore 7
    //   2323: fload 7
    //   2325: f2i
    //   2326: istore 8
    //   2328: fload 6
    //   2330: fconst_0
    //   2331: fcmpl
    //   2332: ifle +15 -> 2347
    //   2335: fload 7
    //   2337: fload 6
    //   2339: fdiv
    //   2340: ldc_w 743
    //   2343: fmul
    //   2344: f2i
    //   2345: istore 8
    //   2347: aload_3
    //   2348: ldc_w 678
    //   2351: iload 8
    //   2353: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2356: pop
    //   2357: ldc_w 269
    //   2360: astore_2
    //   2361: aload_3
    //   2362: ldc_w 267
    //   2365: aload_2
    //   2366: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2369: pop
    //   2370: aload_1
    //   2371: aload_3
    //   2372: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2375: goto -2207 -> 168
    //   2378: ldc_w 745
    //   2381: aload_3
    //   2382: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2385: ifeq +185 -> 2570
    //   2388: aload_2
    //   2389: ldc_w 747
    //   2392: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2395: astore 4
    //   2397: aload_2
    //   2398: ldc_w 749
    //   2401: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2404: astore 5
    //   2406: aload_2
    //   2407: ldc_w 271
    //   2410: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2413: astore 20
    //   2415: aload_2
    //   2416: ldc_w 751
    //   2419: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2422: astore 21
    //   2424: aload_2
    //   2425: ldc_w 753
    //   2428: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2431: astore 22
    //   2433: ldc_w 755
    //   2436: astore_3
    //   2437: aload_2
    //   2438: ldc_w 757
    //   2441: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2444: ifeq +11 -> 2455
    //   2447: aload_2
    //   2448: ldc_w 757
    //   2451: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2454: astore_3
    //   2455: aload_0
    //   2456: getfield 506	awes:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2459: ifnull +84 -> 2543
    //   2462: new 472	android/content/Intent
    //   2465: dup
    //   2466: ldc_w 759
    //   2469: invokespecial 509	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2472: astore_2
    //   2473: aload_2
    //   2474: ldc_w 761
    //   2477: aload 4
    //   2479: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2482: pop
    //   2483: aload_2
    //   2484: ldc_w 763
    //   2487: aload 5
    //   2489: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2492: pop
    //   2493: aload_2
    //   2494: ldc_w 765
    //   2497: aload 20
    //   2499: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2502: pop
    //   2503: aload_2
    //   2504: ldc_w 767
    //   2507: aload 21
    //   2509: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2512: pop
    //   2513: aload_2
    //   2514: ldc_w 769
    //   2517: aload 22
    //   2519: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2522: pop
    //   2523: aload_2
    //   2524: ldc_w 771
    //   2527: aload_3
    //   2528: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2531: pop
    //   2532: aload_0
    //   2533: getfield 506	awes:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2536: aload_2
    //   2537: ldc_w 517
    //   2540: invokevirtual 523	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2543: new 164	org/json/JSONObject
    //   2546: dup
    //   2547: invokespecial 179	org/json/JSONObject:<init>	()V
    //   2550: astore_2
    //   2551: aload_2
    //   2552: ldc_w 267
    //   2555: ldc_w 269
    //   2558: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2561: pop
    //   2562: aload_1
    //   2563: aload_2
    //   2564: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2567: goto -2399 -> 168
    //   2570: ldc_w 773
    //   2573: aload_3
    //   2574: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2577: ifeq -2409 -> 168
    //   2580: aload_2
    //   2581: ldc_w 747
    //   2584: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2587: astore 4
    //   2589: aload_2
    //   2590: ldc_w 749
    //   2593: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2596: astore 5
    //   2598: aload_2
    //   2599: ldc_w 271
    //   2602: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2605: astore 20
    //   2607: aload_2
    //   2608: ldc_w 751
    //   2611: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2614: astore 21
    //   2616: aload_2
    //   2617: ldc_w 775
    //   2620: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2623: ifeq +368 -> 2991
    //   2626: aload_2
    //   2627: ldc_w 775
    //   2630: invokevirtual 575	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   2633: lstore 14
    //   2635: ldc_w 755
    //   2638: astore_3
    //   2639: aload_2
    //   2640: ldc_w 757
    //   2643: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2646: ifeq +11 -> 2657
    //   2649: aload_2
    //   2650: ldc_w 757
    //   2653: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2656: astore_3
    //   2657: aload_0
    //   2658: getfield 506	awes:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2661: ifnull +84 -> 2745
    //   2664: new 472	android/content/Intent
    //   2667: dup
    //   2668: ldc_w 777
    //   2671: invokespecial 509	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2674: astore_2
    //   2675: aload_2
    //   2676: ldc_w 761
    //   2679: aload 4
    //   2681: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2684: pop
    //   2685: aload_2
    //   2686: ldc_w 763
    //   2689: aload 5
    //   2691: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2694: pop
    //   2695: aload_2
    //   2696: ldc_w 765
    //   2699: aload 20
    //   2701: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2704: pop
    //   2705: aload_2
    //   2706: ldc_w 767
    //   2709: aload 21
    //   2711: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2714: pop
    //   2715: aload_2
    //   2716: ldc_w 779
    //   2719: lload 14
    //   2721: invokevirtual 782	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2724: pop
    //   2725: aload_2
    //   2726: ldc_w 771
    //   2729: aload_3
    //   2730: invokevirtual 515	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2733: pop
    //   2734: aload_0
    //   2735: getfield 506	awes:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2738: aload_2
    //   2739: ldc_w 517
    //   2742: invokevirtual 523	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2745: new 164	org/json/JSONObject
    //   2748: dup
    //   2749: invokespecial 179	org/json/JSONObject:<init>	()V
    //   2752: astore_2
    //   2753: aload_2
    //   2754: ldc_w 267
    //   2757: ldc_w 269
    //   2760: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2763: pop
    //   2764: aload_1
    //   2765: aload_2
    //   2766: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2769: goto -2601 -> 168
    //   2772: ldc_w 784
    //   2775: aload 4
    //   2777: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2780: ifeq +185 -> 2965
    //   2783: aload 20
    //   2785: iconst_0
    //   2786: invokevirtual 542	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2789: checkcast 281	java/lang/String
    //   2792: astore_2
    //   2793: new 164	org/json/JSONObject
    //   2796: dup
    //   2797: aload_2
    //   2798: invokespecial 313	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2801: astore_3
    //   2802: aconst_null
    //   2803: astore_2
    //   2804: aload_3
    //   2805: ldc_w 544
    //   2808: invokevirtual 355	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2811: ifeq +11 -> 2822
    //   2814: aload_3
    //   2815: ldc_w 544
    //   2818: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2821: astore_2
    //   2822: aload_0
    //   2823: getfield 71	awes:jdField_a_of_type_Awdz	Lawdz;
    //   2826: invokeinterface 307 1 0
    //   2831: astore_3
    //   2832: aload_3
    //   2833: ifnull +288 -> 3121
    //   2836: aload_3
    //   2837: ldc_w 315
    //   2840: iconst_0
    //   2841: invokevirtual 319	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2844: istore 8
    //   2846: ldc_w 370
    //   2849: aload_2
    //   2850: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2853: ifeq +60 -> 2913
    //   2856: aload_0
    //   2857: iconst_1
    //   2858: putfield 362	awes:jdField_a_of_type_Boolean	Z
    //   2861: new 164	org/json/JSONObject
    //   2864: dup
    //   2865: invokespecial 179	org/json/JSONObject:<init>	()V
    //   2868: astore_2
    //   2869: aload_2
    //   2870: ldc_w 359
    //   2873: iload 8
    //   2875: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2878: pop
    //   2879: aload_2
    //   2880: ldc_w 267
    //   2883: ldc_w 269
    //   2886: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2889: pop
    //   2890: aload_1
    //   2891: aload_2
    //   2892: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2895: aload_0
    //   2896: invokespecial 785	awes:a	()V
    //   2899: goto -2731 -> 168
    //   2902: astore_3
    //   2903: aload_3
    //   2904: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   2907: iconst_0
    //   2908: istore 8
    //   2910: goto -64 -> 2846
    //   2913: ldc_w 341
    //   2916: aload_2
    //   2917: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2920: ifeq -2752 -> 168
    //   2923: aload_0
    //   2924: iconst_1
    //   2925: putfield 295	awes:jdField_b_of_type_Boolean	Z
    //   2928: new 164	org/json/JSONObject
    //   2931: dup
    //   2932: invokespecial 179	org/json/JSONObject:<init>	()V
    //   2935: astore_2
    //   2936: aload_2
    //   2937: ldc_w 359
    //   2940: iload 8
    //   2942: invokevirtual 347	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2945: pop
    //   2946: aload_2
    //   2947: ldc_w 267
    //   2950: ldc_w 269
    //   2953: invokevirtual 188	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2956: pop
    //   2957: aload_1
    //   2958: aload_2
    //   2959: invokevirtual 562	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2962: goto -2794 -> 168
    //   2965: ldc_w 787
    //   2968: aload 4
    //   2970: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2973: ifeq -2805 -> 168
    //   2976: goto -2808 -> 168
    //   2979: aload_0
    //   2980: aload_1
    //   2981: aload_2
    //   2982: aload_3
    //   2983: aload 4
    //   2985: aload 5
    //   2987: invokespecial 789	com/tencent/mobileqq/webview/swift/WebViewPlugin:handleJsRequest	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   2990: ireturn
    //   2991: ldc2_w 790
    //   2994: lstore 14
    //   2996: goto -361 -> 2635
    //   2999: ldc_w 568
    //   3002: astore_2
    //   3003: goto -642 -> 2361
    //   3006: ldc_w 568
    //   3009: astore_2
    //   3010: goto -961 -> 2049
    //   3013: iconst_0
    //   3014: istore 8
    //   3016: goto -1032 -> 1984
    //   3019: goto -1371 -> 1648
    //   3022: aload 20
    //   3024: astore_2
    //   3025: goto -1516 -> 1509
    //   3028: aload_2
    //   3029: astore 4
    //   3031: goto -1631 -> 1400
    //   3034: aconst_null
    //   3035: astore_2
    //   3036: goto -1652 -> 1384
    //   3039: goto -1959 -> 1080
    //   3042: aload_2
    //   3043: astore_3
    //   3044: goto -2087 -> 957
    //   3047: aconst_null
    //   3048: astore_2
    //   3049: goto -2107 -> 942
    //   3052: aconst_null
    //   3053: astore_2
    //   3054: goto -2965 -> 89
    //   3057: iconst_0
    //   3058: istore 8
    //   3060: goto -2081 -> 979
    //   3063: lconst_0
    //   3064: lstore 14
    //   3066: goto -2061 -> 1005
    //   3069: iload 8
    //   3071: iconst_1
    //   3072: iadd
    //   3073: istore 8
    //   3075: iload 10
    //   3077: istore 9
    //   3079: goto -1519 -> 1560
    //   3082: iconst_0
    //   3083: istore 11
    //   3085: goto -1669 -> 1416
    //   3088: lconst_0
    //   3089: lstore 14
    //   3091: goto -1649 -> 1442
    //   3094: ldc_w 269
    //   3097: astore_2
    //   3098: goto -1624 -> 1474
    //   3101: goto -1453 -> 1648
    //   3104: iload 8
    //   3106: iconst_1
    //   3107: iadd
    //   3108: istore 8
    //   3110: iload 10
    //   3112: istore 9
    //   3114: goto -1316 -> 1798
    //   3117: astore_1
    //   3118: goto -2950 -> 168
    //   3121: iconst_0
    //   3122: istore 8
    //   3124: goto -278 -> 2846
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3127	0	this	awes
    //   0	3127	1	paramJsBridgeListener	JsBridgeListener
    //   0	3127	2	paramString1	String
    //   0	3127	3	paramString2	String
    //   0	3127	4	paramString3	String
    //   0	3127	5	paramVarArgs	String[]
    //   2313	25	6	f1	float
    //   2321	15	7	f2	float
    //   251	2872	8	i	int
    //   1155	1958	9	j	int
    //   1163	1948	10	k	int
    //   1414	1670	11	m	int
    //   1510	285	12	n	int
    //   121	1212	13	bool	boolean
    //   258	2832	14	l1	long
    //   1176	105	16	l2	long
    //   1146	69	18	l3	long
    //   12	3011	20	localObject1	Object
    //   215	2495	21	localObject2	Object
    //   361	2157	22	localObject3	Object
    //   394	19	23	str	String
    // Exception table:
    //   from	to	target	type
    //   44	89	163	java/lang/Exception
    //   93	114	163	java/lang/Exception
    //   114	123	163	java/lang/Exception
    //   155	160	163	java/lang/Exception
    //   198	208	163	java/lang/Exception
    //   211	217	163	java/lang/Exception
    //   224	234	163	java/lang/Exception
    //   238	245	163	java/lang/Exception
    //   263	282	163	java/lang/Exception
    //   282	300	163	java/lang/Exception
    //   300	319	163	java/lang/Exception
    //   319	337	163	java/lang/Exception
    //   337	356	163	java/lang/Exception
    //   356	466	163	java/lang/Exception
    //   466	506	163	java/lang/Exception
    //   511	524	163	java/lang/Exception
    //   524	536	163	java/lang/Exception
    //   605	627	163	java/lang/Exception
    //   643	647	163	java/lang/Exception
    //   650	702	163	java/lang/Exception
    //   705	746	163	java/lang/Exception
    //   749	790	163	java/lang/Exception
    //   793	834	163	java/lang/Exception
    //   837	878	163	java/lang/Exception
    //   881	890	163	java/lang/Exception
    //   949	957	163	java/lang/Exception
    //   957	963	163	java/lang/Exception
    //   968	979	163	java/lang/Exception
    //   984	1005	163	java/lang/Exception
    //   1024	1069	163	java/lang/Exception
    //   1073	1080	163	java/lang/Exception
    //   1084	1090	163	java/lang/Exception
    //   1090	1125	163	java/lang/Exception
    //   1129	1133	163	java/lang/Exception
    //   1141	1165	163	java/lang/Exception
    //   1171	1178	163	java/lang/Exception
    //   1178	1196	163	java/lang/Exception
    //   1196	1244	163	java/lang/Exception
    //   1244	1264	163	java/lang/Exception
    //   1264	1269	163	java/lang/Exception
    //   1272	1282	163	java/lang/Exception
    //   1285	1296	163	java/lang/Exception
    //   1299	1320	163	java/lang/Exception
    //   1323	1332	163	java/lang/Exception
    //   1391	1400	163	java/lang/Exception
    //   1405	1416	163	java/lang/Exception
    //   1421	1442	163	java/lang/Exception
    //   1454	1474	163	java/lang/Exception
    //   1476	1504	163	java/lang/Exception
    //   1525	1548	163	java/lang/Exception
    //   1564	1572	163	java/lang/Exception
    //   1588	1601	163	java/lang/Exception
    //   1614	1628	163	java/lang/Exception
    //   1636	1640	163	java/lang/Exception
    //   1648	1700	163	java/lang/Exception
    //   1700	1729	163	java/lang/Exception
    //   1729	1751	163	java/lang/Exception
    //   1751	1768	163	java/lang/Exception
    //   1771	1786	163	java/lang/Exception
    //   1802	1810	163	java/lang/Exception
    //   1830	1844	163	java/lang/Exception
    //   1851	1863	163	java/lang/Exception
    //   1866	1876	163	java/lang/Exception
    //   1892	1911	163	java/lang/Exception
    //   1911	1948	163	java/lang/Exception
    //   1951	1961	163	java/lang/Exception
    //   1965	1984	163	java/lang/Exception
    //   1984	1997	163	java/lang/Exception
    //   2013	2024	163	java/lang/Exception
    //   2028	2045	163	java/lang/Exception
    //   2049	2063	163	java/lang/Exception
    //   2066	2076	163	java/lang/Exception
    //   2080	2098	163	java/lang/Exception
    //   2098	2117	163	java/lang/Exception
    //   2117	2166	163	java/lang/Exception
    //   2170	2177	163	java/lang/Exception
    //   2177	2196	163	java/lang/Exception
    //   2196	2220	163	java/lang/Exception
    //   2250	2254	163	java/lang/Exception
    //   2258	2262	163	java/lang/Exception
    //   2265	2288	163	java/lang/Exception
    //   2292	2303	163	java/lang/Exception
    //   2307	2323	163	java/lang/Exception
    //   2335	2347	163	java/lang/Exception
    //   2347	2357	163	java/lang/Exception
    //   2361	2375	163	java/lang/Exception
    //   2378	2433	163	java/lang/Exception
    //   2437	2455	163	java/lang/Exception
    //   2455	2543	163	java/lang/Exception
    //   2543	2567	163	java/lang/Exception
    //   2570	2635	163	java/lang/Exception
    //   2639	2657	163	java/lang/Exception
    //   2657	2745	163	java/lang/Exception
    //   2745	2769	163	java/lang/Exception
    //   128	153	197	java/lang/Exception
    //   170	194	197	java/lang/Exception
    //   536	556	642	java/lang/Exception
    //   561	570	642	java/lang/Exception
    //   570	586	642	java/lang/Exception
    //   586	601	642	java/lang/Exception
    //   630	639	642	java/lang/Exception
    //   897	905	1128	java/lang/Exception
    //   911	921	1128	java/lang/Exception
    //   923	939	1128	java/lang/Exception
    //   1339	1347	1635	java/lang/Exception
    //   1353	1363	1635	java/lang/Exception
    //   1365	1381	1635	java/lang/Exception
    //   2235	2246	2249	java/lang/OutOfMemoryError
    //   2235	2246	2257	java/lang/Exception
    //   2822	2832	2902	java/lang/Exception
    //   2836	2846	2902	java/lang/Exception
    //   2793	2802	3117	org/json/JSONException
    //   2804	2822	3117	org/json/JSONException
    //   2822	2832	3117	org/json/JSONException
    //   2836	2846	3117	org/json/JSONException
    //   2846	2899	3117	org/json/JSONException
    //   2903	2907	3117	org/json/JSONException
    //   2913	2962	3117	org/json/JSONException
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    try
    {
      if ((this.jdField_a_of_type_Awdz == null) && (a(paramString1))) {
        d();
      }
      return super.handleSchemaRequest(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handleSchemaRequest exception", localException);
      }
    }
  }
  
  public void onCreate()
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {
      this.jdField_a_of_type_AndroidContentContext = localActivity.getApplicationContext();
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    for (;;)
    {
      try
      {
        b();
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localObject = this.jdField_a_of_type_Awdz;
          if (localObject == null) {}
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", localException);
        continue;
      }
      try
      {
        i = this.jdField_a_of_type_Awdz.a();
        if ((i == 2) || (i == 3)) {}
        try
        {
          localObject = this.jdField_a_of_type_Awdz.a();
          if ((localObject != null) && (((String)localObject).startsWith("music_gene_"))) {
            this.jdField_a_of_type_Awdz.c();
          }
        }
        catch (RemoteException localRemoteException2)
        {
          localRemoteException2.printStackTrace();
          continue;
        }
        a(4);
        e();
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentContext = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = null;
        super.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        localRemoteException1.printStackTrace();
        i = 4;
      }
    }
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (paramCustomWebView != null) {}
    label122:
    for (;;)
    {
      try
      {
        paramCustomWebView = paramCustomWebView.getUrl();
        if (!TextUtils.isEmpty(paramCustomWebView)) {
          break label122;
        }
        bguj localbguj = this.mRuntime.a(this.mRuntime.a());
        if ((localbguj == null) || (!(localbguj instanceof bgzu))) {
          break label122;
        }
        paramCustomWebView = ((bgzu)localbguj).getCurrentUrl();
        if (this.jdField_a_of_type_AndroidContentContext == null) {
          break;
        }
        if (a(paramCustomWebView)) {
          d();
        }
        paramCustomWebView = new IntentFilter();
        paramCustomWebView.addAction("BROAD_CAST_CALL_PAGE_SHARE");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramCustomWebView);
        return;
      }
      catch (Exception paramCustomWebView)
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", paramCustomWebView);
        return;
      }
      paramCustomWebView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awes
 * JD-Core Version:    0.7.0.1
 */