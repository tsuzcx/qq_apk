package com.tencent.mobileqq.app.fms;

import android.os.SystemClock;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import zrx;

public class FullMessageSearchTask
{
  int jdField_a_of_type_Int = 0;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FullMessageSearchResult jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
  SearchCostStatistics jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics = new SearchCostStatistics();
  SearchListener jdField_a_of_type_ComTencentMobileqqAppFmsSearchListener;
  Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  Set jdField_a_of_type_JavaUtilSet = new HashSet();
  volatile int b = 0;
  volatile int c = 0;
  
  FullMessageSearchTask(QQAppInterface paramQQAppInterface, String paramString, SearchListener paramSearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchListener = paramSearchListener;
  }
  
  private Pair a(String paramString, List paramList, RecentUser paramRecentUser, long paramLong, QQMessageFacade.Message paramMessage)
  {
    try
    {
      if (SearchStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser))
      {
        long l1 = SystemClock.uptimeMillis();
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramRecentUser.type).a(paramRecentUser.uin, paramRecentUser.type, paramString, SearchStrategy.jdField_a_of_type_Int, this);
        long l2 = SystemClock.uptimeMillis();
        if ((this.c == 2) || (this.c == 3)) {
          return new Pair(Boolean.valueOf(true), Integer.valueOf(2));
        }
        SearchCostStatistics localSearchCostStatistics = this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics;
        localSearchCostStatistics.b += 1;
        localSearchCostStatistics = this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics;
        localSearchCostStatistics.jdField_a_of_type_Long = (l2 - l1 + localSearchCostStatistics.jdField_a_of_type_Long);
        if ((paramString != null) && (((paramString.secondPageList != null) && (paramString.secondPageList.size() > 0)) || ((paramString.secondPageMessageUniseq != null) && (paramString.secondPageMessageUniseq.size() > 0))))
        {
          paramString.user = paramRecentUser;
          paramString.lastMessage = paramMessage;
          paramList.add(paramList.size(), paramString);
        }
      }
      if ((this.b == 0) && (SystemClock.uptimeMillis() - paramLong > SearchStrategy.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser timeout! " + SearchStrategy.c);
        }
        paramString = new Pair(Boolean.valueOf(true), Integer.valueOf(3));
        return paramString;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser oom!");
      }
      return new Pair(Boolean.valueOf(true), Integer.valueOf(3));
    }
    if (SystemClock.uptimeMillis() - paramLong > SearchStrategy.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser timeout! " + SearchStrategy.b);
      }
      return new Pair(Boolean.valueOf(true), Integer.valueOf(3));
    }
    paramString = new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    return paramString;
  }
  
  private FullMessageSearchResult a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearchTask", 2, "startTask " + this);
    }
    a(paramInt);
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.trim().length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey key is null!");
      }
      return null;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if ((localRecentUser.type != 0) && (localRecentUser.type != 1) && (localRecentUser.type != 3000)) {
        localIterator.remove();
      }
    }
    Collections.sort((List)localObject, new zrx(this));
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
    }
    localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "friends size = " + ((List)localObject).size());
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      localObject = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "discussions size = " + ((List)localObject).size());
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject == null) {
        break label425;
      }
    }
    label425:
    for (localObject = ((TroopManager)localObject).a();; localObject = new ArrayList())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "troops size = " + ((List)localObject).size());
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      return a(l);
      localObject = new ArrayList();
      break;
    }
  }
  
  private FullMessageSearchResult a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey ,task=" + this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult = new FullMessageSearchResult();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    Object localObject3;
    Object localObject2;
    label129:
    label331:
    long l;
    StatisticCollector localStatisticCollector;
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject3 = this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject2 = new RecentUser();
      if ((localObject3 instanceof RecentUser))
      {
        localObject1 = (RecentUser)localObject3;
        localObject2 = MsgProxyUtils.a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).type);
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject2)) {
          break label331;
        }
      }
      do
      {
        this.jdField_a_of_type_Int += 1;
        break;
        if ((localObject3 instanceof Friends))
        {
          localObject1 = (Friends)localObject3;
          ((RecentUser)localObject2).uin = ((Friends)localObject1).uin;
          ((RecentUser)localObject2).type = 0;
          ((RecentUser)localObject2).displayName = ((Friends)localObject1).getFriendNickWithAlias();
          localObject1 = localObject2;
          break label129;
        }
        if ((localObject3 instanceof DiscussionInfo))
        {
          localObject1 = (DiscussionInfo)localObject3;
          ((RecentUser)localObject2).uin = ((DiscussionInfo)localObject1).uin;
          ((RecentUser)localObject2).type = 3000;
          ((RecentUser)localObject2).displayName = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication(), ((DiscussionInfo)localObject1).uin);
          localObject1 = localObject2;
          break label129;
        }
        localObject1 = localObject2;
        if (!(localObject3 instanceof TroopInfo)) {
          break label129;
        }
        localObject1 = (TroopInfo)localObject3;
        ((RecentUser)localObject2).uin = ((TroopInfo)localObject1).troopuin;
        ((RecentUser)localObject2).type = 1;
        ((RecentUser)localObject2).displayName = ((TroopInfo)localObject1).troopname;
        localObject1 = localObject2;
        break label129;
        this.jdField_a_of_type_JavaUtilSet.add(localObject2);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((RecentUser)localObject1).uin, ((RecentUser)localObject1).type);
        if (localObject2 != null) {
          break label813;
        }
        l = 0L;
        ((RecentUser)localObject1).lastmsgtime = l;
        int i = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList.size();
        localObject2 = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList, (RecentUser)localObject1, paramLong, (QQMessageFacade.Message)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList.size() != i) {
          this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchListener.a(this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult);
        }
      } while (!((Boolean)((Pair)localObject2).first).booleanValue());
      if (((Integer)((Pair)localObject2).second).intValue() == 3)
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.FullMessageSearchTask", 2, "finish search scs=" + this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.toString() + ",searchType=" + this.b + ",searchStatus=" + this.c + ",searchFinFlag=" + ((Pair)localObject2).second);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Int > 0)
        {
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("queryMessageSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Int));
          ((HashMap)localObject3).put("queryConversationSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.b));
          ((HashMap)localObject3).put("resultSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.c));
          ((HashMap)localObject3).put("keyLength", Integer.toString(this.jdField_a_of_type_JavaLangString.length()));
          localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
          if (this.b != 1) {
            break label823;
          }
        }
      }
    }
    label813:
    label823:
    for (Object localObject1 = "SearchMessageStatistic";; localObject1 = "RecentSearchStatistic")
    {
      localStatisticCollector.a(null, (String)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Long, 0L, (HashMap)localObject3, null);
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_Int = ((Integer)((Pair)localObject2).second).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "pause " + this);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey search result=" + this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.toString());
      }
      if ((this.c != 2) && (this.c != 3))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_Int = 1;
        b(1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
      l = ((QQMessageFacade.Message)localObject2).time;
      break;
    }
  }
  
  /* Error */
  public FullMessageSearchResult a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 139
    //   10: iconst_2
    //   11: new 141	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 406
    //   21: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   38: ifne +12 -> 50
    //   41: aload_0
    //   42: invokevirtual 408	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	()Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: areturn
    //   50: aload_0
    //   51: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   54: iconst_2
    //   55: if_icmpeq +11 -> 66
    //   58: aload_0
    //   59: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   62: iconst_1
    //   63: if_icmpne +24 -> 87
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 35	com/tencent/mobileqq/app/fms/FullMessageSearchTask:b	I
    //   76: aload_0
    //   77: invokestatic 65	android/os/SystemClock:uptimeMillis	()J
    //   80: invokespecial 254	com/tencent/mobileqq/app/fms/FullMessageSearchTask:a	(J)Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   83: astore_1
    //   84: goto -38 -> 46
    //   87: aload_0
    //   88: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   91: iconst_3
    //   92: if_icmpne +11 -> 103
    //   95: aload_0
    //   96: getfield 258	com/tencent/mobileqq/app/fms/FullMessageSearchTask:jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult	Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   99: astore_1
    //   100: goto -54 -> 46
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -59 -> 46
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	FullMessageSearchTask
    //   45	60	1	localFullMessageSearchResult	FullMessageSearchResult
    //   108	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	108	finally
    //   34	46	108	finally
    //   50	66	108	finally
    //   66	84	108	finally
    //   87	100	108	finally
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.c == 1) {
        this.c = 2;
      }
      return;
    }
  }
  
  void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilSet.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult = null;
      this.c = 1;
      this.b = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public FullMessageSearchResult b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 139
    //   10: iconst_2
    //   11: new 141	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 414
    //   21: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   38: iconst_2
    //   39: if_icmpeq +11 -> 50
    //   42: aload_0
    //   43: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   46: iconst_1
    //   47: if_icmpne +12 -> 59
    //   50: aload_0
    //   51: invokevirtual 416	com/tencent/mobileqq/app/fms/FullMessageSearchTask:a	()Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: aload_0
    //   60: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   63: iconst_3
    //   64: if_icmpne +11 -> 75
    //   67: aload_0
    //   68: getfield 258	com/tencent/mobileqq/app/fms/FullMessageSearchTask:jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult	Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   71: astore_1
    //   72: goto -17 -> 55
    //   75: aload_0
    //   76: iconst_0
    //   77: invokespecial 418	com/tencent/mobileqq/app/fms/FullMessageSearchTask:a	(I)Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   80: astore_1
    //   81: goto -26 -> 55
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	FullMessageSearchTask
    //   54	27	1	localFullMessageSearchResult	FullMessageSearchResult
    //   84	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	84	finally
    //   34	50	84	finally
    //   50	55	84	finally
    //   59	72	84	finally
    //   75	81	84	finally
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.c == 3) {
          return;
        }
        if (this.c == 1) {
          this.c = 3;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.FullMessageSearchTask", 2, "finish search scs=" + this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.toString() + ",searchType=" + this.b + ",searchStatus=" + this.c + ",searchFinFlag=" + paramInt);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Int > 0) && (this.c == 3) && (paramInt == 1))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("queryMessageSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Int));
          localHashMap.put("queryConversationSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.b));
          localHashMap.put("resultSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.c));
          localHashMap.put("keyLength", Integer.toString(this.jdField_a_of_type_JavaLangString.length()));
          StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
          if (this.b == 1)
          {
            String str1 = "SearchMessageStatistic";
            localStatisticCollector.a(null, str1, true, this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Long, 0L, localHashMap, null);
          }
        }
        else
        {
          return;
        }
      }
      String str2 = "RecentSearchStatistic";
    }
  }
  
  /* Error */
  public FullMessageSearchResult c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 139
    //   10: iconst_2
    //   11: new 141	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 420
    //   21: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   38: ifne +13 -> 51
    //   41: aload_0
    //   42: iconst_1
    //   43: invokespecial 418	com/tencent/mobileqq/app/fms/FullMessageSearchTask:a	(I)Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aload_0
    //   52: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   55: iconst_2
    //   56: if_icmpeq +11 -> 67
    //   59: aload_0
    //   60: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   63: iconst_1
    //   64: if_icmpne +11 -> 75
    //   67: aload_0
    //   68: invokevirtual 416	com/tencent/mobileqq/app/fms/FullMessageSearchTask:a	()Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   71: astore_1
    //   72: goto -25 -> 47
    //   75: aload_0
    //   76: getfield 37	com/tencent/mobileqq/app/fms/FullMessageSearchTask:c	I
    //   79: iconst_3
    //   80: if_icmpne +11 -> 91
    //   83: aload_0
    //   84: getfield 258	com/tencent/mobileqq/app/fms/FullMessageSearchTask:jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult	Lcom/tencent/mobileqq/app/fms/FullMessageSearchResult;
    //   87: astore_1
    //   88: goto -41 -> 47
    //   91: aconst_null
    //   92: astore_1
    //   93: goto -46 -> 47
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	FullMessageSearchTask
    //   46	47	1	localFullMessageSearchResult	FullMessageSearchResult
    //   96	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	96	finally
    //   34	47	96	finally
    //   51	67	96	finally
    //   67	72	96	finally
    //   75	88	96	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SearchStatus:");
    localStringBuilder.append("key=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",searchConvList.size=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    localStringBuilder.append(",searchIndex=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",SearchType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",SearchStatus=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.FullMessageSearchTask
 * JD-Core Version:    0.7.0.1
 */