package com.tencent.mobileqq.activity.qwallet;

import Wallet.WalletSkinReq;
import Wallet.WalletSkinRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import wxq;
import wxr;
import wxs;
import wxt;
import wxv;

public class QWalletSkinHandler
{
  private static volatile QWalletSkinHandler jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences("qwallet_skin", 0);
  private PreloadManagerProxy jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy = PreloadManagerProxy.a(this.jdField_a_of_type_MqqAppAppRuntime);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
  private HashMap b = new HashMap();
  
  private int a(String paramString)
  {
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("skin_res_num" + l + paramString, -1);
  }
  
  public static QWalletSkinHandler a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler = new QWalletSkinHandler();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler;
    }
    finally {}
  }
  
  private String a(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "skin_" + paramString;
    case 0: 
      return "skin_" + paramString;
    }
    return a(paramString, this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin() + "");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = null;
    }
    for (;;)
    {
      return paramString2;
      Object localObject;
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("bid", paramString1);
        ((Bundle)localObject).putString("uin", paramString2);
        paramString1 = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getResIDByBusinessID", (Bundle)localObject);
        if ((paramString1 != null) && (paramString1.isSuccess())) {
          return paramString1.data.getString("res_id");
        }
      }
      else
      {
        paramString2 = QWalletSetting.a(paramString2, "skin_map", null);
        if (!TextUtils.isEmpty(paramString2)) {
          try
          {
            JSONArray localJSONArray1 = new JSONArray(paramString2);
            int i = 0;
            for (;;)
            {
              if (i >= localJSONArray1.length()) {
                break label219;
              }
              paramString2 = localJSONArray1.getJSONObject(i);
              localObject = paramString2.optString("res_id");
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                JSONArray localJSONArray2 = paramString2.optJSONArray("business_ids");
                if (localJSONArray2 != null)
                {
                  int j = 0;
                  for (;;)
                  {
                    if (j >= localJSONArray2.length()) {
                      break label211;
                    }
                    paramString2 = localJSONArray2.optString(j);
                    if (!TextUtils.isEmpty(paramString2))
                    {
                      boolean bool = QWalletTools.c(paramString1, paramString2);
                      paramString2 = (String)localObject;
                      if (bool) {
                        break;
                      }
                    }
                    j += 1;
                  }
                }
              }
              label211:
              i += 1;
            }
            return null;
          }
          catch (Exception paramString1) {}
        }
      }
    }
  }
  
  private HashMap a()
  {
    int i = a();
    if (i == 0) {
      return null;
    }
    this.jdField_a_of_type_JavaUtilHashMap = a(a(i + "", 0), this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_JavaUtilHashMap);
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  /* Error */
  private HashMap a(String paramString, Object paramObject, HashMap paramHashMap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_2
    //   4: monitorenter
    //   5: aload_3
    //   6: ifnull +7 -> 13
    //   9: aload_2
    //   10: monitorexit
    //   11: aload_3
    //   12: areturn
    //   13: aload_1
    //   14: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +7 -> 24
    //   20: aload_2
    //   21: monitorexit
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 225	com/tencent/mobileqq/activity/qwallet/QWalletSkinHandler:d	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 6
    //   31: aload 6
    //   33: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +7 -> 43
    //   39: aload_2
    //   40: monitorexit
    //   41: aconst_null
    //   42: areturn
    //   43: new 227	java/io/File
    //   46: dup
    //   47: aload 6
    //   49: invokespecial 228	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 7
    //   54: aload 7
    //   56: invokevirtual 231	java/io/File:exists	()Z
    //   59: ifeq +381 -> 440
    //   62: aload 7
    //   64: invokevirtual 234	java/io/File:isDirectory	()Z
    //   67: ifne +68 -> 135
    //   70: goto +370 -> 440
    //   73: iload 4
    //   75: ifeq +179 -> 254
    //   78: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +28 -> 109
    //   84: ldc 241
    //   86: iconst_2
    //   87: new 71	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   94: ldc 243
    //   96: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: aload_1
    //   111: invokespecial 249	com/tencent/mobileqq/activity/qwallet/QWalletSkinHandler:b	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_0
    //   116: getfield 63	com/tencent/mobileqq/activity/qwallet/QWalletSkinHandler:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManagerProxy;
    //   119: aload_3
    //   120: invokevirtual 250	com/tencent/mobileqq/activity/qwallet/preload/PreloadManagerProxy:d	(Ljava/lang/String;)Ljava/lang/String;
    //   123: astore_3
    //   124: aload_3
    //   125: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifeq +55 -> 183
    //   131: aload_2
    //   132: monitorexit
    //   133: aconst_null
    //   134: areturn
    //   135: aload 7
    //   137: invokevirtual 254	java/io/File:listFiles	()[Ljava/io/File;
    //   140: astore_3
    //   141: aload_3
    //   142: ifnull +8 -> 150
    //   145: aload_3
    //   146: arraylength
    //   147: ifgt +17 -> 164
    //   150: aload 6
    //   152: iconst_0
    //   153: invokestatic 259	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Z)V
    //   156: goto -83 -> 73
    //   159: astore_1
    //   160: aload_2
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    //   164: aload_0
    //   165: aload_1
    //   166: invokespecial 261	com/tencent/mobileqq/activity/qwallet/QWalletSkinHandler:a	(Ljava/lang/String;)I
    //   169: aload_3
    //   170: arraylength
    //   171: if_icmpeq +263 -> 434
    //   174: aload 6
    //   176: iconst_0
    //   177: invokestatic 259	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Z)V
    //   180: goto -107 -> 73
    //   183: aload_3
    //   184: aload 6
    //   186: invokestatic 263	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   189: ifne +39 -> 228
    //   192: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +29 -> 224
    //   198: ldc 241
    //   200: iconst_2
    //   201: new 71	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 265
    //   211: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_2
    //   225: monitorexit
    //   226: aconst_null
    //   227: areturn
    //   228: aload 7
    //   230: invokevirtual 254	java/io/File:listFiles	()[Ljava/io/File;
    //   233: astore 6
    //   235: aload 6
    //   237: astore_3
    //   238: aload 6
    //   240: ifnull +14 -> 254
    //   243: aload_0
    //   244: aload_1
    //   245: aload 6
    //   247: arraylength
    //   248: invokespecial 268	com/tencent/mobileqq/activity/qwallet/QWalletSkinHandler:a	(Ljava/lang/String;I)V
    //   251: aload 6
    //   253: astore_3
    //   254: new 21	java/util/HashMap
    //   257: dup
    //   258: invokespecial 22	java/util/HashMap:<init>	()V
    //   261: astore_1
    //   262: aload 7
    //   264: invokevirtual 231	java/io/File:exists	()Z
    //   267: ifeq +163 -> 430
    //   270: aload 7
    //   272: invokevirtual 234	java/io/File:isDirectory	()Z
    //   275: ifeq +155 -> 430
    //   278: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +52 -> 333
    //   284: new 71	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 270
    //   294: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_3
    //   298: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: ldc_w 275
    //   304: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: astore 6
    //   309: aload_3
    //   310: ifnull +135 -> 445
    //   313: aload_3
    //   314: arraylength
    //   315: istore 4
    //   317: ldc 241
    //   319: iconst_2
    //   320: aload 6
    //   322: iload 4
    //   324: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_3
    //   334: ifnull +8 -> 342
    //   337: aload_3
    //   338: arraylength
    //   339: ifgt +22 -> 361
    //   342: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +12 -> 357
    //   348: ldc 241
    //   350: iconst_2
    //   351: ldc_w 277
    //   354: invokestatic 247	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload_2
    //   358: monitorexit
    //   359: aload_1
    //   360: areturn
    //   361: aload_3
    //   362: arraylength
    //   363: istore 5
    //   365: iconst_0
    //   366: istore 4
    //   368: iload 4
    //   370: iload 5
    //   372: if_icmpge +54 -> 426
    //   375: aload_3
    //   376: iload 4
    //   378: aaload
    //   379: astore 6
    //   381: aload 6
    //   383: invokevirtual 280	java/io/File:getName	()Ljava/lang/String;
    //   386: astore 7
    //   388: aload 7
    //   390: iconst_0
    //   391: aload 7
    //   393: bipush 46
    //   395: invokevirtual 286	java/lang/String:lastIndexOf	(I)I
    //   398: invokevirtual 290	java/lang/String:substring	(II)Ljava/lang/String;
    //   401: astore 7
    //   403: aload 7
    //   405: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifne +43 -> 451
    //   411: aload_1
    //   412: aload 7
    //   414: aload 6
    //   416: invokevirtual 293	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   419: invokevirtual 297	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   422: pop
    //   423: goto +28 -> 451
    //   426: aload_2
    //   427: monitorexit
    //   428: aload_1
    //   429: areturn
    //   430: aload_2
    //   431: monitorexit
    //   432: aconst_null
    //   433: areturn
    //   434: iconst_0
    //   435: istore 4
    //   437: goto -364 -> 73
    //   440: aconst_null
    //   441: astore_3
    //   442: goto -369 -> 73
    //   445: iconst_0
    //   446: istore 4
    //   448: goto -131 -> 317
    //   451: iload 4
    //   453: iconst_1
    //   454: iadd
    //   455: istore 4
    //   457: goto -89 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	QWalletSkinHandler
    //   0	460	1	paramString	String
    //   0	460	2	paramObject	Object
    //   0	460	3	paramHashMap	HashMap
    //   1	455	4	i	int
    //   363	10	5	j	int
    //   29	386	6	localObject1	Object
    //   52	361	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	11	159	finally
    //   13	22	159	finally
    //   24	41	159	finally
    //   43	70	159	finally
    //   78	109	159	finally
    //   109	133	159	finally
    //   135	141	159	finally
    //   145	150	159	finally
    //   150	156	159	finally
    //   160	162	159	finally
    //   164	180	159	finally
    //   183	224	159	finally
    //   224	226	159	finally
    //   228	235	159	finally
    //   243	251	159	finally
    //   254	309	159	finally
    //   313	317	159	finally
    //   317	333	159	finally
    //   337	342	159	finally
    //   342	357	159	finally
    //   357	359	159	finally
    //   361	365	159	finally
    //   381	423	159	finally
    //   426	428	159	finally
    //   430	432	159	finally
  }
  
  private void a(int paramInt)
  {
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("skin_id" + l, paramInt).apply();
  }
  
  private void a(QWalletSkinHandler.SkinListener paramSkinListener, boolean paramBoolean)
  {
    if (paramSkinListener == null) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime.runOnUiThread(new wxv(this, paramSkinListener, paramBoolean));
  }
  
  private void a(String paramString, int paramInt)
  {
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("skin_res_num" + l + paramString, paramInt).apply();
  }
  
  private void a(String paramString1, String paramString2)
  {
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("zip_url" + l + paramString1, paramString2).apply();
  }
  
  public static void a(String paramString, JSONArray paramJSONArray)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONArray == null) || (paramJSONArray.length() <= 0)) {
      return;
    }
    QWalletSetting.a(paramString, "skin_map", paramJSONArray.toString());
  }
  
  private boolean a()
  {
    return a() != 0;
  }
  
  private String b(String paramString)
  {
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("zip_url" + l + paramString, "");
  }
  
  private String b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    PreloadResource localPreloadResource = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy.a(paramString1);
    if (localPreloadResource == null) {
      return null;
    }
    synchronized (this.b)
    {
      if (this.b.get(paramString1) == null) {
        this.b.put(paramString1, new Object());
      }
    }
    for (;;)
    {
      synchronized (this.b.get(paramString1))
      {
        Object localObject2 = (HashMap)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
        ??? = localObject2;
        if (localObject2 != null)
        {
          ??? = (String)((HashMap)localObject2).get(paramString2);
          if ((!TextUtils.isEmpty((CharSequence)???)) && (!new File((String)???).exists())) {
            ??? = null;
          }
        }
        else
        {
          localObject2 = c(paramString1);
          String str = b(paramString1);
          if ((TextUtils.isEmpty(localPreloadResource.url)) || (!QWalletTools.c(str, localPreloadResource.url)) || (!QWalletTools.c((String)localObject2, localPreloadResource.md5)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy.c(localPreloadResource.url) == null)) {
            break label238;
          }
          ??? = a(paramString1, ???, (HashMap)???);
          if (??? != null) {
            break;
          }
          return null;
          paramString1 = finally;
          throw paramString1;
        }
        return ???;
      }
      label238:
      QWalletTools.a(d(paramString1));
      a(paramString1, localPreloadResource.url);
      b(paramString1, localPreloadResource.md5);
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, ???);
    paramString1 = (String)((HashMap)???).get(paramString2);
    return paramString1;
  }
  
  private void b(String paramString1, String paramString2)
  {
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("skin_md5" + l + paramString1, paramString2).apply();
  }
  
  private String c(String paramString)
  {
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("skin_md5" + l + paramString, "");
  }
  
  private String d(String paramString)
  {
    String str = b(paramString);
    return PreloadResource.getFolderPathByMD5AndUrl(c(paramString), str);
  }
  
  public int a()
  {
    long l = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("skin_id" + l, 0);
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if (paramInt == 0) {
        return a(paramString2);
      }
    } while (paramInt != 1);
    return b(a(paramString1, 1), paramString2);
  }
  
  public String a(String paramString)
  {
    if (!a()) {
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      String str;
      if (this.jdField_a_of_type_JavaUtilHashMap != null)
      {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if ((!TextUtils.isEmpty(str)) && (!new File(str).exists())) {
          this.jdField_a_of_type_JavaUtilHashMap = null;
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilHashMap = a();
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          break label89;
        }
        return null;
      }
      return str;
    }
    label89:
    paramString = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    return paramString;
  }
  
  public void a(int paramInt, QWalletSkinHandler.SkinListener paramSkinListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletSkinHandler", 2, "OpenWalletSkin:" + paramInt);
    }
    WalletSkinReq localWalletSkinReq = new WalletSkinReq();
    localWalletSkinReq.uin = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    localWalletSkinReq.type = 1;
    localWalletSkinReq.skinID = paramInt;
    QWalletCommonServlet.a(localWalletSkinReq, new wxr(this, paramSkinListener));
  }
  
  public void a(WalletSkinRsp paramWalletSkinRsp, QWalletSkinHandler.SkinListener paramSkinListener)
  {
    ThreadManager.post(new wxt(this, paramWalletSkinRsp, paramSkinListener), 5, null, true);
  }
  
  public void a(QWalletSkinHandler.SkinListener paramSkinListener)
  {
    WalletSkinReq localWalletSkinReq = new WalletSkinReq();
    localWalletSkinReq.uin = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    localWalletSkinReq.type = 2;
    QWalletCommonServlet.a(localWalletSkinReq, new wxq(this, paramSkinListener));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletSkinHandler", 2, "updateSkinState:" + paramBoolean + "|" + a());
    }
    if (paramBoolean)
    {
      b(null);
      return;
    }
    a(0);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = a(paramString, 1);
        if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy.a(paramString) != null)) {
          return true;
        }
      }
    }
    else if (paramInt == 0) {
      return a();
    }
    return false;
  }
  
  public void b(QWalletSkinHandler.SkinListener paramSkinListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletSkinHandler", 2, "updateCurWalletSkin start");
    }
    new WalletSkinReq();
    WalletSkinReq localWalletSkinReq = new WalletSkinReq();
    localWalletSkinReq.uin = this.jdField_a_of_type_MqqAppAppRuntime.getLongAccountUin();
    localWalletSkinReq.type = 0;
    QWalletCommonServlet.a(localWalletSkinReq, new wxs(this, paramSkinListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler
 * JD-Core Version:    0.7.0.1
 */