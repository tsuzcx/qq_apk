import NearbyGroup.GroupInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager.1;
import com.tencent.mobileqq.app.MayknowRecommendManager.11;
import com.tencent.mobileqq.app.MayknowRecommendManager.13;
import com.tencent.mobileqq.app.MayknowRecommendManager.2;
import com.tencent.mobileqq.app.MayknowRecommendManager.4;
import com.tencent.mobileqq.app.MayknowRecommendManager.5;
import com.tencent.mobileqq.app.MayknowRecommendManager.6;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
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
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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

public class anpk
  implements Manager
{
  public static int a;
  public static long a;
  public static final Object a;
  public static final Object b;
  private static int jdField_c_of_type_Int = 70;
  private static int jdField_d_of_type_Int = 3;
  public static boolean e;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  anmu jdField_a_of_type_Anmu = new anpn(this);
  private awna jdField_a_of_type_Awna = new anpo(this);
  private bdci jdField_a_of_type_Bdci = new anpp(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public String a;
  private ArrayList<MayKnowRecommend> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, ArrayList> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private List<RecentRecommendTroopItem> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, MayKnowExposure> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public volatile boolean a;
  public int b;
  private long jdField_b_of_type_Long;
  private final ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, byte[]> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private ArrayList<aixh> jdField_c_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<Integer, Boolean> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  boolean jdField_c_of_type_Boolean = false;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  public boolean d;
  private int jdField_e_of_type_Int = 2;
  private Object jdField_e_of_type_JavaLangObject = new Object();
  private int jdField_f_of_type_Int;
  private Object jdField_f_of_type_JavaLangObject = new Object();
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 1;
  private volatile boolean jdField_g_of_type_Boolean;
  private volatile boolean h;
  private boolean i;
  private boolean j;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Long = 86400000L;
    jdField_a_of_type_Int = 37;
  }
  
  public anpk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_MqqOsMqqHandler.post(new MayknowRecommendManager.1(this));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anmu);
    if (this.jdField_a_of_type_Awna != null)
    {
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(this.jdField_a_of_type_Awna);
      }
    }
    bdch.a(this.jdField_a_of_type_Bdci);
  }
  
  private int a(List<RecentBaseData> paramList, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 3)
    {
      if (paramInt2 <= 3) {
        return paramInt2;
      }
      int k = paramInt1;
      paramInt2 = paramInt1;
      paramInt1 = k;
      if (paramInt2 >= paramList.size()) {
        break label81;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramList.get(paramInt2);
      if (albc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentBaseData)) {
        break label78;
      }
      paramInt1 += 1;
      label58:
      if (paramInt1 != 3) {}
    }
    label78:
    label81:
    for (paramInt1 = paramInt2 + 1;; paramInt1 = 3)
    {
      return paramInt1;
      paramInt2 += 1;
      break;
      return paramInt1;
      break label58;
    }
  }
  
  private aixh a(oidb_0xc26.TabInfo paramTabInfo)
  {
    aixh localaixh = new aixh();
    localaixh.jdField_a_of_type_Int = paramTabInfo.uint32_tab_id.get();
    localaixh.jdField_b_of_type_Int = paramTabInfo.uint32_recommend_count.get();
    String str;
    if (paramTabInfo.bytes_table_name.has())
    {
      str = paramTabInfo.bytes_table_name.get().toStringUtf8();
      localaixh.jdField_a_of_type_JavaLangString = str;
      if (!paramTabInfo.bytes_icon_url_select.has()) {
        break label116;
      }
      str = paramTabInfo.bytes_icon_url_select.get().toStringUtf8();
      label77:
      localaixh.jdField_b_of_type_JavaLangString = str;
      if (!paramTabInfo.bytes_icon_url_unselect.has()) {
        break label122;
      }
    }
    label116:
    label122:
    for (paramTabInfo = paramTabInfo.bytes_icon_url_unselect.get().toStringUtf8();; paramTabInfo = "")
    {
      localaixh.c = paramTabInfo;
      return localaixh;
      str = "";
      break;
      str = "";
      break label77;
    }
  }
  
  private RecentRecommendTroopItem a(String paramString)
  {
    aong localaong = null;
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onJoinedTroop uin: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    label214:
    label252:
    label255:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int m = this.jdField_a_of_type_JavaUtilList.size();
        int k = 0;
        Object localObject = localaong;
        if (k < m)
        {
          if (((RecentRecommendTroopItem)this.jdField_a_of_type_JavaUtilList.get(k)).uin.equalsIgnoreCase(paramString))
          {
            localObject = (RecentRecommendTroopItem)this.jdField_a_of_type_JavaUtilList.remove(k);
            if (this.jdField_f_of_type_Int <= k) {
              break label252;
            }
            k = 0;
            if (k >= this.jdField_e_of_type_Int) {
              break label255;
            }
            this.jdField_f_of_type_Int -= 1;
            k += 1;
            continue;
          }
        }
        else
        {
          k = this.jdField_a_of_type_JavaUtilList.size();
          this.jdField_a_of_type_MqqOsMqqHandler.post(new MayknowRecommendManager.11(this, paramString));
          if (k != 0) {
            break label214;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteRecentUserByType(8113);
          return localObject;
        }
        k += 1;
      }
      localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      paramString = (RecentUser)localaong.findRecentUser(paramString, 8113);
      if (paramString != null)
      {
        localaong.delRecentUser(paramString);
        continue;
      }
    }
  }
  
  private ArrayList<RecentRecommendTroopItem> a(ArrayList<RecentRecommendTroopItem> paramArrayList)
  {
    Object localObject;
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      localObject = new ArrayList();
      return localObject;
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    int k = paramArrayList.size() - 1;
    for (;;)
    {
      localObject = paramArrayList;
      if (k < 0) {
        break;
      }
      if (localTroopManager.d(((RecentRecommendTroopItem)paramArrayList.get(k)).uin) != null) {
        paramArrayList.remove(k);
      }
      k -= 1;
    }
  }
  
  private void a(int paramInt, ArrayList<MayKnowRecommend> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      paramArrayList = b(paramArrayList);
      if (paramInt != 23) {
        break label192;
      }
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((paramArrayList.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() + paramArrayList.size() < 1000)) {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      }
      try
      {
        ((EntityTransaction)???).begin();
        if (paramBoolean)
        {
          localObject2 = "delete from MayKnowRecommend where tabID=" + paramInt;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL((String)localObject2);
        }
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            localObject2 = (MayKnowRecommend)paramArrayList.next();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist((Entity)localObject2);
          }
        }
      }
      catch (Exception paramArrayList)
      {
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "onGetConnectionsPersonData ex", paramArrayList);
        }
        return;
        paramArrayList = finally;
        throw paramArrayList;
        label192:
        ??? = this.jdField_f_of_type_JavaLangObject;
        if (paramBoolean) {}
        for (;;)
        {
          try
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramArrayList);
            break;
          }
          finally {}
          localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
          if (localObject2 != null)
          {
            ArrayList localArrayList = new ArrayList(((ArrayList)localObject2).size() + paramArrayList.size());
            localArrayList.addAll((Collection)localObject2);
            localArrayList.addAll(paramArrayList);
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
          }
        }
        ((EntityTransaction)???).commit();
        return;
      }
      finally
      {
        ((EntityTransaction)???).end();
      }
    }
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      synchronized (this.jdField_e_of_type_JavaLangObject)
      {
        localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_sp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        if (paramArrayOfByte != null)
        {
          String str = "";
          try
          {
            localObject1 = Base64.encodeToString(paramArrayOfByte, 2);
            localSharedPreferences.edit().putString("sp_mayknow_connections_tabinfo_cookie_" + paramInt, (String)localObject1).commit();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("saveTabCookieToSP ").append(paramInt).append(" isNull ");
              if (paramArrayOfByte != null) {
                break label283;
              }
              bool = true;
              QLog.d("MayknowRecommendManager", 2, bool);
            }
            localObject1 = paramArrayOfByte;
            if (paramArrayOfByte == null) {
              localObject1 = new byte[0];
            }
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject1);
            return;
          }
          catch (Throwable localThrowable)
          {
            Object localObject1 = str;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MayknowRecommendManager", 2, "saveTabCookieToSP " + localThrowable.toString());
            localObject1 = str;
            continue;
          }
        }
      }
      localSharedPreferences.edit().remove("sp_mayknow_connections_tabinfo_cookie_" + paramInt).commit();
      continue;
      label283:
      boolean bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new SubMsgType0x111.MsgBody();
        ((SubMsgType0x111.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x111.MsgBody)localObject).uint64_type.has()) {
          break label387;
        }
        l1 = ((SubMsgType0x111.MsgBody)localObject).uint64_type.get();
        if (QLog.isColorLevel()) {
          QLog.i("MayknowRecommendManager", 2, "decodePush0x210_0x111,type = " + l1);
        }
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (l1 == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 update list");
          }
          paramQQAppInterface.a((int)l1, null);
          return;
        }
        if (l1 == 1L)
        {
          paramArrayOfByte = new ArrayList();
          if (((SubMsgType0x111.MsgBody)localObject).rpt_msg_add_recommend_persons.has()) {
            paramArrayOfByte.addAll(MayKnowRecommend.covServerPushDataToLocal(((SubMsgType0x111.MsgBody)localObject).rpt_msg_add_recommend_persons.get(), System.currentTimeMillis()));
          }
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 add " + paramArrayOfByte);
          }
          paramQQAppInterface.a((int)l1, paramArrayOfByte);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        QLog.i("MayknowRecommendManager", 1, "decodePush0x210_0x111 decode error, e=" + paramQQAppInterface.toString());
        return;
      }
      if (l1 == 2L)
      {
        paramArrayOfByte = new ArrayList();
        if (((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.has()) {
          paramArrayOfByte.addAll(((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.get());
        }
        localObject = new ArrayList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          long l2 = ((Long)paramArrayOfByte.next()).longValue();
          if (l2 > 0L) {
            ((List)localObject).add(String.valueOf(l2));
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "decodePush0x210_0x111 del " + localObject);
        }
        paramQQAppInterface.a((int)l1, (List)localObject);
        return;
        QLog.i("MayknowRecommendManager", 1, "decodePush0x210_0x111 pbData = null");
      }
      return;
      label387:
      long l1 = -1L;
    }
  }
  
  private void a(RecentRecommendTroopItem paramRecentRecommendTroopItem)
  {
    int m;
    int k;
    String str;
    if ((paramRecentRecommendTroopItem.labelList != null) && (!paramRecentRecommendTroopItem.labelList.isEmpty()))
    {
      m = Math.min(3, paramRecentRecommendTroopItem.labelList.size());
      Iterator localIterator = paramRecentRecommendTroopItem.labelList.iterator();
      k = 0;
      while (localIterator.hasNext())
      {
        oidb_0x9fb.Label localLabel = (oidb_0x9fb.Label)localIterator.next();
        str = localLabel.bytes_name.get().toStringUtf8();
        if (!TextUtils.isEmpty(str))
        {
          if (localLabel.enum_type.get() != 1) {
            break label193;
          }
          str = str + anni.a(2131705264);
        }
      }
    }
    label193:
    for (;;)
    {
      paramRecentRecommendTroopItem.labelStr += str;
      k += 1;
      if (k == m) {
        return;
      }
      paramRecentRecommendTroopItem.labelStr += "|";
      break;
    }
  }
  
  private <T extends MayKnowRecommend> ArrayList<T> b(@NonNull ArrayList<T> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    anmw localanmw = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramArrayList.next();
      if (!localanmw.b(localMayKnowRecommend.uin))
      {
        boolean bool = localanmw.a(localMayKnowRecommend.uin, false, true);
        if (bool) {}
        for (int k = 1;; k = 0)
        {
          localMayKnowRecommend.friendStatus = k;
          if (bool) {
            break;
          }
          localArrayList.add(localMayKnowRecommend);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void c(List<oidb_0xc26.TabInfo> paramList)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("saveConnectionsTabInfoList ");
      if (paramList != null) {
        break label143;
      }
    }
    label143:
    for (??? = "null";; ??? = Integer.valueOf(paramList.size()))
    {
      QLog.d("MayknowRecommendManager", 2, ???);
      if (paramList == null) {
        return;
      }
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localObject2 = a((oidb_0xc26.TabInfo)paramList.next());
        if (((aixh)localObject2).jdField_a_of_type_Int == 23) {
          ((aixh)localObject2).jdField_b_of_type_Int += c().size();
        }
        this.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    d(this.jdField_c_of_type_JavaUtilArrayList);
  }
  
  private void d(List<aixh> paramList)
  {
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      JSONArray localJSONArray;
      synchronized (this.jdField_e_of_type_JavaLangObject)
      {
        localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_sp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        if (paramList == null)
        {
          localSharedPreferences.edit().remove("sp_mayknow_connections_tabinfo_list_json").commit();
          return;
        }
        localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        if (paramList.hasNext()) {
          localJSONArray.put(aixh.a((aixh)paramList.next()));
        }
      }
      localSharedPreferences.edit().putString("sp_mayknow_connections_tabinfo_list_json", localJSONArray.toString()).commit();
    }
  }
  
  private void e(int paramInt)
  {
    synchronized (this.jdField_f_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()))
      {
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MayKnowRecommend.class, false, "tabID=?", new String[] { paramInt + "" }, null, null, null, null);
        synchronized (this.jdField_f_of_type_JavaLangObject)
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (localArrayList != null)) {
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
          }
          return;
        }
      }
    }
  }
  
  private void f(int paramInt)
  {
    StringBuilder localStringBuilder = null;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.contains(Integer.valueOf(paramInt))) {
      return;
    }
    label244:
    for (;;)
    {
      synchronized (this.jdField_e_of_type_JavaLangObject)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_sp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("sp_mayknow_connections_tabinfo_cookie_" + paramInt, null);
        Object localObject1 = localStringBuilder;
        if (str != null) {}
        try
        {
          localObject1 = Base64.decode(str, 2);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("loadTabCookieFromSP ").append(paramInt).append(" ");
            if (localObject1 == null)
            {
              bool = true;
              QLog.d("MayknowRecommendManager", 2, bool);
            }
          }
          else
          {
            if (localObject1 != null) {
              break label244;
            }
            localObject1 = new byte[0];
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject1);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localObject1 = localStringBuilder;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MayknowRecommendManager", 2, "loadTabCookieFromSP " + localThrowable.toString());
          localObject1 = localStringBuilder;
          continue;
        }
      }
      boolean bool = false;
    }
  }
  
  private boolean f()
  {
    return !((ajld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295)).c();
  }
  
  private void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "deleteRecentUserByType " + paramInt);
    }
    aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    Object localObject = localaong.getRecentList(false);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if (localRecentUser.getType() == paramInt) {
          localaong.delRecentUser(localRecentUser);
        }
      }
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "initData conversationTabShowType: " + this.jdField_b_of_type_Int);
    }
    boolean bool3 = anpe.c();
    boolean bool1 = false;
    boolean bool2 = false;
    EntityTransaction localEntityTransaction;
    if (bool3) {
      localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    }
    try
    {
      localEntityTransaction.begin();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("delete from MayKnowRecommend");
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("delete from MayKnowExposure");
      localEntityTransaction.commit();
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "initData ex", localException);
        }
        localEntityTransaction.end();
        bool1 = bool2;
      }
    }
    finally
    {
      localEntityTransaction.end();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("pull_interval_conversation_tab", 0L).commit();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "initData isLocaleIDChange =  " + bool3 + ",isDBOperateSuccess = " + bool1);
    }
    l();
    if (this.jdField_b_of_type_Int == -1) {
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      n();
      return;
    }
    m();
    o();
  }
  
  private void l()
  {
    boolean bool2 = true;
    jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_report_interval", 86400000L);
    jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_showcount", 37);
    jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_expectcount", 70);
    jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_newfriendcount", 3);
    int k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_conversation_tab_show_type", -1);
    this.jdField_b_of_type_Boolean = b("sp_mayknow_ml_s_a_vl");
    this.jdField_c_of_type_Boolean = b("sp_mayknow_addpage_s_a_vl");
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_contacts_tab_recommend_troop_hide_time", 0L);
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_contacts_tab_recommend_troop_count", 2);
    aqly localaqly = aqlx.a();
    StringBuilder localStringBuilder;
    if (localaqly != null)
    {
      this.jdField_g_of_type_Int = localaqly.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = localaqly.jdField_a_of_type_JavaLangString;
      if (localaqly.jdField_b_of_type_Int == 1)
      {
        bool1 = true;
        this.jdField_d_of_type_Boolean = bool1;
      }
    }
    else
    {
      if (this.jdField_b_of_type_Int != k)
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).notifyUI(123, true, new Object[] { Integer.valueOf(k) });
        this.jdField_b_of_type_Int = k;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("initParams ,conversationTabDisplayAsVerticalListItem = ").append(this.jdField_b_of_type_Boolean).append(",addPageDisplayAsVerticalListItem = ").append(this.jdField_c_of_type_Boolean).append(",conversationTabShowType=").append(this.jdField_b_of_type_Int).append(",mContactsTabRecommendTroopHideTime=").append(this.jdField_c_of_type_Long).append(",mContactsTabRecommendTroopPollInterval=").append(this.jdField_g_of_type_Int).append(",contactsTabRecommendTroopJumpUrl=").append(this.jdField_a_of_type_JavaLangString).append(",showRecommendTroopWhenSearchEmpty=").append(this.jdField_d_of_type_Boolean).append(",mContactsTabShowRecommendTroopCount=").append(this.jdField_e_of_type_Int).append(", config is null: ");
        if (localaqly != null) {
          break label379;
        }
      }
    }
    label379:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("MayknowRecommendManager", 2, bool1);
      return;
      bool1 = false;
      break;
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
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() == 1) {
          r();
        }
      }
      else {
        return;
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MayknowRecommendManager.2(this), 5000L);
  }
  
  private void n()
  {
    Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(RecentRecommendTroopItem.class);
    Object localObject3;
    int k;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("initRecommendTroop in db, troopItems = ");
      if (localObject1 == null)
      {
        k = 0;
        QLog.i("MayknowRecommendManager", 2, k);
      }
    }
    else
    {
      localArrayList = a((ArrayList)localObject1);
      localObject3 = this.jdField_a_of_type_JavaUtilList;
      if (localArrayList == null) {}
    }
    for (;;)
    {
      try
      {
        if ((!localArrayList.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("filtered troop:");
          if (localArrayList != null) {
            break label205;
          }
          localObject1 = "null";
          QLog.i("MayknowRecommendManager", 2, (String)localObject1);
        }
        c();
        localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("is_from_init", true);
        ((FriendListHandler)localObject1).notifyUI(92, true, localObject3);
        return;
      }
      finally {}
      k = ((ArrayList)localObject1).size();
      break;
      label205:
      String str = localArrayList.toString();
    }
  }
  
  private void o()
  {
    Bundle localBundle = null;
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MayKnowRecommend.class, false, "tabID=? or tabID is null", new String[] { "23" }, null, null, null, null);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("initMayKnowGet in db, cpMkrs = ");
      if (localArrayList == null)
      {
        ??? = "NULL";
        QLog.i("MayknowRecommendManager", 2, (String)???);
      }
    }
    else
    {
      localObject3 = b(localArrayList);
      if ((localObject3 == null) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))) {
        break label259;
      }
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("initMayKnowGet size:");
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            break label278;
          }
          ??? = Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size());
          localObject3 = ((StringBuilder)localObject3).append(???).append(" cpMkrs:");
          ??? = localBundle;
          if (localArrayList != null) {
            ??? = Integer.valueOf(localArrayList.size());
          }
          QLog.i("MayknowRecommendManager", 2, ???);
        }
        d();
        ??? = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        localBundle = new Bundle();
        localBundle.putBoolean("is_from_init", true);
        ((FriendListHandler)???).notifyUI(92, true, localBundle);
        return;
        ??? = localArrayList.toString();
      }
      label259:
      if (QLog.isColorLevel())
      {
        QLog.i("MayknowRecommendManager", 2, "initMayKnowGet, mRecommends alread has data");
        continue;
        label278:
        ??? = null;
      }
    }
  }
  
  private void p()
  {
    int k = 0;
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {}
      synchronized (this.jdField_e_of_type_JavaLangObject)
      {
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_sp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("sp_mayknow_connections_tabinfo_list_json", "");
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "loadConnectionsTabInfoList " + (String)localObject4);
        }
        boolean bool = ((String)localObject4).isEmpty();
        if (!bool) {}
        try
        {
          localObject4 = new JSONArray((String)localObject4);
          ArrayList localArrayList = new ArrayList(5);
          while (k < ((JSONArray)localObject4).length())
          {
            localArrayList.add(aixh.a(((JSONArray)localObject4).getJSONObject(k)));
            k += 1;
          }
          this.jdField_c_of_type_JavaUtilArrayList = localArrayList;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MayknowRecommendManager", 2, "loadConnectionsTabInfoList " + localJSONException.toString());
            }
          }
        }
        return;
      }
    }
  }
  
  private void q()
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_sp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().clear().commit();
      return;
    }
  }
  
  private void r()
  {
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "reportExplosure size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + " isExplosuresInited=" + this.h);
      }
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0) || (!this.h)) {
        continue;
      }
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        this.jdField_g_of_type_Boolean = true;
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        if (!QLog.isColorLevel()) {
          continue;
        }
        ??? = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (!((Iterator)???).hasNext()) {
          continue;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
        QLog.d("MayknowRecommendManager", 2, "reportExplosure, Key = " + (String)localEntry.getKey() + ", Value.exposeCnt = " + ((MayKnowExposure)localEntry.getValue()).exposeCnt + ", Value.exposeTime = " + ((MayKnowExposure)localEntry.getValue()).exposeTime);
      }
    }
  }
  
  public int a()
  {
    int n = 0;
    int k = 0;
    p();
    if (!((ajld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295)).c()) {}
    for (int m = 1;; m = 0) {
      label149:
      for (;;)
      {
        synchronized (this.jdField_d_of_type_JavaLangObject)
        {
          if (this.jdField_c_of_type_JavaUtilArrayList != null)
          {
            Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
            n = k;
            if (localIterator.hasNext())
            {
              aixh localaixh = (aixh)localIterator.next();
              if ((localaixh.jdField_a_of_type_Int != 23) && (m == 0)) {
                break label149;
              }
              k = localaixh.jdField_b_of_type_Int + k;
              break label149;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonAllNum " + n);
          }
          return n;
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    int k = 1;
    ArrayList localArrayList = a(paramInt);
    int m = k;
    if (localArrayList != null)
    {
      m = k;
      if (localArrayList.size() > 0)
      {
        paramInt = ((MayKnowRecommend)localArrayList.get(0)).timestamp;
        int n = localArrayList.size();
        k = 1;
        m = paramInt;
        if (k < n)
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localArrayList.get(k);
          if (localMayKnowRecommend.timestamp >= paramInt) {
            break label91;
          }
          paramInt = localMayKnowRecommend.timestamp;
        }
      }
    }
    label91:
    for (;;)
    {
      k += 1;
      break;
      return m;
    }
  }
  
  public long a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      return 9223372036854775807L;
    case 1: 
      str = "pull_interval_conversation_tab";
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 43200000L);
        str = "pull_interval_contact_head";
        continue;
        str = "pull_interval_recommend_tab";
        continue;
        str = "pull_interval_new_friend";
        continue;
        str = "pull_interval_add_page";
      }
    }
    return 0L;
  }
  
  public ArrayList<aixh> a()
  {
    ArrayList localArrayList = new ArrayList();
    p();
    for (;;)
    {
      boolean bool;
      aixh localaixh;
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList == null) {
          break;
        }
        bool = f();
        Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localaixh = aixh.a((aixh)localIterator.next());
        if (localaixh.jdField_a_of_type_Int == 23)
        {
          localaixh.jdField_a_of_type_Boolean = true;
          localArrayList.add(localaixh);
        }
      }
      localaixh.jdField_a_of_type_Boolean = bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "getConnectionsTabInfoList " + localArrayList1.toString());
    }
    return localArrayList1;
  }
  
  public ArrayList<MayKnowRecommend> a(int paramInt)
  {
    ArrayList localArrayList;
    if (paramInt == 23)
    {
      localArrayList = c();
      f(paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("getConnectionsPersonLocal ").append(paramInt).append(" ");
        if (localArrayList == null)
        {
          ??? = "null";
          QLog.d("MayknowRecommendManager", 2, (String)???);
        }
      }
      else
      {
        return localArrayList;
      }
    }
    else
    {
      e(paramInt);
    }
    for (;;)
    {
      synchronized (this.jdField_f_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          break label156;
        }
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localArrayList == null) {
          break label156;
        }
        localArrayList = new ArrayList(localArrayList);
      }
      ??? = localObject1.size() + "";
      break;
      label156:
      Object localObject2 = null;
    }
  }
  
  public List<RecentRecommendTroopItem> a(int paramInt)
  {
    int k = 1;
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
      ??? = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)???).putInt("sp_contacts_tab_recommend_troop_count", this.jdField_e_of_type_Int);
      ((SharedPreferences.Editor)???).commit();
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_g_of_type_Int < 1) {}
    while ((l - this.jdField_b_of_type_Long < k * 60) && (paramInt > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop in poll interval. return empty.");
      }
      return localArrayList;
      k = this.jdField_g_of_type_Int;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      k = this.jdField_a_of_type_JavaUtilList.size();
      if (k == 0) {
        return null;
      }
      if (this.jdField_f_of_type_Int < 0) {
        this.jdField_f_of_type_Int = 0;
      }
      this.jdField_f_of_type_Int %= k;
      int m = Math.min(this.jdField_e_of_type_Int, k);
      paramInt = 0;
      while ((this.jdField_f_of_type_Int < k) && (paramInt < m))
      {
        localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(this.jdField_f_of_type_Int));
        int n = this.jdField_f_of_type_Int + 1;
        this.jdField_f_of_type_Int = n;
        this.jdField_f_of_type_Int = (n % k);
        paramInt += 1;
      }
      if (localArrayList.size() > 0) {
        this.jdField_b_of_type_Long = l;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "getContactsTabNeedShowTroop return troop list: " + localArrayList.toString());
      }
      return localArrayList;
    }
  }
  
  public void a()
  {
    boolean bool = true;
    aqly localaqly = aqlx.a();
    if (localaqly != null)
    {
      this.jdField_g_of_type_Int = localaqly.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = localaqly.jdField_a_of_type_JavaLangString;
      if (localaqly.jdField_b_of_type_Int != 1) {
        break label102;
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "updateRecommendTroopConfig, mContactsTabRecommendTroopPollInterval=" + this.jdField_g_of_type_Int + ",contactsTabRecommendTroopJumpUrl=" + this.jdField_a_of_type_JavaLangString + ",showRecommendTroopWhenSearchEmpty=" + this.jdField_d_of_type_Boolean);
      }
      return;
      label102:
      bool = false;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "clearConnectionsPageNetworkState " + paramInt);
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemote entryType = " + paramInt1 + " tabID=" + paramInt2);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new MayknowRecommendManager.4(this, paramInt2, paramInt1, paramBundle));
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
          int k = Integer.valueOf(paramString.optString("reportInterval").trim()).intValue();
          if ((k <= 86400000) && (k > 0)) {
            jdField_a_of_type_Long = k;
          }
          k = Integer.valueOf(paramString.optString("showCount").trim()).intValue();
          if ((k > 0) && (k <= 100)) {
            jdField_a_of_type_Int = k;
          }
          k = Integer.valueOf(paramString.optString("totalCount").trim()).intValue();
          if ((k <= 100) && (k > 0)) {
            jdField_c_of_type_Int = k;
          }
          k = Integer.valueOf(paramString.optString("newfriendCount")).intValue();
          if (k > 0) {
            jdField_d_of_type_Int = k;
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_report_interval", jdField_a_of_type_Long).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_showcount", jdField_a_of_type_Int).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_expectcount", jdField_c_of_type_Int).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_newfriendcount", jdField_d_of_type_Int).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_version", paramInt).commit();
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MayknowRecommendManager", 2, "updateConfigs error " + paramString.getMessage());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "timeInterval = " + jdField_a_of_type_Long + ",showCount=" + jdField_a_of_type_Int + ",expectCount=" + jdField_c_of_type_Int + ",newfriendCount=" + jdField_d_of_type_Int);
    }
  }
  
  public void a(int paramInt, ArrayList<MayKnowRecommend> paramArrayList, List<oidb_0xc26.TabInfo> paramList, byte[] paramArrayOfByte, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3;
    int k;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("onGetConnectionsPersonData ").append(paramInt).append(" ").append(paramBoolean).append(" ");
      if (paramArrayList == null)
      {
        ??? = "";
        QLog.d("MayknowRecommendManager", 2, ???);
      }
    }
    else
    {
      a(paramInt, paramArrayList, paramBoolean);
      p();
      if (paramList == null) {
        break label574;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "onGetConnectionsPersonData " + paramInt + " " + paramList.size());
      }
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          ??? = (oidb_0xc26.TabInfo)paramList.next();
          if (((oidb_0xc26.TabInfo)???).uint32_tab_id.get() == paramInt)
          {
            paramList = a((oidb_0xc26.TabInfo)???);
            ??? = a(paramInt);
            if (??? != null)
            {
              k = ((ArrayList)???).size();
              if (QLog.isColorLevel()) {
                QLog.d("MayknowRecommendManager", 2, "onGetConnectionsPersonData update count " + k + " " + paramList.jdField_b_of_type_Int);
              }
              paramList.jdField_b_of_type_Int = (k + paramList.jdField_b_of_type_Int);
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramList == null) {
          break label574;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "onGetConnectionsPersonData update tabInfo" + paramList.toString());
        }
        synchronized (this.jdField_d_of_type_JavaLangObject)
        {
          if (this.jdField_c_of_type_JavaUtilArrayList != null)
          {
            localObject3 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              aixh localaixh = (aixh)((Iterator)localObject3).next();
              if ((localaixh.equals(paramList)) && ((localaixh.jdField_b_of_type_Int != paramList.jdField_b_of_type_Int) || (!localaixh.jdField_a_of_type_JavaLangString.equals(paramList.jdField_a_of_type_JavaLangString)) || (!localaixh.jdField_b_of_type_JavaLangString.equals(paramList.jdField_b_of_type_JavaLangString)) || (!localaixh.c.equals(paramList.c))))
              {
                localaixh.jdField_b_of_type_Int = paramList.jdField_b_of_type_Int;
                localaixh.jdField_a_of_type_JavaLangString = paramList.jdField_a_of_type_JavaLangString;
                localaixh.jdField_b_of_type_JavaLangString = paramList.jdField_b_of_type_JavaLangString;
                localaixh.c = paramList.c;
                d(this.jdField_c_of_type_JavaUtilArrayList);
              }
            }
          }
          paramList = new ArrayList();
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            paramArrayList = paramArrayList.iterator();
            for (;;)
            {
              if (paramArrayList.hasNext())
              {
                ??? = (MayKnowRecommend)paramArrayList.next();
                if (??? != null)
                {
                  paramList.add(((MayKnowRecommend)???).uin);
                  continue;
                  ??? = Integer.valueOf(paramArrayList.size());
                  break;
                  k = 0;
                }
              }
            }
          }
        }
      }
      if (paramBundle == null)
      {
        paramArrayList = localObject2;
        if (paramBundle != null) {
          break label597;
        }
      }
      label574:
      label597:
      for (k = 3;; k = paramBundle.getInt("update_type", 3))
      {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, paramList, String.valueOf(paramInt), paramArrayList);
        a(paramInt, paramArrayOfByte);
        return;
        paramArrayList = paramBundle.getString("from", "3");
        break;
      }
      paramList = null;
    }
  }
  
  public void a(View paramView, Context paramContext, String paramString)
  {
    int k = paramView.getId();
    if ((paramString.equals("sp_uin_for_title")) && (k == 2131376201))
    {
      paramView = bkho.a(paramContext);
      paramView.b(2131691104);
      paramView.c(2131690582);
      paramView.a(new anpm(this, paramView));
      paramView.show();
      bcst.b(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_ellipsis", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return;
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof aldh)))
      {
        paramView = (aldh)paramView.getTag();
        if (paramView.a == null) {
          break;
        }
        if ((paramView.a.mUser != null) && ((paramView.a.mUser.extraInfo instanceof RecentRecommendTroopItem))) {}
        for (paramView = (RecentRecommendTroopItem)paramView.a.mUser.extraInfo; paramView != null; paramView = null)
        {
          Object localObject;
          if (k == 2131363816)
          {
            paramString = "mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=" + paramView.uin + "&subsource_id=10017";
            localObject = new Intent(paramContext, JoinGroupTransitActivity.class);
            ((Intent)localObject).putExtra("source_scheme", paramString);
            paramContext.startActivity((Intent)localObject);
            bcst.b(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_add", 0, 0, paramView.uin, paramView.recomAlgol, "", "");
            return;
          }
          paramString = new GroupInfo();
          for (;;)
          {
            try
            {
              paramString.lCode = Long.valueOf(paramView.uin).longValue();
              paramString.strName = paramView.name;
              if (TextUtils.isEmpty(paramView.recommendReason))
              {
                paramString.strIntro = paramView.intro;
                paramString.iMemberCnt = paramView.memberNum;
                localObject = njn.a(paramView);
                if (localObject != null) {
                  paramString.labels = ((ArrayList)localObject);
                }
                paramString.strJoinSig = paramView.authSig;
                bfup.a(paramContext, bfup.a(107, paramString, 10018, false), 2);
                bcst.b(null, "dc00899", "Grp_recom", "", "msg_tab", "clk_grp", 0, 0, paramView.uin, paramView.recomAlgol, "", "");
                return;
              }
            }
            catch (Exception paramView)
            {
              QLog.d("MayknowRecommendManager", 1, "cast string2long error");
              return;
            }
            paramString.strIntro = paramView.recommendReason;
          }
        }
      }
    }
  }
  
  public void a(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        if ((!this.h) || (this.jdField_g_of_type_Boolean)) {
          return;
        }
        ??? = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(???))
        {
          paramMayKnowRecommend = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(???);
          if (paramInt3 != 1) {
            paramMayKnowRecommend.exposeCnt += 1;
          }
          if ((paramMayKnowRecommend.startExploseTime != 0L) || (paramInt3 != 1)) {
            break;
          }
          paramMayKnowRecommend.startExploseTime = SystemClock.uptimeMillis();
          return;
        }
      }
      paramMayKnowRecommend = new MayKnowExposure(paramMayKnowRecommend.uin, paramInt1, paramInt2, paramInt3, paramMayKnowRecommend.algBuffer, paramMayKnowRecommend.additive);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(???, paramMayKnowRecommend);
    }
  }
  
  public void a(String paramString)
  {
    int k;
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      try
      {
        Object localObject3 = new JSONObject(paramString);
        if (((JSONObject)localObject3).has("shield_sub_source_id"))
        {
          localObject3 = ((JSONObject)localObject3).getJSONArray("shield_sub_source_id");
          k = 0;
          while ((localObject3 != null) && (k < ((JSONArray)localObject3).length()))
          {
            int m = ((JSONArray)localObject3).getInt(k);
            this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(m));
            k += 1;
          }
        }
        ??? = new StringBuilder(100);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("MayknowRecommendManager", 2, "updateShieldConfig", localException);
        }
        if (!QLog.isColorLevel()) {
          break label238;
        }
      }
      ((StringBuilder)???).append("updateShieldConfig config: ").append(paramString).append("\r\n");
      ((StringBuilder)???).append("[");
      paramString = this.jdField_b_of_type_JavaUtilArrayList;
      k = 0;
    }
    try
    {
      while (k < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((StringBuilder)???).append(this.jdField_b_of_type_JavaUtilArrayList.get(k)).append(",");
        k += 1;
        continue;
        paramString = finally;
        throw paramString;
      }
      ((StringBuilder)???).append("]");
      QLog.i("MayknowRecommendManager", 2, ((StringBuilder)???).toString());
      label238:
      return;
    }
    finally {}
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeMayKnowRecommend, uin=" + paramString);
    }
    for (;;)
    {
      aixh localaixh;
      int k;
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)???).hasNext()) {
            break label431;
          }
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)???).next();
          if (!localMayKnowRecommend.uin.equals(paramString)) {
            break;
          }
          ((Iterator)???).remove();
          if ((paramBoolean) && (localMayKnowRecommend != null)) {
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localMayKnowRecommend);
          }
          p();
          if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_c_of_type_JavaUtilArrayList == null)) {
            break label340;
          }
          synchronized (this.jdField_c_of_type_JavaUtilArrayList)
          {
            if (this.jdField_c_of_type_JavaUtilArrayList == null) {
              break label337;
            }
            Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label337;
              }
              localaixh = (aixh)localIterator.next();
              label218:
              label223:
              synchronized (this.jdField_f_of_type_JavaLangObject)
              {
                if (localaixh.jdField_a_of_type_Int != 23) {
                  break label253;
                }
                if (localMayKnowRecommend != null)
                {
                  if (localaixh.jdField_b_of_type_Int <= 0) {
                    break;
                  }
                  k = localaixh.jdField_b_of_type_Int - 1;
                  localaixh.jdField_b_of_type_Int = k;
                }
              }
            }
          }
        }
        k = 0;
        break label218;
        label253:
        Object localObject3 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localaixh.jdField_a_of_type_Int));
        if (localObject3 != null)
        {
          localObject3 = ((ArrayList)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            if (!((MayKnowRecommend)((Iterator)localObject3).next()).uin.equals(paramString)) {
              break label223;
            }
            ((Iterator)localObject3).remove();
            localaixh.jdField_b_of_type_Int -= 1;
          }
        }
      }
      label337:
      label340:
      d(this.jdField_c_of_type_JavaUtilArrayList);
      if (paramBoolean) {}
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())
        {
          paramString = "delete from MayKnowRecommend where uin=" + paramString;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL(paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("MayknowRecommendManager", 2, "removeConnectionPerson, " + paramString.toString());
        return;
      }
      label431:
      MayKnowRecommend localMayKnowRecommend = null;
    }
  }
  
  /* Error */
  public void a(@NonNull ArrayList<MayKnowRecommend> paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 334	java/util/ArrayList:isEmpty	()Z
    //   8: ifeq +30 -> 38
    //   11: invokestatic 263	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +23 -> 37
    //   17: ldc_w 265
    //   20: iconst_2
    //   21: invokestatic 1313	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   24: ldc_w 1315
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 1319	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokestatic 280	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 351	anpk:b	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   43: astore 4
    //   45: aload 4
    //   47: astore_3
    //   48: aload 4
    //   50: invokeinterface 193 1 0
    //   55: sipush 1000
    //   58: if_icmple +15 -> 73
    //   61: aload 4
    //   63: iconst_0
    //   64: sipush 1000
    //   67: invokeinterface 1323 3 0
    //   72: astore_3
    //   73: getstatic 47	anpk:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   76: astore 4
    //   78: aload 4
    //   80: monitorenter
    //   81: aload_0
    //   82: getfield 140	anpk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: invokevirtual 1266	java/util/ArrayList:clear	()V
    //   88: aload_0
    //   89: getfield 140	anpk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   92: aload_3
    //   93: invokevirtual 355	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   96: pop
    //   97: aload 4
    //   99: monitorexit
    //   100: aload_0
    //   101: getfield 129	anpk:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   104: invokevirtual 361	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   107: astore 4
    //   109: aload 4
    //   111: invokevirtual 366	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   114: aload_0
    //   115: getfield 129	anpk:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   118: ldc_w 707
    //   121: invokevirtual 374	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   124: pop
    //   125: aload_3
    //   126: invokeinterface 193 1 0
    //   131: ifle +147 -> 278
    //   134: aload_3
    //   135: invokeinterface 552 1 0
    //   140: astore_3
    //   141: aload_3
    //   142: invokeinterface 383 1 0
    //   147: ifeq +131 -> 278
    //   150: aload_0
    //   151: aload_3
    //   152: invokeinterface 387 1 0
    //   157: checkcast 389	com/tencent/mobileqq/data/MayKnowRecommend
    //   160: invokevirtual 1325	anpk:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   163: pop
    //   164: goto -23 -> 141
    //   167: astore_3
    //   168: invokestatic 263	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +14 -> 185
    //   174: ldc_w 265
    //   177: iconst_2
    //   178: ldc_w 1327
    //   181: aload_3
    //   182: invokestatic 398	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload 4
    //   187: invokevirtual 401	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   190: iconst_0
    //   191: istore_2
    //   192: aload_0
    //   193: getfield 97	anpk:jdField_f_of_type_JavaLangObject	Ljava/lang/Object;
    //   196: astore_3
    //   197: aload_3
    //   198: monitorenter
    //   199: aload_0
    //   200: getfield 84	anpk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   203: ifnull +10 -> 213
    //   206: aload_0
    //   207: getfield 84	anpk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   210: invokevirtual 1328	java/util/HashMap:clear	()V
    //   213: aload_3
    //   214: monitorexit
    //   215: invokestatic 263	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -181 -> 37
    //   221: ldc_w 265
    //   224: iconst_2
    //   225: invokestatic 1313	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   228: ldc_w 1330
    //   231: iconst_3
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload_1
    //   238: invokevirtual 337	java/util/ArrayList:size	()I
    //   241: invokestatic 407	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload_0
    //   248: getfield 140	anpk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   251: invokevirtual 337	java/util/ArrayList:size	()I
    //   254: invokestatic 407	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_2
    //   260: iload_2
    //   261: invokestatic 1335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   264: aastore
    //   265: invokestatic 1319	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   268: invokestatic 280	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: return
    //   272: astore_1
    //   273: aload 4
    //   275: monitorexit
    //   276: aload_1
    //   277: athrow
    //   278: aload 4
    //   280: invokevirtual 417	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   283: aload 4
    //   285: invokevirtual 401	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   288: iconst_1
    //   289: istore_2
    //   290: goto -98 -> 192
    //   293: astore_1
    //   294: aload 4
    //   296: invokevirtual 401	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   299: aload_1
    //   300: athrow
    //   301: astore_1
    //   302: aload_3
    //   303: monitorexit
    //   304: aload_1
    //   305: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	anpk
    //   0	306	1	paramArrayList	ArrayList<MayKnowRecommend>
    //   191	99	2	bool	boolean
    //   47	105	3	localObject1	Object
    //   167	15	3	localException	Exception
    //   43	252	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   109	141	167	java/lang/Exception
    //   141	164	167	java/lang/Exception
    //   278	283	167	java/lang/Exception
    //   81	100	272	finally
    //   273	276	272	finally
    //   109	141	293	finally
    //   141	164	293	finally
    //   168	185	293	finally
    //   278	283	293	finally
    //   199	213	301	finally
    //   213	215	301	finally
    //   302	304	301	finally
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
    QLog.i("MayknowRecommendManager", 1, "saveEntryOpenList,MsgEntryOpen=" + bool1 + ",HeadEntryOpen=" + bool2 + ", RecommendEntryOpen=" + bool3 + ", NewEntryOpen=" + bool4 + ", EntryAdd=" + bool5);
  }
  
  /* Error */
  public void a(List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 575 1 0
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: new 131	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 138	java/util/ArrayList:<init>	()V
    //   21: astore 7
    //   23: getstatic 47	anpk:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   26: astore 8
    //   28: aload 8
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 140	anpk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   35: invokevirtual 378	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   38: astore 9
    //   40: aload 9
    //   42: invokeinterface 383 1 0
    //   47: ifeq +92 -> 139
    //   50: aload 9
    //   52: invokeinterface 387 1 0
    //   57: checkcast 389	com/tencent/mobileqq/data/MayKnowRecommend
    //   60: astore 10
    //   62: aload 10
    //   64: ifnull -24 -> 40
    //   67: aload_1
    //   68: aload 10
    //   70: getfield 614	com/tencent/mobileqq/data/MayKnowRecommend:uin	Ljava/lang/String;
    //   73: invokeinterface 1337 2 0
    //   78: ifeq -38 -> 40
    //   81: iload 6
    //   83: ifeq +39 -> 122
    //   86: aload 10
    //   88: getfield 1363	com/tencent/mobileqq/data/MayKnowRecommend:cardDisplayTimestamp	J
    //   91: lload 4
    //   93: ladd
    //   94: lload_2
    //   95: lcmp
    //   96: ifge -56 -> 40
    //   99: aload 10
    //   101: lload_2
    //   102: putfield 1363	com/tencent/mobileqq/data/MayKnowRecommend:cardDisplayTimestamp	J
    //   105: aload 7
    //   107: aload 10
    //   109: invokevirtual 623	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   112: pop
    //   113: goto -73 -> 40
    //   116: astore_1
    //   117: aload 8
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: aload 10
    //   124: lload_2
    //   125: putfield 1363	com/tencent/mobileqq/data/MayKnowRecommend:cardDisplayTimestamp	J
    //   128: aload 7
    //   130: aload 10
    //   132: invokevirtual 623	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -96 -> 40
    //   139: aload 8
    //   141: monitorexit
    //   142: aload 7
    //   144: invokevirtual 334	java/util/ArrayList:isEmpty	()Z
    //   147: ifne -134 -> 13
    //   150: aload_0
    //   151: getfield 129	anpk:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   154: invokevirtual 361	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 366	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   162: aload 7
    //   164: invokevirtual 378	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   167: astore 7
    //   169: aload 7
    //   171: invokeinterface 383 1 0
    //   176: ifeq +47 -> 223
    //   179: aload 7
    //   181: invokeinterface 387 1 0
    //   186: checkcast 389	com/tencent/mobileqq/data/MayKnowRecommend
    //   189: astore 8
    //   191: aload 8
    //   193: ifnull -24 -> 169
    //   196: aload_0
    //   197: aload 8
    //   199: invokevirtual 1325	anpk:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   202: pop
    //   203: goto -34 -> 169
    //   206: astore 7
    //   208: ldc_w 265
    //   211: iconst_1
    //   212: ldc_w 1365
    //   215: invokestatic 1059	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_1
    //   219: invokevirtual 401	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   222: return
    //   223: aload_1
    //   224: invokevirtual 417	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   227: aload_1
    //   228: invokevirtual 401	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   231: return
    //   232: astore 7
    //   234: aload_1
    //   235: invokevirtual 401	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   238: aload 7
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	anpk
    //   0	241	1	paramList	List<String>
    //   0	241	2	paramLong1	long
    //   0	241	4	paramLong2	long
    //   0	241	6	paramBoolean	boolean
    //   21	159	7	localObject1	Object
    //   206	1	7	localThrowable	Throwable
    //   232	7	7	localObject2	Object
    //   26	172	8	localObject3	Object
    //   38	13	9	localIterator	Iterator
    //   60	71	10	localMayKnowRecommend	MayKnowRecommend
    // Exception table:
    //   from	to	target	type
    //   31	40	116	finally
    //   40	62	116	finally
    //   67	81	116	finally
    //   86	113	116	finally
    //   117	120	116	finally
    //   122	136	116	finally
    //   139	142	116	finally
    //   158	169	206	java/lang/Throwable
    //   169	191	206	java/lang/Throwable
    //   196	203	206	java/lang/Throwable
    //   223	227	206	java/lang/Throwable
    //   158	169	232	finally
    //   169	191	232	finally
    //   196	203	232	finally
    //   208	218	232	finally
    //   223	227	232	finally
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
      }
      if (!paramList.isEmpty())
      {
        k = 0;
        paramBundle = paramBundle.getString("from", "");
        if (!"fetch".equals(paramBundle)) {
          break label391;
        }
        k = 3;
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, paramList);
      }
    }
    boolean bool;
    if (paramInt2 != 0)
    {
      bool = true;
      label186:
      localEditor.putBoolean("sp_mayknow_entry_is_up", bool);
      if (paramInt3 != 1) {
        break label414;
      }
      bool = true;
      label208:
      localEditor.putBoolean("sp_mayknow_ml_s_a_vl", bool);
      if (paramInt4 != 1) {
        break label420;
      }
      bool = true;
      label230:
      localEditor.putBoolean("sp_mayknow_addpage_s_a_vl", bool);
      localEditor.commit();
      if (paramInt3 != 1) {
        break label426;
      }
      bool = true;
      label260:
      this.jdField_b_of_type_Boolean = bool;
      if (paramInt4 != 1) {
        break label432;
      }
      bool = true;
      label275:
      this.jdField_c_of_type_Boolean = bool;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      if (paramArrayList != null) {
        break label438;
      }
    }
    label391:
    label414:
    label420:
    label426:
    label432:
    label438:
    for (int k = 0;; k = paramArrayList.size())
    {
      QLog.i("MayknowRecommendManager", 1, "handleReqMayknownFriendList, isSuc = " + paramBoolean + ",dataSize=" + k + ",timestamp=" + paramInt1 + ",isMsgUp=" + paramInt2 + ",msgTabListSwitch=" + paramInt3 + ",addPageListSwitch=" + paramInt4);
      return;
      if (!"push".equals(paramBundle)) {
        break;
      }
      k = 2;
      break;
      bool = false;
      break label186;
      bool = false;
      break label208;
      bool = false;
      break label230;
      bool = false;
      break label260;
      bool = false;
      break label275;
    }
  }
  
  public void a(boolean paramBoolean, List<oidb_0xc26.RecommendInfo> arg2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("handleReqRecommendTroopList success: ").append(paramBoolean).append(" trooplist size: ");
      if (??? != null) {
        break label71;
      }
    }
    label71:
    for (int k = 0;; k = ???.size())
    {
      QLog.i("MayknowRecommendManager", 2, k);
      if ((paramBoolean) && (??? != null) && (!???.isEmpty())) {
        break;
      }
      return;
    }
    Object localObject1 = new ArrayList();
    localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    localEntityTransaction.begin();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("delete from RecentRecommendTroopItem");
    Iterator localIterator1 = ???.iterator();
    while (localIterator1.hasNext())
    {
      ??? = ((oidb_0xc26.RecommendInfo)localIterator1.next()).msg_groups.get();
      if ((??? != null) && (!???.isEmpty()))
      {
        Iterator localIterator2 = ???.iterator();
        label171:
        oidb_0xc26.RgroupInfo localRgroupInfo;
        RecentRecommendTroopItem localRecentRecommendTroopItem;
        while (localIterator2.hasNext())
        {
          localRgroupInfo = (oidb_0xc26.RgroupInfo)localIterator2.next();
          localRecentRecommendTroopItem = new RecentRecommendTroopItem();
          if (localRgroupInfo.uint64_group_code.has())
          {
            localRecentRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
            if (localRgroupInfo.bytes_group_name.has()) {
              localRecentRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
            }
            if (localRgroupInfo.bytes_group_memo.has()) {
              localRecentRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
            }
            localRecentRecommendTroopItem.labelList = antq.b(localRgroupInfo.rpt_group_label.get());
            localRecentRecommendTroopItem.labelStr = "";
            a(localRecentRecommendTroopItem);
            localRecentRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
            localRecentRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
            if (!localRgroupInfo.bytes_algorithm.has()) {
              break label515;
            }
            ??? = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
            label372:
            localRecentRecommendTroopItem.recomAlgol = ???;
            if (!localRgroupInfo.bytes_join_group_auth.has()) {
              break label521;
            }
            ??? = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
            label401:
            localRecentRecommendTroopItem.authSig = ???;
            if (!localRgroupInfo.uint32_activity.has()) {
              break label527;
            }
            k = localRgroupInfo.uint32_activity.get();
            label427:
            localRecentRecommendTroopItem.activity = k;
            if (!localRgroupInfo.int32_uin_privilege.has()) {
              break label532;
            }
          }
        }
        label515:
        label521:
        label527:
        label532:
        for (k = localRgroupInfo.int32_uin_privilege.get();; k = -1)
        {
          localRecentRecommendTroopItem.privilege = k;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(localRecentRecommendTroopItem);
          ((List)localObject1).add(localRecentRecommendTroopItem);
          if (!QLog.isColorLevel()) {
            break label171;
          }
          QLog.d("MayknowRecommendManager", 2, "saveNotificationRecommendTroop into db, recommend troop = " + localRecentRecommendTroopItem);
          break label171;
          break;
          ??? = "";
          break label372;
          ??? = "";
          break label401;
          k = 0;
          break label427;
        }
      }
    }
    for (;;)
    {
      try
      {
        localEntityTransaction.commit();
      }
      catch (Exception ???)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MayknowRecommendManager", 2, "saveRecommendTroop commit error");
        localEntityTransaction.end();
        continue;
      }
      finally
      {
        localEntityTransaction.end();
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
        this.jdField_f_of_type_Int = 0;
        this.jdField_b_of_type_Long = 0L;
        return;
      }
    }
  }
  
  public boolean a()
  {
    if (!this.j)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if ((localPhoneContactManagerImp == null) || (localPhoneContactManagerImp.d() < 9)) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      this.i = bool;
      this.j = true;
      return this.i;
    }
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public boolean a(int paramInt, Bundle paramBundle)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "getMayKnowRecommendRemote entryType = " + paramInt);
    }
    if (!b(paramInt))
    {
      QLog.i("MayknowRecommendManager", 1, String.format("getMayKnowRecommendRemote, isTimeToObtainRemote is false, entryType = " + paramInt, new Object[0]));
      if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("sp_mayknow_818_first_install", true)) {
        return bool;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_mayknow_818_first_install", false).commit();
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "getMayKnowRecommendRemote is818FirstInstall");
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new MayknowRecommendManager.6(this, paramInt, paramBundle));
    bool = true;
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
    QLog.d("MayknowRecommendManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onMsgTabRecommendBItemRemove uin = " + paramString + ",conversationTabDisplayAsVerticalListItem = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      paramString = (RecentUser)localaong.findRecentUser(paramString, 8112);
      if (paramString != null)
      {
        localaong.delRecentUser(paramString);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(List<RecentBaseData> paramList)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData");
    }
    boolean bool1;
    Object localObject;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = b("sp_mayknow_entry_list_msg");
      boolean bool3 = b("sp_mayknow_entry_is_up");
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData showConversationMayKnow = " + bool1 + ",shouldRiseUp = " + bool3);
      }
      if ((bool1) && (bool3))
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (RecentBaseData)localIterator.next();
            if ((localObject instanceof RecentItemMayKnowFriendData))
            {
              localObject = (RecentItemMayKnowFriendData)localObject;
              localIterator.remove();
              if (localObject != null)
              {
                localIterator = paramList.iterator();
                int k = 0;
                label208:
                while (localIterator.hasNext())
                {
                  if ((((RecentBaseData)localIterator.next()).mMenuFlag & 0xF0) != 32) {
                    break label579;
                  }
                  k += 1;
                }
                int m = paramList.size();
                int n = a(paramList, k, m);
                paramList.add(n, localObject);
                if (QLog.isColorLevel()) {
                  QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData insertIndex = " + n + ",setTopItemCount = " + k + ",listsize = " + m);
                }
                long l = NetConnInfoCenter.getServerTime();
                if (((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime < l) {
                  ((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime = l;
                }
                if (n > 0)
                {
                  paramList = (RecentBaseData)paramList.get(n - 1);
                  if ((paramList.mMenuFlag & 0xF0) != 32) {
                    break;
                  }
                }
                else
                {
                  label352:
                  if (QLog.isColorLevel()) {
                    QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData insertIndex = " + n + ",setTopItemCount = " + k + ",listsize = " + m + ",lastmsgtime = " + ((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().saveRecentUser(((RecentItemMayKnowFriendData)localObject).mUser);
                  this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_mayknow_entry_is_up", false);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData result = " + bool1);
      }
      return bool1;
      if ((!(paramList instanceof RecentUserBaseData)) || (((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime <= ((RecentUserBaseData)paramList).mUser.lastmsgtime)) {
        break label352;
      }
      ((RecentItemMayKnowFriendData)localObject).mUser.lastmsgtime = (((RecentUserBaseData)paramList).mUser.lastmsgtime - 1L);
      break label352;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MayknowRecommendManager", 2, "checkAndReOrderRecentData mayKnowFriendData is null ");
        bool1 = bool2;
        continue;
        label579:
        break label208;
        localObject = null;
        break;
        bool1 = true;
      }
    }
  }
  
  public boolean a(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    Object localObject2;
    Object localObject3;
    MayKnowRecommend localMayKnowRecommend;
    if (paramBoolean)
    {
      paramList = b(new ArrayList(paramList));
      localObject2 = new ArrayList(2);
      ??? = paramList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (MayKnowRecommend)((Iterator)???).next();
        if (localObject3 != null)
        {
          ((MayKnowRecommend)localObject3).cardDisplayTimestamp = NetConnInfoCenter.getServerTimeMillis();
          ((List)localObject2).add(((MayKnowRecommend)localObject3).uin);
        }
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((paramList.size() <= 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() + paramList.size() >= 1000)) {
          break label436;
        }
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject3).next();
          if ((localMayKnowRecommend != null) && (((List)localObject2).contains(localMayKnowRecommend.uin))) {
            ((Iterator)localObject3).remove();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(0, paramList);
    }
    label436:
    for (paramList = new LinkedList(this.jdField_a_of_type_JavaUtilArrayList);; paramList = null)
    {
      localObject2 = new ArrayList();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject3).next();
          if (localMayKnowRecommend != null) {
            ((ArrayList)localObject2).add(localMayKnowRecommend.uin);
          }
        }
      }
      if (!((ArrayList)localObject2).isEmpty()) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (ArrayList)localObject2);
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        try
        {
          ((EntityTransaction)???).begin();
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL("delete from MayKnowRecommend where tabID=23");
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject2 = (MayKnowRecommend)paramList.next();
            if (localObject2 != null)
            {
              ((MayKnowRecommend)localObject2).setStatus(1000);
              a((Entity)localObject2);
            }
          }
          return false;
        }
        catch (Exception paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "handleMayKnowPushAdd ex", paramList);
          }
          return false;
          ((EntityTransaction)???).commit();
          return true;
        }
        finally
        {
          ((EntityTransaction)???).end();
        }
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_version", 0);
  }
  
  public ArrayList<String> b()
  {
    int k = 0;
    p();
    ArrayList localArrayList = new ArrayList(4);
    Object localObject3 = null;
    Object localObject4 = this.jdField_d_of_type_JavaLangObject;
    Object localObject1 = localObject3;
    try
    {
      if (this.jdField_c_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject3;
        if (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
          localObject1 = (aixh)this.jdField_c_of_type_JavaUtilArrayList.get(0);
        }
      }
      if (localObject1 != null)
      {
        localObject1 = a(((aixh)localObject1).jdField_a_of_type_Int);
        if (localObject1 != null) {
          while ((k < ((ArrayList)localObject1).size()) && (k < 4))
          {
            localArrayList.add(((MayKnowRecommend)((ArrayList)localObject1).get(k)).uin);
            k += 1;
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label160;
      }
    }
    finally {}
    QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonUinListFroAddActivity " + localArrayList.toString());
    label160:
    return localArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConnectionsDataExceptRecommendTab ");
    }
    p();
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aixh localaixh = (aixh)localIterator.next();
        if (localaixh.jdField_a_of_type_Int != 23)
        {
          a(localaixh.jdField_a_of_type_Int, new ArrayList(0), true);
          a(localaixh.jdField_a_of_type_Int, null);
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConnectionTab " + paramInt);
    }
    a(paramInt, new ArrayList(0), true);
    p();
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList == null) {
          break label155;
        }
        Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((aixh)localIterator.next()).jdField_a_of_type_Int != paramInt) {
            continue;
          }
          localIterator.remove();
          k = 1;
          m = k;
          if (k != 0)
          {
            d(this.jdField_c_of_type_JavaUtilArrayList);
            m = k;
          }
          if (m != 0) {
            a(paramInt, null);
          }
          return;
        }
      }
      int k = 0;
      continue;
      label155:
      int m = 0;
    }
  }
  
  public void b(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage entryType = " + paramInt1 + " tabID=" + paramInt2);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new MayknowRecommendManager.5(this, paramInt2, paramInt1, paramBundle));
  }
  
  public void b(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if ((!this.h) || (this.jdField_g_of_type_Boolean)) {
        return;
      }
      paramMayKnowRecommend = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMayKnowRecommend))
      {
        paramMayKnowRecommend = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMayKnowRecommend);
        if ((paramInt3 == 1) && (paramMayKnowRecommend.startExploseTime != 0L))
        {
          paramMayKnowRecommend.exposeTime = ((int)(SystemClock.uptimeMillis() - paramMayKnowRecommend.startExploseTime + paramMayKnowRecommend.exposeTime));
          paramMayKnowRecommend.exposeCnt += 1;
          paramMayKnowRecommend.startExploseTime = 0L;
          return;
        }
      }
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
    int i2 = 0;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong("sp_get_mayknow_timestamp_v3_for_card_header", System.currentTimeMillis());
    localEditor.putLong("sp_get_mayknow_timestamp_v2", System.currentTimeMillis());
    int i1;
    int n;
    int m;
    int k;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      i2 = 0;
      i1 = 0;
      n = 0;
      m = 0;
      k = 0;
      if (paramList.hasNext())
      {
        oidb_0xc26.EntryDelay localEntryDelay = (oidb_0xc26.EntryDelay)paramList.next();
        int i3;
        int i4;
        switch (localEntryDelay.em_entry.get())
        {
        default: 
          i3 = i2;
          i4 = i1;
          i2 = k;
          i1 = m;
          m = i4;
          k = i3;
        }
        for (;;)
        {
          i3 = i2;
          i4 = i1;
          i2 = k;
          i1 = m;
          m = i4;
          k = i3;
          break;
          i3 = localEntryDelay.uint32_delay.get();
          k = i2;
          i2 = m;
          m = i1;
          i1 = i2;
          i2 = i3;
          continue;
          i3 = localEntryDelay.uint32_delay.get();
          m = i1;
          i1 = i3;
          i3 = k;
          k = i2;
          i2 = i3;
          continue;
          n = localEntryDelay.uint32_delay.get();
          i3 = m;
          i4 = k;
          k = i2;
          m = i1;
          i1 = i3;
          i2 = i4;
          continue;
          i1 = localEntryDelay.uint32_delay.get();
          i3 = m;
          i4 = k;
          k = i2;
          m = i1;
          i1 = i3;
          i2 = i4;
          continue;
          i4 = localEntryDelay.uint32_delay.get();
          i2 = m;
          i3 = k;
          k = i4;
          m = i1;
          i1 = i2;
          i2 = i3;
        }
      }
    }
    for (;;)
    {
      if (k > 0) {
        localEditor.putLong("pull_interval_conversation_tab", k * 1000);
      }
      if (m > 0) {
        localEditor.putLong("pull_interval_contact_head", m * 1000);
      }
      if (n > 0) {
        localEditor.putLong("pull_interval_recommend_tab", n * 1000);
      }
      if (i1 > 0) {
        localEditor.putLong("pull_interval_new_friend", i1 * 1000);
      }
      if (i2 > 0) {
        localEditor.putLong("pull_interval_add_page", i2 * 1000);
      }
      localEditor.commit();
      QLog.i("MayknowRecommendManager", 1, "saveReqTimeAndIntervalInfo,msgIntervel = " + k + ",headIntervel = " + m + ",recommendIntervel = " + n + ",newIntervel = " + i1 + ",addIntervel = " + i2);
      return;
      i1 = 0;
      n = 0;
      m = 0;
      k = 0;
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (this.jdField_b_of_type_Int != 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MayknowRecommendManager", 2, "shouldShowRecommendTroop result: " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean b(int paramInt)
  {
    long l1;
    long l2;
    if (paramInt == 2)
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_get_mayknow_timestamp_v3_for_card_header", 0L);
      l2 = a(paramInt);
      if (Math.abs(l1 - System.currentTimeMillis()) < l2) {
        break label142;
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("MayknowRecommendManager", 1, String.format(new StringBuilder().append("isTimeToObtainRemote, return=").append(bool).append(", lastTime").append(l1).toString(), new Object[0]) + ", pullInternalTime" + l2 + ",entryType = " + paramInt);
      return bool;
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_get_mayknow_timestamp_v2", 0L);
      break;
    }
  }
  
  public boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, false);; bool1 = false)
    {
      boolean bool3 = bool1;
      if (this.jdField_b_of_type_Int == 1)
      {
        boolean bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!TextUtils.equals(paramString, "sp_mayknow_ml_s_a_vl"))
          {
            bool2 = bool1;
            if (!TextUtils.equals(paramString, "sp_mayknow_addpage_s_a_vl"))
            {
              bool2 = bool1;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                ajld localajld = (ajld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295);
                bool2 = bool1;
                if (localajld != null)
                {
                  bool2 = bool1;
                  if (localajld.b())
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
          QLog.i("MayknowRecommendManager", 2, "getSPSwitchState name:" + paramString + "  open:" + bool2);
          bool3 = bool2;
        }
      }
      return bool3;
    }
  }
  
  public boolean b(boolean paramBoolean, List<String> arg2)
  {
    if ((??? == null) || (???.isEmpty())) {
      return false;
    }
    if (paramBoolean)
    {
      LinkedList localLinkedList = new LinkedList();
      Object localObject4;
      MayKnowRecommend localMayKnowRecommend;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject4).next();
          if ((localMayKnowRecommend != null) && (???.contains(localMayKnowRecommend.uin)))
          {
            localLinkedList.add(localMayKnowRecommend);
            ((Iterator)localObject4).remove();
          }
        }
      }
      ??? = new ArrayList();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject4).next();
          if (localMayKnowRecommend != null) {
            ((ArrayList)???).add(localMayKnowRecommend.uin);
          }
        }
      }
      if (!((ArrayList)???).isEmpty()) {
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (ArrayList)???);
      }
      if (!localObject1.isEmpty())
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        try
        {
          ???.begin();
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            ??? = (MayKnowRecommend)localIterator.next();
            if (??? != null)
            {
              localObject4 = ((MayKnowRecommend)???).uin;
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)???, "uin=?", new String[] { localObject4 });
            }
          }
          return false;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "handleMayKnowPushDel ex", localException);
          }
          return false;
          ???.commit();
          return true;
        }
        finally
        {
          ???.end();
        }
      }
    }
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
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "prepareConversationTabRecommendTroopList troopItems size: " + this.jdField_a_of_type_JavaUtilList.size() + " switch open: " + bool);
    }
    Object localObject4 = new ArrayList();
    label413:
    label414:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        ((List)localObject4).addAll(this.jdField_a_of_type_JavaUtilList);
        if ((localObject4 != null) && (!((List)localObject4).isEmpty()) && (bool))
        {
          aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          localaong.deleteRecentUserByType(8112);
          ??? = (RecentUser)localaong.findRecentUser(anhk.ag, 8111);
          if (??? != null) {
            localaong.delRecentUser((BaseRecentUser)???);
          }
          localaong.deleteRecentUserByType(8113);
          Object localObject2 = (RecentUser)localaong.findRecentUser("sp_uin_for_title", 8113);
          ??? = localObject2;
          if (localObject2 == null) {
            ??? = new RecentUser("sp_uin_for_title", 8113);
          }
          long l = -1L - 1L;
          ((RecentUser)???).lastmsgtime = l;
          ((RecentUser)???).lastmsgdrafttime = -500L;
          ((RecentUser)???).opTime = -500L;
          localaong.saveRecentUser((BaseRecentUser)???);
          Iterator localIterator = ((List)localObject4).iterator();
          if (!localIterator.hasNext()) {
            break label413;
          }
          RecentRecommendTroopItem localRecentRecommendTroopItem = (RecentRecommendTroopItem)localIterator.next();
          ??? = (RecentUser)localaong.findRecentUser(localRecentRecommendTroopItem.uin, 8113);
          if (??? != null) {
            break label414;
          }
          ??? = new RecentUser(localRecentRecommendTroopItem.uin, 8113);
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
          localaong.saveRecentUser((BaseRecentUser)???);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteRecentUserByType(8113);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(null, null, paramInt, null);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onContactsTabTroopItemDeleted troop uin: " + paramString);
    }
    a(paramString);
    ((antq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22)).a(paramString, new anpq(this, paramString));
    this.jdField_e_of_type_Int -= 1;
    paramString = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if (this.jdField_e_of_type_Int == 0)
    {
      this.jdField_c_of_type_Long = NetConnInfoCenter.getServerTime();
      paramString.putLong("sp_contacts_tab_recommend_troop_hide_time", this.jdField_c_of_type_Long);
      bcst.b(null, "dc00899", "Grp_recom", "", "link_top", "clk_hide", 0, 0, "", "", "", "");
    }
    paramString.putInt("sp_contacts_tab_recommend_troop_count", this.jdField_e_of_type_Int);
    paramString.commit();
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).notifyUI(92, true, null);
  }
  
  public boolean c()
  {
    boolean bool1 = b();
    boolean bool2 = bdch.a();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowRecommendTroopInConversation, showRecommendTroop: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "prepareConversationMayKnowRecenUser ，conversationTabDisplayAsVerticalListItem = " + this.jdField_b_of_type_Boolean);
    }
    if ((!b("sp_mayknow_entry_list_msg")) || (this.jdField_b_of_type_Int != 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "prepareConversationMayKnowRecenUser hideConversationMayKnow  return ");
      }
    }
    Object localObject2;
    do
    {
      return;
      localObject2 = c();
    } while ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0));
    aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    g(8113);
    Object localObject1;
    RecentUser localRecentUser;
    long l;
    MayKnowRecommend localMayKnowRecommend;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject1 = (RecentUser)localaong.findRecentUser(anhk.ag, 8111);
      if (localObject1 != null) {
        localaong.delRecentUser((BaseRecentUser)localObject1);
      }
      g(8112);
      localRecentUser = (RecentUser)localaong.findRecentUser("sp_uin_for_title", 8112);
      localObject1 = localRecentUser;
      if (localRecentUser == null) {
        localObject1 = new RecentUser("sp_uin_for_title", 8112);
      }
      l = 0L - 1L;
      ((RecentUser)localObject1).lastmsgtime = l;
      ((RecentUser)localObject1).lastmsgdrafttime = -500L;
      ((RecentUser)localObject1).opTime = -500L;
      localaong.saveRecentUser((BaseRecentUser)localObject1);
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      if (!localIterator.hasNext()) {
        break label474;
      }
      localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
      localRecentUser = (RecentUser)localaong.findRecentUser(localMayKnowRecommend.uin, 8112);
      if (localRecentUser != null) {
        break label491;
      }
      localRecentUser = new RecentUser(localMayKnowRecommend.uin, 8112);
    }
    label474:
    label491:
    for (;;)
    {
      localObject2 = localMayKnowRecommend.remark;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = localMayKnowRecommend.mobile_name;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localMayKnowRecommend.nick;
        }
      }
      localRecentUser.displayName = ((String)localObject1);
      localRecentUser.extraInfo = localMayKnowRecommend;
      l -= 1L;
      localRecentUser.lastmsgtime = l;
      localRecentUser.lastmsgdrafttime = -500L;
      localRecentUser.opTime = -500L;
      localaong.saveRecentUser(localRecentUser);
      break;
      g(8112);
      localRecentUser = (RecentUser)localaong.findRecentUser(anhk.ag, 8111);
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "prepareConversationMayKnowRecenUser mayKnowRecommends.size = " + ((ArrayList)localObject2).size() + ",ru = " + localRecentUser);
      }
      localObject1 = localRecentUser;
      if (localRecentUser == null) {
        localObject1 = new RecentUser(anhk.ag, 8111);
      }
      localaong.saveRecentUser((BaseRecentUser)localObject1);
      ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(146)).f();
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).notifyUI(123, true, new Object[] { Integer.valueOf(paramInt) });
    }
    this.jdField_b_of_type_Int = paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putInt("sp_conversation_tab_show_type", paramInt);
    localEditor.commit();
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "saveConversationTabShowType type is: " + paramInt);
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onConversationTabTroopItemDeleted uin:" + paramString);
    }
    Object localObject = a(paramString);
    ((antq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22)).a(paramString, new anpl(this, paramString));
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    localFriendListHandler.notifyUI(92, true, null);
    localFriendListHandler.notifyUI(122, true, new Object[] { paramString });
    if (localObject == null)
    {
      paramString = "";
      if (localObject != null) {
        break label148;
      }
    }
    label148:
    for (localObject = "";; localObject = ((RecentRecommendTroopItem)localObject).recomAlgol)
    {
      bcst.b(null, "dc00899", "Grp_recom", "", "msg_tab", "slide_delete", 0, 0, paramString, (String)localObject, "", "");
      return;
      paramString = ((RecentRecommendTroopItem)localObject).uin;
      break;
    }
  }
  
  public boolean d()
  {
    boolean bool1 = b("sp_mayknow_entry_list_msg");
    boolean bool2 = bdch.a();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowConversationMayKnow, mayKnowListSwitch: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConversationMayKnowRecentUser  ，conversationTabDisplayAsVerticalListItem = " + this.jdField_b_of_type_Boolean);
    }
    aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    g(8112);
    RecentUser localRecentUser = (RecentUser)localaong.findRecentUser(anhk.ag, 8111);
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "removeConversationMayKnowRecentUser ,ru = " + localRecentUser);
    }
    if (localRecentUser != null) {
      localaong.delRecentUser(localRecentUser);
    }
    ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(146)).e();
  }
  
  public void e(String paramString)
  {
    a(paramString);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).notifyUI(122, true, new Object[] { paramString });
  }
  
  public boolean e()
  {
    boolean bool1 = b("sp_mayknow_entry_list_new");
    boolean bool2 = bdch.a();
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, String.format("shouldShowMayKnowInNewFriend, mayKnowListSwitch: %s, isStudyMode: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (!bool2);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null)) {}
    for (;;)
    {
      return;
      Object localObject4 = null;
      EntityTransaction localEntityTransaction = null;
      Object localObject2 = localEntityTransaction;
      Object localObject1 = localObject4;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        localObject2 = localEntityTransaction;
        localObject1 = localObject4;
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
        localObject2 = localEntityTransaction;
        localObject1 = localEntityTransaction;
        localEntityTransaction.begin();
        for (;;)
        {
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          localObject4 = (MayKnowExposure)((Map.Entry)localIterator.next()).getValue();
          localObject2 = localEntityTransaction;
          localObject1 = localEntityTransaction;
          if (((MayKnowExposure)localObject4).exposeCnt > 0)
          {
            localObject2 = localEntityTransaction;
            localObject1 = localEntityTransaction;
            a((Entity)localObject4);
          }
        }
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject2;
          QLog.e("MayknowRecommendManager", 2, "saveExplosures", localException);
        }
        return;
        localObject2 = localException;
        localObject1 = localException;
        localException.commit();
        localObject2 = localException;
        localObject1 = localException;
        if (QLog.isColorLevel())
        {
          localObject2 = localException;
          localObject1 = localException;
          QLog.d("MayknowRecommendManager", 2, "saveExplosures count = " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        }
        localObject2 = localException;
        localObject1 = localException;
        localObject4 = jdField_b_of_type_JavaLangObject;
        localObject2 = localException;
        localObject1 = localException;
        try
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          }
          if (localException == null) {
            continue;
          }
          localException.end();
          return;
        }
        finally
        {
          localObject2 = localException;
          localObject1 = localException;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((EntityTransaction)localObject1).end();
        }
      }
    }
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteRecentUserByType(8113);
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putBoolean("sp_mayknow_entry_list_msg", false);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    ((FriendListHandler)localObject).notifyUI(92, true, null);
    ((FriendListHandler)localObject).i();
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
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new MayknowRecommendManager.13(this));
      ContactReportUtils.a();
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
    f();
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)) && (this.jdField_a_of_type_Awna != null)) {
        ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Awna);
      }
      this.jdField_a_of_type_Awna = null;
      bdch.b(this.jdField_a_of_type_Bdci);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpk
 * JD-Core Version:    0.7.0.1
 */