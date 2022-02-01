import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class bfyp
{
  public static final String a;
  public static final String b;
  public int a;
  public long a;
  private bfyq jdField_a_of_type_Bfyq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBatchAddFriendMgr jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr;
  public List<String> a;
  public volatile int b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131712296);
    jdField_b_of_type_JavaLangString = anni.a(2131712300);
  }
  
  public bfyp(QQAppInterface paramQQAppInterface, String paramString, int paramInt, bfyq parambfyq, List<String> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bfyq = parambfyq;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  public static int a(String paramString)
  {
    if ("newJoin".equalsIgnoreCase(paramString)) {
      return 1;
    }
    if ("activeUser".equalsIgnoreCase(paramString)) {
      return 2;
    }
    if ("highFreqInteract".equalsIgnoreCase(paramString)) {
      return 3;
    }
    if ("newMember".equalsIgnoreCase(paramString)) {
      return 4;
    }
    if ("atMeOrReplyMe".equalsIgnoreCase(paramString)) {
      return 5;
    }
    return 0;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "newJoin";
    case 2: 
      return "activeUser";
    case 3: 
      return "highFreqInteract";
    case 4: 
      return "newMember";
    }
    return "atMeOrReplyMe";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    if (!TextUtils.isEmpty(paramTroopMemberInfo.recommendRemark)) {
      return paramTroopMemberInfo.recommendRemark;
    }
    if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick)) {
      return paramTroopMemberInfo.troopnick;
    }
    if (!TextUtils.isEmpty(paramTroopMemberInfo.friendnick)) {
      return paramTroopMemberInfo.friendnick;
    }
    return paramTroopMemberInfo.memberuin;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("-");
    if (paramString.length > paramInt) {
      return paramString[paramInt];
    }
    return "";
  }
  
  public static String a(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      if (paramBoolean) {
        return "greyTips_exp";
      }
      return "greyTips_clk";
    case 2: 
      if (paramBoolean) {
        return "greyTips_exp_1";
      }
      return "greyTips_clk_1";
    case 3: 
      if (paramBoolean) {
        return "greyTips_exp_2";
      }
      return "greyTips_clk_2";
    case 4: 
      if (paramBoolean) {
        return "greyTips_exp_3";
      }
      return "greyTips_clk_3";
    }
    if (paramBoolean) {
      return "greyTips_exp_4";
    }
    return "greyTips_clk_4";
  }
  
  /* Error */
  public static List<TroopMemberInfo> a(QQAppInterface paramQQAppInterface, String paramString, List<String> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 134	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 135	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: bipush 51
    //   12: invokevirtual 141	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15: checkcast 143	anmw
    //   18: astore 12
    //   20: aload_0
    //   21: bipush 52
    //   23: invokevirtual 141	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   26: checkcast 145	com/tencent/mobileqq/app/TroopManager
    //   29: aload_1
    //   30: invokevirtual 148	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   33: astore 11
    //   35: aload 11
    //   37: ifnonnull +6 -> 43
    //   40: aload 10
    //   42: areturn
    //   43: aconst_null
    //   44: astore 9
    //   46: iload_3
    //   47: ifeq +7 -> 54
    //   50: ldc 150
    //   52: astore 9
    //   54: aload_0
    //   55: invokevirtual 154	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   58: astore 14
    //   60: invokestatic 159	android/os/SystemClock:elapsedRealtime	()J
    //   63: lstore 7
    //   65: aload_0
    //   66: invokevirtual 162	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   69: invokevirtual 168	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   72: astore 13
    //   74: ldc 83
    //   76: invokevirtual 173	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   79: astore 15
    //   81: iconst_5
    //   82: anewarray 66	java/lang/String
    //   85: astore 16
    //   87: aload 16
    //   89: iconst_0
    //   90: ldc 174
    //   92: aastore
    //   93: aload 16
    //   95: iconst_1
    //   96: ldc 176
    //   98: aastore
    //   99: aload 16
    //   101: iconst_2
    //   102: ldc 177
    //   104: aastore
    //   105: aload 16
    //   107: iconst_3
    //   108: ldc 178
    //   110: aastore
    //   111: aload 16
    //   113: iconst_4
    //   114: ldc 179
    //   116: aastore
    //   117: aload_2
    //   118: ifnull +683 -> 801
    //   121: aload_2
    //   122: invokeinterface 185 1 0
    //   127: ifle +674 -> 801
    //   130: new 187	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   137: ldc 190
    //   139: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 196
    //   144: aload_2
    //   145: invokeinterface 185 1 0
    //   150: ldc 198
    //   152: invokestatic 204	java/util/Collections:nCopies	(ILjava/lang/Object;)Ljava/util/List;
    //   155: invokestatic 208	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   158: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 210
    //   163: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore 17
    //   171: aload_2
    //   172: invokeinterface 185 1 0
    //   177: iconst_1
    //   178: iadd
    //   179: anewarray 66	java/lang/String
    //   182: astore 18
    //   184: aload 18
    //   186: iconst_0
    //   187: aload_1
    //   188: aastore
    //   189: iconst_0
    //   190: istore 4
    //   192: iload 4
    //   194: aload_2
    //   195: invokeinterface 185 1 0
    //   200: if_icmpge +30 -> 230
    //   203: aload 18
    //   205: iload 4
    //   207: iconst_1
    //   208: iadd
    //   209: aload_2
    //   210: iload 4
    //   212: invokeinterface 217 2 0
    //   217: checkcast 66	java/lang/String
    //   220: aastore
    //   221: iload 4
    //   223: iconst_1
    //   224: iadd
    //   225: istore 4
    //   227: goto -35 -> 192
    //   230: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +38 -> 271
    //   236: ldc 225
    //   238: iconst_2
    //   239: new 187	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   246: ldc 227
    //   248: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 17
    //   253: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc 229
    //   258: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_2
    //   262: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload 13
    //   273: iconst_1
    //   274: aload 15
    //   276: aload 16
    //   278: aload 17
    //   280: aload 18
    //   282: aconst_null
    //   283: aconst_null
    //   284: aload 9
    //   286: aconst_null
    //   287: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   290: astore_1
    //   291: aload_1
    //   292: ifnull +690 -> 982
    //   295: aload_1
    //   296: astore_2
    //   297: aload_1
    //   298: invokeinterface 247 1 0
    //   303: istore_3
    //   304: iload_3
    //   305: ifeq +677 -> 982
    //   308: iconst_0
    //   309: istore 4
    //   311: aload_1
    //   312: astore_2
    //   313: iload 4
    //   315: istore 5
    //   317: aload_1
    //   318: astore 9
    //   320: new 83	com/tencent/mobileqq/data/TroopMemberInfo
    //   323: dup
    //   324: invokespecial 248	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   327: astore 15
    //   329: aload_1
    //   330: astore_2
    //   331: iload 4
    //   333: istore 5
    //   335: aload_1
    //   336: astore 9
    //   338: aload 15
    //   340: aload_1
    //   341: iconst_0
    //   342: invokeinterface 251 2 0
    //   347: putfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   350: aload_1
    //   351: astore_2
    //   352: iload 4
    //   354: istore 5
    //   356: aload_1
    //   357: astore 9
    //   359: aload 15
    //   361: aload_1
    //   362: iconst_1
    //   363: invokeinterface 254 2 0
    //   368: putfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   371: aload_1
    //   372: astore_2
    //   373: iload 4
    //   375: istore 5
    //   377: aload_1
    //   378: astore 9
    //   380: aload 15
    //   382: aload_1
    //   383: iconst_2
    //   384: invokeinterface 251 2 0
    //   389: putfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   392: aload_1
    //   393: astore_2
    //   394: iload 4
    //   396: istore 5
    //   398: aload_1
    //   399: astore 9
    //   401: aload 15
    //   403: aload_1
    //   404: iconst_3
    //   405: invokeinterface 251 2 0
    //   410: putfield 95	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   413: aload_1
    //   414: astore_2
    //   415: iload 4
    //   417: istore 5
    //   419: aload_1
    //   420: astore 9
    //   422: aload 15
    //   424: aload_1
    //   425: iconst_4
    //   426: invokeinterface 251 2 0
    //   431: putfield 98	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   434: aload_1
    //   435: astore_2
    //   436: iload 4
    //   438: istore 5
    //   440: aload_1
    //   441: astore 9
    //   443: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +75 -> 521
    //   449: aload_1
    //   450: astore_2
    //   451: iload 4
    //   453: istore 5
    //   455: aload_1
    //   456: astore 9
    //   458: ldc 225
    //   460: iconst_2
    //   461: new 187	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   468: ldc_w 258
    //   471: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload 15
    //   476: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   479: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: ldc_w 260
    //   485: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 15
    //   490: getfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   493: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: ldc_w 265
    //   499: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload 12
    //   504: aload 15
    //   506: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   509: invokevirtual 267	anmw:b	(Ljava/lang/String;)Z
    //   512: invokevirtual 270	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   515: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload_1
    //   522: astore_2
    //   523: iload 4
    //   525: istore 5
    //   527: aload_1
    //   528: astore 9
    //   530: aload 12
    //   532: aload 15
    //   534: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   537: invokevirtual 267	anmw:b	(Ljava/lang/String;)Z
    //   540: ifne +85 -> 625
    //   543: aload_1
    //   544: astore_2
    //   545: iload 4
    //   547: istore 5
    //   549: aload_1
    //   550: astore 9
    //   552: aload 15
    //   554: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   557: invokestatic 274	bgjw:d	(Ljava/lang/String;)Z
    //   560: ifeq +65 -> 625
    //   563: aload_1
    //   564: astore_2
    //   565: iload 4
    //   567: istore 5
    //   569: aload_1
    //   570: astore 9
    //   572: aload 15
    //   574: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   577: aload 14
    //   579: invokestatic 278	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   582: ifne +43 -> 625
    //   585: aload_1
    //   586: astore_2
    //   587: iload 4
    //   589: istore 5
    //   591: aload_1
    //   592: astore 9
    //   594: aload_0
    //   595: aload 15
    //   597: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   600: invokestatic 283	bfpx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   603: ifne +22 -> 625
    //   606: aload_1
    //   607: astore_2
    //   608: iload 4
    //   610: istore 5
    //   612: aload_1
    //   613: astore 9
    //   615: aload 10
    //   617: aload 15
    //   619: invokeinterface 287 2 0
    //   624: pop
    //   625: iload 4
    //   627: iconst_1
    //   628: iadd
    //   629: istore 6
    //   631: iload 6
    //   633: istore 4
    //   635: aload_1
    //   636: astore_2
    //   637: iload 6
    //   639: istore 5
    //   641: aload_1
    //   642: astore 9
    //   644: aload_1
    //   645: invokeinterface 290 1 0
    //   650: ifne -339 -> 311
    //   653: aload_1
    //   654: astore_2
    //   655: iload 6
    //   657: istore 5
    //   659: aload_1
    //   660: astore 9
    //   662: aload_1
    //   663: invokeinterface 293 1 0
    //   668: aconst_null
    //   669: astore_1
    //   670: iload 6
    //   672: istore 4
    //   674: aload_1
    //   675: astore_2
    //   676: iload 4
    //   678: istore 5
    //   680: aload_1
    //   681: astore 9
    //   683: aload 13
    //   685: invokevirtual 294	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   688: aload_1
    //   689: astore_2
    //   690: iload 4
    //   692: istore 5
    //   694: aload_1
    //   695: astore 9
    //   697: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   700: ifeq +43 -> 743
    //   703: aload_1
    //   704: astore_2
    //   705: iload 4
    //   707: istore 5
    //   709: aload_1
    //   710: astore 9
    //   712: ldc 225
    //   714: iconst_2
    //   715: invokestatic 300	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   718: ldc_w 302
    //   721: iconst_1
    //   722: anewarray 4	java/lang/Object
    //   725: dup
    //   726: iconst_0
    //   727: invokestatic 159	android/os/SystemClock:elapsedRealtime	()J
    //   730: lload 7
    //   732: lsub
    //   733: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   736: aastore
    //   737: invokestatic 312	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   740: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   743: aload_1
    //   744: ifnull +235 -> 979
    //   747: aload_1
    //   748: invokeinterface 293 1 0
    //   753: ldc 225
    //   755: iconst_1
    //   756: ldc_w 314
    //   759: iconst_3
    //   760: anewarray 4	java/lang/Object
    //   763: dup
    //   764: iconst_0
    //   765: aload 11
    //   767: getfield 319	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   770: aastore
    //   771: dup
    //   772: iconst_1
    //   773: aload 10
    //   775: invokeinterface 185 1 0
    //   780: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   783: aastore
    //   784: dup
    //   785: iconst_2
    //   786: iload 4
    //   788: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   791: aastore
    //   792: invokestatic 327	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   795: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: aload 10
    //   800: areturn
    //   801: aload 13
    //   803: iconst_1
    //   804: aload 15
    //   806: aload 16
    //   808: ldc_w 329
    //   811: iconst_1
    //   812: anewarray 66	java/lang/String
    //   815: dup
    //   816: iconst_0
    //   817: aload_1
    //   818: aastore
    //   819: aconst_null
    //   820: aconst_null
    //   821: aload 9
    //   823: aconst_null
    //   824: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   827: astore_1
    //   828: goto -537 -> 291
    //   831: astore_0
    //   832: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq +13 -> 848
    //   838: ldc 225
    //   840: iconst_2
    //   841: ldc_w 331
    //   844: aload_0
    //   845: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   848: goto -95 -> 753
    //   851: astore_0
    //   852: aconst_null
    //   853: astore_1
    //   854: iconst_0
    //   855: istore 5
    //   857: aload_1
    //   858: astore_2
    //   859: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   862: ifeq +15 -> 877
    //   865: aload_1
    //   866: astore_2
    //   867: ldc 225
    //   869: iconst_2
    //   870: ldc_w 331
    //   873: aload_0
    //   874: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   877: iload 5
    //   879: istore 4
    //   881: aload_1
    //   882: ifnull -129 -> 753
    //   885: aload_1
    //   886: invokeinterface 293 1 0
    //   891: iload 5
    //   893: istore 4
    //   895: goto -142 -> 753
    //   898: astore_0
    //   899: iload 5
    //   901: istore 4
    //   903: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   906: ifeq -153 -> 753
    //   909: ldc 225
    //   911: iconst_2
    //   912: ldc_w 331
    //   915: aload_0
    //   916: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   919: iload 5
    //   921: istore 4
    //   923: goto -170 -> 753
    //   926: astore_0
    //   927: aconst_null
    //   928: astore_2
    //   929: aload_2
    //   930: ifnull +9 -> 939
    //   933: aload_2
    //   934: invokeinterface 293 1 0
    //   939: aload_0
    //   940: athrow
    //   941: astore_1
    //   942: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   945: ifeq -6 -> 939
    //   948: ldc 225
    //   950: iconst_2
    //   951: ldc_w 331
    //   954: aload_1
    //   955: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   958: goto -19 -> 939
    //   961: astore_0
    //   962: goto -33 -> 929
    //   965: astore_0
    //   966: iconst_0
    //   967: istore 5
    //   969: goto -112 -> 857
    //   972: astore_0
    //   973: aload 9
    //   975: astore_1
    //   976: goto -119 -> 857
    //   979: goto -226 -> 753
    //   982: iconst_0
    //   983: istore 4
    //   985: goto -311 -> 674
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	988	0	paramQQAppInterface	QQAppInterface
    //   0	988	1	paramString	String
    //   0	988	2	paramList	List<String>
    //   0	988	3	paramBoolean	boolean
    //   190	794	4	i	int
    //   315	653	5	j	int
    //   629	42	6	k	int
    //   63	668	7	l	long
    //   44	930	9	str1	String
    //   7	792	10	localArrayList	ArrayList
    //   33	733	11	localTroopInfo	TroopInfo
    //   18	513	12	localanmw	anmw
    //   72	730	13	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   58	520	14	str2	String
    //   79	726	15	localObject	Object
    //   85	722	16	arrayOfString1	String[]
    //   169	110	17	str3	String
    //   182	99	18	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   747	753	831	java/lang/Throwable
    //   60	87	851	java/lang/Throwable
    //   121	184	851	java/lang/Throwable
    //   192	221	851	java/lang/Throwable
    //   230	271	851	java/lang/Throwable
    //   271	291	851	java/lang/Throwable
    //   801	828	851	java/lang/Throwable
    //   885	891	898	java/lang/Throwable
    //   60	87	926	finally
    //   121	184	926	finally
    //   192	221	926	finally
    //   230	271	926	finally
    //   271	291	926	finally
    //   801	828	926	finally
    //   933	939	941	java/lang/Throwable
    //   297	304	961	finally
    //   320	329	961	finally
    //   338	350	961	finally
    //   359	371	961	finally
    //   380	392	961	finally
    //   401	413	961	finally
    //   422	434	961	finally
    //   443	449	961	finally
    //   458	521	961	finally
    //   530	543	961	finally
    //   552	563	961	finally
    //   572	585	961	finally
    //   594	606	961	finally
    //   615	625	961	finally
    //   644	653	961	finally
    //   662	668	961	finally
    //   683	688	961	finally
    //   697	703	961	finally
    //   712	743	961	finally
    //   859	865	961	finally
    //   867	877	961	finally
    //   297	304	965	java/lang/Throwable
    //   320	329	972	java/lang/Throwable
    //   338	350	972	java/lang/Throwable
    //   359	371	972	java/lang/Throwable
    //   380	392	972	java/lang/Throwable
    //   401	413	972	java/lang/Throwable
    //   422	434	972	java/lang/Throwable
    //   443	449	972	java/lang/Throwable
    //   458	521	972	java/lang/Throwable
    //   530	543	972	java/lang/Throwable
    //   552	563	972	java/lang/Throwable
    //   572	585	972	java/lang/Throwable
    //   594	606	972	java/lang/Throwable
    //   615	625	972	java/lang/Throwable
    //   644	653	972	java/lang/Throwable
    //   662	668	972	java/lang/Throwable
    //   683	688	972	java/lang/Throwable
    //   697	703	972	java/lang/Throwable
    //   712	743	972	java/lang/Throwable
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, bfyp parambfyp)
  {
    Object localObject = a(paramQQAppInterface, parambfyp.jdField_c_of_type_JavaLangString);
    if (localObject == null) {}
    int j;
    int k;
    do
    {
      return;
      i = ((Integer)localObject[0]).intValue();
      int m = ((Integer)localObject[1]).intValue();
      j = ((Integer)localObject[2]).intValue();
      paramTroopInfo = (String)localObject[3];
      localObject = (String)localObject[4];
      bajc localbajc = ((TroopManager)paramQQAppInterface.getManager(52)).a();
      int n = (int)(localbajc.jdField_a_of_type_Float * i);
      k = (int)(localbajc.jdField_b_of_type_Float * i);
      if ((m >= n) && (j >= k) && (j > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("troopBatchAddFrd.Scene", 1, String.format("doInsertGrayTip_V1 check nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b_%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool), parambfyp.jdField_c_of_type_JavaLangString }));
        if (!bool) {
          break;
        }
        baja.a(paramQQAppInterface, parambfyp.jdField_c_of_type_JavaLangString, m, j, paramTroopInfo, (String)localObject);
        return;
      }
      if ((m < n) && (i != 0))
      {
        paramTroopInfo = String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf(m / i) });
        m = paramTroopInfo.length();
        bcst.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, parambfyp.jdField_c_of_type_JavaLangString, "", paramTroopInfo.substring(0, m - 1), "");
      }
    } while ((j >= k) || (i == 0));
    paramTroopInfo = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(j / i) });
    int i = paramTroopInfo.length();
    bcst.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, parambfyp.jdField_c_of_type_JavaLangString, "", paramTroopInfo.substring(0, i - 1), "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    long l = localSharedPreferences.getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramQQAppInterface.getCurrentAccountUin(), paramTroopInfo.troopuin }), 0L);
    if ((l > 0L) && (l - System.currentTimeMillis() > 86400000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, String.format("dealWithOldTip force_troopUin_invalid=%b_%s_%b seq1_seq2=%d_%d", new Object[] { Boolean.valueOf(paramBoolean), paramTroopInfo.troopuin, Boolean.valueOf(bool), Long.valueOf(paramTroopInfo.dwLastBAFTipMsgUniSeq), Long.valueOf(paramTroopInfo.dwLastBAFTipMsgUniSeq2) }));
      }
      if ((bool) || (paramBoolean))
      {
        int i = 0;
        if (paramTroopInfo.dwLastBAFTipMsgUniSeq != 0L)
        {
          paramQQAppInterface.a().b(paramTroopInfo.troopuin, 1, paramTroopInfo.dwLastBAFTipMsgUniSeq);
          paramTroopInfo.dwLastBAFTipMsgUniSeq = 0L;
          i = 1;
        }
        if (paramTroopInfo.dwLastBAFTipMsgUniSeq2 != 0L)
        {
          paramQQAppInterface.a().b(paramTroopInfo.troopuin, 1, paramTroopInfo.dwLastBAFTipMsgUniSeq2);
          paramTroopInfo.dwLastBAFTipMsgUniSeq2 = 0L;
          i = 1;
        }
        if (i != 0) {
          ((TroopManager)paramQQAppInterface.getManager(52)).b(paramTroopInfo);
        }
        if (bool)
        {
          paramQQAppInterface = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", paramQQAppInterface.getCurrentAccountUin(), paramTroopInfo.troopuin });
          localSharedPreferences.edit().putInt(paramQQAppInterface, 0).apply();
        }
      }
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 6);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1) {}
    for (boolean bool = b(paramQQAppInterface, paramString, paramInt);; bool = c(paramQQAppInterface, paramString, paramInt))
    {
      if (QLog.isColorLevel()) {}
      return bool;
    }
  }
  
  /* Error */
  public static Object[] a(com.tencent.common.app.AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 51
    //   3: invokevirtual 466	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6: checkcast 143	anmw
    //   9: astore 17
    //   11: aload_0
    //   12: bipush 52
    //   14: invokevirtual 466	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   17: checkcast 145	com/tencent/mobileqq/app/TroopManager
    //   20: aload_1
    //   21: invokevirtual 148	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   24: astore 20
    //   26: aload 20
    //   28: ifnonnull +34 -> 62
    //   31: invokestatic 469	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   34: ifeq +26 -> 60
    //   37: ldc 225
    //   39: iconst_4
    //   40: invokestatic 300	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   43: ldc_w 471
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: invokestatic 312	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aconst_null
    //   61: areturn
    //   62: aload_0
    //   63: invokevirtual 472	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   66: astore 19
    //   68: aload_0
    //   69: sipush 203
    //   72: invokevirtual 466	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   75: checkcast 474	bftx
    //   78: astore 21
    //   80: invokestatic 159	android/os/SystemClock:elapsedRealtime	()J
    //   83: lstore 9
    //   85: aload_0
    //   86: invokevirtual 478	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   89: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   92: astore 18
    //   94: aload 18
    //   96: iconst_1
    //   97: ldc 83
    //   99: invokevirtual 173	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   102: iconst_5
    //   103: anewarray 66	java/lang/String
    //   106: dup
    //   107: iconst_0
    //   108: ldc 174
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: ldc 176
    //   115: aastore
    //   116: dup
    //   117: iconst_2
    //   118: ldc 177
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: ldc 178
    //   125: aastore
    //   126: dup
    //   127: iconst_4
    //   128: ldc 179
    //   130: aastore
    //   131: ldc_w 329
    //   134: iconst_1
    //   135: anewarray 66	java/lang/String
    //   138: dup
    //   139: iconst_0
    //   140: aload_1
    //   141: aastore
    //   142: aconst_null
    //   143: aconst_null
    //   144: ldc 150
    //   146: aconst_null
    //   147: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   150: astore 12
    //   152: aload 12
    //   154: ifnull +1542 -> 1696
    //   157: aload 12
    //   159: invokeinterface 247 1 0
    //   164: istore 11
    //   166: iload 11
    //   168: ifeq +1528 -> 1696
    //   171: aconst_null
    //   172: astore 16
    //   174: aconst_null
    //   175: astore 14
    //   177: aconst_null
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_0
    //   181: iconst_0
    //   182: istore_3
    //   183: iconst_0
    //   184: istore 5
    //   186: iconst_0
    //   187: istore_2
    //   188: iload_3
    //   189: istore 7
    //   191: iload 5
    //   193: istore 6
    //   195: new 83	com/tencent/mobileqq/data/TroopMemberInfo
    //   198: dup
    //   199: invokespecial 248	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   202: astore 13
    //   204: iload_3
    //   205: istore 7
    //   207: iload 5
    //   209: istore 6
    //   211: aload 13
    //   213: aload 12
    //   215: iconst_0
    //   216: invokeinterface 251 2 0
    //   221: putfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   224: iload_3
    //   225: istore 7
    //   227: iload 5
    //   229: istore 6
    //   231: aload 13
    //   233: aload 12
    //   235: iconst_1
    //   236: invokeinterface 254 2 0
    //   241: putfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   244: iload_3
    //   245: istore 7
    //   247: iload 5
    //   249: istore 6
    //   251: aload 13
    //   253: aload 12
    //   255: iconst_2
    //   256: invokeinterface 251 2 0
    //   261: putfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   264: iload_3
    //   265: istore 7
    //   267: iload 5
    //   269: istore 6
    //   271: aload 13
    //   273: aload 12
    //   275: iconst_3
    //   276: invokeinterface 251 2 0
    //   281: putfield 95	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   284: iload_3
    //   285: istore 7
    //   287: iload 5
    //   289: istore 6
    //   291: aload 13
    //   293: aload 12
    //   295: iconst_4
    //   296: invokeinterface 251 2 0
    //   301: putfield 98	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   304: iload_3
    //   305: istore 7
    //   307: iload 5
    //   309: istore 6
    //   311: aload 13
    //   313: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   316: invokestatic 274	bgjw:d	(Ljava/lang/String;)Z
    //   319: ifeq +70 -> 389
    //   322: iload_3
    //   323: istore 7
    //   325: iload 5
    //   327: istore 6
    //   329: aload 13
    //   331: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   334: invokestatic 483	bgjw:c	(Ljava/lang/String;)Z
    //   337: ifne +52 -> 389
    //   340: iload_3
    //   341: istore 7
    //   343: iload 5
    //   345: istore 6
    //   347: aload 13
    //   349: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   352: aload 19
    //   354: invokestatic 278	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   357: ifne +32 -> 389
    //   360: aload 21
    //   362: ifnull +290 -> 652
    //   365: iload_3
    //   366: istore 7
    //   368: iload 5
    //   370: istore 6
    //   372: aload 21
    //   374: aload 13
    //   376: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   379: invokevirtual 484	bftx:b	(Ljava/lang/String;)Z
    //   382: istore 11
    //   384: iload 11
    //   386: ifeq +266 -> 652
    //   389: aload_1
    //   390: astore 15
    //   392: iload_3
    //   393: istore 6
    //   395: iload 5
    //   397: istore_3
    //   398: iload_2
    //   399: iconst_1
    //   400: iadd
    //   401: istore 4
    //   403: iload 6
    //   405: istore_2
    //   406: aload_0
    //   407: astore_1
    //   408: aload 16
    //   410: astore 13
    //   412: aload 15
    //   414: astore_0
    //   415: aload 12
    //   417: invokeinterface 290 1 0
    //   422: ifne +1251 -> 1673
    //   425: aload 12
    //   427: invokeinterface 293 1 0
    //   432: aconst_null
    //   433: astore 15
    //   435: aload_0
    //   436: astore 16
    //   438: aload 13
    //   440: astore 12
    //   442: aload 15
    //   444: astore_0
    //   445: aload_0
    //   446: astore 17
    //   448: aload 18
    //   450: invokevirtual 294	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   453: aload_0
    //   454: astore 17
    //   456: invokestatic 469	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   459: ifeq +37 -> 496
    //   462: aload_0
    //   463: astore 17
    //   465: ldc 225
    //   467: iconst_4
    //   468: invokestatic 300	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   471: ldc_w 486
    //   474: iconst_1
    //   475: anewarray 4	java/lang/Object
    //   478: dup
    //   479: iconst_0
    //   480: invokestatic 159	android/os/SystemClock:elapsedRealtime	()J
    //   483: lload 9
    //   485: lsub
    //   486: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   489: aastore
    //   490: invokestatic 312	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   493: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload 12
    //   498: astore 18
    //   500: aload 14
    //   502: astore 15
    //   504: aload 16
    //   506: astore 19
    //   508: aload_1
    //   509: astore 17
    //   511: iload_2
    //   512: istore 5
    //   514: iload_3
    //   515: istore 6
    //   517: iload 4
    //   519: istore 7
    //   521: aload_0
    //   522: ifnull +34 -> 556
    //   525: aload_0
    //   526: invokeinterface 293 1 0
    //   531: iload 4
    //   533: istore 7
    //   535: iload_3
    //   536: istore 6
    //   538: iload_2
    //   539: istore 5
    //   541: aload_1
    //   542: astore 17
    //   544: aload 16
    //   546: astore 19
    //   548: aload 14
    //   550: astore 15
    //   552: aload 12
    //   554: astore 18
    //   556: aload 18
    //   558: ifnull +659 -> 1217
    //   561: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +33 -> 597
    //   567: ldc 225
    //   569: iconst_2
    //   570: new 187	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 488
    //   580: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 18
    //   585: getfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   588: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: aload 18
    //   599: getfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   602: astore_1
    //   603: aload 18
    //   605: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   608: astore_0
    //   609: iconst_5
    //   610: anewarray 4	java/lang/Object
    //   613: dup
    //   614: iconst_0
    //   615: aload 20
    //   617: getfield 491	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   620: iload 7
    //   622: isub
    //   623: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: aastore
    //   627: dup
    //   628: iconst_1
    //   629: iload 6
    //   631: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   634: aastore
    //   635: dup
    //   636: iconst_2
    //   637: iload 5
    //   639: invokestatic 324	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: aastore
    //   643: dup
    //   644: iconst_3
    //   645: aload_0
    //   646: aastore
    //   647: dup
    //   648: iconst_4
    //   649: aload_1
    //   650: aastore
    //   651: areturn
    //   652: iload_3
    //   653: istore 7
    //   655: iload 5
    //   657: istore 6
    //   659: aload 17
    //   661: aload 13
    //   663: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   666: invokevirtual 267	anmw:b	(Ljava/lang/String;)Z
    //   669: ifeq +26 -> 695
    //   672: aload_1
    //   673: astore 13
    //   675: aload_0
    //   676: astore_1
    //   677: iload_2
    //   678: istore 4
    //   680: aload 13
    //   682: astore_0
    //   683: aload 16
    //   685: astore 13
    //   687: iload_3
    //   688: istore_2
    //   689: iload 5
    //   691: istore_3
    //   692: goto -277 -> 415
    //   695: iload_3
    //   696: iconst_1
    //   697: iadd
    //   698: istore 4
    //   700: iload 5
    //   702: istore_3
    //   703: iload 4
    //   705: istore 7
    //   707: iload 5
    //   709: istore 6
    //   711: aload 13
    //   713: getfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   716: ifle +8 -> 724
    //   719: iload 5
    //   721: iconst_1
    //   722: iadd
    //   723: istore_3
    //   724: iload 4
    //   726: istore 7
    //   728: iload_3
    //   729: istore 6
    //   731: aload 13
    //   733: getfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   736: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   739: ifne +46 -> 785
    //   742: iload 4
    //   744: istore 7
    //   746: iload_3
    //   747: istore 6
    //   749: aload 13
    //   751: getfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   754: ifle +1015 -> 1769
    //   757: aload 16
    //   759: ifnull +989 -> 1748
    //   762: iload 4
    //   764: istore 7
    //   766: iload_3
    //   767: istore 6
    //   769: aload 16
    //   771: getfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   774: aload 13
    //   776: getfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   779: if_icmpge +962 -> 1741
    //   782: goto +938 -> 1720
    //   785: iload 4
    //   787: istore 7
    //   789: iload_3
    //   790: istore 6
    //   792: aload 13
    //   794: getfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   797: ifle +108 -> 905
    //   800: aload 14
    //   802: ifnull +74 -> 876
    //   805: iload 4
    //   807: istore 7
    //   809: iload_3
    //   810: istore 6
    //   812: aload 14
    //   814: getfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   817: istore 5
    //   819: iload 4
    //   821: istore 7
    //   823: iload_3
    //   824: istore 6
    //   826: aload 13
    //   828: getfield 256	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   831: istore 8
    //   833: iload 5
    //   835: iload 8
    //   837: if_icmpge +32 -> 869
    //   840: aload 13
    //   842: astore 14
    //   844: aload_1
    //   845: astore 13
    //   847: aload_0
    //   848: astore_1
    //   849: iload_2
    //   850: istore 5
    //   852: aload 13
    //   854: astore_0
    //   855: aload 16
    //   857: astore 13
    //   859: iload 4
    //   861: istore_2
    //   862: iload 5
    //   864: istore 4
    //   866: goto -451 -> 415
    //   869: aload 14
    //   871: astore 13
    //   873: goto -33 -> 840
    //   876: aload 13
    //   878: astore 14
    //   880: aload_1
    //   881: astore 13
    //   883: aload_0
    //   884: astore_1
    //   885: iload_2
    //   886: istore 5
    //   888: aload 13
    //   890: astore_0
    //   891: aload 16
    //   893: astore 13
    //   895: iload 4
    //   897: istore_2
    //   898: iload 5
    //   900: istore 4
    //   902: goto -487 -> 415
    //   905: aload_0
    //   906: ifnonnull +742 -> 1648
    //   909: iload_2
    //   910: istore 5
    //   912: aload_1
    //   913: astore_0
    //   914: aload 13
    //   916: astore_1
    //   917: aload 16
    //   919: astore 13
    //   921: iload 4
    //   923: istore_2
    //   924: iload 5
    //   926: istore 4
    //   928: goto -513 -> 415
    //   931: astore_0
    //   932: aload 12
    //   934: astore 18
    //   936: aload 14
    //   938: astore 15
    //   940: aload 16
    //   942: astore 19
    //   944: aload_1
    //   945: astore 17
    //   947: iload_2
    //   948: istore 5
    //   950: iload_3
    //   951: istore 6
    //   953: iload 4
    //   955: istore 7
    //   957: invokestatic 469	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   960: ifeq -404 -> 556
    //   963: ldc 225
    //   965: iconst_4
    //   966: ldc_w 493
    //   969: aload_0
    //   970: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   973: aload 12
    //   975: astore 18
    //   977: aload 14
    //   979: astore 15
    //   981: aload 16
    //   983: astore 19
    //   985: aload_1
    //   986: astore 17
    //   988: iload_2
    //   989: istore 5
    //   991: iload_3
    //   992: istore 6
    //   994: iload 4
    //   996: istore 7
    //   998: goto -442 -> 556
    //   1001: astore 15
    //   1003: aconst_null
    //   1004: astore_0
    //   1005: aconst_null
    //   1006: astore 12
    //   1008: aconst_null
    //   1009: astore 13
    //   1011: aconst_null
    //   1012: astore 14
    //   1014: aconst_null
    //   1015: astore_1
    //   1016: iconst_0
    //   1017: istore_2
    //   1018: iconst_0
    //   1019: istore_3
    //   1020: iconst_0
    //   1021: istore 4
    //   1023: aload_0
    //   1024: astore 17
    //   1026: invokestatic 469	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1029: ifeq +17 -> 1046
    //   1032: aload_0
    //   1033: astore 17
    //   1035: ldc 225
    //   1037: iconst_4
    //   1038: ldc_w 493
    //   1041: aload 15
    //   1043: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1046: aload 12
    //   1048: astore 18
    //   1050: aload 13
    //   1052: astore 15
    //   1054: aload 14
    //   1056: astore 19
    //   1058: aload_1
    //   1059: astore 17
    //   1061: iload_2
    //   1062: istore 5
    //   1064: iload_3
    //   1065: istore 6
    //   1067: iload 4
    //   1069: istore 7
    //   1071: aload_0
    //   1072: ifnull -516 -> 556
    //   1075: aload_0
    //   1076: invokeinterface 293 1 0
    //   1081: aload 12
    //   1083: astore 18
    //   1085: aload 13
    //   1087: astore 15
    //   1089: aload 14
    //   1091: astore 19
    //   1093: aload_1
    //   1094: astore 17
    //   1096: iload_2
    //   1097: istore 5
    //   1099: iload_3
    //   1100: istore 6
    //   1102: iload 4
    //   1104: istore 7
    //   1106: goto -550 -> 556
    //   1109: astore_0
    //   1110: aload 12
    //   1112: astore 18
    //   1114: aload 13
    //   1116: astore 15
    //   1118: aload 14
    //   1120: astore 19
    //   1122: aload_1
    //   1123: astore 17
    //   1125: iload_2
    //   1126: istore 5
    //   1128: iload_3
    //   1129: istore 6
    //   1131: iload 4
    //   1133: istore 7
    //   1135: invokestatic 469	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1138: ifeq -582 -> 556
    //   1141: ldc 225
    //   1143: iconst_4
    //   1144: ldc_w 493
    //   1147: aload_0
    //   1148: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1151: aload 12
    //   1153: astore 18
    //   1155: aload 13
    //   1157: astore 15
    //   1159: aload 14
    //   1161: astore 19
    //   1163: aload_1
    //   1164: astore 17
    //   1166: iload_2
    //   1167: istore 5
    //   1169: iload_3
    //   1170: istore 6
    //   1172: iload 4
    //   1174: istore 7
    //   1176: goto -620 -> 556
    //   1179: astore_0
    //   1180: aconst_null
    //   1181: astore 12
    //   1183: aload 12
    //   1185: ifnull +10 -> 1195
    //   1188: aload 12
    //   1190: invokeinterface 293 1 0
    //   1195: aload_0
    //   1196: athrow
    //   1197: astore_1
    //   1198: invokestatic 469	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1201: ifeq -6 -> 1195
    //   1204: ldc 225
    //   1206: iconst_4
    //   1207: ldc_w 493
    //   1210: aload_1
    //   1211: invokestatic 334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1214: goto -19 -> 1195
    //   1217: aload 19
    //   1219: ifnull +54 -> 1273
    //   1222: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1225: ifeq +33 -> 1258
    //   1228: ldc 225
    //   1230: iconst_2
    //   1231: new 187	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1238: ldc_w 495
    //   1241: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: aload 19
    //   1246: getfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1249: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1258: aload 19
    //   1260: getfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1263: astore_1
    //   1264: aload 19
    //   1266: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1269: astore_0
    //   1270: goto -661 -> 609
    //   1273: aload 15
    //   1275: ifnull +124 -> 1399
    //   1278: aload 15
    //   1280: getfield 95	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1283: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1286: ifeq +104 -> 1390
    //   1289: aload 15
    //   1291: getfield 98	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1294: astore_0
    //   1295: aload 15
    //   1297: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1300: astore 13
    //   1302: aload_0
    //   1303: astore 12
    //   1305: aload 13
    //   1307: astore_1
    //   1308: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1311: ifeq +203 -> 1514
    //   1314: ldc 225
    //   1316: iconst_2
    //   1317: new 187	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1324: ldc_w 495
    //   1327: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: aload 15
    //   1332: getfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1335: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: ldc_w 497
    //   1341: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: aload 15
    //   1346: getfield 98	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1349: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: ldc_w 499
    //   1355: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: aload 15
    //   1360: getfield 95	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1363: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: ldc_w 501
    //   1369: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: aload_0
    //   1373: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1379: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1382: aload_0
    //   1383: astore_1
    //   1384: aload 13
    //   1386: astore_0
    //   1387: goto -778 -> 609
    //   1390: aload 15
    //   1392: getfield 95	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1395: astore_0
    //   1396: goto -101 -> 1295
    //   1399: aload 17
    //   1401: ifnull +238 -> 1639
    //   1404: aload 17
    //   1406: getfield 95	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1409: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1412: ifeq +110 -> 1522
    //   1415: aload 17
    //   1417: getfield 98	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1420: astore_0
    //   1421: aload 17
    //   1423: getfield 101	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   1426: astore 13
    //   1428: aload_0
    //   1429: astore 12
    //   1431: aload 13
    //   1433: astore_1
    //   1434: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1437: ifeq +77 -> 1514
    //   1440: ldc 225
    //   1442: iconst_2
    //   1443: new 187	java/lang/StringBuilder
    //   1446: dup
    //   1447: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1450: ldc_w 495
    //   1453: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: aload 17
    //   1458: getfield 86	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1461: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: ldc_w 497
    //   1467: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: aload 17
    //   1472: getfield 98	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1475: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: ldc_w 499
    //   1481: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload 17
    //   1486: getfield 95	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1489: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: ldc_w 501
    //   1495: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: aload_0
    //   1499: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1505: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1508: aload 13
    //   1510: astore_1
    //   1511: aload_0
    //   1512: astore 12
    //   1514: aload_1
    //   1515: astore_0
    //   1516: aload 12
    //   1518: astore_1
    //   1519: goto -910 -> 609
    //   1522: aload 17
    //   1524: getfield 95	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1527: astore_0
    //   1528: goto -107 -> 1421
    //   1531: astore_0
    //   1532: goto -349 -> 1183
    //   1535: astore_0
    //   1536: aload 17
    //   1538: astore 12
    //   1540: goto -357 -> 1183
    //   1543: astore 15
    //   1545: aload 12
    //   1547: astore_0
    //   1548: aconst_null
    //   1549: astore 12
    //   1551: aconst_null
    //   1552: astore 13
    //   1554: aconst_null
    //   1555: astore_1
    //   1556: iconst_0
    //   1557: istore_2
    //   1558: iconst_0
    //   1559: istore_3
    //   1560: iconst_0
    //   1561: istore 4
    //   1563: aconst_null
    //   1564: astore 14
    //   1566: goto -543 -> 1023
    //   1569: astore 15
    //   1571: aload_0
    //   1572: astore 16
    //   1574: aload 12
    //   1576: astore_0
    //   1577: aload 13
    //   1579: astore 12
    //   1581: aload 14
    //   1583: astore 13
    //   1585: aload 16
    //   1587: astore 14
    //   1589: goto -566 -> 1023
    //   1592: astore 15
    //   1594: aload_0
    //   1595: astore 17
    //   1597: iload 6
    //   1599: istore_3
    //   1600: iload_2
    //   1601: istore 4
    //   1603: aload 12
    //   1605: astore_0
    //   1606: aload 16
    //   1608: astore 12
    //   1610: aload 14
    //   1612: astore 13
    //   1614: aload_1
    //   1615: astore 14
    //   1617: aload 17
    //   1619: astore_1
    //   1620: iload 7
    //   1622: istore_2
    //   1623: goto -600 -> 1023
    //   1626: astore 15
    //   1628: aload 14
    //   1630: astore 13
    //   1632: aload 16
    //   1634: astore 14
    //   1636: goto -613 -> 1023
    //   1639: ldc 80
    //   1641: astore_0
    //   1642: ldc 80
    //   1644: astore_1
    //   1645: goto -1036 -> 609
    //   1648: aload_1
    //   1649: astore 13
    //   1651: aload_0
    //   1652: astore_1
    //   1653: iload_2
    //   1654: istore 5
    //   1656: aload 13
    //   1658: astore_0
    //   1659: aload 16
    //   1661: astore 13
    //   1663: iload 4
    //   1665: istore_2
    //   1666: iload 5
    //   1668: istore 4
    //   1670: goto -1255 -> 415
    //   1673: iload_3
    //   1674: istore 5
    //   1676: aload_1
    //   1677: astore 15
    //   1679: aload 13
    //   1681: astore 16
    //   1683: aload_0
    //   1684: astore_1
    //   1685: aload 15
    //   1687: astore_0
    //   1688: iload_2
    //   1689: istore_3
    //   1690: iload 4
    //   1692: istore_2
    //   1693: goto -1505 -> 188
    //   1696: aload 12
    //   1698: astore_0
    //   1699: aconst_null
    //   1700: astore 12
    //   1702: aconst_null
    //   1703: astore 14
    //   1705: aconst_null
    //   1706: astore_1
    //   1707: iconst_0
    //   1708: istore_2
    //   1709: iconst_0
    //   1710: istore_3
    //   1711: iconst_0
    //   1712: istore 4
    //   1714: aconst_null
    //   1715: astore 16
    //   1717: goto -1272 -> 445
    //   1720: aload_1
    //   1721: astore 15
    //   1723: aload_0
    //   1724: astore_1
    //   1725: iload_2
    //   1726: istore 5
    //   1728: aload 15
    //   1730: astore_0
    //   1731: iload 4
    //   1733: istore_2
    //   1734: iload 5
    //   1736: istore 4
    //   1738: goto -1323 -> 415
    //   1741: aload 16
    //   1743: astore 13
    //   1745: goto -25 -> 1720
    //   1748: aload_1
    //   1749: astore 15
    //   1751: aload_0
    //   1752: astore_1
    //   1753: iload_2
    //   1754: istore 5
    //   1756: aload 15
    //   1758: astore_0
    //   1759: iload 4
    //   1761: istore_2
    //   1762: iload 5
    //   1764: istore 4
    //   1766: goto -1351 -> 415
    //   1769: aload_1
    //   1770: ifnonnull -122 -> 1648
    //   1773: aload_0
    //   1774: astore_1
    //   1775: iload_2
    //   1776: istore 5
    //   1778: aload 13
    //   1780: astore_0
    //   1781: aload 16
    //   1783: astore 13
    //   1785: iload 4
    //   1787: istore_2
    //   1788: iload 5
    //   1790: istore 4
    //   1792: goto -1377 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1795	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	1795	1	paramString	String
    //   187	1601	2	i	int
    //   182	1529	3	j	int
    //   401	1390	4	k	int
    //   184	1605	5	m	int
    //   193	1405	6	n	int
    //   189	1432	7	i1	int
    //   831	7	8	i2	int
    //   83	401	9	l	long
    //   164	221	11	bool	boolean
    //   150	1551	12	localObject1	Object
    //   202	1582	13	localObject2	Object
    //   175	1529	14	localObject3	Object
    //   390	590	15	localObject4	Object
    //   1001	41	15	localThrowable1	java.lang.Throwable
    //   1052	339	15	localObject5	Object
    //   1543	1	15	localThrowable2	java.lang.Throwable
    //   1569	1	15	localThrowable3	java.lang.Throwable
    //   1592	1	15	localThrowable4	java.lang.Throwable
    //   1626	1	15	localThrowable5	java.lang.Throwable
    //   1677	80	15	str	String
    //   172	1610	16	localObject6	Object
    //   9	1609	17	localObject7	Object
    //   92	1062	18	localObject8	Object
    //   66	1199	19	localObject9	Object
    //   24	592	20	localTroopInfo	TroopInfo
    //   78	295	21	localbftx	bftx
    // Exception table:
    //   from	to	target	type
    //   525	531	931	java/lang/Throwable
    //   80	152	1001	java/lang/Throwable
    //   1075	1081	1109	java/lang/Throwable
    //   80	152	1179	finally
    //   1188	1195	1197	java/lang/Throwable
    //   157	166	1531	finally
    //   195	204	1531	finally
    //   211	224	1531	finally
    //   231	244	1531	finally
    //   251	264	1531	finally
    //   271	284	1531	finally
    //   291	304	1531	finally
    //   311	322	1531	finally
    //   329	340	1531	finally
    //   347	360	1531	finally
    //   372	384	1531	finally
    //   415	432	1531	finally
    //   659	672	1531	finally
    //   711	719	1531	finally
    //   731	742	1531	finally
    //   749	757	1531	finally
    //   769	782	1531	finally
    //   792	800	1531	finally
    //   812	819	1531	finally
    //   826	833	1531	finally
    //   448	453	1535	finally
    //   456	462	1535	finally
    //   465	496	1535	finally
    //   1026	1032	1535	finally
    //   1035	1046	1535	finally
    //   157	166	1543	java/lang/Throwable
    //   415	432	1569	java/lang/Throwable
    //   195	204	1592	java/lang/Throwable
    //   211	224	1592	java/lang/Throwable
    //   231	244	1592	java/lang/Throwable
    //   251	264	1592	java/lang/Throwable
    //   271	284	1592	java/lang/Throwable
    //   291	304	1592	java/lang/Throwable
    //   311	322	1592	java/lang/Throwable
    //   329	340	1592	java/lang/Throwable
    //   347	360	1592	java/lang/Throwable
    //   372	384	1592	java/lang/Throwable
    //   659	672	1592	java/lang/Throwable
    //   711	719	1592	java/lang/Throwable
    //   731	742	1592	java/lang/Throwable
    //   749	757	1592	java/lang/Throwable
    //   769	782	1592	java/lang/Throwable
    //   792	800	1592	java/lang/Throwable
    //   812	819	1592	java/lang/Throwable
    //   826	833	1592	java/lang/Throwable
    //   448	453	1626	java/lang/Throwable
    //   456	462	1626	java/lang/Throwable
    //   465	496	1626	java/lang/Throwable
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    case 4: 
      return 5;
    }
    return 6;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, bfyp parambfyp)
  {
    int j = parambfyp.jdField_e_of_type_Int;
    int i = parambfyp.jdField_d_of_type_Int;
    Object localObject1 = parambfyp.jdField_e_of_type_JavaLangString;
    if ((paramQQAppInterface == null) || (paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "doInsertGrayTip invalidate params!");
      }
      return;
    }
    a(paramQQAppInterface, true, paramTroopInfo);
    QLog.i("troopBatchAddFrd.Scene", 1, String.format("doInsertGrayTip_V2 troopUin_type_nonFrdCnt_cmnFrdCnt=%s_%d_%d_%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(parambfyp.jdField_a_of_type_Int), Integer.valueOf(j), Integer.valueOf(i) }));
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    Object localObject2 = paramQQAppInterface.a().a(paramTroopInfo.troopuin, 1);
    long l1;
    long l2;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      l1 = ((ChatMessage)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq;
      l2 = bbyp.a();
      if (j <= 1) {
        break label594;
      }
      localObject1 = String.format(Locale.getDefault(), jdField_a_of_type_JavaLangString, new Object[] { localObject1, Integer.valueOf(j) });
      label208:
      if (i != 0) {
        break label617;
      }
    }
    label594:
    label617:
    for (localObject1 = (String)localObject1 + anni.a(2131712297);; localObject1 = (String)localObject1 + anni.a(2131712299))
    {
      localObject2 = anni.a(2131712298);
      j = ((String)localObject1).indexOf((String)localObject2);
      int k = ((String)localObject2).length();
      localObject2 = new auxc(paramTroopInfo.troopuin, paramTroopInfo.troopuin, (String)localObject1, 1, -5020, 135178, l2);
      ((auxc)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 24);
      ((Bundle)localObject1).putString("key_action_DATA", paramTroopInfo.troopuin);
      ((Bundle)localObject1).putString("key_a_action_DATA", paramTroopInfo.troopcode);
      ((auxc)localObject2).a(j, j + k, (Bundle)localObject1);
      ((auxc)localObject2).jdField_d_of_type_JavaLangString = (a(parambfyp.jdField_a_of_type_Int) + "-" + parambfyp.jdField_d_of_type_JavaLangString);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, (auxc)localObject2);
      ((MessageForUniteGrayTip)localObject1).isread = true;
      ((MessageForUniteGrayTip)localObject1).shmsgseq = l1;
      ((MessageForUniteGrayTip)localObject1).mNeedTimeStamp = true;
      ((MessageForUniteGrayTip)localObject1).updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.a().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      paramTroopInfo.dwLastBAFTipMsgUniSeq2 = ((MessageForUniteGrayTip)localObject1).uniseq;
      localTroopManager.b(paramTroopInfo);
      localObject1 = ((anwd)paramQQAppInterface.a(20)).a();
      ((TroopBatchAddFriendMgr)localObject1).b(parambfyp.jdField_d_of_type_JavaLangString, parambfyp.jdField_c_of_type_JavaLangString);
      if (parambfyp.jdField_a_of_type_Int == 4) {
        ((TroopBatchAddFriendMgr)localObject1).b(parambfyp.jdField_c_of_type_JavaLangString);
      }
      localObject1 = "1";
      if (i > 0) {
        localObject1 = "0";
      }
      bfup.c(paramQQAppInterface, paramTroopInfo.troopuin, l2);
      bcst.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", a(true, parambfyp.jdField_a_of_type_Int), 0, 0, paramTroopInfo.troopuin, Integer.toString(parambfyp.f), Integer.toString(paramTroopInfo.wMemberNum), (String)localObject1);
      return;
      l1 = Math.abs(new Random().nextInt());
      break;
      localObject1 = String.format(Locale.getDefault(), jdField_b_of_type_JavaLangString, new Object[] { localObject1 });
      break label208;
    }
  }
  
  private boolean b()
  {
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V1 data=null");
      }
      return false;
    }
    int i = ((Integer)localObject[0]).intValue();
    int m = ((Integer)localObject[1]).intValue();
    int j = ((Integer)localObject[2]).intValue();
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    int n = (int)(((bajc)localObject).jdField_a_of_type_Float * i);
    int k = (int)(((bajc)localObject).jdField_b_of_type_Float * i);
    if ((m >= n) && (j >= k) && (j > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkTipCondition_V1 nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) }));
      }
      if (!bool) {
        break;
      }
      return true;
    }
    if ((m < n) && (i != 0))
    {
      localObject = String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf(m / i) });
      m = ((String)localObject).length();
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, this.jdField_c_of_type_JavaLangString, "", ((String)localObject).substring(0, m - 1), "");
    }
    if ((j < k) && (i != 0))
    {
      localObject = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(j / i) });
      i = ((String)localObject).length();
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, this.jdField_c_of_type_JavaLangString, "", ((String)localObject).substring(0, i - 1), "");
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    bajc localbajc = ((TroopManager)localObject).a();
    if (localbajc.jdField_a_of_type_Int != 1) {
      return false;
    }
    localObject = ((TroopManager)localObject).b(paramString);
    if (localObject == null) {
      return false;
    }
    a(paramQQAppInterface, false, (TroopInfo)localObject);
    if (!localbajc.a((TroopInfo)localObject, bajc.jdField_a_of_type_ArrayOfLong)) {
      return false;
    }
    if (((TroopInfo)localObject).dwCmdUinJoinTime < localbajc.jdField_a_of_type_Long)
    {
      if ((QLog.isDevelopLevel()) && (((TroopInfo)localObject).dwCmdUinJoinTime == 0L)) {
        QLog.d("troopBatchAddFrd.Scene", 4, String.format(Locale.getDefault(), "checkCommCondition_V1 troop[%s] dwCmdUinJoinTime is 0!", new Object[] { paramString }));
      }
      return false;
    }
    if (TextUtils.equals(((TroopInfo)localObject).troopowneruin, paramQQAppInterface.getCurrentAccountUin())) {
      return false;
    }
    long l1 = localbajc.jdField_c_of_type_Int * 86400;
    long l2 = NetConnInfoCenter.getServerTime();
    long l3 = l2 - ((TroopInfo)localObject).dwCmdUinJoinTime;
    if ((l3 > l1) || (l3 < 0L))
    {
      bcst.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "joinDate", 0, 0, paramString, "", String.valueOf(l3 / 86400L), "");
      return false;
    }
    if (((TroopInfo)localObject).wMemberNum > localbajc.jdField_b_of_type_Int)
    {
      bcst.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "mberNum", 0, 0, paramString, "", String.valueOf(((TroopInfo)localObject).wMemberNum), "");
      return false;
    }
    if (((TroopInfo)localObject).wClickBAFTipCount != 0) {
      return false;
    }
    if (((TroopInfo)localObject).wInsertBAFTipCount >= localbajc.jdField_d_of_type_Int) {
      return false;
    }
    if ((((TroopInfo)localObject).wInsertBAFTipCount == 0) || (((TroopInfo)localObject).dwLastInsertBAFTipTime == 0L)) {
      return true;
    }
    if (l2 - ((TroopInfo)localObject).dwLastInsertBAFTipTime > 86400L) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, "ONE_DAY_SECOND ");
    }
    return baja.a(((TroopInfo)localObject).dwLastInsertBAFTipTime, l2);
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  private boolean c()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 notFrdMems not match");
      }
      return false;
    }
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = localList.size();
    int i = 0;
    while (i < localList.size())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localList.get(i);
      this.f = localTroopBatchAddFriendMgr.b(localTroopMemberInfo.memberuin);
      if ((this.f >= 0) && (this.jdField_d_of_type_JavaLangString == null))
      {
        this.jdField_d_of_type_JavaLangString = localTroopMemberInfo.memberuin;
        this.jdField_e_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo);
        this.jdField_c_of_type_Int = localTroopMemberInfo.commonFrdCnt;
      }
      if (localTroopMemberInfo.commonFrdCnt > this.jdField_d_of_type_Int) {
        this.jdField_d_of_type_Int = localTroopMemberInfo.commonFrdCnt;
      }
      i += 1;
    }
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 already recommended");
      }
      a(localList);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.Scene", 2, "recommend " + this.jdField_d_of_type_JavaLangString);
    }
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("checkCommCondition");
    localStringBuilder.append(" ").append(paramString).append("_").append(paramInt);
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(paramString);
    if (localTroopInfo == null)
    {
      localStringBuilder.append(" ").append("err:").append("troopinfo is null");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    a(paramQQAppInterface, false, localTroopInfo);
    localObject = ((TroopManager)localObject).a();
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((anwd)paramQQAppInterface.a(20)).a();
    String str = a(paramInt);
    if (TextUtils.isEmpty(str))
    {
      localStringBuilder.append(" ").append("err:").append("type invalid");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!localTroopBatchAddFriendMgr.b(str))
    {
      localStringBuilder.append(" ").append("err:").append("switch off");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!((bajc)localObject).a(localTroopInfo, ((bajc)localObject).jdField_b_of_type_ArrayOfLong))
    {
      localStringBuilder.append(" ").append("err:").append("class invalid =").append(localTroopInfo.dwGroupClassExt);
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (localTroopInfo.wMemberNum > ((bajc)localObject).s)
    {
      bcst.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "mberNum", 0, 0, localTroopInfo.troopuin, Integer.toString(a(paramInt)), Integer.toString(localTroopInfo.wMemberNum), "");
      localStringBuilder.append(" ").append("err:").append("member count").append(localTroopInfo.wMemberNum).append(">").append(((bajc)localObject).s);
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (!localTroopBatchAddFriendMgr.c(paramString))
    {
      bcst.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "grpNum", 0, 0, localTroopInfo.troopuin, Integer.toString(a(paramInt)), Integer.toString(localTroopInfo.wMemberNum), "");
      localStringBuilder.append(" ").append("err:").append("troop cant't insert tips ");
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
      }
      return false;
    }
    localStringBuilder.append(" ").append("suc");
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public static int d(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 5;
    case 2: 
      return 6;
    case 3: 
      return 7;
    case 4: 
      return 8;
    }
    return 14;
  }
  
  public int a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_c_of_type_JavaLangString);
    if (localTroopInfo == null) {
      return -1;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getInt(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0);
    if (i == 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, "checkSecurity need execute security check!");
      }
      if (!bgnt.d(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("troopBatchAddFrd.Scene", 2, String.format("checkSecurity return %s. net connect err", new Object[] { localTroopInfo.troopuin }));
        }
        return -1;
      }
      ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(localTroopInfo.troopuin, localTroopInfo.troopcode, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      return 0;
    }
    if (i != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format(Locale.getDefault(), "checkSecurity fail value: %s", new Object[] { Integer.valueOf(i) }));
      }
      return -1;
    }
    return 1;
  }
  
  List<TroopMemberInfo> a()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject2 = ((TroopManager)localObject1).a();
    localObject1 = ((TroopManager)localObject1).b(this.jdField_c_of_type_JavaLangString);
    int k = ((bajc)localObject2).a(this.jdField_a_of_type_Int);
    int j;
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 2: 
      localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, null, true);
      j = 0;
      i = 0;
      if (j < ((List)localObject2).size())
      {
        if (((TroopMemberInfo)((List)localObject2).get(j)).commonFrdCnt <= 0) {
          break label855;
        }
        i += 1;
      }
      break;
    }
    label849:
    label855:
    for (;;)
    {
      j += 1;
      break;
      if (i < k)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject3 = this.jdField_c_of_type_JavaLangString;
        String str = Integer.toString(i);
        if (localObject1 == null) {}
        for (i = 0;; i = ((TroopInfo)localObject1).wMemberNum)
        {
          bcst.b((QQAppInterface)localObject2, "dc00899", "Grp_addFrd", "", "nonGreyTip", "actvie-res", 0, 0, (String)localObject3, str, Integer.toString(i), "");
          return null;
        }
        localObject1 = new ArrayList();
        localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, true);
        j = 0;
        i = 0;
        if (j < ((List)localObject2).size())
        {
          localObject3 = (TroopMemberInfo)((List)localObject2).get(j);
          if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
            }
            ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
          }
          if (((TroopMemberInfo)localObject3).commonFrdCnt < i) {
            break label849;
          }
          i = ((TroopMemberInfo)localObject3).commonFrdCnt;
        }
        for (;;)
        {
          if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
            ((List)localObject1).add(localObject3);
          }
          j += 1;
          break;
          if (((List)localObject1).size() == 0)
          {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "discus-res", 0, 0, this.jdField_c_of_type_JavaLangString, Integer.toString(i), Integer.toString(((List)localObject2).size()), "");
            return localObject1;
            localObject1 = new ArrayList();
            localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, false);
            i = 0;
            while (i < ((List)localObject2).size())
            {
              localObject3 = (TroopMemberInfo)((List)localObject2).get(i);
              if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
                }
                ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
              }
              if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
                ((List)localObject1).add(localObject3);
              }
              i += 1;
            }
            if (((List)localObject1).size() == 0)
            {
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              str = this.jdField_c_of_type_JavaLangString;
              if (((List)localObject2).size() == 0) {}
              for (i = 0;; i = ((TroopMemberInfo)((List)localObject2).get(0)).commonFrdCnt)
              {
                bcst.b((QQAppInterface)localObject3, "dc00899", "Grp_addFrd", "", "nonGreyTip", "new_res", 0, 0, str, Integer.toString(i), "", "");
                return localObject1;
              }
              localObject1 = new ArrayList();
              localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, false);
              i = 0;
              while (i < ((List)localObject2).size())
              {
                localObject3 = (TroopMemberInfo)((List)localObject2).get(i);
                if (((TroopMemberInfo)localObject3).commonFrdCnt < 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + ((TroopMemberInfo)localObject3).commonFrdCnt);
                  }
                  ((TroopMemberInfo)localObject3).commonFrdCnt = 0;
                }
                if (((TroopMemberInfo)localObject3).commonFrdCnt >= k) {
                  ((List)localObject1).add(localObject3);
                }
                i += 1;
              }
              if (((List)localObject1).size() == 0)
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                str = this.jdField_c_of_type_JavaLangString;
                if (((List)localObject2).size() == 0) {}
                for (i = 0;; i = ((TroopMemberInfo)((List)localObject2).get(0)).commonFrdCnt)
                {
                  bcst.b((QQAppInterface)localObject3, "dc00899", "Grp_addFrd", "", "nonGreyTip", "@_res", 0, 0, str, Integer.toString(i), "", "");
                  return localObject1;
                }
              }
              return localObject1;
            }
            return localObject1;
          }
          return localObject1;
        }
      }
      return localObject2;
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int == 5) {
      b();
    }
    if (this.jdField_b_of_type_Int != 0) {
      return;
    }
    a(true, 0);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_Int = -1;
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, String.format("onErr %s", new Object[] { paramString }));
    }
    if (this.jdField_a_of_type_Bfyq != null) {
      this.jdField_a_of_type_Bfyq.b(this);
    }
  }
  
  void a(List<TroopMemberInfo> paramList)
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (localTroopBatchAddFriendMgr.a(((TroopMemberInfo)paramList.next()).memberuin) >= 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_c_of_type_JavaLangString);
        if (paramList != null) {
          break label140;
        }
      }
      label140:
      for (i = 0;; i = paramList.wMemberNum)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "UinNum_total", 0, 0, this.jdField_c_of_type_JavaLangString, Integer.toString(a(this.jdField_a_of_type_Int)), Integer.toString(i), "");
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int j = -1;
    QLog.i("troopBatchAddFrd.Scene", 1, String.format("onStepAndNext troopUin_type_ts_suc_step=%s_%d_%d_%b_%d", new Object[] { this.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    int i;
    if (paramBoolean)
    {
      i = paramInt;
      label66:
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != 0) {
        break label118;
      }
      i = a();
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      default: 
        return;
        i = -1;
        break label66;
        label118:
        if (this.jdField_b_of_type_Int == 1)
        {
          i = b();
        }
        else if (this.jdField_b_of_type_Int == 2)
        {
          i = c();
        }
        else if (this.jdField_b_of_type_Int == 3)
        {
          i = e();
        }
        else if (this.jdField_b_of_type_Int == 4)
        {
          i = d();
        }
        else
        {
          if (this.jdField_b_of_type_Int == 5)
          {
            b();
            return;
          }
          i = j;
          if (this.jdField_b_of_type_Int == -1) {
            i = j;
          }
        }
        break;
      }
    }
    a(String.format("onStepAndNext err %s_%d_%d_%b_%d", new Object[] { this.jdField_c_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    return;
    a(true, this.jdField_b_of_type_Int + 1);
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int != -1) && (this.jdField_b_of_type_Int != 6);
  }
  
  public int b()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    if ((l == 0L) || (System.currentTimeMillis() - l > 86400000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkDataTroopMemberList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
      }
      int i = j;
      if (bool) {
        i = j;
      }
      switch (((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a().a(this.jdField_c_of_type_JavaLangString, l, this.jdField_a_of_type_Int))
      {
      default: 
        i = -1;
      case 1: 
        return i;
      }
    }
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.Scene", 2, "onSuc troopUin = " + this.jdField_c_of_type_JavaLangString + ",type = " + this.jdField_a_of_type_Int + ",ts=" + this.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_Bfyq != null) {
      this.jdField_a_of_type_Bfyq.a(this);
    }
  }
  
  public int c()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_cmnfrds", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    label109:
    int i;
    String str;
    int k;
    if ((l == 0L) || (System.currentTimeMillis() - l > ((bajc)localObject).t * 60 * 60 * 1000))
    {
      bool = true;
      QLog.d("troopBatchAddFrd.Scene", 1, String.format("checkDataCmnFrdCntList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
      if (!bool)
      {
        i = j;
        if (this.jdField_a_of_type_Int != 4) {}
      }
      else
      {
        localObject = ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
        str = this.jdField_c_of_type_JavaLangString;
        k = this.jdField_a_of_type_Int;
        if (!bool) {
          break label258;
        }
      }
    }
    label258:
    for (boolean bool = false;; bool = true)
    {
      i = j;
      switch (((TroopBatchAddFriendMgr)localObject).a(str, l, k, bool, this.jdField_a_of_type_JavaUtilList))
      {
      default: 
        i = -1;
      case 1: 
        return i;
        bool = false;
        break label109;
      }
    }
    return 0;
  }
  
  public int d()
  {
    int j = 1;
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remarks", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString }), 0L);
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    label109:
    int i;
    String str;
    int k;
    if ((l == 0L) || (System.currentTimeMillis() - l > ((bajc)localObject).u * 60 * 60 * 1000))
    {
      bool = true;
      QLog.d("troopBatchAddFrd.Scene", 1, String.format("checkDataRecmdRemarkList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString }));
      if (!bool)
      {
        i = j;
        if (this.jdField_a_of_type_Int != 4) {}
      }
      else
      {
        localObject = ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
        str = this.jdField_c_of_type_JavaLangString;
        k = this.jdField_a_of_type_Int;
        if (!bool) {
          break label254;
        }
      }
    }
    label254:
    for (boolean bool = false;; bool = true)
    {
      i = j;
      switch (((TroopBatchAddFriendMgr)localObject).a(str, l, k, bool))
      {
      default: 
        i = -1;
      case 1: 
        return i;
        bool = false;
        break label109;
      }
    }
    return 0;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_Int == 1) {}
    for (boolean bool = b(); (!QLog.isColorLevel()) || (bool); bool = c()) {
      return 1;
    }
    return -1;
  }
  
  public int f()
  {
    int j = 1;
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_c_of_type_JavaLangString);
    int i;
    if (localTroopInfo == null)
    {
      this.jdField_b_of_type_Int = -1;
      i = -1;
      return i;
    }
    if (this.jdField_b_of_type_Int != 5) {
      return -1;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 1);
    if (localList.size() > 0)
    {
      i = Math.min(localList.size(), 10);
      i = localList.size() - i;
      if (i < localList.size()) {
        if (!njo.a((MessageRecord)localList.get(i))) {}
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.d("troopBatchAddFrd.Scene", 1, String.format("insertTip hasAnonymousMsg=%b aioList=%d troopUin=%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localList.size()), this.jdField_c_of_type_JavaLangString }));
      i = j;
      if (bool) {
        break;
      }
      if (this.jdField_a_of_type_Int == 1) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo, this);
      }
      for (;;)
      {
        this.jdField_b_of_type_Int = 6;
        return 0;
        i += 1;
        break;
        b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopInfo, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyp
 * JD-Core Version:    0.7.0.1
 */