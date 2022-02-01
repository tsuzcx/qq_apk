package com.tencent.biz.pubaccount.NativeAd.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.AdDownloadCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADBaseAppDownloadManager;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class ADBaseAppDownloadManager
  implements WadlProxyServiceCallBackInterface, IADBaseAppDownloadManager, DownloadListener
{
  protected Handler a;
  protected SoftReference<Activity> a;
  private ArrayList<AdDownloadCallback> a;
  protected List<ADVideoAppDownloadData> a;
  protected Handler b;
  protected List<ADVideoAppDownloadData> b;
  
  public ADBaseAppDownloadManager(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    WadlProxyServiceUtil.a().a(this);
    DownloadManagerV2.a().a(this);
    paramActivity = new StringBuilder();
    paramActivity.append("registerWadlServiceCallBack ：");
    paramActivity.append(this);
    QLog.d("ADBaseAppDownloadManager", 1, paramActivity.toString());
  }
  
  public static int a(WadlResult paramWadlResult)
  {
    if (4 == paramWadlResult.jdField_b_of_type_Int) {
      return 3;
    }
    if (6 == paramWadlResult.jdField_b_of_type_Int) {
      return 5;
    }
    if (5 == paramWadlResult.jdField_b_of_type_Int) {
      return 4;
    }
    if ((9 != paramWadlResult.jdField_b_of_type_Int) && (10 != paramWadlResult.jdField_b_of_type_Int))
    {
      if (7 == paramWadlResult.jdField_b_of_type_Int) {
        return 6;
      }
      return 0;
    }
    return 1;
  }
  
  protected static String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static String a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 5
    //   14: iload_2
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +47 -> 70
    //   26: new 83	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: ldc 148
    //   37: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: aload_0
    //   43: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: ldc 150
    //   50: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: iload_1
    //   56: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 95
    //   62: iconst_2
    //   63: aload_3
    //   64: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +34 -> 107
    //   76: new 83	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   83: astore_3
    //   84: aload_3
    //   85: ldc 155
    //   87: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_3
    //   92: aload_0
    //   93: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: ldc 95
    //   99: iconst_2
    //   100: aload_3
    //   101: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: new 157	java/net/URL
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 160	java/net/URL:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 164	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   118: checkcast 166	java/net/HttpURLConnection
    //   121: astore 4
    //   123: aload 4
    //   125: astore_3
    //   126: aload 4
    //   128: ldc 168
    //   130: invokevirtual 171	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   133: aload 4
    //   135: astore_3
    //   136: aload 4
    //   138: ldc 173
    //   140: ldc 175
    //   142: invokevirtual 179	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 4
    //   147: astore_3
    //   148: aload 4
    //   150: ldc 181
    //   152: ldc 183
    //   154: invokevirtual 179	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 4
    //   159: astore_3
    //   160: aload 4
    //   162: ldc 185
    //   164: ldc 187
    //   166: invokevirtual 179	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 4
    //   171: astore_3
    //   172: aload 4
    //   174: sipush 3000
    //   177: invokevirtual 191	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   180: aload 4
    //   182: astore_3
    //   183: aload 4
    //   185: sipush 3000
    //   188: invokevirtual 194	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   191: aload 4
    //   193: astore_3
    //   194: aload 4
    //   196: invokevirtual 198	java/net/HttpURLConnection:getResponseCode	()I
    //   199: sipush 200
    //   202: if_icmpne +75 -> 277
    //   205: aload 4
    //   207: astore_3
    //   208: aload 4
    //   210: invokevirtual 202	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   213: invokestatic 204	com/tencent/biz/pubaccount/NativeAd/util/ADBaseAppDownloadManager:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   216: astore_0
    //   217: aload 4
    //   219: astore_3
    //   220: aload_0
    //   221: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne +36 -> 260
    //   227: aload 4
    //   229: astore_3
    //   230: new 206	org/json/JSONObject
    //   233: dup
    //   234: aload_0
    //   235: invokespecial 207	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   238: astore_0
    //   239: aload 4
    //   241: astore_3
    //   242: ldc 209
    //   244: invokestatic 215	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   247: checkcast 209	com/tencent/mobileqq/kandian/ad/api/IRIJAdDownloadService
    //   250: aload_0
    //   251: invokeinterface 219 2 0
    //   256: astore_0
    //   257: goto +70 -> 327
    //   260: aload 4
    //   262: astore_3
    //   263: ldc 95
    //   265: iconst_1
    //   266: ldc 221
    //   268: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload 5
    //   273: astore_0
    //   274: goto +53 -> 327
    //   277: aload 4
    //   279: astore_3
    //   280: new 83	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   287: astore_0
    //   288: aload 4
    //   290: astore_3
    //   291: aload_0
    //   292: ldc 223
    //   294: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 4
    //   300: astore_3
    //   301: aload_0
    //   302: aload 4
    //   304: invokevirtual 198	java/net/HttpURLConnection:getResponseCode	()I
    //   307: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 4
    //   313: astore_3
    //   314: ldc 95
    //   316: iconst_1
    //   317: aload_0
    //   318: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 5
    //   326: astore_0
    //   327: aload_0
    //   328: astore_3
    //   329: aload 4
    //   331: ifnull +93 -> 424
    //   334: aload_0
    //   335: astore_3
    //   336: aload 4
    //   338: invokevirtual 226	java/net/HttpURLConnection:disconnect	()V
    //   341: aload_3
    //   342: areturn
    //   343: astore 5
    //   345: aload 4
    //   347: astore_0
    //   348: goto +13 -> 361
    //   351: astore_0
    //   352: aconst_null
    //   353: astore_3
    //   354: goto +73 -> 427
    //   357: astore 5
    //   359: aconst_null
    //   360: astore_0
    //   361: aload_0
    //   362: astore_3
    //   363: new 83	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   370: astore 4
    //   372: aload_0
    //   373: astore_3
    //   374: aload 4
    //   376: ldc 228
    //   378: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload_0
    //   383: astore_3
    //   384: aload 4
    //   386: aload 5
    //   388: invokevirtual 229	java/lang/Exception:toString	()Ljava/lang/String;
    //   391: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_0
    //   396: astore_3
    //   397: ldc 95
    //   399: iconst_1
    //   400: aload 4
    //   402: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload 7
    //   410: astore_3
    //   411: aload_0
    //   412: ifnull +12 -> 424
    //   415: aload 6
    //   417: astore_3
    //   418: aload_0
    //   419: astore 4
    //   421: goto -85 -> 336
    //   424: aload_3
    //   425: areturn
    //   426: astore_0
    //   427: aload_3
    //   428: ifnull +7 -> 435
    //   431: aload_3
    //   432: invokevirtual 226	java/net/HttpURLConnection:disconnect	()V
    //   435: goto +5 -> 440
    //   438: aload_0
    //   439: athrow
    //   440: goto -2 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	paramString	String
    //   0	443	1	paramInt	int
    //   4	11	2	bool	boolean
    //   33	399	3	localObject1	Object
    //   121	299	4	localObject2	Object
    //   12	313	5	localObject3	Object
    //   343	1	5	localException1	Exception
    //   357	30	5	localException2	Exception
    //   6	410	6	localObject4	Object
    //   9	400	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   126	133	343	java/lang/Exception
    //   136	145	343	java/lang/Exception
    //   148	157	343	java/lang/Exception
    //   160	169	343	java/lang/Exception
    //   172	180	343	java/lang/Exception
    //   183	191	343	java/lang/Exception
    //   194	205	343	java/lang/Exception
    //   208	217	343	java/lang/Exception
    //   220	227	343	java/lang/Exception
    //   230	239	343	java/lang/Exception
    //   242	257	343	java/lang/Exception
    //   263	271	343	java/lang/Exception
    //   280	288	343	java/lang/Exception
    //   291	298	343	java/lang/Exception
    //   301	311	343	java/lang/Exception
    //   314	324	343	java/lang/Exception
    //   107	123	351	finally
    //   107	123	357	java/lang/Exception
    //   126	133	426	finally
    //   136	145	426	finally
    //   148	157	426	finally
    //   160	169	426	finally
    //   172	180	426	finally
    //   183	191	426	finally
    //   194	205	426	finally
    //   208	217	426	finally
    //   220	227	426	finally
    //   230	239	426	finally
    //   242	257	426	finally
    //   263	271	426	finally
    //   280	288	426	finally
    //   291	298	426	finally
    //   301	311	426	finally
    //   314	324	426	finally
    //   363	372	426	finally
    //   374	382	426	finally
    //   384	395	426	finally
    //   397	408	426	finally
  }
  
  private void a(Activity paramActivity, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramActivity != null)
    {
      if (paramADVideoAppDownloadData == null) {
        return;
      }
      boolean bool = TextUtils.isEmpty(paramADVideoAppDownloadData.c);
      int i = 0;
      if ((bool) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.jdField_b_of_type_JavaLangString))) {
        paramADVideoAppDownloadData.c = a(paramADVideoAppDownloadData.jdField_b_of_type_JavaLangString, 0);
      }
      String str1 = paramADVideoAppDownloadData.d;
      String str2 = paramADVideoAppDownloadData.jdField_a_of_type_JavaLangString;
      String str3 = paramADVideoAppDownloadData.c;
      String str4 = paramADVideoAppDownloadData.e;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString(DownloadConstants.f, str1);
        localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, str2);
        localBundle.putString(DownloadConstants.j, str3);
        localBundle.putString(DownloadConstants.l, str4);
        localBundle.putInt(DownloadConstants.k, 2);
        localBundle.putInt(DownloadConstants.G, 0);
        localBundle.putBoolean(DownloadConstants.y, false);
        localBundle.putInt(DownloadConstants.J, 0);
        localBundle.putBoolean(DownloadConstants.z, true);
        localBundle.putBoolean(DownloadConstants.h, true);
        localBundle.putBoolean(DownloadConstants.s, false);
        localBundle.putBoolean(DownloadConstants.L, false);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("_");
        localStringBuilder.append(GlobalUtil.calcMD5AsString(str3));
        localBundle.putString("sendTime", localStringBuilder.toString());
        if (!TextUtils.isEmpty(paramADVideoAppDownloadData.f)) {
          localBundle.putString(DownloadConstants.i, paramADVideoAppDownloadData.f);
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startRealDownload pkg:");
          localStringBuilder.append(str1);
          localStringBuilder.append(", appid:");
          localStringBuilder.append(str2);
          localStringBuilder.append(", name:");
          localStringBuilder.append(str4);
          localStringBuilder.append(", url:");
          localStringBuilder.append(str3);
          QLog.d("ADBaseAppDownloadManager", 2, localStringBuilder.toString());
        }
        if (this.jdField_a_of_type_JavaUtilList.contains(paramADVideoAppDownloadData)) {
          this.jdField_a_of_type_JavaUtilList.remove(paramADVideoAppDownloadData);
        }
        this.jdField_a_of_type_JavaUtilList.add(paramADVideoAppDownloadData);
        DownloadProxy.a().a(paramActivity, localBundle, "biz_src_feeds_kandianads", null, 0);
        return;
      }
      if (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        i = paramADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
      } else if (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData != null) {
        i = paramADVideoAppDownloadData.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData.k;
      } else if (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData != null) {
        i = paramADVideoAppDownloadData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.c;
      }
      a(paramADVideoAppDownloadData, 6, i);
    }
  }
  
  public static boolean a(Context paramContext, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return b(paramContext, paramADVideoAppDownloadData);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString);
  }
  
  private static boolean a(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt)
  {
    do
    {
      do
      {
        try
        {
          if (paramADVideoAppDownloadData.jdField_a_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(paramADVideoAppDownloadData.i)) {
              continue;
            }
            if (!TextUtils.isEmpty(paramADVideoAppDownloadData.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData.Q))
            {
              continue;
              if (TextUtils.isEmpty(paramADVideoAppDownloadData.i)) {
                paramADVideoAppDownloadData = paramADVideoAppDownloadData.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData.Q;
              } else {
                paramADVideoAppDownloadData = paramADVideoAppDownloadData.i;
              }
              boolean bool = new File(paramADVideoAppDownloadData).exists();
              if (bool) {
                return true;
              }
            }
          }
          return false;
        }
        catch (Exception paramADVideoAppDownloadData)
        {
          return false;
        }
      } while (paramInt == 3);
    } while (paramInt != 4);
    return false;
  }
  
  private static boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = DownloadManagerV2.a().b(paramString);
    if (paramString == null) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString.l)) {
      paramString = paramString.l;
    } else {
      paramString = "";
    }
    bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (new File(paramString).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b()
  {
    DownloadManagerV2.a().b(this);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private static boolean b(Context paramContext, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if ((paramContext != null) && (paramADVideoAppDownloadData != null) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.d)) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.jdField_a_of_type_JavaLangString)))
    {
      if (paramADVideoAppDownloadData.jdField_a_of_type_Boolean) {
        return a(paramADVideoAppDownloadData, paramADVideoAppDownloadData.jdField_a_of_type_Int);
      }
      if (TextUtils.isEmpty(paramADVideoAppDownloadData.c)) {
        return b(paramContext, paramADVideoAppDownloadData.d);
      }
      return a(paramADVideoAppDownloadData.c);
    }
    return false;
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      DownloadInfo localDownloadInfo = DownloadManagerV2.a().c(paramString);
      if (localDownloadInfo == null) {
        return false;
      }
      if (!TextUtils.isEmpty(localDownloadInfo.l)) {
        paramContext = localDownloadInfo.l;
      } else {
        paramContext = "";
      }
      paramString = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        paramString = paramContext;
        if (!TextUtils.isEmpty(localDownloadInfo.d))
        {
          localDownloadInfo = DownloadManagerV2.a().b(localDownloadInfo.d);
          paramString = paramContext;
          if (localDownloadInfo != null) {
            paramString = localDownloadInfo.l;
          }
        }
      }
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        bool1 = bool2;
        if (new File(paramString).exists()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void e(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams == null) {
      paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams = a(paramADVideoAppDownloadData);
    }
    WadlProxyServiceUtil.a().b(paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramADVideoAppDownloadData)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramADVideoAppDownloadData);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramADVideoAppDownloadData);
  }
  
  protected WadlParams a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    WadlParams localWadlParams = new WadlParams(paramADVideoAppDownloadData.jdField_a_of_type_JavaLangString, paramADVideoAppDownloadData.d);
    localWadlParams.c = 7;
    localWadlParams.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramADVideoAppDownloadData.g);
    localStringBuilder.append("@");
    localStringBuilder.append(paramADVideoAppDownloadData.h);
    localWadlParams.n = localStringBuilder.toString();
    localWadlParams.e = paramADVideoAppDownloadData.c;
    localWadlParams.j = paramADVideoAppDownloadData.e;
    localWadlParams.p = "biz_src_feeds_kandianads";
    localWadlParams.l = "qq_vas_game";
    return localWadlParams;
  }
  
  public void a()
  {
    b();
    WadlProxyServiceUtil.a().b(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisterWadlServiceCallBack ：");
    localStringBuilder.append(this);
    QLog.d("ADBaseAppDownloadManager", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(AdDownloadCallback paramAdDownloadCallback)
  {
    if (paramAdDownloadCallback != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAdDownloadCallback);
    }
  }
  
  public void a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams == null) {
      paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams = a(paramADVideoAppDownloadData);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramADVideoAppDownloadData))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.add(paramADVideoAppDownloadData);
    }
    WadlProxyServiceUtil.a().a(localArrayList);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramADVideoAppDownloadData)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramADVideoAppDownloadData);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramADVideoAppDownloadData);
  }
  
  protected void a(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownload ");
      ((StringBuilder)localObject).append(paramADVideoAppDownloadData.d);
      ((StringBuilder)localObject).append(" progress ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ADBaseAppDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    paramADVideoAppDownloadData.jdField_a_of_type_Int = 3;
    DownloadManagerV2.a().a(this);
    Object localObject = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Activity)((SoftReference)localObject).get();
    }
    a((Activity)localObject, paramADVideoAppDownloadData);
  }
  
  protected void a(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ADBaseAppDownloadManager", "updateUIState error : empty progressCallbacks");
    }
    ThreadManager.getUIHandler().post(new ADBaseAppDownloadManager.1(this, paramADVideoAppDownloadData, paramInt1, paramInt2));
  }
  
  public void a(WadlResult paramWadlResult)
  {
    if (paramWadlResult != null)
    {
      if (paramWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onWadlTaskStatusChanged，wadlResult.taskStatus=");
        localStringBuilder.append(paramWadlResult.jdField_b_of_type_Int);
        QLog.d("ADBaseAppDownloadManager", 2, localStringBuilder.toString());
      }
      if (4 == paramWadlResult.jdField_b_of_type_Int)
      {
        a(paramWadlResult, 3);
        return;
      }
      if (6 == paramWadlResult.jdField_b_of_type_Int)
      {
        a(paramWadlResult, 5);
        return;
      }
      if (5 == paramWadlResult.jdField_b_of_type_Int)
      {
        a(paramWadlResult, 4);
        return;
      }
      if ((9 != paramWadlResult.jdField_b_of_type_Int) && (10 != paramWadlResult.jdField_b_of_type_Int))
      {
        if (7 == paramWadlResult.jdField_b_of_type_Int) {
          a(paramWadlResult, 6);
        }
        return;
      }
      a(paramWadlResult, 1);
    }
  }
  
  protected void a(WadlResult paramWadlResult, int paramInt)
  {
    try
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ADVideoAppDownloadData)((Iterator)localObject1).next();
        if ((((ADVideoAppDownloadData)localObject2).jdField_a_of_type_JavaLangString != null) && (((ADVideoAppDownloadData)localObject2).d != null) && (((ADVideoAppDownloadData)localObject2).jdField_a_of_type_JavaLangString.equals(paramWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.jdField_a_of_type_JavaLangString)) && (((ADVideoAppDownloadData)localObject2).d.equals(paramWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.f)))
        {
          int i = a(paramWadlResult);
          int j = paramWadlResult.d;
          if (!TextUtils.isEmpty(paramWadlResult.jdField_b_of_type_JavaLangString)) {
            ((ADVideoAppDownloadData)localObject2).i = paramWadlResult.jdField_b_of_type_JavaLangString;
          }
          if (((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            ((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = i;
            ((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = j;
          }
          if (((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData != null)
          {
            ((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_b_of_type_Int = i;
            ((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.c = j;
          }
          if (((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData != null)
          {
            ((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData.l = i;
            ((ADVideoAppDownloadData)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizFastwebDataAdData.k = j;
          }
          a((ADVideoAppDownloadData)localObject2, paramInt, paramWadlResult.d);
          return;
        }
      }
    }
    catch (Exception paramWadlResult)
    {
      Object localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyState error ");
      ((StringBuilder)localObject2).append(paramWadlResult.getMessage());
      ((IRIJAdLogService)localObject1).d("ADBaseAppDownloadManager", ((StringBuilder)localObject2).toString());
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new ADBaseAppDownloadManager.2(this, paramDownloadInfo, paramInt));
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onQueryCallback ");
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        a((WadlResult)paramArrayList.next(), 8);
      }
      return;
    }
    paramArrayList = this.jdField_b_of_type_JavaUtilList.iterator();
    while (paramArrayList.hasNext()) {
      a(new WadlResult(((ADVideoAppDownloadData)paramArrayList.next()).jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams), 8);
    }
  }
  
  public boolean a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData != null) {
      ThreadManager.excute(new ADBaseAppDownloadManager.3(this, paramADVideoAppDownloadData), 128, null, true);
    }
    return false;
  }
  
  public void b(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if ((paramADVideoAppDownloadData.jdField_a_of_type_Boolean) && (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams != null))
    {
      WadlProxyServiceUtil.a().a(0, paramADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
      return;
    }
    c(paramADVideoAppDownloadData);
    paramADVideoAppDownloadData = paramADVideoAppDownloadData.c;
    if (TextUtils.isEmpty(paramADVideoAppDownloadData)) {
      return;
    }
    DownloadManagerV2.a().a(paramADVideoAppDownloadData);
  }
  
  public void b(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onQueryCallbackVia ");
    }
  }
  
  public void c(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if ((TextUtils.isEmpty(paramADVideoAppDownloadData.c)) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramADVideoAppDownloadData.b()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ADVideoAppDownloadData localADVideoAppDownloadData = (ADVideoAppDownloadData)localIterator.next();
        if ((localADVideoAppDownloadData.b()) && (!TextUtils.isEmpty(localADVideoAppDownloadData.c)) && (paramADVideoAppDownloadData.a(localADVideoAppDownloadData))) {
          paramADVideoAppDownloadData.c = localADVideoAppDownloadData.c;
        }
      }
    }
  }
  
  public void d(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData.jdField_a_of_type_Boolean)
    {
      if (paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams == null) {
        paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams = a(paramADVideoAppDownloadData);
      }
      WadlProxyServiceUtil.a().c(paramADVideoAppDownloadData.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams);
      return;
    }
    paramADVideoAppDownloadData = DownloadManagerV2.a().c(paramADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
    DownloadManagerV2.a().a(paramADVideoAppDownloadData);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("installSucceed ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("ADBaseAppDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new DownloadInfo();
    ((DownloadInfo)localObject).c = paramString1;
    ((DownloadInfo)localObject).e = paramString2;
    a((DownloadInfo)localObject, 1);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadCancel ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d("ADBaseAppDownloadManager", 2, localStringBuilder.toString());
    }
    a(paramDownloadInfo, 7);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onDownloadError ");
      paramString.append(paramDownloadInfo.e);
      QLog.d("ADBaseAppDownloadManager", 2, paramString.toString());
    }
    a(paramDownloadInfo, 6);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d("ADBaseAppDownloadManager", 2, localStringBuilder.toString());
    }
    a(paramDownloadInfo, 5);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadPause ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d("ADBaseAppDownloadManager", 2, localStringBuilder.toString());
    }
    a(paramDownloadInfo, 4);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadUpdate ");
      localStringBuilder.append(paramList.size());
      QLog.d("ADBaseAppDownloadManager", 2, localStringBuilder.toString());
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((DownloadInfo)paramList.next(), 3);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadWait ");
      localStringBuilder.append(paramDownloadInfo.e);
      QLog.d("ADBaseAppDownloadManager", 2, localStringBuilder.toString());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("packageReplaced ");
      paramString1.append(paramString2);
      QLog.d("ADBaseAppDownloadManager", 2, paramString1.toString());
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("uninstallSucceed ");
      paramString1.append(paramString2);
      QLog.d("ADBaseAppDownloadManager", 2, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */