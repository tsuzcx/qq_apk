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
    int i;
    ArrayList localArrayList;
    int j;
    label18:
    Object localObject2;
    Object localObject1;
    int k;
    if (paramList == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label349;
      }
      RecentUser localRecentUser = (RecentUser)paramList.get(j);
      Object localObject3 = RecentDataListManager.a(localRecentUser.uin, localRecentUser.getType());
      localObject2 = RecentDataListManager.a().a((String)localObject3);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = ConversationDataFactory.a(localRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        if (localObject1 != null) {
          RecentDataListManager.a().a((RecentBaseData)localObject1, (String)localObject3);
        }
      }
      if (localObject1 != null)
      {
        ((RecentBaseData)localObject1).update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        if ((((RecentBaseData)localObject1).getUnreadNum() <= 0) || ((((RecentBaseData)localObject1).mUnreadFlag != 1) && (((RecentBaseData)localObject1).mUnreadFlag != 4))) {
          break label281;
        }
        k = ((RecentBaseData)localObject1).getRecentUserType();
        if (k != 1) {
          break label255;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true).a(((RecentBaseData)localObject1).getRecentUserUin());
        if (localObject2 == null) {
          break label242;
        }
        localObject3 = ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a("");
        if ((!((HotChatInfo)localObject2).isGameRoom) && (!((HotChatInfo)localObject2).troopUin.equals(((WerewolvesPluginManager)localObject3).a))) {
          break label242;
        }
      }
    }
    label281:
    for (;;)
    {
      j += 1;
      break label18;
      i = paramList.size();
      break;
      label242:
      localArrayList.add(localObject1);
      continue;
      label255:
      if ((k == 0) || (k == 3000))
      {
        localArrayList.add(localObject1);
        continue;
        if ((paramList1 != null) && (paramList1.size() > 0))
        {
          localObject2 = paramList1.iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((RecentBaseData)((Iterator)localObject2).next()).getRecentUserUin().equals(((RecentBaseData)localObject1).getRecentUserUin())) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    label349:
    return localArrayList;
  }
  
  private void a(List<RecentUser> paramList)
  {
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, src[");
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaLangStringBuilder.append(((RecentUser)localObject2).uin + "|" + ((RecentUser)localObject2).getType() + ",");
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("], [");
    }
    Object localObject1 = null;
    int i;
    int j;
    String str;
    if (paramList != null)
    {
      i = paramList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localObject2 = (RecentUser)paramList.get(i);
          j = ((RecentUser)localObject2).getType();
          str = ((RecentUser)localObject2).uin;
          if (TextUtils.isEmpty(str))
          {
            paramList.remove(i);
            if (this.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              this.jdField_a_of_type_JavaLangStringBuilder.append(i).append(",").append(((RecentUser)localObject2).getType()).append(";");
              i -= 1;
            }
          }
          else if ((j == 1) && ((((RecentUser)localObject2).lFlag & 1L) != 0L))
          {
            if ((localObject1 != null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
              break label484;
            }
          }
        }
      }
    }
    label484:
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject2;
      if (((HotChatManager)localObject2).b(str)) {
        break;
      }
      paramList.remove(i);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangStringBuilder == null) {
        break;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("invalide hotchat ").append(i).append(",").append(str).append(";");
      localObject1 = localObject2;
      break;
      if ((j == 3000) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        localObject2 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(str);
        if ((localObject2 == null) || (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser()) || (((DiscussionInfo)localObject2).isHidden()))
        {
          paramList.remove(i);
          if (this.jdField_a_of_type_JavaLangStringBuilder != null) {
            this.jdField_a_of_type_JavaLangStringBuilder.append("hidden_RecentUser ").append(i).append(",").append(str).append(";");
          }
        }
      }
      break;
      if (this.jdField_a_of_type_JavaLangStringBuilder != null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append("]");
        QLog.i("MiniMsgHandler", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt == -2050) {
      bool = true;
    }
    return bool;
  }
  
  public List<RecentBaseData> a(int paramInt1, int paramInt2)
  {
    Object localObject2 = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().a(false);
    for (;;)
    {
      try
      {
        Object localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          a(localList);
          if (paramInt2 != 1) {
            break label232;
          }
          localObject3 = localObject1;
          ((List)localObject2).addAll(a(localList, localObject3));
          Collections.sort((List)localObject2, this.jdField_a_of_type_JavaUtilComparator);
          if (((List)localObject2).size() > 100)
          {
            localList = ((List)localObject2).subList(0, 100);
            localObject2 = localList;
          }
          continue;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          ((ArrayList)localObject1).clear();
          ((ArrayList)localObject1).addAll((Collection)localObject2);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject1);
          if (!QLog.isColorLevel()) {
            break label229;
          }
          localObject1 = new StringBuilder().append("initMsgCacheByIndex : resultDataList size = ").append(((List)localObject2).size()).append(",lastDatasize = ");
          if (localObject3 == null)
          {
            paramInt1 = 0;
            QLog.d("MiniMsgHandler", 2, paramInt1);
            return localObject2;
          }
          paramInt1 = localObject3.size();
          continue;
          localException1 = localException1;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1.printStackTrace();
        return localObject2;
      }
      continue;
      label229:
      return localObject2;
      label232:
      Object localObject3 = null;
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgHandler
 * JD-Core Version:    0.7.0.1
 */