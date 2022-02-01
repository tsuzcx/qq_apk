package com.tencent.biz.pubaccount.ecshopassit;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.activity.recent.msg.RecentUserAppearLogic;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.ecshop.api.IEcshopService;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import mqq.util.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class EcShopAssistantManager
  implements Manager
{
  public static final String a;
  public static final String b;
  public static String h;
  public static String i;
  public static HashMap<String, String> j;
  public static HashMap<String, Long> k;
  public static int l;
  public static final String m;
  public static final String n;
  public static List<String> o;
  public static List<String> p;
  public static String s;
  public static boolean t;
  public static final String u;
  public boolean A = false;
  public boolean B;
  public String[] C = { "https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/haowu.html?_wv=3&max_age=600", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/my.html?_wv=3" };
  BroadcastReceiver D = new EcShopAssistantManager.4(this);
  IFaceDecoder E;
  DecodeTaskCompletionListener F = new EcShopAssistantManager.5(this);
  public boolean G = false;
  public String H = null;
  public String I = null;
  public long J;
  private String K;
  private long L;
  private boolean M = true;
  private boolean N = false;
  private Map<String, EcShopData> O;
  private EcShopAssistantManager.EcShopAssistantDownloadListener P;
  QQAppInterface c;
  public List<EcShopData> d;
  final Object e = new Object();
  final Object f = new Object();
  Set<String> g = new HashSet();
  public int q;
  public int r;
  public boolean v = false;
  public String w;
  public long x;
  public int y;
  public boolean z = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("shop_assit_banner_json.txt");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".shop_assit/image/");
    b = localStringBuilder.toString();
    h = "";
    i = "";
    j = new HashMap();
    k = new HashMap();
    l = 600000;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqshp_client_log_wl_conf.json");
    m = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqshp_client_log_jd_conf.json");
    n = localStringBuilder.toString();
    o = null;
    p = null;
    t = true;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir().getAbsoluteFile());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("animConfig/red_packet.png");
    u = localStringBuilder.toString();
  }
  
  public EcShopAssistantManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.K = paramQQAppInterface.getCurrentAccountUin();
    this.O = new HashMap();
    synchronized (this.e)
    {
      this.d = null;
      ThreadManager.post(new EcShopAssistantManager.1(this), 5, null, true);
      this.E = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
      this.E.setDecodeTaskCompletionListener(this.F);
      this.P = new EcShopAssistantManager.EcShopAssistantDownloadListener(this);
      return;
    }
  }
  
  public static Drawable a(Context paramContext)
  {
    if (!TextUtils.isEmpty(i))
    {
      Object localObject1 = paramContext.getResources().getDrawable(2130839696);
      Object localObject2 = i.split("/");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(b);
      ((StringBuilder)localObject3).append(localObject2[(localObject2.length - 1)]);
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = i;
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_icon", (String)localObject3, (String)localObject2), (Drawable)localObject1, (Drawable)localObject1);
        return localObject1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return paramContext.getResources().getDrawable(2130848921);
      }
    }
    return paramContext.getResources().getDrawable(2130848921);
  }
  
  public static String a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    Object localObject = p;
    if (((localObject != null) && (((List)localObject).contains(paramString1))) || ((((IEcshopService)paramQQAppInterface.getRuntimeService(IEcshopService.class)).isInWalletGTKList(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString2.contains("qq.com"))))
    {
      paramString1 = "&g_tk=";
      if (paramString2.contains("&g_tk=")) {
        return paramString2;
      }
      paramQQAppInterface = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getCurrentAccountUin());
      localObject = new StringBuilder(paramString2);
      if (!paramString2.contains("?")) {
        paramString1 = "?g_tk=";
      }
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(String.valueOf(TroopUtils.a(paramQQAppInterface)));
      return ((StringBuilder)localObject).toString();
    }
    return paramString2;
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = this.f;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.g.contains(paramString))) {
        this.g.add(paramString);
      }
      o();
      return;
    }
    finally {}
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.f)
    {
      if ((paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0) && (!this.g.contains(paramString))) {
        this.g.add(paramString);
      }
      o();
      return;
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.O)
    {
      EcShopData localEcShopData = (EcShopData)this.O.remove(paramString);
      synchronized (this.e)
      {
        if (this.d != null) {
          this.d.remove(localEcShopData);
        }
        boolean bool;
        if (localEcShopData != null) {
          bool = paramEntityManager.remove(localEcShopData);
        } else {
          bool = false;
        }
        paramEntityManager = new StringBuilder();
        paramEntityManager.append("removeEcShopData puin: ");
        paramEntityManager.append(paramString);
        QLog.d("EcShopAssistantManager", 2, paramEntityManager.toString());
        if (this.G)
        {
          paramEntityManager = new Intent("action_on_shop_msg_receive");
          paramEntityManager.putParcelableArrayListExtra("datas", (ArrayList)k());
          BaseApplicationImpl.getContext().sendBroadcast(paramEntityManager);
        }
        return bool;
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().g();
    paramString = paramQQAppInterface.c(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.a(paramString);
    }
  }
  
  private boolean b(long paramLong)
  {
    Object localObject1 = this.c;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    localObject1 = this.c.getProxyManager().g();
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return false;
      }
      if ((this.M) && (!this.N))
      {
        localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
        if (((RecentUser)localObject2).lastmsgtime < paramLong) {
          ((RecentUser)localObject2).lastmsgtime = paramLong;
        }
        EcShopData localEcShopData = c();
        if (localEcShopData != null)
        {
          ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
          ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
        }
        else if (this.B)
        {
          ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
        }
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
        QLog.d("EcShopAssistantManager", 2, "update ecshop folder...");
      }
      else
      {
        localObject2 = ((RecentUserProxy)localObject1).c(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
        if (localObject2 != null) {
          ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
        }
        QLog.d("EcShopAssistantManager", 2, "del ecshop folder...");
      }
      localObject1 = this.c.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
      return true;
    }
    return false;
  }
  
  private void c(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.getApp().getSharedPreferences(this.c.getAccount(), 0).edit().putBoolean("is_update_ec_shop_assist", paramBoolean).commit();
  }
  
  private void e(String paramString)
  {
    synchronized (this.f)
    {
      if ((this.c.getConversationFacade().a(paramString, 1008) > 0) && (this.g.contains(paramString))) {
        this.g.remove(paramString);
      }
      o();
      return;
    }
  }
  
  public static SharedPreferences j()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "noLogin";
    }
    localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ecshop_sp");
    localStringBuilder.append((String)localObject1);
    return ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  /* Error */
  private void n()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 207	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 540	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   11: invokevirtual 546	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 4
    //   21: astore_2
    //   22: aload 4
    //   24: ldc_w 382
    //   27: iconst_0
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: ldc_w 548
    //   35: aconst_null
    //   36: invokevirtual 552	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   39: astore 5
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: astore_2
    //   47: new 71	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   54: astore 6
    //   56: aload 4
    //   58: astore_3
    //   59: aload 4
    //   61: astore_2
    //   62: aload 6
    //   64: ldc_w 554
    //   67: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 5
    //   73: ifnonnull +8 -> 81
    //   76: iconst_0
    //   77: istore_1
    //   78: goto +17 -> 95
    //   81: aload 4
    //   83: astore_3
    //   84: aload 4
    //   86: astore_2
    //   87: aload 5
    //   89: invokeinterface 558 1 0
    //   94: istore_1
    //   95: aload 4
    //   97: astore_3
    //   98: aload 4
    //   100: astore_2
    //   101: aload 6
    //   103: iload_1
    //   104: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 4
    //   110: astore_3
    //   111: aload 4
    //   113: astore_2
    //   114: ldc_w 393
    //   117: iconst_2
    //   118: aload 6
    //   120: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload 4
    //   128: astore_3
    //   129: aload 4
    //   131: astore_2
    //   132: aload_0
    //   133: getfield 162	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:e	Ljava/lang/Object;
    //   136: astore 6
    //   138: aload 4
    //   140: astore_3
    //   141: aload 4
    //   143: astore_2
    //   144: aload 6
    //   146: monitorenter
    //   147: aload_0
    //   148: aload 5
    //   150: putfield 218	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:d	Ljava/util/List;
    //   153: aload_0
    //   154: getfield 218	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:d	Ljava/util/List;
    //   157: ifnonnull +16 -> 173
    //   160: aload_0
    //   161: new 410	java/util/ArrayList
    //   164: dup
    //   165: bipush 16
    //   167: invokespecial 564	java/util/ArrayList:<init>	(I)V
    //   170: putfield 218	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:d	Ljava/util/List;
    //   173: aload 6
    //   175: monitorexit
    //   176: aload 4
    //   178: astore_3
    //   179: aload 4
    //   181: astore_2
    //   182: aload_0
    //   183: getfield 216	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:O	Ljava/util/Map;
    //   186: astore 5
    //   188: aload 4
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: aload 5
    //   196: monitorenter
    //   197: aload_0
    //   198: getfield 216	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:O	Ljava/util/Map;
    //   201: invokeinterface 567 1 0
    //   206: aload_0
    //   207: getfield 218	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:d	Ljava/util/List;
    //   210: invokeinterface 571 1 0
    //   215: astore_2
    //   216: aload_2
    //   217: invokeinterface 576 1 0
    //   222: ifeq +31 -> 253
    //   225: aload_2
    //   226: invokeinterface 580 1 0
    //   231: checkcast 382	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   234: astore_3
    //   235: aload_0
    //   236: getfield 216	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:O	Ljava/util/Map;
    //   239: aload_3
    //   240: getfield 583	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   243: aload_3
    //   244: invokeinterface 587 3 0
    //   249: pop
    //   250: goto -34 -> 216
    //   253: aload 5
    //   255: monitorexit
    //   256: aload 4
    //   258: ifnull +100 -> 358
    //   261: aload 4
    //   263: astore_2
    //   264: goto +90 -> 354
    //   267: astore 6
    //   269: aload 5
    //   271: monitorexit
    //   272: aload 4
    //   274: astore_3
    //   275: aload 4
    //   277: astore_2
    //   278: aload 6
    //   280: athrow
    //   281: astore 5
    //   283: aload 6
    //   285: monitorexit
    //   286: aload 4
    //   288: astore_3
    //   289: aload 4
    //   291: astore_2
    //   292: aload 5
    //   294: athrow
    //   295: astore_2
    //   296: goto +63 -> 359
    //   299: astore 4
    //   301: aload_2
    //   302: astore_3
    //   303: new 71	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   310: astore 5
    //   312: aload_2
    //   313: astore_3
    //   314: aload 5
    //   316: ldc_w 589
    //   319: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_2
    //   324: astore_3
    //   325: aload 5
    //   327: aload 4
    //   329: invokevirtual 592	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_2
    //   337: astore_3
    //   338: ldc_w 393
    //   341: iconst_2
    //   342: aload 5
    //   344: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload_2
    //   351: ifnull +7 -> 358
    //   354: aload_2
    //   355: invokevirtual 597	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   358: return
    //   359: aload_3
    //   360: ifnull +7 -> 367
    //   363: aload_3
    //   364: invokevirtual 597	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   367: goto +5 -> 372
    //   370: aload_2
    //   371: athrow
    //   372: goto -2 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	EcShopAssistantManager
    //   77	27	1	i1	int
    //   1	291	2	localObject1	Object
    //   295	76	2	localObject2	Object
    //   3	361	3	localObject3	Object
    //   14	276	4	localEntityManager	EntityManager
    //   299	29	4	localException	Exception
    //   39	231	5	localObject4	Object
    //   281	12	5	localObject5	Object
    //   310	33	5	localStringBuilder	StringBuilder
    //   54	120	6	localObject6	Object
    //   267	17	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   197	216	267	finally
    //   216	250	267	finally
    //   253	256	267	finally
    //   269	272	267	finally
    //   147	173	281	finally
    //   173	176	281	finally
    //   283	286	281	finally
    //   4	16	295	finally
    //   22	41	295	finally
    //   47	56	295	finally
    //   62	71	295	finally
    //   87	95	295	finally
    //   101	108	295	finally
    //   114	126	295	finally
    //   132	138	295	finally
    //   144	147	295	finally
    //   182	188	295	finally
    //   194	197	295	finally
    //   278	281	295	finally
    //   292	295	295	finally
    //   303	312	295	finally
    //   314	323	295	finally
    //   325	336	295	finally
    //   338	350	295	finally
    //   4	16	299	java/lang/Exception
    //   22	41	299	java/lang/Exception
    //   47	56	299	java/lang/Exception
    //   62	71	299	java/lang/Exception
    //   87	95	299	java/lang/Exception
    //   101	108	299	java/lang/Exception
    //   114	126	299	java/lang/Exception
    //   132	138	299	java/lang/Exception
    //   144	147	299	java/lang/Exception
    //   182	188	299	java/lang/Exception
    //   194	197	299	java/lang/Exception
    //   278	281	299	java/lang/Exception
    //   292	295	299	java/lang/Exception
  }
  
  private void o()
  {
    ThreadManager.executeOnSubThread(new EcShopAssistantManager.2(this));
  }
  
  private boolean p()
  {
    return this.c.getApp().getSharedPreferences(this.c.getAccount(), 0).getBoolean("is_update_ec_shop_assist", true);
  }
  
  private void q()
  {
    for (;;)
    {
      synchronized (this.e)
      {
        if (this.d == null)
        {
          i1 = 1;
          if (i1 != 0) {
            n();
          }
          return;
        }
      }
      int i1 = 0;
    }
  }
  
  public EcShopData a(String paramString)
  {
    q();
    synchronized (this.O)
    {
      EcShopData localEcShopData = (EcShopData)this.O.get(paramString);
      ??? = localEcShopData;
      if (localEcShopData == null)
      {
        localEcShopData = new EcShopData();
        localEcShopData.mUin = paramString;
        QQMessageFacade localQQMessageFacade = this.c.getMessageFacade();
        ??? = localEcShopData;
        if (localQQMessageFacade != null)
        {
          paramString = localQQMessageFacade.getDraftSummaryInfo(paramString, 1008);
          ??? = localEcShopData;
          if (paramString != null)
          {
            localEcShopData.mLastDraftTime = paramString.getTime();
            ??? = localEcShopData;
          }
        }
      }
      return ???;
    }
  }
  
  public String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = "";
    Object localObject = str;
    IPublicAccountDataManager localIPublicAccountDataManager;
    if (paramQQAppInterface != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(paramString))
      {
        localIPublicAccountDataManager = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        localObject = str;
        if ((localIPublicAccountDataManager != null) && (!RecentParcelUtil.a(paramQQAppInterface))) {}
      }
    }
    try
    {
      localObject = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfo(paramString, true);
    }
    catch (Throwable localThrowable)
    {
      label67:
      break label67;
    }
    localObject = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfo(paramString);
    break label94;
    localObject = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfo(paramString);
    label94:
    if (localObject != null) {
      str = ((PublicAccountInfo)localObject).name;
    }
    localObject = str;
    if (TextUtils.isEmpty(str))
    {
      paramQQAppInterface = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).queryAccountDetail(paramQQAppInterface, paramString);
      localObject = str;
      if (paramQQAppInterface != null) {
        localObject = paramQQAppInterface.getName();
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return paramString;
    }
    return localObject;
  }
  
  public List<EcShopData> a()
  {
    q();
    for (;;)
    {
      synchronized (this.e)
      {
        if (this.d != null)
        {
          i1 = this.d.size();
          ArrayList localArrayList = new ArrayList(i1);
          localArrayList.addAll(this.d);
          ??? = new StringBuilder();
          ((StringBuilder)???).append("getAllEcShopAssitData size: ");
          ((StringBuilder)???).append(localArrayList.size());
          QLog.d("EcShopAssistantManager", 2, ((StringBuilder)???).toString());
          return localArrayList;
        }
      }
      int i1 = 0;
    }
  }
  
  public void a(long paramLong)
  {
    this.c.getApp().getSharedPreferences(this.c.getAccount(), 0).edit().putLong("last_read_time", paramLong).commit();
    this.L = paramLong;
    synchronized (this.f)
    {
      this.g.clear();
      o();
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject1 = this.c;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    localObject1 = this.c.getProxyManager().g();
    if (localObject2 == null) {
      return;
    }
    this.B = paramBoolean;
    localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
    if (((RecentUser)localObject2).lastmsgtime < paramLong) {
      ((RecentUser)localObject2).lastmsgtime = paramLong;
    }
    ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
    ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
    localObject1 = this.c.getHandler(Conversation.class);
    if (localObject1 != null) {
      ((MqqHandler)localObject1).sendEmptyMessage(1009);
    }
  }
  
  public void a(Intent paramIntent, Context paramContext, int paramInt)
  {
    if (paramIntent != null)
    {
      if (paramContext == null) {
        return;
      }
      Bundle localBundle;
      if (paramIntent.getExtras() == null) {
        localBundle = new Bundle();
      } else {
        localBundle = paramIntent.getExtras();
      }
      localBundle.putParcelableArrayList("datas", (ArrayList)k());
      if (!TextUtils.isEmpty(this.H)) {
        localBundle.putString("ad_logo", this.H);
      }
      if (!TextUtils.isEmpty(this.I)) {
        localBundle.putString("ad_jump", this.I);
      }
      long l1 = this.J;
      if (l1 != 0L) {
        localBundle.putLong("ad_id", l1);
      }
      this.G = true;
      localBundle.putBoolean("is_tab_show", this.v);
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext()) {
        if ("com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName))
        {
          bool1 = true;
          break label191;
        }
      }
      boolean bool1 = false;
      label191:
      localBundle.putBoolean("is_tool_exist", bool1);
      localBundle.putLong("click_time", System.currentTimeMillis());
      localBundle.putStringArray("urls", this.C);
      SharedPreferences localSharedPreferences = j();
      boolean bool2 = localSharedPreferences.getBoolean("folder_tab_red", false);
      paramContext = this.c.getProxyManager().g();
      if (paramInt >= 0)
      {
        bool1 = bool2;
        if (paramInt <= 0) {}
      }
      else
      {
        do
        {
          bool1 = true;
          break;
          bool1 = bool2;
          if (paramContext == null) {
            break;
          }
          paramContext = paramContext.c(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
          bool1 = bool2;
          if (paramContext == null) {
            break;
          }
          paramContext = RecentDataListManager.a(paramContext.uin, paramContext.getType());
          paramContext = RecentDataListManager.a().a(paramContext);
          bool1 = bool2;
          if (paramContext == null) {
            break;
          }
          bool1 = bool2;
        } while (paramContext.mUnreadNum > 0);
      }
      localBundle.putBoolean("hasUnread", bool1);
      localBundle.putLong("last_read_folder", localSharedPreferences.getLong("last_read_folder", 0L));
      localBundle.putLong("latest_time", localSharedPreferences.getLong("latest_time", 0L));
      localBundle.putInt("unReadNum", this.c.getMessageFacade().w());
      localBundle.putBoolean("isDefaultTheme", ThemeUtil.isDefaultOrDIYTheme(false));
      Object localObject = ((FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.c.getCurrentAccountUin());
      String str2 = this.C[1];
      String str1 = "0";
      if (bool1) {
        paramContext = "1";
      } else {
        paramContext = "0";
      }
      str2 = URLUtil.a(str2, "has_reddot", paramContext);
      if (localObject == null) {
        paramContext = "0";
      } else {
        paramContext = String.valueOf(((Friends)localObject).gender);
      }
      localObject = URLUtil.a(str2, "gender", paramContext);
      localBundle.putInt("PUSH_TASK_ID", localSharedPreferences.getInt("PUSH_TASK_ID", 0));
      localBundle.putString("str_ecshop_diy", localSharedPreferences.getString("str_ecshop_diy", ""));
      localBundle.putInt("PUSH_TASK_TYPE", localSharedPreferences.getInt("PUSH_TASK_TYPE", 0));
      localBundle.putString("PUSH_TASK_INFO", localSharedPreferences.getString("PUSH_TASK_INFO", ""));
      localBundle.putLong("PUSH_RECEIVE_TIME", localSharedPreferences.getLong("PUSH_RECEIVE_TIME", 0L));
      paramContext = (Context)localObject;
      if (!TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
        paramContext = URLUtil.a((String)localObject, "jumpUrl", localSharedPreferences.getString("PUSH_JUMP_URL", ""));
      }
      if (this.A) {
        str1 = String.valueOf(localSharedPreferences.getInt("FOLDER_MSG_TYPE", -1));
      }
      paramContext = URLUtil.a(URLUtil.a(paramContext, "type", str1), "taskType", String.valueOf(localSharedPreferences.getInt("PUSH_TASK_TYPE", 0)));
      paramIntent.putExtra("bundle", localBundle);
      paramIntent.putExtra("url", paramContext);
    }
  }
  
  public void a(EcShopData paramEcShopData)
  {
    if (paramEcShopData != null) {
      if (TextUtils.isEmpty(paramEcShopData.mUin)) {
        return;
      }
    }
    for (;;)
    {
      int i1;
      synchronized (this.O)
      {
        this.O.put(paramEcShopData.mUin, paramEcShopData);
        synchronized (this.e)
        {
          if (this.d != null)
          {
            this.d.remove(paramEcShopData);
            int i3 = 0;
            i1 = 0;
            int i2 = i3;
            if (i1 < this.d.size())
            {
              EcShopData localEcShopData = (EcShopData)this.d.get(i1);
              if (Math.max(paramEcShopData.mLastMsgTime, paramEcShopData.mLastDraftTime) <= Math.max(localEcShopData.mLastMsgTime, localEcShopData.mLastDraftTime)) {
                break label316;
              }
              this.d.add(i1, paramEcShopData);
              i2 = 1;
            }
            if (i2 == 0) {
              this.d.add(this.d.size(), paramEcShopData);
            }
          }
          ??? = (ProxyManager)this.c.getManager(QQManagerFactory.PROXY_MANAGER);
          if (paramEcShopData.getStatus() == 1000) {
            ((ProxyManager)???).addMsgQueue(this.c.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 3, null);
          } else {
            ((ProxyManager)???).addMsgQueue(this.c.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 4, null);
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("saveEcShopData(db&cache) puin: ");
          ((StringBuilder)???).append(paramEcShopData.mUin);
          ((StringBuilder)???).append(", status: ");
          ((StringBuilder)???).append(paramEcShopData.getStatus());
          QLog.d("EcShopAssistantManager", 2, ((StringBuilder)???).toString());
          return;
        }
      }
      return;
      label316:
      i1 += 1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.K = paramQQAppInterface.getAccount();
      Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences(this.K, 0);
      this.M = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_show_in_msg", true);
      this.N = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_deleted", false);
      this.L = ((SharedPreferences)localObject2).getLong("last_read_time", 0L);
      Object localObject3 = a();
      synchronized (this.f)
      {
        this.g = SharedPreferencesHandler.a((SharedPreferences)localObject2, "ec_shop_assist_new_unread_list", null);
        if (this.g == null)
        {
          this.g = new HashSet();
          if (p())
          {
            c(false);
            localObject2 = paramQQAppInterface.getMessageFacade();
            if (localObject2 == null) {
              return;
            }
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              EcShopData localEcShopData = (EcShopData)((Iterator)localObject3).next();
              Message localMessage = ((QQMessageFacade)localObject2).getLastMessage(localEcShopData.mUin, 1008);
              if ((paramQQAppInterface.getConversationFacade().a(localEcShopData.mUin, 1008) > 0) && (localMessage.time > this.L)) {
                a(localMessage.frienduin, paramQQAppInterface);
              }
            }
          }
        }
        return;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addMsgToAssist puin: ");
    ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
    QLog.d("EcShopAssistantManager", 2, ((StringBuilder)localObject).toString());
    localObject = j();
    String str = paramMessageRecord.frienduin;
    long l1 = paramMessageRecord.time;
    if ((!TextUtils.isEmpty(str)) && (str.equals(s)))
    {
      ((SharedPreferences)localObject).edit().putBoolean("is_ad_added", false).commit();
      s = null;
    }
    EcShopData localEcShopData = a(str);
    localEcShopData.mImgInfo = "";
    if ((paramMessageRecord != null) && (paramMessageRecord.time > l1)) {
      localEcShopData.mLastMsgTime = paramMessageRecord.time;
    } else {
      localEcShopData.mLastMsgTime = l1;
    }
    Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(localEcShopData.mUin, 1008);
    if (localMessage != null)
    {
      long l2 = localMessage.time;
      if (l2 > localEcShopData.mLastMsgTime) {
        localEcShopData.mLastMsgTime = l2;
      }
      if (l2 > j().getLong("latest_time", 0L)) {
        ((SharedPreferences)localObject).edit().putLong("latest_time", l2).commit();
      }
    }
    a(localEcShopData);
    a(paramMessageRecord, str);
    if (this.N) {
      a(false);
    }
    b(paramQQAppInterface, str);
    b(l1);
    b(str);
    if ((localObject != null) && (!TextUtils.isEmpty(((SharedPreferences)localObject).getString("PUSH_JUMP_URL", "")))) {
      ((SharedPreferences)localObject).edit().putString("PUSH_JUMP_URL", "").commit();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    paramString.mLastDraftTime = paramLong;
    a(paramString);
    b(null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshSettings.... paUin: ");
    ((StringBuilder)localObject1).append(LogUtil.wrapLogUin(paramString1));
    ((StringBuilder)localObject1).append(", src: ");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.d("EcShopAssistantManager", 2, ((StringBuilder)localObject1).toString());
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    paramString2 = this.c.getProxyManager().g();
    paramString1 = this.c.getEntityManagerFactory().createEntityManager();
    ??? = paramString2.a(false);
    Object localObject4;
    Object localObject5;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).getType() == 1008) && (ServiceAccountFolderManager.c(this.c, ((RecentUser)localObject4).uin)) && (!RecentUserAppearLogic.a(this.c, ((RecentUser)localObject4).msgType)))
        {
          ((ArrayList)localObject2).add(localObject4);
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("add to ecshop folder puin: ");
          ((StringBuilder)localObject5).append(((RecentUser)localObject4).uin);
          ((StringBuilder)localObject5).append(", size: ");
          ((StringBuilder)localObject5).append(((ArrayList)localObject2).size());
          QLog.d("EcShopAssistantManager", 2, ((StringBuilder)localObject5).toString());
        }
      }
    }
    q();
    synchronized (this.e)
    {
      if ((this.d != null) && (this.d.size() > 0))
      {
        localObject4 = this.d.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (EcShopData)((Iterator)localObject4).next();
          if ((!ServiceAccountFolderManager.c(this.c, ((EcShopData)localObject5).mUin)) && (!((EcShopData)localObject5).mUin.equalsIgnoreCase(s)))
          {
            ((ArrayList)localObject1).add(localObject5);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("remove form ecshop folder puin: ");
            localStringBuilder.append(((EcShopData)localObject5).mUin);
            QLog.d("EcShopAssistantManager", 2, localStringBuilder.toString());
          }
        }
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("toRecentUser size: ");
      ((StringBuilder)???).append(((ArrayList)localObject1).size());
      QLog.d("EcShopAssistantManager", 2, ((StringBuilder)???).toString());
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ??? = (RecentUser)((Iterator)localObject2).next();
          localObject4 = a(((RecentUser)???).uin);
          if (((RecentUser)???).lastmsgtime == 0L)
          {
            localObject5 = this.c.getMessageFacade().getLastMessage(((EcShopData)localObject4).mUin, 1008);
            if (localObject5 != null) {
              ((EcShopData)localObject4).mLastMsgTime = ((Message)localObject5).time;
            }
          }
          else
          {
            ((EcShopData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime;
          }
          a((EcShopData)localObject4);
          paramString2.a((RecentUser)???);
          a(((RecentUser)???).uin, this.c);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EcShopData)((Iterator)localObject1).next();
          ??? = paramString2.b(((EcShopData)localObject2).mUin, 1008);
          ((RecentUser)???).uin = ((EcShopData)localObject2).mUin;
          ((RecentUser)???).setType(1008);
          ((RecentUser)???).lastmsgtime = ((EcShopData)localObject2).mLastMsgTime;
          ((RecentUser)???).lastmsgdrafttime = ((EcShopData)localObject2).mLastDraftTime;
          if (a(paramString1, ((EcShopData)localObject2).mUin))
          {
            localObject4 = (IPublicAccountDataManager)this.c.getRuntimeService(IPublicAccountDataManager.class, "all");
            if ((localObject4 != null) && (((IPublicAccountDataManager)localObject4).findPublicAccountInfoCache(((EcShopData)localObject2).mUin) != null))
            {
              paramString2.b((RecentUser)???);
              ??? = new StringBuilder();
              ((StringBuilder)???).append("add to msgtab puin: ");
              ((StringBuilder)???).append(((EcShopData)localObject2).mUin);
              QLog.d("EcShopAssistantManager", 2, ((StringBuilder)???).toString());
            }
          }
        }
      }
      paramString2 = c();
      if (paramString2 != null) {
        b(paramString2.mLastMsgTime);
      }
      if (paramString1 != null) {
        paramString1.close();
      }
      b(null);
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.getApp().getSharedPreferences(this.c.getAccount(), 0).edit().putBoolean("ec_shop_assist_deleted", paramBoolean).commit();
    this.N = paramBoolean;
  }
  
  public int b(QQAppInterface paramQQAppInterface)
  {
    int i1;
    int i2;
    label99:
    synchronized (this.f)
    {
      if ((this.g != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.g.iterator();
        i1 = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          i2 = paramQQAppInterface.getConversationFacade().a(str, 1008);
          if (i2 > 0) {
            break label99;
          }
        }
        else
        {
          return i1;
        }
      }
      else
      {
        return 0;
      }
    }
  }
  
  public void b()
  {
    if (this.c == null) {
      return;
    }
    EcShopData localEcShopData = c();
    if (localEcShopData != null) {
      b(localEcShopData.mLastMsgTime);
    }
  }
  
  void b(String paramString)
  {
    if (this.G)
    {
      Intent localIntent = new Intent("action_on_shop_msg_receive");
      localIntent.putParcelableArrayListExtra("datas", (ArrayList)k());
      if ((!TextUtils.isEmpty(paramString)) && ((!this.c.getMessageFacade().n()) || (!paramString.equals(this.c.getMessageFacade().l())))) {
        localIntent.putExtra("uin", paramString);
      }
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.v = paramBoolean;
    j().edit().putBoolean("folder_tab_show", this.v).commit();
  }
  
  public EcShopData c()
  {
    q();
    for (;;)
    {
      synchronized (this.e)
      {
        if ((this.d != null) && (this.d.size() > 0))
        {
          EcShopData localEcShopData = (EcShopData)this.d.get(0);
          return localEcShopData;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.f)
    {
      if ((this.g != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.g.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramQQAppInterface.getConversationFacade().a(str, 1008) > 0) {
            paramQQAppInterface.getConversationFacade().a(str, 1008, false);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void c(String paramString)
  {
    ThreadManager.post(new EcShopAssistantManager.3(this, paramString), 5, null, true);
  }
  
  public void d()
  {
    Object localObject1 = new File(a);
    if (((File)localObject1).exists())
    {
      localObject1 = FileUtils.readFileContent((File)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label254;
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).has("shopFolderName")) {
          h = ((JSONObject)localObject1).getString("shopFolderName");
        }
        if (((JSONObject)localObject1).has("shopFolderIcon")) {
          i = ((JSONObject)localObject1).getString("shopFolderIcon");
        }
        if (!((JSONObject)localObject1).has("shopButton")) {
          break label254;
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("shopButton");
        if (!QLog.isColorLevel()) {
          break label255;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("shopButton info found:");
        ((StringBuilder)localObject2).append(((JSONArray)localObject1).toString());
        QLog.i("EcShopAssistantManager", 2, ((StringBuilder)localObject2).toString());
      }
      catch (Exception localException)
      {
        Object localObject2;
        String str;
        int i2;
        if (!QLog.isColorLevel()) {
          break label254;
        }
      }
      if (i1 < ((JSONArray)localObject1).length())
      {
        localObject2 = (JSONObject)((JSONArray)localObject1).get(i1);
        str = ((JSONObject)localObject2).getString("url");
        i2 = ((JSONObject)localObject2).getInt("id");
        this.C[(i2 - 1)] = str;
        i1 += 1;
        continue;
        QLog.d("EcShopAssistantManager", 2, "parse banner config fail", localException);
        return;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("banner json config file is not existed path=");
        localStringBuilder.append(a);
        QLog.d("EcShopAssistantManager", 2, localStringBuilder.toString());
      }
      else
      {
        label254:
        return;
        label255:
        i1 = 0;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    List localList = o;
    return ((localList != null) && (localList.contains(paramString))) || (ServiceAccountFolderManager.c(this.c, paramString)) || (((IEcshopService)this.c.getRuntimeService(IEcshopService.class)).isInWalletReportList(paramString));
  }
  
  public void e()
  {
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.c.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if (localDownloaderInterface != null)
    {
      Object localObject2 = EmosmUtils.a("VIP_shop_assit_cfg", "https://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json");
      if (localDownloaderInterface.getTask((String)localObject2) == null)
      {
        Object localObject1 = new File(a);
        localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
        if (((File)localObject1).exists())
        {
          long l1 = ((File)localObject1).lastModified();
          ((DownloadTask)localObject2).I = this.c.getPreferences().getLong("last_modified_time", 0L);
          if (Long.valueOf(l1).longValue() != ((DownloadTask)localObject2).I) {
            ((DownloadTask)localObject2).G = true;
          }
        }
        ((DownloadTask)localObject2).D = true;
        ((DownloadTask)localObject2).N = false;
        localObject1 = new Bundle();
        localDownloaderInterface.startDownload((DownloadTask)localObject2, this.P, (Bundle)localObject1);
      }
    }
  }
  
  public void f()
  {
    try
    {
      q();
      Object localObject1 = this.c.getProxyManager().g();
      localObject2 = ((RecentUserProxy)localObject1).a(false);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if ((1008 == localRecentUser.getType()) && (ServiceAccountFolderManager.c(this.c, localRecentUser.uin)))
          {
            EcShopData localEcShopData = a(localRecentUser.uin);
            localEcShopData.mLastDraftTime = localRecentUser.lastmsgdrafttime;
            localEcShopData.mLastMsgTime = localRecentUser.lastmsgtime;
            if (localEcShopData.mLastMsgTime == 0L)
            {
              Message localMessage = this.c.getMessageFacade().getLastMessage(localEcShopData.mUin, 1008);
              long l1;
              if (localMessage != null) {
                l1 = localMessage.time;
              } else {
                l1 = localEcShopData.mLastMsgTime;
              }
              localEcShopData.mLastMsgTime = l1;
            }
            a(localEcShopData);
            ((RecentUserProxy)localObject1).a(localRecentUser);
            a(localEcShopData.mUin, this.c);
          }
        }
      }
      localObject1 = (IPublicAccountHandler)this.c.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (localObject1 != null) {
        ((IPublicAccountHandler)localObject1).clearPublicAccountSeq();
      }
      this.c.getApp().getSharedPreferences(this.c.getAccount(), 0).edit().putBoolean("init_ec_shop_assist", false).commit();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initEcShopAssist fail msg:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.d("EcShopAssistantManager", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void g()
  {
    if (h()) {
      f();
    }
    b();
  }
  
  public boolean h()
  {
    return this.c.getApp().getSharedPreferences(this.c.getAccount(), 0).getBoolean("init_ec_shop_assist", true);
  }
  
  public int i()
  {
    Object localObject1 = this.d;
    int i2 = 0;
    int i1 = 0;
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      for (;;)
      {
        i2 = i1;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (EcShopData)localIterator.next();
        localObject1 = null;
        i2 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.c, ((EcShopData)localObject2).mUin);
        QQMessageFacade localQQMessageFacade = this.c.getMessageFacade();
        if (localQQMessageFacade != null) {
          localObject1 = localQQMessageFacade.getLastMessage(((EcShopData)localObject2).mUin, i2);
        }
        if (localObject1 != null)
        {
          localObject2 = this.c.getConversationFacade();
          if (localObject2 != null) {
            i1 += ((ConversationFacade)localObject2).a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
          }
        }
      }
    }
    return i2;
  }
  
  public List<RecentShopParcel> k()
  {
    if (!this.G) {
      l();
    }
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.c.getRuntimeService(IPublicAccountDataManager.class, "all");
    SharedPreferences localSharedPreferences = j();
    ArrayList localArrayList = new ArrayList();
    synchronized (this.e)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        EcShopData localEcShopData = (EcShopData)localIterator.next();
        Object localObject3;
        if ((!TextUtils.isEmpty(localEcShopData.mUin)) && (localEcShopData.mUin.equals(s)))
        {
          localObject3 = new RecentShopParcel();
          ((RecentShopParcel)localObject3).a = localEcShopData.mUin;
          ((RecentShopParcel)localObject3).b = localSharedPreferences.getString("ad_nick", "");
          ((RecentShopParcel)localObject3).d = localSharedPreferences.getString("ad_title", "");
          ((RecentShopParcel)localObject3).e = localEcShopData.mImgInfo;
          if (localSharedPreferences.getBoolean("ad_cert", false)) {
            ((RecentShopParcel)localObject3).f = 0;
          } else {
            ((RecentShopParcel)localObject3).f = 0;
          }
          ((RecentShopParcel)localObject3).g = 0;
          ((RecentShopParcel)localObject3).h = 1;
          localArrayList.add(localObject3);
        }
        else
        {
          localObject3 = new RecentItemEcShop(localEcShopData);
          ((RecentItemEcShop)localObject3).update(this.c, BaseApplication.getContext());
          RecentShopParcel localRecentShopParcel = new RecentShopParcel();
          localRecentShopParcel.a = localEcShopData.mUin;
          localRecentShopParcel.b = a(this.c, localEcShopData.mUin);
          localRecentShopParcel.c = ((RecentItemEcShop)localObject3).mShowTime;
          localRecentShopParcel.d = String.valueOf(((RecentItemEcShop)localObject3).mLastMsg);
          localRecentShopParcel.e = localEcShopData.mImgInfo;
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfoCache(localEcShopData.mUin);
          if ((localPublicAccountInfo != null) && (localPublicAccountInfo.certifiedGrade > 0L)) {
            localRecentShopParcel.f = 0;
          } else {
            localRecentShopParcel.f = 0;
          }
          localRecentShopParcel.g = ((RecentItemEcShop)localObject3).mUnreadNum;
          localRecentShopParcel.h = 0;
          localRecentShopParcel.j = ((RecentItemEcShop)localObject3).getLastMsgTime();
          localRecentShopParcel.k = localEcShopData.mLastDraftTime;
          localArrayList.add(localRecentShopParcel);
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void l()
  {
    List localList = a();
    if (localList == null) {
      i1 = 0;
    } else {
      i1 = localList.size();
    }
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.c.getRuntimeService(IPublicAccountDataManager.class, "all");
    SharedPreferences localSharedPreferences = j();
    boolean bool = localSharedPreferences.getBoolean("is_ad_added", false);
    long l1 = localSharedPreferences.getLong("ad_puin", 0L);
    this.J = localSharedPreferences.getLong("ad_id", 0L);
    s = String.valueOf(l1);
    Object localObject2 = null;
    this.H = localSharedPreferences.getString("ad_icon_url", null);
    this.I = localSharedPreferences.getString("ad_url", null);
    int i3 = localSharedPreferences.getInt("ad_start", 0);
    int i4 = localSharedPreferences.getInt("ad_end", 0);
    long l2 = System.currentTimeMillis() / 1000L;
    int i2;
    if ((!bool) && (localSharedPreferences.contains("ad_id")) && (i1 > 0))
    {
      if ((l2 > i3) && (l2 < i4) && (!localIPublicAccountDataManager.isFollowedUin(Long.valueOf(l1))))
      {
        localObject1 = new EcShopData();
        ((EcShopData)localObject1).mUin = String.valueOf(l1);
        ((EcShopData)localObject1).mImgInfo = localSharedPreferences.getString("ad_pics", null);
        i2 = 0;
        while ((i2 < i1) && (i2 < 2))
        {
          ((EcShopData)localObject1).mLastMsgTime = (((EcShopData)localList.get(i2)).mLastMsgTime - 1L);
          i2 += 1;
        }
        a((EcShopData)localObject1);
        localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
        i1 = 1;
        break label479;
      }
    }
    else if (bool)
    {
      i2 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i2 >= i1) {
          break;
        }
        if (String.valueOf(l1).equals(((EcShopData)localList.get(i2)).mUin))
        {
          localObject1 = (EcShopData)localList.get(i2);
          break;
        }
        i2 += 1;
      }
      if (((l2 < i3) || (l2 > i4) || (localIPublicAccountDataManager.isFollowedUin(Long.valueOf(l1)))) && (localObject1 != null))
      {
        c(((EcShopData)localObject1).mUin);
      }
      else if (localObject1 != null)
      {
        localObject1 = localSharedPreferences.edit();
        i1 = 1;
        ((SharedPreferences.Editor)localObject1).putBoolean("is_ad_added", true).commit();
        break label479;
      }
    }
    int i1 = 0;
    label479:
    if ((i1 == 0) && (localSharedPreferences.getBoolean("is_ad_added", false)))
    {
      localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
    }
    else if ((i1 != 0) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("show ad ,puin=");
      ((StringBuilder)localObject1).append(s);
      QLog.i("EcShopAssistantManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (i1 == 0)
    {
      s = "";
      return;
    }
    Object localObject1 = (EcshopReportHandler)this.c.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    if (localObject1 != null) {
      ((EcshopReportHandler)localObject1).a(134246436, null, null, null, null, this.J, false);
    }
  }
  
  public boolean m()
  {
    if (!this.z) {
      return false;
    }
    long l1 = j().getLong("last_stay_folder", 0L);
    long l2 = this.y * 1000 * 60 * 60;
    if ((System.currentTimeMillis() - l1 < l2 * 24L) && (this.v))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("lastEnterShop:");
        localStringBuilder.append(l1);
        localStringBuilder.append(",dayLimit:");
        localStringBuilder.append(this.y);
        QLog.i("EcShopAssistantManager", 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.D);
      label10:
      IFaceDecoder localIFaceDecoder = this.E;
      if (localIFaceDecoder != null)
      {
        localIFaceDecoder.destory();
        this.E = null;
      }
      this.P = null;
      return;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager
 * JD-Core Version:    0.7.0.1
 */