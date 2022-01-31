package com.tencent.mobileqq.app.asyncdb.cache;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.RecentConvInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
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
import zwb;
import zwc;
import zwd;
import zwe;
import zwf;

public class RecentUserCache
  extends FullCache
{
  Comparator a;
  Comparator b;
  protected ConcurrentHashMap b;
  
  public RecentUserCache(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, RecentUser.class);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(64);
    this.jdField_a_of_type_JavaUtilComparator = new zwf(true);
    this.jdField_b_of_type_JavaUtilComparator = new zwf(false);
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
  
  private void a(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser != null) {
        if ((localObject1 == null) && (AppConstants.F.equals(localRecentUser.uin)))
        {
          localObject1 = localRecentUser;
        }
        else if ((localObject2 == null) && ((AppConstants.C.equals(localRecentUser.uin)) || (4000 == localRecentUser.type)))
        {
          if ((localRecentUser.msg == null) && (localRecentUser.msgData != null)) {
            localRecentUser.doParse();
          }
          if ((localRecentUser.msg != null) && (!(localRecentUser.msg instanceof String))) {
            localObject2 = localRecentUser;
          }
        }
        else if ((localObject3 == null) && (AppConstants.P.equals(localRecentUser.uin)))
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new zwb(this, l));
    }
  }
  
  private void e()
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
        ThreadManager.getSubThreadHandler().post(new zwc(this, localSharedPreferences));
      } while (!localSharedPreferences.getBoolean("check_newfriend_when_upgrade_V2", true));
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | descRecentList == null");
    return;
    ThreadManager.getSubThreadHandler().post(new zwd(this, localSharedPreferences));
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("pubaccount_assistant_upgrade_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences.getBoolean("check_pubaccountassistant_when_upgrade", true))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | descRecentList == null");
      }
    }
    return;
    label71:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new zwe(this, localSharedPreferences));
  }
  
  private void g()
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
        if ((!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (localRecentUser.type == 7220))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove kandian merge");
          }
        }
        if ((ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (((localRecentUser.type == 1008) && (TextUtils.equals(localRecentUser.uin, AppConstants.as))) || (localRecentUser.type == 7210)))
        {
          localIterator.remove();
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache.RecentUserCache", 2, "remove troop_bar_assist or kandian uin:" + localRecentUser.uin);
          }
        }
      }
    }
  }
  
  public RecentUser a(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramString != null) && (paramString.length() <= 2)) {}
    RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramInt));
    if (localRecentUser == null)
    {
      localRecentUser = new RecentUser();
      localRecentUser.uin = paramString;
      localRecentUser.type = paramInt;
      localRecentUser.displayName = localRecentUser.uin;
      localRecentUser.parse();
      a(localRecentUser);
      paramString = localRecentUser;
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
  
  public MessageCache.RecentConvInfo a(String paramString, int paramInt)
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
      } while (l - ((RecentUser)localObject).lastmsgtime <= MessageCache.b);
    }
    for (paramInt = localArrayList.indexOf(localObject) + 1;; paramInt = -1)
    {
      if (paramInt == -1) {
        paramInt = localArrayList.size();
      }
      for (;;)
      {
        paramString = new MessageCache.RecentConvInfo();
        paramString.a = i;
        paramString.b = paramInt;
        paramString.c = localArrayList.size();
        return paramString;
        i = -1;
        break;
      }
    }
  }
  
  public String a(Entity paramEntity)
  {
    paramEntity = (RecentUser)paramEntity;
    return paramEntity.uin + "&" + paramEntity.type;
  }
  
  public List a(boolean paramBoolean)
  {
    return a(paramBoolean, true);
  }
  
  public List a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2, true);
  }
  
  public List a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      RecentUser localRecentUser;
      try
      {
        ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label262;
        }
        localRecentUser = (RecentUser)((Map.Entry)localIterator.next()).getValue();
        localRecentUser.parse();
        if ((TextUtils.equals(localRecentUser.uin, AppConstants.as)) || (TextUtils.equals(localRecentUser.uin, AppConstants.Y)))
        {
          if (!ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label344;
          }
          i = 0;
          if (i == 0) {
            continue;
          }
          localArrayList.add(localRecentUser);
          continue;
        }
        if (!TextUtils.equals(localRecentUser.uin, AppConstants.at)) {
          break label208;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.db.Cache.RecentUserCache", 2, "getCacheList is error!", localException);
        }
        return new ArrayList();
      }
      if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        if (ReadInJoyHelper.c()) {}
        for (int j = 0;; j = 1)
        {
          i = j;
          if (!ReadInJoyHelper.h()) {
            break;
          }
          i = j;
          if (!paramBoolean2) {
            break;
          }
          i = 0;
          break;
          label208:
          if (TextUtils.equals(localRecentUser.uin, AppConstants.C))
          {
            if (!paramBoolean2) {
              break label362;
            }
            i = 0;
            break;
          }
          if ((TextUtils.equals(localRecentUser.uin, AppConstants.aH)) && (!TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
          {
            i = 0;
            break;
            label262:
            if (paramBoolean1)
            {
              if (paramBoolean3) {
                Collections.sort(localException, this.jdField_a_of_type_JavaUtilComparator);
              }
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label368;
              }
              if (localException != null) {
                break label332;
              }
            }
            label332:
            for (i = 0;; i = localException.size())
            {
              QLog.d("Q.db.Cache.RecentUserCache", 2, String.format("getRecentList, size = %s", new Object[] { Integer.valueOf(i) }));
              break label368;
              Collections.sort(localException, this.jdField_b_of_type_JavaUtilComparator);
              break;
            }
          }
          label344:
          i = 1;
          break;
        }
      }
      int i = 0;
      continue;
      label362:
      i = 1;
    }
    label368:
    return localException;
  }
  
  protected void a() {}
  
  public void a(RecentUser paramRecentUser)
  {
    if ((paramRecentUser == null) || (paramRecentUser.type < 0) || (paramRecentUser.uin == null) || (paramRecentUser.uin.length() <= 2))
    {
      a(paramRecentUser);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "user: " + paramRecentUser.uin + " type " + paramRecentUser.type + " msgType " + paramRecentUser.msgType);
    }
    Object localObject = paramRecentUser;
    if (paramRecentUser.type != 1)
    {
      localObject = paramRecentUser;
      if (paramRecentUser.type != 3000)
      {
        localObject = paramRecentUser;
        if (paramRecentUser.type != 7000)
        {
          if (QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.uin)) {
            paramRecentUser.type = 1024;
          }
          ArrayList localArrayList = new ArrayList();
          localObject = MsgProxyUtils.q;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            int k = localObject[i];
            if (k != paramRecentUser.type)
            {
              String str = a(paramRecentUser.uin, k);
              if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
                localArrayList.add(str);
              }
            }
            i += 1;
          }
          j = localArrayList.size();
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
                ((RecentUser)localObject).type = paramRecentUser.type;
                ((RecentUser)localObject).displayName = paramRecentUser.displayName;
                ((RecentUser)localObject).lastmsgtime = paramRecentUser.lastmsgtime;
                ((RecentUser)localObject).showUpTime = Math.max(((RecentUser)localObject).showUpTime, paramRecentUser.showUpTime);
                ((RecentUser)localObject).troopUin = paramRecentUser.troopUin;
                ((RecentUser)localObject).lastmsgdrafttime = paramRecentUser.lastmsgdrafttime;
                ((RecentUser)localObject).msgData = paramRecentUser.msgData;
                ((RecentUser)localObject).msgType = paramRecentUser.msgType;
                ((RecentUser)localObject).lFlag = paramRecentUser.lFlag;
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localArrayList.get(i));
                paramRecentUser = (RecentUser)localObject;
                continue;
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localArrayList.get(i));
                this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbDBDelayManager.a((Entity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localArrayList.get(i)), 2, 0, null);
              }
            }
          }
          else
          {
            localObject = paramRecentUser;
          }
          QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject).uin, ((RecentUser)localObject).type);
        }
      }
    }
    a((RecentUser)localObject);
    if ((((RecentUser)localObject).type == 7220) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(localObject)))
    {
      paramRecentUser = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
      if (paramRecentUser.a != -1) {
        if (paramRecentUser.a != 1) {
          break label543;
        }
      }
    }
    label543:
    for (long l = System.currentTimeMillis() / 1000L;; l = 0L)
    {
      ((RecentUser)localObject).showUpTime = l;
      a((Entity)localObject);
      return;
    }
  }
  
  public void a(RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + a(paramRecentUser.uin) + " type " + paramRecentUser.type + " msgType " + paramRecentUser.msgType);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type, 0);
    }
    c(paramRecentUser);
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
    int[] arrayOfInt = MsgProxyUtils.q;
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((RecentUser)localObject).uin, ((RecentUser)localObject).type, 0);
        }
        ((RecentUser)localObject).type = k;
        c((Entity)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "delRecentUser user: " + a(((RecentUser)localObject).uin) + " type " + ((RecentUser)localObject).type + " msgType " + ((RecentUser)localObject).msgType);
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
  
  protected void b() {}
  
  public void b(RecentUser paramRecentUser)
  {
    a(paramRecentUser, true);
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
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject1;
    Object localObject2;
    if (PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject1 = AppConstants.ar;
      localObject2 = Integer.toString(150);
      localObject1 = localEntityManager.a(RecentUser.class, false, "uin!=?", new String[] { localObject1 }, null, null, "showUpTime desc, lastmsgtime desc", (String)localObject2);
    }
    Object localObject3;
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject2 = RecentUser.class.getSimpleName();
        localObject1 = localEntityManager.a(RecentUser.class, (String)localObject2, false, null, null, null, null, "showUpTime desc, lastmsgtime desc", Integer.toString(150));
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
              localObject1 = localEntityManager.a(RecentUser.class, false, null, null, null, null, "showUpTime desc, lastmsgtime desc", Integer.toString(150));
              break;
            }
          }
          localEntityManager.a((String)localObject2);
        }
      }
    }
    label529:
    label536:
    for (;;)
    {
      localEntityManager.a();
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
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a((Entity)localObject2), localObject2);
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
            bool = localEntityManager.b("delete from " + (String)localObject2 + " where showUpTime < " + ((RecentUser)localObject3).showUpTime + " or showUpTime = " + ((RecentUser)localObject3).showUpTime + " and max(lastmsgtime, lastmsgdrafttime) < " + Math.max(((RecentUser)localObject3).lastmsgtime, ((RecentUser)localObject3).lastmsgdrafttime) + "; ");
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
      e();
      f();
      g();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache
 * JD-Core Version:    0.7.0.1
 */