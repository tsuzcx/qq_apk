package com.tencent.mobileqq.activity.contact.phonecontact;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.database.StaleDataException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.adapter.ContactBindedAdapter.ContactBindedData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LastLoginPhoneInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.phonecontact.ContactBindHandler;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindObserver2;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.VersionUtils;
import friendlist.GetOnlineInfoResp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mobileqq.data.PhoneContact;>;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class PhoneContactManagerImp
  implements PhoneContactManager
{
  static volatile long jdField_a_of_type_Long = 120000L;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b;
  static volatile long jdField_b_of_type_Long = 86400000L;
  public static int d;
  public static int e;
  public static boolean f;
  volatile int jdField_a_of_type_Int = -1;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private PhoneContactManagerImp.LoadContactFriendListTask jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$LoadContactFriendListTask;
  private PhoneContactManagerImp.MyContentObserver jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$MyContentObserver;
  private PhoneContactManagerImp.UploadProgressGenerator jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator = null;
  private PermissionChecker jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionChecker;
  public ContactBindedAdapter.ContactBindedData a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ContactBinded jdField_a_of_type_ComTencentMobileqqDataContactBinded;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ContactBindHandler jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindHandler;
  private ContactBindObserver2 jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver2 = new PhoneContactManagerImp.22(this);
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new PhoneContactManagerImp.2(this);
  private Boolean jdField_a_of_type_JavaLangBoolean = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new PhoneContactManagerImp.8(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ContactMatch> jdField_a_of_type_JavaUtilArrayList;
  private LinkedList<PhoneContactManager.IPhoneContactListener> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public volatile List<PhoneContact> a;
  private final Random jdField_a_of_type_JavaUtilRandom;
  private volatile Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  volatile boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private ArrayList<PhoneContactAdd> jdField_b_of_type_JavaUtilArrayList;
  List<PhoneContact> jdField_b_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_b_of_type_Boolean = false;
  public volatile int c;
  volatile long jdField_c_of_type_Long = 0L;
  private SharedPreferences jdField_c_of_type_AndroidContentSharedPreferences;
  private List<MobileContactsFriendInfo> jdField_c_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_c_of_type_Boolean = false;
  volatile long jdField_d_of_type_Long = 0L;
  private List<MobileContactsNotFriendInfo> jdField_d_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_d_of_type_Boolean;
  volatile long jdField_e_of_type_Long = 0L;
  private List<String> jdField_e_of_type_JavaUtilList = null;
  private ConcurrentHashMap<String, PhoneContact> jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean e;
  private int jdField_f_of_type_Int = -1;
  public long f;
  private List<PhoneContact> jdField_f_of_type_JavaUtilList = null;
  private ConcurrentHashMap<String, PhoneContact> jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final int jdField_g_of_type_Int;
  private volatile long jdField_g_of_type_Long = 0L;
  private List<PhoneContact> jdField_g_of_type_JavaUtilList = null;
  private ConcurrentHashMap<String, PhoneContact> jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  boolean jdField_g_of_type_Boolean = false;
  private long jdField_h_of_type_Long;
  private volatile List<PhoneContact> jdField_h_of_type_JavaUtilList = null;
  private volatile boolean jdField_h_of_type_Boolean = true;
  private List<PhoneContact> jdField_i_of_type_JavaUtilList = null;
  private boolean jdField_i_of_type_Boolean = false;
  private List<PhoneContact> jdField_j_of_type_JavaUtilList = null;
  private volatile boolean jdField_j_of_type_Boolean = false;
  private List<PhoneContact> jdField_k_of_type_JavaUtilList = null;
  private boolean jdField_k_of_type_Boolean = false;
  private List<NotBindContactNotFriendInfo> jdField_l_of_type_JavaUtilList;
  private volatile boolean jdField_l_of_type_Boolean = false;
  private List<NotBindContactFriendInfo> jdField_m_of_type_JavaUtilList;
  private boolean jdField_m_of_type_Boolean = false;
  private boolean n;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "data1", "display_name", "contact_id", "data2", "data3" };
    jdField_b_of_type_Int = 20;
    jdField_f_of_type_Boolean = false;
    jdField_d_of_type_Int = 0;
    jdField_e_of_type_Int = 2;
  }
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter$ContactBindedData = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_new_friend", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("contact_bind_info_global", 0);
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("session_id", "").getBytes();
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("contact_last_query_list_time", 0L);
    this.jdField_h_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_unbind_mobile_time", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("init [%s, %s]", new Object[] { Long.valueOf(this.jdField_c_of_type_Long), Long.valueOf(this.jdField_h_of_type_Long) }));
    }
    r();
    this.jdField_g_of_type_Long = this.jdField_b_of_type_AndroidContentSharedPreferences.getLong("user_setting_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0L);
    this.jdField_a_of_type_Int = a(a());
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver2);
    this.jdField_a_of_type_JavaUtilRandom = new Random(SystemClock.elapsedRealtime());
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics();
    if (Math.min(paramQQAppInterface.widthPixels, paramQQAppInterface.heightPixels) >= 1080) {}
    for (int i1 = 5;; i1 = 4)
    {
      this.jdField_g_of_type_Int = i1;
      ThreadManager.excute(new PhoneContactManagerImp.1(this), 16, null, false);
      return;
    }
  }
  
  private int a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (paramRespondQueryQQBindingStat == null) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, String.format("getSelfBindState [%s, %s]", new Object[] { a(), paramRespondQueryQQBindingStat }));
      }
      if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.mobileNo))
      {
        if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
          return 1;
        }
        if (a().equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
          return 2;
        }
        return 3;
      }
      if ((paramRespondQueryQQBindingStat.originBinder == 2L) || (paramRespondQueryQQBindingStat.originBinder == 3L)) {
        return 5;
      }
    } while (paramRespondQueryQQBindingStat.originBinder != 1L);
    if (paramRespondQueryQQBindingStat.MobileUniqueNo.equals("init padding")) {
      paramRespondQueryQQBindingStat.MobileUniqueNo = null;
    }
    if ((TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) || (paramRespondQueryQQBindingStat.isStopFindMatch)) {
      return 7;
    }
    if (a().equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 9;
    }
    return 6;
  }
  
  private String a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramString;
    }
    paramString = paramString.getBytes();
    int i2 = paramString.length;
    paramArrayOfByte = a(paramArrayOfByte);
    paramString = a(paramString);
    int i1 = 0;
    while (i1 < i2)
    {
      paramArrayOfByte[i1] = ((byte)(paramString[i1] ^ paramArrayOfByte[i1]));
      i1 += 1;
    }
    i2 = paramArrayOfByte.length;
    i1 = i2 - 1;
    if (i1 >= 0) {
      if (paramArrayOfByte[i1] == 0) {}
    }
    for (;;)
    {
      if (i1 != i2 - 1)
      {
        paramString = new byte[i1 + 1];
        System.arraycopy(paramArrayOfByte, 0, paramString, 0, i1 + 1);
        paramArrayOfByte = paramString;
      }
      for (;;)
      {
        return new String(a(paramArrayOfByte));
        i1 -= 1;
        break;
      }
      i1 = 0;
    }
  }
  
  /* Error */
  private ArrayList<PhoneContact> a(ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2)
  {
    // Byte code:
    //   0: new 458	java/util/HashMap
    //   3: dup
    //   4: invokespecial 459	java/util/HashMap:<init>	()V
    //   7: astore 12
    //   9: new 190	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 191	java/util/ArrayList:<init>	()V
    //   16: astore 11
    //   18: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: ldc_w 280
    //   26: iconst_1
    //   27: ldc_w 464
    //   30: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   40: invokevirtual 468	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   43: astore 7
    //   45: aload 7
    //   47: getstatic 474	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   50: getstatic 84	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 480	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnull +248 -> 311
    //   66: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +36 -> 105
    //   72: ldc_w 280
    //   75: iconst_2
    //   76: new 226	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 482
    //   86: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 8
    //   91: invokeinterface 488 1 0
    //   96: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aconst_null
    //   106: astore 7
    //   108: aload_0
    //   109: getfield 318	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   112: invokevirtual 497	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   115: astore 9
    //   117: aload 9
    //   119: astore 7
    //   121: aload 7
    //   123: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   126: aload 8
    //   128: invokeinterface 505 1 0
    //   133: pop
    //   134: aload 8
    //   136: invokeinterface 508 1 0
    //   141: ifne +652 -> 793
    //   144: aload 8
    //   146: aload 8
    //   148: ldc 74
    //   150: invokeinterface 512 2 0
    //   155: invokeinterface 515 2 0
    //   160: invokestatic 520	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 10
    //   165: aload 8
    //   167: aload 8
    //   169: ldc 76
    //   171: invokeinterface 512 2 0
    //   176: invokeinterface 515 2 0
    //   181: astore 9
    //   183: aload 9
    //   185: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifeq +990 -> 1178
    //   191: aload 10
    //   193: astore 9
    //   195: aload 8
    //   197: aload 8
    //   199: ldc 78
    //   201: invokeinterface 512 2 0
    //   206: invokeinterface 524 2 0
    //   211: istore_3
    //   212: aload 8
    //   214: aload 8
    //   216: ldc 80
    //   218: invokeinterface 512 2 0
    //   223: invokeinterface 524 2 0
    //   228: istore 4
    //   230: aload 8
    //   232: aload 8
    //   234: ldc 82
    //   236: invokeinterface 512 2 0
    //   241: invokeinterface 515 2 0
    //   246: astore 13
    //   248: aload 10
    //   250: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   253: ifne +11 -> 264
    //   256: aload 9
    //   258: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifeq +132 -> 393
    //   264: aload 8
    //   266: invokeinterface 527 1 0
    //   271: pop
    //   272: goto -138 -> 134
    //   275: astore 9
    //   277: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +14 -> 294
    //   283: ldc_w 280
    //   286: iconst_2
    //   287: ldc 250
    //   289: aload 9
    //   291: invokestatic 530	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload 7
    //   296: ifnull +8 -> 304
    //   299: aload 7
    //   301: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   304: aload 8
    //   306: invokeinterface 536 1 0
    //   311: aload_0
    //   312: iconst_0
    //   313: putfield 156	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_g_of_type_Boolean	Z
    //   316: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +63 -> 382
    //   322: ldc_w 280
    //   325: iconst_2
    //   326: ldc_w 538
    //   329: iconst_4
    //   330: anewarray 4	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: aload_1
    //   336: invokevirtual 541	java/util/ArrayList:size	()I
    //   339: invokestatic 546	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: aload_2
    //   346: invokevirtual 541	java/util/ArrayList:size	()I
    //   349: invokestatic 546	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: aload 11
    //   357: invokevirtual 541	java/util/ArrayList:size	()I
    //   360: invokestatic 546	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   363: aastore
    //   364: dup
    //   365: iconst_3
    //   366: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   369: lload 5
    //   371: lsub
    //   372: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   375: aastore
    //   376: invokestatic 292	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   379: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload 11
    //   384: areturn
    //   385: astore 7
    //   387: aconst_null
    //   388: astore 8
    //   390: goto -329 -> 61
    //   393: aload_0
    //   394: getfield 158	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   397: aload 10
    //   399: invokevirtual 550	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   402: checkcast 552	com/tencent/mobileqq/data/PhoneContact
    //   405: astore 14
    //   407: aload 14
    //   409: ifnonnull +174 -> 583
    //   412: new 552	com/tencent/mobileqq/data/PhoneContact
    //   415: dup
    //   416: invokespecial 553	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   419: astore 14
    //   421: aload 14
    //   423: aload 10
    //   425: putfield 554	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   428: aload 14
    //   430: aload 9
    //   432: putfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   435: aload 14
    //   437: iload_3
    //   438: putfield 560	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   441: aload 14
    //   443: iload 4
    //   445: putfield 563	com/tencent/mobileqq/data/PhoneContact:type	I
    //   448: aload 14
    //   450: aload 13
    //   452: putfield 566	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   455: aload 14
    //   457: lload 5
    //   459: putfield 569	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   462: aload 14
    //   464: aload 9
    //   466: iconst_1
    //   467: invokestatic 574	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   470: putfield 577	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   473: aload 14
    //   475: aload 9
    //   477: iconst_2
    //   478: invokestatic 574	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   481: putfield 580	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   484: aload 14
    //   486: aload 14
    //   488: getfield 580	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   491: invokestatic 582	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   494: putfield 585	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   497: aload_0
    //   498: getfield 158	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   501: aload 10
    //   503: aload 14
    //   505: invokevirtual 589	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   508: pop
    //   509: aload 14
    //   511: aload 9
    //   513: aload 10
    //   515: invokestatic 591	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   518: putfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   521: aload_0
    //   522: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   525: aload 14
    //   527: getfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   530: aload 14
    //   532: invokevirtual 589	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   535: pop
    //   536: aload 11
    //   538: aload 14
    //   540: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   543: pop
    //   544: aload_1
    //   545: new 599	SecurityAccountServer/AddressBookItem
    //   548: dup
    //   549: aload 10
    //   551: aload 9
    //   553: invokespecial 602	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   559: pop
    //   560: goto -296 -> 264
    //   563: astore_1
    //   564: aload 7
    //   566: ifnull +8 -> 574
    //   569: aload 7
    //   571: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   574: aload 8
    //   576: invokeinterface 536 1 0
    //   581: aload_1
    //   582: athrow
    //   583: aload 14
    //   585: iload_3
    //   586: putfield 560	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   589: aload 14
    //   591: lload 5
    //   593: putfield 569	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   596: aload 14
    //   598: getfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   601: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   604: ifeq +33 -> 637
    //   607: aload 14
    //   609: aload 14
    //   611: getfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   614: aload 10
    //   616: invokestatic 591	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   619: putfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   622: aload_0
    //   623: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   626: aload 14
    //   628: getfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   631: aload 14
    //   633: invokevirtual 589	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   636: pop
    //   637: aload 14
    //   639: getfield 605	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   642: ifeq +124 -> 766
    //   645: aload 9
    //   647: aload 14
    //   649: getfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   652: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   655: ifne +57 -> 712
    //   658: aload 12
    //   660: aload 10
    //   662: aload 9
    //   664: invokevirtual 606	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   667: pop
    //   668: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq -407 -> 264
    //   674: ldc_w 280
    //   677: iconst_2
    //   678: ldc_w 608
    //   681: iconst_3
    //   682: anewarray 4	java/lang/Object
    //   685: dup
    //   686: iconst_0
    //   687: aload 14
    //   689: getfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   692: aastore
    //   693: dup
    //   694: iconst_1
    //   695: aload 9
    //   697: aastore
    //   698: dup
    //   699: iconst_2
    //   700: aload 10
    //   702: aastore
    //   703: invokestatic 292	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   706: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   709: goto -445 -> 264
    //   712: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   715: ifeq +40 -> 755
    //   718: aload 12
    //   720: aload 10
    //   722: invokevirtual 611	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   725: ifeq +30 -> 755
    //   728: ldc_w 280
    //   731: iconst_2
    //   732: ldc_w 613
    //   735: iconst_2
    //   736: anewarray 4	java/lang/Object
    //   739: dup
    //   740: iconst_0
    //   741: aload 9
    //   743: aastore
    //   744: dup
    //   745: iconst_1
    //   746: aload 10
    //   748: aastore
    //   749: invokestatic 292	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   752: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   755: aload 12
    //   757: aload 10
    //   759: invokevirtual 616	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   762: pop
    //   763: goto -499 -> 264
    //   766: aload_1
    //   767: new 599	SecurityAccountServer/AddressBookItem
    //   770: dup
    //   771: aload 10
    //   773: aload 9
    //   775: invokespecial 602	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   778: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   781: pop
    //   782: aload 11
    //   784: aload 14
    //   786: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   789: pop
    //   790: goto -526 -> 264
    //   793: aload 12
    //   795: invokevirtual 620	java/util/HashMap:keySet	()Ljava/util/Set;
    //   798: invokeinterface 626 1 0
    //   803: astore 9
    //   805: aload 9
    //   807: invokeinterface 631 1 0
    //   812: ifeq +176 -> 988
    //   815: aload 9
    //   817: invokeinterface 635 1 0
    //   822: checkcast 72	java/lang/String
    //   825: astore 10
    //   827: aload_0
    //   828: getfield 158	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   831: aload 10
    //   833: invokevirtual 550	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   836: checkcast 552	com/tencent/mobileqq/data/PhoneContact
    //   839: astore 13
    //   841: aload 13
    //   843: ifnull -38 -> 805
    //   846: aload 12
    //   848: aload 10
    //   850: invokevirtual 636	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   853: checkcast 72	java/lang/String
    //   856: astore 14
    //   858: aload_2
    //   859: new 599	SecurityAccountServer/AddressBookItem
    //   862: dup
    //   863: aload 10
    //   865: aload 13
    //   867: getfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   870: invokespecial 602	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   873: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   876: pop
    //   877: aload_1
    //   878: new 599	SecurityAccountServer/AddressBookItem
    //   881: dup
    //   882: aload 10
    //   884: aload 14
    //   886: invokespecial 602	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   892: pop
    //   893: aload 13
    //   895: aload 14
    //   897: putfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   900: aload 13
    //   902: aload 14
    //   904: iconst_1
    //   905: invokestatic 574	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   908: putfield 577	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   911: aload 13
    //   913: aload 14
    //   915: iconst_2
    //   916: invokestatic 574	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   919: putfield 580	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   922: aload 13
    //   924: aload 13
    //   926: getfield 580	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   929: invokestatic 582	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   932: putfield 585	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   935: aload_0
    //   936: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   939: aload 13
    //   941: getfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   944: aload 13
    //   946: invokevirtual 639	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   949: pop
    //   950: aload 13
    //   952: aload 14
    //   954: aload 10
    //   956: invokestatic 591	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   959: putfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   962: aload_0
    //   963: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   966: aload 13
    //   968: getfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   971: aload 13
    //   973: invokevirtual 589	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   976: pop
    //   977: aload 11
    //   979: aload 13
    //   981: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   984: pop
    //   985: goto -180 -> 805
    //   988: new 190	java/util/ArrayList
    //   991: dup
    //   992: invokespecial 191	java/util/ArrayList:<init>	()V
    //   995: astore 9
    //   997: aload_0
    //   998: getfield 158	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   1001: invokevirtual 642	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   1004: invokeinterface 626 1 0
    //   1009: astore 10
    //   1011: aload 10
    //   1013: invokeinterface 631 1 0
    //   1018: ifeq +105 -> 1123
    //   1021: aload 10
    //   1023: invokeinterface 635 1 0
    //   1028: checkcast 644	java/util/Map$Entry
    //   1031: invokeinterface 647 1 0
    //   1036: checkcast 552	com/tencent/mobileqq/data/PhoneContact
    //   1039: astore 12
    //   1041: aload 12
    //   1043: getfield 569	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   1046: lload 5
    //   1048: lcmp
    //   1049: ifeq -38 -> 1011
    //   1052: aload 12
    //   1054: getfield 650	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1057: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1060: ifne +16 -> 1076
    //   1063: aload_0
    //   1064: getfield 160	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   1067: aload 12
    //   1069: getfield 650	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1072: invokevirtual 651	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1075: pop
    //   1076: aload 10
    //   1078: invokeinterface 653 1 0
    //   1083: aload_0
    //   1084: getfield 318	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1087: aload 12
    //   1089: invokevirtual 656	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1092: pop
    //   1093: aload_2
    //   1094: new 599	SecurityAccountServer/AddressBookItem
    //   1097: dup
    //   1098: aload 12
    //   1100: getfield 554	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1103: aload 12
    //   1105: getfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1108: invokespecial 602	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1111: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1114: pop
    //   1115: aload 9
    //   1117: invokevirtual 659	java/util/ArrayList:clear	()V
    //   1120: goto -109 -> 1011
    //   1123: aload 7
    //   1125: invokevirtual 662	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1128: aload 7
    //   1130: ifnull +8 -> 1138
    //   1133: aload 7
    //   1135: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1138: aload 8
    //   1140: invokeinterface 536 1 0
    //   1145: goto -834 -> 311
    //   1148: astore 7
    //   1150: goto -839 -> 311
    //   1153: astore 7
    //   1155: goto -844 -> 311
    //   1158: astore_2
    //   1159: goto -578 -> 581
    //   1162: astore_1
    //   1163: aconst_null
    //   1164: astore 7
    //   1166: goto -602 -> 564
    //   1169: astore_1
    //   1170: goto -606 -> 564
    //   1173: astore 9
    //   1175: goto -898 -> 277
    //   1178: goto -983 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1181	0	this	PhoneContactManagerImp
    //   0	1181	1	paramArrayList1	ArrayList<AddressBookItem>
    //   0	1181	2	paramArrayList2	ArrayList<AddressBookItem>
    //   211	375	3	i1	int
    //   228	216	4	i2	int
    //   21	1026	5	l1	long
    //   43	257	7	localObject1	Object
    //   385	749	7	localThrowable	Throwable
    //   1148	1	7	localException1	Exception
    //   1153	1	7	localException2	Exception
    //   1164	1	7	localObject2	Object
    //   59	1080	8	localCursor	Cursor
    //   115	142	9	localObject3	Object
    //   275	499	9	localStaleDataException1	StaleDataException
    //   803	313	9	localObject4	Object
    //   1173	1	9	localStaleDataException2	StaleDataException
    //   163	914	10	localObject5	Object
    //   16	962	11	localArrayList	ArrayList
    //   7	1097	12	localObject6	Object
    //   246	734	13	localObject7	Object
    //   405	548	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   121	134	275	android/database/StaleDataException
    //   134	191	275	android/database/StaleDataException
    //   195	264	275	android/database/StaleDataException
    //   264	272	275	android/database/StaleDataException
    //   393	407	275	android/database/StaleDataException
    //   412	560	275	android/database/StaleDataException
    //   583	637	275	android/database/StaleDataException
    //   637	709	275	android/database/StaleDataException
    //   712	755	275	android/database/StaleDataException
    //   755	763	275	android/database/StaleDataException
    //   766	790	275	android/database/StaleDataException
    //   793	805	275	android/database/StaleDataException
    //   805	841	275	android/database/StaleDataException
    //   846	985	275	android/database/StaleDataException
    //   988	1011	275	android/database/StaleDataException
    //   1011	1076	275	android/database/StaleDataException
    //   1076	1120	275	android/database/StaleDataException
    //   1123	1128	275	android/database/StaleDataException
    //   45	61	385	java/lang/Throwable
    //   121	134	563	finally
    //   134	191	563	finally
    //   195	264	563	finally
    //   264	272	563	finally
    //   393	407	563	finally
    //   412	560	563	finally
    //   583	637	563	finally
    //   637	709	563	finally
    //   712	755	563	finally
    //   755	763	563	finally
    //   766	790	563	finally
    //   793	805	563	finally
    //   805	841	563	finally
    //   846	985	563	finally
    //   988	1011	563	finally
    //   1011	1076	563	finally
    //   1076	1120	563	finally
    //   1123	1128	563	finally
    //   1138	1145	1148	java/lang/Exception
    //   304	311	1153	java/lang/Exception
    //   574	581	1158	java/lang/Exception
    //   108	117	1162	finally
    //   277	294	1169	finally
    //   108	117	1173	android/database/StaleDataException
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    if ((paramInt & 0x1) != 0)
    {
      this.jdField_g_of_type_JavaUtilList = null;
      this.jdField_f_of_type_JavaUtilList = null;
      this.jdField_i_of_type_JavaUtilList = null;
      this.jdField_k_of_type_JavaUtilList = null;
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ContactListView.class);
      if (localMqqHandler != null)
      {
        localMqqHandler.removeMessages(1);
        localMqqHandler.sendEmptyMessageDelayed(1, 100L);
      }
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ContactsInnerFrame.class);
      if (localMqqHandler != null)
      {
        localMqqHandler.removeMessages(3);
        localMqqHandler.sendEmptyMessageDelayed(3, 100L);
      }
    }
    this.jdField_h_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.6(this, paramInt));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, String.format("saveUploadDataForNewGuide [%s, %s, %s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      }
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("state", paramInt1);
      if (paramInt2 > 0) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("total", paramInt2);
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("curPer", paramInt3);
      this.jdField_a_of_type_OrgJsonJSONObject.put("expPer", paramInt4);
      LoginUserGuideHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_OrgJsonJSONObject);
      if ((paramInt1 == 3) || (paramInt1 == 4))
      {
        this.jdField_m_of_type_Boolean = false;
        this.jdField_a_of_type_OrgJsonJSONObject = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("showToast [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_Int != 1) {
        if (!paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (String str = HardCodeUtil.a(2131707983); Thread.currentThread() == Looper.getMainLooper().getThread(); str = HardCodeUtil.a(2131707977))
    {
      a(paramBoolean, str);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.3(this, paramBoolean, str));
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("saveContactListTimeStamp, [%s,%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("queryContactTimeStamp", paramLong1).putLong("queryRichInfoTimeStamp", paramLong2).apply();
  }
  
  private void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    int i1 = this.jdField_a_of_type_Int;
    int i2 = a(paramRespondQueryQQBindingStat);
    switch (i2)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = i2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "syncBindState newState = " + i2 + " lastState=" + i1 + " curState=" + this.jdField_a_of_type_Int);
      }
      if (i1 != this.jdField_a_of_type_Int) {
        p();
      }
      return;
      if (this.jdField_a_of_type_Int != i2)
      {
        u();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_show_contact_banner", true).commit();
      }
      if ((i2 != 1) || (this.jdField_a_of_type_Int != 4))
      {
        this.jdField_a_of_type_Int = i2;
        continue;
        if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L) {
          u();
        }
        this.jdField_a_of_type_Int = i2;
        continue;
        if (this.jdField_a_of_type_Int != 8)
        {
          if (this.jdField_a_of_type_Int != i2) {
            u();
          }
          this.jdField_a_of_type_Int = i2;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("PhoneContact", 2, "cur state is uploading");
          continue;
          this.jdField_a_of_type_Int = i2;
          continue;
          this.jdField_a_of_type_Int = i2;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Resources paramResources, ImageView paramImageView)
  {
    if ((paramQQAppInterface == null) || (paramResources == null) || (paramImageView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("loadIconAsync [%s, %s, %s]", new Object[] { paramQQAppInterface, paramResources, paramImageView }));
      }
      return;
    }
    ThreadManager.excute(new PhoneContactManagerImp.23(paramResources, paramQQAppInterface, paramImageView), 16, null, true);
  }
  
  private void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramPhoneContact.uin))
    {
      if (!paramBoolean) {
        break label41;
      }
      paramPhoneContact.bindingDate = 0L;
      paramPhoneContact.isRecommend = 0;
      paramPhoneContact.uin = "";
      paramPhoneContact.originBinder = 0L;
      paramPhoneContact.ability = 0;
    }
    label41:
    while (!paramPhoneContact.uin.equals("0")) {
      return;
    }
    paramPhoneContact.netTypeIconId = 0;
    paramPhoneContact.detalStatusFlag = 20;
    paramPhoneContact.iTermType = 0;
    paramPhoneContact.strTermDesc = "";
    paramPhoneContact.eNetworkType = 0;
    paramPhoneContact.abilityBits = 0L;
  }
  
  private void a(ConcurrentHashMap<String, PhoneContact> paramConcurrentHashMap)
  {
    Object localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      PhoneContact localPhoneContact = (PhoneContact)((Map.Entry)localObject2).getValue();
      localObject2 = (PhoneContact)paramConcurrentHashMap.get(((Map.Entry)localObject2).getKey());
      if ((localObject2 != null) && (localPhoneContact != null))
      {
        ((PhoneContact)localObject2).uin = localPhoneContact.uin;
        ((PhoneContact)localObject2).nationCode = localPhoneContact.nationCode;
        ((PhoneContact)localObject2).mobileCode = localPhoneContact.mobileCode;
        ((PhoneContact)localObject2).bindingDate = localPhoneContact.bindingDate;
        ((PhoneContact)localObject2).nickName = localPhoneContact.nickName;
        ((PhoneContact)localObject2).isUploaded = localPhoneContact.isUploaded;
        ((PhoneContact)localObject2).originBinder = localPhoneContact.originBinder;
        ((PhoneContact)localObject2).ability = localPhoneContact.ability;
      }
    }
    localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    ((ConcurrentHashMap)localObject1).clear();
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 1)
    {
      QQToast.a(localBaseApplication, i1, paramString, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131299166));
      return;
    }
  }
  
  private void a(boolean paramBoolean, List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "notifyRecommendCountChanged|beAdded = " + paramBoolean + "|list.size = " + paramList.size());
    }
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    int i1 = paramList.size();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.11(this, paramBoolean, i1));
  }
  
  private boolean a(String paramString, ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    if ((paramString == null) || ((paramArrayList1 == null) && (paramArrayList2 == null)))
    {
      this.jdField_c_of_type_Boolean = false;
      return false;
    }
    int i2;
    label39:
    int i3;
    label47:
    NewIntent localNewIntent;
    if (QLog.isColorLevel())
    {
      if (paramArrayList1 == null)
      {
        i1 = 0;
        if (paramArrayList2 != null) {
          break label237;
        }
        i2 = 0;
        if (paramArrayList != null) {
          break label246;
        }
        i3 = 0;
        QLog.d("PhoneContact.Manager", 2, String.format("doUpdateContact bind:%s, add:%s, del:%s, rename:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) }));
      }
    }
    else
    {
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
      if (!paramBoolean) {
        break label256;
      }
    }
    label256:
    for (int i1 = 15;; i1 = 38)
    {
      localNewIntent.putExtra("req_type", i1);
      localNewIntent.putExtra("unique_phone_no", paramString);
      localNewIntent.putExtra("add_contact_list", paramArrayList1);
      localNewIntent.putExtra("del_contact_list", paramArrayList2);
      localNewIntent.putExtra("rename_contact_list", paramArrayList);
      localNewIntent.putExtra("next_flag", 0L);
      localNewIntent.putExtra("upload_package_no", 0);
      localNewIntent.putExtra("session_id", new byte[0]);
      localNewIntent.putExtra("is_resend", false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return true;
      i1 = paramArrayList1.size();
      break;
      label237:
      i2 = paramArrayList2.size();
      break label39;
      label246:
      i3 = paramArrayList.size();
      break label47;
    }
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        boolean bool = this.jdField_j_of_type_Boolean;
        if ((bool) || (localQQAppInterface == null))
        {
          paramBoolean1 = false;
          return paramBoolean1;
        }
        ((PhoneUnityManager)localQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).jdField_a_of_type_Boolean = true;
        long l1 = System.currentTimeMillis();
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder(200);
          ((StringBuilder)localObject2).append("doQueryContactList, from: ").append(paramLong);
          ((StringBuilder)localObject2).append(", isQueryingContact: ").append(this.jdField_b_of_type_Boolean);
          ((StringBuilder)localObject2).append(", isUpdatingContact: ").append(this.jdField_c_of_type_Boolean);
          ((StringBuilder)localObject2).append(", mCurrentBindState: ").append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(", beForce: ").append(paramBoolean1);
          ((StringBuilder)localObject2).append(", isQueryAll: ").append(paramBoolean2);
          ((StringBuilder)localObject2).append(", lastQueryTime: ").append(this.jdField_c_of_type_Long / 1000L);
          ((StringBuilder)localObject2).append(", currentTime: ").append(l1 / 1000L);
          ((StringBuilder)localObject2).append(", bindState: ").append(d());
          QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 8) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int != 4))
        {
          l1 = Math.abs(l1 - this.jdField_c_of_type_Long);
          if (((paramLong == 2L) || (paramLong == 23L)) && ((l1 < jdField_b_of_type_Long) || (!this.jdField_h_of_type_Boolean)))
          {
            if (!QLog.isColorLevel()) {
              break label658;
            }
            QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList foreground=%b [interval:%s, limit:%s]", new Object[] { Boolean.valueOf(this.jdField_h_of_type_Boolean), Long.valueOf(l1), Long.valueOf(jdField_b_of_type_Long) }));
            break label658;
          }
          if ((!paramBoolean1) && (l1 < jdField_a_of_type_Long))
          {
            if (!QLog.isColorLevel()) {
              break label663;
            }
            QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList [interval:%s, limit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(jdField_a_of_type_Long) }));
            break label663;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_c_of_type_JavaUtilList = null;
          this.jdField_d_of_type_JavaUtilList = null;
          localObject2 = new NewIntent(localQQAppInterface.getApplication(), ContactBindServlet.class);
          ((NewIntent)localObject2).putExtra("req_type", 30);
          ((NewIntent)localObject2).putExtra("next_flag", 0L);
          long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
          long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
          int i2 = c();
          ((NewIntent)localObject2).putExtra("time_stamp", l2);
          ((NewIntent)localObject2).putExtra("richinfo_time_stamp", l3);
          ((NewIntent)localObject2).putExtra("session_id", new byte[0]);
          ((NewIntent)localObject2).putExtra("unique_phone_no", a());
          if (paramBoolean2)
          {
            i1 = 1;
            ((NewIntent)localObject2).putExtra("force_query_list", i1);
            ((NewIntent)localObject2).putExtra("param_query_from", paramLong);
            ((NewIntent)localObject2).putExtra("param_bind_state", i2);
            localQQAppInterface.startServlet((NewIntent)localObject2);
            QLog.d("PhoneContact.Manager", 1, String.format("real doQueryContactList. [force, queryAll, from, interval] = [%b, %b, %d, %d]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong), Long.valueOf(l1) }));
            paramBoolean1 = true;
            continue;
          }
          int i1 = 2;
          continue;
        }
        paramBoolean1 = false;
      }
      finally {}
      continue;
      label658:
      paramBoolean1 = false;
      continue;
      label663:
      paramBoolean1 = false;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i2 = 0;
    int i3 = paramArrayOfByte.length - 1;
    while (i3 > i2 * 2)
    {
      int i1 = paramArrayOfByte[i2];
      paramArrayOfByte[i2] = paramArrayOfByte[(i3 - i2)];
      paramArrayOfByte[(i3 - i2)] = i1;
      i2 += 1;
    }
    return paramArrayOfByte;
  }
  
  private String b()
  {
    String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("contact_bind_info_unique", "");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("null|null"))) {
      return str;
    }
    str = c();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("contact_bind_info_unique", str);
    localEditor.commit();
    return str;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.10(this, paramInt));
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.12(this, paramLong));
  }
  
  private void b(boolean paramBoolean, List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact|listSize = ", Integer.valueOf(paramList.size()) });
    }
    EntityTransaction localEntityTransaction;
    for (;;)
    {
      PhoneContact localPhoneContact;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (paramList.size() <= 0) {
          break label398;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataContactBinded == null) || (paramList.size() > jdField_b_of_type_Int)) {
          break label445;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        localEntityTransaction.begin();
        try
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.size());
          }
          Iterator localIterator = paramList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localPhoneContact = (PhoneContact)localIterator.next();
          localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            ContactMatch localContactMatch = (ContactMatch)((Iterator)localObject2).next();
            if (!localContactMatch.mobileNo.equals(localPhoneContact.mobileNo)) {
              continue;
            }
            ((Iterator)localObject2).remove();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localContactMatch);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact remove uin=", localContactMatch.mobileNo });
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.end();
        }
      }
      Object localObject2 = new ContactMatch();
      ((ContactMatch)localObject2).mobileNo = localPhoneContact.mobileNo;
      ((ContactMatch)localObject2).unifiedCode = localPhoneContact.unifiedCode;
      ((ContactMatch)localObject2).name = localPhoneContact.name;
      ((ContactMatch)localObject2).timestamp = MessageCache.a();
      ((ContactMatch)localObject2).age = ((short)localPhoneContact.age);
      ((ContactMatch)localObject2).gender = ((short)localPhoneContact.sex);
      ((ContactMatch)localObject2).commonFriend = localPhoneContact.samFriend;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact new uin=", ((ContactMatch)localObject2).mobileNo });
      }
      a((Entity)localObject2);
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
    a(this.jdField_a_of_type_ComTencentMobileqqDataContactBinded);
    label398:
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = new ContactBinded();
        this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.isReaded = paramList.isEmpty();
        a(this.jdField_a_of_type_ComTencentMobileqqDataContactBinded);
      }
    }
    for (;;)
    {
      return;
      label445:
      if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = new ContactBinded();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.timestamp = MessageCache.a();
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.isReaded = false;
      break;
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = null;
    }
  }
  
  private boolean b(boolean paramBoolean)
  {
    boolean bool2 = false;
    int i1 = d();
    if (QLog.isColorLevel())
    {
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
      QLog.d("PhoneContact.Manager", 2, String.format("checkUpdateLocalContact [contactChanged, beFirstQuery, state]=[%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_g_of_type_Boolean), Boolean.valueOf(paramBoolean), localRespondQueryQQBindingStat }));
    }
    boolean bool1;
    if ((i1 != 8) && (f())) {
      bool1 = false | c();
    }
    label109:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              if (!d()) {
                break label109;
              }
              if (paramBoolean) {
                break;
              }
              bool1 = bool2;
            } while (!this.jdField_g_of_type_Boolean);
            return false | o();
            if ((i1 != 4) && (e())) {
              return false | j();
            }
            if (i1 != 1) {
              break;
            }
            bool1 = bool2;
          } while (!paramBoolean);
          bool1 = bool2;
        } while (!a().noBindUploadContacts);
        return false | a(true, true, 15L);
        bool1 = bool2;
      } while (i1 != 2);
      if (paramBoolean) {
        break;
      }
      bool1 = bool2;
    } while (!this.jdField_g_of_type_Boolean);
    return false | r();
  }
  
  private String c()
  {
    Object localObject1 = "";
    String str = QQDeviceInfo.getIMEI("73f9b3");
    if (!VersionUtils.k()) {
      localObject1 = QQDeviceInfo.getMAC("73f9b3");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).equals("02:00:00:00:00:00")) {
        break label118;
      }
    }
    try
    {
      localObject2 = Settings.Secure.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label57:
      label118:
      break label57;
    }
    QLog.i("PhoneContact", 1, String.format("fallback androidId:%s", new Object[] { localObject1 }));
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new Random();
      localObject2 = ((Random)localObject1).nextLong() + "";
    }
    return str + "|" + (String)localObject2;
  }
  
  private void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveContactListTimeStampNotBind" + paramLong);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("queryContactTimeStamp", paramLong).commit();
  }
  
  private void c(boolean paramBoolean)
  {
    List localList = c();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "pushRecommendUnreadCount: beAdded = " + paramBoolean + ", unreadCount = " + localList.size());
    }
    a(paramBoolean, localList);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
    }
  }
  
  private boolean c(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, String.format("showBindPhonePage isLogin return false", new Object[0]));
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("showBindPhonePage fromNotBind=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    boolean bool3 = q();
    boolean bool1 = p();
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = Math.abs(l1 - this.jdField_h_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("showBindPhonePage [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(this.jdField_h_of_type_Long) }));
    }
    if (((BaseActivity.sTopActivity instanceof BindNumberActivity)) || ((BaseActivity.sTopActivity instanceof BindVerifyActivity)))
    {
      QLog.d("PhoneContact.Manager", 2, "showBindPhonePage " + BaseActivity.sTopActivity);
      return false;
    }
    for (;;)
    {
      int i1;
      boolean bool2;
      try
      {
        i1 = d();
        localObject3 = null;
        if (!paramBoolean) {
          break label747;
        }
        localObject1 = localObject3;
        bool2 = bool1;
        if (i1 != 3) {
          break label734;
        }
        localObject1 = localObject3;
        bool2 = bool1;
        if (a() == null) {
          break label734;
        }
        localObject1 = localObject3;
        bool2 = bool1;
        if (a().lastUsedFlag != 3L) {
          break label734;
        }
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), PhoneMatchActivity.class);
        ((Intent)localObject1).putExtra("kSrouce", 16);
        bool2 = false;
      }
      catch (Exception localException)
      {
        Object localObject3;
        Object localObject1;
        String str2;
        String str1;
        QLog.e("PhoneContact.Manager", 1, "showBindPhonePage fail.", localException);
      }
      if (localObject1 != null)
      {
        if (l2 < 3600000L)
        {
          if (!QLog.isColorLevel()) {
            break label745;
          }
          QLog.i("PhoneContact.Manager", 2, String.format("showBindPhonePage just last unbind mobile [%s, %s, %s]", new Object[] { Long.valueOf(l1), Long.valueOf(this.jdField_h_of_type_Long), Long.valueOf(3600000L) }));
          break label745;
          if ((a() == null) || (a().lastUsedFlag != 3L)) {
            break label792;
          }
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), PhoneMatchActivity.class);
          continue;
          localObject1 = a();
          if ((f()) || (localObject1 == null) || (((RespondQueryQQBindingStat)localObject1).isStopFindMatch)) {
            break label792;
          }
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), PhoneMatchActivity.class);
          if (!bool3) {
            break label725;
          }
          ((Intent)localObject1).putExtra("key_from_contact_first", true);
          continue;
        }
        str2 = ((Intent)localObject1).getComponent().getClassName();
        str1 = "";
        localObject3 = str1;
        if (!TextUtils.isEmpty(str2))
        {
          if (str2.equals(BindNumberActivity.class.getName())) {
            localObject3 = "0X80095EB";
          }
        }
        else
        {
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject3, (String)localObject3, 0, 0, "", "", "", "");
          }
          localObject3 = BaseActivity.sTopActivity;
          if ((localObject3 == null) || (((AppActivity)localObject3).isFinishing()) || (((AppActivity)localObject3).getAppRuntime() != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label706;
          }
          ((AppActivity)localObject3).startActivity((Intent)localObject1);
          ((AppActivity)localObject3).overridePendingTransition(2130772314, 2130771992);
          if ((!paramBoolean) || (!bool1)) {
            continue;
          }
          s();
          break;
        }
        localObject3 = str1;
        if (!str2.equals(PhoneMatchActivity.class.getName())) {
          continue;
        }
        localObject3 = "0X80095EA";
        continue;
        if ((paramBoolean) || (!bool3)) {
          break label677;
        }
        t();
        break;
      }
      for (;;)
      {
        return false;
        label677:
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_pop_time_for_switchphone", System.currentTimeMillis()).commit();
        break;
        label706:
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "showBindPhonePage topActivity invalid");
        }
      }
      label725:
      continue;
      label734:
      while (!bool2)
      {
        bool1 = bool2;
        break;
      }
      bool1 = bool2;
      continue;
      label745:
      return false;
      label747:
      switch (i1)
      {
      }
      label792:
      do
      {
        localObject2 = null;
        break;
      } while (!bool3);
      Object localObject2 = null;
    }
    return true;
  }
  
  /* Error */
  private ArrayList<AddressBookItem> d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokespecial 1311	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:o	()V
    //   10: ldc_w 280
    //   13: iconst_1
    //   14: ldc_w 1313
    //   17: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: aload_0
    //   21: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   27: invokevirtual 468	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 474	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   33: getstatic 84	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 480	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore 7
    //   44: new 190	java/util/ArrayList
    //   47: dup
    //   48: invokespecial 191	java/util/ArrayList:<init>	()V
    //   51: astore 12
    //   53: aload 7
    //   55: ifnull +779 -> 834
    //   58: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   61: lstore_3
    //   62: aload 7
    //   64: invokeinterface 488 1 0
    //   69: istore_1
    //   70: aload 12
    //   72: iload_1
    //   73: invokevirtual 1316	java/util/ArrayList:ensureCapacity	(I)V
    //   76: new 117	java/util/concurrent/ConcurrentHashMap
    //   79: dup
    //   80: iload_1
    //   81: invokespecial 1317	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   84: astore 13
    //   86: aload 8
    //   88: astore 6
    //   90: aload 9
    //   92: astore 5
    //   94: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +38 -> 135
    //   100: aload 8
    //   102: astore 6
    //   104: aload 9
    //   106: astore 5
    //   108: ldc_w 280
    //   111: iconst_2
    //   112: new 226	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 1319
    //   122: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload_1
    //   126: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload 8
    //   137: astore 6
    //   139: aload 9
    //   141: astore 5
    //   143: aload_0
    //   144: getfield 318	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: invokevirtual 497	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   150: astore 8
    //   152: aload 8
    //   154: astore 6
    //   156: aload 8
    //   158: astore 5
    //   160: aload 8
    //   162: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   165: aload 8
    //   167: astore 6
    //   169: aload 8
    //   171: astore 5
    //   173: aload 7
    //   175: invokeinterface 505 1 0
    //   180: pop
    //   181: aload 8
    //   183: astore 6
    //   185: aload 8
    //   187: astore 5
    //   189: aload 7
    //   191: invokeinterface 508 1 0
    //   196: ifne +600 -> 796
    //   199: aload 8
    //   201: astore 6
    //   203: aload 8
    //   205: astore 5
    //   207: aload 7
    //   209: aload 7
    //   211: ldc 74
    //   213: invokeinterface 512 2 0
    //   218: invokeinterface 515 2 0
    //   223: invokestatic 520	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 10
    //   228: aload 8
    //   230: astore 6
    //   232: aload 8
    //   234: astore 5
    //   236: aload 7
    //   238: aload 7
    //   240: ldc 76
    //   242: invokeinterface 512 2 0
    //   247: invokeinterface 515 2 0
    //   252: astore 11
    //   254: aload 11
    //   256: astore 9
    //   258: aload 8
    //   260: astore 6
    //   262: aload 8
    //   264: astore 5
    //   266: aload 11
    //   268: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   271: ifeq +7 -> 278
    //   274: aload 10
    //   276: astore 9
    //   278: aload 8
    //   280: astore 6
    //   282: aload 8
    //   284: astore 5
    //   286: aload 7
    //   288: aload 7
    //   290: ldc 78
    //   292: invokeinterface 512 2 0
    //   297: invokeinterface 524 2 0
    //   302: istore_1
    //   303: aload 8
    //   305: astore 6
    //   307: aload 8
    //   309: astore 5
    //   311: aload 7
    //   313: aload 7
    //   315: ldc 80
    //   317: invokeinterface 512 2 0
    //   322: invokeinterface 524 2 0
    //   327: istore_2
    //   328: aload 8
    //   330: astore 6
    //   332: aload 8
    //   334: astore 5
    //   336: aload 7
    //   338: aload 7
    //   340: ldc 82
    //   342: invokeinterface 512 2 0
    //   347: invokeinterface 515 2 0
    //   352: astore 11
    //   354: aload 8
    //   356: astore 6
    //   358: aload 8
    //   360: astore 5
    //   362: aload 10
    //   364: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   367: ifne +19 -> 386
    //   370: aload 8
    //   372: astore 6
    //   374: aload 8
    //   376: astore 5
    //   378: aload 9
    //   380: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   383: ifeq +147 -> 530
    //   386: aload 8
    //   388: astore 6
    //   390: aload 8
    //   392: astore 5
    //   394: aload 7
    //   396: invokeinterface 527 1 0
    //   401: pop
    //   402: goto -221 -> 181
    //   405: astore 8
    //   407: aload 6
    //   409: astore 5
    //   411: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +18 -> 432
    //   417: aload 6
    //   419: astore 5
    //   421: ldc_w 280
    //   424: iconst_2
    //   425: ldc 250
    //   427: aload 8
    //   429: invokestatic 530	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   432: aload 6
    //   434: ifnull +8 -> 442
    //   437: aload 6
    //   439: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   442: aload 7
    //   444: invokeinterface 536 1 0
    //   449: aload_0
    //   450: aload 13
    //   452: invokespecial 1321	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   455: aload_0
    //   456: getfield 158	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   459: invokevirtual 1325	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   462: invokeinterface 1328 1 0
    //   467: astore 5
    //   469: aload 5
    //   471: invokeinterface 631 1 0
    //   476: ifeq +358 -> 834
    //   479: aload 5
    //   481: invokeinterface 635 1 0
    //   486: checkcast 552	com/tencent/mobileqq/data/PhoneContact
    //   489: astore 6
    //   491: aload 12
    //   493: new 599	SecurityAccountServer/AddressBookItem
    //   496: dup
    //   497: aload 6
    //   499: getfield 554	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   502: aload 6
    //   504: getfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   507: invokespecial 602	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: invokevirtual 597	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   513: pop
    //   514: goto -45 -> 469
    //   517: astore 5
    //   519: aload 5
    //   521: invokevirtual 1329	java/lang/Exception:printStackTrace	()V
    //   524: aconst_null
    //   525: astore 7
    //   527: goto -483 -> 44
    //   530: aload 8
    //   532: astore 6
    //   534: aload 8
    //   536: astore 5
    //   538: new 552	com/tencent/mobileqq/data/PhoneContact
    //   541: dup
    //   542: invokespecial 553	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   545: astore 14
    //   547: aload 8
    //   549: astore 6
    //   551: aload 8
    //   553: astore 5
    //   555: aload 14
    //   557: aload 10
    //   559: putfield 554	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   562: aload 8
    //   564: astore 6
    //   566: aload 8
    //   568: astore 5
    //   570: aload 14
    //   572: aload 9
    //   574: putfield 557	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   577: aload 8
    //   579: astore 6
    //   581: aload 8
    //   583: astore 5
    //   585: aload 14
    //   587: iload_1
    //   588: putfield 560	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   591: aload 8
    //   593: astore 6
    //   595: aload 8
    //   597: astore 5
    //   599: aload 14
    //   601: iload_2
    //   602: putfield 563	com/tencent/mobileqq/data/PhoneContact:type	I
    //   605: aload 8
    //   607: astore 6
    //   609: aload 8
    //   611: astore 5
    //   613: aload 14
    //   615: aload 11
    //   617: putfield 566	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   620: aload 8
    //   622: astore 6
    //   624: aload 8
    //   626: astore 5
    //   628: aload 14
    //   630: lload_3
    //   631: putfield 569	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   634: aload 8
    //   636: astore 6
    //   638: aload 8
    //   640: astore 5
    //   642: aload 14
    //   644: aload 9
    //   646: iconst_1
    //   647: invokestatic 574	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   650: putfield 577	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   653: aload 8
    //   655: astore 6
    //   657: aload 8
    //   659: astore 5
    //   661: aload 14
    //   663: aload 9
    //   665: iconst_2
    //   666: invokestatic 574	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   669: putfield 580	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   672: aload 8
    //   674: astore 6
    //   676: aload 8
    //   678: astore 5
    //   680: aload 14
    //   682: aload 14
    //   684: getfield 580	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   687: invokestatic 582	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   690: putfield 585	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   693: aload 8
    //   695: astore 6
    //   697: aload 8
    //   699: astore 5
    //   701: aload 14
    //   703: aload 9
    //   705: aload 10
    //   707: invokestatic 591	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   710: putfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   713: aload 8
    //   715: astore 6
    //   717: aload 8
    //   719: astore 5
    //   721: aload 13
    //   723: aload 10
    //   725: aload 14
    //   727: invokevirtual 589	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   730: pop
    //   731: aload 8
    //   733: astore 6
    //   735: aload 8
    //   737: astore 5
    //   739: aload_0
    //   740: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   743: aload 14
    //   745: getfield 594	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   748: aload 14
    //   750: invokevirtual 589	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   753: pop
    //   754: aload 8
    //   756: astore 6
    //   758: aload 8
    //   760: astore 5
    //   762: aload_0
    //   763: getfield 318	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   766: aload 14
    //   768: invokevirtual 1333	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   771: goto -385 -> 386
    //   774: astore 6
    //   776: aload 5
    //   778: ifnull +8 -> 786
    //   781: aload 5
    //   783: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   786: aload 7
    //   788: invokeinterface 536 1 0
    //   793: aload 6
    //   795: athrow
    //   796: aload 8
    //   798: astore 6
    //   800: aload 8
    //   802: astore 5
    //   804: aload 8
    //   806: invokevirtual 662	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   809: aload 8
    //   811: ifnull +8 -> 819
    //   814: aload 8
    //   816: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   819: aload 7
    //   821: invokeinterface 536 1 0
    //   826: goto -377 -> 449
    //   829: astore 5
    //   831: goto -382 -> 449
    //   834: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +34 -> 871
    //   840: ldc_w 280
    //   843: iconst_2
    //   844: new 226	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 1335
    //   854: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 12
    //   859: invokevirtual 541	java/util/ArrayList:size	()I
    //   862: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   865: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: aload_0
    //   872: iconst_1
    //   873: putfield 1337	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   876: aload 12
    //   878: areturn
    //   879: astore 5
    //   881: goto -432 -> 449
    //   884: astore 5
    //   886: goto -93 -> 793
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	889	0	this	PhoneContactManagerImp
    //   69	519	1	i1	int
    //   327	275	2	i2	int
    //   61	570	3	l1	long
    //   92	388	5	localObject1	Object
    //   517	3	5	localException1	Exception
    //   536	267	5	localStaleDataException1	StaleDataException
    //   829	1	5	localException2	Exception
    //   879	1	5	localException3	Exception
    //   884	1	5	localException4	Exception
    //   88	669	6	localObject2	Object
    //   774	20	6	localObject3	Object
    //   798	1	6	localStaleDataException2	StaleDataException
    //   42	778	7	localCursor	Cursor
    //   4	387	8	localEntityTransaction	EntityTransaction
    //   405	410	8	localStaleDataException3	StaleDataException
    //   1	703	9	localObject4	Object
    //   226	498	10	str1	String
    //   252	364	11	str2	String
    //   51	826	12	localArrayList	ArrayList
    //   84	638	13	localConcurrentHashMap	ConcurrentHashMap
    //   545	222	14	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   94	100	405	android/database/StaleDataException
    //   108	135	405	android/database/StaleDataException
    //   143	152	405	android/database/StaleDataException
    //   160	165	405	android/database/StaleDataException
    //   173	181	405	android/database/StaleDataException
    //   189	199	405	android/database/StaleDataException
    //   207	228	405	android/database/StaleDataException
    //   236	254	405	android/database/StaleDataException
    //   266	274	405	android/database/StaleDataException
    //   286	303	405	android/database/StaleDataException
    //   311	328	405	android/database/StaleDataException
    //   336	354	405	android/database/StaleDataException
    //   362	370	405	android/database/StaleDataException
    //   378	386	405	android/database/StaleDataException
    //   394	402	405	android/database/StaleDataException
    //   538	547	405	android/database/StaleDataException
    //   555	562	405	android/database/StaleDataException
    //   570	577	405	android/database/StaleDataException
    //   585	591	405	android/database/StaleDataException
    //   599	605	405	android/database/StaleDataException
    //   613	620	405	android/database/StaleDataException
    //   628	634	405	android/database/StaleDataException
    //   642	653	405	android/database/StaleDataException
    //   661	672	405	android/database/StaleDataException
    //   680	693	405	android/database/StaleDataException
    //   701	713	405	android/database/StaleDataException
    //   721	731	405	android/database/StaleDataException
    //   739	754	405	android/database/StaleDataException
    //   762	771	405	android/database/StaleDataException
    //   804	809	405	android/database/StaleDataException
    //   20	44	517	java/lang/Exception
    //   94	100	774	finally
    //   108	135	774	finally
    //   143	152	774	finally
    //   160	165	774	finally
    //   173	181	774	finally
    //   189	199	774	finally
    //   207	228	774	finally
    //   236	254	774	finally
    //   266	274	774	finally
    //   286	303	774	finally
    //   311	328	774	finally
    //   336	354	774	finally
    //   362	370	774	finally
    //   378	386	774	finally
    //   394	402	774	finally
    //   411	417	774	finally
    //   421	432	774	finally
    //   538	547	774	finally
    //   555	562	774	finally
    //   570	577	774	finally
    //   585	591	774	finally
    //   599	605	774	finally
    //   613	620	774	finally
    //   628	634	774	finally
    //   642	653	774	finally
    //   661	672	774	finally
    //   680	693	774	finally
    //   701	713	774	finally
    //   721	731	774	finally
    //   739	754	774	finally
    //   762	771	774	finally
    //   804	809	774	finally
    //   819	826	829	java/lang/Exception
    //   442	449	879	java/lang/Exception
    //   786	793	884	java/lang/Exception
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap);
  }
  
  private void e(List<String> paramList)
  {
    try
    {
      HashSet localHashSet = new HashSet(this.jdField_a_of_type_JavaUtilSet.size() + paramList.size());
      localHashSet.addAll(this.jdField_a_of_type_JavaUtilSet);
      localHashSet.addAll(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "addContactsToLastLogin, mLastLoginSet.size=" + this.jdField_a_of_type_JavaUtilSet.size() + ", tempSet.size=" + localHashSet.size());
      }
      this.jdField_a_of_type_JavaUtilSet = localHashSet;
      a(this.jdField_a_of_type_JavaUtilSet);
      return;
    }
    catch (OutOfMemoryError paramList)
    {
      QLog.e("PhoneContactManagerImp", 1, "addContactsToLastLoginList oom", paramList);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      if (!this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
      {
        EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        try
        {
          localEntityTransaction.begin();
          Iterator localIterator = this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
          while (localIterator.hasNext())
          {
            PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
            a(localPhoneContact, paramBoolean);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(localPhoneContact);
          }
          this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        }
        finally
        {
          localEntityTransaction.end();
        }
        localEntityTransaction.commit();
        localEntityTransaction.end();
      }
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("queryShowBindPhonePage fromNotBind=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      this.n = paramBoolean;
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindHandler = ((ContactBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER));
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80095EE", "0X80095EE", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneContact.Manager", 1, "queryShowBindPhonePage fail.", localException);
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("setShowBindPhonePageResult success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindHandler = ((ContactBindHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER));
      }
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneContact.Manager", 1, "setShowBindPhonePageResult fail.", localException);
    }
  }
  
  private List<PhoneContact> h()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if ("0".equals(localPhoneContact.uin)) {
        localArrayList.add(localPhoneContact);
      }
    }
    return localArrayList;
  }
  
  private List<PhoneContact> i()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if (!TextUtils.isEmpty(localPhoneContact.uin)) {
        localArrayList.add(localPhoneContact);
      }
    }
    return localArrayList;
  }
  
  private void l()
  {
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new PhoneContactManagerImp.4(this));
  }
  
  private void m()
  {
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (localObject2 != null) {
      localObject1 = ((EntityManager)localObject2).query(LastLoginPhoneInfo.class);
    }
    if (localObject1 == null) {
      localObject1 = new ArrayList(0);
    }
    for (;;)
    {
      localObject2 = new HashSet(((List)localObject1).size());
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        LastLoginPhoneInfo localLastLoginPhoneInfo = (LastLoginPhoneInfo)localIterator.next();
        if (!TextUtils.isEmpty(localLastLoginPhoneInfo.unifiedCode)) {
          ((Set)localObject2).add(localLastLoginPhoneInfo.unifiedCode);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, "initLastLoginList, load for db,size=" + ((List)localObject1).size() + ", tempSet.size=" + ((Set)localObject2).size());
      }
      this.jdField_a_of_type_JavaUtilSet = ((Set)localObject2);
      return;
    }
  }
  
  private void n()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$MyContentObserver = new PhoneContactManagerImp.MyContentObserver(new Handler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getMainLooper()));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$MyContentObserver.a(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$MyContentObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "preLoadLocalContact");
    }
    a(0L, 0L);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase().delete(new PhoneContact().getTableName(), null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private boolean o()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +77 -> 84
    //   10: new 226	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 992	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 1460
    //   24: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 111	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   31: invokevirtual 911	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: ldc_w 1462
    //   39: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   46: invokevirtual 911	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: ldc_w 1464
    //   54: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   60: aload_0
    //   61: getfield 113	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   64: lsub
    //   65: ldc2_w 1010
    //   68: ldiv
    //   69: invokevirtual 997	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc_w 280
    //   76: iconst_2
    //   77: aload_3
    //   78: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: iload_2
    //   85: istore_1
    //   86: aload_0
    //   87: getfield 111	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   90: ifne +14 -> 104
    //   93: aload_0
    //   94: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   97: istore_1
    //   98: iload_1
    //   99: ifeq +9 -> 108
    //   102: iload_2
    //   103: istore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: iload_1
    //   107: ireturn
    //   108: iload_2
    //   109: istore_1
    //   110: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   113: aload_0
    //   114: getfield 113	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   117: lsub
    //   118: ldc2_w 63
    //   121: lcmp
    //   122: iflt -18 -> 104
    //   125: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +13 -> 141
    //   131: ldc_w 280
    //   134: iconst_2
    //   135: ldc_w 1466
    //   138: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: new 190	java/util/ArrayList
    //   144: dup
    //   145: invokespecial 191	java/util/ArrayList:<init>	()V
    //   148: astore_3
    //   149: new 190	java/util/ArrayList
    //   152: dup
    //   153: invokespecial 191	java/util/ArrayList:<init>	()V
    //   156: astore 4
    //   158: aload_0
    //   159: aload_3
    //   160: aload 4
    //   162: invokespecial 1468	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   165: astore 5
    //   167: aload_3
    //   168: invokevirtual 1469	java/util/ArrayList:isEmpty	()Z
    //   171: ifeq +13 -> 184
    //   174: iload_2
    //   175: istore_1
    //   176: aload 4
    //   178: invokevirtual 1469	java/util/ArrayList:isEmpty	()Z
    //   181: ifne -77 -> 104
    //   184: aload_0
    //   185: aload_0
    //   186: aload_0
    //   187: invokevirtual 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   190: aload_3
    //   191: aload 4
    //   193: aload 5
    //   195: iconst_1
    //   196: invokespecial 1471	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   199: putfield 111	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   202: aload_0
    //   203: iconst_1
    //   204: invokespecial 811	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(I)V
    //   207: iconst_1
    //   208: istore_1
    //   209: goto -105 -> 104
    //   212: astore_3
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_3
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	PhoneContactManagerImp
    //   85	124	1	bool1	boolean
    //   1	174	2	bool2	boolean
    //   19	172	3	localObject1	Object
    //   212	4	3	localObject2	Object
    //   156	36	4	localArrayList1	ArrayList
    //   165	29	5	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   4	84	212	finally
    //   86	98	212	finally
    //   110	141	212	finally
    //   141	174	212	finally
    //   176	184	212	finally
    //   184	207	212	finally
  }
  
  private void p()
  {
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.9(this));
  }
  
  private boolean p()
  {
    if (!"8.5.5".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped_notbind", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "poppedForThisVersionNotBind result = " + bool);
      }
      return bool;
    }
  }
  
  private void q()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_Int >= 9) && (b() == 1))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = null;
          }
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
          EntityTransaction localEntityTransaction1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
          try
          {
            localEntityTransaction1.begin();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase().delete(new ContactMatch().getTableName(), null, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase().delete(new ContactBinded().getTableName(), null, null);
            localEntityTransaction1.commit();
            localEntityTransaction1.end();
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend with BannerShow");
            }
            return;
          }
          finally
          {
            localObject3 = finally;
            localEntityTransaction1.end();
            throw localObject3;
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        EntityTransaction localEntityTransaction2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        ContactMatch localContactMatch;
        try
        {
          localEntityTransaction2.begin();
          Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator1.hasNext())
          {
            localContactMatch = (ContactMatch)localIterator1.next();
            PhoneContact localPhoneContact = b(localContactMatch.mobileNo);
            if ((localPhoneContact == null) || ((localPhoneContact.uin != null) && (!localPhoneContact.uin.equals("0"))) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= jdField_b_of_type_Int))
            {
              localIterator1.remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localContactMatch);
              if (QLog.isColorLevel()) {
                QLog.d("PhoneContact.Manager", 2, new Object[] { "removeIllegalRecommend remove ContactMatch = ", localContactMatch.mobileNo });
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label396;
          }
        }
        finally
        {
          localEntityTransaction2.end();
        }
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator2.hasNext())
        {
          localContactMatch = (ContactMatch)localIterator2.next();
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend|mobileNo : " + localContactMatch.mobileNo + "|size : " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        label396:
        localEntityTransaction2.commit();
        localEntityTransaction2.end();
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend mContactMatchsize = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
      }
    }
  }
  
  private boolean q()
  {
    if (!"8.5.5".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "isPhoneContactFirstRun result = " + bool);
      }
      return bool;
    }
  }
  
  private void r()
  {
    try
    {
      jdField_a_of_type_Long = this.jdField_b_of_type_AndroidContentSharedPreferences.getLong("query_contact_list_min_interval", jdField_a_of_type_Long);
      jdField_b_of_type_Long = this.jdField_b_of_type_AndroidContentSharedPreferences.getLong("query_contact_list_min_interval_for_login", jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("initQueryInterval  [limit:%s limitLogin:%s]", new Object[] { Long.valueOf(jdField_a_of_type_Long), Long.valueOf(jdField_b_of_type_Long) }));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, localThrowable.getMessage());
        }
      }
    }
  }
  
  /* Error */
  private boolean r()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +77 -> 84
    //   10: new 226	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 992	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 1460
    //   24: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 111	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   31: invokevirtual 911	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: ldc_w 1462
    //   39: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   46: invokevirtual 911	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: ldc_w 1464
    //   54: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   60: aload_0
    //   61: getfield 113	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   64: lsub
    //   65: ldc2_w 1010
    //   68: ldiv
    //   69: invokevirtual 997	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc_w 280
    //   76: iconst_2
    //   77: aload_3
    //   78: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: iload_2
    //   85: istore_1
    //   86: aload_0
    //   87: getfield 111	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   90: ifne +14 -> 104
    //   93: aload_0
    //   94: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   97: istore_1
    //   98: iload_1
    //   99: ifeq +9 -> 108
    //   102: iload_2
    //   103: istore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: iload_1
    //   107: ireturn
    //   108: iload_2
    //   109: istore_1
    //   110: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   113: aload_0
    //   114: getfield 113	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   117: lsub
    //   118: ldc2_w 63
    //   121: lcmp
    //   122: iflt -18 -> 104
    //   125: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +13 -> 141
    //   131: ldc_w 280
    //   134: iconst_2
    //   135: ldc_w 1509
    //   138: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: new 190	java/util/ArrayList
    //   144: dup
    //   145: invokespecial 191	java/util/ArrayList:<init>	()V
    //   148: astore_3
    //   149: new 190	java/util/ArrayList
    //   152: dup
    //   153: invokespecial 191	java/util/ArrayList:<init>	()V
    //   156: astore 4
    //   158: aload_0
    //   159: aload_3
    //   160: aload 4
    //   162: invokespecial 1468	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   165: astore 5
    //   167: aload_3
    //   168: invokevirtual 1469	java/util/ArrayList:isEmpty	()Z
    //   171: ifeq +13 -> 184
    //   174: iload_2
    //   175: istore_1
    //   176: aload 4
    //   178: invokevirtual 1469	java/util/ArrayList:isEmpty	()Z
    //   181: ifne -77 -> 104
    //   184: aload_0
    //   185: aload_0
    //   186: aload_0
    //   187: invokevirtual 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   190: aload_3
    //   191: aload 4
    //   193: aload 5
    //   195: iconst_0
    //   196: invokespecial 1471	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   199: putfield 111	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   202: aload_0
    //   203: iconst_1
    //   204: invokespecial 811	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(I)V
    //   207: iconst_1
    //   208: istore_1
    //   209: goto -105 -> 104
    //   212: astore_3
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_3
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	PhoneContactManagerImp
    //   85	124	1	bool1	boolean
    //   1	174	2	bool2	boolean
    //   19	172	3	localObject1	Object
    //   212	4	3	localObject2	Object
    //   156	36	4	localArrayList1	ArrayList
    //   165	29	5	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   4	84	212	finally
    //   86	98	212	finally
    //   110	141	212	finally
    //   141	174	212	finally
    //   176	184	212	finally
    //   184	207	212	finally
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped_notbind", "8.5.5").commit();
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped", "8.5.5").commit();
  }
  
  private void u()
  {
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteLocalData");
    }
    this.jdField_d_of_type_Boolean = false;
    a(0L, 0L);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a(1);
    c(false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = null;
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    }
  }
  
  public int a()
  {
    return c().size();
  }
  
  public int a(List<String> paramList)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if (localRespondQueryQQBindingStat == null) {
      return jdField_e_of_type_Int;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$LoadContactFriendListTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$LoadContactFriendListTask.cancel(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$LoadContactFriendListTask = new PhoneContactManagerImp.LoadContactFriendListTask(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$LoadContactFriendListTask.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$LoadContactFriendListTask.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
    return jdField_d_of_type_Int;
  }
  
  public int a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, ArrayList<NotBindContactFriendInfo> paramArrayList, ArrayList<NotBindContactNotFriendInfo> paramArrayList1)
  {
    if (this.jdField_j_of_type_Boolean) {
      return 0;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(80);
      ((StringBuilder)localObject1).append("saveContactFromServerNotBind, isSegmented = ").append(paramBoolean);
      ((StringBuilder)localObject1).append(", packageNo = ").append(paramInt);
      ((StringBuilder)localObject1).append(", nextFlag = ").append(paramLong1);
      QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_m_of_type_JavaUtilList == null)
    {
      this.jdField_m_of_type_JavaUtilList = paramArrayList;
      if (this.jdField_l_of_type_JavaUtilList != null) {
        break label132;
      }
      this.jdField_l_of_type_JavaUtilList = paramArrayList1;
    }
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean)) {
        break label147;
      }
      return 0;
      this.jdField_m_of_type_JavaUtilList.addAll(paramArrayList);
      break;
      label132:
      this.jdField_l_of_type_JavaUtilList.addAll(paramArrayList1);
    }
    label147:
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
    int i1;
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder(200);
      paramArrayList.append("saveContactFromServer, localTimeStamp:");
      paramArrayList.append(l1).append(", ").append(l2);
      paramArrayList.append(", remoteTimeStamp: ").append(paramLong2);
      paramArrayList1 = paramArrayList.append(", friendCount:");
      if (this.jdField_m_of_type_JavaUtilList != null)
      {
        i1 = this.jdField_m_of_type_JavaUtilList.size();
        paramArrayList1.append(i1);
        paramArrayList1 = paramArrayList.append(", strangerCount:");
        if (this.jdField_l_of_type_JavaUtilList == null) {
          break label722;
        }
        i1 = this.jdField_l_of_type_JavaUtilList.size();
        label301:
        paramArrayList1.append(i1);
        QLog.d("PhoneContact.Manager", 2, paramArrayList.toString());
      }
    }
    else
    {
      if (!this.jdField_d_of_type_Boolean) {
        e();
      }
      if (((paramInt == 0) && (paramBoolean)) || (!paramBoolean)) {
        d(true);
      }
      if ((this.jdField_m_of_type_JavaUtilList == null) || (this.jdField_m_of_type_JavaUtilList.size() <= 0)) {
        break label1372;
      }
      paramArrayList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    }
    Object localObject2;
    Object localObject3;
    boolean bool1;
    for (;;)
    {
      try
      {
        paramArrayList1.begin();
        localObject2 = this.jdField_m_of_type_JavaUtilList.iterator();
        paramBoolean = false;
        if (!((Iterator)localObject2).hasNext()) {
          break label784;
        }
        localObject3 = (NotBindContactFriendInfo)((Iterator)localObject2).next();
        paramArrayList = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramArrayList == null) {
          break label728;
        }
        bool1 = true;
        a(paramArrayList, true);
        paramArrayList.uin = String.valueOf(((NotBindContactFriendInfo)localObject3).bindUin);
        paramArrayList.isUploaded = true;
        paramArrayList.unifiedCode = a(((NotBindContactFriendInfo)localObject3).MobileNoMask, paramArrayList.mobileNo);
        paramArrayList.mobileCode = paramArrayList.unifiedCode;
        paramArrayList.nationCode = "";
        if ((!TextUtils.isEmpty(paramArrayList.uin)) && (!paramArrayList.uin.equals("0")))
        {
          localObject3 = ((FriendsManager)localObject1).e(paramArrayList.uin);
          if (localObject3 != null) {
            paramArrayList.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayList.uin, paramArrayList);
          ((FriendsManager)localObject1).a(paramArrayList.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramArrayList.unifiedCode)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayList.unifiedCode, paramArrayList);
        }
        this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramArrayList.mobileNo);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramArrayList);
        paramBoolean = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramArrayList != null) {
          break label774;
        }
        paramArrayList = "null";
        QLog.d("PhoneContact.Manager", 2, paramArrayList);
        paramBoolean = bool1;
        continue;
        i1 = -1;
      }
      finally
      {
        paramArrayList1.end();
      }
      break;
      label722:
      i1 = -1;
      break label301;
      label728:
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean;
        continue;
        label774:
        paramArrayList = paramArrayList.toString();
      }
    }
    label784:
    paramArrayList1.commit();
    paramArrayList1.end();
    boolean bool3;
    boolean bool2;
    for (;;)
    {
      if ((this.jdField_l_of_type_JavaUtilList != null) && (this.jdField_l_of_type_JavaUtilList.size() > 0))
      {
        paramArrayList1 = new ArrayList(this.jdField_l_of_type_JavaUtilList.size());
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      }
      for (;;)
      {
        try
        {
          paramArrayList.begin();
          localObject1 = this.jdField_l_of_type_JavaUtilList.iterator();
          bool1 = paramBoolean;
          paramBoolean = false;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (NotBindContactNotFriendInfo)((Iterator)localObject1).next();
            localObject3 = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt.toUpperCase());
            if (localObject3 != null)
            {
              bool3 = true;
              a((PhoneContact)localObject3, true);
              ((PhoneContact)localObject3).uin = "0";
              ((PhoneContact)localObject3).nickName = ((NotBindContactNotFriendInfo)localObject2).nickname;
              ((PhoneContact)localObject3).isUploaded = true;
              ((PhoneContact)localObject3).unifiedCode = a(((NotBindContactNotFriendInfo)localObject2).MobileNoMask, ((PhoneContact)localObject3).mobileNo);
              ((PhoneContact)localObject3).mobileCode = ((PhoneContact)localObject3).unifiedCode;
              ((PhoneContact)localObject3).nationCode = "";
              ((PhoneContact)localObject3).age = ((NotBindContactNotFriendInfo)localObject2).age;
              ((PhoneContact)localObject3).sex = ((NotBindContactNotFriendInfo)localObject2).sex;
              ((PhoneContact)localObject3).samFriend = ((NotBindContactNotFriendInfo)localObject2).sameFriend;
              if (((NotBindContactNotFriendInfo)localObject2).isNew)
              {
                paramBoolean = true;
                ((PhoneContact)localObject3).isNewRecommend = true;
                this.jdField_b_of_type_JavaUtilList.add(localObject3);
              }
              if (((PhoneContact)localObject3).detalStatusFlag != 20) {
                paramArrayList1.add(((PhoneContact)localObject3).unifiedCode);
              }
              ((PhoneContact)localObject3).abilityBits = ((NotBindContactNotFriendInfo)localObject2).uAbiFlag;
              if (!TextUtils.isEmpty(((PhoneContact)localObject3).unifiedCode)) {
                this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PhoneContact)localObject3).unifiedCode, localObject3);
              }
              this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((PhoneContact)localObject3).mobileNo);
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update((Entity)localObject3);
              bool2 = paramBoolean;
              if (!QLog.isColorLevel()) {
                break label1390;
              }
              QLog.d("PhoneContact.Manager", 2, "MobileContactsNotFriendInfo; mobile=" + ((PhoneContact)localObject3).unifiedCode + " hide=" + ((PhoneContact)localObject3).isHiden);
              bool2 = true;
              bool1 = paramBoolean;
              paramBoolean = bool2;
              break;
            }
            bool3 = bool1;
            bool2 = paramBoolean;
            if (!QLog.isColorLevel()) {
              break label1390;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean;
            break label1390;
          }
          e(paramArrayList1);
          paramArrayList.commit();
          paramArrayList.end();
          bool2 = paramBoolean;
          paramBoolean = bool1;
          this.jdField_h_of_type_JavaUtilList = null;
          this.jdField_a_of_type_JavaUtilList = null;
          this.jdField_m_of_type_JavaUtilList = null;
          this.jdField_l_of_type_JavaUtilList = null;
          paramInt = 7;
          if (bool2) {
            paramInt = 15;
          }
          if (paramLong1 == 4294967295L)
          {
            e(true);
            b(paramBoolean, this.jdField_b_of_type_JavaUtilList);
            this.jdField_b_of_type_JavaUtilList.clear();
            q();
            c(paramLong2);
          }
          c(bool2);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "saveContactFromServerNotBind leave");
          }
          return paramInt;
        }
        finally
        {
          paramArrayList.end();
        }
        bool2 = false;
      }
      label1372:
      paramBoolean = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean;
      paramBoolean = bool2;
      break;
      label1390:
      paramBoolean = bool3;
      bool1 = bool2;
    }
  }
  
  public int a(boolean paramBoolean1, int paramInt, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3, List<MobileContactsFriendInfo> paramList, List<MobileContactsNotFriendInfo> paramList1)
  {
    if (this.jdField_j_of_type_Boolean) {
      return 0;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(80);
      ((StringBuilder)localObject1).append("saveContactFromServer_v2, isSegmented = ").append(paramBoolean1);
      ((StringBuilder)localObject1).append(", packageNo = ").append(paramInt);
      ((StringBuilder)localObject1).append(", nextFlag = ").append(paramLong1);
      QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_c_of_type_JavaUtilList == null)
    {
      this.jdField_c_of_type_JavaUtilList = paramList;
      if (this.jdField_d_of_type_JavaUtilList != null) {
        break label132;
      }
      this.jdField_d_of_type_JavaUtilList = paramList1;
    }
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean1)) {
        break label147;
      }
      return 0;
      this.jdField_c_of_type_JavaUtilList.addAll(paramList);
      break;
      label132:
      this.jdField_d_of_type_JavaUtilList.addAll(paramList1);
    }
    label147:
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
    int i1;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder(200);
      paramList.append("saveContactFromServer, localTimeStamp:");
      paramList.append(l1).append(", ").append(l2);
      paramList.append(", remoteTimeStamp: ").append(paramLong2).append(", ").append(paramLong3);
      paramList1 = paramList.append(", friendCount:");
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        i1 = this.jdField_c_of_type_JavaUtilList.size();
        paramList1.append(i1);
        paramList1 = paramList.append(", strangerCount:");
        if (this.jdField_d_of_type_JavaUtilList == null) {
          break label781;
        }
        i1 = this.jdField_d_of_type_JavaUtilList.size();
        label312:
        paramList1.append(i1);
        paramList.append(", isListChanged:").append(paramBoolean2);
        QLog.d("PhoneContact.Manager", 2, paramList.toString());
      }
    }
    else
    {
      if (!this.jdField_d_of_type_Boolean) {
        e();
      }
      if (((paramInt == 0) && (paramBoolean1)) || (!paramBoolean1)) {
        d(paramBoolean2);
      }
      if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() <= 0)) {
        break label1569;
      }
      if (!paramBoolean2) {}
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    }
    Object localObject2;
    Object localObject3;
    boolean bool1;
    for (;;)
    {
      try
      {
        paramList1.begin();
        localObject2 = this.jdField_c_of_type_JavaUtilList.iterator();
        paramBoolean1 = false;
        if (!((Iterator)localObject2).hasNext()) {
          break label843;
        }
        localObject3 = (MobileContactsFriendInfo)((Iterator)localObject2).next();
        paramList = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramList == null) {
          break label787;
        }
        bool1 = true;
        a(paramList, paramBoolean2);
        paramList.uin = ((MobileContactsFriendInfo)localObject3).QQ;
        paramList.bindingDate = ((MobileContactsFriendInfo)localObject3).bindingDate;
        paramList.isUploaded = true;
        paramList.originBinder = ((MobileContactsFriendInfo)localObject3).originBinder;
        paramList.ability = ((MobileContactsFriendInfo)localObject3).accountAbi;
        paramList.unifiedCode = a(((MobileContactsFriendInfo)localObject3).MobileNoMask, paramList.mobileNo);
        paramList.mobileCode = paramList.unifiedCode;
        paramList.nationCode = "";
        if ((!TextUtils.isEmpty(paramList.uin)) && (!paramList.uin.equals("0")))
        {
          localObject3 = ((FriendsManager)localObject1).e(paramList.uin);
          if (localObject3 != null) {
            paramList.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList.uin, paramList);
          ((FriendsManager)localObject1).a(paramList.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramList.unifiedCode)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList.unifiedCode, paramList);
        }
        this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramList.mobileNo);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramList);
        paramBoolean1 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramList != null) {
          break label833;
        }
        paramList = "null";
        QLog.d("PhoneContact.Manager", 2, paramList);
        paramBoolean1 = bool1;
        continue;
        i1 = -1;
      }
      finally
      {
        paramList1.end();
      }
      break;
      label781:
      i1 = -1;
      break label312;
      label787:
      bool1 = paramBoolean1;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean1;
        continue;
        label833:
        paramList = paramList.unifiedCode;
      }
    }
    label843:
    paramList1.commit();
    paramList1.end();
    boolean bool3;
    boolean bool2;
    for (;;)
    {
      if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0))
      {
        paramList1 = new ArrayList(this.jdField_d_of_type_JavaUtilList.size());
        paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      }
      for (;;)
      {
        try
        {
          paramList.begin();
          localObject1 = this.jdField_d_of_type_JavaUtilList.iterator();
          bool1 = paramBoolean1;
          paramBoolean1 = false;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MobileContactsNotFriendInfo)((Iterator)localObject1).next();
            localObject3 = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt.toUpperCase());
            if (localObject3 != null)
            {
              bool3 = true;
              a((PhoneContact)localObject3, paramBoolean2);
              bool1 = paramBoolean1;
              if (paramBoolean2)
              {
                ((PhoneContact)localObject3).uin = "0";
                ((PhoneContact)localObject3).bindingDate = ((MobileContactsNotFriendInfo)localObject2).bindingDate;
                ((PhoneContact)localObject3).nickName = ((MobileContactsNotFriendInfo)localObject2).nickname;
                ((PhoneContact)localObject3).isUploaded = true;
                ((PhoneContact)localObject3).originBinder = ((MobileContactsNotFriendInfo)localObject2).originBinder;
                ((PhoneContact)localObject3).ability = ((MobileContactsNotFriendInfo)localObject2).accountAbi;
                ((PhoneContact)localObject3).unifiedCode = a(((MobileContactsNotFriendInfo)localObject2).MobileNoMask, ((PhoneContact)localObject3).mobileNo);
                ((PhoneContact)localObject3).mobileCode = ((PhoneContact)localObject3).unifiedCode;
                ((PhoneContact)localObject3).nationCode = "";
                ((PhoneContact)localObject3).age = ((MobileContactsNotFriendInfo)localObject2).age;
                ((PhoneContact)localObject3).sex = ((MobileContactsNotFriendInfo)localObject2).sex;
                ((PhoneContact)localObject3).samFriend = ((MobileContactsNotFriendInfo)localObject2).sameFriend;
                bool1 = paramBoolean1;
                if (((MobileContactsNotFriendInfo)localObject2).isNew)
                {
                  bool1 = true;
                  ((PhoneContact)localObject3).isNewRecommend = true;
                  this.jdField_b_of_type_JavaUtilList.add(localObject3);
                }
              }
              if (((MobileContactsNotFriendInfo)localObject2).isUpdateSign) {
                ((PhoneContact)localObject3).setRichBuffer(((MobileContactsNotFriendInfo)localObject2).personalSign, ((MobileContactsNotFriendInfo)localObject2).richTime);
              }
              if (((PhoneContact)localObject3).detalStatusFlag != 20) {
                paramList1.add(((PhoneContact)localObject3).unifiedCode);
              }
              ((PhoneContact)localObject3).netTypeIconId = ((MobileContactsNotFriendInfo)localObject2).conType;
              ((PhoneContact)localObject3).detalStatusFlag = ((MobileContactsNotFriendInfo)localObject2).detalStatusFlag;
              ((PhoneContact)localObject3).iTermType = ((MobileContactsNotFriendInfo)localObject2).iTermType;
              ((PhoneContact)localObject3).strTermDesc = ((MobileContactsNotFriendInfo)localObject2).strTermDesc;
              ((PhoneContact)localObject3).eNetworkType = ((MobileContactsNotFriendInfo)localObject2).eNetworkType;
              ((PhoneContact)localObject3).abilityBits = ((MobileContactsNotFriendInfo)localObject2).uAbiFlag;
              if (!TextUtils.isEmpty(((PhoneContact)localObject3).unifiedCode)) {
                this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PhoneContact)localObject3).unifiedCode, localObject3);
              }
              ((PhoneContact)localObject3).isHiden = ((MobileContactsNotFriendInfo)localObject2).isHide;
              this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((PhoneContact)localObject3).mobileNo);
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update((Entity)localObject3);
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label1587;
              }
              QLog.d("PhoneContact.Manager", 2, "MobileContactsNotFriendInfo; mobile=" + ((PhoneContact)localObject3).unifiedCode + " hide=" + ((PhoneContact)localObject3).isHiden);
              paramBoolean1 = true;
              break;
            }
            bool3 = bool1;
            bool2 = paramBoolean1;
            if (!QLog.isColorLevel()) {
              break label1587;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean1;
            break label1587;
          }
          e(paramList1);
          paramList.commit();
          paramList.end();
          bool2 = paramBoolean1;
          paramBoolean1 = bool1;
          this.jdField_h_of_type_JavaUtilList = null;
          this.jdField_a_of_type_JavaUtilList = null;
          this.jdField_c_of_type_JavaUtilList = null;
          this.jdField_d_of_type_JavaUtilList = null;
          paramInt = 6;
          if (paramBoolean2) {
            paramInt = 7;
          }
          i1 = paramInt;
          if (bool2) {
            i1 = paramInt | 0x8;
          }
          if (paramLong1 == 4294967295L)
          {
            e(paramBoolean2);
            b(paramBoolean1, this.jdField_b_of_type_JavaUtilList);
            this.jdField_b_of_type_JavaUtilList.clear();
            q();
            a(paramLong2, paramLong3);
          }
          c(bool2);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "saveContactFromServer_v2 leave");
          }
          return i1;
        }
        finally
        {
          paramList.end();
        }
        bool2 = false;
      }
      label1569:
      paramBoolean1 = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean1;
      paramBoolean1 = bool2;
      break;
      label1587:
      paramBoolean1 = bool3;
      bool1 = bool2;
    }
  }
  
  public long a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      return 1L;
    }
    return 10L;
  }
  
  public RespondQueryQQBindingStat a()
  {
    if (this.jdField_j_of_type_Boolean) {}
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    SharedPreferences localSharedPreferences;
    do
    {
      return null;
      localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    } while (localSharedPreferences == null);
    localRespondQueryQQBindingStat.nationCode = localSharedPreferences.getString("contact_bind_info_nation", null);
    localRespondQueryQQBindingStat.mobileNo = localSharedPreferences.getString("contact_bind_info_mobile", "");
    localRespondQueryQQBindingStat.MobileUniqueNo = localSharedPreferences.getString("contact_bind_info_imei", "");
    localRespondQueryQQBindingStat.isRecommend = localSharedPreferences.getLong("contact_bind_info_recommend", 0L);
    localRespondQueryQQBindingStat.originBinder = localSharedPreferences.getLong("contact_bind_info_origin", 0L);
    localRespondQueryQQBindingStat.bindingTime = localSharedPreferences.getLong("contact_bind_info_time", 0L);
    localRespondQueryQQBindingStat.lastUsedFlag = localSharedPreferences.getLong("contact_bind_info_flag", 0L);
    localRespondQueryQQBindingStat.type = localSharedPreferences.getInt("contact_bind_type", 0);
    localRespondQueryQQBindingStat.isStopFindMatch = localSharedPreferences.getBoolean("contact_bind_stop_find_match", false);
    localRespondQueryQQBindingStat.noBindUploadContacts = localSharedPreferences.getBoolean("contact_bind_nobind_upload", false);
    localRespondQueryQQBindingStat.noBindUploadContactsLocal = localSharedPreferences.getBoolean("contact_bind_nobind_upload_local", false);
    localRespondQueryQQBindingStat.continueUploadNotbind = localSharedPreferences.getBoolean("contact_bind_nobind_continue_upload", false);
    localRespondQueryQQBindingStat.isPhoneSwitched = localSharedPreferences.getBoolean("contact_bind_is_phone_switched", false);
    return localRespondQueryQQBindingStat;
  }
  
  public PermissionChecker a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionChecker == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionChecker = new PermissionChecker();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionChecker;
  }
  
  public ContactBindedAdapter.ContactBindedData a(List<PhoneContact> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new PhoneContactManagerImp.7(this, paramList));
    return this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter$ContactBindedData;
  }
  
  public PhoneContact a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (PhoneContact)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    try
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = b();
      }
      return this.jdField_a_of_type_JavaLangString;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    if (this.jdField_j_of_type_Boolean) {}
    for (;;)
    {
      return null;
      if (paramString != null)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            break label95;
          }
        }
        label95:
        for (EntityManager localEntityManager = null; localEntityManager != null; localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager())
        {
          PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)localEntityManager.find(PhoneNumInfo.class, paramString);
          if (localPhoneNumInfo != null)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPhoneNumInfo.uin);
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneNumInfo.uin, paramString);
          }
          localEntityManager.close();
          return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        }
      }
    }
  }
  
  public ArrayList<PhoneContact> a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = a(null);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("generateRandomList,[%s, %s]", new Object[] { Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - l1) }));
      }
      return new ArrayList();
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PhoneContact)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((PhoneContact)localObject2).samFriend > 0) && (!localFriendsManager.a(((PhoneContact)localObject2).unifiedCode, true))) {
        localArrayList.add(localObject2);
      }
    }
    if (localArrayList.size() < this.jdField_g_of_type_Int) {
      localObject1 = localArrayList;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_JavaUtilSet;
        Collections.sort((List)localObject1, new PhoneContactComparator(new int[] { 3, 4 }, (Set)localObject2, localFriendsManager));
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, String.format("generateRandomList,[%s, %s, %s]", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()), Integer.valueOf(localArrayList.size()), Long.valueOf(System.currentTimeMillis() - l1) }));
        }
        return localObject1;
        localObject1 = new ArrayList(this.jdField_g_of_type_Int);
        int i1 = 0;
        if (i1 < this.jdField_g_of_type_Int)
        {
          ((ArrayList)localObject1).add((PhoneContact)localArrayList.remove(this.jdField_a_of_type_JavaUtilRandom.nextInt(localArrayList.size())));
          i1 += 1;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        QLog.e("PhoneContact.Manager", 1, "" + localIllegalArgumentException, localIllegalArgumentException);
      }
    }
  }
  
  public List<PhoneContact> a()
  {
    return a(new int[] { 1, 2, 4 });
  }
  
  public List<PhoneContact> a(Map<String, PhoneContact> paramMap, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = new ArrayList();
    if (paramMap != null) {
      ((List)localObject).addAll(paramMap.values());
    }
    if (!paramBoolean) {
      Collections.sort((List)localObject, new PhoneContactManagerImp.18(this));
    }
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    label199:
    label234:
    label248:
    String str2;
    int i2;
    label324:
    int i1;
    label344:
    int i3;
    label358:
    int i4;
    label380:
    Friends localFriends;
    label388:
    label404:
    int i5;
    if (((List)localObject).size() > 0)
    {
      if (a() == null) {
        return null;
      }
      String str1 = a().mobileNo;
      paramMap = null;
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (PhoneContact)localIterator.next();
          if ((str1 == null) || (!str1.endsWith(((PhoneContact)localObject).mobileNo.trim())))
          {
            localObject = (PhoneContact)((PhoneContact)localObject).clone();
            if (paramMap == null)
            {
              paramMap = (Map<String, PhoneContact>)localObject;
              if (!TextUtils.isEmpty(((PhoneContact)localObject).uin))
              {
                if (!((PhoneContact)localObject).uin.equals("0")) {
                  break label234;
                }
                paramMap = null;
                if ((paramMap == null) || (paramMap.groupid < 0)) {
                  break label248;
                }
                ((PhoneContact)localObject).nickName = paramMap.getFriendNick();
                ((PhoneContact)localObject).remark = paramMap.remark;
              }
              for (paramMap = (Map<String, PhoneContact>)localObject;; paramMap = (Map<String, PhoneContact>)localObject)
              {
                break;
                paramMap = localFriendsManager.e(((PhoneContact)localObject).uin);
                break label199;
                ((PhoneContact)localObject).uin = "0";
              }
            }
            if ((!paramBoolean) && (((PhoneContact)localObject).contactID == paramMap.contactID))
            {
              str2 = paramMap.mobileNo + "|" + ((PhoneContact)localObject).mobileNo;
              if (!TextUtils.isEmpty(paramMap.uin))
              {
                i2 = 1;
                if ((i2 == 0) || (paramMap.uin.equals("0"))) {
                  break label478;
                }
                i1 = 1;
                if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
                  break label483;
                }
                i3 = 1;
                if ((i3 == 0) || (((PhoneContact)localObject).uin.equals("0"))) {
                  break label489;
                }
                i4 = 1;
                if (i4 != 0) {
                  break label495;
                }
                localFriends = null;
                if ((localFriends == null) || (localFriends.groupid < 0)) {
                  break label510;
                }
                i4 = 1;
                i5 = 2;
                if (i1 == 0) {
                  break label516;
                }
                i1 = 0;
                label413:
                if (i4 == 0) {
                  break label529;
                }
                i2 = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label421:
      if (i1 > i2)
      {
        paramMap = (Map<String, PhoneContact>)localObject;
        if (i3 != 0)
        {
          if (i4 == 0) {
            break label540;
          }
          ((PhoneContact)localObject).nickName = localFriends.getFriendNick();
          ((PhoneContact)localObject).remark = localFriends.remark;
          paramMap = (Map<String, PhoneContact>)localObject;
        }
      }
      for (;;)
      {
        paramMap.mobileNo = str2;
        break;
        i2 = 0;
        break label324;
        label478:
        i1 = 0;
        break label344;
        label483:
        i3 = 0;
        break label358;
        label489:
        i4 = 0;
        break label380;
        label495:
        localFriends = localFriendsManager.e(((PhoneContact)localObject).uin);
        break label388;
        label510:
        i4 = 0;
        break label404;
        label516:
        i1 = i5;
        if (i2 == 0) {
          break label413;
        }
        i1 = 1;
        break label413;
        label529:
        if (i3 == 0) {
          break label728;
        }
        i2 = 1;
        break label421;
        label540:
        ((PhoneContact)localObject).uin = "0";
        paramMap = (Map<String, PhoneContact>)localObject;
        continue;
        localArrayList.add(paramMap);
        paramMap = (Map<String, PhoneContact>)localObject;
        if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
          break;
        }
        if (((PhoneContact)localObject).uin.equals("0")) {}
        for (paramMap = null;; paramMap = localFriendsManager.e(((PhoneContact)localObject).uin))
        {
          if ((paramMap == null) || (paramMap.groupid < 0)) {
            break label640;
          }
          ((PhoneContact)localObject).nickName = paramMap.getFriendNick();
          ((PhoneContact)localObject).remark = paramMap.remark;
          paramMap = (Map<String, PhoneContact>)localObject;
          break;
        }
        label640:
        ((PhoneContact)localObject).uin = "0";
        paramMap = (Map<String, PhoneContact>)localObject;
        break;
        if (paramMap != null) {
          localArrayList.add(paramMap);
        }
        c(localArrayList);
        Collections.sort(localArrayList, new PhoneContactManagerImp.19(this));
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "getContactListForContactListView sort contact cost time: " + (System.currentTimeMillis() - l1));
        }
        return localArrayList;
      }
      label728:
      i2 = 2;
    }
  }
  
  public List<PhoneContact> a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = this.jdField_h_of_type_JavaUtilList;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = h();
    }
    localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject1).next();
      if (localPhoneContact.isHiden) {
        ((List)localObject2).add(localPhoneContact);
      }
    }
    if (paramBoolean) {
      Collections.sort((List)localObject2, new PhoneContactComparator(new int[] { 1, 4 }, null, null));
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getBindHideNoneFriendList cost: " + (System.currentTimeMillis() - l1) + ", size = " + ((List)localObject2).size());
    }
    return localObject2;
  }
  
  public List<PhoneContact> a(int[] paramArrayOfInt)
  {
    long l1 = System.currentTimeMillis();
    List localList = this.jdField_h_of_type_JavaUtilList;
    Object localObject = localList;
    if (localList == null) {
      localObject = h();
    }
    localObject = new ArrayList((Collection)localObject);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {}
    try
    {
      Collections.sort((List)localObject, new PhoneContactComparator(paramArrayOfInt, this.jdField_a_of_type_JavaUtilSet, (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)));
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "getBindNonfriendList cost: " + (System.currentTimeMillis() - l1) + ", size = " + ((List)localObject).size());
      }
      this.jdField_h_of_type_JavaUtilList = ((List)localObject);
      return localObject;
    }
    catch (Exception paramArrayOfInt)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "getBindNonfriendList", paramArrayOfInt);
        }
      }
    }
  }
  
  public Map<String, PhoneContact> a()
  {
    long l1;
    ConcurrentHashMap localConcurrentHashMap;
    Object localObject1;
    try
    {
      localCursor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, jdField_a_of_type_ArrayOfJavaLangString, null, null, null);
      if (localCursor == null) {
        break label455;
      }
      l1 = System.currentTimeMillis();
      i1 = localCursor.getCount();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "load contacs from system db, size=" + i1);
      }
      localConcurrentHashMap = new ConcurrentHashMap();
    }
    catch (Exception localException)
    {
      try
      {
        localCursor.moveToFirst();
        for (;;)
        {
          if (localCursor.isAfterLast()) {
            break label411;
          }
          str2 = PhoneContactHelper.a(localCursor.getString(localCursor.getColumnIndex("data1")));
          str3 = localCursor.getString(localCursor.getColumnIndex("display_name"));
          String str1 = str3;
          if (TextUtils.isEmpty(str3)) {
            str1 = str2;
          }
          i1 = localCursor.getInt(localCursor.getColumnIndex("contact_id"));
          i2 = localCursor.getInt(localCursor.getColumnIndex("data2"));
          str3 = localCursor.getString(localCursor.getColumnIndex("data3"));
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1))) {
            break;
          }
          localCursor.moveToNext();
        }
      }
      catch (StaleDataException localStaleDataException)
      {
        for (;;)
        {
          Cursor localCursor;
          int i1;
          String str2;
          String str3;
          int i2;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "cursor query exception=", localStaleDataException);
          }
          return localConcurrentHashMap;
          localException = localException;
          if (QLog.isColorLevel()) {
            QLog.e("PhoneContact.Manager", 2, "can not query data from system contact db.");
          }
          localObject1 = null;
          continue;
          PhoneContact localPhoneContact = new PhoneContact();
          localPhoneContact.mobileNo = str2;
          localPhoneContact.name = localStaleDataException;
          localPhoneContact.contactID = i1;
          localPhoneContact.type = i2;
          localPhoneContact.label = str3;
          localPhoneContact.lastScanTime = l1;
          localPhoneContact.pinyinAll = ChnToSpell.a(localStaleDataException, 1);
          localPhoneContact.pinyinInitial = ChnToSpell.a(localStaleDataException, 2);
          localPhoneContact.pinyinFirst = PhoneContactHelper.b(localPhoneContact.pinyinInitial);
          localPhoneContact.md5 = PhoneContactHelper.a(localStaleDataException, str2);
          localConcurrentHashMap.put(str2, localPhoneContact);
        }
      }
      finally
      {
        localObject1.close();
      }
    }
    label411:
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, new Object[] { "load phone contact from system db cost=", Long.valueOf(System.currentTimeMillis() - l1) });
    }
    localObject1.close();
    return localConcurrentHashMap;
    label455:
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$MyContentObserver != null)
    {
      try
      {
        if (this.jdField_j_of_type_Boolean) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$MyContentObserver);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$MyContentObserver.a(null);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$MyContentObserver = null;
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          int i1 = paramString.optInt("all_entrance_num");
          if (i1 > 0) {
            jdField_b_of_type_Int = i1;
          }
          this.jdField_c_of_type_AndroidContentSharedPreferences.edit().putInt("all_entrance_num", jdField_b_of_type_Int).commit();
          this.jdField_c_of_type_AndroidContentSharedPreferences.edit().putInt("key_config_version", paramInt).commit();
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "updateConfigs error " + paramString.getMessage());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "updateAllEntranceConfig|allEntranceNum = " + jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveBindConfig style:" + paramInt + " wording:" + paramString1 + " blockMsg:" + paramString2);
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putInt("key_bind_style", paramInt);
    localEditor.putString("key_bind_wording", paramString1);
    localEditor.putString("key_block_msg", paramString2);
    localEditor.commit();
  }
  
  public void a(int paramInt, List<String> paramList)
  {
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_e_of_type_JavaUtilList = paramList;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (localObject != null)
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append("|");
          }
          localStringBuilder.append((String)localObject);
        }
      }
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putInt("frd_has_bind_phone_count_" + paramList, this.jdField_f_of_type_Int).putString("frd_has_bind_phone_some_" + paramList, localStringBuilder.toString()).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("onGetFriendsHasBindPhone [%s, %s]", new Object[] { Integer.valueOf(this.jdField_f_of_type_Int), localStringBuilder.toString() }));
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveUIBits: newBits = " + paramLong + " localUIBits = " + this.jdField_f_of_type_Long);
    }
    if (this.jdField_f_of_type_Long != paramLong)
    {
      this.jdField_f_of_type_Long = paramLong;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_contacts_switches", paramLong);
      b(paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == jdField_a_of_type_Long) && (paramLong2 == jdField_b_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("saveQueryInterval not change [limit:%s, limitLogin:%s]", new Object[] { Long.valueOf(jdField_a_of_type_Long), Long.valueOf(jdField_b_of_type_Long) }));
      }
    }
    for (;;)
    {
      return;
      try
      {
        jdField_a_of_type_Long = Math.max(1800000L, paramLong1);
        jdField_b_of_type_Long = Math.max(86400000L, paramLong2);
        this.jdField_b_of_type_AndroidContentSharedPreferences.edit().putLong("query_contact_list_min_interval", jdField_a_of_type_Long).apply();
        this.jdField_b_of_type_AndroidContentSharedPreferences.edit().putLong("query_contact_list_min_interval_for_login", jdField_b_of_type_Long).apply();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PhoneContact.Manager", 2, String.format("saveQueryInterval  [limit:%s, limitLogin:%s]", new Object[] { Long.valueOf(jdField_a_of_type_Long), Long.valueOf(jdField_b_of_type_Long) }));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("PhoneContact.Manager", 2, localThrowable.getMessage());
          }
        }
      }
    }
  }
  
  public void a(ContactMatch paramContactMatch)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramContactMatch);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramContactMatch);
      }
      return;
    }
  }
  
  public void a(PhoneContactAdd paramPhoneContactAdd)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramPhoneContactAdd);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramPhoneContactAdd);
      }
      return;
    }
  }
  
  public void a(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramIPhoneContactListener)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramIPhoneContactListener);
      }
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "makePhoneContactAddInfo|unifiedCode : " + paramString1 + "|friendSetting : " + paramInt + "|remark : " + paramString2);
    }
    if ((paramInt != 1) && (paramInt != 4)) {
      return;
    }
    label406:
    label422:
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        try
        {
          localEntityTransaction.begin();
          if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.isEmpty())) {
            break label422;
          }
          localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label422;
          }
          PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)((Iterator)localObject2).next();
          if (!localPhoneContactAdd.unifiedCode.equals(paramString1)) {
            continue;
          }
          localPhoneContactAdd.timestamp = MessageCache.a();
          a(localPhoneContactAdd);
          i1 = 0;
          if (i1 != 0)
          {
            localObject2 = new PhoneContactAdd();
            ((PhoneContactAdd)localObject2).name = paramString2;
            ((PhoneContactAdd)localObject2).unifiedCode = paramString1;
            ((PhoneContactAdd)localObject2).timestamp = MessageCache.a();
            if (paramInt != 1) {
              break label356;
            }
            ((PhoneContactAdd)localObject2).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694801);
            if (this.jdField_b_of_type_JavaUtilArrayList == null) {
              this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            a((Entity)localObject2);
          }
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
          {
            paramString2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (paramString2.hasNext())
            {
              localObject2 = (ContactMatch)paramString2.next();
              if (!((ContactMatch)localObject2).unifiedCode.equals(paramString1)) {
                continue;
              }
              paramString2.remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject2);
            }
          }
          localEntityTransaction.commit();
        }
        catch (Resources.NotFoundException paramString1)
        {
          Object localObject2;
          if (!QLog.isColorLevel()) {
            break label406;
          }
          QLog.d("PhoneContact.Manager", 2, "makePhoneContactAddInfo", paramString1);
          localEntityTransaction.end();
          continue;
        }
        finally
        {
          localEntityTransaction.end();
        }
        return;
      }
      label356:
      if (paramInt == 4)
      {
        ((PhoneContactAdd)localObject2).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694802);
        continue;
        i1 = 1;
      }
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 16);
    localNewIntent.putExtra("verify_smscode", paramString);
    localNewIntent.putExtra("session_id", this.jdField_a_of_type_ArrayOfByte);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
      paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
      paramString.eNetworkType = paramGetOnlineInfoResp.eNetworkType;
      paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
      paramString.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
      paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
      if (((paramGetOnlineInfoResp.iTermType == 67586L) || (paramGetOnlineInfoResp.iTermType == 66566L) || (paramGetOnlineInfoResp.iTermType == 72194L) || (paramGetOnlineInfoResp.iTermType == 65804L) || (paramGetOnlineInfoResp.iTermType == 72706L)) && (paramGetOnlineInfoResp.eNetworkType != 1)) {
        paramString.netTypeIconIdIphoneOrWphoneNoWifi = paramGetOnlineInfoResp.eIconType;
      }
      a(2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0, false, false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 35);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "hideContact mobile=" + paramString + "; hide=" + paramBoolean);
    }
    Object localObject = c(paramString);
    if (localObject != null)
    {
      localObject = new AddressBookItem(((PhoneContact)localObject).mobileNo, ((PhoneContact)localObject).name);
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
      localNewIntent.putExtra("req_type", 34);
      localNewIntent.putExtra("param_hiden_mobile", (Serializable)localObject);
      localNewIntent.putExtra("param_hiden_flag", paramBoolean);
      localNewIntent.putExtra("unique_phone_no", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 35);
    localNewIntent.putExtra("country_code", paramString);
    localNewIntent.putExtra("cmd_param_is_encrypt", true);
    localNewIntent.putExtra("cmd_param_encrypt_mobile", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ArrayList<PhoneContact> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "updateRenameList");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    EntityTransaction localEntityTransaction;
    label135:
    do
    {
      for (;;)
      {
        return;
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        try
        {
          localEntityTransaction.begin();
          paramArrayList = paramArrayList.iterator();
          for (;;)
          {
            if (!paramArrayList.hasNext()) {
              break label135;
            }
            localPhoneContact = (PhoneContact)paramArrayList.next();
            if (localPhoneContact.getStatus() != 1000) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist(localPhoneContact);
          }
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            PhoneContact localPhoneContact;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContact.Manager", 2, paramArrayList.getMessage());
            }
            return;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(localPhoneContact);
          }
        }
        finally
        {
          if (localEntityTransaction != null) {
            localEntityTransaction.end();
          }
        }
      }
      localEntityTransaction.commit();
    } while (localEntityTransaction == null);
    localEntityTransaction.end();
  }
  
  public void a(ArrayList<PhoneContact> paramArrayList, int paramInt)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    for (;;)
    {
      PhoneContact localPhoneContact;
      if (localIterator.hasNext())
      {
        localPhoneContact = (PhoneContact)localIterator.next();
        if (paramInt != 0) {}
      }
      else
      {
        return;
      }
      if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!paramArrayList.contains(localPhoneContact)))
      {
        paramInt -= 1;
        paramArrayList.add(localPhoneContact);
      }
    }
  }
  
  public void a(ArrayList<PhoneContact> paramArrayList, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList1, int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("multiMakePhoneContactAddInfo|sourceId : ").append(paramInt);
      if (paramArrayList == null)
      {
        ??? = "|phoneList is null";
        localObject2 = ((StringBuilder)localObject2).append((String)???);
        if (paramArrayList1 != null) {
          break label120;
        }
        ??? = "|addlist is null";
        label52:
        QLog.d("PhoneContact.Manager", 2, (String)???);
      }
    }
    else
    {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramArrayList1 != null) && (!paramArrayList1.isEmpty())) {
        break label148;
      }
    }
    label120:
    while ((paramInt != 3078) && (paramInt != 3079))
    {
      return;
      ??? = "|phoneList.size : " + paramArrayList.size();
      break;
      ??? = "|addlist.size : " + paramArrayList1.size();
      break label52;
    }
    label148:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    }
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject3;
      Object localObject4;
      try
      {
        ((EntityTransaction)localObject2).begin();
        localArrayList = new ArrayList();
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(localArrayList.size());
        }
        paramArrayList1 = paramArrayList1.iterator();
        Object localObject5;
        if (paramArrayList1.hasNext())
        {
          localObject3 = (FriendListHandler.AddBatchPhoneFriendResult)paramArrayList1.next();
          if (((FriendListHandler.AddBatchPhoneFriendResult)localObject3).sendResult != 0) {
            continue;
          }
          localObject4 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label675;
          }
          localObject5 = (PhoneContactAdd)((Iterator)localObject4).next();
          if (!((PhoneContactAdd)localObject5).unifiedCode.equals(((FriendListHandler.AddBatchPhoneFriendResult)localObject3).mobile)) {
            continue;
          }
          ((PhoneContactAdd)localObject5).timestamp = MessageCache.a();
          a((Entity)localObject5);
          paramInt = 0;
          if (paramInt == 0) {
            continue;
          }
          localObject4 = new PhoneContactAdd();
          ((PhoneContactAdd)localObject4).unifiedCode = ((FriendListHandler.AddBatchPhoneFriendResult)localObject3).mobile;
          ((PhoneContactAdd)localObject4).timestamp = MessageCache.a();
          ((PhoneContactAdd)localObject4).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694801);
          localArrayList.add(localObject4);
          continue;
        }
        paramArrayList1 = paramArrayList1.name;
      }
      catch (Resources.NotFoundException paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "multiMakePhoneContactAddInfo", paramArrayList);
        }
        ((EntityTransaction)localObject2).end();
        return;
        paramArrayList = finally;
        throw paramArrayList;
        if (localArrayList.isEmpty()) {
          break label662;
        }
        localObject3 = localArrayList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label544;
        }
        localObject4 = (PhoneContactAdd)((Iterator)localObject3).next();
        localObject5 = paramArrayList.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          paramArrayList1 = (PhoneContact)((Iterator)localObject5).next();
          if (!paramArrayList1.unifiedCode.equals(((PhoneContactAdd)localObject4).unifiedCode)) {
            continue;
          }
          if (paramArrayList1.name == null)
          {
            paramArrayList1 = paramArrayList1.nickName;
            ((PhoneContactAdd)localObject4).name = paramArrayList1;
            a((Entity)localObject4);
          }
        }
        else
        {
          continue;
        }
      }
      finally
      {
        ((EntityTransaction)localObject2).end();
      }
      continue;
      label544:
      this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        paramArrayList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!paramArrayList.hasNext()) {
            break label662;
          }
          paramArrayList1 = (ContactMatch)paramArrayList.next();
          localObject3 = localArrayList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (PhoneContactAdd)((Iterator)localObject3).next();
            if (!paramArrayList1.unifiedCode.equals(((PhoneContactAdd)localObject4).unifiedCode)) {
              break;
            }
            paramArrayList.remove();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramArrayList1);
          }
        }
      }
      label662:
      ((EntityTransaction)localObject2).commit();
      ((EntityTransaction)localObject2).end();
      continue;
      label675:
      paramInt = 1;
    }
  }
  
  public void a(List<PhoneContact> paramList)
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ContactListView.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(4);
      Message localMessage = localMqqHandler.obtainMessage(4);
      localMessage.obj = paramList;
      localMqqHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void a(List<String> paramList, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveLastLoginList, size = " + paramList.size() + ", stamp " + paramLong1 + ", interval = " + paramLong2);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_req_last_login_time", System.currentTimeMillis()).putLong("key_login_info_timestamp", paramLong1).putLong("key_req_login_interval", Math.max(43200000L, 1000L * paramLong2)).commit();
    HashSet localHashSet = new HashSet(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(str.toUpperCase());
      if (localPhoneContact != null) {
        localHashSet.add(localPhoneContact.unifiedCode);
      } else if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "saveLastLoginList, wtf pc null " + str.toUpperCase());
      }
    }
    this.jdField_a_of_type_JavaUtilSet = localHashSet;
    a(this.jdField_a_of_type_JavaUtilSet);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveLastLoginInfo: tempSet.size=" + localHashSet.size());
    }
  }
  
  /* Error */
  public void a(Set<String> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 130	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_j_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc_w 280
    //   17: iconst_2
    //   18: new 226	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 2105
    //   28: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 1231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 295	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 310	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   48: invokevirtual 316	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnonnull +14 -> 67
    //   56: ldc_w 280
    //   59: iconst_1
    //   60: ldc_w 2107
    //   63: invokestatic 1866	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: return
    //   67: aload_3
    //   68: invokevirtual 497	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   76: aload_3
    //   77: ldc_w 2109
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 2110	com/tencent/mobileqq/persistence/EntityManager:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   85: pop
    //   86: aload_1
    //   87: invokeinterface 626 1 0
    //   92: astore_1
    //   93: aload_1
    //   94: invokeinterface 631 1 0
    //   99: ifeq +64 -> 163
    //   102: aload_1
    //   103: invokeinterface 635 1 0
    //   108: checkcast 72	java/lang/String
    //   111: astore 4
    //   113: aload 4
    //   115: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne -25 -> 93
    //   121: new 1414	com/tencent/mobileqq/data/LastLoginPhoneInfo
    //   124: dup
    //   125: invokespecial 2111	com/tencent/mobileqq/data/LastLoginPhoneInfo:<init>	()V
    //   128: astore 5
    //   130: aload 5
    //   132: aload 4
    //   134: putfield 1418	com/tencent/mobileqq/data/LastLoginPhoneInfo:unifiedCode	Ljava/lang/String;
    //   137: aload_3
    //   138: aload 5
    //   140: invokevirtual 1333	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   143: goto -50 -> 93
    //   146: astore_1
    //   147: ldc_w 280
    //   150: iconst_1
    //   151: ldc_w 2113
    //   154: aload_1
    //   155: invokestatic 1304	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_2
    //   159: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   162: return
    //   163: aload_2
    //   164: invokevirtual 662	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   167: aload_2
    //   168: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   171: return
    //   172: astore_1
    //   173: aload_2
    //   174: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   177: aload_1
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	PhoneContactManagerImp
    //   0	179	1	paramSet	Set<String>
    //   71	103	2	localEntityTransaction	EntityTransaction
    //   51	87	3	localEntityManager	EntityManager
    //   111	22	4	str	String
    //   128	11	5	localLastLoginPhoneInfo	LastLoginPhoneInfo
    // Exception table:
    //   from	to	target	type
    //   72	93	146	java/lang/Exception
    //   93	143	146	java/lang/Exception
    //   163	167	146	java/lang/Exception
    //   72	93	172	finally
    //   93	143	172	finally
    //   147	158	172	finally
    //   163	167	172	finally
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("PhoneContact.Manager", 1, new Object[] { "onStepAction fromLogin=", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      e();
      ConfigServlet.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    boolean bool = a(false);
    if ((paramBoolean) && (!bool)) {
      a(true, 2);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_j_of_type_Boolean) {
      break label7;
    }
    label7:
    while (((paramInt == 2) || (paramInt == 23)) && (!this.jdField_h_of_type_Boolean)) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label127;
      }
      boolean bool = b(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("post checkUpdateLocalContact [beFirstQuery, queryFrom, deal]=[%b, %d, %b]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
      }
      if ((bool) || ((paramInt != 2) && (paramInt != 23))) {
        break;
      }
      a(false, true, paramInt);
      return;
    }
    label127:
    ThreadManager.getSubThreadHandler().post(new PhoneContactManagerImp.15(this, paramBoolean, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    this.jdField_h_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_unbind_mobile_time", this.jdField_h_of_type_Long).apply();
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("unbindMobile [%s]", new Object[] { Long.valueOf(this.jdField_h_of_type_Long) }));
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 20);
    localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
    localNewIntent.putExtra("phone_number", localRespondQueryQQBindingStat.mobileNo);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_j_of_type_Boolean	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 2142	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$5
    //   19: dup
    //   20: aload_0
    //   21: iload_1
    //   22: iload_2
    //   23: iload_3
    //   24: invokespecial 2145	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$5:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;ZZI)V
    //   27: bipush 16
    //   29: aconst_null
    //   30: iconst_0
    //   31: invokestatic 380	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   34: goto -21 -> 13
    //   37: astore 5
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 5
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	PhoneContactManagerImp
    //   0	44	1	paramBoolean1	boolean
    //   0	44	2	paramBoolean2	boolean
    //   0	44	3	paramInt	int
    //   6	3	4	bool	boolean
    //   37	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	37	finally
    //   16	34	37	finally
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("session_id", new String(paramArrayOfByte)).commit();
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    this.jdField_h_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_unbind_mobile_time", this.jdField_h_of_type_Long).apply();
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("unbindMobileEncrypt [%s]", new Object[] { Long.valueOf(this.jdField_h_of_type_Long) }));
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 20);
    localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
    localNewIntent.putExtra("cmd_param_is_encrypt", true);
    localNewIntent.putExtra("cmd_param_encrypt_mobile", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean a()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public boolean a(RecommendedContactInfo paramRecommendedContactInfo)
  {
    if (!TextUtils.isEmpty(paramRecommendedContactInfo.contactsInfoEncrypt))
    {
      paramRecommendedContactInfo.contactsInfoEncrypt = paramRecommendedContactInfo.contactsInfoEncrypt.toUpperCase();
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramRecommendedContactInfo.contactsInfoEncrypt);
      if (localPhoneContact != null)
      {
        paramRecommendedContactInfo.unicode = a(paramRecommendedContactInfo.MobileNoMask, localPhoneContact.mobileNo);
        paramRecommendedContactInfo.name = localPhoneContact.name;
        if ((!TextUtils.isEmpty(paramRecommendedContactInfo.unicode)) && (!TextUtils.isEmpty(paramRecommendedContactInfo.name))) {
          return true;
        }
      }
      else
      {
        QLog.d("newerguide", 2, "test .. fillNewerGuideInfo no contact " + paramRecommendedContactInfo.contactsInfoEncrypt);
      }
    }
    return false;
  }
  
  public boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat, String paramString)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("saveBindInfo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_j_of_type_Boolean), paramRespondQueryQQBindingStat, Integer.valueOf(this.jdField_a_of_type_Int), paramString }));
    }
    if (this.jdField_j_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = a(a());
    }
    int i1 = a(paramRespondQueryQQBindingStat);
    if (this.jdField_a_of_type_Int != i1) {
      bool = true;
    }
    paramString = paramRespondQueryQQBindingStat;
    if (paramRespondQueryQQBindingStat == null) {
      paramString = new RespondQueryQQBindingStat();
    }
    paramRespondQueryQQBindingStat = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramRespondQueryQQBindingStat.putString("contact_bind_info_mobile", paramString.mobileNo);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_nation", paramString.nationCode);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_imei", paramString.MobileUniqueNo);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_recommend", paramString.isRecommend);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_origin", paramString.originBinder);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_time", paramString.bindingTime);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_flag", paramString.lastUsedFlag);
    paramRespondQueryQQBindingStat.putInt("contact_bind_type", paramString.type);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_stop_find_match", paramString.isStopFindMatch);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_nobind_upload", paramString.noBindUploadContacts);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_nobind_upload_local", paramString.noBindUploadContactsLocal);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_is_phone_switched", paramString.isPhoneSwitched);
    this.jdField_i_of_type_Boolean = paramString.isPhoneSwitched;
    paramRespondQueryQQBindingStat.commit();
    a(paramString);
    return bool;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
      }
    }
    QLog.d("PhoneContact.Manager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)localIterator.next();
        if (localPhoneContactAdd.unifiedCode.equals(paramString))
        {
          localIterator.remove();
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localPhoneContactAdd);
          return true;
        }
      }
      return false;
    }
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +40 -> 49
    //   12: ldc_w 280
    //   15: iconst_2
    //   16: new 226	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 2178
    //   26: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 1544
    //   36: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: invokevirtual 468	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   59: astore 9
    //   61: getstatic 2181	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   64: astore 8
    //   66: new 226	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 2183
    //   76: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 2185
    //   86: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_1
    //   93: aload 9
    //   95: aload 8
    //   97: iconst_4
    //   98: anewarray 72	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: ldc_w 2187
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: ldc_w 2189
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: ldc_w 2191
    //   118: aastore
    //   119: dup
    //   120: iconst_3
    //   121: ldc 74
    //   123: aastore
    //   124: aload_1
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokevirtual 480	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   130: astore 8
    //   132: aload_2
    //   133: astore_1
    //   134: aload 6
    //   136: astore_2
    //   137: aload 8
    //   139: invokeinterface 527 1 0
    //   144: ifeq +361 -> 505
    //   147: aload 8
    //   149: aload 8
    //   151: ldc_w 2187
    //   154: invokeinterface 512 2 0
    //   159: invokeinterface 2194 2 0
    //   164: lstore_3
    //   165: getstatic 2181	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   168: astore 6
    //   170: new 226	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 2196
    //   180: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: lload_3
    //   184: invokevirtual 997	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: ldc_w 2198
    //   190: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 2191
    //   196: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 2200
    //   202: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc_w 2202
    //   208: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 2204
    //   214: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 80
    //   219: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 2200
    //   225: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: iconst_2
    //   229: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc_w 2185
    //   235: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore 7
    //   243: aload 9
    //   245: aload 6
    //   247: iconst_5
    //   248: anewarray 72	java/lang/String
    //   251: dup
    //   252: iconst_0
    //   253: ldc_w 2187
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: ldc_w 2189
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: ldc_w 2191
    //   268: aastore
    //   269: dup
    //   270: iconst_3
    //   271: ldc 74
    //   273: aastore
    //   274: dup
    //   275: iconst_4
    //   276: ldc 80
    //   278: aastore
    //   279: aload 7
    //   281: aconst_null
    //   282: aconst_null
    //   283: invokevirtual 480	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   286: astore 6
    //   288: aload 6
    //   290: astore_2
    //   291: aload_2
    //   292: invokeinterface 505 1 0
    //   297: ifeq +96 -> 393
    //   300: aload_2
    //   301: aload_2
    //   302: ldc 74
    //   304: invokeinterface 512 2 0
    //   309: invokeinterface 515 2 0
    //   314: invokestatic 520	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   317: astore 7
    //   319: aload_1
    //   320: invokestatic 520	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   323: astore 6
    //   325: aload 6
    //   327: astore_1
    //   328: aload 7
    //   330: aload_1
    //   331: invokestatic 2207	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   334: ifne +35 -> 369
    //   337: new 226	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 2209
    //   347: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload 7
    //   352: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: aload_1
    //   359: invokestatic 2207	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   362: istore 5
    //   364: iload 5
    //   366: ifeq +27 -> 393
    //   369: aload_2
    //   370: ifnull +9 -> 379
    //   373: aload_2
    //   374: invokeinterface 536 1 0
    //   379: aload 8
    //   381: ifnull +10 -> 391
    //   384: aload 8
    //   386: invokeinterface 536 1 0
    //   391: iconst_1
    //   392: ireturn
    //   393: aload_2
    //   394: astore 7
    //   396: aload_1
    //   397: astore 6
    //   399: aload_2
    //   400: ifnull +157 -> 557
    //   403: aload_2
    //   404: invokeinterface 536 1 0
    //   409: aload_2
    //   410: astore 7
    //   412: aload_1
    //   413: astore 6
    //   415: goto +142 -> 557
    //   418: aload_2
    //   419: astore 7
    //   421: aload_1
    //   422: astore 6
    //   424: aload_2
    //   425: ifnull +132 -> 557
    //   428: aload_2
    //   429: invokeinterface 536 1 0
    //   434: aload_2
    //   435: astore 7
    //   437: aload_1
    //   438: astore 6
    //   440: goto +117 -> 557
    //   443: astore_2
    //   444: aload 8
    //   446: astore_1
    //   447: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +14 -> 464
    //   453: ldc_w 280
    //   456: iconst_2
    //   457: ldc_w 2211
    //   460: aload_2
    //   461: invokestatic 530	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   464: aload_1
    //   465: ifnull +9 -> 474
    //   468: aload_1
    //   469: invokeinterface 536 1 0
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_1
    //   477: aload_2
    //   478: ifnull +9 -> 487
    //   481: aload_2
    //   482: invokeinterface 536 1 0
    //   487: aload_1
    //   488: athrow
    //   489: astore_1
    //   490: aload 8
    //   492: astore_2
    //   493: aload_2
    //   494: ifnull +9 -> 503
    //   497: aload_2
    //   498: invokeinterface 536 1 0
    //   503: aload_1
    //   504: athrow
    //   505: aload 8
    //   507: ifnull -33 -> 474
    //   510: aload 8
    //   512: invokeinterface 536 1 0
    //   517: goto -43 -> 474
    //   520: astore_1
    //   521: aload 7
    //   523: astore_2
    //   524: goto -31 -> 493
    //   527: astore 6
    //   529: aload_1
    //   530: astore_2
    //   531: aload 6
    //   533: astore_1
    //   534: goto -41 -> 493
    //   537: astore_2
    //   538: aconst_null
    //   539: astore_1
    //   540: goto -93 -> 447
    //   543: astore_1
    //   544: goto -67 -> 477
    //   547: astore 6
    //   549: goto -131 -> 418
    //   552: astore 6
    //   554: goto -136 -> 418
    //   557: aload 7
    //   559: astore_2
    //   560: aload 6
    //   562: astore_1
    //   563: goto -426 -> 137
    //   566: astore 6
    //   568: goto -150 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	PhoneContactManagerImp
    //   0	571	1	paramString1	String
    //   0	571	2	paramString2	String
    //   164	20	3	l1	long
    //   362	3	5	bool	boolean
    //   4	435	6	localObject1	Object
    //   527	5	6	localObject2	Object
    //   547	1	6	localException1	Exception
    //   552	9	6	localException2	Exception
    //   566	1	6	localException3	Exception
    //   1	557	7	str	String
    //   64	447	8	localObject3	Object
    //   59	185	9	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   137	165	443	java/lang/Exception
    //   373	379	443	java/lang/Exception
    //   403	409	443	java/lang/Exception
    //   428	434	443	java/lang/Exception
    //   481	487	443	java/lang/Exception
    //   487	489	443	java/lang/Exception
    //   291	325	476	finally
    //   328	364	476	finally
    //   137	165	489	finally
    //   373	379	489	finally
    //   403	409	489	finally
    //   428	434	489	finally
    //   481	487	489	finally
    //   487	489	489	finally
    //   61	132	520	finally
    //   447	464	527	finally
    //   61	132	537	java/lang/Exception
    //   165	288	543	finally
    //   328	364	547	java/lang/Exception
    //   165	288	552	java/lang/Exception
    //   291	325	566	java/lang/Exception
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i1;
    long l1;
    long l2;
    int i2;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      i1 = 1;
      l1 = MessageCache.a();
      l2 = Math.abs(l1 - this.jdField_g_of_type_Long);
      if (l2 >= 3600L) {
        break label223;
      }
      i2 = 1;
      label42:
      if ((i2 == 0) || ((!paramBoolean) && (!this.jdField_h_of_type_Boolean))) {
        break label254;
      }
      boolean bool = k();
      if (i1 == 0) {
        bool = m();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, "checkAndUploadContact,  has: " + bool + ",  state: " + d());
      }
      if (!bool) {
        break label254;
      }
      if (i1 == 0) {
        break label228;
      }
      ThreadManager.excute(new PhoneContactManagerImp.21(this, paramBoolean), 16, null, false);
    }
    label223:
    label228:
    label254:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("checkAndUploadContact [%s, %s, %s, %s]", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(this.jdField_g_of_type_Long), Boolean.valueOf(paramBoolean) }));
      }
      if ((i2 == 0) || (paramBoolean)) {
        b(false);
      }
      return paramBoolean;
      i1 = 0;
      break;
      i2 = 0;
      break label42;
      j();
      if (paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = paramBoolean;
        break;
      }
    }
  }
  
  public Object[] a()
  {
    if (this.jdField_f_of_type_Int < 0)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      if (localObject == null) {
        break label200;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      this.jdField_f_of_type_Int = ((SharedPreferences)localObject).getInt("frd_has_bind_phone_count_" + str, 0);
      localObject = ((SharedPreferences)localObject).getString("frd_has_bind_phone_some_" + str, "");
      if (((String)localObject).length() > 0)
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 0)
        {
          this.jdField_e_of_type_JavaUtilList = new ArrayList(localObject.length);
          Collections.addAll(this.jdField_e_of_type_JavaUtilList, (Object[])localObject);
        }
      }
    }
    int i1;
    if (QLog.isColorLevel())
    {
      i1 = this.jdField_f_of_type_Int;
      if (this.jdField_e_of_type_JavaUtilList != null) {
        break label213;
      }
    }
    label200:
    label213:
    for (Object localObject = "null";; localObject = TextUtils.join(",", this.jdField_e_of_type_JavaUtilList))
    {
      QLog.i("PhoneContact.Manager", 2, String.format("getFriendHasBindPhone [%s, %s]", new Object[] { Integer.valueOf(i1), localObject }));
      return new Object[] { Integer.valueOf(this.jdField_f_of_type_Int), this.jdField_e_of_type_JavaUtilList };
      this.jdField_f_of_type_Int = 0;
      this.jdField_e_of_type_JavaUtilList = null;
      break;
    }
  }
  
  public int b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (QLog.isColorLevel())
    {
      localStringBuffer.append("getBannerState bind state = ");
      localStringBuffer.append(d());
    }
    int i1;
    if (d() == 9)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" isCacheInited=");
        localStringBuffer.append(this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_d_of_type_Boolean) {
        if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" ret=");
        localStringBuffer.append(i1);
        QLog.d("PhoneContact.Manager", 2, localStringBuffer.toString());
      }
      return i1;
      i1 = 2;
      continue;
      i1 = 0;
      continue;
      i1 = 2;
    }
  }
  
  public PhoneContact b(String paramString)
  {
    if (this.jdField_d_of_type_Boolean) {
      return (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(PhoneContact.class, paramString);
    }
    return null;
  }
  
  public String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = str;
    } while (str != null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (Object localObject = null; localObject == null; localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager()) {
      return null;
    }
    paramString = (PhoneNumInfo)((EntityManager)localObject).find(PhoneNumInfo.class, "uin=?", new String[] { paramString });
    if (paramString != null) {
      return paramString.phoneNum;
    }
    return null;
  }
  
  public ArrayList<Entity> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded != null) {
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataContactBinded);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            ContactMatch localContactMatch = (ContactMatch)localIterator.next();
            QLog.d("PhoneContact.Manager", 2, "getRecommendContact|mobileNo : " + localContactMatch.mobileNo + "|size : " + this.jdField_a_of_type_JavaUtilArrayList.size());
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public List<PhoneContact> b()
  {
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = i();
    }
    Object localObject1 = new ArrayList((Collection)localObject1);
    try
    {
      localObject2 = this.jdField_a_of_type_JavaUtilSet;
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Collections.sort((List)localObject1, new PhoneContactComparator(new int[] { 6, 5, 1, 4 }, (Set)localObject2, localFriendsManager));
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "getBindAllFriendList size = " + ((List)localObject1).size());
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "getBindAllFriendList", localException);
        }
      }
    }
  }
  
  public List<PhoneContact> b(boolean paramBoolean)
  {
    if (this.jdField_k_of_type_JavaUtilList == null) {
      this.jdField_k_of_type_JavaUtilList = a(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap, paramBoolean);
    }
    return this.jdField_k_of_type_JavaUtilList;
  }
  
  public void b()
  {
    a(true, true, 14);
  }
  
  public void b(PhoneContactManager.IPhoneContactListener paramIPhoneContactListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramIPhoneContactListener);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 33);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "changeHidenStatus: mobile = " + paramString + ";hide=" + paramBoolean);
    }
    paramString = c(paramString);
    if ((paramString != null) && (paramString.isHiden != paramBoolean))
    {
      paramString.isHiden = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramString);
    }
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString);
    localNewIntent.putExtra("cmd_param_is_encrypt", true);
    localNewIntent.putExtra("cmd_param_encrypt_mobile", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(List<AddressBookItem> paramList)
  {
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = this.jdField_j_of_type_Boolean;
        if (bool) {
          return;
        }
        if ((paramList == null) || (paramList.isEmpty())) {
          continue;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        try
        {
          localEntityTransaction.begin();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.end();
        }
        localEntityTransaction.commit();
      }
      finally {}
      localEntityTransaction.end();
      this.jdField_c_of_type_Int += 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l1 = MessageCache.a();; l1 = 0L)
    {
      this.jdField_g_of_type_Long = l1;
      this.jdField_b_of_type_AndroidContentSharedPreferences.edit().putLong("user_setting_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_g_of_type_Long).apply();
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("markOrClearUserSettingFlag [%s]", new Object[] { Long.valueOf(this.jdField_g_of_type_Long) }));
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_h_of_type_JavaUtilList == null) {
      this.jdField_h_of_type_JavaUtilList = h();
    }
    return (this.jdField_h_of_type_JavaUtilList == null) || (this.jdField_h_of_type_JavaUtilList.isEmpty());
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "addContactAndUpload " + paramString1 + ", " + paramString2);
    }
    ContentResolver localContentResolver = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver();
    try
    {
      ContentValues localContentValues = new ContentValues();
      long l1 = ContentUris.parseId(localContentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues));
      if (l1 <= 0L) {
        return false;
      }
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l1));
      localContentValues.put("mimetype", "vnd.android.cursor.item/name");
      localContentValues.put("data1", paramString1);
      localContentResolver.insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l1));
      localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
      localContentValues.put("data1", paramString2);
      localContentValues.put("data2", Integer.valueOf(2));
      localContentResolver.insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      a(false, 1);
      return true;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public int c()
  {
    if (d() <= 5) {
      return 2;
    }
    return 1;
  }
  
  public PhoneContact c(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "queryContactByCodeNumber codeNumber is null");
      }
    }
    do
    {
      return null;
      if (this.jdField_d_of_type_Boolean) {
        return (PhoneContact)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null);
    return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(PhoneContact.class, "mobileCode=?", new String[] { paramString });
  }
  
  public ArrayList<PhoneContactAdd> c()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public List<PhoneContact> c()
  {
    List localList = this.jdField_h_of_type_JavaUtilList;
    if (localList == null) {
      localList = h();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (localPhoneContact.isNewRecommend) {
          localArrayList.add(localPhoneContact);
        }
      }
      this.jdField_h_of_type_JavaUtilList = localList;
      return localArrayList;
    }
  }
  
  public void c()
  {
    this.jdField_h_of_type_Boolean = true;
    a(false, 23);
  }
  
  public void c(String paramString1, String paramString2)
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if ((localObject == null) || (!((String)localObject).equals(paramString2)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramString1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      PhoneNumInfo localPhoneNumInfo = new PhoneNumInfo();
      localPhoneNumInfo.phoneNum = paramString1;
      localPhoneNumInfo.uin = paramString2;
      if (localObject != null)
      {
        ((EntityManager)localObject).persistOrReplace(localPhoneNumInfo);
        ((EntityManager)localObject).close();
      }
    }
  }
  
  public void c(List<PhoneContact> paramList)
  {
    label13:
    HashMap localHashMap;
    Object localObject2;
    Object localObject1;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      return;
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        String str = localPhoneContact.mobileCode;
        if (!TextUtils.isEmpty(localPhoneContact.uin))
        {
          localArrayList.add(str);
        }
        else
        {
          localObject2 = (ArrayList)localHashMap.get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            localHashMap.put(str, localObject1);
          }
          ((ArrayList)localObject1).add(localPhoneContact);
        }
      }
      localObject1 = localArrayList.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label13;
      }
      localObject2 = (ArrayList)localHashMap.get((String)((Iterator)localObject1).next());
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList.remove((PhoneContact)((Iterator)localObject2).next());
      }
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +89 -> 96
    //   10: new 226	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 992	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 2336
    //   24: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore 4
    //   29: aload_0
    //   30: getfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   33: bipush 8
    //   35: if_icmpne +96 -> 131
    //   38: iconst_1
    //   39: istore_1
    //   40: aload 4
    //   42: iload_1
    //   43: invokevirtual 911	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: ldc_w 2338
    //   51: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   58: invokevirtual 911	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: ldc_w 1464
    //   66: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   72: aload_0
    //   73: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   76: lsub
    //   77: ldc2_w 1010
    //   80: ldiv
    //   81: invokevirtual 997	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc_w 280
    //   88: iconst_2
    //   89: aload_3
    //   90: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: iload_2
    //   97: istore_1
    //   98: aload_0
    //   99: getfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   102: bipush 8
    //   104: if_icmpeq +23 -> 127
    //   107: iload_2
    //   108: istore_1
    //   109: aload_0
    //   110: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   113: ifne +14 -> 127
    //   116: aload_0
    //   117: invokevirtual 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   120: astore_3
    //   121: aload_3
    //   122: ifnonnull +14 -> 136
    //   125: iload_2
    //   126: istore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: iload_1
    //   130: ireturn
    //   131: iconst_0
    //   132: istore_1
    //   133: goto -93 -> 40
    //   136: iload_2
    //   137: istore_1
    //   138: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   141: aload_0
    //   142: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   145: lsub
    //   146: ldc2_w 63
    //   149: lcmp
    //   150: iflt -23 -> 127
    //   153: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +13 -> 169
    //   159: ldc_w 280
    //   162: iconst_2
    //   163: ldc_w 2340
    //   166: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_0
    //   170: getfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   173: iconst_2
    //   174: if_icmpeq +19 -> 193
    //   177: aload_0
    //   178: getfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   181: iconst_3
    //   182: if_icmpeq +11 -> 193
    //   185: aload_0
    //   186: getfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   189: iconst_4
    //   190: if_icmpne +7 -> 197
    //   193: aload_0
    //   194: invokespecial 794	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:u	()V
    //   197: aload_0
    //   198: bipush 8
    //   200: putfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   203: aload_0
    //   204: invokespecial 791	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:p	()V
    //   207: aload_0
    //   208: getfield 188	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   211: ifnonnull +23 -> 234
    //   214: aload_0
    //   215: new 2342	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator
    //   218: dup
    //   219: aload_0
    //   220: aconst_null
    //   221: invokespecial 2343	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$1;)V
    //   224: putfield 188	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   227: aload_0
    //   228: getfield 188	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   231: invokevirtual 2345	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:a	()V
    //   234: aload_0
    //   235: invokespecial 2347	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:d	()Ljava/util/ArrayList;
    //   238: astore 4
    //   240: aload 4
    //   242: astore_3
    //   243: aload 4
    //   245: ifnonnull +12 -> 257
    //   248: new 190	java/util/ArrayList
    //   251: dup
    //   252: iconst_0
    //   253: invokespecial 1074	java/util/ArrayList:<init>	(I)V
    //   256: astore_3
    //   257: aload_0
    //   258: getfield 201	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_m_of_type_Boolean	Z
    //   261: ifeq +14 -> 275
    //   264: aload_0
    //   265: iconst_1
    //   266: aload_3
    //   267: invokevirtual 541	java/util/ArrayList:size	()I
    //   270: iconst_0
    //   271: iconst_0
    //   272: invokespecial 814	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(IIII)V
    //   275: new 933	mqq/app/NewIntent
    //   278: dup
    //   279: aload_0
    //   280: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   283: invokevirtual 343	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   286: ldc_w 935
    //   289: invokespecial 938	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   292: astore 4
    //   294: aload 4
    //   296: ldc_w 940
    //   299: bipush 31
    //   301: invokevirtual 944	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   304: pop
    //   305: aload 4
    //   307: ldc_w 946
    //   310: aload_0
    //   311: invokevirtual 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   314: invokevirtual 949	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   317: pop
    //   318: aload 4
    //   320: ldc_w 960
    //   323: lconst_0
    //   324: invokevirtual 963	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   327: pop
    //   328: aload 4
    //   330: ldc_w 965
    //   333: iconst_0
    //   334: invokevirtual 944	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   337: pop
    //   338: aload 4
    //   340: ldc_w 2349
    //   343: aload_3
    //   344: invokevirtual 954	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   347: pop
    //   348: aload 4
    //   350: ldc 248
    //   352: iconst_0
    //   353: newarray byte
    //   355: invokevirtual 968	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   358: pop
    //   359: aload 4
    //   361: ldc_w 970
    //   364: iconst_0
    //   365: invokevirtual 973	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   368: pop
    //   369: aload_0
    //   370: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   373: aload 4
    //   375: invokevirtual 977	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   378: iconst_1
    //   379: istore_1
    //   380: goto -253 -> 127
    //   383: astore_3
    //   384: aload_0
    //   385: monitorexit
    //   386: aload_3
    //   387: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	PhoneContactManagerImp
    //   39	341	1	bool1	boolean
    //   1	136	2	bool2	boolean
    //   19	325	3	localObject1	Object
    //   383	4	3	localObject2	Object
    //   27	347	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	38	383	finally
    //   40	96	383	finally
    //   98	107	383	finally
    //   109	121	383	finally
    //   138	169	383	finally
    //   169	193	383	finally
    //   193	197	383	finally
    //   197	234	383	finally
    //   234	240	383	finally
    //   248	257	383	finally
    //   257	275	383	finally
    //   275	378	383	finally
  }
  
  public int d()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      this.jdField_a_of_type_Int = a(a());
      return d();
    case 8: 
      return 8;
    case 9: 
      return 9;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public List<PhoneContact> d()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, localException.toString());
        }
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PhoneContact.class);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PhoneContact.class);
  }
  
  public void d()
  {
    this.jdField_h_of_type_Boolean = false;
  }
  
  public void d(List<AddressBookItem> paramList)
  {
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = this.jdField_j_of_type_Boolean;
        if (bool) {
          return;
        }
        if ((paramList == null) || (paramList.isEmpty())) {
          continue;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        try
        {
          localEntityTransaction.begin();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.end();
        }
        localEntityTransaction.commit();
      }
      finally {}
      localEntityTransaction.end();
      this.jdField_c_of_type_Int += 1;
    }
  }
  
  public boolean d()
  {
    int i1 = d();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isBindContactOk = " + i1);
    }
    return i1 >= 9;
  }
  
  public int e()
  {
    return this.jdField_c_of_type_AndroidContentSharedPreferences.getInt("key_config_version", 0);
  }
  
  public List<List<PhoneContact>> e()
  {
    Object localObject1 = null;
    long l1 = System.currentTimeMillis();
    if (this.jdField_j_of_type_Boolean) {
      localObject1 = new ArrayList(0);
    }
    Object localObject2;
    label354:
    do
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      FriendsManager localFriendsManager;
      do
      {
        return localObject1;
        if (this.jdField_f_of_type_JavaUtilList != null) {
          break label468;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        Collections.sort((List)localObject2, new PhoneContactManagerImp.13(this));
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (((List)localObject2).size() <= 0) {
          break;
        }
      } while (a() == null);
      String str = a().mobileNo;
      Iterator localIterator = ((List)localObject2).iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = (PhoneContact)localIterator.next();
        if ((str == null) || (!str.endsWith(((PhoneContact)localObject2).mobileNo.trim())))
        {
          PhoneContact localPhoneContact = (PhoneContact)((PhoneContact)localObject2).clone();
          if (TextUtils.isEmpty(localPhoneContact.uin))
          {
            if (localObject1 == null) {
              localObject1 = localPhoneContact;
            }
            for (;;)
            {
              break;
              if (localPhoneContact.contactID == ((PhoneContact)localObject1).contactID)
              {
                ((PhoneContact)localObject1).mobileNo = (((PhoneContact)localObject1).mobileNo + "|" + localPhoneContact.mobileNo);
                if (!QLog.isColorLevel()) {
                  break label395;
                }
                QLog.d("PhoneContact.Manager", 2, "getContactListForDisplay: conbine contact contact name is:" + ((PhoneContact)localObject1).name + "uin is :" + ((PhoneContact)localObject1).uin + "number is:" + ((PhoneContact)localObject1).mobileNo);
              }
              else
              {
                localArrayList2.add(localObject1);
                localObject1 = localPhoneContact;
              }
            }
          }
          if (localPhoneContact.uin.equals("0"))
          {
            localObject2 = null;
            if ((localObject2 == null) || (((Friends)localObject2).groupid < 0)) {
              break label413;
            }
            localPhoneContact.nickName = ((Friends)localObject2).getFriendNick();
            localPhoneContact.remark = ((Friends)localObject2).remark;
          }
          for (;;)
          {
            localArrayList1.add(localPhoneContact);
            break;
            localObject2 = localFriendsManager.e(localPhoneContact.uin);
            break label354;
            localPhoneContact.uin = "0";
          }
        }
      }
      if (localObject1 != null) {
        localArrayList2.add(localObject1);
      }
      localObject1 = new PhoneContactManagerImp.14(this);
      Collections.sort(localArrayList1, (Comparator)localObject1);
      Collections.sort(localArrayList2, (Comparator)localObject1);
      this.jdField_f_of_type_JavaUtilList = localArrayList1;
      this.jdField_g_of_type_JavaUtilList = localArrayList2;
      localObject2 = new ArrayList();
      c(this.jdField_f_of_type_JavaUtilList);
      c(this.jdField_g_of_type_JavaUtilList);
      ((List)localObject2).add(this.jdField_f_of_type_JavaUtilList);
      ((List)localObject2).add(this.jdField_g_of_type_JavaUtilList);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    label395:
    label413:
    label468:
    QLog.d("PhoneContact.Manager", 2, "sort contact cost time: " + (System.currentTimeMillis() - l1));
    return localObject2;
  }
  
  public void e()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PhoneContact.class);
      if (??? != null)
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)???).next();
          localPhoneContact.pinyinFirst = PhoneContactHelper.b(localPhoneContact.pinyinInitial);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
          if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0"))) {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
            this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.unifiedCode, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.md5)) {
            this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.md5, localPhoneContact);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "No contacts.");
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ContactMatch.class, false, null, null, null, null, null, null));
      this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PhoneContactAdd.class, false, null, null, null, null, null, null));
      jdField_b_of_type_Int = this.jdField_c_of_type_AndroidContentSharedPreferences.getInt("all_entrance_num", 20);
      m();
      this.jdField_d_of_type_Boolean = true;
      a(1);
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("initContactCache [%s]", new Object[] { Integer.valueOf(jdField_b_of_type_Int) }));
      }
      return;
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Int == 4) {}
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    label87:
    do
    {
      return true;
      localRespondQueryQQBindingStat = a();
      String str;
      if (QLog.isColorLevel())
      {
        if (localRespondQueryQQBindingStat != null)
        {
          str = localRespondQueryQQBindingStat.toString();
          QLog.d("PhoneContact.Manager", 2, new Object[] { "isAutoUploadContactsNotBind", str });
        }
      }
      else
      {
        if (this.jdField_a_of_type_Int != 3) {
          continue;
        }
        if (localRespondQueryQQBindingStat == null) {
          break;
        }
        if (a().lastUsedFlag != 2L) {
          break label87;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        return bool;
        str = "";
        break;
      }
    } while ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.continueUploadNotbind));
    return false;
  }
  
  public List<PhoneContact> f()
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_i_of_type_JavaUtilList == null) || (this.jdField_i_of_type_JavaUtilList.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      if (localArrayList.size() > 0)
      {
        if (a() == null) {
          return null;
        }
        localArrayList.remove(b(a().mobileNo));
        Collections.sort(localArrayList, new PhoneContactManagerImp.16(this));
      }
      this.jdField_i_of_type_JavaUtilList = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForSelector sort contact cost time: " + (System.currentTimeMillis() - l1));
    }
    return this.jdField_i_of_type_JavaUtilList;
  }
  
  public void f()
  {
    a(1);
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Int == 8) {}
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_Int != 6) {
          break;
        }
        if (a() == null) {
          break label70;
        }
      } while (a().lastUsedFlag == 2L);
      return false;
      if (this.jdField_a_of_type_Int != 7) {
        break;
      }
      localRespondQueryQQBindingStat = a();
      if (localRespondQueryQQBindingStat == null) {
        break;
      }
    } while (!localRespondQueryQQBindingStat.isStopFindMatch);
    return false;
    label70:
    return false;
  }
  
  public List<PhoneContact> g()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.jdField_j_of_type_JavaUtilList == null) || (this.jdField_j_of_type_JavaUtilList.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          localArrayList.add(localPhoneContact);
        } else if ((!localPhoneContact.uin.equals("0")) && (((FriendsManager)localObject1).e(localPhoneContact.uin) != null)) {
          localArrayList.add(localPhoneContact);
        }
      }
      if (localArrayList.size() > 0)
      {
        if (a() == null) {
          return null;
        }
        localArrayList.remove(b(a().mobileNo));
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PhoneContact)((Iterator)localObject1).next();
          if (((PhoneContact)localObject2).pinyinFirst == null) {
            ((PhoneContact)localObject2).pinyinFirst = PhoneContactHelper.b(((PhoneContact)localObject2).pinyinInitial);
          }
        }
        Collections.sort(localArrayList, new PhoneContactManagerImp.17(this));
      }
      this.jdField_j_of_type_JavaUtilList = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForPhoneSelector sort contact cost time: " + (System.currentTimeMillis() - l1));
    }
    return this.jdField_j_of_type_JavaUtilList;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean g()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 126	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 318	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 497	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_0
    //   20: getfield 431	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 431	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   30: iconst_1
    //   31: putfield 1121	com/tencent/mobileqq/data/ContactBinded:isReaded	Z
    //   34: aload_0
    //   35: getfield 1073	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   38: ifnull +82 -> 120
    //   41: aload_0
    //   42: getfield 1073	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   45: invokevirtual 541	java/util/ArrayList:size	()I
    //   48: ifle +72 -> 120
    //   51: aload_0
    //   52: getfield 1073	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   55: invokevirtual 1076	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 631 1 0
    //   65: ifeq +55 -> 120
    //   68: aload_3
    //   69: invokeinterface 635 1 0
    //   74: checkcast 1078	com/tencent/mobileqq/data/ContactMatch
    //   77: astore 4
    //   79: aload 4
    //   81: iconst_1
    //   82: putfield 2390	com/tencent/mobileqq/data/ContactMatch:isReaded	Z
    //   85: aload_0
    //   86: aload 4
    //   88: invokevirtual 1113	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   91: pop
    //   92: goto -33 -> 59
    //   95: astore_3
    //   96: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +14 -> 113
    //   102: ldc_w 280
    //   105: iconst_2
    //   106: ldc_w 2392
    //   109: aload_3
    //   110: invokestatic 530	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_2
    //   114: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   117: aload_1
    //   118: monitorexit
    //   119: return
    //   120: aload_2
    //   121: invokevirtual 662	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   124: aload_2
    //   125: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   128: goto -11 -> 117
    //   131: astore_2
    //   132: aload_1
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    //   136: astore_3
    //   137: aload_2
    //   138: invokevirtual 533	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   141: aload_3
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	PhoneContactManagerImp
    //   4	129	1	localObject1	Object
    //   14	111	2	localEntityTransaction	EntityTransaction
    //   131	7	2	localObject2	Object
    //   58	11	3	localIterator	Iterator
    //   95	15	3	localException	Exception
    //   136	6	3	localObject3	Object
    //   77	10	4	localContactMatch	ContactMatch
    // Exception table:
    //   from	to	target	type
    //   15	34	95	java/lang/Exception
    //   34	59	95	java/lang/Exception
    //   59	92	95	java/lang/Exception
    //   120	124	95	java/lang/Exception
    //   7	15	131	finally
    //   113	117	131	finally
    //   117	119	131	finally
    //   124	128	131	finally
    //   132	134	131	finally
    //   137	143	131	finally
    //   15	34	136	finally
    //   34	59	136	finally
    //   59	92	136	finally
    //   96	113	136	finally
    //   120	124	136	finally
  }
  
  /* Error */
  public boolean h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 468	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 474	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   16: iconst_1
    //   17: anewarray 72	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 74
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: ldc_w 2394
    //   30: invokevirtual 480	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: invokeinterface 488 1 0
    //   47: istore_1
    //   48: iload_1
    //   49: ifle +79 -> 128
    //   52: iconst_1
    //   53: istore_2
    //   54: aload 4
    //   56: ifnull +10 -> 66
    //   59: aload 4
    //   61: invokeinterface 536 1 0
    //   66: iload_2
    //   67: ireturn
    //   68: astore 5
    //   70: aconst_null
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 5
    //   78: invokevirtual 1329	java/lang/Exception:printStackTrace	()V
    //   81: aload 4
    //   83: ifnull +43 -> 126
    //   86: aload 4
    //   88: invokeinterface 536 1 0
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_3
    //   96: aload 4
    //   98: ifnull +10 -> 108
    //   101: aload 4
    //   103: invokeinterface 536 1 0
    //   108: aload_3
    //   109: athrow
    //   110: astore 5
    //   112: aload_3
    //   113: astore 4
    //   115: aload 5
    //   117: astore_3
    //   118: goto -22 -> 96
    //   121: astore 5
    //   123: goto -50 -> 73
    //   126: iconst_0
    //   127: ireturn
    //   128: iconst_0
    //   129: istore_2
    //   130: goto -76 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	PhoneContactManagerImp
    //   47	2	1	i1	int
    //   53	77	2	bool	boolean
    //   33	43	3	localObject1	Object
    //   95	18	3	localObject2	Object
    //   117	1	3	localObject3	Object
    //   1	113	4	localObject4	Object
    //   68	9	5	localException1	Exception
    //   110	6	5	localObject5	Object
    //   121	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   3	34	68	java/lang/Exception
    //   3	34	95	finally
    //   40	48	110	finally
    //   76	81	110	finally
    //   40	48	121	java/lang/Exception
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "OnDisableMobileBindSuc");
    }
    this.jdField_a_of_type_Int = 7;
    a(true, true, 22L);
  }
  
  public boolean i()
  {
    return d() > 5;
  }
  
  public void j()
  {
    int i1 = d();
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "uploadOrUpdateContact state: " + i1);
    }
    if (i1 > 5)
    {
      if (i1 == 9)
      {
        o();
        return;
      }
      c();
      return;
    }
    if (i1 == 2)
    {
      r();
      return;
    }
    j();
  }
  
  /* Error */
  public boolean j()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +77 -> 84
    //   10: new 226	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 992	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 2402
    //   24: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   31: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: ldc_w 2404
    //   39: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   46: invokevirtual 911	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: ldc_w 1464
    //   54: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   60: aload_0
    //   61: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   64: lsub
    //   65: ldc2_w 1010
    //   68: ldiv
    //   69: invokevirtual 997	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc_w 280
    //   76: iconst_2
    //   77: aload_3
    //   78: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_0
    //   85: getfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   88: iconst_4
    //   89: if_icmpeq +17 -> 106
    //   92: aload_0
    //   93: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   96: ifne +10 -> 106
    //   99: aload_0
    //   100: invokevirtual 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   103: ifnonnull +42 -> 145
    //   106: iload_2
    //   107: istore_1
    //   108: aload_0
    //   109: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   112: ifeq +29 -> 141
    //   115: aload_0
    //   116: getfield 242	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   119: invokeinterface 768 1 0
    //   124: ldc_w 1738
    //   127: iconst_1
    //   128: invokeinterface 800 3 0
    //   133: invokeinterface 802 1 0
    //   138: pop
    //   139: iload_2
    //   140: istore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: iload_1
    //   144: ireturn
    //   145: iload_2
    //   146: istore_1
    //   147: invokestatic 462	java/lang/System:currentTimeMillis	()J
    //   150: aload_0
    //   151: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   154: lsub
    //   155: ldc2_w 63
    //   158: lcmp
    //   159: iflt -18 -> 141
    //   162: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +13 -> 178
    //   168: ldc_w 280
    //   171: iconst_2
    //   172: ldc_w 2406
    //   175: invokestatic 388	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_0
    //   179: getfield 242	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   182: invokeinterface 768 1 0
    //   187: ldc_w 1738
    //   190: iconst_0
    //   191: invokeinterface 800 3 0
    //   196: invokeinterface 802 1 0
    //   201: pop
    //   202: aload_0
    //   203: iconst_4
    //   204: putfield 115	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   207: aload_0
    //   208: invokespecial 791	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:p	()V
    //   211: aload_0
    //   212: getfield 188	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   215: ifnonnull +23 -> 238
    //   218: aload_0
    //   219: new 2342	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator
    //   222: dup
    //   223: aload_0
    //   224: aconst_null
    //   225: invokespecial 2343	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$1;)V
    //   228: putfield 188	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   231: aload_0
    //   232: getfield 188	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   235: invokevirtual 2345	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:a	()V
    //   238: aload_0
    //   239: invokespecial 2347	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:d	()Ljava/util/ArrayList;
    //   242: astore 4
    //   244: aload 4
    //   246: astore_3
    //   247: aload 4
    //   249: ifnonnull +12 -> 261
    //   252: new 190	java/util/ArrayList
    //   255: dup
    //   256: iconst_0
    //   257: invokespecial 1074	java/util/ArrayList:<init>	(I)V
    //   260: astore_3
    //   261: aload_0
    //   262: getfield 201	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_m_of_type_Boolean	Z
    //   265: ifeq +14 -> 279
    //   268: aload_0
    //   269: iconst_1
    //   270: aload_3
    //   271: invokevirtual 541	java/util/ArrayList:size	()I
    //   274: iconst_0
    //   275: iconst_0
    //   276: invokespecial 814	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(IIII)V
    //   279: new 933	mqq/app/NewIntent
    //   282: dup
    //   283: aload_0
    //   284: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   287: invokevirtual 343	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   290: ldc_w 935
    //   293: invokespecial 938	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   296: astore 4
    //   298: aload 4
    //   300: ldc_w 940
    //   303: bipush 37
    //   305: invokevirtual 944	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   308: pop
    //   309: aload 4
    //   311: ldc_w 946
    //   314: aload_0
    //   315: invokevirtual 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   318: invokevirtual 949	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   321: pop
    //   322: aload 4
    //   324: ldc_w 960
    //   327: lconst_0
    //   328: invokevirtual 963	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   331: pop
    //   332: aload 4
    //   334: ldc_w 965
    //   337: iconst_0
    //   338: invokevirtual 944	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   341: pop
    //   342: aload 4
    //   344: ldc_w 2349
    //   347: aload_3
    //   348: invokevirtual 954	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   351: pop
    //   352: aload 4
    //   354: ldc 248
    //   356: iconst_0
    //   357: newarray byte
    //   359: invokevirtual 968	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   362: pop
    //   363: aload 4
    //   365: ldc_w 970
    //   368: iconst_0
    //   369: invokevirtual 973	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   372: pop
    //   373: aload_0
    //   374: getfield 208	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   377: aload 4
    //   379: invokevirtual 977	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   382: iconst_1
    //   383: istore_1
    //   384: goto -243 -> 141
    //   387: astore_3
    //   388: aload_0
    //   389: monitorexit
    //   390: aload_3
    //   391: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	PhoneContactManagerImp
    //   107	277	1	bool1	boolean
    //   1	145	2	bool2	boolean
    //   19	329	3	localObject1	Object
    //   387	4	3	localObject2	Object
    //   242	136	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	84	387	finally
    //   84	106	387	finally
    //   108	139	387	finally
    //   147	178	387	finally
    //   178	238	387	finally
    //   238	244	387	finally
    //   252	261	387	finally
    //   261	279	387	finally
    //   279	382	387	finally
  }
  
  public void k()
  {
    int i1 = d();
    if (i1 > 5) {
      if (i1 == 9)
      {
        this.jdField_m_of_type_Boolean = false;
        if (!this.jdField_d_of_type_Boolean) {
          e();
        }
        a(3, this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size(), 100, 100);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, String.format("markAndUploadForNewGuide [%s, %s]", new Object[] { Integer.valueOf(i1), Boolean.valueOf(this.jdField_m_of_type_Boolean) }));
      }
      return;
      this.jdField_m_of_type_Boolean = true;
      c();
      continue;
      if (i1 == 2)
      {
        this.jdField_m_of_type_Boolean = false;
        if (!this.jdField_d_of_type_Boolean) {
          e();
        }
        a(3, this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size(), 100, 100);
      }
      else
      {
        this.jdField_m_of_type_Boolean = true;
        j();
      }
    }
  }
  
  public boolean k()
  {
    if (VersionUtils.k()) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(PermissionChecker.a("android.permission.READ_CONTACTS"));
    }
    for (;;)
    {
      ThreadManager.excute(new PhoneContactManagerImp.20(this), 16, null, true);
      if (QLog.isColorLevel()) {
        QLog.d("contact.PermissionChecker", 2, String.format("hasReadContactPermissionForUI isM=%b has=%b", new Object[] { Boolean.valueOf(VersionUtils.k()), this.jdField_a_of_type_JavaLangBoolean }));
      }
      return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
      if (this.jdField_a_of_type_JavaLangBoolean == null) {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
    }
  }
  
  public boolean l()
  {
    boolean bool1;
    boolean bool2;
    if (VersionUtils.k())
    {
      bool1 = PermissionChecker.a("android.permission.READ_CONTACTS");
      if (!bool1) {
        break label75;
      }
      bool1 = h();
      bool2 = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
      QLog.d("contact.PermissionChecker", 1, String.format("hasReadContactPermission2 isM=%b has=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      return bool1;
      bool1 = h();
      bool2 = false;
      continue;
      label75:
      bool2 = true;
    }
  }
  
  public boolean m()
  {
    boolean bool1;
    if (VersionUtils.k()) {
      bool1 = PermissionChecker.a("android.permission.READ_CONTACTS");
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
      if (QLog.isColorLevel()) {
        QLog.d("contact.PermissionChecker", 2, String.format("hasReadContactPermission3 isM=%b has=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
      bool1 = h();
    }
  }
  
  public boolean n()
  {
    boolean bool = false;
    int i1 = d();
    if ((i1 == 6) || (i1 == 7) || (i1 == 5) || (i1 == 1) || (i1 == 3)) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "needUploadContact [" + i1 + ", " + bool + "]");
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.jdField_j_of_type_Boolean = true;
    this.jdField_g_of_type_JavaUtilList = null;
    this.jdField_f_of_type_JavaUtilList = null;
    this.jdField_i_of_type_JavaUtilList = null;
    this.jdField_k_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver2);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    a();
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionChecker != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionChecker.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp
 * JD-Core Version:    0.7.0.1
 */