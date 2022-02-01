import GeneralSettings.Setting;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.DBUtils.1;
import com.tencent.mobileqq.utils.DBUtils.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bhdf
{
  bhdh a = new bhdh(10, 32);
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    int i = Build.VERSION.SDK_INT;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("troop_news_notify", i).getInt(paramString1 + paramString2 + paramString3, 0);
    }
  }
  
  public static bhdf a()
  {
    return bhdg.a;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = "";
    }
    do
    {
      return paramString1;
      paramString3 = BaseApplication.getContext().getSharedPreferences(paramString1, 0).getString(paramString1 + "troop_active_ranking_red_point" + paramString2 + "wording", paramString3);
      paramString1 = paramString3;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "getTroopActiveRankingRedPointWording troopUin = " + paramString2 + ", wording = " + paramString3);
    return paramString3;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "setTroopLuckyCharacterStatus troopUin = " + paramString2 + ", wording = " + paramString3);
    }
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    localEditor.putLong(paramString1 + "troop_lucky_character_status" + paramString2 + "time", l);
    localEditor.putString(paramString1 + "troop_lucky_character_status" + paramString2 + "wording", paramString3);
    localEditor.apply();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("troop_news_notify", i).edit();
      ((SharedPreferences.Editor)localObject).putInt(paramString1 + paramString2 + paramString3, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    if (paramBoolean)
    {
      localEditor.putBoolean(paramString1 + "group_file_inner_reddot_tim" + paramString3, true);
      localEditor.putBoolean(paramString1 + "group_file_reddot_tim" + paramString3, true);
    }
    for (;;)
    {
      localEditor.putBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
      localEditor.commit();
      return;
      localEditor.putBoolean(paramString1 + "group_file_inner_reddot_tim" + paramString3, false);
      localEditor.putBoolean(paramString1 + "group_file_reddot_tim" + paramString3, false);
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "setTroopGameCardRedPoint troopUin = " + paramString2 + ", isShowRedPoint = " + paramBoolean);
    }
    BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit().putBoolean(paramString1 + "troop_game_card_red_point" + paramString2, paramBoolean).commit();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "setTroopActiveRankingWording troopUin = " + paramString2 + ", isShowRedPoint = " + paramBoolean + ", wording = " + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    localEditor.putBoolean(paramString1 + "troop_active_ranking_red_point" + paramString2, paramBoolean);
    localEditor.putString(paramString1 + "troop_active_ranking_red_point" + paramString2 + "wording", paramString3);
    localEditor.commit();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = BaseApplication.getContext().getSharedPreferences(paramString1, 0).getBoolean(paramString1 + "troop_game_card_red_point_has_showed" + paramString2, false);
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "hasShowTroopGameCardRedPoint troopUin = " + paramString2 + ", isShow = " + bool);
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return BaseApplication.getContext().getSharedPreferences(paramString1, 0).getBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      return bool1;
      paramBoolean = BaseApplication.getContext().getSharedPreferences(paramString1, 0).getBoolean(paramString1 + "troop_active_ranking_red_point" + paramString2, paramBoolean);
      bool1 = paramBoolean;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "isShowTroopActiveRankingRedPoint troopUin = " + paramString2 + ", isShow = " + paramBoolean);
    return paramBoolean;
  }
  
  public static Object[] a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    long l = localSharedPreferences.getLong(paramString1 + "troop_lucky_character_status" + paramString2 + "time", 0L);
    paramString1 = localSharedPreferences.getString(paramString1 + "troop_lucky_character_status" + paramString2 + "wording", paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "getKeyTroopLuckyCharacterStatus troopUin = " + paramString2 + ", lastFetchTime = " + l + ",wording" + paramString1);
    }
    return new Object[] { Long.valueOf(l), paramString1 };
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    localEditor.putBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
    localEditor.commit();
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "setTroopGameCardRedPointHasShowed troopUin = " + paramString2 + ", isShowRedPoint = " + paramBoolean);
    }
    BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit().putBoolean(paramString1 + "troop_game_card_red_point_has_showed" + paramString2, paramBoolean).commit();
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString, 0).edit();
    localEditor.putBoolean(paramString + "troop_lucky_character_red_point", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean b(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = BaseApplication.getContext().getSharedPreferences(paramString, 0).getBoolean(paramString + "troop_lucky_character_red_point", true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "isShowTroopLuckyCharacterRedPoint isShow = " + bool2);
    return bool2;
  }
  
  public static boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramBoolean = false;
    }
    boolean bool;
    do
    {
      return paramBoolean;
      if (bdvn.a()) {
        return false;
      }
      Object localObject = (bgft)aqxe.a().a(695);
      if ((localObject == null) || (!((bgft)localObject).a(paramString2))) {
        return false;
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject == null) {
        return false;
      }
      localObject = ((TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString2);
      if (localObject == null) {
        return false;
      }
      if (((TroopInfo)localObject).isHomeworkTroop()) {
        return false;
      }
      if (!((TroopInfo)localObject).isTroopGameCardEnabled()) {
        return false;
      }
      localObject = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
      if (a(paramString1, paramString2)) {
        return false;
      }
      bool = ((SharedPreferences)localObject).getBoolean(paramString1 + "troop_game_card_red_point" + paramString2, paramBoolean);
      paramBoolean = bool;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "isShowTroopGameCardRedPoint troopUin = " + paramString2 + ", isShow = " + bool);
    return bool;
  }
  
  public static void c(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString, 0).edit();
    localEditor.putBoolean(paramString + "troop_lucky_character_red_point_aio", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean c(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = BaseApplication.getContext().getSharedPreferences(paramString, 0).getBoolean(paramString + "troop_lucky_character_red_point_aio", true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "isShowLuckyCharacterRedPointInAIOSetting isShow = " + bool2);
    return bool2;
  }
  
  public int a(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("subaccount_sp", 0).getInt("subaccount_sp_version", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountVersion() ver=" + i);
    }
    return i;
  }
  
  public int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      i = j;
    }
    label19:
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return i;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
        i = j;
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      j = localSharedPreferences.getInt(paramString, 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, paramString + ":" + j);
    return j;
  }
  
  public TroopMemberCardInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      paramString1 = (TroopMemberCardInfo)paramQQAppInterface.find(TroopMemberCardInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.close();
    }
  }
  
  public TroopMemberInfo a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      paramString1 = (TroopMemberInfo)paramQQAppInterface.find(TroopMemberInfo.class, new String[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    finally
    {
      paramQQAppInterface.close();
    }
  }
  
  /* Error */
  public ArrayList<TroopMemberCardInfo> a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<friendlist.stUinInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +14 -> 15
    //   4: aload_3
    //   5: ifnull +10 -> 15
    //   8: aload_3
    //   9: invokevirtual 320	java/util/ArrayList:size	()I
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: new 317	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 321	java/util/ArrayList:<init>	()V
    //   24: astore 8
    //   26: aload_1
    //   27: invokevirtual 291	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   30: invokevirtual 297	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   33: astore 6
    //   35: aload 6
    //   37: invokevirtual 325	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: astore 7
    //   42: aload 7
    //   44: invokevirtual 330	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   47: iconst_0
    //   48: istore 4
    //   50: iload 4
    //   52: aload_3
    //   53: invokevirtual 320	java/util/ArrayList:size	()I
    //   56: if_icmpge +250 -> 306
    //   59: aload_3
    //   60: iload 4
    //   62: invokevirtual 333	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 335	friendlist/stUinInfo
    //   68: astore 9
    //   70: aload 6
    //   72: ldc_w 299
    //   75: iconst_2
    //   76: anewarray 276	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: aload_2
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: aload 9
    //   87: getfield 339	friendlist/stUinInfo:dwuin	J
    //   90: invokestatic 342	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   93: aastore
    //   94: invokevirtual 305	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   97: checkcast 299	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +164 -> 266
    //   105: iconst_1
    //   106: istore 5
    //   108: aload_1
    //   109: aload 9
    //   111: getfield 339	friendlist/stUinInfo:dwuin	J
    //   114: invokestatic 342	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   117: putfield 346	com/tencent/mobileqq/data/TroopMemberCardInfo:memberuin	Ljava/lang/String;
    //   120: aload_1
    //   121: aload_2
    //   122: putfield 349	com/tencent/mobileqq/data/TroopMemberCardInfo:troopuin	Ljava/lang/String;
    //   125: aload 9
    //   127: getfield 352	friendlist/stUinInfo:dwFlag	J
    //   130: lconst_1
    //   131: land
    //   132: lconst_0
    //   133: lcmp
    //   134: ifeq +12 -> 146
    //   137: aload_1
    //   138: aload 9
    //   140: getfield 355	friendlist/stUinInfo:sName	Ljava/lang/String;
    //   143: putfield 358	com/tencent/mobileqq/data/TroopMemberCardInfo:name	Ljava/lang/String;
    //   146: aload 9
    //   148: getfield 352	friendlist/stUinInfo:dwFlag	J
    //   151: ldc2_w 359
    //   154: land
    //   155: lconst_0
    //   156: lcmp
    //   157: ifeq +12 -> 169
    //   160: aload_1
    //   161: aload 9
    //   163: getfield 364	friendlist/stUinInfo:cGender	B
    //   166: putfield 367	com/tencent/mobileqq/data/TroopMemberCardInfo:sex	B
    //   169: aload 9
    //   171: getfield 352	friendlist/stUinInfo:dwFlag	J
    //   174: ldc2_w 368
    //   177: land
    //   178: lconst_0
    //   179: lcmp
    //   180: ifeq +12 -> 192
    //   183: aload_1
    //   184: aload 9
    //   186: getfield 372	friendlist/stUinInfo:sPhone	Ljava/lang/String;
    //   189: putfield 375	com/tencent/mobileqq/data/TroopMemberCardInfo:tel	Ljava/lang/String;
    //   192: aload 9
    //   194: getfield 352	friendlist/stUinInfo:dwFlag	J
    //   197: ldc2_w 376
    //   200: land
    //   201: lconst_0
    //   202: lcmp
    //   203: ifeq +12 -> 215
    //   206: aload_1
    //   207: aload 9
    //   209: getfield 380	friendlist/stUinInfo:sEmail	Ljava/lang/String;
    //   212: putfield 383	com/tencent/mobileqq/data/TroopMemberCardInfo:email	Ljava/lang/String;
    //   215: aload 9
    //   217: getfield 352	friendlist/stUinInfo:dwFlag	J
    //   220: ldc2_w 384
    //   223: land
    //   224: lconst_0
    //   225: lcmp
    //   226: ifeq +12 -> 238
    //   229: aload_1
    //   230: aload 9
    //   232: getfield 388	friendlist/stUinInfo:sRemark	Ljava/lang/String;
    //   235: putfield 391	com/tencent/mobileqq/data/TroopMemberCardInfo:memo	Ljava/lang/String;
    //   238: iload 5
    //   240: ifeq +40 -> 280
    //   243: aload 6
    //   245: aload_1
    //   246: invokevirtual 395	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   249: pop
    //   250: aload 8
    //   252: aload_1
    //   253: invokevirtual 399	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   256: pop
    //   257: iload 4
    //   259: iconst_1
    //   260: iadd
    //   261: istore 4
    //   263: goto -213 -> 50
    //   266: new 299	com/tencent/mobileqq/data/TroopMemberCardInfo
    //   269: dup
    //   270: invokespecial 400	com/tencent/mobileqq/data/TroopMemberCardInfo:<init>	()V
    //   273: astore_1
    //   274: iconst_0
    //   275: istore 5
    //   277: goto -169 -> 108
    //   280: aload 6
    //   282: aload_1
    //   283: invokevirtual 404	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   286: goto -36 -> 250
    //   289: astore_1
    //   290: aload_1
    //   291: invokevirtual 311	java/lang/Exception:printStackTrace	()V
    //   294: aload 7
    //   296: invokevirtual 407	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   299: aload 6
    //   301: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   304: aconst_null
    //   305: areturn
    //   306: aload 7
    //   308: invokevirtual 409	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   311: aload 7
    //   313: invokevirtual 407	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   316: aload 6
    //   318: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   321: aload 8
    //   323: areturn
    //   324: astore_1
    //   325: aload 7
    //   327: invokevirtual 407	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   330: aload 6
    //   332: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   335: aload_1
    //   336: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	bhdf
    //   0	337	1	paramQQAppInterface	QQAppInterface
    //   0	337	2	paramString	String
    //   0	337	3	paramArrayList	ArrayList<friendlist.stUinInfo>
    //   48	214	4	i	int
    //   106	170	5	j	int
    //   33	298	6	localEntityManager	EntityManager
    //   40	286	7	localEntityTransaction	EntityTransaction
    //   24	298	8	localArrayList	ArrayList
    //   68	163	9	localstUinInfo	friendlist.stUinInfo
    // Exception table:
    //   from	to	target	type
    //   42	47	289	java/lang/Exception
    //   50	101	289	java/lang/Exception
    //   108	146	289	java/lang/Exception
    //   146	169	289	java/lang/Exception
    //   169	192	289	java/lang/Exception
    //   192	215	289	java/lang/Exception
    //   215	238	289	java/lang/Exception
    //   243	250	289	java/lang/Exception
    //   250	257	289	java/lang/Exception
    //   266	274	289	java/lang/Exception
    //   280	286	289	java/lang/Exception
    //   306	311	289	java/lang/Exception
    //   42	47	324	finally
    //   50	101	324	finally
    //   108	146	324	finally
    //   146	169	324	finally
    //   169	192	324	finally
    //   192	215	324	finally
    //   215	238	324	finally
    //   243	250	324	finally
    //   250	257	324	finally
    //   266	274	324	finally
    //   280	286	324	finally
    //   290	294	324	finally
    //   306	311	324	finally
  }
  
  public Map<String, Integer> a(List<String> paramList, int paramInt, QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localHashMap;
    }
    if (paramQQAppInterface == null) {
      return localHashMap;
    }
    aocx localaocx;
    ArrayList localArrayList;
    for (;;)
    {
      String str1;
      try
      {
        localaocx = (aocx)paramQQAppInterface.getManager(QQManagerFactory.ROAM_SETTING_MANAGER);
        localArrayList = new ArrayList();
        int i = 0;
        if (i >= paramList.size()) {
          break;
        }
        str1 = (String)paramList.get(i);
        if ((str1 == null) || (str1.length() == 0))
        {
          i += 1;
          continue;
        }
        paramQQAppInterface = new StringBuilder(40);
      }
      catch (ClassCastException paramList)
      {
        paramList.printStackTrace();
        return localHashMap;
      }
      paramQQAppInterface.append("message.group.policy.");
      paramQQAppInterface.append(str1);
      String str2 = paramQQAppInterface.toString();
      RoamSetting localRoamSetting = localaocx.a(str2);
      paramQQAppInterface = localRoamSetting;
      if (localRoamSetting == null)
      {
        paramQQAppInterface = localRoamSetting;
        if (!TextUtils.isEmpty(str2))
        {
          paramQQAppInterface = new RoamSetting(str2, Integer.toString(paramInt));
          localArrayList.add(paramQQAppInterface);
        }
      }
      localHashMap.put(str1, Integer.valueOf(RoamSetting.getIntValue(paramQQAppInterface, paramInt)));
    }
    if (localArrayList.size() > 0) {
      this.a.a(new DBUtils.1(this, localArrayList, localaocx));
    }
    return localHashMap;
  }
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "saveGeneralSettingRevision=" + paramInt);
    }
    ((aocx)paramQQAppInterface.getManager(QQManagerFactory.ROAM_SETTING_MANAGER)).a(paramInt);
  }
  
  public void a(Context paramContext)
  {
    int i = arqj.a(paramContext);
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putInt("subaccount_sp_version", i).commit();
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setSubAccountVersion() ver=" + i);
    }
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = paramString + "subaccount_show_in_recentlist_first";
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Context paramContext)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while (paramString2 == null) {
      return;
    }
    paramString2 = paramContext.getSharedPreferences(paramString2, 0).edit();
    paramString1 = "message.group.policy." + paramString1;
    paramString2.remove(paramString1);
    paramString2.commit();
    ((aocx)paramQQAppInterface.getManager(QQManagerFactory.ROAM_SETTING_MANAGER)).a(paramString1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      paramInt += 1;
      localSharedPreferences.edit().putInt(paramString, paramInt).commit();
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "set " + paramString + "=" + paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      paramString = paramString + "bindQQAgain";
      localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "setShownAgainBindDialog() " + paramString + ":" + paramBoolean);
  }
  
  public void a(ArrayList<Setting> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    long l = 0L;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      QLog.d("RoamSetting", 2, "saveGeneralSettings setting start size = " + paramArrayList.size());
    }
    aocx localaocx = (aocx)paramQQAppInterface.getManager(QQManagerFactory.ROAM_SETTING_MANAGER);
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    String str;
    label175:
    int j;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        paramQQAppInterface = (Setting)paramArrayList.get(i);
        str = paramQQAppInterface.Path;
        paramQQAppInterface = paramQQAppInterface.Value;
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "saveGeneralSettings path =" + str + "; value = " + paramQQAppInterface);
        }
        if (str == null)
        {
          paramQQAppInterface = (QQAppInterface)localObject;
          i += 1;
          localObject = paramQQAppInterface;
        }
        else
        {
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0) && (!paramQQAppInterface.equalsIgnoreCase(""))) {
            break label520;
          }
          j = bhhi.a(str);
          if (j == 1) {
            paramQQAppInterface = String.valueOf(1);
          }
        }
      }
    }
    label520:
    for (;;)
    {
      label223:
      RoamSetting localRoamSetting = localaocx.a(str, paramQQAppInterface);
      if (localRoamSetting != null) {
        localArrayList.add(localRoamSetting);
      }
      if (("message.ring.switch".equals(str)) || ("message.vibrate.switch".equals(str)) || ("message.ring.care".equals(str)))
      {
        if (localObject == null) {
          localObject = localSharedPreferences.edit();
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              ((SharedPreferences.Editor)localObject).putString(str, paramQQAppInterface);
              paramQQAppInterface = (QQAppInterface)localObject;
            }
            catch (Exception paramQQAppInterface)
            {
              paramQQAppInterface.printStackTrace();
              paramQQAppInterface = (QQAppInterface)localObject;
            }
            break label175;
            if (j == 2)
            {
              paramQQAppInterface = String.valueOf(0);
              break label223;
            }
            if (j == 3)
            {
              paramQQAppInterface = String.valueOf(0);
              break label223;
            }
            if (j == 4)
            {
              paramQQAppInterface = "";
              break label223;
            }
            if (j == 5)
            {
              paramQQAppInterface = "";
              break label223;
            }
            if (j == 6)
            {
              paramQQAppInterface = String.valueOf(1);
              break label223;
            }
            if (j == 7)
            {
              paramQQAppInterface = String.valueOf(0);
              break label223;
            }
            paramQQAppInterface = "0";
            break label223;
            if (Looper.getMainLooper().getThread() == Thread.currentThread())
            {
              ThreadManager.post(new DBUtils.2(this, localaocx, localArrayList), 5, null, false);
              if (localObject == null) {}
            }
            try
            {
              ((SharedPreferences.Editor)localObject).commit();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DBUtils", 2, "GeneralSettings zsw saveGeneralSettings setting end, consume time =" + (System.currentTimeMillis() - l));
              return;
              localaocx.a(localArrayList);
            }
            catch (Exception paramArrayList)
            {
              for (;;)
              {
                paramArrayList.printStackTrace();
              }
            }
          }
        }
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      break label175;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().putBoolean("hasShowBindDialog", paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setHasShowBindDialog:" + paramBoolean);
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = localSharedPreferences.getBoolean("hasShowBindDialog", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "hasShowBindDialog:" + bool2);
    return bool2;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramString == null) {}
    do
    {
      return bool2;
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
      paramContext = paramContext.getSharedPreferences("subaccount_sp", 0);
      paramString = paramString + "subaccount_show_in_recentlist_first";
      if (localSharedPreferences.getBoolean(paramString, false))
      {
        localSharedPreferences.edit().remove(paramString).commit();
        paramContext.edit().putBoolean(paramString, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() update showedBefore:=true");
        }
      }
      if (localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false))
      {
        bool2 = localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false);
        localSharedPreferences.edit().remove("subaccount_is_top_in_recentlist").commit();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() remove isTopRU=" + bool2);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() isTop=" + bool1);
    return bool1;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, TroopMemberCardInfo paramTroopMemberCardInfo)
  {
    boolean bool = false;
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramTroopMemberCardInfo.getStatus() == 1000)
    {
      paramQQAppInterface.persistOrReplace(paramTroopMemberCardInfo);
      if (paramTroopMemberCardInfo.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramTroopMemberCardInfo.getStatus() != 1001) && (paramTroopMemberCardInfo.getStatus() != 1002)) {
      return bool;
    }
    return paramQQAppInterface.update(paramTroopMemberCardInfo);
  }
  
  public boolean a(String paramString)
  {
    if (((paramString == null) || (paramString.length() < 5)) && (QLog.isColorLevel())) {
      QLog.d("SUB_ACCOUNT", 2, "shownBindQQAgain() return.FALSE: mainUin=" + paramString);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramString = paramString + "bindQQAgain";
      bool2 = localSharedPreferences.getBoolean(paramString, false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "shownBindQQAgain() " + paramString + ":" + bool2);
    return bool2;
  }
  
  public Object[] a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = null;
    arrayOfObject[1] = Boolean.valueOf(false);
    if (paramArrayList == null) {
      return arrayOfObject;
    }
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    localEntityTransaction.begin();
    ArrayList localArrayList = new ArrayList();
    arrayOfObject[0] = localArrayList;
    int i = 0;
    label721:
    for (;;)
    {
      try
      {
        if (i < paramArrayList.size())
        {
          stTroopRemarkInfo localstTroopRemarkInfo = (stTroopRemarkInfo)paramArrayList.get(i);
          Object localObject = (TroopMemberCardInfo)localEntityManager.find(TroopMemberCardInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
          int j;
          if (localObject != null)
          {
            j = 1;
            ((TroopMemberCardInfo)localObject).email = localstTroopRemarkInfo.sEmail;
            ((TroopMemberCardInfo)localObject).memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
            ((TroopMemberCardInfo)localObject).memo = localstTroopRemarkInfo.sMemo;
            ((TroopMemberCardInfo)localObject).colorNick = bhmb.a(localstTroopRemarkInfo.sName.getBytes());
            if (((TroopMemberCardInfo)localObject).colorNick == null) {
              ((TroopMemberCardInfo)localObject).colorNick = localstTroopRemarkInfo.sName;
            }
            ((TroopMemberCardInfo)localObject).name = bhmb.b(((TroopMemberCardInfo)localObject).colorNick);
            ((TroopMemberCardInfo)localObject).nick = localstTroopRemarkInfo.strNick;
            ((TroopMemberCardInfo)localObject).sex = localstTroopRemarkInfo.cGender;
            ((TroopMemberCardInfo)localObject).tel = localstTroopRemarkInfo.sPhone;
            ((TroopMemberCardInfo)localObject).troopuin = paramString;
            ((TroopMemberCardInfo)localObject).level = localstTroopRemarkInfo.strRank;
            ((TroopMemberCardInfo)localObject).job = localstTroopRemarkInfo.bytes_job;
            ((TroopMemberCardInfo)localObject).charm = ((int)localstTroopRemarkInfo.GlamourLevel);
            ((TroopMemberCardInfo)localObject).torchFlag = ((int)localstTroopRemarkInfo.TorchbearerFlag);
            if (j != 0)
            {
              localEntityManager.update((Entity)localObject);
              localArrayList.add(localObject);
              j = bgek.a(localstTroopRemarkInfo.vecGroupHonor);
              TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localEntityManager.find(TroopMemberInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
              if (localTroopMemberInfo == null) {
                break label721;
              }
              localTroopMemberInfo.troopColorNick = ((TroopMemberCardInfo)localObject).colorNick;
              localTroopMemberInfo.troopnick = ((TroopMemberCardInfo)localObject).name;
              localTroopMemberInfo.friendnick = localstTroopRemarkInfo.strNick;
              localTroopMemberInfo.memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
              localTroopMemberInfo.sex = localstTroopRemarkInfo.cGender;
              localTroopMemberInfo.troopuin = paramString;
              localTroopMemberInfo.mGlamourLevel = ((int)localstTroopRemarkInfo.GlamourLevel);
              localTroopMemberInfo.mVipType = ((TroopMemberCardInfo)localObject).mVipType;
              localTroopMemberInfo.mVipLevel = ((TroopMemberCardInfo)localObject).mVipLevel;
              localTroopMemberInfo.newRealLevel = j;
              if ((localstTroopRemarkInfo.strRank != null) && (localstTroopRemarkInfo.strRank.length() > 0))
              {
                localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (localObject != null)
                {
                  localObject = ((TroopManager)localObject).b(paramString);
                  if (localObject != null)
                  {
                    localObject = ((TroopInfo)localObject).getTroopLevelMap();
                    if (localObject != null)
                    {
                      Iterator localIterator = ((ConcurrentHashMap)localObject).keySet().iterator();
                      if (localIterator.hasNext())
                      {
                        Integer localInteger = (Integer)localIterator.next();
                        if (!localstTroopRemarkInfo.strRank.equals(((ConcurrentHashMap)localObject).get(localInteger))) {
                          continue;
                        }
                        localTroopMemberInfo.realLevel = localInteger.intValue();
                      }
                    }
                  }
                }
              }
              localEntityManager.update(localTroopMemberInfo);
              break label721;
            }
          }
          else
          {
            localObject = new TroopMemberCardInfo();
            j = 0;
            continue;
          }
          localEntityManager.persist((Entity)localObject);
          continue;
        }
        i += 1;
      }
      catch (Exception paramQQAppInterface)
      {
        arrayOfObject[1] = Boolean.valueOf(false);
        if (QLog.isColorLevel()) {
          QLog.e("handlerGetTroopMemberCardInfoList()", 2, paramQQAppInterface.toString());
        }
        localEntityTransaction.end();
        localEntityManager.close();
        if (QLog.isColorLevel()) {
          QLog.d("handlerGetTroopMemberCardInfoList", 2, "insertTroopMemberCardList bRet = " + arrayOfObject[1]);
        }
        return arrayOfObject;
        arrayOfObject[1] = Boolean.valueOf(true);
        localEntityTransaction.commit();
        localEntityTransaction.end();
        localEntityManager.close();
      }
      finally
      {
        localEntityTransaction.end();
        localEntityManager.close();
      }
    }
  }
  
  public boolean b(Context paramContext, String paramString)
  {
    paramString = paramString + "subaccount_show_in_recentlist_first";
    return paramContext.getSharedPreferences("subaccount_sp", 0).getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdf
 * JD-Core Version:    0.7.0.1
 */