package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.WVSecurityConfBean;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.soso.SosoSrvAddrProvider;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class WebAccelerator
{
  static final Pattern a = Pattern.compile(Patterns.d.pattern());
  public static boolean b = true;
  public static int c = -1;
  public static boolean d = false;
  private static WebAccelerator e = null;
  private int f = 15;
  private int g = 10;
  private Set<String> h = null;
  private byte[] i = new byte[0];
  private long j = 86400000L;
  private boolean k = true;
  private DiskLruCache l = null;
  private Map<String, Long> m = null;
  private int n = 0;
  
  public WebAccelerator()
  {
    if (!b) {
      return;
    }
    SosoSrvAddrProvider.a().c();
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name());
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DPC:");
      ((StringBuilder)localObject).append(str);
      QLog.d("WebAccelerator", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = str.split("\\|");
      if (localObject.length <= 5) {}
    }
    try
    {
      this.n = Integer.parseInt(localObject[4]);
      this.j = (Integer.parseInt(localObject[5]) * 1000 * 60 * 60);
      if (localObject.length > 6) {
        this.g = Integer.parseInt(localObject[6]);
      }
      if (this.g > 30) {
        this.g = 10;
      }
      i1 = 1;
    }
    catch (Exception localException2)
    {
      int i1;
      label214:
      break label214;
    }
    this.k = false;
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
    }
    i1 = 0;
    if ((i1 == 0) && (QLog.isColorLevel()))
    {
      localObject = AIOUtils.a();
      ((StringBuilder)localObject).append("DPC not catch success[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]");
      QLog.d("WebAccelerator", 2, ((StringBuilder)localObject).toString());
    }
    this.h = new HashSet();
    this.m = new HashMap();
    try
    {
      this.l = DiskLruCache.open(((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getApp().getCacheDir(), 1, 1, 1048576L);
      return;
    }
    catch (Exception localException1)
    {
      label330:
      break label330;
    }
    this.k = false;
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
    }
  }
  
  public static WebAccelerator a()
  {
    try
    {
      if (e == null) {
        e = new WebAccelerator();
      }
      WebAccelerator localWebAccelerator = e;
      return localWebAccelerator;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (b)
    {
      ThreadManager.post(new WebAccelerator.1(paramString, paramIntent, paramContext), 8, null, false);
      return;
    }
    if (paramIntent.getBooleanExtra("is_public_account", false))
    {
      paramContext = new ActivityURIRequest(paramContext, "/pubaccount/browser");
      paramContext.extra().putAll(paramIntent.getExtras());
      QRoute.startUri(paramContext, null);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("mqqzone://arouse/qqexplaunchlive");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("?ec_title=");
    localStringBuilder2.append(paramString1);
    localStringBuilder1.append(localStringBuilder2.toString());
    paramString1 = new StringBuilder();
    paramString1.append("&ec_room_init_type=");
    paramString1.append(paramInt1);
    localStringBuilder1.append(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("&ec_room_from_type=");
    paramString1.append(paramInt2);
    localStringBuilder1.append(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("&ec_room_owner_id = ");
    paramString1.append(paramString2);
    localStringBuilder1.append(paramString1.toString());
    localIntent.setData(Uri.parse(localStringBuilder1.toString()));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("mqqzone://arouse/qqexplivevideo");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("?ec_title=");
    localStringBuilder2.append(paramString3);
    localStringBuilder1.append(localStringBuilder2.toString());
    paramString3 = new StringBuilder();
    paramString3.append("&ec_room_id=");
    paramString3.append(paramString1);
    localStringBuilder1.append(paramString3.toString());
    paramString1 = new StringBuilder();
    paramString1.append("&ec_content=");
    paramString1.append(paramString4);
    localStringBuilder1.append(paramString1.toString());
    localStringBuilder1.append("&ec_room_init_type=3");
    paramString1 = new StringBuilder();
    paramString1.append("&ec_room_from_type=");
    paramString1.append(paramInt);
    localStringBuilder1.append(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("&ec_room_owner_id=");
    paramString1.append(paramString2);
    localStringBuilder1.append(paramString1.toString());
    localIntent.setData(Uri.parse(localStringBuilder1.toString()));
    paramContext.startActivity(localIntent);
  }
  
  private final boolean a(int paramInt)
  {
    return (this.n & paramInt) == paramInt;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = (WVSecurityConfBean)QConfigManager.b().b(158);
    int i1;
    if (paramContext != null) {
      i1 = paramContext.a;
    } else {
      i1 = 0;
    }
    paramContext = new StringBuilder();
    paramContext.append("hasUrlSsoCheckSwitchOn isSSOCheckValidate = ");
    paramContext.append(i1);
    QLog.d("WebAccelerator", 1, paramContext.toString());
    if (i1 == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent)
  {
    String str1 = QzoneConfig.getInstance().getConfig("QZVideo", "qzone_eclive_livehost", "https://h5.qzone.qq.com/v2/audio-live/live/");
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder1 = new StringBuilder();
    if ((paramString != null) && (paramString.contains(str1))) {}
    try
    {
      Object localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("hostuin");
      str1 = ((Uri)localObject).getQueryParameter("roomid");
      String str2 = ((Uri)localObject).getQueryParameter("feedid");
      localObject = ((Uri)localObject).getQueryParameter("roomstatus");
      if (!g(str1))
      {
        QLog.d("WebAccelerator", 2, "room_id not number!");
        return false;
      }
      localStringBuilder1.append("mqqzone://arouse/qqexplivevideo");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("?ec_room_id=");
      localStringBuilder2.append(str1);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("&ec_room_owner_id=");
      localStringBuilder2.append(paramString);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("&ec_room_from_type2");
      localStringBuilder1.append("&ec_room_init_type=3");
      localIntent.setData(Uri.parse(localStringBuilder1.toString()));
      paramContext.startActivity(localIntent);
      paramContext = new PushReportController.PushReportItem();
      paramContext.d = "kuolie_party";
      paramContext.e = "party_clk";
      paramContext.h = str2;
      paramContext.i = str1;
      paramContext.j = paramIntent.getStringExtra("title");
      paramContext.l = ((String)localObject);
      paramContext.m = paramString;
      paramContext.n = paramIntent.getStringExtra("friendUin");
      paramContext.o = "4";
      PushReportController.a(null, paramContext);
      return true;
    }
    catch (Exception paramContext)
    {
      label328:
      break label328;
    }
    QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isSend())
    {
      if ((paramChatMessage instanceof MessageForStructing))
      {
        AbsStructMsg localAbsStructMsg2 = ((MessageForStructing)paramChatMessage).structingMsg;
        AbsStructMsg localAbsStructMsg1 = localAbsStructMsg2;
        if (localAbsStructMsg2 == null) {
          localAbsStructMsg1 = StructMsgFactory.a(paramChatMessage.msgData);
        }
        return a(localAbsStructMsg1);
      }
      if ((paramChatMessage instanceof MessageForText))
      {
        paramChatMessage = (MessageForText)paramChatMessage;
        if ((paramChatMessage.msg != null) && (!paramChatMessage.msg.equals("")) && (f(paramChatMessage.msg) != null)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static final boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (paramAbsStructMsg != null) && ("web".equals(paramAbsStructMsg.mMsgAction)) && ((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!CGILoader.a((AbsShareMsg)paramAbsStructMsg));
  }
  
  private final boolean c()
  {
    try
    {
      Object localObject1 = b();
      boolean bool = false;
      int i2 = ((SharedPreferences)localObject1).getInt("bankSize", 0);
      int i1 = i2;
      if (i2 < this.f)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        i1 = i2 + 1;
        ((SharedPreferences.Editor)localObject1).putInt("bankSize", i1);
        ((SharedPreferences.Editor)localObject1).commit();
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = AIOUtils.a();
        ((StringBuilder)localObject1).append("shouldUseAccelerator:");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append("   ");
        ((StringBuilder)localObject1).append(i1);
        QLog.d("WebAccelerator", 2, ((StringBuilder)localObject1).toString());
      }
      return bool;
    }
    finally {}
  }
  
  private static boolean c(Context paramContext, String paramString, Intent paramIntent)
  {
    Object localObject1 = QzoneConfig.getInstance().getConfig("QZVideo", "qzone_eclive_livehost", "https://h5.qzone.qq.com/v2/audio-live/live/");
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith((String)localObject1))) {
      return a(paramContext, paramString, paramIntent);
    }
    Object localObject2 = QzoneConfig.getInstance().getConfig("QZVideo", "qzonelivevideo_livehost", "h5.qzone.qq.com/live/video/qzone/");
    int i1 = QzoneConfig.getInstance().getConfig("QZVideo", "module_jump_native", 1);
    localObject1 = QzoneConfig.getInstance().getConfig("Plato", "PlatoShareUrlPrefix", "plato.tswjs.org/share");
    int i2 = QzoneConfig.getInstance().getConfig("Plato", "qzoneplato_jump_native", 1);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString != null) && (paramString.contains((CharSequence)localObject2))) {}
    try
    {
      localObject3 = Uri.parse(paramString);
      Object localObject4 = ((Uri)localObject3).getQueryParameter("stayin");
      if (i1 != 1) {
        break label493;
      }
      localObject1 = "1";
      if ((localObject4 != null) && (TextUtils.equals((CharSequence)localObject4, "1"))) {
        break label493;
      }
      localObject3 = paramIntent.getStringExtra("self_uin");
      localObject2 = paramString.substring(paramString.lastIndexOf(localObject2) + localObject2.length(), paramString.length()).split("/")[0];
      if ((localObject3 == null) || (localObject2 == null) || (TextUtils.isEmpty((CharSequence)localObject3))) {
        break label491;
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return false;
      }
      if (!g((String)localObject2))
      {
        QLog.d("WebAccelerator", 2, "room_id not number!");
        return false;
      }
      localStringBuilder.append("mqqzone://arouse/livevideo");
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("?room=");
      ((StringBuilder)localObject4).append((String)localObject2);
      localStringBuilder.append(((StringBuilder)localObject4).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&uin=");
      ((StringBuilder)localObject2).append((String)localObject3);
      localStringBuilder.append(((StringBuilder)localObject2).toString());
      localStringBuilder.append("&video_play_source=12");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&backup=");
      ((StringBuilder)localObject2).append(URLEncoder.encode(paramString));
      localStringBuilder.append(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&isEcLive=");
      if (!paramIntent.getBooleanExtra("isEcLive", false)) {
        break label824;
      }
      paramString = (String)localObject1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject3;
        continue;
        paramString = "0";
      }
    }
    ((StringBuilder)localObject2).append(paramString);
    localStringBuilder.append(((StringBuilder)localObject2).toString());
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    paramContext.startActivity(localIntent);
    return true;
    label491:
    return false;
    label493:
    paramIntent = new StringBuilder();
    paramIntent.append("is_native not available, jump to H5, ");
    paramIntent.append(paramString);
    QLog.d("WebAccelerator", 1, paramIntent.toString());
    paramString = new Intent(paramContext, QQBrowserActivity.class);
    paramString.putExtra("url", ((Uri)localObject3).toString());
    paramString.setData((Uri)localObject3);
    paramContext.startActivity(paramString);
    return true;
    QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
    return false;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains((CharSequence)localObject1))) {
      if (i2 != 1) {
        return false;
      }
    }
    try
    {
      paramIntent = URLUtil.b(paramString.substring(paramString.lastIndexOf((String)localObject1) + ((String)localObject1).length() + 1));
      localStringBuilder.append("mqqzone://arouse/plato");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("?id=");
      ((StringBuilder)localObject1).append(URLEncoder.encode((String)paramIntent.get("id")));
      localStringBuilder.append(((StringBuilder)localObject1).toString());
      if (!TextUtils.isEmpty((CharSequence)paramIntent.get("data")))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("&data=");
        ((StringBuilder)localObject1).append(URLEncoder.encode((String)paramIntent.get("data")));
        localStringBuilder.append(((StringBuilder)localObject1).toString());
      }
      paramIntent = new StringBuilder();
      paramIntent.append("&url=");
      paramIntent.append(URLEncoder.encode(paramString));
      localStringBuilder.append(paramIntent.toString());
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (Exception paramContext)
    {
      label805:
      break label805;
    }
    QLog.d("WebAccelerator", 1, "arouse plato  parse url error!");
    return false;
  }
  
  public static String f(@NonNull String paramString)
  {
    boolean bool = paramString.contains("http");
    String str = null;
    if (!bool) {
      return null;
    }
    Matcher localMatcher = a.matcher(paramString);
    if (localMatcher.find()) {
      str = paramString.substring(localMatcher.start(), localMatcher.end());
    }
    return str;
  }
  
  public static boolean g(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private final String h(String paramString)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localObject1 = localObject2;
      localHttpURLConnection.setInstanceFollowRedirects(false);
      localObject1 = localObject2;
      localHttpURLConnection.connect();
      localObject1 = localObject2;
      paramString = localHttpURLConnection.getHeaderField("Location");
      localObject1 = paramString;
      localObject2 = new StringBuilder();
      localObject1 = paramString;
      ((StringBuilder)localObject2).append("code:");
      localObject1 = paramString;
      ((StringBuilder)localObject2).append(localHttpURLConnection.getResponseCode());
      localObject1 = paramString;
      QLog.d("WebAccelerator", 2, ((StringBuilder)localObject2).toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WebAccelerator", 2, "doRedirect", paramString);
      }
    }
    return localObject1;
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +281 -> 282
    //   4: aload_1
    //   5: ldc_w 437
    //   8: invokevirtual 441	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +5 -> 16
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 75	com/tencent/mobileqq/activity/WebAccelerator:k	Z
    //   20: istore_2
    //   21: aconst_null
    //   22: astore 6
    //   24: aconst_null
    //   25: astore_3
    //   26: aconst_null
    //   27: astore 5
    //   29: iload_2
    //   30: ifeq +250 -> 280
    //   33: getstatic 51	com/tencent/mobileqq/activity/WebAccelerator:b	Z
    //   36: ifne +5 -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: aload_1
    //   42: invokestatic 663	com/tencent/smtt/utils/Md5Utils:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 77	com/tencent/mobileqq/activity/WebAccelerator:l	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   51: aload 4
    //   53: invokevirtual 666	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   56: astore 4
    //   58: aload 5
    //   60: astore_3
    //   61: aload 4
    //   63: ifnull +14 -> 77
    //   66: aload 4
    //   68: astore 5
    //   70: aload 4
    //   72: iconst_0
    //   73: invokevirtual 671	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   76: astore_3
    //   77: aload_3
    //   78: astore 6
    //   80: aload 4
    //   82: astore 5
    //   84: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +93 -> 180
    //   90: aload_3
    //   91: astore 6
    //   93: aload 4
    //   95: astore 5
    //   97: invokestatic 159	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   100: astore 7
    //   102: aload_3
    //   103: astore 6
    //   105: aload 4
    //   107: astore 5
    //   109: aload 7
    //   111: ldc_w 673
    //   114: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_3
    //   119: astore 6
    //   121: aload 4
    //   123: astore 5
    //   125: aload 7
    //   127: aload_1
    //   128: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_3
    //   133: astore 6
    //   135: aload 4
    //   137: astore 5
    //   139: aload 7
    //   141: ldc_w 492
    //   144: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_3
    //   149: astore 6
    //   151: aload 4
    //   153: astore 5
    //   155: aload 7
    //   157: aload_3
    //   158: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_3
    //   163: astore 6
    //   165: aload 4
    //   167: astore 5
    //   169: ldc 126
    //   171: iconst_2
    //   172: aload 7
    //   174: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_3
    //   181: astore 5
    //   183: aload 4
    //   185: ifnull +79 -> 264
    //   188: aload_3
    //   189: astore_1
    //   190: aload 4
    //   192: astore_3
    //   193: aload_3
    //   194: invokevirtual 676	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   197: aload_1
    //   198: areturn
    //   199: astore 5
    //   201: aload 4
    //   203: astore_3
    //   204: aload 6
    //   206: astore_1
    //   207: aload 5
    //   209: astore 4
    //   211: goto +20 -> 231
    //   214: astore_1
    //   215: aconst_null
    //   216: astore 5
    //   218: goto +50 -> 268
    //   221: astore 4
    //   223: aconst_null
    //   224: astore 5
    //   226: aload_3
    //   227: astore_1
    //   228: aload 5
    //   230: astore_3
    //   231: aload_3
    //   232: astore 5
    //   234: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +17 -> 254
    //   240: aload_3
    //   241: astore 5
    //   243: ldc 126
    //   245: iconst_2
    //   246: ldc_w 678
    //   249: aload 4
    //   251: invokestatic 656	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload_1
    //   255: astore 5
    //   257: aload_3
    //   258: ifnull +6 -> 264
    //   261: goto -68 -> 193
    //   264: aload 5
    //   266: areturn
    //   267: astore_1
    //   268: aload 5
    //   270: ifnull +8 -> 278
    //   273: aload 5
    //   275: invokevirtual 676	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   278: aload_1
    //   279: athrow
    //   280: aconst_null
    //   281: areturn
    //   282: aload_1
    //   283: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	WebAccelerator
    //   0	284	1	paramString	String
    //   20	10	2	bool	boolean
    //   25	233	3	localObject1	Object
    //   45	165	4	localObject2	Object
    //   221	29	4	localIOException1	IOException
    //   27	155	5	localObject3	Object
    //   199	9	5	localIOException2	IOException
    //   216	58	5	localObject4	Object
    //   22	183	6	localObject5	Object
    //   100	73	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   70	77	199	java/io/IOException
    //   84	90	199	java/io/IOException
    //   97	102	199	java/io/IOException
    //   109	118	199	java/io/IOException
    //   125	132	199	java/io/IOException
    //   139	148	199	java/io/IOException
    //   155	162	199	java/io/IOException
    //   169	180	199	java/io/IOException
    //   47	58	214	finally
    //   47	58	221	java/io/IOException
    //   70	77	267	finally
    //   84	90	267	finally
    //   97	102	267	finally
    //   109	118	267	finally
    //   125	132	267	finally
    //   139	148	267	finally
    //   155	162	267	finally
    //   169	180	267	finally
    //   234	240	267	finally
    //   243	254	267	finally
  }
  
  /* Error */
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_1
    //   4: ifnull +709 -> 713
    //   7: aload_1
    //   8: ldc_w 437
    //   11: invokevirtual 441	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 75	com/tencent/mobileqq/activity/WebAccelerator:k	Z
    //   23: ifeq +675 -> 698
    //   26: getstatic 51	com/tencent/mobileqq/activity/WebAccelerator:b	Z
    //   29: ifeq +669 -> 698
    //   32: aload_1
    //   33: ldc_w 683
    //   36: invokestatic 551	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual 344	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   42: ifne +656 -> 698
    //   45: aload_1
    //   46: ldc_w 683
    //   49: invokevirtual 344	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifne +646 -> 698
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 685	com/tencent/mobileqq/activity/WebAccelerator:c	(Ljava/lang/String;)Z
    //   60: ifeq +6 -> 66
    //   63: goto +635 -> 698
    //   66: invokestatic 691	android/os/SystemClock:uptimeMillis	()J
    //   69: l2i
    //   70: iconst_2
    //   71: irem
    //   72: istore 5
    //   74: getstatic 696	com/tencent/mobileqq/webview/util/WebViewConstant:b	[Ljava/lang/String;
    //   77: astore 8
    //   79: iload 5
    //   81: iconst_m1
    //   82: if_icmple +637 -> 719
    //   85: goto +3 -> 88
    //   88: aload 8
    //   90: iload 5
    //   92: aaload
    //   93: astore 9
    //   95: invokestatic 86	com/tencent/mobileqq/troop/soso/SosoSrvAddrProvider:a	()Lcom/tencent/mobileqq/troop/soso/SosoSrvAddrProvider;
    //   98: iconst_0
    //   99: iconst_0
    //   100: iconst_0
    //   101: invokevirtual 699	com/tencent/mobileqq/troop/soso/SosoSrvAddrProvider:a	(IZZ)Ljava/lang/String;
    //   104: astore 10
    //   106: aload 9
    //   108: astore 8
    //   110: aload 10
    //   112: ifnull +27 -> 139
    //   115: aload 9
    //   117: astore 8
    //   119: aload 10
    //   121: invokevirtual 530	java/lang/String:length	()I
    //   124: ifle +15 -> 139
    //   127: aload 9
    //   129: ldc_w 701
    //   132: aload 10
    //   134: invokevirtual 705	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 8
    //   139: invokestatic 159	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   142: astore 9
    //   144: aload 9
    //   146: aload 8
    //   148: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 9
    //   154: ldc_w 707
    //   157: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 9
    //   163: aload_1
    //   164: ldc_w 709
    //   167: invokestatic 711	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 9
    //   176: ldc_w 713
    //   179: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: iload_2
    //   184: ifeq +51 -> 235
    //   187: iload_2
    //   188: iconst_1
    //   189: if_icmpeq +34 -> 223
    //   192: iload_2
    //   193: sipush 3000
    //   196: if_icmpeq +15 -> 211
    //   199: aload 9
    //   201: ldc_w 715
    //   204: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: goto +36 -> 244
    //   211: aload 9
    //   213: ldc_w 717
    //   216: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: goto +24 -> 244
    //   223: aload 9
    //   225: ldc_w 719
    //   228: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: goto +12 -> 244
    //   235: aload 9
    //   237: ldc_w 721
    //   240: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_3
    //   245: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +19 -> 267
    //   251: aload 9
    //   253: ldc_w 542
    //   256: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 9
    //   262: aload_3
    //   263: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 4
    //   269: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   272: ifne +20 -> 292
    //   275: aload 9
    //   277: ldc_w 723
    //   280: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 9
    //   286: aload 4
    //   288: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 9
    //   294: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: astore 8
    //   299: aload_0
    //   300: aload 8
    //   302: invokespecial 725	com/tencent/mobileqq/activity/WebAccelerator:h	(Ljava/lang/String;)Ljava/lang/String;
    //   305: astore_3
    //   306: aload_0
    //   307: invokevirtual 464	com/tencent/mobileqq/activity/WebAccelerator:b	()Landroid/content/SharedPreferences;
    //   310: astore 4
    //   312: aload 4
    //   314: ldc_w 727
    //   317: iconst_0
    //   318: invokeinterface 472 3 0
    //   323: istore_2
    //   324: aload 4
    //   326: invokeinterface 476 1 0
    //   331: ldc_w 727
    //   334: iload_2
    //   335: iconst_1
    //   336: iadd
    //   337: invokeinterface 482 3 0
    //   342: invokeinterface 485 1 0
    //   347: pop
    //   348: aload_3
    //   349: invokestatic 138	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifne +251 -> 603
    //   355: aload_3
    //   356: aload_1
    //   357: invokevirtual 441	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   360: ifeq +243 -> 603
    //   363: aconst_null
    //   364: astore_3
    //   365: aconst_null
    //   366: astore 4
    //   368: aload_1
    //   369: invokestatic 663	com/tencent/smtt/utils/Md5Utils:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   372: astore 9
    //   374: aload 4
    //   376: astore_1
    //   377: aload_0
    //   378: getfield 77	com/tencent/mobileqq/activity/WebAccelerator:l	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   381: aload 9
    //   383: invokevirtual 730	com/jakewharton/disklrucache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Editor;
    //   386: astore 4
    //   388: aload 4
    //   390: ifnull +82 -> 472
    //   393: aload 4
    //   395: astore_1
    //   396: aload 4
    //   398: astore_3
    //   399: new 117	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   406: astore 9
    //   408: aload 4
    //   410: astore_1
    //   411: aload 4
    //   413: astore_3
    //   414: aload 9
    //   416: invokestatic 691	android/os/SystemClock:uptimeMillis	()J
    //   419: invokevirtual 733	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 4
    //   425: astore_1
    //   426: aload 4
    //   428: astore_3
    //   429: aload 9
    //   431: ldc_w 437
    //   434: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 4
    //   440: astore_1
    //   441: aload 4
    //   443: astore_3
    //   444: aload 4
    //   446: iconst_0
    //   447: aload 9
    //   449: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokevirtual 739	com/jakewharton/disklrucache/DiskLruCache$Editor:set	(ILjava/lang/String;)V
    //   455: aload 4
    //   457: astore_1
    //   458: aload 4
    //   460: astore_3
    //   461: aload 4
    //   463: invokevirtual 741	com/jakewharton/disklrucache/DiskLruCache$Editor:commit	()V
    //   466: iconst_1
    //   467: istore 6
    //   469: goto +157 -> 626
    //   472: aload 4
    //   474: astore_1
    //   475: iload 7
    //   477: istore 6
    //   479: aload 4
    //   481: astore_3
    //   482: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +141 -> 626
    //   488: aload 4
    //   490: astore_1
    //   491: aload 4
    //   493: astore_3
    //   494: ldc 126
    //   496: iconst_2
    //   497: ldc_w 743
    //   500: invokestatic 745	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: iload 7
    //   505: istore 6
    //   507: goto +119 -> 626
    //   510: aload_3
    //   511: ifnull +26 -> 537
    //   514: aload_3
    //   515: invokevirtual 748	com/jakewharton/disklrucache/DiskLruCache$Editor:abort	()V
    //   518: iconst_0
    //   519: ireturn
    //   520: astore_1
    //   521: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +13 -> 537
    //   527: ldc 126
    //   529: iconst_2
    //   530: ldc_w 750
    //   533: aload_1
    //   534: invokestatic 656	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   537: iconst_0
    //   538: ireturn
    //   539: astore_3
    //   540: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +13 -> 556
    //   546: ldc 126
    //   548: iconst_2
    //   549: ldc_w 750
    //   552: aload_3
    //   553: invokestatic 752	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   556: iload 7
    //   558: istore 6
    //   560: aload_1
    //   561: ifnull +65 -> 626
    //   564: aload_1
    //   565: invokevirtual 748	com/jakewharton/disklrucache/DiskLruCache$Editor:abort	()V
    //   568: iload 7
    //   570: istore 6
    //   572: goto +54 -> 626
    //   575: astore_1
    //   576: iload 7
    //   578: istore 6
    //   580: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +43 -> 626
    //   586: ldc 126
    //   588: iconst_2
    //   589: ldc_w 750
    //   592: aload_1
    //   593: invokestatic 656	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   596: iload 7
    //   598: istore 6
    //   600: goto +26 -> 626
    //   603: iload 7
    //   605: istore 6
    //   607: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq +16 -> 626
    //   613: ldc 126
    //   615: iconst_2
    //   616: ldc_w 754
    //   619: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: iload 7
    //   624: istore 6
    //   626: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq +47 -> 676
    //   632: invokestatic 159	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   635: astore_1
    //   636: aload_1
    //   637: ldc_w 756
    //   640: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload_1
    //   645: aload 8
    //   647: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload_1
    //   652: ldc_w 492
    //   655: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload_1
    //   660: iload 6
    //   662: invokevirtual 490	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: ldc 126
    //   668: iconst_2
    //   669: aload_1
    //   670: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   676: iload 6
    //   678: ireturn
    //   679: astore_1
    //   680: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq +13 -> 696
    //   686: ldc 126
    //   688: iconst_2
    //   689: ldc_w 758
    //   692: aload_1
    //   693: invokestatic 656	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   696: iconst_0
    //   697: ireturn
    //   698: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   701: ifeq +12 -> 713
    //   704: ldc 126
    //   706: iconst_2
    //   707: ldc_w 760
    //   710: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: iconst_0
    //   714: ireturn
    //   715: astore_1
    //   716: goto -206 -> 510
    //   719: iconst_0
    //   720: istore 5
    //   722: goto -634 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	WebAccelerator
    //   0	725	1	paramString1	String
    //   0	725	2	paramInt	int
    //   0	725	3	paramString2	String
    //   0	725	4	paramString3	String
    //   72	649	5	i1	int
    //   467	210	6	bool1	boolean
    //   1	622	7	bool2	boolean
    //   77	569	8	localObject1	Object
    //   93	355	9	localObject2	Object
    //   104	29	10	str	String
    // Exception table:
    //   from	to	target	type
    //   514	518	520	java/io/IOException
    //   377	388	539	java/io/IOException
    //   399	408	539	java/io/IOException
    //   414	423	539	java/io/IOException
    //   429	438	539	java/io/IOException
    //   444	455	539	java/io/IOException
    //   461	466	539	java/io/IOException
    //   482	488	539	java/io/IOException
    //   494	503	539	java/io/IOException
    //   564	568	575	java/io/IOException
    //   66	79	679	java/io/UnsupportedEncodingException
    //   95	106	679	java/io/UnsupportedEncodingException
    //   119	139	679	java/io/UnsupportedEncodingException
    //   139	183	679	java/io/UnsupportedEncodingException
    //   199	208	679	java/io/UnsupportedEncodingException
    //   211	220	679	java/io/UnsupportedEncodingException
    //   223	232	679	java/io/UnsupportedEncodingException
    //   235	244	679	java/io/UnsupportedEncodingException
    //   244	267	679	java/io/UnsupportedEncodingException
    //   267	292	679	java/io/UnsupportedEncodingException
    //   292	299	679	java/io/UnsupportedEncodingException
    //   377	388	715	java/lang/Exception
    //   399	408	715	java/lang/Exception
    //   414	423	715	java/lang/Exception
    //   429	438	715	java/lang/Exception
    //   444	455	715	java/lang/Exception
    //   461	466	715	java/lang/Exception
    //   482	488	715	java/lang/Exception
    //   494	503	715	java/lang/Exception
  }
  
  public final SharedPreferences b()
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("WebAccelerator", 0);
      long l1 = localSharedPreferences.getLong("updateTime", 0L);
      SharedPreferences.Editor localEditor;
      if (l1 == 0L)
      {
        localEditor = localSharedPreferences.edit();
        localEditor.putLong("updateTime", System.currentTimeMillis());
        localEditor.commit();
      }
      else if (System.currentTimeMillis() - l1 > 86400000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerator", 2, "get circle,clean data and report");
        }
        localEditor = localSharedPreferences.edit();
        localEditor.putLong("updateTime", System.currentTimeMillis());
        localEditor.putInt("bankSize", 0);
        localEditor.putInt("bank_download_key", 0);
        this.m.clear();
        int i1 = localSharedPreferences.getInt("load_shortLink", 0);
        localEditor.putInt("load_shortLink", 0);
        int i2 = localSharedPreferences.getInt("hit_shortLink", 0);
        localEditor.putInt("hit_shortLink", 0);
        HashMap localHashMap;
        StringBuilder localStringBuilder;
        if ((i1 > 0) || (i2 > 0))
        {
          localHashMap = new HashMap(4);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i1);
          localStringBuilder.append("");
          localHashMap.put("load_time", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i2);
          localStringBuilder.append("");
          localHashMap.put("hit_time", localStringBuilder.toString());
          StatisticCollector.getInstance(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).collectPerformance(null, "AIOWebShortLink", false, 0L, 0L, localHashMap, "", false);
        }
        i1 = localSharedPreferences.getInt("load_safeCheck", 0);
        localEditor.putInt("load_safeCheck", 0);
        i2 = localSharedPreferences.getInt("hit_safeCheck", 0);
        localEditor.putInt("hit_safeCheck", 0);
        if ((i1 > 0) || (i2 > 0))
        {
          localHashMap = new HashMap(4);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i1);
          localStringBuilder.append("");
          localHashMap.put("load_time", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i2);
          localStringBuilder.append("");
          localHashMap.put("hit_time", localStringBuilder.toString());
          StatisticCollector.getInstance(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).collectPerformance(null, "AIOWebSafeCheck", false, 0L, 0L, localHashMap, "", false);
        }
        localEditor.commit();
      }
      return localSharedPreferences;
    }
    finally {}
  }
  
  public final String b(String paramString)
  {
    Object localObject1;
    DiskLruCache.Editor localEditor2;
    DiskLruCache.Editor localEditor1;
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return paramString;
      }
      if ((this.k) && (b) && (BaseOpenWebMonitor.a(paramString)))
      {
        localObject1 = a(paramString);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          str1 = h(paramString);
          if (str1 != null)
          {
            if (str1.equals("")) {
              return paramString;
            }
            localObject1 = b();
            int i1 = ((SharedPreferences)localObject1).getInt("load_shortLink", 0);
            ((SharedPreferences)localObject1).edit().putInt("load_shortLink", i1 + 1).commit();
            localEditor2 = null;
            localObject2 = null;
            localObject1 = localObject2;
            localEditor1 = localEditor2;
          }
        }
      }
    }
    try
    {
      String str2 = Md5Utils.getMD5(paramString);
      localObject1 = localObject2;
      localEditor1 = localEditor2;
      localEditor2 = this.l.edit(str2);
      if (localEditor2 != null)
      {
        localObject1 = localEditor2;
        localEditor1 = localEditor2;
        localEditor2.set(0, str1);
        localObject1 = localEditor2;
        localEditor1 = localEditor2;
        localEditor2.commit();
      }
      else
      {
        localObject1 = localEditor2;
        localEditor1 = localEditor2;
        if (QLog.isColorLevel())
        {
          localObject1 = localEditor2;
          localEditor1 = localEditor2;
          QLog.d("WebAccelerator", 2, "fail to open cache.Editor");
        }
      }
      localObject1 = localEditor2;
      localObject2 = str1;
      localEditor1 = localEditor2;
      if (!QLog.isColorLevel()) {
        break label414;
      }
      localObject1 = localEditor2;
      localEditor1 = localEditor2;
      localObject2 = AIOUtils.a();
      localObject1 = localEditor2;
      localEditor1 = localEditor2;
      ((StringBuilder)localObject2).append("doShortLink:");
      localObject1 = localEditor2;
      localEditor1 = localEditor2;
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = localEditor2;
      localEditor1 = localEditor2;
      ((StringBuilder)localObject2).append("   ");
      localObject1 = localEditor2;
      localEditor1 = localEditor2;
      ((StringBuilder)localObject2).append(str1);
      localObject1 = localEditor2;
      localEditor1 = localEditor2;
      QLog.d("WebAccelerator", 2, ((StringBuilder)localObject2).toString());
      return str1;
    }
    catch (IOException paramString)
    {
      if (!QLog.isColorLevel()) {
        break label373;
      }
      QLog.e("WebAccelerator", 2, "doShortLink", paramString);
      localObject2 = str1;
      if (localIOException == null) {
        break label414;
      }
      try
      {
        localIOException.abort();
        return str1;
      }
      catch (IOException paramString)
      {
        localObject2 = str1;
        if (!QLog.isColorLevel()) {
          break label414;
        }
      }
      QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", paramString);
      return str1;
      return paramString;
      return localObject2;
      return paramString;
    }
    catch (Exception localException)
    {
      label325:
      break label325;
    }
    if (localEditor1 != null) {
      try
      {
        localEditor1.abort();
        return paramString;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", localIOException);
        }
      }
    }
    return paramString;
  }
  
  public final void b(String arg1, int paramInt, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(???))
    {
      if (!b) {
        return;
      }
      String str = ???.trim();
      synchronized (this.i)
      {
        if (this.h.contains(str)) {
          return;
        }
        this.h.add(str);
        int i2 = HttpUtil.getNetWorkType();
        int i1 = 4;
        if (i2 != 1)
        {
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 4)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("WebAccelerator", 2, "unknown network type , not use accelerator");
                }
                return;
              }
              i1 = 8;
            }
          }
          else {
            i1 = 2;
          }
        }
        else {
          i1 = 1;
        }
        if ((a(i1)) && (c()))
        {
          if (a(16)) {
            ??? = b(str);
          } else {
            ??? = str;
          }
          if (a(32)) {
            a(???, paramInt, paramString2, paramString3);
          }
          if (a(64)) {
            d(???);
          }
        }
        synchronized (this.i)
        {
          this.h.remove(str);
          return;
        }
      }
    }
  }
  
  /* Error */
  public final boolean c(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_1
    //   7: ifnull +346 -> 353
    //   10: aload_1
    //   11: ldc_w 437
    //   14: invokevirtual 441	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 75	com/tencent/mobileqq/activity/WebAccelerator:k	Z
    //   26: ifeq +327 -> 353
    //   29: getstatic 51	com/tencent/mobileqq/activity/WebAccelerator:b	Z
    //   32: ifne +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aconst_null
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 9
    //   43: aload_1
    //   44: invokestatic 663	com/tencent/smtt/utils/Md5Utils:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 11
    //   49: iload 5
    //   51: istore_3
    //   52: aload_0
    //   53: getfield 77	com/tencent/mobileqq/activity/WebAccelerator:l	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   56: aload 11
    //   58: invokevirtual 666	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   61: astore 10
    //   63: iload 4
    //   65: istore_2
    //   66: aload 10
    //   68: ifnull +85 -> 153
    //   71: aload 10
    //   73: astore 9
    //   75: iload 5
    //   77: istore_3
    //   78: aload 10
    //   80: astore 8
    //   82: aload 10
    //   84: iconst_0
    //   85: invokevirtual 671	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   88: invokestatic 881	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   91: lstore 6
    //   93: goto +6 -> 99
    //   96: lconst_0
    //   97: lstore 6
    //   99: aload 10
    //   101: astore 9
    //   103: iload 5
    //   105: istore_3
    //   106: aload 10
    //   108: astore 8
    //   110: invokestatic 691	android/os/SystemClock:uptimeMillis	()J
    //   113: lload 6
    //   115: lsub
    //   116: aload_0
    //   117: getfield 73	com/tencent/mobileqq/activity/WebAccelerator:j	J
    //   120: lcmp
    //   121: ifge +8 -> 129
    //   124: iconst_1
    //   125: istore_2
    //   126: goto +27 -> 153
    //   129: aload 10
    //   131: astore 9
    //   133: iload 5
    //   135: istore_3
    //   136: aload 10
    //   138: astore 8
    //   140: aload_0
    //   141: getfield 77	com/tencent/mobileqq/activity/WebAccelerator:l	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   144: aload 11
    //   146: invokevirtual 883	com/jakewharton/disklrucache/DiskLruCache:remove	(Ljava/lang/String;)Z
    //   149: pop
    //   150: iload 4
    //   152: istore_2
    //   153: aload 10
    //   155: astore 9
    //   157: iload_2
    //   158: istore_3
    //   159: aload 10
    //   161: astore 8
    //   163: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +111 -> 277
    //   169: aload 10
    //   171: astore 9
    //   173: iload_2
    //   174: istore_3
    //   175: aload 10
    //   177: astore 8
    //   179: invokestatic 159	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   182: astore 11
    //   184: aload 10
    //   186: astore 9
    //   188: iload_2
    //   189: istore_3
    //   190: aload 10
    //   192: astore 8
    //   194: aload 11
    //   196: ldc_w 885
    //   199: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 10
    //   205: astore 9
    //   207: iload_2
    //   208: istore_3
    //   209: aload 10
    //   211: astore 8
    //   213: aload 11
    //   215: aload_1
    //   216: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 10
    //   222: astore 9
    //   224: iload_2
    //   225: istore_3
    //   226: aload 10
    //   228: astore 8
    //   230: aload 11
    //   232: ldc_w 492
    //   235: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 10
    //   241: astore 9
    //   243: iload_2
    //   244: istore_3
    //   245: aload 10
    //   247: astore 8
    //   249: aload 11
    //   251: iload_2
    //   252: invokevirtual 490	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 10
    //   258: astore 9
    //   260: iload_2
    //   261: istore_3
    //   262: aload 10
    //   264: astore 8
    //   266: ldc 126
    //   268: iconst_2
    //   269: aload 11
    //   271: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: iload_2
    //   278: istore 4
    //   280: aload 10
    //   282: ifnull +56 -> 338
    //   285: aload 10
    //   287: astore 8
    //   289: aload 8
    //   291: invokevirtual 676	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   294: iload_2
    //   295: ireturn
    //   296: astore_1
    //   297: goto +44 -> 341
    //   300: astore_1
    //   301: aload 8
    //   303: astore 9
    //   305: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +17 -> 325
    //   311: aload 8
    //   313: astore 9
    //   315: ldc 126
    //   317: iconst_2
    //   318: ldc_w 887
    //   321: aload_1
    //   322: invokestatic 656	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   325: iload_3
    //   326: istore 4
    //   328: aload 8
    //   330: ifnull +8 -> 338
    //   333: iload_3
    //   334: istore_2
    //   335: goto -46 -> 289
    //   338: iload 4
    //   340: ireturn
    //   341: aload 9
    //   343: ifnull +8 -> 351
    //   346: aload 9
    //   348: invokevirtual 676	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   351: aload_1
    //   352: athrow
    //   353: iconst_0
    //   354: ireturn
    //   355: astore 8
    //   357: goto -261 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	WebAccelerator
    //   0	360	1	paramString	String
    //   65	270	2	bool1	boolean
    //   51	283	3	bool2	boolean
    //   4	335	4	bool3	boolean
    //   1	133	5	bool4	boolean
    //   91	23	6	l1	long
    //   38	291	8	localObject1	Object
    //   355	1	8	localNumberFormatException	java.lang.NumberFormatException
    //   41	306	9	localObject2	Object
    //   61	225	10	localSnapshot	com.jakewharton.disklrucache.DiskLruCache.Snapshot
    //   47	223	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	63	296	finally
    //   82	93	296	finally
    //   110	124	296	finally
    //   140	150	296	finally
    //   163	169	296	finally
    //   179	184	296	finally
    //   194	203	296	finally
    //   213	220	296	finally
    //   230	239	296	finally
    //   249	256	296	finally
    //   266	277	296	finally
    //   305	311	296	finally
    //   315	325	296	finally
    //   52	63	300	java/io/IOException
    //   82	93	300	java/io/IOException
    //   110	124	300	java/io/IOException
    //   140	150	300	java/io/IOException
    //   163	169	300	java/io/IOException
    //   179	184	300	java/io/IOException
    //   194	203	300	java/io/IOException
    //   213	220	300	java/io/IOException
    //   230	239	300	java/io/IOException
    //   249	256	300	java/io/IOException
    //   266	277	300	java/io/IOException
    //   82	93	355	java/lang/NumberFormatException
  }
  
  public final boolean d(String paramString)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return false;
      }
      if (!b) {
        return false;
      }
      String str = CGILoader.b(paramString);
      boolean bool1;
      try
      {
        InetAddress.getByName(str);
        bool1 = true;
      }
      catch (SecurityException localSecurityException)
      {
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("WebAccelerator", 2, "doDNS", localSecurityException);
          bool1 = bool3;
        }
      }
      catch (UnknownHostException localUnknownHostException)
      {
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("WebAccelerator", 2, "doDNS", localUnknownHostException);
          bool1 = bool3;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = AIOUtils.a();
        localStringBuilder.append("doDNS:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("   ");
        localStringBuilder.append(bool1);
        QLog.d("WebAccelerator", 2, localStringBuilder.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public final void e(String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("WebAccelerator", 0);
      int i1 = localSharedPreferences.getInt(paramString, 0);
      if (i1 > 0) {
        localSharedPreferences.edit().putInt(paramString, i1 - 1).commit();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.WebAccelerator
 * JD-Core Version:    0.7.0.1
 */