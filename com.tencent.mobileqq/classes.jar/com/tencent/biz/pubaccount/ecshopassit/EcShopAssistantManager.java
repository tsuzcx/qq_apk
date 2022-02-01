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
import org.json.JSONArray;
import org.json.JSONObject;

public class EcShopAssistantManager
  implements Manager
{
  public static int a;
  public static final String a;
  public static HashMap<String, String> a;
  public static boolean a;
  public static final String b;
  public static HashMap<String, Long> b;
  public static List<String> b;
  public static String c;
  public static List<String> c;
  public static String d;
  public static final String e;
  public static final String f;
  public static String g;
  public static final String h;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new EcShopAssistantManager.4(this);
  private EcShopAssistantManager.EcShopAssistantDownloadListener jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager$EcShopAssistantDownloadListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new EcShopAssistantManager.5(this);
  final Object jdField_a_of_type_JavaLangObject = new Object();
  public List<EcShopData> a;
  private Map<String, EcShopData> jdField_a_of_type_JavaUtilMap;
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  public String[] a;
  public int b;
  public long b;
  final Object b;
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
  public String j = null;
  public String k = null;
  private String l;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("shop_assit_banner_json.txt");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".shop_assit/image/");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Int = 600000;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqshp_client_log_wl_conf.json");
    jdField_e_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qqshp_client_log_jd_conf.json");
    jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    jdField_b_of_type_JavaUtilList = null;
    jdField_c_of_type_JavaUtilList = null;
    jdField_a_of_type_Boolean = true;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir().getAbsoluteFile());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("animConfig/red_packet.png");
    jdField_h_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public EcShopAssistantManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "https://gouwu.qq.com/m/cgi-bin/shop/discover?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/haowu.html?_wv=3&max_age=600", "https://gouwu.qq.com/m/cgi-bin/shop/nearby?_wv=1027", "https://imgcache.qq.com/zzapp/gwmobile/html/my.html?_wv=3" };
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.l = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList = null;
      ThreadManager.post(new EcShopAssistantManager.1(this), 5, null, true);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager$EcShopAssistantDownloadListener = new EcShopAssistantManager.EcShopAssistantDownloadListener(this);
      return;
    }
  }
  
  public static SharedPreferences a()
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
  
  public static Drawable a(Context paramContext)
  {
    if (!TextUtils.isEmpty(jdField_d_of_type_JavaLangString))
    {
      Object localObject1 = paramContext.getResources().getDrawable(2130839505);
      Object localObject2 = jdField_d_of_type_JavaLangString.split("/");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject3).append(localObject2[(localObject2.length - 1)]);
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = jdField_d_of_type_JavaLangString;
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_icon", (String)localObject3, (String)localObject2), (Drawable)localObject1, (Drawable)localObject1);
        return localObject1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        return paramContext.getResources().getDrawable(2130847270);
      }
    }
    return paramContext.getResources().getDrawable(2130847270);
  }
  
  public static String a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    Object localObject = jdField_c_of_type_JavaUtilList;
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
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.a(paramString);
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
      if ((paramQQAppInterface.getConversationFacade().a(paramString, 1008) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h();
      return;
    }
  }
  
  private boolean a(long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return false;
      }
      if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
      {
        localObject2 = ((RecentUserProxy)localObject1).a(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
        if (((RecentUser)localObject2).lastmsgtime < paramLong) {
          ((RecentUser)localObject2).lastmsgtime = paramLong;
        }
        EcShopData localEcShopData = a();
        if (localEcShopData != null)
        {
          ((RecentUser)localObject2).lastmsgtime = localEcShopData.mLastMsgTime;
          ((RecentUser)localObject2).lastmsgdrafttime = localEcShopData.mLastDraftTime;
        }
        else if (this.jdField_e_of_type_Boolean)
        {
          ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
        }
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
        QLog.d("EcShopAssistantManager", 2, "update ecshop folder...");
      }
      else
      {
        localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
        if (localObject2 != null) {
          ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
        }
        QLog.d("EcShopAssistantManager", 2, "del ecshop folder...");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.remove(localEcShopData);
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
        if (this.jdField_f_of_type_Boolean)
        {
          paramEntityManager = new Intent("action_on_shop_msg_receive");
          paramEntityManager.putParcelableArrayListExtra("datas", (ArrayList)b());
          BaseApplicationImpl.getContext().sendBroadcast(paramEntityManager);
        }
        return bool;
      }
    }
  }
  
  private void c(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, 1008) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      h();
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("is_update_ec_shop_assist", paramBoolean).commit();
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
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 179	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 516	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   11: invokevirtual 522	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 4
    //   21: astore_2
    //   22: aload 4
    //   24: ldc_w 406
    //   27: iconst_0
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: ldc_w 524
    //   35: aconst_null
    //   36: invokevirtual 528	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   39: astore 5
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: astore_2
    //   47: new 43	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   54: astore 6
    //   56: aload 4
    //   58: astore_3
    //   59: aload 4
    //   61: astore_2
    //   62: aload 6
    //   64: ldc_w 530
    //   67: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   89: invokeinterface 534 1 0
    //   94: istore_1
    //   95: aload 4
    //   97: astore_3
    //   98: aload 4
    //   100: astore_2
    //   101: aload 6
    //   103: iload_1
    //   104: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 4
    //   110: astore_3
    //   111: aload 4
    //   113: astore_2
    //   114: ldc_w 421
    //   117: iconst_2
    //   118: aload 6
    //   120: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 428	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload 4
    //   128: astore_3
    //   129: aload 4
    //   131: astore_2
    //   132: aload_0
    //   133: getfield 134	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   136: astore 6
    //   138: aload 4
    //   140: astore_3
    //   141: aload 4
    //   143: astore_2
    //   144: aload 6
    //   146: monitorenter
    //   147: aload_0
    //   148: aload 5
    //   150: putfield 190	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   153: aload_0
    //   154: getfield 190	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   157: ifnonnull +16 -> 173
    //   160: aload_0
    //   161: new 473	java/util/ArrayList
    //   164: dup
    //   165: bipush 16
    //   167: invokespecial 540	java/util/ArrayList:<init>	(I)V
    //   170: putfield 190	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   173: aload 6
    //   175: monitorexit
    //   176: aload 4
    //   178: astore_3
    //   179: aload 4
    //   181: astore_2
    //   182: aload_0
    //   183: getfield 188	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   186: astore 5
    //   188: aload 4
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: aload 5
    //   196: monitorenter
    //   197: aload_0
    //   198: getfield 188	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   201: invokeinterface 543 1 0
    //   206: aload_0
    //   207: getfield 190	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   210: invokeinterface 547 1 0
    //   215: astore_2
    //   216: aload_2
    //   217: invokeinterface 552 1 0
    //   222: ifeq +31 -> 253
    //   225: aload_2
    //   226: invokeinterface 556 1 0
    //   231: checkcast 406	com/tencent/biz/pubaccount/ecshopassit/EcShopData
    //   234: astore_3
    //   235: aload_0
    //   236: getfield 188	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   239: aload_3
    //   240: getfield 559	com/tencent/biz/pubaccount/ecshopassit/EcShopData:mUin	Ljava/lang/String;
    //   243: aload_3
    //   244: invokeinterface 563 3 0
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
    //   303: new 43	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   310: astore 5
    //   312: aload_2
    //   313: astore_3
    //   314: aload 5
    //   316: ldc_w 565
    //   319: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_2
    //   324: astore_3
    //   325: aload 5
    //   327: aload 4
    //   329: invokevirtual 568	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_2
    //   337: astore_3
    //   338: ldc_w 421
    //   341: iconst_2
    //   342: aload 5
    //   344: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 570	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload_2
    //   351: ifnull +7 -> 358
    //   354: aload_2
    //   355: invokevirtual 573	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   358: return
    //   359: aload_3
    //   360: ifnull +7 -> 367
    //   363: aload_3
    //   364: invokevirtual 573	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   367: goto +5 -> 372
    //   370: aload_2
    //   371: athrow
    //   372: goto -2 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	EcShopAssistantManager
    //   77	27	1	m	int
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
  
  private void h()
  {
    ThreadManager.executeOnSubThread(new EcShopAssistantManager.2(this));
  }
  
  private void i()
  {
    for (;;)
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
      }
      int m = 0;
    }
  }
  
  public int a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    int n = 0;
    int m = 0;
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      for (;;)
      {
        n = m;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (EcShopData)localIterator.next();
        localObject1 = null;
        n = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject2).mUin);
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        if (localQQMessageFacade != null) {
          localObject1 = localQQMessageFacade.getLastMessage(((EcShopData)localObject2).mUin, n);
        }
        if (localObject1 != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
          if (localObject2 != null) {
            m += ((ConversationFacade)localObject2).a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
          }
        }
      }
    }
    return n;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    int m;
    int n;
    label99:
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        m = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          n = paramQQAppInterface.getConversationFacade().a(str, 1008);
          if (n > 0) {
            break label99;
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
  }
  
  public EcShopData a()
  {
    i();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(0);
          return localEcShopData;
        }
      }
      Object localObject2 = null;
    }
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
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
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
          ??? = new StringBuilder();
          ((StringBuilder)???).append("getAllEcShopAssitData size: ");
          ((StringBuilder)???).append(localArrayList.size());
          QLog.d("EcShopAssistantManager", 2, ((StringBuilder)???).toString());
          return localArrayList;
        }
      }
      int m = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    EcShopData localEcShopData = a();
    if (localEcShopData != null) {
      a(localEcShopData.mLastMsgTime);
    }
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (localObject2 == null) {
      return;
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
    localObject2 = ((RecentUserProxy)localObject1).a(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
    if (((RecentUser)localObject2).lastmsgtime < paramLong) {
      ((RecentUser)localObject2).lastmsgtime = paramLong;
    }
    ((RecentUser)localObject2).lastmsgdrafttime = ((RecentUser)localObject2).lastmsgtime;
    ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
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
      localBundle.putParcelableArrayList("datas", (ArrayList)b());
      if (!TextUtils.isEmpty(this.j)) {
        localBundle.putString("ad_logo", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        localBundle.putString("ad_jump", this.k);
      }
      long l1 = this.jdField_b_of_type_Long;
      if (l1 != 0L) {
        localBundle.putLong("ad_id", l1);
      }
      this.jdField_f_of_type_Boolean = true;
      localBundle.putBoolean("is_tab_show", this.jdField_b_of_type_Boolean);
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
      localBundle.putStringArray("urls", this.jdField_a_of_type_ArrayOfJavaLangString);
      SharedPreferences localSharedPreferences = a();
      boolean bool2 = localSharedPreferences.getBoolean("folder_tab_red", false);
      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
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
          paramContext = paramContext.b(AppConstants.EC_SHOP_ASSISTANT_UIN, 7120);
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
      localBundle.putInt("unReadNum", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b());
      localBundle.putBoolean("isDefaultTheme", ThemeUtil.isDefaultOrDIYTheme(false));
      Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      String str2 = this.jdField_a_of_type_ArrayOfJavaLangString[1];
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
      if (this.jdField_d_of_type_Boolean) {
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
      int m;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramEcShopData.mUin, paramEcShopData);
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            this.jdField_a_of_type_JavaUtilList.remove(paramEcShopData);
            int i1 = 0;
            m = 0;
            int n = i1;
            if (m < this.jdField_a_of_type_JavaUtilList.size())
            {
              EcShopData localEcShopData = (EcShopData)this.jdField_a_of_type_JavaUtilList.get(m);
              if (Math.max(paramEcShopData.mLastMsgTime, paramEcShopData.mLastDraftTime) <= Math.max(localEcShopData.mLastMsgTime, localEcShopData.mLastDraftTime)) {
                break label316;
              }
              this.jdField_a_of_type_JavaUtilList.add(m, paramEcShopData);
              n = 1;
            }
            if (n == 0) {
              this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramEcShopData);
            }
          }
          ??? = (ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
          if (paramEcShopData.getStatus() == 1000) {
            ((ProxyManager)???).addMsgQueue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 3, null);
          } else {
            ((ProxyManager)???).addMsgQueue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, paramEcShopData.getTableName(), paramEcShopData, 4, null);
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
      m += 1;
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
            localObject2 = paramQQAppInterface.getMessageFacade();
            if (localObject2 == null) {
              return;
            }
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              EcShopData localEcShopData = (EcShopData)((Iterator)localObject3).next();
              Message localMessage = ((QQMessageFacade)localObject2).getLastMessage(localEcShopData.mUin, 1008);
              if ((paramQQAppInterface.getConversationFacade().a(localEcShopData.mUin, 1008) > 0) && (localMessage.time > this.jdField_c_of_type_Long)) {
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
    localObject = a();
    String str = paramMessageRecord.frienduin;
    long l1 = paramMessageRecord.time;
    if ((!TextUtils.isEmpty(str)) && (str.equals(jdField_g_of_type_JavaLangString)))
    {
      ((SharedPreferences)localObject).edit().putBoolean("is_ad_added", false).commit();
      jdField_g_of_type_JavaLangString = null;
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
      if (l2 > a().getLong("latest_time", 0L)) {
        ((SharedPreferences)localObject).edit().putLong("latest_time", l2).commit();
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
    if ((localObject != null) && (!TextUtils.isEmpty(((SharedPreferences)localObject).getString("PUSH_JUMP_URL", "")))) {
      ((SharedPreferences)localObject).edit().putString("PUSH_JUMP_URL", "").commit();
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      Intent localIntent = new Intent("action_on_shop_msg_receive");
      localIntent.putParcelableArrayListExtra("datas", (ArrayList)b());
      if ((!TextUtils.isEmpty(paramString)) && ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a()) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a())))) {
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshSettings.... paUin: ");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(", src: ");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.d("EcShopAssistantManager", 2, ((StringBuilder)localObject1).toString());
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ??? = paramString2.a(false);
    Object localObject4;
    Object localObject5;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).getType() == 1008) && (ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin)) && (!RecentUserAppearLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).msgType)))
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
    i();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (EcShopData)((Iterator)localObject4).next();
          if ((!ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((EcShopData)localObject5).mUin)) && (!((EcShopData)localObject5).mUin.equalsIgnoreCase(jdField_g_of_type_JavaLangString)))
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
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(((EcShopData)localObject4).mUin, 1008);
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
          a(((RecentUser)???).uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          ((RecentUser)???).setType(1008);
          ((RecentUser)???).lastmsgtime = ((EcShopData)localObject2).mLastMsgTime;
          ((RecentUser)???).lastmsgdrafttime = ((EcShopData)localObject2).mLastDraftTime;
          if (a(paramString1, ((EcShopData)localObject2).mUin))
          {
            localObject4 = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
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
      paramString2 = a();
      if (paramString2 != null) {
        a(paramString2.mLastMsgTime);
      }
      if (paramString1 != null) {
        paramString1.close();
      }
      a(null);
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("ec_shop_assist_deleted", paramBoolean).commit();
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("init_ec_shop_assist", true);
  }
  
  public boolean a(String paramString)
  {
    List localList = jdField_b_of_type_JavaUtilList;
    return ((localList != null) && (localList.contains(paramString))) || (ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString)) || (((IEcshopService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEcshopService.class)).isInWalletReportList(paramString));
  }
  
  public List<RecentShopParcel> b()
  {
    if (!this.jdField_f_of_type_Boolean) {
      f();
    }
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    SharedPreferences localSharedPreferences = a();
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        EcShopData localEcShopData = (EcShopData)localIterator.next();
        Object localObject3;
        if ((!TextUtils.isEmpty(localEcShopData.mUin)) && (localEcShopData.mUin.equals(jdField_g_of_type_JavaLangString)))
        {
          localObject3 = new RecentShopParcel();
          ((RecentShopParcel)localObject3).jdField_a_of_type_JavaLangString = localEcShopData.mUin;
          ((RecentShopParcel)localObject3).jdField_b_of_type_JavaLangString = localSharedPreferences.getString("ad_nick", "");
          ((RecentShopParcel)localObject3).jdField_d_of_type_JavaLangString = localSharedPreferences.getString("ad_title", "");
          ((RecentShopParcel)localObject3).jdField_e_of_type_JavaLangString = localEcShopData.mImgInfo;
          if (localSharedPreferences.getBoolean("ad_cert", false)) {
            ((RecentShopParcel)localObject3).jdField_a_of_type_Int = 0;
          } else {
            ((RecentShopParcel)localObject3).jdField_a_of_type_Int = 0;
          }
          ((RecentShopParcel)localObject3).jdField_b_of_type_Int = 0;
          ((RecentShopParcel)localObject3).jdField_c_of_type_Int = 1;
          localArrayList.add(localObject3);
        }
        else
        {
          localObject3 = new RecentItemEcShop(localEcShopData);
          ((RecentItemEcShop)localObject3).update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext());
          RecentShopParcel localRecentShopParcel = new RecentShopParcel();
          localRecentShopParcel.jdField_a_of_type_JavaLangString = localEcShopData.mUin;
          localRecentShopParcel.jdField_b_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEcShopData.mUin);
          localRecentShopParcel.jdField_c_of_type_JavaLangString = ((RecentItemEcShop)localObject3).mShowTime;
          localRecentShopParcel.jdField_d_of_type_JavaLangString = String.valueOf(((RecentItemEcShop)localObject3).mLastMsg);
          localRecentShopParcel.jdField_e_of_type_JavaLangString = localEcShopData.mImgInfo;
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfoCache(localEcShopData.mUin);
          if ((localPublicAccountInfo != null) && (localPublicAccountInfo.certifiedGrade > 0L)) {
            localRecentShopParcel.jdField_a_of_type_Int = 0;
          } else {
            localRecentShopParcel.jdField_a_of_type_Int = 0;
          }
          localRecentShopParcel.jdField_b_of_type_Int = ((RecentItemEcShop)localObject3).mUnreadNum;
          localRecentShopParcel.jdField_c_of_type_Int = 0;
          localRecentShopParcel.jdField_a_of_type_Long = ((RecentItemEcShop)localObject3).getLastMsgTime();
          localRecentShopParcel.jdField_b_of_type_Long = localEcShopData.mLastDraftTime;
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
  
  public void b()
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject1).exists())
    {
      localObject1 = FileUtils.readFileContent((File)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label254;
      }
    }
    for (;;)
    {
      int m;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).has("shopFolderName")) {
          jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).getString("shopFolderName");
        }
        if (((JSONObject)localObject1).has("shopFolderIcon")) {
          jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).getString("shopFolderIcon");
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
        int n;
        if (!QLog.isColorLevel()) {
          break label254;
        }
      }
      if (m < ((JSONArray)localObject1).length())
      {
        localObject2 = (JSONObject)((JSONArray)localObject1).get(m);
        str = ((JSONObject)localObject2).getString("url");
        n = ((JSONObject)localObject2).getInt("id");
        this.jdField_a_of_type_ArrayOfJavaLangString[(n - 1)] = str;
        m += 1;
        continue;
        QLog.d("EcShopAssistantManager", 2, "parse banner config fail", localException);
        return;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("banner json config file is not existed path=");
        localStringBuilder.append(jdField_a_of_type_JavaLangString);
        QLog.d("EcShopAssistantManager", 2, localStringBuilder.toString());
      }
      else
      {
        label254:
        return;
        label255:
        m = 0;
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (paramQQAppInterface != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
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
  
  public void b(String paramString)
  {
    ThreadManager.post(new EcShopAssistantManager.3(this, paramString), 5, null, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    a().edit().putBoolean("folder_tab_show", this.jdField_b_of_type_Boolean).commit();
  }
  
  public boolean b()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    long l1 = a().getLong("last_stay_folder", 0L);
    long l2 = this.jdField_d_of_type_Int * 1000 * 60 * 60;
    if ((System.currentTimeMillis() - l1 < l2 * 24L) && (this.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("lastEnterShop:");
        localStringBuilder.append(l1);
        localStringBuilder.append(",dayLimit:");
        localStringBuilder.append(this.jdField_d_of_type_Int);
        QLog.i("EcShopAssistantManager", 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  public void c()
  {
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    if (localDownloaderInterface != null)
    {
      Object localObject2 = EmosmUtils.a("VIP_shop_assit_cfg", "https://imgcache.qq.com/zzapp/qqshop/banner/qqshop_shopinghelper_conf.json");
      if (localDownloaderInterface.getTask((String)localObject2) == null)
      {
        Object localObject1 = new File(jdField_a_of_type_JavaLangString);
        localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
        if (((File)localObject1).exists())
        {
          long l1 = ((File)localObject1).lastModified();
          ((DownloadTask)localObject2).i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("last_modified_time", 0L);
          if (Long.valueOf(l1).longValue() != ((DownloadTask)localObject2).i) {
            ((DownloadTask)localObject2).m = true;
          }
        }
        ((DownloadTask)localObject2).j = true;
        ((DownloadTask)localObject2).p = false;
        localObject1 = new Bundle();
        localDownloaderInterface.startDownload((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager$EcShopAssistantDownloadListener, (Bundle)localObject1);
      }
    }
  }
  
  public void d()
  {
    try
    {
      i();
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      localObject2 = ((RecentUserProxy)localObject1).a(false);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
          if ((1008 == localRecentUser.getType()) && (ServiceAccountFolderManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)))
          {
            EcShopData localEcShopData = a(localRecentUser.uin);
            localEcShopData.mLastDraftTime = localRecentUser.lastmsgdrafttime;
            localEcShopData.mLastMsgTime = localRecentUser.lastmsgtime;
            if (localEcShopData.mLastMsgTime == 0L)
            {
              Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(localEcShopData.mUin, 1008);
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
            a(localEcShopData.mUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
      localObject1 = (IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (localObject1 != null) {
        ((IPublicAccountHandler)localObject1).clearPublicAccountSeq();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("init_ec_shop_assist", false).commit();
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
  
  public void e()
  {
    if (a()) {
      d();
    }
    a();
  }
  
  void f()
  {
    List localList = a();
    if (localList == null) {
      m = 0;
    } else {
      m = localList.size();
    }
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    SharedPreferences localSharedPreferences = a();
    boolean bool = localSharedPreferences.getBoolean("is_ad_added", false);
    long l1 = localSharedPreferences.getLong("ad_puin", 0L);
    this.jdField_b_of_type_Long = localSharedPreferences.getLong("ad_id", 0L);
    jdField_g_of_type_JavaLangString = String.valueOf(l1);
    Object localObject2 = null;
    this.j = localSharedPreferences.getString("ad_icon_url", null);
    this.k = localSharedPreferences.getString("ad_url", null);
    int i1 = localSharedPreferences.getInt("ad_start", 0);
    int i2 = localSharedPreferences.getInt("ad_end", 0);
    long l2 = System.currentTimeMillis() / 1000L;
    int n;
    if ((!bool) && (localSharedPreferences.contains("ad_id")) && (m > 0))
    {
      if ((l2 > i1) && (l2 < i2) && (!localIPublicAccountDataManager.isFollowedUin(Long.valueOf(l1))))
      {
        localObject1 = new EcShopData();
        ((EcShopData)localObject1).mUin = String.valueOf(l1);
        ((EcShopData)localObject1).mImgInfo = localSharedPreferences.getString("ad_pics", null);
        n = 0;
        while ((n < m) && (n < 2))
        {
          ((EcShopData)localObject1).mLastMsgTime = (((EcShopData)localList.get(n)).mLastMsgTime - 1L);
          n += 1;
        }
        a((EcShopData)localObject1);
        localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
        m = 1;
        break label479;
      }
    }
    else if (bool)
    {
      n = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (n >= m) {
          break;
        }
        if (String.valueOf(l1).equals(((EcShopData)localList.get(n)).mUin))
        {
          localObject1 = (EcShopData)localList.get(n);
          break;
        }
        n += 1;
      }
      if (((l2 < i1) || (l2 > i2) || (localIPublicAccountDataManager.isFollowedUin(Long.valueOf(l1)))) && (localObject1 != null))
      {
        b(((EcShopData)localObject1).mUin);
      }
      else if (localObject1 != null)
      {
        localObject1 = localSharedPreferences.edit();
        m = 1;
        ((SharedPreferences.Editor)localObject1).putBoolean("is_ad_added", true).commit();
        break label479;
      }
    }
    int m = 0;
    label479:
    if ((m == 0) && (localSharedPreferences.getBoolean("is_ad_added", false)))
    {
      localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
    }
    else if ((m != 0) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("show ad ,puin=");
      ((StringBuilder)localObject1).append(jdField_g_of_type_JavaLangString);
      QLog.i("EcShopAssistantManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (m == 0)
    {
      jdField_g_of_type_JavaLangString = "";
      return;
    }
    Object localObject1 = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    if (localObject1 != null) {
      ((EcshopReportHandler)localObject1).a(134246436, null, null, null, null, this.jdField_b_of_type_Long, false);
    }
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label10:
      IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
      if (localIFaceDecoder != null)
      {
        localIFaceDecoder.destory();
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager$EcShopAssistantDownloadListener = null;
      return;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager
 * JD-Core Version:    0.7.0.1
 */