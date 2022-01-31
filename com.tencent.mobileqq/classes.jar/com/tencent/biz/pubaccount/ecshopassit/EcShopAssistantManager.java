package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
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
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment;
import com.tencent.gdtad.views.canvas.GdtCanvasDataBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vip.DownloadListener;
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
import laj;
import lak;
import lal;
import lam;
import lan;
import lao;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class EcShopAssistantManager
  implements Manager
{
  public static int a;
  public static final String a;
  public static HashMap a;
  public static boolean a;
  public static final String b;
  public static HashMap b;
  public static List b;
  public static String c;
  public static List c;
  public static String d;
  public static final String e;
  public static final String f;
  public static String g;
  public static final String h;
  public long a;
  public BroadcastReceiver a;
  public QQAppInterface a;
  FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = new lao(this);
  public FaceDecoder a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new lam(this);
  final Object jdField_a_of_type_JavaLangObject = new Object();
  public List a;
  private Map jdField_a_of_type_JavaUtilMap;
  public Set a;
  public String[] a;
  public int b;
  public long b;
  public final Object b;
  public boolean b;
  public int c;
  private long c;
  public boolean c;
  public int d;
  public boolean d;
  public boolean e;
  public boolean f;
  private boolean g;
  private boolean h;
  public String i;
  public String j;
  public String k;
  private String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "shop_assit_banner_json.txt";
    jdField_b_of_type_JavaLangString = AppConstants.aJ + ".shop_assit/image/";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Int = 600000;
    jdField_e_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_wl_conf.json";
    jdField_f_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_jd_conf.json";
    jdField_a_of_type_Boolean = true;
    jdField_h_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsoluteFile() + File.separator + "animConfig/red_packet.png";
  }
  
  public EcShopAssistantManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/haowu.html?_wv=3&max_age=600", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/my.html?_wv=3" };
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lan(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.l = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList = null;
      ThreadManager.post(new laj(this), 5, null, true);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
      return;
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 1: 
      return 1;
    case 3000: 
      return 2;
    }
    return 3;
  }
  
  public static SharedPreferences a()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("ecshop_sp" + str1, 0);
  }
  
  public static Drawable a(Context paramContext)
  {
    if (!TextUtils.isEmpty(jdField_d_of_type_JavaLangString))
    {
      Object localObject1 = paramContext.getResources().getDrawable(2130838676);
      Object localObject2 = jdField_d_of_type_JavaLangString.split("/");
      localObject2 = jdField_b_of_type_JavaLangString + localObject2[(localObject2.length - 1)];
      String str = jdField_d_of_type_JavaLangString;
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_icon", str, (String)localObject2), (Drawable)localObject1, (Drawable)localObject1);
        return localObject1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return paramContext.getResources().getDrawable(2130843784);
      }
    }
    return paramContext.getResources().getDrawable(2130843784);
  }
  
  public static String a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if ((jdField_c_of_type_JavaUtilList == null) || (!jdField_c_of_type_JavaUtilList.contains(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!paramString2.contains("qq.com")) || (paramString2.contains("&g_tk="))) {
      return paramString2;
    }
    paramQQAppInterface = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getCurrentAccountUin());
    StringBuilder localStringBuilder = new StringBuilder(paramString2);
    if (paramString2.contains("?")) {}
    for (paramString1 = "&g_tk=";; paramString1 = "?g_tk=")
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(String.valueOf(TroopUtils.b(paramQQAppInterface)));
      return localStringBuilder.toString();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.b(paramString);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h();
      return;
    }
    finally {}
  }
  
  private void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1008) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h();
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if ((localObject2 == null) || (localObject1 == null)) {
      return false;
    }
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      localObject2 = ((RecentUserProxy)localObject1).a(AppConstants.aa, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      EcShopData localEcShopData = a();
      if (localEcShopData != null)
      {
        ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
        ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
        ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("EcShopAssistantManager", 2, "update ecshop folder...");
        }
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
      return true;
      if (!this.jdField_e_of_type_Boolean) {
        break;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      break;
      localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.aa, 7120);
      if (localObject2 != null) {
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EcShopAssistantManager", 2, "del ecshop folder...");
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    boolean bool = false;
    EcShopData localEcShopData;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(localEcShopData);
      }
      if (localEcShopData != null) {
        bool = paramEntityManager.b(localEcShopData);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EcShopAssistantManager", 2, "removeEcShopData puin: " + paramString);
      }
      if (this.jdField_f_of_type_Boolean)
      {
        paramEntityManager = new Intent("action_on_shop_msg_receive");
        paramEntityManager.putParcelableArrayListExtra("datas", (ArrayList)b());
        BaseApplicationImpl.getContext().sendBroadcast(paramEntityManager);
      }
      return bool;
      paramEntityManager = finally;
      throw paramEntityManager;
    }
  }
  
  public static int b()
  {
    int n = 0;
    String str = DeviceInfoUtil.b();
    int m = n;
    if (!TextUtils.isEmpty(str))
    {
      m = n;
      if (str.length() > 5)
      {
        m = n;
        if (str.startsWith("460"))
        {
          str = str.substring(3, 5);
          if ((!str.equals("00")) && (!str.equals("02")) && (!str.equals("04")) && (!str.equals("07"))) {
            break label88;
          }
          m = 1;
        }
      }
    }
    label88:
    do
    {
      return m;
      if ((str.equals("01")) || (str.equals("06")) || (str.equals("09"))) {
        return 2;
      }
      if ((str.equals("03")) || (str.equals("05"))) {
        return 3;
      }
      m = n;
    } while (!str.equals("20"));
    return 4;
  }
  
  private void c(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1008) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      h();
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("is_update_ec_shop_assist", paramBoolean).commit();
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("is_update_ec_shop_assist", true);
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 160	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9: invokevirtual 519	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   12: invokevirtual 525	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: astore_3
    //   16: aload_3
    //   17: ldc_w 363
    //   20: iconst_0
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc_w 527
    //   28: aconst_null
    //   29: invokevirtual 530	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   32: astore_2
    //   33: invokestatic 380	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +40 -> 76
    //   39: new 37	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 532
    //   49: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: astore 4
    //   54: aload_2
    //   55: ifnonnull +186 -> 241
    //   58: iconst_0
    //   59: istore_1
    //   60: ldc_w 382
    //   63: iconst_2
    //   64: aload 4
    //   66: iload_1
    //   67: invokevirtual 535	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 122	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   80: astore 4
    //   82: aload 4
    //   84: monitorenter
    //   85: aload_0
    //   86: aload_2
    //   87: putfield 171	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   90: aload_0
    //   91: getfield 171	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   94: ifnonnull +16 -> 110
    //   97: aload_0
    //   98: new 436	java/util/ArrayList
    //   101: dup
    //   102: bipush 16
    //   104: invokespecial 538	java/util/ArrayList:<init>	(I)V
    //   107: putfield 171	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   110: aload 4
    //   112: monitorexit
    //   113: aload_0
    //   114: getfield 169	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   117: astore_2
    //   118: aload_2
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 169	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   124: invokeinterface 541 1 0
    //   129: aload_0
    //   130: getfield 171	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   133: invokeinterface 545 1 0
    //   138: astore 4
    //   140: aload 4
    //   142: invokeinterface 550 1 0
    //   147: ifeq +128 -> 275
    //   150: aload 4
    //   152: invokeinterface 554 1 0
    //   157: checkcast 363	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   160: astore 5
    //   162: aload_0
    //   163: getfield 169	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   166: aload 5
    //   168: getfield 557	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   171: aload 5
    //   173: invokeinterface 561 3 0
    //   178: pop
    //   179: goto -39 -> 140
    //   182: astore 4
    //   184: aload_2
    //   185: monitorexit
    //   186: aload 4
    //   188: athrow
    //   189: astore 4
    //   191: aload_3
    //   192: astore_2
    //   193: invokestatic 380	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +36 -> 232
    //   199: aload_3
    //   200: astore_2
    //   201: ldc_w 382
    //   204: iconst_2
    //   205: new 37	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 563
    //   215: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 4
    //   220: invokevirtual 566	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   223: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 568	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload_3
    //   233: ifnull +7 -> 240
    //   236: aload_3
    //   237: invokevirtual 570	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   240: return
    //   241: aload_2
    //   242: invokeinterface 573 1 0
    //   247: istore_1
    //   248: goto -188 -> 60
    //   251: astore_2
    //   252: aload 4
    //   254: monitorexit
    //   255: aload_2
    //   256: athrow
    //   257: astore_2
    //   258: aload_3
    //   259: astore 4
    //   261: aload_2
    //   262: astore_3
    //   263: aload 4
    //   265: ifnull +8 -> 273
    //   268: aload 4
    //   270: invokevirtual 570	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   273: aload_3
    //   274: athrow
    //   275: aload_2
    //   276: monitorexit
    //   277: aload_3
    //   278: ifnull -38 -> 240
    //   281: aload_3
    //   282: invokevirtual 570	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   285: return
    //   286: astore_3
    //   287: aload_2
    //   288: astore 4
    //   290: goto -27 -> 263
    //   293: astore 4
    //   295: aload 5
    //   297: astore_3
    //   298: goto -107 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	EcShopAssistantManager
    //   59	189	1	m	int
    //   251	5	2	localObject2	Object
    //   257	31	2	localObject3	Object
    //   15	267	3	localObject4	Object
    //   286	1	3	localObject5	Object
    //   297	1	3	localEcShopData1	EcShopData
    //   182	5	4	localObject7	Object
    //   189	64	4	localException1	Exception
    //   259	30	4	localObject8	Object
    //   293	1	4	localException2	Exception
    //   3	293	5	localEcShopData2	EcShopData
    // Exception table:
    //   from	to	target	type
    //   120	140	182	finally
    //   140	179	182	finally
    //   184	186	182	finally
    //   275	277	182	finally
    //   16	54	189	java/lang/Exception
    //   60	76	189	java/lang/Exception
    //   76	85	189	java/lang/Exception
    //   113	120	189	java/lang/Exception
    //   186	189	189	java/lang/Exception
    //   241	248	189	java/lang/Exception
    //   255	257	189	java/lang/Exception
    //   85	110	251	finally
    //   110	113	251	finally
    //   252	255	251	finally
    //   16	54	257	finally
    //   60	76	257	finally
    //   76	85	257	finally
    //   113	120	257	finally
    //   186	189	257	finally
    //   241	248	257	finally
    //   255	257	257	finally
    //   5	16	286	finally
    //   193	199	286	finally
    //   201	232	286	finally
    //   5	16	293	java/lang/Exception
  }
  
  private void h()
  {
    ThreadManager.executeOnSubThread(new lak(this));
  }
  
  private void i()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        m = 1;
        if (m != 0) {
          g();
        }
        return;
      }
      int m = 0;
    }
  }
  
  public int a()
  {
    int m;
    int n;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      m = 0;
      n = m;
      if (!localIterator.hasNext()) {
        break label119;
      }
      localObject1 = (EcShopData)localIterator.next();
      n = PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject1).mUin);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject2 == null) {
        break label124;
      }
    }
    label119:
    label124:
    for (Object localObject1 = ((QQMessageFacade)localObject2).a(((EcShopData)localObject1).mUin, n);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localObject2 != null) {
          m += ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        }
      }
      for (;;)
      {
        break;
        n = 0;
        return n;
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int m;
    int n;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        m = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          n = paramQQAppInterface.a().a(str, 1008);
          if (n <= 0) {
            break label98;
          }
        }
        else
        {
          return m;
        }
      }
      else
      {
        return 0;
      }
    }
    for (;;)
    {
      m += n;
      break;
      label98:
      n = 0;
    }
  }
  
  public EcShopData a()
  {
    Object localObject3 = null;
    i();
    Object localObject4 = this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = localObject3;
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          localObject1 = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(0);
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public EcShopData a(String paramString)
  {
    i();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      ??? = localEcShopData;
      if (localEcShopData == null)
      {
        localEcShopData = new EcShopData();
        localEcShopData.mUin = paramString;
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ??? = localEcShopData;
        if (localQQMessageFacade != null)
        {
          paramString = localQQMessageFacade.a(paramString, 1008);
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
    Object localObject = paramString;
    if (paramQQAppInterface != null)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        localObject = paramString;
        if (localPublicAccountDataManager != null)
        {
          localObject = localPublicAccountDataManager.b(paramString);
          if (localObject == null) {
            break label78;
          }
        }
      }
    }
    label78:
    for (localObject = ((PublicAccountInfo)localObject).name;; localObject = paramString)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramQQAppInterface = PublicAccountUtil.a(paramQQAppInterface, paramString);
        if (paramQQAppInterface != null)
        {
          localObject = paramQQAppInterface.name;
          return localObject;
        }
      }
      return localObject;
    }
  }
  
  public List a()
  {
    int n = 0;
    i();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          m = this.jdField_a_of_type_JavaUtilList.size();
          ArrayList localArrayList = new ArrayList(m);
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder().append("getAllEcShopAssitData size: ");
            if (localArrayList == null)
            {
              m = n;
              QLog.d("EcShopAssistantManager", 2, m);
            }
          }
          else
          {
            return localArrayList;
          }
        }
        else
        {
          m = 0;
        }
      }
      int m = localObject2.size();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EcShopData localEcShopData;
    do
    {
      return;
      localEcShopData = a();
    } while (localEcShopData == null);
    a(localEcShopData.mLastMsgTime);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putLong("last_read_time", paramLong).commit();
    this.jdField_c_of_type_Long = paramLong;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      h();
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      } while (localObject2 == null);
      this.jdField_e_of_type_Boolean = paramBoolean;
      Object localObject2 = ((RecentUserProxy)localObject1).a(AppConstants.aa, 7120);
      if (((RecentUser)localObject2).lastmsgtime < paramLong) {
        ((RecentUser)localObject2).lastmsgtime = paramLong;
      }
      ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
      ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    } while (localObject1 == null);
    ((MqqHandler)localObject1).sendEmptyMessage(1009);
  }
  
  public void a(Intent paramIntent, Context paramContext, int paramInt)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      return;
    }
    Bundle localBundle;
    if (paramIntent.getExtras() == null)
    {
      localBundle = new Bundle();
      localBundle.putParcelableArrayList("datas", (ArrayList)b());
      if (!TextUtils.isEmpty(this.j)) {
        localBundle.putString("ad_logo", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        localBundle.putString("ad_jump", this.k);
      }
      if (this.jdField_b_of_type_Long != 0L) {
        localBundle.putLong("ad_id", this.jdField_b_of_type_Long);
      }
      this.jdField_f_of_type_Boolean = true;
      localBundle.putBoolean("is_tab_show", this.jdField_b_of_type_Boolean);
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (!"com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName));
    }
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_tool_exist", bool);
      localBundle.putLong("click_time", System.currentTimeMillis());
      localBundle.putStringArray("urls", this.jdField_a_of_type_ArrayOfJavaLangString);
      SharedPreferences localSharedPreferences = a();
      if (localSharedPreferences.getBoolean("folder_tab_red", false)) {}
      for (bool = true;; bool = false)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (paramInt >= 0)
        {
          if (paramInt <= 0) {
            break label705;
          }
          bool = true;
        }
        label390:
        label685:
        label697:
        label705:
        for (;;)
        {
          label251:
          localBundle.putBoolean("hasUnread", bool);
          localBundle.putLong("last_read_folder", localSharedPreferences.getLong("last_read_folder", 0L));
          localBundle.putLong("latest_time", localSharedPreferences.getLong("latest_time", 0L));
          localBundle.putInt("unReadNum", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b());
          localBundle.putBoolean("isDefaultTheme", ThemeUtil.isDefaultOrDIYTheme(false));
          Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          String str = this.jdField_a_of_type_ArrayOfJavaLangString[1];
          if (bool)
          {
            paramContext = "1";
            label370:
            str = URLUtil.a(str, "has_reddot", paramContext);
            if (localObject != null) {
              break label685;
            }
            paramContext = "0";
            localObject = URLUtil.a(str, "gender", paramContext);
            localBundle.putInt("PUSH_TASK_ID", localSharedPreferences.getInt("PUSH_TASK_ID", 0));
            localBundle.putString("str_ecshop_diy", localSharedPreferences.getString("str_ecshop_diy", ""));
            localBundle.putInt("PUSH_TASK_TYPE", localSharedPreferences.getInt("PUSH_TASK_TYPE", 0));
            localBundle.putString("PUSH_TASK_INFO", localSharedPreferences.getString("PUSH_TASK_INFO", ""));
            localBundle.putLong("PUSH_RECEIVE_TIME", localSharedPreferences.getLong("PUSH_RECEIVE_TIME", 0L));
            paramContext = (Context)localObject;
            if (!TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
              paramContext = URLUtil.a((String)localObject, "jumpUrl", localSharedPreferences.getString("PUSH_JUMP_URL", ""));
            }
            if (!this.jdField_d_of_type_Boolean) {
              break label697;
            }
          }
          for (localObject = String.valueOf(localSharedPreferences.getInt("FOLDER_MSG_TYPE", -1));; localObject = "0")
          {
            paramContext = URLUtil.a(URLUtil.a(paramContext, "type", (String)localObject), "taskType", String.valueOf(localSharedPreferences.getInt("PUSH_TASK_TYPE", 0)));
            paramIntent.putExtra("bundle", localBundle);
            paramIntent.putExtra("url", paramContext);
            return;
            localBundle = paramIntent.getExtras();
            break;
            if (paramContext == null) {
              break label705;
            }
            paramContext = paramContext.b(AppConstants.aa, 7120);
            if (paramContext == null) {
              break label705;
            }
            paramContext = RecentDataListManager.a(paramContext.uin, paramContext.type);
            paramContext = RecentDataListManager.a().a(paramContext);
            if ((paramContext == null) || (paramContext.jdField_c_of_type_Int <= 0)) {
              break label705;
            }
            bool = true;
            break label251;
            paramContext = "0";
            break label370;
            paramContext = String.valueOf(((Friends)localObject).gender);
            break label390;
          }
        }
      }
    }
  }
  
  public void a(EcShopData paramEcShopData)
  {
    if ((paramEcShopData == null) || (TextUtils.isEmpty(paramEcShopData.mUin))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramEcShopData.mUin, paramEcShopData);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramEcShopData);
          m = 0;
          if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label291;
          }
          EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(m);
          if (Math.max(paramEcShopData.mLastMsgTime, paramEcShopData.mLastDraftTime) <= Math.max(localEcShopData.mLastMsgTime, localEcShopData.mLastDraftTime)) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(m, paramEcShopData);
          m = 1;
          if (m == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramEcShopData);
          }
        }
        ??? = (ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
        if (paramEcShopData.getStatus() == 1000)
        {
          ((ProxyManager)???).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 3, null);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EcShopAssistantManager", 2, "saveEcShopData(db&cache) puin: " + paramEcShopData.mUin + ", status: " + paramEcShopData.getStatus());
          return;
          paramEcShopData = finally;
          throw paramEcShopData;
          m += 1;
        }
      }
      ((ProxyManager)???).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 4, null);
      continue;
      label291:
      int m = 0;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.l = paramQQAppInterface.getAccount();
      Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences(this.l, 0);
      this.jdField_g_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_show_in_msg", true);
      this.jdField_h_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("ec_shop_assist_deleted", false);
      this.jdField_c_of_type_Long = ((SharedPreferences)localObject2).getLong("last_read_time", 0L);
      Object localObject3 = a();
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilSet = SharedPreferencesHandler.a((SharedPreferences)localObject2, "ec_shop_assist_new_unread_list", null);
        if (this.jdField_a_of_type_JavaUtilSet == null)
        {
          this.jdField_a_of_type_JavaUtilSet = new HashSet();
          if (c())
          {
            c(false);
            localObject2 = paramQQAppInterface.a();
            if (localObject2 == null) {
              return;
            }
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              EcShopData localEcShopData = (EcShopData)((Iterator)localObject3).next();
              QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localEcShopData.mUin, 1008);
              if ((paramQQAppInterface.a().a(localEcShopData.mUin, 1008) > 0) && (localMessage.time > this.jdField_c_of_type_Long)) {
                a(localMessage.frienduin, paramQQAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "addMsgToAssist puin: " + paramMessageRecord.senderuin);
    }
    SharedPreferences localSharedPreferences = a();
    String str = paramMessageRecord.frienduin;
    long l1 = paramMessageRecord.time;
    if ((!TextUtils.isEmpty(str)) && (str.equals(jdField_g_of_type_JavaLangString)))
    {
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
      }
      jdField_g_of_type_JavaLangString = null;
    }
    EcShopData localEcShopData = a(str);
    localEcShopData.mImgInfo = "";
    if ((paramMessageRecord != null) && (paramMessageRecord.time > l1)) {}
    for (localEcShopData.mLastMsgTime = paramMessageRecord.time;; localEcShopData.mLastMsgTime = l1)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localEcShopData.mUin, 1008);
      if (localMessage != null)
      {
        long l2 = localMessage.time;
        if (l2 > localEcShopData.mLastMsgTime) {
          localEcShopData.mLastMsgTime = l2;
        }
        if ((l2 > a().getLong("latest_time", 0L)) && (localSharedPreferences != null)) {
          localSharedPreferences.edit().putLong("latest_time", l2).commit();
        }
      }
      a(localEcShopData);
      a(paramMessageRecord, str);
      if (this.jdField_h_of_type_Boolean) {
        a(false);
      }
      a(paramQQAppInterface, str);
      a(l1);
      a(str);
      if (TextUtils.isEmpty(localSharedPreferences.getString("PUSH_JUMP_URL", ""))) {
        break;
      }
      localSharedPreferences.edit().putString("PUSH_JUMP_URL", "").commit();
      return;
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      Intent localIntent = new Intent("action_on_shop_msg_receive");
      localIntent.putParcelableArrayListExtra("datas", (ArrayList)b());
      if ((!TextUtils.isEmpty(paramString)) && ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())))) {
        localIntent.putExtra("uin", paramString);
      }
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
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
    a(null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "refreshSettings.... paUin: " + paramString1 + ", src: " + paramString2);
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ??? = paramString2.a(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).type == 1008) && (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin)) && (!((RecentUser)localObject4).shouldShowInRecentList()))
        {
          ((ArrayList)localObject2).add(localObject4);
          if (QLog.isColorLevel()) {
            QLog.d("EcShopAssistantManager", 2, "add to ecshop folder puin: " + ((RecentUser)localObject4).uin + ", size: " + ((ArrayList)localObject2).size());
          }
        }
      }
    }
    i();
    Object localObject5;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (EcShopData)((Iterator)localObject4).next();
          if ((!ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject5).mUin)) && (!((EcShopData)localObject5).mUin.equalsIgnoreCase(jdField_g_of_type_JavaLangString)))
          {
            ((ArrayList)localObject1).add(localObject5);
            if (QLog.isColorLevel()) {
              QLog.d("EcShopAssistantManager", 2, "remove form ecshop folder puin: " + ((EcShopData)localObject5).mUin);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "toRecentUser size: " + ((ArrayList)localObject1).size());
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject2).next();
        localObject4 = a(((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((EcShopData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((EcShopData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((EcShopData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a((EcShopData)localObject4);
          paramString2.b((RecentUser)???);
          a(((RecentUser)???).uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EcShopData)((Iterator)localObject1).next();
        ??? = paramString2.a(((EcShopData)localObject2).mUin, 1008);
        ((RecentUser)???).uin = ((EcShopData)localObject2).mUin;
        ((RecentUser)???).type = 1008;
        ((RecentUser)???).lastmsgtime = ((EcShopData)localObject2).mLastMsgTime;
        ((RecentUser)???).lastmsgdrafttime = ((EcShopData)localObject2).mLastDraftTime;
        if (a(paramString1, ((EcShopData)localObject2).mUin))
        {
          localObject4 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if ((localObject4 != null) && (((PublicAccountDataManager)localObject4).c(((EcShopData)localObject2).mUin) != null))
          {
            paramString2.a((RecentUser)???);
            if (QLog.isColorLevel()) {
              QLog.d("EcShopAssistantManager", 2, "add to msgtab puin: " + ((EcShopData)localObject2).mUin);
            }
          }
        }
      }
    }
    paramString2 = a();
    if (paramString2 != null) {
      a(paramString2.mLastMsgTime);
    }
    if (paramString1 != null) {
      paramString1.a();
    }
    a(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("ec_shop_assist_deleted", paramBoolean).commit();
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("init_ec_shop_assist", true);
  }
  
  public boolean a(AbsStructMsgElement paramAbsStructMsgElement, Activity paramActivity)
  {
    if (paramAbsStructMsgElement == null) {
      return false;
    }
    if (((paramAbsStructMsgElement.a instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsgElement.a).mStructMsgItemLists != null))
    {
      Object localObject = (AbsStructMsgElement)((AbsShareMsg)paramAbsStructMsgElement.a).mStructMsgItemLists.get(0);
      if (((localObject instanceof AbsStructMsgItem)) && ("5".equals(((AbsStructMsgItem)localObject).p)))
      {
        paramAbsStructMsgElement = new qq_ad_get.QQAdGetRsp.AdInfo.DestInfo();
        paramAbsStructMsgElement.canvas_json.set(((AbsStructMsgElement)localObject).o);
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo localTraceInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
        localTraceInfo.traceid.set(((AbsStructMsgElement)localObject).n);
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo localReportInfo = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
        localReportInfo.exposure_url.set(((AbsStructMsgElement)localObject).q);
        localReportInfo.landing_page_report_url.set(((AbsStructMsgElement)localObject).m);
        localReportInfo.trace_info.set(localTraceInfo);
        localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.set(localReportInfo);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).dest_info.set(paramAbsStructMsgElement);
        GdtCanvasBaseFragment.a(paramActivity, ShopCanvasFragment.class, GdtCanvasDataBuilder.a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject)));
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return ((jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_JavaUtilList.contains(paramString))) || (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
  }
  
  public List b()
  {
    if (!this.jdField_f_of_type_Boolean) {
      f();
    }
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
    SharedPreferences localSharedPreferences = a();
    ArrayList localArrayList = new ArrayList();
    EcShopData localEcShopData;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label408;
        }
        localEcShopData = (EcShopData)localIterator.next();
        if ((TextUtils.isEmpty(localEcShopData.mUin)) || (!localEcShopData.mUin.equals(jdField_g_of_type_JavaLangString))) {
          break;
        }
        localObject3 = new RecentShopParcel();
        ((RecentShopParcel)localObject3).jdField_a_of_type_JavaLangString = localEcShopData.mUin;
        ((RecentShopParcel)localObject3).jdField_b_of_type_JavaLangString = localSharedPreferences.getString("ad_nick", "");
        ((RecentShopParcel)localObject3).jdField_d_of_type_JavaLangString = localSharedPreferences.getString("ad_title", "");
        ((RecentShopParcel)localObject3).jdField_e_of_type_JavaLangString = localEcShopData.mImgInfo;
        if (localSharedPreferences.getBoolean("ad_cert", false))
        {
          ((RecentShopParcel)localObject3).jdField_a_of_type_Int = 2130839745;
          ((RecentShopParcel)localObject3).jdField_b_of_type_Int = 0;
          ((RecentShopParcel)localObject3).jdField_c_of_type_Int = 1;
          localArrayList.add(localObject3);
        }
      }
      ((RecentShopParcel)localObject3).jdField_a_of_type_Int = 0;
    }
    Object localObject3 = new RecentItemEcShop(localEcShopData);
    ((RecentItemEcShop)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext());
    RecentShopParcel localRecentShopParcel = new RecentShopParcel();
    localRecentShopParcel.jdField_a_of_type_JavaLangString = localEcShopData.mUin;
    localRecentShopParcel.jdField_b_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEcShopData.mUin);
    localRecentShopParcel.jdField_c_of_type_JavaLangString = ((RecentItemEcShop)localObject3).jdField_c_of_type_JavaLangString;
    localRecentShopParcel.jdField_d_of_type_JavaLangString = String.valueOf(((RecentItemEcShop)localObject3).jdField_c_of_type_JavaLangCharSequence);
    localRecentShopParcel.jdField_e_of_type_JavaLangString = localEcShopData.mImgInfo;
    PublicAccountInfo localPublicAccountInfo = localObject2.c(localEcShopData.mUin);
    if ((localPublicAccountInfo != null) && (localPublicAccountInfo.certifiedGrade > 0L)) {}
    for (localRecentShopParcel.jdField_a_of_type_Int = 2130839745;; localRecentShopParcel.jdField_a_of_type_Int = 0)
    {
      localRecentShopParcel.jdField_b_of_type_Int = ((RecentItemEcShop)localObject3).jdField_c_of_type_Int;
      localRecentShopParcel.jdField_c_of_type_Int = 0;
      localRecentShopParcel.jdField_a_of_type_Long = ((RecentItemEcShop)localObject3).a();
      localRecentShopParcel.jdField_b_of_type_Long = localEcShopData.mLastDraftTime;
      localArrayList.add(localRecentShopParcel);
      break;
    }
    label408:
    return localArrayList;
  }
  
  public void b()
  {
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      localObject = FileUtils.a((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      int m;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("shopFolderName")) {
          jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("shopFolderName");
        }
        if (((JSONObject)localObject).has("shopFolderIcon")) {
          jdField_d_of_type_JavaLangString = ((JSONObject)localObject).getString("shopFolderIcon");
        }
        if (!((JSONObject)localObject).has("shopButton")) {
          break label208;
        }
        localObject = ((JSONObject)localObject).getJSONArray("shopButton");
        if (!QLog.isColorLevel()) {
          break label245;
        }
        QLog.i("EcShopAssistantManager", 2, "shopButton info found:" + ((JSONArray)localObject).toString());
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        String str;
        int n;
        if (!QLog.isColorLevel()) {
          break label208;
        }
        QLog.d("EcShopAssistantManager", 2, "parse banner config fail", localException);
      }
      if (m < ((JSONArray)localObject).length())
      {
        localJSONObject = (JSONObject)((JSONArray)localObject).get(m);
        str = localJSONObject.getString("url");
        n = localJSONObject.getInt("id");
        this.jdField_a_of_type_ArrayOfJavaLangString[(n - 1)] = str;
        m += 1;
      }
      else
      {
        label208:
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("EcShopAssistantManager", 2, "banner json config file is not existed path=" + jdField_a_of_type_JavaLangString);
        return;
        label245:
        m = 0;
      }
    }
  }
  
  public void b(String paramString)
  {
    ThreadManager.post(new lal(this, paramString), 5, null, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    a().edit().putBoolean("folder_tab_show", this.jdField_b_of_type_Boolean).commit();
  }
  
  public boolean b()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = a().getLong("last_stay_folder", 0L);
      l2 = this.jdField_d_of_type_Int * 1000 * 60 * 60;
    } while ((System.currentTimeMillis() - l1 >= l2 * 24L) || (!this.jdField_b_of_type_Boolean));
    if (QLog.isColorLevel()) {
      QLog.i("EcShopAssistantManager", 2, "lastEnterShop:" + l1 + ",dayLimit:" + this.jdField_d_of_type_Int);
    }
    return true;
  }
  
  public void c()
  {
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
    if (localDownloaderInterface != null)
    {
      Object localObject2 = EmosmUtils.a("VIP_shop_assit_cfg", "http://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json");
      if (localDownloaderInterface.a((String)localObject2) == null)
      {
        Object localObject1 = new File(jdField_a_of_type_JavaLangString);
        localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
        if (((File)localObject1).exists())
        {
          long l1 = ((File)localObject1).lastModified();
          ((DownloadTask)localObject2).i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("last_modified_time", 0L);
          if (Long.valueOf(l1).longValue() != ((DownloadTask)localObject2).i) {
            ((DownloadTask)localObject2).k = true;
          }
        }
        ((DownloadTask)localObject2).jdField_h_of_type_Boolean = true;
        ((DownloadTask)localObject2).n = false;
        localObject1 = new Bundle();
        localDownloaderInterface.a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject1);
      }
    }
  }
  
  public void d()
  {
    for (;;)
    {
      try
      {
        i();
        RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        Object localObject = localRecentUserProxy.a(false);
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((1008 == localRecentUser.type) && (ServiceAccountFolderManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)))
        {
          EcShopData localEcShopData = a(localRecentUser.uin);
          localEcShopData.mLastDraftTime = localRecentUser.lastmsgdrafttime;
          localEcShopData.mLastMsgTime = localRecentUser.lastmsgtime;
          if (localEcShopData.mLastMsgTime == 0L)
          {
            QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localEcShopData.mUin, 1008);
            if (localMessage != null)
            {
              l1 = localMessage.time;
              localEcShopData.mLastMsgTime = l1;
            }
          }
          else
          {
            a(localEcShopData);
            localRecentUserProxy.b(localRecentUser);
            a(localEcShopData.mUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            continue;
          }
          long l1 = localEcShopData.mLastMsgTime;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EcShopAssistantManager", 2, "initEcShopAssist fail msg:" + localException.getMessage());
        }
        return;
      }
    }
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    if (localPublicAccountHandler != null) {
      localPublicAccountHandler.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("init_ec_shop_assist", false).commit();
  }
  
  public void e()
  {
    if (a()) {
      d();
    }
    a();
  }
  
  void f()
  {
    Object localObject1 = a();
    int m;
    Object localObject2;
    SharedPreferences localSharedPreferences;
    boolean bool;
    long l1;
    int i1;
    int i2;
    long l2;
    int n;
    if (localObject1 == null)
    {
      m = 0;
      localObject2 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      localSharedPreferences = a();
      bool = localSharedPreferences.getBoolean("is_ad_added", false);
      l1 = localSharedPreferences.getLong("ad_puin", 0L);
      this.jdField_b_of_type_Long = localSharedPreferences.getLong("ad_id", 0L);
      jdField_g_of_type_JavaLangString = String.valueOf(l1);
      this.j = localSharedPreferences.getString("ad_icon_url", null);
      this.k = localSharedPreferences.getString("ad_url", null);
      i1 = localSharedPreferences.getInt("ad_start", 0);
      i2 = localSharedPreferences.getInt("ad_end", 0);
      l2 = System.currentTimeMillis() / 1000L;
      if ((!bool) && (localSharedPreferences.contains("ad_id")) && (m > 0))
      {
        if ((l2 <= i1) || (l2 >= i2) || (((PublicAccountDataManager)localObject2).a(Long.valueOf(l1)))) {
          break label571;
        }
        localObject2 = new EcShopData();
        ((EcShopData)localObject2).mUin = String.valueOf(l1);
        ((EcShopData)localObject2).mImgInfo = localSharedPreferences.getString("ad_pics", null);
        n = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((n >= m) || (n >= 2))
        {
          a((EcShopData)localObject2);
          m = 1;
          localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
          if ((m != 0) || (!localSharedPreferences.getBoolean("is_ad_added", false))) {
            break label501;
          }
          localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
          label314:
          if (m != 0) {
            break label543;
          }
          jdField_g_of_type_JavaLangString = "";
          return;
          m = ((List)localObject1).size();
          break;
        }
        ((EcShopData)localObject2).mLastMsgTime = (((EcShopData)((List)localObject1).get(n)).mLastMsgTime - 1L);
        n += 1;
      }
    }
    if (bool)
    {
      n = 0;
      label370:
      if (n >= m) {
        break label576;
      }
      if (!String.valueOf(l1).equals(((EcShopData)((List)localObject1).get(n)).mUin)) {}
    }
    label543:
    label571:
    label576:
    for (localObject1 = (EcShopData)((List)localObject1).get(n);; localObject1 = null)
    {
      if (((l2 < i1) || (l2 > i2) || (((PublicAccountDataManager)localObject2).a(Long.valueOf(l1)))) && (localObject1 != null))
      {
        b(((EcShopData)localObject1).mUin);
        m = 0;
        break;
        n += 1;
        break label370;
      }
      if (localObject1 != null)
      {
        m = 1;
        localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
        break;
        label501:
        if ((m == 0) || (!QLog.isColorLevel())) {
          break label314;
        }
        QLog.i("EcShopAssistantManager", 2, "show ad ,puin=" + jdField_g_of_type_JavaLangString);
        break label314;
        ((EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134246436, null, null, null, null, this.jdField_b_of_type_Long, false);
        return;
      }
      m = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label10:
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = null;
      return;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager
 * JD-Core Version:    0.7.0.1
 */