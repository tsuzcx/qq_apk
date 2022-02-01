import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager.2;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager.4;
import com.tencent.mobileqq.gamecenter.message.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class avld
  implements Observer, Manager
{
  private static final String jdField_a_of_type_JavaLangString = avln.jdField_a_of_type_JavaLangString + "GameMsgManager";
  private static boolean jdField_d_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private areh jdField_a_of_type_Areh = new areh();
  private avlo jdField_a_of_type_Avlo = new avle(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GameMsgManager.2(this);
  private Map<String, GameUserInfo> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  public boolean a;
  private Map<String, GameBasicInfo> b = Collections.synchronizedMap(new HashMap());
  public boolean b;
  private Map<String, GameSwitchConfig> c = Collections.synchronizedMap(new HashMap());
  public boolean c;
  private Map<String, GameCenterSessionInfo> jdField_d_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, GameCenterSessionInfo> e = new ConcurrentHashMap();
  private Map<String, GameCenterSessionInfo> f = new ConcurrentHashMap();
  
  public avld(QQAppInterface paramQQAppInterface)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[GameMsgManager] start");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[GameMsgManager] end");
  }
  
  private ArrayList<String> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      GameUserInfo localGameUserInfo = a(str);
      if (localGameUserInfo == null)
      {
        localArrayList.add(str);
        QLog.i(jdField_a_of_type_JavaLangString, 2, "case 1: can't find in local, roldId:" + str);
      }
      else
      {
        long l2 = l1 - localGameUserInfo.mSaveTs;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "delta:" + l2);
        }
        if (l2 >= 120000L)
        {
          localArrayList.add(str);
          QLog.i(jdField_a_of_type_JavaLangString, 2, "case 2: it's time to update, roldId:" + str);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(GameBasicInfo paramGameBasicInfo)
  {
    if ((paramGameBasicInfo == null) || (TextUtils.isEmpty(paramGameBasicInfo.mAppId))) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[updateGameConfigItem], appId:" + paramGameBasicInfo.mAppId);
    this.b.put(paramGameBasicInfo.mAppId, paramGameBasicInfo);
    a(paramGameBasicInfo);
  }
  
  private void a(GameUserInfo paramGameUserInfo)
  {
    if ((paramGameUserInfo == null) || (TextUtils.isEmpty(paramGameUserInfo.mRoleId))) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[updateGameUsrInfoItem], roleId:" + paramGameUserInfo.mRoleId);
    this.jdField_a_of_type_JavaUtilMap.put(paramGameUserInfo.mRoleId, paramGameUserInfo);
    a(paramGameUserInfo);
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[isInited]" + jdField_d_of_type_Boolean);
    }
    return jdField_d_of_type_Boolean;
  }
  
  private void d()
  {
    try
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(GameUserInfo.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameUserInfo)localObject2;
            if (!TextUtils.isEmpty(((GameUserInfo)localObject2).mRoleId)) {
              this.jdField_a_of_type_JavaUtilMap.put(((GameUserInfo)localObject2).mRoleId, localObject2);
            }
          }
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "ursInfo.size:" + this.jdField_a_of_type_JavaUtilMap.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
      return;
    }
  }
  
  private void e()
  {
    try
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(GameBasicInfo.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameBasicInfo)localObject2;
            if (!TextUtils.isEmpty(((GameBasicInfo)localObject2).mAppId)) {
              this.b.put(((GameBasicInfo)localObject2).mAppId, localObject2);
            }
          }
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "gameConfig.size:" + this.b.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
      return;
    }
  }
  
  private void f()
  {
    try
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(GameSwitchConfig.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameSwitchConfig)localObject2;
            if (!TextUtils.isEmpty(((GameSwitchConfig)localObject2).mAppId)) {
              this.c.put(((GameSwitchConfig)localObject2).mAppId, localObject2);
            }
          }
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "gameSwitchConfig.size:" + this.c.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
      return;
    }
  }
  
  public int a()
  {
    return a(true);
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.f.size() == 0) {
      a();
    }
    Iterator localIterator = this.f.keySet().iterator();
    String str;
    for (int i = 0; localIterator.hasNext(); i = ((GameCenterSessionInfo)this.f.get(str)).c() + i) {
      str = (String)localIterator.next();
    }
    int j = i;
    if (paramBoolean) {
      j = i + b();
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[getUnreadCnt] cnt:" + j);
    return j;
  }
  
  public avlc a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSingleGameDetail], roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    GameUserInfo localGameUserInfo = a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localGameUserInfo == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "usrInfo is null");
      localArrayList.add(paramString);
      a(true, localArrayList);
      return null;
    }
    GameBasicInfo localGameBasicInfo = a(localGameUserInfo.mAppId);
    if (localGameBasicInfo == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "basicinfp is null");
      localArrayList.add(paramString);
      a(true, localArrayList);
      return null;
    }
    localArrayList.add(paramString);
    a(false, localArrayList);
    return avlc.a(localGameBasicInfo, localGameUserInfo);
  }
  
  public GameCenterSessionInfo a()
  {
    if (this.jdField_d_of_type_JavaUtilMap.size() == 0) {
      a();
    }
    Object localObject2 = new ArrayList(this.e.values());
    Object localObject1 = new ArrayList(this.f.values());
    Collections.sort((List)localObject2);
    Collections.sort((List)localObject1);
    if ((((List)localObject2).size() > 0) && (((List)localObject1).size() > 0))
    {
      localObject2 = (GameCenterSessionInfo)((List)localObject2).get(0);
      localObject1 = (GameCenterSessionInfo)((List)localObject1).get(0);
      if (((GameCenterSessionInfo)localObject2).a() > ((GameCenterSessionInfo)localObject1).a()) {
        return localObject2;
      }
      return localObject1;
    }
    if (((List)localObject2).size() > 0) {
      return (GameCenterSessionInfo)((List)localObject2).get(0);
    }
    if (((List)localObject1).size() > 0) {
      return (GameCenterSessionInfo)((List)localObject1).get(0);
    }
    return null;
  }
  
  public GameCenterSessionInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoByUin] sessionId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_d_of_type_JavaUtilMap.size() == 0) {
      a();
    }
    return (GameCenterSessionInfo)this.jdField_d_of_type_JavaUtilMap.get(paramString);
  }
  
  public GameBasicInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[findGameConfig], appId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameBasicInfo)this.b.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "got it from cache");
    return localObject;
    QLog.i(jdField_a_of_type_JavaLangString, 1, "try to read from db");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(GameBasicInfo.class, paramString);
    if (localObject != null)
    {
      localObject = (GameBasicInfo)localObject;
      this.b.put(paramString, localObject);
      return localObject;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "fail to find gameCfg from db.");
    return null;
  }
  
  public GameSwitchConfig a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[findGameSwitchConfig], appId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameSwitchConfig)this.c.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "got it from cache");
    return localObject;
    QLog.i(jdField_a_of_type_JavaLangString, 1, "try to read from db");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(GameSwitchConfig.class, paramString);
    if (localObject != null)
    {
      localObject = (GameSwitchConfig)localObject;
      this.c.put(paramString, localObject);
      return localObject;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "fail to find gameCfg from db.");
    return null;
  }
  
  public GameUserInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[findGameUserInfo], roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameUserInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "got it from cache");
    return localObject;
    QLog.i(jdField_a_of_type_JavaLangString, 1, "try to read from db");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(GameUserInfo.class, paramString);
    if (localObject != null)
    {
      localObject = (GameUserInfo)localObject;
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      return localObject;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "fail to find usrinfo from db.");
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_Areh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Areh.e))) {
      return this.jdField_a_of_type_Areh.e;
    }
    return avlf.d;
  }
  
  public HashMap<String, avlc> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GameUserInfo localGameUserInfo = a(str);
      if (localGameUserInfo == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "usrInfo is null, roleId:" + str);
        bool = true;
      }
      else
      {
        GameBasicInfo localGameBasicInfo = a(localGameUserInfo.mAppId);
        if (localGameBasicInfo == null)
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "basicinfp is null, appid:" + localGameUserInfo.mAppId);
          bool = true;
        }
        else
        {
          localHashMap.put(str, avlc.a(localGameBasicInfo, localGameUserInfo));
        }
      }
    }
    a(bool, paramArrayList);
    return localHashMap;
  }
  
  public List<GameCenterSessionInfo> a()
  {
    return a(0, "");
  }
  
  public List<GameCenterSessionInfo> a(int paramInt, String paramString)
  {
    Object localObject1;
    Object localObject4;
    Object localObject5;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] type:" + paramInt + ",gameId:" + paramString + "curSize:" + this.jdField_d_of_type_JavaUtilMap.size());
      }
      if (!c()) {}
      for (localObject1 = new ArrayList();; localObject1 = null)
      {
        return localObject1;
        localObject1 = new ArrayList();
        if (this.jdField_d_of_type_JavaUtilMap.size() != 0) {
          break label944;
        }
        localObject3 = b();
        if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] tinyconversion is null.return");
      }
      localObject2 = new HashSet();
      localObject4 = ((List)localObject3).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ConversationInfo)((Iterator)localObject4).next();
        if ((((ConversationInfo)localObject5).tinyInfo != null) && (!TextUtils.isEmpty(((ConversationInfo)localObject5).tinyInfo.fromRoleId)))
        {
          ((Set)localObject2).add(((ConversationInfo)localObject5).tinyInfo.fromRoleId);
          ((Set)localObject2).add(((ConversationInfo)localObject5).tinyInfo.toRoleId);
        }
      }
      if (!QLog.isColorLevel()) {
        break label295;
      }
    }
    finally {}
    QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoList] tinycon size:" + ((List)localObject3).size() + " id size:" + ((Set)localObject2).size());
    label295:
    Object localObject2 = a(new ArrayList((Collection)localObject2));
    Object localObject3 = ((List)localObject3).iterator();
    label319:
    Object localObject6;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ConversationInfo)((Iterator)localObject3).next();
        if (localObject4 == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] info is null, continue.");
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] info:" + ((ConversationInfo)localObject4).toString());
          }
          localObject5 = new GameCenterSessionInfo();
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((ConversationInfo)localObject4).uin, ((ConversationInfo)localObject4).type);
          CharSequence localCharSequence;
          if (localObject6 != null)
          {
            localCharSequence = ((QQMessageFacade.Message)localObject6).emoRecentMsg;
            if (!TextUtils.isEmpty(localCharSequence)) {
              ((GameCenterSessionInfo)localObject5).k(localCharSequence.toString());
            }
            ((GameCenterSessionInfo)localObject5).a(((QQMessageFacade.Message)localObject6).isSend());
            ((GameCenterSessionInfo)localObject5).b(((QQMessageFacade.Message)localObject6).time);
          }
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((ConversationInfo)localObject4).uin, ((ConversationInfo)localObject4).type);
          if (localObject6 != null)
          {
            localCharSequence = ((QQMessageFacade.Message)localObject6).emoRecentMsg;
            if (!TextUtils.isEmpty(localCharSequence)) {
              ((GameCenterSessionInfo)localObject5).j(localCharSequence.toString());
            }
            ((GameCenterSessionInfo)localObject5).a(((QQMessageFacade.Message)localObject6).time);
          }
          ((GameCenterSessionInfo)localObject5).e(((ConversationInfo)localObject4).uin);
          ((GameCenterSessionInfo)localObject5).c(((ConversationInfo)localObject4).unreadCount);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] sessionId" + ((ConversationInfo)localObject4).uin + " tinyInfo:" + ((ConversationInfo)localObject4).tinyInfo);
          }
          if ((((ConversationInfo)localObject4).tinyInfo != null) && (!TextUtils.isEmpty(((ConversationInfo)localObject4).tinyInfo.fromRoleId)))
          {
            if (b(((ConversationInfo)localObject4).tinyInfo.gameAppId + ""))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] msg blocked: " + ((GameCenterSessionInfo)localObject5).d());
              continue;
            }
            ((GameCenterSessionInfo)localObject5).d(((ConversationInfo)localObject4).tinyInfo.fromRoleId);
            ((GameCenterSessionInfo)localObject5).b(((ConversationInfo)localObject4).tinyInfo.toRoleId);
            if (localObject2 != null)
            {
              localObject6 = (avlc)((HashMap)localObject2).get(((ConversationInfo)localObject4).tinyInfo.fromRoleId);
              if (!QLog.isColorLevel()) {
                break label1511;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoList] sessionId:" + ((ConversationInfo)localObject4).uin + ",gameDetailInfo:" + localObject6);
              break label1511;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject6 != null)
      {
        ((GameCenterSessionInfo)localObject5).i(((avlc)localObject6).e);
        ((GameCenterSessionInfo)localObject5).f(((avlc)localObject6).jdField_c_of_type_JavaLangString);
        ((GameCenterSessionInfo)localObject5).d(((avlc)localObject6).b);
        ((GameCenterSessionInfo)localObject5).h(((avlc)localObject6).d);
        ((GameCenterSessionInfo)localObject5).g(((avlc)localObject6).i);
        ((GameCenterSessionInfo)localObject5).c(((avlc)localObject6).k);
        ((GameCenterSessionInfo)localObject5).a(((avlc)localObject6).j);
      }
      this.jdField_d_of_type_JavaUtilMap.put(((GameCenterSessionInfo)localObject5).d(), localObject5);
      break label319;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoList] sessionMap:" + this.jdField_d_of_type_JavaUtilMap.toString());
      }
      label944:
      this.f.clear();
      this.e.clear();
      localObject2 = this.jdField_d_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject3 = (GameCenterSessionInfo)this.jdField_d_of_type_JavaUtilMap.get(localObject3);
        ((GameCenterSessionInfo)localObject3).b(0);
        if (a(((GameCenterSessionInfo)localObject3).e()))
        {
          ((GameCenterSessionInfo)localObject3).a(1);
          this.f.put(((GameCenterSessionInfo)localObject3).d(), localObject3);
        }
        else
        {
          ((GameCenterSessionInfo)localObject3).a(0);
          if (((GameCenterSessionInfo)localObject3).c() > 0)
          {
            if (!this.e.containsKey(((GameCenterSessionInfo)localObject3).e()))
            {
              ((GameCenterSessionInfo)localObject3).a();
              this.e.put(((GameCenterSessionInfo)localObject3).e(), localObject3);
            }
            else
            {
              localObject4 = (GameCenterSessionInfo)this.e.get(((GameCenterSessionInfo)localObject3).e());
              if (((GameCenterSessionInfo)localObject3).a() > ((GameCenterSessionInfo)localObject4).a())
              {
                ((GameCenterSessionInfo)localObject3).b(((GameCenterSessionInfo)localObject4).b() + 1);
                this.e.put(((GameCenterSessionInfo)localObject3).e(), localObject3);
              }
            }
          }
          else {
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] folder session:" + localObject3);
          }
        }
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] size:" + this.jdField_d_of_type_JavaUtilMap.size() + ",fsize:" + this.e.size() + "，nsize:" + this.f.size());
      if (paramInt == 0)
      {
        ((List)localObject1).addAll(this.f.values());
        ((List)localObject1).addAll(this.e.values());
        paramString = (String)localObject1;
      }
      for (;;)
      {
        Collections.sort(paramString);
        localObject1 = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoList] ret:" + paramString.toString());
        localObject1 = paramString;
        break;
        if (paramInt == 1)
        {
          paramString = new ArrayList(this.e.values());
        }
        else if (paramInt == 2)
        {
          paramString = new ArrayList(this.f.values());
        }
        else
        {
          if (paramInt == 3)
          {
            localObject2 = this.jdField_d_of_type_JavaUtilMap.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              if (TextUtils.equals(paramString, ((GameCenterSessionInfo)this.jdField_d_of_type_JavaUtilMap.get(localObject3)).e())) {
                ((List)localObject1).add(this.jdField_d_of_type_JavaUtilMap.get(localObject3));
              }
            }
          }
          paramString = (String)localObject1;
        }
      }
      label1511:
      if (localObject6 != null) {}
    }
  }
  
  public void a()
  {
    a("action_qgame_messgae_change", null, 3, a());
  }
  
  public void a(int paramInt)
  {
    if (((RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().findRecentUser("2747277822", 1008) == null) && (paramInt != 0)) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        String str = "sp_enter_pub" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localSharedPreferences.edit().putInt(str, this.jdField_a_of_type_Int).apply();
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "[setUnshowedUnreadCnt] cnt:" + this.jdField_a_of_type_Int);
  }
  
  public void a(areh paramareh)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 2, "[updateGraySwich]");
    if (paramareh == null) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "graySwitch:" + paramareh.jdField_a_of_type_Int + ",msgListUrl:" + paramareh.b + ",prefix:" + paramareh.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Areh == null) {
      this.jdField_a_of_type_Areh = new areh();
    }
    if (!TextUtils.isEmpty(paramareh.b)) {
      this.jdField_a_of_type_Areh.b = paramareh.b;
    }
    this.jdField_a_of_type_Areh.jdField_a_of_type_Int = paramareh.jdField_a_of_type_Int;
    if (!TextUtils.isEmpty(paramareh.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_Areh.jdField_c_of_type_JavaLangString = paramareh.jdField_c_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Areh.jdField_c_of_type_Int = paramareh.jdField_c_of_type_Int;
    this.jdField_a_of_type_Areh.e = paramareh.e;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[setAllReaded] gameId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)this.jdField_d_of_type_JavaUtilMap.get(str);
        if (paramString.equals(localGameCenterSessionInfo.e()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localGameCenterSessionInfo.d(), 10007);
          localGameCenterSessionInfo.c(0);
          if (this.f.get(str) != null) {
            ((GameCenterSessionInfo)this.f.get(str)).c(0);
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[onGameSwitchChange] gameId:" + paramString + ",switchType:" + paramInt1 + ",value:" + paramInt2);
    ArrayList localArrayList = new ArrayList();
    GameSwitchConfig localGameSwitchConfig2 = a(paramString);
    GameSwitchConfig localGameSwitchConfig1 = localGameSwitchConfig2;
    if (localGameSwitchConfig2 == null)
    {
      localGameSwitchConfig1 = new GameSwitchConfig();
      localGameSwitchConfig1.mAppId = paramString;
    }
    if (paramInt1 == 0) {
      if ((paramInt2 != 0) && (paramInt2 != 1))
      {
        localGameSwitchConfig1.mBlockSwitch = 0;
        localArrayList.add(localGameSwitchConfig1);
        c(localArrayList);
        if (localGameSwitchConfig1.mBlockSwitch == 1) {
          b(paramString);
        }
      }
    }
    while (paramInt1 != 1) {
      for (;;)
      {
        return;
        localGameSwitchConfig1.mBlockSwitch = paramInt2;
      }
    }
    if ((paramInt2 != 0) && (paramInt2 != 1)) {}
    for (localGameSwitchConfig1.mSyncSwitch = 1;; localGameSwitchConfig1.mSyncSwitch = paramInt2)
    {
      localArrayList.add(localGameSwitchConfig1);
      c(localArrayList);
      if (localGameSwitchConfig1.mSyncSwitch != 0) {
        break;
      }
      a(paramString);
      return;
    }
  }
  
  public void a(String paramString, GameCenterSessionInfo paramGameCenterSessionInfo, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(BaseApplicationImpl.getApplication().getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_game_msg", paramGameCenterSessionInfo);
    localBundle.putInt("key_msg_change_type", paramInt1);
    localBundle.putInt("key_msg_unread_cnt", paramInt2);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[notifyMessageChange] action:" + paramString + ",type:" + paramInt1 + ",cnt:" + paramInt2);
  }
  
  public void a(ArrayList<GameUserInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[saveOrUpdateGameUsrInfoArrays], size:" + paramArrayList.size());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameUserInfo localGameUserInfo1 = (GameUserInfo)paramArrayList.next();
        if (localGameUserInfo1 != null)
        {
          GameUserInfo localGameUserInfo2 = (GameUserInfo)this.jdField_a_of_type_JavaUtilMap.get(localGameUserInfo1.mRoleId);
          if (localGameUserInfo2 == null)
          {
            localGameUserInfo1.setStatus(1000);
            a(localGameUserInfo1);
          }
          else if (localGameUserInfo1.mUpdateTs != localGameUserInfo2.mUpdateTs)
          {
            a(localGameUserInfo1);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "game user info has changed,origTS:" + localGameUserInfo2.mUpdateTs + ",newTS:" + localGameUserInfo1.mUpdateTs);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[pullGameUsrInfoFromServer], isForcePull:" + paramBoolean);
    }
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "not in gray whitelist, return.");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new GameMsgManager.4(this, paramBoolean, paramArrayList));
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
    QLog.e(jdField_a_of_type_JavaLangString, 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    GameSwitchConfig localGameSwitchConfig = a(paramString);
    if (localGameSwitchConfig == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[isGameMsgSync] gameId:" + paramString + ", config is null,return true");
      return true;
    }
    if (localGameSwitchConfig.mSyncSwitch == 0) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[isGameMsgSync] gameId:" + paramString + ", ret:" + bool);
      }
      return bool;
    }
  }
  
  public int b()
  {
    if ((!avlf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.e.size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public GameCenterSessionInfo b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoByRoleId] roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_d_of_type_JavaUtilMap.size() == 0) {
      a();
    }
    Iterator localIterator = this.jdField_d_of_type_JavaUtilMap.keySet().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      localObject = (GameCenterSessionInfo)this.jdField_d_of_type_JavaUtilMap.get(localObject);
    } while (!paramString.equals(((GameCenterSessionInfo)localObject).c()));
    for (paramString = (String)localObject;; paramString = null) {
      return paramString;
    }
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_Areh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Areh.b))) {
      return this.jdField_a_of_type_Areh.b;
    }
    return avlf.b;
  }
  
  public List<ConversationInfo> b()
  {
    return avlh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void b()
  {
    if (!c()) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[tryGetGameSwitchFromSvr], not in gray whitelist, return.");
      }
    }
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 300000L) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[tryGetGameSwitchFromSvr]");
    ((avln)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(175)).a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[deleteAllSession] gameId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_d_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)((Map.Entry)localIterator.next()).getValue();
        if (paramString.equals(localGameCenterSessionInfo.e()))
        {
          localIterator.remove();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localGameCenterSessionInfo.d(), 10007);
          }
        }
      }
      localIterator = this.f.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((GameCenterSessionInfo)((Map.Entry)localIterator.next()).getValue()).e())) {
          localIterator.remove();
        }
      }
      localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals((String)((Map.Entry)localIterator.next()).getKey())) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void b(ArrayList<GameBasicInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[saveOrUpdateGameBasicConfigs], size:" + paramArrayList.size());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameBasicInfo localGameBasicInfo1 = (GameBasicInfo)paramArrayList.next();
        if (localGameBasicInfo1 != null)
        {
          GameBasicInfo localGameBasicInfo2 = (GameBasicInfo)this.b.get(localGameBasicInfo1.mAppId);
          if (localGameBasicInfo2 == null)
          {
            localGameBasicInfo1.setStatus(1000);
            a(localGameBasicInfo1);
          }
          else if (localGameBasicInfo2.mUpdateTs != localGameBasicInfo1.mUpdateTs)
          {
            a(localGameBasicInfo1);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "game basic config has changed,origTS:" + localGameBasicInfo2.mUpdateTs + ",newTS:" + localGameBasicInfo1.mUpdateTs);
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Areh != null) && (this.jdField_a_of_type_Areh.jdField_c_of_type_Int == 1);
  }
  
  public boolean b(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    GameSwitchConfig localGameSwitchConfig = a(paramString);
    if (localGameSwitchConfig == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[isGameMsgBlocked] gameId:" + paramString + ", config is null,return false");
      return bool2;
    }
    if (localGameSwitchConfig.mBlockSwitch == 0) {}
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[isGameMsgBlocked] gameId:" + paramString + ", ret:" + bool1);
      return bool1;
      bool1 = true;
    }
  }
  
  public int c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getUnshowedUnreadCnt] cnt:" + this.jdField_a_of_type_Int);
    }
    if (!avlf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    while ((!c()) || (tug.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "2747277822"))) {
      return 0;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public GameCenterSessionInfo c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.e.size() == 0) {
      a();
    }
    return (GameCenterSessionInfo)this.e.get(paramString);
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_Areh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Areh.jdField_c_of_type_JavaLangString))) {
      return this.jdField_a_of_type_Areh.jdField_c_of_type_JavaLangString;
    }
    return avlf.jdField_c_of_type_JavaLangString;
  }
  
  public void c()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1009));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[updateRecentList] send update list msg.");
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "[cleanSessionUnread] id:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      paramString = a(paramString);
    } while (paramString == null);
    paramString.c(0);
    a(a());
  }
  
  public void c(ArrayList<GameSwitchConfig> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameSwitchConfig localGameSwitchConfig = (GameSwitchConfig)paramArrayList.next();
        if (localGameSwitchConfig != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[saveOrUpdateGameSwitchConfigs] config:" + localGameSwitchConfig.toString());
          }
          this.c.put(localGameSwitchConfig.mAppId, localGameSwitchConfig);
          a(localGameSwitchConfig);
        }
      }
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Areh != null) && (this.jdField_a_of_type_Areh.jdField_a_of_type_Int == 1);
  }
  
  public int d()
  {
    return 1;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Areh != null) {
      return this.jdField_a_of_type_Areh.d;
    }
    return "";
  }
  
  public void onDestroy()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[onDestroy]");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avlo);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!c()) {}
    label7:
    MessageRecord localMessageRecord;
    ConversationInfo localConversationInfo;
    do
    {
      do
      {
        break label7;
        break label7;
        do
        {
          return;
        } while (!(paramObject instanceof MessageRecord));
        localMessageRecord = (MessageRecord)paramObject;
      } while (localMessageRecord.istroop != 10007);
      b();
      localConversationInfo = avlh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.frienduin, localMessageRecord.istroop);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "[update] ##-- new msg:" + localMessageRecord.frienduin + ", conInfo:" + localConversationInfo);
      }
    } while (localConversationInfo == null);
    paramObservable = a(localMessageRecord.frienduin);
    label298:
    label312:
    label483:
    label498:
    int i;
    label502:
    int j;
    int k;
    if (paramObservable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] create new sessionInfo.");
      }
      paramObject = new GameCenterSessionInfo();
      paramObject.e(localMessageRecord.frienduin);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (localObject != null) {
        if (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject).emoRecentMsg)) {
          break label298;
        }
      }
      for (paramObservable = "";; paramObservable = ((QQMessageFacade.Message)localObject).emoRecentMsg.toString())
      {
        paramObject.j(paramObservable);
        paramObject.a(((QQMessageFacade.Message)localObject).time);
        paramObservable = localConversationInfo.tinyInfo;
        if (paramObservable == null) {
          break label498;
        }
        if (!b(paramObservable.gameAppId + "")) {
          break label312;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, "[update] ##-- new msg:" + localMessageRecord.frienduin + ", blocked.");
        return;
      }
      paramObject.d(paramObservable.fromRoleId);
      paramObject.b(paramObservable.toRoleId);
      paramObject.f(paramObservable.gameAppId + "");
      localObject = a(paramObject.c());
      if (localObject != null)
      {
        paramObject.f(((avlc)localObject).jdField_c_of_type_JavaLangString);
        paramObject.g(((avlc)localObject).i);
        paramObject.i(((avlc)localObject).e);
        paramObject.d(((avlc)localObject).b);
        paramObject.c(((avlc)localObject).k);
        paramObject.h(((avlc)localObject).d);
        paramObject.a(((avlc)localObject).j);
      }
      if (a(paramObservable.gameAppId + ""))
      {
        paramObject.a(1);
        this.f.put(paramObject.d(), paramObject);
        this.jdField_d_of_type_JavaUtilMap.put(paramObject.d(), paramObject);
        i = 0;
        paramObservable = paramObject;
        paramObservable.c(localConversationInfo.unreadCount);
        paramObservable.k(localMessageRecord.msg);
        paramObservable.b(localMessageRecord.time);
        paramObservable.a(localMessageRecord.isSend());
        j = a();
        k = paramObservable.c();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] update info:" + paramObservable.toString());
        }
        if (paramObservable.a() != 0) {
          break label855;
        }
        paramObservable = c(paramObservable.e());
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] notify folder session:" + paramObservable);
        }
        a("action_qgame_messgae_change", paramObservable, 1, j);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] oldUnread:" + i + ",newUnread:" + k);
      }
      if ((!avlf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (i == k)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
      a(j);
      return;
      paramObject.a(0);
      paramObject.a();
      this.e.put(paramObject.e(), paramObject);
      break label483;
      i = paramObservable.c();
      if (paramObservable.a() == 0)
      {
        paramObject = c(paramObservable.e());
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] folder session:" + paramObject);
        }
        if (paramObject != null)
        {
          paramObservable.b(paramObject.b() + 1);
          this.e.put(paramObservable.e(), paramObservable);
          break label502;
        }
        paramObservable.a();
        this.e.put(paramObservable.e(), paramObservable);
      }
      break label502;
      label855:
      a("action_qgame_messgae_change", paramObservable, 1, j);
      a("action_qgame_unread_change", paramObservable, 1, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avld
 * JD-Core Version:    0.7.0.1
 */