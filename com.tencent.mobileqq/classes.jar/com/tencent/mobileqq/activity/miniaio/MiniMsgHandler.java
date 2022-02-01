package com.tencent.mobileqq.activity.miniaio;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MiniMsgHandler
  extends BusinessHandler
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected StringBuilder a;
  Comparator<RecentBaseData> jdField_a_of_type_JavaUtilComparator = new MiniMsgHandler.1(this);
  private ConcurrentHashMap<Integer, ArrayList<RecentBaseData>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public MiniMsgHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private List<RecentBaseData> a(List<RecentUser> paramList, List<RecentBaseData> paramList1)
  {
    int j = 0;
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    ArrayList localArrayList = new ArrayList();
    while (j < i)
    {
      RecentUser localRecentUser = (RecentUser)paramList.get(j);
      Object localObject3 = RecentDataListManager.a(localRecentUser.uin, localRecentUser.getType());
      Object localObject2 = RecentDataListManager.a().a((String)localObject3);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = ConversationDataFactory.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          RecentDataListManager.a().a((RecentBaseData)localObject2, (String)localObject3);
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null)
      {
        localObject1.update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        if ((localObject1.getUnreadNum() > 0) && ((localObject1.mUnreadFlag == 1) || (localObject1.mUnreadFlag == 4)))
        {
          int k = localObject1.getRecentUserType();
          if (k == 1)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true).a(localObject1.getRecentUserUin());
            if (localObject2 != null)
            {
              localObject3 = ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a("");
              if ((((HotChatInfo)localObject2).isGameRoom) || (((HotChatInfo)localObject2).troopUin.equals(((WerewolvesPluginManager)localObject3).a))) {}
            }
            else
            {
              localArrayList.add(localObject1);
            }
          }
          else if ((k == 0) || (k == 3000))
          {
            localArrayList.add(localObject1);
          }
        }
        else if ((paramList1 != null) && (paramList1.size() > 0))
        {
          localObject2 = paramList1.iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((RecentBaseData)((Iterator)localObject2).next()).getRecentUserUin().equals(localObject1.getRecentUserUin())) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
      j += 1;
    }
    return localArrayList;
  }
  
  private void a(List<RecentUser> paramList)
  {
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (QLog.isDevelopLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangStringBuilder;
      if (localObject1 == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      } else {
        ((StringBuilder)localObject1).setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, src[");
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentUser)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_JavaLangStringBuilder;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((RecentUser)localObject2).uin);
        ((StringBuilder)localObject4).append("|");
        ((StringBuilder)localObject4).append(((RecentUser)localObject2).getType());
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject3).append(((StringBuilder)localObject4).toString());
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("], [");
    }
    Object localObject1 = null;
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        localObject2 = (RecentUser)paramList.get(i);
        int j = ((RecentUser)localObject2).getType();
        localObject4 = ((RecentUser)localObject2).uin;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramList.remove(i);
          localObject4 = this.jdField_a_of_type_JavaLangStringBuilder;
          localObject3 = localObject1;
          if (localObject4 != null)
          {
            ((StringBuilder)localObject4).append(i);
            ((StringBuilder)localObject4).append(",");
            ((StringBuilder)localObject4).append(((RecentUser)localObject2).getType());
            ((StringBuilder)localObject4).append(";");
            localObject3 = localObject1;
          }
        }
        else if ((j == 1) && ((((RecentUser)localObject2).lFlag & 1L) != 0L))
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = ((QQAppInterface)localObject3).getHotChatMng(true);
            }
          }
          localObject3 = localObject2;
          if (localObject2 != null)
          {
            localObject3 = localObject2;
            if (!((HotChatManager)localObject2).b((String)localObject4))
            {
              paramList.remove(i);
              localObject1 = this.jdField_a_of_type_JavaLangStringBuilder;
              localObject3 = localObject2;
              if (localObject1 != null)
              {
                ((StringBuilder)localObject1).append("invalide hotchat ");
                ((StringBuilder)localObject1).append(i);
                ((StringBuilder)localObject1).append(",");
                ((StringBuilder)localObject1).append((String)localObject4);
                ((StringBuilder)localObject1).append(";");
                localObject3 = localObject2;
              }
            }
          }
        }
        else
        {
          localObject3 = localObject1;
          if (j == 3000)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject3 = localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((DiscussionManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.DISCUSSION_MANAGER)).a((String)localObject4);
              if ((localObject2 != null) && (!((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser()))
              {
                localObject3 = localObject1;
                if (!((DiscussionInfo)localObject2).isHidden()) {}
              }
              else
              {
                paramList.remove(i);
                localObject2 = this.jdField_a_of_type_JavaLangStringBuilder;
                localObject3 = localObject1;
                if (localObject2 != null)
                {
                  ((StringBuilder)localObject2).append("hidden_RecentUser ");
                  ((StringBuilder)localObject2).append(i);
                  ((StringBuilder)localObject2).append(",");
                  ((StringBuilder)localObject2).append((String)localObject4);
                  ((StringBuilder)localObject2).append(";");
                  localObject3 = localObject1;
                }
              }
            }
          }
        }
        i -= 1;
        localObject1 = localObject3;
      }
    }
    paramList = this.jdField_a_of_type_JavaLangStringBuilder;
    if (paramList != null)
    {
      paramList.append("]");
      QLog.i("MiniMsgHandler", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == -2050;
  }
  
  public List<RecentBaseData> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy();
    int i = 0;
    List localList = ((RecentUserProxy)localObject1).a(false);
    Object localObject2 = localArrayList;
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localArrayList;
          localObject3 = new ArrayList();
        }
        localObject2 = localArrayList;
        a(localList);
        if (paramInt2 != 1) {
          break label335;
        }
        localObject4 = localObject3;
        localObject2 = localArrayList;
        localArrayList.addAll(a(localList, localObject4));
        localObject2 = localArrayList;
        Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
        localObject1 = localArrayList;
        localObject2 = localArrayList;
        if (localArrayList.size() > 100)
        {
          localObject2 = localArrayList;
          localObject1 = localArrayList.subList(0, 100);
        }
        localObject2 = localObject1;
        ((ArrayList)localObject3).clear();
        localObject2 = localObject1;
        ((ArrayList)localObject3).addAll((Collection)localObject1);
        localObject2 = localObject1;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject3);
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          localObject3 = new StringBuilder();
          localObject2 = localObject1;
          ((StringBuilder)localObject3).append("initMsgCacheByIndex : resultDataList size = ");
          localObject2 = localObject1;
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          localObject2 = localObject1;
          ((StringBuilder)localObject3).append(",lastDatasize = ");
          if (localObject4 == null)
          {
            paramInt1 = i;
          }
          else
          {
            localObject2 = localObject1;
            paramInt1 = localObject4.size();
          }
          localObject2 = localObject1;
          ((StringBuilder)localObject3).append(paramInt1);
          localObject2 = localObject1;
          QLog.d("MiniMsgHandler", 2, ((StringBuilder)localObject3).toString());
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject3 = localObject2;
      }
      return localObject3;
      label335:
      Object localObject4 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(Integer paramInteger)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramInteger);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 1) || (paramInt1 == 0) || (paramInt1 == 3000)) && (!a(paramInt2)))
    {
      MiniMsgIPCServer.a().a();
      if (!TextUtils.isEmpty(paramString)) {
        MiniMsgIPCServer.a().a(paramString, paramInt1);
      }
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgHandler
 * JD-Core Version:    0.7.0.1
 */