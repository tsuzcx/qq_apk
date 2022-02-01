package com.tencent.mobileqq.app;

import NearbyGroup.GroupInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.RecommendTroopConfigProcessor;
import com.tencent.mobileqq.config.RecommendTroopConfigProcessor.RecommendTroopConfigBean;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.recommend.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.MayKnowRecommend;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;
import tencent.im.oidb.oidb_0xc26.EntryDelay;
import tencent.im.oidb.oidb_0xc26.RecommendInfo;
import tencent.im.oidb.oidb_0xc26.RgroupInfo;
import tencent.im.oidb.oidb_0xc26.TabInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.MsgBody;

public class MayknowRecommendManager
  implements Manager
{
  public static int a;
  public static long a;
  public static final Object a;
  public static final Object b;
  private static int jdField_c_of_type_Int;
  private static int jdField_d_of_type_Int;
  public static boolean e;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new MayknowRecommendManager.1(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MayknowRecommendManager.3(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new MayknowRecommendManager.2(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private IPhoneContactListener jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener = new MayknowRecommendManager.4(this);
  private StudyModeChangeListener jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener = new MayknowRecommendManager.5(this);
  public String a;
  private ArrayList<MayKnowRecommend> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, ArrayList> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private List<RecentRecommendTroopItem> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, MayKnowExposure> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public volatile boolean a;
  public int b;
  private long jdField_b_of_type_Long = 0L;
  private final ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, byte[]> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private ArrayList<ConnectionsTabInfo> jdField_c_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, Boolean> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  boolean jdField_c_of_type_Boolean = false;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  public boolean d;
  private int jdField_e_of_type_Int = 2;
  private Object jdField_e_of_type_JavaLangObject = new Object();
  private int jdField_f_of_type_Int = 0;
  private Object jdField_f_of_type_JavaLangObject = new Object();
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 1;
  private volatile boolean jdField_g_of_type_Boolean;
  private volatile boolean h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Long = 86400000L;
    jdField_a_of_type_Int = 37;
    jdField_c_of_type_Int = 70;
    jdField_d_of_type_Int = 3;
    jdField_e_of_type_Boolean = false;
  }
  
  public MayknowRecommendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener != null)
    {
      paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.addListener(this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener);
      }
    }
    StudyModeManager.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
  }
  
  private int a(List<RecentBaseData> paramList, int paramInt1, int paramInt2)
  {
    int m = paramInt1;
    if (paramInt1 < 3)
    {
      if (paramInt2 <= 3) {
        return paramInt2;
      }
      for (paramInt2 = paramInt1; paramInt1 < paramList.size(); paramInt2 = m)
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramList.get(paramInt1);
        m = paramInt2;
        if (!RecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentBaseData)) {
          m = paramInt2 + 1;
        }
        if (m == 3) {
          return paramInt1 + 1;
        }
        paramInt1 += 1;
      }
      m = 3;
    }
    return m;
  }
  
  private ConnectionsTabInfo a(oidb_0xc26.TabInfo paramTabInfo)
  {
    ConnectionsTabInfo localConnectionsTabInfo = new ConnectionsTabInfo();
    localConnectionsTabInfo.jdField_a_of_type_Int = paramTabInfo.uint32_tab_id.get();
    localConnectionsTabInfo.jdField_b_of_type_Int = paramTabInfo.uint32_recommend_count.get();
    boolean bool = paramTabInfo.bytes_table_name.has();
    String str2 = "";
    if (bool) {
      str1 = paramTabInfo.bytes_table_name.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localConnectionsTabInfo.jdField_a_of_type_JavaLangString = str1;
    if (paramTabInfo.bytes_icon_url_select.has()) {
      str1 = paramTabInfo.bytes_icon_url_select.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localConnectionsTabInfo.jdField_b_of_type_JavaLangString = str1;
    String str1 = str2;
    if (paramTabInfo.bytes_icon_url_unselect.has()) {
      str1 = paramTabInfo.bytes_icon_url_unselect.get().toStringUtf8();
    }
    localConnectionsTabInfo.c = str1;
    return localConnectionsTabInfo;
  }
  
  private RecentRecommendTroopItem a(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onJoinedTroop uin: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    int m;
    label283:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int n = this.jdField_a_of_type_JavaUtilList.size();
      m = 0;
      localObject1 = localObject2;
      if (m < n)
      {
        if (!((RecentRecommendTroopItem)this.jdField_a_of_type_JavaUtilList.get(m)).uin.equalsIgnoreCase(paramString)) {
          break label283;
        }
        localObject2 = (RecentRecommendTroopItem)this.jdField_a_of_type_JavaUtilList.remove(m);
        localObject1 = localObject2;
        if (this.jdField_f_of_type_Int > m)
        {
          m = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (m >= this.jdField_e_of_type_Int) {
              break;
            }
            this.jdField_f_of_type_Int -= 1;
            m += 1;
          }
        }
      }
      m = this.jdField_a_of_type_JavaUtilList.size();
      localObject2 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(6, 0, 0, paramString);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject2);
      if (m == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(8113);
        return localObject1;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      paramString = ((RecentUserProxy)localObject2).b(paramString, 8113);
      if (paramString != null) {
        ((RecentUserProxy)localObject2).a(paramString);
      }
      return localObject1;
    }
  }
  
  private ArrayList<RecentRecommendTroopItem> a(ArrayList<RecentRecommendTroopItem> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      int m = paramArrayList.size() - 1;
      while (m >= 0)
      {
        if (localTroopManager.d(((RecentRecommendTroopItem)paramArrayList.get(m)).uin) != null) {
          paramArrayList.remove(m);
        }
        m -= 1;
      }
      return paramArrayList;
    }
    return new ArrayList();
  }
  
  /* Error */
  private void a(int paramInt, ArrayList<MayKnowRecommend> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +330 -> 331
    //   4: aload_0
    //   5: aload_2
    //   6: invokespecial 387	com/tencent/mobileqq/app/MayknowRecommendManager:b	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   9: astore_2
    //   10: iload_1
    //   11: bipush 23
    //   13: if_icmpne +64 -> 77
    //   16: getstatic 50	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   19: astore 4
    //   21: aload 4
    //   23: monitorenter
    //   24: aload_2
    //   25: invokevirtual 373	java/util/ArrayList:size	()I
    //   28: ifle +37 -> 65
    //   31: aload_0
    //   32: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   35: ifnull +30 -> 65
    //   38: aload_0
    //   39: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   42: invokevirtual 373	java/util/ArrayList:size	()I
    //   45: aload_2
    //   46: invokevirtual 373	java/util/ArrayList:size	()I
    //   49: iadd
    //   50: sipush 1000
    //   53: if_icmpge +12 -> 65
    //   56: aload_0
    //   57: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   60: aload_2
    //   61: invokevirtual 391	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   64: pop
    //   65: aload 4
    //   67: monitorexit
    //   68: goto +110 -> 178
    //   71: astore_2
    //   72: aload 4
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    //   77: aload_0
    //   78: getfield 119	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_f_of_type_JavaLangObject	Ljava/lang/Object;
    //   81: astore 4
    //   83: aload 4
    //   85: monitorenter
    //   86: iload_3
    //   87: ifeq +19 -> 106
    //   90: aload_0
    //   91: getfield 106	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   94: iload_1
    //   95: invokestatic 397	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aload_2
    //   99: invokevirtual 401	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: goto +72 -> 175
    //   106: aload_0
    //   107: getfield 106	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   110: iload_1
    //   111: invokestatic 397	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   114: invokevirtual 404	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 161	java/util/ArrayList
    //   120: astore 5
    //   122: aload 5
    //   124: ifnull +51 -> 175
    //   127: new 161	java/util/ArrayList
    //   130: dup
    //   131: aload 5
    //   133: invokevirtual 373	java/util/ArrayList:size	()I
    //   136: aload_2
    //   137: invokevirtual 373	java/util/ArrayList:size	()I
    //   140: iadd
    //   141: invokespecial 162	java/util/ArrayList:<init>	(I)V
    //   144: astore 6
    //   146: aload 6
    //   148: aload 5
    //   150: invokevirtual 391	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   153: pop
    //   154: aload 6
    //   156: aload_2
    //   157: invokevirtual 391	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 106	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   165: iload_1
    //   166: invokestatic 397	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aload 6
    //   171: invokevirtual 401	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload 4
    //   177: monitorexit
    //   178: aload_0
    //   179: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   182: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   185: astore 4
    //   187: aload 4
    //   189: invokevirtual 415	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   192: iload_3
    //   193: ifeq +45 -> 238
    //   196: new 295	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   203: astore 5
    //   205: aload 5
    //   207: ldc_w 417
    //   210: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 5
    //   216: iload_1
    //   217: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 5
    //   223: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: astore 5
    //   228: aload_0
    //   229: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   232: aload 5
    //   234: invokevirtual 423	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   237: pop
    //   238: aload_2
    //   239: invokevirtual 373	java/util/ArrayList:size	()I
    //   242: ifle +40 -> 282
    //   245: aload_2
    //   246: invokevirtual 427	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   249: astore_2
    //   250: aload_2
    //   251: invokeinterface 432 1 0
    //   256: ifeq +26 -> 282
    //   259: aload_2
    //   260: invokeinterface 436 1 0
    //   265: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   268: astore 5
    //   270: aload_0
    //   271: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   274: aload 5
    //   276: invokevirtual 442	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   279: goto -29 -> 250
    //   282: aload 4
    //   284: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   287: goto +25 -> 312
    //   290: astore_2
    //   291: goto +27 -> 318
    //   294: astore_2
    //   295: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +14 -> 312
    //   301: ldc_w 304
    //   304: iconst_2
    //   305: ldc_w 447
    //   308: aload_2
    //   309: invokestatic 450	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload 4
    //   314: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   317: return
    //   318: aload 4
    //   320: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   323: aload_2
    //   324: athrow
    //   325: astore_2
    //   326: aload 4
    //   328: monitorexit
    //   329: aload_2
    //   330: athrow
    //   331: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	MayknowRecommendManager
    //   0	332	1	paramInt	int
    //   0	332	2	paramArrayList	ArrayList<MayKnowRecommend>
    //   0	332	3	paramBoolean	boolean
    //   19	308	4	localObject1	Object
    //   120	155	5	localObject2	Object
    //   144	26	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   24	65	71	finally
    //   65	68	71	finally
    //   72	75	71	finally
    //   187	192	290	finally
    //   196	238	290	finally
    //   238	250	290	finally
    //   250	279	290	finally
    //   282	287	290	finally
    //   295	312	290	finally
    //   187	192	294	java/lang/Exception
    //   196	238	294	java/lang/Exception
    //   238	250	294	java/lang/Exception
    //   250	279	294	java/lang/Exception
    //   282	287	294	java/lang/Exception
    //   90	103	325	finally
    //   106	122	325	finally
    //   127	175	325	finally
    //   175	178	325	finally
    //   326	329	325	finally
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mayknow_connections_sp_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      Object localObject4 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
      if (paramArrayOfByte != null)
      {
        localObject2 = "";
        try
        {
          localObject1 = Base64.encodeToString(paramArrayOfByte, 2);
        }
        catch (Throwable localThrowable)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("saveTabCookieToSP ");
            ((StringBuilder)localObject1).append(localThrowable.toString());
            QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
        localObject2 = ((SharedPreferences)localObject4).edit();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("sp_mayknow_connections_tabinfo_cookie_");
        ((StringBuilder)localObject4).append(paramInt);
        ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject4).toString(), (String)localObject1).commit();
      }
      else
      {
        localObject1 = ((SharedPreferences)localObject4).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sp_mayknow_connections_tabinfo_cookie_");
        ((StringBuilder)localObject2).append(paramInt);
        ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString()).commit();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("saveTabCookieToSP ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" isNull ");
        boolean bool;
        if (paramArrayOfByte == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject1).append(bool);
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject1 = new byte[0];
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject1);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = new SubMsgType0x111.MsgBody();
        ((SubMsgType0x111.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x111.MsgBody)localObject).uint64_type.has()) {
          break label426;
        }
        l1 = ((SubMsgType0x111.MsgBody)localObject).uint64_type.get();
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("decodePush0x210_0x111,type = ");
          paramArrayOfByte.append(l1);
          QLog.i("MayknowRecommendManager", 2, paramArrayOfByte.toString());
        }
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (l1 == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 update list");
          }
          paramQQAppInterface.handleMayKnowRecommendPush((int)l1, null);
          return;
        }
        if (l1 == 1L)
        {
          paramArrayOfByte = new ArrayList();
          if (((SubMsgType0x111.MsgBody)localObject).rpt_msg_add_recommend_persons.has()) {
            paramArrayOfByte.addAll(MayKnowRecommend.covServerPushDataToLocal(((SubMsgType0x111.MsgBody)localObject).rpt_msg_add_recommend_persons.get(), System.currentTimeMillis()));
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("decodePush0x210_0x111 add ");
            ((StringBuilder)localObject).append(paramArrayOfByte);
            QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
          }
          paramQQAppInterface.handleMayKnowRecommendPush((int)l1, paramArrayOfByte);
          return;
        }
        if (l1 != 2L) {
          break label425;
        }
        ArrayList localArrayList = new ArrayList();
        if (((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.has()) {
          localArrayList.addAll(((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.get());
        }
        paramArrayOfByte = new ArrayList();
        localObject = localArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          long l2 = ((Long)((Iterator)localObject).next()).longValue();
          if (l2 <= 0L) {
            continue;
          }
          paramArrayOfByte.add(String.valueOf(l2));
          continue;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decodePush0x210_0x111 del ");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
        }
        paramQQAppInterface.handleMayKnowRecommendPush((int)l1, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("decodePush0x210_0x111 decode error, e=");
        paramArrayOfByte.append(paramQQAppInterface.toString());
        QLog.i("MayknowRecommendManager", 1, paramArrayOfByte.toString());
        return;
      }
      QLog.i("MayknowRecommendManager", 1, "decodePush0x210_0x111 pbData = null");
      label425:
      return;
      label426:
      long l1 = -1L;
    }
  }
  
  private void a(RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    if ((paramRecentRecommendTroopItem.labelList != null) && (!paramRecentRecommendTroopItem.labelList.isEmpty()))
    {
      int m = 0;
      int n = Math.min(3, paramRecentRecommendTroopItem.labelList.size());
      Iterator localIterator = paramRecentRecommendTroopItem.labelList.iterator();
      while (localIterator.hasNext())
      {
        oidb_0x9fb.Label localLabel = (oidb_0x9fb.Label)localIterator.next();
        Object localObject2 = localLabel.bytes_name.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          Object localObject1 = localObject2;
          if (localLabel.enum_type.get() == 1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131706539));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramRecentRecommendTroopItem.labelStr);
          ((StringBuilder)localObject2).append((String)localObject1);
          paramRecentRecommendTroopItem.labelStr = ((StringBuilder)localObject2).toString();
          m += 1;
          if (m == n) {
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramRecentRecommendTroopItem.labelStr);
          ((StringBuilder)localObject1).append("|");
          paramRecentRecommendTroopItem.labelStr = ((StringBuilder)localObject1).toString();
        }
      }
    }
  }
  
  private <T extends MayKnowRecommend> ArrayList<T> b(@NonNull ArrayList<T> paramArrayList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c(List<oidb_0xc26.TabInfo> paramList)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("saveConnectionsTabInfoList ");
      if (paramList == null) {
        ??? = "null";
      } else {
        ??? = Integer.valueOf(paramList.size());
      }
      ((StringBuilder)localObject2).append(???);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramList != null) {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = a((oidb_0xc26.TabInfo)paramList.next());
          if (((ConnectionsTabInfo)localObject2).jdField_a_of_type_Int == 23) {
            ((ConnectionsTabInfo)localObject2).jdField_b_of_type_Int += c().size();
          }
          this.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
        }
        d(this.jdField_c_of_type_JavaUtilArrayList);
        return;
      }
    }
  }
  
  private void d(List<ConnectionsTabInfo> paramList)
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mayknow_connections_sp_");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
      if (paramList == null)
      {
        ((SharedPreferences)localObject2).edit().remove("sp_mayknow_connections_tabinfo_list_json").commit();
      }
      else
      {
        localObject3 = new JSONArray();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          ((JSONArray)localObject3).put(ConnectionsTabInfo.a((ConnectionsTabInfo)paramList.next()));
        }
        ((SharedPreferences)localObject2).edit().putString("sp_mayknow_connections_tabinfo_list_json", ((JSONArray)localObject3).toString()).commit();
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void e(int paramInt)
  {
    synchronized (this.jdField_f_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
        return;
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      if ((??? != null) && (((EntityManager)???).isOpen()))
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("");
        localObject2 = (ArrayList)((EntityManager)???).query(MayKnowRecommend.class, false, "tabID=?", new String[] { ((StringBuilder)localObject2).toString() }, null, null, null, null);
        synchronized (this.jdField_f_of_type_JavaLangObject)
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (localObject2 != null)) {
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject2);
          }
          return;
        }
      }
      return;
    }
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.contains(Integer.valueOf(paramInt))) {
      return;
    }
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mayknow_connections_sp_");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sp_mayknow_connections_tabinfo_cookie_");
      ((StringBuilder)localObject3).append(paramInt);
      String str = ((StringBuilder)localObject3).toString();
      localObject3 = null;
      str = ((SharedPreferences)localObject1).getString(str, null);
      localObject1 = localObject3;
      if (str != null) {
        try
        {
          localObject1 = Base64.decode(str, 2);
        }
        catch (Throwable localThrowable)
        {
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("loadTabCookieFromSP ");
            ((StringBuilder)localObject1).append(localThrowable.toString());
            QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject3;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("loadTabCookieFromSP ");
        ((StringBuilder)localObject3).append(paramInt);
        ((StringBuilder)localObject3).append(" ");
        boolean bool;
        if (localObject1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject3).append(bool);
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject3).toString());
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new byte[0];
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject3);
      return;
    }
  }
  
  private boolean f()
  {
    return ((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).c() ^ true;
  }
  
  private void g(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("deleteRecentUserByType ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject2 = ((RecentUserProxy)localObject1).a(false);
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if (localRecentUser.getType() == paramInt) {
          ((RecentUserProxy)localObject1).a(localRecentUser);
        }
      }
    }
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: new 295	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: ldc_w 740
    //   20: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: aload_0
    //   27: getfield 85	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_Int	I
    //   30: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: ldc_w 304
    //   37: iconst_2
    //   38: aload 5
    //   40: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: invokestatic 743	com/tencent/mobileqq/app/LocaleManager:c	()Z
    //   49: istore 4
    //   51: iconst_0
    //   52: istore_2
    //   53: iconst_0
    //   54: istore_3
    //   55: iload 4
    //   57: ifeq +118 -> 175
    //   60: aload_0
    //   61: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   64: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore 5
    //   69: aload 5
    //   71: invokevirtual 415	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   74: aload_0
    //   75: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   78: ldc_w 745
    //   81: invokevirtual 423	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   84: pop
    //   85: aload_0
    //   86: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   89: ldc_w 747
    //   92: invokevirtual 423	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   95: pop
    //   96: aload 5
    //   98: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   101: iconst_1
    //   102: istore_2
    //   103: goto +32 -> 135
    //   106: astore 6
    //   108: goto +59 -> 167
    //   111: astore 6
    //   113: iload_3
    //   114: istore_2
    //   115: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +17 -> 135
    //   121: ldc_w 304
    //   124: iconst_2
    //   125: ldc_w 749
    //   128: aload 6
    //   130: invokestatic 450	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   133: iload_3
    //   134: istore_2
    //   135: aload 5
    //   137: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   140: aload_0
    //   141: getfield 178	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   144: invokeinterface 489 1 0
    //   149: ldc_w 751
    //   152: lconst_0
    //   153: invokeinterface 755 4 0
    //   158: invokeinterface 499 1 0
    //   163: pop
    //   164: goto +11 -> 175
    //   167: aload 5
    //   169: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   172: aload 6
    //   174: athrow
    //   175: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +57 -> 235
    //   181: new 295	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   188: astore 5
    //   190: aload 5
    //   192: ldc_w 757
    //   195: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: iload 4
    //   203: invokevirtual 507	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 5
    //   209: ldc_w 759
    //   212: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 5
    //   218: iload_2
    //   219: invokevirtual 507	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc_w 304
    //   226: iconst_2
    //   227: aload 5
    //   229: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_0
    //   236: invokespecial 762	com/tencent/mobileqq/app/MayknowRecommendManager:l	()V
    //   239: aload_0
    //   240: getfield 85	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_Int	I
    //   243: istore_1
    //   244: iload_1
    //   245: iconst_m1
    //   246: if_icmpne +4 -> 250
    //   249: return
    //   250: iload_1
    //   251: iconst_2
    //   252: if_icmpne +8 -> 260
    //   255: aload_0
    //   256: invokespecial 765	com/tencent/mobileqq/app/MayknowRecommendManager:n	()V
    //   259: return
    //   260: aload_0
    //   261: invokespecial 768	com/tencent/mobileqq/app/MayknowRecommendManager:m	()V
    //   264: aload_0
    //   265: invokespecial 771	com/tencent/mobileqq/app/MayknowRecommendManager:o	()V
    //   268: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	MayknowRecommendManager
    //   243	10	1	m	int
    //   52	167	2	bool1	boolean
    //   54	80	3	bool2	boolean
    //   49	153	4	bool3	boolean
    //   13	215	5	localObject1	Object
    //   106	1	6	localObject2	Object
    //   111	62	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   69	101	106	finally
    //   115	133	106	finally
    //   69	101	111	java/lang/Exception
  }
  
  private void l()
  {
    jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_report_interval", 86400000L);
    jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_showcount", 37);
    jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_expectcount", 70);
    jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_newfriendcount", 3);
    int m = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_conversation_tab_show_type", -1);
    this.jdField_b_of_type_Boolean = b("sp_mayknow_ml_s_a_vl");
    this.jdField_c_of_type_Boolean = b("sp_mayknow_addpage_s_a_vl");
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_contacts_tab_recommend_troop_hide_time", 0L);
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_contacts_tab_recommend_troop_count", 2);
    RecommendTroopConfigProcessor.RecommendTroopConfigBean localRecommendTroopConfigBean = RecommendTroopConfigProcessor.a();
    boolean bool2 = false;
    boolean bool1;
    if (localRecommendTroopConfigBean != null)
    {
      this.jdField_g_of_type_Int = localRecommendTroopConfigBean.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = localRecommendTroopConfigBean.jdField_a_of_type_JavaLangString;
      if (localRecommendTroopConfigBean.jdField_b_of_type_Int == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_d_of_type_Boolean = bool1;
    }
    if (this.jdField_b_of_type_Int != m)
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(120, true, new Object[] { Integer.valueOf(m) });
      this.jdField_b_of_type_Int = m;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initParams ,conversationTabDisplayAsVerticalListItem = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(",addPageDisplayAsVerticalListItem = ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",conversationTabShowType=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(",mContactsTabRecommendTroopHideTime=");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append(",mContactsTabRecommendTroopPollInterval=");
      localStringBuilder.append(this.jdField_g_of_type_Int);
      localStringBuilder.append(",contactsTabRecommendTroopJumpUrl=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",showRecommendTroopWhenSearchEmpty=");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append(",mContactsTabShowRecommendTroopCount=");
      localStringBuilder.append(this.jdField_e_of_type_Int);
      localStringBuilder.append(", config is null: ");
      bool1 = bool2;
      if (localRecommendTroopConfigBean == null) {
        bool1 = true;
      }
      localStringBuilder.append(bool1);
      QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
  }
  
  private void m()
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MayKnowExposure.class, false, null, null, null, null, null, null);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Iterator)localObject2).next();
          localMayKnowExposure = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(MayKnowExposure.generateKey(localMayKnowExposure), localMayKnowExposure);
        }
      }
      this.h = true;
      long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_report_explosure_time", 0L);
      if (Math.abs(System.currentTimeMillis() - l) > jdField_a_of_type_Long)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a() == 1)
        {
          r();
          return;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 5000L);
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void n()
  {
    Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(RecentRecommendTroopItem.class);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initRecommendTroop in db, troopItems = ");
      int m;
      if (localObject1 == null) {
        m = 0;
      } else {
        m = ((ArrayList)localObject1).size();
      }
      ((StringBuilder)localObject3).append(m);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject3).toString());
    }
    ArrayList localArrayList = a((ArrayList)localObject1);
    Object localObject3 = this.jdField_a_of_type_JavaUtilList;
    if (localArrayList != null) {}
    try
    {
      if ((!localArrayList.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("filtered troop:");
        if (localArrayList == null) {
          localObject1 = "null";
        } else {
          localObject1 = localArrayList.toString();
        }
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject3).toString());
      }
      c();
      localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putBoolean("is_from_init", true);
      ((FriendListHandler)localObject1).notifyUI(90, true, localObject3);
      return;
    }
    finally {}
  }
  
  private void o()
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MayKnowRecommend.class, false, "tabID=? or tabID is null", new String[] { "23" }, null, null, null, null);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("initMayKnowGet in db, cpMkrs = ");
      if (localArrayList == null) {
        localObject1 = "NULL";
      } else {
        localObject1 = localArrayList.toString();
      }
      ((StringBuilder)???).append((String)localObject1);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
    }
    Object localObject1 = b(localArrayList);
    if (localObject1 != null)
    {
      ??? = this.jdField_a_of_type_JavaUtilArrayList;
      if ((??? == null) || (((ArrayList)???).size() <= 0)) {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "initMayKnowGet, mRecommends alread has data");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initMayKnowGet size:");
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList;
      ??? = null;
      if (localObject3 != null) {
        localObject3 = Integer.valueOf(((ArrayList)localObject3).size());
      } else {
        localObject3 = null;
      }
      localStringBuilder.append(localObject3);
      localStringBuilder.append(" cpMkrs:");
      localObject3 = ???;
      if (localArrayList != null) {
        localObject3 = Integer.valueOf(localArrayList.size());
      }
      localStringBuilder.append(localObject3);
      QLog.i("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    d();
    Object localObject3 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    ??? = new Bundle();
    ((Bundle)???).putBoolean("is_from_init", true);
    ((FriendListHandler)localObject3).notifyUI(90, true, ???);
  }
  
  private void p()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        synchronized (this.jdField_e_of_type_JavaLangObject)
        {
          Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          Object localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("mayknow_connections_sp_");
          ((StringBuilder)localObject6).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localObject6 = ((StringBuilder)localObject6).toString();
          int m = 0;
          localObject4 = ((BaseApplication)localObject4).getSharedPreferences((String)localObject6, 0).getString("sp_mayknow_connections_tabinfo_list_json", "");
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("loadConnectionsTabInfoList ");
            ((StringBuilder)localObject6).append((String)localObject4);
            QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject6).toString());
          }
          boolean bool = ((String)localObject4).isEmpty();
          if (!bool) {
            try
            {
              localObject4 = new JSONArray((String)localObject4);
              localObject6 = new ArrayList(5);
              while (m < ((JSONArray)localObject4).length())
              {
                ((ArrayList)localObject6).add(ConnectionsTabInfo.a(((JSONArray)localObject4).getJSONObject(m)));
                m += 1;
              }
              this.jdField_c_of_type_JavaUtilArrayList = ((ArrayList)localObject6);
            }
            catch (JSONException localJSONException)
            {
              if (QLog.isColorLevel())
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("loadConnectionsTabInfoList ");
                ((StringBuilder)localObject6).append(localJSONException.toString());
                QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject6).toString());
              }
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void q()
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mayknow_connections_sp_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().clear().commit();
      return;
    }
  }
  
  private void r()
  {
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("reportExplosure size=");
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      ((StringBuilder)???).append(" isExplosuresInited=");
      ((StringBuilder)???).append(this.h);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) && (this.h)) {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        this.jdField_g_of_type_Boolean = true;
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reportMayknowRecommendExplosure(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        if (QLog.isColorLevel())
        {
          ??? = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          if (((Iterator)???).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("reportExplosure, Key = ");
            localStringBuilder.append((String)localEntry.getKey());
            localStringBuilder.append(", Value.exposeCnt = ");
            localStringBuilder.append(((MayKnowExposure)localEntry.getValue()).exposeCnt);
            localStringBuilder.append(", Value.exposeTime = ");
            localStringBuilder.append(((MayKnowExposure)localEntry.getValue()).exposeTime);
            QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public int a()
  {
    p();
    boolean bool = ((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).c();
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_c_of_type_JavaUtilArrayList;
      int n = 0;
      int m = 0;
      if (localObject2 != null)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          n = m;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          ConnectionsTabInfo localConnectionsTabInfo = (ConnectionsTabInfo)((Iterator)localObject2).next();
          if ((localConnectionsTabInfo.jdField_a_of_type_Int == 23) || ((bool ^ true))) {
            m += localConnectionsTabInfo.jdField_b_of_type_Int;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("getConnectionsPersonAllNum ");
        ((StringBuilder)???).append(n);
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
      }
      return n;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public int a(int paramInt)
  {
    ArrayList localArrayList = a(paramInt);
    paramInt = 1;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int m = ((MayKnowRecommend)localArrayList.get(0)).timestamp;
      int i1 = localArrayList.size();
      while (paramInt < i1)
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localArrayList.get(paramInt);
        int n = m;
        if (localMayKnowRecommend.timestamp < m) {
          n = localMayKnowRecommend.timestamp;
        }
        paramInt += 1;
        m = n;
      }
      return m;
    }
    return 1;
  }
  
  public long a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      return 9223372036854775807L;
    case 6: 
      return 0L;
    case 5: 
      str = "pull_interval_add_page";
      break;
    case 4: 
      str = "pull_interval_new_friend";
      break;
    case 3: 
      str = "pull_interval_recommend_tab";
      break;
    case 2: 
      str = "pull_interval_contact_head";
      break;
    case 1: 
      str = "pull_interval_conversation_tab";
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 43200000L);
  }
  
  public ArrayList<ConnectionsTabInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    p();
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList != null)
      {
        boolean bool = f();
        Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ConnectionsTabInfo localConnectionsTabInfo = ConnectionsTabInfo.a((ConnectionsTabInfo)localIterator.next());
          if (localConnectionsTabInfo.jdField_a_of_type_Int == 23) {
            localConnectionsTabInfo.jdField_a_of_type_Boolean = true;
          } else {
            localConnectionsTabInfo.jdField_a_of_type_Boolean = bool;
          }
          localArrayList.add(localConnectionsTabInfo);
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("getConnectionsTabInfoList ");
        ((StringBuilder)???).append(localArrayList.toString());
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public ArrayList<MayKnowRecommend> a(int paramInt)
  {
    ArrayList localArrayList;
    if (paramInt == 23) {
      localArrayList = c();
    } else {
      e(paramInt);
    }
    for (;;)
    {
      synchronized (this.jdField_f_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap != null)
        {
          localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
          if (localArrayList != null)
          {
            localArrayList = new ArrayList(localArrayList);
            f(paramInt);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getConnectionsPersonLocal ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(" ");
              if (localArrayList == null)
              {
                ??? = "null";
              }
              else
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append(localArrayList.size());
                ((StringBuilder)???).append("");
                ??? = ((StringBuilder)???).toString();
              }
              localStringBuilder.append((String)???);
              QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
            }
            return localArrayList;
          }
        }
      }
      Object localObject2 = null;
    }
  }
  
  public List<RecentRecommendTroopItem> a(int paramInt)
  {
    if (!b("sp_mayknow_entry_list_head"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop switch not open.");
      }
      return null;
    }
    long l = NetConnInfoCenter.getServerTime();
    if (l - this.jdField_c_of_type_Long < 86400L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop hide time in 24h. return null.");
      }
      return null;
    }
    if (this.jdField_e_of_type_Int == 0)
    {
      this.jdField_e_of_type_Int = 2;
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject1).putInt("sp_contacts_tab_recommend_troop_count", this.jdField_e_of_type_Int);
      ((SharedPreferences.Editor)localObject1).commit();
    }
    Object localObject1 = new ArrayList();
    int n = this.jdField_g_of_type_Int;
    int m = n;
    if (n < 1) {
      m = 1;
    }
    if ((l - this.jdField_b_of_type_Long < m * 60) && (paramInt > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop in poll interval. return empty.");
      }
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      m = this.jdField_a_of_type_JavaUtilList.size();
      if (m == 0) {
        return null;
      }
      n = this.jdField_f_of_type_Int;
      paramInt = 0;
      if (n < 0) {
        this.jdField_f_of_type_Int = 0;
      }
      this.jdField_f_of_type_Int %= m;
      n = Math.min(this.jdField_e_of_type_Int, m);
      while ((this.jdField_f_of_type_Int < m) && (paramInt < n))
      {
        ((List)localObject1).add(this.jdField_a_of_type_JavaUtilList.get(this.jdField_f_of_type_Int));
        int i1 = this.jdField_f_of_type_Int + 1;
        this.jdField_f_of_type_Int = i1;
        this.jdField_f_of_type_Int = (i1 % m);
        paramInt += 1;
      }
      if (((List)localObject1).size() > 0) {
        this.jdField_b_of_type_Long = l;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("getContactsTabNeedShowTroop return troop list: ");
        ((StringBuilder)???).append(localObject1.toString());
        QLog.i("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
      }
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a()
  {
    Object localObject = RecommendTroopConfigProcessor.a();
    if (localObject != null)
    {
      this.jdField_g_of_type_Int = ((RecommendTroopConfigProcessor.RecommendTroopConfigBean)localObject).jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = ((RecommendTroopConfigProcessor.RecommendTroopConfigBean)localObject).jdField_a_of_type_JavaLangString;
      int m = ((RecommendTroopConfigProcessor.RecommendTroopConfigBean)localObject).jdField_b_of_type_Int;
      boolean bool = true;
      if (m != 1) {
        bool = false;
      }
      this.jdField_d_of_type_Boolean = bool;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRecommendTroopConfig, mContactsTabRecommendTroopPollInterval=");
        ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
        ((StringBuilder)localObject).append(",contactsTabRecommendTroopJumpUrl=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(",showRecommendTroopWhenSearchEmpty=");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearConnectionsPageNetworkState ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConnectionsPersonRemote entryType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" tabID=");
      localStringBuilder.append(paramInt2);
      QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    paramBundle = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3, paramInt1, paramInt2, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramBundle);
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        int m = Integer.valueOf(paramString.optString("reportInterval").trim()).intValue();
        if ((m <= 86400000) && (m > 0)) {
          jdField_a_of_type_Long = m;
        }
        m = Integer.valueOf(paramString.optString("showCount").trim()).intValue();
        if ((m > 0) && (m <= 100)) {
          jdField_a_of_type_Int = m;
        }
        m = Integer.valueOf(paramString.optString("totalCount").trim()).intValue();
        if ((m <= 100) && (m > 0)) {
          jdField_c_of_type_Int = m;
        }
        m = Integer.valueOf(paramString.optString("newfriendCount")).intValue();
        if (m > 0) {
          jdField_d_of_type_Int = m;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_report_interval", jdField_a_of_type_Long).commit();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_showcount", jdField_a_of_type_Int).commit();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_expectcount", jdField_c_of_type_Int).commit();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_newfriendcount", jdField_d_of_type_Int).commit();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_version", paramInt).commit();
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateConfigs error ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("MayknowRecommendManager", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("timeInterval = ");
      paramString.append(jdField_a_of_type_Long);
      paramString.append(",showCount=");
      paramString.append(jdField_a_of_type_Int);
      paramString.append(",expectCount=");
      paramString.append(jdField_c_of_type_Int);
      paramString.append(",newfriendCount=");
      paramString.append(jdField_d_of_type_Int);
      QLog.d("MayknowRecommendManager", 2, paramString.toString());
    }
  }
  
  public void a(int paramInt, ArrayList<MayKnowRecommend> paramArrayList, List<oidb_0xc26.TabInfo> paramList, byte[] paramArrayOfByte, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onGetConnectionsPersonData ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(" ");
      ((StringBuilder)???).append(paramBoolean);
      ((StringBuilder)???).append(" ");
      if (paramArrayList == null) {
        localObject1 = "";
      } else {
        localObject1 = Integer.valueOf(paramArrayList.size());
      }
      ((StringBuilder)???).append(localObject1);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
    }
    a(paramInt, paramArrayList, paramBoolean);
    p();
    if (paramList != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onGetConnectionsPersonData ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(paramList.size());
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
      }
      paramList = paramList.iterator();
      do
      {
        paramBoolean = paramList.hasNext();
        localObject1 = null;
        if (!paramBoolean) {
          break;
        }
        ??? = (oidb_0xc26.TabInfo)paramList.next();
      } while (((oidb_0xc26.TabInfo)???).uint32_tab_id.get() != paramInt);
      paramList = a((oidb_0xc26.TabInfo)???);
      ??? = a(paramInt);
      int m;
      if (??? != null) {
        m = ((ArrayList)???).size();
      } else {
        m = 0;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onGetConnectionsPersonData update count ");
        ((StringBuilder)???).append(m);
        ((StringBuilder)???).append(" ");
        ((StringBuilder)???).append(paramList.jdField_b_of_type_Int);
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
      }
      paramList.jdField_b_of_type_Int += m;
      break label334;
      paramList = null;
      label334:
      if (paramList != null)
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onGetConnectionsPersonData update tabInfo");
          ((StringBuilder)???).append(paramList.toString());
          QLog.d("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
        }
        synchronized (this.jdField_d_of_type_JavaLangObject)
        {
          if (this.jdField_c_of_type_JavaUtilArrayList != null)
          {
            Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              ConnectionsTabInfo localConnectionsTabInfo = (ConnectionsTabInfo)localIterator.next();
              if ((localConnectionsTabInfo.equals(paramList)) && ((localConnectionsTabInfo.jdField_b_of_type_Int != paramList.jdField_b_of_type_Int) || (!localConnectionsTabInfo.jdField_a_of_type_JavaLangString.equals(paramList.jdField_a_of_type_JavaLangString)) || (!localConnectionsTabInfo.jdField_b_of_type_JavaLangString.equals(paramList.jdField_b_of_type_JavaLangString)) || (!localConnectionsTabInfo.c.equals(paramList.c))))
              {
                localConnectionsTabInfo.jdField_b_of_type_Int = paramList.jdField_b_of_type_Int;
                localConnectionsTabInfo.jdField_a_of_type_JavaLangString = paramList.jdField_a_of_type_JavaLangString;
                localConnectionsTabInfo.jdField_b_of_type_JavaLangString = paramList.jdField_b_of_type_JavaLangString;
                localConnectionsTabInfo.c = paramList.c;
                d(this.jdField_c_of_type_JavaUtilArrayList);
              }
            }
          }
          paramList = new ArrayList();
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            paramArrayList = paramArrayList.iterator();
            while (paramArrayList.hasNext())
            {
              ??? = (MayKnowRecommend)paramArrayList.next();
              if (??? != null) {
                paramList.add(((MayKnowRecommend)???).uin);
              }
            }
          }
          if (paramBundle == null) {
            paramArrayList = (ArrayList<MayKnowRecommend>)localObject1;
          } else {
            paramArrayList = paramBundle.getString("from", "3");
          }
          m = 3;
          if (paramBundle != null) {
            m = paramBundle.getInt("update_type", 3);
          }
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, paramList, String.valueOf(paramInt), paramArrayList);
        }
      }
    }
    a(paramInt, paramArrayOfByte);
  }
  
  public void a(View paramView, Context paramContext, String paramString)
  {
    int m = paramView.getId();
    if ((paramString.equals("sp_uin_for_title")) && (m == 2131376248))
    {
      paramView = ActionSheet.create(paramContext);
      paramView.addButton(2131691258);
      paramView.addCancelButton(2131690728);
      paramView.setOnButtonClickListener(new MayknowRecommendManager.8(this, paramView));
      paramView.show();
      ReportController.b(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_ellipsis", 0, 0, "", "", "", "");
      return;
    }
    Object localObject;
    if (paramView.getTag() != null)
    {
      if (!(paramView.getTag() instanceof RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder)) {
        return;
      }
      localObject = (RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder)paramView.getTag();
      if (((RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder)localObject).a == null) {
        return;
      }
      paramString = null;
      paramView = paramString;
      if (((RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder)localObject).a.mUser != null)
      {
        paramView = paramString;
        if ((((RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder)localObject).a.mUser.extraInfo instanceof RecentRecommendTroopItem)) {
          paramView = (RecentRecommendTroopItem)((RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder)localObject).a.mUser.extraInfo;
        }
      }
      if (paramView == null) {
        return;
      }
      if (m == 2131363961)
      {
        paramString = new StringBuilder();
        paramString.append("mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=");
        paramString.append(paramView.uin);
        paramString.append("&subsource_id=10017");
        paramString = paramString.toString();
        localObject = new Intent(paramContext, JoinGroupTransitActivity.class);
        ((Intent)localObject).putExtra("source_scheme", paramString);
        paramContext.startActivity((Intent)localObject);
        ReportController.b(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_add", 0, 0, paramView.uin, paramView.recomAlgol, "", "");
        return;
      }
      paramString = new GroupInfo();
    }
    try
    {
      paramString.lCode = Long.valueOf(paramView.uin).longValue();
      paramString.strName = paramView.name;
      if (TextUtils.isEmpty(paramView.recommendReason)) {
        paramString.strIntro = paramView.intro;
      } else {
        paramString.strIntro = paramView.recommendReason;
      }
      paramString.iMemberCnt = paramView.memberNum;
      localObject = GroupViewAdapter.a(paramView);
      if (localObject != null) {
        paramString.labels = ((ArrayList)localObject);
      }
      paramString.strJoinSig = paramView.authSig;
      TroopUtils.a(paramContext, TroopUtils.a(107, paramString, 10018, false), 2);
      ReportController.b(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_grp", 0, 0, paramView.uin, paramView.recomAlgol, "", "");
      return;
    }
    catch (Exception paramView)
    {
      label427:
      break label427;
    }
    QLog.d("MayknowRecommendManager", 1, "cast string2long error");
  }
  
  public void a(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if ((this.h) && (!this.jdField_g_of_type_Boolean))
      {
        ??? = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(???))
        {
          paramMayKnowRecommend = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(???);
        }
        else
        {
          paramMayKnowRecommend = new MayKnowExposure(paramMayKnowRecommend.uin, paramInt1, paramInt2, paramInt3, paramMayKnowRecommend.algBuffer, paramMayKnowRecommend.additive);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(???, paramMayKnowRecommend);
        }
        if (paramInt3 != 1) {
          paramMayKnowRecommend.exposeCnt += 1;
        }
        if (paramMayKnowRecommend.startExploseTime != 0L) {
          return;
        }
        if (paramInt3 == 1) {
          paramMayKnowRecommend.startExploseTime = SystemClock.uptimeMillis();
        }
        return;
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      int n = 0;
      try
      {
        Object localObject3 = new JSONObject(paramString);
        int m;
        if (((JSONObject)localObject3).has("shield_sub_source_id"))
        {
          localObject3 = ((JSONObject)localObject3).getJSONArray("shield_sub_source_id");
          m = 0;
          while ((localObject3 != null) && (m < ((JSONArray)localObject3).length()))
          {
            int i1 = ((JSONArray)localObject3).getInt(m);
            this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i1));
            m += 1;
          }
        }
        paramString = finally;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("MayknowRecommendManager", 2, "updateShieldConfig", localException);
        }
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder(100);
          ((StringBuilder)???).append("updateShieldConfig config: ");
          ((StringBuilder)???).append(paramString);
          ((StringBuilder)???).append("\r\n");
          ((StringBuilder)???).append("[");
          paramString = this.jdField_b_of_type_JavaUtilArrayList;
          m = n;
          try
          {
            while (m < this.jdField_b_of_type_JavaUtilArrayList.size())
            {
              ((StringBuilder)???).append(this.jdField_b_of_type_JavaUtilArrayList.get(m));
              ((StringBuilder)???).append(",");
              m += 1;
            }
            ((StringBuilder)???).append("]");
            QLog.i("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
            return;
          }
          finally {}
        }
        return;
      }
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("removeMayKnowRecommend, uin=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayList localArrayList = null;
    int m;
    label473:
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        localObject1 = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (MayKnowRecommend)localIterator.next();
      } while (!((MayKnowRecommend)localObject1).uin.equals(paramString));
      localIterator.remove();
      if ((paramBoolean) && (localObject1 != null)) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject1);
      }
      p();
      if (this.jdField_a_of_type_JavaUtilHashMap != null)
      {
        localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
        if (localArrayList != null) {
          try
          {
            if (this.jdField_c_of_type_JavaUtilArrayList != null)
            {
              localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
              while (localIterator.hasNext())
              {
                ConnectionsTabInfo localConnectionsTabInfo = (ConnectionsTabInfo)localIterator.next();
                synchronized (this.jdField_f_of_type_JavaLangObject)
                {
                  if (localConnectionsTabInfo.jdField_a_of_type_Int == 23)
                  {
                    if (localObject1 != null)
                    {
                      if (localConnectionsTabInfo.jdField_b_of_type_Int <= 0) {
                        break label473;
                      }
                      m = localConnectionsTabInfo.jdField_b_of_type_Int - 1;
                      localConnectionsTabInfo.jdField_b_of_type_Int = m;
                    }
                  }
                  else
                  {
                    Object localObject3 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localConnectionsTabInfo.jdField_a_of_type_Int));
                    if (localObject3 != null)
                    {
                      localObject3 = ((ArrayList)localObject3).iterator();
                      while (((Iterator)localObject3).hasNext()) {
                        if (((MayKnowRecommend)((Iterator)localObject3).next()).uin.equals(paramString))
                        {
                          ((Iterator)localObject3).remove();
                          localConnectionsTabInfo.jdField_b_of_type_Int -= 1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          finally {}
        }
      }
      d(this.jdField_c_of_type_JavaUtilArrayList);
      if (paramBoolean) {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("delete from MayKnowRecommend where uin=");
            ((StringBuilder)localObject1).append(paramString);
            paramString = ((StringBuilder)localObject1).toString();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL(paramString);
            return;
          }
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("removeConnectionPerson, ");
            ((StringBuilder)localObject1).append(paramString.toString());
            QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      return;
    }
  }
  
  /* Error */
  public void a(@NonNull ArrayList<MayKnowRecommend> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +284 -> 285
    //   4: aload_1
    //   5: invokevirtual 361	java/util/ArrayList:isEmpty	()Z
    //   8: ifeq +6 -> 14
    //   11: goto +274 -> 285
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 387	com/tencent/mobileqq/app/MayknowRecommendManager:b	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload 4
    //   26: invokeinterface 223 1 0
    //   31: sipush 1000
    //   34: if_icmple +15 -> 49
    //   37: aload 4
    //   39: iconst_0
    //   40: sipush 1000
    //   43: invokeinterface 1343 3 0
    //   48: astore_3
    //   49: getstatic 50	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   52: astore 4
    //   54: aload 4
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   61: invokevirtual 1298	java/util/ArrayList:clear	()V
    //   64: aload_0
    //   65: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: aload_3
    //   69: invokevirtual 391	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   72: pop
    //   73: aload 4
    //   75: monitorexit
    //   76: aload_0
    //   77: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   80: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   83: astore 4
    //   85: aload 4
    //   87: invokevirtual 415	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   90: aload_0
    //   91: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   94: ldc_w 745
    //   97: invokevirtual 423	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   100: pop
    //   101: aload_3
    //   102: invokeinterface 223 1 0
    //   107: ifle +36 -> 143
    //   110: aload_3
    //   111: invokeinterface 591 1 0
    //   116: astore_3
    //   117: aload_3
    //   118: invokeinterface 432 1 0
    //   123: ifeq +20 -> 143
    //   126: aload_0
    //   127: aload_3
    //   128: invokeinterface 436 1 0
    //   133: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   136: invokevirtual 1345	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   139: pop
    //   140: goto -23 -> 117
    //   143: aload 4
    //   145: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   148: aload 4
    //   150: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   153: iconst_1
    //   154: istore_2
    //   155: goto +32 -> 187
    //   158: astore_1
    //   159: goto +113 -> 272
    //   162: astore_3
    //   163: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +14 -> 180
    //   169: ldc_w 304
    //   172: iconst_2
    //   173: ldc_w 1347
    //   176: aload_3
    //   177: invokestatic 450	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   180: aload 4
    //   182: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   185: iconst_0
    //   186: istore_2
    //   187: aload_0
    //   188: getfield 119	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_f_of_type_JavaLangObject	Ljava/lang/Object;
    //   191: astore_3
    //   192: aload_3
    //   193: monitorenter
    //   194: aload_0
    //   195: getfield 106	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   198: ifnull +10 -> 208
    //   201: aload_0
    //   202: getfield 106	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   205: invokevirtual 1348	java/util/HashMap:clear	()V
    //   208: aload_3
    //   209: monitorexit
    //   210: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +53 -> 266
    //   216: ldc_w 304
    //   219: iconst_2
    //   220: invokestatic 1354	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   223: ldc_w 1356
    //   226: iconst_3
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_1
    //   233: invokevirtual 373	java/util/ArrayList:size	()I
    //   236: invokestatic 397	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_0
    //   243: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   246: invokevirtual 373	java/util/ArrayList:size	()I
    //   249: invokestatic 397	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aastore
    //   253: dup
    //   254: iconst_2
    //   255: iload_2
    //   256: invokestatic 1361	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   259: aastore
    //   260: invokestatic 1365	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   263: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: return
    //   267: astore_1
    //   268: aload_3
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    //   272: aload 4
    //   274: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   277: aload_1
    //   278: athrow
    //   279: astore_1
    //   280: aload 4
    //   282: monitorexit
    //   283: aload_1
    //   284: athrow
    //   285: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +23 -> 311
    //   291: ldc_w 304
    //   294: iconst_2
    //   295: invokestatic 1354	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   298: ldc_w 1367
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 1365	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokestatic 310	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	MayknowRecommendManager
    //   0	312	1	paramArrayList	ArrayList<MayKnowRecommend>
    //   154	102	2	bool	boolean
    //   23	105	3	localObject1	Object
    //   162	15	3	localException	Exception
    //   191	78	3	localObject2	Object
    //   19	262	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   85	117	158	finally
    //   117	140	158	finally
    //   143	148	158	finally
    //   163	180	158	finally
    //   85	117	162	java/lang/Exception
    //   117	140	162	java/lang/Exception
    //   143	148	162	java/lang/Exception
    //   194	208	267	finally
    //   208	210	267	finally
    //   268	270	267	finally
    //   57	76	279	finally
    //   280	283	279	finally
  }
  
  public void a(List<Integer> paramList)
  {
    boolean bool1 = paramList.contains(Integer.valueOf(1));
    boolean bool2 = paramList.contains(Integer.valueOf(2));
    boolean bool3 = paramList.contains(Integer.valueOf(3));
    boolean bool4 = paramList.contains(Integer.valueOf(4));
    boolean bool5 = paramList.contains(Integer.valueOf(5));
    paramList = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramList.putBoolean("sp_mayknow_entry_list_msg", bool1);
    paramList.putBoolean("sp_mayknow_entry_list_head", bool2);
    paramList.putBoolean("sp_mayknow_entry_list_recommend", bool3);
    paramList.putBoolean("sp_mayknow_entry_list_new", bool4);
    paramList.putBoolean("sp_mayknow_entry_list_add", bool5);
    paramList.commit();
    paramList = new StringBuilder();
    paramList.append("saveEntryOpenList,MsgEntryOpen=");
    paramList.append(bool1);
    paramList.append(",HeadEntryOpen=");
    paramList.append(bool2);
    paramList.append(", RecommendEntryOpen=");
    paramList.append(bool3);
    paramList.append(", NewEntryOpen=");
    paramList.append(bool4);
    paramList.append(", EntryAdd=");
    paramList.append(bool5);
    QLog.i("MayknowRecommendManager", 1, paramList.toString());
  }
  
  public void a(List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject1 = new ArrayList();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
          if ((localMayKnowRecommend != null) && (paramList.contains(localMayKnowRecommend.uin))) {
            if (paramBoolean)
            {
              if (localMayKnowRecommend.cardDisplayTimestamp + paramLong2 < paramLong1)
              {
                localMayKnowRecommend.cardDisplayTimestamp = paramLong1;
                ((ArrayList)localObject1).add(localMayKnowRecommend);
              }
            }
            else
            {
              localMayKnowRecommend.cardDisplayTimestamp = paramLong1;
              ((ArrayList)localObject1).add(localMayKnowRecommend);
            }
          }
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        }
        try
        {
          try
          {
            paramList.begin();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ??? = (MayKnowRecommend)((Iterator)localObject1).next();
              if (??? != null) {
                a((Entity)???);
              }
            }
            paramList.commit();
          }
          finally
          {
            break label227;
          }
        }
        catch (Throwable localThrowable)
        {
          label212:
          break label212;
        }
        QLog.e("MayknowRecommendManager", 1, "update card timestamp to db error");
        paramList.end();
        return;
        label227:
        paramList.end();
        throw localObject2;
        return;
      }
    }
    else
    {
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("delete from MayKnowExposure");
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "onReportExplosures , success");
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_report_explosure_time", System.currentTimeMillis());
    }
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      this.jdField_g_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(boolean paramBoolean, ArrayList<MayKnowRecommend> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle, List<oidb_0xc26.TabInfo> paramList, byte[] arg9)
  {
    if (!paramBoolean)
    {
      QLog.i("MayknowRecommendManager", 1, "handleReqMayknownFriendList, isSuc is false");
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    a(paramArrayList);
    q();
    c(paramList);
    a(23, ???);
    int n = 0;
    int m;
    if (paramBundle != null)
    {
      paramList = new ArrayList();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
          if (localMayKnowRecommend != null) {
            paramList.add(localMayKnowRecommend.uin);
          }
        }
        if (!paramList.isEmpty())
        {
          paramBundle = paramBundle.getString("from", "");
          if ("fetch".equals(paramBundle)) {
            m = 3;
          } else if ("push".equals(paramBundle)) {
            m = 2;
          } else {
            m = 0;
          }
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, paramList);
        }
      }
    }
    boolean bool;
    if (paramInt2 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localEditor.putBoolean("sp_mayknow_entry_is_up", bool);
    if (paramInt3 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localEditor.putBoolean("sp_mayknow_ml_s_a_vl", bool);
    if (paramInt4 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localEditor.putBoolean("sp_mayknow_addpage_s_a_vl", bool);
    localEditor.commit();
    if (paramInt3 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    if (paramInt4 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    if (paramArrayList == null) {
      m = n;
    } else {
      m = paramArrayList.size();
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("handleReqMayknownFriendList, isSuc = ");
    paramArrayList.append(paramBoolean);
    paramArrayList.append(",dataSize=");
    paramArrayList.append(m);
    paramArrayList.append(",timestamp=");
    paramArrayList.append(paramInt1);
    paramArrayList.append(",isMsgUp=");
    paramArrayList.append(paramInt2);
    paramArrayList.append(",msgTabListSwitch=");
    paramArrayList.append(paramInt3);
    paramArrayList.append(",addPageListSwitch=");
    paramArrayList.append(paramInt4);
    QLog.i("MayknowRecommendManager", 1, paramArrayList.toString());
  }
  
  public void a(boolean paramBoolean, List<oidb_0xc26.RecommendInfo> arg2)
  {
    Object localObject1;
    int m;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleReqRecommendTroopList success: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" trooplist size: ");
      if (??? == null) {
        m = 0;
      } else {
        m = ???.size();
      }
      ((StringBuilder)localObject1).append(m);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramBoolean) && (??? != null))
    {
      if (???.isEmpty()) {
        return;
      }
      localObject1 = new ArrayList();
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      localEntityTransaction.begin();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("delete from RecentRecommendTroopItem");
      Iterator localIterator1 = ???.iterator();
      while (localIterator1.hasNext())
      {
        ??? = ((oidb_0xc26.RecommendInfo)localIterator1.next()).msg_groups.get();
        if ((??? != null) && (!???.isEmpty()))
        {
          Iterator localIterator2 = ???.iterator();
          while (localIterator2.hasNext())
          {
            oidb_0xc26.RgroupInfo localRgroupInfo = (oidb_0xc26.RgroupInfo)localIterator2.next();
            RecentRecommendTroopItem localRecentRecommendTroopItem = new RecentRecommendTroopItem();
            if (localRgroupInfo.uint64_group_code.has())
            {
              localRecentRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
              if (localRgroupInfo.bytes_group_name.has()) {
                localRecentRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
              }
              if (localRgroupInfo.bytes_group_memo.has()) {
                localRecentRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
              }
              localRecentRecommendTroopItem.labelList = RecommendTroopUtils.a(localRgroupInfo.rpt_group_label.get());
              localRecentRecommendTroopItem.labelStr = "";
              a(localRecentRecommendTroopItem);
              localRecentRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
              localRecentRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
              if (localRgroupInfo.bytes_algorithm.has()) {
                ??? = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
              } else {
                ??? = "";
              }
              localRecentRecommendTroopItem.recomAlgol = ???;
              if (localRgroupInfo.bytes_join_group_auth.has()) {
                ??? = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
              } else {
                ??? = "";
              }
              localRecentRecommendTroopItem.authSig = ???;
              if (localRgroupInfo.uint32_activity.has()) {
                m = localRgroupInfo.uint32_activity.get();
              } else {
                m = 0;
              }
              localRecentRecommendTroopItem.activity = m;
              if (localRgroupInfo.int32_uin_privilege.has()) {
                m = localRgroupInfo.int32_uin_privilege.get();
              } else {
                m = -1;
              }
              localRecentRecommendTroopItem.privilege = m;
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(localRecentRecommendTroopItem);
              ((List)localObject1).add(localRecentRecommendTroopItem);
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ???.append("saveNotificationRecommendTroop into db, recommend troop = ");
                ???.append(localRecentRecommendTroopItem);
                QLog.d("MayknowRecommendManager", 2, ???.toString());
              }
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          try
          {
            localEntityTransaction.commit();
            localEntityTransaction.end();
          }
          finally
          {
            continue;
          }
        }
        catch (Exception ???)
        {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MayknowRecommendManager", 2, "saveRecommendTroop commit error");
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
        this.jdField_f_of_type_Int = 0;
        this.jdField_b_of_type_Long = 0L;
        return;
      }
      localEntityTransaction.end();
      throw ???;
    }
  }
  
  public boolean a()
  {
    if (!this.k)
    {
      boolean bool2 = false;
      IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      boolean bool1 = bool2;
      if (localIPhoneContactService != null)
      {
        bool1 = bool2;
        if (localIPhoneContactService.getSelfBindState() >= 9) {
          bool1 = true;
        }
      }
      this.j = bool1;
      this.k = true;
    }
    return this.j;
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public boolean a(int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMayKnowRecommendRemote entryType = ");
      localStringBuilder.append(paramInt);
      QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    if (!b(paramInt))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMayKnowRecommendRemote, isTimeToObtainRemote is false, entryType = ");
      localStringBuilder.append(paramInt);
      QLog.i("MayknowRecommendManager", 1, String.format(localStringBuilder.toString(), new Object[0]));
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_mayknow_818_first_install", true))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_mayknow_818_first_install", false).commit();
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "getMayKnowRecommendRemote is818FirstInstall");
        }
      }
      else
      {
        return false;
      }
    }
    paramBundle = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5, paramInt, 0, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramBundle);
    return true;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity em closed e=");
      localStringBuilder.append(paramEntity.getTableName());
      QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgTabRecommendBItemRemove uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",conversationTabDisplayAsVerticalListItem = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      paramString = ((RecentUserProxy)localObject).b(paramString, 8112);
      bool1 = bool2;
      if (paramString != null)
      {
        ((RecentUserProxy)localObject).a(paramString);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(List<RecentBaseData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData");
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = b("sp_mayknow_entry_list_msg");
      boolean bool2 = b("sp_mayknow_entry_is_up");
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkAndReOrderRecentData showConversationMayKnow = ");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(",shouldRiseUp = ");
        ((StringBuilder)localObject1).append(bool2);
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
      }
      if ((bool1) && (bool2))
      {
        Object localObject2 = null;
        Iterator localIterator = paramList.iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (RecentBaseData)localIterator.next();
        } while (!(localObject1 instanceof RecentItemMayKnowFriendData));
        localObject1 = (RecentItemMayKnowFriendData)localObject1;
        localIterator.remove();
        if (localObject1 != null)
        {
          localObject2 = paramList.iterator();
          int m = 0;
          while (((Iterator)localObject2).hasNext()) {
            if ((((RecentBaseData)((Iterator)localObject2).next()).mMenuFlag & 0xF0) == 32) {
              m += 1;
            }
          }
          int n = paramList.size();
          int i1 = a(paramList, m, n);
          paramList.add(i1, localObject1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkAndReOrderRecentData insertIndex = ");
            ((StringBuilder)localObject2).append(i1);
            ((StringBuilder)localObject2).append(",setTopItemCount = ");
            ((StringBuilder)localObject2).append(m);
            ((StringBuilder)localObject2).append(",listsize = ");
            ((StringBuilder)localObject2).append(n);
            QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject2).toString());
          }
          long l = NetConnInfoCenter.getServerTime();
          if (((RecentItemMayKnowFriendData)localObject1).mUser.lastmsgtime < l) {
            ((RecentItemMayKnowFriendData)localObject1).mUser.lastmsgtime = l;
          }
          if (i1 > 0)
          {
            paramList = (RecentBaseData)paramList.get(i1 - 1);
            if (((paramList.mMenuFlag & 0xF0) != 32) && ((paramList instanceof RecentUserBaseData)))
            {
              l = ((RecentItemMayKnowFriendData)localObject1).mUser.lastmsgtime;
              paramList = (RecentUserBaseData)paramList;
              if (l > paramList.mUser.lastmsgtime) {
                ((RecentItemMayKnowFriendData)localObject1).mUser.lastmsgtime = (paramList.mUser.lastmsgtime - 1L);
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder();
            paramList.append("checkAndReOrderRecentData insertIndex = ");
            paramList.append(i1);
            paramList.append(",setTopItemCount = ");
            paramList.append(m);
            paramList.append(",listsize = ");
            paramList.append(n);
            paramList.append(",lastmsgtime = ");
            paramList.append(((RecentItemMayKnowFriendData)localObject1).mUser.lastmsgtime);
            QLog.d("MayknowRecommendManager", 2, paramList.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().b(((RecentItemMayKnowFriendData)localObject1).mUser);
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_mayknow_entry_is_up", false);
        }
        else
        {
          bool2 = false;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break label613;
          }
          QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData mayKnowFriendData is null ");
          bool1 = bool2;
          break label613;
        }
      }
    }
    boolean bool1 = true;
    label613:
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("checkAndReOrderRecentData result = ");
      paramList.append(bool1);
      QLog.d("MayknowRecommendManager", 2, paramList.toString());
    }
    return bool1;
  }
  
  /* Error */
  public boolean a(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +440 -> 441
    //   4: aload_2
    //   5: invokeinterface 617 1 0
    //   10: ifeq +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: iload_1
    //   16: ifeq +425 -> 441
    //   19: aload_0
    //   20: new 161	java/util/ArrayList
    //   23: dup
    //   24: aload_2
    //   25: invokespecial 1005	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   28: invokespecial 387	com/tencent/mobileqq/app/MayknowRecommendManager:b	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   31: astore 4
    //   33: new 161	java/util/ArrayList
    //   36: dup
    //   37: iconst_2
    //   38: invokespecial 162	java/util/ArrayList:<init>	(I)V
    //   41: astore 5
    //   43: aload 4
    //   45: invokevirtual 427	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_2
    //   49: aload_2
    //   50: invokeinterface 432 1 0
    //   55: ifeq +39 -> 94
    //   58: aload_2
    //   59: invokeinterface 436 1 0
    //   64: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull -20 -> 49
    //   72: aload_3
    //   73: invokestatic 1602	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   76: putfield 1395	com/tencent/mobileqq/data/MayKnowRecommend:cardDisplayTimestamp	J
    //   79: aload 5
    //   81: aload_3
    //   82: getfield 1101	com/tencent/mobileqq/data/MayKnowRecommend:uin	Ljava/lang/String;
    //   85: invokeinterface 603 2 0
    //   90: pop
    //   91: goto -42 -> 49
    //   94: aconst_null
    //   95: astore_3
    //   96: getstatic 50	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   99: astore 6
    //   101: aload 6
    //   103: monitorenter
    //   104: aload_3
    //   105: astore_2
    //   106: aload 4
    //   108: invokevirtual 373	java/util/ArrayList:size	()I
    //   111: ifle +101 -> 212
    //   114: aload_3
    //   115: astore_2
    //   116: aload_0
    //   117: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   120: invokevirtual 373	java/util/ArrayList:size	()I
    //   123: aload 4
    //   125: invokevirtual 373	java/util/ArrayList:size	()I
    //   128: iadd
    //   129: sipush 1000
    //   132: if_icmpge +80 -> 212
    //   135: aload_0
    //   136: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   139: invokevirtual 427	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   142: astore_2
    //   143: aload_2
    //   144: invokeinterface 432 1 0
    //   149: ifeq +40 -> 189
    //   152: aload_2
    //   153: invokeinterface 436 1 0
    //   158: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   161: astore_3
    //   162: aload_3
    //   163: ifnull -20 -> 143
    //   166: aload 5
    //   168: aload_3
    //   169: getfield 1101	com/tencent/mobileqq/data/MayKnowRecommend:uin	Ljava/lang/String;
    //   172: invokeinterface 1369 2 0
    //   177: ifeq -34 -> 143
    //   180: aload_2
    //   181: invokeinterface 1330 1 0
    //   186: goto -43 -> 143
    //   189: aload_0
    //   190: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   193: iconst_0
    //   194: aload 4
    //   196: invokevirtual 1605	java/util/ArrayList:addAll	(ILjava/util/Collection;)Z
    //   199: pop
    //   200: new 1607	java/util/LinkedList
    //   203: dup
    //   204: aload_0
    //   205: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   208: invokespecial 1608	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   211: astore_2
    //   212: aload 6
    //   214: monitorexit
    //   215: new 161	java/util/ArrayList
    //   218: dup
    //   219: invokespecial 168	java/util/ArrayList:<init>	()V
    //   222: astore 4
    //   224: getstatic 50	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   227: astore_3
    //   228: aload_3
    //   229: monitorenter
    //   230: aload_0
    //   231: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   234: invokevirtual 427	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   237: astore 5
    //   239: aload 5
    //   241: invokeinterface 432 1 0
    //   246: ifeq +34 -> 280
    //   249: aload 5
    //   251: invokeinterface 436 1 0
    //   256: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   259: astore 6
    //   261: aload 6
    //   263: ifnull -24 -> 239
    //   266: aload 4
    //   268: aload 6
    //   270: getfield 1101	com/tencent/mobileqq/data/MayKnowRecommend:uin	Ljava/lang/String;
    //   273: invokevirtual 678	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   276: pop
    //   277: goto -38 -> 239
    //   280: aload_3
    //   281: monitorexit
    //   282: aload 4
    //   284: invokevirtual 361	java/util/ArrayList:isEmpty	()Z
    //   287: ifne +13 -> 300
    //   290: aload_0
    //   291: getfield 145	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   294: iconst_1
    //   295: aload 4
    //   297: invokestatic 1417	com/tencent/mobileqq/activity/contacts/mayknow/ContactReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/util/ArrayList;)V
    //   300: aload_2
    //   301: ifnull +140 -> 441
    //   304: aload_2
    //   305: invokeinterface 617 1 0
    //   310: ifne +131 -> 441
    //   313: aload_0
    //   314: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   317: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   320: astore_3
    //   321: aload_3
    //   322: invokevirtual 415	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   325: aload_0
    //   326: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   329: ldc_w 1610
    //   332: invokevirtual 423	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   335: pop
    //   336: aload_2
    //   337: invokeinterface 591 1 0
    //   342: astore_2
    //   343: aload_2
    //   344: invokeinterface 432 1 0
    //   349: ifeq +37 -> 386
    //   352: aload_2
    //   353: invokeinterface 436 1 0
    //   358: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   361: astore 4
    //   363: aload 4
    //   365: ifnull -22 -> 343
    //   368: aload 4
    //   370: sipush 1000
    //   373: invokevirtual 1613	com/tencent/mobileqq/data/MayKnowRecommend:setStatus	(I)V
    //   376: aload_0
    //   377: aload 4
    //   379: invokevirtual 1345	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   382: pop
    //   383: goto -40 -> 343
    //   386: aload_3
    //   387: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   390: aload_3
    //   391: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   394: iconst_1
    //   395: ireturn
    //   396: astore_2
    //   397: goto +27 -> 424
    //   400: astore_2
    //   401: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +14 -> 418
    //   407: ldc_w 304
    //   410: iconst_2
    //   411: ldc_w 1615
    //   414: aload_2
    //   415: invokestatic 450	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_3
    //   419: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   422: iconst_0
    //   423: ireturn
    //   424: aload_3
    //   425: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   428: aload_2
    //   429: athrow
    //   430: astore_2
    //   431: aload_3
    //   432: monitorexit
    //   433: aload_2
    //   434: athrow
    //   435: astore_2
    //   436: aload 6
    //   438: monitorexit
    //   439: aload_2
    //   440: athrow
    //   441: iconst_0
    //   442: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	MayknowRecommendManager
    //   0	443	1	paramBoolean	boolean
    //   0	443	2	paramList	List<MayKnowRecommend>
    //   67	365	3	localObject1	Object
    //   31	347	4	localObject2	Object
    //   41	209	5	localObject3	Object
    //   99	338	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   321	343	396	finally
    //   343	363	396	finally
    //   368	383	396	finally
    //   386	390	396	finally
    //   401	418	396	finally
    //   321	343	400	java/lang/Exception
    //   343	363	400	java/lang/Exception
    //   368	383	400	java/lang/Exception
    //   386	390	400	java/lang/Exception
    //   230	239	430	finally
    //   239	261	430	finally
    //   266	277	430	finally
    //   280	282	430	finally
    //   431	433	430	finally
    //   106	114	435	finally
    //   116	143	435	finally
    //   143	162	435	finally
    //   166	186	435	finally
    //   189	212	435	finally
    //   212	215	435	finally
    //   436	439	435	finally
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_version", 0);
  }
  
  public ArrayList<String> b()
  {
    p();
    ArrayList localArrayList = new ArrayList(4);
    Object localObject3;
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      Object localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
      int m = 0;
      if ((localObject1 != null) && (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject1 = (ConnectionsTabInfo)this.jdField_c_of_type_JavaUtilArrayList.get(0);
        if (localObject1 != null)
        {
          localObject1 = a(((ConnectionsTabInfo)localObject1).jdField_a_of_type_Int);
          if (localObject1 != null) {
            while ((m < ((ArrayList)localObject1).size()) && (m < 4))
            {
              localArrayList.add(((MayKnowRecommend)((ArrayList)localObject1).get(m)).uin);
              m += 1;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getConnectionsPersonUinListFroAddActivity ");
          ((StringBuilder)localObject1).append(localArrayList.toString());
          QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
        }
        return localArrayList;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConnectionsDataExceptRecommendTab ");
    }
    p();
    Object localObject = this.jdField_c_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ConnectionsTabInfo localConnectionsTabInfo = (ConnectionsTabInfo)((Iterator)localObject).next();
        if (localConnectionsTabInfo.jdField_a_of_type_Int != 23)
        {
          a(localConnectionsTabInfo.jdField_a_of_type_Int, new ArrayList(0), true);
          a(localConnectionsTabInfo.jdField_a_of_type_Int, null);
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeConnectionTab ");
      ((StringBuilder)???).append(paramInt);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
    }
    int n = 0;
    int i1 = 0;
    a(paramInt, new ArrayList(0), true);
    p();
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        do
        {
          m = i1;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (((ConnectionsTabInfo)localIterator.next()).jdField_a_of_type_Int != paramInt);
        localIterator.remove();
        int m = 1;
        n = m;
        if (m != 0)
        {
          d(this.jdField_c_of_type_JavaUtilArrayList);
          n = m;
        }
      }
      if (n != 0) {
        a(paramInt, null);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConnectionsPersonRemoteNextPage entryType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" tabID=");
      localStringBuilder.append(paramInt2);
      QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    paramBundle = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4, paramInt1, paramInt2, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramBundle);
  }
  
  public void b(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if ((this.h) && (!this.jdField_g_of_type_Boolean))
      {
        paramMayKnowRecommend = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMayKnowRecommend))
        {
          paramMayKnowRecommend = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMayKnowRecommend);
          if ((paramInt3 == 1) && (paramMayKnowRecommend.startExploseTime != 0L))
          {
            long l1 = SystemClock.uptimeMillis();
            long l2 = paramMayKnowRecommend.startExploseTime;
            paramMayKnowRecommend.exposeTime = ((int)(paramMayKnowRecommend.exposeTime + (l1 - l2)));
            paramMayKnowRecommend.exposeCnt += 1;
            paramMayKnowRecommend.startExploseTime = 0L;
          }
        }
        return;
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, true);
  }
  
  public void b(List<oidb_0xc26.EntryDelay> paramList)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong("sp_get_mayknow_timestamp_v3_for_card_header", System.currentTimeMillis());
    localEditor.putLong("sp_get_mayknow_timestamp_v2", System.currentTimeMillis());
    int i2 = 0;
    int i3 = 0;
    int i1;
    int n;
    int m;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      i2 = 0;
      i1 = 0;
      n = 0;
      m = 0;
      while (paramList.hasNext())
      {
        oidb_0xc26.EntryDelay localEntryDelay = (oidb_0xc26.EntryDelay)paramList.next();
        int i4 = localEntryDelay.em_entry.get();
        if (i4 != 1)
        {
          if (i4 != 2)
          {
            if (i4 != 3)
            {
              if (i4 != 4)
              {
                if (i4 == 5) {
                  m = localEntryDelay.uint32_delay.get();
                }
              }
              else {
                i3 = localEntryDelay.uint32_delay.get();
              }
            }
            else {
              n = localEntryDelay.uint32_delay.get();
            }
          }
          else {
            i1 = localEntryDelay.uint32_delay.get();
          }
        }
        else {
          i2 = localEntryDelay.uint32_delay.get();
        }
      }
    }
    else
    {
      i3 = 0;
      i1 = 0;
      n = 0;
      m = 0;
    }
    if (i2 > 0) {
      localEditor.putLong("pull_interval_conversation_tab", i2 * 1000);
    }
    if (i1 > 0) {
      localEditor.putLong("pull_interval_contact_head", i1 * 1000);
    }
    if (n > 0) {
      localEditor.putLong("pull_interval_recommend_tab", n * 1000);
    }
    if (i3 > 0) {
      localEditor.putLong("pull_interval_new_friend", i3 * 1000);
    }
    if (m > 0) {
      localEditor.putLong("pull_interval_add_page", m * 1000);
    }
    localEditor.commit();
    paramList = new StringBuilder();
    paramList.append("saveReqTimeAndIntervalInfo,msgIntervel = ");
    paramList.append(i2);
    paramList.append(",headIntervel = ");
    paramList.append(i1);
    paramList.append(",recommendIntervel = ");
    paramList.append(n);
    paramList.append(",newIntervel = ");
    paramList.append(i3);
    paramList.append(",addIntervel = ");
    paramList.append(m);
    QLog.i("MayknowRecommendManager", 1, paramList.toString());
  }
  
  public boolean b()
  {
    int m = this.jdField_b_of_type_Int;
    boolean bool = true;
    if (m == 1) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldShowRecommendTroop result: ");
      localStringBuilder.append(bool);
      QLog.i("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    long l1;
    if (paramInt == 2) {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_get_mayknow_timestamp_v3_for_card_header", 0L);
    } else {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_get_mayknow_timestamp_v2", 0L);
    }
    long l2 = a(paramInt);
    boolean bool;
    if (Math.abs(l1 - System.currentTimeMillis()) >= l2) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("isTimeToObtainRemote, return=");
    localStringBuilder2.append(bool);
    localStringBuilder2.append(", lastTime");
    localStringBuilder2.append(l1);
    localStringBuilder1.append(String.format(localStringBuilder2.toString(), new Object[0]));
    localStringBuilder1.append(", pullInternalTime");
    localStringBuilder1.append(l2);
    localStringBuilder1.append(",entryType = ");
    localStringBuilder1.append(paramInt);
    QLog.d("MayknowRecommendManager", 1, localStringBuilder1.toString());
    return bool;
  }
  
  public boolean b(String paramString)
  {
    boolean bool1;
    if (!TextUtils.isEmpty(paramString)) {
      bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, false);
    } else {
      bool1 = false;
    }
    boolean bool3 = bool1;
    if (this.jdField_b_of_type_Int == 1)
    {
      boolean bool2 = bool1;
      Object localObject;
      if (bool1)
      {
        bool2 = bool1;
        if (!TextUtils.equals(paramString, "sp_mayknow_ml_s_a_vl"))
        {
          bool2 = bool1;
          if (!TextUtils.equals(paramString, "sp_mayknow_addpage_s_a_vl"))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            bool2 = bool1;
            if (localObject != null)
            {
              localObject = (CTEntryMng)((QQAppInterface)localObject).getManager(QQManagerFactory.CTENTRY_MNG);
              bool2 = bool1;
              if (localObject != null)
              {
                bool2 = bool1;
                if (((CTEntryMng)localObject).b())
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("MayknowRecommendManager", 2, "getSPSwitchState user closed");
                  }
                  bool2 = false;
                }
              }
            }
          }
        }
      }
      bool3 = bool2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSPSwitchState name:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("  open:");
        ((StringBuilder)localObject).append(bool2);
        QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
        bool3 = bool2;
      }
    }
    return bool3;
  }
  
  /* Error */
  public boolean b(boolean paramBoolean, List<String> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +331 -> 332
    //   4: aload_2
    //   5: invokeinterface 617 1 0
    //   10: ifeq +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: iload_1
    //   16: ifeq +316 -> 332
    //   19: new 1607	java/util/LinkedList
    //   22: dup
    //   23: invokespecial 1674	java/util/LinkedList:<init>	()V
    //   26: astore_3
    //   27: getstatic 50	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   30: astore 4
    //   32: aload 4
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   39: invokevirtual 427	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   42: astore 5
    //   44: aload 5
    //   46: invokeinterface 432 1 0
    //   51: ifeq +53 -> 104
    //   54: aload 5
    //   56: invokeinterface 436 1 0
    //   61: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull -24 -> 44
    //   71: aload_2
    //   72: aload 6
    //   74: getfield 1101	com/tencent/mobileqq/data/MayKnowRecommend:uin	Ljava/lang/String;
    //   77: invokeinterface 1369 2 0
    //   82: ifeq -38 -> 44
    //   85: aload_3
    //   86: aload 6
    //   88: invokeinterface 603 2 0
    //   93: pop
    //   94: aload 5
    //   96: invokeinterface 1330 1 0
    //   101: goto -57 -> 44
    //   104: aload 4
    //   106: monitorexit
    //   107: new 161	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 168	java/util/ArrayList:<init>	()V
    //   114: astore 4
    //   116: getstatic 50	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   119: astore_2
    //   120: aload_2
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 170	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   126: invokevirtual 427	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   129: astore 5
    //   131: aload 5
    //   133: invokeinterface 432 1 0
    //   138: ifeq +34 -> 172
    //   141: aload 5
    //   143: invokeinterface 436 1 0
    //   148: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   151: astore 6
    //   153: aload 6
    //   155: ifnull -24 -> 131
    //   158: aload 4
    //   160: aload 6
    //   162: getfield 1101	com/tencent/mobileqq/data/MayKnowRecommend:uin	Ljava/lang/String;
    //   165: invokevirtual 678	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: goto -38 -> 131
    //   172: aload_2
    //   173: monitorexit
    //   174: aload 4
    //   176: invokevirtual 361	java/util/ArrayList:isEmpty	()Z
    //   179: ifne +13 -> 192
    //   182: aload_0
    //   183: getfield 145	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: iconst_1
    //   187: aload 4
    //   189: invokestatic 1417	com/tencent/mobileqq/activity/contacts/mayknow/ContactReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/util/ArrayList;)V
    //   192: aload_3
    //   193: invokeinterface 617 1 0
    //   198: ifne +134 -> 332
    //   201: aload_0
    //   202: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   205: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   208: astore_2
    //   209: aload_2
    //   210: invokevirtual 415	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   213: aload_3
    //   214: invokeinterface 591 1 0
    //   219: astore_3
    //   220: aload_3
    //   221: invokeinterface 432 1 0
    //   226: ifeq +51 -> 277
    //   229: aload_3
    //   230: invokeinterface 436 1 0
    //   235: checkcast 438	com/tencent/mobileqq/data/MayKnowRecommend
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull -22 -> 220
    //   245: aload 4
    //   247: getfield 1101	com/tencent/mobileqq/data/MayKnowRecommend:uin	Ljava/lang/String;
    //   250: astore 5
    //   252: aload_0
    //   253: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   256: aload 4
    //   258: ldc_w 1676
    //   261: iconst_1
    //   262: anewarray 323	java/lang/String
    //   265: dup
    //   266: iconst_0
    //   267: aload 5
    //   269: aastore
    //   270: invokevirtual 1679	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   273: pop
    //   274: goto -54 -> 220
    //   277: aload_2
    //   278: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   281: aload_2
    //   282: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   285: iconst_1
    //   286: ireturn
    //   287: astore_3
    //   288: goto +27 -> 315
    //   291: astore_3
    //   292: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +14 -> 309
    //   298: ldc_w 304
    //   301: iconst_2
    //   302: ldc_w 1681
    //   305: aload_3
    //   306: invokestatic 450	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   309: aload_2
    //   310: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   313: iconst_0
    //   314: ireturn
    //   315: aload_2
    //   316: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   319: aload_3
    //   320: athrow
    //   321: astore_3
    //   322: aload_2
    //   323: monitorexit
    //   324: aload_3
    //   325: athrow
    //   326: astore_2
    //   327: aload 4
    //   329: monitorexit
    //   330: aload_2
    //   331: athrow
    //   332: iconst_0
    //   333: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	MayknowRecommendManager
    //   0	334	1	paramBoolean	boolean
    //   0	334	2	paramList	List<String>
    //   26	204	3	localObject1	Object
    //   287	1	3	localObject2	Object
    //   291	29	3	localException	Exception
    //   321	4	3	localObject3	Object
    //   30	298	4	localObject4	Object
    //   42	226	5	localObject5	Object
    //   64	97	6	localMayKnowRecommend	MayKnowRecommend
    // Exception table:
    //   from	to	target	type
    //   209	220	287	finally
    //   220	240	287	finally
    //   245	274	287	finally
    //   277	281	287	finally
    //   292	309	287	finally
    //   209	220	291	java/lang/Exception
    //   220	240	291	java/lang/Exception
    //   245	274	291	java/lang/Exception
    //   277	281	291	java/lang/Exception
    //   122	131	321	finally
    //   131	153	321	finally
    //   158	169	321	finally
    //   172	174	321	finally
    //   322	324	321	finally
    //   35	44	326	finally
    //   44	66	326	finally
    //   71	101	326	finally
    //   104	107	326	finally
    //   327	330	326	finally
  }
  
  public ArrayList<MayKnowRecommend> c()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
  }
  
  public void c()
  {
    boolean bool = b("sp_mayknow_entry_list_msg");
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("prepareConversationTabRecommendTroopList troopItems size: ");
      ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilList.size());
      ((StringBuilder)???).append(" switch open: ");
      ((StringBuilder)???).append(bool);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
    }
    Object localObject4 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ((List)localObject4).addAll(this.jdField_a_of_type_JavaUtilList);
      RecentUserProxy localRecentUserProxy;
      Object localObject2;
      long l;
      Iterator localIterator;
      if ((!((List)localObject4).isEmpty()) && (bool))
      {
        localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        localRecentUserProxy.a(8112);
        ??? = localRecentUserProxy.b(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, 8111);
        if (??? != null) {
          localRecentUserProxy.a((RecentUser)???);
        }
        localRecentUserProxy.a(8113);
        localObject2 = localRecentUserProxy.b("sp_uin_for_title", 8113);
        ??? = localObject2;
        if (localObject2 == null) {
          ??? = new RecentUser("sp_uin_for_title", 8113);
        }
        l = -2L;
        ((RecentUser)???).lastmsgtime = -2L;
        ((RecentUser)???).lastmsgdrafttime = -500L;
        ((RecentUser)???).opTime = -500L;
        localRecentUserProxy.b((RecentUser)???);
        localIterator = ((List)localObject4).iterator();
      }
      while (localIterator.hasNext())
      {
        RecentRecommendTroopItem localRecentRecommendTroopItem = (RecentRecommendTroopItem)localIterator.next();
        localObject2 = localRecentUserProxy.b(localRecentRecommendTroopItem.uin, 8113);
        ??? = localObject2;
        if (localObject2 == null) {
          ??? = new RecentUser(localRecentRecommendTroopItem.uin, 8113);
        }
        localObject4 = localRecentRecommendTroopItem.name;
        localObject2 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject2 = localRecentRecommendTroopItem.uin;
        }
        ((RecentUser)???).displayName = ((String)localObject2);
        ((RecentUser)???).extraInfo = localRecentRecommendTroopItem;
        l -= 1L;
        ((RecentUser)???).lastmsgtime = l;
        ((RecentUser)???).lastmsgdrafttime = -500L;
        ((RecentUser)???).opTime = -500L;
        localRecentUserProxy.b((RecentUser)???);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(8113);
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void c(int paramInt)
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getMayKnowRecommend(null, null, paramInt, null);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onContactsTabTroopItemDeleted troop uin: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
    }
    a(paramString);
    Object localObject = (IRecommendTroopService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRecommendTroopService.class, "");
    if (localObject != null) {
      ((IRecommendTroopService)localObject).setRecommendTroopDeleted(paramString, new MayknowRecommendManager.6(this, paramString));
    }
    this.jdField_e_of_type_Int -= 1;
    paramString = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if (this.jdField_e_of_type_Int == 0)
    {
      this.jdField_c_of_type_Long = NetConnInfoCenter.getServerTime();
      paramString.putLong("sp_contacts_tab_recommend_troop_hide_time", this.jdField_c_of_type_Long);
      ReportController.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_hide", 0, 0, "", "", "", "");
    }
    paramString.putInt("sp_contacts_tab_recommend_troop_count", this.jdField_e_of_type_Int);
    paramString.commit();
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(90, true, null);
  }
  
  public boolean c()
  {
    boolean bool1 = b();
    boolean bool2 = StudyModeManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowRecommendTroopInConversation, showRecommendTroop: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  public void d()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("prepareConversationMayKnowRecenUser ，conversationTabDisplayAsVerticalListItem = ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
    }
    if ((b("sp_mayknow_entry_list_msg")) && (this.jdField_b_of_type_Int == 1))
    {
      Object localObject3 = c();
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        g(8113);
        if (this.jdField_b_of_type_Boolean)
        {
          localObject1 = localRecentUserProxy.b(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, 8111);
          if (localObject1 != null) {
            localRecentUserProxy.a((RecentUser)localObject1);
          }
          g(8112);
          localObject2 = localRecentUserProxy.b("sp_uin_for_title", 8112);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new RecentUser("sp_uin_for_title", 8112);
          }
          long l = -1L;
          ((RecentUser)localObject1).lastmsgtime = -1L;
          ((RecentUser)localObject1).lastmsgdrafttime = -500L;
          ((RecentUser)localObject1).opTime = -500L;
          localRecentUserProxy.b((RecentUser)localObject1);
          Iterator localIterator = ((ArrayList)localObject3).iterator();
          while (localIterator.hasNext())
          {
            MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
            localObject1 = localRecentUserProxy.b(localMayKnowRecommend.uin, 8112);
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new RecentUser(localMayKnowRecommend.uin, 8112);
            }
            localObject3 = localMayKnowRecommend.remark;
            localObject1 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject3 = localMayKnowRecommend.mobile_name;
              localObject1 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject1 = localMayKnowRecommend.nick;
              }
            }
            ((RecentUser)localObject2).displayName = ((String)localObject1);
            ((RecentUser)localObject2).extraInfo = localMayKnowRecommend;
            l -= 1L;
            ((RecentUser)localObject2).lastmsgtime = l;
            ((RecentUser)localObject2).lastmsgdrafttime = -500L;
            ((RecentUser)localObject2).opTime = -500L;
            localRecentUserProxy.b((RecentUser)localObject2);
          }
        }
        g(8112);
        Object localObject2 = localRecentUserProxy.b(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, 8111);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("prepareConversationMayKnowRecenUser mayKnowRecommends.size = ");
          ((StringBuilder)localObject1).append(((ArrayList)localObject3).size());
          ((StringBuilder)localObject1).append(",ru = ");
          ((StringBuilder)localObject1).append(localObject2);
          QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RecentUser(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, 8111);
        }
        localRecentUserProxy.b((RecentUser)localObject1);
        ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).f();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "prepareConversationMayKnowRecenUser hideConversationMayKnow  return ");
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(120, true, new Object[] { Integer.valueOf(paramInt) });
    }
    this.jdField_b_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putInt("sp_conversation_tab_show_type", paramInt);
    ((SharedPreferences.Editor)localObject).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveConversationTabShowType type is: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onConversationTabTroopItemDeleted uin:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
    }
    RecentRecommendTroopItem localRecentRecommendTroopItem = a(paramString);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = "";
    localObject2 = (IRecommendTroopService)((QQAppInterface)localObject2).getRuntimeService(IRecommendTroopService.class, "");
    if (localObject2 != null) {
      ((IRecommendTroopService)localObject2).setRecommendTroopDeleted(paramString, new MayknowRecommendManager.7(this, paramString));
    }
    localObject2 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    ((FriendListHandler)localObject2).notifyUI(90, true, null);
    ((FriendListHandler)localObject2).notifyUI(119, true, new Object[] { paramString });
    if (localRecentRecommendTroopItem == null) {
      paramString = "";
    } else {
      paramString = localRecentRecommendTroopItem.uin;
    }
    if (localRecentRecommendTroopItem != null) {
      localObject1 = localRecentRecommendTroopItem.recomAlgol;
    }
    ReportController.b(null, "dc00899", "Grp_recom", "", "msg_tab", "slide_delete", 0, 0, paramString, (String)localObject1, "", "");
  }
  
  public boolean d()
  {
    boolean bool1 = b("sp_mayknow_entry_list_msg");
    boolean bool2 = StudyModeManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowConversationMayKnow, mayKnowListSwitch: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeConversationMayKnowRecentUser  ，conversationTabDisplayAsVerticalListItem = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    g(8112);
    RecentUser localRecentUser = ((RecentUserProxy)localObject).b(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, 8111);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeConversationMayKnowRecentUser ,ru = ");
      localStringBuilder.append(localRecentUser);
      QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    if (localRecentUser != null) {
      ((RecentUserProxy)localObject).a(localRecentUser);
    }
    ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).e();
  }
  
  public void e(String paramString)
  {
    a(paramString);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(119, true, new Object[] { paramString });
  }
  
  public boolean e()
  {
    boolean bool1 = b("sp_mayknow_entry_list_new");
    boolean bool2 = StudyModeManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowMayKnowInNewFriend, mayKnowListSwitch: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 167	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnull +294 -> 302
    //   11: aload_0
    //   12: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aconst_null
    //   20: astore 4
    //   22: aconst_null
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: aload 4
    //   28: astore_1
    //   29: aload 5
    //   31: invokevirtual 945	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   34: invokeinterface 948 1 0
    //   39: astore 5
    //   41: aload_3
    //   42: astore_2
    //   43: aload 4
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 159	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: invokevirtual 410	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   53: astore_3
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 415	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: astore_1
    //   66: aload 5
    //   68: invokeinterface 432 1 0
    //   73: ifeq +53 -> 126
    //   76: aload_3
    //   77: astore_2
    //   78: aload_3
    //   79: astore_1
    //   80: aload 5
    //   82: invokeinterface 436 1 0
    //   87: checkcast 950	java/util/Map$Entry
    //   90: invokeinterface 960 1 0
    //   95: checkcast 835	com/tencent/mobileqq/data/MayKnowExposure
    //   98: astore 4
    //   100: aload_3
    //   101: astore_2
    //   102: aload_3
    //   103: astore_1
    //   104: aload 4
    //   106: getfield 963	com/tencent/mobileqq/data/MayKnowExposure:exposeCnt	I
    //   109: ifle -47 -> 62
    //   112: aload_3
    //   113: astore_2
    //   114: aload_3
    //   115: astore_1
    //   116: aload_0
    //   117: aload 4
    //   119: invokevirtual 1345	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   122: pop
    //   123: goto -61 -> 62
    //   126: aload_3
    //   127: astore_2
    //   128: aload_3
    //   129: astore_1
    //   130: aload_3
    //   131: invokevirtual 445	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   134: aload_3
    //   135: astore_2
    //   136: aload_3
    //   137: astore_1
    //   138: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +62 -> 203
    //   144: aload_3
    //   145: astore_2
    //   146: aload_3
    //   147: astore_1
    //   148: new 295	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   155: astore 4
    //   157: aload_3
    //   158: astore_2
    //   159: aload_3
    //   160: astore_1
    //   161: aload 4
    //   163: ldc_w 1783
    //   166: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_3
    //   171: astore_2
    //   172: aload_3
    //   173: astore_1
    //   174: aload 4
    //   176: aload_0
    //   177: getfield 167	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   180: invokevirtual 933	java/util/concurrent/ConcurrentHashMap:size	()I
    //   183: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_3
    //   188: astore_2
    //   189: aload_3
    //   190: astore_1
    //   191: ldc_w 304
    //   194: iconst_2
    //   195: aload 4
    //   197: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_3
    //   204: astore_2
    //   205: aload_3
    //   206: astore_1
    //   207: getstatic 52	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   210: astore 4
    //   212: aload_3
    //   213: astore_2
    //   214: aload_3
    //   215: astore_1
    //   216: aload 4
    //   218: monitorenter
    //   219: aload_0
    //   220: getfield 167	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   223: ifnull +10 -> 233
    //   226: aload_0
    //   227: getfield 167	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   230: invokevirtual 1784	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   233: aload 4
    //   235: monitorexit
    //   236: aload_3
    //   237: ifnull +54 -> 291
    //   240: aload_3
    //   241: astore_1
    //   242: goto +45 -> 287
    //   245: astore 5
    //   247: aload 4
    //   249: monitorexit
    //   250: aload_3
    //   251: astore_2
    //   252: aload_3
    //   253: astore_1
    //   254: aload 5
    //   256: athrow
    //   257: astore_1
    //   258: goto +34 -> 292
    //   261: astore_3
    //   262: aload_1
    //   263: astore_2
    //   264: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +16 -> 283
    //   270: aload_1
    //   271: astore_2
    //   272: ldc_w 304
    //   275: iconst_2
    //   276: ldc_w 1786
    //   279: aload_3
    //   280: invokestatic 1788	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload_1
    //   284: ifnull +7 -> 291
    //   287: aload_1
    //   288: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   291: return
    //   292: aload_2
    //   293: ifnull +7 -> 300
    //   296: aload_2
    //   297: invokevirtual 453	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   300: aload_1
    //   301: athrow
    //   302: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	MayknowRecommendManager
    //   28	226	1	localObject1	Object
    //   257	44	1	localObject2	Object
    //   25	272	2	localObject3	Object
    //   23	230	3	localEntityTransaction	EntityTransaction
    //   261	19	3	localException	Exception
    //   20	228	4	localObject4	Object
    //   4	77	5	localObject5	Object
    //   245	10	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   219	233	245	finally
    //   233	236	245	finally
    //   247	250	245	finally
    //   29	41	257	finally
    //   46	54	257	finally
    //   58	62	257	finally
    //   66	76	257	finally
    //   80	100	257	finally
    //   104	112	257	finally
    //   116	123	257	finally
    //   130	134	257	finally
    //   138	144	257	finally
    //   148	157	257	finally
    //   161	170	257	finally
    //   174	187	257	finally
    //   191	203	257	finally
    //   207	212	257	finally
    //   216	219	257	finally
    //   254	257	257	finally
    //   264	270	257	finally
    //   272	283	257	finally
    //   29	41	261	java/lang/Exception
    //   46	54	261	java/lang/Exception
    //   58	62	261	java/lang/Exception
    //   66	76	261	java/lang/Exception
    //   80	100	261	java/lang/Exception
    //   104	112	261	java/lang/Exception
    //   116	123	261	java/lang/Exception
    //   130	134	261	java/lang/Exception
    //   138	144	261	java/lang/Exception
    //   148	157	261	java/lang/Exception
    //   161	170	261	java/lang/Exception
    //   174	187	261	java/lang/Exception
    //   191	203	261	java/lang/Exception
    //   207	212	261	java/lang/Exception
    //   216	219	261	java/lang/Exception
    //   254	257	261	java/lang/Exception
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 1, "turnOffSPMsgTabEntrySwitchState");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_mayknow_entry_list_msg", false).commit();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onConversationTabRecommendTroopHided");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(8113);
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putBoolean("sp_mayknow_entry_list_msg", false);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    ((FriendListHandler)localObject).notifyUI(90, true, null);
    ((FriendListHandler)localObject).reqHideConversationTroopRecommend();
  }
  
  public void i()
  {
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onEnterBackground ");
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.sendEmptyMessage(7);
      ContactReportUtils.a();
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    f();
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener != null) {
        ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener = null;
      StudyModeManager.b(this.jdField_a_of_type_ComTencentMobileqqStudymodeStudyModeChangeListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager
 * JD-Core Version:    0.7.0.1
 */