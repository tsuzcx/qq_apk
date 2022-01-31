package com.tencent.mobileqq.app;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import ahzr;
import ajjj;
import ajjy;
import ajnq;
import ajnr;
import ajns;
import ajnt;
import ajnu;
import ajnv;
import ajnw;
import ajnx;
import ajny;
import ajnz;
import ajoa;
import ajod;
import ajof;
import amnv;
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
import aroh;
import aroi;
import atmo;
import atmp;
import atmq;
import atmr;
import atof;
import atog;
import atoh;
import atoi;
import awao;
import awqx;
import bbmy;
import befc;
import befo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ThemeNoviceGuideActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LastLoginPhoneInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
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
  implements aroh
{
  public static volatile long a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b;
  static volatile long jdField_b_of_type_Long;
  static volatile long jdField_c_of_type_Long;
  public static int d;
  public static int e;
  public static boolean f;
  public volatile int a;
  public ahzr a;
  private ajoa jdField_a_of_type_Ajoa;
  private ajod jdField_a_of_type_Ajod;
  private amnv jdField_a_of_type_Amnv;
  public SharedPreferences a;
  private atmp jdField_a_of_type_Atmp;
  private atof jdField_a_of_type_Atof;
  private atog jdField_a_of_type_Atog = new ajnx(this);
  private atoh jdField_a_of_type_Atoh = new ajnz(this);
  private PhoneContactManagerImp.UploadProgressGenerator jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp$UploadProgressGenerator;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ContactBinded jdField_a_of_type_ComTencentMobileqqDataContactBinded;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new PhoneContactManagerImp.6(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ContactMatch> jdField_a_of_type_JavaUtilArrayList;
  private LinkedList<aroi> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public volatile List<PhoneContact> a;
  private final Random jdField_a_of_type_JavaUtilRandom;
  private volatile Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private Runnable jdField_b_of_type_JavaLangRunnable = new PhoneContactManagerImp.9(this);
  private ArrayList<PhoneContactAdd> jdField_b_of_type_JavaUtilArrayList;
  List<PhoneContact> jdField_b_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean b;
  public volatile int c;
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
  public volatile long f;
  private List<PhoneContact> jdField_f_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final int jdField_g_of_type_Int;
  public long g;
  private List<PhoneContact> jdField_g_of_type_JavaUtilList;
  private ConcurrentHashMap<String, PhoneContact> jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean g;
  private long jdField_h_of_type_Long;
  private volatile List<PhoneContact> jdField_h_of_type_JavaUtilList;
  private boolean jdField_h_of_type_Boolean;
  private long jdField_i_of_type_Long;
  private List<PhoneContact> jdField_i_of_type_JavaUtilList;
  private volatile boolean jdField_i_of_type_Boolean;
  private List<PhoneContact> jdField_j_of_type_JavaUtilList;
  private boolean jdField_j_of_type_Boolean;
  private List<PhoneContact> jdField_k_of_type_JavaUtilList;
  private volatile boolean jdField_k_of_type_Boolean;
  private List<NotBindContactNotFriendInfo> jdField_l_of_type_JavaUtilList;
  private boolean jdField_l_of_type_Boolean;
  private List<NotBindContactFriendInfo> jdField_m_of_type_JavaUtilList;
  private boolean jdField_m_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Long = 120000L;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "data1", "display_name", "contact_id", "data2", "data3" };
    jdField_b_of_type_Int = 20;
    jdField_e_of_type_Int = 2;
  }
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_new_friend", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("contact_bind_info_global", 0);
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("session_id", "").getBytes();
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("contact_last_query_list_time", 0L);
    this.jdField_h_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_unbind_mobile_time", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("init [%s, %s]", new Object[] { Long.valueOf(this.jdField_d_of_type_Long), Long.valueOf(this.jdField_h_of_type_Long) }));
    }
    s();
    this.jdField_a_of_type_Int = a(a());
    this.jdField_a_of_type_Atmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atog);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Atoh);
    this.jdField_a_of_type_JavaUtilRandom = new Random(SystemClock.elapsedRealtime());
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics();
    if (Math.min(paramQQAppInterface.widthPixels, paramQQAppInterface.heightPixels) >= 1080) {}
    for (int n = 5;; n = 4)
    {
      this.jdField_g_of_type_Int = n;
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
    int i1 = paramString.length;
    paramArrayOfByte = a(paramArrayOfByte);
    paramString = a(paramString);
    int n = 0;
    while (n < i1)
    {
      paramArrayOfByte[n] = ((byte)(paramString[n] ^ paramArrayOfByte[n]));
      n += 1;
    }
    i1 = paramArrayOfByte.length;
    n = i1 - 1;
    if (n >= 0) {
      if (paramArrayOfByte[n] == 0) {}
    }
    for (;;)
    {
      if (n != i1 - 1)
      {
        paramString = new byte[n + 1];
        System.arraycopy(paramArrayOfByte, 0, paramString, 0, n + 1);
        paramArrayOfByte = paramString;
      }
      for (;;)
      {
        return new String(a(paramArrayOfByte));
        n -= 1;
        break;
      }
      n = 0;
    }
  }
  
  /* Error */
  private ArrayList<PhoneContact> a(ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2)
  {
    // Byte code:
    //   0: new 415	java/util/HashMap
    //   3: dup
    //   4: invokespecial 416	java/util/HashMap:<init>	()V
    //   7: astore 12
    //   9: new 152	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 153	java/util/ArrayList:<init>	()V
    //   16: astore 11
    //   18: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: aload_0
    //   24: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 168	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: invokevirtual 423	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   33: astore 7
    //   35: aload 7
    //   37: getstatic 429	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   40: getstatic 79	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 435	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +246 -> 299
    //   56: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +35 -> 94
    //   62: ldc 234
    //   64: iconst_2
    //   65: new 180	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 437
    //   75: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload 8
    //   80: invokeinterface 443 1 0
    //   85: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aconst_null
    //   95: astore 7
    //   97: aload_0
    //   98: getfield 270	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Atmp	Latmp;
    //   101: invokevirtual 451	atmp:a	()Latmr;
    //   104: astore 9
    //   106: aload 9
    //   108: astore 7
    //   110: aload 7
    //   112: invokevirtual 455	atmr:a	()V
    //   115: aload 8
    //   117: invokeinterface 458 1 0
    //   122: pop
    //   123: aload 8
    //   125: invokeinterface 461 1 0
    //   130: ifne +648 -> 778
    //   133: aload 8
    //   135: aload 8
    //   137: ldc 69
    //   139: invokeinterface 465 2 0
    //   144: invokeinterface 468 2 0
    //   149: invokestatic 473	ajnr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   152: astore 10
    //   154: aload 8
    //   156: aload 8
    //   158: ldc 71
    //   160: invokeinterface 465 2 0
    //   165: invokeinterface 468 2 0
    //   170: astore 9
    //   172: aload 9
    //   174: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifeq +986 -> 1163
    //   180: aload 10
    //   182: astore 9
    //   184: aload 8
    //   186: aload 8
    //   188: ldc 73
    //   190: invokeinterface 465 2 0
    //   195: invokeinterface 477 2 0
    //   200: istore_3
    //   201: aload 8
    //   203: aload 8
    //   205: ldc 75
    //   207: invokeinterface 465 2 0
    //   212: invokeinterface 477 2 0
    //   217: istore 4
    //   219: aload 8
    //   221: aload 8
    //   223: ldc 77
    //   225: invokeinterface 465 2 0
    //   230: invokeinterface 468 2 0
    //   235: astore 13
    //   237: aload 10
    //   239: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +11 -> 253
    //   245: aload 9
    //   247: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifeq +130 -> 380
    //   253: aload 8
    //   255: invokeinterface 480 1 0
    //   260: pop
    //   261: goto -138 -> 123
    //   264: astore 9
    //   266: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +13 -> 282
    //   272: ldc 234
    //   274: iconst_2
    //   275: ldc 204
    //   277: aload 9
    //   279: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload 7
    //   284: ifnull +8 -> 292
    //   287: aload 7
    //   289: invokevirtual 485	atmr:b	()V
    //   292: aload 8
    //   294: invokeinterface 488 1 0
    //   299: aload_0
    //   300: iconst_0
    //   301: putfield 127	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_g_of_type_Boolean	Z
    //   304: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +62 -> 369
    //   310: ldc 234
    //   312: iconst_2
    //   313: ldc_w 490
    //   316: iconst_4
    //   317: anewarray 4	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload_1
    //   323: invokevirtual 493	java/util/ArrayList:size	()I
    //   326: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: aload_2
    //   333: invokevirtual 493	java/util/ArrayList:size	()I
    //   336: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: aastore
    //   340: dup
    //   341: iconst_2
    //   342: aload 11
    //   344: invokevirtual 493	java/util/ArrayList:size	()I
    //   347: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: aastore
    //   351: dup
    //   352: iconst_3
    //   353: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   356: lload 5
    //   358: lsub
    //   359: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   362: aastore
    //   363: invokestatic 246	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   366: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload 11
    //   371: areturn
    //   372: astore 7
    //   374: aconst_null
    //   375: astore 8
    //   377: goto -326 -> 51
    //   380: aload_0
    //   381: getfield 129	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   384: aload 10
    //   386: invokevirtual 502	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   389: checkcast 504	com/tencent/mobileqq/data/PhoneContact
    //   392: astore 14
    //   394: aload 14
    //   396: ifnonnull +174 -> 570
    //   399: new 504	com/tencent/mobileqq/data/PhoneContact
    //   402: dup
    //   403: invokespecial 505	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   406: astore 14
    //   408: aload 14
    //   410: aload 10
    //   412: putfield 506	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   415: aload 14
    //   417: aload 9
    //   419: putfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   422: aload 14
    //   424: iload_3
    //   425: putfield 512	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   428: aload 14
    //   430: iload 4
    //   432: putfield 515	com/tencent/mobileqq/data/PhoneContact:type	I
    //   435: aload 14
    //   437: aload 13
    //   439: putfield 518	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   442: aload 14
    //   444: lload 5
    //   446: putfield 521	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   449: aload 14
    //   451: aload 9
    //   453: iconst_1
    //   454: invokestatic 526	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   457: putfield 529	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   460: aload 14
    //   462: aload 9
    //   464: iconst_2
    //   465: invokestatic 526	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   468: putfield 532	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   471: aload 14
    //   473: aload 14
    //   475: getfield 532	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   478: invokestatic 534	ajnr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   481: putfield 537	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   484: aload_0
    //   485: getfield 129	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   488: aload 10
    //   490: aload 14
    //   492: invokevirtual 541	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   495: pop
    //   496: aload 14
    //   498: aload 9
    //   500: aload 10
    //   502: invokestatic 543	ajnr:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: putfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   508: aload_0
    //   509: getfield 135	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   512: aload 14
    //   514: getfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   517: aload 14
    //   519: invokevirtual 541	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   522: pop
    //   523: aload 11
    //   525: aload 14
    //   527: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   530: pop
    //   531: aload_1
    //   532: new 551	SecurityAccountServer/AddressBookItem
    //   535: dup
    //   536: aload 10
    //   538: aload 9
    //   540: invokespecial 554	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   546: pop
    //   547: goto -294 -> 253
    //   550: astore_1
    //   551: aload 7
    //   553: ifnull +8 -> 561
    //   556: aload 7
    //   558: invokevirtual 485	atmr:b	()V
    //   561: aload 8
    //   563: invokeinterface 488 1 0
    //   568: aload_1
    //   569: athrow
    //   570: aload 14
    //   572: iload_3
    //   573: putfield 512	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   576: aload 14
    //   578: lload 5
    //   580: putfield 521	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   583: aload 14
    //   585: getfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   588: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   591: ifeq +33 -> 624
    //   594: aload 14
    //   596: aload 14
    //   598: getfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   601: aload 10
    //   603: invokestatic 543	ajnr:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   606: putfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   609: aload_0
    //   610: getfield 135	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   613: aload 14
    //   615: getfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   618: aload 14
    //   620: invokevirtual 541	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   623: pop
    //   624: aload 14
    //   626: getfield 557	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   629: ifeq +122 -> 751
    //   632: aload 9
    //   634: aload 14
    //   636: getfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   639: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   642: ifne +56 -> 698
    //   645: aload 12
    //   647: aload 10
    //   649: aload 9
    //   651: invokevirtual 558	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   654: pop
    //   655: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq -405 -> 253
    //   661: ldc 234
    //   663: iconst_2
    //   664: ldc_w 560
    //   667: iconst_3
    //   668: anewarray 4	java/lang/Object
    //   671: dup
    //   672: iconst_0
    //   673: aload 14
    //   675: getfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   678: aastore
    //   679: dup
    //   680: iconst_1
    //   681: aload 9
    //   683: aastore
    //   684: dup
    //   685: iconst_2
    //   686: aload 10
    //   688: aastore
    //   689: invokestatic 246	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   692: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   695: goto -442 -> 253
    //   698: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   701: ifeq +39 -> 740
    //   704: aload 12
    //   706: aload 10
    //   708: invokevirtual 563	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   711: ifeq +29 -> 740
    //   714: ldc 234
    //   716: iconst_2
    //   717: ldc_w 565
    //   720: iconst_2
    //   721: anewarray 4	java/lang/Object
    //   724: dup
    //   725: iconst_0
    //   726: aload 9
    //   728: aastore
    //   729: dup
    //   730: iconst_1
    //   731: aload 10
    //   733: aastore
    //   734: invokestatic 246	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   737: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: aload 12
    //   742: aload 10
    //   744: invokevirtual 568	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   747: pop
    //   748: goto -495 -> 253
    //   751: aload_1
    //   752: new 551	SecurityAccountServer/AddressBookItem
    //   755: dup
    //   756: aload 10
    //   758: aload 9
    //   760: invokespecial 554	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   763: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   766: pop
    //   767: aload 11
    //   769: aload 14
    //   771: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   774: pop
    //   775: goto -522 -> 253
    //   778: aload 12
    //   780: invokevirtual 572	java/util/HashMap:keySet	()Ljava/util/Set;
    //   783: invokeinterface 578 1 0
    //   788: astore 9
    //   790: aload 9
    //   792: invokeinterface 583 1 0
    //   797: ifeq +176 -> 973
    //   800: aload 9
    //   802: invokeinterface 587 1 0
    //   807: checkcast 67	java/lang/String
    //   810: astore 10
    //   812: aload_0
    //   813: getfield 129	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   816: aload 10
    //   818: invokevirtual 502	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   821: checkcast 504	com/tencent/mobileqq/data/PhoneContact
    //   824: astore 13
    //   826: aload 13
    //   828: ifnull -38 -> 790
    //   831: aload 12
    //   833: aload 10
    //   835: invokevirtual 588	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   838: checkcast 67	java/lang/String
    //   841: astore 14
    //   843: aload_2
    //   844: new 551	SecurityAccountServer/AddressBookItem
    //   847: dup
    //   848: aload 10
    //   850: aload 13
    //   852: getfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   855: invokespecial 554	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   861: pop
    //   862: aload_1
    //   863: new 551	SecurityAccountServer/AddressBookItem
    //   866: dup
    //   867: aload 10
    //   869: aload 14
    //   871: invokespecial 554	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   874: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   877: pop
    //   878: aload 13
    //   880: aload 14
    //   882: putfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   885: aload 13
    //   887: aload 14
    //   889: iconst_1
    //   890: invokestatic 526	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   893: putfield 529	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   896: aload 13
    //   898: aload 14
    //   900: iconst_2
    //   901: invokestatic 526	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   904: putfield 532	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   907: aload 13
    //   909: aload 13
    //   911: getfield 532	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   914: invokestatic 534	ajnr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   917: putfield 537	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   920: aload_0
    //   921: getfield 135	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   924: aload 13
    //   926: getfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   929: aload 13
    //   931: invokevirtual 591	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   934: pop
    //   935: aload 13
    //   937: aload 14
    //   939: aload 10
    //   941: invokestatic 543	ajnr:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   944: putfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   947: aload_0
    //   948: getfield 135	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   951: aload 13
    //   953: getfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   956: aload 13
    //   958: invokevirtual 541	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   961: pop
    //   962: aload 11
    //   964: aload 13
    //   966: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   969: pop
    //   970: goto -180 -> 790
    //   973: new 152	java/util/ArrayList
    //   976: dup
    //   977: invokespecial 153	java/util/ArrayList:<init>	()V
    //   980: astore 9
    //   982: aload_0
    //   983: getfield 129	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   986: invokevirtual 594	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   989: invokeinterface 578 1 0
    //   994: astore 10
    //   996: aload 10
    //   998: invokeinterface 583 1 0
    //   1003: ifeq +105 -> 1108
    //   1006: aload 10
    //   1008: invokeinterface 587 1 0
    //   1013: checkcast 596	java/util/Map$Entry
    //   1016: invokeinterface 599 1 0
    //   1021: checkcast 504	com/tencent/mobileqq/data/PhoneContact
    //   1024: astore 12
    //   1026: aload 12
    //   1028: getfield 521	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   1031: lload 5
    //   1033: lcmp
    //   1034: ifeq -38 -> 996
    //   1037: aload 12
    //   1039: getfield 602	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1042: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1045: ifne +16 -> 1061
    //   1048: aload_0
    //   1049: getfield 131	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   1052: aload 12
    //   1054: getfield 602	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1057: invokevirtual 603	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1060: pop
    //   1061: aload 10
    //   1063: invokeinterface 605 1 0
    //   1068: aload_0
    //   1069: getfield 270	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Atmp	Latmp;
    //   1072: aload 12
    //   1074: invokevirtual 608	atmp:b	(Latmo;)Z
    //   1077: pop
    //   1078: aload_2
    //   1079: new 551	SecurityAccountServer/AddressBookItem
    //   1082: dup
    //   1083: aload 12
    //   1085: getfield 506	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1088: aload 12
    //   1090: getfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1093: invokespecial 554	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1096: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1099: pop
    //   1100: aload 9
    //   1102: invokevirtual 611	java/util/ArrayList:clear	()V
    //   1105: goto -109 -> 996
    //   1108: aload 7
    //   1110: invokevirtual 613	atmr:c	()V
    //   1113: aload 7
    //   1115: ifnull +8 -> 1123
    //   1118: aload 7
    //   1120: invokevirtual 485	atmr:b	()V
    //   1123: aload 8
    //   1125: invokeinterface 488 1 0
    //   1130: goto -831 -> 299
    //   1133: astore 7
    //   1135: goto -836 -> 299
    //   1138: astore 7
    //   1140: goto -841 -> 299
    //   1143: astore_2
    //   1144: goto -576 -> 568
    //   1147: astore_1
    //   1148: aconst_null
    //   1149: astore 7
    //   1151: goto -600 -> 551
    //   1154: astore_1
    //   1155: goto -604 -> 551
    //   1158: astore 9
    //   1160: goto -894 -> 266
    //   1163: goto -979 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1166	0	this	PhoneContactManagerImp
    //   0	1166	1	paramArrayList1	ArrayList<AddressBookItem>
    //   0	1166	2	paramArrayList2	ArrayList<AddressBookItem>
    //   200	373	3	n	int
    //   217	214	4	i1	int
    //   21	1011	5	l1	long
    //   33	255	7	localObject1	Object
    //   372	747	7	localThrowable	Throwable
    //   1133	1	7	localException1	Exception
    //   1138	1	7	localException2	Exception
    //   1149	1	7	localObject2	Object
    //   49	1075	8	localCursor	Cursor
    //   104	142	9	localObject3	Object
    //   264	495	9	localStaleDataException1	StaleDataException
    //   788	313	9	localObject4	Object
    //   1158	1	9	localStaleDataException2	StaleDataException
    //   152	910	10	localObject5	Object
    //   16	947	11	localArrayList	ArrayList
    //   7	1082	12	localObject6	Object
    //   235	730	13	localObject7	Object
    //   392	546	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   110	123	264	android/database/StaleDataException
    //   123	180	264	android/database/StaleDataException
    //   184	253	264	android/database/StaleDataException
    //   253	261	264	android/database/StaleDataException
    //   380	394	264	android/database/StaleDataException
    //   399	547	264	android/database/StaleDataException
    //   570	624	264	android/database/StaleDataException
    //   624	695	264	android/database/StaleDataException
    //   698	740	264	android/database/StaleDataException
    //   740	748	264	android/database/StaleDataException
    //   751	775	264	android/database/StaleDataException
    //   778	790	264	android/database/StaleDataException
    //   790	826	264	android/database/StaleDataException
    //   831	970	264	android/database/StaleDataException
    //   973	996	264	android/database/StaleDataException
    //   996	1061	264	android/database/StaleDataException
    //   1061	1105	264	android/database/StaleDataException
    //   1108	1113	264	android/database/StaleDataException
    //   35	51	372	java/lang/Throwable
    //   110	123	550	finally
    //   123	180	550	finally
    //   184	253	550	finally
    //   253	261	550	finally
    //   380	394	550	finally
    //   399	547	550	finally
    //   570	624	550	finally
    //   624	695	550	finally
    //   698	740	550	finally
    //   740	748	550	finally
    //   751	775	550	finally
    //   778	790	550	finally
    //   790	826	550	finally
    //   831	970	550	finally
    //   973	996	550	finally
    //   996	1061	550	finally
    //   1061	1105	550	finally
    //   1108	1113	550	finally
    //   1123	1130	1133	java/lang/Exception
    //   292	299	1138	java/lang/Exception
    //   561	568	1143	java/lang/Exception
    //   97	106	1147	finally
    //   266	282	1154	finally
    //   97	106	1158	android/database/StaleDataException
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_i_of_type_Boolean) {
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.7(this, paramInt));
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
        this.jdField_l_of_type_Boolean = false;
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
    for (String str = ajjy.a(2131642211); Thread.currentThread() == Looper.getMainLooper().getThread(); str = ajjy.a(2131642205))
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
    int n = this.jdField_a_of_type_Int;
    int i1 = a(paramRespondQueryQQBindingStat);
    switch (i1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = i1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "syncBindState newState = " + i1 + " lastState=" + n + " curState=" + this.jdField_a_of_type_Int);
      }
      if (n != this.jdField_a_of_type_Int) {
        p();
      }
      return;
      if (this.jdField_a_of_type_Int != i1)
      {
        v();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_show_contact_banner", true).commit();
      }
      if ((i1 != 1) || (this.jdField_a_of_type_Int != 4))
      {
        this.jdField_a_of_type_Int = i1;
        continue;
        if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L) {
          v();
        }
        this.jdField_a_of_type_Int = i1;
        continue;
        if (this.jdField_a_of_type_Int != 8)
        {
          if (this.jdField_a_of_type_Int != i1) {
            v();
          }
          this.jdField_a_of_type_Int = i1;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("PhoneContact", 2, "cur state is uploading");
          continue;
          this.jdField_a_of_type_Int = i1;
          continue;
          this.jdField_a_of_type_Int = i1;
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
    ThreadManager.excute(new PhoneContactManagerImp.24(paramResources, paramQQAppInterface, paramImageView), 16, null, true);
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
    for (int n = 2;; n = 1)
    {
      bbmy.a(localBaseApplication, n, paramString, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131167766));
      return;
    }
  }
  
  private void a(boolean paramBoolean, List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "notifyRecommendCountChanged|beAdded = " + paramBoolean + "|list.size = " + paramList.size());
    }
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    int n = paramList.size();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.12(this, paramBoolean, n));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        boolean bool = this.jdField_i_of_type_Boolean;
        if ((bool) || (localQQAppInterface == null)) {
          return;
        }
        ((ajof)localQQAppInterface.getManager(102)).jdField_a_of_type_Boolean = true;
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder(200);
          ((StringBuilder)localObject2).append("doQueryContactList, from: ").append(paramLong);
          ((StringBuilder)localObject2).append(", isQueryingContact: ").append(this.jdField_b_of_type_Boolean);
          ((StringBuilder)localObject2).append(", isUpdatingContact: ").append(this.jdField_c_of_type_Boolean);
          ((StringBuilder)localObject2).append(", mCurrentBindState: ").append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append(", beForce: ").append(paramBoolean1);
          ((StringBuilder)localObject2).append(", isQueryAll: ").append(paramBoolean2);
          ((StringBuilder)localObject2).append(", lastQueryTime: ").append(this.jdField_d_of_type_Long / 1000L);
          ((StringBuilder)localObject2).append(", currentTime: ").append(l1 / 1000L);
          ((StringBuilder)localObject2).append(", bindState: ").append(d());
          QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 8) || (this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Int == 4)) {
          continue;
        }
        l1 = Math.abs(l1 - this.jdField_d_of_type_Long);
        if ((!paramBoolean1) && (l1 < jdField_a_of_type_Long))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList [interval:%s, limit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(jdField_a_of_type_Long) }));
          continue;
        }
        if (!paramBoolean1) {
          break label384;
        }
      }
      finally {}
      if ((paramLong == 3L) && (l1 < jdField_c_of_type_Long))
      {
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList [interval:%s, reconnectLimit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(jdField_c_of_type_Long) }));
        }
      }
      else
      {
        label384:
        if ((!paramBoolean1) || (paramLong != 2L) || (l1 >= jdField_b_of_type_Long)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList [interval:%s, logInLimit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(jdField_b_of_type_Long) }));
        }
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_JavaUtilList = null;
    this.jdField_d_of_type_JavaUtilList = null;
    Object localObject2 = new NewIntent(localObject1.getApplication(), atoi.class);
    ((NewIntent)localObject2).putExtra("req_type", 30);
    ((NewIntent)localObject2).putExtra("next_flag", 0L);
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryRichInfoTimeStamp", 0L);
    int i1 = c();
    ((NewIntent)localObject2).putExtra("time_stamp", l1);
    ((NewIntent)localObject2).putExtra("richinfo_time_stamp", l2);
    ((NewIntent)localObject2).putExtra("session_id", new byte[0]);
    ((NewIntent)localObject2).putExtra("unique_phone_no", a());
    if (paramBoolean2) {}
    for (int n = 1;; n = 2)
    {
      ((NewIntent)localObject2).putExtra("force_query_list", n);
      ((NewIntent)localObject2).putExtra("param_query_from", paramLong);
      ((NewIntent)localObject2).putExtra("param_bind_state", i1);
      localObject1.startServlet((NewIntent)localObject2);
      break;
    }
  }
  
  private boolean a(String paramString, ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    if ((paramString == null) || ((paramArrayList1 == null) && (paramArrayList2 == null)))
    {
      this.jdField_c_of_type_Boolean = false;
      return false;
    }
    int i1;
    label39:
    int i2;
    label47:
    NewIntent localNewIntent;
    if (QLog.isColorLevel())
    {
      if (paramArrayList1 == null)
      {
        n = 0;
        if (paramArrayList2 != null) {
          break label236;
        }
        i1 = 0;
        if (paramArrayList != null) {
          break label245;
        }
        i2 = 0;
        QLog.d("PhoneContact.Manager", 2, String.format("doUpdateContact bind:%s, add:%s, del:%s, rename:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2) }));
      }
    }
    else
    {
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), atoi.class);
      if (!paramBoolean) {
        break label255;
      }
    }
    label236:
    label245:
    label255:
    for (int n = 15;; n = 38)
    {
      localNewIntent.putExtra("req_type", n);
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
      n = paramArrayList1.size();
      break;
      i1 = paramArrayList2.size();
      break label39;
      i2 = paramArrayList.size();
      break label47;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    int i2 = paramArrayOfByte.length - 1;
    while (i2 > i1 * 2)
    {
      int n = paramArrayOfByte[i1];
      paramArrayOfByte[i1] = paramArrayOfByte[(i2 - i1)];
      paramArrayOfByte[(i2 - i1)] = n;
      i1 += 1;
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
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.11(this, paramInt));
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.13(this, paramLong));
  }
  
  private void b(boolean paramBoolean, List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact|listSize = ", Integer.valueOf(paramList.size()) });
    }
    atmr localatmr;
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
        localatmr = this.jdField_a_of_type_Atmp.a();
        localatmr.a();
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
            this.jdField_a_of_type_Atmp.b(localContactMatch);
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
          localatmr.b();
        }
      }
      Object localObject2 = new ContactMatch();
      ((ContactMatch)localObject2).mobileNo = localPhoneContact.mobileNo;
      ((ContactMatch)localObject2).unifiedCode = localPhoneContact.unifiedCode;
      ((ContactMatch)localObject2).name = localPhoneContact.name;
      ((ContactMatch)localObject2).timestamp = awao.a();
      ((ContactMatch)localObject2).age = ((short)localPhoneContact.age);
      ((ContactMatch)localObject2).gender = ((short)localPhoneContact.sex);
      ((ContactMatch)localObject2).commonFriend = localPhoneContact.samFriend;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact new uin=", ((ContactMatch)localObject2).mobileNo });
      }
      a((atmo)localObject2);
    }
    localatmr.c();
    localatmr.b();
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
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.timestamp = awao.a();
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.isReaded = false;
      break;
      this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = null;
    }
  }
  
  private boolean b(boolean paramBoolean)
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
    boolean bool2 = n();
    boolean bool1 = m();
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = Math.abs(l1 - this.jdField_h_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("showBindPhonePage [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(this.jdField_h_of_type_Long) }));
    }
    if (((BaseActivity.sTopActivity instanceof BindNumberActivity)) || ((BaseActivity.sTopActivity instanceof BindVerifyActivity)))
    {
      QLog.d("PhoneContact.Manager", 2, "showBindPhonePage " + BaseActivity.sTopActivity);
      return false;
    }
    for (;;)
    {
      int n;
      try
      {
        n = d();
        localIntent = null;
        if (!paramBoolean) {
          break label1016;
        }
        if ((n != 3) || (a() == null) || (a().lastUsedFlag != 3L)) {
          break label1011;
        }
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), PhoneMatchActivity.class);
        localIntent.putExtra("kSrouce", 16);
        bool1 = false;
        if (!bool1) {
          break label1008;
        }
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), BindNumberActivity.class);
        localIntent.putExtra("kSrouce", -1);
        if (localIntent == null) {
          break label899;
        }
        if (l2 >= 3600000L) {
          break label666;
        }
        if (!QLog.isColorLevel()) {
          break label1014;
        }
        QLog.i("PhoneContact.Manager", 2, String.format("showBindPhonePage just last unbind mobile [%s, %s, %s]", new Object[] { Long.valueOf(l1), Long.valueOf(this.jdField_h_of_type_Long), Long.valueOf(3600000L) }));
      }
      catch (Exception localException)
      {
        Intent localIntent;
        QLog.e("PhoneContact.Manager", 1, "showBindPhonePage fail.", localException);
        return false;
      }
      if (bool2)
      {
        if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_bind_style", 0) == 0)
        {
          localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), BindNumberActivity.class);
          localIntent.putExtra("kSrouce", 9);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006EF7", "0X8006EF7", 0, 0, "", "", "", "");
          continue;
        }
        if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_bind_style", 0) == 1)
        {
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), BindNumberActivity.class);
          ((Intent)localObject1).putExtra("kSrouce", 11);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006EF8", "0X8006EF8", 0, 0, "", "", "", "");
          continue;
          if ((a() != null) && (a().lastUsedFlag == 3L))
          {
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), PhoneMatchActivity.class);
            continue;
            localObject1 = a();
            if ((!e()) && (localObject1 != null) && (!((RespondQueryQQBindingStat)localObject1).isStopFindMatch))
            {
              localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), PhoneMatchActivity.class);
              if (bool2)
              {
                ((Intent)localObject1).putExtra("key_from_contact_first", true);
                continue;
                label666:
                String str2 = ((Intent)localObject1).getComponent().getClassName();
                String str1 = "";
                Object localObject2 = str1;
                if (!TextUtils.isEmpty(str2))
                {
                  if (!str2.equals(BindNumberActivity.class.getName())) {
                    break label810;
                  }
                  localObject2 = "0X80095EB";
                }
                for (;;)
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
                  }
                  localObject2 = BaseActivity.sTopActivity;
                  if ((localObject2 == null) || (((AppActivity)localObject2).isFinishing()) || (((AppActivity)localObject2).getAppRuntime() != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                    break label881;
                  }
                  ((AppActivity)localObject2).startActivity((Intent)localObject1);
                  ((AppActivity)localObject2).overridePendingTransition(2130772277, 2130771990);
                  if ((!paramBoolean) || (!bool1)) {
                    break;
                  }
                  t();
                  break label1066;
                  label810:
                  localObject2 = str1;
                  if (str2.equals(PhoneMatchActivity.class.getName())) {
                    localObject2 = "0X80095EA";
                  }
                }
                if ((!paramBoolean) && (bool2))
                {
                  u();
                  break label1066;
                }
                this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_pop_time_for_switchphone", System.currentTimeMillis()).commit();
                break label1066;
                label881:
                if (!QLog.isColorLevel()) {
                  break label1070;
                }
                QLog.d("PhoneContact.Manager", 2, "showBindPhonePage topActivity invalid");
                break label1070;
                label899:
                if ((paramBoolean) || (!bool2)) {
                  break;
                }
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
                if ((localObject1 == null) || (((SharedPreferences)localObject1).getBoolean("THEME_NOVICE_GUIDE_RUNED", false)) || (!BaseApplicationImpl.IS_SUPPORT_THEME)) {
                  break;
                }
                ((SharedPreferences)localObject1).edit().putBoolean("THEME_NOVICE_GUIDE_RUNED", true).commit();
                localObject1 = new Intent(BaseActivity.sTopActivity, ThemeNoviceGuideActivity.class);
                BaseActivity.sTopActivity.startActivity((Intent)localObject1);
                BaseActivity.sTopActivity.overridePendingTransition(2130771979, 2130771980);
                u();
                return false;
              }
              continue;
              label1008:
              continue;
              label1011:
              continue;
              label1014:
              return false;
              label1016:
              switch (n)
              {
              }
            }
          }
        }
      }
      Object localObject1 = null;
    }
    label1066:
    label1070:
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  private String c()
  {
    Object localObject1 = "";
    String str = befc.a("73f9b3");
    if (!befo.k()) {
      localObject1 = befc.c("73f9b3");
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.C();
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
    //   7: invokespecial 1297	com/tencent/mobileqq/app/PhoneContactManagerImp:o	()V
    //   10: aload_0
    //   11: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: invokevirtual 168	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: invokevirtual 423	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   20: getstatic 429	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   23: getstatic 79	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 435	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 7
    //   34: new 152	java/util/ArrayList
    //   37: dup
    //   38: invokespecial 153	java/util/ArrayList:<init>	()V
    //   41: astore 12
    //   43: aload 7
    //   45: ifnull +777 -> 822
    //   48: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   51: lstore_3
    //   52: aload 7
    //   54: invokeinterface 443 1 0
    //   59: istore_1
    //   60: aload 12
    //   62: iload_1
    //   63: invokevirtual 1300	java/util/ArrayList:ensureCapacity	(I)V
    //   66: new 104	java/util/concurrent/ConcurrentHashMap
    //   69: dup
    //   70: iload_1
    //   71: invokespecial 1301	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   74: astore 13
    //   76: aload 8
    //   78: astore 6
    //   80: aload 9
    //   82: astore 5
    //   84: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +37 -> 124
    //   90: aload 8
    //   92: astore 6
    //   94: aload 9
    //   96: astore 5
    //   98: ldc 234
    //   100: iconst_2
    //   101: new 180	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 1303
    //   111: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload_1
    //   115: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload 8
    //   126: astore 6
    //   128: aload 9
    //   130: astore 5
    //   132: aload_0
    //   133: getfield 270	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Atmp	Latmp;
    //   136: invokevirtual 451	atmp:a	()Latmr;
    //   139: astore 8
    //   141: aload 8
    //   143: astore 6
    //   145: aload 8
    //   147: astore 5
    //   149: aload 8
    //   151: invokevirtual 455	atmr:a	()V
    //   154: aload 8
    //   156: astore 6
    //   158: aload 8
    //   160: astore 5
    //   162: aload 7
    //   164: invokeinterface 458 1 0
    //   169: pop
    //   170: aload 8
    //   172: astore 6
    //   174: aload 8
    //   176: astore 5
    //   178: aload 7
    //   180: invokeinterface 461 1 0
    //   185: ifne +599 -> 784
    //   188: aload 8
    //   190: astore 6
    //   192: aload 8
    //   194: astore 5
    //   196: aload 7
    //   198: aload 7
    //   200: ldc 69
    //   202: invokeinterface 465 2 0
    //   207: invokeinterface 468 2 0
    //   212: invokestatic 473	ajnr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 10
    //   217: aload 8
    //   219: astore 6
    //   221: aload 8
    //   223: astore 5
    //   225: aload 7
    //   227: aload 7
    //   229: ldc 71
    //   231: invokeinterface 465 2 0
    //   236: invokeinterface 468 2 0
    //   241: astore 11
    //   243: aload 11
    //   245: astore 9
    //   247: aload 8
    //   249: astore 6
    //   251: aload 8
    //   253: astore 5
    //   255: aload 11
    //   257: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   260: ifeq +7 -> 267
    //   263: aload 10
    //   265: astore 9
    //   267: aload 8
    //   269: astore 6
    //   271: aload 8
    //   273: astore 5
    //   275: aload 7
    //   277: aload 7
    //   279: ldc 73
    //   281: invokeinterface 465 2 0
    //   286: invokeinterface 477 2 0
    //   291: istore_1
    //   292: aload 8
    //   294: astore 6
    //   296: aload 8
    //   298: astore 5
    //   300: aload 7
    //   302: aload 7
    //   304: ldc 75
    //   306: invokeinterface 465 2 0
    //   311: invokeinterface 477 2 0
    //   316: istore_2
    //   317: aload 8
    //   319: astore 6
    //   321: aload 8
    //   323: astore 5
    //   325: aload 7
    //   327: aload 7
    //   329: ldc 77
    //   331: invokeinterface 465 2 0
    //   336: invokeinterface 468 2 0
    //   341: astore 11
    //   343: aload 8
    //   345: astore 6
    //   347: aload 8
    //   349: astore 5
    //   351: aload 10
    //   353: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne +19 -> 375
    //   359: aload 8
    //   361: astore 6
    //   363: aload 8
    //   365: astore 5
    //   367: aload 9
    //   369: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifeq +146 -> 518
    //   375: aload 8
    //   377: astore 6
    //   379: aload 8
    //   381: astore 5
    //   383: aload 7
    //   385: invokeinterface 480 1 0
    //   390: pop
    //   391: goto -221 -> 170
    //   394: astore 8
    //   396: aload 6
    //   398: astore 5
    //   400: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +17 -> 420
    //   406: aload 6
    //   408: astore 5
    //   410: ldc 234
    //   412: iconst_2
    //   413: ldc 204
    //   415: aload 8
    //   417: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: aload 6
    //   422: ifnull +8 -> 430
    //   425: aload 6
    //   427: invokevirtual 485	atmr:b	()V
    //   430: aload 7
    //   432: invokeinterface 488 1 0
    //   437: aload_0
    //   438: aload 13
    //   440: invokespecial 1305	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   443: aload_0
    //   444: getfield 129	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   447: invokevirtual 1309	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   450: invokeinterface 1312 1 0
    //   455: astore 5
    //   457: aload 5
    //   459: invokeinterface 583 1 0
    //   464: ifeq +358 -> 822
    //   467: aload 5
    //   469: invokeinterface 587 1 0
    //   474: checkcast 504	com/tencent/mobileqq/data/PhoneContact
    //   477: astore 6
    //   479: aload 12
    //   481: new 551	SecurityAccountServer/AddressBookItem
    //   484: dup
    //   485: aload 6
    //   487: getfield 506	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   490: aload 6
    //   492: getfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   495: invokespecial 554	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: invokevirtual 549	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   501: pop
    //   502: goto -45 -> 457
    //   505: astore 5
    //   507: aload 5
    //   509: invokevirtual 1313	java/lang/Exception:printStackTrace	()V
    //   512: aconst_null
    //   513: astore 7
    //   515: goto -481 -> 34
    //   518: aload 8
    //   520: astore 6
    //   522: aload 8
    //   524: astore 5
    //   526: new 504	com/tencent/mobileqq/data/PhoneContact
    //   529: dup
    //   530: invokespecial 505	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   533: astore 14
    //   535: aload 8
    //   537: astore 6
    //   539: aload 8
    //   541: astore 5
    //   543: aload 14
    //   545: aload 10
    //   547: putfield 506	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   550: aload 8
    //   552: astore 6
    //   554: aload 8
    //   556: astore 5
    //   558: aload 14
    //   560: aload 9
    //   562: putfield 509	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   565: aload 8
    //   567: astore 6
    //   569: aload 8
    //   571: astore 5
    //   573: aload 14
    //   575: iload_1
    //   576: putfield 512	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   579: aload 8
    //   581: astore 6
    //   583: aload 8
    //   585: astore 5
    //   587: aload 14
    //   589: iload_2
    //   590: putfield 515	com/tencent/mobileqq/data/PhoneContact:type	I
    //   593: aload 8
    //   595: astore 6
    //   597: aload 8
    //   599: astore 5
    //   601: aload 14
    //   603: aload 11
    //   605: putfield 518	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   608: aload 8
    //   610: astore 6
    //   612: aload 8
    //   614: astore 5
    //   616: aload 14
    //   618: lload_3
    //   619: putfield 521	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   622: aload 8
    //   624: astore 6
    //   626: aload 8
    //   628: astore 5
    //   630: aload 14
    //   632: aload 9
    //   634: iconst_1
    //   635: invokestatic 526	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   638: putfield 529	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   641: aload 8
    //   643: astore 6
    //   645: aload 8
    //   647: astore 5
    //   649: aload 14
    //   651: aload 9
    //   653: iconst_2
    //   654: invokestatic 526	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   657: putfield 532	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   660: aload 8
    //   662: astore 6
    //   664: aload 8
    //   666: astore 5
    //   668: aload 14
    //   670: aload 14
    //   672: getfield 532	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   675: invokestatic 534	ajnr:b	(Ljava/lang/String;)Ljava/lang/String;
    //   678: putfield 537	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   681: aload 8
    //   683: astore 6
    //   685: aload 8
    //   687: astore 5
    //   689: aload 14
    //   691: aload 9
    //   693: aload 10
    //   695: invokestatic 543	ajnr:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   698: putfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   701: aload 8
    //   703: astore 6
    //   705: aload 8
    //   707: astore 5
    //   709: aload 13
    //   711: aload 10
    //   713: aload 14
    //   715: invokevirtual 541	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   718: pop
    //   719: aload 8
    //   721: astore 6
    //   723: aload 8
    //   725: astore 5
    //   727: aload_0
    //   728: getfield 135	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   731: aload 14
    //   733: getfield 546	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   736: aload 14
    //   738: invokevirtual 541	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   741: pop
    //   742: aload 8
    //   744: astore 6
    //   746: aload 8
    //   748: astore 5
    //   750: aload_0
    //   751: getfield 270	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Atmp	Latmp;
    //   754: aload 14
    //   756: invokevirtual 1316	atmp:b	(Latmo;)V
    //   759: goto -384 -> 375
    //   762: astore 6
    //   764: aload 5
    //   766: ifnull +8 -> 774
    //   769: aload 5
    //   771: invokevirtual 485	atmr:b	()V
    //   774: aload 7
    //   776: invokeinterface 488 1 0
    //   781: aload 6
    //   783: athrow
    //   784: aload 8
    //   786: astore 6
    //   788: aload 8
    //   790: astore 5
    //   792: aload 8
    //   794: invokevirtual 613	atmr:c	()V
    //   797: aload 8
    //   799: ifnull +8 -> 807
    //   802: aload 8
    //   804: invokevirtual 485	atmr:b	()V
    //   807: aload 7
    //   809: invokeinterface 488 1 0
    //   814: goto -377 -> 437
    //   817: astore 5
    //   819: goto -382 -> 437
    //   822: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   825: ifeq +33 -> 858
    //   828: ldc 234
    //   830: iconst_2
    //   831: new 180	java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   838: ldc_w 1318
    //   841: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: aload 12
    //   846: invokevirtual 493	java/util/ArrayList:size	()I
    //   849: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   852: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   858: aload_0
    //   859: iconst_1
    //   860: putfield 1320	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   863: aload 12
    //   865: areturn
    //   866: astore 5
    //   868: goto -431 -> 437
    //   871: astore 5
    //   873: goto -92 -> 781
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	876	0	this	PhoneContactManagerImp
    //   59	517	1	n	int
    //   316	274	2	i1	int
    //   51	568	3	l1	long
    //   82	386	5	localObject1	Object
    //   505	3	5	localException1	Exception
    //   524	267	5	localStaleDataException1	StaleDataException
    //   817	1	5	localException2	Exception
    //   866	1	5	localException3	Exception
    //   871	1	5	localException4	Exception
    //   78	667	6	localObject2	Object
    //   762	20	6	localObject3	Object
    //   786	1	6	localStaleDataException2	StaleDataException
    //   32	776	7	localCursor	Cursor
    //   4	376	8	localatmr	atmr
    //   394	409	8	localStaleDataException3	StaleDataException
    //   1	691	9	localObject4	Object
    //   215	497	10	str1	String
    //   241	363	11	str2	String
    //   41	823	12	localArrayList	ArrayList
    //   74	636	13	localConcurrentHashMap	ConcurrentHashMap
    //   533	222	14	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   84	90	394	android/database/StaleDataException
    //   98	124	394	android/database/StaleDataException
    //   132	141	394	android/database/StaleDataException
    //   149	154	394	android/database/StaleDataException
    //   162	170	394	android/database/StaleDataException
    //   178	188	394	android/database/StaleDataException
    //   196	217	394	android/database/StaleDataException
    //   225	243	394	android/database/StaleDataException
    //   255	263	394	android/database/StaleDataException
    //   275	292	394	android/database/StaleDataException
    //   300	317	394	android/database/StaleDataException
    //   325	343	394	android/database/StaleDataException
    //   351	359	394	android/database/StaleDataException
    //   367	375	394	android/database/StaleDataException
    //   383	391	394	android/database/StaleDataException
    //   526	535	394	android/database/StaleDataException
    //   543	550	394	android/database/StaleDataException
    //   558	565	394	android/database/StaleDataException
    //   573	579	394	android/database/StaleDataException
    //   587	593	394	android/database/StaleDataException
    //   601	608	394	android/database/StaleDataException
    //   616	622	394	android/database/StaleDataException
    //   630	641	394	android/database/StaleDataException
    //   649	660	394	android/database/StaleDataException
    //   668	681	394	android/database/StaleDataException
    //   689	701	394	android/database/StaleDataException
    //   709	719	394	android/database/StaleDataException
    //   727	742	394	android/database/StaleDataException
    //   750	759	394	android/database/StaleDataException
    //   792	797	394	android/database/StaleDataException
    //   10	34	505	java/lang/Exception
    //   84	90	762	finally
    //   98	124	762	finally
    //   132	141	762	finally
    //   149	154	762	finally
    //   162	170	762	finally
    //   178	188	762	finally
    //   196	217	762	finally
    //   225	243	762	finally
    //   255	263	762	finally
    //   275	292	762	finally
    //   300	317	762	finally
    //   325	343	762	finally
    //   351	359	762	finally
    //   367	375	762	finally
    //   383	391	762	finally
    //   400	406	762	finally
    //   410	420	762	finally
    //   526	535	762	finally
    //   543	550	762	finally
    //   558	565	762	finally
    //   573	579	762	finally
    //   587	593	762	finally
    //   601	608	762	finally
    //   616	622	762	finally
    //   630	641	762	finally
    //   649	660	762	finally
    //   668	681	762	finally
    //   689	701	762	finally
    //   709	719	762	finally
    //   727	742	762	finally
    //   750	759	762	finally
    //   792	797	762	finally
    //   807	814	817	java/lang/Exception
    //   430	437	866	java/lang/Exception
    //   774	781	871	java/lang/Exception
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new PhoneContactManagerImp.16(this, paramBoolean));
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
        atmr localatmr = this.jdField_a_of_type_Atmp.a();
        try
        {
          localatmr.a();
          Iterator localIterator = this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
          while (localIterator.hasNext())
          {
            PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
            a(localPhoneContact, paramBoolean);
            this.jdField_a_of_type_Atmp.a(localPhoneContact);
          }
          this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        }
        finally
        {
          localatmr.b();
        }
        localatmr.c();
        localatmr.b();
      }
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("queryShowBindPhonePage fromNotBind=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      this.jdField_m_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Atof == null) {
        this.jdField_a_of_type_Atof = ((atof)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(134));
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80095EE", "0X80095EE", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Atof.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneContact.Manager", 1, "queryShowBindPhonePage fail.", localException);
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
  
  private void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("setShowBindPhonePageResult success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      if (this.jdField_a_of_type_Atof == null) {
        this.jdField_a_of_type_Atof = ((atof)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(134));
      }
      this.jdField_a_of_type_Atof.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneContact.Manager", 1, "setShowBindPhonePageResult fail.", localException);
    }
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
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new PhoneContactManagerImp.4(this));
  }
  
  private void m()
  {
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (localObject2 != null) {
      localObject1 = ((atmp)localObject2).a(LastLoginPhoneInfo.class);
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
  
  private boolean m()
  {
    if (!"8.2.6".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped_notbind", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "poppedForThisVersionNotBind result = " + bool);
      }
      return bool;
    }
  }
  
  private void n()
  {
    try
    {
      this.jdField_a_of_type_Ajod = new ajod(new Handler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getMainLooper()));
      this.jdField_a_of_type_Ajod.a(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_Ajod);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private boolean n()
  {
    if (!"8.2.6".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_phone_version_popped", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "isPhoneContactFirstRun result = " + bool);
      }
      return bool;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void p()
  {
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.10(this));
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
          atmr localatmr1 = this.jdField_a_of_type_Atmp.a();
          try
          {
            localatmr1.a();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ContactMatch().getTableName(), null, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new ContactBinded().getTableName(), null, null);
            localatmr1.c();
            localatmr1.b();
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend with BannerShow");
            }
            return;
          }
          finally
          {
            localObject3 = finally;
            localatmr1.b();
            throw localObject3;
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        atmr localatmr2 = this.jdField_a_of_type_Atmp.a();
        ContactMatch localContactMatch;
        try
        {
          localatmr2.a();
          Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator1.hasNext())
          {
            localContactMatch = (ContactMatch)localIterator1.next();
            PhoneContact localPhoneContact = b(localContactMatch.mobileNo);
            if ((localPhoneContact == null) || ((localPhoneContact.uin != null) && (!localPhoneContact.uin.equals("0"))) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= jdField_b_of_type_Int))
            {
              localIterator1.remove();
              this.jdField_a_of_type_Atmp.b(localContactMatch);
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
          localatmr2.b();
        }
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator2.hasNext())
        {
          localContactMatch = (ContactMatch)localIterator2.next();
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend|mobileNo : " + localContactMatch.mobileNo + "|size : " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        label393:
        localatmr2.c();
        localatmr2.b();
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend mContactMatchsize = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
      }
    }
  }
  
  /* Error */
  private void r()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +76 -> 81
    //   8: new 180	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 906	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc_w 1479
    //   22: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 98	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   29: invokevirtual 886	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: ldc_w 1481
    //   37: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   44: invokevirtual 886	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 1483
    //   52: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 100	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_Long	J
    //   62: lsub
    //   63: ldc2_w 924
    //   66: ldiv
    //   67: invokevirtual 911	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc 234
    //   73: iconst_2
    //   74: aload_2
    //   75: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: getfield 98	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   85: ifne +12 -> 97
    //   88: aload_0
    //   89: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq +6 -> 100
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   103: aload_0
    //   104: getfield 100	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_Long	J
    //   107: lsub
    //   108: ldc2_w 62
    //   111: lcmp
    //   112: iflt -15 -> 97
    //   115: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +12 -> 130
    //   121: ldc 234
    //   123: iconst_2
    //   124: ldc_w 1485
    //   127: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: new 152	java/util/ArrayList
    //   133: dup
    //   134: invokespecial 153	java/util/ArrayList:<init>	()V
    //   137: astore_2
    //   138: new 152	java/util/ArrayList
    //   141: dup
    //   142: invokespecial 153	java/util/ArrayList:<init>	()V
    //   145: astore_3
    //   146: aload_0
    //   147: aload_2
    //   148: aload_3
    //   149: invokespecial 1487	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   152: astore 4
    //   154: aload_2
    //   155: invokevirtual 1488	java/util/ArrayList:isEmpty	()Z
    //   158: ifeq +10 -> 168
    //   161: aload_3
    //   162: invokevirtual 1488	java/util/ArrayList:isEmpty	()Z
    //   165: ifne -68 -> 97
    //   168: aload_0
    //   169: aload_0
    //   170: aload_0
    //   171: invokevirtual 338	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   174: aload_2
    //   175: aload_3
    //   176: aload 4
    //   178: iconst_1
    //   179: invokespecial 1490	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   182: putfield 98	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   185: aload_0
    //   186: iconst_1
    //   187: invokespecial 782	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(I)V
    //   190: goto -93 -> 97
    //   193: astore_2
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_2
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	PhoneContactManagerImp
    //   92	2	1	bool	boolean
    //   17	158	2	localObject1	Object
    //   193	4	2	localObject2	Object
    //   145	31	3	localArrayList1	ArrayList
    //   152	25	4	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	81	193	finally
    //   81	93	193	finally
    //   100	130	193	finally
    //   130	168	193	finally
    //   168	190	193	finally
  }
  
  private void s()
  {
    try
    {
      jdField_a_of_type_Long = this.jdField_b_of_type_AndroidContentSharedPreferences.getLong("query_contact_list_min_interval", jdField_a_of_type_Long);
      jdField_b_of_type_Long = this.jdField_b_of_type_AndroidContentSharedPreferences.getLong("query_contact_list_min_interval_for_login", jdField_b_of_type_Long);
      jdField_c_of_type_Long = this.jdField_b_of_type_AndroidContentSharedPreferences.getLong("query_contact_list_min_interval_for_reconnect", jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("initQueryInterval  [limit:%s, logInLimit:%s, reconnectLimit:%s]", new Object[] { Long.valueOf(jdField_a_of_type_Long), Long.valueOf(jdField_b_of_type_Long), Long.valueOf(jdField_c_of_type_Long) }));
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
  
  private void t()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped_notbind", "8.2.6").commit();
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_phone_version_popped", "8.2.6").commit();
  }
  
  private void v()
  {
    if (this.jdField_i_of_type_Boolean) {
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
      ??? = this.jdField_a_of_type_Atmp.a();
    }
  }
  
  /* Error */
  private void w()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +76 -> 81
    //   8: new 180	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 906	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc_w 1479
    //   22: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 98	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   29: invokevirtual 886	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: ldc_w 1481
    //   37: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   44: invokevirtual 886	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 1483
    //   52: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 100	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_Long	J
    //   62: lsub
    //   63: ldc2_w 924
    //   66: ldiv
    //   67: invokevirtual 911	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc 234
    //   73: iconst_2
    //   74: aload_2
    //   75: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: getfield 98	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   85: ifne +12 -> 97
    //   88: aload_0
    //   89: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq +6 -> 100
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   103: aload_0
    //   104: getfield 100	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_f_of_type_Long	J
    //   107: lsub
    //   108: ldc2_w 62
    //   111: lcmp
    //   112: iflt -15 -> 97
    //   115: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +12 -> 130
    //   121: ldc 234
    //   123: iconst_2
    //   124: ldc_w 1502
    //   127: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: new 152	java/util/ArrayList
    //   133: dup
    //   134: invokespecial 153	java/util/ArrayList:<init>	()V
    //   137: astore_2
    //   138: new 152	java/util/ArrayList
    //   141: dup
    //   142: invokespecial 153	java/util/ArrayList:<init>	()V
    //   145: astore_3
    //   146: aload_0
    //   147: aload_2
    //   148: aload_3
    //   149: invokespecial 1487	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   152: astore 4
    //   154: aload_2
    //   155: invokevirtual 1488	java/util/ArrayList:isEmpty	()Z
    //   158: ifeq +10 -> 168
    //   161: aload_3
    //   162: invokevirtual 1488	java/util/ArrayList:isEmpty	()Z
    //   165: ifne -68 -> 97
    //   168: aload_0
    //   169: aload_0
    //   170: aload_0
    //   171: invokevirtual 338	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   174: aload_2
    //   175: aload_3
    //   176: aload 4
    //   178: iconst_0
    //   179: invokespecial 1490	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   182: putfield 98	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_Boolean	Z
    //   185: aload_0
    //   186: iconst_1
    //   187: invokespecial 782	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(I)V
    //   190: goto -93 -> 97
    //   193: astore_2
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_2
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	PhoneContactManagerImp
    //   92	2	1	bool	boolean
    //   17	158	2	localObject1	Object
    //   193	4	2	localObject2	Object
    //   145	31	3	localArrayList1	ArrayList
    //   152	25	4	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	81	193	finally
    //   81	93	193	finally
    //   100	130	193	finally
    //   130	168	193	finally
    //   168	190	193	finally
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
    if (this.jdField_a_of_type_Ajoa != null) {
      this.jdField_a_of_type_Ajoa.cancel(true);
    }
    this.jdField_a_of_type_Ajoa = new ajoa(this, null);
    this.jdField_a_of_type_Ajoa.a(paramList);
    this.jdField_a_of_type_Ajoa.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
    return jdField_d_of_type_Int;
  }
  
  public int a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, ArrayList<NotBindContactFriendInfo> paramArrayList, ArrayList<NotBindContactNotFriendInfo> paramArrayList1)
  {
    if (this.jdField_i_of_type_Boolean) {
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
    int n;
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder(200);
      paramArrayList.append("saveContactFromServer, localTimeStamp:");
      paramArrayList.append(l1).append(", ").append(l2);
      paramArrayList.append(", remoteTimeStamp: ").append(paramLong2);
      paramArrayList1 = paramArrayList.append(", friendCount:");
      if (this.jdField_m_of_type_JavaUtilList != null)
      {
        n = this.jdField_m_of_type_JavaUtilList.size();
        paramArrayList1.append(n);
        paramArrayList1 = paramArrayList.append(", strangerCount:");
        if (this.jdField_l_of_type_JavaUtilList == null) {
          break label718;
        }
        n = this.jdField_l_of_type_JavaUtilList.size();
        label300:
        paramArrayList1.append(n);
        QLog.d("PhoneContact.Manager", 2, paramArrayList.toString());
      }
    }
    else
    {
      if (!this.jdField_d_of_type_Boolean) {
        c();
      }
      if (((paramInt == 0) && (paramBoolean)) || (!paramBoolean)) {
        e(true);
      }
      if ((this.jdField_m_of_type_JavaUtilList == null) || (this.jdField_m_of_type_JavaUtilList.size() <= 0)) {
        break label1364;
      }
      paramArrayList1 = this.jdField_a_of_type_Atmp.a();
      localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    }
    Object localObject2;
    Object localObject3;
    boolean bool1;
    for (;;)
    {
      try
      {
        paramArrayList1.a();
        localObject2 = this.jdField_m_of_type_JavaUtilList.iterator();
        paramBoolean = false;
        if (!((Iterator)localObject2).hasNext()) {
          break label779;
        }
        localObject3 = (NotBindContactFriendInfo)((Iterator)localObject2).next();
        paramArrayList = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramArrayList == null) {
          break label724;
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
          localObject3 = ((ajjj)localObject1).e(paramArrayList.uin);
          if (localObject3 != null) {
            paramArrayList.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayList.uin, paramArrayList);
          ((ajjj)localObject1).a(paramArrayList.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramArrayList.unifiedCode)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayList.unifiedCode, paramArrayList);
        }
        this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramArrayList.mobileNo);
        this.jdField_a_of_type_Atmp.a(paramArrayList);
        paramBoolean = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramArrayList != null) {
          break label769;
        }
        paramArrayList = "null";
        QLog.d("PhoneContact.Manager", 2, paramArrayList);
        paramBoolean = bool1;
        continue;
        n = -1;
      }
      finally
      {
        paramArrayList1.b();
      }
      break;
      label718:
      n = -1;
      break label300;
      label724:
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean;
        continue;
        label769:
        paramArrayList = paramArrayList.toString();
      }
    }
    label779:
    paramArrayList1.c();
    paramArrayList1.b();
    boolean bool3;
    boolean bool2;
    for (;;)
    {
      if ((this.jdField_l_of_type_JavaUtilList != null) && (this.jdField_l_of_type_JavaUtilList.size() > 0))
      {
        paramArrayList1 = new ArrayList(this.jdField_l_of_type_JavaUtilList.size());
        paramArrayList = this.jdField_a_of_type_Atmp.a();
      }
      for (;;)
      {
        try
        {
          paramArrayList.a();
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
              this.jdField_a_of_type_Atmp.a((atmo)localObject3);
              bool2 = paramBoolean;
              if (!QLog.isColorLevel()) {
                break label1382;
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
              break label1382;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean;
            break label1382;
          }
          e(paramArrayList1);
          paramArrayList.c();
          paramArrayList.b();
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
            f(true);
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
          paramArrayList.b();
        }
        bool2 = false;
      }
      label1364:
      paramBoolean = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean;
      paramBoolean = bool2;
      break;
      label1382:
      paramBoolean = bool3;
      bool1 = bool2;
    }
  }
  
  public int a(boolean paramBoolean1, int paramInt, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3, List<MobileContactsFriendInfo> paramList, List<MobileContactsNotFriendInfo> paramList1)
  {
    if (this.jdField_i_of_type_Boolean) {
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
    int n;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder(200);
      paramList.append("saveContactFromServer, localTimeStamp:");
      paramList.append(l1).append(", ").append(l2);
      paramList.append(", remoteTimeStamp: ").append(paramLong2).append(", ").append(paramLong3);
      paramList1 = paramList.append(", friendCount:");
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        n = this.jdField_c_of_type_JavaUtilList.size();
        paramList1.append(n);
        paramList1 = paramList.append(", strangerCount:");
        if (this.jdField_d_of_type_JavaUtilList == null) {
          break label777;
        }
        n = this.jdField_d_of_type_JavaUtilList.size();
        label311:
        paramList1.append(n);
        paramList.append(", isListChanged:").append(paramBoolean2);
        QLog.d("PhoneContact.Manager", 2, paramList.toString());
      }
    }
    else
    {
      if (!this.jdField_d_of_type_Boolean) {
        c();
      }
      if (((paramInt == 0) && (paramBoolean1)) || (!paramBoolean1)) {
        e(paramBoolean2);
      }
      if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() <= 0)) {
        break label1561;
      }
      if (!paramBoolean2) {}
      paramList1 = this.jdField_a_of_type_Atmp.a();
      localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    }
    Object localObject2;
    Object localObject3;
    boolean bool1;
    for (;;)
    {
      try
      {
        paramList1.a();
        localObject2 = this.jdField_c_of_type_JavaUtilList.iterator();
        paramBoolean1 = false;
        if (!((Iterator)localObject2).hasNext()) {
          break label838;
        }
        localObject3 = (MobileContactsFriendInfo)((Iterator)localObject2).next();
        paramList = (PhoneContact)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramList == null) {
          break label783;
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
          localObject3 = ((ajjj)localObject1).e(paramList.uin);
          if (localObject3 != null) {
            paramList.nickName = ((Friends)localObject3).name;
          }
          this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList.uin, paramList);
          ((ajjj)localObject1).a(paramList.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramList.unifiedCode)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramList.unifiedCode, paramList);
        }
        this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramList.mobileNo);
        this.jdField_a_of_type_Atmp.a(paramList);
        paramBoolean1 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramList != null) {
          break label828;
        }
        paramList = "null";
        QLog.d("PhoneContact.Manager", 2, paramList);
        paramBoolean1 = bool1;
        continue;
        n = -1;
      }
      finally
      {
        paramList1.b();
      }
      break;
      label777:
      n = -1;
      break label311;
      label783:
      bool1 = paramBoolean1;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean1;
        continue;
        label828:
        paramList = paramList.unifiedCode;
      }
    }
    label838:
    paramList1.c();
    paramList1.b();
    boolean bool3;
    boolean bool2;
    for (;;)
    {
      if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0))
      {
        paramList1 = new ArrayList(this.jdField_d_of_type_JavaUtilList.size());
        paramList = this.jdField_a_of_type_Atmp.a();
      }
      for (;;)
      {
        try
        {
          paramList.a();
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
              this.jdField_a_of_type_Atmp.a((atmo)localObject3);
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label1579;
              }
              QLog.d("PhoneContact.Manager", 2, "MobileContactsNotFriendInfo; mobile=" + ((PhoneContact)localObject3).unifiedCode + " hide=" + ((PhoneContact)localObject3).isHiden);
              paramBoolean1 = true;
              break;
            }
            bool3 = bool1;
            bool2 = paramBoolean1;
            if (!QLog.isColorLevel()) {
              break label1579;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean1;
            break label1579;
          }
          e(paramList1);
          paramList.c();
          paramList.b();
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
          n = paramInt;
          if (bool2) {
            n = paramInt | 0x8;
          }
          if (paramLong1 == 4294967295L)
          {
            f(paramBoolean2);
            b(paramBoolean1, this.jdField_b_of_type_JavaUtilList);
            this.jdField_b_of_type_JavaUtilList.clear();
            q();
            a(paramLong2, paramLong3);
          }
          c(bool2);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "saveContactFromServer_v2 leave");
          }
          return n;
        }
        finally
        {
          paramList.b();
        }
        bool2 = false;
      }
      label1561:
      paramBoolean1 = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean1;
      paramBoolean1 = bool2;
      break;
      label1579:
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
    if (this.jdField_i_of_type_Boolean) {}
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
  
  public ahzr a(List<PhoneContact> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new PhoneContactManagerImp.8(this, paramList));
    return this.jdField_a_of_type_Ahzr;
  }
  
  public amnv a()
  {
    if (this.jdField_a_of_type_Amnv == null) {
      this.jdField_a_of_type_Amnv = new amnv();
    }
    return this.jdField_a_of_type_Amnv;
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
    if (this.jdField_i_of_type_Boolean) {}
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
        for (atmp localatmp = null; localatmp != null; localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager())
        {
          PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)localatmp.a(PhoneNumInfo.class, paramString);
          if (localPhoneNumInfo != null)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPhoneNumInfo.uin);
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneNumInfo.uin, paramString);
          }
          localatmp.a();
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
    ajjj localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PhoneContact)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((PhoneContact)localObject2).samFriend > 0) && (!localajjj.a(((PhoneContact)localObject2).unifiedCode, true))) {
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
        Collections.sort((List)localObject1, new ajnq(new int[] { 3, 4 }, (Set)localObject2, localajjj));
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, String.format("generateRandomList,[%s, %s, %s]", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()), Integer.valueOf(localArrayList.size()), Long.valueOf(System.currentTimeMillis() - l1) }));
        }
        return localObject1;
        localObject1 = new ArrayList(this.jdField_g_of_type_Int);
        int n = 0;
        if (n < this.jdField_g_of_type_Int)
        {
          ((ArrayList)localObject1).add((PhoneContact)localArrayList.remove(this.jdField_a_of_type_JavaUtilRandom.nextInt(localArrayList.size())));
          n += 1;
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
      Collections.sort((List)localObject, new ajnw(this));
    }
    ArrayList localArrayList = new ArrayList();
    ajjj localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    label198:
    label233:
    label247:
    String str2;
    int i1;
    label323:
    int n;
    label343:
    int i2;
    label357:
    int i3;
    label379:
    Friends localFriends;
    label387:
    label403:
    int i4;
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
                  break label233;
                }
                paramMap = null;
                if ((paramMap == null) || (paramMap.groupid < 0)) {
                  break label247;
                }
                ((PhoneContact)localObject).nickName = paramMap.getFriendNick();
                ((PhoneContact)localObject).remark = paramMap.remark;
              }
              for (paramMap = (Map<String, PhoneContact>)localObject;; paramMap = (Map<String, PhoneContact>)localObject)
              {
                break;
                paramMap = localajjj.e(((PhoneContact)localObject).uin);
                break label198;
                ((PhoneContact)localObject).uin = "0";
              }
            }
            if ((!paramBoolean) && (((PhoneContact)localObject).contactID == paramMap.contactID))
            {
              str2 = paramMap.mobileNo + "|" + ((PhoneContact)localObject).mobileNo;
              if (!TextUtils.isEmpty(paramMap.uin))
              {
                i1 = 1;
                if ((i1 == 0) || (paramMap.uin.equals("0"))) {
                  break label477;
                }
                n = 1;
                if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
                  break label482;
                }
                i2 = 1;
                if ((i2 == 0) || (((PhoneContact)localObject).uin.equals("0"))) {
                  break label488;
                }
                i3 = 1;
                if (i3 != 0) {
                  break label494;
                }
                localFriends = null;
                if ((localFriends == null) || (localFriends.groupid < 0)) {
                  break label509;
                }
                i3 = 1;
                i4 = 2;
                if (n == 0) {
                  break label515;
                }
                n = 0;
                label412:
                if (i3 == 0) {
                  break label528;
                }
                i1 = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label420:
      if (n > i1)
      {
        paramMap = (Map<String, PhoneContact>)localObject;
        if (i2 != 0)
        {
          if (i3 == 0) {
            break label539;
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
        i1 = 0;
        break label323;
        label477:
        n = 0;
        break label343;
        label482:
        i2 = 0;
        break label357;
        label488:
        i3 = 0;
        break label379;
        label494:
        localFriends = localajjj.e(((PhoneContact)localObject).uin);
        break label387;
        label509:
        i3 = 0;
        break label403;
        label515:
        n = i4;
        if (i1 == 0) {
          break label412;
        }
        n = 1;
        break label412;
        label528:
        if (i2 == 0) {
          break label726;
        }
        i1 = 1;
        break label420;
        label539:
        ((PhoneContact)localObject).uin = "0";
        paramMap = (Map<String, PhoneContact>)localObject;
        continue;
        localArrayList.add(paramMap);
        paramMap = (Map<String, PhoneContact>)localObject;
        if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
          break;
        }
        if (((PhoneContact)localObject).uin.equals("0")) {}
        for (paramMap = null;; paramMap = localajjj.e(((PhoneContact)localObject).uin))
        {
          if ((paramMap == null) || (paramMap.groupid < 0)) {
            break label639;
          }
          ((PhoneContact)localObject).nickName = paramMap.getFriendNick();
          ((PhoneContact)localObject).remark = paramMap.remark;
          paramMap = (Map<String, PhoneContact>)localObject;
          break;
        }
        label639:
        ((PhoneContact)localObject).uin = "0";
        paramMap = (Map<String, PhoneContact>)localObject;
        break;
        if (paramMap != null) {
          localArrayList.add(paramMap);
        }
        c(localArrayList);
        Collections.sort(localArrayList, new ajny(this));
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "getContactListForContactListView sort contact cost time: " + (System.currentTimeMillis() - l1));
        }
        return localArrayList;
      }
      label726:
      i1 = 2;
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
      Collections.sort((List)localObject2, new ajnq(new int[] { 1, 4 }, null, null));
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
      Collections.sort((List)localObject, new ajnq(paramArrayOfInt, this.jdField_a_of_type_JavaUtilSet, (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)));
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
      n = localCursor.getCount();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "load contacs from system db, size=" + n);
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
          str2 = ajnr.a(localCursor.getString(localCursor.getColumnIndex("data1")));
          str3 = localCursor.getString(localCursor.getColumnIndex("display_name"));
          String str1 = str3;
          if (TextUtils.isEmpty(str3)) {
            str1 = str2;
          }
          n = localCursor.getInt(localCursor.getColumnIndex("contact_id"));
          i1 = localCursor.getInt(localCursor.getColumnIndex("data2"));
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
          int n;
          String str2;
          String str3;
          int i1;
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
          localPhoneContact.contactID = n;
          localPhoneContact.type = i1;
          localPhoneContact.label = str3;
          localPhoneContact.lastScanTime = l1;
          localPhoneContact.pinyinAll = ChnToSpell.a(localStaleDataException, 1);
          localPhoneContact.pinyinInitial = ChnToSpell.a(localStaleDataException, 2);
          localPhoneContact.pinyinFirst = ajnr.b(localPhoneContact.pinyinInitial);
          localPhoneContact.md5 = ajnr.a(localStaleDataException, str2);
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
    if (this.jdField_a_of_type_Ajod != null)
    {
      try
      {
        if (this.jdField_i_of_type_Boolean) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_Ajod);
        this.jdField_a_of_type_Ajod.a(null);
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
      this.jdField_a_of_type_Ajod = null;
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
          int n = paramString.optInt("all_entrance_num");
          if (n > 0) {
            jdField_b_of_type_Int = n;
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
      QLog.d("PhoneContact.Manager", 2, "saveUIBits: newBits = " + paramLong + " localUIBits = " + this.jdField_g_of_type_Long);
    }
    if (this.jdField_g_of_type_Long != paramLong)
    {
      this.jdField_g_of_type_Long = paramLong;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_contacts_switches", paramLong);
      b(paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == jdField_a_of_type_Long) && (paramLong2 == jdField_b_of_type_Long) && (paramLong3 == jdField_c_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("saveQueryInterval not change [limit:%s, logInLimit:%s, reconnectLimit:%s]", new Object[] { Long.valueOf(jdField_a_of_type_Long), Long.valueOf(jdField_b_of_type_Long), Long.valueOf(jdField_c_of_type_Long) }));
      }
    }
    for (;;)
    {
      return;
      try
      {
        jdField_a_of_type_Long = Math.max(120000L, paramLong1);
        jdField_b_of_type_Long = Math.max(0L, paramLong2);
        jdField_c_of_type_Long = Math.max(0L, paramLong3);
        this.jdField_b_of_type_AndroidContentSharedPreferences.edit().putLong("query_contact_list_min_interval", jdField_a_of_type_Long).putLong("query_contact_list_min_interval_for_login", jdField_b_of_type_Long).putLong("query_contact_list_min_interval_for_reconnect", jdField_c_of_type_Long).apply();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PhoneContact.Manager", 2, String.format("saveQueryInterval  [limit:%s, logInLimit:%s, reconnectLimit:%s]", new Object[] { Long.valueOf(jdField_a_of_type_Long), Long.valueOf(jdField_b_of_type_Long), Long.valueOf(jdField_c_of_type_Long) }));
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
  
  public void a(aroi paramaroi)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramaroi)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramaroi);
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
        this.jdField_a_of_type_Atmp.b(paramContactMatch);
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
        this.jdField_a_of_type_Atmp.b(paramPhoneContactAdd);
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
      atmr localatmr;
      int n;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localatmr = this.jdField_a_of_type_Atmp.a();
        try
        {
          localatmr.a();
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
          localPhoneContactAdd.timestamp = awao.a();
          a(localPhoneContactAdd);
          n = 0;
          if (n != 0)
          {
            localObject2 = new PhoneContactAdd();
            ((PhoneContactAdd)localObject2).name = paramString2;
            ((PhoneContactAdd)localObject2).unifiedCode = paramString1;
            ((PhoneContactAdd)localObject2).timestamp = awao.a();
            if (paramInt != 1) {
              break label355;
            }
            ((PhoneContactAdd)localObject2).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131629352);
            if (this.jdField_b_of_type_JavaUtilArrayList == null) {
              this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            a((atmo)localObject2);
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
              this.jdField_a_of_type_Atmp.b((atmo)localObject2);
            }
          }
          localatmr.c();
        }
        catch (Resources.NotFoundException paramString1)
        {
          Object localObject2;
          if (!QLog.isColorLevel()) {
            break label404;
          }
          QLog.d("PhoneContact.Manager", 2, "makePhoneContactAddInfo", paramString1);
          localatmr.b();
          continue;
        }
        finally
        {
          localatmr.b();
        }
        return;
      }
      label355:
      if (paramInt == 4)
      {
        ((PhoneContactAdd)localObject2).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131629353);
        continue;
        n = 1;
      }
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), atoi.class);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), atoi.class);
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
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), atoi.class);
      localNewIntent.putExtra("req_type", 34);
      localNewIntent.putExtra("param_hiden_mobile", (Serializable)localObject);
      localNewIntent.putExtra("param_hiden_flag", paramBoolean);
      localNewIntent.putExtra("unique_phone_no", paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  public void a(ArrayList<PhoneContact> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "updateRenameList");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    atmr localatmr;
    label133:
    do
    {
      for (;;)
      {
        return;
        localatmr = this.jdField_a_of_type_Atmp.a();
        try
        {
          localatmr.a();
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
            this.jdField_a_of_type_Atmp.a(localPhoneContact);
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
            this.jdField_a_of_type_Atmp.a(localPhoneContact);
          }
        }
        finally
        {
          if (localatmr != null) {
            localatmr.b();
          }
        }
      }
      localatmr.c();
    } while (localatmr == null);
    localatmr.b();
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
      localObject2 = this.jdField_a_of_type_Atmp.a();
    }
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject3;
      Object localObject4;
      try
      {
        ((atmr)localObject2).a();
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
          ((PhoneContactAdd)localObject5).timestamp = awao.a();
          a((atmo)localObject5);
          paramInt = 0;
          if (paramInt == 0) {
            continue;
          }
          localObject4 = new PhoneContactAdd();
          ((PhoneContactAdd)localObject4).unifiedCode = ((FriendListHandler.AddBatchPhoneFriendResult)localObject3).mobile;
          ((PhoneContactAdd)localObject4).timestamp = awao.a();
          ((PhoneContactAdd)localObject4).remindInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources().getString(2131629352);
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
        ((atmr)localObject2).b();
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
            a((atmo)localObject4);
          }
        }
        else
        {
          continue;
        }
      }
      finally
      {
        ((atmr)localObject2).b();
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
            this.jdField_a_of_type_Atmp.b(paramArrayList1);
          }
        }
      }
      label660:
      ((atmr)localObject2).c();
      ((atmr)localObject2).b();
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
    //   1: getfield 620	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_i_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +29 -> 40
    //   14: ldc 234
    //   16: iconst_2
    //   17: new 180	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 2076
    //   27: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 1135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 249	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   44: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   47: invokevirtual 268	atmq:createEntityManager	()Latmp;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +13 -> 65
    //   55: ldc 234
    //   57: iconst_1
    //   58: ldc_w 2078
    //   61: invokestatic 1845	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: return
    //   65: aload_3
    //   66: invokevirtual 451	atmp:a	()Latmr;
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 455	atmr:a	()V
    //   74: aload_3
    //   75: ldc_w 2080
    //   78: aconst_null
    //   79: aconst_null
    //   80: invokevirtual 2081	atmp:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   83: pop
    //   84: aload_1
    //   85: invokeinterface 578 1 0
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 583 1 0
    //   97: ifeq +63 -> 160
    //   100: aload_1
    //   101: invokeinterface 587 1 0
    //   106: checkcast 67	java/lang/String
    //   109: astore 4
    //   111: aload 4
    //   113: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifne -25 -> 91
    //   119: new 1404	com/tencent/mobileqq/data/LastLoginPhoneInfo
    //   122: dup
    //   123: invokespecial 2082	com/tencent/mobileqq/data/LastLoginPhoneInfo:<init>	()V
    //   126: astore 5
    //   128: aload 5
    //   130: aload 4
    //   132: putfield 1408	com/tencent/mobileqq/data/LastLoginPhoneInfo:unifiedCode	Ljava/lang/String;
    //   135: aload_3
    //   136: aload 5
    //   138: invokevirtual 1316	atmp:b	(Latmo;)V
    //   141: goto -50 -> 91
    //   144: astore_1
    //   145: ldc 234
    //   147: iconst_1
    //   148: ldc_w 2084
    //   151: aload_1
    //   152: invokestatic 1169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_2
    //   156: invokevirtual 485	atmr:b	()V
    //   159: return
    //   160: aload_2
    //   161: invokevirtual 613	atmr:c	()V
    //   164: aload_2
    //   165: invokevirtual 485	atmr:b	()V
    //   168: return
    //   169: astore_1
    //   170: aload_2
    //   171: invokevirtual 485	atmr:b	()V
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	PhoneContactManagerImp
    //   0	176	1	paramSet	Set<String>
    //   69	102	2	localatmr	atmr
    //   50	86	3	localatmp	atmp
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
    d(paramBoolean);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), atoi.class);
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
    //   3: getfield 620	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_i_of_type_Boolean	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 2091	com/tencent/mobileqq/app/PhoneContactManagerImp$5
    //   19: dup
    //   20: aload_0
    //   21: iload_1
    //   22: iload_2
    //   23: iload_3
    //   24: invokespecial 2094	com/tencent/mobileqq/app/PhoneContactManagerImp$5:<init>	(Lcom/tencent/mobileqq/app/PhoneContactManagerImp;ZZI)V
    //   27: bipush 16
    //   29: aconst_null
    //   30: iconst_0
    //   31: invokestatic 332	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
  
  public boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat, String paramString)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("saveBindInfo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_i_of_type_Boolean), paramRespondQueryQQBindingStat, Integer.valueOf(this.jdField_a_of_type_Int), paramString }));
    }
    if (this.jdField_i_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = a(a());
    }
    int n = a(paramRespondQueryQQBindingStat);
    if (this.jdField_a_of_type_Int != n) {
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
    this.jdField_h_of_type_Boolean = paramString.isPhoneSwitched;
    paramRespondQueryQQBindingStat.commit();
    a(paramString);
    return bool;
  }
  
  protected boolean a(atmo paramatmo)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Atmp.a()) {
      if (paramatmo.getStatus() == 1000)
      {
        this.jdField_a_of_type_Atmp.b(paramatmo);
        if (paramatmo.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramatmo.getStatus() == 1001) || (paramatmo.getStatus() == 1002)) {
        return this.jdField_a_of_type_Atmp.a(paramatmo);
      }
    }
    QLog.d("PhoneContact.Manager", 2, "updateEntity em closed e=" + paramatmo.getTableName());
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
          this.jdField_a_of_type_Atmp.b(localPhoneContactAdd);
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
    //   6: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +39 -> 48
    //   12: ldc 234
    //   14: iconst_2
    //   15: new 180	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 2125
    //   25: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 1538
    //   35: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 168	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: invokevirtual 423	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   58: astore 9
    //   60: getstatic 2128	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   63: astore 8
    //   65: new 180	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 2130
    //   75: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 2132
    //   85: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore_1
    //   92: aload 9
    //   94: aload 8
    //   96: iconst_4
    //   97: anewarray 67	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 2134
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: ldc_w 2136
    //   111: aastore
    //   112: dup
    //   113: iconst_2
    //   114: ldc_w 2138
    //   117: aastore
    //   118: dup
    //   119: iconst_3
    //   120: ldc 69
    //   122: aastore
    //   123: aload_1
    //   124: aconst_null
    //   125: aconst_null
    //   126: invokevirtual 435	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   129: astore 8
    //   131: aload_2
    //   132: astore_1
    //   133: aload 6
    //   135: astore_2
    //   136: aload 8
    //   138: invokeinterface 480 1 0
    //   143: ifeq +360 -> 503
    //   146: aload 8
    //   148: aload 8
    //   150: ldc_w 2134
    //   153: invokeinterface 465 2 0
    //   158: invokeinterface 2141 2 0
    //   163: lstore_3
    //   164: getstatic 2128	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   167: astore 6
    //   169: new 180	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 2143
    //   179: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: lload_3
    //   183: invokevirtual 911	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: ldc_w 2145
    //   189: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 2138
    //   195: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 2147
    //   201: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc_w 2149
    //   207: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 2151
    //   213: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 75
    //   218: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 2147
    //   224: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iconst_2
    //   228: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 2132
    //   234: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: astore 7
    //   242: aload 9
    //   244: aload 6
    //   246: iconst_5
    //   247: anewarray 67	java/lang/String
    //   250: dup
    //   251: iconst_0
    //   252: ldc_w 2134
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: ldc_w 2136
    //   261: aastore
    //   262: dup
    //   263: iconst_2
    //   264: ldc_w 2138
    //   267: aastore
    //   268: dup
    //   269: iconst_3
    //   270: ldc 69
    //   272: aastore
    //   273: dup
    //   274: iconst_4
    //   275: ldc 75
    //   277: aastore
    //   278: aload 7
    //   280: aconst_null
    //   281: aconst_null
    //   282: invokevirtual 435	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   285: astore 6
    //   287: aload 6
    //   289: astore_2
    //   290: aload_2
    //   291: invokeinterface 458 1 0
    //   296: ifeq +96 -> 392
    //   299: aload_2
    //   300: aload_2
    //   301: ldc 69
    //   303: invokeinterface 465 2 0
    //   308: invokeinterface 468 2 0
    //   313: invokestatic 473	ajnr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 7
    //   318: aload_1
    //   319: invokestatic 473	ajnr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   322: astore 6
    //   324: aload 6
    //   326: astore_1
    //   327: aload 7
    //   329: aload_1
    //   330: invokestatic 2154	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   333: ifne +35 -> 368
    //   336: new 180	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 2156
    //   346: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 7
    //   351: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload_1
    //   358: invokestatic 2154	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   361: istore 5
    //   363: iload 5
    //   365: ifeq +27 -> 392
    //   368: aload_2
    //   369: ifnull +9 -> 378
    //   372: aload_2
    //   373: invokeinterface 488 1 0
    //   378: aload 8
    //   380: ifnull +10 -> 390
    //   383: aload 8
    //   385: invokeinterface 488 1 0
    //   390: iconst_1
    //   391: ireturn
    //   392: aload_2
    //   393: astore 7
    //   395: aload_1
    //   396: astore 6
    //   398: aload_2
    //   399: ifnull +156 -> 555
    //   402: aload_2
    //   403: invokeinterface 488 1 0
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
    //   428: invokeinterface 488 1 0
    //   433: aload_2
    //   434: astore 7
    //   436: aload_1
    //   437: astore 6
    //   439: goto +116 -> 555
    //   442: astore_2
    //   443: aload 8
    //   445: astore_1
    //   446: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +13 -> 462
    //   452: ldc 234
    //   454: iconst_2
    //   455: ldc_w 2158
    //   458: aload_2
    //   459: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: aload_1
    //   463: ifnull +9 -> 472
    //   466: aload_1
    //   467: invokeinterface 488 1 0
    //   472: iconst_0
    //   473: ireturn
    //   474: astore_1
    //   475: aload_2
    //   476: ifnull +9 -> 485
    //   479: aload_2
    //   480: invokeinterface 488 1 0
    //   485: aload_1
    //   486: athrow
    //   487: astore_1
    //   488: aload 8
    //   490: astore_2
    //   491: aload_2
    //   492: ifnull +9 -> 501
    //   495: aload_2
    //   496: invokeinterface 488 1 0
    //   501: aload_1
    //   502: athrow
    //   503: aload 8
    //   505: ifnull -33 -> 472
    //   508: aload 8
    //   510: invokeinterface 488 1 0
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
    int n;
    long l1;
    long l2;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      n = 1;
      l1 = awao.a();
      if (n == 0) {
        this.jdField_i_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("user_setting_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0L);
      }
      l2 = Math.abs(l1 - this.jdField_i_of_type_Long);
      if (l2 >= 3600L) {
        break label255;
      }
      boolean bool = i();
      if (n == 0) {
        bool = k();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, "checkAndUploadContact,  has: " + bool + ",  state: " + d());
      }
      if (!bool) {
        break label255;
      }
      if (n == 0) {
        break label239;
      }
      ThreadManager.excute(new PhoneContactManagerImp.22(this, paramBoolean), 16, null, false);
    }
    label170:
    label239:
    label255:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("checkAndUploadContact [%s, %s, %s, %s]", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(this.jdField_i_of_type_Long), Boolean.valueOf(paramBoolean) }));
      }
      b(false);
      return paramBoolean;
      n = 0;
      break;
      j();
      if (!paramBoolean) {
        break label170;
      }
      this.jdField_e_of_type_Boolean = true;
      break label170;
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
    int n;
    if (QLog.isColorLevel())
    {
      n = this.jdField_f_of_type_Int;
      if (this.jdField_e_of_type_JavaUtilList != null) {
        break label212;
      }
    }
    label199:
    label212:
    for (Object localObject = "null";; localObject = TextUtils.join(",", this.jdField_e_of_type_JavaUtilList))
    {
      QLog.i("PhoneContact.Manager", 2, String.format("getFriendHasBindPhone [%s, %s]", new Object[] { Integer.valueOf(n), localObject }));
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
    int n;
    if (d() == 9)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" isCacheInited=");
        localStringBuffer.append(this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_d_of_type_Boolean) {
        if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
          n = 1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" ret=");
        localStringBuffer.append(n);
        QLog.d("PhoneContact.Manager", 2, localStringBuffer.toString());
      }
      return n;
      n = 2;
      continue;
      n = 0;
      continue;
      n = 2;
    }
  }
  
  public PhoneContact b(String paramString)
  {
    if (this.jdField_d_of_type_Boolean) {
      return (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_Atmp != null) {
      return (PhoneContact)this.jdField_a_of_type_Atmp.a(PhoneContact.class, paramString);
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
    paramString = (PhoneNumInfo)((atmp)localObject).a(PhoneNumInfo.class, "uin=?", new String[] { paramString });
    if (paramString != null) {
      return paramString.phoneNum;
    }
    return null;
  }
  
  public ArrayList<atmo> b()
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
      ajjj localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      Collections.sort((List)localObject1, new ajnq(new int[] { 6, 5, 1, 4 }, (Set)localObject2, localajjj));
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
  
  public void b(aroi paramaroi)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramaroi);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), atoi.class);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), atoi.class);
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
      this.jdField_a_of_type_Atmp.a(paramString);
    }
  }
  
  public void b(List<AddressBookItem> paramList)
  {
    for (;;)
    {
      atmr localatmr;
      try
      {
        boolean bool = this.jdField_i_of_type_Boolean;
        if (bool) {
          return;
        }
        if ((paramList == null) || (paramList.isEmpty())) {
          continue;
        }
        localatmr = this.jdField_a_of_type_Atmp.a();
        try
        {
          localatmr.a();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_Atmp.a((atmo)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localatmr.b();
        }
        localatmr.c();
      }
      finally {}
      localatmr.b();
      this.jdField_c_of_type_Int += 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l1 = awao.a();; l1 = 0L)
    {
      this.jdField_i_of_type_Long = l1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("user_setting_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_i_of_type_Long).apply();
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("markOrClearUserSettingFlag [%s]", new Object[] { Long.valueOf(this.jdField_i_of_type_Long) }));
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
    } while (this.jdField_a_of_type_Atmp == null);
    return (PhoneContact)this.jdField_a_of_type_Atmp.a(PhoneContact.class, "mobileCode=?", new String[] { paramString });
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
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      ??? = this.jdField_a_of_type_Atmp.a(PhoneContact.class);
      if (??? != null)
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)???).next();
          localPhoneContact.pinyinFirst = ajnr.b(localPhoneContact.pinyinInitial);
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
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_Atmp.a(ContactMatch.class, false, null, null, null, null, null, null));
      this.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_Atmp.a(PhoneContactAdd.class, false, null, null, null, null, null, null));
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
        ((atmp)localObject).b(localPhoneNumInfo);
        ((atmp)localObject).a();
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
  
  public boolean c()
  {
    int n = d();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isBindContactOk = " + n);
    }
    return n >= 9;
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
        return this.jdField_a_of_type_Atmp.a(PhoneContact.class);
      }
    }
    return this.jdField_a_of_type_Atmp.a(PhoneContact.class);
  }
  
  public void d()
  {
    a(1);
  }
  
  public void d(List<AddressBookItem> paramList)
  {
    for (;;)
    {
      atmr localatmr;
      try
      {
        boolean bool = this.jdField_i_of_type_Boolean;
        if (bool) {
          return;
        }
        if ((paramList == null) || (paramList.isEmpty())) {
          continue;
        }
        localatmr = this.jdField_a_of_type_Atmp.a();
        try
        {
          localatmr.a();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_Atmp.a((atmo)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localatmr.b();
        }
        localatmr.c();
      }
      finally {}
      localatmr.b();
      this.jdField_c_of_type_Int += 1;
    }
  }
  
  public boolean d()
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
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<List<PhoneContact>> e()
  {
    Object localObject1 = null;
    long l1 = System.currentTimeMillis();
    if (this.jdField_i_of_type_Boolean) {
      localObject1 = new ArrayList(0);
    }
    Object localObject2;
    label352:
    do
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      ajjj localajjj;
      do
      {
        return localObject1;
        if (this.jdField_f_of_type_JavaUtilList != null) {
          break label466;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        Collections.sort((List)localObject2, new ajns(this));
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
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
                  break label393;
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
              break label411;
            }
            localPhoneContact.nickName = ((Friends)localObject2).getFriendNick();
            localPhoneContact.remark = ((Friends)localObject2).remark;
          }
          for (;;)
          {
            localArrayList1.add(localPhoneContact);
            break;
            localObject2 = localajjj.e(localPhoneContact.uin);
            break label352;
            localPhoneContact.uin = "0";
          }
        }
      }
      if (localObject1 != null) {
        localArrayList2.add(localObject1);
      }
      localObject1 = new ajnt(this);
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
    label393:
    label411:
    label466:
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
  
  public int f()
  {
    return this.jdField_c_of_type_AndroidContentSharedPreferences.getInt("key_config_version", 0);
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
        Collections.sort(localArrayList, new ajnu(this));
      }
      this.jdField_i_of_type_JavaUtilList = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForSelector sort contact cost time: " + (System.currentTimeMillis() - l1));
    }
    return this.jdField_i_of_type_JavaUtilList;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 270	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Atmp	Latmp;
    //   11: invokevirtual 451	atmp:a	()Latmr;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 455	atmr:a	()V
    //   19: aload_0
    //   20: getfield 386	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 386	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   30: iconst_1
    //   31: putfield 1098	com/tencent/mobileqq/data/ContactBinded:isReaded	Z
    //   34: aload_0
    //   35: getfield 1050	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   38: ifnull +81 -> 119
    //   41: aload_0
    //   42: getfield 1050	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   45: invokevirtual 493	java/util/ArrayList:size	()I
    //   48: ifle +71 -> 119
    //   51: aload_0
    //   52: getfield 1050	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   55: invokevirtual 1053	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 583 1 0
    //   65: ifeq +54 -> 119
    //   68: aload_3
    //   69: invokeinterface 587 1 0
    //   74: checkcast 1055	com/tencent/mobileqq/data/ContactMatch
    //   77: astore 4
    //   79: aload 4
    //   81: iconst_1
    //   82: putfield 2322	com/tencent/mobileqq/data/ContactMatch:isReaded	Z
    //   85: aload_0
    //   86: aload 4
    //   88: invokevirtual 1090	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Latmo;)Z
    //   91: pop
    //   92: goto -33 -> 59
    //   95: astore_3
    //   96: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +13 -> 112
    //   102: ldc 234
    //   104: iconst_2
    //   105: ldc_w 2324
    //   108: aload_3
    //   109: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: invokevirtual 485	atmr:b	()V
    //   116: aload_1
    //   117: monitorexit
    //   118: return
    //   119: aload_2
    //   120: invokevirtual 613	atmr:c	()V
    //   123: aload_2
    //   124: invokevirtual 485	atmr:b	()V
    //   127: goto -11 -> 116
    //   130: astore_2
    //   131: aload_1
    //   132: monitorexit
    //   133: aload_2
    //   134: athrow
    //   135: astore_3
    //   136: aload_2
    //   137: invokevirtual 485	atmr:b	()V
    //   140: aload_3
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	PhoneContactManagerImp
    //   4	128	1	localObject1	Object
    //   14	110	2	localatmr	atmr
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
  
  public boolean f()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public List<PhoneContact> g()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((this.jdField_j_of_type_JavaUtilList == null) || (this.jdField_j_of_type_JavaUtilList.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          localArrayList.add(localPhoneContact);
        } else if ((!localPhoneContact.uin.equals("0")) && (((ajjj)localObject1).e(localPhoneContact.uin) != null)) {
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
            ((PhoneContact)localObject2).pinyinFirst = ajnr.b(((PhoneContact)localObject2).pinyinInitial);
          }
        }
        Collections.sort(localArrayList, new ajnv(this));
      }
      this.jdField_j_of_type_JavaUtilList = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForPhoneSelector sort contact cost time: " + (System.currentTimeMillis() - l1));
    }
    return this.jdField_j_of_type_JavaUtilList;
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +84 -> 91
    //   10: new 180	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 906	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc_w 2333
    //   24: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore_3
    //   28: aload_0
    //   29: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   32: bipush 8
    //   34: if_icmpne +85 -> 119
    //   37: aload_3
    //   38: iload_1
    //   39: invokevirtual 886	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc_w 2335
    //   47: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   54: invokevirtual 886	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_2
    //   59: ldc_w 1483
    //   62: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   68: aload_0
    //   69: getfield 96	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   72: lsub
    //   73: ldc2_w 924
    //   76: ldiv
    //   77: invokevirtual 911	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc 234
    //   83: iconst_2
    //   84: aload_2
    //   85: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   95: bipush 8
    //   97: if_icmpeq +19 -> 116
    //   100: aload_0
    //   101: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   104: ifne +12 -> 116
    //   107: aload_0
    //   108: invokevirtual 338	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   111: astore_2
    //   112: aload_2
    //   113: ifnonnull +11 -> 124
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: iconst_0
    //   120: istore_1
    //   121: goto -84 -> 37
    //   124: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   127: aload_0
    //   128: getfield 96	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   131: lsub
    //   132: ldc2_w 62
    //   135: lcmp
    //   136: iflt -20 -> 116
    //   139: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +12 -> 154
    //   145: ldc 234
    //   147: iconst_2
    //   148: ldc_w 2337
    //   151: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   158: iconst_2
    //   159: if_icmpeq +19 -> 178
    //   162: aload_0
    //   163: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   166: iconst_3
    //   167: if_icmpeq +11 -> 178
    //   170: aload_0
    //   171: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   174: iconst_4
    //   175: if_icmpne +7 -> 182
    //   178: aload_0
    //   179: invokespecial 763	com/tencent/mobileqq/app/PhoneContactManagerImp:v	()V
    //   182: aload_0
    //   183: bipush 8
    //   185: putfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   188: aload_0
    //   189: invokespecial 760	com/tencent/mobileqq/app/PhoneContactManagerImp:p	()V
    //   192: aload_0
    //   193: getfield 381	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator;
    //   196: ifnonnull +23 -> 219
    //   199: aload_0
    //   200: new 2339	com/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator
    //   203: dup
    //   204: aload_0
    //   205: aconst_null
    //   206: invokespecial 2340	com/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator:<init>	(Lcom/tencent/mobileqq/app/PhoneContactManagerImp;Lcom/tencent/mobileqq/app/PhoneContactManagerImp$1;)V
    //   209: putfield 381	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator;
    //   212: aload_0
    //   213: getfield 381	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator;
    //   216: invokevirtual 2341	com/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator:a	()V
    //   219: aload_0
    //   220: invokespecial 2343	com/tencent/mobileqq/app/PhoneContactManagerImp:d	()Ljava/util/ArrayList;
    //   223: astore_3
    //   224: aload_3
    //   225: astore_2
    //   226: aload_3
    //   227: ifnonnull +12 -> 239
    //   230: new 152	java/util/ArrayList
    //   233: dup
    //   234: iconst_0
    //   235: invokespecial 1051	java/util/ArrayList:<init>	(I)V
    //   238: astore_2
    //   239: aload_0
    //   240: getfield 688	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_l_of_type_Boolean	Z
    //   243: ifeq +14 -> 257
    //   246: aload_0
    //   247: iconst_1
    //   248: aload_2
    //   249: invokevirtual 493	java/util/ArrayList:size	()I
    //   252: iconst_0
    //   253: iconst_0
    //   254: invokespecial 785	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(IIII)V
    //   257: new 958	mqq/app/NewIntent
    //   260: dup
    //   261: aload_0
    //   262: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   265: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   268: ldc_w 960
    //   271: invokespecial 963	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   274: astore_3
    //   275: aload_3
    //   276: ldc_w 965
    //   279: bipush 31
    //   281: invokevirtual 969	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   284: pop
    //   285: aload_3
    //   286: ldc_w 985
    //   289: aload_0
    //   290: invokevirtual 338	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   293: invokevirtual 988	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   296: pop
    //   297: aload_3
    //   298: ldc_w 971
    //   301: lconst_0
    //   302: invokevirtual 974	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   305: pop
    //   306: aload_3
    //   307: ldc_w 1016
    //   310: iconst_0
    //   311: invokevirtual 969	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   314: pop
    //   315: aload_3
    //   316: ldc_w 2345
    //   319: aload_2
    //   320: invokevirtual 1010	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   323: pop
    //   324: aload_3
    //   325: ldc 202
    //   327: iconst_0
    //   328: newarray byte
    //   330: invokevirtual 983	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   333: pop
    //   334: aload_3
    //   335: ldc_w 1018
    //   338: iconst_0
    //   339: invokevirtual 1021	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   342: pop
    //   343: aload_0
    //   344: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: aload_3
    //   348: invokevirtual 998	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   351: goto -235 -> 116
    //   354: astore_2
    //   355: aload_0
    //   356: monitorexit
    //   357: aload_2
    //   358: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	PhoneContactManagerImp
    //   1	120	1	bool	boolean
    //   19	301	2	localObject1	Object
    //   354	4	2	localObject2	Object
    //   27	321	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	37	354	finally
    //   37	91	354	finally
    //   91	112	354	finally
    //   124	154	354	finally
    //   154	178	354	finally
    //   178	182	354	finally
    //   182	219	354	finally
    //   219	224	354	finally
    //   230	239	354	finally
    //   239	257	354	finally
    //   257	351	354	finally
  }
  
  /* Error */
  public boolean g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 168	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 423	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 429	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   16: iconst_1
    //   17: anewarray 67	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 69
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: ldc_w 2347
    //   30: invokevirtual 435	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: invokeinterface 443 1 0
    //   47: istore_1
    //   48: iload_1
    //   49: ifle +79 -> 128
    //   52: iconst_1
    //   53: istore_2
    //   54: aload 4
    //   56: ifnull +10 -> 66
    //   59: aload 4
    //   61: invokeinterface 488 1 0
    //   66: iload_2
    //   67: ireturn
    //   68: astore 5
    //   70: aconst_null
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 5
    //   78: invokevirtual 1313	java/lang/Exception:printStackTrace	()V
    //   81: aload 4
    //   83: ifnull +43 -> 126
    //   86: aload 4
    //   88: invokeinterface 488 1 0
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_3
    //   96: aload 4
    //   98: ifnull +10 -> 108
    //   101: aload 4
    //   103: invokeinterface 488 1 0
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
    //   47	2	1	n	int
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
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +76 -> 81
    //   8: new 180	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 906	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_1
    //   18: aload_1
    //   19: ldc_w 2349
    //   22: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   29: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: ldc_w 2351
    //   37: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   44: invokevirtual 886	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: ldc_w 1483
    //   52: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 96	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   62: lsub
    //   63: ldc2_w 924
    //   66: ldiv
    //   67: invokevirtual 911	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc 234
    //   73: iconst_2
    //   74: aload_1
    //   75: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: getfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   85: iconst_4
    //   86: if_icmpeq +17 -> 103
    //   89: aload_0
    //   90: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   93: ifne +10 -> 103
    //   96: aload_0
    //   97: invokevirtual 338	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   100: ifnonnull +37 -> 137
    //   103: aload_0
    //   104: getfield 92	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_b_of_type_Boolean	Z
    //   107: ifeq +27 -> 134
    //   110: aload_0
    //   111: getfield 196	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   114: invokeinterface 737 1 0
    //   119: ldc_w 1724
    //   122: iconst_1
    //   123: invokeinterface 769 3 0
    //   128: invokeinterface 772 1 0
    //   133: pop
    //   134: aload_0
    //   135: monitorexit
    //   136: return
    //   137: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   140: aload_0
    //   141: getfield 96	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_e_of_type_Long	J
    //   144: lsub
    //   145: ldc2_w 62
    //   148: lcmp
    //   149: iflt -15 -> 134
    //   152: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +12 -> 167
    //   158: ldc 234
    //   160: iconst_2
    //   161: ldc_w 2353
    //   164: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_0
    //   168: getfield 196	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   171: invokeinterface 737 1 0
    //   176: ldc_w 1724
    //   179: iconst_0
    //   180: invokeinterface 769 3 0
    //   185: invokeinterface 772 1 0
    //   190: pop
    //   191: aload_0
    //   192: iconst_4
    //   193: putfield 102	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_Int	I
    //   196: aload_0
    //   197: invokespecial 760	com/tencent/mobileqq/app/PhoneContactManagerImp:p	()V
    //   200: aload_0
    //   201: getfield 381	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator;
    //   204: ifnonnull +23 -> 227
    //   207: aload_0
    //   208: new 2339	com/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator
    //   211: dup
    //   212: aload_0
    //   213: aconst_null
    //   214: invokespecial 2340	com/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator:<init>	(Lcom/tencent/mobileqq/app/PhoneContactManagerImp;Lcom/tencent/mobileqq/app/PhoneContactManagerImp$1;)V
    //   217: putfield 381	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator;
    //   220: aload_0
    //   221: getfield 381	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator;
    //   224: invokevirtual 2341	com/tencent/mobileqq/app/PhoneContactManagerImp$UploadProgressGenerator:a	()V
    //   227: aload_0
    //   228: invokespecial 2343	com/tencent/mobileqq/app/PhoneContactManagerImp:d	()Ljava/util/ArrayList;
    //   231: astore_2
    //   232: aload_2
    //   233: astore_1
    //   234: aload_2
    //   235: ifnonnull +12 -> 247
    //   238: new 152	java/util/ArrayList
    //   241: dup
    //   242: iconst_0
    //   243: invokespecial 1051	java/util/ArrayList:<init>	(I)V
    //   246: astore_1
    //   247: aload_0
    //   248: getfield 688	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_l_of_type_Boolean	Z
    //   251: ifeq +14 -> 265
    //   254: aload_0
    //   255: iconst_1
    //   256: aload_1
    //   257: invokevirtual 493	java/util/ArrayList:size	()I
    //   260: iconst_0
    //   261: iconst_0
    //   262: invokespecial 785	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(IIII)V
    //   265: new 958	mqq/app/NewIntent
    //   268: dup
    //   269: aload_0
    //   270: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   273: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   276: ldc_w 960
    //   279: invokespecial 963	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   282: astore_2
    //   283: aload_2
    //   284: ldc_w 965
    //   287: bipush 37
    //   289: invokevirtual 969	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   292: pop
    //   293: aload_2
    //   294: ldc_w 985
    //   297: aload_0
    //   298: invokevirtual 338	com/tencent/mobileqq/app/PhoneContactManagerImp:a	()Ljava/lang/String;
    //   301: invokevirtual 988	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   304: pop
    //   305: aload_2
    //   306: ldc_w 971
    //   309: lconst_0
    //   310: invokevirtual 974	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   313: pop
    //   314: aload_2
    //   315: ldc_w 1016
    //   318: iconst_0
    //   319: invokevirtual 969	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   322: pop
    //   323: aload_2
    //   324: ldc_w 2345
    //   327: aload_1
    //   328: invokevirtual 1010	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   331: pop
    //   332: aload_2
    //   333: ldc 202
    //   335: iconst_0
    //   336: newarray byte
    //   338: invokevirtual 983	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   341: pop
    //   342: aload_2
    //   343: ldc_w 1018
    //   346: iconst_0
    //   347: invokevirtual 1021	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   350: pop
    //   351: aload_0
    //   352: getfield 162	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   355: aload_2
    //   356: invokevirtual 998	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   359: goto -225 -> 134
    //   362: astore_1
    //   363: aload_0
    //   364: monitorexit
    //   365: aload_1
    //   366: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	PhoneContactManagerImp
    //   17	311	1	localObject1	Object
    //   362	4	1	localObject2	Object
    //   231	125	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	81	362	finally
    //   81	103	362	finally
    //   103	134	362	finally
    //   137	167	362	finally
    //   167	227	362	finally
    //   227	232	362	finally
    //   238	247	362	finally
    //   247	265	362	finally
    //   265	359	362	finally
  }
  
  public boolean h()
  {
    return d() > 5;
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
    if (befo.k()) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(amnv.a("android.permission.READ_CONTACTS"));
    }
    for (;;)
    {
      ThreadManager.excute(new PhoneContactManagerImp.21(this), 16, null, true);
      if (QLog.isColorLevel()) {
        QLog.d("contact.PermissionChecker", 2, String.format("hasReadContactPermissionForUI isM=%b has=%b", new Object[] { Boolean.valueOf(befo.k()), this.jdField_a_of_type_JavaLangBoolean }));
      }
      return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
      if (this.jdField_a_of_type_JavaLangBoolean == null) {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
    }
  }
  
  public void j()
  {
    int n = d();
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "uploadOrUpdateContact state: " + n);
    }
    if (n > 5)
    {
      if (n == 9)
      {
        r();
        return;
      }
      g();
      return;
    }
    if (n == 2)
    {
      w();
      return;
    }
    h();
  }
  
  public boolean j()
  {
    boolean bool1;
    boolean bool2;
    if (befo.k())
    {
      bool1 = amnv.a("android.permission.READ_CONTACTS");
      if (!bool1) {
        break label75;
      }
      bool1 = g();
      bool2 = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
      QLog.d("contact.PermissionChecker", 1, String.format("hasReadContactPermission2 isM=%b has=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      return bool1;
      bool1 = g();
      bool2 = false;
      continue;
      label75:
      bool2 = true;
    }
  }
  
  public void k()
  {
    int n = d();
    if (n > 5) {
      if (n == 9)
      {
        this.jdField_l_of_type_Boolean = false;
        if (!this.jdField_d_of_type_Boolean) {
          c();
        }
        a(3, this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size(), 100, 100);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, String.format("markAndUploadForNewGuide [%s, %s]", new Object[] { Integer.valueOf(n), Boolean.valueOf(this.jdField_l_of_type_Boolean) }));
      }
      return;
      this.jdField_l_of_type_Boolean = true;
      g();
      continue;
      if (n == 2)
      {
        this.jdField_l_of_type_Boolean = false;
        if (!this.jdField_d_of_type_Boolean) {
          c();
        }
        a(3, this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size(), 100, 100);
      }
      else
      {
        this.jdField_l_of_type_Boolean = true;
        h();
      }
    }
  }
  
  public boolean k()
  {
    boolean bool1;
    if (befo.k()) {
      bool1 = amnv.a("android.permission.READ_CONTACTS");
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
      if (QLog.isColorLevel()) {
        QLog.d("contact.PermissionChecker", 2, String.format("hasReadContactPermission3 isM=%b has=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
      bool1 = g();
    }
  }
  
  public boolean l()
  {
    boolean bool = false;
    int n = d();
    if ((n == 6) || (n == 7) || (n == 5) || (n == 1) || (n == 3)) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "needUploadContact [" + n + ", " + bool + "]");
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.jdField_i_of_type_Boolean = true;
    this.jdField_g_of_type_JavaUtilList = null;
    this.jdField_f_of_type_JavaUtilList = null;
    this.jdField_i_of_type_JavaUtilList = null;
    this.jdField_k_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atog);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Atoh);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    a();
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_Amnv != null) {
      this.jdField_a_of_type_Amnv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp
 * JD-Core Version:    0.7.0.1
 */