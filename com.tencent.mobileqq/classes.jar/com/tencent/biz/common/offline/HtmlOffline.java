package com.tencent.biz.common.offline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.util.DefaultThreadManager;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.offline.util.MyLog;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.QQThreadManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HtmlOffline
{
  protected static final String[] a = { "config.json", "verify.json", "verify.signature" };
  protected static final String[] b = { "0", "1" };
  public static int c = 0;
  public static IThreadManager d = new DefaultThreadManager();
  public static IOfflineDownloader e = new OfflineDownloader();
  public static ILog f = new MyLog();
  public static ConcurrentHashMap<String, String> g = new ConcurrentHashMap();
  public static AsyncBack h = new HtmlOffline.3();
  public static boolean i = false;
  private static Context j;
  
  public static String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localObject = e(OfflineEnvHelper.b());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localStringBuffer.append((String)localObject);
      }
    }
    if (j == null) {
      j = BaseApplication.getContext().getApplicationContext();
    }
    Object localObject = e(OfflineEnvHelper.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (localStringBuffer.length() > 0) {
        localStringBuffer.append(",");
      }
      localStringBuffer.append((String)localObject);
    }
    if (f.a())
    {
      localObject = f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalOfflineVersions:");
      localStringBuilder.append(localStringBuffer.toString());
      ((ILog)localObject).b("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      if (paramString1.contains("#"))
      {
        Object localObject2 = paramString1.split("\\#");
        localObject1 = localObject2[0];
        int m = localObject2.length;
        int k = 1;
        paramString1 = "";
        StringBuilder localStringBuilder;
        while (k < m)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append("#");
          localStringBuilder.append(localObject2[k]);
          paramString1 = localStringBuilder.toString();
          k += 1;
        }
        if (((String)localObject1).contains("?"))
        {
          localObject2 = new StringBuilder();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("?");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("&");
          ((StringBuilder)localObject2).append(((String)localObject1).replace("?", localStringBuilder.toString()));
          ((StringBuilder)localObject2).append(paramString1);
          return ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(paramString1);
        return ((StringBuilder)localObject2).toString();
      }
      if (paramString1.contains("?"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("?");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("&");
        return paramString1.replace("?", ((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("?");
      ((StringBuilder)localObject1).append(paramString2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static JSONObject a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("/");
      localStringBuilder.append("config.json");
      paramString = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("html5/");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    try
    {
      paramString = paramContext.getAssets().open(paramString);
      paramContext = Util.a(paramString);
      try
      {
        paramString.close();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
      try
      {
        paramContext = new JSONObject(paramContext);
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        if (f.a()) {
          f.a("HtmlCheckUpdate", 2, "error:getAssetConfig");
        }
      }
      return null;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  public static void a(Context paramContext)
  {
    j = paramContext;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expire_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str = OfflineEnvHelper.c(paramString1);
      if (TextUtils.isEmpty(str))
      {
        paramAsyncBack.loaded(null, 3);
        return;
      }
      JSONObject localJSONObject = c(paramString1);
      if (localJSONObject != null)
      {
        l1 = 30L;
        try
        {
          l2 = localJSONObject.getLong("frequency");
          l1 = l2;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        long l2 = (System.currentTimeMillis() - b(paramContext, paramString1)) / 60000L;
        if (f.a())
        {
          localObject = f;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkUpdate check freq:");
          localStringBuilder.append(l1);
          localStringBuilder.append(", time:");
          localStringBuilder.append(l2);
          ((ILog)localObject).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
        }
        if (l2 < l1)
        {
          paramAsyncBack.loaded(null, 5);
          return;
        }
      }
      if (BidDownloader.c(paramString1))
      {
        paramAsyncBack.loaded(null, 7);
        return;
      }
      BidDownloader.a(paramString1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(".zip");
      str = ((StringBuilder)localObject).toString();
      long l1 = System.currentTimeMillis();
      localObject = new HashMap();
      ((HashMap)localObject).put("Accept-Encoding", "gzip");
      d.c(new HtmlOffline.5(paramContext, paramString2, paramString1, str, l1, paramAsyncBack, (HashMap)localObject));
      return;
    }
    paramAsyncBack.loaded(null, 1);
  }
  
  public static void a(ILog paramILog)
  {
    f = paramILog;
  }
  
  public static void a(IOfflineDownloader paramIOfflineDownloader)
  {
    e = paramIOfflineDownloader;
  }
  
  public static void a(IThreadManager paramIThreadManager)
  {
    d = paramIThreadManager;
  }
  
  protected static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, paramInt2, "lixian_update", "");
  }
  
  public static void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      k = Integer.valueOf(paramString1).intValue();
    }
    catch (NumberFormatException paramString1)
    {
      int k;
      label20:
      Object localObject;
      StringBuilder localStringBuilder;
      break label20;
    }
    k = -1;
    if (paramString3 == null) {
      paramString1 = "";
    } else {
      paramString1 = paramString3;
    }
    try
    {
      if (j == null) {
        j = BaseApplication.getContext();
      }
      paramString3 = j.getPackageManager().getPackageInfo(j.getPackageName(), 0).versionName;
    }
    catch (Exception paramString3)
    {
      paramString3.printStackTrace();
    }
    catch (PackageManager.NameNotFoundException paramString3)
    {
      paramString3.printStackTrace();
    }
    paramString3 = "";
    if ((paramInt2 <= 0) && (j != null)) {
      paramInt2 = NetworkUtil.getNetWorkType();
    }
    if (i)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt2);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramString3, "mp_msg_sys_14", paramString2, k, paramInt1, (String)localObject, "3", localStringBuilder.toString(), paramString1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDownTime qver=");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", mainAction=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", bid=");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", code=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", time=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", netType=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", ex5=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.i("HtmlCheckUpdate", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, paramAppRuntime, true, h);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    d.a(new HtmlOffline.2(paramString, paramAppRuntime, paramAsyncBack));
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean)
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramString);
    paramString = new HashMap(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = c(str);
      if (localObject2 != null)
      {
        localObject2 = ((JSONObject)localObject2).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString.put(str, localObject2);
        }
      }
      else
      {
        paramString.put(str, "0");
      }
    }
    a(paramAppRuntime, paramString, paramAsyncBack, paramBoolean, false, false);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean, int paramInt)
  {
    a(paramString, paramAppRuntime, paramAsyncBack, paramBoolean, 5, false);
  }
  
  @Deprecated
  public static void a(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    b(paramString, paramAppRuntime, paramAsyncBack, true, paramInt, paramBoolean2);
  }
  
  protected static void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, AsyncBack paramAsyncBack)
  {
    if (f.a())
    {
      localObject = f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->offline:checkUp,url=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",callback=");
      localStringBuilder.append(paramAsyncBack);
      ((ILog)localObject).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    if (paramAsyncBack == null) {
      return;
    }
    Object localObject = Uri.parse(paramString).getQueryParameter("_bid");
    int m = AuthorizeConfig.a(true).d(paramString);
    int k = m;
    if (m == 0) {
      k = 5;
    }
    a((String)localObject, paramAppRuntime, paramAsyncBack, paramBoolean, k);
  }
  
  public static void a(ArrayList<String> paramArrayList, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if ((paramAppRuntime != null) && (paramArrayList.size() != 0))
    {
      b(paramArrayList, paramAppRuntime, paramAsyncBack, paramBoolean1, paramBoolean2);
      return;
    }
    paramAsyncBack.loaded("{\"r\":-1}", -1);
  }
  
  /* Error */
  public static void a(AppRuntime paramAppRuntime, HashMap<String, String> paramHashMap, AsyncBack paramAsyncBack, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: invokestatic 379	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 145
    //   8: iconst_2
    //   9: ldc_w 485
    //   12: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: new 489	mqq/app/NewIntent
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 495	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   23: invokevirtual 498	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   26: ldc_w 500
    //   29: invokespecial 503	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   32: astore 9
    //   34: aload 9
    //   36: ldc_w 505
    //   39: ldc_w 507
    //   42: invokevirtual 511	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   45: pop
    //   46: new 513	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody
    //   49: dup
    //   50: invokespecial 514	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:<init>	()V
    //   53: astore 10
    //   55: aload 10
    //   57: getfield 518	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: iconst_3
    //   61: invokevirtual 523	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   64: aload 10
    //   66: getfield 526	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:uint32_platform	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   69: iconst_3
    //   70: invokevirtual 523	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   73: aload_1
    //   74: ifnonnull +20 -> 94
    //   77: ldc 145
    //   79: iconst_1
    //   80: ldc_w 528
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 532	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokestatic 534	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: return
    //   94: aload_1
    //   95: ifnull +78 -> 173
    //   98: aload_1
    //   99: invokevirtual 535	java/util/HashMap:size	()I
    //   102: ifle +71 -> 173
    //   105: ldc 145
    //   107: iconst_1
    //   108: ldc_w 537
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: ldc_w 539
    //   120: aastore
    //   121: invokestatic 532	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: invokestatic 379	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +43 -> 173
    //   133: new 134	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   140: astore 8
    //   142: aload 8
    //   144: ldc_w 541
    //   147: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 8
    //   153: aload_1
    //   154: invokevirtual 542	java/util/HashMap:toString	()Ljava/lang/String;
    //   157: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc_w 544
    //   164: iconst_2
    //   165: aload 8
    //   167: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload 10
    //   175: getfield 548	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:str_qver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   178: ldc_w 539
    //   181: invokevirtual 552	java/lang/String:getBytes	()[B
    //   184: invokestatic 558	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   187: invokevirtual 563	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   190: aload 10
    //   192: getfield 566	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:str_osrelease	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   195: getstatic 571	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   198: invokevirtual 552	java/lang/String:getBytes	()[B
    //   201: invokestatic 558	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   204: invokevirtual 563	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   207: invokestatic 358	com/tencent/mobileqq/utils/NetworkUtil:getNetWorkType	()I
    //   210: istore 6
    //   212: aload 10
    //   214: getfield 575	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:int32_network	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   217: iload 6
    //   219: invokevirtual 578	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   222: aload 10
    //   224: getfield 581	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:str_from	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   227: ldc_w 583
    //   230: invokevirtual 552	java/lang/String:getBytes	()[B
    //   233: invokestatic 558	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: invokevirtual 563	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   239: aload_1
    //   240: invokevirtual 587	java/util/HashMap:keySet	()Ljava/util/Set;
    //   243: invokeinterface 590 1 0
    //   248: astore 11
    //   250: aload 11
    //   252: invokeinterface 428 1 0
    //   257: ifeq +126 -> 383
    //   260: aload 11
    //   262: invokeinterface 432 1 0
    //   267: checkcast 28	java/lang/String
    //   270: astore 8
    //   272: aload_1
    //   273: aload 8
    //   275: invokevirtual 594	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   278: checkcast 28	java/lang/String
    //   281: astore 12
    //   283: aload 8
    //   285: invokestatic 330	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   288: invokevirtual 333	java/lang/Integer:intValue	()I
    //   291: istore 6
    //   293: aload 12
    //   295: invokestatic 330	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   298: invokevirtual 333	java/lang/Integer:intValue	()I
    //   301: istore 7
    //   303: goto +27 -> 330
    //   306: astore 8
    //   308: goto +14 -> 322
    //   311: iconst_0
    //   312: istore 6
    //   314: goto +13 -> 327
    //   317: astore 8
    //   319: iconst_0
    //   320: istore 6
    //   322: aload 8
    //   324: invokevirtual 595	java/lang/NumberFormatException:printStackTrace	()V
    //   327: iconst_0
    //   328: istore 7
    //   330: iload 6
    //   332: ifne +6 -> 338
    //   335: goto -85 -> 250
    //   338: new 597	tencent/im/sso/offlinpkg/OfflinePkg$BidPkg
    //   341: dup
    //   342: invokespecial 598	tencent/im/sso/offlinpkg/OfflinePkg$BidPkg:<init>	()V
    //   345: astore 8
    //   347: aload 8
    //   349: getfield 601	tencent/im/sso/offlinpkg/OfflinePkg$BidPkg:uint32_bid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   352: iload 6
    //   354: invokevirtual 523	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   357: aload 8
    //   359: getfield 605	tencent/im/sso/offlinpkg/OfflinePkg$BidPkg:uint32_pkg_id	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   362: iload 7
    //   364: invokestatic 608	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: invokevirtual 613	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   370: aload 10
    //   372: getfield 617	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:st_bid_pkg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   375: aload 8
    //   377: invokevirtual 622	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   380: goto -130 -> 250
    //   383: aload 9
    //   385: ldc_w 624
    //   388: aload 10
    //   390: invokevirtual 627	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:toByteArray	()[B
    //   393: invokevirtual 630	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   396: pop
    //   397: aload 9
    //   399: new 632	com/tencent/biz/common/offline/HtmlOffline$HtmlOfflineObserver
    //   402: dup
    //   403: aload_2
    //   404: aload_0
    //   405: iload_3
    //   406: iload 4
    //   408: iload 5
    //   410: aload 9
    //   412: invokespecial 635	com/tencent/biz/common/offline/HtmlOffline$HtmlOfflineObserver:<init>	(Lcom/tencent/biz/common/offline/AsyncBack;Lmqq/app/AppRuntime;ZZZLmqq/app/NewIntent;)V
    //   415: invokevirtual 639	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   418: aload_0
    //   419: aload 9
    //   421: invokevirtual 643	mqq/app/AppRuntime:startServlet	(Lmqq/app/NewIntent;)V
    //   424: return
    //   425: astore_0
    //   426: invokestatic 379	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +13 -> 442
    //   432: ldc 145
    //   434: iconst_2
    //   435: ldc_w 645
    //   438: aload_0
    //   439: invokestatic 648	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: return
    //   443: astore 8
    //   445: goto -134 -> 311
    //   448: astore 8
    //   450: goto -123 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramAppRuntime	AppRuntime
    //   0	453	1	paramHashMap	HashMap<String, String>
    //   0	453	2	paramAsyncBack	AsyncBack
    //   0	453	3	paramBoolean1	boolean
    //   0	453	4	paramBoolean2	boolean
    //   0	453	5	paramBoolean3	boolean
    //   210	143	6	k	int
    //   301	62	7	m	int
    //   140	144	8	localObject	Object
    //   306	1	8	localNumberFormatException1	NumberFormatException
    //   317	6	8	localNumberFormatException2	NumberFormatException
    //   345	31	8	localBidPkg	tencent.im.sso.offlinpkg.OfflinePkg.BidPkg
    //   443	1	8	localException1	Exception
    //   448	1	8	localException2	Exception
    //   32	388	9	localNewIntent	mqq.app.NewIntent
    //   53	336	10	localReqBody	tencent.im.sso.offlinpkg.OfflinePkg.ReqBody
    //   248	13	11	localIterator	Iterator
    //   281	13	12	str	String
    // Exception table:
    //   from	to	target	type
    //   293	303	306	java/lang/NumberFormatException
    //   283	293	317	java/lang/NumberFormatException
    //   383	397	425	java/lang/Exception
    //   283	293	443	java/lang/Exception
    //   293	303	448	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    if (f.a())
    {
      localObject = f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->offline:transToLocalUrl,url:");
      localStringBuilder.append(paramString);
      ((ILog)localObject).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,business id is null!");
      }
      return false;
    }
    if (paramContext == null)
    {
      a((String)localObject, 3, 0L, 4, "lixian_cover", "0");
      BidDownloader.a(0, (String)localObject, 3, 0, "lixian_cover", 0);
      return false;
    }
    if (OfflineEnvHelper.b((String)localObject) == null)
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,initEnv fail!");
      }
      a((String)localObject, 2, 0L, NetworkUtil.getNetWorkType(), "lixian_cover", "0");
      BidDownloader.a(0, (String)localObject, 2, 0, "lixian_cover", 0);
      return false;
    }
    if (Arrays.asList(b).contains(localObject))
    {
      a((String)localObject, 4, 0L, NetworkUtil.getNetWorkType(), "lixian_cover", "0");
      BidDownloader.a(0, (String)localObject, 4, 0, "lixian_cover", 0);
      return false;
    }
    localObject = d;
    if (localObject == null)
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,threadManager is null");
      }
      return false;
    }
    ((IThreadManager)localObject).b(new HtmlOffline.1(paramContext, paramString, paramAsyncCallBack));
    return true;
  }
  
  /* Error */
  protected static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: invokevirtual 186	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokevirtual 192	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: new 685	java/io/FileOutputStream
    //   18: dup
    //   19: new 687	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 688	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 691	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: sipush 4096
    //   34: newarray byte
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 695	java/io/InputStream:read	([B)I
    //   42: istore_3
    //   43: iload_3
    //   44: iconst_m1
    //   45: if_icmpne +21 -> 66
    //   48: aload_2
    //   49: invokevirtual 698	java/io/FileOutputStream:flush	()V
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 202	java/io/InputStream:close	()V
    //   60: aload_2
    //   61: invokevirtual 699	java/io/FileOutputStream:close	()V
    //   64: iconst_1
    //   65: ireturn
    //   66: aload_2
    //   67: aload_1
    //   68: iconst_0
    //   69: iload_3
    //   70: invokevirtual 703	java/io/FileOutputStream:write	([BII)V
    //   73: goto -36 -> 37
    //   76: astore_1
    //   77: goto +70 -> 147
    //   80: astore_1
    //   81: goto +13 -> 94
    //   84: astore_1
    //   85: aload 5
    //   87: astore_2
    //   88: goto +59 -> 147
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_0
    //   95: astore 4
    //   97: aload_2
    //   98: astore_0
    //   99: goto +15 -> 114
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload 5
    //   107: astore_2
    //   108: goto +39 -> 147
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_1
    //   115: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   118: aload 4
    //   120: ifnull +11 -> 131
    //   123: aload 4
    //   125: invokevirtual 202	java/io/InputStream:close	()V
    //   128: goto +3 -> 131
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 699	java/io/FileOutputStream:close	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_1
    //   142: aload_0
    //   143: astore_2
    //   144: aload 4
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +10 -> 158
    //   151: aload_0
    //   152: invokevirtual 202	java/io/InputStream:close	()V
    //   155: goto +3 -> 158
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 699	java/io/FileOutputStream:close	()V
    //   166: goto +5 -> 171
    //   169: aload_1
    //   170: athrow
    //   171: goto -2 -> 169
    //   174: astore_0
    //   175: goto -115 -> 60
    //   178: astore_0
    //   179: goto -115 -> 64
    //   182: astore_1
    //   183: goto -52 -> 131
    //   186: astore_0
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_0
    //   190: goto -32 -> 158
    //   193: astore_0
    //   194: goto -28 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramString1	String
    //   0	197	2	paramString2	String
    //   42	28	3	k	int
    //   4	141	4	localContext	Context
    //   1	105	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	37	76	finally
    //   37	43	76	finally
    //   48	52	76	finally
    //   66	73	76	finally
    //   31	37	80	java/io/IOException
    //   37	43	80	java/io/IOException
    //   48	52	80	java/io/IOException
    //   66	73	80	java/io/IOException
    //   15	31	84	finally
    //   15	31	91	java/io/IOException
    //   6	15	102	finally
    //   6	15	111	java/io/IOException
    //   114	118	141	finally
    //   56	60	174	java/io/IOException
    //   60	64	178	java/io/IOException
    //   123	128	182	java/io/IOException
    //   135	139	186	java/io/IOException
    //   151	155	189	java/io/IOException
    //   162	166	193	java/io/IOException
  }
  
  protected static boolean a(String paramString)
  {
    String str1 = OfflineEnvHelper.c(paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".zip");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append("tmp_c_");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(File.separator);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append(".zip");
    localObject3 = ((StringBuilder)localObject3).toString();
    if (!a((String)localObject2, (String)localObject1, (String)localObject3))
    {
      QLog.w("HtmlCheckUpdate", 1, "combine renameToDest businessId.zip failed");
      return false;
    }
    String str2 = OfflineEnvHelper.b(paramString);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(str2);
    ((StringBuilder)localObject4).append(paramString);
    str2 = ((StringBuilder)localObject4).toString();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(str2);
    ((StringBuilder)localObject4).append("/b.zip");
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append((String)localObject2);
    ((StringBuilder)localObject5).append("/b.zip");
    localObject5 = ((StringBuilder)localObject5).toString();
    if (!a((String)localObject2, (String)localObject4, (String)localObject5))
    {
      QLog.w("HtmlCheckUpdate", 1, "combine renameToDest b.zip failed");
      return false;
    }
    Object localObject6 = new File((String)localObject5);
    if (f.a())
    {
      ILog localILog = f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("combine zip");
      localStringBuilder.append(paramString);
      localILog.a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    paramString = new File((String)localObject3);
    if ((((File)localObject6).exists()) && (paramString.exists())) {}
    try
    {
      if (paramString.isDirectory())
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("FXXX! This is a wrong patch file! ");
        ((StringBuilder)localObject6).append((String)localObject3);
        QLog.e("HtmlCheckUpdate", 1, ((StringBuilder)localObject6).toString());
        paramString.delete();
        return false;
      }
      bool1 = false;
    }
    catch (Throwable paramString)
    {
      boolean bool1;
      boolean bool2;
      label468:
      label470:
      break label468;
    }
    try
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject2);
      paramString.append("/b.zip");
      bool2 = BspatchUtil.a(paramString.toString(), (String)localObject3, (String)localObject3);
      bool1 = bool2;
    }
    catch (Throwable paramString)
    {
      break label470;
    }
    bool1 = false;
    paramString = new StringBuilder();
    paramString.append(str2);
    paramString.append("/");
    a(paramString.toString(), (String)localObject5, (String)localObject4);
    a(str1, (String)localObject3, (String)localObject1);
    Util.a((String)localObject2);
    return bool1;
  }
  
  public static boolean a(String paramString1, Context paramContext, String paramString2, AsyncCallBack paramAsyncCallBack)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?_bid=");
    localStringBuilder.append(paramString2);
    return a(paramContext, localStringBuilder.toString(), paramAsyncCallBack);
  }
  
  static boolean a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    paramString1 = new File(paramString2);
    if (!paramString1.exists())
    {
      QLog.d("HtmlCheckUpdate", 1, new Object[] { paramString2, "not exist" });
      return false;
    }
    boolean bool = paramString1.renameTo(new File(paramString3));
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, new Object[] { "origin:", paramString2, " dest:", paramString3, " result: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private static boolean a(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, int paramInt)
  {
    if (paramAsyncBack == null)
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId, callback is null!");
      }
      return true;
    }
    if (OfflineEnvHelper.b(paramString) == null)
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,no sd card!");
      }
      paramAsyncBack.loaded(null, 3);
      return true;
    }
    if (Arrays.asList(b).contains(paramString))
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,do not update");
      }
      return true;
    }
    if ((paramInt <= 60) && (paramInt >= 0))
    {
      if ((paramAppRuntime != null) && (paramAppRuntime.isLogin())) {
        return false;
      }
      QLog.w("HtmlCheckUpdate", 1, "app == null or user not login.");
      return true;
    }
    if (f.a()) {
      f.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,delayed too long.");
    }
    return true;
  }
  
  protected static long b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_up_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  @SuppressLint({"NewApi"})
  public static HtmlOffline.MyWebResourceResponse b(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http")))
    {
      Object localObject1 = OfflineEnvHelper.b(paramString1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramString1);
      paramString1 = ((StringBuilder)localObject2).toString();
      paramString2 = g(paramString2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(paramString2);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!new File((String)localObject1).exists())
      {
        if (f.b())
        {
          paramString1 = f;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getResponse local file not exists :");
          ((StringBuilder)localObject1).append(paramString2);
          paramString1.a("HtmlCheckUpdate", 4, ((StringBuilder)localObject1).toString());
        }
        return null;
      }
      if (paramString2.contains(".css")) {
        paramString1 = "text/css";
      } else if (paramString2.contains(".js")) {
        paramString1 = "application/x-javascript";
      } else if ((!paramString2.contains(".jpg")) && (!paramString2.contains(".gif")) && (!paramString2.contains(".png")) && (!paramString2.contains(".jpeg"))) {
        paramString1 = "text/html";
      } else {
        paramString1 = "image/*";
      }
      if (f.b())
      {
        localObject2 = f;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getResponse ****************** :");
        localStringBuilder.append(paramString2);
        ((ILog)localObject2).a("HtmlCheckUpdate", 4, localStringBuilder.toString());
      }
      try
      {
        localObject1 = new BufferedInputStream(new FileInputStream((String)localObject1));
        return new HtmlOffline.MyWebResourceResponse(paramString1, (InputStream)localObject1);
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        if (f.b())
        {
          paramString1 = f;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getResponse get local file fail:");
          ((StringBuilder)localObject1).append(paramString2);
          paramString1.a("HtmlCheckUpdate", 4, ((StringBuilder)localObject1).toString());
        }
        return null;
      }
    }
    if (f.a()) {
      f.a("HtmlCheckUpdate", 2, "shouldInterceptRequest: businessId null ");
    }
    return null;
  }
  
  public static void b()
  {
    if (j == null)
    {
      a(new QQThreadManager());
      a(new OfflineDownloader());
      a(new MyLog());
      a(BaseApplication.getContext());
    }
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime)
  {
    a(paramString, paramAppRuntime, false, h);
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (f.a())
    {
      localObject1 = f;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("-->offline:checkUpByBusinessId ");
      localStringBuilder1.append(paramString);
      ((ILog)localObject1).a("HtmlCheckUpdate", 2, localStringBuilder1.toString());
    }
    if (a(paramString, paramAppRuntime, paramAsyncBack, paramInt)) {
      return;
    }
    Object localObject1 = c(paramString);
    long l2 = 30L;
    long l1 = l2;
    if (localObject1 != null) {
      try
      {
        l1 = ((JSONObject)localObject1).getLong("frequency");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        l1 = l2;
      }
    }
    l2 = (System.currentTimeMillis() - b(paramAppRuntime.getApplication(), paramString)) / 60000L;
    if (f.a())
    {
      localObject2 = f;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("-->offline:checkUpdate check freq:");
      localStringBuilder2.append(l1);
      localStringBuilder2.append(", time:");
      localStringBuilder2.append(l2);
      ((ILog)localObject2).a("HtmlCheckUpdate", 2, localStringBuilder2.toString());
    }
    if ((!paramBoolean2) && (l2 < l1))
    {
      paramAsyncBack.loaded(null, 5);
      return;
    }
    if (BidDownloader.c(paramString))
    {
      if (f.a())
      {
        paramAppRuntime = f;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("-->offline:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" is downloading");
        paramAppRuntime.a("HtmlCheckUpdate", 2, ((StringBuilder)localObject1).toString());
      }
      paramAsyncBack.loaded(null, 7);
      return;
    }
    d(paramAppRuntime.getApplication().getApplicationContext(), paramString);
    if (d == null)
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "threadManager is null");
      }
      return;
    }
    Object localObject2 = new HashMap(1);
    int k = 0;
    if (localObject1 != null) {
      k = ((JSONObject)localObject1).optInt("version", 0);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append("");
    ((HashMap)localObject2).put(paramString, ((StringBuilder)localObject1).toString());
    d.a(new HtmlOffline.4(paramInt, paramString, paramAppRuntime, (HashMap)localObject2, paramAsyncBack, paramBoolean1, paramBoolean2));
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, AsyncBack paramAsyncBack)
  {
    a(paramString, paramAppRuntime, paramAsyncBack, paramBoolean, 5);
  }
  
  private static void b(ArrayList<String> paramArrayList, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList.size() == 0) {
      return;
    }
    HashMap localHashMap = new HashMap(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      Object localObject = c(str);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put(str, localObject);
        }
      }
      else
      {
        localHashMap.put(str, "0");
      }
    }
    a(paramAppRuntime, localHashMap, paramAsyncBack, paramBoolean1, paramBoolean2, false);
  }
  
  protected static boolean b(String paramString)
  {
    try
    {
      Object localObject1 = f;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("-->offline:doUpdateZip start:");
      ((StringBuilder)localObject2).append(paramString);
      ((ILog)localObject1).a("HtmlCheckUpdate", 1, ((StringBuilder)localObject2).toString());
      boolean bool1 = TextUtils.isEmpty(paramString);
      boolean bool2 = false;
      if (bool1) {
        return false;
      }
      localObject1 = OfflineEnvHelper.c(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (f.a()) {
          f.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,zip root dir is null:");
        }
        return false;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(".zip");
      Object localObject4 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject4).exists())
      {
        if (f.a())
        {
          localObject1 = f;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("-->offline:doUpdateZip:no zip ! : businessId:");
          ((StringBuilder)localObject2).append(paramString);
          ((ILog)localObject1).a("HtmlCheckUpdate", 2, ((StringBuilder)localObject2).toString());
        }
        return false;
      }
      localObject2 = OfflineEnvHelper.b(paramString);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("tmp_u_");
      ((StringBuilder)localObject3).append(System.currentTimeMillis());
      ((StringBuilder)localObject3).append(File.separator);
      localObject1 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(".zip");
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!a((String)localObject1, (String)localObject4, (String)localObject3))
      {
        QLog.w("HtmlCheckUpdate", 1, "doUpdateZip renameToDest businessId.zip failed");
        return false;
      }
      localObject4 = new File((String)localObject3);
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append((String)localObject2);
      ((StringBuilder)localObject5).append(paramString);
      localObject5 = ((StringBuilder)localObject5).toString();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append((String)localObject2);
      ((StringBuilder)localObject6).append(paramString);
      ((StringBuilder)localObject6).append("_new");
      localObject2 = ((StringBuilder)localObject6).toString();
      Util.a((String)localObject2);
      localObject6 = new File((String)localObject2);
      if (!((File)localObject6).mkdirs())
      {
        if (f.a())
        {
          paramString = f;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("-->offline:doUpdateZip,mkdirs: error:");
          ((StringBuilder)localObject1).append((String)localObject2);
          paramString.b("HtmlCheckUpdate", 2, ((StringBuilder)localObject1).toString());
        }
        return false;
      }
      long l = System.currentTimeMillis();
      int k = ZipUtils.unZipFolder((String)localObject3, (String)localObject2);
      if (k > 0)
      {
        if (c == 0) {
          c = 2;
        }
        Util.b((String)localObject3);
        a(paramString, 13, 0L, k, "lixian_update", "0");
        BidDownloader.a(0, paramString, 13, 0, "lixian_update", k);
        bool1 = bool2;
        if (f.a())
        {
          f.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,unZipFolder fail!");
          bool1 = bool2;
        }
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("/b.zip");
        ((File)localObject4).renameTo(new File(((StringBuilder)localObject3).toString()));
        Util.a((String)localObject5);
        bool1 = ((File)localObject6).renameTo(new File((String)localObject5));
        a(paramString, 13, 0L, k, "lixian_time", "0");
        BidDownloader.a(0, paramString, 13, 0, "lixian_time", k);
      }
      if (f.a())
      {
        paramString = f;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("-->offline:time of unzip：");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject2).append(", isSuccess: ");
        ((StringBuilder)localObject2).append(bool1);
        paramString.a("HtmlCheckUpdate", 2, ((StringBuilder)localObject2).toString());
      }
      Util.a((String)localObject1);
      return bool1;
    }
    finally {}
  }
  
  protected static int c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expire_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static JSONObject c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = OfflineEnvHelper.b(paramString);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append("config.json");
    paramString = new File(localStringBuilder.toString());
    if (paramString.exists())
    {
      try
      {
        paramString = new FileInputStream(paramString);
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      if (paramString == null) {
        return null;
      }
      str = Util.a(paramString);
      try
      {
        paramString.close();
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
      try
      {
        paramString = new JSONObject(str);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  protected static void c(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, AsyncBack paramAsyncBack)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseExpire:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("HtmlCheckUpdate", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("data");
      localObject1 = new ArrayList();
      int m = paramString.length();
      int k = 0;
      while (k < m)
      {
        JSONObject localJSONObject = paramString.optJSONObject(k);
        if (localJSONObject != null)
        {
          int n = localJSONObject.optInt("code");
          if ((n > 0) && (n < 10))
          {
            int i1 = localJSONObject.optInt("bid");
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append("");
            ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append("");
            localObject2 = new BidDownloader(((StringBuilder)localObject2).toString(), paramAppRuntime, paramAsyncBack, true, n);
            ((BidDownloader)localObject2).p = localJSONObject.optInt("id");
            boolean bool;
            if (localJSONObject.optInt("isWifi", 0) > 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((BidDownloader)localObject2).i = bool;
            ((BidDownloader)localObject2).d = paramBoolean;
            ((BidDownloader)localObject2).m = localJSONObject.optString("url");
            ((BidDownloader)localObject2).n = localJSONObject.optInt("filesize");
            ((BidDownloader)localObject2).b();
          }
        }
        k += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("parseExpire: ");
        paramAppRuntime.append(QLog.getStackTraceString(paramString));
        QLog.i("HtmlCheckUpdate", 2, paramAppRuntime.toString());
      }
    }
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "verfyFile: businessId null ");
      }
      return false;
    }
    Object localObject = OfflineEnvHelper.b(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString1);
    localObject = localStringBuilder.toString();
    if (!new File((String)localObject).exists()) {
      return true;
    }
    paramString2 = g(paramString2);
    long l = System.currentTimeMillis();
    if (!OfflineSecurity.c(paramString2, (String)localObject, paramString1))
    {
      d((String)localObject, paramString1);
      if (f.a())
      {
        paramString1 = f;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("verfySingleFile fail :");
        ((StringBuilder)localObject).append(paramString2);
        paramString1.a("HtmlCheckUpdate", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (f.b())
    {
      paramString1 = f;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verifyFile:time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject).append(", file:");
      ((StringBuilder)localObject).append(paramString2);
      paramString1.b("HtmlCheckUpdate", 4, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = c(paramString);
    if (paramString == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramString.optLong("expired", 0L);
    if ((l2 > 0L) && (l1 > l2)) {
      return null;
    }
    try
    {
      paramString = paramString.getString("version");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected static void d(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_up_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramContext = paramContext.edit();
    paramContext.putLong(paramString, System.currentTimeMillis());
    paramContext.commit();
  }
  
  public static void d(String paramString1, String paramString2)
  {
    OfflinePlugin.h(paramString2);
    Util.a(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, new Object[] { "dealVerifyErroFile fileDir:", paramString1, " mBussinessId:", paramString2 });
    }
  }
  
  protected static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int k = 0;
        while ((k < paramString.length) && (k < 100))
        {
          Object localObject = paramString[k];
          if ((localObject.isDirectory()) && (TextUtils.isDigitsOnly(localObject.getName())))
          {
            JSONObject localJSONObject = c(localObject.getName());
            if (localJSONObject != null) {
              try
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(localObject.getName());
                localStringBuilder.append("|");
                localStringBuilder.append(localJSONObject.getString("version"));
                localStringBuilder.append(",");
                localStringBuffer.append(localStringBuilder.toString());
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
            }
          }
          k += 1;
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String f(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file://");
    ((StringBuilder)localObject).append(OfflineEnvHelper.b());
    localObject = ((StringBuilder)localObject).toString();
    int k;
    if (paramString != null)
    {
      if (!paramString.startsWith((String)localObject)) {
        return "";
      }
      paramString = paramString.substring(((String)localObject).length());
      k = paramString.indexOf('/');
      if (k <= 0) {
        return "";
      }
    }
    try
    {
      Integer.parseInt(paramString.substring(0, k), 10);
      paramString = paramString.substring(k + 1);
      if (paramString.length() > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://");
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
      return "";
    }
    catch (NumberFormatException paramString) {}
    return "";
  }
  
  public static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int k = paramString.indexOf(":");
    if (k >= 0)
    {
      k += 3;
      if (k >= paramString.length()) {
        return null;
      }
      String[] arrayOfString = paramString.substring(k).split("\\?");
      paramString = arrayOfString;
      if (arrayOfString[0].contains("#")) {
        paramString = arrayOfString[0].split("\\#");
      }
      return paramString[0];
    }
    return null;
  }
  
  public static boolean h(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (f.a()) {
        f.a("HtmlCheckUpdate", 2, "verfySign: businessId null ");
      }
      return false;
    }
    Object localObject = OfflineEnvHelper.b(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    localObject = localStringBuilder.toString();
    if (!new File((String)localObject).exists()) {
      return true;
    }
    if (OfflineSecurity.b((String)localObject, paramString)) {
      return true;
    }
    d((String)localObject, paramString);
    if (f.a())
    {
      localObject = f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("verfySign fail :");
      localStringBuilder.append(paramString);
      ((ILog)localObject).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  private static void j(String paramString)
  {
    if (f.a()) {
      f.a("HtmlCheckUpdate", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline
 * JD-Core Version:    0.7.0.1
 */