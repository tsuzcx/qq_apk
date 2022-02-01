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
  public Map<String, String[]> a = new ConcurrentHashMap();
  public Set<String> b = Collections.synchronizedSet(new HashSet());
  ArrayList<DiscussionInfo> c = new ArrayList();
  private QQAppInterface d;
  private EntityManager e;
  private boolean f = false;
  private ConcurrentHashMap<String, DiscussionInfo> g = new QQConcurrentHashMap(1016, 0, 350);
  private ConcurrentHashMap<String, DiscussionInfo> h = new QQConcurrentHashMap(1022, 0, 350);
  private QQLruCache<String, Map<String, DiscussionMemberInfo>> i = new QQLruCache(2006, 100, 130);
  
  public DiscussionManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    this.e = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = false;
    if (paramInt == 3000)
    {
      DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString, true);
      if (localDiscussionInfo != null)
      {
        if (localDiscussionInfo.isHidden()) {
          return true;
        }
        paramQQAppInterface = localDiscussionManager.b(paramString, paramQQAppInterface.getCurrentAccountUin());
        if (paramQQAppInterface != null)
        {
          if ((paramQQAppInterface.flag & 0x1) == 1) {
            bool = true;
          }
          return bool;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MsgProxyUtils", 2, String.format("isDiscussionFilter, discuss meminfo not find, uin:%s, uinType: %d ", new Object[] { paramString, Integer.valueOf(paramInt) }));
          return false;
        }
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "initDisscussCache begin");
    }
    Object localObject2 = (ArrayList)this.e.query(DiscussionInfo.class, false, null, null, null, null, null, null);
    int k = 0;
    int j;
    if (localObject2 != null) {
      j = ((ArrayList)localObject2).size();
    } else {
      j = 0;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(j);
    Object localObject1;
    if (localObject2 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initDisscussCache disList.size: ");
        ((StringBuilder)localObject1).append(((ArrayList)localObject2).size());
        QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new ArrayList(10);
      j = 0;
      while (j < ((ArrayList)localObject2).size())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((ArrayList)localObject2).get(j);
        localConcurrentHashMap.put(localDiscussionInfo.uin, localDiscussionInfo);
        if (ContactUtils.b(this.d, localDiscussionInfo))
        {
          Map localMap2 = b(localDiscussionInfo.uin);
          if (ContactUtils.a(this.d, localDiscussionInfo.uin, localDiscussionInfo, localMap2, false)) {
            ((ArrayList)localObject1).add(localDiscussionInfo);
          }
        }
        j += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initDisscussCache, updateList=");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
        QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject2).toString());
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = this.e.getTransaction();
        ((EntityTransaction)localObject2).begin();
        j = k;
      }
    }
    try
    {
      try
      {
        while (j < ((ArrayList)localObject1).size())
        {
          a((Entity)((ArrayList)localObject1).get(j));
          j += 1;
        }
      }
      finally
      {
        ((EntityTransaction)localObject2).end();
      }
    }
    catch (Exception localException)
    {
      label330:
      break label330;
    }
    ((EntityTransaction)localObject2).end();
    ((ArrayList)localObject1).clear();
    this.g.putAll(localMap1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initDisscussCache end: ");
      ((StringBuilder)localObject1).append(localMap1.size());
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void e()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("buildDiscussUI, begin, discussList[");
        ((StringBuilder)localObject1).append(this.c.size());
        ((StringBuilder)localObject1).append("], hideDiscussCache[");
        ((StringBuilder)localObject1).append(this.h.size());
        ((StringBuilder)localObject1).append("]");
        QLog.w("Q.contacttab.dscs", 1, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new QQConcurrentHashMap(1022, 0, 350);
      ArrayList localArrayList = new ArrayList();
      if (this.g != null)
      {
        int j = this.g.size();
        if (j > 0)
        {
          localArrayList.ensureCapacity(j);
          Iterator localIterator = this.g.values().iterator();
          while (localIterator.hasNext())
          {
            DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
            if ((localDiscussionInfo.mCompareSpell == null) || (localDiscussionInfo.mCompareSpell.length() == 0)) {
              ContactSorter.a(localDiscussionInfo);
            }
            if (localDiscussionInfo.isHidden()) {
              ((ConcurrentHashMap)localObject1).put(localDiscussionInfo.uin, localDiscussionInfo);
            } else {
              localArrayList.add(localDiscussionInfo);
            }
          }
        }
      }
      try
      {
        this.c = localArrayList;
        this.h = ((ConcurrentHashMap)localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("buildDiscussUI, end, discussList[");
          ((StringBuilder)localObject1).append(this.c.size());
          ((StringBuilder)localObject1).append("], hideDiscussCache[");
          ((StringBuilder)localObject1).append(this.h.size());
          ((StringBuilder)localObject1).append("]");
          QLog.w("Q.contacttab.dscs", 1, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      finally {}
      throw localObject3;
    }
    finally {}
    for (;;) {}
  }
  
  public DiscussionInfo a(String paramString, boolean paramBoolean)
  {
    if (!DiscussionInfo.isValidDisUin(paramString)) {
      return null;
    }
    Object localObject2 = (DiscussionInfo)this.g.get(paramString);
    boolean bool = false;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (!paramBoolean)
      {
        localObject1 = localObject2;
        if (!this.f)
        {
          localObject2 = (DiscussionInfo)this.e.find(DiscussionInfo.class, paramString);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("findDiscussionInfoByID db ");
            if (localObject2 != null) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            ((StringBuilder)localObject1).append(paramBoolean);
            QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            this.g.put(paramString, localObject2);
            localObject1 = localObject2;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("findDiscussionInfoByID, discussionID[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], isDiscussCacheInited[");
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject2).append("], discussionInfo[");
      if (localObject1 != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], hideDiscussCache[");
      paramBoolean = bool;
      if (this.h.get(paramString) != null) {
        paramBoolean = true;
      }
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("]");
      QLog.w("Q.contacttab.dscs", 1, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public DiscussionMemberInfo a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString2 = b(paramString1, paramString2);
      paramString1 = d(paramString1);
      if ((paramString1 != null) && (paramString1.isDiscussHrMeeting())) {
        return paramString2;
      }
      if (paramString2 != null)
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        if ((paramString2.inteRemark == null) || (!paramString2.inteRemark.equals(paramArrayOfByte)))
        {
          paramString2.inteRemark = paramArrayOfByte;
          if (paramArrayOfByte.equals(paramString2.memberName)) {
            paramString2.inteRemarkSource = 129L;
          } else {
            paramString2.inteRemarkSource = 128L;
          }
          if (paramBoolean) {
            a(paramString2);
          }
        }
      }
      return paramString2;
    }
    return null;
  }
  
  public ArrayList<DiscussionMemberInfo> a(String paramString)
  {
    paramString = b(paramString);
    ArrayList localArrayList = new ArrayList();
    if ((paramString != null) && (paramString.size() > 0)) {
      localArrayList.addAll(paramString.values());
    }
    return localArrayList;
  }
  
  public Map<String, ArrayList<DiscussionMemberInfo>> a(String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    int m = paramArrayOfString.length;
    int k = 0;
    int j = 0;
    while (j < m)
    {
      localHashMap.put(paramArrayOfString[j], new ArrayList());
      j += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("discussionUin in (");
    j = 0;
    while (j < paramArrayOfString.length)
    {
      if (j != 0) {
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("?");
      j += 1;
    }
    ((StringBuilder)localObject).append(")");
    String[] arrayOfString = new String[paramArrayOfString.length];
    j = k;
    while (j < arrayOfString.length)
    {
      arrayOfString[j] = SecurityUtile.encode(paramArrayOfString[j]);
      j += 1;
    }
    paramArrayOfString = this.e.query(DiscussionMemberInfo.class, false, ((StringBuilder)localObject).toString(), arrayOfString, "memberUin", null, "memberUin", null);
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
    d();
    e();
    this.f = true;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("saveDiscussInfo ");
      if (paramDiscussionInfo != null) {
        localObject1 = paramDiscussionInfo.uin;
      } else {
        localObject1 = Integer.valueOf(-1);
      }
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramDiscussionInfo == null) {
      return;
    }
    Object localObject1 = this.g;
    if (localObject1 != null) {
      ((ConcurrentHashMap)localObject1).put(paramDiscussionInfo.uin, paramDiscussionInfo);
    }
    a(paramDiscussionInfo);
    localObject1 = this.d.getProxyManager();
    Object localObject2 = ((ProxyManager)localObject1).g().b(paramDiscussionInfo.uin, 3000);
    if (((RecentUser)localObject2).getStatus() == 1001)
    {
      ((RecentUser)localObject2).displayName = paramDiscussionInfo.discussionName;
      ((ProxyManager)localObject1).g().b((RecentUser)localObject2);
    }
    e();
  }
  
  public void a(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    if (paramDiscussionMemberInfo != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveDiscussionMemberInfo ");
        ((StringBuilder)localObject).append(paramDiscussionMemberInfo);
        QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = b(paramDiscussionMemberInfo.discussionUin);
      if (localObject != null) {
        ((Map)localObject).put(paramDiscussionMemberInfo.memberUin, paramDiscussionMemberInfo);
      }
      a(paramDiscussionMemberInfo);
      DiscussionInfo localDiscussionInfo = d(paramDiscussionMemberInfo.discussionUin);
      if ((localDiscussionInfo != null) && (ContactUtils.a(this.d, paramDiscussionMemberInfo.discussionUin, localDiscussionInfo, (Map)localObject, false))) {
        a(localDiscussionInfo);
      }
    }
  }
  
  /* Error */
  public void a(String paramString, DiscussionInfo paramDiscussionInfo, long paramLong1, Map<String, DiscussionMemberInfo> paramMap, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +82 -> 85
    //   6: new 165	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   13: astore 9
    //   15: aload 9
    //   17: ldc_w 419
    //   20: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 9
    //   26: aload_1
    //   27: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 9
    //   33: ldc_w 421
    //   36: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 9
    //   42: aload 5
    //   44: invokeinterface 338 1 0
    //   49: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 9
    //   55: ldc_w 423
    //   58: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 9
    //   64: lload 6
    //   66: invokevirtual 426	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: ldc_w 428
    //   73: iconst_2
    //   74: aload 9
    //   76: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: goto +3 -> 85
    //   85: aload_0
    //   86: getfield 49	com/tencent/mobileqq/app/DiscussionManager:i	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   89: aload_1
    //   90: aload 5
    //   92: invokevirtual 429	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 337	java/util/Map
    //   98: astore 9
    //   100: aload 9
    //   102: ifnull +73 -> 175
    //   105: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +67 -> 175
    //   111: new 165	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   118: astore 10
    //   120: aload 10
    //   122: ldc_w 431
    //   125: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 10
    //   131: aload 9
    //   133: invokeinterface 338 1 0
    //   138: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 10
    //   144: ldc_w 433
    //   147: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 10
    //   153: aload 5
    //   155: invokeinterface 338 1 0
    //   160: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 148
    //   166: iconst_2
    //   167: aload 10
    //   169: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: new 56	java/util/HashSet
    //   178: dup
    //   179: invokespecial 57	java/util/HashSet:<init>	()V
    //   182: astore 10
    //   184: aload_0
    //   185: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   188: invokevirtual 212	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   191: astore 9
    //   193: aload 9
    //   195: invokevirtual 217	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   198: aload 5
    //   200: invokeinterface 437 1 0
    //   205: invokeinterface 440 1 0
    //   210: astore 11
    //   212: aload 11
    //   214: invokeinterface 265 1 0
    //   219: ifeq +140 -> 359
    //   222: aload 11
    //   224: invokeinterface 269 1 0
    //   229: checkcast 442	java/util/Map$Entry
    //   232: invokeinterface 445 1 0
    //   237: checkcast 116	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   240: astore 12
    //   242: new 165	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   249: astore 13
    //   251: aload 13
    //   253: aload 12
    //   255: getfield 372	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   258: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 13
    //   264: ldc_w 447
    //   267: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 13
    //   273: aload 12
    //   275: getfield 416	com/tencent/mobileqq/data/DiscussionMemberInfo:memberUin	Ljava/lang/String;
    //   278: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 13
    //   284: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: astore 12
    //   289: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +40 -> 332
    //   295: new 165	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   302: astore 13
    //   304: aload 13
    //   306: ldc_w 449
    //   309: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 13
    //   315: aload 12
    //   317: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc 148
    //   323: iconst_2
    //   324: aload 13
    //   326: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload 10
    //   334: aload 12
    //   336: invokevirtual 452	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   339: ifne -127 -> 212
    //   342: aload 10
    //   344: aload 12
    //   346: invokevirtual 453	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   349: pop
    //   350: aload_0
    //   351: aload_2
    //   352: invokevirtual 222	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   355: pop
    //   356: goto -144 -> 212
    //   359: aload_0
    //   360: getfield 72	com/tencent/mobileqq/app/DiscussionManager:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   363: invokevirtual 457	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   366: ifnull +87 -> 453
    //   369: aload_0
    //   370: getfield 72	com/tencent/mobileqq/app/DiscussionManager:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   373: invokevirtual 457	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   376: new 116	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   379: dup
    //   380: invokespecial 458	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   383: invokevirtual 461	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   386: ldc_w 463
    //   389: iconst_2
    //   390: anewarray 137	java/lang/String
    //   393: dup
    //   394: iconst_0
    //   395: aload_1
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: lload 6
    //   401: invokestatic 466	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   404: aastore
    //   405: invokevirtual 472	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   408: istore 8
    //   410: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq +40 -> 453
    //   416: new 165	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   423: astore 10
    //   425: aload 10
    //   427: ldc_w 474
    //   430: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 10
    //   436: iload 8
    //   438: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc 148
    //   444: iconst_2
    //   445: aload 10
    //   447: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: aload_0
    //   454: getfield 72	com/tencent/mobileqq/app/DiscussionManager:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   457: aload_1
    //   458: aload_2
    //   459: aload 5
    //   461: iconst_0
    //   462: invokestatic 202	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   465: pop
    //   466: aload_2
    //   467: lload_3
    //   468: putfield 477	com/tencent/mobileqq/data/DiscussionInfo:infoSeq	J
    //   471: aload_0
    //   472: aload_2
    //   473: invokevirtual 478	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   476: aload 9
    //   478: invokevirtual 225	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   481: goto +24 -> 505
    //   484: astore_1
    //   485: goto +26 -> 511
    //   488: astore_1
    //   489: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +13 -> 505
    //   495: ldc 148
    //   497: iconst_2
    //   498: ldc_w 480
    //   501: aload_1
    //   502: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   505: aload 9
    //   507: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   510: return
    //   511: aload 9
    //   513: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   516: goto +5 -> 521
    //   519: aload_1
    //   520: athrow
    //   521: goto -2 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	DiscussionManager
    //   0	524	1	paramString	String
    //   0	524	2	paramDiscussionInfo	DiscussionInfo
    //   0	524	3	paramLong1	long
    //   0	524	5	paramMap	Map<String, DiscussionMemberInfo>
    //   0	524	6	paramLong2	long
    //   408	29	8	j	int
    //   13	499	9	localObject1	Object
    //   118	328	10	localObject2	Object
    //   210	13	11	localIterator	Iterator
    //   240	105	12	localObject3	Object
    //   249	76	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   198	212	484	finally
    //   212	332	484	finally
    //   332	356	484	finally
    //   359	453	484	finally
    //   453	481	484	finally
    //   489	505	484	finally
    //   198	212	488	java/lang/Exception
    //   212	332	488	java/lang/Exception
    //   332	356	488	java/lang/Exception
    //   359	453	488	java/lang/Exception
    //   453	481	488	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("deleteDiscussionMember disUin=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" memberUin=");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2 = (Map)this.i.get(paramString1);
    if (localObject2 != null)
    {
      localObject2 = (DiscussionMemberInfo)((Map)localObject2).remove(paramString2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("removed from cache ");
        ((StringBuilder)localObject1).append(localObject2);
        if (((StringBuilder)localObject1).toString() != null) {
          localObject1 = "true";
        } else {
          localObject1 = "false";
        }
        QLog.d("Q.contacttab.dscs", 2, (String)localObject1);
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (DiscussionMemberInfo)this.e.find(DiscussionMemberInfo.class, new String[] { paramString1, paramString2 });
    }
    if (localObject2 != null)
    {
      this.e.remove((Entity)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "removed from db ");
      }
    }
  }
  
  /* Error */
  public void a(String paramString, Set<String> paramSet)
  {
    // Byte code:
    //   0: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +35 -> 38
    //   6: new 165	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 509
    //   18: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: ldc 148
    //   30: iconst_2
    //   31: aload_3
    //   32: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_1
    //   39: invokestatic 286	com/tencent/mobileqq/data/DiscussionInfo:isValidDisUin	(Ljava/lang/String;)Z
    //   42: ifeq +286 -> 328
    //   45: aload_2
    //   46: ifnull +282 -> 328
    //   49: aload_2
    //   50: invokeinterface 510 1 0
    //   55: ifne +4 -> 59
    //   58: return
    //   59: aload_0
    //   60: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   63: invokevirtual 212	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 217	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 199	com/tencent/mobileqq/app/DiscussionManager:b	(Ljava/lang/String;)Ljava/util/Map;
    //   76: astore 4
    //   78: aload 4
    //   80: ifnull +140 -> 220
    //   83: new 165	java/lang/StringBuilder
    //   86: dup
    //   87: aload_2
    //   88: invokeinterface 510 1 0
    //   93: bipush 8
    //   95: imul
    //   96: invokespecial 511	java/lang/StringBuilder:<init>	(I)V
    //   99: astore 5
    //   101: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +12 -> 116
    //   107: aload 5
    //   109: ldc_w 513
    //   112: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_2
    //   117: invokeinterface 440 1 0
    //   122: astore_2
    //   123: aload_2
    //   124: invokeinterface 265 1 0
    //   129: ifeq +74 -> 203
    //   132: aload_2
    //   133: invokeinterface 269 1 0
    //   138: checkcast 137	java/lang/String
    //   141: astore 6
    //   143: aload 4
    //   145: aload 6
    //   147: invokeinterface 493 2 0
    //   152: checkcast 116	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   155: astore 7
    //   157: aload 7
    //   159: ifnull -36 -> 123
    //   162: aload_0
    //   163: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   166: aload 7
    //   168: invokevirtual 504	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   171: pop
    //   172: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq -52 -> 123
    //   178: aload 5
    //   180: aload 6
    //   182: iconst_0
    //   183: iconst_4
    //   184: invokevirtual 517	java/lang/String:substring	(II)Ljava/lang/String;
    //   187: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 5
    //   193: ldc_w 519
    //   196: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -77 -> 123
    //   203: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +14 -> 220
    //   209: ldc 148
    //   211: iconst_2
    //   212: aload 5
    //   214: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: aload_1
    //   222: invokevirtual 308	com/tencent/mobileqq/app/DiscussionManager:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   225: astore_2
    //   226: aload_0
    //   227: getfield 72	com/tencent/mobileqq/app/DiscussionManager:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   230: aload_1
    //   231: aload_2
    //   232: aload 4
    //   234: iconst_0
    //   235: invokestatic 202	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   238: ifeq +12 -> 250
    //   241: aload_0
    //   242: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   245: aload_2
    //   246: invokevirtual 522	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   249: pop
    //   250: aload_3
    //   251: invokevirtual 225	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   254: aload_3
    //   255: ifnull +62 -> 317
    //   258: goto +55 -> 313
    //   261: astore_1
    //   262: goto +56 -> 318
    //   265: astore_2
    //   266: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +40 -> 309
    //   272: new 165	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   279: astore 4
    //   281: aload 4
    //   283: ldc_w 524
    //   286: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 4
    //   292: aload_1
    //   293: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: ldc 148
    //   299: iconst_2
    //   300: aload 4
    //   302: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: aload_2
    //   306: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   309: aload_3
    //   310: ifnull +7 -> 317
    //   313: aload_3
    //   314: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   317: return
    //   318: aload_3
    //   319: ifnull +7 -> 326
    //   322: aload_3
    //   323: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   326: aload_1
    //   327: athrow
    //   328: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	DiscussionManager
    //   0	329	1	paramString	String
    //   0	329	2	paramSet	Set<String>
    //   13	310	3	localObject1	Object
    //   76	225	4	localObject2	Object
    //   99	114	5	localStringBuilder	StringBuilder
    //   141	40	6	str	String
    //   155	12	7	localDiscussionMemberInfo	DiscussionMemberInfo
    // Exception table:
    //   from	to	target	type
    //   67	78	261	finally
    //   83	116	261	finally
    //   116	123	261	finally
    //   123	157	261	finally
    //   162	200	261	finally
    //   203	220	261	finally
    //   220	250	261	finally
    //   250	254	261	finally
    //   266	309	261	finally
    //   67	78	265	java/lang/Exception
    //   83	116	265	java/lang/Exception
    //   116	123	265	java/lang/Exception
    //   123	157	265	java/lang/Exception
    //   162	200	265	java/lang/Exception
    //   203	220	265	java/lang/Exception
    //   220	250	265	java/lang/Exception
    //   250	254	265	java/lang/Exception
  }
  
  public void a(List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("queryDiscs_");
    ((StringBuilder)localObject).append(paramList.size());
    TraceUtils.traceBegin(((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadData size=");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject).toString());
    }
    if (paramList.size() > 0)
    {
      localObject = new StringBuilder("uin=? ");
      int j = 1;
      while (j < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        j += 1;
      }
      paramList = this.e.query(DiscussionInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (DiscussionInfo)paramList.next();
          this.g.put(((DiscussionInfo)localObject).uin, localObject);
        }
      }
    }
    TraceUtils.traceEnd();
  }
  
  public boolean a(Entity paramEntity)
  {
    int j = paramEntity.getStatus();
    boolean bool = false;
    if (j == 1000)
    {
      this.e.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.e.update(paramEntity);
  }
  
  /* Error */
  boolean a(ArrayList<DiscussionInfo> paramArrayList, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 212	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: astore 7
    //   9: iconst_0
    //   10: istore 6
    //   12: aload 7
    //   14: invokevirtual 217	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   17: aload_1
    //   18: ifnull +118 -> 136
    //   21: aload_1
    //   22: invokevirtual 160	java/util/ArrayList:size	()I
    //   25: ifle +111 -> 136
    //   28: iconst_0
    //   29: istore 5
    //   31: iload 5
    //   33: aload_1
    //   34: invokevirtual 160	java/util/ArrayList:size	()I
    //   37: if_icmpge +99 -> 136
    //   40: aload_1
    //   41: iload 5
    //   43: invokevirtual 183	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   46: checkcast 103	com/tencent/mobileqq/data/DiscussionInfo
    //   49: astore 8
    //   51: aload_0
    //   52: getfield 42	com/tencent/mobileqq/app/DiscussionManager:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   55: aload 8
    //   57: getfield 187	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   60: aload 8
    //   62: invokevirtual 191	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: aload_0
    //   67: aload 8
    //   69: invokevirtual 222	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   72: pop
    //   73: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +261 -> 337
    //   79: new 165	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   86: astore 9
    //   88: aload 9
    //   90: ldc_w 561
    //   93: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 9
    //   99: aload 8
    //   101: getfield 187	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   104: iconst_0
    //   105: iconst_4
    //   106: invokevirtual 517	java/lang/String:substring	(II)Ljava/lang/String;
    //   109: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 9
    //   115: ldc_w 563
    //   118: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc 148
    //   124: iconst_2
    //   125: aload 9
    //   127: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: goto +204 -> 337
    //   136: iload 4
    //   138: ifeq +133 -> 271
    //   141: aload_0
    //   142: getfield 42	com/tencent/mobileqq/app/DiscussionManager:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   145: invokevirtual 564	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   148: invokeinterface 440 1 0
    //   153: astore_1
    //   154: aload_1
    //   155: invokeinterface 265 1 0
    //   160: ifeq +111 -> 271
    //   163: aload_1
    //   164: invokeinterface 269 1 0
    //   169: checkcast 442	java/util/Map$Entry
    //   172: invokeinterface 445 1 0
    //   177: checkcast 103	com/tencent/mobileqq/data/DiscussionInfo
    //   180: astore 8
    //   182: aload 8
    //   184: getfield 567	com/tencent/mobileqq/data/DiscussionInfo:timeSec	J
    //   187: lload_2
    //   188: lcmp
    //   189: ifge -35 -> 154
    //   192: aload_1
    //   193: invokeinterface 569 1 0
    //   198: aload_0
    //   199: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   202: aload 8
    //   204: invokevirtual 504	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   207: pop
    //   208: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq -57 -> 154
    //   214: new 165	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   221: astore 9
    //   223: aload 9
    //   225: ldc_w 561
    //   228: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 9
    //   234: aload 8
    //   236: getfield 187	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   239: iconst_0
    //   240: iconst_4
    //   241: invokevirtual 517	java/lang/String:substring	(II)Ljava/lang/String;
    //   244: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 9
    //   250: ldc_w 571
    //   253: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: ldc 148
    //   259: iconst_2
    //   260: aload 9
    //   262: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: goto -114 -> 154
    //   271: aload 7
    //   273: invokevirtual 225	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   276: aload 7
    //   278: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   281: iconst_1
    //   282: istore 4
    //   284: goto +33 -> 317
    //   287: astore_1
    //   288: goto +36 -> 324
    //   291: astore_1
    //   292: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +13 -> 308
    //   298: ldc 148
    //   300: iconst_2
    //   301: ldc_w 573
    //   304: aload_1
    //   305: invokestatic 575	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload 7
    //   310: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   313: iload 6
    //   315: istore 4
    //   317: aload_0
    //   318: invokespecial 379	com/tencent/mobileqq/app/DiscussionManager:e	()V
    //   321: iload 4
    //   323: ireturn
    //   324: aload 7
    //   326: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   329: goto +5 -> 334
    //   332: aload_1
    //   333: athrow
    //   334: goto -2 -> 332
    //   337: iload 5
    //   339: iconst_1
    //   340: iadd
    //   341: istore 5
    //   343: goto -312 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	DiscussionManager
    //   0	346	1	paramArrayList	ArrayList<DiscussionInfo>
    //   0	346	2	paramLong	long
    //   0	346	4	paramBoolean	boolean
    //   29	313	5	j	int
    //   10	304	6	bool	boolean
    //   7	318	7	localEntityTransaction	EntityTransaction
    //   49	186	8	localDiscussionInfo	DiscussionInfo
    //   86	175	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	17	287	finally
    //   21	28	287	finally
    //   31	133	287	finally
    //   141	154	287	finally
    //   154	268	287	finally
    //   271	276	287	finally
    //   292	308	287	finally
    //   12	17	291	java/lang/Exception
    //   21	28	291	java/lang/Exception
    //   31	133	291	java/lang/Exception
    //   141	154	291	java/lang/Exception
    //   154	268	291	java/lang/Exception
    //   271	276	291	java/lang/Exception
  }
  
  public DiscussionMemberInfo b(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1);
    if (paramString1 != null) {
      return (DiscussionMemberInfo)paramString1.get(paramString2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfo null");
    }
    return null;
  }
  
  public ArrayList<DiscussionInfo> b()
  {
    if (!this.f) {
      a();
    }
    return this.c;
  }
  
  public Map<String, DiscussionMemberInfo> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionMemberInfoListByUin param is null");
      }
      return null;
    }
    Object localObject2 = (Map)this.i.get(paramString);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDiscussionMemberInfoListByUin from map list disUin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" size=");
        int j;
        if (localObject2 == null) {
          j = -1;
        } else {
          j = ((Map)localObject2).size();
        }
        ((StringBuilder)localObject1).append(j);
        QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject1).toString());
        return localObject2;
      }
    }
    else
    {
      localObject2 = this.e.query(DiscussionMemberInfo.class, false, "discussionUin=? ", new String[] { paramString }, null, null, "memberUin", null);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getDiscussionMemberInfoListByUin from DB list is null disUin=");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject1).toString());
        }
        return null;
      }
      localObject1 = new HashMap(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject2).next();
        ((Map)localObject1).put(localDiscussionMemberInfo.memberUin, localDiscussionMemberInfo);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getDiscussionMemberInfoListByUin from db list disUin=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" size=");
        ((StringBuilder)localObject2).append(((Map)localObject1).size());
        QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject2).toString());
      }
      this.i.put(paramString, localObject1);
    }
    return localObject1;
  }
  
  public void b(DiscussionInfo paramDiscussionInfo)
  {
    if (paramDiscussionInfo != null)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
          if (localDiscussionInfo.uin.equals(paramDiscussionInfo.uin)) {
            localDiscussionInfo.hasCollect = paramDiscussionInfo.hasCollect;
          }
        }
      }
    }
  }
  
  /* Error */
  public void b(List<DiscussionMemberInfo> paramList)
  {
    // Byte code:
    //   0: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 148
    //   8: iconst_2
    //   9: ldc_w 608
    //   12: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +277 -> 293
    //   19: aload_1
    //   20: invokeinterface 529 1 0
    //   25: ifne +4 -> 29
    //   28: return
    //   29: aload_1
    //   30: invokeinterface 529 1 0
    //   35: iconst_1
    //   36: if_icmpne +18 -> 54
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_0
    //   42: invokeinterface 609 2 0
    //   47: checkcast 116	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   50: invokevirtual 334	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   53: return
    //   54: new 56	java/util/HashSet
    //   57: dup
    //   58: invokespecial 57	java/util/HashSet:<init>	()V
    //   61: astore 4
    //   63: aload_0
    //   64: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   67: invokevirtual 212	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual 217	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   75: aconst_null
    //   76: astore_2
    //   77: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +11 -> 91
    //   83: new 611	java/lang/StringBuffer
    //   86: dup
    //   87: invokespecial 612	java/lang/StringBuffer:<init>	()V
    //   90: astore_2
    //   91: aload_1
    //   92: invokeinterface 369 1 0
    //   97: astore_1
    //   98: aload_1
    //   99: invokeinterface 265 1 0
    //   104: ifeq +109 -> 213
    //   107: aload_1
    //   108: invokeinterface 269 1 0
    //   113: checkcast 116	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   116: astore 5
    //   118: new 165	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   125: astore 6
    //   127: aload 6
    //   129: aload 5
    //   131: getfield 372	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   134: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 6
    //   140: ldc_w 447
    //   143: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 6
    //   149: aload 5
    //   151: getfield 416	com/tencent/mobileqq/data/DiscussionMemberInfo:memberUin	Ljava/lang/String;
    //   154: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 6
    //   160: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 6
    //   165: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +18 -> 186
    //   171: aload_2
    //   172: aload 6
    //   174: invokevirtual 615	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   177: pop
    //   178: aload_2
    //   179: ldc_w 617
    //   182: invokevirtual 615	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   185: pop
    //   186: aload 4
    //   188: aload 6
    //   190: invokevirtual 452	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   193: ifne -95 -> 98
    //   196: aload_0
    //   197: aload 5
    //   199: invokevirtual 334	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   202: aload 4
    //   204: aload 6
    //   206: invokevirtual 453	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   209: pop
    //   210: goto -112 -> 98
    //   213: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +38 -> 254
    //   219: new 165	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   226: astore_1
    //   227: aload_1
    //   228: ldc_w 619
    //   231: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_1
    //   236: aload_2
    //   237: invokevirtual 620	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   240: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 148
    //   246: iconst_2
    //   247: aload_1
    //   248: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_3
    //   255: invokevirtual 225	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   258: goto +24 -> 282
    //   261: astore_1
    //   262: goto +25 -> 287
    //   265: astore_1
    //   266: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +13 -> 282
    //   272: ldc 148
    //   274: iconst_2
    //   275: ldc_w 622
    //   278: aload_1
    //   279: invokestatic 624	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload_3
    //   283: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   286: return
    //   287: aload_3
    //   288: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   291: aload_1
    //   292: athrow
    //   293: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	DiscussionManager
    //   0	294	1	paramList	List<DiscussionMemberInfo>
    //   76	161	2	localStringBuffer	java.lang.StringBuffer
    //   70	218	3	localEntityTransaction	EntityTransaction
    //   61	142	4	localHashSet	HashSet
    //   116	82	5	localDiscussionMemberInfo	DiscussionMemberInfo
    //   125	80	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	91	261	finally
    //   91	98	261	finally
    //   98	186	261	finally
    //   186	210	261	finally
    //   213	254	261	finally
    //   254	258	261	finally
    //   266	282	261	finally
    //   77	91	265	java/lang/Exception
    //   91	98	265	java/lang/Exception
    //   98	186	265	java/lang/Exception
    //   186	210	265	java/lang/Exception
    //   213	254	265	java/lang/Exception
    //   254	258	265	java/lang/Exception
  }
  
  public int c()
  {
    boolean bool = this.f;
    int k = 0;
    int j = 0;
    if (bool)
    {
      Iterator localIterator = this.c.iterator();
      for (;;)
      {
        k = j;
        if (!localIterator.hasNext()) {
          break;
        }
        if (((DiscussionInfo)localIterator.next()).hasCollect) {
          j += 1;
        }
      }
    }
    return k;
  }
  
  public int c(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.size();
    }
    return 0;
  }
  
  @Nullable
  protected DiscussionInfo c(@NonNull List<AddDiscussMemberInfo> paramList)
  {
    Object localObject = new ArrayList();
    Iterator localIterator1 = this.g.entrySet().iterator();
    for (;;)
    {
      boolean bool = localIterator1.hasNext();
      j = 0;
      if (!bool) {
        break;
      }
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Map.Entry)localIterator1.next()).getValue();
      if (!localDiscussionInfo.isDiscussHrMeeting())
      {
        Map localMap = b(localDiscussionInfo.uin);
        if ((localMap != null) && (paramList.size() + 1 == localMap.size()))
        {
          Iterator localIterator2 = paramList.iterator();
          while (localIterator2.hasNext()) {
            if (!localMap.containsKey(String.valueOf(((AddDiscussMemberInfo)localIterator2.next()).getUin()))) {
              break label154;
            }
          }
          j = 1;
          label154:
          if (j != 0) {
            ((ArrayList)localObject).add(localDiscussionInfo);
          }
        }
      }
    }
    int j = ((ArrayList)localObject).size();
    paramList = null;
    if (j == 0) {
      return null;
    }
    if (((ArrayList)localObject).size() == 1) {
      return (DiscussionInfo)((ArrayList)localObject).get(0);
    }
    long l = 0L;
    localIterator1 = ((ArrayList)localObject).iterator();
    while (localIterator1.hasNext())
    {
      localObject = (DiscussionInfo)localIterator1.next();
      if (((DiscussionInfo)localObject).createTime > l)
      {
        l = ((DiscussionInfo)localObject).createTime;
        paramList = (List<AddDiscussMemberInfo>)localObject;
      }
    }
    return paramList;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    return (ArrayList)this.e.query(DiscussionMemberInfo.class, false, "discussionUin=? and memberUin=?", new String[] { paramString1, paramString2 }, null, null, "memberUin", null) != null;
  }
  
  public DiscussionInfo d(String paramString)
  {
    return a(paramString, false);
  }
  
  /* Error */
  public void d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +49 -> 52
    //   6: new 165	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 649
    //   18: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc_w 651
    //   32: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 148
    //   44: iconst_2
    //   45: aload_3
    //   46: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_1
    //   53: invokestatic 588	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +4 -> 60
    //   59: return
    //   60: aload_0
    //   61: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   64: invokevirtual 212	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 217	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   72: aload_0
    //   73: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   76: ldc 116
    //   78: iconst_0
    //   79: ldc_w 653
    //   82: iconst_1
    //   83: anewarray 137	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: aconst_null
    //   91: aconst_null
    //   92: ldc_w 366
    //   95: aconst_null
    //   96: invokevirtual 156	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   99: checkcast 67	java/util/ArrayList
    //   102: astore 4
    //   104: aload 4
    //   106: ifnull +152 -> 258
    //   109: aload 4
    //   111: invokevirtual 160	java/util/ArrayList:size	()I
    //   114: ifle +144 -> 258
    //   117: aload 4
    //   119: invokevirtual 603	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   122: astore 4
    //   124: aload 4
    //   126: invokeinterface 265 1 0
    //   131: ifeq +127 -> 258
    //   134: aload 4
    //   136: invokeinterface 269 1 0
    //   141: checkcast 116	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   144: getfield 372	com/tencent/mobileqq/data/DiscussionMemberInfo:discussionUin	Ljava/lang/String;
    //   147: astore 5
    //   149: aload_0
    //   150: aload 5
    //   152: invokevirtual 308	com/tencent/mobileqq/app/DiscussionManager:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   155: astore 6
    //   157: aload_0
    //   158: aload 5
    //   160: invokevirtual 199	com/tencent/mobileqq/app/DiscussionManager:b	(Ljava/lang/String;)Ljava/util/Map;
    //   163: astore 7
    //   165: aload 7
    //   167: ifnull +45 -> 212
    //   170: aload 7
    //   172: aload_1
    //   173: invokeinterface 373 2 0
    //   178: checkcast 116	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   181: astore 8
    //   183: aload 8
    //   185: ifnull +27 -> 212
    //   188: aload 8
    //   190: aload_2
    //   191: putfield 317	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   194: aload 8
    //   196: ldc2_w 330
    //   199: putfield 329	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   202: aload_0
    //   203: getfield 86	com/tencent/mobileqq/app/DiscussionManager:e	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   206: aload 8
    //   208: invokevirtual 522	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   211: pop
    //   212: aload 6
    //   214: ifnull -90 -> 124
    //   217: aload 6
    //   219: aload 6
    //   221: getfield 656	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   224: ldc2_w 657
    //   227: lor
    //   228: putfield 656	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   231: aload_0
    //   232: getfield 72	com/tencent/mobileqq/app/DiscussionManager:d	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   235: aload 5
    //   237: aload 6
    //   239: aload 7
    //   241: iconst_0
    //   242: invokestatic 202	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;Ljava/util/Map;Z)Z
    //   245: ifeq -121 -> 124
    //   248: aload_0
    //   249: aload 6
    //   251: invokevirtual 222	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   254: pop
    //   255: goto -131 -> 124
    //   258: aload_3
    //   259: invokevirtual 225	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   262: goto +24 -> 286
    //   265: astore_1
    //   266: goto +25 -> 291
    //   269: astore_1
    //   270: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +13 -> 286
    //   276: ldc 148
    //   278: iconst_2
    //   279: ldc_w 660
    //   282: aload_1
    //   283: invokestatic 624	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   286: aload_3
    //   287: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   290: return
    //   291: aload_3
    //   292: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   295: goto +5 -> 300
    //   298: aload_1
    //   299: athrow
    //   300: goto -2 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	DiscussionManager
    //   0	303	1	paramString1	String
    //   0	303	2	paramString2	String
    //   13	279	3	localObject1	Object
    //   102	33	4	localObject2	Object
    //   147	89	5	str	String
    //   155	95	6	localDiscussionInfo	DiscussionInfo
    //   163	77	7	localMap	Map
    //   181	26	8	localDiscussionMemberInfo	DiscussionMemberInfo
    // Exception table:
    //   from	to	target	type
    //   68	104	265	finally
    //   109	124	265	finally
    //   124	165	265	finally
    //   170	183	265	finally
    //   188	212	265	finally
    //   217	255	265	finally
    //   258	262	265	finally
    //   270	286	265	finally
    //   68	104	269	java/lang/Exception
    //   109	124	269	java/lang/Exception
    //   124	165	269	java/lang/Exception
    //   170	183	269	java/lang/Exception
    //   188	212	269	java/lang/Exception
    //   217	255	269	java/lang/Exception
    //   258	262	269	java/lang/Exception
  }
  
  public boolean e(String paramString)
  {
    Object localObject = d(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideDiscuss begin, uin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], info[");
      boolean bool;
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], discussList[");
      localStringBuilder.append(this.c.size());
      localStringBuilder.append("], hideDiscussCache[");
      localStringBuilder.append(this.h.size());
      localStringBuilder.append("]");
      QLog.w("Q.contacttab.dscs", 1, localStringBuilder.toString());
    }
    if (localObject != null) {
      try
      {
        this.h.put(((DiscussionInfo)localObject).uin, localObject);
        this.c.remove(localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("hideDiscuss end, uin[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("], discussList[");
          ((StringBuilder)localObject).append(this.c.size());
          ((StringBuilder)localObject).append("], hideDiscussCache[");
          ((StringBuilder)localObject).append(this.h.size());
          ((StringBuilder)localObject).append("]");
          QLog.w("Q.contacttab.dscs", 1, ((StringBuilder)localObject).toString());
          return true;
        }
      }
      finally {}
    }
    return true;
  }
  
  public boolean f(String paramString)
  {
    DiscussionInfo localDiscussionInfo = d(paramString);
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    Object localObject;
    if (bool1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reShowDiscuss begin, uin[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], info[");
      if (localDiscussionInfo != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("], discussList[");
      ((StringBuilder)localObject).append(this.c.size());
      ((StringBuilder)localObject).append("], hideDiscussCache[");
      ((StringBuilder)localObject).append(this.h.size());
      ((StringBuilder)localObject).append("]");
      QLog.w("Q.contacttab.dscs", 1, ((StringBuilder)localObject).toString());
    }
    if (localDiscussionInfo != null) {}
    for (;;)
    {
      try
      {
        this.h.remove(localDiscussionInfo.uin);
        localObject = this.c.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label360;
        }
        if (((DiscussionInfo)((Iterator)localObject).next()).uin != localDiscussionInfo.uin) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          this.c.add(localDiscussionInfo);
        }
      }
      finally {}
      bool1 = false;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reShowDiscuss end, uin[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], info[");
        if (localDiscussionInfo != null) {
          bool2 = true;
        }
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append("], bExist[");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append("], discussList[");
        ((StringBuilder)localObject).append(this.c.size());
        ((StringBuilder)localObject).append("], hideDiscussCache[");
        ((StringBuilder)localObject).append(this.h.size());
        ((StringBuilder)localObject).append("]");
        QLog.w("Q.contacttab.dscs", 1, ((StringBuilder)localObject).toString());
      }
      return true;
      label360:
      bool1 = false;
    }
  }
  
  public boolean g(String paramString)
  {
    DiscussionInfo localDiscussionInfo = d(paramString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteDiscuss uin=");
      localStringBuilder.append(paramString);
      QLog.d("Q.contacttab.dscs", 2, localStringBuilder.toString());
    }
    if (localDiscussionInfo != null)
    {
      this.g.remove(paramString);
      this.i.remove(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete from DiscussionMemberInfo where discussionUin='");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'");
      paramString = localStringBuilder.toString();
      this.e.execSQL(paramString);
      this.e.remove(localDiscussionInfo);
      e();
    }
    return true;
  }
  
  public ArrayList<String> h(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = a(paramString);
    paramString = localArrayList1;
    if (localArrayList2 != null)
    {
      paramString = localArrayList2.iterator();
      while (paramString.hasNext()) {
        localArrayList1.add(((DiscussionMemberInfo)paramString.next()).memberUin);
      }
      paramString = GroupIconHelper.a(localArrayList1);
    }
    if (paramString.isEmpty()) {
      paramString.add(this.d.getCurrentAccountUin());
    }
    return paramString;
  }
  
  public void onDestroy()
  {
    this.e.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionManager
 * JD-Core Version:    0.7.0.1
 */