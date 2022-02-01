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
  public final Handler a;
  public final ConcurrentHashMap<String, Set<String>> a;
  
  public JsonConfig(SharedPreferences paramSharedPreferences, AbstractConfig paramAbstractConfig)
  {
    super(paramSharedPreferences, paramAbstractConfig);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidOsHandler = new JsonConfig.1(this, Looper.getMainLooper());
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localHashSet);
        }
        i += 1;
      }
      return;
    }
    QLog.e("AuthorizeConfig", 1, "domain Name are all empty!");
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmd_config_new", "");
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
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
            Set localSet = (Set)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
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
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject3);
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
      int i = this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a(paramString1, paramString2);
      if ((a(i)) || (!b(i))) {
        return i;
      }
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)
    {
      d();
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
        c();
      }
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)
    {
      QLog.e("AuthorizeConfig", 1, "can not find any JS API, so return!");
      return a(false, true);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet();
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
          localObject = (Set)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        } while ((localObject == null) || (((Set)localObject).size() == 0));
        localObject = ((Set)localObject).iterator();
      }
    } while (!AuthorizeConfig.b((String)((Iterator)localObject).next(), paramString2));
    return a(true, false);
    return a(false, false);
  }
  
  public String a()
  {
    if (!a()) {
      return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("offlineHtml", null);
  }
  
  /* Error */
  public String a(android.content.SharedPreferences.Editor paramEditor, String paramString)
  {
    // Byte code:
    //   0: ldc 140
    //   2: astore 14
    //   4: ldc 212
    //   6: astore 9
    //   8: ldc 126
    //   10: astore 18
    //   12: new 56	org/json/JSONObject
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 59	org/json/JSONObject:<init>	(Ljava/lang/String;)V
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
    //   40: ldc 214
    //   42: invokevirtual 217	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   45: astore 15
    //   47: aload 14
    //   49: astore 12
    //   51: aload 9
    //   53: astore 10
    //   55: aload 14
    //   57: astore 13
    //   59: aload 9
    //   61: astore 11
    //   63: new 14	java/util/concurrent/ConcurrentHashMap
    //   66: dup
    //   67: bipush 50
    //   69: invokespecial 17	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
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
    //   97: invokevirtual 94	org/json/JSONArray:length	()I
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
    //   120: ldc 124
    //   122: aload 15
    //   124: invokevirtual 220	org/json/JSONArray:toString	()Ljava/lang/String;
    //   127: invokeinterface 226 3 0
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
    //   150: ldc 42
    //   152: ldc 126
    //   154: invokeinterface 226 3 0
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
    //   178: invokevirtual 94	org/json/JSONArray:length	()I
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
    //   212: invokevirtual 136	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
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
    //   233: ldc 138
    //   235: invokevirtual 108	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   257: invokevirtual 108	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   278: invokevirtual 94	org/json/JSONArray:length	()I
    //   281: istore 5
    //   283: iconst_0
    //   284: istore 6
    //   286: iload 6
    //   288: iload 5
    //   290: if_icmpge +1123 -> 1413
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
    //   311: invokevirtual 228	org/json/JSONArray:getString	(I)Ljava/lang/String;
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
    //   334: invokevirtual 144	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   337: checkcast 110	java/util/Set
    //   340: astore 17
    //   342: aload 17
    //   344: ifnonnull +1036 -> 1380
    //   347: new 99	java/util/HashSet
    //   350: dup
    //   351: bipush 20
    //   353: invokespecial 100	java/util/HashSet:<init>	(I)V
    //   356: astore 17
    //   358: goto +3 -> 361
    //   361: aload 9
    //   363: astore 10
    //   365: aload 21
    //   367: invokevirtual 94	org/json/JSONArray:length	()I
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
    //   402: invokevirtual 228	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   405: invokeinterface 114 2 0
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
    //   440: invokevirtual 118	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   471: invokestatic 234	android/os/Message:obtain	()Landroid/os/Message;
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
    //   493: putfield 238	android/os/Message:what	I
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
    //   514: putfield 242	android/os/Message:obj	Ljava/lang/Object;
    //   517: aload_2
    //   518: astore 11
    //   520: aload 9
    //   522: astore 10
    //   524: aload_2
    //   525: astore 12
    //   527: aload 9
    //   529: astore 13
    //   531: aload_0
    //   532: getfield 32	com/tencent/biz/authorize/JsonConfig:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   535: aload 15
    //   537: invokevirtual 248	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   540: pop
    //   541: aload 18
    //   543: astore 10
    //   545: goto +160 -> 705
    //   548: ldc 140
    //   550: astore 12
    //   552: ldc 212
    //   554: astore 13
    //   556: aload 12
    //   558: astore 11
    //   560: aload 13
    //   562: astore 10
    //   564: ldc 67
    //   566: iconst_1
    //   567: ldc 250
    //   569: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   603: new 252	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   610: astore 10
    //   612: aload 10
    //   614: ldc 126
    //   616: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 10
    //   622: aload_2
    //   623: invokevirtual 261	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   626: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload 10
    //   632: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   660: new 252	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   667: astore 9
    //   669: aload 9
    //   671: ldc 126
    //   673: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 9
    //   679: aload_2
    //   680: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   683: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 9
    //   689: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: astore 11
    //   694: aload 10
    //   696: astore 9
    //   698: aload 12
    //   700: astore_2
    //   701: aload 11
    //   703: astore 10
    //   705: aload_1
    //   706: ldc_w 265
    //   709: aload 19
    //   711: ldc_w 265
    //   714: invokevirtual 217	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   717: invokevirtual 220	org/json/JSONArray:toString	()Ljava/lang/String;
    //   720: invokeinterface 226 3 0
    //   725: pop
    //   726: goto +49 -> 775
    //   729: astore 11
    //   731: new 252	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   738: astore 12
    //   740: aload 12
    //   742: aload 10
    //   744: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 12
    //   750: ldc_w 267
    //   753: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 12
    //   759: aload 11
    //   761: invokevirtual 268	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   764: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 12
    //   770: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: astore 10
    //   775: aload_1
    //   776: ldc 207
    //   778: aload 19
    //   780: ldc_w 270
    //   783: invokevirtual 274	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   786: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   789: invokeinterface 226 3 0
    //   794: pop
    //   795: goto +49 -> 844
    //   798: astore 11
    //   800: new 252	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   807: astore 12
    //   809: aload 12
    //   811: aload 10
    //   813: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload 12
    //   819: ldc_w 267
    //   822: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload 12
    //   828: aload 11
    //   830: invokevirtual 268	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   833: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: aload 12
    //   839: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: astore 10
    //   844: aload_1
    //   845: ldc_w 277
    //   848: aload 19
    //   850: ldc_w 279
    //   853: invokevirtual 274	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   856: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   859: invokeinterface 226 3 0
    //   864: pop
    //   865: goto +49 -> 914
    //   868: astore 11
    //   870: new 252	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   877: astore 12
    //   879: aload 12
    //   881: aload 10
    //   883: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload 12
    //   889: ldc_w 267
    //   892: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 12
    //   898: aload 11
    //   900: invokevirtual 268	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   903: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload 12
    //   909: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: astore 10
    //   914: aload_1
    //   915: ldc_w 281
    //   918: aload 19
    //   920: ldc_w 281
    //   923: invokevirtual 274	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   926: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   929: invokeinterface 226 3 0
    //   934: pop
    //   935: goto +49 -> 984
    //   938: astore 11
    //   940: new 252	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   947: astore 12
    //   949: aload 12
    //   951: aload 10
    //   953: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload 12
    //   959: ldc_w 267
    //   962: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload 12
    //   968: aload 11
    //   970: invokevirtual 268	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   973: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload 12
    //   979: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: astore 10
    //   984: new 56	org/json/JSONObject
    //   987: dup
    //   988: invokespecial 282	org/json/JSONObject:<init>	()V
    //   991: astore 11
    //   993: aload 19
    //   995: ldc_w 284
    //   998: invokevirtual 217	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1001: astore 12
    //   1003: aload 12
    //   1005: invokevirtual 94	org/json/JSONArray:length	()I
    //   1008: istore 5
    //   1010: iconst_0
    //   1011: istore_3
    //   1012: iload_3
    //   1013: iload 5
    //   1015: if_icmpge +70 -> 1085
    //   1018: aload 12
    //   1020: iload_3
    //   1021: invokevirtual 286	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1024: astore 14
    //   1026: aload 14
    //   1028: ldc_w 288
    //   1031: invokevirtual 217	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1034: astore 13
    //   1036: aload 14
    //   1038: aload_2
    //   1039: invokevirtual 217	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1042: astore 14
    //   1044: aload 14
    //   1046: invokevirtual 94	org/json/JSONArray:length	()I
    //   1049: istore 6
    //   1051: iconst_0
    //   1052: istore 4
    //   1054: iload 4
    //   1056: iload 6
    //   1058: if_icmpge +388 -> 1446
    //   1061: aload 11
    //   1063: aload 14
    //   1065: iload 4
    //   1067: invokevirtual 228	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1070: aload 13
    //   1072: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1075: pop
    //   1076: iload 4
    //   1078: iconst_1
    //   1079: iadd
    //   1080: istore 4
    //   1082: goto -28 -> 1054
    //   1085: aload_1
    //   1086: ldc_w 284
    //   1089: aload 11
    //   1091: invokevirtual 275	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1094: invokeinterface 226 3 0
    //   1099: pop
    //   1100: goto +47 -> 1147
    //   1103: astore_2
    //   1104: new 252	java/lang/StringBuilder
    //   1107: dup
    //   1108: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1111: astore 11
    //   1113: aload 11
    //   1115: aload 10
    //   1117: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: pop
    //   1121: aload 11
    //   1123: ldc_w 267
    //   1126: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: aload 11
    //   1132: aload_2
    //   1133: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1136: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: pop
    //   1140: aload 11
    //   1142: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: astore 10
    //   1147: aload_1
    //   1148: aload 9
    //   1150: aload 19
    //   1152: aload 9
    //   1154: invokevirtual 295	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   1157: invokeinterface 299 4 0
    //   1162: pop
    //   1163: goto +43 -> 1206
    //   1166: astore_2
    //   1167: new 252	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1174: astore 9
    //   1176: aload 9
    //   1178: ldc_w 301
    //   1181: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: pop
    //   1185: aload 9
    //   1187: aload_2
    //   1188: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1191: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: ldc 67
    //   1197: iconst_1
    //   1198: aload 9
    //   1200: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1203: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1206: getstatic 304	com/tencent/biz/AuthorizeConfig:a	[Ljava/lang/String;
    //   1209: astore 9
    //   1211: aload 9
    //   1213: arraylength
    //   1214: istore 4
    //   1216: iconst_0
    //   1217: istore_3
    //   1218: iload_3
    //   1219: iload 4
    //   1221: if_icmpge +148 -> 1369
    //   1224: aload 9
    //   1226: iload_3
    //   1227: aaload
    //   1228: astore 11
    //   1230: aload 19
    //   1232: aload 11
    //   1234: invokevirtual 217	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1237: astore 12
    //   1239: aload_1
    //   1240: aload 11
    //   1242: aload 12
    //   1244: invokevirtual 220	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1247: invokeinterface 226 3 0
    //   1252: pop
    //   1253: aload 10
    //   1255: astore_2
    //   1256: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1259: ifeq +100 -> 1359
    //   1262: new 252	java/lang/StringBuilder
    //   1265: dup
    //   1266: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1269: astore_2
    //   1270: aload_2
    //   1271: ldc_w 306
    //   1274: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload_2
    //   1279: aload 11
    //   1281: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: pop
    //   1285: aload_2
    //   1286: ldc_w 308
    //   1289: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: pop
    //   1293: aload_2
    //   1294: aload 12
    //   1296: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: ldc 67
    //   1302: iconst_2
    //   1303: aload_2
    //   1304: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1307: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1310: aload 10
    //   1312: astore_2
    //   1313: goto +46 -> 1359
    //   1316: astore_2
    //   1317: new 252	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   1324: astore 11
    //   1326: aload 11
    //   1328: aload 10
    //   1330: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload 11
    //   1336: ldc_w 267
    //   1339: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: pop
    //   1343: aload 11
    //   1345: aload_2
    //   1346: invokevirtual 268	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1349: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: pop
    //   1353: aload 11
    //   1355: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1358: astore_2
    //   1359: iload_3
    //   1360: iconst_1
    //   1361: iadd
    //   1362: istore_3
    //   1363: aload_2
    //   1364: astore 10
    //   1366: goto -148 -> 1218
    //   1369: aload 10
    //   1371: areturn
    //   1372: astore_1
    //   1373: goto +12 -> 1385
    //   1376: astore_1
    //   1377: goto +23 -> 1400
    //   1380: goto -1019 -> 361
    //   1383: astore 11
    //   1385: aload 9
    //   1387: astore 10
    //   1389: aload_2
    //   1390: astore 9
    //   1392: aload 11
    //   1394: astore_2
    //   1395: goto -796 -> 599
    //   1398: astore 11
    //   1400: aload 9
    //   1402: astore 10
    //   1404: aload_2
    //   1405: astore 9
    //   1407: aload 11
    //   1409: astore_2
    //   1410: goto -754 -> 656
    //   1413: iload 4
    //   1415: iconst_1
    //   1416: iadd
    //   1417: istore 4
    //   1419: goto -1231 -> 188
    //   1422: astore_2
    //   1423: aload 13
    //   1425: astore 9
    //   1427: aload 11
    //   1429: astore 10
    //   1431: goto -832 -> 599
    //   1434: astore_2
    //   1435: aload 14
    //   1437: astore 9
    //   1439: aload 12
    //   1441: astore 10
    //   1443: goto -787 -> 656
    //   1446: iload_3
    //   1447: iconst_1
    //   1448: iadd
    //   1449: istore_3
    //   1450: goto -438 -> 1012
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1453	0	this	JsonConfig
    //   0	1453	1	paramEditor	android.content.SharedPreferences.Editor
    //   0	1453	2	paramString	String
    //   181	1182	3	i	int
    //   183	1039	4	j	int
    //   281	735	5	k	int
    //   284	775	6	m	int
    //   370	10	7	n	int
    //   373	43	8	i1	int
    //   6	1219	9	localObject1	Object
    //   28	1342	10	localObject2	Object
    //   36	666	11	localObject3	Object
    //   729	31	11	localJSONException1	JSONException
    //   798	31	11	localJSONException2	JSONException
    //   868	31	11	localJSONException3	JSONException
    //   938	31	11	localJSONException4	JSONException
    //   991	363	11	localObject4	Object
    //   24	1271	12	localObject5	Object
    //   32	1039	13	localObject6	Object
    //   2	1062	14	localObject7	Object
    //   45	491	15	localObject8	Object
    //   260	48	16	localJSONArray1	JSONArray
    //   340	99	17	localObject9	Object
    //   10	532	18	str1	String
    //   20	1211	19	localJSONObject	JSONObject
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
    //   775	795	798	org/json/JSONException
    //   844	865	868	org/json/JSONException
    //   914	935	938	org/json/JSONException
    //   984	1010	1103	java/lang/Exception
    //   1018	1051	1103	java/lang/Exception
    //   1061	1076	1103	java/lang/Exception
    //   1085	1100	1103	java/lang/Exception
    //   1147	1163	1166	java/lang/Exception
    //   1230	1253	1316	org/json/JSONException
    //   1256	1310	1316	org/json/JSONException
    //   347	358	1383	java/lang/OutOfMemoryError
    //   365	372	1383	java/lang/OutOfMemoryError
    //   347	358	1398	java/lang/Exception
    //   365	372	1398	java/lang/Exception
    //   396	411	1422	java/lang/OutOfMemoryError
    //   434	444	1422	java/lang/OutOfMemoryError
    //   471	476	1422	java/lang/OutOfMemoryError
    //   490	496	1422	java/lang/OutOfMemoryError
    //   510	517	1422	java/lang/OutOfMemoryError
    //   396	411	1434	java/lang/Exception
    //   434	444	1434	java/lang/Exception
    //   471	476	1434	java/lang/Exception
    //   490	496	1434	java/lang/Exception
    //   510	517	1434	java/lang/Exception
  }
  
  public JSONArray a(String paramString)
  {
    if (!a()) {
      return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a(paramString);
    }
    Object localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences;
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
  
  public JSONObject a()
  {
    if (!a()) {
      return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a();
    }
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    JSONObject localJSONObject = null;
    localObject = ((SharedPreferences)localObject).getString("schemes", null);
    if (localObject != null) {
      localJSONObject = new JSONObject((String)localObject);
    }
    return localJSONObject;
  }
  
  public void a()
  {
    b();
  }
  
  public boolean a()
  {
    ((FlatBuffersConfig)this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig).b();
    return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.a() ^ true;
  }
  
  public String b()
  {
    if (!a()) {
      return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.b();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("extra", null);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public String c()
  {
    if (!a()) {
      return this.jdField_a_of_type_ComTencentBizAuthorizeAbstractConfig.c();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("jump", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.authorize.JsonConfig
 * JD-Core Version:    0.7.0.1
 */