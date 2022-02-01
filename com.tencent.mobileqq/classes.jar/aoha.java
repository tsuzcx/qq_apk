import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class aoha
  implements Manager
{
  public static boolean a;
  private final int jdField_a_of_type_Int = 10000;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final int b = 10001;
  
  public aoha(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
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
    anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    paramString = localanyw.e(paramString);
    if (paramString != null)
    {
      paramString = localanyw.a(paramString.groupid + "");
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
  
  private boolean a(SearchHistory paramSearchHistory, PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    if (!paramPhoneContactManagerImp.i()) {}
    do
    {
      return true;
      paramSearchHistory = paramPhoneContactManagerImp.c(paramSearchHistory.uin);
    } while ((paramSearchHistory == null) || (!"0".equals(paramSearchHistory.uin)));
    return false;
  }
  
  private boolean c(SearchHistory paramSearchHistory)
  {
    paramSearchHistory = ((anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramSearchHistory.uin);
    return (paramSearchHistory == null) || (paramSearchHistory.isHidden());
  }
  
  private boolean d(SearchHistory paramSearchHistory)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (localPhoneContactManagerImp.i()) {
      return true;
    }
    paramSearchHistory = localPhoneContactManagerImp.c(paramSearchHistory.uin);
    if (paramSearchHistory == null) {
      return true;
    }
    return TextUtils.isEmpty(paramSearchHistory.uin);
  }
  
  private boolean e(SearchHistory paramSearchHistory)
  {
    Object localObject = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((anyw)localObject).b(paramSearchHistory.uin)) {
        bool1 = true;
      }
    }
    if (paramSearchHistory.type == 1000)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (((TroopManager)localObject).b(((TroopManager)localObject).c(paramSearchHistory.troopUin), paramSearchHistory.uin) != null) {}
    }
    else
    {
      do
      {
        return true;
        if (paramSearchHistory.type != 1004) {
          break;
        }
        paramSearchHistory = ((anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramSearchHistory.troopUin);
      } while ((paramSearchHistory == null) || (paramSearchHistory.isDiscussHrMeeting()) || (paramSearchHistory.isHidden()));
    }
    return bool1;
  }
  
  /* Error */
  public java.util.ArrayList<SearchHistory> a()
  {
    // Byte code:
    //   0: new 187	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 188	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: iconst_0
    //   14: ldc 133
    //   16: invokevirtual 193	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: ldc 195
    //   26: aconst_null
    //   27: invokevirtual 201	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +258 -> 290
    //   35: aload_3
    //   36: invokeinterface 206 1 0
    //   41: ifeq +249 -> 290
    //   44: iconst_0
    //   45: istore_1
    //   46: new 133	com/tencent/mobileqq/data/SearchHistory
    //   49: dup
    //   50: invokespecial 207	com/tencent/mobileqq/data/SearchHistory:<init>	()V
    //   53: astore 5
    //   55: aload 5
    //   57: aload_3
    //   58: aload_3
    //   59: ldc 209
    //   61: invokeinterface 213 2 0
    //   66: invokeinterface 216 2 0
    //   71: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   74: aload 5
    //   76: aload_3
    //   77: aload_3
    //   78: ldc 220
    //   80: invokeinterface 213 2 0
    //   85: invokeinterface 216 2 0
    //   90: putfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   93: aload 5
    //   95: aload_3
    //   96: aload_3
    //   97: ldc 223
    //   99: invokeinterface 213 2 0
    //   104: invokeinterface 216 2 0
    //   109: putfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   112: aload 5
    //   114: aload_3
    //   115: aload_3
    //   116: ldc 224
    //   118: invokeinterface 213 2 0
    //   123: invokeinterface 216 2 0
    //   128: putfield 174	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   131: aload 5
    //   133: aload_3
    //   134: aload_3
    //   135: ldc 225
    //   137: invokeinterface 213 2 0
    //   142: invokeinterface 229 2 0
    //   147: putfield 169	com/tencent/mobileqq/data/SearchHistory:type	I
    //   150: aload 5
    //   152: aload_3
    //   153: aload_3
    //   154: ldc 231
    //   156: invokeinterface 213 2 0
    //   161: invokeinterface 216 2 0
    //   166: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   169: aload 5
    //   171: aload_3
    //   172: aload_3
    //   173: ldc 235
    //   175: invokeinterface 213 2 0
    //   180: invokeinterface 229 2 0
    //   185: putfield 237	com/tencent/mobileqq/data/SearchHistory:count	I
    //   188: aload 5
    //   190: aload_3
    //   191: aload_3
    //   192: ldc 239
    //   194: invokeinterface 213 2 0
    //   199: invokeinterface 243 2 0
    //   204: putfield 246	com/tencent/mobileqq/data/SearchHistory:time	J
    //   207: aload 5
    //   209: aload_3
    //   210: aload_3
    //   211: ldc 248
    //   213: invokeinterface 213 2 0
    //   218: invokeinterface 229 2 0
    //   223: i2l
    //   224: invokevirtual 252	com/tencent/mobileqq/data/SearchHistory:setId	(J)V
    //   227: aload_0
    //   228: aload 5
    //   230: invokevirtual 254	aoha:a	(Lcom/tencent/mobileqq/data/SearchHistory;)Z
    //   233: istore_2
    //   234: iload_1
    //   235: iconst_5
    //   236: if_icmplt +5 -> 241
    //   239: iconst_1
    //   240: istore_2
    //   241: iload_2
    //   242: ifeq +61 -> 303
    //   245: aload_0
    //   246: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   249: ldc 133
    //   251: aload 5
    //   253: getfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   256: invokevirtual 258	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   259: checkcast 133	com/tencent/mobileqq/data/SearchHistory
    //   262: astore 5
    //   264: aload 5
    //   266: ifnull +13 -> 279
    //   269: aload_0
    //   270: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   273: aload 5
    //   275: invokevirtual 262	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   278: pop
    //   279: aload_3
    //   280: invokeinterface 265 1 0
    //   285: istore_2
    //   286: iload_2
    //   287: ifne +75 -> 362
    //   290: aload_3
    //   291: ifnull +9 -> 300
    //   294: aload_3
    //   295: invokeinterface 268 1 0
    //   300: aload 4
    //   302: areturn
    //   303: iload_1
    //   304: iconst_5
    //   305: if_icmpge -26 -> 279
    //   308: aload 4
    //   310: aload 5
    //   312: invokevirtual 271	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   315: pop
    //   316: goto -37 -> 279
    //   319: astore 5
    //   321: aload_3
    //   322: ifnull -22 -> 300
    //   325: aload_3
    //   326: invokeinterface 268 1 0
    //   331: aload 4
    //   333: areturn
    //   334: astore 4
    //   336: aconst_null
    //   337: astore_3
    //   338: aload_3
    //   339: ifnull +9 -> 348
    //   342: aload_3
    //   343: invokeinterface 268 1 0
    //   348: aload 4
    //   350: athrow
    //   351: astore 4
    //   353: goto -15 -> 338
    //   356: astore_3
    //   357: aconst_null
    //   358: astore_3
    //   359: goto -38 -> 321
    //   362: iload_1
    //   363: iconst_1
    //   364: iadd
    //   365: istore_1
    //   366: goto -320 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	aoha
    //   45	321	1	i	int
    //   233	54	2	bool	boolean
    //   30	313	3	localCursor	android.database.Cursor
    //   356	1	3	localException1	java.lang.Exception
    //   358	1	3	localObject1	Object
    //   7	325	4	localArrayList	java.util.ArrayList
    //   334	15	4	localObject2	Object
    //   351	1	4	localObject3	Object
    //   53	258	5	localSearchHistory	SearchHistory
    //   319	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   35	44	319	java/lang/Exception
    //   46	234	319	java/lang/Exception
    //   245	264	319	java/lang/Exception
    //   269	279	319	java/lang/Exception
    //   279	286	319	java/lang/Exception
    //   308	316	319	java/lang/Exception
    //   9	31	334	finally
    //   35	44	351	finally
    //   46	234	351	finally
    //   245	264	351	finally
    //   269	279	351	finally
    //   279	286	351	finally
    //   308	316	351	finally
    //   9	31	356	java/lang/Exception
  }
  
  /* Error */
  public void a(SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 237	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   9: putfield 246	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 169	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: lookupswitch	default:+124->140, 0:+125->141, 1:+273->289, 1000:+393->409, 1004:+433->449, 1006:+353->369, 1008:+513->529, 1021:+473->489, 3000:+313->329, 7220:+566->582, 56938:+353->369, 56939:+353->369, 56940:+353->369, 56941:+353->369, 56942:+353->369
    //   141: aload_1
    //   142: aload_0
    //   143: aload_1
    //   144: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   147: invokespecial 282	aoha:a	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   153: aload_1
    //   154: getfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   157: ifnonnull +13 -> 170
    //   160: aload_1
    //   161: ldc_w 283
    //   164: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   167: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   170: aload_1
    //   171: new 52	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   178: aload_1
    //   179: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   182: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: sipush 10001
    //   188: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   197: aload_0
    //   198: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   201: ldc 133
    //   203: aload_1
    //   204: getfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   207: invokevirtual 258	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   210: checkcast 133	com/tencent/mobileqq/data/SearchHistory
    //   213: astore_2
    //   214: aload_2
    //   215: ifnull +407 -> 622
    //   218: aload_2
    //   219: aload_1
    //   220: getfield 246	com/tencent/mobileqq/data/SearchHistory:time	J
    //   223: putfield 246	com/tencent/mobileqq/data/SearchHistory:time	J
    //   226: aload_2
    //   227: aload_2
    //   228: getfield 237	com/tencent/mobileqq/data/SearchHistory:count	I
    //   231: iconst_1
    //   232: iadd
    //   233: putfield 237	com/tencent/mobileqq/data/SearchHistory:count	I
    //   236: aload_2
    //   237: getfield 169	com/tencent/mobileqq/data/SearchHistory:type	I
    //   240: aload_1
    //   241: getfield 169	com/tencent/mobileqq/data/SearchHistory:type	I
    //   244: if_icmpeq +35 -> 279
    //   247: aload_2
    //   248: aload_1
    //   249: getfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   252: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   255: aload_2
    //   256: aload_1
    //   257: getfield 169	com/tencent/mobileqq/data/SearchHistory:type	I
    //   260: putfield 169	com/tencent/mobileqq/data/SearchHistory:type	I
    //   263: aload_2
    //   264: aload_1
    //   265: getfield 174	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   268: putfield 174	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   271: aload_2
    //   272: aload_1
    //   273: getfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   276: putfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   279: aload_0
    //   280: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   283: aload_2
    //   284: invokevirtual 290	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   287: pop
    //   288: return
    //   289: aload_1
    //   290: ldc_w 291
    //   293: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   296: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   299: aload_1
    //   300: new 52	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   307: aload_1
    //   308: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   311: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: sipush 10000
    //   317: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   326: goto -129 -> 197
    //   329: aload_1
    //   330: ldc_w 292
    //   333: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   336: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   339: aload_1
    //   340: new 52	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   347: aload_1
    //   348: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   351: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: sipush 10000
    //   357: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   366: goto -169 -> 197
    //   369: aload_1
    //   370: ldc_w 293
    //   373: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   376: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   379: aload_1
    //   380: new 52	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   387: aload_1
    //   388: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   391: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: sipush 10001
    //   397: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   406: goto -209 -> 197
    //   409: aload_1
    //   410: ldc_w 294
    //   413: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   416: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   419: aload_1
    //   420: new 52	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   427: aload_1
    //   428: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   431: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: sipush 10001
    //   437: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   446: goto -249 -> 197
    //   449: aload_1
    //   450: ldc_w 295
    //   453: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   456: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   459: aload_1
    //   460: new 52	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   467: aload_1
    //   468: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   471: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: sipush 10001
    //   477: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   486: goto -289 -> 197
    //   489: aload_1
    //   490: ldc_w 296
    //   493: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   496: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   499: aload_1
    //   500: new 52	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   507: aload_1
    //   508: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   511: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: sipush 10001
    //   517: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   526: goto -329 -> 197
    //   529: aload_1
    //   530: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   533: getstatic 301	antf:az	Ljava/lang/String;
    //   536: invokestatic 304	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   539: ifeq -342 -> 197
    //   542: aload_1
    //   543: ldc_w 305
    //   546: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   549: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   552: aload_1
    //   553: new 52	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   560: aload_1
    //   561: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   564: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: sipush 10001
    //   570: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   579: goto -382 -> 197
    //   582: aload_1
    //   583: ldc_w 306
    //   586: invokestatic 287	anzj:a	(I)Ljava/lang/String;
    //   589: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   592: aload_1
    //   593: new 52	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   600: aload_1
    //   601: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   604: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: sipush 10001
    //   610: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   619: goto -422 -> 197
    //   622: aload_0
    //   623: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   626: iconst_0
    //   627: ldc 133
    //   629: invokevirtual 193	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   632: aconst_null
    //   633: aconst_null
    //   634: aconst_null
    //   635: aconst_null
    //   636: aconst_null
    //   637: ldc_w 308
    //   640: aconst_null
    //   641: invokevirtual 201	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   644: astore_3
    //   645: aload_3
    //   646: ifnull +173 -> 819
    //   649: aload_3
    //   650: astore_2
    //   651: iconst_5
    //   652: aload_3
    //   653: invokeinterface 312 1 0
    //   658: if_icmpgt +161 -> 819
    //   661: aload_3
    //   662: astore_2
    //   663: aload_3
    //   664: invokeinterface 206 1 0
    //   669: ifeq +139 -> 808
    //   672: aload_3
    //   673: astore_2
    //   674: aload_3
    //   675: aload_3
    //   676: ldc 209
    //   678: invokeinterface 213 2 0
    //   683: invokeinterface 216 2 0
    //   688: astore 4
    //   690: aload_3
    //   691: astore_2
    //   692: aload_0
    //   693: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   696: ldc 133
    //   698: aload 4
    //   700: invokevirtual 258	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   703: checkcast 133	com/tencent/mobileqq/data/SearchHistory
    //   706: astore 4
    //   708: aload_3
    //   709: astore_2
    //   710: aload 4
    //   712: aload_1
    //   713: getfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   716: putfield 218	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   719: aload_3
    //   720: astore_2
    //   721: aload 4
    //   723: aload_1
    //   724: getfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   727: putfield 136	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   730: aload_3
    //   731: astore_2
    //   732: aload 4
    //   734: aload_1
    //   735: getfield 174	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   738: putfield 174	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   741: aload_3
    //   742: astore_2
    //   743: aload 4
    //   745: aload_1
    //   746: getfield 246	com/tencent/mobileqq/data/SearchHistory:time	J
    //   749: putfield 246	com/tencent/mobileqq/data/SearchHistory:time	J
    //   752: aload_3
    //   753: astore_2
    //   754: aload 4
    //   756: aload_1
    //   757: getfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   760: putfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   763: aload_3
    //   764: astore_2
    //   765: aload 4
    //   767: aload_1
    //   768: getfield 169	com/tencent/mobileqq/data/SearchHistory:type	I
    //   771: putfield 169	com/tencent/mobileqq/data/SearchHistory:type	I
    //   774: aload_3
    //   775: astore_2
    //   776: aload 4
    //   778: aload_1
    //   779: getfield 237	com/tencent/mobileqq/data/SearchHistory:count	I
    //   782: putfield 237	com/tencent/mobileqq/data/SearchHistory:count	I
    //   785: aload_3
    //   786: astore_2
    //   787: aload 4
    //   789: aload_1
    //   790: getfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   793: putfield 233	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   796: aload_3
    //   797: astore_2
    //   798: aload_0
    //   799: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   802: aload 4
    //   804: invokevirtual 290	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   807: pop
    //   808: aload_3
    //   809: ifnull -669 -> 140
    //   812: aload_3
    //   813: invokeinterface 268 1 0
    //   818: return
    //   819: aload_3
    //   820: astore_2
    //   821: aload_0
    //   822: getfield 36	aoha:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   825: aload_1
    //   826: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   829: goto -21 -> 808
    //   832: astore_1
    //   833: aload_3
    //   834: astore_2
    //   835: aload_1
    //   836: invokevirtual 319	java/lang/Exception:printStackTrace	()V
    //   839: aload_3
    //   840: ifnull -700 -> 140
    //   843: aload_3
    //   844: invokeinterface 268 1 0
    //   849: return
    //   850: astore_1
    //   851: aconst_null
    //   852: astore_2
    //   853: aload_2
    //   854: ifnull +9 -> 863
    //   857: aload_2
    //   858: invokeinterface 268 1 0
    //   863: aload_1
    //   864: athrow
    //   865: astore_1
    //   866: goto -13 -> 853
    //   869: astore_1
    //   870: aconst_null
    //   871: astore_3
    //   872: goto -39 -> 833
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	875	0	this	aoha
    //   0	875	1	paramSearchHistory	SearchHistory
    //   213	645	2	localObject1	Object
    //   644	228	3	localCursor	android.database.Cursor
    //   688	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   651	661	832	java/lang/Exception
    //   663	672	832	java/lang/Exception
    //   674	690	832	java/lang/Exception
    //   692	708	832	java/lang/Exception
    //   710	719	832	java/lang/Exception
    //   721	730	832	java/lang/Exception
    //   732	741	832	java/lang/Exception
    //   743	752	832	java/lang/Exception
    //   754	763	832	java/lang/Exception
    //   765	774	832	java/lang/Exception
    //   776	785	832	java/lang/Exception
    //   787	796	832	java/lang/Exception
    //   798	808	832	java/lang/Exception
    //   821	829	832	java/lang/Exception
    //   622	645	850	finally
    //   651	661	865	finally
    //   663	672	865	finally
    //   674	690	865	finally
    //   692	708	865	finally
    //   710	719	865	finally
    //   721	730	865	finally
    //   732	741	865	finally
    //   743	752	865	finally
    //   754	763	865	finally
    //   765	774	865	finally
    //   776	785	865	finally
    //   787	796	865	finally
    //   798	808	865	finally
    //   821	829	865	finally
    //   835	839	865	finally
    //   622	645	869	java/lang/Exception
  }
  
  boolean a(SearchHistory paramSearchHistory)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    switch (paramSearchHistory.type)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramSearchHistory.uin));
          return true;
          return e(paramSearchHistory);
        } while (localTroopManager.b(paramSearchHistory.uin) != null);
        return true;
        return c(paramSearchHistory);
        return true;
        if ((!TextUtils.equals(paramSearchHistory.uin, antf.az)) || (bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          return true;
        }
        paramSearchHistory.displayName = tyi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        return false;
        if ((!bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (bnrf.j())) {
          return true;
        }
        paramSearchHistory.displayName = tyi.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        return false;
        return d(paramSearchHistory);
        return a(paramSearchHistory, localPhoneContactManagerImp);
        paramSearchHistory = localPhoneContactManagerImp.c(paramSearchHistory.uin);
      } while ((paramSearchHistory != null) && (!TextUtils.isEmpty(paramSearchHistory.uin)) && (!"0".equals(paramSearchHistory.uin)));
      return true;
      paramSearchHistory = localPhoneContactManagerImp.c(paramSearchHistory.uin);
    } while (paramSearchHistory == null);
    return !TextUtils.isEmpty(paramSearchHistory.uin);
  }
  
  public boolean b(SearchHistory paramSearchHistory)
  {
    boolean bool = false;
    if (paramSearchHistory != null)
    {
      paramSearchHistory.setStatus(1001);
      bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramSearchHistory);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoha
 * JD-Core Version:    0.7.0.1
 */