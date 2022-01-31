package com.tencent.mobileqq.app;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.database.StaleDataException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.adapter.ContactBindedAdapter.ContactBindedData;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import zif;
import zig;
import zih;
import zii;
import zij;
import zik;
import zil;
import zim;
import zin;
import zio;
import zip;
import ziq;
import zit;
import ziu;
import ziv;
import ziw;
import zix;
import ziy;
import ziz;
import zja;
import zjb;
import zjc;
import zjd;
import zje;
import zjh;
import zji;

public class PhoneContactManagerImp
  implements PhoneContactManager
{
  public static volatile long a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b;
  public static int e;
  public static int f;
  public static boolean g;
  public volatile int a;
  public SharedPreferences a;
  public ContactBindedAdapter.ContactBindedData a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ContactBinded jdField_a_of_type_ComTencentMobileqqDataContactBinded;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ziq(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new ziz(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public volatile List a;
  private volatile Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private zje jdField_a_of_type_Zje;
  private zjh jdField_a_of_type_Zjh;
  private zji jdField_a_of_type_Zji;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public volatile long b;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private Runnable jdField_b_of_type_JavaLangRunnable = new zii(this);
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean b;
  public volatile int c;
  public volatile long c;
  private SharedPreferences jdField_c_of_type_AndroidContentSharedPreferences;
  private List jdField_c_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean c;
  public int d;
  public volatile long d;
  private List jdField_d_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean d;
  public long e;
  private List jdField_e_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_e_of_type_Boolean;
  private List jdField_f_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean f;
  private volatile List jdField_g_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap;
  private List h;
  public boolean h;
  private List jdField_i_of_type_JavaUtilList;
  private boolean jdField_i_of_type_Boolean;
  private List jdField_j_of_type_JavaUtilList;
  private boolean jdField_j_of_type_Boolean;
  private List jdField_k_of_type_JavaUtilList;
  private volatile boolean jdField_k_of_type_Boolean;
  private List l;
  
  static
  {
    jdField_a_of_type_Long = 120000L;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "data1", "display_name", "contact_id", "data2", "data3" };
    jdField_b_of_type_Int = 20;
    jdField_f_of_type_Int = 2;
  }
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_new_friend", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("contact_bind_info_global", 0);
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("session_id", "").getBytes();
    jdField_a_of_type_Long = this.jdField_b_of_type_AndroidContentSharedPreferences.getLong("query_contact_list_min_interval", jdField_a_of_type_Long);
    this.jdField_a_of_type_Int = a(a());
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    ThreadManager.post(new zif(this), 2, null, false);
  }
  
  private int a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (paramRespondQueryQQBindingStat == null) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "getSelfBindState : " + a() + " " + paramRespondQueryQQBindingStat.mobileNo + " " + paramRespondQueryQQBindingStat.originBinder + " " + paramRespondQueryQQBindingStat.MobileUniqueNo + " " + paramRespondQueryQQBindingStat.lastUsedFlag + " " + paramRespondQueryQQBindingStat.isRecommend + " " + paramRespondQueryQQBindingStat.bindingTime + " " + this.jdField_i_of_type_Boolean);
      }
      if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.mobileNo))
      {
        if (!paramRespondQueryQQBindingStat.noBindUploadContactsLocal) {
          return 1;
        }
        if (!paramRespondQueryQQBindingStat.isPhoneSwitched) {
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
  
  public static int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    Object localObject2 = paramPhoneContact1.pinyinFirst;
    String str = paramPhoneContact2.pinyinFirst;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("#")) {
      localObject1 = "Za";
    }
    localObject2 = str;
    if (str.endsWith("#")) {
      localObject2 = "Za";
    }
    int n = ((String)localObject1).compareTo((String)localObject2);
    int m = n;
    if (n == 0) {
      m = paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
    }
    return m;
  }
  
  private String a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramString;
    }
    paramString = paramString.getBytes();
    int n = paramString.length;
    paramArrayOfByte = a(paramArrayOfByte);
    paramString = a(paramString);
    int m = 0;
    while (m < n)
    {
      paramArrayOfByte[m] = ((byte)(paramString[m] ^ paramArrayOfByte[m]));
      m += 1;
    }
    n = paramArrayOfByte.length;
    m = n - 1;
    if (m >= 0) {
      if (paramArrayOfByte[m] == 0) {}
    }
    for (;;)
    {
      if (m != n - 1)
      {
        paramString = new byte[m + 1];
        System.arraycopy(paramArrayOfByte, 0, paramString, 0, m + 1);
        paramArrayOfByte = paramString;
      }
      for (;;)
      {
        return new String(a(paramArrayOfByte));
        m -= 1;
        break;
      }
      m = 0;
    }
  }
  
  /* Error */
  private ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    // Byte code:
    //   0: new 354	java/util/HashMap
    //   3: dup
    //   4: invokespecial 355	java/util/HashMap:<init>	()V
    //   7: astore 12
    //   9: new 133	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 134	java/util/ArrayList:<init>	()V
    //   16: astore 11
    //   18: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: aload_0
    //   24: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: invokevirtual 363	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   33: astore 7
    //   35: aload 7
    //   37: getstatic 369	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   40: getstatic 60	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +248 -> 301
    //   56: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +36 -> 95
    //   62: ldc_w 377
    //   65: iconst_2
    //   66: new 156	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 379
    //   76: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 8
    //   81: invokeinterface 385 1 0
    //   86: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aconst_null
    //   96: astore 7
    //   98: aload_0
    //   99: getfield 216	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   102: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   105: astore 9
    //   107: aload 9
    //   109: astore 7
    //   111: aload 7
    //   113: invokevirtual 397	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   116: aload 8
    //   118: invokeinterface 400 1 0
    //   123: pop
    //   124: aload 8
    //   126: invokeinterface 403 1 0
    //   131: ifne +671 -> 802
    //   134: aload 8
    //   136: aload 8
    //   138: ldc 50
    //   140: invokeinterface 406 2 0
    //   145: invokeinterface 409 2 0
    //   150: invokestatic 414	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore 10
    //   155: aload 8
    //   157: aload 8
    //   159: ldc 52
    //   161: invokeinterface 406 2 0
    //   166: invokeinterface 409 2 0
    //   171: astore 9
    //   173: aload 9
    //   175: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifeq +1009 -> 1187
    //   181: aload 10
    //   183: astore 9
    //   185: aload 8
    //   187: aload 8
    //   189: ldc 54
    //   191: invokeinterface 406 2 0
    //   196: invokeinterface 418 2 0
    //   201: istore_3
    //   202: aload 8
    //   204: aload 8
    //   206: ldc 56
    //   208: invokeinterface 406 2 0
    //   213: invokeinterface 418 2 0
    //   218: istore 4
    //   220: aload 8
    //   222: aload 8
    //   224: ldc 58
    //   226: invokeinterface 406 2 0
    //   231: invokeinterface 409 2 0
    //   236: astore 13
    //   238: aload 10
    //   240: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +11 -> 254
    //   246: aload 9
    //   248: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifeq +176 -> 427
    //   254: aload 8
    //   256: invokeinterface 421 1 0
    //   261: pop
    //   262: goto -138 -> 124
    //   265: astore 9
    //   267: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +14 -> 284
    //   273: ldc_w 377
    //   276: iconst_2
    //   277: ldc 180
    //   279: aload 9
    //   281: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: aload 7
    //   286: ifnull +8 -> 294
    //   289: aload 7
    //   291: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   294: aload 8
    //   296: invokeinterface 429 1 0
    //   301: aload_0
    //   302: iconst_0
    //   303: putfield 108	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_h_of_type_Boolean	Z
    //   306: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +35 -> 344
    //   312: ldc_w 377
    //   315: iconst_2
    //   316: new 156	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 431
    //   326: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   332: lload 5
    //   334: lsub
    //   335: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   338: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +33 -> 380
    //   350: ldc_w 377
    //   353: iconst_2
    //   354: new 156	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 433
    //   364: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: invokevirtual 436	java/util/ArrayList:size	()I
    //   371: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +33 -> 416
    //   386: ldc_w 377
    //   389: iconst_2
    //   390: new 156	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 438
    //   400: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_2
    //   404: invokevirtual 436	java/util/ArrayList:size	()I
    //   407: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload 11
    //   418: areturn
    //   419: astore 7
    //   421: aconst_null
    //   422: astore 8
    //   424: goto -373 -> 51
    //   427: aload_0
    //   428: getfield 110	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   431: aload 10
    //   433: invokevirtual 442	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   436: checkcast 306	com/tencent/mobileqq/data/PhoneContact
    //   439: astore 14
    //   441: aload 14
    //   443: ifnonnull +174 -> 617
    //   446: new 306	com/tencent/mobileqq/data/PhoneContact
    //   449: dup
    //   450: invokespecial 443	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   453: astore 14
    //   455: aload 14
    //   457: aload 10
    //   459: putfield 444	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   462: aload 14
    //   464: aload 9
    //   466: putfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   469: aload 14
    //   471: iload_3
    //   472: putfield 450	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   475: aload 14
    //   477: iload 4
    //   479: putfield 453	com/tencent/mobileqq/data/PhoneContact:type	I
    //   482: aload 14
    //   484: aload 13
    //   486: putfield 456	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   489: aload 14
    //   491: lload 5
    //   493: putfield 459	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   496: aload 14
    //   498: aload 9
    //   500: iconst_1
    //   501: invokestatic 464	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   504: putfield 323	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   507: aload 14
    //   509: aload 9
    //   511: iconst_2
    //   512: invokestatic 464	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   515: putfield 467	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   518: aload 14
    //   520: aload 14
    //   522: getfield 467	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   525: invokestatic 469	com/tencent/mobileqq/app/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   528: putfield 309	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   531: aload_0
    //   532: getfield 110	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   535: aload 10
    //   537: aload 14
    //   539: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   542: pop
    //   543: aload 14
    //   545: aload 9
    //   547: aload 10
    //   549: invokestatic 475	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   552: putfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   555: aload_0
    //   556: getfield 116	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   559: aload 14
    //   561: getfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   564: aload 14
    //   566: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   569: pop
    //   570: aload 11
    //   572: aload 14
    //   574: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   577: pop
    //   578: aload_1
    //   579: new 483	SecurityAccountServer/AddressBookItem
    //   582: dup
    //   583: aload 10
    //   585: aload 9
    //   587: invokespecial 486	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   593: pop
    //   594: goto -340 -> 254
    //   597: astore_1
    //   598: aload 7
    //   600: ifnull +8 -> 608
    //   603: aload 7
    //   605: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   608: aload 8
    //   610: invokeinterface 429 1 0
    //   615: aload_1
    //   616: athrow
    //   617: aload 14
    //   619: iload_3
    //   620: putfield 450	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   623: aload 14
    //   625: lload 5
    //   627: putfield 459	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   630: aload 14
    //   632: getfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   635: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   638: ifeq +33 -> 671
    //   641: aload 14
    //   643: aload 14
    //   645: getfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   648: aload 10
    //   650: invokestatic 475	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   653: putfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   656: aload_0
    //   657: getfield 116	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   660: aload 14
    //   662: getfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   665: aload 14
    //   667: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   670: pop
    //   671: aload 14
    //   673: getfield 489	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   676: ifeq +99 -> 775
    //   679: aload 9
    //   681: aload 14
    //   683: getfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   686: invokevirtual 296	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   689: ifne +75 -> 764
    //   692: aload 12
    //   694: aload 10
    //   696: aload 9
    //   698: invokevirtual 490	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   701: pop
    //   702: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq -451 -> 254
    //   708: ldc_w 377
    //   711: iconst_2
    //   712: new 156	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 492
    //   722: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload 14
    //   727: getfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   730: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: ldc_w 494
    //   736: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: aload 9
    //   741: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: ldc_w 496
    //   747: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload 10
    //   752: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: goto -507 -> 254
    //   764: aload 12
    //   766: aload 10
    //   768: invokevirtual 499	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   771: pop
    //   772: goto -518 -> 254
    //   775: aload_1
    //   776: new 483	SecurityAccountServer/AddressBookItem
    //   779: dup
    //   780: aload 10
    //   782: aload 9
    //   784: invokespecial 486	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   787: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   790: pop
    //   791: aload 11
    //   793: aload 14
    //   795: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   798: pop
    //   799: goto -545 -> 254
    //   802: aload 12
    //   804: invokevirtual 503	java/util/HashMap:keySet	()Ljava/util/Set;
    //   807: invokeinterface 509 1 0
    //   812: astore 9
    //   814: aload 9
    //   816: invokeinterface 514 1 0
    //   821: ifeq +176 -> 997
    //   824: aload 9
    //   826: invokeinterface 518 1 0
    //   831: checkcast 48	java/lang/String
    //   834: astore 10
    //   836: aload_0
    //   837: getfield 110	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   840: aload 10
    //   842: invokevirtual 442	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   845: checkcast 306	com/tencent/mobileqq/data/PhoneContact
    //   848: astore 13
    //   850: aload 13
    //   852: ifnull -38 -> 814
    //   855: aload 12
    //   857: aload 10
    //   859: invokevirtual 519	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   862: checkcast 48	java/lang/String
    //   865: astore 14
    //   867: aload_2
    //   868: new 483	SecurityAccountServer/AddressBookItem
    //   871: dup
    //   872: aload 10
    //   874: aload 13
    //   876: getfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   879: invokespecial 486	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   882: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   885: pop
    //   886: aload_1
    //   887: new 483	SecurityAccountServer/AddressBookItem
    //   890: dup
    //   891: aload 10
    //   893: aload 14
    //   895: invokespecial 486	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   901: pop
    //   902: aload 13
    //   904: aload 14
    //   906: putfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   909: aload 13
    //   911: aload 14
    //   913: iconst_1
    //   914: invokestatic 464	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   917: putfield 323	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   920: aload 13
    //   922: aload 14
    //   924: iconst_2
    //   925: invokestatic 464	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   928: putfield 467	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   931: aload 13
    //   933: aload 13
    //   935: getfield 467	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   938: invokestatic 469	com/tencent/mobileqq/app/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   941: putfield 309	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   944: aload_0
    //   945: getfield 116	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   948: aload 13
    //   950: getfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   953: aload 13
    //   955: invokevirtual 522	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   958: pop
    //   959: aload 13
    //   961: aload 14
    //   963: aload 10
    //   965: invokestatic 475	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   968: putfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   971: aload_0
    //   972: getfield 116	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   975: aload 13
    //   977: getfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   980: aload 13
    //   982: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   985: pop
    //   986: aload 11
    //   988: aload 13
    //   990: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   993: pop
    //   994: goto -180 -> 814
    //   997: new 133	java/util/ArrayList
    //   1000: dup
    //   1001: invokespecial 134	java/util/ArrayList:<init>	()V
    //   1004: astore 9
    //   1006: aload_0
    //   1007: getfield 110	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   1010: invokevirtual 525	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   1013: invokeinterface 509 1 0
    //   1018: astore 10
    //   1020: aload 10
    //   1022: invokeinterface 514 1 0
    //   1027: ifeq +105 -> 1132
    //   1030: aload 10
    //   1032: invokeinterface 518 1 0
    //   1037: checkcast 527	java/util/Map$Entry
    //   1040: invokeinterface 530 1 0
    //   1045: checkcast 306	com/tencent/mobileqq/data/PhoneContact
    //   1048: astore 12
    //   1050: aload 12
    //   1052: getfield 459	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   1055: lload 5
    //   1057: lcmp
    //   1058: ifeq -38 -> 1020
    //   1061: aload 12
    //   1063: getfield 533	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1066: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1069: ifne +16 -> 1085
    //   1072: aload_0
    //   1073: getfield 112	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   1076: aload 12
    //   1078: getfield 533	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1081: invokevirtual 534	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1084: pop
    //   1085: aload 10
    //   1087: invokeinterface 536 1 0
    //   1092: aload_0
    //   1093: getfield 216	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1096: aload 12
    //   1098: invokevirtual 539	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1101: pop
    //   1102: aload_2
    //   1103: new 483	SecurityAccountServer/AddressBookItem
    //   1106: dup
    //   1107: aload 12
    //   1109: getfield 444	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1112: aload 12
    //   1114: getfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1117: invokespecial 486	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1120: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1123: pop
    //   1124: aload 9
    //   1126: invokevirtual 542	java/util/ArrayList:clear	()V
    //   1129: goto -109 -> 1020
    //   1132: aload 7
    //   1134: invokevirtual 544	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   1137: aload 7
    //   1139: ifnull +8 -> 1147
    //   1142: aload 7
    //   1144: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1147: aload 8
    //   1149: invokeinterface 429 1 0
    //   1154: goto -853 -> 301
    //   1157: astore 7
    //   1159: goto -858 -> 301
    //   1162: astore 7
    //   1164: goto -863 -> 301
    //   1167: astore_2
    //   1168: goto -553 -> 615
    //   1171: astore_1
    //   1172: aconst_null
    //   1173: astore 7
    //   1175: goto -577 -> 598
    //   1178: astore_1
    //   1179: goto -581 -> 598
    //   1182: astore 9
    //   1184: goto -917 -> 267
    //   1187: goto -1002 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1190	0	this	PhoneContactManagerImp
    //   0	1190	1	paramArrayList1	ArrayList
    //   0	1190	2	paramArrayList2	ArrayList
    //   201	419	3	m	int
    //   218	260	4	n	int
    //   21	1035	5	l1	long
    //   33	257	7	localObject1	Object
    //   419	724	7	localThrowable	Throwable
    //   1157	1	7	localException1	Exception
    //   1162	1	7	localException2	Exception
    //   1173	1	7	localObject2	Object
    //   49	1099	8	localCursor	Cursor
    //   105	142	9	localObject3	Object
    //   265	518	9	localStaleDataException1	StaleDataException
    //   812	313	9	localObject4	Object
    //   1182	1	9	localStaleDataException2	StaleDataException
    //   153	933	10	localObject5	Object
    //   16	971	11	localArrayList	ArrayList
    //   7	1106	12	localObject6	Object
    //   236	753	13	localObject7	Object
    //   439	523	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   111	124	265	android/database/StaleDataException
    //   124	181	265	android/database/StaleDataException
    //   185	254	265	android/database/StaleDataException
    //   254	262	265	android/database/StaleDataException
    //   427	441	265	android/database/StaleDataException
    //   446	594	265	android/database/StaleDataException
    //   617	671	265	android/database/StaleDataException
    //   671	761	265	android/database/StaleDataException
    //   764	772	265	android/database/StaleDataException
    //   775	799	265	android/database/StaleDataException
    //   802	814	265	android/database/StaleDataException
    //   814	850	265	android/database/StaleDataException
    //   855	994	265	android/database/StaleDataException
    //   997	1020	265	android/database/StaleDataException
    //   1020	1085	265	android/database/StaleDataException
    //   1085	1129	265	android/database/StaleDataException
    //   1132	1137	265	android/database/StaleDataException
    //   35	51	419	java/lang/Throwable
    //   111	124	597	finally
    //   124	181	597	finally
    //   185	254	597	finally
    //   254	262	597	finally
    //   427	441	597	finally
    //   446	594	597	finally
    //   617	671	597	finally
    //   671	761	597	finally
    //   764	772	597	finally
    //   775	799	597	finally
    //   802	814	597	finally
    //   814	850	597	finally
    //   855	994	597	finally
    //   997	1020	597	finally
    //   1020	1085	597	finally
    //   1085	1129	597	finally
    //   1132	1137	597	finally
    //   1147	1154	1157	java/lang/Exception
    //   294	301	1162	java/lang/Exception
    //   608	615	1167	java/lang/Exception
    //   98	107	1171	finally
    //   267	284	1178	finally
    //   98	107	1182	android/database/StaleDataException
  }
  
  private void a(int paramInt)
  {
    if ((paramInt & 0x1) != 0)
    {
      this.jdField_f_of_type_JavaUtilList = null;
      this.jdField_e_of_type_JavaUtilList = null;
      this.jdField_h_of_type_JavaUtilList = null;
      this.jdField_j_of_type_JavaUtilList = null;
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
    this.jdField_g_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zja(this, paramInt));
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveContactListTimeStamp" + paramLong1 + ", " + paramLong2);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("queryContactTimeStamp", paramLong1).putLong("queryRichInfoTimeStamp", paramLong2).commit();
  }
  
  private void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    int m = this.jdField_a_of_type_Int;
    int n = a(paramRespondQueryQQBindingStat);
    switch (n)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = n;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "syncBindState newState = " + n + " lastState=" + m + " curState=" + this.jdField_a_of_type_Int);
      }
      if (m != this.jdField_a_of_type_Int) {
        m();
      }
      return;
      if (this.jdField_a_of_type_Int != n)
      {
        r();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_show_contact_banner", true).commit();
      }
      if ((n != 1) || (this.jdField_a_of_type_Int != 4))
      {
        this.jdField_a_of_type_Int = n;
        continue;
        if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L) {
          r();
        }
        this.jdField_a_of_type_Int = n;
        continue;
        if (this.jdField_a_of_type_Int != 8)
        {
          if (this.jdField_a_of_type_Int != n) {
            r();
          }
          this.jdField_a_of_type_Int = n;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("PhoneContact", 2, "cur state is uploading");
          continue;
          this.jdField_a_of_type_Int = n;
          continue;
          this.jdField_a_of_type_Int = n;
        }
      }
    }
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
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_contact_last_login", paramString).commit();
  }
  
  private void a(ConcurrentHashMap paramConcurrentHashMap)
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
  
  private void a(boolean paramBoolean, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "notifyRecommendCountChanged|beAdded = " + paramBoolean + "|list.size = " + paramList.size());
    }
    int m = paramList.size();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zil(this, paramBoolean, m));
  }
  
  private boolean a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, boolean paramBoolean)
  {
    if ((paramString == null) || ((paramArrayList1 == null) && (paramArrayList2 == null)))
    {
      this.jdField_d_of_type_Boolean = false;
      return false;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    if (paramBoolean) {}
    for (int m = 15;; m = 38)
    {
      localNewIntent.putExtra("req_type", m);
      localNewIntent.putExtra("unique_phone_no", paramString);
      localNewIntent.putExtra("add_contact_list", paramArrayList1);
      localNewIntent.putExtra("del_contact_list", paramArrayList2);
      localNewIntent.putExtra("rename_contact_list", paramArrayList3);
      localNewIntent.putExtra("next_flag", 0L);
      localNewIntent.putExtra("upload_package_no", 0);
      localNewIntent.putExtra("session_id", new byte[0]);
      localNewIntent.putExtra("is_resend", false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return true;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int n = 0;
    int i1 = paramArrayOfByte.length - 1;
    while (i1 > n * 2)
    {
      int m = paramArrayOfByte[n];
      paramArrayOfByte[n] = paramArrayOfByte[(i1 - n)];
      paramArrayOfByte[(i1 - n)] = m;
      n += 1;
    }
    return paramArrayOfByte;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zik(this, paramInt));
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zim(this, paramLong));
  }
  
  private void b(boolean paramBoolean, List paramList)
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
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        localEntityTransaction.a();
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
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localContactMatch);
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
          localEntityTransaction.b();
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
    localEntityTransaction.c();
    localEntityTransaction.b();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.C();
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        ((PhoneUnityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(101)).jdField_a_of_type_Boolean = true;
        long l1 = System.currentTimeMillis();
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder(200);
          ((StringBuilder)localObject1).append("doQueryContactList, isQueryingContact ").append(this.jdField_c_of_type_Boolean);
          ((StringBuilder)localObject1).append(", isUpdatingContact ").append(this.jdField_d_of_type_Boolean);
          ((StringBuilder)localObject1).append(", mCurrentBindState ").append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(", beForce ").append(paramBoolean1);
          ((StringBuilder)localObject1).append(", isQueryAll ").append(paramBoolean2);
          ((StringBuilder)localObject1).append(", lastQueryTime ").append(this.jdField_b_of_type_Long / 1000L);
          ((StringBuilder)localObject1).append(", currentTime ").append(l1 / 1000L);
          QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject1).toString());
        }
        int m;
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int != 8) && (!this.jdField_d_of_type_Boolean))
        {
          m = this.jdField_a_of_type_Int;
          if (m != 4) {}
        }
        else
        {
          return;
        }
        if ((paramBoolean1) || (Math.abs(l1 - this.jdField_b_of_type_Long) >= jdField_a_of_type_Long))
        {
          ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_c_of_type_Boolean = true;
          this.jdField_c_of_type_JavaUtilList = null;
          this.jdField_d_of_type_JavaUtilList = null;
          localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
          ((NewIntent)localObject1).putExtra("req_type", 30);
          ((NewIntent)localObject1).putExtra("next_flag", 0L);
          l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
          long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
          ((NewIntent)localObject1).putExtra("time_stamp", l1);
          ((NewIntent)localObject1).putExtra("richinfo_time_stamp", l2);
          ((NewIntent)localObject1).putExtra("session_id", new byte[0]);
          ((NewIntent)localObject1).putExtra("unique_phone_no", a());
          if (paramBoolean2)
          {
            m = 1;
            ((NewIntent)localObject1).putExtra("force_query_list", m);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
          }
          else
          {
            m = 2;
          }
        }
      }
      finally {}
    }
  }
  
  private String d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("contact_bind_info_unique", "");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("null|null"))) {
      return localObject1;
    }
    Object localObject2 = e();
    localObject1 = localObject2;
    if (((String)localObject2).equals("|")) {
      localObject1 = e();
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("|"))
    {
      localObject1 = new Random();
      localObject2 = ((Random)localObject1).nextLong() + "|" + ((Random)localObject1).nextLong();
    }
    localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putString("contact_bind_info_unique", (String)localObject2);
    ((SharedPreferences.Editor)localObject1).commit();
    return localObject2;
  }
  
  /* Error */
  private ArrayList d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokespecial 943	com/tencent/mobileqq/app/PhoneContactManagerImp:l	()V
    //   10: aload_0
    //   11: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: invokevirtual 363	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   20: getstatic 369	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   23: getstatic 60	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 7
    //   34: new 133	java/util/ArrayList
    //   37: dup
    //   38: invokespecial 134	java/util/ArrayList:<init>	()V
    //   41: astore 12
    //   43: aload 7
    //   45: ifnull +779 -> 824
    //   48: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   51: lstore_3
    //   52: aload 7
    //   54: invokeinterface 385 1 0
    //   59: istore_1
    //   60: aload 12
    //   62: iload_1
    //   63: invokevirtual 946	java/util/ArrayList:ensureCapacity	(I)V
    //   66: new 87	java/util/concurrent/ConcurrentHashMap
    //   69: dup
    //   70: iload_1
    //   71: invokespecial 947	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   74: astore 13
    //   76: aload 8
    //   78: astore 6
    //   80: aload 9
    //   82: astore 5
    //   84: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +38 -> 125
    //   90: aload 8
    //   92: astore 6
    //   94: aload 9
    //   96: astore 5
    //   98: ldc_w 377
    //   101: iconst_2
    //   102: new 156	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 949
    //   112: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload_1
    //   116: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload 8
    //   127: astore 6
    //   129: aload 9
    //   131: astore 5
    //   133: aload_0
    //   134: getfield 216	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   137: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   140: astore 8
    //   142: aload 8
    //   144: astore 6
    //   146: aload 8
    //   148: astore 5
    //   150: aload 8
    //   152: invokevirtual 397	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   155: aload 8
    //   157: astore 6
    //   159: aload 8
    //   161: astore 5
    //   163: aload 7
    //   165: invokeinterface 400 1 0
    //   170: pop
    //   171: aload 8
    //   173: astore 6
    //   175: aload 8
    //   177: astore 5
    //   179: aload 7
    //   181: invokeinterface 403 1 0
    //   186: ifne +600 -> 786
    //   189: aload 8
    //   191: astore 6
    //   193: aload 8
    //   195: astore 5
    //   197: aload 7
    //   199: aload 7
    //   201: ldc 50
    //   203: invokeinterface 406 2 0
    //   208: invokeinterface 409 2 0
    //   213: invokestatic 414	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 10
    //   218: aload 8
    //   220: astore 6
    //   222: aload 8
    //   224: astore 5
    //   226: aload 7
    //   228: aload 7
    //   230: ldc 52
    //   232: invokeinterface 406 2 0
    //   237: invokeinterface 409 2 0
    //   242: astore 11
    //   244: aload 11
    //   246: astore 9
    //   248: aload 8
    //   250: astore 6
    //   252: aload 8
    //   254: astore 5
    //   256: aload 11
    //   258: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifeq +7 -> 268
    //   264: aload 10
    //   266: astore 9
    //   268: aload 8
    //   270: astore 6
    //   272: aload 8
    //   274: astore 5
    //   276: aload 7
    //   278: aload 7
    //   280: ldc 54
    //   282: invokeinterface 406 2 0
    //   287: invokeinterface 418 2 0
    //   292: istore_1
    //   293: aload 8
    //   295: astore 6
    //   297: aload 8
    //   299: astore 5
    //   301: aload 7
    //   303: aload 7
    //   305: ldc 56
    //   307: invokeinterface 406 2 0
    //   312: invokeinterface 418 2 0
    //   317: istore_2
    //   318: aload 8
    //   320: astore 6
    //   322: aload 8
    //   324: astore 5
    //   326: aload 7
    //   328: aload 7
    //   330: ldc 58
    //   332: invokeinterface 406 2 0
    //   337: invokeinterface 409 2 0
    //   342: astore 11
    //   344: aload 8
    //   346: astore 6
    //   348: aload 8
    //   350: astore 5
    //   352: aload 10
    //   354: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifne +19 -> 376
    //   360: aload 8
    //   362: astore 6
    //   364: aload 8
    //   366: astore 5
    //   368: aload 9
    //   370: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   373: ifeq +147 -> 520
    //   376: aload 8
    //   378: astore 6
    //   380: aload 8
    //   382: astore 5
    //   384: aload 7
    //   386: invokeinterface 421 1 0
    //   391: pop
    //   392: goto -221 -> 171
    //   395: astore 8
    //   397: aload 6
    //   399: astore 5
    //   401: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +18 -> 422
    //   407: aload 6
    //   409: astore 5
    //   411: ldc_w 377
    //   414: iconst_2
    //   415: ldc 180
    //   417: aload 8
    //   419: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: aload 6
    //   424: ifnull +8 -> 432
    //   427: aload 6
    //   429: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   432: aload 7
    //   434: invokeinterface 429 1 0
    //   439: aload_0
    //   440: aload 13
    //   442: invokespecial 951	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   445: aload_0
    //   446: getfield 110	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   449: invokevirtual 955	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   452: invokeinterface 958 1 0
    //   457: astore 5
    //   459: aload 5
    //   461: invokeinterface 514 1 0
    //   466: ifeq +358 -> 824
    //   469: aload 5
    //   471: invokeinterface 518 1 0
    //   476: checkcast 306	com/tencent/mobileqq/data/PhoneContact
    //   479: astore 6
    //   481: aload 12
    //   483: new 483	SecurityAccountServer/AddressBookItem
    //   486: dup
    //   487: aload 6
    //   489: getfield 444	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   492: aload 6
    //   494: getfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   497: invokespecial 486	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: invokevirtual 481	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   503: pop
    //   504: goto -45 -> 459
    //   507: astore 5
    //   509: aload 5
    //   511: invokevirtual 961	java/lang/Exception:printStackTrace	()V
    //   514: aconst_null
    //   515: astore 7
    //   517: goto -483 -> 34
    //   520: aload 8
    //   522: astore 6
    //   524: aload 8
    //   526: astore 5
    //   528: new 306	com/tencent/mobileqq/data/PhoneContact
    //   531: dup
    //   532: invokespecial 443	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   535: astore 14
    //   537: aload 8
    //   539: astore 6
    //   541: aload 8
    //   543: astore 5
    //   545: aload 14
    //   547: aload 10
    //   549: putfield 444	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   552: aload 8
    //   554: astore 6
    //   556: aload 8
    //   558: astore 5
    //   560: aload 14
    //   562: aload 9
    //   564: putfield 447	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   567: aload 8
    //   569: astore 6
    //   571: aload 8
    //   573: astore 5
    //   575: aload 14
    //   577: iload_1
    //   578: putfield 450	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   581: aload 8
    //   583: astore 6
    //   585: aload 8
    //   587: astore 5
    //   589: aload 14
    //   591: iload_2
    //   592: putfield 453	com/tencent/mobileqq/data/PhoneContact:type	I
    //   595: aload 8
    //   597: astore 6
    //   599: aload 8
    //   601: astore 5
    //   603: aload 14
    //   605: aload 11
    //   607: putfield 456	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   610: aload 8
    //   612: astore 6
    //   614: aload 8
    //   616: astore 5
    //   618: aload 14
    //   620: lload_3
    //   621: putfield 459	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   624: aload 8
    //   626: astore 6
    //   628: aload 8
    //   630: astore 5
    //   632: aload 14
    //   634: aload 9
    //   636: iconst_1
    //   637: invokestatic 464	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   640: putfield 323	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   643: aload 8
    //   645: astore 6
    //   647: aload 8
    //   649: astore 5
    //   651: aload 14
    //   653: aload 9
    //   655: iconst_2
    //   656: invokestatic 464	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   659: putfield 467	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   662: aload 8
    //   664: astore 6
    //   666: aload 8
    //   668: astore 5
    //   670: aload 14
    //   672: aload 14
    //   674: getfield 467	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   677: invokestatic 469	com/tencent/mobileqq/app/PhoneContactHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   680: putfield 309	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   683: aload 8
    //   685: astore 6
    //   687: aload 8
    //   689: astore 5
    //   691: aload 14
    //   693: aload 9
    //   695: aload 10
    //   697: invokestatic 475	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   700: putfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   703: aload 8
    //   705: astore 6
    //   707: aload 8
    //   709: astore 5
    //   711: aload 13
    //   713: aload 10
    //   715: aload 14
    //   717: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   720: pop
    //   721: aload 8
    //   723: astore 6
    //   725: aload 8
    //   727: astore 5
    //   729: aload_0
    //   730: getfield 116	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   733: aload 14
    //   735: getfield 478	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   738: aload 14
    //   740: invokevirtual 473	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   743: pop
    //   744: aload 8
    //   746: astore 6
    //   748: aload 8
    //   750: astore 5
    //   752: aload_0
    //   753: getfield 216	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   756: aload 14
    //   758: invokevirtual 964	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   761: goto -385 -> 376
    //   764: astore 6
    //   766: aload 5
    //   768: ifnull +8 -> 776
    //   771: aload 5
    //   773: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   776: aload 7
    //   778: invokeinterface 429 1 0
    //   783: aload 6
    //   785: athrow
    //   786: aload 8
    //   788: astore 6
    //   790: aload 8
    //   792: astore 5
    //   794: aload 8
    //   796: invokevirtual 544	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   799: aload 8
    //   801: ifnull +8 -> 809
    //   804: aload 8
    //   806: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   809: aload 7
    //   811: invokeinterface 429 1 0
    //   816: goto -377 -> 439
    //   819: astore 5
    //   821: goto -382 -> 439
    //   824: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   827: ifeq +34 -> 861
    //   830: ldc_w 377
    //   833: iconst_2
    //   834: new 156	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   841: ldc_w 966
    //   844: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload 12
    //   849: invokevirtual 436	java/util/ArrayList:size	()I
    //   852: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   855: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   861: aload_0
    //   862: iconst_1
    //   863: putfield 968	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_e_of_type_Boolean	Z
    //   866: aload 12
    //   868: areturn
    //   869: astore 5
    //   871: goto -432 -> 439
    //   874: astore 5
    //   876: goto -93 -> 783
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	879	0	this	PhoneContactManagerImp
    //   59	519	1	m	int
    //   317	275	2	n	int
    //   51	570	3	l1	long
    //   82	388	5	localObject1	Object
    //   507	3	5	localException1	Exception
    //   526	267	5	localStaleDataException1	StaleDataException
    //   819	1	5	localException2	Exception
    //   869	1	5	localException3	Exception
    //   874	1	5	localException4	Exception
    //   78	669	6	localObject2	Object
    //   764	20	6	localObject3	Object
    //   788	1	6	localStaleDataException2	StaleDataException
    //   32	778	7	localCursor	Cursor
    //   4	377	8	localEntityTransaction	EntityTransaction
    //   395	410	8	localStaleDataException3	StaleDataException
    //   1	693	9	localObject4	Object
    //   216	498	10	str1	String
    //   242	364	11	str2	String
    //   41	826	12	localArrayList	ArrayList
    //   74	638	13	localConcurrentHashMap	ConcurrentHashMap
    //   535	222	14	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   84	90	395	android/database/StaleDataException
    //   98	125	395	android/database/StaleDataException
    //   133	142	395	android/database/StaleDataException
    //   150	155	395	android/database/StaleDataException
    //   163	171	395	android/database/StaleDataException
    //   179	189	395	android/database/StaleDataException
    //   197	218	395	android/database/StaleDataException
    //   226	244	395	android/database/StaleDataException
    //   256	264	395	android/database/StaleDataException
    //   276	293	395	android/database/StaleDataException
    //   301	318	395	android/database/StaleDataException
    //   326	344	395	android/database/StaleDataException
    //   352	360	395	android/database/StaleDataException
    //   368	376	395	android/database/StaleDataException
    //   384	392	395	android/database/StaleDataException
    //   528	537	395	android/database/StaleDataException
    //   545	552	395	android/database/StaleDataException
    //   560	567	395	android/database/StaleDataException
    //   575	581	395	android/database/StaleDataException
    //   589	595	395	android/database/StaleDataException
    //   603	610	395	android/database/StaleDataException
    //   618	624	395	android/database/StaleDataException
    //   632	643	395	android/database/StaleDataException
    //   651	662	395	android/database/StaleDataException
    //   670	683	395	android/database/StaleDataException
    //   691	703	395	android/database/StaleDataException
    //   711	721	395	android/database/StaleDataException
    //   729	744	395	android/database/StaleDataException
    //   752	761	395	android/database/StaleDataException
    //   794	799	395	android/database/StaleDataException
    //   10	34	507	java/lang/Exception
    //   84	90	764	finally
    //   98	125	764	finally
    //   133	142	764	finally
    //   150	155	764	finally
    //   163	171	764	finally
    //   179	189	764	finally
    //   197	218	764	finally
    //   226	244	764	finally
    //   256	264	764	finally
    //   276	293	764	finally
    //   301	318	764	finally
    //   326	344	764	finally
    //   352	360	764	finally
    //   368	376	764	finally
    //   384	392	764	finally
    //   401	407	764	finally
    //   411	422	764	finally
    //   528	537	764	finally
    //   545	552	764	finally
    //   560	567	764	finally
    //   575	581	764	finally
    //   589	595	764	finally
    //   603	610	764	finally
    //   618	624	764	finally
    //   632	643	764	finally
    //   651	662	764	finally
    //   670	683	764	finally
    //   691	703	764	finally
    //   711	721	764	finally
    //   729	744	764	finally
    //   752	761	764	finally
    //   794	799	764	finally
    //   809	816	819	java/lang/Exception
    //   432	439	869	java/lang/Exception
    //   776	783	874	java/lang/Exception
  }
  
  private void d(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new zip(this, paramBoolean));
  }
  
  private String e()
  {
    Object localObject = "";
    for (;;)
    {
      try
      {
        str1 = ((TelephonyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("phone")).getDeviceId();
        localObject = str1;
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        continue;
      }
      try
      {
        str1 = ((WifiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        return (String)localObject + "|" + str1;
      }
      catch (Exception localException1)
      {
        str2 = "";
      }
    }
  }
  
  private void e(List paramList)
  {
    StringBuilder localStringBuilder;
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_contact_last_login", "");
      localStringBuilder = new StringBuilder(((String)localObject).length() + paramList.size() * 13);
      localStringBuilder.append((String)localObject);
      localObject = new HashSet(this.jdField_a_of_type_JavaUtilSet.size() + paramList.size());
      ((Set)localObject).addAll(this.jdField_a_of_type_JavaUtilSet);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (((Set)localObject).add(str)) {
          localStringBuilder.append('|').append(str);
        }
      }
      this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    }
    catch (OutOfMemoryError paramList)
    {
      QLog.e("PhoneContactManagerImp", 1, "addContactsToLastLoginList oom", paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "addContactsToLastLogin, " + localStringBuilder.toString());
    }
    a(localStringBuilder.toString());
  }
  
  private void e(boolean paramBoolean)
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
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      if (!this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
      {
        EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          Iterator localIterator = this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
          while (localIterator.hasNext())
          {
            PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
            a(localPhoneContact, paramBoolean);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          }
          this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityTransaction.c();
        localEntityTransaction.b();
      }
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
  
  /* Error */
  private void g(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: bipush 101
    //   8: invokevirtual 881	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11: checkcast 883	com/tencent/mobileqq/app/PhoneUnityManager
    //   14: iconst_1
    //   15: putfield 884	com/tencent/mobileqq/app/PhoneUnityManager:jdField_a_of_type_Boolean	Z
    //   18: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   21: lstore_3
    //   22: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +125 -> 150
    //   28: new 156	java/lang/StringBuilder
    //   31: dup
    //   32: sipush 200
    //   35: invokespecial 885	java/lang/StringBuilder:<init>	(I)V
    //   38: astore 7
    //   40: aload 7
    //   42: ldc_w 1047
    //   45: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   52: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 7
    //   58: ldc_w 889
    //   61: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 81	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   68: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 7
    //   74: ldc_w 891
    //   77: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   84: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 7
    //   90: ldc_w 893
    //   93: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload_1
    //   97: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 7
    //   103: ldc_w 897
    //   106: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 77	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Long	J
    //   113: ldc2_w 898
    //   116: ldiv
    //   117: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 7
    //   123: ldc_w 901
    //   126: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: lload_3
    //   130: ldc2_w 898
    //   133: ldiv
    //   134: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: ldc_w 377
    //   141: iconst_2
    //   142: aload 7
    //   144: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   154: ifne +20 -> 174
    //   157: aload_0
    //   158: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   161: iconst_4
    //   162: if_icmpeq +12 -> 174
    //   165: aload_0
    //   166: getfield 81	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   169: istore_2
    //   170: iload_2
    //   171: ifeq +6 -> 177
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: iload_1
    //   178: ifne +19 -> 197
    //   181: lload_3
    //   182: aload_0
    //   183: getfield 77	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Long	J
    //   186: lsub
    //   187: invokestatic 907	java/lang/Math:abs	(J)J
    //   190: getstatic 46	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Long	J
    //   193: lcmp
    //   194: iflt -20 -> 174
    //   197: aload_0
    //   198: iconst_1
    //   199: putfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   202: aload_0
    //   203: aconst_null
    //   204: putfield 1049	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_k_of_type_JavaUtilList	Ljava/util/List;
    //   207: new 733	mqq/app/NewIntent
    //   210: dup
    //   211: aload_0
    //   212: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   215: invokevirtual 737	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   218: ldc_w 739
    //   221: invokespecial 742	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   224: astore 7
    //   226: aload 7
    //   228: ldc_w 744
    //   231: bipush 39
    //   233: invokevirtual 748	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   236: pop
    //   237: aload 7
    //   239: ldc_w 764
    //   242: lconst_0
    //   243: invokevirtual 767	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   246: pop
    //   247: aload_0
    //   248: getfield 172	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   251: ldc_w 605
    //   254: lconst_0
    //   255: invokeinterface 198 4 0
    //   260: lstore_3
    //   261: aload_0
    //   262: getfield 172	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   265: ldc_w 613
    //   268: lconst_0
    //   269: invokeinterface 198 4 0
    //   274: lstore 5
    //   276: aload 7
    //   278: ldc_w 920
    //   281: lload_3
    //   282: invokevirtual 767	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   285: pop
    //   286: aload 7
    //   288: ldc_w 922
    //   291: lload 5
    //   293: invokevirtual 767	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   296: pop
    //   297: aload 7
    //   299: ldc 178
    //   301: iconst_0
    //   302: newarray byte
    //   304: invokevirtual 772	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   307: pop
    //   308: aload 7
    //   310: ldc_w 750
    //   313: aload_0
    //   314: invokevirtual 241	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   317: invokevirtual 753	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   320: pop
    //   321: aload_0
    //   322: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   325: aload 7
    //   327: invokevirtual 781	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   330: goto -156 -> 174
    //   333: astore 7
    //   335: aload_0
    //   336: monitorexit
    //   337: aload 7
    //   339: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	PhoneContactManagerImp
    //   0	340	1	paramBoolean	boolean
    //   169	2	2	bool	boolean
    //   21	261	3	l1	long
    //   274	18	5	l2	long
    //   38	288	7	localObject1	Object
    //   333	5	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	150	333	finally
    //   150	170	333	finally
    //   181	197	333	finally
    //   197	330	333	finally
  }
  
  private List h()
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
  
  private boolean h()
  {
    if (!"7.6.3".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped_notbind", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "poppedForThisVersionNotBind result = " + bool);
      }
      return bool;
    }
  }
  
  private List i()
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
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new zix(this));
  }
  
  private boolean i()
  {
    if (!"7.6.3".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "isPhoneContactFirstRun result = " + bool);
      }
      return bool;
    }
  }
  
  private void j()
  {
    String[] arrayOfString = StringUtil.a(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("key_contact_last_login", ""), '|');
    HashSet localHashSet = new HashSet(arrayOfString.length);
    int n = arrayOfString.length;
    int m = 0;
    while (m < n)
    {
      String str = arrayOfString[m];
      if (!TextUtils.isEmpty(str)) {
        localHashSet.add(str);
      }
      m += 1;
    }
    this.jdField_a_of_type_JavaUtilSet = localHashSet;
  }
  
  private void k()
  {
    try
    {
      this.jdField_a_of_type_Zjh = new zjh(new Handler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getMainLooper()));
      this.jdField_a_of_type_Zjh.a(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_Zjh);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "preLoadLocalContact");
    }
    a(0L, 0L);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zij(this));
  }
  
  private void n()
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
          EntityTransaction localEntityTransaction1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
          try
          {
            localEntityTransaction1.a();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ContactMatch().getTableName(), null, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ContactBinded().getTableName(), null, null);
            localEntityTransaction1.c();
            localEntityTransaction1.b();
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend with BannerShow");
            }
            return;
          }
          finally
          {
            localObject3 = finally;
            localEntityTransaction1.b();
            throw localObject3;
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        EntityTransaction localEntityTransaction2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        ContactMatch localContactMatch;
        try
        {
          localEntityTransaction2.a();
          Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator1.hasNext())
          {
            localContactMatch = (ContactMatch)localIterator1.next();
            PhoneContact localPhoneContact = b(localContactMatch.mobileNo);
            if ((localPhoneContact == null) || ((localPhoneContact.uin != null) && (!localPhoneContact.uin.equals("0"))) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= jdField_b_of_type_Int))
            {
              localIterator1.remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localContactMatch);
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
          localEntityTransaction2.b();
        }
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator2.hasNext())
        {
          localContactMatch = (ContactMatch)localIterator2.next();
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend|mobileNo : " + localContactMatch.mobileNo + "|size : " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        label396:
        localEntityTransaction2.c();
        localEntityTransaction2.b();
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend mContactMatchsize = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
      }
    }
  }
  
  /* Error */
  private void o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +77 -> 82
    //   8: new 156	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 885	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc_w 1132
    //   22: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 81	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   29: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: ldc_w 1134
    //   37: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   44: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 1136
    //   52: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 83	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   62: lsub
    //   63: ldc2_w 898
    //   66: ldiv
    //   67: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc_w 377
    //   74: iconst_2
    //   75: aload_2
    //   76: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 81	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   86: ifne +12 -> 98
    //   89: aload_0
    //   90: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   93: istore_1
    //   94: iload_1
    //   95: ifeq +6 -> 101
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   104: aload_0
    //   105: getfield 83	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   108: lsub
    //   109: ldc2_w 43
    //   112: lcmp
    //   113: iflt -15 -> 98
    //   116: new 133	java/util/ArrayList
    //   119: dup
    //   120: invokespecial 134	java/util/ArrayList:<init>	()V
    //   123: astore_2
    //   124: new 133	java/util/ArrayList
    //   127: dup
    //   128: invokespecial 134	java/util/ArrayList:<init>	()V
    //   131: astore_3
    //   132: aload_0
    //   133: aload_2
    //   134: aload_3
    //   135: invokespecial 1138	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   138: astore 4
    //   140: aload_2
    //   141: invokevirtual 1139	java/util/ArrayList:isEmpty	()Z
    //   144: ifeq +10 -> 154
    //   147: aload_3
    //   148: invokevirtual 1139	java/util/ArrayList:isEmpty	()Z
    //   151: ifne -53 -> 98
    //   154: aload_0
    //   155: aload_0
    //   156: aload_0
    //   157: invokevirtual 241	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   160: aload_2
    //   161: aload_3
    //   162: aload 4
    //   164: iconst_1
    //   165: invokespecial 1141	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   168: putfield 81	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   171: aload_0
    //   172: iconst_1
    //   173: invokespecial 641	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(I)V
    //   176: goto -78 -> 98
    //   179: astore_2
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_2
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	PhoneContactManagerImp
    //   93	2	1	bool	boolean
    //   17	144	2	localObject1	Object
    //   179	4	2	localObject2	Object
    //   131	31	3	localArrayList1	ArrayList
    //   138	25	4	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	82	179	finally
    //   82	94	179	finally
    //   101	154	179	finally
    //   154	176	179	finally
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped_notbind", "7.6.3").commit();
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped", "7.6.3").commit();
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteLocalData");
    }
    this.jdField_e_of_type_Boolean = false;
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
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
  
  /* Error */
  private void s()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +77 -> 82
    //   8: new 156	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 885	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc_w 1132
    //   22: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 81	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   29: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: ldc_w 1134
    //   37: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   44: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 1136
    //   52: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 83	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   62: lsub
    //   63: ldc2_w 898
    //   66: ldiv
    //   67: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc_w 377
    //   74: iconst_2
    //   75: aload_2
    //   76: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 81	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   86: ifne +12 -> 98
    //   89: aload_0
    //   90: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   93: istore_1
    //   94: iload_1
    //   95: ifeq +6 -> 101
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   104: aload_0
    //   105: getfield 83	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   108: lsub
    //   109: ldc2_w 43
    //   112: lcmp
    //   113: iflt -15 -> 98
    //   116: new 133	java/util/ArrayList
    //   119: dup
    //   120: invokespecial 134	java/util/ArrayList:<init>	()V
    //   123: astore_2
    //   124: new 133	java/util/ArrayList
    //   127: dup
    //   128: invokespecial 134	java/util/ArrayList:<init>	()V
    //   131: astore_3
    //   132: aload_0
    //   133: aload_2
    //   134: aload_3
    //   135: invokespecial 1138	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   138: astore 4
    //   140: aload_2
    //   141: invokevirtual 1139	java/util/ArrayList:isEmpty	()Z
    //   144: ifeq +10 -> 154
    //   147: aload_3
    //   148: invokevirtual 1139	java/util/ArrayList:isEmpty	()Z
    //   151: ifne -53 -> 98
    //   154: aload_0
    //   155: aload_0
    //   156: aload_0
    //   157: invokevirtual 241	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   160: aload_2
    //   161: aload_3
    //   162: aload 4
    //   164: iconst_0
    //   165: invokespecial 1141	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   168: putfield 81	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   171: aload_0
    //   172: iconst_1
    //   173: invokespecial 641	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(I)V
    //   176: goto -78 -> 98
    //   179: astore_2
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_2
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	PhoneContactManagerImp
    //   93	2	1	bool	boolean
    //   17	144	2	localObject1	Object
    //   179	4	2	localObject2	Object
    //   131	31	3	localArrayList1	ArrayList
    //   138	25	4	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	82	179	finally
    //   82	94	179	finally
    //   101	154	179	finally
    //   154	176	179	finally
  }
  
  public int a()
  {
    return c().size();
  }
  
  public int a(List paramList)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if (localRespondQueryQQBindingStat == null) {
      return jdField_f_of_type_Int;
    }
    if (this.jdField_a_of_type_Zje != null) {
      this.jdField_a_of_type_Zje.cancel(true);
    }
    this.jdField_a_of_type_Zje = new zje(this, null);
    this.jdField_a_of_type_Zje.a(paramList);
    this.jdField_a_of_type_Zje.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
    return jdField_e_of_type_Int;
  }
  
  public int a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(80);
      ((StringBuilder)localObject1).append("saveContactFromServerNotBind, isSegmented = ").append(paramBoolean);
      ((StringBuilder)localObject1).append(", packageNo = ").append(paramInt);
      ((StringBuilder)localObject1).append(", nextFlag = ").append(paramLong1);
      QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.l == null)
    {
      this.l = paramArrayList1;
      if (this.jdField_k_of_type_JavaUtilList != null) {
        break label123;
      }
      this.jdField_k_of_type_JavaUtilList = paramArrayList2;
    }
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean)) {
        break label138;
      }
      return 0;
      this.l.addAll(paramArrayList1);
      break;
      label123:
      this.jdField_k_of_type_JavaUtilList.addAll(paramArrayList2);
    }
    label138:
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
    int m;
    if (QLog.isColorLevel())
    {
      paramArrayList1 = new StringBuilder(200);
      paramArrayList1.append("saveContactFromServer, localTimeStamp:");
      paramArrayList1.append(l1).append(", ").append(l2);
      paramArrayList1.append(", remoteTimeStamp: ").append(paramLong2);
      paramArrayList2 = paramArrayList1.append(", friendCount:");
      if (this.l != null)
      {
        m = this.l.size();
        paramArrayList2.append(m);
        paramArrayList2 = paramArrayList1.append(", strangerCount:");
        if (this.jdField_k_of_type_JavaUtilList == null) {
          break label701;
        }
        m = this.jdField_k_of_type_JavaUtilList.size();
        label292:
        paramArrayList2.append(m);
        QLog.d("PhoneContact.Manager", 2, paramArrayList1.toString());
      }
    }
    else
    {
      if (((paramInt == 0) && (paramBoolean)) || (!paramBoolean)) {
        e(true);
      }
      if ((this.l == null) || (this.l.size() <= 0)) {
        break label1351;
      }
      paramArrayList2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    }
    Object localObject2;
    Object localObject3;
    boolean bool1;
    for (;;)
    {
      try
      {
        paramArrayList2.a();
        localObject2 = this.l.iterator();
        paramBoolean = false;
        if (!((Iterator)localObject2).hasNext()) {
          break label763;
        }
        localObject3 = (NotBindContactFriendInfo)((Iterator)localObject2).next();
        paramArrayList1 = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramArrayList1 == null) {
          break label707;
        }
        bool1 = true;
        a(paramArrayList1, true);
        paramArrayList1.uin = String.valueOf(((NotBindContactFriendInfo)localObject3).bindUin);
        paramArrayList1.isUploaded = true;
        paramArrayList1.unifiedCode = a(((NotBindContactFriendInfo)localObject3).MobileNoMask, paramArrayList1.mobileNo);
        paramArrayList1.mobileCode = paramArrayList1.unifiedCode;
        paramArrayList1.nationCode = "";
        if ((!TextUtils.isEmpty(paramArrayList1.uin)) && (!paramArrayList1.uin.equals("0")))
        {
          localObject3 = ((FriendsManager)localObject1).c(paramArrayList1.uin);
          if (localObject3 != null) {
            paramArrayList1.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayList1.uin, paramArrayList1);
          ((FriendsManager)localObject1).a(paramArrayList1.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramArrayList1.unifiedCode)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayList1.unifiedCode, paramArrayList1);
        }
        this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramArrayList1.mobileNo);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramArrayList1);
        paramBoolean = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramArrayList1 != null) {
          break label753;
        }
        paramArrayList1 = "null";
        QLog.d("PhoneContact.Manager", 2, paramArrayList1);
        paramBoolean = bool1;
        continue;
        m = -1;
      }
      finally
      {
        paramArrayList2.b();
      }
      break;
      label701:
      m = -1;
      break label292;
      label707:
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean;
        continue;
        label753:
        paramArrayList1 = paramArrayList1.toString();
      }
    }
    label763:
    paramArrayList2.c();
    paramArrayList2.b();
    boolean bool3;
    boolean bool2;
    for (;;)
    {
      if ((this.jdField_k_of_type_JavaUtilList != null) && (this.jdField_k_of_type_JavaUtilList.size() > 0))
      {
        paramArrayList2 = new ArrayList(this.jdField_k_of_type_JavaUtilList.size());
        paramArrayList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      }
      for (;;)
      {
        try
        {
          paramArrayList1.a();
          localObject1 = this.jdField_k_of_type_JavaUtilList.iterator();
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
                paramArrayList2.add(((PhoneContact)localObject3).unifiedCode);
              }
              ((PhoneContact)localObject3).abilityBits = ((NotBindContactNotFriendInfo)localObject2).uAbiFlag;
              if (!TextUtils.isEmpty(((PhoneContact)localObject3).unifiedCode)) {
                this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PhoneContact)localObject3).unifiedCode, localObject3);
              }
              this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((PhoneContact)localObject3).mobileNo);
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject3);
              bool2 = paramBoolean;
              if (!QLog.isColorLevel()) {
                break label1369;
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
              break label1369;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean;
            break label1369;
          }
          e(paramArrayList2);
          paramArrayList1.c();
          paramArrayList1.b();
          bool2 = paramBoolean;
          paramBoolean = bool1;
          this.jdField_g_of_type_JavaUtilList = null;
          this.jdField_a_of_type_JavaUtilList = null;
          this.l = null;
          this.jdField_k_of_type_JavaUtilList = null;
          paramInt = 7;
          if (bool2) {
            paramInt = 15;
          }
          if (paramLong1 == 4294967295L)
          {
            f(true);
            b(paramBoolean, this.jdField_b_of_type_JavaUtilList);
            this.jdField_b_of_type_JavaUtilList.clear();
            n();
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
          paramArrayList1.b();
        }
        bool2 = false;
      }
      label1351:
      paramBoolean = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean;
      paramBoolean = bool2;
      break;
      label1369:
      paramBoolean = bool3;
      bool1 = bool2;
    }
  }
  
  public int a(boolean paramBoolean1, int paramInt, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3, long paramLong4, List paramList1, List paramList2)
  {
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
      this.jdField_c_of_type_JavaUtilList = paramList1;
      if (this.jdField_d_of_type_JavaUtilList != null) {
        break label123;
      }
      this.jdField_d_of_type_JavaUtilList = paramList2;
    }
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean1)) {
        break label138;
      }
      return 0;
      this.jdField_c_of_type_JavaUtilList.addAll(paramList1);
      break;
      label123:
      this.jdField_d_of_type_JavaUtilList.addAll(paramList2);
    }
    label138:
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
    int m;
    if (QLog.isColorLevel())
    {
      paramList1 = new StringBuilder(200);
      paramList1.append("saveContactFromServer, localTimeStamp:");
      paramList1.append(l1).append(", ").append(l2);
      paramList1.append(", remoteTimeStamp: ").append(paramLong2).append(", ").append(paramLong3);
      paramList2 = paramList1.append(", friendCount:");
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        m = this.jdField_c_of_type_JavaUtilList.size();
        paramList2.append(m);
        paramList2 = paramList1.append(", strangerCount:");
        if (this.jdField_d_of_type_JavaUtilList == null) {
          break label774;
        }
        m = this.jdField_d_of_type_JavaUtilList.size();
        label303:
        paramList2.append(m);
        paramList1.append(", queryInterval:").append(paramLong4);
        paramList1.append(", isListChanged:").append(paramBoolean2);
        QLog.d("PhoneContact.Manager", 2, paramList1.toString());
      }
    }
    else
    {
      if (((paramInt == 0) && (paramBoolean1)) || (!paramBoolean1)) {
        e(paramBoolean2);
      }
      if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() <= 0)) {
        break label1598;
      }
      if (!paramBoolean2) {}
      paramList2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    }
    Object localObject2;
    Object localObject3;
    boolean bool1;
    for (;;)
    {
      try
      {
        paramList2.a();
        localObject2 = this.jdField_c_of_type_JavaUtilList.iterator();
        paramBoolean1 = false;
        if (!((Iterator)localObject2).hasNext()) {
          break label836;
        }
        localObject3 = (MobileContactsFriendInfo)((Iterator)localObject2).next();
        paramList1 = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramList1 == null) {
          break label780;
        }
        bool1 = true;
        a(paramList1, paramBoolean2);
        paramList1.uin = ((MobileContactsFriendInfo)localObject3).QQ;
        paramList1.bindingDate = ((MobileContactsFriendInfo)localObject3).bindingDate;
        paramList1.isUploaded = true;
        paramList1.originBinder = ((MobileContactsFriendInfo)localObject3).originBinder;
        paramList1.ability = ((MobileContactsFriendInfo)localObject3).accountAbi;
        paramList1.unifiedCode = a(((MobileContactsFriendInfo)localObject3).MobileNoMask, paramList1.mobileNo);
        paramList1.mobileCode = paramList1.unifiedCode;
        paramList1.nationCode = "";
        if ((!TextUtils.isEmpty(paramList1.uin)) && (!paramList1.uin.equals("0")))
        {
          localObject3 = ((FriendsManager)localObject1).c(paramList1.uin);
          if (localObject3 != null) {
            paramList1.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList1.uin, paramList1);
          ((FriendsManager)localObject1).a(paramList1.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramList1.unifiedCode)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList1.unifiedCode, paramList1);
        }
        this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramList1.mobileNo);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramList1);
        paramBoolean1 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramList1 != null) {
          break label826;
        }
        paramList1 = "null";
        QLog.d("PhoneContact.Manager", 2, paramList1);
        paramBoolean1 = bool1;
        continue;
        m = -1;
      }
      finally
      {
        paramList2.b();
      }
      break;
      label774:
      m = -1;
      break label303;
      label780:
      bool1 = paramBoolean1;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean1;
        continue;
        label826:
        paramList1 = paramList1.unifiedCode;
      }
    }
    label836:
    paramList2.c();
    paramList2.b();
    boolean bool3;
    boolean bool2;
    for (;;)
    {
      if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0))
      {
        paramList2 = new ArrayList(this.jdField_d_of_type_JavaUtilList.size());
        paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      }
      for (;;)
      {
        try
        {
          paramList1.a();
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
                paramList2.add(((PhoneContact)localObject3).unifiedCode);
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
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject3);
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label1616;
              }
              QLog.d("PhoneContact.Manager", 2, "MobileContactsNotFriendInfo; mobile=" + ((PhoneContact)localObject3).unifiedCode + " hide=" + ((PhoneContact)localObject3).isHiden);
              paramBoolean1 = true;
              break;
            }
            bool3 = bool1;
            bool2 = paramBoolean1;
            if (!QLog.isColorLevel()) {
              break label1616;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean1;
            break label1616;
          }
          e(paramList2);
          paramList1.c();
          paramList1.b();
          bool2 = paramBoolean1;
          paramBoolean1 = bool1;
          this.jdField_g_of_type_JavaUtilList = null;
          this.jdField_a_of_type_JavaUtilList = null;
          this.jdField_c_of_type_JavaUtilList = null;
          this.jdField_d_of_type_JavaUtilList = null;
          paramInt = 6;
          if (paramBoolean2) {
            paramInt = 7;
          }
          m = paramInt;
          if (bool2) {
            m = paramInt | 0x8;
          }
          if (paramLong1 == 4294967295L)
          {
            f(paramBoolean2);
            b(paramBoolean1, this.jdField_b_of_type_JavaUtilList);
            this.jdField_b_of_type_JavaUtilList.clear();
            n();
            a(paramLong2, paramLong3);
            jdField_a_of_type_Long = Math.max(120000L, paramLong4);
            this.jdField_b_of_type_AndroidContentSharedPreferences.edit().putLong("query_contact_list_min_interval", jdField_a_of_type_Long).commit();
          }
          c(bool2);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "saveContactFromServer_v2 leave");
          }
          return m;
        }
        finally
        {
          paramList1.b();
        }
        bool2 = false;
      }
      label1598:
      paramBoolean1 = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean1;
      paramBoolean1 = bool2;
      break;
      label1616:
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
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences == null) {
      return null;
    }
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
    return localRespondQueryQQBindingStat;
  }
  
  public ContactBindedAdapter.ContactBindedData a(List paramList)
  {
    ThreadManager.getSubThreadHandler().post(new zjc(this, paramList));
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
        this.jdField_a_of_type_JavaLangString = d();
      }
      return this.jdField_a_of_type_JavaLangString;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    EntityManager localEntityManager;
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break;
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)localEntityManager.a(PhoneNumInfo.class, paramString);
    if (localPhoneNumInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPhoneNumInfo.uin);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneNumInfo.uin, paramString);
    }
    localEntityManager.a();
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList a()
  {
    int m = 0;
    ArrayList localArrayList1 = (ArrayList)((ArrayList)a()).clone();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      return new ArrayList();
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Collections.sort(localArrayList1, new zjd(this, localFriendsManager));
    int n = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels;
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "generateRandomListscreenWidth : " + n);
    }
    ArrayList localArrayList2;
    int i1;
    if (n >= 1080)
    {
      n = 5;
      localArrayList2 = new ArrayList();
      i1 = 0;
      label137:
      if (m < n)
      {
        PhoneContact localPhoneContact = (PhoneContact)localArrayList1.get((this.jdField_d_of_type_Int + i1) % localArrayList1.size());
        if (localFriendsManager.a(localPhoneContact.unifiedCode, true)) {
          break label226;
        }
        localArrayList2.add(localPhoneContact);
        m += 1;
      }
    }
    label226:
    for (;;)
    {
      if (i1 == localArrayList1.size() - 1)
      {
        this.jdField_d_of_type_Int += n;
        return localArrayList2;
        n = 4;
        break;
      }
      i1 += 1;
      break label137;
    }
  }
  
  public List a()
  {
    return a(true, true);
  }
  
  public List a(Map paramMap, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = new ArrayList();
    if (paramMap != null) {
      ((List)localObject).addAll(paramMap.values());
    }
    if (!paramBoolean) {
      Collections.sort((List)localObject, new ziv(this));
    }
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    label198:
    label233:
    label247:
    String str2;
    int n;
    label323:
    int m;
    label343:
    int i1;
    label357:
    int i2;
    label379:
    Friends localFriends;
    label387:
    label403:
    int i3;
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
              paramMap = (Map)localObject;
              if (!TextUtils.isEmpty(((PhoneContact)localObject).uin))
              {
                if (!((PhoneContact)localObject).uin.equals("0")) {
                  break label233;
                }
                paramMap = null;
                if ((paramMap == null) || (paramMap.groupid < 0)) {
                  break label247;
                }
                ((PhoneContact)localObject).nickName = paramMap.getFriendNick();
                ((PhoneContact)localObject).remark = paramMap.remark;
              }
              for (paramMap = (Map)localObject;; paramMap = (Map)localObject)
              {
                break;
                paramMap = localFriendsManager.c(((PhoneContact)localObject).uin);
                break label198;
                ((PhoneContact)localObject).uin = "0";
              }
            }
            if ((!paramBoolean) && (((PhoneContact)localObject).contactID == paramMap.contactID))
            {
              str2 = paramMap.mobileNo + "|" + ((PhoneContact)localObject).mobileNo;
              if (!TextUtils.isEmpty(paramMap.uin))
              {
                n = 1;
                if ((n == 0) || (paramMap.uin.equals("0"))) {
                  break label477;
                }
                m = 1;
                if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
                  break label482;
                }
                i1 = 1;
                if ((i1 == 0) || (((PhoneContact)localObject).uin.equals("0"))) {
                  break label488;
                }
                i2 = 1;
                if (i2 != 0) {
                  break label494;
                }
                localFriends = null;
                if ((localFriends == null) || (localFriends.groupid < 0)) {
                  break label509;
                }
                i2 = 1;
                i3 = 2;
                if (m == 0) {
                  break label515;
                }
                m = 0;
                label412:
                if (i2 == 0) {
                  break label528;
                }
                n = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label420:
      if (m > n)
      {
        paramMap = (Map)localObject;
        if (i1 != 0)
        {
          if (i2 == 0) {
            break label539;
          }
          ((PhoneContact)localObject).nickName = localFriends.getFriendNick();
          ((PhoneContact)localObject).remark = localFriends.remark;
          paramMap = (Map)localObject;
        }
      }
      for (;;)
      {
        paramMap.mobileNo = str2;
        break;
        n = 0;
        break label323;
        label477:
        m = 0;
        break label343;
        label482:
        i1 = 0;
        break label357;
        label488:
        i2 = 0;
        break label379;
        label494:
        localFriends = localFriendsManager.c(((PhoneContact)localObject).uin);
        break label387;
        label509:
        i2 = 0;
        break label403;
        label515:
        m = i3;
        if (n == 0) {
          break label412;
        }
        m = 1;
        break label412;
        label528:
        if (i1 == 0) {
          break label727;
        }
        n = 1;
        break label420;
        label539:
        ((PhoneContact)localObject).uin = "0";
        paramMap = (Map)localObject;
        continue;
        localArrayList.add(paramMap);
        paramMap = (Map)localObject;
        if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
          break;
        }
        if (((PhoneContact)localObject).uin.equals("0")) {}
        for (paramMap = null;; paramMap = localFriendsManager.c(((PhoneContact)localObject).uin))
        {
          if ((paramMap == null) || (paramMap.groupid < 0)) {
            break label639;
          }
          ((PhoneContact)localObject).nickName = paramMap.getFriendNick();
          ((PhoneContact)localObject).remark = paramMap.remark;
          paramMap = (Map)localObject;
          break;
        }
        label639:
        ((PhoneContact)localObject).uin = "0";
        paramMap = (Map)localObject;
        break;
        if (paramMap != null) {
          localArrayList.add(paramMap);
        }
        c(localArrayList);
        Collections.sort(localArrayList, new ziw(this));
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "getContactListForContactListView sort contact cost time: " + (System.currentTimeMillis() - l1));
        }
        return localArrayList;
      }
      label727:
      n = 2;
    }
  }
  
  public List a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = this.jdField_g_of_type_JavaUtilList;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = h();
    }
    localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (PhoneContact)((Iterator)localObject1).next();
      if (((PhoneContact)localObject3).isHiden) {
        ((List)localObject2).add(localObject3);
      }
    }
    if (paramBoolean)
    {
      localObject3 = new zjb(this);
      localObject1 = new ArrayList((Collection)localObject2);
      Collections.sort((List)localObject1, (Comparator)localObject3);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "getBindHideNoneFriendList cost: " + (System.currentTimeMillis() - l1) + ", size = " + ((List)localObject1).size());
      }
      return localObject1;
      localObject1 = localObject2;
    }
  }
  
  public List a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = this.jdField_g_of_type_JavaUtilList;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = h();
    }
    localObject2 = new zih(this, paramBoolean2, paramBoolean1);
    localObject1 = new ArrayList((Collection)localObject1);
    try
    {
      Collections.sort((List)localObject1, (Comparator)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "getBindNonfriendContactList cost: " + (System.currentTimeMillis() - l1) + ", size = " + ((List)localObject1).size());
      }
      this.jdField_g_of_type_JavaUtilList = ((List)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "getBindNonfriendContactList", localException);
        }
      }
    }
  }
  
  public Map a()
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
      m = localCursor.getCount();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "load contacs from system db, size=" + m);
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
          m = localCursor.getInt(localCursor.getColumnIndex("contact_id"));
          n = localCursor.getInt(localCursor.getColumnIndex("data2"));
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
          int m;
          String str2;
          String str3;
          int n;
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
          localPhoneContact.contactID = m;
          localPhoneContact.type = n;
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
    if (this.jdField_a_of_type_Zjh != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_Zjh);
      this.jdField_a_of_type_Zjh.a(null);
      this.jdField_a_of_type_Zjh = null;
      return;
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
          int m = paramString.optInt("all_entrance_num");
          if (m > 0) {
            jdField_b_of_type_Int = m;
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
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveUIBits: newBits = " + paramLong + " localUIBits = " + this.jdField_e_of_type_Long);
    }
    if (this.jdField_e_of_type_Long != paramLong)
    {
      this.jdField_e_of_type_Long = paramLong;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_contacts_switches", paramLong);
      b(paramLong);
    }
  }
  
  public void a(ContactMatch paramContactMatch)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramContactMatch);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramContactMatch);
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
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramPhoneContactAdd);
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
      int m;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
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
          m = 0;
          if (m != 0)
          {
            localObject2 = new PhoneContactAdd();
            ((PhoneContactAdd)localObject2).name = paramString2;
            ((PhoneContactAdd)localObject2).unifiedCode = paramString1;
            ((PhoneContactAdd)localObject2).timestamp = MessageCache.a();
            if (paramInt != 1) {
              break label356;
            }
            ((PhoneContactAdd)localObject2).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433330);
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
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject2);
            }
          }
          localEntityTransaction.c();
        }
        catch (Resources.NotFoundException paramString1)
        {
          Object localObject2;
          if (!QLog.isColorLevel()) {
            break label406;
          }
          QLog.d("PhoneContact.Manager", 2, "makePhoneContactAddInfo", paramString1);
          localEntityTransaction.b();
          continue;
        }
        finally
        {
          localEntityTransaction.b();
        }
        return;
      }
      label356:
      if (paramInt == 4)
      {
        ((PhoneContactAdd)localObject2).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433331);
        continue;
        m = 1;
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
  
  public void a(ArrayList paramArrayList)
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
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
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
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
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
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          }
        }
        finally
        {
          if (localEntityTransaction != null) {
            localEntityTransaction.b();
          }
        }
      }
      localEntityTransaction.c();
    } while (localEntityTransaction == null);
    localEntityTransaction.b();
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
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
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("multiMakePhoneContactAddInfo|sourceId : ").append(paramInt);
      if (paramArrayList1 == null)
      {
        ??? = "|phoneList is null";
        localObject2 = ((StringBuilder)localObject2).append((String)???);
        if (paramArrayList2 != null) {
          break label120;
        }
        ??? = "|addlist is null";
        label52:
        QLog.d("PhoneContact.Manager", 2, (String)???);
      }
    }
    else
    {
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()) && (paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {
        break label148;
      }
    }
    label120:
    while ((paramInt != 3078) && (paramInt != 3079))
    {
      return;
      ??? = "|phoneList.size : " + paramArrayList1.size();
      break;
      ??? = "|addlist.size : " + paramArrayList2.size();
      break label52;
    }
    label148:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject3;
      Object localObject4;
      try
      {
        ((EntityTransaction)localObject2).a();
        localArrayList = new ArrayList();
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(localArrayList.size());
        }
        paramArrayList2 = paramArrayList2.iterator();
        Object localObject5;
        if (paramArrayList2.hasNext())
        {
          localObject3 = (FriendListHandler.AddBatchPhoneFriendResult)paramArrayList2.next();
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
          ((PhoneContactAdd)localObject4).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131433330);
          localArrayList.add(localObject4);
          continue;
        }
        paramArrayList2 = paramArrayList2.name;
      }
      catch (Resources.NotFoundException paramArrayList1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "multiMakePhoneContactAddInfo", paramArrayList1);
        }
        ((EntityTransaction)localObject2).b();
        return;
        paramArrayList1 = finally;
        throw paramArrayList1;
        if (localArrayList.isEmpty()) {
          break label662;
        }
        localObject3 = localArrayList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label544;
        }
        localObject4 = (PhoneContactAdd)((Iterator)localObject3).next();
        localObject5 = paramArrayList1.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          paramArrayList2 = (PhoneContact)((Iterator)localObject5).next();
          if (!paramArrayList2.unifiedCode.equals(((PhoneContactAdd)localObject4).unifiedCode)) {
            continue;
          }
          if (paramArrayList2.name == null)
          {
            paramArrayList2 = paramArrayList2.nickName;
            ((PhoneContactAdd)localObject4).name = paramArrayList2;
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
        ((EntityTransaction)localObject2).b();
      }
      continue;
      label544:
      this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        paramArrayList1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!paramArrayList1.hasNext()) {
            break label662;
          }
          paramArrayList2 = (ContactMatch)paramArrayList1.next();
          localObject3 = localArrayList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (PhoneContactAdd)((Iterator)localObject3).next();
            if (!paramArrayList2.unifiedCode.equals(((PhoneContactAdd)localObject4).unifiedCode)) {
              break;
            }
            paramArrayList1.remove();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramArrayList2);
          }
        }
      }
      label662:
      ((EntityTransaction)localObject2).c();
      ((EntityTransaction)localObject2).b();
      continue;
      label675:
      paramInt = 1;
    }
  }
  
  public void a(List paramList)
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
  
  public void a(List paramList, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveLastLoginList, size = " + paramList.size() + ", stamp " + paramLong1 + ", interval = " + paramLong2);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_req_last_login_time", System.currentTimeMillis()).putLong("key_login_info_timestamp", paramLong1).putLong("key_req_login_interval", Math.max(43200000L, 1000L * paramLong2)).commit();
    HashSet localHashSet = new HashSet(paramList.size());
    StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 13);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(str.toUpperCase());
      if (localPhoneContact != null)
      {
        localHashSet.add(localPhoneContact.unifiedCode);
        localStringBuilder.append('|').append(localPhoneContact.unifiedCode);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "saveLastLoginList, wtf pc null " + str.toUpperCase());
      }
    }
    a(localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilSet = localHashSet;
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveLastLoginInfo: " + localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = false;
    if (paramBoolean) {}
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new ziy(this, paramBoolean1, paramBoolean2));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("session_id", new String(paramArrayOfByte)).commit();
  }
  
  public boolean a()
  {
    return this.jdField_j_of_type_Boolean;
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
  
  public boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = a(a());
    }
    if (this.jdField_a_of_type_Int != a(paramRespondQueryQQBindingStat)) {}
    for (boolean bool = true;; bool = false)
    {
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = paramRespondQueryQQBindingStat;
      if (paramRespondQueryQQBindingStat == null) {
        localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
      }
      paramRespondQueryQQBindingStat = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      paramRespondQueryQQBindingStat.putString("contact_bind_info_mobile", localRespondQueryQQBindingStat.mobileNo);
      paramRespondQueryQQBindingStat.putString("contact_bind_info_nation", localRespondQueryQQBindingStat.nationCode);
      paramRespondQueryQQBindingStat.putString("contact_bind_info_imei", localRespondQueryQQBindingStat.MobileUniqueNo);
      paramRespondQueryQQBindingStat.putLong("contact_bind_info_recommend", localRespondQueryQQBindingStat.isRecommend);
      paramRespondQueryQQBindingStat.putLong("contact_bind_info_origin", localRespondQueryQQBindingStat.originBinder);
      paramRespondQueryQQBindingStat.putLong("contact_bind_info_time", localRespondQueryQQBindingStat.bindingTime);
      paramRespondQueryQQBindingStat.putLong("contact_bind_info_flag", localRespondQueryQQBindingStat.lastUsedFlag);
      paramRespondQueryQQBindingStat.putInt("contact_bind_type", localRespondQueryQQBindingStat.type);
      paramRespondQueryQQBindingStat.putBoolean("contact_bind_stop_find_match", localRespondQueryQQBindingStat.isStopFindMatch);
      paramRespondQueryQQBindingStat.putBoolean("contact_bind_nobind_upload", localRespondQueryQQBindingStat.noBindUploadContacts);
      paramRespondQueryQQBindingStat.putBoolean("contact_bind_nobind_upload_local", localRespondQueryQQBindingStat.noBindUploadContactsLocal);
      this.jdField_i_of_type_Boolean = localRespondQueryQQBindingStat.isPhoneSwitched;
      paramRespondQueryQQBindingStat.commit();
      a(localRespondQueryQQBindingStat);
      return bool;
    }
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
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
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localPhoneContactAdd);
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
    //   6: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +40 -> 49
    //   12: ldc_w 377
    //   15: iconst_2
    //   16: new 156	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 1734
    //   26: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 599
    //   36: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: invokevirtual 363	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   59: astore 9
    //   61: getstatic 1737	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   64: astore 8
    //   66: new 156	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 1739
    //   76: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 1741
    //   86: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_1
    //   93: aload 9
    //   95: aload 8
    //   97: iconst_4
    //   98: anewarray 48	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: ldc_w 1743
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: ldc_w 1745
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: ldc_w 1747
    //   118: aastore
    //   119: dup
    //   120: iconst_3
    //   121: ldc 50
    //   123: aastore
    //   124: aload_1
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   130: astore 8
    //   132: aload_2
    //   133: astore_1
    //   134: aload 6
    //   136: astore_2
    //   137: aload 8
    //   139: invokeinterface 421 1 0
    //   144: ifeq +361 -> 505
    //   147: aload 8
    //   149: aload 8
    //   151: ldc_w 1743
    //   154: invokeinterface 406 2 0
    //   159: invokeinterface 1750 2 0
    //   164: lstore_3
    //   165: getstatic 1737	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   168: astore 6
    //   170: new 156	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 1752
    //   180: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: lload_3
    //   184: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: ldc_w 1754
    //   190: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 1747
    //   196: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 1756
    //   202: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc_w 1758
    //   208: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 1760
    //   214: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 56
    //   219: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 1756
    //   225: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: iconst_2
    //   229: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc_w 1741
    //   235: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore 7
    //   243: aload 9
    //   245: aload 6
    //   247: iconst_5
    //   248: anewarray 48	java/lang/String
    //   251: dup
    //   252: iconst_0
    //   253: ldc_w 1743
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: ldc_w 1745
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: ldc_w 1747
    //   268: aastore
    //   269: dup
    //   270: iconst_3
    //   271: ldc 50
    //   273: aastore
    //   274: dup
    //   275: iconst_4
    //   276: ldc 56
    //   278: aastore
    //   279: aload 7
    //   281: aconst_null
    //   282: aconst_null
    //   283: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   286: astore 6
    //   288: aload 6
    //   290: astore_2
    //   291: aload_2
    //   292: invokeinterface 400 1 0
    //   297: ifeq +96 -> 393
    //   300: aload_2
    //   301: aload_2
    //   302: ldc 50
    //   304: invokeinterface 406 2 0
    //   309: invokeinterface 409 2 0
    //   314: invokestatic 414	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   317: astore 7
    //   319: aload_1
    //   320: invokestatic 414	com/tencent/mobileqq/app/PhoneContactHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   323: astore 6
    //   325: aload 6
    //   327: astore_1
    //   328: aload 7
    //   330: aload_1
    //   331: invokestatic 1763	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   334: ifne +35 -> 369
    //   337: new 156	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 1765
    //   347: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload 7
    //   352: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: aload_1
    //   359: invokestatic 1763	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   362: istore 5
    //   364: iload 5
    //   366: ifeq +27 -> 393
    //   369: aload_2
    //   370: ifnull +9 -> 379
    //   373: aload_2
    //   374: invokeinterface 429 1 0
    //   379: aload 8
    //   381: ifnull +10 -> 391
    //   384: aload 8
    //   386: invokeinterface 429 1 0
    //   391: iconst_1
    //   392: ireturn
    //   393: aload_2
    //   394: astore 7
    //   396: aload_1
    //   397: astore 6
    //   399: aload_2
    //   400: ifnull +157 -> 557
    //   403: aload_2
    //   404: invokeinterface 429 1 0
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
    //   429: invokeinterface 429 1 0
    //   434: aload_2
    //   435: astore 7
    //   437: aload_1
    //   438: astore 6
    //   440: goto +117 -> 557
    //   443: astore_2
    //   444: aload 8
    //   446: astore_1
    //   447: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +14 -> 464
    //   453: ldc_w 377
    //   456: iconst_2
    //   457: ldc_w 1767
    //   460: aload_2
    //   461: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   464: aload_1
    //   465: ifnull +9 -> 474
    //   468: aload_1
    //   469: invokeinterface 429 1 0
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_1
    //   477: aload_2
    //   478: ifnull +9 -> 487
    //   481: aload_2
    //   482: invokeinterface 429 1 0
    //   487: aload_1
    //   488: athrow
    //   489: astore_1
    //   490: aload 8
    //   492: astore_2
    //   493: aload_2
    //   494: ifnull +9 -> 503
    //   497: aload_2
    //   498: invokeinterface 429 1 0
    //   503: aload_1
    //   504: athrow
    //   505: aload 8
    //   507: ifnull -33 -> 474
    //   510: aload 8
    //   512: invokeinterface 429 1 0
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
  
  public int b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (QLog.isColorLevel())
    {
      localStringBuffer.append("getBannerState bind state = ");
      localStringBuffer.append(c());
    }
    int m;
    if (c() == 9)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" isCacheInited=");
        localStringBuffer.append(this.jdField_e_of_type_Boolean);
      }
      if (this.jdField_e_of_type_Boolean) {
        if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
          m = 1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" ret=");
        localStringBuffer.append(m);
        QLog.d("PhoneContact.Manager", 2, localStringBuffer.toString());
      }
      return m;
      m = 2;
      continue;
      m = 0;
      continue;
      m = 2;
    }
  }
  
  public PhoneContact b(String paramString)
  {
    if (this.jdField_e_of_type_Boolean) {
      return (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class, paramString);
    }
    return null;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_bind_wording", null);
  }
  
  public String b(String paramString)
  {
    Object localObject = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (localObject == null) {
      return null;
    }
    paramString = (PhoneNumInfo)((EntityManager)localObject).a(PhoneNumInfo.class, "uin=?", new String[] { paramString });
    if (paramString != null) {
      return paramString.phoneNum;
    }
    return null;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList1 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded != null) {
        localArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqDataContactBinded);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localArrayList1.addAll(this.jdField_a_of_type_JavaUtilArrayList);
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
    return localArrayList2;
  }
  
  public List b()
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
    localObject2 = new zig(this);
    Object localObject1 = new ArrayList((Collection)localObject1);
    try
    {
      Collections.sort((List)localObject1, (Comparator)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "getBindAllriendContactList size = " + ((List)localObject1).size());
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "getBindAllriendContactList", localException);
        }
      }
    }
  }
  
  public List b(boolean paramBoolean)
  {
    if (this.jdField_j_of_type_JavaUtilList == null) {
      this.jdField_j_of_type_JavaUtilList = a(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap, paramBoolean);
    }
    return this.jdField_j_of_type_JavaUtilList;
  }
  
  public void b()
  {
    a(true, true);
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
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString);
    }
  }
  
  public void b(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = paramList.isEmpty();
        if (bool) {
          return;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityTransaction.c();
      }
      finally {}
      localEntityTransaction.b();
      this.jdField_c_of_type_Int += 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    d(paramBoolean);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 20);
    localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
    localNewIntent.putExtra("phone_number", localRespondQueryQQBindingStat.mobileNo);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean b()
  {
    if (this.jdField_g_of_type_JavaUtilList == null) {
      this.jdField_g_of_type_JavaUtilList = h();
    }
    if (this.jdField_g_of_type_JavaUtilList == null) {
      return true;
    }
    return this.jdField_g_of_type_JavaUtilList.isEmpty();
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
      d(false);
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
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      this.jdField_a_of_type_Int = a(a());
      return c();
    case 8: 
      return 8;
    case 9: 
      return 9;
    }
    return this.jdField_a_of_type_Int;
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
      if (this.jdField_e_of_type_Boolean) {
        return (PhoneContact)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null);
    return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class, "mobileCode=?", new String[] { paramString });
  }
  
  public String c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_block_msg", null);
  }
  
  public ArrayList c()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public List c()
  {
    List localList = this.jdField_g_of_type_JavaUtilList;
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
      this.jdField_g_of_type_JavaUtilList = localList;
      return localArrayList;
    }
  }
  
  public void c()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
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
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactMatch.class, false, null, null, null, null, null, null));
      this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContactAdd.class, false, null, null, null, null, null, null));
      jdField_b_of_type_Int = this.jdField_c_of_type_AndroidContentSharedPreferences.getInt("all_entrance_num", 20);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "initContactCache|NewFriendManager.sAllEntranceNum = " + jdField_b_of_type_Int);
      }
      j();
      this.jdField_e_of_type_Boolean = true;
      a(1);
      return;
    }
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
        ((EntityManager)localObject).b(localPhoneNumInfo);
        ((EntityManager)localObject).a();
      }
    }
  }
  
  public void c(List paramList)
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
  
  public boolean c()
  {
    int m = c();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isBindContactOk = " + m);
    }
    return m >= 9;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List d()
  {
    if (this.jdField_e_of_type_Boolean)
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
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
  }
  
  public void d()
  {
    a(1);
  }
  
  public void d(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = paramList.isEmpty();
        if (bool) {
          return;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityTransaction.c();
      }
      finally {}
      localEntityTransaction.b();
      this.jdField_c_of_type_Int += 1;
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Int == 4) {}
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    do
    {
      do
      {
        return true;
        localRespondQueryQQBindingStat = a();
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, new Object[] { "isAutoUploadContactsNotBind", localRespondQueryQQBindingStat.toString() });
        }
        if (this.jdField_a_of_type_Int != 3) {
          break;
        }
        if (localRespondQueryQQBindingStat == null) {
          break label84;
        }
      } while (a().lastUsedFlag == 2L);
      return false;
    } while ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.continueUploadNotbind));
    label84:
    return false;
  }
  
  public int e()
  {
    return this.jdField_c_of_type_AndroidContentSharedPreferences.getInt("key_config_version", 0);
  }
  
  public List e()
  {
    Object localObject1 = null;
    long l1 = System.currentTimeMillis();
    Object localObject2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    FriendsManager localFriendsManager;
    if (this.jdField_e_of_type_JavaUtilList == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      Collections.sort((List)localObject2, new zin(this));
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (((List)localObject2).size() > 0) {
        if (a() != null) {}
      }
    }
    label337:
    label378:
    do
    {
      return localObject1;
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
                  break label378;
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
              break label396;
            }
            localPhoneContact.nickName = ((Friends)localObject2).getFriendNick();
            localPhoneContact.remark = ((Friends)localObject2).remark;
          }
          for (;;)
          {
            localArrayList1.add(localPhoneContact);
            break;
            localObject2 = localFriendsManager.c(localPhoneContact.uin);
            break label337;
            localPhoneContact.uin = "0";
          }
        }
      }
      if (localObject1 != null) {
        localArrayList2.add(localObject1);
      }
      localObject1 = new zio(this);
      Collections.sort(localArrayList1, (Comparator)localObject1);
      Collections.sort(localArrayList2, (Comparator)localObject1);
      this.jdField_e_of_type_JavaUtilList = localArrayList1;
      this.jdField_f_of_type_JavaUtilList = localArrayList2;
      localObject2 = new ArrayList();
      c(this.jdField_e_of_type_JavaUtilList);
      c(this.jdField_f_of_type_JavaUtilList);
      ((List)localObject2).add(this.jdField_e_of_type_JavaUtilList);
      ((List)localObject2).add(this.jdField_f_of_type_JavaUtilList);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    label396:
    QLog.d("PhoneContact.Manager", 2, "sort contact cost time: " + (System.currentTimeMillis() - l1));
    return localObject2;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public boolean e()
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
  
  public List f()
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_h_of_type_JavaUtilList == null) || (this.jdField_h_of_type_JavaUtilList.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      if (localArrayList.size() > 0)
      {
        if (a() == null) {
          return null;
        }
        localArrayList.remove(b(a().mobileNo));
        Collections.sort(localArrayList, new zit(this));
      }
      this.jdField_h_of_type_JavaUtilList = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForSelector sort contact cost time: " + (System.currentTimeMillis() - l1));
    }
    return this.jdField_h_of_type_JavaUtilList;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 216	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 397	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   19: aload_0
    //   20: getfield 327	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 327	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   30: iconst_1
    //   31: putfield 857	com/tencent/mobileqq/data/ContactBinded:isReaded	Z
    //   34: aload_0
    //   35: getfield 808	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   38: ifnull +82 -> 120
    //   41: aload_0
    //   42: getfield 808	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   45: invokevirtual 436	java/util/ArrayList:size	()I
    //   48: ifle +72 -> 120
    //   51: aload_0
    //   52: getfield 808	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   55: invokevirtual 812	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 514 1 0
    //   65: ifeq +55 -> 120
    //   68: aload_3
    //   69: invokeinterface 518 1 0
    //   74: checkcast 814	com/tencent/mobileqq/data/ContactMatch
    //   77: astore 4
    //   79: aload 4
    //   81: iconst_1
    //   82: putfield 1892	com/tencent/mobileqq/data/ContactMatch:isReaded	Z
    //   85: aload_0
    //   86: aload 4
    //   88: invokevirtual 849	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   91: pop
    //   92: goto -33 -> 59
    //   95: astore_3
    //   96: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +14 -> 113
    //   102: ldc_w 377
    //   105: iconst_2
    //   106: ldc_w 1894
    //   109: aload_3
    //   110: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_2
    //   114: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   117: aload_1
    //   118: monitorexit
    //   119: return
    //   120: aload_2
    //   121: invokevirtual 544	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   124: aload_2
    //   125: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   128: goto -11 -> 117
    //   131: astore_2
    //   132: aload_1
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    //   136: astore_3
    //   137: aload_2
    //   138: invokevirtual 426	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
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
  public boolean f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 144	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 363	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 369	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   16: iconst_1
    //   17: anewarray 48	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 50
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: ldc_w 1896
    //   30: invokevirtual 375	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: invokeinterface 385 1 0
    //   47: istore_1
    //   48: iload_1
    //   49: ifle +79 -> 128
    //   52: iconst_1
    //   53: istore_2
    //   54: aload 4
    //   56: ifnull +10 -> 66
    //   59: aload 4
    //   61: invokeinterface 429 1 0
    //   66: iload_2
    //   67: ireturn
    //   68: astore 5
    //   70: aconst_null
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 5
    //   78: invokevirtual 961	java/lang/Exception:printStackTrace	()V
    //   81: aload 4
    //   83: ifnull +43 -> 126
    //   86: aload 4
    //   88: invokeinterface 429 1 0
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_3
    //   96: aload 4
    //   98: ifnull +10 -> 108
    //   101: aload 4
    //   103: invokeinterface 429 1 0
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
    //   47	2	1	m	int
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
  
  public List g()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((this.jdField_i_of_type_JavaUtilList == null) || (this.jdField_i_of_type_JavaUtilList.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          localArrayList.add(localPhoneContact);
        } else if ((!localPhoneContact.uin.equals("0")) && (((FriendsManager)localObject1).c(localPhoneContact.uin) != null)) {
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
        Collections.sort(localArrayList, new ziu(this));
      }
      this.jdField_i_of_type_JavaUtilList = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForPhoneSelector sort contact cost time: " + (System.currentTimeMillis() - l1));
    }
    return this.jdField_i_of_type_JavaUtilList;
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +87 -> 94
    //   10: new 156	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 885	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc_w 1905
    //   24: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore_3
    //   28: aload_0
    //   29: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   32: bipush 8
    //   34: if_icmpne +5 -> 39
    //   37: iconst_1
    //   38: istore_1
    //   39: aload_3
    //   40: iload_1
    //   41: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: ldc_w 1907
    //   49: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   56: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_2
    //   61: ldc_w 1136
    //   64: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   70: aload_0
    //   71: getfield 79	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Long	J
    //   74: lsub
    //   75: ldc2_w 898
    //   78: ldiv
    //   79: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: ldc_w 377
    //   86: iconst_2
    //   87: aload_2
    //   88: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_0
    //   95: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   98: bipush 8
    //   100: if_icmpeq +19 -> 119
    //   103: aload_0
    //   104: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   107: ifne +12 -> 119
    //   110: aload_0
    //   111: invokevirtual 241	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   114: astore_2
    //   115: aload_2
    //   116: ifnonnull +6 -> 122
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   125: aload_0
    //   126: getfield 79	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Long	J
    //   129: lsub
    //   130: ldc2_w 43
    //   133: lcmp
    //   134: iflt -15 -> 119
    //   137: aload_0
    //   138: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   141: iconst_2
    //   142: if_icmpeq +19 -> 161
    //   145: aload_0
    //   146: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   149: iconst_3
    //   150: if_icmpeq +11 -> 161
    //   153: aload_0
    //   154: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   157: iconst_4
    //   158: if_icmpne +7 -> 165
    //   161: aload_0
    //   162: invokespecial 629	com/tencent/mobileqq/app/PhoneContactManagerImp:r	()V
    //   165: aload_0
    //   166: bipush 8
    //   168: putfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   171: aload_0
    //   172: invokespecial 626	com/tencent/mobileqq/app/PhoneContactManagerImp:m	()V
    //   175: aload_0
    //   176: getfield 552	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Zji	Lzji;
    //   179: ifnonnull +23 -> 202
    //   182: aload_0
    //   183: new 1909	zji
    //   186: dup
    //   187: aload_0
    //   188: aconst_null
    //   189: invokespecial 1910	zji:<init>	(Lcom/tencent/mobileqq/app/PhoneContactManagerImp;Lzif;)V
    //   192: putfield 552	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Zji	Lzji;
    //   195: aload_0
    //   196: getfield 552	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Zji	Lzji;
    //   199: invokevirtual 1911	zji:a	()V
    //   202: aload_0
    //   203: invokespecial 1913	com/tencent/mobileqq/app/PhoneContactManagerImp:d	()Ljava/util/ArrayList;
    //   206: astore_3
    //   207: aload_3
    //   208: astore_2
    //   209: aload_3
    //   210: ifnonnull +12 -> 222
    //   213: new 133	java/util/ArrayList
    //   216: dup
    //   217: iconst_0
    //   218: invokespecial 810	java/util/ArrayList:<init>	(I)V
    //   221: astore_2
    //   222: new 733	mqq/app/NewIntent
    //   225: dup
    //   226: aload_0
    //   227: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   230: invokevirtual 737	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   233: ldc_w 739
    //   236: invokespecial 742	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   239: astore_3
    //   240: aload_3
    //   241: ldc_w 744
    //   244: bipush 31
    //   246: invokevirtual 748	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   249: pop
    //   250: aload_3
    //   251: ldc_w 750
    //   254: aload_0
    //   255: invokevirtual 241	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   258: invokevirtual 753	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   261: pop
    //   262: aload_3
    //   263: ldc_w 764
    //   266: lconst_0
    //   267: invokevirtual 767	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   270: pop
    //   271: aload_3
    //   272: ldc_w 769
    //   275: iconst_0
    //   276: invokevirtual 748	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   279: pop
    //   280: aload_3
    //   281: ldc_w 1915
    //   284: aload_2
    //   285: invokevirtual 758	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   288: pop
    //   289: aload_3
    //   290: ldc 178
    //   292: iconst_0
    //   293: newarray byte
    //   295: invokevirtual 772	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   298: pop
    //   299: aload_3
    //   300: ldc_w 774
    //   303: iconst_0
    //   304: invokevirtual 777	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   307: pop
    //   308: aload_0
    //   309: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   312: aload_3
    //   313: invokevirtual 781	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   316: goto -197 -> 119
    //   319: astore_2
    //   320: aload_0
    //   321: monitorexit
    //   322: aload_2
    //   323: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	PhoneContactManagerImp
    //   1	40	1	bool	boolean
    //   19	266	2	localObject1	Object
    //   319	4	2	localObject2	Object
    //   27	286	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	28	319	finally
    //   28	37	319	finally
    //   39	94	319	finally
    //   94	115	319	finally
    //   122	161	319	finally
    //   161	165	319	finally
    //   165	202	319	finally
    //   202	207	319	finally
    //   213	222	319	finally
    //   222	316	319	finally
  }
  
  public boolean g()
  {
    return c() > 5;
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +77 -> 82
    //   8: new 156	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 885	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_1
    //   18: aload_1
    //   19: ldc_w 1917
    //   22: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   29: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: ldc_w 1919
    //   37: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   44: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: ldc_w 1136
    //   52: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 79	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Long	J
    //   62: lsub
    //   63: ldc2_w 898
    //   66: ldiv
    //   67: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc_w 377
    //   74: iconst_2
    //   75: aload_1
    //   76: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   86: iconst_4
    //   87: if_icmpeq +17 -> 104
    //   90: aload_0
    //   91: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   94: ifne +10 -> 104
    //   97: aload_0
    //   98: invokevirtual 241	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   101: ifnonnull +37 -> 138
    //   104: aload_0
    //   105: getfield 75	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   108: ifeq +27 -> 135
    //   111: aload_0
    //   112: getfield 172	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   115: invokeinterface 603 1 0
    //   120: ldc_w 1365
    //   123: iconst_1
    //   124: invokeinterface 635 3 0
    //   129: invokeinterface 616 1 0
    //   134: pop
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   141: aload_0
    //   142: getfield 79	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Long	J
    //   145: lsub
    //   146: ldc2_w 43
    //   149: lcmp
    //   150: iflt -15 -> 135
    //   153: aload_0
    //   154: getfield 172	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   157: invokeinterface 603 1 0
    //   162: ldc_w 1365
    //   165: iconst_0
    //   166: invokeinterface 635 3 0
    //   171: invokeinterface 616 1 0
    //   176: pop
    //   177: aload_0
    //   178: iconst_4
    //   179: putfield 85	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   182: aload_0
    //   183: invokespecial 626	com/tencent/mobileqq/app/PhoneContactManagerImp:m	()V
    //   186: aload_0
    //   187: getfield 552	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Zji	Lzji;
    //   190: ifnonnull +23 -> 213
    //   193: aload_0
    //   194: new 1909	zji
    //   197: dup
    //   198: aload_0
    //   199: aconst_null
    //   200: invokespecial 1910	zji:<init>	(Lcom/tencent/mobileqq/app/PhoneContactManagerImp;Lzif;)V
    //   203: putfield 552	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Zji	Lzji;
    //   206: aload_0
    //   207: getfield 552	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Zji	Lzji;
    //   210: invokevirtual 1911	zji:a	()V
    //   213: aload_0
    //   214: invokespecial 1913	com/tencent/mobileqq/app/PhoneContactManagerImp:d	()Ljava/util/ArrayList;
    //   217: astore_2
    //   218: aload_2
    //   219: astore_1
    //   220: aload_2
    //   221: ifnonnull +12 -> 233
    //   224: new 133	java/util/ArrayList
    //   227: dup
    //   228: iconst_0
    //   229: invokespecial 810	java/util/ArrayList:<init>	(I)V
    //   232: astore_1
    //   233: new 733	mqq/app/NewIntent
    //   236: dup
    //   237: aload_0
    //   238: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: invokevirtual 737	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   244: ldc_w 739
    //   247: invokespecial 742	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   250: astore_2
    //   251: aload_2
    //   252: ldc_w 744
    //   255: bipush 37
    //   257: invokevirtual 748	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   260: pop
    //   261: aload_2
    //   262: ldc_w 750
    //   265: aload_0
    //   266: invokevirtual 241	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   269: invokevirtual 753	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   272: pop
    //   273: aload_2
    //   274: ldc_w 764
    //   277: lconst_0
    //   278: invokevirtual 767	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   281: pop
    //   282: aload_2
    //   283: ldc_w 769
    //   286: iconst_0
    //   287: invokevirtual 748	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   290: pop
    //   291: aload_2
    //   292: ldc_w 1915
    //   295: aload_1
    //   296: invokevirtual 758	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   299: pop
    //   300: aload_2
    //   301: ldc 178
    //   303: iconst_0
    //   304: newarray byte
    //   306: invokevirtual 772	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   309: pop
    //   310: aload_2
    //   311: ldc_w 774
    //   314: iconst_0
    //   315: invokevirtual 777	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   318: pop
    //   319: aload_0
    //   320: getfield 138	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   323: aload_2
    //   324: invokevirtual 781	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   327: goto -192 -> 135
    //   330: astore_1
    //   331: aload_0
    //   332: monitorexit
    //   333: aload_1
    //   334: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	PhoneContactManagerImp
    //   17	279	1	localObject1	Object
    //   330	4	1	localObject2	Object
    //   217	107	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	82	330	finally
    //   82	104	330	finally
    //   104	135	330	finally
    //   138	213	330	finally
    //   213	218	330	finally
    //   224	233	330	finally
    //   233	327	330	finally
  }
  
  public void onDestroy()
  {
    this.jdField_f_of_type_JavaUtilList = null;
    this.jdField_e_of_type_JavaUtilList = null;
    this.jdField_h_of_type_JavaUtilList = null;
    this.jdField_j_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    a();
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp
 * JD-Core Version:    0.7.0.1
 */