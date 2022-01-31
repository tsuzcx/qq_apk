package com.tencent.mobileqq.app.asyncdb.cache;

import acxd;
import ahay;
import ahca;
import ajed;
import ajwh;
import ajwi;
import ajwl;
import akaq;
import akbh;
import akbm;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import atmo;
import atmp;
import atmq;
import aufl;
import awao;
import awas;
import axfs;
import bcpn;
import bgmq;
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
import rtr;

public class RecentUserCache
  extends ajwi
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  Comparator<atmo> jdField_a_of_type_JavaUtilComparator = new ajwl(true);
  Comparator<atmo> b;
  protected ConcurrentHashMap<String, ConcurrentHashMap<String, atmo>> b;
  private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap(64);
  
  public RecentUserCache(QQAppInterface paramQQAppInterface, ajwh paramajwh)
  {
    super(paramQQAppInterface, paramajwh, RecentUser.class);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(64);
    this.jdField_b_of_type_JavaUtilComparator = new ajwl(false);
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
        if ((localObject1 == null) && (ajed.G.equals(localRecentUser.uin)))
        {
          localObject1 = localRecentUser;
        }
        else if ((localObject2 == null) && ((ajed.D.equals(localRecentUser.uin)) || (4000 == localRecentUser.getType())))
        {
          if ((localRecentUser.msg == null) && (localRecentUser.msgData != null)) {
            localRecentUser.doParse();
          }
          if ((localRecentUser.msg != null) && (!(localRecentUser.msg instanceof String))) {
            localObject2 = localRecentUser;
          }
        }
        else if ((localObject3 == null) && (ajed.S.equals(localRecentUser.uin)))
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
    String str = ahay.a(paramRecentUser.uin, paramRecentUser.getType());
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
  
  private void f()
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
  
  private void g()
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
  
  private void h()
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
        if ((!bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (localRecentUser.getType() == 7220))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove kandian merge");
          }
        }
        if ((bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (((localRecentUser.getType() == 1008) && (TextUtils.equals(localRecentUser.uin, ajed.ay))) || (localRecentUser.getType() == 7210)))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove troop_bar_assist or kandian uin:" + localRecentUser.uin);
          }
        }
      }
    }
  }
  
  public awas a(String paramString, int paramInt)
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
      } while (l - ((RecentUser)localObject).lastmsgtime <= awao.b);
    }
    for (paramInt = localArrayList.indexOf(localObject) + 1;; paramInt = -1)
    {
      if (paramInt == -1) {
        paramInt = localArrayList.size();
      }
      for (;;)
      {
        paramString = new awas();
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
  
  public String a(atmo paramatmo)
  {
    paramatmo = (RecentUser)paramatmo;
    return paramatmo.uin + "&" + paramatmo.getType();
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
    for (;;)
    {
      RecentUser localRecentUser;
      try
      {
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label377;
        }
        localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        localRecentUser.parse();
        if ((TextUtils.equals(localRecentUser.uin, ajed.ay)) || (TextUtils.equals(localRecentUser.uin, ajed.ab)))
        {
          if (!bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label459;
          }
          i = 0;
          if (i == 0) {
            continue;
          }
          localArrayList.add(localRecentUser);
          continue;
        }
        if (!TextUtils.equals(localRecentUser.uin, ajed.az)) {
          break label171;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.db.Cache.RecentUserCache", 2, "getCacheList is error!", localException);
        }
        return new ArrayList();
      }
      int i = 0;
      continue;
      label171:
      if (TextUtils.equals(localRecentUser.uin, ajed.aP))
      {
        i = 0;
      }
      else
      {
        if (TextUtils.equals(localRecentUser.uin, ajed.D))
        {
          if (paramBoolean2) {
            i = 0;
          }
        }
        else
        {
          if (TextUtils.equals(localRecentUser.uin, ajed.aN))
          {
            if (!axfs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              i = 0;
            }
          }
          else if ((TextUtils.equals(localRecentUser.uin, ajed.aP)) || (TextUtils.equals(localRecentUser.uin, ajed.aQ)))
          {
            if (!bgmq.c(localRecentUser.uin)) {
              i = 0;
            }
          }
          else
          {
            if (TextUtils.equals(ajed.H, localRecentUser.uin))
            {
              i = 0;
              continue;
            }
            if (TextUtils.equals(ajed.aR, localRecentUser.uin))
            {
              if (!LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser)) {
                i = 0;
              }
            }
            else
            {
              if (localRecentUser.isHiddenChat == 1)
              {
                i = 0;
                continue;
              }
              if (TextUtils.equals(ajed.aS, localRecentUser.uin))
              {
                i = 0;
                continue;
                label377:
                if (paramBoolean1)
                {
                  if (paramBoolean3) {
                    Collections.sort(localException, this.jdField_a_of_type_JavaUtilComparator);
                  }
                }
                else
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  if (localException != null) {
                    break label447;
                  }
                }
                label447:
                for (i = 0;; i = localException.size())
                {
                  QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getRecentList, size = %s", new Object[] { Integer.valueOf(i) }));
                  break label471;
                  Collections.sort(localException, this.jdField_b_of_type_JavaUtilComparator);
                  break;
                }
              }
            }
          }
          label459:
          i = 1;
          continue;
        }
        i = 1;
      }
    }
    label471:
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
    if (akbh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin, paramRecentUser.getType()))
    {
      QLog.d("Q.db.Cache.RecentUserCache", 1, "find save invalid user:" + paramRecentUser.uin + " type:" + paramRecentUser.getType(), new RuntimeException("invalid user"));
      akbh.a(paramRecentUser.uin);
    }
    if ((paramRecentUser.getType() == 1) || (paramRecentUser.getType() == 0))
    {
      boolean bool = acxd.a(paramRecentUser.uin, paramRecentUser.getType(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "saveRecentUser user: " + paramRecentUser.uin + " type " + paramRecentUser.getType() + " isHidden " + bool + " user.isHiddenChat=" + paramRecentUser.isHiddenChat);
      }
      if (!bool) {
        break label482;
      }
    }
    Object localObject;
    ArrayList localArrayList;
    label482:
    for (int i = 1;; i = 0)
    {
      paramRecentUser.isHiddenChat = i;
      if (paramRecentUser.getType() == 1)
      {
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramRecentUser.uin);
        if (localObject != null) {
          paramRecentUser.showUpTime = ((CommonlyUsedTroop)localObject).addedTimestamp;
        }
      }
      localObject = paramRecentUser;
      if (paramRecentUser.getType() == 1) {
        break label742;
      }
      localObject = paramRecentUser;
      if (paramRecentUser.getType() == 3000) {
        break label742;
      }
      localObject = paramRecentUser;
      if (paramRecentUser.getType() == 7000) {
        break label742;
      }
      if (bcpn.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin)) {
        paramRecentUser.setType(1024);
      }
      localArrayList = new ArrayList();
      localObject = akbm.q;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        int k = localObject[i];
        if (k != paramRecentUser.getType())
        {
          String str = a(paramRecentUser.uin, k);
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
            localArrayList.add(str);
          }
        }
        i += 1;
      }
    }
    int j = localArrayList.size();
    if (j > 0)
    {
      i = 0;
      localObject = paramRecentUser;
      if (i < j)
      {
        if (i == 0)
        {
          localObject = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localArrayList.get(i));
          if (localObject != null) {}
        }
        for (;;)
        {
          i += 1;
          break;
          ((RecentUser)localObject).setType(paramRecentUser.getType());
          ((RecentUser)localObject).displayName = paramRecentUser.displayName;
          ((RecentUser)localObject).lastmsgtime = paramRecentUser.lastmsgtime;
          ((RecentUser)localObject).showUpTime = Math.max(((RecentUser)localObject).showUpTime, paramRecentUser.showUpTime);
          ((RecentUser)localObject).troopUin = paramRecentUser.troopUin;
          ((RecentUser)localObject).lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
          ((RecentUser)localObject).msgData = paramRecentUser.msgData;
          ((RecentUser)localObject).msgType = paramRecentUser.msgType;
          ((RecentUser)localObject).lFlag = paramRecentUser.lFlag;
          ((RecentUser)localObject).isHiddenChat = paramRecentUser.isHiddenChat;
          ((RecentUser)localObject).opTime = Math.max(((RecentUser)localObject).opTime, paramRecentUser.opTime);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localArrayList.get(i));
          paramRecentUser = (RecentUser)localObject;
          continue;
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localArrayList.get(i));
          this.jdField_a_of_type_Ajwh.a((atmo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localArrayList.get(i)), 2, 0, null);
        }
      }
    }
    else
    {
      localObject = paramRecentUser;
    }
    aufl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject).uin, ((RecentUser)localObject).getType());
    label742:
    a((RecentUser)localObject);
    if ((((RecentUser)localObject).getType() == 7220) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(localObject)))
    {
      paramRecentUser = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      if (paramRecentUser.a != -1) {
        if (paramRecentUser.a != 1) {
          break label852;
        }
      }
    }
    label852:
    for (long l = System.currentTimeMillis() / 1000L;; l = 0L)
    {
      ((RecentUser)localObject).showUpTime = l;
      a((atmo)localObject);
      if ((((RecentUser)localObject).isHiddenChat != 0) || (!ahca.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break;
      }
      try
      {
        c((RecentUser)localObject, paramBoolean);
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
    int[] arrayOfInt = akbm.q;
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
        c((atmo)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + a(((RecentUser)localObject).uin) + " type " + ((RecentUser)localObject).getType() + " msgType " + ((RecentUser)localObject).msgType);
        }
      }
      i += 1;
    }
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
    atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1;
    Object localObject2;
    if (rtr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject1 = ajed.ax;
      localObject2 = Integer.toString(150);
      localObject1 = localatmp.a(RecentUser.class, false, "uin!=?", new String[] { localObject1 }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject2);
    }
    Object localObject3;
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject2 = RecentUser.class.getSimpleName();
        localObject1 = localatmp.a(RecentUser.class, (String)localObject2, false, null, null, null, null, "showUpTime desc, lastmsgtime desc", Integer.toString(150));
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
              localObject1 = localatmp.a(RecentUser.class, false, null, null, null, null, "showUpTime desc, lastmsgtime desc", Integer.toString(150));
              break;
            }
          }
          localatmp.a((String)localObject2);
        }
      }
    }
    label529:
    label536:
    for (;;)
    {
      localatmp.a();
      a((List)localObject1);
      Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label511;
          }
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          a((RecentUser)localObject2);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a((atmo)localObject2), localObject2);
          continue;
          localObject1 = new ArrayList(20);
          break;
          if (((List)localObject1).size() <= 149) {
            break label536;
          }
          long l = System.currentTimeMillis();
          try
          {
            localObject2 = new RecentUser().getTableName();
            localObject3 = (RecentUser)((List)localObject1).get(140);
            bool = localatmp.b("delete from " + (String)localObject2 + " where showUpTime < " + ((RecentUser)localObject3).showUpTime + " or showUpTime = " + ((RecentUser)localObject3).showUpTime + " and max(lastmsgtime, lastmsgdrafttime) < " + Math.max(((RecentUser)localObject3).lastmsgtime, ((RecentUser)localObject3).lastmsgdrafttime) + "; ");
            if (!bool) {
              break label529;
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
      label511:
      f();
      g();
      h();
      return;
    }
  }
  
  public void e()
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