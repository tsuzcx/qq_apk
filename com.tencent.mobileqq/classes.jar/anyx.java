import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache;
import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.1;
import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.2;
import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.3;
import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.4;
import com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.5;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class anyx
  extends BaseRecentUserCache<RecentUser, QQAppInterface>
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(64);
  
  public anyx(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, RecentUser.class);
  }
  
  private void b(RecentUser paramRecentUser, boolean paramBoolean)
  {
    String str = albs.a(paramRecentUser.uin, paramRecentUser.getType());
    long l = Math.max(Math.max(paramRecentUser.opTime, paramRecentUser.showUpTime), Math.max(paramRecentUser.lastmsgtime, paramRecentUser.lastmsgdrafttime));
    if ((!paramBoolean) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) && (((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).longValue() >= l))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, new Object[] { "saveParcelDataToRecentData repeat， key=", str, " opTime=", Long.valueOf(paramRecentUser.opTime), " showUpTime=", Long.valueOf(paramRecentUser.showUpTime), " lastmsgtime=", Long.valueOf(paramRecentUser.lastmsgtime), " lastmsgdrafttime=", Long.valueOf(paramRecentUser.lastmsgdrafttime) });
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getRecentThreadLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RecentUserCache.5(this, str, paramRecentUser, l));
  }
  
  private void c()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.app).getApplication().getSharedPreferences("new_friend_upgrade_pref" + ((QQAppInterface)this.app).getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_newfriend_when_upgrade", true)) {
      if (this.cacheMap == null) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | descRecentList == null");
        }
      }
    }
    do
    {
      do
      {
        return;
        ThreadManager.getSubThreadHandler().post(new RecentUserCache.2(this, localSharedPreferences));
      } while (!localSharedPreferences.getBoolean("check_newfriend_when_upgrade_V2", true));
      if (this.cacheMap != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | descRecentList == null");
    return;
    ThreadManager.getSubThreadHandler().post(new RecentUserCache.3(this, localSharedPreferences));
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.app).getApplication().getSharedPreferences("pubaccount_assistant_upgrade_pref" + ((QQAppInterface)this.app).getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_pubaccountassistant_when_upgrade", true))
    {
      if (this.cacheMap != null) {
        break label77;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | descRecentList == null");
      }
    }
    return;
    label77:
    ((QQAppInterface)this.app).a(new RecentUserCache.4(this, localSharedPreferences));
  }
  
  private void e()
  {
    if (this.cacheMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkKandianUpgrade | descRecentList == null");
      }
      return;
    }
    synchronized (this.cacheMap)
    {
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        if ((!bmqa.a((QQAppInterface)this.app)) && (localRecentUser.getType() == 7220))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove kandian merge");
          }
        }
        if ((bmqa.a((QQAppInterface)this.app)) && (((localRecentUser.getType() == 1008) && (TextUtils.equals(localRecentUser.uin, anhk.az))) || (localRecentUser.getType() == 7210)))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove troop_bar_assist or kandian uin:" + localRecentUser.uin);
          }
        }
      }
    }
  }
  
  public bbyt a(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    Object localObject;
    try
    {
      localArrayList = new ArrayList(this.cacheMap.size());
      localObject = this.cacheMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)((Iterator)localObject).next()).getValue();
        localRecentUser.parse();
        localArrayList.add(localRecentUser);
      }
      Collections.sort(localArrayList, this.comparator);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getRecentConvInfo is error!", paramString);
      }
      return null;
    }
    paramString = (RecentUser)this.cacheMap.get(getKey(paramString, paramInt));
    int i;
    if (paramString != null)
    {
      i = localArrayList.indexOf(paramString) + 1;
      long l = System.currentTimeMillis() / 1000L;
      paramString = localArrayList.iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (RecentUser)paramString.next();
      } while (l - ((RecentUser)localObject).lastmsgtime <= bbyp.b);
    }
    for (paramInt = localArrayList.indexOf(localObject) + 1;; paramInt = -1)
    {
      if (paramInt == -1) {
        paramInt = localArrayList.size();
      }
      for (;;)
      {
        paramString = new bbyt();
        paramString.a = i;
        paramString.b = paramInt;
        paramString.c = localArrayList.size();
        return paramString;
        i = -1;
        break;
      }
    }
  }
  
  protected RecentUser a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if ((paramRecentUser.getType() == 10007) && (autf.a((QQAppInterface)this.app)) && (autd.a()))
    {
      localObject1 = (autd)((QQAppInterface)this.app).getManager(358);
      if (((autd)localObject1).c())
      {
        localObject1 = ((autd)localObject1).a();
        localObject2 = getKey("2747277822", 10007);
        if ((!this.cacheMap.containsKey(localObject2)) && (localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 1, "addCache ##--10007");
          }
          addCache(findRecentUserByUin("2747277822", 1008));
        }
      }
    }
    if (aofn.a((QQAppInterface)this.app, paramRecentUser.uin, paramRecentUser.getType()))
    {
      QLog.d("Q.db.Cache.RecentUserCache", 1, "find save invalid user:" + paramRecentUser.uin + " type:" + paramRecentUser.getType(), new RuntimeException("invalid user"));
      aofn.a(paramRecentUser.uin);
    }
    if ((paramRecentUser.getType() == 1) || (paramRecentUser.getType() == 0))
    {
      paramBoolean = aglw.a(paramRecentUser.uin, paramRecentUser.getType(), (QQAppInterface)this.app);
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramRecentUser.uin + " type " + paramRecentUser.getType() + " isHidden " + paramBoolean + " user.isHiddenChat=" + paramRecentUser.isHiddenChat);
      }
      if (!paramBoolean) {
        break label514;
      }
    }
    label514:
    for (int i = 1;; i = 0)
    {
      paramRecentUser.isHiddenChat = i;
      if (paramRecentUser.getType() == 1)
      {
        localObject1 = ((TroopManager)((QQAppInterface)this.app).getManager(52)).a(paramRecentUser.uin);
        if (localObject1 != null) {
          paramRecentUser.showUpTime = ((CommonlyUsedTroop)localObject1).addedTimestamp;
        }
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 1) {
        break label777;
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 3000) {
        break label777;
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 7000) {
        break label777;
      }
      if (bjft.b((QQAppInterface)this.app, paramRecentUser.uin)) {
        paramRecentUser.setType(1024);
      }
      localObject2 = new ArrayList();
      localObject1 = acwh.q;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        int k = localObject1[i];
        if (k != paramRecentUser.getType())
        {
          String str = getKey(paramRecentUser.uin, k);
          if (this.cacheMap.containsKey(str)) {
            ((ArrayList)localObject2).add(str);
          }
        }
        i += 1;
      }
    }
    int j = ((ArrayList)localObject2).size();
    if (j > 0)
    {
      i = 0;
      localObject1 = paramRecentUser;
      if (i < j)
      {
        if (i == 0)
        {
          localObject1 = (RecentUser)this.cacheMap.remove(((ArrayList)localObject2).get(i));
          if (localObject1 != null) {}
        }
        for (;;)
        {
          i += 1;
          break;
          ((RecentUser)localObject1).setType(paramRecentUser.getType());
          ((RecentUser)localObject1).displayName = paramRecentUser.displayName;
          ((RecentUser)localObject1).lastmsgtime = paramRecentUser.lastmsgtime;
          ((RecentUser)localObject1).showUpTime = Math.max(((RecentUser)localObject1).showUpTime, paramRecentUser.showUpTime);
          ((RecentUser)localObject1).troopUin = paramRecentUser.troopUin;
          ((RecentUser)localObject1).lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
          ((RecentUser)localObject1).msgData = paramRecentUser.msgData;
          ((RecentUser)localObject1).msgType = paramRecentUser.msgType;
          ((RecentUser)localObject1).lFlag = paramRecentUser.lFlag;
          ((RecentUser)localObject1).isHiddenChat = paramRecentUser.isHiddenChat;
          ((RecentUser)localObject1).opTime = Math.max(((RecentUser)localObject1).opTime, paramRecentUser.opTime);
          this.cacheMap.remove(((ArrayList)localObject2).get(i));
          paramRecentUser = (RecentUser)localObject1;
          continue;
          this.cacheMap.remove(((ArrayList)localObject2).get(i));
          this.proxyManager.addQueue((Entity)this.cacheMap.get(((ArrayList)localObject2).get(i)), 2, 0, null);
        }
      }
    }
    else
    {
      localObject1 = paramRecentUser;
    }
    azwe.a((QQAppInterface)this.app, ((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
    label777:
    if ((((RecentUser)localObject1).getType() == 7220) && (!this.cacheMap.contains(localObject1)))
    {
      paramRecentUser = (KandianMergeManager)((QQAppInterface)this.app).getManager(162);
      if (paramRecentUser.a != -1) {
        if (paramRecentUser.a != 1) {
          break label852;
        }
      }
    }
    label852:
    for (long l = System.currentTimeMillis() / 1000L;; l = 0L)
    {
      ((RecentUser)localObject1).showUpTime = l;
      return localObject1;
    }
  }
  
  protected RecentUser a(String paramString, int paramInt)
  {
    return new RecentUser(paramString, paramInt);
  }
  
  public List<RecentUser> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.cacheMap.size());
      Iterator localIterator = this.cacheMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        localRecentUser.parse();
        if (localRecentUser.isHiddenChat == 1) {
          localArrayList.add(localRecentUser);
        }
      }
      if (!QLog.isColorLevel()) {
        return localException;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getHiddenCacheList is error!", localException);
      }
      return new ArrayList();
    }
    if (localException == null) {}
    for (int i = 0;; i = localException.size())
    {
      QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getHiddenRecentList, size = %s", new Object[] { Integer.valueOf(i) }));
      break;
    }
    return localException;
  }
  
  public void a()
  {
    EntityManager localEntityManager = ((QQAppInterface)this.app).a().createEntityManager();
    ??? = Integer.toString(50);
    Object localObject3 = localEntityManager.query(RecentUser.class, false, "type=?", new String[] { String.valueOf(10007) }, null, null, "lastmsgtime desc", (String)???);
    int i = this.cacheMap.size();
    if (localObject3 != null) {
      synchronized (this.cacheMap)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          String str = getKey(localRecentUser);
          if (!this.cacheMap.containsKey(str)) {
            this.cacheMap.put(str, localRecentUser);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "preLoadTinyRecentUser is called. preCount = " + i + ", afterCount = " + this.cacheMap.size());
    }
    localObject1.close();
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    super.saveRecentUser(paramRecentUser, paramBoolean);
    if ((paramRecentUser.isHiddenChat == 0) && (alcu.a((QQAppInterface)this.app))) {}
    try
    {
      b(paramRecentUser, paramBoolean);
      return;
    }
    catch (Throwable paramRecentUser) {}
  }
  
  public void a(String paramString)
  {
    Object localObject = (ConcurrentHashMap)this.uinMap.get(paramString);
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty()))
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "findRecentUserByUin, uin:" + paramString + ",type:" + str);
          }
          int i = Integer.valueOf(str).intValue();
          if (i != 7000) {
            delRecentUser((RecentUser)findRecentUserByUin(paramString, i));
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int[] arrayOfInt = acwh.q;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = getKey(paramString, k);
      if (this.cacheMap.containsKey(localObject))
      {
        localObject = (RecentUser)this.cacheMap.get(localObject);
        if (paramBoolean) {
          ((QQAppInterface)this.app).a().a(((RecentUser)localObject).uin, ((RecentUser)localObject).getType(), 0);
        }
        ((RecentUser)localObject).setType(k);
        removeCache((Entity)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + getShortUinStr(((RecentUser)localObject).uin) + " type " + ((RecentUser)localObject).getType() + " msgType " + ((RecentUser)localObject).msgType);
        }
      }
      i += 1;
    }
  }
  
  protected boolean a(RecentUser paramRecentUser)
  {
    boolean bool = false;
    if (paramRecentUser.getType() == 1036) {
      bool = true;
    }
    return bool;
  }
  
  @VisibleForTesting
  protected boolean a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((TextUtils.equals(paramRecentUser.uin, anhk.az)) || (TextUtils.equals(paramRecentUser.uin, anhk.ac)))
    {
      if (bmqa.a((QQAppInterface)this.app)) {
        return false;
      }
    }
    else
    {
      if (TextUtils.equals(paramRecentUser.uin, anhk.aA)) {
        return false;
      }
      if (TextUtils.equals(paramRecentUser.uin, anhk.aQ)) {
        return false;
      }
      if (TextUtils.equals(paramRecentUser.uin, anhk.D)) {
        return !paramBoolean;
      }
      if (TextUtils.equals(paramRecentUser.uin, anhk.aO))
      {
        if (!bdjg.a((QQAppInterface)this.app)) {
          return false;
        }
      }
      else if ((TextUtils.equals(paramRecentUser.uin, anhk.aQ)) || (TextUtils.equals(paramRecentUser.uin, anhk.aR)))
      {
        if (!bmqa.b(paramRecentUser.uin)) {
          return false;
        }
      }
      else
      {
        if (TextUtils.equals(anhk.H, paramRecentUser.uin)) {
          return false;
        }
        if (TextUtils.equals(anhk.aS, paramRecentUser.uin))
        {
          if (!LoginWelcomeManager.a((QQAppInterface)this.app, paramRecentUser)) {
            return false;
          }
        }
        else
        {
          if (paramRecentUser.getType() == 1038) {
            return akxz.a(false);
          }
          if (paramRecentUser.isHiddenChat == 1) {
            return false;
          }
          if (TextUtils.equals(anhk.aT, paramRecentUser.uin)) {
            return false;
          }
          if (paramRecentUser.getType() == 10007) {
            return !paramBoolean;
          }
          if (paramRecentUser.getType() == 10008) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = (ConcurrentHashMap)this.uinMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty()) && ((!paramString.containsKey(String.valueOf(7000))) || (paramString.keySet().size() > 1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void doOnConstructor()
  {
    EntityManager localEntityManager = ((QQAppInterface)this.app).a().createEntityManager();
    Object localObject1;
    Object localObject2;
    if (tzo.b((QQAppInterface)this.app))
    {
      localObject1 = anhk.ay;
      localObject2 = Integer.toString(150);
      localObject1 = localEntityManager.query(RecentUser.class, false, "uin!=?", new String[] { localObject1 }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject2);
    }
    Object localObject3;
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject2 = RecentUser.class.getSimpleName();
        localObject1 = localEntityManager.query(RecentUser.class, (String)localObject2, false, null, null, null, null, "showUpTime desc, lastmsgtime desc", Integer.toString(150));
        if (localObject1 != null)
        {
          localObject3 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
              localRecentUser.setStatus(1000);
              localRecentUser.setId(-1L);
              addCache(localRecentUser, 2, null);
              continue;
              localObject1 = Integer.toString(150);
              localObject1 = localEntityManager.query(RecentUser.class, false, "type!=?", new String[] { String.valueOf(10007) }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject1);
              break;
            }
          }
          localEntityManager.drop((String)localObject2);
        }
      }
    }
    label535:
    label553:
    label560:
    for (;;)
    {
      localEntityManager.close();
      filterErrorData((List)localObject1);
      Collections.sort((List)localObject1, this.comparator);
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label535;
          }
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          checkRecentUserNull((BaseRecentUser)localObject2);
          this.cacheMap.put(getKey((Entity)localObject2), localObject2);
          continue;
          localObject1 = new ArrayList(20);
          break;
          if (((List)localObject1).size() <= 149) {
            break label560;
          }
          long l = System.currentTimeMillis();
          try
          {
            localObject2 = new RecentUser().getTableName();
            localObject3 = (RecentUser)((List)localObject1).get(140);
            bool = localEntityManager.execSQL("delete from " + (String)localObject2 + " where showUpTime < " + ((RecentUser)localObject3).showUpTime + " or showUpTime = " + ((RecentUser)localObject3).showUpTime + " and max(lastmsgtime, lastmsgdrafttime) < " + Math.max(((RecentUser)localObject3).lastmsgtime, ((RecentUser)localObject3).lastmsgdrafttime) + "; ");
            if (!bool) {
              break label553;
            }
            localObject2 = new ArrayList(((List)localObject1).subList(0, 140));
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              boolean bool;
              continue;
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          try
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.db.Cache.RecentUserCache", 2, "doInit int recentUserProxy delete recent table >199 isOk = " + bool + "; time = " + (System.currentTimeMillis() - l));
            localObject1 = localObject2;
          }
          catch (Exception localException1)
          {
            localObject1 = localObject2;
          }
        }
        localException1.printStackTrace();
        break;
      }
      c();
      d();
      e();
      return;
    }
  }
  
  public void filterErrorData(List<RecentUser> paramList)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser != null) {
        if ((localObject1 == null) && (anhk.G.equals(localRecentUser.uin)))
        {
          localObject1 = localRecentUser;
        }
        else if ((localObject2 == null) && ((anhk.D.equals(localRecentUser.uin)) || (4000 == localRecentUser.getType())))
        {
          if ((localRecentUser.msg == null) && (localRecentUser.msgData != null)) {
            localRecentUser.doParse();
          }
          if ((localRecentUser.msg != null) && (!(localRecentUser.msg instanceof String))) {
            localObject2 = localRecentUser;
          }
        }
        else if ((localObject3 == null) && (anhk.T.equals(localRecentUser.uin)))
        {
          localObject3 = localRecentUser;
        }
      }
    }
    if (localObject1 != null) {
      paramList.remove(localObject1);
    }
    if (localObject3 != null) {
      paramList.remove(localObject3);
    }
    if (localObject2 != null)
    {
      paramList.remove(localObject2);
      long l = localObject2.getId();
      ((QQAppInterface)this.app).a(new RecentUserCache.1(this, l));
    }
  }
  
  public Class getRecentUserGenerifyClassType()
  {
    return RecentUser.class;
  }
  
  public void setUnreadMark(String paramString, int paramInt1, int paramInt2)
  {
    ((QQAppInterface)this.app).a().a(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyx
 * JD-Core Version:    0.7.0.1
 */