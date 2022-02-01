package com.tencent.mobileqq.app;

import QQService.AddDiscussMemberInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
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
import java.util.List<LQQService.AddDiscussMemberInfo;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class DiscussionManager
  implements Manager
{
  private QQLruCache<String, Map<String, DiscussionMemberInfo>> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(2006, 100, 130);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList<DiscussionInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map<String, String[]> a;
  public Set<String> a;
  private ConcurrentHashMap<String, DiscussionInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new QQConcurrentHashMap(1016, 0, 350);
  private boolean jdField_a_of_type_Boolean = false;
  private ConcurrentHashMap<String, DiscussionInfo> b = new QQConcurrentHashMap(1022, 0, 350);
  
  public DiscussionManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 3000)
    {
      DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString, true);
      if ((localDiscussionInfo == null) || (localDiscussionInfo.isHidden())) {
        return true;
      }
      paramQQAppInterface = localDiscussionManager.a(paramString, paramQQAppInterface.getCurrentAccountUin());
      if (paramQQAppInterface != null) {
        return (paramQQAppInterface.flag & 0x1) == 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxyUtils", 2, String.format("isDiscussionFilter, discuss meminfo not find, uin:%s, uinType: %d ", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
    }
    return false;
  }
  
  private void b()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(DiscussionInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(i);
      if (localObject2 == null) {
        break label309;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "initDisscussCache disList.size: " + ((ArrayList)localObject2).size());
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      ((EntityTransaction)localObject2).begin();
      i = j;
    }
    try
    {
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).end();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).end();
    }
    localArrayList.clear();
    label309:
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
            localObject2 = (DiscussionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(DiscussionInfo.class, paramString);
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
  protected DiscussionInfo a(@NonNull List<AddDiscussMemberInfo> paramList)
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
            paramList = (List<AddDiscussMemberInfo>)localObject;
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
  
  public ArrayList<DiscussionInfo> a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList<DiscussionMemberInfo> a(String paramString)
  {
    paramString = a(paramString);
    ArrayList localArrayList = new ArrayList();
    if ((paramString != null) && (paramString.size() > 0)) {
      localArrayList.addAll(paramString.values());
    }
    return localArrayList;
  }
  
  public Map<String, DiscussionMemberInfo> a(String paramString)
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(DiscussionMemberInfo.class, false, "discussionUin=? ", new String[] { paramString }, null, null, "memberUin", null);
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
  
  public Map<String, ArrayList<DiscussionMemberInfo>> a(String[] paramArrayOfString)
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
      arrayOfString[i] = SecurityUtile.encode(paramArrayOfString[i]);
      i += 1;
    }
    paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(DiscussionMemberInfo.class, false, ((StringBuilder)localObject).toString(), arrayOfString, "memberUin", null, "memberUin", null);
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    Object localObject2 = ((ProxyManager)localObject1).a().a(paramDiscussionInfo.uin, 3000);
    if (((RecentUser)localObject2).getStatus() == 1001)
    {
      ((RecentUser)localObject2).displayName = paramDiscussionInfo.discussionName;
      ((ProxyManager)localObject1).a().b((RecentUser)localObject2);
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
  public void a(String paramString, DiscussionInfo paramDiscussionInfo, long paramLong1, Map<String, DiscussionMemberInfo> paramMap, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +57 -> 60
    //   6: ldc_w 481
    //   9: iconst_2
    //   10: new 159	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 483
    //   20: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 485
    //   30: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 5
    //   35: invokeinterface 285 1 0
    //   40: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc_w 487
    //   46: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload 6
    //   51: invokevirtual 490	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_0
    //   61: getfield 42	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   64: aload_1
    //   65: aload 5
    //   67: invokevirtual 417	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 284	java/util/Map
    //   73: astore 9
    //   75: aload 9
    //   77: ifnull +57 -> 134
    //   80: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +51 -> 134
    //   86: ldc 142
    //   88: iconst_2
    //   89: new 159	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 492
    //   99: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 9
    //   104: invokeinterface 285 1 0
    //   109: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 494
    //   115: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 5
    //   120: invokeinterface 285 1 0
    //   125: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: new 49	java/util/HashSet
    //   137: dup
    //   138: invokespecial 50	java/util/HashSet:<init>	()V
    //   141: astore 10
    //   143: aload_0
    //   144: getfield 79	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   147: invokevirtual 206	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   150: astore 9
    //   152: aload 9
    //   154: invokevirtual 211	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   157: aload 5
    //   159: invokeinterface 495 1 0
    //   164: invokeinterface 318 1 0
    //   169: astore 11
    //   171: aload 11
    //   173: invokeinterface 260 1 0
    //   178: ifeq +140 -> 318
    //   181: aload 11
    //   183: invokeinterface 264 1 0
    //   188: checkcast 320	java/util/Map$Entry
    //   191: invokeinterface 323 1 0
    //   196: checkcast 109	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   199: astore 12
    //   201: new 159	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   208: aload 12
    //   210: getfield 437	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   213: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 497
    //   219: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 12
    //   224: getfield 413	com/tencent/mobileqq/data/DiscussionMemberInfo:memberUin	Ljava/lang/String;
    //   227: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore 12
    //   235: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +30 -> 268
    //   241: ldc 142
    //   243: iconst_2
    //   244: new 159	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   251: ldc_w 499
    //   254: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 12
    //   259: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload 10
    //   270: aload 12
    //   272: invokevirtual 502	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   275: ifne -104 -> 171
    //   278: aload 10
    //   280: aload 12
    //   282: invokevirtual 503	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: aload_0
    //   287: aload_2
    //   288: invokevirtual 216	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   291: pop
    //   292: goto -121 -> 171
    //   295: astore_1
    //   296: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +13 -> 312
    //   302: ldc 142
    //   304: iconst_2
    //   305: ldc_w 505
    //   308: aload_1
    //   309: invokestatic 508	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload 9
    //   314: invokevirtual 222	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   317: return
    //   318: aload_0
    //   319: getfield 65	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   322: invokevirtual 512	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   325: ifnull +77 -> 402
    //   328: aload_0
    //   329: getfield 65	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   332: invokevirtual 512	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   335: new 109	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   338: dup
    //   339: invokespecial 513	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   342: invokevirtual 516	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   345: ldc_w 518
    //   348: iconst_2
    //   349: anewarray 130	java/lang/String
    //   352: dup
    //   353: iconst_0
    //   354: aload_1
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: lload 6
    //   360: invokestatic 339	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   363: aastore
    //   364: invokevirtual 524	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   367: istore 8
    //   369: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +30 -> 402
    //   375: ldc 142
    //   377: iconst_2
    //   378: new 159	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 526
    //   388: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: iload 8
    //   393: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_0
    //   403: getfield 65	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   406: aload_1
    //   407: aload_2
    //   408: aload 5
    //   410: iconst_0
    //   411: invokestatic 196	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   414: pop
    //   415: aload_2
    //   416: lload_3
    //   417: putfield 529	com/tencent/mobileqq/data/DiscussionInfo:infoSeq	J
    //   420: aload_0
    //   421: aload_2
    //   422: invokevirtual 530	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   425: aload 9
    //   427: invokevirtual 219	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   430: aload 9
    //   432: invokevirtual 222	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   435: return
    //   436: astore_1
    //   437: aload 9
    //   439: invokevirtual 222	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   442: aload_1
    //   443: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	DiscussionManager
    //   0	444	1	paramString	String
    //   0	444	2	paramDiscussionInfo	DiscussionInfo
    //   0	444	3	paramLong1	long
    //   0	444	5	paramMap	Map<String, DiscussionMemberInfo>
    //   0	444	6	paramLong2	long
    //   367	25	8	i	int
    //   73	365	9	localObject1	Object
    //   141	138	10	localHashSet	HashSet
    //   169	13	11	localIterator	Iterator
    //   199	82	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   157	171	295	java/lang/Exception
    //   171	268	295	java/lang/Exception
    //   268	292	295	java/lang/Exception
    //   318	402	295	java/lang/Exception
    //   402	430	295	java/lang/Exception
    //   157	171	436	finally
    //   171	268	436	finally
    //   268	292	436	finally
    //   296	312	436	finally
    //   318	402	436	finally
    //   402	430	436	finally
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
          break label181;
        }
        localObject1 = "true";
        QLog.d("Q.contacttab.dscs", 2, (String)localObject1);
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (DiscussionMemberInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(DiscussionMemberInfo.class, new String[] { paramString1, paramString2 });
      }
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "removed from db ");
        }
      }
      return;
      label181:
      localObject1 = "false";
      break;
    }
  }
  
  public void a(String paramString, Set<String> paramSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "deleteDiscussionMembers disuin=" + paramString);
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) || (paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      try
      {
        localEntityTransaction.begin();
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
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localDiscussionMemberInfo);
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
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramSet);
        }
        localEntityTransaction.commit();
        return;
      }
      finally
      {
        if (localEntityTransaction != null) {
          localEntityTransaction.end();
        }
      }
    }
  }
  
  public void a(List<String> paramList)
  {
    TraceUtils.traceBegin("queryDiscs_" + paramList.size());
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
      paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(DiscussionInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
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
    TraceUtils.traceEnd();
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
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
    if ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin=?", new String[] { paramString1, paramString2 }, null, null, "memberUin", null) != null) {
      bool = true;
    }
    return bool;
  }
  
  boolean a(ArrayList<DiscussionInfo> paramArrayList, long paramLong, boolean paramBoolean)
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    label298:
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
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
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localDiscussionInfo);
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
        localEntityTransaction.end();
        paramBoolean = false;
        c();
        return paramBoolean;
        localEntityTransaction.commit();
        localEntityTransaction.end();
        paramBoolean = true;
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
  }
  
  public ArrayList<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localArrayList.add(((DiscussionMemberInfo)paramString.next()).memberUin);
      }
    }
    for (paramString = GroupIconHelper.a(localArrayList);; paramString = localArrayList)
    {
      if (paramString.isEmpty()) {
        paramString.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      return paramString;
    }
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
    //   0: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 142
    //   8: iconst_2
    //   9: new 159	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 645
    //   19: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 647
    //   29: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: invokestatic 395	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: getfield 79	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: invokevirtual 206	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 211	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   62: aload_0
    //   63: getfield 79	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: ldc 109
    //   68: iconst_0
    //   69: ldc_w 649
    //   72: iconst_1
    //   73: anewarray 130	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: aconst_null
    //   81: aconst_null
    //   82: ldc_w 406
    //   85: aconst_null
    //   86: invokevirtual 150	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   89: checkcast 60	java/util/ArrayList
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +174 -> 270
    //   99: aload 4
    //   101: invokevirtual 154	java/util/ArrayList:size	()I
    //   104: ifle +166 -> 270
    //   107: aload 4
    //   109: invokevirtual 278	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   112: astore 4
    //   114: aload 4
    //   116: invokeinterface 260 1 0
    //   121: ifeq +149 -> 270
    //   124: aload 4
    //   126: invokeinterface 264 1 0
    //   131: checkcast 109	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   134: getfield 437	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   137: astore 5
    //   139: aload_0
    //   140: aload 5
    //   142: invokevirtual 356	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   145: astore 6
    //   147: aload_0
    //   148: aload 5
    //   150: invokevirtual 193	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Ljava/util/Map;
    //   153: astore 7
    //   155: aload 7
    //   157: ifnull +45 -> 202
    //   160: aload 7
    //   162: aload_1
    //   163: invokeinterface 351 2 0
    //   168: checkcast 109	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   171: astore 8
    //   173: aload 8
    //   175: ifnull +27 -> 202
    //   178: aload 8
    //   180: aload_2
    //   181: putfield 362	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   184: aload 8
    //   186: ldc2_w 377
    //   189: putfield 373	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   192: aload_0
    //   193: getfield 79	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   196: aload 8
    //   198: invokevirtual 570	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   201: pop
    //   202: aload 6
    //   204: ifnull -90 -> 114
    //   207: aload 6
    //   209: aload 6
    //   211: getfield 652	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   214: ldc2_w 653
    //   217: lor
    //   218: putfield 652	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   221: aload_0
    //   222: getfield 65	com/tencent/mobileqq/app/DiscussionManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   225: aload 5
    //   227: aload 6
    //   229: aload 7
    //   231: iconst_0
    //   232: invokestatic 196	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   235: ifeq -121 -> 114
    //   238: aload_0
    //   239: aload 6
    //   241: invokevirtual 216	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   244: pop
    //   245: goto -131 -> 114
    //   248: astore_1
    //   249: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifeq +13 -> 265
    //   255: ldc 142
    //   257: iconst_2
    //   258: ldc_w 656
    //   261: aload_1
    //   262: invokestatic 659	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_3
    //   266: invokevirtual 222	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   269: return
    //   270: aload_3
    //   271: invokevirtual 219	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   274: aload_3
    //   275: invokevirtual 222	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   278: return
    //   279: astore_1
    //   280: aload_3
    //   281: invokevirtual 222	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   284: aload_1
    //   285: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	DiscussionManager
    //   0	286	1	paramString1	String
    //   0	286	2	paramString2	String
    //   57	224	3	localEntityTransaction	EntityTransaction
    //   92	33	4	localObject	Object
    //   137	89	5	str	String
    //   145	95	6	localDiscussionInfo	DiscussionInfo
    //   153	77	7	localMap	Map
    //   171	26	8	localDiscussionMemberInfo	DiscussionMemberInfo
    // Exception table:
    //   from	to	target	type
    //   58	94	248	java/lang/Exception
    //   99	114	248	java/lang/Exception
    //   114	155	248	java/lang/Exception
    //   160	173	248	java/lang/Exception
    //   178	202	248	java/lang/Exception
    //   207	245	248	java/lang/Exception
    //   270	274	248	java/lang/Exception
    //   58	94	279	finally
    //   99	114	279	finally
    //   114	155	279	finally
    //   160	173	279	finally
    //   178	202	279	finally
    //   207	245	279	finally
    //   249	265	279	finally
    //   270	274	279	finally
  }
  
  public void b(List<DiscussionMemberInfo> paramList)
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
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    localEntityTransaction.begin();
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
        localEntityTransaction.commit();
        return;
      }
      finally
      {
        localEntityTransaction.end();
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
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.execSQL(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localDiscussionInfo);
      c();
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionManager
 * JD-Core Version:    0.7.0.1
 */