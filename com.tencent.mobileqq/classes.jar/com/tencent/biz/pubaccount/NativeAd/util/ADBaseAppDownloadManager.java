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
  protected SoftReference<Activity> a;
  protected Handler b;
  protected List<ADVideoAppDownloadData> c = new CopyOnWriteArrayList();
  protected List<ADVideoAppDownloadData> d = new CopyOnWriteArrayList();
  protected Handler e = new Handler(Looper.getMainLooper());
  private ArrayList<AdDownloadCallback> f = new ArrayList();
  
  public ADBaseAppDownloadManager(Activity paramActivity)
  {
    this.a = new SoftReference(paramActivity);
    this.b = new Handler(ThreadManager.getSubThreadLooper());
    WadlProxyServiceUtil.a().a(this);
    DownloadManagerV2.a().a(this);
    paramActivity = new StringBuilder();
    paramActivity.append("registerWadlServiceCallBack ：");
    paramActivity.append(this);
    QLog.d("ADBaseAppDownloadManager", 1, paramActivity.toString());
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
    //   1: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   20: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +47 -> 70
    //   26: new 87	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: ldc 145
    //   37: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: aload_0
    //   43: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: ldc 147
    //   50: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: iload_1
    //   56: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 99
    //   62: iconst_2
    //   63: aload_3
    //   64: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +34 -> 107
    //   76: new 87	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   83: astore_3
    //   84: aload_3
    //   85: ldc 152
    //   87: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_3
    //   92: aload_0
    //   93: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: ldc 99
    //   99: iconst_2
    //   100: aload_3
    //   101: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: new 154	java/net/URL
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 157	java/net/URL:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 161	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   118: checkcast 163	java/net/HttpURLConnection
    //   121: astore 4
    //   123: aload 4
    //   125: astore_3
    //   126: aload 4
    //   128: ldc 165
    //   130: invokevirtual 168	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   133: aload 4
    //   135: astore_3
    //   136: aload 4
    //   138: ldc 170
    //   140: ldc 172
    //   142: invokevirtual 176	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 4
    //   147: astore_3
    //   148: aload 4
    //   150: ldc 178
    //   152: ldc 180
    //   154: invokevirtual 176	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 4
    //   159: astore_3
    //   160: aload 4
    //   162: ldc 182
    //   164: ldc 184
    //   166: invokevirtual 176	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 4
    //   171: astore_3
    //   172: aload 4
    //   174: sipush 3000
    //   177: invokevirtual 188	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   180: aload 4
    //   182: astore_3
    //   183: aload 4
    //   185: sipush 3000
    //   188: invokevirtual 191	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   191: aload 4
    //   193: astore_3
    //   194: aload 4
    //   196: invokevirtual 195	java/net/HttpURLConnection:getResponseCode	()I
    //   199: sipush 200
    //   202: if_icmpne +75 -> 277
    //   205: aload 4
    //   207: astore_3
    //   208: aload 4
    //   210: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   213: invokestatic 201	com/tencent/biz/pubaccount/NativeAd/util/ADBaseAppDownloadManager:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   216: astore_0
    //   217: aload 4
    //   219: astore_3
    //   220: aload_0
    //   221: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne +36 -> 260
    //   227: aload 4
    //   229: astore_3
    //   230: new 203	org/json/JSONObject
    //   233: dup
    //   234: aload_0
    //   235: invokespecial 204	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   238: astore_0
    //   239: aload 4
    //   241: astore_3
    //   242: ldc 206
    //   244: invokestatic 212	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   247: checkcast 206	com/tencent/mobileqq/kandian/ad/api/IRIJAdDownloadService
    //   250: aload_0
    //   251: invokeinterface 216 2 0
    //   256: astore_0
    //   257: goto +70 -> 327
    //   260: aload 4
    //   262: astore_3
    //   263: ldc 99
    //   265: iconst_1
    //   266: ldc 218
    //   268: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload 5
    //   273: astore_0
    //   274: goto +53 -> 327
    //   277: aload 4
    //   279: astore_3
    //   280: new 87	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   287: astore_0
    //   288: aload 4
    //   290: astore_3
    //   291: aload_0
    //   292: ldc 220
    //   294: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 4
    //   300: astore_3
    //   301: aload_0
    //   302: aload 4
    //   304: invokevirtual 195	java/net/HttpURLConnection:getResponseCode	()I
    //   307: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 4
    //   313: astore_3
    //   314: ldc 99
    //   316: iconst_1
    //   317: aload_0
    //   318: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 5
    //   326: astore_0
    //   327: aload_0
    //   328: astore_3
    //   329: aload 4
    //   331: ifnull +93 -> 424
    //   334: aload_0
    //   335: astore_3
    //   336: aload 4
    //   338: invokevirtual 223	java/net/HttpURLConnection:disconnect	()V
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
    //   363: new 87	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   370: astore 4
    //   372: aload_0
    //   373: astore_3
    //   374: aload 4
    //   376: ldc 225
    //   378: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload_0
    //   383: astore_3
    //   384: aload 4
    //   386: aload 5
    //   388: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   391: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_0
    //   396: astore_3
    //   397: ldc 99
    //   399: iconst_1
    //   400: aload 4
    //   402: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   432: invokevirtual 223	java/net/HttpURLConnection:disconnect	()V
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
      if ((bool) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.b))) {
        paramADVideoAppDownloadData.c = a(paramADVideoAppDownloadData.b, 0);
      }
      String str1 = paramADVideoAppDownloadData.d;
      String str2 = paramADVideoAppDownloadData.a;
      String str3 = paramADVideoAppDownloadData.c;
      String str4 = paramADVideoAppDownloadData.e;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString(DownloadConstants.f, str1);
        localBundle.putString(DownloadConstants.b, str2);
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
        if (!TextUtils.isEmpty(paramADVideoAppDownloadData.h)) {
          localBundle.putString(DownloadConstants.i, paramADVideoAppDownloadData.h);
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
        if (this.c.contains(paramADVideoAppDownloadData)) {
          this.c.remove(paramADVideoAppDownloadData);
        }
        this.c.add(paramADVideoAppDownloadData);
        DownloadProxy.a().a(paramActivity, localBundle, "biz_src_feeds_kandianads", null, 0);
        return;
      }
      if (paramADVideoAppDownloadData.k != null) {
        i = paramADVideoAppDownloadData.k.progress;
      } else if (paramADVideoAppDownloadData.o != null) {
        i = paramADVideoAppDownloadData.o.ao;
      } else if (paramADVideoAppDownloadData.p != null) {
        i = paramADVideoAppDownloadData.p.H;
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
    if (!TextUtils.isEmpty(paramString.q)) {
      paramString = paramString.q;
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
  
  public static int b(WadlResult paramWadlResult)
  {
    if (4 == paramWadlResult.d) {
      return 3;
    }
    if (6 == paramWadlResult.d) {
      return 5;
    }
    if (5 == paramWadlResult.d) {
      return 4;
    }
    if ((9 != paramWadlResult.d) && (10 != paramWadlResult.d))
    {
      if (7 == paramWadlResult.d) {
        return 6;
      }
      return 0;
    }
    return 1;
  }
  
  private void b()
  {
    DownloadManagerV2.a().b(this);
    this.e.removeCallbacksAndMessages(null);
    this.b.removeCallbacksAndMessages(null);
  }
  
  private static boolean b(Context paramContext, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if ((paramContext != null) && (paramADVideoAppDownloadData != null) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.d)) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.a)))
    {
      if (paramADVideoAppDownloadData.l) {
        return b(paramADVideoAppDownloadData, paramADVideoAppDownloadData.f);
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
      if (!TextUtils.isEmpty(localDownloadInfo.q)) {
        paramContext = localDownloadInfo.q;
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
            paramString = localDownloadInfo.q;
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
  
  private static boolean b(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt)
  {
    do
    {
      do
      {
        try
        {
          if (paramADVideoAppDownloadData.l)
          {
            if (!TextUtils.isEmpty(paramADVideoAppDownloadData.n)) {
              continue;
            }
            if (!TextUtils.isEmpty(paramADVideoAppDownloadData.o.aq))
            {
              continue;
              if (TextUtils.isEmpty(paramADVideoAppDownloadData.n)) {
                paramADVideoAppDownloadData = paramADVideoAppDownloadData.o.aq;
              } else {
                paramADVideoAppDownloadData = paramADVideoAppDownloadData.n;
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
  
  private void g(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData.m == null) {
      paramADVideoAppDownloadData.m = b(paramADVideoAppDownloadData);
    }
    WadlProxyServiceUtil.a().b(paramADVideoAppDownloadData.m);
    if (this.c.contains(paramADVideoAppDownloadData)) {
      this.c.remove(paramADVideoAppDownloadData);
    }
    this.c.add(paramADVideoAppDownloadData);
  }
  
  public void a()
  {
    b();
    WadlProxyServiceUtil.a().b(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisterWadlServiceCallBack ：");
    localStringBuilder.append(this);
    QLog.d("ADBaseAppDownloadManager", 1, localStringBuilder.toString());
    this.a = null;
    this.f.clear();
    this.d.clear();
    this.c.clear();
  }
  
  public void a(AdDownloadCallback paramAdDownloadCallback)
  {
    if (paramAdDownloadCallback != null) {
      this.f.add(paramAdDownloadCallback);
    }
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
    paramADVideoAppDownloadData.f = 3;
    DownloadManagerV2.a().a(this);
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Activity)((SoftReference)localObject).get();
    }
    a((Activity)localObject, paramADVideoAppDownloadData);
  }
  
  protected void a(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt1, int paramInt2)
  {
    if (this.f.size() == 0) {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ADBaseAppDownloadManager", "updateUIState error : empty progressCallbacks");
    }
    ThreadManager.getUIHandler().post(new ADBaseAppDownloadManager.1(this, paramADVideoAppDownloadData, paramInt1, paramInt2));
  }
  
  public void a(WadlResult paramWadlResult)
  {
    if (paramWadlResult != null)
    {
      if (paramWadlResult.a == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onWadlTaskStatusChanged，wadlResult.taskStatus=");
        localStringBuilder.append(paramWadlResult.d);
        QLog.d("ADBaseAppDownloadManager", 2, localStringBuilder.toString());
      }
      if (4 == paramWadlResult.d)
      {
        a(paramWadlResult, 3);
        return;
      }
      if (6 == paramWadlResult.d)
      {
        a(paramWadlResult, 5);
        return;
      }
      if (5 == paramWadlResult.d)
      {
        a(paramWadlResult, 4);
        return;
      }
      if ((9 != paramWadlResult.d) && (10 != paramWadlResult.d))
      {
        if (7 == paramWadlResult.d) {
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
      localObject1 = this.c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ADVideoAppDownloadData)((Iterator)localObject1).next();
        if ((((ADVideoAppDownloadData)localObject2).a != null) && (((ADVideoAppDownloadData)localObject2).d != null) && (((ADVideoAppDownloadData)localObject2).a.equals(paramWadlResult.a.e)) && (((ADVideoAppDownloadData)localObject2).d.equals(paramWadlResult.a.m)))
        {
          int i = b(paramWadlResult);
          int j = paramWadlResult.k;
          if (!TextUtils.isEmpty(paramWadlResult.g)) {
            ((ADVideoAppDownloadData)localObject2).n = paramWadlResult.g;
          }
          if (((ADVideoAppDownloadData)localObject2).k != null)
          {
            ((ADVideoAppDownloadData)localObject2).k.downloadState = i;
            ((ADVideoAppDownloadData)localObject2).k.progress = j;
          }
          if (((ADVideoAppDownloadData)localObject2).p != null)
          {
            ((ADVideoAppDownloadData)localObject2).p.G = i;
            ((ADVideoAppDownloadData)localObject2).p.H = j;
          }
          if (((ADVideoAppDownloadData)localObject2).o != null)
          {
            ((ADVideoAppDownloadData)localObject2).o.ap = i;
            ((ADVideoAppDownloadData)localObject2).o.ao = j;
          }
          a((ADVideoAppDownloadData)localObject2, paramInt, paramWadlResult.k);
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
    paramArrayList = this.d.iterator();
    while (paramArrayList.hasNext()) {
      a(new WadlResult(((ADVideoAppDownloadData)paramArrayList.next()).m), 8);
    }
  }
  
  public boolean a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData != null) {
      ThreadManager.excute(new ADBaseAppDownloadManager.3(this, paramADVideoAppDownloadData), 128, null, true);
    }
    return false;
  }
  
  protected WadlParams b(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    WadlParams localWadlParams = new WadlParams(paramADVideoAppDownloadData.a, paramADVideoAppDownloadData.d);
    localWadlParams.d = 7;
    localWadlParams.c = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramADVideoAppDownloadData.i);
    localStringBuilder.append("@");
    localStringBuilder.append(paramADVideoAppDownloadData.j);
    localWadlParams.y = localStringBuilder.toString();
    localWadlParams.k = paramADVideoAppDownloadData.c;
    localWadlParams.u = paramADVideoAppDownloadData.e;
    localWadlParams.A = "biz_src_feeds_kandianads";
    localWadlParams.w = "qq_vas_game";
    return localWadlParams;
  }
  
  public void b(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onQueryCallbackVia ");
    }
  }
  
  public void c(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData.m == null) {
      paramADVideoAppDownloadData.m = b(paramADVideoAppDownloadData);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramADVideoAppDownloadData.a);
    if (!this.d.contains(paramADVideoAppDownloadData))
    {
      this.d.clear();
      this.d.add(paramADVideoAppDownloadData);
    }
    WadlProxyServiceUtil.a().a(localArrayList);
    if (this.c.contains(paramADVideoAppDownloadData)) {
      this.c.remove(paramADVideoAppDownloadData);
    }
    this.c.add(paramADVideoAppDownloadData);
  }
  
  public void d(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if ((paramADVideoAppDownloadData.l) && (paramADVideoAppDownloadData.m != null))
    {
      WadlProxyServiceUtil.a().a(0, paramADVideoAppDownloadData.a);
      return;
    }
    e(paramADVideoAppDownloadData);
    paramADVideoAppDownloadData = paramADVideoAppDownloadData.c;
    if (TextUtils.isEmpty(paramADVideoAppDownloadData)) {
      return;
    }
    DownloadManagerV2.a().e(paramADVideoAppDownloadData);
  }
  
  public void e(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if ((TextUtils.isEmpty(paramADVideoAppDownloadData.c)) && (this.c.size() > 0) && (paramADVideoAppDownloadData.b()))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        ADVideoAppDownloadData localADVideoAppDownloadData = (ADVideoAppDownloadData)localIterator.next();
        if ((localADVideoAppDownloadData.b()) && (!TextUtils.isEmpty(localADVideoAppDownloadData.c)) && (paramADVideoAppDownloadData.a(localADVideoAppDownloadData))) {
          paramADVideoAppDownloadData.c = localADVideoAppDownloadData.c;
        }
      }
    }
  }
  
  public void f(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData.l)
    {
      if (paramADVideoAppDownloadData.m == null) {
        paramADVideoAppDownloadData.m = b(paramADVideoAppDownloadData);
      }
      WadlProxyServiceUtil.a().c(paramADVideoAppDownloadData.m);
      return;
    }
    paramADVideoAppDownloadData = DownloadManagerV2.a().c(paramADVideoAppDownloadData.a);
    DownloadManagerV2.a().d(paramADVideoAppDownloadData);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager
 * JD-Core Version:    0.7.0.1
 */