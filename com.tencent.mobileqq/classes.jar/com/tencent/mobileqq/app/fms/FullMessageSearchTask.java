package com.tencent.mobileqq.app.fms;

import android.os.SystemClock;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QueryHistoryParam;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
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

public class FullMessageSearchTask
{
  int jdField_a_of_type_Int = 0;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FullMessageSearchResult jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
  SearchCostStatistics jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics = new SearchCostStatistics();
  SearchListener jdField_a_of_type_ComTencentMobileqqAppFmsSearchListener;
  Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString;
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  volatile int b = 0;
  volatile int c = 0;
  
  FullMessageSearchTask(QQAppInterface paramQQAppInterface, String paramString, SearchListener paramSearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchListener = paramSearchListener;
  }
  
  private Pair<Boolean, Integer> a(String paramString, List<FullMessageSearchResult.SearchResultItem> paramList, RecentUser paramRecentUser, long paramLong, Message paramMessage)
  {
    try
    {
      if (SearchStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser))
      {
        long l1 = SystemClock.uptimeMillis();
        paramString = new QueryHistoryParam(paramRecentUser.uin, paramRecentUser.getType(), paramString, SearchStrategy.jdField_a_of_type_Int, this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramRecentUser.getType()).a(paramString);
        paramString = (FullMessageSearchResult.SearchResultItem)paramString.b;
        long l2 = SystemClock.uptimeMillis();
        if ((this.c != 2) && (this.c != 3))
        {
          SearchCostStatistics localSearchCostStatistics = this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics;
          localSearchCostStatistics.b += 1;
          localSearchCostStatistics = this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics;
          localSearchCostStatistics.jdField_a_of_type_Long += l2 - l1;
          if ((paramString != null) && (((paramString.secondPageList != null) && (paramString.secondPageList.size() > 0)) || ((paramString.secondPageMessageUniseq != null) && (paramString.secondPageMessageUniseq.size() > 0))))
          {
            paramString.user = paramRecentUser;
            paramString.lastMessage = paramMessage;
            paramList.add(paramList.size(), paramString);
          }
        }
        else
        {
          return new Pair(Boolean.valueOf(true), Integer.valueOf(2));
        }
      }
      int i = this.b;
      if ((i == 0) && (SystemClock.uptimeMillis() - paramLong > SearchStrategy.c))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("queryHistroyByUser timeout! ");
          paramString.append(SearchStrategy.c);
          QLog.d("Q.msg.FullMessageSearchTask", 2, paramString.toString());
        }
        return new Pair(Boolean.valueOf(true), Integer.valueOf(3));
      }
      if (SystemClock.uptimeMillis() - paramLong > SearchStrategy.b)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("queryHistroyByUser timeout! ");
          paramString.append(SearchStrategy.b);
          QLog.d("Q.msg.FullMessageSearchTask", 2, paramString.toString());
        }
        return new Pair(Boolean.valueOf(true), Integer.valueOf(3));
      }
      paramString = new Pair(Boolean.valueOf(false), Integer.valueOf(0));
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      label376:
      break label376;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser oom!");
    }
    return new Pair(Boolean.valueOf(true), Integer.valueOf(3));
  }
  
  private FullMessageSearchResult a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startTask ");
      ((StringBuilder)localObject1).append(this);
      QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
    }
    a(paramInt);
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    if ((localObject1 != null) && (((String)localObject1).trim().length() != 0))
    {
      long l = SystemClock.uptimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(false);
      if (localObject1 == null)
      {
        QLog.e("Q.msg.FullMessageSearchTask", 1, "userList is null!");
        return null;
      }
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.getType() != 0) && (localRecentUser.getType() != 1) && (localRecentUser.getType() != 3000)) {
          ((Iterator)localObject2).remove();
        }
      }
      Collections.sort((List)localObject1, new FullMessageSearchTask.1(this));
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject1 != null) {
        localObject1 = ((FriendsManager)localObject1).b();
      } else {
        localObject1 = new ArrayList();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("friends size = ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      localObject1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("discussions size = ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 != null) {
        localObject1 = ((TroopManager)localObject1).b();
      } else {
        localObject1 = new ArrayList();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("troops size = ");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      return a(l);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey key is null!");
    }
    return null;
  }
  
  private FullMessageSearchResult a(long paramLong)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryAllHistroyByKey ,task=");
      ((StringBuilder)localObject1).append(this);
      QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult = new FullMessageSearchResult();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject1 = new RecentUser();
      if ((localObject2 instanceof RecentUser))
      {
        localObject1 = (RecentUser)localObject2;
      }
      else if ((localObject2 instanceof Friends))
      {
        localObject2 = (Friends)localObject2;
        ((RecentUser)localObject1).uin = ((Friends)localObject2).uin;
        ((RecentUser)localObject1).setType(0);
        ((RecentUser)localObject1).displayName = ((Friends)localObject2).getFriendNickWithAlias();
      }
      else if ((localObject2 instanceof DiscussionInfo))
      {
        localObject2 = (DiscussionInfo)localObject2;
        ((RecentUser)localObject1).uin = ((DiscussionInfo)localObject2).uin;
        ((RecentUser)localObject1).setType(3000);
        ((RecentUser)localObject1).displayName = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication(), ((DiscussionInfo)localObject2).uin);
      }
      else if ((localObject2 instanceof TroopInfo))
      {
        localObject2 = (TroopInfo)localObject2;
        ((RecentUser)localObject1).uin = ((TroopInfo)localObject2).troopuin;
        ((RecentUser)localObject1).setType(1);
        ((RecentUser)localObject1).displayName = ((TroopInfo)localObject2).troopname;
      }
      localObject2 = UinTypeUtil.a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
      if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject2))
      {
        this.jdField_a_of_type_JavaUtilSet.add(localObject2);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
        long l;
        if (localObject2 == null) {
          l = 0L;
        } else {
          l = ((Message)localObject2).time;
        }
        ((RecentUser)localObject1).lastmsgtime = l;
        int i = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList.size();
        localObject2 = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList, (RecentUser)localObject1, paramLong, (Message)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_JavaUtilList.size() != i) {
          this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchListener.a(this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult);
        }
        if (((Boolean)((Pair)localObject2).first).booleanValue())
        {
          if (((Integer)((Pair)localObject2).second).intValue() == 3)
          {
            a();
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("finish search scs=");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.toString());
              ((StringBuilder)localObject1).append(",searchType=");
              ((StringBuilder)localObject1).append(this.b);
              ((StringBuilder)localObject1).append(",searchStatus=");
              ((StringBuilder)localObject1).append(this.c);
              ((StringBuilder)localObject1).append(",searchFinFlag=");
              ((StringBuilder)localObject1).append(((Pair)localObject2).second);
              QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Int > 0)
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("queryMessageSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Int));
              localHashMap.put("queryConversationSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.b));
              localHashMap.put("resultSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.c));
              localHashMap.put("keyLength", Integer.toString(this.jdField_a_of_type_JavaLangString.length()));
              StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
              if (this.b == 1) {
                localObject1 = "SearchMessageStatistic";
              } else {
                localObject1 = "RecentSearchStatistic";
              }
              localStatisticCollector.collectPerformance(null, (String)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Long, 0L, localHashMap, null);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_Int = ((Integer)((Pair)localObject2).second).intValue();
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pause ");
          ((StringBuilder)localObject1).append(this);
          QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
          break;
        }
      }
      this.jdField_a_of_type_Int += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryAllHistroyByKey search result=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.toString());
      QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
    }
    if ((this.c != 2) && (this.c != 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult.jdField_a_of_type_Int = 1;
      b(1);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
  }
  
  public FullMessageSearchResult a()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("resume ");
        ((StringBuilder)localObject1).append(this);
        QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.c == 0)
      {
        localObject1 = c();
        return localObject1;
      }
      if ((this.c != 2) && (this.c != 1))
      {
        if (this.c == 3)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
          return localObject1;
        }
        return null;
      }
      this.c = 1;
      this.b = 1;
      Object localObject1 = a(SystemClock.uptimeMillis());
      return localObject1;
    }
    finally {}
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
  
  public FullMessageSearchResult b()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startRecentSearch ");
        ((StringBuilder)localObject1).append(this);
        QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
      }
      if ((this.c != 2) && (this.c != 1))
      {
        if (this.c == 3)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
          return localObject1;
        }
        localObject1 = a(0);
        return localObject1;
      }
      Object localObject1 = a();
      return localObject1;
    }
    finally {}
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
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("finish search scs=");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.toString());
          ((StringBuilder)localObject1).append(",searchType=");
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append(",searchStatus=");
          ((StringBuilder)localObject1).append(this.c);
          ((StringBuilder)localObject1).append(",searchFinFlag=");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Int > 0) && (this.c == 3) && (paramInt == 1))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("queryMessageSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Int));
          localHashMap.put("queryConversationSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.b));
          localHashMap.put("resultSize", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.c));
          localHashMap.put("keyLength", Integer.toString(this.jdField_a_of_type_JavaLangString.length()));
          StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
          if (this.b == 1)
          {
            localObject1 = "SearchMessageStatistic";
            localStatisticCollector.collectPerformance(null, (String)localObject1, true, this.jdField_a_of_type_ComTencentMobileqqAppFmsSearchCostStatistics.jdField_a_of_type_Long, 0L, localHashMap, null);
          }
        }
        else
        {
          return;
        }
      }
      String str = "RecentSearchStatistic";
    }
  }
  
  public FullMessageSearchResult c()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startAllSearch ");
        ((StringBuilder)localObject1).append(this);
        QLog.d("Q.msg.FullMessageSearchTask", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.c == 0)
      {
        localObject1 = a(1);
        return localObject1;
      }
      if ((this.c != 2) && (this.c != 1))
      {
        if (this.c == 3)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult;
          return localObject1;
        }
        return null;
      }
      Object localObject1 = a();
      return localObject1;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.FullMessageSearchTask
 * JD-Core Version:    0.7.0.1
 */