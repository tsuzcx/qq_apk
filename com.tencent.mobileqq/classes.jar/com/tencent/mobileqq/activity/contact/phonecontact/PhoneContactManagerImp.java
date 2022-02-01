package com.tencent.mobileqq.activity.contact.phonecontact;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import ajbz;
import ajca;
import ajcb;
import ajcc;
import ajcd;
import ajce;
import ajcf;
import ajcg;
import ajch;
import ajci;
import ajcj;
import ajcm;
import ajco;
import ajcr;
import amgo;
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
import anvk;
import anvx;
import arph;
import awyz;
import awza;
import azio;
import azip;
import aziq;
import azir;
import bcrg;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ThemeNoviceGuideActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LastLoginPhoneInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
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
  implements awyz
{
  static volatile long jdField_a_of_type_Long = 120000L;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b;
  static volatile long jdField_b_of_type_Long = 86400000L;
  public static int d;
  public static int e;
  public static boolean f;
  public volatile int a;
  private ajcj jdField_a_of_type_Ajcj;
  private ajcm jdField_a_of_type_Ajcm;
  private ajcr jdField_a_of_type_Ajcr;
  public amgo a;
  public SharedPreferences a;
  private azio jdField_a_of_type_Azio;
  private azip jdField_a_of_type_Azip = new ajch(this);
  private aziq jdField_a_of_type_Aziq = new ajci(this);
  private PhoneContactManagerImp.UploadProgressGenerator jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ContactBinded jdField_a_of_type_ComTencentMobileqqDataContactBinded;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new PhoneContactManagerImp.8(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ContactMatch> jdField_a_of_type_JavaUtilArrayList;
  private LinkedList<awza> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public volatile List<PhoneContact> a;
  private final Random jdField_a_of_type_JavaUtilRandom;
  private volatile Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private ArrayList<PhoneContactAdd> jdField_b_of_type_JavaUtilArrayList;
  List<PhoneContact> jdField_b_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean b;
  public volatile int c;
  public volatile long c;
  private SharedPreferences jdField_c_of_type_AndroidContentSharedPreferences;
  private List<MobileContactsFriendInfo> jdField_c_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean c;
  public volatile long d;
  private List<MobileContactsNotFriendInfo> jdField_d_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_d_of_type_Boolean;
  public volatile long e;
  private List<String> jdField_e_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean e;
  private int jdField_f_of_type_Int = -1;
  public long f;
  private List<PhoneContact> jdField_f_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final int jdField_g_of_type_Int;
  private volatile long jdField_g_of_type_Long;
  private List<PhoneContact> jdField_g_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean g;
  private long jdField_h_of_type_Long;
  private volatile List<PhoneContact> jdField_h_of_type_JavaUtilList;
  private volatile boolean jdField_h_of_type_Boolean = true;
  private List<PhoneContact> jdField_i_of_type_JavaUtilList;
  private boolean jdField_i_of_type_Boolean;
  private List<PhoneContact> jdField_j_of_type_JavaUtilList;
  private volatile boolean jdField_j_of_type_Boolean;
  private List<PhoneContact> jdField_k_of_type_JavaUtilList;
  private boolean jdField_k_of_type_Boolean;
  private List<NotBindContactNotFriendInfo> jdField_l_of_type_JavaUtilList;
  private volatile boolean jdField_l_of_type_Boolean;
  private List<NotBindContactFriendInfo> jdField_m_of_type_JavaUtilList;
  private boolean jdField_m_of_type_Boolean;
  private boolean n;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "data1", "display_name", "contact_id", "data2", "data3" };
    jdField_b_of_type_Int = 20;
    jdField_e_of_type_Int = 2;
  }
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_g_of_type_Boolean = false;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azip);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aziq);
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
    //   0: new 420	java/util/HashMap
    //   3: dup
    //   4: invokespecial 421	java/util/HashMap:<init>	()V
    //   7: astore 12
    //   9: new 154	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 155	java/util/ArrayList:<init>	()V
    //   16: astore 11
    //   18: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: ldc 236
    //   25: iconst_1
    //   26: ldc_w 426
    //   29: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   39: invokevirtual 430	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   42: astore 7
    //   44: aload 7
    //   46: getstatic 436	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   49: getstatic 84	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 442	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 8
    //   60: aload 8
    //   62: ifnull +246 -> 308
    //   65: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +35 -> 103
    //   71: ldc 236
    //   73: iconst_2
    //   74: new 182	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 444
    //   84: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 8
    //   89: invokeinterface 450 1 0
    //   94: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aconst_null
    //   104: astore 7
    //   106: aload_0
    //   107: getfield 276	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   110: invokevirtual 459	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   113: astore 9
    //   115: aload 9
    //   117: astore 7
    //   119: aload 7
    //   121: invokevirtual 464	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   124: aload 8
    //   126: invokeinterface 467 1 0
    //   131: pop
    //   132: aload 8
    //   134: invokeinterface 470 1 0
    //   139: ifne +648 -> 787
    //   142: aload 8
    //   144: aload 8
    //   146: ldc 74
    //   148: invokeinterface 474 2 0
    //   153: invokeinterface 477 2 0
    //   158: invokestatic 482	ajca:a	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 10
    //   163: aload 8
    //   165: aload 8
    //   167: ldc 76
    //   169: invokeinterface 474 2 0
    //   174: invokeinterface 477 2 0
    //   179: astore 9
    //   181: aload 9
    //   183: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifeq +986 -> 1172
    //   189: aload 10
    //   191: astore 9
    //   193: aload 8
    //   195: aload 8
    //   197: ldc 78
    //   199: invokeinterface 474 2 0
    //   204: invokeinterface 486 2 0
    //   209: istore_3
    //   210: aload 8
    //   212: aload 8
    //   214: ldc 80
    //   216: invokeinterface 474 2 0
    //   221: invokeinterface 486 2 0
    //   226: istore 4
    //   228: aload 8
    //   230: aload 8
    //   232: ldc 82
    //   234: invokeinterface 474 2 0
    //   239: invokeinterface 477 2 0
    //   244: astore 13
    //   246: aload 10
    //   248: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +11 -> 262
    //   254: aload 9
    //   256: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   259: ifeq +130 -> 389
    //   262: aload 8
    //   264: invokeinterface 489 1 0
    //   269: pop
    //   270: goto -138 -> 132
    //   273: astore 9
    //   275: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +13 -> 291
    //   281: ldc 236
    //   283: iconst_2
    //   284: ldc 206
    //   286: aload 9
    //   288: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: aload 7
    //   293: ifnull +8 -> 301
    //   296: aload 7
    //   298: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   301: aload 8
    //   303: invokeinterface 498 1 0
    //   308: aload_0
    //   309: iconst_0
    //   310: putfield 134	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_g_of_type_Boolean	Z
    //   313: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +62 -> 378
    //   319: ldc 236
    //   321: iconst_2
    //   322: ldc_w 500
    //   325: iconst_4
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload_1
    //   332: invokevirtual 503	java/util/ArrayList:size	()I
    //   335: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   338: aastore
    //   339: dup
    //   340: iconst_1
    //   341: aload_2
    //   342: invokevirtual 503	java/util/ArrayList:size	()I
    //   345: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: aastore
    //   349: dup
    //   350: iconst_2
    //   351: aload 11
    //   353: invokevirtual 503	java/util/ArrayList:size	()I
    //   356: invokestatic 508	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   365: lload 5
    //   367: lsub
    //   368: invokestatic 244	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   371: aastore
    //   372: invokestatic 248	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   375: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload 11
    //   380: areturn
    //   381: astore 7
    //   383: aconst_null
    //   384: astore 8
    //   386: goto -326 -> 60
    //   389: aload_0
    //   390: getfield 136	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   393: aload 10
    //   395: invokevirtual 512	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   398: checkcast 514	com/tencent/mobileqq/data/PhoneContact
    //   401: astore 14
    //   403: aload 14
    //   405: ifnonnull +174 -> 579
    //   408: new 514	com/tencent/mobileqq/data/PhoneContact
    //   411: dup
    //   412: invokespecial 515	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   415: astore 14
    //   417: aload 14
    //   419: aload 10
    //   421: putfield 516	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   424: aload 14
    //   426: aload 9
    //   428: putfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   431: aload 14
    //   433: iload_3
    //   434: putfield 522	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   437: aload 14
    //   439: iload 4
    //   441: putfield 525	com/tencent/mobileqq/data/PhoneContact:type	I
    //   444: aload 14
    //   446: aload 13
    //   448: putfield 528	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   451: aload 14
    //   453: lload 5
    //   455: putfield 531	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   458: aload 14
    //   460: aload 9
    //   462: iconst_1
    //   463: invokestatic 536	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   466: putfield 539	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   469: aload 14
    //   471: aload 9
    //   473: iconst_2
    //   474: invokestatic 536	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   477: putfield 542	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   480: aload 14
    //   482: aload 14
    //   484: getfield 542	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   487: invokestatic 544	ajca:b	(Ljava/lang/String;)Ljava/lang/String;
    //   490: putfield 547	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   493: aload_0
    //   494: getfield 136	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   497: aload 10
    //   499: aload 14
    //   501: invokevirtual 551	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   504: pop
    //   505: aload 14
    //   507: aload 9
    //   509: aload 10
    //   511: invokestatic 553	ajca:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   514: putfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   517: aload_0
    //   518: getfield 142	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   521: aload 14
    //   523: getfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   526: aload 14
    //   528: invokevirtual 551	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   531: pop
    //   532: aload 11
    //   534: aload 14
    //   536: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   539: pop
    //   540: aload_1
    //   541: new 561	SecurityAccountServer/AddressBookItem
    //   544: dup
    //   545: aload 10
    //   547: aload 9
    //   549: invokespecial 564	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   555: pop
    //   556: goto -294 -> 262
    //   559: astore_1
    //   560: aload 7
    //   562: ifnull +8 -> 570
    //   565: aload 7
    //   567: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   570: aload 8
    //   572: invokeinterface 498 1 0
    //   577: aload_1
    //   578: athrow
    //   579: aload 14
    //   581: iload_3
    //   582: putfield 522	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   585: aload 14
    //   587: lload 5
    //   589: putfield 531	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   592: aload 14
    //   594: getfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   597: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   600: ifeq +33 -> 633
    //   603: aload 14
    //   605: aload 14
    //   607: getfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   610: aload 10
    //   612: invokestatic 553	ajca:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   615: putfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   618: aload_0
    //   619: getfield 142	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   622: aload 14
    //   624: getfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   627: aload 14
    //   629: invokevirtual 551	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   632: pop
    //   633: aload 14
    //   635: getfield 567	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   638: ifeq +122 -> 760
    //   641: aload 9
    //   643: aload 14
    //   645: getfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   648: invokevirtual 377	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   651: ifne +56 -> 707
    //   654: aload 12
    //   656: aload 10
    //   658: aload 9
    //   660: invokevirtual 568	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   663: pop
    //   664: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   667: ifeq -405 -> 262
    //   670: ldc 236
    //   672: iconst_2
    //   673: ldc_w 570
    //   676: iconst_3
    //   677: anewarray 4	java/lang/Object
    //   680: dup
    //   681: iconst_0
    //   682: aload 14
    //   684: getfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   687: aastore
    //   688: dup
    //   689: iconst_1
    //   690: aload 9
    //   692: aastore
    //   693: dup
    //   694: iconst_2
    //   695: aload 10
    //   697: aastore
    //   698: invokestatic 248	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   701: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: goto -442 -> 262
    //   707: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq +39 -> 749
    //   713: aload 12
    //   715: aload 10
    //   717: invokevirtual 573	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   720: ifeq +29 -> 749
    //   723: ldc 236
    //   725: iconst_2
    //   726: ldc_w 575
    //   729: iconst_2
    //   730: anewarray 4	java/lang/Object
    //   733: dup
    //   734: iconst_0
    //   735: aload 9
    //   737: aastore
    //   738: dup
    //   739: iconst_1
    //   740: aload 10
    //   742: aastore
    //   743: invokestatic 248	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   746: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: aload 12
    //   751: aload 10
    //   753: invokevirtual 578	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   756: pop
    //   757: goto -495 -> 262
    //   760: aload_1
    //   761: new 561	SecurityAccountServer/AddressBookItem
    //   764: dup
    //   765: aload 10
    //   767: aload 9
    //   769: invokespecial 564	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   772: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   775: pop
    //   776: aload 11
    //   778: aload 14
    //   780: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   783: pop
    //   784: goto -522 -> 262
    //   787: aload 12
    //   789: invokevirtual 582	java/util/HashMap:keySet	()Ljava/util/Set;
    //   792: invokeinterface 588 1 0
    //   797: astore 9
    //   799: aload 9
    //   801: invokeinterface 593 1 0
    //   806: ifeq +176 -> 982
    //   809: aload 9
    //   811: invokeinterface 597 1 0
    //   816: checkcast 72	java/lang/String
    //   819: astore 10
    //   821: aload_0
    //   822: getfield 136	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   825: aload 10
    //   827: invokevirtual 512	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   830: checkcast 514	com/tencent/mobileqq/data/PhoneContact
    //   833: astore 13
    //   835: aload 13
    //   837: ifnull -38 -> 799
    //   840: aload 12
    //   842: aload 10
    //   844: invokevirtual 598	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   847: checkcast 72	java/lang/String
    //   850: astore 14
    //   852: aload_2
    //   853: new 561	SecurityAccountServer/AddressBookItem
    //   856: dup
    //   857: aload 10
    //   859: aload 13
    //   861: getfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   864: invokespecial 564	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   867: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   870: pop
    //   871: aload_1
    //   872: new 561	SecurityAccountServer/AddressBookItem
    //   875: dup
    //   876: aload 10
    //   878: aload 14
    //   880: invokespecial 564	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   883: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   886: pop
    //   887: aload 13
    //   889: aload 14
    //   891: putfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   894: aload 13
    //   896: aload 14
    //   898: iconst_1
    //   899: invokestatic 536	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   902: putfield 539	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   905: aload 13
    //   907: aload 14
    //   909: iconst_2
    //   910: invokestatic 536	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   913: putfield 542	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   916: aload 13
    //   918: aload 13
    //   920: getfield 542	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   923: invokestatic 544	ajca:b	(Ljava/lang/String;)Ljava/lang/String;
    //   926: putfield 547	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   929: aload_0
    //   930: getfield 142	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   933: aload 13
    //   935: getfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   938: aload 13
    //   940: invokevirtual 601	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   943: pop
    //   944: aload 13
    //   946: aload 14
    //   948: aload 10
    //   950: invokestatic 553	ajca:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   953: putfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   956: aload_0
    //   957: getfield 142	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   960: aload 13
    //   962: getfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   965: aload 13
    //   967: invokevirtual 551	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   970: pop
    //   971: aload 11
    //   973: aload 13
    //   975: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   978: pop
    //   979: goto -180 -> 799
    //   982: new 154	java/util/ArrayList
    //   985: dup
    //   986: invokespecial 155	java/util/ArrayList:<init>	()V
    //   989: astore 9
    //   991: aload_0
    //   992: getfield 136	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   995: invokevirtual 604	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   998: invokeinterface 588 1 0
    //   1003: astore 10
    //   1005: aload 10
    //   1007: invokeinterface 593 1 0
    //   1012: ifeq +105 -> 1117
    //   1015: aload 10
    //   1017: invokeinterface 597 1 0
    //   1022: checkcast 606	java/util/Map$Entry
    //   1025: invokeinterface 609 1 0
    //   1030: checkcast 514	com/tencent/mobileqq/data/PhoneContact
    //   1033: astore 12
    //   1035: aload 12
    //   1037: getfield 531	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   1040: lload 5
    //   1042: lcmp
    //   1043: ifeq -38 -> 1005
    //   1046: aload 12
    //   1048: getfield 612	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1051: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1054: ifne +16 -> 1070
    //   1057: aload_0
    //   1058: getfield 138	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   1061: aload 12
    //   1063: getfield 612	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1066: invokevirtual 613	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1069: pop
    //   1070: aload 10
    //   1072: invokeinterface 615 1 0
    //   1077: aload_0
    //   1078: getfield 276	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1081: aload 12
    //   1083: invokevirtual 618	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1086: pop
    //   1087: aload_2
    //   1088: new 561	SecurityAccountServer/AddressBookItem
    //   1091: dup
    //   1092: aload 12
    //   1094: getfield 516	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1097: aload 12
    //   1099: getfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1102: invokespecial 564	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1105: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1108: pop
    //   1109: aload 9
    //   1111: invokevirtual 621	java/util/ArrayList:clear	()V
    //   1114: goto -109 -> 1005
    //   1117: aload 7
    //   1119: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1122: aload 7
    //   1124: ifnull +8 -> 1132
    //   1127: aload 7
    //   1129: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1132: aload 8
    //   1134: invokeinterface 498 1 0
    //   1139: goto -831 -> 308
    //   1142: astore 7
    //   1144: goto -836 -> 308
    //   1147: astore 7
    //   1149: goto -841 -> 308
    //   1152: astore_2
    //   1153: goto -576 -> 577
    //   1156: astore_1
    //   1157: aconst_null
    //   1158: astore 7
    //   1160: goto -600 -> 560
    //   1163: astore_1
    //   1164: goto -604 -> 560
    //   1167: astore 9
    //   1169: goto -894 -> 275
    //   1172: goto -979 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1175	0	this	PhoneContactManagerImp
    //   0	1175	1	paramArrayList1	ArrayList<AddressBookItem>
    //   0	1175	2	paramArrayList2	ArrayList<AddressBookItem>
    //   209	373	3	i1	int
    //   226	214	4	i2	int
    //   21	1020	5	l1	long
    //   42	255	7	localObject1	Object
    //   381	747	7	localThrowable	Throwable
    //   1142	1	7	localException1	Exception
    //   1147	1	7	localException2	Exception
    //   1158	1	7	localObject2	Object
    //   58	1075	8	localCursor	Cursor
    //   113	142	9	localObject3	Object
    //   273	495	9	localStaleDataException1	StaleDataException
    //   797	313	9	localObject4	Object
    //   1167	1	9	localStaleDataException2	StaleDataException
    //   161	910	10	localObject5	Object
    //   16	956	11	localArrayList	ArrayList
    //   7	1091	12	localObject6	Object
    //   244	730	13	localObject7	Object
    //   401	546	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   119	132	273	android/database/StaleDataException
    //   132	189	273	android/database/StaleDataException
    //   193	262	273	android/database/StaleDataException
    //   262	270	273	android/database/StaleDataException
    //   389	403	273	android/database/StaleDataException
    //   408	556	273	android/database/StaleDataException
    //   579	633	273	android/database/StaleDataException
    //   633	704	273	android/database/StaleDataException
    //   707	749	273	android/database/StaleDataException
    //   749	757	273	android/database/StaleDataException
    //   760	784	273	android/database/StaleDataException
    //   787	799	273	android/database/StaleDataException
    //   799	835	273	android/database/StaleDataException
    //   840	979	273	android/database/StaleDataException
    //   982	1005	273	android/database/StaleDataException
    //   1005	1070	273	android/database/StaleDataException
    //   1070	1114	273	android/database/StaleDataException
    //   1117	1122	273	android/database/StaleDataException
    //   44	60	381	java/lang/Throwable
    //   119	132	559	finally
    //   132	189	559	finally
    //   193	262	559	finally
    //   262	270	559	finally
    //   389	403	559	finally
    //   408	556	559	finally
    //   579	633	559	finally
    //   633	704	559	finally
    //   707	749	559	finally
    //   749	757	559	finally
    //   760	784	559	finally
    //   787	799	559	finally
    //   799	835	559	finally
    //   840	979	559	finally
    //   982	1005	559	finally
    //   1005	1070	559	finally
    //   1070	1114	559	finally
    //   1117	1122	559	finally
    //   1132	1139	1142	java/lang/Exception
    //   301	308	1147	java/lang/Exception
    //   570	577	1152	java/lang/Exception
    //   106	115	1156	finally
    //   275	291	1163	finally
    //   106	115	1167	android/database/StaleDataException
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
          break label106;
        }
      }
    }
    label106:
    for (String str = anvx.a(2131707456); Thread.currentThread() == Looper.getMainLooper().getThread(); str = anvx.a(2131707450))
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
      QQToast.a(localBaseApplication, i1, paramString, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131299080));
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
          break label236;
        }
        i2 = 0;
        if (paramArrayList != null) {
          break label245;
        }
        i3 = 0;
        QLog.d("PhoneContact.Manager", 2, String.format("doUpdateContact bind:%s, add:%s, del:%s, rename:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) }));
      }
    }
    else
    {
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
      if (!paramBoolean) {
        break label255;
      }
    }
    label236:
    label245:
    label255:
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
      i2 = paramArrayList2.size();
      break label39;
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
        ((ajco)localQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).jdField_a_of_type_Boolean = true;
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
              break label654;
            }
            QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList foreground=%b [interval:%s, limit:%s]", new Object[] { Boolean.valueOf(this.jdField_h_of_type_Boolean), Long.valueOf(l1), Long.valueOf(jdField_b_of_type_Long) }));
            break label654;
          }
          if ((!paramBoolean1) && (l1 < jdField_a_of_type_Long))
          {
            if (!QLog.isColorLevel()) {
              break label659;
            }
            QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList [interval:%s, limit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(jdField_a_of_type_Long) }));
            break label659;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_c_of_type_JavaUtilList = null;
          this.jdField_d_of_type_JavaUtilList = null;
          localObject2 = new NewIntent(localQQAppInterface.getApplication(), azir.class);
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
      label654:
      paramBoolean1 = false;
      continue;
      label659:
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
          break label395;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataContactBinded == null) || (paramList.size() > jdField_b_of_type_Int)) {
          break label442;
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
      ((ContactMatch)localObject2).timestamp = bcrg.a();
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
    label395:
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
      label442:
      if (this.jdField_a_of_type_ComTencentMobileqqDataContactBinded == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = new ContactBinded();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.timestamp = bcrg.a();
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
    label108:
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
                break label108;
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
    if (!VersionUtils.isM()) {
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
          break label846;
        }
        localObject1 = localObject3;
        bool2 = bool1;
        if (i1 != 3) {
          break label833;
        }
        localObject1 = localObject3;
        bool2 = bool1;
        if (a() == null) {
          break label833;
        }
        localObject1 = localObject3;
        bool2 = bool1;
        if (a().lastUsedFlag != 3L) {
          break label833;
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
        return false;
      }
      if (localObject1 != null)
      {
        if (l2 < 3600000L)
        {
          if (!QLog.isColorLevel()) {
            break label844;
          }
          QLog.i("PhoneContact.Manager", 2, String.format("showBindPhonePage just last unbind mobile [%s, %s, %s]", new Object[] { Long.valueOf(l1), Long.valueOf(this.jdField_h_of_type_Long), Long.valueOf(3600000L) }));
          break label844;
          if ((a() == null) || (a().lastUsedFlag != 3L)) {
            break label888;
          }
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), PhoneMatchActivity.class);
          continue;
          localObject1 = a();
          if ((f()) || (localObject1 == null) || (((RespondQueryQQBindingStat)localObject1).isStopFindMatch)) {
            break label888;
          }
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), PhoneMatchActivity.class);
          if (bool3) {
            ((Intent)localObject1).putExtra("key_from_contact_first", true);
          }
        }
        else
        {
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
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject3, (String)localObject3, 0, 0, "", "", "", "");
            }
            localObject3 = BaseActivity.sTopActivity;
            if ((localObject3 == null) || (((AppActivity)localObject3).isFinishing()) || (((AppActivity)localObject3).getAppRuntime() != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              break label700;
            }
            ((AppActivity)localObject3).startActivity((Intent)localObject1);
            ((AppActivity)localObject3).overridePendingTransition(2130772299, 2130771990);
            if ((!paramBoolean) || (!bool1)) {
              continue;
            }
            s();
            break label905;
          }
          localObject3 = str1;
          if (!str2.equals(PhoneMatchActivity.class.getName())) {
            continue;
          }
          localObject3 = "0X80095EA";
          continue;
          if ((!paramBoolean) && (bool3))
          {
            t();
            break label905;
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_pop_time_for_switchphone", System.currentTimeMillis()).commit();
          break label905;
          label700:
          if (!QLog.isColorLevel()) {
            break label909;
          }
          QLog.d("PhoneContact.Manager", 2, "showBindPhonePage topActivity invalid");
          break label909;
        }
      }
      else
      {
        if ((paramBoolean) || (!bool3)) {
          break;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        if ((localObject2 == null) || (((SharedPreferences)localObject2).getBoolean("THEME_NOVICE_GUIDE_RUNED", false)) || (!BaseApplicationImpl.IS_SUPPORT_THEME)) {
          break;
        }
        ((SharedPreferences)localObject2).edit().putBoolean("THEME_NOVICE_GUIDE_RUNED", true).commit();
        localObject2 = new Intent(BaseActivity.sTopActivity, ThemeNoviceGuideActivity.class);
        BaseActivity.sTopActivity.startActivity((Intent)localObject2);
        BaseActivity.sTopActivity.overridePendingTransition(2130771979, 2130771980);
        t();
        return false;
      }
      continue;
      label833:
      while (!bool2)
      {
        bool1 = bool2;
        break;
      }
      bool1 = bool2;
      continue;
      label844:
      return false;
      label846:
      switch (i1)
      {
      }
      label888:
      do
      {
        localObject2 = null;
        break;
      } while (!bool3);
      Object localObject2 = null;
    }
    label905:
    label909:
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
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
    //   7: invokespecial 1315	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:o	()V
    //   10: ldc 236
    //   12: iconst_1
    //   13: ldc_w 1317
    //   16: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   26: invokevirtual 430	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   29: getstatic 436	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   32: getstatic 84	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 442	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 7
    //   43: new 154	java/util/ArrayList
    //   46: dup
    //   47: invokespecial 155	java/util/ArrayList:<init>	()V
    //   50: astore 12
    //   52: aload 7
    //   54: ifnull +777 -> 831
    //   57: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   60: lstore_3
    //   61: aload 7
    //   63: invokeinterface 450 1 0
    //   68: istore_1
    //   69: aload 12
    //   71: iload_1
    //   72: invokevirtual 1320	java/util/ArrayList:ensureCapacity	(I)V
    //   75: new 111	java/util/concurrent/ConcurrentHashMap
    //   78: dup
    //   79: iload_1
    //   80: invokespecial 1321	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   83: astore 13
    //   85: aload 8
    //   87: astore 6
    //   89: aload 9
    //   91: astore 5
    //   93: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +37 -> 133
    //   99: aload 8
    //   101: astore 6
    //   103: aload 9
    //   105: astore 5
    //   107: ldc 236
    //   109: iconst_2
    //   110: new 182	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 1323
    //   120: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload_1
    //   124: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 8
    //   135: astore 6
    //   137: aload 9
    //   139: astore 5
    //   141: aload_0
    //   142: getfield 276	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   145: invokevirtual 459	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   148: astore 8
    //   150: aload 8
    //   152: astore 6
    //   154: aload 8
    //   156: astore 5
    //   158: aload 8
    //   160: invokevirtual 464	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   163: aload 8
    //   165: astore 6
    //   167: aload 8
    //   169: astore 5
    //   171: aload 7
    //   173: invokeinterface 467 1 0
    //   178: pop
    //   179: aload 8
    //   181: astore 6
    //   183: aload 8
    //   185: astore 5
    //   187: aload 7
    //   189: invokeinterface 470 1 0
    //   194: ifne +599 -> 793
    //   197: aload 8
    //   199: astore 6
    //   201: aload 8
    //   203: astore 5
    //   205: aload 7
    //   207: aload 7
    //   209: ldc 74
    //   211: invokeinterface 474 2 0
    //   216: invokeinterface 477 2 0
    //   221: invokestatic 482	ajca:a	(Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 10
    //   226: aload 8
    //   228: astore 6
    //   230: aload 8
    //   232: astore 5
    //   234: aload 7
    //   236: aload 7
    //   238: ldc 76
    //   240: invokeinterface 474 2 0
    //   245: invokeinterface 477 2 0
    //   250: astore 11
    //   252: aload 11
    //   254: astore 9
    //   256: aload 8
    //   258: astore 6
    //   260: aload 8
    //   262: astore 5
    //   264: aload 11
    //   266: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   269: ifeq +7 -> 276
    //   272: aload 10
    //   274: astore 9
    //   276: aload 8
    //   278: astore 6
    //   280: aload 8
    //   282: astore 5
    //   284: aload 7
    //   286: aload 7
    //   288: ldc 78
    //   290: invokeinterface 474 2 0
    //   295: invokeinterface 486 2 0
    //   300: istore_1
    //   301: aload 8
    //   303: astore 6
    //   305: aload 8
    //   307: astore 5
    //   309: aload 7
    //   311: aload 7
    //   313: ldc 80
    //   315: invokeinterface 474 2 0
    //   320: invokeinterface 486 2 0
    //   325: istore_2
    //   326: aload 8
    //   328: astore 6
    //   330: aload 8
    //   332: astore 5
    //   334: aload 7
    //   336: aload 7
    //   338: ldc 82
    //   340: invokeinterface 474 2 0
    //   345: invokeinterface 477 2 0
    //   350: astore 11
    //   352: aload 8
    //   354: astore 6
    //   356: aload 8
    //   358: astore 5
    //   360: aload 10
    //   362: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   365: ifne +19 -> 384
    //   368: aload 8
    //   370: astore 6
    //   372: aload 8
    //   374: astore 5
    //   376: aload 9
    //   378: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   381: ifeq +146 -> 527
    //   384: aload 8
    //   386: astore 6
    //   388: aload 8
    //   390: astore 5
    //   392: aload 7
    //   394: invokeinterface 489 1 0
    //   399: pop
    //   400: goto -221 -> 179
    //   403: astore 8
    //   405: aload 6
    //   407: astore 5
    //   409: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +17 -> 429
    //   415: aload 6
    //   417: astore 5
    //   419: ldc 236
    //   421: iconst_2
    //   422: ldc 206
    //   424: aload 8
    //   426: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aload 6
    //   431: ifnull +8 -> 439
    //   434: aload 6
    //   436: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   439: aload 7
    //   441: invokeinterface 498 1 0
    //   446: aload_0
    //   447: aload 13
    //   449: invokespecial 1325	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   452: aload_0
    //   453: getfield 136	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   456: invokevirtual 1329	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   459: invokeinterface 1332 1 0
    //   464: astore 5
    //   466: aload 5
    //   468: invokeinterface 593 1 0
    //   473: ifeq +358 -> 831
    //   476: aload 5
    //   478: invokeinterface 597 1 0
    //   483: checkcast 514	com/tencent/mobileqq/data/PhoneContact
    //   486: astore 6
    //   488: aload 12
    //   490: new 561	SecurityAccountServer/AddressBookItem
    //   493: dup
    //   494: aload 6
    //   496: getfield 516	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   499: aload 6
    //   501: getfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   504: invokespecial 564	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: invokevirtual 559	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   510: pop
    //   511: goto -45 -> 466
    //   514: astore 5
    //   516: aload 5
    //   518: invokevirtual 1333	java/lang/Exception:printStackTrace	()V
    //   521: aconst_null
    //   522: astore 7
    //   524: goto -481 -> 43
    //   527: aload 8
    //   529: astore 6
    //   531: aload 8
    //   533: astore 5
    //   535: new 514	com/tencent/mobileqq/data/PhoneContact
    //   538: dup
    //   539: invokespecial 515	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   542: astore 14
    //   544: aload 8
    //   546: astore 6
    //   548: aload 8
    //   550: astore 5
    //   552: aload 14
    //   554: aload 10
    //   556: putfield 516	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   559: aload 8
    //   561: astore 6
    //   563: aload 8
    //   565: astore 5
    //   567: aload 14
    //   569: aload 9
    //   571: putfield 519	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   574: aload 8
    //   576: astore 6
    //   578: aload 8
    //   580: astore 5
    //   582: aload 14
    //   584: iload_1
    //   585: putfield 522	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   588: aload 8
    //   590: astore 6
    //   592: aload 8
    //   594: astore 5
    //   596: aload 14
    //   598: iload_2
    //   599: putfield 525	com/tencent/mobileqq/data/PhoneContact:type	I
    //   602: aload 8
    //   604: astore 6
    //   606: aload 8
    //   608: astore 5
    //   610: aload 14
    //   612: aload 11
    //   614: putfield 528	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   617: aload 8
    //   619: astore 6
    //   621: aload 8
    //   623: astore 5
    //   625: aload 14
    //   627: lload_3
    //   628: putfield 531	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   631: aload 8
    //   633: astore 6
    //   635: aload 8
    //   637: astore 5
    //   639: aload 14
    //   641: aload 9
    //   643: iconst_1
    //   644: invokestatic 536	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   647: putfield 539	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   650: aload 8
    //   652: astore 6
    //   654: aload 8
    //   656: astore 5
    //   658: aload 14
    //   660: aload 9
    //   662: iconst_2
    //   663: invokestatic 536	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   666: putfield 542	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   669: aload 8
    //   671: astore 6
    //   673: aload 8
    //   675: astore 5
    //   677: aload 14
    //   679: aload 14
    //   681: getfield 542	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   684: invokestatic 544	ajca:b	(Ljava/lang/String;)Ljava/lang/String;
    //   687: putfield 547	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   690: aload 8
    //   692: astore 6
    //   694: aload 8
    //   696: astore 5
    //   698: aload 14
    //   700: aload 9
    //   702: aload 10
    //   704: invokestatic 553	ajca:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   707: putfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   710: aload 8
    //   712: astore 6
    //   714: aload 8
    //   716: astore 5
    //   718: aload 13
    //   720: aload 10
    //   722: aload 14
    //   724: invokevirtual 551	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   727: pop
    //   728: aload 8
    //   730: astore 6
    //   732: aload 8
    //   734: astore 5
    //   736: aload_0
    //   737: getfield 142	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   740: aload 14
    //   742: getfield 556	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   745: aload 14
    //   747: invokevirtual 551	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   750: pop
    //   751: aload 8
    //   753: astore 6
    //   755: aload 8
    //   757: astore 5
    //   759: aload_0
    //   760: getfield 276	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   763: aload 14
    //   765: invokevirtual 1337	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   768: goto -384 -> 384
    //   771: astore 6
    //   773: aload 5
    //   775: ifnull +8 -> 783
    //   778: aload 5
    //   780: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   783: aload 7
    //   785: invokeinterface 498 1 0
    //   790: aload 6
    //   792: athrow
    //   793: aload 8
    //   795: astore 6
    //   797: aload 8
    //   799: astore 5
    //   801: aload 8
    //   803: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   806: aload 8
    //   808: ifnull +8 -> 816
    //   811: aload 8
    //   813: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   816: aload 7
    //   818: invokeinterface 498 1 0
    //   823: goto -377 -> 446
    //   826: astore 5
    //   828: goto -382 -> 446
    //   831: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +33 -> 867
    //   837: ldc 236
    //   839: iconst_2
    //   840: new 182	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   847: ldc_w 1339
    //   850: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload 12
    //   855: invokevirtual 503	java/util/ArrayList:size	()I
    //   858: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   861: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: aload_0
    //   868: iconst_1
    //   869: putfield 1341	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   872: aload 12
    //   874: areturn
    //   875: astore 5
    //   877: goto -431 -> 446
    //   880: astore 5
    //   882: goto -92 -> 790
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	885	0	this	PhoneContactManagerImp
    //   68	517	1	i1	int
    //   325	274	2	i2	int
    //   60	568	3	l1	long
    //   91	386	5	localObject1	Object
    //   514	3	5	localException1	Exception
    //   533	267	5	localStaleDataException1	StaleDataException
    //   826	1	5	localException2	Exception
    //   875	1	5	localException3	Exception
    //   880	1	5	localException4	Exception
    //   87	667	6	localObject2	Object
    //   771	20	6	localObject3	Object
    //   795	1	6	localStaleDataException2	StaleDataException
    //   41	776	7	localCursor	Cursor
    //   4	385	8	localEntityTransaction	EntityTransaction
    //   403	409	8	localStaleDataException3	StaleDataException
    //   1	700	9	localObject4	Object
    //   224	497	10	str1	String
    //   250	363	11	str2	String
    //   50	823	12	localArrayList	ArrayList
    //   83	636	13	localConcurrentHashMap	ConcurrentHashMap
    //   542	222	14	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   93	99	403	android/database/StaleDataException
    //   107	133	403	android/database/StaleDataException
    //   141	150	403	android/database/StaleDataException
    //   158	163	403	android/database/StaleDataException
    //   171	179	403	android/database/StaleDataException
    //   187	197	403	android/database/StaleDataException
    //   205	226	403	android/database/StaleDataException
    //   234	252	403	android/database/StaleDataException
    //   264	272	403	android/database/StaleDataException
    //   284	301	403	android/database/StaleDataException
    //   309	326	403	android/database/StaleDataException
    //   334	352	403	android/database/StaleDataException
    //   360	368	403	android/database/StaleDataException
    //   376	384	403	android/database/StaleDataException
    //   392	400	403	android/database/StaleDataException
    //   535	544	403	android/database/StaleDataException
    //   552	559	403	android/database/StaleDataException
    //   567	574	403	android/database/StaleDataException
    //   582	588	403	android/database/StaleDataException
    //   596	602	403	android/database/StaleDataException
    //   610	617	403	android/database/StaleDataException
    //   625	631	403	android/database/StaleDataException
    //   639	650	403	android/database/StaleDataException
    //   658	669	403	android/database/StaleDataException
    //   677	690	403	android/database/StaleDataException
    //   698	710	403	android/database/StaleDataException
    //   718	728	403	android/database/StaleDataException
    //   736	751	403	android/database/StaleDataException
    //   759	768	403	android/database/StaleDataException
    //   801	806	403	android/database/StaleDataException
    //   19	43	514	java/lang/Exception
    //   93	99	771	finally
    //   107	133	771	finally
    //   141	150	771	finally
    //   158	163	771	finally
    //   171	179	771	finally
    //   187	197	771	finally
    //   205	226	771	finally
    //   234	252	771	finally
    //   264	272	771	finally
    //   284	301	771	finally
    //   309	326	771	finally
    //   334	352	771	finally
    //   360	368	771	finally
    //   376	384	771	finally
    //   392	400	771	finally
    //   409	415	771	finally
    //   419	429	771	finally
    //   535	544	771	finally
    //   552	559	771	finally
    //   567	574	771	finally
    //   582	588	771	finally
    //   596	602	771	finally
    //   610	617	771	finally
    //   625	631	771	finally
    //   639	650	771	finally
    //   658	669	771	finally
    //   677	690	771	finally
    //   698	710	771	finally
    //   718	728	771	finally
    //   736	751	771	finally
    //   759	768	771	finally
    //   801	806	771	finally
    //   816	823	826	java/lang/Exception
    //   439	446	875	java/lang/Exception
    //   783	790	880	java/lang/Exception
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
      if (this.jdField_a_of_type_Azio == null) {
        this.jdField_a_of_type_Azio = ((azio)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER));
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80095EE", "0X80095EE", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Azio.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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
      if (this.jdField_a_of_type_Azio == null) {
        this.jdField_a_of_type_Azio = ((azio)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER));
      }
      this.jdField_a_of_type_Azio.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramBoolean);
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
      this.jdField_a_of_type_Ajcm = new ajcm(new Handler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getMainLooper()));
      this.jdField_a_of_type_Ajcm.a(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_Ajcm);
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
    //   4: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +76 -> 83
    //   10: new 182	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 974	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 1466
    //   24: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   31: invokevirtual 891	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: ldc_w 1468
    //   39: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   46: invokevirtual 891	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: ldc_w 1470
    //   54: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   60: aload_0
    //   61: getfield 107	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   64: lsub
    //   65: ldc2_w 992
    //   68: ldiv
    //   69: invokevirtual 979	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 236
    //   75: iconst_2
    //   76: aload_3
    //   77: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iload_2
    //   84: istore_1
    //   85: aload_0
    //   86: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   89: ifne +14 -> 103
    //   92: aload_0
    //   93: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   96: istore_1
    //   97: iload_1
    //   98: ifeq +9 -> 107
    //   101: iload_2
    //   102: istore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_1
    //   106: ireturn
    //   107: iload_2
    //   108: istore_1
    //   109: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   112: aload_0
    //   113: getfield 107	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   116: lsub
    //   117: ldc2_w 63
    //   120: lcmp
    //   121: iflt -18 -> 103
    //   124: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +12 -> 139
    //   130: ldc 236
    //   132: iconst_2
    //   133: ldc_w 1472
    //   136: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: new 154	java/util/ArrayList
    //   142: dup
    //   143: invokespecial 155	java/util/ArrayList:<init>	()V
    //   146: astore_3
    //   147: new 154	java/util/ArrayList
    //   150: dup
    //   151: invokespecial 155	java/util/ArrayList:<init>	()V
    //   154: astore 4
    //   156: aload_0
    //   157: aload_3
    //   158: aload 4
    //   160: invokespecial 1474	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   163: astore 5
    //   165: aload_3
    //   166: invokevirtual 1475	java/util/ArrayList:isEmpty	()Z
    //   169: ifeq +13 -> 182
    //   172: iload_2
    //   173: istore_1
    //   174: aload 4
    //   176: invokevirtual 1475	java/util/ArrayList:isEmpty	()Z
    //   179: ifne -76 -> 103
    //   182: aload_0
    //   183: aload_0
    //   184: aload_0
    //   185: invokevirtual 344	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   188: aload_3
    //   189: aload 4
    //   191: aload 5
    //   193: iconst_1
    //   194: invokespecial 1477	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   197: putfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   200: aload_0
    //   201: iconst_1
    //   202: invokespecial 791	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(I)V
    //   205: iconst_1
    //   206: istore_1
    //   207: goto -104 -> 103
    //   210: astore_3
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_3
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	PhoneContactManagerImp
    //   84	123	1	bool1	boolean
    //   1	172	2	bool2	boolean
    //   19	170	3	localObject1	Object
    //   210	4	3	localObject2	Object
    //   154	36	4	localArrayList1	ArrayList
    //   163	29	5	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   4	83	210	finally
    //   85	97	210	finally
    //   109	139	210	finally
    //   139	172	210	finally
    //   174	182	210	finally
    //   182	205	210	finally
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
    if (!"8.4.10".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped_notbind", ""))) {}
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
            break label393;
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
        label393:
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
    if (!"8.4.10".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped", ""))) {}
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
    //   4: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +76 -> 83
    //   10: new 182	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 974	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 1466
    //   24: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   31: invokevirtual 891	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: ldc_w 1468
    //   39: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   46: invokevirtual 891	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: ldc_w 1470
    //   54: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   60: aload_0
    //   61: getfield 107	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   64: lsub
    //   65: ldc2_w 992
    //   68: ldiv
    //   69: invokevirtual 979	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 236
    //   75: iconst_2
    //   76: aload_3
    //   77: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iload_2
    //   84: istore_1
    //   85: aload_0
    //   86: getfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   89: ifne +14 -> 103
    //   92: aload_0
    //   93: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   96: istore_1
    //   97: iload_1
    //   98: ifeq +9 -> 107
    //   101: iload_2
    //   102: istore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_1
    //   106: ireturn
    //   107: iload_2
    //   108: istore_1
    //   109: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   112: aload_0
    //   113: getfield 107	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   116: lsub
    //   117: ldc2_w 63
    //   120: lcmp
    //   121: iflt -18 -> 103
    //   124: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +12 -> 139
    //   130: ldc 236
    //   132: iconst_2
    //   133: ldc_w 1515
    //   136: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: new 154	java/util/ArrayList
    //   142: dup
    //   143: invokespecial 155	java/util/ArrayList:<init>	()V
    //   146: astore_3
    //   147: new 154	java/util/ArrayList
    //   150: dup
    //   151: invokespecial 155	java/util/ArrayList:<init>	()V
    //   154: astore 4
    //   156: aload_0
    //   157: aload_3
    //   158: aload 4
    //   160: invokespecial 1474	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   163: astore 5
    //   165: aload_3
    //   166: invokevirtual 1475	java/util/ArrayList:isEmpty	()Z
    //   169: ifeq +13 -> 182
    //   172: iload_2
    //   173: istore_1
    //   174: aload 4
    //   176: invokevirtual 1475	java/util/ArrayList:isEmpty	()Z
    //   179: ifne -76 -> 103
    //   182: aload_0
    //   183: aload_0
    //   184: aload_0
    //   185: invokevirtual 344	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   188: aload_3
    //   189: aload 4
    //   191: aload 5
    //   193: iconst_0
    //   194: invokespecial 1477	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   197: putfield 105	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   200: aload_0
    //   201: iconst_1
    //   202: invokespecial 791	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(I)V
    //   205: iconst_1
    //   206: istore_1
    //   207: goto -104 -> 103
    //   210: astore_3
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_3
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	PhoneContactManagerImp
    //   84	123	1	bool1	boolean
    //   1	172	2	bool2	boolean
    //   19	170	3	localObject1	Object
    //   210	4	3	localObject2	Object
    //   154	36	4	localArrayList1	ArrayList
    //   163	29	5	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   4	83	210	finally
    //   85	97	210	finally
    //   109	139	210	finally
    //   139	172	210	finally
    //   174	182	210	finally
    //   182	205	210	finally
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped_notbind", "8.4.10").commit();
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped", "8.4.10").commit();
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
    if (this.jdField_a_of_type_Ajcj != null) {
      this.jdField_a_of_type_Ajcj.cancel(true);
    }
    this.jdField_a_of_type_Ajcj = new ajcj(this, null);
    this.jdField_a_of_type_Ajcj.a(paramList);
    this.jdField_a_of_type_Ajcj.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
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
        break label131;
      }
      this.jdField_l_of_type_JavaUtilList = paramArrayList1;
    }
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean)) {
        break label146;
      }
      return 0;
      this.jdField_m_of_type_JavaUtilList.addAll(paramArrayList);
      break;
      label131:
      this.jdField_l_of_type_JavaUtilList.addAll(paramArrayList1);
    }
    label146:
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
          break label719;
        }
        i1 = this.jdField_l_of_type_JavaUtilList.size();
        label300:
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
        break label1365;
      }
      paramArrayList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
          break label780;
        }
        localObject3 = (NotBindContactFriendInfo)((Iterator)localObject2).next();
        paramArrayList = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramArrayList == null) {
          break label725;
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
          localObject3 = ((anvk)localObject1).e(paramArrayList.uin);
          if (localObject3 != null) {
            paramArrayList.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayList.uin, paramArrayList);
          ((anvk)localObject1).a(paramArrayList.unifiedCode, false);
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
          break label770;
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
      label719:
      i1 = -1;
      break label300;
      label725:
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean;
        continue;
        label770:
        paramArrayList = paramArrayList.toString();
      }
    }
    label780:
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
                break label1383;
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
              break label1383;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean;
            break label1383;
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
      label1365:
      paramBoolean = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean;
      paramBoolean = bool2;
      break;
      label1383:
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
        break label131;
      }
      this.jdField_d_of_type_JavaUtilList = paramList1;
    }
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean1)) {
        break label146;
      }
      return 0;
      this.jdField_c_of_type_JavaUtilList.addAll(paramList);
      break;
      label131:
      this.jdField_d_of_type_JavaUtilList.addAll(paramList1);
    }
    label146:
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
          break label778;
        }
        i1 = this.jdField_d_of_type_JavaUtilList.size();
        label311:
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
        break label1562;
      }
      if (!paramBoolean2) {}
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
          break label839;
        }
        localObject3 = (MobileContactsFriendInfo)((Iterator)localObject2).next();
        paramList = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramList == null) {
          break label784;
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
          localObject3 = ((anvk)localObject1).e(paramList.uin);
          if (localObject3 != null) {
            paramList.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList.uin, paramList);
          ((anvk)localObject1).a(paramList.unifiedCode, false);
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
          break label829;
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
      label778:
      i1 = -1;
      break label311;
      label784:
      bool1 = paramBoolean1;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean1;
        continue;
        label829:
        paramList = paramList.unifiedCode;
      }
    }
    label839:
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
                break label1580;
              }
              QLog.d("PhoneContact.Manager", 2, "MobileContactsNotFriendInfo; mobile=" + ((PhoneContact)localObject3).unifiedCode + " hide=" + ((PhoneContact)localObject3).isHiden);
              paramBoolean1 = true;
              break;
            }
            bool3 = bool1;
            bool2 = paramBoolean1;
            if (!QLog.isColorLevel()) {
              break label1580;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean1;
            break label1580;
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
      label1562:
      paramBoolean1 = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean1;
      paramBoolean1 = bool2;
      break;
      label1580:
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
  
  public ajcr a()
  {
    if (this.jdField_a_of_type_Ajcr == null) {
      this.jdField_a_of_type_Ajcr = new ajcr();
    }
    return this.jdField_a_of_type_Ajcr;
  }
  
  public amgo a(List<PhoneContact> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new PhoneContactManagerImp.7(this, paramList));
    return this.jdField_a_of_type_Amgo;
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
    anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PhoneContact)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((PhoneContact)localObject2).samFriend > 0) && (!localanvk.a(((PhoneContact)localObject2).unifiedCode, true))) {
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
        Collections.sort((List)localObject1, new ajbz(new int[] { 3, 4 }, (Set)localObject2, localanvk));
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
      Collections.sort((List)localObject, new ajcf(this));
    }
    ArrayList localArrayList = new ArrayList();
    anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
                paramMap = localanvk.e(((PhoneContact)localObject).uin);
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
        localFriends = localanvk.e(((PhoneContact)localObject).uin);
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
          break label727;
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
        for (paramMap = null;; paramMap = localanvk.e(((PhoneContact)localObject).uin))
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
        Collections.sort(localArrayList, new ajcg(this));
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "getContactListForContactListView sort contact cost time: " + (System.currentTimeMillis() - l1));
        }
        return localArrayList;
      }
      label727:
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
      Collections.sort((List)localObject2, new ajbz(new int[] { 1, 4 }, null, null));
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
      Collections.sort((List)localObject, new ajbz(paramArrayOfInt, this.jdField_a_of_type_JavaUtilSet, (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)));
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
        break label451;
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
            break label408;
          }
          str2 = ajca.a(localCursor.getString(localCursor.getColumnIndex("data1")));
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
          localPhoneContact.pinyinFirst = ajca.b(localPhoneContact.pinyinInitial);
          localPhoneContact.md5 = ajca.a(localStaleDataException, str2);
          localConcurrentHashMap.put(str2, localPhoneContact);
        }
      }
      finally
      {
        localObject1.close();
      }
    }
    label408:
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, new Object[] { "load phone contact from system db cost=", Long.valueOf(System.currentTimeMillis() - l1) });
    }
    localObject1.close();
    return localConcurrentHashMap;
    label451:
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Ajcm != null)
    {
      try
      {
        if (this.jdField_j_of_type_Boolean) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_Ajcm);
        this.jdField_a_of_type_Ajcm.a(null);
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
      this.jdField_a_of_type_Ajcm = null;
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
  
  public void a(awza paramawza)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramawza)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramawza);
      }
      return;
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
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "makePhoneContactAddInfo|unifiedCode : " + paramString1 + "|friendSetting : " + paramInt + "|remark : " + paramString2);
    }
    if ((paramInt != 1) && (paramInt != 4)) {
      return;
    }
    label404:
    label420:
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
            break label420;
          }
          localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label420;
          }
          PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)((Iterator)localObject2).next();
          if (!localPhoneContactAdd.unifiedCode.equals(paramString1)) {
            continue;
          }
          localPhoneContactAdd.timestamp = bcrg.a();
          a(localPhoneContactAdd);
          i1 = 0;
          if (i1 != 0)
          {
            localObject2 = new PhoneContactAdd();
            ((PhoneContactAdd)localObject2).name = paramString2;
            ((PhoneContactAdd)localObject2).unifiedCode = paramString1;
            ((PhoneContactAdd)localObject2).timestamp = bcrg.a();
            if (paramInt != 1) {
              break label355;
            }
            ((PhoneContactAdd)localObject2).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694580);
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
            break label404;
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
      label355:
      if (paramInt == 4)
      {
        ((PhoneContactAdd)localObject2).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694581);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
    label133:
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
              break label133;
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
          break label119;
        }
        ??? = "|addlist is null";
        label52:
        QLog.d("PhoneContact.Manager", 2, (String)???);
      }
    }
    else
    {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramArrayList1 != null) && (!paramArrayList1.isEmpty())) {
        break label147;
      }
    }
    label119:
    while ((paramInt != 3078) && (paramInt != 3079))
    {
      return;
      ??? = "|phoneList.size : " + paramArrayList.size();
      break;
      ??? = "|addlist.size : " + paramArrayList1.size();
      break label52;
    }
    label147:
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
            break label673;
          }
          localObject5 = (PhoneContactAdd)((Iterator)localObject4).next();
          if (!((PhoneContactAdd)localObject5).unifiedCode.equals(((FriendListHandler.AddBatchPhoneFriendResult)localObject3).mobile)) {
            continue;
          }
          ((PhoneContactAdd)localObject5).timestamp = bcrg.a();
          a((Entity)localObject5);
          paramInt = 0;
          if (paramInt == 0) {
            continue;
          }
          localObject4 = new PhoneContactAdd();
          ((PhoneContactAdd)localObject4).unifiedCode = ((FriendListHandler.AddBatchPhoneFriendResult)localObject3).mobile;
          ((PhoneContactAdd)localObject4).timestamp = bcrg.a();
          ((PhoneContactAdd)localObject4).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131694580);
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
          break label660;
        }
        localObject3 = localArrayList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label542;
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
      label542:
      this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        paramArrayList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (!paramArrayList.hasNext()) {
            break label660;
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
      label660:
      ((EntityTransaction)localObject2).commit();
      ((EntityTransaction)localObject2).end();
      continue;
      label673:
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
    //   1: getfield 631	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_j_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +29 -> 40
    //   14: ldc 236
    //   16: iconst_2
    //   17: new 182	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 2113
    //   27: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 1216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 251	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 268	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   47: invokevirtual 274	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +13 -> 65
    //   55: ldc 236
    //   57: iconst_1
    //   58: ldc_w 2115
    //   61: invokestatic 1872	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: return
    //   65: aload_3
    //   66: invokevirtual 459	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 464	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   74: aload_3
    //   75: ldc_w 2117
    //   78: aconst_null
    //   79: aconst_null
    //   80: invokevirtual 2118	com/tencent/mobileqq/persistence/EntityManager:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   83: pop
    //   84: aload_1
    //   85: invokeinterface 588 1 0
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 593 1 0
    //   97: ifeq +63 -> 160
    //   100: aload_1
    //   101: invokeinterface 597 1 0
    //   106: checkcast 72	java/lang/String
    //   109: astore 4
    //   111: aload 4
    //   113: invokestatic 357	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifne -25 -> 91
    //   119: new 1420	com/tencent/mobileqq/data/LastLoginPhoneInfo
    //   122: dup
    //   123: invokespecial 2119	com/tencent/mobileqq/data/LastLoginPhoneInfo:<init>	()V
    //   126: astore 5
    //   128: aload 5
    //   130: aload 4
    //   132: putfield 1424	com/tencent/mobileqq/data/LastLoginPhoneInfo:unifiedCode	Ljava/lang/String;
    //   135: aload_3
    //   136: aload 5
    //   138: invokevirtual 1337	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   141: goto -50 -> 91
    //   144: astore_1
    //   145: ldc 236
    //   147: iconst_1
    //   148: ldc_w 2121
    //   151: aload_1
    //   152: invokestatic 1289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_2
    //   156: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   159: return
    //   160: aload_2
    //   161: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   164: aload_2
    //   165: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   168: return
    //   169: astore_1
    //   170: aload_2
    //   171: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	PhoneContactManagerImp
    //   0	176	1	paramSet	Set<String>
    //   69	102	2	localEntityTransaction	EntityTransaction
    //   50	86	3	localEntityManager	EntityManager
    //   109	22	4	str	String
    //   126	11	5	localLastLoginPhoneInfo	LastLoginPhoneInfo
    // Exception table:
    //   from	to	target	type
    //   70	91	144	java/lang/Exception
    //   91	141	144	java/lang/Exception
    //   160	164	144	java/lang/Exception
    //   70	91	169	finally
    //   91	141	169	finally
    //   145	155	169	finally
    //   160	164	169	finally
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("PhoneContact.Manager", 1, new Object[] { "onStepAction fromLogin=", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      e();
      arph.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
        break label126;
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
    label126:
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
    //   3: getfield 631	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_j_of_type_Boolean	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 2150	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$5
    //   19: dup
    //   20: aload_0
    //   21: iload_1
    //   22: iload_2
    //   23: iload_3
    //   24: invokespecial 2153	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$5:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;ZZI)V
    //   27: bipush 16
    //   29: aconst_null
    //   30: iconst_0
    //   31: invokestatic 338	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
    //   6: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +39 -> 48
    //   12: ldc 236
    //   14: iconst_2
    //   15: new 182	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 2188
    //   25: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 1552
    //   35: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: invokevirtual 430	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   58: astore 9
    //   60: getstatic 2191	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   63: astore 8
    //   65: new 182	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 2193
    //   75: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 2195
    //   85: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore_1
    //   92: aload 9
    //   94: aload 8
    //   96: iconst_4
    //   97: anewarray 72	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 2197
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: ldc_w 2199
    //   111: aastore
    //   112: dup
    //   113: iconst_2
    //   114: ldc_w 2201
    //   117: aastore
    //   118: dup
    //   119: iconst_3
    //   120: ldc 74
    //   122: aastore
    //   123: aload_1
    //   124: aconst_null
    //   125: aconst_null
    //   126: invokevirtual 442	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore 8
    //   131: aload_2
    //   132: astore_1
    //   133: aload 6
    //   135: astore_2
    //   136: aload 8
    //   138: invokeinterface 489 1 0
    //   143: ifeq +360 -> 503
    //   146: aload 8
    //   148: aload 8
    //   150: ldc_w 2197
    //   153: invokeinterface 474 2 0
    //   158: invokeinterface 2204 2 0
    //   163: lstore_3
    //   164: getstatic 2191	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   167: astore 6
    //   169: new 182	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 2206
    //   179: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload_3
    //   183: invokevirtual 979	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: ldc_w 2208
    //   189: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 2201
    //   195: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 2210
    //   201: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc_w 2212
    //   207: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 2214
    //   213: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 80
    //   218: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 2210
    //   224: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iconst_2
    //   228: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 2195
    //   234: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: astore 7
    //   242: aload 9
    //   244: aload 6
    //   246: iconst_5
    //   247: anewarray 72	java/lang/String
    //   250: dup
    //   251: iconst_0
    //   252: ldc_w 2197
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: ldc_w 2199
    //   261: aastore
    //   262: dup
    //   263: iconst_2
    //   264: ldc_w 2201
    //   267: aastore
    //   268: dup
    //   269: iconst_3
    //   270: ldc 74
    //   272: aastore
    //   273: dup
    //   274: iconst_4
    //   275: ldc 80
    //   277: aastore
    //   278: aload 7
    //   280: aconst_null
    //   281: aconst_null
    //   282: invokevirtual 442	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   285: astore 6
    //   287: aload 6
    //   289: astore_2
    //   290: aload_2
    //   291: invokeinterface 467 1 0
    //   296: ifeq +96 -> 392
    //   299: aload_2
    //   300: aload_2
    //   301: ldc 74
    //   303: invokeinterface 474 2 0
    //   308: invokeinterface 477 2 0
    //   313: invokestatic 482	ajca:a	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 7
    //   318: aload_1
    //   319: invokestatic 482	ajca:a	(Ljava/lang/String;)Ljava/lang/String;
    //   322: astore 6
    //   324: aload 6
    //   326: astore_1
    //   327: aload 7
    //   329: aload_1
    //   330: invokestatic 2217	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   333: ifne +35 -> 368
    //   336: new 182	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 2219
    //   346: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 7
    //   351: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload_1
    //   358: invokestatic 2217	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   361: istore 5
    //   363: iload 5
    //   365: ifeq +27 -> 392
    //   368: aload_2
    //   369: ifnull +9 -> 378
    //   372: aload_2
    //   373: invokeinterface 498 1 0
    //   378: aload 8
    //   380: ifnull +10 -> 390
    //   383: aload 8
    //   385: invokeinterface 498 1 0
    //   390: iconst_1
    //   391: ireturn
    //   392: aload_2
    //   393: astore 7
    //   395: aload_1
    //   396: astore 6
    //   398: aload_2
    //   399: ifnull +156 -> 555
    //   402: aload_2
    //   403: invokeinterface 498 1 0
    //   408: aload_2
    //   409: astore 7
    //   411: aload_1
    //   412: astore 6
    //   414: goto +141 -> 555
    //   417: aload_2
    //   418: astore 7
    //   420: aload_1
    //   421: astore 6
    //   423: aload_2
    //   424: ifnull +131 -> 555
    //   427: aload_2
    //   428: invokeinterface 498 1 0
    //   433: aload_2
    //   434: astore 7
    //   436: aload_1
    //   437: astore 6
    //   439: goto +116 -> 555
    //   442: astore_2
    //   443: aload 8
    //   445: astore_1
    //   446: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +13 -> 462
    //   452: ldc 236
    //   454: iconst_2
    //   455: ldc_w 2221
    //   458: aload_2
    //   459: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: aload_1
    //   463: ifnull +9 -> 472
    //   466: aload_1
    //   467: invokeinterface 498 1 0
    //   472: iconst_0
    //   473: ireturn
    //   474: astore_1
    //   475: aload_2
    //   476: ifnull +9 -> 485
    //   479: aload_2
    //   480: invokeinterface 498 1 0
    //   485: aload_1
    //   486: athrow
    //   487: astore_1
    //   488: aload 8
    //   490: astore_2
    //   491: aload_2
    //   492: ifnull +9 -> 501
    //   495: aload_2
    //   496: invokeinterface 498 1 0
    //   501: aload_1
    //   502: athrow
    //   503: aload 8
    //   505: ifnull -33 -> 472
    //   508: aload 8
    //   510: invokeinterface 498 1 0
    //   515: goto -43 -> 472
    //   518: astore_1
    //   519: aload 7
    //   521: astore_2
    //   522: goto -31 -> 491
    //   525: astore 6
    //   527: aload_1
    //   528: astore_2
    //   529: aload 6
    //   531: astore_1
    //   532: goto -41 -> 491
    //   535: astore_2
    //   536: aconst_null
    //   537: astore_1
    //   538: goto -92 -> 446
    //   541: astore_1
    //   542: goto -67 -> 475
    //   545: astore 6
    //   547: goto -130 -> 417
    //   550: astore 6
    //   552: goto -135 -> 417
    //   555: aload 7
    //   557: astore_2
    //   558: aload 6
    //   560: astore_1
    //   561: goto -425 -> 136
    //   564: astore 6
    //   566: goto -149 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	PhoneContactManagerImp
    //   0	569	1	paramString1	String
    //   0	569	2	paramString2	String
    //   163	20	3	l1	long
    //   361	3	5	bool	boolean
    //   4	434	6	localObject1	Object
    //   525	5	6	localObject2	Object
    //   545	1	6	localException1	Exception
    //   550	9	6	localException2	Exception
    //   564	1	6	localException3	Exception
    //   1	555	7	str	String
    //   63	446	8	localObject3	Object
    //   58	185	9	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   136	164	442	java/lang/Exception
    //   372	378	442	java/lang/Exception
    //   402	408	442	java/lang/Exception
    //   427	433	442	java/lang/Exception
    //   479	485	442	java/lang/Exception
    //   485	487	442	java/lang/Exception
    //   290	324	474	finally
    //   327	363	474	finally
    //   136	164	487	finally
    //   372	378	487	finally
    //   402	408	487	finally
    //   427	433	487	finally
    //   479	485	487	finally
    //   485	487	487	finally
    //   60	131	518	finally
    //   446	462	525	finally
    //   60	131	535	java/lang/Exception
    //   164	287	541	finally
    //   327	363	545	java/lang/Exception
    //   164	287	550	java/lang/Exception
    //   290	324	564	java/lang/Exception
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
      l1 = bcrg.a();
      l2 = Math.abs(l1 - this.jdField_g_of_type_Long);
      if (l2 >= 3600L) {
        break label221;
      }
      i2 = 1;
      label42:
      if ((i2 == 0) || ((!paramBoolean) && (!this.jdField_h_of_type_Boolean))) {
        break label252;
      }
      boolean bool = k();
      if (i1 == 0) {
        bool = m();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, "checkAndUploadContact,  has: " + bool + ",  state: " + d());
      }
      if (!bool) {
        break label252;
      }
      if (i1 == 0) {
        break label226;
      }
      ThreadManager.excute(new PhoneContactManagerImp.21(this, paramBoolean), 16, null, false);
    }
    label221:
    label226:
    label252:
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
        break label199;
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
        break label212;
      }
    }
    label199:
    label212:
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
      anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Collections.sort((List)localObject1, new ajbz(new int[] { 6, 5, 1, 4 }, (Set)localObject2, localanvk));
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
  
  public void b(awza paramawza)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramawza);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), azir.class);
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
    for (long l1 = bcrg.a();; l1 = 0L)
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
    //   4: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +88 -> 95
    //   10: new 182	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 974	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 2349
    //   24: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore 4
    //   29: aload_0
    //   30: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   33: bipush 8
    //   35: if_icmpne +95 -> 130
    //   38: iconst_1
    //   39: istore_1
    //   40: aload 4
    //   42: iload_1
    //   43: invokevirtual 891	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: ldc_w 2351
    //   51: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   58: invokevirtual 891	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: ldc_w 1470
    //   66: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   72: aload_0
    //   73: getfield 103	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   76: lsub
    //   77: ldc2_w 992
    //   80: ldiv
    //   81: invokevirtual 979	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc 236
    //   87: iconst_2
    //   88: aload_3
    //   89: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iload_2
    //   96: istore_1
    //   97: aload_0
    //   98: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   101: bipush 8
    //   103: if_icmpeq +23 -> 126
    //   106: iload_2
    //   107: istore_1
    //   108: aload_0
    //   109: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   112: ifne +14 -> 126
    //   115: aload_0
    //   116: invokevirtual 344	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   119: astore_3
    //   120: aload_3
    //   121: ifnonnull +14 -> 135
    //   124: iload_2
    //   125: istore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: iload_1
    //   129: ireturn
    //   130: iconst_0
    //   131: istore_1
    //   132: goto -92 -> 40
    //   135: iload_2
    //   136: istore_1
    //   137: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   140: aload_0
    //   141: getfield 103	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   144: lsub
    //   145: ldc2_w 63
    //   148: lcmp
    //   149: iflt -23 -> 126
    //   152: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +12 -> 167
    //   158: ldc 236
    //   160: iconst_2
    //   161: ldc_w 2353
    //   164: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_0
    //   168: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   171: iconst_2
    //   172: if_icmpeq +19 -> 191
    //   175: aload_0
    //   176: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   179: iconst_3
    //   180: if_icmpeq +11 -> 191
    //   183: aload_0
    //   184: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   187: iconst_4
    //   188: if_icmpne +7 -> 195
    //   191: aload_0
    //   192: invokespecial 774	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:u	()V
    //   195: aload_0
    //   196: bipush 8
    //   198: putfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   201: aload_0
    //   202: invokespecial 771	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:p	()V
    //   205: aload_0
    //   206: getfield 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   209: ifnonnull +23 -> 232
    //   212: aload_0
    //   213: new 2355	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator
    //   216: dup
    //   217: aload_0
    //   218: aconst_null
    //   219: invokespecial 2356	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$1;)V
    //   222: putfield 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   225: aload_0
    //   226: getfield 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   229: invokevirtual 2358	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:a	()V
    //   232: aload_0
    //   233: invokespecial 2360	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:d	()Ljava/util/ArrayList;
    //   236: astore 4
    //   238: aload 4
    //   240: astore_3
    //   241: aload 4
    //   243: ifnonnull +12 -> 255
    //   246: new 154	java/util/ArrayList
    //   249: dup
    //   250: iconst_0
    //   251: invokespecial 1056	java/util/ArrayList:<init>	(I)V
    //   254: astore_3
    //   255: aload_0
    //   256: getfield 699	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_m_of_type_Boolean	Z
    //   259: ifeq +14 -> 273
    //   262: aload_0
    //   263: iconst_1
    //   264: aload_3
    //   265: invokevirtual 503	java/util/ArrayList:size	()I
    //   268: iconst_0
    //   269: iconst_0
    //   270: invokespecial 794	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(IIII)V
    //   273: new 915	mqq/app/NewIntent
    //   276: dup
    //   277: aload_0
    //   278: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   281: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   284: ldc_w 917
    //   287: invokespecial 920	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   290: astore 4
    //   292: aload 4
    //   294: ldc_w 922
    //   297: bipush 31
    //   299: invokevirtual 926	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   302: pop
    //   303: aload 4
    //   305: ldc_w 928
    //   308: aload_0
    //   309: invokevirtual 344	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   312: invokevirtual 931	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   315: pop
    //   316: aload 4
    //   318: ldc_w 942
    //   321: lconst_0
    //   322: invokevirtual 945	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   325: pop
    //   326: aload 4
    //   328: ldc_w 947
    //   331: iconst_0
    //   332: invokevirtual 926	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   335: pop
    //   336: aload 4
    //   338: ldc_w 2362
    //   341: aload_3
    //   342: invokevirtual 936	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   345: pop
    //   346: aload 4
    //   348: ldc 204
    //   350: iconst_0
    //   351: newarray byte
    //   353: invokevirtual 950	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   356: pop
    //   357: aload 4
    //   359: ldc_w 952
    //   362: iconst_0
    //   363: invokevirtual 955	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   366: pop
    //   367: aload_0
    //   368: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   371: aload 4
    //   373: invokevirtual 959	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   376: iconst_1
    //   377: istore_1
    //   378: goto -252 -> 126
    //   381: astore_3
    //   382: aload_0
    //   383: monitorexit
    //   384: aload_3
    //   385: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	PhoneContactManagerImp
    //   39	339	1	bool1	boolean
    //   1	135	2	bool2	boolean
    //   19	323	3	localObject1	Object
    //   381	4	3	localObject2	Object
    //   27	345	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	38	381	finally
    //   40	95	381	finally
    //   97	106	381	finally
    //   108	120	381	finally
    //   137	167	381	finally
    //   167	191	381	finally
    //   191	195	381	finally
    //   195	232	381	finally
    //   232	238	381	finally
    //   246	255	381	finally
    //   255	273	381	finally
    //   273	376	381	finally
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
    label353:
    do
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      anvk localanvk;
      do
      {
        return localObject1;
        if (this.jdField_f_of_type_JavaUtilList != null) {
          break label467;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        Collections.sort((List)localObject2, new ajcb(this));
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
                  break label394;
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
              break label412;
            }
            localPhoneContact.nickName = ((Friends)localObject2).getFriendNick();
            localPhoneContact.remark = ((Friends)localObject2).remark;
          }
          for (;;)
          {
            localArrayList1.add(localPhoneContact);
            break;
            localObject2 = localanvk.e(localPhoneContact.uin);
            break label353;
            localPhoneContact.uin = "0";
          }
        }
      }
      if (localObject1 != null) {
        localArrayList2.add(localObject1);
      }
      localObject1 = new ajcc(this);
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
    label394:
    label412:
    label467:
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
          localPhoneContact.pinyinFirst = ajca.b(localPhoneContact.pinyinInitial);
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
    label86:
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
          break label86;
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
        Collections.sort(localArrayList, new ajcd(this));
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
    Object localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((this.jdField_j_of_type_JavaUtilList == null) || (this.jdField_j_of_type_JavaUtilList.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          localArrayList.add(localPhoneContact);
        } else if ((!localPhoneContact.uin.equals("0")) && (((anvk)localObject1).e(localPhoneContact.uin) != null)) {
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
            ((PhoneContact)localObject2).pinyinFirst = ajca.b(((PhoneContact)localObject2).pinyinInitial);
          }
        }
        Collections.sort(localArrayList, new ajce(this));
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
    //   1: getfield 118	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 276	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 459	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 464	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_0
    //   20: getfield 391	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 391	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   30: iconst_1
    //   31: putfield 1103	com/tencent/mobileqq/data/ContactBinded:isReaded	Z
    //   34: aload_0
    //   35: getfield 1055	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   38: ifnull +81 -> 119
    //   41: aload_0
    //   42: getfield 1055	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   45: invokevirtual 503	java/util/ArrayList:size	()I
    //   48: ifle +71 -> 119
    //   51: aload_0
    //   52: getfield 1055	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   55: invokevirtual 1058	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 593 1 0
    //   65: ifeq +54 -> 119
    //   68: aload_3
    //   69: invokeinterface 597 1 0
    //   74: checkcast 1060	com/tencent/mobileqq/data/ContactMatch
    //   77: astore 4
    //   79: aload 4
    //   81: iconst_1
    //   82: putfield 2405	com/tencent/mobileqq/data/ContactMatch:isReaded	Z
    //   85: aload_0
    //   86: aload 4
    //   88: invokevirtual 1095	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   91: pop
    //   92: goto -33 -> 59
    //   95: astore_3
    //   96: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +13 -> 112
    //   102: ldc 236
    //   104: iconst_2
    //   105: ldc_w 2407
    //   108: aload_3
    //   109: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   116: aload_1
    //   117: monitorexit
    //   118: return
    //   119: aload_2
    //   120: invokevirtual 624	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   123: aload_2
    //   124: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   127: goto -11 -> 116
    //   130: astore_2
    //   131: aload_1
    //   132: monitorexit
    //   133: aload_2
    //   134: athrow
    //   135: astore_3
    //   136: aload_2
    //   137: invokevirtual 495	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   140: aload_3
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	PhoneContactManagerImp
    //   4	128	1	localObject1	Object
    //   14	110	2	localEntityTransaction	EntityTransaction
    //   130	7	2	localObject2	Object
    //   58	11	3	localIterator	Iterator
    //   95	14	3	localException	Exception
    //   135	6	3	localObject3	Object
    //   77	10	4	localContactMatch	ContactMatch
    // Exception table:
    //   from	to	target	type
    //   15	34	95	java/lang/Exception
    //   34	59	95	java/lang/Exception
    //   59	92	95	java/lang/Exception
    //   119	123	95	java/lang/Exception
    //   7	15	130	finally
    //   112	116	130	finally
    //   116	118	130	finally
    //   123	127	130	finally
    //   131	133	130	finally
    //   136	142	130	finally
    //   15	34	135	finally
    //   34	59	135	finally
    //   59	92	135	finally
    //   96	112	135	finally
    //   119	123	135	finally
  }
  
  /* Error */
  public boolean h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 430	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 436	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   16: iconst_1
    //   17: anewarray 72	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 74
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: ldc_w 2409
    //   30: invokevirtual 442	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: invokeinterface 450 1 0
    //   47: istore_1
    //   48: iload_1
    //   49: ifle +79 -> 128
    //   52: iconst_1
    //   53: istore_2
    //   54: aload 4
    //   56: ifnull +10 -> 66
    //   59: aload 4
    //   61: invokeinterface 498 1 0
    //   66: iload_2
    //   67: ireturn
    //   68: astore 5
    //   70: aconst_null
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 5
    //   78: invokevirtual 1333	java/lang/Exception:printStackTrace	()V
    //   81: aload 4
    //   83: ifnull +43 -> 126
    //   86: aload 4
    //   88: invokeinterface 498 1 0
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_3
    //   96: aload 4
    //   98: ifnull +10 -> 108
    //   101: aload 4
    //   103: invokeinterface 498 1 0
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
    //   4: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +76 -> 83
    //   10: new 182	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 974	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: ldc_w 2417
    //   24: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   31: invokevirtual 453	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: ldc_w 2419
    //   39: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   46: invokevirtual 891	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: ldc_w 1470
    //   54: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   60: aload_0
    //   61: getfield 103	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   64: lsub
    //   65: ldc2_w 992
    //   68: ldiv
    //   69: invokevirtual 979	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 236
    //   75: iconst_2
    //   76: aload_3
    //   77: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_0
    //   84: getfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   87: iconst_4
    //   88: if_icmpeq +17 -> 105
    //   91: aload_0
    //   92: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   95: ifne +10 -> 105
    //   98: aload_0
    //   99: invokevirtual 344	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   102: ifnonnull +42 -> 144
    //   105: iload_2
    //   106: istore_1
    //   107: aload_0
    //   108: getfield 99	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   111: ifeq +29 -> 140
    //   114: aload_0
    //   115: getfield 198	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   118: invokeinterface 748 1 0
    //   123: ldc_w 1742
    //   126: iconst_1
    //   127: invokeinterface 780 3 0
    //   132: invokeinterface 782 1 0
    //   137: pop
    //   138: iload_2
    //   139: istore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: iload_1
    //   143: ireturn
    //   144: iload_2
    //   145: istore_1
    //   146: invokestatic 424	java/lang/System:currentTimeMillis	()J
    //   149: aload_0
    //   150: getfield 103	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_d_of_type_Long	J
    //   153: lsub
    //   154: ldc2_w 63
    //   157: lcmp
    //   158: iflt -18 -> 140
    //   161: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +12 -> 176
    //   167: ldc 236
    //   169: iconst_2
    //   170: ldc_w 2421
    //   173: invokestatic 346	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: getfield 198	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   180: invokeinterface 748 1 0
    //   185: ldc_w 1742
    //   188: iconst_0
    //   189: invokeinterface 780 3 0
    //   194: invokeinterface 782 1 0
    //   199: pop
    //   200: aload_0
    //   201: iconst_4
    //   202: putfield 109	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   205: aload_0
    //   206: invokespecial 771	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:p	()V
    //   209: aload_0
    //   210: getfield 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   213: ifnonnull +23 -> 236
    //   216: aload_0
    //   217: new 2355	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator
    //   220: dup
    //   221: aload_0
    //   222: aconst_null
    //   223: invokespecial 2356	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$1;)V
    //   226: putfield 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   229: aload_0
    //   230: getfield 386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   233: invokevirtual 2358	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:a	()V
    //   236: aload_0
    //   237: invokespecial 2360	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:d	()Ljava/util/ArrayList;
    //   240: astore 4
    //   242: aload 4
    //   244: astore_3
    //   245: aload 4
    //   247: ifnonnull +12 -> 259
    //   250: new 154	java/util/ArrayList
    //   253: dup
    //   254: iconst_0
    //   255: invokespecial 1056	java/util/ArrayList:<init>	(I)V
    //   258: astore_3
    //   259: aload_0
    //   260: getfield 699	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_m_of_type_Boolean	Z
    //   263: ifeq +14 -> 277
    //   266: aload_0
    //   267: iconst_1
    //   268: aload_3
    //   269: invokevirtual 503	java/util/ArrayList:size	()I
    //   272: iconst_0
    //   273: iconst_0
    //   274: invokespecial 794	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(IIII)V
    //   277: new 915	mqq/app/NewIntent
    //   280: dup
    //   281: aload_0
    //   282: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   285: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   288: ldc_w 917
    //   291: invokespecial 920	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   294: astore 4
    //   296: aload 4
    //   298: ldc_w 922
    //   301: bipush 37
    //   303: invokevirtual 926	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   306: pop
    //   307: aload 4
    //   309: ldc_w 928
    //   312: aload_0
    //   313: invokevirtual 344	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   316: invokevirtual 931	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   319: pop
    //   320: aload 4
    //   322: ldc_w 942
    //   325: lconst_0
    //   326: invokevirtual 945	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   329: pop
    //   330: aload 4
    //   332: ldc_w 947
    //   335: iconst_0
    //   336: invokevirtual 926	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   339: pop
    //   340: aload 4
    //   342: ldc_w 2362
    //   345: aload_3
    //   346: invokevirtual 936	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   349: pop
    //   350: aload 4
    //   352: ldc 204
    //   354: iconst_0
    //   355: newarray byte
    //   357: invokevirtual 950	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   360: pop
    //   361: aload 4
    //   363: ldc_w 952
    //   366: iconst_0
    //   367: invokevirtual 955	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   370: pop
    //   371: aload_0
    //   372: getfield 164	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   375: aload 4
    //   377: invokevirtual 959	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   380: iconst_1
    //   381: istore_1
    //   382: goto -242 -> 140
    //   385: astore_3
    //   386: aload_0
    //   387: monitorexit
    //   388: aload_3
    //   389: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	PhoneContactManagerImp
    //   106	276	1	bool1	boolean
    //   1	144	2	bool2	boolean
    //   19	327	3	localObject1	Object
    //   385	4	3	localObject2	Object
    //   240	136	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	83	385	finally
    //   83	105	385	finally
    //   107	138	385	finally
    //   146	176	385	finally
    //   176	236	385	finally
    //   236	242	385	finally
    //   250	259	385	finally
    //   259	277	385	finally
    //   277	380	385	finally
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
    if (VersionUtils.isM()) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(ajcr.a("android.permission.READ_CONTACTS"));
    }
    for (;;)
    {
      ThreadManager.excute(new PhoneContactManagerImp.20(this), 16, null, true);
      if (QLog.isColorLevel()) {
        QLog.d("contact.PermissionChecker", 2, String.format("hasReadContactPermissionForUI isM=%b has=%b", new Object[] { Boolean.valueOf(VersionUtils.isM()), this.jdField_a_of_type_JavaLangBoolean }));
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
    if (VersionUtils.isM())
    {
      bool1 = ajcr.a("android.permission.READ_CONTACTS");
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
    if (VersionUtils.isM()) {
      bool1 = ajcr.a("android.permission.READ_CONTACTS");
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azip);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aziq);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    a();
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ajcr != null) {
      this.jdField_a_of_type_Ajcr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp
 * JD-Core Version:    0.7.0.1
 */