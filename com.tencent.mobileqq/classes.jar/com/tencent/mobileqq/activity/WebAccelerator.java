package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider.SosoSrvAddrType;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import common.config.service.QzoneConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import uip;

public class WebAccelerator
{
  public static int a;
  private static WebAccelerator jdField_a_of_type_ComTencentMobileqqActivityWebAccelerator;
  static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(Patterns.d.pattern());
  public static boolean a;
  public static boolean b;
  private long jdField_a_of_type_Long = 86400000L;
  private DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  private Map jdField_a_of_type_JavaUtilMap;
  private Set jdField_a_of_type_JavaUtilSet;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int b = 15;
  private int jdField_c_of_type_Int = 10;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = -1;
  }
  
  public WebAccelerator()
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    SosoSrvAddrProvider.a().b();
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerator", 2, "DPC:" + str);
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length <= 5) {}
    }
    for (;;)
    {
      try
      {
        this.d = Integer.parseInt(arrayOfString[4]);
        this.jdField_a_of_type_Long = (Integer.parseInt(arrayOfString[5]) * 1000 * 60 * 60);
        if (arrayOfString.length > 6) {
          this.jdField_c_of_type_Int = Integer.parseInt(arrayOfString[6]);
        }
        i = j;
        if (this.jdField_c_of_type_Int > 30)
        {
          this.jdField_c_of_type_Int = 10;
          i = j;
        }
        if ((i == 0) && (QLog.isColorLevel())) {
          QLog.d("WebAccelerator", 2, "DPC not catch success[" + str + "]");
        }
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        try
        {
          this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open(((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getApp().getCacheDir(), 1, 1, 1048576L);
          return;
        }
        catch (Exception localException1)
        {
          this.jdField_c_of_type_Boolean = false;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
        return;
      }
      catch (Exception localException2)
      {
        this.jdField_c_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("WebAccelerator", 2, "WebAccelerator init fail");
        }
      }
      int i = 0;
    }
  }
  
  public static WebAccelerator a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWebAccelerator == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWebAccelerator = new WebAccelerator();
      }
      WebAccelerator localWebAccelerator = jdField_a_of_type_ComTencentMobileqqActivityWebAccelerator;
      return localWebAccelerator;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      ThreadManager.post(new uip(paramString, paramIntent, paramContext), 8, null, false);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  private final boolean a()
  {
    boolean bool = false;
    try
    {
      Object localObject1 = a();
      int j = ((SharedPreferences)localObject1).getInt("bankSize", 0);
      int i = j;
      if (j < this.b)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        i = j + 1;
        ((SharedPreferences.Editor)localObject1).putInt("bankSize", i);
        ((SharedPreferences.Editor)localObject1).commit();
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebAccelerator", 2, "shouldUseAccelerator:" + bool + "   " + i);
      }
      return bool;
    }
    finally {}
  }
  
  private final boolean a(int paramInt)
  {
    return (this.d & paramInt) == paramInt;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramChatMessage.isSend())
    {
      if (!(paramChatMessage instanceof MessageForStructing)) {
        break label54;
      }
      AbsStructMsg localAbsStructMsg2 = ((MessageForStructing)paramChatMessage).structingMsg;
      AbsStructMsg localAbsStructMsg1 = localAbsStructMsg2;
      if (localAbsStructMsg2 == null) {
        localAbsStructMsg1 = StructMsgFactory.a(paramChatMessage.msgData);
      }
      if (!a(localAbsStructMsg1)) {
        break label106;
      }
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      label54:
      bool1 = bool2;
      if ((paramChatMessage instanceof MessageForText))
      {
        paramChatMessage = (MessageForText)paramChatMessage;
        bool1 = bool2;
        if (paramChatMessage.msg != null)
        {
          bool1 = bool2;
          if (!paramChatMessage.msg.equals(""))
          {
            bool1 = bool2;
            if (c(paramChatMessage.msg) != null)
            {
              return true;
              label106:
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public static final boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return (paramAbsStructMsg != null) && ("web".equals(paramAbsStructMsg.mMsgAction)) && ((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (!CGILoader.a((AbsShareMsg)paramAbsStructMsg));
  }
  
  private static boolean b(Context paramContext, String paramString, Intent paramIntent)
  {
    boolean bool2 = false;
    String str1 = QzoneConfig.getInstance().getConfig("QZVideo", "qzonelivevideo_livehost", "h5.qzone.qq.com/live/video/qzone/");
    int i = QzoneConfig.getInstance().getConfig("QZVideo", "module_jump_native", 1);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setPackage("com.tencent.mobileqq");
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.contains(str1))
      {
        try
        {
          Uri localUri = Uri.parse(paramString);
          String str2 = localUri.getQueryParameter("stayin");
          if ((i != 1) || ((str2 != null) && (TextUtils.equals(str2, "1"))))
          {
            QLog.d("WebAccelerator", 1, "is_native not available, jump to H5, " + paramString);
            paramString = new Intent(paramContext, QQBrowserActivity.class);
            paramString.putExtra("url", localUri.toString());
            paramString.setData(localUri);
            paramContext.startActivity(paramString);
            return true;
          }
          paramIntent = paramIntent.getStringExtra("self_uin");
          i = paramString.lastIndexOf(str1);
          str1 = paramString.substring(str1.length() + i, paramString.length()).split("/")[0];
          bool1 = bool2;
          if (paramIntent == null) {
            break label418;
          }
          bool1 = bool2;
          if (str1 == null) {
            break label418;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(paramIntent)) {
            break label418;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(str1)) {
            break label418;
          }
          if (!d(str1))
          {
            QLog.d("WebAccelerator", 2, "room_id not number!");
            return false;
          }
        }
        catch (Exception paramContext)
        {
          QLog.d("WebAccelerator", 1, "getQzoneVideoIntent parse url error!");
          return false;
        }
        localStringBuilder.append("mqqzone://arouse/livevideo").append("?room=" + str1).append("&uin=" + paramIntent).append("&video_play_source=12").append("&backup=" + URLEncoder.encode(paramString));
        localIntent.setData(Uri.parse(localStringBuilder.toString()));
        paramContext.startActivity(localIntent);
        bool1 = true;
      }
    }
    label418:
    return bool1;
  }
  
  public static String c(String paramString)
  {
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    String str = null;
    if (localMatcher.find()) {
      str = paramString.substring(localMatcher.start(), localMatcher.end());
    }
    return str;
  }
  
  public static final boolean c(String paramString)
  {
    return (paramString.startsWith("http://url.cn/")) || (paramString.startsWith("http%3A%2F%2Furl.cn%2F"));
  }
  
  private final String d(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      str1 = str2;
      localHttpURLConnection.setInstanceFollowRedirects(false);
      str1 = str2;
      localHttpURLConnection.connect();
      str1 = str2;
      paramString = localHttpURLConnection.getHeaderField("Location");
      str1 = paramString;
      QLog.d("WebAccelerator", 2, "code:" + localHttpURLConnection.getResponseCode());
    }
    catch (Exception localException)
    {
      do
      {
        paramString = str1;
      } while (!QLog.isColorLevel());
      QLog.e("WebAccelerator", 2, "doRedirect", localException);
    }
    return paramString;
    return str1;
  }
  
  public static boolean d(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  /* Error */
  public final SharedPreferences a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 474	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: ldc 89
    //   7: iconst_0
    //   8: invokevirtual 478	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: astore 5
    //   13: aload 5
    //   15: ldc_w 480
    //   18: lconst_0
    //   19: invokeinterface 484 4 0
    //   24: lstore_3
    //   25: lload_3
    //   26: lconst_0
    //   27: lcmp
    //   28: ifne +39 -> 67
    //   31: aload 5
    //   33: invokeinterface 217 1 0
    //   38: astore 6
    //   40: aload 6
    //   42: ldc_w 480
    //   45: invokestatic 490	java/lang/System:currentTimeMillis	()J
    //   48: invokeinterface 494 4 0
    //   53: pop
    //   54: aload 6
    //   56: invokeinterface 226 1 0
    //   61: pop
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: areturn
    //   67: invokestatic 490	java/lang/System:currentTimeMillis	()J
    //   70: lload_3
    //   71: lsub
    //   72: ldc2_w 52
    //   75: lcmp
    //   76: ifle -14 -> 62
    //   79: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +12 -> 94
    //   85: ldc 89
    //   87: iconst_2
    //   88: ldc_w 496
    //   91: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload 5
    //   96: invokeinterface 217 1 0
    //   101: astore 6
    //   103: aload 6
    //   105: ldc_w 480
    //   108: invokestatic 490	java/lang/System:currentTimeMillis	()J
    //   111: invokeinterface 494 4 0
    //   116: pop
    //   117: aload 6
    //   119: ldc 207
    //   121: iconst_0
    //   122: invokeinterface 223 3 0
    //   127: pop
    //   128: aload 6
    //   130: ldc_w 498
    //   133: iconst_0
    //   134: invokeinterface 223 3 0
    //   139: pop
    //   140: aload_0
    //   141: getfield 145	com/tencent/mobileqq/activity/WebAccelerator:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   144: invokeinterface 503 1 0
    //   149: aload 5
    //   151: ldc_w 505
    //   154: iconst_0
    //   155: invokeinterface 213 3 0
    //   160: istore_1
    //   161: aload 6
    //   163: ldc_w 505
    //   166: iconst_0
    //   167: invokeinterface 223 3 0
    //   172: pop
    //   173: aload 5
    //   175: ldc_w 507
    //   178: iconst_0
    //   179: invokeinterface 213 3 0
    //   184: istore_2
    //   185: aload 6
    //   187: ldc_w 507
    //   190: iconst_0
    //   191: invokeinterface 223 3 0
    //   196: pop
    //   197: iload_1
    //   198: ifgt +7 -> 205
    //   201: iload_2
    //   202: ifle +93 -> 295
    //   205: new 142	java/util/HashMap
    //   208: dup
    //   209: iconst_4
    //   210: invokespecial 510	java/util/HashMap:<init>	(I)V
    //   213: astore 7
    //   215: aload 7
    //   217: ldc_w 512
    //   220: new 91	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   227: iload_1
    //   228: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 271
    //   234: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 516	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: aload 7
    //   246: ldc_w 518
    //   249: new 91	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   256: iload_2
    //   257: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: ldc_w 271
    //   263: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokevirtual 516	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   272: pop
    //   273: invokestatic 524	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   276: invokestatic 529	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   279: aconst_null
    //   280: ldc_w 531
    //   283: iconst_0
    //   284: lconst_0
    //   285: lconst_0
    //   286: aload 7
    //   288: ldc_w 271
    //   291: iconst_0
    //   292: invokevirtual 534	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   295: aload 5
    //   297: ldc_w 536
    //   300: iconst_0
    //   301: invokeinterface 213 3 0
    //   306: istore_1
    //   307: aload 6
    //   309: ldc_w 536
    //   312: iconst_0
    //   313: invokeinterface 223 3 0
    //   318: pop
    //   319: aload 5
    //   321: ldc_w 538
    //   324: iconst_0
    //   325: invokeinterface 213 3 0
    //   330: istore_2
    //   331: aload 6
    //   333: ldc_w 538
    //   336: iconst_0
    //   337: invokeinterface 223 3 0
    //   342: pop
    //   343: iload_1
    //   344: ifgt +7 -> 351
    //   347: iload_2
    //   348: ifle +93 -> 441
    //   351: new 142	java/util/HashMap
    //   354: dup
    //   355: iconst_4
    //   356: invokespecial 510	java/util/HashMap:<init>	(I)V
    //   359: astore 7
    //   361: aload 7
    //   363: ldc_w 512
    //   366: new 91	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   373: iload_1
    //   374: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: ldc_w 271
    //   380: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokevirtual 516	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   389: pop
    //   390: aload 7
    //   392: ldc_w 518
    //   395: new 91	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   402: iload_2
    //   403: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: ldc_w 271
    //   409: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokevirtual 516	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: invokestatic 524	com/tencent/mobileqq/mqsafeedit/BaseApplication:getContext	()Landroid/content/Context;
    //   422: invokestatic 529	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   425: aconst_null
    //   426: ldc_w 540
    //   429: iconst_0
    //   430: lconst_0
    //   431: lconst_0
    //   432: aload 7
    //   434: ldc_w 271
    //   437: iconst_0
    //   438: invokevirtual 534	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   441: aload 6
    //   443: invokeinterface 226 1 0
    //   448: pop
    //   449: goto -387 -> 62
    //   452: astore 5
    //   454: aload_0
    //   455: monitorexit
    //   456: aload 5
    //   458: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	WebAccelerator
    //   160	214	1	i	int
    //   184	219	2	j	int
    //   24	47	3	l	long
    //   11	309	5	localSharedPreferences	SharedPreferences
    //   452	5	5	localObject	Object
    //   38	404	6	localEditor	SharedPreferences.Editor
    //   213	220	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   2	25	452	finally
    //   31	62	452	finally
    //   67	94	452	finally
    //   94	197	452	finally
    //   205	295	452	finally
    //   295	343	452	finally
    //   351	441	452	finally
    //   441	449	452	finally
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_1
    //   12: ifnull +13 -> 25
    //   15: aload_1
    //   16: ldc_w 271
    //   19: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +7 -> 29
    //   25: aload_1
    //   26: astore_2
    //   27: aload_2
    //   28: areturn
    //   29: aload 4
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 57	com/tencent/mobileqq/activity/WebAccelerator:jdField_c_of_type_Boolean	Z
    //   36: ifeq -9 -> 27
    //   39: aload 4
    //   41: astore_2
    //   42: getstatic 37	com/tencent/mobileqq/activity/WebAccelerator:jdField_a_of_type_Boolean	Z
    //   45: ifeq -18 -> 27
    //   48: aload_1
    //   49: invokestatic 547	com/tencent/smtt/utils/Md5Utils:getMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 177	com/tencent/mobileqq/activity/WebAccelerator:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   57: aload_2
    //   58: invokevirtual 551	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +17 -> 82
    //   68: aload 4
    //   70: astore_2
    //   71: aload 6
    //   73: astore 5
    //   75: aload 4
    //   77: iconst_0
    //   78: invokevirtual 557	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   81: astore_3
    //   82: aload 4
    //   84: astore_2
    //   85: aload_3
    //   86: astore 5
    //   88: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +40 -> 131
    //   94: aload 4
    //   96: astore_2
    //   97: aload_3
    //   98: astore 5
    //   100: ldc 89
    //   102: iconst_2
    //   103: invokestatic 131	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   106: ldc_w 559
    //   109: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 233
    //   118: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_3
    //   132: astore_2
    //   133: aload 4
    //   135: ifnull -108 -> 27
    //   138: aload 4
    //   140: invokevirtual 562	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   143: aload_3
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore 4
    //   149: aload 5
    //   151: astore_1
    //   152: aload 4
    //   154: astore_2
    //   155: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +16 -> 174
    //   161: aload 4
    //   163: astore_2
    //   164: ldc 89
    //   166: iconst_2
    //   167: ldc_w 564
    //   170: aload_3
    //   171: invokestatic 463	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_1
    //   175: astore_2
    //   176: aload 4
    //   178: ifnull -151 -> 27
    //   181: aload 4
    //   183: invokevirtual 562	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   186: aload_1
    //   187: areturn
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_2
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 562	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: goto -11 -> 191
    //   205: astore_3
    //   206: aload 5
    //   208: astore_1
    //   209: goto -57 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	WebAccelerator
    //   0	212	1	paramString	String
    //   26	170	2	localObject1	Object
    //   1	143	3	str	String
    //   145	26	3	localIOException1	IOException
    //   205	1	3	localIOException2	IOException
    //   9	173	4	localSnapshot	DiskLruCache.Snapshot
    //   3	204	5	localObject2	Object
    //   6	66	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   53	63	145	java/io/IOException
    //   53	63	188	finally
    //   75	82	201	finally
    //   88	94	201	finally
    //   100	131	201	finally
    //   155	161	201	finally
    //   164	174	201	finally
    //   75	82	205	java/io/IOException
    //   88	94	205	java/io/IOException
    //   100	131	205	java/io/IOException
  }
  
  public final void a(String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("WebAccelerator", 0);
      int i = localSharedPreferences.getInt(paramString, 0);
      if (i > 0) {
        localSharedPreferences.edit().putInt(paramString, i - 1).commit();
      }
      return;
    }
    finally {}
  }
  
  public final void a(String arg1, int paramInt, String paramString2, String paramString3)
  {
    int i = 2;
    if ((TextUtils.isEmpty(???)) || (!jdField_a_of_type_Boolean)) {}
    String str;
    do
    {
      return;
      str = ???.trim();
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilSet.add(str);
      switch (HttpUtil.a())
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "unknown network type , not use accelerator");
    return;
    i = 4;
    if ((a(i)) && (a())) {
      if (!a(16)) {
        break label225;
      }
    }
    label225:
    for (??? = b(str);; ??? = str)
    {
      if (a(32)) {
        a(???, paramInt, paramString2, paramString3);
      }
      if (a(64)) {
        b(???);
      }
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilSet.remove(str);
        return;
      }
      i = 8;
      break;
      i = 1;
      break;
    }
  }
  
  public final boolean a(String paramString)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (!paramString.equals("")) {
        break label28;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      label28:
      bool2 = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        continue;
      }
      bool2 = bool1;
      if (!jdField_a_of_type_Boolean) {
        continue;
      }
      Object localObject3 = null;
      Object localObject1 = null;
      String str = Md5Utils.getMD5(paramString);
      boolean bool3 = bool5;
      try
      {
        DiskLruCache.Snapshot localSnapshot = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.get(str);
        bool1 = bool4;
        if (localSnapshot != null)
        {
          bool3 = bool5;
          localObject1 = localSnapshot;
          localObject3 = localSnapshot;
        }
        try
        {
          l = Long.parseLong(localSnapshot.getString(0));
          bool3 = bool5;
          localObject1 = localSnapshot;
          localObject3 = localSnapshot;
          if (SystemClock.uptimeMillis() - l < this.jdField_a_of_type_Long)
          {
            bool1 = true;
            bool3 = bool1;
            localObject1 = localSnapshot;
            localObject3 = localSnapshot;
            if (QLog.isColorLevel())
            {
              bool3 = bool1;
              localObject1 = localSnapshot;
              localObject3 = localSnapshot;
              QLog.d("WebAccelerator", 2, "isSafeCheck:" + paramString + "   " + bool1);
            }
            bool2 = bool1;
            return bool1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            long l = 0L;
            continue;
            bool3 = bool5;
            localObject2 = localSnapshot;
            localObject3 = localSnapshot;
            this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.remove(str);
            bool1 = bool4;
          }
        }
      }
      catch (IOException paramString)
      {
        Object localObject2;
        localObject3 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject3 = localObject2;
          QLog.e("WebAccelerator", 2, "isSafeCheck fail", paramString);
        }
        bool2 = bool3;
        return bool3;
      }
      finally
      {
        if (localObject3 != null) {
          localObject3.close();
        }
      }
    }
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramString1 != null)
    {
      if (!paramString1.equals("")) {
        break label31;
      }
      bool2 = bool3;
    }
    label31:
    do
    {
      return bool2;
      if ((this.jdField_c_of_type_Boolean) && (jdField_a_of_type_Boolean) && (!paramString1.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) && (!paramString1.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) && (!a(paramString1))) {
        break;
      }
      bool2 = bool3;
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "no need doSafeCheck");
    return false;
    for (;;)
    {
      Object localObject2;
      try
      {
        i = (int)SystemClock.uptimeMillis() % 2;
        localObject1 = SosoPlugin.a;
        if (i > -1)
        {
          localObject2 = localObject1[i];
          String str = SosoSrvAddrProvider.a().a(SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV);
          localObject1 = localObject2;
          if (str != null)
          {
            localObject1 = localObject2;
            if (str.length() > 0) {
              localObject1 = ((String)localObject2).replaceFirst("http://[^/\\s]*/", str);
            }
          }
          localObject2 = AIOUtils.a();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("&u=");
          ((StringBuilder)localObject2).append(URLEncoder.encode(paramString1, "UTF-8"));
          ((StringBuilder)localObject2).append("&wap=3");
          switch (paramInt)
          {
          case 0: 
            ((StringBuilder)localObject2).append("&qq-pf-to=mqq.temporaryc2c");
            if (!TextUtils.isEmpty(paramString2)) {
              ((StringBuilder)localObject2).append("&uin=").append(paramString2);
            }
            if (!TextUtils.isEmpty(paramString3)) {
              ((StringBuilder)localObject2).append("&originuin=").append(paramString3);
            }
            localObject1 = ((StringBuilder)localObject2).toString();
            paramString2 = d((String)localObject1);
            paramString3 = a();
            paramInt = paramString3.getInt("load_safeCheck", 0);
            paramString3.edit().putInt("load_safeCheck", paramInt + 1).commit();
            if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(paramString1))) {
              break label695;
            }
            paramString2 = null;
            paramString3 = null;
            localObject2 = Md5Utils.getMD5(paramString1);
            paramString1 = paramString3;
          }
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        int i;
        Object localObject1;
        bool2 = bool3;
      }
      try
      {
        paramString3 = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.edit((String)localObject2);
        if (paramString3 == null) {
          break label555;
        }
        paramString1 = paramString3;
        paramString2 = paramString3;
        paramString3.set(0, SystemClock.uptimeMillis() + "");
        paramString1 = paramString3;
        paramString2 = paramString3;
        paramString3.commit();
        bool1 = true;
      }
      catch (IOException paramString2)
      {
        if (!QLog.isColorLevel()) {
          break label610;
        }
        QLog.d("WebAccelerator", 2, "doSafeCheck", paramString2);
        bool1 = bool4;
        if (paramString1 == null) {
          continue;
        }
        try
        {
          paramString1.abort();
          bool1 = bool4;
        }
        catch (IOException paramString1)
        {
          bool1 = bool4;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("WebAccelerator", 2, "doSafeCheck", paramString1);
        bool1 = bool4;
        continue;
      }
      catch (Exception paramString1)
      {
        bool2 = bool3;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebAccelerator", 2, "doSafeCheck:" + (String)localObject1 + "   " + bool1);
      return bool1;
      i = 0;
      continue;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.c2c");
      continue;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("WebAccelerator", 2, "buildUrl fail", paramString1);
      return false;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.group");
      continue;
      ((StringBuilder)localObject2).append("&qq-pf-to=mqq.discussion");
      continue;
      label555:
      boolean bool1 = bool4;
      paramString1 = paramString3;
      paramString2 = paramString3;
      if (QLog.isColorLevel())
      {
        paramString1 = paramString3;
        paramString2 = paramString3;
        QLog.e("WebAccelerator", 2, "fail to open cache.editor");
        bool1 = bool4;
        continue;
        label610:
        if (paramString2 == null) {
          break;
        }
        try
        {
          paramString2.abort();
          return false;
        }
        catch (IOException paramString1)
        {
          bool2 = bool3;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("WebAccelerator", 2, "doSafeCheck", paramString1);
        return false;
        label695:
        bool1 = bool4;
        if (QLog.isColorLevel())
        {
          QLog.d("WebAccelerator", 2, "doRedirect get fail url");
          bool1 = bool4;
        }
      }
    }
  }
  
  public final String b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    Object localObject2;
    do
    {
      DiskLruCache.Editor localEditor1;
      for (;;)
      {
        return paramString;
        if ((this.jdField_c_of_type_Boolean) && (jdField_a_of_type_Boolean) && (c(paramString)))
        {
          Object localObject1 = a(paramString);
          localObject2 = localObject1;
          if (localObject1 != null) {
            break label371;
          }
          String str1 = d(paramString);
          if ((str1 != null) && (!str1.equals("")))
          {
            localObject1 = a();
            int i = ((SharedPreferences)localObject1).getInt("load_shortLink", 0);
            ((SharedPreferences)localObject1).edit().putInt("load_shortLink", i + 1).commit();
            DiskLruCache.Editor localEditor2 = null;
            localObject2 = null;
            localObject1 = localObject2;
            localEditor1 = localEditor2;
            try
            {
              String str2 = Md5Utils.getMD5(paramString);
              localObject1 = localObject2;
              localEditor1 = localEditor2;
              localEditor2 = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.edit(str2);
              if (localEditor2 != null)
              {
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localEditor2.set(0, str1);
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localEditor2.commit();
              }
              for (;;)
              {
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                localObject2 = str1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                QLog.d("WebAccelerator", 2, "doShortLink:" + paramString + "   " + str1);
                localObject2 = str1;
                break;
                localObject1 = localEditor2;
                localEditor1 = localEditor2;
                if (QLog.isColorLevel())
                {
                  localObject1 = localEditor2;
                  localEditor1 = localEditor2;
                  QLog.d("WebAccelerator", 2, "fail to open cache.Editor");
                }
              }
              if (localEditor1 == null) {}
            }
            catch (IOException paramString)
            {
              if (QLog.isColorLevel()) {
                QLog.e("WebAccelerator", 2, "doShortLink", paramString);
              }
              localObject2 = str1;
              if (localObject1 == null) {
                break label371;
              }
              try
              {
                ((DiskLruCache.Editor)localObject1).abort();
                localObject2 = str1;
              }
              catch (IOException paramString)
              {
                localObject2 = str1;
                if (!QLog.isColorLevel()) {
                  break label371;
                }
              }
              QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", paramString);
              localObject2 = str1;
            }
            catch (Exception localException) {}
          }
        }
      }
      try
      {
        localEditor1.abort();
        return paramString;
      }
      catch (IOException localIOException) {}
    } while (!QLog.isColorLevel());
    QLog.e("WebAccelerator", 2, "doShortLink.editor.abort", localIOException);
    return paramString;
    label371:
    return localObject2;
  }
  
  public final boolean b(String paramString)
  {
    bool3 = false;
    bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      if (!paramString.equals("")) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    do
    {
      do
      {
        return bool2;
        bool2 = bool1;
      } while (!jdField_a_of_type_Boolean);
      String str = CGILoader.a(paramString);
      try
      {
        InetAddress.getByName(str);
        bool1 = true;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        for (;;)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.e("WebAccelerator", 2, "doDNS", localUnknownHostException);
            bool1 = bool3;
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.e("WebAccelerator", 2, "doDNS", localSecurityException);
            bool1 = bool3;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("WebAccelerator", 2, "doDNS:" + paramString + "   " + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.WebAccelerator
 * JD-Core Version:    0.7.0.1
 */