package com.tencent.mobileqq.app.asyncdb.cache;

import abol;
import abot;
import afai;
import ajbg;
import ajeu;
import ajfw;
import aljq;
import amcg;
import amch;
import amck;
import amgl;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import asil;
import asin;
import awbv;
import awbw;
import awbx;
import awwg;
import ayvc;
import ayvg;
import badt;
import bfua;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import syb;

public class RecentUserCache
  extends amch
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  Comparator<awbv> jdField_a_of_type_JavaUtilComparator = new amck(true);
  Comparator<awbv> b;
  protected ConcurrentHashMap<String, ConcurrentHashMap<String, awbv>> b;
  private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap(64);
  
  public RecentUserCache(QQAppInterface paramQQAppInterface, amcg paramamcg)
  {
    super(paramQQAppInterface, paramamcg, RecentUser.class);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(64);
    this.jdField_b_of_type_JavaUtilComparator = new amck(false);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new RecentUserCache.CacheMap(this, null);
    d();
  }
  
  private RecentUser a(RecentUser paramRecentUser)
  {
    if (paramRecentUser.uin == null) {
      paramRecentUser.uin = "";
    }
    if (paramRecentUser.troopUin == null) {
      paramRecentUser.troopUin = "";
    }
    if (paramRecentUser.displayName == null) {
      paramRecentUser.displayName = "";
    }
    return paramRecentUser;
  }
  
  private final String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 4);
    return paramString.substring(0, 4);
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  private void a(List<RecentUser> paramList)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser != null) {
        if ((localObject1 == null) && (aljq.G.equals(localRecentUser.uin)))
        {
          localObject1 = localRecentUser;
        }
        else if ((localObject2 == null) && ((aljq.D.equals(localRecentUser.uin)) || (4000 == localRecentUser.getType())))
        {
          if ((localRecentUser.msg == null) && (localRecentUser.msgData != null)) {
            localRecentUser.doParse();
          }
          if ((localRecentUser.msg != null) && (!(localRecentUser.msg instanceof String))) {
            localObject2 = localRecentUser;
          }
        }
        else if ((localObject3 == null) && (aljq.T.equals(localRecentUser.uin)))
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new RecentUserCache.1(this, l));
    }
  }
  
  private void c(RecentUser paramRecentUser, boolean paramBoolean)
  {
    String str = ajeu.a(paramRecentUser.uin, paramRecentUser.getType());
    long l = Math.max(Math.max(paramRecentUser.opTime, paramRecentUser.showUpTime), Math.max(paramRecentUser.lastmsgtime, paramRecentUser.lastmsgdrafttime));
    if ((!paramBoolean) && (this.c.containsKey(str)) && (((Long)this.c.get(str)).longValue() >= l))
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
  
  private void g()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("new_friend_upgrade_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_newfriend_when_upgrade", true)) {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
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
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | descRecentList == null");
    return;
    ThreadManager.getSubThreadHandler().post(new RecentUserCache.3(this, localSharedPreferences));
  }
  
  private void h()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("pubaccount_assistant_upgrade_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_pubaccountassistant_when_upgrade", true))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label74;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | descRecentList == null");
      }
    }
    return;
    label74:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new RecentUserCache.4(this, localSharedPreferences));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkKandianUpgrade | descRecentList == null");
      }
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        if ((!bjxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (localRecentUser.getType() == 7220))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove kandian merge");
          }
        }
        if ((bjxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (((localRecentUser.getType() == 1008) && (TextUtils.equals(localRecentUser.uin, aljq.az))) || (localRecentUser.getType() == 7210)))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove troop_bar_assist or kandian uin:" + localRecentUser.uin);
          }
        }
      }
    }
  }
  
  public ayvg a(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    Object localObject;
    try
    {
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)((Iterator)localObject).next()).getValue();
        localRecentUser.parse();
        localArrayList.add(localRecentUser);
      }
      Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getRecentConvInfo is error!", paramString);
      }
      return null;
    }
    paramString = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramInt));
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
      } while (l - ((RecentUser)localObject).lastmsgtime <= ayvc.b);
    }
    for (paramInt = localArrayList.indexOf(localObject) + 1;; paramInt = -1)
    {
      if (paramInt == -1) {
        paramInt = localArrayList.size();
      }
      for (;;)
      {
        paramString = new ayvg();
        paramString.a = i;
        paramString.b = paramInt;
        paramString.c = localArrayList.size();
        return paramString;
        i = -1;
        break;
      }
    }
  }
  
  public RecentUser a(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramString != null) && (paramString.length() <= 2)) {}
    RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramInt));
    if (localRecentUser == null)
    {
      paramString = new RecentUser(paramString, paramInt);
      paramString.displayName = paramString.uin;
      paramString.parse();
      a(paramString);
    }
    do
    {
      return paramString;
      paramString = localRecentUser;
    } while (localRecentUser.msg != null);
    if (localRecentUser.mIsParsed)
    {
      localRecentUser.reParse();
      return localRecentUser;
    }
    localRecentUser.parse();
    return localRecentUser;
  }
  
  public String a(awbv paramawbv)
  {
    paramawbv = (RecentUser)paramawbv;
    return paramawbv.uin + "&" + paramawbv.getType();
  }
  
  public List<RecentUser> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
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
  
  public List<RecentUser> a(boolean paramBoolean)
  {
    return a(paramBoolean, true);
  }
  
  public List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2, true);
  }
  
  public List<RecentUser> a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        localRecentUser.parse();
        if (a(localRecentUser, paramBoolean2)) {
          localArrayList.add(localRecentUser);
        }
      }
      if (!paramBoolean1) {
        break label132;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.db.Cache.RecentUserCache", 2, "getCacheList is error!", localException);
      }
      return new ArrayList();
    }
    if (paramBoolean3)
    {
      Collections.sort(localException, this.jdField_a_of_type_JavaUtilComparator);
      label132:
      if (!QLog.isColorLevel()) {
        break label197;
      }
      if (localException != null) {
        break label185;
      }
    }
    label185:
    for (int i = 0;; i = localException.size())
    {
      QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getRecentList, size = %s", new Object[] { Integer.valueOf(i) }));
      break label197;
      Collections.sort(localException, this.jdField_b_of_type_JavaUtilComparator);
      break;
    }
    label197:
    return localException;
  }
  
  public void a() {}
  
  public void a(RecentUser paramRecentUser)
  {
    a(paramRecentUser, false);
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((paramRecentUser == null) || (paramRecentUser.getType() < 0) || (paramRecentUser.uin == null) || (paramRecentUser.uin.length() <= 2)) {
      a(paramRecentUser);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramRecentUser.uin + " type " + paramRecentUser.getType() + " msgType " + paramRecentUser.msgType);
      }
    } while (paramRecentUser.getType() == 1036);
    Object localObject1;
    Object localObject2;
    if ((paramRecentUser.getType() == 10007) && (asin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (asil.a()))
    {
      localObject1 = (asil)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358);
      if (((asil)localObject1).b())
      {
        localObject1 = ((asil)localObject1).a();
        localObject2 = a("2747277822", 10007);
        if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject2)) && (localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 1, "addCache ##--10007");
          }
          a(a("2747277822", 1008));
        }
      }
    }
    if (amgl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))
    {
      QLog.d("Q.db.Cache.RecentUserCache", 1, "find save invalid user:" + paramRecentUser.uin + " type:" + paramRecentUser.getType(), new RuntimeException("invalid user"));
      amgl.a(paramRecentUser.uin);
    }
    if ((paramRecentUser.getType() == 1) || (paramRecentUser.getType() == 0))
    {
      boolean bool = afai.a(paramRecentUser.uin, paramRecentUser.getType(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramRecentUser.uin + " type " + paramRecentUser.getType() + " isHidden " + bool + " user.isHiddenChat=" + paramRecentUser.isHiddenChat);
      }
      if (!bool) {
        break label606;
      }
    }
    label606:
    for (int i = 1;; i = 0)
    {
      paramRecentUser.isHiddenChat = i;
      if (paramRecentUser.getType() == 1)
      {
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramRecentUser.uin);
        if (localObject1 != null) {
          paramRecentUser.showUpTime = ((CommonlyUsedTroop)localObject1).addedTimestamp;
        }
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 1) {
        break label866;
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 3000) {
        break label866;
      }
      localObject1 = paramRecentUser;
      if (paramRecentUser.getType() == 7000) {
        break label866;
      }
      if (bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin)) {
        paramRecentUser.setType(1024);
      }
      localObject2 = new ArrayList();
      localObject1 = abot.q;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        int k = localObject1[i];
        if (k != paramRecentUser.getType())
        {
          String str = a(paramRecentUser.uin, k);
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
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
          localObject1 = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((ArrayList)localObject2).get(i));
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
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((ArrayList)localObject2).get(i));
          paramRecentUser = (RecentUser)localObject1;
          continue;
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((ArrayList)localObject2).get(i));
          this.jdField_a_of_type_Amcg.a((awbv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((ArrayList)localObject2).get(i)), 2, 0, null);
        }
      }
    }
    else
    {
      localObject1 = paramRecentUser;
    }
    awwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
    label866:
    a((RecentUser)localObject1);
    if ((((RecentUser)localObject1).getType() == 7220) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(localObject1)))
    {
      paramRecentUser = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      if (paramRecentUser.a != -1) {
        if (paramRecentUser.a != 1) {
          break label976;
        }
      }
    }
    label976:
    for (long l = System.currentTimeMillis() / 1000L;; l = 0L)
    {
      ((RecentUser)localObject1).showUpTime = l;
      a((awbv)localObject1);
      if ((((RecentUser)localObject1).isHiddenChat != 0) || (!ajfw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break;
      }
      try
      {
        c((RecentUser)localObject1, paramBoolean);
        return;
      }
      catch (Throwable paramRecentUser)
      {
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
            b(a(paramString, i));
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int[] arrayOfInt = abot.q;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = a(paramString, k);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
      {
        localObject = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((RecentUser)localObject).uin, ((RecentUser)localObject).getType(), 0);
        }
        ((RecentUser)localObject).setType(k);
        c((awbv)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + a(((RecentUser)localObject).uin) + " type " + ((RecentUser)localObject).getType() + " msgType " + ((RecentUser)localObject).msgType);
        }
      }
      i += 1;
    }
  }
  
  @VisibleForTesting
  protected boolean a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if ((TextUtils.equals(paramRecentUser.uin, aljq.az)) || (TextUtils.equals(paramRecentUser.uin, aljq.ac))) {
      if (!bjxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label106;
      }
    }
    label106:
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((TextUtils.equals(paramRecentUser.uin, aljq.aA)) || (TextUtils.equals(paramRecentUser.uin, aljq.aR)));
          if (!TextUtils.equals(paramRecentUser.uin, aljq.D)) {
            break;
          }
        } while (paramBoolean);
        return true;
        if (!TextUtils.equals(paramRecentUser.uin, aljq.aP)) {
          break;
        }
      } while (!badt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      do
      {
        do
        {
          do
          {
            return true;
            if ((!TextUtils.equals(paramRecentUser.uin, aljq.aR)) && (!TextUtils.equals(paramRecentUser.uin, aljq.aS))) {
              break;
            }
          } while (bjxj.c(paramRecentUser.uin));
          return false;
          if (TextUtils.equals(aljq.H, paramRecentUser.uin)) {
            break;
          }
          if (!TextUtils.equals(aljq.aT, paramRecentUser.uin)) {
            break label185;
          }
        } while (LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser));
        return false;
        if (paramRecentUser.getType() == 1038) {
          return ajbg.a(false);
        }
        if ((paramRecentUser.isHiddenChat == 1) || (TextUtils.equals(aljq.aU, paramRecentUser.uin))) {
          break;
        }
      } while (paramRecentUser.getType() != 10007);
    } while (paramBoolean);
    label185:
    return true;
  }
  
  public boolean a(String paramString)
  {
    paramString = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    return (paramString != null) && (!paramString.isEmpty());
  }
  
  public boolean a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      return (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramInt)) != null;
    }
  }
  
  public RecentUser b(String paramString, int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        paramString = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramInt));
        if (paramString == null) {
          return null;
        }
        if (paramString.msg == null)
        {
          if (paramString.mIsParsed) {
            paramString.reParse();
          }
        }
        else {
          return paramString;
        }
      }
      paramString.parse();
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType, type:" + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType cacheMap  is null");
      }
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (((RecentUser)((Map.Entry)localIterator.next()).getValue()).getType() == paramInt)
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "deleteRecentUserByType remove ru");
          }
        }
      }
    }
  }
  
  public void b(RecentUser paramRecentUser)
  {
    b(paramRecentUser, true);
  }
  
  public void b(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + a(paramRecentUser.uin) + " type " + paramRecentUser.getType() + " msgType " + paramRecentUser.msgType + ",uin = " + paramRecentUser.uin);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.getType(), 0);
    }
    c(paramRecentUser);
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty()) && ((!paramString.containsKey(String.valueOf(7000))) || (paramString.keySet().size() > 1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  protected void d()
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1;
    Object localObject2;
    if (syb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject1 = aljq.ay;
      localObject2 = Integer.toString(150);
      localObject1 = localawbw.a(RecentUser.class, false, "uin!=?", new String[] { localObject1 }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject2);
    }
    Object localObject3;
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject2 = RecentUser.class.getSimpleName();
        localObject1 = localawbw.a(RecentUser.class, (String)localObject2, false, null, null, null, null, "showUpTime desc, lastmsgtime desc", Integer.toString(150));
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
              a(localRecentUser, 2, null);
              continue;
              localObject1 = Integer.toString(150);
              localObject1 = localawbw.a(RecentUser.class, false, "type!=?", new String[] { String.valueOf(10007) }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject1);
              break;
            }
          }
          localawbw.a((String)localObject2);
        }
      }
    }
    label529:
    label547:
    label554:
    for (;;)
    {
      localawbw.a();
      a((List)localObject1);
      Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label529;
          }
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          a((RecentUser)localObject2);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a((awbv)localObject2), localObject2);
          continue;
          localObject1 = new ArrayList(20);
          break;
          if (((List)localObject1).size() <= 149) {
            break label554;
          }
          long l = System.currentTimeMillis();
          try
          {
            localObject2 = new RecentUser().getTableName();
            localObject3 = (RecentUser)((List)localObject1).get(140);
            bool = localawbw.b("delete from " + (String)localObject2 + " where showUpTime < " + ((RecentUser)localObject3).showUpTime + " or showUpTime = " + ((RecentUser)localObject3).showUpTime + " and max(lastmsgtime, lastmsgdrafttime) < " + Math.max(((RecentUser)localObject3).lastmsgtime, ((RecentUser)localObject3).lastmsgdrafttime) + "; ");
            if (!bool) {
              break label547;
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
      g();
      h();
      i();
      return;
    }
  }
  
  public void e()
  {
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ??? = Integer.toString(50);
    Object localObject3 = localawbw.a(RecentUser.class, false, "type=?", new String[] { String.valueOf(10007) }, null, null, "lastmsgtime desc", (String)???);
    int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    if (localObject3 != null) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
          String str = a(localRecentUser);
          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localRecentUser);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "preLoadTinyRecentUser is called. preCount = " + i + ", afterCount = " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
    localObject1.a();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache
 * JD-Core Version:    0.7.0.1
 */