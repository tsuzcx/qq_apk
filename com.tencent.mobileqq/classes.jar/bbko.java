import MessageSvcPack.stConfNumInfo;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bbko
{
  public static int a;
  public static bbkt a;
  private static String jdField_a_of_type_JavaLangString = "Q.msg.MessageCache";
  public static boolean a;
  public static int b;
  public static HashMap<String, bbkq> b;
  private ConcurrentHashMap<String, byte[]> A = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> B = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> C = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> D = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> E = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> F = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> G = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> H = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> I = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> J = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> K = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> L = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> M = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> N = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> O = new ConcurrentHashMap();
  private ConcurrentHashMap<Pair<String, Integer>, Long> P = new ConcurrentHashMap();
  private ConcurrentHashMap<Pair<String, Integer>, Long> Q = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Set<Integer>>> R = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, HashSet<Long>>> S = new ConcurrentHashMap();
  private ConcurrentHashMap<String, MessageRecord> T = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> U = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> V = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> W = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> X = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> Y = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> Z = new ConcurrentHashMap();
  private long jdField_a_of_type_Long = -1L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private bbkp jdField_a_of_type_Bbkp;
  public bbku a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<Long, MessageForPoke> a;
  public List<MessageRecord> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  public ConcurrentHashMap<String, String> a;
  public AtomicInteger a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private ConcurrentHashMap<String, byte[]> aa = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ab = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> ac = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> ad = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<Object[]>> ae = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, ArrayList<msg_comm.Msg>> af = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, ArrayList<msg_comm.Msg>> ag = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> ah = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<Object[]>> ai = new ConcurrentHashMap();
  private ConcurrentHashMap<String, DisMsgReadedNotify> aj = new ConcurrentHashMap();
  private ConcurrentHashMap<String, GroupMsgReadedNotify> ak = new ConcurrentHashMap();
  private ConcurrentHashMap<String, AppShareID> al = new ConcurrentHashMap();
  private ConcurrentHashMap<String, OpenID> am = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object> an = new ConcurrentHashMap();
  private long jdField_b_of_type_Long;
  private MessageRecord jdField_b_of_type_ComTencentMobileqqDataMessageRecord;
  private ArrayList<stConfNumInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap<Long, Object[]> b;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, ArrayList<String>> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public ConcurrentHashMap<String, String> c;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  public ConcurrentHashMap<String, Long> d;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  public ConcurrentHashMap<String, Long> e;
  public ConcurrentHashMap<String, Set<String>> f = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Long> g = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object[]> i = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object[]> j = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> k = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> l = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> m = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> n = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> o = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> p = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Pair<Long, Long>> q = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Pair<Long, Long>> r = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, bbkr>> s = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, bbkr>> t = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> u = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<Integer>> v = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> w = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> x = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> y = new ConcurrentHashMap();
  private ConcurrentHashMap<String, byte[]> z = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Int = 3;
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Int = 259200;
  }
  
  public bbko(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_Int = -1;
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    this.jdField_a_of_type_Bbkp = new bbkp(this);
    jdField_a_of_type_Boolean = false;
  }
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  private String a(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    if (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1) {
        localStringBuilder.append(paramList.get(i1) + "|");
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append(paramList.get(i1));
      }
    }
    return localStringBuilder.toString();
  }
  
  private List<Integer> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString == null) || (paramString.length() == 0)) {
      return localArrayList;
    }
    paramString = paramString.split("\\|");
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramString[i1];
      try
      {
        localArrayList.add(Integer.valueOf(str));
        label59:
        i1 += 1;
      }
      catch (Exception localException)
      {
        break label59;
      }
    }
  }
  
  private void i(String paramString, long paramLong)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.putLong("deleteFriendMsgTime" + paramString, paramLong);
    }
  }
  
  public static void j()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
    {
      localObject1 = (QQAppInterface)localObject1;
      Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences(((QQAppInterface)localObject1).getCurrentAccountUin(), 0);
      localObject1 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject1).remove("getMsgV4_vSyncCookie");
      ((SharedPreferences.Editor)localObject1).remove("getlastMessageTime");
      ((SharedPreferences.Editor)localObject1).remove("getMsgV4_vPubAccountCookie");
      ((SharedPreferences.Editor)localObject1).remove("getTroopDiscMsgLastTime");
      localObject2 = ((SharedPreferences)localObject2).getAll().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Map.Entry)((Iterator)localObject2).next()).getKey();
        if ((!TextUtils.isEmpty(str)) && ((str.startsWith("getTroopLastMessageTime")) || (str.startsWith("getDiscussionLastMessageTime")))) {
          ((SharedPreferences.Editor)localObject1).remove(str);
        }
      }
      ((SharedPreferences.Editor)localObject1).commit();
      QLog.e(jdField_a_of_type_JavaLangString, 1, "clearAllMsgSyncFlags");
    }
  }
  
  public int a()
  {
    if (this.jdField_d_of_type_Int == -1) {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("DS_SEND_KEY", 0);
    }
    this.jdField_d_of_type_Int += 1;
    this.jdField_a_of_type_Bbkp.putInt("DS_SEND_KEY", this.jdField_d_of_type_Int);
    return this.jdField_d_of_type_Int;
  }
  
  public int a(String paramString)
  {
    if (!this.ad.containsKey(paramString)) {
      this.ad.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.ad.get(paramString)).intValue();
  }
  
  public int a(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt).iterator();
    for (paramInt = 0; paramString.hasNext(); paramInt = Math.max(((Integer)paramString.next()).intValue(), paramInt)) {}
    return paramInt + 1;
  }
  
  public long a(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {}
    long l1;
    do
    {
      return -1L;
      paramString = str + "_noticetime_" + paramString;
      if (this.g.containsKey(paramString)) {
        break;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(str + "birth", 0).getLong(paramString, -1L);
    } while (l1 == -1L);
    this.g.put(paramString, Long.valueOf(l1));
    return ((Long)this.g.get(paramString)).longValue();
  }
  
  public long a(String paramString, int paramInt)
  {
    String str = abwz.a(paramString, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + 0);
      }
      return 0L;
    }
    if (!this.M.containsKey(str))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDelMsgLastSeq" + str, 0L);
      this.M.put(str, Long.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + l1);
      }
    }
    return ((Long)this.M.get(str)).longValue();
  }
  
  public DisMsgReadedNotify a(String paramString)
  {
    return (DisMsgReadedNotify)this.aj.remove(paramString);
  }
  
  public GroupMsgReadedNotify a(String paramString)
  {
    return (GroupMsgReadedNotify)this.ak.remove(paramString);
  }
  
  public Pair<Long, Long> a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      localObject = null;
    }
    Pair localPair;
    do
    {
      return localObject;
      localPair = (Pair)this.q.get(paramString);
      localObject = localPair;
    } while (localPair != null);
    Object localObject = new Pair(Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDisscussionInfoSeq" + paramString, 0L)), Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDisscussionInfoLastTime" + paramString, 0L)));
    this.q.put(paramString, localObject);
    return localObject;
  }
  
  public bbku a()
  {
    if (this.jdField_a_of_type_Bbku == null) {
      this.jdField_a_of_type_Bbku = new bbku(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1026, "hctopic", this.jdField_a_of_type_AndroidContentSharedPreferences, this.jdField_a_of_type_Bbkp);
    }
    return this.jdField_a_of_type_Bbku;
  }
  
  public AppShareID a(String paramString)
  {
    if (!this.al.containsKey(paramString))
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      AppShareID localAppShareID = (AppShareID)localEntityManager.find(AppShareID.class, "strPkgName=?", new String[] { paramString });
      if (localAppShareID != null)
      {
        a(paramString, localAppShareID);
        if (QLog.isColorLevel()) {
          QLog.d("share_appid", 2, "Add cache from db appid = " + paramString);
        }
        localEntityManager.close();
      }
    }
    for (;;)
    {
      if (this.al.get(paramString) != bftp.a) {
        break label187;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Not exist in db appid = " + paramString);
      }
      a(paramString, bftp.a);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Already in cache appid = " + paramString);
      }
    }
    label187:
    return (AppShareID)this.al.get(paramString);
  }
  
  public MessageRecord a(int paramInt, String paramString, long paramLong)
  {
    paramString = String.valueOf(paramInt) + "_" + paramString + "_" + paramLong;
    MessageRecord localMessageRecord = (MessageRecord)this.T.get(paramString);
    this.T.remove(paramString);
    return localMessageRecord;
  }
  
  public OpenID a(String paramString)
  {
    if (!this.am.containsKey(paramString))
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      OpenID localOpenID = (OpenID)localEntityManager.find(OpenID.class, paramString);
      if (localOpenID != null)
      {
        a(paramString, localOpenID);
        if (QLog.isColorLevel()) {
          QLog.d("openid", 2, "Add cache from db appid = " + paramString);
        }
      }
      localEntityManager.close();
    }
    for (;;)
    {
      return (OpenID)this.am.get(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("openid", 2, "Already in cache appid = " + paramString + ",openid=" + ((OpenID)this.am.get(paramString)).openID);
      }
    }
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public ArrayList<msg_comm.Msg> a(long paramLong)
  {
    return (ArrayList)this.af.get(Long.valueOf(paramLong));
  }
  
  public ArrayList<Object[]> a(String paramString)
  {
    return (ArrayList)this.ae.get(paramString);
  }
  
  public List<Integer> a(String paramString, int paramInt)
  {
    String str = abwz.a(paramString, paramInt);
    if (!this.v.containsKey(str))
    {
      paramString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("getLongMsgIdArray" + abwz.a(paramString, paramInt), "");
      this.v.put(str, a(paramString));
    }
    return (List)this.v.get(str);
  }
  
  public Map<String, Set<Integer>> a(String paramString, int paramInt)
  {
    synchronized (this.R)
    {
      paramString = abwz.a(paramString, paramInt);
      if ((this.R.containsKey(paramString)) && (this.R.get(paramString) != null))
      {
        Map localMap = (Map)this.R.get(paramString);
        if ((localMap != null) && (localMap.isEmpty()))
        {
          this.R.remove(paramString);
          return null;
        }
        return localMap;
      }
    }
    return null;
  }
  
  public Set<String> a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {}
    Set localSet;
    do
    {
      return null;
      if (this.f.containsKey(str)) {
        break;
      }
      localSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(str + "birth", 0).getStringSet(str + "_list", null);
    } while (localSet == null);
    this.f.put(str, localSet);
    return (Set)this.f.get(str);
  }
  
  public ConcurrentHashMap<String, Integer> a()
  {
    return this.ad;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "clearDiscNumInfoCache");
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Bbkp.putInt("getlastMessageTime", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>setBuddyMsgLastSeq lastseq = " + paramInt);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.af.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    Object localObject2 = (ArrayList)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    Object localObject1 = localObject2;
    long l1;
    long l2;
    long l3;
    if (localObject2 == null) {
      if (this.jdField_c_of_type_JavaUtilHashMap.size() >= 20)
      {
        localObject1 = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
        l1 = 0L;
        if (!((Iterator)localObject1).hasNext()) {
          break label232;
        }
        l2 = ((Long)((Iterator)localObject1).next()).longValue();
        l3 = Long.parseLong((String)((ArrayList)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(l2))).get(0));
        if (paramLong2 - l3 <= 300L) {
          break label202;
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilHashMap.remove(Long.valueOf(l2));
      localObject1 = new ArrayList();
      if (((ArrayList)localObject1).size() >= 20) {
        ((ArrayList)localObject1).remove(0);
      }
      localObject2 = Long.toString(paramLong2);
      if (((ArrayList)localObject1).size() == 0)
      {
        ((ArrayList)localObject1).add(localObject2);
        label180:
        ((ArrayList)localObject1).add(paramString);
        this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localObject1);
        return;
        label202:
        if (l3 >= paramLong2) {
          break label229;
        }
        l1 = l2;
      }
      label229:
      for (;;)
      {
        break;
        ((ArrayList)localObject1).set(0, localObject2);
        break label180;
      }
      label232:
      l2 = l1;
    }
  }
  
  public void a(long paramLong, List<msg_comm.Msg> paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.af.get(Long.valueOf(paramLong));
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.addAll(paramList);
    this.af.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      String str;
      synchronized (this.R)
      {
        if (!paramMessageRecord.isLongMsg()) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addOnlineLongMsgFragment longid=" + paramMessageRecord.getLongMsgInfoString());
        }
        localObject = abwz.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        str = abwz.b(paramMessageRecord);
        if ((this.R.containsKey(localObject)) && (this.R.get(localObject) != null))
        {
          localConcurrentHashMap1 = (ConcurrentHashMap)this.R.get(localObject);
          if (!localConcurrentHashMap1.containsKey(str)) {
            break label195;
          }
          localObject = (Set)localConcurrentHashMap1.get(str);
          ((Set)localObject).add(Integer.valueOf(paramMessageRecord.longMsgIndex));
          if (paramMessageRecord.longMsgCount <= ((Set)localObject).size()) {
            localConcurrentHashMap1.remove(str);
          }
          return;
        }
      }
      ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
      this.R.put(localObject, localConcurrentHashMap1);
      continue;
      label195:
      Object localObject = new HashSet();
      ((Set)localObject).add(Integer.valueOf(paramMessageRecord.longMsgIndex));
      localConcurrentHashMap1.put(str, localObject);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    String str = abwz.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    Object localObject1 = new bbkr(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, System.currentTimeMillis());
    ((bbkr)localObject1).jdField_b_of_type_Int = paramInt;
    if (this.s.containsKey(str))
    {
      localObject2 = (ConcurrentHashMap)this.s.get(str);
      if (localObject2 != null) {
        ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      }
    }
    for (;;)
    {
      if (paramMessageRecord.isLongMsg())
      {
        if (!this.S.containsKey(str)) {
          break label288;
        }
        if (!((ConcurrentHashMap)this.S.get(str)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId))) {
          break;
        }
        ((HashSet)((ConcurrentHashMap)this.S.get(str)).get(Integer.valueOf(paramMessageRecord.longMsgId))).add(Long.valueOf(paramMessageRecord.uniseq));
      }
      return;
      localObject2 = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      this.s.put(str, localObject2);
      continue;
      localObject2 = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      this.s.put(str, localObject2);
    }
    localObject1 = new HashSet();
    ((HashSet)localObject1).add(Long.valueOf(paramMessageRecord.uniseq));
    ((ConcurrentHashMap)this.S.get(str)).put(Integer.valueOf(paramMessageRecord.longMsgId), localObject1);
    return;
    label288:
    localObject1 = new ConcurrentHashMap();
    Object localObject2 = new HashSet();
    ((HashSet)localObject2).add(Long.valueOf(paramMessageRecord.uniseq));
    ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramMessageRecord.longMsgId), localObject2);
    this.S.put(str, localObject1);
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.ad.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setTroopMsgResponseState state: " + paramString + " state: " + paramInt);
      }
      if (paramInt == 2) {
        f(paramString);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1).add(Integer.valueOf(paramInt2));
    if (a(paramString, paramInt1).size() > 50)
    {
      paramInt2 = 0;
      while (paramInt2 < 10)
      {
        a(paramString, paramInt1).remove(0);
        paramInt2 += 1;
      }
    }
    this.jdField_a_of_type_Bbkp.putString("getLongMsgIdArray" + abwz.a(paramString, paramInt1), a(a(paramString, paramInt1))).commit();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    label660:
    label663:
    label673:
    label688:
    label694:
    for (;;)
    {
      long l1;
      HashMap localHashMap;
      int i6;
      int i5;
      try
      {
        l1 = System.nanoTime();
        localHashMap = new HashMap();
        localHashMap.put("isFirstOpen", String.valueOf(paramInt3));
        Object localObject = abwz.a(paramString, paramInt1);
        if ((jdField_b_of_type_JavaUtilHashMap != null) && (jdField_b_of_type_JavaUtilHashMap.containsKey(localObject)))
        {
          localObject = (bbkq)jdField_b_of_type_JavaUtilHashMap.get(localObject);
          localHashMap.put("isInited", String.valueOf(((bbkq)localObject).jdField_a_of_type_Boolean));
          localHashMap.put("isMsgExisted", String.valueOf(((bbkq)localObject).jdField_b_of_type_Boolean));
          localHashMap.put("msgCostTime", String.valueOf(((bbkq)localObject).jdField_a_of_type_Long));
          if (paramInt1 != 1) {
            break label688;
          }
          i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramString);
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramString, paramInt1);
          if (paramString == null) {
            break label673;
          }
          i3 = paramString.jdField_a_of_type_Int;
          i2 = paramString.jdField_b_of_type_Int;
          i4 = paramString.jdField_c_of_type_Int;
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).a().b();
          i6 = 0;
          paramInt3 = 0;
          localObject = paramString.keySet();
          if ((localObject == null) || (((Set)localObject).size() <= 0)) {
            break label663;
          }
          i5 = ((Set)localObject).size();
          localObject = ((Set)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (paramString.get(str) == null) {
              break label660;
            }
            paramInt3 = ((List)paramString.get(str)).size() + paramInt3;
            break label694;
          }
        }
        else
        {
          localHashMap.put("isInited", "true");
          localHashMap.put("isMsgExisted", "true");
          localHashMap.put("msgCostTime", "0");
          continue;
        }
        localHashMap.put("uintype", String.valueOf(paramInt1));
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      for (;;)
      {
        localHashMap.put("recentLoc", String.valueOf(i3));
        localHashMap.put("activeConvLoc", String.valueOf(i2));
        localHashMap.put("convCount", String.valueOf(i4));
        localHashMap.put("msgFrom", String.valueOf(paramInt2));
        localHashMap.put("troopSpeType", String.valueOf(i1));
        localHashMap.put("msgCacheSize", String.valueOf(paramInt3));
        localHashMap.put("cacheSize", String.valueOf(i5));
        localHashMap.put("isCacheExpired", String.valueOf(jdField_a_of_type_Boolean));
        long l2 = Runtime.getRuntime().freeMemory() / 1024L / 1024L;
        long l3 = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
        long l4 = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
        localHashMap.put("freeMemory", String.valueOf(l2));
        localHashMap.put("totalMemory", String.valueOf(l3));
        localHashMap.put("maxMemory", String.valueOf(l4));
        localHashMap.put("cacheVersion", "2");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "msg_cache_strategy_tag", true, bfzg.jdField_a_of_type_Long, 0L, localHashMap, "");
        if (QLog.isColorLevel())
        {
          l2 = System.nanoTime();
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "AIOTime reportMsgCacheStrategy cost:%d ", Long.valueOf((l2 - l1) / 1000000L), " param: ", localHashMap });
        }
        if ((i4 - 5 <= i5) || (i5 >= 40)) {
          break;
        }
        return;
        break label694;
        i5 = 0;
        paramInt3 = i6;
      }
      int i4 = -2;
      int i2 = -2;
      int i3 = -2;
      continue;
      int i1 = 1;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (paramInt == 1) {
      paramLong = Math.max(paramLong, b(paramString));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + paramLong);
      }
      this.M.put(abwz.a(paramString, paramInt), Long.valueOf(Math.max(paramLong, a(paramString, paramInt))));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
        this.jdField_a_of_type_Bbkp.putLong("getDelMsgLastSeq" + abwz.a(paramString, paramInt), paramLong).commit();
      }
      return;
      if (paramInt == 3000)
      {
        paramLong = Math.max(paramLong, h(paramString));
      }
      else
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(paramString, paramInt);
        long l1 = paramLong;
        if (localList != null)
        {
          l1 = paramLong;
          if (!localList.isEmpty()) {
            l1 = Math.max(paramLong, ((MessageRecord)localList.get(localList.size() - 1)).time);
          }
        }
        b(paramString, 0L, 0L);
        paramLong = l1;
        if (paramInt == 0)
        {
          i(paramString, NetConnInfoCenter.getServerTimeMillis());
          paramLong = l1;
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.R)
    {
      paramString1 = a(paramString1, paramInt);
      if (paramString1 == null) {
        return;
      }
      if (paramString1.containsKey(paramString2)) {
        paramString1.remove(paramString2);
      }
      return;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, b(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addGroupMsgLastSeq " + paramLong);
    }
    this.h.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.putLong("getTroopLastMessageTime" + paramString, paramLong);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.q.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Bbkp.putLong("getDisscussionInfoSeq" + paramString, paramLong1);
      this.jdField_a_of_type_Bbkp.putLong("getDisscussionInfoLastTime" + paramString, paramLong2);
    }
  }
  
  public void a(String paramString, DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    this.aj.put(paramString, paramDisMsgReadedNotify);
  }
  
  public void a(String paramString, GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    this.ak.put(paramString, paramGroupMsgReadedNotify);
  }
  
  public void a(String paramString, AppShareID paramAppShareID)
  {
    this.al.put(paramString, paramAppShareID);
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "add share appid to cache = " + paramString);
    }
  }
  
  public void a(String paramString, OpenID paramOpenID)
  {
    this.am.put(paramString, paramOpenID);
    if (QLog.isColorLevel()) {
      QLog.d("openid", 2, "add openid to cache = " + paramOpenID);
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      paramString1 = paramString1 + "_" + paramString2;
      try
      {
        paramString2 = (byte[])this.W.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "confess_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.W.remove(paramString1);
          paramString2.remove(paramString1);
        }
        for (;;)
        {
          paramString2.commit();
          return;
          this.W.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString1) {}
    }
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap;
    if (paramBoolean)
    {
      localConcurrentHashMap = this.Y;
      label26:
      paramString2 = paramString1 + "_" + paramString2;
    }
    for (;;)
    {
      try
      {
        paramString1 = (byte[])localConcurrentHashMap.get(paramString2);
        if (((paramString1 != null) && (Arrays.equals(paramString1, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          break;
        }
        BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
        StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("MatchChat");
        if (!paramBoolean) {
          break label190;
        }
        paramString1 = "";
        paramString1 = localBaseApplication.getSharedPreferences(paramString1, 0).edit();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
          break label197;
        }
        localConcurrentHashMap.remove(paramString2);
        paramString1.remove(paramString2);
        paramString1.commit();
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      localConcurrentHashMap = this.Z;
      break label26;
      label190:
      paramString1 = "_campus";
      continue;
      label197:
      localConcurrentHashMap.put(paramString2, paramArrayOfByte);
      paramString1.putString(paramString2, PkgTools.toHexStr(paramArrayOfByte));
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addWpaMsgKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + HexUtil.bytes2HexStr(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.w.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte)))
    {
      this.w.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        paramArrayOfByte = HexUtil.bytes2HexStr(paramArrayOfByte);
        this.jdField_a_of_type_Bbkp.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.ae.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.ae.put(paramString, localArrayList1);
  }
  
  public void a(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    Object localObject1 = (RevokeMsgInfo)paramArrayList.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "RevokeNotifyCache, add cache, " + ((RevokeMsgInfo)localObject1).toString());
    }
    int i2 = ((RevokeMsgInfo)localObject1).jdField_a_of_type_Int;
    Object localObject2 = ((RevokeMsgInfo)localObject1).jdField_a_of_type_JavaLangString;
    int i1;
    if (((RevokeMsgInfo)localObject1).jdField_c_of_type_Int > 1)
    {
      i1 = 1;
      if (i1 == 0) {
        break label254;
      }
      localObject1 = String.format("%s&%d&%d&%d", new Object[] { localObject2, Integer.valueOf(i2), Integer.valueOf(((RevokeMsgInfo)localObject1).jdField_b_of_type_Int), Integer.valueOf(((RevokeMsgInfo)localObject1).jdField_c_of_type_Int) });
    }
    for (;;)
    {
      label121:
      if (this.u.containsKey(localObject1))
      {
        localObject1 = (ArrayList)this.u.get(localObject1);
        localObject2 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        for (;;)
        {
          if (paramArrayList.hasNext())
          {
            RevokeMsgInfo localRevokeMsgInfo1 = (RevokeMsgInfo)paramArrayList.next();
            Iterator localIterator = ((ArrayList)localObject1).iterator();
            RevokeMsgInfo localRevokeMsgInfo2;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localRevokeMsgInfo2 = (RevokeMsgInfo)localIterator.next();
            } while ((localRevokeMsgInfo1.jdField_a_of_type_Long != localRevokeMsgInfo2.jdField_a_of_type_Long) || (localRevokeMsgInfo1.jdField_b_of_type_Long != localRevokeMsgInfo2.jdField_b_of_type_Long));
            ((ArrayList)localObject2).add(localRevokeMsgInfo1);
            continue;
            i1 = 0;
            break;
            label254:
            localObject1 = String.format("%s&%d&%d", new Object[] { localObject2, Integer.valueOf(i2), Long.valueOf(((RevokeMsgInfo)localObject1).jdField_a_of_type_Long) });
            break label121;
          }
        }
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        return;
      }
    }
    this.u.put(localObject1, paramArrayList);
  }
  
  /* Error */
  public void a(List<stConfNumInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 567	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +42 -> 47
    //   8: getstatic 121	bbko:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: astore_3
    //   12: new 359	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1048
    //   22: invokevirtual 377	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: astore 4
    //   27: aload_1
    //   28: ifnonnull +31 -> 59
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_3
    //   34: iconst_2
    //   35: aload 4
    //   37: iload_2
    //   38: invokevirtual 574	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: invokevirtual 380	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 578	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: getfield 160	bbko:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: aload_1
    //   52: invokevirtual 743	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   55: pop
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_1
    //   60: invokeinterface 364 1 0
    //   65: istore_2
    //   66: goto -33 -> 33
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bbko
    //   0	74	1	paramList	List<stConfNumInfo>
    //   32	34	2	i1	int
    //   11	23	3	str	String
    //   25	11	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	27	69	finally
    //   33	47	69	finally
    //   47	56	69	finally
    //   59	66	69	finally
  }
  
  public void a(Set<String> paramSet)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (paramSet != null))
    {
      this.f.put(str, paramSet);
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(str + "birth", 0).edit();
      localEditor.putStringSet(str + "_list", paramSet);
      localEditor.apply();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      String str = HexUtil.bytes2HexStr(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>setLastSyncCookie lastSyncCookie:" + str);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>setBuddyMsgLastSeq cookie = " + HexUtil.bytes2HexStr(paramArrayOfByte));
      }
      this.jdField_a_of_type_Bbkp.putString("getMsgV4_vSyncCookie", str);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("removeDiscPullSeqCache, uinArray: ");
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        localStringBuilder.append(str).append(",");
        if (this.o.containsKey(str)) {
          this.o.remove(str);
        }
        i1 += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isDiscPullSeqFinish size = " + this.o.size());
    }
    return this.o.isEmpty();
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    paramString = String.valueOf(paramInt) + "_" + paramString + "_" + paramLong;
    return this.T.containsKey(paramString);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    Object localObject = (ArrayList)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    ((Iterator)localObject).next();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals((String)((Iterator)localObject).next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop, abwz.b(paramMessageRecord));
  }
  
  public boolean a(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      return this.jdField_a_of_type_AndroidContentSharedPreferences.contains("deleteFriendMsgTime" + paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a(paramString, paramInt1).iterator();
    while (localIterator.hasNext()) {
      if (((Integer)localIterator.next()).intValue() == paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "long msg id is exist! uin=" + paramString + ",istroop=" + paramInt1 + ",longMsgID=" + paramInt2);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgSend", 2, String.format("removeSendingCache key = %d %s %d", new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt) }));
    }
    paramString = abwz.a(paramString, paramInt);
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if (this.s.containsKey(paramString))
    {
      localObject1 = (ConcurrentHashMap)this.s.get(paramString);
      if (localObject1 != null)
      {
        localObject2 = (bbkr)((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramLong));
        if ((localObject2 != null) && (((bbkr)localObject2).jdField_b_of_type_Long > 0L))
        {
          long l1 = System.currentTimeMillis() - ((bbkr)localObject2).jdField_b_of_type_Long;
          if ((l1 < MessageHandler.jdField_e_of_type_Int) && (l1 > 0L))
          {
            bool1 = false;
            bool2 = bool1;
            if (localObject1 != null)
            {
              bool2 = bool1;
              if (((ConcurrentHashMap)localObject1).isEmpty()) {
                this.s.remove(paramString);
              }
            }
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((!d()) && (this.t.containsKey(paramString)))
      {
        localObject1 = (ConcurrentHashMap)this.t.get(paramString);
        if (localObject1 != null) {
          ((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramLong));
        }
        if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).isEmpty())) {
          this.t.remove(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "msgSending:delete result in messageSendingTemp " + this.t);
        }
      }
      int i1;
      if (this.S.containsKey(paramString))
      {
        int i2 = 0;
        localObject1 = ((ConcurrentHashMap)this.S.get(paramString)).keySet().iterator();
        do
        {
          paramInt = i2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          i1 = ((Integer)((Iterator)localObject1).next()).intValue();
          localObject2 = (Set)((ConcurrentHashMap)this.S.get(paramString)).get(Integer.valueOf(i1));
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("removeSendingCache  longMsgFragmentSet = %s", new Object[] { localObject2 }));
          }
        } while (!((Set)localObject2).contains(Long.valueOf(paramLong)));
        ((Set)localObject2).remove(Long.valueOf(paramLong));
        if (!((Set)localObject2).isEmpty()) {
          break label501;
        }
      }
      label501:
      for (paramInt = i1;; paramInt = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeSendingCache uniseq=" + paramLong + "longid=" + i1);
        }
        for (;;)
        {
          if (paramInt != 0) {
            ((ConcurrentHashMap)this.S.get(paramString)).remove(Integer.valueOf(paramInt));
          }
          return bool2;
        }
      }
      bool1 = true;
      break;
    }
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.R)
    {
      paramString1 = a(paramString1, paramInt);
      if (paramString1 == null) {
        return false;
      }
      if (paramString1.containsKey(paramString2))
      {
        if (((Set)paramString1.get(paramString2)).isEmpty())
        {
          paramString1.remove(paramString2);
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilSet.size() == 0) {
      return false;
    }
    paramString = paramString + "_" + paramLong1 + "_" + paramLong2;
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("getRegPrxyFailFlag", false);
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  public byte[] a()
  {
    String str;
    if (((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null))
    {
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("getMsgV4_vSyncCookie", "");
      if (str.length() != 0) {
        break label97;
      }
    }
    label97:
    for (this.jdField_a_of_type_ArrayOfByte = null;; this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>getLastSyncCookie lastSyncCookie:" + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      }
      return this.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  public byte[] a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.B.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "pub", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.hexToBytes((String)localObject);
    this.B.put(paramString, localObject);
    return (byte[])this.B.get(paramString);
  }
  
  public byte[] a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.W.containsKey(paramString1))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "confess_sig", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = PkgTools.hexToBytes(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.W.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.W.get(paramString1);
    }
    return null;
  }
  
  public byte[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    ConcurrentHashMap localConcurrentHashMap;
    BaseApplication localBaseApplication;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localConcurrentHashMap = this.Y;
      paramString2 = paramString1 + "_" + paramString2;
      if (localConcurrentHashMap.containsKey(paramString2)) {
        break label182;
      }
      localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("MatchChat");
      if (!paramBoolean) {
        break label175;
      }
    }
    label175:
    for (paramString1 = "";; paramString1 = "_campus")
    {
      paramString1 = localBaseApplication.getSharedPreferences(paramString1, 0).getString(paramString2, null);
      if (TextUtils.isEmpty(paramString1)) {
        break label192;
      }
      paramString1 = PkgTools.hexToBytes(paramString1);
      if ((paramString1 == null) || (paramString1.length <= 0)) {
        break label192;
      }
      localConcurrentHashMap.put(paramString2, paramString1);
      return paramString1;
      localConcurrentHashMap = this.Z;
      break;
    }
    label182:
    return (byte[])localConcurrentHashMap.get(paramString2);
    label192:
    return null;
  }
  
  public Object[] a(String paramString)
  {
    if (this.j.containsKey(paramString)) {
      return (Object[])this.j.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDiscussionMemberSeq" + paramString, -1L);
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDiscussionConfigSeq" + paramString, -1L);
      if (l1 != 0L) {
        return new Object[] { Long.valueOf(l1), Long.valueOf(l2) };
      }
    }
    return null;
  }
  
  public int b()
  {
    if ((this.jdField_c_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)) {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("getlastMessageTime", 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>getBuddyMsgLastSeq: " + this.jdField_c_of_type_Int);
    }
    return this.jdField_c_of_type_Int;
  }
  
  public int b(String paramString)
  {
    if (!this.ah.containsKey(paramString)) {
      this.ah.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.ah.get(paramString)).intValue();
  }
  
  public long b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(str)) {}
    long l1;
    do
    {
      return -1L;
      if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        break;
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(str + "birth", 0).getLong(str + "_time", -1L);
    } while (l1 == -1L);
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(l1));
    return ((Long)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).longValue();
  }
  
  public long b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.h.containsKey(paramString))
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopLastMessageTime" + paramString, 0L);
      this.h.put(paramString, Long.valueOf(l1));
    }
    paramString = (Long)this.h.get(paramString);
    if (paramString == null) {}
    for (long l1 = 0L;; l1 = paramString.longValue()) {
      return l1;
    }
  }
  
  public long b(String paramString, int paramInt)
  {
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBreakPointSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + 0);
      }
      return 0L;
    }
    if (!this.P.containsKey(localPair))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getBreakPointSeq" + paramString + "_" + paramInt, 0L);
      this.P.put(localPair, Long.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBreakPointSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + l1);
      }
    }
    return ((Long)this.P.get(localPair)).longValue();
  }
  
  public Pair<Long, Long> b(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.r.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getC2CLastMessageTime" + paramString, 0L);
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getC2CLastMessageTimeRand" + paramString, 0L);
      this.r.put(paramString, new Pair(Long.valueOf(l1), Long.valueOf(l2)));
    }
    return (Pair)this.r.get(paramString);
  }
  
  public ArrayList<stConfNumInfo> b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "cloneDiscNumInfoCache size = " + this.jdField_b_of_type_JavaUtilArrayList.size());
      }
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      return localArrayList;
    }
    finally {}
  }
  
  public ArrayList<msg_comm.Msg> b(long paramLong)
  {
    return (ArrayList)this.ag.get(Long.valueOf(paramLong));
  }
  
  public ArrayList<Object[]> b(String paramString)
  {
    return (ArrayList)this.ai.get(paramString);
  }
  
  public ConcurrentHashMap<String, ArrayList<Object[]>> b()
  {
    return this.ae;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "clearDiscPullSeqCache");
    }
    this.o.clear();
  }
  
  public void b(int paramInt)
  {
    if (c() != paramInt)
    {
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_a_of_type_Bbkp.putInt("msgsignal_switch", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>setMsgSignalSwitch = " + paramInt);
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.ag.remove(Long.valueOf(paramLong));
  }
  
  public void b(long paramLong, List<msg_comm.Msg> paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.ag.get(Long.valueOf(paramLong));
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.addAll(paramList);
    this.ag.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str = String.valueOf(paramMessageRecord.istroop) + "_" + paramMessageRecord.frienduin + "_" + paramMessageRecord.uniseq;
    this.T.put(str, paramMessageRecord);
  }
  
  public void b(String paramString)
  {
    this.ae.remove(paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.ah.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("setDiscussionMsgState discussionUin: ").append(paramString).append(" state: ").append(paramInt);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      if (paramInt == 2) {
        h(paramString);
      }
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    this.Q.put(new Pair(paramString, Integer.valueOf(paramInt)), Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.putLong("getAIOLastSeq" + paramString + "_" + paramInt, paramLong);
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, c(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addGroupExpiredSeq " + paramLong);
    }
    this.m.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.putLong("getTroopExpiredSeq" + paramString, paramLong);
    }
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    paramString = MD5.toMD5(paramString);
    this.r.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Bbkp.putLong("getC2CLastMessageTime" + paramString, paramLong1);
      this.jdField_a_of_type_Bbkp.putLong("getC2CLastMessageTimeRand" + paramString, paramLong2);
    }
  }
  
  public void b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      paramString1 = paramString1 + "_" + paramString2;
      try
      {
        paramString2 = (byte[])this.X.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "LimitChat", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.X.remove(paramString1);
          paramString2.remove(paramString1);
        }
        for (;;)
        {
          paramString2.commit();
          return;
          this.X.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString1) {}
    }
  }
  
  public void b(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addPCQQSearchMsgKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + HexUtil.bytes2HexStr(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.x.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte)))
    {
      this.x.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        paramArrayOfByte = HexUtil.bytes2HexStr(paramArrayOfByte);
        this.jdField_a_of_type_Bbkp.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void b(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.j.put(paramString, paramArrayOfObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        this.jdField_a_of_type_Bbkp.putLong("getDiscussionMemberSeq" + paramString, ((Long)paramArrayOfObject[0]).longValue());
        this.jdField_a_of_type_Bbkp.putLong("getDiscussionConfigSeq" + paramString, ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((MessageRecord)paramList.next());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      paramArrayOfByte = HexUtil.bytes2HexStr(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>setLastPubAccountCookie lastPACookie:" + paramArrayOfByte);
      }
      this.jdField_a_of_type_Bbkp.putString("getMsgV4_vPubAccountCookie", paramArrayOfByte);
    }
  }
  
  public boolean b()
  {
    return this.k.isEmpty();
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = abwz.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (paramMessageRecord.isLongMsg())
        {
          if ((this.S.containsKey(localObject)) && (((ConcurrentHashMap)this.S.get(localObject)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId)))) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
      } while (!this.s.containsKey(localObject));
      localObject = (ConcurrentHashMap)this.s.get(localObject);
    } while ((localObject == null) || (!((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramMessageRecord.uniseq))));
    return true;
  }
  
  public boolean b(String paramString, int paramInt, long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord == null) {}
    while ((!this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.frienduin.equals(paramString)) || (this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.istroop != paramInt) || (this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.uniseq != paramLong)) {
      return false;
    }
    return true;
  }
  
  public byte[] b()
  {
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)) {
      this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("getMsgV4_vPubAccountCookie", ""));
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>getLastPubAccountCookie lastPACookie:" + HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte));
    }
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public byte[] b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getWpaMsgKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.w.containsKey(paramString)) {
        break label150;
      }
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getWpaMsgKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = HexUtil.hexStr2Bytes((String)localObject);
    this.w.put(paramString, localObject);
    label150:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getWpaMsgKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + HexUtil.bytes2HexStr((byte[])this.w.get(paramString)));
    }
    return (byte[])this.w.get(paramString);
  }
  
  public byte[] b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.X.containsKey(paramString1))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "LimitChat", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = PkgTools.hexToBytes(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.X.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.X.get(paramString1);
    }
    return null;
  }
  
  public Object[] b(String paramString)
  {
    if (this.i.containsKey(paramString)) {
      return (Object[])this.i.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopMemberSeq" + paramString, -1L);
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopConfigSeq" + paramString, -1L);
      if (l1 != 0L) {
        return new Object[] { Long.valueOf(l1), Long.valueOf(l2) };
      }
    }
    return null;
  }
  
  public int c()
  {
    if (this.jdField_e_of_type_Int < 0) {
      if (!this.jdField_a_of_type_AndroidContentSharedPreferences.contains("msgsignal_switch")) {
        break label44;
      }
    }
    label44:
    for (this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("msgsignal_switch", 0);; this.jdField_e_of_type_Int = 0) {
      return this.jdField_e_of_type_Int;
    }
  }
  
  public long c()
  {
    if ((this.jdField_a_of_type_Long == -1L) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)) {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopDiscMsgLastTime", 0L);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>getTroopAndDiscMsgLastTime lastTime: " + this.jdField_a_of_type_Long);
    }
    return this.jdField_a_of_type_Long;
  }
  
  public long c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.m.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopExpiredSeq" + paramString, 0L);
      this.m.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.m.get(paramString)).longValue();
  }
  
  public long c(String paramString, int paramInt)
  {
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.Q.containsKey(localPair))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getAIOLastSeq" + paramString + "_" + paramInt, 0L);
      this.Q.put(localPair, Long.valueOf(l1));
    }
    return ((Long)this.Q.get(localPair)).longValue();
  }
  
  public ConcurrentHashMap<String, Integer> c()
  {
    return this.ah;
  }
  
  public void c()
  {
    this.U.clear();
  }
  
  public void c(long paramLong)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (paramLong > 0L))
    {
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(paramLong));
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(str + "birth", 0).edit();
      localEditor.putLong(str + "_time", paramLong);
      localEditor.apply();
    }
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramMessageRecord.frienduin + "_" + paramMessageRecord.msgUid + "_" + paramMessageRecord.shmsgseq;
    this.jdField_a_of_type_JavaUtilSet.add(paramMessageRecord);
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      this.o.put(paramString, Boolean.valueOf(true));
    }
  }
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    this.P.put(new Pair(paramString, Integer.valueOf(paramInt)), Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.putLong("getBreakPointSeq" + paramString + "_" + paramInt, paramLong);
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, d(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addDiscExpiredSeq " + paramLong);
    }
    this.n.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.putLong("getDiscussionExpiredSeq" + paramString, paramLong);
    }
  }
  
  public void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    a(paramString1, paramString2, paramArrayOfByte, true);
  }
  
  public void c(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addBusinessCrmMsgKey----> sig:" + HexUtil.bytes2HexStr(paramArrayOfByte) + ",length:" + paramArrayOfByte.length);
    }
    Object localObject = (byte[])this.y.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.y.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "crm", 0);
        paramArrayOfByte = PkgTools.toHexStr(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void c(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.i.put(paramString, paramArrayOfObject);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "addGroupMsgMemberSeq: groupUin=", paramString, "lastSeqId=", paramArrayOfObject[0] });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        this.jdField_a_of_type_Bbkp.putLong("getTroopMemberSeq" + paramString, ((Long)paramArrayOfObject[0]).longValue());
        this.jdField_a_of_type_Bbkp.putLong("getTroopConfigSeq" + paramString, ((Long)paramArrayOfObject[1]).longValue());
        bcdm.a(paramString, ((Long)paramArrayOfObject[1]).longValue(), ((Long)paramArrayOfObject[0]).longValue());
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Bbkp.putBoolean("getRegPrxyFailFlag", paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>setRegPrxyFailFlag = " + paramBoolean);
      }
    }
  }
  
  public boolean c()
  {
    return this.l.isEmpty();
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramMessageRecord);
    if ((paramMessageRecord.msgtype == -1051) || (paramMessageRecord.msgtype == -1035)) {}
    do
    {
      return bool;
      if ((!bool) || (paramMessageRecord.isLongMsg()) || ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))) {
        break;
      }
      Object localObject = abwz.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      localObject = (ConcurrentHashMap)this.s.get(localObject);
      if (localObject == null) {
        break;
      }
      paramMessageRecord = (bbkr)((ConcurrentHashMap)localObject).get(Long.valueOf(paramMessageRecord.uniseq));
      if (paramMessageRecord == null) {
        break;
      }
      long l1 = System.currentTimeMillis() - paramMessageRecord.jdField_b_of_type_Long;
      if ((l1 >= paramMessageRecord.jdField_b_of_type_Int) || (l1 <= 0L)) {
        break;
      }
      bool = false;
    } while (!QLog.isDevelopLevel());
    QLog.d("MsgSend", 4, "isStartSendingUI, " + false);
    return false;
    return bool;
  }
  
  public byte[] c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pcQQSearchKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.x.containsKey(paramString)) {
        break label150;
      }
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "pcQQSearchKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = HexUtil.hexStr2Bytes((String)localObject);
    this.x.put(paramString, localObject);
    label150:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pcQQSearchKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + HexUtil.bytes2HexStr((byte[])this.x.get(paramString)));
    }
    return (byte[])this.x.get(paramString);
  }
  
  public byte[] c(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, true);
  }
  
  public long d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.n.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDiscussionExpiredSeq" + paramString, 0L);
      this.n.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.n.get(paramString)).longValue();
  }
  
  public ConcurrentHashMap<String, ArrayList<Object[]>> d()
  {
    return this.ai;
  }
  
  public void d()
  {
    if (!this.s.isEmpty())
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.s.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if ((((Map.Entry)localObject).getValue() != null) && (!((ConcurrentHashMap)((Map.Entry)localObject).getValue()).isEmpty()))
        {
          localObject = ((ConcurrentHashMap)((Map.Entry)localObject).getValue()).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("uin", ((bbkr)localEntry.getValue()).jdField_a_of_type_JavaLangString);
              localJSONObject.put("type", ((bbkr)localEntry.getValue()).jdField_a_of_type_Int);
              localJSONObject.put("uniseq", ((bbkr)localEntry.getValue()).jdField_a_of_type_Long);
              localJSONArray.put(localJSONObject);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        this.jdField_a_of_type_Bbkp.putString("msgSending", localJSONArray.toString());
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "msgSending:write msgSending file before exit," + localJSONArray.toString());
        }
      }
    }
    e();
    this.jdField_c_of_type_Int = -1;
    this.h.clear();
    this.ae.clear();
    this.p.clear();
    this.ai.clear();
    this.aj.clear();
    this.ak.clear();
    this.r.clear();
    this.jdField_b_of_type_Long = 0L;
    this.al.clear();
    this.am.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.s.clear();
    this.t.clear();
    this.i.clear();
    this.j.clear();
    this.l.clear();
    this.k.clear();
    this.N.clear();
    if (this.jdField_a_of_type_Bbku != null) {
      this.jdField_a_of_type_Bbku.a();
    }
  }
  
  public void d(long paramLong)
  {
    if (this.jdField_a_of_type_Long < paramLong)
    {
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "--->>setTroopAndDiscMsgLastTime lastTime: " + paramLong);
        }
        this.jdField_a_of_type_Bbkp.putLong("getTroopDiscMsgLastTime", this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void d(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord, MessageHandler.jdField_e_of_type_Int);
  }
  
  public void d(String paramString)
  {
    this.ai.remove(paramString);
  }
  
  public void d(String paramString, int paramInt, long paramLong)
  {
    String str = abwz.a(paramString, paramInt);
    paramString = new bbkr(this, paramString, paramInt, paramLong, 0L);
    ConcurrentHashMap localConcurrentHashMap;
    if (this.t.containsKey(str))
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.t.get(str);
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "msgSending:addSendingCacheTemp,msgSendingTemp:" + this.t + " msgCache:" + hashCode());
      }
      return;
      localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      this.t.put(str, localConcurrentHashMap);
      continue;
      localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      this.t.put(str, localConcurrentHashMap);
    }
  }
  
  public void d(String paramString, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      paramString = (String)localObject + "_noticetime_" + paramString;
      this.g.put(paramString, Long.valueOf(paramLong));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences((String)localObject + "birth", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      paramString1 = paramString1 + "_" + paramString2;
      try
      {
        paramString2 = (byte[])this.aa.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "tiny_session_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.aa.remove(paramString1);
          paramString2.remove(paramString1);
        }
        for (;;)
        {
          paramString2.commit();
          return;
          this.aa.put(paramString1, paramArrayOfByte);
          paramString2.putString(paramString1, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString1) {}
    }
  }
  
  public void d(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addBusinessCrmSigt uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + HexUtil.bytes2HexStr(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.z.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte))) {
      this.z.put(paramString, paramArrayOfByte);
    }
  }
  
  public void d(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.ai.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.ai.put(paramString, localArrayList1);
  }
  
  public boolean d()
  {
    return (this.t == null) || (this.t.isEmpty());
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.isLongMsg()) && ((paramMessageRecord instanceof MessageForLongMsg))) {
      paramMessageRecord = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
    }
    while (paramMessageRecord.hasNext()) {
      if (((MessageRecord)paramMessageRecord.next()).extraflag != 0)
      {
        return true;
        if (paramMessageRecord.extraflag != 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public byte[] d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBusinessCrmKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.y.containsKey(paramString)) {
        break label183;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "crm", 0).getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "businessCrmKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = PkgTools.hexToBytes((String)localObject);
    this.y.put(paramString, localObject);
    label183:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "businessCrmKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + HexUtil.bytes2HexStr((byte[])this.y.get(paramString)));
    }
    return (byte[])this.y.get(paramString);
  }
  
  public byte[] d(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.aa.containsKey(paramString1))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "tiny_session_sig", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = PkgTools.hexToBytes(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.aa.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.aa.get(paramString1);
    }
    return null;
  }
  
  public long e(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (str == null) {
      return 0L;
    }
    if (!this.O.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString + str, 0L);
      this.O.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.O.get(paramString)).longValue();
  }
  
  public ConcurrentHashMap<String, ConcurrentHashMap<Long, bbkr>> e()
  {
    return this.t;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bbkp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "msgCache commit.");
      }
      this.jdField_a_of_type_Bbkp.commit();
    }
  }
  
  public void e(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public void e(String paramString)
  {
    this.k.put(paramString, Boolean.valueOf(true));
  }
  
  public void e(String paramString, long paramLong)
  {
    this.O.put(paramString, Long.valueOf(paramLong));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (str != null) {
      this.jdField_a_of_type_Bbkp.putLong(paramString + str, paramLong).commit();
    }
  }
  
  public void e(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramString1 = paramString1 + "_" + paramString2;
    for (;;)
    {
      try
      {
        paramString2 = (byte[])this.ac.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          break;
        }
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "game_buddy", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.ac.remove(paramString1);
          paramString2.remove(paramString1);
          paramString2.apply();
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.d(jdField_a_of_type_JavaLangString + "GameBuddy", 2, "addGameBuddyChatSessionKey throw e, e = ", paramString1);
        return;
      }
      this.ac.put(paramString1, paramArrayOfByte);
      paramString2.putString(paramString1, PkgTools.toHexStr(paramArrayOfByte));
    }
  }
  
  public void e(String paramString, byte[] paramArrayOfByte) {}
  
  public boolean e()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean e(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {}
    boolean bool;
    label44:
    MessageRecord localMessageRecord;
    do
    {
      return false;
      if ((!paramMessageRecord.isLongMsg()) || (!(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForLongMsg))) {
        break label119;
      }
      Iterator localIterator = ((MessageForLongMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).longMsgFragmentList.iterator();
      bool = false;
      if (!localIterator.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)localIterator.next();
    } while (localMessageRecord.extraflag != 0);
    if ((localMessageRecord.frienduin.equals(paramMessageRecord.frienduin)) && (localMessageRecord.istroop == paramMessageRecord.istroop) && (localMessageRecord.uniseq == paramMessageRecord.uniseq)) {
      bool = true;
    }
    for (;;)
    {
      break label44;
      return bool;
      label119:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != paramMessageRecord) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag != 0)) {
        break;
      }
      return true;
    }
  }
  
  public byte[] e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "businessCrmSigt uin:null peerUin:" + paramString + " key:null");
      }
    }
    while (!this.z.containsKey(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "businessCrmSigt uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "peerUin:" + paramString + " key:" + HexUtil.bytes2HexStr((byte[])this.z.get(paramString)));
    }
    return (byte[])this.z.get(paramString);
  }
  
  public byte[] e(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.ac.containsKey(paramString1))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "game_buddy", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = PkgTools.hexToBytes(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.ac.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.ac.get(paramString1);
    }
    return null;
  }
  
  public long f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      return 0L;
    }
    Long localLong2 = (Long)this.N.get(paramString);
    Long localLong1 = localLong2;
    if (localLong2 == null)
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getFriendFeedLastTime" + paramString, -1L);
      localLong1 = Long.valueOf(l1);
      this.N.put(paramString, Long.valueOf(l1));
    }
    return localLong1.longValue();
  }
  
  public ConcurrentHashMap<String, ArrayList<RevokeMsgInfo>> f()
  {
    return this.u;
  }
  
  public void f()
  {
    synchronized (this.R)
    {
      this.R.clear();
      return;
    }
  }
  
  public void f(MessageRecord paramMessageRecord)
  {
    this.jdField_b_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public void f(String paramString)
  {
    if (this.k.containsKey(paramString)) {
      this.k.remove(paramString);
    }
  }
  
  public void f(String paramString, long paramLong)
  {
    this.N.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.putLong("getFriendFeedLastTime" + paramString, paramLong);
    }
  }
  
  public void f(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramString1 = paramString1 + "_" + paramString2;
    for (;;)
    {
      try
      {
        paramString2 = (byte[])this.ab.get(paramString1);
        if (((paramString2 != null) && (Arrays.equals(paramString2, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          break;
        }
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qq_circle", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.ab.remove(paramString1);
          paramString2.remove(paramString1);
          paramString2.apply();
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.d(jdField_a_of_type_JavaLangString + "QQCircle", 2, "addQQCircleChatSessionKey throw e, e = ", paramString1);
        return;
      }
      this.ab.put(paramString1, paramArrayOfByte);
      paramString2.putString(paramString1, PkgTools.toHexStr(paramArrayOfByte));
    }
  }
  
  public void f(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.B.get(paramString);
    if ((localObject == null) || (!localObject.equals(paramArrayOfByte)))
    {
      this.B.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "pub", 0);
        paramArrayOfByte = PkgTools.toHexStr(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public boolean f(MessageRecord paramMessageRecord)
  {
    if (this.u.isEmpty()) {
      return false;
    }
    if (paramMessageRecord.isLongMsg()) {}
    for (String str = String.format("%s&%d&%d&%d", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.longMsgId), Integer.valueOf(paramMessageRecord.longMsgCount) }); this.u.containsKey(str); str = String.format("%s&%d&%d", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Long.valueOf(paramMessageRecord.shmsgseq) }))
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "RevokeNotifyCache, msgFilter true, " + paramMessageRecord.toString());
      }
      return true;
    }
    return false;
  }
  
  public byte[] f(String paramString)
  {
    return null;
  }
  
  public byte[] f(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = paramString1 + "_" + paramString2;
    if (!this.ab.containsKey(paramString1))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qq_circle", 0).getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = PkgTools.hexToBytes(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0))
        {
          this.ab.put(paramString1, paramString2);
          return paramString2;
        }
      }
    }
    else
    {
      return (byte[])this.ab.get(paramString1);
    }
    return null;
  }
  
  public long g(String paramString)
  {
    paramString = (Long)this.U.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "dumpGroupMsgJob size = " + this.k.size());
    }
  }
  
  public void g(String paramString)
  {
    this.l.put(paramString, Boolean.valueOf(true));
  }
  
  public void g(String paramString, long paramLong)
  {
    this.U.put(paramString, Long.valueOf(paramLong));
  }
  
  public void g(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.C.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.C.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "same_state", 0);
        paramArrayOfByte = PkgTools.toHexStr(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] g(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.J.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "circle_group", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.hexToBytes((String)localObject);
    this.J.put(paramString, localObject);
    return (byte[])this.J.get(paramString);
  }
  
  public long h(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      return 0L;
    }
    if (!this.p.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDiscussionLastMessageTime" + paramString, 0L);
      this.p.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.p.get(paramString)).longValue();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "dumpDiscMsgJob size = " + this.l.size());
    }
  }
  
  public void h(String paramString)
  {
    if (this.l.containsKey(paramString)) {
      this.l.remove(paramString);
    }
  }
  
  public void h(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, h(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addDiscussionMsgLastSeq " + paramLong);
    }
    this.p.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.putLong("getDiscussionLastMessageTime" + paramString, paramLong);
    }
  }
  
  public void h(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.D.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "accost", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.D.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.D.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] h(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.K.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "circle_group_av", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.hexToBytes((String)localObject);
    this.K.put(paramString, localObject);
    return (byte[])this.K.get(paramString);
  }
  
  public long i(String paramString)
  {
    long l1 = h(paramString);
    long l2 = d(paramString);
    long l3 = a(paramString, 3000);
    return Math.max(Math.max(l1, l2), l3);
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeHotChatSeq groupUin:" + paramString);
    }
    this.h.put(paramString, Long.valueOf(0L));
    this.i.put(paramString, new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    this.m.put(paramString, Long.valueOf(0L));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      this.jdField_a_of_type_Bbkp.remove("getTroopLastMessageTime" + paramString);
      this.jdField_a_of_type_Bbkp.remove("getTroopMemberSeq" + paramString);
      this.jdField_a_of_type_Bbkp.remove("getTroopConfigSeq" + paramString);
      this.jdField_a_of_type_Bbkp.remove("getTroopExpiredSeq" + paramString);
    }
  }
  
  public void i(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.G.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "tribe_bytes_chat_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.G.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.G.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] i(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.L.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "friend_validation", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.hexToBytes((String)localObject);
    this.L.put(paramString, localObject);
    return (byte[])this.L.get(paramString);
  }
  
  public long j(String paramString)
  {
    long l1 = a(paramString, 1);
    long l2 = b(paramString);
    long l3 = c(paramString);
    return Math.max(Math.max(l2, l1), l3);
  }
  
  public void j(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) {
      this.jdField_a_of_type_Bbkp.remove("deleteFriendMsgTime" + paramString);
    }
  }
  
  public void j(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.I.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "movie_ticket_bytes_chat_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.I.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.I.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] j(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {}
    do
    {
      return null;
      if (this.C.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "same_state", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.hexToBytes((String)localObject);
    this.C.put(paramString, localObject);
    return (byte[])this.C.get(paramString);
  }
  
  public void k(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.V.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "approval_assistant", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.V.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.V.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] k(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.G.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "tribe_bytes_chat_sig", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.hexToBytes((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.G.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.G.get(paramString);
    }
    return null;
  }
  
  public void l(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.F.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "dating", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.F.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.F.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] l(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.H.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "audioroom_bytes_chat_sig", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.hexToBytes((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.H.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.H.get(paramString);
    }
    return null;
  }
  
  public void m(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.J.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.J.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "circle_group", 0);
        paramArrayOfByte = PkgTools.toHexStr(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] m(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.I.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "movie_ticket_bytes_chat_sig", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.hexToBytes((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.I.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.I.get(paramString);
    }
    return null;
  }
  
  public void n(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.K.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.K.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "circle_group_av", 0);
        paramArrayOfByte = PkgTools.toHexStr(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] n(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.D.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "accost", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.hexToBytes((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.D.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.D.get(paramString);
    }
    return null;
  }
  
  public void o(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.L.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.L.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "friend_validation", 0);
        paramArrayOfByte = PkgTools.toHexStr(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] o(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.V.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "approval_assistant", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.hexToBytes((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.V.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.V.get(paramString);
    }
    return null;
  }
  
  public void p(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.H.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "audioroom_bytes_chat_sig", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.H.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.H.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.toHexStr(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] p(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.E.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "nearby_assistant", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.hexToBytes((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.E.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.E.get(paramString);
    }
    return null;
  }
  
  public byte[] q(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null)) {
      return null;
    }
    if (!this.F.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "dating", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.hexToBytes((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.F.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.F.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbko
 * JD-Core Version:    0.7.0.1
 */