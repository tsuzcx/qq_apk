package com.tencent.mobileqq.app;

import QQService.AddDiscussMemberInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
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
import mqq.manager.Manager;

public class DiscussionManager
  implements Manager
{
  private QQLruCache jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2006, 100, 130);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map a;
  public Set a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1016, 0, 350);
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap b = new QQConcurrentHashMap(1022, 0, 350);
  
  public DiscussionManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void b()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(i);
      if (localObject2 == null) {
        break label274;
      }
      localArrayList = new ArrayList(10);
      i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((ArrayList)localObject2).get(i);
        localConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
        if (ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDiscussionInfo))
        {
          Map localMap = a(localDiscussionInfo.uin);
          if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDiscussionInfo.uin, localDiscussionInfo, localMap, false)) {
            localArrayList.add(localDiscussionInfo);
          }
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache, updateList=" + localArrayList.size());
    }
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      i = j;
    }
    try
    {
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    label274:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache end: " + localConcurrentHashMap.size());
    }
  }
  
  private void c()
  {
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.dscs", 1, "buildDiscussUI, begin, discussList[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "], hideDiscussCache[" + this.b.size() + "]");
        }
        QQConcurrentHashMap localQQConcurrentHashMap = new QQConcurrentHashMap(1022, 0, 350);
        localArrayList = new ArrayList();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          break;
        }
        int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
        if (i <= 0) {
          break;
        }
        localArrayList.ensureCapacity(i);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
        if ((localDiscussionInfo.mCompareSpell == null) || (localDiscussionInfo.mCompareSpell.length() == 0)) {
          ContactSorter.a(localDiscussionInfo);
        }
        if (localDiscussionInfo.isHidden()) {
          localQQConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
        } else {
          localArrayList.add(localDiscussionInfo);
        }
      }
      finally {}
    }
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      this.b = localObject1;
      if (QLog.isColorLevel()) {
        QLog.w("Q.contacttab.dscs", 1, "buildDiscussUI, end, discussList[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "], hideDiscussCache[" + this.b.size() + "]");
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label52;
      }
      if (!((DiscussionInfo)localIterator.next()).hasCollect) {
        break label54;
      }
      i += 1;
    }
    label52:
    label54:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.size();
    }
    return 0;
  }
  
  public DiscussionInfo a(String paramString)
  {
    return a(paramString, false);
  }
  
  public DiscussionInfo a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    if (!DiscussionInfo.isValidDisUin(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = (DiscussionInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!paramBoolean)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Boolean)
          {
            localObject2 = (DiscussionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, paramString);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("findDiscussionInfoByID db ");
              if (localObject2 == null) {
                break;
              }
              paramBoolean = true;
              QLog.d("Q.contacttab.dscs", 2, paramBoolean);
            }
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
              localObject1 = localObject2;
            }
          }
        }
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    Object localObject2 = new StringBuilder().append("findDiscussionInfoByID, discussionID[").append(paramString).append("], isDiscussCacheInited[").append(this.jdField_a_of_type_Boolean).append("], discussionInfo[");
    if (localObject1 != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localObject2 = ((StringBuilder)localObject2).append(paramBoolean).append("], hideDiscussCache[");
      paramBoolean = bool;
      if (this.b.get(paramString) != null) {
        paramBoolean = true;
      }
      QLog.w("Q.contacttab.dscs", 1, paramBoolean + "]");
      return localObject1;
      paramBoolean = false;
      break;
    }
  }
  
  @Nullable
  protected DiscussionInfo a(@NonNull List paramList)
  {
    Object localObject = new ArrayList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    label242:
    label248:
    for (;;)
    {
      DiscussionInfo localDiscussionInfo;
      if (localIterator1.hasNext())
      {
        localDiscussionInfo = (DiscussionInfo)((Map.Entry)localIterator1.next()).getValue();
        if (!localDiscussionInfo.isDiscussHrMeeting())
        {
          Map localMap = a(localDiscussionInfo.uin);
          if ((localMap != null) && (paramList.size() + 1 == localMap.size()))
          {
            Iterator localIterator2 = paramList.iterator();
            do
            {
              if (!localIterator2.hasNext()) {
                break;
              }
            } while (localMap.containsKey(String.valueOf(((AddDiscussMemberInfo)localIterator2.next()).getUin())));
          }
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label248;
          }
          ((ArrayList)localObject).add(localDiscussionInfo);
          break;
          if (((ArrayList)localObject).size() == 0) {
            return null;
          }
          if (((ArrayList)localObject).size() == 1) {
            return (DiscussionInfo)((ArrayList)localObject).get(0);
          }
          localIterator1 = ((ArrayList)localObject).iterator();
          long l = 0L;
          paramList = null;
          if (localIterator1.hasNext())
          {
            localObject = (DiscussionInfo)localIterator1.next();
            if (((DiscussionInfo)localObject).createTime <= l) {
              break label242;
            }
            l = ((DiscussionInfo)localObject).createTime;
            paramList = (List)localObject;
          }
          for (;;)
          {
            break;
            return paramList;
          }
        }
      }
    }
  }
  
  public DiscussionMemberInfo a(String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = a(paramString1);
    if (paramString1 != null) {
      paramString1 = (DiscussionMemberInfo)paramString1.get(paramString2);
    }
    do
    {
      return paramString1;
      paramString1 = localObject;
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfo null");
    return null;
  }
  
  public DiscussionMemberInfo a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      paramString1 = null;
    }
    do
    {
      do
      {
        DiscussionInfo localDiscussionInfo;
        do
        {
          return paramString1;
          paramString2 = a(paramString1, paramString2);
          localDiscussionInfo = a(paramString1);
          if (localDiscussionInfo == null) {
            break;
          }
          paramString1 = paramString2;
        } while (localDiscussionInfo.isDiscussHrMeeting());
        paramString1 = paramString2;
      } while (paramString2 == null);
      paramArrayOfByte = new String(paramArrayOfByte);
      if (paramString2.inteRemark == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.inteRemark.equals(paramArrayOfByte));
    paramString2.inteRemark = paramArrayOfByte;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.equals(paramString2.memberName))) {}
    for (paramString2.inteRemarkSource = 129L;; paramString2.inteRemarkSource = 128L)
    {
      paramString1 = paramString2;
      if (!paramBoolean) {
        break;
      }
      a(paramString2);
      return paramString2;
    }
  }
  
  public ArrayList a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(String paramString)
  {
    paramString = a(paramString);
    ArrayList localArrayList = new ArrayList();
    if ((paramString != null) && (paramString.size() > 0)) {
      localArrayList.addAll(paramString.values());
    }
    return localArrayList;
  }
  
  public Map a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin param is null");
      }
      return null;
    }
    Object localObject2 = (Map)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("getDiscussionMemberInfoListByUin from map list disUin=").append(paramString).append(" size=");
        if (localObject2 != null) {
          break label101;
        }
        i = -1;
        label82:
        QLog.d("Q.contacttab.dscs", 2, i);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return localObject1;
      label101:
      i = ((Map)localObject2).size();
      break label82;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? ", new String[] { paramString }, null, null, "memberUin", null);
      if (localObject2 == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from DB list is null disUin=" + paramString);
        return null;
      }
      localObject1 = new HashMap(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject2).next();
        ((Map)localObject1).put(localDiscussionMemberInfo.memberUin, localDiscussionMemberInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin from db list disUin=" + paramString + " size=" + ((Map)localObject1).size());
      }
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, localObject1);
    }
  }
  
  public Map a(String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localHashMap.put(paramArrayOfString[i], new ArrayList());
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("discussionUin in (");
    i = 0;
    while (i < paramArrayOfString.length)
    {
      if (i != 0) {
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("?");
      i += 1;
    }
    ((StringBuilder)localObject).append(")");
    String[] arrayOfString = new String[paramArrayOfString.length];
    i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = SecurityUtile.a(paramArrayOfString[i]);
      i += 1;
    }
    paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, ((StringBuilder)localObject).toString(), arrayOfString, "memberUin", null, "memberUin", null);
    if (paramArrayOfString != null)
    {
      paramArrayOfString = paramArrayOfString.iterator();
      while (paramArrayOfString.hasNext())
      {
        localObject = (DiscussionMemberInfo)paramArrayOfString.next();
        ((List)localHashMap.get(((DiscussionMemberInfo)localObject).discussionUin)).add(localObject);
      }
    }
    return localHashMap;
  }
  
  public void a()
  {
    b();
    c();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("saveDiscussInfo ");
      if (paramDiscussionInfo == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject1 = paramDiscussionInfo.uin;; localObject1 = Integer.valueOf(-1))
    {
      QLog.d("Q.contacttab.dscs", 2, localObject1);
      if (paramDiscussionInfo != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDiscussionInfo.uin, paramDiscussionInfo);
    }
    a(paramDiscussionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject2 = ((ProxyManager)localObject1).a().a(paramDiscussionInfo.uin, 3000);
    if (((RecentUser)localObject2).getStatus() == 1001)
    {
      ((RecentUser)localObject2).displayName = paramDiscussionInfo.discussionName;
      ((ProxyManager)localObject1).a().a((RecentUser)localObject2);
    }
    c();
  }
  
  public void a(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    if (paramDiscussionMemberInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfo " + paramDiscussionMemberInfo);
      }
      Map localMap = a(paramDiscussionMemberInfo.discussionUin);
      if (localMap != null) {
        localMap.put(paramDiscussionMemberInfo.memberUin, paramDiscussionMemberInfo);
      }
      a(paramDiscussionMemberInfo);
      DiscussionInfo localDiscussionInfo = a(paramDiscussionMemberInfo.discussionUin);
      if ((localDiscussionInfo != null) && (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionMemberInfo.discussionUin, localDiscussionInfo, localMap, false))) {
        a(localDiscussionInfo);
      }
    }
  }
  
  /* Error */
  public void a(String paramString, DiscussionInfo paramDiscussionInfo, long paramLong1, Map paramMap, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +57 -> 60
    //   6: ldc_w 431
    //   9: iconst_2
    //   10: new 133	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 433
    //   20: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 435
    //   30: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 5
    //   35: invokeinterface 233 1 0
    //   40: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc_w 437
    //   46: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload 6
    //   51: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_0
    //   61: getfield 35	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   64: aload_1
    //   65: aload 5
    //   67: invokevirtual 368	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 232	java/util/Map
    //   73: astore 9
    //   75: aload 9
    //   77: ifnull +57 -> 134
    //   80: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +51 -> 134
    //   86: ldc 83
    //   88: iconst_2
    //   89: new 133	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 442
    //   99: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 9
    //   104: invokeinterface 233 1 0
    //   109: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 444
    //   115: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 5
    //   120: invokeinterface 233 1 0
    //   125: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: new 42	java/util/HashSet
    //   137: dup
    //   138: invokespecial 43	java/util/HashSet:<init>	()V
    //   141: astore 10
    //   143: aload_0
    //   144: getfield 72	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   150: astore 9
    //   152: aload 9
    //   154: invokevirtual 154	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   157: aload 5
    //   159: invokeinterface 445 1 0
    //   164: invokeinterface 268 1 0
    //   169: astore 11
    //   171: aload 11
    //   173: invokeinterface 201 1 0
    //   178: ifeq +141 -> 319
    //   181: aload 11
    //   183: invokeinterface 205 1 0
    //   188: checkcast 270	java/util/Map$Entry
    //   191: invokeinterface 273 1 0
    //   196: checkcast 303	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   199: astore 12
    //   201: new 133	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   208: aload 12
    //   210: getfield 386	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   213: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 447
    //   219: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 12
    //   224: getfield 364	com/tencent/mobileqq/data/DiscussionMemberInfo:memberUin	Ljava/lang/String;
    //   227: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore 13
    //   235: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +30 -> 268
    //   241: ldc 83
    //   243: iconst_2
    //   244: new 133	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   251: ldc_w 449
    //   254: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 13
    //   259: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload 10
    //   270: aload 13
    //   272: invokevirtual 452	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   275: ifne -104 -> 171
    //   278: aload 10
    //   280: aload 13
    //   282: invokevirtual 453	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload_0
    //   287: aload 12
    //   289: invokevirtual 159	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   292: pop
    //   293: goto -122 -> 171
    //   296: astore_1
    //   297: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +13 -> 313
    //   303: ldc 83
    //   305: iconst_2
    //   306: ldc_w 455
    //   309: aload_1
    //   310: invokestatic 458	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: aload 9
    //   315: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   318: return
    //   319: aload_0
    //   320: getfield 58	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   323: invokevirtual 461	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   326: ifnull +77 -> 403
    //   329: aload_0
    //   330: getfield 58	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   333: invokevirtual 461	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   336: new 303	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   339: dup
    //   340: invokespecial 462	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   343: invokevirtual 465	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   346: ldc_w 467
    //   349: iconst_2
    //   350: anewarray 210	java/lang/String
    //   353: dup
    //   354: iconst_0
    //   355: aload_1
    //   356: aastore
    //   357: dup
    //   358: iconst_1
    //   359: lload 6
    //   361: invokestatic 290	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   364: aastore
    //   365: invokevirtual 472	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   368: istore 8
    //   370: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +30 -> 403
    //   376: ldc 83
    //   378: iconst_2
    //   379: new 133	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 474
    //   389: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: iload 8
    //   394: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: aload_0
    //   404: getfield 58	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: aload_1
    //   408: aload_2
    //   409: aload 5
    //   411: iconst_0
    //   412: invokestatic 127	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   415: pop
    //   416: aload_2
    //   417: lload_3
    //   418: putfield 477	com/tencent/mobileqq/data/DiscussionInfo:infoSeq	J
    //   421: aload_0
    //   422: aload_2
    //   423: invokevirtual 478	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   426: aload 9
    //   428: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   431: aload 9
    //   433: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   436: return
    //   437: astore_1
    //   438: aload 9
    //   440: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   443: aload_1
    //   444: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	DiscussionManager
    //   0	445	1	paramString	String
    //   0	445	2	paramDiscussionInfo	DiscussionInfo
    //   0	445	3	paramLong1	long
    //   0	445	5	paramMap	Map
    //   0	445	6	paramLong2	long
    //   368	25	8	i	int
    //   73	366	9	localObject	Object
    //   141	138	10	localHashSet	HashSet
    //   169	13	11	localIterator	Iterator
    //   199	89	12	localDiscussionMemberInfo	DiscussionMemberInfo
    //   233	48	13	str	String
    // Exception table:
    //   from	to	target	type
    //   157	171	296	java/lang/Exception
    //   171	268	296	java/lang/Exception
    //   268	293	296	java/lang/Exception
    //   319	403	296	java/lang/Exception
    //   403	431	296	java/lang/Exception
    //   157	171	437	finally
    //   171	268	437	finally
    //   268	293	437	finally
    //   297	313	437	finally
    //   319	403	437	finally
    //   403	431	437	finally
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMember disUin=" + paramString1 + " memberUin=" + paramString2);
    }
    Object localObject1 = (Map)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString1);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (DiscussionMemberInfo)((Map)localObject1).remove(paramString2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        if ("removed from cache " + localObject2 == null) {
          break label182;
        }
        localObject1 = "true";
        QLog.d("Q.contacttab.dscs", 2, (String)localObject1);
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (DiscussionMemberInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, new String[] { paramString1, paramString2 });
      }
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "removed from db ");
        }
      }
      return;
      label182:
      localObject1 = "false";
      break;
    }
  }
  
  public void a(String paramString, Set paramSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers disuin=" + paramString);
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) || (paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        localMap = a(paramString);
        if (localMap != null)
        {
          localStringBuilder = new StringBuilder(paramSet.size() * 8);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("remove member=");
          }
          paramSet = paramSet.iterator();
          while (paramSet.hasNext())
          {
            String str = (String)paramSet.next();
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localMap.remove(str);
            if (localDiscussionMemberInfo != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionMemberInfo);
              if (QLog.isColorLevel()) {
                localStringBuilder.append(str.substring(0, 4)).append("|");
              }
            }
          }
        }
      }
      catch (Exception paramSet)
      {
        Map localMap;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers exp disUin=" + paramString, paramSet);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, localStringBuilder.toString());
        }
        paramSet = a(paramString);
        if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramSet, localMap, false)) {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramSet);
        }
        localEntityTransaction.c();
        return;
      }
      finally
      {
        if (localEntityTransaction != null) {
          localEntityTransaction.b();
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("queryDiscs_" + paramList.size());
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "preloadData size=" + paramList.size());
    }
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i = 1;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i += 1;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (DiscussionInfo)paramList.next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((DiscussionInfo)localObject).uin, localObject);
        }
      }
    }
    TraceUtils.a();
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    DiscussionInfo localDiscussionInfo = a(paramString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("hideDiscuss begin, uin[").append(paramString).append("], info[");
      if (localDiscussionInfo == null) {
        break label196;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.w("Q.contacttab.dscs", 1, bool + "], discussList[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "], hideDiscussCache[" + this.b.size() + "]");
      if (localDiscussionInfo != null) {}
      label196:
      try
      {
        this.b.put(localDiscussionInfo.uin, localDiscussionInfo);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localDiscussionInfo);
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.dscs", 1, "hideDiscuss end, uin[" + paramString + "], discussList[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "], hideDiscussCache[" + this.b.size() + "]");
        }
        return true;
      }
      finally {}
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    if ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin=?", new String[] { paramString1, paramString2 }, null, null, "memberUin", null) != null) {
      bool = true;
    }
    return bool;
  }
  
  boolean a(ArrayList paramArrayList, long paramLong, boolean paramBoolean)
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    label298:
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        int i;
        DiscussionInfo localDiscussionInfo;
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          i = 0;
          if (i < paramArrayList.size())
          {
            localDiscussionInfo = (DiscussionInfo)paramArrayList.get(i);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
            a(localDiscussionInfo);
            if (!QLog.isColorLevel()) {
              break label298;
            }
            QLog.d("Q.contacttab.dscs", 2, "disUin=" + localDiscussionInfo.uin.substring(0, 4) + " has been updated");
            break label298;
          }
        }
        if (paramBoolean)
        {
          paramArrayList = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          if (paramArrayList.hasNext())
          {
            localDiscussionInfo = (DiscussionInfo)((Map.Entry)paramArrayList.next()).getValue();
            if (localDiscussionInfo.timeSec >= paramLong) {
              continue;
            }
            paramArrayList.remove();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionInfo);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.contacttab.dscs", 2, "disUin=" + localDiscussionInfo.uin.substring(0, 4) + " has been removed");
            continue;
          }
        }
        i += 1;
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.dscs", 2, "saveAllDiscussions exception:", paramArrayList);
        }
        localEntityTransaction.b();
        paramBoolean = false;
        c();
        return paramBoolean;
        localEntityTransaction.c();
        localEntityTransaction.b();
        paramBoolean = true;
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.snapshot().entrySet().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Map)((Map.Entry)localIterator.next()).getValue()).size() + i) {}
    return i;
  }
  
  public ArrayList b(String paramString)
  {
    ArrayList localArrayList = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin<>? ", new String[] { paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, null, null, "memberUin", String.valueOf(5));
    paramString = localArrayList;
    if (localObject != null)
    {
      localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localArrayList.add(((DiscussionMemberInfo)((Iterator)localObject).next()).memberUin);
      }
    }
    return paramString;
  }
  
  public void b(DiscussionInfo paramDiscussionInfo)
  {
    if ((paramDiscussionInfo != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
        if (localDiscussionInfo.uin.equals(paramDiscussionInfo.uin)) {
          localDiscussionInfo.hasCollect = paramDiscussionInfo.hasCollect;
        }
      }
    }
  }
  
  /* Error */
  public void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 83
    //   8: iconst_2
    //   9: new 133	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 585
    //   19: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 587
    //   29: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: invokestatic 346	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: getfield 72	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 154	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   62: aload_0
    //   63: getfield 72	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: ldc_w 303
    //   69: iconst_0
    //   70: ldc_w 589
    //   73: iconst_1
    //   74: anewarray 210	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: aconst_null
    //   82: aconst_null
    //   83: ldc_w 357
    //   86: aconst_null
    //   87: invokevirtual 96	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   90: checkcast 53	java/util/ArrayList
    //   93: astore 4
    //   95: aload 4
    //   97: ifnull +174 -> 271
    //   100: aload 4
    //   102: invokevirtual 100	java/util/ArrayList:size	()I
    //   105: ifle +166 -> 271
    //   108: aload 4
    //   110: invokevirtual 226	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   113: astore 4
    //   115: aload 4
    //   117: invokeinterface 201 1 0
    //   122: ifeq +149 -> 271
    //   125: aload 4
    //   127: invokeinterface 205 1 0
    //   132: checkcast 303	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   135: getfield 386	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   138: astore 5
    //   140: aload_0
    //   141: aload 5
    //   143: invokevirtual 310	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   146: astore 6
    //   148: aload_0
    //   149: aload 5
    //   151: invokevirtual 124	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Ljava/util/Map;
    //   154: astore 7
    //   156: aload 7
    //   158: ifnull +45 -> 203
    //   161: aload 7
    //   163: aload_1
    //   164: invokeinterface 301 2 0
    //   169: checkcast 303	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   172: astore 8
    //   174: aload 8
    //   176: ifnull +27 -> 203
    //   179: aload 8
    //   181: aload_2
    //   182: putfield 316	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   185: aload 8
    //   187: ldc2_w 331
    //   190: putfield 327	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   193: aload_0
    //   194: getfield 72	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   197: aload 8
    //   199: invokevirtual 515	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   202: pop
    //   203: aload 6
    //   205: ifnull -90 -> 115
    //   208: aload 6
    //   210: aload 6
    //   212: getfield 592	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   215: ldc2_w 593
    //   218: lor
    //   219: putfield 592	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   222: aload_0
    //   223: getfield 58	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   226: aload 5
    //   228: aload 6
    //   230: aload 7
    //   232: iconst_0
    //   233: invokestatic 127	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   236: ifeq -121 -> 115
    //   239: aload_0
    //   240: aload 6
    //   242: invokevirtual 159	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   245: pop
    //   246: goto -131 -> 115
    //   249: astore_1
    //   250: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +13 -> 266
    //   256: ldc 83
    //   258: iconst_2
    //   259: ldc_w 596
    //   262: aload_1
    //   263: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload_3
    //   267: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   270: return
    //   271: aload_3
    //   272: invokevirtual 162	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   275: aload_3
    //   276: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   279: return
    //   280: astore_1
    //   281: aload_3
    //   282: invokevirtual 164	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   285: aload_1
    //   286: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	DiscussionManager
    //   0	287	1	paramString1	String
    //   0	287	2	paramString2	String
    //   57	225	3	localEntityTransaction	EntityTransaction
    //   93	33	4	localObject	Object
    //   138	89	5	str	String
    //   146	95	6	localDiscussionInfo	DiscussionInfo
    //   154	77	7	localMap	Map
    //   172	26	8	localDiscussionMemberInfo	DiscussionMemberInfo
    // Exception table:
    //   from	to	target	type
    //   58	95	249	java/lang/Exception
    //   100	115	249	java/lang/Exception
    //   115	156	249	java/lang/Exception
    //   161	174	249	java/lang/Exception
    //   179	203	249	java/lang/Exception
    //   208	246	249	java/lang/Exception
    //   271	275	249	java/lang/Exception
    //   58	95	280	finally
    //   100	115	280	finally
    //   115	156	280	finally
    //   161	174	280	finally
    //   179	203	280	finally
    //   208	246	280	finally
    //   250	266	280	finally
    //   271	275	280	finally
  }
  
  public void b(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList");
    }
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (paramList.size() == 1)
    {
      a((DiscussionMemberInfo)paramList.get(0));
      return;
    }
    HashSet localHashSet = new HashSet();
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    localEntityTransaction.a();
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localStringBuffer = new StringBuffer();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramList.next();
            String str = localDiscussionMemberInfo.discussionUin + "_" + localDiscussionMemberInfo.memberUin;
            if (QLog.isColorLevel())
            {
              localStringBuffer.append(str);
              localStringBuffer.append(";");
            }
            if (localHashSet.contains(str)) {
              continue;
            }
            a(localDiscussionMemberInfo);
            localHashSet.add(str);
            continue;
          }
        }
        StringBuffer localStringBuffer = null;
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList ex=", paramList);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "saveDiscussionMemberInfoList info=" + localStringBuffer.toString());
        }
        localEntityTransaction.c();
        return;
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    DiscussionInfo localDiscussionInfo = a(paramString);
    Object localObject;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("reShowDiscuss begin, uin[").append(paramString).append("], info[");
      if (localDiscussionInfo != null)
      {
        bool1 = true;
        QLog.w("Q.contacttab.dscs", 1, bool1 + "], discussList[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "], hideDiscussCache[" + this.b.size() + "]");
      }
    }
    else
    {
      if (localDiscussionInfo == null) {
        break label293;
      }
    }
    for (;;)
    {
      try
      {
        this.b.remove(localDiscussionInfo.uin);
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label288;
        }
        if (((DiscussionInfo)((Iterator)localObject).next()).uin != localDiscussionInfo.uin) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localDiscussionInfo);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("reShowDiscuss end, uin[").append(paramString).append("], info[");
          if (localDiscussionInfo != null) {
            bool2 = true;
          }
          QLog.w("Q.contacttab.dscs", 1, bool2 + "], bExist[" + bool1 + "], discussList[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "], hideDiscussCache[" + this.b.size() + "]");
        }
        return true;
      }
      finally {}
      bool1 = false;
      break;
      label288:
      bool1 = false;
      continue;
      label293:
      bool1 = false;
    }
  }
  
  public boolean c(String paramString)
  {
    DiscussionInfo localDiscussionInfo = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscuss uin=" + paramString);
    }
    if (localDiscussionInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.remove(paramString);
      paramString = "delete from DiscussionMemberInfo where discussionUin='" + paramString + "'";
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDiscussionInfo);
      c();
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionManager
 * JD-Core Version:    0.7.0.1
 */