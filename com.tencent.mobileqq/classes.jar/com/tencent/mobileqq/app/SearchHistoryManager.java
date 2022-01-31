package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class SearchHistoryManager
  implements Manager
{
  public static boolean a;
  private final int jdField_a_of_type_Int = 10000;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final int b = 10001;
  
  public SearchHistoryManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("search_keyword" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    paramString = localFriendsManager.c(paramString);
    if (paramString != null)
    {
      paramString = localFriendsManager.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_Boolean = true;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString("search_keyword" + paramQQAppInterface.getCurrentAccountUin(), paramString);
    localEditor.commit();
  }
  
  /* Error */
  public java.util.ArrayList a()
  {
    // Byte code:
    //   0: new 131	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 132	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: bipush 50
    //   15: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   18: checkcast 88	com/tencent/mobileqq/app/FriendsManager
    //   21: astore 8
    //   23: aload_0
    //   24: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: bipush 51
    //   29: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   32: checkcast 134	com/tencent/mobileqq/app/TroopManager
    //   35: astore 9
    //   37: aload_0
    //   38: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: bipush 10
    //   43: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   46: checkcast 136	com/tencent/mobileqq/app/PhoneContactManagerImp
    //   49: astore 10
    //   51: aload_0
    //   52: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   55: iconst_0
    //   56: ldc 138
    //   58: invokevirtual 143	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: ldc 145
    //   68: aconst_null
    //   69: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 6
    //   74: iconst_0
    //   75: istore_3
    //   76: aload 6
    //   78: ifnull +386 -> 464
    //   81: aload 6
    //   83: invokeinterface 155 1 0
    //   88: ifeq +376 -> 464
    //   91: new 138	com/tencent/mobileqq/data/SearchHistory
    //   94: dup
    //   95: invokespecial 156	com/tencent/mobileqq/data/SearchHistory:<init>	()V
    //   98: astore 11
    //   100: aload 11
    //   102: aload 6
    //   104: aload 6
    //   106: ldc 158
    //   108: invokeinterface 162 2 0
    //   113: invokeinterface 165 2 0
    //   118: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   121: aload 11
    //   123: aload 6
    //   125: aload 6
    //   127: ldc 169
    //   129: invokeinterface 162 2 0
    //   134: invokeinterface 165 2 0
    //   139: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   142: aload 11
    //   144: aload 6
    //   146: aload 6
    //   148: ldc 173
    //   150: invokeinterface 162 2 0
    //   155: invokeinterface 165 2 0
    //   160: putfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   163: aload 11
    //   165: aload 6
    //   167: aload 6
    //   169: ldc 177
    //   171: invokeinterface 162 2 0
    //   176: invokeinterface 165 2 0
    //   181: putfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   184: aload 11
    //   186: aload 6
    //   188: aload 6
    //   190: ldc 181
    //   192: invokeinterface 162 2 0
    //   197: invokeinterface 185 2 0
    //   202: putfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   205: aload 11
    //   207: aload 6
    //   209: aload 6
    //   211: ldc 189
    //   213: invokeinterface 162 2 0
    //   218: invokeinterface 165 2 0
    //   223: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   226: aload 11
    //   228: aload 6
    //   230: aload 6
    //   232: ldc 193
    //   234: invokeinterface 162 2 0
    //   239: invokeinterface 185 2 0
    //   244: putfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   247: aload 11
    //   249: aload 6
    //   251: aload 6
    //   253: ldc 197
    //   255: invokeinterface 162 2 0
    //   260: invokeinterface 201 2 0
    //   265: putfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   268: aload 11
    //   270: aload 6
    //   272: aload 6
    //   274: ldc 206
    //   276: invokeinterface 162 2 0
    //   281: invokeinterface 185 2 0
    //   286: i2l
    //   287: invokevirtual 210	com/tencent/mobileqq/data/SearchHistory:setId	(J)V
    //   290: iconst_0
    //   291: istore_2
    //   292: iconst_0
    //   293: istore 4
    //   295: iconst_0
    //   296: istore_1
    //   297: aload 11
    //   299: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   302: lookupswitch	default:+711->1013, 0:+177->479, 1:+324->626, 1000:+195->497, 1004:+195->497, 1008:+380->682, 1021:+733->1035, 3000:+342->644, 7220:+427->729, 56939:+567->869, 56940:+466->768, 56941:+517->819, 56942:+612->914
    //   409: ifeq +538 -> 947
    //   412: aload_0
    //   413: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   416: ldc 138
    //   418: aload 11
    //   420: getfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   423: invokevirtual 213	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   426: checkcast 138	com/tencent/mobileqq/data/SearchHistory
    //   429: astore 11
    //   431: aload 11
    //   433: ifnull +13 -> 446
    //   436: aload_0
    //   437: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   440: aload 11
    //   442: invokevirtual 216	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   445: pop
    //   446: iload_3
    //   447: iconst_1
    //   448: iadd
    //   449: istore_3
    //   450: aload 6
    //   452: invokeinterface 219 1 0
    //   457: istore 5
    //   459: iload 5
    //   461: ifne -370 -> 91
    //   464: aload 6
    //   466: ifnull +10 -> 476
    //   469: aload 6
    //   471: invokeinterface 222 1 0
    //   476: aload 7
    //   478: areturn
    //   479: aload 8
    //   481: aload 11
    //   483: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   486: invokevirtual 225	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   489: ifne +524 -> 1013
    //   492: iconst_1
    //   493: istore_1
    //   494: goto +521 -> 1015
    //   497: aload 8
    //   499: aload 11
    //   501: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   504: invokevirtual 225	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   507: ifeq +5 -> 512
    //   510: iconst_1
    //   511: istore_1
    //   512: aload 11
    //   514: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   517: sipush 1000
    //   520: if_icmpne +47 -> 567
    //   523: aload_0
    //   524: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   527: bipush 51
    //   529: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   532: checkcast 134	com/tencent/mobileqq/app/TroopManager
    //   535: astore 12
    //   537: iload_1
    //   538: istore_2
    //   539: aload 12
    //   541: aload 12
    //   543: aload 11
    //   545: getfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   548: invokevirtual 227	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   551: aload 11
    //   553: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   556: invokevirtual 230	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   559: ifnonnull +454 -> 1013
    //   562: iconst_1
    //   563: istore_1
    //   564: goto +451 -> 1015
    //   567: iload_1
    //   568: istore_2
    //   569: aload 11
    //   571: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   574: sipush 1004
    //   577: if_icmpne +436 -> 1013
    //   580: aload_0
    //   581: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   584: bipush 52
    //   586: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   589: checkcast 232	com/tencent/mobileqq/app/DiscussionManager
    //   592: aload 11
    //   594: getfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   597: invokevirtual 235	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   600: astore 12
    //   602: aload 12
    //   604: ifnull +421 -> 1025
    //   607: aload 12
    //   609: invokevirtual 240	com/tencent/mobileqq/data/DiscussionInfo:isDiscussHrMeeting	()Z
    //   612: ifne +413 -> 1025
    //   615: aload 12
    //   617: invokevirtual 243	com/tencent/mobileqq/data/DiscussionInfo:isHidden	()Z
    //   620: ifeq +407 -> 1027
    //   623: goto +402 -> 1025
    //   626: aload 9
    //   628: aload 11
    //   630: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   633: invokevirtual 246	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   636: ifnonnull +377 -> 1013
    //   639: iconst_1
    //   640: istore_1
    //   641: goto +374 -> 1015
    //   644: aload_0
    //   645: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   648: bipush 52
    //   650: invokevirtual 86	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   653: checkcast 232	com/tencent/mobileqq/app/DiscussionManager
    //   656: aload 11
    //   658: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   661: invokevirtual 235	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   664: astore 12
    //   666: aload 12
    //   668: ifnull +362 -> 1030
    //   671: aload 12
    //   673: invokevirtual 243	com/tencent/mobileqq/data/DiscussionInfo:isHidden	()Z
    //   676: ifeq +337 -> 1013
    //   679: goto +351 -> 1030
    //   682: aload 11
    //   684: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   687: getstatic 251	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   690: invokestatic 255	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   693: ifeq +347 -> 1040
    //   696: aload_0
    //   697: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   700: invokestatic 260	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   703: ifeq +6 -> 709
    //   706: goto +334 -> 1040
    //   709: aload 11
    //   711: aload_0
    //   712: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   715: invokestatic 263	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   718: invokestatic 268	com/tencent/biz/pubaccount/util/PublicAccountConfigUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   721: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   724: iconst_0
    //   725: istore_1
    //   726: goto +289 -> 1015
    //   729: aload_0
    //   730: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   733: invokestatic 260	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   736: ifeq +309 -> 1045
    //   739: invokestatic 271	cooperation/readinjoy/ReadInJoyHelper:h	()Z
    //   742: ifeq +6 -> 748
    //   745: goto +300 -> 1045
    //   748: aload 11
    //   750: aload_0
    //   751: getfield 23	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   754: invokestatic 263	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   757: invokestatic 273	com/tencent/biz/pubaccount/util/PublicAccountConfigUtil:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   760: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   763: iconst_0
    //   764: istore_1
    //   765: goto +250 -> 1015
    //   768: aload 10
    //   770: invokevirtual 276	com/tencent/mobileqq/app/PhoneContactManagerImp:g	()Z
    //   773: ifeq +8 -> 781
    //   776: iconst_1
    //   777: istore_1
    //   778: goto +237 -> 1015
    //   781: aload 10
    //   783: aload 11
    //   785: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   788: invokevirtual 279	com/tencent/mobileqq/app/PhoneContactManagerImp:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PhoneContact;
    //   791: astore 12
    //   793: aload 12
    //   795: ifnonnull +8 -> 803
    //   798: iconst_1
    //   799: istore_1
    //   800: goto +215 -> 1015
    //   803: aload 12
    //   805: getfield 282	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   808: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   811: ifeq +202 -> 1013
    //   814: iconst_1
    //   815: istore_1
    //   816: goto +199 -> 1015
    //   819: aload 10
    //   821: invokevirtual 276	com/tencent/mobileqq/app/PhoneContactManagerImp:g	()Z
    //   824: ifne +8 -> 832
    //   827: iconst_1
    //   828: istore_1
    //   829: goto +186 -> 1015
    //   832: aload 10
    //   834: aload 11
    //   836: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   839: invokevirtual 279	com/tencent/mobileqq/app/PhoneContactManagerImp:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PhoneContact;
    //   842: astore 12
    //   844: aload 12
    //   846: ifnull +204 -> 1050
    //   849: iload 4
    //   851: istore_1
    //   852: ldc_w 284
    //   855: aload 12
    //   857: getfield 282	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   860: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   863: ifne +189 -> 1052
    //   866: goto +184 -> 1050
    //   869: aload 10
    //   871: aload 11
    //   873: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   876: invokevirtual 279	com/tencent/mobileqq/app/PhoneContactManagerImp:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PhoneContact;
    //   879: astore 12
    //   881: aload 12
    //   883: ifnull +172 -> 1055
    //   886: aload 12
    //   888: getfield 282	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   891: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   894: ifne +161 -> 1055
    //   897: ldc_w 284
    //   900: aload 12
    //   902: getfield 282	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   905: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   908: ifeq +105 -> 1013
    //   911: goto +144 -> 1055
    //   914: aload 10
    //   916: aload 11
    //   918: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   921: invokevirtual 279	com/tencent/mobileqq/app/PhoneContactManagerImp:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PhoneContact;
    //   924: astore 12
    //   926: aload 12
    //   928: ifnull +85 -> 1013
    //   931: aload 12
    //   933: getfield 282	com/tencent/mobileqq/data/PhoneContact:uin	Ljava/lang/String;
    //   936: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   939: ifeq +121 -> 1060
    //   942: iconst_0
    //   943: istore_1
    //   944: goto +71 -> 1015
    //   947: iload_3
    //   948: iconst_3
    //   949: if_icmpge -503 -> 446
    //   952: aload 7
    //   954: aload 11
    //   956: invokevirtual 292	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   959: pop
    //   960: goto -514 -> 446
    //   963: astore 8
    //   965: aload 6
    //   967: ifnull -491 -> 476
    //   970: aload 6
    //   972: invokeinterface 222 1 0
    //   977: aload 7
    //   979: areturn
    //   980: astore 7
    //   982: aconst_null
    //   983: astore 6
    //   985: aload 6
    //   987: ifnull +10 -> 997
    //   990: aload 6
    //   992: invokeinterface 222 1 0
    //   997: aload 7
    //   999: athrow
    //   1000: astore 7
    //   1002: goto -17 -> 985
    //   1005: astore 6
    //   1007: aconst_null
    //   1008: astore 6
    //   1010: goto -45 -> 965
    //   1013: iload_2
    //   1014: istore_1
    //   1015: iload_3
    //   1016: iconst_3
    //   1017: if_icmplt -609 -> 408
    //   1020: iconst_1
    //   1021: istore_1
    //   1022: goto -614 -> 408
    //   1025: iconst_1
    //   1026: istore_1
    //   1027: goto -12 -> 1015
    //   1030: iconst_1
    //   1031: istore_1
    //   1032: goto -17 -> 1015
    //   1035: iconst_1
    //   1036: istore_1
    //   1037: goto -22 -> 1015
    //   1040: iconst_1
    //   1041: istore_1
    //   1042: goto -27 -> 1015
    //   1045: iconst_1
    //   1046: istore_1
    //   1047: goto -32 -> 1015
    //   1050: iconst_1
    //   1051: istore_1
    //   1052: goto -37 -> 1015
    //   1055: iconst_1
    //   1056: istore_1
    //   1057: goto -42 -> 1015
    //   1060: iconst_1
    //   1061: istore_1
    //   1062: goto -47 -> 1015
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1065	0	this	SearchHistoryManager
    //   296	766	1	i	int
    //   291	723	2	j	int
    //   75	943	3	k	int
    //   293	557	4	m	int
    //   457	3	5	bool	boolean
    //   72	919	6	localCursor	android.database.Cursor
    //   1005	1	6	localException1	java.lang.Exception
    //   1008	1	6	localObject1	Object
    //   7	971	7	localArrayList	java.util.ArrayList
    //   980	18	7	localObject2	Object
    //   1000	1	7	localObject3	Object
    //   21	477	8	localFriendsManager	FriendsManager
    //   963	1	8	localException2	java.lang.Exception
    //   35	592	9	localTroopManager	TroopManager
    //   49	866	10	localPhoneContactManagerImp	PhoneContactManagerImp
    //   98	857	11	localSearchHistory	SearchHistory
    //   535	397	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   81	91	963	java/lang/Exception
    //   91	290	963	java/lang/Exception
    //   297	408	963	java/lang/Exception
    //   412	431	963	java/lang/Exception
    //   436	446	963	java/lang/Exception
    //   450	459	963	java/lang/Exception
    //   479	492	963	java/lang/Exception
    //   497	510	963	java/lang/Exception
    //   512	537	963	java/lang/Exception
    //   539	562	963	java/lang/Exception
    //   569	602	963	java/lang/Exception
    //   607	615	963	java/lang/Exception
    //   615	623	963	java/lang/Exception
    //   626	639	963	java/lang/Exception
    //   644	666	963	java/lang/Exception
    //   671	679	963	java/lang/Exception
    //   682	706	963	java/lang/Exception
    //   709	724	963	java/lang/Exception
    //   729	745	963	java/lang/Exception
    //   748	763	963	java/lang/Exception
    //   768	776	963	java/lang/Exception
    //   781	793	963	java/lang/Exception
    //   803	814	963	java/lang/Exception
    //   819	827	963	java/lang/Exception
    //   832	844	963	java/lang/Exception
    //   852	866	963	java/lang/Exception
    //   869	881	963	java/lang/Exception
    //   886	897	963	java/lang/Exception
    //   897	911	963	java/lang/Exception
    //   914	926	963	java/lang/Exception
    //   931	942	963	java/lang/Exception
    //   952	960	963	java/lang/Exception
    //   51	74	980	finally
    //   81	91	1000	finally
    //   91	290	1000	finally
    //   297	408	1000	finally
    //   412	431	1000	finally
    //   436	446	1000	finally
    //   450	459	1000	finally
    //   479	492	1000	finally
    //   497	510	1000	finally
    //   512	537	1000	finally
    //   539	562	1000	finally
    //   569	602	1000	finally
    //   607	615	1000	finally
    //   615	623	1000	finally
    //   626	639	1000	finally
    //   644	666	1000	finally
    //   671	679	1000	finally
    //   682	706	1000	finally
    //   709	724	1000	finally
    //   729	745	1000	finally
    //   748	763	1000	finally
    //   768	776	1000	finally
    //   781	793	1000	finally
    //   803	814	1000	finally
    //   819	827	1000	finally
    //   832	844	1000	finally
    //   852	866	1000	finally
    //   869	881	1000	finally
    //   886	897	1000	finally
    //   897	911	1000	finally
    //   914	926	1000	finally
    //   931	942	1000	finally
    //   952	960	1000	finally
    //   51	74	1005	java/lang/Exception
  }
  
  /* Error */
  public void a(SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 299	java/lang/System:currentTimeMillis	()J
    //   9: putfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: lookupswitch	default:+124->140, 0:+125->141, 1:+270->286, 1000:+381->397, 1004:+418->434, 1006:+344->360, 1008:+492->508, 1021:+455->471, 3000:+307->323, 7220:+542->558, 56938:+344->360, 56939:+344->360, 56940:+344->360, 56941:+344->360, 56942:+344->360
    //   141: aload_1
    //   142: aload_0
    //   143: aload_1
    //   144: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   147: invokespecial 301	com/tencent/mobileqq/app/SearchHistoryManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   153: aload_1
    //   154: getfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   157: ifnonnull +10 -> 167
    //   160: aload_1
    //   161: ldc_w 303
    //   164: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   167: aload_1
    //   168: new 53	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   175: aload_1
    //   176: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   179: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: sipush 10001
    //   185: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   194: aload_0
    //   195: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   198: ldc 138
    //   200: aload_1
    //   201: getfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   204: invokevirtual 213	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   207: checkcast 138	com/tencent/mobileqq/data/SearchHistory
    //   210: astore_2
    //   211: aload_2
    //   212: ifnull +383 -> 595
    //   215: aload_2
    //   216: aload_1
    //   217: getfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   220: putfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   223: aload_2
    //   224: aload_2
    //   225: getfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   228: iconst_1
    //   229: iadd
    //   230: putfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   233: aload_2
    //   234: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   237: aload_1
    //   238: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   241: if_icmpeq +35 -> 276
    //   244: aload_2
    //   245: aload_1
    //   246: getfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   249: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   252: aload_2
    //   253: aload_1
    //   254: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   257: putfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   260: aload_2
    //   261: aload_1
    //   262: getfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   265: putfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   268: aload_2
    //   269: aload_1
    //   270: getfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   273: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   276: aload_0
    //   277: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   280: aload_2
    //   281: invokevirtual 305	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   284: pop
    //   285: return
    //   286: aload_1
    //   287: ldc_w 307
    //   290: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   293: aload_1
    //   294: new 53	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   301: aload_1
    //   302: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   305: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: sipush 10000
    //   311: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   320: goto -126 -> 194
    //   323: aload_1
    //   324: ldc_w 309
    //   327: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   330: aload_1
    //   331: new 53	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   338: aload_1
    //   339: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   342: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: sipush 10000
    //   348: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   357: goto -163 -> 194
    //   360: aload_1
    //   361: ldc_w 311
    //   364: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   367: aload_1
    //   368: new 53	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   375: aload_1
    //   376: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   379: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: sipush 10001
    //   385: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   394: goto -200 -> 194
    //   397: aload_1
    //   398: ldc_w 313
    //   401: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   404: aload_1
    //   405: new 53	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   412: aload_1
    //   413: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   416: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: sipush 10001
    //   422: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   431: goto -237 -> 194
    //   434: aload_1
    //   435: ldc_w 315
    //   438: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   441: aload_1
    //   442: new 53	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   449: aload_1
    //   450: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   453: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: sipush 10001
    //   459: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   468: goto -274 -> 194
    //   471: aload_1
    //   472: ldc_w 317
    //   475: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   478: aload_1
    //   479: new 53	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   486: aload_1
    //   487: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   490: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: sipush 10001
    //   496: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   505: goto -311 -> 194
    //   508: aload_1
    //   509: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   512: getstatic 251	com/tencent/mobileqq/app/AppConstants:as	Ljava/lang/String;
    //   515: invokestatic 255	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   518: ifeq -324 -> 194
    //   521: aload_1
    //   522: ldc_w 319
    //   525: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   528: aload_1
    //   529: new 53	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   536: aload_1
    //   537: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   540: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: sipush 10001
    //   546: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   555: goto -361 -> 194
    //   558: aload_1
    //   559: ldc_w 319
    //   562: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   565: aload_1
    //   566: new 53	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   573: aload_1
    //   574: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   577: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: sipush 10001
    //   583: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   586: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   592: goto -398 -> 194
    //   595: aload_0
    //   596: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   599: iconst_0
    //   600: ldc 138
    //   602: invokevirtual 143	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   605: aconst_null
    //   606: aconst_null
    //   607: aconst_null
    //   608: aconst_null
    //   609: aconst_null
    //   610: ldc_w 321
    //   613: aconst_null
    //   614: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   617: astore_3
    //   618: aload_3
    //   619: ifnull +173 -> 792
    //   622: aload_3
    //   623: astore_2
    //   624: iconst_3
    //   625: aload_3
    //   626: invokeinterface 325 1 0
    //   631: if_icmpgt +161 -> 792
    //   634: aload_3
    //   635: astore_2
    //   636: aload_3
    //   637: invokeinterface 155 1 0
    //   642: ifeq +139 -> 781
    //   645: aload_3
    //   646: astore_2
    //   647: aload_3
    //   648: aload_3
    //   649: ldc 158
    //   651: invokeinterface 162 2 0
    //   656: invokeinterface 165 2 0
    //   661: astore 4
    //   663: aload_3
    //   664: astore_2
    //   665: aload_0
    //   666: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   669: ldc 138
    //   671: aload 4
    //   673: invokevirtual 213	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   676: checkcast 138	com/tencent/mobileqq/data/SearchHistory
    //   679: astore 4
    //   681: aload_3
    //   682: astore_2
    //   683: aload 4
    //   685: aload_1
    //   686: getfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   689: putfield 167	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   692: aload_3
    //   693: astore_2
    //   694: aload 4
    //   696: aload_1
    //   697: getfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   700: putfield 175	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   703: aload_3
    //   704: astore_2
    //   705: aload 4
    //   707: aload_1
    //   708: getfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   711: putfield 179	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   714: aload_3
    //   715: astore_2
    //   716: aload 4
    //   718: aload_1
    //   719: getfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   722: putfield 204	com/tencent/mobileqq/data/SearchHistory:time	J
    //   725: aload_3
    //   726: astore_2
    //   727: aload 4
    //   729: aload_1
    //   730: getfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   733: putfield 171	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   736: aload_3
    //   737: astore_2
    //   738: aload 4
    //   740: aload_1
    //   741: getfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   744: putfield 187	com/tencent/mobileqq/data/SearchHistory:type	I
    //   747: aload_3
    //   748: astore_2
    //   749: aload 4
    //   751: aload_1
    //   752: getfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   755: putfield 195	com/tencent/mobileqq/data/SearchHistory:count	I
    //   758: aload_3
    //   759: astore_2
    //   760: aload 4
    //   762: aload_1
    //   763: getfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   766: putfield 191	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   769: aload_3
    //   770: astore_2
    //   771: aload_0
    //   772: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   775: aload 4
    //   777: invokevirtual 305	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   780: pop
    //   781: aload_3
    //   782: ifnull -642 -> 140
    //   785: aload_3
    //   786: invokeinterface 222 1 0
    //   791: return
    //   792: aload_3
    //   793: astore_2
    //   794: aload_0
    //   795: getfield 37	com/tencent/mobileqq/app/SearchHistoryManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   798: aload_1
    //   799: invokevirtual 328	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   802: goto -21 -> 781
    //   805: astore_1
    //   806: aload_3
    //   807: astore_2
    //   808: aload_1
    //   809: invokevirtual 331	java/lang/Exception:printStackTrace	()V
    //   812: aload_3
    //   813: ifnull -673 -> 140
    //   816: aload_3
    //   817: invokeinterface 222 1 0
    //   822: return
    //   823: astore_1
    //   824: aconst_null
    //   825: astore_2
    //   826: aload_2
    //   827: ifnull +9 -> 836
    //   830: aload_2
    //   831: invokeinterface 222 1 0
    //   836: aload_1
    //   837: athrow
    //   838: astore_1
    //   839: goto -13 -> 826
    //   842: astore_1
    //   843: aconst_null
    //   844: astore_3
    //   845: goto -39 -> 806
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	848	0	this	SearchHistoryManager
    //   0	848	1	paramSearchHistory	SearchHistory
    //   210	621	2	localObject1	Object
    //   617	228	3	localCursor	android.database.Cursor
    //   661	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   624	634	805	java/lang/Exception
    //   636	645	805	java/lang/Exception
    //   647	663	805	java/lang/Exception
    //   665	681	805	java/lang/Exception
    //   683	692	805	java/lang/Exception
    //   694	703	805	java/lang/Exception
    //   705	714	805	java/lang/Exception
    //   716	725	805	java/lang/Exception
    //   727	736	805	java/lang/Exception
    //   738	747	805	java/lang/Exception
    //   749	758	805	java/lang/Exception
    //   760	769	805	java/lang/Exception
    //   771	781	805	java/lang/Exception
    //   794	802	805	java/lang/Exception
    //   595	618	823	finally
    //   624	634	838	finally
    //   636	645	838	finally
    //   647	663	838	finally
    //   665	681	838	finally
    //   683	692	838	finally
    //   694	703	838	finally
    //   705	714	838	finally
    //   716	725	838	finally
    //   727	736	838	finally
    //   738	747	838	finally
    //   749	758	838	finally
    //   760	769	838	finally
    //   771	781	838	finally
    //   794	802	838	finally
    //   808	812	838	finally
    //   595	618	842	java/lang/Exception
  }
  
  public boolean a(SearchHistory paramSearchHistory)
  {
    boolean bool = false;
    if (paramSearchHistory != null)
    {
      paramSearchHistory.setStatus(1001);
      bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramSearchHistory);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */