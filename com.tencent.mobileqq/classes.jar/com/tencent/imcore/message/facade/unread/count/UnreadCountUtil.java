package com.tencent.imcore.message.facade.unread.count;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.unread.filter.UnreadMsgFilter;
import com.tencent.imcore.message.facade.unread.filter.UnreadMsgFilterProvider;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.ConversationHelper;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class UnreadCountUtil
{
  private static final Provider<List<UnreadMsgFilter>> jdField_a_of_type_ComTencentMobileqqDataEntitymanagerProvider = new UnreadMsgFilterProvider();
  private static String jdField_a_of_type_JavaLangString;
  private static final Provider<List<UnreadCountCalculateStrategy>> b = new UnreadCountProvider();
  
  public static int a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = ((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isNewUnreadCountEnable();
    int i = 0;
    if (!bool)
    {
      Object localObject = paramQQAppInterface.getProxyManager().a().a(false);
      new ConversationHelper(paramQQAppInterface).a((List)localObject);
      ArrayList localArrayList = new ArrayList();
      if (localObject != null) {
        i = ((List)localObject).size();
      } else {
        i = 0;
      }
      ConversationDataFactory.a((List)localObject, paramQQAppInterface, paramContext, localArrayList, i);
      paramContext = localArrayList.iterator();
      i = 0;
      while (paramContext.hasNext())
      {
        localObject = (RecentBaseData)paramContext.next();
        if ((localObject != null) && (((RecentBaseData)localObject).isUnreadMsgNumInTabNum()) && (!RecentAdapter.a(paramQQAppInterface, (RecentBaseData)localObject))) {
          i += ((RecentBaseData)localObject).getUnreadNum();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("UnreadCountUtil", 2, new Object[] { "unreadMsgNew = ", Integer.valueOf(i) });
      }
      return i;
    }
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.b();
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder(168);
    localStringBuilder.append("startTime=[");
    localStringBuilder.append(l);
    localStringBuilder.append("],");
    int i = a(paramQQAppInterface, paramQQMessageFacade, 2);
    if (i != 0) {
      localStringBuilder.append(String.format(Locale.US, "(%s,%d,%d) ", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) }));
    }
    Iterator localIterator = ((List)b.get()).iterator();
    while (localIterator.hasNext()) {
      i += ((UnreadCountCalculateStrategy)localIterator.next()).a(paramQQAppInterface, paramQQMessageFacade, localStringBuilder);
    }
    localStringBuilder.append(",costTime=[");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append("]");
    paramQQAppInterface = localStringBuilder.toString();
    if (!paramQQAppInterface.equals(jdField_a_of_type_JavaLangString))
    {
      paramQQMessageFacade = new StringBuilder();
      paramQQMessageFacade.append("Recent Msg Unread: ");
      paramQQMessageFacade.append(paramQQAppInterface);
      QLog.d("UnreadCountUtil_UnreadMonitor", 1, paramQQMessageFacade.toString());
      jdField_a_of_type_JavaLangString = paramQQAppInterface;
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, int paramInt)
  {
    long l1 = SystemClock.elapsedRealtime();
    Object localObject = paramQQMessageFacade.a();
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      if (((Set)localObject).isEmpty()) {
        return 0;
      }
      StringBuilder localStringBuilder1 = null;
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("getUnreadMsgsNum type=");
        localStringBuilder1.append(paramInt);
        localStringBuilder1.append("{");
        localStringBuilder1 = new StringBuilder(localStringBuilder1.toString());
      }
      StringBuilder localStringBuilder2 = new StringBuilder("getUnreadMsgsNum (uin, type, filterCostTime, getUnreadNumCostTime): ");
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("(");
        localStringBuilder3.append(localConversationInfo.uin);
        localStringBuilder3.append(",");
        localStringBuilder3.append(localConversationInfo.type);
        localStringBuilder2.append(localStringBuilder3.toString());
        if (a(paramQQAppInterface, paramQQMessageFacade, localConversationInfo, localStringBuilder2))
        {
          localStringBuilder2.append(") ");
        }
        else
        {
          long l2 = SystemClock.elapsedRealtime();
          j = paramQQMessageFacade.a(localConversationInfo.type).a(paramInt, localConversationInfo);
          localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append(",");
          localStringBuilder3.append(SystemClock.elapsedRealtime() - l2);
          localStringBuilder3.append("ms) ");
          localStringBuilder2.append(localStringBuilder3.toString());
          if ((QLog.isColorLevel()) && (localStringBuilder1 != null) && (j > 0))
          {
            localStringBuilder3 = new StringBuilder();
            localStringBuilder3.append("[");
            localStringBuilder3.append(localConversationInfo.uin);
            localStringBuilder3.append(",");
            localStringBuilder3.append(localConversationInfo.type);
            localStringBuilder3.append(",");
            localStringBuilder3.append(j);
            localStringBuilder3.append("]");
            localStringBuilder1.append(localStringBuilder3.toString());
          }
          i += a(paramQQAppInterface, localConversationInfo, j);
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder1 != null) && (i > 0))
      {
        localStringBuilder1.append("}");
        QLog.d("UnreadCountUtil", 2, localStringBuilder1.toString());
      }
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("UnreadCountUtil", 2, localStringBuilder2.toString());
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("getUnreadMsgsNum() called with: type = [");
        paramQQAppInterface.append(paramInt);
        paramQQAppInterface.append("], end, costTime = [");
        paramQQAppInterface.append(SystemClock.elapsedRealtime() - l1);
        paramQQAppInterface.append("]ms");
        QLog.d("UnreadCountUtil", 2, paramQQAppInterface.toString());
        j = i;
      }
    }
    return j;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, ConversationInfo paramConversationInfo, int paramInt)
  {
    int i = paramInt;
    if (paramConversationInfo.type == 1008)
    {
      i = paramInt;
      if (paramInt > 0)
      {
        int j = paramQQAppInterface.getConversationFacade().g(paramConversationInfo.uin, 1008);
        i = paramInt;
        if (j > 0) {
          i = paramInt - 1;
        }
        paramInt = i;
        if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramConversationInfo.uin))
        {
          paramInt = i;
          if (j > 0) {
            paramInt = 0;
          }
        }
        i = paramInt;
        if (AppConstants.KANDIAN_DAILY_UIN.equals(paramConversationInfo.uin)) {
          if (j <= 0)
          {
            i = paramInt;
            if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    return i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, ConversationInfo paramConversationInfo, StringBuilder paramStringBuilder)
  {
    Object localObject = (List)jdField_a_of_type_ComTencentMobileqqDataEntitymanagerProvider.get();
    boolean bool2 = false;
    boolean bool3 = false;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      long l = SystemClock.elapsedRealtime();
      localObject = ((List)localObject).iterator();
      UnreadMsgFilter localUnreadMsgFilter;
      do
      {
        bool1 = bool3;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUnreadMsgFilter = (UnreadMsgFilter)((Iterator)localObject).next();
      } while (!localUnreadMsgFilter.a(paramQQAppInterface, paramConversationInfo, paramQQMessageFacade));
      boolean bool1 = localUnreadMsgFilter.b(paramQQAppInterface, paramConversationInfo, paramQQMessageFacade);
      bool2 = bool1;
      if (paramStringBuilder != null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(",");
        paramQQAppInterface.append(SystemClock.elapsedRealtime() - l);
        paramQQAppInterface.append("ms");
        paramStringBuilder.append(paramQQAppInterface.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.UnreadCountUtil
 * JD-Core Version:    0.7.0.1
 */