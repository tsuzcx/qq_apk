package com.tencent.biz.authorize;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonConfig
  extends AbstractConfig
{
  public final ConcurrentHashMap<String, Set<String>> c = new ConcurrentHashMap(50);
  public final Handler d = new JsonConfig.1(this, Looper.getMainLooper());
  
  public JsonConfig(SharedPreferences paramSharedPreferences, AbstractConfig paramAbstractConfig)
  {
    super(paramSharedPreferences, paramAbstractConfig);
  }
  
  private void h()
  {
    Object localObject1 = this.a;
    Object localObject2 = null;
    localObject1 = ((SharedPreferences)localObject1).getString("cmdConfig", null);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject1 = new JSONObject((String)localObject1);
    }
    catch (JSONException localJSONException1)
    {
      label37:
      break label37;
    }
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
      localObject1 = localObject2;
      break label71;
      QLog.e("AuthorizeConfig", 2, "now error! old mPref have no value for cmdConfig!");
      localObject1 = localObject2;
    }
    label71:
    if (localObject1 == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "now read cmdConfig {\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
      }
      localObject2 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"pub.idqqimg.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\",\"Troop.addGroupApp\", \"deviceapp.*\"]}");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException2)
    {
      label106:
      int i;
      break label106;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
    }
    if (localObject1 == null)
    {
      QLog.e("AuthorizeConfig", 1, "cmdJsonObject is null!");
      return;
    }
    localObject2 = ((JSONObject)localObject1).names();
    if ((localObject2 != null) && (((JSONArray)localObject2).length() != 0))
    {
      this.c.clear();
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        HashSet localHashSet = new HashSet(20);
        String str = ((JSONArray)localObject2).optString(i);
        JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray(str);
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          int j = 0;
          while (j < localJSONArray.length())
          {
            localHashSet.add(localJSONArray.optString(j));
            j += 1;
          }
          this.c.put(str, localHashSet);
        }
        i += 1;
      }
      return;
    }
    QLog.e("AuthorizeConfig", 1, "domain Name are all empty!");
  }
  
  private void i()
  {
    Object localObject1 = this.a.getString("cmd_config_new", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "Js Api Config JSONArray error!", localException);
        }
        localObject2 = null;
      }
      if ((localObject2 != null) && (localObject2.length() > 0))
      {
        this.c.clear();
        int m = localObject2.length();
        int i = 0;
        while (i < m)
        {
          Object localObject3 = localObject2.optJSONObject(i);
          JSONArray localJSONArray1 = ((JSONObject)localObject3).optJSONArray("api");
          JSONArray localJSONArray2 = ((JSONObject)localObject3).optJSONArray("match");
          int n = localJSONArray2.length();
          int j = 0;
          while (j < n)
          {
            String str = localJSONArray2.optString(j);
            Set localSet = (Set)this.c.get(str);
            localObject3 = localSet;
            if (localSet == null) {
              localObject3 = new HashSet(20);
            }
            int i1 = localJSONArray1.length();
            int k = 0;
            while (k < i1)
            {
              ((Set)localObject3).add(localJSONArray1.optString(k));
              k += 1;
            }
            this.c.put(str, localObject3);
            j += 1;
          }
          i += 1;
        }
        return;
      }
      QLog.e("AuthorizeConfig", 1, "Js Api Config JSONArray From Pref is empty");
      return;
    }
    QLog.e("AuthorizeConfig", 1, "get Js Api Config From Pref is empty!");
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a())
    {
      int i = this.b.a(paramString1, paramString2);
      if ((a(i)) || (!b(i))) {
        return i;
      }
    }
    if (this.c.size() == 0)
    {
      i();
      if (this.c.size() == 0) {
        h();
      }
    }
    if (this.c.size() == 0)
    {
      QLog.e("AuthorizeConfig", 1, "can not find any JS API, so return!");
      return a(false, true);
    }
    Object localObject = this.c.keySet();
    if (((Set)localObject).size() == 0) {
      return a(false, true);
    }
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {
      str = paramString1.toLowerCase();
    }
    do
    {
      paramString1 = ((Set)localObject).iterator();
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!paramString1.hasNext()) {
              break;
            }
            localObject = (String)paramString1.next();
          } while (!AuthorizeConfig.b((String)localObject, str));
          localObject = (Set)this.c.get(localObject);
        } while ((localObject == null) || (((Set)localObject).size() == 0));
        localObject = ((Set)localObject).iterator();
      }
    } while (!AuthorizeConfig.b((String)((Iterator)localObject).next(), paramString2));
    return a(true, false);
    return a(false, false);
  }
  
  /* Error */
  public String a(android.content.SharedPreferences.Editor paramEditor, String paramString)
  {
    // Byte code:
    //   0: ldc 142
    //   2: astore 14
    //   4: ldc 210
    //   6: astore 9
    //   8: ldc 128
    //   10: astore 18
    //   12: new 58	org/json/JSONObject
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 61	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: astore 19
    //   22: aload 14
    //   24: astore 12
    //   26: aload 9
    //   28: astore 10
    //   30: aload 14
    //   32: astore 13
    //   34: aload 9
    //   36: astore 11
    //   38: aload 19
    //   40: ldc 212
    //   42: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   45: astore 15
    //   47: aload 14
    //   49: astore 12
    //   51: aload 9
    //   53: astore 10
    //   55: aload 14
    //   57: astore 13
    //   59: aload 9
    //   61: astore 11
    //   63: new 15	java/util/concurrent/ConcurrentHashMap
    //   66: dup
    //   67: bipush 50
    //   69: invokespecial 18	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   72: astore 20
    //   74: aload 15
    //   76: ifnull +472 -> 548
    //   79: aload 14
    //   81: astore 12
    //   83: aload 9
    //   85: astore 10
    //   87: aload 14
    //   89: astore 13
    //   91: aload 9
    //   93: astore 11
    //   95: aload 15
    //   97: invokevirtual 95	org/json/JSONArray:length	()I
    //   100: ifle +448 -> 548
    //   103: aload 14
    //   105: astore 12
    //   107: aload 9
    //   109: astore 10
    //   111: aload 14
    //   113: astore 13
    //   115: aload 9
    //   117: astore 11
    //   119: aload_1
    //   120: ldc 126
    //   122: aload 15
    //   124: invokevirtual 218	org/json/JSONArray:toString	()Ljava/lang/String;
    //   127: invokeinterface 224 3 0
    //   132: pop
    //   133: aload 14
    //   135: astore 12
    //   137: aload 9
    //   139: astore 10
    //   141: aload 14
    //   143: astore 13
    //   145: aload 9
    //   147: astore 11
    //   149: aload_1
    //   150: ldc 44
    //   152: ldc 128
    //   154: invokeinterface 224 3 0
    //   159: pop
    //   160: aload 14
    //   162: astore 12
    //   164: aload 9
    //   166: astore 10
    //   168: aload 14
    //   170: astore 13
    //   172: aload 9
    //   174: astore 11
    //   176: aload 15
    //   178: invokevirtual 95	org/json/JSONArray:length	()I
    //   181: istore_3
    //   182: iconst_0
    //   183: istore 4
    //   185: aload 14
    //   187: astore_2
    //   188: iload 4
    //   190: iload_3
    //   191: if_icmpge +266 -> 457
    //   194: aload_2
    //   195: astore 12
    //   197: aload 9
    //   199: astore 10
    //   201: aload_2
    //   202: astore 13
    //   204: aload 9
    //   206: astore 11
    //   208: aload 15
    //   210: iload 4
    //   212: invokevirtual 138	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   215: astore 14
    //   217: aload_2
    //   218: astore 12
    //   220: aload 9
    //   222: astore 10
    //   224: aload_2
    //   225: astore 13
    //   227: aload 9
    //   229: astore 11
    //   231: aload 14
    //   233: ldc 140
    //   235: invokevirtual 109	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   238: astore 21
    //   240: aload_2
    //   241: astore 12
    //   243: aload 9
    //   245: astore 10
    //   247: aload_2
    //   248: astore 13
    //   250: aload 9
    //   252: astore 11
    //   254: aload 14
    //   256: aload_2
    //   257: invokevirtual 109	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   260: astore 16
    //   262: aload_2
    //   263: astore 12
    //   265: aload 9
    //   267: astore 10
    //   269: aload_2
    //   270: astore 13
    //   272: aload 9
    //   274: astore 11
    //   276: aload 16
    //   278: invokevirtual 95	org/json/JSONArray:length	()I
    //   281: istore 5
    //   283: iconst_0
    //   284: istore 6
    //   286: iload 6
    //   288: iload 5
    //   290: if_icmpge +1124 -> 1414
    //   293: aload_2
    //   294: astore 12
    //   296: aload 9
    //   298: astore 10
    //   300: aload_2
    //   301: astore 13
    //   303: aload 9
    //   305: astore 11
    //   307: aload 16
    //   309: iload 6
    //   311: invokevirtual 226	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   314: astore 22
    //   316: aload_2
    //   317: astore 12
    //   319: aload 9
    //   321: astore 10
    //   323: aload_2
    //   324: astore 13
    //   326: aload 9
    //   328: astore 11
    //   330: aload 20
    //   332: aload 22
    //   334: invokevirtual 146	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   337: checkcast 111	java/util/Set
    //   340: astore 17
    //   342: aload 17
    //   344: ifnonnull +1037 -> 1381
    //   347: new 100	java/util/HashSet
    //   350: dup
    //   351: bipush 20
    //   353: invokespecial 101	java/util/HashSet:<init>	(I)V
    //   356: astore 17
    //   358: goto +3 -> 361
    //   361: aload 9
    //   363: astore 10
    //   365: aload 21
    //   367: invokevirtual 95	org/json/JSONArray:length	()I
    //   370: istore 7
    //   372: iconst_0
    //   373: istore 8
    //   375: iload 8
    //   377: iload 7
    //   379: if_icmpge +41 -> 420
    //   382: aload_2
    //   383: astore 13
    //   385: aload 10
    //   387: astore 11
    //   389: aload_2
    //   390: astore 14
    //   392: aload 10
    //   394: astore 12
    //   396: aload 17
    //   398: aload 21
    //   400: iload 8
    //   402: invokevirtual 226	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   405: invokeinterface 115 2 0
    //   410: pop
    //   411: iload 8
    //   413: iconst_1
    //   414: iadd
    //   415: istore 8
    //   417: goto -42 -> 375
    //   420: aload_2
    //   421: astore 13
    //   423: aload 10
    //   425: astore 11
    //   427: aload_2
    //   428: astore 14
    //   430: aload 10
    //   432: astore 12
    //   434: aload 20
    //   436: aload 22
    //   438: aload 17
    //   440: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   443: pop
    //   444: iload 6
    //   446: iconst_1
    //   447: iadd
    //   448: istore 6
    //   450: aload 10
    //   452: astore 9
    //   454: goto -168 -> 286
    //   457: aload_2
    //   458: astore 13
    //   460: aload 9
    //   462: astore 11
    //   464: aload_2
    //   465: astore 14
    //   467: aload 9
    //   469: astore 12
    //   471: invokestatic 232	android/os/Message:obtain	()Landroid/os/Message;
    //   474: astore 15
    //   476: aload_2
    //   477: astore 13
    //   479: aload 9
    //   481: astore 11
    //   483: aload_2
    //   484: astore 14
    //   486: aload 9
    //   488: astore 12
    //   490: aload 15
    //   492: iconst_1
    //   493: putfield 236	android/os/Message:what	I
    //   496: aload_2
    //   497: astore 13
    //   499: aload 9
    //   501: astore 11
    //   503: aload_2
    //   504: astore 14
    //   506: aload 9
    //   508: astore 12
    //   510: aload 15
    //   512: aload 20
    //   514: putfield 240	android/os/Message:obj	Ljava/lang/Object;
    //   517: aload_2
    //   518: astore 11
    //   520: aload 9
    //   522: astore 10
    //   524: aload_2
    //   525: astore 12
    //   527: aload 9
    //   529: astore 13
    //   531: aload_0
    //   532: getfield 33	com/tencent/biz/authorize/JsonConfig:d	Landroid/os/Handler;
    //   535: aload 15
    //   537: invokevirtual 246	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   540: pop
    //   541: aload 18
    //   543: astore 10
    //   545: goto +160 -> 705
    //   548: ldc 142
    //   550: astore 12
    //   552: ldc 210
    //   554: astore 13
    //   556: aload 12
    //   558: astore 11
    //   560: aload 13
    //   562: astore 10
    //   564: ldc 69
    //   566: iconst_1
    //   567: ldc 248
    //   569: invokestatic 79	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: aconst_null
    //   573: areturn
    //   574: astore_2
    //   575: aload 11
    //   577: astore 9
    //   579: aload 10
    //   581: astore 11
    //   583: goto +20 -> 603
    //   586: astore_2
    //   587: aload 13
    //   589: astore 10
    //   591: goto +69 -> 660
    //   594: astore_2
    //   595: aload 12
    //   597: astore 9
    //   599: aload 10
    //   601: astore 11
    //   603: new 250	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   610: astore 10
    //   612: aload 10
    //   614: ldc 128
    //   616: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 10
    //   622: aload_2
    //   623: invokevirtual 259	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   626: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload 10
    //   632: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: astore 10
    //   637: aload 9
    //   639: astore_2
    //   640: aload 11
    //   642: astore 9
    //   644: goto +61 -> 705
    //   647: astore_2
    //   648: aload 13
    //   650: astore 9
    //   652: aload 11
    //   654: astore 10
    //   656: aload 9
    //   658: astore 12
    //   660: new 250	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   667: astore 9
    //   669: aload 9
    //   671: ldc 128
    //   673: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 9
    //   679: aload_2
    //   680: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   683: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 9
    //   689: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: astore 11
    //   694: aload 10
    //   696: astore 9
    //   698: aload 12
    //   700: astore_2
    //   701: aload 11
    //   703: astore 10
    //   705: aload_1
    //   706: ldc_w 263
    //   709: aload 19
    //   711: ldc_w 263
    //   714: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   717: invokevirtual 218	org/json/JSONArray:toString	()Ljava/lang/String;
    //   720: invokeinterface 224 3 0
    //   725: pop
    //   726: goto +49 -> 775
    //   729: astore 11
    //   731: new 250	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   738: astore 12
    //   740: aload 12
    //   742: aload 10
    //   744: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 12
    //   750: ldc_w 265
    //   753: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 12
    //   759: aload 11
    //   761: invokevirtual 266	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   764: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 12
    //   770: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: astore 10
    //   775: aload_1
    //   776: ldc_w 268
    //   779: aload 19
    //   781: ldc_w 270
    //   784: invokevirtual 274	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   787: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   790: invokeinterface 224 3 0
    //   795: pop
    //   796: goto +49 -> 845
    //   799: astore 11
    //   801: new 250	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   808: astore 12
    //   810: aload 12
    //   812: aload 10
    //   814: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload 12
    //   820: ldc_w 265
    //   823: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload 12
    //   829: aload 11
    //   831: invokevirtual 266	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   834: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload 12
    //   840: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: astore 10
    //   845: aload_1
    //   846: ldc_w 277
    //   849: aload 19
    //   851: ldc_w 279
    //   854: invokevirtual 274	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   857: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   860: invokeinterface 224 3 0
    //   865: pop
    //   866: goto +49 -> 915
    //   869: astore 11
    //   871: new 250	java/lang/StringBuilder
    //   874: dup
    //   875: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   878: astore 12
    //   880: aload 12
    //   882: aload 10
    //   884: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload 12
    //   890: ldc_w 265
    //   893: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 12
    //   899: aload 11
    //   901: invokevirtual 266	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   904: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload 12
    //   910: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: astore 10
    //   915: aload_1
    //   916: ldc_w 281
    //   919: aload 19
    //   921: ldc_w 281
    //   924: invokevirtual 274	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   927: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   930: invokeinterface 224 3 0
    //   935: pop
    //   936: goto +49 -> 985
    //   939: astore 11
    //   941: new 250	java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   948: astore 12
    //   950: aload 12
    //   952: aload 10
    //   954: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload 12
    //   960: ldc_w 265
    //   963: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload 12
    //   969: aload 11
    //   971: invokevirtual 266	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   974: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: aload 12
    //   980: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   983: astore 10
    //   985: new 58	org/json/JSONObject
    //   988: dup
    //   989: invokespecial 282	org/json/JSONObject:<init>	()V
    //   992: astore 11
    //   994: aload 19
    //   996: ldc_w 284
    //   999: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1002: astore 12
    //   1004: aload 12
    //   1006: invokevirtual 95	org/json/JSONArray:length	()I
    //   1009: istore 5
    //   1011: iconst_0
    //   1012: istore_3
    //   1013: iload_3
    //   1014: iload 5
    //   1016: if_icmpge +70 -> 1086
    //   1019: aload 12
    //   1021: iload_3
    //   1022: invokevirtual 286	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1025: astore 14
    //   1027: aload 14
    //   1029: ldc_w 288
    //   1032: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1035: astore 13
    //   1037: aload 14
    //   1039: aload_2
    //   1040: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1043: astore 14
    //   1045: aload 14
    //   1047: invokevirtual 95	org/json/JSONArray:length	()I
    //   1050: istore 6
    //   1052: iconst_0
    //   1053: istore 4
    //   1055: iload 4
    //   1057: iload 6
    //   1059: if_icmpge +388 -> 1447
    //   1062: aload 11
    //   1064: aload 14
    //   1066: iload 4
    //   1068: invokevirtual 226	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1071: aload 13
    //   1073: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1076: pop
    //   1077: iload 4
    //   1079: iconst_1
    //   1080: iadd
    //   1081: istore 4
    //   1083: goto -28 -> 1055
    //   1086: aload_1
    //   1087: ldc_w 284
    //   1090: aload 11
    //   1092: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1095: invokeinterface 224 3 0
    //   1100: pop
    //   1101: goto +47 -> 1148
    //   1104: astore_2
    //   1105: new 250	java/lang/StringBuilder
    //   1108: dup
    //   1109: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   1112: astore 11
    //   1114: aload 11
    //   1116: aload 10
    //   1118: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: pop
    //   1122: aload 11
    //   1124: ldc_w 265
    //   1127: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: pop
    //   1131: aload 11
    //   1133: aload_2
    //   1134: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1137: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: pop
    //   1141: aload 11
    //   1143: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: astore 10
    //   1148: aload_1
    //   1149: aload 9
    //   1151: aload 19
    //   1153: aload 9
    //   1155: invokevirtual 295	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   1158: invokeinterface 299 4 0
    //   1163: pop
    //   1164: goto +43 -> 1207
    //   1167: astore_2
    //   1168: new 250	java/lang/StringBuilder
    //   1171: dup
    //   1172: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   1175: astore 9
    //   1177: aload 9
    //   1179: ldc_w 301
    //   1182: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 9
    //   1188: aload_2
    //   1189: invokevirtual 261	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1192: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: ldc 69
    //   1198: iconst_1
    //   1199: aload 9
    //   1201: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokestatic 79	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1207: getstatic 304	com/tencent/biz/AuthorizeConfig:a	[Ljava/lang/String;
    //   1210: astore 9
    //   1212: aload 9
    //   1214: arraylength
    //   1215: istore 4
    //   1217: iconst_0
    //   1218: istore_3
    //   1219: iload_3
    //   1220: iload 4
    //   1222: if_icmpge +148 -> 1370
    //   1225: aload 9
    //   1227: iload_3
    //   1228: aaload
    //   1229: astore 11
    //   1231: aload 19
    //   1233: aload 11
    //   1235: invokevirtual 215	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1238: astore 12
    //   1240: aload_1
    //   1241: aload 11
    //   1243: aload 12
    //   1245: invokevirtual 218	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1248: invokeinterface 224 3 0
    //   1253: pop
    //   1254: aload 10
    //   1256: astore_2
    //   1257: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1260: ifeq +100 -> 1360
    //   1263: new 250	java/lang/StringBuilder
    //   1266: dup
    //   1267: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   1270: astore_2
    //   1271: aload_2
    //   1272: ldc_w 306
    //   1275: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: pop
    //   1279: aload_2
    //   1280: aload 11
    //   1282: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: pop
    //   1286: aload_2
    //   1287: ldc_w 308
    //   1290: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: aload_2
    //   1295: aload 12
    //   1297: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1300: pop
    //   1301: ldc 69
    //   1303: iconst_2
    //   1304: aload_2
    //   1305: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1308: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1311: aload 10
    //   1313: astore_2
    //   1314: goto +46 -> 1360
    //   1317: astore_2
    //   1318: new 250	java/lang/StringBuilder
    //   1321: dup
    //   1322: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   1325: astore 11
    //   1327: aload 11
    //   1329: aload 10
    //   1331: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: pop
    //   1335: aload 11
    //   1337: ldc_w 265
    //   1340: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload 11
    //   1346: aload_2
    //   1347: invokevirtual 266	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1350: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: pop
    //   1354: aload 11
    //   1356: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1359: astore_2
    //   1360: iload_3
    //   1361: iconst_1
    //   1362: iadd
    //   1363: istore_3
    //   1364: aload_2
    //   1365: astore 10
    //   1367: goto -148 -> 1219
    //   1370: aload 10
    //   1372: areturn
    //   1373: astore_1
    //   1374: goto +12 -> 1386
    //   1377: astore_1
    //   1378: goto +23 -> 1401
    //   1381: goto -1020 -> 361
    //   1384: astore 11
    //   1386: aload 9
    //   1388: astore 10
    //   1390: aload_2
    //   1391: astore 9
    //   1393: aload 11
    //   1395: astore_2
    //   1396: goto -797 -> 599
    //   1399: astore 11
    //   1401: aload 9
    //   1403: astore 10
    //   1405: aload_2
    //   1406: astore 9
    //   1408: aload 11
    //   1410: astore_2
    //   1411: goto -755 -> 656
    //   1414: iload 4
    //   1416: iconst_1
    //   1417: iadd
    //   1418: istore 4
    //   1420: goto -1232 -> 188
    //   1423: astore_2
    //   1424: aload 13
    //   1426: astore 9
    //   1428: aload 11
    //   1430: astore 10
    //   1432: goto -833 -> 599
    //   1435: astore_2
    //   1436: aload 14
    //   1438: astore 9
    //   1440: aload 12
    //   1442: astore 10
    //   1444: goto -788 -> 656
    //   1447: iload_3
    //   1448: iconst_1
    //   1449: iadd
    //   1450: istore_3
    //   1451: goto -438 -> 1013
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1454	0	this	JsonConfig
    //   0	1454	1	paramEditor	android.content.SharedPreferences.Editor
    //   0	1454	2	paramString	String
    //   181	1183	3	i	int
    //   183	1040	4	j	int
    //   281	736	5	k	int
    //   284	776	6	m	int
    //   370	10	7	n	int
    //   373	43	8	i1	int
    //   6	1220	9	localObject1	Object
    //   28	1343	10	localObject2	Object
    //   36	666	11	localObject3	Object
    //   729	31	11	localJSONException1	JSONException
    //   799	31	11	localJSONException2	JSONException
    //   869	31	11	localJSONException3	JSONException
    //   939	31	11	localJSONException4	JSONException
    //   992	363	11	localObject4	Object
    //   24	1272	12	localObject5	Object
    //   32	1040	13	localObject6	Object
    //   2	1063	14	localObject7	Object
    //   45	491	15	localObject8	Object
    //   260	48	16	localJSONArray1	JSONArray
    //   340	99	17	localObject9	Object
    //   10	532	18	str1	String
    //   20	1212	19	localJSONObject	JSONObject
    //   72	441	20	localConcurrentHashMap	ConcurrentHashMap
    //   238	161	21	localJSONArray2	JSONArray
    //   314	123	22	str2	String
    // Exception table:
    //   from	to	target	type
    //   531	541	574	java/lang/OutOfMemoryError
    //   564	572	574	java/lang/OutOfMemoryError
    //   531	541	586	java/lang/Exception
    //   564	572	586	java/lang/Exception
    //   38	47	594	java/lang/OutOfMemoryError
    //   63	74	594	java/lang/OutOfMemoryError
    //   95	103	594	java/lang/OutOfMemoryError
    //   119	133	594	java/lang/OutOfMemoryError
    //   149	160	594	java/lang/OutOfMemoryError
    //   176	182	594	java/lang/OutOfMemoryError
    //   208	217	594	java/lang/OutOfMemoryError
    //   231	240	594	java/lang/OutOfMemoryError
    //   254	262	594	java/lang/OutOfMemoryError
    //   276	283	594	java/lang/OutOfMemoryError
    //   307	316	594	java/lang/OutOfMemoryError
    //   330	342	594	java/lang/OutOfMemoryError
    //   38	47	647	java/lang/Exception
    //   63	74	647	java/lang/Exception
    //   95	103	647	java/lang/Exception
    //   119	133	647	java/lang/Exception
    //   149	160	647	java/lang/Exception
    //   176	182	647	java/lang/Exception
    //   208	217	647	java/lang/Exception
    //   231	240	647	java/lang/Exception
    //   254	262	647	java/lang/Exception
    //   276	283	647	java/lang/Exception
    //   307	316	647	java/lang/Exception
    //   330	342	647	java/lang/Exception
    //   705	726	729	org/json/JSONException
    //   775	796	799	org/json/JSONException
    //   845	866	869	org/json/JSONException
    //   915	936	939	org/json/JSONException
    //   985	1011	1104	java/lang/Exception
    //   1019	1052	1104	java/lang/Exception
    //   1062	1077	1104	java/lang/Exception
    //   1086	1101	1104	java/lang/Exception
    //   1148	1164	1167	java/lang/Exception
    //   1231	1254	1317	org/json/JSONException
    //   1257	1311	1317	org/json/JSONException
    //   347	358	1384	java/lang/OutOfMemoryError
    //   365	372	1384	java/lang/OutOfMemoryError
    //   347	358	1399	java/lang/Exception
    //   365	372	1399	java/lang/Exception
    //   396	411	1423	java/lang/OutOfMemoryError
    //   434	444	1423	java/lang/OutOfMemoryError
    //   471	476	1423	java/lang/OutOfMemoryError
    //   490	496	1423	java/lang/OutOfMemoryError
    //   510	517	1423	java/lang/OutOfMemoryError
    //   396	411	1435	java/lang/Exception
    //   434	444	1435	java/lang/Exception
    //   471	476	1435	java/lang/Exception
    //   490	496	1435	java/lang/Exception
    //   510	517	1435	java/lang/Exception
  }
  
  public JSONArray a(String paramString)
  {
    if (!a()) {
      return this.b.a(paramString);
    }
    Object localObject3 = this.a;
    Object localObject2 = null;
    Object localObject1 = null;
    localObject3 = ((SharedPreferences)localObject3).getString(paramString, null);
    if (localObject3 != null) {}
    try
    {
      localObject2 = new JSONArray((String)localObject3);
    }
    catch (JSONException localJSONException2)
    {
      label92:
      break label97;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Load server config for ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
      }
      return localObject2;
    }
    catch (JSONException localJSONException1)
    {
      break label92;
    }
    localObject1 = localObject2;
    label97:
    localObject2 = localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Decode ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" Config error");
      QLog.w("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public boolean a()
  {
    ((FlatBuffersConfig)this.b).g();
    return this.b.a() ^ true;
  }
  
  public String b()
  {
    if (!a()) {
      return this.b.b();
    }
    return this.a.getString("offlineHtml", null);
  }
  
  public String c()
  {
    if (!a()) {
      return this.b.c();
    }
    return this.a.getString("extra", null);
  }
  
  public String d()
  {
    if (!a()) {
      return this.b.d();
    }
    return this.a.getString("jump", null);
  }
  
  public JSONObject e()
  {
    if (!a()) {
      return this.b.e();
    }
    Object localObject = this.a;
    JSONObject localJSONObject = null;
    localObject = ((SharedPreferences)localObject).getString("schemes", null);
    if (localObject != null) {
      localJSONObject = new JSONObject((String)localObject);
    }
    return localJSONObject;
  }
  
  public void f()
  {
    g();
  }
  
  public void g()
  {
    this.d.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.JsonConfig
 * JD-Core Version:    0.7.0.1
 */